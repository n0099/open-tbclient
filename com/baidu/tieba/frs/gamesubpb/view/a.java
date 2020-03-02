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
    private boolean ajw;
    private View.OnClickListener akt;
    private c dqK = new c(new c.a() { // from class: com.baidu.tieba.frs.gamesubpb.view.a.1
        @Override // com.baidu.tieba.pb.a.c.a
        public boolean onDoubleTap(View view, MotionEvent motionEvent) {
            a.this.lR(false);
            a.this.bT(view);
            a.this.lR(true);
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
    private LinearLayout dyH;
    private ViewTreeObserver.OnGlobalLayoutListener eis;
    private BdTypeListView ekb;
    private long eqi;
    private com.baidu.tieba.frs.gamesubpb.c gCX;
    private e gDH;
    private FrameLayout gDI;
    private EditText gDJ;
    private TextView gDK;
    private TextView gDL;
    private TextView gDM;
    private com.baidu.tieba.frs.gamesubpb.b gDN;
    private com.baidu.tieba.frs.gamesubpb.model.b gDO;
    private List<m> gDP;
    private String gDQ;
    private String gDb;
    private FrsGameSubPbActivity gDn;
    private View gdV;
    private boolean hasMore;
    private View mBack;
    private NavigationBar mNavigationBar;
    private ProgressBar mProgressBar;
    private RelativeLayout mRootView;

    public a(FrsGameSubPbActivity frsGameSubPbActivity, View.OnClickListener onClickListener, String str) {
        this.gDn = frsGameSubPbActivity;
        this.akt = onClickListener;
        this.gDb = str;
        this.mRootView = (RelativeLayout) LayoutInflater.from(frsGameSubPbActivity.getPageContext().getPageActivity()).inflate(R.layout.frs_game_sub_pb_activity, (ViewGroup) null);
        this.ekb = (BdTypeListView) this.mRootView.findViewById(R.id.new_sub_pb_list);
        this.ekb.setOnTouchListener(this.dqK);
        this.ekb.setOnScrollListener(new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.frs.gamesubpb.view.a.4
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
                if (i != 0) {
                    l.hideSoftKeyPad(a.this.gDn.getPageContext().getPageActivity(), a.this.gDJ);
                }
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            }
        });
        this.gDH = new e(this.gDn.getPageContext());
        this.gdV = BdListViewHelper.a(this.gDn.getActivity(), this.ekb, BdListViewHelper.HeadType.DEFAULT);
        this.gDL = (TextView) this.mRootView.findViewById(R.id.subpb_editor_tool_comment_reply_text);
        this.gDL.setOnClickListener(this.akt);
        this.gDM = (TextView) this.mRootView.findViewById(R.id.no_reply_list_view);
        this.gDI = (FrameLayout) this.mRootView.findViewById(R.id.bottom_view);
        this.dyH = (LinearLayout) this.mRootView.findViewById(R.id.subpb_editor_tool_comment_input_container);
        this.gDJ = (EditText) this.mRootView.findViewById(R.id.subpb_editor_tool_comment_input_edit);
        this.gDK = (TextView) this.mRootView.findViewById(R.id.subpb_editor_tool_comment_send_tv);
        this.gDK.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.gamesubpb.view.a.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.Bp(a.this.gDJ.getText().toString());
            }
        });
        this.mProgressBar = (ProgressBar) this.mRootView.findViewById(R.id.progressBar);
        bIj();
        this.gDN = new com.baidu.tieba.frs.gamesubpb.b(this.gDn.getPageContext(), this.ekb);
        this.gDN.setClickListener(new a.InterfaceC0508a() { // from class: com.baidu.tieba.frs.gamesubpb.view.a.6
            @Override // com.baidu.tieba.frs.gamesubpb.a.InterfaceC0508a
            public void a(d dVar) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonPolymericActivityConfig(a.this.gDn.getPageContext().getPageActivity()).createNormalConfig(Long.valueOf(dVar.userId).longValue(), String.valueOf(a.this.eqi).equals(dVar.userId), false)));
            }

            @Override // com.baidu.tieba.frs.gamesubpb.a.InterfaceC0508a
            public void b(d dVar) {
                if (dVar != null) {
                    a.this.d(dVar);
                }
            }

            @Override // com.baidu.tieba.frs.gamesubpb.a.InterfaceC0508a
            public void c(d dVar) {
                if (a.this.gCX != null) {
                    a.this.gCX.bIb();
                }
                if (dVar == null) {
                    a.this.Bq(null);
                    a.this.bIl();
                    return;
                }
                a.this.Bq(dVar.userName);
                a.this.gDQ = dVar.userId;
            }
        });
        tB(140);
        bIk();
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        this.gDP = new ArrayList();
        this.eqi = com.baidu.adp.lib.f.b.toLong(TbadkCoreApplication.getCurrentAccount(), 0L);
    }

    private void bIj() {
        this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(R.id.view_navigation_bar);
        this.mBack = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        ImageView backImageView = this.mNavigationBar.getBackImageView();
        if (backImageView != null && (backImageView.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.mBack.getLayoutParams();
            int dimens = l.getDimens(this.gDn.getPageContext().getPageActivity(), R.dimen.ds30);
            layoutParams.height = dimens;
            layoutParams.width = dimens;
            backImageView.setLayoutParams(layoutParams);
        }
        if (this.mBack != null && (this.mBack.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.mBack.getLayoutParams();
            layoutParams2.width = -2;
            layoutParams2.height = -1;
            this.mBack.setPadding(l.getDimens(this.gDn.getPageContext().getPageActivity(), R.dimen.ds32), this.mBack.getPaddingTop(), this.mBack.getPaddingRight(), this.mBack.getPaddingBottom());
            this.mBack.setLayoutParams(layoutParams2);
        }
        if (this.mNavigationBar.getBackImageView() != null) {
            SvgManager.aGC().a(this.mNavigationBar.getBackImageView(), R.drawable.icon_pure_topbar_return44_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
    }

    private void bIk() {
        this.eis = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tieba.frs.gamesubpb.view.a.7
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                Rect rect = new Rect();
                a.this.gDn.getPageContext().getPageActivity().getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
                int statusBarHeight = l.getStatusBarHeight(a.this.gDn.getPageContext().getPageActivity());
                int[] screenDimensions = l.getScreenDimensions(a.this.gDn.getPageContext().getPageActivity());
                if (screenDimensions[1] - rect.bottom > screenDimensions[1] / 4 && !a.this.ajw) {
                    a.this.ajw = true;
                    a.this.onKeyboardVisibilityChanged(true);
                } else if (screenDimensions[1] - rect.height() == statusBarHeight && a.this.ajw) {
                    a.this.ajw = false;
                    a.this.onKeyboardVisibilityChanged(false);
                }
            }
        };
        this.gDn.getPageContext().getPageActivity().getWindow().getDecorView().getViewTreeObserver().addOnGlobalLayoutListener(this.eis);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(final d dVar) {
        final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.gDn.getPageContext().getPageActivity());
        aVar.sR(null);
        aVar.jW(R.string.del_post_confirm);
        aVar.fH(true);
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
        aVar.b(this.gDn.getPageContext()).aEC();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(d dVar) {
        HttpMessage httpMessage = new HttpMessage(1003381);
        httpMessage.addParam("user_id", this.eqi);
        httpMessage.addParam("main_tower_id", dVar.gDD);
        httpMessage.addParam("id", dVar.id);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Bp(String str) {
        tC(0);
        HttpMessage httpMessage = new HttpMessage(1003380);
        httpMessage.addParam("user_id", this.eqi);
        httpMessage.addParam("reply_user_id", this.gDQ);
        httpMessage.addParam("content", str);
        httpMessage.addParam("main_tower_id", this.gDb);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bIl() {
        this.gDQ = this.gDO != null ? this.gDO.userId : null;
    }

    private void bIm() {
        if (!v.isEmpty(this.gDP)) {
            this.mNavigationBar.setCenterTextTitle(String.format(this.gDn.getResources().getString(R.string.subpb_floor_reply_count), aq.numFormatOver10000(this.gDP.size())));
        } else {
            this.mNavigationBar.setCenterTextTitle(this.gDn.getResources().getString(R.string.reply));
        }
    }

    private void tB(final int i) {
        this.gDJ.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.frs.gamesubpb.view.a.10
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                if (!TextUtils.isEmpty(charSequence)) {
                    a.this.gDK.setEnabled(true);
                    String charSequence2 = charSequence.toString();
                    if (!StringUtils.isNull(charSequence2) && ad.getTextLength(charSequence2) > i) {
                        String subString = ad.subString(charSequence2, 0, i - 1);
                        a.this.gDJ.setText(subString);
                        a.this.gDJ.setSelection(a.this.gDJ.getText().length());
                        UtilHelper.showToast(a.this.gDn.getPageContext().getPageActivity().getApplication(), a.this.gDn.getPageContext().getPageActivity().getResources().getString(R.string.edit_text_over_limit_tip, Integer.valueOf(subString.length())));
                        return;
                    }
                    return;
                }
                a.this.bIl();
                a.this.gDK.setEnabled(false);
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
            }
        });
    }

    private void bIn() {
        if (this.mNavigationBar.getBackImageView() != null) {
            SvgManager.aGC().a(this.mNavigationBar.getBackImageView(), R.drawable.icon_pure_topbar_return44_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lR(final boolean z) {
        if (this.ekb != null) {
            if (!z) {
                this.ekb.setEnabled(z);
            } else {
                this.ekb.postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.gamesubpb.view.a.11
                    @Override // java.lang.Runnable
                    public void run() {
                        a.this.ekb.setEnabled(z);
                    }
                }, 10L);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onKeyboardVisibilityChanged(boolean z) {
        if (z) {
            Rect rect = new Rect();
            this.dyH.getWindowVisibleDisplayFrame(rect);
            this.gDI.scrollTo(this.gDI.getScrollX(), (l.getScreenDimensions(this.gDn.getPageContext().getPageActivity())[1] - rect.bottom) - (MenuKeyUtils.hasSmartBar() ? l.dip2px(this.gDn.getPageContext().getPageActivity(), 48.0f) : 0));
            return;
        }
        this.gDI.setScrollY(0);
    }

    private void lS(boolean z) {
        if (v.isEmpty(this.gDP)) {
            this.ekb.setNextPage(null);
            this.gDM.setVisibility(0);
        } else {
            this.ekb.setNextPage(this.gDH);
            this.gDM.setVisibility(8);
            if (z) {
                this.gDH.startLoadData();
            } else {
                this.gDH.endLoadData();
            }
        }
        bIm();
    }

    public void a(boolean z, com.baidu.tieba.frs.gamesubpb.model.b bVar, List<m> list) {
        this.hasMore = z;
        this.gDO = bVar;
        bIl();
        if (v.isEmpty(list)) {
            lS(z);
            return;
        }
        this.gDP.clear();
        this.gDP.addAll(list);
        this.gDM.setVisibility(8);
        this.ekb.setNextPage(this.gDH);
        this.gDN.setData(list);
        bIn();
        this.gDL.setVisibility(0);
        this.gDL.setText(R.string.say_your_point);
        lS(z);
    }

    public void a(boolean z, String str, d dVar) {
        tC(8);
        if (z && dVar != null) {
            BdToast.a(this.gDn.getPageContext().getPageActivity(), this.gDn.getPageContext().getString(R.string.subpb_add_comment_succ_tip), 1).aEH();
            this.gDJ.setText((CharSequence) null);
            this.gDP.add(dVar);
            this.gDN.setData(this.gDP);
            lS(this.hasMore);
            this.gDJ.post(new Runnable() { // from class: com.baidu.tieba.frs.gamesubpb.view.a.2
                @Override // java.lang.Runnable
                public void run() {
                    a.this.gDJ.requestFocus();
                    l.hideSoftKeyPad(a.this.gDn.getPageContext().getPageActivity(), a.this.gDJ);
                }
            });
            return;
        }
        if (TextUtils.isEmpty(str)) {
            str = this.gDn.getPageContext().getString(R.string.subpb_add_comment_fail_tip);
        }
        BdToast.a(this.gDn.getPageContext().getPageActivity(), str, 1).aEH();
    }

    public void b(boolean z, String str, d dVar) {
        if (z) {
            BdToast.a(this.gDn.getPageContext().getPageActivity(), this.gDn.getPageContext().getString(R.string.subpb_delete_comment_succ_tip), 1).aEH();
            this.gDP.remove(dVar);
            this.gDN.setData(this.gDP);
            lS(this.hasMore);
            return;
        }
        if (TextUtils.isEmpty(str)) {
            str = this.gDn.getPageContext().getString(R.string.subpb_delete_comment_fail_tip);
        }
        BdToast.a(this.gDn.getPageContext().getPageActivity(), str, 1).aEH();
    }

    public void lT(boolean z) {
        if (this.gdV != null && this.gdV.getLayoutParams() != null) {
            ViewGroup.LayoutParams layoutParams = this.gdV.getLayoutParams();
            if (z) {
                bIn();
                layoutParams.height = l.getDimens(this.gDn.getPageContext().getPageActivity(), R.dimen.ds98);
            } else {
                layoutParams.height = l.getDimens(this.gDn.getPageContext().getPageActivity(), R.dimen.ds98) + UtilHelper.getLightStatusBarHeight();
            }
            this.gdV.setLayoutParams(layoutParams);
        }
    }

    public void bT(View view) {
        if (this.gdV != null && this.mNavigationBar != null) {
            if (this.mNavigationBar.isNavigationBarExcludeStatusbarVisible()) {
                this.mNavigationBar.showNavigationBarExcludeStatusbar(false);
                if (UtilHelper.canUseStyleImmersiveSticky()) {
                    this.gdV.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight()));
                } else if (this.ekb != null) {
                    this.ekb.removeHeaderView(this.gdV);
                }
                this.mNavigationBar.setVisibility(8);
                return;
            }
            this.mNavigationBar.showNavigationBarExcludeStatusbar(true);
            if (UtilHelper.canUseStyleImmersiveSticky()) {
                this.gdV.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + l.getDimens(this.gDn.getActivity(), R.dimen.ds98)));
            } else if (this.ekb != null) {
                this.ekb.addHeaderView(this.gdV, 0);
            }
            this.mNavigationBar.setVisibility(0);
        }
    }

    public void Bq(String str) {
        this.gDL.setVisibility(8);
        this.dyH.setVisibility(0);
        this.gDJ.post(new Runnable() { // from class: com.baidu.tieba.frs.gamesubpb.view.a.3
            @Override // java.lang.Runnable
            public void run() {
                a.this.gDJ.requestFocus();
                l.showSoftKeyPad(a.this.gDn.getPageContext().getPageActivity(), a.this.gDJ);
            }
        });
        if (!TextUtils.isEmpty(str)) {
            String format = String.format(this.gDn.getPageContext().getPageActivity().getResources().getString(R.string.reply_sub_floor), str);
            this.gDJ.setText(format);
            this.gDJ.setSelection(format.length());
        }
    }

    public void tC(int i) {
        this.mProgressBar.setVisibility(i);
    }

    public View byE() {
        return this.gdV;
    }

    public View getRootView() {
        return this.mRootView;
    }

    public ListView getListView() {
        return this.ekb;
    }

    public TextView bIo() {
        return this.gDL;
    }

    public NavigationBar beL() {
        return this.mNavigationBar;
    }

    public void e(com.baidu.tieba.frs.gamesubpb.c cVar) {
        this.gCX = cVar;
    }

    public void b(BdListView.e eVar) {
        this.ekb.setOnSrollToBottomListener(eVar);
    }

    public void onChangeSkinType(int i) {
        this.gDn.getLayoutMode().setNightMode(i == 1);
        this.gDn.getLayoutMode().onModeChanged(this.mRootView);
        am.setBackgroundColor(this.mRootView, R.color.cp_bg_line_d);
        this.mNavigationBar.onChangeSkinType(this.gDn.getPageContext(), i);
        this.gDH.changeSkin(i);
        am.setViewTextColor(this.gDL, (int) R.color.cp_cont_e);
        this.gDL.setAlpha(0.95f);
        am.setBackgroundResource(this.gDL, R.drawable.pb_ecomm_comment_bg);
        am.setViewTextColor(this.gDM, (int) R.color.cp_cont_d);
        am.setBackgroundResource(this.dyH, R.drawable.pb_ecomm_comment_bg);
        am.setViewTextColor(this.gDJ, (int) R.color.cp_cont_f);
        this.gDJ.setHintTextColor(am.getColor(R.color.cp_cont_e));
        am.setViewTextColor(this.gDK, (int) R.color.game_sub_pb_send_txt_color);
    }

    public void onDestroy() {
        if (this.eis != null) {
            this.gDn.getPageContext().getPageActivity().getWindow().getDecorView().getViewTreeObserver().removeGlobalOnLayoutListener(this.eis);
        }
    }
}
