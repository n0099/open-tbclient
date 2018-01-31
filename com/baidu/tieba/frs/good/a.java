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
    private l dGO;
    private j dGP;
    private p dGQ;
    private l dGR;
    private com.baidu.tieba.frs.entelechy.a.c dGS;
    private t dGV;
    private g dGW;
    private com.baidu.adp.widget.ListView.a dGX;
    private com.baidu.adp.widget.ListView.a dGY;
    private d dGZ;
    private d dHa;
    private com.baidu.tieba.frs.l dHb;
    private List<com.baidu.adp.widget.ListView.a> dHc;
    private final HashMap<Integer, bd> dHi;
    private com.baidu.tieba.tbadkCore.l dHj;
    private com.baidu.adp.widget.ListView.a dOA;
    private com.baidu.adp.widget.ListView.a dOB;
    private b dOy;
    private BdTypeRecyclerView dOz;
    private ArrayList<i> dln;
    private List<com.baidu.adp.widget.ListView.a> mAdapters = new LinkedList();
    private CustomMessageListener dHl = new CustomMessageListener(CmdConfigCustom.CMD_FRS_ADD_ADAPTER) { // from class: com.baidu.tieba.frs.good.a.1
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
                        ((com.baidu.tieba.frs.g) aVar).a(a.this.dOy.getPageContext(), a.this.dOy.getUniqueId());
                    }
                }
                ArrayList arrayList = new ArrayList();
                arrayList.addAll(absDelegateAdapterList);
                if (a.this.mAdapters != null) {
                    a.this.mAdapters.addAll(arrayList);
                }
                if (a.this.dOz != null) {
                    a.this.dOz.addAdapters(arrayList);
                }
            }
        }
    };
    private CustomMessageListener dHm = new CustomMessageListener(CmdConfigCustom.CMD_LEGO_REGISTER) { // from class: com.baidu.tieba.frs.good.a.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && v.E(a.this.dHc)) {
                a.this.b(a.this.dOz);
                a.this.b(a.this.dln, a.this.dHj);
            }
        }
    };

    public a(b bVar, BdTypeRecyclerView bdTypeRecyclerView) {
        a(bVar, bdTypeRecyclerView);
        this.dOz = bdTypeRecyclerView;
        this.dHi = new HashMap<>();
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v31, resolved type: com.baidu.tieba.frs.good.b */
    /* JADX WARN: Multi-variable type inference failed */
    public void a(b bVar, BdTypeRecyclerView bdTypeRecyclerView) {
        this.dOy = bVar;
        this.dHl.setPriority(1);
        this.dHl.setSelfListener(true);
        this.dOy.registerListener(this.dHl);
        this.dGO = new l(bVar.getPageContext(), bd.aNb, this.dOy.getUniqueId());
        this.dGO.setVoiceManager(bVar.getVoiceManager());
        this.dGP = new j(bVar.getPageContext(), bd.aNc, this.dOy.getUniqueId());
        this.dGR = new l(bVar.getPageContext(), bd.aNd, this.dOy.getUniqueId());
        this.dGR.setVoiceManager(bVar.getVoiceManager());
        this.dGV = new t(bVar.getPageContext(), bd.aNe, this.dOy.getUniqueId());
        this.dGW = new g(bVar.getPageContext(), bd.aNj, this.dOy.getUniqueId());
        this.dHb = new com.baidu.tieba.frs.l(bVar.getPageContext(), m.dDH);
        this.dGZ = new d(bVar.getPageContext(), bd.aNn, this.dOy.getUniqueId());
        this.dHa = new d(bVar.getPageContext(), bd.aNo, this.dOy.getUniqueId());
        this.dGX = com.baidu.tieba.frs.a.atF().a(bVar.getPageContext(), bd.aOp, this.dOy.getUniqueId(), true);
        this.dGY = com.baidu.tieba.frs.a.atF().b(bVar.getPageContext(), bd.aOw, this.dOy.getUniqueId());
        this.dOA = q.bmS().a(this.dOy, AdvertAppInfo.aIV);
        this.dOB = q.bmS().a(this.dOy, AdvertAppInfo.aJe);
        this.dGS = new com.baidu.tieba.frs.entelechy.a.c(bVar.getPageContext(), ar.aMx, this.dOy.getUniqueId());
        this.dGQ = new p(bVar.getPageContext(), bd.aNi, this.dOy.getUniqueId());
        this.mAdapters.add(this.dGO);
        this.mAdapters.add(this.dGP);
        this.mAdapters.add(this.dGO);
        this.mAdapters.add(this.dGP);
        this.mAdapters.add(this.dGR);
        this.mAdapters.add(this.dHb);
        this.mAdapters.add(this.dGV);
        this.mAdapters.add(this.dGW);
        this.mAdapters.add(this.dGZ);
        this.mAdapters.add(this.dHa);
        this.mAdapters.add(this.dGS);
        this.mAdapters.add(this.dGQ);
        if (this.dGX != null) {
            this.mAdapters.add(this.dGX);
        }
        if (this.dGY != null) {
            this.mAdapters.add(this.dGY);
        }
        this.mAdapters.add(this.dOA);
        this.mAdapters.add(this.dOB);
        com.baidu.adp.widget.ListView.a<? extends bd, ? extends r.a> b = com.baidu.tieba.frs.a.atF().b(this.dOy.getPageContext(), bd.aOo, this.dOy.getUniqueId());
        if (b != null) {
            this.mAdapters.add(b);
        }
        CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_ADD_ADAPTER, new AbsDelegateAdapterList());
        CustomMessage customMessage = new CustomMessage(CmdConfigCustom.CMD_FRS_ADD_ADAPTER);
        customMessage.setTag(this.dOy.getUniqueId());
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
        this.dOz.setData(arrayList);
        this.dln = arrayList;
        this.dHj = lVar;
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
                if (this.dHi != null && !this.dHi.containsValue(iVar)) {
                    this.dHi.put(Integer.valueOf(i2), (bd) iVar);
                }
            }
            i = i2 + 1;
        }
    }

    public HashMap<Integer, bd> awo() {
        return this.dHi;
    }

    public void awp() {
        if (this.dOz != null && this.dOz.getData() != null && this.dOz.getData().size() != 0) {
            for (i iVar : this.dOz.getData()) {
                if ((iVar instanceof bd) && ((bd) iVar).yO() != 0) {
                    ((bd) iVar).zC();
                }
            }
        }
    }

    public void notifyDataSetChanged() {
        this.dOz.getAdapter().notifyDataSetChanged();
    }

    public void onChangeSkinType(int i) {
    }

    public void notifyDataSetInvalidated() {
        this.dOz.getAdapter().notifyDataSetChanged();
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
                    } else if (aVar.getType() == bd.aOo) {
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
                if (it.next().getType() == bd.aNa) {
                    it.remove();
                }
            }
        }
    }

    private void a(BdTypeRecyclerView bdTypeRecyclerView) {
        if (this.dOy != null && bdTypeRecyclerView != null && !b(bdTypeRecyclerView)) {
            this.dOy.registerListener(this.dHm);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v5, resolved type: com.baidu.tieba.frs.good.b */
    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public boolean b(BdTypeRecyclerView bdTypeRecyclerView) {
        if (this.dOy == null || bdTypeRecyclerView == null) {
            return false;
        }
        this.dHc = new ArrayList();
        ArrayList<BdUniqueId> buT = com.baidu.tieba.tbadkCore.q.buT();
        if (buT == null || buT.size() <= 0) {
            return false;
        }
        int size = buT.size();
        for (int i = 0; i < size; i++) {
            com.baidu.tieba.frs.g<ICardInfo, ? extends r.a> a = com.baidu.tieba.frs.a.atF().a(this.dOy.getPageContext(), buT.get(i), this.dOy.getUniqueId());
            if (a != null) {
                this.mAdapters.add(a);
                this.dHc.add(a);
            }
        }
        if (!v.E(this.dHc)) {
            bdTypeRecyclerView.addAdapters(this.dHc);
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
