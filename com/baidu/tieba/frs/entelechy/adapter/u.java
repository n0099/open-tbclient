package com.baidu.tieba.frs.entelechy.adapter;

import android.text.TextUtils;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.data.ca;
import com.baidu.tbadk.core.data.cb;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.AbsDelegateAdapterList;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.tbadkCore.FrsViewData;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes2.dex */
public class u implements al {
    private ArrayList<com.baidu.adp.widget.ListView.n> dataList;
    private com.baidu.adp.widget.ListView.s iLY;
    private FrsFragment jiS;
    private z jrA;
    private w jrB;
    private n jrC;
    private q jrD;
    private aa jrE;
    private ae jrF;
    private y jrG;
    private v jrH;
    private ad jrI;
    private p jrJ;
    private x jrK;
    private final HashMap<Integer, cb> jrt;
    private FrsViewData jru;
    private ai jrw;
    private com.baidu.adp.widget.ListView.a jrx;
    private ac jry;
    private o jrz;
    private List<com.baidu.adp.widget.ListView.a> bns = new LinkedList();
    private boolean jrv = false;
    private final com.baidu.tieba.frs.i jfX = new com.baidu.tieba.frs.i();

    public u(FrsFragment frsFragment, com.baidu.adp.widget.ListView.s sVar, boolean z) {
        this.iLY = sVar;
        a(frsFragment, sVar);
        this.jrt = new HashMap<>();
        rf(z);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r6v35, resolved type: com.baidu.tieba.frs.FrsFragment */
    /* JADX WARN: Multi-variable type inference failed */
    public void a(FrsFragment frsFragment, com.baidu.adp.widget.ListView.s sVar) {
        this.jiS = frsFragment;
        this.jrx = com.baidu.tieba.frs.e.cBH().a(frsFragment.getPageContext(), com.baidu.tieba.tbadkCore.x.nvO, this.jiS.getUniqueId(), false);
        this.jry = new ac(frsFragment.getTbPageContext(), cb.eQs, this.jiS.getUniqueId());
        this.jry.b(sVar);
        this.jrz = new o(frsFragment.getTbPageContext(), cb.eQt, this.jiS.getUniqueId());
        this.jrz.b(sVar);
        this.jrA = new z(frsFragment.getTbPageContext(), cb.eQv, this.jiS.getUniqueId());
        this.jrA.b(sVar);
        this.jrB = new w(frsFragment.getTbPageContext(), cb.eQw, this.jiS.getUniqueId());
        this.jrB.b(sVar);
        this.jrC = new n(frsFragment.getTbPageContext(), cb.eQy, this.jiS.getUniqueId());
        this.jrC.b(sVar);
        this.jrD = new q(frsFragment.getTbPageContext(), cb.eQz, this.jiS.getUniqueId());
        this.jrD.b(sVar);
        this.jrF = new ae(frsFragment.getTbPageContext(), cb.eQE, this.jiS.getUniqueId());
        this.jrF.b(sVar);
        this.jrE = new aa(frsFragment.getTbPageContext(), cb.eQY, this.jiS.getUniqueId());
        this.jrE.b(sVar);
        this.jrG = new y(frsFragment.getTbPageContext(), cb.eQF, this.jiS.getUniqueId());
        this.jrG.b(sVar);
        this.jrH = new v(frsFragment.getTbPageContext(), cb.eQG, this.jiS.getUniqueId());
        this.jrH.b(sVar);
        this.jrI = new ad(frsFragment.getPageContext(), cb.eQK, this.jiS.getUniqueId());
        this.jrI.b(sVar);
        this.jrJ = new p(frsFragment.getPageContext(), cb.eRd, this.jiS.getUniqueId());
        this.jrJ.b(sVar);
        t tVar = new t(frsFragment.getPageContext(), cb.eQI, this.jiS.getUniqueId());
        tVar.b(sVar);
        ab abVar = new ab(frsFragment.getPageContext(), cb.eQP, this.jiS.getUniqueId());
        abVar.b(sVar);
        a aVar = new a(frsFragment.getPageContext(), cb.eQB, frsFragment.getUniqueId());
        aVar.b(sVar);
        aVar.uX(1);
        d dVar = new d(frsFragment.getPageContext(), cb.eQx, frsFragment.getUniqueId());
        dVar.b(sVar);
        b bVar = new b(frsFragment.getPageContext(), cb.eQR, this.jiS.getUniqueId());
        bVar.b(sVar);
        bVar.setInFrsAllThread(true);
        i iVar = new i(frsFragment.getPageContext(), cb.eQQ, this.jiS.getUniqueId());
        iVar.b(sVar);
        iVar.setInFrsAllThread(true);
        j jVar = new j(frsFragment.getPageContext(), cb.eQS, this.jiS.getUniqueId());
        jVar.b(sVar);
        jVar.setInFrsAllThread(true);
        ad adVar = new ad(frsFragment.getPageContext(), cb.eQT, this.jiS.getUniqueId());
        adVar.b(sVar);
        s sVar2 = new s(frsFragment.getPageContext(), cb.eRc, this.jiS.getUniqueId());
        sVar2.b(sVar);
        r rVar = new r(frsFragment.getPageContext(), cb.eQU, this.jiS.getUniqueId());
        rVar.b(sVar);
        this.jrw = new ai(frsFragment.getPageContext(), com.baidu.tieba.tbadkCore.q.nvG, this.jiS.getUniqueId());
        this.jrK = new x(frsFragment.getPageContext(), cb.eQJ, this.jiS.getUniqueId());
        this.jrK.b(sVar);
        com.baidu.adp.widget.ListView.a<? extends ca, ? extends TypeAdapter.ViewHolder> a2 = com.baidu.tieba.frs.e.cBH().a(frsFragment.getPageContext(), this.jiS.getUniqueId(), true);
        com.baidu.adp.widget.ListView.a<? extends cb, ? extends TypeAdapter.ViewHolder> b2 = com.baidu.tieba.frs.e.cBH().b(frsFragment.getPageContext(), cb.eSx, this.jiS.getUniqueId());
        com.baidu.tieba.frs.r rVar2 = new com.baidu.tieba.frs.r(frsFragment.getPageContext(), com.baidu.tieba.frs.s.jjT);
        m mVar = new m(frsFragment.getPageContext(), com.baidu.tieba.frs.u.jkk);
        FrsUserRecommendAdapter frsUserRecommendAdapter = new FrsUserRecommendAdapter(frsFragment.getPageContext(), com.baidu.tieba.frs.w.jkt, this.jiS.getUniqueId());
        g gVar = new g(frsFragment.getPageContext(), cb.eQD, this.jiS.getUniqueId());
        gVar.a((BdTypeRecyclerView) sVar);
        this.bns.add(this.jrx);
        this.bns.add(this.jry);
        this.bns.add(this.jrz);
        this.bns.add(this.jrA);
        this.bns.add(this.jrB);
        this.bns.add(this.jrC);
        this.bns.add(this.jrD);
        this.bns.add(this.jrE);
        this.bns.add(this.jrF);
        this.bns.add(this.jrG);
        this.bns.add(this.jrH);
        this.bns.add(this.jrw);
        this.bns.add(tVar);
        this.bns.add(abVar);
        this.bns.add(aVar);
        this.bns.add(dVar);
        this.bns.add(bVar);
        this.bns.add(iVar);
        this.bns.add(jVar);
        this.bns.add(this.jrK);
        this.bns.add(this.jrI);
        this.bns.add(this.jrJ);
        this.bns.add(a2);
        this.bns.add(b2);
        this.bns.add(rVar2);
        this.bns.add(mVar);
        this.bns.add(sVar2);
        this.bns.add(rVar);
        this.bns.add(frsUserRecommendAdapter);
        this.bns.add(adVar);
        this.bns.add(gVar);
        this.bns.add(com.baidu.tieba.h.b.cNt().c(this.jiS.getBaseFragmentActivity(), AdvertAppInfo.eLm));
        com.baidu.tieba.InjectPlugin.b.b bVar2 = new com.baidu.tieba.InjectPlugin.b.b(this.jiS, 1);
        bVar2.setExtraData(this.bns);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_FEED_AD_PLUGIN_OPERATE, bVar2));
        dm(this.bns);
        sVar.addAdapters(this.bns);
        AbsDelegateAdapterList absDelegateAdapterList = new AbsDelegateAdapterList();
        CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_ADD_ADAPTER, absDelegateAdapterList);
        CustomMessage customMessage = new CustomMessage(CmdConfigCustom.CMD_FRS_ADD_ADAPTER);
        customMessage.setTag(this.jiS.getUniqueId());
        customResponsedMessage.setOrginalMessage(customMessage);
        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
        Ew("page_frs");
        if (!absDelegateAdapterList.isEmpty()) {
            Iterator it = absDelegateAdapterList.iterator();
            while (it.hasNext()) {
                com.baidu.adp.widget.ListView.a aVar2 = (com.baidu.adp.widget.ListView.a) it.next();
                if (aVar2 instanceof com.baidu.tieba.frs.k) {
                    ((com.baidu.tieba.frs.k) aVar2).a(this.jiS.getPageContext(), this.jiS.getUniqueId());
                }
            }
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(absDelegateAdapterList);
            if (this.bns != null) {
                this.bns.addAll(arrayList);
            }
            if (this.iLY != null) {
                this.iLY.addAdapters(arrayList);
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.adapter.al
    public void onDestory() {
        for (com.baidu.adp.widget.ListView.a aVar : this.bns) {
            if (aVar instanceof com.baidu.tieba.frs.k) {
                ((com.baidu.tieba.frs.k) aVar).release();
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.adapter.al
    public HashMap<Integer, cb> cGz() {
        return this.jrt;
    }

    @Override // com.baidu.tieba.frs.entelechy.adapter.al
    public void notifyDataSetChanged() {
        if (this.iLY.getListAdapter() != null) {
            this.iLY.getListAdapter().notifyDataSetChanged();
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.adapter.al
    public int cGA() {
        if (this.jrx != null) {
            return R.id.frs_bawu_center;
        }
        return 0;
    }

    @Override // com.baidu.tieba.frs.entelechy.adapter.al
    public boolean r(BdUniqueId bdUniqueId) {
        if (bdUniqueId == null) {
            return false;
        }
        for (com.baidu.adp.widget.ListView.a aVar : this.bns) {
            if (aVar != null && aVar.getType() == bdUniqueId) {
                return true;
            }
        }
        return false;
    }

    @Override // com.baidu.tieba.frs.entelechy.adapter.al
    public void a(com.baidu.adp.widget.ListView.w wVar) {
        if (this.bns != null && this.bns.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.bns) {
                if (aVar instanceof com.baidu.tieba.frs.k) {
                    ((com.baidu.tieba.frs.k) aVar).a(wVar);
                } else if ((aVar instanceof x) || (aVar instanceof ad)) {
                    aVar.a(wVar);
                }
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.adapter.al
    public void setForumName(String str) {
        if (this.bns != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.bns) {
                if (aVar instanceof com.baidu.tieba.card.z) {
                    ((com.baidu.tieba.card.z) aVar).setForumName(str);
                }
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v1, resolved type: com.baidu.tieba.frs.FrsFragment */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.baidu.tieba.frs.entelechy.adapter.al
    public void cGB() {
        if (this.bns != null && this.bns.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.bns) {
                if (aVar instanceof com.baidu.tieba.frs.k) {
                    ((com.baidu.tieba.frs.k) aVar).a(this.jiS.getPageContext(), this.jiS.getUniqueId());
                }
            }
            dm(this.bns);
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.adapter.al
    public List<com.baidu.adp.widget.ListView.n> getDatas() {
        if (this.iLY != null) {
            return this.iLY.getData();
        }
        return null;
    }

    @Override // com.baidu.tieba.frs.entelechy.adapter.al
    public int cGC() {
        if (this.jrx != null) {
            return R.id.frs_fortune_bag_item;
        }
        return 0;
    }

    @Override // com.baidu.tieba.frs.entelechy.adapter.al
    public int cGD() {
        if (this.jrx != null) {
            return R.id.frs_my_service_item;
        }
        return 0;
    }

    public void bbC() {
        if (this.dataList != null) {
            this.iLY.setData(this.dataList);
        }
        notifyDataSetChanged();
    }

    @Override // com.baidu.tieba.frs.entelechy.adapter.al
    public void setFromCDN(boolean z) {
        if (this.bns != null && this.bns.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.bns) {
                if (aVar instanceof com.baidu.tieba.frs.k) {
                    ((com.baidu.tieba.frs.k) aVar).setFromCDN(z);
                }
            }
            if (this.jry != null) {
                this.jry.setFromCDN(z);
            }
            if (this.jrz != null) {
                this.jrz.setFromCDN(z);
            }
            if (this.jrA != null) {
                this.jrA.setFromCDN(z);
            }
            if (this.jrB != null) {
                this.jrB.setFromCDN(z);
            }
            if (this.jrC != null) {
                this.jrC.setFromCDN(z);
            }
            if (this.jrD != null) {
                this.jrD.setFromCDN(z);
            }
            if (this.jrI != null) {
                this.jrI.setFromCDN(z);
            }
            if (this.jrK != null) {
                this.jrK.setFromCDN(z);
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.adapter.al
    public void cGE() {
        List<com.baidu.adp.widget.ListView.n> data;
        if (this.iLY != null && this.iLY.getData() != null && this.iLY.getData().size() != 0 && (data = this.iLY.getData()) != null && data.size() != 0) {
            for (com.baidu.adp.widget.ListView.n nVar : data) {
                if (nVar instanceof cb) {
                    if (((cb) nVar).bnL() != 0) {
                        ((cb) nVar).boP();
                    }
                } else if ((nVar instanceof ca) && ((ca) nVar).eJQ.bnL() != 0) {
                    ((ca) nVar).eJQ.boP();
                }
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.adapter.al
    public void rf(boolean z) {
        if (this.jrv != z) {
            this.jrv = z;
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.adapter.al
    public void b(ArrayList<com.baidu.adp.widget.ListView.n> arrayList, FrsViewData frsViewData) {
        b(frsViewData);
        cFe();
        com.baidu.tieba.tbadkCore.v.x(arrayList, 1);
        av(arrayList);
        aw(arrayList);
        ax(arrayList);
        Iterator<com.baidu.adp.widget.ListView.n> it = arrayList.iterator();
        while (it.hasNext()) {
            com.baidu.adp.widget.ListView.n next = it.next();
            if ((next instanceof ca) && ((ca) next).eJQ.isTop()) {
                it.remove();
            }
        }
        this.iLY.setData(arrayList);
        this.jru = frsViewData;
        cFI();
        cGF();
        this.dataList = arrayList;
    }

    public void b(FrsViewData frsViewData) {
        if (this.bns != null && this.bns.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.bns) {
                if (aVar instanceof com.baidu.tieba.frs.k) {
                    ((com.baidu.tieba.frs.k) aVar).b(frsViewData);
                }
            }
        }
    }

    private ArrayList<Integer> av(ArrayList<com.baidu.adp.widget.ListView.n> arrayList) {
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
            com.baidu.adp.widget.ListView.n nVar = arrayList.get(i2);
            if (nVar instanceof AdvertAppInfo) {
                arrayList2.add(Integer.valueOf(i2));
                if (this.jrt != null && !this.jrt.containsValue(nVar)) {
                    this.jrt.put(Integer.valueOf(i2), (cb) nVar);
                }
            }
            i = i2 + 1;
        }
    }

    private void aw(ArrayList<com.baidu.adp.widget.ListView.n> arrayList) {
        int i;
        if (this.bns != null && this.bns.size() != 0) {
            int i2 = 0;
            if (arrayList == null || arrayList.size() <= 0) {
                i = 0;
            } else {
                Iterator<com.baidu.adp.widget.ListView.n> it = arrayList.iterator();
                while (true) {
                    i = i2;
                    if (!it.hasNext() || it.next().getType().getId() != cb.eQl.getId()) {
                        break;
                    }
                    i2 = i + 1;
                }
            }
            for (com.baidu.adp.widget.ListView.a aVar : this.bns) {
                if (aVar instanceof com.baidu.tieba.frs.k) {
                    ((com.baidu.tieba.frs.k) aVar).yu(i);
                }
            }
        }
    }

    private void ax(ArrayList<com.baidu.adp.widget.ListView.n> arrayList) {
        int count = com.baidu.tbadk.core.util.y.getCount(arrayList);
        for (int i = 0; i < count; i++) {
            com.baidu.adp.widget.ListView.n nVar = (com.baidu.adp.widget.ListView.n) com.baidu.tbadk.core.util.y.getItem(arrayList, i - 1);
            com.baidu.adp.widget.ListView.n nVar2 = (com.baidu.adp.widget.ListView.n) com.baidu.tbadk.core.util.y.getItem(arrayList, i);
            if (nVar2 instanceof ca) {
                cb cbVar = ((ca) nVar2).eJQ;
                if (i == 0) {
                    cbVar.isFirstFloor = true;
                } else {
                    cbVar.isFirstFloor = false;
                }
                String blo = cbVar.blo();
                if (nVar instanceof com.baidu.tieba.frs.u) {
                    cbVar.needTopMargin = false;
                } else if (nVar != null && !c(nVar)) {
                    cbVar.needTopMargin = false;
                } else if ((nVar instanceof ca) && c(nVar) && !TextUtils.isEmpty(((ca) nVar).eJQ.blo())) {
                    cbVar.needTopMargin = true;
                } else if (c(nVar2) && !TextUtils.isEmpty(blo)) {
                    cbVar.needTopMargin = true;
                } else {
                    cbVar.needTopMargin = false;
                }
            }
        }
    }

    private boolean c(com.baidu.adp.widget.ListView.n nVar) {
        if (nVar == null) {
            return false;
        }
        BdUniqueId type = nVar.getType();
        return type == cb.eQm || type == cb.eQJ || type == cb.eQK || type == cb.eQT || type == cb.eRc;
    }

    private void cFe() {
        if (!com.baidu.tbadk.core.util.y.isEmpty(this.bns) && this.jiS != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.bns) {
                if (aVar instanceof com.baidu.tieba.frs.k) {
                    ((com.baidu.tieba.frs.k) aVar).a(this.jiS.getTbPageTag());
                }
            }
        }
    }

    private void cFI() {
        com.baidu.tieba.frs.b.b statisticMetaData;
        if (this.jru != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.bns) {
                if ((aVar instanceof com.baidu.tieba.frs.b.d) && (statisticMetaData = ((com.baidu.tieba.frs.b.d) aVar).getStatisticMetaData()) != null) {
                    if (this.jru.needLog == 1) {
                        statisticMetaData.jHy = true;
                    } else {
                        statisticMetaData.jHy = false;
                    }
                    if (this.jru.getForum() != null) {
                        statisticMetaData.jHA = this.jru.getForum().getId();
                    }
                    if (this.jiS != null && this.jiS.cCw() != null) {
                        int cJM = this.jiS.cCw().cJM();
                        if (cJM == -1) {
                            cJM = this.jiS.cCw().cJN();
                        }
                        statisticMetaData.jHz = cJM;
                    }
                }
            }
        }
    }

    private void cGF() {
        if (this.jru != null && this.jru.getForum() != null && !StringUtils.isNull(this.jru.getForum().getId()) && this.jrw != null) {
            this.jrw.setForumId(this.jru.getForum().getId());
        }
    }

    private void dm(List<com.baidu.adp.widget.ListView.a> list) {
        if (list != null) {
            for (com.baidu.adp.widget.ListView.a aVar : list) {
                if (aVar instanceof com.baidu.tieba.frs.k) {
                    ((com.baidu.tieba.frs.k) aVar).a(this.jfX);
                }
            }
        }
    }

    private void Ew(String str) {
        if (this.bns != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.bns) {
                if (aVar instanceof com.baidu.tieba.a.f) {
                    ((com.baidu.tieba.a.f) aVar).Ew(str);
                }
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.adapter.al
    public void a(com.baidu.tieba.frs.f fVar) {
        if (this.bns != null && this.bns.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.bns) {
                if (aVar instanceof com.baidu.tieba.frs.k) {
                    ((com.baidu.tieba.frs.k) aVar).a(fVar);
                }
            }
        }
    }
}
