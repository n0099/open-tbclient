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
import com.baidu.tieba.d;
import com.baidu.tieba.forumMember.tbtitle.TbTitleActivity;
import java.util.List;
import org.apache.http.HttpStatus;
import tbclient.GetLevelInfo.DataRes;
import tbclient.LevelInfo;
/* loaded from: classes3.dex */
public class a extends c<TbTitleActivity> {
    private NoNetworkView buT;
    private View cVX;
    private TextView dhA;
    public LinearLayout dhB;
    private List<LevelInfo> dhC;
    private DataRes dhD;
    private C0149a dhE;
    private View.OnClickListener dho;
    private TbTitleActivity dhu;
    private ScrollView dhv;
    private LinearLayout dhw;
    private TextView dhx;
    private ImageView dhy;
    private TextView dhz;
    private NavigationBar mNavigationBar;
    private RelativeLayout mRootView;

    public a(TbTitleActivity tbTitleActivity, View.OnClickListener onClickListener) {
        super(tbTitleActivity.getPageContext());
        this.dhE = new C0149a(new View.OnClickListener() { // from class: com.baidu.tieba.forumMember.tbtitle.a.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(a.this.dhu.getPageContext().getContext()).createNormalCfg(a.this.getPageContext().getString(d.k.tieba_text), "from")));
            }
        });
        this.dhu = tbTitleActivity;
        this.dho = onClickListener;
        initUI();
    }

    private void initUI() {
        this.mRootView = (RelativeLayout) LayoutInflater.from(this.dhu.getPageContext().getPageActivity()).inflate(d.i.tbtitle_activity, (ViewGroup) null);
        this.dhu.setContentView(this.mRootView);
        this.cVX = this.mRootView.findViewById(d.g.top_view);
        if (!j.jr()) {
            this.cVX.getLayoutParams().height = UtilHelper.getLightStatusBarHeight() + l.e(this.dhu.getActivity(), d.e.ds170);
        } else {
            this.cVX.getLayoutParams().height = UtilHelper.getLightStatusBarHeight() + l.e(this.dhu.getActivity(), d.e.ds88);
        }
        this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(d.g.view_navigation_bar);
        this.mNavigationBar.setCenterTextTitle(this.dhu.getString(d.k.tbtitle_title));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.showBottomLine();
        this.dhv = (ScrollView) this.mRootView.findViewById(d.g.tbtitle_scroll_view);
        this.dhB = (LinearLayout) this.mRootView.findViewById(d.g.first_line_layout);
        this.dhA = (TextView) this.mRootView.findViewById(d.g.tbtile_like_btn);
        this.dhw = (LinearLayout) this.mRootView.findViewById(d.g.table_canvas);
        this.dhx = (TextView) this.mRootView.findViewById(d.g.user_level_name);
        this.dhy = (ImageView) this.mRootView.findViewById(d.g.header_level_img);
        this.dhz = (TextView) this.mRootView.findViewById(d.g.tbtitle_tip_detail2);
        this.buT = (NoNetworkView) this.mRootView.findViewById(d.g.view_no_network);
        asH();
        asI();
    }

    private void asH() {
        String string = getPageContext().getResources().getString(d.k.tbtitle_tip_detail2);
        String string2 = getPageContext().getResources().getString(d.k.tbtitle_tip_tieba_bar);
        int length = string2.length();
        int indexOf = string.indexOf(string2);
        SpannableString spannableString = new SpannableString(string);
        spannableString.setSpan(this.dhE, indexOf, length + indexOf, 33);
        this.dhz.setText(spannableString);
        this.dhz.setMovementMethod(LinkMovementMethod.getInstance());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.forumMember.tbtitle.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0149a extends ClickableSpan {
        private View.OnClickListener avZ;

        public C0149a(View.OnClickListener onClickListener) {
            this.avZ = onClickListener;
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            textPaint.setColor(am.getColor(d.C0142d.cp_link_tip_a));
            textPaint.setUnderlineText(false);
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View view) {
            this.avZ.onClick(view);
        }
    }

    public void bk(List<LevelInfo> list) {
        this.dhC = list;
        if (this.dhw != null && this.dhC != null && this.dhC.size() != 0) {
            this.dhw.removeAllViews();
            for (int i = 1; i <= list.size(); i++) {
                LevelInfo levelInfo = list.get(i - 1);
                View inflate = LayoutInflater.from(this.dhu.getPageContext().getContext()).inflate(d.i.tbtitle_table_item, (ViewGroup) null);
                LinearLayout linearLayout = (LinearLayout) inflate.findViewById(d.g.table_item_background);
                TextView textView = (TextView) inflate.findViewById(d.g.table_item_level_name);
                TextView textView2 = (TextView) inflate.findViewById(d.g.table_item_need_experienment);
                View findViewById = inflate.findViewById(d.g.tbtile_item_horizontal_line);
                ImageView imageView = (ImageView) inflate.findViewById(d.g.table_item_level_img);
                if (i % 2 != 0) {
                    am.i(linearLayout, d.C0142d.cp_bg_line_e);
                }
                am.c(textView, d.C0142d.cp_cont_b, 1);
                am.c(textView2, d.C0142d.cp_cont_b, 1);
                am.j(findViewById, d.C0142d.cp_bg_line_b);
                am.c(imageView, BitmapHelper.getGradeResourceIdNew(levelInfo.id.intValue()));
                textView.setText(levelInfo.name);
                if (levelInfo.score.intValue() <= 3000000 && levelInfo.score.intValue() > 0) {
                    textView2.setText(levelInfo.score + "");
                } else if (levelInfo.score.intValue() <= 0) {
                    textView2.setText("0");
                } else {
                    textView2.setText("3000000");
                }
                this.dhw.addView(inflate);
            }
        }
    }

    public void a(DataRes dataRes) {
        this.dhD = dataRes;
        if (this.dhD != null) {
            if (this.dhD.is_like.intValue() == 1 && this.dhB != null) {
                this.dhB.setVisibility(8);
            }
            if (this.dhx != null) {
                if (StringUtils.isNull(this.dhD.level_name, true)) {
                    this.dhx.setText(this.dhD.level_name);
                } else {
                    this.dhx.setVisibility(8);
                }
            }
            if (this.dhy != null) {
                if (this.dhD.user_level.intValue() <= 0 || this.dhD.user_level.intValue() > 18) {
                    this.dhy.setVisibility(8);
                } else {
                    am.c(this.dhy, BitmapHelper.getGradeResourceIdNew(this.dhD.user_level.intValue()));
                }
            }
        }
    }

    private void asI() {
        this.dhA.setOnClickListener(this.dho);
        this.dhz.setOnClickListener(this.dho);
    }

    public void dl(int i) {
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(this.dhu.getPageContext(), i);
        }
        if (this.buT != null) {
            this.buT.onChangeSkinType(this.dhu.getPageContext(), i);
        }
        bk(this.dhC);
        a(this.dhD);
        this.dhu.getLayoutMode().setNightMode(i == 1);
        this.dhu.getLayoutMode().onModeChanged(this.mRootView);
    }

    public void mp(String str) {
        this.dhv.setVisibility(8);
        this.dhu.showNetRefreshView(this.mRootView, str, true);
        this.dhu.setNetRefreshViewTopMargin(HttpStatus.SC_BAD_REQUEST);
    }

    public void asJ() {
        this.dhv.setVisibility(0);
        this.dhu.hideNetRefreshView(this.mRootView);
    }

    public void showLoadingView() {
        this.dhv.setVisibility(8);
        this.dhu.showLoadingView(this.mRootView, true);
    }

    public void asK() {
        this.dhv.setVisibility(0);
        this.dhu.hideLoadingView(this.mRootView);
    }

    public void h(NoNetworkView.a aVar) {
        if (aVar != null) {
            this.buT.a(aVar);
        }
    }

    public void fs(boolean z) {
        if (!z) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.cVX.getLayoutParams();
            layoutParams.height = UtilHelper.getLightStatusBarHeight() + l.e(this.dhu.getActivity(), d.e.ds170);
            this.cVX.setLayoutParams(layoutParams);
            return;
        }
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.cVX.getLayoutParams();
        layoutParams2.height = UtilHelper.getLightStatusBarHeight() + l.e(this.dhu.getActivity(), d.e.ds88);
        this.cVX.setLayoutParams(layoutParams2);
    }
}
