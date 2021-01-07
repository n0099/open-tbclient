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
/* loaded from: classes9.dex */
public class t {
    private final BdListView WV;
    private final NoNetworkView gzT;
    private final TbPageContext<r> iUb;
    private final NavigationBar iUc;
    private final j iUo;
    private final LinearLayout iVh;
    private final TextView iVi;
    private final s iVj;
    private final a iVk;
    private final com.baidu.tbadk.core.view.g mPullView;

    public t(TbPageContext<r> tbPageContext) {
        this.iUb = tbPageContext;
        tbPageContext.getPageActivity().setContentView(R.layout.face_shop_activity);
        this.iVh = (LinearLayout) tbPageContext.getPageActivity().findViewById(R.id.face_shop);
        this.iUc = (NavigationBar) tbPageContext.getPageActivity().findViewById(R.id.view_navigation_bar);
        this.iUc.setTitleText(tbPageContext.getResources().getString(R.string.face_store));
        this.iUc.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.iVi = this.iUc.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, tbPageContext.getResources().getString(R.string.manage));
        ao.setViewTextColor(this.iVi, R.color.CAM_X0106, 1);
        this.gzT = (NoNetworkView) tbPageContext.getPageActivity().findViewById(R.id.view_no_network);
        this.WV = (BdListView) tbPageContext.getPageActivity().findViewById(R.id.face_shop_list);
        this.mPullView = new com.baidu.tbadk.core.view.g(tbPageContext);
        this.iVj = new s(tbPageContext.getOrignalPage());
        this.iVk = new a(tbPageContext);
        this.WV.setAdapter((ListAdapter) this.iVj);
        this.WV.setPullRefresh(this.mPullView);
        this.WV.setNextPage(this.iVk);
        try {
            this.iVi.setOnClickListener(tbPageContext.getOrignalPage());
        } catch (Exception e) {
            BdLog.e(e);
        }
        this.iUo = new j(tbPageContext, R.style.common_alert_dialog);
    }

    public void c(FaceShopData faceShopData) {
        cBS();
        if (faceShopData != null && faceShopData.pack_list != null && faceShopData.pack_list.size() > 0) {
            ArrayList<String> arrayList = new ArrayList<>();
            Iterator<FacePackageData> it = faceShopData.pack_list.iterator();
            while (it.hasNext()) {
                arrayList.add(String.valueOf(it.next().pid));
            }
            at(arrayList);
        }
    }

    public void at(ArrayList<String> arrayList) {
        if (arrayList != null && arrayList.size() > 0) {
            MessageManager.getInstance().dispatchResponsedMessageToUI(new QueryDownloadMessage(arrayList));
        }
    }

    public s cBW() {
        return this.iVj;
    }

    public void cBS() {
        this.iVk.cCd();
        this.WV.completePullRefreshPostDelayed(0L);
    }

    public void cBX() {
        this.WV.startPullRefresh();
    }

    public void cBY() {
        this.iVk.cCc();
    }

    public void a(AdapterView.OnItemClickListener onItemClickListener) {
        this.WV.setOnItemClickListener(onItemClickListener);
    }

    public void a(f.c cVar) {
        this.mPullView.setListPullRefreshListener(cVar);
    }

    public void a(BdListView.e eVar) {
        this.WV.setOnSrollToBottomListener(eVar);
    }

    public void c(NoNetworkView.a aVar) {
        this.gzT.a(aVar);
    }

    public void d(NoNetworkView.a aVar) {
        this.gzT.b(aVar);
    }

    public void cBZ() {
        if (this.iVk != null) {
            this.iVk.hide();
        }
    }

    public void cCa() {
        if (this.iVk != null) {
            this.iVk.rV();
        }
    }

    public void onResume() {
        if (this.gzT != null && this.gzT.getVisibility() == 0 && com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
            this.gzT.update(false);
        }
    }

    public void cBG() {
        if (this.iUo != null) {
            this.iUo.cBm();
            com.baidu.adp.lib.f.g.a(this.iUo, this.iUb);
        }
    }

    public void cBH() {
        if (this.iUo != null) {
            this.iUo.cBn();
        }
    }

    public void cBI() {
        if (this.iUo != null) {
            com.baidu.adp.lib.f.g.b(this.iUo, this.iUb);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes9.dex */
    public class a extends com.baidu.adp.widget.ListView.b {
        private View fKX;
        private final TbPageContext<?> iUb;
        private TextView mTextView = null;
        private ProgressBar mProgressBar = null;
        private View mRoot = null;

        public a(TbPageContext<?> tbPageContext) {
            this.iUb = tbPageContext;
        }

        @Override // com.baidu.adp.widget.ListView.b
        public View createView() {
            this.mRoot = LayoutInflater.from(this.iUb.getPageActivity()).inflate(R.layout.new_pb_list_more, (ViewGroup) null);
            this.mRoot.setPadding(0, this.iUb.getResources().getDimensionPixelSize(R.dimen.ds16), 0, this.iUb.getResources().getDimensionPixelSize(R.dimen.ds16));
            this.mTextView = (TextView) this.mRoot.findViewById(R.id.pb_more_text);
            this.fKX = this.mRoot.findViewById(R.id.pb_more_view);
            this.fKX.setVisibility(8);
            this.mProgressBar = (ProgressBar) this.mRoot.findViewById(R.id.progress);
            sk(TbadkApplication.getInst().getSkinType());
            this.fKX.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
            return this.mRoot;
        }

        public void sk(int i) {
            if (this.iUb != null) {
                this.iUb.getLayoutMode().setNightMode(i == 1);
                this.iUb.getLayoutMode().onModeChanged(this.fKX);
            }
        }

        public void hide() {
            this.mRoot.setVisibility(8);
        }

        public void rV() {
            this.mRoot.setVisibility(0);
        }

        public void cCc() {
            this.mProgressBar.setVisibility(0);
            this.mTextView.setText(this.iUb.getPageActivity().getText(R.string.loading));
            this.fKX.setVisibility(0);
        }

        public void cCd() {
            this.mProgressBar.setVisibility(8);
            this.mTextView.setText(R.string.load_more);
        }

        @Override // com.baidu.adp.widget.ListView.b
        public void onClick() {
        }
    }

    public void onChangeSkinType(int i) {
        com.baidu.tbadk.core.c layoutMode = this.iUb.getLayoutMode();
        layoutMode.setNightMode(i == 1);
        layoutMode.onModeChanged(this.iVh);
        if (this.iUc != null) {
            this.iUc.onChangeSkinType(this.iUb, i);
        }
        if (this.mPullView != null) {
            this.mPullView.changeSkin(i);
        }
        if (this.iVk != null) {
            this.iVk.sk(i);
        }
        if (this.gzT != null) {
            this.gzT.onChangeSkinType(this.iUb, i);
        }
    }

    public TextView cCb() {
        return this.iVi;
    }
}
