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
import com.baidu.tbadk.core.data.bx;
import com.baidu.tbadk.core.data.by;
import com.baidu.tbadk.core.util.y;
import com.baidu.tieba.a.f;
import com.baidu.tieba.frs.AbsDelegateAdapterList;
import com.baidu.tieba.frs.d.d;
import com.baidu.tieba.frs.e;
import com.baidu.tieba.frs.entelechy.a.aa;
import com.baidu.tieba.frs.entelechy.a.ab;
import com.baidu.tieba.frs.entelechy.a.ac;
import com.baidu.tieba.frs.entelechy.a.ad;
import com.baidu.tieba.frs.entelechy.a.g;
import com.baidu.tieba.frs.entelechy.a.i;
import com.baidu.tieba.frs.entelechy.a.j;
import com.baidu.tieba.frs.entelechy.a.n;
import com.baidu.tieba.frs.entelechy.a.o;
import com.baidu.tieba.frs.entelechy.a.p;
import com.baidu.tieba.frs.entelechy.a.s;
import com.baidu.tieba.frs.entelechy.a.u;
import com.baidu.tieba.frs.entelechy.a.v;
import com.baidu.tieba.frs.entelechy.a.w;
import com.baidu.tieba.frs.entelechy.a.x;
import com.baidu.tieba.frs.entelechy.a.z;
import com.baidu.tieba.frs.k;
import com.baidu.tieba.frs.r;
import com.baidu.tieba.lego.card.model.ICardInfo;
import com.baidu.tieba.tbadkCore.FrsViewData;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes22.dex */
public class b {
    private BdTypeRecyclerView iYW;
    private ArrayList<q> isF;
    private final HashMap<Integer, by> jdH;
    private FrsViewData jdI;
    private FrsGoodFragment jpX;
    private List<com.baidu.adp.widget.ListView.a> jqr;
    private ArrayList<q> jqs;
    private List<com.baidu.adp.widget.ListView.a> bnf = new LinkedList();
    private CustomMessageListener jbM = new CustomMessageListener(CmdConfigCustom.CMD_FRS_ADD_ADAPTER) { // from class: com.baidu.tieba.frs.good.b.1
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
                        ((k) aVar).a(b.this.jpX.getPageContext(), b.this.jpX.getUniqueId());
                    }
                }
                ArrayList arrayList = new ArrayList();
                arrayList.addAll(absDelegateAdapterList);
                if (b.this.bnf != null) {
                    b.this.bnf.addAll(arrayList);
                }
                if (b.this.iYW != null) {
                    b.this.iYW.addAdapters(arrayList);
                }
            }
        }
    };
    private CustomMessageListener jqt = new CustomMessageListener(CmdConfigCustom.CMD_LEGO_REGISTER) { // from class: com.baidu.tieba.frs.good.b.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && y.isEmpty(b.this.jqr)) {
                b.this.g(b.this.iYW);
                b.this.b(b.this.isF, b.this.jdI);
            }
        }
    };

    public b(FrsGoodFragment frsGoodFragment, BdTypeRecyclerView bdTypeRecyclerView) {
        a(frsGoodFragment, bdTypeRecyclerView);
        this.iYW = bdTypeRecyclerView;
        this.jdH = new HashMap<>();
    }

    public void a(FrsGoodFragment frsGoodFragment, BdTypeRecyclerView bdTypeRecyclerView) {
        this.jpX = frsGoodFragment;
        this.jbM.setPriority(1);
        this.jbM.setSelfListener(true);
        this.jpX.registerListener(this.jbM);
        ab abVar = new ab(frsGoodFragment.getTbPageContext(), by.eIY, this.jpX.getUniqueId());
        o oVar = new o(frsGoodFragment.getTbPageContext(), by.eIZ, this.jpX.getUniqueId());
        com.baidu.tieba.frs.entelechy.a.y yVar = new com.baidu.tieba.frs.entelechy.a.y(frsGoodFragment.getTbPageContext(), by.eJb, this.jpX.getUniqueId());
        v vVar = new v(frsGoodFragment.getTbPageContext(), by.eJc, this.jpX.getUniqueId());
        n nVar = new n(frsGoodFragment.getTbPageContext(), by.eJe, this.jpX.getUniqueId());
        p pVar = new p(frsGoodFragment.getTbPageContext(), by.eJf, this.jpX.getUniqueId());
        ad adVar = new ad(frsGoodFragment.getTbPageContext(), by.eJk, this.jpX.getUniqueId());
        z zVar = new z(frsGoodFragment.getTbPageContext(), by.eJE, this.jpX.getUniqueId());
        x xVar = new x(frsGoodFragment.getTbPageContext(), by.eJl, this.jpX.getUniqueId());
        u uVar = new u(frsGoodFragment.getTbPageContext(), by.eJm, this.jpX.getUniqueId());
        ac acVar = new ac(frsGoodFragment.getPageContext(), by.eJq, this.jpX.getUniqueId());
        s sVar = new s(frsGoodFragment.getPageContext(), by.eJo, this.jpX.getUniqueId());
        w wVar = new w(frsGoodFragment.getPageContext(), by.eJp, this.jpX.getUniqueId());
        ac acVar2 = new ac(frsGoodFragment.getPageContext(), by.eJz, this.jpX.getUniqueId());
        r rVar = new r(frsGoodFragment.getPageContext(), com.baidu.tieba.frs.s.iWt);
        com.baidu.adp.widget.ListView.a<? extends bx, ? extends af.a> a2 = e.cBn().a(frsGoodFragment.getPageContext(), this.jpX.getUniqueId(), true);
        com.baidu.adp.widget.ListView.a<? extends by, ? extends af.a> b = e.cBn().b(frsGoodFragment.getPageContext(), by.eLc, this.jpX.getUniqueId());
        com.baidu.adp.widget.ListView.a<?, ?> a3 = com.baidu.tieba.recapp.r.dFg().a(this.jpX, AdvertAppInfo.eDM);
        com.baidu.adp.widget.ListView.a<?, ?> a4 = com.baidu.tieba.recapp.r.dFg().a(this.jpX, AdvertAppInfo.eDV);
        aa aaVar = new aa(frsGoodFragment.getPageContext(), by.eJv, this.jpX.getUniqueId());
        com.baidu.tieba.frs.entelechy.a.b bVar = new com.baidu.tieba.frs.entelechy.a.b(frsGoodFragment.getPageContext(), by.eJx, this.jpX.getUniqueId());
        i iVar = new i(frsGoodFragment.getPageContext(), by.eJw, this.jpX.getUniqueId());
        j jVar = new j(frsGoodFragment.getPageContext(), by.eJy, this.jpX.getUniqueId());
        g gVar = new g(frsGoodFragment.getPageContext(), by.eJj, this.jpX.getUniqueId());
        gVar.a(bdTypeRecyclerView);
        this.bnf.add(abVar);
        this.bnf.add(oVar);
        this.bnf.add(yVar);
        this.bnf.add(vVar);
        this.bnf.add(nVar);
        this.bnf.add(pVar);
        this.bnf.add(zVar);
        this.bnf.add(adVar);
        this.bnf.add(xVar);
        this.bnf.add(uVar);
        this.bnf.add(acVar);
        this.bnf.add(sVar);
        this.bnf.add(sVar);
        this.bnf.add(wVar);
        this.bnf.add(rVar);
        this.bnf.add(acVar);
        this.bnf.add(acVar2);
        this.bnf.add(aaVar);
        this.bnf.add(bVar);
        this.bnf.add(iVar);
        this.bnf.add(jVar);
        this.bnf.add(gVar);
        if (a2 != null) {
            this.bnf.add(a2);
        }
        if (b != null) {
            this.bnf.add(b);
        }
        this.bnf.add(a3);
        this.bnf.add(a4);
        CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_ADD_ADAPTER, new AbsDelegateAdapterList());
        CustomMessage customMessage = new CustomMessage(CmdConfigCustom.CMD_FRS_ADD_ADAPTER);
        customMessage.setTag(this.jpX.getUniqueId());
        customResponsedMessage.setOrginalMessage(customMessage);
        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
        f(bdTypeRecyclerView);
        com.baidu.tieba.InjectPlugin.b.b bVar2 = new com.baidu.tieba.InjectPlugin.b.b(this.jpX, 1);
        bVar2.setExtraData(this.bnf);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_FEED_AD_PLUGIN_OPERATE, bVar2));
        bdTypeRecyclerView.addAdapters(this.bnf);
        Fo("page_frs_good");
        for (com.baidu.adp.widget.ListView.a aVar : this.bnf) {
            if (aVar instanceof com.baidu.tieba.card.aa) {
                ((com.baidu.tieba.card.aa) aVar).oZ(true);
            }
        }
    }

    public void onDestory() {
        for (com.baidu.adp.widget.ListView.a aVar : this.bnf) {
            if (aVar instanceof k) {
                ((k) aVar).release();
            }
        }
    }

    public void b(ArrayList<q> arrayList, FrsViewData frsViewData) {
        if (frsViewData != null && arrayList != null && arrayList.size() == 1 && (arrayList.get(0) instanceof com.baidu.tieba.frs.s)) {
            frsViewData.setThreadList(arrayList);
        }
        b(frsViewData);
        cEH();
        aF(arrayList);
        com.baidu.tieba.tbadkCore.v.x(arrayList, 1);
        aE(arrayList);
        ArrayList<q> switchThreadDataToThreadCardInfo = frsViewData.switchThreadDataToThreadCardInfo();
        this.iYW.setData(switchThreadDataToThreadCardInfo);
        this.jqs = switchThreadDataToThreadCardInfo;
        this.isF = arrayList;
        this.jdI = frsViewData;
        cFk();
    }

    public void refreshData() {
        this.iYW.setData(this.jqs);
        notifyDataSetChanged();
    }

    private void cEH() {
        if (!y.isEmpty(this.bnf) && this.jpX != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.bnf) {
                if (aVar instanceof k) {
                    ((k) aVar).a(this.jpX.getTbPageTag());
                }
            }
        }
    }

    private void cFk() {
        com.baidu.tieba.frs.d.b statisticMetaData;
        if (this.jdI != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.bnf) {
                if ((aVar instanceof d) && (statisticMetaData = ((d) aVar).getStatisticMetaData()) != null) {
                    if (this.jdI.needLog == 1) {
                        statisticMetaData.jtR = true;
                    } else {
                        statisticMetaData.jtR = false;
                    }
                    if (this.jdI.getForum() != null) {
                        statisticMetaData.jtT = this.jdI.getForum().getId();
                    }
                    if (this.jpX != null) {
                        statisticMetaData.jtS = 5;
                    }
                }
            }
        }
    }

    private void aE(ArrayList<q> arrayList) {
        if (arrayList != null && arrayList.size() != 0) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < arrayList.size()) {
                    q qVar = arrayList.get(i2);
                    if ((qVar instanceof AdvertAppInfo) && this.jdH != null && !this.jdH.containsValue(qVar)) {
                        this.jdH.put(Integer.valueOf(i2), (by) qVar);
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    public HashMap<Integer, by> cFX() {
        return this.jdH;
    }

    public void cGc() {
        if (this.iYW != null && this.iYW.getData() != null && this.iYW.getData().size() != 0) {
            for (q qVar : this.iYW.getData()) {
                if ((qVar instanceof bx) && ((bx) qVar).eCR.boK() != 0) {
                    ((bx) qVar).eCR.bpP();
                }
            }
        }
    }

    public void cII() {
        for (com.baidu.adp.widget.ListView.a aVar : this.bnf) {
            if (aVar instanceof com.baidu.tieba.card.z) {
                ((com.baidu.tieba.card.z) aVar).wi(3);
            }
        }
    }

    public void notifyDataSetChanged() {
        this.iYW.getAdapter().notifyDataSetChanged();
    }

    public void onChangeSkinType(int i) {
    }

    public void notifyDataSetInvalidated() {
        this.iYW.getAdapter().notifyDataSetChanged();
    }

    public void setFromCDN(boolean z) {
        if (this.bnf != null && this.bnf.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.bnf) {
                if (aVar instanceof k) {
                    ((k) aVar).setFromCDN(z);
                }
            }
        }
    }

    public void b(FrsViewData frsViewData) {
        if (this.bnf != null && this.bnf.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.bnf) {
                if (aVar instanceof k) {
                    ((k) aVar).b(frsViewData);
                }
            }
        }
    }

    public void a(com.baidu.adp.widget.ListView.ab abVar) {
        if (this.bnf != null && this.bnf.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.bnf) {
                if (aVar != null && (aVar instanceof k)) {
                    ((k) aVar).a(abVar);
                }
            }
        }
    }

    private void aF(ArrayList<q> arrayList) {
        if (arrayList != null && arrayList.size() > 0) {
            Iterator<q> it = arrayList.iterator();
            while (it.hasNext()) {
                if (it.next().getType() == by.eIR) {
                    it.remove();
                }
            }
        }
    }

    private void f(BdTypeRecyclerView bdTypeRecyclerView) {
        if (this.jpX != null && bdTypeRecyclerView != null && !g(bdTypeRecyclerView)) {
            this.jpX.registerListener(this.jqt);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v5, resolved type: com.baidu.tieba.frs.good.FrsGoodFragment */
    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public boolean g(BdTypeRecyclerView bdTypeRecyclerView) {
        if (this.jpX == null || bdTypeRecyclerView == null) {
            return false;
        }
        this.jqr = new ArrayList();
        ArrayList<BdUniqueId> dOz = com.baidu.tieba.tbadkCore.v.dOz();
        if (dOz == null || dOz.size() <= 0) {
            return false;
        }
        int size = dOz.size();
        for (int i = 0; i < size; i++) {
            k<ICardInfo, ? extends af.a> a2 = e.cBn().a(this.jpX.getPageContext(), dOz.get(i), this.jpX.getUniqueId());
            if (a2 != null) {
                this.bnf.add(a2);
                this.jqr.add(a2);
            }
        }
        if (!y.isEmpty(this.jqr)) {
            bdTypeRecyclerView.addAdapters(this.jqr);
        }
        return true;
    }

    public boolean r(BdUniqueId bdUniqueId) {
        if (bdUniqueId == null) {
            return false;
        }
        for (com.baidu.adp.widget.ListView.a aVar : this.bnf) {
            if (aVar != null && aVar.getType() == bdUniqueId) {
                return true;
            }
        }
        return false;
    }

    private void Fo(String str) {
        if (this.bnf != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.bnf) {
                if (aVar instanceof f) {
                    ((f) aVar).Fo(str);
                }
            }
        }
    }

    public List<q> getDataList() {
        return this.isF;
    }

    public List<q> cIJ() {
        return this.jqs;
    }
}
