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
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tbadk.util.af;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.gamesubpb.FrsGameSubPbActivity;
import com.baidu.tieba.frs.gamesubpb.a;
import com.baidu.tieba.frs.gamesubpb.model.d;
import com.baidu.tieba.frs.gamesubpb.model.e;
import com.baidu.tieba.pb.a.c;
import com.compatible.menukey.MenuKeyUtils;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes22.dex */
public class a {
    private View.OnClickListener aYF;
    private c fbT = new c(new c.a() { // from class: com.baidu.tieba.frs.gamesubpb.view.a.1
        @Override // com.baidu.tieba.pb.a.c.a
        public boolean onDoubleTap(View view, MotionEvent motionEvent) {
            a.this.pV(false);
            a.this.cB(view);
            a.this.pV(true);
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
    private LinearLayout fkl;
    private BdTypeListView gcr;
    private long giP;
    private ViewTreeObserver.OnGlobalLayoutListener globalListener;
    private boolean hasMore;
    private com.baidu.tieba.frs.gamesubpb.c iSX;
    private e iTH;
    private FrameLayout iTI;
    private EditText iTJ;
    private TextView iTK;
    private TextView iTL;
    private TextView iTM;
    private com.baidu.tieba.frs.gamesubpb.b iTN;
    private com.baidu.tieba.frs.gamesubpb.model.b iTO;
    private List<q> iTP;
    private String iTQ;
    private String iTb;
    private FrsGameSubPbActivity iTn;
    private View iqS;
    private View mBack;
    private boolean mIsKeyboardOpen;
    private NavigationBar mNavigationBar;
    private ProgressBar mProgressBar;
    private RelativeLayout mRootView;

    public a(FrsGameSubPbActivity frsGameSubPbActivity, View.OnClickListener onClickListener, String str) {
        this.iTn = frsGameSubPbActivity;
        this.aYF = onClickListener;
        this.iTb = str;
        this.mRootView = (RelativeLayout) LayoutInflater.from(frsGameSubPbActivity.getPageContext().getPageActivity()).inflate(R.layout.frs_game_sub_pb_activity, (ViewGroup) null);
        this.gcr = (BdTypeListView) this.mRootView.findViewById(R.id.new_sub_pb_list);
        this.gcr.setOnTouchListener(this.fbT);
        this.gcr.setOnScrollListener(new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.frs.gamesubpb.view.a.4
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
                if (i != 0) {
                    l.hideSoftKeyPad(a.this.iTn.getPageContext().getPageActivity(), a.this.iTJ);
                }
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            }
        });
        this.iTH = new e(this.iTn.getPageContext());
        this.iqS = BdListViewHelper.a(this.iTn.getActivity(), this.gcr, BdListViewHelper.HeadType.DEFAULT);
        this.iTL = (TextView) this.mRootView.findViewById(R.id.subpb_editor_tool_comment_reply_text);
        this.iTL.setOnClickListener(this.aYF);
        this.iTM = (TextView) this.mRootView.findViewById(R.id.no_reply_list_view);
        this.iTI = (FrameLayout) this.mRootView.findViewById(R.id.bottom_view);
        this.fkl = (LinearLayout) this.mRootView.findViewById(R.id.subpb_editor_tool_comment_input_container);
        this.iTJ = (EditText) this.mRootView.findViewById(R.id.subpb_editor_tool_comment_input_edit);
        this.iTK = (TextView) this.mRootView.findViewById(R.id.subpb_editor_tool_comment_send_tv);
        this.iTK.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.gamesubpb.view.a.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.Kl(a.this.iTJ.getText().toString());
            }
        });
        this.mProgressBar = (ProgressBar) this.mRootView.findViewById(R.id.progressBar);
        cAG();
        this.iTN = new com.baidu.tieba.frs.gamesubpb.b(this.iTn.getPageContext(), this.gcr);
        this.iTN.setClickListener(new a.InterfaceC0716a() { // from class: com.baidu.tieba.frs.gamesubpb.view.a.6
            @Override // com.baidu.tieba.frs.gamesubpb.a.InterfaceC0716a
            public void a(d dVar) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonPolymericActivityConfig(a.this.iTn.getPageContext().getPageActivity()).createNormalConfig(Long.valueOf(dVar.userId).longValue(), String.valueOf(a.this.giP).equals(dVar.userId), false)));
            }

            @Override // com.baidu.tieba.frs.gamesubpb.a.InterfaceC0716a
            public void b(d dVar) {
                if (dVar != null) {
                    a.this.d(dVar);
                }
            }

            @Override // com.baidu.tieba.frs.gamesubpb.a.InterfaceC0716a
            public void c(d dVar) {
                if (a.this.iSX != null) {
                    a.this.iSX.cAz();
                }
                if (dVar == null) {
                    a.this.Km(null);
                    a.this.cAI();
                    return;
                }
                a.this.Km(dVar.userName);
                a.this.iTQ = dVar.userId;
            }
        });
        zA(140);
        cAH();
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        this.iTP = new ArrayList();
        this.giP = com.baidu.adp.lib.f.b.toLong(TbadkCoreApplication.getCurrentAccount(), 0L);
    }

    private void cAG() {
        this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(R.id.view_navigation_bar);
        this.mBack = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        ImageView backImageView = this.mNavigationBar.getBackImageView();
        if (backImageView != null && (backImageView.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.mBack.getLayoutParams();
            int dimens = l.getDimens(this.iTn.getPageContext().getPageActivity(), R.dimen.ds30);
            layoutParams.height = dimens;
            layoutParams.width = dimens;
            backImageView.setLayoutParams(layoutParams);
        }
        if (this.mBack != null && (this.mBack.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.mBack.getLayoutParams();
            layoutParams2.width = -2;
            layoutParams2.height = -1;
            this.mBack.setPadding(l.getDimens(this.iTn.getPageContext().getPageActivity(), R.dimen.ds32), this.mBack.getPaddingTop(), this.mBack.getPaddingRight(), this.mBack.getPaddingBottom());
            this.mBack.setLayoutParams(layoutParams2);
        }
        if (this.mNavigationBar.getBackImageView() != null) {
            SvgManager.boN().a(this.mNavigationBar.getBackImageView(), R.drawable.icon_pure_topbar_return44_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
    }

    private void cAH() {
        this.globalListener = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tieba.frs.gamesubpb.view.a.7
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                Rect rect = new Rect();
                a.this.iTn.getPageContext().getPageActivity().getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
                int statusBarHeight = l.getStatusBarHeight(a.this.iTn.getPageContext().getPageActivity());
                int[] screenDimensions = l.getScreenDimensions(a.this.iTn.getPageContext().getPageActivity());
                if (screenDimensions[1] - rect.bottom > screenDimensions[1] / 4 && !a.this.mIsKeyboardOpen) {
                    a.this.mIsKeyboardOpen = true;
                    a.this.onKeyboardVisibilityChanged(true);
                } else if (screenDimensions[1] - rect.height() == statusBarHeight && a.this.mIsKeyboardOpen) {
                    a.this.mIsKeyboardOpen = false;
                    a.this.onKeyboardVisibilityChanged(false);
                }
            }
        };
        this.iTn.getPageContext().getPageActivity().getWindow().getDecorView().getViewTreeObserver().addOnGlobalLayoutListener(this.globalListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(final d dVar) {
        final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.iTn.getPageContext().getPageActivity());
        aVar.AZ(null);
        aVar.om(R.string.del_post_confirm);
        aVar.iN(true);
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
        aVar.b(this.iTn.getPageContext()).bmC();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(d dVar) {
        HttpMessage httpMessage = new HttpMessage(1003381);
        httpMessage.addParam("user_id", this.giP);
        httpMessage.addParam("main_tower_id", dVar.iTD);
        httpMessage.addParam("id", dVar.id);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Kl(String str) {
        zB(0);
        HttpMessage httpMessage = new HttpMessage(1003380);
        httpMessage.addParam("user_id", this.giP);
        httpMessage.addParam("reply_user_id", this.iTQ);
        httpMessage.addParam("content", str);
        httpMessage.addParam("main_tower_id", this.iTb);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cAI() {
        this.iTQ = this.iTO != null ? this.iTO.userId : null;
    }

    private void cAJ() {
        if (!y.isEmpty(this.iTP)) {
            this.mNavigationBar.setCenterTextTitle(String.format(this.iTn.getResources().getString(R.string.subpb_floor_reply_count), at.numFormatOver10000(this.iTP.size())));
        } else {
            this.mNavigationBar.setCenterTextTitle(this.iTn.getResources().getString(R.string.reply));
        }
    }

    private void zA(final int i) {
        this.iTJ.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.frs.gamesubpb.view.a.10
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                if (!TextUtils.isEmpty(charSequence)) {
                    a.this.iTK.setEnabled(true);
                    String charSequence2 = charSequence.toString();
                    if (!StringUtils.isNull(charSequence2) && af.getTextLength(charSequence2) > i) {
                        String subString = af.subString(charSequence2, 0, i - 1);
                        a.this.iTJ.setText(subString);
                        a.this.iTJ.setSelection(a.this.iTJ.getText().length());
                        UtilHelper.showToast(a.this.iTn.getPageContext().getPageActivity().getApplication(), a.this.iTn.getPageContext().getPageActivity().getResources().getString(R.string.edit_text_over_limit_tip, Integer.valueOf(subString.length())));
                        return;
                    }
                    return;
                }
                a.this.cAI();
                a.this.iTK.setEnabled(false);
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
            }
        });
    }

    private void cAK() {
        if (this.mNavigationBar.getBackImageView() != null) {
            SvgManager.boN().a(this.mNavigationBar.getBackImageView(), R.drawable.icon_pure_topbar_return44_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pV(final boolean z) {
        if (this.gcr != null) {
            if (!z) {
                this.gcr.setEnabled(z);
            } else {
                this.gcr.postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.gamesubpb.view.a.11
                    @Override // java.lang.Runnable
                    public void run() {
                        a.this.gcr.setEnabled(z);
                    }
                }, 10L);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onKeyboardVisibilityChanged(boolean z) {
        if (z) {
            Rect rect = new Rect();
            this.fkl.getWindowVisibleDisplayFrame(rect);
            this.iTI.scrollTo(this.iTI.getScrollX(), (l.getScreenDimensions(this.iTn.getPageContext().getPageActivity())[1] - rect.bottom) - (MenuKeyUtils.hasSmartBar() ? l.dip2px(this.iTn.getPageContext().getPageActivity(), 48.0f) : 0));
            return;
        }
        this.iTI.setScrollY(0);
    }

    private void pW(boolean z) {
        if (y.isEmpty(this.iTP)) {
            this.gcr.setNextPage(null);
            this.iTM.setVisibility(0);
        } else {
            this.gcr.setNextPage(this.iTH);
            this.iTM.setVisibility(8);
            if (z) {
                this.iTH.startLoadData();
            } else {
                this.iTH.endLoadData();
            }
        }
        cAJ();
    }

    public void a(boolean z, com.baidu.tieba.frs.gamesubpb.model.b bVar, List<q> list) {
        this.hasMore = z;
        this.iTO = bVar;
        cAI();
        if (y.isEmpty(list)) {
            pW(z);
            return;
        }
        this.iTP.clear();
        this.iTP.addAll(list);
        this.iTM.setVisibility(8);
        this.gcr.setNextPage(this.iTH);
        this.iTN.setData(list);
        cAK();
        this.iTL.setVisibility(0);
        this.iTL.setText(R.string.say_your_point);
        pW(z);
    }

    public void a(boolean z, String str, d dVar) {
        zB(8);
        if (z && dVar != null) {
            BdToast.a(this.iTn.getPageContext().getPageActivity(), this.iTn.getPageContext().getString(R.string.subpb_add_comment_succ_tip), 1).bmI();
            this.iTJ.setText((CharSequence) null);
            this.iTP.add(dVar);
            this.iTN.setData(this.iTP);
            pW(this.hasMore);
            this.iTJ.post(new Runnable() { // from class: com.baidu.tieba.frs.gamesubpb.view.a.2
                @Override // java.lang.Runnable
                public void run() {
                    a.this.iTJ.requestFocus();
                    l.hideSoftKeyPad(a.this.iTn.getPageContext().getPageActivity(), a.this.iTJ);
                }
            });
            return;
        }
        if (TextUtils.isEmpty(str)) {
            str = this.iTn.getPageContext().getString(R.string.subpb_add_comment_fail_tip);
        }
        BdToast.a(this.iTn.getPageContext().getPageActivity(), str, 1).bmI();
    }

    public void b(boolean z, String str, d dVar) {
        if (z) {
            BdToast.a(this.iTn.getPageContext().getPageActivity(), this.iTn.getPageContext().getString(R.string.subpb_delete_comment_succ_tip), 1).bmI();
            this.iTP.remove(dVar);
            this.iTN.setData(this.iTP);
            pW(this.hasMore);
            return;
        }
        if (TextUtils.isEmpty(str)) {
            str = this.iTn.getPageContext().getString(R.string.subpb_delete_comment_fail_tip);
        }
        BdToast.a(this.iTn.getPageContext().getPageActivity(), str, 1).bmI();
    }

    public void pX(boolean z) {
        if (this.iqS != null && this.iqS.getLayoutParams() != null) {
            ViewGroup.LayoutParams layoutParams = this.iqS.getLayoutParams();
            if (z) {
                cAK();
                layoutParams.height = l.getDimens(this.iTn.getPageContext().getPageActivity(), R.dimen.ds98);
            } else {
                layoutParams.height = l.getDimens(this.iTn.getPageContext().getPageActivity(), R.dimen.ds98) + UtilHelper.getLightStatusBarHeight();
            }
            this.iqS.setLayoutParams(layoutParams);
        }
    }

    public void cB(View view) {
        if (this.iqS != null && this.mNavigationBar != null) {
            if (this.mNavigationBar.isNavigationBarExcludeStatusbarVisible()) {
                this.mNavigationBar.showNavigationBarExcludeStatusbar(false);
                if (UtilHelper.canUseStyleImmersiveSticky()) {
                    this.iqS.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight()));
                } else if (this.gcr != null) {
                    this.gcr.removeHeaderView(this.iqS);
                }
                this.mNavigationBar.setVisibility(8);
                return;
            }
            this.mNavigationBar.showNavigationBarExcludeStatusbar(true);
            if (UtilHelper.canUseStyleImmersiveSticky()) {
                this.iqS.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + l.getDimens(this.iTn.getActivity(), R.dimen.ds98)));
            } else if (this.gcr != null) {
                this.gcr.addHeaderView(this.iqS, 0);
            }
            this.mNavigationBar.setVisibility(0);
        }
    }

    public void Km(String str) {
        this.iTL.setVisibility(8);
        this.fkl.setVisibility(0);
        this.iTJ.post(new Runnable() { // from class: com.baidu.tieba.frs.gamesubpb.view.a.3
            @Override // java.lang.Runnable
            public void run() {
                a.this.iTJ.requestFocus();
                l.showSoftKeyPad(a.this.iTn.getPageContext().getPageActivity(), a.this.iTJ);
            }
        });
        if (!TextUtils.isEmpty(str)) {
            String format = String.format(this.iTn.getPageContext().getPageActivity().getResources().getString(R.string.reply_sub_floor), str);
            this.iTJ.setText(format);
            this.iTJ.setSelection(format.length());
        }
    }

    public void zB(int i) {
        this.mProgressBar.setVisibility(i);
    }

    public View cpI() {
        return this.iqS;
    }

    public View getRootView() {
        return this.mRootView;
    }

    public ListView getListView() {
        return this.gcr;
    }

    public TextView cAL() {
        return this.iTL;
    }

    public NavigationBar bQh() {
        return this.mNavigationBar;
    }

    public void e(com.baidu.tieba.frs.gamesubpb.c cVar) {
        this.iSX = cVar;
    }

    public void b(BdListView.e eVar) {
        this.gcr.setOnSrollToBottomListener(eVar);
    }

    public void onChangeSkinType(int i) {
        this.iTn.getLayoutMode().setNightMode(i == 1);
        this.iTn.getLayoutMode().onModeChanged(this.mRootView);
        ap.setBackgroundColor(this.mRootView, R.color.cp_bg_line_d);
        this.mNavigationBar.onChangeSkinType(this.iTn.getPageContext(), i);
        this.iTH.changeSkin(i);
        ap.setViewTextColor(this.iTL, (int) R.color.cp_cont_e);
        this.iTL.setAlpha(0.95f);
        ap.setBackgroundResource(this.iTL, R.drawable.pb_ecomm_comment_bg);
        ap.setViewTextColor(this.iTM, (int) R.color.cp_cont_d);
        ap.setBackgroundResource(this.fkl, R.drawable.pb_ecomm_comment_bg);
        ap.setViewTextColor(this.iTJ, (int) R.color.cp_cont_f);
        this.iTJ.setHintTextColor(ap.getColor(R.color.cp_cont_e));
        ap.setViewTextColor(this.iTK, (int) R.color.game_sub_pb_send_txt_color);
    }

    public void onDestroy() {
        if (this.globalListener != null) {
            this.iTn.getPageContext().getPageActivity().getWindow().getDecorView().getViewTreeObserver().removeGlobalOnLayoutListener(this.globalListener);
        }
    }
}
