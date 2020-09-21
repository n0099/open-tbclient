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
/* loaded from: classes22.dex */
public class a extends c<TbTitleActivity> {
    private ScrollView cek;
    private NoNetworkView fHl;
    private View hPv;
    private View.OnClickListener hXe;
    private TbTitleActivity hXj;
    private LinearLayout hXk;
    private TextView hXl;
    private ImageView hXm;
    private TextView hXn;
    private TextView hXo;
    public LinearLayout hXp;
    private List<LevelInfo> hXq;
    private DataRes hXr;
    private C0673a hXs;
    private NavigationBar mNavigationBar;
    private RelativeLayout mRootView;

    public a(TbTitleActivity tbTitleActivity, View.OnClickListener onClickListener) {
        super(tbTitleActivity.getPageContext());
        this.hXs = new C0673a(new View.OnClickListener() { // from class: com.baidu.tieba.forumMember.tbtitle.a.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(a.this.hXj.getPageContext().getContext()).createNormalCfg(a.this.getPageContext().getString(R.string.tieba_text), "from")));
            }
        });
        this.hXj = tbTitleActivity;
        this.hXe = onClickListener;
        initUI();
    }

    private void initUI() {
        this.mRootView = (RelativeLayout) LayoutInflater.from(this.hXj.getPageContext().getPageActivity()).inflate(R.layout.tbtitle_activity, (ViewGroup) null);
        this.hXj.setContentView(this.mRootView);
        this.hPv = this.mRootView.findViewById(R.id.top_view);
        if (!j.isNetworkAvailableForImmediately()) {
            this.hPv.getLayoutParams().height = UtilHelper.getLightStatusBarHeight() + l.getDimens(this.hXj.getActivity(), R.dimen.ds170);
        } else {
            this.hPv.getLayoutParams().height = UtilHelper.getLightStatusBarHeight() + l.getDimens(this.hXj.getActivity(), R.dimen.ds88);
        }
        this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setCenterTextTitle(this.hXj.getString(R.string.tbtitle_title));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.showBottomLine();
        this.cek = (ScrollView) this.mRootView.findViewById(R.id.tbtitle_scroll_view);
        this.hXp = (LinearLayout) this.mRootView.findViewById(R.id.first_line_layout);
        this.hXo = (TextView) this.mRootView.findViewById(R.id.tbtile_like_btn);
        this.hXk = (LinearLayout) this.mRootView.findViewById(R.id.table_canvas);
        this.hXl = (TextView) this.mRootView.findViewById(R.id.user_level_name);
        this.hXm = (ImageView) this.mRootView.findViewById(R.id.header_level_img);
        this.hXn = (TextView) this.mRootView.findViewById(R.id.tbtitle_tip_detail2);
        this.fHl = (NoNetworkView) this.mRootView.findViewById(R.id.view_no_network);
        cnG();
        cnH();
    }

    private void cnG() {
        String string = getPageContext().getResources().getString(R.string.tbtitle_tip_detail2);
        String string2 = getPageContext().getResources().getString(R.string.tbtitle_tip_tieba_bar);
        int length = string2.length();
        int indexOf = string.indexOf(string2);
        SpannableString spannableString = new SpannableString(string);
        spannableString.setSpan(this.hXs, indexOf, length + indexOf, 33);
        this.hXn.setText(spannableString);
        this.hXn.setMovementMethod(LinkMovementMethod.getInstance());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.forumMember.tbtitle.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes22.dex */
    public class C0673a extends ClickableSpan {
        private View.OnClickListener etM;

        public C0673a(View.OnClickListener onClickListener) {
            this.etM = onClickListener;
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            textPaint.setColor(ap.getColor(R.color.cp_link_tip_a));
            textPaint.setUnderlineText(false);
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View view) {
            this.etM.onClick(view);
        }
    }

    public void cG(List<LevelInfo> list) {
        this.hXq = list;
        if (this.hXk != null && this.hXq != null && this.hXq.size() != 0) {
            this.hXk.removeAllViews();
            for (int i = 1; i <= list.size(); i++) {
                LevelInfo levelInfo = list.get(i - 1);
                View inflate = LayoutInflater.from(this.hXj.getPageContext().getContext()).inflate(R.layout.tbtitle_table_item, (ViewGroup) null);
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
                this.hXk.addView(inflate);
            }
        }
    }

    public void a(DataRes dataRes) {
        this.hXr = dataRes;
        if (this.hXr != null) {
            if (this.hXr.is_like.intValue() == 1 && this.hXp != null) {
                this.hXp.setVisibility(8);
            }
            if (this.hXl != null) {
                if (StringUtils.isNull(this.hXr.level_name, true)) {
                    this.hXl.setText(this.hXr.level_name);
                } else {
                    this.hXl.setVisibility(8);
                }
            }
            if (this.hXm != null) {
                if (this.hXr.user_level.intValue() <= 0 || this.hXr.user_level.intValue() > 18) {
                    this.hXm.setVisibility(8);
                } else {
                    ap.setImageResource(this.hXm, BitmapHelper.getGradeResourceIdNew(this.hXr.user_level.intValue()));
                }
            }
        }
    }

    private void cnH() {
        this.hXo.setOnClickListener(this.hXe);
        this.hXn.setOnClickListener(this.hXe);
    }

    public void onSkinTypeChanged(int i) {
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(this.hXj.getPageContext(), i);
        }
        if (this.fHl != null) {
            this.fHl.onChangeSkinType(this.hXj.getPageContext(), i);
        }
        cG(this.hXq);
        a(this.hXr);
        this.hXj.getLayoutMode().setNightMode(i == 1);
        this.hXj.getLayoutMode().onModeChanged(this.mRootView);
    }

    public void IJ(String str) {
        this.cek.setVisibility(8);
        this.hXj.showNetRefreshView(this.mRootView, str, true);
        this.hXj.setNetRefreshViewTopMargin(400);
    }

    public void cnI() {
        this.cek.setVisibility(0);
        this.hXj.hideNetRefreshView(this.mRootView);
    }

    public void showLoadingView() {
        this.cek.setVisibility(8);
        this.hXj.showLoadingView(this.mRootView, true);
    }

    public void cnJ() {
        this.cek.setVisibility(0);
        this.hXj.hideLoadingView(this.mRootView);
    }

    public void g(NoNetworkView.a aVar) {
        if (aVar != null) {
            this.fHl.a(aVar);
        }
    }

    public void og(boolean z) {
        if (!z) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.hPv.getLayoutParams();
            layoutParams.height = UtilHelper.getLightStatusBarHeight() + l.getDimens(this.hXj.getActivity(), R.dimen.ds170);
            this.hPv.setLayoutParams(layoutParams);
            return;
        }
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.hPv.getLayoutParams();
        layoutParams2.height = UtilHelper.getLightStatusBarHeight() + l.getDimens(this.hXj.getActivity(), R.dimen.ds88);
        this.hPv.setLayoutParams(layoutParams2);
    }
}
