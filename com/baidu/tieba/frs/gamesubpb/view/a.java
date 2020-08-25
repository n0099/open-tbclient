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
/* loaded from: classes16.dex */
public class a {
    private View.OnClickListener aRU;
    private c eFf = new c(new c.a() { // from class: com.baidu.tieba.frs.gamesubpb.view.a.1
        @Override // com.baidu.tieba.pb.a.c.a
        public boolean onDoubleTap(View view, MotionEvent motionEvent) {
            a.this.oQ(false);
            a.this.ck(view);
            a.this.oQ(true);
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
    private LinearLayout eMK;
    private BdTypeListView fCP;
    private long fJa;
    private ViewTreeObserver.OnGlobalLayoutListener globalListener;
    private View hIo;
    private boolean hasMore;
    private com.baidu.tieba.frs.gamesubpb.c ikA;
    private String ikE;
    private FrsGameSubPbActivity ikQ;
    private e ilk;
    private FrameLayout ill;
    private EditText ilm;
    private TextView iln;
    private TextView ilo;
    private TextView ilp;
    private com.baidu.tieba.frs.gamesubpb.b ilq;
    private com.baidu.tieba.frs.gamesubpb.model.b ilr;
    private List<q> ils;
    private String ilt;
    private View mBack;
    private boolean mIsKeyboardOpen;
    private NavigationBar mNavigationBar;
    private ProgressBar mProgressBar;
    private RelativeLayout mRootView;

    public a(FrsGameSubPbActivity frsGameSubPbActivity, View.OnClickListener onClickListener, String str) {
        this.ikQ = frsGameSubPbActivity;
        this.aRU = onClickListener;
        this.ikE = str;
        this.mRootView = (RelativeLayout) LayoutInflater.from(frsGameSubPbActivity.getPageContext().getPageActivity()).inflate(R.layout.frs_game_sub_pb_activity, (ViewGroup) null);
        this.fCP = (BdTypeListView) this.mRootView.findViewById(R.id.new_sub_pb_list);
        this.fCP.setOnTouchListener(this.eFf);
        this.fCP.setOnScrollListener(new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.frs.gamesubpb.view.a.4
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
                if (i != 0) {
                    l.hideSoftKeyPad(a.this.ikQ.getPageContext().getPageActivity(), a.this.ilm);
                }
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            }
        });
        this.ilk = new e(this.ikQ.getPageContext());
        this.hIo = BdListViewHelper.a(this.ikQ.getActivity(), this.fCP, BdListViewHelper.HeadType.DEFAULT);
        this.ilo = (TextView) this.mRootView.findViewById(R.id.subpb_editor_tool_comment_reply_text);
        this.ilo.setOnClickListener(this.aRU);
        this.ilp = (TextView) this.mRootView.findViewById(R.id.no_reply_list_view);
        this.ill = (FrameLayout) this.mRootView.findViewById(R.id.bottom_view);
        this.eMK = (LinearLayout) this.mRootView.findViewById(R.id.subpb_editor_tool_comment_input_container);
        this.ilm = (EditText) this.mRootView.findViewById(R.id.subpb_editor_tool_comment_input_edit);
        this.iln = (TextView) this.mRootView.findViewById(R.id.subpb_editor_tool_comment_send_tv);
        this.iln.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.gamesubpb.view.a.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.IB(a.this.ilm.getText().toString());
            }
        });
        this.mProgressBar = (ProgressBar) this.mRootView.findViewById(R.id.progressBar);
        cqO();
        this.ilq = new com.baidu.tieba.frs.gamesubpb.b(this.ikQ.getPageContext(), this.fCP);
        this.ilq.setClickListener(new a.InterfaceC0685a() { // from class: com.baidu.tieba.frs.gamesubpb.view.a.6
            @Override // com.baidu.tieba.frs.gamesubpb.a.InterfaceC0685a
            public void a(d dVar) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonPolymericActivityConfig(a.this.ikQ.getPageContext().getPageActivity()).createNormalConfig(Long.valueOf(dVar.userId).longValue(), String.valueOf(a.this.fJa).equals(dVar.userId), false)));
            }

            @Override // com.baidu.tieba.frs.gamesubpb.a.InterfaceC0685a
            public void b(d dVar) {
                if (dVar != null) {
                    a.this.d(dVar);
                }
            }

            @Override // com.baidu.tieba.frs.gamesubpb.a.InterfaceC0685a
            public void c(d dVar) {
                if (a.this.ikA != null) {
                    a.this.ikA.cqH();
                }
                if (dVar == null) {
                    a.this.IC(null);
                    a.this.cqQ();
                    return;
                }
                a.this.IC(dVar.userName);
                a.this.ilt = dVar.userId;
            }
        });
        yc(140);
        cqP();
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        this.ils = new ArrayList();
        this.fJa = com.baidu.adp.lib.f.b.toLong(TbadkCoreApplication.getCurrentAccount(), 0L);
    }

    private void cqO() {
        this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(R.id.view_navigation_bar);
        this.mBack = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        ImageView backImageView = this.mNavigationBar.getBackImageView();
        if (backImageView != null && (backImageView.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.mBack.getLayoutParams();
            int dimens = l.getDimens(this.ikQ.getPageContext().getPageActivity(), R.dimen.ds30);
            layoutParams.height = dimens;
            layoutParams.width = dimens;
            backImageView.setLayoutParams(layoutParams);
        }
        if (this.mBack != null && (this.mBack.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.mBack.getLayoutParams();
            layoutParams2.width = -2;
            layoutParams2.height = -1;
            this.mBack.setPadding(l.getDimens(this.ikQ.getPageContext().getPageActivity(), R.dimen.ds32), this.mBack.getPaddingTop(), this.mBack.getPaddingRight(), this.mBack.getPaddingBottom());
            this.mBack.setLayoutParams(layoutParams2);
        }
        if (this.mNavigationBar.getBackImageView() != null) {
            SvgManager.bjq().a(this.mNavigationBar.getBackImageView(), R.drawable.icon_pure_topbar_return44_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
    }

    private void cqP() {
        this.globalListener = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tieba.frs.gamesubpb.view.a.7
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                Rect rect = new Rect();
                a.this.ikQ.getPageContext().getPageActivity().getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
                int statusBarHeight = l.getStatusBarHeight(a.this.ikQ.getPageContext().getPageActivity());
                int[] screenDimensions = l.getScreenDimensions(a.this.ikQ.getPageContext().getPageActivity());
                if (screenDimensions[1] - rect.bottom > screenDimensions[1] / 4 && !a.this.mIsKeyboardOpen) {
                    a.this.mIsKeyboardOpen = true;
                    a.this.onKeyboardVisibilityChanged(true);
                } else if (screenDimensions[1] - rect.height() == statusBarHeight && a.this.mIsKeyboardOpen) {
                    a.this.mIsKeyboardOpen = false;
                    a.this.onKeyboardVisibilityChanged(false);
                }
            }
        };
        this.ikQ.getPageContext().getPageActivity().getWindow().getDecorView().getViewTreeObserver().addOnGlobalLayoutListener(this.globalListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(final d dVar) {
        final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.ikQ.getPageContext().getPageActivity());
        aVar.zy(null);
        aVar.nt(R.string.del_post_confirm);
        aVar.ig(true);
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
        aVar.b(this.ikQ.getPageContext()).bhg();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(d dVar) {
        HttpMessage httpMessage = new HttpMessage(1003381);
        httpMessage.addParam("user_id", this.fJa);
        httpMessage.addParam("main_tower_id", dVar.ilg);
        httpMessage.addParam("id", dVar.id);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void IB(String str) {
        yd(0);
        HttpMessage httpMessage = new HttpMessage(1003380);
        httpMessage.addParam("user_id", this.fJa);
        httpMessage.addParam("reply_user_id", this.ilt);
        httpMessage.addParam("content", str);
        httpMessage.addParam("main_tower_id", this.ikE);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cqQ() {
        this.ilt = this.ilr != null ? this.ilr.userId : null;
    }

    private void cqR() {
        if (!y.isEmpty(this.ils)) {
            this.mNavigationBar.setCenterTextTitle(String.format(this.ikQ.getResources().getString(R.string.subpb_floor_reply_count), at.numFormatOver10000(this.ils.size())));
        } else {
            this.mNavigationBar.setCenterTextTitle(this.ikQ.getResources().getString(R.string.reply));
        }
    }

    private void yc(final int i) {
        this.ilm.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.frs.gamesubpb.view.a.10
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                if (!TextUtils.isEmpty(charSequence)) {
                    a.this.iln.setEnabled(true);
                    String charSequence2 = charSequence.toString();
                    if (!StringUtils.isNull(charSequence2) && ae.getTextLength(charSequence2) > i) {
                        String subString = ae.subString(charSequence2, 0, i - 1);
                        a.this.ilm.setText(subString);
                        a.this.ilm.setSelection(a.this.ilm.getText().length());
                        UtilHelper.showToast(a.this.ikQ.getPageContext().getPageActivity().getApplication(), a.this.ikQ.getPageContext().getPageActivity().getResources().getString(R.string.edit_text_over_limit_tip, Integer.valueOf(subString.length())));
                        return;
                    }
                    return;
                }
                a.this.cqQ();
                a.this.iln.setEnabled(false);
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
            }
        });
    }

    private void cqS() {
        if (this.mNavigationBar.getBackImageView() != null) {
            SvgManager.bjq().a(this.mNavigationBar.getBackImageView(), R.drawable.icon_pure_topbar_return44_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void oQ(final boolean z) {
        if (this.fCP != null) {
            if (!z) {
                this.fCP.setEnabled(z);
            } else {
                this.fCP.postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.gamesubpb.view.a.11
                    @Override // java.lang.Runnable
                    public void run() {
                        a.this.fCP.setEnabled(z);
                    }
                }, 10L);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onKeyboardVisibilityChanged(boolean z) {
        if (z) {
            Rect rect = new Rect();
            this.eMK.getWindowVisibleDisplayFrame(rect);
            this.ill.scrollTo(this.ill.getScrollX(), (l.getScreenDimensions(this.ikQ.getPageContext().getPageActivity())[1] - rect.bottom) - (MenuKeyUtils.hasSmartBar() ? l.dip2px(this.ikQ.getPageContext().getPageActivity(), 48.0f) : 0));
            return;
        }
        this.ill.setScrollY(0);
    }

    private void oR(boolean z) {
        if (y.isEmpty(this.ils)) {
            this.fCP.setNextPage(null);
            this.ilp.setVisibility(0);
        } else {
            this.fCP.setNextPage(this.ilk);
            this.ilp.setVisibility(8);
            if (z) {
                this.ilk.startLoadData();
            } else {
                this.ilk.endLoadData();
            }
        }
        cqR();
    }

    public void a(boolean z, com.baidu.tieba.frs.gamesubpb.model.b bVar, List<q> list) {
        this.hasMore = z;
        this.ilr = bVar;
        cqQ();
        if (y.isEmpty(list)) {
            oR(z);
            return;
        }
        this.ils.clear();
        this.ils.addAll(list);
        this.ilp.setVisibility(8);
        this.fCP.setNextPage(this.ilk);
        this.ilq.setData(list);
        cqS();
        this.ilo.setVisibility(0);
        this.ilo.setText(R.string.say_your_point);
        oR(z);
    }

    public void a(boolean z, String str, d dVar) {
        yd(8);
        if (z && dVar != null) {
            BdToast.a(this.ikQ.getPageContext().getPageActivity(), this.ikQ.getPageContext().getString(R.string.subpb_add_comment_succ_tip), 1).bhm();
            this.ilm.setText((CharSequence) null);
            this.ils.add(dVar);
            this.ilq.setData(this.ils);
            oR(this.hasMore);
            this.ilm.post(new Runnable() { // from class: com.baidu.tieba.frs.gamesubpb.view.a.2
                @Override // java.lang.Runnable
                public void run() {
                    a.this.ilm.requestFocus();
                    l.hideSoftKeyPad(a.this.ikQ.getPageContext().getPageActivity(), a.this.ilm);
                }
            });
            return;
        }
        if (TextUtils.isEmpty(str)) {
            str = this.ikQ.getPageContext().getString(R.string.subpb_add_comment_fail_tip);
        }
        BdToast.a(this.ikQ.getPageContext().getPageActivity(), str, 1).bhm();
    }

    public void b(boolean z, String str, d dVar) {
        if (z) {
            BdToast.a(this.ikQ.getPageContext().getPageActivity(), this.ikQ.getPageContext().getString(R.string.subpb_delete_comment_succ_tip), 1).bhm();
            this.ils.remove(dVar);
            this.ilq.setData(this.ils);
            oR(this.hasMore);
            return;
        }
        if (TextUtils.isEmpty(str)) {
            str = this.ikQ.getPageContext().getString(R.string.subpb_delete_comment_fail_tip);
        }
        BdToast.a(this.ikQ.getPageContext().getPageActivity(), str, 1).bhm();
    }

    public void oS(boolean z) {
        if (this.hIo != null && this.hIo.getLayoutParams() != null) {
            ViewGroup.LayoutParams layoutParams = this.hIo.getLayoutParams();
            if (z) {
                cqS();
                layoutParams.height = l.getDimens(this.ikQ.getPageContext().getPageActivity(), R.dimen.ds98);
            } else {
                layoutParams.height = l.getDimens(this.ikQ.getPageContext().getPageActivity(), R.dimen.ds98) + UtilHelper.getLightStatusBarHeight();
            }
            this.hIo.setLayoutParams(layoutParams);
        }
    }

    public void ck(View view) {
        if (this.hIo != null && this.mNavigationBar != null) {
            if (this.mNavigationBar.isNavigationBarExcludeStatusbarVisible()) {
                this.mNavigationBar.showNavigationBarExcludeStatusbar(false);
                if (UtilHelper.canUseStyleImmersiveSticky()) {
                    this.hIo.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight()));
                } else if (this.fCP != null) {
                    this.fCP.removeHeaderView(this.hIo);
                }
                this.mNavigationBar.setVisibility(8);
                return;
            }
            this.mNavigationBar.showNavigationBarExcludeStatusbar(true);
            if (UtilHelper.canUseStyleImmersiveSticky()) {
                this.hIo.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + l.getDimens(this.ikQ.getActivity(), R.dimen.ds98)));
            } else if (this.fCP != null) {
                this.fCP.addHeaderView(this.hIo, 0);
            }
            this.mNavigationBar.setVisibility(0);
        }
    }

    public void IC(String str) {
        this.ilo.setVisibility(8);
        this.eMK.setVisibility(0);
        this.ilm.post(new Runnable() { // from class: com.baidu.tieba.frs.gamesubpb.view.a.3
            @Override // java.lang.Runnable
            public void run() {
                a.this.ilm.requestFocus();
                l.showSoftKeyPad(a.this.ikQ.getPageContext().getPageActivity(), a.this.ilm);
            }
        });
        if (!TextUtils.isEmpty(str)) {
            String format = String.format(this.ikQ.getPageContext().getPageActivity().getResources().getString(R.string.reply_sub_floor), str);
            this.ilm.setText(format);
            this.ilm.setSelection(format.length());
        }
    }

    public void yd(int i) {
        this.mProgressBar.setVisibility(i);
    }

    public View cfN() {
        return this.hIo;
    }

    public View getRootView() {
        return this.mRootView;
    }

    public ListView getListView() {
        return this.fCP;
    }

    public TextView cqT() {
        return this.ilo;
    }

    public NavigationBar bJH() {
        return this.mNavigationBar;
    }

    public void e(com.baidu.tieba.frs.gamesubpb.c cVar) {
        this.ikA = cVar;
    }

    public void b(BdListView.e eVar) {
        this.fCP.setOnSrollToBottomListener(eVar);
    }

    public void onChangeSkinType(int i) {
        this.ikQ.getLayoutMode().setNightMode(i == 1);
        this.ikQ.getLayoutMode().onModeChanged(this.mRootView);
        ap.setBackgroundColor(this.mRootView, R.color.cp_bg_line_d);
        this.mNavigationBar.onChangeSkinType(this.ikQ.getPageContext(), i);
        this.ilk.changeSkin(i);
        ap.setViewTextColor(this.ilo, (int) R.color.cp_cont_e);
        this.ilo.setAlpha(0.95f);
        ap.setBackgroundResource(this.ilo, R.drawable.pb_ecomm_comment_bg);
        ap.setViewTextColor(this.ilp, (int) R.color.cp_cont_d);
        ap.setBackgroundResource(this.eMK, R.drawable.pb_ecomm_comment_bg);
        ap.setViewTextColor(this.ilm, (int) R.color.cp_cont_f);
        this.ilm.setHintTextColor(ap.getColor(R.color.cp_cont_e));
        ap.setViewTextColor(this.iln, (int) R.color.game_sub_pb_send_txt_color);
    }

    public void onDestroy() {
        if (this.globalListener != null) {
            this.ikQ.getPageContext().getPageActivity().getWindow().getDecorView().getViewTreeObserver().removeGlobalOnLayoutListener(this.globalListener);
        }
    }
}
