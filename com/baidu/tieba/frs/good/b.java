package com.baidu.tieba.frs.good;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.adp.widget.ListView.n;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.data.ca;
import com.baidu.tbadk.core.data.cb;
import com.baidu.tbadk.core.util.y;
import com.baidu.tieba.a.f;
import com.baidu.tieba.frs.AbsDelegateAdapterList;
import com.baidu.tieba.frs.b.d;
import com.baidu.tieba.frs.e;
import com.baidu.tieba.frs.entelechy.adapter.aa;
import com.baidu.tieba.frs.entelechy.adapter.ab;
import com.baidu.tieba.frs.entelechy.adapter.ac;
import com.baidu.tieba.frs.entelechy.adapter.ad;
import com.baidu.tieba.frs.entelechy.adapter.ae;
import com.baidu.tieba.frs.entelechy.adapter.g;
import com.baidu.tieba.frs.entelechy.adapter.i;
import com.baidu.tieba.frs.entelechy.adapter.j;
import com.baidu.tieba.frs.entelechy.adapter.o;
import com.baidu.tieba.frs.entelechy.adapter.q;
import com.baidu.tieba.frs.entelechy.adapter.t;
import com.baidu.tieba.frs.entelechy.adapter.v;
import com.baidu.tieba.frs.entelechy.adapter.w;
import com.baidu.tieba.frs.entelechy.adapter.x;
import com.baidu.tieba.frs.entelechy.adapter.z;
import com.baidu.tieba.frs.k;
import com.baidu.tieba.frs.r;
import com.baidu.tieba.frs.s;
import com.baidu.tieba.lego.card.model.ICardInfo;
import com.baidu.tieba.tbadkCore.FrsViewData;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes2.dex */
public class b {
    private ArrayList<n> iHS;
    private List<com.baidu.adp.widget.ListView.a> jFJ;
    private ArrayList<n> jFK;
    private FrsGoodFragment jFr;
    private BdTypeRecyclerView joh;
    private final HashMap<Integer, cb> jtc;
    private FrsViewData jtd;
    private List<com.baidu.adp.widget.ListView.a> boS = new LinkedList();
    private CustomMessageListener jqY = new CustomMessageListener(CmdConfigCustom.CMD_FRS_ADD_ADAPTER) { // from class: com.baidu.tieba.frs.good.b.1
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
                        ((k) aVar).a(b.this.jFr.getPageContext(), b.this.jFr.getUniqueId());
                    }
                }
                ArrayList arrayList = new ArrayList();
                arrayList.addAll(absDelegateAdapterList);
                if (b.this.boS != null) {
                    b.this.boS.addAll(arrayList);
                }
                if (b.this.joh != null) {
                    b.this.joh.addAdapters(arrayList);
                }
            }
        }
    };
    private CustomMessageListener jFL = new CustomMessageListener(CmdConfigCustom.CMD_LEGO_REGISTER) { // from class: com.baidu.tieba.frs.good.b.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && y.isEmpty(b.this.jFJ)) {
                b.this.g(b.this.joh);
                b.this.b(b.this.iHS, b.this.jtd);
            }
        }
    };

    public b(FrsGoodFragment frsGoodFragment, BdTypeRecyclerView bdTypeRecyclerView) {
        a(frsGoodFragment, bdTypeRecyclerView);
        this.joh = bdTypeRecyclerView;
        this.jtc = new HashMap<>();
    }

    public void a(FrsGoodFragment frsGoodFragment, BdTypeRecyclerView bdTypeRecyclerView) {
        this.jFr = frsGoodFragment;
        this.jqY.setPriority(1);
        this.jqY.setSelfListener(true);
        this.jFr.registerListener(this.jqY);
        ac acVar = new ac(frsGoodFragment.getTbPageContext(), cb.eRT, this.jFr.getUniqueId());
        o oVar = new o(frsGoodFragment.getTbPageContext(), cb.eRU, this.jFr.getUniqueId());
        z zVar = new z(frsGoodFragment.getTbPageContext(), cb.eRW, this.jFr.getUniqueId());
        w wVar = new w(frsGoodFragment.getTbPageContext(), cb.eRX, this.jFr.getUniqueId());
        com.baidu.tieba.frs.entelechy.adapter.n nVar = new com.baidu.tieba.frs.entelechy.adapter.n(frsGoodFragment.getTbPageContext(), cb.eRZ, this.jFr.getUniqueId());
        q qVar = new q(frsGoodFragment.getTbPageContext(), cb.eSa, this.jFr.getUniqueId());
        ae aeVar = new ae(frsGoodFragment.getTbPageContext(), cb.eSf, this.jFr.getUniqueId());
        aa aaVar = new aa(frsGoodFragment.getTbPageContext(), cb.eSz, this.jFr.getUniqueId());
        com.baidu.tieba.frs.entelechy.adapter.y yVar = new com.baidu.tieba.frs.entelechy.adapter.y(frsGoodFragment.getTbPageContext(), cb.eSg, this.jFr.getUniqueId());
        v vVar = new v(frsGoodFragment.getTbPageContext(), cb.eSh, this.jFr.getUniqueId());
        ad adVar = new ad(frsGoodFragment.getPageContext(), cb.eSl, this.jFr.getUniqueId());
        t tVar = new t(frsGoodFragment.getPageContext(), cb.eSj, this.jFr.getUniqueId());
        x xVar = new x(frsGoodFragment.getPageContext(), cb.eSk, this.jFr.getUniqueId());
        ad adVar2 = new ad(frsGoodFragment.getPageContext(), cb.eSu, this.jFr.getUniqueId());
        r rVar = new r(frsGoodFragment.getPageContext(), s.jlC);
        com.baidu.adp.widget.ListView.a<? extends ca, ? extends TypeAdapter.ViewHolder> a2 = e.cBN().a(frsGoodFragment.getPageContext(), this.jFr.getUniqueId(), true);
        com.baidu.adp.widget.ListView.a<? extends cb, ? extends TypeAdapter.ViewHolder> b = e.cBN().b(frsGoodFragment.getPageContext(), cb.eTY, this.jFr.getUniqueId());
        com.baidu.adp.widget.ListView.a<?, ?> a3 = com.baidu.tieba.recapp.s.dDB().a(this.jFr, AdvertAppInfo.eMB);
        com.baidu.adp.widget.ListView.a<?, ?> a4 = com.baidu.tieba.recapp.s.dDB().a(this.jFr, AdvertAppInfo.eMK);
        ab abVar = new ab(frsGoodFragment.getPageContext(), cb.eSq, this.jFr.getUniqueId());
        com.baidu.tieba.frs.entelechy.adapter.b bVar = new com.baidu.tieba.frs.entelechy.adapter.b(frsGoodFragment.getPageContext(), cb.eSs, this.jFr.getUniqueId());
        i iVar = new i(frsGoodFragment.getPageContext(), cb.eSr, this.jFr.getUniqueId());
        j jVar = new j(frsGoodFragment.getPageContext(), cb.eSt, this.jFr.getUniqueId());
        g gVar = new g(frsGoodFragment.getPageContext(), cb.eSe, this.jFr.getUniqueId());
        gVar.a(bdTypeRecyclerView);
        this.boS.add(acVar);
        this.boS.add(oVar);
        this.boS.add(zVar);
        this.boS.add(wVar);
        this.boS.add(nVar);
        this.boS.add(qVar);
        this.boS.add(aaVar);
        this.boS.add(aeVar);
        this.boS.add(yVar);
        this.boS.add(vVar);
        this.boS.add(adVar);
        this.boS.add(tVar);
        this.boS.add(tVar);
        this.boS.add(xVar);
        this.boS.add(rVar);
        this.boS.add(adVar);
        this.boS.add(adVar2);
        this.boS.add(abVar);
        this.boS.add(bVar);
        this.boS.add(iVar);
        this.boS.add(jVar);
        this.boS.add(gVar);
        if (a2 != null) {
            this.boS.add(a2);
        }
        if (b != null) {
            this.boS.add(b);
        }
        this.boS.add(a3);
        this.boS.add(a4);
        CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_ADD_ADAPTER, new AbsDelegateAdapterList());
        CustomMessage customMessage = new CustomMessage(CmdConfigCustom.CMD_FRS_ADD_ADAPTER);
        customMessage.setTag(this.jFr.getUniqueId());
        customResponsedMessage.setOrginalMessage(customMessage);
        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
        f(bdTypeRecyclerView);
        this.boS.add(com.baidu.tieba.h.b.cNB().c(this.jFr.getBaseFragmentActivity(), AdvertAppInfo.eMN));
        this.boS.add(com.baidu.tieba.h.b.cNB().c(this.jFr.getBaseFragmentActivity(), AdvertAppInfo.eMM));
        com.baidu.tieba.InjectPlugin.b.b bVar2 = new com.baidu.tieba.InjectPlugin.b.b(this.jFr, 1);
        bVar2.setExtraData(this.boS);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_FEED_AD_PLUGIN_OPERATE, bVar2));
        bdTypeRecyclerView.addAdapters(this.boS);
        ED("page_frs_good");
        for (com.baidu.adp.widget.ListView.a aVar : this.boS) {
            if (aVar instanceof com.baidu.tieba.card.aa) {
                ((com.baidu.tieba.card.aa) aVar).pD(true);
            }
        }
    }

    public void onDestory() {
        for (com.baidu.adp.widget.ListView.a aVar : this.boS) {
            if (aVar instanceof k) {
                ((k) aVar).release();
            }
        }
        MessageManager.getInstance().unRegisterListener(this.jqY);
    }

    public void b(ArrayList<n> arrayList, FrsViewData frsViewData) {
        if (frsViewData != null && arrayList != null && arrayList.size() == 1 && (arrayList.get(0) instanceof s)) {
            frsViewData.setThreadList(arrayList);
        }
        b(frsViewData);
        cFk();
        az(arrayList);
        com.baidu.tieba.tbadkCore.v.x(arrayList, 1);
        ay(arrayList);
        ArrayList<n> switchThreadDataToThreadCardInfo = frsViewData.switchThreadDataToThreadCardInfo();
        this.joh.setData(switchThreadDataToThreadCardInfo);
        this.jFK = switchThreadDataToThreadCardInfo;
        this.iHS = arrayList;
        this.jtd = frsViewData;
        cFO();
    }

    public void refreshData() {
        this.joh.setData(this.jFK);
        notifyDataSetChanged();
    }

    private void cFk() {
        if (!y.isEmpty(this.boS) && this.jFr != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.boS) {
                if (aVar instanceof k) {
                    ((k) aVar).a(this.jFr.getTbPageTag());
                }
            }
        }
    }

    private void cFO() {
        com.baidu.tieba.frs.b.b statisticMetaData;
        if (this.jtd != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.boS) {
                if ((aVar instanceof d) && (statisticMetaData = ((d) aVar).getStatisticMetaData()) != null) {
                    if (this.jtd.needLog == 1) {
                        statisticMetaData.jJh = true;
                    } else {
                        statisticMetaData.jJh = false;
                    }
                    if (this.jtd.getForum() != null) {
                        statisticMetaData.jJj = this.jtd.getForum().getId();
                    }
                    if (this.jFr != null) {
                        statisticMetaData.jJi = 5;
                    }
                }
            }
        }
    }

    private void ay(ArrayList<n> arrayList) {
        if (arrayList != null && arrayList.size() != 0) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < arrayList.size()) {
                    n nVar = arrayList.get(i2);
                    if ((nVar instanceof AdvertAppInfo) && this.jtc != null && !this.jtc.containsValue(nVar)) {
                        this.jtc.put(Integer.valueOf(i2), (cb) nVar);
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    public HashMap<Integer, cb> cGF() {
        return this.jtc;
    }

    public void cGK() {
        if (this.joh != null && this.joh.getData() != null && this.joh.getData().size() != 0) {
            for (n nVar : this.joh.getData()) {
                if ((nVar instanceof ca) && ((ca) nVar).eLr.bnN() != 0) {
                    ((ca) nVar).eLr.boR();
                }
            }
        }
    }

    public void cJr() {
        for (com.baidu.adp.widget.ListView.a aVar : this.boS) {
            if (aVar instanceof com.baidu.tieba.card.z) {
                ((com.baidu.tieba.card.z) aVar).uZ(3);
            }
        }
    }

    public void notifyDataSetChanged() {
        this.joh.getAdapter().notifyDataSetChanged();
    }

    public void onChangeSkinType(int i) {
    }

    public void notifyDataSetInvalidated() {
        this.joh.getAdapter().notifyDataSetChanged();
    }

    public void setFromCDN(boolean z) {
        if (this.boS != null && this.boS.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.boS) {
                if (aVar instanceof k) {
                    ((k) aVar).setFromCDN(z);
                }
            }
        }
    }

    public void b(FrsViewData frsViewData) {
        if (this.boS != null && this.boS.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.boS) {
                if (aVar instanceof k) {
                    ((k) aVar).b(frsViewData);
                }
            }
        }
    }

    public void a(com.baidu.adp.widget.ListView.w wVar) {
        if (this.boS != null && this.boS.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.boS) {
                if (aVar != null && (aVar instanceof k)) {
                    ((k) aVar).a(wVar);
                }
            }
        }
    }

    private void az(ArrayList<n> arrayList) {
        if (arrayList != null && arrayList.size() > 0) {
            Iterator<n> it = arrayList.iterator();
            while (it.hasNext()) {
                if (it.next().getType() == cb.eRM) {
                    it.remove();
                }
            }
        }
    }

    private void f(BdTypeRecyclerView bdTypeRecyclerView) {
        if (this.jFr != null && bdTypeRecyclerView != null && !g(bdTypeRecyclerView)) {
            this.jFr.registerListener(this.jFL);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v5, resolved type: com.baidu.tieba.frs.good.FrsGoodFragment */
    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public boolean g(BdTypeRecyclerView bdTypeRecyclerView) {
        if (this.jFr == null || bdTypeRecyclerView == null) {
            return false;
        }
        this.jFJ = new ArrayList();
        ArrayList<BdUniqueId> dNb = com.baidu.tieba.tbadkCore.v.dNb();
        if (dNb == null || dNb.size() <= 0) {
            return false;
        }
        int size = dNb.size();
        for (int i = 0; i < size; i++) {
            k<ICardInfo, ? extends TypeAdapter.ViewHolder> a2 = e.cBN().a(this.jFr.getPageContext(), dNb.get(i), this.jFr.getUniqueId());
            if (a2 != null) {
                this.boS.add(a2);
                this.jFJ.add(a2);
            }
        }
        if (!y.isEmpty(this.jFJ)) {
            bdTypeRecyclerView.addAdapters(this.jFJ);
        }
        return true;
    }

    public boolean r(BdUniqueId bdUniqueId) {
        if (bdUniqueId == null) {
            return false;
        }
        for (com.baidu.adp.widget.ListView.a aVar : this.boS) {
            if (aVar != null && aVar.getType() == bdUniqueId) {
                return true;
            }
        }
        return false;
    }

    private void ED(String str) {
        if (this.boS != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.boS) {
                if (aVar instanceof f) {
                    ((f) aVar).ED(str);
                }
            }
        }
    }

    public List<n> getDataList() {
        return this.iHS;
    }

    public List<n> cJs() {
        return this.jFK;
    }
}
