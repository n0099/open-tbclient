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
import com.baidu.tbadk.core.util.am;
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
    private NoNetworkView bvz;
    private View cYM;
    private View.OnClickListener dke;
    private TbTitleActivity dkj;
    private ScrollView dkk;
    private LinearLayout dkl;
    private TextView dkm;
    private ImageView dkn;
    private TextView dko;
    private TextView dkp;
    public LinearLayout dkq;
    private List<LevelInfo> dkr;
    private DataRes dks;
    private C0147a dkt;
    private NavigationBar mNavigationBar;
    private RelativeLayout mRootView;

    public a(TbTitleActivity tbTitleActivity, View.OnClickListener onClickListener) {
        super(tbTitleActivity.getPageContext());
        this.dkt = new C0147a(new View.OnClickListener() { // from class: com.baidu.tieba.forumMember.tbtitle.a.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(a.this.dkj.getPageContext().getContext()).createNormalCfg(a.this.getPageContext().getString(d.j.tieba_text), "from")));
            }
        });
        this.dkj = tbTitleActivity;
        this.dke = onClickListener;
        initUI();
    }

    private void initUI() {
        this.mRootView = (RelativeLayout) LayoutInflater.from(this.dkj.getPageContext().getPageActivity()).inflate(d.h.tbtitle_activity, (ViewGroup) null);
        this.dkj.setContentView(this.mRootView);
        this.cYM = this.mRootView.findViewById(d.g.top_view);
        if (!j.js()) {
            this.cYM.getLayoutParams().height = UtilHelper.getLightStatusBarHeight() + l.f(this.dkj.getActivity(), d.e.ds170);
        } else {
            this.cYM.getLayoutParams().height = UtilHelper.getLightStatusBarHeight() + l.f(this.dkj.getActivity(), d.e.ds88);
        }
        this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(d.g.view_navigation_bar);
        this.mNavigationBar.setCenterTextTitle(this.dkj.getString(d.j.tbtitle_title));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.showBottomLine();
        this.dkk = (ScrollView) this.mRootView.findViewById(d.g.tbtitle_scroll_view);
        this.dkq = (LinearLayout) this.mRootView.findViewById(d.g.first_line_layout);
        this.dkp = (TextView) this.mRootView.findViewById(d.g.tbtile_like_btn);
        this.dkl = (LinearLayout) this.mRootView.findViewById(d.g.table_canvas);
        this.dkm = (TextView) this.mRootView.findViewById(d.g.user_level_name);
        this.dkn = (ImageView) this.mRootView.findViewById(d.g.header_level_img);
        this.dko = (TextView) this.mRootView.findViewById(d.g.tbtitle_tip_detail2);
        this.bvz = (NoNetworkView) this.mRootView.findViewById(d.g.view_no_network);
        atl();
        atm();
    }

    private void atl() {
        String string = getPageContext().getResources().getString(d.j.tbtitle_tip_detail2);
        String string2 = getPageContext().getResources().getString(d.j.tbtitle_tip_tieba_bar);
        int length = string2.length();
        int indexOf = string.indexOf(string2);
        SpannableString spannableString = new SpannableString(string);
        spannableString.setSpan(this.dkt, indexOf, length + indexOf, 33);
        this.dko.setText(spannableString);
        this.dko.setMovementMethod(LinkMovementMethod.getInstance());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.forumMember.tbtitle.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0147a extends ClickableSpan {
        private View.OnClickListener avF;

        public C0147a(View.OnClickListener onClickListener) {
            this.avF = onClickListener;
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            textPaint.setColor(am.getColor(d.C0140d.cp_link_tip_a));
            textPaint.setUnderlineText(false);
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View view) {
            this.avF.onClick(view);
        }
    }

    public void bj(List<LevelInfo> list) {
        this.dkr = list;
        if (this.dkl != null && this.dkr != null && this.dkr.size() != 0) {
            this.dkl.removeAllViews();
            for (int i = 1; i <= list.size(); i++) {
                LevelInfo levelInfo = list.get(i - 1);
                View inflate = LayoutInflater.from(this.dkj.getPageContext().getContext()).inflate(d.h.tbtitle_table_item, (ViewGroup) null);
                LinearLayout linearLayout = (LinearLayout) inflate.findViewById(d.g.table_item_background);
                TextView textView = (TextView) inflate.findViewById(d.g.table_item_level_name);
                TextView textView2 = (TextView) inflate.findViewById(d.g.table_item_need_experienment);
                View findViewById = inflate.findViewById(d.g.tbtile_item_horizontal_line);
                ImageView imageView = (ImageView) inflate.findViewById(d.g.table_item_level_img);
                if (i % 2 != 0) {
                    am.i(linearLayout, d.C0140d.cp_bg_line_e);
                }
                am.c(textView, d.C0140d.cp_cont_b, 1);
                am.c(textView2, d.C0140d.cp_cont_b, 1);
                am.j(findViewById, d.C0140d.cp_bg_line_b);
                am.c(imageView, BitmapHelper.getGradeResourceIdNew(levelInfo.id.intValue()));
                textView.setText(levelInfo.name);
                if (levelInfo.score.intValue() <= 3000000 && levelInfo.score.intValue() > 0) {
                    textView2.setText(levelInfo.score + "");
                } else if (levelInfo.score.intValue() <= 0) {
                    textView2.setText("0");
                } else {
                    textView2.setText("3000000");
                }
                this.dkl.addView(inflate);
            }
        }
    }

    public void a(DataRes dataRes) {
        this.dks = dataRes;
        if (this.dks != null) {
            if (this.dks.is_like.intValue() == 1 && this.dkq != null) {
                this.dkq.setVisibility(8);
            }
            if (this.dkm != null) {
                if (StringUtils.isNull(this.dks.level_name, true)) {
                    this.dkm.setText(this.dks.level_name);
                } else {
                    this.dkm.setVisibility(8);
                }
            }
            if (this.dkn != null) {
                if (this.dks.user_level.intValue() <= 0 || this.dks.user_level.intValue() > 18) {
                    this.dkn.setVisibility(8);
                } else {
                    am.c(this.dkn, BitmapHelper.getGradeResourceIdNew(this.dks.user_level.intValue()));
                }
            }
        }
    }

    private void atm() {
        this.dkp.setOnClickListener(this.dke);
        this.dko.setOnClickListener(this.dke);
    }

    public void dn(int i) {
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(this.dkj.getPageContext(), i);
        }
        if (this.bvz != null) {
            this.bvz.onChangeSkinType(this.dkj.getPageContext(), i);
        }
        bj(this.dkr);
        a(this.dks);
        this.dkj.getLayoutMode().setNightMode(i == 1);
        this.dkj.getLayoutMode().onModeChanged(this.mRootView);
    }

    public void mo(String str) {
        this.dkk.setVisibility(8);
        this.dkj.showNetRefreshView(this.mRootView, str, true);
        this.dkj.setNetRefreshViewTopMargin(HttpStatus.SC_BAD_REQUEST);
    }

    public void atn() {
        this.dkk.setVisibility(0);
        this.dkj.hideNetRefreshView(this.mRootView);
    }

    public void showLoadingView() {
        this.dkk.setVisibility(8);
        this.dkj.showLoadingView(this.mRootView, true);
    }

    public void ato() {
        this.dkk.setVisibility(0);
        this.dkj.hideLoadingView(this.mRootView);
    }

    public void h(NoNetworkView.a aVar) {
        if (aVar != null) {
            this.bvz.a(aVar);
        }
    }

    public void ft(boolean z) {
        if (!z) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.cYM.getLayoutParams();
            layoutParams.height = UtilHelper.getLightStatusBarHeight() + l.f(this.dkj.getActivity(), d.e.ds170);
            this.cYM.setLayoutParams(layoutParams);
            return;
        }
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.cYM.getLayoutParams();
        layoutParams2.height = UtilHelper.getLightStatusBarHeight() + l.f(this.dkj.getActivity(), d.e.ds88);
        this.cYM.setLayoutParams(layoutParams2);
    }
}
