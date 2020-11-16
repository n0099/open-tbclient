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
import com.baidu.adp.base.c;
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
/* loaded from: classes22.dex */
public class a extends c<TbTitleActivity> {
    private ScrollView cDk;
    private NoNetworkView giU;
    private C0722a iFA;
    private View.OnClickListener iFm;
    private TbTitleActivity iFr;
    private LinearLayout iFs;
    private TextView iFt;
    private ImageView iFu;
    private TextView iFv;
    private TextView iFw;
    public LinearLayout iFx;
    private List<LevelInfo> iFy;
    private DataRes iFz;
    private View ixE;
    private NavigationBar mNavigationBar;
    private RelativeLayout mRootView;

    public a(TbTitleActivity tbTitleActivity, View.OnClickListener onClickListener) {
        super(tbTitleActivity.getPageContext());
        this.iFA = new C0722a(new View.OnClickListener() { // from class: com.baidu.tieba.forumMember.tbtitle.a.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(a.this.iFr.getPageContext().getContext()).createNormalCfg(a.this.getPageContext().getString(R.string.tieba_text), "from")));
            }
        });
        this.iFr = tbTitleActivity;
        this.iFm = onClickListener;
        initUI();
    }

    private void initUI() {
        this.mRootView = (RelativeLayout) LayoutInflater.from(this.iFr.getPageContext().getPageActivity()).inflate(R.layout.tbtitle_activity, (ViewGroup) null);
        this.iFr.setContentView(this.mRootView);
        this.ixE = this.mRootView.findViewById(R.id.top_view);
        if (!j.isNetworkAvailableForImmediately()) {
            this.ixE.getLayoutParams().height = UtilHelper.getLightStatusBarHeight() + l.getDimens(this.iFr.getActivity(), R.dimen.ds170);
        } else {
            this.ixE.getLayoutParams().height = UtilHelper.getLightStatusBarHeight() + l.getDimens(this.iFr.getActivity(), R.dimen.ds88);
        }
        this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setCenterTextTitle(this.iFr.getString(R.string.tbtitle_title));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.showBottomLine();
        this.cDk = (ScrollView) this.mRootView.findViewById(R.id.tbtitle_scroll_view);
        this.iFx = (LinearLayout) this.mRootView.findViewById(R.id.first_line_layout);
        this.iFw = (TextView) this.mRootView.findViewById(R.id.tbtile_like_btn);
        this.iFs = (LinearLayout) this.mRootView.findViewById(R.id.table_canvas);
        this.iFt = (TextView) this.mRootView.findViewById(R.id.user_level_name);
        this.iFu = (ImageView) this.mRootView.findViewById(R.id.header_level_img);
        this.iFv = (TextView) this.mRootView.findViewById(R.id.tbtitle_tip_detail2);
        this.giU = (NoNetworkView) this.mRootView.findViewById(R.id.view_no_network);
        cwp();
        cwq();
    }

    private void cwp() {
        String string = getPageContext().getResources().getString(R.string.tbtitle_tip_detail2);
        String string2 = getPageContext().getResources().getString(R.string.tbtitle_tip_tieba_bar);
        int length = string2.length();
        int indexOf = string.indexOf(string2);
        SpannableString spannableString = new SpannableString(string);
        spannableString.setSpan(this.iFA, indexOf, length + indexOf, 33);
        this.iFv.setText(spannableString);
        this.iFv.setMovementMethod(LinkMovementMethod.getInstance());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.forumMember.tbtitle.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes22.dex */
    public class C0722a extends ClickableSpan {
        private View.OnClickListener eTp;

        public C0722a(View.OnClickListener onClickListener) {
            this.eTp = onClickListener;
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            textPaint.setColor(ap.getColor(R.color.CAM_X0302));
            textPaint.setUnderlineText(false);
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View view) {
            this.eTp.onClick(view);
        }
    }

    public void da(List<LevelInfo> list) {
        this.iFy = list;
        if (this.iFs != null && this.iFy != null && this.iFy.size() != 0) {
            this.iFs.removeAllViews();
            for (int i = 1; i <= list.size(); i++) {
                LevelInfo levelInfo = list.get(i - 1);
                View inflate = LayoutInflater.from(this.iFr.getPageContext().getContext()).inflate(R.layout.tbtitle_table_item, (ViewGroup) null);
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
                this.iFs.addView(inflate);
            }
        }
    }

    public void a(DataRes dataRes) {
        this.iFz = dataRes;
        if (this.iFz != null) {
            if (this.iFz.is_like.intValue() == 1 && this.iFx != null) {
                this.iFx.setVisibility(8);
            }
            if (this.iFt != null) {
                if (StringUtils.isNull(this.iFz.level_name, true)) {
                    this.iFt.setText(this.iFz.level_name);
                } else {
                    this.iFt.setVisibility(8);
                }
            }
            if (this.iFu != null) {
                if (this.iFz.user_level.intValue() <= 0 || this.iFz.user_level.intValue() > 18) {
                    this.iFu.setVisibility(8);
                } else {
                    ap.setImageResource(this.iFu, BitmapHelper.getGradeResourceIdNew(this.iFz.user_level.intValue()));
                }
            }
        }
    }

    private void cwq() {
        this.iFw.setOnClickListener(this.iFm);
        this.iFv.setOnClickListener(this.iFm);
    }

    public void onSkinTypeChanged(int i) {
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(this.iFr.getPageContext(), i);
        }
        if (this.giU != null) {
            this.giU.onChangeSkinType(this.iFr.getPageContext(), i);
        }
        da(this.iFy);
        a(this.iFz);
        this.iFr.getLayoutMode().setNightMode(i == 1);
        this.iFr.getLayoutMode().onModeChanged(this.mRootView);
    }

    public void JN(String str) {
        this.cDk.setVisibility(8);
        this.iFr.showNetRefreshView(this.mRootView, str, true);
        this.iFr.setNetRefreshViewTopMargin(400);
    }

    public void cwr() {
        this.cDk.setVisibility(0);
        this.iFr.hideNetRefreshView(this.mRootView);
    }

    public void showLoadingView() {
        this.cDk.setVisibility(8);
        this.iFr.showLoadingView(this.mRootView, true);
    }

    public void cws() {
        this.cDk.setVisibility(0);
        this.iFr.hideLoadingView(this.mRootView);
    }

    public void g(NoNetworkView.a aVar) {
        if (aVar != null) {
            this.giU.a(aVar);
        }
    }

    public void pp(boolean z) {
        if (!z) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.ixE.getLayoutParams();
            layoutParams.height = UtilHelper.getLightStatusBarHeight() + l.getDimens(this.iFr.getActivity(), R.dimen.ds170);
            this.ixE.setLayoutParams(layoutParams);
            return;
        }
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.ixE.getLayoutParams();
        layoutParams2.height = UtilHelper.getLightStatusBarHeight() + l.getDimens(this.iFr.getActivity(), R.dimen.ds88);
        this.ixE.setLayoutParams(layoutParams2);
    }
}
