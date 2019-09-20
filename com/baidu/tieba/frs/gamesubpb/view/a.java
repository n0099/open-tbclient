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
    private View cgb;
    private c cmw = new c(new c.a() { // from class: com.baidu.tieba.frs.gamesubpb.view.a.1
        @Override // com.baidu.tieba.pb.a.c.a
        public boolean b(View view, MotionEvent motionEvent) {
            a.this.kE(false);
            a.this.bW(view);
            a.this.kE(true);
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
    private LinearLayout cvc;
    private long dtW;
    private com.baidu.tieba.frs.gamesubpb.c fKT;
    private String fKX;
    private e fLD;
    private FrameLayout fLE;
    private EditText fLF;
    private TextView fLG;
    private TextView fLH;
    private TextView fLI;
    private com.baidu.tieba.frs.gamesubpb.b fLJ;
    private com.baidu.tieba.frs.gamesubpb.model.b fLK;
    private List<m> fLL;
    private String fLM;
    private FrsGameSubPbActivity fLj;
    private View fio;
    private ViewTreeObserver.OnGlobalLayoutListener globalListener;
    private boolean hasMore;
    private View.OnClickListener mCommonClickListener;
    private boolean mIsKeyboardOpen;
    private BdTypeListView mListView;
    private NavigationBar mNavigationBar;
    private ProgressBar mProgressBar;
    private RelativeLayout mRootView;

    public a(FrsGameSubPbActivity frsGameSubPbActivity, View.OnClickListener onClickListener, String str) {
        this.fLj = frsGameSubPbActivity;
        this.mCommonClickListener = onClickListener;
        this.fKX = str;
        this.mRootView = (RelativeLayout) LayoutInflater.from(frsGameSubPbActivity.getPageContext().getPageActivity()).inflate(R.layout.frs_game_sub_pb_activity, (ViewGroup) null);
        this.mListView = (BdTypeListView) this.mRootView.findViewById(R.id.new_sub_pb_list);
        this.mListView.setOnTouchListener(this.cmw);
        this.mListView.setOnScrollListener(new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.frs.gamesubpb.view.a.4
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
                if (i != 0) {
                    l.b(a.this.fLj.getPageContext().getPageActivity(), a.this.fLF);
                }
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            }
        });
        this.fLD = new e(this.fLj.getPageContext());
        this.fio = BdListViewHelper.a(this.fLj.getActivity(), this.mListView, BdListViewHelper.HeadType.DEFAULT);
        this.fLH = (TextView) this.mRootView.findViewById(R.id.subpb_editor_tool_comment_reply_text);
        this.fLH.setOnClickListener(this.mCommonClickListener);
        this.fLI = (TextView) this.mRootView.findViewById(R.id.no_reply_list_view);
        this.fLE = (FrameLayout) this.mRootView.findViewById(R.id.bottom_view);
        this.cvc = (LinearLayout) this.mRootView.findViewById(R.id.subpb_editor_tool_comment_input_container);
        this.fLF = (EditText) this.mRootView.findViewById(R.id.subpb_editor_tool_comment_input_edit);
        this.fLG = (TextView) this.mRootView.findViewById(R.id.subpb_editor_tool_comment_send_tv);
        this.fLG.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.gamesubpb.view.a.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.xI(a.this.fLF.getText().toString());
            }
        });
        this.mProgressBar = (ProgressBar) this.mRootView.findViewById(R.id.progressBar);
        bre();
        this.fLJ = new com.baidu.tieba.frs.gamesubpb.b(this.fLj.getPageContext(), this.mListView);
        this.fLJ.setClickListener(new a.InterfaceC0325a() { // from class: com.baidu.tieba.frs.gamesubpb.view.a.6
            @Override // com.baidu.tieba.frs.gamesubpb.a.InterfaceC0325a
            public void a(d dVar) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonPolymericActivityConfig(a.this.fLj.getPageContext().getPageActivity()).createNormalConfig(Long.valueOf(dVar.userId).longValue(), String.valueOf(a.this.dtW).equals(dVar.userId), false)));
            }

            @Override // com.baidu.tieba.frs.gamesubpb.a.InterfaceC0325a
            public void b(d dVar) {
                if (dVar != null) {
                    a.this.d(dVar);
                }
            }

            @Override // com.baidu.tieba.frs.gamesubpb.a.InterfaceC0325a
            public void c(d dVar) {
                if (a.this.fKT != null) {
                    a.this.fKT.bqW();
                }
                if (dVar == null) {
                    a.this.xJ(null);
                    a.this.brg();
                    return;
                }
                a.this.xJ(dVar.userName);
                a.this.fLM = dVar.userId;
            }
        });
        ss(140);
        brf();
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        this.fLL = new ArrayList();
        this.dtW = com.baidu.adp.lib.g.b.e(TbadkCoreApplication.getCurrentAccount(), 0L);
    }

    private void bre() {
        this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(R.id.view_navigation_bar);
        this.cgb = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        ImageView backImageView = this.mNavigationBar.getBackImageView();
        if (backImageView != null && (backImageView.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.cgb.getLayoutParams();
            int g = l.g(this.fLj.getPageContext().getPageActivity(), R.dimen.ds30);
            layoutParams.height = g;
            layoutParams.width = g;
            backImageView.setLayoutParams(layoutParams);
        }
        if (this.cgb != null && (this.cgb.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.cgb.getLayoutParams();
            layoutParams2.width = -2;
            layoutParams2.height = -1;
            this.cgb.setPadding(l.g(this.fLj.getPageContext().getPageActivity(), R.dimen.ds32), this.cgb.getPaddingTop(), this.cgb.getPaddingRight(), this.cgb.getPaddingBottom());
            this.cgb.setLayoutParams(layoutParams2);
        }
        if (this.mNavigationBar.getBackImageView() != null) {
            SvgManager.ajv().a(this.mNavigationBar.getBackImageView(), R.drawable.icon_pure_topbar_return_n_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
    }

    private void brf() {
        this.globalListener = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tieba.frs.gamesubpb.view.a.7
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                Rect rect = new Rect();
                a.this.fLj.getPageContext().getPageActivity().getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
                int u = l.u(a.this.fLj.getPageContext().getPageActivity());
                int[] aj = l.aj(a.this.fLj.getPageContext().getPageActivity());
                if (aj[1] - rect.bottom > aj[1] / 4 && !a.this.mIsKeyboardOpen) {
                    a.this.mIsKeyboardOpen = true;
                    a.this.onKeyboardVisibilityChanged(true);
                } else if (aj[1] - rect.height() == u && a.this.mIsKeyboardOpen) {
                    a.this.mIsKeyboardOpen = false;
                    a.this.onKeyboardVisibilityChanged(false);
                }
            }
        };
        this.fLj.getPageContext().getPageActivity().getWindow().getDecorView().getViewTreeObserver().addOnGlobalLayoutListener(this.globalListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(final d dVar) {
        final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.fLj.getPageContext().getPageActivity());
        aVar.mP(null);
        aVar.hv(R.string.del_post_confirm);
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
        aVar.b(this.fLj.getPageContext()).agO();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(d dVar) {
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_DELETE_SUB_COMMENT);
        httpMessage.addParam("user_id", this.dtW);
        httpMessage.addParam("main_tower_id", dVar.fLz);
        httpMessage.addParam("id", dVar.id);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xI(String str) {
        st(0);
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_ADD_SUB_COMMENT);
        httpMessage.addParam("user_id", this.dtW);
        httpMessage.addParam("reply_user_id", this.fLM);
        httpMessage.addParam("content", str);
        httpMessage.addParam("main_tower_id", this.fKX);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void brg() {
        this.fLM = this.fLK != null ? this.fLK.userId : null;
    }

    private void brh() {
        if (!v.aa(this.fLL)) {
            this.mNavigationBar.setCenterTextTitle(String.format(this.fLj.getResources().getString(R.string.subpb_floor_reply_count), aq.aM(this.fLL.size())));
        } else {
            this.mNavigationBar.setCenterTextTitle(this.fLj.getResources().getString(R.string.reply));
        }
    }

    private void ss(final int i) {
        this.fLF.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.frs.gamesubpb.view.a.10
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                if (!TextUtils.isEmpty(charSequence)) {
                    a.this.fLG.setEnabled(true);
                    String charSequence2 = charSequence.toString();
                    if (!StringUtils.isNull(charSequence2) && aa.ry(charSequence2) > i) {
                        String p = aa.p(charSequence2, 0, i - 1);
                        a.this.fLF.setText(p);
                        a.this.fLF.setSelection(a.this.fLF.getText().length());
                        UtilHelper.showToast(a.this.fLj.getPageContext().getPageActivity().getApplication(), a.this.fLj.getPageContext().getPageActivity().getResources().getString(R.string.edit_text_over_limit_tip, Integer.valueOf(p.length())));
                        return;
                    }
                    return;
                }
                a.this.brg();
                a.this.fLG.setEnabled(false);
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
            }
        });
    }

    private void bri() {
        if (this.mNavigationBar.getBackImageView() != null) {
            SvgManager.ajv().a(this.mNavigationBar.getBackImageView(), R.drawable.icon_pure_topbar_return_n_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void kE(final boolean z) {
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
            this.cvc.getWindowVisibleDisplayFrame(rect);
            this.fLE.scrollTo(this.fLE.getScrollX(), (l.aj(this.fLj.getPageContext().getPageActivity())[1] - rect.bottom) - (MenuKeyUtils.hasSmartBar() ? l.dip2px(this.fLj.getPageContext().getPageActivity(), 48.0f) : 0));
            return;
        }
        this.fLE.setScrollY(0);
    }

    private void kF(boolean z) {
        if (v.aa(this.fLL)) {
            this.mListView.setNextPage(null);
            this.fLI.setVisibility(0);
        } else {
            this.mListView.setNextPage(this.fLD);
            this.fLI.setVisibility(8);
            if (z) {
                this.fLD.akR();
            } else {
                this.fLD.akS();
            }
        }
        brh();
    }

    public void a(boolean z, com.baidu.tieba.frs.gamesubpb.model.b bVar, List<m> list) {
        this.hasMore = z;
        this.fLK = bVar;
        brg();
        if (v.aa(list)) {
            kF(z);
            return;
        }
        this.fLL.clear();
        this.fLL.addAll(list);
        this.fLI.setVisibility(8);
        this.mListView.setNextPage(this.fLD);
        this.fLJ.setData(list);
        bri();
        this.fLH.setVisibility(0);
        this.fLH.setText(R.string.say_your_point);
        kF(z);
    }

    public void a(boolean z, String str, d dVar) {
        st(8);
        if (z && dVar != null) {
            BdToast.b(this.fLj.getPageContext().getPageActivity(), this.fLj.getPageContext().getString(R.string.subpb_add_comment_succ_tip), 1).agW();
            this.fLF.setText((CharSequence) null);
            this.fLL.add(dVar);
            this.fLJ.setData(this.fLL);
            kF(this.hasMore);
            this.fLF.post(new Runnable() { // from class: com.baidu.tieba.frs.gamesubpb.view.a.2
                @Override // java.lang.Runnable
                public void run() {
                    a.this.fLF.requestFocus();
                    l.b(a.this.fLj.getPageContext().getPageActivity(), a.this.fLF);
                }
            });
            return;
        }
        if (TextUtils.isEmpty(str)) {
            str = this.fLj.getPageContext().getString(R.string.subpb_add_comment_fail_tip);
        }
        BdToast.b(this.fLj.getPageContext().getPageActivity(), str, 1).agW();
    }

    public void b(boolean z, String str, d dVar) {
        if (z) {
            BdToast.b(this.fLj.getPageContext().getPageActivity(), this.fLj.getPageContext().getString(R.string.subpb_delete_comment_succ_tip), 1).agW();
            this.fLL.remove(dVar);
            this.fLJ.setData(this.fLL);
            kF(this.hasMore);
            return;
        }
        if (TextUtils.isEmpty(str)) {
            str = this.fLj.getPageContext().getString(R.string.subpb_delete_comment_fail_tip);
        }
        BdToast.b(this.fLj.getPageContext().getPageActivity(), str, 1).agW();
    }

    public void kG(boolean z) {
        if (this.fio != null && this.fio.getLayoutParams() != null) {
            ViewGroup.LayoutParams layoutParams = this.fio.getLayoutParams();
            if (z) {
                bri();
                layoutParams.height = l.g(this.fLj.getPageContext().getPageActivity(), R.dimen.ds98);
            } else {
                layoutParams.height = l.g(this.fLj.getPageContext().getPageActivity(), R.dimen.ds98) + UtilHelper.getLightStatusBarHeight();
            }
            this.fio.setLayoutParams(layoutParams);
        }
    }

    public void bW(View view) {
        if (this.fio != null && this.mNavigationBar != null) {
            if (this.mNavigationBar.isNavigationBarExcludeStatusbarVisible()) {
                this.mNavigationBar.showNavigationBarExcludeStatusbar(false);
                if (UtilHelper.canUseStyleImmersiveSticky()) {
                    this.fio.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight()));
                } else if (this.mListView != null) {
                    this.mListView.removeHeaderView(this.fio);
                }
                this.mNavigationBar.setVisibility(8);
                return;
            }
            this.mNavigationBar.showNavigationBarExcludeStatusbar(true);
            if (UtilHelper.canUseStyleImmersiveSticky()) {
                this.fio.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + l.g(this.fLj.getActivity(), R.dimen.ds98)));
            } else if (this.mListView != null) {
                this.mListView.addHeaderView(this.fio, 0);
            }
            this.mNavigationBar.setVisibility(0);
        }
    }

    public void xJ(String str) {
        this.fLH.setVisibility(8);
        this.cvc.setVisibility(0);
        this.fLF.post(new Runnable() { // from class: com.baidu.tieba.frs.gamesubpb.view.a.3
            @Override // java.lang.Runnable
            public void run() {
                a.this.fLF.requestFocus();
                l.c(a.this.fLj.getPageContext().getPageActivity(), a.this.fLF);
            }
        });
        if (!TextUtils.isEmpty(str)) {
            String format = String.format(this.fLj.getPageContext().getPageActivity().getResources().getString(R.string.reply_sub_floor), str);
            this.fLF.setText(format);
            this.fLF.setSelection(format.length());
        }
    }

    public void st(int i) {
        this.mProgressBar.setVisibility(i);
    }

    public View bgK() {
        return this.fio;
    }

    public View getRootView() {
        return this.mRootView;
    }

    public ListView getListView() {
        return this.mListView;
    }

    public TextView brj() {
        return this.fLH;
    }

    public NavigationBar aLN() {
        return this.mNavigationBar;
    }

    public void e(com.baidu.tieba.frs.gamesubpb.c cVar) {
        this.fKT = cVar;
    }

    public void b(BdListView.e eVar) {
        this.mListView.setOnSrollToBottomListener(eVar);
    }

    public void onChangeSkinType(int i) {
        this.fLj.getLayoutMode().setNightMode(i == 1);
        this.fLj.getLayoutMode().onModeChanged(this.mRootView);
        am.l(this.mRootView, R.color.cp_bg_line_d);
        this.mNavigationBar.onChangeSkinType(this.fLj.getPageContext(), i);
        this.fLD.iY(i);
        am.j(this.fLH, R.color.cp_cont_e);
        this.fLH.setAlpha(0.95f);
        am.k(this.fLH, R.drawable.pb_ecomm_comment_bg);
        am.j(this.fLI, R.color.cp_cont_d);
        am.k(this.cvc, R.drawable.pb_ecomm_comment_bg);
        am.j(this.fLF, R.color.cp_cont_f);
        this.fLF.setHintTextColor(am.getColor(R.color.cp_cont_e));
        am.j(this.fLG, R.color.game_sub_pb_send_txt_color);
    }

    public void onDestroy() {
        if (this.globalListener != null) {
            this.fLj.getPageContext().getPageActivity().getWindow().getDecorView().getViewTreeObserver().removeGlobalOnLayoutListener(this.globalListener);
        }
    }
}
