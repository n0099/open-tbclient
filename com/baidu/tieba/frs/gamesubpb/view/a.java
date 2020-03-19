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
/* loaded from: classes9.dex */
public class a {
    private boolean ajG;
    private View.OnClickListener akE;
    private c drk = new c(new c.a() { // from class: com.baidu.tieba.frs.gamesubpb.view.a.1
        @Override // com.baidu.tieba.pb.a.c.a
        public boolean onDoubleTap(View view, MotionEvent motionEvent) {
            a.this.lW(false);
            a.this.bT(view);
            a.this.lW(true);
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
    private LinearLayout dzh;
    private ViewTreeObserver.OnGlobalLayoutListener eiV;
    private BdTypeListView ekE;
    private long eqR;
    private e gER;
    private FrameLayout gES;
    private EditText gET;
    private TextView gEU;
    private TextView gEV;
    private TextView gEW;
    private com.baidu.tieba.frs.gamesubpb.b gEX;
    private com.baidu.tieba.frs.gamesubpb.model.b gEY;
    private List<m> gEZ;
    private com.baidu.tieba.frs.gamesubpb.c gEh;
    private String gEl;
    private FrsGameSubPbActivity gEx;
    private String gFa;
    private View geR;
    private boolean hasMore;
    private View mBack;
    private NavigationBar mNavigationBar;
    private ProgressBar mProgressBar;
    private RelativeLayout mRootView;

    public a(FrsGameSubPbActivity frsGameSubPbActivity, View.OnClickListener onClickListener, String str) {
        this.gEx = frsGameSubPbActivity;
        this.akE = onClickListener;
        this.gEl = str;
        this.mRootView = (RelativeLayout) LayoutInflater.from(frsGameSubPbActivity.getPageContext().getPageActivity()).inflate(R.layout.frs_game_sub_pb_activity, (ViewGroup) null);
        this.ekE = (BdTypeListView) this.mRootView.findViewById(R.id.new_sub_pb_list);
        this.ekE.setOnTouchListener(this.drk);
        this.ekE.setOnScrollListener(new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.frs.gamesubpb.view.a.4
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
                if (i != 0) {
                    l.hideSoftKeyPad(a.this.gEx.getPageContext().getPageActivity(), a.this.gET);
                }
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            }
        });
        this.gER = new e(this.gEx.getPageContext());
        this.geR = BdListViewHelper.a(this.gEx.getActivity(), this.ekE, BdListViewHelper.HeadType.DEFAULT);
        this.gEV = (TextView) this.mRootView.findViewById(R.id.subpb_editor_tool_comment_reply_text);
        this.gEV.setOnClickListener(this.akE);
        this.gEW = (TextView) this.mRootView.findViewById(R.id.no_reply_list_view);
        this.gES = (FrameLayout) this.mRootView.findViewById(R.id.bottom_view);
        this.dzh = (LinearLayout) this.mRootView.findViewById(R.id.subpb_editor_tool_comment_input_container);
        this.gET = (EditText) this.mRootView.findViewById(R.id.subpb_editor_tool_comment_input_edit);
        this.gEU = (TextView) this.mRootView.findViewById(R.id.subpb_editor_tool_comment_send_tv);
        this.gEU.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.gamesubpb.view.a.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.Bq(a.this.gET.getText().toString());
            }
        });
        this.mProgressBar = (ProgressBar) this.mRootView.findViewById(R.id.progressBar);
        bIw();
        this.gEX = new com.baidu.tieba.frs.gamesubpb.b(this.gEx.getPageContext(), this.ekE);
        this.gEX.setClickListener(new a.InterfaceC0508a() { // from class: com.baidu.tieba.frs.gamesubpb.view.a.6
            @Override // com.baidu.tieba.frs.gamesubpb.a.InterfaceC0508a
            public void a(d dVar) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonPolymericActivityConfig(a.this.gEx.getPageContext().getPageActivity()).createNormalConfig(Long.valueOf(dVar.userId).longValue(), String.valueOf(a.this.eqR).equals(dVar.userId), false)));
            }

            @Override // com.baidu.tieba.frs.gamesubpb.a.InterfaceC0508a
            public void b(d dVar) {
                if (dVar != null) {
                    a.this.d(dVar);
                }
            }

            @Override // com.baidu.tieba.frs.gamesubpb.a.InterfaceC0508a
            public void c(d dVar) {
                if (a.this.gEh != null) {
                    a.this.gEh.bIo();
                }
                if (dVar == null) {
                    a.this.Br(null);
                    a.this.bIy();
                    return;
                }
                a.this.Br(dVar.userName);
                a.this.gFa = dVar.userId;
            }
        });
        tH(140);
        bIx();
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        this.gEZ = new ArrayList();
        this.eqR = com.baidu.adp.lib.f.b.toLong(TbadkCoreApplication.getCurrentAccount(), 0L);
    }

    private void bIw() {
        this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(R.id.view_navigation_bar);
        this.mBack = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        ImageView backImageView = this.mNavigationBar.getBackImageView();
        if (backImageView != null && (backImageView.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.mBack.getLayoutParams();
            int dimens = l.getDimens(this.gEx.getPageContext().getPageActivity(), R.dimen.ds30);
            layoutParams.height = dimens;
            layoutParams.width = dimens;
            backImageView.setLayoutParams(layoutParams);
        }
        if (this.mBack != null && (this.mBack.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.mBack.getLayoutParams();
            layoutParams2.width = -2;
            layoutParams2.height = -1;
            this.mBack.setPadding(l.getDimens(this.gEx.getPageContext().getPageActivity(), R.dimen.ds32), this.mBack.getPaddingTop(), this.mBack.getPaddingRight(), this.mBack.getPaddingBottom());
            this.mBack.setLayoutParams(layoutParams2);
        }
        if (this.mNavigationBar.getBackImageView() != null) {
            SvgManager.aGG().a(this.mNavigationBar.getBackImageView(), R.drawable.icon_pure_topbar_return44_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
    }

    private void bIx() {
        this.eiV = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tieba.frs.gamesubpb.view.a.7
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                Rect rect = new Rect();
                a.this.gEx.getPageContext().getPageActivity().getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
                int statusBarHeight = l.getStatusBarHeight(a.this.gEx.getPageContext().getPageActivity());
                int[] screenDimensions = l.getScreenDimensions(a.this.gEx.getPageContext().getPageActivity());
                if (screenDimensions[1] - rect.bottom > screenDimensions[1] / 4 && !a.this.ajG) {
                    a.this.ajG = true;
                    a.this.onKeyboardVisibilityChanged(true);
                } else if (screenDimensions[1] - rect.height() == statusBarHeight && a.this.ajG) {
                    a.this.ajG = false;
                    a.this.onKeyboardVisibilityChanged(false);
                }
            }
        };
        this.gEx.getPageContext().getPageActivity().getWindow().getDecorView().getViewTreeObserver().addOnGlobalLayoutListener(this.eiV);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(final d dVar) {
        final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.gEx.getPageContext().getPageActivity());
        aVar.sR(null);
        aVar.jW(R.string.del_post_confirm);
        aVar.fI(true);
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
        aVar.b(this.gEx.getPageContext()).aEG();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(d dVar) {
        HttpMessage httpMessage = new HttpMessage(1003381);
        httpMessage.addParam("user_id", this.eqR);
        httpMessage.addParam("main_tower_id", dVar.gEN);
        httpMessage.addParam("id", dVar.id);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Bq(String str) {
        tI(0);
        HttpMessage httpMessage = new HttpMessage(1003380);
        httpMessage.addParam("user_id", this.eqR);
        httpMessage.addParam("reply_user_id", this.gFa);
        httpMessage.addParam("content", str);
        httpMessage.addParam("main_tower_id", this.gEl);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bIy() {
        this.gFa = this.gEY != null ? this.gEY.userId : null;
    }

    private void bIz() {
        if (!v.isEmpty(this.gEZ)) {
            this.mNavigationBar.setCenterTextTitle(String.format(this.gEx.getResources().getString(R.string.subpb_floor_reply_count), aq.numFormatOver10000(this.gEZ.size())));
        } else {
            this.mNavigationBar.setCenterTextTitle(this.gEx.getResources().getString(R.string.reply));
        }
    }

    private void tH(final int i) {
        this.gET.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.frs.gamesubpb.view.a.10
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                if (!TextUtils.isEmpty(charSequence)) {
                    a.this.gEU.setEnabled(true);
                    String charSequence2 = charSequence.toString();
                    if (!StringUtils.isNull(charSequence2) && ad.getTextLength(charSequence2) > i) {
                        String subString = ad.subString(charSequence2, 0, i - 1);
                        a.this.gET.setText(subString);
                        a.this.gET.setSelection(a.this.gET.getText().length());
                        UtilHelper.showToast(a.this.gEx.getPageContext().getPageActivity().getApplication(), a.this.gEx.getPageContext().getPageActivity().getResources().getString(R.string.edit_text_over_limit_tip, Integer.valueOf(subString.length())));
                        return;
                    }
                    return;
                }
                a.this.bIy();
                a.this.gEU.setEnabled(false);
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
            }
        });
    }

    private void bIA() {
        if (this.mNavigationBar.getBackImageView() != null) {
            SvgManager.aGG().a(this.mNavigationBar.getBackImageView(), R.drawable.icon_pure_topbar_return44_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lW(final boolean z) {
        if (this.ekE != null) {
            if (!z) {
                this.ekE.setEnabled(z);
            } else {
                this.ekE.postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.gamesubpb.view.a.11
                    @Override // java.lang.Runnable
                    public void run() {
                        a.this.ekE.setEnabled(z);
                    }
                }, 10L);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onKeyboardVisibilityChanged(boolean z) {
        if (z) {
            Rect rect = new Rect();
            this.dzh.getWindowVisibleDisplayFrame(rect);
            this.gES.scrollTo(this.gES.getScrollX(), (l.getScreenDimensions(this.gEx.getPageContext().getPageActivity())[1] - rect.bottom) - (MenuKeyUtils.hasSmartBar() ? l.dip2px(this.gEx.getPageContext().getPageActivity(), 48.0f) : 0));
            return;
        }
        this.gES.setScrollY(0);
    }

    private void lX(boolean z) {
        if (v.isEmpty(this.gEZ)) {
            this.ekE.setNextPage(null);
            this.gEW.setVisibility(0);
        } else {
            this.ekE.setNextPage(this.gER);
            this.gEW.setVisibility(8);
            if (z) {
                this.gER.startLoadData();
            } else {
                this.gER.endLoadData();
            }
        }
        bIz();
    }

    public void a(boolean z, com.baidu.tieba.frs.gamesubpb.model.b bVar, List<m> list) {
        this.hasMore = z;
        this.gEY = bVar;
        bIy();
        if (v.isEmpty(list)) {
            lX(z);
            return;
        }
        this.gEZ.clear();
        this.gEZ.addAll(list);
        this.gEW.setVisibility(8);
        this.ekE.setNextPage(this.gER);
        this.gEX.setData(list);
        bIA();
        this.gEV.setVisibility(0);
        this.gEV.setText(R.string.say_your_point);
        lX(z);
    }

    public void a(boolean z, String str, d dVar) {
        tI(8);
        if (z && dVar != null) {
            BdToast.a(this.gEx.getPageContext().getPageActivity(), this.gEx.getPageContext().getString(R.string.subpb_add_comment_succ_tip), 1).aEL();
            this.gET.setText((CharSequence) null);
            this.gEZ.add(dVar);
            this.gEX.setData(this.gEZ);
            lX(this.hasMore);
            this.gET.post(new Runnable() { // from class: com.baidu.tieba.frs.gamesubpb.view.a.2
                @Override // java.lang.Runnable
                public void run() {
                    a.this.gET.requestFocus();
                    l.hideSoftKeyPad(a.this.gEx.getPageContext().getPageActivity(), a.this.gET);
                }
            });
            return;
        }
        if (TextUtils.isEmpty(str)) {
            str = this.gEx.getPageContext().getString(R.string.subpb_add_comment_fail_tip);
        }
        BdToast.a(this.gEx.getPageContext().getPageActivity(), str, 1).aEL();
    }

    public void b(boolean z, String str, d dVar) {
        if (z) {
            BdToast.a(this.gEx.getPageContext().getPageActivity(), this.gEx.getPageContext().getString(R.string.subpb_delete_comment_succ_tip), 1).aEL();
            this.gEZ.remove(dVar);
            this.gEX.setData(this.gEZ);
            lX(this.hasMore);
            return;
        }
        if (TextUtils.isEmpty(str)) {
            str = this.gEx.getPageContext().getString(R.string.subpb_delete_comment_fail_tip);
        }
        BdToast.a(this.gEx.getPageContext().getPageActivity(), str, 1).aEL();
    }

    public void lY(boolean z) {
        if (this.geR != null && this.geR.getLayoutParams() != null) {
            ViewGroup.LayoutParams layoutParams = this.geR.getLayoutParams();
            if (z) {
                bIA();
                layoutParams.height = l.getDimens(this.gEx.getPageContext().getPageActivity(), R.dimen.ds98);
            } else {
                layoutParams.height = l.getDimens(this.gEx.getPageContext().getPageActivity(), R.dimen.ds98) + UtilHelper.getLightStatusBarHeight();
            }
            this.geR.setLayoutParams(layoutParams);
        }
    }

    public void bT(View view) {
        if (this.geR != null && this.mNavigationBar != null) {
            if (this.mNavigationBar.isNavigationBarExcludeStatusbarVisible()) {
                this.mNavigationBar.showNavigationBarExcludeStatusbar(false);
                if (UtilHelper.canUseStyleImmersiveSticky()) {
                    this.geR.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight()));
                } else if (this.ekE != null) {
                    this.ekE.removeHeaderView(this.geR);
                }
                this.mNavigationBar.setVisibility(8);
                return;
            }
            this.mNavigationBar.showNavigationBarExcludeStatusbar(true);
            if (UtilHelper.canUseStyleImmersiveSticky()) {
                this.geR.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + l.getDimens(this.gEx.getActivity(), R.dimen.ds98)));
            } else if (this.ekE != null) {
                this.ekE.addHeaderView(this.geR, 0);
            }
            this.mNavigationBar.setVisibility(0);
        }
    }

    public void Br(String str) {
        this.gEV.setVisibility(8);
        this.dzh.setVisibility(0);
        this.gET.post(new Runnable() { // from class: com.baidu.tieba.frs.gamesubpb.view.a.3
            @Override // java.lang.Runnable
            public void run() {
                a.this.gET.requestFocus();
                l.showSoftKeyPad(a.this.gEx.getPageContext().getPageActivity(), a.this.gET);
            }
        });
        if (!TextUtils.isEmpty(str)) {
            String format = String.format(this.gEx.getPageContext().getPageActivity().getResources().getString(R.string.reply_sub_floor), str);
            this.gET.setText(format);
            this.gET.setSelection(format.length());
        }
    }

    public void tI(int i) {
        this.mProgressBar.setVisibility(i);
    }

    public View byL() {
        return this.geR;
    }

    public View getRootView() {
        return this.mRootView;
    }

    public ListView getListView() {
        return this.ekE;
    }

    public TextView bIB() {
        return this.gEV;
    }

    public NavigationBar beR() {
        return this.mNavigationBar;
    }

    public void e(com.baidu.tieba.frs.gamesubpb.c cVar) {
        this.gEh = cVar;
    }

    public void b(BdListView.e eVar) {
        this.ekE.setOnSrollToBottomListener(eVar);
    }

    public void onChangeSkinType(int i) {
        this.gEx.getLayoutMode().setNightMode(i == 1);
        this.gEx.getLayoutMode().onModeChanged(this.mRootView);
        am.setBackgroundColor(this.mRootView, R.color.cp_bg_line_d);
        this.mNavigationBar.onChangeSkinType(this.gEx.getPageContext(), i);
        this.gER.changeSkin(i);
        am.setViewTextColor(this.gEV, (int) R.color.cp_cont_e);
        this.gEV.setAlpha(0.95f);
        am.setBackgroundResource(this.gEV, R.drawable.pb_ecomm_comment_bg);
        am.setViewTextColor(this.gEW, (int) R.color.cp_cont_d);
        am.setBackgroundResource(this.dzh, R.drawable.pb_ecomm_comment_bg);
        am.setViewTextColor(this.gET, (int) R.color.cp_cont_f);
        this.gET.setHintTextColor(am.getColor(R.color.cp_cont_e));
        am.setViewTextColor(this.gEU, (int) R.color.game_sub_pb_send_txt_color);
    }

    public void onDestroy() {
        if (this.eiV != null) {
            this.gEx.getPageContext().getPageActivity().getWindow().getDecorView().getViewTreeObserver().removeGlobalOnLayoutListener(this.eiV);
        }
    }
}
