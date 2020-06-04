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
import com.baidu.adp.widget.ListView.o;
import com.baidu.adp.widget.ListView.x;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationConstants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.pageInfo.TbPageTag;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.adModel.ADHttpResponseMessage;
import com.baidu.tieba.frs.adModel.ADRequestModel;
import com.baidu.tieba.frs.adModel.ADSocketResponseMessage;
import com.baidu.tieba.frs.al;
import com.baidu.tieba.frs.an;
import com.baidu.tieba.frs.p;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes9.dex */
public class FrsADFragment extends BaseFragment implements BdListView.e, al, an {
    private TbPageContext context;
    private long forumId;
    private String hnl;
    private ADRequestModel.a hsf;
    private ADRequestModel hsg;
    private a hsh;
    private List<c> hsi;
    private com.baidu.tbadk.k.c hsj;
    private String mFrom;
    private boolean mHasMore;
    protected e hse = null;
    private int offset = 0;
    public int WR = 0;
    private ArrayList<o> gMY = new ArrayList<>();
    private int cOy = 0;
    private int hoo = 0;
    private CustomMessageListener hqu = new CustomMessageListener(2921397) { // from class: com.baidu.tieba.frs.ad.FrsADFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Integer num;
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Integer) && (num = (Integer) customResponsedMessage.getData()) != null && FrsADFragment.this.hsj != null && FrsADFragment.this.hsj.isViewAttached()) {
                FrsADFragment.this.hsj.nu(num.intValue());
            }
        }
    };
    private final RecyclerView.OnScrollListener mScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.frs.ad.FrsADFragment.3
        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            FrsADFragment.this.hoo += i2;
            if (FrsADFragment.this.hoo >= FrsADFragment.this.cOy * 2 && i2 < 0) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921437, true));
            }
        }
    };
    private CustomMessageListener hsk = new CustomMessageListener(CmdConfigCustom.CMD_FRS_TAB_SELECTED) { // from class: com.baidu.tieba.frs.ad.FrsADFragment.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                Object data = customResponsedMessage.getData();
                if ((data instanceof Integer) && Integer.parseInt(data.toString()) == 90) {
                    if (FrsADFragment.this.getListView() != null) {
                        FrsADFragment.this.getListView().setSelection(0);
                    }
                    if (FrsADFragment.this.hsj != null && FrsADFragment.this.hsj.isViewAttached()) {
                        FrsADFragment.this.uk(0);
                    } else if (FrsADFragment.this.hse != null) {
                        FrsADFragment.this.hse.startPullRefresh();
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_EXPAND_BAR_HEADER, true));
                    }
                }
            }
        }
    };
    private CustomMessageListener hot = new CustomMessageListener(CmdConfigCustom.CMD_FRS_TAB_CLICK) { // from class: com.baidu.tieba.frs.ad.FrsADFragment.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                Object data = customResponsedMessage.getData();
                if ((data instanceof Integer) && Integer.parseInt(data.toString()) == 90) {
                    if (FrsADFragment.this.getListView() != null) {
                        FrsADFragment.this.getListView().setSelection(0);
                    }
                    if (FrsADFragment.this.hsj != null && FrsADFragment.this.hsj.isViewAttached()) {
                        FrsADFragment.this.uk(0);
                        FrsADFragment.this.showLoadingView();
                    } else if (FrsADFragment.this.hse != null) {
                        FrsADFragment.this.hse.startPullRefresh();
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_EXPAND_BAR_HEADER, true));
                    }
                }
            }
        }
    };
    private x hoP = new x() { // from class: com.baidu.tieba.frs.ad.FrsADFragment.6
        @Override // com.baidu.adp.widget.ListView.x
        public void a(View view, o oVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            c cVar;
            if (oVar != null && (oVar instanceof c) && (cVar = (c) oVar) != null && cVar.bgm() != null) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(new Pair("showad", "1"));
                ba.aVa().b(FrsADFragment.this.context, new String[]{com.baidu.tbadk.browser.a.appendParams(cVar.bgm(), arrayList)});
                if (!aq.isEmpty(cVar.bXj())) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.an("c13194").dh("obj_type", cVar.bXj()).s("fid", FrsADFragment.this.forumId));
                }
            }
        }
    };

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        bXg();
    }

    private void bXg() {
        if (isPrimary()) {
            if (this.hsj != null && this.hsj.isViewAttached()) {
                MessageManager.getInstance().registerListener(this.hqu);
                return;
            }
            return;
        }
        MessageManager.getInstance().unRegisterListener(this.hqu);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.context = getPageContext();
        initData(bundle);
        registerListener(this.hsk);
        registerListener(this.hot);
        if (this.hsg == null) {
            this.hsg = new ADRequestModel(this.context);
        }
        this.cOy = UtilHelper.getScreenHeight(getActivity());
    }

    private void initData(Bundle bundle) {
        if (bundle != null) {
            this.hnl = bundle.getString("name");
            this.mFrom = bundle.getString("from");
            this.forumId = Long.parseLong(bundle.getString("forum_id"));
            return;
        }
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.hnl = arguments.getString("name");
            this.mFrom = arguments.getString("from");
            this.forumId = Long.parseLong(arguments.getString("forum_id"));
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.frs_ad_fragment, (ViewGroup) null);
        this.hse = new e(this, inflate);
        this.hse.setOnScrollListener(this.mScrollListener);
        this.hsh = new a(this, this.hse.getListView());
        this.hsh.a(this.hoP);
        if (this.hsf == null) {
            this.hsf = new ADRequestModel.a() { // from class: com.baidu.tieba.frs.ad.FrsADFragment.2
                @Override // com.baidu.tieba.frs.adModel.ADRequestModel.a
                public void a(ADHttpResponseMessage aDHttpResponseMessage) {
                    if (aDHttpResponseMessage != null && FrsADFragment.this.hse != null) {
                        if (aDHttpResponseMessage.getError() == 0) {
                            FrsADFragment.this.offset = (int) aDHttpResponseMessage.getOffset();
                            FrsADFragment.this.hsi = aDHttpResponseMessage.getList();
                            FrsADFragment.this.mHasMore = aDHttpResponseMessage.getHas_more() == 1;
                            FrsADFragment.this.Ho();
                            return;
                        }
                        FrsADFragment.this.bqP();
                    }
                }

                @Override // com.baidu.tieba.frs.adModel.ADRequestModel.a
                public void a(ADSocketResponseMessage aDSocketResponseMessage) {
                    if (aDSocketResponseMessage != null && FrsADFragment.this.hse != null) {
                        if (aDSocketResponseMessage.getError() == 0) {
                            FrsADFragment.this.offset = (int) aDSocketResponseMessage.getOffset();
                            FrsADFragment.this.hsi = aDSocketResponseMessage.getList();
                            FrsADFragment.this.mHasMore = aDSocketResponseMessage.getHas_more() == 1;
                            FrsADFragment.this.Ho();
                            return;
                        }
                        FrsADFragment.this.bqP();
                    }
                }
            };
        }
        this.hsg.a(this.hsf);
        if (!j.isNetWorkAvailable()) {
            bqP();
        }
        return inflate;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ho() {
        if (this.hse != null) {
            hideLoadingView();
            this.hse.bXq();
            if (this.WR == 0) {
                if (!v.isEmpty(this.hsi)) {
                    R(true, false);
                    this.hse.brN();
                    return;
                }
                bqU();
            } else if (this.WR == 2) {
                this.hse.iQ(false);
                if (!v.isEmpty(this.hsi)) {
                    R(true, false);
                    this.hse.brN();
                    return;
                }
                bqU();
            } else if (this.WR == 1) {
                if (!v.isEmpty(this.hsi)) {
                    R(false, true);
                } else {
                    this.hse.brN();
                }
            }
        }
    }

    private void R(boolean z, boolean z2) {
        if (this.gMY != null) {
            if (z) {
                this.gMY.clear();
            }
            if (z2) {
                for (int i = 0; i < this.gMY.size(); i++) {
                    o oVar = (o) v.getItem(this.gMY, i);
                    if (oVar instanceof c) {
                        ((c) oVar).nh(false);
                    }
                }
            }
            this.gMY.addAll(this.hsi);
            com.baidu.tbadk.a.a.c.a(com.baidu.tbadk.a.a.c.aMx(), this.gMY);
            this.hse.bXp().setData(this.gMY);
            this.hse.bXp().notifyDataSetChanged();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public TbPageTag getTbPageTag() {
        TbPageTag tbPageTag = super.getTbPageTag();
        tbPageTag.locatePage = PageStayDurationConstants.PageName.FRS;
        return tbPageTag;
    }

    @Override // com.baidu.tieba.frs.al
    public void bUA() {
        if (this.hse != null && this.hse.getListView() != null) {
            this.hse.getListView().scrollToPosition(0);
        }
    }

    @Override // com.baidu.tieba.frs.al
    public void brL() {
        if (this.hse != null) {
            bUA();
            this.hse.startPullRefresh();
        }
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (this.hse != null) {
            if (this.hse != null && this.hse.getListView() != null) {
                this.hse.getListView().stopScroll();
            }
            bqM();
            if (l.isNetOk() && this.mHasMore) {
                uk(1);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.hse != null) {
            this.hse.onChangeSkinType(i);
        }
        if (this.hsj != null && this.hsj.isViewAttached()) {
            this.hsj.onChangeSkinType();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uk(int i) {
        if (this.hsg != null) {
            bqQ();
            this.WR = i;
            if (i == 0 || i == 2) {
                this.hsg.b(this.forumId, 0, 20);
            } else if (i == 1) {
                this.hsg.b(this.forumId, this.offset, 20);
            }
        }
    }

    public BdTypeRecyclerView getListView() {
        if (this.hse == null) {
            return null;
        }
        return this.hse.getListView();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLazyLoad() {
        super.onLazyLoad();
        if (j.isNetWorkAvailable()) {
            uk(0);
            showLoadingView();
            return;
        }
        bqP();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLoad() {
        TiebaStatic.log(new com.baidu.tbadk.core.util.an("c13008").s("fid", this.forumId).ag("obj_type", 9).ag("obj_locate", 2).dh("uid", TbadkCoreApplication.getCurrentAccount()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showLoadingView() {
        this.hse.nj(false);
        showLoadingView(this.hse.bIN(), true, getResources().getDimensionPixelSize(R.dimen.ds250));
    }

    private void hideLoadingView() {
        this.hse.nj(true);
        hideLoadingView(this.hse.bIN());
    }

    private void bqM() {
        if (!this.mHasMore) {
            if (v.isEmpty(this.hsi)) {
                this.hse.brO();
                return;
            } else {
                this.hse.brN();
                return;
            }
        }
        this.hse.brM();
    }

    private void bqU() {
        if (this.gMY != null && this.hse != null) {
            this.gMY.add(new p());
            this.hse.bXp().setData(this.gMY);
            this.hse.bXp().notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bqP() {
        this.hse.nj(false);
        this.hse.ni(false);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_EXPAND_BAR_HEADER, true));
        this.hse.brO();
        this.hse.getListView().getData().clear();
        this.hse.bWb();
        if (this.hsj == null) {
            this.hsj = new com.baidu.tbadk.k.c(getPageContext().getContext(), getNetRefreshListener());
            this.hsj.setTitle(null);
            this.hsj.setSubText(null);
            this.hsj.setButtonText(null);
            this.hsj.showRefreshButton();
            this.hsj.getAttachedView().setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        }
        this.hsj.onChangeSkinType();
        this.hsj.attachView(this.hse.bIN(), true);
        MessageManager.getInstance().registerListener(this.hqu);
    }

    private void bqQ() {
        this.hse.nj(true);
        this.hse.ni(true);
        if (this.hsj != null && this.hsj.isViewAttached()) {
            this.hsj.dettachView(this.hse.bIN());
            MessageManager.getInstance().unRegisterListener(this.hqu);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void onNetRefreshButtonClicked() {
        if (j.isNetWorkAvailable()) {
            uk(0);
            showLoadingView();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.hqu);
        if (this.hse != null) {
            this.hse.onDestroy();
        }
        if (this.hsg != null) {
            this.hsg.onDestroy();
        }
        super.onDestroy();
    }

    @Override // com.baidu.tieba.frs.an
    public void aWp() {
        if (this.hse != null) {
            if (j.isNetWorkAvailable()) {
                uk(2);
                if (v.isEmpty(this.gMY)) {
                    showLoadingView();
                    return;
                }
                return;
            }
            this.hse.iQ(false);
        }
    }

    @Override // com.baidu.tieba.frs.an
    public void aWq() {
    }
}
