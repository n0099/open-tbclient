package com.baidu.tieba.frs.gamesubpb.view;

import android.graphics.Rect;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.AbsListView;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.adp.widget.ListView.m;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PersonPolymericActivityConfig;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tbadk.util.aa;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.gamesubpb.FrsGameSubPbActivity;
import com.baidu.tieba.frs.gamesubpb.a;
import com.baidu.tieba.frs.gamesubpb.model.d;
import com.baidu.tieba.frs.gamesubpb.model.e;
import com.baidu.tieba.pb.a.c;
import com.compatible.menukey.MenuKeyUtils;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class a {
    private boolean YX;
    private View.OnClickListener ZX;
    private LinearLayout cHm;
    private c czv = new c(new c.a() { // from class: com.baidu.tieba.frs.gamesubpb.view.a.1
        @Override // com.baidu.tieba.pb.a.c.a
        public boolean onDoubleTap(View view, MotionEvent motionEvent) {
            a.this.kr(false);
            a.this.bT(view);
            a.this.kr(true);
            return true;
        }

        @Override // com.baidu.tieba.pb.a.c.a
        public boolean onDoubleTapEvent(View view, MotionEvent motionEvent) {
            return false;
        }

        @Override // com.baidu.tieba.pb.a.c.a
        public boolean onSingleTapConfirmed(View view, MotionEvent motionEvent) {
            return true;
        }
    });
    private long dAO;
    private ViewTreeObserver.OnGlobalLayoutListener dLS;
    private BdTypeListView dvB;
    private FrsGameSubPbActivity fKD;
    private e fKX;
    private FrameLayout fKY;
    private EditText fKZ;
    private com.baidu.tieba.frs.gamesubpb.c fKn;
    private String fKr;
    private TextView fLa;
    private TextView fLb;
    private TextView fLc;
    private com.baidu.tieba.frs.gamesubpb.b fLd;
    private com.baidu.tieba.frs.gamesubpb.model.b fLe;
    private List<m> fLf;
    private String fLg;
    private View flb;
    private boolean hasMore;
    private View mBack;
    private NavigationBar mNavigationBar;
    private ProgressBar mProgressBar;
    private RelativeLayout mRootView;

    public a(FrsGameSubPbActivity frsGameSubPbActivity, View.OnClickListener onClickListener, String str) {
        this.fKD = frsGameSubPbActivity;
        this.ZX = onClickListener;
        this.fKr = str;
        this.mRootView = (RelativeLayout) LayoutInflater.from(frsGameSubPbActivity.getPageContext().getPageActivity()).inflate(R.layout.frs_game_sub_pb_activity, (ViewGroup) null);
        this.dvB = (BdTypeListView) this.mRootView.findViewById(R.id.new_sub_pb_list);
        this.dvB.setOnTouchListener(this.czv);
        this.dvB.setOnScrollListener(new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.frs.gamesubpb.view.a.4
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
                if (i != 0) {
                    l.hideSoftKeyPad(a.this.fKD.getPageContext().getPageActivity(), a.this.fKZ);
                }
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            }
        });
        this.fKX = new e(this.fKD.getPageContext());
        this.flb = BdListViewHelper.a(this.fKD.getActivity(), this.dvB, BdListViewHelper.HeadType.DEFAULT);
        this.fLb = (TextView) this.mRootView.findViewById(R.id.subpb_editor_tool_comment_reply_text);
        this.fLb.setOnClickListener(this.ZX);
        this.fLc = (TextView) this.mRootView.findViewById(R.id.no_reply_list_view);
        this.fKY = (FrameLayout) this.mRootView.findViewById(R.id.bottom_view);
        this.cHm = (LinearLayout) this.mRootView.findViewById(R.id.subpb_editor_tool_comment_input_container);
        this.fKZ = (EditText) this.mRootView.findViewById(R.id.subpb_editor_tool_comment_input_edit);
        this.fLa = (TextView) this.mRootView.findViewById(R.id.subpb_editor_tool_comment_send_tv);
        this.fLa.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.gamesubpb.view.a.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.wa(a.this.fKZ.getText().toString());
            }
        });
        this.mProgressBar = (ProgressBar) this.mRootView.findViewById(R.id.progressBar);
        boi();
        this.fLd = new com.baidu.tieba.frs.gamesubpb.b(this.fKD.getPageContext(), this.dvB);
        this.fLd.setClickListener(new a.InterfaceC0414a() { // from class: com.baidu.tieba.frs.gamesubpb.view.a.6
            @Override // com.baidu.tieba.frs.gamesubpb.a.InterfaceC0414a
            public void a(d dVar) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonPolymericActivityConfig(a.this.fKD.getPageContext().getPageActivity()).createNormalConfig(Long.valueOf(dVar.userId).longValue(), String.valueOf(a.this.dAO).equals(dVar.userId), false)));
            }

            @Override // com.baidu.tieba.frs.gamesubpb.a.InterfaceC0414a
            public void b(d dVar) {
                if (dVar != null) {
                    a.this.d(dVar);
                }
            }

            @Override // com.baidu.tieba.frs.gamesubpb.a.InterfaceC0414a
            public void c(d dVar) {
                if (a.this.fKn != null) {
                    a.this.fKn.boa();
                }
                if (dVar == null) {
                    a.this.wb(null);
                    a.this.bok();
                    return;
                }
                a.this.wb(dVar.userName);
                a.this.fLg = dVar.userId;
            }
        });
        rl(140);
        boj();
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        this.fLf = new ArrayList();
        this.dAO = com.baidu.adp.lib.g.b.toLong(TbadkCoreApplication.getCurrentAccount(), 0L);
    }

    private void boi() {
        this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(R.id.view_navigation_bar);
        this.mBack = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        ImageView backImageView = this.mNavigationBar.getBackImageView();
        if (backImageView != null && (backImageView.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.mBack.getLayoutParams();
            int dimens = l.getDimens(this.fKD.getPageContext().getPageActivity(), R.dimen.ds30);
            layoutParams.height = dimens;
            layoutParams.width = dimens;
            backImageView.setLayoutParams(layoutParams);
        }
        if (this.mBack != null && (this.mBack.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.mBack.getLayoutParams();
            layoutParams2.width = -2;
            layoutParams2.height = -1;
            this.mBack.setPadding(l.getDimens(this.fKD.getPageContext().getPageActivity(), R.dimen.ds32), this.mBack.getPaddingTop(), this.mBack.getPaddingRight(), this.mBack.getPaddingBottom());
            this.mBack.setLayoutParams(layoutParams2);
        }
        if (this.mNavigationBar.getBackImageView() != null) {
            SvgManager.amN().a(this.mNavigationBar.getBackImageView(), R.drawable.icon_pure_topbar_return_n_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
    }

    private void boj() {
        this.dLS = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tieba.frs.gamesubpb.view.a.7
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                Rect rect = new Rect();
                a.this.fKD.getPageContext().getPageActivity().getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
                int statusBarHeight = l.getStatusBarHeight(a.this.fKD.getPageContext().getPageActivity());
                int[] screenDimensions = l.getScreenDimensions(a.this.fKD.getPageContext().getPageActivity());
                if (screenDimensions[1] - rect.bottom > screenDimensions[1] / 4 && !a.this.YX) {
                    a.this.YX = true;
                    a.this.onKeyboardVisibilityChanged(true);
                } else if (screenDimensions[1] - rect.height() == statusBarHeight && a.this.YX) {
                    a.this.YX = false;
                    a.this.onKeyboardVisibilityChanged(false);
                }
            }
        };
        this.fKD.getPageContext().getPageActivity().getWindow().getDecorView().getViewTreeObserver().addOnGlobalLayoutListener(this.dLS);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(final d dVar) {
        final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.fKD.getPageContext().getPageActivity());
        aVar.nm(null);
        aVar.hU(R.string.del_post_confirm);
        aVar.eh(true);
        aVar.a(R.string.dialog_ok, new a.b() { // from class: com.baidu.tieba.frs.gamesubpb.view.a.8
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar.dismiss();
                a.this.e(dVar);
            }
        });
        aVar.b(R.string.dialog_cancel, new a.b() { // from class: com.baidu.tieba.frs.gamesubpb.view.a.9
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar.dismiss();
            }
        });
        aVar.b(this.fKD.getPageContext()).akO();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(d dVar) {
        HttpMessage httpMessage = new HttpMessage(1003381);
        httpMessage.addParam("user_id", this.dAO);
        httpMessage.addParam("main_tower_id", dVar.fKT);
        httpMessage.addParam("id", dVar.id);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void wa(String str) {
        rm(0);
        HttpMessage httpMessage = new HttpMessage(1003380);
        httpMessage.addParam("user_id", this.dAO);
        httpMessage.addParam("reply_user_id", this.fLg);
        httpMessage.addParam("content", str);
        httpMessage.addParam("main_tower_id", this.fKr);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bok() {
        this.fLg = this.fLe != null ? this.fLe.userId : null;
    }

    private void bol() {
        if (!v.isEmpty(this.fLf)) {
            this.mNavigationBar.setCenterTextTitle(String.format(this.fKD.getResources().getString(R.string.subpb_floor_reply_count), aq.numFormatOver10000(this.fLf.size())));
        } else {
            this.mNavigationBar.setCenterTextTitle(this.fKD.getResources().getString(R.string.reply));
        }
    }

    private void rl(final int i) {
        this.fKZ.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.frs.gamesubpb.view.a.10
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                if (!TextUtils.isEmpty(charSequence)) {
                    a.this.fLa.setEnabled(true);
                    String charSequence2 = charSequence.toString();
                    if (!StringUtils.isNull(charSequence2) && aa.getTextLength(charSequence2) > i) {
                        String subString = aa.subString(charSequence2, 0, i - 1);
                        a.this.fKZ.setText(subString);
                        a.this.fKZ.setSelection(a.this.fKZ.getText().length());
                        UtilHelper.showToast(a.this.fKD.getPageContext().getPageActivity().getApplication(), a.this.fKD.getPageContext().getPageActivity().getResources().getString(R.string.edit_text_over_limit_tip, Integer.valueOf(subString.length())));
                        return;
                    }
                    return;
                }
                a.this.bok();
                a.this.fLa.setEnabled(false);
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
            }
        });
    }

    private void bom() {
        if (this.mNavigationBar.getBackImageView() != null) {
            SvgManager.amN().a(this.mNavigationBar.getBackImageView(), R.drawable.icon_pure_topbar_return_n_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void kr(final boolean z) {
        if (this.dvB != null) {
            if (!z) {
                this.dvB.setEnabled(z);
            } else {
                this.dvB.postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.gamesubpb.view.a.11
                    @Override // java.lang.Runnable
                    public void run() {
                        a.this.dvB.setEnabled(z);
                    }
                }, 10L);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onKeyboardVisibilityChanged(boolean z) {
        if (z) {
            Rect rect = new Rect();
            this.cHm.getWindowVisibleDisplayFrame(rect);
            this.fKY.scrollTo(this.fKY.getScrollX(), (l.getScreenDimensions(this.fKD.getPageContext().getPageActivity())[1] - rect.bottom) - (MenuKeyUtils.hasSmartBar() ? l.dip2px(this.fKD.getPageContext().getPageActivity(), 48.0f) : 0));
            return;
        }
        this.fKY.setScrollY(0);
    }

    private void ks(boolean z) {
        if (v.isEmpty(this.fLf)) {
            this.dvB.setNextPage(null);
            this.fLc.setVisibility(0);
        } else {
            this.dvB.setNextPage(this.fKX);
            this.fLc.setVisibility(8);
            if (z) {
                this.fKX.startLoadData();
            } else {
                this.fKX.endLoadData();
            }
        }
        bol();
    }

    public void a(boolean z, com.baidu.tieba.frs.gamesubpb.model.b bVar, List<m> list) {
        this.hasMore = z;
        this.fLe = bVar;
        bok();
        if (v.isEmpty(list)) {
            ks(z);
            return;
        }
        this.fLf.clear();
        this.fLf.addAll(list);
        this.fLc.setVisibility(8);
        this.dvB.setNextPage(this.fKX);
        this.fLd.setData(list);
        bom();
        this.fLb.setVisibility(0);
        this.fLb.setText(R.string.say_your_point);
        ks(z);
    }

    public void a(boolean z, String str, d dVar) {
        rm(8);
        if (z && dVar != null) {
            BdToast.b(this.fKD.getPageContext().getPageActivity(), this.fKD.getPageContext().getString(R.string.subpb_add_comment_succ_tip), 1).akT();
            this.fKZ.setText((CharSequence) null);
            this.fLf.add(dVar);
            this.fLd.setData(this.fLf);
            ks(this.hasMore);
            this.fKZ.post(new Runnable() { // from class: com.baidu.tieba.frs.gamesubpb.view.a.2
                @Override // java.lang.Runnable
                public void run() {
                    a.this.fKZ.requestFocus();
                    l.hideSoftKeyPad(a.this.fKD.getPageContext().getPageActivity(), a.this.fKZ);
                }
            });
            return;
        }
        if (TextUtils.isEmpty(str)) {
            str = this.fKD.getPageContext().getString(R.string.subpb_add_comment_fail_tip);
        }
        BdToast.b(this.fKD.getPageContext().getPageActivity(), str, 1).akT();
    }

    public void b(boolean z, String str, d dVar) {
        if (z) {
            BdToast.b(this.fKD.getPageContext().getPageActivity(), this.fKD.getPageContext().getString(R.string.subpb_delete_comment_succ_tip), 1).akT();
            this.fLf.remove(dVar);
            this.fLd.setData(this.fLf);
            ks(this.hasMore);
            return;
        }
        if (TextUtils.isEmpty(str)) {
            str = this.fKD.getPageContext().getString(R.string.subpb_delete_comment_fail_tip);
        }
        BdToast.b(this.fKD.getPageContext().getPageActivity(), str, 1).akT();
    }

    public void kt(boolean z) {
        if (this.flb != null && this.flb.getLayoutParams() != null) {
            ViewGroup.LayoutParams layoutParams = this.flb.getLayoutParams();
            if (z) {
                bom();
                layoutParams.height = l.getDimens(this.fKD.getPageContext().getPageActivity(), R.dimen.ds98);
            } else {
                layoutParams.height = l.getDimens(this.fKD.getPageContext().getPageActivity(), R.dimen.ds98) + UtilHelper.getLightStatusBarHeight();
            }
            this.flb.setLayoutParams(layoutParams);
        }
    }

    public void bT(View view) {
        if (this.flb != null && this.mNavigationBar != null) {
            if (this.mNavigationBar.isNavigationBarExcludeStatusbarVisible()) {
                this.mNavigationBar.showNavigationBarExcludeStatusbar(false);
                if (UtilHelper.canUseStyleImmersiveSticky()) {
                    this.flb.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight()));
                } else if (this.dvB != null) {
                    this.dvB.removeHeaderView(this.flb);
                }
                this.mNavigationBar.setVisibility(8);
                return;
            }
            this.mNavigationBar.showNavigationBarExcludeStatusbar(true);
            if (UtilHelper.canUseStyleImmersiveSticky()) {
                this.flb.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + l.getDimens(this.fKD.getActivity(), R.dimen.ds98)));
            } else if (this.dvB != null) {
                this.dvB.addHeaderView(this.flb, 0);
            }
            this.mNavigationBar.setVisibility(0);
        }
    }

    public void wb(String str) {
        this.fLb.setVisibility(8);
        this.cHm.setVisibility(0);
        this.fKZ.post(new Runnable() { // from class: com.baidu.tieba.frs.gamesubpb.view.a.3
            @Override // java.lang.Runnable
            public void run() {
                a.this.fKZ.requestFocus();
                l.showSoftKeyPad(a.this.fKD.getPageContext().getPageActivity(), a.this.fKZ);
            }
        });
        if (!TextUtils.isEmpty(str)) {
            String format = String.format(this.fKD.getPageContext().getPageActivity().getResources().getString(R.string.reply_sub_floor), str);
            this.fKZ.setText(format);
            this.fKZ.setSelection(format.length());
        }
    }

    public void rm(int i) {
        this.mProgressBar.setVisibility(i);
    }

    public View beD() {
        return this.flb;
    }

    public View getRootView() {
        return this.mRootView;
    }

    public ListView getListView() {
        return this.dvB;
    }

    public TextView bon() {
        return this.fLb;
    }

    public NavigationBar aKR() {
        return this.mNavigationBar;
    }

    public void e(com.baidu.tieba.frs.gamesubpb.c cVar) {
        this.fKn = cVar;
    }

    public void b(BdListView.e eVar) {
        this.dvB.setOnSrollToBottomListener(eVar);
    }

    public void onChangeSkinType(int i) {
        this.fKD.getLayoutMode().setNightMode(i == 1);
        this.fKD.getLayoutMode().onModeChanged(this.mRootView);
        am.setBackgroundColor(this.mRootView, R.color.cp_bg_line_d);
        this.mNavigationBar.onChangeSkinType(this.fKD.getPageContext(), i);
        this.fKX.changeSkin(i);
        am.setViewTextColor(this.fLb, (int) R.color.cp_cont_e);
        this.fLb.setAlpha(0.95f);
        am.setBackgroundResource(this.fLb, R.drawable.pb_ecomm_comment_bg);
        am.setViewTextColor(this.fLc, (int) R.color.cp_cont_d);
        am.setBackgroundResource(this.cHm, R.drawable.pb_ecomm_comment_bg);
        am.setViewTextColor(this.fKZ, (int) R.color.cp_cont_f);
        this.fKZ.setHintTextColor(am.getColor(R.color.cp_cont_e));
        am.setViewTextColor(this.fLa, (int) R.color.game_sub_pb_send_txt_color);
    }

    public void onDestroy() {
        if (this.dLS != null) {
            this.fKD.getPageContext().getPageActivity().getWindow().getDecorView().getViewTreeObserver().removeGlobalOnLayoutListener(this.dLS);
        }
    }
}
