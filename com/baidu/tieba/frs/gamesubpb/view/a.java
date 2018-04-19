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
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tbadk.util.w;
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
    private LinearLayout aER;
    private c aWx = new c(new c.a() { // from class: com.baidu.tieba.frs.gamesubpb.view.a.1
        @Override // com.baidu.tieba.pb.a.c.a
        public boolean a(View view2, MotionEvent motionEvent) {
            a.this.fN(false);
            a.this.av(view2);
            a.this.fN(true);
            return true;
        }

        @Override // com.baidu.tieba.pb.a.c.a
        public boolean b(View view2, MotionEvent motionEvent) {
            return false;
        }

        @Override // com.baidu.tieba.pb.a.c.a
        public boolean c(View view2, MotionEvent motionEvent) {
            return true;
        }
    });
    private View asg;
    private long blQ;
    private View cNL;
    private com.baidu.tieba.frs.gamesubpb.c djM;
    private String djQ;
    private TextView dkA;
    private TextView dkB;
    private com.baidu.tieba.frs.gamesubpb.b dkC;
    private com.baidu.tieba.frs.gamesubpb.model.b dkD;
    private List<h> dkE;
    private String dkF;
    private FrsGameSubPbActivity dkc;
    private e dkw;
    private FrameLayout dkx;
    private EditText dky;
    private TextView dkz;
    private ViewTreeObserver.OnGlobalLayoutListener globalListener;
    private boolean hasMore;
    private View.OnClickListener mCommonClickListener;
    private boolean mIsKeyboardOpen;
    private BdTypeListView mListView;
    private NavigationBar mNavigationBar;
    private ProgressBar mProgressBar;
    private RelativeLayout mRootView;

    public a(FrsGameSubPbActivity frsGameSubPbActivity, View.OnClickListener onClickListener, String str) {
        this.dkc = frsGameSubPbActivity;
        this.mCommonClickListener = onClickListener;
        this.djQ = str;
        this.mRootView = (RelativeLayout) LayoutInflater.from(frsGameSubPbActivity.getPageContext().getPageActivity()).inflate(d.i.frs_game_sub_pb_activity, (ViewGroup) null);
        this.mListView = (BdTypeListView) this.mRootView.findViewById(d.g.new_sub_pb_list);
        this.mListView.setOnTouchListener(this.aWx);
        this.mListView.setOnScrollListener(new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.frs.gamesubpb.view.a.4
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
                if (i != 0) {
                    l.b(a.this.dkc.getPageContext().getPageActivity(), a.this.dky);
                }
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            }
        });
        this.dkw = new e(this.dkc.getPageContext());
        this.cNL = BdListViewHelper.a(this.dkc.getActivity(), this.mListView, BdListViewHelper.HeadType.DEFAULT);
        this.dkA = (TextView) this.mRootView.findViewById(d.g.subpb_editor_tool_comment_reply_text);
        this.dkA.setOnClickListener(this.mCommonClickListener);
        this.dkB = (TextView) this.mRootView.findViewById(d.g.no_reply_list_view);
        this.dkx = (FrameLayout) this.mRootView.findViewById(d.g.bottom_view);
        this.aER = (LinearLayout) this.mRootView.findViewById(d.g.subpb_editor_tool_comment_input_container);
        this.dky = (EditText) this.mRootView.findViewById(d.g.subpb_editor_tool_comment_input_edit);
        this.dkz = (TextView) this.mRootView.findViewById(d.g.subpb_editor_tool_comment_send_tv);
        this.dkz.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.gamesubpb.view.a.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                a.this.lY(a.this.dky.getText().toString());
            }
        });
        this.mProgressBar = (ProgressBar) this.mRootView.findViewById(d.g.progressBar);
        ath();
        this.dkC = new com.baidu.tieba.frs.gamesubpb.b(this.dkc.getPageContext(), this.mListView);
        this.dkC.setClickListener(new a.InterfaceC0140a() { // from class: com.baidu.tieba.frs.gamesubpb.view.a.6
            @Override // com.baidu.tieba.frs.gamesubpb.a.InterfaceC0140a
            public void a(com.baidu.tieba.frs.gamesubpb.model.d dVar) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonPolymericActivityConfig(a.this.dkc.getPageContext().getPageActivity()).createNormalConfig(Long.valueOf(dVar.userId).longValue(), String.valueOf(a.this.blQ).equals(dVar.userId), false)));
            }

            @Override // com.baidu.tieba.frs.gamesubpb.a.InterfaceC0140a
            public void b(com.baidu.tieba.frs.gamesubpb.model.d dVar) {
                if (dVar != null) {
                    a.this.d(dVar);
                }
            }

            @Override // com.baidu.tieba.frs.gamesubpb.a.InterfaceC0140a
            public void c(com.baidu.tieba.frs.gamesubpb.model.d dVar) {
                if (a.this.djM != null) {
                    a.this.djM.asZ();
                }
                if (dVar == null) {
                    a.this.lZ(null);
                    a.this.atj();
                    return;
                }
                a.this.lZ(dVar.userName);
                a.this.dkF = dVar.userId;
            }
        });
        kM(140);
        ati();
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        this.dkE = new ArrayList();
        this.blQ = com.baidu.adp.lib.g.b.c(TbadkCoreApplication.getCurrentAccount(), 0L);
    }

    private void ath() {
        this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(d.g.view_navigation_bar);
        this.asg = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        ImageView backImageView = this.mNavigationBar.getBackImageView();
        if (backImageView != null && (backImageView.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.asg.getLayoutParams();
            int e = l.e(this.dkc.getPageContext().getPageActivity(), d.e.ds30);
            layoutParams.height = e;
            layoutParams.width = e;
            backImageView.setLayoutParams(layoutParams);
        }
        if (this.asg != null && (this.asg.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.asg.getLayoutParams();
            layoutParams2.width = -2;
            layoutParams2.height = -1;
            this.asg.setPadding(l.e(this.dkc.getPageContext().getPageActivity(), d.e.ds32), this.asg.getPaddingTop(), this.asg.getPaddingRight(), this.asg.getPaddingBottom());
            this.asg.setLayoutParams(layoutParams2);
        }
        this.mNavigationBar.setmBackImageViewBg(d.f.subpb_navigationbar_back, d.f.subpb_navigationbar_back);
    }

    private void ati() {
        this.globalListener = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tieba.frs.gamesubpb.view.a.7
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                Rect rect = new Rect();
                a.this.dkc.getPageContext().getPageActivity().getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
                int p = l.p(a.this.dkc.getPageContext().getPageActivity());
                int[] aj = l.aj(a.this.dkc.getPageContext().getPageActivity());
                if (aj[1] - rect.bottom > aj[1] / 4 && !a.this.mIsKeyboardOpen) {
                    a.this.mIsKeyboardOpen = true;
                    a.this.onKeyboardVisibilityChanged(true);
                } else if (aj[1] - rect.height() == p && a.this.mIsKeyboardOpen) {
                    a.this.mIsKeyboardOpen = false;
                    a.this.onKeyboardVisibilityChanged(false);
                }
            }
        };
        this.dkc.getPageContext().getPageActivity().getWindow().getDecorView().getViewTreeObserver().addOnGlobalLayoutListener(this.globalListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(final com.baidu.tieba.frs.gamesubpb.model.d dVar) {
        final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.dkc.getPageContext().getPageActivity());
        aVar.db(null);
        aVar.bZ(d.k.del_post_confirm);
        aVar.as(true);
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
        aVar.b(this.dkc.getPageContext()).tD();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(com.baidu.tieba.frs.gamesubpb.model.d dVar) {
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_DELETE_SUB_COMMENT);
        httpMessage.addParam("user_id", this.blQ);
        httpMessage.addParam("main_tower_id", dVar.dks);
        httpMessage.addParam("id", dVar.id);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lY(String str) {
        kN(0);
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_ADD_SUB_COMMENT);
        httpMessage.addParam("user_id", this.blQ);
        httpMessage.addParam("reply_user_id", this.dkF);
        httpMessage.addParam("content", str);
        httpMessage.addParam("main_tower_id", this.djQ);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void atj() {
        this.dkF = this.dkD != null ? this.dkD.userId : null;
    }

    private void atk() {
        if (!v.w(this.dkE)) {
            this.mNavigationBar.setCenterTextTitle(String.format(this.dkc.getResources().getString(d.k.subpb_floor_reply_count), an.z(this.dkE.size())));
        } else {
            this.mNavigationBar.setCenterTextTitle(this.dkc.getResources().getString(d.k.reply));
        }
    }

    private void kM(final int i) {
        this.dky.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.frs.gamesubpb.view.a.10
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                if (!TextUtils.isEmpty(charSequence)) {
                    a.this.dkz.setEnabled(true);
                    String charSequence2 = charSequence.toString();
                    if (!StringUtils.isNull(charSequence2) && w.hk(charSequence2) > i) {
                        String k = w.k(charSequence2, 0, i - 1);
                        a.this.dky.setText(k);
                        a.this.dky.setSelection(a.this.dky.getText().length());
                        UtilHelper.showToast(a.this.dkc.getPageContext().getPageActivity().getApplication(), a.this.dkc.getPageContext().getPageActivity().getResources().getString(d.k.edit_text_over_limit_tip, Integer.valueOf(k.length())));
                        return;
                    }
                    return;
                }
                a.this.atj();
                a.this.dkz.setEnabled(false);
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
            }
        });
    }

    private void atl() {
        this.mNavigationBar.setmBackImageViewBg(d.f.subpb_navigationbar_close, d.f.subpb_navigationbar_close);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fN(final boolean z) {
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
            this.aER.getWindowVisibleDisplayFrame(rect);
            this.dkx.scrollTo(this.dkx.getScrollX(), (l.aj(this.dkc.getPageContext().getPageActivity())[1] - rect.bottom) - (MenuKeyUtils.hasSmartBar() ? l.dip2px(this.dkc.getPageContext().getPageActivity(), 48.0f) : 0));
            return;
        }
        this.dkx.setScrollY(0);
    }

    private void fO(boolean z) {
        if (v.w(this.dkE)) {
            this.mListView.setNextPage(null);
            this.dkB.setVisibility(0);
        } else {
            this.mListView.setNextPage(this.dkw);
            this.dkB.setVisibility(8);
            if (z) {
                this.dkw.wR();
            } else {
                this.dkw.wS();
            }
        }
        atk();
    }

    public void a(boolean z, com.baidu.tieba.frs.gamesubpb.model.b bVar, List<h> list) {
        this.hasMore = z;
        this.dkD = bVar;
        atj();
        if (v.w(list)) {
            fO(z);
            return;
        }
        this.dkE.clear();
        this.dkE.addAll(list);
        this.dkB.setVisibility(8);
        this.mListView.setNextPage(this.dkw);
        this.dkC.setData(list);
        atl();
        this.dkA.setVisibility(0);
        this.dkA.setText(d.k.say_your_point);
        fO(z);
    }

    public void a(boolean z, String str, com.baidu.tieba.frs.gamesubpb.model.d dVar) {
        kN(8);
        if (z && dVar != null) {
            BdToast.a(this.dkc.getPageContext().getPageActivity(), this.dkc.getPageContext().getString(d.k.subpb_add_comment_succ_tip), 1).tL();
            this.dky.setText((CharSequence) null);
            this.dkE.add(dVar);
            this.dkC.setData(this.dkE);
            fO(this.hasMore);
            this.dky.post(new Runnable() { // from class: com.baidu.tieba.frs.gamesubpb.view.a.2
                @Override // java.lang.Runnable
                public void run() {
                    a.this.dky.requestFocus();
                    l.b(a.this.dkc.getPageContext().getPageActivity(), a.this.dky);
                }
            });
            return;
        }
        if (TextUtils.isEmpty(str)) {
            str = this.dkc.getPageContext().getString(d.k.subpb_add_comment_fail_tip);
        }
        BdToast.a(this.dkc.getPageContext().getPageActivity(), str, 1).tL();
    }

    public void b(boolean z, String str, com.baidu.tieba.frs.gamesubpb.model.d dVar) {
        if (z) {
            BdToast.a(this.dkc.getPageContext().getPageActivity(), this.dkc.getPageContext().getString(d.k.subpb_delete_comment_succ_tip), 1).tL();
            this.dkE.remove(dVar);
            this.dkC.setData(this.dkE);
            fO(this.hasMore);
            return;
        }
        if (TextUtils.isEmpty(str)) {
            str = this.dkc.getPageContext().getString(d.k.subpb_delete_comment_fail_tip);
        }
        BdToast.a(this.dkc.getPageContext().getPageActivity(), str, 1).tL();
    }

    public void fP(boolean z) {
        if (this.cNL != null && this.cNL.getLayoutParams() != null) {
            ViewGroup.LayoutParams layoutParams = this.cNL.getLayoutParams();
            if (z) {
                atl();
                layoutParams.height = l.e(this.dkc.getPageContext().getPageActivity(), d.e.ds98);
            } else {
                layoutParams.height = l.e(this.dkc.getPageContext().getPageActivity(), d.e.ds98) + UtilHelper.getLightStatusBarHeight();
            }
            this.cNL.setLayoutParams(layoutParams);
        }
    }

    public void av(View view2) {
        if (this.cNL != null && this.mNavigationBar != null) {
            if (this.mNavigationBar.isNavigationBarExcludeStatusbarVisible()) {
                this.mNavigationBar.showNavigationBarExcludeStatusbar(false);
                if (UtilHelper.canUseStyleImmersiveSticky()) {
                    this.cNL.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight()));
                } else if (this.mListView != null) {
                    this.mListView.removeHeaderView(this.cNL);
                }
                this.mNavigationBar.setVisibility(8);
                return;
            }
            this.mNavigationBar.showNavigationBarExcludeStatusbar(true);
            if (UtilHelper.canUseStyleImmersiveSticky()) {
                this.cNL.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + l.e(this.dkc.getActivity(), d.e.ds98)));
            } else if (this.mListView != null) {
                this.mListView.addHeaderView(this.cNL, 0);
            }
            this.mNavigationBar.setVisibility(0);
        }
    }

    public void lZ(String str) {
        this.dkA.setVisibility(8);
        this.aER.setVisibility(0);
        this.dky.post(new Runnable() { // from class: com.baidu.tieba.frs.gamesubpb.view.a.3
            @Override // java.lang.Runnable
            public void run() {
                a.this.dky.requestFocus();
                l.c(a.this.dkc.getPageContext().getPageActivity(), a.this.dky);
            }
        });
        if (!TextUtils.isEmpty(str)) {
            String format = String.format(this.dkc.getPageContext().getPageActivity().getResources().getString(d.k.reply_sub_floor), str);
            this.dky.setText(format);
            this.dky.setSelection(format.length());
        }
    }

    public void kN(int i) {
        this.mProgressBar.setVisibility(i);
    }

    public View atm() {
        return this.cNL;
    }

    public View getRootView() {
        return this.mRootView;
    }

    public ListView getListView() {
        return this.mListView;
    }

    public TextView atn() {
        return this.dkA;
    }

    public NavigationBar Rg() {
        return this.mNavigationBar;
    }

    public void e(com.baidu.tieba.frs.gamesubpb.c cVar) {
        this.djM = cVar;
    }

    public void a(BdListView.e eVar) {
        this.mListView.setOnSrollToBottomListener(eVar);
    }

    public void onChangeSkinType(int i) {
        this.dkc.getLayoutMode().setNightMode(i == 1);
        this.dkc.getLayoutMode().u(this.mRootView);
        ak.j(this.mRootView, d.C0126d.cp_bg_line_d);
        this.mNavigationBar.onChangeSkinType(this.dkc.getPageContext(), i);
        this.dkw.dv(i);
        ak.h(this.dkA, d.C0126d.cp_cont_e);
        this.dkA.setAlpha(0.95f);
        ak.i(this.dkA, d.f.pb_ecomm_comment_bg);
        ak.h(this.dkB, d.C0126d.cp_cont_d);
        ak.i(this.aER, d.f.pb_ecomm_comment_bg);
        ak.h(this.dky, d.C0126d.cp_cont_f);
        this.dky.setHintTextColor(ak.getColor(d.C0126d.cp_cont_e));
        ak.h(this.dkz, d.C0126d.game_sub_pb_send_txt_color);
    }

    public void onDestroy() {
        if (this.globalListener != null) {
            this.dkc.getPageContext().getPageActivity().getWindow().getDecorView().getViewTreeObserver().removeGlobalOnLayoutListener(this.globalListener);
        }
    }
}
