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
    private ScrollView bjy;
    private NoNetworkView elv;
    private View gei;
    private View.OnClickListener glX;
    private TbTitleActivity gmc;
    private LinearLayout gmd;
    private TextView gme;
    private ImageView gmf;
    private TextView gmg;
    private TextView gmh;
    public LinearLayout gmi;
    private List<LevelInfo> gmj;
    private DataRes gmk;
    private C0501a gml;
    private NavigationBar mNavigationBar;
    private RelativeLayout mRootView;

    public a(TbTitleActivity tbTitleActivity, View.OnClickListener onClickListener) {
        super(tbTitleActivity.getPageContext());
        this.gml = new C0501a(new View.OnClickListener() { // from class: com.baidu.tieba.forumMember.tbtitle.a.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(a.this.gmc.getPageContext().getContext()).createNormalCfg(a.this.getPageContext().getString(R.string.tieba_text), "from")));
            }
        });
        this.gmc = tbTitleActivity;
        this.glX = onClickListener;
        initUI();
    }

    private void initUI() {
        this.mRootView = (RelativeLayout) LayoutInflater.from(this.gmc.getPageContext().getPageActivity()).inflate(R.layout.tbtitle_activity, (ViewGroup) null);
        this.gmc.setContentView(this.mRootView);
        this.gei = this.mRootView.findViewById(R.id.top_view);
        if (!j.isNetworkAvailableForImmediately()) {
            this.gei.getLayoutParams().height = UtilHelper.getLightStatusBarHeight() + l.getDimens(this.gmc.getActivity(), R.dimen.ds170);
        } else {
            this.gei.getLayoutParams().height = UtilHelper.getLightStatusBarHeight() + l.getDimens(this.gmc.getActivity(), R.dimen.ds88);
        }
        this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setCenterTextTitle(this.gmc.getString(R.string.tbtitle_title));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.showBottomLine();
        this.bjy = (ScrollView) this.mRootView.findViewById(R.id.tbtitle_scroll_view);
        this.gmi = (LinearLayout) this.mRootView.findViewById(R.id.first_line_layout);
        this.gmh = (TextView) this.mRootView.findViewById(R.id.tbtile_like_btn);
        this.gmd = (LinearLayout) this.mRootView.findViewById(R.id.table_canvas);
        this.gme = (TextView) this.mRootView.findViewById(R.id.user_level_name);
        this.gmf = (ImageView) this.mRootView.findViewById(R.id.header_level_img);
        this.gmg = (TextView) this.mRootView.findViewById(R.id.tbtitle_tip_detail2);
        this.elv = (NoNetworkView) this.mRootView.findViewById(R.id.view_no_network);
        bCE();
        bCF();
    }

    private void bCE() {
        String string = getPageContext().getResources().getString(R.string.tbtitle_tip_detail2);
        String string2 = getPageContext().getResources().getString(R.string.tbtitle_tip_tieba_bar);
        int length = string2.length();
        int indexOf = string.indexOf(string2);
        SpannableString spannableString = new SpannableString(string);
        spannableString.setSpan(this.gml, indexOf, length + indexOf, 33);
        this.gmg.setText(spannableString);
        this.gmg.setMovementMethod(LinkMovementMethod.getInstance());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.forumMember.tbtitle.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public class C0501a extends ClickableSpan {
        private View.OnClickListener dgl;

        public C0501a(View.OnClickListener onClickListener) {
            this.dgl = onClickListener;
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            textPaint.setColor(am.getColor(R.color.cp_link_tip_a));
            textPaint.setUnderlineText(false);
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View view) {
            this.dgl.onClick(view);
        }
    }

    public void cb(List<LevelInfo> list) {
        this.gmj = list;
        if (this.gmd != null && this.gmj != null && this.gmj.size() != 0) {
            this.gmd.removeAllViews();
            for (int i = 1; i <= list.size(); i++) {
                LevelInfo levelInfo = list.get(i - 1);
                View inflate = LayoutInflater.from(this.gmc.getPageContext().getContext()).inflate(R.layout.tbtitle_table_item, (ViewGroup) null);
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
                this.gmd.addView(inflate);
            }
        }
    }

    public void a(DataRes dataRes) {
        this.gmk = dataRes;
        if (this.gmk != null) {
            if (this.gmk.is_like.intValue() == 1 && this.gmi != null) {
                this.gmi.setVisibility(8);
            }
            if (this.gme != null) {
                if (StringUtils.isNull(this.gmk.level_name, true)) {
                    this.gme.setText(this.gmk.level_name);
                } else {
                    this.gme.setVisibility(8);
                }
            }
            if (this.gmf != null) {
                if (this.gmk.user_level.intValue() <= 0 || this.gmk.user_level.intValue() > 18) {
                    this.gmf.setVisibility(8);
                } else {
                    am.setImageResource(this.gmf, BitmapHelper.getGradeResourceIdNew(this.gmk.user_level.intValue()));
                }
            }
        }
    }

    private void bCF() {
        this.gmh.setOnClickListener(this.glX);
        this.gmg.setOnClickListener(this.glX);
    }

    public void onSkinTypeChanged(int i) {
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(this.gmc.getPageContext(), i);
        }
        if (this.elv != null) {
            this.elv.onChangeSkinType(this.gmc.getPageContext(), i);
        }
        cb(this.gmj);
        a(this.gmk);
        this.gmc.getLayoutMode().setNightMode(i == 1);
        this.gmc.getLayoutMode().onModeChanged(this.mRootView);
    }

    public void Ba(String str) {
        this.bjy.setVisibility(8);
        this.gmc.showNetRefreshView(this.mRootView, str, true);
        this.gmc.setNetRefreshViewTopMargin(400);
    }

    public void bCG() {
        this.bjy.setVisibility(0);
        this.gmc.hideNetRefreshView(this.mRootView);
    }

    public void showLoadingView() {
        this.bjy.setVisibility(8);
        this.gmc.showLoadingView(this.mRootView, true);
    }

    public void bCH() {
        this.bjy.setVisibility(0);
        this.gmc.hideLoadingView(this.mRootView);
    }

    public void g(NoNetworkView.a aVar) {
        if (aVar != null) {
            this.elv.a(aVar);
        }
    }

    public void kZ(boolean z) {
        if (!z) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.gei.getLayoutParams();
            layoutParams.height = UtilHelper.getLightStatusBarHeight() + l.getDimens(this.gmc.getActivity(), R.dimen.ds170);
            this.gei.setLayoutParams(layoutParams);
            return;
        }
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.gei.getLayoutParams();
        layoutParams2.height = UtilHelper.getLightStatusBarHeight() + l.getDimens(this.gmc.getActivity(), R.dimen.ds88);
        this.gei.setLayoutParams(layoutParams2);
    }
}
