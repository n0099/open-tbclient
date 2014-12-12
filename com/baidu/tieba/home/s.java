package com.baidu.tieba.home;

import android.app.AlertDialog;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.ad;
import com.baidu.tbadk.core.view.ak;
import com.baidu.tieba.z;
/* loaded from: classes.dex */
public class s extends com.baidu.adp.base.g<BaseFragmentActivity> {
    public static String aPi = "top_nav_all_folder";
    private LinearLayout Mg;
    private final f aPa;
    private BdListView aPb;
    private p aPc;
    private AlertDialog aPd;
    private AlertDialog aPe;
    private AlertDialog aPf;
    private View aPg;
    private RelativeLayout aPh;
    private View aPj;
    private View aPk;
    private Button aPl;
    private Button aPm;
    private NoNetworkView awR;
    private BaseFragmentActivity mActivity;
    private ak mPullView;

    public s(BaseFragmentActivity baseFragmentActivity, f fVar, View.OnKeyListener onKeyListener) {
        super(baseFragmentActivity.getPageContext());
        this.mActivity = null;
        this.aPb = null;
        this.aPc = null;
        this.aPd = null;
        this.aPe = null;
        this.aPf = null;
        this.Mg = null;
        this.aPh = null;
        this.mPullView = null;
        this.awR = null;
        this.aPj = null;
        this.mActivity = baseFragmentActivity;
        this.aPa = fVar;
        View view = fVar.getView();
        this.Mg = (LinearLayout) view.findViewById(com.baidu.tieba.w.container);
        this.awR = (NoNetworkView) view.findViewById(com.baidu.tieba.w.view_no_network);
        this.aPh = (RelativeLayout) view.findViewById(com.baidu.tieba.w.lv_container);
        this.aPg = com.baidu.adp.lib.g.b.ek().a(this.mActivity.getPageContext().getPageActivity(), com.baidu.tieba.x.enter_forum_search_bar, null, false);
        this.aPb = (BdListView) view.findViewById(com.baidu.tieba.w.enter_forum_lv_forum);
        this.aPc = new p(baseFragmentActivity);
        this.aPc.r(fVar);
        this.aPc.a(fVar);
        this.aPc.s(fVar);
        this.aPc.t(fVar);
        this.aPc.u(fVar);
        if (fVar != null) {
            this.aPc.cj(fVar.Jg());
        }
        this.aPb.setAdapter((ListAdapter) this.aPc);
        this.aPb.setOnKeyListener(onKeyListener);
        this.aPb.setOnItemClickListener(fVar);
        this.aPb.setOnScrollListener(fVar);
        this.mPullView = new ak(baseFragmentActivity.getPageContext().getContext());
        this.aPb.setPullRefresh(this.mPullView);
        this.aPb.addHeaderView(this.aPg);
        com.baidu.tbadk.core.view.i iVar = new com.baidu.tbadk.core.view.i(this.mActivity.getPageContext().getContext());
        iVar.setHeightDip(30);
        this.aPb.addFooterView(iVar);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams.addRule(14);
        layoutParams.addRule(3, com.baidu.tieba.w.net_and_search);
        CharSequence[] charSequenceArr = {baseFragmentActivity.getPageContext().getPageActivity().getString(z.enter_forum), baseFragmentActivity.getPageContext().getPageActivity().getString(z.delete)};
        AlertDialog.Builder builder = new AlertDialog.Builder(baseFragmentActivity.getPageContext().getPageActivity());
        builder.setTitle(baseFragmentActivity.getPageContext().getPageActivity().getString(z.operation));
        builder.setItems(charSequenceArr, fVar);
        this.aPe = builder.create();
        this.aPe.setCanceledOnTouchOutside(true);
        CharSequence[] charSequenceArr2 = {baseFragmentActivity.getPageContext().getPageActivity().getString(z.enter_forum), baseFragmentActivity.getPageContext().getPageActivity().getString(z.unfollow_title)};
        AlertDialog.Builder builder2 = new AlertDialog.Builder(baseFragmentActivity.getPageContext().getPageActivity());
        builder2.setTitle(baseFragmentActivity.getPageContext().getPageActivity().getString(z.operation));
        builder2.setItems(charSequenceArr2, fVar);
        this.aPf = builder2.create();
        this.aPf.setCanceledOnTouchOutside(true);
        this.aPk = view.findViewById(com.baidu.tieba.w.enter_forum_hao123_popup_root);
        this.aPl = (Button) view.findViewById(com.baidu.tieba.w.enter_forum_hao123_popup_confirm);
        this.aPm = (Button) view.findViewById(com.baidu.tieba.w.enter_forum_hao123_popup_cancel);
        this.aPl.setOnClickListener(fVar);
        this.aPm.setOnClickListener(fVar);
    }

    public void jK() {
        this.aPb.jK();
    }

    public Button Jk() {
        return this.aPl;
    }

    public Button Jl() {
        return this.aPm;
    }

