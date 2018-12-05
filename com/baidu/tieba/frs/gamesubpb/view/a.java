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
    private View aMU;
    private long bPk;
    private LinearLayout bam;
    private c brN = new c(new c.a() { // from class: com.baidu.tieba.frs.gamesubpb.view.a.1
        @Override // com.baidu.tieba.pb.a.c.a
        public boolean a(View view, MotionEvent motionEvent) {
            a.this.he(false);
            a.this.aQ(view);
            a.this.he(true);
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
    private FrsGameSubPbActivity dWA;
    private e dWU;
    private FrameLayout dWV;
    private EditText dWW;
    private TextView dWX;
    private TextView dWY;
    private TextView dWZ;
    private com.baidu.tieba.frs.gamesubpb.c dWk;
    private String dWo;
    private com.baidu.tieba.frs.gamesubpb.b dXa;
    private com.baidu.tieba.frs.gamesubpb.model.b dXb;
    private List<h> dXc;
    private String dXd;
    private View duq;
    private ViewTreeObserver.OnGlobalLayoutListener globalListener;
    private boolean hasMore;
    private View.OnClickListener mCommonClickListener;
    private boolean mIsKeyboardOpen;
    private BdTypeListView mListView;
    private NavigationBar mNavigationBar;
    private ProgressBar mProgressBar;
    private RelativeLayout mRootView;

    public a(FrsGameSubPbActivity frsGameSubPbActivity, View.OnClickListener onClickListener, String str) {
        this.dWA = frsGameSubPbActivity;
        this.mCommonClickListener = onClickListener;
        this.dWo = str;
        this.mRootView = (RelativeLayout) LayoutInflater.from(frsGameSubPbActivity.getPageContext().getPageActivity()).inflate(e.h.frs_game_sub_pb_activity, (ViewGroup) null);
        this.mListView = (BdTypeListView) this.mRootView.findViewById(e.g.new_sub_pb_list);
        this.mListView.setOnTouchListener(this.brN);
        this.mListView.setOnScrollListener(new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.frs.gamesubpb.view.a.4
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
                if (i != 0) {
                    l.b(a.this.dWA.getPageContext().getPageActivity(), a.this.dWW);
                }
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            }
        });
        this.dWU = new com.baidu.tieba.frs.gamesubpb.model.e(this.dWA.getPageContext());
        this.duq = BdListViewHelper.a(this.dWA.getActivity(), this.mListView, BdListViewHelper.HeadType.DEFAULT);
        this.dWY = (TextView) this.mRootView.findViewById(e.g.subpb_editor_tool_comment_reply_text);
        this.dWY.setOnClickListener(this.mCommonClickListener);
        this.dWZ = (TextView) this.mRootView.findViewById(e.g.no_reply_list_view);
        this.dWV = (FrameLayout) this.mRootView.findViewById(e.g.bottom_view);
        this.bam = (LinearLayout) this.mRootView.findViewById(e.g.subpb_editor_tool_comment_input_container);
        this.dWW = (EditText) this.mRootView.findViewById(e.g.subpb_editor_tool_comment_input_edit);
        this.dWX = (TextView) this.mRootView.findViewById(e.g.subpb_editor_tool_comment_send_tv);
        this.dWX.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.gamesubpb.view.a.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.oq(a.this.dWW.getText().toString());
            }
        });
        this.mProgressBar = (ProgressBar) this.mRootView.findViewById(e.g.progressBar);
        aFi();
        this.dXa = new com.baidu.tieba.frs.gamesubpb.b(this.dWA.getPageContext(), this.mListView);
        this.dXa.setClickListener(new a.InterfaceC0225a() { // from class: com.baidu.tieba.frs.gamesubpb.view.a.6
            @Override // com.baidu.tieba.frs.gamesubpb.a.InterfaceC0225a
            public void a(d dVar) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonPolymericActivityConfig(a.this.dWA.getPageContext().getPageActivity()).createNormalConfig(Long.valueOf(dVar.userId).longValue(), String.valueOf(a.this.bPk).equals(dVar.userId), false)));
            }

            @Override // com.baidu.tieba.frs.gamesubpb.a.InterfaceC0225a
            public void b(d dVar) {
                if (dVar != null) {
                    a.this.d(dVar);
                }
            }

            @Override // com.baidu.tieba.frs.gamesubpb.a.InterfaceC0225a
            public void c(d dVar) {
                if (a.this.dWk != null) {
                    a.this.dWk.aFa();
                }
                if (dVar == null) {
                    a.this.or(null);
                    a.this.aFk();
                    return;
                }
                a.this.or(dVar.userName);
                a.this.dXd = dVar.userId;
            }
        });
        mP(140);
        aFj();
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        this.dXc = new ArrayList();
        this.bPk = com.baidu.adp.lib.g.b.d(TbadkCoreApplication.getCurrentAccount(), 0L);
    }

    private void aFi() {
        this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(e.g.view_navigation_bar);
        this.aMU = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        ImageView backImageView = this.mNavigationBar.getBackImageView();
        if (backImageView != null && (backImageView.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.aMU.getLayoutParams();
            int h = l.h(this.dWA.getPageContext().getPageActivity(), e.C0210e.ds30);
            layoutParams.height = h;
            layoutParams.width = h;
            backImageView.setLayoutParams(layoutParams);
        }
        if (this.aMU != null && (this.aMU.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.aMU.getLayoutParams();
            layoutParams2.width = -2;
            layoutParams2.height = -1;
            this.aMU.setPadding(l.h(this.dWA.getPageContext().getPageActivity(), e.C0210e.ds32), this.aMU.getPaddingTop(), this.aMU.getPaddingRight(), this.aMU.getPaddingBottom());
            this.aMU.setLayoutParams(layoutParams2);
        }
        this.mNavigationBar.setmBackImageViewBg(e.f.subpb_navigationbar_back, e.f.subpb_navigationbar_back);
    }

    private void aFj() {
        this.globalListener = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tieba.frs.gamesubpb.view.a.7
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                Rect rect = new Rect();
                a.this.dWA.getPageContext().getPageActivity().getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
                int r = l.r(a.this.dWA.getPageContext().getPageActivity());
                int[] aS = l.aS(a.this.dWA.getPageContext().getPageActivity());
                if (aS[1] - rect.bottom > aS[1] / 4 && !a.this.mIsKeyboardOpen) {
                    a.this.mIsKeyboardOpen = true;
                    a.this.onKeyboardVisibilityChanged(true);
                } else if (aS[1] - rect.height() == r && a.this.mIsKeyboardOpen) {
                    a.this.mIsKeyboardOpen = false;
                    a.this.onKeyboardVisibilityChanged(false);
                }
            }
        };
        this.dWA.getPageContext().getPageActivity().getWindow().getDecorView().getViewTreeObserver().addOnGlobalLayoutListener(this.globalListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(final d dVar) {
        final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.dWA.getPageContext().getPageActivity());
        aVar.eA(null);
        aVar.db(e.j.del_post_confirm);
        aVar.bg(true);
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
        aVar.b(this.dWA.getPageContext()).BF();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(d dVar) {
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_DELETE_SUB_COMMENT);
        httpMessage.addParam("user_id", this.bPk);
        httpMessage.addParam("main_tower_id", dVar.dWQ);
        httpMessage.addParam("id", dVar.id);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void oq(String str) {
        mQ(0);
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_ADD_SUB_COMMENT);
        httpMessage.addParam("user_id", this.bPk);
        httpMessage.addParam("reply_user_id", this.dXd);
        httpMessage.addParam("content", str);
        httpMessage.addParam("main_tower_id", this.dWo);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aFk() {
        this.dXd = this.dXb != null ? this.dXb.userId : null;
    }

    private void aFl() {
        if (!v.I(this.dXc)) {
            this.mNavigationBar.setCenterTextTitle(String.format(this.dWA.getResources().getString(e.j.subpb_floor_reply_count), ao.U(this.dXc.size())));
        } else {
            this.mNavigationBar.setCenterTextTitle(this.dWA.getResources().getString(e.j.reply));
        }
    }

    private void mP(final int i) {
        this.dWW.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.frs.gamesubpb.view.a.10
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                if (!TextUtils.isEmpty(charSequence)) {
                    a.this.dWX.setEnabled(true);
                    String charSequence2 = charSequence.toString();
                    if (!StringUtils.isNull(charSequence2) && y.iL(charSequence2) > i) {
                        String q = y.q(charSequence2, 0, i - 1);
                        a.this.dWW.setText(q);
                        a.this.dWW.setSelection(a.this.dWW.getText().length());
                        UtilHelper.showToast(a.this.dWA.getPageContext().getPageActivity().getApplication(), a.this.dWA.getPageContext().getPageActivity().getResources().getString(e.j.edit_text_over_limit_tip, Integer.valueOf(q.length())));
                        return;
                    }
                    return;
                }
                a.this.aFk();
                a.this.dWX.setEnabled(false);
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
            }
        });
    }

    private void aFm() {
        this.mNavigationBar.setmBackImageViewBg(e.f.subpb_navigationbar_close, e.f.subpb_navigationbar_close);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void he(final boolean z) {
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
            this.bam.getWindowVisibleDisplayFrame(rect);
            this.dWV.scrollTo(this.dWV.getScrollX(), (l.aS(this.dWA.getPageContext().getPageActivity())[1] - rect.bottom) - (MenuKeyUtils.hasSmartBar() ? l.dip2px(this.dWA.getPageContext().getPageActivity(), 48.0f) : 0));
            return;
        }
        this.dWV.setScrollY(0);
    }

    private void hf(boolean z) {
        if (v.I(this.dXc)) {
            this.mListView.setNextPage(null);
            this.dWZ.setVisibility(0);
        } else {
            this.mListView.setNextPage(this.dWU);
            this.dWZ.setVisibility(8);
            if (z) {
                this.dWU.Fc();
            } else {
                this.dWU.Fd();
            }
        }
        aFl();
    }

    public void a(boolean z, com.baidu.tieba.frs.gamesubpb.model.b bVar, List<h> list) {
        this.hasMore = z;
        this.dXb = bVar;
        aFk();
        if (v.I(list)) {
            hf(z);
            return;
        }
        this.dXc.clear();
        this.dXc.addAll(list);
        this.dWZ.setVisibility(8);
        this.mListView.setNextPage(this.dWU);
        this.dXa.setData(list);
        aFm();
        this.dWY.setVisibility(0);
        this.dWY.setText(e.j.say_your_point);
        hf(z);
    }

    public void a(boolean z, String str, d dVar) {
        mQ(8);
        if (z && dVar != null) {
            BdToast.a(this.dWA.getPageContext().getPageActivity(), this.dWA.getPageContext().getString(e.j.subpb_add_comment_succ_tip), 1).BN();
            this.dWW.setText((CharSequence) null);
            this.dXc.add(dVar);
            this.dXa.setData(this.dXc);
            hf(this.hasMore);
            this.dWW.post(new Runnable() { // from class: com.baidu.tieba.frs.gamesubpb.view.a.2
                @Override // java.lang.Runnable
                public void run() {
                    a.this.dWW.requestFocus();
                    l.b(a.this.dWA.getPageContext().getPageActivity(), a.this.dWW);
                }
            });
            return;
        }
        if (TextUtils.isEmpty(str)) {
            str = this.dWA.getPageContext().getString(e.j.subpb_add_comment_fail_tip);
        }
        BdToast.a(this.dWA.getPageContext().getPageActivity(), str, 1).BN();
    }

    public void b(boolean z, String str, d dVar) {
        if (z) {
            BdToast.a(this.dWA.getPageContext().getPageActivity(), this.dWA.getPageContext().getString(e.j.subpb_delete_comment_succ_tip), 1).BN();
            this.dXc.remove(dVar);
            this.dXa.setData(this.dXc);
            hf(this.hasMore);
            return;
        }
        if (TextUtils.isEmpty(str)) {
            str = this.dWA.getPageContext().getString(e.j.subpb_delete_comment_fail_tip);
        }
        BdToast.a(this.dWA.getPageContext().getPageActivity(), str, 1).BN();
    }

    public void hg(boolean z) {
        if (this.duq != null && this.duq.getLayoutParams() != null) {
            ViewGroup.LayoutParams layoutParams = this.duq.getLayoutParams();
            if (z) {
                aFm();
                layoutParams.height = l.h(this.dWA.getPageContext().getPageActivity(), e.C0210e.ds98);
            } else {
                layoutParams.height = l.h(this.dWA.getPageContext().getPageActivity(), e.C0210e.ds98) + UtilHelper.getLightStatusBarHeight();
            }
            this.duq.setLayoutParams(layoutParams);
        }
    }

    public void aQ(View view) {
        if (this.duq != null && this.mNavigationBar != null) {
            if (this.mNavigationBar.isNavigationBarExcludeStatusbarVisible()) {
                this.mNavigationBar.showNavigationBarExcludeStatusbar(false);
                if (UtilHelper.canUseStyleImmersiveSticky()) {
                    this.duq.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight()));
                } else if (this.mListView != null) {
                    this.mListView.removeHeaderView(this.duq);
                }
                this.mNavigationBar.setVisibility(8);
                return;
            }
            this.mNavigationBar.showNavigationBarExcludeStatusbar(true);
            if (UtilHelper.canUseStyleImmersiveSticky()) {
                this.duq.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + l.h(this.dWA.getActivity(), e.C0210e.ds98)));
            } else if (this.mListView != null) {
                this.mListView.addHeaderView(this.duq, 0);
            }
            this.mNavigationBar.setVisibility(0);
        }
    }

    public void or(String str) {
        this.dWY.setVisibility(8);
        this.bam.setVisibility(0);
        this.dWW.post(new Runnable() { // from class: com.baidu.tieba.frs.gamesubpb.view.a.3
            @Override // java.lang.Runnable
            public void run() {
                a.this.dWW.requestFocus();
                l.c(a.this.dWA.getPageContext().getPageActivity(), a.this.dWW);
            }
        });
        if (!TextUtils.isEmpty(str)) {
            String format = String.format(this.dWA.getPageContext().getPageActivity().getResources().getString(e.j.reply_sub_floor), str);
            this.dWW.setText(format);
            this.dWW.setSelection(format.length());
        }
    }

    public void mQ(int i) {
        this.mProgressBar.setVisibility(i);
    }

    public View aFn() {
        return this.duq;
    }

    public View getRootView() {
        return this.mRootView;
    }

    public ListView getListView() {
        return this.mListView;
    }

    public TextView aFo() {
        return this.dWY;
    }

    public NavigationBar abU() {
        return this.mNavigationBar;
    }

    public void e(com.baidu.tieba.frs.gamesubpb.c cVar) {
        this.dWk = cVar;
    }

    public void a(BdListView.e eVar) {
        this.mListView.setOnSrollToBottomListener(eVar);
    }

    public void onChangeSkinType(int i) {
        this.dWA.getLayoutMode().setNightMode(i == 1);
        this.dWA.getLayoutMode().onModeChanged(this.mRootView);
        al.j(this.mRootView, e.d.cp_bg_line_d);
        this.mNavigationBar.onChangeSkinType(this.dWA.getPageContext(), i);
        this.dWU.ey(i);
        al.h(this.dWY, e.d.cp_cont_e);
        this.dWY.setAlpha(0.95f);
        al.i(this.dWY, e.f.pb_ecomm_comment_bg);
        al.h(this.dWZ, e.d.cp_cont_d);
        al.i(this.bam, e.f.pb_ecomm_comment_bg);
        al.h(this.dWW, e.d.cp_cont_f);
        this.dWW.setHintTextColor(al.getColor(e.d.cp_cont_e));
        al.h(this.dWX, e.d.game_sub_pb_send_txt_color);
    }

    public void onDestroy() {
        if (this.globalListener != null) {
            this.dWA.getPageContext().getPageActivity().getWindow().getDecorView().getViewTreeObserver().removeGlobalOnLayoutListener(this.globalListener);
        }
    }
}
