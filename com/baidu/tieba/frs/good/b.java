package com.baidu.tieba.frs.good;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.adp.widget.ListView.af;
import com.baidu.adp.widget.ListView.q;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.data.bv;
import com.baidu.tbadk.core.data.bw;
import com.baidu.tbadk.core.util.y;
import com.baidu.tieba.a.f;
import com.baidu.tieba.frs.AbsDelegateAdapterList;
import com.baidu.tieba.frs.d.d;
import com.baidu.tieba.frs.e;
import com.baidu.tieba.frs.entelechy.a.aa;
import com.baidu.tieba.frs.entelechy.a.ab;
import com.baidu.tieba.frs.entelechy.a.ac;
import com.baidu.tieba.frs.entelechy.a.h;
import com.baidu.tieba.frs.entelechy.a.i;
import com.baidu.tieba.frs.entelechy.a.m;
import com.baidu.tieba.frs.entelechy.a.n;
import com.baidu.tieba.frs.entelechy.a.o;
import com.baidu.tieba.frs.entelechy.a.r;
import com.baidu.tieba.frs.entelechy.a.t;
import com.baidu.tieba.frs.entelechy.a.u;
import com.baidu.tieba.frs.entelechy.a.v;
import com.baidu.tieba.frs.entelechy.a.w;
import com.baidu.tieba.frs.entelechy.a.x;
import com.baidu.tieba.frs.entelechy.a.z;
import com.baidu.tieba.frs.k;
import com.baidu.tieba.frs.s;
import com.baidu.tieba.lego.card.model.ICardInfo;
import com.baidu.tieba.tbadkCore.FrsViewData;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes22.dex */
public class b {
    private BdTypeRecyclerView iNq;
    private final HashMap<Integer, bw> iRW;
    private FrsViewData iRX;
    private ArrayList<q> igW;
    private FrsGoodFragment jbG;
    private List<com.baidu.adp.widget.ListView.a> jbZ;
    private ArrayList<q> jca;
    private List<com.baidu.adp.widget.ListView.a> bky = new LinkedList();
    private CustomMessageListener iQf = new CustomMessageListener(CmdConfigCustom.CMD_FRS_ADD_ADAPTER) { // from class: com.baidu.tieba.frs.good.b.1
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX DEBUG: Multi-variable search result rejected for r3v2, resolved type: com.baidu.tieba.frs.good.FrsGoodFragment */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2003008 && (customResponsedMessage.getData() instanceof AbsDelegateAdapterList)) {
                AbsDelegateAdapterList absDelegateAdapterList = (AbsDelegateAdapterList) customResponsedMessage.getData();
                Iterator it = absDelegateAdapterList.iterator();
                while (it.hasNext()) {
                    com.baidu.adp.widget.ListView.a aVar = (com.baidu.adp.widget.ListView.a) it.next();
                    if (aVar instanceof k) {
                        ((k) aVar).a(b.this.jbG.getPageContext(), b.this.jbG.getUniqueId());
                    }
                }
                ArrayList arrayList = new ArrayList();
                arrayList.addAll(absDelegateAdapterList);
                if (b.this.bky != null) {
                    b.this.bky.addAll(arrayList);
                }
                if (b.this.iNq != null) {
                    b.this.iNq.addAdapters(arrayList);
                }
            }
        }
    };
    private CustomMessageListener jcb = new CustomMessageListener(CmdConfigCustom.CMD_LEGO_REGISTER) { // from class: com.baidu.tieba.frs.good.b.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && y.isEmpty(b.this.jbZ)) {
                b.this.b(b.this.iNq);
                b.this.b(b.this.igW, b.this.iRX);
            }
        }
    };

    public b(FrsGoodFragment frsGoodFragment, BdTypeRecyclerView bdTypeRecyclerView) {
        a(frsGoodFragment, bdTypeRecyclerView);
        this.iNq = bdTypeRecyclerView;
        this.iRW = new HashMap<>();
    }

    public void a(FrsGoodFragment frsGoodFragment, BdTypeRecyclerView bdTypeRecyclerView) {
        this.jbG = frsGoodFragment;
        this.iQf.setPriority(1);
        this.iQf.setSelfListener(true);
        this.jbG.registerListener(this.iQf);
        aa aaVar = new aa(frsGoodFragment.getTbPageContext(), bw.eDF, this.jbG.getUniqueId());
        n nVar = new n(frsGoodFragment.getTbPageContext(), bw.eDG, this.jbG.getUniqueId());
        x xVar = new x(frsGoodFragment.getTbPageContext(), bw.eDI, this.jbG.getUniqueId());
        u uVar = new u(frsGoodFragment.getTbPageContext(), bw.eDJ, this.jbG.getUniqueId());
        m mVar = new m(frsGoodFragment.getTbPageContext(), bw.eDL, this.jbG.getUniqueId());
        o oVar = new o(frsGoodFragment.getTbPageContext(), bw.eDM, this.jbG.getUniqueId());
        ac acVar = new ac(frsGoodFragment.getTbPageContext(), bw.eDR, this.jbG.getUniqueId());
        com.baidu.tieba.frs.entelechy.a.y yVar = new com.baidu.tieba.frs.entelechy.a.y(frsGoodFragment.getTbPageContext(), bw.eEk, this.jbG.getUniqueId());
        w wVar = new w(frsGoodFragment.getTbPageContext(), bw.eDS, this.jbG.getUniqueId());
        t tVar = new t(frsGoodFragment.getTbPageContext(), bw.eDT, this.jbG.getUniqueId());
        ab abVar = new ab(frsGoodFragment.getPageContext(), bw.eDW, this.jbG.getUniqueId());
        r rVar = new r(frsGoodFragment.getPageContext(), bw.eDU, this.jbG.getUniqueId());
        v vVar = new v(frsGoodFragment.getPageContext(), bw.eDV, this.jbG.getUniqueId());
        ab abVar2 = new ab(frsGoodFragment.getPageContext(), bw.eEf, this.jbG.getUniqueId());
        com.baidu.tieba.frs.r rVar2 = new com.baidu.tieba.frs.r(frsGoodFragment.getPageContext(), s.iKL);
        com.baidu.adp.widget.ListView.a<? extends bv, ? extends af.a> a2 = e.cxv().a(frsGoodFragment.getPageContext(), this.jbG.getUniqueId(), true);
        com.baidu.adp.widget.ListView.a<? extends bw, ? extends af.a> b = e.cxv().b(frsGoodFragment.getPageContext(), bw.eFI, this.jbG.getUniqueId());
        com.baidu.adp.widget.ListView.a<?, ?> a3 = com.baidu.tieba.recapp.r.dAo().a(this.jbG, AdvertAppInfo.eyx);
        com.baidu.adp.widget.ListView.a<?, ?> a4 = com.baidu.tieba.recapp.r.dAo().a(this.jbG, AdvertAppInfo.eyG);
        z zVar = new z(frsGoodFragment.getPageContext(), bw.eEb, this.jbG.getUniqueId());
        com.baidu.tieba.frs.entelechy.a.b bVar = new com.baidu.tieba.frs.entelechy.a.b(frsGoodFragment.getPageContext(), bw.eEd, this.jbG.getUniqueId());
        h hVar = new h(frsGoodFragment.getPageContext(), bw.eEc, this.jbG.getUniqueId());
        i iVar = new i(frsGoodFragment.getPageContext(), bw.eEe, this.jbG.getUniqueId());
        this.bky.add(aaVar);
        this.bky.add(nVar);
        this.bky.add(xVar);
        this.bky.add(uVar);
        this.bky.add(mVar);
        this.bky.add(oVar);
        this.bky.add(yVar);
        this.bky.add(acVar);
        this.bky.add(wVar);
        this.bky.add(tVar);
        this.bky.add(abVar);
        this.bky.add(rVar);
        this.bky.add(rVar);
        this.bky.add(vVar);
        this.bky.add(rVar2);
        this.bky.add(abVar);
        this.bky.add(abVar2);
        this.bky.add(zVar);
        this.bky.add(bVar);
        this.bky.add(hVar);
        this.bky.add(iVar);
        if (a2 != null) {
            this.bky.add(a2);
        }
        if (b != null) {
            this.bky.add(b);
        }
        this.bky.add(a3);
        this.bky.add(a4);
        CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_ADD_ADAPTER, new AbsDelegateAdapterList());
        CustomMessage customMessage = new CustomMessage(CmdConfigCustom.CMD_FRS_ADD_ADAPTER);
        customMessage.setTag(this.jbG.getUniqueId());
        customResponsedMessage.setOrginalMessage(customMessage);
        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
        a(bdTypeRecyclerView);
        com.baidu.tieba.InjectPlugin.b.b bVar2 = new com.baidu.tieba.InjectPlugin.b.b(this.jbG, 1);
        bVar2.setExtraData(this.bky);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_FEED_AD_PLUGIN_OPERATE, bVar2));
        bdTypeRecyclerView.addAdapters(this.bky);
        EZ("page_frs_good");
        for (com.baidu.adp.widget.ListView.a aVar : this.bky) {
            if (aVar instanceof com.baidu.tieba.card.aa) {
                ((com.baidu.tieba.card.aa) aVar).oA(true);
            }
        }
    }

    public void onDestory() {
        for (com.baidu.adp.widget.ListView.a aVar : this.bky) {
            if (aVar instanceof k) {
                ((k) aVar).release();
            }
        }
    }

    public void b(ArrayList<q> arrayList, FrsViewData frsViewData) {
        if (frsViewData != null && arrayList != null && arrayList.size() == 1 && (arrayList.get(0) instanceof s)) {
            frsViewData.setThreadList(arrayList);
        }
        b(frsViewData);
        cAN();
        aC(arrayList);
        com.baidu.tieba.tbadkCore.u.x(arrayList, 1);
        aB(arrayList);
        ArrayList<q> switchThreadDataToThreadCardInfo = frsViewData.switchThreadDataToThreadCardInfo();
        this.iNq.setData(switchThreadDataToThreadCardInfo);
        this.jca = switchThreadDataToThreadCardInfo;
        this.igW = arrayList;
        this.iRX = frsViewData;
        cBq();
    }

    public void refreshData() {
        this.iNq.setData(this.jca);
        notifyDataSetChanged();
    }

    private void cAN() {
        if (!y.isEmpty(this.bky) && this.jbG != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.bky) {
                if (aVar instanceof k) {
                    ((k) aVar).a(this.jbG.getTbPageTag());
                }
            }
        }
    }

    private void cBq() {
        com.baidu.tieba.frs.d.b statisticMetaData;
        if (this.iRX != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.bky) {
                if ((aVar instanceof d) && (statisticMetaData = ((d) aVar).getStatisticMetaData()) != null) {
                    if (this.iRX.needLog == 1) {
                        statisticMetaData.jfB = true;
                    } else {
                        statisticMetaData.jfB = false;
                    }
                    if (this.iRX.getForum() != null) {
                        statisticMetaData.jfD = this.iRX.getForum().getId();
                    }
                    if (this.jbG != null) {
                        statisticMetaData.jfC = 5;
                    }
                }
            }
        }
    }

    private void aB(ArrayList<q> arrayList) {
        if (arrayList != null && arrayList.size() != 0) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < arrayList.size()) {
                    q qVar = arrayList.get(i2);
                    if ((qVar instanceof AdvertAppInfo) && this.iRW != null && !this.iRW.containsValue(qVar)) {
                        this.iRW.put(Integer.valueOf(i2), (bw) qVar);
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    public HashMap<Integer, bw> cCa() {
        return this.iRW;
    }

    public void cCf() {
        if (this.iNq != null && this.iNq.getData() != null && this.iNq.getData().size() != 0) {
            for (q qVar : this.iNq.getData()) {
                if ((qVar instanceof bv) && ((bv) qVar).exA.bmv() != 0) {
                    ((bv) qVar).exA.bny();
                }
            }
        }
    }

    public void cDQ() {
        for (com.baidu.adp.widget.ListView.a aVar : this.bky) {
            if (aVar instanceof com.baidu.tieba.card.z) {
                ((com.baidu.tieba.card.z) aVar).vd(3);
            }
        }
    }

    public void notifyDataSetChanged() {
        this.iNq.getAdapter().notifyDataSetChanged();
    }

    public void onChangeSkinType(int i) {
    }

    public void notifyDataSetInvalidated() {
        this.iNq.getAdapter().notifyDataSetChanged();
    }

    public void setFromCDN(boolean z) {
        if (this.bky != null && this.bky.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.bky) {
                if (aVar instanceof k) {
                    ((k) aVar).setFromCDN(z);
                }
            }
        }
    }

    public void b(FrsViewData frsViewData) {
        if (this.bky != null && this.bky.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.bky) {
                if (aVar instanceof k) {
                    ((k) aVar).b(frsViewData);
                }
            }
        }
    }

    public void a(com.baidu.adp.widget.ListView.ab abVar) {
        if (this.bky != null && this.bky.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.bky) {
                if (aVar != null && (aVar instanceof k)) {
                    ((k) aVar).a(abVar);
                }
            }
        }
    }

    private void aC(ArrayList<q> arrayList) {
        if (arrayList != null && arrayList.size() > 0) {
            Iterator<q> it = arrayList.iterator();
            while (it.hasNext()) {
                if (it.next().getType() == bw.eDz) {
                    it.remove();
                }
            }
        }
    }

    private void a(BdTypeRecyclerView bdTypeRecyclerView) {
        if (this.jbG != null && bdTypeRecyclerView != null && !b(bdTypeRecyclerView)) {
            this.jbG.registerListener(this.jcb);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v5, resolved type: com.baidu.tieba.frs.good.FrsGoodFragment */
    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public boolean b(BdTypeRecyclerView bdTypeRecyclerView) {
        if (this.jbG == null || bdTypeRecyclerView == null) {
            return false;
        }
        this.jbZ = new ArrayList();
        ArrayList<BdUniqueId> dJq = com.baidu.tieba.tbadkCore.u.dJq();
        if (dJq == null || dJq.size() <= 0) {
            return false;
        }
        int size = dJq.size();
        for (int i = 0; i < size; i++) {
            k<ICardInfo, ? extends af.a> a2 = e.cxv().a(this.jbG.getPageContext(), dJq.get(i), this.jbG.getUniqueId());
            if (a2 != null) {
                this.bky.add(a2);
                this.jbZ.add(a2);
            }
        }
        if (!y.isEmpty(this.jbZ)) {
            bdTypeRecyclerView.addAdapters(this.jbZ);
        }
        return true;
    }

    public boolean r(BdUniqueId bdUniqueId) {
        if (bdUniqueId == null) {
            return false;
        }
        for (com.baidu.adp.widget.ListView.a aVar : this.bky) {
            if (aVar != null && aVar.getType() == bdUniqueId) {
                return true;
            }
        }
        return false;
    }

    private void EZ(String str) {
        if (this.bky != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.bky) {
                if (aVar instanceof f) {
                    ((f) aVar).EZ(str);
                }
            }
        }
    }

    public List<q> getDataList() {
        return this.igW;
    }

    public List<q> cDR() {
        return this.jca;
    }
}
