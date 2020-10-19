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
    private ScrollView cqA;
    private NoNetworkView fTu;
    private View ieu;
    private View.OnClickListener imd;
    private TbTitleActivity imj;
    private LinearLayout imk;
    private TextView iml;
    private ImageView imm;
    private TextView imn;
    private TextView imo;
    public LinearLayout imp;
    private List<LevelInfo> imq;
    private DataRes imr;
    private C0691a ims;
    private NavigationBar mNavigationBar;
    private RelativeLayout mRootView;

    public a(TbTitleActivity tbTitleActivity, View.OnClickListener onClickListener) {
        super(tbTitleActivity.getPageContext());
        this.ims = new C0691a(new View.OnClickListener() { // from class: com.baidu.tieba.forumMember.tbtitle.a.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(a.this.imj.getPageContext().getContext()).createNormalCfg(a.this.getPageContext().getString(R.string.tieba_text), "from")));
            }
        });
        this.imj = tbTitleActivity;
        this.imd = onClickListener;
        initUI();
    }

    private void initUI() {
        this.mRootView = (RelativeLayout) LayoutInflater.from(this.imj.getPageContext().getPageActivity()).inflate(R.layout.tbtitle_activity, (ViewGroup) null);
        this.imj.setContentView(this.mRootView);
        this.ieu = this.mRootView.findViewById(R.id.top_view);
        if (!j.isNetworkAvailableForImmediately()) {
            this.ieu.getLayoutParams().height = UtilHelper.getLightStatusBarHeight() + l.getDimens(this.imj.getActivity(), R.dimen.ds170);
        } else {
            this.ieu.getLayoutParams().height = UtilHelper.getLightStatusBarHeight() + l.getDimens(this.imj.getActivity(), R.dimen.ds88);
        }
        this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setCenterTextTitle(this.imj.getString(R.string.tbtitle_title));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.showBottomLine();
        this.cqA = (ScrollView) this.mRootView.findViewById(R.id.tbtitle_scroll_view);
        this.imp = (LinearLayout) this.mRootView.findViewById(R.id.first_line_layout);
        this.imo = (TextView) this.mRootView.findViewById(R.id.tbtile_like_btn);
        this.imk = (LinearLayout) this.mRootView.findViewById(R.id.table_canvas);
        this.iml = (TextView) this.mRootView.findViewById(R.id.user_level_name);
        this.imm = (ImageView) this.mRootView.findViewById(R.id.header_level_img);
        this.imn = (TextView) this.mRootView.findViewById(R.id.tbtitle_tip_detail2);
        this.fTu = (NoNetworkView) this.mRootView.findViewById(R.id.view_no_network);
        cre();
        crf();
    }

    private void cre() {
        String string = getPageContext().getResources().getString(R.string.tbtitle_tip_detail2);
        String string2 = getPageContext().getResources().getString(R.string.tbtitle_tip_tieba_bar);
        int length = string2.length();
        int indexOf = string.indexOf(string2);
        SpannableString spannableString = new SpannableString(string);
        spannableString.setSpan(this.ims, indexOf, length + indexOf, 33);
        this.imn.setText(spannableString);
        this.imn.setMovementMethod(LinkMovementMethod.getInstance());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.forumMember.tbtitle.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes23.dex */
    public class C0691a extends ClickableSpan {
        private View.OnClickListener eFW;

        public C0691a(View.OnClickListener onClickListener) {
            this.eFW = onClickListener;
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            textPaint.setColor(ap.getColor(R.color.cp_link_tip_a));
            textPaint.setUnderlineText(false);
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View view) {
            this.eFW.onClick(view);
        }
    }

    public void cJ(List<LevelInfo> list) {
        this.imq = list;
        if (this.imk != null && this.imq != null && this.imq.size() != 0) {
            this.imk.removeAllViews();
            for (int i = 1; i <= list.size(); i++) {
                LevelInfo levelInfo = list.get(i - 1);
                View inflate = LayoutInflater.from(this.imj.getPageContext().getContext()).inflate(R.layout.tbtitle_table_item, (ViewGroup) null);
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
                this.imk.addView(inflate);
            }
        }
    }

    public void a(DataRes dataRes) {
        this.imr = dataRes;
        if (this.imr != null) {
            if (this.imr.is_like.intValue() == 1 && this.imp != null) {
                this.imp.setVisibility(8);
            }
            if (this.iml != null) {
                if (StringUtils.isNull(this.imr.level_name, true)) {
                    this.iml.setText(this.imr.level_name);
                } else {
                    this.iml.setVisibility(8);
                }
            }
            if (this.imm != null) {
                if (this.imr.user_level.intValue() <= 0 || this.imr.user_level.intValue() > 18) {
                    this.imm.setVisibility(8);
                } else {
                    ap.setImageResource(this.imm, BitmapHelper.getGradeResourceIdNew(this.imr.user_level.intValue()));
                }
            }
        }
    }

    private void crf() {
        this.imo.setOnClickListener(this.imd);
        this.imn.setOnClickListener(this.imd);
    }

    public void onSkinTypeChanged(int i) {
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(this.imj.getPageContext(), i);
        }
        if (this.fTu != null) {
            this.fTu.onChangeSkinType(this.imj.getPageContext(), i);
        }
        cJ(this.imq);
        a(this.imr);
        this.imj.getLayoutMode().setNightMode(i == 1);
        this.imj.getLayoutMode().onModeChanged(this.mRootView);
    }

    public void Jw(String str) {
        this.cqA.setVisibility(8);
        this.imj.showNetRefreshView(this.mRootView, str, true);
        this.imj.setNetRefreshViewTopMargin(400);
    }

    public void crg() {
        this.cqA.setVisibility(0);
        this.imj.hideNetRefreshView(this.mRootView);
    }

    public void showLoadingView() {
        this.cqA.setVisibility(8);
        this.imj.showLoadingView(this.mRootView, true);
    }

    public void crh() {
        this.cqA.setVisibility(0);
        this.imj.hideLoadingView(this.mRootView);
    }

    public void g(NoNetworkView.a aVar) {
        if (aVar != null) {
            this.fTu.a(aVar);
        }
    }

    public void oL(boolean z) {
        if (!z) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.ieu.getLayoutParams();
            layoutParams.height = UtilHelper.getLightStatusBarHeight() + l.getDimens(this.imj.getActivity(), R.dimen.ds170);
            this.ieu.setLayoutParams(layoutParams);
            return;
        }
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.ieu.getLayoutParams();
        layoutParams2.height = UtilHelper.getLightStatusBarHeight() + l.getDimens(this.imj.getActivity(), R.dimen.ds88);
        this.ieu.setLayoutParams(layoutParams2);
    }
}
