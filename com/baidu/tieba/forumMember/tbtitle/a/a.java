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
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
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
    private ScrollView bvD;
    private NoNetworkView dwI;
    private View flb;
    private View.OnClickListener fsS;
    private TbTitleActivity fsX;
    private LinearLayout fsY;
    private TextView fsZ;
    private ImageView fta;
    private TextView ftb;
    private TextView ftc;
    public LinearLayout ftd;
    private List<LevelInfo> fte;
    private DataRes ftf;
    private C0407a ftg;
    private NavigationBar mNavigationBar;
    private RelativeLayout mRootView;

    public a(TbTitleActivity tbTitleActivity, View.OnClickListener onClickListener) {
        super(tbTitleActivity.getPageContext());
        this.ftg = new C0407a(new View.OnClickListener() { // from class: com.baidu.tieba.forumMember.tbtitle.a.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(a.this.fsX.getPageContext().getContext()).createNormalCfg(a.this.getPageContext().getString(R.string.tieba_text), "from")));
            }
        });
        this.fsX = tbTitleActivity;
        this.fsS = onClickListener;
        initUI();
    }

    private void initUI() {
        this.mRootView = (RelativeLayout) LayoutInflater.from(this.fsX.getPageContext().getPageActivity()).inflate(R.layout.tbtitle_activity, (ViewGroup) null);
        this.fsX.setContentView(this.mRootView);
        this.flb = this.mRootView.findViewById(R.id.top_view);
        if (!j.isNetworkAvailableForImmediately()) {
            this.flb.getLayoutParams().height = UtilHelper.getLightStatusBarHeight() + l.getDimens(this.fsX.getActivity(), R.dimen.ds170);
        } else {
            this.flb.getLayoutParams().height = UtilHelper.getLightStatusBarHeight() + l.getDimens(this.fsX.getActivity(), R.dimen.ds88);
        }
        this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setCenterTextTitle(this.fsX.getString(R.string.tbtitle_title));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.showBottomLine();
        this.bvD = (ScrollView) this.mRootView.findViewById(R.id.tbtitle_scroll_view);
        this.ftd = (LinearLayout) this.mRootView.findViewById(R.id.first_line_layout);
        this.ftc = (TextView) this.mRootView.findViewById(R.id.tbtile_like_btn);
        this.fsY = (LinearLayout) this.mRootView.findViewById(R.id.table_canvas);
        this.fsZ = (TextView) this.mRootView.findViewById(R.id.user_level_name);
        this.fta = (ImageView) this.mRootView.findViewById(R.id.header_level_img);
        this.ftb = (TextView) this.mRootView.findViewById(R.id.tbtitle_tip_detail2);
        this.dwI = (NoNetworkView) this.mRootView.findViewById(R.id.view_no_network);
        biE();
        biF();
    }

    private void biE() {
        String string = getPageContext().getResources().getString(R.string.tbtitle_tip_detail2);
        String string2 = getPageContext().getResources().getString(R.string.tbtitle_tip_tieba_bar);
        int length = string2.length();
        int indexOf = string.indexOf(string2);
        SpannableString spannableString = new SpannableString(string);
        spannableString.setSpan(this.ftg, indexOf, length + indexOf, 33);
        this.ftb.setText(spannableString);
        this.ftb.setMovementMethod(LinkMovementMethod.getInstance());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.forumMember.tbtitle.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class C0407a extends ClickableSpan {
        private View.OnClickListener cpk;

        public C0407a(View.OnClickListener onClickListener) {
            this.cpk = onClickListener;
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            textPaint.setColor(am.getColor(R.color.cp_link_tip_a));
            textPaint.setUnderlineText(false);
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View view) {
            this.cpk.onClick(view);
        }
    }

    public void cj(List<LevelInfo> list) {
        this.fte = list;
        if (this.fsY != null && this.fte != null && this.fte.size() != 0) {
            this.fsY.removeAllViews();
            for (int i = 1; i <= list.size(); i++) {
                LevelInfo levelInfo = list.get(i - 1);
                View inflate = LayoutInflater.from(this.fsX.getPageContext().getContext()).inflate(R.layout.tbtitle_table_item, (ViewGroup) null);
                LinearLayout linearLayout = (LinearLayout) inflate.findViewById(R.id.table_item_background);
                TextView textView = (TextView) inflate.findViewById(R.id.table_item_level_name);
                TextView textView2 = (TextView) inflate.findViewById(R.id.table_item_need_experienment);
                View findViewById = inflate.findViewById(R.id.tbtile_item_horizontal_line);
                ImageView imageView = (ImageView) inflate.findViewById(R.id.table_item_level_img);
                if (i % 2 != 0) {
                    am.setBackgroundResource(linearLayout, R.color.cp_bg_line_e);
                }
                am.setViewTextColor(textView, R.color.cp_cont_b, 1);
                am.setViewTextColor(textView2, R.color.cp_cont_b, 1);
                am.setBackgroundColor(findViewById, R.color.cp_bg_line_c);
                am.setImageResource(imageView, BitmapHelper.getGradeResourceIdNew(levelInfo.id.intValue()));
                textView.setText(levelInfo.name);
                if (levelInfo.score.intValue() <= 3000000 && levelInfo.score.intValue() > 0) {
                    textView2.setText(levelInfo.score + "");
                } else if (levelInfo.score.intValue() <= 0) {
                    textView2.setText("0");
                } else {
                    textView2.setText("3000000");
                }
                this.fsY.addView(inflate);
            }
        }
    }

    public void a(DataRes dataRes) {
        this.ftf = dataRes;
        if (this.ftf != null) {
            if (this.ftf.is_like.intValue() == 1 && this.ftd != null) {
                this.ftd.setVisibility(8);
            }
            if (this.fsZ != null) {
                if (StringUtils.isNull(this.ftf.level_name, true)) {
                    this.fsZ.setText(this.ftf.level_name);
                } else {
                    this.fsZ.setVisibility(8);
                }
            }
            if (this.fta != null) {
                if (this.ftf.user_level.intValue() <= 0 || this.ftf.user_level.intValue() > 18) {
                    this.fta.setVisibility(8);
                } else {
                    am.setImageResource(this.fta, BitmapHelper.getGradeResourceIdNew(this.ftf.user_level.intValue()));
                }
            }
        }
    }

    private void biF() {
        this.ftc.setOnClickListener(this.fsS);
        this.ftb.setOnClickListener(this.fsS);
    }

    public void onSkinTypeChanged(int i) {
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(this.fsX.getPageContext(), i);
        }
        if (this.dwI != null) {
            this.dwI.onChangeSkinType(this.fsX.getPageContext(), i);
        }
        cj(this.fte);
        a(this.ftf);
        this.fsX.getLayoutMode().setNightMode(i == 1);
        this.fsX.getLayoutMode().onModeChanged(this.mRootView);
    }

    public void vH(String str) {
        this.bvD.setVisibility(8);
        this.fsX.showNetRefreshView(this.mRootView, str, true);
        this.fsX.setNetRefreshViewTopMargin(400);
    }

    public void biG() {
        this.bvD.setVisibility(0);
        this.fsX.hideNetRefreshView(this.mRootView);
    }

    public void showLoadingView() {
        this.bvD.setVisibility(8);
        this.fsX.showLoadingView(this.mRootView, true);
    }

    public void biH() {
        this.bvD.setVisibility(0);
        this.fsX.hideLoadingView(this.mRootView);
    }

    public void h(NoNetworkView.a aVar) {
        if (aVar != null) {
            this.dwI.a(aVar);
        }
    }

    public void jy(boolean z) {
        if (!z) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.flb.getLayoutParams();
            layoutParams.height = UtilHelper.getLightStatusBarHeight() + l.getDimens(this.fsX.getActivity(), R.dimen.ds170);
            this.flb.setLayoutParams(layoutParams);
            return;
        }
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.flb.getLayoutParams();
        layoutParams2.height = UtilHelper.getLightStatusBarHeight() + l.getDimens(this.fsX.getActivity(), R.dimen.ds88);
        this.flb.setLayoutParams(layoutParams2);
    }
}
