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
    private View cNL;
    private View.OnClickListener cVg;
    private TbTitleActivity cVm;
    private ScrollView cVn;
    private LinearLayout cVo;
    private TextView cVp;
    private ImageView cVq;
    private TextView cVr;
    private TextView cVs;
    public LinearLayout cVt;
    private List<LevelInfo> cVu;
    private DataRes cVv;
    private C0133a cVw;
    private NavigationBar mNavigationBar;
    private RelativeLayout mRootView;

    public a(TbTitleActivity tbTitleActivity, View.OnClickListener onClickListener) {
        super(tbTitleActivity.getPageContext());
        this.cVw = new C0133a(new View.OnClickListener() { // from class: com.baidu.tieba.forumMember.tbtitle.a.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(a.this.cVm.getPageContext().getContext()).createNormalCfg(a.this.getPageContext().getString(d.k.tieba_text), "from")));
            }
        });
        this.cVm = tbTitleActivity;
        this.cVg = onClickListener;
        initUI();
    }

    private void initUI() {
        this.mRootView = (RelativeLayout) LayoutInflater.from(this.cVm.getPageContext().getPageActivity()).inflate(d.i.tbtitle_activity, (ViewGroup) null);
        this.cVm.setContentView(this.mRootView);
        this.cNL = this.mRootView.findViewById(d.g.top_view);
        if (!j.gD()) {
            this.cNL.getLayoutParams().height = UtilHelper.getLightStatusBarHeight() + l.e(this.cVm.getActivity(), d.e.ds170);
        } else {
            this.cNL.getLayoutParams().height = UtilHelper.getLightStatusBarHeight() + l.e(this.cVm.getActivity(), d.e.ds88);
        }
        this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(d.g.view_navigation_bar);
        this.mNavigationBar.setCenterTextTitle(this.cVm.getString(d.k.tbtitle_title));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.showBottomLine();
        this.cVn = (ScrollView) this.mRootView.findViewById(d.g.tbtitle_scroll_view);
        this.cVt = (LinearLayout) this.mRootView.findViewById(d.g.first_line_layout);
        this.cVs = (TextView) this.mRootView.findViewById(d.g.tbtile_like_btn);
        this.cVo = (LinearLayout) this.mRootView.findViewById(d.g.table_canvas);
        this.cVp = (TextView) this.mRootView.findViewById(d.g.user_level_name);
        this.cVq = (ImageView) this.mRootView.findViewById(d.g.header_level_img);
        this.cVr = (TextView) this.mRootView.findViewById(d.g.tbtitle_tip_detail2);
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
        spannableString.setSpan(this.cVw, indexOf, length + indexOf, 33);
        this.cVr.setText(spannableString);
        this.cVr.setMovementMethod(LinkMovementMethod.getInstance());
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
        this.cVu = list;
        if (this.cVo != null && this.cVu != null && this.cVu.size() != 0) {
            this.cVo.removeAllViews();
            for (int i = 1; i <= list.size(); i++) {
                LevelInfo levelInfo = list.get(i - 1);
                View inflate = LayoutInflater.from(this.cVm.getPageContext().getContext()).inflate(d.i.tbtitle_table_item, (ViewGroup) null);
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
                this.cVo.addView(inflate);
            }
        }
    }

    public void a(DataRes dataRes) {
        this.cVv = dataRes;
        if (this.cVv != null) {
            if (this.cVv.is_like.intValue() == 1 && this.cVt != null) {
                this.cVt.setVisibility(8);
            }
            if (this.cVp != null) {
                if (StringUtils.isNull(this.cVv.level_name, true)) {
                    this.cVp.setText(this.cVv.level_name);
                } else {
                    this.cVp.setVisibility(8);
                }
            }
            if (this.cVq != null) {
                if (this.cVv.user_level.intValue() <= 0 || this.cVv.user_level.intValue() > 18) {
                    this.cVq.setVisibility(8);
                } else {
                    ak.c(this.cVq, BitmapHelper.getGradeResourceIdNew(this.cVv.user_level.intValue()));
                }
            }
        }
    }

    private void aot() {
        this.cVs.setOnClickListener(this.cVg);
        this.cVr.setOnClickListener(this.cVg);
    }

    public void di(int i) {
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(this.cVm.getPageContext(), i);
        }
        if (this.bla != null) {
            this.bla.onChangeSkinType(this.cVm.getPageContext(), i);
        }
        bd(this.cVu);
        a(this.cVv);
        this.cVm.getLayoutMode().setNightMode(i == 1);
        this.cVm.getLayoutMode().u(this.mRootView);
    }

    public void lF(String str) {
        this.cVn.setVisibility(8);
        this.cVm.showNetRefreshView(this.mRootView, str, true);
        this.cVm.setNetRefreshViewTopMargin(HttpStatus.SC_BAD_REQUEST);
    }

    public void aou() {
        this.cVn.setVisibility(0);
        this.cVm.hideNetRefreshView(this.mRootView);
    }

    public void showLoadingView() {
        this.cVn.setVisibility(8);
        this.cVm.showLoadingView(this.mRootView, true);
    }

    public void aov() {
        this.cVn.setVisibility(0);
        this.cVm.hideLoadingView(this.mRootView);
    }

    public void h(NoNetworkView.a aVar) {
        if (aVar != null) {
            this.bla.a(aVar);
        }
    }

    public void fm(boolean z) {
        if (!z) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.cNL.getLayoutParams();
            layoutParams.height = UtilHelper.getLightStatusBarHeight() + l.e(this.cVm.getActivity(), d.e.ds170);
            this.cNL.setLayoutParams(layoutParams);
            return;
        }
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.cNL.getLayoutParams();
        layoutParams2.height = UtilHelper.getLightStatusBarHeight() + l.e(this.cVm.getActivity(), d.e.ds88);
        this.cNL.setLayoutParams(layoutParams2);
    }
}
