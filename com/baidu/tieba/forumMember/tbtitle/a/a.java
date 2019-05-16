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
import com.baidu.tieba.R;
import com.baidu.tieba.forumMember.tbtitle.TbTitleActivity;
import java.util.List;
import tbclient.GetLevelInfo.DataRes;
import tbclient.LevelInfo;
/* loaded from: classes5.dex */
public class a extends c<TbTitleActivity> {
    private ScrollView bbv;
    private NoNetworkView dlW;
    private View faZ;
    private TextView fmA;
    private ImageView fmB;
    private TextView fmC;
    private TextView fmD;
    public LinearLayout fmE;
    private List<LevelInfo> fmF;
    private DataRes fmG;
    private C0304a fmH;
    private View.OnClickListener fmt;
    private TbTitleActivity fmy;
    private LinearLayout fmz;
    private NavigationBar mNavigationBar;
    private RelativeLayout mRootView;

    public a(TbTitleActivity tbTitleActivity, View.OnClickListener onClickListener) {
        super(tbTitleActivity.getPageContext());
        this.fmH = new C0304a(new View.OnClickListener() { // from class: com.baidu.tieba.forumMember.tbtitle.a.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(a.this.fmy.getPageContext().getContext()).createNormalCfg(a.this.getPageContext().getString(R.string.tieba_text), "from")));
            }
        });
        this.fmy = tbTitleActivity;
        this.fmt = onClickListener;
        initUI();
    }

    private void initUI() {
        this.mRootView = (RelativeLayout) LayoutInflater.from(this.fmy.getPageContext().getPageActivity()).inflate(R.layout.tbtitle_activity, (ViewGroup) null);
        this.fmy.setContentView(this.mRootView);
        this.faZ = this.mRootView.findViewById(R.id.top_view);
        if (!j.jG()) {
            this.faZ.getLayoutParams().height = UtilHelper.getLightStatusBarHeight() + l.g(this.fmy.getActivity(), R.dimen.ds170);
        } else {
            this.faZ.getLayoutParams().height = UtilHelper.getLightStatusBarHeight() + l.g(this.fmy.getActivity(), R.dimen.ds88);
        }
        this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setCenterTextTitle(this.fmy.getString(R.string.tbtitle_title));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.showBottomLine();
        this.bbv = (ScrollView) this.mRootView.findViewById(R.id.tbtitle_scroll_view);
        this.fmE = (LinearLayout) this.mRootView.findViewById(R.id.first_line_layout);
        this.fmD = (TextView) this.mRootView.findViewById(R.id.tbtile_like_btn);
        this.fmz = (LinearLayout) this.mRootView.findViewById(R.id.table_canvas);
        this.fmA = (TextView) this.mRootView.findViewById(R.id.user_level_name);
        this.fmB = (ImageView) this.mRootView.findViewById(R.id.header_level_img);
        this.fmC = (TextView) this.mRootView.findViewById(R.id.tbtitle_tip_detail2);
        this.dlW = (NoNetworkView) this.mRootView.findViewById(R.id.view_no_network);
        biB();
        biC();
    }

    private void biB() {
        String string = getPageContext().getResources().getString(R.string.tbtitle_tip_detail2);
        String string2 = getPageContext().getResources().getString(R.string.tbtitle_tip_tieba_bar);
        int length = string2.length();
        int indexOf = string.indexOf(string2);
        SpannableString spannableString = new SpannableString(string);
        spannableString.setSpan(this.fmH, indexOf, length + indexOf, 33);
        this.fmC.setText(spannableString);
        this.fmC.setMovementMethod(LinkMovementMethod.getInstance());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.forumMember.tbtitle.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class C0304a extends ClickableSpan {
        private View.OnClickListener bYE;

        public C0304a(View.OnClickListener onClickListener) {
            this.bYE = onClickListener;
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            textPaint.setColor(al.getColor(R.color.cp_link_tip_a));
            textPaint.setUnderlineText(false);
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View view) {
            this.bYE.onClick(view);
        }
    }

    public void bV(List<LevelInfo> list) {
        this.fmF = list;
        if (this.fmz != null && this.fmF != null && this.fmF.size() != 0) {
            this.fmz.removeAllViews();
            for (int i = 1; i <= list.size(); i++) {
                LevelInfo levelInfo = list.get(i - 1);
                View inflate = LayoutInflater.from(this.fmy.getPageContext().getContext()).inflate(R.layout.tbtitle_table_item, (ViewGroup) null);
                LinearLayout linearLayout = (LinearLayout) inflate.findViewById(R.id.table_item_background);
                TextView textView = (TextView) inflate.findViewById(R.id.table_item_level_name);
                TextView textView2 = (TextView) inflate.findViewById(R.id.table_item_need_experienment);
                View findViewById = inflate.findViewById(R.id.tbtile_item_horizontal_line);
                ImageView imageView = (ImageView) inflate.findViewById(R.id.table_item_level_img);
                if (i % 2 != 0) {
                    al.k(linearLayout, R.color.cp_bg_line_e);
                }
                al.f(textView, R.color.cp_cont_b, 1);
                al.f(textView2, R.color.cp_cont_b, 1);
                al.l(findViewById, R.color.cp_bg_line_b);
                al.c(imageView, BitmapHelper.getGradeResourceIdNew(levelInfo.id.intValue()));
                textView.setText(levelInfo.name);
                if (levelInfo.score.intValue() <= 3000000 && levelInfo.score.intValue() > 0) {
                    textView2.setText(levelInfo.score + "");
                } else if (levelInfo.score.intValue() <= 0) {
                    textView2.setText("0");
                } else {
                    textView2.setText("3000000");
                }
                this.fmz.addView(inflate);
            }
        }
    }

    public void a(DataRes dataRes) {
        this.fmG = dataRes;
        if (this.fmG != null) {
            if (this.fmG.is_like.intValue() == 1 && this.fmE != null) {
                this.fmE.setVisibility(8);
            }
            if (this.fmA != null) {
                if (StringUtils.isNull(this.fmG.level_name, true)) {
                    this.fmA.setText(this.fmG.level_name);
                } else {
                    this.fmA.setVisibility(8);
                }
            }
            if (this.fmB != null) {
                if (this.fmG.user_level.intValue() <= 0 || this.fmG.user_level.intValue() > 18) {
                    this.fmB.setVisibility(8);
                } else {
                    al.c(this.fmB, BitmapHelper.getGradeResourceIdNew(this.fmG.user_level.intValue()));
                }
            }
        }
    }

    private void biC() {
        this.fmD.setOnClickListener(this.fmt);
        this.fmC.setOnClickListener(this.fmt);
    }

    public void iA(int i) {
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(this.fmy.getPageContext(), i);
        }
        if (this.dlW != null) {
            this.dlW.onChangeSkinType(this.fmy.getPageContext(), i);
        }
        bV(this.fmF);
        a(this.fmG);
        this.fmy.getLayoutMode().setNightMode(i == 1);
        this.fmy.getLayoutMode().onModeChanged(this.mRootView);
    }

    public void wl(String str) {
        this.bbv.setVisibility(8);
        this.fmy.showNetRefreshView(this.mRootView, str, true);
        this.fmy.setNetRefreshViewTopMargin(400);
    }

    public void biD() {
        this.bbv.setVisibility(0);
        this.fmy.hideNetRefreshView(this.mRootView);
    }

    public void showLoadingView() {
        this.bbv.setVisibility(8);
        this.fmy.showLoadingView(this.mRootView, true);
    }

    public void biE() {
        this.bbv.setVisibility(0);
        this.fmy.hideLoadingView(this.mRootView);
    }

    public void h(NoNetworkView.a aVar) {
        if (aVar != null) {
            this.dlW.a(aVar);
        }
    }

    public void jx(boolean z) {
        if (!z) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.faZ.getLayoutParams();
            layoutParams.height = UtilHelper.getLightStatusBarHeight() + l.g(this.fmy.getActivity(), R.dimen.ds170);
            this.faZ.setLayoutParams(layoutParams);
            return;
        }
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.faZ.getLayoutParams();
        layoutParams2.height = UtilHelper.getLightStatusBarHeight() + l.g(this.fmy.getActivity(), R.dimen.ds88);
        this.faZ.setLayoutParams(layoutParams2);
    }
}
