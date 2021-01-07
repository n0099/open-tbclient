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
import com.baidu.tbadk.core.data.by;
import com.baidu.tbadk.core.data.bz;
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
    private com.baidu.adp.widget.ListView.s iKI;
    private FrsFragment jhE;
    private final HashMap<Integer, bz> jqf;
    private FrsViewData jqg;
    private ai jqi;
    private com.baidu.adp.widget.ListView.a jqj;
    private ac jqk;
    private o jql;
    private z jqm;
    private w jqn;
    private n jqo;
    private q jqp;
    private aa jqq;
    private ae jqr;
    private y jqs;
    private v jqt;
    private ad jqu;
    private p jqv;
    private x jqw;
    private List<com.baidu.adp.widget.ListView.a> boM = new LinkedList();
    private boolean jqh = false;
    private final com.baidu.tieba.frs.i jeK = new com.baidu.tieba.frs.i();

    public u(FrsFragment frsFragment, com.baidu.adp.widget.ListView.s sVar, boolean z) {
        this.iKI = sVar;
        a(frsFragment, sVar);
        this.jqf = new HashMap<>();
        qZ(z);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r6v35, resolved type: com.baidu.tieba.frs.FrsFragment */
    /* JADX WARN: Multi-variable type inference failed */
    public void a(FrsFragment frsFragment, com.baidu.adp.widget.ListView.s sVar) {
        this.jhE = frsFragment;
        this.jqj = com.baidu.tieba.frs.e.cEh().a(frsFragment.getPageContext(), com.baidu.tieba.tbadkCore.x.nqm, this.jhE.getUniqueId(), false);
        this.jqk = new ac(frsFragment.getTbPageContext(), bz.eSR, this.jhE.getUniqueId());
        this.jqk.b(sVar);
        this.jql = new o(frsFragment.getTbPageContext(), bz.eSS, this.jhE.getUniqueId());
        this.jql.b(sVar);
        this.jqm = new z(frsFragment.getTbPageContext(), bz.eSU, this.jhE.getUniqueId());
        this.jqm.b(sVar);
        this.jqn = new w(frsFragment.getTbPageContext(), bz.eSV, this.jhE.getUniqueId());
        this.jqn.b(sVar);
        this.jqo = new n(frsFragment.getTbPageContext(), bz.eSX, this.jhE.getUniqueId());
        this.jqo.b(sVar);
        this.jqp = new q(frsFragment.getTbPageContext(), bz.eSY, this.jhE.getUniqueId());
        this.jqp.b(sVar);
        this.jqr = new ae(frsFragment.getTbPageContext(), bz.eTd, this.jhE.getUniqueId());
        this.jqr.b(sVar);
        this.jqq = new aa(frsFragment.getTbPageContext(), bz.eTx, this.jhE.getUniqueId());
        this.jqq.b(sVar);
        this.jqs = new y(frsFragment.getTbPageContext(), bz.eTe, this.jhE.getUniqueId());
        this.jqs.b(sVar);
        this.jqt = new v(frsFragment.getTbPageContext(), bz.eTf, this.jhE.getUniqueId());
        this.jqt.b(sVar);
        this.jqu = new ad(frsFragment.getPageContext(), bz.eTj, this.jhE.getUniqueId());
        this.jqu.b(sVar);
        this.jqv = new p(frsFragment.getPageContext(), bz.eTC, this.jhE.getUniqueId());
        this.jqv.b(sVar);
        t tVar = new t(frsFragment.getPageContext(), bz.eTh, this.jhE.getUniqueId());
        tVar.b(sVar);
        ab abVar = new ab(frsFragment.getPageContext(), bz.eTo, this.jhE.getUniqueId());
        abVar.b(sVar);
        a aVar = new a(frsFragment.getPageContext(), bz.eTa, frsFragment.getUniqueId());
        aVar.b(sVar);
        aVar.wt(1);
        d dVar = new d(frsFragment.getPageContext(), bz.eSW, frsFragment.getUniqueId());
        dVar.b(sVar);
        b bVar = new b(frsFragment.getPageContext(), bz.eTq, this.jhE.getUniqueId());
        bVar.b(sVar);
        bVar.setInFrsAllThread(true);
        i iVar = new i(frsFragment.getPageContext(), bz.eTp, this.jhE.getUniqueId());
        iVar.b(sVar);
        iVar.setInFrsAllThread(true);
        j jVar = new j(frsFragment.getPageContext(), bz.eTr, this.jhE.getUniqueId());
        jVar.b(sVar);
        jVar.setInFrsAllThread(true);
        ad adVar = new ad(frsFragment.getPageContext(), bz.eTs, this.jhE.getUniqueId());
        adVar.b(sVar);
        s sVar2 = new s(frsFragment.getPageContext(), bz.eTB, this.jhE.getUniqueId());
        sVar2.b(sVar);
        r rVar = new r(frsFragment.getPageContext(), bz.eTt, this.jhE.getUniqueId());
        rVar.b(sVar);
        this.jqi = new ai(frsFragment.getPageContext(), com.baidu.tieba.tbadkCore.q.nqe, this.jhE.getUniqueId());
        this.jqw = new x(frsFragment.getPageContext(), bz.eTi, this.jhE.getUniqueId());
        this.jqw.b(sVar);
        com.baidu.adp.widget.ListView.a<? extends by, ? extends TypeAdapter.ViewHolder> a2 = com.baidu.tieba.frs.e.cEh().a(frsFragment.getPageContext(), this.jhE.getUniqueId(), true);
        com.baidu.adp.widget.ListView.a<? extends bz, ? extends TypeAdapter.ViewHolder> b2 = com.baidu.tieba.frs.e.cEh().b(frsFragment.getPageContext(), bz.eUW, this.jhE.getUniqueId());
        com.baidu.tieba.frs.r rVar2 = new com.baidu.tieba.frs.r(frsFragment.getPageContext(), com.baidu.tieba.frs.s.jiG);
        m mVar = new m(frsFragment.getPageContext(), com.baidu.tieba.frs.u.jiX);
        FrsUserRecommendAdapter frsUserRecommendAdapter = new FrsUserRecommendAdapter(frsFragment.getPageContext(), com.baidu.tieba.frs.w.jjg, this.jhE.getUniqueId());
        g gVar = new g(frsFragment.getPageContext(), bz.eTc, this.jhE.getUniqueId());
        gVar.a((BdTypeRecyclerView) sVar);
        this.boM.add(this.jqj);
        this.boM.add(this.jqk);
        this.boM.add(this.jql);
        this.boM.add(this.jqm);
        this.boM.add(this.jqn);
        this.boM.add(this.jqo);
        this.boM.add(this.jqp);
        this.boM.add(this.jqq);
        this.boM.add(this.jqr);
        this.boM.add(this.jqs);
        this.boM.add(this.jqt);
        this.boM.add(this.jqi);
        this.boM.add(tVar);
        this.boM.add(abVar);
        this.boM.add(aVar);
        this.boM.add(dVar);
        this.boM.add(bVar);
        this.boM.add(iVar);
        this.boM.add(jVar);
        this.boM.add(this.jqw);
        this.boM.add(this.jqu);
        this.boM.add(this.jqv);
        this.boM.add(a2);
        this.boM.add(b2);
        this.boM.add(rVar2);
        this.boM.add(mVar);
        this.boM.add(sVar2);
        this.boM.add(rVar);
        this.boM.add(frsUserRecommendAdapter);
        this.boM.add(adVar);
        this.boM.add(gVar);
        this.boM.add(com.baidu.tieba.h.b.cPq().c(this.jhE.getBaseFragmentActivity(), AdvertAppInfo.eNL));
        com.baidu.tieba.InjectPlugin.b.b bVar2 = new com.baidu.tieba.InjectPlugin.b.b(this.jhE, 1);
        bVar2.setExtraData(this.boM);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_FEED_AD_PLUGIN_OPERATE, bVar2));
        dr(this.boM);
        sVar.addAdapters(this.boM);
        AbsDelegateAdapterList absDelegateAdapterList = new AbsDelegateAdapterList();
        CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_ADD_ADAPTER, absDelegateAdapterList);
        CustomMessage customMessage = new CustomMessage(CmdConfigCustom.CMD_FRS_ADD_ADAPTER);
        customMessage.setTag(this.jhE.getUniqueId());
        customResponsedMessage.setOrginalMessage(customMessage);
        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
        Fl("page_frs");
        if (!absDelegateAdapterList.isEmpty()) {
            Iterator it = absDelegateAdapterList.iterator();
            while (it.hasNext()) {
                com.baidu.adp.widget.ListView.a aVar2 = (com.baidu.adp.widget.ListView.a) it.next();
                if (aVar2 instanceof com.baidu.tieba.frs.k) {
                    ((com.baidu.tieba.frs.k) aVar2).a(this.jhE.getPageContext(), this.jhE.getUniqueId());
                }
            }
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(absDelegateAdapterList);
            if (this.boM != null) {
                this.boM.addAll(arrayList);
            }
            if (this.iKI != null) {
                this.iKI.addAdapters(arrayList);
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.adapter.al
    public void onDestory() {
        for (com.baidu.adp.widget.ListView.a aVar : this.boM) {
            if (aVar instanceof com.baidu.tieba.frs.k) {
                ((com.baidu.tieba.frs.k) aVar).release();
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.adapter.al
    public HashMap<Integer, bz> cIX() {
        return this.jqf;
    }

    @Override // com.baidu.tieba.frs.entelechy.adapter.al
    public void notifyDataSetChanged() {
        if (this.iKI.getListAdapter() != null) {
            this.iKI.getListAdapter().notifyDataSetChanged();
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.adapter.al
    public int cIY() {
        if (this.jqj != null) {
            return R.id.frs_bawu_center;
        }
        return 0;
    }

    @Override // com.baidu.tieba.frs.entelechy.adapter.al
    public boolean r(BdUniqueId bdUniqueId) {
        if (bdUniqueId == null) {
            return false;
        }
        for (com.baidu.adp.widget.ListView.a aVar : this.boM) {
            if (aVar != null && aVar.getType() == bdUniqueId) {
                return true;
            }
        }
        return false;
    }

    @Override // com.baidu.tieba.frs.entelechy.adapter.al
    public void a(com.baidu.adp.widget.ListView.w wVar) {
        if (this.boM != null && this.boM.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.boM) {
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
        if (this.boM != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.boM) {
                if (aVar instanceof com.baidu.tieba.card.y) {
                    ((com.baidu.tieba.card.y) aVar).setForumName(str);
                }
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v1, resolved type: com.baidu.tieba.frs.FrsFragment */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.baidu.tieba.frs.entelechy.adapter.al
    public void cIZ() {
        if (this.boM != null && this.boM.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.boM) {
                if (aVar instanceof com.baidu.tieba.frs.k) {
                    ((com.baidu.tieba.frs.k) aVar).a(this.jhE.getPageContext(), this.jhE.getUniqueId());
                }
            }
            dr(this.boM);
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.adapter.al
    public List<com.baidu.adp.widget.ListView.n> getDatas() {
        if (this.iKI != null) {
            return this.iKI.getData();
        }
        return null;
    }

    @Override // com.baidu.tieba.frs.entelechy.adapter.al
    public int cJa() {
        if (this.jqj != null) {
            return R.id.frs_fortune_bag_item;
        }
        return 0;
    }

    @Override // com.baidu.tieba.frs.entelechy.adapter.al
    public int cJb() {
        if (this.jqj != null) {
            return R.id.frs_my_service_item;
        }
        return 0;
    }

    public void bfj() {
        if (this.dataList != null) {
            this.iKI.setData(this.dataList);
        }
        notifyDataSetChanged();
    }

    @Override // com.baidu.tieba.frs.entelechy.adapter.al
    public void setFromCDN(boolean z) {
        if (this.boM != null && this.boM.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.boM) {
                if (aVar instanceof com.baidu.tieba.frs.k) {
                    ((com.baidu.tieba.frs.k) aVar).setFromCDN(z);
                }
            }
            if (this.jqk != null) {
                this.jqk.setFromCDN(z);
            }
            if (this.jql != null) {
                this.jql.setFromCDN(z);
            }
            if (this.jqm != null) {
                this.jqm.setFromCDN(z);
            }
            if (this.jqn != null) {
                this.jqn.setFromCDN(z);
            }
            if (this.jqo != null) {
                this.jqo.setFromCDN(z);
            }
            if (this.jqp != null) {
                this.jqp.setFromCDN(z);
            }
            if (this.jqu != null) {
                this.jqu.setFromCDN(z);
            }
            if (this.jqw != null) {
                this.jqw.setFromCDN(z);
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.adapter.al
    public void cJc() {
        List<com.baidu.adp.widget.ListView.n> data;
        if (this.iKI != null && this.iKI.getData() != null && this.iKI.getData().size() != 0 && (data = this.iKI.getData()) != null && data.size() != 0) {
            for (com.baidu.adp.widget.ListView.n nVar : data) {
                if (nVar instanceof bz) {
                    if (((bz) nVar).brm() != 0) {
                        ((bz) nVar).bsr();
                    }
                } else if ((nVar instanceof by) && ((by) nVar).eMv.brm() != 0) {
                    ((by) nVar).eMv.bsr();
                }
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.adapter.al
    public void qZ(boolean z) {
        if (this.jqh != z) {
            this.jqh = z;
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.adapter.al
    public void b(ArrayList<com.baidu.adp.widget.ListView.n> arrayList, FrsViewData frsViewData) {
        b(frsViewData);
        cHD();
        com.baidu.tieba.tbadkCore.v.x(arrayList, 1);
        aB(arrayList);
        aC(arrayList);
        aD(arrayList);
        Iterator<com.baidu.adp.widget.ListView.n> it = arrayList.iterator();
        while (it.hasNext()) {
            com.baidu.adp.widget.ListView.n next = it.next();
            if ((next instanceof by) && ((by) next).eMv.bsb()) {
                it.remove();
            }
        }
        this.iKI.setData(arrayList);
        this.jqg = frsViewData;
        cIg();
        cJd();
        this.dataList = arrayList;
    }

    public void b(FrsViewData frsViewData) {
        if (this.boM != null && this.boM.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.boM) {
                if (aVar instanceof com.baidu.tieba.frs.k) {
                    ((com.baidu.tieba.frs.k) aVar).b(frsViewData);
                }
            }
        }
    }

    private ArrayList<Integer> aB(ArrayList<com.baidu.adp.widget.ListView.n> arrayList) {
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
                if (this.jqf != null && !this.jqf.containsValue(nVar)) {
                    this.jqf.put(Integer.valueOf(i2), (bz) nVar);
                }
            }
            i = i2 + 1;
        }
    }

    private void aC(ArrayList<com.baidu.adp.widget.ListView.n> arrayList) {
        int i;
        if (this.boM != null && this.boM.size() != 0) {
            int i2 = 0;
            if (arrayList == null || arrayList.size() <= 0) {
                i = 0;
            } else {
                Iterator<com.baidu.adp.widget.ListView.n> it = arrayList.iterator();
                while (true) {
                    i = i2;
                    if (!it.hasNext() || it.next().getType().getId() != bz.eSK.getId()) {
                        break;
                    }
                    i2 = i + 1;
                }
            }
            for (com.baidu.adp.widget.ListView.a aVar : this.boM) {
                if (aVar instanceof com.baidu.tieba.frs.k) {
                    ((com.baidu.tieba.frs.k) aVar).zQ(i);
                }
            }
        }
    }

    private void aD(ArrayList<com.baidu.adp.widget.ListView.n> arrayList) {
        int count = com.baidu.tbadk.core.util.x.getCount(arrayList);
        for (int i = 0; i < count; i++) {
            com.baidu.adp.widget.ListView.n nVar = (com.baidu.adp.widget.ListView.n) com.baidu.tbadk.core.util.x.getItem(arrayList, i - 1);
            com.baidu.adp.widget.ListView.n nVar2 = (com.baidu.adp.widget.ListView.n) com.baidu.tbadk.core.util.x.getItem(arrayList, i);
            if (nVar2 instanceof by) {
                bz bzVar = ((by) nVar2).eMv;
                if (i == 0) {
                    bzVar.isFirstFloor = true;
                } else {
                    bzVar.isFirstFloor = false;
                }
                String boQ = bzVar.boQ();
                if (nVar instanceof com.baidu.tieba.frs.u) {
                    bzVar.needTopMargin = false;
                } else if (nVar != null && !c(nVar)) {
                    bzVar.needTopMargin = false;
                } else if ((nVar instanceof by) && c(nVar) && !TextUtils.isEmpty(((by) nVar).eMv.boQ())) {
                    bzVar.needTopMargin = true;
                } else if (c(nVar2) && !TextUtils.isEmpty(boQ)) {
                    bzVar.needTopMargin = true;
                } else {
                    bzVar.needTopMargin = false;
                }
            }
        }
    }

    private boolean c(com.baidu.adp.widget.ListView.n nVar) {
        if (nVar == null) {
            return false;
        }
        BdUniqueId type = nVar.getType();
        return type == bz.eSL || type == bz.eTi || type == bz.eTj || type == bz.eTs || type == bz.eTB;
    }

    private void cHD() {
        if (!com.baidu.tbadk.core.util.x.isEmpty(this.boM) && this.jhE != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.boM) {
                if (aVar instanceof com.baidu.tieba.frs.k) {
                    ((com.baidu.tieba.frs.k) aVar).a(this.jhE.getTbPageTag());
                }
            }
        }
    }

    private void cIg() {
        com.baidu.tieba.frs.b.b statisticMetaData;
        if (this.jqg != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.boM) {
                if ((aVar instanceof com.baidu.tieba.frs.b.d) && (statisticMetaData = ((com.baidu.tieba.frs.b.d) aVar).getStatisticMetaData()) != null) {
                    if (this.jqg.needLog == 1) {
                        statisticMetaData.jGm = true;
                    } else {
                        statisticMetaData.jGm = false;
                    }
                    if (this.jqg.getForum() != null) {
                        statisticMetaData.jGo = this.jqg.getForum().getId();
                    }
                    if (this.jhE != null && this.jhE.cEV() != null) {
                        int cMk = this.jhE.cEV().cMk();
                        if (cMk == -1) {
                            cMk = this.jhE.cEV().cMl();
                        }
                        statisticMetaData.jGn = cMk;
                    }
                }
            }
        }
    }

    private void cJd() {
        if (this.jqg != null && this.jqg.getForum() != null && !StringUtils.isNull(this.jqg.getForum().getId()) && this.jqi != null) {
            this.jqi.setForumId(this.jqg.getForum().getId());
        }
    }

    private void dr(List<com.baidu.adp.widget.ListView.a> list) {
        if (list != null) {
            for (com.baidu.adp.widget.ListView.a aVar : list) {
                if (aVar instanceof com.baidu.tieba.frs.k) {
                    ((com.baidu.tieba.frs.k) aVar).a(this.jeK);
                }
            }
        }
    }

    private void Fl(String str) {
        if (this.boM != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.boM) {
                if (aVar instanceof com.baidu.tieba.a.f) {
                    ((com.baidu.tieba.a.f) aVar).Fl(str);
                }
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.adapter.al
    public void a(com.baidu.tieba.frs.f fVar) {
        if (this.boM != null && this.boM.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.boM) {
                if (aVar instanceof com.baidu.tieba.frs.k) {
                    ((com.baidu.tieba.frs.k) aVar).a(fVar);
                }
            }
        }
    }
}
