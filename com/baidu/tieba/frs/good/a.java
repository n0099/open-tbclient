package com.baidu.tieba.frs.good;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.adp.widget.ListView.i;
import com.baidu.adp.widget.ListView.o;
import com.baidu.adp.widget.ListView.r;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.data.ar;
import com.baidu.tbadk.core.data.bd;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.frs.AbsDelegateAdapterList;
import com.baidu.tieba.frs.entelechy.a.d;
import com.baidu.tieba.frs.entelechy.a.g;
import com.baidu.tieba.frs.entelechy.a.j;
import com.baidu.tieba.frs.entelechy.a.p;
import com.baidu.tieba.frs.entelechy.a.t;
import com.baidu.tieba.frs.l;
import com.baidu.tieba.frs.m;
import com.baidu.tieba.lego.card.model.ICardInfo;
import com.baidu.tieba.recapp.q;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes2.dex */
public class a {
    private t dGA;
    private g dGB;
    private com.baidu.adp.widget.ListView.a dGC;
    private com.baidu.adp.widget.ListView.a dGD;
    private d dGE;
    private d dGF;
    private l dGG;
    private List<com.baidu.adp.widget.ListView.a> dGH;
    private final HashMap<Integer, bd> dGN;
    private com.baidu.tieba.tbadkCore.l dGO;
    private com.baidu.tieba.frs.entelechy.a.l dGt;
    private j dGu;
    private p dGv;
    private com.baidu.tieba.frs.entelechy.a.l dGw;
    private com.baidu.tieba.frs.entelechy.a.c dGx;
    private b dOd;
    private BdTypeRecyclerView dOe;
    private com.baidu.adp.widget.ListView.a dOf;
    private com.baidu.adp.widget.ListView.a dOg;
    private ArrayList<i> dkS;
    private List<com.baidu.adp.widget.ListView.a> mAdapters = new LinkedList();
    private CustomMessageListener dGQ = new CustomMessageListener(CmdConfigCustom.CMD_FRS_ADD_ADAPTER) { // from class: com.baidu.tieba.frs.good.a.1
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX DEBUG: Multi-variable search result rejected for r3v2, resolved type: com.baidu.tieba.frs.good.b */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2003008 && (customResponsedMessage.getData() instanceof AbsDelegateAdapterList)) {
                AbsDelegateAdapterList absDelegateAdapterList = (AbsDelegateAdapterList) customResponsedMessage.getData();
                Iterator it = absDelegateAdapterList.iterator();
                while (it.hasNext()) {
                    com.baidu.adp.widget.ListView.a aVar = (com.baidu.adp.widget.ListView.a) it.next();
                    if (aVar instanceof com.baidu.tieba.frs.g) {
                        ((com.baidu.tieba.frs.g) aVar).a(a.this.dOd.getPageContext(), a.this.dOd.getUniqueId());
                    }
                }
                ArrayList arrayList = new ArrayList();
                arrayList.addAll(absDelegateAdapterList);
                if (a.this.mAdapters != null) {
                    a.this.mAdapters.addAll(arrayList);
                }
                if (a.this.dOe != null) {
                    a.this.dOe.addAdapters(arrayList);
                }
            }
        }
    };
    private CustomMessageListener dGR = new CustomMessageListener(CmdConfigCustom.CMD_LEGO_REGISTER) { // from class: com.baidu.tieba.frs.good.a.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && v.E(a.this.dGH)) {
                a.this.b(a.this.dOe);
                a.this.b(a.this.dkS, a.this.dGO);
            }
        }
    };

    public a(b bVar, BdTypeRecyclerView bdTypeRecyclerView) {
        a(bVar, bdTypeRecyclerView);
        this.dOe = bdTypeRecyclerView;
        this.dGN = new HashMap<>();
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v31, resolved type: com.baidu.tieba.frs.good.b */
    /* JADX WARN: Multi-variable type inference failed */
    public void a(b bVar, BdTypeRecyclerView bdTypeRecyclerView) {
        this.dOd = bVar;
        this.dGQ.setPriority(1);
        this.dGQ.setSelfListener(true);
        this.dOd.registerListener(this.dGQ);
        this.dGt = new com.baidu.tieba.frs.entelechy.a.l(bVar.getPageContext(), bd.aMY, this.dOd.getUniqueId());
        this.dGt.setVoiceManager(bVar.getVoiceManager());
        this.dGu = new j(bVar.getPageContext(), bd.aMZ, this.dOd.getUniqueId());
        this.dGw = new com.baidu.tieba.frs.entelechy.a.l(bVar.getPageContext(), bd.aNa, this.dOd.getUniqueId());
        this.dGw.setVoiceManager(bVar.getVoiceManager());
        this.dGA = new t(bVar.getPageContext(), bd.aNb, this.dOd.getUniqueId());
        this.dGB = new g(bVar.getPageContext(), bd.aNg, this.dOd.getUniqueId());
        this.dGG = new l(bVar.getPageContext(), m.dDm);
        this.dGE = new d(bVar.getPageContext(), bd.aNk, this.dOd.getUniqueId());
        this.dGF = new d(bVar.getPageContext(), bd.aNl, this.dOd.getUniqueId());
        this.dGC = com.baidu.tieba.frs.a.atA().a(bVar.getPageContext(), bd.aOm, this.dOd.getUniqueId(), true);
        this.dGD = com.baidu.tieba.frs.a.atA().b(bVar.getPageContext(), bd.aOt, this.dOd.getUniqueId());
        this.dOf = q.bmR().a(this.dOd, AdvertAppInfo.aIS);
        this.dOg = q.bmR().a(this.dOd, AdvertAppInfo.aJb);
        this.dGx = new com.baidu.tieba.frs.entelechy.a.c(bVar.getPageContext(), ar.aMu, this.dOd.getUniqueId());
        this.dGv = new p(bVar.getPageContext(), bd.aNf, this.dOd.getUniqueId());
        this.mAdapters.add(this.dGt);
        this.mAdapters.add(this.dGu);
        this.mAdapters.add(this.dGt);
        this.mAdapters.add(this.dGu);
        this.mAdapters.add(this.dGw);
        this.mAdapters.add(this.dGG);
        this.mAdapters.add(this.dGA);
        this.mAdapters.add(this.dGB);
        this.mAdapters.add(this.dGE);
        this.mAdapters.add(this.dGF);
        this.mAdapters.add(this.dGx);
        this.mAdapters.add(this.dGv);
        if (this.dGC != null) {
            this.mAdapters.add(this.dGC);
        }
        if (this.dGD != null) {
            this.mAdapters.add(this.dGD);
        }
        this.mAdapters.add(this.dOf);
        this.mAdapters.add(this.dOg);
        com.baidu.adp.widget.ListView.a<? extends bd, ? extends r.a> b = com.baidu.tieba.frs.a.atA().b(this.dOd.getPageContext(), bd.aOl, this.dOd.getUniqueId());
        if (b != null) {
            this.mAdapters.add(b);
        }
        CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_ADD_ADAPTER, new AbsDelegateAdapterList());
        CustomMessage customMessage = new CustomMessage(CmdConfigCustom.CMD_FRS_ADD_ADAPTER);
        customMessage.setTag(this.dOd.getUniqueId());
        customResponsedMessage.setOrginalMessage(customMessage);
        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
        a(bdTypeRecyclerView);
        bdTypeRecyclerView.addAdapters(this.mAdapters);
    }

    public void onDestory() {
        for (com.baidu.adp.widget.ListView.a aVar : this.mAdapters) {
            if (aVar instanceof com.baidu.tieba.frs.g) {
                ((com.baidu.tieba.frs.g) aVar).release();
            }
        }
    }

    public void b(ArrayList<i> arrayList, com.baidu.tieba.tbadkCore.l lVar) {
        b(lVar);
        N(arrayList);
        com.baidu.tieba.tbadkCore.q.s(arrayList, 1);
        L(arrayList);
        this.dOe.setData(arrayList);
        this.dkS = arrayList;
        this.dGO = lVar;
    }

    private ArrayList<Integer> L(ArrayList<i> arrayList) {
        if (arrayList == null || arrayList.size() == 0) {
            return null;
        }
        ArrayList<Integer> arrayList2 = new ArrayList<>();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= arrayList.size()) {
                return arrayList2;
            }
            i iVar = arrayList.get(i2);
            if (iVar instanceof AdvertAppInfo) {
                arrayList2.add(Integer.valueOf(i2));
                if (this.dGN != null && !this.dGN.containsValue(iVar)) {
                    this.dGN.put(Integer.valueOf(i2), (bd) iVar);
                }
            }
            i = i2 + 1;
        }
    }

    public HashMap<Integer, bd> awj() {
        return this.dGN;
    }

    public void awk() {
        if (this.dOe != null && this.dOe.getData() != null && this.dOe.getData().size() != 0) {
            for (i iVar : this.dOe.getData()) {
                if ((iVar instanceof bd) && ((bd) iVar).yN() != 0) {
                    ((bd) iVar).zB();
                }
            }
        }
    }

    public void notifyDataSetChanged() {
        this.dOe.getAdapter().notifyDataSetChanged();
    }

    public void onChangeSkinType(int i) {
    }

    public void notifyDataSetInvalidated() {
        this.dOe.getAdapter().notifyDataSetChanged();
    }

    public void setFromCDN(boolean z) {
        if (this.mAdapters != null && this.mAdapters.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.mAdapters) {
                if (aVar instanceof com.baidu.tieba.frs.g) {
                    ((com.baidu.tieba.frs.g) aVar).setFromCDN(z);
                }
            }
        }
    }

    public void b(com.baidu.tieba.tbadkCore.l lVar) {
        if (this.mAdapters != null && this.mAdapters.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.mAdapters) {
                if (aVar instanceof com.baidu.tieba.frs.g) {
                    ((com.baidu.tieba.frs.g) aVar).b(lVar);
                }
            }
        }
    }

    public void setOnAdapterItemClickListener(o oVar) {
        if (this.mAdapters != null && this.mAdapters.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.mAdapters) {
                if (aVar != null) {
                    if (aVar instanceof com.baidu.tieba.frs.g) {
                        ((com.baidu.tieba.frs.g) aVar).setOnAdapterItemClickListener(oVar);
                    } else if (aVar.getType() == bd.aOl) {
                        aVar.setOnAdapterItemClickListener(oVar);
                    }
                }
            }
        }
    }

    private void N(ArrayList<i> arrayList) {
        if (arrayList != null && arrayList.size() > 0) {
            Iterator<i> it = arrayList.iterator();
            while (it.hasNext()) {
                if (it.next().getType() == bd.aMX) {
                    it.remove();
                }
            }
        }
    }

    private void a(BdTypeRecyclerView bdTypeRecyclerView) {
        if (this.dOd != null && bdTypeRecyclerView != null && !b(bdTypeRecyclerView)) {
            this.dOd.registerListener(this.dGR);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v5, resolved type: com.baidu.tieba.frs.good.b */
    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public boolean b(BdTypeRecyclerView bdTypeRecyclerView) {
        if (this.dOd == null || bdTypeRecyclerView == null) {
            return false;
        }
        this.dGH = new ArrayList();
        ArrayList<BdUniqueId> buR = com.baidu.tieba.tbadkCore.q.buR();
        if (buR == null || buR.size() <= 0) {
            return false;
        }
        int size = buR.size();
        for (int i = 0; i < size; i++) {
            com.baidu.tieba.frs.g<ICardInfo, ? extends r.a> a = com.baidu.tieba.frs.a.atA().a(this.dOd.getPageContext(), buR.get(i), this.dOd.getUniqueId());
            if (a != null) {
                this.mAdapters.add(a);
                this.dGH.add(a);
            }
        }
        if (!v.E(this.dGH)) {
            bdTypeRecyclerView.addAdapters(this.dGH);
        }
        return true;
    }

    public boolean k(BdUniqueId bdUniqueId) {
        if (bdUniqueId == null) {
            return false;
        }
        for (com.baidu.adp.widget.ListView.a aVar : this.mAdapters) {
            if (aVar != null && aVar.getType() == bdUniqueId) {
                return true;
            }
        }
        return false;
    }
}
