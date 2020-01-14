package com.baidu.tieba.frs.mc;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.adp.widget.ListView.m;
import com.baidu.adp.widget.ListView.v;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.data.bi;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.frs.AbsDelegateAdapterList;
import com.baidu.tieba.frs.entelechy.a.p;
import com.baidu.tieba.frs.entelechy.a.r;
import com.baidu.tieba.frs.entelechy.a.s;
import com.baidu.tieba.frs.entelechy.a.t;
import com.baidu.tieba.frs.entelechy.a.u;
import com.baidu.tieba.frs.entelechy.a.w;
import com.baidu.tieba.frs.entelechy.a.x;
import com.baidu.tieba.frs.n;
import com.baidu.tieba.lego.card.model.ICardInfo;
import com.baidu.tieba.tbadkCore.FrsViewData;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes7.dex */
public class f {
    private ArrayList<m> fPW;
    private List<com.baidu.adp.widget.ListView.a> gDJ;
    private FrsNewAreaFragment gFD;
    private BdTypeRecyclerView gqN;
    private final HashMap<Integer, bj> guV;
    private FrsViewData guW;
    private List<com.baidu.adp.widget.ListView.a> apl = new LinkedList();
    private CustomMessageListener gDL = new CustomMessageListener(CmdConfigCustom.CMD_LEGO_REGISTER) { // from class: com.baidu.tieba.frs.mc.f.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && v.isEmpty(f.this.gDJ)) {
                f.this.b(f.this.gqN);
                f.this.b(f.this.fPW, f.this.guW);
            }
        }
    };

    public f(FrsNewAreaFragment frsNewAreaFragment, BdTypeRecyclerView bdTypeRecyclerView) {
        a(frsNewAreaFragment, bdTypeRecyclerView);
        this.gqN = bdTypeRecyclerView;
        this.guV = new HashMap<>();
    }

    public void a(FrsNewAreaFragment frsNewAreaFragment, BdTypeRecyclerView bdTypeRecyclerView) {
        this.gFD = frsNewAreaFragment;
        w wVar = new w(frsNewAreaFragment.getTbPageContext(), bj.cNj, this.gFD.getUniqueId());
        wVar.a(bdTypeRecyclerView);
        com.baidu.tieba.frs.entelechy.a.l lVar = new com.baidu.tieba.frs.entelechy.a.l(frsNewAreaFragment.getTbPageContext(), bj.cNk, this.gFD.getUniqueId());
        lVar.a(bdTypeRecyclerView);
        t tVar = new t(frsNewAreaFragment.getTbPageContext(), bj.cNm, this.gFD.getUniqueId());
        tVar.a(bdTypeRecyclerView);
        r rVar = new r(frsNewAreaFragment.getTbPageContext(), bj.cNn, this.gFD.getUniqueId());
        rVar.a(bdTypeRecyclerView);
        com.baidu.tieba.frs.entelechy.a.k kVar = new com.baidu.tieba.frs.entelechy.a.k(frsNewAreaFragment.getTbPageContext(), bj.cNp, this.gFD.getUniqueId());
        kVar.a(bdTypeRecyclerView);
        com.baidu.tieba.frs.entelechy.a.m mVar = new com.baidu.tieba.frs.entelechy.a.m(frsNewAreaFragment.getTbPageContext(), bj.cNq, this.gFD.getUniqueId());
        mVar.a(bdTypeRecyclerView);
        u uVar = new u(frsNewAreaFragment.getTbPageContext(), bj.cNI, this.gFD.getUniqueId());
        uVar.a(bdTypeRecyclerView);
        x xVar = new x(frsNewAreaFragment.getPageContext(), bj.cNv, this.gFD.getUniqueId());
        xVar.a(bdTypeRecyclerView);
        p pVar = new p(frsNewAreaFragment.getPageContext(), bj.cNt, this.gFD.getUniqueId());
        pVar.a(bdTypeRecyclerView);
        com.baidu.tieba.frs.entelechy.a.b bVar = new com.baidu.tieba.frs.entelechy.a.b(frsNewAreaFragment.getPageContext(), bj.cNB, this.gFD.getUniqueId());
        bVar.a(bdTypeRecyclerView);
        com.baidu.tieba.frs.entelechy.a.g gVar = new com.baidu.tieba.frs.entelechy.a.g(frsNewAreaFragment.getPageContext(), bj.cNA, this.gFD.getUniqueId());
        gVar.a(bdTypeRecyclerView);
        com.baidu.tieba.frs.entelechy.a.h hVar = new com.baidu.tieba.frs.entelechy.a.h(frsNewAreaFragment.getPageContext(), bj.cNC, this.gFD.getUniqueId());
        hVar.a(bdTypeRecyclerView);
        s sVar = new s(frsNewAreaFragment.getPageContext(), bj.cNu, this.gFD.getUniqueId());
        sVar.a(bdTypeRecyclerView);
        x xVar2 = new x(frsNewAreaFragment.getPageContext(), bj.cND, this.gFD.getUniqueId());
        xVar2.a(bdTypeRecyclerView);
        com.baidu.tieba.frs.m mVar2 = new com.baidu.tieba.frs.m(frsNewAreaFragment.getPageContext(), n.goX);
        mVar2.a(bdTypeRecyclerView);
        com.baidu.adp.widget.ListView.a<? extends bi, ? extends v.a> a = com.baidu.tieba.frs.c.bBC().a(frsNewAreaFragment.getPageContext(), this.gFD.getUniqueId(), true);
        com.baidu.adp.widget.ListView.a<? extends bj, ? extends v.a> b = com.baidu.tieba.frs.c.bBC().b(frsNewAreaFragment.getPageContext(), bj.cPi, this.gFD.getUniqueId());
        com.baidu.adp.widget.ListView.a<?, ?> a2 = com.baidu.tieba.recapp.r.cAX().a(this.gFD, AdvertAppInfo.cIB);
        com.baidu.adp.widget.ListView.a<?, ?> a3 = com.baidu.tieba.recapp.r.cAX().a(this.gFD, AdvertAppInfo.cIK);
        com.baidu.tieba.frs.entelechy.a.v vVar = new com.baidu.tieba.frs.entelechy.a.v(frsNewAreaFragment.getPageContext(), bj.cNz, this.gFD.getUniqueId());
        vVar.a(bdTypeRecyclerView);
        this.apl.add(wVar);
        this.apl.add(lVar);
        this.apl.add(tVar);
        this.apl.add(rVar);
        this.apl.add(kVar);
        this.apl.add(mVar);
        this.apl.add(uVar);
        this.apl.add(xVar);
        this.apl.add(pVar);
        this.apl.add(bVar);
        this.apl.add(gVar);
        this.apl.add(hVar);
        this.apl.add(sVar);
        this.apl.add(mVar2);
        this.apl.add(xVar);
        this.apl.add(xVar2);
        this.apl.add(vVar);
        if (a != null) {
            this.apl.add(a);
        }
        if (b != null) {
            this.apl.add(b);
        }
        this.apl.add(a2);
        this.apl.add(a3);
        CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_ADD_ADAPTER, new AbsDelegateAdapterList());
        CustomMessage customMessage = new CustomMessage(CmdConfigCustom.CMD_FRS_ADD_ADAPTER);
        customMessage.setTag(this.gFD.getUniqueId());
        customResponsedMessage.setOrginalMessage(customMessage);
        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
        a(bdTypeRecyclerView);
        com.baidu.tieba.InjectPlugin.b.b bVar2 = new com.baidu.tieba.InjectPlugin.b.b(this.gFD, 1);
        bVar2.setExtraData(this.apl);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_FEED_AD_PLUGIN_OPERATE, bVar2));
        bdTypeRecyclerView.addAdapters(this.apl);
    }

    public void onDestory() {
        for (com.baidu.adp.widget.ListView.a aVar : this.apl) {
            if (aVar instanceof com.baidu.tieba.frs.h) {
                ((com.baidu.tieba.frs.h) aVar).release();
            }
        }
    }

    public void b(ArrayList<m> arrayList, FrsViewData frsViewData) {
        b(frsViewData);
        bEq();
        com.baidu.tieba.tbadkCore.s.o(arrayList, 1);
        ap(arrayList);
        this.gqN.setData(arrayList);
        this.fPW = arrayList;
        this.guW = frsViewData;
        bEU();
    }

    public void refreshData() {
        this.gqN.setData(this.fPW);
        notifyDataSetChanged();
    }

    private void bEq() {
        if (!com.baidu.tbadk.core.util.v.isEmpty(this.apl) && this.gFD != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.apl) {
                if (aVar instanceof com.baidu.tieba.frs.h) {
                    ((com.baidu.tieba.frs.h) aVar).a(this.gFD.getTbPageTag());
                }
            }
        }
    }

    private void bEU() {
        com.baidu.tieba.frs.d.b bFt;
        if (this.guW != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.apl) {
                if ((aVar instanceof com.baidu.tieba.frs.d.d) && (bFt = ((com.baidu.tieba.frs.d.d) aVar).bFt()) != null) {
                    if (this.guW.needLog == 1) {
                        bFt.gHl = true;
                    } else {
                        bFt.gHl = false;
                    }
                    if (this.guW.getForum() != null) {
                        bFt.gHn = this.guW.getForum().getId();
                    }
                }
            }
        }
    }

    private void ap(ArrayList<m> arrayList) {
        if (arrayList != null && arrayList.size() != 0) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < arrayList.size()) {
                    m mVar = arrayList.get(i2);
                    if ((mVar instanceof AdvertAppInfo) && this.guV != null && !this.guV.containsValue(mVar)) {
                        this.guV.put(Integer.valueOf(i2), (bj) mVar);
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    public HashMap<Integer, bj> bFw() {
        return this.guV;
    }

    public void bFB() {
        if (this.gqN != null && this.gqN.getData() != null && this.gqN.getData().size() != 0) {
            for (m mVar : this.gqN.getData()) {
                if ((mVar instanceof bi) && ((bi) mVar).cNb.azS() != 0) {
                    ((bi) mVar).cNb.aAT();
                }
            }
        }
    }

    public void notifyDataSetChanged() {
        this.gqN.getAdapter().notifyDataSetChanged();
    }

    public void onChangeSkinType(int i) {
    }

    public void notifyDataSetInvalidated() {
        this.gqN.getAdapter().notifyDataSetChanged();
    }

    public void setFromCDN(boolean z) {
        if (this.apl != null && this.apl.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.apl) {
                if (aVar instanceof com.baidu.tieba.frs.h) {
                    ((com.baidu.tieba.frs.h) aVar).setFromCDN(z);
                }
            }
        }
    }

    public void b(FrsViewData frsViewData) {
        if (this.apl != null && this.apl.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.apl) {
                if (aVar instanceof com.baidu.tieba.frs.h) {
                    ((com.baidu.tieba.frs.h) aVar).b(frsViewData);
                }
            }
        }
    }

    public void a(com.baidu.adp.widget.ListView.s sVar) {
        if (this.apl != null && this.apl.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.apl) {
                if (aVar != null && (aVar instanceof com.baidu.tieba.frs.h)) {
                    ((com.baidu.tieba.frs.h) aVar).a(sVar);
                }
            }
        }
    }

    private void a(BdTypeRecyclerView bdTypeRecyclerView) {
        if (this.gFD != null && bdTypeRecyclerView != null && !b(bdTypeRecyclerView)) {
            this.gFD.registerListener(this.gDL);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v5, resolved type: com.baidu.tieba.frs.mc.FrsNewAreaFragment */
    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public boolean b(BdTypeRecyclerView bdTypeRecyclerView) {
        if (this.gFD == null || bdTypeRecyclerView == null) {
            return false;
        }
        this.gDJ = new ArrayList();
        ArrayList<BdUniqueId> cIM = com.baidu.tieba.tbadkCore.s.cIM();
        if (cIM == null || cIM.size() <= 0) {
            return false;
        }
        int size = cIM.size();
        for (int i = 0; i < size; i++) {
            com.baidu.tieba.frs.h<ICardInfo, ? extends v.a> a = com.baidu.tieba.frs.c.bBC().a(this.gFD.getPageContext(), cIM.get(i), this.gFD.getUniqueId());
            if (a != null) {
                this.apl.add(a);
                this.gDJ.add(a);
            }
        }
        if (!com.baidu.tbadk.core.util.v.isEmpty(this.gDJ)) {
            bdTypeRecyclerView.addAdapters(this.gDJ);
        }
        return true;
    }

    public List<m> getDataList() {
        return this.fPW;
    }
}
