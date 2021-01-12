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
    private View.OnClickListener aYB;
    private LinearLayout fBO;
    private c ftt = new c(new c.a() { // from class: com.baidu.tieba.frs.gamesubpb.view.a.1
        @Override // com.baidu.tieba.pb.a.c.a
        public boolean onDoubleTap(View view, MotionEvent motionEvent) {
            a.this.rc(false);
            a.this.db(view);
            a.this.rc(true);
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
    private long gCR;
    private ViewTreeObserver.OnGlobalLayoutListener globalListener;
    private BdTypeListView gwr;
    private boolean hasMore;
    private View iQc;
    private e jvK;
    private FrameLayout jvL;
    private EditText jvM;
    private TextView jvN;
    private TextView jvO;
    private TextView jvP;
    private b jvQ;
    private com.baidu.tieba.frs.gamesubpb.model.b jvR;
    private List<n> jvS;
    private String jvT;
    private com.baidu.tieba.frs.gamesubpb.c jva;
    private String jve;
    private FrsGameSubPbActivity jvq;
    private View mBack;
    private boolean mIsKeyboardOpen;
    private NavigationBar mNavigationBar;
    private ProgressBar mProgressBar;
    private RelativeLayout mRootView;

    public a(FrsGameSubPbActivity frsGameSubPbActivity, View.OnClickListener onClickListener, String str) {
        this.jvq = frsGameSubPbActivity;
        this.aYB = onClickListener;
        this.jve = str;
        this.mRootView = (RelativeLayout) LayoutInflater.from(frsGameSubPbActivity.getPageContext().getPageActivity()).inflate(R.layout.frs_game_sub_pb_activity, (ViewGroup) null);
        this.gwr = (BdTypeListView) this.mRootView.findViewById(R.id.new_sub_pb_list);
        this.gwr.setOnTouchListener(this.ftt);
        this.gwr.setOnScrollListener(new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.frs.gamesubpb.view.a.4
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
                if (i != 0) {
                    l.hideSoftKeyPad(a.this.jvq.getPageContext().getPageActivity(), a.this.jvM);
                }
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            }
        });
        this.jvK = new e(this.jvq.getPageContext());
        this.iQc = BdListViewHelper.a(this.jvq.getActivity(), this.gwr, BdListViewHelper.HeadType.DEFAULT);
        this.jvO = (TextView) this.mRootView.findViewById(R.id.subpb_editor_tool_comment_reply_text);
        this.jvO.setOnClickListener(this.aYB);
        this.jvP = (TextView) this.mRootView.findViewById(R.id.no_reply_list_view);
        this.jvL = (FrameLayout) this.mRootView.findViewById(R.id.bottom_view);
        this.fBO = (LinearLayout) this.mRootView.findViewById(R.id.subpb_editor_tool_comment_input_container);
        this.jvM = (EditText) this.mRootView.findViewById(R.id.subpb_editor_tool_comment_input_edit);
        this.jvN = (TextView) this.mRootView.findViewById(R.id.subpb_editor_tool_comment_send_tv);
        this.jvN.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.gamesubpb.view.a.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.JY(a.this.jvM.getText().toString());
            }
        });
        this.mProgressBar = (ProgressBar) this.mRootView.findViewById(R.id.progressBar);
        cHg();
        this.jvQ = new b(this.jvq.getPageContext(), this.gwr);
        this.jvQ.setClickListener(new a.InterfaceC0730a() { // from class: com.baidu.tieba.frs.gamesubpb.view.a.6
            @Override // com.baidu.tieba.frs.gamesubpb.a.InterfaceC0730a
            public void a(d dVar) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonPolymericActivityConfig(a.this.jvq.getPageContext().getPageActivity()).createNormalConfig(Long.valueOf(dVar.userId).longValue(), String.valueOf(a.this.gCR).equals(dVar.userId), false)));
            }

            @Override // com.baidu.tieba.frs.gamesubpb.a.InterfaceC0730a
            public void b(d dVar) {
                if (dVar != null) {
                    a.this.d(dVar);
                }
            }

            @Override // com.baidu.tieba.frs.gamesubpb.a.InterfaceC0730a
            public void c(d dVar) {
                if (a.this.jva != null) {
                    a.this.jva.cGZ();
                }
                if (dVar == null) {
                    a.this.JZ(null);
                    a.this.cHi();
                    return;
                }
                a.this.JZ(dVar.userName);
                a.this.jvT = dVar.userId;
            }
        });
        zF(140);
        cHh();
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        this.jvS = new ArrayList();
        this.gCR = com.baidu.adp.lib.f.b.toLong(TbadkCoreApplication.getCurrentAccount(), 0L);
    }

    private void cHg() {
        this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(R.id.view_navigation_bar);
        this.mBack = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        ImageView backImageView = this.mNavigationBar.getBackImageView();
        if (backImageView != null && (backImageView.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.mBack.getLayoutParams();
            int dimens = l.getDimens(this.jvq.getPageContext().getPageActivity(), R.dimen.ds30);
            layoutParams.height = dimens;
            layoutParams.width = dimens;
            backImageView.setLayoutParams(layoutParams);
        }
        if (this.mBack != null && (this.mBack.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.mBack.getLayoutParams();
            layoutParams2.width = -2;
            layoutParams2.height = -1;
            this.mBack.setPadding(l.getDimens(this.jvq.getPageContext().getPageActivity(), R.dimen.ds32), this.mBack.getPaddingTop(), this.mBack.getPaddingRight(), this.mBack.getPaddingBottom());
            this.mBack.setLayoutParams(layoutParams2);
        }
        if (this.mNavigationBar.getBackImageView() != null) {
            SvgManager.bsx().a(this.mNavigationBar.getBackImageView(), R.drawable.ic_icon_pure_topbar_return40_svg, R.color.CAM_X0106, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
    }

    private void cHh() {
        this.globalListener = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tieba.frs.gamesubpb.view.a.7
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                Rect rect = new Rect();
                a.this.jvq.getPageContext().getPageActivity().getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
                int statusBarHeight = l.getStatusBarHeight(a.this.jvq.getPageContext().getPageActivity());
                int[] screenDimensions = l.getScreenDimensions(a.this.jvq.getPageContext().getPageActivity());
                if (screenDimensions[1] - rect.bottom > screenDimensions[1] / 4 && !a.this.mIsKeyboardOpen) {
                    a.this.mIsKeyboardOpen = true;
                    a.this.onKeyboardVisibilityChanged(true);
                } else if (screenDimensions[1] - rect.height() == statusBarHeight && a.this.mIsKeyboardOpen) {
                    a.this.mIsKeyboardOpen = false;
                    a.this.onKeyboardVisibilityChanged(false);
                }
            }
        };
        this.jvq.getPageContext().getPageActivity().getWindow().getDecorView().getViewTreeObserver().addOnGlobalLayoutListener(this.globalListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(final d dVar) {
        final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.jvq.getPageContext().getPageActivity());
        aVar.Ac(null);
        aVar.nu(R.string.del_post_confirm);
        aVar.jE(true);
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
        aVar.b(this.jvq.getPageContext()).bqe();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(d dVar) {
        HttpMessage httpMessage = new HttpMessage(1003381);
        httpMessage.addParam("user_id", this.gCR);
        httpMessage.addParam("main_tower_id", dVar.jvG);
        httpMessage.addParam("id", dVar.id);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JY(String str) {
        zG(0);
        HttpMessage httpMessage = new HttpMessage(1003380);
        httpMessage.addParam("user_id", this.gCR);
        httpMessage.addParam("reply_user_id", this.jvT);
        httpMessage.addParam("content", str);
        httpMessage.addParam("main_tower_id", this.jve);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cHi() {
        this.jvT = this.jvR != null ? this.jvR.userId : null;
    }

    private void cHj() {
        if (!x.isEmpty(this.jvS)) {
            this.mNavigationBar.setCenterTextTitle(String.format(this.jvq.getResources().getString(R.string.subpb_floor_reply_count), at.numFormatOver10000(this.jvS.size())));
        } else {
            this.mNavigationBar.setCenterTextTitle(this.jvq.getResources().getString(R.string.reply));
        }
    }

    private void zF(final int i) {
        this.jvM.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.frs.gamesubpb.view.a.10
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                if (!TextUtils.isEmpty(charSequence)) {
                    a.this.jvN.setEnabled(true);
                    String charSequence2 = charSequence.toString();
                    if (!StringUtils.isNull(charSequence2) && ad.getTextLength(charSequence2) > i) {
                        String subString = ad.subString(charSequence2, 0, i - 1);
                        a.this.jvM.setText(subString);
                        a.this.jvM.setSelection(a.this.jvM.getText().length());
                        UtilHelper.showToast(a.this.jvq.getPageContext().getPageActivity().getApplication(), a.this.jvq.getPageContext().getPageActivity().getResources().getString(R.string.edit_text_over_limit_tip, Integer.valueOf(subString.length())));
                        return;
                    }
                    return;
                }
                a.this.cHi();
                a.this.jvN.setEnabled(false);
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
            }
        });
    }

    private void cHk() {
        if (this.mNavigationBar.getBackImageView() != null) {
            SvgManager.bsx().a(this.mNavigationBar.getBackImageView(), R.drawable.ic_icon_pure_topbar_return40_svg, R.color.CAM_X0106, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rc(final boolean z) {
        if (this.gwr != null) {
            if (!z) {
                this.gwr.setEnabled(z);
            } else {
                this.gwr.postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.gamesubpb.view.a.11
                    @Override // java.lang.Runnable
                    public void run() {
                        a.this.gwr.setEnabled(z);
                    }
                }, 10L);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onKeyboardVisibilityChanged(boolean z) {
        if (z) {
            Rect rect = new Rect();
            this.fBO.getWindowVisibleDisplayFrame(rect);
            this.jvL.scrollTo(this.jvL.getScrollX(), (l.getScreenDimensions(this.jvq.getPageContext().getPageActivity())[1] - rect.bottom) - (MenuKeyUtils.hasSmartBar() ? l.dip2px(this.jvq.getPageContext().getPageActivity(), 48.0f) : 0));
            return;
        }
        this.jvL.setScrollY(0);
    }

    private void rd(boolean z) {
        if (x.isEmpty(this.jvS)) {
            this.gwr.setNextPage(null);
            this.jvP.setVisibility(0);
        } else {
            this.gwr.setNextPage(this.jvK);
            this.jvP.setVisibility(8);
            if (z) {
                this.jvK.startLoadData();
            } else {
                this.jvK.endLoadData();
            }
        }
        cHj();
    }

    public void a(boolean z, com.baidu.tieba.frs.gamesubpb.model.b bVar, List<n> list) {
        this.hasMore = z;
        this.jvR = bVar;
        cHi();
        if (x.isEmpty(list)) {
            rd(z);
            return;
        }
        this.jvS.clear();
        this.jvS.addAll(list);
        this.jvP.setVisibility(8);
        this.gwr.setNextPage(this.jvK);
        this.jvQ.setData(list);
        cHk();
        this.jvO.setVisibility(0);
        this.jvO.setText(R.string.say_your_point);
        rd(z);
    }

    public void a(boolean z, String str, d dVar) {
        zG(8);
        if (z && dVar != null) {
            BdToast.b(this.jvq.getPageContext().getPageActivity(), this.jvq.getPageContext().getString(R.string.subpb_add_comment_succ_tip), 1).bqk();
            this.jvM.setText((CharSequence) null);
            this.jvS.add(dVar);
            this.jvQ.setData(this.jvS);
            rd(this.hasMore);
            this.jvM.post(new Runnable() { // from class: com.baidu.tieba.frs.gamesubpb.view.a.2
                @Override // java.lang.Runnable
                public void run() {
                    a.this.jvM.requestFocus();
                    l.hideSoftKeyPad(a.this.jvq.getPageContext().getPageActivity(), a.this.jvM);
                }
            });
            return;
        }
        if (TextUtils.isEmpty(str)) {
            str = this.jvq.getPageContext().getString(R.string.subpb_add_comment_fail_tip);
        }
        BdToast.b(this.jvq.getPageContext().getPageActivity(), str, 1).bqk();
    }

    public void b(boolean z, String str, d dVar) {
        if (z) {
            BdToast.b(this.jvq.getPageContext().getPageActivity(), this.jvq.getPageContext().getString(R.string.subpb_delete_comment_succ_tip), 1).bqk();
            this.jvS.remove(dVar);
            this.jvQ.setData(this.jvS);
            rd(this.hasMore);
            return;
        }
        if (TextUtils.isEmpty(str)) {
            str = this.jvq.getPageContext().getString(R.string.subpb_delete_comment_fail_tip);
        }
        BdToast.b(this.jvq.getPageContext().getPageActivity(), str, 1).bqk();
    }

    public void re(boolean z) {
        if (this.iQc != null && this.iQc.getLayoutParams() != null) {
            ViewGroup.LayoutParams layoutParams = this.iQc.getLayoutParams();
            if (z) {
                cHk();
                layoutParams.height = l.getDimens(this.jvq.getPageContext().getPageActivity(), R.dimen.ds98);
            } else {
                layoutParams.height = l.getDimens(this.jvq.getPageContext().getPageActivity(), R.dimen.ds98) + UtilHelper.getLightStatusBarHeight();
            }
            this.iQc.setLayoutParams(layoutParams);
        }
    }

    public void db(View view) {
        if (this.iQc != null && this.mNavigationBar != null) {
            if (this.mNavigationBar.isNavigationBarExcludeStatusbarVisible()) {
                this.mNavigationBar.showNavigationBarExcludeStatusbar(false);
                if (UtilHelper.canUseStyleImmersiveSticky()) {
                    this.iQc.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight()));
                } else if (this.gwr != null) {
                    this.gwr.removeHeaderView(this.iQc);
                }
                this.mNavigationBar.setVisibility(8);
                return;
            }
            this.mNavigationBar.showNavigationBarExcludeStatusbar(true);
            if (UtilHelper.canUseStyleImmersiveSticky()) {
                this.iQc.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + l.getDimens(this.jvq.getActivity(), R.dimen.ds98)));
            } else if (this.gwr != null) {
                this.gwr.addHeaderView(this.iQc, 0);
            }
            this.mNavigationBar.setVisibility(0);
        }
    }

    public void JZ(String str) {
        this.jvO.setVisibility(8);
        this.fBO.setVisibility(0);
        this.jvM.post(new Runnable() { // from class: com.baidu.tieba.frs.gamesubpb.view.a.3
            @Override // java.lang.Runnable
            public void run() {
                a.this.jvM.requestFocus();
                l.showSoftKeyPad(a.this.jvq.getPageContext().getPageActivity(), a.this.jvM);
            }
        });
        if (!TextUtils.isEmpty(str)) {
            String format = String.format(this.jvq.getPageContext().getPageActivity().getResources().getString(R.string.reply_sub_floor), str);
            this.jvM.setText(format);
            this.jvM.setSelection(format.length());
        }
    }

    public void zG(int i) {
        this.mProgressBar.setVisibility(i);
    }

    public View cve() {
        return this.iQc;
    }

    public View getRootView() {
        return this.mRootView;
    }

    public ListView getListView() {
        return this.gwr;
    }

    public TextView cHl() {
        return this.jvO;
    }

    public NavigationBar bUz() {
        return this.mNavigationBar;
    }

    public void e(com.baidu.tieba.frs.gamesubpb.c cVar) {
        this.jva = cVar;
    }

    public void b(BdListView.e eVar) {
        this.gwr.setOnSrollToBottomListener(eVar);
    }

    public void onChangeSkinType(int i) {
        this.jvq.getLayoutMode().setNightMode(i == 1);
        this.jvq.getLayoutMode().onModeChanged(this.mRootView);
        ao.setBackgroundColor(this.mRootView, R.color.CAM_X0201);
        this.mNavigationBar.onChangeSkinType(this.jvq.getPageContext(), i);
        this.jvK.changeSkin(i);
        ao.setViewTextColor(this.jvO, R.color.CAM_X0110);
        this.jvO.setAlpha(0.95f);
        ao.setBackgroundResource(this.jvO, R.drawable.pb_ecomm_comment_bg);
        ao.setViewTextColor(this.jvP, R.color.CAM_X0109);
        ao.setBackgroundResource(this.fBO, R.drawable.pb_ecomm_comment_bg);
        ao.setViewTextColor(this.jvM, R.color.CAM_X0106);
        this.jvM.setHintTextColor(ao.getColor(R.color.CAM_X0110));
        ao.setViewTextColor(this.jvN, R.color.game_sub_pb_send_txt_color);
    }

    public void onDestroy() {
        if (this.globalListener != null) {
            this.jvq.getPageContext().getPageActivity().getWindow().getDecorView().getViewTreeObserver().removeGlobalOnLayoutListener(this.globalListener);
        }
    }
}
