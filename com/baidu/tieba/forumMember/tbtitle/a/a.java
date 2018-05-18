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
import com.baidu.tbadk.core.util.ak;
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
    private NoNetworkView blp;
    private View cOP;
    private C0133a cWA;
    private View.OnClickListener cWk;
    private TbTitleActivity cWq;
    private ScrollView cWr;
    private LinearLayout cWs;
    private TextView cWt;
    private ImageView cWu;
    private TextView cWv;
    private TextView cWw;
    public LinearLayout cWx;
    private List<LevelInfo> cWy;
    private DataRes cWz;
    private NavigationBar mNavigationBar;
    private RelativeLayout mRootView;

    public a(TbTitleActivity tbTitleActivity, View.OnClickListener onClickListener) {
        super(tbTitleActivity.getPageContext());
        this.cWA = new C0133a(new View.OnClickListener() { // from class: com.baidu.tieba.forumMember.tbtitle.a.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(a.this.cWq.getPageContext().getContext()).createNormalCfg(a.this.getPageContext().getString(d.k.tieba_text), "from")));
            }
        });
        this.cWq = tbTitleActivity;
        this.cWk = onClickListener;
        initUI();
    }

    private void initUI() {
        this.mRootView = (RelativeLayout) LayoutInflater.from(this.cWq.getPageContext().getPageActivity()).inflate(d.i.tbtitle_activity, (ViewGroup) null);
        this.cWq.setContentView(this.mRootView);
        this.cOP = this.mRootView.findViewById(d.g.top_view);
        if (!j.gD()) {
            this.cOP.getLayoutParams().height = UtilHelper.getLightStatusBarHeight() + l.e(this.cWq.getActivity(), d.e.ds170);
        } else {
            this.cOP.getLayoutParams().height = UtilHelper.getLightStatusBarHeight() + l.e(this.cWq.getActivity(), d.e.ds88);
        }
        this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(d.g.view_navigation_bar);
        this.mNavigationBar.setCenterTextTitle(this.cWq.getString(d.k.tbtitle_title));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.showBottomLine();
        this.cWr = (ScrollView) this.mRootView.findViewById(d.g.tbtitle_scroll_view);
        this.cWx = (LinearLayout) this.mRootView.findViewById(d.g.first_line_layout);
        this.cWw = (TextView) this.mRootView.findViewById(d.g.tbtile_like_btn);
        this.cWs = (LinearLayout) this.mRootView.findViewById(d.g.table_canvas);
        this.cWt = (TextView) this.mRootView.findViewById(d.g.user_level_name);
        this.cWu = (ImageView) this.mRootView.findViewById(d.g.header_level_img);
        this.cWv = (TextView) this.mRootView.findViewById(d.g.tbtitle_tip_detail2);
        this.blp = (NoNetworkView) this.mRootView.findViewById(d.g.view_no_network);
        aor();
        aos();
    }

    private void aor() {
        String string = getPageContext().getResources().getString(d.k.tbtitle_tip_detail2);
        String string2 = getPageContext().getResources().getString(d.k.tbtitle_tip_tieba_bar);
        int length = string2.length();
        int indexOf = string.indexOf(string2);
        SpannableString spannableString = new SpannableString(string);
        spannableString.setSpan(this.cWA, indexOf, length + indexOf, 33);
        this.cWv.setText(spannableString);
        this.cWv.setMovementMethod(LinkMovementMethod.getInstance());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.forumMember.tbtitle.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0133a extends ClickableSpan {
        private View.OnClickListener ani;

        public C0133a(View.OnClickListener onClickListener) {
            this.ani = onClickListener;
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            textPaint.setColor(ak.getColor(d.C0126d.cp_link_tip_a));
            textPaint.setUnderlineText(false);
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View view2) {
            this.ani.onClick(view2);
        }
    }

    public void bg(List<LevelInfo> list) {
        this.cWy = list;
        if (this.cWs != null && this.cWy != null && this.cWy.size() != 0) {
            this.cWs.removeAllViews();
            for (int i = 1; i <= list.size(); i++) {
                LevelInfo levelInfo = list.get(i - 1);
                View inflate = LayoutInflater.from(this.cWq.getPageContext().getContext()).inflate(d.i.tbtitle_table_item, (ViewGroup) null);
                LinearLayout linearLayout = (LinearLayout) inflate.findViewById(d.g.table_item_background);
                TextView textView = (TextView) inflate.findViewById(d.g.table_item_level_name);
                TextView textView2 = (TextView) inflate.findViewById(d.g.table_item_need_experienment);
                View findViewById = inflate.findViewById(d.g.tbtile_item_horizontal_line);
                ImageView imageView = (ImageView) inflate.findViewById(d.g.table_item_level_img);
                if (i % 2 != 0) {
                    ak.i(linearLayout, d.C0126d.cp_bg_line_e);
                }
                ak.c(textView, d.C0126d.cp_cont_b, 1);
                ak.c(textView2, d.C0126d.cp_cont_b, 1);
                ak.j(findViewById, d.C0126d.cp_bg_line_b);
                ak.c(imageView, BitmapHelper.getGradeResourceIdNew(levelInfo.id.intValue()));
                textView.setText(levelInfo.name);
                if (levelInfo.score.intValue() <= 3000000 && levelInfo.score.intValue() > 0) {
                    textView2.setText(levelInfo.score + "");
                } else if (levelInfo.score.intValue() <= 0) {
                    textView2.setText("0");
                } else {
                    textView2.setText("3000000");
                }
                this.cWs.addView(inflate);
            }
        }
    }

    public void a(DataRes dataRes) {
        this.cWz = dataRes;
        if (this.cWz != null) {
            if (this.cWz.is_like.intValue() == 1 && this.cWx != null) {
                this.cWx.setVisibility(8);
            }
            if (this.cWt != null) {
                if (StringUtils.isNull(this.cWz.level_name, true)) {
                    this.cWt.setText(this.cWz.level_name);
                } else {
                    this.cWt.setVisibility(8);
                }
            }
            if (this.cWu != null) {
                if (this.cWz.user_level.intValue() <= 0 || this.cWz.user_level.intValue() > 18) {
                    this.cWu.setVisibility(8);
                } else {
                    ak.c(this.cWu, BitmapHelper.getGradeResourceIdNew(this.cWz.user_level.intValue()));
                }
            }
        }
    }

    private void aos() {
        this.cWw.setOnClickListener(this.cWk);
        this.cWv.setOnClickListener(this.cWk);
    }

    public void di(int i) {
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(this.cWq.getPageContext(), i);
        }
        if (this.blp != null) {
            this.blp.onChangeSkinType(this.cWq.getPageContext(), i);
        }
        bg(this.cWy);
        a(this.cWz);
        this.cWq.getLayoutMode().setNightMode(i == 1);
        this.cWq.getLayoutMode().u(this.mRootView);
    }

    public void lI(String str) {
        this.cWr.setVisibility(8);
        this.cWq.showNetRefreshView(this.mRootView, str, true);
        this.cWq.setNetRefreshViewTopMargin(HttpStatus.SC_BAD_REQUEST);
    }

    public void aot() {
        this.cWr.setVisibility(0);
        this.cWq.hideNetRefreshView(this.mRootView);
    }

    public void showLoadingView() {
        this.cWr.setVisibility(8);
        this.cWq.showLoadingView(this.mRootView, true);
    }

    public void aou() {
        this.cWr.setVisibility(0);
        this.cWq.hideLoadingView(this.mRootView);
    }

    public void h(NoNetworkView.a aVar) {
        if (aVar != null) {
            this.blp.a(aVar);
        }
    }

    public void fn(boolean z) {
        if (!z) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.cOP.getLayoutParams();
            layoutParams.height = UtilHelper.getLightStatusBarHeight() + l.e(this.cWq.getActivity(), d.e.ds170);
            this.cOP.setLayoutParams(layoutParams);
            return;
        }
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.cOP.getLayoutParams();
        layoutParams2.height = UtilHelper.getLightStatusBarHeight() + l.e(this.cWq.getActivity(), d.e.ds88);
        this.cOP.setLayoutParams(layoutParams2);
    }
}
