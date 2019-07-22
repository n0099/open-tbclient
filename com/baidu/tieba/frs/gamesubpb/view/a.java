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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tbadk.util.ab;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.gamesubpb.FrsGameSubPbActivity;
import com.baidu.tieba.frs.gamesubpb.a;
import com.baidu.tieba.frs.gamesubpb.model.d;
import com.baidu.tieba.frs.gamesubpb.model.e;
import com.baidu.tieba.pb.a.c;
import com.compatible.menukey.MenuKeyUtils;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class a {
    private View cfb;
    private c clt = new c(new c.a() { // from class: com.baidu.tieba.frs.gamesubpb.view.a.1
        @Override // com.baidu.tieba.pb.a.c.a
        public boolean b(View view, MotionEvent motionEvent) {
            a.this.kB(false);
            a.this.bV(view);
            a.this.kB(true);
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
    private LinearLayout ctY;
    private long dsd;
    private FrsGameSubPbActivity fIG;
    private com.baidu.tieba.frs.gamesubpb.c fIq;
    private String fIu;
    private e fJa;
    private FrameLayout fJb;
    private EditText fJc;
    private TextView fJd;
    private TextView fJe;
    private TextView fJf;
    private com.baidu.tieba.frs.gamesubpb.b fJg;
    private com.baidu.tieba.frs.gamesubpb.model.b fJh;
    private List<m> fJi;
    private String fJj;
    private View fga;
    private ViewTreeObserver.OnGlobalLayoutListener globalListener;
    private boolean hasMore;
    private View.OnClickListener mCommonClickListener;
    private boolean mIsKeyboardOpen;
    private BdTypeListView mListView;
    private NavigationBar mNavigationBar;
    private ProgressBar mProgressBar;
    private RelativeLayout mRootView;

    public a(FrsGameSubPbActivity frsGameSubPbActivity, View.OnClickListener onClickListener, String str) {
        this.fIG = frsGameSubPbActivity;
        this.mCommonClickListener = onClickListener;
        this.fIu = str;
        this.mRootView = (RelativeLayout) LayoutInflater.from(frsGameSubPbActivity.getPageContext().getPageActivity()).inflate(R.layout.frs_game_sub_pb_activity, (ViewGroup) null);
        this.mListView = (BdTypeListView) this.mRootView.findViewById(R.id.new_sub_pb_list);
        this.mListView.setOnTouchListener(this.clt);
        this.mListView.setOnScrollListener(new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.frs.gamesubpb.view.a.4
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
                if (i != 0) {
                    l.b(a.this.fIG.getPageContext().getPageActivity(), a.this.fJc);
                }
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            }
        });
        this.fJa = new e(this.fIG.getPageContext());
        this.fga = BdListViewHelper.a(this.fIG.getActivity(), this.mListView, BdListViewHelper.HeadType.DEFAULT);
        this.fJe = (TextView) this.mRootView.findViewById(R.id.subpb_editor_tool_comment_reply_text);
        this.fJe.setOnClickListener(this.mCommonClickListener);
        this.fJf = (TextView) this.mRootView.findViewById(R.id.no_reply_list_view);
        this.fJb = (FrameLayout) this.mRootView.findViewById(R.id.bottom_view);
        this.ctY = (LinearLayout) this.mRootView.findViewById(R.id.subpb_editor_tool_comment_input_container);
        this.fJc = (EditText) this.mRootView.findViewById(R.id.subpb_editor_tool_comment_input_edit);
        this.fJd = (TextView) this.mRootView.findViewById(R.id.subpb_editor_tool_comment_send_tv);
        this.fJd.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.gamesubpb.view.a.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.xi(a.this.fJc.getText().toString());
            }
        });
        this.mProgressBar = (ProgressBar) this.mRootView.findViewById(R.id.progressBar);
        bqf();
        this.fJg = new com.baidu.tieba.frs.gamesubpb.b(this.fIG.getPageContext(), this.mListView);
        this.fJg.setClickListener(new a.InterfaceC0308a() { // from class: com.baidu.tieba.frs.gamesubpb.view.a.6
            @Override // com.baidu.tieba.frs.gamesubpb.a.InterfaceC0308a
            public void a(d dVar) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonPolymericActivityConfig(a.this.fIG.getPageContext().getPageActivity()).createNormalConfig(Long.valueOf(dVar.userId).longValue(), String.valueOf(a.this.dsd).equals(dVar.userId), false)));
            }

            @Override // com.baidu.tieba.frs.gamesubpb.a.InterfaceC0308a
            public void b(d dVar) {
                if (dVar != null) {
                    a.this.d(dVar);
                }
            }

            @Override // com.baidu.tieba.frs.gamesubpb.a.InterfaceC0308a
            public void c(d dVar) {
                if (a.this.fIq != null) {
                    a.this.fIq.bpX();
                }
                if (dVar == null) {
                    a.this.xj(null);
                    a.this.bqh();
                    return;
                }
                a.this.xj(dVar.userName);
                a.this.fJj = dVar.userId;
            }
        });
        sm(140);
        bqg();
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        this.fJi = new ArrayList();
        this.dsd = com.baidu.adp.lib.g.b.c(TbadkCoreApplication.getCurrentAccount(), 0L);
    }

    private void bqf() {
        this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(R.id.view_navigation_bar);
        this.cfb = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        ImageView backImageView = this.mNavigationBar.getBackImageView();
        if (backImageView != null && (backImageView.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.cfb.getLayoutParams();
            int g = l.g(this.fIG.getPageContext().getPageActivity(), R.dimen.ds30);
            layoutParams.height = g;
            layoutParams.width = g;
            backImageView.setLayoutParams(layoutParams);
        }
        if (this.cfb != null && (this.cfb.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.cfb.getLayoutParams();
            layoutParams2.width = -2;
            layoutParams2.height = -1;
            this.cfb.setPadding(l.g(this.fIG.getPageContext().getPageActivity(), R.dimen.ds32), this.cfb.getPaddingTop(), this.cfb.getPaddingRight(), this.cfb.getPaddingBottom());
            this.cfb.setLayoutParams(layoutParams2);
        }
        this.mNavigationBar.setmBackImageViewBg(R.drawable.subpb_navigationbar_back, R.drawable.subpb_navigationbar_back);
    }

    private void bqg() {
        this.globalListener = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tieba.frs.gamesubpb.view.a.7
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                Rect rect = new Rect();
                a.this.fIG.getPageContext().getPageActivity().getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
                int u = l.u(a.this.fIG.getPageContext().getPageActivity());
                int[] aj = l.aj(a.this.fIG.getPageContext().getPageActivity());
                if (aj[1] - rect.bottom > aj[1] / 4 && !a.this.mIsKeyboardOpen) {
                    a.this.mIsKeyboardOpen = true;
                    a.this.onKeyboardVisibilityChanged(true);
                } else if (aj[1] - rect.height() == u && a.this.mIsKeyboardOpen) {
                    a.this.mIsKeyboardOpen = false;
                    a.this.onKeyboardVisibilityChanged(false);
                }
            }
        };
        this.fIG.getPageContext().getPageActivity().getWindow().getDecorView().getViewTreeObserver().addOnGlobalLayoutListener(this.globalListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(final d dVar) {
        final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.fIG.getPageContext().getPageActivity());
        aVar.mN(null);
        aVar.hu(R.string.del_post_confirm);
        aVar.dR(true);
        aVar.a(R.string.dialog_ok, new a.b() { // from class: com.baidu.tieba.frs.gamesubpb.view.a.8
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar.dismiss();
                a.this.e(dVar);
            }
        });
        aVar.b(R.string.dialog_cancel, new a.b() { // from class: com.baidu.tieba.frs.gamesubpb.view.a.9
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar.dismiss();
            }
        });
        aVar.b(this.fIG.getPageContext()).agI();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(d dVar) {
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_DELETE_SUB_COMMENT);
        httpMessage.addParam("user_id", this.dsd);
        httpMessage.addParam("main_tower_id", dVar.fIW);
        httpMessage.addParam("id", dVar.id);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xi(String str) {
        sn(0);
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_ADD_SUB_COMMENT);
        httpMessage.addParam("user_id", this.dsd);
        httpMessage.addParam("reply_user_id", this.fJj);
        httpMessage.addParam("content", str);
        httpMessage.addParam("main_tower_id", this.fIu);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bqh() {
        this.fJj = this.fJh != null ? this.fJh.userId : null;
    }

    private void bqi() {
        if (!v.aa(this.fJi)) {
            this.mNavigationBar.setCenterTextTitle(String.format(this.fIG.getResources().getString(R.string.subpb_floor_reply_count), aq.aM(this.fJi.size())));
        } else {
            this.mNavigationBar.setCenterTextTitle(this.fIG.getResources().getString(R.string.reply));
        }
    }

    private void sm(final int i) {
        this.fJc.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.frs.gamesubpb.view.a.10
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                if (!TextUtils.isEmpty(charSequence)) {
                    a.this.fJd.setEnabled(true);
                    String charSequence2 = charSequence.toString();
                    if (!StringUtils.isNull(charSequence2) && ab.rn(charSequence2) > i) {
                        String p = ab.p(charSequence2, 0, i - 1);
                        a.this.fJc.setText(p);
                        a.this.fJc.setSelection(a.this.fJc.getText().length());
                        UtilHelper.showToast(a.this.fIG.getPageContext().getPageActivity().getApplication(), a.this.fIG.getPageContext().getPageActivity().getResources().getString(R.string.edit_text_over_limit_tip, Integer.valueOf(p.length())));
                        return;
                    }
                    return;
                }
                a.this.bqh();
                a.this.fJd.setEnabled(false);
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
            }
        });
    }

    private void bqj() {
        this.mNavigationBar.setmBackImageViewBg(R.drawable.subpb_navigationbar_close, R.drawable.subpb_navigationbar_close);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void kB(final boolean z) {
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
            this.ctY.getWindowVisibleDisplayFrame(rect);
            this.fJb.scrollTo(this.fJb.getScrollX(), (l.aj(this.fIG.getPageContext().getPageActivity())[1] - rect.bottom) - (MenuKeyUtils.hasSmartBar() ? l.dip2px(this.fIG.getPageContext().getPageActivity(), 48.0f) : 0));
            return;
        }
        this.fJb.setScrollY(0);
    }

    private void kC(boolean z) {
        if (v.aa(this.fJi)) {
            this.mListView.setNextPage(null);
            this.fJf.setVisibility(0);
        } else {
            this.mListView.setNextPage(this.fJa);
            this.fJf.setVisibility(8);
            if (z) {
                this.fJa.akD();
            } else {
                this.fJa.akE();
            }
        }
        bqi();
    }

    public void a(boolean z, com.baidu.tieba.frs.gamesubpb.model.b bVar, List<m> list) {
        this.hasMore = z;
        this.fJh = bVar;
        bqh();
        if (v.aa(list)) {
            kC(z);
            return;
        }
        this.fJi.clear();
        this.fJi.addAll(list);
        this.fJf.setVisibility(8);
        this.mListView.setNextPage(this.fJa);
        this.fJg.setData(list);
        bqj();
        this.fJe.setVisibility(0);
        this.fJe.setText(R.string.say_your_point);
        kC(z);
    }

    public void a(boolean z, String str, d dVar) {
        sn(8);
        if (z && dVar != null) {
            BdToast.b(this.fIG.getPageContext().getPageActivity(), this.fIG.getPageContext().getString(R.string.subpb_add_comment_succ_tip), 1).agQ();
            this.fJc.setText((CharSequence) null);
            this.fJi.add(dVar);
            this.fJg.setData(this.fJi);
            kC(this.hasMore);
            this.fJc.post(new Runnable() { // from class: com.baidu.tieba.frs.gamesubpb.view.a.2
                @Override // java.lang.Runnable
                public void run() {
                    a.this.fJc.requestFocus();
                    l.b(a.this.fIG.getPageContext().getPageActivity(), a.this.fJc);
                }
            });
            return;
        }
        if (TextUtils.isEmpty(str)) {
            str = this.fIG.getPageContext().getString(R.string.subpb_add_comment_fail_tip);
        }
        BdToast.b(this.fIG.getPageContext().getPageActivity(), str, 1).agQ();
    }

    public void b(boolean z, String str, d dVar) {
        if (z) {
            BdToast.b(this.fIG.getPageContext().getPageActivity(), this.fIG.getPageContext().getString(R.string.subpb_delete_comment_succ_tip), 1).agQ();
            this.fJi.remove(dVar);
            this.fJg.setData(this.fJi);
            kC(this.hasMore);
            return;
        }
        if (TextUtils.isEmpty(str)) {
            str = this.fIG.getPageContext().getString(R.string.subpb_delete_comment_fail_tip);
        }
        BdToast.b(this.fIG.getPageContext().getPageActivity(), str, 1).agQ();
    }

    public void kD(boolean z) {
        if (this.fga != null && this.fga.getLayoutParams() != null) {
            ViewGroup.LayoutParams layoutParams = this.fga.getLayoutParams();
            if (z) {
                bqj();
                layoutParams.height = l.g(this.fIG.getPageContext().getPageActivity(), R.dimen.ds98);
            } else {
                layoutParams.height = l.g(this.fIG.getPageContext().getPageActivity(), R.dimen.ds98) + UtilHelper.getLightStatusBarHeight();
            }
            this.fga.setLayoutParams(layoutParams);
        }
    }

    public void bV(View view) {
        if (this.fga != null && this.mNavigationBar != null) {
            if (this.mNavigationBar.isNavigationBarExcludeStatusbarVisible()) {
                this.mNavigationBar.showNavigationBarExcludeStatusbar(false);
                if (UtilHelper.canUseStyleImmersiveSticky()) {
                    this.fga.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight()));
                } else if (this.mListView != null) {
                    this.mListView.removeHeaderView(this.fga);
                }
                this.mNavigationBar.setVisibility(8);
                return;
            }
            this.mNavigationBar.showNavigationBarExcludeStatusbar(true);
            if (UtilHelper.canUseStyleImmersiveSticky()) {
                this.fga.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + l.g(this.fIG.getActivity(), R.dimen.ds98)));
            } else if (this.mListView != null) {
                this.mListView.addHeaderView(this.fga, 0);
            }
            this.mNavigationBar.setVisibility(0);
        }
    }

    public void xj(String str) {
        this.fJe.setVisibility(8);
        this.ctY.setVisibility(0);
        this.fJc.post(new Runnable() { // from class: com.baidu.tieba.frs.gamesubpb.view.a.3
            @Override // java.lang.Runnable
            public void run() {
                a.this.fJc.requestFocus();
                l.c(a.this.fIG.getPageContext().getPageActivity(), a.this.fJc);
            }
        });
        if (!TextUtils.isEmpty(str)) {
            String format = String.format(this.fIG.getPageContext().getPageActivity().getResources().getString(R.string.reply_sub_floor), str);
            this.fJc.setText(format);
            this.fJc.setSelection(format.length());
        }
    }

    public void sn(int i) {
        this.mProgressBar.setVisibility(i);
    }

    public View bqk() {
        return this.fga;
    }

    public View getRootView() {
        return this.mRootView;
    }

    public ListView getListView() {
        return this.mListView;
    }

    public TextView bql() {
        return this.fJe;
    }

    public NavigationBar aLh() {
        return this.mNavigationBar;
    }

    public void e(com.baidu.tieba.frs.gamesubpb.c cVar) {
        this.fIq = cVar;
    }

    public void b(BdListView.e eVar) {
        this.mListView.setOnSrollToBottomListener(eVar);
    }

    public void onChangeSkinType(int i) {
        this.fIG.getLayoutMode().setNightMode(i == 1);
        this.fIG.getLayoutMode().onModeChanged(this.mRootView);
        am.l(this.mRootView, R.color.cp_bg_line_d);
        this.mNavigationBar.onChangeSkinType(this.fIG.getPageContext(), i);
        this.fJa.iV(i);
        am.j(this.fJe, R.color.cp_cont_e);
        this.fJe.setAlpha(0.95f);
        am.k(this.fJe, R.drawable.pb_ecomm_comment_bg);
        am.j(this.fJf, R.color.cp_cont_d);
        am.k(this.ctY, R.drawable.pb_ecomm_comment_bg);
        am.j(this.fJc, R.color.cp_cont_f);
        this.fJc.setHintTextColor(am.getColor(R.color.cp_cont_e));
        am.j(this.fJd, R.color.game_sub_pb_send_txt_color);
    }

    public void onDestroy() {
        if (this.globalListener != null) {
            this.fIG.getPageContext().getPageActivity().getWindow().getDecorView().getViewTreeObserver().removeGlobalOnLayoutListener(this.globalListener);
        }
    }
}
