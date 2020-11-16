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
import com.baidu.tbadk.core.data.bw;
import com.baidu.tbadk.core.data.bx;
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
/* loaded from: classes21.dex */
public class b {
    private BdTypeRecyclerView iOd;
    private final HashMap<Integer, bx> iSJ;
    private FrsViewData iSK;
    private ArrayList<q> ihK;
    private List<com.baidu.adp.widget.ListView.a> jcM;
    private ArrayList<q> jcN;
    private FrsGoodFragment jcs;
    private List<com.baidu.adp.widget.ListView.a> biN = new LinkedList();
    private CustomMessageListener iQS = new CustomMessageListener(CmdConfigCustom.CMD_FRS_ADD_ADAPTER) { // from class: com.baidu.tieba.frs.good.b.1
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
                        ((k) aVar).a(b.this.jcs.getPageContext(), b.this.jcs.getUniqueId());
                    }
                }
                ArrayList arrayList = new ArrayList();
                arrayList.addAll(absDelegateAdapterList);
                if (b.this.biN != null) {
                    b.this.biN.addAll(arrayList);
                }
                if (b.this.iOd != null) {
                    b.this.iOd.addAdapters(arrayList);
                }
            }
        }
    };
    private CustomMessageListener jcO = new CustomMessageListener(CmdConfigCustom.CMD_LEGO_REGISTER) { // from class: com.baidu.tieba.frs.good.b.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && y.isEmpty(b.this.jcM)) {
                b.this.b(b.this.iOd);
                b.this.b(b.this.ihK, b.this.iSK);
            }
        }
    };

    public b(FrsGoodFragment frsGoodFragment, BdTypeRecyclerView bdTypeRecyclerView) {
        a(frsGoodFragment, bdTypeRecyclerView);
        this.iOd = bdTypeRecyclerView;
        this.iSJ = new HashMap<>();
    }

    public void a(FrsGoodFragment frsGoodFragment, BdTypeRecyclerView bdTypeRecyclerView) {
        this.jcs = frsGoodFragment;
        this.iQS.setPriority(1);
        this.iQS.setSelfListener(true);
        this.jcs.registerListener(this.iQS);
        aa aaVar = new aa(frsGoodFragment.getTbPageContext(), bx.eBX, this.jcs.getUniqueId());
        n nVar = new n(frsGoodFragment.getTbPageContext(), bx.eBY, this.jcs.getUniqueId());
        x xVar = new x(frsGoodFragment.getTbPageContext(), bx.eCa, this.jcs.getUniqueId());
        u uVar = new u(frsGoodFragment.getTbPageContext(), bx.eCb, this.jcs.getUniqueId());
        m mVar = new m(frsGoodFragment.getTbPageContext(), bx.eCd, this.jcs.getUniqueId());
        o oVar = new o(frsGoodFragment.getTbPageContext(), bx.eCe, this.jcs.getUniqueId());
        ac acVar = new ac(frsGoodFragment.getTbPageContext(), bx.eCj, this.jcs.getUniqueId());
        com.baidu.tieba.frs.entelechy.a.y yVar = new com.baidu.tieba.frs.entelechy.a.y(frsGoodFragment.getTbPageContext(), bx.eCC, this.jcs.getUniqueId());
        w wVar = new w(frsGoodFragment.getTbPageContext(), bx.eCk, this.jcs.getUniqueId());
        t tVar = new t(frsGoodFragment.getTbPageContext(), bx.eCl, this.jcs.getUniqueId());
        ab abVar = new ab(frsGoodFragment.getPageContext(), bx.eCo, this.jcs.getUniqueId());
        r rVar = new r(frsGoodFragment.getPageContext(), bx.eCm, this.jcs.getUniqueId());
        v vVar = new v(frsGoodFragment.getPageContext(), bx.eCn, this.jcs.getUniqueId());
        ab abVar2 = new ab(frsGoodFragment.getPageContext(), bx.eCx, this.jcs.getUniqueId());
        com.baidu.tieba.frs.r rVar2 = new com.baidu.tieba.frs.r(frsGoodFragment.getPageContext(), s.iLy);
        com.baidu.adp.widget.ListView.a<? extends bw, ? extends af.a> a2 = e.cwX().a(frsGoodFragment.getPageContext(), this.jcs.getUniqueId(), true);
        com.baidu.adp.widget.ListView.a<? extends bx, ? extends af.a> b = e.cwX().b(frsGoodFragment.getPageContext(), bx.eEa, this.jcs.getUniqueId());
        com.baidu.adp.widget.ListView.a<?, ?> a3 = com.baidu.tieba.recapp.q.dzO().a(this.jcs, AdvertAppInfo.ewL);
        com.baidu.adp.widget.ListView.a<?, ?> a4 = com.baidu.tieba.recapp.q.dzO().a(this.jcs, AdvertAppInfo.ewU);
        z zVar = new z(frsGoodFragment.getPageContext(), bx.eCt, this.jcs.getUniqueId());
        com.baidu.tieba.frs.entelechy.a.b bVar = new com.baidu.tieba.frs.entelechy.a.b(frsGoodFragment.getPageContext(), bx.eCv, this.jcs.getUniqueId());
        h hVar = new h(frsGoodFragment.getPageContext(), bx.eCu, this.jcs.getUniqueId());
        i iVar = new i(frsGoodFragment.getPageContext(), bx.eCw, this.jcs.getUniqueId());
        this.biN.add(aaVar);
        this.biN.add(nVar);
        this.biN.add(xVar);
        this.biN.add(uVar);
        this.biN.add(mVar);
        this.biN.add(oVar);
        this.biN.add(yVar);
        this.biN.add(acVar);
        this.biN.add(wVar);
        this.biN.add(tVar);
        this.biN.add(abVar);
        this.biN.add(rVar);
        this.biN.add(rVar);
        this.biN.add(vVar);
        this.biN.add(rVar2);
        this.biN.add(abVar);
        this.biN.add(abVar2);
        this.biN.add(zVar);
        this.biN.add(bVar);
        this.biN.add(hVar);
        this.biN.add(iVar);
        if (a2 != null) {
            this.biN.add(a2);
        }
        if (b != null) {
            this.biN.add(b);
        }
        this.biN.add(a3);
        this.biN.add(a4);
        CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_ADD_ADAPTER, new AbsDelegateAdapterList());
        CustomMessage customMessage = new CustomMessage(CmdConfigCustom.CMD_FRS_ADD_ADAPTER);
        customMessage.setTag(this.jcs.getUniqueId());
        customResponsedMessage.setOrginalMessage(customMessage);
        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
        a(bdTypeRecyclerView);
        com.baidu.tieba.InjectPlugin.b.b bVar2 = new com.baidu.tieba.InjectPlugin.b.b(this.jcs, 1);
        bVar2.setExtraData(this.biN);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_FEED_AD_PLUGIN_OPERATE, bVar2));
        bdTypeRecyclerView.addAdapters(this.biN);
        EA("page_frs_good");
        for (com.baidu.adp.widget.ListView.a aVar : this.biN) {
            if (aVar instanceof com.baidu.tieba.card.aa) {
                ((com.baidu.tieba.card.aa) aVar).oD(true);
            }
        }
    }

    public void onDestory() {
        for (com.baidu.adp.widget.ListView.a aVar : this.biN) {
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
        cAq();
        aD(arrayList);
        com.baidu.tieba.tbadkCore.u.x(arrayList, 1);
        aC(arrayList);
        ArrayList<q> switchThreadDataToThreadCardInfo = frsViewData.switchThreadDataToThreadCardInfo();
        this.iOd.setData(switchThreadDataToThreadCardInfo);
        this.jcN = switchThreadDataToThreadCardInfo;
        this.ihK = arrayList;
        this.iSK = frsViewData;
        cAT();
    }

    public void refreshData() {
        this.iOd.setData(this.jcN);
        notifyDataSetChanged();
    }

    private void cAq() {
        if (!y.isEmpty(this.biN) && this.jcs != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.biN) {
                if (aVar instanceof k) {
                    ((k) aVar).a(this.jcs.getTbPageTag());
                }
            }
        }
    }

    private void cAT() {
        com.baidu.tieba.frs.d.b statisticMetaData;
        if (this.iSK != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.biN) {
                if ((aVar instanceof d) && (statisticMetaData = ((d) aVar).getStatisticMetaData()) != null) {
                    if (this.iSK.needLog == 1) {
                        statisticMetaData.jgm = true;
                    } else {
                        statisticMetaData.jgm = false;
                    }
                    if (this.iSK.getForum() != null) {
                        statisticMetaData.jgo = this.iSK.getForum().getId();
                    }
                    if (this.jcs != null) {
                        statisticMetaData.jgn = 5;
                    }
                }
            }
        }
    }

    private void aC(ArrayList<q> arrayList) {
        if (arrayList != null && arrayList.size() != 0) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < arrayList.size()) {
                    q qVar = arrayList.get(i2);
                    if ((qVar instanceof AdvertAppInfo) && this.iSJ != null && !this.iSJ.containsValue(qVar)) {
                        this.iSJ.put(Integer.valueOf(i2), (bx) qVar);
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    public HashMap<Integer, bx> cBD() {
        return this.iSJ;
    }

    public void cBI() {
        if (this.iOd != null && this.iOd.getData() != null && this.iOd.getData().size() != 0) {
            for (q qVar : this.iOd.getData()) {
                if ((qVar instanceof bw) && ((bw) qVar).evQ.blx() != 0) {
                    ((bw) qVar).evQ.bmC();
                }
            }
        }
    }

    public void cDu() {
        for (com.baidu.adp.widget.ListView.a aVar : this.biN) {
            if (aVar instanceof com.baidu.tieba.card.z) {
                ((com.baidu.tieba.card.z) aVar).vB(3);
            }
        }
    }

    public void notifyDataSetChanged() {
        this.iOd.getAdapter().notifyDataSetChanged();
    }

    public void onChangeSkinType(int i) {
    }

    public void notifyDataSetInvalidated() {
        this.iOd.getAdapter().notifyDataSetChanged();
    }

    public void setFromCDN(boolean z) {
        if (this.biN != null && this.biN.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.biN) {
                if (aVar instanceof k) {
                    ((k) aVar).setFromCDN(z);
                }
            }
        }
    }

    public void b(FrsViewData frsViewData) {
        if (this.biN != null && this.biN.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.biN) {
                if (aVar instanceof k) {
                    ((k) aVar).b(frsViewData);
                }
            }
        }
    }

    public void a(com.baidu.adp.widget.ListView.ab abVar) {
        if (this.biN != null && this.biN.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.biN) {
                if (aVar != null && (aVar instanceof k)) {
                    ((k) aVar).a(abVar);
                }
            }
        }
    }

    private void aD(ArrayList<q> arrayList) {
        if (arrayList != null && arrayList.size() > 0) {
            Iterator<q> it = arrayList.iterator();
            while (it.hasNext()) {
                if (it.next().getType() == bx.eBQ) {
                    it.remove();
                }
            }
        }
    }

    private void a(BdTypeRecyclerView bdTypeRecyclerView) {
        if (this.jcs != null && bdTypeRecyclerView != null && !b(bdTypeRecyclerView)) {
            this.jcs.registerListener(this.jcO);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v5, resolved type: com.baidu.tieba.frs.good.FrsGoodFragment */
    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public boolean b(BdTypeRecyclerView bdTypeRecyclerView) {
        if (this.jcs == null || bdTypeRecyclerView == null) {
            return false;
        }
        this.jcM = new ArrayList();
        ArrayList<BdUniqueId> dJh = com.baidu.tieba.tbadkCore.u.dJh();
        if (dJh == null || dJh.size() <= 0) {
            return false;
        }
        int size = dJh.size();
        for (int i = 0; i < size; i++) {
            k<ICardInfo, ? extends af.a> a2 = e.cwX().a(this.jcs.getPageContext(), dJh.get(i), this.jcs.getUniqueId());
            if (a2 != null) {
                this.biN.add(a2);
                this.jcM.add(a2);
            }
        }
        if (!y.isEmpty(this.jcM)) {
            bdTypeRecyclerView.addAdapters(this.jcM);
        }
        return true;
    }

    public boolean r(BdUniqueId bdUniqueId) {
        if (bdUniqueId == null) {
            return false;
        }
        for (com.baidu.adp.widget.ListView.a aVar : this.biN) {
            if (aVar != null && aVar.getType() == bdUniqueId) {
                return true;
            }
        }
        return false;
    }

    private void EA(String str) {
        if (this.biN != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.biN) {
                if (aVar instanceof f) {
                    ((f) aVar).EA(str);
                }
            }
        }
    }

    public List<q> getDataList() {
        return this.ihK;
    }

    public List<q> cDv() {
        return this.jcN;
    }
}
