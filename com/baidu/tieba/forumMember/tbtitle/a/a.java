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
import com.baidu.tieba.f;
import com.baidu.tieba.forumMember.tbtitle.TbTitleActivity;
import java.util.List;
import org.apache.http.HttpStatus;
import tbclient.GetLevelInfo.DataRes;
import tbclient.LevelInfo;
/* loaded from: classes3.dex */
public class a extends c<TbTitleActivity> {
    private NoNetworkView bvB;
    private View cYI;
    private View.OnClickListener dkc;
    private TbTitleActivity dkh;
    private ScrollView dki;
    private LinearLayout dkj;
    private TextView dkk;
    private ImageView dkl;
    private TextView dkm;
    private TextView dkn;
    public LinearLayout dko;
    private List<LevelInfo> dkp;
    private DataRes dkq;
    private C0147a dkr;
    private NavigationBar mNavigationBar;
    private RelativeLayout mRootView;

    public a(TbTitleActivity tbTitleActivity, View.OnClickListener onClickListener) {
        super(tbTitleActivity.getPageContext());
        this.dkr = new C0147a(new View.OnClickListener() { // from class: com.baidu.tieba.forumMember.tbtitle.a.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(a.this.dkh.getPageContext().getContext()).createNormalCfg(a.this.getPageContext().getString(f.j.tieba_text), "from")));
            }
        });
        this.dkh = tbTitleActivity;
        this.dkc = onClickListener;
        initUI();
    }

    private void initUI() {
        this.mRootView = (RelativeLayout) LayoutInflater.from(this.dkh.getPageContext().getPageActivity()).inflate(f.h.tbtitle_activity, (ViewGroup) null);
        this.dkh.setContentView(this.mRootView);
        this.cYI = this.mRootView.findViewById(f.g.top_view);
        if (!j.js()) {
            this.cYI.getLayoutParams().height = UtilHelper.getLightStatusBarHeight() + l.f(this.dkh.getActivity(), f.e.ds170);
        } else {
            this.cYI.getLayoutParams().height = UtilHelper.getLightStatusBarHeight() + l.f(this.dkh.getActivity(), f.e.ds88);
        }
        this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(f.g.view_navigation_bar);
        this.mNavigationBar.setCenterTextTitle(this.dkh.getString(f.j.tbtitle_title));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.showBottomLine();
        this.dki = (ScrollView) this.mRootView.findViewById(f.g.tbtitle_scroll_view);
        this.dko = (LinearLayout) this.mRootView.findViewById(f.g.first_line_layout);
        this.dkn = (TextView) this.mRootView.findViewById(f.g.tbtile_like_btn);
        this.dkj = (LinearLayout) this.mRootView.findViewById(f.g.table_canvas);
        this.dkk = (TextView) this.mRootView.findViewById(f.g.user_level_name);
        this.dkl = (ImageView) this.mRootView.findViewById(f.g.header_level_img);
        this.dkm = (TextView) this.mRootView.findViewById(f.g.tbtitle_tip_detail2);
        this.bvB = (NoNetworkView) this.mRootView.findViewById(f.g.view_no_network);
        atk();
        atl();
    }

    private void atk() {
        String string = getPageContext().getResources().getString(f.j.tbtitle_tip_detail2);
        String string2 = getPageContext().getResources().getString(f.j.tbtitle_tip_tieba_bar);
        int length = string2.length();
        int indexOf = string.indexOf(string2);
        SpannableString spannableString = new SpannableString(string);
        spannableString.setSpan(this.dkr, indexOf, length + indexOf, 33);
        this.dkm.setText(spannableString);
        this.dkm.setMovementMethod(LinkMovementMethod.getInstance());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.forumMember.tbtitle.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0147a extends ClickableSpan {
        private View.OnClickListener avD;

        public C0147a(View.OnClickListener onClickListener) {
            this.avD = onClickListener;
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            textPaint.setColor(am.getColor(f.d.cp_link_tip_a));
            textPaint.setUnderlineText(false);
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View view) {
            this.avD.onClick(view);
        }
    }

    public void bj(List<LevelInfo> list) {
        this.dkp = list;
        if (this.dkj != null && this.dkp != null && this.dkp.size() != 0) {
            this.dkj.removeAllViews();
            for (int i = 1; i <= list.size(); i++) {
                LevelInfo levelInfo = list.get(i - 1);
                View inflate = LayoutInflater.from(this.dkh.getPageContext().getContext()).inflate(f.h.tbtitle_table_item, (ViewGroup) null);
                LinearLayout linearLayout = (LinearLayout) inflate.findViewById(f.g.table_item_background);
                TextView textView = (TextView) inflate.findViewById(f.g.table_item_level_name);
                TextView textView2 = (TextView) inflate.findViewById(f.g.table_item_need_experienment);
                View findViewById = inflate.findViewById(f.g.tbtile_item_horizontal_line);
                ImageView imageView = (ImageView) inflate.findViewById(f.g.table_item_level_img);
                if (i % 2 != 0) {
                    am.i(linearLayout, f.d.cp_bg_line_e);
                }
                am.c(textView, f.d.cp_cont_b, 1);
                am.c(textView2, f.d.cp_cont_b, 1);
                am.j(findViewById, f.d.cp_bg_line_b);
                am.c(imageView, BitmapHelper.getGradeResourceIdNew(levelInfo.id.intValue()));
                textView.setText(levelInfo.name);
                if (levelInfo.score.intValue() <= 3000000 && levelInfo.score.intValue() > 0) {
                    textView2.setText(levelInfo.score + "");
                } else if (levelInfo.score.intValue() <= 0) {
                    textView2.setText("0");
                } else {
                    textView2.setText("3000000");
                }
                this.dkj.addView(inflate);
            }
        }
    }

    public void a(DataRes dataRes) {
        this.dkq = dataRes;
        if (this.dkq != null) {
            if (this.dkq.is_like.intValue() == 1 && this.dko != null) {
                this.dko.setVisibility(8);
            }
            if (this.dkk != null) {
                if (StringUtils.isNull(this.dkq.level_name, true)) {
                    this.dkk.setText(this.dkq.level_name);
                } else {
                    this.dkk.setVisibility(8);
                }
            }
            if (this.dkl != null) {
                if (this.dkq.user_level.intValue() <= 0 || this.dkq.user_level.intValue() > 18) {
                    this.dkl.setVisibility(8);
                } else {
                    am.c(this.dkl, BitmapHelper.getGradeResourceIdNew(this.dkq.user_level.intValue()));
                }
            }
        }
    }

    private void atl() {
        this.dkn.setOnClickListener(this.dkc);
        this.dkm.setOnClickListener(this.dkc);
    }

    public void dm(int i) {
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(this.dkh.getPageContext(), i);
        }
        if (this.bvB != null) {
            this.bvB.onChangeSkinType(this.dkh.getPageContext(), i);
        }
        bj(this.dkp);
        a(this.dkq);
        this.dkh.getLayoutMode().setNightMode(i == 1);
        this.dkh.getLayoutMode().onModeChanged(this.mRootView);
    }

    public void mq(String str) {
        this.dki.setVisibility(8);
        this.dkh.showNetRefreshView(this.mRootView, str, true);
        this.dkh.setNetRefreshViewTopMargin(HttpStatus.SC_BAD_REQUEST);
    }

    public void atm() {
        this.dki.setVisibility(0);
        this.dkh.hideNetRefreshView(this.mRootView);
    }

    public void showLoadingView() {
        this.dki.setVisibility(8);
        this.dkh.showLoadingView(this.mRootView, true);
    }

    public void atn() {
        this.dki.setVisibility(0);
        this.dkh.hideLoadingView(this.mRootView);
    }

    public void h(NoNetworkView.a aVar) {
        if (aVar != null) {
            this.bvB.a(aVar);
        }
    }

    public void ft(boolean z) {
        if (!z) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.cYI.getLayoutParams();
            layoutParams.height = UtilHelper.getLightStatusBarHeight() + l.f(this.dkh.getActivity(), f.e.ds170);
            this.cYI.setLayoutParams(layoutParams);
            return;
        }
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.cYI.getLayoutParams();
        layoutParams2.height = UtilHelper.getLightStatusBarHeight() + l.f(this.dkh.getActivity(), f.e.ds88);
        this.cYI.setLayoutParams(layoutParams2);
    }
}
