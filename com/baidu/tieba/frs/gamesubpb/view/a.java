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
/* loaded from: classes21.dex */
public class a {
    private View.OnClickListener aTZ;
    private c eHq = new c(new c.a() { // from class: com.baidu.tieba.frs.gamesubpb.view.a.1
        @Override // com.baidu.tieba.pb.a.c.a
        public boolean onDoubleTap(View view, MotionEvent motionEvent) {
            a.this.oY(false);
            a.this.ct(view);
            a.this.oY(true);
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
    private LinearLayout ePF;
    private BdTypeListView fGf;
    private long fMt;
    private ViewTreeObserver.OnGlobalLayoutListener globalListener;
    private View hPv;
    private boolean hasMore;
    private com.baidu.tieba.frs.gamesubpb.c irI;
    private String irM;
    private FrsGameSubPbActivity irY;
    private List<q> isA;
    private String isB;
    private e iss;
    private FrameLayout ist;
    private EditText isu;
    private TextView isv;
    private TextView isw;
    private TextView isx;
    private com.baidu.tieba.frs.gamesubpb.b isy;
    private com.baidu.tieba.frs.gamesubpb.model.b isz;
    private View mBack;
    private boolean mIsKeyboardOpen;
    private NavigationBar mNavigationBar;
    private ProgressBar mProgressBar;
    private RelativeLayout mRootView;

    public a(FrsGameSubPbActivity frsGameSubPbActivity, View.OnClickListener onClickListener, String str) {
        this.irY = frsGameSubPbActivity;
        this.aTZ = onClickListener;
        this.irM = str;
        this.mRootView = (RelativeLayout) LayoutInflater.from(frsGameSubPbActivity.getPageContext().getPageActivity()).inflate(R.layout.frs_game_sub_pb_activity, (ViewGroup) null);
        this.fGf = (BdTypeListView) this.mRootView.findViewById(R.id.new_sub_pb_list);
        this.fGf.setOnTouchListener(this.eHq);
        this.fGf.setOnScrollListener(new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.frs.gamesubpb.view.a.4
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
                if (i != 0) {
                    l.hideSoftKeyPad(a.this.irY.getPageContext().getPageActivity(), a.this.isu);
                }
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            }
        });
        this.iss = new e(this.irY.getPageContext());
        this.hPv = BdListViewHelper.a(this.irY.getActivity(), this.fGf, BdListViewHelper.HeadType.DEFAULT);
        this.isw = (TextView) this.mRootView.findViewById(R.id.subpb_editor_tool_comment_reply_text);
        this.isw.setOnClickListener(this.aTZ);
        this.isx = (TextView) this.mRootView.findViewById(R.id.no_reply_list_view);
        this.ist = (FrameLayout) this.mRootView.findViewById(R.id.bottom_view);
        this.ePF = (LinearLayout) this.mRootView.findViewById(R.id.subpb_editor_tool_comment_input_container);
        this.isu = (EditText) this.mRootView.findViewById(R.id.subpb_editor_tool_comment_input_edit);
        this.isv = (TextView) this.mRootView.findViewById(R.id.subpb_editor_tool_comment_send_tv);
        this.isv.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.gamesubpb.view.a.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.IZ(a.this.isu.getText().toString());
            }
        });
        this.mProgressBar = (ProgressBar) this.mRootView.findViewById(R.id.progressBar);
        cuc();
        this.isy = new com.baidu.tieba.frs.gamesubpb.b(this.irY.getPageContext(), this.fGf);
        this.isy.setClickListener(new a.InterfaceC0682a() { // from class: com.baidu.tieba.frs.gamesubpb.view.a.6
            @Override // com.baidu.tieba.frs.gamesubpb.a.InterfaceC0682a
            public void a(d dVar) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonPolymericActivityConfig(a.this.irY.getPageContext().getPageActivity()).createNormalConfig(Long.valueOf(dVar.userId).longValue(), String.valueOf(a.this.fMt).equals(dVar.userId), false)));
            }

            @Override // com.baidu.tieba.frs.gamesubpb.a.InterfaceC0682a
            public void b(d dVar) {
                if (dVar != null) {
                    a.this.d(dVar);
                }
            }

            @Override // com.baidu.tieba.frs.gamesubpb.a.InterfaceC0682a
            public void c(d dVar) {
                if (a.this.irI != null) {
                    a.this.irI.ctV();
                }
                if (dVar == null) {
                    a.this.Ja(null);
                    a.this.cue();
                    return;
                }
                a.this.Ja(dVar.userName);
                a.this.isB = dVar.userId;
            }
        });
        yB(140);
        cud();
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        this.isA = new ArrayList();
        this.fMt = com.baidu.adp.lib.f.b.toLong(TbadkCoreApplication.getCurrentAccount(), 0L);
    }

    private void cuc() {
        this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(R.id.view_navigation_bar);
        this.mBack = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        ImageView backImageView = this.mNavigationBar.getBackImageView();
        if (backImageView != null && (backImageView.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.mBack.getLayoutParams();
            int dimens = l.getDimens(this.irY.getPageContext().getPageActivity(), R.dimen.ds30);
            layoutParams.height = dimens;
            layoutParams.width = dimens;
            backImageView.setLayoutParams(layoutParams);
        }
        if (this.mBack != null && (this.mBack.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.mBack.getLayoutParams();
            layoutParams2.width = -2;
            layoutParams2.height = -1;
            this.mBack.setPadding(l.getDimens(this.irY.getPageContext().getPageActivity(), R.dimen.ds32), this.mBack.getPaddingTop(), this.mBack.getPaddingRight(), this.mBack.getPaddingBottom());
            this.mBack.setLayoutParams(layoutParams2);
        }
        if (this.mNavigationBar.getBackImageView() != null) {
            SvgManager.bkl().a(this.mNavigationBar.getBackImageView(), R.drawable.icon_pure_topbar_return44_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
    }

    private void cud() {
        this.globalListener = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tieba.frs.gamesubpb.view.a.7
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                Rect rect = new Rect();
                a.this.irY.getPageContext().getPageActivity().getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
                int statusBarHeight = l.getStatusBarHeight(a.this.irY.getPageContext().getPageActivity());
                int[] screenDimensions = l.getScreenDimensions(a.this.irY.getPageContext().getPageActivity());
                if (screenDimensions[1] - rect.bottom > screenDimensions[1] / 4 && !a.this.mIsKeyboardOpen) {
                    a.this.mIsKeyboardOpen = true;
                    a.this.onKeyboardVisibilityChanged(true);
                } else if (screenDimensions[1] - rect.height() == statusBarHeight && a.this.mIsKeyboardOpen) {
                    a.this.mIsKeyboardOpen = false;
                    a.this.onKeyboardVisibilityChanged(false);
                }
            }
        };
        this.irY.getPageContext().getPageActivity().getWindow().getDecorView().getViewTreeObserver().addOnGlobalLayoutListener(this.globalListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(final d dVar) {
        final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.irY.getPageContext().getPageActivity());
        aVar.zU(null);
        aVar.nE(R.string.del_post_confirm);
        aVar.ie(true);
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
        aVar.b(this.irY.getPageContext()).bia();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(d dVar) {
        HttpMessage httpMessage = new HttpMessage(1003381);
        httpMessage.addParam("user_id", this.fMt);
        httpMessage.addParam("main_tower_id", dVar.iso);
        httpMessage.addParam("id", dVar.id);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void IZ(String str) {
        yC(0);
        HttpMessage httpMessage = new HttpMessage(1003380);
        httpMessage.addParam("user_id", this.fMt);
        httpMessage.addParam("reply_user_id", this.isB);
        httpMessage.addParam("content", str);
        httpMessage.addParam("main_tower_id", this.irM);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cue() {
        this.isB = this.isz != null ? this.isz.userId : null;
    }

    private void cuf() {
        if (!y.isEmpty(this.isA)) {
            this.mNavigationBar.setCenterTextTitle(String.format(this.irY.getResources().getString(R.string.subpb_floor_reply_count), at.numFormatOver10000(this.isA.size())));
        } else {
            this.mNavigationBar.setCenterTextTitle(this.irY.getResources().getString(R.string.reply));
        }
    }

    private void yB(final int i) {
        this.isu.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.frs.gamesubpb.view.a.10
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                if (!TextUtils.isEmpty(charSequence)) {
                    a.this.isv.setEnabled(true);
                    String charSequence2 = charSequence.toString();
                    if (!StringUtils.isNull(charSequence2) && af.getTextLength(charSequence2) > i) {
                        String subString = af.subString(charSequence2, 0, i - 1);
                        a.this.isu.setText(subString);
                        a.this.isu.setSelection(a.this.isu.getText().length());
                        UtilHelper.showToast(a.this.irY.getPageContext().getPageActivity().getApplication(), a.this.irY.getPageContext().getPageActivity().getResources().getString(R.string.edit_text_over_limit_tip, Integer.valueOf(subString.length())));
                        return;
                    }
                    return;
                }
                a.this.cue();
                a.this.isv.setEnabled(false);
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
            }
        });
    }

    private void cug() {
        if (this.mNavigationBar.getBackImageView() != null) {
            SvgManager.bkl().a(this.mNavigationBar.getBackImageView(), R.drawable.icon_pure_topbar_return44_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void oY(final boolean z) {
        if (this.fGf != null) {
            if (!z) {
                this.fGf.setEnabled(z);
            } else {
                this.fGf.postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.gamesubpb.view.a.11
                    @Override // java.lang.Runnable
                    public void run() {
                        a.this.fGf.setEnabled(z);
                    }
                }, 10L);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onKeyboardVisibilityChanged(boolean z) {
        if (z) {
            Rect rect = new Rect();
            this.ePF.getWindowVisibleDisplayFrame(rect);
            this.ist.scrollTo(this.ist.getScrollX(), (l.getScreenDimensions(this.irY.getPageContext().getPageActivity())[1] - rect.bottom) - (MenuKeyUtils.hasSmartBar() ? l.dip2px(this.irY.getPageContext().getPageActivity(), 48.0f) : 0));
            return;
        }
        this.ist.setScrollY(0);
    }

    private void oZ(boolean z) {
        if (y.isEmpty(this.isA)) {
            this.fGf.setNextPage(null);
            this.isx.setVisibility(0);
        } else {
            this.fGf.setNextPage(this.iss);
            this.isx.setVisibility(8);
            if (z) {
                this.iss.startLoadData();
            } else {
                this.iss.endLoadData();
            }
        }
        cuf();
    }

    public void a(boolean z, com.baidu.tieba.frs.gamesubpb.model.b bVar, List<q> list) {
        this.hasMore = z;
        this.isz = bVar;
        cue();
        if (y.isEmpty(list)) {
            oZ(z);
            return;
        }
        this.isA.clear();
        this.isA.addAll(list);
        this.isx.setVisibility(8);
        this.fGf.setNextPage(this.iss);
        this.isy.setData(list);
        cug();
        this.isw.setVisibility(0);
        this.isw.setText(R.string.say_your_point);
        oZ(z);
    }

    public void a(boolean z, String str, d dVar) {
        yC(8);
        if (z && dVar != null) {
            BdToast.a(this.irY.getPageContext().getPageActivity(), this.irY.getPageContext().getString(R.string.subpb_add_comment_succ_tip), 1).big();
            this.isu.setText((CharSequence) null);
            this.isA.add(dVar);
            this.isy.setData(this.isA);
            oZ(this.hasMore);
            this.isu.post(new Runnable() { // from class: com.baidu.tieba.frs.gamesubpb.view.a.2
                @Override // java.lang.Runnable
                public void run() {
                    a.this.isu.requestFocus();
                    l.hideSoftKeyPad(a.this.irY.getPageContext().getPageActivity(), a.this.isu);
                }
            });
            return;
        }
        if (TextUtils.isEmpty(str)) {
            str = this.irY.getPageContext().getString(R.string.subpb_add_comment_fail_tip);
        }
        BdToast.a(this.irY.getPageContext().getPageActivity(), str, 1).big();
    }

    public void b(boolean z, String str, d dVar) {
        if (z) {
            BdToast.a(this.irY.getPageContext().getPageActivity(), this.irY.getPageContext().getString(R.string.subpb_delete_comment_succ_tip), 1).big();
            this.isA.remove(dVar);
            this.isy.setData(this.isA);
            oZ(this.hasMore);
            return;
        }
        if (TextUtils.isEmpty(str)) {
            str = this.irY.getPageContext().getString(R.string.subpb_delete_comment_fail_tip);
        }
        BdToast.a(this.irY.getPageContext().getPageActivity(), str, 1).big();
    }

    public void pa(boolean z) {
        if (this.hPv != null && this.hPv.getLayoutParams() != null) {
            ViewGroup.LayoutParams layoutParams = this.hPv.getLayoutParams();
            if (z) {
                cug();
                layoutParams.height = l.getDimens(this.irY.getPageContext().getPageActivity(), R.dimen.ds98);
            } else {
                layoutParams.height = l.getDimens(this.irY.getPageContext().getPageActivity(), R.dimen.ds98) + UtilHelper.getLightStatusBarHeight();
            }
            this.hPv.setLayoutParams(layoutParams);
        }
    }

    public void ct(View view) {
        if (this.hPv != null && this.mNavigationBar != null) {
            if (this.mNavigationBar.isNavigationBarExcludeStatusbarVisible()) {
                this.mNavigationBar.showNavigationBarExcludeStatusbar(false);
                if (UtilHelper.canUseStyleImmersiveSticky()) {
                    this.hPv.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight()));
                } else if (this.fGf != null) {
                    this.fGf.removeHeaderView(this.hPv);
                }
                this.mNavigationBar.setVisibility(8);
                return;
            }
            this.mNavigationBar.showNavigationBarExcludeStatusbar(true);
            if (UtilHelper.canUseStyleImmersiveSticky()) {
                this.hPv.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + l.getDimens(this.irY.getActivity(), R.dimen.ds98)));
            } else if (this.fGf != null) {
                this.fGf.addHeaderView(this.hPv, 0);
            }
            this.mNavigationBar.setVisibility(0);
        }
    }

    public void Ja(String str) {
        this.isw.setVisibility(8);
        this.ePF.setVisibility(0);
        this.isu.post(new Runnable() { // from class: com.baidu.tieba.frs.gamesubpb.view.a.3
            @Override // java.lang.Runnable
            public void run() {
                a.this.isu.requestFocus();
                l.showSoftKeyPad(a.this.irY.getPageContext().getPageActivity(), a.this.isu);
            }
        });
        if (!TextUtils.isEmpty(str)) {
            String format = String.format(this.irY.getPageContext().getPageActivity().getResources().getString(R.string.reply_sub_floor), str);
            this.isu.setText(format);
            this.isu.setSelection(format.length());
        }
    }

    public void yC(int i) {
        this.mProgressBar.setVisibility(i);
    }

    public View cjf() {
        return this.hPv;
    }

    public View getRootView() {
        return this.mRootView;
    }

    public ListView getListView() {
        return this.fGf;
    }

    public TextView cuh() {
        return this.isw;
    }

    public NavigationBar bKS() {
        return this.mNavigationBar;
    }

    public void e(com.baidu.tieba.frs.gamesubpb.c cVar) {
        this.irI = cVar;
    }

    public void b(BdListView.e eVar) {
        this.fGf.setOnSrollToBottomListener(eVar);
    }

    public void onChangeSkinType(int i) {
        this.irY.getLayoutMode().setNightMode(i == 1);
        this.irY.getLayoutMode().onModeChanged(this.mRootView);
        ap.setBackgroundColor(this.mRootView, R.color.cp_bg_line_d);
        this.mNavigationBar.onChangeSkinType(this.irY.getPageContext(), i);
        this.iss.changeSkin(i);
        ap.setViewTextColor(this.isw, (int) R.color.cp_cont_e);
        this.isw.setAlpha(0.95f);
        ap.setBackgroundResource(this.isw, R.drawable.pb_ecomm_comment_bg);
        ap.setViewTextColor(this.isx, (int) R.color.cp_cont_d);
        ap.setBackgroundResource(this.ePF, R.drawable.pb_ecomm_comment_bg);
        ap.setViewTextColor(this.isu, (int) R.color.cp_cont_f);
        this.isu.setHintTextColor(ap.getColor(R.color.cp_cont_e));
        ap.setViewTextColor(this.isv, (int) R.color.game_sub_pb_send_txt_color);
    }

    public void onDestroy() {
        if (this.globalListener != null) {
            this.irY.getPageContext().getPageActivity().getWindow().getDecorView().getViewTreeObserver().removeGlobalOnLayoutListener(this.globalListener);
        }
    }
}
