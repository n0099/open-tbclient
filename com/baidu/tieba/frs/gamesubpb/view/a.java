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
import com.baidu.tbadk.core.util.w;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tbadk.util.x;
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
    private View aAn;
    private LinearLayout aNo;
    private c beE = new c(new c.a() { // from class: com.baidu.tieba.frs.gamesubpb.view.a.1
        @Override // com.baidu.tieba.pb.a.c.a
        public boolean a(View view, MotionEvent motionEvent) {
            a.this.fT(false);
            a.this.av(view);
            a.this.fT(true);
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
    private long bul;
    private View cXU;
    private e duO;
    private FrameLayout duP;
    private EditText duQ;
    private TextView duR;
    private TextView duS;
    private TextView duT;
    private com.baidu.tieba.frs.gamesubpb.b duU;
    private com.baidu.tieba.frs.gamesubpb.model.b duV;
    private List<h> duW;
    private String duX;
    private com.baidu.tieba.frs.gamesubpb.c due;
    private String dui;
    private FrsGameSubPbActivity duu;
    private ViewTreeObserver.OnGlobalLayoutListener globalListener;
    private boolean hasMore;
    private View.OnClickListener mCommonClickListener;
    private boolean mIsKeyboardOpen;
    private BdTypeListView mListView;
    private NavigationBar mNavigationBar;
    private ProgressBar mProgressBar;
    private RelativeLayout mRootView;

    public a(FrsGameSubPbActivity frsGameSubPbActivity, View.OnClickListener onClickListener, String str) {
        this.duu = frsGameSubPbActivity;
        this.mCommonClickListener = onClickListener;
        this.dui = str;
        this.mRootView = (RelativeLayout) LayoutInflater.from(frsGameSubPbActivity.getPageContext().getPageActivity()).inflate(d.i.frs_game_sub_pb_activity, (ViewGroup) null);
        this.mListView = (BdTypeListView) this.mRootView.findViewById(d.g.new_sub_pb_list);
        this.mListView.setOnTouchListener(this.beE);
        this.mListView.setOnScrollListener(new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.frs.gamesubpb.view.a.4
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
                if (i != 0) {
                    l.b(a.this.duu.getPageContext().getPageActivity(), a.this.duQ);
                }
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            }
        });
        this.duO = new e(this.duu.getPageContext());
        this.cXU = BdListViewHelper.a(this.duu.getActivity(), this.mListView, BdListViewHelper.HeadType.DEFAULT);
        this.duS = (TextView) this.mRootView.findViewById(d.g.subpb_editor_tool_comment_reply_text);
        this.duS.setOnClickListener(this.mCommonClickListener);
        this.duT = (TextView) this.mRootView.findViewById(d.g.no_reply_list_view);
        this.duP = (FrameLayout) this.mRootView.findViewById(d.g.bottom_view);
        this.aNo = (LinearLayout) this.mRootView.findViewById(d.g.subpb_editor_tool_comment_input_container);
        this.duQ = (EditText) this.mRootView.findViewById(d.g.subpb_editor_tool_comment_input_edit);
        this.duR = (TextView) this.mRootView.findViewById(d.g.subpb_editor_tool_comment_send_tv);
        this.duR.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.gamesubpb.view.a.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.mI(a.this.duQ.getText().toString());
            }
        });
        this.mProgressBar = (ProgressBar) this.mRootView.findViewById(d.g.progressBar);
        axm();
        this.duU = new com.baidu.tieba.frs.gamesubpb.b(this.duu.getPageContext(), this.mListView);
        this.duU.setClickListener(new a.InterfaceC0155a() { // from class: com.baidu.tieba.frs.gamesubpb.view.a.6
            @Override // com.baidu.tieba.frs.gamesubpb.a.InterfaceC0155a
            public void a(com.baidu.tieba.frs.gamesubpb.model.d dVar) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonPolymericActivityConfig(a.this.duu.getPageContext().getPageActivity()).createNormalConfig(Long.valueOf(dVar.userId).longValue(), String.valueOf(a.this.bul).equals(dVar.userId), false)));
            }

            @Override // com.baidu.tieba.frs.gamesubpb.a.InterfaceC0155a
            public void b(com.baidu.tieba.frs.gamesubpb.model.d dVar) {
                if (dVar != null) {
                    a.this.d(dVar);
                }
            }

            @Override // com.baidu.tieba.frs.gamesubpb.a.InterfaceC0155a
            public void c(com.baidu.tieba.frs.gamesubpb.model.d dVar) {
                if (a.this.due != null) {
                    a.this.due.axe();
                }
                if (dVar == null) {
                    a.this.mJ(null);
                    a.this.axo();
                    return;
                }
                a.this.mJ(dVar.userName);
                a.this.duX = dVar.userId;
            }
        });
        kQ(140);
        axn();
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        this.duW = new ArrayList();
        this.bul = com.baidu.adp.lib.g.b.c(TbadkCoreApplication.getCurrentAccount(), 0L);
    }

    private void axm() {
        this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(d.g.view_navigation_bar);
        this.aAn = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        ImageView backImageView = this.mNavigationBar.getBackImageView();
        if (backImageView != null && (backImageView.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.aAn.getLayoutParams();
            int e = l.e(this.duu.getPageContext().getPageActivity(), d.e.ds30);
            layoutParams.height = e;
            layoutParams.width = e;
            backImageView.setLayoutParams(layoutParams);
        }
        if (this.aAn != null && (this.aAn.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.aAn.getLayoutParams();
            layoutParams2.width = -2;
            layoutParams2.height = -1;
            this.aAn.setPadding(l.e(this.duu.getPageContext().getPageActivity(), d.e.ds32), this.aAn.getPaddingTop(), this.aAn.getPaddingRight(), this.aAn.getPaddingBottom());
            this.aAn.setLayoutParams(layoutParams2);
        }
        this.mNavigationBar.setmBackImageViewBg(d.f.subpb_navigationbar_back, d.f.subpb_navigationbar_back);
    }

    private void axn() {
        this.globalListener = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tieba.frs.gamesubpb.view.a.7
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                Rect rect = new Rect();
                a.this.duu.getPageContext().getPageActivity().getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
                int o = l.o(a.this.duu.getPageContext().getPageActivity());
                int[] al = l.al(a.this.duu.getPageContext().getPageActivity());
                if (al[1] - rect.bottom > al[1] / 4 && !a.this.mIsKeyboardOpen) {
                    a.this.mIsKeyboardOpen = true;
                    a.this.onKeyboardVisibilityChanged(true);
                } else if (al[1] - rect.height() == o && a.this.mIsKeyboardOpen) {
                    a.this.mIsKeyboardOpen = false;
                    a.this.onKeyboardVisibilityChanged(false);
                }
            }
        };
        this.duu.getPageContext().getPageActivity().getWindow().getDecorView().getViewTreeObserver().addOnGlobalLayoutListener(this.globalListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(final com.baidu.tieba.frs.gamesubpb.model.d dVar) {
        final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.duu.getPageContext().getPageActivity());
        aVar.dA(null);
        aVar.cc(d.k.del_post_confirm);
        aVar.av(true);
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
        aVar.b(this.duu.getPageContext()).xa();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(com.baidu.tieba.frs.gamesubpb.model.d dVar) {
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_DELETE_SUB_COMMENT);
        httpMessage.addParam("user_id", this.bul);
        httpMessage.addParam("main_tower_id", dVar.duK);
        httpMessage.addParam("id", dVar.id);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mI(String str) {
        kR(0);
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_ADD_SUB_COMMENT);
        httpMessage.addParam("user_id", this.bul);
        httpMessage.addParam("reply_user_id", this.duX);
        httpMessage.addParam("content", str);
        httpMessage.addParam("main_tower_id", this.dui);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void axo() {
        this.duX = this.duV != null ? this.duV.userId : null;
    }

    private void axp() {
        if (!w.z(this.duW)) {
            this.mNavigationBar.setCenterTextTitle(String.format(this.duu.getResources().getString(d.k.subpb_floor_reply_count), ao.C(this.duW.size())));
        } else {
            this.mNavigationBar.setCenterTextTitle(this.duu.getResources().getString(d.k.reply));
        }
    }

    private void kQ(final int i) {
        this.duQ.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.frs.gamesubpb.view.a.10
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                if (!TextUtils.isEmpty(charSequence)) {
                    a.this.duR.setEnabled(true);
                    String charSequence2 = charSequence.toString();
                    if (!StringUtils.isNull(charSequence2) && x.hG(charSequence2) > i) {
                        String k = x.k(charSequence2, 0, i - 1);
                        a.this.duQ.setText(k);
                        a.this.duQ.setSelection(a.this.duQ.getText().length());
                        UtilHelper.showToast(a.this.duu.getPageContext().getPageActivity().getApplication(), a.this.duu.getPageContext().getPageActivity().getResources().getString(d.k.edit_text_over_limit_tip, Integer.valueOf(k.length())));
                        return;
                    }
                    return;
                }
                a.this.axo();
                a.this.duR.setEnabled(false);
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
            }
        });
    }

    private void axq() {
        this.mNavigationBar.setmBackImageViewBg(d.f.subpb_navigationbar_close, d.f.subpb_navigationbar_close);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fT(final boolean z) {
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
            this.aNo.getWindowVisibleDisplayFrame(rect);
            this.duP.scrollTo(this.duP.getScrollX(), (l.al(this.duu.getPageContext().getPageActivity())[1] - rect.bottom) - (MenuKeyUtils.hasSmartBar() ? l.dip2px(this.duu.getPageContext().getPageActivity(), 48.0f) : 0));
            return;
        }
        this.duP.setScrollY(0);
    }

    private void fU(boolean z) {
        if (w.z(this.duW)) {
            this.mListView.setNextPage(null);
            this.duT.setVisibility(0);
        } else {
            this.mListView.setNextPage(this.duO);
            this.duT.setVisibility(8);
            if (z) {
                this.duO.Ar();
            } else {
                this.duO.As();
            }
        }
        axp();
    }

    public void a(boolean z, com.baidu.tieba.frs.gamesubpb.model.b bVar, List<h> list) {
        this.hasMore = z;
        this.duV = bVar;
        axo();
        if (w.z(list)) {
            fU(z);
            return;
        }
        this.duW.clear();
        this.duW.addAll(list);
        this.duT.setVisibility(8);
        this.mListView.setNextPage(this.duO);
        this.duU.setData(list);
        axq();
        this.duS.setVisibility(0);
        this.duS.setText(d.k.say_your_point);
        fU(z);
    }

    public void a(boolean z, String str, com.baidu.tieba.frs.gamesubpb.model.d dVar) {
        kR(8);
        if (z && dVar != null) {
            BdToast.a(this.duu.getPageContext().getPageActivity(), this.duu.getPageContext().getString(d.k.subpb_add_comment_succ_tip), 1).xi();
            this.duQ.setText((CharSequence) null);
            this.duW.add(dVar);
            this.duU.setData(this.duW);
            fU(this.hasMore);
            this.duQ.post(new Runnable() { // from class: com.baidu.tieba.frs.gamesubpb.view.a.2
                @Override // java.lang.Runnable
                public void run() {
                    a.this.duQ.requestFocus();
                    l.b(a.this.duu.getPageContext().getPageActivity(), a.this.duQ);
                }
            });
            return;
        }
        if (TextUtils.isEmpty(str)) {
            str = this.duu.getPageContext().getString(d.k.subpb_add_comment_fail_tip);
        }
        BdToast.a(this.duu.getPageContext().getPageActivity(), str, 1).xi();
    }

    public void b(boolean z, String str, com.baidu.tieba.frs.gamesubpb.model.d dVar) {
        if (z) {
            BdToast.a(this.duu.getPageContext().getPageActivity(), this.duu.getPageContext().getString(d.k.subpb_delete_comment_succ_tip), 1).xi();
            this.duW.remove(dVar);
            this.duU.setData(this.duW);
            fU(this.hasMore);
            return;
        }
        if (TextUtils.isEmpty(str)) {
            str = this.duu.getPageContext().getString(d.k.subpb_delete_comment_fail_tip);
        }
        BdToast.a(this.duu.getPageContext().getPageActivity(), str, 1).xi();
    }

    public void fV(boolean z) {
        if (this.cXU != null && this.cXU.getLayoutParams() != null) {
            ViewGroup.LayoutParams layoutParams = this.cXU.getLayoutParams();
            if (z) {
                axq();
                layoutParams.height = l.e(this.duu.getPageContext().getPageActivity(), d.e.ds98);
            } else {
                layoutParams.height = l.e(this.duu.getPageContext().getPageActivity(), d.e.ds98) + UtilHelper.getLightStatusBarHeight();
            }
            this.cXU.setLayoutParams(layoutParams);
        }
    }

    public void av(View view) {
        if (this.cXU != null && this.mNavigationBar != null) {
            if (this.mNavigationBar.isNavigationBarExcludeStatusbarVisible()) {
                this.mNavigationBar.showNavigationBarExcludeStatusbar(false);
                if (UtilHelper.canUseStyleImmersiveSticky()) {
                    this.cXU.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight()));
                } else if (this.mListView != null) {
                    this.mListView.removeHeaderView(this.cXU);
                }
                this.mNavigationBar.setVisibility(8);
                return;
            }
            this.mNavigationBar.showNavigationBarExcludeStatusbar(true);
            if (UtilHelper.canUseStyleImmersiveSticky()) {
                this.cXU.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + l.e(this.duu.getActivity(), d.e.ds98)));
            } else if (this.mListView != null) {
                this.mListView.addHeaderView(this.cXU, 0);
            }
            this.mNavigationBar.setVisibility(0);
        }
    }

    public void mJ(String str) {
        this.duS.setVisibility(8);
        this.aNo.setVisibility(0);
        this.duQ.post(new Runnable() { // from class: com.baidu.tieba.frs.gamesubpb.view.a.3
            @Override // java.lang.Runnable
            public void run() {
                a.this.duQ.requestFocus();
                l.c(a.this.duu.getPageContext().getPageActivity(), a.this.duQ);
            }
        });
        if (!TextUtils.isEmpty(str)) {
            String format = String.format(this.duu.getPageContext().getPageActivity().getResources().getString(d.k.reply_sub_floor), str);
            this.duQ.setText(format);
            this.duQ.setSelection(format.length());
        }
    }

    public void kR(int i) {
        this.mProgressBar.setVisibility(i);
    }

    public View axr() {
        return this.cXU;
    }

    public View getRootView() {
        return this.mRootView;
    }

    public ListView getListView() {
        return this.mListView;
    }

    public TextView axs() {
        return this.duS;
    }

    public NavigationBar UB() {
        return this.mNavigationBar;
    }

    public void e(com.baidu.tieba.frs.gamesubpb.c cVar) {
        this.due = cVar;
    }

    public void a(BdListView.e eVar) {
        this.mListView.setOnSrollToBottomListener(eVar);
    }

    public void onChangeSkinType(int i) {
        this.duu.getLayoutMode().setNightMode(i == 1);
        this.duu.getLayoutMode().onModeChanged(this.mRootView);
        al.j(this.mRootView, d.C0141d.cp_bg_line_d);
        this.mNavigationBar.onChangeSkinType(this.duu.getPageContext(), i);
        this.duO.dy(i);
        al.h(this.duS, d.C0141d.cp_cont_e);
        this.duS.setAlpha(0.95f);
        al.i(this.duS, d.f.pb_ecomm_comment_bg);
        al.h(this.duT, d.C0141d.cp_cont_d);
        al.i(this.aNo, d.f.pb_ecomm_comment_bg);
        al.h(this.duQ, d.C0141d.cp_cont_f);
        this.duQ.setHintTextColor(al.getColor(d.C0141d.cp_cont_e));
        al.h(this.duR, d.C0141d.game_sub_pb_send_txt_color);
    }

    public void onDestroy() {
        if (this.globalListener != null) {
            this.duu.getPageContext().getPageActivity().getWindow().getDecorView().getViewTreeObserver().removeGlobalOnLayoutListener(this.globalListener);
        }
    }
}
