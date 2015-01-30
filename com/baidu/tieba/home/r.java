package com.baidu.tieba.home;

import android.app.AlertDialog;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.ad;
import com.baidu.tbadk.core.view.ak;
import com.baidu.tieba.x;
import com.baidu.tieba.z;
/* loaded from: classes.dex */
public class r extends com.baidu.adp.base.g<BaseFragmentActivity> {
    public static String aQq = "top_nav_all_folder";
    private TextView NO;
    private final f aQj;
    private BdListView aQk;
    private o aQl;
    private AlertDialog aQm;
    private AlertDialog aQn;
    private AlertDialog aQo;
    private View aQp;
    private View aQr;
    private NoNetworkView axR;
    private BaseFragmentActivity mActivity;
    private ak mPullView;

    public r(BaseFragmentActivity baseFragmentActivity, f fVar, View.OnKeyListener onKeyListener) {
        super(baseFragmentActivity.getPageContext());
        this.mActivity = null;
        this.aQk = null;
        this.aQl = null;
        this.aQm = null;
        this.aQn = null;
        this.aQo = null;
        this.mPullView = null;
        this.axR = null;
        this.aQr = null;
        this.mActivity = baseFragmentActivity;
        this.aQj = fVar;
        View view = fVar.getView();
        this.aQp = com.baidu.adp.lib.g.b.ei().a(this.mActivity.getPageContext().getPageActivity(), x.enter_forum_search_bar, null, false);
        this.NO = (TextView) this.aQp.findViewById(com.baidu.tieba.w.search_text_tip);
        this.axR = (NoNetworkView) this.aQp.findViewById(com.baidu.tieba.w.enter_forum_no_network);
        this.NO.setOnClickListener(fVar);
        this.aQk = (BdListView) view.findViewById(com.baidu.tieba.w.enter_forum_lv_forum);
        this.aQl = new o(baseFragmentActivity);
        this.aQl.s(fVar);
        this.aQl.a(fVar);
        this.aQl.t(fVar);
        this.aQl.u(fVar);
        this.aQl.v(fVar);
        if (fVar != null) {
            this.aQl.cm(fVar.JE());
        }
        this.aQk.setAdapter((ListAdapter) this.aQl);
        this.aQk.setOnKeyListener(onKeyListener);
        this.aQk.setOnItemClickListener(fVar);
        this.aQk.setOnScrollListener(fVar);
        this.mPullView = new ak(baseFragmentActivity.getPageContext());
        this.aQk.setPullRefresh(this.mPullView);
        this.aQk.addHeaderView(this.aQp);
        com.baidu.tbadk.core.view.i iVar = new com.baidu.tbadk.core.view.i(this.mActivity.getPageContext().getPageActivity());
        iVar.setHeightDip(30);
        this.aQk.addFooterView(iVar);
        CharSequence[] charSequenceArr = {baseFragmentActivity.getPageContext().getPageActivity().getString(z.enter_forum), baseFragmentActivity.getPageContext().getPageActivity().getString(z.delete)};
        AlertDialog.Builder builder = new AlertDialog.Builder(baseFragmentActivity.getPageContext().getPageActivity());
        builder.setTitle(baseFragmentActivity.getPageContext().getPageActivity().getString(z.operation));
        builder.setItems(charSequenceArr, fVar);
        this.aQn = builder.create();
        this.aQn.setCanceledOnTouchOutside(true);
        CharSequence[] charSequenceArr2 = {baseFragmentActivity.getPageContext().getPageActivity().getString(z.enter_forum), baseFragmentActivity.getPageContext().getPageActivity().getString(z.unfollow_title)};
        AlertDialog.Builder builder2 = new AlertDialog.Builder(baseFragmentActivity.getPageContext().getPageActivity());
        builder2.setTitle(baseFragmentActivity.getPageContext().getPageActivity().getString(z.operation));
        builder2.setItems(charSequenceArr2, fVar);
        this.aQo = builder2.create();
        this.aQo.setCanceledOnTouchOutside(true);
    }

    public void jJ() {
        this.aQk.jJ();
    }

    public void JI() {
        this.aQk.jI();
    }

