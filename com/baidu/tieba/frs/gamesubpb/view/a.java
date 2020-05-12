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
    private boolean aCk;
    private View.OnClickListener aDi;
    private c dRm = new c(new c.a() { // from class: com.baidu.tieba.frs.gamesubpb.view.a.1
        @Override // com.baidu.tieba.pb.a.c.a
        public boolean onDoubleTap(View view, MotionEvent motionEvent) {
            a.this.na(false);
            a.this.cb(view);
            a.this.na(true);
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
    private LinearLayout dYT;
    private ViewTreeObserver.OnGlobalLayoutListener eIM;
    private BdTypeListView eOj;
    private long eUt;
    private View gOf;
    private boolean hasMore;
    private com.baidu.tieba.frs.gamesubpb.c hnJ;
    private String hnN;
    private FrsGameSubPbActivity hnZ;
    private com.baidu.tieba.frs.gamesubpb.model.b hoA;
    private List<m> hoB;
    private String hoC;
    private e hot;
    private FrameLayout hou;
    private EditText hov;
    private TextView how;
    private TextView hox;
    private TextView hoy;
    private com.baidu.tieba.frs.gamesubpb.b hoz;
    private View mBack;
    private NavigationBar mNavigationBar;
    private ProgressBar mProgressBar;
    private RelativeLayout mRootView;

    public a(FrsGameSubPbActivity frsGameSubPbActivity, View.OnClickListener onClickListener, String str) {
        this.hnZ = frsGameSubPbActivity;
        this.aDi = onClickListener;
        this.hnN = str;
        this.mRootView = (RelativeLayout) LayoutInflater.from(frsGameSubPbActivity.getPageContext().getPageActivity()).inflate(R.layout.frs_game_sub_pb_activity, (ViewGroup) null);
        this.eOj = (BdTypeListView) this.mRootView.findViewById(R.id.new_sub_pb_list);
        this.eOj.setOnTouchListener(this.dRm);
        this.eOj.setOnScrollListener(new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.frs.gamesubpb.view.a.4
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
                if (i != 0) {
                    l.hideSoftKeyPad(a.this.hnZ.getPageContext().getPageActivity(), a.this.hov);
                }
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            }
        });
        this.hot = new e(this.hnZ.getPageContext());
        this.gOf = BdListViewHelper.a(this.hnZ.getActivity(), this.eOj, BdListViewHelper.HeadType.DEFAULT);
        this.hox = (TextView) this.mRootView.findViewById(R.id.subpb_editor_tool_comment_reply_text);
        this.hox.setOnClickListener(this.aDi);
        this.hoy = (TextView) this.mRootView.findViewById(R.id.no_reply_list_view);
        this.hou = (FrameLayout) this.mRootView.findViewById(R.id.bottom_view);
        this.dYT = (LinearLayout) this.mRootView.findViewById(R.id.subpb_editor_tool_comment_input_container);
        this.hov = (EditText) this.mRootView.findViewById(R.id.subpb_editor_tool_comment_input_edit);
        this.how = (TextView) this.mRootView.findViewById(R.id.subpb_editor_tool_comment_send_tv);
        this.how.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.gamesubpb.view.a.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.Dd(a.this.hov.getText().toString());
            }
        });
        this.mProgressBar = (ProgressBar) this.mRootView.findViewById(R.id.progressBar);
        bSU();
        this.hoz = new com.baidu.tieba.frs.gamesubpb.b(this.hnZ.getPageContext(), this.eOj);
        this.hoz.setClickListener(new a.InterfaceC0566a() { // from class: com.baidu.tieba.frs.gamesubpb.view.a.6
            @Override // com.baidu.tieba.frs.gamesubpb.a.InterfaceC0566a
            public void a(d dVar) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonPolymericActivityConfig(a.this.hnZ.getPageContext().getPageActivity()).createNormalConfig(Long.valueOf(dVar.userId).longValue(), String.valueOf(a.this.eUt).equals(dVar.userId), false)));
            }

            @Override // com.baidu.tieba.frs.gamesubpb.a.InterfaceC0566a
            public void b(d dVar) {
                if (dVar != null) {
                    a.this.d(dVar);
                }
            }

            @Override // com.baidu.tieba.frs.gamesubpb.a.InterfaceC0566a
            public void c(d dVar) {
                if (a.this.hnJ != null) {
                    a.this.hnJ.bSM();
                }
                if (dVar == null) {
                    a.this.De(null);
                    a.this.bSW();
                    return;
                }
                a.this.De(dVar.userName);
                a.this.hoC = dVar.userId;
            }
        });
        uf(140);
        bSV();
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        this.hoB = new ArrayList();
        this.eUt = com.baidu.adp.lib.f.b.toLong(TbadkCoreApplication.getCurrentAccount(), 0L);
    }

    private void bSU() {
        this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(R.id.view_navigation_bar);
        this.mBack = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        ImageView backImageView = this.mNavigationBar.getBackImageView();
        if (backImageView != null && (backImageView.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.mBack.getLayoutParams();
            int dimens = l.getDimens(this.hnZ.getPageContext().getPageActivity(), R.dimen.ds30);
            layoutParams.height = dimens;
            layoutParams.width = dimens;
            backImageView.setLayoutParams(layoutParams);
        }
        if (this.mBack != null && (this.mBack.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.mBack.getLayoutParams();
            layoutParams2.width = -2;
            layoutParams2.height = -1;
            this.mBack.setPadding(l.getDimens(this.hnZ.getPageContext().getPageActivity(), R.dimen.ds32), this.mBack.getPaddingTop(), this.mBack.getPaddingRight(), this.mBack.getPaddingBottom());
            this.mBack.setLayoutParams(layoutParams2);
        }
        if (this.mNavigationBar.getBackImageView() != null) {
            SvgManager.aOR().a(this.mNavigationBar.getBackImageView(), R.drawable.icon_pure_topbar_return44_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
    }

    private void bSV() {
        this.eIM = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tieba.frs.gamesubpb.view.a.7
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                Rect rect = new Rect();
                a.this.hnZ.getPageContext().getPageActivity().getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
                int statusBarHeight = l.getStatusBarHeight(a.this.hnZ.getPageContext().getPageActivity());
                int[] screenDimensions = l.getScreenDimensions(a.this.hnZ.getPageContext().getPageActivity());
                if (screenDimensions[1] - rect.bottom > screenDimensions[1] / 4 && !a.this.aCk) {
                    a.this.aCk = true;
                    a.this.onKeyboardVisibilityChanged(true);
                } else if (screenDimensions[1] - rect.height() == statusBarHeight && a.this.aCk) {
                    a.this.aCk = false;
                    a.this.onKeyboardVisibilityChanged(false);
                }
            }
        };
        this.hnZ.getPageContext().getPageActivity().getWindow().getDecorView().getViewTreeObserver().addOnGlobalLayoutListener(this.eIM);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(final d dVar) {
        final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.hnZ.getPageContext().getPageActivity());
        aVar.uh(null);
        aVar.kd(R.string.del_post_confirm);
        aVar.gF(true);
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
        aVar.b(this.hnZ.getPageContext()).aMS();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(d dVar) {
        HttpMessage httpMessage = new HttpMessage(1003381);
        httpMessage.addParam("user_id", this.eUt);
        httpMessage.addParam("main_tower_id", dVar.hop);
        httpMessage.addParam("id", dVar.id);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Dd(String str) {
        ug(0);
        HttpMessage httpMessage = new HttpMessage(1003380);
        httpMessage.addParam("user_id", this.eUt);
        httpMessage.addParam("reply_user_id", this.hoC);
        httpMessage.addParam("content", str);
        httpMessage.addParam("main_tower_id", this.hnN);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bSW() {
        this.hoC = this.hoA != null ? this.hoA.userId : null;
    }

    private void bSX() {
        if (!v.isEmpty(this.hoB)) {
            this.mNavigationBar.setCenterTextTitle(String.format(this.hnZ.getResources().getString(R.string.subpb_floor_reply_count), aq.numFormatOver10000(this.hoB.size())));
        } else {
            this.mNavigationBar.setCenterTextTitle(this.hnZ.getResources().getString(R.string.reply));
        }
    }

    private void uf(final int i) {
        this.hov.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.frs.gamesubpb.view.a.10
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                if (!TextUtils.isEmpty(charSequence)) {
                    a.this.how.setEnabled(true);
                    String charSequence2 = charSequence.toString();
                    if (!StringUtils.isNull(charSequence2) && ad.getTextLength(charSequence2) > i) {
                        String subString = ad.subString(charSequence2, 0, i - 1);
                        a.this.hov.setText(subString);
                        a.this.hov.setSelection(a.this.hov.getText().length());
                        UtilHelper.showToast(a.this.hnZ.getPageContext().getPageActivity().getApplication(), a.this.hnZ.getPageContext().getPageActivity().getResources().getString(R.string.edit_text_over_limit_tip, Integer.valueOf(subString.length())));
                        return;
                    }
                    return;
                }
                a.this.bSW();
                a.this.how.setEnabled(false);
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
            }
        });
    }

    private void bSY() {
        if (this.mNavigationBar.getBackImageView() != null) {
            SvgManager.aOR().a(this.mNavigationBar.getBackImageView(), R.drawable.icon_pure_topbar_return44_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void na(final boolean z) {
        if (this.eOj != null) {
            if (!z) {
                this.eOj.setEnabled(z);
            } else {
                this.eOj.postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.gamesubpb.view.a.11
                    @Override // java.lang.Runnable
                    public void run() {
                        a.this.eOj.setEnabled(z);
                    }
                }, 10L);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onKeyboardVisibilityChanged(boolean z) {
        if (z) {
            Rect rect = new Rect();
            this.dYT.getWindowVisibleDisplayFrame(rect);
            this.hou.scrollTo(this.hou.getScrollX(), (l.getScreenDimensions(this.hnZ.getPageContext().getPageActivity())[1] - rect.bottom) - (MenuKeyUtils.hasSmartBar() ? l.dip2px(this.hnZ.getPageContext().getPageActivity(), 48.0f) : 0));
            return;
        }
        this.hou.setScrollY(0);
    }

    private void nb(boolean z) {
        if (v.isEmpty(this.hoB)) {
            this.eOj.setNextPage(null);
            this.hoy.setVisibility(0);
        } else {
            this.eOj.setNextPage(this.hot);
            this.hoy.setVisibility(8);
            if (z) {
                this.hot.startLoadData();
            } else {
                this.hot.endLoadData();
            }
        }
        bSX();
    }

    public void a(boolean z, com.baidu.tieba.frs.gamesubpb.model.b bVar, List<m> list) {
        this.hasMore = z;
        this.hoA = bVar;
        bSW();
        if (v.isEmpty(list)) {
            nb(z);
            return;
        }
        this.hoB.clear();
        this.hoB.addAll(list);
        this.hoy.setVisibility(8);
        this.eOj.setNextPage(this.hot);
        this.hoz.setData(list);
        bSY();
        this.hox.setVisibility(0);
        this.hox.setText(R.string.say_your_point);
        nb(z);
    }

    public void a(boolean z, String str, d dVar) {
        ug(8);
        if (z && dVar != null) {
            BdToast.a(this.hnZ.getPageContext().getPageActivity(), this.hnZ.getPageContext().getString(R.string.subpb_add_comment_succ_tip), 1).aMX();
            this.hov.setText((CharSequence) null);
            this.hoB.add(dVar);
            this.hoz.setData(this.hoB);
            nb(this.hasMore);
            this.hov.post(new Runnable() { // from class: com.baidu.tieba.frs.gamesubpb.view.a.2
                @Override // java.lang.Runnable
                public void run() {
                    a.this.hov.requestFocus();
                    l.hideSoftKeyPad(a.this.hnZ.getPageContext().getPageActivity(), a.this.hov);
                }
            });
            return;
        }
        if (TextUtils.isEmpty(str)) {
            str = this.hnZ.getPageContext().getString(R.string.subpb_add_comment_fail_tip);
        }
        BdToast.a(this.hnZ.getPageContext().getPageActivity(), str, 1).aMX();
    }

    public void b(boolean z, String str, d dVar) {
        if (z) {
            BdToast.a(this.hnZ.getPageContext().getPageActivity(), this.hnZ.getPageContext().getString(R.string.subpb_delete_comment_succ_tip), 1).aMX();
            this.hoB.remove(dVar);
            this.hoz.setData(this.hoB);
            nb(this.hasMore);
            return;
        }
        if (TextUtils.isEmpty(str)) {
            str = this.hnZ.getPageContext().getString(R.string.subpb_delete_comment_fail_tip);
        }
        BdToast.a(this.hnZ.getPageContext().getPageActivity(), str, 1).aMX();
    }

    public void nc(boolean z) {
        if (this.gOf != null && this.gOf.getLayoutParams() != null) {
            ViewGroup.LayoutParams layoutParams = this.gOf.getLayoutParams();
            if (z) {
                bSY();
                layoutParams.height = l.getDimens(this.hnZ.getPageContext().getPageActivity(), R.dimen.ds98);
            } else {
                layoutParams.height = l.getDimens(this.hnZ.getPageContext().getPageActivity(), R.dimen.ds98) + UtilHelper.getLightStatusBarHeight();
            }
            this.gOf.setLayoutParams(layoutParams);
        }
    }

    public void cb(View view) {
        if (this.gOf != null && this.mNavigationBar != null) {
            if (this.mNavigationBar.isNavigationBarExcludeStatusbarVisible()) {
                this.mNavigationBar.showNavigationBarExcludeStatusbar(false);
                if (UtilHelper.canUseStyleImmersiveSticky()) {
                    this.gOf.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight()));
                } else if (this.eOj != null) {
                    this.eOj.removeHeaderView(this.gOf);
                }
                this.mNavigationBar.setVisibility(8);
                return;
            }
            this.mNavigationBar.showNavigationBarExcludeStatusbar(true);
            if (UtilHelper.canUseStyleImmersiveSticky()) {
                this.gOf.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + l.getDimens(this.hnZ.getActivity(), R.dimen.ds98)));
            } else if (this.eOj != null) {
                this.eOj.addHeaderView(this.gOf, 0);
            }
            this.mNavigationBar.setVisibility(0);
        }
    }

    public void De(String str) {
        this.hox.setVisibility(8);
        this.dYT.setVisibility(0);
        this.hov.post(new Runnable() { // from class: com.baidu.tieba.frs.gamesubpb.view.a.3
            @Override // java.lang.Runnable
            public void run() {
                a.this.hov.requestFocus();
                l.showSoftKeyPad(a.this.hnZ.getPageContext().getPageActivity(), a.this.hov);
            }
        });
        if (!TextUtils.isEmpty(str)) {
            String format = String.format(this.hnZ.getPageContext().getPageActivity().getResources().getString(R.string.reply_sub_floor), str);
            this.hov.setText(format);
            this.hov.setSelection(format.length());
        }
    }

    public void ug(int i) {
        this.mProgressBar.setVisibility(i);
    }

    public View bIG() {
        return this.gOf;
    }

    public View getRootView() {
        return this.mRootView;
    }

    public ListView getListView() {
        return this.eOj;
    }

    public TextView bSZ() {
        return this.hox;
    }

    public NavigationBar bof() {
        return this.mNavigationBar;
    }

    public void e(com.baidu.tieba.frs.gamesubpb.c cVar) {
        this.hnJ = cVar;
    }

    public void b(BdListView.e eVar) {
        this.eOj.setOnSrollToBottomListener(eVar);
    }

    public void onChangeSkinType(int i) {
        this.hnZ.getLayoutMode().setNightMode(i == 1);
        this.hnZ.getLayoutMode().onModeChanged(this.mRootView);
        am.setBackgroundColor(this.mRootView, R.color.cp_bg_line_d);
        this.mNavigationBar.onChangeSkinType(this.hnZ.getPageContext(), i);
        this.hot.changeSkin(i);
        am.setViewTextColor(this.hox, (int) R.color.cp_cont_e);
        this.hox.setAlpha(0.95f);
        am.setBackgroundResource(this.hox, R.drawable.pb_ecomm_comment_bg);
        am.setViewTextColor(this.hoy, (int) R.color.cp_cont_d);
        am.setBackgroundResource(this.dYT, R.drawable.pb_ecomm_comment_bg);
        am.setViewTextColor(this.hov, (int) R.color.cp_cont_f);
        this.hov.setHintTextColor(am.getColor(R.color.cp_cont_e));
        am.setViewTextColor(this.how, (int) R.color.game_sub_pb_send_txt_color);
    }

    public void onDestroy() {
        if (this.eIM != null) {
            this.hnZ.getPageContext().getPageActivity().getWindow().getDecorView().getViewTreeObserver().removeGlobalOnLayoutListener(this.eIM);
        }
    }
}
