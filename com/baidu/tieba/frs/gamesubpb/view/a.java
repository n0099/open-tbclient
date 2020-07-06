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
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.w;
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
    private View.OnClickListener aLl;
    private c eor = new c(new c.a() { // from class: com.baidu.tieba.frs.gamesubpb.view.a.1
        @Override // com.baidu.tieba.pb.a.c.a
        public boolean onDoubleTap(View view, MotionEvent motionEvent) {
            a.this.nH(false);
            a.this.cc(view);
            a.this.nH(true);
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
    private LinearLayout evS;
    private BdTypeListView fml;
    private long fsA;
    private ViewTreeObserver.OnGlobalLayoutListener globalListener;
    private FrsGameSubPbActivity hQI;
    private com.baidu.tieba.frs.gamesubpb.c hQs;
    private String hQw;
    private e hRc;
    private FrameLayout hRd;
    private EditText hRe;
    private TextView hRf;
    private TextView hRg;
    private TextView hRh;
    private com.baidu.tieba.frs.gamesubpb.b hRi;
    private com.baidu.tieba.frs.gamesubpb.model.b hRj;
    private List<q> hRk;
    private String hRl;
    private boolean hasMore;
    private View hpn;
    private View mBack;
    private boolean mIsKeyboardOpen;
    private NavigationBar mNavigationBar;
    private ProgressBar mProgressBar;
    private RelativeLayout mRootView;

    public a(FrsGameSubPbActivity frsGameSubPbActivity, View.OnClickListener onClickListener, String str) {
        this.hQI = frsGameSubPbActivity;
        this.aLl = onClickListener;
        this.hQw = str;
        this.mRootView = (RelativeLayout) LayoutInflater.from(frsGameSubPbActivity.getPageContext().getPageActivity()).inflate(R.layout.frs_game_sub_pb_activity, (ViewGroup) null);
        this.fml = (BdTypeListView) this.mRootView.findViewById(R.id.new_sub_pb_list);
        this.fml.setOnTouchListener(this.eor);
        this.fml.setOnScrollListener(new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.frs.gamesubpb.view.a.4
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
                if (i != 0) {
                    l.hideSoftKeyPad(a.this.hQI.getPageContext().getPageActivity(), a.this.hRe);
                }
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            }
        });
        this.hRc = new e(this.hQI.getPageContext());
        this.hpn = BdListViewHelper.a(this.hQI.getActivity(), this.fml, BdListViewHelper.HeadType.DEFAULT);
        this.hRg = (TextView) this.mRootView.findViewById(R.id.subpb_editor_tool_comment_reply_text);
        this.hRg.setOnClickListener(this.aLl);
        this.hRh = (TextView) this.mRootView.findViewById(R.id.no_reply_list_view);
        this.hRd = (FrameLayout) this.mRootView.findViewById(R.id.bottom_view);
        this.evS = (LinearLayout) this.mRootView.findViewById(R.id.subpb_editor_tool_comment_input_container);
        this.hRe = (EditText) this.mRootView.findViewById(R.id.subpb_editor_tool_comment_input_edit);
        this.hRf = (TextView) this.mRootView.findViewById(R.id.subpb_editor_tool_comment_send_tv);
        this.hRf.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.gamesubpb.view.a.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.Fn(a.this.hRe.getText().toString());
            }
        });
        this.mProgressBar = (ProgressBar) this.mRootView.findViewById(R.id.progressBar);
        ccL();
        this.hRi = new com.baidu.tieba.frs.gamesubpb.b(this.hQI.getPageContext(), this.fml);
        this.hRi.setClickListener(new a.InterfaceC0624a() { // from class: com.baidu.tieba.frs.gamesubpb.view.a.6
            @Override // com.baidu.tieba.frs.gamesubpb.a.InterfaceC0624a
            public void a(d dVar) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonPolymericActivityConfig(a.this.hQI.getPageContext().getPageActivity()).createNormalConfig(Long.valueOf(dVar.userId).longValue(), String.valueOf(a.this.fsA).equals(dVar.userId), false)));
            }

            @Override // com.baidu.tieba.frs.gamesubpb.a.InterfaceC0624a
            public void b(d dVar) {
                if (dVar != null) {
                    a.this.d(dVar);
                }
            }

            @Override // com.baidu.tieba.frs.gamesubpb.a.InterfaceC0624a
            public void c(d dVar) {
                if (a.this.hQs != null) {
                    a.this.hQs.ccE();
                }
                if (dVar == null) {
                    a.this.Fo(null);
                    a.this.ccN();
                    return;
                }
                a.this.Fo(dVar.userName);
                a.this.hRl = dVar.userId;
            }
        });
        vr(140);
        ccM();
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        this.hRk = new ArrayList();
        this.fsA = com.baidu.adp.lib.f.b.toLong(TbadkCoreApplication.getCurrentAccount(), 0L);
    }

    private void ccL() {
        this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(R.id.view_navigation_bar);
        this.mBack = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        ImageView backImageView = this.mNavigationBar.getBackImageView();
        if (backImageView != null && (backImageView.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.mBack.getLayoutParams();
            int dimens = l.getDimens(this.hQI.getPageContext().getPageActivity(), R.dimen.ds30);
            layoutParams.height = dimens;
            layoutParams.width = dimens;
            backImageView.setLayoutParams(layoutParams);
        }
        if (this.mBack != null && (this.mBack.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.mBack.getLayoutParams();
            layoutParams2.width = -2;
            layoutParams2.height = -1;
            this.mBack.setPadding(l.getDimens(this.hQI.getPageContext().getPageActivity(), R.dimen.ds32), this.mBack.getPaddingTop(), this.mBack.getPaddingRight(), this.mBack.getPaddingBottom());
            this.mBack.setLayoutParams(layoutParams2);
        }
        if (this.mNavigationBar.getBackImageView() != null) {
            SvgManager.aWQ().a(this.mNavigationBar.getBackImageView(), R.drawable.icon_pure_topbar_return44_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
    }

    private void ccM() {
        this.globalListener = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tieba.frs.gamesubpb.view.a.7
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                Rect rect = new Rect();
                a.this.hQI.getPageContext().getPageActivity().getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
                int statusBarHeight = l.getStatusBarHeight(a.this.hQI.getPageContext().getPageActivity());
                int[] screenDimensions = l.getScreenDimensions(a.this.hQI.getPageContext().getPageActivity());
                if (screenDimensions[1] - rect.bottom > screenDimensions[1] / 4 && !a.this.mIsKeyboardOpen) {
                    a.this.mIsKeyboardOpen = true;
                    a.this.onKeyboardVisibilityChanged(true);
                } else if (screenDimensions[1] - rect.height() == statusBarHeight && a.this.mIsKeyboardOpen) {
                    a.this.mIsKeyboardOpen = false;
                    a.this.onKeyboardVisibilityChanged(false);
                }
            }
        };
        this.hQI.getPageContext().getPageActivity().getWindow().getDecorView().getViewTreeObserver().addOnGlobalLayoutListener(this.globalListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(final d dVar) {
        final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.hQI.getPageContext().getPageActivity());
        aVar.wd(null);
        aVar.kT(R.string.del_post_confirm);
        aVar.hg(true);
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
        aVar.b(this.hQI.getPageContext()).aUN();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(d dVar) {
        HttpMessage httpMessage = new HttpMessage(1003381);
        httpMessage.addParam("user_id", this.fsA);
        httpMessage.addParam("main_tower_id", dVar.hQY);
        httpMessage.addParam("id", dVar.id);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Fn(String str) {
        vs(0);
        HttpMessage httpMessage = new HttpMessage(1003380);
        httpMessage.addParam("user_id", this.fsA);
        httpMessage.addParam("reply_user_id", this.hRl);
        httpMessage.addParam("content", str);
        httpMessage.addParam("main_tower_id", this.hQw);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ccN() {
        this.hRl = this.hRj != null ? this.hRj.userId : null;
    }

    private void ccO() {
        if (!w.isEmpty(this.hRk)) {
            this.mNavigationBar.setCenterTextTitle(String.format(this.hQI.getResources().getString(R.string.subpb_floor_reply_count), ar.numFormatOver10000(this.hRk.size())));
        } else {
            this.mNavigationBar.setCenterTextTitle(this.hQI.getResources().getString(R.string.reply));
        }
    }

    private void vr(final int i) {
        this.hRe.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.frs.gamesubpb.view.a.10
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                if (!TextUtils.isEmpty(charSequence)) {
                    a.this.hRf.setEnabled(true);
                    String charSequence2 = charSequence.toString();
                    if (!StringUtils.isNull(charSequence2) && ae.getTextLength(charSequence2) > i) {
                        String subString = ae.subString(charSequence2, 0, i - 1);
                        a.this.hRe.setText(subString);
                        a.this.hRe.setSelection(a.this.hRe.getText().length());
                        UtilHelper.showToast(a.this.hQI.getPageContext().getPageActivity().getApplication(), a.this.hQI.getPageContext().getPageActivity().getResources().getString(R.string.edit_text_over_limit_tip, Integer.valueOf(subString.length())));
                        return;
                    }
                    return;
                }
                a.this.ccN();
                a.this.hRf.setEnabled(false);
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
            }
        });
    }

    private void ccP() {
        if (this.mNavigationBar.getBackImageView() != null) {
            SvgManager.aWQ().a(this.mNavigationBar.getBackImageView(), R.drawable.icon_pure_topbar_return44_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void nH(final boolean z) {
        if (this.fml != null) {
            if (!z) {
                this.fml.setEnabled(z);
            } else {
                this.fml.postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.gamesubpb.view.a.11
                    @Override // java.lang.Runnable
                    public void run() {
                        a.this.fml.setEnabled(z);
                    }
                }, 10L);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onKeyboardVisibilityChanged(boolean z) {
        if (z) {
            Rect rect = new Rect();
            this.evS.getWindowVisibleDisplayFrame(rect);
            this.hRd.scrollTo(this.hRd.getScrollX(), (l.getScreenDimensions(this.hQI.getPageContext().getPageActivity())[1] - rect.bottom) - (MenuKeyUtils.hasSmartBar() ? l.dip2px(this.hQI.getPageContext().getPageActivity(), 48.0f) : 0));
            return;
        }
        this.hRd.setScrollY(0);
    }

    private void nI(boolean z) {
        if (w.isEmpty(this.hRk)) {
            this.fml.setNextPage(null);
            this.hRh.setVisibility(0);
        } else {
            this.fml.setNextPage(this.hRc);
            this.hRh.setVisibility(8);
            if (z) {
                this.hRc.startLoadData();
            } else {
                this.hRc.endLoadData();
            }
        }
        ccO();
    }

    public void a(boolean z, com.baidu.tieba.frs.gamesubpb.model.b bVar, List<q> list) {
        this.hasMore = z;
        this.hRj = bVar;
        ccN();
        if (w.isEmpty(list)) {
            nI(z);
            return;
        }
        this.hRk.clear();
        this.hRk.addAll(list);
        this.hRh.setVisibility(8);
        this.fml.setNextPage(this.hRc);
        this.hRi.setData(list);
        ccP();
        this.hRg.setVisibility(0);
        this.hRg.setText(R.string.say_your_point);
        nI(z);
    }

    public void a(boolean z, String str, d dVar) {
        vs(8);
        if (z && dVar != null) {
            BdToast.a(this.hQI.getPageContext().getPageActivity(), this.hQI.getPageContext().getString(R.string.subpb_add_comment_succ_tip), 1).aUS();
            this.hRe.setText((CharSequence) null);
            this.hRk.add(dVar);
            this.hRi.setData(this.hRk);
            nI(this.hasMore);
            this.hRe.post(new Runnable() { // from class: com.baidu.tieba.frs.gamesubpb.view.a.2
                @Override // java.lang.Runnable
                public void run() {
                    a.this.hRe.requestFocus();
                    l.hideSoftKeyPad(a.this.hQI.getPageContext().getPageActivity(), a.this.hRe);
                }
            });
            return;
        }
        if (TextUtils.isEmpty(str)) {
            str = this.hQI.getPageContext().getString(R.string.subpb_add_comment_fail_tip);
        }
        BdToast.a(this.hQI.getPageContext().getPageActivity(), str, 1).aUS();
    }

    public void b(boolean z, String str, d dVar) {
        if (z) {
            BdToast.a(this.hQI.getPageContext().getPageActivity(), this.hQI.getPageContext().getString(R.string.subpb_delete_comment_succ_tip), 1).aUS();
            this.hRk.remove(dVar);
            this.hRi.setData(this.hRk);
            nI(this.hasMore);
            return;
        }
        if (TextUtils.isEmpty(str)) {
            str = this.hQI.getPageContext().getString(R.string.subpb_delete_comment_fail_tip);
        }
        BdToast.a(this.hQI.getPageContext().getPageActivity(), str, 1).aUS();
    }

    public void nJ(boolean z) {
        if (this.hpn != null && this.hpn.getLayoutParams() != null) {
            ViewGroup.LayoutParams layoutParams = this.hpn.getLayoutParams();
            if (z) {
                ccP();
                layoutParams.height = l.getDimens(this.hQI.getPageContext().getPageActivity(), R.dimen.ds98);
            } else {
                layoutParams.height = l.getDimens(this.hQI.getPageContext().getPageActivity(), R.dimen.ds98) + UtilHelper.getLightStatusBarHeight();
            }
            this.hpn.setLayoutParams(layoutParams);
        }
    }

    public void cc(View view) {
        if (this.hpn != null && this.mNavigationBar != null) {
            if (this.mNavigationBar.isNavigationBarExcludeStatusbarVisible()) {
                this.mNavigationBar.showNavigationBarExcludeStatusbar(false);
                if (UtilHelper.canUseStyleImmersiveSticky()) {
                    this.hpn.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight()));
                } else if (this.fml != null) {
                    this.fml.removeHeaderView(this.hpn);
                }
                this.mNavigationBar.setVisibility(8);
                return;
            }
            this.mNavigationBar.showNavigationBarExcludeStatusbar(true);
            if (UtilHelper.canUseStyleImmersiveSticky()) {
                this.hpn.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + l.getDimens(this.hQI.getActivity(), R.dimen.ds98)));
            } else if (this.fml != null) {
                this.fml.addHeaderView(this.hpn, 0);
            }
            this.mNavigationBar.setVisibility(0);
        }
    }

    public void Fo(String str) {
        this.hRg.setVisibility(8);
        this.evS.setVisibility(0);
        this.hRe.post(new Runnable() { // from class: com.baidu.tieba.frs.gamesubpb.view.a.3
            @Override // java.lang.Runnable
            public void run() {
                a.this.hRe.requestFocus();
                l.showSoftKeyPad(a.this.hQI.getPageContext().getPageActivity(), a.this.hRe);
            }
        });
        if (!TextUtils.isEmpty(str)) {
            String format = String.format(this.hQI.getPageContext().getPageActivity().getResources().getString(R.string.reply_sub_floor), str);
            this.hRe.setText(format);
            this.hRe.setSelection(format.length());
        }
    }

    public void vs(int i) {
        this.mProgressBar.setVisibility(i);
    }

    public View bSf() {
        return this.hpn;
    }

    public View getRootView() {
        return this.mRootView;
    }

    public ListView getListView() {
        return this.fml;
    }

    public TextView ccQ() {
        return this.hRg;
    }

    public NavigationBar bwW() {
        return this.mNavigationBar;
    }

    public void e(com.baidu.tieba.frs.gamesubpb.c cVar) {
        this.hQs = cVar;
    }

    public void b(BdListView.e eVar) {
        this.fml.setOnSrollToBottomListener(eVar);
    }

    public void onChangeSkinType(int i) {
        this.hQI.getLayoutMode().setNightMode(i == 1);
        this.hQI.getLayoutMode().onModeChanged(this.mRootView);
        an.setBackgroundColor(this.mRootView, R.color.cp_bg_line_d);
        this.mNavigationBar.onChangeSkinType(this.hQI.getPageContext(), i);
        this.hRc.changeSkin(i);
        an.setViewTextColor(this.hRg, (int) R.color.cp_cont_e);
        this.hRg.setAlpha(0.95f);
        an.setBackgroundResource(this.hRg, R.drawable.pb_ecomm_comment_bg);
        an.setViewTextColor(this.hRh, (int) R.color.cp_cont_d);
        an.setBackgroundResource(this.evS, R.drawable.pb_ecomm_comment_bg);
        an.setViewTextColor(this.hRe, (int) R.color.cp_cont_f);
        this.hRe.setHintTextColor(an.getColor(R.color.cp_cont_e));
        an.setViewTextColor(this.hRf, (int) R.color.game_sub_pb_send_txt_color);
    }

    public void onDestroy() {
        if (this.globalListener != null) {
            this.hQI.getPageContext().getPageActivity().getWindow().getDecorView().getViewTreeObserver().removeGlobalOnLayoutListener(this.globalListener);
        }
    }
}
