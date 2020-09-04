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
/* loaded from: classes16.dex */
public class b {
    private BdTypeRecyclerView hYW;
    private ArrayList<q> hsy;
    private final HashMap<Integer, bw> idG;
    private FrsViewData idH;
    private FrsGoodFragment ind;
    private List<com.baidu.adp.widget.ListView.a> inx;
    private ArrayList<q> iny;
    private List<com.baidu.adp.widget.ListView.a> bbw = new LinkedList();
    private CustomMessageListener ibL = new CustomMessageListener(CmdConfigCustom.CMD_FRS_ADD_ADAPTER) { // from class: com.baidu.tieba.frs.good.b.1
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
                        ((k) aVar).a(b.this.ind.getPageContext(), b.this.ind.getUniqueId());
                    }
                }
                ArrayList arrayList = new ArrayList();
                arrayList.addAll(absDelegateAdapterList);
                if (b.this.bbw != null) {
                    b.this.bbw.addAll(arrayList);
                }
                if (b.this.hYW != null) {
                    b.this.hYW.addAdapters(arrayList);
                }
            }
        }
    };
    private CustomMessageListener inz = new CustomMessageListener(CmdConfigCustom.CMD_LEGO_REGISTER) { // from class: com.baidu.tieba.frs.good.b.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && y.isEmpty(b.this.inx)) {
                b.this.b(b.this.hYW);
                b.this.b(b.this.hsy, b.this.idH);
            }
        }
    };

    public b(FrsGoodFragment frsGoodFragment, BdTypeRecyclerView bdTypeRecyclerView) {
        a(frsGoodFragment, bdTypeRecyclerView);
        this.hYW = bdTypeRecyclerView;
        this.idG = new HashMap<>();
    }

    public void a(FrsGoodFragment frsGoodFragment, BdTypeRecyclerView bdTypeRecyclerView) {
        this.ind = frsGoodFragment;
        this.ibL.setPriority(1);
        this.ibL.setSelfListener(true);
        this.ind.registerListener(this.ibL);
        aa aaVar = new aa(frsGoodFragment.getTbPageContext(), bw.ebb, this.ind.getUniqueId());
        n nVar = new n(frsGoodFragment.getTbPageContext(), bw.ebc, this.ind.getUniqueId());
        x xVar = new x(frsGoodFragment.getTbPageContext(), bw.ebe, this.ind.getUniqueId());
        u uVar = new u(frsGoodFragment.getTbPageContext(), bw.ebf, this.ind.getUniqueId());
        m mVar = new m(frsGoodFragment.getTbPageContext(), bw.ebh, this.ind.getUniqueId());
        o oVar = new o(frsGoodFragment.getTbPageContext(), bw.ebi, this.ind.getUniqueId());
        ac acVar = new ac(frsGoodFragment.getTbPageContext(), bw.ebn, this.ind.getUniqueId());
        com.baidu.tieba.frs.entelechy.a.y yVar = new com.baidu.tieba.frs.entelechy.a.y(frsGoodFragment.getTbPageContext(), bw.ebF, this.ind.getUniqueId());
        w wVar = new w(frsGoodFragment.getTbPageContext(), bw.ebo, this.ind.getUniqueId());
        t tVar = new t(frsGoodFragment.getTbPageContext(), bw.ebp, this.ind.getUniqueId());
        ab abVar = new ab(frsGoodFragment.getPageContext(), bw.ebs, this.ind.getUniqueId());
        r rVar = new r(frsGoodFragment.getPageContext(), bw.ebq, this.ind.getUniqueId());
        v vVar = new v(frsGoodFragment.getPageContext(), bw.ebr, this.ind.getUniqueId());
        ab abVar2 = new ab(frsGoodFragment.getPageContext(), bw.ebA, this.ind.getUniqueId());
        com.baidu.tieba.frs.r rVar2 = new com.baidu.tieba.frs.r(frsGoodFragment.getPageContext(), s.hWr);
        com.baidu.adp.widget.ListView.a<? extends bv, ? extends af.a> a = e.clc().a(frsGoodFragment.getPageContext(), this.ind.getUniqueId(), true);
        com.baidu.adp.widget.ListView.a<? extends bw, ? extends af.a> b = e.clc().b(frsGoodFragment.getPageContext(), bw.edd, this.ind.getUniqueId());
        com.baidu.adp.widget.ListView.a<?, ?> a2 = com.baidu.tieba.recapp.r.dnk().a(this.ind, AdvertAppInfo.dVS);
        com.baidu.adp.widget.ListView.a<?, ?> a3 = com.baidu.tieba.recapp.r.dnk().a(this.ind, AdvertAppInfo.dWb);
        z zVar = new z(frsGoodFragment.getPageContext(), bw.ebw, this.ind.getUniqueId());
        com.baidu.tieba.frs.entelechy.a.b bVar = new com.baidu.tieba.frs.entelechy.a.b(frsGoodFragment.getPageContext(), bw.eby, this.ind.getUniqueId());
        h hVar = new h(frsGoodFragment.getPageContext(), bw.ebx, this.ind.getUniqueId());
        i iVar = new i(frsGoodFragment.getPageContext(), bw.ebz, this.ind.getUniqueId());
        this.bbw.add(aaVar);
        this.bbw.add(nVar);
        this.bbw.add(xVar);
        this.bbw.add(uVar);
        this.bbw.add(mVar);
        this.bbw.add(oVar);
        this.bbw.add(yVar);
        this.bbw.add(acVar);
        this.bbw.add(wVar);
        this.bbw.add(tVar);
        this.bbw.add(abVar);
        this.bbw.add(rVar);
        this.bbw.add(rVar);
        this.bbw.add(vVar);
        this.bbw.add(rVar2);
        this.bbw.add(abVar);
        this.bbw.add(abVar2);
        this.bbw.add(zVar);
        this.bbw.add(bVar);
        this.bbw.add(hVar);
        this.bbw.add(iVar);
        if (a != null) {
            this.bbw.add(a);
        }
        if (b != null) {
            this.bbw.add(b);
        }
        this.bbw.add(a2);
        this.bbw.add(a3);
        CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_ADD_ADAPTER, new AbsDelegateAdapterList());
        CustomMessage customMessage = new CustomMessage(CmdConfigCustom.CMD_FRS_ADD_ADAPTER);
        customMessage.setTag(this.ind.getUniqueId());
        customResponsedMessage.setOrginalMessage(customMessage);
        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
        a(bdTypeRecyclerView);
        com.baidu.tieba.InjectPlugin.b.b bVar2 = new com.baidu.tieba.InjectPlugin.b.b(this.ind, 1);
        bVar2.setExtraData(this.bbw);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_FEED_AD_PLUGIN_OPERATE, bVar2));
        bdTypeRecyclerView.addAdapters(this.bbw);
        Dk("page_frs_good");
        for (com.baidu.adp.widget.ListView.a aVar : this.bbw) {
            if (aVar instanceof com.baidu.tieba.card.z) {
                ((com.baidu.tieba.card.z) aVar).no(true);
            }
        }
    }

    public void onDestory() {
        for (com.baidu.adp.widget.ListView.a aVar : this.bbw) {
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
        cou();
        az(arrayList);
        com.baidu.tieba.tbadkCore.u.u(arrayList, 1);
        ay(arrayList);
        ArrayList<q> switchThreadDataToThreadCardInfo = frsViewData.switchThreadDataToThreadCardInfo();
        this.hYW.setData(switchThreadDataToThreadCardInfo);
        this.iny = switchThreadDataToThreadCardInfo;
        this.hsy = arrayList;
        this.idH = frsViewData;
        coY();
    }

    public void refreshData() {
        this.hYW.setData(this.iny);
        notifyDataSetChanged();
    }

    private void cou() {
        if (!y.isEmpty(this.bbw) && this.ind != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.bbw) {
                if (aVar instanceof k) {
                    ((k) aVar).a(this.ind.getTbPageTag());
                }
            }
        }
    }

    private void coY() {
        com.baidu.tieba.frs.d.b statisticMetaData;
        if (this.idH != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.bbw) {
                if ((aVar instanceof d) && (statisticMetaData = ((d) aVar).getStatisticMetaData()) != null) {
                    if (this.idH.needLog == 1) {
                        statisticMetaData.iqZ = true;
                    } else {
                        statisticMetaData.iqZ = false;
                    }
                    if (this.idH.getForum() != null) {
                        statisticMetaData.irb = this.idH.getForum().getId();
                    }
                    if (this.ind != null) {
                        statisticMetaData.ira = 5;
                    }
                }
            }
        }
    }

    private void ay(ArrayList<q> arrayList) {
        if (arrayList != null && arrayList.size() != 0) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < arrayList.size()) {
                    q qVar = arrayList.get(i2);
                    if ((qVar instanceof AdvertAppInfo) && this.idG != null && !this.idG.containsValue(qVar)) {
                        this.idG.put(Integer.valueOf(i2), (bw) qVar);
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    public HashMap<Integer, bw> cpI() {
        return this.idG;
    }

    public void cpN() {
        if (this.hYW != null && this.hYW.getData() != null && this.hYW.getData().size() != 0) {
            for (q qVar : this.hYW.getData()) {
                if ((qVar instanceof bv) && ((bv) qVar).dUW.bez() != 0) {
                    ((bv) qVar).dUW.bfC();
                }
            }
        }
    }

    public void crw() {
        for (com.baidu.adp.widget.ListView.a aVar : this.bbw) {
            if (aVar instanceof com.baidu.tieba.card.y) {
                ((com.baidu.tieba.card.y) aVar).tz(3);
            }
        }
    }

    public void notifyDataSetChanged() {
        this.hYW.getAdapter().notifyDataSetChanged();
    }

    public void onChangeSkinType(int i) {
    }

    public void notifyDataSetInvalidated() {
        this.hYW.getAdapter().notifyDataSetChanged();
    }

    public void setFromCDN(boolean z) {
        if (this.bbw != null && this.bbw.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.bbw) {
                if (aVar instanceof k) {
                    ((k) aVar).setFromCDN(z);
                }
            }
        }
    }

    public void b(FrsViewData frsViewData) {
        if (this.bbw != null && this.bbw.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.bbw) {
                if (aVar instanceof k) {
                    ((k) aVar).b(frsViewData);
                }
            }
        }
    }

    public void a(com.baidu.adp.widget.ListView.ab abVar) {
        if (this.bbw != null && this.bbw.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.bbw) {
                if (aVar != null && (aVar instanceof k)) {
                    ((k) aVar).a(abVar);
                }
            }
        }
    }

    private void az(ArrayList<q> arrayList) {
        if (arrayList != null && arrayList.size() > 0) {
            Iterator<q> it = arrayList.iterator();
            while (it.hasNext()) {
                if (it.next().getType() == bw.eaV) {
                    it.remove();
                }
            }
        }
    }

    private void a(BdTypeRecyclerView bdTypeRecyclerView) {
        if (this.ind != null && bdTypeRecyclerView != null && !b(bdTypeRecyclerView)) {
            this.ind.registerListener(this.inz);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v5, resolved type: com.baidu.tieba.frs.good.FrsGoodFragment */
    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public boolean b(BdTypeRecyclerView bdTypeRecyclerView) {
        if (this.ind == null || bdTypeRecyclerView == null) {
            return false;
        }
        this.inx = new ArrayList();
        ArrayList<BdUniqueId> dwb = com.baidu.tieba.tbadkCore.u.dwb();
        if (dwb == null || dwb.size() <= 0) {
            return false;
        }
        int size = dwb.size();
        for (int i = 0; i < size; i++) {
            k<ICardInfo, ? extends af.a> a = e.clc().a(this.ind.getPageContext(), dwb.get(i), this.ind.getUniqueId());
            if (a != null) {
                this.bbw.add(a);
                this.inx.add(a);
            }
        }
        if (!y.isEmpty(this.inx)) {
            bdTypeRecyclerView.addAdapters(this.inx);
        }
        return true;
    }

    public boolean s(BdUniqueId bdUniqueId) {
        if (bdUniqueId == null) {
            return false;
        }
        for (com.baidu.adp.widget.ListView.a aVar : this.bbw) {
            if (aVar != null && aVar.getType() == bdUniqueId) {
                return true;
            }
        }
        return false;
    }

    private void Dk(String str) {
        if (this.bbw != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.bbw) {
                if (aVar instanceof f) {
                    ((f) aVar).Dk(str);
                }
            }
        }
    }

    public List<q> getDataList() {
        return this.hsy;
    }

    public List<q> crx() {
        return this.iny;
    }
}
