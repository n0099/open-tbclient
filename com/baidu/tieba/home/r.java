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
    public static String aQp = "top_nav_all_folder";
    private TextView NL;
    private final f aQi;
    private BdListView aQj;
    private o aQk;
    private AlertDialog aQl;
    private AlertDialog aQm;
    private AlertDialog aQn;
    private View aQo;
    private View aQq;
    private NoNetworkView axO;
    private BaseFragmentActivity mActivity;
    private ak mPullView;

    public r(BaseFragmentActivity baseFragmentActivity, f fVar, View.OnKeyListener onKeyListener) {
        super(baseFragmentActivity.getPageContext());
        this.mActivity = null;
        this.aQj = null;
        this.aQk = null;
        this.aQl = null;
        this.aQm = null;
        this.aQn = null;
        this.mPullView = null;
        this.axO = null;
        this.aQq = null;
        this.mActivity = baseFragmentActivity;
        this.aQi = fVar;
        View view = fVar.getView();
        this.aQo = com.baidu.adp.lib.g.b.ei().a(this.mActivity.getPageContext().getPageActivity(), x.enter_forum_search_bar, null, false);
        this.NL = (TextView) this.aQo.findViewById(com.baidu.tieba.w.search_text_tip);
        this.axO = (NoNetworkView) this.aQo.findViewById(com.baidu.tieba.w.enter_forum_no_network);
        this.NL.setOnClickListener(fVar);
        this.aQj = (BdListView) view.findViewById(com.baidu.tieba.w.enter_forum_lv_forum);
        this.aQk = new o(baseFragmentActivity);
        this.aQk.s(fVar);
        this.aQk.a(fVar);
        this.aQk.t(fVar);
        this.aQk.u(fVar);
        this.aQk.v(fVar);
        if (fVar != null) {
            this.aQk.cm(fVar.Jz());
        }
        this.aQj.setAdapter((ListAdapter) this.aQk);
        this.aQj.setOnKeyListener(onKeyListener);
        this.aQj.setOnItemClickListener(fVar);
        this.aQj.setOnScrollListener(fVar);
        this.mPullView = new ak(baseFragmentActivity.getPageContext());
        this.aQj.setPullRefresh(this.mPullView);
        this.aQj.addHeaderView(this.aQo);
        com.baidu.tbadk.core.view.i iVar = new com.baidu.tbadk.core.view.i(this.mActivity.getPageContext().getPageActivity());
        iVar.setHeightDip(30);
        this.aQj.addFooterView(iVar);
        CharSequence[] charSequenceArr = {baseFragmentActivity.getPageContext().getPageActivity().getString(z.enter_forum), baseFragmentActivity.getPageContext().getPageActivity().getString(z.delete)};
        AlertDialog.Builder builder = new AlertDialog.Builder(baseFragmentActivity.getPageContext().getPageActivity());
        builder.setTitle(baseFragmentActivity.getPageContext().getPageActivity().getString(z.operation));
        builder.setItems(charSequenceArr, fVar);
        this.aQm = builder.create();
        this.aQm.setCanceledOnTouchOutside(true);
        CharSequence[] charSequenceArr2 = {baseFragmentActivity.getPageContext().getPageActivity().getString(z.enter_forum), baseFragmentActivity.getPageContext().getPageActivity().getString(z.unfollow_title)};
        AlertDialog.Builder builder2 = new AlertDialog.Builder(baseFragmentActivity.getPageContext().getPageActivity());
        builder2.setTitle(baseFragmentActivity.getPageContext().getPageActivity().getString(z.operation));
        builder2.setItems(charSequenceArr2, fVar);
        this.aQn = builder2.create();
        this.aQn.setCanceledOnTouchOutside(true);
    }

    public void jC() {
        this.aQj.jC();
    }

    public void JD() {
        this.aQj.jB();
    }

    public void b(com.baidu.tieba.data.e eVar) {
        if (eVar != null) {
            try {
                this.aQk.a(eVar);
                co(eVar.Cv());
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    public void co(boolean z) {
        if (!TbadkCoreApplication.isLogin()) {
            this.aQj.setVisibility(8);
            return;
        }
        this.aQj.setVisibility(0);
        if (this.aQk.yH() <= 4 && !z && MessageManager.getInstance().findTask(2012116) != null) {
            this.aQk.cl(true);
            this.aQk.cn(true);
        } else if (this.aQk.yH() <= 10 && !z) {
            this.aQk.cl(false);
            this.aQk.cn(true);
        } else {
            this.aQk.cl(false);
            this.aQk.cn(false);
        }
    }

    public boolean JE() {
        return com.baidu.tbadk.core.sharedPref.b.oc().getBoolean("has_shown_enter_forum_guide_cover", false);
    }

    public View JF() {
        return this.aQo;
    }

    public void JG() {
        com.baidu.tbadk.core.sharedPref.b.oc().putBoolean("has_shown_enter_forum_guide_cover", true);
    }

    public void JH() {
        if (JE()) {
            this.aQq = com.baidu.adp.lib.g.b.ei().inflate(this.mActivity.getPageContext().getPageActivity(), x.enter_forum_interest_guide, null);
            FrameLayout frameLayout = (FrameLayout) this.mActivity.findViewById(16908290);
            this.aQq.setOnClickListener(new s(this, frameLayout));
            frameLayout.addView(this.aQq);
            JG();
        }
    }

    public void h(boolean z, String str) {
        if (!z && str != null) {
            this.mActivity.showToast(str);
        }
    }

    public void notifyDataSetChanged() {
        this.aQk.notifyDataSetChanged();
    }

    public void onResume() {
        NetworkInfo activeNetworkInfo;
        if (this.axO != null && this.axO.getVisibility() == 0 && (activeNetworkInfo = ((ConnectivityManager) this.mActivity.getSystemService("connectivity")).getActiveNetworkInfo()) != null && activeNetworkInfo.isAvailable()) {
            this.axO.as(false);
        }
    }

    public void JI() {
        if (this.axO != null) {
            this.axO.as(true);
        }
    }

    public void e(ad adVar) {
        this.axO.a(adVar);
    }

    public void onChangeSkinType(int i) {
        this.mActivity.getLayoutMode().ab(i == 1);
        this.mActivity.getLayoutMode().h(this.aQj);
        this.mActivity.getLayoutMode().h(this.aQo);
        if (i == 1) {
            this.aQj.setBackgroundColor(-14274755);
        } else {
            this.aQj.setBackgroundColor(-1);
        }
        if (this.axO != null) {
            this.axO.onChangeSkinType(this.mActivity.getPageContext(), i);
        }
        this.aQk.onChangeSkinType(i);
        this.mPullView.cs(i);
    }

    public int JJ() {
        return com.baidu.tieba.w.item_left;
    }

    public int JK() {
        return com.baidu.tieba.w.item_right;
    }

    public int JL() {
        return com.baidu.tieba.w.iv_dismiss;
    }

    public int JM() {
        return com.baidu.tieba.w.enterforum_forumrecommendinfo_change;
    }

    public int JN() {
        return com.baidu.tieba.w.forum_view_root;
    }

    public int JO() {
        return com.baidu.tieba.w.add_love_ll;
    }

    public void JP() {
        com.baidu.adp.lib.g.k.a(this.aQm, this.mActivity.getPageContext());
    }

    public void JQ() {
        com.baidu.adp.lib.g.k.a(this.aQn, this.mActivity.getPageContext());
    }

    public void JR() {
        if (this.aQl == null) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this.mActivity.getParent());
            builder.setTitle(z.alert_title);
            builder.setIcon(com.baidu.tieba.v.dialogue_quit);
            builder.setMessage(z.delete_like_info);
            builder.setPositiveButton(this.mActivity.getPageContext().getPageActivity().getString(z.confirm), this.aQi);
            builder.setNegativeButton(this.mActivity.getPageContext().getPageActivity().getString(z.cancel), this.aQi);
            this.aQl = builder.create();
        }
        com.baidu.adp.lib.g.k.a(this.aQl, this.mActivity.getPageContext());
    }

    public AlertDialog JS() {
        return this.aQm;
    }

    public AlertDialog JT() {
        return this.aQn;
    }

    public void a(com.baidu.adp.widget.ListView.g gVar) {
        this.mPullView.a(gVar);
    }

    public o JU() {
        return this.aQk;
    }
}
