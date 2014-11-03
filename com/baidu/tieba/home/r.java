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
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.y;
/* loaded from: classes.dex */
public class r extends com.baidu.adp.base.f {
    public static String aMY = "top_nav_all_folder";
    private LinearLayout Hl;
    private y Yg;
    private final f aMQ;
    private BdListView aMR;
    private o aMS;
    private AlertDialog aMT;
    private AlertDialog aMU;
    private AlertDialog aMV;
    private View aMW;
    private RelativeLayout aMX;
    private View aMZ;
    private View aNa;
    private Button aNb;
    private Button aNc;
    private NoNetworkView atH;
    private BaseFragmentActivity mActivity;

    public r(BaseFragmentActivity baseFragmentActivity, f fVar, View.OnKeyListener onKeyListener) {
        super(baseFragmentActivity);
        this.mActivity = null;
        this.aMR = null;
        this.aMS = null;
        this.aMT = null;
        this.aMU = null;
        this.aMV = null;
        this.Hl = null;
        this.aMX = null;
        this.Yg = null;
        this.atH = null;
        this.aMZ = null;
        this.mActivity = baseFragmentActivity;
        this.aMQ = fVar;
        View view = fVar.getView();
        this.Hl = (LinearLayout) view.findViewById(com.baidu.tieba.v.container);
        this.atH = (NoNetworkView) view.findViewById(com.baidu.tieba.v.view_no_network);
        this.aMX = (RelativeLayout) view.findViewById(com.baidu.tieba.v.lv_container);
        this.aMW = com.baidu.adp.lib.g.b.ek().a(this.mActivity, com.baidu.tieba.w.enter_forum_search_bar, null, false);
        this.aMR = (BdListView) view.findViewById(com.baidu.tieba.v.enter_forum_lv_forum);
        this.aMS = new o(baseFragmentActivity);
        this.aMS.q(fVar);
        this.aMS.a(fVar);
        this.aMR.setAdapter((ListAdapter) this.aMS);
        this.aMR.setOnKeyListener(onKeyListener);
        this.aMR.setOnItemClickListener(fVar);
        this.aMR.setOnScrollListener(fVar);
        this.Yg = new y(baseFragmentActivity);
        this.aMR.setPullRefresh(this.Yg);
        this.aMR.addHeaderView(this.aMW);
        com.baidu.tieba.view.i iVar = new com.baidu.tieba.view.i(this.mActivity);
        iVar.setHeightDip(30);
        this.aMR.addFooterView(iVar);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams.addRule(14);
        layoutParams.addRule(3, com.baidu.tieba.v.net_and_search);
        CharSequence[] charSequenceArr = {baseFragmentActivity.getString(com.baidu.tieba.y.enter_forum), baseFragmentActivity.getString(com.baidu.tieba.y.delete)};
        AlertDialog.Builder builder = new AlertDialog.Builder(baseFragmentActivity);
        builder.setTitle(baseFragmentActivity.getString(com.baidu.tieba.y.operation));
        builder.setItems(charSequenceArr, fVar);
        this.aMU = builder.create();
        this.aMU.setCanceledOnTouchOutside(true);
        CharSequence[] charSequenceArr2 = {baseFragmentActivity.getString(com.baidu.tieba.y.enter_forum), baseFragmentActivity.getString(com.baidu.tieba.y.unfollow_title)};
        AlertDialog.Builder builder2 = new AlertDialog.Builder(baseFragmentActivity);
        builder2.setTitle(baseFragmentActivity.getString(com.baidu.tieba.y.operation));
        builder2.setItems(charSequenceArr2, fVar);
        this.aMV = builder2.create();
        this.aMV.setCanceledOnTouchOutside(true);
        this.aNa = view.findViewById(com.baidu.tieba.v.enter_forum_hao123_popup_root);
        this.aNb = (Button) view.findViewById(com.baidu.tieba.v.enter_forum_hao123_popup_confirm);
        this.aNc = (Button) view.findViewById(com.baidu.tieba.v.enter_forum_hao123_popup_cancel);
        this.aNb.setOnClickListener(fVar);
        this.aNc.setOnClickListener(fVar);
    }

    public void hO() {
        this.aMR.hO();
    }

    public Button IP() {
        return this.aNb;
    }

    public Button IQ() {
        return this.aNc;
    }

    public void IR() {
        this.aMR.hN();
    }

