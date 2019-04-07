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
import com.baidu.tieba.d;
import com.baidu.tieba.forumMember.tbtitle.TbTitleActivity;
import java.util.List;
import tbclient.GetLevelInfo.DataRes;
import tbclient.LevelInfo;
/* loaded from: classes5.dex */
public class a extends c<TbTitleActivity> {
    private ScrollView aYG;
    private NoNetworkView dbq;
    private View eKP;
    private List<LevelInfo> eWA;
    private DataRes eWB;
    private C0286a eWC;
    private View.OnClickListener eWo;
    private TbTitleActivity eWt;
    private LinearLayout eWu;
    private TextView eWv;
    private ImageView eWw;
    private TextView eWx;
    private TextView eWy;
    public LinearLayout eWz;
    private NavigationBar mNavigationBar;
    private RelativeLayout mRootView;

    public a(TbTitleActivity tbTitleActivity, View.OnClickListener onClickListener) {
        super(tbTitleActivity.getPageContext());
        this.eWC = new C0286a(new View.OnClickListener() { // from class: com.baidu.tieba.forumMember.tbtitle.a.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(a.this.eWt.getPageContext().getContext()).createNormalCfg(a.this.getPageContext().getString(d.j.tieba_text), "from")));
            }
        });
        this.eWt = tbTitleActivity;
        this.eWo = onClickListener;
        initUI();
    }

    private void initUI() {
        this.mRootView = (RelativeLayout) LayoutInflater.from(this.eWt.getPageContext().getPageActivity()).inflate(d.h.tbtitle_activity, (ViewGroup) null);
        this.eWt.setContentView(this.mRootView);
        this.eKP = this.mRootView.findViewById(d.g.top_view);
        if (!j.kM()) {
            this.eKP.getLayoutParams().height = UtilHelper.getLightStatusBarHeight() + l.h(this.eWt.getActivity(), d.e.ds170);
        } else {
            this.eKP.getLayoutParams().height = UtilHelper.getLightStatusBarHeight() + l.h(this.eWt.getActivity(), d.e.ds88);
        }
        this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(d.g.view_navigation_bar);
        this.mNavigationBar.setCenterTextTitle(this.eWt.getString(d.j.tbtitle_title));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.showBottomLine();
        this.aYG = (ScrollView) this.mRootView.findViewById(d.g.tbtitle_scroll_view);
        this.eWz = (LinearLayout) this.mRootView.findViewById(d.g.first_line_layout);
        this.eWy = (TextView) this.mRootView.findViewById(d.g.tbtile_like_btn);
        this.eWu = (LinearLayout) this.mRootView.findViewById(d.g.table_canvas);
        this.eWv = (TextView) this.mRootView.findViewById(d.g.user_level_name);
        this.eWw = (ImageView) this.mRootView.findViewById(d.g.header_level_img);
        this.eWx = (TextView) this.mRootView.findViewById(d.g.tbtitle_tip_detail2);
        this.dbq = (NoNetworkView) this.mRootView.findViewById(d.g.view_no_network);
        bbl();
        bbm();
    }

    private void bbl() {
        String string = getPageContext().getResources().getString(d.j.tbtitle_tip_detail2);
        String string2 = getPageContext().getResources().getString(d.j.tbtitle_tip_tieba_bar);
        int length = string2.length();
        int indexOf = string.indexOf(string2);
        SpannableString spannableString = new SpannableString(string);
        spannableString.setSpan(this.eWC, indexOf, length + indexOf, 33);
        this.eWx.setText(spannableString);
        this.eWx.setMovementMethod(LinkMovementMethod.getInstance());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.forumMember.tbtitle.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class C0286a extends ClickableSpan {
        private View.OnClickListener bQM;

        public C0286a(View.OnClickListener onClickListener) {
            this.bQM = onClickListener;
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            textPaint.setColor(al.getColor(d.C0277d.cp_link_tip_a));
            textPaint.setUnderlineText(false);
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View view) {
            this.bQM.onClick(view);
        }
    }

    public void bN(List<LevelInfo> list) {
        this.eWA = list;
        if (this.eWu != null && this.eWA != null && this.eWA.size() != 0) {
            this.eWu.removeAllViews();
            for (int i = 1; i <= list.size(); i++) {
                LevelInfo levelInfo = list.get(i - 1);
                View inflate = LayoutInflater.from(this.eWt.getPageContext().getContext()).inflate(d.h.tbtitle_table_item, (ViewGroup) null);
                LinearLayout linearLayout = (LinearLayout) inflate.findViewById(d.g.table_item_background);
                TextView textView = (TextView) inflate.findViewById(d.g.table_item_level_name);
                TextView textView2 = (TextView) inflate.findViewById(d.g.table_item_need_experienment);
                View findViewById = inflate.findViewById(d.g.tbtile_item_horizontal_line);
                ImageView imageView = (ImageView) inflate.findViewById(d.g.table_item_level_img);
                if (i % 2 != 0) {
                    al.k(linearLayout, d.C0277d.cp_bg_line_e);
                }
                al.d(textView, d.C0277d.cp_cont_b, 1);
                al.d(textView2, d.C0277d.cp_cont_b, 1);
                al.l(findViewById, d.C0277d.cp_bg_line_b);
                al.c(imageView, BitmapHelper.getGradeResourceIdNew(levelInfo.id.intValue()));
                textView.setText(levelInfo.name);
                if (levelInfo.score.intValue() <= 3000000 && levelInfo.score.intValue() > 0) {
                    textView2.setText(levelInfo.score + "");
                } else if (levelInfo.score.intValue() <= 0) {
                    textView2.setText("0");
                } else {
                    textView2.setText("3000000");
                }
                this.eWu.addView(inflate);
            }
        }
    }

    public void a(DataRes dataRes) {
        this.eWB = dataRes;
        if (this.eWB != null) {
            if (this.eWB.is_like.intValue() == 1 && this.eWz != null) {
                this.eWz.setVisibility(8);
            }
            if (this.eWv != null) {
                if (StringUtils.isNull(this.eWB.level_name, true)) {
                    this.eWv.setText(this.eWB.level_name);
                } else {
                    this.eWv.setVisibility(8);
                }
            }
            if (this.eWw != null) {
                if (this.eWB.user_level.intValue() <= 0 || this.eWB.user_level.intValue() > 18) {
                    this.eWw.setVisibility(8);
                } else {
                    al.c(this.eWw, BitmapHelper.getGradeResourceIdNew(this.eWB.user_level.intValue()));
                }
            }
        }
    }

    private void bbm() {
        this.eWy.setOnClickListener(this.eWo);
        this.eWx.setOnClickListener(this.eWo);
    }

    public void hM(int i) {
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(this.eWt.getPageContext(), i);
        }
        if (this.dbq != null) {
            this.dbq.onChangeSkinType(this.eWt.getPageContext(), i);
        }
        bN(this.eWA);
        a(this.eWB);
        this.eWt.getLayoutMode().setNightMode(i == 1);
        this.eWt.getLayoutMode().onModeChanged(this.mRootView);
    }

    public void uR(String str) {
        this.aYG.setVisibility(8);
        this.eWt.showNetRefreshView(this.mRootView, str, true);
        this.eWt.setNetRefreshViewTopMargin(400);
    }

    public void bbn() {
        this.aYG.setVisibility(0);
        this.eWt.hideNetRefreshView(this.mRootView);
    }

    public void showLoadingView() {
        this.aYG.setVisibility(8);
        this.eWt.showLoadingView(this.mRootView, true);
    }

    public void bbo() {
        this.aYG.setVisibility(0);
        this.eWt.hideLoadingView(this.mRootView);
    }

    public void h(NoNetworkView.a aVar) {
        if (aVar != null) {
            this.dbq.a(aVar);
        }
    }

    public void iP(boolean z) {
        if (!z) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.eKP.getLayoutParams();
            layoutParams.height = UtilHelper.getLightStatusBarHeight() + l.h(this.eWt.getActivity(), d.e.ds170);
            this.eKP.setLayoutParams(layoutParams);
            return;
        }
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.eKP.getLayoutParams();
        layoutParams2.height = UtilHelper.getLightStatusBarHeight() + l.h(this.eWt.getActivity(), d.e.ds88);
        this.eKP.setLayoutParams(layoutParams2);
    }
}
