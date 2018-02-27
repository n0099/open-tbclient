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
    private com.baidu.tieba.pb.a.c bLG = new com.baidu.tieba.pb.a.c(new c.a() { // from class: com.baidu.tieba.frs.gamesubpb.view.b.1
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
    private View bgy;
    private LinearLayout buq;
    private long cbN;
    private FrsGameSubPbActivity dPJ;
    private com.baidu.tieba.frs.gamesubpb.c dPt;
    private String dPx;
    private e dQd;
    private FrameLayout dQe;
    private EditText dQf;
    private TextView dQg;
    private TextView dQh;
    private TextView dQi;
    private com.baidu.tieba.frs.gamesubpb.b dQj;
    private com.baidu.tieba.frs.gamesubpb.model.b dQk;
    private List<i> dQl;
    private String dQm;
    private View duU;
    private ViewTreeObserver.OnGlobalLayoutListener globalListener;
    private boolean hasMore;
    private View.OnClickListener mCommonClickListener;
    private boolean mIsKeyboardOpen;
    private BdTypeListView mListView;
    private NavigationBar mNavigationBar;
    private ProgressBar mProgressBar;
    private RelativeLayout mRootView;

    public b(FrsGameSubPbActivity frsGameSubPbActivity, View.OnClickListener onClickListener, String str) {
        this.dPJ = frsGameSubPbActivity;
        this.mCommonClickListener = onClickListener;
        this.dPx = str;
        this.mRootView = (RelativeLayout) LayoutInflater.from(frsGameSubPbActivity.getPageContext().getPageActivity()).inflate(d.h.frs_game_sub_pb_activity, (ViewGroup) null);
        this.mListView = (BdTypeListView) this.mRootView.findViewById(d.g.new_sub_pb_list);
        this.mListView.setOnTouchListener(this.bLG);
        this.mListView.setOnScrollListener(new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.frs.gamesubpb.view.b.4
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
                if (i != 0) {
                    l.a(b.this.dPJ.getPageContext().getPageActivity(), b.this.dQf);
                }
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            }
        });
        this.dQd = new e(this.dPJ.getPageContext());
        this.duU = BdListViewHelper.a(this.dPJ.getActivity(), this.mListView, BdListViewHelper.HeadType.DEFAULT);
        this.dQh = (TextView) this.mRootView.findViewById(d.g.subpb_editor_tool_comment_reply_text);
        this.dQh.setOnClickListener(this.mCommonClickListener);
        this.dQi = (TextView) this.mRootView.findViewById(d.g.no_reply_list_view);
        this.dQe = (FrameLayout) this.mRootView.findViewById(d.g.bottom_view);
        this.buq = (LinearLayout) this.mRootView.findViewById(d.g.subpb_editor_tool_comment_input_container);
        this.dQf = (EditText) this.mRootView.findViewById(d.g.subpb_editor_tool_comment_input_edit);
        this.dQg = (TextView) this.mRootView.findViewById(d.g.subpb_editor_tool_comment_send_tv);
        this.dQg.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.gamesubpb.view.b.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.this.lU(b.this.dQf.getText().toString());
            }
        });
        this.mProgressBar = (ProgressBar) this.mRootView.findViewById(d.g.progressBar);
        ayq();
        this.dQj = new com.baidu.tieba.frs.gamesubpb.b(this.dPJ.getPageContext(), this.mListView);
        this.dQj.setClickListener(new a.InterfaceC0156a() { // from class: com.baidu.tieba.frs.gamesubpb.view.b.6
            @Override // com.baidu.tieba.frs.gamesubpb.a.InterfaceC0156a
            public void a(com.baidu.tieba.frs.gamesubpb.model.d dVar) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonPolymericActivityConfig(b.this.dPJ.getPageContext().getPageActivity()).createNormalConfig(Long.valueOf(dVar.userId).longValue(), String.valueOf(b.this.cbN).equals(dVar.userId), false)));
            }

            @Override // com.baidu.tieba.frs.gamesubpb.a.InterfaceC0156a
            public void b(com.baidu.tieba.frs.gamesubpb.model.d dVar) {
                if (dVar != null) {
                    b.this.d(dVar);
                }
            }

            @Override // com.baidu.tieba.frs.gamesubpb.a.InterfaceC0156a
            public void c(com.baidu.tieba.frs.gamesubpb.model.d dVar) {
                if (b.this.dPt != null) {
                    b.this.dPt.ayi();
                }
                if (dVar == null) {
                    b.this.lV(null);
                    b.this.ays();
                    return;
                }
                b.this.lV(dVar.userName);
                b.this.dQm = dVar.userId;
            }
        });
        ny(140);
        ayr();
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        this.dQl = new ArrayList();
        this.cbN = com.baidu.adp.lib.g.b.c(TbadkCoreApplication.getCurrentAccount(), 0L);
    }

    private void ayq() {
        this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(d.g.view_navigation_bar);
        this.bgy = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        ImageView backImageView = this.mNavigationBar.getBackImageView();
        if (backImageView != null && (backImageView.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bgy.getLayoutParams();
            int t = l.t(this.dPJ.getPageContext().getPageActivity(), d.e.ds30);
            layoutParams.height = t;
            layoutParams.width = t;
            backImageView.setLayoutParams(layoutParams);
        }
        if (this.bgy != null && (this.bgy.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.bgy.getLayoutParams();
            layoutParams2.width = -2;
            layoutParams2.height = -1;
            this.bgy.setPadding(l.t(this.dPJ.getPageContext().getPageActivity(), d.e.ds32), this.bgy.getPaddingTop(), this.bgy.getPaddingRight(), this.bgy.getPaddingBottom());
            this.bgy.setLayoutParams(layoutParams2);
        }
        this.mNavigationBar.setmBackImageViewBg(d.f.subpb_navigationbar_back, d.f.subpb_navigationbar_back);
    }

    private void ayr() {
        this.globalListener = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tieba.frs.gamesubpb.view.b.7
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                Rect rect = new Rect();
                b.this.dPJ.getPageContext().getPageActivity().getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
                int p = l.p(b.this.dPJ.getPageContext().getPageActivity());
                int[] as = l.as(b.this.dPJ.getPageContext().getPageActivity());
                if (as[1] - rect.bottom > as[1] / 4 && !b.this.mIsKeyboardOpen) {
                    b.this.mIsKeyboardOpen = true;
                    b.this.onKeyboardVisibilityChanged(true);
                } else if (as[1] - rect.height() == p && b.this.mIsKeyboardOpen) {
                    b.this.mIsKeyboardOpen = false;
                    b.this.onKeyboardVisibilityChanged(false);
                }
            }
        };
        this.dPJ.getPageContext().getPageActivity().getWindow().getDecorView().getViewTreeObserver().addOnGlobalLayoutListener(this.globalListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(final com.baidu.tieba.frs.gamesubpb.model.d dVar) {
        final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.dPJ.getPageContext().getPageActivity());
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
        aVar.b(this.dPJ.getPageContext()).AU();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(com.baidu.tieba.frs.gamesubpb.model.d dVar) {
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_DELETE_SUB_COMMENT);
        httpMessage.addParam("user_id", this.cbN);
        httpMessage.addParam("main_tower_id", dVar.dPZ);
        httpMessage.addParam("id", dVar.id);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lU(String str) {
        nz(0);
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_ADD_SUB_COMMENT);
        httpMessage.addParam("user_id", this.cbN);
        httpMessage.addParam("reply_user_id", this.dQm);
        httpMessage.addParam("content", str);
        httpMessage.addParam("main_tower_id", this.dPx);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ays() {
        this.dQm = this.dQk != null ? this.dQk.userId : null;
    }

    private void ayt() {
        if (!v.E(this.dQl)) {
            this.mNavigationBar.setCenterTextTitle(String.format(this.dPJ.getResources().getString(d.j.subpb_floor_reply_count), am.H(this.dQl.size())));
        } else {
            this.mNavigationBar.setCenterTextTitle(this.dPJ.getResources().getString(d.j.subpb_floor_default_title));
        }
    }

    private void ny(final int i) {
        this.dQf.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.frs.gamesubpb.view.b.10
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                if (!TextUtils.isEmpty(charSequence)) {
                    b.this.dQg.setEnabled(true);
                    String charSequence2 = charSequence.toString();
                    if (!StringUtils.isNull(charSequence2) && w.hs(charSequence2) > i) {
                        String j = w.j(charSequence2, 0, i - 1);
                        b.this.dQf.setText(j);
                        b.this.dQf.setSelection(b.this.dQf.getText().length());
                        UtilHelper.showToast(b.this.dPJ.getPageContext().getPageActivity().getApplication(), b.this.dPJ.getPageContext().getPageActivity().getResources().getString(d.j.edit_text_over_limit_tip, Integer.valueOf(j.length())));
                        return;
                    }
                    return;
                }
                b.this.ays();
                b.this.dQg.setEnabled(false);
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
            }
        });
    }

    private void ayu() {
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
            this.buq.getWindowVisibleDisplayFrame(rect);
            this.dQe.scrollTo(this.dQe.getScrollX(), (l.as(this.dPJ.getPageContext().getPageActivity())[1] - rect.bottom) - (MenuKeyUtils.hasSmartBar() ? l.dip2px(this.dPJ.getPageContext().getPageActivity(), 48.0f) : 0));
            return;
        }
        this.dQe.setScrollY(0);
    }

    private void gi(boolean z) {
        if (v.E(this.dQl)) {
            this.mListView.setNextPage(null);
            this.dQi.setVisibility(0);
        } else {
            this.mListView.setNextPage(this.dQd);
            this.dQi.setVisibility(8);
            if (z) {
                this.dQd.Ef();
            } else {
                this.dQd.Eg();
            }
        }
        ayt();
    }

    public void a(boolean z, com.baidu.tieba.frs.gamesubpb.model.b bVar, List<i> list) {
        this.hasMore = z;
        this.dQk = bVar;
        ays();
        if (v.E(list)) {
            gi(z);
            return;
        }
        this.dQl.clear();
        this.dQl.addAll(list);
        this.dQi.setVisibility(8);
        this.mListView.setNextPage(this.dQd);
        this.dQj.setData(list);
        ayu();
        this.dQh.setVisibility(0);
        this.dQh.setText(d.j.say_your_point);
        gi(z);
    }

    public void a(boolean z, String str, com.baidu.tieba.frs.gamesubpb.model.d dVar) {
        nz(8);
        if (z && dVar != null) {
            BdToast.a(this.dPJ.getPageContext().getPageActivity(), this.dPJ.getPageContext().getString(d.j.subpb_add_comment_succ_tip), 1).Bc();
            this.dQf.setText((CharSequence) null);
            this.dQl.add(dVar);
            this.dQj.setData(this.dQl);
            gi(this.hasMore);
            this.dQf.post(new Runnable() { // from class: com.baidu.tieba.frs.gamesubpb.view.b.2
                @Override // java.lang.Runnable
                public void run() {
                    b.this.dQf.requestFocus();
                    l.a(b.this.dPJ.getPageContext().getPageActivity(), b.this.dQf);
                }
            });
            return;
        }
        if (TextUtils.isEmpty(str)) {
            str = this.dPJ.getPageContext().getString(d.j.subpb_add_comment_fail_tip);
        }
        BdToast.a(this.dPJ.getPageContext().getPageActivity(), str, 1).Bc();
    }

    public void b(boolean z, String str, com.baidu.tieba.frs.gamesubpb.model.d dVar) {
        if (z) {
            BdToast.a(this.dPJ.getPageContext().getPageActivity(), this.dPJ.getPageContext().getString(d.j.subpb_delete_comment_succ_tip), 1).Bc();
            this.dQl.remove(dVar);
            this.dQj.setData(this.dQl);
            gi(this.hasMore);
            return;
        }
        if (TextUtils.isEmpty(str)) {
            str = this.dPJ.getPageContext().getString(d.j.subpb_delete_comment_fail_tip);
        }
        BdToast.a(this.dPJ.getPageContext().getPageActivity(), str, 1).Bc();
    }

    public void gj(boolean z) {
        if (this.duU != null && this.duU.getLayoutParams() != null) {
            ViewGroup.LayoutParams layoutParams = this.duU.getLayoutParams();
            if (z) {
                ayu();
                layoutParams.height = l.t(this.dPJ.getPageContext().getPageActivity(), d.e.ds98);
            } else {
                layoutParams.height = l.t(this.dPJ.getPageContext().getPageActivity(), d.e.ds98) + UtilHelper.getLightStatusBarHeight();
            }
            this.duU.setLayoutParams(layoutParams);
        }
    }

    public void bQ(View view) {
        if (this.duU != null && this.mNavigationBar != null) {
            if (this.mNavigationBar.isNavigationBarExcludeStatusbarVisible()) {
                this.mNavigationBar.showNavigationBarExcludeStatusbar(false);
                if (UtilHelper.canUseStyleImmersiveSticky()) {
                    this.duU.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight()));
                } else if (this.mListView != null) {
                    this.mListView.removeHeaderView(this.duU);
                }
                this.mNavigationBar.setVisibility(8);
                return;
            }
            this.mNavigationBar.showNavigationBarExcludeStatusbar(true);
            if (UtilHelper.canUseStyleImmersiveSticky()) {
                this.duU.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + l.t(this.dPJ.getActivity(), d.e.ds98)));
            } else if (this.mListView != null) {
                this.mListView.addHeaderView(this.duU, 0);
            }
            this.mNavigationBar.setVisibility(0);
        }
    }

    public void lV(String str) {
        this.dQh.setVisibility(8);
        this.buq.setVisibility(0);
        this.dQf.post(new Runnable() { // from class: com.baidu.tieba.frs.gamesubpb.view.b.3
            @Override // java.lang.Runnable
            public void run() {
                b.this.dQf.requestFocus();
                l.b(b.this.dPJ.getPageContext().getPageActivity(), b.this.dQf);
            }
        });
        if (!TextUtils.isEmpty(str)) {
            String format = String.format(this.dPJ.getPageContext().getPageActivity().getResources().getString(d.j.reply_sub_floor), str);
            this.dQf.setText(format);
            this.dQf.setSelection(format.length());
        }
    }

    public void nz(int i) {
        this.mProgressBar.setVisibility(i);
    }

    public View ayv() {
        return this.duU;
    }

    public View getRootView() {
        return this.mRootView;
    }

    public ListView getListView() {
        return this.mListView;
    }

    public TextView ayw() {
        return this.dQh;
    }

    public NavigationBar avj() {
        return this.mNavigationBar;
    }

    public void e(com.baidu.tieba.frs.gamesubpb.c cVar) {
        this.dPt = cVar;
    }

    public void a(BdListView.e eVar) {
        this.mListView.setOnSrollToBottomListener(eVar);
    }

    public void onChangeSkinType(int i) {
        this.dPJ.getLayoutMode().aQ(i == 1);
        this.dPJ.getLayoutMode().aM(this.mRootView);
        aj.t(this.mRootView, d.C0141d.cp_bg_line_d);
        this.mNavigationBar.onChangeSkinType(this.dPJ.getPageContext(), i);
        this.dQd.gx(i);
        aj.r(this.dQh, d.C0141d.cp_cont_e);
        this.dQh.setAlpha(0.95f);
        aj.s(this.dQh, d.f.pb_ecomm_comment_bg);
        aj.r(this.dQi, d.C0141d.cp_cont_d);
        aj.s(this.buq, d.f.pb_ecomm_comment_bg);
        aj.r(this.dQf, d.C0141d.cp_cont_f);
        this.dQf.setHintTextColor(aj.getColor(d.C0141d.cp_cont_e));
        aj.r(this.dQg, d.C0141d.game_sub_pb_send_txt_color);
    }

    public void onDestroy() {
        if (this.globalListener != null) {
            this.dPJ.getPageContext().getPageActivity().getWindow().getDecorView().getViewTreeObserver().removeGlobalOnLayoutListener(this.globalListener);
        }
    }
}
