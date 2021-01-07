package com.baidu.tieba.forumMember.tbtitle.a;

import android.text.SpannableString;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import com.baidu.adp.base.d;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.lib.util.l;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tieba.R;
import com.baidu.tieba.forumMember.tbtitle.TbTitleActivity;
import java.util.List;
import tbclient.GetLevelInfo.DataRes;
import tbclient.LevelInfo;
/* loaded from: classes8.dex */
public class a extends d<TbTitleActivity> {
    private ScrollView cPa;
    private NoNetworkView gCe;
    private View iUJ;
    private ImageView jcA;
    private TextView jcB;
    private TextView jcC;
    public LinearLayout jcD;
    private List<LevelInfo> jcE;
    private DataRes jcF;
    private C0736a jcG;
    private View.OnClickListener jcs;
    private TbTitleActivity jcx;
    private LinearLayout jcy;
    private TextView jcz;
    private NavigationBar mNavigationBar;
    private RelativeLayout mRootView;

    public a(TbTitleActivity tbTitleActivity, View.OnClickListener onClickListener) {
        super(tbTitleActivity.getPageContext());
        this.jcG = new C0736a(new View.OnClickListener() { // from class: com.baidu.tieba.forumMember.tbtitle.a.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(a.this.jcx.getPageContext().getContext()).createNormalCfg(a.this.getPageContext().getString(R.string.tieba_text), "from")));
            }
        });
        this.jcx = tbTitleActivity;
        this.jcs = onClickListener;
        initUI();
    }

    private void initUI() {
        this.mRootView = (RelativeLayout) LayoutInflater.from(this.jcx.getPageContext().getPageActivity()).inflate(R.layout.tbtitle_activity, (ViewGroup) null);
        this.jcx.setContentView(this.mRootView);
        this.iUJ = this.mRootView.findViewById(R.id.top_view);
        if (!j.isNetworkAvailableForImmediately()) {
            this.iUJ.getLayoutParams().height = UtilHelper.getLightStatusBarHeight() + l.getDimens(this.jcx.getActivity(), R.dimen.ds170);
        } else {
            this.iUJ.getLayoutParams().height = UtilHelper.getLightStatusBarHeight() + l.getDimens(this.jcx.getActivity(), R.dimen.ds88);
        }
        this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setCenterTextTitle(this.jcx.getString(R.string.tbtitle_title));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.showBottomLine();
        this.cPa = (ScrollView) this.mRootView.findViewById(R.id.tbtitle_scroll_view);
        this.jcD = (LinearLayout) this.mRootView.findViewById(R.id.first_line_layout);
        this.jcC = (TextView) this.mRootView.findViewById(R.id.tbtile_like_btn);
        this.jcy = (LinearLayout) this.mRootView.findViewById(R.id.table_canvas);
        this.jcz = (TextView) this.mRootView.findViewById(R.id.user_level_name);
        this.jcA = (ImageView) this.mRootView.findViewById(R.id.header_level_img);
        this.jcB = (TextView) this.mRootView.findViewById(R.id.tbtitle_tip_detail2);
        this.gCe = (NoNetworkView) this.mRootView.findViewById(R.id.view_no_network);
        cDz();
        cDA();
    }

    private void cDz() {
        String string = getPageContext().getResources().getString(R.string.tbtitle_tip_detail2);
        String string2 = getPageContext().getResources().getString(R.string.tbtitle_tip_tieba_bar);
        int length = string2.length();
        int indexOf = string.indexOf(string2);
        SpannableString spannableString = new SpannableString(string);
        spannableString.setSpan(this.jcG, indexOf, length + indexOf, 33);
        this.jcB.setText(spannableString);
        this.jcB.setMovementMethod(LinkMovementMethod.getInstance());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.forumMember.tbtitle.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C0736a extends ClickableSpan {
        private View.OnClickListener fko;

        public C0736a(View.OnClickListener onClickListener) {
            this.fko = onClickListener;
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            textPaint.setColor(ao.getColor(R.color.CAM_X0302));
            textPaint.setUnderlineText(false);
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View view) {
            this.fko.onClick(view);
        }
    }

    public void dl(List<LevelInfo> list) {
        this.jcE = list;
        if (this.jcy != null && this.jcE != null && this.jcE.size() != 0) {
            this.jcy.removeAllViews();
            for (int i = 1; i <= list.size(); i++) {
                LevelInfo levelInfo = list.get(i - 1);
                View inflate = LayoutInflater.from(this.jcx.getPageContext().getContext()).inflate(R.layout.tbtitle_table_item, (ViewGroup) null);
                LinearLayout linearLayout = (LinearLayout) inflate.findViewById(R.id.table_item_background);
                TextView textView = (TextView) inflate.findViewById(R.id.table_item_level_name);
                TextView textView2 = (TextView) inflate.findViewById(R.id.table_item_need_experienment);
                View findViewById = inflate.findViewById(R.id.tbtile_item_horizontal_line);
                ImageView imageView = (ImageView) inflate.findViewById(R.id.table_item_level_img);
                if (i % 2 != 0) {
                    ao.setBackgroundResource(linearLayout, R.color.CAM_X0205);
                }
                ao.setViewTextColor(textView, R.color.CAM_X0105, 1);
                ao.setViewTextColor(textView2, R.color.CAM_X0105, 1);
                ao.setBackgroundColor(findViewById, R.color.CAM_X0204);
                ao.setImageResource(imageView, BitmapHelper.getGradeResourceIdNew(levelInfo.id.intValue()));
                textView.setText(levelInfo.name);
                if (levelInfo.score.intValue() <= 3000000 && levelInfo.score.intValue() > 0) {
                    textView2.setText(levelInfo.score + "");
                } else if (levelInfo.score.intValue() <= 0) {
                    textView2.setText("0");
                } else {
                    textView2.setText("3000000");
                }
                this.jcy.addView(inflate);
            }
        }
    }

    public void a(DataRes dataRes) {
        this.jcF = dataRes;
        if (this.jcF != null) {
            if (this.jcF.is_like.intValue() == 1 && this.jcD != null) {
                this.jcD.setVisibility(8);
            }
            if (this.jcz != null) {
                if (StringUtils.isNull(this.jcF.level_name, true)) {
                    this.jcz.setText(this.jcF.level_name);
                } else {
                    this.jcz.setVisibility(8);
                }
            }
            if (this.jcA != null) {
                if (this.jcF.user_level.intValue() <= 0 || this.jcF.user_level.intValue() > 18) {
                    this.jcA.setVisibility(8);
                } else {
                    ao.setImageResource(this.jcA, BitmapHelper.getGradeResourceIdNew(this.jcF.user_level.intValue()));
                }
            }
        }
    }

    private void cDA() {
        this.jcC.setOnClickListener(this.jcs);
        this.jcB.setOnClickListener(this.jcs);
    }

    public void onSkinTypeChanged(int i) {
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(this.jcx.getPageContext(), i);
        }
        if (this.gCe != null) {
            this.gCe.onChangeSkinType(this.jcx.getPageContext(), i);
        }
        dl(this.jcE);
        a(this.jcF);
        this.jcx.getLayoutMode().setNightMode(i == 1);
        this.jcx.getLayoutMode().onModeChanged(this.mRootView);
    }

    public void KA(String str) {
        this.cPa.setVisibility(8);
        this.jcx.showNetRefreshView(this.mRootView, str, true);
        this.jcx.setNetRefreshViewTopMargin(400);
    }

    public void cDB() {
        this.cPa.setVisibility(0);
        this.jcx.hideNetRefreshView(this.mRootView);
    }

    public void showLoadingView() {
        this.cPa.setVisibility(8);
        this.jcx.showLoadingView(this.mRootView, true);
    }

    public void cDC() {
        this.cPa.setVisibility(0);
        this.jcx.hideLoadingView(this.mRootView);
    }

    public void g(NoNetworkView.a aVar) {
        if (aVar != null) {
            this.gCe.a(aVar);
        }
    }

    public void qj(boolean z) {
        if (!z) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.iUJ.getLayoutParams();
            layoutParams.height = UtilHelper.getLightStatusBarHeight() + l.getDimens(this.jcx.getActivity(), R.dimen.ds170);
            this.iUJ.setLayoutParams(layoutParams);
            return;
        }
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.iUJ.getLayoutParams();
        layoutParams2.height = UtilHelper.getLightStatusBarHeight() + l.getDimens(this.jcx.getActivity(), R.dimen.ds88);
        this.iUJ.setLayoutParams(layoutParams2);
    }
}
