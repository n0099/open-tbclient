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
    private View aEa;
    private LinearLayout aRy;
    private long bCd;
    private c bjA = new c(new c.a() { // from class: com.baidu.tieba.frs.gamesubpb.view.a.1
        @Override // com.baidu.tieba.pb.a.c.a
        public boolean a(View view, MotionEvent motionEvent) {
            a.this.gB(false);
            a.this.aO(view);
            a.this.gB(true);
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
    private com.baidu.tieba.frs.gamesubpb.c dGG;
    private String dGK;
    private FrsGameSubPbActivity dGW;
    private e dHq;
    private FrameLayout dHr;
    private EditText dHs;
    private TextView dHt;
    private TextView dHu;
    private TextView dHv;
    private com.baidu.tieba.frs.gamesubpb.b dHw;
    private com.baidu.tieba.frs.gamesubpb.model.b dHx;
    private List<h> dHy;
    private String dHz;
    private View deF;
    private ViewTreeObserver.OnGlobalLayoutListener globalListener;
    private boolean hasMore;
    private View.OnClickListener mCommonClickListener;
    private boolean mIsKeyboardOpen;
    private BdTypeListView mListView;
    private NavigationBar mNavigationBar;
    private ProgressBar mProgressBar;
    private RelativeLayout mRootView;

    public a(FrsGameSubPbActivity frsGameSubPbActivity, View.OnClickListener onClickListener, String str) {
        this.dGW = frsGameSubPbActivity;
        this.mCommonClickListener = onClickListener;
        this.dGK = str;
        this.mRootView = (RelativeLayout) LayoutInflater.from(frsGameSubPbActivity.getPageContext().getPageActivity()).inflate(e.h.frs_game_sub_pb_activity, (ViewGroup) null);
        this.mListView = (BdTypeListView) this.mRootView.findViewById(e.g.new_sub_pb_list);
        this.mListView.setOnTouchListener(this.bjA);
        this.mListView.setOnScrollListener(new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.frs.gamesubpb.view.a.4
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
                if (i != 0) {
                    l.a(a.this.dGW.getPageContext().getPageActivity(), a.this.dHs);
                }
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            }
        });
        this.dHq = new com.baidu.tieba.frs.gamesubpb.model.e(this.dGW.getPageContext());
        this.deF = BdListViewHelper.a(this.dGW.getActivity(), this.mListView, BdListViewHelper.HeadType.DEFAULT);
        this.dHu = (TextView) this.mRootView.findViewById(e.g.subpb_editor_tool_comment_reply_text);
        this.dHu.setOnClickListener(this.mCommonClickListener);
        this.dHv = (TextView) this.mRootView.findViewById(e.g.no_reply_list_view);
        this.dHr = (FrameLayout) this.mRootView.findViewById(e.g.bottom_view);
        this.aRy = (LinearLayout) this.mRootView.findViewById(e.g.subpb_editor_tool_comment_input_container);
        this.dHs = (EditText) this.mRootView.findViewById(e.g.subpb_editor_tool_comment_input_edit);
        this.dHt = (TextView) this.mRootView.findViewById(e.g.subpb_editor_tool_comment_send_tv);
        this.dHt.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.gamesubpb.view.a.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.nm(a.this.dHs.getText().toString());
            }
        });
        this.mProgressBar = (ProgressBar) this.mRootView.findViewById(e.g.progressBar);
        aAI();
        this.dHw = new com.baidu.tieba.frs.gamesubpb.b(this.dGW.getPageContext(), this.mListView);
        this.dHw.setClickListener(new a.InterfaceC0155a() { // from class: com.baidu.tieba.frs.gamesubpb.view.a.6
            @Override // com.baidu.tieba.frs.gamesubpb.a.InterfaceC0155a
            public void a(d dVar) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonPolymericActivityConfig(a.this.dGW.getPageContext().getPageActivity()).createNormalConfig(Long.valueOf(dVar.userId).longValue(), String.valueOf(a.this.bCd).equals(dVar.userId), false)));
            }

            @Override // com.baidu.tieba.frs.gamesubpb.a.InterfaceC0155a
            public void b(d dVar) {
                if (dVar != null) {
                    a.this.d(dVar);
                }
            }

            @Override // com.baidu.tieba.frs.gamesubpb.a.InterfaceC0155a
            public void c(d dVar) {
                if (a.this.dGG != null) {
                    a.this.dGG.aAA();
                }
                if (dVar == null) {
                    a.this.nn(null);
                    a.this.aAK();
                    return;
                }
                a.this.nn(dVar.userName);
                a.this.dHz = dVar.userId;
            }
        });
        lK(140);
        aAJ();
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        this.dHy = new ArrayList();
        this.bCd = com.baidu.adp.lib.g.b.d(TbadkCoreApplication.getCurrentAccount(), 0L);
    }

    private void aAI() {
        this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(e.g.view_navigation_bar);
        this.aEa = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        ImageView backImageView = this.mNavigationBar.getBackImageView();
        if (backImageView != null && (backImageView.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.aEa.getLayoutParams();
            int h = l.h(this.dGW.getPageContext().getPageActivity(), e.C0141e.ds30);
            layoutParams.height = h;
            layoutParams.width = h;
            backImageView.setLayoutParams(layoutParams);
        }
        if (this.aEa != null && (this.aEa.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.aEa.getLayoutParams();
            layoutParams2.width = -2;
            layoutParams2.height = -1;
            this.aEa.setPadding(l.h(this.dGW.getPageContext().getPageActivity(), e.C0141e.ds32), this.aEa.getPaddingTop(), this.aEa.getPaddingRight(), this.aEa.getPaddingBottom());
            this.aEa.setLayoutParams(layoutParams2);
        }
        this.mNavigationBar.setmBackImageViewBg(e.f.subpb_navigationbar_back, e.f.subpb_navigationbar_back);
    }

    private void aAJ() {
        this.globalListener = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tieba.frs.gamesubpb.view.a.7
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                Rect rect = new Rect();
                a.this.dGW.getPageContext().getPageActivity().getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
                int r = l.r(a.this.dGW.getPageContext().getPageActivity());
                int[] aS = l.aS(a.this.dGW.getPageContext().getPageActivity());
                if (aS[1] - rect.bottom > aS[1] / 4 && !a.this.mIsKeyboardOpen) {
                    a.this.mIsKeyboardOpen = true;
                    a.this.onKeyboardVisibilityChanged(true);
                } else if (aS[1] - rect.height() == r && a.this.mIsKeyboardOpen) {
                    a.this.mIsKeyboardOpen = false;
                    a.this.onKeyboardVisibilityChanged(false);
                }
            }
        };
        this.dGW.getPageContext().getPageActivity().getWindow().getDecorView().getViewTreeObserver().addOnGlobalLayoutListener(this.globalListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(final d dVar) {
        final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.dGW.getPageContext().getPageActivity());
        aVar.dS(null);
        aVar.cp(e.j.del_post_confirm);
        aVar.aF(true);
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
        aVar.b(this.dGW.getPageContext()).yl();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(d dVar) {
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_DELETE_SUB_COMMENT);
        httpMessage.addParam("user_id", this.bCd);
        httpMessage.addParam("main_tower_id", dVar.dHm);
        httpMessage.addParam("id", dVar.id);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void nm(String str) {
        lL(0);
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_ADD_SUB_COMMENT);
        httpMessage.addParam("user_id", this.bCd);
        httpMessage.addParam("reply_user_id", this.dHz);
        httpMessage.addParam("content", str);
        httpMessage.addParam("main_tower_id", this.dGK);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aAK() {
        this.dHz = this.dHx != null ? this.dHx.userId : null;
    }

    private void aAL() {
        if (!v.z(this.dHy)) {
            this.mNavigationBar.setCenterTextTitle(String.format(this.dGW.getResources().getString(e.j.subpb_floor_reply_count), ao.J(this.dHy.size())));
        } else {
            this.mNavigationBar.setCenterTextTitle(this.dGW.getResources().getString(e.j.reply));
        }
    }

    private void lK(final int i) {
        this.dHs.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.frs.gamesubpb.view.a.10
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                if (!TextUtils.isEmpty(charSequence)) {
                    a.this.dHt.setEnabled(true);
                    String charSequence2 = charSequence.toString();
                    if (!StringUtils.isNull(charSequence2) && y.m16if(charSequence2) > i) {
                        String o = y.o(charSequence2, 0, i - 1);
                        a.this.dHs.setText(o);
                        a.this.dHs.setSelection(a.this.dHs.getText().length());
                        UtilHelper.showToast(a.this.dGW.getPageContext().getPageActivity().getApplication(), a.this.dGW.getPageContext().getPageActivity().getResources().getString(e.j.edit_text_over_limit_tip, Integer.valueOf(o.length())));
                        return;
                    }
                    return;
                }
                a.this.aAK();
                a.this.dHt.setEnabled(false);
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
            }
        });
    }

    private void aAM() {
        this.mNavigationBar.setmBackImageViewBg(e.f.subpb_navigationbar_close, e.f.subpb_navigationbar_close);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gB(final boolean z) {
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
            this.aRy.getWindowVisibleDisplayFrame(rect);
            this.dHr.scrollTo(this.dHr.getScrollX(), (l.aS(this.dGW.getPageContext().getPageActivity())[1] - rect.bottom) - (MenuKeyUtils.hasSmartBar() ? l.dip2px(this.dGW.getPageContext().getPageActivity(), 48.0f) : 0));
            return;
        }
        this.dHr.setScrollY(0);
    }

    private void gC(boolean z) {
        if (v.z(this.dHy)) {
            this.mListView.setNextPage(null);
            this.dHv.setVisibility(0);
        } else {
            this.mListView.setNextPage(this.dHq);
            this.dHv.setVisibility(8);
            if (z) {
                this.dHq.BI();
            } else {
                this.dHq.BJ();
            }
        }
        aAL();
    }

    public void a(boolean z, com.baidu.tieba.frs.gamesubpb.model.b bVar, List<h> list) {
        this.hasMore = z;
        this.dHx = bVar;
        aAK();
        if (v.z(list)) {
            gC(z);
            return;
        }
        this.dHy.clear();
        this.dHy.addAll(list);
        this.dHv.setVisibility(8);
        this.mListView.setNextPage(this.dHq);
        this.dHw.setData(list);
        aAM();
        this.dHu.setVisibility(0);
        this.dHu.setText(e.j.say_your_point);
        gC(z);
    }

    public void a(boolean z, String str, d dVar) {
        lL(8);
        if (z && dVar != null) {
            BdToast.a(this.dGW.getPageContext().getPageActivity(), this.dGW.getPageContext().getString(e.j.subpb_add_comment_succ_tip), 1).yt();
            this.dHs.setText((CharSequence) null);
            this.dHy.add(dVar);
            this.dHw.setData(this.dHy);
            gC(this.hasMore);
            this.dHs.post(new Runnable() { // from class: com.baidu.tieba.frs.gamesubpb.view.a.2
                @Override // java.lang.Runnable
                public void run() {
                    a.this.dHs.requestFocus();
                    l.a(a.this.dGW.getPageContext().getPageActivity(), a.this.dHs);
                }
            });
            return;
        }
        if (TextUtils.isEmpty(str)) {
            str = this.dGW.getPageContext().getString(e.j.subpb_add_comment_fail_tip);
        }
        BdToast.a(this.dGW.getPageContext().getPageActivity(), str, 1).yt();
    }

    public void b(boolean z, String str, d dVar) {
        if (z) {
            BdToast.a(this.dGW.getPageContext().getPageActivity(), this.dGW.getPageContext().getString(e.j.subpb_delete_comment_succ_tip), 1).yt();
            this.dHy.remove(dVar);
            this.dHw.setData(this.dHy);
            gC(this.hasMore);
            return;
        }
        if (TextUtils.isEmpty(str)) {
            str = this.dGW.getPageContext().getString(e.j.subpb_delete_comment_fail_tip);
        }
        BdToast.a(this.dGW.getPageContext().getPageActivity(), str, 1).yt();
    }

    public void gD(boolean z) {
        if (this.deF != null && this.deF.getLayoutParams() != null) {
            ViewGroup.LayoutParams layoutParams = this.deF.getLayoutParams();
            if (z) {
                aAM();
                layoutParams.height = l.h(this.dGW.getPageContext().getPageActivity(), e.C0141e.ds98);
            } else {
                layoutParams.height = l.h(this.dGW.getPageContext().getPageActivity(), e.C0141e.ds98) + UtilHelper.getLightStatusBarHeight();
            }
            this.deF.setLayoutParams(layoutParams);
        }
    }

    public void aO(View view) {
        if (this.deF != null && this.mNavigationBar != null) {
            if (this.mNavigationBar.isNavigationBarExcludeStatusbarVisible()) {
                this.mNavigationBar.showNavigationBarExcludeStatusbar(false);
                if (UtilHelper.canUseStyleImmersiveSticky()) {
                    this.deF.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight()));
                } else if (this.mListView != null) {
                    this.mListView.removeHeaderView(this.deF);
                }
                this.mNavigationBar.setVisibility(8);
                return;
            }
            this.mNavigationBar.showNavigationBarExcludeStatusbar(true);
            if (UtilHelper.canUseStyleImmersiveSticky()) {
                this.deF.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + l.h(this.dGW.getActivity(), e.C0141e.ds98)));
            } else if (this.mListView != null) {
                this.mListView.addHeaderView(this.deF, 0);
            }
            this.mNavigationBar.setVisibility(0);
        }
    }

    public void nn(String str) {
        this.dHu.setVisibility(8);
        this.aRy.setVisibility(0);
        this.dHs.post(new Runnable() { // from class: com.baidu.tieba.frs.gamesubpb.view.a.3
            @Override // java.lang.Runnable
            public void run() {
                a.this.dHs.requestFocus();
                l.b(a.this.dGW.getPageContext().getPageActivity(), a.this.dHs);
            }
        });
        if (!TextUtils.isEmpty(str)) {
            String format = String.format(this.dGW.getPageContext().getPageActivity().getResources().getString(e.j.reply_sub_floor), str);
            this.dHs.setText(format);
            this.dHs.setSelection(format.length());
        }
    }

    public void lL(int i) {
        this.mProgressBar.setVisibility(i);
    }

    public View aAN() {
        return this.deF;
    }

    public View getRootView() {
        return this.mRootView;
    }

    public ListView getListView() {
        return this.mListView;
    }

    public TextView aAO() {
        return this.dHu;
    }

    public NavigationBar WW() {
        return this.mNavigationBar;
    }

    public void e(com.baidu.tieba.frs.gamesubpb.c cVar) {
        this.dGG = cVar;
    }

    public void a(BdListView.e eVar) {
        this.mListView.setOnSrollToBottomListener(eVar);
    }

    public void onChangeSkinType(int i) {
        this.dGW.getLayoutMode().setNightMode(i == 1);
        this.dGW.getLayoutMode().onModeChanged(this.mRootView);
        al.j(this.mRootView, e.d.cp_bg_line_d);
        this.mNavigationBar.onChangeSkinType(this.dGW.getPageContext(), i);
        this.dHq.dM(i);
        al.h(this.dHu, e.d.cp_cont_e);
        this.dHu.setAlpha(0.95f);
        al.i(this.dHu, e.f.pb_ecomm_comment_bg);
        al.h(this.dHv, e.d.cp_cont_d);
        al.i(this.aRy, e.f.pb_ecomm_comment_bg);
        al.h(this.dHs, e.d.cp_cont_f);
        this.dHs.setHintTextColor(al.getColor(e.d.cp_cont_e));
        al.h(this.dHt, e.d.game_sub_pb_send_txt_color);
    }

    public void onDestroy() {
        if (this.globalListener != null) {
            this.dGW.getPageContext().getPageActivity().getWindow().getDecorView().getViewTreeObserver().removeGlobalOnLayoutListener(this.globalListener);
        }
    }
}
