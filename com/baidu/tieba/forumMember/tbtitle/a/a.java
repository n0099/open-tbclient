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
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tieba.R;
import com.baidu.tieba.forumMember.tbtitle.TbTitleActivity;
import java.util.List;
import tbclient.GetLevelInfo.DataRes;
import tbclient.LevelInfo;
/* loaded from: classes10.dex */
public class a extends c<TbTitleActivity> {
    private ScrollView bVE;
    private NoNetworkView fns;
    private View hpn;
    private View.OnClickListener hwV;
    private TbTitleActivity hxa;
    private LinearLayout hxb;
    private TextView hxc;
    private ImageView hxd;
    private TextView hxe;
    private TextView hxf;
    public LinearLayout hxg;
    private List<LevelInfo> hxh;
    private DataRes hxi;
    private C0616a hxj;
    private NavigationBar mNavigationBar;
    private RelativeLayout mRootView;

    public a(TbTitleActivity tbTitleActivity, View.OnClickListener onClickListener) {
        super(tbTitleActivity.getPageContext());
        this.hxj = new C0616a(new View.OnClickListener() { // from class: com.baidu.tieba.forumMember.tbtitle.a.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(a.this.hxa.getPageContext().getContext()).createNormalCfg(a.this.getPageContext().getString(R.string.tieba_text), "from")));
            }
        });
        this.hxa = tbTitleActivity;
        this.hwV = onClickListener;
        initUI();
    }

    private void initUI() {
        this.mRootView = (RelativeLayout) LayoutInflater.from(this.hxa.getPageContext().getPageActivity()).inflate(R.layout.tbtitle_activity, (ViewGroup) null);
        this.hxa.setContentView(this.mRootView);
        this.hpn = this.mRootView.findViewById(R.id.top_view);
        if (!j.isNetworkAvailableForImmediately()) {
            this.hpn.getLayoutParams().height = UtilHelper.getLightStatusBarHeight() + l.getDimens(this.hxa.getActivity(), R.dimen.ds170);
        } else {
            this.hpn.getLayoutParams().height = UtilHelper.getLightStatusBarHeight() + l.getDimens(this.hxa.getActivity(), R.dimen.ds88);
        }
        this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setCenterTextTitle(this.hxa.getString(R.string.tbtitle_title));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.showBottomLine();
        this.bVE = (ScrollView) this.mRootView.findViewById(R.id.tbtitle_scroll_view);
        this.hxg = (LinearLayout) this.mRootView.findViewById(R.id.first_line_layout);
        this.hxf = (TextView) this.mRootView.findViewById(R.id.tbtile_like_btn);
        this.hxb = (LinearLayout) this.mRootView.findViewById(R.id.table_canvas);
        this.hxc = (TextView) this.mRootView.findViewById(R.id.user_level_name);
        this.hxd = (ImageView) this.mRootView.findViewById(R.id.header_level_img);
        this.hxe = (TextView) this.mRootView.findViewById(R.id.tbtitle_tip_detail2);
        this.fns = (NoNetworkView) this.mRootView.findViewById(R.id.view_no_network);
        bWC();
        bWD();
    }

    private void bWC() {
        String string = getPageContext().getResources().getString(R.string.tbtitle_tip_detail2);
        String string2 = getPageContext().getResources().getString(R.string.tbtitle_tip_tieba_bar);
        int length = string2.length();
        int indexOf = string.indexOf(string2);
        SpannableString spannableString = new SpannableString(string);
        spannableString.setSpan(this.hxj, indexOf, length + indexOf, 33);
        this.hxe.setText(spannableString);
        this.hxe.setMovementMethod(LinkMovementMethod.getInstance());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.forumMember.tbtitle.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public class C0616a extends ClickableSpan {
        private View.OnClickListener ebA;

        public C0616a(View.OnClickListener onClickListener) {
            this.ebA = onClickListener;
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            textPaint.setColor(an.getColor(R.color.cp_link_tip_a));
            textPaint.setUnderlineText(false);
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View view) {
            this.ebA.onClick(view);
        }
    }

    public void ct(List<LevelInfo> list) {
        this.hxh = list;
        if (this.hxb != null && this.hxh != null && this.hxh.size() != 0) {
            this.hxb.removeAllViews();
            for (int i = 1; i <= list.size(); i++) {
                LevelInfo levelInfo = list.get(i - 1);
                View inflate = LayoutInflater.from(this.hxa.getPageContext().getContext()).inflate(R.layout.tbtitle_table_item, (ViewGroup) null);
                LinearLayout linearLayout = (LinearLayout) inflate.findViewById(R.id.table_item_background);
                TextView textView = (TextView) inflate.findViewById(R.id.table_item_level_name);
                TextView textView2 = (TextView) inflate.findViewById(R.id.table_item_need_experienment);
                View findViewById = inflate.findViewById(R.id.tbtile_item_horizontal_line);
                ImageView imageView = (ImageView) inflate.findViewById(R.id.table_item_level_img);
                if (i % 2 != 0) {
                    an.setBackgroundResource(linearLayout, R.color.cp_bg_line_e);
                }
                an.setViewTextColor(textView, R.color.cp_cont_b, 1);
                an.setViewTextColor(textView2, R.color.cp_cont_b, 1);
                an.setBackgroundColor(findViewById, R.color.cp_bg_line_c);
                an.setImageResource(imageView, BitmapHelper.getGradeResourceIdNew(levelInfo.id.intValue()));
                textView.setText(levelInfo.name);
                if (levelInfo.score.intValue() <= 3000000 && levelInfo.score.intValue() > 0) {
                    textView2.setText(levelInfo.score + "");
                } else if (levelInfo.score.intValue() <= 0) {
                    textView2.setText("0");
                } else {
                    textView2.setText("3000000");
                }
                this.hxb.addView(inflate);
            }
        }
    }

    public void a(DataRes dataRes) {
        this.hxi = dataRes;
        if (this.hxi != null) {
            if (this.hxi.is_like.intValue() == 1 && this.hxg != null) {
                this.hxg.setVisibility(8);
            }
            if (this.hxc != null) {
                if (StringUtils.isNull(this.hxi.level_name, true)) {
                    this.hxc.setText(this.hxi.level_name);
                } else {
                    this.hxc.setVisibility(8);
                }
            }
            if (this.hxd != null) {
                if (this.hxi.user_level.intValue() <= 0 || this.hxi.user_level.intValue() > 18) {
                    this.hxd.setVisibility(8);
                } else {
                    an.setImageResource(this.hxd, BitmapHelper.getGradeResourceIdNew(this.hxi.user_level.intValue()));
                }
            }
        }
    }

    private void bWD() {
        this.hxf.setOnClickListener(this.hwV);
        this.hxe.setOnClickListener(this.hwV);
    }

    public void onSkinTypeChanged(int i) {
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(this.hxa.getPageContext(), i);
        }
        if (this.fns != null) {
            this.fns.onChangeSkinType(this.hxa.getPageContext(), i);
        }
        ct(this.hxh);
        a(this.hxi);
        this.hxa.getLayoutMode().setNightMode(i == 1);
        this.hxa.getLayoutMode().onModeChanged(this.mRootView);
    }

    public void EZ(String str) {
        this.bVE.setVisibility(8);
        this.hxa.showNetRefreshView(this.mRootView, str, true);
        this.hxa.setNetRefreshViewTopMargin(400);
    }

    public void bWE() {
        this.bVE.setVisibility(0);
        this.hxa.hideNetRefreshView(this.mRootView);
    }

    public void showLoadingView() {
        this.bVE.setVisibility(8);
        this.hxa.showLoadingView(this.mRootView, true);
    }

    public void bWF() {
        this.bVE.setVisibility(0);
        this.hxa.hideLoadingView(this.mRootView);
    }

    public void g(NoNetworkView.a aVar) {
        if (aVar != null) {
            this.fns.a(aVar);
        }
    }

    public void mP(boolean z) {
        if (!z) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.hpn.getLayoutParams();
            layoutParams.height = UtilHelper.getLightStatusBarHeight() + l.getDimens(this.hxa.getActivity(), R.dimen.ds170);
            this.hpn.setLayoutParams(layoutParams);
            return;
        }
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.hpn.getLayoutParams();
        layoutParams2.height = UtilHelper.getLightStatusBarHeight() + l.getDimens(this.hxa.getActivity(), R.dimen.ds88);
        this.hpn.setLayoutParams(layoutParams2);
    }
}
