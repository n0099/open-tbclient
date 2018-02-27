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
    private NoNetworkView caX;
    private TextView dCA;
    private ImageView dCB;
    private TextView dCC;
    private TextView dCD;
    public LinearLayout dCE;
    private List<LevelInfo> dCF;
    private DataRes dCG;
    private C0147a dCH;
    private View.OnClickListener dCr;
    private TbTitleActivity dCx;
    private ScrollView dCy;
    private LinearLayout dCz;
    private View duU;
    private NavigationBar mNavigationBar;
    private RelativeLayout mRootView;

    public a(TbTitleActivity tbTitleActivity, View.OnClickListener onClickListener) {
        super(tbTitleActivity.getPageContext());
        this.dCH = new C0147a(new View.OnClickListener() { // from class: com.baidu.tieba.forumMember.tbtitle.a.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(a.this.dCx.getPageContext().getContext()).createNormalCfg(a.this.getPageContext().getString(d.j.tieba_text), "from")));
            }
        });
        this.dCx = tbTitleActivity;
        this.dCr = onClickListener;
        initUI();
    }

    private void initUI() {
        this.mRootView = (RelativeLayout) LayoutInflater.from(this.dCx.getPageContext().getPageActivity()).inflate(d.h.tbtitle_activity, (ViewGroup) null);
        this.dCx.setContentView(this.mRootView);
        this.duU = this.mRootView.findViewById(d.g.top_view);
        if (!j.ox()) {
            this.duU.getLayoutParams().height = UtilHelper.getLightStatusBarHeight() + l.t(this.dCx.getActivity(), d.e.ds170);
        } else {
            this.duU.getLayoutParams().height = UtilHelper.getLightStatusBarHeight() + l.t(this.dCx.getActivity(), d.e.ds88);
        }
        this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(d.g.view_navigation_bar);
        this.mNavigationBar.setCenterTextTitle(this.dCx.getString(d.j.tbtitle_title));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.showBottomLine();
        this.dCy = (ScrollView) this.mRootView.findViewById(d.g.tbtitle_scroll_view);
        this.dCE = (LinearLayout) this.mRootView.findViewById(d.g.first_line_layout);
        this.dCD = (TextView) this.mRootView.findViewById(d.g.tbtile_like_btn);
        this.dCz = (LinearLayout) this.mRootView.findViewById(d.g.table_canvas);
        this.dCA = (TextView) this.mRootView.findViewById(d.g.user_level_name);
        this.dCB = (ImageView) this.mRootView.findViewById(d.g.header_level_img);
        this.dCC = (TextView) this.mRootView.findViewById(d.g.tbtitle_tip_detail2);
        this.caX = (NoNetworkView) this.mRootView.findViewById(d.g.view_no_network);
        auc();
        aud();
    }

    private void auc() {
        String string = getPageContext().getResources().getString(d.j.tbtitle_tip_detail2);
        String string2 = getPageContext().getResources().getString(d.j.tbtitle_tip_tieba_bar);
        int length = string2.length();
        int indexOf = string.indexOf(string2);
        SpannableString spannableString = new SpannableString(string);
        spannableString.setSpan(this.dCH, indexOf, length + indexOf, 33);
        this.dCC.setText(spannableString);
        this.dCC.setMovementMethod(LinkMovementMethod.getInstance());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.forumMember.tbtitle.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0147a extends ClickableSpan {
        private View.OnClickListener bbM;

        public C0147a(View.OnClickListener onClickListener) {
            this.bbM = onClickListener;
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            textPaint.setColor(aj.getColor(d.C0141d.cp_link_tip_a));
            textPaint.setUnderlineText(false);
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View view) {
            this.bbM.onClick(view);
        }
    }

    public void bj(List<LevelInfo> list) {
        this.dCF = list;
        if (this.dCz != null && this.dCF != null && this.dCF.size() != 0) {
            this.dCz.removeAllViews();
            for (int i = 1; i <= list.size(); i++) {
                LevelInfo levelInfo = list.get(i - 1);
                View inflate = LayoutInflater.from(this.dCx.getPageContext().getContext()).inflate(d.h.tbtitle_table_item, (ViewGroup) null);
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
                this.dCz.addView(inflate);
            }
        }
    }

    public void a(DataRes dataRes) {
        this.dCG = dataRes;
        if (this.dCG != null) {
            if (this.dCG.is_like.intValue() == 1 && this.dCE != null) {
                this.dCE.setVisibility(8);
            }
            if (this.dCA != null) {
                if (StringUtils.isNull(this.dCG.level_name, true)) {
                    this.dCA.setText(this.dCG.level_name);
                } else {
                    this.dCA.setVisibility(8);
                }
            }
            if (this.dCB != null) {
                if (this.dCG.user_level.intValue() <= 0 || this.dCG.user_level.intValue() > 18) {
                    this.dCB.setVisibility(8);
                } else {
                    aj.c(this.dCB, BitmapHelper.getGradeResourceIdNew(this.dCG.user_level.intValue()));
                }
            }
        }
    }

    private void aud() {
        this.dCD.setOnClickListener(this.dCr);
        this.dCC.setOnClickListener(this.dCr);
    }

    public void gi(int i) {
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(this.dCx.getPageContext(), i);
        }
        if (this.caX != null) {
            this.caX.onChangeSkinType(this.dCx.getPageContext(), i);
        }
        bj(this.dCF);
        a(this.dCG);
        this.dCx.getLayoutMode().aQ(i == 1);
        this.dCx.getLayoutMode().aM(this.mRootView);
    }

    public void lC(String str) {
        this.dCy.setVisibility(8);
        this.dCx.showNetRefreshView(this.mRootView, str, true);
        this.dCx.setNetRefreshViewTopMargin(HttpStatus.SC_BAD_REQUEST);
    }

    public void aue() {
        this.dCy.setVisibility(0);
        this.dCx.hideNetRefreshView(this.mRootView);
    }

    public void VT() {
        this.dCy.setVisibility(8);
        this.dCx.showLoadingView(this.mRootView, true);
    }

    public void auf() {
        this.dCy.setVisibility(0);
        this.dCx.hideLoadingView(this.mRootView);
    }

    public void h(NoNetworkView.a aVar) {
        if (aVar != null) {
            this.caX.a(aVar);
        }
    }

    public void fH(boolean z) {
        if (!z) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.duU.getLayoutParams();
            layoutParams.height = UtilHelper.getLightStatusBarHeight() + l.t(this.dCx.getActivity(), d.e.ds170);
            this.duU.setLayoutParams(layoutParams);
            return;
        }
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.duU.getLayoutParams();
        layoutParams2.height = UtilHelper.getLightStatusBarHeight() + l.t(this.dCx.getActivity(), d.e.ds88);
        this.duU.setLayoutParams(layoutParams2);
    }
}
