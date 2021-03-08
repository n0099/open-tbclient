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
    private View.OnClickListener bdi;
    private LinearLayout fFC;
    private c fxj = new c(new c.a() { // from class: com.baidu.tieba.frs.gamesubpb.view.a.1
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
    private BdTypeListView gAY;
    private long gHy;
    private ViewTreeObserver.OnGlobalLayoutListener globalListener;
    private boolean hasMore;
    private View iXG;
    private com.baidu.tieba.frs.gamesubpb.c jCD;
    private String jCH;
    private FrsGameSubPbActivity jCT;
    private e jDn;
    private FrameLayout jDo;
    private EditText jDp;
    private TextView jDq;
    private TextView jDr;
    private TextView jDs;
    private b jDt;
    private com.baidu.tieba.frs.gamesubpb.model.b jDu;
    private List<n> jDv;
    private String jDw;
    private View mBack;
    private boolean mIsKeyboardOpen;
    private NavigationBar mNavigationBar;
    private ProgressBar mProgressBar;
    private RelativeLayout mRootView;

    public a(FrsGameSubPbActivity frsGameSubPbActivity, View.OnClickListener onClickListener, String str) {
        this.jCT = frsGameSubPbActivity;
        this.bdi = onClickListener;
        this.jCH = str;
        this.mRootView = (RelativeLayout) LayoutInflater.from(frsGameSubPbActivity.getPageContext().getPageActivity()).inflate(R.layout.frs_game_sub_pb_activity, (ViewGroup) null);
        this.gAY = (BdTypeListView) this.mRootView.findViewById(R.id.new_sub_pb_list);
        this.gAY.setOnTouchListener(this.fxj);
        this.gAY.setOnScrollListener(new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.frs.gamesubpb.view.a.4
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
                if (i != 0) {
                    l.hideSoftKeyPad(a.this.jCT.getPageContext().getPageActivity(), a.this.jDp);
                }
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            }
        });
        this.jDn = new e(this.jCT.getPageContext());
        this.iXG = BdListViewHelper.a(this.jCT.getActivity(), this.gAY, BdListViewHelper.HeadType.DEFAULT);
        this.jDr = (TextView) this.mRootView.findViewById(R.id.subpb_editor_tool_comment_reply_text);
        this.jDr.setOnClickListener(this.bdi);
        this.jDs = (TextView) this.mRootView.findViewById(R.id.no_reply_list_view);
        this.jDo = (FrameLayout) this.mRootView.findViewById(R.id.bottom_view);
        this.fFC = (LinearLayout) this.mRootView.findViewById(R.id.subpb_editor_tool_comment_input_container);
        this.jDp = (EditText) this.mRootView.findViewById(R.id.subpb_editor_tool_comment_input_edit);
        this.jDq = (TextView) this.mRootView.findViewById(R.id.subpb_editor_tool_comment_send_tv);
        this.jDq.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.gamesubpb.view.a.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.KT(a.this.jDp.getText().toString());
            }
        });
        this.mProgressBar = (ProgressBar) this.mRootView.findViewById(R.id.progressBar);
        cIG();
        this.jDt = new b(this.jCT.getPageContext(), this.gAY);
        this.jDt.setClickListener(new a.InterfaceC0737a() { // from class: com.baidu.tieba.frs.gamesubpb.view.a.6
            @Override // com.baidu.tieba.frs.gamesubpb.a.InterfaceC0737a
            public void a(d dVar) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonPolymericActivityConfig(a.this.jCT.getPageContext().getPageActivity()).createNormalConfig(Long.valueOf(dVar.userId).longValue(), String.valueOf(a.this.gHy).equals(dVar.userId), false)));
            }

            @Override // com.baidu.tieba.frs.gamesubpb.a.InterfaceC0737a
            public void b(d dVar) {
                if (dVar != null) {
                    a.this.d(dVar);
                }
            }

            @Override // com.baidu.tieba.frs.gamesubpb.a.InterfaceC0737a
            public void c(d dVar) {
                if (a.this.jCD != null) {
                    a.this.jCD.cIz();
                }
                if (dVar == null) {
                    a.this.KU(null);
                    a.this.cII();
                    return;
                }
                a.this.KU(dVar.userName);
                a.this.jDw = dVar.userId;
            }
        });
        zQ(140);
        cIH();
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        this.jDv = new ArrayList();
        this.gHy = com.baidu.adp.lib.f.b.toLong(TbadkCoreApplication.getCurrentAccount(), 0L);
    }

    private void cIG() {
        this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(R.id.view_navigation_bar);
        this.mBack = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        ImageView backImageView = this.mNavigationBar.getBackImageView();
        if (backImageView != null && (backImageView.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.mBack.getLayoutParams();
            int dimens = l.getDimens(this.jCT.getPageContext().getPageActivity(), R.dimen.ds30);
            layoutParams.height = dimens;
            layoutParams.width = dimens;
            backImageView.setLayoutParams(layoutParams);
        }
        if (this.mBack != null && (this.mBack.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.mBack.getLayoutParams();
            layoutParams2.width = -2;
            layoutParams2.height = -1;
            this.mBack.setPadding(l.getDimens(this.jCT.getPageContext().getPageActivity(), R.dimen.ds32), this.mBack.getPaddingTop(), this.mBack.getPaddingRight(), this.mBack.getPaddingBottom());
            this.mBack.setLayoutParams(layoutParams2);
        }
        if (this.mNavigationBar.getBackImageView() != null) {
            SvgManager.bsU().a(this.mNavigationBar.getBackImageView(), R.drawable.ic_icon_pure_topbar_return40_svg, R.color.CAM_X0106, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
    }

    private void cIH() {
        this.globalListener = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tieba.frs.gamesubpb.view.a.7
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                Rect rect = new Rect();
                a.this.jCT.getPageContext().getPageActivity().getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
                int statusBarHeight = l.getStatusBarHeight(a.this.jCT.getPageContext().getPageActivity());
                int[] screenDimensions = l.getScreenDimensions(a.this.jCT.getPageContext().getPageActivity());
                if (screenDimensions[1] - rect.bottom > screenDimensions[1] / 4 && !a.this.mIsKeyboardOpen) {
                    a.this.mIsKeyboardOpen = true;
                    a.this.onKeyboardVisibilityChanged(true);
                } else if (screenDimensions[1] - rect.height() == statusBarHeight && a.this.mIsKeyboardOpen) {
                    a.this.mIsKeyboardOpen = false;
                    a.this.onKeyboardVisibilityChanged(false);
                }
            }
        };
        this.jCT.getPageContext().getPageActivity().getWindow().getDecorView().getViewTreeObserver().addOnGlobalLayoutListener(this.globalListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(final d dVar) {
        final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.jCT.getPageContext().getPageActivity());
        aVar.AA(null);
        aVar.ny(R.string.del_post_confirm);
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
        aVar.b(this.jCT.getPageContext()).bqz();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(d dVar) {
        HttpMessage httpMessage = new HttpMessage(1003381);
        httpMessage.addParam("user_id", this.gHy);
        httpMessage.addParam("main_tower_id", dVar.jDj);
        httpMessage.addParam("id", dVar.id);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void KT(String str) {
        zR(0);
        HttpMessage httpMessage = new HttpMessage(1003380);
        httpMessage.addParam("user_id", this.gHy);
        httpMessage.addParam("reply_user_id", this.jDw);
        httpMessage.addParam("content", str);
        httpMessage.addParam("main_tower_id", this.jCH);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cII() {
        this.jDw = this.jDu != null ? this.jDu.userId : null;
    }

    private void cIJ() {
        if (!y.isEmpty(this.jDv)) {
            this.mNavigationBar.setCenterTextTitle(String.format(this.jCT.getResources().getString(R.string.subpb_floor_reply_count), au.numFormatOver10000(this.jDv.size())));
        } else {
            this.mNavigationBar.setCenterTextTitle(this.jCT.getResources().getString(R.string.reply));
        }
    }

    private void zQ(final int i) {
        this.jDp.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.frs.gamesubpb.view.a.10
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                if (!TextUtils.isEmpty(charSequence)) {
                    a.this.jDq.setEnabled(true);
                    String charSequence2 = charSequence.toString();
                    if (!StringUtils.isNull(charSequence2) && ag.getTextLength(charSequence2) > i) {
                        String subString = ag.subString(charSequence2, 0, i - 1);
                        a.this.jDp.setText(subString);
                        a.this.jDp.setSelection(a.this.jDp.getText().length());
                        UtilHelper.showToast(a.this.jCT.getPageContext().getPageActivity().getApplication(), a.this.jCT.getPageContext().getPageActivity().getResources().getString(R.string.edit_text_over_limit_tip, Integer.valueOf(subString.length())));
                        return;
                    }
                    return;
                }
                a.this.cII();
                a.this.jDq.setEnabled(false);
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
            }
        });
    }

    private void cIK() {
        if (this.mNavigationBar.getBackImageView() != null) {
            SvgManager.bsU().a(this.mNavigationBar.getBackImageView(), R.drawable.ic_icon_pure_topbar_return40_svg, R.color.CAM_X0106, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rm(final boolean z) {
        if (this.gAY != null) {
            if (!z) {
                this.gAY.setEnabled(z);
            } else {
                this.gAY.postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.gamesubpb.view.a.11
                    @Override // java.lang.Runnable
                    public void run() {
                        a.this.gAY.setEnabled(z);
                    }
                }, 10L);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onKeyboardVisibilityChanged(boolean z) {
        if (z) {
            Rect rect = new Rect();
            this.fFC.getWindowVisibleDisplayFrame(rect);
            this.jDo.scrollTo(this.jDo.getScrollX(), (l.getScreenDimensions(this.jCT.getPageContext().getPageActivity())[1] - rect.bottom) - (MenuKeyUtils.hasSmartBar() ? l.dip2px(this.jCT.getPageContext().getPageActivity(), 48.0f) : 0));
            return;
        }
        this.jDo.setScrollY(0);
    }

    private void rn(boolean z) {
        if (y.isEmpty(this.jDv)) {
            this.gAY.setNextPage(null);
            this.jDs.setVisibility(0);
        } else {
            this.gAY.setNextPage(this.jDn);
            this.jDs.setVisibility(8);
            if (z) {
                this.jDn.startLoadData();
            } else {
                this.jDn.endLoadData();
            }
        }
        cIJ();
    }

    public void a(boolean z, com.baidu.tieba.frs.gamesubpb.model.b bVar, List<n> list) {
        this.hasMore = z;
        this.jDu = bVar;
        cII();
        if (y.isEmpty(list)) {
            rn(z);
            return;
        }
        this.jDv.clear();
        this.jDv.addAll(list);
        this.jDs.setVisibility(8);
        this.gAY.setNextPage(this.jDn);
        this.jDt.setData(list);
        cIK();
        this.jDr.setVisibility(0);
        this.jDr.setText(R.string.say_your_point);
        rn(z);
    }

    public void a(boolean z, String str, d dVar) {
        zR(8);
        if (z && dVar != null) {
            BdToast.b(this.jCT.getPageContext().getPageActivity(), this.jCT.getPageContext().getString(R.string.subpb_add_comment_succ_tip), 1).bqF();
            this.jDp.setText((CharSequence) null);
            this.jDv.add(dVar);
            this.jDt.setData(this.jDv);
            rn(this.hasMore);
            this.jDp.post(new Runnable() { // from class: com.baidu.tieba.frs.gamesubpb.view.a.2
                @Override // java.lang.Runnable
                public void run() {
                    a.this.jDp.requestFocus();
                    l.hideSoftKeyPad(a.this.jCT.getPageContext().getPageActivity(), a.this.jDp);
                }
            });
            return;
        }
        if (TextUtils.isEmpty(str)) {
            str = this.jCT.getPageContext().getString(R.string.subpb_add_comment_fail_tip);
        }
        BdToast.b(this.jCT.getPageContext().getPageActivity(), str, 1).bqF();
    }

    public void b(boolean z, String str, d dVar) {
        if (z) {
            BdToast.b(this.jCT.getPageContext().getPageActivity(), this.jCT.getPageContext().getString(R.string.subpb_delete_comment_succ_tip), 1).bqF();
            this.jDv.remove(dVar);
            this.jDt.setData(this.jDv);
            rn(this.hasMore);
            return;
        }
        if (TextUtils.isEmpty(str)) {
            str = this.jCT.getPageContext().getString(R.string.subpb_delete_comment_fail_tip);
        }
        BdToast.b(this.jCT.getPageContext().getPageActivity(), str, 1).bqF();
    }

    public void ro(boolean z) {
        if (this.iXG != null && this.iXG.getLayoutParams() != null) {
            ViewGroup.LayoutParams layoutParams = this.iXG.getLayoutParams();
            if (z) {
                cIK();
                layoutParams.height = l.getDimens(this.jCT.getPageContext().getPageActivity(), R.dimen.ds98);
            } else {
                layoutParams.height = l.getDimens(this.jCT.getPageContext().getPageActivity(), R.dimen.ds98) + UtilHelper.getLightStatusBarHeight();
            }
            this.iXG.setLayoutParams(layoutParams);
        }
    }

    public void cZ(View view) {
        if (this.iXG != null && this.mNavigationBar != null) {
            if (this.mNavigationBar.isNavigationBarExcludeStatusbarVisible()) {
                this.mNavigationBar.showNavigationBarExcludeStatusbar(false);
                if (UtilHelper.canUseStyleImmersiveSticky()) {
                    this.iXG.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight()));
                } else if (this.gAY != null) {
                    this.gAY.removeHeaderView(this.iXG);
                }
                this.mNavigationBar.setVisibility(8);
                return;
            }
            this.mNavigationBar.showNavigationBarExcludeStatusbar(true);
            if (UtilHelper.canUseStyleImmersiveSticky()) {
                this.iXG.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + l.getDimens(this.jCT.getActivity(), R.dimen.ds98)));
            } else if (this.gAY != null) {
                this.gAY.addHeaderView(this.iXG, 0);
            }
            this.mNavigationBar.setVisibility(0);
        }
    }

    public void KU(String str) {
        this.jDr.setVisibility(8);
        this.fFC.setVisibility(0);
        this.jDp.post(new Runnable() { // from class: com.baidu.tieba.frs.gamesubpb.view.a.3
            @Override // java.lang.Runnable
            public void run() {
                a.this.jDp.requestFocus();
                l.showSoftKeyPad(a.this.jCT.getPageContext().getPageActivity(), a.this.jDp);
            }
        });
        if (!TextUtils.isEmpty(str)) {
            String format = String.format(this.jCT.getPageContext().getPageActivity().getResources().getString(R.string.reply_sub_floor), str);
            this.jDp.setText(format);
            this.jDp.setSelection(format.length());
        }
    }

    public void zR(int i) {
        this.mProgressBar.setVisibility(i);
    }

    public View cwD() {
        return this.iXG;
    }

    public View getRootView() {
        return this.mRootView;
    }

    public ListView getListView() {
        return this.gAY;
    }

    public TextView cIL() {
        return this.jDr;
    }

    public NavigationBar bVq() {
        return this.mNavigationBar;
    }

    public void e(com.baidu.tieba.frs.gamesubpb.c cVar) {
        this.jCD = cVar;
    }

    public void b(BdListView.e eVar) {
        this.gAY.setOnSrollToBottomListener(eVar);
    }

    public void onChangeSkinType(int i) {
        this.jCT.getLayoutMode().setNightMode(i == 1);
        this.jCT.getLayoutMode().onModeChanged(this.mRootView);
        ap.setBackgroundColor(this.mRootView, R.color.CAM_X0201);
        this.mNavigationBar.onChangeSkinType(this.jCT.getPageContext(), i);
        this.jDn.changeSkin(i);
        ap.setViewTextColor(this.jDr, R.color.CAM_X0110);
        this.jDr.setAlpha(0.95f);
        ap.setBackgroundResource(this.jDr, R.drawable.pb_ecomm_comment_bg);
        ap.setViewTextColor(this.jDs, R.color.CAM_X0109);
        ap.setBackgroundResource(this.fFC, R.drawable.pb_ecomm_comment_bg);
        ap.setViewTextColor(this.jDp, R.color.CAM_X0106);
        this.jDp.setHintTextColor(ap.getColor(R.color.CAM_X0110));
        ap.setViewTextColor(this.jDq, R.color.game_sub_pb_send_txt_color);
    }

    public void onDestroy() {
        if (this.globalListener != null) {
            this.jCT.getPageContext().getPageActivity().getWindow().getDecorView().getViewTreeObserver().removeGlobalOnLayoutListener(this.globalListener);
        }
    }
}
