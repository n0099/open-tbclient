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
    private ScrollView bHu;
    private NoNetworkView bOx;
    private View.OnClickListener dFO;
    private TbTitleActivity dFT;
    private LinearLayout dFU;
    private TextView dFV;
    private ImageView dFW;
    private TextView dFX;
    private TextView dFY;
    public LinearLayout dFZ;
    private List<LevelInfo> dGa;
    private DataRes dGb;
    private C0216a dGc;
    private View duq;
    private NavigationBar mNavigationBar;
    private RelativeLayout mRootView;

    public a(TbTitleActivity tbTitleActivity, View.OnClickListener onClickListener) {
        super(tbTitleActivity.getPageContext());
        this.dGc = new C0216a(new View.OnClickListener() { // from class: com.baidu.tieba.forumMember.tbtitle.a.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(a.this.dFT.getPageContext().getContext()).createNormalCfg(a.this.getPageContext().getString(e.j.tieba_text), "from")));
            }
        });
        this.dFT = tbTitleActivity;
        this.dFO = onClickListener;
        initUI();
    }

    private void initUI() {
        this.mRootView = (RelativeLayout) LayoutInflater.from(this.dFT.getPageContext().getPageActivity()).inflate(e.h.tbtitle_activity, (ViewGroup) null);
        this.dFT.setContentView(this.mRootView);
        this.duq = this.mRootView.findViewById(e.g.top_view);
        if (!j.kK()) {
            this.duq.getLayoutParams().height = UtilHelper.getLightStatusBarHeight() + l.h(this.dFT.getActivity(), e.C0210e.ds170);
        } else {
            this.duq.getLayoutParams().height = UtilHelper.getLightStatusBarHeight() + l.h(this.dFT.getActivity(), e.C0210e.ds88);
        }
        this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(e.g.view_navigation_bar);
        this.mNavigationBar.setCenterTextTitle(this.dFT.getString(e.j.tbtitle_title));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.showBottomLine();
        this.bHu = (ScrollView) this.mRootView.findViewById(e.g.tbtitle_scroll_view);
        this.dFZ = (LinearLayout) this.mRootView.findViewById(e.g.first_line_layout);
        this.dFY = (TextView) this.mRootView.findViewById(e.g.tbtile_like_btn);
        this.dFU = (LinearLayout) this.mRootView.findViewById(e.g.table_canvas);
        this.dFV = (TextView) this.mRootView.findViewById(e.g.user_level_name);
        this.dFW = (ImageView) this.mRootView.findViewById(e.g.header_level_img);
        this.dFX = (TextView) this.mRootView.findViewById(e.g.tbtitle_tip_detail2);
        this.bOx = (NoNetworkView) this.mRootView.findViewById(e.g.view_no_network);
        azC();
        azD();
    }

    private void azC() {
        String string = getPageContext().getResources().getString(e.j.tbtitle_tip_detail2);
        String string2 = getPageContext().getResources().getString(e.j.tbtitle_tip_tieba_bar);
        int length = string2.length();
        int indexOf = string.indexOf(string2);
        SpannableString spannableString = new SpannableString(string);
        spannableString.setSpan(this.dGc, indexOf, length + indexOf, 33);
        this.dFX.setText(spannableString);
        this.dFX.setMovementMethod(LinkMovementMethod.getInstance());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.forumMember.tbtitle.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0216a extends ClickableSpan {
        private View.OnClickListener aHO;

        public C0216a(View.OnClickListener onClickListener) {
            this.aHO = onClickListener;
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            textPaint.setColor(al.getColor(e.d.cp_link_tip_a));
            textPaint.setUnderlineText(false);
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View view) {
            this.aHO.onClick(view);
        }
    }

    public void bA(List<LevelInfo> list) {
        this.dGa = list;
        if (this.dFU != null && this.dGa != null && this.dGa.size() != 0) {
            this.dFU.removeAllViews();
            for (int i = 1; i <= list.size(); i++) {
                LevelInfo levelInfo = list.get(i - 1);
                View inflate = LayoutInflater.from(this.dFT.getPageContext().getContext()).inflate(e.h.tbtitle_table_item, (ViewGroup) null);
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
                this.dFU.addView(inflate);
            }
        }
    }

    public void a(DataRes dataRes) {
        this.dGb = dataRes;
        if (this.dGb != null) {
            if (this.dGb.is_like.intValue() == 1 && this.dFZ != null) {
                this.dFZ.setVisibility(8);
            }
            if (this.dFV != null) {
                if (StringUtils.isNull(this.dGb.level_name, true)) {
                    this.dFV.setText(this.dGb.level_name);
                } else {
                    this.dFV.setVisibility(8);
                }
            }
            if (this.dFW != null) {
                if (this.dGb.user_level.intValue() <= 0 || this.dGb.user_level.intValue() > 18) {
                    this.dFW.setVisibility(8);
                } else {
                    al.c(this.dFW, BitmapHelper.getGradeResourceIdNew(this.dGb.user_level.intValue()));
                }
            }
        }
    }

    private void azD() {
        this.dFY.setOnClickListener(this.dFO);
        this.dFX.setOnClickListener(this.dFO);
    }

    public void ej(int i) {
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(this.dFT.getPageContext(), i);
        }
        if (this.bOx != null) {
            this.bOx.onChangeSkinType(this.dFT.getPageContext(), i);
        }
        bA(this.dGa);
        a(this.dGb);
        this.dFT.getLayoutMode().setNightMode(i == 1);
        this.dFT.getLayoutMode().onModeChanged(this.mRootView);
    }

    public void nU(String str) {
        this.bHu.setVisibility(8);
        this.dFT.showNetRefreshView(this.mRootView, str, true);
        this.dFT.setNetRefreshViewTopMargin(400);
    }

    public void azE() {
        this.bHu.setVisibility(0);
        this.dFT.hideNetRefreshView(this.mRootView);
    }

    public void showLoadingView() {
        this.bHu.setVisibility(8);
        this.dFT.showLoadingView(this.mRootView, true);
    }

    public void azF() {
        this.bHu.setVisibility(0);
        this.dFT.hideLoadingView(this.mRootView);
    }

    public void h(NoNetworkView.a aVar) {
        if (aVar != null) {
            this.bOx.a(aVar);
        }
    }

    public void gn(boolean z) {
        if (!z) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.duq.getLayoutParams();
            layoutParams.height = UtilHelper.getLightStatusBarHeight() + l.h(this.dFT.getActivity(), e.C0210e.ds170);
            this.duq.setLayoutParams(layoutParams);
            return;
        }
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.duq.getLayoutParams();
        layoutParams2.height = UtilHelper.getLightStatusBarHeight() + l.h(this.dFT.getActivity(), e.C0210e.ds88);
        this.duq.setLayoutParams(layoutParams2);
    }
}
