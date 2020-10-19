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
import com.baidu.adp.widget.ListView.ab;
import com.baidu.adp.widget.ListView.q;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationConstants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.be;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.pageInfo.TbPageTag;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.adModel.ADHttpResponseMessage;
import com.baidu.tieba.frs.adModel.ADRequestModel;
import com.baidu.tieba.frs.adModel.ADSocketResponseMessage;
import com.baidu.tieba.frs.as;
import com.baidu.tieba.frs.au;
import com.baidu.tieba.frs.s;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes22.dex */
public class FrsADFragment extends BaseFragment implements BdListView.e, as, au {
    private TbPageContext context;
    private long forumId;
    private String ioO;
    private ADRequestModel.a ivf;
    private ADRequestModel ivg;
    private a ivh;
    private List<c> ivi;
    private com.baidu.tbadk.k.c ivj;
    private String mFrom;
    private boolean mHasMore;
    protected e ive = null;
    private int offset = 0;
    public int YG = 0;
    private ArrayList<q> hOy = new ArrayList<>();
    private int dvr = 0;
    private int ipU = 0;
    private CustomMessageListener isy = new CustomMessageListener(2921397) { // from class: com.baidu.tieba.frs.ad.FrsADFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Integer num;
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Integer) && (num = (Integer) customResponsedMessage.getData()) != null && FrsADFragment.this.ivj != null && FrsADFragment.this.ivj.isViewAttached()) {
                FrsADFragment.this.ivj.rh(num.intValue());
            }
        }
    };
    private final RecyclerView.OnScrollListener mScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.frs.ad.FrsADFragment.3
        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            FrsADFragment.this.ipU += i2;
            if (FrsADFragment.this.ipU >= FrsADFragment.this.dvr * 2 && i2 < 0) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921437, true));
            }
        }
    };
    private CustomMessageListener ivk = new CustomMessageListener(CmdConfigCustom.CMD_FRS_TAB_SELECTED) { // from class: com.baidu.tieba.frs.ad.FrsADFragment.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                Object data = customResponsedMessage.getData();
                if ((data instanceof Integer) && Integer.parseInt(data.toString()) == 90) {
                    if (FrsADFragment.this.getListView() != null) {
                        FrsADFragment.this.getListView().setSelection(0);
                    }
                    if (FrsADFragment.this.ivj != null && FrsADFragment.this.ivj.isViewAttached()) {
                        FrsADFragment.this.yE(0);
                    } else if (FrsADFragment.this.ive != null) {
                        FrsADFragment.this.ive.startPullRefresh();
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_EXPAND_BAR_HEADER, true));
                    }
                }
            }
        }
    };
    private CustomMessageListener iqi = new CustomMessageListener(CmdConfigCustom.CMD_FRS_TAB_CLICK) { // from class: com.baidu.tieba.frs.ad.FrsADFragment.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                Object data = customResponsedMessage.getData();
                if ((data instanceof Integer) && Integer.parseInt(data.toString()) == 90) {
                    if (FrsADFragment.this.getListView() != null) {
                        FrsADFragment.this.getListView().setSelection(0);
                    }
                    if (FrsADFragment.this.ivj != null && FrsADFragment.this.ivj.isViewAttached()) {
                        FrsADFragment.this.yE(0);
                        FrsADFragment.this.showLoadingView();
                    } else if (FrsADFragment.this.ive != null) {
                        FrsADFragment.this.ive.startPullRefresh();
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_EXPAND_BAR_HEADER, true));
                    }
                }
            }
        }
    };
    private ab iqH = new ab() { // from class: com.baidu.tieba.frs.ad.FrsADFragment.6
        @Override // com.baidu.adp.widget.ListView.ab
        public void a(View view, q qVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            c cVar;
            if (qVar != null && (qVar instanceof c) && (cVar = (c) qVar) != null && cVar.byP() != null) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(new Pair("showad", "1"));
                be.bmY().b(FrsADFragment.this.context, new String[]{com.baidu.tbadk.browser.a.appendParams(cVar.byP(), arrayList)});
                if (!at.isEmpty(cVar.cvj())) {
                    TiebaStatic.log(new aq("c13194").dK("obj_type", cVar.cvj()).u("fid", FrsADFragment.this.forumId));
                }
            }
        }
    };

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        cvg();
    }

    private void cvg() {
        if (isPrimary()) {
            if (this.ivj != null && this.ivj.isViewAttached()) {
                MessageManager.getInstance().registerListener(this.isy);
                return;
            }
            return;
        }
        MessageManager.getInstance().unRegisterListener(this.isy);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.context = getPageContext();
        initData(bundle);
        registerListener(this.ivk);
        registerListener(this.iqi);
        if (this.ivg == null) {
            this.ivg = new ADRequestModel(this.context);
        }
        this.dvr = UtilHelper.getScreenHeight(getActivity());
    }

    private void initData(Bundle bundle) {
        if (bundle != null) {
            this.ioO = bundle.getString("name");
            this.mFrom = bundle.getString("from");
            this.forumId = Long.parseLong(bundle.getString("forum_id"));
            return;
        }
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.ioO = arguments.getString("name");
            this.mFrom = arguments.getString("from");
            this.forumId = Long.parseLong(arguments.getString("forum_id"));
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.frs_ad_fragment, (ViewGroup) null);
        this.ive = new e(this, inflate);
        this.ive.setOnScrollListener(this.mScrollListener);
        this.ivh = new a(this, this.ive.getListView());
        this.ivh.a(this.iqH);
        if (this.ivf == null) {
            this.ivf = new ADRequestModel.a() { // from class: com.baidu.tieba.frs.ad.FrsADFragment.2
                @Override // com.baidu.tieba.frs.adModel.ADRequestModel.a
                public void a(ADHttpResponseMessage aDHttpResponseMessage) {
                    if (aDHttpResponseMessage != null && FrsADFragment.this.ive != null) {
                        if (aDHttpResponseMessage.getError() == 0) {
                            FrsADFragment.this.offset = (int) aDHttpResponseMessage.getOffset();
                            FrsADFragment.this.ivi = aDHttpResponseMessage.getList();
                            FrsADFragment.this.mHasMore = aDHttpResponseMessage.getHas_more() == 1;
                            FrsADFragment.this.Qi();
                            return;
                        }
                        FrsADFragment.this.bJY();
                    }
                }

                @Override // com.baidu.tieba.frs.adModel.ADRequestModel.a
                public void a(ADSocketResponseMessage aDSocketResponseMessage) {
                    if (aDSocketResponseMessage != null && FrsADFragment.this.ive != null) {
                        if (aDSocketResponseMessage.getError() == 0) {
                            FrsADFragment.this.offset = (int) aDSocketResponseMessage.getOffset();
                            FrsADFragment.this.ivi = aDSocketResponseMessage.getList();
                            FrsADFragment.this.mHasMore = aDSocketResponseMessage.getHas_more() == 1;
                            FrsADFragment.this.Qi();
                            return;
                        }
                        FrsADFragment.this.bJY();
                    }
                }
            };
        }
        this.ivg.a(this.ivf);
        if (!j.isNetWorkAvailable()) {
            bJY();
        }
        return inflate;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Qi() {
        if (this.ive != null) {
            hideLoadingView();
            this.ive.cvq();
            if (this.YG == 0) {
                if (!y.isEmpty(this.ivi)) {
                    X(true, false);
                    this.ive.SJ();
                    return;
                }
                bKc();
            } else if (this.YG == 2) {
                this.ive.kG(false);
                if (!y.isEmpty(this.ivi)) {
                    X(true, false);
                    this.ive.SJ();
                    return;
                }
                bKc();
            } else if (this.YG == 1) {
                if (!y.isEmpty(this.ivi)) {
                    X(false, true);
                } else {
                    this.ive.SJ();
                }
            }
        }
    }

    private void X(boolean z, boolean z2) {
        if (this.hOy != null) {
            if (z) {
                this.hOy.clear();
            }
            if (z2) {
                for (int i = 0; i < this.hOy.size(); i++) {
                    q qVar = (q) y.getItem(this.hOy, i);
                    if (qVar instanceof c) {
                        ((c) qVar).po(false);
                    }
                }
            }
            this.hOy.addAll(this.ivi);
            com.baidu.tbadk.a.a.a.aN(this.hOy);
            this.ive.cvp().setData(this.hOy);
            this.ive.cvp().notifyDataSetChanged();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public TbPageTag getTbPageTag() {
        TbPageTag tbPageTag = super.getTbPageTag();
        tbPageTag.locatePage = PageStayDurationConstants.PageName.FRS;
        tbPageTag.tabId = 90;
        return tbPageTag;
    }

    @Override // com.baidu.tieba.frs.as
    public void csk() {
        if (this.ive != null && this.ive.getListView() != null) {
            this.ive.getListView().scrollToPosition(0);
        }
    }

    @Override // com.baidu.tieba.frs.as
    public void bKT() {
        if (this.ive != null) {
            csk();
            this.ive.startPullRefresh();
        }
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (this.ive != null) {
            if (this.ive != null && this.ive.getListView() != null) {
                this.ive.getListView().stopScroll();
            }
            bJV();
            if (l.isNetOk() && this.mHasMore) {
                yE(1);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.ive != null) {
            this.ive.onChangeSkinType(i);
        }
        if (this.ivj != null && this.ivj.isViewAttached()) {
            this.ivj.onChangeSkinType();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void yE(int i) {
        if (this.ivg != null) {
            SK();
            this.YG = i;
            if (i == 0 || i == 2) {
                this.ivg.c(this.forumId, 0, 20);
            } else if (i == 1) {
                this.ivg.c(this.forumId, this.offset, 20);
            }
        }
    }

    public BdTypeRecyclerView getListView() {
        if (this.ive == null) {
            return null;
        }
        return this.ive.getListView();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLazyLoad() {
        super.onLazyLoad();
        if (j.isNetWorkAvailable()) {
            yE(0);
            showLoadingView();
            return;
        }
        bJY();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLoad() {
        TiebaStatic.log(new aq("c13008").u("fid", this.forumId).aj("obj_type", 9).aj("obj_locate", 2).dK("uid", TbadkCoreApplication.getCurrentAccount()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showLoadingView() {
        this.ive.pq(false);
        showLoadingView(this.ive.cew(), true, getResources().getDimensionPixelSize(R.dimen.ds250));
    }

    private void hideLoadingView() {
        this.ive.pq(true);
        hideLoadingView(this.ive.cew());
    }

    private void bJV() {
        if (!this.mHasMore) {
            if (y.isEmpty(this.ivi)) {
                this.ive.bKU();
                return;
            } else {
                this.ive.SJ();
                return;
            }
        }
        this.ive.SI();
    }

    private void bKc() {
        if (this.hOy != null && this.ive != null) {
            this.hOy.add(new s());
            this.ive.cvp().setData(this.hOy);
            this.ive.cvp().notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bJY() {
        this.ive.pq(false);
        this.ive.pp(false);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_EXPAND_BAR_HEADER, true));
        this.ive.bKU();
        this.ive.getListView().getData().clear();
        this.ive.ctP();
        if (this.ivj == null) {
            this.ivj = new com.baidu.tbadk.k.c(getPageContext().getContext(), getNetRefreshListener());
            this.ivj.setTitle(null);
            this.ivj.setSubText(null);
            this.ivj.setButtonText(null);
            this.ivj.showRefreshButton();
            this.ivj.getAttachedView().setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        }
        this.ivj.onChangeSkinType();
        this.ivj.attachView(this.ive.cew(), true);
        MessageManager.getInstance().registerListener(this.isy);
    }

    private void SK() {
        this.ive.pq(true);
        this.ive.pp(true);
        if (this.ivj != null && this.ivj.isViewAttached()) {
            this.ivj.dettachView(this.ive.cew());
            MessageManager.getInstance().unRegisterListener(this.isy);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void onNetRefreshButtonClicked() {
        if (j.isNetWorkAvailable()) {
            yE(0);
            showLoadingView();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.isy);
        if (this.ive != null) {
            this.ive.onDestroy();
        }
        if (this.ivg != null) {
            this.ivg.onDestroy();
        }
        super.onDestroy();
    }

    @Override // com.baidu.tieba.frs.au
    public void boi() {
        if (this.ive != null) {
            if (j.isNetWorkAvailable()) {
                yE(2);
                if (y.isEmpty(this.hOy)) {
                    showLoadingView();
                    return;
                }
                return;
            }
            this.ive.kG(false);
        }
    }

    @Override // com.baidu.tieba.frs.au
    public void boj() {
    }
}
