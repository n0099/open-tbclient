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
import com.baidu.tieba.e;
import com.baidu.tieba.forumMember.tbtitle.TbTitleActivity;
import java.util.List;
import tbclient.GetLevelInfo.DataRes;
import tbclient.LevelInfo;
/* loaded from: classes3.dex */
public class a extends c<TbTitleActivity> {
    private ScrollView bDf;
    private NoNetworkView bJX;
    private View dmK;
    private View.OnClickListener dxX;
    private TbTitleActivity dyc;
    private LinearLayout dyd;
    private TextView dye;
    private ImageView dyf;
    private TextView dyg;
    private TextView dyh;
    public LinearLayout dyi;
    private List<LevelInfo> dyj;
    private DataRes dyk;
    private C0181a dyl;
    private NavigationBar mNavigationBar;
    private RelativeLayout mRootView;

    public a(TbTitleActivity tbTitleActivity, View.OnClickListener onClickListener) {
        super(tbTitleActivity.getPageContext());
        this.dyl = new C0181a(new View.OnClickListener() { // from class: com.baidu.tieba.forumMember.tbtitle.a.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(a.this.dyc.getPageContext().getContext()).createNormalCfg(a.this.getPageContext().getString(e.j.tieba_text), "from")));
            }
        });
        this.dyc = tbTitleActivity;
        this.dxX = onClickListener;
        initUI();
    }

    private void initUI() {
        this.mRootView = (RelativeLayout) LayoutInflater.from(this.dyc.getPageContext().getPageActivity()).inflate(e.h.tbtitle_activity, (ViewGroup) null);
        this.dyc.setContentView(this.mRootView);
        this.dmK = this.mRootView.findViewById(e.g.top_view);
        if (!j.kM()) {
            this.dmK.getLayoutParams().height = UtilHelper.getLightStatusBarHeight() + l.h(this.dyc.getActivity(), e.C0175e.ds170);
        } else {
            this.dmK.getLayoutParams().height = UtilHelper.getLightStatusBarHeight() + l.h(this.dyc.getActivity(), e.C0175e.ds88);
        }
        this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(e.g.view_navigation_bar);
        this.mNavigationBar.setCenterTextTitle(this.dyc.getString(e.j.tbtitle_title));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.showBottomLine();
        this.bDf = (ScrollView) this.mRootView.findViewById(e.g.tbtitle_scroll_view);
        this.dyi = (LinearLayout) this.mRootView.findViewById(e.g.first_line_layout);
        this.dyh = (TextView) this.mRootView.findViewById(e.g.tbtile_like_btn);
        this.dyd = (LinearLayout) this.mRootView.findViewById(e.g.table_canvas);
        this.dye = (TextView) this.mRootView.findViewById(e.g.user_level_name);
        this.dyf = (ImageView) this.mRootView.findViewById(e.g.header_level_img);
        this.dyg = (TextView) this.mRootView.findViewById(e.g.tbtitle_tip_detail2);
        this.bJX = (NoNetworkView) this.mRootView.findViewById(e.g.view_no_network);
        ayv();
        ayw();
    }

    private void ayv() {
        String string = getPageContext().getResources().getString(e.j.tbtitle_tip_detail2);
        String string2 = getPageContext().getResources().getString(e.j.tbtitle_tip_tieba_bar);
        int length = string2.length();
        int indexOf = string.indexOf(string2);
        SpannableString spannableString = new SpannableString(string);
        spannableString.setSpan(this.dyl, indexOf, length + indexOf, 33);
        this.dyg.setText(spannableString);
        this.dyg.setMovementMethod(LinkMovementMethod.getInstance());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.forumMember.tbtitle.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0181a extends ClickableSpan {
        private View.OnClickListener aDy;

        public C0181a(View.OnClickListener onClickListener) {
            this.aDy = onClickListener;
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            textPaint.setColor(al.getColor(e.d.cp_link_tip_a));
            textPaint.setUnderlineText(false);
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View view) {
            this.aDy.onClick(view);
        }
    }

    public void bA(List<LevelInfo> list) {
        this.dyj = list;
        if (this.dyd != null && this.dyj != null && this.dyj.size() != 0) {
            this.dyd.removeAllViews();
            for (int i = 1; i <= list.size(); i++) {
                LevelInfo levelInfo = list.get(i - 1);
                View inflate = LayoutInflater.from(this.dyc.getPageContext().getContext()).inflate(e.h.tbtitle_table_item, (ViewGroup) null);
                LinearLayout linearLayout = (LinearLayout) inflate.findViewById(e.g.table_item_background);
                TextView textView = (TextView) inflate.findViewById(e.g.table_item_level_name);
                TextView textView2 = (TextView) inflate.findViewById(e.g.table_item_need_experienment);
                View findViewById = inflate.findViewById(e.g.tbtile_item_horizontal_line);
                ImageView imageView = (ImageView) inflate.findViewById(e.g.table_item_level_img);
                if (i % 2 != 0) {
                    al.i(linearLayout, e.d.cp_bg_line_e);
                }
                al.c(textView, e.d.cp_cont_b, 1);
                al.c(textView2, e.d.cp_cont_b, 1);
                al.j(findViewById, e.d.cp_bg_line_b);
                al.c(imageView, BitmapHelper.getGradeResourceIdNew(levelInfo.id.intValue()));
                textView.setText(levelInfo.name);
                if (levelInfo.score.intValue() <= 3000000 && levelInfo.score.intValue() > 0) {
                    textView2.setText(levelInfo.score + "");
                } else if (levelInfo.score.intValue() <= 0) {
                    textView2.setText("0");
                } else {
                    textView2.setText("3000000");
                }
                this.dyd.addView(inflate);
            }
        }
    }

    public void a(DataRes dataRes) {
        this.dyk = dataRes;
        if (this.dyk != null) {
            if (this.dyk.is_like.intValue() == 1 && this.dyi != null) {
                this.dyi.setVisibility(8);
            }
            if (this.dye != null) {
                if (StringUtils.isNull(this.dyk.level_name, true)) {
                    this.dye.setText(this.dyk.level_name);
                } else {
                    this.dye.setVisibility(8);
                }
            }
            if (this.dyf != null) {
                if (this.dyk.user_level.intValue() <= 0 || this.dyk.user_level.intValue() > 18) {
                    this.dyf.setVisibility(8);
                } else {
                    al.c(this.dyf, BitmapHelper.getGradeResourceIdNew(this.dyk.user_level.intValue()));
                }
            }
        }
    }

    private void ayw() {
        this.dyh.setOnClickListener(this.dxX);
        this.dyg.setOnClickListener(this.dxX);
    }

    public void dH(int i) {
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(this.dyc.getPageContext(), i);
        }
        if (this.bJX != null) {
            this.bJX.onChangeSkinType(this.dyc.getPageContext(), i);
        }
        bA(this.dyj);
        a(this.dyk);
        this.dyc.getLayoutMode().setNightMode(i == 1);
        this.dyc.getLayoutMode().onModeChanged(this.mRootView);
    }

    public void nu(String str) {
        this.bDf.setVisibility(8);
        this.dyc.showNetRefreshView(this.mRootView, str, true);
        this.dyc.setNetRefreshViewTopMargin(400);
    }

    public void ayx() {
        this.bDf.setVisibility(0);
        this.dyc.hideNetRefreshView(this.mRootView);
    }

    public void showLoadingView() {
        this.bDf.setVisibility(8);
        this.dyc.showLoadingView(this.mRootView, true);
    }

    public void ayy() {
        this.bDf.setVisibility(0);
        this.dyc.hideLoadingView(this.mRootView);
    }

    public void h(NoNetworkView.a aVar) {
        if (aVar != null) {
            this.bJX.a(aVar);
        }
    }

    public void gc(boolean z) {
        if (!z) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.dmK.getLayoutParams();
            layoutParams.height = UtilHelper.getLightStatusBarHeight() + l.h(this.dyc.getActivity(), e.C0175e.ds170);
            this.dmK.setLayoutParams(layoutParams);
            return;
        }
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.dmK.getLayoutParams();
        layoutParams2.height = UtilHelper.getLightStatusBarHeight() + l.h(this.dyc.getActivity(), e.C0175e.ds88);
        this.dmK.setLayoutParams(layoutParams2);
    }
}
