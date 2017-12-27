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
import com.baidu.tbadk.core.data.as;
import com.baidu.tbadk.core.data.be;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.frs.AbsDelegateAdapterList;
import com.baidu.tieba.frs.entelechy.a.d;
import com.baidu.tieba.frs.entelechy.a.g;
import com.baidu.tieba.frs.entelechy.a.j;
import com.baidu.tieba.frs.entelechy.a.l;
import com.baidu.tieba.frs.entelechy.a.p;
import com.baidu.tieba.frs.entelechy.a.t;
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
    private l dBS;
    private j dBT;
    private p dBU;
    private l dBV;
    private com.baidu.tieba.frs.entelechy.a.c dBW;
    private t dBZ;
    private g dCa;
    private com.baidu.adp.widget.ListView.a dCb;
    private com.baidu.adp.widget.ListView.a dCc;
    private d dCd;
    private d dCe;
    private com.baidu.tieba.frs.l dCf;
    private List<com.baidu.adp.widget.ListView.a> dCg;
    private final HashMap<Integer, be> dCm;
    private com.baidu.tieba.tbadkCore.l dCn;
    private b dJB;
    private BdTypeRecyclerView dJC;
    private com.baidu.adp.widget.ListView.a dJD;
    private com.baidu.adp.widget.ListView.a dJE;
    private ArrayList<i> dgq;
    private List<com.baidu.adp.widget.ListView.a> mAdapters = new LinkedList();
    private CustomMessageListener dCp = new CustomMessageListener(CmdConfigCustom.CMD_FRS_ADD_ADAPTER) { // from class: com.baidu.tieba.frs.good.a.1
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
                        ((com.baidu.tieba.frs.g) aVar).a(a.this.dJB.getPageContext(), a.this.dJB.getUniqueId());
                    }
                }
                ArrayList arrayList = new ArrayList();
                arrayList.addAll(absDelegateAdapterList);
                if (a.this.mAdapters != null) {
                    a.this.mAdapters.addAll(arrayList);
                }
                if (a.this.dJC != null) {
                    a.this.dJC.addAdapters(arrayList);
                }
            }
        }
    };
    private CustomMessageListener dCq = new CustomMessageListener(CmdConfigCustom.CMD_LEGO_REGISTER) { // from class: com.baidu.tieba.frs.good.a.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && v.G(a.this.dCg)) {
                a.this.b(a.this.dJC);
                a.this.b(a.this.dgq, a.this.dCn);
            }
        }
    };

    public a(b bVar, BdTypeRecyclerView bdTypeRecyclerView) {
        a(bVar, bdTypeRecyclerView);
        this.dJC = bdTypeRecyclerView;
        this.dCm = new HashMap<>();
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v31, resolved type: com.baidu.tieba.frs.good.b */
    /* JADX WARN: Multi-variable type inference failed */
    public void a(b bVar, BdTypeRecyclerView bdTypeRecyclerView) {
        this.dJB = bVar;
        this.dCp.setPriority(1);
        this.dCp.setSelfListener(true);
        this.dJB.registerListener(this.dCp);
        this.dBS = new l(bVar.getPageContext(), be.aNc, this.dJB.getUniqueId());
        this.dBS.setVoiceManager(bVar.getVoiceManager());
        this.dBT = new j(bVar.getPageContext(), be.aNd, this.dJB.getUniqueId());
        this.dBV = new l(bVar.getPageContext(), be.aNe, this.dJB.getUniqueId());
        this.dBV.setVoiceManager(bVar.getVoiceManager());
        this.dBZ = new t(bVar.getPageContext(), be.aNf, this.dJB.getUniqueId());
        this.dCa = new g(bVar.getPageContext(), be.aNk, this.dJB.getUniqueId());
        this.dCf = new com.baidu.tieba.frs.l(bVar.getPageContext(), m.dyL);
        this.dCd = new d(bVar.getPageContext(), be.aNo, this.dJB.getUniqueId());
        this.dCe = new d(bVar.getPageContext(), be.aNp, this.dJB.getUniqueId());
        this.dCb = com.baidu.tieba.frs.a.asx().a(bVar.getPageContext(), be.aOq, this.dJB.getUniqueId(), true);
        this.dCc = com.baidu.tieba.frs.a.asx().b(bVar.getPageContext(), be.aOv, this.dJB.getUniqueId());
        this.dJD = q.bty().a(this.dJB, AdvertAppInfo.aIU);
        this.dJE = q.bty().a(this.dJB, AdvertAppInfo.aJd);
        this.dBW = new com.baidu.tieba.frs.entelechy.a.c(bVar.getPageContext(), as.aMy, this.dJB.getUniqueId());
        this.dBU = new p(bVar.getPageContext(), be.aNj, this.dJB.getUniqueId());
        this.mAdapters.add(this.dBS);
        this.mAdapters.add(this.dBT);
        this.mAdapters.add(this.dBS);
        this.mAdapters.add(this.dBT);
        this.mAdapters.add(this.dBV);
        this.mAdapters.add(this.dCf);
        this.mAdapters.add(this.dBZ);
        this.mAdapters.add(this.dCa);
        this.mAdapters.add(this.dCd);
        this.mAdapters.add(this.dCe);
        this.mAdapters.add(this.dBW);
        this.mAdapters.add(this.dBU);
        if (this.dCb != null) {
            this.mAdapters.add(this.dCb);
        }
        if (this.dCc != null) {
            this.mAdapters.add(this.dCc);
        }
        this.mAdapters.add(this.dJD);
        this.mAdapters.add(this.dJE);
        com.baidu.adp.widget.ListView.a<? extends be, ? extends r.a> b = com.baidu.tieba.frs.a.asx().b(this.dJB.getPageContext(), be.aOp, this.dJB.getUniqueId());
        if (b != null) {
            this.mAdapters.add(b);
        }
        CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_ADD_ADAPTER, new AbsDelegateAdapterList());
        CustomMessage customMessage = new CustomMessage(CmdConfigCustom.CMD_FRS_ADD_ADAPTER);
        customMessage.setTag(this.dJB.getUniqueId());
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
        this.dJC.setData(arrayList);
        this.dgq = arrayList;
        this.dCn = lVar;
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
                if (this.dCm != null && !this.dCm.containsValue(iVar)) {
                    this.dCm.put(Integer.valueOf(i2), (be) iVar);
                }
            }
            i = i2 + 1;
        }
    }

    public HashMap<Integer, be> avg() {
        return this.dCm;
    }

    public void avh() {
        if (this.dJC != null && this.dJC.getData() != null && this.dJC.getData().size() != 0) {
            for (i iVar : this.dJC.getData()) {
                if ((iVar instanceof be) && ((be) iVar).yS() != 0) {
                    ((be) iVar).zF();
                }
            }
        }
    }

    public void notifyDataSetChanged() {
        this.dJC.getAdapter().notifyDataSetChanged();
    }

    public void onChangeSkinType(int i) {
    }

    public void notifyDataSetInvalidated() {
        this.dJC.getAdapter().notifyDataSetChanged();
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
                    } else if (aVar.getType() == be.aOp) {
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
                if (it.next().getType() == be.aNb) {
                    it.remove();
                }
            }
        }
    }

    private void a(BdTypeRecyclerView bdTypeRecyclerView) {
        if (this.dJB != null && bdTypeRecyclerView != null && !b(bdTypeRecyclerView)) {
            this.dJB.registerListener(this.dCq);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v5, resolved type: com.baidu.tieba.frs.good.b */
    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public boolean b(BdTypeRecyclerView bdTypeRecyclerView) {
        if (this.dJB == null || bdTypeRecyclerView == null) {
            return false;
        }
        this.dCg = new ArrayList();
        ArrayList<BdUniqueId> bBv = com.baidu.tieba.tbadkCore.q.bBv();
        if (bBv == null || bBv.size() <= 0) {
            return false;
        }
        int size = bBv.size();
        for (int i = 0; i < size; i++) {
            com.baidu.tieba.frs.g<ICardInfo, ? extends r.a> a = com.baidu.tieba.frs.a.asx().a(this.dJB.getPageContext(), bBv.get(i), this.dJB.getUniqueId());
            if (a != null) {
                this.mAdapters.add(a);
                this.dCg.add(a);
            }
        }
        if (!v.G(this.dCg)) {
            bdTypeRecyclerView.addAdapters(this.dCg);
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
