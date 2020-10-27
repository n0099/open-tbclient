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
    private ScrollView czb;
    private NoNetworkView gdx;
    private View iqS;
    private View.OnClickListener iyB;
    private TbTitleActivity iyG;
    private LinearLayout iyH;
    private TextView iyI;
    private ImageView iyJ;
    private TextView iyK;
    private TextView iyL;
    public LinearLayout iyM;
    private List<LevelInfo> iyN;
    private DataRes iyO;
    private C0707a iyP;
    private NavigationBar mNavigationBar;
    private RelativeLayout mRootView;

    public a(TbTitleActivity tbTitleActivity, View.OnClickListener onClickListener) {
        super(tbTitleActivity.getPageContext());
        this.iyP = new C0707a(new View.OnClickListener() { // from class: com.baidu.tieba.forumMember.tbtitle.a.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(a.this.iyG.getPageContext().getContext()).createNormalCfg(a.this.getPageContext().getString(R.string.tieba_text), "from")));
            }
        });
        this.iyG = tbTitleActivity;
        this.iyB = onClickListener;
        initUI();
    }

    private void initUI() {
        this.mRootView = (RelativeLayout) LayoutInflater.from(this.iyG.getPageContext().getPageActivity()).inflate(R.layout.tbtitle_activity, (ViewGroup) null);
        this.iyG.setContentView(this.mRootView);
        this.iqS = this.mRootView.findViewById(R.id.top_view);
        if (!j.isNetworkAvailableForImmediately()) {
            this.iqS.getLayoutParams().height = UtilHelper.getLightStatusBarHeight() + l.getDimens(this.iyG.getActivity(), R.dimen.ds170);
        } else {
            this.iqS.getLayoutParams().height = UtilHelper.getLightStatusBarHeight() + l.getDimens(this.iyG.getActivity(), R.dimen.ds88);
        }
        this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setCenterTextTitle(this.iyG.getString(R.string.tbtitle_title));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.showBottomLine();
        this.czb = (ScrollView) this.mRootView.findViewById(R.id.tbtitle_scroll_view);
        this.iyM = (LinearLayout) this.mRootView.findViewById(R.id.first_line_layout);
        this.iyL = (TextView) this.mRootView.findViewById(R.id.tbtile_like_btn);
        this.iyH = (LinearLayout) this.mRootView.findViewById(R.id.table_canvas);
        this.iyI = (TextView) this.mRootView.findViewById(R.id.user_level_name);
        this.iyJ = (ImageView) this.mRootView.findViewById(R.id.header_level_img);
        this.iyK = (TextView) this.mRootView.findViewById(R.id.tbtitle_tip_detail2);
        this.gdx = (NoNetworkView) this.mRootView.findViewById(R.id.view_no_network);
        cul();
        cum();
    }

    private void cul() {
        String string = getPageContext().getResources().getString(R.string.tbtitle_tip_detail2);
        String string2 = getPageContext().getResources().getString(R.string.tbtitle_tip_tieba_bar);
        int length = string2.length();
        int indexOf = string.indexOf(string2);
        SpannableString spannableString = new SpannableString(string);
        spannableString.setSpan(this.iyP, indexOf, length + indexOf, 33);
        this.iyK.setText(spannableString);
        this.iyK.setMovementMethod(LinkMovementMethod.getInstance());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.forumMember.tbtitle.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes23.dex */
    public class C0707a extends ClickableSpan {
        private View.OnClickListener eOs;

        public C0707a(View.OnClickListener onClickListener) {
            this.eOs = onClickListener;
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            textPaint.setColor(ap.getColor(R.color.cp_link_tip_a));
            textPaint.setUnderlineText(false);
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View view) {
            this.eOs.onClick(view);
        }
    }

    public void cS(List<LevelInfo> list) {
        this.iyN = list;
        if (this.iyH != null && this.iyN != null && this.iyN.size() != 0) {
            this.iyH.removeAllViews();
            for (int i = 1; i <= list.size(); i++) {
                LevelInfo levelInfo = list.get(i - 1);
                View inflate = LayoutInflater.from(this.iyG.getPageContext().getContext()).inflate(R.layout.tbtitle_table_item, (ViewGroup) null);
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
                this.iyH.addView(inflate);
            }
        }
    }

    public void a(DataRes dataRes) {
        this.iyO = dataRes;
        if (this.iyO != null) {
            if (this.iyO.is_like.intValue() == 1 && this.iyM != null) {
                this.iyM.setVisibility(8);
            }
            if (this.iyI != null) {
                if (StringUtils.isNull(this.iyO.level_name, true)) {
                    this.iyI.setText(this.iyO.level_name);
                } else {
                    this.iyI.setVisibility(8);
                }
            }
            if (this.iyJ != null) {
                if (this.iyO.user_level.intValue() <= 0 || this.iyO.user_level.intValue() > 18) {
                    this.iyJ.setVisibility(8);
                } else {
                    ap.setImageResource(this.iyJ, BitmapHelper.getGradeResourceIdNew(this.iyO.user_level.intValue()));
                }
            }
        }
    }

    private void cum() {
        this.iyL.setOnClickListener(this.iyB);
        this.iyK.setOnClickListener(this.iyB);
    }

    public void onSkinTypeChanged(int i) {
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(this.iyG.getPageContext(), i);
        }
        if (this.gdx != null) {
            this.gdx.onChangeSkinType(this.iyG.getPageContext(), i);
        }
        cS(this.iyN);
        a(this.iyO);
        this.iyG.getLayoutMode().setNightMode(i == 1);
        this.iyG.getLayoutMode().onModeChanged(this.mRootView);
    }

    public void JV(String str) {
        this.czb.setVisibility(8);
        this.iyG.showNetRefreshView(this.mRootView, str, true);
        this.iyG.setNetRefreshViewTopMargin(400);
    }

    public void cun() {
        this.czb.setVisibility(0);
        this.iyG.hideNetRefreshView(this.mRootView);
    }

    public void showLoadingView() {
        this.czb.setVisibility(8);
        this.iyG.showLoadingView(this.mRootView, true);
    }

    public void cuo() {
        this.czb.setVisibility(0);
        this.iyG.hideLoadingView(this.mRootView);
    }

    public void g(NoNetworkView.a aVar) {
        if (aVar != null) {
            this.gdx.a(aVar);
        }
    }

    public void pd(boolean z) {
        if (!z) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.iqS.getLayoutParams();
            layoutParams.height = UtilHelper.getLightStatusBarHeight() + l.getDimens(this.iyG.getActivity(), R.dimen.ds170);
            this.iqS.setLayoutParams(layoutParams);
            return;
        }
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.iqS.getLayoutParams();
        layoutParams2.height = UtilHelper.getLightStatusBarHeight() + l.getDimens(this.iyG.getActivity(), R.dimen.ds88);
        this.iqS.setLayoutParams(layoutParams2);
    }
}
