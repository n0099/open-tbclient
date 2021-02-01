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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tieba.R;
import com.baidu.tieba.forumMember.tbtitle.TbTitleActivity;
import java.util.List;
import tbclient.GetLevelInfo.DataRes;
import tbclient.LevelInfo;
/* loaded from: classes8.dex */
public class a extends d<TbTitleActivity> {
    private ScrollView cMC;
    private NoNetworkView gAh;
    private View iVJ;
    private ImageView jdA;
    private TextView jdB;
    private TextView jdC;
    public LinearLayout jdD;
    private List<LevelInfo> jdE;
    private DataRes jdF;
    private C0719a jdG;
    private View.OnClickListener jds;
    private TbTitleActivity jdx;
    private LinearLayout jdy;
    private TextView jdz;
    private NavigationBar mNavigationBar;
    private RelativeLayout mRootView;

    public a(TbTitleActivity tbTitleActivity, View.OnClickListener onClickListener) {
        super(tbTitleActivity.getPageContext());
        this.jdG = new C0719a(new View.OnClickListener() { // from class: com.baidu.tieba.forumMember.tbtitle.a.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(a.this.jdx.getPageContext().getContext()).createNormalCfg(a.this.getPageContext().getString(R.string.tieba_text), "from")));
            }
        });
        this.jdx = tbTitleActivity;
        this.jds = onClickListener;
        initUI();
    }

    private void initUI() {
        this.mRootView = (RelativeLayout) LayoutInflater.from(this.jdx.getPageContext().getPageActivity()).inflate(R.layout.tbtitle_activity, (ViewGroup) null);
        this.jdx.setContentView(this.mRootView);
        this.iVJ = this.mRootView.findViewById(R.id.top_view);
        if (!j.isNetworkAvailableForImmediately()) {
            this.iVJ.getLayoutParams().height = UtilHelper.getLightStatusBarHeight() + l.getDimens(this.jdx.getActivity(), R.dimen.ds170);
        } else {
            this.iVJ.getLayoutParams().height = UtilHelper.getLightStatusBarHeight() + l.getDimens(this.jdx.getActivity(), R.dimen.ds88);
        }
        this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setCenterTextTitle(this.jdx.getString(R.string.tbtitle_title));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.showBottomLine();
        this.cMC = (ScrollView) this.mRootView.findViewById(R.id.tbtitle_scroll_view);
        this.jdD = (LinearLayout) this.mRootView.findViewById(R.id.first_line_layout);
        this.jdC = (TextView) this.mRootView.findViewById(R.id.tbtile_like_btn);
        this.jdy = (LinearLayout) this.mRootView.findViewById(R.id.table_canvas);
        this.jdz = (TextView) this.mRootView.findViewById(R.id.user_level_name);
        this.jdA = (ImageView) this.mRootView.findViewById(R.id.header_level_img);
        this.jdB = (TextView) this.mRootView.findViewById(R.id.tbtitle_tip_detail2);
        this.gAh = (NoNetworkView) this.mRootView.findViewById(R.id.view_no_network);
        cAS();
        cAT();
    }

    private void cAS() {
        String string = getPageContext().getResources().getString(R.string.tbtitle_tip_detail2);
        String string2 = getPageContext().getResources().getString(R.string.tbtitle_tip_tieba_bar);
        int length = string2.length();
        int indexOf = string.indexOf(string2);
        SpannableString spannableString = new SpannableString(string);
        spannableString.setSpan(this.jdG, indexOf, length + indexOf, 33);
        this.jdB.setText(spannableString);
        this.jdB.setMovementMethod(LinkMovementMethod.getInstance());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.forumMember.tbtitle.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C0719a extends ClickableSpan {
        private View.OnClickListener fhT;

        public C0719a(View.OnClickListener onClickListener) {
            this.fhT = onClickListener;
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            textPaint.setColor(ap.getColor(R.color.CAM_X0302));
            textPaint.setUnderlineText(false);
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View view) {
            this.fhT.onClick(view);
        }
    }

    public void dg(List<LevelInfo> list) {
        this.jdE = list;
        if (this.jdy != null && this.jdE != null && this.jdE.size() != 0) {
            this.jdy.removeAllViews();
            for (int i = 1; i <= list.size(); i++) {
                LevelInfo levelInfo = list.get(i - 1);
                View inflate = LayoutInflater.from(this.jdx.getPageContext().getContext()).inflate(R.layout.tbtitle_table_item, (ViewGroup) null);
                LinearLayout linearLayout = (LinearLayout) inflate.findViewById(R.id.table_item_background);
                TextView textView = (TextView) inflate.findViewById(R.id.table_item_level_name);
                TextView textView2 = (TextView) inflate.findViewById(R.id.table_item_need_experienment);
                View findViewById = inflate.findViewById(R.id.tbtile_item_horizontal_line);
                ImageView imageView = (ImageView) inflate.findViewById(R.id.table_item_level_img);
                if (i % 2 != 0) {
                    ap.setBackgroundResource(linearLayout, R.color.CAM_X0205);
                }
                ap.setViewTextColor(textView, R.color.CAM_X0105, 1);
                ap.setViewTextColor(textView2, R.color.CAM_X0105, 1);
                ap.setBackgroundColor(findViewById, R.color.CAM_X0204);
                ap.setImageResource(imageView, BitmapHelper.getGradeResourceIdNew(levelInfo.id.intValue()));
                textView.setText(levelInfo.name);
                if (levelInfo.score.intValue() <= 3000000 && levelInfo.score.intValue() > 0) {
                    textView2.setText(levelInfo.score + "");
                } else if (levelInfo.score.intValue() <= 0) {
                    textView2.setText("0");
                } else {
                    textView2.setText("3000000");
                }
                this.jdy.addView(inflate);
            }
        }
    }

    public void a(DataRes dataRes) {
        this.jdF = dataRes;
        if (this.jdF != null) {
            if (this.jdF.is_like.intValue() == 1 && this.jdD != null) {
                this.jdD.setVisibility(8);
            }
            if (this.jdz != null) {
                if (StringUtils.isNull(this.jdF.level_name, true)) {
                    this.jdz.setText(this.jdF.level_name);
                } else {
                    this.jdz.setVisibility(8);
                }
            }
            if (this.jdA != null) {
                if (this.jdF.user_level.intValue() <= 0 || this.jdF.user_level.intValue() > 18) {
                    this.jdA.setVisibility(8);
                } else {
                    ap.setImageResource(this.jdA, BitmapHelper.getGradeResourceIdNew(this.jdF.user_level.intValue()));
                }
            }
        }
    }

    private void cAT() {
        this.jdC.setOnClickListener(this.jds);
        this.jdB.setOnClickListener(this.jds);
    }

    public void onSkinTypeChanged(int i) {
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(this.jdx.getPageContext(), i);
        }
        if (this.gAh != null) {
            this.gAh.onChangeSkinType(this.jdx.getPageContext(), i);
        }
        dg(this.jdE);
        a(this.jdF);
        this.jdx.getLayoutMode().setNightMode(i == 1);
        this.jdx.getLayoutMode().onModeChanged(this.mRootView);
    }

    public void Ka(String str) {
        this.cMC.setVisibility(8);
        this.jdx.showNetRefreshView(this.mRootView, str, true);
        this.jdx.setNetRefreshViewTopMargin(400);
    }

    public void cAU() {
        this.cMC.setVisibility(0);
        this.jdx.hideNetRefreshView(this.mRootView);
    }

    public void showLoadingView() {
        this.cMC.setVisibility(8);
        this.jdx.showLoadingView(this.mRootView, true);
    }

    public void cAV() {
        this.cMC.setVisibility(0);
        this.jdx.hideLoadingView(this.mRootView);
    }

    public void g(NoNetworkView.a aVar) {
        if (aVar != null) {
            this.gAh.a(aVar);
        }
    }

    public void qp(boolean z) {
        if (!z) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.iVJ.getLayoutParams();
            layoutParams.height = UtilHelper.getLightStatusBarHeight() + l.getDimens(this.jdx.getActivity(), R.dimen.ds170);
            this.iVJ.setLayoutParams(layoutParams);
            return;
        }
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.iVJ.getLayoutParams();
        layoutParams2.height = UtilHelper.getLightStatusBarHeight() + l.getDimens(this.jdx.getActivity(), R.dimen.ds88);
        this.iVJ.setLayoutParams(layoutParams2);
    }
}
