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
    private com.baidu.tieba.pb.a.c bLT = new com.baidu.tieba.pb.a.c(new c.a() { // from class: com.baidu.tieba.frs.gamesubpb.view.b.1
        @Override // com.baidu.tieba.pb.a.c.a
        public boolean c(View view, MotionEvent motionEvent) {
            b.this.gh(false);
            b.this.bQ(view);
            b.this.gh(true);
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
    private View bgK;
    private LinearLayout buD;
    private long cbZ;
    private com.baidu.tieba.frs.gamesubpb.c dPF;
    private String dPJ;
    private FrsGameSubPbActivity dPV;
    private e dQp;
    private FrameLayout dQq;
    private EditText dQr;
    private TextView dQs;
    private TextView dQt;
    private TextView dQu;
    private com.baidu.tieba.frs.gamesubpb.b dQv;
    private com.baidu.tieba.frs.gamesubpb.model.b dQw;
    private List<i> dQx;
    private String dQy;
    private View dvg;
    private ViewTreeObserver.OnGlobalLayoutListener globalListener;
    private boolean hasMore;
    private View.OnClickListener mCommonClickListener;
    private boolean mIsKeyboardOpen;
    private BdTypeListView mListView;
    private NavigationBar mNavigationBar;
    private ProgressBar mProgressBar;
    private RelativeLayout mRootView;

    public b(FrsGameSubPbActivity frsGameSubPbActivity, View.OnClickListener onClickListener, String str) {
        this.dPV = frsGameSubPbActivity;
        this.mCommonClickListener = onClickListener;
        this.dPJ = str;
        this.mRootView = (RelativeLayout) LayoutInflater.from(frsGameSubPbActivity.getPageContext().getPageActivity()).inflate(d.h.frs_game_sub_pb_activity, (ViewGroup) null);
        this.mListView = (BdTypeListView) this.mRootView.findViewById(d.g.new_sub_pb_list);
        this.mListView.setOnTouchListener(this.bLT);
        this.mListView.setOnScrollListener(new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.frs.gamesubpb.view.b.4
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
                if (i != 0) {
                    l.a(b.this.dPV.getPageContext().getPageActivity(), b.this.dQr);
                }
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            }
        });
        this.dQp = new e(this.dPV.getPageContext());
        this.dvg = BdListViewHelper.a(this.dPV.getActivity(), this.mListView, BdListViewHelper.HeadType.DEFAULT);
        this.dQt = (TextView) this.mRootView.findViewById(d.g.subpb_editor_tool_comment_reply_text);
        this.dQt.setOnClickListener(this.mCommonClickListener);
        this.dQu = (TextView) this.mRootView.findViewById(d.g.no_reply_list_view);
        this.dQq = (FrameLayout) this.mRootView.findViewById(d.g.bottom_view);
        this.buD = (LinearLayout) this.mRootView.findViewById(d.g.subpb_editor_tool_comment_input_container);
        this.dQr = (EditText) this.mRootView.findViewById(d.g.subpb_editor_tool_comment_input_edit);
        this.dQs = (TextView) this.mRootView.findViewById(d.g.subpb_editor_tool_comment_send_tv);
        this.dQs.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.gamesubpb.view.b.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.this.lU(b.this.dQr.getText().toString());
            }
        });
        this.mProgressBar = (ProgressBar) this.mRootView.findViewById(d.g.progressBar);
        ayr();
        this.dQv = new com.baidu.tieba.frs.gamesubpb.b(this.dPV.getPageContext(), this.mListView);
        this.dQv.setClickListener(new a.InterfaceC0155a() { // from class: com.baidu.tieba.frs.gamesubpb.view.b.6
            @Override // com.baidu.tieba.frs.gamesubpb.a.InterfaceC0155a
            public void a(com.baidu.tieba.frs.gamesubpb.model.d dVar) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonPolymericActivityConfig(b.this.dPV.getPageContext().getPageActivity()).createNormalConfig(Long.valueOf(dVar.userId).longValue(), String.valueOf(b.this.cbZ).equals(dVar.userId), false)));
            }

            @Override // com.baidu.tieba.frs.gamesubpb.a.InterfaceC0155a
            public void b(com.baidu.tieba.frs.gamesubpb.model.d dVar) {
                if (dVar != null) {
                    b.this.d(dVar);
                }
            }

            @Override // com.baidu.tieba.frs.gamesubpb.a.InterfaceC0155a
            public void c(com.baidu.tieba.frs.gamesubpb.model.d dVar) {
                if (b.this.dPF != null) {
                    b.this.dPF.ayj();
                }
                if (dVar == null) {
                    b.this.lV(null);
                    b.this.ayt();
                    return;
                }
                b.this.lV(dVar.userName);
                b.this.dQy = dVar.userId;
            }
        });
        ny(140);
        ays();
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        this.dQx = new ArrayList();
        this.cbZ = com.baidu.adp.lib.g.b.c(TbadkCoreApplication.getCurrentAccount(), 0L);
    }

    private void ayr() {
        this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(d.g.view_navigation_bar);
        this.bgK = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        ImageView backImageView = this.mNavigationBar.getBackImageView();
        if (backImageView != null && (backImageView.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bgK.getLayoutParams();
            int t = l.t(this.dPV.getPageContext().getPageActivity(), d.e.ds30);
            layoutParams.height = t;
            layoutParams.width = t;
            backImageView.setLayoutParams(layoutParams);
        }
        if (this.bgK != null && (this.bgK.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.bgK.getLayoutParams();
            layoutParams2.width = -2;
            layoutParams2.height = -1;
            this.bgK.setPadding(l.t(this.dPV.getPageContext().getPageActivity(), d.e.ds32), this.bgK.getPaddingTop(), this.bgK.getPaddingRight(), this.bgK.getPaddingBottom());
            this.bgK.setLayoutParams(layoutParams2);
        }
        this.mNavigationBar.setmBackImageViewBg(d.f.subpb_navigationbar_back, d.f.subpb_navigationbar_back);
    }

    private void ays() {
        this.globalListener = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tieba.frs.gamesubpb.view.b.7
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                Rect rect = new Rect();
                b.this.dPV.getPageContext().getPageActivity().getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
                int p = l.p(b.this.dPV.getPageContext().getPageActivity());
                int[] as = l.as(b.this.dPV.getPageContext().getPageActivity());
                if (as[1] - rect.bottom > as[1] / 4 && !b.this.mIsKeyboardOpen) {
                    b.this.mIsKeyboardOpen = true;
                    b.this.onKeyboardVisibilityChanged(true);
                } else if (as[1] - rect.height() == p && b.this.mIsKeyboardOpen) {
                    b.this.mIsKeyboardOpen = false;
                    b.this.onKeyboardVisibilityChanged(false);
                }
            }
        };
        this.dPV.getPageContext().getPageActivity().getWindow().getDecorView().getViewTreeObserver().addOnGlobalLayoutListener(this.globalListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(final com.baidu.tieba.frs.gamesubpb.model.d dVar) {
        final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.dPV.getPageContext().getPageActivity());
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
        aVar.b(this.dPV.getPageContext()).AU();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(com.baidu.tieba.frs.gamesubpb.model.d dVar) {
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_DELETE_SUB_COMMENT);
        httpMessage.addParam("user_id", this.cbZ);
        httpMessage.addParam("main_tower_id", dVar.dQl);
        httpMessage.addParam("id", dVar.id);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lU(String str) {
        nz(0);
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_ADD_SUB_COMMENT);
        httpMessage.addParam("user_id", this.cbZ);
        httpMessage.addParam("reply_user_id", this.dQy);
        httpMessage.addParam("content", str);
        httpMessage.addParam("main_tower_id", this.dPJ);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ayt() {
        this.dQy = this.dQw != null ? this.dQw.userId : null;
    }

    private void ayu() {
        if (!v.E(this.dQx)) {
            this.mNavigationBar.setCenterTextTitle(String.format(this.dPV.getResources().getString(d.j.subpb_floor_reply_count), am.H(this.dQx.size())));
        } else {
            this.mNavigationBar.setCenterTextTitle(this.dPV.getResources().getString(d.j.subpb_floor_default_title));
        }
    }

    private void ny(final int i) {
        this.dQr.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.frs.gamesubpb.view.b.10
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                if (!TextUtils.isEmpty(charSequence)) {
                    b.this.dQs.setEnabled(true);
                    String charSequence2 = charSequence.toString();
                    if (!StringUtils.isNull(charSequence2) && w.hs(charSequence2) > i) {
                        String j = w.j(charSequence2, 0, i - 1);
                        b.this.dQr.setText(j);
                        b.this.dQr.setSelection(b.this.dQr.getText().length());
                        UtilHelper.showToast(b.this.dPV.getPageContext().getPageActivity().getApplication(), b.this.dPV.getPageContext().getPageActivity().getResources().getString(d.j.edit_text_over_limit_tip, Integer.valueOf(j.length())));
                        return;
                    }
                    return;
                }
                b.this.ayt();
                b.this.dQs.setEnabled(false);
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
            }
        });
    }

    private void ayv() {
        this.mNavigationBar.setmBackImageViewBg(d.f.subpb_navigationbar_close, d.f.subpb_navigationbar_close);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gh(final boolean z) {
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
            this.buD.getWindowVisibleDisplayFrame(rect);
            this.dQq.scrollTo(this.dQq.getScrollX(), (l.as(this.dPV.getPageContext().getPageActivity())[1] - rect.bottom) - (MenuKeyUtils.hasSmartBar() ? l.dip2px(this.dPV.getPageContext().getPageActivity(), 48.0f) : 0));
            return;
        }
        this.dQq.setScrollY(0);
    }

    private void gi(boolean z) {
        if (v.E(this.dQx)) {
            this.mListView.setNextPage(null);
            this.dQu.setVisibility(0);
        } else {
            this.mListView.setNextPage(this.dQp);
            this.dQu.setVisibility(8);
            if (z) {
                this.dQp.Eg();
            } else {
                this.dQp.Eh();
            }
        }
        ayu();
    }

    public void a(boolean z, com.baidu.tieba.frs.gamesubpb.model.b bVar, List<i> list) {
        this.hasMore = z;
        this.dQw = bVar;
        ayt();
        if (v.E(list)) {
            gi(z);
            return;
        }
        this.dQx.clear();
        this.dQx.addAll(list);
        this.dQu.setVisibility(8);
        this.mListView.setNextPage(this.dQp);
        this.dQv.setData(list);
        ayv();
        this.dQt.setVisibility(0);
        this.dQt.setText(d.j.say_your_point);
        gi(z);
    }

    public void a(boolean z, String str, com.baidu.tieba.frs.gamesubpb.model.d dVar) {
        nz(8);
        if (z && dVar != null) {
            BdToast.a(this.dPV.getPageContext().getPageActivity(), this.dPV.getPageContext().getString(d.j.subpb_add_comment_succ_tip), 1).Bc();
            this.dQr.setText((CharSequence) null);
            this.dQx.add(dVar);
            this.dQv.setData(this.dQx);
            gi(this.hasMore);
            this.dQr.post(new Runnable() { // from class: com.baidu.tieba.frs.gamesubpb.view.b.2
                @Override // java.lang.Runnable
                public void run() {
                    b.this.dQr.requestFocus();
                    l.a(b.this.dPV.getPageContext().getPageActivity(), b.this.dQr);
                }
            });
            return;
        }
        if (TextUtils.isEmpty(str)) {
            str = this.dPV.getPageContext().getString(d.j.subpb_add_comment_fail_tip);
        }
        BdToast.a(this.dPV.getPageContext().getPageActivity(), str, 1).Bc();
    }

    public void b(boolean z, String str, com.baidu.tieba.frs.gamesubpb.model.d dVar) {
        if (z) {
            BdToast.a(this.dPV.getPageContext().getPageActivity(), this.dPV.getPageContext().getString(d.j.subpb_delete_comment_succ_tip), 1).Bc();
            this.dQx.remove(dVar);
            this.dQv.setData(this.dQx);
            gi(this.hasMore);
            return;
        }
        if (TextUtils.isEmpty(str)) {
            str = this.dPV.getPageContext().getString(d.j.subpb_delete_comment_fail_tip);
        }
        BdToast.a(this.dPV.getPageContext().getPageActivity(), str, 1).Bc();
    }

    public void gj(boolean z) {
        if (this.dvg != null && this.dvg.getLayoutParams() != null) {
            ViewGroup.LayoutParams layoutParams = this.dvg.getLayoutParams();
            if (z) {
                ayv();
                layoutParams.height = l.t(this.dPV.getPageContext().getPageActivity(), d.e.ds98);
            } else {
                layoutParams.height = l.t(this.dPV.getPageContext().getPageActivity(), d.e.ds98) + UtilHelper.getLightStatusBarHeight();
            }
            this.dvg.setLayoutParams(layoutParams);
        }
    }

    public void bQ(View view) {
        if (this.dvg != null && this.mNavigationBar != null) {
            if (this.mNavigationBar.isNavigationBarExcludeStatusbarVisible()) {
                this.mNavigationBar.showNavigationBarExcludeStatusbar(false);
                if (UtilHelper.canUseStyleImmersiveSticky()) {
                    this.dvg.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight()));
                } else if (this.mListView != null) {
                    this.mListView.removeHeaderView(this.dvg);
                }
                this.mNavigationBar.setVisibility(8);
                return;
            }
            this.mNavigationBar.showNavigationBarExcludeStatusbar(true);
            if (UtilHelper.canUseStyleImmersiveSticky()) {
                this.dvg.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + l.t(this.dPV.getActivity(), d.e.ds98)));
            } else if (this.mListView != null) {
                this.mListView.addHeaderView(this.dvg, 0);
            }
            this.mNavigationBar.setVisibility(0);
        }
    }

    public void lV(String str) {
        this.dQt.setVisibility(8);
        this.buD.setVisibility(0);
        this.dQr.post(new Runnable() { // from class: com.baidu.tieba.frs.gamesubpb.view.b.3
            @Override // java.lang.Runnable
            public void run() {
                b.this.dQr.requestFocus();
                l.b(b.this.dPV.getPageContext().getPageActivity(), b.this.dQr);
            }
        });
        if (!TextUtils.isEmpty(str)) {
            String format = String.format(this.dPV.getPageContext().getPageActivity().getResources().getString(d.j.reply_sub_floor), str);
            this.dQr.setText(format);
            this.dQr.setSelection(format.length());
        }
    }

    public void nz(int i) {
        this.mProgressBar.setVisibility(i);
    }

    public View ayw() {
        return this.dvg;
    }

    public View getRootView() {
        return this.mRootView;
    }

    public ListView getListView() {
        return this.mListView;
    }

    public TextView ayx() {
        return this.dQt;
    }

    public NavigationBar avk() {
        return this.mNavigationBar;
    }

    public void e(com.baidu.tieba.frs.gamesubpb.c cVar) {
        this.dPF = cVar;
    }

    public void a(BdListView.e eVar) {
        this.mListView.setOnSrollToBottomListener(eVar);
    }

    public void onChangeSkinType(int i) {
        this.dPV.getLayoutMode().aQ(i == 1);
        this.dPV.getLayoutMode().aM(this.mRootView);
        aj.t(this.mRootView, d.C0140d.cp_bg_line_d);
        this.mNavigationBar.onChangeSkinType(this.dPV.getPageContext(), i);
        this.dQp.gx(i);
        aj.r(this.dQt, d.C0140d.cp_cont_e);
        this.dQt.setAlpha(0.95f);
        aj.s(this.dQt, d.f.pb_ecomm_comment_bg);
        aj.r(this.dQu, d.C0140d.cp_cont_d);
        aj.s(this.buD, d.f.pb_ecomm_comment_bg);
        aj.r(this.dQr, d.C0140d.cp_cont_f);
        this.dQr.setHintTextColor(aj.getColor(d.C0140d.cp_cont_e));
        aj.r(this.dQs, d.C0140d.game_sub_pb_send_txt_color);
    }

    public void onDestroy() {
        if (this.globalListener != null) {
            this.dPV.getPageContext().getPageActivity().getWindow().getDecorView().getViewTreeObserver().removeGlobalOnLayoutListener(this.globalListener);
        }
    }
}
