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
    private ScrollView bIl;
    private NoNetworkView bPm;
    private C0216a dJA;
    private View.OnClickListener dJm;
    private TbTitleActivity dJr;
    private LinearLayout dJs;
    private TextView dJt;
    private ImageView dJu;
    private TextView dJv;
    private TextView dJw;
    public LinearLayout dJx;
    private List<LevelInfo> dJy;
    private DataRes dJz;
    private View dxN;
    private NavigationBar mNavigationBar;
    private RelativeLayout mRootView;

    public a(TbTitleActivity tbTitleActivity, View.OnClickListener onClickListener) {
        super(tbTitleActivity.getPageContext());
        this.dJA = new C0216a(new View.OnClickListener() { // from class: com.baidu.tieba.forumMember.tbtitle.a.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(a.this.dJr.getPageContext().getContext()).createNormalCfg(a.this.getPageContext().getString(e.j.tieba_text), "from")));
            }
        });
        this.dJr = tbTitleActivity;
        this.dJm = onClickListener;
        initUI();
    }

    private void initUI() {
        this.mRootView = (RelativeLayout) LayoutInflater.from(this.dJr.getPageContext().getPageActivity()).inflate(e.h.tbtitle_activity, (ViewGroup) null);
        this.dJr.setContentView(this.mRootView);
        this.dxN = this.mRootView.findViewById(e.g.top_view);
        if (!j.kK()) {
            this.dxN.getLayoutParams().height = UtilHelper.getLightStatusBarHeight() + l.h(this.dJr.getActivity(), e.C0210e.ds170);
        } else {
            this.dxN.getLayoutParams().height = UtilHelper.getLightStatusBarHeight() + l.h(this.dJr.getActivity(), e.C0210e.ds88);
        }
        this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(e.g.view_navigation_bar);
        this.mNavigationBar.setCenterTextTitle(this.dJr.getString(e.j.tbtitle_title));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.showBottomLine();
        this.bIl = (ScrollView) this.mRootView.findViewById(e.g.tbtitle_scroll_view);
        this.dJx = (LinearLayout) this.mRootView.findViewById(e.g.first_line_layout);
        this.dJw = (TextView) this.mRootView.findViewById(e.g.tbtile_like_btn);
        this.dJs = (LinearLayout) this.mRootView.findViewById(e.g.table_canvas);
        this.dJt = (TextView) this.mRootView.findViewById(e.g.user_level_name);
        this.dJu = (ImageView) this.mRootView.findViewById(e.g.header_level_img);
        this.dJv = (TextView) this.mRootView.findViewById(e.g.tbtitle_tip_detail2);
        this.bPm = (NoNetworkView) this.mRootView.findViewById(e.g.view_no_network);
        aAO();
        aAP();
    }

    private void aAO() {
        String string = getPageContext().getResources().getString(e.j.tbtitle_tip_detail2);
        String string2 = getPageContext().getResources().getString(e.j.tbtitle_tip_tieba_bar);
        int length = string2.length();
        int indexOf = string.indexOf(string2);
        SpannableString spannableString = new SpannableString(string);
        spannableString.setSpan(this.dJA, indexOf, length + indexOf, 33);
        this.dJv.setText(spannableString);
        this.dJv.setMovementMethod(LinkMovementMethod.getInstance());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.forumMember.tbtitle.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0216a extends ClickableSpan {
        private View.OnClickListener aIs;

        public C0216a(View.OnClickListener onClickListener) {
            this.aIs = onClickListener;
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            textPaint.setColor(al.getColor(e.d.cp_link_tip_a));
            textPaint.setUnderlineText(false);
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View view) {
            this.aIs.onClick(view);
        }
    }

    public void bC(List<LevelInfo> list) {
        this.dJy = list;
        if (this.dJs != null && this.dJy != null && this.dJy.size() != 0) {
            this.dJs.removeAllViews();
            for (int i = 1; i <= list.size(); i++) {
                LevelInfo levelInfo = list.get(i - 1);
                View inflate = LayoutInflater.from(this.dJr.getPageContext().getContext()).inflate(e.h.tbtitle_table_item, (ViewGroup) null);
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
                this.dJs.addView(inflate);
            }
        }
    }

    public void a(DataRes dataRes) {
        this.dJz = dataRes;
        if (this.dJz != null) {
            if (this.dJz.is_like.intValue() == 1 && this.dJx != null) {
                this.dJx.setVisibility(8);
            }
            if (this.dJt != null) {
                if (StringUtils.isNull(this.dJz.level_name, true)) {
                    this.dJt.setText(this.dJz.level_name);
                } else {
                    this.dJt.setVisibility(8);
                }
            }
            if (this.dJu != null) {
                if (this.dJz.user_level.intValue() <= 0 || this.dJz.user_level.intValue() > 18) {
                    this.dJu.setVisibility(8);
                } else {
                    al.c(this.dJu, BitmapHelper.getGradeResourceIdNew(this.dJz.user_level.intValue()));
                }
            }
        }
    }

    private void aAP() {
        this.dJw.setOnClickListener(this.dJm);
        this.dJv.setOnClickListener(this.dJm);
    }

    public void ej(int i) {
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(this.dJr.getPageContext(), i);
        }
        if (this.bPm != null) {
            this.bPm.onChangeSkinType(this.dJr.getPageContext(), i);
        }
        bC(this.dJy);
        a(this.dJz);
        this.dJr.getLayoutMode().setNightMode(i == 1);
        this.dJr.getLayoutMode().onModeChanged(this.mRootView);
    }

    public void op(String str) {
        this.bIl.setVisibility(8);
        this.dJr.showNetRefreshView(this.mRootView, str, true);
        this.dJr.setNetRefreshViewTopMargin(400);
    }

    public void aAQ() {
        this.bIl.setVisibility(0);
        this.dJr.hideNetRefreshView(this.mRootView);
    }

    public void showLoadingView() {
        this.bIl.setVisibility(8);
        this.dJr.showLoadingView(this.mRootView, true);
    }

    public void aAR() {
        this.bIl.setVisibility(0);
        this.dJr.hideLoadingView(this.mRootView);
    }

    public void h(NoNetworkView.a aVar) {
        if (aVar != null) {
            this.bPm.a(aVar);
        }
    }

    public void gs(boolean z) {
        if (!z) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.dxN.getLayoutParams();
            layoutParams.height = UtilHelper.getLightStatusBarHeight() + l.h(this.dJr.getActivity(), e.C0210e.ds170);
            this.dxN.setLayoutParams(layoutParams);
            return;
        }
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.dxN.getLayoutParams();
        layoutParams2.height = UtilHelper.getLightStatusBarHeight() + l.h(this.dJr.getActivity(), e.C0210e.ds88);
        this.dxN.setLayoutParams(layoutParams2);
    }
}
