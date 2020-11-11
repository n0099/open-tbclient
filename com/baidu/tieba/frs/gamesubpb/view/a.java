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
    private View.OnClickListener aZX;
    private c fhK = new c(new c.a() { // from class: com.baidu.tieba.frs.gamesubpb.view.a.1
        @Override // com.baidu.tieba.pb.a.c.a
        public boolean onDoubleTap(View view, MotionEvent motionEvent) {
            a.this.qe(false);
            a.this.cG(view);
            a.this.qe(true);
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
    private LinearLayout fqd;
    private BdTypeListView gih;
    private ViewTreeObserver.OnGlobalLayoutListener globalListener;
    private long goC;
    private boolean hasMore;
    private com.baidu.tieba.frs.gamesubpb.c iYU;
    private String iYY;
    private e iZE;
    private FrameLayout iZF;
    private EditText iZG;
    private TextView iZH;
    private TextView iZI;
    private TextView iZJ;
    private com.baidu.tieba.frs.gamesubpb.b iZK;
    private com.baidu.tieba.frs.gamesubpb.model.b iZL;
    private List<q> iZM;
    private String iZN;
    private FrsGameSubPbActivity iZk;
    private View iwP;
    private View mBack;
    private boolean mIsKeyboardOpen;
    private NavigationBar mNavigationBar;
    private ProgressBar mProgressBar;
    private RelativeLayout mRootView;

    public a(FrsGameSubPbActivity frsGameSubPbActivity, View.OnClickListener onClickListener, String str) {
        this.iZk = frsGameSubPbActivity;
        this.aZX = onClickListener;
        this.iYY = str;
        this.mRootView = (RelativeLayout) LayoutInflater.from(frsGameSubPbActivity.getPageContext().getPageActivity()).inflate(R.layout.frs_game_sub_pb_activity, (ViewGroup) null);
        this.gih = (BdTypeListView) this.mRootView.findViewById(R.id.new_sub_pb_list);
        this.gih.setOnTouchListener(this.fhK);
        this.gih.setOnScrollListener(new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.frs.gamesubpb.view.a.4
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
                if (i != 0) {
                    l.hideSoftKeyPad(a.this.iZk.getPageContext().getPageActivity(), a.this.iZG);
                }
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            }
        });
        this.iZE = new e(this.iZk.getPageContext());
        this.iwP = BdListViewHelper.a(this.iZk.getActivity(), this.gih, BdListViewHelper.HeadType.DEFAULT);
        this.iZI = (TextView) this.mRootView.findViewById(R.id.subpb_editor_tool_comment_reply_text);
        this.iZI.setOnClickListener(this.aZX);
        this.iZJ = (TextView) this.mRootView.findViewById(R.id.no_reply_list_view);
        this.iZF = (FrameLayout) this.mRootView.findViewById(R.id.bottom_view);
        this.fqd = (LinearLayout) this.mRootView.findViewById(R.id.subpb_editor_tool_comment_input_container);
        this.iZG = (EditText) this.mRootView.findViewById(R.id.subpb_editor_tool_comment_input_edit);
        this.iZH = (TextView) this.mRootView.findViewById(R.id.subpb_editor_tool_comment_send_tv);
        this.iZH.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.gamesubpb.view.a.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.KC(a.this.iZG.getText().toString());
            }
        });
        this.mProgressBar = (ProgressBar) this.mRootView.findViewById(R.id.progressBar);
        cDh();
        this.iZK = new com.baidu.tieba.frs.gamesubpb.b(this.iZk.getPageContext(), this.gih);
        this.iZK.setClickListener(new a.InterfaceC0730a() { // from class: com.baidu.tieba.frs.gamesubpb.view.a.6
            @Override // com.baidu.tieba.frs.gamesubpb.a.InterfaceC0730a
            public void a(d dVar) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonPolymericActivityConfig(a.this.iZk.getPageContext().getPageActivity()).createNormalConfig(Long.valueOf(dVar.userId).longValue(), String.valueOf(a.this.goC).equals(dVar.userId), false)));
            }

            @Override // com.baidu.tieba.frs.gamesubpb.a.InterfaceC0730a
            public void b(d dVar) {
                if (dVar != null) {
                    a.this.d(dVar);
                }
            }

            @Override // com.baidu.tieba.frs.gamesubpb.a.InterfaceC0730a
            public void c(d dVar) {
                if (a.this.iYU != null) {
                    a.this.iYU.cDa();
                }
                if (dVar == null) {
                    a.this.KD(null);
                    a.this.cDj();
                    return;
                }
                a.this.KD(dVar.userName);
                a.this.iZN = dVar.userId;
            }
        });
        zN(140);
        cDi();
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        this.iZM = new ArrayList();
        this.goC = com.baidu.adp.lib.f.b.toLong(TbadkCoreApplication.getCurrentAccount(), 0L);
    }

    private void cDh() {
        this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(R.id.view_navigation_bar);
        this.mBack = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        ImageView backImageView = this.mNavigationBar.getBackImageView();
        if (backImageView != null && (backImageView.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.mBack.getLayoutParams();
            int dimens = l.getDimens(this.iZk.getPageContext().getPageActivity(), R.dimen.ds30);
            layoutParams.height = dimens;
            layoutParams.width = dimens;
            backImageView.setLayoutParams(layoutParams);
        }
        if (this.mBack != null && (this.mBack.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.mBack.getLayoutParams();
            layoutParams2.width = -2;
            layoutParams2.height = -1;
            this.mBack.setPadding(l.getDimens(this.iZk.getPageContext().getPageActivity(), R.dimen.ds32), this.mBack.getPaddingTop(), this.mBack.getPaddingRight(), this.mBack.getPaddingBottom());
            this.mBack.setLayoutParams(layoutParams2);
        }
        if (this.mNavigationBar.getBackImageView() != null) {
            SvgManager.brn().a(this.mNavigationBar.getBackImageView(), R.drawable.icon_pure_topbar_return44_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
    }

    private void cDi() {
        this.globalListener = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tieba.frs.gamesubpb.view.a.7
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                Rect rect = new Rect();
                a.this.iZk.getPageContext().getPageActivity().getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
                int statusBarHeight = l.getStatusBarHeight(a.this.iZk.getPageContext().getPageActivity());
                int[] screenDimensions = l.getScreenDimensions(a.this.iZk.getPageContext().getPageActivity());
                if (screenDimensions[1] - rect.bottom > screenDimensions[1] / 4 && !a.this.mIsKeyboardOpen) {
                    a.this.mIsKeyboardOpen = true;
                    a.this.onKeyboardVisibilityChanged(true);
                } else if (screenDimensions[1] - rect.height() == statusBarHeight && a.this.mIsKeyboardOpen) {
                    a.this.mIsKeyboardOpen = false;
                    a.this.onKeyboardVisibilityChanged(false);
                }
            }
        };
        this.iZk.getPageContext().getPageActivity().getWindow().getDecorView().getViewTreeObserver().addOnGlobalLayoutListener(this.globalListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(final d dVar) {
        final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.iZk.getPageContext().getPageActivity());
        aVar.Bn(null);
        aVar.ow(R.string.del_post_confirm);
        aVar.iW(true);
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
        aVar.b(this.iZk.getPageContext()).bpc();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(d dVar) {
        HttpMessage httpMessage = new HttpMessage(1003381);
        httpMessage.addParam("user_id", this.goC);
        httpMessage.addParam("main_tower_id", dVar.iZA);
        httpMessage.addParam("id", dVar.id);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void KC(String str) {
        zO(0);
        HttpMessage httpMessage = new HttpMessage(1003380);
        httpMessage.addParam("user_id", this.goC);
        httpMessage.addParam("reply_user_id", this.iZN);
        httpMessage.addParam("content", str);
        httpMessage.addParam("main_tower_id", this.iYY);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cDj() {
        this.iZN = this.iZL != null ? this.iZL.userId : null;
    }

    private void cDk() {
        if (!y.isEmpty(this.iZM)) {
            this.mNavigationBar.setCenterTextTitle(String.format(this.iZk.getResources().getString(R.string.subpb_floor_reply_count), at.numFormatOver10000(this.iZM.size())));
        } else {
            this.mNavigationBar.setCenterTextTitle(this.iZk.getResources().getString(R.string.reply));
        }
    }

    private void zN(final int i) {
        this.iZG.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.frs.gamesubpb.view.a.10
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                if (!TextUtils.isEmpty(charSequence)) {
                    a.this.iZH.setEnabled(true);
                    String charSequence2 = charSequence.toString();
                    if (!StringUtils.isNull(charSequence2) && af.getTextLength(charSequence2) > i) {
                        String subString = af.subString(charSequence2, 0, i - 1);
                        a.this.iZG.setText(subString);
                        a.this.iZG.setSelection(a.this.iZG.getText().length());
                        UtilHelper.showToast(a.this.iZk.getPageContext().getPageActivity().getApplication(), a.this.iZk.getPageContext().getPageActivity().getResources().getString(R.string.edit_text_over_limit_tip, Integer.valueOf(subString.length())));
                        return;
                    }
                    return;
                }
                a.this.cDj();
                a.this.iZH.setEnabled(false);
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
            }
        });
    }

    private void cDl() {
        if (this.mNavigationBar.getBackImageView() != null) {
            SvgManager.brn().a(this.mNavigationBar.getBackImageView(), R.drawable.icon_pure_topbar_return44_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qe(final boolean z) {
        if (this.gih != null) {
            if (!z) {
                this.gih.setEnabled(z);
            } else {
                this.gih.postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.gamesubpb.view.a.11
                    @Override // java.lang.Runnable
                    public void run() {
                        a.this.gih.setEnabled(z);
                    }
                }, 10L);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onKeyboardVisibilityChanged(boolean z) {
        if (z) {
            Rect rect = new Rect();
            this.fqd.getWindowVisibleDisplayFrame(rect);
            this.iZF.scrollTo(this.iZF.getScrollX(), (l.getScreenDimensions(this.iZk.getPageContext().getPageActivity())[1] - rect.bottom) - (MenuKeyUtils.hasSmartBar() ? l.dip2px(this.iZk.getPageContext().getPageActivity(), 48.0f) : 0));
            return;
        }
        this.iZF.setScrollY(0);
    }

    private void qf(boolean z) {
        if (y.isEmpty(this.iZM)) {
            this.gih.setNextPage(null);
            this.iZJ.setVisibility(0);
        } else {
            this.gih.setNextPage(this.iZE);
            this.iZJ.setVisibility(8);
            if (z) {
                this.iZE.startLoadData();
            } else {
                this.iZE.endLoadData();
            }
        }
        cDk();
    }

    public void a(boolean z, com.baidu.tieba.frs.gamesubpb.model.b bVar, List<q> list) {
        this.hasMore = z;
        this.iZL = bVar;
        cDj();
        if (y.isEmpty(list)) {
            qf(z);
            return;
        }
        this.iZM.clear();
        this.iZM.addAll(list);
        this.iZJ.setVisibility(8);
        this.gih.setNextPage(this.iZE);
        this.iZK.setData(list);
        cDl();
        this.iZI.setVisibility(0);
        this.iZI.setText(R.string.say_your_point);
        qf(z);
    }

    public void a(boolean z, String str, d dVar) {
        zO(8);
        if (z && dVar != null) {
            BdToast.a(this.iZk.getPageContext().getPageActivity(), this.iZk.getPageContext().getString(R.string.subpb_add_comment_succ_tip), 1).bpi();
            this.iZG.setText((CharSequence) null);
            this.iZM.add(dVar);
            this.iZK.setData(this.iZM);
            qf(this.hasMore);
            this.iZG.post(new Runnable() { // from class: com.baidu.tieba.frs.gamesubpb.view.a.2
                @Override // java.lang.Runnable
                public void run() {
                    a.this.iZG.requestFocus();
                    l.hideSoftKeyPad(a.this.iZk.getPageContext().getPageActivity(), a.this.iZG);
                }
            });
            return;
        }
        if (TextUtils.isEmpty(str)) {
            str = this.iZk.getPageContext().getString(R.string.subpb_add_comment_fail_tip);
        }
        BdToast.a(this.iZk.getPageContext().getPageActivity(), str, 1).bpi();
    }

    public void b(boolean z, String str, d dVar) {
        if (z) {
            BdToast.a(this.iZk.getPageContext().getPageActivity(), this.iZk.getPageContext().getString(R.string.subpb_delete_comment_succ_tip), 1).bpi();
            this.iZM.remove(dVar);
            this.iZK.setData(this.iZM);
            qf(this.hasMore);
            return;
        }
        if (TextUtils.isEmpty(str)) {
            str = this.iZk.getPageContext().getString(R.string.subpb_delete_comment_fail_tip);
        }
        BdToast.a(this.iZk.getPageContext().getPageActivity(), str, 1).bpi();
    }

    public void qg(boolean z) {
        if (this.iwP != null && this.iwP.getLayoutParams() != null) {
            ViewGroup.LayoutParams layoutParams = this.iwP.getLayoutParams();
            if (z) {
                cDl();
                layoutParams.height = l.getDimens(this.iZk.getPageContext().getPageActivity(), R.dimen.ds98);
            } else {
                layoutParams.height = l.getDimens(this.iZk.getPageContext().getPageActivity(), R.dimen.ds98) + UtilHelper.getLightStatusBarHeight();
            }
            this.iwP.setLayoutParams(layoutParams);
        }
    }

    public void cG(View view) {
        if (this.iwP != null && this.mNavigationBar != null) {
            if (this.mNavigationBar.isNavigationBarExcludeStatusbarVisible()) {
                this.mNavigationBar.showNavigationBarExcludeStatusbar(false);
                if (UtilHelper.canUseStyleImmersiveSticky()) {
                    this.iwP.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight()));
                } else if (this.gih != null) {
                    this.gih.removeHeaderView(this.iwP);
                }
                this.mNavigationBar.setVisibility(8);
                return;
            }
            this.mNavigationBar.showNavigationBarExcludeStatusbar(true);
            if (UtilHelper.canUseStyleImmersiveSticky()) {
                this.iwP.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + l.getDimens(this.iZk.getActivity(), R.dimen.ds98)));
            } else if (this.gih != null) {
                this.gih.addHeaderView(this.iwP, 0);
            }
            this.mNavigationBar.setVisibility(0);
        }
    }

    public void KD(String str) {
        this.iZI.setVisibility(8);
        this.fqd.setVisibility(0);
        this.iZG.post(new Runnable() { // from class: com.baidu.tieba.frs.gamesubpb.view.a.3
            @Override // java.lang.Runnable
            public void run() {
                a.this.iZG.requestFocus();
                l.showSoftKeyPad(a.this.iZk.getPageContext().getPageActivity(), a.this.iZG);
            }
        });
        if (!TextUtils.isEmpty(str)) {
            String format = String.format(this.iZk.getPageContext().getPageActivity().getResources().getString(R.string.reply_sub_floor), str);
            this.iZG.setText(format);
            this.iZG.setSelection(format.length());
        }
    }

    public void zO(int i) {
        this.mProgressBar.setVisibility(i);
    }

    public View csj() {
        return this.iwP;
    }

    public View getRootView() {
        return this.mRootView;
    }

    public ListView getListView() {
        return this.gih;
    }

    public TextView cDm() {
        return this.iZI;
    }

    public NavigationBar bSH() {
        return this.mNavigationBar;
    }

    public void e(com.baidu.tieba.frs.gamesubpb.c cVar) {
        this.iYU = cVar;
    }

    public void b(BdListView.e eVar) {
        this.gih.setOnSrollToBottomListener(eVar);
    }

    public void onChangeSkinType(int i) {
        this.iZk.getLayoutMode().setNightMode(i == 1);
        this.iZk.getLayoutMode().onModeChanged(this.mRootView);
        ap.setBackgroundColor(this.mRootView, R.color.cp_bg_line_d);
        this.mNavigationBar.onChangeSkinType(this.iZk.getPageContext(), i);
        this.iZE.changeSkin(i);
        ap.setViewTextColor(this.iZI, (int) R.color.cp_cont_e);
        this.iZI.setAlpha(0.95f);
        ap.setBackgroundResource(this.iZI, R.drawable.pb_ecomm_comment_bg);
        ap.setViewTextColor(this.iZJ, (int) R.color.cp_cont_d);
        ap.setBackgroundResource(this.fqd, R.drawable.pb_ecomm_comment_bg);
        ap.setViewTextColor(this.iZG, (int) R.color.cp_cont_f);
        this.iZG.setHintTextColor(ap.getColor(R.color.cp_cont_e));
        ap.setViewTextColor(this.iZH, (int) R.color.game_sub_pb_send_txt_color);
    }

    public void onDestroy() {
        if (this.globalListener != null) {
            this.iZk.getPageContext().getPageActivity().getWindow().getDecorView().getViewTreeObserver().removeGlobalOnLayoutListener(this.globalListener);
        }
    }
}
