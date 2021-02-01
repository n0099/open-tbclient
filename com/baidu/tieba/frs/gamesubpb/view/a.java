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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tbadk.util.ag;
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
    private View.OnClickListener bbI;
    private LinearLayout fEd;
    private c fvK = new c(new c.a() { // from class: com.baidu.tieba.frs.gamesubpb.view.a.1
        @Override // com.baidu.tieba.pb.a.c.a
        public boolean onDoubleTap(View view, MotionEvent motionEvent) {
            a.this.rm(false);
            a.this.cZ(view);
            a.this.rm(true);
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
    private long gFB;
    private ViewTreeObserver.OnGlobalLayoutListener globalListener;
    private BdTypeListView gzb;
    private boolean hasMore;
    private View iVJ;
    private com.baidu.tieba.frs.gamesubpb.c jAG;
    private String jAK;
    private FrsGameSubPbActivity jAW;
    private e jBq;
    private FrameLayout jBr;
    private EditText jBs;
    private TextView jBt;
    private TextView jBu;
    private TextView jBv;
    private b jBw;
    private com.baidu.tieba.frs.gamesubpb.model.b jBx;
    private List<n> jBy;
    private String jBz;
    private View mBack;
    private boolean mIsKeyboardOpen;
    private NavigationBar mNavigationBar;
    private ProgressBar mProgressBar;
    private RelativeLayout mRootView;

    public a(FrsGameSubPbActivity frsGameSubPbActivity, View.OnClickListener onClickListener, String str) {
        this.jAW = frsGameSubPbActivity;
        this.bbI = onClickListener;
        this.jAK = str;
        this.mRootView = (RelativeLayout) LayoutInflater.from(frsGameSubPbActivity.getPageContext().getPageActivity()).inflate(R.layout.frs_game_sub_pb_activity, (ViewGroup) null);
        this.gzb = (BdTypeListView) this.mRootView.findViewById(R.id.new_sub_pb_list);
        this.gzb.setOnTouchListener(this.fvK);
        this.gzb.setOnScrollListener(new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.frs.gamesubpb.view.a.4
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
                if (i != 0) {
                    l.hideSoftKeyPad(a.this.jAW.getPageContext().getPageActivity(), a.this.jBs);
                }
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            }
        });
        this.jBq = new e(this.jAW.getPageContext());
        this.iVJ = BdListViewHelper.a(this.jAW.getActivity(), this.gzb, BdListViewHelper.HeadType.DEFAULT);
        this.jBu = (TextView) this.mRootView.findViewById(R.id.subpb_editor_tool_comment_reply_text);
        this.jBu.setOnClickListener(this.bbI);
        this.jBv = (TextView) this.mRootView.findViewById(R.id.no_reply_list_view);
        this.jBr = (FrameLayout) this.mRootView.findViewById(R.id.bottom_view);
        this.fEd = (LinearLayout) this.mRootView.findViewById(R.id.subpb_editor_tool_comment_input_container);
        this.jBs = (EditText) this.mRootView.findViewById(R.id.subpb_editor_tool_comment_input_edit);
        this.jBt = (TextView) this.mRootView.findViewById(R.id.subpb_editor_tool_comment_send_tv);
        this.jBt.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.gamesubpb.view.a.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.KJ(a.this.jBs.getText().toString());
            }
        });
        this.mProgressBar = (ProgressBar) this.mRootView.findViewById(R.id.progressBar);
        cIt();
        this.jBw = new b(this.jAW.getPageContext(), this.gzb);
        this.jBw.setClickListener(new a.InterfaceC0730a() { // from class: com.baidu.tieba.frs.gamesubpb.view.a.6
            @Override // com.baidu.tieba.frs.gamesubpb.a.InterfaceC0730a
            public void a(d dVar) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonPolymericActivityConfig(a.this.jAW.getPageContext().getPageActivity()).createNormalConfig(Long.valueOf(dVar.userId).longValue(), String.valueOf(a.this.gFB).equals(dVar.userId), false)));
            }

            @Override // com.baidu.tieba.frs.gamesubpb.a.InterfaceC0730a
            public void b(d dVar) {
                if (dVar != null) {
                    a.this.d(dVar);
                }
            }

            @Override // com.baidu.tieba.frs.gamesubpb.a.InterfaceC0730a
            public void c(d dVar) {
                if (a.this.jAG != null) {
                    a.this.jAG.cIm();
                }
                if (dVar == null) {
                    a.this.KK(null);
                    a.this.cIv();
                    return;
                }
                a.this.KK(dVar.userName);
                a.this.jBz = dVar.userId;
            }
        });
        zP(140);
        cIu();
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        this.jBy = new ArrayList();
        this.gFB = com.baidu.adp.lib.f.b.toLong(TbadkCoreApplication.getCurrentAccount(), 0L);
    }

    private void cIt() {
        this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(R.id.view_navigation_bar);
        this.mBack = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        ImageView backImageView = this.mNavigationBar.getBackImageView();
        if (backImageView != null && (backImageView.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.mBack.getLayoutParams();
            int dimens = l.getDimens(this.jAW.getPageContext().getPageActivity(), R.dimen.ds30);
            layoutParams.height = dimens;
            layoutParams.width = dimens;
            backImageView.setLayoutParams(layoutParams);
        }
        if (this.mBack != null && (this.mBack.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.mBack.getLayoutParams();
            layoutParams2.width = -2;
            layoutParams2.height = -1;
            this.mBack.setPadding(l.getDimens(this.jAW.getPageContext().getPageActivity(), R.dimen.ds32), this.mBack.getPaddingTop(), this.mBack.getPaddingRight(), this.mBack.getPaddingBottom());
            this.mBack.setLayoutParams(layoutParams2);
        }
        if (this.mNavigationBar.getBackImageView() != null) {
            SvgManager.bsR().a(this.mNavigationBar.getBackImageView(), R.drawable.ic_icon_pure_topbar_return40_svg, R.color.CAM_X0106, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
    }

    private void cIu() {
        this.globalListener = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tieba.frs.gamesubpb.view.a.7
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                Rect rect = new Rect();
                a.this.jAW.getPageContext().getPageActivity().getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
                int statusBarHeight = l.getStatusBarHeight(a.this.jAW.getPageContext().getPageActivity());
                int[] screenDimensions = l.getScreenDimensions(a.this.jAW.getPageContext().getPageActivity());
                if (screenDimensions[1] - rect.bottom > screenDimensions[1] / 4 && !a.this.mIsKeyboardOpen) {
                    a.this.mIsKeyboardOpen = true;
                    a.this.onKeyboardVisibilityChanged(true);
                } else if (screenDimensions[1] - rect.height() == statusBarHeight && a.this.mIsKeyboardOpen) {
                    a.this.mIsKeyboardOpen = false;
                    a.this.onKeyboardVisibilityChanged(false);
                }
            }
        };
        this.jAW.getPageContext().getPageActivity().getWindow().getDecorView().getViewTreeObserver().addOnGlobalLayoutListener(this.globalListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(final d dVar) {
        final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.jAW.getPageContext().getPageActivity());
        aVar.At(null);
        aVar.nx(R.string.del_post_confirm);
        aVar.jG(true);
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
        aVar.b(this.jAW.getPageContext()).bqx();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(d dVar) {
        HttpMessage httpMessage = new HttpMessage(1003381);
        httpMessage.addParam("user_id", this.gFB);
        httpMessage.addParam("main_tower_id", dVar.jBm);
        httpMessage.addParam("id", dVar.id);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void KJ(String str) {
        zQ(0);
        HttpMessage httpMessage = new HttpMessage(1003380);
        httpMessage.addParam("user_id", this.gFB);
        httpMessage.addParam("reply_user_id", this.jBz);
        httpMessage.addParam("content", str);
        httpMessage.addParam("main_tower_id", this.jAK);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cIv() {
        this.jBz = this.jBx != null ? this.jBx.userId : null;
    }

    private void cIw() {
        if (!y.isEmpty(this.jBy)) {
            this.mNavigationBar.setCenterTextTitle(String.format(this.jAW.getResources().getString(R.string.subpb_floor_reply_count), au.numFormatOver10000(this.jBy.size())));
        } else {
            this.mNavigationBar.setCenterTextTitle(this.jAW.getResources().getString(R.string.reply));
        }
    }

    private void zP(final int i) {
        this.jBs.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.frs.gamesubpb.view.a.10
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                if (!TextUtils.isEmpty(charSequence)) {
                    a.this.jBt.setEnabled(true);
                    String charSequence2 = charSequence.toString();
                    if (!StringUtils.isNull(charSequence2) && ag.getTextLength(charSequence2) > i) {
                        String subString = ag.subString(charSequence2, 0, i - 1);
                        a.this.jBs.setText(subString);
                        a.this.jBs.setSelection(a.this.jBs.getText().length());
                        UtilHelper.showToast(a.this.jAW.getPageContext().getPageActivity().getApplication(), a.this.jAW.getPageContext().getPageActivity().getResources().getString(R.string.edit_text_over_limit_tip, Integer.valueOf(subString.length())));
                        return;
                    }
                    return;
                }
                a.this.cIv();
                a.this.jBt.setEnabled(false);
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
            }
        });
    }

    private void cIx() {
        if (this.mNavigationBar.getBackImageView() != null) {
            SvgManager.bsR().a(this.mNavigationBar.getBackImageView(), R.drawable.ic_icon_pure_topbar_return40_svg, R.color.CAM_X0106, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rm(final boolean z) {
        if (this.gzb != null) {
            if (!z) {
                this.gzb.setEnabled(z);
            } else {
                this.gzb.postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.gamesubpb.view.a.11
                    @Override // java.lang.Runnable
                    public void run() {
                        a.this.gzb.setEnabled(z);
                    }
                }, 10L);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onKeyboardVisibilityChanged(boolean z) {
        if (z) {
            Rect rect = new Rect();
            this.fEd.getWindowVisibleDisplayFrame(rect);
            this.jBr.scrollTo(this.jBr.getScrollX(), (l.getScreenDimensions(this.jAW.getPageContext().getPageActivity())[1] - rect.bottom) - (MenuKeyUtils.hasSmartBar() ? l.dip2px(this.jAW.getPageContext().getPageActivity(), 48.0f) : 0));
            return;
        }
        this.jBr.setScrollY(0);
    }

    private void rn(boolean z) {
        if (y.isEmpty(this.jBy)) {
            this.gzb.setNextPage(null);
            this.jBv.setVisibility(0);
        } else {
            this.gzb.setNextPage(this.jBq);
            this.jBv.setVisibility(8);
            if (z) {
                this.jBq.startLoadData();
            } else {
                this.jBq.endLoadData();
            }
        }
        cIw();
    }

    public void a(boolean z, com.baidu.tieba.frs.gamesubpb.model.b bVar, List<n> list) {
        this.hasMore = z;
        this.jBx = bVar;
        cIv();
        if (y.isEmpty(list)) {
            rn(z);
            return;
        }
        this.jBy.clear();
        this.jBy.addAll(list);
        this.jBv.setVisibility(8);
        this.gzb.setNextPage(this.jBq);
        this.jBw.setData(list);
        cIx();
        this.jBu.setVisibility(0);
        this.jBu.setText(R.string.say_your_point);
        rn(z);
    }

    public void a(boolean z, String str, d dVar) {
        zQ(8);
        if (z && dVar != null) {
            BdToast.b(this.jAW.getPageContext().getPageActivity(), this.jAW.getPageContext().getString(R.string.subpb_add_comment_succ_tip), 1).bqD();
            this.jBs.setText((CharSequence) null);
            this.jBy.add(dVar);
            this.jBw.setData(this.jBy);
            rn(this.hasMore);
            this.jBs.post(new Runnable() { // from class: com.baidu.tieba.frs.gamesubpb.view.a.2
                @Override // java.lang.Runnable
                public void run() {
                    a.this.jBs.requestFocus();
                    l.hideSoftKeyPad(a.this.jAW.getPageContext().getPageActivity(), a.this.jBs);
                }
            });
            return;
        }
        if (TextUtils.isEmpty(str)) {
            str = this.jAW.getPageContext().getString(R.string.subpb_add_comment_fail_tip);
        }
        BdToast.b(this.jAW.getPageContext().getPageActivity(), str, 1).bqD();
    }

    public void b(boolean z, String str, d dVar) {
        if (z) {
            BdToast.b(this.jAW.getPageContext().getPageActivity(), this.jAW.getPageContext().getString(R.string.subpb_delete_comment_succ_tip), 1).bqD();
            this.jBy.remove(dVar);
            this.jBw.setData(this.jBy);
            rn(this.hasMore);
            return;
        }
        if (TextUtils.isEmpty(str)) {
            str = this.jAW.getPageContext().getString(R.string.subpb_delete_comment_fail_tip);
        }
        BdToast.b(this.jAW.getPageContext().getPageActivity(), str, 1).bqD();
    }

    public void ro(boolean z) {
        if (this.iVJ != null && this.iVJ.getLayoutParams() != null) {
            ViewGroup.LayoutParams layoutParams = this.iVJ.getLayoutParams();
            if (z) {
                cIx();
                layoutParams.height = l.getDimens(this.jAW.getPageContext().getPageActivity(), R.dimen.ds98);
            } else {
                layoutParams.height = l.getDimens(this.jAW.getPageContext().getPageActivity(), R.dimen.ds98) + UtilHelper.getLightStatusBarHeight();
            }
            this.iVJ.setLayoutParams(layoutParams);
        }
    }

    public void cZ(View view) {
        if (this.iVJ != null && this.mNavigationBar != null) {
            if (this.mNavigationBar.isNavigationBarExcludeStatusbarVisible()) {
                this.mNavigationBar.showNavigationBarExcludeStatusbar(false);
                if (UtilHelper.canUseStyleImmersiveSticky()) {
                    this.iVJ.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight()));
                } else if (this.gzb != null) {
                    this.gzb.removeHeaderView(this.iVJ);
                }
                this.mNavigationBar.setVisibility(8);
                return;
            }
            this.mNavigationBar.showNavigationBarExcludeStatusbar(true);
            if (UtilHelper.canUseStyleImmersiveSticky()) {
                this.iVJ.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + l.getDimens(this.jAW.getActivity(), R.dimen.ds98)));
            } else if (this.gzb != null) {
                this.gzb.addHeaderView(this.iVJ, 0);
            }
            this.mNavigationBar.setVisibility(0);
        }
    }

    public void KK(String str) {
        this.jBu.setVisibility(8);
        this.fEd.setVisibility(0);
        this.jBs.post(new Runnable() { // from class: com.baidu.tieba.frs.gamesubpb.view.a.3
            @Override // java.lang.Runnable
            public void run() {
                a.this.jBs.requestFocus();
                l.showSoftKeyPad(a.this.jAW.getPageContext().getPageActivity(), a.this.jBs);
            }
        });
        if (!TextUtils.isEmpty(str)) {
            String format = String.format(this.jAW.getPageContext().getPageActivity().getResources().getString(R.string.reply_sub_floor), str);
            this.jBs.setText(format);
            this.jBs.setSelection(format.length());
        }
    }

    public void zQ(int i) {
        this.mProgressBar.setVisibility(i);
    }

    public View cwq() {
        return this.iVJ;
    }

    public View getRootView() {
        return this.mRootView;
    }

    public ListView getListView() {
        return this.gzb;
    }

    public TextView cIy() {
        return this.jBu;
    }

    public NavigationBar bVd() {
        return this.mNavigationBar;
    }

    public void e(com.baidu.tieba.frs.gamesubpb.c cVar) {
        this.jAG = cVar;
    }

    public void b(BdListView.e eVar) {
        this.gzb.setOnSrollToBottomListener(eVar);
    }

    public void onChangeSkinType(int i) {
        this.jAW.getLayoutMode().setNightMode(i == 1);
        this.jAW.getLayoutMode().onModeChanged(this.mRootView);
        ap.setBackgroundColor(this.mRootView, R.color.CAM_X0201);
        this.mNavigationBar.onChangeSkinType(this.jAW.getPageContext(), i);
        this.jBq.changeSkin(i);
        ap.setViewTextColor(this.jBu, R.color.CAM_X0110);
        this.jBu.setAlpha(0.95f);
        ap.setBackgroundResource(this.jBu, R.drawable.pb_ecomm_comment_bg);
        ap.setViewTextColor(this.jBv, R.color.CAM_X0109);
        ap.setBackgroundResource(this.fEd, R.drawable.pb_ecomm_comment_bg);
        ap.setViewTextColor(this.jBs, R.color.CAM_X0106);
        this.jBs.setHintTextColor(ap.getColor(R.color.CAM_X0110));
        ap.setViewTextColor(this.jBt, R.color.game_sub_pb_send_txt_color);
    }

    public void onDestroy() {
        if (this.globalListener != null) {
            this.jAW.getPageContext().getPageActivity().getWindow().getDecorView().getViewTreeObserver().removeGlobalOnLayoutListener(this.globalListener);
        }
    }
}
