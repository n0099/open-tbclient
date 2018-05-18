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
    private LinearLayout aES;
    private c aWy = new c(new c.a() { // from class: com.baidu.tieba.frs.gamesubpb.view.a.1
        @Override // com.baidu.tieba.pb.a.c.a
        public boolean a(View view2, MotionEvent motionEvent) {
            a.this.fO(false);
            a.this.av(view2);
            a.this.fO(true);
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
    private long bmf;
    private View cOP;
    private com.baidu.tieba.frs.gamesubpb.c dkQ;
    private String dkU;
    private e dlA;
    private FrameLayout dlB;
    private EditText dlC;
    private TextView dlD;
    private TextView dlE;
    private TextView dlF;
    private com.baidu.tieba.frs.gamesubpb.b dlG;
    private com.baidu.tieba.frs.gamesubpb.model.b dlH;
    private List<h> dlI;
    private String dlJ;
    private FrsGameSubPbActivity dlg;
    private ViewTreeObserver.OnGlobalLayoutListener globalListener;
    private boolean hasMore;
    private View.OnClickListener mCommonClickListener;
    private boolean mIsKeyboardOpen;
    private BdTypeListView mListView;
    private NavigationBar mNavigationBar;
    private ProgressBar mProgressBar;
    private RelativeLayout mRootView;

    public a(FrsGameSubPbActivity frsGameSubPbActivity, View.OnClickListener onClickListener, String str) {
        this.dlg = frsGameSubPbActivity;
        this.mCommonClickListener = onClickListener;
        this.dkU = str;
        this.mRootView = (RelativeLayout) LayoutInflater.from(frsGameSubPbActivity.getPageContext().getPageActivity()).inflate(d.i.frs_game_sub_pb_activity, (ViewGroup) null);
        this.mListView = (BdTypeListView) this.mRootView.findViewById(d.g.new_sub_pb_list);
        this.mListView.setOnTouchListener(this.aWy);
        this.mListView.setOnScrollListener(new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.frs.gamesubpb.view.a.4
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
                if (i != 0) {
                    l.b(a.this.dlg.getPageContext().getPageActivity(), a.this.dlC);
                }
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            }
        });
        this.dlA = new e(this.dlg.getPageContext());
        this.cOP = BdListViewHelper.a(this.dlg.getActivity(), this.mListView, BdListViewHelper.HeadType.DEFAULT);
        this.dlE = (TextView) this.mRootView.findViewById(d.g.subpb_editor_tool_comment_reply_text);
        this.dlE.setOnClickListener(this.mCommonClickListener);
        this.dlF = (TextView) this.mRootView.findViewById(d.g.no_reply_list_view);
        this.dlB = (FrameLayout) this.mRootView.findViewById(d.g.bottom_view);
        this.aES = (LinearLayout) this.mRootView.findViewById(d.g.subpb_editor_tool_comment_input_container);
        this.dlC = (EditText) this.mRootView.findViewById(d.g.subpb_editor_tool_comment_input_edit);
        this.dlD = (TextView) this.mRootView.findViewById(d.g.subpb_editor_tool_comment_send_tv);
        this.dlD.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.gamesubpb.view.a.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                a.this.mb(a.this.dlC.getText().toString());
            }
        });
        this.mProgressBar = (ProgressBar) this.mRootView.findViewById(d.g.progressBar);
        atg();
        this.dlG = new com.baidu.tieba.frs.gamesubpb.b(this.dlg.getPageContext(), this.mListView);
        this.dlG.setClickListener(new a.InterfaceC0140a() { // from class: com.baidu.tieba.frs.gamesubpb.view.a.6
            @Override // com.baidu.tieba.frs.gamesubpb.a.InterfaceC0140a
            public void a(com.baidu.tieba.frs.gamesubpb.model.d dVar) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonPolymericActivityConfig(a.this.dlg.getPageContext().getPageActivity()).createNormalConfig(Long.valueOf(dVar.userId).longValue(), String.valueOf(a.this.bmf).equals(dVar.userId), false)));
            }

            @Override // com.baidu.tieba.frs.gamesubpb.a.InterfaceC0140a
            public void b(com.baidu.tieba.frs.gamesubpb.model.d dVar) {
                if (dVar != null) {
                    a.this.d(dVar);
                }
            }

            @Override // com.baidu.tieba.frs.gamesubpb.a.InterfaceC0140a
            public void c(com.baidu.tieba.frs.gamesubpb.model.d dVar) {
                if (a.this.dkQ != null) {
                    a.this.dkQ.asY();
                }
                if (dVar == null) {
                    a.this.mc(null);
                    a.this.ati();
                    return;
                }
                a.this.mc(dVar.userName);
                a.this.dlJ = dVar.userId;
            }
        });
        kL(140);
        ath();
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        this.dlI = new ArrayList();
        this.bmf = com.baidu.adp.lib.g.b.c(TbadkCoreApplication.getCurrentAccount(), 0L);
    }

    private void atg() {
        this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(d.g.view_navigation_bar);
        this.asg = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        ImageView backImageView = this.mNavigationBar.getBackImageView();
        if (backImageView != null && (backImageView.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.asg.getLayoutParams();
            int e = l.e(this.dlg.getPageContext().getPageActivity(), d.e.ds30);
            layoutParams.height = e;
            layoutParams.width = e;
            backImageView.setLayoutParams(layoutParams);
        }
        if (this.asg != null && (this.asg.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.asg.getLayoutParams();
            layoutParams2.width = -2;
            layoutParams2.height = -1;
            this.asg.setPadding(l.e(this.dlg.getPageContext().getPageActivity(), d.e.ds32), this.asg.getPaddingTop(), this.asg.getPaddingRight(), this.asg.getPaddingBottom());
            this.asg.setLayoutParams(layoutParams2);
        }
        this.mNavigationBar.setmBackImageViewBg(d.f.subpb_navigationbar_back, d.f.subpb_navigationbar_back);
    }

    private void ath() {
        this.globalListener = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tieba.frs.gamesubpb.view.a.7
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                Rect rect = new Rect();
                a.this.dlg.getPageContext().getPageActivity().getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
                int p = l.p(a.this.dlg.getPageContext().getPageActivity());
                int[] aj = l.aj(a.this.dlg.getPageContext().getPageActivity());
                if (aj[1] - rect.bottom > aj[1] / 4 && !a.this.mIsKeyboardOpen) {
                    a.this.mIsKeyboardOpen = true;
                    a.this.onKeyboardVisibilityChanged(true);
                } else if (aj[1] - rect.height() == p && a.this.mIsKeyboardOpen) {
                    a.this.mIsKeyboardOpen = false;
                    a.this.onKeyboardVisibilityChanged(false);
                }
            }
        };
        this.dlg.getPageContext().getPageActivity().getWindow().getDecorView().getViewTreeObserver().addOnGlobalLayoutListener(this.globalListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(final com.baidu.tieba.frs.gamesubpb.model.d dVar) {
        final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.dlg.getPageContext().getPageActivity());
        aVar.db(null);
        aVar.ca(d.k.del_post_confirm);
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
        aVar.b(this.dlg.getPageContext()).tC();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(com.baidu.tieba.frs.gamesubpb.model.d dVar) {
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_DELETE_SUB_COMMENT);
        httpMessage.addParam("user_id", this.bmf);
        httpMessage.addParam("main_tower_id", dVar.dlw);
        httpMessage.addParam("id", dVar.id);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mb(String str) {
        kM(0);
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_ADD_SUB_COMMENT);
        httpMessage.addParam("user_id", this.bmf);
        httpMessage.addParam("reply_user_id", this.dlJ);
        httpMessage.addParam("content", str);
        httpMessage.addParam("main_tower_id", this.dkU);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ati() {
        this.dlJ = this.dlH != null ? this.dlH.userId : null;
    }

    private void atj() {
        if (!v.w(this.dlI)) {
            this.mNavigationBar.setCenterTextTitle(String.format(this.dlg.getResources().getString(d.k.subpb_floor_reply_count), an.z(this.dlI.size())));
        } else {
            this.mNavigationBar.setCenterTextTitle(this.dlg.getResources().getString(d.k.reply));
        }
    }

    private void kL(final int i) {
        this.dlC.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.frs.gamesubpb.view.a.10
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                if (!TextUtils.isEmpty(charSequence)) {
                    a.this.dlD.setEnabled(true);
                    String charSequence2 = charSequence.toString();
                    if (!StringUtils.isNull(charSequence2) && w.hl(charSequence2) > i) {
                        String k = w.k(charSequence2, 0, i - 1);
                        a.this.dlC.setText(k);
                        a.this.dlC.setSelection(a.this.dlC.getText().length());
                        UtilHelper.showToast(a.this.dlg.getPageContext().getPageActivity().getApplication(), a.this.dlg.getPageContext().getPageActivity().getResources().getString(d.k.edit_text_over_limit_tip, Integer.valueOf(k.length())));
                        return;
                    }
                    return;
                }
                a.this.ati();
                a.this.dlD.setEnabled(false);
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
            }
        });
    }

    private void atk() {
        this.mNavigationBar.setmBackImageViewBg(d.f.subpb_navigationbar_close, d.f.subpb_navigationbar_close);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fO(final boolean z) {
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
            this.aES.getWindowVisibleDisplayFrame(rect);
            this.dlB.scrollTo(this.dlB.getScrollX(), (l.aj(this.dlg.getPageContext().getPageActivity())[1] - rect.bottom) - (MenuKeyUtils.hasSmartBar() ? l.dip2px(this.dlg.getPageContext().getPageActivity(), 48.0f) : 0));
            return;
        }
        this.dlB.setScrollY(0);
    }

    private void fP(boolean z) {
        if (v.w(this.dlI)) {
            this.mListView.setNextPage(null);
            this.dlF.setVisibility(0);
        } else {
            this.mListView.setNextPage(this.dlA);
            this.dlF.setVisibility(8);
            if (z) {
                this.dlA.wQ();
            } else {
                this.dlA.wR();
            }
        }
        atj();
    }

    public void a(boolean z, com.baidu.tieba.frs.gamesubpb.model.b bVar, List<h> list) {
        this.hasMore = z;
        this.dlH = bVar;
        ati();
        if (v.w(list)) {
            fP(z);
            return;
        }
        this.dlI.clear();
        this.dlI.addAll(list);
        this.dlF.setVisibility(8);
        this.mListView.setNextPage(this.dlA);
        this.dlG.setData(list);
        atk();
        this.dlE.setVisibility(0);
        this.dlE.setText(d.k.say_your_point);
        fP(z);
    }

    public void a(boolean z, String str, com.baidu.tieba.frs.gamesubpb.model.d dVar) {
        kM(8);
        if (z && dVar != null) {
            BdToast.a(this.dlg.getPageContext().getPageActivity(), this.dlg.getPageContext().getString(d.k.subpb_add_comment_succ_tip), 1).tK();
            this.dlC.setText((CharSequence) null);
            this.dlI.add(dVar);
            this.dlG.setData(this.dlI);
            fP(this.hasMore);
            this.dlC.post(new Runnable() { // from class: com.baidu.tieba.frs.gamesubpb.view.a.2
                @Override // java.lang.Runnable
                public void run() {
                    a.this.dlC.requestFocus();
                    l.b(a.this.dlg.getPageContext().getPageActivity(), a.this.dlC);
                }
            });
            return;
        }
        if (TextUtils.isEmpty(str)) {
            str = this.dlg.getPageContext().getString(d.k.subpb_add_comment_fail_tip);
        }
        BdToast.a(this.dlg.getPageContext().getPageActivity(), str, 1).tK();
    }

    public void b(boolean z, String str, com.baidu.tieba.frs.gamesubpb.model.d dVar) {
        if (z) {
            BdToast.a(this.dlg.getPageContext().getPageActivity(), this.dlg.getPageContext().getString(d.k.subpb_delete_comment_succ_tip), 1).tK();
            this.dlI.remove(dVar);
            this.dlG.setData(this.dlI);
            fP(this.hasMore);
            return;
        }
        if (TextUtils.isEmpty(str)) {
            str = this.dlg.getPageContext().getString(d.k.subpb_delete_comment_fail_tip);
        }
        BdToast.a(this.dlg.getPageContext().getPageActivity(), str, 1).tK();
    }

    public void fQ(boolean z) {
        if (this.cOP != null && this.cOP.getLayoutParams() != null) {
            ViewGroup.LayoutParams layoutParams = this.cOP.getLayoutParams();
            if (z) {
                atk();
                layoutParams.height = l.e(this.dlg.getPageContext().getPageActivity(), d.e.ds98);
            } else {
                layoutParams.height = l.e(this.dlg.getPageContext().getPageActivity(), d.e.ds98) + UtilHelper.getLightStatusBarHeight();
            }
            this.cOP.setLayoutParams(layoutParams);
        }
    }

    public void av(View view2) {
        if (this.cOP != null && this.mNavigationBar != null) {
            if (this.mNavigationBar.isNavigationBarExcludeStatusbarVisible()) {
                this.mNavigationBar.showNavigationBarExcludeStatusbar(false);
                if (UtilHelper.canUseStyleImmersiveSticky()) {
                    this.cOP.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight()));
                } else if (this.mListView != null) {
                    this.mListView.removeHeaderView(this.cOP);
                }
                this.mNavigationBar.setVisibility(8);
                return;
            }
            this.mNavigationBar.showNavigationBarExcludeStatusbar(true);
            if (UtilHelper.canUseStyleImmersiveSticky()) {
                this.cOP.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + l.e(this.dlg.getActivity(), d.e.ds98)));
            } else if (this.mListView != null) {
                this.mListView.addHeaderView(this.cOP, 0);
            }
            this.mNavigationBar.setVisibility(0);
        }
    }

    public void mc(String str) {
        this.dlE.setVisibility(8);
        this.aES.setVisibility(0);
        this.dlC.post(new Runnable() { // from class: com.baidu.tieba.frs.gamesubpb.view.a.3
            @Override // java.lang.Runnable
            public void run() {
                a.this.dlC.requestFocus();
                l.c(a.this.dlg.getPageContext().getPageActivity(), a.this.dlC);
            }
        });
        if (!TextUtils.isEmpty(str)) {
            String format = String.format(this.dlg.getPageContext().getPageActivity().getResources().getString(d.k.reply_sub_floor), str);
            this.dlC.setText(format);
            this.dlC.setSelection(format.length());
        }
    }

    public void kM(int i) {
        this.mProgressBar.setVisibility(i);
    }

    public View atl() {
        return this.cOP;
    }

    public View getRootView() {
        return this.mRootView;
    }

    public ListView getListView() {
        return this.mListView;
    }

    public TextView atm() {
        return this.dlE;
    }

    public NavigationBar Rd() {
        return this.mNavigationBar;
    }

    public void e(com.baidu.tieba.frs.gamesubpb.c cVar) {
        this.dkQ = cVar;
    }

    public void a(BdListView.e eVar) {
        this.mListView.setOnSrollToBottomListener(eVar);
    }

    public void onChangeSkinType(int i) {
        this.dlg.getLayoutMode().setNightMode(i == 1);
        this.dlg.getLayoutMode().u(this.mRootView);
        ak.j(this.mRootView, d.C0126d.cp_bg_line_d);
        this.mNavigationBar.onChangeSkinType(this.dlg.getPageContext(), i);
        this.dlA.dw(i);
        ak.h(this.dlE, d.C0126d.cp_cont_e);
        this.dlE.setAlpha(0.95f);
        ak.i(this.dlE, d.f.pb_ecomm_comment_bg);
        ak.h(this.dlF, d.C0126d.cp_cont_d);
        ak.i(this.aES, d.f.pb_ecomm_comment_bg);
        ak.h(this.dlC, d.C0126d.cp_cont_f);
        this.dlC.setHintTextColor(ak.getColor(d.C0126d.cp_cont_e));
        ak.h(this.dlD, d.C0126d.game_sub_pb_send_txt_color);
    }

    public void onDestroy() {
        if (this.globalListener != null) {
            this.dlg.getPageContext().getPageActivity().getWindow().getDecorView().getViewTreeObserver().removeGlobalOnLayoutListener(this.globalListener);
        }
    }
}
