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
    private ScrollView bjL;
    private NoNetworkView elL;
    private View geR;
    private View.OnClickListener gmF;
    private TbTitleActivity gmK;
    private LinearLayout gmL;
    private TextView gmM;
    private ImageView gmN;
    private TextView gmO;
    private TextView gmP;
    public LinearLayout gmQ;
    private List<LevelInfo> gmR;
    private DataRes gmS;
    private C0501a gmT;
    private NavigationBar mNavigationBar;
    private RelativeLayout mRootView;

    public a(TbTitleActivity tbTitleActivity, View.OnClickListener onClickListener) {
        super(tbTitleActivity.getPageContext());
        this.gmT = new C0501a(new View.OnClickListener() { // from class: com.baidu.tieba.forumMember.tbtitle.a.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(a.this.gmK.getPageContext().getContext()).createNormalCfg(a.this.getPageContext().getString(R.string.tieba_text), "from")));
            }
        });
        this.gmK = tbTitleActivity;
        this.gmF = onClickListener;
        initUI();
    }

    private void initUI() {
        this.mRootView = (RelativeLayout) LayoutInflater.from(this.gmK.getPageContext().getPageActivity()).inflate(R.layout.tbtitle_activity, (ViewGroup) null);
        this.gmK.setContentView(this.mRootView);
        this.geR = this.mRootView.findViewById(R.id.top_view);
        if (!j.isNetworkAvailableForImmediately()) {
            this.geR.getLayoutParams().height = UtilHelper.getLightStatusBarHeight() + l.getDimens(this.gmK.getActivity(), R.dimen.ds170);
        } else {
            this.geR.getLayoutParams().height = UtilHelper.getLightStatusBarHeight() + l.getDimens(this.gmK.getActivity(), R.dimen.ds88);
        }
        this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setCenterTextTitle(this.gmK.getString(R.string.tbtitle_title));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.showBottomLine();
        this.bjL = (ScrollView) this.mRootView.findViewById(R.id.tbtitle_scroll_view);
        this.gmQ = (LinearLayout) this.mRootView.findViewById(R.id.first_line_layout);
        this.gmP = (TextView) this.mRootView.findViewById(R.id.tbtile_like_btn);
        this.gmL = (LinearLayout) this.mRootView.findViewById(R.id.table_canvas);
        this.gmM = (TextView) this.mRootView.findViewById(R.id.user_level_name);
        this.gmN = (ImageView) this.mRootView.findViewById(R.id.header_level_img);
        this.gmO = (TextView) this.mRootView.findViewById(R.id.tbtitle_tip_detail2);
        this.elL = (NoNetworkView) this.mRootView.findViewById(R.id.view_no_network);
        bCK();
        bCL();
    }

    private void bCK() {
        String string = getPageContext().getResources().getString(R.string.tbtitle_tip_detail2);
        String string2 = getPageContext().getResources().getString(R.string.tbtitle_tip_tieba_bar);
        int length = string2.length();
        int indexOf = string.indexOf(string2);
        SpannableString spannableString = new SpannableString(string);
        spannableString.setSpan(this.gmT, indexOf, length + indexOf, 33);
        this.gmO.setText(spannableString);
        this.gmO.setMovementMethod(LinkMovementMethod.getInstance());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.forumMember.tbtitle.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public class C0501a extends ClickableSpan {
        private View.OnClickListener dgy;

        public C0501a(View.OnClickListener onClickListener) {
            this.dgy = onClickListener;
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            textPaint.setColor(am.getColor(R.color.cp_link_tip_a));
            textPaint.setUnderlineText(false);
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View view) {
            this.dgy.onClick(view);
        }
    }

    public void cb(List<LevelInfo> list) {
        this.gmR = list;
        if (this.gmL != null && this.gmR != null && this.gmR.size() != 0) {
            this.gmL.removeAllViews();
            for (int i = 1; i <= list.size(); i++) {
                LevelInfo levelInfo = list.get(i - 1);
                View inflate = LayoutInflater.from(this.gmK.getPageContext().getContext()).inflate(R.layout.tbtitle_table_item, (ViewGroup) null);
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
                this.gmL.addView(inflate);
            }
        }
    }

    public void a(DataRes dataRes) {
        this.gmS = dataRes;
        if (this.gmS != null) {
            if (this.gmS.is_like.intValue() == 1 && this.gmQ != null) {
                this.gmQ.setVisibility(8);
            }
            if (this.gmM != null) {
                if (StringUtils.isNull(this.gmS.level_name, true)) {
                    this.gmM.setText(this.gmS.level_name);
                } else {
                    this.gmM.setVisibility(8);
                }
            }
            if (this.gmN != null) {
                if (this.gmS.user_level.intValue() <= 0 || this.gmS.user_level.intValue() > 18) {
                    this.gmN.setVisibility(8);
                } else {
                    am.setImageResource(this.gmN, BitmapHelper.getGradeResourceIdNew(this.gmS.user_level.intValue()));
                }
            }
        }
    }

    private void bCL() {
        this.gmP.setOnClickListener(this.gmF);
        this.gmO.setOnClickListener(this.gmF);
    }

    public void onSkinTypeChanged(int i) {
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(this.gmK.getPageContext(), i);
        }
        if (this.elL != null) {
            this.elL.onChangeSkinType(this.gmK.getPageContext(), i);
        }
        cb(this.gmR);
        a(this.gmS);
        this.gmK.getLayoutMode().setNightMode(i == 1);
        this.gmK.getLayoutMode().onModeChanged(this.mRootView);
    }

    public void Bb(String str) {
        this.bjL.setVisibility(8);
        this.gmK.showNetRefreshView(this.mRootView, str, true);
        this.gmK.setNetRefreshViewTopMargin(400);
    }

    public void bCM() {
        this.bjL.setVisibility(0);
        this.gmK.hideNetRefreshView(this.mRootView);
    }

    public void showLoadingView() {
        this.bjL.setVisibility(8);
        this.gmK.showLoadingView(this.mRootView, true);
    }

    public void bCN() {
        this.bjL.setVisibility(0);
        this.gmK.hideLoadingView(this.mRootView);
    }

    public void g(NoNetworkView.a aVar) {
        if (aVar != null) {
            this.elL.a(aVar);
        }
    }

    public void le(boolean z) {
        if (!z) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.geR.getLayoutParams();
            layoutParams.height = UtilHelper.getLightStatusBarHeight() + l.getDimens(this.gmK.getActivity(), R.dimen.ds170);
            this.geR.setLayoutParams(layoutParams);
            return;
        }
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.geR.getLayoutParams();
        layoutParams2.height = UtilHelper.getLightStatusBarHeight() + l.getDimens(this.gmK.getActivity(), R.dimen.ds88);
        this.geR.setLayoutParams(layoutParams2);
    }
}
