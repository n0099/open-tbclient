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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.f;
import com.baidu.tieba.R;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes8.dex */
public class t {
    private final BdListView Yj;
    private final NoNetworkView gzT;
    private final TbPageContext<r> iWY;
    private final NavigationBar iWZ;
    private final j iXl;
    private final LinearLayout iYe;
    private final TextView iYf;
    private final s iYg;
    private final a iYh;
    private final com.baidu.tbadk.core.view.g mPullView;

    public t(TbPageContext<r> tbPageContext) {
        this.iWY = tbPageContext;
        tbPageContext.getPageActivity().setContentView(R.layout.face_shop_activity);
        this.iYe = (LinearLayout) tbPageContext.getPageActivity().findViewById(R.id.face_shop);
        this.iWZ = (NavigationBar) tbPageContext.getPageActivity().findViewById(R.id.view_navigation_bar);
        this.iWZ.setTitleText(tbPageContext.getResources().getString(R.string.face_store));
        this.iWZ.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.iYf = this.iWZ.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, tbPageContext.getResources().getString(R.string.manage));
        ap.setViewTextColor(this.iYf, R.color.CAM_X0106, 1);
        this.gzT = (NoNetworkView) tbPageContext.getPageActivity().findViewById(R.id.view_no_network);
        this.Yj = (BdListView) tbPageContext.getPageActivity().findViewById(R.id.face_shop_list);
        this.mPullView = new com.baidu.tbadk.core.view.g(tbPageContext);
        this.iYg = new s(tbPageContext.getOrignalPage());
        this.iYh = new a(tbPageContext);
        this.Yj.setAdapter((ListAdapter) this.iYg);
        this.Yj.setPullRefresh(this.mPullView);
        this.Yj.setNextPage(this.iYh);
        try {
            this.iYf.setOnClickListener(tbPageContext.getOrignalPage());
        } catch (Exception e) {
            BdLog.e(e);
        }
        this.iXl = new j(tbPageContext, R.style.common_alert_dialog);
    }

    public void c(FaceShopData faceShopData) {
        czy();
        if (faceShopData != null && faceShopData.pack_list != null && faceShopData.pack_list.size() > 0) {
            ArrayList<String> arrayList = new ArrayList<>();
            Iterator<FacePackageData> it = faceShopData.pack_list.iterator();
            while (it.hasNext()) {
                arrayList.add(String.valueOf(it.next().pid));
            }
            an(arrayList);
        }
    }

    public void an(ArrayList<String> arrayList) {
        if (arrayList != null && arrayList.size() > 0) {
            MessageManager.getInstance().dispatchResponsedMessageToUI(new QueryDownloadMessage(arrayList));
        }
    }

    public s czC() {
        return this.iYg;
    }

    public void czy() {
        this.iYh.czJ();
        this.Yj.completePullRefreshPostDelayed(0L);
    }

    public void czD() {
        this.Yj.startPullRefresh();
    }

    public void czE() {
        this.iYh.czI();
    }

    public void a(AdapterView.OnItemClickListener onItemClickListener) {
        this.Yj.setOnItemClickListener(onItemClickListener);
    }

    public void a(f.c cVar) {
        this.mPullView.setListPullRefreshListener(cVar);
    }

    public void a(BdListView.e eVar) {
        this.Yj.setOnSrollToBottomListener(eVar);
    }

    public void c(NoNetworkView.a aVar) {
        this.gzT.a(aVar);
    }

    public void d(NoNetworkView.a aVar) {
        this.gzT.b(aVar);
    }

    public void czF() {
        if (this.iYh != null) {
            this.iYh.hide();
        }
    }

    public void czG() {
        if (this.iYh != null) {
            this.iYh.display();
        }
    }

    public void onResume() {
        if (this.gzT != null && this.gzT.getVisibility() == 0 && com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
            this.gzT.update(false);
        }
    }

    public void czm() {
        if (this.iXl != null) {
            this.iXl.cyS();
            com.baidu.adp.lib.f.g.a(this.iXl, this.iWY);
        }
    }

    public void czn() {
        if (this.iXl != null) {
            this.iXl.cyT();
        }
    }

    public void czo() {
        if (this.iXl != null) {
            com.baidu.adp.lib.f.g.b(this.iXl, this.iWY);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes8.dex */
    public class a extends com.baidu.adp.widget.ListView.b {
        private View fKb;
        private final TbPageContext<?> iWY;
        private TextView mTextView = null;
        private ProgressBar mProgressBar = null;
        private View mRoot = null;

        public a(TbPageContext<?> tbPageContext) {
            this.iWY = tbPageContext;
        }

        @Override // com.baidu.adp.widget.ListView.b
        public View createView() {
            this.mRoot = LayoutInflater.from(this.iWY.getPageActivity()).inflate(R.layout.new_pb_list_more, (ViewGroup) null);
            this.mRoot.setPadding(0, this.iWY.getResources().getDimensionPixelSize(R.dimen.ds16), 0, this.iWY.getResources().getDimensionPixelSize(R.dimen.ds16));
            this.mTextView = (TextView) this.mRoot.findViewById(R.id.pb_more_text);
            this.fKb = this.mRoot.findViewById(R.id.pb_more_view);
            this.fKb.setVisibility(8);
            this.mProgressBar = (ProgressBar) this.mRoot.findViewById(R.id.progress);
            qK(TbadkApplication.getInst().getSkinType());
            this.fKb.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
            return this.mRoot;
        }

        public void qK(int i) {
            if (this.iWY != null) {
                this.iWY.getLayoutMode().setNightMode(i == 1);
                this.iWY.getLayoutMode().onModeChanged(this.fKb);
            }
        }

        public void hide() {
            this.mRoot.setVisibility(8);
        }

        public void display() {
            this.mRoot.setVisibility(0);
        }

        public void czI() {
            this.mProgressBar.setVisibility(0);
            this.mTextView.setText(this.iWY.getPageActivity().getText(R.string.loading));
            this.fKb.setVisibility(0);
        }

        public void czJ() {
            this.mProgressBar.setVisibility(8);
            this.mTextView.setText(R.string.load_more);
        }

        @Override // com.baidu.adp.widget.ListView.b
        public void onClick() {
        }
    }

    public void onChangeSkinType(int i) {
        com.baidu.tbadk.core.c layoutMode = this.iWY.getLayoutMode();
        layoutMode.setNightMode(i == 1);
        layoutMode.onModeChanged(this.iYe);
        if (this.iWZ != null) {
            this.iWZ.onChangeSkinType(this.iWY, i);
        }
        if (this.mPullView != null) {
            this.mPullView.changeSkin(i);
        }
        if (this.iYh != null) {
            this.iYh.qK(i);
        }
        if (this.gzT != null) {
            this.gzT.onChangeSkinType(this.iWY, i);
        }
    }

    public TextView czH() {
        return this.iYf;
    }
}
