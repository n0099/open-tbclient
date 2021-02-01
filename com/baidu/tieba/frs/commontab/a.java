package com.baidu.tieba.frs.commontab;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.adp.widget.ListView.n;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.data.cb;
import com.baidu.tieba.card.y;
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
    private BdTypeRecyclerView XW;
    private boolean isDynamic;
    private r jml;
    private FrsCommonTabFragment joQ;
    private k joR;
    private k joS;
    private ah joT;
    private aj joU;
    private aj joV;
    private f joW;
    private com.baidu.tieba.frs.entelechy.adapter.c joX;
    private l joY;
    private ak joZ;
    private g jpa;
    private List<com.baidu.adp.widget.ListView.a> bns = new LinkedList();
    private CustomMessageListener jpb = new CustomMessageListener(CmdConfigCustom.CMD_FRS_ADD_ADAPTER) { // from class: com.baidu.tieba.frs.commontab.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2003008 && (customResponsedMessage.getData() instanceof AbsDelegateAdapterList)) {
                Iterator it = ((AbsDelegateAdapterList) customResponsedMessage.getData()).iterator();
                while (it.hasNext()) {
                    com.baidu.adp.widget.ListView.a aVar = (com.baidu.adp.widget.ListView.a) it.next();
                    if ((aVar instanceof y) && "FrsHottopicDelegateAdapter".equals(((y) aVar).csw()) && a.this.bns != null) {
                        ((y) aVar).a(a.this.joQ.getPageContext(), a.this.joQ.getUniqueId());
                        if (a.this.isDynamic) {
                            ((y) aVar).setFrom("c13010");
                        }
                        a.this.bns.add(aVar);
                    }
                }
            }
        }
    };

    public a(FrsCommonTabFragment frsCommonTabFragment, BdTypeRecyclerView bdTypeRecyclerView, FrsViewData frsViewData, boolean z) {
        a(frsCommonTabFragment, bdTypeRecyclerView, frsViewData, z);
        this.XW = bdTypeRecyclerView;
    }

    public void a(FrsCommonTabFragment frsCommonTabFragment, BdTypeRecyclerView bdTypeRecyclerView, FrsViewData frsViewData, boolean z) {
        this.joQ = frsCommonTabFragment;
        this.jpb.setPriority(1);
        this.jpb.setSelfListener(true);
        this.joQ.registerListener(this.jpb);
        this.joR = new k(frsCommonTabFragment.getPageContext(), cb.eQm, this.joQ.getUniqueId());
        this.joS = new k(frsCommonTabFragment.getPageContext(), cb.eQJ, this.joQ.getUniqueId());
        this.joT = new ah(frsCommonTabFragment.getPageContext(), cb.eQP, this.joQ.getUniqueId());
        this.joU = new aj(frsCommonTabFragment.getPageContext(), cb.eQK, this.joQ.getUniqueId());
        this.joU.jph = this.joQ.jph;
        this.joV = new aj(frsCommonTabFragment.getPageContext(), cb.eQT, this.joQ.getUniqueId());
        this.joV.jph = this.joQ.jph;
        this.joW = new f(frsCommonTabFragment.getPageContext(), cb.eRd, this.joQ.getUniqueId());
        this.jml = new r(frsCommonTabFragment.getPageContext(), s.jjF);
        com.baidu.tieba.frs.entelechy.adapter.a aVar = new com.baidu.tieba.frs.entelechy.adapter.a(frsCommonTabFragment.getPageContext(), cb.eQB, frsCommonTabFragment.getUniqueId());
        this.joX = new com.baidu.tieba.frs.entelechy.adapter.c(frsCommonTabFragment.getPageContext(), cb.eQR, this.joQ.getUniqueId());
        this.joY = new l(frsCommonTabFragment.getPageContext(), cb.eQQ, this.joQ.getUniqueId());
        this.joZ = new ak(frsCommonTabFragment.getPageContext(), cb.eQS, this.joQ.getUniqueId());
        if (!z) {
            this.jpa = new g(frsCommonTabFragment.getPageContext(), cb.eQD, this.joQ.getUniqueId());
            this.jpa.a(this.XW);
        }
        cFA();
        this.bns.add(this.joR);
        this.bns.add(this.joS);
        this.bns.add(this.joT);
        this.bns.add(this.joU);
        this.bns.add(this.joV);
        this.bns.add(this.joW);
        this.bns.add(this.jml);
        this.bns.add(aVar);
        this.bns.add(this.joX);
        this.bns.add(this.joY);
        this.bns.add(this.joZ);
        this.bns.add(this.jpa);
        if (frsCommonTabFragment.tabId == 89) {
            this.isDynamic = true;
            this.joR.setFrom("c13010");
            this.joS.setFrom("c13010");
            this.joT.setFrom("c13010");
            this.joU.setFrom("c13010");
            this.joV.setFrom("c13010");
            Ey("page_frs_dynamic");
        }
        this.joR.uX(frsCommonTabFragment.tabId);
        this.joS.uX(frsCommonTabFragment.tabId);
        this.joT.uX(frsCommonTabFragment.tabId);
        this.joU.uX(frsCommonTabFragment.tabId);
        this.joV.uX(frsCommonTabFragment.tabId);
        this.joW.uX(frsCommonTabFragment.tabId);
        this.joX.uX(frsCommonTabFragment.tabId);
        this.joY.uX(frsCommonTabFragment.tabId);
        this.joZ.uX(frsCommonTabFragment.tabId);
        this.joR.zn(frsCommonTabFragment.tabType);
        this.joS.zn(frsCommonTabFragment.tabType);
        boolean z2 = frsCommonTabFragment.tabType == 16;
        this.joR.re(z2);
        this.joU.re(z2);
        this.joW.re(z2);
        this.joT.re(z2);
        this.joY.re(z2);
        this.joZ.re(z2);
        AbsDelegateAdapterList absDelegateAdapterList = new AbsDelegateAdapterList();
        CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2003022, absDelegateAdapterList);
        CustomMessage customMessage = new CustomMessage(2003022);
        customMessage.setTag(this.joQ.getUniqueId());
        customResponsedMessage.setOrginalMessage(customMessage);
        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
        if (!absDelegateAdapterList.isEmpty()) {
            Iterator it = absDelegateAdapterList.iterator();
            while (it.hasNext()) {
                com.baidu.adp.widget.ListView.a aVar2 = (com.baidu.adp.widget.ListView.a) it.next();
                if (aVar2 instanceof com.baidu.tieba.frs.k) {
                    ((com.baidu.tieba.frs.k) aVar2).a(this.joQ.getPageContext(), this.joQ.getUniqueId());
                }
            }
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(absDelegateAdapterList);
            if (this.bns != null) {
                this.bns.addAll(arrayList);
            }
        }
        if (frsCommonTabFragment.tabId == 502 || frsCommonTabFragment.isGeneralTab == 1) {
            b(frsViewData);
        }
        cEX();
        bdTypeRecyclerView.addAdapters(this.bns);
        cFB();
    }

    private void cFA() {
        com.baidu.adp.widget.ListView.a<?, ?> a2 = com.baidu.tieba.recapp.r.dDm().a(this.joQ, AdvertAppInfo.eLa);
        com.baidu.adp.widget.ListView.a<?, ?> a3 = com.baidu.tieba.recapp.r.dDm().a(this.joQ, AdvertAppInfo.eLj);
        com.baidu.adp.widget.ListView.a<?, ?> a4 = com.baidu.tieba.recapp.r.dDm().a(this.joQ, AdvertAppInfo.eLn);
        com.baidu.adp.widget.ListView.a<?, ?> a5 = com.baidu.tieba.recapp.r.dDm().a(this.joQ, AdvertAppInfo.eLo);
        com.baidu.adp.widget.ListView.a<?, ?> a6 = com.baidu.tieba.recapp.r.dDm().a(this.joQ, AdvertAppInfo.eLp);
        this.bns.add(a2);
        this.bns.add(a3);
        this.bns.add(a4);
        this.bns.add(a5);
        this.bns.add(a6);
        com.baidu.adp.widget.ListView.a<?, ?> b2 = com.baidu.tieba.h.b.cNm().b(this.joQ.getBaseFragmentActivity(), AdvertAppInfo.eLm);
        com.baidu.adp.widget.ListView.a<?, ?> b3 = com.baidu.tieba.h.b.cNm().b(this.joQ.getBaseFragmentActivity(), AdvertAppInfo.eLl);
        this.bns.add(b2);
        this.bns.add(b3);
    }

    public void setData(ArrayList<n> arrayList) {
        cEX();
        this.XW.setData(au(arrayList));
    }

    private ArrayList<n> au(ArrayList<n> arrayList) {
        ArrayList<n> arrayList2 = new ArrayList<>();
        Iterator<n> it = arrayList.iterator();
        while (it.hasNext()) {
            n next = it.next();
            if (next instanceof cb) {
                if (((cb) next).bpW() != null) {
                    if (!((cb) next).boS()) {
                        arrayList2.add(next);
                    } else {
                        ((cb) next).a((Item) null);
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

    private void cEX() {
        if (!com.baidu.tbadk.core.util.y.isEmpty(this.bns) && this.joQ != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.bns) {
                if (aVar instanceof com.baidu.tieba.frs.k) {
                    ((com.baidu.tieba.frs.k) aVar).a(this.joQ.getTbPageTag());
                }
            }
        }
    }

    private void cFB() {
        if (this.joQ != null && !com.baidu.tbadk.core.util.y.isEmpty(this.bns)) {
            for (com.baidu.adp.widget.ListView.a aVar : this.bns) {
                if (aVar instanceof com.baidu.tieba.frs.b.d) {
                    com.baidu.tieba.frs.b.d dVar = (com.baidu.tieba.frs.b.d) aVar;
                    if (dVar.getStatisticMetaData() != null) {
                        dVar.getStatisticMetaData().jHk = this.joQ.jpg;
                        dVar.getStatisticMetaData().jHm = this.joQ.forumId;
                        dVar.getStatisticMetaData().jHn = this.joQ.tabId;
                        dVar.getStatisticMetaData().jHq = this.joQ.tabType;
                        if (this.joQ.tabId == 502) {
                            dVar.getStatisticMetaData().jHp = 10;
                        } else if (this.joQ.isGeneralTab == 1) {
                            dVar.getStatisticMetaData().jHp = 12;
                        }
                    }
                }
            }
        }
    }

    public void notifyDataSetChanged() {
        this.XW.getAdapter().notifyDataSetChanged();
    }

    public void onDestory() {
        for (com.baidu.adp.widget.ListView.a aVar : this.bns) {
            if (aVar instanceof com.baidu.tieba.frs.k) {
                ((com.baidu.tieba.frs.k) aVar).release();
            }
        }
    }

    private void Ey(String str) {
        if (this.bns != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.bns) {
                if (aVar instanceof com.baidu.tieba.a.f) {
                    ((com.baidu.tieba.a.f) aVar).Ey(str);
                }
            }
        }
    }

    private void b(FrsViewData frsViewData) {
        if (this.bns != null && this.bns.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.bns) {
                if (aVar instanceof com.baidu.tieba.frs.k) {
                    ((com.baidu.tieba.frs.k) aVar).b(frsViewData);
                }
            }
        }
    }

    public void rb(boolean z) {
        if (this.joR != null) {
            this.joR.rd(z);
        }
        if (this.joS != null) {
            this.joS.rd(z);
        }
        if (this.joU != null) {
            this.joU.rd(z);
        }
        if (this.joV != null) {
            this.joV.rd(z);
        }
        if (this.joW != null) {
            this.joW.rd(z);
        }
    }
}
