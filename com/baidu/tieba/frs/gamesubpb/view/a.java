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
    private BdTypeListView faQ;
    private long fhb;
    private ViewTreeObserver.OnGlobalLayoutListener globalListener;
    private String hCB;
    private FrsGameSubPbActivity hCN;
    private com.baidu.tieba.frs.gamesubpb.c hCx;
    private e hDh;
    private FrameLayout hDi;
    private EditText hDj;
    private TextView hDk;
    private TextView hDl;
    private TextView hDm;
    private com.baidu.tieba.frs.gamesubpb.b hDn;
    private com.baidu.tieba.frs.gamesubpb.model.b hDo;
    private List<o> hDp;
    private String hDq;
    private boolean hasMore;
    private View hcR;
    private View mBack;
    private boolean mIsKeyboardOpen;
    private NavigationBar mNavigationBar;
    private ProgressBar mProgressBar;
    private RelativeLayout mRootView;

    public a(FrsGameSubPbActivity frsGameSubPbActivity, View.OnClickListener onClickListener, String str) {
        this.hCN = frsGameSubPbActivity;
        this.aIH = onClickListener;
        this.hCB = str;
        this.mRootView = (RelativeLayout) LayoutInflater.from(frsGameSubPbActivity.getPageContext().getPageActivity()).inflate(R.layout.frs_game_sub_pb_activity, (ViewGroup) null);
        this.faQ = (BdTypeListView) this.mRootView.findViewById(R.id.new_sub_pb_list);
        this.faQ.setOnTouchListener(this.efF);
        this.faQ.setOnScrollListener(new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.frs.gamesubpb.view.a.4
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
                if (i != 0) {
                    l.hideSoftKeyPad(a.this.hCN.getPageContext().getPageActivity(), a.this.hDj);
                }
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            }
        });
        this.hDh = new e(this.hCN.getPageContext());
        this.hcR = BdListViewHelper.a(this.hCN.getActivity(), this.faQ, BdListViewHelper.HeadType.DEFAULT);
        this.hDl = (TextView) this.mRootView.findViewById(R.id.subpb_editor_tool_comment_reply_text);
        this.hDl.setOnClickListener(this.aIH);
        this.hDm = (TextView) this.mRootView.findViewById(R.id.no_reply_list_view);
        this.hDi = (FrameLayout) this.mRootView.findViewById(R.id.bottom_view);
        this.enc = (LinearLayout) this.mRootView.findViewById(R.id.subpb_editor_tool_comment_input_container);
        this.hDj = (EditText) this.mRootView.findViewById(R.id.subpb_editor_tool_comment_input_edit);
        this.hDk = (TextView) this.mRootView.findViewById(R.id.subpb_editor_tool_comment_send_tv);
        this.hDk.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.gamesubpb.view.a.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.EM(a.this.hDj.getText().toString());
            }
        });
        this.mProgressBar = (ProgressBar) this.mRootView.findViewById(R.id.progressBar);
        bZp();
        this.hDn = new com.baidu.tieba.frs.gamesubpb.b(this.hCN.getPageContext(), this.faQ);
        this.hDn.setClickListener(new a.InterfaceC0616a() { // from class: com.baidu.tieba.frs.gamesubpb.view.a.6
            @Override // com.baidu.tieba.frs.gamesubpb.a.InterfaceC0616a
            public void a(d dVar) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonPolymericActivityConfig(a.this.hCN.getPageContext().getPageActivity()).createNormalConfig(Long.valueOf(dVar.userId).longValue(), String.valueOf(a.this.fhb).equals(dVar.userId), false)));
            }

            @Override // com.baidu.tieba.frs.gamesubpb.a.InterfaceC0616a
            public void b(d dVar) {
                if (dVar != null) {
                    a.this.d(dVar);
                }
            }

            @Override // com.baidu.tieba.frs.gamesubpb.a.InterfaceC0616a
            public void c(d dVar) {
                if (a.this.hCx != null) {
                    a.this.hCx.bZh();
                }
                if (dVar == null) {
                    a.this.EN(null);
                    a.this.bZr();
                    return;
                }
                a.this.EN(dVar.userName);
                a.this.hDq = dVar.userId;
            }
        });
        uK(140);
        bZq();
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        this.hDp = new ArrayList();
        this.fhb = com.baidu.adp.lib.f.b.toLong(TbadkCoreApplication.getCurrentAccount(), 0L);
    }

    private void bZp() {
        this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(R.id.view_navigation_bar);
        this.mBack = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        ImageView backImageView = this.mNavigationBar.getBackImageView();
        if (backImageView != null && (backImageView.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.mBack.getLayoutParams();
            int dimens = l.getDimens(this.hCN.getPageContext().getPageActivity(), R.dimen.ds30);
            layoutParams.height = dimens;
            layoutParams.width = dimens;
            backImageView.setLayoutParams(layoutParams);
        }
        if (this.mBack != null && (this.mBack.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.mBack.getLayoutParams();
            layoutParams2.width = -2;
            layoutParams2.height = -1;
            this.mBack.setPadding(l.getDimens(this.hCN.getPageContext().getPageActivity(), R.dimen.ds32), this.mBack.getPaddingTop(), this.mBack.getPaddingRight(), this.mBack.getPaddingBottom());
            this.mBack.setLayoutParams(layoutParams2);
        }
        if (this.mNavigationBar.getBackImageView() != null) {
            SvgManager.aUV().a(this.mNavigationBar.getBackImageView(), R.drawable.icon_pure_topbar_return44_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
    }

    private void bZq() {
        this.globalListener = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tieba.frs.gamesubpb.view.a.7
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                Rect rect = new Rect();
                a.this.hCN.getPageContext().getPageActivity().getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
                int statusBarHeight = l.getStatusBarHeight(a.this.hCN.getPageContext().getPageActivity());
                int[] screenDimensions = l.getScreenDimensions(a.this.hCN.getPageContext().getPageActivity());
                if (screenDimensions[1] - rect.bottom > screenDimensions[1] / 4 && !a.this.mIsKeyboardOpen) {
                    a.this.mIsKeyboardOpen = true;
                    a.this.onKeyboardVisibilityChanged(true);
                } else if (screenDimensions[1] - rect.height() == statusBarHeight && a.this.mIsKeyboardOpen) {
                    a.this.mIsKeyboardOpen = false;
                    a.this.onKeyboardVisibilityChanged(false);
                }
            }
        };
        this.hCN.getPageContext().getPageActivity().getWindow().getDecorView().getViewTreeObserver().addOnGlobalLayoutListener(this.globalListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(final d dVar) {
        final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.hCN.getPageContext().getPageActivity());
        aVar.vN(null);
        aVar.kD(R.string.del_post_confirm);
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
        aVar.b(this.hCN.getPageContext()).aST();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(d dVar) {
        HttpMessage httpMessage = new HttpMessage(1003381);
        httpMessage.addParam("user_id", this.fhb);
        httpMessage.addParam("main_tower_id", dVar.hDd);
        httpMessage.addParam("id", dVar.id);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void EM(String str) {
        uL(0);
        HttpMessage httpMessage = new HttpMessage(1003380);
        httpMessage.addParam("user_id", this.fhb);
        httpMessage.addParam("reply_user_id", this.hDq);
        httpMessage.addParam("content", str);
        httpMessage.addParam("main_tower_id", this.hCB);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bZr() {
        this.hDq = this.hDo != null ? this.hDo.userId : null;
    }

    private void bZs() {
        if (!v.isEmpty(this.hDp)) {
            this.mNavigationBar.setCenterTextTitle(String.format(this.hCN.getResources().getString(R.string.subpb_floor_reply_count), aq.numFormatOver10000(this.hDp.size())));
        } else {
            this.mNavigationBar.setCenterTextTitle(this.hCN.getResources().getString(R.string.reply));
        }
    }

    private void uK(final int i) {
        this.hDj.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.frs.gamesubpb.view.a.10
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                if (!TextUtils.isEmpty(charSequence)) {
                    a.this.hDk.setEnabled(true);
                    String charSequence2 = charSequence.toString();
                    if (!StringUtils.isNull(charSequence2) && ae.getTextLength(charSequence2) > i) {
                        String subString = ae.subString(charSequence2, 0, i - 1);
                        a.this.hDj.setText(subString);
                        a.this.hDj.setSelection(a.this.hDj.getText().length());
                        UtilHelper.showToast(a.this.hCN.getPageContext().getPageActivity().getApplication(), a.this.hCN.getPageContext().getPageActivity().getResources().getString(R.string.edit_text_over_limit_tip, Integer.valueOf(subString.length())));
                        return;
                    }
                    return;
                }
                a.this.bZr();
                a.this.hDk.setEnabled(false);
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
            }
        });
    }

    private void bZt() {
        if (this.mNavigationBar.getBackImageView() != null) {
            SvgManager.aUV().a(this.mNavigationBar.getBackImageView(), R.drawable.icon_pure_topbar_return44_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void nv(final boolean z) {
        if (this.faQ != null) {
            if (!z) {
                this.faQ.setEnabled(z);
            } else {
                this.faQ.postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.gamesubpb.view.a.11
                    @Override // java.lang.Runnable
                    public void run() {
                        a.this.faQ.setEnabled(z);
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
            this.hDi.scrollTo(this.hDi.getScrollX(), (l.getScreenDimensions(this.hCN.getPageContext().getPageActivity())[1] - rect.bottom) - (MenuKeyUtils.hasSmartBar() ? l.dip2px(this.hCN.getPageContext().getPageActivity(), 48.0f) : 0));
            return;
        }
        this.hDi.setScrollY(0);
    }

    private void nw(boolean z) {
        if (v.isEmpty(this.hDp)) {
            this.faQ.setNextPage(null);
            this.hDm.setVisibility(0);
        } else {
            this.faQ.setNextPage(this.hDh);
            this.hDm.setVisibility(8);
            if (z) {
                this.hDh.startLoadData();
            } else {
                this.hDh.endLoadData();
            }
        }
        bZs();
    }

    public void a(boolean z, com.baidu.tieba.frs.gamesubpb.model.b bVar, List<o> list) {
        this.hasMore = z;
        this.hDo = bVar;
        bZr();
        if (v.isEmpty(list)) {
            nw(z);
            return;
        }
        this.hDp.clear();
        this.hDp.addAll(list);
        this.hDm.setVisibility(8);
        this.faQ.setNextPage(this.hDh);
        this.hDn.setData(list);
        bZt();
        this.hDl.setVisibility(0);
        this.hDl.setText(R.string.say_your_point);
        nw(z);
    }

    public void a(boolean z, String str, d dVar) {
        uL(8);
        if (z && dVar != null) {
            BdToast.a(this.hCN.getPageContext().getPageActivity(), this.hCN.getPageContext().getString(R.string.subpb_add_comment_succ_tip), 1).aSY();
            this.hDj.setText((CharSequence) null);
            this.hDp.add(dVar);
            this.hDn.setData(this.hDp);
            nw(this.hasMore);
            this.hDj.post(new Runnable() { // from class: com.baidu.tieba.frs.gamesubpb.view.a.2
                @Override // java.lang.Runnable
                public void run() {
                    a.this.hDj.requestFocus();
                    l.hideSoftKeyPad(a.this.hCN.getPageContext().getPageActivity(), a.this.hDj);
                }
            });
            return;
        }
        if (TextUtils.isEmpty(str)) {
            str = this.hCN.getPageContext().getString(R.string.subpb_add_comment_fail_tip);
        }
        BdToast.a(this.hCN.getPageContext().getPageActivity(), str, 1).aSY();
    }

    public void b(boolean z, String str, d dVar) {
        if (z) {
            BdToast.a(this.hCN.getPageContext().getPageActivity(), this.hCN.getPageContext().getString(R.string.subpb_delete_comment_succ_tip), 1).aSY();
            this.hDp.remove(dVar);
            this.hDn.setData(this.hDp);
            nw(this.hasMore);
            return;
        }
        if (TextUtils.isEmpty(str)) {
            str = this.hCN.getPageContext().getString(R.string.subpb_delete_comment_fail_tip);
        }
        BdToast.a(this.hCN.getPageContext().getPageActivity(), str, 1).aSY();
    }

    public void nx(boolean z) {
        if (this.hcR != null && this.hcR.getLayoutParams() != null) {
            ViewGroup.LayoutParams layoutParams = this.hcR.getLayoutParams();
            if (z) {
                bZt();
                layoutParams.height = l.getDimens(this.hCN.getPageContext().getPageActivity(), R.dimen.ds98);
            } else {
                layoutParams.height = l.getDimens(this.hCN.getPageContext().getPageActivity(), R.dimen.ds98) + UtilHelper.getLightStatusBarHeight();
            }
            this.hcR.setLayoutParams(layoutParams);
        }
    }

    public void cb(View view) {
        if (this.hcR != null && this.mNavigationBar != null) {
            if (this.mNavigationBar.isNavigationBarExcludeStatusbarVisible()) {
                this.mNavigationBar.showNavigationBarExcludeStatusbar(false);
                if (UtilHelper.canUseStyleImmersiveSticky()) {
                    this.hcR.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight()));
                } else if (this.faQ != null) {
                    this.faQ.removeHeaderView(this.hcR);
                }
                this.mNavigationBar.setVisibility(8);
                return;
            }
            this.mNavigationBar.showNavigationBarExcludeStatusbar(true);
            if (UtilHelper.canUseStyleImmersiveSticky()) {
                this.hcR.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + l.getDimens(this.hCN.getActivity(), R.dimen.ds98)));
            } else if (this.faQ != null) {
                this.faQ.addHeaderView(this.hcR, 0);
            }
            this.mNavigationBar.setVisibility(0);
        }
    }

    public void EN(String str) {
        this.hDl.setVisibility(8);
        this.enc.setVisibility(0);
        this.hDj.post(new Runnable() { // from class: com.baidu.tieba.frs.gamesubpb.view.a.3
            @Override // java.lang.Runnable
            public void run() {
                a.this.hDj.requestFocus();
                l.showSoftKeyPad(a.this.hCN.getPageContext().getPageActivity(), a.this.hDj);
            }
        });
        if (!TextUtils.isEmpty(str)) {
            String format = String.format(this.hCN.getPageContext().getPageActivity().getResources().getString(R.string.reply_sub_floor), str);
            this.hDj.setText(format);
            this.hDj.setSelection(format.length());
        }
    }

    public void uL(int i) {
        this.mProgressBar.setVisibility(i);
    }

    public View bOZ() {
        return this.hcR;
    }

    public View getRootView() {
        return this.mRootView;
    }

    public ListView getListView() {
        return this.faQ;
    }

    public TextView bZu() {
        return this.hDl;
    }

    public NavigationBar btY() {
        return this.mNavigationBar;
    }

    public void e(com.baidu.tieba.frs.gamesubpb.c cVar) {
        this.hCx = cVar;
    }

    public void b(BdListView.e eVar) {
        this.faQ.setOnSrollToBottomListener(eVar);
    }

    public void onChangeSkinType(int i) {
        this.hCN.getLayoutMode().setNightMode(i == 1);
        this.hCN.getLayoutMode().onModeChanged(this.mRootView);
        am.setBackgroundColor(this.mRootView, R.color.cp_bg_line_d);
        this.mNavigationBar.onChangeSkinType(this.hCN.getPageContext(), i);
        this.hDh.changeSkin(i);
        am.setViewTextColor(this.hDl, (int) R.color.cp_cont_e);
        this.hDl.setAlpha(0.95f);
        am.setBackgroundResource(this.hDl, R.drawable.pb_ecomm_comment_bg);
        am.setViewTextColor(this.hDm, (int) R.color.cp_cont_d);
        am.setBackgroundResource(this.enc, R.drawable.pb_ecomm_comment_bg);
        am.setViewTextColor(this.hDj, (int) R.color.cp_cont_f);
        this.hDj.setHintTextColor(am.getColor(R.color.cp_cont_e));
        am.setViewTextColor(this.hDk, (int) R.color.game_sub_pb_send_txt_color);
    }

    public void onDestroy() {
        if (this.globalListener != null) {
            this.hCN.getPageContext().getPageActivity().getWindow().getDecorView().getViewTreeObserver().removeGlobalOnLayoutListener(this.globalListener);
        }
    }
}
