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
/* loaded from: classes10.dex */
public class a extends c<TbTitleActivity> {
    private ScrollView bQQ;
    private NoNetworkView fbX;
    private View hcR;
    private View.OnClickListener hkD;
    private TbTitleActivity hkI;
    private LinearLayout hkJ;
    private TextView hkK;
    private ImageView hkL;
    private TextView hkM;
    private TextView hkN;
    public LinearLayout hkO;
    private List<LevelInfo> hkP;
    private DataRes hkQ;
    private C0609a hkR;
    private NavigationBar mNavigationBar;
    private RelativeLayout mRootView;

    public a(TbTitleActivity tbTitleActivity, View.OnClickListener onClickListener) {
        super(tbTitleActivity.getPageContext());
        this.hkR = new C0609a(new View.OnClickListener() { // from class: com.baidu.tieba.forumMember.tbtitle.a.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(a.this.hkI.getPageContext().getContext()).createNormalCfg(a.this.getPageContext().getString(R.string.tieba_text), "from")));
            }
        });
        this.hkI = tbTitleActivity;
        this.hkD = onClickListener;
        initUI();
    }

    private void initUI() {
        this.mRootView = (RelativeLayout) LayoutInflater.from(this.hkI.getPageContext().getPageActivity()).inflate(R.layout.tbtitle_activity, (ViewGroup) null);
        this.hkI.setContentView(this.mRootView);
        this.hcR = this.mRootView.findViewById(R.id.top_view);
        if (!j.isNetworkAvailableForImmediately()) {
            this.hcR.getLayoutParams().height = UtilHelper.getLightStatusBarHeight() + l.getDimens(this.hkI.getActivity(), R.dimen.ds170);
        } else {
            this.hcR.getLayoutParams().height = UtilHelper.getLightStatusBarHeight() + l.getDimens(this.hkI.getActivity(), R.dimen.ds88);
        }
        this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setCenterTextTitle(this.hkI.getString(R.string.tbtitle_title));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.showBottomLine();
        this.bQQ = (ScrollView) this.mRootView.findViewById(R.id.tbtitle_scroll_view);
        this.hkO = (LinearLayout) this.mRootView.findViewById(R.id.first_line_layout);
        this.hkN = (TextView) this.mRootView.findViewById(R.id.tbtile_like_btn);
        this.hkJ = (LinearLayout) this.mRootView.findViewById(R.id.table_canvas);
        this.hkK = (TextView) this.mRootView.findViewById(R.id.user_level_name);
        this.hkL = (ImageView) this.mRootView.findViewById(R.id.header_level_img);
        this.hkM = (TextView) this.mRootView.findViewById(R.id.tbtitle_tip_detail2);
        this.fbX = (NoNetworkView) this.mRootView.findViewById(R.id.view_no_network);
        bTE();
        bTF();
    }

    private void bTE() {
        String string = getPageContext().getResources().getString(R.string.tbtitle_tip_detail2);
        String string2 = getPageContext().getResources().getString(R.string.tbtitle_tip_tieba_bar);
        int length = string2.length();
        int indexOf = string.indexOf(string2);
        SpannableString spannableString = new SpannableString(string);
        spannableString.setSpan(this.hkR, indexOf, length + indexOf, 33);
        this.hkM.setText(spannableString);
        this.hkM.setMovementMethod(LinkMovementMethod.getInstance());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.forumMember.tbtitle.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public class C0609a extends ClickableSpan {
        private View.OnClickListener dUl;

        public C0609a(View.OnClickListener onClickListener) {
            this.dUl = onClickListener;
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            textPaint.setColor(am.getColor(R.color.cp_link_tip_a));
            textPaint.setUnderlineText(false);
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View view) {
            this.dUl.onClick(view);
        }
    }

    public void ck(List<LevelInfo> list) {
        this.hkP = list;
        if (this.hkJ != null && this.hkP != null && this.hkP.size() != 0) {
            this.hkJ.removeAllViews();
            for (int i = 1; i <= list.size(); i++) {
                LevelInfo levelInfo = list.get(i - 1);
                View inflate = LayoutInflater.from(this.hkI.getPageContext().getContext()).inflate(R.layout.tbtitle_table_item, (ViewGroup) null);
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
                this.hkJ.addView(inflate);
            }
        }
    }

    public void a(DataRes dataRes) {
        this.hkQ = dataRes;
        if (this.hkQ != null) {
            if (this.hkQ.is_like.intValue() == 1 && this.hkO != null) {
                this.hkO.setVisibility(8);
            }
            if (this.hkK != null) {
                if (StringUtils.isNull(this.hkQ.level_name, true)) {
                    this.hkK.setText(this.hkQ.level_name);
                } else {
                    this.hkK.setVisibility(8);
                }
            }
            if (this.hkL != null) {
                if (this.hkQ.user_level.intValue() <= 0 || this.hkQ.user_level.intValue() > 18) {
                    this.hkL.setVisibility(8);
                } else {
                    am.setImageResource(this.hkL, BitmapHelper.getGradeResourceIdNew(this.hkQ.user_level.intValue()));
                }
            }
        }
    }

    private void bTF() {
        this.hkN.setOnClickListener(this.hkD);
        this.hkM.setOnClickListener(this.hkD);
    }

    public void onSkinTypeChanged(int i) {
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(this.hkI.getPageContext(), i);
        }
        if (this.fbX != null) {
            this.fbX.onChangeSkinType(this.hkI.getPageContext(), i);
        }
        ck(this.hkP);
        a(this.hkQ);
        this.hkI.getLayoutMode().setNightMode(i == 1);
        this.hkI.getLayoutMode().onModeChanged(this.mRootView);
    }

    public void Ey(String str) {
        this.bQQ.setVisibility(8);
        this.hkI.showNetRefreshView(this.mRootView, str, true);
        this.hkI.setNetRefreshViewTopMargin(400);
    }

    public void bTG() {
        this.bQQ.setVisibility(0);
        this.hkI.hideNetRefreshView(this.mRootView);
    }

    public void showLoadingView() {
        this.bQQ.setVisibility(8);
        this.hkI.showLoadingView(this.mRootView, true);
    }

    public void bTH() {
        this.bQQ.setVisibility(0);
        this.hkI.hideLoadingView(this.mRootView);
    }

    public void g(NoNetworkView.a aVar) {
        if (aVar != null) {
            this.fbX.a(aVar);
        }
    }

    public void mE(boolean z) {
        if (!z) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.hcR.getLayoutParams();
            layoutParams.height = UtilHelper.getLightStatusBarHeight() + l.getDimens(this.hkI.getActivity(), R.dimen.ds170);
            this.hcR.setLayoutParams(layoutParams);
            return;
        }
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.hcR.getLayoutParams();
        layoutParams2.height = UtilHelper.getLightStatusBarHeight() + l.getDimens(this.hkI.getActivity(), R.dimen.ds88);
        this.hcR.setLayoutParams(layoutParams2);
    }
}
