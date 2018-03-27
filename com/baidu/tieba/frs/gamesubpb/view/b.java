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
import com.baidu.adp.widget.ListView.i;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PersonPolymericActivityConfig;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tbadk.util.w;
import com.baidu.tieba.d;
import com.baidu.tieba.frs.gamesubpb.FrsGameSubPbActivity;
import com.baidu.tieba.frs.gamesubpb.a;
import com.baidu.tieba.frs.gamesubpb.model.e;
import com.baidu.tieba.pb.a.c;
import com.compatible.menukey.MenuKeyUtils;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class b {
    private com.baidu.tieba.pb.a.c bLJ = new com.baidu.tieba.pb.a.c(new c.a() { // from class: com.baidu.tieba.frs.gamesubpb.view.b.1
        @Override // com.baidu.tieba.pb.a.c.a
        public boolean c(View view, MotionEvent motionEvent) {
            b.this.gi(false);
            b.this.bQ(view);
            b.this.gi(true);
            return true;
        }

        @Override // com.baidu.tieba.pb.a.c.a
        public boolean d(View view, MotionEvent motionEvent) {
            return false;
        }

        @Override // com.baidu.tieba.pb.a.c.a
        public boolean e(View view, MotionEvent motionEvent) {
            return true;
        }
    });
    private View bgB;
    private LinearLayout but;
    private long cbQ;
    private String dPC;
    private FrsGameSubPbActivity dPO;
    private com.baidu.tieba.frs.gamesubpb.c dPy;
    private e dQi;
    private FrameLayout dQj;
    private EditText dQk;
    private TextView dQl;
    private TextView dQm;
    private TextView dQn;
    private com.baidu.tieba.frs.gamesubpb.b dQo;
    private com.baidu.tieba.frs.gamesubpb.model.b dQp;
    private List<i> dQq;
    private String dQr;
    private View duX;
    private ViewTreeObserver.OnGlobalLayoutListener globalListener;
    private boolean hasMore;
    private View.OnClickListener mCommonClickListener;
    private boolean mIsKeyboardOpen;
    private BdTypeListView mListView;
    private NavigationBar mNavigationBar;
    private ProgressBar mProgressBar;
    private RelativeLayout mRootView;

    public b(FrsGameSubPbActivity frsGameSubPbActivity, View.OnClickListener onClickListener, String str) {
        this.dPO = frsGameSubPbActivity;
        this.mCommonClickListener = onClickListener;
        this.dPC = str;
        this.mRootView = (RelativeLayout) LayoutInflater.from(frsGameSubPbActivity.getPageContext().getPageActivity()).inflate(d.h.frs_game_sub_pb_activity, (ViewGroup) null);
        this.mListView = (BdTypeListView) this.mRootView.findViewById(d.g.new_sub_pb_list);
        this.mListView.setOnTouchListener(this.bLJ);
        this.mListView.setOnScrollListener(new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.frs.gamesubpb.view.b.4
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
                if (i != 0) {
                    l.a(b.this.dPO.getPageContext().getPageActivity(), b.this.dQk);
                }
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            }
        });
        this.dQi = new e(this.dPO.getPageContext());
        this.duX = BdListViewHelper.a(this.dPO.getActivity(), this.mListView, BdListViewHelper.HeadType.DEFAULT);
        this.dQm = (TextView) this.mRootView.findViewById(d.g.subpb_editor_tool_comment_reply_text);
        this.dQm.setOnClickListener(this.mCommonClickListener);
        this.dQn = (TextView) this.mRootView.findViewById(d.g.no_reply_list_view);
        this.dQj = (FrameLayout) this.mRootView.findViewById(d.g.bottom_view);
        this.but = (LinearLayout) this.mRootView.findViewById(d.g.subpb_editor_tool_comment_input_container);
        this.dQk = (EditText) this.mRootView.findViewById(d.g.subpb_editor_tool_comment_input_edit);
        this.dQl = (TextView) this.mRootView.findViewById(d.g.subpb_editor_tool_comment_send_tv);
        this.dQl.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.gamesubpb.view.b.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.this.lU(b.this.dQk.getText().toString());
            }
        });
        this.mProgressBar = (ProgressBar) this.mRootView.findViewById(d.g.progressBar);
        ays();
        this.dQo = new com.baidu.tieba.frs.gamesubpb.b(this.dPO.getPageContext(), this.mListView);
        this.dQo.setClickListener(new a.InterfaceC0156a() { // from class: com.baidu.tieba.frs.gamesubpb.view.b.6
            @Override // com.baidu.tieba.frs.gamesubpb.a.InterfaceC0156a
            public void a(com.baidu.tieba.frs.gamesubpb.model.d dVar) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonPolymericActivityConfig(b.this.dPO.getPageContext().getPageActivity()).createNormalConfig(Long.valueOf(dVar.userId).longValue(), String.valueOf(b.this.cbQ).equals(dVar.userId), false)));
            }

            @Override // com.baidu.tieba.frs.gamesubpb.a.InterfaceC0156a
            public void b(com.baidu.tieba.frs.gamesubpb.model.d dVar) {
                if (dVar != null) {
                    b.this.d(dVar);
                }
            }

            @Override // com.baidu.tieba.frs.gamesubpb.a.InterfaceC0156a
            public void c(com.baidu.tieba.frs.gamesubpb.model.d dVar) {
                if (b.this.dPy != null) {
                    b.this.dPy.ayk();
                }
                if (dVar == null) {
                    b.this.lV(null);
                    b.this.ayu();
                    return;
                }
                b.this.lV(dVar.userName);
                b.this.dQr = dVar.userId;
            }
        });
        ny(140);
        ayt();
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        this.dQq = new ArrayList();
        this.cbQ = com.baidu.adp.lib.g.b.c(TbadkCoreApplication.getCurrentAccount(), 0L);
    }

    private void ays() {
        this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(d.g.view_navigation_bar);
        this.bgB = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        ImageView backImageView = this.mNavigationBar.getBackImageView();
        if (backImageView != null && (backImageView.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bgB.getLayoutParams();
            int t = l.t(this.dPO.getPageContext().getPageActivity(), d.e.ds30);
            layoutParams.height = t;
            layoutParams.width = t;
            backImageView.setLayoutParams(layoutParams);
        }
        if (this.bgB != null && (this.bgB.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.bgB.getLayoutParams();
            layoutParams2.width = -2;
            layoutParams2.height = -1;
            this.bgB.setPadding(l.t(this.dPO.getPageContext().getPageActivity(), d.e.ds32), this.bgB.getPaddingTop(), this.bgB.getPaddingRight(), this.bgB.getPaddingBottom());
            this.bgB.setLayoutParams(layoutParams2);
        }
        this.mNavigationBar.setmBackImageViewBg(d.f.subpb_navigationbar_back, d.f.subpb_navigationbar_back);
    }

    private void ayt() {
        this.globalListener = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tieba.frs.gamesubpb.view.b.7
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                Rect rect = new Rect();
                b.this.dPO.getPageContext().getPageActivity().getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
                int p = l.p(b.this.dPO.getPageContext().getPageActivity());
                int[] as = l.as(b.this.dPO.getPageContext().getPageActivity());
                if (as[1] - rect.bottom > as[1] / 4 && !b.this.mIsKeyboardOpen) {
                    b.this.mIsKeyboardOpen = true;
                    b.this.onKeyboardVisibilityChanged(true);
                } else if (as[1] - rect.height() == p && b.this.mIsKeyboardOpen) {
                    b.this.mIsKeyboardOpen = false;
                    b.this.onKeyboardVisibilityChanged(false);
                }
            }
        };
        this.dPO.getPageContext().getPageActivity().getWindow().getDecorView().getViewTreeObserver().addOnGlobalLayoutListener(this.globalListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(final com.baidu.tieba.frs.gamesubpb.model.d dVar) {
        final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.dPO.getPageContext().getPageActivity());
        aVar.dj(null);
        aVar.fb(d.j.del_post_confirm);
        aVar.ba(true);
        aVar.a(d.j.dialog_ok, new a.b() { // from class: com.baidu.tieba.frs.gamesubpb.view.b.8
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar.dismiss();
                b.this.e(dVar);
            }
        });
        aVar.b(d.j.dialog_cancel, new a.b() { // from class: com.baidu.tieba.frs.gamesubpb.view.b.9
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar.dismiss();
            }
        });
        aVar.b(this.dPO.getPageContext()).AV();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(com.baidu.tieba.frs.gamesubpb.model.d dVar) {
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_DELETE_SUB_COMMENT);
        httpMessage.addParam("user_id", this.cbQ);
        httpMessage.addParam("main_tower_id", dVar.dQe);
        httpMessage.addParam("id", dVar.id);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lU(String str) {
        nz(0);
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_ADD_SUB_COMMENT);
        httpMessage.addParam("user_id", this.cbQ);
        httpMessage.addParam("reply_user_id", this.dQr);
        httpMessage.addParam("content", str);
        httpMessage.addParam("main_tower_id", this.dPC);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ayu() {
        this.dQr = this.dQp != null ? this.dQp.userId : null;
    }

    private void ayv() {
        if (!v.E(this.dQq)) {
            this.mNavigationBar.setCenterTextTitle(String.format(this.dPO.getResources().getString(d.j.subpb_floor_reply_count), am.H(this.dQq.size())));
        } else {
            this.mNavigationBar.setCenterTextTitle(this.dPO.getResources().getString(d.j.subpb_floor_default_title));
        }
    }

    private void ny(final int i) {
        this.dQk.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.frs.gamesubpb.view.b.10
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                if (!TextUtils.isEmpty(charSequence)) {
                    b.this.dQl.setEnabled(true);
                    String charSequence2 = charSequence.toString();
                    if (!StringUtils.isNull(charSequence2) && w.hs(charSequence2) > i) {
                        String j = w.j(charSequence2, 0, i - 1);
                        b.this.dQk.setText(j);
                        b.this.dQk.setSelection(b.this.dQk.getText().length());
                        UtilHelper.showToast(b.this.dPO.getPageContext().getPageActivity().getApplication(), b.this.dPO.getPageContext().getPageActivity().getResources().getString(d.j.edit_text_over_limit_tip, Integer.valueOf(j.length())));
                        return;
                    }
                    return;
                }
                b.this.ayu();
                b.this.dQl.setEnabled(false);
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
            }
        });
    }

    private void ayw() {
        this.mNavigationBar.setmBackImageViewBg(d.f.subpb_navigationbar_close, d.f.subpb_navigationbar_close);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gi(final boolean z) {
        if (this.mListView != null) {
            if (!z) {
                this.mListView.setEnabled(z);
            } else {
                this.mListView.postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.gamesubpb.view.b.11
                    @Override // java.lang.Runnable
                    public void run() {
                        b.this.mListView.setEnabled(z);
                    }
                }, 10L);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onKeyboardVisibilityChanged(boolean z) {
        if (z) {
            Rect rect = new Rect();
            this.but.getWindowVisibleDisplayFrame(rect);
            this.dQj.scrollTo(this.dQj.getScrollX(), (l.as(this.dPO.getPageContext().getPageActivity())[1] - rect.bottom) - (MenuKeyUtils.hasSmartBar() ? l.dip2px(this.dPO.getPageContext().getPageActivity(), 48.0f) : 0));
            return;
        }
        this.dQj.setScrollY(0);
    }

    private void gj(boolean z) {
        if (v.E(this.dQq)) {
            this.mListView.setNextPage(null);
            this.dQn.setVisibility(0);
        } else {
            this.mListView.setNextPage(this.dQi);
            this.dQn.setVisibility(8);
            if (z) {
                this.dQi.Eg();
            } else {
                this.dQi.Eh();
            }
        }
        ayv();
    }

    public void a(boolean z, com.baidu.tieba.frs.gamesubpb.model.b bVar, List<i> list) {
        this.hasMore = z;
        this.dQp = bVar;
        ayu();
        if (v.E(list)) {
            gj(z);
            return;
        }
        this.dQq.clear();
        this.dQq.addAll(list);
        this.dQn.setVisibility(8);
        this.mListView.setNextPage(this.dQi);
        this.dQo.setData(list);
        ayw();
        this.dQm.setVisibility(0);
        this.dQm.setText(d.j.say_your_point);
        gj(z);
    }

    public void a(boolean z, String str, com.baidu.tieba.frs.gamesubpb.model.d dVar) {
        nz(8);
        if (z && dVar != null) {
            BdToast.a(this.dPO.getPageContext().getPageActivity(), this.dPO.getPageContext().getString(d.j.subpb_add_comment_succ_tip), 1).Bd();
            this.dQk.setText((CharSequence) null);
            this.dQq.add(dVar);
            this.dQo.setData(this.dQq);
            gj(this.hasMore);
            this.dQk.post(new Runnable() { // from class: com.baidu.tieba.frs.gamesubpb.view.b.2
                @Override // java.lang.Runnable
                public void run() {
                    b.this.dQk.requestFocus();
                    l.a(b.this.dPO.getPageContext().getPageActivity(), b.this.dQk);
                }
            });
            return;
        }
        if (TextUtils.isEmpty(str)) {
            str = this.dPO.getPageContext().getString(d.j.subpb_add_comment_fail_tip);
        }
        BdToast.a(this.dPO.getPageContext().getPageActivity(), str, 1).Bd();
    }

    public void b(boolean z, String str, com.baidu.tieba.frs.gamesubpb.model.d dVar) {
        if (z) {
            BdToast.a(this.dPO.getPageContext().getPageActivity(), this.dPO.getPageContext().getString(d.j.subpb_delete_comment_succ_tip), 1).Bd();
            this.dQq.remove(dVar);
            this.dQo.setData(this.dQq);
            gj(this.hasMore);
            return;
        }
        if (TextUtils.isEmpty(str)) {
            str = this.dPO.getPageContext().getString(d.j.subpb_delete_comment_fail_tip);
        }
        BdToast.a(this.dPO.getPageContext().getPageActivity(), str, 1).Bd();
    }

    public void gk(boolean z) {
        if (this.duX != null && this.duX.getLayoutParams() != null) {
            ViewGroup.LayoutParams layoutParams = this.duX.getLayoutParams();
            if (z) {
                ayw();
                layoutParams.height = l.t(this.dPO.getPageContext().getPageActivity(), d.e.ds98);
            } else {
                layoutParams.height = l.t(this.dPO.getPageContext().getPageActivity(), d.e.ds98) + UtilHelper.getLightStatusBarHeight();
            }
            this.duX.setLayoutParams(layoutParams);
        }
    }

    public void bQ(View view) {
        if (this.duX != null && this.mNavigationBar != null) {
            if (this.mNavigationBar.isNavigationBarExcludeStatusbarVisible()) {
                this.mNavigationBar.showNavigationBarExcludeStatusbar(false);
                if (UtilHelper.canUseStyleImmersiveSticky()) {
                    this.duX.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight()));
                } else if (this.mListView != null) {
                    this.mListView.removeHeaderView(this.duX);
                }
                this.mNavigationBar.setVisibility(8);
                return;
            }
            this.mNavigationBar.showNavigationBarExcludeStatusbar(true);
            if (UtilHelper.canUseStyleImmersiveSticky()) {
                this.duX.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + l.t(this.dPO.getActivity(), d.e.ds98)));
            } else if (this.mListView != null) {
                this.mListView.addHeaderView(this.duX, 0);
            }
            this.mNavigationBar.setVisibility(0);
        }
    }

    public void lV(String str) {
        this.dQm.setVisibility(8);
        this.but.setVisibility(0);
        this.dQk.post(new Runnable() { // from class: com.baidu.tieba.frs.gamesubpb.view.b.3
            @Override // java.lang.Runnable
            public void run() {
                b.this.dQk.requestFocus();
                l.b(b.this.dPO.getPageContext().getPageActivity(), b.this.dQk);
            }
        });
        if (!TextUtils.isEmpty(str)) {
            String format = String.format(this.dPO.getPageContext().getPageActivity().getResources().getString(d.j.reply_sub_floor), str);
            this.dQk.setText(format);
            this.dQk.setSelection(format.length());
        }
    }

    public void nz(int i) {
        this.mProgressBar.setVisibility(i);
    }

    public View ayx() {
        return this.duX;
    }

    public View getRootView() {
        return this.mRootView;
    }

    public ListView getListView() {
        return this.mListView;
    }

    public TextView ayy() {
        return this.dQm;
    }

    public NavigationBar avk() {
        return this.mNavigationBar;
    }

    public void e(com.baidu.tieba.frs.gamesubpb.c cVar) {
        this.dPy = cVar;
    }

    public void a(BdListView.e eVar) {
        this.mListView.setOnSrollToBottomListener(eVar);
    }

    public void onChangeSkinType(int i) {
        this.dPO.getLayoutMode().aQ(i == 1);
        this.dPO.getLayoutMode().aM(this.mRootView);
        aj.t(this.mRootView, d.C0141d.cp_bg_line_d);
        this.mNavigationBar.onChangeSkinType(this.dPO.getPageContext(), i);
        this.dQi.gx(i);
        aj.r(this.dQm, d.C0141d.cp_cont_e);
        this.dQm.setAlpha(0.95f);
        aj.s(this.dQm, d.f.pb_ecomm_comment_bg);
        aj.r(this.dQn, d.C0141d.cp_cont_d);
        aj.s(this.but, d.f.pb_ecomm_comment_bg);
        aj.r(this.dQk, d.C0141d.cp_cont_f);
        this.dQk.setHintTextColor(aj.getColor(d.C0141d.cp_cont_e));
        aj.r(this.dQl, d.C0141d.game_sub_pb_send_txt_color);
    }

    public void onDestroy() {
        if (this.globalListener != null) {
            this.dPO.getPageContext().getPageActivity().getWindow().getDecorView().getViewTreeObserver().removeGlobalOnLayoutListener(this.globalListener);
        }
    }
}
