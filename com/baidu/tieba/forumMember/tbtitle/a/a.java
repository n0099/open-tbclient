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
    private NoNetworkView cbj;
    private View.OnClickListener dCD;
    private TbTitleActivity dCJ;
    private ScrollView dCK;
    private LinearLayout dCL;
    private TextView dCM;
    private ImageView dCN;
    private TextView dCO;
    private TextView dCP;
    public LinearLayout dCQ;
    private List<LevelInfo> dCR;
    private DataRes dCS;
    private C0146a dCT;
    private View dvg;
    private NavigationBar mNavigationBar;
    private RelativeLayout mRootView;

    public a(TbTitleActivity tbTitleActivity, View.OnClickListener onClickListener) {
        super(tbTitleActivity.getPageContext());
        this.dCT = new C0146a(new View.OnClickListener() { // from class: com.baidu.tieba.forumMember.tbtitle.a.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(a.this.dCJ.getPageContext().getContext()).createNormalCfg(a.this.getPageContext().getString(d.j.tieba_text), "from")));
            }
        });
        this.dCJ = tbTitleActivity;
        this.dCD = onClickListener;
        initUI();
    }

    private void initUI() {
        this.mRootView = (RelativeLayout) LayoutInflater.from(this.dCJ.getPageContext().getPageActivity()).inflate(d.h.tbtitle_activity, (ViewGroup) null);
        this.dCJ.setContentView(this.mRootView);
        this.dvg = this.mRootView.findViewById(d.g.top_view);
        if (!j.ox()) {
            this.dvg.getLayoutParams().height = UtilHelper.getLightStatusBarHeight() + l.t(this.dCJ.getActivity(), d.e.ds170);
        } else {
            this.dvg.getLayoutParams().height = UtilHelper.getLightStatusBarHeight() + l.t(this.dCJ.getActivity(), d.e.ds88);
        }
        this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(d.g.view_navigation_bar);
        this.mNavigationBar.setCenterTextTitle(this.dCJ.getString(d.j.tbtitle_title));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.showBottomLine();
        this.dCK = (ScrollView) this.mRootView.findViewById(d.g.tbtitle_scroll_view);
        this.dCQ = (LinearLayout) this.mRootView.findViewById(d.g.first_line_layout);
        this.dCP = (TextView) this.mRootView.findViewById(d.g.tbtile_like_btn);
        this.dCL = (LinearLayout) this.mRootView.findViewById(d.g.table_canvas);
        this.dCM = (TextView) this.mRootView.findViewById(d.g.user_level_name);
        this.dCN = (ImageView) this.mRootView.findViewById(d.g.header_level_img);
        this.dCO = (TextView) this.mRootView.findViewById(d.g.tbtitle_tip_detail2);
        this.cbj = (NoNetworkView) this.mRootView.findViewById(d.g.view_no_network);
        aud();
        aue();
    }

    private void aud() {
        String string = getPageContext().getResources().getString(d.j.tbtitle_tip_detail2);
        String string2 = getPageContext().getResources().getString(d.j.tbtitle_tip_tieba_bar);
        int length = string2.length();
        int indexOf = string.indexOf(string2);
        SpannableString spannableString = new SpannableString(string);
        spannableString.setSpan(this.dCT, indexOf, length + indexOf, 33);
        this.dCO.setText(spannableString);
        this.dCO.setMovementMethod(LinkMovementMethod.getInstance());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.forumMember.tbtitle.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0146a extends ClickableSpan {
        private View.OnClickListener bbY;

        public C0146a(View.OnClickListener onClickListener) {
            this.bbY = onClickListener;
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            textPaint.setColor(aj.getColor(d.C0140d.cp_link_tip_a));
            textPaint.setUnderlineText(false);
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View view) {
            this.bbY.onClick(view);
        }
    }

    public void bj(List<LevelInfo> list) {
        this.dCR = list;
        if (this.dCL != null && this.dCR != null && this.dCR.size() != 0) {
            this.dCL.removeAllViews();
            for (int i = 1; i <= list.size(); i++) {
                LevelInfo levelInfo = list.get(i - 1);
                View inflate = LayoutInflater.from(this.dCJ.getPageContext().getContext()).inflate(d.h.tbtitle_table_item, (ViewGroup) null);
                LinearLayout linearLayout = (LinearLayout) inflate.findViewById(d.g.table_item_background);
                TextView textView = (TextView) inflate.findViewById(d.g.table_item_level_name);
                TextView textView2 = (TextView) inflate.findViewById(d.g.table_item_need_experienment);
                View findViewById = inflate.findViewById(d.g.tbtile_item_horizontal_line);
                ImageView imageView = (ImageView) inflate.findViewById(d.g.table_item_level_img);
                if (i % 2 != 0) {
                    aj.s(linearLayout, d.C0140d.cp_bg_line_e);
                }
                aj.e(textView, d.C0140d.cp_cont_b, 1);
                aj.e(textView2, d.C0140d.cp_cont_b, 1);
                aj.t(findViewById, d.C0140d.cp_bg_line_b);
                aj.c(imageView, BitmapHelper.getGradeResourceIdNew(levelInfo.id.intValue()));
                textView.setText(levelInfo.name);
                if (levelInfo.score.intValue() <= 3000000 && levelInfo.score.intValue() > 0) {
                    textView2.setText(levelInfo.score + "");
                } else if (levelInfo.score.intValue() <= 0) {
                    textView2.setText("0");
                } else {
                    textView2.setText("3000000");
                }
                this.dCL.addView(inflate);
            }
        }
    }

    public void a(DataRes dataRes) {
        this.dCS = dataRes;
        if (this.dCS != null) {
            if (this.dCS.is_like.intValue() == 1 && this.dCQ != null) {
                this.dCQ.setVisibility(8);
            }
            if (this.dCM != null) {
                if (StringUtils.isNull(this.dCS.level_name, true)) {
                    this.dCM.setText(this.dCS.level_name);
                } else {
                    this.dCM.setVisibility(8);
                }
            }
            if (this.dCN != null) {
                if (this.dCS.user_level.intValue() <= 0 || this.dCS.user_level.intValue() > 18) {
                    this.dCN.setVisibility(8);
                } else {
                    aj.c(this.dCN, BitmapHelper.getGradeResourceIdNew(this.dCS.user_level.intValue()));
                }
            }
        }
    }

    private void aue() {
        this.dCP.setOnClickListener(this.dCD);
        this.dCO.setOnClickListener(this.dCD);
    }

    public void gi(int i) {
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(this.dCJ.getPageContext(), i);
        }
        if (this.cbj != null) {
            this.cbj.onChangeSkinType(this.dCJ.getPageContext(), i);
        }
        bj(this.dCR);
        a(this.dCS);
        this.dCJ.getLayoutMode().aQ(i == 1);
        this.dCJ.getLayoutMode().aM(this.mRootView);
    }

    public void lC(String str) {
        this.dCK.setVisibility(8);
        this.dCJ.showNetRefreshView(this.mRootView, str, true);
        this.dCJ.setNetRefreshViewTopMargin(HttpStatus.SC_BAD_REQUEST);
    }

    public void auf() {
        this.dCK.setVisibility(0);
        this.dCJ.hideNetRefreshView(this.mRootView);
    }

    public void VU() {
        this.dCK.setVisibility(8);
        this.dCJ.showLoadingView(this.mRootView, true);
    }

    public void aug() {
        this.dCK.setVisibility(0);
        this.dCJ.hideLoadingView(this.mRootView);
    }

    public void h(NoNetworkView.a aVar) {
        if (aVar != null) {
            this.cbj.a(aVar);
        }
    }

    public void fH(boolean z) {
        if (!z) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.dvg.getLayoutParams();
            layoutParams.height = UtilHelper.getLightStatusBarHeight() + l.t(this.dCJ.getActivity(), d.e.ds170);
            this.dvg.setLayoutParams(layoutParams);
            return;
        }
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.dvg.getLayoutParams();
        layoutParams2.height = UtilHelper.getLightStatusBarHeight() + l.t(this.dCJ.getActivity(), d.e.ds88);
        this.dvg.setLayoutParams(layoutParams2);
    }
}
