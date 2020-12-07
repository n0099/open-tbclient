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
    private NoNetworkView grd;
    private View iIw;
    private View.OnClickListener iQe;
    private TbTitleActivity iQj;
    private LinearLayout iQk;
    private TextView iQl;
    private ImageView iQm;
    private TextView iQn;
    private TextView iQo;
    public LinearLayout iQp;
    private List<LevelInfo> iQq;
    private DataRes iQr;
    private C0736a iQs;
    private NavigationBar mNavigationBar;
    private RelativeLayout mRootView;

    public a(TbTitleActivity tbTitleActivity, View.OnClickListener onClickListener) {
        super(tbTitleActivity.getPageContext());
        this.iQs = new C0736a(new View.OnClickListener() { // from class: com.baidu.tieba.forumMember.tbtitle.a.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(a.this.iQj.getPageContext().getContext()).createNormalCfg(a.this.getPageContext().getString(R.string.tieba_text), "from")));
            }
        });
        this.iQj = tbTitleActivity;
        this.iQe = onClickListener;
        initUI();
    }

    private void initUI() {
        this.mRootView = (RelativeLayout) LayoutInflater.from(this.iQj.getPageContext().getPageActivity()).inflate(R.layout.tbtitle_activity, (ViewGroup) null);
        this.iQj.setContentView(this.mRootView);
        this.iIw = this.mRootView.findViewById(R.id.top_view);
        if (!j.isNetworkAvailableForImmediately()) {
            this.iIw.getLayoutParams().height = UtilHelper.getLightStatusBarHeight() + l.getDimens(this.iQj.getActivity(), R.dimen.ds170);
        } else {
            this.iIw.getLayoutParams().height = UtilHelper.getLightStatusBarHeight() + l.getDimens(this.iQj.getActivity(), R.dimen.ds88);
        }
        this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setCenterTextTitle(this.iQj.getString(R.string.tbtitle_title));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.showBottomLine();
        this.cKf = (ScrollView) this.mRootView.findViewById(R.id.tbtitle_scroll_view);
        this.iQp = (LinearLayout) this.mRootView.findViewById(R.id.first_line_layout);
        this.iQo = (TextView) this.mRootView.findViewById(R.id.tbtile_like_btn);
        this.iQk = (LinearLayout) this.mRootView.findViewById(R.id.table_canvas);
        this.iQl = (TextView) this.mRootView.findViewById(R.id.user_level_name);
        this.iQm = (ImageView) this.mRootView.findViewById(R.id.header_level_img);
        this.iQn = (TextView) this.mRootView.findViewById(R.id.tbtitle_tip_detail2);
        this.grd = (NoNetworkView) this.mRootView.findViewById(R.id.view_no_network);
        cAE();
        cAF();
    }

    private void cAE() {
        String string = getPageContext().getResources().getString(R.string.tbtitle_tip_detail2);
        String string2 = getPageContext().getResources().getString(R.string.tbtitle_tip_tieba_bar);
        int length = string2.length();
        int indexOf = string.indexOf(string2);
        SpannableString spannableString = new SpannableString(string);
        spannableString.setSpan(this.iQs, indexOf, length + indexOf, 33);
        this.iQn.setText(spannableString);
        this.iQn.setMovementMethod(LinkMovementMethod.getInstance());
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
        this.iQq = list;
        if (this.iQk != null && this.iQq != null && this.iQq.size() != 0) {
            this.iQk.removeAllViews();
            for (int i = 1; i <= list.size(); i++) {
                LevelInfo levelInfo = list.get(i - 1);
                View inflate = LayoutInflater.from(this.iQj.getPageContext().getContext()).inflate(R.layout.tbtitle_table_item, (ViewGroup) null);
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
                this.iQk.addView(inflate);
            }
        }
    }

    public void a(DataRes dataRes) {
        this.iQr = dataRes;
        if (this.iQr != null) {
            if (this.iQr.is_like.intValue() == 1 && this.iQp != null) {
                this.iQp.setVisibility(8);
            }
            if (this.iQl != null) {
                if (StringUtils.isNull(this.iQr.level_name, true)) {
                    this.iQl.setText(this.iQr.level_name);
                } else {
                    this.iQl.setVisibility(8);
                }
            }
            if (this.iQm != null) {
                if (this.iQr.user_level.intValue() <= 0 || this.iQr.user_level.intValue() > 18) {
                    this.iQm.setVisibility(8);
                } else {
                    ap.setImageResource(this.iQm, BitmapHelper.getGradeResourceIdNew(this.iQr.user_level.intValue()));
                }
            }
        }
    }

    private void cAF() {
        this.iQo.setOnClickListener(this.iQe);
        this.iQn.setOnClickListener(this.iQe);
    }

    public void onSkinTypeChanged(int i) {
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(this.iQj.getPageContext(), i);
        }
        if (this.grd != null) {
            this.grd.onChangeSkinType(this.iQj.getPageContext(), i);
        }
        de(this.iQq);
        a(this.iQr);
        this.iQj.getLayoutMode().setNightMode(i == 1);
        this.iQj.getLayoutMode().onModeChanged(this.mRootView);
    }

    public void KD(String str) {
        this.cKf.setVisibility(8);
        this.iQj.showNetRefreshView(this.mRootView, str, true);
        this.iQj.setNetRefreshViewTopMargin(400);
    }

    public void cAG() {
        this.cKf.setVisibility(0);
        this.iQj.hideNetRefreshView(this.mRootView);
    }

    public void showLoadingView() {
        this.cKf.setVisibility(8);
        this.iQj.showLoadingView(this.mRootView, true);
    }

    public void cAH() {
        this.cKf.setVisibility(0);
        this.iQj.hideLoadingView(this.mRootView);
    }

    public void g(NoNetworkView.a aVar) {
        if (aVar != null) {
            this.grd.a(aVar);
        }
    }

    public void pM(boolean z) {
        if (!z) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.iIw.getLayoutParams();
            layoutParams.height = UtilHelper.getLightStatusBarHeight() + l.getDimens(this.iQj.getActivity(), R.dimen.ds170);
            this.iIw.setLayoutParams(layoutParams);
            return;
        }
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.iIw.getLayoutParams();
        layoutParams2.height = UtilHelper.getLightStatusBarHeight() + l.getDimens(this.iQj.getActivity(), R.dimen.ds88);
        this.iIw.setLayoutParams(layoutParams2);
    }
}
