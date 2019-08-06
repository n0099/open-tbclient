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
    private NoNetworkView dnM;
    private View fgA;
    private View.OnClickListener frS;
    private TbTitleActivity frX;
    private LinearLayout frY;
    private TextView frZ;
    private ImageView fsa;
    private TextView fsb;
    private TextView fsc;
    public LinearLayout fsd;
    private List<LevelInfo> fse;
    private DataRes fsf;
    private C0307a fsg;
    private NavigationBar mNavigationBar;
    private RelativeLayout mRootView;

    public a(TbTitleActivity tbTitleActivity, View.OnClickListener onClickListener) {
        super(tbTitleActivity.getPageContext());
        this.fsg = new C0307a(new View.OnClickListener() { // from class: com.baidu.tieba.forumMember.tbtitle.a.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(a.this.frX.getPageContext().getContext()).createNormalCfg(a.this.getPageContext().getString(R.string.tieba_text), "from")));
            }
        });
        this.frX = tbTitleActivity;
        this.frS = onClickListener;
        initUI();
    }

    private void initUI() {
        this.mRootView = (RelativeLayout) LayoutInflater.from(this.frX.getPageContext().getPageActivity()).inflate(R.layout.tbtitle_activity, (ViewGroup) null);
        this.frX.setContentView(this.mRootView);
        this.fgA = this.mRootView.findViewById(R.id.top_view);
        if (!j.jQ()) {
            this.fgA.getLayoutParams().height = UtilHelper.getLightStatusBarHeight() + l.g(this.frX.getActivity(), R.dimen.ds170);
        } else {
            this.fgA.getLayoutParams().height = UtilHelper.getLightStatusBarHeight() + l.g(this.frX.getActivity(), R.dimen.ds88);
        }
        this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setCenterTextTitle(this.frX.getString(R.string.tbtitle_title));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.showBottomLine();
        this.bcg = (ScrollView) this.mRootView.findViewById(R.id.tbtitle_scroll_view);
        this.fsd = (LinearLayout) this.mRootView.findViewById(R.id.first_line_layout);
        this.fsc = (TextView) this.mRootView.findViewById(R.id.tbtile_like_btn);
        this.frY = (LinearLayout) this.mRootView.findViewById(R.id.table_canvas);
        this.frZ = (TextView) this.mRootView.findViewById(R.id.user_level_name);
        this.fsa = (ImageView) this.mRootView.findViewById(R.id.header_level_img);
        this.fsb = (TextView) this.mRootView.findViewById(R.id.tbtitle_tip_detail2);
        this.dnM = (NoNetworkView) this.mRootView.findViewById(R.id.view_no_network);
        bkN();
        bkO();
    }

    private void bkN() {
        String string = getPageContext().getResources().getString(R.string.tbtitle_tip_detail2);
        String string2 = getPageContext().getResources().getString(R.string.tbtitle_tip_tieba_bar);
        int length = string2.length();
        int indexOf = string.indexOf(string2);
        SpannableString spannableString = new SpannableString(string);
        spannableString.setSpan(this.fsg, indexOf, length + indexOf, 33);
        this.fsb.setText(spannableString);
        this.fsb.setMovementMethod(LinkMovementMethod.getInstance());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.forumMember.tbtitle.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class C0307a extends ClickableSpan {
        private View.OnClickListener bZN;

        public C0307a(View.OnClickListener onClickListener) {
            this.bZN = onClickListener;
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            textPaint.setColor(am.getColor(R.color.cp_link_tip_a));
            textPaint.setUnderlineText(false);
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View view) {
            this.bZN.onClick(view);
        }
    }

    public void bW(List<LevelInfo> list) {
        this.fse = list;
        if (this.frY != null && this.fse != null && this.fse.size() != 0) {
            this.frY.removeAllViews();
            for (int i = 1; i <= list.size(); i++) {
                LevelInfo levelInfo = list.get(i - 1);
                View inflate = LayoutInflater.from(this.frX.getPageContext().getContext()).inflate(R.layout.tbtitle_table_item, (ViewGroup) null);
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
                this.frY.addView(inflate);
            }
        }
    }

    public void a(DataRes dataRes) {
        this.fsf = dataRes;
        if (this.fsf != null) {
            if (this.fsf.is_like.intValue() == 1 && this.fsd != null) {
                this.fsd.setVisibility(8);
            }
            if (this.frZ != null) {
                if (StringUtils.isNull(this.fsf.level_name, true)) {
                    this.frZ.setText(this.fsf.level_name);
                } else {
                    this.frZ.setVisibility(8);
                }
            }
            if (this.fsa != null) {
                if (this.fsf.user_level.intValue() <= 0 || this.fsf.user_level.intValue() > 18) {
                    this.fsa.setVisibility(8);
                } else {
                    am.c(this.fsa, BitmapHelper.getGradeResourceIdNew(this.fsf.user_level.intValue()));
                }
            }
        }
    }

    private void bkO() {
        this.fsc.setOnClickListener(this.frS);
        this.fsb.setOnClickListener(this.frS);
    }

    public void iG(int i) {
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(this.frX.getPageContext(), i);
        }
        if (this.dnM != null) {
            this.dnM.onChangeSkinType(this.frX.getPageContext(), i);
        }
        bW(this.fse);
        a(this.fsf);
        this.frX.getLayoutMode().setNightMode(i == 1);
        this.frX.getLayoutMode().onModeChanged(this.mRootView);
    }

    public void wQ(String str) {
        this.bcg.setVisibility(8);
        this.frX.showNetRefreshView(this.mRootView, str, true);
        this.frX.setNetRefreshViewTopMargin(400);
    }

    public void bkP() {
        this.bcg.setVisibility(0);
        this.frX.hideNetRefreshView(this.mRootView);
    }

    public void showLoadingView() {
        this.bcg.setVisibility(8);
        this.frX.showLoadingView(this.mRootView, true);
    }

    public void bkQ() {
        this.bcg.setVisibility(0);
        this.frX.hideLoadingView(this.mRootView);
    }

    public void h(NoNetworkView.a aVar) {
        if (aVar != null) {
            this.dnM.a(aVar);
        }
    }

    public void jH(boolean z) {
        if (!z) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.fgA.getLayoutParams();
            layoutParams.height = UtilHelper.getLightStatusBarHeight() + l.g(this.frX.getActivity(), R.dimen.ds170);
            this.fgA.setLayoutParams(layoutParams);
            return;
        }
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.fgA.getLayoutParams();
        layoutParams2.height = UtilHelper.getLightStatusBarHeight() + l.g(this.frX.getActivity(), R.dimen.ds88);
        this.fgA.setLayoutParams(layoutParams2);
    }
}
