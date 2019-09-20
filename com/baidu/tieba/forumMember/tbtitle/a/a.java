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
    private ScrollView bcE;
    private NoNetworkView dpy;
    private View fio;
    private View.OnClickListener ftF;
    private TbTitleActivity ftK;
    private LinearLayout ftL;
    private TextView ftM;
    private ImageView ftN;
    private TextView ftO;
    private TextView ftP;
    public LinearLayout ftQ;
    private List<LevelInfo> ftR;
    private DataRes ftS;
    private C0318a ftT;
    private NavigationBar mNavigationBar;
    private RelativeLayout mRootView;

    public a(TbTitleActivity tbTitleActivity, View.OnClickListener onClickListener) {
        super(tbTitleActivity.getPageContext());
        this.ftT = new C0318a(new View.OnClickListener() { // from class: com.baidu.tieba.forumMember.tbtitle.a.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(a.this.ftK.getPageContext().getContext()).createNormalCfg(a.this.getPageContext().getString(R.string.tieba_text), "from")));
            }
        });
        this.ftK = tbTitleActivity;
        this.ftF = onClickListener;
        initUI();
    }

    private void initUI() {
        this.mRootView = (RelativeLayout) LayoutInflater.from(this.ftK.getPageContext().getPageActivity()).inflate(R.layout.tbtitle_activity, (ViewGroup) null);
        this.ftK.setContentView(this.mRootView);
        this.fio = this.mRootView.findViewById(R.id.top_view);
        if (!j.jQ()) {
            this.fio.getLayoutParams().height = UtilHelper.getLightStatusBarHeight() + l.g(this.ftK.getActivity(), R.dimen.ds170);
        } else {
            this.fio.getLayoutParams().height = UtilHelper.getLightStatusBarHeight() + l.g(this.ftK.getActivity(), R.dimen.ds88);
        }
        this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setCenterTextTitle(this.ftK.getString(R.string.tbtitle_title));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.showBottomLine();
        this.bcE = (ScrollView) this.mRootView.findViewById(R.id.tbtitle_scroll_view);
        this.ftQ = (LinearLayout) this.mRootView.findViewById(R.id.first_line_layout);
        this.ftP = (TextView) this.mRootView.findViewById(R.id.tbtile_like_btn);
        this.ftL = (LinearLayout) this.mRootView.findViewById(R.id.table_canvas);
        this.ftM = (TextView) this.mRootView.findViewById(R.id.user_level_name);
        this.ftN = (ImageView) this.mRootView.findViewById(R.id.header_level_img);
        this.ftO = (TextView) this.mRootView.findViewById(R.id.tbtitle_tip_detail2);
        this.dpy = (NoNetworkView) this.mRootView.findViewById(R.id.view_no_network);
        bly();
        blz();
    }

    private void bly() {
        String string = getPageContext().getResources().getString(R.string.tbtitle_tip_detail2);
        String string2 = getPageContext().getResources().getString(R.string.tbtitle_tip_tieba_bar);
        int length = string2.length();
        int indexOf = string.indexOf(string2);
        SpannableString spannableString = new SpannableString(string);
        spannableString.setSpan(this.ftT, indexOf, length + indexOf, 33);
        this.ftO.setText(spannableString);
        this.ftO.setMovementMethod(LinkMovementMethod.getInstance());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.forumMember.tbtitle.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class C0318a extends ClickableSpan {
        private View.OnClickListener caG;

        public C0318a(View.OnClickListener onClickListener) {
            this.caG = onClickListener;
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            textPaint.setColor(am.getColor(R.color.cp_link_tip_a));
            textPaint.setUnderlineText(false);
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View view) {
            this.caG.onClick(view);
        }
    }

    public void bW(List<LevelInfo> list) {
        this.ftR = list;
        if (this.ftL != null && this.ftR != null && this.ftR.size() != 0) {
            this.ftL.removeAllViews();
            for (int i = 1; i <= list.size(); i++) {
                LevelInfo levelInfo = list.get(i - 1);
                View inflate = LayoutInflater.from(this.ftK.getPageContext().getContext()).inflate(R.layout.tbtitle_table_item, (ViewGroup) null);
                LinearLayout linearLayout = (LinearLayout) inflate.findViewById(R.id.table_item_background);
                TextView textView = (TextView) inflate.findViewById(R.id.table_item_level_name);
                TextView textView2 = (TextView) inflate.findViewById(R.id.table_item_need_experienment);
                View findViewById = inflate.findViewById(R.id.tbtile_item_horizontal_line);
                ImageView imageView = (ImageView) inflate.findViewById(R.id.table_item_level_img);
                if (i % 2 != 0) {
                    am.k(linearLayout, R.color.cp_bg_line_e);
                }
                am.f(textView, R.color.cp_cont_b, 1);
                am.f(textView2, R.color.cp_cont_b, 1);
                am.l(findViewById, R.color.cp_bg_line_c);
                am.c(imageView, BitmapHelper.getGradeResourceIdNew(levelInfo.id.intValue()));
                textView.setText(levelInfo.name);
                if (levelInfo.score.intValue() <= 3000000 && levelInfo.score.intValue() > 0) {
                    textView2.setText(levelInfo.score + "");
                } else if (levelInfo.score.intValue() <= 0) {
                    textView2.setText("0");
                } else {
                    textView2.setText("3000000");
                }
                this.ftL.addView(inflate);
            }
        }
    }

    public void a(DataRes dataRes) {
        this.ftS = dataRes;
        if (this.ftS != null) {
            if (this.ftS.is_like.intValue() == 1 && this.ftQ != null) {
                this.ftQ.setVisibility(8);
            }
            if (this.ftM != null) {
                if (StringUtils.isNull(this.ftS.level_name, true)) {
                    this.ftM.setText(this.ftS.level_name);
                } else {
                    this.ftM.setVisibility(8);
                }
            }
            if (this.ftN != null) {
                if (this.ftS.user_level.intValue() <= 0 || this.ftS.user_level.intValue() > 18) {
                    this.ftN.setVisibility(8);
                } else {
                    am.c(this.ftN, BitmapHelper.getGradeResourceIdNew(this.ftS.user_level.intValue()));
                }
            }
        }
    }

    private void blz() {
        this.ftP.setOnClickListener(this.ftF);
        this.ftO.setOnClickListener(this.ftF);
    }

    public void iJ(int i) {
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(this.ftK.getPageContext(), i);
        }
        if (this.dpy != null) {
            this.dpy.onChangeSkinType(this.ftK.getPageContext(), i);
        }
        bW(this.ftR);
        a(this.ftS);
        this.ftK.getLayoutMode().setNightMode(i == 1);
        this.ftK.getLayoutMode().onModeChanged(this.mRootView);
    }

    public void xp(String str) {
        this.bcE.setVisibility(8);
        this.ftK.showNetRefreshView(this.mRootView, str, true);
        this.ftK.setNetRefreshViewTopMargin(400);
    }

    public void blA() {
        this.bcE.setVisibility(0);
        this.ftK.hideNetRefreshView(this.mRootView);
    }

    public void showLoadingView() {
        this.bcE.setVisibility(8);
        this.ftK.showLoadingView(this.mRootView, true);
    }

    public void blB() {
        this.bcE.setVisibility(0);
        this.ftK.hideLoadingView(this.mRootView);
    }

    public void h(NoNetworkView.a aVar) {
        if (aVar != null) {
            this.dpy.a(aVar);
        }
    }

    public void jK(boolean z) {
        if (!z) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.fio.getLayoutParams();
            layoutParams.height = UtilHelper.getLightStatusBarHeight() + l.g(this.ftK.getActivity(), R.dimen.ds170);
            this.fio.setLayoutParams(layoutParams);
            return;
        }
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.fio.getLayoutParams();
        layoutParams2.height = UtilHelper.getLightStatusBarHeight() + l.g(this.ftK.getActivity(), R.dimen.ds88);
        this.fio.setLayoutParams(layoutParams2);
    }
}
