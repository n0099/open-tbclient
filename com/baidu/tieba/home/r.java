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
    public static String aMK = "top_nav_all_folder";
    private LinearLayout Hk;
    private y Yc;
    private final f aMC;
    private BdListView aMD;
    private o aME;
    private AlertDialog aMF;
    private AlertDialog aMG;
    private AlertDialog aMH;
    private View aMI;
    private RelativeLayout aMJ;
    private View aML;
    private View aMM;
    private Button aMN;
    private Button aMO;
    private NoNetworkView aty;
    private BaseFragmentActivity mActivity;

    public r(BaseFragmentActivity baseFragmentActivity, f fVar, View.OnKeyListener onKeyListener) {
        super(baseFragmentActivity);
        this.mActivity = null;
        this.aMD = null;
        this.aME = null;
        this.aMF = null;
        this.aMG = null;
        this.aMH = null;
        this.Hk = null;
        this.aMJ = null;
        this.Yc = null;
        this.aty = null;
        this.aML = null;
        this.mActivity = baseFragmentActivity;
        this.aMC = fVar;
        View view = fVar.getView();
        this.Hk = (LinearLayout) view.findViewById(com.baidu.tieba.v.container);
        this.aty = (NoNetworkView) view.findViewById(com.baidu.tieba.v.view_no_network);
        this.aMJ = (RelativeLayout) view.findViewById(com.baidu.tieba.v.lv_container);
        this.aMI = com.baidu.adp.lib.g.b.ek().a(this.mActivity, com.baidu.tieba.w.enter_forum_search_bar, null, false);
        this.aMD = (BdListView) view.findViewById(com.baidu.tieba.v.enter_forum_lv_forum);
        this.aME = new o(baseFragmentActivity);
        this.aME.q(fVar);
        this.aME.a(fVar);
        this.aMD.setAdapter((ListAdapter) this.aME);
        this.aMD.setOnKeyListener(onKeyListener);
        this.aMD.setOnItemClickListener(fVar);
        this.aMD.setOnScrollListener(fVar);
        this.Yc = new y(baseFragmentActivity);
        this.aMD.setPullRefresh(this.Yc);
        this.aMD.addHeaderView(this.aMI);
        com.baidu.tieba.view.i iVar = new com.baidu.tieba.view.i(this.mActivity);
        iVar.setHeightDip(30);
        this.aMD.addFooterView(iVar);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams.addRule(14);
        layoutParams.addRule(3, com.baidu.tieba.v.net_and_search);
        CharSequence[] charSequenceArr = {baseFragmentActivity.getString(com.baidu.tieba.y.enter_forum), baseFragmentActivity.getString(com.baidu.tieba.y.delete)};
        AlertDialog.Builder builder = new AlertDialog.Builder(baseFragmentActivity);
        builder.setTitle(baseFragmentActivity.getString(com.baidu.tieba.y.operation));
        builder.setItems(charSequenceArr, fVar);
        this.aMG = builder.create();
        this.aMG.setCanceledOnTouchOutside(true);
        CharSequence[] charSequenceArr2 = {baseFragmentActivity.getString(com.baidu.tieba.y.enter_forum), baseFragmentActivity.getString(com.baidu.tieba.y.unfollow_title)};
        AlertDialog.Builder builder2 = new AlertDialog.Builder(baseFragmentActivity);
        builder2.setTitle(baseFragmentActivity.getString(com.baidu.tieba.y.operation));
        builder2.setItems(charSequenceArr2, fVar);
        this.aMH = builder2.create();
        this.aMH.setCanceledOnTouchOutside(true);
        this.aMM = view.findViewById(com.baidu.tieba.v.enter_forum_hao123_popup_root);
        this.aMN = (Button) view.findViewById(com.baidu.tieba.v.enter_forum_hao123_popup_confirm);
        this.aMO = (Button) view.findViewById(com.baidu.tieba.v.enter_forum_hao123_popup_cancel);
        this.aMN.setOnClickListener(fVar);
        this.aMO.setOnClickListener(fVar);
    }

    public void hO() {
        this.aMD.hO();
    }

    public Button IL() {
        return this.aMN;
    }

    public Button IM() {
        return this.aMO;
    }

    public void IN() {
        this.aMD.hN();
    }

    public void b(com.baidu.tieba.data.o oVar) {
        if (oVar != null) {
            try {
                this.aME.a(oVar);
                cv(oVar.yL());
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    public void cv(boolean z) {
        if (!TbadkApplication.isLogin()) {
            this.aMD.setVisibility(8);
            return;
        }
        this.aMD.setVisibility(0);
        if (this.aME.IJ() <= 4 && !z) {
            this.aME.cu(true);
        } else {
            this.aME.cu(false);
        }
    }

    public boolean IO() {
        return com.baidu.tbadk.core.sharedPref.b.lk().getBoolean("has_shown_enter_forum_guide_cover", false);
    }

    public View IP() {
        return this.aMI;
    }

    public void IQ() {
        com.baidu.tbadk.core.sharedPref.b.lk().putBoolean("has_shown_enter_forum_guide_cover", true);
    }

    public void IR() {
        if (IO()) {
            this.aML = com.baidu.adp.lib.g.b.ek().inflate(this.mActivity, com.baidu.tieba.w.enter_forum_interest_guide, null);
            FrameLayout frameLayout = (FrameLayout) this.mActivity.findViewById(16908290);
            this.aML.setOnClickListener(new s(this, frameLayout));
            frameLayout.addView(this.aML);
            IQ();
        }
    }

    public void d(boolean z, String str) {
        if (!z && str != null) {
            this.mActivity.showToast(str);
        }
    }

    public void notifyDataSetChanged() {
        this.aME.notifyDataSetChanged();
    }

    public void onResume() {
        NetworkInfo activeNetworkInfo;
        if (this.aty != null && this.aty.getVisibility() == 0 && (activeNetworkInfo = ((ConnectivityManager) this.mActivity.getSystemService("connectivity")).getActiveNetworkInfo()) != null && activeNetworkInfo.isAvailable()) {
            this.aty.Z(false);
        }
    }

    public void onStop() {
    }

    public void IS() {
        if (this.aty != null) {
            this.aty.Z(true);
        }
    }

    public void e(com.baidu.tbadk.core.view.u uVar) {
        this.aty.a(uVar);
    }

    public void onChangeSkinType(int i) {
        this.mActivity.getLayoutMode().L(i == 1);
        this.mActivity.getLayoutMode().h(this.Hk);
        this.mActivity.getLayoutMode().h(this.aMM);
        this.mActivity.getLayoutMode().h(this.aMI);
        if (i == 1) {
            this.aMJ.setBackgroundColor(-14274755);
        } else {
            this.aMJ.setBackgroundColor(-1);
        }
        if (this.aty != null) {
            this.aty.onChangeSkinType(i);
        }
        this.aME.onChangeSkinType(i);
        this.Yc.bM(i);
    }

    public int IT() {
        return com.baidu.tieba.v.item_left;
    }

    public int IU() {
        return com.baidu.tieba.v.item_right;
    }

    public int IV() {
        return com.baidu.tieba.v.recommend_item_left;
    }

    public int IW() {
        return com.baidu.tieba.v.recommend_item_right;
    }

    public void IX() {
        com.baidu.adp.lib.g.j.a(this.aMG, this.mActivity);
    }

    public void IY() {
        com.baidu.adp.lib.g.j.a(this.aMH, this.mActivity);
    }

    public void IZ() {
        if (this.aMF == null) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this.mActivity.getParent());
            builder.setTitle(com.baidu.tieba.y.alert_title);
            builder.setIcon(com.baidu.tieba.u.dialogue_quit);
            builder.setMessage(com.baidu.tieba.y.delete_like_info);
            builder.setPositiveButton(this.mActivity.getString(com.baidu.tieba.y.confirm), this.aMC);
            builder.setNegativeButton(this.mActivity.getString(com.baidu.tieba.y.cancel), this.aMC);
            this.aMF = builder.create();
        }
        com.baidu.adp.lib.g.j.a(this.aMF, this.mActivity);
    }

    public AlertDialog Ja() {
        return this.aMG;
    }

    public AlertDialog Jb() {
        return this.aMH;
    }

    public void a(com.baidu.adp.widget.ListView.f fVar) {
        this.Yc.a(fVar);
    }

    public void Jc() {
        if (this.aMM != null) {
            this.aMM.setVisibility(0);
        }
    }

    public void Jd() {
        if (this.aMM != null) {
            this.aMM.setVisibility(8);
        }
    }
}
