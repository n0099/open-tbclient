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
import com.baidu.tbadk.util.y;
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
    private View aJu;
    private LinearLayout aWP;
    private long bLv;
    private c boq = new c(new c.a() { // from class: com.baidu.tieba.frs.gamesubpb.view.a.1
        @Override // com.baidu.tieba.pb.a.c.a
        public boolean a(View view, MotionEvent motionEvent) {
            a.this.hc(false);
            a.this.aQ(view);
            a.this.hc(true);
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
    private com.baidu.tieba.frs.gamesubpb.c dPI;
    private String dPM;
    private FrsGameSubPbActivity dPY;
    private List<h> dQA;
    private String dQB;
    private e dQs;
    private FrameLayout dQt;
    private EditText dQu;
    private TextView dQv;
    private TextView dQw;
    private TextView dQx;
    private com.baidu.tieba.frs.gamesubpb.b dQy;
    private com.baidu.tieba.frs.gamesubpb.model.b dQz;
    private View dnP;
    private ViewTreeObserver.OnGlobalLayoutListener globalListener;
    private boolean hasMore;
    private View.OnClickListener mCommonClickListener;
    private boolean mIsKeyboardOpen;
    private BdTypeListView mListView;
    private NavigationBar mNavigationBar;
    private ProgressBar mProgressBar;
    private RelativeLayout mRootView;

    public a(FrsGameSubPbActivity frsGameSubPbActivity, View.OnClickListener onClickListener, String str) {
        this.dPY = frsGameSubPbActivity;
        this.mCommonClickListener = onClickListener;
        this.dPM = str;
        this.mRootView = (RelativeLayout) LayoutInflater.from(frsGameSubPbActivity.getPageContext().getPageActivity()).inflate(e.h.frs_game_sub_pb_activity, (ViewGroup) null);
        this.mListView = (BdTypeListView) this.mRootView.findViewById(e.g.new_sub_pb_list);
        this.mListView.setOnTouchListener(this.boq);
        this.mListView.setOnScrollListener(new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.frs.gamesubpb.view.a.4
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
                if (i != 0) {
                    l.b(a.this.dPY.getPageContext().getPageActivity(), a.this.dQu);
                }
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            }
        });
        this.dQs = new com.baidu.tieba.frs.gamesubpb.model.e(this.dPY.getPageContext());
        this.dnP = BdListViewHelper.a(this.dPY.getActivity(), this.mListView, BdListViewHelper.HeadType.DEFAULT);
        this.dQw = (TextView) this.mRootView.findViewById(e.g.subpb_editor_tool_comment_reply_text);
        this.dQw.setOnClickListener(this.mCommonClickListener);
        this.dQx = (TextView) this.mRootView.findViewById(e.g.no_reply_list_view);
        this.dQt = (FrameLayout) this.mRootView.findViewById(e.g.bottom_view);
        this.aWP = (LinearLayout) this.mRootView.findViewById(e.g.subpb_editor_tool_comment_input_container);
        this.dQu = (EditText) this.mRootView.findViewById(e.g.subpb_editor_tool_comment_input_edit);
        this.dQv = (TextView) this.mRootView.findViewById(e.g.subpb_editor_tool_comment_send_tv);
        this.dQv.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.gamesubpb.view.a.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.nP(a.this.dQu.getText().toString());
            }
        });
        this.mProgressBar = (ProgressBar) this.mRootView.findViewById(e.g.progressBar);
        aDw();
        this.dQy = new com.baidu.tieba.frs.gamesubpb.b(this.dPY.getPageContext(), this.mListView);
        this.dQy.setClickListener(new a.InterfaceC0214a() { // from class: com.baidu.tieba.frs.gamesubpb.view.a.6
            @Override // com.baidu.tieba.frs.gamesubpb.a.InterfaceC0214a
            public void a(d dVar) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonPolymericActivityConfig(a.this.dPY.getPageContext().getPageActivity()).createNormalConfig(Long.valueOf(dVar.userId).longValue(), String.valueOf(a.this.bLv).equals(dVar.userId), false)));
            }

            @Override // com.baidu.tieba.frs.gamesubpb.a.InterfaceC0214a
            public void b(d dVar) {
                if (dVar != null) {
                    a.this.d(dVar);
                }
            }

            @Override // com.baidu.tieba.frs.gamesubpb.a.InterfaceC0214a
            public void c(d dVar) {
                if (a.this.dPI != null) {
                    a.this.dPI.aDo();
                }
                if (dVar == null) {
                    a.this.nQ(null);
                    a.this.aDy();
                    return;
                }
                a.this.nQ(dVar.userName);
                a.this.dQB = dVar.userId;
            }
        });
        mz(140);
        aDx();
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        this.dQA = new ArrayList();
        this.bLv = com.baidu.adp.lib.g.b.d(TbadkCoreApplication.getCurrentAccount(), 0L);
    }

    private void aDw() {
        this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(e.g.view_navigation_bar);
        this.aJu = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        ImageView backImageView = this.mNavigationBar.getBackImageView();
        if (backImageView != null && (backImageView.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.aJu.getLayoutParams();
            int h = l.h(this.dPY.getPageContext().getPageActivity(), e.C0200e.ds30);
            layoutParams.height = h;
            layoutParams.width = h;
            backImageView.setLayoutParams(layoutParams);
        }
        if (this.aJu != null && (this.aJu.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.aJu.getLayoutParams();
            layoutParams2.width = -2;
            layoutParams2.height = -1;
            this.aJu.setPadding(l.h(this.dPY.getPageContext().getPageActivity(), e.C0200e.ds32), this.aJu.getPaddingTop(), this.aJu.getPaddingRight(), this.aJu.getPaddingBottom());
            this.aJu.setLayoutParams(layoutParams2);
        }
        this.mNavigationBar.setmBackImageViewBg(e.f.subpb_navigationbar_back, e.f.subpb_navigationbar_back);
    }

    private void aDx() {
        this.globalListener = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tieba.frs.gamesubpb.view.a.7
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                Rect rect = new Rect();
                a.this.dPY.getPageContext().getPageActivity().getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
                int r = l.r(a.this.dPY.getPageContext().getPageActivity());
                int[] aS = l.aS(a.this.dPY.getPageContext().getPageActivity());
                if (aS[1] - rect.bottom > aS[1] / 4 && !a.this.mIsKeyboardOpen) {
                    a.this.mIsKeyboardOpen = true;
                    a.this.onKeyboardVisibilityChanged(true);
                } else if (aS[1] - rect.height() == r && a.this.mIsKeyboardOpen) {
                    a.this.mIsKeyboardOpen = false;
                    a.this.onKeyboardVisibilityChanged(false);
                }
            }
        };
        this.dPY.getPageContext().getPageActivity().getWindow().getDecorView().getViewTreeObserver().addOnGlobalLayoutListener(this.globalListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(final d dVar) {
        final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.dPY.getPageContext().getPageActivity());
        aVar.ei(null);
        aVar.cN(e.j.del_post_confirm);
        aVar.bf(true);
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
        aVar.b(this.dPY.getPageContext()).AB();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(d dVar) {
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_DELETE_SUB_COMMENT);
        httpMessage.addParam("user_id", this.bLv);
        httpMessage.addParam("main_tower_id", dVar.dQo);
        httpMessage.addParam("id", dVar.id);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void nP(String str) {
        mA(0);
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_ADD_SUB_COMMENT);
        httpMessage.addParam("user_id", this.bLv);
        httpMessage.addParam("reply_user_id", this.dQB);
        httpMessage.addParam("content", str);
        httpMessage.addParam("main_tower_id", this.dPM);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aDy() {
        this.dQB = this.dQz != null ? this.dQz.userId : null;
    }

    private void aDz() {
        if (!v.I(this.dQA)) {
            this.mNavigationBar.setCenterTextTitle(String.format(this.dPY.getResources().getString(e.j.subpb_floor_reply_count), ao.N(this.dQA.size())));
        } else {
            this.mNavigationBar.setCenterTextTitle(this.dPY.getResources().getString(e.j.reply));
        }
    }

    private void mz(final int i) {
        this.dQu.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.frs.gamesubpb.view.a.10
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                if (!TextUtils.isEmpty(charSequence)) {
                    a.this.dQv.setEnabled(true);
                    String charSequence2 = charSequence.toString();
                    if (!StringUtils.isNull(charSequence2) && y.it(charSequence2) > i) {
                        String o = y.o(charSequence2, 0, i - 1);
                        a.this.dQu.setText(o);
                        a.this.dQu.setSelection(a.this.dQu.getText().length());
                        UtilHelper.showToast(a.this.dPY.getPageContext().getPageActivity().getApplication(), a.this.dPY.getPageContext().getPageActivity().getResources().getString(e.j.edit_text_over_limit_tip, Integer.valueOf(o.length())));
                        return;
                    }
                    return;
                }
                a.this.aDy();
                a.this.dQv.setEnabled(false);
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
            }
        });
    }

    private void aDA() {
        this.mNavigationBar.setmBackImageViewBg(e.f.subpb_navigationbar_close, e.f.subpb_navigationbar_close);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hc(final boolean z) {
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
            this.aWP.getWindowVisibleDisplayFrame(rect);
            this.dQt.scrollTo(this.dQt.getScrollX(), (l.aS(this.dPY.getPageContext().getPageActivity())[1] - rect.bottom) - (MenuKeyUtils.hasSmartBar() ? l.dip2px(this.dPY.getPageContext().getPageActivity(), 48.0f) : 0));
            return;
        }
        this.dQt.setScrollY(0);
    }

    private void hd(boolean z) {
        if (v.I(this.dQA)) {
            this.mListView.setNextPage(null);
            this.dQx.setVisibility(0);
        } else {
            this.mListView.setNextPage(this.dQs);
            this.dQx.setVisibility(8);
            if (z) {
                this.dQs.DY();
            } else {
                this.dQs.DZ();
            }
        }
        aDz();
    }

    public void a(boolean z, com.baidu.tieba.frs.gamesubpb.model.b bVar, List<h> list) {
        this.hasMore = z;
        this.dQz = bVar;
        aDy();
        if (v.I(list)) {
            hd(z);
            return;
        }
        this.dQA.clear();
        this.dQA.addAll(list);
        this.dQx.setVisibility(8);
        this.mListView.setNextPage(this.dQs);
        this.dQy.setData(list);
        aDA();
        this.dQw.setVisibility(0);
        this.dQw.setText(e.j.say_your_point);
        hd(z);
    }

    public void a(boolean z, String str, d dVar) {
        mA(8);
        if (z && dVar != null) {
            BdToast.a(this.dPY.getPageContext().getPageActivity(), this.dPY.getPageContext().getString(e.j.subpb_add_comment_succ_tip), 1).AJ();
            this.dQu.setText((CharSequence) null);
            this.dQA.add(dVar);
            this.dQy.setData(this.dQA);
            hd(this.hasMore);
            this.dQu.post(new Runnable() { // from class: com.baidu.tieba.frs.gamesubpb.view.a.2
                @Override // java.lang.Runnable
                public void run() {
                    a.this.dQu.requestFocus();
                    l.b(a.this.dPY.getPageContext().getPageActivity(), a.this.dQu);
                }
            });
            return;
        }
        if (TextUtils.isEmpty(str)) {
            str = this.dPY.getPageContext().getString(e.j.subpb_add_comment_fail_tip);
        }
        BdToast.a(this.dPY.getPageContext().getPageActivity(), str, 1).AJ();
    }

    public void b(boolean z, String str, d dVar) {
        if (z) {
            BdToast.a(this.dPY.getPageContext().getPageActivity(), this.dPY.getPageContext().getString(e.j.subpb_delete_comment_succ_tip), 1).AJ();
            this.dQA.remove(dVar);
            this.dQy.setData(this.dQA);
            hd(this.hasMore);
            return;
        }
        if (TextUtils.isEmpty(str)) {
            str = this.dPY.getPageContext().getString(e.j.subpb_delete_comment_fail_tip);
        }
        BdToast.a(this.dPY.getPageContext().getPageActivity(), str, 1).AJ();
    }

    public void he(boolean z) {
        if (this.dnP != null && this.dnP.getLayoutParams() != null) {
            ViewGroup.LayoutParams layoutParams = this.dnP.getLayoutParams();
            if (z) {
                aDA();
                layoutParams.height = l.h(this.dPY.getPageContext().getPageActivity(), e.C0200e.ds98);
            } else {
                layoutParams.height = l.h(this.dPY.getPageContext().getPageActivity(), e.C0200e.ds98) + UtilHelper.getLightStatusBarHeight();
            }
            this.dnP.setLayoutParams(layoutParams);
        }
    }

    public void aQ(View view) {
        if (this.dnP != null && this.mNavigationBar != null) {
            if (this.mNavigationBar.isNavigationBarExcludeStatusbarVisible()) {
                this.mNavigationBar.showNavigationBarExcludeStatusbar(false);
                if (UtilHelper.canUseStyleImmersiveSticky()) {
                    this.dnP.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight()));
                } else if (this.mListView != null) {
                    this.mListView.removeHeaderView(this.dnP);
                }
                this.mNavigationBar.setVisibility(8);
                return;
            }
            this.mNavigationBar.showNavigationBarExcludeStatusbar(true);
            if (UtilHelper.canUseStyleImmersiveSticky()) {
                this.dnP.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + l.h(this.dPY.getActivity(), e.C0200e.ds98)));
            } else if (this.mListView != null) {
                this.mListView.addHeaderView(this.dnP, 0);
            }
            this.mNavigationBar.setVisibility(0);
        }
    }

    public void nQ(String str) {
        this.dQw.setVisibility(8);
        this.aWP.setVisibility(0);
        this.dQu.post(new Runnable() { // from class: com.baidu.tieba.frs.gamesubpb.view.a.3
            @Override // java.lang.Runnable
            public void run() {
                a.this.dQu.requestFocus();
                l.c(a.this.dPY.getPageContext().getPageActivity(), a.this.dQu);
            }
        });
        if (!TextUtils.isEmpty(str)) {
            String format = String.format(this.dPY.getPageContext().getPageActivity().getResources().getString(e.j.reply_sub_floor), str);
            this.dQu.setText(format);
            this.dQu.setSelection(format.length());
        }
    }

    public void mA(int i) {
        this.mProgressBar.setVisibility(i);
    }

    public View aDB() {
        return this.dnP;
    }

    public View getRootView() {
        return this.mRootView;
    }

    public ListView getListView() {
        return this.mListView;
    }

    public TextView aDC() {
        return this.dQw;
    }

    public NavigationBar aaO() {
        return this.mNavigationBar;
    }

    public void e(com.baidu.tieba.frs.gamesubpb.c cVar) {
        this.dPI = cVar;
    }

    public void a(BdListView.e eVar) {
        this.mListView.setOnSrollToBottomListener(eVar);
    }

    public void onChangeSkinType(int i) {
        this.dPY.getLayoutMode().setNightMode(i == 1);
        this.dPY.getLayoutMode().onModeChanged(this.mRootView);
        al.j(this.mRootView, e.d.cp_bg_line_d);
        this.mNavigationBar.onChangeSkinType(this.dPY.getPageContext(), i);
        this.dQs.ek(i);
        al.h(this.dQw, e.d.cp_cont_e);
        this.dQw.setAlpha(0.95f);
        al.i(this.dQw, e.f.pb_ecomm_comment_bg);
        al.h(this.dQx, e.d.cp_cont_d);
        al.i(this.aWP, e.f.pb_ecomm_comment_bg);
        al.h(this.dQu, e.d.cp_cont_f);
        this.dQu.setHintTextColor(al.getColor(e.d.cp_cont_e));
        al.h(this.dQv, e.d.game_sub_pb_send_txt_color);
    }

    public void onDestroy() {
        if (this.globalListener != null) {
            this.dPY.getPageContext().getPageActivity().getWindow().getDecorView().getViewTreeObserver().removeGlobalOnLayoutListener(this.globalListener);
        }
    }
}
