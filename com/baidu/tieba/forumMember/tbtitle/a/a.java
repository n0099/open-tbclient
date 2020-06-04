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
    private ScrollView bQQ;
    private NoNetworkView fci;
    private View hdc;
    private View.OnClickListener hkO;
    private TbTitleActivity hkT;
    private LinearLayout hkU;
    private TextView hkV;
    private ImageView hkW;
    private TextView hkX;
    private TextView hkY;
    public LinearLayout hkZ;
    private List<LevelInfo> hla;
    private DataRes hlb;
    private C0609a hlc;
    private NavigationBar mNavigationBar;
    private RelativeLayout mRootView;

    public a(TbTitleActivity tbTitleActivity, View.OnClickListener onClickListener) {
        super(tbTitleActivity.getPageContext());
        this.hlc = new C0609a(new View.OnClickListener() { // from class: com.baidu.tieba.forumMember.tbtitle.a.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(a.this.hkT.getPageContext().getContext()).createNormalCfg(a.this.getPageContext().getString(R.string.tieba_text), "from")));
            }
        });
        this.hkT = tbTitleActivity;
        this.hkO = onClickListener;
        initUI();
    }

    private void initUI() {
        this.mRootView = (RelativeLayout) LayoutInflater.from(this.hkT.getPageContext().getPageActivity()).inflate(R.layout.tbtitle_activity, (ViewGroup) null);
        this.hkT.setContentView(this.mRootView);
        this.hdc = this.mRootView.findViewById(R.id.top_view);
        if (!j.isNetworkAvailableForImmediately()) {
            this.hdc.getLayoutParams().height = UtilHelper.getLightStatusBarHeight() + l.getDimens(this.hkT.getActivity(), R.dimen.ds170);
        } else {
            this.hdc.getLayoutParams().height = UtilHelper.getLightStatusBarHeight() + l.getDimens(this.hkT.getActivity(), R.dimen.ds88);
        }
        this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setCenterTextTitle(this.hkT.getString(R.string.tbtitle_title));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.showBottomLine();
        this.bQQ = (ScrollView) this.mRootView.findViewById(R.id.tbtitle_scroll_view);
        this.hkZ = (LinearLayout) this.mRootView.findViewById(R.id.first_line_layout);
        this.hkY = (TextView) this.mRootView.findViewById(R.id.tbtile_like_btn);
        this.hkU = (LinearLayout) this.mRootView.findViewById(R.id.table_canvas);
        this.hkV = (TextView) this.mRootView.findViewById(R.id.user_level_name);
        this.hkW = (ImageView) this.mRootView.findViewById(R.id.header_level_img);
        this.hkX = (TextView) this.mRootView.findViewById(R.id.tbtitle_tip_detail2);
        this.fci = (NoNetworkView) this.mRootView.findViewById(R.id.view_no_network);
        bTG();
        bTH();
    }

    private void bTG() {
        String string = getPageContext().getResources().getString(R.string.tbtitle_tip_detail2);
        String string2 = getPageContext().getResources().getString(R.string.tbtitle_tip_tieba_bar);
        int length = string2.length();
        int indexOf = string.indexOf(string2);
        SpannableString spannableString = new SpannableString(string);
        spannableString.setSpan(this.hlc, indexOf, length + indexOf, 33);
        this.hkX.setText(spannableString);
        this.hkX.setMovementMethod(LinkMovementMethod.getInstance());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.forumMember.tbtitle.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public class C0609a extends ClickableSpan {
        private View.OnClickListener dUl;

        public C0609a(View.OnClickListener onClickListener) {
            this.dUl = onClickListener;
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            textPaint.setColor(am.getColor(R.color.cp_link_tip_a));
            textPaint.setUnderlineText(false);
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View view) {
            this.dUl.onClick(view);
        }
    }

    public void ck(List<LevelInfo> list) {
        this.hla = list;
        if (this.hkU != null && this.hla != null && this.hla.size() != 0) {
            this.hkU.removeAllViews();
            for (int i = 1; i <= list.size(); i++) {
                LevelInfo levelInfo = list.get(i - 1);
                View inflate = LayoutInflater.from(this.hkT.getPageContext().getContext()).inflate(R.layout.tbtitle_table_item, (ViewGroup) null);
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
                this.hkU.addView(inflate);
            }
        }
    }

    public void a(DataRes dataRes) {
        this.hlb = dataRes;
        if (this.hlb != null) {
            if (this.hlb.is_like.intValue() == 1 && this.hkZ != null) {
                this.hkZ.setVisibility(8);
            }
            if (this.hkV != null) {
                if (StringUtils.isNull(this.hlb.level_name, true)) {
                    this.hkV.setText(this.hlb.level_name);
                } else {
                    this.hkV.setVisibility(8);
                }
            }
            if (this.hkW != null) {
                if (this.hlb.user_level.intValue() <= 0 || this.hlb.user_level.intValue() > 18) {
                    this.hkW.setVisibility(8);
                } else {
                    am.setImageResource(this.hkW, BitmapHelper.getGradeResourceIdNew(this.hlb.user_level.intValue()));
                }
            }
        }
    }

    private void bTH() {
        this.hkY.setOnClickListener(this.hkO);
        this.hkX.setOnClickListener(this.hkO);
    }

    public void onSkinTypeChanged(int i) {
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(this.hkT.getPageContext(), i);
        }
        if (this.fci != null) {
            this.fci.onChangeSkinType(this.hkT.getPageContext(), i);
        }
        ck(this.hla);
        a(this.hlb);
        this.hkT.getLayoutMode().setNightMode(i == 1);
        this.hkT.getLayoutMode().onModeChanged(this.mRootView);
    }

    public void Ey(String str) {
        this.bQQ.setVisibility(8);
        this.hkT.showNetRefreshView(this.mRootView, str, true);
        this.hkT.setNetRefreshViewTopMargin(400);
    }

    public void bTI() {
        this.bQQ.setVisibility(0);
        this.hkT.hideNetRefreshView(this.mRootView);
    }

    public void showLoadingView() {
        this.bQQ.setVisibility(8);
        this.hkT.showLoadingView(this.mRootView, true);
    }

    public void bTJ() {
        this.bQQ.setVisibility(0);
        this.hkT.hideLoadingView(this.mRootView);
    }

    public void g(NoNetworkView.a aVar) {
        if (aVar != null) {
            this.fci.a(aVar);
        }
    }

    public void mE(boolean z) {
        if (!z) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.hdc.getLayoutParams();
            layoutParams.height = UtilHelper.getLightStatusBarHeight() + l.getDimens(this.hkT.getActivity(), R.dimen.ds170);
            this.hdc.setLayoutParams(layoutParams);
            return;
        }
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.hdc.getLayoutParams();
        layoutParams2.height = UtilHelper.getLightStatusBarHeight() + l.getDimens(this.hkT.getActivity(), R.dimen.ds88);
        this.hdc.setLayoutParams(layoutParams2);
    }
}
