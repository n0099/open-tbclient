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
    private View.OnClickListener akt;
    private c dqJ = new c(new c.a() { // from class: com.baidu.tieba.frs.gamesubpb.view.a.1
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
    private LinearLayout dyG;
    private ViewTreeObserver.OnGlobalLayoutListener eir;
    private BdTypeListView eka;
    private long eqh;
    private com.baidu.tieba.frs.gamesubpb.c gCV;
    private String gCZ;
    private e gDF;
    private FrameLayout gDG;
    private EditText gDH;
    private TextView gDI;
    private TextView gDJ;
    private TextView gDK;
    private com.baidu.tieba.frs.gamesubpb.b gDL;
    private com.baidu.tieba.frs.gamesubpb.model.b gDM;
    private List<m> gDN;
    private String gDO;
    private FrsGameSubPbActivity gDl;
    private View gdT;
    private boolean hasMore;
    private View mBack;
    private NavigationBar mNavigationBar;
    private ProgressBar mProgressBar;
    private RelativeLayout mRootView;

    public a(FrsGameSubPbActivity frsGameSubPbActivity, View.OnClickListener onClickListener, String str) {
        this.gDl = frsGameSubPbActivity;
        this.akt = onClickListener;
        this.gCZ = str;
        this.mRootView = (RelativeLayout) LayoutInflater.from(frsGameSubPbActivity.getPageContext().getPageActivity()).inflate(R.layout.frs_game_sub_pb_activity, (ViewGroup) null);
        this.eka = (BdTypeListView) this.mRootView.findViewById(R.id.new_sub_pb_list);
        this.eka.setOnTouchListener(this.dqJ);
        this.eka.setOnScrollListener(new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.frs.gamesubpb.view.a.4
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
                if (i != 0) {
                    l.hideSoftKeyPad(a.this.gDl.getPageContext().getPageActivity(), a.this.gDH);
                }
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            }
        });
        this.gDF = new e(this.gDl.getPageContext());
        this.gdT = BdListViewHelper.a(this.gDl.getActivity(), this.eka, BdListViewHelper.HeadType.DEFAULT);
        this.gDJ = (TextView) this.mRootView.findViewById(R.id.subpb_editor_tool_comment_reply_text);
        this.gDJ.setOnClickListener(this.akt);
        this.gDK = (TextView) this.mRootView.findViewById(R.id.no_reply_list_view);
        this.gDG = (FrameLayout) this.mRootView.findViewById(R.id.bottom_view);
        this.dyG = (LinearLayout) this.mRootView.findViewById(R.id.subpb_editor_tool_comment_input_container);
        this.gDH = (EditText) this.mRootView.findViewById(R.id.subpb_editor_tool_comment_input_edit);
        this.gDI = (TextView) this.mRootView.findViewById(R.id.subpb_editor_tool_comment_send_tv);
        this.gDI.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.gamesubpb.view.a.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.Bp(a.this.gDH.getText().toString());
            }
        });
        this.mProgressBar = (ProgressBar) this.mRootView.findViewById(R.id.progressBar);
        bIh();
        this.gDL = new com.baidu.tieba.frs.gamesubpb.b(this.gDl.getPageContext(), this.eka);
        this.gDL.setClickListener(new a.InterfaceC0508a() { // from class: com.baidu.tieba.frs.gamesubpb.view.a.6
            @Override // com.baidu.tieba.frs.gamesubpb.a.InterfaceC0508a
            public void a(d dVar) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonPolymericActivityConfig(a.this.gDl.getPageContext().getPageActivity()).createNormalConfig(Long.valueOf(dVar.userId).longValue(), String.valueOf(a.this.eqh).equals(dVar.userId), false)));
            }

            @Override // com.baidu.tieba.frs.gamesubpb.a.InterfaceC0508a
            public void b(d dVar) {
                if (dVar != null) {
                    a.this.d(dVar);
                }
            }

            @Override // com.baidu.tieba.frs.gamesubpb.a.InterfaceC0508a
            public void c(d dVar) {
                if (a.this.gCV != null) {
                    a.this.gCV.bHZ();
                }
                if (dVar == null) {
                    a.this.Bq(null);
                    a.this.bIj();
                    return;
                }
                a.this.Bq(dVar.userName);
                a.this.gDO = dVar.userId;
            }
        });
        tB(140);
        bIi();
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        this.gDN = new ArrayList();
        this.eqh = com.baidu.adp.lib.f.b.toLong(TbadkCoreApplication.getCurrentAccount(), 0L);
    }

    private void bIh() {
        this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(R.id.view_navigation_bar);
        this.mBack = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        ImageView backImageView = this.mNavigationBar.getBackImageView();
        if (backImageView != null && (backImageView.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.mBack.getLayoutParams();
            int dimens = l.getDimens(this.gDl.getPageContext().getPageActivity(), R.dimen.ds30);
            layoutParams.height = dimens;
            layoutParams.width = dimens;
            backImageView.setLayoutParams(layoutParams);
        }
        if (this.mBack != null && (this.mBack.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.mBack.getLayoutParams();
            layoutParams2.width = -2;
            layoutParams2.height = -1;
            this.mBack.setPadding(l.getDimens(this.gDl.getPageContext().getPageActivity(), R.dimen.ds32), this.mBack.getPaddingTop(), this.mBack.getPaddingRight(), this.mBack.getPaddingBottom());
            this.mBack.setLayoutParams(layoutParams2);
        }
        if (this.mNavigationBar.getBackImageView() != null) {
            SvgManager.aGA().a(this.mNavigationBar.getBackImageView(), R.drawable.icon_pure_topbar_return44_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
    }

    private void bIi() {
        this.eir = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tieba.frs.gamesubpb.view.a.7
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                Rect rect = new Rect();
                a.this.gDl.getPageContext().getPageActivity().getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
                int statusBarHeight = l.getStatusBarHeight(a.this.gDl.getPageContext().getPageActivity());
                int[] screenDimensions = l.getScreenDimensions(a.this.gDl.getPageContext().getPageActivity());
                if (screenDimensions[1] - rect.bottom > screenDimensions[1] / 4 && !a.this.ajw) {
                    a.this.ajw = true;
                    a.this.onKeyboardVisibilityChanged(true);
                } else if (screenDimensions[1] - rect.height() == statusBarHeight && a.this.ajw) {
                    a.this.ajw = false;
                    a.this.onKeyboardVisibilityChanged(false);
                }
            }
        };
        this.gDl.getPageContext().getPageActivity().getWindow().getDecorView().getViewTreeObserver().addOnGlobalLayoutListener(this.eir);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(final d dVar) {
        final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.gDl.getPageContext().getPageActivity());
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
        aVar.b(this.gDl.getPageContext()).aEA();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(d dVar) {
        HttpMessage httpMessage = new HttpMessage(1003381);
        httpMessage.addParam("user_id", this.eqh);
        httpMessage.addParam("main_tower_id", dVar.gDB);
        httpMessage.addParam("id", dVar.id);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Bp(String str) {
        tC(0);
        HttpMessage httpMessage = new HttpMessage(1003380);
        httpMessage.addParam("user_id", this.eqh);
        httpMessage.addParam("reply_user_id", this.gDO);
        httpMessage.addParam("content", str);
        httpMessage.addParam("main_tower_id", this.gCZ);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bIj() {
        this.gDO = this.gDM != null ? this.gDM.userId : null;
    }

    private void bIk() {
        if (!v.isEmpty(this.gDN)) {
            this.mNavigationBar.setCenterTextTitle(String.format(this.gDl.getResources().getString(R.string.subpb_floor_reply_count), aq.numFormatOver10000(this.gDN.size())));
        } else {
            this.mNavigationBar.setCenterTextTitle(this.gDl.getResources().getString(R.string.reply));
        }
    }

    private void tB(final int i) {
        this.gDH.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.frs.gamesubpb.view.a.10
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                if (!TextUtils.isEmpty(charSequence)) {
                    a.this.gDI.setEnabled(true);
                    String charSequence2 = charSequence.toString();
                    if (!StringUtils.isNull(charSequence2) && ad.getTextLength(charSequence2) > i) {
                        String subString = ad.subString(charSequence2, 0, i - 1);
                        a.this.gDH.setText(subString);
                        a.this.gDH.setSelection(a.this.gDH.getText().length());
                        UtilHelper.showToast(a.this.gDl.getPageContext().getPageActivity().getApplication(), a.this.gDl.getPageContext().getPageActivity().getResources().getString(R.string.edit_text_over_limit_tip, Integer.valueOf(subString.length())));
                        return;
                    }
                    return;
                }
                a.this.bIj();
                a.this.gDI.setEnabled(false);
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
            }
        });
    }

    private void bIl() {
        if (this.mNavigationBar.getBackImageView() != null) {
            SvgManager.aGA().a(this.mNavigationBar.getBackImageView(), R.drawable.icon_pure_topbar_return44_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lR(final boolean z) {
        if (this.eka != null) {
            if (!z) {
                this.eka.setEnabled(z);
            } else {
                this.eka.postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.gamesubpb.view.a.11
                    @Override // java.lang.Runnable
                    public void run() {
                        a.this.eka.setEnabled(z);
                    }
                }, 10L);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onKeyboardVisibilityChanged(boolean z) {
        if (z) {
            Rect rect = new Rect();
            this.dyG.getWindowVisibleDisplayFrame(rect);
            this.gDG.scrollTo(this.gDG.getScrollX(), (l.getScreenDimensions(this.gDl.getPageContext().getPageActivity())[1] - rect.bottom) - (MenuKeyUtils.hasSmartBar() ? l.dip2px(this.gDl.getPageContext().getPageActivity(), 48.0f) : 0));
            return;
        }
        this.gDG.setScrollY(0);
    }

    private void lS(boolean z) {
        if (v.isEmpty(this.gDN)) {
            this.eka.setNextPage(null);
            this.gDK.setVisibility(0);
        } else {
            this.eka.setNextPage(this.gDF);
            this.gDK.setVisibility(8);
            if (z) {
                this.gDF.startLoadData();
            } else {
                this.gDF.endLoadData();
            }
        }
        bIk();
    }

    public void a(boolean z, com.baidu.tieba.frs.gamesubpb.model.b bVar, List<m> list) {
        this.hasMore = z;
        this.gDM = bVar;
        bIj();
        if (v.isEmpty(list)) {
            lS(z);
            return;
        }
        this.gDN.clear();
        this.gDN.addAll(list);
        this.gDK.setVisibility(8);
        this.eka.setNextPage(this.gDF);
        this.gDL.setData(list);
        bIl();
        this.gDJ.setVisibility(0);
        this.gDJ.setText(R.string.say_your_point);
        lS(z);
    }

    public void a(boolean z, String str, d dVar) {
        tC(8);
        if (z && dVar != null) {
            BdToast.a(this.gDl.getPageContext().getPageActivity(), this.gDl.getPageContext().getString(R.string.subpb_add_comment_succ_tip), 1).aEF();
            this.gDH.setText((CharSequence) null);
            this.gDN.add(dVar);
            this.gDL.setData(this.gDN);
            lS(this.hasMore);
            this.gDH.post(new Runnable() { // from class: com.baidu.tieba.frs.gamesubpb.view.a.2
                @Override // java.lang.Runnable
                public void run() {
                    a.this.gDH.requestFocus();
                    l.hideSoftKeyPad(a.this.gDl.getPageContext().getPageActivity(), a.this.gDH);
                }
            });
            return;
        }
        if (TextUtils.isEmpty(str)) {
            str = this.gDl.getPageContext().getString(R.string.subpb_add_comment_fail_tip);
        }
        BdToast.a(this.gDl.getPageContext().getPageActivity(), str, 1).aEF();
    }

    public void b(boolean z, String str, d dVar) {
        if (z) {
            BdToast.a(this.gDl.getPageContext().getPageActivity(), this.gDl.getPageContext().getString(R.string.subpb_delete_comment_succ_tip), 1).aEF();
            this.gDN.remove(dVar);
            this.gDL.setData(this.gDN);
            lS(this.hasMore);
            return;
        }
        if (TextUtils.isEmpty(str)) {
            str = this.gDl.getPageContext().getString(R.string.subpb_delete_comment_fail_tip);
        }
        BdToast.a(this.gDl.getPageContext().getPageActivity(), str, 1).aEF();
    }

    public void lT(boolean z) {
        if (this.gdT != null && this.gdT.getLayoutParams() != null) {
            ViewGroup.LayoutParams layoutParams = this.gdT.getLayoutParams();
            if (z) {
                bIl();
                layoutParams.height = l.getDimens(this.gDl.getPageContext().getPageActivity(), R.dimen.ds98);
            } else {
                layoutParams.height = l.getDimens(this.gDl.getPageContext().getPageActivity(), R.dimen.ds98) + UtilHelper.getLightStatusBarHeight();
            }
            this.gdT.setLayoutParams(layoutParams);
        }
    }

    public void bT(View view) {
        if (this.gdT != null && this.mNavigationBar != null) {
            if (this.mNavigationBar.isNavigationBarExcludeStatusbarVisible()) {
                this.mNavigationBar.showNavigationBarExcludeStatusbar(false);
                if (UtilHelper.canUseStyleImmersiveSticky()) {
                    this.gdT.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight()));
                } else if (this.eka != null) {
                    this.eka.removeHeaderView(this.gdT);
                }
                this.mNavigationBar.setVisibility(8);
                return;
            }
            this.mNavigationBar.showNavigationBarExcludeStatusbar(true);
            if (UtilHelper.canUseStyleImmersiveSticky()) {
                this.gdT.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + l.getDimens(this.gDl.getActivity(), R.dimen.ds98)));
            } else if (this.eka != null) {
                this.eka.addHeaderView(this.gdT, 0);
            }
            this.mNavigationBar.setVisibility(0);
        }
    }

    public void Bq(String str) {
        this.gDJ.setVisibility(8);
        this.dyG.setVisibility(0);
        this.gDH.post(new Runnable() { // from class: com.baidu.tieba.frs.gamesubpb.view.a.3
            @Override // java.lang.Runnable
            public void run() {
                a.this.gDH.requestFocus();
                l.showSoftKeyPad(a.this.gDl.getPageContext().getPageActivity(), a.this.gDH);
            }
        });
        if (!TextUtils.isEmpty(str)) {
            String format = String.format(this.gDl.getPageContext().getPageActivity().getResources().getString(R.string.reply_sub_floor), str);
            this.gDH.setText(format);
            this.gDH.setSelection(format.length());
        }
    }

    public void tC(int i) {
        this.mProgressBar.setVisibility(i);
    }

    public View byC() {
        return this.gdT;
    }

    public View getRootView() {
        return this.mRootView;
    }

    public ListView getListView() {
        return this.eka;
    }

    public TextView bIm() {
        return this.gDJ;
    }

    public NavigationBar beJ() {
        return this.mNavigationBar;
    }

    public void e(com.baidu.tieba.frs.gamesubpb.c cVar) {
        this.gCV = cVar;
    }

    public void b(BdListView.e eVar) {
        this.eka.setOnSrollToBottomListener(eVar);
    }

    public void onChangeSkinType(int i) {
        this.gDl.getLayoutMode().setNightMode(i == 1);
        this.gDl.getLayoutMode().onModeChanged(this.mRootView);
        am.setBackgroundColor(this.mRootView, R.color.cp_bg_line_d);
        this.mNavigationBar.onChangeSkinType(this.gDl.getPageContext(), i);
        this.gDF.changeSkin(i);
        am.setViewTextColor(this.gDJ, (int) R.color.cp_cont_e);
        this.gDJ.setAlpha(0.95f);
        am.setBackgroundResource(this.gDJ, R.drawable.pb_ecomm_comment_bg);
        am.setViewTextColor(this.gDK, (int) R.color.cp_cont_d);
        am.setBackgroundResource(this.dyG, R.drawable.pb_ecomm_comment_bg);
        am.setViewTextColor(this.gDH, (int) R.color.cp_cont_f);
        this.gDH.setHintTextColor(am.getColor(R.color.cp_cont_e));
        am.setViewTextColor(this.gDI, (int) R.color.game_sub_pb_send_txt_color);
    }

    public void onDestroy() {
        if (this.eir != null) {
            this.gDl.getPageContext().getPageActivity().getWindow().getDecorView().getViewTreeObserver().removeGlobalOnLayoutListener(this.eir);
        }
    }
}
