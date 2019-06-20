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
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.ap;
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
    private View cdY;
    private c ckh = new c(new c.a() { // from class: com.baidu.tieba.frs.gamesubpb.view.a.1
        @Override // com.baidu.tieba.pb.a.c.a
        public boolean b(View view, MotionEvent motionEvent) {
            a.this.kr(false);
            a.this.bT(view);
            a.this.kr(true);
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
    private LinearLayout csL;
    private long dpV;
    private FrsGameSubPbActivity fDI;
    private com.baidu.tieba.frs.gamesubpb.c fDs;
    private String fDw;
    private e fEc;
    private FrameLayout fEd;
    private EditText fEe;
    private TextView fEf;
    private TextView fEg;
    private TextView fEh;
    private com.baidu.tieba.frs.gamesubpb.b fEi;
    private com.baidu.tieba.frs.gamesubpb.model.b fEj;
    private List<m> fEk;
    private String fEl;
    private View fba;
    private ViewTreeObserver.OnGlobalLayoutListener globalListener;
    private boolean hasMore;
    private View.OnClickListener mCommonClickListener;
    private boolean mIsKeyboardOpen;
    private BdTypeListView mListView;
    private NavigationBar mNavigationBar;
    private ProgressBar mProgressBar;
    private RelativeLayout mRootView;

    public a(FrsGameSubPbActivity frsGameSubPbActivity, View.OnClickListener onClickListener, String str) {
        this.fDI = frsGameSubPbActivity;
        this.mCommonClickListener = onClickListener;
        this.fDw = str;
        this.mRootView = (RelativeLayout) LayoutInflater.from(frsGameSubPbActivity.getPageContext().getPageActivity()).inflate(R.layout.frs_game_sub_pb_activity, (ViewGroup) null);
        this.mListView = (BdTypeListView) this.mRootView.findViewById(R.id.new_sub_pb_list);
        this.mListView.setOnTouchListener(this.ckh);
        this.mListView.setOnScrollListener(new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.frs.gamesubpb.view.a.4
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
                if (i != 0) {
                    l.b(a.this.fDI.getPageContext().getPageActivity(), a.this.fEe);
                }
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            }
        });
        this.fEc = new e(this.fDI.getPageContext());
        this.fba = BdListViewHelper.a(this.fDI.getActivity(), this.mListView, BdListViewHelper.HeadType.DEFAULT);
        this.fEg = (TextView) this.mRootView.findViewById(R.id.subpb_editor_tool_comment_reply_text);
        this.fEg.setOnClickListener(this.mCommonClickListener);
        this.fEh = (TextView) this.mRootView.findViewById(R.id.no_reply_list_view);
        this.fEd = (FrameLayout) this.mRootView.findViewById(R.id.bottom_view);
        this.csL = (LinearLayout) this.mRootView.findViewById(R.id.subpb_editor_tool_comment_input_container);
        this.fEe = (EditText) this.mRootView.findViewById(R.id.subpb_editor_tool_comment_input_edit);
        this.fEf = (TextView) this.mRootView.findViewById(R.id.subpb_editor_tool_comment_send_tv);
        this.fEf.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.gamesubpb.view.a.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.wD(a.this.fEe.getText().toString());
            }
        });
        this.mProgressBar = (ProgressBar) this.mRootView.findViewById(R.id.progressBar);
        boe();
        this.fEi = new com.baidu.tieba.frs.gamesubpb.b(this.fDI.getPageContext(), this.mListView);
        this.fEi.setClickListener(new a.InterfaceC0311a() { // from class: com.baidu.tieba.frs.gamesubpb.view.a.6
            @Override // com.baidu.tieba.frs.gamesubpb.a.InterfaceC0311a
            public void a(d dVar) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonPolymericActivityConfig(a.this.fDI.getPageContext().getPageActivity()).createNormalConfig(Long.valueOf(dVar.userId).longValue(), String.valueOf(a.this.dpV).equals(dVar.userId), false)));
            }

            @Override // com.baidu.tieba.frs.gamesubpb.a.InterfaceC0311a
            public void b(d dVar) {
                if (dVar != null) {
                    a.this.d(dVar);
                }
            }

            @Override // com.baidu.tieba.frs.gamesubpb.a.InterfaceC0311a
            public void c(d dVar) {
                if (a.this.fDs != null) {
                    a.this.fDs.bnW();
                }
                if (dVar == null) {
                    a.this.wE(null);
                    a.this.bog();
                    return;
                }
                a.this.wE(dVar.userName);
                a.this.fEl = dVar.userId;
            }
        });
        rU(140);
        bof();
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        this.fEk = new ArrayList();
        this.dpV = com.baidu.adp.lib.g.b.c(TbadkCoreApplication.getCurrentAccount(), 0L);
    }

    private void boe() {
        this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(R.id.view_navigation_bar);
        this.cdY = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        ImageView backImageView = this.mNavigationBar.getBackImageView();
        if (backImageView != null && (backImageView.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.cdY.getLayoutParams();
            int g = l.g(this.fDI.getPageContext().getPageActivity(), R.dimen.ds30);
            layoutParams.height = g;
            layoutParams.width = g;
            backImageView.setLayoutParams(layoutParams);
        }
        if (this.cdY != null && (this.cdY.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.cdY.getLayoutParams();
            layoutParams2.width = -2;
            layoutParams2.height = -1;
            this.cdY.setPadding(l.g(this.fDI.getPageContext().getPageActivity(), R.dimen.ds32), this.cdY.getPaddingTop(), this.cdY.getPaddingRight(), this.cdY.getPaddingBottom());
            this.cdY.setLayoutParams(layoutParams2);
        }
        this.mNavigationBar.setmBackImageViewBg(R.drawable.subpb_navigationbar_back, R.drawable.subpb_navigationbar_back);
    }

    private void bof() {
        this.globalListener = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tieba.frs.gamesubpb.view.a.7
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                Rect rect = new Rect();
                a.this.fDI.getPageContext().getPageActivity().getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
                int r = l.r(a.this.fDI.getPageContext().getPageActivity());
                int[] aj = l.aj(a.this.fDI.getPageContext().getPageActivity());
                if (aj[1] - rect.bottom > aj[1] / 4 && !a.this.mIsKeyboardOpen) {
                    a.this.mIsKeyboardOpen = true;
                    a.this.onKeyboardVisibilityChanged(true);
                } else if (aj[1] - rect.height() == r && a.this.mIsKeyboardOpen) {
                    a.this.mIsKeyboardOpen = false;
                    a.this.onKeyboardVisibilityChanged(false);
                }
            }
        };
        this.fDI.getPageContext().getPageActivity().getWindow().getDecorView().getViewTreeObserver().addOnGlobalLayoutListener(this.globalListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(final d dVar) {
        final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.fDI.getPageContext().getPageActivity());
        aVar.mC(null);
        aVar.ho(R.string.del_post_confirm);
        aVar.dN(true);
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
        aVar.b(this.fDI.getPageContext()).afG();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(d dVar) {
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_DELETE_SUB_COMMENT);
        httpMessage.addParam("user_id", this.dpV);
        httpMessage.addParam("main_tower_id", dVar.fDY);
        httpMessage.addParam("id", dVar.id);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void wD(String str) {
        rV(0);
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_ADD_SUB_COMMENT);
        httpMessage.addParam("user_id", this.dpV);
        httpMessage.addParam("reply_user_id", this.fEl);
        httpMessage.addParam("content", str);
        httpMessage.addParam("main_tower_id", this.fDw);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bog() {
        this.fEl = this.fEj != null ? this.fEj.userId : null;
    }

    private void boh() {
        if (!v.aa(this.fEk)) {
            this.mNavigationBar.setCenterTextTitle(String.format(this.fDI.getResources().getString(R.string.subpb_floor_reply_count), ap.aL(this.fEk.size())));
        } else {
            this.mNavigationBar.setCenterTextTitle(this.fDI.getResources().getString(R.string.reply));
        }
    }

    private void rU(final int i) {
        this.fEe.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.frs.gamesubpb.view.a.10
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                if (!TextUtils.isEmpty(charSequence)) {
                    a.this.fEf.setEnabled(true);
                    String charSequence2 = charSequence.toString();
                    if (!StringUtils.isNull(charSequence2) && ab.qV(charSequence2) > i) {
                        String p = ab.p(charSequence2, 0, i - 1);
                        a.this.fEe.setText(p);
                        a.this.fEe.setSelection(a.this.fEe.getText().length());
                        UtilHelper.showToast(a.this.fDI.getPageContext().getPageActivity().getApplication(), a.this.fDI.getPageContext().getPageActivity().getResources().getString(R.string.edit_text_over_limit_tip, Integer.valueOf(p.length())));
                        return;
                    }
                    return;
                }
                a.this.bog();
                a.this.fEf.setEnabled(false);
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
            }
        });
    }

    private void boi() {
        this.mNavigationBar.setmBackImageViewBg(R.drawable.subpb_navigationbar_close, R.drawable.subpb_navigationbar_close);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void kr(final boolean z) {
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
            this.csL.getWindowVisibleDisplayFrame(rect);
            this.fEd.scrollTo(this.fEd.getScrollX(), (l.aj(this.fDI.getPageContext().getPageActivity())[1] - rect.bottom) - (MenuKeyUtils.hasSmartBar() ? l.dip2px(this.fDI.getPageContext().getPageActivity(), 48.0f) : 0));
            return;
        }
        this.fEd.setScrollY(0);
    }

    private void ks(boolean z) {
        if (v.aa(this.fEk)) {
            this.mListView.setNextPage(null);
            this.fEh.setVisibility(0);
        } else {
            this.mListView.setNextPage(this.fEc);
            this.fEh.setVisibility(8);
            if (z) {
                this.fEc.ajy();
            } else {
                this.fEc.ajz();
            }
        }
        boh();
    }

    public void a(boolean z, com.baidu.tieba.frs.gamesubpb.model.b bVar, List<m> list) {
        this.hasMore = z;
        this.fEj = bVar;
        bog();
        if (v.aa(list)) {
            ks(z);
            return;
        }
        this.fEk.clear();
        this.fEk.addAll(list);
        this.fEh.setVisibility(8);
        this.mListView.setNextPage(this.fEc);
        this.fEi.setData(list);
        boi();
        this.fEg.setVisibility(0);
        this.fEg.setText(R.string.say_your_point);
        ks(z);
    }

    public void a(boolean z, String str, d dVar) {
        rV(8);
        if (z && dVar != null) {
            BdToast.b(this.fDI.getPageContext().getPageActivity(), this.fDI.getPageContext().getString(R.string.subpb_add_comment_succ_tip), 1).afO();
            this.fEe.setText((CharSequence) null);
            this.fEk.add(dVar);
            this.fEi.setData(this.fEk);
            ks(this.hasMore);
            this.fEe.post(new Runnable() { // from class: com.baidu.tieba.frs.gamesubpb.view.a.2
                @Override // java.lang.Runnable
                public void run() {
                    a.this.fEe.requestFocus();
                    l.b(a.this.fDI.getPageContext().getPageActivity(), a.this.fEe);
                }
            });
            return;
        }
        if (TextUtils.isEmpty(str)) {
            str = this.fDI.getPageContext().getString(R.string.subpb_add_comment_fail_tip);
        }
        BdToast.b(this.fDI.getPageContext().getPageActivity(), str, 1).afO();
    }

    public void b(boolean z, String str, d dVar) {
        if (z) {
            BdToast.b(this.fDI.getPageContext().getPageActivity(), this.fDI.getPageContext().getString(R.string.subpb_delete_comment_succ_tip), 1).afO();
            this.fEk.remove(dVar);
            this.fEi.setData(this.fEk);
            ks(this.hasMore);
            return;
        }
        if (TextUtils.isEmpty(str)) {
            str = this.fDI.getPageContext().getString(R.string.subpb_delete_comment_fail_tip);
        }
        BdToast.b(this.fDI.getPageContext().getPageActivity(), str, 1).afO();
    }

    public void kt(boolean z) {
        if (this.fba != null && this.fba.getLayoutParams() != null) {
            ViewGroup.LayoutParams layoutParams = this.fba.getLayoutParams();
            if (z) {
                boi();
                layoutParams.height = l.g(this.fDI.getPageContext().getPageActivity(), R.dimen.ds98);
            } else {
                layoutParams.height = l.g(this.fDI.getPageContext().getPageActivity(), R.dimen.ds98) + UtilHelper.getLightStatusBarHeight();
            }
            this.fba.setLayoutParams(layoutParams);
        }
    }

    public void bT(View view) {
        if (this.fba != null && this.mNavigationBar != null) {
            if (this.mNavigationBar.isNavigationBarExcludeStatusbarVisible()) {
                this.mNavigationBar.showNavigationBarExcludeStatusbar(false);
                if (UtilHelper.canUseStyleImmersiveSticky()) {
                    this.fba.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight()));
                } else if (this.mListView != null) {
                    this.mListView.removeHeaderView(this.fba);
                }
                this.mNavigationBar.setVisibility(8);
                return;
            }
            this.mNavigationBar.showNavigationBarExcludeStatusbar(true);
            if (UtilHelper.canUseStyleImmersiveSticky()) {
                this.fba.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + l.g(this.fDI.getActivity(), R.dimen.ds98)));
            } else if (this.mListView != null) {
                this.mListView.addHeaderView(this.fba, 0);
            }
            this.mNavigationBar.setVisibility(0);
        }
    }

    public void wE(String str) {
        this.fEg.setVisibility(8);
        this.csL.setVisibility(0);
        this.fEe.post(new Runnable() { // from class: com.baidu.tieba.frs.gamesubpb.view.a.3
            @Override // java.lang.Runnable
            public void run() {
                a.this.fEe.requestFocus();
                l.c(a.this.fDI.getPageContext().getPageActivity(), a.this.fEe);
            }
        });
        if (!TextUtils.isEmpty(str)) {
            String format = String.format(this.fDI.getPageContext().getPageActivity().getResources().getString(R.string.reply_sub_floor), str);
            this.fEe.setText(format);
            this.fEe.setSelection(format.length());
        }
    }

    public void rV(int i) {
        this.mProgressBar.setVisibility(i);
    }

    public View boj() {
        return this.fba;
    }

    public View getRootView() {
        return this.mRootView;
    }

    public ListView getListView() {
        return this.mListView;
    }

    public TextView bok() {
        return this.fEg;
    }

    public NavigationBar aJC() {
        return this.mNavigationBar;
    }

    public void e(com.baidu.tieba.frs.gamesubpb.c cVar) {
        this.fDs = cVar;
    }

    public void b(BdListView.e eVar) {
        this.mListView.setOnSrollToBottomListener(eVar);
    }

    public void onChangeSkinType(int i) {
        this.fDI.getLayoutMode().setNightMode(i == 1);
        this.fDI.getLayoutMode().onModeChanged(this.mRootView);
        al.l(this.mRootView, R.color.cp_bg_line_d);
        this.mNavigationBar.onChangeSkinType(this.fDI.getPageContext(), i);
        this.fEc.iP(i);
        al.j(this.fEg, R.color.cp_cont_e);
        this.fEg.setAlpha(0.95f);
        al.k(this.fEg, R.drawable.pb_ecomm_comment_bg);
        al.j(this.fEh, R.color.cp_cont_d);
        al.k(this.csL, R.drawable.pb_ecomm_comment_bg);
        al.j(this.fEe, R.color.cp_cont_f);
        this.fEe.setHintTextColor(al.getColor(R.color.cp_cont_e));
        al.j(this.fEf, R.color.game_sub_pb_send_txt_color);
    }

    public void onDestroy() {
        if (this.globalListener != null) {
            this.fDI.getPageContext().getPageActivity().getWindow().getDecorView().getViewTreeObserver().removeGlobalOnLayoutListener(this.globalListener);
        }
    }
}
