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
import com.baidu.tbadk.core.util.al;
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
    private NoNetworkView btu;
    private View cXU;
    private TbTitleActivity dfD;
    private ScrollView dfE;
    private LinearLayout dfF;
    private TextView dfG;
    private ImageView dfH;
    private TextView dfI;
    private TextView dfJ;
    public LinearLayout dfK;
    private List<LevelInfo> dfL;
    private DataRes dfM;
    private C0148a dfN;
    private View.OnClickListener dfx;
    private NavigationBar mNavigationBar;
    private RelativeLayout mRootView;

    public a(TbTitleActivity tbTitleActivity, View.OnClickListener onClickListener) {
        super(tbTitleActivity.getPageContext());
        this.dfN = new C0148a(new View.OnClickListener() { // from class: com.baidu.tieba.forumMember.tbtitle.a.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(a.this.dfD.getPageContext().getContext()).createNormalCfg(a.this.getPageContext().getString(d.k.tieba_text), "from")));
            }
        });
        this.dfD = tbTitleActivity;
        this.dfx = onClickListener;
        initUI();
    }

    private void initUI() {
        this.mRootView = (RelativeLayout) LayoutInflater.from(this.dfD.getPageContext().getPageActivity()).inflate(d.i.tbtitle_activity, (ViewGroup) null);
        this.dfD.setContentView(this.mRootView);
        this.cXU = this.mRootView.findViewById(d.g.top_view);
        if (!j.jr()) {
            this.cXU.getLayoutParams().height = UtilHelper.getLightStatusBarHeight() + l.e(this.dfD.getActivity(), d.e.ds170);
        } else {
            this.cXU.getLayoutParams().height = UtilHelper.getLightStatusBarHeight() + l.e(this.dfD.getActivity(), d.e.ds88);
        }
        this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(d.g.view_navigation_bar);
        this.mNavigationBar.setCenterTextTitle(this.dfD.getString(d.k.tbtitle_title));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.showBottomLine();
        this.dfE = (ScrollView) this.mRootView.findViewById(d.g.tbtitle_scroll_view);
        this.dfK = (LinearLayout) this.mRootView.findViewById(d.g.first_line_layout);
        this.dfJ = (TextView) this.mRootView.findViewById(d.g.tbtile_like_btn);
        this.dfF = (LinearLayout) this.mRootView.findViewById(d.g.table_canvas);
        this.dfG = (TextView) this.mRootView.findViewById(d.g.user_level_name);
        this.dfH = (ImageView) this.mRootView.findViewById(d.g.header_level_img);
        this.dfI = (TextView) this.mRootView.findViewById(d.g.tbtitle_tip_detail2);
        this.btu = (NoNetworkView) this.mRootView.findViewById(d.g.view_no_network);
        asw();
        asx();
    }

    private void asw() {
        String string = getPageContext().getResources().getString(d.k.tbtitle_tip_detail2);
        String string2 = getPageContext().getResources().getString(d.k.tbtitle_tip_tieba_bar);
        int length = string2.length();
        int indexOf = string.indexOf(string2);
        SpannableString spannableString = new SpannableString(string);
        spannableString.setSpan(this.dfN, indexOf, length + indexOf, 33);
        this.dfI.setText(spannableString);
        this.dfI.setMovementMethod(LinkMovementMethod.getInstance());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.forumMember.tbtitle.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0148a extends ClickableSpan {
        private View.OnClickListener avq;

        public C0148a(View.OnClickListener onClickListener) {
            this.avq = onClickListener;
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            textPaint.setColor(al.getColor(d.C0141d.cp_link_tip_a));
            textPaint.setUnderlineText(false);
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View view) {
            this.avq.onClick(view);
        }
    }

    public void bj(List<LevelInfo> list) {
        this.dfL = list;
        if (this.dfF != null && this.dfL != null && this.dfL.size() != 0) {
            this.dfF.removeAllViews();
            for (int i = 1; i <= list.size(); i++) {
                LevelInfo levelInfo = list.get(i - 1);
                View inflate = LayoutInflater.from(this.dfD.getPageContext().getContext()).inflate(d.i.tbtitle_table_item, (ViewGroup) null);
                LinearLayout linearLayout = (LinearLayout) inflate.findViewById(d.g.table_item_background);
                TextView textView = (TextView) inflate.findViewById(d.g.table_item_level_name);
                TextView textView2 = (TextView) inflate.findViewById(d.g.table_item_need_experienment);
                View findViewById = inflate.findViewById(d.g.tbtile_item_horizontal_line);
                ImageView imageView = (ImageView) inflate.findViewById(d.g.table_item_level_img);
                if (i % 2 != 0) {
                    al.i(linearLayout, d.C0141d.cp_bg_line_e);
                }
                al.c(textView, d.C0141d.cp_cont_b, 1);
                al.c(textView2, d.C0141d.cp_cont_b, 1);
                al.j(findViewById, d.C0141d.cp_bg_line_b);
                al.c(imageView, BitmapHelper.getGradeResourceIdNew(levelInfo.id.intValue()));
                textView.setText(levelInfo.name);
                if (levelInfo.score.intValue() <= 3000000 && levelInfo.score.intValue() > 0) {
                    textView2.setText(levelInfo.score + "");
                } else if (levelInfo.score.intValue() <= 0) {
                    textView2.setText("0");
                } else {
                    textView2.setText("3000000");
                }
                this.dfF.addView(inflate);
            }
        }
    }

    public void a(DataRes dataRes) {
        this.dfM = dataRes;
        if (this.dfM != null) {
            if (this.dfM.is_like.intValue() == 1 && this.dfK != null) {
                this.dfK.setVisibility(8);
            }
            if (this.dfG != null) {
                if (StringUtils.isNull(this.dfM.level_name, true)) {
                    this.dfG.setText(this.dfM.level_name);
                } else {
                    this.dfG.setVisibility(8);
                }
            }
            if (this.dfH != null) {
                if (this.dfM.user_level.intValue() <= 0 || this.dfM.user_level.intValue() > 18) {
                    this.dfH.setVisibility(8);
                } else {
                    al.c(this.dfH, BitmapHelper.getGradeResourceIdNew(this.dfM.user_level.intValue()));
                }
            }
        }
    }

    private void asx() {
        this.dfJ.setOnClickListener(this.dfx);
        this.dfI.setOnClickListener(this.dfx);
    }

    public void dk(int i) {
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(this.dfD.getPageContext(), i);
        }
        if (this.btu != null) {
            this.btu.onChangeSkinType(this.dfD.getPageContext(), i);
        }
        bj(this.dfL);
        a(this.dfM);
        this.dfD.getLayoutMode().setNightMode(i == 1);
        this.dfD.getLayoutMode().onModeChanged(this.mRootView);
    }

    public void mp(String str) {
        this.dfE.setVisibility(8);
        this.dfD.showNetRefreshView(this.mRootView, str, true);
        this.dfD.setNetRefreshViewTopMargin(HttpStatus.SC_BAD_REQUEST);
    }

    public void asy() {
        this.dfE.setVisibility(0);
        this.dfD.hideNetRefreshView(this.mRootView);
    }

    public void showLoadingView() {
        this.dfE.setVisibility(8);
        this.dfD.showLoadingView(this.mRootView, true);
    }

    public void asz() {
        this.dfE.setVisibility(0);
        this.dfD.hideLoadingView(this.mRootView);
    }

    public void h(NoNetworkView.a aVar) {
        if (aVar != null) {
            this.btu.a(aVar);
        }
    }

    public void fr(boolean z) {
        if (!z) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.cXU.getLayoutParams();
            layoutParams.height = UtilHelper.getLightStatusBarHeight() + l.e(this.dfD.getActivity(), d.e.ds170);
            this.cXU.setLayoutParams(layoutParams);
            return;
        }
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.cXU.getLayoutParams();
        layoutParams2.height = UtilHelper.getLightStatusBarHeight() + l.e(this.dfD.getActivity(), d.e.ds88);
        this.cXU.setLayoutParams(layoutParams2);
    }
}
