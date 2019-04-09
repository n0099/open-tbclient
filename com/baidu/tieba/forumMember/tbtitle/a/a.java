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
    private ScrollView aYH;
    private NoNetworkView dbr;
    private View eKQ;
    public LinearLayout eWA;
    private List<LevelInfo> eWB;
    private DataRes eWC;
    private C0286a eWD;
    private View.OnClickListener eWp;
    private TbTitleActivity eWu;
    private LinearLayout eWv;
    private TextView eWw;
    private ImageView eWx;
    private TextView eWy;
    private TextView eWz;
    private NavigationBar mNavigationBar;
    private RelativeLayout mRootView;

    public a(TbTitleActivity tbTitleActivity, View.OnClickListener onClickListener) {
        super(tbTitleActivity.getPageContext());
        this.eWD = new C0286a(new View.OnClickListener() { // from class: com.baidu.tieba.forumMember.tbtitle.a.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(a.this.eWu.getPageContext().getContext()).createNormalCfg(a.this.getPageContext().getString(d.j.tieba_text), "from")));
            }
        });
        this.eWu = tbTitleActivity;
        this.eWp = onClickListener;
        initUI();
    }

    private void initUI() {
        this.mRootView = (RelativeLayout) LayoutInflater.from(this.eWu.getPageContext().getPageActivity()).inflate(d.h.tbtitle_activity, (ViewGroup) null);
        this.eWu.setContentView(this.mRootView);
        this.eKQ = this.mRootView.findViewById(d.g.top_view);
        if (!j.kM()) {
            this.eKQ.getLayoutParams().height = UtilHelper.getLightStatusBarHeight() + l.h(this.eWu.getActivity(), d.e.ds170);
        } else {
            this.eKQ.getLayoutParams().height = UtilHelper.getLightStatusBarHeight() + l.h(this.eWu.getActivity(), d.e.ds88);
        }
        this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(d.g.view_navigation_bar);
        this.mNavigationBar.setCenterTextTitle(this.eWu.getString(d.j.tbtitle_title));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.showBottomLine();
        this.aYH = (ScrollView) this.mRootView.findViewById(d.g.tbtitle_scroll_view);
        this.eWA = (LinearLayout) this.mRootView.findViewById(d.g.first_line_layout);
        this.eWz = (TextView) this.mRootView.findViewById(d.g.tbtile_like_btn);
        this.eWv = (LinearLayout) this.mRootView.findViewById(d.g.table_canvas);
        this.eWw = (TextView) this.mRootView.findViewById(d.g.user_level_name);
        this.eWx = (ImageView) this.mRootView.findViewById(d.g.header_level_img);
        this.eWy = (TextView) this.mRootView.findViewById(d.g.tbtitle_tip_detail2);
        this.dbr = (NoNetworkView) this.mRootView.findViewById(d.g.view_no_network);
        bbl();
        bbm();
    }

    private void bbl() {
        String string = getPageContext().getResources().getString(d.j.tbtitle_tip_detail2);
        String string2 = getPageContext().getResources().getString(d.j.tbtitle_tip_tieba_bar);
        int length = string2.length();
        int indexOf = string.indexOf(string2);
        SpannableString spannableString = new SpannableString(string);
        spannableString.setSpan(this.eWD, indexOf, length + indexOf, 33);
        this.eWy.setText(spannableString);
        this.eWy.setMovementMethod(LinkMovementMethod.getInstance());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.forumMember.tbtitle.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class C0286a extends ClickableSpan {
        private View.OnClickListener bQN;

        public C0286a(View.OnClickListener onClickListener) {
            this.bQN = onClickListener;
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            textPaint.setColor(al.getColor(d.C0277d.cp_link_tip_a));
            textPaint.setUnderlineText(false);
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View view) {
            this.bQN.onClick(view);
        }
    }

    public void bN(List<LevelInfo> list) {
        this.eWB = list;
        if (this.eWv != null && this.eWB != null && this.eWB.size() != 0) {
            this.eWv.removeAllViews();
            for (int i = 1; i <= list.size(); i++) {
                LevelInfo levelInfo = list.get(i - 1);
                View inflate = LayoutInflater.from(this.eWu.getPageContext().getContext()).inflate(d.h.tbtitle_table_item, (ViewGroup) null);
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
                this.eWv.addView(inflate);
            }
        }
    }

    public void a(DataRes dataRes) {
        this.eWC = dataRes;
        if (this.eWC != null) {
            if (this.eWC.is_like.intValue() == 1 && this.eWA != null) {
                this.eWA.setVisibility(8);
            }
            if (this.eWw != null) {
                if (StringUtils.isNull(this.eWC.level_name, true)) {
                    this.eWw.setText(this.eWC.level_name);
                } else {
                    this.eWw.setVisibility(8);
                }
            }
            if (this.eWx != null) {
                if (this.eWC.user_level.intValue() <= 0 || this.eWC.user_level.intValue() > 18) {
                    this.eWx.setVisibility(8);
                } else {
                    al.c(this.eWx, BitmapHelper.getGradeResourceIdNew(this.eWC.user_level.intValue()));
                }
            }
        }
    }

    private void bbm() {
        this.eWz.setOnClickListener(this.eWp);
        this.eWy.setOnClickListener(this.eWp);
    }

    public void hM(int i) {
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(this.eWu.getPageContext(), i);
        }
        if (this.dbr != null) {
            this.dbr.onChangeSkinType(this.eWu.getPageContext(), i);
        }
        bN(this.eWB);
        a(this.eWC);
        this.eWu.getLayoutMode().setNightMode(i == 1);
        this.eWu.getLayoutMode().onModeChanged(this.mRootView);
    }

    public void uR(String str) {
        this.aYH.setVisibility(8);
        this.eWu.showNetRefreshView(this.mRootView, str, true);
        this.eWu.setNetRefreshViewTopMargin(400);
    }

    public void bbn() {
        this.aYH.setVisibility(0);
        this.eWu.hideNetRefreshView(this.mRootView);
    }

    public void showLoadingView() {
        this.aYH.setVisibility(8);
        this.eWu.showLoadingView(this.mRootView, true);
    }

    public void bbo() {
        this.aYH.setVisibility(0);
        this.eWu.hideLoadingView(this.mRootView);
    }

    public void h(NoNetworkView.a aVar) {
        if (aVar != null) {
            this.dbr.a(aVar);
        }
    }

    public void iP(boolean z) {
        if (!z) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.eKQ.getLayoutParams();
            layoutParams.height = UtilHelper.getLightStatusBarHeight() + l.h(this.eWu.getActivity(), d.e.ds170);
            this.eKQ.setLayoutParams(layoutParams);
            return;
        }
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.eKQ.getLayoutParams();
        layoutParams2.height = UtilHelper.getLightStatusBarHeight() + l.h(this.eWu.getActivity(), d.e.ds88);
        this.eKQ.setLayoutParams(layoutParams2);
    }
}
