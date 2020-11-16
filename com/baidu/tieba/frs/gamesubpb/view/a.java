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
import com.baidu.adp.widget.ListView.q;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PersonPolymericActivityConfig;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tbadk.util.ae;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.gamesubpb.FrsGameSubPbActivity;
import com.baidu.tieba.frs.gamesubpb.a;
import com.baidu.tieba.frs.gamesubpb.model.d;
import com.baidu.tieba.frs.gamesubpb.model.e;
import com.baidu.tieba.pb.a.c;
import com.compatible.menukey.MenuKeyUtils;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes21.dex */
public class a {
    private View.OnClickListener aYm;
    private c fgS = new c(new c.a() { // from class: com.baidu.tieba.frs.gamesubpb.view.a.1
        @Override // com.baidu.tieba.pb.a.c.a
        public boolean onDoubleTap(View view, MotionEvent motionEvent) {
            a.this.qh(false);
            a.this.cK(view);
            a.this.qh(true);
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
    private LinearLayout fpk;
    private BdTypeListView ghN;
    private ViewTreeObserver.OnGlobalLayoutListener globalListener;
    private long goj;
    private boolean hasMore;
    private com.baidu.tieba.frs.gamesubpb.c iZG;
    private String iZK;
    private FrsGameSubPbActivity iZW;
    private View ixE;
    private e jaq;
    private FrameLayout jar;
    private EditText jas;
    private TextView jat;
    private TextView jau;
    private TextView jav;
    private com.baidu.tieba.frs.gamesubpb.b jaw;
    private com.baidu.tieba.frs.gamesubpb.model.b jax;
    private List<q> jay;
    private String jaz;
    private View mBack;
    private boolean mIsKeyboardOpen;
    private NavigationBar mNavigationBar;
    private ProgressBar mProgressBar;
    private RelativeLayout mRootView;

    public a(FrsGameSubPbActivity frsGameSubPbActivity, View.OnClickListener onClickListener, String str) {
        this.iZW = frsGameSubPbActivity;
        this.aYm = onClickListener;
        this.iZK = str;
        this.mRootView = (RelativeLayout) LayoutInflater.from(frsGameSubPbActivity.getPageContext().getPageActivity()).inflate(R.layout.frs_game_sub_pb_activity, (ViewGroup) null);
        this.ghN = (BdTypeListView) this.mRootView.findViewById(R.id.new_sub_pb_list);
        this.ghN.setOnTouchListener(this.fgS);
        this.ghN.setOnScrollListener(new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.frs.gamesubpb.view.a.4
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
                if (i != 0) {
                    l.hideSoftKeyPad(a.this.iZW.getPageContext().getPageActivity(), a.this.jas);
                }
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            }
        });
        this.jaq = new e(this.iZW.getPageContext());
        this.ixE = BdListViewHelper.a(this.iZW.getActivity(), this.ghN, BdListViewHelper.HeadType.DEFAULT);
        this.jau = (TextView) this.mRootView.findViewById(R.id.subpb_editor_tool_comment_reply_text);
        this.jau.setOnClickListener(this.aYm);
        this.jav = (TextView) this.mRootView.findViewById(R.id.no_reply_list_view);
        this.jar = (FrameLayout) this.mRootView.findViewById(R.id.bottom_view);
        this.fpk = (LinearLayout) this.mRootView.findViewById(R.id.subpb_editor_tool_comment_input_container);
        this.jas = (EditText) this.mRootView.findViewById(R.id.subpb_editor_tool_comment_input_edit);
        this.jat = (TextView) this.mRootView.findViewById(R.id.subpb_editor_tool_comment_send_tv);
        this.jat.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.gamesubpb.view.a.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.Kd(a.this.jas.getText().toString());
            }
        });
        this.mProgressBar = (ProgressBar) this.mRootView.findViewById(R.id.progressBar);
        cCL();
        this.jaw = new com.baidu.tieba.frs.gamesubpb.b(this.iZW.getPageContext(), this.ghN);
        this.jaw.setClickListener(new a.InterfaceC0731a() { // from class: com.baidu.tieba.frs.gamesubpb.view.a.6
            @Override // com.baidu.tieba.frs.gamesubpb.a.InterfaceC0731a
            public void a(d dVar) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonPolymericActivityConfig(a.this.iZW.getPageContext().getPageActivity()).createNormalConfig(Long.valueOf(dVar.userId).longValue(), String.valueOf(a.this.goj).equals(dVar.userId), false)));
            }

            @Override // com.baidu.tieba.frs.gamesubpb.a.InterfaceC0731a
            public void b(d dVar) {
                if (dVar != null) {
                    a.this.d(dVar);
                }
            }

            @Override // com.baidu.tieba.frs.gamesubpb.a.InterfaceC0731a
            public void c(d dVar) {
                if (a.this.iZG != null) {
                    a.this.iZG.cCE();
                }
                if (dVar == null) {
                    a.this.Ke(null);
                    a.this.cCN();
                    return;
                }
                a.this.Ke(dVar.userName);
                a.this.jaz = dVar.userId;
            }
        });
        Al(140);
        cCM();
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        this.jay = new ArrayList();
        this.goj = com.baidu.adp.lib.f.b.toLong(TbadkCoreApplication.getCurrentAccount(), 0L);
    }

    private void cCL() {
        this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(R.id.view_navigation_bar);
        this.mBack = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        ImageView backImageView = this.mNavigationBar.getBackImageView();
        if (backImageView != null && (backImageView.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.mBack.getLayoutParams();
            int dimens = l.getDimens(this.iZW.getPageContext().getPageActivity(), R.dimen.ds30);
            layoutParams.height = dimens;
            layoutParams.width = dimens;
            backImageView.setLayoutParams(layoutParams);
        }
        if (this.mBack != null && (this.mBack.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.mBack.getLayoutParams();
            layoutParams2.width = -2;
            layoutParams2.height = -1;
            this.mBack.setPadding(l.getDimens(this.iZW.getPageContext().getPageActivity(), R.dimen.ds32), this.mBack.getPaddingTop(), this.mBack.getPaddingRight(), this.mBack.getPaddingBottom());
            this.mBack.setLayoutParams(layoutParams2);
        }
        if (this.mNavigationBar.getBackImageView() != null) {
            SvgManager.bqB().a(this.mNavigationBar.getBackImageView(), R.drawable.ic_icon_pure_topbar_return40_svg, R.color.CAM_X0106, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
    }

    private void cCM() {
        this.globalListener = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tieba.frs.gamesubpb.view.a.7
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                Rect rect = new Rect();
                a.this.iZW.getPageContext().getPageActivity().getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
                int statusBarHeight = l.getStatusBarHeight(a.this.iZW.getPageContext().getPageActivity());
                int[] screenDimensions = l.getScreenDimensions(a.this.iZW.getPageContext().getPageActivity());
                if (screenDimensions[1] - rect.bottom > screenDimensions[1] / 4 && !a.this.mIsKeyboardOpen) {
                    a.this.mIsKeyboardOpen = true;
                    a.this.onKeyboardVisibilityChanged(true);
                } else if (screenDimensions[1] - rect.height() == statusBarHeight && a.this.mIsKeyboardOpen) {
                    a.this.mIsKeyboardOpen = false;
                    a.this.onKeyboardVisibilityChanged(false);
                }
            }
        };
        this.iZW.getPageContext().getPageActivity().getWindow().getDecorView().getViewTreeObserver().addOnGlobalLayoutListener(this.globalListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(final d dVar) {
        final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.iZW.getPageContext().getPageActivity());
        aVar.AI(null);
        aVar.os(R.string.del_post_confirm);
        aVar.iX(true);
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
        aVar.b(this.iZW.getPageContext()).bog();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(d dVar) {
        HttpMessage httpMessage = new HttpMessage(1003381);
        httpMessage.addParam("user_id", this.goj);
        httpMessage.addParam("main_tower_id", dVar.jam);
        httpMessage.addParam("id", dVar.id);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Kd(String str) {
        Am(0);
        HttpMessage httpMessage = new HttpMessage(1003380);
        httpMessage.addParam("user_id", this.goj);
        httpMessage.addParam("reply_user_id", this.jaz);
        httpMessage.addParam("content", str);
        httpMessage.addParam("main_tower_id", this.iZK);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cCN() {
        this.jaz = this.jax != null ? this.jax.userId : null;
    }

    private void cCO() {
        if (!y.isEmpty(this.jay)) {
            this.mNavigationBar.setCenterTextTitle(String.format(this.iZW.getResources().getString(R.string.subpb_floor_reply_count), au.numFormatOver10000(this.jay.size())));
        } else {
            this.mNavigationBar.setCenterTextTitle(this.iZW.getResources().getString(R.string.reply));
        }
    }

    private void Al(final int i) {
        this.jas.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.frs.gamesubpb.view.a.10
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                if (!TextUtils.isEmpty(charSequence)) {
                    a.this.jat.setEnabled(true);
                    String charSequence2 = charSequence.toString();
                    if (!StringUtils.isNull(charSequence2) && ae.getTextLength(charSequence2) > i) {
                        String subString = ae.subString(charSequence2, 0, i - 1);
                        a.this.jas.setText(subString);
                        a.this.jas.setSelection(a.this.jas.getText().length());
                        UtilHelper.showToast(a.this.iZW.getPageContext().getPageActivity().getApplication(), a.this.iZW.getPageContext().getPageActivity().getResources().getString(R.string.edit_text_over_limit_tip, Integer.valueOf(subString.length())));
                        return;
                    }
                    return;
                }
                a.this.cCN();
                a.this.jat.setEnabled(false);
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
            }
        });
    }

    private void cCP() {
        if (this.mNavigationBar.getBackImageView() != null) {
            SvgManager.bqB().a(this.mNavigationBar.getBackImageView(), R.drawable.ic_icon_pure_topbar_return40_svg, R.color.CAM_X0106, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qh(final boolean z) {
        if (this.ghN != null) {
            if (!z) {
                this.ghN.setEnabled(z);
            } else {
                this.ghN.postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.gamesubpb.view.a.11
                    @Override // java.lang.Runnable
                    public void run() {
                        a.this.ghN.setEnabled(z);
                    }
                }, 10L);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onKeyboardVisibilityChanged(boolean z) {
        if (z) {
            Rect rect = new Rect();
            this.fpk.getWindowVisibleDisplayFrame(rect);
            this.jar.scrollTo(this.jar.getScrollX(), (l.getScreenDimensions(this.iZW.getPageContext().getPageActivity())[1] - rect.bottom) - (MenuKeyUtils.hasSmartBar() ? l.dip2px(this.iZW.getPageContext().getPageActivity(), 48.0f) : 0));
            return;
        }
        this.jar.setScrollY(0);
    }

    private void qi(boolean z) {
        if (y.isEmpty(this.jay)) {
            this.ghN.setNextPage(null);
            this.jav.setVisibility(0);
        } else {
            this.ghN.setNextPage(this.jaq);
            this.jav.setVisibility(8);
            if (z) {
                this.jaq.startLoadData();
            } else {
                this.jaq.endLoadData();
            }
        }
        cCO();
    }

    public void a(boolean z, com.baidu.tieba.frs.gamesubpb.model.b bVar, List<q> list) {
        this.hasMore = z;
        this.jax = bVar;
        cCN();
        if (y.isEmpty(list)) {
            qi(z);
            return;
        }
        this.jay.clear();
        this.jay.addAll(list);
        this.jav.setVisibility(8);
        this.ghN.setNextPage(this.jaq);
        this.jaw.setData(list);
        cCP();
        this.jau.setVisibility(0);
        this.jau.setText(R.string.say_your_point);
        qi(z);
    }

    public void a(boolean z, String str, d dVar) {
        Am(8);
        if (z && dVar != null) {
            BdToast.a(this.iZW.getPageContext().getPageActivity(), this.iZW.getPageContext().getString(R.string.subpb_add_comment_succ_tip), 1).bom();
            this.jas.setText((CharSequence) null);
            this.jay.add(dVar);
            this.jaw.setData(this.jay);
            qi(this.hasMore);
            this.jas.post(new Runnable() { // from class: com.baidu.tieba.frs.gamesubpb.view.a.2
                @Override // java.lang.Runnable
                public void run() {
                    a.this.jas.requestFocus();
                    l.hideSoftKeyPad(a.this.iZW.getPageContext().getPageActivity(), a.this.jas);
                }
            });
            return;
        }
        if (TextUtils.isEmpty(str)) {
            str = this.iZW.getPageContext().getString(R.string.subpb_add_comment_fail_tip);
        }
        BdToast.a(this.iZW.getPageContext().getPageActivity(), str, 1).bom();
    }

    public void b(boolean z, String str, d dVar) {
        if (z) {
            BdToast.a(this.iZW.getPageContext().getPageActivity(), this.iZW.getPageContext().getString(R.string.subpb_delete_comment_succ_tip), 1).bom();
            this.jay.remove(dVar);
            this.jaw.setData(this.jay);
            qi(this.hasMore);
            return;
        }
        if (TextUtils.isEmpty(str)) {
            str = this.iZW.getPageContext().getString(R.string.subpb_delete_comment_fail_tip);
        }
        BdToast.a(this.iZW.getPageContext().getPageActivity(), str, 1).bom();
    }

    public void qj(boolean z) {
        if (this.ixE != null && this.ixE.getLayoutParams() != null) {
            ViewGroup.LayoutParams layoutParams = this.ixE.getLayoutParams();
            if (z) {
                cCP();
                layoutParams.height = l.getDimens(this.iZW.getPageContext().getPageActivity(), R.dimen.ds98);
            } else {
                layoutParams.height = l.getDimens(this.iZW.getPageContext().getPageActivity(), R.dimen.ds98) + UtilHelper.getLightStatusBarHeight();
            }
            this.ixE.setLayoutParams(layoutParams);
        }
    }

    public void cK(View view) {
        if (this.ixE != null && this.mNavigationBar != null) {
            if (this.mNavigationBar.isNavigationBarExcludeStatusbarVisible()) {
                this.mNavigationBar.showNavigationBarExcludeStatusbar(false);
                if (UtilHelper.canUseStyleImmersiveSticky()) {
                    this.ixE.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight()));
                } else if (this.ghN != null) {
                    this.ghN.removeHeaderView(this.ixE);
                }
                this.mNavigationBar.setVisibility(8);
                return;
            }
            this.mNavigationBar.showNavigationBarExcludeStatusbar(true);
            if (UtilHelper.canUseStyleImmersiveSticky()) {
                this.ixE.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + l.getDimens(this.iZW.getActivity(), R.dimen.ds98)));
            } else if (this.ghN != null) {
                this.ghN.addHeaderView(this.ixE, 0);
            }
            this.mNavigationBar.setVisibility(0);
        }
    }

    public void Ke(String str) {
        this.jau.setVisibility(8);
        this.fpk.setVisibility(0);
        this.jas.post(new Runnable() { // from class: com.baidu.tieba.frs.gamesubpb.view.a.3
            @Override // java.lang.Runnable
            public void run() {
                a.this.jas.requestFocus();
                l.showSoftKeyPad(a.this.iZW.getPageContext().getPageActivity(), a.this.jas);
            }
        });
        if (!TextUtils.isEmpty(str)) {
            String format = String.format(this.iZW.getPageContext().getPageActivity().getResources().getString(R.string.reply_sub_floor), str);
            this.jas.setText(format);
            this.jas.setSelection(format.length());
        }
    }

    public void Am(int i) {
        this.mProgressBar.setVisibility(i);
    }

    public View crM() {
        return this.ixE;
    }

    public View getRootView() {
        return this.mRootView;
    }

    public ListView getListView() {
        return this.ghN;
    }

    public TextView cCQ() {
        return this.jau;
    }

    public NavigationBar bSa() {
        return this.mNavigationBar;
    }

    public void e(com.baidu.tieba.frs.gamesubpb.c cVar) {
        this.iZG = cVar;
    }

    public void b(BdListView.e eVar) {
        this.ghN.setOnSrollToBottomListener(eVar);
    }

    public void onChangeSkinType(int i) {
        this.iZW.getLayoutMode().setNightMode(i == 1);
        this.iZW.getLayoutMode().onModeChanged(this.mRootView);
        ap.setBackgroundColor(this.mRootView, R.color.CAM_X0201);
        this.mNavigationBar.onChangeSkinType(this.iZW.getPageContext(), i);
        this.jaq.changeSkin(i);
        ap.setViewTextColor(this.jau, (int) R.color.CAM_X0110);
        this.jau.setAlpha(0.95f);
        ap.setBackgroundResource(this.jau, R.drawable.pb_ecomm_comment_bg);
        ap.setViewTextColor(this.jav, (int) R.color.CAM_X0109);
        ap.setBackgroundResource(this.fpk, R.drawable.pb_ecomm_comment_bg);
        ap.setViewTextColor(this.jas, (int) R.color.CAM_X0106);
        this.jas.setHintTextColor(ap.getColor(R.color.CAM_X0110));
        ap.setViewTextColor(this.jat, (int) R.color.game_sub_pb_send_txt_color);
    }

    public void onDestroy() {
        if (this.globalListener != null) {
            this.iZW.getPageContext().getPageActivity().getWindow().getDecorView().getViewTreeObserver().removeGlobalOnLayoutListener(this.globalListener);
        }
    }
}
