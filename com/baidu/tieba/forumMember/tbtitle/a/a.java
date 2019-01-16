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
    private ScrollView bIk;
    private NoNetworkView bPl;
    private View.OnClickListener dJl;
    private TbTitleActivity dJq;
    private LinearLayout dJr;
    private TextView dJs;
    private ImageView dJt;
    private TextView dJu;
    private TextView dJv;
    public LinearLayout dJw;
    private List<LevelInfo> dJx;
    private DataRes dJy;
    private C0216a dJz;
    private View dxM;
    private NavigationBar mNavigationBar;
    private RelativeLayout mRootView;

    public a(TbTitleActivity tbTitleActivity, View.OnClickListener onClickListener) {
        super(tbTitleActivity.getPageContext());
        this.dJz = new C0216a(new View.OnClickListener() { // from class: com.baidu.tieba.forumMember.tbtitle.a.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(a.this.dJq.getPageContext().getContext()).createNormalCfg(a.this.getPageContext().getString(e.j.tieba_text), "from")));
            }
        });
        this.dJq = tbTitleActivity;
        this.dJl = onClickListener;
        initUI();
    }

    private void initUI() {
        this.mRootView = (RelativeLayout) LayoutInflater.from(this.dJq.getPageContext().getPageActivity()).inflate(e.h.tbtitle_activity, (ViewGroup) null);
        this.dJq.setContentView(this.mRootView);
        this.dxM = this.mRootView.findViewById(e.g.top_view);
        if (!j.kK()) {
            this.dxM.getLayoutParams().height = UtilHelper.getLightStatusBarHeight() + l.h(this.dJq.getActivity(), e.C0210e.ds170);
        } else {
            this.dxM.getLayoutParams().height = UtilHelper.getLightStatusBarHeight() + l.h(this.dJq.getActivity(), e.C0210e.ds88);
        }
        this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(e.g.view_navigation_bar);
        this.mNavigationBar.setCenterTextTitle(this.dJq.getString(e.j.tbtitle_title));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.showBottomLine();
        this.bIk = (ScrollView) this.mRootView.findViewById(e.g.tbtitle_scroll_view);
        this.dJw = (LinearLayout) this.mRootView.findViewById(e.g.first_line_layout);
        this.dJv = (TextView) this.mRootView.findViewById(e.g.tbtile_like_btn);
        this.dJr = (LinearLayout) this.mRootView.findViewById(e.g.table_canvas);
        this.dJs = (TextView) this.mRootView.findViewById(e.g.user_level_name);
        this.dJt = (ImageView) this.mRootView.findViewById(e.g.header_level_img);
        this.dJu = (TextView) this.mRootView.findViewById(e.g.tbtitle_tip_detail2);
        this.bPl = (NoNetworkView) this.mRootView.findViewById(e.g.view_no_network);
        aAO();
        aAP();
    }

    private void aAO() {
        String string = getPageContext().getResources().getString(e.j.tbtitle_tip_detail2);
        String string2 = getPageContext().getResources().getString(e.j.tbtitle_tip_tieba_bar);
        int length = string2.length();
        int indexOf = string.indexOf(string2);
        SpannableString spannableString = new SpannableString(string);
        spannableString.setSpan(this.dJz, indexOf, length + indexOf, 33);
        this.dJu.setText(spannableString);
        this.dJu.setMovementMethod(LinkMovementMethod.getInstance());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.forumMember.tbtitle.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0216a extends ClickableSpan {
        private View.OnClickListener aIr;

        public C0216a(View.OnClickListener onClickListener) {
            this.aIr = onClickListener;
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            textPaint.setColor(al.getColor(e.d.cp_link_tip_a));
            textPaint.setUnderlineText(false);
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View view) {
            this.aIr.onClick(view);
        }
    }

    public void bC(List<LevelInfo> list) {
        this.dJx = list;
        if (this.dJr != null && this.dJx != null && this.dJx.size() != 0) {
            this.dJr.removeAllViews();
            for (int i = 1; i <= list.size(); i++) {
                LevelInfo levelInfo = list.get(i - 1);
                View inflate = LayoutInflater.from(this.dJq.getPageContext().getContext()).inflate(e.h.tbtitle_table_item, (ViewGroup) null);
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
                this.dJr.addView(inflate);
            }
        }
    }

    public void a(DataRes dataRes) {
        this.dJy = dataRes;
        if (this.dJy != null) {
            if (this.dJy.is_like.intValue() == 1 && this.dJw != null) {
                this.dJw.setVisibility(8);
            }
            if (this.dJs != null) {
                if (StringUtils.isNull(this.dJy.level_name, true)) {
                    this.dJs.setText(this.dJy.level_name);
                } else {
                    this.dJs.setVisibility(8);
                }
            }
            if (this.dJt != null) {
                if (this.dJy.user_level.intValue() <= 0 || this.dJy.user_level.intValue() > 18) {
                    this.dJt.setVisibility(8);
                } else {
                    al.c(this.dJt, BitmapHelper.getGradeResourceIdNew(this.dJy.user_level.intValue()));
                }
            }
        }
    }

    private void aAP() {
        this.dJv.setOnClickListener(this.dJl);
        this.dJu.setOnClickListener(this.dJl);
    }

    public void ej(int i) {
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(this.dJq.getPageContext(), i);
        }
        if (this.bPl != null) {
            this.bPl.onChangeSkinType(this.dJq.getPageContext(), i);
        }
        bC(this.dJx);
        a(this.dJy);
        this.dJq.getLayoutMode().setNightMode(i == 1);
        this.dJq.getLayoutMode().onModeChanged(this.mRootView);
    }

    public void op(String str) {
        this.bIk.setVisibility(8);
        this.dJq.showNetRefreshView(this.mRootView, str, true);
        this.dJq.setNetRefreshViewTopMargin(400);
    }

    public void aAQ() {
        this.bIk.setVisibility(0);
        this.dJq.hideNetRefreshView(this.mRootView);
    }

    public void showLoadingView() {
        this.bIk.setVisibility(8);
        this.dJq.showLoadingView(this.mRootView, true);
    }

    public void aAR() {
        this.bIk.setVisibility(0);
        this.dJq.hideLoadingView(this.mRootView);
    }

    public void h(NoNetworkView.a aVar) {
        if (aVar != null) {
            this.bPl.a(aVar);
        }
    }

    public void gs(boolean z) {
        if (!z) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.dxM.getLayoutParams();
            layoutParams.height = UtilHelper.getLightStatusBarHeight() + l.h(this.dJq.getActivity(), e.C0210e.ds170);
            this.dxM.setLayoutParams(layoutParams);
            return;
        }
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.dxM.getLayoutParams();
        layoutParams2.height = UtilHelper.getLightStatusBarHeight() + l.h(this.dJq.getActivity(), e.C0210e.ds88);
        this.dxM.setLayoutParams(layoutParams2);
    }
}
