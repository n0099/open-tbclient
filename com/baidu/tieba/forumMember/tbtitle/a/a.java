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
import tbclient.GetLevelInfo.DataRes;
import tbclient.LevelInfo;
/* loaded from: classes3.dex */
public class a extends c<TbTitleActivity> {
    private ScrollView bDR;
    private NoNetworkView bKI;
    private View dnP;
    public LinearLayout dzA;
    private List<LevelInfo> dzB;
    private DataRes dzC;
    private C0206a dzD;
    private View.OnClickListener dzp;
    private TbTitleActivity dzu;
    private LinearLayout dzv;
    private TextView dzw;
    private ImageView dzx;
    private TextView dzy;
    private TextView dzz;
    private NavigationBar mNavigationBar;
    private RelativeLayout mRootView;

    public a(TbTitleActivity tbTitleActivity, View.OnClickListener onClickListener) {
        super(tbTitleActivity.getPageContext());
        this.dzD = new C0206a(new View.OnClickListener() { // from class: com.baidu.tieba.forumMember.tbtitle.a.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(a.this.dzu.getPageContext().getContext()).createNormalCfg(a.this.getPageContext().getString(e.j.tieba_text), "from")));
            }
        });
        this.dzu = tbTitleActivity;
        this.dzp = onClickListener;
        initUI();
    }

    private void initUI() {
        this.mRootView = (RelativeLayout) LayoutInflater.from(this.dzu.getPageContext().getPageActivity()).inflate(e.h.tbtitle_activity, (ViewGroup) null);
        this.dzu.setContentView(this.mRootView);
        this.dnP = this.mRootView.findViewById(e.g.top_view);
        if (!j.kK()) {
            this.dnP.getLayoutParams().height = UtilHelper.getLightStatusBarHeight() + l.h(this.dzu.getActivity(), e.C0200e.ds170);
        } else {
            this.dnP.getLayoutParams().height = UtilHelper.getLightStatusBarHeight() + l.h(this.dzu.getActivity(), e.C0200e.ds88);
        }
        this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(e.g.view_navigation_bar);
        this.mNavigationBar.setCenterTextTitle(this.dzu.getString(e.j.tbtitle_title));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.showBottomLine();
        this.bDR = (ScrollView) this.mRootView.findViewById(e.g.tbtitle_scroll_view);
        this.dzA = (LinearLayout) this.mRootView.findViewById(e.g.first_line_layout);
        this.dzz = (TextView) this.mRootView.findViewById(e.g.tbtile_like_btn);
        this.dzv = (LinearLayout) this.mRootView.findViewById(e.g.table_canvas);
        this.dzw = (TextView) this.mRootView.findViewById(e.g.user_level_name);
        this.dzx = (ImageView) this.mRootView.findViewById(e.g.header_level_img);
        this.dzy = (TextView) this.mRootView.findViewById(e.g.tbtitle_tip_detail2);
        this.bKI = (NoNetworkView) this.mRootView.findViewById(e.g.view_no_network);
        axS();
        axT();
    }

    private void axS() {
        String string = getPageContext().getResources().getString(e.j.tbtitle_tip_detail2);
        String string2 = getPageContext().getResources().getString(e.j.tbtitle_tip_tieba_bar);
        int length = string2.length();
        int indexOf = string.indexOf(string2);
        SpannableString spannableString = new SpannableString(string);
        spannableString.setSpan(this.dzD, indexOf, length + indexOf, 33);
        this.dzy.setText(spannableString);
        this.dzy.setMovementMethod(LinkMovementMethod.getInstance());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.forumMember.tbtitle.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0206a extends ClickableSpan {
        private View.OnClickListener aEo;

        public C0206a(View.OnClickListener onClickListener) {
            this.aEo = onClickListener;
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            textPaint.setColor(al.getColor(e.d.cp_link_tip_a));
            textPaint.setUnderlineText(false);
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View view) {
            this.aEo.onClick(view);
        }
    }

    public void by(List<LevelInfo> list) {
        this.dzB = list;
        if (this.dzv != null && this.dzB != null && this.dzB.size() != 0) {
            this.dzv.removeAllViews();
            for (int i = 1; i <= list.size(); i++) {
                LevelInfo levelInfo = list.get(i - 1);
                View inflate = LayoutInflater.from(this.dzu.getPageContext().getContext()).inflate(e.h.tbtitle_table_item, (ViewGroup) null);
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
                this.dzv.addView(inflate);
            }
        }
    }

    public void a(DataRes dataRes) {
        this.dzC = dataRes;
        if (this.dzC != null) {
            if (this.dzC.is_like.intValue() == 1 && this.dzA != null) {
                this.dzA.setVisibility(8);
            }
            if (this.dzw != null) {
                if (StringUtils.isNull(this.dzC.level_name, true)) {
                    this.dzw.setText(this.dzC.level_name);
                } else {
                    this.dzw.setVisibility(8);
                }
            }
            if (this.dzx != null) {
                if (this.dzC.user_level.intValue() <= 0 || this.dzC.user_level.intValue() > 18) {
                    this.dzx.setVisibility(8);
                } else {
                    al.c(this.dzx, BitmapHelper.getGradeResourceIdNew(this.dzC.user_level.intValue()));
                }
            }
        }
    }

    private void axT() {
        this.dzz.setOnClickListener(this.dzp);
        this.dzy.setOnClickListener(this.dzp);
    }

    public void dV(int i) {
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(this.dzu.getPageContext(), i);
        }
        if (this.bKI != null) {
            this.bKI.onChangeSkinType(this.dzu.getPageContext(), i);
        }
        by(this.dzB);
        a(this.dzC);
        this.dzu.getLayoutMode().setNightMode(i == 1);
        this.dzu.getLayoutMode().onModeChanged(this.mRootView);
    }

    public void nv(String str) {
        this.bDR.setVisibility(8);
        this.dzu.showNetRefreshView(this.mRootView, str, true);
        this.dzu.setNetRefreshViewTopMargin(400);
    }

    public void axU() {
        this.bDR.setVisibility(0);
        this.dzu.hideNetRefreshView(this.mRootView);
    }

    public void showLoadingView() {
        this.bDR.setVisibility(8);
        this.dzu.showLoadingView(this.mRootView, true);
    }

    public void axV() {
        this.bDR.setVisibility(0);
        this.dzu.hideLoadingView(this.mRootView);
    }

    public void h(NoNetworkView.a aVar) {
        if (aVar != null) {
            this.bKI.a(aVar);
        }
    }

    public void gm(boolean z) {
        if (!z) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.dnP.getLayoutParams();
            layoutParams.height = UtilHelper.getLightStatusBarHeight() + l.h(this.dzu.getActivity(), e.C0200e.ds170);
            this.dnP.setLayoutParams(layoutParams);
            return;
        }
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.dnP.getLayoutParams();
        layoutParams2.height = UtilHelper.getLightStatusBarHeight() + l.h(this.dzu.getActivity(), e.C0200e.ds88);
        this.dnP.setLayoutParams(layoutParams2);
    }
}