    public void Jm() {
        this.aPb.jJ();
    }

    public void b(com.baidu.tieba.data.e eVar) {
        if (eVar != null) {
            try {
                this.aPc.a(eVar);
                cl(eVar.BY());
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    public void cl(boolean z) {
        if (!TbadkCoreApplication.isLogin()) {
            this.aPb.setVisibility(8);
            return;
        }
        this.aPb.setVisibility(0);
        if (this.aPc.yx() <= 4 && !z && MessageManager.getInstance().findTask(2012116) != null) {
            this.aPc.ci(true);
            this.aPc.ck(true);
        } else if (this.aPc.yx() <= 10 && !z) {
            this.aPc.ci(false);
            this.aPc.ck(true);
        } else {
            this.aPc.ci(false);
            this.aPc.ck(false);
        }
    }

    public boolean Jn() {
        return com.baidu.tbadk.core.sharedPref.b.og().getBoolean("has_shown_enter_forum_guide_cover", false);
    }

    public View Jo() {
        return this.aPg;
    }

    public void Jp() {
        com.baidu.tbadk.core.sharedPref.b.og().putBoolean("has_shown_enter_forum_guide_cover", true);
    }

    public void Jq() {
        if (Jn()) {
            this.aPj = com.baidu.adp.lib.g.b.ek().inflate(this.mActivity.getPageContext().getPageActivity(), com.baidu.tieba.x.enter_forum_interest_guide, null);
            FrameLayout frameLayout = (FrameLayout) this.mActivity.findViewById(16908290);
            this.aPj.setOnClickListener(new t(this, frameLayout));
            frameLayout.addView(this.aPj);
            Jp();
        }
    }

    public void h(boolean z, String str) {
        if (!z && str != null) {
            this.mActivity.showToast(str);
        }
    }

    public void notifyDataSetChanged() {
        this.aPc.notifyDataSetChanged();
    }

    public void onResume() {
        NetworkInfo activeNetworkInfo;
        if (this.awR != null && this.awR.getVisibility() == 0 && (activeNetworkInfo = ((ConnectivityManager) this.mActivity.getSystemService("connectivity")).getActiveNetworkInfo()) != null && activeNetworkInfo.isAvailable()) {
            this.awR.aq(false);
        }
    }

    public void onStop() {
    }

    public void Jr() {
        if (this.awR != null) {
            this.awR.aq(true);
        }
    }

    public void e(ad adVar) {
        this.awR.a(adVar);
    }

    public void onChangeSkinType(int i) {
        this.mActivity.getLayoutMode().ab(i == 1);
        this.mActivity.getLayoutMode().h(this.Mg);
        this.mActivity.getLayoutMode().h(this.aPk);
        this.mActivity.getLayoutMode().h(this.aPg);
        if (i == 1) {
            this.aPh.setBackgroundColor(-14274755);
        } else {
            this.aPh.setBackgroundColor(-1);
        }
        if (this.awR != null) {
            this.awR.onChangeSkinType(this.mActivity.getPageContext(), i);
        }
        this.aPc.onChangeSkinType(i);
        this.mPullView.cl(i);
    }

    public int Js() {
        return com.baidu.tieba.w.item_left;
    }

    public int Jt() {
        return com.baidu.tieba.w.item_right;
    }

    public int Ju() {
        return com.baidu.tieba.w.iv_dismiss;
    }

    public int Jv() {
        return com.baidu.tieba.w.enterforum_forumrecommendinfo_change;
    }

    public int Jw() {
        return com.baidu.tieba.w.forum_view_root;
    }

    public int Jx() {
        return com.baidu.tieba.w.add_love_ll;
    }

    public void Jy() {
        com.baidu.adp.lib.g.k.a(this.aPe, this.mActivity.getPageContext());
    }

    public void Jz() {
        com.baidu.adp.lib.g.k.a(this.aPf, this.mActivity.getPageContext());
    }

    public void JA() {
        if (this.aPd == null) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this.mActivity.getParent());
            builder.setTitle(z.alert_title);
            builder.setIcon(com.baidu.tieba.v.dialogue_quit);
            builder.setMessage(z.delete_like_info);
            builder.setPositiveButton(this.mActivity.getPageContext().getPageActivity().getString(z.confirm), this.aPa);
            builder.setNegativeButton(this.mActivity.getPageContext().getPageActivity().getString(z.cancel), this.aPa);
            this.aPd = builder.create();
        }
        com.baidu.adp.lib.g.k.a(this.aPd, this.mActivity.getPageContext());
    }

    public AlertDialog JB() {
        return this.aPe;
    }

    public AlertDialog JC() {
        return this.aPf;
    }

    public void a(com.baidu.adp.widget.ListView.g gVar) {
        this.mPullView.a(gVar);
    }

    public void JD() {
        if (this.aPk != null) {
            this.aPk.setVisibility(8);
        }
    }

    public p JE() {
        return this.aPc;
    }
}
