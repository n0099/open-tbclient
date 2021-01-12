package com.baidu.tieba.frs.commontab;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.adp.widget.ListView.n;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.data.bz;
import com.baidu.tieba.card.x;
import com.baidu.tieba.frs.AbsDelegateAdapterList;
import com.baidu.tieba.frs.entelechy.adapter.ah;
import com.baidu.tieba.frs.entelechy.adapter.aj;
import com.baidu.tieba.frs.entelechy.adapter.ak;
import com.baidu.tieba.frs.entelechy.adapter.f;
import com.baidu.tieba.frs.entelechy.adapter.g;
import com.baidu.tieba.frs.entelechy.adapter.k;
import com.baidu.tieba.frs.entelechy.adapter.l;
import com.baidu.tieba.frs.r;
import com.baidu.tieba.frs.s;
import com.baidu.tieba.tbadkCore.FrsViewData;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import tbclient.Item;
/* loaded from: classes2.dex */
public class a {
    private BdTypeRecyclerView Ya;
    private boolean isDynamic;
    private r jgE;
    private FrsCommonTabFragment jjj;
    private k jjk;
    private k jjl;
    private ah jjm;
    private aj jjn;
    private aj jjo;
    private f jjp;
    private com.baidu.tieba.frs.entelechy.adapter.c jjq;
    private l jjr;
    private ak jjs;
    private g jjt;
    private List<com.baidu.adp.widget.ListView.a> bjZ = new LinkedList();
    private CustomMessageListener jju = new CustomMessageListener(CmdConfigCustom.CMD_FRS_ADD_ADAPTER) { // from class: com.baidu.tieba.frs.commontab.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2003008 && (customResponsedMessage.getData() instanceof AbsDelegateAdapterList)) {
                Iterator it = ((AbsDelegateAdapterList) customResponsedMessage.getData()).iterator();
                while (it.hasNext()) {
                    com.baidu.adp.widget.ListView.a aVar = (com.baidu.adp.widget.ListView.a) it.next();
                    if ((aVar instanceof x) && "FrsHottopicDelegateAdapter".equals(((x) aVar).acB()) && a.this.bjZ != null) {
                        ((x) aVar).a(a.this.jjj.getPageContext(), a.this.jjj.getUniqueId());
                        if (a.this.isDynamic) {
                            ((x) aVar).setFrom("c13010");
                        }
                        a.this.bjZ.add(aVar);
                    }
                }
            }
        }
    };

    public a(FrsCommonTabFragment frsCommonTabFragment, BdTypeRecyclerView bdTypeRecyclerView, FrsViewData frsViewData, boolean z) {
        a(frsCommonTabFragment, bdTypeRecyclerView, frsViewData, z);
        this.Ya = bdTypeRecyclerView;
    }

    public void a(FrsCommonTabFragment frsCommonTabFragment, BdTypeRecyclerView bdTypeRecyclerView, FrsViewData frsViewData, boolean z) {
        this.jjj = frsCommonTabFragment;
        this.jju.setPriority(1);
        this.jju.setSelfListener(true);
        this.jjj.registerListener(this.jju);
        this.jjk = new k(frsCommonTabFragment.getPageContext(), bz.eOa, this.jjj.getUniqueId());
        this.jjl = new k(frsCommonTabFragment.getPageContext(), bz.eOx, this.jjj.getUniqueId());
        this.jjm = new ah(frsCommonTabFragment.getPageContext(), bz.eOD, this.jjj.getUniqueId());
        this.jjn = new aj(frsCommonTabFragment.getPageContext(), bz.eOy, this.jjj.getUniqueId());
        this.jjn.jjA = this.jjj.jjA;
        this.jjo = new aj(frsCommonTabFragment.getPageContext(), bz.eOH, this.jjj.getUniqueId());
        this.jjo.jjA = this.jjj.jjA;
        this.jjp = new f(frsCommonTabFragment.getPageContext(), bz.eOR, this.jjj.getUniqueId());
        this.jgE = new r(frsCommonTabFragment.getPageContext(), s.jdY);
        com.baidu.tieba.frs.entelechy.adapter.a aVar = new com.baidu.tieba.frs.entelechy.adapter.a(frsCommonTabFragment.getPageContext(), bz.eOp, frsCommonTabFragment.getUniqueId());
        this.jjq = new com.baidu.tieba.frs.entelechy.adapter.c(frsCommonTabFragment.getPageContext(), bz.eOF, this.jjj.getUniqueId());
        this.jjr = new l(frsCommonTabFragment.getPageContext(), bz.eOE, this.jjj.getUniqueId());
        this.jjs = new ak(frsCommonTabFragment.getPageContext(), bz.eOG, this.jjj.getUniqueId());
        if (!z) {
            this.jjt = new g(frsCommonTabFragment.getPageContext(), bz.eOr, this.jjj.getUniqueId());
            this.jjt.a(this.Ya);
        }
        cEn();
        this.bjZ.add(this.jjk);
        this.bjZ.add(this.jjl);
        this.bjZ.add(this.jjm);
        this.bjZ.add(this.jjn);
        this.bjZ.add(this.jjo);
        this.bjZ.add(this.jjp);
        this.bjZ.add(this.jgE);
        this.bjZ.add(aVar);
        this.bjZ.add(this.jjq);
        this.bjZ.add(this.jjr);
        this.bjZ.add(this.jjs);
        this.bjZ.add(this.jjt);
        if (frsCommonTabFragment.tabId == 89) {
            this.isDynamic = true;
            this.jjk.setFrom("c13010");
            this.jjl.setFrom("c13010");
            this.jjm.setFrom("c13010");
            this.jjn.setFrom("c13010");
            this.jjo.setFrom("c13010");
            Ea("page_frs_dynamic");
        }
        this.jjk.uN(frsCommonTabFragment.tabId);
        this.jjl.uN(frsCommonTabFragment.tabId);
        this.jjm.uN(frsCommonTabFragment.tabId);
        this.jjn.uN(frsCommonTabFragment.tabId);
        this.jjo.uN(frsCommonTabFragment.tabId);
        this.jjp.uN(frsCommonTabFragment.tabId);
        this.jjq.uN(frsCommonTabFragment.tabId);
        this.jjr.uN(frsCommonTabFragment.tabId);
        this.jjs.uN(frsCommonTabFragment.tabId);
        this.jjk.zd(frsCommonTabFragment.tabType);
        this.jjl.zd(frsCommonTabFragment.tabType);
        boolean z2 = frsCommonTabFragment.tabType == 16;
        this.jjk.qU(z2);
        this.jjn.qU(z2);
        this.jjp.qU(z2);
        this.jjm.qU(z2);
        this.jjr.qU(z2);
        this.jjs.qU(z2);
        AbsDelegateAdapterList absDelegateAdapterList = new AbsDelegateAdapterList();
        CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2003022, absDelegateAdapterList);
        CustomMessage customMessage = new CustomMessage(2003022);
        customMessage.setTag(this.jjj.getUniqueId());
        customResponsedMessage.setOrginalMessage(customMessage);
        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
        if (!absDelegateAdapterList.isEmpty()) {
            Iterator it = absDelegateAdapterList.iterator();
            while (it.hasNext()) {
                com.baidu.adp.widget.ListView.a aVar2 = (com.baidu.adp.widget.ListView.a) it.next();
                if (aVar2 instanceof com.baidu.tieba.frs.k) {
                    ((com.baidu.tieba.frs.k) aVar2).a(this.jjj.getPageContext(), this.jjj.getUniqueId());
                }
            }
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(absDelegateAdapterList);
            if (this.bjZ != null) {
                this.bjZ.addAll(arrayList);
            }
        }
        if (frsCommonTabFragment.tabId == 502 || frsCommonTabFragment.isGeneralTab == 1) {
            b(frsViewData);
        }
        cDL();
        bdTypeRecyclerView.addAdapters(this.bjZ);
        cEo();
    }

    private void cEn() {
        com.baidu.adp.widget.ListView.a<?, ?> a2 = com.baidu.tieba.recapp.r.dBe().a(this.jjj, AdvertAppInfo.eIO);
        com.baidu.adp.widget.ListView.a<?, ?> a3 = com.baidu.tieba.recapp.r.dBe().a(this.jjj, AdvertAppInfo.eIX);
        com.baidu.adp.widget.ListView.a<?, ?> a4 = com.baidu.tieba.recapp.r.dBe().a(this.jjj, AdvertAppInfo.eJb);
        com.baidu.adp.widget.ListView.a<?, ?> a5 = com.baidu.tieba.recapp.r.dBe().a(this.jjj, AdvertAppInfo.eJc);
        com.baidu.adp.widget.ListView.a<?, ?> a6 = com.baidu.tieba.recapp.r.dBe().a(this.jjj, AdvertAppInfo.eJd);
        this.bjZ.add(a2);
        this.bjZ.add(a3);
        this.bjZ.add(a4);
        this.bjZ.add(a5);
        this.bjZ.add(a6);
        com.baidu.adp.widget.ListView.a<?, ?> b2 = com.baidu.tieba.h.b.cLy().b(this.jjj.getBaseFragmentActivity(), AdvertAppInfo.eJa);
        com.baidu.adp.widget.ListView.a<?, ?> b3 = com.baidu.tieba.h.b.cLy().b(this.jjj.getBaseFragmentActivity(), AdvertAppInfo.eIZ);
        this.bjZ.add(b2);
        this.bjZ.add(b3);
    }

    public void setData(ArrayList<n> arrayList) {
        cDL();
        this.Ya.setData(av(arrayList));
    }

    private ArrayList<n> av(ArrayList<n> arrayList) {
        ArrayList<n> arrayList2 = new ArrayList<>();
        Iterator<n> it = arrayList.iterator();
        while (it.hasNext()) {
            n next = it.next();
            if (next instanceof bz) {
                if (((bz) next).bpE() != null) {
                    if (!((bz) next).boA()) {
                        arrayList2.add(next);
                    } else {
                        ((bz) next).a((Item) null);
                        arrayList2.add(next);
                    }
                } else {
                    arrayList2.add(next);
                }
            } else {
                arrayList2.add(next);
            }
        }
        return arrayList2;
    }

    private void cDL() {
        if (!com.baidu.tbadk.core.util.x.isEmpty(this.bjZ) && this.jjj != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.bjZ) {
                if (aVar instanceof com.baidu.tieba.frs.k) {
                    ((com.baidu.tieba.frs.k) aVar).a(this.jjj.getTbPageTag());
                }
            }
        }
    }

    private void cEo() {
        if (this.jjj != null && !com.baidu.tbadk.core.util.x.isEmpty(this.bjZ)) {
            for (com.baidu.adp.widget.ListView.a aVar : this.bjZ) {
                if (aVar instanceof com.baidu.tieba.frs.b.d) {
                    com.baidu.tieba.frs.b.d dVar = (com.baidu.tieba.frs.b.d) aVar;
                    if (dVar.getStatisticMetaData() != null) {
                        dVar.getStatisticMetaData().jBG = this.jjj.jjz;
                        dVar.getStatisticMetaData().jBI = this.jjj.forumId;
                        dVar.getStatisticMetaData().jBJ = this.jjj.tabId;
                        dVar.getStatisticMetaData().jBM = this.jjj.tabType;
                        if (this.jjj.tabId == 502) {
                            dVar.getStatisticMetaData().jBL = 10;
                        } else if (this.jjj.isGeneralTab == 1) {
                            dVar.getStatisticMetaData().jBL = 12;
                        }
                    }
                }
            }
        }
    }

    public void notifyDataSetChanged() {
        this.Ya.getAdapter().notifyDataSetChanged();
    }

    public void onDestory() {
        for (com.baidu.adp.widget.ListView.a aVar : this.bjZ) {
            if (aVar instanceof com.baidu.tieba.frs.k) {
                ((com.baidu.tieba.frs.k) aVar).release();
            }
        }
    }

    private void Ea(String str) {
        if (this.bjZ != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.bjZ) {
                if (aVar instanceof com.baidu.tieba.a.f) {
                    ((com.baidu.tieba.a.f) aVar).Ea(str);
                }
            }
        }
    }

    private void b(FrsViewData frsViewData) {
        if (this.bjZ != null && this.bjZ.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.bjZ) {
                if (aVar instanceof com.baidu.tieba.frs.k) {
                    ((com.baidu.tieba.frs.k) aVar).b(frsViewData);
                }
            }
        }
    }

    public void qR(boolean z) {
        if (this.jjk != null) {
            this.jjk.qT(z);
        }
        if (this.jjl != null) {
            this.jjl.qT(z);
        }
        if (this.jjn != null) {
            this.jjn.qT(z);
        }
        if (this.jjo != null) {
            this.jjo.qT(z);
        }
        if (this.jjp != null) {
            this.jjp.qT(z);
        }
    }
}
