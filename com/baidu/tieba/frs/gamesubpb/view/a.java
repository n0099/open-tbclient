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
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PersonPolymericActivityConfig;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tbadk.util.aa;
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
    private boolean YF;
    private View.OnClickListener ZF;
    private LinearLayout cGv;
    private c cyE = new c(new c.a() { // from class: com.baidu.tieba.frs.gamesubpb.view.a.1
        @Override // com.baidu.tieba.pb.a.c.a
        public boolean onDoubleTap(View view, MotionEvent motionEvent) {
            a.this.kr(false);
            a.this.bT(view);
            a.this.kr(true);
            return true;
        }

        @Override // com.baidu.tieba.pb.a.c.a
        public boolean onDoubleTapEvent(View view, MotionEvent motionEvent) {
            return false;
        }

        @Override // com.baidu.tieba.pb.a.c.a
        public boolean onSingleTapConfirmed(View view, MotionEvent motionEvent) {
            return true;
        }
    });
    private ViewTreeObserver.OnGlobalLayoutListener dLb;
    private BdTypeListView duK;
    private long dzX;
    private String fJA;
    private FrsGameSubPbActivity fJM;
    private com.baidu.tieba.frs.gamesubpb.c fJw;
    private e fKg;
    private FrameLayout fKh;
    private EditText fKi;
    private TextView fKj;
    private TextView fKk;
    private TextView fKl;
    private com.baidu.tieba.frs.gamesubpb.b fKm;
    private com.baidu.tieba.frs.gamesubpb.model.b fKn;
    private List<m> fKo;
    private String fKp;
    private View fkk;
    private boolean hasMore;
    private View mBack;
    private NavigationBar mNavigationBar;
    private ProgressBar mProgressBar;
    private RelativeLayout mRootView;

    public a(FrsGameSubPbActivity frsGameSubPbActivity, View.OnClickListener onClickListener, String str) {
        this.fJM = frsGameSubPbActivity;
        this.ZF = onClickListener;
        this.fJA = str;
        this.mRootView = (RelativeLayout) LayoutInflater.from(frsGameSubPbActivity.getPageContext().getPageActivity()).inflate(R.layout.frs_game_sub_pb_activity, (ViewGroup) null);
        this.duK = (BdTypeListView) this.mRootView.findViewById(R.id.new_sub_pb_list);
        this.duK.setOnTouchListener(this.cyE);
        this.duK.setOnScrollListener(new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.frs.gamesubpb.view.a.4
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
                if (i != 0) {
                    l.hideSoftKeyPad(a.this.fJM.getPageContext().getPageActivity(), a.this.fKi);
                }
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            }
        });
        this.fKg = new e(this.fJM.getPageContext());
        this.fkk = BdListViewHelper.a(this.fJM.getActivity(), this.duK, BdListViewHelper.HeadType.DEFAULT);
        this.fKk = (TextView) this.mRootView.findViewById(R.id.subpb_editor_tool_comment_reply_text);
        this.fKk.setOnClickListener(this.ZF);
        this.fKl = (TextView) this.mRootView.findViewById(R.id.no_reply_list_view);
        this.fKh = (FrameLayout) this.mRootView.findViewById(R.id.bottom_view);
        this.cGv = (LinearLayout) this.mRootView.findViewById(R.id.subpb_editor_tool_comment_input_container);
        this.fKi = (EditText) this.mRootView.findViewById(R.id.subpb_editor_tool_comment_input_edit);
        this.fKj = (TextView) this.mRootView.findViewById(R.id.subpb_editor_tool_comment_send_tv);
        this.fKj.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.gamesubpb.view.a.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.wa(a.this.fKi.getText().toString());
            }
        });
        this.mProgressBar = (ProgressBar) this.mRootView.findViewById(R.id.progressBar);
        bog();
        this.fKm = new com.baidu.tieba.frs.gamesubpb.b(this.fJM.getPageContext(), this.duK);
        this.fKm.setClickListener(new a.InterfaceC0414a() { // from class: com.baidu.tieba.frs.gamesubpb.view.a.6
            @Override // com.baidu.tieba.frs.gamesubpb.a.InterfaceC0414a
            public void a(d dVar) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonPolymericActivityConfig(a.this.fJM.getPageContext().getPageActivity()).createNormalConfig(Long.valueOf(dVar.userId).longValue(), String.valueOf(a.this.dzX).equals(dVar.userId), false)));
            }

            @Override // com.baidu.tieba.frs.gamesubpb.a.InterfaceC0414a
            public void b(d dVar) {
                if (dVar != null) {
                    a.this.d(dVar);
                }
            }

            @Override // com.baidu.tieba.frs.gamesubpb.a.InterfaceC0414a
            public void c(d dVar) {
                if (a.this.fJw != null) {
                    a.this.fJw.bnY();
                }
                if (dVar == null) {
                    a.this.wb(null);
                    a.this.boi();
                    return;
                }
                a.this.wb(dVar.userName);
                a.this.fKp = dVar.userId;
            }
        });
        rk(140);
        boh();
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        this.fKo = new ArrayList();
        this.dzX = com.baidu.adp.lib.g.b.toLong(TbadkCoreApplication.getCurrentAccount(), 0L);
    }

    private void bog() {
        this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(R.id.view_navigation_bar);
        this.mBack = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        ImageView backImageView = this.mNavigationBar.getBackImageView();
        if (backImageView != null && (backImageView.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.mBack.getLayoutParams();
            int dimens = l.getDimens(this.fJM.getPageContext().getPageActivity(), R.dimen.ds30);
            layoutParams.height = dimens;
            layoutParams.width = dimens;
            backImageView.setLayoutParams(layoutParams);
        }
        if (this.mBack != null && (this.mBack.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.mBack.getLayoutParams();
            layoutParams2.width = -2;
            layoutParams2.height = -1;
            this.mBack.setPadding(l.getDimens(this.fJM.getPageContext().getPageActivity(), R.dimen.ds32), this.mBack.getPaddingTop(), this.mBack.getPaddingRight(), this.mBack.getPaddingBottom());
            this.mBack.setLayoutParams(layoutParams2);
        }
        if (this.mNavigationBar.getBackImageView() != null) {
            SvgManager.amL().a(this.mNavigationBar.getBackImageView(), R.drawable.icon_pure_topbar_return_n_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
    }

    private void boh() {
        this.dLb = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tieba.frs.gamesubpb.view.a.7
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                Rect rect = new Rect();
                a.this.fJM.getPageContext().getPageActivity().getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
                int statusBarHeight = l.getStatusBarHeight(a.this.fJM.getPageContext().getPageActivity());
                int[] screenDimensions = l.getScreenDimensions(a.this.fJM.getPageContext().getPageActivity());
                if (screenDimensions[1] - rect.bottom > screenDimensions[1] / 4 && !a.this.YF) {
                    a.this.YF = true;
                    a.this.onKeyboardVisibilityChanged(true);
                } else if (screenDimensions[1] - rect.height() == statusBarHeight && a.this.YF) {
                    a.this.YF = false;
                    a.this.onKeyboardVisibilityChanged(false);
                }
            }
        };
        this.fJM.getPageContext().getPageActivity().getWindow().getDecorView().getViewTreeObserver().addOnGlobalLayoutListener(this.dLb);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(final d dVar) {
        final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.fJM.getPageContext().getPageActivity());
        aVar.nm(null);
        aVar.hT(R.string.del_post_confirm);
        aVar.eh(true);
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
        aVar.b(this.fJM.getPageContext()).akM();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(d dVar) {
        HttpMessage httpMessage = new HttpMessage(1003381);
        httpMessage.addParam("user_id", this.dzX);
        httpMessage.addParam("main_tower_id", dVar.fKc);
        httpMessage.addParam("id", dVar.id);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void wa(String str) {
        rl(0);
        HttpMessage httpMessage = new HttpMessage(1003380);
        httpMessage.addParam("user_id", this.dzX);
        httpMessage.addParam("reply_user_id", this.fKp);
        httpMessage.addParam("content", str);
        httpMessage.addParam("main_tower_id", this.fJA);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void boi() {
        this.fKp = this.fKn != null ? this.fKn.userId : null;
    }

    private void boj() {
        if (!v.isEmpty(this.fKo)) {
            this.mNavigationBar.setCenterTextTitle(String.format(this.fJM.getResources().getString(R.string.subpb_floor_reply_count), aq.numFormatOver10000(this.fKo.size())));
        } else {
            this.mNavigationBar.setCenterTextTitle(this.fJM.getResources().getString(R.string.reply));
        }
    }

    private void rk(final int i) {
        this.fKi.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.frs.gamesubpb.view.a.10
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                if (!TextUtils.isEmpty(charSequence)) {
                    a.this.fKj.setEnabled(true);
                    String charSequence2 = charSequence.toString();
                    if (!StringUtils.isNull(charSequence2) && aa.getTextLength(charSequence2) > i) {
                        String subString = aa.subString(charSequence2, 0, i - 1);
                        a.this.fKi.setText(subString);
                        a.this.fKi.setSelection(a.this.fKi.getText().length());
                        UtilHelper.showToast(a.this.fJM.getPageContext().getPageActivity().getApplication(), a.this.fJM.getPageContext().getPageActivity().getResources().getString(R.string.edit_text_over_limit_tip, Integer.valueOf(subString.length())));
                        return;
                    }
                    return;
                }
                a.this.boi();
                a.this.fKj.setEnabled(false);
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
            }
        });
    }

    private void bok() {
        if (this.mNavigationBar.getBackImageView() != null) {
            SvgManager.amL().a(this.mNavigationBar.getBackImageView(), R.drawable.icon_pure_topbar_return_n_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void kr(final boolean z) {
        if (this.duK != null) {
            if (!z) {
                this.duK.setEnabled(z);
            } else {
                this.duK.postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.gamesubpb.view.a.11
                    @Override // java.lang.Runnable
                    public void run() {
                        a.this.duK.setEnabled(z);
                    }
                }, 10L);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onKeyboardVisibilityChanged(boolean z) {
        if (z) {
            Rect rect = new Rect();
            this.cGv.getWindowVisibleDisplayFrame(rect);
            this.fKh.scrollTo(this.fKh.getScrollX(), (l.getScreenDimensions(this.fJM.getPageContext().getPageActivity())[1] - rect.bottom) - (MenuKeyUtils.hasSmartBar() ? l.dip2px(this.fJM.getPageContext().getPageActivity(), 48.0f) : 0));
            return;
        }
        this.fKh.setScrollY(0);
    }

    private void ks(boolean z) {
        if (v.isEmpty(this.fKo)) {
            this.duK.setNextPage(null);
            this.fKl.setVisibility(0);
        } else {
            this.duK.setNextPage(this.fKg);
            this.fKl.setVisibility(8);
            if (z) {
                this.fKg.startLoadData();
            } else {
                this.fKg.endLoadData();
            }
        }
        boj();
    }

    public void a(boolean z, com.baidu.tieba.frs.gamesubpb.model.b bVar, List<m> list) {
        this.hasMore = z;
        this.fKn = bVar;
        boi();
        if (v.isEmpty(list)) {
            ks(z);
            return;
        }
        this.fKo.clear();
        this.fKo.addAll(list);
        this.fKl.setVisibility(8);
        this.duK.setNextPage(this.fKg);
        this.fKm.setData(list);
        bok();
        this.fKk.setVisibility(0);
        this.fKk.setText(R.string.say_your_point);
        ks(z);
    }

    public void a(boolean z, String str, d dVar) {
        rl(8);
        if (z && dVar != null) {
            BdToast.b(this.fJM.getPageContext().getPageActivity(), this.fJM.getPageContext().getString(R.string.subpb_add_comment_succ_tip), 1).akR();
            this.fKi.setText((CharSequence) null);
            this.fKo.add(dVar);
            this.fKm.setData(this.fKo);
            ks(this.hasMore);
            this.fKi.post(new Runnable() { // from class: com.baidu.tieba.frs.gamesubpb.view.a.2
                @Override // java.lang.Runnable
                public void run() {
                    a.this.fKi.requestFocus();
                    l.hideSoftKeyPad(a.this.fJM.getPageContext().getPageActivity(), a.this.fKi);
                }
            });
            return;
        }
        if (TextUtils.isEmpty(str)) {
            str = this.fJM.getPageContext().getString(R.string.subpb_add_comment_fail_tip);
        }
        BdToast.b(this.fJM.getPageContext().getPageActivity(), str, 1).akR();
    }

    public void b(boolean z, String str, d dVar) {
        if (z) {
            BdToast.b(this.fJM.getPageContext().getPageActivity(), this.fJM.getPageContext().getString(R.string.subpb_delete_comment_succ_tip), 1).akR();
            this.fKo.remove(dVar);
            this.fKm.setData(this.fKo);
            ks(this.hasMore);
            return;
        }
        if (TextUtils.isEmpty(str)) {
            str = this.fJM.getPageContext().getString(R.string.subpb_delete_comment_fail_tip);
        }
        BdToast.b(this.fJM.getPageContext().getPageActivity(), str, 1).akR();
    }

    public void kt(boolean z) {
        if (this.fkk != null && this.fkk.getLayoutParams() != null) {
            ViewGroup.LayoutParams layoutParams = this.fkk.getLayoutParams();
            if (z) {
                bok();
                layoutParams.height = l.getDimens(this.fJM.getPageContext().getPageActivity(), R.dimen.ds98);
            } else {
                layoutParams.height = l.getDimens(this.fJM.getPageContext().getPageActivity(), R.dimen.ds98) + UtilHelper.getLightStatusBarHeight();
            }
            this.fkk.setLayoutParams(layoutParams);
        }
    }

    public void bT(View view) {
        if (this.fkk != null && this.mNavigationBar != null) {
            if (this.mNavigationBar.isNavigationBarExcludeStatusbarVisible()) {
                this.mNavigationBar.showNavigationBarExcludeStatusbar(false);
                if (UtilHelper.canUseStyleImmersiveSticky()) {
                    this.fkk.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight()));
                } else if (this.duK != null) {
                    this.duK.removeHeaderView(this.fkk);
                }
                this.mNavigationBar.setVisibility(8);
                return;
            }
            this.mNavigationBar.showNavigationBarExcludeStatusbar(true);
            if (UtilHelper.canUseStyleImmersiveSticky()) {
                this.fkk.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + l.getDimens(this.fJM.getActivity(), R.dimen.ds98)));
            } else if (this.duK != null) {
                this.duK.addHeaderView(this.fkk, 0);
            }
            this.mNavigationBar.setVisibility(0);
        }
    }

    public void wb(String str) {
        this.fKk.setVisibility(8);
        this.cGv.setVisibility(0);
        this.fKi.post(new Runnable() { // from class: com.baidu.tieba.frs.gamesubpb.view.a.3
            @Override // java.lang.Runnable
            public void run() {
                a.this.fKi.requestFocus();
                l.showSoftKeyPad(a.this.fJM.getPageContext().getPageActivity(), a.this.fKi);
            }
        });
        if (!TextUtils.isEmpty(str)) {
            String format = String.format(this.fJM.getPageContext().getPageActivity().getResources().getString(R.string.reply_sub_floor), str);
            this.fKi.setText(format);
            this.fKi.setSelection(format.length());
        }
    }

    public void rl(int i) {
        this.mProgressBar.setVisibility(i);
    }

    public View beB() {
        return this.fkk;
    }

    public View getRootView() {
        return this.mRootView;
    }

    public ListView getListView() {
        return this.duK;
    }

    public TextView bol() {
        return this.fKk;
    }

    public NavigationBar aKP() {
        return this.mNavigationBar;
    }

    public void e(com.baidu.tieba.frs.gamesubpb.c cVar) {
        this.fJw = cVar;
    }

    public void b(BdListView.e eVar) {
        this.duK.setOnSrollToBottomListener(eVar);
    }

    public void onChangeSkinType(int i) {
        this.fJM.getLayoutMode().setNightMode(i == 1);
        this.fJM.getLayoutMode().onModeChanged(this.mRootView);
        am.setBackgroundColor(this.mRootView, R.color.cp_bg_line_d);
        this.mNavigationBar.onChangeSkinType(this.fJM.getPageContext(), i);
        this.fKg.changeSkin(i);
        am.setViewTextColor(this.fKk, (int) R.color.cp_cont_e);
        this.fKk.setAlpha(0.95f);
        am.setBackgroundResource(this.fKk, R.drawable.pb_ecomm_comment_bg);
        am.setViewTextColor(this.fKl, (int) R.color.cp_cont_d);
        am.setBackgroundResource(this.cGv, R.drawable.pb_ecomm_comment_bg);
        am.setViewTextColor(this.fKi, (int) R.color.cp_cont_f);
        this.fKi.setHintTextColor(am.getColor(R.color.cp_cont_e));
        am.setViewTextColor(this.fKj, (int) R.color.game_sub_pb_send_txt_color);
    }

    public void onDestroy() {
        if (this.dLb != null) {
            this.fJM.getPageContext().getPageActivity().getWindow().getDecorView().getViewTreeObserver().removeGlobalOnLayoutListener(this.dLb);
        }
    }
}
