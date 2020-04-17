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
    private boolean aCe;
    private View.OnClickListener aDc;
    private c dRh = new c(new c.a() { // from class: com.baidu.tieba.frs.gamesubpb.view.a.1
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
    private LinearLayout dYO;
    private ViewTreeObserver.OnGlobalLayoutListener eIH;
    private BdTypeListView eOe;
    private long eUo;
    private View gNZ;
    private boolean hasMore;
    private com.baidu.tieba.frs.gamesubpb.c hnD;
    private String hnH;
    private FrsGameSubPbActivity hnT;
    private e hon;
    private FrameLayout hoo;
    private EditText hop;
    private TextView hoq;
    private TextView hor;
    private TextView hos;
    private com.baidu.tieba.frs.gamesubpb.b hot;
    private com.baidu.tieba.frs.gamesubpb.model.b hou;
    private List<m> hov;
    private String how;
    private View mBack;
    private NavigationBar mNavigationBar;
    private ProgressBar mProgressBar;
    private RelativeLayout mRootView;

    public a(FrsGameSubPbActivity frsGameSubPbActivity, View.OnClickListener onClickListener, String str) {
        this.hnT = frsGameSubPbActivity;
        this.aDc = onClickListener;
        this.hnH = str;
        this.mRootView = (RelativeLayout) LayoutInflater.from(frsGameSubPbActivity.getPageContext().getPageActivity()).inflate(R.layout.frs_game_sub_pb_activity, (ViewGroup) null);
        this.eOe = (BdTypeListView) this.mRootView.findViewById(R.id.new_sub_pb_list);
        this.eOe.setOnTouchListener(this.dRh);
        this.eOe.setOnScrollListener(new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.frs.gamesubpb.view.a.4
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
                if (i != 0) {
                    l.hideSoftKeyPad(a.this.hnT.getPageContext().getPageActivity(), a.this.hop);
                }
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            }
        });
        this.hon = new e(this.hnT.getPageContext());
        this.gNZ = BdListViewHelper.a(this.hnT.getActivity(), this.eOe, BdListViewHelper.HeadType.DEFAULT);
        this.hor = (TextView) this.mRootView.findViewById(R.id.subpb_editor_tool_comment_reply_text);
        this.hor.setOnClickListener(this.aDc);
        this.hos = (TextView) this.mRootView.findViewById(R.id.no_reply_list_view);
        this.hoo = (FrameLayout) this.mRootView.findViewById(R.id.bottom_view);
        this.dYO = (LinearLayout) this.mRootView.findViewById(R.id.subpb_editor_tool_comment_input_container);
        this.hop = (EditText) this.mRootView.findViewById(R.id.subpb_editor_tool_comment_input_edit);
        this.hoq = (TextView) this.mRootView.findViewById(R.id.subpb_editor_tool_comment_send_tv);
        this.hoq.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.gamesubpb.view.a.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.Da(a.this.hop.getText().toString());
            }
        });
        this.mProgressBar = (ProgressBar) this.mRootView.findViewById(R.id.progressBar);
        bSV();
        this.hot = new com.baidu.tieba.frs.gamesubpb.b(this.hnT.getPageContext(), this.eOe);
        this.hot.setClickListener(new a.InterfaceC0545a() { // from class: com.baidu.tieba.frs.gamesubpb.view.a.6
            @Override // com.baidu.tieba.frs.gamesubpb.a.InterfaceC0545a
            public void a(d dVar) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonPolymericActivityConfig(a.this.hnT.getPageContext().getPageActivity()).createNormalConfig(Long.valueOf(dVar.userId).longValue(), String.valueOf(a.this.eUo).equals(dVar.userId), false)));
            }

            @Override // com.baidu.tieba.frs.gamesubpb.a.InterfaceC0545a
            public void b(d dVar) {
                if (dVar != null) {
                    a.this.d(dVar);
                }
            }

            @Override // com.baidu.tieba.frs.gamesubpb.a.InterfaceC0545a
            public void c(d dVar) {
                if (a.this.hnD != null) {
                    a.this.hnD.bSN();
                }
                if (dVar == null) {
                    a.this.Db(null);
                    a.this.bSX();
                    return;
                }
                a.this.Db(dVar.userName);
                a.this.how = dVar.userId;
            }
        });
        uf(140);
        bSW();
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        this.hov = new ArrayList();
        this.eUo = com.baidu.adp.lib.f.b.toLong(TbadkCoreApplication.getCurrentAccount(), 0L);
    }

    private void bSV() {
        this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(R.id.view_navigation_bar);
        this.mBack = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        ImageView backImageView = this.mNavigationBar.getBackImageView();
        if (backImageView != null && (backImageView.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.mBack.getLayoutParams();
            int dimens = l.getDimens(this.hnT.getPageContext().getPageActivity(), R.dimen.ds30);
            layoutParams.height = dimens;
            layoutParams.width = dimens;
            backImageView.setLayoutParams(layoutParams);
        }
        if (this.mBack != null && (this.mBack.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.mBack.getLayoutParams();
            layoutParams2.width = -2;
            layoutParams2.height = -1;
            this.mBack.setPadding(l.getDimens(this.hnT.getPageContext().getPageActivity(), R.dimen.ds32), this.mBack.getPaddingTop(), this.mBack.getPaddingRight(), this.mBack.getPaddingBottom());
            this.mBack.setLayoutParams(layoutParams2);
        }
        if (this.mNavigationBar.getBackImageView() != null) {
            SvgManager.aOU().a(this.mNavigationBar.getBackImageView(), R.drawable.icon_pure_topbar_return44_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
    }

    private void bSW() {
        this.eIH = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tieba.frs.gamesubpb.view.a.7
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                Rect rect = new Rect();
                a.this.hnT.getPageContext().getPageActivity().getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
                int statusBarHeight = l.getStatusBarHeight(a.this.hnT.getPageContext().getPageActivity());
                int[] screenDimensions = l.getScreenDimensions(a.this.hnT.getPageContext().getPageActivity());
                if (screenDimensions[1] - rect.bottom > screenDimensions[1] / 4 && !a.this.aCe) {
                    a.this.aCe = true;
                    a.this.onKeyboardVisibilityChanged(true);
                } else if (screenDimensions[1] - rect.height() == statusBarHeight && a.this.aCe) {
                    a.this.aCe = false;
                    a.this.onKeyboardVisibilityChanged(false);
                }
            }
        };
        this.hnT.getPageContext().getPageActivity().getWindow().getDecorView().getViewTreeObserver().addOnGlobalLayoutListener(this.eIH);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(final d dVar) {
        final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.hnT.getPageContext().getPageActivity());
        aVar.ue(null);
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
        aVar.b(this.hnT.getPageContext()).aMU();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(d dVar) {
        HttpMessage httpMessage = new HttpMessage(1003381);
        httpMessage.addParam("user_id", this.eUo);
        httpMessage.addParam("main_tower_id", dVar.hoj);
        httpMessage.addParam("id", dVar.id);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Da(String str) {
        ug(0);
        HttpMessage httpMessage = new HttpMessage(1003380);
        httpMessage.addParam("user_id", this.eUo);
        httpMessage.addParam("reply_user_id", this.how);
        httpMessage.addParam("content", str);
        httpMessage.addParam("main_tower_id", this.hnH);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bSX() {
        this.how = this.hou != null ? this.hou.userId : null;
    }

    private void bSY() {
        if (!v.isEmpty(this.hov)) {
            this.mNavigationBar.setCenterTextTitle(String.format(this.hnT.getResources().getString(R.string.subpb_floor_reply_count), aq.numFormatOver10000(this.hov.size())));
        } else {
            this.mNavigationBar.setCenterTextTitle(this.hnT.getResources().getString(R.string.reply));
        }
    }

    private void uf(final int i) {
        this.hop.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.frs.gamesubpb.view.a.10
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                if (!TextUtils.isEmpty(charSequence)) {
                    a.this.hoq.setEnabled(true);
                    String charSequence2 = charSequence.toString();
                    if (!StringUtils.isNull(charSequence2) && ad.getTextLength(charSequence2) > i) {
                        String subString = ad.subString(charSequence2, 0, i - 1);
                        a.this.hop.setText(subString);
                        a.this.hop.setSelection(a.this.hop.getText().length());
                        UtilHelper.showToast(a.this.hnT.getPageContext().getPageActivity().getApplication(), a.this.hnT.getPageContext().getPageActivity().getResources().getString(R.string.edit_text_over_limit_tip, Integer.valueOf(subString.length())));
                        return;
                    }
                    return;
                }
                a.this.bSX();
                a.this.hoq.setEnabled(false);
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
            }
        });
    }

    private void bSZ() {
        if (this.mNavigationBar.getBackImageView() != null) {
            SvgManager.aOU().a(this.mNavigationBar.getBackImageView(), R.drawable.icon_pure_topbar_return44_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void na(final boolean z) {
        if (this.eOe != null) {
            if (!z) {
                this.eOe.setEnabled(z);
            } else {
                this.eOe.postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.gamesubpb.view.a.11
                    @Override // java.lang.Runnable
                    public void run() {
                        a.this.eOe.setEnabled(z);
                    }
                }, 10L);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onKeyboardVisibilityChanged(boolean z) {
        if (z) {
            Rect rect = new Rect();
            this.dYO.getWindowVisibleDisplayFrame(rect);
            this.hoo.scrollTo(this.hoo.getScrollX(), (l.getScreenDimensions(this.hnT.getPageContext().getPageActivity())[1] - rect.bottom) - (MenuKeyUtils.hasSmartBar() ? l.dip2px(this.hnT.getPageContext().getPageActivity(), 48.0f) : 0));
            return;
        }
        this.hoo.setScrollY(0);
    }

    private void nb(boolean z) {
        if (v.isEmpty(this.hov)) {
            this.eOe.setNextPage(null);
            this.hos.setVisibility(0);
        } else {
            this.eOe.setNextPage(this.hon);
            this.hos.setVisibility(8);
            if (z) {
                this.hon.startLoadData();
            } else {
                this.hon.endLoadData();
            }
        }
        bSY();
    }

    public void a(boolean z, com.baidu.tieba.frs.gamesubpb.model.b bVar, List<m> list) {
        this.hasMore = z;
        this.hou = bVar;
        bSX();
        if (v.isEmpty(list)) {
            nb(z);
            return;
        }
        this.hov.clear();
        this.hov.addAll(list);
        this.hos.setVisibility(8);
        this.eOe.setNextPage(this.hon);
        this.hot.setData(list);
        bSZ();
        this.hor.setVisibility(0);
        this.hor.setText(R.string.say_your_point);
        nb(z);
    }

    public void a(boolean z, String str, d dVar) {
        ug(8);
        if (z && dVar != null) {
            BdToast.a(this.hnT.getPageContext().getPageActivity(), this.hnT.getPageContext().getString(R.string.subpb_add_comment_succ_tip), 1).aMZ();
            this.hop.setText((CharSequence) null);
            this.hov.add(dVar);
            this.hot.setData(this.hov);
            nb(this.hasMore);
            this.hop.post(new Runnable() { // from class: com.baidu.tieba.frs.gamesubpb.view.a.2
                @Override // java.lang.Runnable
                public void run() {
                    a.this.hop.requestFocus();
                    l.hideSoftKeyPad(a.this.hnT.getPageContext().getPageActivity(), a.this.hop);
                }
            });
            return;
        }
        if (TextUtils.isEmpty(str)) {
            str = this.hnT.getPageContext().getString(R.string.subpb_add_comment_fail_tip);
        }
        BdToast.a(this.hnT.getPageContext().getPageActivity(), str, 1).aMZ();
    }

    public void b(boolean z, String str, d dVar) {
        if (z) {
            BdToast.a(this.hnT.getPageContext().getPageActivity(), this.hnT.getPageContext().getString(R.string.subpb_delete_comment_succ_tip), 1).aMZ();
            this.hov.remove(dVar);
            this.hot.setData(this.hov);
            nb(this.hasMore);
            return;
        }
        if (TextUtils.isEmpty(str)) {
            str = this.hnT.getPageContext().getString(R.string.subpb_delete_comment_fail_tip);
        }
        BdToast.a(this.hnT.getPageContext().getPageActivity(), str, 1).aMZ();
    }

    public void nc(boolean z) {
        if (this.gNZ != null && this.gNZ.getLayoutParams() != null) {
            ViewGroup.LayoutParams layoutParams = this.gNZ.getLayoutParams();
            if (z) {
                bSZ();
                layoutParams.height = l.getDimens(this.hnT.getPageContext().getPageActivity(), R.dimen.ds98);
            } else {
                layoutParams.height = l.getDimens(this.hnT.getPageContext().getPageActivity(), R.dimen.ds98) + UtilHelper.getLightStatusBarHeight();
            }
            this.gNZ.setLayoutParams(layoutParams);
        }
    }

    public void cb(View view) {
        if (this.gNZ != null && this.mNavigationBar != null) {
            if (this.mNavigationBar.isNavigationBarExcludeStatusbarVisible()) {
                this.mNavigationBar.showNavigationBarExcludeStatusbar(false);
                if (UtilHelper.canUseStyleImmersiveSticky()) {
                    this.gNZ.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight()));
                } else if (this.eOe != null) {
                    this.eOe.removeHeaderView(this.gNZ);
                }
                this.mNavigationBar.setVisibility(8);
                return;
            }
            this.mNavigationBar.showNavigationBarExcludeStatusbar(true);
            if (UtilHelper.canUseStyleImmersiveSticky()) {
                this.gNZ.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + l.getDimens(this.hnT.getActivity(), R.dimen.ds98)));
            } else if (this.eOe != null) {
                this.eOe.addHeaderView(this.gNZ, 0);
            }
            this.mNavigationBar.setVisibility(0);
        }
    }

    public void Db(String str) {
        this.hor.setVisibility(8);
        this.dYO.setVisibility(0);
        this.hop.post(new Runnable() { // from class: com.baidu.tieba.frs.gamesubpb.view.a.3
            @Override // java.lang.Runnable
            public void run() {
                a.this.hop.requestFocus();
                l.showSoftKeyPad(a.this.hnT.getPageContext().getPageActivity(), a.this.hop);
            }
        });
        if (!TextUtils.isEmpty(str)) {
            String format = String.format(this.hnT.getPageContext().getPageActivity().getResources().getString(R.string.reply_sub_floor), str);
            this.hop.setText(format);
            this.hop.setSelection(format.length());
        }
    }

    public void ug(int i) {
        this.mProgressBar.setVisibility(i);
    }

    public View bIH() {
        return this.gNZ;
    }

    public View getRootView() {
        return this.mRootView;
    }

    public ListView getListView() {
        return this.eOe;
    }

    public TextView bTa() {
        return this.hor;
    }

    public NavigationBar boh() {
        return this.mNavigationBar;
    }

    public void e(com.baidu.tieba.frs.gamesubpb.c cVar) {
        this.hnD = cVar;
    }

    public void b(BdListView.e eVar) {
        this.eOe.setOnSrollToBottomListener(eVar);
    }

    public void onChangeSkinType(int i) {
        this.hnT.getLayoutMode().setNightMode(i == 1);
        this.hnT.getLayoutMode().onModeChanged(this.mRootView);
        am.setBackgroundColor(this.mRootView, R.color.cp_bg_line_d);
        this.mNavigationBar.onChangeSkinType(this.hnT.getPageContext(), i);
        this.hon.changeSkin(i);
        am.setViewTextColor(this.hor, (int) R.color.cp_cont_e);
        this.hor.setAlpha(0.95f);
        am.setBackgroundResource(this.hor, R.drawable.pb_ecomm_comment_bg);
        am.setViewTextColor(this.hos, (int) R.color.cp_cont_d);
        am.setBackgroundResource(this.dYO, R.drawable.pb_ecomm_comment_bg);
        am.setViewTextColor(this.hop, (int) R.color.cp_cont_f);
        this.hop.setHintTextColor(am.getColor(R.color.cp_cont_e));
        am.setViewTextColor(this.hoq, (int) R.color.game_sub_pb_send_txt_color);
    }

    public void onDestroy() {
        if (this.eIH != null) {
            this.hnT.getPageContext().getPageActivity().getWindow().getDecorView().getViewTreeObserver().removeGlobalOnLayoutListener(this.eIH);
        }
    }
}
