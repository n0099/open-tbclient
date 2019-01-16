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
    private View aNy;
    private long bPY;
    private LinearLayout bba;
    private c bsE = new c(new c.a() { // from class: com.baidu.tieba.frs.gamesubpb.view.a.1
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
    private com.baidu.tieba.frs.gamesubpb.c dZH;
    private String dZL;
    private FrsGameSubPbActivity dZX;
    private View dxM;
    private String eaA;
    private e ear;
    private FrameLayout eas;
    private EditText eat;
    private TextView eau;
    private TextView eav;
    private TextView eaw;
    private com.baidu.tieba.frs.gamesubpb.b eax;
    private com.baidu.tieba.frs.gamesubpb.model.b eay;
    private List<h> eaz;
    private ViewTreeObserver.OnGlobalLayoutListener globalListener;
    private boolean hasMore;
    private View.OnClickListener mCommonClickListener;
    private boolean mIsKeyboardOpen;
    private BdTypeListView mListView;
    private NavigationBar mNavigationBar;
    private ProgressBar mProgressBar;
    private RelativeLayout mRootView;

    public a(FrsGameSubPbActivity frsGameSubPbActivity, View.OnClickListener onClickListener, String str) {
        this.dZX = frsGameSubPbActivity;
        this.mCommonClickListener = onClickListener;
        this.dZL = str;
        this.mRootView = (RelativeLayout) LayoutInflater.from(frsGameSubPbActivity.getPageContext().getPageActivity()).inflate(e.h.frs_game_sub_pb_activity, (ViewGroup) null);
        this.mListView = (BdTypeListView) this.mRootView.findViewById(e.g.new_sub_pb_list);
        this.mListView.setOnTouchListener(this.bsE);
        this.mListView.setOnScrollListener(new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.frs.gamesubpb.view.a.4
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
                if (i != 0) {
                    l.b(a.this.dZX.getPageContext().getPageActivity(), a.this.eat);
                }
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            }
        });
        this.ear = new com.baidu.tieba.frs.gamesubpb.model.e(this.dZX.getPageContext());
        this.dxM = BdListViewHelper.a(this.dZX.getActivity(), this.mListView, BdListViewHelper.HeadType.DEFAULT);
        this.eav = (TextView) this.mRootView.findViewById(e.g.subpb_editor_tool_comment_reply_text);
        this.eav.setOnClickListener(this.mCommonClickListener);
        this.eaw = (TextView) this.mRootView.findViewById(e.g.no_reply_list_view);
        this.eas = (FrameLayout) this.mRootView.findViewById(e.g.bottom_view);
        this.bba = (LinearLayout) this.mRootView.findViewById(e.g.subpb_editor_tool_comment_input_container);
        this.eat = (EditText) this.mRootView.findViewById(e.g.subpb_editor_tool_comment_input_edit);
        this.eau = (TextView) this.mRootView.findViewById(e.g.subpb_editor_tool_comment_send_tv);
        this.eau.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.gamesubpb.view.a.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.oJ(a.this.eat.getText().toString());
            }
        });
        this.mProgressBar = (ProgressBar) this.mRootView.findViewById(e.g.progressBar);
        aGu();
        this.eax = new com.baidu.tieba.frs.gamesubpb.b(this.dZX.getPageContext(), this.mListView);
        this.eax.setClickListener(new a.InterfaceC0225a() { // from class: com.baidu.tieba.frs.gamesubpb.view.a.6
            @Override // com.baidu.tieba.frs.gamesubpb.a.InterfaceC0225a
            public void a(d dVar) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonPolymericActivityConfig(a.this.dZX.getPageContext().getPageActivity()).createNormalConfig(Long.valueOf(dVar.userId).longValue(), String.valueOf(a.this.bPY).equals(dVar.userId), false)));
            }

            @Override // com.baidu.tieba.frs.gamesubpb.a.InterfaceC0225a
            public void b(d dVar) {
                if (dVar != null) {
                    a.this.d(dVar);
                }
            }

            @Override // com.baidu.tieba.frs.gamesubpb.a.InterfaceC0225a
            public void c(d dVar) {
                if (a.this.dZH != null) {
                    a.this.dZH.aGm();
                }
                if (dVar == null) {
                    a.this.oK(null);
                    a.this.aGw();
                    return;
                }
                a.this.oK(dVar.userName);
                a.this.eaA = dVar.userId;
            }
        });
        nd(140);
        aGv();
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        this.eaz = new ArrayList();
        this.bPY = com.baidu.adp.lib.g.b.d(TbadkCoreApplication.getCurrentAccount(), 0L);
    }

    private void aGu() {
        this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(e.g.view_navigation_bar);
        this.aNy = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        ImageView backImageView = this.mNavigationBar.getBackImageView();
        if (backImageView != null && (backImageView.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.aNy.getLayoutParams();
            int h = l.h(this.dZX.getPageContext().getPageActivity(), e.C0210e.ds30);
            layoutParams.height = h;
            layoutParams.width = h;
            backImageView.setLayoutParams(layoutParams);
        }
        if (this.aNy != null && (this.aNy.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.aNy.getLayoutParams();
            layoutParams2.width = -2;
            layoutParams2.height = -1;
            this.aNy.setPadding(l.h(this.dZX.getPageContext().getPageActivity(), e.C0210e.ds32), this.aNy.getPaddingTop(), this.aNy.getPaddingRight(), this.aNy.getPaddingBottom());
            this.aNy.setLayoutParams(layoutParams2);
        }
        this.mNavigationBar.setmBackImageViewBg(e.f.subpb_navigationbar_back, e.f.subpb_navigationbar_back);
    }

    private void aGv() {
        this.globalListener = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tieba.frs.gamesubpb.view.a.7
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                Rect rect = new Rect();
                a.this.dZX.getPageContext().getPageActivity().getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
                int r = l.r(a.this.dZX.getPageContext().getPageActivity());
                int[] aS = l.aS(a.this.dZX.getPageContext().getPageActivity());
                if (aS[1] - rect.bottom > aS[1] / 4 && !a.this.mIsKeyboardOpen) {
                    a.this.mIsKeyboardOpen = true;
                    a.this.onKeyboardVisibilityChanged(true);
                } else if (aS[1] - rect.height() == r && a.this.mIsKeyboardOpen) {
                    a.this.mIsKeyboardOpen = false;
                    a.this.onKeyboardVisibilityChanged(false);
                }
            }
        };
        this.dZX.getPageContext().getPageActivity().getWindow().getDecorView().getViewTreeObserver().addOnGlobalLayoutListener(this.globalListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(final d dVar) {
        final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.dZX.getPageContext().getPageActivity());
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
        aVar.b(this.dZX.getPageContext()).BS();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(d dVar) {
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_DELETE_SUB_COMMENT);
        httpMessage.addParam("user_id", this.bPY);
        httpMessage.addParam("main_tower_id", dVar.ean);
        httpMessage.addParam("id", dVar.id);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void oJ(String str) {
        ne(0);
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_ADD_SUB_COMMENT);
        httpMessage.addParam("user_id", this.bPY);
        httpMessage.addParam("reply_user_id", this.eaA);
        httpMessage.addParam("content", str);
        httpMessage.addParam("main_tower_id", this.dZL);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aGw() {
        this.eaA = this.eay != null ? this.eay.userId : null;
    }

    private void aGx() {
        if (!v.I(this.eaz)) {
            this.mNavigationBar.setCenterTextTitle(String.format(this.dZX.getResources().getString(e.j.subpb_floor_reply_count), ao.V(this.eaz.size())));
        } else {
            this.mNavigationBar.setCenterTextTitle(this.dZX.getResources().getString(e.j.reply));
        }
    }

    private void nd(final int i) {
        this.eat.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.frs.gamesubpb.view.a.10
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                if (!TextUtils.isEmpty(charSequence)) {
                    a.this.eau.setEnabled(true);
                    String charSequence2 = charSequence.toString();
                    if (!StringUtils.isNull(charSequence2) && z.jc(charSequence2) > i) {
                        String q = z.q(charSequence2, 0, i - 1);
                        a.this.eat.setText(q);
                        a.this.eat.setSelection(a.this.eat.getText().length());
                        UtilHelper.showToast(a.this.dZX.getPageContext().getPageActivity().getApplication(), a.this.dZX.getPageContext().getPageActivity().getResources().getString(e.j.edit_text_over_limit_tip, Integer.valueOf(q.length())));
                        return;
                    }
                    return;
                }
                a.this.aGw();
                a.this.eau.setEnabled(false);
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
            this.bba.getWindowVisibleDisplayFrame(rect);
            this.eas.scrollTo(this.eas.getScrollX(), (l.aS(this.dZX.getPageContext().getPageActivity())[1] - rect.bottom) - (MenuKeyUtils.hasSmartBar() ? l.dip2px(this.dZX.getPageContext().getPageActivity(), 48.0f) : 0));
            return;
        }
        this.eas.setScrollY(0);
    }

    private void hl(boolean z) {
        if (v.I(this.eaz)) {
            this.mListView.setNextPage(null);
            this.eaw.setVisibility(0);
        } else {
            this.mListView.setNextPage(this.ear);
            this.eaw.setVisibility(8);
            if (z) {
                this.ear.Fp();
            } else {
                this.ear.Fq();
            }
        }
        aGx();
    }

    public void a(boolean z, com.baidu.tieba.frs.gamesubpb.model.b bVar, List<h> list) {
        this.hasMore = z;
        this.eay = bVar;
        aGw();
        if (v.I(list)) {
            hl(z);
            return;
        }
        this.eaz.clear();
        this.eaz.addAll(list);
        this.eaw.setVisibility(8);
        this.mListView.setNextPage(this.ear);
        this.eax.setData(list);
        aGy();
        this.eav.setVisibility(0);
        this.eav.setText(e.j.say_your_point);
        hl(z);
    }

    public void a(boolean z, String str, d dVar) {
        ne(8);
        if (z && dVar != null) {
            BdToast.a(this.dZX.getPageContext().getPageActivity(), this.dZX.getPageContext().getString(e.j.subpb_add_comment_succ_tip), 1).Ca();
            this.eat.setText((CharSequence) null);
            this.eaz.add(dVar);
            this.eax.setData(this.eaz);
            hl(this.hasMore);
            this.eat.post(new Runnable() { // from class: com.baidu.tieba.frs.gamesubpb.view.a.2
                @Override // java.lang.Runnable
                public void run() {
                    a.this.eat.requestFocus();
                    l.b(a.this.dZX.getPageContext().getPageActivity(), a.this.eat);
                }
            });
            return;
        }
        if (TextUtils.isEmpty(str)) {
            str = this.dZX.getPageContext().getString(e.j.subpb_add_comment_fail_tip);
        }
        BdToast.a(this.dZX.getPageContext().getPageActivity(), str, 1).Ca();
    }

    public void b(boolean z, String str, d dVar) {
        if (z) {
            BdToast.a(this.dZX.getPageContext().getPageActivity(), this.dZX.getPageContext().getString(e.j.subpb_delete_comment_succ_tip), 1).Ca();
            this.eaz.remove(dVar);
            this.eax.setData(this.eaz);
            hl(this.hasMore);
            return;
        }
        if (TextUtils.isEmpty(str)) {
            str = this.dZX.getPageContext().getString(e.j.subpb_delete_comment_fail_tip);
        }
        BdToast.a(this.dZX.getPageContext().getPageActivity(), str, 1).Ca();
    }

    public void hm(boolean z) {
        if (this.dxM != null && this.dxM.getLayoutParams() != null) {
            ViewGroup.LayoutParams layoutParams = this.dxM.getLayoutParams();
            if (z) {
                aGy();
                layoutParams.height = l.h(this.dZX.getPageContext().getPageActivity(), e.C0210e.ds98);
            } else {
                layoutParams.height = l.h(this.dZX.getPageContext().getPageActivity(), e.C0210e.ds98) + UtilHelper.getLightStatusBarHeight();
            }
            this.dxM.setLayoutParams(layoutParams);
        }
    }

    public void aT(View view) {
        if (this.dxM != null && this.mNavigationBar != null) {
            if (this.mNavigationBar.isNavigationBarExcludeStatusbarVisible()) {
                this.mNavigationBar.showNavigationBarExcludeStatusbar(false);
                if (UtilHelper.canUseStyleImmersiveSticky()) {
                    this.dxM.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight()));
                } else if (this.mListView != null) {
                    this.mListView.removeHeaderView(this.dxM);
                }
                this.mNavigationBar.setVisibility(8);
                return;
            }
            this.mNavigationBar.showNavigationBarExcludeStatusbar(true);
            if (UtilHelper.canUseStyleImmersiveSticky()) {
                this.dxM.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + l.h(this.dZX.getActivity(), e.C0210e.ds98)));
            } else if (this.mListView != null) {
                this.mListView.addHeaderView(this.dxM, 0);
            }
            this.mNavigationBar.setVisibility(0);
        }
    }

    public void oK(String str) {
        this.eav.setVisibility(8);
        this.bba.setVisibility(0);
        this.eat.post(new Runnable() { // from class: com.baidu.tieba.frs.gamesubpb.view.a.3
            @Override // java.lang.Runnable
            public void run() {
                a.this.eat.requestFocus();
                l.c(a.this.dZX.getPageContext().getPageActivity(), a.this.eat);
            }
        });
        if (!TextUtils.isEmpty(str)) {
            String format = String.format(this.dZX.getPageContext().getPageActivity().getResources().getString(e.j.reply_sub_floor), str);
            this.eat.setText(format);
            this.eat.setSelection(format.length());
        }
    }

    public void ne(int i) {
        this.mProgressBar.setVisibility(i);
    }

    public View aGz() {
        return this.dxM;
    }

    public View getRootView() {
        return this.mRootView;
    }

    public ListView getListView() {
        return this.mListView;
    }

    public TextView aGA() {
        return this.eav;
    }

    public NavigationBar act() {
        return this.mNavigationBar;
    }

    public void e(com.baidu.tieba.frs.gamesubpb.c cVar) {
        this.dZH = cVar;
    }

    public void a(BdListView.e eVar) {
        this.mListView.setOnSrollToBottomListener(eVar);
    }

    public void onChangeSkinType(int i) {
        this.dZX.getLayoutMode().setNightMode(i == 1);
        this.dZX.getLayoutMode().onModeChanged(this.mRootView);
        al.j(this.mRootView, e.d.cp_bg_line_d);
        this.mNavigationBar.onChangeSkinType(this.dZX.getPageContext(), i);
        this.ear.ey(i);
        al.h(this.eav, e.d.cp_cont_e);
        this.eav.setAlpha(0.95f);
        al.i(this.eav, e.f.pb_ecomm_comment_bg);
        al.h(this.eaw, e.d.cp_cont_d);
        al.i(this.bba, e.f.pb_ecomm_comment_bg);
        al.h(this.eat, e.d.cp_cont_f);
        this.eat.setHintTextColor(al.getColor(e.d.cp_cont_e));
        al.h(this.eau, e.d.game_sub_pb_send_txt_color);
    }

    public void onDestroy() {
        if (this.globalListener != null) {
            this.dZX.getPageContext().getPageActivity().getWindow().getDecorView().getViewTreeObserver().removeGlobalOnLayoutListener(this.globalListener);
        }
    }
}
