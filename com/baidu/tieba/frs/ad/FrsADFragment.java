package com.baidu.tieba.frs.ad;

import android.os.Bundle;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.adp.widget.ListView.n;
import com.baidu.adp.widget.ListView.w;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationConstants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.util.bf;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.pageInfo.TbPageTag;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.adModel.ADHttpResponseMessage;
import com.baidu.tieba.frs.adModel.ADRequestModel;
import com.baidu.tieba.frs.adModel.ADSocketResponseMessage;
import com.baidu.tieba.frs.ao;
import com.baidu.tieba.frs.aq;
import com.baidu.tieba.frs.s;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class FrsADFragment extends BaseFragment implements BdListView.e, ao, aq {
    private TbPageContext context;
    private long forumId;
    private String jgn;
    private ADRequestModel.a jmG;
    private ADRequestModel jmH;
    private a jmI;
    private List<c> jmJ;
    private com.baidu.tbadk.l.c jmK;
    private String mFrom;
    private boolean mHasMore;
    protected e jmF = null;
    private int offset = 0;
    public int aam = 0;
    private ArrayList<n> iGj = new ArrayList<>();
    private int dVi = 0;
    private int jhs = 0;
    private CustomMessageListener jjZ = new CustomMessageListener(2921397) { // from class: com.baidu.tieba.frs.ad.FrsADFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Integer num;
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Integer) && (num = (Integer) customResponsedMessage.getData()) != null && FrsADFragment.this.jmK != null && FrsADFragment.this.jmK.isViewAttached()) {
                FrsADFragment.this.jmK.rm(num.intValue());
            }
        }
    };
    private final RecyclerView.OnScrollListener mScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.frs.ad.FrsADFragment.3
        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            FrsADFragment.this.jhs += i2;
            if (FrsADFragment.this.jhs >= FrsADFragment.this.dVi * 2 && i2 < 0) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921437, true));
            }
        }
    };
    private CustomMessageListener jmL = new CustomMessageListener(CmdConfigCustom.CMD_FRS_TAB_SELECTED) { // from class: com.baidu.tieba.frs.ad.FrsADFragment.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                Object data = customResponsedMessage.getData();
                if ((data instanceof Integer) && Integer.parseInt(data.toString()) == 90) {
                    if (FrsADFragment.this.getListView() != null) {
                        FrsADFragment.this.getListView().setSelection(0);
                    }
                    if (FrsADFragment.this.jmK != null && FrsADFragment.this.jmK.isViewAttached()) {
                        FrsADFragment.this.zd(0);
                    } else if (FrsADFragment.this.jmF != null) {
                        FrsADFragment.this.jmF.startPullRefresh();
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_EXPAND_BAR_HEADER, true));
                    }
                }
            }
        }
    };
    private CustomMessageListener jhH = new CustomMessageListener(CmdConfigCustom.CMD_FRS_TAB_CLICK) { // from class: com.baidu.tieba.frs.ad.FrsADFragment.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                Object data = customResponsedMessage.getData();
                if ((data instanceof Integer) && Integer.parseInt(data.toString()) == 90) {
                    if (FrsADFragment.this.getListView() != null) {
                        FrsADFragment.this.getListView().setSelection(0);
                    }
                    if (FrsADFragment.this.jmK != null && FrsADFragment.this.jmK.isViewAttached()) {
                        FrsADFragment.this.zd(0);
                        FrsADFragment.this.showLoadingView();
                    } else if (FrsADFragment.this.jmF != null) {
                        FrsADFragment.this.jmF.startPullRefresh();
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_EXPAND_BAR_HEADER, true));
                    }
                }
            }
        }
    };
    private w jii = new w() { // from class: com.baidu.tieba.frs.ad.FrsADFragment.6
        @Override // com.baidu.adp.widget.ListView.w
        public void a(View view, n nVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            c cVar;
            if (nVar != null && (nVar instanceof c) && (cVar = (c) nVar) != null && cVar.bEY() != null) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(new Pair("showad", "1"));
                bf.bsV().b(FrsADFragment.this.context, new String[]{com.baidu.tbadk.browser.a.appendParams(cVar.bEY(), arrayList)});
                if (!au.isEmpty(cVar.cFi())) {
                    TiebaStatic.log(new ar("c13194").dR("obj_type", cVar.cFi()).v("fid", FrsADFragment.this.forumId));
                }
            }
        }
    };

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        cFf();
    }

    private void cFf() {
        if (isPrimary()) {
            if (this.jmK != null && this.jmK.isViewAttached()) {
                MessageManager.getInstance().registerListener(this.jjZ);
                return;
            }
            return;
        }
        MessageManager.getInstance().unRegisterListener(this.jjZ);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.context = getPageContext();
        initData(bundle);
        registerListener(this.jmL);
        registerListener(this.jhH);
        if (this.jmH == null) {
            this.jmH = new ADRequestModel(this.context);
        }
        this.dVi = UtilHelper.getScreenHeight(getActivity());
    }

    private void initData(Bundle bundle) {
        if (bundle != null) {
            this.jgn = bundle.getString("name");
            this.mFrom = bundle.getString("from");
            this.forumId = Long.parseLong(bundle.getString("forum_id"));
            return;
        }
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.jgn = arguments.getString("name");
            this.mFrom = arguments.getString("from");
            this.forumId = Long.parseLong(arguments.getString("forum_id"));
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.frs_ad_fragment, (ViewGroup) null);
        this.jmF = new e(this, inflate);
        this.jmF.setOnScrollListener(this.mScrollListener);
        this.jmI = new a(this, this.jmF.getListView());
        this.jmI.a(this.jii);
        if (this.jmG == null) {
            this.jmG = new ADRequestModel.a() { // from class: com.baidu.tieba.frs.ad.FrsADFragment.2
                @Override // com.baidu.tieba.frs.adModel.ADRequestModel.a
                public void a(ADHttpResponseMessage aDHttpResponseMessage) {
                    if (aDHttpResponseMessage != null && FrsADFragment.this.jmF != null) {
                        if (aDHttpResponseMessage.getError() == 0) {
                            FrsADFragment.this.offset = (int) aDHttpResponseMessage.getOffset();
                            FrsADFragment.this.jmJ = aDHttpResponseMessage.getList();
                            FrsADFragment.this.mHasMore = aDHttpResponseMessage.getHas_more() == 1;
                            FrsADFragment.this.Ut();
                            return;
                        }
                        FrsADFragment.this.bRB();
                    }
                }

                @Override // com.baidu.tieba.frs.adModel.ADRequestModel.a
                public void a(ADSocketResponseMessage aDSocketResponseMessage) {
                    if (aDSocketResponseMessage != null && FrsADFragment.this.jmF != null) {
                        if (aDSocketResponseMessage.getError() == 0) {
                            FrsADFragment.this.offset = (int) aDSocketResponseMessage.getOffset();
                            FrsADFragment.this.jmJ = aDSocketResponseMessage.getList();
                            FrsADFragment.this.mHasMore = aDSocketResponseMessage.getHas_more() == 1;
                            FrsADFragment.this.Ut();
                            return;
                        }
                        FrsADFragment.this.bRB();
                    }
                }
            };
        }
        if (this.jmH == null) {
            this.jmH = new ADRequestModel(this.context);
        }
        this.jmH.a(this.jmG);
        if (!j.isNetWorkAvailable()) {
            bRB();
        }
        return inflate;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ut() {
        if (this.jmF != null) {
            hideLoadingView();
            this.jmF.cFp();
            if (this.aam == 0) {
                if (!y.isEmpty(this.jmJ)) {
                    ac(true, false);
                    this.jmF.WY();
                    return;
                }
                bRF();
            } else if (this.aam == 2) {
                this.jmF.lU(false);
                if (!y.isEmpty(this.jmJ)) {
                    ac(true, false);
                    this.jmF.WY();
                    return;
                }
                bRF();
            } else if (this.aam == 1) {
                if (!y.isEmpty(this.jmJ)) {
                    ac(false, true);
                } else {
                    this.jmF.WY();
                }
            }
        }
    }

    private void ac(boolean z, boolean z2) {
        if (this.iGj != null) {
            if (z) {
                this.iGj.clear();
            }
            if (z2) {
                for (int i = 0; i < this.iGj.size(); i++) {
                    n nVar = (n) y.getItem(this.iGj, i);
                    if (nVar instanceof c) {
                        ((c) nVar).qT(false);
                    }
                }
            }
            this.iGj.addAll(this.jmJ);
            com.baidu.tbadk.a.a.a.bj(this.iGj);
            this.jmF.cFo().setData(this.iGj);
            this.jmF.cFo().notifyDataSetChanged();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public TbPageTag getTbPageTag() {
        TbPageTag tbPageTag = super.getTbPageTag();
        tbPageTag.locatePage = PageStayDurationConstants.PageName.FRS;
        tbPageTag.tabId = 90;
        return tbPageTag;
    }

    @Override // com.baidu.tieba.frs.ao
    public void cCg() {
        if (this.jmF != null && this.jmF.getListView() != null) {
            this.jmF.getListView().scrollToPosition(0);
        }
    }

    @Override // com.baidu.tieba.frs.ao
    public void bSx() {
        if (this.jmF != null) {
            cCg();
            this.jmF.startPullRefresh();
        }
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (this.jmF != null) {
            if (this.jmF != null && this.jmF.getListView() != null) {
                this.jmF.getListView().stopScroll();
            }
            bRy();
            if (l.isNetOk() && this.mHasMore) {
                zd(1);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.jmF != null) {
            this.jmF.onChangeSkinType(i);
        }
        if (this.jmK != null && this.jmK.isViewAttached()) {
            this.jmK.onChangeSkinType();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zd(int i) {
        if (this.jmH != null) {
            WZ();
            this.aam = i;
            if (i == 0 || i == 2) {
                this.jmH.f(this.forumId, 0, 20);
            } else if (i == 1) {
                this.jmH.f(this.forumId, this.offset, 20);
            }
        }
    }

    public BdTypeRecyclerView getListView() {
        if (this.jmF == null) {
            return null;
        }
        return this.jmF.getListView();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLazyLoad() {
        super.onLazyLoad();
        if (j.isNetWorkAvailable()) {
            zd(0);
            showLoadingView();
            return;
        }
        bRB();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLoad() {
        TiebaStatic.log(new ar("c13008").v("fid", this.forumId).ap("obj_type", 9).ap("obj_locate", 2).dR("uid", TbadkCoreApplication.getCurrentAccount()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showLoadingView() {
        this.jmF.qV(false);
        showLoadingView(this.jmF.cnu(), true, getResources().getDimensionPixelSize(R.dimen.ds250));
    }

    private void hideLoadingView() {
        this.jmF.qV(true);
        hideLoadingView(this.jmF.cnu());
    }

    private void bRy() {
        if (!this.mHasMore) {
            if (y.isEmpty(this.jmJ)) {
                this.jmF.bSy();
                return;
            } else {
                this.jmF.WY();
                return;
            }
        }
        this.jmF.WX();
    }

    private void bRF() {
        if (this.iGj != null && this.jmF != null) {
            this.iGj.add(new s());
            this.jmF.cFo().setData(this.iGj);
            this.jmF.cFo().notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bRB() {
        this.jmF.qV(false);
        this.jmF.qU(false);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_EXPAND_BAR_HEADER, true));
        this.jmF.bSy();
        this.jmF.getListView().getData().clear();
        this.jmF.cDO();
        if (this.jmK == null) {
            this.jmK = new com.baidu.tbadk.l.c(getPageContext().getContext(), getNetRefreshListener());
            this.jmK.setTitle(null);
            this.jmK.setSubText(null);
            this.jmK.setButtonText(null);
            this.jmK.showRefreshButton();
            this.jmK.getAttachedView().setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        }
        this.jmK.onChangeSkinType();
        this.jmK.attachView(this.jmF.cnu(), true);
        MessageManager.getInstance().registerListener(this.jjZ);
    }

    private void WZ() {
        this.jmF.qV(true);
        this.jmF.qU(true);
        if (this.jmK != null && this.jmK.isViewAttached()) {
            this.jmK.dettachView(this.jmF.cnu());
            MessageManager.getInstance().unRegisterListener(this.jjZ);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void onNetRefreshButtonClicked() {
        if (j.isNetWorkAvailable()) {
            zd(0);
            showLoadingView();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.jjZ);
        if (this.jmF != null) {
            this.jmF.onDestroy();
        }
        if (this.jmH != null) {
            this.jmH.onDestroy();
        }
        super.onDestroy();
    }

    @Override // com.baidu.tieba.frs.aq
    public void bum() {
        if (this.jmF != null) {
            if (j.isNetWorkAvailable()) {
                zd(2);
                if (y.isEmpty(this.iGj)) {
                    showLoadingView();
                    return;
                }
                return;
            }
            this.jmF.lU(false);
        }
    }

    @Override // com.baidu.tieba.frs.aq
    public void bun() {
    }
}
