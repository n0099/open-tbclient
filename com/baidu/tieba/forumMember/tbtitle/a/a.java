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
import com.baidu.tieba.R;
import com.baidu.tieba.forumMember.tbtitle.TbTitleActivity;
import java.util.List;
import tbclient.GetLevelInfo.DataRes;
import tbclient.LevelInfo;
/* loaded from: classes5.dex */
public class a extends c<TbTitleActivity> {
    private ScrollView bcg;
    private NoNetworkView dnF;
    private View fga;
    private TextView frA;
    private ImageView frB;
    private TextView frC;
    private TextView frD;
    public LinearLayout frE;
    private List<LevelInfo> frF;
    private DataRes frG;
    private C0301a frH;
    private View.OnClickListener frt;
    private TbTitleActivity fry;
    private LinearLayout frz;
    private NavigationBar mNavigationBar;
    private RelativeLayout mRootView;

    public a(TbTitleActivity tbTitleActivity, View.OnClickListener onClickListener) {
        super(tbTitleActivity.getPageContext());
        this.frH = new C0301a(new View.OnClickListener() { // from class: com.baidu.tieba.forumMember.tbtitle.a.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(a.this.fry.getPageContext().getContext()).createNormalCfg(a.this.getPageContext().getString(R.string.tieba_text), "from")));
            }
        });
        this.fry = tbTitleActivity;
        this.frt = onClickListener;
        initUI();
    }

    private void initUI() {
        this.mRootView = (RelativeLayout) LayoutInflater.from(this.fry.getPageContext().getPageActivity()).inflate(R.layout.tbtitle_activity, (ViewGroup) null);
        this.fry.setContentView(this.mRootView);
        this.fga = this.mRootView.findViewById(R.id.top_view);
        if (!j.jQ()) {
            this.fga.getLayoutParams().height = UtilHelper.getLightStatusBarHeight() + l.g(this.fry.getActivity(), R.dimen.ds170);
        } else {
            this.fga.getLayoutParams().height = UtilHelper.getLightStatusBarHeight() + l.g(this.fry.getActivity(), R.dimen.ds88);
        }
        this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setCenterTextTitle(this.fry.getString(R.string.tbtitle_title));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.showBottomLine();
        this.bcg = (ScrollView) this.mRootView.findViewById(R.id.tbtitle_scroll_view);
        this.frE = (LinearLayout) this.mRootView.findViewById(R.id.first_line_layout);
        this.frD = (TextView) this.mRootView.findViewById(R.id.tbtile_like_btn);
        this.frz = (LinearLayout) this.mRootView.findViewById(R.id.table_canvas);
        this.frA = (TextView) this.mRootView.findViewById(R.id.user_level_name);
        this.frB = (ImageView) this.mRootView.findViewById(R.id.header_level_img);
        this.frC = (TextView) this.mRootView.findViewById(R.id.tbtitle_tip_detail2);
        this.dnF = (NoNetworkView) this.mRootView.findViewById(R.id.view_no_network);
        bkG();
        bkH();
    }

    private void bkG() {
        String string = getPageContext().getResources().getString(R.string.tbtitle_tip_detail2);
        String string2 = getPageContext().getResources().getString(R.string.tbtitle_tip_tieba_bar);
        int length = string2.length();
        int indexOf = string.indexOf(string2);
        SpannableString spannableString = new SpannableString(string);
        spannableString.setSpan(this.frH, indexOf, length + indexOf, 33);
        this.frC.setText(spannableString);
        this.frC.setMovementMethod(LinkMovementMethod.getInstance());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.forumMember.tbtitle.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class C0301a extends ClickableSpan {
        private View.OnClickListener bZH;

        public C0301a(View.OnClickListener onClickListener) {
            this.bZH = onClickListener;
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            textPaint.setColor(am.getColor(R.color.cp_link_tip_a));
            textPaint.setUnderlineText(false);
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View view) {
            this.bZH.onClick(view);
        }
    }

    public void bW(List<LevelInfo> list) {
        this.frF = list;
        if (this.frz != null && this.frF != null && this.frF.size() != 0) {
            this.frz.removeAllViews();
            for (int i = 1; i <= list.size(); i++) {
                LevelInfo levelInfo = list.get(i - 1);
                View inflate = LayoutInflater.from(this.fry.getPageContext().getContext()).inflate(R.layout.tbtitle_table_item, (ViewGroup) null);
                LinearLayout linearLayout = (LinearLayout) inflate.findViewById(R.id.table_item_background);
                TextView textView = (TextView) inflate.findViewById(R.id.table_item_level_name);
                TextView textView2 = (TextView) inflate.findViewById(R.id.table_item_need_experienment);
                View findViewById = inflate.findViewById(R.id.tbtile_item_horizontal_line);
                ImageView imageView = (ImageView) inflate.findViewById(R.id.table_item_level_img);
                if (i % 2 != 0) {
                    am.k(linearLayout, R.color.cp_bg_line_e);
                }
                am.f(textView, R.color.cp_cont_b, 1);
                am.f(textView2, R.color.cp_cont_b, 1);
                am.l(findViewById, R.color.cp_bg_line_b);
                am.c(imageView, BitmapHelper.getGradeResourceIdNew(levelInfo.id.intValue()));
                textView.setText(levelInfo.name);
                if (levelInfo.score.intValue() <= 3000000 && levelInfo.score.intValue() > 0) {
                    textView2.setText(levelInfo.score + "");
                } else if (levelInfo.score.intValue() <= 0) {
                    textView2.setText("0");
                } else {
                    textView2.setText("3000000");
                }
                this.frz.addView(inflate);
            }
        }
    }

    public void a(DataRes dataRes) {
        this.frG = dataRes;
        if (this.frG != null) {
            if (this.frG.is_like.intValue() == 1 && this.frE != null) {
                this.frE.setVisibility(8);
            }
            if (this.frA != null) {
                if (StringUtils.isNull(this.frG.level_name, true)) {
                    this.frA.setText(this.frG.level_name);
                } else {
                    this.frA.setVisibility(8);
                }
            }
            if (this.frB != null) {
                if (this.frG.user_level.intValue() <= 0 || this.frG.user_level.intValue() > 18) {
                    this.frB.setVisibility(8);
                } else {
                    am.c(this.frB, BitmapHelper.getGradeResourceIdNew(this.frG.user_level.intValue()));
                }
            }
        }
    }

    private void bkH() {
        this.frD.setOnClickListener(this.frt);
        this.frC.setOnClickListener(this.frt);
    }

    public void iG(int i) {
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(this.fry.getPageContext(), i);
        }
        if (this.dnF != null) {
            this.dnF.onChangeSkinType(this.fry.getPageContext(), i);
        }
        bW(this.frF);
        a(this.frG);
        this.fry.getLayoutMode().setNightMode(i == 1);
        this.fry.getLayoutMode().onModeChanged(this.mRootView);
    }

    public void wP(String str) {
        this.bcg.setVisibility(8);
        this.fry.showNetRefreshView(this.mRootView, str, true);
        this.fry.setNetRefreshViewTopMargin(400);
    }

    public void bkI() {
        this.bcg.setVisibility(0);
        this.fry.hideNetRefreshView(this.mRootView);
    }

    public void showLoadingView() {
        this.bcg.setVisibility(8);
        this.fry.showLoadingView(this.mRootView, true);
    }

    public void bkJ() {
        this.bcg.setVisibility(0);
        this.fry.hideLoadingView(this.mRootView);
    }

    public void h(NoNetworkView.a aVar) {
        if (aVar != null) {
            this.dnF.a(aVar);
        }
    }

    public void jH(boolean z) {
        if (!z) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.fga.getLayoutParams();
            layoutParams.height = UtilHelper.getLightStatusBarHeight() + l.g(this.fry.getActivity(), R.dimen.ds170);
            this.fga.setLayoutParams(layoutParams);
            return;
        }
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.fga.getLayoutParams();
        layoutParams2.height = UtilHelper.getLightStatusBarHeight() + l.g(this.fry.getActivity(), R.dimen.ds88);
        this.fga.setLayoutParams(layoutParams2);
    }
}
