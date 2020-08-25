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
/* loaded from: classes17.dex */
public class a extends c<TbTitleActivity> {
    private ScrollView ccd;
    private NoNetworkView fDV;
    private View hIo;
    private View.OnClickListener hPY;
    private TbTitleActivity hQd;
    private LinearLayout hQe;
    private TextView hQf;
    private ImageView hQg;
    private TextView hQh;
    private TextView hQi;
    public LinearLayout hQj;
    private List<LevelInfo> hQk;
    private DataRes hQl;
    private C0676a hQm;
    private NavigationBar mNavigationBar;
    private RelativeLayout mRootView;

    public a(TbTitleActivity tbTitleActivity, View.OnClickListener onClickListener) {
        super(tbTitleActivity.getPageContext());
        this.hQm = new C0676a(new View.OnClickListener() { // from class: com.baidu.tieba.forumMember.tbtitle.a.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(a.this.hQd.getPageContext().getContext()).createNormalCfg(a.this.getPageContext().getString(R.string.tieba_text), "from")));
            }
        });
        this.hQd = tbTitleActivity;
        this.hPY = onClickListener;
        initUI();
    }

    private void initUI() {
        this.mRootView = (RelativeLayout) LayoutInflater.from(this.hQd.getPageContext().getPageActivity()).inflate(R.layout.tbtitle_activity, (ViewGroup) null);
        this.hQd.setContentView(this.mRootView);
        this.hIo = this.mRootView.findViewById(R.id.top_view);
        if (!j.isNetworkAvailableForImmediately()) {
            this.hIo.getLayoutParams().height = UtilHelper.getLightStatusBarHeight() + l.getDimens(this.hQd.getActivity(), R.dimen.ds170);
        } else {
            this.hIo.getLayoutParams().height = UtilHelper.getLightStatusBarHeight() + l.getDimens(this.hQd.getActivity(), R.dimen.ds88);
        }
        this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setCenterTextTitle(this.hQd.getString(R.string.tbtitle_title));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.showBottomLine();
        this.ccd = (ScrollView) this.mRootView.findViewById(R.id.tbtitle_scroll_view);
        this.hQj = (LinearLayout) this.mRootView.findViewById(R.id.first_line_layout);
        this.hQi = (TextView) this.mRootView.findViewById(R.id.tbtile_like_btn);
        this.hQe = (LinearLayout) this.mRootView.findViewById(R.id.table_canvas);
        this.hQf = (TextView) this.mRootView.findViewById(R.id.user_level_name);
        this.hQg = (ImageView) this.mRootView.findViewById(R.id.header_level_img);
        this.hQh = (TextView) this.mRootView.findViewById(R.id.tbtitle_tip_detail2);
        this.fDV = (NoNetworkView) this.mRootView.findViewById(R.id.view_no_network);
        cks();
        ckt();
    }

    private void cks() {
        String string = getPageContext().getResources().getString(R.string.tbtitle_tip_detail2);
        String string2 = getPageContext().getResources().getString(R.string.tbtitle_tip_tieba_bar);
        int length = string2.length();
        int indexOf = string.indexOf(string2);
        SpannableString spannableString = new SpannableString(string);
        spannableString.setSpan(this.hQm, indexOf, length + indexOf, 33);
        this.hQh.setText(spannableString);
        this.hQh.setMovementMethod(LinkMovementMethod.getInstance());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.forumMember.tbtitle.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes17.dex */
    public class C0676a extends ClickableSpan {
        private View.OnClickListener erD;

        public C0676a(View.OnClickListener onClickListener) {
            this.erD = onClickListener;
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            textPaint.setColor(ap.getColor(R.color.cp_link_tip_a));
            textPaint.setUnderlineText(false);
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View view) {
            this.erD.onClick(view);
        }
    }

    public void cA(List<LevelInfo> list) {
        this.hQk = list;
        if (this.hQe != null && this.hQk != null && this.hQk.size() != 0) {
            this.hQe.removeAllViews();
            for (int i = 1; i <= list.size(); i++) {
                LevelInfo levelInfo = list.get(i - 1);
                View inflate = LayoutInflater.from(this.hQd.getPageContext().getContext()).inflate(R.layout.tbtitle_table_item, (ViewGroup) null);
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
                this.hQe.addView(inflate);
            }
        }
    }

    public void a(DataRes dataRes) {
        this.hQl = dataRes;
        if (this.hQl != null) {
            if (this.hQl.is_like.intValue() == 1 && this.hQj != null) {
                this.hQj.setVisibility(8);
            }
            if (this.hQf != null) {
                if (StringUtils.isNull(this.hQl.level_name, true)) {
                    this.hQf.setText(this.hQl.level_name);
                } else {
                    this.hQf.setVisibility(8);
                }
            }
            if (this.hQg != null) {
                if (this.hQl.user_level.intValue() <= 0 || this.hQl.user_level.intValue() > 18) {
                    this.hQg.setVisibility(8);
                } else {
                    ap.setImageResource(this.hQg, BitmapHelper.getGradeResourceIdNew(this.hQl.user_level.intValue()));
                }
            }
        }
    }

    private void ckt() {
        this.hQi.setOnClickListener(this.hPY);
        this.hQh.setOnClickListener(this.hPY);
    }

    public void onSkinTypeChanged(int i) {
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(this.hQd.getPageContext(), i);
        }
        if (this.fDV != null) {
            this.fDV.onChangeSkinType(this.hQd.getPageContext(), i);
        }
        cA(this.hQk);
        a(this.hQl);
        this.hQd.getLayoutMode().setNightMode(i == 1);
        this.hQd.getLayoutMode().onModeChanged(this.mRootView);
    }

    public void Il(String str) {
        this.ccd.setVisibility(8);
        this.hQd.showNetRefreshView(this.mRootView, str, true);
        this.hQd.setNetRefreshViewTopMargin(400);
    }

    public void cku() {
        this.ccd.setVisibility(0);
        this.hQd.hideNetRefreshView(this.mRootView);
    }

    public void showLoadingView() {
        this.ccd.setVisibility(8);
        this.hQd.showLoadingView(this.mRootView, true);
    }

    public void ckv() {
        this.ccd.setVisibility(0);
        this.hQd.hideLoadingView(this.mRootView);
    }

    public void g(NoNetworkView.a aVar) {
        if (aVar != null) {
            this.fDV.a(aVar);
        }
    }

    public void nY(boolean z) {
        if (!z) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.hIo.getLayoutParams();
            layoutParams.height = UtilHelper.getLightStatusBarHeight() + l.getDimens(this.hQd.getActivity(), R.dimen.ds170);
            this.hIo.setLayoutParams(layoutParams);
            return;
        }
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.hIo.getLayoutParams();
        layoutParams2.height = UtilHelper.getLightStatusBarHeight() + l.getDimens(this.hQd.getActivity(), R.dimen.ds88);
        this.hIo.setLayoutParams(layoutParams2);
    }
}
