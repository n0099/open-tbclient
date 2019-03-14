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
    private View bVZ;
    private c cbY = new c(new c.a() { // from class: com.baidu.tieba.frs.gamesubpb.view.a.1
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
    private LinearLayout ckz;
    private long dfn;
    private View eLd;
    private FrsGameSubPbActivity fnA;
    private e fnU;
    private FrameLayout fnV;
    private EditText fnW;
    private TextView fnX;
    private TextView fnY;
    private TextView fnZ;
    private com.baidu.tieba.frs.gamesubpb.c fnk;
    private String fno;
    private com.baidu.tieba.frs.gamesubpb.b foa;
    private com.baidu.tieba.frs.gamesubpb.model.b fob;
    private List<m> foc;
    private String fod;
    private ViewTreeObserver.OnGlobalLayoutListener globalListener;
    private boolean hasMore;
    private View.OnClickListener mCommonClickListener;
    private boolean mIsKeyboardOpen;
    private BdTypeListView mListView;
    private NavigationBar mNavigationBar;
    private ProgressBar mProgressBar;
    private RelativeLayout mRootView;

    public a(FrsGameSubPbActivity frsGameSubPbActivity, View.OnClickListener onClickListener, String str) {
        this.fnA = frsGameSubPbActivity;
        this.mCommonClickListener = onClickListener;
        this.fno = str;
        this.mRootView = (RelativeLayout) LayoutInflater.from(frsGameSubPbActivity.getPageContext().getPageActivity()).inflate(d.h.frs_game_sub_pb_activity, (ViewGroup) null);
        this.mListView = (BdTypeListView) this.mRootView.findViewById(d.g.new_sub_pb_list);
        this.mListView.setOnTouchListener(this.cbY);
        this.mListView.setOnScrollListener(new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.frs.gamesubpb.view.a.4
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
                if (i != 0) {
                    l.b(a.this.fnA.getPageContext().getPageActivity(), a.this.fnW);
                }
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            }
        });
        this.fnU = new e(this.fnA.getPageContext());
        this.eLd = BdListViewHelper.a(this.fnA.getActivity(), this.mListView, BdListViewHelper.HeadType.DEFAULT);
        this.fnY = (TextView) this.mRootView.findViewById(d.g.subpb_editor_tool_comment_reply_text);
        this.fnY.setOnClickListener(this.mCommonClickListener);
        this.fnZ = (TextView) this.mRootView.findViewById(d.g.no_reply_list_view);
        this.fnV = (FrameLayout) this.mRootView.findViewById(d.g.bottom_view);
        this.ckz = (LinearLayout) this.mRootView.findViewById(d.g.subpb_editor_tool_comment_input_container);
        this.fnW = (EditText) this.mRootView.findViewById(d.g.subpb_editor_tool_comment_input_edit);
        this.fnX = (TextView) this.mRootView.findViewById(d.g.subpb_editor_tool_comment_send_tv);
        this.fnX.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.gamesubpb.view.a.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.vm(a.this.fnW.getText().toString());
            }
        });
        this.mProgressBar = (ProgressBar) this.mRootView.findViewById(d.g.progressBar);
        bgM();
        this.foa = new com.baidu.tieba.frs.gamesubpb.b(this.fnA.getPageContext(), this.mListView);
        this.foa.setClickListener(new a.InterfaceC0293a() { // from class: com.baidu.tieba.frs.gamesubpb.view.a.6
            @Override // com.baidu.tieba.frs.gamesubpb.a.InterfaceC0293a
            public void a(com.baidu.tieba.frs.gamesubpb.model.d dVar) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonPolymericActivityConfig(a.this.fnA.getPageContext().getPageActivity()).createNormalConfig(Long.valueOf(dVar.userId).longValue(), String.valueOf(a.this.dfn).equals(dVar.userId), false)));
            }

            @Override // com.baidu.tieba.frs.gamesubpb.a.InterfaceC0293a
            public void b(com.baidu.tieba.frs.gamesubpb.model.d dVar) {
                if (dVar != null) {
                    a.this.d(dVar);
                }
            }

            @Override // com.baidu.tieba.frs.gamesubpb.a.InterfaceC0293a
            public void c(com.baidu.tieba.frs.gamesubpb.model.d dVar) {
                if (a.this.fnk != null) {
                    a.this.fnk.bgE();
                }
                if (dVar == null) {
                    a.this.vn(null);
                    a.this.bgO();
                    return;
                }
                a.this.vn(dVar.userName);
                a.this.fod = dVar.userId;
            }
        });
        qQ(140);
        bgN();
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        this.foc = new ArrayList();
        this.dfn = com.baidu.adp.lib.g.b.d(TbadkCoreApplication.getCurrentAccount(), 0L);
    }

    private void bgM() {
        this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(d.g.view_navigation_bar);
        this.bVZ = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        ImageView backImageView = this.mNavigationBar.getBackImageView();
        if (backImageView != null && (backImageView.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bVZ.getLayoutParams();
            int h = l.h(this.fnA.getPageContext().getPageActivity(), d.e.ds30);
            layoutParams.height = h;
            layoutParams.width = h;
            backImageView.setLayoutParams(layoutParams);
        }
        if (this.bVZ != null && (this.bVZ.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.bVZ.getLayoutParams();
            layoutParams2.width = -2;
            layoutParams2.height = -1;
            this.bVZ.setPadding(l.h(this.fnA.getPageContext().getPageActivity(), d.e.ds32), this.bVZ.getPaddingTop(), this.bVZ.getPaddingRight(), this.bVZ.getPaddingBottom());
            this.bVZ.setLayoutParams(layoutParams2);
        }
        this.mNavigationBar.setmBackImageViewBg(d.f.subpb_navigationbar_back, d.f.subpb_navigationbar_back);
    }

    private void bgN() {
        this.globalListener = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tieba.frs.gamesubpb.view.a.7
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                Rect rect = new Rect();
                a.this.fnA.getPageContext().getPageActivity().getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
                int r = l.r(a.this.fnA.getPageContext().getPageActivity());
                int[] aS = l.aS(a.this.fnA.getPageContext().getPageActivity());
                if (aS[1] - rect.bottom > aS[1] / 4 && !a.this.mIsKeyboardOpen) {
                    a.this.mIsKeyboardOpen = true;
                    a.this.onKeyboardVisibilityChanged(true);
                } else if (aS[1] - rect.height() == r && a.this.mIsKeyboardOpen) {
                    a.this.mIsKeyboardOpen = false;
                    a.this.onKeyboardVisibilityChanged(false);
                }
            }
        };
        this.fnA.getPageContext().getPageActivity().getWindow().getDecorView().getViewTreeObserver().addOnGlobalLayoutListener(this.globalListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(final com.baidu.tieba.frs.gamesubpb.model.d dVar) {
        final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.fnA.getPageContext().getPageActivity());
        aVar.lx(null);
        aVar.gD(d.j.del_post_confirm);
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
        aVar.b(this.fnA.getPageContext()).aaZ();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(com.baidu.tieba.frs.gamesubpb.model.d dVar) {
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_DELETE_SUB_COMMENT);
        httpMessage.addParam("user_id", this.dfn);
        httpMessage.addParam("main_tower_id", dVar.fnQ);
        httpMessage.addParam("id", dVar.id);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void vm(String str) {
        qR(0);
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_ADD_SUB_COMMENT);
        httpMessage.addParam("user_id", this.dfn);
        httpMessage.addParam("reply_user_id", this.fod);
        httpMessage.addParam("content", str);
        httpMessage.addParam("main_tower_id", this.fno);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bgO() {
        this.fod = this.fob != null ? this.fob.userId : null;
    }

    private void bgP() {
        if (!v.T(this.foc)) {
            this.mNavigationBar.setCenterTextTitle(String.format(this.fnA.getResources().getString(d.j.subpb_floor_reply_count), ap.ax(this.foc.size())));
        } else {
            this.mNavigationBar.setCenterTextTitle(this.fnA.getResources().getString(d.j.reply));
        }
    }

    private void qQ(final int i) {
        this.fnW.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.frs.gamesubpb.view.a.10
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                if (!TextUtils.isEmpty(charSequence)) {
                    a.this.fnX.setEnabled(true);
                    String charSequence2 = charSequence.toString();
                    if (!StringUtils.isNull(charSequence2) && ab.pM(charSequence2) > i) {
                        String p = ab.p(charSequence2, 0, i - 1);
                        a.this.fnW.setText(p);
                        a.this.fnW.setSelection(a.this.fnW.getText().length());
                        UtilHelper.showToast(a.this.fnA.getPageContext().getPageActivity().getApplication(), a.this.fnA.getPageContext().getPageActivity().getResources().getString(d.j.edit_text_over_limit_tip, Integer.valueOf(p.length())));
                        return;
                    }
                    return;
                }
                a.this.bgO();
                a.this.fnX.setEnabled(false);
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
            }
        });
    }

    private void bgQ() {
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
            this.ckz.getWindowVisibleDisplayFrame(rect);
            this.fnV.scrollTo(this.fnV.getScrollX(), (l.aS(this.fnA.getPageContext().getPageActivity())[1] - rect.bottom) - (MenuKeyUtils.hasSmartBar() ? l.dip2px(this.fnA.getPageContext().getPageActivity(), 48.0f) : 0));
            return;
        }
        this.fnV.setScrollY(0);
    }

    private void jG(boolean z) {
        if (v.T(this.foc)) {
            this.mListView.setNextPage(null);
            this.fnZ.setVisibility(0);
        } else {
            this.mListView.setNextPage(this.fnU);
            this.fnZ.setVisibility(8);
            if (z) {
                this.fnU.aeC();
            } else {
                this.fnU.aeD();
            }
        }
        bgP();
    }

    public void a(boolean z, com.baidu.tieba.frs.gamesubpb.model.b bVar, List<m> list) {
        this.hasMore = z;
        this.fob = bVar;
        bgO();
        if (v.T(list)) {
            jG(z);
            return;
        }
        this.foc.clear();
        this.foc.addAll(list);
        this.fnZ.setVisibility(8);
        this.mListView.setNextPage(this.fnU);
        this.foa.setData(list);
        bgQ();
        this.fnY.setVisibility(0);
        this.fnY.setText(d.j.say_your_point);
        jG(z);
    }

    public void a(boolean z, String str, com.baidu.tieba.frs.gamesubpb.model.d dVar) {
        qR(8);
        if (z && dVar != null) {
            BdToast.b(this.fnA.getPageContext().getPageActivity(), this.fnA.getPageContext().getString(d.j.subpb_add_comment_succ_tip), 1).abh();
            this.fnW.setText((CharSequence) null);
            this.foc.add(dVar);
            this.foa.setData(this.foc);
            jG(this.hasMore);
            this.fnW.post(new Runnable() { // from class: com.baidu.tieba.frs.gamesubpb.view.a.2
                @Override // java.lang.Runnable
                public void run() {
                    a.this.fnW.requestFocus();
                    l.b(a.this.fnA.getPageContext().getPageActivity(), a.this.fnW);
                }
            });
            return;
        }
        if (TextUtils.isEmpty(str)) {
            str = this.fnA.getPageContext().getString(d.j.subpb_add_comment_fail_tip);
        }
        BdToast.b(this.fnA.getPageContext().getPageActivity(), str, 1).abh();
    }

    public void b(boolean z, String str, com.baidu.tieba.frs.gamesubpb.model.d dVar) {
        if (z) {
            BdToast.b(this.fnA.getPageContext().getPageActivity(), this.fnA.getPageContext().getString(d.j.subpb_delete_comment_succ_tip), 1).abh();
            this.foc.remove(dVar);
            this.foa.setData(this.foc);
            jG(this.hasMore);
            return;
        }
        if (TextUtils.isEmpty(str)) {
            str = this.fnA.getPageContext().getString(d.j.subpb_delete_comment_fail_tip);
        }
        BdToast.b(this.fnA.getPageContext().getPageActivity(), str, 1).abh();
    }

    public void jH(boolean z) {
        if (this.eLd != null && this.eLd.getLayoutParams() != null) {
            ViewGroup.LayoutParams layoutParams = this.eLd.getLayoutParams();
            if (z) {
                bgQ();
                layoutParams.height = l.h(this.fnA.getPageContext().getPageActivity(), d.e.ds98);
            } else {
                layoutParams.height = l.h(this.fnA.getPageContext().getPageActivity(), d.e.ds98) + UtilHelper.getLightStatusBarHeight();
            }
            this.eLd.setLayoutParams(layoutParams);
        }
    }

    public void bL(View view) {
        if (this.eLd != null && this.mNavigationBar != null) {
            if (this.mNavigationBar.isNavigationBarExcludeStatusbarVisible()) {
                this.mNavigationBar.showNavigationBarExcludeStatusbar(false);
                if (UtilHelper.canUseStyleImmersiveSticky()) {
                    this.eLd.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight()));
                } else if (this.mListView != null) {
                    this.mListView.removeHeaderView(this.eLd);
                }
                this.mNavigationBar.setVisibility(8);
                return;
            }
            this.mNavigationBar.showNavigationBarExcludeStatusbar(true);
            if (UtilHelper.canUseStyleImmersiveSticky()) {
                this.eLd.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + l.h(this.fnA.getActivity(), d.e.ds98)));
            } else if (this.mListView != null) {
                this.mListView.addHeaderView(this.eLd, 0);
            }
            this.mNavigationBar.setVisibility(0);
        }
    }

    public void vn(String str) {
        this.fnY.setVisibility(8);
        this.ckz.setVisibility(0);
        this.fnW.post(new Runnable() { // from class: com.baidu.tieba.frs.gamesubpb.view.a.3
            @Override // java.lang.Runnable
            public void run() {
                a.this.fnW.requestFocus();
                l.c(a.this.fnA.getPageContext().getPageActivity(), a.this.fnW);
            }
        });
        if (!TextUtils.isEmpty(str)) {
            String format = String.format(this.fnA.getPageContext().getPageActivity().getResources().getString(d.j.reply_sub_floor), str);
            this.fnW.setText(format);
            this.fnW.setSelection(format.length());
        }
    }

    public void qR(int i) {
        this.mProgressBar.setVisibility(i);
    }

    public View bgR() {
        return this.eLd;
    }

    public View getRootView() {
        return this.mRootView;
    }

    public ListView getListView() {
        return this.mListView;
    }

    public TextView bgS() {
        return this.fnY;
    }

    public NavigationBar aDp() {
        return this.mNavigationBar;
    }

    public void e(com.baidu.tieba.frs.gamesubpb.c cVar) {
        this.fnk = cVar;
    }

    public void b(BdListView.e eVar) {
        this.mListView.setOnSrollToBottomListener(eVar);
    }

    public void onChangeSkinType(int i) {
        this.fnA.getLayoutMode().setNightMode(i == 1);
        this.fnA.getLayoutMode().onModeChanged(this.mRootView);
        al.l(this.mRootView, d.C0277d.cp_bg_line_d);
        this.mNavigationBar.onChangeSkinType(this.fnA.getPageContext(), i);
        this.fnU.ic(i);
        al.j(this.fnY, d.C0277d.cp_cont_e);
        this.fnY.setAlpha(0.95f);
        al.k(this.fnY, d.f.pb_ecomm_comment_bg);
        al.j(this.fnZ, d.C0277d.cp_cont_d);
        al.k(this.ckz, d.f.pb_ecomm_comment_bg);
        al.j(this.fnW, d.C0277d.cp_cont_f);
        this.fnW.setHintTextColor(al.getColor(d.C0277d.cp_cont_e));
        al.j(this.fnX, d.C0277d.game_sub_pb_send_txt_color);
    }

    public void onDestroy() {
        if (this.globalListener != null) {
            this.fnA.getPageContext().getPageActivity().getWindow().getDecorView().getViewTreeObserver().removeGlobalOnLayoutListener(this.globalListener);
        }
    }
}
