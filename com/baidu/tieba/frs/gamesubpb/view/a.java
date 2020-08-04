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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.util.x;
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
/* loaded from: classes16.dex */
public class a {
    private View.OnClickListener aMH;
    private LinearLayout eCl;
    private c euG = new c(new c.a() { // from class: com.baidu.tieba.frs.gamesubpb.view.a.1
        @Override // com.baidu.tieba.pb.a.c.a
        public boolean onDoubleTap(View view, MotionEvent motionEvent) {
            a.this.om(false);
            a.this.ci(view);
            a.this.om(true);
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
    private BdTypeListView frv;
    private long fxI;
    private ViewTreeObserver.OnGlobalLayoutListener globalListener;
    private FrsGameSubPbActivity hWJ;
    private com.baidu.tieba.frs.gamesubpb.c hWt;
    private String hWx;
    private e hXd;
    private FrameLayout hXe;
    private EditText hXf;
    private TextView hXg;
    private TextView hXh;
    private TextView hXi;
    private com.baidu.tieba.frs.gamesubpb.b hXj;
    private com.baidu.tieba.frs.gamesubpb.model.b hXk;
    private List<q> hXl;
    private String hXm;
    private boolean hasMore;
    private View huZ;
    private View mBack;
    private boolean mIsKeyboardOpen;
    private NavigationBar mNavigationBar;
    private ProgressBar mProgressBar;
    private RelativeLayout mRootView;

    public a(FrsGameSubPbActivity frsGameSubPbActivity, View.OnClickListener onClickListener, String str) {
        this.hWJ = frsGameSubPbActivity;
        this.aMH = onClickListener;
        this.hWx = str;
        this.mRootView = (RelativeLayout) LayoutInflater.from(frsGameSubPbActivity.getPageContext().getPageActivity()).inflate(R.layout.frs_game_sub_pb_activity, (ViewGroup) null);
        this.frv = (BdTypeListView) this.mRootView.findViewById(R.id.new_sub_pb_list);
        this.frv.setOnTouchListener(this.euG);
        this.frv.setOnScrollListener(new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.frs.gamesubpb.view.a.4
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
                if (i != 0) {
                    l.hideSoftKeyPad(a.this.hWJ.getPageContext().getPageActivity(), a.this.hXf);
                }
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            }
        });
        this.hXd = new e(this.hWJ.getPageContext());
        this.huZ = BdListViewHelper.a(this.hWJ.getActivity(), this.frv, BdListViewHelper.HeadType.DEFAULT);
        this.hXh = (TextView) this.mRootView.findViewById(R.id.subpb_editor_tool_comment_reply_text);
        this.hXh.setOnClickListener(this.aMH);
        this.hXi = (TextView) this.mRootView.findViewById(R.id.no_reply_list_view);
        this.hXe = (FrameLayout) this.mRootView.findViewById(R.id.bottom_view);
        this.eCl = (LinearLayout) this.mRootView.findViewById(R.id.subpb_editor_tool_comment_input_container);
        this.hXf = (EditText) this.mRootView.findViewById(R.id.subpb_editor_tool_comment_input_edit);
        this.hXg = (TextView) this.mRootView.findViewById(R.id.subpb_editor_tool_comment_send_tv);
        this.hXg.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.gamesubpb.view.a.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.FZ(a.this.hXf.getText().toString());
            }
        });
        this.mProgressBar = (ProgressBar) this.mRootView.findViewById(R.id.progressBar);
        cgj();
        this.hXj = new com.baidu.tieba.frs.gamesubpb.b(this.hWJ.getPageContext(), this.frv);
        this.hXj.setClickListener(new a.InterfaceC0634a() { // from class: com.baidu.tieba.frs.gamesubpb.view.a.6
            @Override // com.baidu.tieba.frs.gamesubpb.a.InterfaceC0634a
            public void a(d dVar) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonPolymericActivityConfig(a.this.hWJ.getPageContext().getPageActivity()).createNormalConfig(Long.valueOf(dVar.userId).longValue(), String.valueOf(a.this.fxI).equals(dVar.userId), false)));
            }

            @Override // com.baidu.tieba.frs.gamesubpb.a.InterfaceC0634a
            public void b(d dVar) {
                if (dVar != null) {
                    a.this.d(dVar);
                }
            }

            @Override // com.baidu.tieba.frs.gamesubpb.a.InterfaceC0634a
            public void c(d dVar) {
                if (a.this.hWt != null) {
                    a.this.hWt.cgc();
                }
                if (dVar == null) {
                    a.this.Ga(null);
                    a.this.cgl();
                    return;
                }
                a.this.Ga(dVar.userName);
                a.this.hXm = dVar.userId;
            }
        });
        vJ(140);
        cgk();
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        this.hXl = new ArrayList();
        this.fxI = com.baidu.adp.lib.f.b.toLong(TbadkCoreApplication.getCurrentAccount(), 0L);
    }

    private void cgj() {
        this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(R.id.view_navigation_bar);
        this.mBack = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        ImageView backImageView = this.mNavigationBar.getBackImageView();
        if (backImageView != null && (backImageView.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.mBack.getLayoutParams();
            int dimens = l.getDimens(this.hWJ.getPageContext().getPageActivity(), R.dimen.ds30);
            layoutParams.height = dimens;
            layoutParams.width = dimens;
            backImageView.setLayoutParams(layoutParams);
        }
        if (this.mBack != null && (this.mBack.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.mBack.getLayoutParams();
            layoutParams2.width = -2;
            layoutParams2.height = -1;
            this.mBack.setPadding(l.getDimens(this.hWJ.getPageContext().getPageActivity(), R.dimen.ds32), this.mBack.getPaddingTop(), this.mBack.getPaddingRight(), this.mBack.getPaddingBottom());
            this.mBack.setLayoutParams(layoutParams2);
        }
        if (this.mNavigationBar.getBackImageView() != null) {
            SvgManager.baR().a(this.mNavigationBar.getBackImageView(), R.drawable.icon_pure_topbar_return44_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
    }

    private void cgk() {
        this.globalListener = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tieba.frs.gamesubpb.view.a.7
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                Rect rect = new Rect();
                a.this.hWJ.getPageContext().getPageActivity().getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
                int statusBarHeight = l.getStatusBarHeight(a.this.hWJ.getPageContext().getPageActivity());
                int[] screenDimensions = l.getScreenDimensions(a.this.hWJ.getPageContext().getPageActivity());
                if (screenDimensions[1] - rect.bottom > screenDimensions[1] / 4 && !a.this.mIsKeyboardOpen) {
                    a.this.mIsKeyboardOpen = true;
                    a.this.onKeyboardVisibilityChanged(true);
                } else if (screenDimensions[1] - rect.height() == statusBarHeight && a.this.mIsKeyboardOpen) {
                    a.this.mIsKeyboardOpen = false;
                    a.this.onKeyboardVisibilityChanged(false);
                }
            }
        };
        this.hWJ.getPageContext().getPageActivity().getWindow().getDecorView().getViewTreeObserver().addOnGlobalLayoutListener(this.globalListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(final d dVar) {
        final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.hWJ.getPageContext().getPageActivity());
        aVar.xk(null);
        aVar.ln(R.string.del_post_confirm);
        aVar.hK(true);
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
        aVar.b(this.hWJ.getPageContext()).aYL();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(d dVar) {
        HttpMessage httpMessage = new HttpMessage(1003381);
        httpMessage.addParam("user_id", this.fxI);
        httpMessage.addParam("main_tower_id", dVar.hWZ);
        httpMessage.addParam("id", dVar.id);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void FZ(String str) {
        vK(0);
        HttpMessage httpMessage = new HttpMessage(1003380);
        httpMessage.addParam("user_id", this.fxI);
        httpMessage.addParam("reply_user_id", this.hXm);
        httpMessage.addParam("content", str);
        httpMessage.addParam("main_tower_id", this.hWx);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cgl() {
        this.hXm = this.hXk != null ? this.hXk.userId : null;
    }

    private void cgm() {
        if (!x.isEmpty(this.hXl)) {
            this.mNavigationBar.setCenterTextTitle(String.format(this.hWJ.getResources().getString(R.string.subpb_floor_reply_count), as.numFormatOver10000(this.hXl.size())));
        } else {
            this.mNavigationBar.setCenterTextTitle(this.hWJ.getResources().getString(R.string.reply));
        }
    }

    private void vJ(final int i) {
        this.hXf.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.frs.gamesubpb.view.a.10
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                if (!TextUtils.isEmpty(charSequence)) {
                    a.this.hXg.setEnabled(true);
                    String charSequence2 = charSequence.toString();
                    if (!StringUtils.isNull(charSequence2) && ae.getTextLength(charSequence2) > i) {
                        String subString = ae.subString(charSequence2, 0, i - 1);
                        a.this.hXf.setText(subString);
                        a.this.hXf.setSelection(a.this.hXf.getText().length());
                        UtilHelper.showToast(a.this.hWJ.getPageContext().getPageActivity().getApplication(), a.this.hWJ.getPageContext().getPageActivity().getResources().getString(R.string.edit_text_over_limit_tip, Integer.valueOf(subString.length())));
                        return;
                    }
                    return;
                }
                a.this.cgl();
                a.this.hXg.setEnabled(false);
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
            }
        });
    }

    private void cgn() {
        if (this.mNavigationBar.getBackImageView() != null) {
            SvgManager.baR().a(this.mNavigationBar.getBackImageView(), R.drawable.icon_pure_topbar_return44_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void om(final boolean z) {
        if (this.frv != null) {
            if (!z) {
                this.frv.setEnabled(z);
            } else {
                this.frv.postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.gamesubpb.view.a.11
                    @Override // java.lang.Runnable
                    public void run() {
                        a.this.frv.setEnabled(z);
                    }
                }, 10L);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onKeyboardVisibilityChanged(boolean z) {
        if (z) {
            Rect rect = new Rect();
            this.eCl.getWindowVisibleDisplayFrame(rect);
            this.hXe.scrollTo(this.hXe.getScrollX(), (l.getScreenDimensions(this.hWJ.getPageContext().getPageActivity())[1] - rect.bottom) - (MenuKeyUtils.hasSmartBar() ? l.dip2px(this.hWJ.getPageContext().getPageActivity(), 48.0f) : 0));
            return;
        }
        this.hXe.setScrollY(0);
    }

    private void on(boolean z) {
        if (x.isEmpty(this.hXl)) {
            this.frv.setNextPage(null);
            this.hXi.setVisibility(0);
        } else {
            this.frv.setNextPage(this.hXd);
            this.hXi.setVisibility(8);
            if (z) {
                this.hXd.startLoadData();
            } else {
                this.hXd.endLoadData();
            }
        }
        cgm();
    }

    public void a(boolean z, com.baidu.tieba.frs.gamesubpb.model.b bVar, List<q> list) {
        this.hasMore = z;
        this.hXk = bVar;
        cgl();
        if (x.isEmpty(list)) {
            on(z);
            return;
        }
        this.hXl.clear();
        this.hXl.addAll(list);
        this.hXi.setVisibility(8);
        this.frv.setNextPage(this.hXd);
        this.hXj.setData(list);
        cgn();
        this.hXh.setVisibility(0);
        this.hXh.setText(R.string.say_your_point);
        on(z);
    }

    public void a(boolean z, String str, d dVar) {
        vK(8);
        if (z && dVar != null) {
            BdToast.a(this.hWJ.getPageContext().getPageActivity(), this.hWJ.getPageContext().getString(R.string.subpb_add_comment_succ_tip), 1).aYR();
            this.hXf.setText((CharSequence) null);
            this.hXl.add(dVar);
            this.hXj.setData(this.hXl);
            on(this.hasMore);
            this.hXf.post(new Runnable() { // from class: com.baidu.tieba.frs.gamesubpb.view.a.2
                @Override // java.lang.Runnable
                public void run() {
                    a.this.hXf.requestFocus();
                    l.hideSoftKeyPad(a.this.hWJ.getPageContext().getPageActivity(), a.this.hXf);
                }
            });
            return;
        }
        if (TextUtils.isEmpty(str)) {
            str = this.hWJ.getPageContext().getString(R.string.subpb_add_comment_fail_tip);
        }
        BdToast.a(this.hWJ.getPageContext().getPageActivity(), str, 1).aYR();
    }

    public void b(boolean z, String str, d dVar) {
        if (z) {
            BdToast.a(this.hWJ.getPageContext().getPageActivity(), this.hWJ.getPageContext().getString(R.string.subpb_delete_comment_succ_tip), 1).aYR();
            this.hXl.remove(dVar);
            this.hXj.setData(this.hXl);
            on(this.hasMore);
            return;
        }
        if (TextUtils.isEmpty(str)) {
            str = this.hWJ.getPageContext().getString(R.string.subpb_delete_comment_fail_tip);
        }
        BdToast.a(this.hWJ.getPageContext().getPageActivity(), str, 1).aYR();
    }

    public void oo(boolean z) {
        if (this.huZ != null && this.huZ.getLayoutParams() != null) {
            ViewGroup.LayoutParams layoutParams = this.huZ.getLayoutParams();
            if (z) {
                cgn();
                layoutParams.height = l.getDimens(this.hWJ.getPageContext().getPageActivity(), R.dimen.ds98);
            } else {
                layoutParams.height = l.getDimens(this.hWJ.getPageContext().getPageActivity(), R.dimen.ds98) + UtilHelper.getLightStatusBarHeight();
            }
            this.huZ.setLayoutParams(layoutParams);
        }
    }

    public void ci(View view) {
        if (this.huZ != null && this.mNavigationBar != null) {
            if (this.mNavigationBar.isNavigationBarExcludeStatusbarVisible()) {
                this.mNavigationBar.showNavigationBarExcludeStatusbar(false);
                if (UtilHelper.canUseStyleImmersiveSticky()) {
                    this.huZ.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight()));
                } else if (this.frv != null) {
                    this.frv.removeHeaderView(this.huZ);
                }
                this.mNavigationBar.setVisibility(8);
                return;
            }
            this.mNavigationBar.showNavigationBarExcludeStatusbar(true);
            if (UtilHelper.canUseStyleImmersiveSticky()) {
                this.huZ.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + l.getDimens(this.hWJ.getActivity(), R.dimen.ds98)));
            } else if (this.frv != null) {
                this.frv.addHeaderView(this.huZ, 0);
            }
            this.mNavigationBar.setVisibility(0);
        }
    }

    public void Ga(String str) {
        this.hXh.setVisibility(8);
        this.eCl.setVisibility(0);
        this.hXf.post(new Runnable() { // from class: com.baidu.tieba.frs.gamesubpb.view.a.3
            @Override // java.lang.Runnable
            public void run() {
                a.this.hXf.requestFocus();
                l.showSoftKeyPad(a.this.hWJ.getPageContext().getPageActivity(), a.this.hXf);
            }
        });
        if (!TextUtils.isEmpty(str)) {
            String format = String.format(this.hWJ.getPageContext().getPageActivity().getResources().getString(R.string.reply_sub_floor), str);
            this.hXf.setText(format);
            this.hXf.setSelection(format.length());
        }
    }

    public void vK(int i) {
        this.mProgressBar.setVisibility(i);
    }

    public View bVw() {
        return this.huZ;
    }

    public View getRootView() {
        return this.mRootView;
    }

    public ListView getListView() {
        return this.frv;
    }

    public TextView cgo() {
        return this.hXh;
    }

    public NavigationBar bAm() {
        return this.mNavigationBar;
    }

    public void e(com.baidu.tieba.frs.gamesubpb.c cVar) {
        this.hWt = cVar;
    }

    public void b(BdListView.e eVar) {
        this.frv.setOnSrollToBottomListener(eVar);
    }

    public void onChangeSkinType(int i) {
        this.hWJ.getLayoutMode().setNightMode(i == 1);
        this.hWJ.getLayoutMode().onModeChanged(this.mRootView);
        ao.setBackgroundColor(this.mRootView, R.color.cp_bg_line_d);
        this.mNavigationBar.onChangeSkinType(this.hWJ.getPageContext(), i);
        this.hXd.changeSkin(i);
        ao.setViewTextColor(this.hXh, R.color.cp_cont_e);
        this.hXh.setAlpha(0.95f);
        ao.setBackgroundResource(this.hXh, R.drawable.pb_ecomm_comment_bg);
        ao.setViewTextColor(this.hXi, R.color.cp_cont_d);
        ao.setBackgroundResource(this.eCl, R.drawable.pb_ecomm_comment_bg);
        ao.setViewTextColor(this.hXf, R.color.cp_cont_f);
        this.hXf.setHintTextColor(ao.getColor(R.color.cp_cont_e));
        ao.setViewTextColor(this.hXg, R.color.game_sub_pb_send_txt_color);
    }

    public void onDestroy() {
        if (this.globalListener != null) {
            this.hWJ.getPageContext().getPageActivity().getWindow().getDecorView().getViewTreeObserver().removeGlobalOnLayoutListener(this.globalListener);
        }
    }
}
