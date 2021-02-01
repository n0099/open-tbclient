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
    private com.baidu.adp.widget.ListView.s iLK;
    private FrsFragment jiE;
    private final HashMap<Integer, cb> jrf;
    private FrsViewData jrg;
    private ai jri;
    private com.baidu.adp.widget.ListView.a jrj;
    private ac jrk;
    private o jrl;
    private z jrm;
    private w jrn;
    private n jro;
    private q jrp;
    private aa jrq;
    private ae jrr;
    private y jrs;
    private v jrt;
    private ad jru;
    private p jrv;
    private x jrw;
    private List<com.baidu.adp.widget.ListView.a> bns = new LinkedList();
    private boolean jrh = false;
    private final com.baidu.tieba.frs.i jfJ = new com.baidu.tieba.frs.i();

    public u(FrsFragment frsFragment, com.baidu.adp.widget.ListView.s sVar, boolean z) {
        this.iLK = sVar;
        a(frsFragment, sVar);
        this.jrf = new HashMap<>();
        rf(z);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r6v35, resolved type: com.baidu.tieba.frs.FrsFragment */
    /* JADX WARN: Multi-variable type inference failed */
    public void a(FrsFragment frsFragment, com.baidu.adp.widget.ListView.s sVar) {
        this.jiE = frsFragment;
        this.jrj = com.baidu.tieba.frs.e.cBA().a(frsFragment.getPageContext(), com.baidu.tieba.tbadkCore.x.nvo, this.jiE.getUniqueId(), false);
        this.jrk = new ac(frsFragment.getTbPageContext(), cb.eQs, this.jiE.getUniqueId());
        this.jrk.b(sVar);
        this.jrl = new o(frsFragment.getTbPageContext(), cb.eQt, this.jiE.getUniqueId());
        this.jrl.b(sVar);
        this.jrm = new z(frsFragment.getTbPageContext(), cb.eQv, this.jiE.getUniqueId());
        this.jrm.b(sVar);
        this.jrn = new w(frsFragment.getTbPageContext(), cb.eQw, this.jiE.getUniqueId());
        this.jrn.b(sVar);
        this.jro = new n(frsFragment.getTbPageContext(), cb.eQy, this.jiE.getUniqueId());
        this.jro.b(sVar);
        this.jrp = new q(frsFragment.getTbPageContext(), cb.eQz, this.jiE.getUniqueId());
        this.jrp.b(sVar);
        this.jrr = new ae(frsFragment.getTbPageContext(), cb.eQE, this.jiE.getUniqueId());
        this.jrr.b(sVar);
        this.jrq = new aa(frsFragment.getTbPageContext(), cb.eQY, this.jiE.getUniqueId());
        this.jrq.b(sVar);
        this.jrs = new y(frsFragment.getTbPageContext(), cb.eQF, this.jiE.getUniqueId());
        this.jrs.b(sVar);
        this.jrt = new v(frsFragment.getTbPageContext(), cb.eQG, this.jiE.getUniqueId());
        this.jrt.b(sVar);
        this.jru = new ad(frsFragment.getPageContext(), cb.eQK, this.jiE.getUniqueId());
        this.jru.b(sVar);
        this.jrv = new p(frsFragment.getPageContext(), cb.eRd, this.jiE.getUniqueId());
        this.jrv.b(sVar);
        t tVar = new t(frsFragment.getPageContext(), cb.eQI, this.jiE.getUniqueId());
        tVar.b(sVar);
        ab abVar = new ab(frsFragment.getPageContext(), cb.eQP, this.jiE.getUniqueId());
        abVar.b(sVar);
        a aVar = new a(frsFragment.getPageContext(), cb.eQB, frsFragment.getUniqueId());
        aVar.b(sVar);
        aVar.uX(1);
        d dVar = new d(frsFragment.getPageContext(), cb.eQx, frsFragment.getUniqueId());
        dVar.b(sVar);
        b bVar = new b(frsFragment.getPageContext(), cb.eQR, this.jiE.getUniqueId());
        bVar.b(sVar);
        bVar.setInFrsAllThread(true);
        i iVar = new i(frsFragment.getPageContext(), cb.eQQ, this.jiE.getUniqueId());
        iVar.b(sVar);
        iVar.setInFrsAllThread(true);
        j jVar = new j(frsFragment.getPageContext(), cb.eQS, this.jiE.getUniqueId());
        jVar.b(sVar);
        jVar.setInFrsAllThread(true);
        ad adVar = new ad(frsFragment.getPageContext(), cb.eQT, this.jiE.getUniqueId());
        adVar.b(sVar);
        s sVar2 = new s(frsFragment.getPageContext(), cb.eRc, this.jiE.getUniqueId());
        sVar2.b(sVar);
        r rVar = new r(frsFragment.getPageContext(), cb.eQU, this.jiE.getUniqueId());
        rVar.b(sVar);
        this.jri = new ai(frsFragment.getPageContext(), com.baidu.tieba.tbadkCore.q.nvg, this.jiE.getUniqueId());
        this.jrw = new x(frsFragment.getPageContext(), cb.eQJ, this.jiE.getUniqueId());
        this.jrw.b(sVar);
        com.baidu.adp.widget.ListView.a<? extends ca, ? extends TypeAdapter.ViewHolder> a2 = com.baidu.tieba.frs.e.cBA().a(frsFragment.getPageContext(), this.jiE.getUniqueId(), true);
        com.baidu.adp.widget.ListView.a<? extends cb, ? extends TypeAdapter.ViewHolder> b2 = com.baidu.tieba.frs.e.cBA().b(frsFragment.getPageContext(), cb.eSx, this.jiE.getUniqueId());
        com.baidu.tieba.frs.r rVar2 = new com.baidu.tieba.frs.r(frsFragment.getPageContext(), com.baidu.tieba.frs.s.jjF);
        m mVar = new m(frsFragment.getPageContext(), com.baidu.tieba.frs.u.jjW);
        FrsUserRecommendAdapter frsUserRecommendAdapter = new FrsUserRecommendAdapter(frsFragment.getPageContext(), com.baidu.tieba.frs.w.jkf, this.jiE.getUniqueId());
        g gVar = new g(frsFragment.getPageContext(), cb.eQD, this.jiE.getUniqueId());
        gVar.a((BdTypeRecyclerView) sVar);
        this.bns.add(this.jrj);
        this.bns.add(this.jrk);
        this.bns.add(this.jrl);
        this.bns.add(this.jrm);
        this.bns.add(this.jrn);
        this.bns.add(this.jro);
        this.bns.add(this.jrp);
        this.bns.add(this.jrq);
        this.bns.add(this.jrr);
        this.bns.add(this.jrs);
        this.bns.add(this.jrt);
        this.bns.add(this.jri);
        this.bns.add(tVar);
        this.bns.add(abVar);
        this.bns.add(aVar);
        this.bns.add(dVar);
        this.bns.add(bVar);
        this.bns.add(iVar);
        this.bns.add(jVar);
        this.bns.add(this.jrw);
        this.bns.add(this.jru);
        this.bns.add(this.jrv);
        this.bns.add(a2);
        this.bns.add(b2);
        this.bns.add(rVar2);
        this.bns.add(mVar);
        this.bns.add(sVar2);
        this.bns.add(rVar);
        this.bns.add(frsUserRecommendAdapter);
        this.bns.add(adVar);
        this.bns.add(gVar);
        this.bns.add(com.baidu.tieba.h.b.cNm().c(this.jiE.getBaseFragmentActivity(), AdvertAppInfo.eLm));
        com.baidu.tieba.InjectPlugin.b.b bVar2 = new com.baidu.tieba.InjectPlugin.b.b(this.jiE, 1);
        bVar2.setExtraData(this.bns);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_FEED_AD_PLUGIN_OPERATE, bVar2));
        dm(this.bns);
        sVar.addAdapters(this.bns);
        AbsDelegateAdapterList absDelegateAdapterList = new AbsDelegateAdapterList();
        CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_ADD_ADAPTER, absDelegateAdapterList);
        CustomMessage customMessage = new CustomMessage(CmdConfigCustom.CMD_FRS_ADD_ADAPTER);
        customMessage.setTag(this.jiE.getUniqueId());
        customResponsedMessage.setOrginalMessage(customMessage);
        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
        Ey("page_frs");
        if (!absDelegateAdapterList.isEmpty()) {
            Iterator it = absDelegateAdapterList.iterator();
            while (it.hasNext()) {
                com.baidu.adp.widget.ListView.a aVar2 = (com.baidu.adp.widget.ListView.a) it.next();
                if (aVar2 instanceof com.baidu.tieba.frs.k) {
                    ((com.baidu.tieba.frs.k) aVar2).a(this.jiE.getPageContext(), this.jiE.getUniqueId());
                }
            }
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(absDelegateAdapterList);
            if (this.bns != null) {
                this.bns.addAll(arrayList);
            }
            if (this.iLK != null) {
                this.iLK.addAdapters(arrayList);
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
    public HashMap<Integer, cb> cGs() {
        return this.jrf;
    }

    @Override // com.baidu.tieba.frs.entelechy.adapter.al
    public void notifyDataSetChanged() {
        if (this.iLK.getListAdapter() != null) {
            this.iLK.getListAdapter().notifyDataSetChanged();
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.adapter.al
    public int cGt() {
        if (this.jrj != null) {
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
    public void cGu() {
        if (this.bns != null && this.bns.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.bns) {
                if (aVar instanceof com.baidu.tieba.frs.k) {
                    ((com.baidu.tieba.frs.k) aVar).a(this.jiE.getPageContext(), this.jiE.getUniqueId());
                }
            }
            dm(this.bns);
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.adapter.al
    public List<com.baidu.adp.widget.ListView.n> getDatas() {
        if (this.iLK != null) {
            return this.iLK.getData();
        }
        return null;
    }

    @Override // com.baidu.tieba.frs.entelechy.adapter.al
    public int cGv() {
        if (this.jrj != null) {
            return R.id.frs_fortune_bag_item;
        }
        return 0;
    }

    @Override // com.baidu.tieba.frs.entelechy.adapter.al
    public int cGw() {
        if (this.jrj != null) {
            return R.id.frs_my_service_item;
        }
        return 0;
    }

    public void bbC() {
        if (this.dataList != null) {
            this.iLK.setData(this.dataList);
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
            if (this.jrk != null) {
                this.jrk.setFromCDN(z);
            }
            if (this.jrl != null) {
                this.jrl.setFromCDN(z);
            }
            if (this.jrm != null) {
                this.jrm.setFromCDN(z);
            }
            if (this.jrn != null) {
                this.jrn.setFromCDN(z);
            }
            if (this.jro != null) {
                this.jro.setFromCDN(z);
            }
            if (this.jrp != null) {
                this.jrp.setFromCDN(z);
            }
            if (this.jru != null) {
                this.jru.setFromCDN(z);
            }
            if (this.jrw != null) {
                this.jrw.setFromCDN(z);
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.adapter.al
    public void cGx() {
        List<com.baidu.adp.widget.ListView.n> data;
        if (this.iLK != null && this.iLK.getData() != null && this.iLK.getData().size() != 0 && (data = this.iLK.getData()) != null && data.size() != 0) {
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
        if (this.jrh != z) {
            this.jrh = z;
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.adapter.al
    public void b(ArrayList<com.baidu.adp.widget.ListView.n> arrayList, FrsViewData frsViewData) {
        b(frsViewData);
        cEX();
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
        this.iLK.setData(arrayList);
        this.jrg = frsViewData;
        cFB();
        cGy();
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
                if (this.jrf != null && !this.jrf.containsValue(nVar)) {
                    this.jrf.put(Integer.valueOf(i2), (cb) nVar);
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

    private void cEX() {
        if (!com.baidu.tbadk.core.util.y.isEmpty(this.bns) && this.jiE != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.bns) {
                if (aVar instanceof com.baidu.tieba.frs.k) {
                    ((com.baidu.tieba.frs.k) aVar).a(this.jiE.getTbPageTag());
                }
            }
        }
    }

    private void cFB() {
        com.baidu.tieba.frs.b.b statisticMetaData;
        if (this.jrg != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.bns) {
                if ((aVar instanceof com.baidu.tieba.frs.b.d) && (statisticMetaData = ((com.baidu.tieba.frs.b.d) aVar).getStatisticMetaData()) != null) {
                    if (this.jrg.needLog == 1) {
                        statisticMetaData.jHk = true;
                    } else {
                        statisticMetaData.jHk = false;
                    }
                    if (this.jrg.getForum() != null) {
                        statisticMetaData.jHm = this.jrg.getForum().getId();
                    }
                    if (this.jiE != null && this.jiE.cCp() != null) {
                        int cJF = this.jiE.cCp().cJF();
                        if (cJF == -1) {
                            cJF = this.jiE.cCp().cJG();
                        }
                        statisticMetaData.jHl = cJF;
                    }
                }
            }
        }
    }

    private void cGy() {
        if (this.jrg != null && this.jrg.getForum() != null && !StringUtils.isNull(this.jrg.getForum().getId()) && this.jri != null) {
            this.jri.setForumId(this.jrg.getForum().getId());
        }
    }

    private void dm(List<com.baidu.adp.widget.ListView.a> list) {
        if (list != null) {
            for (com.baidu.adp.widget.ListView.a aVar : list) {
                if (aVar instanceof com.baidu.tieba.frs.k) {
                    ((com.baidu.tieba.frs.k) aVar).a(this.jfJ);
                }
            }
        }
    }

    private void Ey(String str) {
        if (this.bns != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.bns) {
                if (aVar instanceof com.baidu.tieba.a.f) {
                    ((com.baidu.tieba.a.f) aVar).Ey(str);
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
