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
    private r jmA;
    private FrsCommonTabFragment jpe;
    private k jpf;
    private k jpg;
    private ah jph;
    private aj jpi;
    private aj jpj;
    private f jpk;
    private com.baidu.tieba.frs.entelechy.adapter.c jpl;
    private l jpm;
    private ak jpn;
    private g jpo;
    private List<com.baidu.adp.widget.ListView.a> bns = new LinkedList();
    private CustomMessageListener jpp = new CustomMessageListener(CmdConfigCustom.CMD_FRS_ADD_ADAPTER) { // from class: com.baidu.tieba.frs.commontab.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2003008 && (customResponsedMessage.getData() instanceof AbsDelegateAdapterList)) {
                Iterator it = ((AbsDelegateAdapterList) customResponsedMessage.getData()).iterator();
                while (it.hasNext()) {
                    com.baidu.adp.widget.ListView.a aVar = (com.baidu.adp.widget.ListView.a) it.next();
                    if ((aVar instanceof y) && "FrsHottopicDelegateAdapter".equals(((y) aVar).csD()) && a.this.bns != null) {
                        ((y) aVar).a(a.this.jpe.getPageContext(), a.this.jpe.getUniqueId());
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
        this.jpe = frsCommonTabFragment;
        this.jpp.setPriority(1);
        this.jpp.setSelfListener(true);
        this.jpe.registerListener(this.jpp);
        this.jpf = new k(frsCommonTabFragment.getPageContext(), cb.eQm, this.jpe.getUniqueId());
        this.jpg = new k(frsCommonTabFragment.getPageContext(), cb.eQJ, this.jpe.getUniqueId());
        this.jph = new ah(frsCommonTabFragment.getPageContext(), cb.eQP, this.jpe.getUniqueId());
        this.jpi = new aj(frsCommonTabFragment.getPageContext(), cb.eQK, this.jpe.getUniqueId());
        this.jpi.jpv = this.jpe.jpv;
        this.jpj = new aj(frsCommonTabFragment.getPageContext(), cb.eQT, this.jpe.getUniqueId());
        this.jpj.jpv = this.jpe.jpv;
        this.jpk = new f(frsCommonTabFragment.getPageContext(), cb.eRd, this.jpe.getUniqueId());
        this.jmA = new r(frsCommonTabFragment.getPageContext(), s.jjT);
        com.baidu.tieba.frs.entelechy.adapter.a aVar = new com.baidu.tieba.frs.entelechy.adapter.a(frsCommonTabFragment.getPageContext(), cb.eQB, frsCommonTabFragment.getUniqueId());
        this.jpl = new com.baidu.tieba.frs.entelechy.adapter.c(frsCommonTabFragment.getPageContext(), cb.eQR, this.jpe.getUniqueId());
        this.jpm = new l(frsCommonTabFragment.getPageContext(), cb.eQQ, this.jpe.getUniqueId());
        this.jpn = new ak(frsCommonTabFragment.getPageContext(), cb.eQS, this.jpe.getUniqueId());
        if (!z) {
            this.jpo = new g(frsCommonTabFragment.getPageContext(), cb.eQD, this.jpe.getUniqueId());
            this.jpo.a(this.XW);
        }
        cFH();
        this.bns.add(this.jpf);
        this.bns.add(this.jpg);
        this.bns.add(this.jph);
        this.bns.add(this.jpi);
        this.bns.add(this.jpj);
        this.bns.add(this.jpk);
        this.bns.add(this.jmA);
        this.bns.add(aVar);
        this.bns.add(this.jpl);
        this.bns.add(this.jpm);
        this.bns.add(this.jpn);
        this.bns.add(this.jpo);
        if (frsCommonTabFragment.tabId == 89) {
            this.isDynamic = true;
            this.jpf.setFrom("c13010");
            this.jpg.setFrom("c13010");
            this.jph.setFrom("c13010");
            this.jpi.setFrom("c13010");
            this.jpj.setFrom("c13010");
            Ew("page_frs_dynamic");
        }
        this.jpf.uX(frsCommonTabFragment.tabId);
        this.jpg.uX(frsCommonTabFragment.tabId);
        this.jph.uX(frsCommonTabFragment.tabId);
        this.jpi.uX(frsCommonTabFragment.tabId);
        this.jpj.uX(frsCommonTabFragment.tabId);
        this.jpk.uX(frsCommonTabFragment.tabId);
        this.jpl.uX(frsCommonTabFragment.tabId);
        this.jpm.uX(frsCommonTabFragment.tabId);
        this.jpn.uX(frsCommonTabFragment.tabId);
        this.jpf.zn(frsCommonTabFragment.tabType);
        this.jpg.zn(frsCommonTabFragment.tabType);
        boolean z2 = frsCommonTabFragment.tabType == 16;
        this.jpf.re(z2);
        this.jpi.re(z2);
        this.jpk.re(z2);
        this.jph.re(z2);
        this.jpm.re(z2);
        this.jpn.re(z2);
        AbsDelegateAdapterList absDelegateAdapterList = new AbsDelegateAdapterList();
        CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2003022, absDelegateAdapterList);
        CustomMessage customMessage = new CustomMessage(2003022);
        customMessage.setTag(this.jpe.getUniqueId());
        customResponsedMessage.setOrginalMessage(customMessage);
        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
        if (!absDelegateAdapterList.isEmpty()) {
            Iterator it = absDelegateAdapterList.iterator();
            while (it.hasNext()) {
                com.baidu.adp.widget.ListView.a aVar2 = (com.baidu.adp.widget.ListView.a) it.next();
                if (aVar2 instanceof com.baidu.tieba.frs.k) {
                    ((com.baidu.tieba.frs.k) aVar2).a(this.jpe.getPageContext(), this.jpe.getUniqueId());
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
        cFe();
        bdTypeRecyclerView.addAdapters(this.bns);
        cFI();
    }

    private void cFH() {
        com.baidu.adp.widget.ListView.a<?, ?> a2 = com.baidu.tieba.recapp.s.dDt().a(this.jpe, AdvertAppInfo.eLa);
        com.baidu.adp.widget.ListView.a<?, ?> a3 = com.baidu.tieba.recapp.s.dDt().a(this.jpe, AdvertAppInfo.eLj);
        com.baidu.adp.widget.ListView.a<?, ?> a4 = com.baidu.tieba.recapp.s.dDt().a(this.jpe, AdvertAppInfo.eLn);
        com.baidu.adp.widget.ListView.a<?, ?> a5 = com.baidu.tieba.recapp.s.dDt().a(this.jpe, AdvertAppInfo.eLo);
        com.baidu.adp.widget.ListView.a<?, ?> a6 = com.baidu.tieba.recapp.s.dDt().a(this.jpe, AdvertAppInfo.eLp);
        this.bns.add(a2);
        this.bns.add(a3);
        this.bns.add(a4);
        this.bns.add(a5);
        this.bns.add(a6);
        com.baidu.adp.widget.ListView.a<?, ?> b2 = com.baidu.tieba.h.b.cNt().b(this.jpe.getBaseFragmentActivity(), AdvertAppInfo.eLm);
        com.baidu.adp.widget.ListView.a<?, ?> b3 = com.baidu.tieba.h.b.cNt().b(this.jpe.getBaseFragmentActivity(), AdvertAppInfo.eLl);
        this.bns.add(b2);
        this.bns.add(b3);
    }

    public void setData(ArrayList<n> arrayList) {
        cFe();
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

    private void cFe() {
        if (!com.baidu.tbadk.core.util.y.isEmpty(this.bns) && this.jpe != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.bns) {
                if (aVar instanceof com.baidu.tieba.frs.k) {
                    ((com.baidu.tieba.frs.k) aVar).a(this.jpe.getTbPageTag());
                }
            }
        }
    }

    private void cFI() {
        if (this.jpe != null && !com.baidu.tbadk.core.util.y.isEmpty(this.bns)) {
            for (com.baidu.adp.widget.ListView.a aVar : this.bns) {
                if (aVar instanceof com.baidu.tieba.frs.b.d) {
                    com.baidu.tieba.frs.b.d dVar = (com.baidu.tieba.frs.b.d) aVar;
                    if (dVar.getStatisticMetaData() != null) {
                        dVar.getStatisticMetaData().jHy = this.jpe.jpu;
                        dVar.getStatisticMetaData().jHA = this.jpe.forumId;
                        dVar.getStatisticMetaData().jHB = this.jpe.tabId;
                        dVar.getStatisticMetaData().jHE = this.jpe.tabType;
                        if (this.jpe.tabId == 502) {
                            dVar.getStatisticMetaData().jHD = 10;
                        } else if (this.jpe.isGeneralTab == 1) {
                            dVar.getStatisticMetaData().jHD = 12;
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

    private void Ew(String str) {
        if (this.bns != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.bns) {
                if (aVar instanceof com.baidu.tieba.a.f) {
                    ((com.baidu.tieba.a.f) aVar).Ew(str);
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
        if (this.jpf != null) {
            this.jpf.rd(z);
        }
        if (this.jpg != null) {
            this.jpg.rd(z);
        }
        if (this.jpi != null) {
            this.jpi.rd(z);
        }
        if (this.jpj != null) {
            this.jpj.rd(z);
        }
        if (this.jpk != null) {
            this.jpk.rd(z);
        }
    }
}
