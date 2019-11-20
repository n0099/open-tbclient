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
    private ScrollView buM;
    private NoNetworkView dvR;
    private View fkk;
    private View.OnClickListener fsb;
    private TbTitleActivity fsg;
    private LinearLayout fsh;
    private TextView fsi;
    private ImageView fsj;
    private TextView fsk;
    private TextView fsl;
    public LinearLayout fsm;
    private List<LevelInfo> fsn;
    private DataRes fso;
    private C0407a fsp;
    private NavigationBar mNavigationBar;
    private RelativeLayout mRootView;

    public a(TbTitleActivity tbTitleActivity, View.OnClickListener onClickListener) {
        super(tbTitleActivity.getPageContext());
        this.fsp = new C0407a(new View.OnClickListener() { // from class: com.baidu.tieba.forumMember.tbtitle.a.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(a.this.fsg.getPageContext().getContext()).createNormalCfg(a.this.getPageContext().getString(R.string.tieba_text), "from")));
            }
        });
        this.fsg = tbTitleActivity;
        this.fsb = onClickListener;
        initUI();
    }

    private void initUI() {
        this.mRootView = (RelativeLayout) LayoutInflater.from(this.fsg.getPageContext().getPageActivity()).inflate(R.layout.tbtitle_activity, (ViewGroup) null);
        this.fsg.setContentView(this.mRootView);
        this.fkk = this.mRootView.findViewById(R.id.top_view);
        if (!j.isNetworkAvailableForImmediately()) {
            this.fkk.getLayoutParams().height = UtilHelper.getLightStatusBarHeight() + l.getDimens(this.fsg.getActivity(), R.dimen.ds170);
        } else {
            this.fkk.getLayoutParams().height = UtilHelper.getLightStatusBarHeight() + l.getDimens(this.fsg.getActivity(), R.dimen.ds88);
        }
        this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setCenterTextTitle(this.fsg.getString(R.string.tbtitle_title));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.showBottomLine();
        this.buM = (ScrollView) this.mRootView.findViewById(R.id.tbtitle_scroll_view);
        this.fsm = (LinearLayout) this.mRootView.findViewById(R.id.first_line_layout);
        this.fsl = (TextView) this.mRootView.findViewById(R.id.tbtile_like_btn);
        this.fsh = (LinearLayout) this.mRootView.findViewById(R.id.table_canvas);
        this.fsi = (TextView) this.mRootView.findViewById(R.id.user_level_name);
        this.fsj = (ImageView) this.mRootView.findViewById(R.id.header_level_img);
        this.fsk = (TextView) this.mRootView.findViewById(R.id.tbtitle_tip_detail2);
        this.dvR = (NoNetworkView) this.mRootView.findViewById(R.id.view_no_network);
        biC();
        biD();
    }

    private void biC() {
        String string = getPageContext().getResources().getString(R.string.tbtitle_tip_detail2);
        String string2 = getPageContext().getResources().getString(R.string.tbtitle_tip_tieba_bar);
        int length = string2.length();
        int indexOf = string.indexOf(string2);
        SpannableString spannableString = new SpannableString(string);
        spannableString.setSpan(this.fsp, indexOf, length + indexOf, 33);
        this.fsk.setText(spannableString);
        this.fsk.setMovementMethod(LinkMovementMethod.getInstance());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.forumMember.tbtitle.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class C0407a extends ClickableSpan {
        private View.OnClickListener cot;

        public C0407a(View.OnClickListener onClickListener) {
            this.cot = onClickListener;
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            textPaint.setColor(am.getColor(R.color.cp_link_tip_a));
            textPaint.setUnderlineText(false);
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View view) {
            this.cot.onClick(view);
        }
    }

    public void cj(List<LevelInfo> list) {
        this.fsn = list;
        if (this.fsh != null && this.fsn != null && this.fsn.size() != 0) {
            this.fsh.removeAllViews();
            for (int i = 1; i <= list.size(); i++) {
                LevelInfo levelInfo = list.get(i - 1);
                View inflate = LayoutInflater.from(this.fsg.getPageContext().getContext()).inflate(R.layout.tbtitle_table_item, (ViewGroup) null);
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
                this.fsh.addView(inflate);
            }
        }
    }

    public void a(DataRes dataRes) {
        this.fso = dataRes;
        if (this.fso != null) {
            if (this.fso.is_like.intValue() == 1 && this.fsm != null) {
                this.fsm.setVisibility(8);
            }
            if (this.fsi != null) {
                if (StringUtils.isNull(this.fso.level_name, true)) {
                    this.fsi.setText(this.fso.level_name);
                } else {
                    this.fsi.setVisibility(8);
                }
            }
            if (this.fsj != null) {
                if (this.fso.user_level.intValue() <= 0 || this.fso.user_level.intValue() > 18) {
                    this.fsj.setVisibility(8);
                } else {
                    am.setImageResource(this.fsj, BitmapHelper.getGradeResourceIdNew(this.fso.user_level.intValue()));
                }
            }
        }
    }

    private void biD() {
        this.fsl.setOnClickListener(this.fsb);
        this.fsk.setOnClickListener(this.fsb);
    }

    public void onSkinTypeChanged(int i) {
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(this.fsg.getPageContext(), i);
        }
        if (this.dvR != null) {
            this.dvR.onChangeSkinType(this.fsg.getPageContext(), i);
        }
        cj(this.fsn);
        a(this.fso);
        this.fsg.getLayoutMode().setNightMode(i == 1);
        this.fsg.getLayoutMode().onModeChanged(this.mRootView);
    }

    public void vH(String str) {
        this.buM.setVisibility(8);
        this.fsg.showNetRefreshView(this.mRootView, str, true);
        this.fsg.setNetRefreshViewTopMargin(400);
    }

    public void biE() {
        this.buM.setVisibility(0);
        this.fsg.hideNetRefreshView(this.mRootView);
    }

    public void showLoadingView() {
        this.buM.setVisibility(8);
        this.fsg.showLoadingView(this.mRootView, true);
    }

    public void biF() {
        this.buM.setVisibility(0);
        this.fsg.hideLoadingView(this.mRootView);
    }

    public void h(NoNetworkView.a aVar) {
        if (aVar != null) {
            this.dvR.a(aVar);
        }
    }

    public void jy(boolean z) {
        if (!z) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.fkk.getLayoutParams();
            layoutParams.height = UtilHelper.getLightStatusBarHeight() + l.getDimens(this.fsg.getActivity(), R.dimen.ds170);
            this.fkk.setLayoutParams(layoutParams);
            return;
        }
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.fkk.getLayoutParams();
        layoutParams2.height = UtilHelper.getLightStatusBarHeight() + l.getDimens(this.fsg.getActivity(), R.dimen.ds88);
        this.fkk.setLayoutParams(layoutParams2);
    }
}
