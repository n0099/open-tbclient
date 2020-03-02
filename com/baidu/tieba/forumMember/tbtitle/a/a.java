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
    private ScrollView bjx;
    private NoNetworkView eli;
    private View gdV;
    private View.OnClickListener glK;
    private TbTitleActivity glP;
    private LinearLayout glQ;
    private TextView glR;
    private ImageView glS;
    private TextView glT;
    private TextView glU;
    public LinearLayout glV;
    private List<LevelInfo> glW;
    private DataRes glX;
    private C0501a glY;
    private NavigationBar mNavigationBar;
    private RelativeLayout mRootView;

    public a(TbTitleActivity tbTitleActivity, View.OnClickListener onClickListener) {
        super(tbTitleActivity.getPageContext());
        this.glY = new C0501a(new View.OnClickListener() { // from class: com.baidu.tieba.forumMember.tbtitle.a.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(a.this.glP.getPageContext().getContext()).createNormalCfg(a.this.getPageContext().getString(R.string.tieba_text), "from")));
            }
        });
        this.glP = tbTitleActivity;
        this.glK = onClickListener;
        initUI();
    }

    private void initUI() {
        this.mRootView = (RelativeLayout) LayoutInflater.from(this.glP.getPageContext().getPageActivity()).inflate(R.layout.tbtitle_activity, (ViewGroup) null);
        this.glP.setContentView(this.mRootView);
        this.gdV = this.mRootView.findViewById(R.id.top_view);
        if (!j.isNetworkAvailableForImmediately()) {
            this.gdV.getLayoutParams().height = UtilHelper.getLightStatusBarHeight() + l.getDimens(this.glP.getActivity(), R.dimen.ds170);
        } else {
            this.gdV.getLayoutParams().height = UtilHelper.getLightStatusBarHeight() + l.getDimens(this.glP.getActivity(), R.dimen.ds88);
        }
        this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setCenterTextTitle(this.glP.getString(R.string.tbtitle_title));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.showBottomLine();
        this.bjx = (ScrollView) this.mRootView.findViewById(R.id.tbtitle_scroll_view);
        this.glV = (LinearLayout) this.mRootView.findViewById(R.id.first_line_layout);
        this.glU = (TextView) this.mRootView.findViewById(R.id.tbtile_like_btn);
        this.glQ = (LinearLayout) this.mRootView.findViewById(R.id.table_canvas);
        this.glR = (TextView) this.mRootView.findViewById(R.id.user_level_name);
        this.glS = (ImageView) this.mRootView.findViewById(R.id.header_level_img);
        this.glT = (TextView) this.mRootView.findViewById(R.id.tbtitle_tip_detail2);
        this.eli = (NoNetworkView) this.mRootView.findViewById(R.id.view_no_network);
        bCD();
        bCE();
    }

    private void bCD() {
        String string = getPageContext().getResources().getString(R.string.tbtitle_tip_detail2);
        String string2 = getPageContext().getResources().getString(R.string.tbtitle_tip_tieba_bar);
        int length = string2.length();
        int indexOf = string.indexOf(string2);
        SpannableString spannableString = new SpannableString(string);
        spannableString.setSpan(this.glY, indexOf, length + indexOf, 33);
        this.glT.setText(spannableString);
        this.glT.setMovementMethod(LinkMovementMethod.getInstance());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.forumMember.tbtitle.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public class C0501a extends ClickableSpan {
        private View.OnClickListener dfY;

        public C0501a(View.OnClickListener onClickListener) {
            this.dfY = onClickListener;
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            textPaint.setColor(am.getColor(R.color.cp_link_tip_a));
            textPaint.setUnderlineText(false);
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View view) {
            this.dfY.onClick(view);
        }
    }

    public void cb(List<LevelInfo> list) {
        this.glW = list;
        if (this.glQ != null && this.glW != null && this.glW.size() != 0) {
            this.glQ.removeAllViews();
            for (int i = 1; i <= list.size(); i++) {
                LevelInfo levelInfo = list.get(i - 1);
                View inflate = LayoutInflater.from(this.glP.getPageContext().getContext()).inflate(R.layout.tbtitle_table_item, (ViewGroup) null);
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
                this.glQ.addView(inflate);
            }
        }
    }

    public void a(DataRes dataRes) {
        this.glX = dataRes;
        if (this.glX != null) {
            if (this.glX.is_like.intValue() == 1 && this.glV != null) {
                this.glV.setVisibility(8);
            }
            if (this.glR != null) {
                if (StringUtils.isNull(this.glX.level_name, true)) {
                    this.glR.setText(this.glX.level_name);
                } else {
                    this.glR.setVisibility(8);
                }
            }
            if (this.glS != null) {
                if (this.glX.user_level.intValue() <= 0 || this.glX.user_level.intValue() > 18) {
                    this.glS.setVisibility(8);
                } else {
                    am.setImageResource(this.glS, BitmapHelper.getGradeResourceIdNew(this.glX.user_level.intValue()));
                }
            }
        }
    }

    private void bCE() {
        this.glU.setOnClickListener(this.glK);
        this.glT.setOnClickListener(this.glK);
    }

    public void onSkinTypeChanged(int i) {
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(this.glP.getPageContext(), i);
        }
        if (this.eli != null) {
            this.eli.onChangeSkinType(this.glP.getPageContext(), i);
        }
        cb(this.glW);
        a(this.glX);
        this.glP.getLayoutMode().setNightMode(i == 1);
        this.glP.getLayoutMode().onModeChanged(this.mRootView);
    }

    public void AZ(String str) {
        this.bjx.setVisibility(8);
        this.glP.showNetRefreshView(this.mRootView, str, true);
        this.glP.setNetRefreshViewTopMargin(400);
    }

    public void bCF() {
        this.bjx.setVisibility(0);
        this.glP.hideNetRefreshView(this.mRootView);
    }

    public void showLoadingView() {
        this.bjx.setVisibility(8);
        this.glP.showLoadingView(this.mRootView, true);
    }

    public void bCG() {
        this.bjx.setVisibility(0);
        this.glP.hideLoadingView(this.mRootView);
    }

    public void g(NoNetworkView.a aVar) {
        if (aVar != null) {
            this.eli.a(aVar);
        }
    }

    public void kZ(boolean z) {
        if (!z) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.gdV.getLayoutParams();
            layoutParams.height = UtilHelper.getLightStatusBarHeight() + l.getDimens(this.glP.getActivity(), R.dimen.ds170);
            this.gdV.setLayoutParams(layoutParams);
            return;
        }
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.gdV.getLayoutParams();
        layoutParams2.height = UtilHelper.getLightStatusBarHeight() + l.getDimens(this.glP.getActivity(), R.dimen.ds88);
        this.gdV.setLayoutParams(layoutParams2);
    }
}
