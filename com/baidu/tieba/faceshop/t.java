package com.baidu.tieba.faceshop;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.f;
import com.baidu.tieba.R;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes8.dex */
public class t {
    private final BdListView WT;
    private final NoNetworkView gvm;
    private final j iPH;
    private final TbPageContext<r> iPu;
    private final NavigationBar iPv;
    private final LinearLayout iQA;
    private final TextView iQB;
    private final s iQC;
    private final a iQD;
    private final com.baidu.tbadk.core.view.g mPullView;

    public t(TbPageContext<r> tbPageContext) {
        this.iPu = tbPageContext;
        tbPageContext.getPageActivity().setContentView(R.layout.face_shop_activity);
        this.iQA = (LinearLayout) tbPageContext.getPageActivity().findViewById(R.id.face_shop);
        this.iPv = (NavigationBar) tbPageContext.getPageActivity().findViewById(R.id.view_navigation_bar);
        this.iPv.setTitleText(tbPageContext.getResources().getString(R.string.face_store));
        this.iPv.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.iQB = this.iPv.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, tbPageContext.getResources().getString(R.string.manage));
        ao.setViewTextColor(this.iQB, R.color.CAM_X0106, 1);
        this.gvm = (NoNetworkView) tbPageContext.getPageActivity().findViewById(R.id.view_no_network);
        this.WT = (BdListView) tbPageContext.getPageActivity().findViewById(R.id.face_shop_list);
        this.mPullView = new com.baidu.tbadk.core.view.g(tbPageContext);
        this.iQC = new s(tbPageContext.getOrignalPage());
        this.iQD = new a(tbPageContext);
        this.WT.setAdapter((ListAdapter) this.iQC);
        this.WT.setPullRefresh(this.mPullView);
        this.WT.setNextPage(this.iQD);
        try {
            this.iQB.setOnClickListener(tbPageContext.getOrignalPage());
        } catch (Exception e) {
            BdLog.e(e);
        }
        this.iPH = new j(tbPageContext, R.style.common_alert_dialog);
    }

    public void c(FaceShopData faceShopData) {
        cya();
        if (faceShopData != null && faceShopData.pack_list != null && faceShopData.pack_list.size() > 0) {
            ArrayList<String> arrayList = new ArrayList<>();
            Iterator<FacePackageData> it = faceShopData.pack_list.iterator();
            while (it.hasNext()) {
                arrayList.add(String.valueOf(it.next().pid));
            }
            ao(arrayList);
        }
    }

    public void ao(ArrayList<String> arrayList) {
        if (arrayList != null && arrayList.size() > 0) {
            MessageManager.getInstance().dispatchResponsedMessageToUI(new QueryDownloadMessage(arrayList));
        }
    }

    public s cye() {
        return this.iQC;
    }

    public void cya() {
        this.iQD.cyl();
        this.WT.completePullRefreshPostDelayed(0L);
    }

    public void cyf() {
        this.WT.startPullRefresh();
    }

    public void cyg() {
        this.iQD.cyk();
    }

    public void a(AdapterView.OnItemClickListener onItemClickListener) {
        this.WT.setOnItemClickListener(onItemClickListener);
    }

    public void a(f.c cVar) {
        this.mPullView.setListPullRefreshListener(cVar);
    }

    public void a(BdListView.e eVar) {
        this.WT.setOnSrollToBottomListener(eVar);
    }

    public void c(NoNetworkView.a aVar) {
        this.gvm.a(aVar);
    }

    public void d(NoNetworkView.a aVar) {
        this.gvm.b(aVar);
    }

    public void cyh() {
        if (this.iQD != null) {
            this.iQD.hide();
        }
    }

    public void cyi() {
        if (this.iQD != null) {
            this.iQD.rV();
        }
    }

    public void onResume() {
        if (this.gvm != null && this.gvm.getVisibility() == 0 && com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
            this.gvm.update(false);
        }
    }

    public void cxO() {
        if (this.iPH != null) {
            this.iPH.cxu();
            com.baidu.adp.lib.f.g.a(this.iPH, this.iPu);
        }
    }

    public void cxP() {
        if (this.iPH != null) {
            this.iPH.cxv();
        }
    }

    public void cxQ() {
        if (this.iPH != null) {
            com.baidu.adp.lib.f.g.b(this.iPH, this.iPu);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes8.dex */
    public class a extends com.baidu.adp.widget.ListView.b {
        private View fGq;
        private final TbPageContext<?> iPu;
        private TextView mTextView = null;
        private ProgressBar mProgressBar = null;
        private View mRoot = null;

        public a(TbPageContext<?> tbPageContext) {
            this.iPu = tbPageContext;
        }

        @Override // com.baidu.adp.widget.ListView.b
        public View createView() {
            this.mRoot = LayoutInflater.from(this.iPu.getPageActivity()).inflate(R.layout.new_pb_list_more, (ViewGroup) null);
            this.mRoot.setPadding(0, this.iPu.getResources().getDimensionPixelSize(R.dimen.ds16), 0, this.iPu.getResources().getDimensionPixelSize(R.dimen.ds16));
            this.mTextView = (TextView) this.mRoot.findViewById(R.id.pb_more_text);
            this.fGq = this.mRoot.findViewById(R.id.pb_more_view);
            this.fGq.setVisibility(8);
            this.mProgressBar = (ProgressBar) this.mRoot.findViewById(R.id.progress);
            qE(TbadkApplication.getInst().getSkinType());
            this.fGq.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
            return this.mRoot;
        }

        public void qE(int i) {
            if (this.iPu != null) {
                this.iPu.getLayoutMode().setNightMode(i == 1);
                this.iPu.getLayoutMode().onModeChanged(this.fGq);
            }
        }

        public void hide() {
            this.mRoot.setVisibility(8);
        }

        public void rV() {
            this.mRoot.setVisibility(0);
        }

        public void cyk() {
            this.mProgressBar.setVisibility(0);
            this.mTextView.setText(this.iPu.getPageActivity().getText(R.string.loading));
            this.fGq.setVisibility(0);
        }

        public void cyl() {
            this.mProgressBar.setVisibility(8);
            this.mTextView.setText(R.string.load_more);
        }

        @Override // com.baidu.adp.widget.ListView.b
        public void onClick() {
        }
    }

    public void onChangeSkinType(int i) {
        com.baidu.tbadk.core.c layoutMode = this.iPu.getLayoutMode();
        layoutMode.setNightMode(i == 1);
        layoutMode.onModeChanged(this.iQA);
        if (this.iPv != null) {
            this.iPv.onChangeSkinType(this.iPu, i);
        }
        if (this.mPullView != null) {
            this.mPullView.changeSkin(i);
        }
        if (this.iQD != null) {
            this.iQD.qE(i);
        }
        if (this.gvm != null) {
            this.gvm.onChangeSkinType(this.iPu, i);
        }
    }

    public TextView cyj() {
        return this.iQB;
    }
}
