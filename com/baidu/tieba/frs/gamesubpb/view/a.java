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
import com.baidu.tbadk.util.ad;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.gamesubpb.FrsGameSubPbActivity;
import com.baidu.tieba.frs.gamesubpb.a;
import com.baidu.tieba.frs.gamesubpb.model.d;
import com.baidu.tieba.frs.gamesubpb.model.e;
import com.baidu.tieba.pb.a.c;
import com.compatible.menukey.MenuKeyUtils;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class a {
    private boolean agD;
    private View.OnClickListener ahD;
    private c dmm = new c(new c.a() { // from class: com.baidu.tieba.frs.gamesubpb.view.a.1
        @Override // com.baidu.tieba.pb.a.c.a
        public boolean onDoubleTap(View view, MotionEvent motionEvent) {
            a.this.lD(false);
            a.this.bO(view);
            a.this.lD(true);
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
    private LinearLayout dup;
    private ViewTreeObserver.OnGlobalLayoutListener eeg;
    private BdTypeListView efM;
    private long ekX;
    private View fYJ;
    private com.baidu.tieba.frs.gamesubpb.c gxL;
    private String gxP;
    private TextView gyA;
    private com.baidu.tieba.frs.gamesubpb.b gyB;
    private com.baidu.tieba.frs.gamesubpb.model.b gyC;
    private List<m> gyD;
    private String gyE;
    private FrsGameSubPbActivity gyb;
    private e gyv;
    private FrameLayout gyw;
    private EditText gyx;
    private TextView gyy;
    private TextView gyz;
    private boolean hasMore;
    private View mBack;
    private NavigationBar mNavigationBar;
    private ProgressBar mProgressBar;
    private RelativeLayout mRootView;

    public a(FrsGameSubPbActivity frsGameSubPbActivity, View.OnClickListener onClickListener, String str) {
        this.gyb = frsGameSubPbActivity;
        this.ahD = onClickListener;
        this.gxP = str;
        this.mRootView = (RelativeLayout) LayoutInflater.from(frsGameSubPbActivity.getPageContext().getPageActivity()).inflate(R.layout.frs_game_sub_pb_activity, (ViewGroup) null);
        this.efM = (BdTypeListView) this.mRootView.findViewById(R.id.new_sub_pb_list);
        this.efM.setOnTouchListener(this.dmm);
        this.efM.setOnScrollListener(new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.frs.gamesubpb.view.a.4
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
                if (i != 0) {
                    l.hideSoftKeyPad(a.this.gyb.getPageContext().getPageActivity(), a.this.gyx);
                }
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            }
        });
        this.gyv = new e(this.gyb.getPageContext());
        this.fYJ = BdListViewHelper.a(this.gyb.getActivity(), this.efM, BdListViewHelper.HeadType.DEFAULT);
        this.gyz = (TextView) this.mRootView.findViewById(R.id.subpb_editor_tool_comment_reply_text);
        this.gyz.setOnClickListener(this.ahD);
        this.gyA = (TextView) this.mRootView.findViewById(R.id.no_reply_list_view);
        this.gyw = (FrameLayout) this.mRootView.findViewById(R.id.bottom_view);
        this.dup = (LinearLayout) this.mRootView.findViewById(R.id.subpb_editor_tool_comment_input_container);
        this.gyx = (EditText) this.mRootView.findViewById(R.id.subpb_editor_tool_comment_input_edit);
        this.gyy = (TextView) this.mRootView.findViewById(R.id.subpb_editor_tool_comment_send_tv);
        this.gyy.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.gamesubpb.view.a.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.AP(a.this.gyx.getText().toString());
            }
        });
        this.mProgressBar = (ProgressBar) this.mRootView.findViewById(R.id.progressBar);
        bFD();
        this.gyB = new com.baidu.tieba.frs.gamesubpb.b(this.gyb.getPageContext(), this.efM);
        this.gyB.setClickListener(new a.InterfaceC0497a() { // from class: com.baidu.tieba.frs.gamesubpb.view.a.6
            @Override // com.baidu.tieba.frs.gamesubpb.a.InterfaceC0497a
            public void a(d dVar) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonPolymericActivityConfig(a.this.gyb.getPageContext().getPageActivity()).createNormalConfig(Long.valueOf(dVar.userId).longValue(), String.valueOf(a.this.ekX).equals(dVar.userId), false)));
            }

            @Override // com.baidu.tieba.frs.gamesubpb.a.InterfaceC0497a
            public void b(d dVar) {
                if (dVar != null) {
                    a.this.d(dVar);
                }
            }

            @Override // com.baidu.tieba.frs.gamesubpb.a.InterfaceC0497a
            public void c(d dVar) {
                if (a.this.gxL != null) {
                    a.this.gxL.bFv();
                }
                if (dVar == null) {
                    a.this.AQ(null);
                    a.this.bFF();
                    return;
                }
                a.this.AQ(dVar.userName);
                a.this.gyE = dVar.userId;
            }
        });
        tq(140);
        bFE();
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        this.gyD = new ArrayList();
        this.ekX = com.baidu.adp.lib.f.b.toLong(TbadkCoreApplication.getCurrentAccount(), 0L);
    }

    private void bFD() {
        this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(R.id.view_navigation_bar);
        this.mBack = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        ImageView backImageView = this.mNavigationBar.getBackImageView();
        if (backImageView != null && (backImageView.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.mBack.getLayoutParams();
            int dimens = l.getDimens(this.gyb.getPageContext().getPageActivity(), R.dimen.ds30);
            layoutParams.height = dimens;
            layoutParams.width = dimens;
            backImageView.setLayoutParams(layoutParams);
        }
        if (this.mBack != null && (this.mBack.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.mBack.getLayoutParams();
            layoutParams2.width = -2;
            layoutParams2.height = -1;
            this.mBack.setPadding(l.getDimens(this.gyb.getPageContext().getPageActivity(), R.dimen.ds32), this.mBack.getPaddingTop(), this.mBack.getPaddingRight(), this.mBack.getPaddingBottom());
            this.mBack.setLayoutParams(layoutParams2);
        }
        if (this.mNavigationBar.getBackImageView() != null) {
            SvgManager.aDW().a(this.mNavigationBar.getBackImageView(), R.drawable.icon_pure_topbar_return44_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
    }

    private void bFE() {
        this.eeg = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tieba.frs.gamesubpb.view.a.7
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                Rect rect = new Rect();
                a.this.gyb.getPageContext().getPageActivity().getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
                int statusBarHeight = l.getStatusBarHeight(a.this.gyb.getPageContext().getPageActivity());
                int[] screenDimensions = l.getScreenDimensions(a.this.gyb.getPageContext().getPageActivity());
                if (screenDimensions[1] - rect.bottom > screenDimensions[1] / 4 && !a.this.agD) {
                    a.this.agD = true;
                    a.this.onKeyboardVisibilityChanged(true);
                } else if (screenDimensions[1] - rect.height() == statusBarHeight && a.this.agD) {
                    a.this.agD = false;
                    a.this.onKeyboardVisibilityChanged(false);
                }
            }
        };
        this.gyb.getPageContext().getPageActivity().getWindow().getDecorView().getViewTreeObserver().addOnGlobalLayoutListener(this.eeg);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(final d dVar) {
        final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.gyb.getPageContext().getPageActivity());
        aVar.sy(null);
        aVar.jF(R.string.del_post_confirm);
        aVar.fv(true);
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
        aVar.b(this.gyb.getPageContext()).aBW();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(d dVar) {
        HttpMessage httpMessage = new HttpMessage(1003381);
        httpMessage.addParam("user_id", this.ekX);
        httpMessage.addParam("main_tower_id", dVar.gyr);
        httpMessage.addParam("id", dVar.id);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void AP(String str) {
        tr(0);
        HttpMessage httpMessage = new HttpMessage(1003380);
        httpMessage.addParam("user_id", this.ekX);
        httpMessage.addParam("reply_user_id", this.gyE);
        httpMessage.addParam("content", str);
        httpMessage.addParam("main_tower_id", this.gxP);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bFF() {
        this.gyE = this.gyC != null ? this.gyC.userId : null;
    }

    private void bFG() {
        if (!v.isEmpty(this.gyD)) {
            this.mNavigationBar.setCenterTextTitle(String.format(this.gyb.getResources().getString(R.string.subpb_floor_reply_count), aq.numFormatOver10000(this.gyD.size())));
        } else {
            this.mNavigationBar.setCenterTextTitle(this.gyb.getResources().getString(R.string.reply));
        }
    }

    private void tq(final int i) {
        this.gyx.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.frs.gamesubpb.view.a.10
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                if (!TextUtils.isEmpty(charSequence)) {
                    a.this.gyy.setEnabled(true);
                    String charSequence2 = charSequence.toString();
                    if (!StringUtils.isNull(charSequence2) && ad.getTextLength(charSequence2) > i) {
                        String subString = ad.subString(charSequence2, 0, i - 1);
                        a.this.gyx.setText(subString);
                        a.this.gyx.setSelection(a.this.gyx.getText().length());
                        UtilHelper.showToast(a.this.gyb.getPageContext().getPageActivity().getApplication(), a.this.gyb.getPageContext().getPageActivity().getResources().getString(R.string.edit_text_over_limit_tip, Integer.valueOf(subString.length())));
                        return;
                    }
                    return;
                }
                a.this.bFF();
                a.this.gyy.setEnabled(false);
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
            }
        });
    }

    private void bFH() {
        if (this.mNavigationBar.getBackImageView() != null) {
            SvgManager.aDW().a(this.mNavigationBar.getBackImageView(), R.drawable.icon_pure_topbar_return44_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lD(final boolean z) {
        if (this.efM != null) {
            if (!z) {
                this.efM.setEnabled(z);
            } else {
                this.efM.postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.gamesubpb.view.a.11
                    @Override // java.lang.Runnable
                    public void run() {
                        a.this.efM.setEnabled(z);
                    }
                }, 10L);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onKeyboardVisibilityChanged(boolean z) {
        if (z) {
            Rect rect = new Rect();
            this.dup.getWindowVisibleDisplayFrame(rect);
            this.gyw.scrollTo(this.gyw.getScrollX(), (l.getScreenDimensions(this.gyb.getPageContext().getPageActivity())[1] - rect.bottom) - (MenuKeyUtils.hasSmartBar() ? l.dip2px(this.gyb.getPageContext().getPageActivity(), 48.0f) : 0));
            return;
        }
        this.gyw.setScrollY(0);
    }

    private void lE(boolean z) {
        if (v.isEmpty(this.gyD)) {
            this.efM.setNextPage(null);
            this.gyA.setVisibility(0);
        } else {
            this.efM.setNextPage(this.gyv);
            this.gyA.setVisibility(8);
            if (z) {
                this.gyv.startLoadData();
            } else {
                this.gyv.endLoadData();
            }
        }
        bFG();
    }

    public void a(boolean z, com.baidu.tieba.frs.gamesubpb.model.b bVar, List<m> list) {
        this.hasMore = z;
        this.gyC = bVar;
        bFF();
        if (v.isEmpty(list)) {
            lE(z);
            return;
        }
        this.gyD.clear();
        this.gyD.addAll(list);
        this.gyA.setVisibility(8);
        this.efM.setNextPage(this.gyv);
        this.gyB.setData(list);
        bFH();
        this.gyz.setVisibility(0);
        this.gyz.setText(R.string.say_your_point);
        lE(z);
    }

    public void a(boolean z, String str, d dVar) {
        tr(8);
        if (z && dVar != null) {
            BdToast.a(this.gyb.getPageContext().getPageActivity(), this.gyb.getPageContext().getString(R.string.subpb_add_comment_succ_tip), 1).aCb();
            this.gyx.setText((CharSequence) null);
            this.gyD.add(dVar);
            this.gyB.setData(this.gyD);
            lE(this.hasMore);
            this.gyx.post(new Runnable() { // from class: com.baidu.tieba.frs.gamesubpb.view.a.2
                @Override // java.lang.Runnable
                public void run() {
                    a.this.gyx.requestFocus();
                    l.hideSoftKeyPad(a.this.gyb.getPageContext().getPageActivity(), a.this.gyx);
                }
            });
            return;
        }
        if (TextUtils.isEmpty(str)) {
            str = this.gyb.getPageContext().getString(R.string.subpb_add_comment_fail_tip);
        }
        BdToast.a(this.gyb.getPageContext().getPageActivity(), str, 1).aCb();
    }

    public void b(boolean z, String str, d dVar) {
        if (z) {
            BdToast.a(this.gyb.getPageContext().getPageActivity(), this.gyb.getPageContext().getString(R.string.subpb_delete_comment_succ_tip), 1).aCb();
            this.gyD.remove(dVar);
            this.gyB.setData(this.gyD);
            lE(this.hasMore);
            return;
        }
        if (TextUtils.isEmpty(str)) {
            str = this.gyb.getPageContext().getString(R.string.subpb_delete_comment_fail_tip);
        }
        BdToast.a(this.gyb.getPageContext().getPageActivity(), str, 1).aCb();
    }

    public void lF(boolean z) {
        if (this.fYJ != null && this.fYJ.getLayoutParams() != null) {
            ViewGroup.LayoutParams layoutParams = this.fYJ.getLayoutParams();
            if (z) {
                bFH();
                layoutParams.height = l.getDimens(this.gyb.getPageContext().getPageActivity(), R.dimen.ds98);
            } else {
                layoutParams.height = l.getDimens(this.gyb.getPageContext().getPageActivity(), R.dimen.ds98) + UtilHelper.getLightStatusBarHeight();
            }
            this.fYJ.setLayoutParams(layoutParams);
        }
    }

    public void bO(View view) {
        if (this.fYJ != null && this.mNavigationBar != null) {
            if (this.mNavigationBar.isNavigationBarExcludeStatusbarVisible()) {
                this.mNavigationBar.showNavigationBarExcludeStatusbar(false);
                if (UtilHelper.canUseStyleImmersiveSticky()) {
                    this.fYJ.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight()));
                } else if (this.efM != null) {
                    this.efM.removeHeaderView(this.fYJ);
                }
                this.mNavigationBar.setVisibility(8);
                return;
            }
            this.mNavigationBar.showNavigationBarExcludeStatusbar(true);
            if (UtilHelper.canUseStyleImmersiveSticky()) {
                this.fYJ.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + l.getDimens(this.gyb.getActivity(), R.dimen.ds98)));
            } else if (this.efM != null) {
                this.efM.addHeaderView(this.fYJ, 0);
            }
            this.mNavigationBar.setVisibility(0);
        }
    }

    public void AQ(String str) {
        this.gyz.setVisibility(8);
        this.dup.setVisibility(0);
        this.gyx.post(new Runnable() { // from class: com.baidu.tieba.frs.gamesubpb.view.a.3
            @Override // java.lang.Runnable
            public void run() {
                a.this.gyx.requestFocus();
                l.showSoftKeyPad(a.this.gyb.getPageContext().getPageActivity(), a.this.gyx);
            }
        });
        if (!TextUtils.isEmpty(str)) {
            String format = String.format(this.gyb.getPageContext().getPageActivity().getResources().getString(R.string.reply_sub_floor), str);
            this.gyx.setText(format);
            this.gyx.setSelection(format.length());
        }
    }

    public void tr(int i) {
        this.mProgressBar.setVisibility(i);
    }

    public View bvV() {
        return this.fYJ;
    }

    public View getRootView() {
        return this.mRootView;
    }

    public ListView getListView() {
        return this.efM;
    }

    public TextView bFI() {
        return this.gyz;
    }

    public NavigationBar bcb() {
        return this.mNavigationBar;
    }

    public void e(com.baidu.tieba.frs.gamesubpb.c cVar) {
        this.gxL = cVar;
    }

    public void b(BdListView.e eVar) {
        this.efM.setOnSrollToBottomListener(eVar);
    }

    public void onChangeSkinType(int i) {
        this.gyb.getLayoutMode().setNightMode(i == 1);
        this.gyb.getLayoutMode().onModeChanged(this.mRootView);
        am.setBackgroundColor(this.mRootView, R.color.cp_bg_line_d);
        this.mNavigationBar.onChangeSkinType(this.gyb.getPageContext(), i);
        this.gyv.changeSkin(i);
        am.setViewTextColor(this.gyz, (int) R.color.cp_cont_e);
        this.gyz.setAlpha(0.95f);
        am.setBackgroundResource(this.gyz, R.drawable.pb_ecomm_comment_bg);
        am.setViewTextColor(this.gyA, (int) R.color.cp_cont_d);
        am.setBackgroundResource(this.dup, R.drawable.pb_ecomm_comment_bg);
        am.setViewTextColor(this.gyx, (int) R.color.cp_cont_f);
        this.gyx.setHintTextColor(am.getColor(R.color.cp_cont_e));
        am.setViewTextColor(this.gyy, (int) R.color.game_sub_pb_send_txt_color);
    }

    public void onDestroy() {
        if (this.eeg != null) {
            this.gyb.getPageContext().getPageActivity().getWindow().getDecorView().getViewTreeObserver().removeGlobalOnLayoutListener(this.eeg);
        }
    }
}
