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
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tieba.d;
import com.baidu.tieba.forumMember.tbtitle.TbTitleActivity;
import java.util.List;
import org.apache.http.HttpStatus;
import tbclient.GetLevelInfo.DataRes;
import tbclient.LevelInfo;
/* loaded from: classes3.dex */
public class a extends c<TbTitleActivity> {
    private NoNetworkView cba;
    private TbTitleActivity dCA;
    private ScrollView dCB;
    private LinearLayout dCC;
    private TextView dCD;
    private ImageView dCE;
    private TextView dCF;
    private TextView dCG;
    public LinearLayout dCH;
    private List<LevelInfo> dCI;
    private DataRes dCJ;
    private C0147a dCK;
    private View.OnClickListener dCu;
    private View duX;
    private NavigationBar mNavigationBar;
    private RelativeLayout mRootView;

    public a(TbTitleActivity tbTitleActivity, View.OnClickListener onClickListener) {
        super(tbTitleActivity.getPageContext());
        this.dCK = new C0147a(new View.OnClickListener() { // from class: com.baidu.tieba.forumMember.tbtitle.a.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(a.this.dCA.getPageContext().getContext()).createNormalCfg(a.this.getPageContext().getString(d.j.tieba_text), "from")));
            }
        });
        this.dCA = tbTitleActivity;
        this.dCu = onClickListener;
        initUI();
    }

    private void initUI() {
        this.mRootView = (RelativeLayout) LayoutInflater.from(this.dCA.getPageContext().getPageActivity()).inflate(d.h.tbtitle_activity, (ViewGroup) null);
        this.dCA.setContentView(this.mRootView);
        this.duX = this.mRootView.findViewById(d.g.top_view);
        if (!j.ox()) {
            this.duX.getLayoutParams().height = UtilHelper.getLightStatusBarHeight() + l.t(this.dCA.getActivity(), d.e.ds170);
        } else {
            this.duX.getLayoutParams().height = UtilHelper.getLightStatusBarHeight() + l.t(this.dCA.getActivity(), d.e.ds88);
        }
        this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(d.g.view_navigation_bar);
        this.mNavigationBar.setCenterTextTitle(this.dCA.getString(d.j.tbtitle_title));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.showBottomLine();
        this.dCB = (ScrollView) this.mRootView.findViewById(d.g.tbtitle_scroll_view);
        this.dCH = (LinearLayout) this.mRootView.findViewById(d.g.first_line_layout);
        this.dCG = (TextView) this.mRootView.findViewById(d.g.tbtile_like_btn);
        this.dCC = (LinearLayout) this.mRootView.findViewById(d.g.table_canvas);
        this.dCD = (TextView) this.mRootView.findViewById(d.g.user_level_name);
        this.dCE = (ImageView) this.mRootView.findViewById(d.g.header_level_img);
        this.dCF = (TextView) this.mRootView.findViewById(d.g.tbtitle_tip_detail2);
        this.cba = (NoNetworkView) this.mRootView.findViewById(d.g.view_no_network);
        aud();
        aue();
    }

    private void aud() {
        String string = getPageContext().getResources().getString(d.j.tbtitle_tip_detail2);
        String string2 = getPageContext().getResources().getString(d.j.tbtitle_tip_tieba_bar);
        int length = string2.length();
        int indexOf = string.indexOf(string2);
        SpannableString spannableString = new SpannableString(string);
        spannableString.setSpan(this.dCK, indexOf, length + indexOf, 33);
        this.dCF.setText(spannableString);
        this.dCF.setMovementMethod(LinkMovementMethod.getInstance());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.forumMember.tbtitle.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0147a extends ClickableSpan {
        private View.OnClickListener bbO;

        public C0147a(View.OnClickListener onClickListener) {
            this.bbO = onClickListener;
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            textPaint.setColor(aj.getColor(d.C0141d.cp_link_tip_a));
            textPaint.setUnderlineText(false);
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View view) {
            this.bbO.onClick(view);
        }
    }

    public void bj(List<LevelInfo> list) {
        this.dCI = list;
        if (this.dCC != null && this.dCI != null && this.dCI.size() != 0) {
            this.dCC.removeAllViews();
            for (int i = 1; i <= list.size(); i++) {
                LevelInfo levelInfo = list.get(i - 1);
                View inflate = LayoutInflater.from(this.dCA.getPageContext().getContext()).inflate(d.h.tbtitle_table_item, (ViewGroup) null);
                LinearLayout linearLayout = (LinearLayout) inflate.findViewById(d.g.table_item_background);
                TextView textView = (TextView) inflate.findViewById(d.g.table_item_level_name);
                TextView textView2 = (TextView) inflate.findViewById(d.g.table_item_need_experienment);
                View findViewById = inflate.findViewById(d.g.tbtile_item_horizontal_line);
                ImageView imageView = (ImageView) inflate.findViewById(d.g.table_item_level_img);
                if (i % 2 != 0) {
                    aj.s(linearLayout, d.C0141d.cp_bg_line_e);
                }
                aj.e(textView, d.C0141d.cp_cont_b, 1);
                aj.e(textView2, d.C0141d.cp_cont_b, 1);
                aj.t(findViewById, d.C0141d.cp_bg_line_b);
                aj.c(imageView, BitmapHelper.getGradeResourceIdNew(levelInfo.id.intValue()));
                textView.setText(levelInfo.name);
                if (levelInfo.score.intValue() <= 3000000 && levelInfo.score.intValue() > 0) {
                    textView2.setText(levelInfo.score + "");
                } else if (levelInfo.score.intValue() <= 0) {
                    textView2.setText("0");
                } else {
                    textView2.setText("3000000");
                }
                this.dCC.addView(inflate);
            }
        }
    }

    public void a(DataRes dataRes) {
        this.dCJ = dataRes;
        if (this.dCJ != null) {
            if (this.dCJ.is_like.intValue() == 1 && this.dCH != null) {
                this.dCH.setVisibility(8);
            }
            if (this.dCD != null) {
                if (StringUtils.isNull(this.dCJ.level_name, true)) {
                    this.dCD.setText(this.dCJ.level_name);
                } else {
                    this.dCD.setVisibility(8);
                }
            }
            if (this.dCE != null) {
                if (this.dCJ.user_level.intValue() <= 0 || this.dCJ.user_level.intValue() > 18) {
                    this.dCE.setVisibility(8);
                } else {
                    aj.c(this.dCE, BitmapHelper.getGradeResourceIdNew(this.dCJ.user_level.intValue()));
                }
            }
        }
    }

    private void aue() {
        this.dCG.setOnClickListener(this.dCu);
        this.dCF.setOnClickListener(this.dCu);
    }

    public void gi(int i) {
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(this.dCA.getPageContext(), i);
        }
        if (this.cba != null) {
            this.cba.onChangeSkinType(this.dCA.getPageContext(), i);
        }
        bj(this.dCI);
        a(this.dCJ);
        this.dCA.getLayoutMode().aQ(i == 1);
        this.dCA.getLayoutMode().aM(this.mRootView);
    }

    public void lC(String str) {
        this.dCB.setVisibility(8);
        this.dCA.showNetRefreshView(this.mRootView, str, true);
        this.dCA.setNetRefreshViewTopMargin(HttpStatus.SC_BAD_REQUEST);
    }

    public void auf() {
        this.dCB.setVisibility(0);
        this.dCA.hideNetRefreshView(this.mRootView);
    }

    public void VU() {
        this.dCB.setVisibility(8);
        this.dCA.showLoadingView(this.mRootView, true);
    }

    public void aug() {
        this.dCB.setVisibility(0);
        this.dCA.hideLoadingView(this.mRootView);
    }

    public void h(NoNetworkView.a aVar) {
        if (aVar != null) {
            this.cba.a(aVar);
        }
    }

    public void fH(boolean z) {
        if (!z) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.duX.getLayoutParams();
            layoutParams.height = UtilHelper.getLightStatusBarHeight() + l.t(this.dCA.getActivity(), d.e.ds170);
            this.duX.setLayoutParams(layoutParams);
            return;
        }
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.duX.getLayoutParams();
        layoutParams2.height = UtilHelper.getLightStatusBarHeight() + l.t(this.dCA.getActivity(), d.e.ds88);
        this.duX.setLayoutParams(layoutParams2);
    }
}
