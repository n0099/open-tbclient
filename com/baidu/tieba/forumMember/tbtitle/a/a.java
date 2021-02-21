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
import com.baidu.adp.base.d;
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
/* loaded from: classes8.dex */
public class a extends d<TbTitleActivity> {
    private ScrollView cMC;
    private NoNetworkView gAv;
    private View iVX;
    private View.OnClickListener jdG;
    private TbTitleActivity jdL;
    private LinearLayout jdM;
    private TextView jdN;
    private ImageView jdO;
    private TextView jdP;
    private TextView jdQ;
    public LinearLayout jdR;
    private List<LevelInfo> jdS;
    private DataRes jdT;
    private C0720a jdU;
    private NavigationBar mNavigationBar;
    private RelativeLayout mRootView;

    public a(TbTitleActivity tbTitleActivity, View.OnClickListener onClickListener) {
        super(tbTitleActivity.getPageContext());
        this.jdU = new C0720a(new View.OnClickListener() { // from class: com.baidu.tieba.forumMember.tbtitle.a.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(a.this.jdL.getPageContext().getContext()).createNormalCfg(a.this.getPageContext().getString(R.string.tieba_text), "from")));
            }
        });
        this.jdL = tbTitleActivity;
        this.jdG = onClickListener;
        initUI();
    }

    private void initUI() {
        this.mRootView = (RelativeLayout) LayoutInflater.from(this.jdL.getPageContext().getPageActivity()).inflate(R.layout.tbtitle_activity, (ViewGroup) null);
        this.jdL.setContentView(this.mRootView);
        this.iVX = this.mRootView.findViewById(R.id.top_view);
        if (!j.isNetworkAvailableForImmediately()) {
            this.iVX.getLayoutParams().height = UtilHelper.getLightStatusBarHeight() + l.getDimens(this.jdL.getActivity(), R.dimen.ds170);
        } else {
            this.iVX.getLayoutParams().height = UtilHelper.getLightStatusBarHeight() + l.getDimens(this.jdL.getActivity(), R.dimen.ds88);
        }
        this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setCenterTextTitle(this.jdL.getString(R.string.tbtitle_title));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.showBottomLine();
        this.cMC = (ScrollView) this.mRootView.findViewById(R.id.tbtitle_scroll_view);
        this.jdR = (LinearLayout) this.mRootView.findViewById(R.id.first_line_layout);
        this.jdQ = (TextView) this.mRootView.findViewById(R.id.tbtile_like_btn);
        this.jdM = (LinearLayout) this.mRootView.findViewById(R.id.table_canvas);
        this.jdN = (TextView) this.mRootView.findViewById(R.id.user_level_name);
        this.jdO = (ImageView) this.mRootView.findViewById(R.id.header_level_img);
        this.jdP = (TextView) this.mRootView.findViewById(R.id.tbtitle_tip_detail2);
        this.gAv = (NoNetworkView) this.mRootView.findViewById(R.id.view_no_network);
        cAZ();
        cBa();
    }

    private void cAZ() {
        String string = getPageContext().getResources().getString(R.string.tbtitle_tip_detail2);
        String string2 = getPageContext().getResources().getString(R.string.tbtitle_tip_tieba_bar);
        int length = string2.length();
        int indexOf = string.indexOf(string2);
        SpannableString spannableString = new SpannableString(string);
        spannableString.setSpan(this.jdU, indexOf, length + indexOf, 33);
        this.jdP.setText(spannableString);
        this.jdP.setMovementMethod(LinkMovementMethod.getInstance());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.forumMember.tbtitle.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C0720a extends ClickableSpan {
        private View.OnClickListener fhT;

        public C0720a(View.OnClickListener onClickListener) {
            this.fhT = onClickListener;
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            textPaint.setColor(ap.getColor(R.color.CAM_X0302));
            textPaint.setUnderlineText(false);
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View view) {
            this.fhT.onClick(view);
        }
    }

    public void dg(List<LevelInfo> list) {
        this.jdS = list;
        if (this.jdM != null && this.jdS != null && this.jdS.size() != 0) {
            this.jdM.removeAllViews();
            for (int i = 1; i <= list.size(); i++) {
                LevelInfo levelInfo = list.get(i - 1);
                View inflate = LayoutInflater.from(this.jdL.getPageContext().getContext()).inflate(R.layout.tbtitle_table_item, (ViewGroup) null);
                LinearLayout linearLayout = (LinearLayout) inflate.findViewById(R.id.table_item_background);
                TextView textView = (TextView) inflate.findViewById(R.id.table_item_level_name);
                TextView textView2 = (TextView) inflate.findViewById(R.id.table_item_need_experienment);
                View findViewById = inflate.findViewById(R.id.tbtile_item_horizontal_line);
                ImageView imageView = (ImageView) inflate.findViewById(R.id.table_item_level_img);
                if (i % 2 != 0) {
                    ap.setBackgroundResource(linearLayout, R.color.CAM_X0205);
                }
                ap.setViewTextColor(textView, R.color.CAM_X0105, 1);
                ap.setViewTextColor(textView2, R.color.CAM_X0105, 1);
                ap.setBackgroundColor(findViewById, R.color.CAM_X0204);
                ap.setImageResource(imageView, BitmapHelper.getGradeResourceIdNew(levelInfo.id.intValue()));
                textView.setText(levelInfo.name);
                if (levelInfo.score.intValue() <= 3000000 && levelInfo.score.intValue() > 0) {
                    textView2.setText(levelInfo.score + "");
                } else if (levelInfo.score.intValue() <= 0) {
                    textView2.setText("0");
                } else {
                    textView2.setText("3000000");
                }
                this.jdM.addView(inflate);
            }
        }
    }

    public void a(DataRes dataRes) {
        this.jdT = dataRes;
        if (this.jdT != null) {
            if (this.jdT.is_like.intValue() == 1 && this.jdR != null) {
                this.jdR.setVisibility(8);
            }
            if (this.jdN != null) {
                if (StringUtils.isNull(this.jdT.level_name, true)) {
                    this.jdN.setText(this.jdT.level_name);
                } else {
                    this.jdN.setVisibility(8);
                }
            }
            if (this.jdO != null) {
                if (this.jdT.user_level.intValue() <= 0 || this.jdT.user_level.intValue() > 18) {
                    this.jdO.setVisibility(8);
                } else {
                    ap.setImageResource(this.jdO, BitmapHelper.getGradeResourceIdNew(this.jdT.user_level.intValue()));
                }
            }
        }
    }

    private void cBa() {
        this.jdQ.setOnClickListener(this.jdG);
        this.jdP.setOnClickListener(this.jdG);
    }

    public void onSkinTypeChanged(int i) {
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(this.jdL.getPageContext(), i);
        }
        if (this.gAv != null) {
            this.gAv.onChangeSkinType(this.jdL.getPageContext(), i);
        }
        dg(this.jdS);
        a(this.jdT);
        this.jdL.getLayoutMode().setNightMode(i == 1);
        this.jdL.getLayoutMode().onModeChanged(this.mRootView);
    }

    public void Kb(String str) {
        this.cMC.setVisibility(8);
        this.jdL.showNetRefreshView(this.mRootView, str, true);
        this.jdL.setNetRefreshViewTopMargin(400);
    }

    public void cBb() {
        this.cMC.setVisibility(0);
        this.jdL.hideNetRefreshView(this.mRootView);
    }

    public void showLoadingView() {
        this.cMC.setVisibility(8);
        this.jdL.showLoadingView(this.mRootView, true);
    }

    public void cBc() {
        this.cMC.setVisibility(0);
        this.jdL.hideLoadingView(this.mRootView);
    }

    public void g(NoNetworkView.a aVar) {
        if (aVar != null) {
            this.gAv.a(aVar);
        }
    }

    public void qp(boolean z) {
        if (!z) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.iVX.getLayoutParams();
            layoutParams.height = UtilHelper.getLightStatusBarHeight() + l.getDimens(this.jdL.getActivity(), R.dimen.ds170);
            this.iVX.setLayoutParams(layoutParams);
            return;
        }
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.iVX.getLayoutParams();
        layoutParams2.height = UtilHelper.getLightStatusBarHeight() + l.getDimens(this.jdL.getActivity(), R.dimen.ds88);
        this.iVX.setLayoutParams(layoutParams2);
    }
}
