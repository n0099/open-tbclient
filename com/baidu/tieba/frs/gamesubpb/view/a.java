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
    private View.OnClickListener aXk;
    private c eTx = new c(new c.a() { // from class: com.baidu.tieba.frs.gamesubpb.view.a.1
        @Override // com.baidu.tieba.pb.a.c.a
        public boolean onDoubleTap(View view, MotionEvent motionEvent) {
            a.this.pD(false);
            a.this.cx(view);
            a.this.pD(true);
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
    private BdTypeListView fSo;
    private long fYK;
    private LinearLayout fbM;
    private ViewTreeObserver.OnGlobalLayoutListener globalListener;
    private boolean hasMore;
    private com.baidu.tieba.frs.gamesubpb.c iGB;
    private String iGF;
    private FrsGameSubPbActivity iGR;
    private e iHl;
    private FrameLayout iHm;
    private EditText iHn;
    private TextView iHo;
    private TextView iHp;
    private TextView iHq;
    private com.baidu.tieba.frs.gamesubpb.b iHr;
    private com.baidu.tieba.frs.gamesubpb.model.b iHs;
    private List<q> iHt;
    private String iHu;
    private View ieu;
    private View mBack;
    private boolean mIsKeyboardOpen;
    private NavigationBar mNavigationBar;
    private ProgressBar mProgressBar;
    private RelativeLayout mRootView;

    public a(FrsGameSubPbActivity frsGameSubPbActivity, View.OnClickListener onClickListener, String str) {
        this.iGR = frsGameSubPbActivity;
        this.aXk = onClickListener;
        this.iGF = str;
        this.mRootView = (RelativeLayout) LayoutInflater.from(frsGameSubPbActivity.getPageContext().getPageActivity()).inflate(R.layout.frs_game_sub_pb_activity, (ViewGroup) null);
        this.fSo = (BdTypeListView) this.mRootView.findViewById(R.id.new_sub_pb_list);
        this.fSo.setOnTouchListener(this.eTx);
        this.fSo.setOnScrollListener(new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.frs.gamesubpb.view.a.4
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
                if (i != 0) {
                    l.hideSoftKeyPad(a.this.iGR.getPageContext().getPageActivity(), a.this.iHn);
                }
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            }
        });
        this.iHl = new e(this.iGR.getPageContext());
        this.ieu = BdListViewHelper.a(this.iGR.getActivity(), this.fSo, BdListViewHelper.HeadType.DEFAULT);
        this.iHp = (TextView) this.mRootView.findViewById(R.id.subpb_editor_tool_comment_reply_text);
        this.iHp.setOnClickListener(this.aXk);
        this.iHq = (TextView) this.mRootView.findViewById(R.id.no_reply_list_view);
        this.iHm = (FrameLayout) this.mRootView.findViewById(R.id.bottom_view);
        this.fbM = (LinearLayout) this.mRootView.findViewById(R.id.subpb_editor_tool_comment_input_container);
        this.iHn = (EditText) this.mRootView.findViewById(R.id.subpb_editor_tool_comment_input_edit);
        this.iHo = (TextView) this.mRootView.findViewById(R.id.subpb_editor_tool_comment_send_tv);
        this.iHo.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.gamesubpb.view.a.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.JM(a.this.iHn.getText().toString());
            }
        });
        this.mProgressBar = (ProgressBar) this.mRootView.findViewById(R.id.progressBar);
        cxz();
        this.iHr = new com.baidu.tieba.frs.gamesubpb.b(this.iGR.getPageContext(), this.fSo);
        this.iHr.setClickListener(new a.InterfaceC0700a() { // from class: com.baidu.tieba.frs.gamesubpb.view.a.6
            @Override // com.baidu.tieba.frs.gamesubpb.a.InterfaceC0700a
            public void a(d dVar) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonPolymericActivityConfig(a.this.iGR.getPageContext().getPageActivity()).createNormalConfig(Long.valueOf(dVar.userId).longValue(), String.valueOf(a.this.fYK).equals(dVar.userId), false)));
            }

            @Override // com.baidu.tieba.frs.gamesubpb.a.InterfaceC0700a
            public void b(d dVar) {
                if (dVar != null) {
                    a.this.d(dVar);
                }
            }

            @Override // com.baidu.tieba.frs.gamesubpb.a.InterfaceC0700a
            public void c(d dVar) {
                if (a.this.iGB != null) {
                    a.this.iGB.cxs();
                }
                if (dVar == null) {
                    a.this.JN(null);
                    a.this.cxB();
                    return;
                }
                a.this.JN(dVar.userName);
                a.this.iHu = dVar.userId;
            }
        });
        zh(140);
        cxA();
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        this.iHt = new ArrayList();
        this.fYK = com.baidu.adp.lib.f.b.toLong(TbadkCoreApplication.getCurrentAccount(), 0L);
    }

    private void cxz() {
        this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(R.id.view_navigation_bar);
        this.mBack = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        ImageView backImageView = this.mNavigationBar.getBackImageView();
        if (backImageView != null && (backImageView.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.mBack.getLayoutParams();
            int dimens = l.getDimens(this.iGR.getPageContext().getPageActivity(), R.dimen.ds30);
            layoutParams.height = dimens;
            layoutParams.width = dimens;
            backImageView.setLayoutParams(layoutParams);
        }
        if (this.mBack != null && (this.mBack.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.mBack.getLayoutParams();
            layoutParams2.width = -2;
            layoutParams2.height = -1;
            this.mBack.setPadding(l.getDimens(this.iGR.getPageContext().getPageActivity(), R.dimen.ds32), this.mBack.getPaddingTop(), this.mBack.getPaddingRight(), this.mBack.getPaddingBottom());
            this.mBack.setLayoutParams(layoutParams2);
        }
        if (this.mNavigationBar.getBackImageView() != null) {
            SvgManager.bmU().a(this.mNavigationBar.getBackImageView(), R.drawable.icon_pure_topbar_return44_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
    }

    private void cxA() {
        this.globalListener = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tieba.frs.gamesubpb.view.a.7
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                Rect rect = new Rect();
                a.this.iGR.getPageContext().getPageActivity().getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
                int statusBarHeight = l.getStatusBarHeight(a.this.iGR.getPageContext().getPageActivity());
                int[] screenDimensions = l.getScreenDimensions(a.this.iGR.getPageContext().getPageActivity());
                if (screenDimensions[1] - rect.bottom > screenDimensions[1] / 4 && !a.this.mIsKeyboardOpen) {
                    a.this.mIsKeyboardOpen = true;
                    a.this.onKeyboardVisibilityChanged(true);
                } else if (screenDimensions[1] - rect.height() == statusBarHeight && a.this.mIsKeyboardOpen) {
                    a.this.mIsKeyboardOpen = false;
                    a.this.onKeyboardVisibilityChanged(false);
                }
            }
        };
        this.iGR.getPageContext().getPageActivity().getWindow().getDecorView().getViewTreeObserver().addOnGlobalLayoutListener(this.globalListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(final d dVar) {
        final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.iGR.getPageContext().getPageActivity());
        aVar.AG(null);
        aVar.ob(R.string.del_post_confirm);
        aVar.iA(true);
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
        aVar.b(this.iGR.getPageContext()).bkJ();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(d dVar) {
        HttpMessage httpMessage = new HttpMessage(1003381);
        httpMessage.addParam("user_id", this.fYK);
        httpMessage.addParam("main_tower_id", dVar.iHh);
        httpMessage.addParam("id", dVar.id);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JM(String str) {
        zi(0);
        HttpMessage httpMessage = new HttpMessage(1003380);
        httpMessage.addParam("user_id", this.fYK);
        httpMessage.addParam("reply_user_id", this.iHu);
        httpMessage.addParam("content", str);
        httpMessage.addParam("main_tower_id", this.iGF);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cxB() {
        this.iHu = this.iHs != null ? this.iHs.userId : null;
    }

    private void cxC() {
        if (!y.isEmpty(this.iHt)) {
            this.mNavigationBar.setCenterTextTitle(String.format(this.iGR.getResources().getString(R.string.subpb_floor_reply_count), at.numFormatOver10000(this.iHt.size())));
        } else {
            this.mNavigationBar.setCenterTextTitle(this.iGR.getResources().getString(R.string.reply));
        }
    }

    private void zh(final int i) {
        this.iHn.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.frs.gamesubpb.view.a.10
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                if (!TextUtils.isEmpty(charSequence)) {
                    a.this.iHo.setEnabled(true);
                    String charSequence2 = charSequence.toString();
                    if (!StringUtils.isNull(charSequence2) && af.getTextLength(charSequence2) > i) {
                        String subString = af.subString(charSequence2, 0, i - 1);
                        a.this.iHn.setText(subString);
                        a.this.iHn.setSelection(a.this.iHn.getText().length());
                        UtilHelper.showToast(a.this.iGR.getPageContext().getPageActivity().getApplication(), a.this.iGR.getPageContext().getPageActivity().getResources().getString(R.string.edit_text_over_limit_tip, Integer.valueOf(subString.length())));
                        return;
                    }
                    return;
                }
                a.this.cxB();
                a.this.iHo.setEnabled(false);
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
            }
        });
    }

    private void cxD() {
        if (this.mNavigationBar.getBackImageView() != null) {
            SvgManager.bmU().a(this.mNavigationBar.getBackImageView(), R.drawable.icon_pure_topbar_return44_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pD(final boolean z) {
        if (this.fSo != null) {
            if (!z) {
                this.fSo.setEnabled(z);
            } else {
                this.fSo.postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.gamesubpb.view.a.11
                    @Override // java.lang.Runnable
                    public void run() {
                        a.this.fSo.setEnabled(z);
                    }
                }, 10L);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onKeyboardVisibilityChanged(boolean z) {
        if (z) {
            Rect rect = new Rect();
            this.fbM.getWindowVisibleDisplayFrame(rect);
            this.iHm.scrollTo(this.iHm.getScrollX(), (l.getScreenDimensions(this.iGR.getPageContext().getPageActivity())[1] - rect.bottom) - (MenuKeyUtils.hasSmartBar() ? l.dip2px(this.iGR.getPageContext().getPageActivity(), 48.0f) : 0));
            return;
        }
        this.iHm.setScrollY(0);
    }

    private void pE(boolean z) {
        if (y.isEmpty(this.iHt)) {
            this.fSo.setNextPage(null);
            this.iHq.setVisibility(0);
        } else {
            this.fSo.setNextPage(this.iHl);
            this.iHq.setVisibility(8);
            if (z) {
                this.iHl.startLoadData();
            } else {
                this.iHl.endLoadData();
            }
        }
        cxC();
    }

    public void a(boolean z, com.baidu.tieba.frs.gamesubpb.model.b bVar, List<q> list) {
        this.hasMore = z;
        this.iHs = bVar;
        cxB();
        if (y.isEmpty(list)) {
            pE(z);
            return;
        }
        this.iHt.clear();
        this.iHt.addAll(list);
        this.iHq.setVisibility(8);
        this.fSo.setNextPage(this.iHl);
        this.iHr.setData(list);
        cxD();
        this.iHp.setVisibility(0);
        this.iHp.setText(R.string.say_your_point);
        pE(z);
    }

    public void a(boolean z, String str, d dVar) {
        zi(8);
        if (z && dVar != null) {
            BdToast.a(this.iGR.getPageContext().getPageActivity(), this.iGR.getPageContext().getString(R.string.subpb_add_comment_succ_tip), 1).bkP();
            this.iHn.setText((CharSequence) null);
            this.iHt.add(dVar);
            this.iHr.setData(this.iHt);
            pE(this.hasMore);
            this.iHn.post(new Runnable() { // from class: com.baidu.tieba.frs.gamesubpb.view.a.2
                @Override // java.lang.Runnable
                public void run() {
                    a.this.iHn.requestFocus();
                    l.hideSoftKeyPad(a.this.iGR.getPageContext().getPageActivity(), a.this.iHn);
                }
            });
            return;
        }
        if (TextUtils.isEmpty(str)) {
            str = this.iGR.getPageContext().getString(R.string.subpb_add_comment_fail_tip);
        }
        BdToast.a(this.iGR.getPageContext().getPageActivity(), str, 1).bkP();
    }

    public void b(boolean z, String str, d dVar) {
        if (z) {
            BdToast.a(this.iGR.getPageContext().getPageActivity(), this.iGR.getPageContext().getString(R.string.subpb_delete_comment_succ_tip), 1).bkP();
            this.iHt.remove(dVar);
            this.iHr.setData(this.iHt);
            pE(this.hasMore);
            return;
        }
        if (TextUtils.isEmpty(str)) {
            str = this.iGR.getPageContext().getString(R.string.subpb_delete_comment_fail_tip);
        }
        BdToast.a(this.iGR.getPageContext().getPageActivity(), str, 1).bkP();
    }

    public void pF(boolean z) {
        if (this.ieu != null && this.ieu.getLayoutParams() != null) {
            ViewGroup.LayoutParams layoutParams = this.ieu.getLayoutParams();
            if (z) {
                cxD();
                layoutParams.height = l.getDimens(this.iGR.getPageContext().getPageActivity(), R.dimen.ds98);
            } else {
                layoutParams.height = l.getDimens(this.iGR.getPageContext().getPageActivity(), R.dimen.ds98) + UtilHelper.getLightStatusBarHeight();
            }
            this.ieu.setLayoutParams(layoutParams);
        }
    }

    public void cx(View view) {
        if (this.ieu != null && this.mNavigationBar != null) {
            if (this.mNavigationBar.isNavigationBarExcludeStatusbarVisible()) {
                this.mNavigationBar.showNavigationBarExcludeStatusbar(false);
                if (UtilHelper.canUseStyleImmersiveSticky()) {
                    this.ieu.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight()));
                } else if (this.fSo != null) {
                    this.fSo.removeHeaderView(this.ieu);
                }
                this.mNavigationBar.setVisibility(8);
                return;
            }
            this.mNavigationBar.showNavigationBarExcludeStatusbar(true);
            if (UtilHelper.canUseStyleImmersiveSticky()) {
                this.ieu.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + l.getDimens(this.iGR.getActivity(), R.dimen.ds98)));
            } else if (this.fSo != null) {
                this.fSo.addHeaderView(this.ieu, 0);
            }
            this.mNavigationBar.setVisibility(0);
        }
    }

    public void JN(String str) {
        this.iHp.setVisibility(8);
        this.fbM.setVisibility(0);
        this.iHn.post(new Runnable() { // from class: com.baidu.tieba.frs.gamesubpb.view.a.3
            @Override // java.lang.Runnable
            public void run() {
                a.this.iHn.requestFocus();
                l.showSoftKeyPad(a.this.iGR.getPageContext().getPageActivity(), a.this.iHn);
            }
        });
        if (!TextUtils.isEmpty(str)) {
            String format = String.format(this.iGR.getPageContext().getPageActivity().getResources().getString(R.string.reply_sub_floor), str);
            this.iHn.setText(format);
            this.iHn.setSelection(format.length());
        }
    }

    public void zi(int i) {
        this.mProgressBar.setVisibility(i);
    }

    public View cmB() {
        return this.ieu;
    }

    public View getRootView() {
        return this.mRootView;
    }

    public ListView getListView() {
        return this.fSo;
    }

    public TextView cxE() {
        return this.iHp;
    }

    public NavigationBar bNC() {
        return this.mNavigationBar;
    }

    public void e(com.baidu.tieba.frs.gamesubpb.c cVar) {
        this.iGB = cVar;
    }

    public void b(BdListView.e eVar) {
        this.fSo.setOnSrollToBottomListener(eVar);
    }

    public void onChangeSkinType(int i) {
        this.iGR.getLayoutMode().setNightMode(i == 1);
        this.iGR.getLayoutMode().onModeChanged(this.mRootView);
        ap.setBackgroundColor(this.mRootView, R.color.cp_bg_line_d);
        this.mNavigationBar.onChangeSkinType(this.iGR.getPageContext(), i);
        this.iHl.changeSkin(i);
        ap.setViewTextColor(this.iHp, (int) R.color.cp_cont_e);
        this.iHp.setAlpha(0.95f);
        ap.setBackgroundResource(this.iHp, R.drawable.pb_ecomm_comment_bg);
        ap.setViewTextColor(this.iHq, (int) R.color.cp_cont_d);
        ap.setBackgroundResource(this.fbM, R.drawable.pb_ecomm_comment_bg);
        ap.setViewTextColor(this.iHn, (int) R.color.cp_cont_f);
        this.iHn.setHintTextColor(ap.getColor(R.color.cp_cont_e));
        ap.setViewTextColor(this.iHo, (int) R.color.game_sub_pb_send_txt_color);
    }

    public void onDestroy() {
        if (this.globalListener != null) {
            this.iGR.getPageContext().getPageActivity().getWindow().getDecorView().getViewTreeObserver().removeGlobalOnLayoutListener(this.globalListener);
        }
    }
}
