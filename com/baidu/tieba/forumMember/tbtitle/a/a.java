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
/* loaded from: classes7.dex */
public class a extends c<TbTitleActivity> {
    private ScrollView bes;
    private NoNetworkView egT;
    private View fYJ;
    private TbTitleActivity ggC;
    private LinearLayout ggD;
    private TextView ggE;
    private ImageView ggF;
    private TextView ggG;
    private TextView ggH;
    public LinearLayout ggI;
    private List<LevelInfo> ggJ;
    private DataRes ggK;
    private C0490a ggL;
    private View.OnClickListener ggx;
    private NavigationBar mNavigationBar;
    private RelativeLayout mRootView;

    public a(TbTitleActivity tbTitleActivity, View.OnClickListener onClickListener) {
        super(tbTitleActivity.getPageContext());
        this.ggL = new C0490a(new View.OnClickListener() { // from class: com.baidu.tieba.forumMember.tbtitle.a.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(a.this.ggC.getPageContext().getContext()).createNormalCfg(a.this.getPageContext().getString(R.string.tieba_text), "from")));
            }
        });
        this.ggC = tbTitleActivity;
        this.ggx = onClickListener;
        initUI();
    }

    private void initUI() {
        this.mRootView = (RelativeLayout) LayoutInflater.from(this.ggC.getPageContext().getPageActivity()).inflate(R.layout.tbtitle_activity, (ViewGroup) null);
        this.ggC.setContentView(this.mRootView);
        this.fYJ = this.mRootView.findViewById(R.id.top_view);
        if (!j.isNetworkAvailableForImmediately()) {
            this.fYJ.getLayoutParams().height = UtilHelper.getLightStatusBarHeight() + l.getDimens(this.ggC.getActivity(), R.dimen.ds170);
        } else {
            this.fYJ.getLayoutParams().height = UtilHelper.getLightStatusBarHeight() + l.getDimens(this.ggC.getActivity(), R.dimen.ds88);
        }
        this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setCenterTextTitle(this.ggC.getString(R.string.tbtitle_title));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.showBottomLine();
        this.bes = (ScrollView) this.mRootView.findViewById(R.id.tbtitle_scroll_view);
        this.ggI = (LinearLayout) this.mRootView.findViewById(R.id.first_line_layout);
        this.ggH = (TextView) this.mRootView.findViewById(R.id.tbtile_like_btn);
        this.ggD = (LinearLayout) this.mRootView.findViewById(R.id.table_canvas);
        this.ggE = (TextView) this.mRootView.findViewById(R.id.user_level_name);
        this.ggF = (ImageView) this.mRootView.findViewById(R.id.header_level_img);
        this.ggG = (TextView) this.mRootView.findViewById(R.id.tbtitle_tip_detail2);
        this.egT = (NoNetworkView) this.mRootView.findViewById(R.id.view_no_network);
        bzX();
        bzY();
    }

    private void bzX() {
        String string = getPageContext().getResources().getString(R.string.tbtitle_tip_detail2);
        String string2 = getPageContext().getResources().getString(R.string.tbtitle_tip_tieba_bar);
        int length = string2.length();
        int indexOf = string.indexOf(string2);
        SpannableString spannableString = new SpannableString(string);
        spannableString.setSpan(this.ggL, indexOf, length + indexOf, 33);
        this.ggG.setText(spannableString);
        this.ggG.setMovementMethod(LinkMovementMethod.getInstance());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.forumMember.tbtitle.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public class C0490a extends ClickableSpan {
        private View.OnClickListener dbH;

        public C0490a(View.OnClickListener onClickListener) {
            this.dbH = onClickListener;
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            textPaint.setColor(am.getColor(R.color.cp_link_tip_a));
            textPaint.setUnderlineText(false);
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View view) {
            this.dbH.onClick(view);
        }
    }

    public void cf(List<LevelInfo> list) {
        this.ggJ = list;
        if (this.ggD != null && this.ggJ != null && this.ggJ.size() != 0) {
            this.ggD.removeAllViews();
            for (int i = 1; i <= list.size(); i++) {
                LevelInfo levelInfo = list.get(i - 1);
                View inflate = LayoutInflater.from(this.ggC.getPageContext().getContext()).inflate(R.layout.tbtitle_table_item, (ViewGroup) null);
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
                this.ggD.addView(inflate);
            }
        }
    }

    public void a(DataRes dataRes) {
        this.ggK = dataRes;
        if (this.ggK != null) {
            if (this.ggK.is_like.intValue() == 1 && this.ggI != null) {
                this.ggI.setVisibility(8);
            }
            if (this.ggE != null) {
                if (StringUtils.isNull(this.ggK.level_name, true)) {
                    this.ggE.setText(this.ggK.level_name);
                } else {
                    this.ggE.setVisibility(8);
                }
            }
            if (this.ggF != null) {
                if (this.ggK.user_level.intValue() <= 0 || this.ggK.user_level.intValue() > 18) {
                    this.ggF.setVisibility(8);
                } else {
                    am.setImageResource(this.ggF, BitmapHelper.getGradeResourceIdNew(this.ggK.user_level.intValue()));
                }
            }
        }
    }

    private void bzY() {
        this.ggH.setOnClickListener(this.ggx);
        this.ggG.setOnClickListener(this.ggx);
    }

    public void onSkinTypeChanged(int i) {
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(this.ggC.getPageContext(), i);
        }
        if (this.egT != null) {
            this.egT.onChangeSkinType(this.ggC.getPageContext(), i);
        }
        cf(this.ggJ);
        a(this.ggK);
        this.ggC.getLayoutMode().setNightMode(i == 1);
        this.ggC.getLayoutMode().onModeChanged(this.mRootView);
    }

    public void Az(String str) {
        this.bes.setVisibility(8);
        this.ggC.showNetRefreshView(this.mRootView, str, true);
        this.ggC.setNetRefreshViewTopMargin(400);
    }

    public void bzZ() {
        this.bes.setVisibility(0);
        this.ggC.hideNetRefreshView(this.mRootView);
    }

    public void showLoadingView() {
        this.bes.setVisibility(8);
        this.ggC.showLoadingView(this.mRootView, true);
    }

    public void bAa() {
        this.bes.setVisibility(0);
        this.ggC.hideLoadingView(this.mRootView);
    }

    public void g(NoNetworkView.a aVar) {
        if (aVar != null) {
            this.egT.a(aVar);
        }
    }

    public void kK(boolean z) {
        if (!z) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.fYJ.getLayoutParams();
            layoutParams.height = UtilHelper.getLightStatusBarHeight() + l.getDimens(this.ggC.getActivity(), R.dimen.ds170);
            this.fYJ.setLayoutParams(layoutParams);
            return;
        }
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.fYJ.getLayoutParams();
        layoutParams2.height = UtilHelper.getLightStatusBarHeight() + l.getDimens(this.ggC.getActivity(), R.dimen.ds88);
        this.fYJ.setLayoutParams(layoutParams2);
    }
}
