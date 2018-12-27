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
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tieba.e;
import com.baidu.tieba.forumMember.tbtitle.TbTitleActivity;
import java.util.List;
import tbclient.GetLevelInfo.DataRes;
import tbclient.LevelInfo;
/* loaded from: classes3.dex */
public class a extends c<TbTitleActivity> {
    private ScrollView bHx;
    private NoNetworkView bOA;
    private View.OnClickListener dIC;
    private TbTitleActivity dIH;
    private LinearLayout dII;
    private TextView dIJ;
    private ImageView dIK;
    private TextView dIL;
    private TextView dIM;
    public LinearLayout dIN;
    private List<LevelInfo> dIO;
    private DataRes dIP;
    private C0216a dIQ;
    private View dxd;
    private NavigationBar mNavigationBar;
    private RelativeLayout mRootView;

    public a(TbTitleActivity tbTitleActivity, View.OnClickListener onClickListener) {
        super(tbTitleActivity.getPageContext());
        this.dIQ = new C0216a(new View.OnClickListener() { // from class: com.baidu.tieba.forumMember.tbtitle.a.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(a.this.dIH.getPageContext().getContext()).createNormalCfg(a.this.getPageContext().getString(e.j.tieba_text), "from")));
            }
        });
        this.dIH = tbTitleActivity;
        this.dIC = onClickListener;
        initUI();
    }

    private void initUI() {
        this.mRootView = (RelativeLayout) LayoutInflater.from(this.dIH.getPageContext().getPageActivity()).inflate(e.h.tbtitle_activity, (ViewGroup) null);
        this.dIH.setContentView(this.mRootView);
        this.dxd = this.mRootView.findViewById(e.g.top_view);
        if (!j.kK()) {
            this.dxd.getLayoutParams().height = UtilHelper.getLightStatusBarHeight() + l.h(this.dIH.getActivity(), e.C0210e.ds170);
        } else {
            this.dxd.getLayoutParams().height = UtilHelper.getLightStatusBarHeight() + l.h(this.dIH.getActivity(), e.C0210e.ds88);
        }
        this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(e.g.view_navigation_bar);
        this.mNavigationBar.setCenterTextTitle(this.dIH.getString(e.j.tbtitle_title));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.showBottomLine();
        this.bHx = (ScrollView) this.mRootView.findViewById(e.g.tbtitle_scroll_view);
        this.dIN = (LinearLayout) this.mRootView.findViewById(e.g.first_line_layout);
        this.dIM = (TextView) this.mRootView.findViewById(e.g.tbtile_like_btn);
        this.dII = (LinearLayout) this.mRootView.findViewById(e.g.table_canvas);
        this.dIJ = (TextView) this.mRootView.findViewById(e.g.user_level_name);
        this.dIK = (ImageView) this.mRootView.findViewById(e.g.header_level_img);
        this.dIL = (TextView) this.mRootView.findViewById(e.g.tbtitle_tip_detail2);
        this.bOA = (NoNetworkView) this.mRootView.findViewById(e.g.view_no_network);
        aAr();
        aAs();
    }

    private void aAr() {
        String string = getPageContext().getResources().getString(e.j.tbtitle_tip_detail2);
        String string2 = getPageContext().getResources().getString(e.j.tbtitle_tip_tieba_bar);
        int length = string2.length();
        int indexOf = string.indexOf(string2);
        SpannableString spannableString = new SpannableString(string);
        spannableString.setSpan(this.dIQ, indexOf, length + indexOf, 33);
        this.dIL.setText(spannableString);
        this.dIL.setMovementMethod(LinkMovementMethod.getInstance());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.forumMember.tbtitle.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0216a extends ClickableSpan {
        private View.OnClickListener aHP;

        public C0216a(View.OnClickListener onClickListener) {
            this.aHP = onClickListener;
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            textPaint.setColor(al.getColor(e.d.cp_link_tip_a));
            textPaint.setUnderlineText(false);
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View view) {
            this.aHP.onClick(view);
        }
    }

    public void bB(List<LevelInfo> list) {
        this.dIO = list;
        if (this.dII != null && this.dIO != null && this.dIO.size() != 0) {
            this.dII.removeAllViews();
            for (int i = 1; i <= list.size(); i++) {
                LevelInfo levelInfo = list.get(i - 1);
                View inflate = LayoutInflater.from(this.dIH.getPageContext().getContext()).inflate(e.h.tbtitle_table_item, (ViewGroup) null);
                LinearLayout linearLayout = (LinearLayout) inflate.findViewById(e.g.table_item_background);
                TextView textView = (TextView) inflate.findViewById(e.g.table_item_level_name);
                TextView textView2 = (TextView) inflate.findViewById(e.g.table_item_need_experienment);
                View findViewById = inflate.findViewById(e.g.tbtile_item_horizontal_line);
                ImageView imageView = (ImageView) inflate.findViewById(e.g.table_item_level_img);
                if (i % 2 != 0) {
                    al.i(linearLayout, e.d.cp_bg_line_e);
                }
                al.c(textView, e.d.cp_cont_b, 1);
                al.c(textView2, e.d.cp_cont_b, 1);
                al.j(findViewById, e.d.cp_bg_line_b);
                al.c(imageView, BitmapHelper.getGradeResourceIdNew(levelInfo.id.intValue()));
                textView.setText(levelInfo.name);
                if (levelInfo.score.intValue() <= 3000000 && levelInfo.score.intValue() > 0) {
                    textView2.setText(levelInfo.score + "");
                } else if (levelInfo.score.intValue() <= 0) {
                    textView2.setText("0");
                } else {
                    textView2.setText("3000000");
                }
                this.dII.addView(inflate);
            }
        }
    }

    public void a(DataRes dataRes) {
        this.dIP = dataRes;
        if (this.dIP != null) {
            if (this.dIP.is_like.intValue() == 1 && this.dIN != null) {
                this.dIN.setVisibility(8);
            }
            if (this.dIJ != null) {
                if (StringUtils.isNull(this.dIP.level_name, true)) {
                    this.dIJ.setText(this.dIP.level_name);
                } else {
                    this.dIJ.setVisibility(8);
                }
            }
            if (this.dIK != null) {
                if (this.dIP.user_level.intValue() <= 0 || this.dIP.user_level.intValue() > 18) {
                    this.dIK.setVisibility(8);
                } else {
                    al.c(this.dIK, BitmapHelper.getGradeResourceIdNew(this.dIP.user_level.intValue()));
                }
            }
        }
    }

    private void aAs() {
        this.dIM.setOnClickListener(this.dIC);
        this.dIL.setOnClickListener(this.dIC);
    }

    public void ej(int i) {
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(this.dIH.getPageContext(), i);
        }
        if (this.bOA != null) {
            this.bOA.onChangeSkinType(this.dIH.getPageContext(), i);
        }
        bB(this.dIO);
        a(this.dIP);
        this.dIH.getLayoutMode().setNightMode(i == 1);
        this.dIH.getLayoutMode().onModeChanged(this.mRootView);
    }

    public void nX(String str) {
        this.bHx.setVisibility(8);
        this.dIH.showNetRefreshView(this.mRootView, str, true);
        this.dIH.setNetRefreshViewTopMargin(400);
    }

    public void aAt() {
        this.bHx.setVisibility(0);
        this.dIH.hideNetRefreshView(this.mRootView);
    }

    public void showLoadingView() {
        this.bHx.setVisibility(8);
        this.dIH.showLoadingView(this.mRootView, true);
    }

    public void aAu() {
        this.bHx.setVisibility(0);
        this.dIH.hideLoadingView(this.mRootView);
    }

    public void h(NoNetworkView.a aVar) {
        if (aVar != null) {
            this.bOA.a(aVar);
        }
    }

    public void gp(boolean z) {
        if (!z) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.dxd.getLayoutParams();
            layoutParams.height = UtilHelper.getLightStatusBarHeight() + l.h(this.dIH.getActivity(), e.C0210e.ds170);
            this.dxd.setLayoutParams(layoutParams);
            return;
        }
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.dxd.getLayoutParams();
        layoutParams2.height = UtilHelper.getLightStatusBarHeight() + l.h(this.dIH.getActivity(), e.C0210e.ds88);
        this.dxd.setLayoutParams(layoutParams2);
    }
}
