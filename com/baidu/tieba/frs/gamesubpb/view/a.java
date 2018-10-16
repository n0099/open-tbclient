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
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tbadk.util.y;
import com.baidu.tieba.e;
import com.baidu.tieba.frs.gamesubpb.FrsGameSubPbActivity;
import com.baidu.tieba.frs.gamesubpb.a;
import com.baidu.tieba.frs.gamesubpb.model.d;
import com.baidu.tieba.frs.gamesubpb.model.e;
import com.baidu.tieba.pb.a.c;
import com.compatible.menukey.MenuKeyUtils;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class a {
    private View aIE;
    private LinearLayout aVZ;
    private long bKK;
    private c bnE = new c(new c.a() { // from class: com.baidu.tieba.frs.gamesubpb.view.a.1
        @Override // com.baidu.tieba.pb.a.c.a
        public boolean a(View view, MotionEvent motionEvent) {
            a.this.gT(false);
            a.this.aO(view);
            a.this.gT(true);
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
    private com.baidu.tieba.frs.gamesubpb.c dOF;
    private String dOJ;
    private FrsGameSubPbActivity dOV;
    private e dPp;
    private FrameLayout dPq;
    private EditText dPr;
    private TextView dPs;
    private TextView dPt;
    private TextView dPu;
    private com.baidu.tieba.frs.gamesubpb.b dPv;
    private com.baidu.tieba.frs.gamesubpb.model.b dPw;
    private List<h> dPx;
    private String dPy;
    private View dmK;
    private ViewTreeObserver.OnGlobalLayoutListener globalListener;
    private boolean hasMore;
    private View.OnClickListener mCommonClickListener;
    private boolean mIsKeyboardOpen;
    private BdTypeListView mListView;
    private NavigationBar mNavigationBar;
    private ProgressBar mProgressBar;
    private RelativeLayout mRootView;

    public a(FrsGameSubPbActivity frsGameSubPbActivity, View.OnClickListener onClickListener, String str) {
        this.dOV = frsGameSubPbActivity;
        this.mCommonClickListener = onClickListener;
        this.dOJ = str;
        this.mRootView = (RelativeLayout) LayoutInflater.from(frsGameSubPbActivity.getPageContext().getPageActivity()).inflate(e.h.frs_game_sub_pb_activity, (ViewGroup) null);
        this.mListView = (BdTypeListView) this.mRootView.findViewById(e.g.new_sub_pb_list);
        this.mListView.setOnTouchListener(this.bnE);
        this.mListView.setOnScrollListener(new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.frs.gamesubpb.view.a.4
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
                if (i != 0) {
                    l.a(a.this.dOV.getPageContext().getPageActivity(), a.this.dPr);
                }
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            }
        });
        this.dPp = new com.baidu.tieba.frs.gamesubpb.model.e(this.dOV.getPageContext());
        this.dmK = BdListViewHelper.a(this.dOV.getActivity(), this.mListView, BdListViewHelper.HeadType.DEFAULT);
        this.dPt = (TextView) this.mRootView.findViewById(e.g.subpb_editor_tool_comment_reply_text);
        this.dPt.setOnClickListener(this.mCommonClickListener);
        this.dPu = (TextView) this.mRootView.findViewById(e.g.no_reply_list_view);
        this.dPq = (FrameLayout) this.mRootView.findViewById(e.g.bottom_view);
        this.aVZ = (LinearLayout) this.mRootView.findViewById(e.g.subpb_editor_tool_comment_input_container);
        this.dPr = (EditText) this.mRootView.findViewById(e.g.subpb_editor_tool_comment_input_edit);
        this.dPs = (TextView) this.mRootView.findViewById(e.g.subpb_editor_tool_comment_send_tv);
        this.dPs.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.gamesubpb.view.a.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.nO(a.this.dPr.getText().toString());
            }
        });
        this.mProgressBar = (ProgressBar) this.mRootView.findViewById(e.g.progressBar);
        aEb();
        this.dPv = new com.baidu.tieba.frs.gamesubpb.b(this.dOV.getPageContext(), this.mListView);
        this.dPv.setClickListener(new a.InterfaceC0189a() { // from class: com.baidu.tieba.frs.gamesubpb.view.a.6
            @Override // com.baidu.tieba.frs.gamesubpb.a.InterfaceC0189a
            public void a(d dVar) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonPolymericActivityConfig(a.this.dOV.getPageContext().getPageActivity()).createNormalConfig(Long.valueOf(dVar.userId).longValue(), String.valueOf(a.this.bKK).equals(dVar.userId), false)));
            }

            @Override // com.baidu.tieba.frs.gamesubpb.a.InterfaceC0189a
            public void b(d dVar) {
                if (dVar != null) {
                    a.this.d(dVar);
                }
            }

            @Override // com.baidu.tieba.frs.gamesubpb.a.InterfaceC0189a
            public void c(d dVar) {
                if (a.this.dOF != null) {
                    a.this.dOF.aDT();
                }
                if (dVar == null) {
                    a.this.nP(null);
                    a.this.aEd();
                    return;
                }
                a.this.nP(dVar.userName);
                a.this.dPy = dVar.userId;
            }
        });
        mi(140);
        aEc();
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        this.dPx = new ArrayList();
        this.bKK = com.baidu.adp.lib.g.b.d(TbadkCoreApplication.getCurrentAccount(), 0L);
    }

    private void aEb() {
        this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(e.g.view_navigation_bar);
        this.aIE = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        ImageView backImageView = this.mNavigationBar.getBackImageView();
        if (backImageView != null && (backImageView.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.aIE.getLayoutParams();
            int h = l.h(this.dOV.getPageContext().getPageActivity(), e.C0175e.ds30);
            layoutParams.height = h;
            layoutParams.width = h;
            backImageView.setLayoutParams(layoutParams);
        }
        if (this.aIE != null && (this.aIE.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.aIE.getLayoutParams();
            layoutParams2.width = -2;
            layoutParams2.height = -1;
            this.aIE.setPadding(l.h(this.dOV.getPageContext().getPageActivity(), e.C0175e.ds32), this.aIE.getPaddingTop(), this.aIE.getPaddingRight(), this.aIE.getPaddingBottom());
            this.aIE.setLayoutParams(layoutParams2);
        }
        this.mNavigationBar.setmBackImageViewBg(e.f.subpb_navigationbar_back, e.f.subpb_navigationbar_back);
    }

    private void aEc() {
        this.globalListener = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tieba.frs.gamesubpb.view.a.7
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                Rect rect = new Rect();
                a.this.dOV.getPageContext().getPageActivity().getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
                int r = l.r(a.this.dOV.getPageContext().getPageActivity());
                int[] aS = l.aS(a.this.dOV.getPageContext().getPageActivity());
                if (aS[1] - rect.bottom > aS[1] / 4 && !a.this.mIsKeyboardOpen) {
                    a.this.mIsKeyboardOpen = true;
                    a.this.onKeyboardVisibilityChanged(true);
                } else if (aS[1] - rect.height() == r && a.this.mIsKeyboardOpen) {
                    a.this.mIsKeyboardOpen = false;
                    a.this.onKeyboardVisibilityChanged(false);
                }
            }
        };
        this.dOV.getPageContext().getPageActivity().getWindow().getDecorView().getViewTreeObserver().addOnGlobalLayoutListener(this.globalListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(final d dVar) {
        final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.dOV.getPageContext().getPageActivity());
        aVar.ei(null);
        aVar.cz(e.j.del_post_confirm);
        aVar.aP(true);
        aVar.a(e.j.dialog_ok, new a.b() { // from class: com.baidu.tieba.frs.gamesubpb.view.a.8
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar.dismiss();
                a.this.e(dVar);
            }
        });
        aVar.b(e.j.dialog_cancel, new a.b() { // from class: com.baidu.tieba.frs.gamesubpb.view.a.9
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar.dismiss();
            }
        });
        aVar.b(this.dOV.getPageContext()).Au();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(d dVar) {
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_DELETE_SUB_COMMENT);
        httpMessage.addParam("user_id", this.bKK);
        httpMessage.addParam("main_tower_id", dVar.dPl);
        httpMessage.addParam("id", dVar.id);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void nO(String str) {
        mj(0);
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_ADD_SUB_COMMENT);
        httpMessage.addParam("user_id", this.bKK);
        httpMessage.addParam("reply_user_id", this.dPy);
        httpMessage.addParam("content", str);
        httpMessage.addParam("main_tower_id", this.dOJ);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aEd() {
        this.dPy = this.dPw != null ? this.dPw.userId : null;
    }

    private void aEe() {
        if (!v.J(this.dPx)) {
            this.mNavigationBar.setCenterTextTitle(String.format(this.dOV.getResources().getString(e.j.subpb_floor_reply_count), ao.L(this.dPx.size())));
        } else {
            this.mNavigationBar.setCenterTextTitle(this.dOV.getResources().getString(e.j.reply));
        }
    }

    private void mi(final int i) {
        this.dPr.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.frs.gamesubpb.view.a.10
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                if (!TextUtils.isEmpty(charSequence)) {
                    a.this.dPs.setEnabled(true);
                    String charSequence2 = charSequence.toString();
                    if (!StringUtils.isNull(charSequence2) && y.is(charSequence2) > i) {
                        String o = y.o(charSequence2, 0, i - 1);
                        a.this.dPr.setText(o);
                        a.this.dPr.setSelection(a.this.dPr.getText().length());
                        UtilHelper.showToast(a.this.dOV.getPageContext().getPageActivity().getApplication(), a.this.dOV.getPageContext().getPageActivity().getResources().getString(e.j.edit_text_over_limit_tip, Integer.valueOf(o.length())));
                        return;
                    }
                    return;
                }
                a.this.aEd();
                a.this.dPs.setEnabled(false);
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
            }
        });
    }

    private void aEf() {
        this.mNavigationBar.setmBackImageViewBg(e.f.subpb_navigationbar_close, e.f.subpb_navigationbar_close);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gT(final boolean z) {
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
            this.aVZ.getWindowVisibleDisplayFrame(rect);
            this.dPq.scrollTo(this.dPq.getScrollX(), (l.aS(this.dOV.getPageContext().getPageActivity())[1] - rect.bottom) - (MenuKeyUtils.hasSmartBar() ? l.dip2px(this.dOV.getPageContext().getPageActivity(), 48.0f) : 0));
            return;
        }
        this.dPq.setScrollY(0);
    }

    private void gU(boolean z) {
        if (v.J(this.dPx)) {
            this.mListView.setNextPage(null);
            this.dPu.setVisibility(0);
        } else {
            this.mListView.setNextPage(this.dPp);
            this.dPu.setVisibility(8);
            if (z) {
                this.dPp.DO();
            } else {
                this.dPp.DP();
            }
        }
        aEe();
    }

    public void a(boolean z, com.baidu.tieba.frs.gamesubpb.model.b bVar, List<h> list) {
        this.hasMore = z;
        this.dPw = bVar;
        aEd();
        if (v.J(list)) {
            gU(z);
            return;
        }
        this.dPx.clear();
        this.dPx.addAll(list);
        this.dPu.setVisibility(8);
        this.mListView.setNextPage(this.dPp);
        this.dPv.setData(list);
        aEf();
        this.dPt.setVisibility(0);
        this.dPt.setText(e.j.say_your_point);
        gU(z);
    }

    public void a(boolean z, String str, d dVar) {
        mj(8);
        if (z && dVar != null) {
            BdToast.a(this.dOV.getPageContext().getPageActivity(), this.dOV.getPageContext().getString(e.j.subpb_add_comment_succ_tip), 1).AC();
            this.dPr.setText((CharSequence) null);
            this.dPx.add(dVar);
            this.dPv.setData(this.dPx);
            gU(this.hasMore);
            this.dPr.post(new Runnable() { // from class: com.baidu.tieba.frs.gamesubpb.view.a.2
                @Override // java.lang.Runnable
                public void run() {
                    a.this.dPr.requestFocus();
                    l.a(a.this.dOV.getPageContext().getPageActivity(), a.this.dPr);
                }
            });
            return;
        }
        if (TextUtils.isEmpty(str)) {
            str = this.dOV.getPageContext().getString(e.j.subpb_add_comment_fail_tip);
        }
        BdToast.a(this.dOV.getPageContext().getPageActivity(), str, 1).AC();
    }

    public void b(boolean z, String str, d dVar) {
        if (z) {
            BdToast.a(this.dOV.getPageContext().getPageActivity(), this.dOV.getPageContext().getString(e.j.subpb_delete_comment_succ_tip), 1).AC();
            this.dPx.remove(dVar);
            this.dPv.setData(this.dPx);
            gU(this.hasMore);
            return;
        }
        if (TextUtils.isEmpty(str)) {
            str = this.dOV.getPageContext().getString(e.j.subpb_delete_comment_fail_tip);
        }
        BdToast.a(this.dOV.getPageContext().getPageActivity(), str, 1).AC();
    }

    public void gV(boolean z) {
        if (this.dmK != null && this.dmK.getLayoutParams() != null) {
            ViewGroup.LayoutParams layoutParams = this.dmK.getLayoutParams();
            if (z) {
                aEf();
                layoutParams.height = l.h(this.dOV.getPageContext().getPageActivity(), e.C0175e.ds98);
            } else {
                layoutParams.height = l.h(this.dOV.getPageContext().getPageActivity(), e.C0175e.ds98) + UtilHelper.getLightStatusBarHeight();
            }
            this.dmK.setLayoutParams(layoutParams);
        }
    }

    public void aO(View view) {
        if (this.dmK != null && this.mNavigationBar != null) {
            if (this.mNavigationBar.isNavigationBarExcludeStatusbarVisible()) {
                this.mNavigationBar.showNavigationBarExcludeStatusbar(false);
                if (UtilHelper.canUseStyleImmersiveSticky()) {
                    this.dmK.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight()));
                } else if (this.mListView != null) {
                    this.mListView.removeHeaderView(this.dmK);
                }
                this.mNavigationBar.setVisibility(8);
                return;
            }
            this.mNavigationBar.showNavigationBarExcludeStatusbar(true);
            if (UtilHelper.canUseStyleImmersiveSticky()) {
                this.dmK.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + l.h(this.dOV.getActivity(), e.C0175e.ds98)));
            } else if (this.mListView != null) {
                this.mListView.addHeaderView(this.dmK, 0);
            }
            this.mNavigationBar.setVisibility(0);
        }
    }

    public void nP(String str) {
        this.dPt.setVisibility(8);
        this.aVZ.setVisibility(0);
        this.dPr.post(new Runnable() { // from class: com.baidu.tieba.frs.gamesubpb.view.a.3
            @Override // java.lang.Runnable
            public void run() {
                a.this.dPr.requestFocus();
                l.b(a.this.dOV.getPageContext().getPageActivity(), a.this.dPr);
            }
        });
        if (!TextUtils.isEmpty(str)) {
            String format = String.format(this.dOV.getPageContext().getPageActivity().getResources().getString(e.j.reply_sub_floor), str);
            this.dPr.setText(format);
            this.dPr.setSelection(format.length());
        }
    }

    public void mj(int i) {
        this.mProgressBar.setVisibility(i);
    }

    public View aEg() {
        return this.dmK;
    }

    public View getRootView() {
        return this.mRootView;
    }

    public ListView getListView() {
        return this.mListView;
    }

    public TextView aEh() {
        return this.dPt;
    }

    public NavigationBar aaD() {
        return this.mNavigationBar;
    }

    public void e(com.baidu.tieba.frs.gamesubpb.c cVar) {
        this.dOF = cVar;
    }

    public void a(BdListView.e eVar) {
        this.mListView.setOnSrollToBottomListener(eVar);
    }

    public void onChangeSkinType(int i) {
        this.dOV.getLayoutMode().setNightMode(i == 1);
        this.dOV.getLayoutMode().onModeChanged(this.mRootView);
        al.j(this.mRootView, e.d.cp_bg_line_d);
        this.mNavigationBar.onChangeSkinType(this.dOV.getPageContext(), i);
        this.dPp.dW(i);
        al.h(this.dPt, e.d.cp_cont_e);
        this.dPt.setAlpha(0.95f);
        al.i(this.dPt, e.f.pb_ecomm_comment_bg);
        al.h(this.dPu, e.d.cp_cont_d);
        al.i(this.aVZ, e.f.pb_ecomm_comment_bg);
        al.h(this.dPr, e.d.cp_cont_f);
        this.dPr.setHintTextColor(al.getColor(e.d.cp_cont_e));
        al.h(this.dPs, e.d.game_sub_pb_send_txt_color);
    }

    public void onDestroy() {
        if (this.globalListener != null) {
            this.dOV.getPageContext().getPageActivity().getWindow().getDecorView().getViewTreeObserver().removeGlobalOnLayoutListener(this.globalListener);
        }
    }
}
