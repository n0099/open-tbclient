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
import com.baidu.adp.widget.ListView.n;
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
import com.baidu.tbadk.util.ag;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.gamesubpb.FrsGameSubPbActivity;
import com.baidu.tieba.frs.gamesubpb.a;
import com.baidu.tieba.frs.gamesubpb.b;
import com.baidu.tieba.frs.gamesubpb.model.d;
import com.baidu.tieba.frs.gamesubpb.model.e;
import com.baidu.tieba.pb.a.c;
import com.compatible.menukey.MenuKeyUtils;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class a {
    private View.OnClickListener bbI;
    private LinearLayout fEd;
    private c fvK = new c(new c.a() { // from class: com.baidu.tieba.frs.gamesubpb.view.a.1
        @Override // com.baidu.tieba.pb.a.c.a
        public boolean onDoubleTap(View view, MotionEvent motionEvent) {
            a.this.rm(false);
            a.this.cZ(view);
            a.this.rm(true);
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
    private long gFP;
    private ViewTreeObserver.OnGlobalLayoutListener globalListener;
    private BdTypeListView gzp;
    private boolean hasMore;
    private View iVX;
    private com.baidu.tieba.frs.gamesubpb.c jAU;
    private String jAY;
    private e jBE;
    private FrameLayout jBF;
    private EditText jBG;
    private TextView jBH;
    private TextView jBI;
    private TextView jBJ;
    private b jBK;
    private com.baidu.tieba.frs.gamesubpb.model.b jBL;
    private List<n> jBM;
    private String jBN;
    private FrsGameSubPbActivity jBk;
    private View mBack;
    private boolean mIsKeyboardOpen;
    private NavigationBar mNavigationBar;
    private ProgressBar mProgressBar;
    private RelativeLayout mRootView;

    public a(FrsGameSubPbActivity frsGameSubPbActivity, View.OnClickListener onClickListener, String str) {
        this.jBk = frsGameSubPbActivity;
        this.bbI = onClickListener;
        this.jAY = str;
        this.mRootView = (RelativeLayout) LayoutInflater.from(frsGameSubPbActivity.getPageContext().getPageActivity()).inflate(R.layout.frs_game_sub_pb_activity, (ViewGroup) null);
        this.gzp = (BdTypeListView) this.mRootView.findViewById(R.id.new_sub_pb_list);
        this.gzp.setOnTouchListener(this.fvK);
        this.gzp.setOnScrollListener(new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.frs.gamesubpb.view.a.4
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
                if (i != 0) {
                    l.hideSoftKeyPad(a.this.jBk.getPageContext().getPageActivity(), a.this.jBG);
                }
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            }
        });
        this.jBE = new e(this.jBk.getPageContext());
        this.iVX = BdListViewHelper.a(this.jBk.getActivity(), this.gzp, BdListViewHelper.HeadType.DEFAULT);
        this.jBI = (TextView) this.mRootView.findViewById(R.id.subpb_editor_tool_comment_reply_text);
        this.jBI.setOnClickListener(this.bbI);
        this.jBJ = (TextView) this.mRootView.findViewById(R.id.no_reply_list_view);
        this.jBF = (FrameLayout) this.mRootView.findViewById(R.id.bottom_view);
        this.fEd = (LinearLayout) this.mRootView.findViewById(R.id.subpb_editor_tool_comment_input_container);
        this.jBG = (EditText) this.mRootView.findViewById(R.id.subpb_editor_tool_comment_input_edit);
        this.jBH = (TextView) this.mRootView.findViewById(R.id.subpb_editor_tool_comment_send_tv);
        this.jBH.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.gamesubpb.view.a.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.KK(a.this.jBG.getText().toString());
            }
        });
        this.mProgressBar = (ProgressBar) this.mRootView.findViewById(R.id.progressBar);
        cIA();
        this.jBK = new b(this.jBk.getPageContext(), this.gzp);
        this.jBK.setClickListener(new a.InterfaceC0731a() { // from class: com.baidu.tieba.frs.gamesubpb.view.a.6
            @Override // com.baidu.tieba.frs.gamesubpb.a.InterfaceC0731a
            public void a(d dVar) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonPolymericActivityConfig(a.this.jBk.getPageContext().getPageActivity()).createNormalConfig(Long.valueOf(dVar.userId).longValue(), String.valueOf(a.this.gFP).equals(dVar.userId), false)));
            }

            @Override // com.baidu.tieba.frs.gamesubpb.a.InterfaceC0731a
            public void b(d dVar) {
                if (dVar != null) {
                    a.this.d(dVar);
                }
            }

            @Override // com.baidu.tieba.frs.gamesubpb.a.InterfaceC0731a
            public void c(d dVar) {
                if (a.this.jAU != null) {
                    a.this.jAU.cIt();
                }
                if (dVar == null) {
                    a.this.KL(null);
                    a.this.cIC();
                    return;
                }
                a.this.KL(dVar.userName);
                a.this.jBN = dVar.userId;
            }
        });
        zP(140);
        cIB();
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        this.jBM = new ArrayList();
        this.gFP = com.baidu.adp.lib.f.b.toLong(TbadkCoreApplication.getCurrentAccount(), 0L);
    }

    private void cIA() {
        this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(R.id.view_navigation_bar);
        this.mBack = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        ImageView backImageView = this.mNavigationBar.getBackImageView();
        if (backImageView != null && (backImageView.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.mBack.getLayoutParams();
            int dimens = l.getDimens(this.jBk.getPageContext().getPageActivity(), R.dimen.ds30);
            layoutParams.height = dimens;
            layoutParams.width = dimens;
            backImageView.setLayoutParams(layoutParams);
        }
        if (this.mBack != null && (this.mBack.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.mBack.getLayoutParams();
            layoutParams2.width = -2;
            layoutParams2.height = -1;
            this.mBack.setPadding(l.getDimens(this.jBk.getPageContext().getPageActivity(), R.dimen.ds32), this.mBack.getPaddingTop(), this.mBack.getPaddingRight(), this.mBack.getPaddingBottom());
            this.mBack.setLayoutParams(layoutParams2);
        }
        if (this.mNavigationBar.getBackImageView() != null) {
            SvgManager.bsR().a(this.mNavigationBar.getBackImageView(), R.drawable.ic_icon_pure_topbar_return40_svg, R.color.CAM_X0106, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
    }

    private void cIB() {
        this.globalListener = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tieba.frs.gamesubpb.view.a.7
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                Rect rect = new Rect();
                a.this.jBk.getPageContext().getPageActivity().getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
                int statusBarHeight = l.getStatusBarHeight(a.this.jBk.getPageContext().getPageActivity());
                int[] screenDimensions = l.getScreenDimensions(a.this.jBk.getPageContext().getPageActivity());
                if (screenDimensions[1] - rect.bottom > screenDimensions[1] / 4 && !a.this.mIsKeyboardOpen) {
                    a.this.mIsKeyboardOpen = true;
                    a.this.onKeyboardVisibilityChanged(true);
                } else if (screenDimensions[1] - rect.height() == statusBarHeight && a.this.mIsKeyboardOpen) {
                    a.this.mIsKeyboardOpen = false;
                    a.this.onKeyboardVisibilityChanged(false);
                }
            }
        };
        this.jBk.getPageContext().getPageActivity().getWindow().getDecorView().getViewTreeObserver().addOnGlobalLayoutListener(this.globalListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(final d dVar) {
        final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.jBk.getPageContext().getPageActivity());
        aVar.At(null);
        aVar.nx(R.string.del_post_confirm);
        aVar.jG(true);
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
        aVar.b(this.jBk.getPageContext()).bqx();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(d dVar) {
        HttpMessage httpMessage = new HttpMessage(1003381);
        httpMessage.addParam("user_id", this.gFP);
        httpMessage.addParam("main_tower_id", dVar.jBA);
        httpMessage.addParam("id", dVar.id);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void KK(String str) {
        zQ(0);
        HttpMessage httpMessage = new HttpMessage(1003380);
        httpMessage.addParam("user_id", this.gFP);
        httpMessage.addParam("reply_user_id", this.jBN);
        httpMessage.addParam("content", str);
        httpMessage.addParam("main_tower_id", this.jAY);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cIC() {
        this.jBN = this.jBL != null ? this.jBL.userId : null;
    }

    private void cID() {
        if (!y.isEmpty(this.jBM)) {
            this.mNavigationBar.setCenterTextTitle(String.format(this.jBk.getResources().getString(R.string.subpb_floor_reply_count), au.numFormatOver10000(this.jBM.size())));
        } else {
            this.mNavigationBar.setCenterTextTitle(this.jBk.getResources().getString(R.string.reply));
        }
    }

    private void zP(final int i) {
        this.jBG.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.frs.gamesubpb.view.a.10
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                if (!TextUtils.isEmpty(charSequence)) {
                    a.this.jBH.setEnabled(true);
                    String charSequence2 = charSequence.toString();
                    if (!StringUtils.isNull(charSequence2) && ag.getTextLength(charSequence2) > i) {
                        String subString = ag.subString(charSequence2, 0, i - 1);
                        a.this.jBG.setText(subString);
                        a.this.jBG.setSelection(a.this.jBG.getText().length());
                        UtilHelper.showToast(a.this.jBk.getPageContext().getPageActivity().getApplication(), a.this.jBk.getPageContext().getPageActivity().getResources().getString(R.string.edit_text_over_limit_tip, Integer.valueOf(subString.length())));
                        return;
                    }
                    return;
                }
                a.this.cIC();
                a.this.jBH.setEnabled(false);
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
            }
        });
    }

    private void cIE() {
        if (this.mNavigationBar.getBackImageView() != null) {
            SvgManager.bsR().a(this.mNavigationBar.getBackImageView(), R.drawable.ic_icon_pure_topbar_return40_svg, R.color.CAM_X0106, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rm(final boolean z) {
        if (this.gzp != null) {
            if (!z) {
                this.gzp.setEnabled(z);
            } else {
                this.gzp.postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.gamesubpb.view.a.11
                    @Override // java.lang.Runnable
                    public void run() {
                        a.this.gzp.setEnabled(z);
                    }
                }, 10L);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onKeyboardVisibilityChanged(boolean z) {
        if (z) {
            Rect rect = new Rect();
            this.fEd.getWindowVisibleDisplayFrame(rect);
            this.jBF.scrollTo(this.jBF.getScrollX(), (l.getScreenDimensions(this.jBk.getPageContext().getPageActivity())[1] - rect.bottom) - (MenuKeyUtils.hasSmartBar() ? l.dip2px(this.jBk.getPageContext().getPageActivity(), 48.0f) : 0));
            return;
        }
        this.jBF.setScrollY(0);
    }

    private void rn(boolean z) {
        if (y.isEmpty(this.jBM)) {
            this.gzp.setNextPage(null);
            this.jBJ.setVisibility(0);
        } else {
            this.gzp.setNextPage(this.jBE);
            this.jBJ.setVisibility(8);
            if (z) {
                this.jBE.startLoadData();
            } else {
                this.jBE.endLoadData();
            }
        }
        cID();
    }

    public void a(boolean z, com.baidu.tieba.frs.gamesubpb.model.b bVar, List<n> list) {
        this.hasMore = z;
        this.jBL = bVar;
        cIC();
        if (y.isEmpty(list)) {
            rn(z);
            return;
        }
        this.jBM.clear();
        this.jBM.addAll(list);
        this.jBJ.setVisibility(8);
        this.gzp.setNextPage(this.jBE);
        this.jBK.setData(list);
        cIE();
        this.jBI.setVisibility(0);
        this.jBI.setText(R.string.say_your_point);
        rn(z);
    }

    public void a(boolean z, String str, d dVar) {
        zQ(8);
        if (z && dVar != null) {
            BdToast.b(this.jBk.getPageContext().getPageActivity(), this.jBk.getPageContext().getString(R.string.subpb_add_comment_succ_tip), 1).bqD();
            this.jBG.setText((CharSequence) null);
            this.jBM.add(dVar);
            this.jBK.setData(this.jBM);
            rn(this.hasMore);
            this.jBG.post(new Runnable() { // from class: com.baidu.tieba.frs.gamesubpb.view.a.2
                @Override // java.lang.Runnable
                public void run() {
                    a.this.jBG.requestFocus();
                    l.hideSoftKeyPad(a.this.jBk.getPageContext().getPageActivity(), a.this.jBG);
                }
            });
            return;
        }
        if (TextUtils.isEmpty(str)) {
            str = this.jBk.getPageContext().getString(R.string.subpb_add_comment_fail_tip);
        }
        BdToast.b(this.jBk.getPageContext().getPageActivity(), str, 1).bqD();
    }

    public void b(boolean z, String str, d dVar) {
        if (z) {
            BdToast.b(this.jBk.getPageContext().getPageActivity(), this.jBk.getPageContext().getString(R.string.subpb_delete_comment_succ_tip), 1).bqD();
            this.jBM.remove(dVar);
            this.jBK.setData(this.jBM);
            rn(this.hasMore);
            return;
        }
        if (TextUtils.isEmpty(str)) {
            str = this.jBk.getPageContext().getString(R.string.subpb_delete_comment_fail_tip);
        }
        BdToast.b(this.jBk.getPageContext().getPageActivity(), str, 1).bqD();
    }

    public void ro(boolean z) {
        if (this.iVX != null && this.iVX.getLayoutParams() != null) {
            ViewGroup.LayoutParams layoutParams = this.iVX.getLayoutParams();
            if (z) {
                cIE();
                layoutParams.height = l.getDimens(this.jBk.getPageContext().getPageActivity(), R.dimen.ds98);
            } else {
                layoutParams.height = l.getDimens(this.jBk.getPageContext().getPageActivity(), R.dimen.ds98) + UtilHelper.getLightStatusBarHeight();
            }
            this.iVX.setLayoutParams(layoutParams);
        }
    }

    public void cZ(View view) {
        if (this.iVX != null && this.mNavigationBar != null) {
            if (this.mNavigationBar.isNavigationBarExcludeStatusbarVisible()) {
                this.mNavigationBar.showNavigationBarExcludeStatusbar(false);
                if (UtilHelper.canUseStyleImmersiveSticky()) {
                    this.iVX.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight()));
                } else if (this.gzp != null) {
                    this.gzp.removeHeaderView(this.iVX);
                }
                this.mNavigationBar.setVisibility(8);
                return;
            }
            this.mNavigationBar.showNavigationBarExcludeStatusbar(true);
            if (UtilHelper.canUseStyleImmersiveSticky()) {
                this.iVX.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + l.getDimens(this.jBk.getActivity(), R.dimen.ds98)));
            } else if (this.gzp != null) {
                this.gzp.addHeaderView(this.iVX, 0);
            }
            this.mNavigationBar.setVisibility(0);
        }
    }

    public void KL(String str) {
        this.jBI.setVisibility(8);
        this.fEd.setVisibility(0);
        this.jBG.post(new Runnable() { // from class: com.baidu.tieba.frs.gamesubpb.view.a.3
            @Override // java.lang.Runnable
            public void run() {
                a.this.jBG.requestFocus();
                l.showSoftKeyPad(a.this.jBk.getPageContext().getPageActivity(), a.this.jBG);
            }
        });
        if (!TextUtils.isEmpty(str)) {
            String format = String.format(this.jBk.getPageContext().getPageActivity().getResources().getString(R.string.reply_sub_floor), str);
            this.jBG.setText(format);
            this.jBG.setSelection(format.length());
        }
    }

    public void zQ(int i) {
        this.mProgressBar.setVisibility(i);
    }

    public View cwx() {
        return this.iVX;
    }

    public View getRootView() {
        return this.mRootView;
    }

    public ListView getListView() {
        return this.gzp;
    }

    public TextView cIF() {
        return this.jBI;
    }

    public NavigationBar bVk() {
        return this.mNavigationBar;
    }

    public void e(com.baidu.tieba.frs.gamesubpb.c cVar) {
        this.jAU = cVar;
    }

    public void b(BdListView.e eVar) {
        this.gzp.setOnSrollToBottomListener(eVar);
    }

    public void onChangeSkinType(int i) {
        this.jBk.getLayoutMode().setNightMode(i == 1);
        this.jBk.getLayoutMode().onModeChanged(this.mRootView);
        ap.setBackgroundColor(this.mRootView, R.color.CAM_X0201);
        this.mNavigationBar.onChangeSkinType(this.jBk.getPageContext(), i);
        this.jBE.changeSkin(i);
        ap.setViewTextColor(this.jBI, R.color.CAM_X0110);
        this.jBI.setAlpha(0.95f);
        ap.setBackgroundResource(this.jBI, R.drawable.pb_ecomm_comment_bg);
        ap.setViewTextColor(this.jBJ, R.color.CAM_X0109);
        ap.setBackgroundResource(this.fEd, R.drawable.pb_ecomm_comment_bg);
        ap.setViewTextColor(this.jBG, R.color.CAM_X0106);
        this.jBG.setHintTextColor(ap.getColor(R.color.CAM_X0110));
        ap.setViewTextColor(this.jBH, R.color.game_sub_pb_send_txt_color);
    }

    public void onDestroy() {
        if (this.globalListener != null) {
            this.jBk.getPageContext().getPageActivity().getWindow().getDecorView().getViewTreeObserver().removeGlobalOnLayoutListener(this.globalListener);
        }
    }
}
