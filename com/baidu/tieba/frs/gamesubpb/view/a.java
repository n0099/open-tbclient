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
    private View.OnClickListener aku;
    private c dqX = new c(new c.a() { // from class: com.baidu.tieba.frs.gamesubpb.view.a.1
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
    private LinearLayout dyU;
    private ViewTreeObserver.OnGlobalLayoutListener eiF;
    private BdTypeListView eko;
    private long eqv;
    private e gDT;
    private FrameLayout gDU;
    private EditText gDV;
    private TextView gDW;
    private TextView gDX;
    private TextView gDY;
    private com.baidu.tieba.frs.gamesubpb.b gDZ;
    private com.baidu.tieba.frs.gamesubpb.c gDj;
    private String gDn;
    private FrsGameSubPbActivity gDz;
    private com.baidu.tieba.frs.gamesubpb.model.b gEa;
    private List<m> gEb;
    private String gEc;
    private View gei;
    private boolean hasMore;
    private View mBack;
    private NavigationBar mNavigationBar;
    private ProgressBar mProgressBar;
    private RelativeLayout mRootView;

    public a(FrsGameSubPbActivity frsGameSubPbActivity, View.OnClickListener onClickListener, String str) {
        this.gDz = frsGameSubPbActivity;
        this.aku = onClickListener;
        this.gDn = str;
        this.mRootView = (RelativeLayout) LayoutInflater.from(frsGameSubPbActivity.getPageContext().getPageActivity()).inflate(R.layout.frs_game_sub_pb_activity, (ViewGroup) null);
        this.eko = (BdTypeListView) this.mRootView.findViewById(R.id.new_sub_pb_list);
        this.eko.setOnTouchListener(this.dqX);
        this.eko.setOnScrollListener(new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.frs.gamesubpb.view.a.4
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
                if (i != 0) {
                    l.hideSoftKeyPad(a.this.gDz.getPageContext().getPageActivity(), a.this.gDV);
                }
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            }
        });
        this.gDT = new e(this.gDz.getPageContext());
        this.gei = BdListViewHelper.a(this.gDz.getActivity(), this.eko, BdListViewHelper.HeadType.DEFAULT);
        this.gDX = (TextView) this.mRootView.findViewById(R.id.subpb_editor_tool_comment_reply_text);
        this.gDX.setOnClickListener(this.aku);
        this.gDY = (TextView) this.mRootView.findViewById(R.id.no_reply_list_view);
        this.gDU = (FrameLayout) this.mRootView.findViewById(R.id.bottom_view);
        this.dyU = (LinearLayout) this.mRootView.findViewById(R.id.subpb_editor_tool_comment_input_container);
        this.gDV = (EditText) this.mRootView.findViewById(R.id.subpb_editor_tool_comment_input_edit);
        this.gDW = (TextView) this.mRootView.findViewById(R.id.subpb_editor_tool_comment_send_tv);
        this.gDW.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.gamesubpb.view.a.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.Bq(a.this.gDV.getText().toString());
            }
        });
        this.mProgressBar = (ProgressBar) this.mRootView.findViewById(R.id.progressBar);
        bIk();
        this.gDZ = new com.baidu.tieba.frs.gamesubpb.b(this.gDz.getPageContext(), this.eko);
        this.gDZ.setClickListener(new a.InterfaceC0508a() { // from class: com.baidu.tieba.frs.gamesubpb.view.a.6
            @Override // com.baidu.tieba.frs.gamesubpb.a.InterfaceC0508a
            public void a(d dVar) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonPolymericActivityConfig(a.this.gDz.getPageContext().getPageActivity()).createNormalConfig(Long.valueOf(dVar.userId).longValue(), String.valueOf(a.this.eqv).equals(dVar.userId), false)));
            }

            @Override // com.baidu.tieba.frs.gamesubpb.a.InterfaceC0508a
            public void b(d dVar) {
                if (dVar != null) {
                    a.this.d(dVar);
                }
            }

            @Override // com.baidu.tieba.frs.gamesubpb.a.InterfaceC0508a
            public void c(d dVar) {
                if (a.this.gDj != null) {
                    a.this.gDj.bIc();
                }
                if (dVar == null) {
                    a.this.Br(null);
                    a.this.bIm();
                    return;
                }
                a.this.Br(dVar.userName);
                a.this.gEc = dVar.userId;
            }
        });
        tB(140);
        bIl();
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        this.gEb = new ArrayList();
        this.eqv = com.baidu.adp.lib.f.b.toLong(TbadkCoreApplication.getCurrentAccount(), 0L);
    }

    private void bIk() {
        this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(R.id.view_navigation_bar);
        this.mBack = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        ImageView backImageView = this.mNavigationBar.getBackImageView();
        if (backImageView != null && (backImageView.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.mBack.getLayoutParams();
            int dimens = l.getDimens(this.gDz.getPageContext().getPageActivity(), R.dimen.ds30);
            layoutParams.height = dimens;
            layoutParams.width = dimens;
            backImageView.setLayoutParams(layoutParams);
        }
        if (this.mBack != null && (this.mBack.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.mBack.getLayoutParams();
            layoutParams2.width = -2;
            layoutParams2.height = -1;
            this.mBack.setPadding(l.getDimens(this.gDz.getPageContext().getPageActivity(), R.dimen.ds32), this.mBack.getPaddingTop(), this.mBack.getPaddingRight(), this.mBack.getPaddingBottom());
            this.mBack.setLayoutParams(layoutParams2);
        }
        if (this.mNavigationBar.getBackImageView() != null) {
            SvgManager.aGC().a(this.mNavigationBar.getBackImageView(), R.drawable.icon_pure_topbar_return44_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
    }

    private void bIl() {
        this.eiF = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tieba.frs.gamesubpb.view.a.7
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                Rect rect = new Rect();
                a.this.gDz.getPageContext().getPageActivity().getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
                int statusBarHeight = l.getStatusBarHeight(a.this.gDz.getPageContext().getPageActivity());
                int[] screenDimensions = l.getScreenDimensions(a.this.gDz.getPageContext().getPageActivity());
                if (screenDimensions[1] - rect.bottom > screenDimensions[1] / 4 && !a.this.ajw) {
                    a.this.ajw = true;
                    a.this.onKeyboardVisibilityChanged(true);
                } else if (screenDimensions[1] - rect.height() == statusBarHeight && a.this.ajw) {
                    a.this.ajw = false;
                    a.this.onKeyboardVisibilityChanged(false);
                }
            }
        };
        this.gDz.getPageContext().getPageActivity().getWindow().getDecorView().getViewTreeObserver().addOnGlobalLayoutListener(this.eiF);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(final d dVar) {
        final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.gDz.getPageContext().getPageActivity());
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
        aVar.b(this.gDz.getPageContext()).aEC();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(d dVar) {
        HttpMessage httpMessage = new HttpMessage(1003381);
        httpMessage.addParam("user_id", this.eqv);
        httpMessage.addParam("main_tower_id", dVar.gDP);
        httpMessage.addParam("id", dVar.id);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Bq(String str) {
        tC(0);
        HttpMessage httpMessage = new HttpMessage(1003380);
        httpMessage.addParam("user_id", this.eqv);
        httpMessage.addParam("reply_user_id", this.gEc);
        httpMessage.addParam("content", str);
        httpMessage.addParam("main_tower_id", this.gDn);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bIm() {
        this.gEc = this.gEa != null ? this.gEa.userId : null;
    }

    private void bIn() {
        if (!v.isEmpty(this.gEb)) {
            this.mNavigationBar.setCenterTextTitle(String.format(this.gDz.getResources().getString(R.string.subpb_floor_reply_count), aq.numFormatOver10000(this.gEb.size())));
        } else {
            this.mNavigationBar.setCenterTextTitle(this.gDz.getResources().getString(R.string.reply));
        }
    }

    private void tB(final int i) {
        this.gDV.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.frs.gamesubpb.view.a.10
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                if (!TextUtils.isEmpty(charSequence)) {
                    a.this.gDW.setEnabled(true);
                    String charSequence2 = charSequence.toString();
                    if (!StringUtils.isNull(charSequence2) && ad.getTextLength(charSequence2) > i) {
                        String subString = ad.subString(charSequence2, 0, i - 1);
                        a.this.gDV.setText(subString);
                        a.this.gDV.setSelection(a.this.gDV.getText().length());
                        UtilHelper.showToast(a.this.gDz.getPageContext().getPageActivity().getApplication(), a.this.gDz.getPageContext().getPageActivity().getResources().getString(R.string.edit_text_over_limit_tip, Integer.valueOf(subString.length())));
                        return;
                    }
                    return;
                }
                a.this.bIm();
                a.this.gDW.setEnabled(false);
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
            }
        });
    }

    private void bIo() {
        if (this.mNavigationBar.getBackImageView() != null) {
            SvgManager.aGC().a(this.mNavigationBar.getBackImageView(), R.drawable.icon_pure_topbar_return44_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lR(final boolean z) {
        if (this.eko != null) {
            if (!z) {
                this.eko.setEnabled(z);
            } else {
                this.eko.postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.gamesubpb.view.a.11
                    @Override // java.lang.Runnable
                    public void run() {
                        a.this.eko.setEnabled(z);
                    }
                }, 10L);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onKeyboardVisibilityChanged(boolean z) {
        if (z) {
            Rect rect = new Rect();
            this.dyU.getWindowVisibleDisplayFrame(rect);
            this.gDU.scrollTo(this.gDU.getScrollX(), (l.getScreenDimensions(this.gDz.getPageContext().getPageActivity())[1] - rect.bottom) - (MenuKeyUtils.hasSmartBar() ? l.dip2px(this.gDz.getPageContext().getPageActivity(), 48.0f) : 0));
            return;
        }
        this.gDU.setScrollY(0);
    }

    private void lS(boolean z) {
        if (v.isEmpty(this.gEb)) {
            this.eko.setNextPage(null);
            this.gDY.setVisibility(0);
        } else {
            this.eko.setNextPage(this.gDT);
            this.gDY.setVisibility(8);
            if (z) {
                this.gDT.startLoadData();
            } else {
                this.gDT.endLoadData();
            }
        }
        bIn();
    }

    public void a(boolean z, com.baidu.tieba.frs.gamesubpb.model.b bVar, List<m> list) {
        this.hasMore = z;
        this.gEa = bVar;
        bIm();
        if (v.isEmpty(list)) {
            lS(z);
            return;
        }
        this.gEb.clear();
        this.gEb.addAll(list);
        this.gDY.setVisibility(8);
        this.eko.setNextPage(this.gDT);
        this.gDZ.setData(list);
        bIo();
        this.gDX.setVisibility(0);
        this.gDX.setText(R.string.say_your_point);
        lS(z);
    }

    public void a(boolean z, String str, d dVar) {
        tC(8);
        if (z && dVar != null) {
            BdToast.a(this.gDz.getPageContext().getPageActivity(), this.gDz.getPageContext().getString(R.string.subpb_add_comment_succ_tip), 1).aEH();
            this.gDV.setText((CharSequence) null);
            this.gEb.add(dVar);
            this.gDZ.setData(this.gEb);
            lS(this.hasMore);
            this.gDV.post(new Runnable() { // from class: com.baidu.tieba.frs.gamesubpb.view.a.2
                @Override // java.lang.Runnable
                public void run() {
                    a.this.gDV.requestFocus();
                    l.hideSoftKeyPad(a.this.gDz.getPageContext().getPageActivity(), a.this.gDV);
                }
            });
            return;
        }
        if (TextUtils.isEmpty(str)) {
            str = this.gDz.getPageContext().getString(R.string.subpb_add_comment_fail_tip);
        }
        BdToast.a(this.gDz.getPageContext().getPageActivity(), str, 1).aEH();
    }

    public void b(boolean z, String str, d dVar) {
        if (z) {
            BdToast.a(this.gDz.getPageContext().getPageActivity(), this.gDz.getPageContext().getString(R.string.subpb_delete_comment_succ_tip), 1).aEH();
            this.gEb.remove(dVar);
            this.gDZ.setData(this.gEb);
            lS(this.hasMore);
            return;
        }
        if (TextUtils.isEmpty(str)) {
            str = this.gDz.getPageContext().getString(R.string.subpb_delete_comment_fail_tip);
        }
        BdToast.a(this.gDz.getPageContext().getPageActivity(), str, 1).aEH();
    }

    public void lT(boolean z) {
        if (this.gei != null && this.gei.getLayoutParams() != null) {
            ViewGroup.LayoutParams layoutParams = this.gei.getLayoutParams();
            if (z) {
                bIo();
                layoutParams.height = l.getDimens(this.gDz.getPageContext().getPageActivity(), R.dimen.ds98);
            } else {
                layoutParams.height = l.getDimens(this.gDz.getPageContext().getPageActivity(), R.dimen.ds98) + UtilHelper.getLightStatusBarHeight();
            }
            this.gei.setLayoutParams(layoutParams);
        }
    }

    public void bT(View view) {
        if (this.gei != null && this.mNavigationBar != null) {
            if (this.mNavigationBar.isNavigationBarExcludeStatusbarVisible()) {
                this.mNavigationBar.showNavigationBarExcludeStatusbar(false);
                if (UtilHelper.canUseStyleImmersiveSticky()) {
                    this.gei.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight()));
                } else if (this.eko != null) {
                    this.eko.removeHeaderView(this.gei);
                }
                this.mNavigationBar.setVisibility(8);
                return;
            }
            this.mNavigationBar.showNavigationBarExcludeStatusbar(true);
            if (UtilHelper.canUseStyleImmersiveSticky()) {
                this.gei.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + l.getDimens(this.gDz.getActivity(), R.dimen.ds98)));
            } else if (this.eko != null) {
                this.eko.addHeaderView(this.gei, 0);
            }
            this.mNavigationBar.setVisibility(0);
        }
    }

    public void Br(String str) {
        this.gDX.setVisibility(8);
        this.dyU.setVisibility(0);
        this.gDV.post(new Runnable() { // from class: com.baidu.tieba.frs.gamesubpb.view.a.3
            @Override // java.lang.Runnable
            public void run() {
                a.this.gDV.requestFocus();
                l.showSoftKeyPad(a.this.gDz.getPageContext().getPageActivity(), a.this.gDV);
            }
        });
        if (!TextUtils.isEmpty(str)) {
            String format = String.format(this.gDz.getPageContext().getPageActivity().getResources().getString(R.string.reply_sub_floor), str);
            this.gDV.setText(format);
            this.gDV.setSelection(format.length());
        }
    }

    public void tC(int i) {
        this.mProgressBar.setVisibility(i);
    }

    public View byF() {
        return this.gei;
    }

    public View getRootView() {
        return this.mRootView;
    }

    public ListView getListView() {
        return this.eko;
    }

    public TextView bIp() {
        return this.gDX;
    }

    public NavigationBar beM() {
        return this.mNavigationBar;
    }

    public void e(com.baidu.tieba.frs.gamesubpb.c cVar) {
        this.gDj = cVar;
    }

    public void b(BdListView.e eVar) {
        this.eko.setOnSrollToBottomListener(eVar);
    }

    public void onChangeSkinType(int i) {
        this.gDz.getLayoutMode().setNightMode(i == 1);
        this.gDz.getLayoutMode().onModeChanged(this.mRootView);
        am.setBackgroundColor(this.mRootView, R.color.cp_bg_line_d);
        this.mNavigationBar.onChangeSkinType(this.gDz.getPageContext(), i);
        this.gDT.changeSkin(i);
        am.setViewTextColor(this.gDX, (int) R.color.cp_cont_e);
        this.gDX.setAlpha(0.95f);
        am.setBackgroundResource(this.gDX, R.drawable.pb_ecomm_comment_bg);
        am.setViewTextColor(this.gDY, (int) R.color.cp_cont_d);
        am.setBackgroundResource(this.dyU, R.drawable.pb_ecomm_comment_bg);
        am.setViewTextColor(this.gDV, (int) R.color.cp_cont_f);
        this.gDV.setHintTextColor(am.getColor(R.color.cp_cont_e));
        am.setViewTextColor(this.gDW, (int) R.color.game_sub_pb_send_txt_color);
    }

    public void onDestroy() {
        if (this.eiF != null) {
            this.gDz.getPageContext().getPageActivity().getWindow().getDecorView().getViewTreeObserver().removeGlobalOnLayoutListener(this.eiF);
        }
    }
}
