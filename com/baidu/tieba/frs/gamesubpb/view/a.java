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
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PersonPolymericActivityConfig;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tbadk.util.ab;
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
    private View cfi;
    private c clA = new c(new c.a() { // from class: com.baidu.tieba.frs.gamesubpb.view.a.1
        @Override // com.baidu.tieba.pb.a.c.a
        public boolean b(View view, MotionEvent motionEvent) {
            a.this.kB(false);
            a.this.bW(view);
            a.this.kB(true);
            return true;
        }

        @Override // com.baidu.tieba.pb.a.c.a
        public boolean c(View view, MotionEvent motionEvent) {
            return false;
        }

        @Override // com.baidu.tieba.pb.a.c.a
        public boolean d(View view, MotionEvent motionEvent) {
            return true;
        }
    });
    private LinearLayout cuf;
    private long dsk;
    private e fJO;
    private FrameLayout fJP;
    private EditText fJQ;
    private TextView fJR;
    private TextView fJS;
    private TextView fJT;
    private com.baidu.tieba.frs.gamesubpb.b fJU;
    private com.baidu.tieba.frs.gamesubpb.model.b fJV;
    private List<m> fJW;
    private String fJX;
    private com.baidu.tieba.frs.gamesubpb.c fJe;
    private String fJi;
    private FrsGameSubPbActivity fJu;
    private View fgA;
    private ViewTreeObserver.OnGlobalLayoutListener globalListener;
    private boolean hasMore;
    private View.OnClickListener mCommonClickListener;
    private boolean mIsKeyboardOpen;
    private BdTypeListView mListView;
    private NavigationBar mNavigationBar;
    private ProgressBar mProgressBar;
    private RelativeLayout mRootView;

    public a(FrsGameSubPbActivity frsGameSubPbActivity, View.OnClickListener onClickListener, String str) {
        this.fJu = frsGameSubPbActivity;
        this.mCommonClickListener = onClickListener;
        this.fJi = str;
        this.mRootView = (RelativeLayout) LayoutInflater.from(frsGameSubPbActivity.getPageContext().getPageActivity()).inflate(R.layout.frs_game_sub_pb_activity, (ViewGroup) null);
        this.mListView = (BdTypeListView) this.mRootView.findViewById(R.id.new_sub_pb_list);
        this.mListView.setOnTouchListener(this.clA);
        this.mListView.setOnScrollListener(new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.frs.gamesubpb.view.a.4
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
                if (i != 0) {
                    l.b(a.this.fJu.getPageContext().getPageActivity(), a.this.fJQ);
                }
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            }
        });
        this.fJO = new e(this.fJu.getPageContext());
        this.fgA = BdListViewHelper.a(this.fJu.getActivity(), this.mListView, BdListViewHelper.HeadType.DEFAULT);
        this.fJS = (TextView) this.mRootView.findViewById(R.id.subpb_editor_tool_comment_reply_text);
        this.fJS.setOnClickListener(this.mCommonClickListener);
        this.fJT = (TextView) this.mRootView.findViewById(R.id.no_reply_list_view);
        this.fJP = (FrameLayout) this.mRootView.findViewById(R.id.bottom_view);
        this.cuf = (LinearLayout) this.mRootView.findViewById(R.id.subpb_editor_tool_comment_input_container);
        this.fJQ = (EditText) this.mRootView.findViewById(R.id.subpb_editor_tool_comment_input_edit);
        this.fJR = (TextView) this.mRootView.findViewById(R.id.subpb_editor_tool_comment_send_tv);
        this.fJR.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.gamesubpb.view.a.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.xj(a.this.fJQ.getText().toString());
            }
        });
        this.mProgressBar = (ProgressBar) this.mRootView.findViewById(R.id.progressBar);
        bqs();
        this.fJU = new com.baidu.tieba.frs.gamesubpb.b(this.fJu.getPageContext(), this.mListView);
        this.fJU.setClickListener(new a.InterfaceC0314a() { // from class: com.baidu.tieba.frs.gamesubpb.view.a.6
            @Override // com.baidu.tieba.frs.gamesubpb.a.InterfaceC0314a
            public void a(d dVar) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonPolymericActivityConfig(a.this.fJu.getPageContext().getPageActivity()).createNormalConfig(Long.valueOf(dVar.userId).longValue(), String.valueOf(a.this.dsk).equals(dVar.userId), false)));
            }

            @Override // com.baidu.tieba.frs.gamesubpb.a.InterfaceC0314a
            public void b(d dVar) {
                if (dVar != null) {
                    a.this.d(dVar);
                }
            }

            @Override // com.baidu.tieba.frs.gamesubpb.a.InterfaceC0314a
            public void c(d dVar) {
                if (a.this.fJe != null) {
                    a.this.fJe.bqk();
                }
                if (dVar == null) {
                    a.this.xk(null);
                    a.this.bqu();
                    return;
                }
                a.this.xk(dVar.userName);
                a.this.fJX = dVar.userId;
            }
        });
        so(140);
        bqt();
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        this.fJW = new ArrayList();
        this.dsk = com.baidu.adp.lib.g.b.c(TbadkCoreApplication.getCurrentAccount(), 0L);
    }

    private void bqs() {
        this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(R.id.view_navigation_bar);
        this.cfi = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        ImageView backImageView = this.mNavigationBar.getBackImageView();
        if (backImageView != null && (backImageView.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.cfi.getLayoutParams();
            int g = l.g(this.fJu.getPageContext().getPageActivity(), R.dimen.ds30);
            layoutParams.height = g;
            layoutParams.width = g;
            backImageView.setLayoutParams(layoutParams);
        }
        if (this.cfi != null && (this.cfi.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.cfi.getLayoutParams();
            layoutParams2.width = -2;
            layoutParams2.height = -1;
            this.cfi.setPadding(l.g(this.fJu.getPageContext().getPageActivity(), R.dimen.ds32), this.cfi.getPaddingTop(), this.cfi.getPaddingRight(), this.cfi.getPaddingBottom());
            this.cfi.setLayoutParams(layoutParams2);
        }
        this.mNavigationBar.setmBackImageViewBg(R.drawable.subpb_navigationbar_back, R.drawable.subpb_navigationbar_back);
    }

    private void bqt() {
        this.globalListener = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tieba.frs.gamesubpb.view.a.7
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                Rect rect = new Rect();
                a.this.fJu.getPageContext().getPageActivity().getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
                int u = l.u(a.this.fJu.getPageContext().getPageActivity());
                int[] aj = l.aj(a.this.fJu.getPageContext().getPageActivity());
                if (aj[1] - rect.bottom > aj[1] / 4 && !a.this.mIsKeyboardOpen) {
                    a.this.mIsKeyboardOpen = true;
                    a.this.onKeyboardVisibilityChanged(true);
                } else if (aj[1] - rect.height() == u && a.this.mIsKeyboardOpen) {
                    a.this.mIsKeyboardOpen = false;
                    a.this.onKeyboardVisibilityChanged(false);
                }
            }
        };
        this.fJu.getPageContext().getPageActivity().getWindow().getDecorView().getViewTreeObserver().addOnGlobalLayoutListener(this.globalListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(final d dVar) {
        final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.fJu.getPageContext().getPageActivity());
        aVar.mN(null);
        aVar.hu(R.string.del_post_confirm);
        aVar.dR(true);
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
        aVar.b(this.fJu.getPageContext()).agK();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(d dVar) {
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_DELETE_SUB_COMMENT);
        httpMessage.addParam("user_id", this.dsk);
        httpMessage.addParam("main_tower_id", dVar.fJK);
        httpMessage.addParam("id", dVar.id);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xj(String str) {
        sp(0);
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_ADD_SUB_COMMENT);
        httpMessage.addParam("user_id", this.dsk);
        httpMessage.addParam("reply_user_id", this.fJX);
        httpMessage.addParam("content", str);
        httpMessage.addParam("main_tower_id", this.fJi);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bqu() {
        this.fJX = this.fJV != null ? this.fJV.userId : null;
    }

    private void bqv() {
        if (!v.aa(this.fJW)) {
            this.mNavigationBar.setCenterTextTitle(String.format(this.fJu.getResources().getString(R.string.subpb_floor_reply_count), aq.aM(this.fJW.size())));
        } else {
            this.mNavigationBar.setCenterTextTitle(this.fJu.getResources().getString(R.string.reply));
        }
    }

    private void so(final int i) {
        this.fJQ.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.frs.gamesubpb.view.a.10
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                if (!TextUtils.isEmpty(charSequence)) {
                    a.this.fJR.setEnabled(true);
                    String charSequence2 = charSequence.toString();
                    if (!StringUtils.isNull(charSequence2) && ab.rn(charSequence2) > i) {
                        String p = ab.p(charSequence2, 0, i - 1);
                        a.this.fJQ.setText(p);
                        a.this.fJQ.setSelection(a.this.fJQ.getText().length());
                        UtilHelper.showToast(a.this.fJu.getPageContext().getPageActivity().getApplication(), a.this.fJu.getPageContext().getPageActivity().getResources().getString(R.string.edit_text_over_limit_tip, Integer.valueOf(p.length())));
                        return;
                    }
                    return;
                }
                a.this.bqu();
                a.this.fJR.setEnabled(false);
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
            }
        });
    }

    private void bqw() {
        this.mNavigationBar.setmBackImageViewBg(R.drawable.subpb_navigationbar_close, R.drawable.subpb_navigationbar_close);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void kB(final boolean z) {
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
            this.cuf.getWindowVisibleDisplayFrame(rect);
            this.fJP.scrollTo(this.fJP.getScrollX(), (l.aj(this.fJu.getPageContext().getPageActivity())[1] - rect.bottom) - (MenuKeyUtils.hasSmartBar() ? l.dip2px(this.fJu.getPageContext().getPageActivity(), 48.0f) : 0));
            return;
        }
        this.fJP.setScrollY(0);
    }

    private void kC(boolean z) {
        if (v.aa(this.fJW)) {
            this.mListView.setNextPage(null);
            this.fJT.setVisibility(0);
        } else {
            this.mListView.setNextPage(this.fJO);
            this.fJT.setVisibility(8);
            if (z) {
                this.fJO.akF();
            } else {
                this.fJO.akG();
            }
        }
        bqv();
    }

    public void a(boolean z, com.baidu.tieba.frs.gamesubpb.model.b bVar, List<m> list) {
        this.hasMore = z;
        this.fJV = bVar;
        bqu();
        if (v.aa(list)) {
            kC(z);
            return;
        }
        this.fJW.clear();
        this.fJW.addAll(list);
        this.fJT.setVisibility(8);
        this.mListView.setNextPage(this.fJO);
        this.fJU.setData(list);
        bqw();
        this.fJS.setVisibility(0);
        this.fJS.setText(R.string.say_your_point);
        kC(z);
    }

    public void a(boolean z, String str, d dVar) {
        sp(8);
        if (z && dVar != null) {
            BdToast.b(this.fJu.getPageContext().getPageActivity(), this.fJu.getPageContext().getString(R.string.subpb_add_comment_succ_tip), 1).agS();
            this.fJQ.setText((CharSequence) null);
            this.fJW.add(dVar);
            this.fJU.setData(this.fJW);
            kC(this.hasMore);
            this.fJQ.post(new Runnable() { // from class: com.baidu.tieba.frs.gamesubpb.view.a.2
                @Override // java.lang.Runnable
                public void run() {
                    a.this.fJQ.requestFocus();
                    l.b(a.this.fJu.getPageContext().getPageActivity(), a.this.fJQ);
                }
            });
            return;
        }
        if (TextUtils.isEmpty(str)) {
            str = this.fJu.getPageContext().getString(R.string.subpb_add_comment_fail_tip);
        }
        BdToast.b(this.fJu.getPageContext().getPageActivity(), str, 1).agS();
    }

    public void b(boolean z, String str, d dVar) {
        if (z) {
            BdToast.b(this.fJu.getPageContext().getPageActivity(), this.fJu.getPageContext().getString(R.string.subpb_delete_comment_succ_tip), 1).agS();
            this.fJW.remove(dVar);
            this.fJU.setData(this.fJW);
            kC(this.hasMore);
            return;
        }
        if (TextUtils.isEmpty(str)) {
            str = this.fJu.getPageContext().getString(R.string.subpb_delete_comment_fail_tip);
        }
        BdToast.b(this.fJu.getPageContext().getPageActivity(), str, 1).agS();
    }

    public void kD(boolean z) {
        if (this.fgA != null && this.fgA.getLayoutParams() != null) {
            ViewGroup.LayoutParams layoutParams = this.fgA.getLayoutParams();
            if (z) {
                bqw();
                layoutParams.height = l.g(this.fJu.getPageContext().getPageActivity(), R.dimen.ds98);
            } else {
                layoutParams.height = l.g(this.fJu.getPageContext().getPageActivity(), R.dimen.ds98) + UtilHelper.getLightStatusBarHeight();
            }
            this.fgA.setLayoutParams(layoutParams);
        }
    }

    public void bW(View view) {
        if (this.fgA != null && this.mNavigationBar != null) {
            if (this.mNavigationBar.isNavigationBarExcludeStatusbarVisible()) {
                this.mNavigationBar.showNavigationBarExcludeStatusbar(false);
                if (UtilHelper.canUseStyleImmersiveSticky()) {
                    this.fgA.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight()));
                } else if (this.mListView != null) {
                    this.mListView.removeHeaderView(this.fgA);
                }
                this.mNavigationBar.setVisibility(8);
                return;
            }
            this.mNavigationBar.showNavigationBarExcludeStatusbar(true);
            if (UtilHelper.canUseStyleImmersiveSticky()) {
                this.fgA.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + l.g(this.fJu.getActivity(), R.dimen.ds98)));
            } else if (this.mListView != null) {
                this.mListView.addHeaderView(this.fgA, 0);
            }
            this.mNavigationBar.setVisibility(0);
        }
    }

    public void xk(String str) {
        this.fJS.setVisibility(8);
        this.cuf.setVisibility(0);
        this.fJQ.post(new Runnable() { // from class: com.baidu.tieba.frs.gamesubpb.view.a.3
            @Override // java.lang.Runnable
            public void run() {
                a.this.fJQ.requestFocus();
                l.c(a.this.fJu.getPageContext().getPageActivity(), a.this.fJQ);
            }
        });
        if (!TextUtils.isEmpty(str)) {
            String format = String.format(this.fJu.getPageContext().getPageActivity().getResources().getString(R.string.reply_sub_floor), str);
            this.fJQ.setText(format);
            this.fJQ.setSelection(format.length());
        }
    }

    public void sp(int i) {
        this.mProgressBar.setVisibility(i);
    }

    public View bqx() {
        return this.fgA;
    }

    public View getRootView() {
        return this.mRootView;
    }

    public ListView getListView() {
        return this.mListView;
    }

    public TextView bqy() {
        return this.fJS;
    }

    public NavigationBar aLj() {
        return this.mNavigationBar;
    }

    public void e(com.baidu.tieba.frs.gamesubpb.c cVar) {
        this.fJe = cVar;
    }

    public void b(BdListView.e eVar) {
        this.mListView.setOnSrollToBottomListener(eVar);
    }

    public void onChangeSkinType(int i) {
        this.fJu.getLayoutMode().setNightMode(i == 1);
        this.fJu.getLayoutMode().onModeChanged(this.mRootView);
        am.l(this.mRootView, R.color.cp_bg_line_d);
        this.mNavigationBar.onChangeSkinType(this.fJu.getPageContext(), i);
        this.fJO.iV(i);
        am.j(this.fJS, R.color.cp_cont_e);
        this.fJS.setAlpha(0.95f);
        am.k(this.fJS, R.drawable.pb_ecomm_comment_bg);
        am.j(this.fJT, R.color.cp_cont_d);
        am.k(this.cuf, R.drawable.pb_ecomm_comment_bg);
        am.j(this.fJQ, R.color.cp_cont_f);
        this.fJQ.setHintTextColor(am.getColor(R.color.cp_cont_e));
        am.j(this.fJR, R.color.game_sub_pb_send_txt_color);
    }

    public void onDestroy() {
        if (this.globalListener != null) {
            this.fJu.getPageContext().getPageActivity().getWindow().getDecorView().getViewTreeObserver().removeGlobalOnLayoutListener(this.globalListener);
        }
    }
}
