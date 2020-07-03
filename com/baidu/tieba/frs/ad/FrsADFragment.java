package com.baidu.tieba.frs.ad;

import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.adp.widget.ListView.q;
import com.baidu.adp.widget.ListView.z;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationConstants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tbadk.core.util.w;
import com.baidu.tbadk.pageInfo.TbPageTag;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.adModel.ADHttpResponseMessage;
import com.baidu.tieba.frs.adModel.ADRequestModel;
import com.baidu.tieba.frs.adModel.ADSocketResponseMessage;
import com.baidu.tieba.frs.aq;
import com.baidu.tieba.frs.as;
import com.baidu.tieba.frs.r;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes9.dex */
public class FrsADFragment extends BaseFragment implements BdListView.e, aq, as {
    private TbPageContext context;
    private long forumId;
    private ADRequestModel.a hEV;
    private ADRequestModel hEW;
    private a hEX;
    private List<c> hEY;
    private com.baidu.tbadk.k.c hEZ;
    private String hzC;
    private String mFrom;
    private boolean mHasMore;
    protected e hEU = null;
    private int offset = 0;
    public int Xx = 0;
    private ArrayList<q> gZU = new ArrayList<>();
    private int cTi = 0;
    private int hAH = 0;
    private CustomMessageListener hDd = new CustomMessageListener(2921397) { // from class: com.baidu.tieba.frs.ad.FrsADFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Integer num;
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Integer) && (num = (Integer) customResponsedMessage.getData()) != null && FrsADFragment.this.hEZ != null && FrsADFragment.this.hEZ.isViewAttached()) {
                FrsADFragment.this.hEZ.nP(num.intValue());
            }
        }
    };
    private final RecyclerView.OnScrollListener mScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.frs.ad.FrsADFragment.3
        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            FrsADFragment.this.hAH += i2;
            if (FrsADFragment.this.hAH >= FrsADFragment.this.cTi * 2 && i2 < 0) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921437, true));
            }
        }
    };
    private CustomMessageListener hFa = new CustomMessageListener(CmdConfigCustom.CMD_FRS_TAB_SELECTED) { // from class: com.baidu.tieba.frs.ad.FrsADFragment.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                Object data = customResponsedMessage.getData();
                if ((data instanceof Integer) && Integer.parseInt(data.toString()) == 90) {
                    if (FrsADFragment.this.getListView() != null) {
                        FrsADFragment.this.getListView().setSelection(0);
                    }
                    if (FrsADFragment.this.hEZ != null && FrsADFragment.this.hEZ.isViewAttached()) {
                        FrsADFragment.this.uP(0);
                    } else if (FrsADFragment.this.hEU != null) {
                        FrsADFragment.this.hEU.startPullRefresh();
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_EXPAND_BAR_HEADER, true));
                    }
                }
            }
        }
    };
    private CustomMessageListener hAR = new CustomMessageListener(CmdConfigCustom.CMD_FRS_TAB_CLICK) { // from class: com.baidu.tieba.frs.ad.FrsADFragment.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                Object data = customResponsedMessage.getData();
                if ((data instanceof Integer) && Integer.parseInt(data.toString()) == 90) {
                    if (FrsADFragment.this.getListView() != null) {
                        FrsADFragment.this.getListView().setSelection(0);
                    }
                    if (FrsADFragment.this.hEZ != null && FrsADFragment.this.hEZ.isViewAttached()) {
                        FrsADFragment.this.uP(0);
                        FrsADFragment.this.showLoadingView();
                    } else if (FrsADFragment.this.hEU != null) {
                        FrsADFragment.this.hEU.startPullRefresh();
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_EXPAND_BAR_HEADER, true));
                    }
                }
            }
        }
    };
    private z hBp = new z() { // from class: com.baidu.tieba.frs.ad.FrsADFragment.6
        @Override // com.baidu.adp.widget.ListView.z
        public void a(View view, q qVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            c cVar;
            if (qVar != null && (qVar instanceof c) && (cVar = (c) qVar) != null && cVar.biz() != null) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(new Pair("showad", "1"));
                bc.aWU().b(FrsADFragment.this.context, new String[]{com.baidu.tbadk.browser.a.appendParams(cVar.biz(), arrayList)});
                if (!ar.isEmpty(cVar.cau())) {
                    TiebaStatic.log(new ao("c13194").dk("obj_type", cVar.cau()).s("fid", FrsADFragment.this.forumId));
                }
            }
        }
    };

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        car();
    }

    private void car() {
        if (isPrimary()) {
            if (this.hEZ != null && this.hEZ.isViewAttached()) {
                MessageManager.getInstance().registerListener(this.hDd);
                return;
            }
            return;
        }
        MessageManager.getInstance().unRegisterListener(this.hDd);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.context = getPageContext();
        initData(bundle);
        registerListener(this.hFa);
        registerListener(this.hAR);
        if (this.hEW == null) {
            this.hEW = new ADRequestModel(this.context);
        }
        this.cTi = UtilHelper.getScreenHeight(getActivity());
    }

    private void initData(Bundle bundle) {
        if (bundle != null) {
            this.hzC = bundle.getString("name");
            this.mFrom = bundle.getString("from");
            this.forumId = Long.parseLong(bundle.getString("forum_id"));
            return;
        }
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.hzC = arguments.getString("name");
            this.mFrom = arguments.getString("from");
            this.forumId = Long.parseLong(arguments.getString("forum_id"));
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.frs_ad_fragment, (ViewGroup) null);
        this.hEU = new e(this, inflate);
        this.hEU.setOnScrollListener(this.mScrollListener);
        this.hEX = new a(this, this.hEU.getListView());
        this.hEX.a(this.hBp);
        if (this.hEV == null) {
            this.hEV = new ADRequestModel.a() { // from class: com.baidu.tieba.frs.ad.FrsADFragment.2
                @Override // com.baidu.tieba.frs.adModel.ADRequestModel.a
                public void a(ADHttpResponseMessage aDHttpResponseMessage) {
                    if (aDHttpResponseMessage != null && FrsADFragment.this.hEU != null) {
                        if (aDHttpResponseMessage.getError() == 0) {
                            FrsADFragment.this.offset = (int) aDHttpResponseMessage.getOffset();
                            FrsADFragment.this.hEY = aDHttpResponseMessage.getList();
                            FrsADFragment.this.mHasMore = aDHttpResponseMessage.getHas_more() == 1;
                            FrsADFragment.this.IB();
                            return;
                        }
                        FrsADFragment.this.btM();
                    }
                }

                @Override // com.baidu.tieba.frs.adModel.ADRequestModel.a
                public void a(ADSocketResponseMessage aDSocketResponseMessage) {
                    if (aDSocketResponseMessage != null && FrsADFragment.this.hEU != null) {
                        if (aDSocketResponseMessage.getError() == 0) {
                            FrsADFragment.this.offset = (int) aDSocketResponseMessage.getOffset();
                            FrsADFragment.this.hEY = aDSocketResponseMessage.getList();
                            FrsADFragment.this.mHasMore = aDSocketResponseMessage.getHas_more() == 1;
                            FrsADFragment.this.IB();
                            return;
                        }
                        FrsADFragment.this.btM();
                    }
                }
            };
        }
        this.hEW.a(this.hEV);
        if (!j.isNetWorkAvailable()) {
            btM();
        }
        return inflate;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void IB() {
        if (this.hEU != null) {
            hideLoadingView();
            this.hEU.caB();
            if (this.Xx == 0) {
                if (!w.isEmpty(this.hEY)) {
                    R(true, false);
                    this.hEU.buJ();
                    return;
                }
                btR();
            } else if (this.Xx == 2) {
                this.hEU.jc(false);
                if (!w.isEmpty(this.hEY)) {
                    R(true, false);
                    this.hEU.buJ();
                    return;
                }
                btR();
            } else if (this.Xx == 1) {
                if (!w.isEmpty(this.hEY)) {
                    R(false, true);
                } else {
                    this.hEU.buJ();
                }
            }
        }
    }

    private void R(boolean z, boolean z2) {
        if (this.gZU != null) {
            if (z) {
                this.gZU.clear();
            }
            if (z2) {
                for (int i = 0; i < this.gZU.size(); i++) {
                    q qVar = (q) w.getItem(this.gZU, i);
                    if (qVar instanceof c) {
                        ((c) qVar).ns(false);
                    }
                }
            }
            this.gZU.addAll(this.hEY);
            com.baidu.tbadk.a.a.c.a(com.baidu.tbadk.a.a.c.aOa(), this.gZU);
            this.hEU.caA().setData(this.gZU);
            this.hEU.caA().notifyDataSetChanged();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public TbPageTag getTbPageTag() {
        TbPageTag tbPageTag = super.getTbPageTag();
        tbPageTag.locatePage = PageStayDurationConstants.PageName.FRS;
        return tbPageTag;
    }

    @Override // com.baidu.tieba.frs.aq
    public void bXG() {
        if (this.hEU != null && this.hEU.getListView() != null) {
            this.hEU.getListView().scrollToPosition(0);
        }
    }

    @Override // com.baidu.tieba.frs.aq
    public void buH() {
        if (this.hEU != null) {
            bXG();
            this.hEU.startPullRefresh();
        }
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (this.hEU != null) {
            if (this.hEU != null && this.hEU.getListView() != null) {
                this.hEU.getListView().stopScroll();
            }
            btJ();
            if (l.isNetOk() && this.mHasMore) {
                uP(1);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.hEU != null) {
            this.hEU.onChangeSkinType(i);
        }
        if (this.hEZ != null && this.hEZ.isViewAttached()) {
            this.hEZ.onChangeSkinType();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uP(int i) {
        if (this.hEW != null) {
            btN();
            this.Xx = i;
            if (i == 0 || i == 2) {
                this.hEW.b(this.forumId, 0, 20);
            } else if (i == 1) {
                this.hEW.b(this.forumId, this.offset, 20);
            }
        }
    }

    public BdTypeRecyclerView getListView() {
        if (this.hEU == null) {
            return null;
        }
        return this.hEU.getListView();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLazyLoad() {
        super.onLazyLoad();
        if (j.isNetWorkAvailable()) {
            uP(0);
            showLoadingView();
            return;
        }
        btM();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLoad() {
        TiebaStatic.log(new ao("c13008").s("fid", this.forumId).ag("obj_type", 9).ag("obj_locate", 2).dk("uid", TbadkCoreApplication.getCurrentAccount()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showLoadingView() {
        this.hEU.nu(false);
        showLoadingView(this.hEU.bLS(), true, getResources().getDimensionPixelSize(R.dimen.ds250));
    }

    private void hideLoadingView() {
        this.hEU.nu(true);
        hideLoadingView(this.hEU.bLS());
    }

    private void btJ() {
        if (!this.mHasMore) {
            if (w.isEmpty(this.hEY)) {
                this.hEU.buK();
                return;
            } else {
                this.hEU.buJ();
                return;
            }
        }
        this.hEU.buI();
    }

    private void btR() {
        if (this.gZU != null && this.hEU != null) {
            this.gZU.add(new r());
            this.hEU.caA().setData(this.gZU);
            this.hEU.caA().notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btM() {
        this.hEU.nu(false);
        this.hEU.nt(false);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_EXPAND_BAR_HEADER, true));
        this.hEU.buK();
        this.hEU.getListView().getData().clear();
        this.hEU.bZj();
        if (this.hEZ == null) {
            this.hEZ = new com.baidu.tbadk.k.c(getPageContext().getContext(), getNetRefreshListener());
            this.hEZ.setTitle(null);
            this.hEZ.setSubText(null);
            this.hEZ.setButtonText(null);
            this.hEZ.showRefreshButton();
            this.hEZ.getAttachedView().setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        }
        this.hEZ.onChangeSkinType();
        this.hEZ.attachView(this.hEU.bLS(), true);
        MessageManager.getInstance().registerListener(this.hDd);
    }

    private void btN() {
        this.hEU.nu(true);
        this.hEU.nt(true);
        if (this.hEZ != null && this.hEZ.isViewAttached()) {
            this.hEZ.dettachView(this.hEU.bLS());
            MessageManager.getInstance().unRegisterListener(this.hDd);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void onNetRefreshButtonClicked() {
        if (j.isNetWorkAvailable()) {
            uP(0);
            showLoadingView();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.hDd);
        if (this.hEU != null) {
            this.hEU.onDestroy();
        }
        if (this.hEW != null) {
            this.hEW.onDestroy();
        }
        super.onDestroy();
    }

    @Override // com.baidu.tieba.frs.as
    public void aYg() {
        if (this.hEU != null) {
            if (j.isNetWorkAvailable()) {
                uP(2);
                if (w.isEmpty(this.gZU)) {
                    showLoadingView();
                    return;
                }
                return;
            }
            this.hEU.jc(false);
        }
    }

    @Override // com.baidu.tieba.frs.as
    public void aYh() {
    }
}
