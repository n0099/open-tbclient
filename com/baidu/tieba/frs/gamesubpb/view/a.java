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
import com.baidu.tieba.d;
import com.baidu.tieba.frs.gamesubpb.FrsGameSubPbActivity;
import com.baidu.tieba.frs.gamesubpb.a;
import com.baidu.tieba.frs.gamesubpb.model.e;
import com.baidu.tieba.pb.a.c;
import com.compatible.menukey.MenuKeyUtils;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class a {
    private View bWb;
    private c cca = new c(new c.a() { // from class: com.baidu.tieba.frs.gamesubpb.view.a.1
        @Override // com.baidu.tieba.pb.a.c.a
        public boolean b(View view, MotionEvent motionEvent) {
            a.this.jF(false);
            a.this.bL(view);
            a.this.jF(true);
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
    private LinearLayout ckB;
    private long dfr;
    private View eKP;
    private com.baidu.tieba.frs.gamesubpb.c fmW;
    private e fnG;
    private FrameLayout fnH;
    private EditText fnI;
    private TextView fnJ;
    private TextView fnK;
    private TextView fnL;
    private com.baidu.tieba.frs.gamesubpb.b fnM;
    private com.baidu.tieba.frs.gamesubpb.model.b fnN;
    private List<m> fnO;
    private String fnP;
    private String fna;
    private FrsGameSubPbActivity fnm;
    private ViewTreeObserver.OnGlobalLayoutListener globalListener;
    private boolean hasMore;
    private View.OnClickListener mCommonClickListener;
    private boolean mIsKeyboardOpen;
    private BdTypeListView mListView;
    private NavigationBar mNavigationBar;
    private ProgressBar mProgressBar;
    private RelativeLayout mRootView;

    public a(FrsGameSubPbActivity frsGameSubPbActivity, View.OnClickListener onClickListener, String str) {
        this.fnm = frsGameSubPbActivity;
        this.mCommonClickListener = onClickListener;
        this.fna = str;
        this.mRootView = (RelativeLayout) LayoutInflater.from(frsGameSubPbActivity.getPageContext().getPageActivity()).inflate(d.h.frs_game_sub_pb_activity, (ViewGroup) null);
        this.mListView = (BdTypeListView) this.mRootView.findViewById(d.g.new_sub_pb_list);
        this.mListView.setOnTouchListener(this.cca);
        this.mListView.setOnScrollListener(new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.frs.gamesubpb.view.a.4
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
                if (i != 0) {
                    l.b(a.this.fnm.getPageContext().getPageActivity(), a.this.fnI);
                }
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            }
        });
        this.fnG = new e(this.fnm.getPageContext());
        this.eKP = BdListViewHelper.a(this.fnm.getActivity(), this.mListView, BdListViewHelper.HeadType.DEFAULT);
        this.fnK = (TextView) this.mRootView.findViewById(d.g.subpb_editor_tool_comment_reply_text);
        this.fnK.setOnClickListener(this.mCommonClickListener);
        this.fnL = (TextView) this.mRootView.findViewById(d.g.no_reply_list_view);
        this.fnH = (FrameLayout) this.mRootView.findViewById(d.g.bottom_view);
        this.ckB = (LinearLayout) this.mRootView.findViewById(d.g.subpb_editor_tool_comment_input_container);
        this.fnI = (EditText) this.mRootView.findViewById(d.g.subpb_editor_tool_comment_input_edit);
        this.fnJ = (TextView) this.mRootView.findViewById(d.g.subpb_editor_tool_comment_send_tv);
        this.fnJ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.gamesubpb.view.a.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.vl(a.this.fnI.getText().toString());
            }
        });
        this.mProgressBar = (ProgressBar) this.mRootView.findViewById(d.g.progressBar);
        bgK();
        this.fnM = new com.baidu.tieba.frs.gamesubpb.b(this.fnm.getPageContext(), this.mListView);
        this.fnM.setClickListener(new a.InterfaceC0293a() { // from class: com.baidu.tieba.frs.gamesubpb.view.a.6
            @Override // com.baidu.tieba.frs.gamesubpb.a.InterfaceC0293a
            public void a(com.baidu.tieba.frs.gamesubpb.model.d dVar) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonPolymericActivityConfig(a.this.fnm.getPageContext().getPageActivity()).createNormalConfig(Long.valueOf(dVar.userId).longValue(), String.valueOf(a.this.dfr).equals(dVar.userId), false)));
            }

            @Override // com.baidu.tieba.frs.gamesubpb.a.InterfaceC0293a
            public void b(com.baidu.tieba.frs.gamesubpb.model.d dVar) {
                if (dVar != null) {
                    a.this.d(dVar);
                }
            }

            @Override // com.baidu.tieba.frs.gamesubpb.a.InterfaceC0293a
            public void c(com.baidu.tieba.frs.gamesubpb.model.d dVar) {
                if (a.this.fmW != null) {
                    a.this.fmW.bgC();
                }
                if (dVar == null) {
                    a.this.vm(null);
                    a.this.bgM();
                    return;
                }
                a.this.vm(dVar.userName);
                a.this.fnP = dVar.userId;
            }
        });
        qM(140);
        bgL();
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        this.fnO = new ArrayList();
        this.dfr = com.baidu.adp.lib.g.b.d(TbadkCoreApplication.getCurrentAccount(), 0L);
    }

    private void bgK() {
        this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(d.g.view_navigation_bar);
        this.bWb = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        ImageView backImageView = this.mNavigationBar.getBackImageView();
        if (backImageView != null && (backImageView.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bWb.getLayoutParams();
            int h = l.h(this.fnm.getPageContext().getPageActivity(), d.e.ds30);
            layoutParams.height = h;
            layoutParams.width = h;
            backImageView.setLayoutParams(layoutParams);
        }
        if (this.bWb != null && (this.bWb.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.bWb.getLayoutParams();
            layoutParams2.width = -2;
            layoutParams2.height = -1;
            this.bWb.setPadding(l.h(this.fnm.getPageContext().getPageActivity(), d.e.ds32), this.bWb.getPaddingTop(), this.bWb.getPaddingRight(), this.bWb.getPaddingBottom());
            this.bWb.setLayoutParams(layoutParams2);
        }
        this.mNavigationBar.setmBackImageViewBg(d.f.subpb_navigationbar_back, d.f.subpb_navigationbar_back);
    }

    private void bgL() {
        this.globalListener = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tieba.frs.gamesubpb.view.a.7
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                Rect rect = new Rect();
                a.this.fnm.getPageContext().getPageActivity().getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
                int r = l.r(a.this.fnm.getPageContext().getPageActivity());
                int[] aS = l.aS(a.this.fnm.getPageContext().getPageActivity());
                if (aS[1] - rect.bottom > aS[1] / 4 && !a.this.mIsKeyboardOpen) {
                    a.this.mIsKeyboardOpen = true;
                    a.this.onKeyboardVisibilityChanged(true);
                } else if (aS[1] - rect.height() == r && a.this.mIsKeyboardOpen) {
                    a.this.mIsKeyboardOpen = false;
                    a.this.onKeyboardVisibilityChanged(false);
                }
            }
        };
        this.fnm.getPageContext().getPageActivity().getWindow().getDecorView().getViewTreeObserver().addOnGlobalLayoutListener(this.globalListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(final com.baidu.tieba.frs.gamesubpb.model.d dVar) {
        final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.fnm.getPageContext().getPageActivity());
        aVar.ly(null);
        aVar.gC(d.j.del_post_confirm);
        aVar.dr(true);
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
        aVar.b(this.fnm.getPageContext()).aaW();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(com.baidu.tieba.frs.gamesubpb.model.d dVar) {
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_DELETE_SUB_COMMENT);
        httpMessage.addParam("user_id", this.dfr);
        httpMessage.addParam("main_tower_id", dVar.fnC);
        httpMessage.addParam("id", dVar.id);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void vl(String str) {
        qN(0);
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_ADD_SUB_COMMENT);
        httpMessage.addParam("user_id", this.dfr);
        httpMessage.addParam("reply_user_id", this.fnP);
        httpMessage.addParam("content", str);
        httpMessage.addParam("main_tower_id", this.fna);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bgM() {
        this.fnP = this.fnN != null ? this.fnN.userId : null;
    }

    private void bgN() {
        if (!v.T(this.fnO)) {
            this.mNavigationBar.setCenterTextTitle(String.format(this.fnm.getResources().getString(d.j.subpb_floor_reply_count), ap.ax(this.fnO.size())));
        } else {
            this.mNavigationBar.setCenterTextTitle(this.fnm.getResources().getString(d.j.reply));
        }
    }

    private void qM(final int i) {
        this.fnI.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.frs.gamesubpb.view.a.10
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                if (!TextUtils.isEmpty(charSequence)) {
                    a.this.fnJ.setEnabled(true);
                    String charSequence2 = charSequence.toString();
                    if (!StringUtils.isNull(charSequence2) && ab.pN(charSequence2) > i) {
                        String p = ab.p(charSequence2, 0, i - 1);
                        a.this.fnI.setText(p);
                        a.this.fnI.setSelection(a.this.fnI.getText().length());
                        UtilHelper.showToast(a.this.fnm.getPageContext().getPageActivity().getApplication(), a.this.fnm.getPageContext().getPageActivity().getResources().getString(d.j.edit_text_over_limit_tip, Integer.valueOf(p.length())));
                        return;
                    }
                    return;
                }
                a.this.bgM();
                a.this.fnJ.setEnabled(false);
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
            }
        });
    }

    private void bgO() {
        this.mNavigationBar.setmBackImageViewBg(d.f.subpb_navigationbar_close, d.f.subpb_navigationbar_close);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jF(final boolean z) {
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
            this.ckB.getWindowVisibleDisplayFrame(rect);
            this.fnH.scrollTo(this.fnH.getScrollX(), (l.aS(this.fnm.getPageContext().getPageActivity())[1] - rect.bottom) - (MenuKeyUtils.hasSmartBar() ? l.dip2px(this.fnm.getPageContext().getPageActivity(), 48.0f) : 0));
            return;
        }
        this.fnH.setScrollY(0);
    }

    private void jG(boolean z) {
        if (v.T(this.fnO)) {
            this.mListView.setNextPage(null);
            this.fnL.setVisibility(0);
        } else {
            this.mListView.setNextPage(this.fnG);
            this.fnL.setVisibility(8);
            if (z) {
                this.fnG.aez();
            } else {
                this.fnG.aeA();
            }
        }
        bgN();
    }

    public void a(boolean z, com.baidu.tieba.frs.gamesubpb.model.b bVar, List<m> list) {
        this.hasMore = z;
        this.fnN = bVar;
        bgM();
        if (v.T(list)) {
            jG(z);
            return;
        }
        this.fnO.clear();
        this.fnO.addAll(list);
        this.fnL.setVisibility(8);
        this.mListView.setNextPage(this.fnG);
        this.fnM.setData(list);
        bgO();
        this.fnK.setVisibility(0);
        this.fnK.setText(d.j.say_your_point);
        jG(z);
    }

    public void a(boolean z, String str, com.baidu.tieba.frs.gamesubpb.model.d dVar) {
        qN(8);
        if (z && dVar != null) {
            BdToast.b(this.fnm.getPageContext().getPageActivity(), this.fnm.getPageContext().getString(d.j.subpb_add_comment_succ_tip), 1).abe();
            this.fnI.setText((CharSequence) null);
            this.fnO.add(dVar);
            this.fnM.setData(this.fnO);
            jG(this.hasMore);
            this.fnI.post(new Runnable() { // from class: com.baidu.tieba.frs.gamesubpb.view.a.2
                @Override // java.lang.Runnable
                public void run() {
                    a.this.fnI.requestFocus();
                    l.b(a.this.fnm.getPageContext().getPageActivity(), a.this.fnI);
                }
            });
            return;
        }
        if (TextUtils.isEmpty(str)) {
            str = this.fnm.getPageContext().getString(d.j.subpb_add_comment_fail_tip);
        }
        BdToast.b(this.fnm.getPageContext().getPageActivity(), str, 1).abe();
    }

    public void b(boolean z, String str, com.baidu.tieba.frs.gamesubpb.model.d dVar) {
        if (z) {
            BdToast.b(this.fnm.getPageContext().getPageActivity(), this.fnm.getPageContext().getString(d.j.subpb_delete_comment_succ_tip), 1).abe();
            this.fnO.remove(dVar);
            this.fnM.setData(this.fnO);
            jG(this.hasMore);
            return;
        }
        if (TextUtils.isEmpty(str)) {
            str = this.fnm.getPageContext().getString(d.j.subpb_delete_comment_fail_tip);
        }
        BdToast.b(this.fnm.getPageContext().getPageActivity(), str, 1).abe();
    }

    public void jH(boolean z) {
        if (this.eKP != null && this.eKP.getLayoutParams() != null) {
            ViewGroup.LayoutParams layoutParams = this.eKP.getLayoutParams();
            if (z) {
                bgO();
                layoutParams.height = l.h(this.fnm.getPageContext().getPageActivity(), d.e.ds98);
            } else {
                layoutParams.height = l.h(this.fnm.getPageContext().getPageActivity(), d.e.ds98) + UtilHelper.getLightStatusBarHeight();
            }
            this.eKP.setLayoutParams(layoutParams);
        }
    }

    public void bL(View view) {
        if (this.eKP != null && this.mNavigationBar != null) {
            if (this.mNavigationBar.isNavigationBarExcludeStatusbarVisible()) {
                this.mNavigationBar.showNavigationBarExcludeStatusbar(false);
                if (UtilHelper.canUseStyleImmersiveSticky()) {
                    this.eKP.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight()));
                } else if (this.mListView != null) {
                    this.mListView.removeHeaderView(this.eKP);
                }
                this.mNavigationBar.setVisibility(8);
                return;
            }
            this.mNavigationBar.showNavigationBarExcludeStatusbar(true);
            if (UtilHelper.canUseStyleImmersiveSticky()) {
                this.eKP.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + l.h(this.fnm.getActivity(), d.e.ds98)));
            } else if (this.mListView != null) {
                this.mListView.addHeaderView(this.eKP, 0);
            }
            this.mNavigationBar.setVisibility(0);
        }
    }

    public void vm(String str) {
        this.fnK.setVisibility(8);
        this.ckB.setVisibility(0);
        this.fnI.post(new Runnable() { // from class: com.baidu.tieba.frs.gamesubpb.view.a.3
            @Override // java.lang.Runnable
            public void run() {
                a.this.fnI.requestFocus();
                l.c(a.this.fnm.getPageContext().getPageActivity(), a.this.fnI);
            }
        });
        if (!TextUtils.isEmpty(str)) {
            String format = String.format(this.fnm.getPageContext().getPageActivity().getResources().getString(d.j.reply_sub_floor), str);
            this.fnI.setText(format);
            this.fnI.setSelection(format.length());
        }
    }

    public void qN(int i) {
        this.mProgressBar.setVisibility(i);
    }

    public View bgP() {
        return this.eKP;
    }

    public View getRootView() {
        return this.mRootView;
    }

    public ListView getListView() {
        return this.mListView;
    }

    public TextView bgQ() {
        return this.fnK;
    }

    public NavigationBar aDm() {
        return this.mNavigationBar;
    }

    public void e(com.baidu.tieba.frs.gamesubpb.c cVar) {
        this.fmW = cVar;
    }

    public void b(BdListView.e eVar) {
        this.mListView.setOnSrollToBottomListener(eVar);
    }

    public void onChangeSkinType(int i) {
        this.fnm.getLayoutMode().setNightMode(i == 1);
        this.fnm.getLayoutMode().onModeChanged(this.mRootView);
        al.l(this.mRootView, d.C0277d.cp_bg_line_d);
        this.mNavigationBar.onChangeSkinType(this.fnm.getPageContext(), i);
        this.fnG.ib(i);
        al.j(this.fnK, d.C0277d.cp_cont_e);
        this.fnK.setAlpha(0.95f);
        al.k(this.fnK, d.f.pb_ecomm_comment_bg);
        al.j(this.fnL, d.C0277d.cp_cont_d);
        al.k(this.ckB, d.f.pb_ecomm_comment_bg);
        al.j(this.fnI, d.C0277d.cp_cont_f);
        this.fnI.setHintTextColor(al.getColor(d.C0277d.cp_cont_e));
        al.j(this.fnJ, d.C0277d.game_sub_pb_send_txt_color);
    }

    public void onDestroy() {
        if (this.globalListener != null) {
            this.fnm.getPageContext().getPageActivity().getWindow().getDecorView().getViewTreeObserver().removeGlobalOnLayoutListener(this.globalListener);
        }
    }
}
