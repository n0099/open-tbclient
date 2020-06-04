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
import com.baidu.adp.widget.ListView.o;
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
/* loaded from: classes9.dex */
public class a {
    private View.OnClickListener aIH;
    private c efF = new c(new c.a() { // from class: com.baidu.tieba.frs.gamesubpb.view.a.1
        @Override // com.baidu.tieba.pb.a.c.a
        public boolean onDoubleTap(View view, MotionEvent motionEvent) {
            a.this.nv(false);
            a.this.cb(view);
            a.this.nv(true);
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
    private LinearLayout enc;
    private BdTypeListView fbb;
    private long fhm;
    private ViewTreeObserver.OnGlobalLayoutListener globalListener;
    private FrsGameSubPbActivity hDA;
    private e hDU;
    private FrameLayout hDV;
    private EditText hDW;
    private TextView hDX;
    private TextView hDY;
    private TextView hDZ;
    private com.baidu.tieba.frs.gamesubpb.c hDk;
    private String hDo;
    private com.baidu.tieba.frs.gamesubpb.b hEa;
    private com.baidu.tieba.frs.gamesubpb.model.b hEb;
    private List<o> hEc;
    private String hEd;
    private boolean hasMore;
    private View hdc;
    private View mBack;
    private boolean mIsKeyboardOpen;
    private NavigationBar mNavigationBar;
    private ProgressBar mProgressBar;
    private RelativeLayout mRootView;

    public a(FrsGameSubPbActivity frsGameSubPbActivity, View.OnClickListener onClickListener, String str) {
        this.hDA = frsGameSubPbActivity;
        this.aIH = onClickListener;
        this.hDo = str;
        this.mRootView = (RelativeLayout) LayoutInflater.from(frsGameSubPbActivity.getPageContext().getPageActivity()).inflate(R.layout.frs_game_sub_pb_activity, (ViewGroup) null);
        this.fbb = (BdTypeListView) this.mRootView.findViewById(R.id.new_sub_pb_list);
        this.fbb.setOnTouchListener(this.efF);
        this.fbb.setOnScrollListener(new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.frs.gamesubpb.view.a.4
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
                if (i != 0) {
                    l.hideSoftKeyPad(a.this.hDA.getPageContext().getPageActivity(), a.this.hDW);
                }
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            }
        });
        this.hDU = new e(this.hDA.getPageContext());
        this.hdc = BdListViewHelper.a(this.hDA.getActivity(), this.fbb, BdListViewHelper.HeadType.DEFAULT);
        this.hDY = (TextView) this.mRootView.findViewById(R.id.subpb_editor_tool_comment_reply_text);
        this.hDY.setOnClickListener(this.aIH);
        this.hDZ = (TextView) this.mRootView.findViewById(R.id.no_reply_list_view);
        this.hDV = (FrameLayout) this.mRootView.findViewById(R.id.bottom_view);
        this.enc = (LinearLayout) this.mRootView.findViewById(R.id.subpb_editor_tool_comment_input_container);
        this.hDW = (EditText) this.mRootView.findViewById(R.id.subpb_editor_tool_comment_input_edit);
        this.hDX = (TextView) this.mRootView.findViewById(R.id.subpb_editor_tool_comment_send_tv);
        this.hDX.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.gamesubpb.view.a.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.EM(a.this.hDW.getText().toString());
            }
        });
        this.mProgressBar = (ProgressBar) this.mRootView.findViewById(R.id.progressBar);
        bZx();
        this.hEa = new com.baidu.tieba.frs.gamesubpb.b(this.hDA.getPageContext(), this.fbb);
        this.hEa.setClickListener(new a.InterfaceC0616a() { // from class: com.baidu.tieba.frs.gamesubpb.view.a.6
            @Override // com.baidu.tieba.frs.gamesubpb.a.InterfaceC0616a
            public void a(d dVar) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonPolymericActivityConfig(a.this.hDA.getPageContext().getPageActivity()).createNormalConfig(Long.valueOf(dVar.userId).longValue(), String.valueOf(a.this.fhm).equals(dVar.userId), false)));
            }

            @Override // com.baidu.tieba.frs.gamesubpb.a.InterfaceC0616a
            public void b(d dVar) {
                if (dVar != null) {
                    a.this.d(dVar);
                }
            }

            @Override // com.baidu.tieba.frs.gamesubpb.a.InterfaceC0616a
            public void c(d dVar) {
                if (a.this.hDk != null) {
                    a.this.hDk.bZp();
                }
                if (dVar == null) {
                    a.this.EN(null);
                    a.this.bZz();
                    return;
                }
                a.this.EN(dVar.userName);
                a.this.hEd = dVar.userId;
            }
        });
        uM(140);
        bZy();
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        this.hEc = new ArrayList();
        this.fhm = com.baidu.adp.lib.f.b.toLong(TbadkCoreApplication.getCurrentAccount(), 0L);
    }

    private void bZx() {
        this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(R.id.view_navigation_bar);
        this.mBack = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        ImageView backImageView = this.mNavigationBar.getBackImageView();
        if (backImageView != null && (backImageView.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.mBack.getLayoutParams();
            int dimens = l.getDimens(this.hDA.getPageContext().getPageActivity(), R.dimen.ds30);
            layoutParams.height = dimens;
            layoutParams.width = dimens;
            backImageView.setLayoutParams(layoutParams);
        }
        if (this.mBack != null && (this.mBack.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.mBack.getLayoutParams();
            layoutParams2.width = -2;
            layoutParams2.height = -1;
            this.mBack.setPadding(l.getDimens(this.hDA.getPageContext().getPageActivity(), R.dimen.ds32), this.mBack.getPaddingTop(), this.mBack.getPaddingRight(), this.mBack.getPaddingBottom());
            this.mBack.setLayoutParams(layoutParams2);
        }
        if (this.mNavigationBar.getBackImageView() != null) {
            SvgManager.aUW().a(this.mNavigationBar.getBackImageView(), R.drawable.icon_pure_topbar_return44_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
    }

    private void bZy() {
        this.globalListener = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tieba.frs.gamesubpb.view.a.7
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                Rect rect = new Rect();
                a.this.hDA.getPageContext().getPageActivity().getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
                int statusBarHeight = l.getStatusBarHeight(a.this.hDA.getPageContext().getPageActivity());
                int[] screenDimensions = l.getScreenDimensions(a.this.hDA.getPageContext().getPageActivity());
                if (screenDimensions[1] - rect.bottom > screenDimensions[1] / 4 && !a.this.mIsKeyboardOpen) {
                    a.this.mIsKeyboardOpen = true;
                    a.this.onKeyboardVisibilityChanged(true);
                } else if (screenDimensions[1] - rect.height() == statusBarHeight && a.this.mIsKeyboardOpen) {
                    a.this.mIsKeyboardOpen = false;
                    a.this.onKeyboardVisibilityChanged(false);
                }
            }
        };
        this.hDA.getPageContext().getPageActivity().getWindow().getDecorView().getViewTreeObserver().addOnGlobalLayoutListener(this.globalListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(final d dVar) {
        final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.hDA.getPageContext().getPageActivity());
        aVar.vN(null);
        aVar.kF(R.string.del_post_confirm);
        aVar.gX(true);
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
        aVar.b(this.hDA.getPageContext()).aST();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(d dVar) {
        HttpMessage httpMessage = new HttpMessage(1003381);
        httpMessage.addParam("user_id", this.fhm);
        httpMessage.addParam("main_tower_id", dVar.hDQ);
        httpMessage.addParam("id", dVar.id);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void EM(String str) {
        uN(0);
        HttpMessage httpMessage = new HttpMessage(1003380);
        httpMessage.addParam("user_id", this.fhm);
        httpMessage.addParam("reply_user_id", this.hEd);
        httpMessage.addParam("content", str);
        httpMessage.addParam("main_tower_id", this.hDo);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bZz() {
        this.hEd = this.hEb != null ? this.hEb.userId : null;
    }

    private void bZA() {
        if (!v.isEmpty(this.hEc)) {
            this.mNavigationBar.setCenterTextTitle(String.format(this.hDA.getResources().getString(R.string.subpb_floor_reply_count), aq.numFormatOver10000(this.hEc.size())));
        } else {
            this.mNavigationBar.setCenterTextTitle(this.hDA.getResources().getString(R.string.reply));
        }
    }

    private void uM(final int i) {
        this.hDW.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.frs.gamesubpb.view.a.10
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                if (!TextUtils.isEmpty(charSequence)) {
                    a.this.hDX.setEnabled(true);
                    String charSequence2 = charSequence.toString();
                    if (!StringUtils.isNull(charSequence2) && ae.getTextLength(charSequence2) > i) {
                        String subString = ae.subString(charSequence2, 0, i - 1);
                        a.this.hDW.setText(subString);
                        a.this.hDW.setSelection(a.this.hDW.getText().length());
                        UtilHelper.showToast(a.this.hDA.getPageContext().getPageActivity().getApplication(), a.this.hDA.getPageContext().getPageActivity().getResources().getString(R.string.edit_text_over_limit_tip, Integer.valueOf(subString.length())));
                        return;
                    }
                    return;
                }
                a.this.bZz();
                a.this.hDX.setEnabled(false);
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
            }
        });
    }

    private void bZB() {
        if (this.mNavigationBar.getBackImageView() != null) {
            SvgManager.aUW().a(this.mNavigationBar.getBackImageView(), R.drawable.icon_pure_topbar_return44_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void nv(final boolean z) {
        if (this.fbb != null) {
            if (!z) {
                this.fbb.setEnabled(z);
            } else {
                this.fbb.postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.gamesubpb.view.a.11
                    @Override // java.lang.Runnable
                    public void run() {
                        a.this.fbb.setEnabled(z);
                    }
                }, 10L);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onKeyboardVisibilityChanged(boolean z) {
        if (z) {
            Rect rect = new Rect();
            this.enc.getWindowVisibleDisplayFrame(rect);
            this.hDV.scrollTo(this.hDV.getScrollX(), (l.getScreenDimensions(this.hDA.getPageContext().getPageActivity())[1] - rect.bottom) - (MenuKeyUtils.hasSmartBar() ? l.dip2px(this.hDA.getPageContext().getPageActivity(), 48.0f) : 0));
            return;
        }
        this.hDV.setScrollY(0);
    }

    private void nw(boolean z) {
        if (v.isEmpty(this.hEc)) {
            this.fbb.setNextPage(null);
            this.hDZ.setVisibility(0);
        } else {
            this.fbb.setNextPage(this.hDU);
            this.hDZ.setVisibility(8);
            if (z) {
                this.hDU.startLoadData();
            } else {
                this.hDU.endLoadData();
            }
        }
        bZA();
    }

    public void a(boolean z, com.baidu.tieba.frs.gamesubpb.model.b bVar, List<o> list) {
        this.hasMore = z;
        this.hEb = bVar;
        bZz();
        if (v.isEmpty(list)) {
            nw(z);
            return;
        }
        this.hEc.clear();
        this.hEc.addAll(list);
        this.hDZ.setVisibility(8);
        this.fbb.setNextPage(this.hDU);
        this.hEa.setData(list);
        bZB();
        this.hDY.setVisibility(0);
        this.hDY.setText(R.string.say_your_point);
        nw(z);
    }

    public void a(boolean z, String str, d dVar) {
        uN(8);
        if (z && dVar != null) {
            BdToast.a(this.hDA.getPageContext().getPageActivity(), this.hDA.getPageContext().getString(R.string.subpb_add_comment_succ_tip), 1).aSY();
            this.hDW.setText((CharSequence) null);
            this.hEc.add(dVar);
            this.hEa.setData(this.hEc);
            nw(this.hasMore);
            this.hDW.post(new Runnable() { // from class: com.baidu.tieba.frs.gamesubpb.view.a.2
                @Override // java.lang.Runnable
                public void run() {
                    a.this.hDW.requestFocus();
                    l.hideSoftKeyPad(a.this.hDA.getPageContext().getPageActivity(), a.this.hDW);
                }
            });
            return;
        }
        if (TextUtils.isEmpty(str)) {
            str = this.hDA.getPageContext().getString(R.string.subpb_add_comment_fail_tip);
        }
        BdToast.a(this.hDA.getPageContext().getPageActivity(), str, 1).aSY();
    }

    public void b(boolean z, String str, d dVar) {
        if (z) {
            BdToast.a(this.hDA.getPageContext().getPageActivity(), this.hDA.getPageContext().getString(R.string.subpb_delete_comment_succ_tip), 1).aSY();
            this.hEc.remove(dVar);
            this.hEa.setData(this.hEc);
            nw(this.hasMore);
            return;
        }
        if (TextUtils.isEmpty(str)) {
            str = this.hDA.getPageContext().getString(R.string.subpb_delete_comment_fail_tip);
        }
        BdToast.a(this.hDA.getPageContext().getPageActivity(), str, 1).aSY();
    }

    public void nx(boolean z) {
        if (this.hdc != null && this.hdc.getLayoutParams() != null) {
            ViewGroup.LayoutParams layoutParams = this.hdc.getLayoutParams();
            if (z) {
                bZB();
                layoutParams.height = l.getDimens(this.hDA.getPageContext().getPageActivity(), R.dimen.ds98);
            } else {
                layoutParams.height = l.getDimens(this.hDA.getPageContext().getPageActivity(), R.dimen.ds98) + UtilHelper.getLightStatusBarHeight();
            }
            this.hdc.setLayoutParams(layoutParams);
        }
    }

    public void cb(View view) {
        if (this.hdc != null && this.mNavigationBar != null) {
            if (this.mNavigationBar.isNavigationBarExcludeStatusbarVisible()) {
                this.mNavigationBar.showNavigationBarExcludeStatusbar(false);
                if (UtilHelper.canUseStyleImmersiveSticky()) {
                    this.hdc.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight()));
                } else if (this.fbb != null) {
                    this.fbb.removeHeaderView(this.hdc);
                }
                this.mNavigationBar.setVisibility(8);
                return;
            }
            this.mNavigationBar.showNavigationBarExcludeStatusbar(true);
            if (UtilHelper.canUseStyleImmersiveSticky()) {
                this.hdc.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + l.getDimens(this.hDA.getActivity(), R.dimen.ds98)));
            } else if (this.fbb != null) {
                this.fbb.addHeaderView(this.hdc, 0);
            }
            this.mNavigationBar.setVisibility(0);
        }
    }

    public void EN(String str) {
        this.hDY.setVisibility(8);
        this.enc.setVisibility(0);
        this.hDW.post(new Runnable() { // from class: com.baidu.tieba.frs.gamesubpb.view.a.3
            @Override // java.lang.Runnable
            public void run() {
                a.this.hDW.requestFocus();
                l.showSoftKeyPad(a.this.hDA.getPageContext().getPageActivity(), a.this.hDW);
            }
        });
        if (!TextUtils.isEmpty(str)) {
            String format = String.format(this.hDA.getPageContext().getPageActivity().getResources().getString(R.string.reply_sub_floor), str);
            this.hDW.setText(format);
            this.hDW.setSelection(format.length());
        }
    }

    public void uN(int i) {
        this.mProgressBar.setVisibility(i);
    }

    public View bPb() {
        return this.hdc;
    }

    public View getRootView() {
        return this.mRootView;
    }

    public ListView getListView() {
        return this.fbb;
    }

    public TextView bZC() {
        return this.hDY;
    }

    public NavigationBar bua() {
        return this.mNavigationBar;
    }

    public void e(com.baidu.tieba.frs.gamesubpb.c cVar) {
        this.hDk = cVar;
    }

    public void b(BdListView.e eVar) {
        this.fbb.setOnSrollToBottomListener(eVar);
    }

    public void onChangeSkinType(int i) {
        this.hDA.getLayoutMode().setNightMode(i == 1);
        this.hDA.getLayoutMode().onModeChanged(this.mRootView);
        am.setBackgroundColor(this.mRootView, R.color.cp_bg_line_d);
        this.mNavigationBar.onChangeSkinType(this.hDA.getPageContext(), i);
        this.hDU.changeSkin(i);
        am.setViewTextColor(this.hDY, (int) R.color.cp_cont_e);
        this.hDY.setAlpha(0.95f);
        am.setBackgroundResource(this.hDY, R.drawable.pb_ecomm_comment_bg);
        am.setViewTextColor(this.hDZ, (int) R.color.cp_cont_d);
        am.setBackgroundResource(this.enc, R.drawable.pb_ecomm_comment_bg);
        am.setViewTextColor(this.hDW, (int) R.color.cp_cont_f);
        this.hDW.setHintTextColor(am.getColor(R.color.cp_cont_e));
        am.setViewTextColor(this.hDX, (int) R.color.game_sub_pb_send_txt_color);
    }

    public void onDestroy() {
        if (this.globalListener != null) {
            this.hDA.getPageContext().getPageActivity().getWindow().getDecorView().getViewTreeObserver().removeGlobalOnLayoutListener(this.globalListener);
        }
    }
}