    public void b(com.baidu.tieba.data.e eVar) {
        if (eVar != null) {
            try {
                this.aQl.a(eVar);
                co(eVar.CB());
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    public void co(boolean z) {
        if (!TbadkCoreApplication.isLogin()) {
            this.aQk.setVisibility(8);
            return;
        }
        this.aQk.setVisibility(0);
        if (this.aQl.yN() <= 4 && !z && MessageManager.getInstance().findTask(2012116) != null) {
            this.aQl.cl(true);
            this.aQl.cn(true);
        } else if (this.aQl.yN() <= 10 && !z) {
            this.aQl.cl(false);
            this.aQl.cn(true);
        } else {
            this.aQl.cl(false);
            this.aQl.cn(false);
        }
    }

    public boolean JJ() {
        return com.baidu.tbadk.core.sharedPref.b.oj().getBoolean("has_shown_enter_forum_guide_cover", false);
    }

    public View JK() {
        return this.aQp;
    }

    public void JL() {
        com.baidu.tbadk.core.sharedPref.b.oj().putBoolean("has_shown_enter_forum_guide_cover", true);
    }

    public void JM() {
        if (JJ()) {
            this.aQr = com.baidu.adp.lib.g.b.ei().inflate(this.mActivity.getPageContext().getPageActivity(), x.enter_forum_interest_guide, null);
            FrameLayout frameLayout = (FrameLayout) this.mActivity.findViewById(16908290);
            this.aQr.setOnClickListener(new s(this, frameLayout));
            frameLayout.addView(this.aQr);
            JL();
        }
    }

    public void h(boolean z, String str) {
        if (!z && str != null) {
            this.mActivity.showToast(str);
        }
    }

    public void notifyDataSetChanged() {
        this.aQl.notifyDataSetChanged();
    }

    public void onResume() {
        NetworkInfo activeNetworkInfo;
        if (this.axR != null && this.axR.getVisibility() == 0 && (activeNetworkInfo = ((ConnectivityManager) this.mActivity.getSystemService("connectivity")).getActiveNetworkInfo()) != null && activeNetworkInfo.isAvailable()) {
            this.axR.as(false);
        }
    }

    public void JN() {
        if (this.axR != null) {
            this.axR.as(true);
        }
    }

    public void e(ad adVar) {
        this.axR.a(adVar);
    }

    public void onChangeSkinType(int i) {
        this.mActivity.getLayoutMode().ab(i == 1);
        this.mActivity.getLayoutMode().h(this.aQk);
        this.mActivity.getLayoutMode().h(this.aQp);
        if (i == 1) {
            this.aQk.setBackgroundColor(-14274755);
        } else {
            this.aQk.setBackgroundColor(-1);
        }
        if (this.axR != null) {
            this.axR.onChangeSkinType(this.mActivity.getPageContext(), i);
        }
        this.aQl.onChangeSkinType(i);
        this.mPullView.cs(i);
    }

    public int JO() {
        return com.baidu.tieba.w.item_left;
    }

    public int JP() {
        return com.baidu.tieba.w.item_right;
    }

    public int JQ() {
        return com.baidu.tieba.w.iv_dismiss;
    }

    public int JR() {
        return com.baidu.tieba.w.enterforum_forumrecommendinfo_change;
    }

    public int JS() {
        return com.baidu.tieba.w.forum_view_root;
    }

    public int JT() {
        return com.baidu.tieba.w.add_love_ll;
    }

    public void JU() {
        com.baidu.adp.lib.g.k.a(this.aQn, this.mActivity.getPageContext());
    }

    public void JV() {
        com.baidu.adp.lib.g.k.a(this.aQo, this.mActivity.getPageContext());
    }

    public void JW() {
        if (this.aQm == null) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this.mActivity.getParent());
            builder.setTitle(z.alert_title);
            builder.setIcon(com.baidu.tieba.v.dialogue_quit);
            builder.setMessage(z.delete_like_info);
            builder.setPositiveButton(this.mActivity.getPageContext().getPageActivity().getString(z.confirm), this.aQj);
            builder.setNegativeButton(this.mActivity.getPageContext().getPageActivity().getString(z.cancel), this.aQj);
            this.aQm = builder.create();
        }
        com.baidu.adp.lib.g.k.a(this.aQm, this.mActivity.getPageContext());
    }

    public AlertDialog JX() {
        return this.aQn;
    }

    public AlertDialog JY() {
        return this.aQo;
    }

    public void a(com.baidu.adp.widget.ListView.g gVar) {
        this.mPullView.a(gVar);
    }

    public o JZ() {
        return this.aQl;
    }
}
