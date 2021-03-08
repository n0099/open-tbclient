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
import com.baidu.adp.base.d;
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
/* loaded from: classes7.dex */
public class a extends d<TbTitleActivity> {
    private ScrollView cOc;
    private NoNetworkView gCe;
    private View iXG;
    public LinearLayout jfA;
    private List<LevelInfo> jfB;
    private DataRes jfC;
    private C0726a jfD;
    private View.OnClickListener jfp;
    private TbTitleActivity jfu;
    private LinearLayout jfv;
    private TextView jfw;
    private ImageView jfx;
    private TextView jfy;
    private TextView jfz;
    private NavigationBar mNavigationBar;
    private RelativeLayout mRootView;

    public a(TbTitleActivity tbTitleActivity, View.OnClickListener onClickListener) {
        super(tbTitleActivity.getPageContext());
        this.jfD = new C0726a(new View.OnClickListener() { // from class: com.baidu.tieba.forumMember.tbtitle.a.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(a.this.jfu.getPageContext().getContext()).createNormalCfg(a.this.getPageContext().getString(R.string.tieba_text), "from")));
            }
        });
        this.jfu = tbTitleActivity;
        this.jfp = onClickListener;
        initUI();
    }

    private void initUI() {
        this.mRootView = (RelativeLayout) LayoutInflater.from(this.jfu.getPageContext().getPageActivity()).inflate(R.layout.tbtitle_activity, (ViewGroup) null);
        this.jfu.setContentView(this.mRootView);
        this.iXG = this.mRootView.findViewById(R.id.top_view);
        if (!j.isNetworkAvailableForImmediately()) {
            this.iXG.getLayoutParams().height = UtilHelper.getLightStatusBarHeight() + l.getDimens(this.jfu.getActivity(), R.dimen.ds170);
        } else {
            this.iXG.getLayoutParams().height = UtilHelper.getLightStatusBarHeight() + l.getDimens(this.jfu.getActivity(), R.dimen.ds88);
        }
        this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setCenterTextTitle(this.jfu.getString(R.string.tbtitle_title));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.showBottomLine();
        this.cOc = (ScrollView) this.mRootView.findViewById(R.id.tbtitle_scroll_view);
        this.jfA = (LinearLayout) this.mRootView.findViewById(R.id.first_line_layout);
        this.jfz = (TextView) this.mRootView.findViewById(R.id.tbtile_like_btn);
        this.jfv = (LinearLayout) this.mRootView.findViewById(R.id.table_canvas);
        this.jfw = (TextView) this.mRootView.findViewById(R.id.user_level_name);
        this.jfx = (ImageView) this.mRootView.findViewById(R.id.header_level_img);
        this.jfy = (TextView) this.mRootView.findViewById(R.id.tbtitle_tip_detail2);
        this.gCe = (NoNetworkView) this.mRootView.findViewById(R.id.view_no_network);
        cBf();
        cBg();
    }

    private void cBf() {
        String string = getPageContext().getResources().getString(R.string.tbtitle_tip_detail2);
        String string2 = getPageContext().getResources().getString(R.string.tbtitle_tip_tieba_bar);
        int length = string2.length();
        int indexOf = string.indexOf(string2);
        SpannableString spannableString = new SpannableString(string);
        spannableString.setSpan(this.jfD, indexOf, length + indexOf, 33);
        this.jfy.setText(spannableString);
        this.jfy.setMovementMethod(LinkMovementMethod.getInstance());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.forumMember.tbtitle.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public class C0726a extends ClickableSpan {
        private View.OnClickListener fjv;

        public C0726a(View.OnClickListener onClickListener) {
            this.fjv = onClickListener;
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            textPaint.setColor(ap.getColor(R.color.CAM_X0302));
            textPaint.setUnderlineText(false);
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View view) {
            this.fjv.onClick(view);
        }
    }

    public void dg(List<LevelInfo> list) {
        this.jfB = list;
        if (this.jfv != null && this.jfB != null && this.jfB.size() != 0) {
            this.jfv.removeAllViews();
            for (int i = 1; i <= list.size(); i++) {
                LevelInfo levelInfo = list.get(i - 1);
                View inflate = LayoutInflater.from(this.jfu.getPageContext().getContext()).inflate(R.layout.tbtitle_table_item, (ViewGroup) null);
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
                this.jfv.addView(inflate);
            }
        }
    }

    public void a(DataRes dataRes) {
        this.jfC = dataRes;
        if (this.jfC != null) {
            if (this.jfC.is_like.intValue() == 1 && this.jfA != null) {
                this.jfA.setVisibility(8);
            }
            if (this.jfw != null) {
                if (StringUtils.isNull(this.jfC.level_name, true)) {
                    this.jfw.setText(this.jfC.level_name);
                } else {
                    this.jfw.setVisibility(8);
                }
            }
            if (this.jfx != null) {
                if (this.jfC.user_level.intValue() <= 0 || this.jfC.user_level.intValue() > 18) {
                    this.jfx.setVisibility(8);
                } else {
                    ap.setImageResource(this.jfx, BitmapHelper.getGradeResourceIdNew(this.jfC.user_level.intValue()));
                }
            }
        }
    }

    private void cBg() {
        this.jfz.setOnClickListener(this.jfp);
        this.jfy.setOnClickListener(this.jfp);
    }

    public void onSkinTypeChanged(int i) {
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(this.jfu.getPageContext(), i);
        }
        if (this.gCe != null) {
            this.gCe.onChangeSkinType(this.jfu.getPageContext(), i);
        }
        dg(this.jfB);
        a(this.jfC);
        this.jfu.getLayoutMode().setNightMode(i == 1);
        this.jfu.getLayoutMode().onModeChanged(this.mRootView);
    }

    public void Kk(String str) {
        this.cOc.setVisibility(8);
        this.jfu.showNetRefreshView(this.mRootView, str, true);
        this.jfu.setNetRefreshViewTopMargin(400);
    }

    public void cBh() {
        this.cOc.setVisibility(0);
        this.jfu.hideNetRefreshView(this.mRootView);
    }

    public void showLoadingView() {
        this.cOc.setVisibility(8);
        this.jfu.showLoadingView(this.mRootView, true);
    }

    public void cBi() {
        this.cOc.setVisibility(0);
        this.jfu.hideLoadingView(this.mRootView);
    }

    public void g(NoNetworkView.a aVar) {
        if (aVar != null) {
            this.gCe.a(aVar);
        }
    }

    public void qp(boolean z) {
        if (!z) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.iXG.getLayoutParams();
            layoutParams.height = UtilHelper.getLightStatusBarHeight() + l.getDimens(this.jfu.getActivity(), R.dimen.ds170);
            this.iXG.setLayoutParams(layoutParams);
            return;
        }
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.iXG.getLayoutParams();
        layoutParams2.height = UtilHelper.getLightStatusBarHeight() + l.getDimens(this.jfu.getActivity(), R.dimen.ds88);
        this.iXG.setLayoutParams(layoutParams2);
    }
}
