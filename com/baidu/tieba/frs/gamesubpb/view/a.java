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
    private View aAZ;
    private LinearLayout aOj;
    private c bge = new c(new c.a() { // from class: com.baidu.tieba.frs.gamesubpb.view.a.1
        @Override // com.baidu.tieba.pb.a.c.a
        public boolean a(View view, MotionEvent motionEvent) {
            a.this.gd(false);
            a.this.aA(view);
            a.this.gd(true);
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
    private long bwm;
    private View cYM;
    private e dAJ;
    private FrameLayout dAK;
    private EditText dAL;
    private TextView dAM;
    private TextView dAN;
    private TextView dAO;
    private com.baidu.tieba.frs.gamesubpb.b dAP;
    private com.baidu.tieba.frs.gamesubpb.model.b dAQ;
    private List<h> dAR;
    private String dAS;
    private String dAd;
    private FrsGameSubPbActivity dAp;
    private com.baidu.tieba.frs.gamesubpb.c dzZ;
    private ViewTreeObserver.OnGlobalLayoutListener globalListener;
    private boolean hasMore;
    private View.OnClickListener mCommonClickListener;
    private boolean mIsKeyboardOpen;
    private BdTypeListView mListView;
    private NavigationBar mNavigationBar;
    private ProgressBar mProgressBar;
    private RelativeLayout mRootView;

    public a(FrsGameSubPbActivity frsGameSubPbActivity, View.OnClickListener onClickListener, String str) {
        this.dAp = frsGameSubPbActivity;
        this.mCommonClickListener = onClickListener;
        this.dAd = str;
        this.mRootView = (RelativeLayout) LayoutInflater.from(frsGameSubPbActivity.getPageContext().getPageActivity()).inflate(d.h.frs_game_sub_pb_activity, (ViewGroup) null);
        this.mListView = (BdTypeListView) this.mRootView.findViewById(d.g.new_sub_pb_list);
        this.mListView.setOnTouchListener(this.bge);
        this.mListView.setOnScrollListener(new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.frs.gamesubpb.view.a.4
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
                if (i != 0) {
                    l.a(a.this.dAp.getPageContext().getPageActivity(), a.this.dAL);
                }
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            }
        });
        this.dAJ = new e(this.dAp.getPageContext());
        this.cYM = BdListViewHelper.a(this.dAp.getActivity(), this.mListView, BdListViewHelper.HeadType.DEFAULT);
        this.dAN = (TextView) this.mRootView.findViewById(d.g.subpb_editor_tool_comment_reply_text);
        this.dAN.setOnClickListener(this.mCommonClickListener);
        this.dAO = (TextView) this.mRootView.findViewById(d.g.no_reply_list_view);
        this.dAK = (FrameLayout) this.mRootView.findViewById(d.g.bottom_view);
        this.aOj = (LinearLayout) this.mRootView.findViewById(d.g.subpb_editor_tool_comment_input_container);
        this.dAL = (EditText) this.mRootView.findViewById(d.g.subpb_editor_tool_comment_input_edit);
        this.dAM = (TextView) this.mRootView.findViewById(d.g.subpb_editor_tool_comment_send_tv);
        this.dAM.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.gamesubpb.view.a.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.mH(a.this.dAL.getText().toString());
            }
        });
        this.mProgressBar = (ProgressBar) this.mRootView.findViewById(d.g.progressBar);
        ayv();
        this.dAP = new com.baidu.tieba.frs.gamesubpb.b(this.dAp.getPageContext(), this.mListView);
        this.dAP.setClickListener(new a.InterfaceC0155a() { // from class: com.baidu.tieba.frs.gamesubpb.view.a.6
            @Override // com.baidu.tieba.frs.gamesubpb.a.InterfaceC0155a
            public void a(com.baidu.tieba.frs.gamesubpb.model.d dVar) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonPolymericActivityConfig(a.this.dAp.getPageContext().getPageActivity()).createNormalConfig(Long.valueOf(dVar.userId).longValue(), String.valueOf(a.this.bwm).equals(dVar.userId), false)));
            }

            @Override // com.baidu.tieba.frs.gamesubpb.a.InterfaceC0155a
            public void b(com.baidu.tieba.frs.gamesubpb.model.d dVar) {
                if (dVar != null) {
                    a.this.d(dVar);
                }
            }

            @Override // com.baidu.tieba.frs.gamesubpb.a.InterfaceC0155a
            public void c(com.baidu.tieba.frs.gamesubpb.model.d dVar) {
                if (a.this.dzZ != null) {
                    a.this.dzZ.ayn();
                }
                if (dVar == null) {
                    a.this.mI(null);
                    a.this.ayx();
                    return;
                }
                a.this.mI(dVar.userName);
                a.this.dAS = dVar.userId;
            }
        });
        li(140);
        ayw();
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        this.dAR = new ArrayList();
        this.bwm = com.baidu.adp.lib.g.b.c(TbadkCoreApplication.getCurrentAccount(), 0L);
    }

    private void ayv() {
        this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(d.g.view_navigation_bar);
        this.aAZ = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        ImageView backImageView = this.mNavigationBar.getBackImageView();
        if (backImageView != null && (backImageView.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.aAZ.getLayoutParams();
            int f = l.f(this.dAp.getPageContext().getPageActivity(), d.e.ds30);
            layoutParams.height = f;
            layoutParams.width = f;
            backImageView.setLayoutParams(layoutParams);
        }
        if (this.aAZ != null && (this.aAZ.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.aAZ.getLayoutParams();
            layoutParams2.width = -2;
            layoutParams2.height = -1;
            this.aAZ.setPadding(l.f(this.dAp.getPageContext().getPageActivity(), d.e.ds32), this.aAZ.getPaddingTop(), this.aAZ.getPaddingRight(), this.aAZ.getPaddingBottom());
            this.aAZ.setLayoutParams(layoutParams2);
        }
        this.mNavigationBar.setmBackImageViewBg(d.f.subpb_navigationbar_back, d.f.subpb_navigationbar_back);
    }

    private void ayw() {
        this.globalListener = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tieba.frs.gamesubpb.view.a.7
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                Rect rect = new Rect();
                a.this.dAp.getPageContext().getPageActivity().getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
                int o = l.o(a.this.dAp.getPageContext().getPageActivity());
                int[] al = l.al(a.this.dAp.getPageContext().getPageActivity());
                if (al[1] - rect.bottom > al[1] / 4 && !a.this.mIsKeyboardOpen) {
                    a.this.mIsKeyboardOpen = true;
                    a.this.onKeyboardVisibilityChanged(true);
                } else if (al[1] - rect.height() == o && a.this.mIsKeyboardOpen) {
                    a.this.mIsKeyboardOpen = false;
                    a.this.onKeyboardVisibilityChanged(false);
                }
            }
        };
        this.dAp.getPageContext().getPageActivity().getWindow().getDecorView().getViewTreeObserver().addOnGlobalLayoutListener(this.globalListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(final com.baidu.tieba.frs.gamesubpb.model.d dVar) {
        final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.dAp.getPageContext().getPageActivity());
        aVar.dA(null);
        aVar.cf(d.j.del_post_confirm);
        aVar.av(true);
        aVar.a(d.j.dialog_ok, new a.b() { // from class: com.baidu.tieba.frs.gamesubpb.view.a.8
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar.dismiss();
                a.this.e(dVar);
            }
        });
        aVar.b(d.j.dialog_cancel, new a.b() { // from class: com.baidu.tieba.frs.gamesubpb.view.a.9
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar.dismiss();
            }
        });
        aVar.b(this.dAp.getPageContext()).xf();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(com.baidu.tieba.frs.gamesubpb.model.d dVar) {
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_DELETE_SUB_COMMENT);
        httpMessage.addParam("user_id", this.bwm);
        httpMessage.addParam("main_tower_id", dVar.dAF);
        httpMessage.addParam("id", dVar.id);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mH(String str) {
        lj(0);
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_ADD_SUB_COMMENT);
        httpMessage.addParam("user_id", this.bwm);
        httpMessage.addParam("reply_user_id", this.dAS);
        httpMessage.addParam("content", str);
        httpMessage.addParam("main_tower_id", this.dAd);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ayx() {
        this.dAS = this.dAQ != null ? this.dAQ.userId : null;
    }

    private void ayy() {
        if (!w.z(this.dAR)) {
            this.mNavigationBar.setCenterTextTitle(String.format(this.dAp.getResources().getString(d.j.subpb_floor_reply_count), ap.F(this.dAR.size())));
        } else {
            this.mNavigationBar.setCenterTextTitle(this.dAp.getResources().getString(d.j.reply));
        }
    }

    private void li(final int i) {
        this.dAL.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.frs.gamesubpb.view.a.10
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                if (!TextUtils.isEmpty(charSequence)) {
                    a.this.dAM.setEnabled(true);
                    String charSequence2 = charSequence.toString();
                    if (!StringUtils.isNull(charSequence2) && com.baidu.tbadk.util.w.hH(charSequence2) > i) {
                        String k = com.baidu.tbadk.util.w.k(charSequence2, 0, i - 1);
                        a.this.dAL.setText(k);
                        a.this.dAL.setSelection(a.this.dAL.getText().length());
                        UtilHelper.showToast(a.this.dAp.getPageContext().getPageActivity().getApplication(), a.this.dAp.getPageContext().getPageActivity().getResources().getString(d.j.edit_text_over_limit_tip, Integer.valueOf(k.length())));
                        return;
                    }
                    return;
                }
                a.this.ayx();
                a.this.dAM.setEnabled(false);
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
            }
        });
    }

    private void ayz() {
        this.mNavigationBar.setmBackImageViewBg(d.f.subpb_navigationbar_close, d.f.subpb_navigationbar_close);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gd(final boolean z) {
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
            this.aOj.getWindowVisibleDisplayFrame(rect);
            this.dAK.scrollTo(this.dAK.getScrollX(), (l.al(this.dAp.getPageContext().getPageActivity())[1] - rect.bottom) - (MenuKeyUtils.hasSmartBar() ? l.dip2px(this.dAp.getPageContext().getPageActivity(), 48.0f) : 0));
            return;
        }
        this.dAK.setScrollY(0);
    }

    private void ge(boolean z) {
        if (w.z(this.dAR)) {
            this.mListView.setNextPage(null);
            this.dAO.setVisibility(0);
        } else {
            this.mListView.setNextPage(this.dAJ);
            this.dAO.setVisibility(8);
            if (z) {
                this.dAJ.Ax();
            } else {
                this.dAJ.Ay();
            }
        }
        ayy();
    }

    public void a(boolean z, com.baidu.tieba.frs.gamesubpb.model.b bVar, List<h> list) {
        this.hasMore = z;
        this.dAQ = bVar;
        ayx();
        if (w.z(list)) {
            ge(z);
            return;
        }
        this.dAR.clear();
        this.dAR.addAll(list);
        this.dAO.setVisibility(8);
        this.mListView.setNextPage(this.dAJ);
        this.dAP.setData(list);
        ayz();
        this.dAN.setVisibility(0);
        this.dAN.setText(d.j.say_your_point);
        ge(z);
    }

    public void a(boolean z, String str, com.baidu.tieba.frs.gamesubpb.model.d dVar) {
        lj(8);
        if (z && dVar != null) {
            BdToast.a(this.dAp.getPageContext().getPageActivity(), this.dAp.getPageContext().getString(d.j.subpb_add_comment_succ_tip), 1).xn();
            this.dAL.setText((CharSequence) null);
            this.dAR.add(dVar);
            this.dAP.setData(this.dAR);
            ge(this.hasMore);
            this.dAL.post(new Runnable() { // from class: com.baidu.tieba.frs.gamesubpb.view.a.2
                @Override // java.lang.Runnable
                public void run() {
                    a.this.dAL.requestFocus();
                    l.a(a.this.dAp.getPageContext().getPageActivity(), a.this.dAL);
                }
            });
            return;
        }
        if (TextUtils.isEmpty(str)) {
            str = this.dAp.getPageContext().getString(d.j.subpb_add_comment_fail_tip);
        }
        BdToast.a(this.dAp.getPageContext().getPageActivity(), str, 1).xn();
    }

    public void b(boolean z, String str, com.baidu.tieba.frs.gamesubpb.model.d dVar) {
        if (z) {
            BdToast.a(this.dAp.getPageContext().getPageActivity(), this.dAp.getPageContext().getString(d.j.subpb_delete_comment_succ_tip), 1).xn();
            this.dAR.remove(dVar);
            this.dAP.setData(this.dAR);
            ge(this.hasMore);
            return;
        }
        if (TextUtils.isEmpty(str)) {
            str = this.dAp.getPageContext().getString(d.j.subpb_delete_comment_fail_tip);
        }
        BdToast.a(this.dAp.getPageContext().getPageActivity(), str, 1).xn();
    }

    public void gf(boolean z) {
        if (this.cYM != null && this.cYM.getLayoutParams() != null) {
            ViewGroup.LayoutParams layoutParams = this.cYM.getLayoutParams();
            if (z) {
                ayz();
                layoutParams.height = l.f(this.dAp.getPageContext().getPageActivity(), d.e.ds98);
            } else {
                layoutParams.height = l.f(this.dAp.getPageContext().getPageActivity(), d.e.ds98) + UtilHelper.getLightStatusBarHeight();
            }
            this.cYM.setLayoutParams(layoutParams);
        }
    }

    public void aA(View view) {
        if (this.cYM != null && this.mNavigationBar != null) {
            if (this.mNavigationBar.isNavigationBarExcludeStatusbarVisible()) {
                this.mNavigationBar.showNavigationBarExcludeStatusbar(false);
                if (UtilHelper.canUseStyleImmersiveSticky()) {
                    this.cYM.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight()));
                } else if (this.mListView != null) {
                    this.mListView.removeHeaderView(this.cYM);
                }
                this.mNavigationBar.setVisibility(8);
                return;
            }
            this.mNavigationBar.showNavigationBarExcludeStatusbar(true);
            if (UtilHelper.canUseStyleImmersiveSticky()) {
                this.cYM.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + l.f(this.dAp.getActivity(), d.e.ds98)));
            } else if (this.mListView != null) {
                this.mListView.addHeaderView(this.cYM, 0);
            }
            this.mNavigationBar.setVisibility(0);
        }
    }

    public void mI(String str) {
        this.dAN.setVisibility(8);
        this.aOj.setVisibility(0);
        this.dAL.post(new Runnable() { // from class: com.baidu.tieba.frs.gamesubpb.view.a.3
            @Override // java.lang.Runnable
            public void run() {
                a.this.dAL.requestFocus();
                l.b(a.this.dAp.getPageContext().getPageActivity(), a.this.dAL);
            }
        });
        if (!TextUtils.isEmpty(str)) {
            String format = String.format(this.dAp.getPageContext().getPageActivity().getResources().getString(d.j.reply_sub_floor), str);
            this.dAL.setText(format);
            this.dAL.setSelection(format.length());
        }
    }

    public void lj(int i) {
        this.mProgressBar.setVisibility(i);
    }

    public View ayA() {
        return this.cYM;
    }

    public View getRootView() {
        return this.mRootView;
    }

    public ListView getListView() {
        return this.mListView;
    }

    public TextView ayB() {
        return this.dAN;
    }

    public NavigationBar Vf() {
        return this.mNavigationBar;
    }

    public void e(com.baidu.tieba.frs.gamesubpb.c cVar) {
        this.dzZ = cVar;
    }

    public void a(BdListView.e eVar) {
        this.mListView.setOnSrollToBottomListener(eVar);
    }

    public void onChangeSkinType(int i) {
        this.dAp.getLayoutMode().setNightMode(i == 1);
        this.dAp.getLayoutMode().onModeChanged(this.mRootView);
        am.j(this.mRootView, d.C0140d.cp_bg_line_d);
        this.mNavigationBar.onChangeSkinType(this.dAp.getPageContext(), i);
        this.dAJ.dC(i);
        am.h(this.dAN, d.C0140d.cp_cont_e);
        this.dAN.setAlpha(0.95f);
        am.i(this.dAN, d.f.pb_ecomm_comment_bg);
        am.h(this.dAO, d.C0140d.cp_cont_d);
        am.i(this.aOj, d.f.pb_ecomm_comment_bg);
        am.h(this.dAL, d.C0140d.cp_cont_f);
        this.dAL.setHintTextColor(am.getColor(d.C0140d.cp_cont_e));
        am.h(this.dAM, d.C0140d.game_sub_pb_send_txt_color);
    }

    public void onDestroy() {
        if (this.globalListener != null) {
            this.dAp.getPageContext().getPageActivity().getWindow().getDecorView().getViewTreeObserver().removeGlobalOnLayoutListener(this.globalListener);
        }
    }
}
