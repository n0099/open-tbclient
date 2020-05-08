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
/* loaded from: classes10.dex */
public class a extends c<TbTitleActivity> {
    private ScrollView bHY;
    private NoNetworkView ePq;
    private View gOf;
    private View.OnClickListener gVR;
    private TbTitleActivity gVW;
    private LinearLayout gVX;
    private TextView gVY;
    private ImageView gVZ;
    private TextView gWa;
    private TextView gWb;
    public LinearLayout gWc;
    private List<LevelInfo> gWd;
    private DataRes gWe;
    private C0559a gWf;
    private NavigationBar mNavigationBar;
    private RelativeLayout mRootView;

    public a(TbTitleActivity tbTitleActivity, View.OnClickListener onClickListener) {
        super(tbTitleActivity.getPageContext());
        this.gWf = new C0559a(new View.OnClickListener() { // from class: com.baidu.tieba.forumMember.tbtitle.a.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(a.this.gVW.getPageContext().getContext()).createNormalCfg(a.this.getPageContext().getString(R.string.tieba_text), "from")));
            }
        });
        this.gVW = tbTitleActivity;
        this.gVR = onClickListener;
        initUI();
    }

    private void initUI() {
        this.mRootView = (RelativeLayout) LayoutInflater.from(this.gVW.getPageContext().getPageActivity()).inflate(R.layout.tbtitle_activity, (ViewGroup) null);
        this.gVW.setContentView(this.mRootView);
        this.gOf = this.mRootView.findViewById(R.id.top_view);
        if (!j.isNetworkAvailableForImmediately()) {
            this.gOf.getLayoutParams().height = UtilHelper.getLightStatusBarHeight() + l.getDimens(this.gVW.getActivity(), R.dimen.ds170);
        } else {
            this.gOf.getLayoutParams().height = UtilHelper.getLightStatusBarHeight() + l.getDimens(this.gVW.getActivity(), R.dimen.ds88);
        }
        this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setCenterTextTitle(this.gVW.getString(R.string.tbtitle_title));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.showBottomLine();
        this.bHY = (ScrollView) this.mRootView.findViewById(R.id.tbtitle_scroll_view);
        this.gWc = (LinearLayout) this.mRootView.findViewById(R.id.first_line_layout);
        this.gWb = (TextView) this.mRootView.findViewById(R.id.tbtile_like_btn);
        this.gVX = (LinearLayout) this.mRootView.findViewById(R.id.table_canvas);
        this.gVY = (TextView) this.mRootView.findViewById(R.id.user_level_name);
        this.gVZ = (ImageView) this.mRootView.findViewById(R.id.header_level_img);
        this.gWa = (TextView) this.mRootView.findViewById(R.id.tbtitle_tip_detail2);
        this.ePq = (NoNetworkView) this.mRootView.findViewById(R.id.view_no_network);
        bNi();
        bNj();
    }

    private void bNi() {
        String string = getPageContext().getResources().getString(R.string.tbtitle_tip_detail2);
        String string2 = getPageContext().getResources().getString(R.string.tbtitle_tip_tieba_bar);
        int length = string2.length();
        int indexOf = string.indexOf(string2);
        SpannableString spannableString = new SpannableString(string);
        spannableString.setSpan(this.gWf, indexOf, length + indexOf, 33);
        this.gWa.setText(spannableString);
        this.gWa.setMovementMethod(LinkMovementMethod.getInstance());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.forumMember.tbtitle.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public class C0559a extends ClickableSpan {
        private View.OnClickListener dFZ;

        public C0559a(View.OnClickListener onClickListener) {
            this.dFZ = onClickListener;
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            textPaint.setColor(am.getColor(R.color.cp_link_tip_a));
            textPaint.setUnderlineText(false);
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View view) {
            this.dFZ.onClick(view);
        }
    }

    public void cn(List<LevelInfo> list) {
        this.gWd = list;
        if (this.gVX != null && this.gWd != null && this.gWd.size() != 0) {
            this.gVX.removeAllViews();
            for (int i = 1; i <= list.size(); i++) {
                LevelInfo levelInfo = list.get(i - 1);
                View inflate = LayoutInflater.from(this.gVW.getPageContext().getContext()).inflate(R.layout.tbtitle_table_item, (ViewGroup) null);
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
                this.gVX.addView(inflate);
            }
        }
    }

    public void a(DataRes dataRes) {
        this.gWe = dataRes;
        if (this.gWe != null) {
            if (this.gWe.is_like.intValue() == 1 && this.gWc != null) {
                this.gWc.setVisibility(8);
            }
            if (this.gVY != null) {
                if (StringUtils.isNull(this.gWe.level_name, true)) {
                    this.gVY.setText(this.gWe.level_name);
                } else {
                    this.gVY.setVisibility(8);
                }
            }
            if (this.gVZ != null) {
                if (this.gWe.user_level.intValue() <= 0 || this.gWe.user_level.intValue() > 18) {
                    this.gVZ.setVisibility(8);
                } else {
                    am.setImageResource(this.gVZ, BitmapHelper.getGradeResourceIdNew(this.gWe.user_level.intValue()));
                }
            }
        }
    }

    private void bNj() {
        this.gWb.setOnClickListener(this.gVR);
        this.gWa.setOnClickListener(this.gVR);
    }

    public void onSkinTypeChanged(int i) {
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(this.gVW.getPageContext(), i);
        }
        if (this.ePq != null) {
            this.ePq.onChangeSkinType(this.gVW.getPageContext(), i);
        }
        cn(this.gWd);
        a(this.gWe);
        this.gVW.getLayoutMode().setNightMode(i == 1);
        this.gVW.getLayoutMode().onModeChanged(this.mRootView);
    }

    public void CP(String str) {
        this.bHY.setVisibility(8);
        this.gVW.showNetRefreshView(this.mRootView, str, true);
        this.gVW.setNetRefreshViewTopMargin(400);
    }

    public void bNk() {
        this.bHY.setVisibility(0);
        this.gVW.hideNetRefreshView(this.mRootView);
    }

    public void showLoadingView() {
        this.bHY.setVisibility(8);
        this.gVW.showLoadingView(this.mRootView, true);
    }

    public void bNl() {
        this.bHY.setVisibility(0);
        this.gVW.hideLoadingView(this.mRootView);
    }

    public void g(NoNetworkView.a aVar) {
        if (aVar != null) {
            this.ePq.a(aVar);
        }
    }

    public void mj(boolean z) {
        if (!z) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.gOf.getLayoutParams();
            layoutParams.height = UtilHelper.getLightStatusBarHeight() + l.getDimens(this.gVW.getActivity(), R.dimen.ds170);
            this.gOf.setLayoutParams(layoutParams);
            return;
        }
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.gOf.getLayoutParams();
        layoutParams2.height = UtilHelper.getLightStatusBarHeight() + l.getDimens(this.gVW.getActivity(), R.dimen.ds88);
        this.gOf.setLayoutParams(layoutParams2);
    }
}
