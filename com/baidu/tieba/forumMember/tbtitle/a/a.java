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
    private ScrollView aYD;
    private NoNetworkView dbm;
    private View eLd;
    private View.OnClickListener eWC;
    private TbTitleActivity eWH;
    private LinearLayout eWI;
    private TextView eWJ;
    private ImageView eWK;
    private TextView eWL;
    private TextView eWM;
    public LinearLayout eWN;
    private List<LevelInfo> eWO;
    private DataRes eWP;
    private C0286a eWQ;
    private NavigationBar mNavigationBar;
    private RelativeLayout mRootView;

    public a(TbTitleActivity tbTitleActivity, View.OnClickListener onClickListener) {
        super(tbTitleActivity.getPageContext());
        this.eWQ = new C0286a(new View.OnClickListener() { // from class: com.baidu.tieba.forumMember.tbtitle.a.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(a.this.eWH.getPageContext().getContext()).createNormalCfg(a.this.getPageContext().getString(d.j.tieba_text), "from")));
            }
        });
        this.eWH = tbTitleActivity;
        this.eWC = onClickListener;
        initUI();
    }

    private void initUI() {
        this.mRootView = (RelativeLayout) LayoutInflater.from(this.eWH.getPageContext().getPageActivity()).inflate(d.h.tbtitle_activity, (ViewGroup) null);
        this.eWH.setContentView(this.mRootView);
        this.eLd = this.mRootView.findViewById(d.g.top_view);
        if (!j.kM()) {
            this.eLd.getLayoutParams().height = UtilHelper.getLightStatusBarHeight() + l.h(this.eWH.getActivity(), d.e.ds170);
        } else {
            this.eLd.getLayoutParams().height = UtilHelper.getLightStatusBarHeight() + l.h(this.eWH.getActivity(), d.e.ds88);
        }
        this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(d.g.view_navigation_bar);
        this.mNavigationBar.setCenterTextTitle(this.eWH.getString(d.j.tbtitle_title));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.showBottomLine();
        this.aYD = (ScrollView) this.mRootView.findViewById(d.g.tbtitle_scroll_view);
        this.eWN = (LinearLayout) this.mRootView.findViewById(d.g.first_line_layout);
        this.eWM = (TextView) this.mRootView.findViewById(d.g.tbtile_like_btn);
        this.eWI = (LinearLayout) this.mRootView.findViewById(d.g.table_canvas);
        this.eWJ = (TextView) this.mRootView.findViewById(d.g.user_level_name);
        this.eWK = (ImageView) this.mRootView.findViewById(d.g.header_level_img);
        this.eWL = (TextView) this.mRootView.findViewById(d.g.tbtitle_tip_detail2);
        this.dbm = (NoNetworkView) this.mRootView.findViewById(d.g.view_no_network);
        bbn();
        bbo();
    }

    private void bbn() {
        String string = getPageContext().getResources().getString(d.j.tbtitle_tip_detail2);
        String string2 = getPageContext().getResources().getString(d.j.tbtitle_tip_tieba_bar);
        int length = string2.length();
        int indexOf = string.indexOf(string2);
        SpannableString spannableString = new SpannableString(string);
        spannableString.setSpan(this.eWQ, indexOf, length + indexOf, 33);
        this.eWL.setText(spannableString);
        this.eWL.setMovementMethod(LinkMovementMethod.getInstance());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.forumMember.tbtitle.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class C0286a extends ClickableSpan {
        private View.OnClickListener bQK;

        public C0286a(View.OnClickListener onClickListener) {
            this.bQK = onClickListener;
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            textPaint.setColor(al.getColor(d.C0277d.cp_link_tip_a));
            textPaint.setUnderlineText(false);
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View view) {
            this.bQK.onClick(view);
        }
    }

    public void bP(List<LevelInfo> list) {
        this.eWO = list;
        if (this.eWI != null && this.eWO != null && this.eWO.size() != 0) {
            this.eWI.removeAllViews();
            for (int i = 1; i <= list.size(); i++) {
                LevelInfo levelInfo = list.get(i - 1);
                View inflate = LayoutInflater.from(this.eWH.getPageContext().getContext()).inflate(d.h.tbtitle_table_item, (ViewGroup) null);
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
                this.eWI.addView(inflate);
            }
        }
    }

    public void a(DataRes dataRes) {
        this.eWP = dataRes;
        if (this.eWP != null) {
            if (this.eWP.is_like.intValue() == 1 && this.eWN != null) {
                this.eWN.setVisibility(8);
            }
            if (this.eWJ != null) {
                if (StringUtils.isNull(this.eWP.level_name, true)) {
                    this.eWJ.setText(this.eWP.level_name);
                } else {
                    this.eWJ.setVisibility(8);
                }
            }
            if (this.eWK != null) {
                if (this.eWP.user_level.intValue() <= 0 || this.eWP.user_level.intValue() > 18) {
                    this.eWK.setVisibility(8);
                } else {
                    al.c(this.eWK, BitmapHelper.getGradeResourceIdNew(this.eWP.user_level.intValue()));
                }
            }
        }
    }

    private void bbo() {
        this.eWM.setOnClickListener(this.eWC);
        this.eWL.setOnClickListener(this.eWC);
    }

    public void hN(int i) {
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(this.eWH.getPageContext(), i);
        }
        if (this.dbm != null) {
            this.dbm.onChangeSkinType(this.eWH.getPageContext(), i);
        }
        bP(this.eWO);
        a(this.eWP);
        this.eWH.getLayoutMode().setNightMode(i == 1);
        this.eWH.getLayoutMode().onModeChanged(this.mRootView);
    }

    public void uS(String str) {
        this.aYD.setVisibility(8);
        this.eWH.showNetRefreshView(this.mRootView, str, true);
        this.eWH.setNetRefreshViewTopMargin(400);
    }

    public void bbp() {
        this.aYD.setVisibility(0);
        this.eWH.hideNetRefreshView(this.mRootView);
    }

    public void showLoadingView() {
        this.aYD.setVisibility(8);
        this.eWH.showLoadingView(this.mRootView, true);
    }

    public void bbq() {
        this.aYD.setVisibility(0);
        this.eWH.hideLoadingView(this.mRootView);
    }

    public void h(NoNetworkView.a aVar) {
        if (aVar != null) {
            this.dbm.a(aVar);
        }
    }

    public void iP(boolean z) {
        if (!z) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.eLd.getLayoutParams();
            layoutParams.height = UtilHelper.getLightStatusBarHeight() + l.h(this.eWH.getActivity(), d.e.ds170);
            this.eLd.setLayoutParams(layoutParams);
            return;
        }
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.eLd.getLayoutParams();
        layoutParams2.height = UtilHelper.getLightStatusBarHeight() + l.h(this.eWH.getActivity(), d.e.ds88);
        this.eLd.setLayoutParams(layoutParams2);
    }
}
