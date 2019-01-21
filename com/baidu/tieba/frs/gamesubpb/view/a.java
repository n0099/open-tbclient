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
import com.baidu.tbadk.util.z;
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
    private View aNz;
    private long bPZ;
    private LinearLayout bbb;
    private c bsF = new c(new c.a() { // from class: com.baidu.tieba.frs.gamesubpb.view.a.1
        @Override // com.baidu.tieba.pb.a.c.a
        public boolean a(View view, MotionEvent motionEvent) {
            a.this.hk(false);
            a.this.aT(view);
            a.this.hk(true);
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
    private com.baidu.tieba.frs.gamesubpb.c dZI;
    private String dZM;
    private FrsGameSubPbActivity dZY;
    private View dxN;
    private List<h> eaA;
    private String eaB;
    private e eas;
    private FrameLayout eat;
    private EditText eau;
    private TextView eav;
    private TextView eaw;
    private TextView eax;
    private com.baidu.tieba.frs.gamesubpb.b eay;
    private com.baidu.tieba.frs.gamesubpb.model.b eaz;
    private ViewTreeObserver.OnGlobalLayoutListener globalListener;
    private boolean hasMore;
    private View.OnClickListener mCommonClickListener;
    private boolean mIsKeyboardOpen;
    private BdTypeListView mListView;
    private NavigationBar mNavigationBar;
    private ProgressBar mProgressBar;
    private RelativeLayout mRootView;

    public a(FrsGameSubPbActivity frsGameSubPbActivity, View.OnClickListener onClickListener, String str) {
        this.dZY = frsGameSubPbActivity;
        this.mCommonClickListener = onClickListener;
        this.dZM = str;
        this.mRootView = (RelativeLayout) LayoutInflater.from(frsGameSubPbActivity.getPageContext().getPageActivity()).inflate(e.h.frs_game_sub_pb_activity, (ViewGroup) null);
        this.mListView = (BdTypeListView) this.mRootView.findViewById(e.g.new_sub_pb_list);
        this.mListView.setOnTouchListener(this.bsF);
        this.mListView.setOnScrollListener(new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.frs.gamesubpb.view.a.4
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
                if (i != 0) {
                    l.b(a.this.dZY.getPageContext().getPageActivity(), a.this.eau);
                }
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            }
        });
        this.eas = new com.baidu.tieba.frs.gamesubpb.model.e(this.dZY.getPageContext());
        this.dxN = BdListViewHelper.a(this.dZY.getActivity(), this.mListView, BdListViewHelper.HeadType.DEFAULT);
        this.eaw = (TextView) this.mRootView.findViewById(e.g.subpb_editor_tool_comment_reply_text);
        this.eaw.setOnClickListener(this.mCommonClickListener);
        this.eax = (TextView) this.mRootView.findViewById(e.g.no_reply_list_view);
        this.eat = (FrameLayout) this.mRootView.findViewById(e.g.bottom_view);
        this.bbb = (LinearLayout) this.mRootView.findViewById(e.g.subpb_editor_tool_comment_input_container);
        this.eau = (EditText) this.mRootView.findViewById(e.g.subpb_editor_tool_comment_input_edit);
        this.eav = (TextView) this.mRootView.findViewById(e.g.subpb_editor_tool_comment_send_tv);
        this.eav.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.gamesubpb.view.a.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.oJ(a.this.eau.getText().toString());
            }
        });
        this.mProgressBar = (ProgressBar) this.mRootView.findViewById(e.g.progressBar);
        aGu();
        this.eay = new com.baidu.tieba.frs.gamesubpb.b(this.dZY.getPageContext(), this.mListView);
        this.eay.setClickListener(new a.InterfaceC0225a() { // from class: com.baidu.tieba.frs.gamesubpb.view.a.6
            @Override // com.baidu.tieba.frs.gamesubpb.a.InterfaceC0225a
            public void a(d dVar) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonPolymericActivityConfig(a.this.dZY.getPageContext().getPageActivity()).createNormalConfig(Long.valueOf(dVar.userId).longValue(), String.valueOf(a.this.bPZ).equals(dVar.userId), false)));
            }

            @Override // com.baidu.tieba.frs.gamesubpb.a.InterfaceC0225a
            public void b(d dVar) {
                if (dVar != null) {
                    a.this.d(dVar);
                }
            }

            @Override // com.baidu.tieba.frs.gamesubpb.a.InterfaceC0225a
            public void c(d dVar) {
                if (a.this.dZI != null) {
                    a.this.dZI.aGm();
                }
                if (dVar == null) {
                    a.this.oK(null);
                    a.this.aGw();
                    return;
                }
                a.this.oK(dVar.userName);
                a.this.eaB = dVar.userId;
            }
        });
        nd(140);
        aGv();
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        this.eaA = new ArrayList();
        this.bPZ = com.baidu.adp.lib.g.b.d(TbadkCoreApplication.getCurrentAccount(), 0L);
    }

    private void aGu() {
        this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(e.g.view_navigation_bar);
        this.aNz = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        ImageView backImageView = this.mNavigationBar.getBackImageView();
        if (backImageView != null && (backImageView.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.aNz.getLayoutParams();
            int h = l.h(this.dZY.getPageContext().getPageActivity(), e.C0210e.ds30);
            layoutParams.height = h;
            layoutParams.width = h;
            backImageView.setLayoutParams(layoutParams);
        }
        if (this.aNz != null && (this.aNz.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.aNz.getLayoutParams();
            layoutParams2.width = -2;
            layoutParams2.height = -1;
            this.aNz.setPadding(l.h(this.dZY.getPageContext().getPageActivity(), e.C0210e.ds32), this.aNz.getPaddingTop(), this.aNz.getPaddingRight(), this.aNz.getPaddingBottom());
            this.aNz.setLayoutParams(layoutParams2);
        }
        this.mNavigationBar.setmBackImageViewBg(e.f.subpb_navigationbar_back, e.f.subpb_navigationbar_back);
    }

    private void aGv() {
        this.globalListener = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tieba.frs.gamesubpb.view.a.7
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                Rect rect = new Rect();
                a.this.dZY.getPageContext().getPageActivity().getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
                int r = l.r(a.this.dZY.getPageContext().getPageActivity());
                int[] aS = l.aS(a.this.dZY.getPageContext().getPageActivity());
                if (aS[1] - rect.bottom > aS[1] / 4 && !a.this.mIsKeyboardOpen) {
                    a.this.mIsKeyboardOpen = true;
                    a.this.onKeyboardVisibilityChanged(true);
                } else if (aS[1] - rect.height() == r && a.this.mIsKeyboardOpen) {
                    a.this.mIsKeyboardOpen = false;
                    a.this.onKeyboardVisibilityChanged(false);
                }
            }
        };
        this.dZY.getPageContext().getPageActivity().getWindow().getDecorView().getViewTreeObserver().addOnGlobalLayoutListener(this.globalListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(final d dVar) {
        final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.dZY.getPageContext().getPageActivity());
        aVar.eJ(null);
        aVar.db(e.j.del_post_confirm);
        aVar.bh(true);
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
        aVar.b(this.dZY.getPageContext()).BS();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(d dVar) {
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_DELETE_SUB_COMMENT);
        httpMessage.addParam("user_id", this.bPZ);
        httpMessage.addParam("main_tower_id", dVar.eao);
        httpMessage.addParam("id", dVar.id);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void oJ(String str) {
        ne(0);
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_ADD_SUB_COMMENT);
        httpMessage.addParam("user_id", this.bPZ);
        httpMessage.addParam("reply_user_id", this.eaB);
        httpMessage.addParam("content", str);
        httpMessage.addParam("main_tower_id", this.dZM);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aGw() {
        this.eaB = this.eaz != null ? this.eaz.userId : null;
    }

    private void aGx() {
        if (!v.I(this.eaA)) {
            this.mNavigationBar.setCenterTextTitle(String.format(this.dZY.getResources().getString(e.j.subpb_floor_reply_count), ao.V(this.eaA.size())));
        } else {
            this.mNavigationBar.setCenterTextTitle(this.dZY.getResources().getString(e.j.reply));
        }
    }

    private void nd(final int i) {
        this.eau.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.frs.gamesubpb.view.a.10
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                if (!TextUtils.isEmpty(charSequence)) {
                    a.this.eav.setEnabled(true);
                    String charSequence2 = charSequence.toString();
                    if (!StringUtils.isNull(charSequence2) && z.jc(charSequence2) > i) {
                        String q = z.q(charSequence2, 0, i - 1);
                        a.this.eau.setText(q);
                        a.this.eau.setSelection(a.this.eau.getText().length());
                        UtilHelper.showToast(a.this.dZY.getPageContext().getPageActivity().getApplication(), a.this.dZY.getPageContext().getPageActivity().getResources().getString(e.j.edit_text_over_limit_tip, Integer.valueOf(q.length())));
                        return;
                    }
                    return;
                }
                a.this.aGw();
                a.this.eav.setEnabled(false);
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
            }
        });
    }

    private void aGy() {
        this.mNavigationBar.setmBackImageViewBg(e.f.subpb_navigationbar_close, e.f.subpb_navigationbar_close);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hk(final boolean z) {
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
            this.bbb.getWindowVisibleDisplayFrame(rect);
            this.eat.scrollTo(this.eat.getScrollX(), (l.aS(this.dZY.getPageContext().getPageActivity())[1] - rect.bottom) - (MenuKeyUtils.hasSmartBar() ? l.dip2px(this.dZY.getPageContext().getPageActivity(), 48.0f) : 0));
            return;
        }
        this.eat.setScrollY(0);
    }

    private void hl(boolean z) {
        if (v.I(this.eaA)) {
            this.mListView.setNextPage(null);
            this.eax.setVisibility(0);
        } else {
            this.mListView.setNextPage(this.eas);
            this.eax.setVisibility(8);
            if (z) {
                this.eas.Fp();
            } else {
                this.eas.Fq();
            }
        }
        aGx();
    }

    public void a(boolean z, com.baidu.tieba.frs.gamesubpb.model.b bVar, List<h> list) {
        this.hasMore = z;
        this.eaz = bVar;
        aGw();
        if (v.I(list)) {
            hl(z);
            return;
        }
        this.eaA.clear();
        this.eaA.addAll(list);
        this.eax.setVisibility(8);
        this.mListView.setNextPage(this.eas);
        this.eay.setData(list);
        aGy();
        this.eaw.setVisibility(0);
        this.eaw.setText(e.j.say_your_point);
        hl(z);
    }

    public void a(boolean z, String str, d dVar) {
        ne(8);
        if (z && dVar != null) {
            BdToast.a(this.dZY.getPageContext().getPageActivity(), this.dZY.getPageContext().getString(e.j.subpb_add_comment_succ_tip), 1).Ca();
            this.eau.setText((CharSequence) null);
            this.eaA.add(dVar);
            this.eay.setData(this.eaA);
            hl(this.hasMore);
            this.eau.post(new Runnable() { // from class: com.baidu.tieba.frs.gamesubpb.view.a.2
                @Override // java.lang.Runnable
                public void run() {
                    a.this.eau.requestFocus();
                    l.b(a.this.dZY.getPageContext().getPageActivity(), a.this.eau);
                }
            });
            return;
        }
        if (TextUtils.isEmpty(str)) {
            str = this.dZY.getPageContext().getString(e.j.subpb_add_comment_fail_tip);
        }
        BdToast.a(this.dZY.getPageContext().getPageActivity(), str, 1).Ca();
    }

    public void b(boolean z, String str, d dVar) {
        if (z) {
            BdToast.a(this.dZY.getPageContext().getPageActivity(), this.dZY.getPageContext().getString(e.j.subpb_delete_comment_succ_tip), 1).Ca();
            this.eaA.remove(dVar);
            this.eay.setData(this.eaA);
            hl(this.hasMore);
            return;
        }
        if (TextUtils.isEmpty(str)) {
            str = this.dZY.getPageContext().getString(e.j.subpb_delete_comment_fail_tip);
        }
        BdToast.a(this.dZY.getPageContext().getPageActivity(), str, 1).Ca();
    }

    public void hm(boolean z) {
        if (this.dxN != null && this.dxN.getLayoutParams() != null) {
            ViewGroup.LayoutParams layoutParams = this.dxN.getLayoutParams();
            if (z) {
                aGy();
                layoutParams.height = l.h(this.dZY.getPageContext().getPageActivity(), e.C0210e.ds98);
            } else {
                layoutParams.height = l.h(this.dZY.getPageContext().getPageActivity(), e.C0210e.ds98) + UtilHelper.getLightStatusBarHeight();
            }
            this.dxN.setLayoutParams(layoutParams);
        }
    }

    public void aT(View view) {
        if (this.dxN != null && this.mNavigationBar != null) {
            if (this.mNavigationBar.isNavigationBarExcludeStatusbarVisible()) {
                this.mNavigationBar.showNavigationBarExcludeStatusbar(false);
                if (UtilHelper.canUseStyleImmersiveSticky()) {
                    this.dxN.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight()));
                } else if (this.mListView != null) {
                    this.mListView.removeHeaderView(this.dxN);
                }
                this.mNavigationBar.setVisibility(8);
                return;
            }
            this.mNavigationBar.showNavigationBarExcludeStatusbar(true);
            if (UtilHelper.canUseStyleImmersiveSticky()) {
                this.dxN.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + l.h(this.dZY.getActivity(), e.C0210e.ds98)));
            } else if (this.mListView != null) {
                this.mListView.addHeaderView(this.dxN, 0);
            }
            this.mNavigationBar.setVisibility(0);
        }
    }

    public void oK(String str) {
        this.eaw.setVisibility(8);
        this.bbb.setVisibility(0);
        this.eau.post(new Runnable() { // from class: com.baidu.tieba.frs.gamesubpb.view.a.3
            @Override // java.lang.Runnable
            public void run() {
                a.this.eau.requestFocus();
                l.c(a.this.dZY.getPageContext().getPageActivity(), a.this.eau);
            }
        });
        if (!TextUtils.isEmpty(str)) {
            String format = String.format(this.dZY.getPageContext().getPageActivity().getResources().getString(e.j.reply_sub_floor), str);
            this.eau.setText(format);
            this.eau.setSelection(format.length());
        }
    }

    public void ne(int i) {
        this.mProgressBar.setVisibility(i);
    }

    public View aGz() {
        return this.dxN;
    }

    public View getRootView() {
        return this.mRootView;
    }

    public ListView getListView() {
        return this.mListView;
    }

    public TextView aGA() {
        return this.eaw;
    }

    public NavigationBar act() {
        return this.mNavigationBar;
    }

    public void e(com.baidu.tieba.frs.gamesubpb.c cVar) {
        this.dZI = cVar;
    }

    public void a(BdListView.e eVar) {
        this.mListView.setOnSrollToBottomListener(eVar);
    }

    public void onChangeSkinType(int i) {
        this.dZY.getLayoutMode().setNightMode(i == 1);
        this.dZY.getLayoutMode().onModeChanged(this.mRootView);
        al.j(this.mRootView, e.d.cp_bg_line_d);
        this.mNavigationBar.onChangeSkinType(this.dZY.getPageContext(), i);
        this.eas.ey(i);
        al.h(this.eaw, e.d.cp_cont_e);
        this.eaw.setAlpha(0.95f);
        al.i(this.eaw, e.f.pb_ecomm_comment_bg);
        al.h(this.eax, e.d.cp_cont_d);
        al.i(this.bbb, e.f.pb_ecomm_comment_bg);
        al.h(this.eau, e.d.cp_cont_f);
        this.eau.setHintTextColor(al.getColor(e.d.cp_cont_e));
        al.h(this.eav, e.d.game_sub_pb_send_txt_color);
    }

    public void onDestroy() {
        if (this.globalListener != null) {
            this.dZY.getPageContext().getPageActivity().getWindow().getDecorView().getViewTreeObserver().removeGlobalOnLayoutListener(this.globalListener);
        }
    }
}
