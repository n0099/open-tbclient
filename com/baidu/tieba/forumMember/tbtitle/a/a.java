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
import org.apache.http.HttpStatus;
import tbclient.GetLevelInfo.DataRes;
import tbclient.LevelInfo;
/* loaded from: classes3.dex */
public class a extends c<TbTitleActivity> {
    private NoNetworkView bBq;
    private View deF;
    private View.OnClickListener dpV;
    private TbTitleActivity dqa;
    private ScrollView dqb;
    private LinearLayout dqc;
    private TextView dqd;
    private ImageView dqe;
    private TextView dqf;
    private TextView dqg;
    public LinearLayout dqh;
    private List<LevelInfo> dqi;
    private DataRes dqj;
    private C0147a dqk;
    private NavigationBar mNavigationBar;
    private RelativeLayout mRootView;

    public a(TbTitleActivity tbTitleActivity, View.OnClickListener onClickListener) {
        super(tbTitleActivity.getPageContext());
        this.dqk = new C0147a(new View.OnClickListener() { // from class: com.baidu.tieba.forumMember.tbtitle.a.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(a.this.dqa.getPageContext().getContext()).createNormalCfg(a.this.getPageContext().getString(e.j.tieba_text), "from")));
            }
        });
        this.dqa = tbTitleActivity;
        this.dpV = onClickListener;
        initUI();
    }

    private void initUI() {
        this.mRootView = (RelativeLayout) LayoutInflater.from(this.dqa.getPageContext().getPageActivity()).inflate(e.h.tbtitle_activity, (ViewGroup) null);
        this.dqa.setContentView(this.mRootView);
        this.deF = this.mRootView.findViewById(e.g.top_view);
        if (!j.ky()) {
            this.deF.getLayoutParams().height = UtilHelper.getLightStatusBarHeight() + l.h(this.dqa.getActivity(), e.C0141e.ds170);
        } else {
            this.deF.getLayoutParams().height = UtilHelper.getLightStatusBarHeight() + l.h(this.dqa.getActivity(), e.C0141e.ds88);
        }
        this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(e.g.view_navigation_bar);
        this.mNavigationBar.setCenterTextTitle(this.dqa.getString(e.j.tbtitle_title));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.showBottomLine();
        this.dqb = (ScrollView) this.mRootView.findViewById(e.g.tbtitle_scroll_view);
        this.dqh = (LinearLayout) this.mRootView.findViewById(e.g.first_line_layout);
        this.dqg = (TextView) this.mRootView.findViewById(e.g.tbtile_like_btn);
        this.dqc = (LinearLayout) this.mRootView.findViewById(e.g.table_canvas);
        this.dqd = (TextView) this.mRootView.findViewById(e.g.user_level_name);
        this.dqe = (ImageView) this.mRootView.findViewById(e.g.header_level_img);
        this.dqf = (TextView) this.mRootView.findViewById(e.g.tbtitle_tip_detail2);
        this.bBq = (NoNetworkView) this.mRootView.findViewById(e.g.view_no_network);
        auY();
        auZ();
    }

    private void auY() {
        String string = getPageContext().getResources().getString(e.j.tbtitle_tip_detail2);
        String string2 = getPageContext().getResources().getString(e.j.tbtitle_tip_tieba_bar);
        int length = string2.length();
        int indexOf = string.indexOf(string2);
        SpannableString spannableString = new SpannableString(string);
        spannableString.setSpan(this.dqk, indexOf, length + indexOf, 33);
        this.dqf.setText(spannableString);
        this.dqf.setMovementMethod(LinkMovementMethod.getInstance());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.forumMember.tbtitle.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0147a extends ClickableSpan {
        private View.OnClickListener ayP;

        public C0147a(View.OnClickListener onClickListener) {
            this.ayP = onClickListener;
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            textPaint.setColor(al.getColor(e.d.cp_link_tip_a));
            textPaint.setUnderlineText(false);
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View view) {
            this.ayP.onClick(view);
        }
    }

    public void bk(List<LevelInfo> list) {
        this.dqi = list;
        if (this.dqc != null && this.dqi != null && this.dqi.size() != 0) {
            this.dqc.removeAllViews();
            for (int i = 1; i <= list.size(); i++) {
                LevelInfo levelInfo = list.get(i - 1);
                View inflate = LayoutInflater.from(this.dqa.getPageContext().getContext()).inflate(e.h.tbtitle_table_item, (ViewGroup) null);
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
                this.dqc.addView(inflate);
            }
        }
    }

    public void a(DataRes dataRes) {
        this.dqj = dataRes;
        if (this.dqj != null) {
            if (this.dqj.is_like.intValue() == 1 && this.dqh != null) {
                this.dqh.setVisibility(8);
            }
            if (this.dqd != null) {
                if (StringUtils.isNull(this.dqj.level_name, true)) {
                    this.dqd.setText(this.dqj.level_name);
                } else {
                    this.dqd.setVisibility(8);
                }
            }
            if (this.dqe != null) {
                if (this.dqj.user_level.intValue() <= 0 || this.dqj.user_level.intValue() > 18) {
                    this.dqe.setVisibility(8);
                } else {
                    al.c(this.dqe, BitmapHelper.getGradeResourceIdNew(this.dqj.user_level.intValue()));
                }
            }
        }
    }

    private void auZ() {
        this.dqg.setOnClickListener(this.dpV);
        this.dqf.setOnClickListener(this.dpV);
    }

    public void dx(int i) {
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(this.dqa.getPageContext(), i);
        }
        if (this.bBq != null) {
            this.bBq.onChangeSkinType(this.dqa.getPageContext(), i);
        }
        bk(this.dqi);
        a(this.dqj);
        this.dqa.getLayoutMode().setNightMode(i == 1);
        this.dqa.getLayoutMode().onModeChanged(this.mRootView);
    }

    public void mS(String str) {
        this.dqb.setVisibility(8);
        this.dqa.showNetRefreshView(this.mRootView, str, true);
        this.dqa.setNetRefreshViewTopMargin(HttpStatus.SC_BAD_REQUEST);
    }

    public void ava() {
        this.dqb.setVisibility(0);
        this.dqa.hideNetRefreshView(this.mRootView);
    }

    public void showLoadingView() {
        this.dqb.setVisibility(8);
        this.dqa.showLoadingView(this.mRootView, true);
    }

    public void avb() {
        this.dqb.setVisibility(0);
        this.dqa.hideLoadingView(this.mRootView);
    }

    public void h(NoNetworkView.a aVar) {
        if (aVar != null) {
            this.bBq.a(aVar);
        }
    }

    public void fK(boolean z) {
        if (!z) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.deF.getLayoutParams();
            layoutParams.height = UtilHelper.getLightStatusBarHeight() + l.h(this.dqa.getActivity(), e.C0141e.ds170);
            this.deF.setLayoutParams(layoutParams);
            return;
        }
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.deF.getLayoutParams();
        layoutParams2.height = UtilHelper.getLightStatusBarHeight() + l.h(this.dqa.getActivity(), e.C0141e.ds88);
        this.deF.setLayoutParams(layoutParams2);
    }
}