    public void b(com.baidu.tieba.data.o oVar) {
        if (oVar != null) {
            try {
                this.aMS.a(oVar);
                cv(oVar.yN());
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    public void cv(boolean z) {
        if (!TbadkApplication.isLogin()) {
            this.aMR.setVisibility(8);
            return;
        }
        this.aMR.setVisibility(0);
        if (this.aMS.IN() <= 4 && !z) {
            this.aMS.cu(true);
        } else {
            this.aMS.cu(false);
        }
    }

    public boolean IS() {
        return com.baidu.tbadk.core.sharedPref.b.lk().getBoolean("has_shown_enter_forum_guide_cover", false);
    }

    public View IT() {
        return this.aMW;
    }

    public void IU() {
        com.baidu.tbadk.core.sharedPref.b.lk().putBoolean("has_shown_enter_forum_guide_cover", true);
    }

    public void IV() {
        if (IS()) {
            this.aMZ = com.baidu.adp.lib.g.b.ek().inflate(this.mActivity, com.baidu.tieba.w.enter_forum_interest_guide, null);
            FrameLayout frameLayout = (FrameLayout) this.mActivity.findViewById(16908290);
            this.aMZ.setOnClickListener(new s(this, frameLayout));
            frameLayout.addView(this.aMZ);
            IU();
        }
    }

    public void d(boolean z, String str) {
        if (!z && str != null) {
            this.mActivity.showToast(str);
        }
    }

    public void notifyDataSetChanged() {
        this.aMS.notifyDataSetChanged();
    }

    public void onResume() {
        NetworkInfo activeNetworkInfo;
        if (this.atH != null && this.atH.getVisibility() == 0 && (activeNetworkInfo = ((ConnectivityManager) this.mActivity.getSystemService("connectivity")).getActiveNetworkInfo()) != null && activeNetworkInfo.isAvailable()) {
            this.atH.Z(false);
        }
    }

    public void onStop() {
    }

    public void IW() {
        if (this.atH != null) {
            this.atH.Z(true);
        }
    }

    public void e(com.baidu.tbadk.core.view.u uVar) {
        this.atH.a(uVar);
    }

    public void onChangeSkinType(int i) {
        this.mActivity.getLayoutMode().L(i == 1);
        this.mActivity.getLayoutMode().h(this.Hl);
        this.mActivity.getLayoutMode().h(this.aNa);
        this.mActivity.getLayoutMode().h(this.aMW);
        if (i == 1) {
            this.aMX.setBackgroundColor(-14274755);
        } else {
            this.aMX.setBackgroundColor(-1);
        }
        if (this.atH != null) {
            this.atH.onChangeSkinType(i);
        }
        this.aMS.onChangeSkinType(i);
        this.Yg.bM(i);
    }

    public int IX() {
        return com.baidu.tieba.v.item_left;
    }

    public int IY() {
        return com.baidu.tieba.v.item_right;
    }

    public int IZ() {
        return com.baidu.tieba.v.recommend_item_left;
    }

    public int Ja() {
        return com.baidu.tieba.v.recommend_item_right;
    }

    public void Jb() {
        com.baidu.adp.lib.g.j.a(this.aMU, this.mActivity);
    }

    public void Jc() {
        com.baidu.adp.lib.g.j.a(this.aMV, this.mActivity);
    }

    public void Jd() {
        if (this.aMT == null) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this.mActivity.getParent());
            builder.setTitle(com.baidu.tieba.y.alert_title);
            builder.setIcon(com.baidu.tieba.u.dialogue_quit);
            builder.setMessage(com.baidu.tieba.y.delete_like_info);
            builder.setPositiveButton(this.mActivity.getString(com.baidu.tieba.y.confirm), this.aMQ);
            builder.setNegativeButton(this.mActivity.getString(com.baidu.tieba.y.cancel), this.aMQ);
            this.aMT = builder.create();
        }
        com.baidu.adp.lib.g.j.a(this.aMT, this.mActivity);
    }

    public AlertDialog Je() {
        return this.aMU;
    }

    public AlertDialog Jf() {
        return this.aMV;
    }

    public void a(com.baidu.adp.widget.ListView.f fVar) {
        this.Yg.a(fVar);
    }

    public void Jg() {
        if (this.aNa != null) {
            this.aNa.setVisibility(0);
        }
    }

    public void Jh() {
        if (this.aNa != null) {
            this.aNa.setVisibility(8);
        }
    }
}
