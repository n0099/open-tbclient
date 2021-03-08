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
    private BdTypeRecyclerView Zq;
    private boolean isDynamic;
    private r joj;
    private FrsCommonTabFragment jqN;
    private k jqO;
    private k jqP;
    private ah jqQ;
    private aj jqR;
    private aj jqS;
    private f jqT;
    private com.baidu.tieba.frs.entelechy.adapter.c jqU;
    private l jqV;
    private ak jqW;
    private g jqX;
    private List<com.baidu.adp.widget.ListView.a> boS = new LinkedList();
    private CustomMessageListener jqY = new CustomMessageListener(CmdConfigCustom.CMD_FRS_ADD_ADAPTER) { // from class: com.baidu.tieba.frs.commontab.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2003008 && (customResponsedMessage.getData() instanceof AbsDelegateAdapterList)) {
                Iterator it = ((AbsDelegateAdapterList) customResponsedMessage.getData()).iterator();
                while (it.hasNext()) {
                    com.baidu.adp.widget.ListView.a aVar = (com.baidu.adp.widget.ListView.a) it.next();
                    if ((aVar instanceof y) && "FrsHottopicDelegateAdapter".equals(((y) aVar).csJ()) && a.this.boS != null) {
                        ((y) aVar).a(a.this.jqN.getPageContext(), a.this.jqN.getUniqueId());
                        if (a.this.isDynamic) {
                            ((y) aVar).setFrom("c13010");
                        }
                        a.this.boS.add(aVar);
                    }
                }
            }
        }
    };

    public a(FrsCommonTabFragment frsCommonTabFragment, BdTypeRecyclerView bdTypeRecyclerView, FrsViewData frsViewData, boolean z) {
        a(frsCommonTabFragment, bdTypeRecyclerView, frsViewData, z);
        this.Zq = bdTypeRecyclerView;
    }

    public void a(FrsCommonTabFragment frsCommonTabFragment, BdTypeRecyclerView bdTypeRecyclerView, FrsViewData frsViewData, boolean z) {
        this.jqN = frsCommonTabFragment;
        this.jqY.setPriority(1);
        this.jqY.setSelfListener(true);
        this.jqN.registerListener(this.jqY);
        this.jqO = new k(frsCommonTabFragment.getPageContext(), cb.eRN, this.jqN.getUniqueId());
        this.jqP = new k(frsCommonTabFragment.getPageContext(), cb.eSk, this.jqN.getUniqueId());
        this.jqQ = new ah(frsCommonTabFragment.getPageContext(), cb.eSq, this.jqN.getUniqueId());
        this.jqR = new aj(frsCommonTabFragment.getPageContext(), cb.eSl, this.jqN.getUniqueId());
        this.jqR.jre = this.jqN.jre;
        this.jqS = new aj(frsCommonTabFragment.getPageContext(), cb.eSu, this.jqN.getUniqueId());
        this.jqS.jre = this.jqN.jre;
        this.jqT = new f(frsCommonTabFragment.getPageContext(), cb.eSE, this.jqN.getUniqueId());
        this.joj = new r(frsCommonTabFragment.getPageContext(), s.jlC);
        com.baidu.tieba.frs.entelechy.adapter.a aVar = new com.baidu.tieba.frs.entelechy.adapter.a(frsCommonTabFragment.getPageContext(), cb.eSc, frsCommonTabFragment.getUniqueId());
        this.jqU = new com.baidu.tieba.frs.entelechy.adapter.c(frsCommonTabFragment.getPageContext(), cb.eSs, this.jqN.getUniqueId());
        this.jqV = new l(frsCommonTabFragment.getPageContext(), cb.eSr, this.jqN.getUniqueId());
        this.jqW = new ak(frsCommonTabFragment.getPageContext(), cb.eSt, this.jqN.getUniqueId());
        if (!z) {
            this.jqX = new g(frsCommonTabFragment.getPageContext(), cb.eSe, this.jqN.getUniqueId());
            this.jqX.a(this.Zq);
        }
        cFN();
        this.boS.add(this.jqO);
        this.boS.add(this.jqP);
        this.boS.add(this.jqQ);
        this.boS.add(this.jqR);
        this.boS.add(this.jqS);
        this.boS.add(this.jqT);
        this.boS.add(this.joj);
        this.boS.add(aVar);
        this.boS.add(this.jqU);
        this.boS.add(this.jqV);
        this.boS.add(this.jqW);
        this.boS.add(this.jqX);
        if (frsCommonTabFragment.tabId == 89) {
            this.isDynamic = true;
            this.jqO.setFrom("c13010");
            this.jqP.setFrom("c13010");
            this.jqQ.setFrom("c13010");
            this.jqR.setFrom("c13010");
            this.jqS.setFrom("c13010");
            ED("page_frs_dynamic");
        }
        this.jqO.uZ(frsCommonTabFragment.tabId);
        this.jqP.uZ(frsCommonTabFragment.tabId);
        this.jqQ.uZ(frsCommonTabFragment.tabId);
        this.jqR.uZ(frsCommonTabFragment.tabId);
        this.jqS.uZ(frsCommonTabFragment.tabId);
        this.jqT.uZ(frsCommonTabFragment.tabId);
        this.jqU.uZ(frsCommonTabFragment.tabId);
        this.jqV.uZ(frsCommonTabFragment.tabId);
        this.jqW.uZ(frsCommonTabFragment.tabId);
        this.jqO.zo(frsCommonTabFragment.tabType);
        this.jqP.zo(frsCommonTabFragment.tabType);
        boolean z2 = frsCommonTabFragment.tabType == 16;
        this.jqO.re(z2);
        this.jqR.re(z2);
        this.jqT.re(z2);
        this.jqQ.re(z2);
        this.jqV.re(z2);
        this.jqW.re(z2);
        AbsDelegateAdapterList absDelegateAdapterList = new AbsDelegateAdapterList();
        CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2003022, absDelegateAdapterList);
        CustomMessage customMessage = new CustomMessage(2003022);
        customMessage.setTag(this.jqN.getUniqueId());
        customResponsedMessage.setOrginalMessage(customMessage);
        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
        if (!absDelegateAdapterList.isEmpty()) {
            Iterator it = absDelegateAdapterList.iterator();
            while (it.hasNext()) {
                com.baidu.adp.widget.ListView.a aVar2 = (com.baidu.adp.widget.ListView.a) it.next();
                if (aVar2 instanceof com.baidu.tieba.frs.k) {
                    ((com.baidu.tieba.frs.k) aVar2).a(this.jqN.getPageContext(), this.jqN.getUniqueId());
                }
            }
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(absDelegateAdapterList);
            if (this.boS != null) {
                this.boS.addAll(arrayList);
            }
        }
        if (frsCommonTabFragment.tabId == 502 || frsCommonTabFragment.isGeneralTab == 1) {
            b(frsViewData);
        }
        cFk();
        bdTypeRecyclerView.addAdapters(this.boS);
        cFO();
    }

    private void cFN() {
        com.baidu.adp.widget.ListView.a<?, ?> a2 = com.baidu.tieba.recapp.s.dDB().a(this.jqN, AdvertAppInfo.eMB);
        com.baidu.adp.widget.ListView.a<?, ?> a3 = com.baidu.tieba.recapp.s.dDB().a(this.jqN, AdvertAppInfo.eMK);
        com.baidu.adp.widget.ListView.a<?, ?> a4 = com.baidu.tieba.recapp.s.dDB().a(this.jqN, AdvertAppInfo.eMO);
        com.baidu.adp.widget.ListView.a<?, ?> a5 = com.baidu.tieba.recapp.s.dDB().a(this.jqN, AdvertAppInfo.eMP);
        com.baidu.adp.widget.ListView.a<?, ?> a6 = com.baidu.tieba.recapp.s.dDB().a(this.jqN, AdvertAppInfo.eMQ);
        this.boS.add(a2);
        this.boS.add(a3);
        this.boS.add(a4);
        this.boS.add(a5);
        this.boS.add(a6);
        com.baidu.adp.widget.ListView.a<?, ?> b = com.baidu.tieba.h.b.cNB().b(this.jqN.getBaseFragmentActivity(), AdvertAppInfo.eMN);
        com.baidu.adp.widget.ListView.a<?, ?> b2 = com.baidu.tieba.h.b.cNB().b(this.jqN.getBaseFragmentActivity(), AdvertAppInfo.eMM);
        this.boS.add(b);
        this.boS.add(b2);
    }

    public void setData(ArrayList<n> arrayList) {
        cFk();
        this.Zq.setData(au(arrayList));
    }

    private ArrayList<n> au(ArrayList<n> arrayList) {
        ArrayList<n> arrayList2 = new ArrayList<>();
        Iterator<n> it = arrayList.iterator();
        while (it.hasNext()) {
            n next = it.next();
            if (next instanceof cb) {
                if (((cb) next).bpY() != null) {
                    if (!((cb) next).boU()) {
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

    private void cFk() {
        if (!com.baidu.tbadk.core.util.y.isEmpty(this.boS) && this.jqN != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.boS) {
                if (aVar instanceof com.baidu.tieba.frs.k) {
                    ((com.baidu.tieba.frs.k) aVar).a(this.jqN.getTbPageTag());
                }
            }
        }
    }

    private void cFO() {
        if (this.jqN != null && !com.baidu.tbadk.core.util.y.isEmpty(this.boS)) {
            for (com.baidu.adp.widget.ListView.a aVar : this.boS) {
                if (aVar instanceof com.baidu.tieba.frs.b.d) {
                    com.baidu.tieba.frs.b.d dVar = (com.baidu.tieba.frs.b.d) aVar;
                    if (dVar.getStatisticMetaData() != null) {
                        dVar.getStatisticMetaData().jJh = this.jqN.jrd;
                        dVar.getStatisticMetaData().jJj = this.jqN.forumId;
                        dVar.getStatisticMetaData().jJk = this.jqN.tabId;
                        dVar.getStatisticMetaData().jJn = this.jqN.tabType;
                        if (this.jqN.tabId == 502) {
                            dVar.getStatisticMetaData().jJm = 10;
                        } else if (this.jqN.isGeneralTab == 1) {
                            dVar.getStatisticMetaData().jJm = 12;
                        }
                    }
                }
            }
        }
    }

    public void notifyDataSetChanged() {
        this.Zq.getAdapter().notifyDataSetChanged();
    }

    public void onDestory() {
        for (com.baidu.adp.widget.ListView.a aVar : this.boS) {
            if (aVar instanceof com.baidu.tieba.frs.k) {
                ((com.baidu.tieba.frs.k) aVar).release();
            }
        }
    }

    private void ED(String str) {
        if (this.boS != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.boS) {
                if (aVar instanceof com.baidu.tieba.a.f) {
                    ((com.baidu.tieba.a.f) aVar).ED(str);
                }
            }
        }
    }

    private void b(FrsViewData frsViewData) {
        if (this.boS != null && this.boS.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.boS) {
                if (aVar instanceof com.baidu.tieba.frs.k) {
                    ((com.baidu.tieba.frs.k) aVar).b(frsViewData);
                }
            }
        }
    }

    public void rb(boolean z) {
        if (this.jqO != null) {
            this.jqO.rd(z);
        }
        if (this.jqP != null) {
            this.jqP.rd(z);
        }
        if (this.jqR != null) {
            this.jqR.rd(z);
        }
        if (this.jqS != null) {
            this.jqS.rd(z);
        }
        if (this.jqT != null) {
            this.jqT.rd(z);
        }
    }
}
