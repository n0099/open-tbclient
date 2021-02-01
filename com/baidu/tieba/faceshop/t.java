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
/* loaded from: classes9.dex */
public class t {
    private final BdListView WO;
    private final NoNetworkView gxW;
    private final TbPageContext<r> iVb;
    private final NavigationBar iVc;
    private final j iVo;
    private final LinearLayout iWh;
    private final TextView iWi;
    private final s iWj;
    private final a iWk;
    private final com.baidu.tbadk.core.view.g mPullView;

    public t(TbPageContext<r> tbPageContext) {
        this.iVb = tbPageContext;
        tbPageContext.getPageActivity().setContentView(R.layout.face_shop_activity);
        this.iWh = (LinearLayout) tbPageContext.getPageActivity().findViewById(R.id.face_shop);
        this.iVc = (NavigationBar) tbPageContext.getPageActivity().findViewById(R.id.view_navigation_bar);
        this.iVc.setTitleText(tbPageContext.getResources().getString(R.string.face_store));
        this.iVc.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.iWi = this.iVc.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, tbPageContext.getResources().getString(R.string.manage));
        ap.setViewTextColor(this.iWi, R.color.CAM_X0106, 1);
        this.gxW = (NoNetworkView) tbPageContext.getPageActivity().findViewById(R.id.view_no_network);
        this.WO = (BdListView) tbPageContext.getPageActivity().findViewById(R.id.face_shop_list);
        this.mPullView = new com.baidu.tbadk.core.view.g(tbPageContext);
        this.iWj = new s(tbPageContext.getOrignalPage());
        this.iWk = new a(tbPageContext);
        this.WO.setAdapter((ListAdapter) this.iWj);
        this.WO.setPullRefresh(this.mPullView);
        this.WO.setNextPage(this.iWk);
        try {
            this.iWi.setOnClickListener(tbPageContext.getOrignalPage());
        } catch (Exception e) {
            BdLog.e(e);
        }
        this.iVo = new j(tbPageContext, R.style.common_alert_dialog);
    }

    public void c(FaceShopData faceShopData) {
        czl();
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

    public s czp() {
        return this.iWj;
    }

    public void czl() {
        this.iWk.czw();
        this.WO.completePullRefreshPostDelayed(0L);
    }

    public void czq() {
        this.WO.startPullRefresh();
    }

    public void czr() {
        this.iWk.czv();
    }

    public void a(AdapterView.OnItemClickListener onItemClickListener) {
        this.WO.setOnItemClickListener(onItemClickListener);
    }

    public void a(f.c cVar) {
        this.mPullView.setListPullRefreshListener(cVar);
    }

    public void a(BdListView.e eVar) {
        this.WO.setOnSrollToBottomListener(eVar);
    }

    public void c(NoNetworkView.a aVar) {
        this.gxW.a(aVar);
    }

    public void d(NoNetworkView.a aVar) {
        this.gxW.b(aVar);
    }

    public void czs() {
        if (this.iWk != null) {
            this.iWk.hide();
        }
    }

    public void czt() {
        if (this.iWk != null) {
            this.iWk.display();
        }
    }

    public void onResume() {
        if (this.gxW != null && this.gxW.getVisibility() == 0 && com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
            this.gxW.update(false);
        }
    }

    public void cyZ() {
        if (this.iVo != null) {
            this.iVo.cyF();
            com.baidu.adp.lib.f.g.a(this.iVo, this.iVb);
        }
    }

    public void cza() {
        if (this.iVo != null) {
            this.iVo.cyG();
        }
    }

    public void czb() {
        if (this.iVo != null) {
            com.baidu.adp.lib.f.g.b(this.iVo, this.iVb);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes9.dex */
    public class a extends com.baidu.adp.widget.ListView.b {
        private View fIC;
        private final TbPageContext<?> iVb;
        private TextView mTextView = null;
        private ProgressBar mProgressBar = null;
        private View mRoot = null;

        public a(TbPageContext<?> tbPageContext) {
            this.iVb = tbPageContext;
        }

        @Override // com.baidu.adp.widget.ListView.b
        public View createView() {
            this.mRoot = LayoutInflater.from(this.iVb.getPageActivity()).inflate(R.layout.new_pb_list_more, (ViewGroup) null);
            this.mRoot.setPadding(0, this.iVb.getResources().getDimensionPixelSize(R.dimen.ds16), 0, this.iVb.getResources().getDimensionPixelSize(R.dimen.ds16));
            this.mTextView = (TextView) this.mRoot.findViewById(R.id.pb_more_text);
            this.fIC = this.mRoot.findViewById(R.id.pb_more_view);
            this.fIC.setVisibility(8);
            this.mProgressBar = (ProgressBar) this.mRoot.findViewById(R.id.progress);
            qJ(TbadkApplication.getInst().getSkinType());
            this.fIC.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
            return this.mRoot;
        }

        public void qJ(int i) {
            if (this.iVb != null) {
                this.iVb.getLayoutMode().setNightMode(i == 1);
                this.iVb.getLayoutMode().onModeChanged(this.fIC);
            }
        }

        public void hide() {
            this.mRoot.setVisibility(8);
        }

        public void display() {
            this.mRoot.setVisibility(0);
        }

        public void czv() {
            this.mProgressBar.setVisibility(0);
            this.mTextView.setText(this.iVb.getPageActivity().getText(R.string.loading));
            this.fIC.setVisibility(0);
        }

        public void czw() {
            this.mProgressBar.setVisibility(8);
            this.mTextView.setText(R.string.load_more);
        }

        @Override // com.baidu.adp.widget.ListView.b
        public void onClick() {
        }
    }

    public void onChangeSkinType(int i) {
        com.baidu.tbadk.core.c layoutMode = this.iVb.getLayoutMode();
        layoutMode.setNightMode(i == 1);
        layoutMode.onModeChanged(this.iWh);
        if (this.iVc != null) {
            this.iVc.onChangeSkinType(this.iVb, i);
        }
        if (this.mPullView != null) {
            this.mPullView.changeSkin(i);
        }
        if (this.iWk != null) {
            this.iWk.qJ(i);
        }
        if (this.gxW != null) {
            this.gxW.onChangeSkinType(this.iVb, i);
        }
    }

    public TextView czu() {
        return this.iWi;
    }
}
