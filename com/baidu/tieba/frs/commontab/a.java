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
    private BdTypeRecyclerView Yc;
    private boolean isDynamic;
    private r jll;
    private FrsCommonTabFragment jnQ;
    private k jnR;
    private k jnS;
    private ah jnT;
    private aj jnU;
    private aj jnV;
    private f jnW;
    private com.baidu.tieba.frs.entelechy.adapter.c jnX;
    private l jnY;
    private ak jnZ;
    private g joa;
    private List<com.baidu.adp.widget.ListView.a> boM = new LinkedList();
    private CustomMessageListener job = new CustomMessageListener(CmdConfigCustom.CMD_FRS_ADD_ADAPTER) { // from class: com.baidu.tieba.frs.commontab.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2003008 && (customResponsedMessage.getData() instanceof AbsDelegateAdapterList)) {
                Iterator it = ((AbsDelegateAdapterList) customResponsedMessage.getData()).iterator();
                while (it.hasNext()) {
                    com.baidu.adp.widget.ListView.a aVar = (com.baidu.adp.widget.ListView.a) it.next();
                    if ((aVar instanceof x) && "FrsHottopicDelegateAdapter".equals(((x) aVar).agv()) && a.this.boM != null) {
                        ((x) aVar).a(a.this.jnQ.getPageContext(), a.this.jnQ.getUniqueId());
                        if (a.this.isDynamic) {
                            ((x) aVar).setFrom("c13010");
                        }
                        a.this.boM.add(aVar);
                    }
                }
            }
        }
    };

    public a(FrsCommonTabFragment frsCommonTabFragment, BdTypeRecyclerView bdTypeRecyclerView, FrsViewData frsViewData, boolean z) {
        a(frsCommonTabFragment, bdTypeRecyclerView, frsViewData, z);
        this.Yc = bdTypeRecyclerView;
    }

    public void a(FrsCommonTabFragment frsCommonTabFragment, BdTypeRecyclerView bdTypeRecyclerView, FrsViewData frsViewData, boolean z) {
        this.jnQ = frsCommonTabFragment;
        this.job.setPriority(1);
        this.job.setSelfListener(true);
        this.jnQ.registerListener(this.job);
        this.jnR = new k(frsCommonTabFragment.getPageContext(), bz.eSL, this.jnQ.getUniqueId());
        this.jnS = new k(frsCommonTabFragment.getPageContext(), bz.eTi, this.jnQ.getUniqueId());
        this.jnT = new ah(frsCommonTabFragment.getPageContext(), bz.eTo, this.jnQ.getUniqueId());
        this.jnU = new aj(frsCommonTabFragment.getPageContext(), bz.eTj, this.jnQ.getUniqueId());
        this.jnU.joh = this.jnQ.joh;
        this.jnV = new aj(frsCommonTabFragment.getPageContext(), bz.eTs, this.jnQ.getUniqueId());
        this.jnV.joh = this.jnQ.joh;
        this.jnW = new f(frsCommonTabFragment.getPageContext(), bz.eTC, this.jnQ.getUniqueId());
        this.jll = new r(frsCommonTabFragment.getPageContext(), s.jiG);
        com.baidu.tieba.frs.entelechy.adapter.a aVar = new com.baidu.tieba.frs.entelechy.adapter.a(frsCommonTabFragment.getPageContext(), bz.eTa, frsCommonTabFragment.getUniqueId());
        this.jnX = new com.baidu.tieba.frs.entelechy.adapter.c(frsCommonTabFragment.getPageContext(), bz.eTq, this.jnQ.getUniqueId());
        this.jnY = new l(frsCommonTabFragment.getPageContext(), bz.eTp, this.jnQ.getUniqueId());
        this.jnZ = new ak(frsCommonTabFragment.getPageContext(), bz.eTr, this.jnQ.getUniqueId());
        if (!z) {
            this.joa = new g(frsCommonTabFragment.getPageContext(), bz.eTc, this.jnQ.getUniqueId());
            this.joa.a(this.Yc);
        }
        cIf();
        this.boM.add(this.jnR);
        this.boM.add(this.jnS);
        this.boM.add(this.jnT);
        this.boM.add(this.jnU);
        this.boM.add(this.jnV);
        this.boM.add(this.jnW);
        this.boM.add(this.jll);
        this.boM.add(aVar);
        this.boM.add(this.jnX);
        this.boM.add(this.jnY);
        this.boM.add(this.jnZ);
        this.boM.add(this.joa);
        if (frsCommonTabFragment.tabId == 89) {
            this.isDynamic = true;
            this.jnR.setFrom("c13010");
            this.jnS.setFrom("c13010");
            this.jnT.setFrom("c13010");
            this.jnU.setFrom("c13010");
            this.jnV.setFrom("c13010");
            Fl("page_frs_dynamic");
        }
        this.jnR.wt(frsCommonTabFragment.tabId);
        this.jnS.wt(frsCommonTabFragment.tabId);
        this.jnT.wt(frsCommonTabFragment.tabId);
        this.jnU.wt(frsCommonTabFragment.tabId);
        this.jnV.wt(frsCommonTabFragment.tabId);
        this.jnW.wt(frsCommonTabFragment.tabId);
        this.jnX.wt(frsCommonTabFragment.tabId);
        this.jnY.wt(frsCommonTabFragment.tabId);
        this.jnZ.wt(frsCommonTabFragment.tabId);
        this.jnR.AJ(frsCommonTabFragment.tabType);
        this.jnS.AJ(frsCommonTabFragment.tabType);
        boolean z2 = frsCommonTabFragment.tabType == 16;
        this.jnR.qY(z2);
        this.jnU.qY(z2);
        this.jnW.qY(z2);
        this.jnT.qY(z2);
        this.jnY.qY(z2);
        this.jnZ.qY(z2);
        AbsDelegateAdapterList absDelegateAdapterList = new AbsDelegateAdapterList();
        CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2003022, absDelegateAdapterList);
        CustomMessage customMessage = new CustomMessage(2003022);
        customMessage.setTag(this.jnQ.getUniqueId());
        customResponsedMessage.setOrginalMessage(customMessage);
        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
        if (!absDelegateAdapterList.isEmpty()) {
            Iterator it = absDelegateAdapterList.iterator();
            while (it.hasNext()) {
                com.baidu.adp.widget.ListView.a aVar2 = (com.baidu.adp.widget.ListView.a) it.next();
                if (aVar2 instanceof com.baidu.tieba.frs.k) {
                    ((com.baidu.tieba.frs.k) aVar2).a(this.jnQ.getPageContext(), this.jnQ.getUniqueId());
                }
            }
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(absDelegateAdapterList);
            if (this.boM != null) {
                this.boM.addAll(arrayList);
            }
        }
        if (frsCommonTabFragment.tabId == 502 || frsCommonTabFragment.isGeneralTab == 1) {
            b(frsViewData);
        }
        cHD();
        bdTypeRecyclerView.addAdapters(this.boM);
        cIg();
    }

    private void cIf() {
        com.baidu.adp.widget.ListView.a<?, ?> a2 = com.baidu.tieba.recapp.r.dEW().a(this.jnQ, AdvertAppInfo.eNz);
        com.baidu.adp.widget.ListView.a<?, ?> a3 = com.baidu.tieba.recapp.r.dEW().a(this.jnQ, AdvertAppInfo.eNI);
        com.baidu.adp.widget.ListView.a<?, ?> a4 = com.baidu.tieba.recapp.r.dEW().a(this.jnQ, AdvertAppInfo.eNM);
        com.baidu.adp.widget.ListView.a<?, ?> a5 = com.baidu.tieba.recapp.r.dEW().a(this.jnQ, AdvertAppInfo.eNN);
        com.baidu.adp.widget.ListView.a<?, ?> a6 = com.baidu.tieba.recapp.r.dEW().a(this.jnQ, AdvertAppInfo.eNO);
        this.boM.add(a2);
        this.boM.add(a3);
        this.boM.add(a4);
        this.boM.add(a5);
        this.boM.add(a6);
        com.baidu.adp.widget.ListView.a<?, ?> b2 = com.baidu.tieba.h.b.cPq().b(this.jnQ.getBaseFragmentActivity(), AdvertAppInfo.eNL);
        com.baidu.adp.widget.ListView.a<?, ?> b3 = com.baidu.tieba.h.b.cPq().b(this.jnQ.getBaseFragmentActivity(), AdvertAppInfo.eNK);
        this.boM.add(b2);
        this.boM.add(b3);
    }

    public void setData(ArrayList<n> arrayList) {
        cHD();
        this.Yc.setData(aA(arrayList));
    }

    private ArrayList<n> aA(ArrayList<n> arrayList) {
        ArrayList<n> arrayList2 = new ArrayList<>();
        Iterator<n> it = arrayList.iterator();
        while (it.hasNext()) {
            n next = it.next();
            if (next instanceof bz) {
                if (((bz) next).bty() != null) {
                    if (!((bz) next).bsu()) {
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

    private void cHD() {
        if (!com.baidu.tbadk.core.util.x.isEmpty(this.boM) && this.jnQ != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.boM) {
                if (aVar instanceof com.baidu.tieba.frs.k) {
                    ((com.baidu.tieba.frs.k) aVar).a(this.jnQ.getTbPageTag());
                }
            }
        }
    }

    private void cIg() {
        if (this.jnQ != null && !com.baidu.tbadk.core.util.x.isEmpty(this.boM)) {
            for (com.baidu.adp.widget.ListView.a aVar : this.boM) {
                if (aVar instanceof com.baidu.tieba.frs.b.d) {
                    com.baidu.tieba.frs.b.d dVar = (com.baidu.tieba.frs.b.d) aVar;
                    if (dVar.getStatisticMetaData() != null) {
                        dVar.getStatisticMetaData().jGm = this.jnQ.jog;
                        dVar.getStatisticMetaData().jGo = this.jnQ.forumId;
                        dVar.getStatisticMetaData().jGp = this.jnQ.tabId;
                        dVar.getStatisticMetaData().jGs = this.jnQ.tabType;
                        if (this.jnQ.tabId == 502) {
                            dVar.getStatisticMetaData().jGr = 10;
                        } else if (this.jnQ.isGeneralTab == 1) {
                            dVar.getStatisticMetaData().jGr = 12;
                        }
                    }
                }
            }
        }
    }

    public void notifyDataSetChanged() {
        this.Yc.getAdapter().notifyDataSetChanged();
    }

    public void onDestory() {
        for (com.baidu.adp.widget.ListView.a aVar : this.boM) {
            if (aVar instanceof com.baidu.tieba.frs.k) {
                ((com.baidu.tieba.frs.k) aVar).release();
            }
        }
    }

    private void Fl(String str) {
        if (this.boM != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.boM) {
                if (aVar instanceof com.baidu.tieba.a.f) {
                    ((com.baidu.tieba.a.f) aVar).Fl(str);
                }
            }
        }
    }

    private void b(FrsViewData frsViewData) {
        if (this.boM != null && this.boM.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.boM) {
                if (aVar instanceof com.baidu.tieba.frs.k) {
                    ((com.baidu.tieba.frs.k) aVar).b(frsViewData);
                }
            }
        }
    }

    public void qV(boolean z) {
        if (this.jnR != null) {
            this.jnR.qX(z);
        }
        if (this.jnS != null) {
            this.jnS.qX(z);
        }
        if (this.jnU != null) {
            this.jnU.qX(z);
        }
        if (this.jnV != null) {
            this.jnV.qX(z);
        }
        if (this.jnW != null) {
            this.jnW.qX(z);
        }
    }
}
