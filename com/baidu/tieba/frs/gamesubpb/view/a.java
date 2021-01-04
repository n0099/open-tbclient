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
import com.baidu.adp.widget.ListView.n;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PersonPolymericActivityConfig;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tbadk.util.ad;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.gamesubpb.FrsGameSubPbActivity;
import com.baidu.tieba.frs.gamesubpb.a;
import com.baidu.tieba.frs.gamesubpb.b;
import com.baidu.tieba.frs.gamesubpb.model.d;
import com.baidu.tieba.frs.gamesubpb.model.e;
import com.baidu.tieba.pb.a.c;
import com.compatible.menukey.MenuKeyUtils;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class a {
    private View.OnClickListener bdp;
    private LinearLayout fGv;
    private c fyb = new c(new c.a() { // from class: com.baidu.tieba.frs.gamesubpb.view.a.1
        @Override // com.baidu.tieba.pb.a.c.a
        public boolean onDoubleTap(View view, MotionEvent motionEvent) {
            a.this.rg(false);
            a.this.db(view);
            a.this.rg(true);
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
    private BdTypeListView gAY;
    private long gHx;
    private ViewTreeObserver.OnGlobalLayoutListener globalListener;
    private boolean hasMore;
    private View iUJ;
    private e jAq;
    private FrameLayout jAr;
    private EditText jAs;
    private TextView jAt;
    private TextView jAu;
    private TextView jAv;
    private b jAw;
    private com.baidu.tieba.frs.gamesubpb.model.b jAx;
    private List<n> jAy;
    private String jAz;
    private com.baidu.tieba.frs.gamesubpb.c jzG;
    private String jzK;
    private FrsGameSubPbActivity jzW;
    private View mBack;
    private boolean mIsKeyboardOpen;
    private NavigationBar mNavigationBar;
    private ProgressBar mProgressBar;
    private RelativeLayout mRootView;

    public a(FrsGameSubPbActivity frsGameSubPbActivity, View.OnClickListener onClickListener, String str) {
        this.jzW = frsGameSubPbActivity;
        this.bdp = onClickListener;
        this.jzK = str;
        this.mRootView = (RelativeLayout) LayoutInflater.from(frsGameSubPbActivity.getPageContext().getPageActivity()).inflate(R.layout.frs_game_sub_pb_activity, (ViewGroup) null);
        this.gAY = (BdTypeListView) this.mRootView.findViewById(R.id.new_sub_pb_list);
        this.gAY.setOnTouchListener(this.fyb);
        this.gAY.setOnScrollListener(new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.frs.gamesubpb.view.a.4
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
                if (i != 0) {
                    l.hideSoftKeyPad(a.this.jzW.getPageContext().getPageActivity(), a.this.jAs);
                }
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            }
        });
        this.jAq = new e(this.jzW.getPageContext());
        this.iUJ = BdListViewHelper.a(this.jzW.getActivity(), this.gAY, BdListViewHelper.HeadType.DEFAULT);
        this.jAu = (TextView) this.mRootView.findViewById(R.id.subpb_editor_tool_comment_reply_text);
        this.jAu.setOnClickListener(this.bdp);
        this.jAv = (TextView) this.mRootView.findViewById(R.id.no_reply_list_view);
        this.jAr = (FrameLayout) this.mRootView.findViewById(R.id.bottom_view);
        this.fGv = (LinearLayout) this.mRootView.findViewById(R.id.subpb_editor_tool_comment_input_container);
        this.jAs = (EditText) this.mRootView.findViewById(R.id.subpb_editor_tool_comment_input_edit);
        this.jAt = (TextView) this.mRootView.findViewById(R.id.subpb_editor_tool_comment_send_tv);
        this.jAt.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.gamesubpb.view.a.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.Lj(a.this.jAs.getText().toString());
            }
        });
        this.mProgressBar = (ProgressBar) this.mRootView.findViewById(R.id.progressBar);
        cKX();
        this.jAw = new b(this.jzW.getPageContext(), this.gAY);
        this.jAw.setClickListener(new a.InterfaceC0740a() { // from class: com.baidu.tieba.frs.gamesubpb.view.a.6
            @Override // com.baidu.tieba.frs.gamesubpb.a.InterfaceC0740a
            public void a(d dVar) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonPolymericActivityConfig(a.this.jzW.getPageContext().getPageActivity()).createNormalConfig(Long.valueOf(dVar.userId).longValue(), String.valueOf(a.this.gHx).equals(dVar.userId), false)));
            }

            @Override // com.baidu.tieba.frs.gamesubpb.a.InterfaceC0740a
            public void b(d dVar) {
                if (dVar != null) {
                    a.this.d(dVar);
                }
            }

            @Override // com.baidu.tieba.frs.gamesubpb.a.InterfaceC0740a
            public void c(d dVar) {
                if (a.this.jzG != null) {
                    a.this.jzG.cKQ();
                }
                if (dVar == null) {
                    a.this.Lk(null);
                    a.this.cKZ();
                    return;
                }
                a.this.Lk(dVar.userName);
                a.this.jAz = dVar.userId;
            }
        });
        Bl(140);
        cKY();
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        this.jAy = new ArrayList();
        this.gHx = com.baidu.adp.lib.f.b.toLong(TbadkCoreApplication.getCurrentAccount(), 0L);
    }

    private void cKX() {
        this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(R.id.view_navigation_bar);
        this.mBack = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        ImageView backImageView = this.mNavigationBar.getBackImageView();
        if (backImageView != null && (backImageView.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.mBack.getLayoutParams();
            int dimens = l.getDimens(this.jzW.getPageContext().getPageActivity(), R.dimen.ds30);
            layoutParams.height = dimens;
            layoutParams.width = dimens;
            backImageView.setLayoutParams(layoutParams);
        }
        if (this.mBack != null && (this.mBack.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.mBack.getLayoutParams();
            layoutParams2.width = -2;
            layoutParams2.height = -1;
            this.mBack.setPadding(l.getDimens(this.jzW.getPageContext().getPageActivity(), R.dimen.ds32), this.mBack.getPaddingTop(), this.mBack.getPaddingRight(), this.mBack.getPaddingBottom());
            this.mBack.setLayoutParams(layoutParams2);
        }
        if (this.mNavigationBar.getBackImageView() != null) {
            SvgManager.bwq().a(this.mNavigationBar.getBackImageView(), R.drawable.ic_icon_pure_topbar_return40_svg, R.color.CAM_X0106, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
    }

    private void cKY() {
        this.globalListener = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tieba.frs.gamesubpb.view.a.7
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                Rect rect = new Rect();
                a.this.jzW.getPageContext().getPageActivity().getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
                int statusBarHeight = l.getStatusBarHeight(a.this.jzW.getPageContext().getPageActivity());
                int[] screenDimensions = l.getScreenDimensions(a.this.jzW.getPageContext().getPageActivity());
                if (screenDimensions[1] - rect.bottom > screenDimensions[1] / 4 && !a.this.mIsKeyboardOpen) {
                    a.this.mIsKeyboardOpen = true;
                    a.this.onKeyboardVisibilityChanged(true);
                } else if (screenDimensions[1] - rect.height() == statusBarHeight && a.this.mIsKeyboardOpen) {
                    a.this.mIsKeyboardOpen = false;
                    a.this.onKeyboardVisibilityChanged(false);
                }
            }
        };
        this.jzW.getPageContext().getPageActivity().getWindow().getDecorView().getViewTreeObserver().addOnGlobalLayoutListener(this.globalListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(final d dVar) {
        final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.jzW.getPageContext().getPageActivity());
        aVar.Bo(null);
        aVar.pa(R.string.del_post_confirm);
        aVar.jI(true);
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
        aVar.b(this.jzW.getPageContext()).btX();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(d dVar) {
        HttpMessage httpMessage = new HttpMessage(1003381);
        httpMessage.addParam("user_id", this.gHx);
        httpMessage.addParam("main_tower_id", dVar.jAm);
        httpMessage.addParam("id", dVar.id);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Lj(String str) {
        Bm(0);
        HttpMessage httpMessage = new HttpMessage(1003380);
        httpMessage.addParam("user_id", this.gHx);
        httpMessage.addParam("reply_user_id", this.jAz);
        httpMessage.addParam("content", str);
        httpMessage.addParam("main_tower_id", this.jzK);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cKZ() {
        this.jAz = this.jAx != null ? this.jAx.userId : null;
    }

    private void cLa() {
        if (!x.isEmpty(this.jAy)) {
            this.mNavigationBar.setCenterTextTitle(String.format(this.jzW.getResources().getString(R.string.subpb_floor_reply_count), at.numFormatOver10000(this.jAy.size())));
        } else {
            this.mNavigationBar.setCenterTextTitle(this.jzW.getResources().getString(R.string.reply));
        }
    }

    private void Bl(final int i) {
        this.jAs.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.frs.gamesubpb.view.a.10
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                if (!TextUtils.isEmpty(charSequence)) {
                    a.this.jAt.setEnabled(true);
                    String charSequence2 = charSequence.toString();
                    if (!StringUtils.isNull(charSequence2) && ad.getTextLength(charSequence2) > i) {
                        String subString = ad.subString(charSequence2, 0, i - 1);
                        a.this.jAs.setText(subString);
                        a.this.jAs.setSelection(a.this.jAs.getText().length());
                        UtilHelper.showToast(a.this.jzW.getPageContext().getPageActivity().getApplication(), a.this.jzW.getPageContext().getPageActivity().getResources().getString(R.string.edit_text_over_limit_tip, Integer.valueOf(subString.length())));
                        return;
                    }
                    return;
                }
                a.this.cKZ();
                a.this.jAt.setEnabled(false);
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
            }
        });
    }

    private void cLb() {
        if (this.mNavigationBar.getBackImageView() != null) {
            SvgManager.bwq().a(this.mNavigationBar.getBackImageView(), R.drawable.ic_icon_pure_topbar_return40_svg, R.color.CAM_X0106, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rg(final boolean z) {
        if (this.gAY != null) {
            if (!z) {
                this.gAY.setEnabled(z);
            } else {
                this.gAY.postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.gamesubpb.view.a.11
                    @Override // java.lang.Runnable
                    public void run() {
                        a.this.gAY.setEnabled(z);
                    }
                }, 10L);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onKeyboardVisibilityChanged(boolean z) {
        if (z) {
            Rect rect = new Rect();
            this.fGv.getWindowVisibleDisplayFrame(rect);
            this.jAr.scrollTo(this.jAr.getScrollX(), (l.getScreenDimensions(this.jzW.getPageContext().getPageActivity())[1] - rect.bottom) - (MenuKeyUtils.hasSmartBar() ? l.dip2px(this.jzW.getPageContext().getPageActivity(), 48.0f) : 0));
            return;
        }
        this.jAr.setScrollY(0);
    }

    private void rh(boolean z) {
        if (x.isEmpty(this.jAy)) {
            this.gAY.setNextPage(null);
            this.jAv.setVisibility(0);
        } else {
            this.gAY.setNextPage(this.jAq);
            this.jAv.setVisibility(8);
            if (z) {
                this.jAq.startLoadData();
            } else {
                this.jAq.endLoadData();
            }
        }
        cLa();
    }

    public void a(boolean z, com.baidu.tieba.frs.gamesubpb.model.b bVar, List<n> list) {
        this.hasMore = z;
        this.jAx = bVar;
        cKZ();
        if (x.isEmpty(list)) {
            rh(z);
            return;
        }
        this.jAy.clear();
        this.jAy.addAll(list);
        this.jAv.setVisibility(8);
        this.gAY.setNextPage(this.jAq);
        this.jAw.setData(list);
        cLb();
        this.jAu.setVisibility(0);
        this.jAu.setText(R.string.say_your_point);
        rh(z);
    }

    public void a(boolean z, String str, d dVar) {
        Bm(8);
        if (z && dVar != null) {
            BdToast.b(this.jzW.getPageContext().getPageActivity(), this.jzW.getPageContext().getString(R.string.subpb_add_comment_succ_tip), 1).bud();
            this.jAs.setText((CharSequence) null);
            this.jAy.add(dVar);
            this.jAw.setData(this.jAy);
            rh(this.hasMore);
            this.jAs.post(new Runnable() { // from class: com.baidu.tieba.frs.gamesubpb.view.a.2
                @Override // java.lang.Runnable
                public void run() {
                    a.this.jAs.requestFocus();
                    l.hideSoftKeyPad(a.this.jzW.getPageContext().getPageActivity(), a.this.jAs);
                }
            });
            return;
        }
        if (TextUtils.isEmpty(str)) {
            str = this.jzW.getPageContext().getString(R.string.subpb_add_comment_fail_tip);
        }
        BdToast.b(this.jzW.getPageContext().getPageActivity(), str, 1).bud();
    }

    public void b(boolean z, String str, d dVar) {
        if (z) {
            BdToast.b(this.jzW.getPageContext().getPageActivity(), this.jzW.getPageContext().getString(R.string.subpb_delete_comment_succ_tip), 1).bud();
            this.jAy.remove(dVar);
            this.jAw.setData(this.jAy);
            rh(this.hasMore);
            return;
        }
        if (TextUtils.isEmpty(str)) {
            str = this.jzW.getPageContext().getString(R.string.subpb_delete_comment_fail_tip);
        }
        BdToast.b(this.jzW.getPageContext().getPageActivity(), str, 1).bud();
    }

    public void ri(boolean z) {
        if (this.iUJ != null && this.iUJ.getLayoutParams() != null) {
            ViewGroup.LayoutParams layoutParams = this.iUJ.getLayoutParams();
            if (z) {
                cLb();
                layoutParams.height = l.getDimens(this.jzW.getPageContext().getPageActivity(), R.dimen.ds98);
            } else {
                layoutParams.height = l.getDimens(this.jzW.getPageContext().getPageActivity(), R.dimen.ds98) + UtilHelper.getLightStatusBarHeight();
            }
            this.iUJ.setLayoutParams(layoutParams);
        }
    }

    public void db(View view) {
        if (this.iUJ != null && this.mNavigationBar != null) {
            if (this.mNavigationBar.isNavigationBarExcludeStatusbarVisible()) {
                this.mNavigationBar.showNavigationBarExcludeStatusbar(false);
                if (UtilHelper.canUseStyleImmersiveSticky()) {
                    this.iUJ.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight()));
                } else if (this.gAY != null) {
                    this.gAY.removeHeaderView(this.iUJ);
                }
                this.mNavigationBar.setVisibility(8);
                return;
            }
            this.mNavigationBar.showNavigationBarExcludeStatusbar(true);
            if (UtilHelper.canUseStyleImmersiveSticky()) {
                this.iUJ.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + l.getDimens(this.jzW.getActivity(), R.dimen.ds98)));
            } else if (this.gAY != null) {
                this.gAY.addHeaderView(this.iUJ, 0);
            }
            this.mNavigationBar.setVisibility(0);
        }
    }

    public void Lk(String str) {
        this.jAu.setVisibility(8);
        this.fGv.setVisibility(0);
        this.jAs.post(new Runnable() { // from class: com.baidu.tieba.frs.gamesubpb.view.a.3
            @Override // java.lang.Runnable
            public void run() {
                a.this.jAs.requestFocus();
                l.showSoftKeyPad(a.this.jzW.getPageContext().getPageActivity(), a.this.jAs);
            }
        });
        if (!TextUtils.isEmpty(str)) {
            String format = String.format(this.jzW.getPageContext().getPageActivity().getResources().getString(R.string.reply_sub_floor), str);
            this.jAs.setText(format);
            this.jAs.setSelection(format.length());
        }
    }

    public void Bm(int i) {
        this.mProgressBar.setVisibility(i);
    }

    public View cyV() {
        return this.iUJ;
    }

    public View getRootView() {
        return this.mRootView;
    }

    public ListView getListView() {
        return this.gAY;
    }

    public TextView cLc() {
        return this.jAu;
    }

    public NavigationBar bYq() {
        return this.mNavigationBar;
    }

    public void e(com.baidu.tieba.frs.gamesubpb.c cVar) {
        this.jzG = cVar;
    }

    public void b(BdListView.e eVar) {
        this.gAY.setOnSrollToBottomListener(eVar);
    }

    public void onChangeSkinType(int i) {
        this.jzW.getLayoutMode().setNightMode(i == 1);
        this.jzW.getLayoutMode().onModeChanged(this.mRootView);
        ao.setBackgroundColor(this.mRootView, R.color.CAM_X0201);
        this.mNavigationBar.onChangeSkinType(this.jzW.getPageContext(), i);
        this.jAq.changeSkin(i);
        ao.setViewTextColor(this.jAu, R.color.CAM_X0110);
        this.jAu.setAlpha(0.95f);
        ao.setBackgroundResource(this.jAu, R.drawable.pb_ecomm_comment_bg);
        ao.setViewTextColor(this.jAv, R.color.CAM_X0109);
        ao.setBackgroundResource(this.fGv, R.drawable.pb_ecomm_comment_bg);
        ao.setViewTextColor(this.jAs, R.color.CAM_X0106);
        this.jAs.setHintTextColor(ao.getColor(R.color.CAM_X0110));
        ao.setViewTextColor(this.jAt, R.color.game_sub_pb_send_txt_color);
    }

    public void onDestroy() {
        if (this.globalListener != null) {
            this.jzW.getPageContext().getPageActivity().getWindow().getDecorView().getViewTreeObserver().removeGlobalOnLayoutListener(this.globalListener);
        }
    }
}
