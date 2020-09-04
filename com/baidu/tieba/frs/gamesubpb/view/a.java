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
    private View.OnClickListener aRW;
    private c eFj = new c(new c.a() { // from class: com.baidu.tieba.frs.gamesubpb.view.a.1
        @Override // com.baidu.tieba.pb.a.c.a
        public boolean onDoubleTap(View view, MotionEvent motionEvent) {
            a.this.oS(false);
            a.this.ck(view);
            a.this.oS(true);
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
    private LinearLayout eMO;
    private BdTypeListView fCT;
    private long fJe;
    private ViewTreeObserver.OnGlobalLayoutListener globalListener;
    private View hIu;
    private boolean hasMore;
    private com.baidu.tieba.frs.gamesubpb.c ikG;
    private String ikK;
    private FrsGameSubPbActivity ikW;
    private e ilq;
    private FrameLayout ilr;
    private EditText ils;
    private TextView ilt;
    private TextView ilu;
    private TextView ilv;
    private com.baidu.tieba.frs.gamesubpb.b ilw;
    private com.baidu.tieba.frs.gamesubpb.model.b ilx;
    private List<q> ily;
    private String ilz;
    private View mBack;
    private boolean mIsKeyboardOpen;
    private NavigationBar mNavigationBar;
    private ProgressBar mProgressBar;
    private RelativeLayout mRootView;

    public a(FrsGameSubPbActivity frsGameSubPbActivity, View.OnClickListener onClickListener, String str) {
        this.ikW = frsGameSubPbActivity;
        this.aRW = onClickListener;
        this.ikK = str;
        this.mRootView = (RelativeLayout) LayoutInflater.from(frsGameSubPbActivity.getPageContext().getPageActivity()).inflate(R.layout.frs_game_sub_pb_activity, (ViewGroup) null);
        this.fCT = (BdTypeListView) this.mRootView.findViewById(R.id.new_sub_pb_list);
        this.fCT.setOnTouchListener(this.eFj);
        this.fCT.setOnScrollListener(new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.frs.gamesubpb.view.a.4
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
                if (i != 0) {
                    l.hideSoftKeyPad(a.this.ikW.getPageContext().getPageActivity(), a.this.ils);
                }
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            }
        });
        this.ilq = new e(this.ikW.getPageContext());
        this.hIu = BdListViewHelper.a(this.ikW.getActivity(), this.fCT, BdListViewHelper.HeadType.DEFAULT);
        this.ilu = (TextView) this.mRootView.findViewById(R.id.subpb_editor_tool_comment_reply_text);
        this.ilu.setOnClickListener(this.aRW);
        this.ilv = (TextView) this.mRootView.findViewById(R.id.no_reply_list_view);
        this.ilr = (FrameLayout) this.mRootView.findViewById(R.id.bottom_view);
        this.eMO = (LinearLayout) this.mRootView.findViewById(R.id.subpb_editor_tool_comment_input_container);
        this.ils = (EditText) this.mRootView.findViewById(R.id.subpb_editor_tool_comment_input_edit);
        this.ilt = (TextView) this.mRootView.findViewById(R.id.subpb_editor_tool_comment_send_tv);
        this.ilt.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.gamesubpb.view.a.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.IC(a.this.ils.getText().toString());
            }
        });
        this.mProgressBar = (ProgressBar) this.mRootView.findViewById(R.id.progressBar);
        cqP();
        this.ilw = new com.baidu.tieba.frs.gamesubpb.b(this.ikW.getPageContext(), this.fCT);
        this.ilw.setClickListener(new a.InterfaceC0685a() { // from class: com.baidu.tieba.frs.gamesubpb.view.a.6
            @Override // com.baidu.tieba.frs.gamesubpb.a.InterfaceC0685a
            public void a(d dVar) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonPolymericActivityConfig(a.this.ikW.getPageContext().getPageActivity()).createNormalConfig(Long.valueOf(dVar.userId).longValue(), String.valueOf(a.this.fJe).equals(dVar.userId), false)));
            }

            @Override // com.baidu.tieba.frs.gamesubpb.a.InterfaceC0685a
            public void b(d dVar) {
                if (dVar != null) {
                    a.this.d(dVar);
                }
            }

            @Override // com.baidu.tieba.frs.gamesubpb.a.InterfaceC0685a
            public void c(d dVar) {
                if (a.this.ikG != null) {
                    a.this.ikG.cqI();
                }
                if (dVar == null) {
                    a.this.ID(null);
                    a.this.cqR();
                    return;
                }
                a.this.ID(dVar.userName);
                a.this.ilz = dVar.userId;
            }
        });
        yc(140);
        cqQ();
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        this.ily = new ArrayList();
        this.fJe = com.baidu.adp.lib.f.b.toLong(TbadkCoreApplication.getCurrentAccount(), 0L);
    }

    private void cqP() {
        this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(R.id.view_navigation_bar);
        this.mBack = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        ImageView backImageView = this.mNavigationBar.getBackImageView();
        if (backImageView != null && (backImageView.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.mBack.getLayoutParams();
            int dimens = l.getDimens(this.ikW.getPageContext().getPageActivity(), R.dimen.ds30);
            layoutParams.height = dimens;
            layoutParams.width = dimens;
            backImageView.setLayoutParams(layoutParams);
        }
        if (this.mBack != null && (this.mBack.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.mBack.getLayoutParams();
            layoutParams2.width = -2;
            layoutParams2.height = -1;
            this.mBack.setPadding(l.getDimens(this.ikW.getPageContext().getPageActivity(), R.dimen.ds32), this.mBack.getPaddingTop(), this.mBack.getPaddingRight(), this.mBack.getPaddingBottom());
            this.mBack.setLayoutParams(layoutParams2);
        }
        if (this.mNavigationBar.getBackImageView() != null) {
            SvgManager.bjq().a(this.mNavigationBar.getBackImageView(), R.drawable.icon_pure_topbar_return44_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
    }

    private void cqQ() {
        this.globalListener = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tieba.frs.gamesubpb.view.a.7
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                Rect rect = new Rect();
                a.this.ikW.getPageContext().getPageActivity().getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
                int statusBarHeight = l.getStatusBarHeight(a.this.ikW.getPageContext().getPageActivity());
                int[] screenDimensions = l.getScreenDimensions(a.this.ikW.getPageContext().getPageActivity());
                if (screenDimensions[1] - rect.bottom > screenDimensions[1] / 4 && !a.this.mIsKeyboardOpen) {
                    a.this.mIsKeyboardOpen = true;
                    a.this.onKeyboardVisibilityChanged(true);
                } else if (screenDimensions[1] - rect.height() == statusBarHeight && a.this.mIsKeyboardOpen) {
                    a.this.mIsKeyboardOpen = false;
                    a.this.onKeyboardVisibilityChanged(false);
                }
            }
        };
        this.ikW.getPageContext().getPageActivity().getWindow().getDecorView().getViewTreeObserver().addOnGlobalLayoutListener(this.globalListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(final d dVar) {
        final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.ikW.getPageContext().getPageActivity());
        aVar.zz(null);
        aVar.nt(R.string.del_post_confirm);
        aVar.ih(true);
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
        aVar.b(this.ikW.getPageContext()).bhg();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(d dVar) {
        HttpMessage httpMessage = new HttpMessage(1003381);
        httpMessage.addParam("user_id", this.fJe);
        httpMessage.addParam("main_tower_id", dVar.ilm);
        httpMessage.addParam("id", dVar.id);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void IC(String str) {
        yd(0);
        HttpMessage httpMessage = new HttpMessage(1003380);
        httpMessage.addParam("user_id", this.fJe);
        httpMessage.addParam("reply_user_id", this.ilz);
        httpMessage.addParam("content", str);
        httpMessage.addParam("main_tower_id", this.ikK);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cqR() {
        this.ilz = this.ilx != null ? this.ilx.userId : null;
    }

    private void cqS() {
        if (!y.isEmpty(this.ily)) {
            this.mNavigationBar.setCenterTextTitle(String.format(this.ikW.getResources().getString(R.string.subpb_floor_reply_count), at.numFormatOver10000(this.ily.size())));
        } else {
            this.mNavigationBar.setCenterTextTitle(this.ikW.getResources().getString(R.string.reply));
        }
    }

    private void yc(final int i) {
        this.ils.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.frs.gamesubpb.view.a.10
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                if (!TextUtils.isEmpty(charSequence)) {
                    a.this.ilt.setEnabled(true);
                    String charSequence2 = charSequence.toString();
                    if (!StringUtils.isNull(charSequence2) && ae.getTextLength(charSequence2) > i) {
                        String subString = ae.subString(charSequence2, 0, i - 1);
                        a.this.ils.setText(subString);
                        a.this.ils.setSelection(a.this.ils.getText().length());
                        UtilHelper.showToast(a.this.ikW.getPageContext().getPageActivity().getApplication(), a.this.ikW.getPageContext().getPageActivity().getResources().getString(R.string.edit_text_over_limit_tip, Integer.valueOf(subString.length())));
                        return;
                    }
                    return;
                }
                a.this.cqR();
                a.this.ilt.setEnabled(false);
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
            }
        });
    }

    private void cqT() {
        if (this.mNavigationBar.getBackImageView() != null) {
            SvgManager.bjq().a(this.mNavigationBar.getBackImageView(), R.drawable.icon_pure_topbar_return44_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void oS(final boolean z) {
        if (this.fCT != null) {
            if (!z) {
                this.fCT.setEnabled(z);
            } else {
                this.fCT.postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.gamesubpb.view.a.11
                    @Override // java.lang.Runnable
                    public void run() {
                        a.this.fCT.setEnabled(z);
                    }
                }, 10L);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onKeyboardVisibilityChanged(boolean z) {
        if (z) {
            Rect rect = new Rect();
            this.eMO.getWindowVisibleDisplayFrame(rect);
            this.ilr.scrollTo(this.ilr.getScrollX(), (l.getScreenDimensions(this.ikW.getPageContext().getPageActivity())[1] - rect.bottom) - (MenuKeyUtils.hasSmartBar() ? l.dip2px(this.ikW.getPageContext().getPageActivity(), 48.0f) : 0));
            return;
        }
        this.ilr.setScrollY(0);
    }

    private void oT(boolean z) {
        if (y.isEmpty(this.ily)) {
            this.fCT.setNextPage(null);
            this.ilv.setVisibility(0);
        } else {
            this.fCT.setNextPage(this.ilq);
            this.ilv.setVisibility(8);
            if (z) {
                this.ilq.startLoadData();
            } else {
                this.ilq.endLoadData();
            }
        }
        cqS();
    }

    public void a(boolean z, com.baidu.tieba.frs.gamesubpb.model.b bVar, List<q> list) {
        this.hasMore = z;
        this.ilx = bVar;
        cqR();
        if (y.isEmpty(list)) {
            oT(z);
            return;
        }
        this.ily.clear();
        this.ily.addAll(list);
        this.ilv.setVisibility(8);
        this.fCT.setNextPage(this.ilq);
        this.ilw.setData(list);
        cqT();
        this.ilu.setVisibility(0);
        this.ilu.setText(R.string.say_your_point);
        oT(z);
    }

    public void a(boolean z, String str, d dVar) {
        yd(8);
        if (z && dVar != null) {
            BdToast.a(this.ikW.getPageContext().getPageActivity(), this.ikW.getPageContext().getString(R.string.subpb_add_comment_succ_tip), 1).bhm();
            this.ils.setText((CharSequence) null);
            this.ily.add(dVar);
            this.ilw.setData(this.ily);
            oT(this.hasMore);
            this.ils.post(new Runnable() { // from class: com.baidu.tieba.frs.gamesubpb.view.a.2
                @Override // java.lang.Runnable
                public void run() {
                    a.this.ils.requestFocus();
                    l.hideSoftKeyPad(a.this.ikW.getPageContext().getPageActivity(), a.this.ils);
                }
            });
            return;
        }
        if (TextUtils.isEmpty(str)) {
            str = this.ikW.getPageContext().getString(R.string.subpb_add_comment_fail_tip);
        }
        BdToast.a(this.ikW.getPageContext().getPageActivity(), str, 1).bhm();
    }

    public void b(boolean z, String str, d dVar) {
        if (z) {
            BdToast.a(this.ikW.getPageContext().getPageActivity(), this.ikW.getPageContext().getString(R.string.subpb_delete_comment_succ_tip), 1).bhm();
            this.ily.remove(dVar);
            this.ilw.setData(this.ily);
            oT(this.hasMore);
            return;
        }
        if (TextUtils.isEmpty(str)) {
            str = this.ikW.getPageContext().getString(R.string.subpb_delete_comment_fail_tip);
        }
        BdToast.a(this.ikW.getPageContext().getPageActivity(), str, 1).bhm();
    }

    public void oU(boolean z) {
        if (this.hIu != null && this.hIu.getLayoutParams() != null) {
            ViewGroup.LayoutParams layoutParams = this.hIu.getLayoutParams();
            if (z) {
                cqT();
                layoutParams.height = l.getDimens(this.ikW.getPageContext().getPageActivity(), R.dimen.ds98);
            } else {
                layoutParams.height = l.getDimens(this.ikW.getPageContext().getPageActivity(), R.dimen.ds98) + UtilHelper.getLightStatusBarHeight();
            }
            this.hIu.setLayoutParams(layoutParams);
        }
    }

    public void ck(View view) {
        if (this.hIu != null && this.mNavigationBar != null) {
            if (this.mNavigationBar.isNavigationBarExcludeStatusbarVisible()) {
                this.mNavigationBar.showNavigationBarExcludeStatusbar(false);
                if (UtilHelper.canUseStyleImmersiveSticky()) {
                    this.hIu.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight()));
                } else if (this.fCT != null) {
                    this.fCT.removeHeaderView(this.hIu);
                }
                this.mNavigationBar.setVisibility(8);
                return;
            }
            this.mNavigationBar.showNavigationBarExcludeStatusbar(true);
            if (UtilHelper.canUseStyleImmersiveSticky()) {
                this.hIu.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + l.getDimens(this.ikW.getActivity(), R.dimen.ds98)));
            } else if (this.fCT != null) {
                this.fCT.addHeaderView(this.hIu, 0);
            }
            this.mNavigationBar.setVisibility(0);
        }
    }

    public void ID(String str) {
        this.ilu.setVisibility(8);
        this.eMO.setVisibility(0);
        this.ils.post(new Runnable() { // from class: com.baidu.tieba.frs.gamesubpb.view.a.3
            @Override // java.lang.Runnable
            public void run() {
                a.this.ils.requestFocus();
                l.showSoftKeyPad(a.this.ikW.getPageContext().getPageActivity(), a.this.ils);
            }
        });
        if (!TextUtils.isEmpty(str)) {
            String format = String.format(this.ikW.getPageContext().getPageActivity().getResources().getString(R.string.reply_sub_floor), str);
            this.ils.setText(format);
            this.ils.setSelection(format.length());
        }
    }

    public void yd(int i) {
        this.mProgressBar.setVisibility(i);
    }

    public View cfO() {
        return this.hIu;
    }

    public View getRootView() {
        return this.mRootView;
    }

    public ListView getListView() {
        return this.fCT;
    }

    public TextView cqU() {
        return this.ilu;
    }

    public NavigationBar bJI() {
        return this.mNavigationBar;
    }

    public void e(com.baidu.tieba.frs.gamesubpb.c cVar) {
        this.ikG = cVar;
    }

    public void b(BdListView.e eVar) {
        this.fCT.setOnSrollToBottomListener(eVar);
    }

    public void onChangeSkinType(int i) {
        this.ikW.getLayoutMode().setNightMode(i == 1);
        this.ikW.getLayoutMode().onModeChanged(this.mRootView);
        ap.setBackgroundColor(this.mRootView, R.color.cp_bg_line_d);
        this.mNavigationBar.onChangeSkinType(this.ikW.getPageContext(), i);
        this.ilq.changeSkin(i);
        ap.setViewTextColor(this.ilu, (int) R.color.cp_cont_e);
        this.ilu.setAlpha(0.95f);
        ap.setBackgroundResource(this.ilu, R.drawable.pb_ecomm_comment_bg);
        ap.setViewTextColor(this.ilv, (int) R.color.cp_cont_d);
        ap.setBackgroundResource(this.eMO, R.drawable.pb_ecomm_comment_bg);
        ap.setViewTextColor(this.ils, (int) R.color.cp_cont_f);
        this.ils.setHintTextColor(ap.getColor(R.color.cp_cont_e));
        ap.setViewTextColor(this.ilt, (int) R.color.game_sub_pb_send_txt_color);
    }

    public void onDestroy() {
        if (this.globalListener != null) {
            this.ikW.getPageContext().getPageActivity().getWindow().getDecorView().getViewTreeObserver().removeGlobalOnLayoutListener(this.globalListener);
        }
    }
}
