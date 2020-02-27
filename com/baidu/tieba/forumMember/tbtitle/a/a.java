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
    private ScrollView bjw;
    private NoNetworkView elh;
    private View gdT;
    private View.OnClickListener glI;
    private TbTitleActivity glN;
    private LinearLayout glO;
    private TextView glP;
    private ImageView glQ;
    private TextView glR;
    private TextView glS;
    public LinearLayout glT;
    private List<LevelInfo> glU;
    private DataRes glV;
    private C0501a glW;
    private NavigationBar mNavigationBar;
    private RelativeLayout mRootView;

    public a(TbTitleActivity tbTitleActivity, View.OnClickListener onClickListener) {
        super(tbTitleActivity.getPageContext());
        this.glW = new C0501a(new View.OnClickListener() { // from class: com.baidu.tieba.forumMember.tbtitle.a.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(a.this.glN.getPageContext().getContext()).createNormalCfg(a.this.getPageContext().getString(R.string.tieba_text), "from")));
            }
        });
        this.glN = tbTitleActivity;
        this.glI = onClickListener;
        initUI();
    }

    private void initUI() {
        this.mRootView = (RelativeLayout) LayoutInflater.from(this.glN.getPageContext().getPageActivity()).inflate(R.layout.tbtitle_activity, (ViewGroup) null);
        this.glN.setContentView(this.mRootView);
        this.gdT = this.mRootView.findViewById(R.id.top_view);
        if (!j.isNetworkAvailableForImmediately()) {
            this.gdT.getLayoutParams().height = UtilHelper.getLightStatusBarHeight() + l.getDimens(this.glN.getActivity(), R.dimen.ds170);
        } else {
            this.gdT.getLayoutParams().height = UtilHelper.getLightStatusBarHeight() + l.getDimens(this.glN.getActivity(), R.dimen.ds88);
        }
        this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setCenterTextTitle(this.glN.getString(R.string.tbtitle_title));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.showBottomLine();
        this.bjw = (ScrollView) this.mRootView.findViewById(R.id.tbtitle_scroll_view);
        this.glT = (LinearLayout) this.mRootView.findViewById(R.id.first_line_layout);
        this.glS = (TextView) this.mRootView.findViewById(R.id.tbtile_like_btn);
        this.glO = (LinearLayout) this.mRootView.findViewById(R.id.table_canvas);
        this.glP = (TextView) this.mRootView.findViewById(R.id.user_level_name);
        this.glQ = (ImageView) this.mRootView.findViewById(R.id.header_level_img);
        this.glR = (TextView) this.mRootView.findViewById(R.id.tbtitle_tip_detail2);
        this.elh = (NoNetworkView) this.mRootView.findViewById(R.id.view_no_network);
        bCB();
        bCC();
    }

    private void bCB() {
        String string = getPageContext().getResources().getString(R.string.tbtitle_tip_detail2);
        String string2 = getPageContext().getResources().getString(R.string.tbtitle_tip_tieba_bar);
        int length = string2.length();
        int indexOf = string.indexOf(string2);
        SpannableString spannableString = new SpannableString(string);
        spannableString.setSpan(this.glW, indexOf, length + indexOf, 33);
        this.glR.setText(spannableString);
        this.glR.setMovementMethod(LinkMovementMethod.getInstance());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.forumMember.tbtitle.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public class C0501a extends ClickableSpan {
        private View.OnClickListener dfX;

        public C0501a(View.OnClickListener onClickListener) {
            this.dfX = onClickListener;
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            textPaint.setColor(am.getColor(R.color.cp_link_tip_a));
            textPaint.setUnderlineText(false);
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View view) {
            this.dfX.onClick(view);
        }
    }

    public void cb(List<LevelInfo> list) {
        this.glU = list;
        if (this.glO != null && this.glU != null && this.glU.size() != 0) {
            this.glO.removeAllViews();
            for (int i = 1; i <= list.size(); i++) {
                LevelInfo levelInfo = list.get(i - 1);
                View inflate = LayoutInflater.from(this.glN.getPageContext().getContext()).inflate(R.layout.tbtitle_table_item, (ViewGroup) null);
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
                this.glO.addView(inflate);
            }
        }
    }

    public void a(DataRes dataRes) {
        this.glV = dataRes;
        if (this.glV != null) {
            if (this.glV.is_like.intValue() == 1 && this.glT != null) {
                this.glT.setVisibility(8);
            }
            if (this.glP != null) {
                if (StringUtils.isNull(this.glV.level_name, true)) {
                    this.glP.setText(this.glV.level_name);
                } else {
                    this.glP.setVisibility(8);
                }
            }
            if (this.glQ != null) {
                if (this.glV.user_level.intValue() <= 0 || this.glV.user_level.intValue() > 18) {
                    this.glQ.setVisibility(8);
                } else {
                    am.setImageResource(this.glQ, BitmapHelper.getGradeResourceIdNew(this.glV.user_level.intValue()));
                }
            }
        }
    }

    private void bCC() {
        this.glS.setOnClickListener(this.glI);
        this.glR.setOnClickListener(this.glI);
    }

    public void onSkinTypeChanged(int i) {
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(this.glN.getPageContext(), i);
        }
        if (this.elh != null) {
            this.elh.onChangeSkinType(this.glN.getPageContext(), i);
        }
        cb(this.glU);
        a(this.glV);
        this.glN.getLayoutMode().setNightMode(i == 1);
        this.glN.getLayoutMode().onModeChanged(this.mRootView);
    }

    public void AZ(String str) {
        this.bjw.setVisibility(8);
        this.glN.showNetRefreshView(this.mRootView, str, true);
        this.glN.setNetRefreshViewTopMargin(400);
    }

    public void bCD() {
        this.bjw.setVisibility(0);
        this.glN.hideNetRefreshView(this.mRootView);
    }

    public void showLoadingView() {
        this.bjw.setVisibility(8);
        this.glN.showLoadingView(this.mRootView, true);
    }

    public void bCE() {
        this.bjw.setVisibility(0);
        this.glN.hideLoadingView(this.mRootView);
    }

    public void g(NoNetworkView.a aVar) {
        if (aVar != null) {
            this.elh.a(aVar);
        }
    }

    public void kZ(boolean z) {
        if (!z) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.gdT.getLayoutParams();
            layoutParams.height = UtilHelper.getLightStatusBarHeight() + l.getDimens(this.glN.getActivity(), R.dimen.ds170);
            this.gdT.setLayoutParams(layoutParams);
            return;
        }
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.gdT.getLayoutParams();
        layoutParams2.height = UtilHelper.getLightStatusBarHeight() + l.getDimens(this.glN.getActivity(), R.dimen.ds88);
        this.gdT.setLayoutParams(layoutParams2);
    }
}
