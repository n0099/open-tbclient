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
    private View aMW;
    private long bPn;
    private LinearLayout bap;
    private c brQ = new c(new c.a() { // from class: com.baidu.tieba.frs.gamesubpb.view.a.1
        @Override // com.baidu.tieba.pb.a.c.a
        public boolean a(View view, MotionEvent motionEvent) {
            a.this.hh(false);
            a.this.aT(view);
            a.this.hh(true);
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
    private e dZL;
    private FrameLayout dZM;
    private EditText dZN;
    private TextView dZO;
    private TextView dZP;
    private TextView dZQ;
    private com.baidu.tieba.frs.gamesubpb.b dZR;
    private com.baidu.tieba.frs.gamesubpb.model.b dZS;
    private List<h> dZT;
    private String dZU;
    private com.baidu.tieba.frs.gamesubpb.c dZb;
    private String dZf;
    private FrsGameSubPbActivity dZr;
    private View dxd;
    private ViewTreeObserver.OnGlobalLayoutListener globalListener;
    private boolean hasMore;
    private View.OnClickListener mCommonClickListener;
    private boolean mIsKeyboardOpen;
    private BdTypeListView mListView;
    private NavigationBar mNavigationBar;
    private ProgressBar mProgressBar;
    private RelativeLayout mRootView;

    public a(FrsGameSubPbActivity frsGameSubPbActivity, View.OnClickListener onClickListener, String str) {
        this.dZr = frsGameSubPbActivity;
        this.mCommonClickListener = onClickListener;
        this.dZf = str;
        this.mRootView = (RelativeLayout) LayoutInflater.from(frsGameSubPbActivity.getPageContext().getPageActivity()).inflate(e.h.frs_game_sub_pb_activity, (ViewGroup) null);
        this.mListView = (BdTypeListView) this.mRootView.findViewById(e.g.new_sub_pb_list);
        this.mListView.setOnTouchListener(this.brQ);
        this.mListView.setOnScrollListener(new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.frs.gamesubpb.view.a.4
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
                if (i != 0) {
                    l.b(a.this.dZr.getPageContext().getPageActivity(), a.this.dZN);
                }
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            }
        });
        this.dZL = new com.baidu.tieba.frs.gamesubpb.model.e(this.dZr.getPageContext());
        this.dxd = BdListViewHelper.a(this.dZr.getActivity(), this.mListView, BdListViewHelper.HeadType.DEFAULT);
        this.dZP = (TextView) this.mRootView.findViewById(e.g.subpb_editor_tool_comment_reply_text);
        this.dZP.setOnClickListener(this.mCommonClickListener);
        this.dZQ = (TextView) this.mRootView.findViewById(e.g.no_reply_list_view);
        this.dZM = (FrameLayout) this.mRootView.findViewById(e.g.bottom_view);
        this.bap = (LinearLayout) this.mRootView.findViewById(e.g.subpb_editor_tool_comment_input_container);
        this.dZN = (EditText) this.mRootView.findViewById(e.g.subpb_editor_tool_comment_input_edit);
        this.dZO = (TextView) this.mRootView.findViewById(e.g.subpb_editor_tool_comment_send_tv);
        this.dZO.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.gamesubpb.view.a.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.ot(a.this.dZN.getText().toString());
            }
        });
        this.mProgressBar = (ProgressBar) this.mRootView.findViewById(e.g.progressBar);
        aFX();
        this.dZR = new com.baidu.tieba.frs.gamesubpb.b(this.dZr.getPageContext(), this.mListView);
        this.dZR.setClickListener(new a.InterfaceC0225a() { // from class: com.baidu.tieba.frs.gamesubpb.view.a.6
            @Override // com.baidu.tieba.frs.gamesubpb.a.InterfaceC0225a
            public void a(d dVar) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonPolymericActivityConfig(a.this.dZr.getPageContext().getPageActivity()).createNormalConfig(Long.valueOf(dVar.userId).longValue(), String.valueOf(a.this.bPn).equals(dVar.userId), false)));
            }

            @Override // com.baidu.tieba.frs.gamesubpb.a.InterfaceC0225a
            public void b(d dVar) {
                if (dVar != null) {
                    a.this.d(dVar);
                }
            }

            @Override // com.baidu.tieba.frs.gamesubpb.a.InterfaceC0225a
            public void c(d dVar) {
                if (a.this.dZb != null) {
                    a.this.dZb.aFP();
                }
                if (dVar == null) {
                    a.this.ou(null);
                    a.this.aFZ();
                    return;
                }
                a.this.ou(dVar.userName);
                a.this.dZU = dVar.userId;
            }
        });
        nc(140);
        aFY();
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        this.dZT = new ArrayList();
        this.bPn = com.baidu.adp.lib.g.b.d(TbadkCoreApplication.getCurrentAccount(), 0L);
    }

    private void aFX() {
        this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(e.g.view_navigation_bar);
        this.aMW = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        ImageView backImageView = this.mNavigationBar.getBackImageView();
        if (backImageView != null && (backImageView.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.aMW.getLayoutParams();
            int h = l.h(this.dZr.getPageContext().getPageActivity(), e.C0210e.ds30);
            layoutParams.height = h;
            layoutParams.width = h;
            backImageView.setLayoutParams(layoutParams);
        }
        if (this.aMW != null && (this.aMW.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.aMW.getLayoutParams();
            layoutParams2.width = -2;
            layoutParams2.height = -1;
            this.aMW.setPadding(l.h(this.dZr.getPageContext().getPageActivity(), e.C0210e.ds32), this.aMW.getPaddingTop(), this.aMW.getPaddingRight(), this.aMW.getPaddingBottom());
            this.aMW.setLayoutParams(layoutParams2);
        }
        this.mNavigationBar.setmBackImageViewBg(e.f.subpb_navigationbar_back, e.f.subpb_navigationbar_back);
    }

    private void aFY() {
        this.globalListener = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tieba.frs.gamesubpb.view.a.7
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                Rect rect = new Rect();
                a.this.dZr.getPageContext().getPageActivity().getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
                int r = l.r(a.this.dZr.getPageContext().getPageActivity());
                int[] aS = l.aS(a.this.dZr.getPageContext().getPageActivity());
                if (aS[1] - rect.bottom > aS[1] / 4 && !a.this.mIsKeyboardOpen) {
                    a.this.mIsKeyboardOpen = true;
                    a.this.onKeyboardVisibilityChanged(true);
                } else if (aS[1] - rect.height() == r && a.this.mIsKeyboardOpen) {
                    a.this.mIsKeyboardOpen = false;
                    a.this.onKeyboardVisibilityChanged(false);
                }
            }
        };
        this.dZr.getPageContext().getPageActivity().getWindow().getDecorView().getViewTreeObserver().addOnGlobalLayoutListener(this.globalListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(final d dVar) {
        final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.dZr.getPageContext().getPageActivity());
        aVar.eA(null);
        aVar.db(e.j.del_post_confirm);
        aVar.bg(true);
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
        aVar.b(this.dZr.getPageContext()).BF();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(d dVar) {
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_DELETE_SUB_COMMENT);
        httpMessage.addParam("user_id", this.bPn);
        httpMessage.addParam("main_tower_id", dVar.dZH);
        httpMessage.addParam("id", dVar.id);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ot(String str) {
        nd(0);
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_ADD_SUB_COMMENT);
        httpMessage.addParam("user_id", this.bPn);
        httpMessage.addParam("reply_user_id", this.dZU);
        httpMessage.addParam("content", str);
        httpMessage.addParam("main_tower_id", this.dZf);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aFZ() {
        this.dZU = this.dZS != null ? this.dZS.userId : null;
    }

    private void aGa() {
        if (!v.I(this.dZT)) {
            this.mNavigationBar.setCenterTextTitle(String.format(this.dZr.getResources().getString(e.j.subpb_floor_reply_count), ao.V(this.dZT.size())));
        } else {
            this.mNavigationBar.setCenterTextTitle(this.dZr.getResources().getString(e.j.reply));
        }
    }

    private void nc(final int i) {
        this.dZN.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.frs.gamesubpb.view.a.10
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                if (!TextUtils.isEmpty(charSequence)) {
                    a.this.dZO.setEnabled(true);
                    String charSequence2 = charSequence.toString();
                    if (!StringUtils.isNull(charSequence2) && y.iM(charSequence2) > i) {
                        String q = y.q(charSequence2, 0, i - 1);
                        a.this.dZN.setText(q);
                        a.this.dZN.setSelection(a.this.dZN.getText().length());
                        UtilHelper.showToast(a.this.dZr.getPageContext().getPageActivity().getApplication(), a.this.dZr.getPageContext().getPageActivity().getResources().getString(e.j.edit_text_over_limit_tip, Integer.valueOf(q.length())));
                        return;
                    }
                    return;
                }
                a.this.aFZ();
                a.this.dZO.setEnabled(false);
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
            }
        });
    }

    private void aGb() {
        this.mNavigationBar.setmBackImageViewBg(e.f.subpb_navigationbar_close, e.f.subpb_navigationbar_close);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hh(final boolean z) {
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
            this.bap.getWindowVisibleDisplayFrame(rect);
            this.dZM.scrollTo(this.dZM.getScrollX(), (l.aS(this.dZr.getPageContext().getPageActivity())[1] - rect.bottom) - (MenuKeyUtils.hasSmartBar() ? l.dip2px(this.dZr.getPageContext().getPageActivity(), 48.0f) : 0));
            return;
        }
        this.dZM.setScrollY(0);
    }

    private void hi(boolean z) {
        if (v.I(this.dZT)) {
            this.mListView.setNextPage(null);
            this.dZQ.setVisibility(0);
        } else {
            this.mListView.setNextPage(this.dZL);
            this.dZQ.setVisibility(8);
            if (z) {
                this.dZL.Fc();
            } else {
                this.dZL.Fd();
            }
        }
        aGa();
    }

    public void a(boolean z, com.baidu.tieba.frs.gamesubpb.model.b bVar, List<h> list) {
        this.hasMore = z;
        this.dZS = bVar;
        aFZ();
        if (v.I(list)) {
            hi(z);
            return;
        }
        this.dZT.clear();
        this.dZT.addAll(list);
        this.dZQ.setVisibility(8);
        this.mListView.setNextPage(this.dZL);
        this.dZR.setData(list);
        aGb();
        this.dZP.setVisibility(0);
        this.dZP.setText(e.j.say_your_point);
        hi(z);
    }

    public void a(boolean z, String str, d dVar) {
        nd(8);
        if (z && dVar != null) {
            BdToast.a(this.dZr.getPageContext().getPageActivity(), this.dZr.getPageContext().getString(e.j.subpb_add_comment_succ_tip), 1).BN();
            this.dZN.setText((CharSequence) null);
            this.dZT.add(dVar);
            this.dZR.setData(this.dZT);
            hi(this.hasMore);
            this.dZN.post(new Runnable() { // from class: com.baidu.tieba.frs.gamesubpb.view.a.2
                @Override // java.lang.Runnable
                public void run() {
                    a.this.dZN.requestFocus();
                    l.b(a.this.dZr.getPageContext().getPageActivity(), a.this.dZN);
                }
            });
            return;
        }
        if (TextUtils.isEmpty(str)) {
            str = this.dZr.getPageContext().getString(e.j.subpb_add_comment_fail_tip);
        }
        BdToast.a(this.dZr.getPageContext().getPageActivity(), str, 1).BN();
    }

    public void b(boolean z, String str, d dVar) {
        if (z) {
            BdToast.a(this.dZr.getPageContext().getPageActivity(), this.dZr.getPageContext().getString(e.j.subpb_delete_comment_succ_tip), 1).BN();
            this.dZT.remove(dVar);
            this.dZR.setData(this.dZT);
            hi(this.hasMore);
            return;
        }
        if (TextUtils.isEmpty(str)) {
            str = this.dZr.getPageContext().getString(e.j.subpb_delete_comment_fail_tip);
        }
        BdToast.a(this.dZr.getPageContext().getPageActivity(), str, 1).BN();
    }

    public void hj(boolean z) {
        if (this.dxd != null && this.dxd.getLayoutParams() != null) {
            ViewGroup.LayoutParams layoutParams = this.dxd.getLayoutParams();
            if (z) {
                aGb();
                layoutParams.height = l.h(this.dZr.getPageContext().getPageActivity(), e.C0210e.ds98);
            } else {
                layoutParams.height = l.h(this.dZr.getPageContext().getPageActivity(), e.C0210e.ds98) + UtilHelper.getLightStatusBarHeight();
            }
            this.dxd.setLayoutParams(layoutParams);
        }
    }

    public void aT(View view) {
        if (this.dxd != null && this.mNavigationBar != null) {
            if (this.mNavigationBar.isNavigationBarExcludeStatusbarVisible()) {
                this.mNavigationBar.showNavigationBarExcludeStatusbar(false);
                if (UtilHelper.canUseStyleImmersiveSticky()) {
                    this.dxd.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight()));
                } else if (this.mListView != null) {
                    this.mListView.removeHeaderView(this.dxd);
                }
                this.mNavigationBar.setVisibility(8);
                return;
            }
            this.mNavigationBar.showNavigationBarExcludeStatusbar(true);
            if (UtilHelper.canUseStyleImmersiveSticky()) {
                this.dxd.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + l.h(this.dZr.getActivity(), e.C0210e.ds98)));
            } else if (this.mListView != null) {
                this.mListView.addHeaderView(this.dxd, 0);
            }
            this.mNavigationBar.setVisibility(0);
        }
    }

    public void ou(String str) {
        this.dZP.setVisibility(8);
        this.bap.setVisibility(0);
        this.dZN.post(new Runnable() { // from class: com.baidu.tieba.frs.gamesubpb.view.a.3
            @Override // java.lang.Runnable
            public void run() {
                a.this.dZN.requestFocus();
                l.c(a.this.dZr.getPageContext().getPageActivity(), a.this.dZN);
            }
        });
        if (!TextUtils.isEmpty(str)) {
            String format = String.format(this.dZr.getPageContext().getPageActivity().getResources().getString(e.j.reply_sub_floor), str);
            this.dZN.setText(format);
            this.dZN.setSelection(format.length());
        }
    }

    public void nd(int i) {
        this.mProgressBar.setVisibility(i);
    }

    public View aGc() {
        return this.dxd;
    }

    public View getRootView() {
        return this.mRootView;
    }

    public ListView getListView() {
        return this.mListView;
    }

    public TextView aGd() {
        return this.dZP;
    }

    public NavigationBar abW() {
        return this.mNavigationBar;
    }

    public void e(com.baidu.tieba.frs.gamesubpb.c cVar) {
        this.dZb = cVar;
    }

    public void a(BdListView.e eVar) {
        this.mListView.setOnSrollToBottomListener(eVar);
    }

    public void onChangeSkinType(int i) {
        this.dZr.getLayoutMode().setNightMode(i == 1);
        this.dZr.getLayoutMode().onModeChanged(this.mRootView);
        al.j(this.mRootView, e.d.cp_bg_line_d);
        this.mNavigationBar.onChangeSkinType(this.dZr.getPageContext(), i);
        this.dZL.ey(i);
        al.h(this.dZP, e.d.cp_cont_e);
        this.dZP.setAlpha(0.95f);
        al.i(this.dZP, e.f.pb_ecomm_comment_bg);
        al.h(this.dZQ, e.d.cp_cont_d);
        al.i(this.bap, e.f.pb_ecomm_comment_bg);
        al.h(this.dZN, e.d.cp_cont_f);
        this.dZN.setHintTextColor(al.getColor(e.d.cp_cont_e));
        al.h(this.dZO, e.d.game_sub_pb_send_txt_color);
    }

    public void onDestroy() {
        if (this.globalListener != null) {
            this.dZr.getPageContext().getPageActivity().getWindow().getDecorView().getViewTreeObserver().removeGlobalOnLayoutListener(this.globalListener);
        }
    }
}
