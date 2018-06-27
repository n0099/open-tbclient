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
import com.baidu.adp.widget.ListView.h;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PersonPolymericActivityConfig;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.w;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tbadk.util.x;
import com.baidu.tieba.d;
import com.baidu.tieba.frs.gamesubpb.FrsGameSubPbActivity;
import com.baidu.tieba.frs.gamesubpb.a;
import com.baidu.tieba.frs.gamesubpb.model.e;
import com.baidu.tieba.pb.a.c;
import com.compatible.menukey.MenuKeyUtils;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class a {
    private View aBf;
    private LinearLayout aOk;
    private c bfS = new c(new c.a() { // from class: com.baidu.tieba.frs.gamesubpb.view.a.1
        @Override // com.baidu.tieba.pb.a.c.a
        public boolean a(View view, MotionEvent motionEvent) {
            a.this.gb(false);
            a.this.ax(view);
            a.this.gb(true);
            return true;
        }

        @Override // com.baidu.tieba.pb.a.c.a
        public boolean b(View view, MotionEvent motionEvent) {
            return false;
        }

        @Override // com.baidu.tieba.pb.a.c.a
        public boolean c(View view, MotionEvent motionEvent) {
            return true;
        }
    });
    private long bvG;
    private View cVX;
    private FrsGameSubPbActivity dxD;
    private e dxX;
    private FrameLayout dxY;
    private EditText dxZ;
    private com.baidu.tieba.frs.gamesubpb.c dxn;
    private String dxr;
    private TextView dya;
    private TextView dyb;
    private TextView dyc;
    private com.baidu.tieba.frs.gamesubpb.b dyd;
    private com.baidu.tieba.frs.gamesubpb.model.b dye;
    private List<h> dyf;
    private String dyg;
    private ViewTreeObserver.OnGlobalLayoutListener globalListener;
    private boolean hasMore;
    private View.OnClickListener mCommonClickListener;
    private boolean mIsKeyboardOpen;
    private BdTypeListView mListView;
    private NavigationBar mNavigationBar;
    private ProgressBar mProgressBar;
    private RelativeLayout mRootView;

    public a(FrsGameSubPbActivity frsGameSubPbActivity, View.OnClickListener onClickListener, String str) {
        this.dxD = frsGameSubPbActivity;
        this.mCommonClickListener = onClickListener;
        this.dxr = str;
        this.mRootView = (RelativeLayout) LayoutInflater.from(frsGameSubPbActivity.getPageContext().getPageActivity()).inflate(d.i.frs_game_sub_pb_activity, (ViewGroup) null);
        this.mListView = (BdTypeListView) this.mRootView.findViewById(d.g.new_sub_pb_list);
        this.mListView.setOnTouchListener(this.bfS);
        this.mListView.setOnScrollListener(new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.frs.gamesubpb.view.a.4
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
                if (i != 0) {
                    l.b(a.this.dxD.getPageContext().getPageActivity(), a.this.dxZ);
                }
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            }
        });
        this.dxX = new e(this.dxD.getPageContext());
        this.cVX = BdListViewHelper.a(this.dxD.getActivity(), this.mListView, BdListViewHelper.HeadType.DEFAULT);
        this.dyb = (TextView) this.mRootView.findViewById(d.g.subpb_editor_tool_comment_reply_text);
        this.dyb.setOnClickListener(this.mCommonClickListener);
        this.dyc = (TextView) this.mRootView.findViewById(d.g.no_reply_list_view);
        this.dxY = (FrameLayout) this.mRootView.findViewById(d.g.bottom_view);
        this.aOk = (LinearLayout) this.mRootView.findViewById(d.g.subpb_editor_tool_comment_input_container);
        this.dxZ = (EditText) this.mRootView.findViewById(d.g.subpb_editor_tool_comment_input_edit);
        this.dya = (TextView) this.mRootView.findViewById(d.g.subpb_editor_tool_comment_send_tv);
        this.dya.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.gamesubpb.view.a.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.mI(a.this.dxZ.getText().toString());
            }
        });
        this.mProgressBar = (ProgressBar) this.mRootView.findViewById(d.g.progressBar);
        axQ();
        this.dyd = new com.baidu.tieba.frs.gamesubpb.b(this.dxD.getPageContext(), this.mListView);
        this.dyd.setClickListener(new a.InterfaceC0157a() { // from class: com.baidu.tieba.frs.gamesubpb.view.a.6
            @Override // com.baidu.tieba.frs.gamesubpb.a.InterfaceC0157a
            public void a(com.baidu.tieba.frs.gamesubpb.model.d dVar) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonPolymericActivityConfig(a.this.dxD.getPageContext().getPageActivity()).createNormalConfig(Long.valueOf(dVar.userId).longValue(), String.valueOf(a.this.bvG).equals(dVar.userId), false)));
            }

            @Override // com.baidu.tieba.frs.gamesubpb.a.InterfaceC0157a
            public void b(com.baidu.tieba.frs.gamesubpb.model.d dVar) {
                if (dVar != null) {
                    a.this.d(dVar);
                }
            }

            @Override // com.baidu.tieba.frs.gamesubpb.a.InterfaceC0157a
            public void c(com.baidu.tieba.frs.gamesubpb.model.d dVar) {
                if (a.this.dxn != null) {
                    a.this.dxn.axI();
                }
                if (dVar == null) {
                    a.this.mJ(null);
                    a.this.axS();
                    return;
                }
                a.this.mJ(dVar.userName);
                a.this.dyg = dVar.userId;
            }
        });
        kX(140);
        axR();
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        this.dyf = new ArrayList();
        this.bvG = com.baidu.adp.lib.g.b.c(TbadkCoreApplication.getCurrentAccount(), 0L);
    }

    private void axQ() {
        this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(d.g.view_navigation_bar);
        this.aBf = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        ImageView backImageView = this.mNavigationBar.getBackImageView();
        if (backImageView != null && (backImageView.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.aBf.getLayoutParams();
            int e = l.e(this.dxD.getPageContext().getPageActivity(), d.e.ds30);
            layoutParams.height = e;
            layoutParams.width = e;
            backImageView.setLayoutParams(layoutParams);
        }
        if (this.aBf != null && (this.aBf.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.aBf.getLayoutParams();
            layoutParams2.width = -2;
            layoutParams2.height = -1;
            this.aBf.setPadding(l.e(this.dxD.getPageContext().getPageActivity(), d.e.ds32), this.aBf.getPaddingTop(), this.aBf.getPaddingRight(), this.aBf.getPaddingBottom());
            this.aBf.setLayoutParams(layoutParams2);
        }
        this.mNavigationBar.setmBackImageViewBg(d.f.subpb_navigationbar_back, d.f.subpb_navigationbar_back);
    }

    private void axR() {
        this.globalListener = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tieba.frs.gamesubpb.view.a.7
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                Rect rect = new Rect();
                a.this.dxD.getPageContext().getPageActivity().getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
                int o = l.o(a.this.dxD.getPageContext().getPageActivity());
                int[] al = l.al(a.this.dxD.getPageContext().getPageActivity());
                if (al[1] - rect.bottom > al[1] / 4 && !a.this.mIsKeyboardOpen) {
                    a.this.mIsKeyboardOpen = true;
                    a.this.onKeyboardVisibilityChanged(true);
                } else if (al[1] - rect.height() == o && a.this.mIsKeyboardOpen) {
                    a.this.mIsKeyboardOpen = false;
                    a.this.onKeyboardVisibilityChanged(false);
                }
            }
        };
        this.dxD.getPageContext().getPageActivity().getWindow().getDecorView().getViewTreeObserver().addOnGlobalLayoutListener(this.globalListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(final com.baidu.tieba.frs.gamesubpb.model.d dVar) {
        final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.dxD.getPageContext().getPageActivity());
        aVar.dD(null);
        aVar.cd(d.k.del_post_confirm);
        aVar.ax(true);
        aVar.a(d.k.dialog_ok, new a.b() { // from class: com.baidu.tieba.frs.gamesubpb.view.a.8
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar.dismiss();
                a.this.e(dVar);
            }
        });
        aVar.b(d.k.dialog_cancel, new a.b() { // from class: com.baidu.tieba.frs.gamesubpb.view.a.9
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar.dismiss();
            }
        });
        aVar.b(this.dxD.getPageContext()).xn();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(com.baidu.tieba.frs.gamesubpb.model.d dVar) {
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_DELETE_SUB_COMMENT);
        httpMessage.addParam("user_id", this.bvG);
        httpMessage.addParam("main_tower_id", dVar.dxT);
        httpMessage.addParam("id", dVar.id);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mI(String str) {
        kY(0);
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_ADD_SUB_COMMENT);
        httpMessage.addParam("user_id", this.bvG);
        httpMessage.addParam("reply_user_id", this.dyg);
        httpMessage.addParam("content", str);
        httpMessage.addParam("main_tower_id", this.dxr);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void axS() {
        this.dyg = this.dye != null ? this.dye.userId : null;
    }

    private void axT() {
        if (!w.A(this.dyf)) {
            this.mNavigationBar.setCenterTextTitle(String.format(this.dxD.getResources().getString(d.k.subpb_floor_reply_count), ap.D(this.dyf.size())));
        } else {
            this.mNavigationBar.setCenterTextTitle(this.dxD.getResources().getString(d.k.reply));
        }
    }

    private void kX(final int i) {
        this.dxZ.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.frs.gamesubpb.view.a.10
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                if (!TextUtils.isEmpty(charSequence)) {
                    a.this.dya.setEnabled(true);
                    String charSequence2 = charSequence.toString();
                    if (!StringUtils.isNull(charSequence2) && x.hK(charSequence2) > i) {
                        String k = x.k(charSequence2, 0, i - 1);
                        a.this.dxZ.setText(k);
                        a.this.dxZ.setSelection(a.this.dxZ.getText().length());
                        UtilHelper.showToast(a.this.dxD.getPageContext().getPageActivity().getApplication(), a.this.dxD.getPageContext().getPageActivity().getResources().getString(d.k.edit_text_over_limit_tip, Integer.valueOf(k.length())));
                        return;
                    }
                    return;
                }
                a.this.axS();
                a.this.dya.setEnabled(false);
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
            }
        });
    }

    private void axU() {
        this.mNavigationBar.setmBackImageViewBg(d.f.subpb_navigationbar_close, d.f.subpb_navigationbar_close);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gb(final boolean z) {
        if (this.mListView != null) {
            if (!z) {
                this.mListView.setEnabled(z);
            } else {
                this.mListView.postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.gamesubpb.view.a.11
                    @Override // java.lang.Runnable
                    public void run() {
                        a.this.mListView.setEnabled(z);
                    }
                }, 10L);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onKeyboardVisibilityChanged(boolean z) {
        if (z) {
            Rect rect = new Rect();
            this.aOk.getWindowVisibleDisplayFrame(rect);
            this.dxY.scrollTo(this.dxY.getScrollX(), (l.al(this.dxD.getPageContext().getPageActivity())[1] - rect.bottom) - (MenuKeyUtils.hasSmartBar() ? l.dip2px(this.dxD.getPageContext().getPageActivity(), 48.0f) : 0));
            return;
        }
        this.dxY.setScrollY(0);
    }

    private void gc(boolean z) {
        if (w.A(this.dyf)) {
            this.mListView.setNextPage(null);
            this.dyc.setVisibility(0);
        } else {
            this.mListView.setNextPage(this.dxX);
            this.dyc.setVisibility(8);
            if (z) {
                this.dxX.AH();
            } else {
                this.dxX.AI();
            }
        }
        axT();
    }

    public void a(boolean z, com.baidu.tieba.frs.gamesubpb.model.b bVar, List<h> list) {
        this.hasMore = z;
        this.dye = bVar;
        axS();
        if (w.A(list)) {
            gc(z);
            return;
        }
        this.dyf.clear();
        this.dyf.addAll(list);
        this.dyc.setVisibility(8);
        this.mListView.setNextPage(this.dxX);
        this.dyd.setData(list);
        axU();
        this.dyb.setVisibility(0);
        this.dyb.setText(d.k.say_your_point);
        gc(z);
    }

    public void a(boolean z, String str, com.baidu.tieba.frs.gamesubpb.model.d dVar) {
        kY(8);
        if (z && dVar != null) {
            BdToast.a(this.dxD.getPageContext().getPageActivity(), this.dxD.getPageContext().getString(d.k.subpb_add_comment_succ_tip), 1).xv();
            this.dxZ.setText((CharSequence) null);
            this.dyf.add(dVar);
            this.dyd.setData(this.dyf);
            gc(this.hasMore);
            this.dxZ.post(new Runnable() { // from class: com.baidu.tieba.frs.gamesubpb.view.a.2
                @Override // java.lang.Runnable
                public void run() {
                    a.this.dxZ.requestFocus();
                    l.b(a.this.dxD.getPageContext().getPageActivity(), a.this.dxZ);
                }
            });
            return;
        }
        if (TextUtils.isEmpty(str)) {
            str = this.dxD.getPageContext().getString(d.k.subpb_add_comment_fail_tip);
        }
        BdToast.a(this.dxD.getPageContext().getPageActivity(), str, 1).xv();
    }

    public void b(boolean z, String str, com.baidu.tieba.frs.gamesubpb.model.d dVar) {
        if (z) {
            BdToast.a(this.dxD.getPageContext().getPageActivity(), this.dxD.getPageContext().getString(d.k.subpb_delete_comment_succ_tip), 1).xv();
            this.dyf.remove(dVar);
            this.dyd.setData(this.dyf);
            gc(this.hasMore);
            return;
        }
        if (TextUtils.isEmpty(str)) {
            str = this.dxD.getPageContext().getString(d.k.subpb_delete_comment_fail_tip);
        }
        BdToast.a(this.dxD.getPageContext().getPageActivity(), str, 1).xv();
    }

    public void gd(boolean z) {
        if (this.cVX != null && this.cVX.getLayoutParams() != null) {
            ViewGroup.LayoutParams layoutParams = this.cVX.getLayoutParams();
            if (z) {
                axU();
                layoutParams.height = l.e(this.dxD.getPageContext().getPageActivity(), d.e.ds98);
            } else {
                layoutParams.height = l.e(this.dxD.getPageContext().getPageActivity(), d.e.ds98) + UtilHelper.getLightStatusBarHeight();
            }
            this.cVX.setLayoutParams(layoutParams);
        }
    }

    public void ax(View view) {
        if (this.cVX != null && this.mNavigationBar != null) {
            if (this.mNavigationBar.isNavigationBarExcludeStatusbarVisible()) {
                this.mNavigationBar.showNavigationBarExcludeStatusbar(false);
                if (UtilHelper.canUseStyleImmersiveSticky()) {
                    this.cVX.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight()));
                } else if (this.mListView != null) {
                    this.mListView.removeHeaderView(this.cVX);
                }
                this.mNavigationBar.setVisibility(8);
                return;
            }
            this.mNavigationBar.showNavigationBarExcludeStatusbar(true);
            if (UtilHelper.canUseStyleImmersiveSticky()) {
                this.cVX.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + l.e(this.dxD.getActivity(), d.e.ds98)));
            } else if (this.mListView != null) {
                this.mListView.addHeaderView(this.cVX, 0);
            }
            this.mNavigationBar.setVisibility(0);
        }
    }

    public void mJ(String str) {
        this.dyb.setVisibility(8);
        this.aOk.setVisibility(0);
        this.dxZ.post(new Runnable() { // from class: com.baidu.tieba.frs.gamesubpb.view.a.3
            @Override // java.lang.Runnable
            public void run() {
                a.this.dxZ.requestFocus();
                l.c(a.this.dxD.getPageContext().getPageActivity(), a.this.dxZ);
            }
        });
        if (!TextUtils.isEmpty(str)) {
            String format = String.format(this.dxD.getPageContext().getPageActivity().getResources().getString(d.k.reply_sub_floor), str);
            this.dxZ.setText(format);
            this.dxZ.setSelection(format.length());
        }
    }

    public void kY(int i) {
        this.mProgressBar.setVisibility(i);
    }

    public View axV() {
        return this.cVX;
    }

    public View getRootView() {
        return this.mRootView;
    }

    public ListView getListView() {
        return this.mListView;
    }

    public TextView axW() {
        return this.dyb;
    }

    public NavigationBar UW() {
        return this.mNavigationBar;
    }

    public void e(com.baidu.tieba.frs.gamesubpb.c cVar) {
        this.dxn = cVar;
    }

    public void a(BdListView.e eVar) {
        this.mListView.setOnSrollToBottomListener(eVar);
    }

    public void onChangeSkinType(int i) {
        this.dxD.getLayoutMode().setNightMode(i == 1);
        this.dxD.getLayoutMode().onModeChanged(this.mRootView);
        am.j(this.mRootView, d.C0142d.cp_bg_line_d);
        this.mNavigationBar.onChangeSkinType(this.dxD.getPageContext(), i);
        this.dxX.dz(i);
        am.h(this.dyb, d.C0142d.cp_cont_e);
        this.dyb.setAlpha(0.95f);
        am.i(this.dyb, d.f.pb_ecomm_comment_bg);
        am.h(this.dyc, d.C0142d.cp_cont_d);
        am.i(this.aOk, d.f.pb_ecomm_comment_bg);
        am.h(this.dxZ, d.C0142d.cp_cont_f);
        this.dxZ.setHintTextColor(am.getColor(d.C0142d.cp_cont_e));
        am.h(this.dya, d.C0142d.game_sub_pb_send_txt_color);
    }

    public void onDestroy() {
        if (this.globalListener != null) {
            this.dxD.getPageContext().getPageActivity().getWindow().getDecorView().getViewTreeObserver().removeGlobalOnLayoutListener(this.globalListener);
        }
    }
}
