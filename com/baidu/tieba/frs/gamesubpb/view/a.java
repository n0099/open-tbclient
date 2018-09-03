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
import com.baidu.tieba.f;
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
    private View aAW;
    private LinearLayout aOg;
    private c bgf = new c(new c.a() { // from class: com.baidu.tieba.frs.gamesubpb.view.a.1
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
    private long bwo;
    private View cYI;
    private e dAG;
    private FrameLayout dAH;
    private EditText dAI;
    private TextView dAJ;
    private TextView dAK;
    private TextView dAL;
    private com.baidu.tieba.frs.gamesubpb.b dAM;
    private com.baidu.tieba.frs.gamesubpb.model.b dAN;
    private List<h> dAO;
    private String dAP;
    private String dAa;
    private FrsGameSubPbActivity dAm;
    private com.baidu.tieba.frs.gamesubpb.c dzW;
    private ViewTreeObserver.OnGlobalLayoutListener globalListener;
    private boolean hasMore;
    private View.OnClickListener mCommonClickListener;
    private boolean mIsKeyboardOpen;
    private BdTypeListView mListView;
    private NavigationBar mNavigationBar;
    private ProgressBar mProgressBar;
    private RelativeLayout mRootView;

    public a(FrsGameSubPbActivity frsGameSubPbActivity, View.OnClickListener onClickListener, String str) {
        this.dAm = frsGameSubPbActivity;
        this.mCommonClickListener = onClickListener;
        this.dAa = str;
        this.mRootView = (RelativeLayout) LayoutInflater.from(frsGameSubPbActivity.getPageContext().getPageActivity()).inflate(f.h.frs_game_sub_pb_activity, (ViewGroup) null);
        this.mListView = (BdTypeListView) this.mRootView.findViewById(f.g.new_sub_pb_list);
        this.mListView.setOnTouchListener(this.bgf);
        this.mListView.setOnScrollListener(new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.frs.gamesubpb.view.a.4
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
                if (i != 0) {
                    l.a(a.this.dAm.getPageContext().getPageActivity(), a.this.dAI);
                }
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            }
        });
        this.dAG = new e(this.dAm.getPageContext());
        this.cYI = BdListViewHelper.a(this.dAm.getActivity(), this.mListView, BdListViewHelper.HeadType.DEFAULT);
        this.dAK = (TextView) this.mRootView.findViewById(f.g.subpb_editor_tool_comment_reply_text);
        this.dAK.setOnClickListener(this.mCommonClickListener);
        this.dAL = (TextView) this.mRootView.findViewById(f.g.no_reply_list_view);
        this.dAH = (FrameLayout) this.mRootView.findViewById(f.g.bottom_view);
        this.aOg = (LinearLayout) this.mRootView.findViewById(f.g.subpb_editor_tool_comment_input_container);
        this.dAI = (EditText) this.mRootView.findViewById(f.g.subpb_editor_tool_comment_input_edit);
        this.dAJ = (TextView) this.mRootView.findViewById(f.g.subpb_editor_tool_comment_send_tv);
        this.dAJ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.gamesubpb.view.a.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.mJ(a.this.dAI.getText().toString());
            }
        });
        this.mProgressBar = (ProgressBar) this.mRootView.findViewById(f.g.progressBar);
        ayt();
        this.dAM = new com.baidu.tieba.frs.gamesubpb.b(this.dAm.getPageContext(), this.mListView);
        this.dAM.setClickListener(new a.InterfaceC0155a() { // from class: com.baidu.tieba.frs.gamesubpb.view.a.6
            @Override // com.baidu.tieba.frs.gamesubpb.a.InterfaceC0155a
            public void a(d dVar) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonPolymericActivityConfig(a.this.dAm.getPageContext().getPageActivity()).createNormalConfig(Long.valueOf(dVar.userId).longValue(), String.valueOf(a.this.bwo).equals(dVar.userId), false)));
            }

            @Override // com.baidu.tieba.frs.gamesubpb.a.InterfaceC0155a
            public void b(d dVar) {
                if (dVar != null) {
                    a.this.d(dVar);
                }
            }

            @Override // com.baidu.tieba.frs.gamesubpb.a.InterfaceC0155a
            public void c(d dVar) {
                if (a.this.dzW != null) {
                    a.this.dzW.ayl();
                }
                if (dVar == null) {
                    a.this.mK(null);
                    a.this.ayv();
                    return;
                }
                a.this.mK(dVar.userName);
                a.this.dAP = dVar.userId;
            }
        });
        lh(140);
        ayu();
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        this.dAO = new ArrayList();
        this.bwo = com.baidu.adp.lib.g.b.c(TbadkCoreApplication.getCurrentAccount(), 0L);
    }

    private void ayt() {
        this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(f.g.view_navigation_bar);
        this.aAW = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        ImageView backImageView = this.mNavigationBar.getBackImageView();
        if (backImageView != null && (backImageView.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.aAW.getLayoutParams();
            int f = l.f(this.dAm.getPageContext().getPageActivity(), f.e.ds30);
            layoutParams.height = f;
            layoutParams.width = f;
            backImageView.setLayoutParams(layoutParams);
        }
        if (this.aAW != null && (this.aAW.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.aAW.getLayoutParams();
            layoutParams2.width = -2;
            layoutParams2.height = -1;
            this.aAW.setPadding(l.f(this.dAm.getPageContext().getPageActivity(), f.e.ds32), this.aAW.getPaddingTop(), this.aAW.getPaddingRight(), this.aAW.getPaddingBottom());
            this.aAW.setLayoutParams(layoutParams2);
        }
        this.mNavigationBar.setmBackImageViewBg(f.C0146f.subpb_navigationbar_back, f.C0146f.subpb_navigationbar_back);
    }

    private void ayu() {
        this.globalListener = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tieba.frs.gamesubpb.view.a.7
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                Rect rect = new Rect();
                a.this.dAm.getPageContext().getPageActivity().getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
                int n = l.n(a.this.dAm.getPageContext().getPageActivity());
                int[] al = l.al(a.this.dAm.getPageContext().getPageActivity());
                if (al[1] - rect.bottom > al[1] / 4 && !a.this.mIsKeyboardOpen) {
                    a.this.mIsKeyboardOpen = true;
                    a.this.onKeyboardVisibilityChanged(true);
                } else if (al[1] - rect.height() == n && a.this.mIsKeyboardOpen) {
                    a.this.mIsKeyboardOpen = false;
                    a.this.onKeyboardVisibilityChanged(false);
                }
            }
        };
        this.dAm.getPageContext().getPageActivity().getWindow().getDecorView().getViewTreeObserver().addOnGlobalLayoutListener(this.globalListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(final d dVar) {
        final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.dAm.getPageContext().getPageActivity());
        aVar.dA(null);
        aVar.cf(f.j.del_post_confirm);
        aVar.aw(true);
        aVar.a(f.j.dialog_ok, new a.b() { // from class: com.baidu.tieba.frs.gamesubpb.view.a.8
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar.dismiss();
                a.this.e(dVar);
            }
        });
        aVar.b(f.j.dialog_cancel, new a.b() { // from class: com.baidu.tieba.frs.gamesubpb.view.a.9
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar.dismiss();
            }
        });
        aVar.b(this.dAm.getPageContext()).xe();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(d dVar) {
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_DELETE_SUB_COMMENT);
        httpMessage.addParam("user_id", this.bwo);
        httpMessage.addParam("main_tower_id", dVar.dAC);
        httpMessage.addParam("id", dVar.id);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mJ(String str) {
        li(0);
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_ADD_SUB_COMMENT);
        httpMessage.addParam("user_id", this.bwo);
        httpMessage.addParam("reply_user_id", this.dAP);
        httpMessage.addParam("content", str);
        httpMessage.addParam("main_tower_id", this.dAa);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ayv() {
        this.dAP = this.dAN != null ? this.dAN.userId : null;
    }

    private void ayw() {
        if (!w.z(this.dAO)) {
            this.mNavigationBar.setCenterTextTitle(String.format(this.dAm.getResources().getString(f.j.subpb_floor_reply_count), ap.F(this.dAO.size())));
        } else {
            this.mNavigationBar.setCenterTextTitle(this.dAm.getResources().getString(f.j.reply));
        }
    }

    private void lh(final int i) {
        this.dAI.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.frs.gamesubpb.view.a.10
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                if (!TextUtils.isEmpty(charSequence)) {
                    a.this.dAJ.setEnabled(true);
                    String charSequence2 = charSequence.toString();
                    if (!StringUtils.isNull(charSequence2) && com.baidu.tbadk.util.w.hH(charSequence2) > i) {
                        String k = com.baidu.tbadk.util.w.k(charSequence2, 0, i - 1);
                        a.this.dAI.setText(k);
                        a.this.dAI.setSelection(a.this.dAI.getText().length());
                        UtilHelper.showToast(a.this.dAm.getPageContext().getPageActivity().getApplication(), a.this.dAm.getPageContext().getPageActivity().getResources().getString(f.j.edit_text_over_limit_tip, Integer.valueOf(k.length())));
                        return;
                    }
                    return;
                }
                a.this.ayv();
                a.this.dAJ.setEnabled(false);
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
            }
        });
    }

    private void ayx() {
        this.mNavigationBar.setmBackImageViewBg(f.C0146f.subpb_navigationbar_close, f.C0146f.subpb_navigationbar_close);
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
            this.aOg.getWindowVisibleDisplayFrame(rect);
            this.dAH.scrollTo(this.dAH.getScrollX(), (l.al(this.dAm.getPageContext().getPageActivity())[1] - rect.bottom) - (MenuKeyUtils.hasSmartBar() ? l.dip2px(this.dAm.getPageContext().getPageActivity(), 48.0f) : 0));
            return;
        }
        this.dAH.setScrollY(0);
    }

    private void ge(boolean z) {
        if (w.z(this.dAO)) {
            this.mListView.setNextPage(null);
            this.dAL.setVisibility(0);
        } else {
            this.mListView.setNextPage(this.dAG);
            this.dAL.setVisibility(8);
            if (z) {
                this.dAG.Av();
            } else {
                this.dAG.Aw();
            }
        }
        ayw();
    }

    public void a(boolean z, com.baidu.tieba.frs.gamesubpb.model.b bVar, List<h> list) {
        this.hasMore = z;
        this.dAN = bVar;
        ayv();
        if (w.z(list)) {
            ge(z);
            return;
        }
        this.dAO.clear();
        this.dAO.addAll(list);
        this.dAL.setVisibility(8);
        this.mListView.setNextPage(this.dAG);
        this.dAM.setData(list);
        ayx();
        this.dAK.setVisibility(0);
        this.dAK.setText(f.j.say_your_point);
        ge(z);
    }

    public void a(boolean z, String str, d dVar) {
        li(8);
        if (z && dVar != null) {
            BdToast.a(this.dAm.getPageContext().getPageActivity(), this.dAm.getPageContext().getString(f.j.subpb_add_comment_succ_tip), 1).xm();
            this.dAI.setText((CharSequence) null);
            this.dAO.add(dVar);
            this.dAM.setData(this.dAO);
            ge(this.hasMore);
            this.dAI.post(new Runnable() { // from class: com.baidu.tieba.frs.gamesubpb.view.a.2
                @Override // java.lang.Runnable
                public void run() {
                    a.this.dAI.requestFocus();
                    l.a(a.this.dAm.getPageContext().getPageActivity(), a.this.dAI);
                }
            });
            return;
        }
        if (TextUtils.isEmpty(str)) {
            str = this.dAm.getPageContext().getString(f.j.subpb_add_comment_fail_tip);
        }
        BdToast.a(this.dAm.getPageContext().getPageActivity(), str, 1).xm();
    }

    public void b(boolean z, String str, d dVar) {
        if (z) {
            BdToast.a(this.dAm.getPageContext().getPageActivity(), this.dAm.getPageContext().getString(f.j.subpb_delete_comment_succ_tip), 1).xm();
            this.dAO.remove(dVar);
            this.dAM.setData(this.dAO);
            ge(this.hasMore);
            return;
        }
        if (TextUtils.isEmpty(str)) {
            str = this.dAm.getPageContext().getString(f.j.subpb_delete_comment_fail_tip);
        }
        BdToast.a(this.dAm.getPageContext().getPageActivity(), str, 1).xm();
    }

    public void gf(boolean z) {
        if (this.cYI != null && this.cYI.getLayoutParams() != null) {
            ViewGroup.LayoutParams layoutParams = this.cYI.getLayoutParams();
            if (z) {
                ayx();
                layoutParams.height = l.f(this.dAm.getPageContext().getPageActivity(), f.e.ds98);
            } else {
                layoutParams.height = l.f(this.dAm.getPageContext().getPageActivity(), f.e.ds98) + UtilHelper.getLightStatusBarHeight();
            }
            this.cYI.setLayoutParams(layoutParams);
        }
    }

    public void aA(View view) {
        if (this.cYI != null && this.mNavigationBar != null) {
            if (this.mNavigationBar.isNavigationBarExcludeStatusbarVisible()) {
                this.mNavigationBar.showNavigationBarExcludeStatusbar(false);
                if (UtilHelper.canUseStyleImmersiveSticky()) {
                    this.cYI.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight()));
                } else if (this.mListView != null) {
                    this.mListView.removeHeaderView(this.cYI);
                }
                this.mNavigationBar.setVisibility(8);
                return;
            }
            this.mNavigationBar.showNavigationBarExcludeStatusbar(true);
            if (UtilHelper.canUseStyleImmersiveSticky()) {
                this.cYI.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + l.f(this.dAm.getActivity(), f.e.ds98)));
            } else if (this.mListView != null) {
                this.mListView.addHeaderView(this.cYI, 0);
            }
            this.mNavigationBar.setVisibility(0);
        }
    }

    public void mK(String str) {
        this.dAK.setVisibility(8);
        this.aOg.setVisibility(0);
        this.dAI.post(new Runnable() { // from class: com.baidu.tieba.frs.gamesubpb.view.a.3
            @Override // java.lang.Runnable
            public void run() {
                a.this.dAI.requestFocus();
                l.b(a.this.dAm.getPageContext().getPageActivity(), a.this.dAI);
            }
        });
        if (!TextUtils.isEmpty(str)) {
            String format = String.format(this.dAm.getPageContext().getPageActivity().getResources().getString(f.j.reply_sub_floor), str);
            this.dAI.setText(format);
            this.dAI.setSelection(format.length());
        }
    }

    public void li(int i) {
        this.mProgressBar.setVisibility(i);
    }

    public View ayy() {
        return this.cYI;
    }

    public View getRootView() {
        return this.mRootView;
    }

    public ListView getListView() {
        return this.mListView;
    }

    public TextView ayz() {
        return this.dAK;
    }

    public NavigationBar Vj() {
        return this.mNavigationBar;
    }

    public void e(com.baidu.tieba.frs.gamesubpb.c cVar) {
        this.dzW = cVar;
    }

    public void a(BdListView.e eVar) {
        this.mListView.setOnSrollToBottomListener(eVar);
    }

    public void onChangeSkinType(int i) {
        this.dAm.getLayoutMode().setNightMode(i == 1);
        this.dAm.getLayoutMode().onModeChanged(this.mRootView);
        am.j(this.mRootView, f.d.cp_bg_line_d);
        this.mNavigationBar.onChangeSkinType(this.dAm.getPageContext(), i);
        this.dAG.dB(i);
        am.h(this.dAK, f.d.cp_cont_e);
        this.dAK.setAlpha(0.95f);
        am.i(this.dAK, f.C0146f.pb_ecomm_comment_bg);
        am.h(this.dAL, f.d.cp_cont_d);
        am.i(this.aOg, f.C0146f.pb_ecomm_comment_bg);
        am.h(this.dAI, f.d.cp_cont_f);
        this.dAI.setHintTextColor(am.getColor(f.d.cp_cont_e));
        am.h(this.dAJ, f.d.game_sub_pb_send_txt_color);
    }

    public void onDestroy() {
        if (this.globalListener != null) {
            this.dAm.getPageContext().getPageActivity().getWindow().getDecorView().getViewTreeObserver().removeGlobalOnLayoutListener(this.globalListener);
        }
    }
}
