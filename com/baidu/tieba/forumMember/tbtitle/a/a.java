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
    private NoNetworkView bla;
    private View cNI;
    private View.OnClickListener cVd;
    private TbTitleActivity cVj;
    private ScrollView cVk;
    private LinearLayout cVl;
    private TextView cVm;
    private ImageView cVn;
    private TextView cVo;
    private TextView cVp;
    public LinearLayout cVq;
    private List<LevelInfo> cVr;
    private DataRes cVs;
    private C0133a cVt;
    private NavigationBar mNavigationBar;
    private RelativeLayout mRootView;

    public a(TbTitleActivity tbTitleActivity, View.OnClickListener onClickListener) {
        super(tbTitleActivity.getPageContext());
        this.cVt = new C0133a(new View.OnClickListener() { // from class: com.baidu.tieba.forumMember.tbtitle.a.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(a.this.cVj.getPageContext().getContext()).createNormalCfg(a.this.getPageContext().getString(d.k.tieba_text), "from")));
            }
        });
        this.cVj = tbTitleActivity;
        this.cVd = onClickListener;
        initUI();
    }

    private void initUI() {
        this.mRootView = (RelativeLayout) LayoutInflater.from(this.cVj.getPageContext().getPageActivity()).inflate(d.i.tbtitle_activity, (ViewGroup) null);
        this.cVj.setContentView(this.mRootView);
        this.cNI = this.mRootView.findViewById(d.g.top_view);
        if (!j.gD()) {
            this.cNI.getLayoutParams().height = UtilHelper.getLightStatusBarHeight() + l.e(this.cVj.getActivity(), d.e.ds170);
        } else {
            this.cNI.getLayoutParams().height = UtilHelper.getLightStatusBarHeight() + l.e(this.cVj.getActivity(), d.e.ds88);
        }
        this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(d.g.view_navigation_bar);
        this.mNavigationBar.setCenterTextTitle(this.cVj.getString(d.k.tbtitle_title));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.showBottomLine();
        this.cVk = (ScrollView) this.mRootView.findViewById(d.g.tbtitle_scroll_view);
        this.cVq = (LinearLayout) this.mRootView.findViewById(d.g.first_line_layout);
        this.cVp = (TextView) this.mRootView.findViewById(d.g.tbtile_like_btn);
        this.cVl = (LinearLayout) this.mRootView.findViewById(d.g.table_canvas);
        this.cVm = (TextView) this.mRootView.findViewById(d.g.user_level_name);
        this.cVn = (ImageView) this.mRootView.findViewById(d.g.header_level_img);
        this.cVo = (TextView) this.mRootView.findViewById(d.g.tbtitle_tip_detail2);
        this.bla = (NoNetworkView) this.mRootView.findViewById(d.g.view_no_network);
        aos();
        aot();
    }

    private void aos() {
        String string = getPageContext().getResources().getString(d.k.tbtitle_tip_detail2);
        String string2 = getPageContext().getResources().getString(d.k.tbtitle_tip_tieba_bar);
        int length = string2.length();
        int indexOf = string.indexOf(string2);
        SpannableString spannableString = new SpannableString(string);
        spannableString.setSpan(this.cVt, indexOf, length + indexOf, 33);
        this.cVo.setText(spannableString);
        this.cVo.setMovementMethod(LinkMovementMethod.getInstance());
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

    public void bd(List<LevelInfo> list) {
        this.cVr = list;
        if (this.cVl != null && this.cVr != null && this.cVr.size() != 0) {
            this.cVl.removeAllViews();
            for (int i = 1; i <= list.size(); i++) {
                LevelInfo levelInfo = list.get(i - 1);
                View inflate = LayoutInflater.from(this.cVj.getPageContext().getContext()).inflate(d.i.tbtitle_table_item, (ViewGroup) null);
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
                this.cVl.addView(inflate);
            }
        }
    }

    public void a(DataRes dataRes) {
        this.cVs = dataRes;
        if (this.cVs != null) {
            if (this.cVs.is_like.intValue() == 1 && this.cVq != null) {
                this.cVq.setVisibility(8);
            }
            if (this.cVm != null) {
                if (StringUtils.isNull(this.cVs.level_name, true)) {
                    this.cVm.setText(this.cVs.level_name);
                } else {
                    this.cVm.setVisibility(8);
                }
            }
            if (this.cVn != null) {
                if (this.cVs.user_level.intValue() <= 0 || this.cVs.user_level.intValue() > 18) {
                    this.cVn.setVisibility(8);
                } else {
                    ak.c(this.cVn, BitmapHelper.getGradeResourceIdNew(this.cVs.user_level.intValue()));
                }
            }
        }
    }

    private void aot() {
        this.cVp.setOnClickListener(this.cVd);
        this.cVo.setOnClickListener(this.cVd);
    }

    public void dh(int i) {
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(this.cVj.getPageContext(), i);
        }
        if (this.bla != null) {
            this.bla.onChangeSkinType(this.cVj.getPageContext(), i);
        }
        bd(this.cVr);
        a(this.cVs);
        this.cVj.getLayoutMode().setNightMode(i == 1);
        this.cVj.getLayoutMode().u(this.mRootView);
    }

    public void lF(String str) {
        this.cVk.setVisibility(8);
        this.cVj.showNetRefreshView(this.mRootView, str, true);
        this.cVj.setNetRefreshViewTopMargin(HttpStatus.SC_BAD_REQUEST);
    }

    public void aou() {
        this.cVk.setVisibility(0);
        this.cVj.hideNetRefreshView(this.mRootView);
    }

    public void showLoadingView() {
        this.cVk.setVisibility(8);
        this.cVj.showLoadingView(this.mRootView, true);
    }

    public void aov() {
        this.cVk.setVisibility(0);
        this.cVj.hideLoadingView(this.mRootView);
    }

    public void h(NoNetworkView.a aVar) {
        if (aVar != null) {
            this.bla.a(aVar);
        }
    }

    public void fm(boolean z) {
        if (!z) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.cNI.getLayoutParams();
            layoutParams.height = UtilHelper.getLightStatusBarHeight() + l.e(this.cVj.getActivity(), d.e.ds170);
            this.cNI.setLayoutParams(layoutParams);
            return;
        }
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.cNI.getLayoutParams();
        layoutParams2.height = UtilHelper.getLightStatusBarHeight() + l.e(this.cVj.getActivity(), d.e.ds88);
        this.cNI.setLayoutParams(layoutParams2);
    }
}
