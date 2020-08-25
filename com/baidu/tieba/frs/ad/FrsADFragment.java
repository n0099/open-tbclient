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
/* loaded from: classes16.dex */
public class FrsADFragment extends BaseFragment implements BdListView.e, as, au {
    private TbPageContext context;
    private long forumId;
    private String hSH;
    private ADRequestModel.a hYY;
    private ADRequestModel hYZ;
    private a hZa;
    private List<c> hZb;
    private com.baidu.tbadk.k.c hZc;
    private String mFrom;
    private boolean mHasMore;
    protected e hYX = null;
    private int offset = 0;
    public int XV = 0;
    private ArrayList<q> hss = new ArrayList<>();
    private int dhe = 0;
    private int hTN = 0;
    private CustomMessageListener hWr = new CustomMessageListener(2921397) { // from class: com.baidu.tieba.frs.ad.FrsADFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Integer num;
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Integer) && (num = (Integer) customResponsedMessage.getData()) != null && FrsADFragment.this.hZc != null && FrsADFragment.this.hZc.isViewAttached()) {
                FrsADFragment.this.hZc.qs(num.intValue());
            }
        }
    };
    private final RecyclerView.OnScrollListener mScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.frs.ad.FrsADFragment.3
        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            FrsADFragment.this.hTN += i2;
            if (FrsADFragment.this.hTN >= FrsADFragment.this.dhe * 2 && i2 < 0) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921437, true));
            }
        }
    };
    private CustomMessageListener hZd = new CustomMessageListener(CmdConfigCustom.CMD_FRS_TAB_SELECTED) { // from class: com.baidu.tieba.frs.ad.FrsADFragment.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                Object data = customResponsedMessage.getData();
                if ((data instanceof Integer) && Integer.parseInt(data.toString()) == 90) {
                    if (FrsADFragment.this.getListView() != null) {
                        FrsADFragment.this.getListView().setSelection(0);
                    }
                    if (FrsADFragment.this.hZc != null && FrsADFragment.this.hZc.isViewAttached()) {
                        FrsADFragment.this.xz(0);
                    } else if (FrsADFragment.this.hYX != null) {
                        FrsADFragment.this.hYX.startPullRefresh();
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_EXPAND_BAR_HEADER, true));
                    }
                }
            }
        }
    };
    private CustomMessageListener hUb = new CustomMessageListener(CmdConfigCustom.CMD_FRS_TAB_CLICK) { // from class: com.baidu.tieba.frs.ad.FrsADFragment.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                Object data = customResponsedMessage.getData();
                if ((data instanceof Integer) && Integer.parseInt(data.toString()) == 90) {
                    if (FrsADFragment.this.getListView() != null) {
                        FrsADFragment.this.getListView().setSelection(0);
                    }
                    if (FrsADFragment.this.hZc != null && FrsADFragment.this.hZc.isViewAttached()) {
                        FrsADFragment.this.xz(0);
                        FrsADFragment.this.showLoadingView();
                    } else if (FrsADFragment.this.hYX != null) {
                        FrsADFragment.this.hYX.startPullRefresh();
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_EXPAND_BAR_HEADER, true));
                    }
                }
            }
        }
    };
    private ab hUA = new ab() { // from class: com.baidu.tieba.frs.ad.FrsADFragment.6
        @Override // com.baidu.adp.widget.ListView.ab
        public void a(View view, q qVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            c cVar;
            if (qVar != null && (qVar instanceof c) && (cVar = (c) qVar) != null && cVar.bva() != null) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(new Pair("showad", "1"));
                be.bju().b(FrsADFragment.this.context, new String[]{com.baidu.tbadk.browser.a.appendParams(cVar.bva(), arrayList)});
                if (!at.isEmpty(cVar.cox())) {
                    TiebaStatic.log(new aq("c13194").dD("obj_type", cVar.cox()).u("fid", FrsADFragment.this.forumId));
                }
            }
        }
    };

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        cou();
    }

    private void cou() {
        if (isPrimary()) {
            if (this.hZc != null && this.hZc.isViewAttached()) {
                MessageManager.getInstance().registerListener(this.hWr);
                return;
            }
            return;
        }
        MessageManager.getInstance().unRegisterListener(this.hWr);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.context = getPageContext();
        initData(bundle);
        registerListener(this.hZd);
        registerListener(this.hUb);
        if (this.hYZ == null) {
            this.hYZ = new ADRequestModel(this.context);
        }
        this.dhe = UtilHelper.getScreenHeight(getActivity());
    }

    private void initData(Bundle bundle) {
        if (bundle != null) {
            this.hSH = bundle.getString("name");
            this.mFrom = bundle.getString("from");
            this.forumId = Long.parseLong(bundle.getString("forum_id"));
            return;
        }
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.hSH = arguments.getString("name");
            this.mFrom = arguments.getString("from");
            this.forumId = Long.parseLong(arguments.getString("forum_id"));
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.frs_ad_fragment, (ViewGroup) null);
        this.hYX = new e(this, inflate);
        this.hYX.setOnScrollListener(this.mScrollListener);
        this.hZa = new a(this, this.hYX.getListView());
        this.hZa.a(this.hUA);
        if (this.hYY == null) {
            this.hYY = new ADRequestModel.a() { // from class: com.baidu.tieba.frs.ad.FrsADFragment.2
                @Override // com.baidu.tieba.frs.adModel.ADRequestModel.a
                public void a(ADHttpResponseMessage aDHttpResponseMessage) {
                    if (aDHttpResponseMessage != null && FrsADFragment.this.hYX != null) {
                        if (aDHttpResponseMessage.getError() == 0) {
                            FrsADFragment.this.offset = (int) aDHttpResponseMessage.getOffset();
                            FrsADFragment.this.hZb = aDHttpResponseMessage.getList();
                            FrsADFragment.this.mHasMore = aDHttpResponseMessage.getHas_more() == 1;
                            FrsADFragment.this.OA();
                            return;
                        }
                        FrsADFragment.this.bFV();
                    }
                }

                @Override // com.baidu.tieba.frs.adModel.ADRequestModel.a
                public void a(ADSocketResponseMessage aDSocketResponseMessage) {
                    if (aDSocketResponseMessage != null && FrsADFragment.this.hYX != null) {
                        if (aDSocketResponseMessage.getError() == 0) {
                            FrsADFragment.this.offset = (int) aDSocketResponseMessage.getOffset();
                            FrsADFragment.this.hZb = aDSocketResponseMessage.getList();
                            FrsADFragment.this.mHasMore = aDSocketResponseMessage.getHas_more() == 1;
                            FrsADFragment.this.OA();
                            return;
                        }
                        FrsADFragment.this.bFV();
                    }
                }
            };
        }
        this.hYZ.a(this.hYY);
        if (!j.isNetWorkAvailable()) {
            bFV();
        }
        return inflate;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void OA() {
        if (this.hYX != null) {
            hideLoadingView();
            this.hYX.coE();
            if (this.XV == 0) {
                if (!y.isEmpty(this.hZb)) {
                    W(true, false);
                    this.hYX.bGS();
                    return;
                }
                bGa();
            } else if (this.XV == 2) {
                this.hYX.kf(false);
                if (!y.isEmpty(this.hZb)) {
                    W(true, false);
                    this.hYX.bGS();
                    return;
                }
                bGa();
            } else if (this.XV == 1) {
                if (!y.isEmpty(this.hZb)) {
                    W(false, true);
                } else {
                    this.hYX.bGS();
                }
            }
        }
    }

    private void W(boolean z, boolean z2) {
        if (this.hss != null) {
            if (z) {
                this.hss.clear();
            }
            if (z2) {
                for (int i = 0; i < this.hss.size(); i++) {
                    q qVar = (q) y.getItem(this.hss, i);
                    if (qVar instanceof c) {
                        ((c) qVar).oB(false);
                    }
                }
            }
            this.hss.addAll(this.hZb);
            com.baidu.tbadk.a.a.a.aG(this.hss);
            this.hYX.coD().setData(this.hss);
            this.hYX.coD().notifyDataSetChanged();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public TbPageTag getTbPageTag() {
        TbPageTag tbPageTag = super.getTbPageTag();
        tbPageTag.locatePage = PageStayDurationConstants.PageName.FRS;
        return tbPageTag;
    }

    @Override // com.baidu.tieba.frs.as
    public void clz() {
        if (this.hYX != null && this.hYX.getListView() != null) {
            this.hYX.getListView().scrollToPosition(0);
        }
    }

    @Override // com.baidu.tieba.frs.as
    public void bGQ() {
        if (this.hYX != null) {
            clz();
            this.hYX.startPullRefresh();
        }
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (this.hYX != null) {
            if (this.hYX != null && this.hYX.getListView() != null) {
                this.hYX.getListView().stopScroll();
            }
            bFS();
            if (l.isNetOk() && this.mHasMore) {
                xz(1);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.hYX != null) {
            this.hYX.onChangeSkinType(i);
        }
        if (this.hZc != null && this.hZc.isViewAttached()) {
            this.hZc.onChangeSkinType();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xz(int i) {
        if (this.hYZ != null) {
            bFW();
            this.XV = i;
            if (i == 0 || i == 2) {
                this.hYZ.c(this.forumId, 0, 20);
            } else if (i == 1) {
                this.hYZ.c(this.forumId, this.offset, 20);
            }
        }
    }

    public BdTypeRecyclerView getListView() {
        if (this.hYX == null) {
            return null;
        }
        return this.hYX.getListView();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLazyLoad() {
        super.onLazyLoad();
        if (j.isNetWorkAvailable()) {
            xz(0);
            showLoadingView();
            return;
        }
        bFV();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLoad() {
        TiebaStatic.log(new aq("c13008").u("fid", this.forumId).ai("obj_type", 9).ai("obj_locate", 2).dD("uid", TbadkCoreApplication.getCurrentAccount()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showLoadingView() {
        this.hYX.oD(false);
        showLoadingView(this.hYX.bZb(), true, getResources().getDimensionPixelSize(R.dimen.ds250));
    }

    private void hideLoadingView() {
        this.hYX.oD(true);
        hideLoadingView(this.hYX.bZb());
    }

    private void bFS() {
        if (!this.mHasMore) {
            if (y.isEmpty(this.hZb)) {
                this.hYX.bGT();
                return;
            } else {
                this.hYX.bGS();
                return;
            }
        }
        this.hYX.bGR();
    }

    private void bGa() {
        if (this.hss != null && this.hYX != null) {
            this.hss.add(new s());
            this.hYX.coD().setData(this.hss);
            this.hYX.coD().notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bFV() {
        this.hYX.oD(false);
        this.hYX.oC(false);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_EXPAND_BAR_HEADER, true));
        this.hYX.bGT();
        this.hYX.getListView().getData().clear();
        this.hYX.cne();
        if (this.hZc == null) {
            this.hZc = new com.baidu.tbadk.k.c(getPageContext().getContext(), getNetRefreshListener());
            this.hZc.setTitle(null);
            this.hZc.setSubText(null);
            this.hZc.setButtonText(null);
            this.hZc.showRefreshButton();
            this.hZc.getAttachedView().setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        }
        this.hZc.onChangeSkinType();
        this.hZc.attachView(this.hYX.bZb(), true);
        MessageManager.getInstance().registerListener(this.hWr);
    }

    private void bFW() {
        this.hYX.oD(true);
        this.hYX.oC(true);
        if (this.hZc != null && this.hZc.isViewAttached()) {
            this.hZc.dettachView(this.hYX.bZb());
            MessageManager.getInstance().unRegisterListener(this.hWr);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void onNetRefreshButtonClicked() {
        if (j.isNetWorkAvailable()) {
            xz(0);
            showLoadingView();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.hWr);
        if (this.hYX != null) {
            this.hYX.onDestroy();
        }
        if (this.hYZ != null) {
            this.hYZ.onDestroy();
        }
        super.onDestroy();
    }

    @Override // com.baidu.tieba.frs.au
    public void bkD() {
        if (this.hYX != null) {
            if (j.isNetWorkAvailable()) {
                xz(2);
                if (y.isEmpty(this.hss)) {
                    showLoadingView();
                    return;
                }
                return;
            }
            this.hYX.kf(false);
        }
    }

    @Override // com.baidu.tieba.frs.au
    public void bkE() {
    }
}
