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
/* loaded from: classes7.dex */
public class a {
    private boolean ahn;
    private View.OnClickListener ain;
    private c dmA = new c(new c.a() { // from class: com.baidu.tieba.frs.gamesubpb.view.a.1
        @Override // com.baidu.tieba.pb.a.c.a
        public boolean onDoubleTap(View view, MotionEvent motionEvent) {
            a.this.lO(false);
            a.this.bT(view);
            a.this.lO(true);
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
    private LinearLayout duA;
    private ViewTreeObserver.OnGlobalLayoutListener eeo;
    private BdTypeListView efW;
    private long elT;
    private com.baidu.tieba.frs.gamesubpb.c gAV;
    private String gAZ;
    private e gBF;
    private FrameLayout gBG;
    private EditText gBH;
    private TextView gBI;
    private TextView gBJ;
    private TextView gBK;
    private com.baidu.tieba.frs.gamesubpb.b gBL;
    private com.baidu.tieba.frs.gamesubpb.model.b gBM;
    private List<m> gBN;
    private String gBO;
    private FrsGameSubPbActivity gBl;
    private View gbS;
    private boolean hasMore;
    private View mBack;
    private NavigationBar mNavigationBar;
    private ProgressBar mProgressBar;
    private RelativeLayout mRootView;

    public a(FrsGameSubPbActivity frsGameSubPbActivity, View.OnClickListener onClickListener, String str) {
        this.gBl = frsGameSubPbActivity;
        this.ain = onClickListener;
        this.gAZ = str;
        this.mRootView = (RelativeLayout) LayoutInflater.from(frsGameSubPbActivity.getPageContext().getPageActivity()).inflate(R.layout.frs_game_sub_pb_activity, (ViewGroup) null);
        this.efW = (BdTypeListView) this.mRootView.findViewById(R.id.new_sub_pb_list);
        this.efW.setOnTouchListener(this.dmA);
        this.efW.setOnScrollListener(new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.frs.gamesubpb.view.a.4
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
                if (i != 0) {
                    l.hideSoftKeyPad(a.this.gBl.getPageContext().getPageActivity(), a.this.gBH);
                }
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            }
        });
        this.gBF = new e(this.gBl.getPageContext());
        this.gbS = BdListViewHelper.a(this.gBl.getActivity(), this.efW, BdListViewHelper.HeadType.DEFAULT);
        this.gBJ = (TextView) this.mRootView.findViewById(R.id.subpb_editor_tool_comment_reply_text);
        this.gBJ.setOnClickListener(this.ain);
        this.gBK = (TextView) this.mRootView.findViewById(R.id.no_reply_list_view);
        this.gBG = (FrameLayout) this.mRootView.findViewById(R.id.bottom_view);
        this.duA = (LinearLayout) this.mRootView.findViewById(R.id.subpb_editor_tool_comment_input_container);
        this.gBH = (EditText) this.mRootView.findViewById(R.id.subpb_editor_tool_comment_input_edit);
        this.gBI = (TextView) this.mRootView.findViewById(R.id.subpb_editor_tool_comment_send_tv);
        this.gBI.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.gamesubpb.view.a.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.AZ(a.this.gBH.getText().toString());
            }
        });
        this.mProgressBar = (ProgressBar) this.mRootView.findViewById(R.id.progressBar);
        bGF();
        this.gBL = new com.baidu.tieba.frs.gamesubpb.b(this.gBl.getPageContext(), this.efW);
        this.gBL.setClickListener(new a.InterfaceC0501a() { // from class: com.baidu.tieba.frs.gamesubpb.view.a.6
            @Override // com.baidu.tieba.frs.gamesubpb.a.InterfaceC0501a
            public void a(d dVar) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonPolymericActivityConfig(a.this.gBl.getPageContext().getPageActivity()).createNormalConfig(Long.valueOf(dVar.userId).longValue(), String.valueOf(a.this.elT).equals(dVar.userId), false)));
            }

            @Override // com.baidu.tieba.frs.gamesubpb.a.InterfaceC0501a
            public void b(d dVar) {
                if (dVar != null) {
                    a.this.d(dVar);
                }
            }

            @Override // com.baidu.tieba.frs.gamesubpb.a.InterfaceC0501a
            public void c(d dVar) {
                if (a.this.gAV != null) {
                    a.this.gAV.bGx();
                }
                if (dVar == null) {
                    a.this.Ba(null);
                    a.this.bGH();
                    return;
                }
                a.this.Ba(dVar.userName);
                a.this.gBO = dVar.userId;
            }
        });
        tv(140);
        bGG();
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        this.gBN = new ArrayList();
        this.elT = com.baidu.adp.lib.f.b.toLong(TbadkCoreApplication.getCurrentAccount(), 0L);
    }

    private void bGF() {
        this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(R.id.view_navigation_bar);
        this.mBack = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        ImageView backImageView = this.mNavigationBar.getBackImageView();
        if (backImageView != null && (backImageView.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.mBack.getLayoutParams();
            int dimens = l.getDimens(this.gBl.getPageContext().getPageActivity(), R.dimen.ds30);
            layoutParams.height = dimens;
            layoutParams.width = dimens;
            backImageView.setLayoutParams(layoutParams);
        }
        if (this.mBack != null && (this.mBack.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.mBack.getLayoutParams();
            layoutParams2.width = -2;
            layoutParams2.height = -1;
            this.mBack.setPadding(l.getDimens(this.gBl.getPageContext().getPageActivity(), R.dimen.ds32), this.mBack.getPaddingTop(), this.mBack.getPaddingRight(), this.mBack.getPaddingBottom());
            this.mBack.setLayoutParams(layoutParams2);
        }
        if (this.mNavigationBar.getBackImageView() != null) {
            SvgManager.aEp().a(this.mNavigationBar.getBackImageView(), R.drawable.icon_pure_topbar_return44_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
    }

    private void bGG() {
        this.eeo = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tieba.frs.gamesubpb.view.a.7
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                Rect rect = new Rect();
                a.this.gBl.getPageContext().getPageActivity().getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
                int statusBarHeight = l.getStatusBarHeight(a.this.gBl.getPageContext().getPageActivity());
                int[] screenDimensions = l.getScreenDimensions(a.this.gBl.getPageContext().getPageActivity());
                if (screenDimensions[1] - rect.bottom > screenDimensions[1] / 4 && !a.this.ahn) {
                    a.this.ahn = true;
                    a.this.onKeyboardVisibilityChanged(true);
                } else if (screenDimensions[1] - rect.height() == statusBarHeight && a.this.ahn) {
                    a.this.ahn = false;
                    a.this.onKeyboardVisibilityChanged(false);
                }
            }
        };
        this.gBl.getPageContext().getPageActivity().getWindow().getDecorView().getViewTreeObserver().addOnGlobalLayoutListener(this.eeo);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(final d dVar) {
        final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.gBl.getPageContext().getPageActivity());
        aVar.sB(null);
        aVar.jF(R.string.del_post_confirm);
        aVar.fA(true);
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
        aVar.b(this.gBl.getPageContext()).aCp();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(d dVar) {
        HttpMessage httpMessage = new HttpMessage(1003381);
        httpMessage.addParam("user_id", this.elT);
        httpMessage.addParam("main_tower_id", dVar.gBB);
        httpMessage.addParam("id", dVar.id);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void AZ(String str) {
        tw(0);
        HttpMessage httpMessage = new HttpMessage(1003380);
        httpMessage.addParam("user_id", this.elT);
        httpMessage.addParam("reply_user_id", this.gBO);
        httpMessage.addParam("content", str);
        httpMessage.addParam("main_tower_id", this.gAZ);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bGH() {
        this.gBO = this.gBM != null ? this.gBM.userId : null;
    }

    private void bGI() {
        if (!v.isEmpty(this.gBN)) {
            this.mNavigationBar.setCenterTextTitle(String.format(this.gBl.getResources().getString(R.string.subpb_floor_reply_count), aq.numFormatOver10000(this.gBN.size())));
        } else {
            this.mNavigationBar.setCenterTextTitle(this.gBl.getResources().getString(R.string.reply));
        }
    }

    private void tv(final int i) {
        this.gBH.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.frs.gamesubpb.view.a.10
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                if (!TextUtils.isEmpty(charSequence)) {
                    a.this.gBI.setEnabled(true);
                    String charSequence2 = charSequence.toString();
                    if (!StringUtils.isNull(charSequence2) && ad.getTextLength(charSequence2) > i) {
                        String subString = ad.subString(charSequence2, 0, i - 1);
                        a.this.gBH.setText(subString);
                        a.this.gBH.setSelection(a.this.gBH.getText().length());
                        UtilHelper.showToast(a.this.gBl.getPageContext().getPageActivity().getApplication(), a.this.gBl.getPageContext().getPageActivity().getResources().getString(R.string.edit_text_over_limit_tip, Integer.valueOf(subString.length())));
                        return;
                    }
                    return;
                }
                a.this.bGH();
                a.this.gBI.setEnabled(false);
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
            }
        });
    }

    private void bGJ() {
        if (this.mNavigationBar.getBackImageView() != null) {
            SvgManager.aEp().a(this.mNavigationBar.getBackImageView(), R.drawable.icon_pure_topbar_return44_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lO(final boolean z) {
        if (this.efW != null) {
            if (!z) {
                this.efW.setEnabled(z);
            } else {
                this.efW.postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.gamesubpb.view.a.11
                    @Override // java.lang.Runnable
                    public void run() {
                        a.this.efW.setEnabled(z);
                    }
                }, 10L);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onKeyboardVisibilityChanged(boolean z) {
        if (z) {
            Rect rect = new Rect();
            this.duA.getWindowVisibleDisplayFrame(rect);
            this.gBG.scrollTo(this.gBG.getScrollX(), (l.getScreenDimensions(this.gBl.getPageContext().getPageActivity())[1] - rect.bottom) - (MenuKeyUtils.hasSmartBar() ? l.dip2px(this.gBl.getPageContext().getPageActivity(), 48.0f) : 0));
            return;
        }
        this.gBG.setScrollY(0);
    }

    private void lP(boolean z) {
        if (v.isEmpty(this.gBN)) {
            this.efW.setNextPage(null);
            this.gBK.setVisibility(0);
        } else {
            this.efW.setNextPage(this.gBF);
            this.gBK.setVisibility(8);
            if (z) {
                this.gBF.startLoadData();
            } else {
                this.gBF.endLoadData();
            }
        }
        bGI();
    }

    public void a(boolean z, com.baidu.tieba.frs.gamesubpb.model.b bVar, List<m> list) {
        this.hasMore = z;
        this.gBM = bVar;
        bGH();
        if (v.isEmpty(list)) {
            lP(z);
            return;
        }
        this.gBN.clear();
        this.gBN.addAll(list);
        this.gBK.setVisibility(8);
        this.efW.setNextPage(this.gBF);
        this.gBL.setData(list);
        bGJ();
        this.gBJ.setVisibility(0);
        this.gBJ.setText(R.string.say_your_point);
        lP(z);
    }

    public void a(boolean z, String str, d dVar) {
        tw(8);
        if (z && dVar != null) {
            BdToast.a(this.gBl.getPageContext().getPageActivity(), this.gBl.getPageContext().getString(R.string.subpb_add_comment_succ_tip), 1).aCu();
            this.gBH.setText((CharSequence) null);
            this.gBN.add(dVar);
            this.gBL.setData(this.gBN);
            lP(this.hasMore);
            this.gBH.post(new Runnable() { // from class: com.baidu.tieba.frs.gamesubpb.view.a.2
                @Override // java.lang.Runnable
                public void run() {
                    a.this.gBH.requestFocus();
                    l.hideSoftKeyPad(a.this.gBl.getPageContext().getPageActivity(), a.this.gBH);
                }
            });
            return;
        }
        if (TextUtils.isEmpty(str)) {
            str = this.gBl.getPageContext().getString(R.string.subpb_add_comment_fail_tip);
        }
        BdToast.a(this.gBl.getPageContext().getPageActivity(), str, 1).aCu();
    }

    public void b(boolean z, String str, d dVar) {
        if (z) {
            BdToast.a(this.gBl.getPageContext().getPageActivity(), this.gBl.getPageContext().getString(R.string.subpb_delete_comment_succ_tip), 1).aCu();
            this.gBN.remove(dVar);
            this.gBL.setData(this.gBN);
            lP(this.hasMore);
            return;
        }
        if (TextUtils.isEmpty(str)) {
            str = this.gBl.getPageContext().getString(R.string.subpb_delete_comment_fail_tip);
        }
        BdToast.a(this.gBl.getPageContext().getPageActivity(), str, 1).aCu();
    }

    public void lQ(boolean z) {
        if (this.gbS != null && this.gbS.getLayoutParams() != null) {
            ViewGroup.LayoutParams layoutParams = this.gbS.getLayoutParams();
            if (z) {
                bGJ();
                layoutParams.height = l.getDimens(this.gBl.getPageContext().getPageActivity(), R.dimen.ds98);
            } else {
                layoutParams.height = l.getDimens(this.gBl.getPageContext().getPageActivity(), R.dimen.ds98) + UtilHelper.getLightStatusBarHeight();
            }
            this.gbS.setLayoutParams(layoutParams);
        }
    }

    public void bT(View view) {
        if (this.gbS != null && this.mNavigationBar != null) {
            if (this.mNavigationBar.isNavigationBarExcludeStatusbarVisible()) {
                this.mNavigationBar.showNavigationBarExcludeStatusbar(false);
                if (UtilHelper.canUseStyleImmersiveSticky()) {
                    this.gbS.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight()));
                } else if (this.efW != null) {
                    this.efW.removeHeaderView(this.gbS);
                }
                this.mNavigationBar.setVisibility(8);
                return;
            }
            this.mNavigationBar.showNavigationBarExcludeStatusbar(true);
            if (UtilHelper.canUseStyleImmersiveSticky()) {
                this.gbS.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + l.getDimens(this.gBl.getActivity(), R.dimen.ds98)));
            } else if (this.efW != null) {
                this.efW.addHeaderView(this.gbS, 0);
            }
            this.mNavigationBar.setVisibility(0);
        }
    }

    public void Ba(String str) {
        this.gBJ.setVisibility(8);
        this.duA.setVisibility(0);
        this.gBH.post(new Runnable() { // from class: com.baidu.tieba.frs.gamesubpb.view.a.3
            @Override // java.lang.Runnable
            public void run() {
                a.this.gBH.requestFocus();
                l.showSoftKeyPad(a.this.gBl.getPageContext().getPageActivity(), a.this.gBH);
            }
        });
        if (!TextUtils.isEmpty(str)) {
            String format = String.format(this.gBl.getPageContext().getPageActivity().getResources().getString(R.string.reply_sub_floor), str);
            this.gBH.setText(format);
            this.gBH.setSelection(format.length());
        }
    }

    public void tw(int i) {
        this.mProgressBar.setVisibility(i);
    }

    public View bwX() {
        return this.gbS;
    }

    public View getRootView() {
        return this.mRootView;
    }

    public ListView getListView() {
        return this.efW;
    }

    public TextView bGK() {
        return this.gBJ;
    }

    public NavigationBar bcw() {
        return this.mNavigationBar;
    }

    public void e(com.baidu.tieba.frs.gamesubpb.c cVar) {
        this.gAV = cVar;
    }

    public void b(BdListView.e eVar) {
        this.efW.setOnSrollToBottomListener(eVar);
    }

    public void onChangeSkinType(int i) {
        this.gBl.getLayoutMode().setNightMode(i == 1);
        this.gBl.getLayoutMode().onModeChanged(this.mRootView);
        am.setBackgroundColor(this.mRootView, R.color.cp_bg_line_d);
        this.mNavigationBar.onChangeSkinType(this.gBl.getPageContext(), i);
        this.gBF.changeSkin(i);
        am.setViewTextColor(this.gBJ, (int) R.color.cp_cont_e);
        this.gBJ.setAlpha(0.95f);
        am.setBackgroundResource(this.gBJ, R.drawable.pb_ecomm_comment_bg);
        am.setViewTextColor(this.gBK, (int) R.color.cp_cont_d);
        am.setBackgroundResource(this.duA, R.drawable.pb_ecomm_comment_bg);
        am.setViewTextColor(this.gBH, (int) R.color.cp_cont_f);
        this.gBH.setHintTextColor(am.getColor(R.color.cp_cont_e));
        am.setViewTextColor(this.gBI, (int) R.color.game_sub_pb_send_txt_color);
    }

    public void onDestroy() {
        if (this.eeo != null) {
            this.gBl.getPageContext().getPageActivity().getWindow().getDecorView().getViewTreeObserver().removeGlobalOnLayoutListener(this.eeo);
        }
    }
}
