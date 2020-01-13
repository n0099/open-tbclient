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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tieba.R;
import com.baidu.tieba.forumMember.tbtitle.TbTitleActivity;
import java.util.List;
import tbclient.GetLevelInfo.DataRes;
import tbclient.LevelInfo;
/* loaded from: classes8.dex */
public class a extends c<TbTitleActivity> {
    private ScrollView bfi;
    private NoNetworkView ehd;
    private View gbS;
    private View.OnClickListener gjH;
    private TbTitleActivity gjM;
    private LinearLayout gjN;
    private TextView gjO;
    private ImageView gjP;
    private TextView gjQ;
    private TextView gjR;
    public LinearLayout gjS;
    private List<LevelInfo> gjT;
    private DataRes gjU;
    private C0494a gjV;
    private NavigationBar mNavigationBar;
    private RelativeLayout mRootView;

    public a(TbTitleActivity tbTitleActivity, View.OnClickListener onClickListener) {
        super(tbTitleActivity.getPageContext());
        this.gjV = new C0494a(new View.OnClickListener() { // from class: com.baidu.tieba.forumMember.tbtitle.a.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(a.this.gjM.getPageContext().getContext()).createNormalCfg(a.this.getPageContext().getString(R.string.tieba_text), "from")));
            }
        });
        this.gjM = tbTitleActivity;
        this.gjH = onClickListener;
        initUI();
    }

    private void initUI() {
        this.mRootView = (RelativeLayout) LayoutInflater.from(this.gjM.getPageContext().getPageActivity()).inflate(R.layout.tbtitle_activity, (ViewGroup) null);
        this.gjM.setContentView(this.mRootView);
        this.gbS = this.mRootView.findViewById(R.id.top_view);
        if (!j.isNetworkAvailableForImmediately()) {
            this.gbS.getLayoutParams().height = UtilHelper.getLightStatusBarHeight() + l.getDimens(this.gjM.getActivity(), R.dimen.ds170);
        } else {
            this.gbS.getLayoutParams().height = UtilHelper.getLightStatusBarHeight() + l.getDimens(this.gjM.getActivity(), R.dimen.ds88);
        }
        this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setCenterTextTitle(this.gjM.getString(R.string.tbtitle_title));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.showBottomLine();
        this.bfi = (ScrollView) this.mRootView.findViewById(R.id.tbtitle_scroll_view);
        this.gjS = (LinearLayout) this.mRootView.findViewById(R.id.first_line_layout);
        this.gjR = (TextView) this.mRootView.findViewById(R.id.tbtile_like_btn);
        this.gjN = (LinearLayout) this.mRootView.findViewById(R.id.table_canvas);
        this.gjO = (TextView) this.mRootView.findViewById(R.id.user_level_name);
        this.gjP = (ImageView) this.mRootView.findViewById(R.id.header_level_img);
        this.gjQ = (TextView) this.mRootView.findViewById(R.id.tbtitle_tip_detail2);
        this.ehd = (NoNetworkView) this.mRootView.findViewById(R.id.view_no_network);
        bAZ();
        bBa();
    }

    private void bAZ() {
        String string = getPageContext().getResources().getString(R.string.tbtitle_tip_detail2);
        String string2 = getPageContext().getResources().getString(R.string.tbtitle_tip_tieba_bar);
        int length = string2.length();
        int indexOf = string.indexOf(string2);
        SpannableString spannableString = new SpannableString(string);
        spannableString.setSpan(this.gjV, indexOf, length + indexOf, 33);
        this.gjQ.setText(spannableString);
        this.gjQ.setMovementMethod(LinkMovementMethod.getInstance());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.forumMember.tbtitle.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C0494a extends ClickableSpan {
        private View.OnClickListener dbS;

        public C0494a(View.OnClickListener onClickListener) {
            this.dbS = onClickListener;
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            textPaint.setColor(am.getColor(R.color.cp_link_tip_a));
            textPaint.setUnderlineText(false);
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View view) {
            this.dbS.onClick(view);
        }
    }

    public void cf(List<LevelInfo> list) {
        this.gjT = list;
        if (this.gjN != null && this.gjT != null && this.gjT.size() != 0) {
            this.gjN.removeAllViews();
            for (int i = 1; i <= list.size(); i++) {
                LevelInfo levelInfo = list.get(i - 1);
                View inflate = LayoutInflater.from(this.gjM.getPageContext().getContext()).inflate(R.layout.tbtitle_table_item, (ViewGroup) null);
                LinearLayout linearLayout = (LinearLayout) inflate.findViewById(R.id.table_item_background);
                TextView textView = (TextView) inflate.findViewById(R.id.table_item_level_name);
                TextView textView2 = (TextView) inflate.findViewById(R.id.table_item_need_experienment);
                View findViewById = inflate.findViewById(R.id.tbtile_item_horizontal_line);
                ImageView imageView = (ImageView) inflate.findViewById(R.id.table_item_level_img);
                if (i % 2 != 0) {
                    am.setBackgroundResource(linearLayout, R.color.cp_bg_line_e);
                }
                am.setViewTextColor(textView, R.color.cp_cont_b, 1);
                am.setViewTextColor(textView2, R.color.cp_cont_b, 1);
                am.setBackgroundColor(findViewById, R.color.cp_bg_line_c);
                am.setImageResource(imageView, BitmapHelper.getGradeResourceIdNew(levelInfo.id.intValue()));
                textView.setText(levelInfo.name);
                if (levelInfo.score.intValue() <= 3000000 && levelInfo.score.intValue() > 0) {
                    textView2.setText(levelInfo.score + "");
                } else if (levelInfo.score.intValue() <= 0) {
                    textView2.setText("0");
                } else {
                    textView2.setText("3000000");
                }
                this.gjN.addView(inflate);
            }
        }
    }

    public void a(DataRes dataRes) {
        this.gjU = dataRes;
        if (this.gjU != null) {
            if (this.gjU.is_like.intValue() == 1 && this.gjS != null) {
                this.gjS.setVisibility(8);
            }
            if (this.gjO != null) {
                if (StringUtils.isNull(this.gjU.level_name, true)) {
                    this.gjO.setText(this.gjU.level_name);
                } else {
                    this.gjO.setVisibility(8);
                }
            }
            if (this.gjP != null) {
                if (this.gjU.user_level.intValue() <= 0 || this.gjU.user_level.intValue() > 18) {
                    this.gjP.setVisibility(8);
                } else {
                    am.setImageResource(this.gjP, BitmapHelper.getGradeResourceIdNew(this.gjU.user_level.intValue()));
                }
            }
        }
    }

    private void bBa() {
        this.gjR.setOnClickListener(this.gjH);
        this.gjQ.setOnClickListener(this.gjH);
    }

    public void onSkinTypeChanged(int i) {
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(this.gjM.getPageContext(), i);
        }
        if (this.ehd != null) {
            this.ehd.onChangeSkinType(this.gjM.getPageContext(), i);
        }
        cf(this.gjT);
        a(this.gjU);
        this.gjM.getLayoutMode().setNightMode(i == 1);
        this.gjM.getLayoutMode().onModeChanged(this.mRootView);
    }

    public void AJ(String str) {
        this.bfi.setVisibility(8);
        this.gjM.showNetRefreshView(this.mRootView, str, true);
        this.gjM.setNetRefreshViewTopMargin(400);
    }

    public void bBb() {
        this.bfi.setVisibility(0);
        this.gjM.hideNetRefreshView(this.mRootView);
    }

    public void showLoadingView() {
        this.bfi.setVisibility(8);
        this.gjM.showLoadingView(this.mRootView, true);
    }

    public void bBc() {
        this.bfi.setVisibility(0);
        this.gjM.hideLoadingView(this.mRootView);
    }

    public void g(NoNetworkView.a aVar) {
        if (aVar != null) {
            this.ehd.a(aVar);
        }
    }

    public void kV(boolean z) {
        if (!z) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.gbS.getLayoutParams();
            layoutParams.height = UtilHelper.getLightStatusBarHeight() + l.getDimens(this.gjM.getActivity(), R.dimen.ds170);
            this.gbS.setLayoutParams(layoutParams);
            return;
        }
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.gbS.getLayoutParams();
        layoutParams2.height = UtilHelper.getLightStatusBarHeight() + l.getDimens(this.gjM.getActivity(), R.dimen.ds88);
        this.gbS.setLayoutParams(layoutParams2);
    }
}
