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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tieba.R;
import com.baidu.tieba.forumMember.tbtitle.TbTitleActivity;
import java.util.List;
import tbclient.GetLevelInfo.DataRes;
import tbclient.LevelInfo;
/* loaded from: classes23.dex */
public class a extends c<TbTitleActivity> {
    private ScrollView cEU;
    private NoNetworkView gjn;
    private TbTitleActivity iED;
    private LinearLayout iEE;
    private TextView iEF;
    private ImageView iEG;
    private TextView iEH;
    private TextView iEI;
    public LinearLayout iEJ;
    private List<LevelInfo> iEK;
    private DataRes iEL;
    private C0721a iEM;
    private View.OnClickListener iEy;
    private View iwP;
    private NavigationBar mNavigationBar;
    private RelativeLayout mRootView;

    public a(TbTitleActivity tbTitleActivity, View.OnClickListener onClickListener) {
        super(tbTitleActivity.getPageContext());
        this.iEM = new C0721a(new View.OnClickListener() { // from class: com.baidu.tieba.forumMember.tbtitle.a.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(a.this.iED.getPageContext().getContext()).createNormalCfg(a.this.getPageContext().getString(R.string.tieba_text), "from")));
            }
        });
        this.iED = tbTitleActivity;
        this.iEy = onClickListener;
        initUI();
    }

    private void initUI() {
        this.mRootView = (RelativeLayout) LayoutInflater.from(this.iED.getPageContext().getPageActivity()).inflate(R.layout.tbtitle_activity, (ViewGroup) null);
        this.iED.setContentView(this.mRootView);
        this.iwP = this.mRootView.findViewById(R.id.top_view);
        if (!j.isNetworkAvailableForImmediately()) {
            this.iwP.getLayoutParams().height = UtilHelper.getLightStatusBarHeight() + l.getDimens(this.iED.getActivity(), R.dimen.ds170);
        } else {
            this.iwP.getLayoutParams().height = UtilHelper.getLightStatusBarHeight() + l.getDimens(this.iED.getActivity(), R.dimen.ds88);
        }
        this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setCenterTextTitle(this.iED.getString(R.string.tbtitle_title));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.showBottomLine();
        this.cEU = (ScrollView) this.mRootView.findViewById(R.id.tbtitle_scroll_view);
        this.iEJ = (LinearLayout) this.mRootView.findViewById(R.id.first_line_layout);
        this.iEI = (TextView) this.mRootView.findViewById(R.id.tbtile_like_btn);
        this.iEE = (LinearLayout) this.mRootView.findViewById(R.id.table_canvas);
        this.iEF = (TextView) this.mRootView.findViewById(R.id.user_level_name);
        this.iEG = (ImageView) this.mRootView.findViewById(R.id.header_level_img);
        this.iEH = (TextView) this.mRootView.findViewById(R.id.tbtitle_tip_detail2);
        this.gjn = (NoNetworkView) this.mRootView.findViewById(R.id.view_no_network);
        cwM();
        cwN();
    }

    private void cwM() {
        String string = getPageContext().getResources().getString(R.string.tbtitle_tip_detail2);
        String string2 = getPageContext().getResources().getString(R.string.tbtitle_tip_tieba_bar);
        int length = string2.length();
        int indexOf = string.indexOf(string2);
        SpannableString spannableString = new SpannableString(string);
        spannableString.setSpan(this.iEM, indexOf, length + indexOf, 33);
        this.iEH.setText(spannableString);
        this.iEH.setMovementMethod(LinkMovementMethod.getInstance());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.forumMember.tbtitle.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes23.dex */
    public class C0721a extends ClickableSpan {
        private View.OnClickListener eUh;

        public C0721a(View.OnClickListener onClickListener) {
            this.eUh = onClickListener;
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            textPaint.setColor(ap.getColor(R.color.cp_link_tip_a));
            textPaint.setUnderlineText(false);
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View view) {
            this.eUh.onClick(view);
        }
    }

    public void da(List<LevelInfo> list) {
        this.iEK = list;
        if (this.iEE != null && this.iEK != null && this.iEK.size() != 0) {
            this.iEE.removeAllViews();
            for (int i = 1; i <= list.size(); i++) {
                LevelInfo levelInfo = list.get(i - 1);
                View inflate = LayoutInflater.from(this.iED.getPageContext().getContext()).inflate(R.layout.tbtitle_table_item, (ViewGroup) null);
                LinearLayout linearLayout = (LinearLayout) inflate.findViewById(R.id.table_item_background);
                TextView textView = (TextView) inflate.findViewById(R.id.table_item_level_name);
                TextView textView2 = (TextView) inflate.findViewById(R.id.table_item_need_experienment);
                View findViewById = inflate.findViewById(R.id.tbtile_item_horizontal_line);
                ImageView imageView = (ImageView) inflate.findViewById(R.id.table_item_level_img);
                if (i % 2 != 0) {
                    ap.setBackgroundResource(linearLayout, R.color.cp_bg_line_e);
                }
                ap.setViewTextColor(textView, R.color.cp_cont_b, 1);
                ap.setViewTextColor(textView2, R.color.cp_cont_b, 1);
                ap.setBackgroundColor(findViewById, R.color.cp_bg_line_c);
                ap.setImageResource(imageView, BitmapHelper.getGradeResourceIdNew(levelInfo.id.intValue()));
                textView.setText(levelInfo.name);
                if (levelInfo.score.intValue() <= 3000000 && levelInfo.score.intValue() > 0) {
                    textView2.setText(levelInfo.score + "");
                } else if (levelInfo.score.intValue() <= 0) {
                    textView2.setText("0");
                } else {
                    textView2.setText("3000000");
                }
                this.iEE.addView(inflate);
            }
        }
    }

    public void a(DataRes dataRes) {
        this.iEL = dataRes;
        if (this.iEL != null) {
            if (this.iEL.is_like.intValue() == 1 && this.iEJ != null) {
                this.iEJ.setVisibility(8);
            }
            if (this.iEF != null) {
                if (StringUtils.isNull(this.iEL.level_name, true)) {
                    this.iEF.setText(this.iEL.level_name);
                } else {
                    this.iEF.setVisibility(8);
                }
            }
            if (this.iEG != null) {
                if (this.iEL.user_level.intValue() <= 0 || this.iEL.user_level.intValue() > 18) {
                    this.iEG.setVisibility(8);
                } else {
                    ap.setImageResource(this.iEG, BitmapHelper.getGradeResourceIdNew(this.iEL.user_level.intValue()));
                }
            }
        }
    }

    private void cwN() {
        this.iEI.setOnClickListener(this.iEy);
        this.iEH.setOnClickListener(this.iEy);
    }

    public void onSkinTypeChanged(int i) {
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(this.iED.getPageContext(), i);
        }
        if (this.gjn != null) {
            this.gjn.onChangeSkinType(this.iED.getPageContext(), i);
        }
        da(this.iEK);
        a(this.iEL);
        this.iED.getLayoutMode().setNightMode(i == 1);
        this.iED.getLayoutMode().onModeChanged(this.mRootView);
    }

    public void Km(String str) {
        this.cEU.setVisibility(8);
        this.iED.showNetRefreshView(this.mRootView, str, true);
        this.iED.setNetRefreshViewTopMargin(400);
    }

    public void cwO() {
        this.cEU.setVisibility(0);
        this.iED.hideNetRefreshView(this.mRootView);
    }

    public void showLoadingView() {
        this.cEU.setVisibility(8);
        this.iED.showLoadingView(this.mRootView, true);
    }

    public void cwP() {
        this.cEU.setVisibility(0);
        this.iED.hideLoadingView(this.mRootView);
    }

    public void g(NoNetworkView.a aVar) {
        if (aVar != null) {
            this.gjn.a(aVar);
        }
    }

    public void pm(boolean z) {
        if (!z) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.iwP.getLayoutParams();
            layoutParams.height = UtilHelper.getLightStatusBarHeight() + l.getDimens(this.iED.getActivity(), R.dimen.ds170);
            this.iwP.setLayoutParams(layoutParams);
            return;
        }
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.iwP.getLayoutParams();
        layoutParams2.height = UtilHelper.getLightStatusBarHeight() + l.getDimens(this.iED.getActivity(), R.dimen.ds88);
        this.iwP.setLayoutParams(layoutParams2);
    }
}
