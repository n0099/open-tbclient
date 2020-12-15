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
/* loaded from: classes23.dex */
public class a extends c<TbTitleActivity> {
    private ScrollView cKf;
    private NoNetworkView grf;
    private View iIy;
    private View.OnClickListener iQg;
    private TbTitleActivity iQl;
    private LinearLayout iQm;
    private TextView iQn;
    private ImageView iQo;
    private TextView iQp;
    private TextView iQq;
    public LinearLayout iQr;
    private List<LevelInfo> iQs;
    private DataRes iQt;
    private C0736a iQu;
    private NavigationBar mNavigationBar;
    private RelativeLayout mRootView;

    public a(TbTitleActivity tbTitleActivity, View.OnClickListener onClickListener) {
        super(tbTitleActivity.getPageContext());
        this.iQu = new C0736a(new View.OnClickListener() { // from class: com.baidu.tieba.forumMember.tbtitle.a.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(a.this.iQl.getPageContext().getContext()).createNormalCfg(a.this.getPageContext().getString(R.string.tieba_text), "from")));
            }
        });
        this.iQl = tbTitleActivity;
        this.iQg = onClickListener;
        initUI();
    }

    private void initUI() {
        this.mRootView = (RelativeLayout) LayoutInflater.from(this.iQl.getPageContext().getPageActivity()).inflate(R.layout.tbtitle_activity, (ViewGroup) null);
        this.iQl.setContentView(this.mRootView);
        this.iIy = this.mRootView.findViewById(R.id.top_view);
        if (!j.isNetworkAvailableForImmediately()) {
            this.iIy.getLayoutParams().height = UtilHelper.getLightStatusBarHeight() + l.getDimens(this.iQl.getActivity(), R.dimen.ds170);
        } else {
            this.iIy.getLayoutParams().height = UtilHelper.getLightStatusBarHeight() + l.getDimens(this.iQl.getActivity(), R.dimen.ds88);
        }
        this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setCenterTextTitle(this.iQl.getString(R.string.tbtitle_title));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.showBottomLine();
        this.cKf = (ScrollView) this.mRootView.findViewById(R.id.tbtitle_scroll_view);
        this.iQr = (LinearLayout) this.mRootView.findViewById(R.id.first_line_layout);
        this.iQq = (TextView) this.mRootView.findViewById(R.id.tbtile_like_btn);
        this.iQm = (LinearLayout) this.mRootView.findViewById(R.id.table_canvas);
        this.iQn = (TextView) this.mRootView.findViewById(R.id.user_level_name);
        this.iQo = (ImageView) this.mRootView.findViewById(R.id.header_level_img);
        this.iQp = (TextView) this.mRootView.findViewById(R.id.tbtitle_tip_detail2);
        this.grf = (NoNetworkView) this.mRootView.findViewById(R.id.view_no_network);
        cAF();
        cAG();
    }

    private void cAF() {
        String string = getPageContext().getResources().getString(R.string.tbtitle_tip_detail2);
        String string2 = getPageContext().getResources().getString(R.string.tbtitle_tip_tieba_bar);
        int length = string2.length();
        int indexOf = string.indexOf(string2);
        SpannableString spannableString = new SpannableString(string);
        spannableString.setSpan(this.iQu, indexOf, length + indexOf, 33);
        this.iQp.setText(spannableString);
        this.iQp.setMovementMethod(LinkMovementMethod.getInstance());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.forumMember.tbtitle.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes23.dex */
    public class C0736a extends ClickableSpan {
        private View.OnClickListener faK;

        public C0736a(View.OnClickListener onClickListener) {
            this.faK = onClickListener;
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            textPaint.setColor(ap.getColor(R.color.CAM_X0302));
            textPaint.setUnderlineText(false);
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View view) {
            this.faK.onClick(view);
        }
    }

    public void de(List<LevelInfo> list) {
        this.iQs = list;
        if (this.iQm != null && this.iQs != null && this.iQs.size() != 0) {
            this.iQm.removeAllViews();
            for (int i = 1; i <= list.size(); i++) {
                LevelInfo levelInfo = list.get(i - 1);
                View inflate = LayoutInflater.from(this.iQl.getPageContext().getContext()).inflate(R.layout.tbtitle_table_item, (ViewGroup) null);
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
                this.iQm.addView(inflate);
            }
        }
    }

    public void a(DataRes dataRes) {
        this.iQt = dataRes;
        if (this.iQt != null) {
            if (this.iQt.is_like.intValue() == 1 && this.iQr != null) {
                this.iQr.setVisibility(8);
            }
            if (this.iQn != null) {
                if (StringUtils.isNull(this.iQt.level_name, true)) {
                    this.iQn.setText(this.iQt.level_name);
                } else {
                    this.iQn.setVisibility(8);
                }
            }
            if (this.iQo != null) {
                if (this.iQt.user_level.intValue() <= 0 || this.iQt.user_level.intValue() > 18) {
                    this.iQo.setVisibility(8);
                } else {
                    ap.setImageResource(this.iQo, BitmapHelper.getGradeResourceIdNew(this.iQt.user_level.intValue()));
                }
            }
        }
    }

    private void cAG() {
        this.iQq.setOnClickListener(this.iQg);
        this.iQp.setOnClickListener(this.iQg);
    }

    public void onSkinTypeChanged(int i) {
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(this.iQl.getPageContext(), i);
        }
        if (this.grf != null) {
            this.grf.onChangeSkinType(this.iQl.getPageContext(), i);
        }
        de(this.iQs);
        a(this.iQt);
        this.iQl.getLayoutMode().setNightMode(i == 1);
        this.iQl.getLayoutMode().onModeChanged(this.mRootView);
    }

    public void KD(String str) {
        this.cKf.setVisibility(8);
        this.iQl.showNetRefreshView(this.mRootView, str, true);
        this.iQl.setNetRefreshViewTopMargin(400);
    }

    public void cAH() {
        this.cKf.setVisibility(0);
        this.iQl.hideNetRefreshView(this.mRootView);
    }

    public void showLoadingView() {
        this.cKf.setVisibility(8);
        this.iQl.showLoadingView(this.mRootView, true);
    }

    public void cAI() {
        this.cKf.setVisibility(0);
        this.iQl.hideLoadingView(this.mRootView);
    }

    public void g(NoNetworkView.a aVar) {
        if (aVar != null) {
            this.grf.a(aVar);
        }
    }

    public void pM(boolean z) {
        if (!z) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.iIy.getLayoutParams();
            layoutParams.height = UtilHelper.getLightStatusBarHeight() + l.getDimens(this.iQl.getActivity(), R.dimen.ds170);
            this.iIy.setLayoutParams(layoutParams);
            return;
        }
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.iIy.getLayoutParams();
        layoutParams2.height = UtilHelper.getLightStatusBarHeight() + l.getDimens(this.iQl.getActivity(), R.dimen.ds88);
        this.iIy.setLayoutParams(layoutParams2);
    }
}
