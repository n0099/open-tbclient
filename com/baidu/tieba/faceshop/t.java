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
    private final NoNetworkView gyk;
    private final j iVC;
    private final TbPageContext<r> iVp;
    private final NavigationBar iVq;
    private final LinearLayout iWv;
    private final TextView iWw;
    private final s iWx;
    private final a iWy;
    private final com.baidu.tbadk.core.view.g mPullView;

    public t(TbPageContext<r> tbPageContext) {
        this.iVp = tbPageContext;
        tbPageContext.getPageActivity().setContentView(R.layout.face_shop_activity);
        this.iWv = (LinearLayout) tbPageContext.getPageActivity().findViewById(R.id.face_shop);
        this.iVq = (NavigationBar) tbPageContext.getPageActivity().findViewById(R.id.view_navigation_bar);
        this.iVq.setTitleText(tbPageContext.getResources().getString(R.string.face_store));
        this.iVq.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.iWw = this.iVq.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, tbPageContext.getResources().getString(R.string.manage));
        ap.setViewTextColor(this.iWw, R.color.CAM_X0106, 1);
        this.gyk = (NoNetworkView) tbPageContext.getPageActivity().findViewById(R.id.view_no_network);
        this.WO = (BdListView) tbPageContext.getPageActivity().findViewById(R.id.face_shop_list);
        this.mPullView = new com.baidu.tbadk.core.view.g(tbPageContext);
        this.iWx = new s(tbPageContext.getOrignalPage());
        this.iWy = new a(tbPageContext);
        this.WO.setAdapter((ListAdapter) this.iWx);
        this.WO.setPullRefresh(this.mPullView);
        this.WO.setNextPage(this.iWy);
        try {
            this.iWw.setOnClickListener(tbPageContext.getOrignalPage());
        } catch (Exception e) {
            BdLog.e(e);
        }
        this.iVC = new j(tbPageContext, R.style.common_alert_dialog);
    }

    public void c(FaceShopData faceShopData) {
        czs();
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

    public s czw() {
        return this.iWx;
    }

    public void czs() {
        this.iWy.czD();
        this.WO.completePullRefreshPostDelayed(0L);
    }

    public void czx() {
        this.WO.startPullRefresh();
    }

    public void czy() {
        this.iWy.czC();
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
        this.gyk.a(aVar);
    }

    public void d(NoNetworkView.a aVar) {
        this.gyk.b(aVar);
    }

    public void czz() {
        if (this.iWy != null) {
            this.iWy.hide();
        }
    }

    public void czA() {
        if (this.iWy != null) {
            this.iWy.display();
        }
    }

    public void onResume() {
        if (this.gyk != null && this.gyk.getVisibility() == 0 && com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
            this.gyk.update(false);
        }
    }

    public void czg() {
        if (this.iVC != null) {
            this.iVC.cyM();
            com.baidu.adp.lib.f.g.a(this.iVC, this.iVp);
        }
    }

    public void czh() {
        if (this.iVC != null) {
            this.iVC.cyN();
        }
    }

    public void czi() {
        if (this.iVC != null) {
            com.baidu.adp.lib.f.g.b(this.iVC, this.iVp);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes9.dex */
    public class a extends com.baidu.adp.widget.ListView.b {
        private View fIC;
        private final TbPageContext<?> iVp;
        private TextView mTextView = null;
        private ProgressBar mProgressBar = null;
        private View mRoot = null;

        public a(TbPageContext<?> tbPageContext) {
            this.iVp = tbPageContext;
        }

        @Override // com.baidu.adp.widget.ListView.b
        public View createView() {
            this.mRoot = LayoutInflater.from(this.iVp.getPageActivity()).inflate(R.layout.new_pb_list_more, (ViewGroup) null);
            this.mRoot.setPadding(0, this.iVp.getResources().getDimensionPixelSize(R.dimen.ds16), 0, this.iVp.getResources().getDimensionPixelSize(R.dimen.ds16));
            this.mTextView = (TextView) this.mRoot.findViewById(R.id.pb_more_text);
            this.fIC = this.mRoot.findViewById(R.id.pb_more_view);
            this.fIC.setVisibility(8);
            this.mProgressBar = (ProgressBar) this.mRoot.findViewById(R.id.progress);
            qJ(TbadkApplication.getInst().getSkinType());
            this.fIC.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
            return this.mRoot;
        }

        public void qJ(int i) {
            if (this.iVp != null) {
                this.iVp.getLayoutMode().setNightMode(i == 1);
                this.iVp.getLayoutMode().onModeChanged(this.fIC);
            }
        }

        public void hide() {
            this.mRoot.setVisibility(8);
        }

        public void display() {
            this.mRoot.setVisibility(0);
        }

        public void czC() {
            this.mProgressBar.setVisibility(0);
            this.mTextView.setText(this.iVp.getPageActivity().getText(R.string.loading));
            this.fIC.setVisibility(0);
        }

        public void czD() {
            this.mProgressBar.setVisibility(8);
            this.mTextView.setText(R.string.load_more);
        }

        @Override // com.baidu.adp.widget.ListView.b
        public void onClick() {
        }
    }

    public void onChangeSkinType(int i) {
        com.baidu.tbadk.core.c layoutMode = this.iVp.getLayoutMode();
        layoutMode.setNightMode(i == 1);
        layoutMode.onModeChanged(this.iWv);
        if (this.iVq != null) {
            this.iVq.onChangeSkinType(this.iVp, i);
        }
        if (this.mPullView != null) {
            this.mPullView.changeSkin(i);
        }
        if (this.iWy != null) {
            this.iWy.qJ(i);
        }
        if (this.gyk != null) {
            this.gyk.onChangeSkinType(this.iVp, i);
        }
    }

    public TextView czB() {
        return this.iWw;
    }
}
