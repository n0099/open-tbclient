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
/* loaded from: classes22.dex */
public class a {
    private View.OnClickListener bbH;
    private c fos = new c(new c.a() { // from class: com.baidu.tieba.frs.gamesubpb.view.a.1
        @Override // com.baidu.tieba.pb.a.c.a
        public boolean onDoubleTap(View view, MotionEvent motionEvent) {
            a.this.qI(false);
            a.this.cR(view);
            a.this.qI(true);
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
    private LinearLayout fwP;
    private ViewTreeObserver.OnGlobalLayoutListener globalListener;
    private BdTypeListView gpX;
    private long gws;
    private boolean hasMore;
    private View iIw;
    private e jnQ;
    private FrameLayout jnR;
    private EditText jnS;
    private TextView jnT;
    private TextView jnU;
    private TextView jnV;
    private com.baidu.tieba.frs.gamesubpb.b jnW;
    private com.baidu.tieba.frs.gamesubpb.model.b jnX;
    private List<q> jnY;
    private String jnZ;
    private com.baidu.tieba.frs.gamesubpb.c jng;
    private String jnk;
    private FrsGameSubPbActivity jnw;
    private View mBack;
    private boolean mIsKeyboardOpen;
    private NavigationBar mNavigationBar;
    private ProgressBar mProgressBar;
    private RelativeLayout mRootView;

    public a(FrsGameSubPbActivity frsGameSubPbActivity, View.OnClickListener onClickListener, String str) {
        this.jnw = frsGameSubPbActivity;
        this.bbH = onClickListener;
        this.jnk = str;
        this.mRootView = (RelativeLayout) LayoutInflater.from(frsGameSubPbActivity.getPageContext().getPageActivity()).inflate(R.layout.frs_game_sub_pb_activity, (ViewGroup) null);
        this.gpX = (BdTypeListView) this.mRootView.findViewById(R.id.new_sub_pb_list);
        this.gpX.setOnTouchListener(this.fos);
        this.gpX.setOnScrollListener(new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.frs.gamesubpb.view.a.4
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
                if (i != 0) {
                    l.hideSoftKeyPad(a.this.jnw.getPageContext().getPageActivity(), a.this.jnS);
                }
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            }
        });
        this.jnQ = new e(this.jnw.getPageContext());
        this.iIw = BdListViewHelper.a(this.jnw.getActivity(), this.gpX, BdListViewHelper.HeadType.DEFAULT);
        this.jnU = (TextView) this.mRootView.findViewById(R.id.subpb_editor_tool_comment_reply_text);
        this.jnU.setOnClickListener(this.bbH);
        this.jnV = (TextView) this.mRootView.findViewById(R.id.no_reply_list_view);
        this.jnR = (FrameLayout) this.mRootView.findViewById(R.id.bottom_view);
        this.fwP = (LinearLayout) this.mRootView.findViewById(R.id.subpb_editor_tool_comment_input_container);
        this.jnS = (EditText) this.mRootView.findViewById(R.id.subpb_editor_tool_comment_input_edit);
        this.jnT = (TextView) this.mRootView.findViewById(R.id.subpb_editor_tool_comment_send_tv);
        this.jnT.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.gamesubpb.view.a.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.Lj(a.this.jnS.getText().toString());
            }
        });
        this.mProgressBar = (ProgressBar) this.mRootView.findViewById(R.id.progressBar);
        cHW();
        this.jnW = new com.baidu.tieba.frs.gamesubpb.b(this.jnw.getPageContext(), this.gpX);
        this.jnW.setClickListener(new a.InterfaceC0747a() { // from class: com.baidu.tieba.frs.gamesubpb.view.a.6
            @Override // com.baidu.tieba.frs.gamesubpb.a.InterfaceC0747a
            public void a(d dVar) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonPolymericActivityConfig(a.this.jnw.getPageContext().getPageActivity()).createNormalConfig(Long.valueOf(dVar.userId).longValue(), String.valueOf(a.this.gws).equals(dVar.userId), false)));
            }

            @Override // com.baidu.tieba.frs.gamesubpb.a.InterfaceC0747a
            public void b(d dVar) {
                if (dVar != null) {
                    a.this.d(dVar);
                }
            }

            @Override // com.baidu.tieba.frs.gamesubpb.a.InterfaceC0747a
            public void c(d dVar) {
                if (a.this.jng != null) {
                    a.this.jng.cHP();
                }
                if (dVar == null) {
                    a.this.Lk(null);
                    a.this.cHY();
                    return;
                }
                a.this.Lk(dVar.userName);
                a.this.jnZ = dVar.userId;
            }
        });
        AZ(140);
        cHX();
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        this.jnY = new ArrayList();
        this.gws = com.baidu.adp.lib.f.b.toLong(TbadkCoreApplication.getCurrentAccount(), 0L);
    }

    private void cHW() {
        this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(R.id.view_navigation_bar);
        this.mBack = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        ImageView backImageView = this.mNavigationBar.getBackImageView();
        if (backImageView != null && (backImageView.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.mBack.getLayoutParams();
            int dimens = l.getDimens(this.jnw.getPageContext().getPageActivity(), R.dimen.ds30);
            layoutParams.height = dimens;
            layoutParams.width = dimens;
            backImageView.setLayoutParams(layoutParams);
        }
        if (this.mBack != null && (this.mBack.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.mBack.getLayoutParams();
            layoutParams2.width = -2;
            layoutParams2.height = -1;
            this.mBack.setPadding(l.getDimens(this.jnw.getPageContext().getPageActivity(), R.dimen.ds32), this.mBack.getPaddingTop(), this.mBack.getPaddingRight(), this.mBack.getPaddingBottom());
            this.mBack.setLayoutParams(layoutParams2);
        }
        if (this.mNavigationBar.getBackImageView() != null) {
            SvgManager.btW().a(this.mNavigationBar.getBackImageView(), R.drawable.ic_icon_pure_topbar_return40_svg, R.color.CAM_X0106, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
    }

    private void cHX() {
        this.globalListener = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tieba.frs.gamesubpb.view.a.7
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                Rect rect = new Rect();
                a.this.jnw.getPageContext().getPageActivity().getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
                int statusBarHeight = l.getStatusBarHeight(a.this.jnw.getPageContext().getPageActivity());
                int[] screenDimensions = l.getScreenDimensions(a.this.jnw.getPageContext().getPageActivity());
                if (screenDimensions[1] - rect.bottom > screenDimensions[1] / 4 && !a.this.mIsKeyboardOpen) {
                    a.this.mIsKeyboardOpen = true;
                    a.this.onKeyboardVisibilityChanged(true);
                } else if (screenDimensions[1] - rect.height() == statusBarHeight && a.this.mIsKeyboardOpen) {
                    a.this.mIsKeyboardOpen = false;
                    a.this.onKeyboardVisibilityChanged(false);
                }
            }
        };
        this.jnw.getPageContext().getPageActivity().getWindow().getDecorView().getViewTreeObserver().addOnGlobalLayoutListener(this.globalListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(final d dVar) {
        final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.jnw.getPageContext().getPageActivity());
        aVar.Bp(null);
        aVar.oQ(R.string.del_post_confirm);
        aVar.jm(true);
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
        aVar.b(this.jnw.getPageContext()).brv();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(d dVar) {
        HttpMessage httpMessage = new HttpMessage(1003381);
        httpMessage.addParam("user_id", this.gws);
        httpMessage.addParam("main_tower_id", dVar.jnM);
        httpMessage.addParam("id", dVar.id);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Lj(String str) {
        Ba(0);
        HttpMessage httpMessage = new HttpMessage(1003380);
        httpMessage.addParam("user_id", this.gws);
        httpMessage.addParam("reply_user_id", this.jnZ);
        httpMessage.addParam("content", str);
        httpMessage.addParam("main_tower_id", this.jnk);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cHY() {
        this.jnZ = this.jnX != null ? this.jnX.userId : null;
    }

    private void cHZ() {
        if (!y.isEmpty(this.jnY)) {
            this.mNavigationBar.setCenterTextTitle(String.format(this.jnw.getResources().getString(R.string.subpb_floor_reply_count), au.numFormatOver10000(this.jnY.size())));
        } else {
            this.mNavigationBar.setCenterTextTitle(this.jnw.getResources().getString(R.string.reply));
        }
    }

    private void AZ(final int i) {
        this.jnS.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.frs.gamesubpb.view.a.10
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                if (!TextUtils.isEmpty(charSequence)) {
                    a.this.jnT.setEnabled(true);
                    String charSequence2 = charSequence.toString();
                    if (!StringUtils.isNull(charSequence2) && ae.getTextLength(charSequence2) > i) {
                        String subString = ae.subString(charSequence2, 0, i - 1);
                        a.this.jnS.setText(subString);
                        a.this.jnS.setSelection(a.this.jnS.getText().length());
                        UtilHelper.showToast(a.this.jnw.getPageContext().getPageActivity().getApplication(), a.this.jnw.getPageContext().getPageActivity().getResources().getString(R.string.edit_text_over_limit_tip, Integer.valueOf(subString.length())));
                        return;
                    }
                    return;
                }
                a.this.cHY();
                a.this.jnT.setEnabled(false);
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
            }
        });
    }

    private void cIa() {
        if (this.mNavigationBar.getBackImageView() != null) {
            SvgManager.btW().a(this.mNavigationBar.getBackImageView(), R.drawable.ic_icon_pure_topbar_return40_svg, R.color.CAM_X0106, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qI(final boolean z) {
        if (this.gpX != null) {
            if (!z) {
                this.gpX.setEnabled(z);
            } else {
                this.gpX.postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.gamesubpb.view.a.11
                    @Override // java.lang.Runnable
                    public void run() {
                        a.this.gpX.setEnabled(z);
                    }
                }, 10L);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onKeyboardVisibilityChanged(boolean z) {
        if (z) {
            Rect rect = new Rect();
            this.fwP.getWindowVisibleDisplayFrame(rect);
            this.jnR.scrollTo(this.jnR.getScrollX(), (l.getScreenDimensions(this.jnw.getPageContext().getPageActivity())[1] - rect.bottom) - (MenuKeyUtils.hasSmartBar() ? l.dip2px(this.jnw.getPageContext().getPageActivity(), 48.0f) : 0));
            return;
        }
        this.jnR.setScrollY(0);
    }

    private void qJ(boolean z) {
        if (y.isEmpty(this.jnY)) {
            this.gpX.setNextPage(null);
            this.jnV.setVisibility(0);
        } else {
            this.gpX.setNextPage(this.jnQ);
            this.jnV.setVisibility(8);
            if (z) {
                this.jnQ.startLoadData();
            } else {
                this.jnQ.endLoadData();
            }
        }
        cHZ();
    }

    public void a(boolean z, com.baidu.tieba.frs.gamesubpb.model.b bVar, List<q> list) {
        this.hasMore = z;
        this.jnX = bVar;
        cHY();
        if (y.isEmpty(list)) {
            qJ(z);
            return;
        }
        this.jnY.clear();
        this.jnY.addAll(list);
        this.jnV.setVisibility(8);
        this.gpX.setNextPage(this.jnQ);
        this.jnW.setData(list);
        cIa();
        this.jnU.setVisibility(0);
        this.jnU.setText(R.string.say_your_point);
        qJ(z);
    }

    public void a(boolean z, String str, d dVar) {
        Ba(8);
        if (z && dVar != null) {
            BdToast.a(this.jnw.getPageContext().getPageActivity(), this.jnw.getPageContext().getString(R.string.subpb_add_comment_succ_tip), 1).brB();
            this.jnS.setText((CharSequence) null);
            this.jnY.add(dVar);
            this.jnW.setData(this.jnY);
            qJ(this.hasMore);
            this.jnS.post(new Runnable() { // from class: com.baidu.tieba.frs.gamesubpb.view.a.2
                @Override // java.lang.Runnable
                public void run() {
                    a.this.jnS.requestFocus();
                    l.hideSoftKeyPad(a.this.jnw.getPageContext().getPageActivity(), a.this.jnS);
                }
            });
            return;
        }
        if (TextUtils.isEmpty(str)) {
            str = this.jnw.getPageContext().getString(R.string.subpb_add_comment_fail_tip);
        }
        BdToast.a(this.jnw.getPageContext().getPageActivity(), str, 1).brB();
    }

    public void b(boolean z, String str, d dVar) {
        if (z) {
            BdToast.a(this.jnw.getPageContext().getPageActivity(), this.jnw.getPageContext().getString(R.string.subpb_delete_comment_succ_tip), 1).brB();
            this.jnY.remove(dVar);
            this.jnW.setData(this.jnY);
            qJ(this.hasMore);
            return;
        }
        if (TextUtils.isEmpty(str)) {
            str = this.jnw.getPageContext().getString(R.string.subpb_delete_comment_fail_tip);
        }
        BdToast.a(this.jnw.getPageContext().getPageActivity(), str, 1).brB();
    }

    public void qK(boolean z) {
        if (this.iIw != null && this.iIw.getLayoutParams() != null) {
            ViewGroup.LayoutParams layoutParams = this.iIw.getLayoutParams();
            if (z) {
                cIa();
                layoutParams.height = l.getDimens(this.jnw.getPageContext().getPageActivity(), R.dimen.ds98);
            } else {
                layoutParams.height = l.getDimens(this.jnw.getPageContext().getPageActivity(), R.dimen.ds98) + UtilHelper.getLightStatusBarHeight();
            }
            this.iIw.setLayoutParams(layoutParams);
        }
    }

    public void cR(View view) {
        if (this.iIw != null && this.mNavigationBar != null) {
            if (this.mNavigationBar.isNavigationBarExcludeStatusbarVisible()) {
                this.mNavigationBar.showNavigationBarExcludeStatusbar(false);
                if (UtilHelper.canUseStyleImmersiveSticky()) {
                    this.iIw.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight()));
                } else if (this.gpX != null) {
                    this.gpX.removeHeaderView(this.iIw);
                }
                this.mNavigationBar.setVisibility(8);
                return;
            }
            this.mNavigationBar.showNavigationBarExcludeStatusbar(true);
            if (UtilHelper.canUseStyleImmersiveSticky()) {
                this.iIw.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + l.getDimens(this.jnw.getActivity(), R.dimen.ds98)));
            } else if (this.gpX != null) {
                this.gpX.addHeaderView(this.iIw, 0);
            }
            this.mNavigationBar.setVisibility(0);
        }
    }

    public void Lk(String str) {
        this.jnU.setVisibility(8);
        this.fwP.setVisibility(0);
        this.jnS.post(new Runnable() { // from class: com.baidu.tieba.frs.gamesubpb.view.a.3
            @Override // java.lang.Runnable
            public void run() {
                a.this.jnS.requestFocus();
                l.showSoftKeyPad(a.this.jnw.getPageContext().getPageActivity(), a.this.jnS);
            }
        });
        if (!TextUtils.isEmpty(str)) {
            String format = String.format(this.jnw.getPageContext().getPageActivity().getResources().getString(R.string.reply_sub_floor), str);
            this.jnS.setText(format);
            this.jnS.setSelection(format.length());
        }
    }

    public void Ba(int i) {
        this.mProgressBar.setVisibility(i);
    }

    public View cwb() {
        return this.iIw;
    }

    public View getRootView() {
        return this.mRootView;
    }

    public ListView getListView() {
        return this.gpX;
    }

    public TextView cIb() {
        return this.jnU;
    }

    public NavigationBar bVK() {
        return this.mNavigationBar;
    }

    public void e(com.baidu.tieba.frs.gamesubpb.c cVar) {
        this.jng = cVar;
    }

    public void b(BdListView.e eVar) {
        this.gpX.setOnSrollToBottomListener(eVar);
    }

    public void onChangeSkinType(int i) {
        this.jnw.getLayoutMode().setNightMode(i == 1);
        this.jnw.getLayoutMode().onModeChanged(this.mRootView);
        ap.setBackgroundColor(this.mRootView, R.color.CAM_X0201);
        this.mNavigationBar.onChangeSkinType(this.jnw.getPageContext(), i);
        this.jnQ.changeSkin(i);
        ap.setViewTextColor(this.jnU, (int) R.color.CAM_X0110);
        this.jnU.setAlpha(0.95f);
        ap.setBackgroundResource(this.jnU, R.drawable.pb_ecomm_comment_bg);
        ap.setViewTextColor(this.jnV, (int) R.color.CAM_X0109);
        ap.setBackgroundResource(this.fwP, R.drawable.pb_ecomm_comment_bg);
        ap.setViewTextColor(this.jnS, (int) R.color.CAM_X0106);
        this.jnS.setHintTextColor(ap.getColor(R.color.CAM_X0110));
        ap.setViewTextColor(this.jnT, (int) R.color.game_sub_pb_send_txt_color);
    }

    public void onDestroy() {
        if (this.globalListener != null) {
            this.jnw.getPageContext().getPageActivity().getWindow().getDecorView().getViewTreeObserver().removeGlobalOnLayoutListener(this.globalListener);
        }
    }
}
