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
    private com.baidu.adp.widget.ListView.s iGb;
    private FrsFragment jcX;
    private ai jlB;
    private com.baidu.adp.widget.ListView.a jlC;
    private ac jlD;
    private o jlE;
    private z jlF;
    private w jlG;
    private n jlH;
    private q jlI;
    private aa jlJ;
    private ae jlK;
    private y jlL;
    private v jlM;
    private ad jlN;
    private p jlO;
    private x jlP;
    private final HashMap<Integer, bz> jly;
    private FrsViewData jlz;
    private List<com.baidu.adp.widget.ListView.a> bjZ = new LinkedList();
    private boolean jlA = false;
    private final com.baidu.tieba.frs.i jad = new com.baidu.tieba.frs.i();

    public u(FrsFragment frsFragment, com.baidu.adp.widget.ListView.s sVar, boolean z) {
        this.iGb = sVar;
        a(frsFragment, sVar);
        this.jly = new HashMap<>();
        qV(z);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r6v35, resolved type: com.baidu.tieba.frs.FrsFragment */
    /* JADX WARN: Multi-variable type inference failed */
    public void a(FrsFragment frsFragment, com.baidu.adp.widget.ListView.s sVar) {
        this.jcX = frsFragment;
        this.jlC = com.baidu.tieba.frs.e.cAp().a(frsFragment.getPageContext(), com.baidu.tieba.tbadkCore.x.nlF, this.jcX.getUniqueId(), false);
        this.jlD = new ac(frsFragment.getTbPageContext(), bz.eOg, this.jcX.getUniqueId());
        this.jlD.b(sVar);
        this.jlE = new o(frsFragment.getTbPageContext(), bz.eOh, this.jcX.getUniqueId());
        this.jlE.b(sVar);
        this.jlF = new z(frsFragment.getTbPageContext(), bz.eOj, this.jcX.getUniqueId());
        this.jlF.b(sVar);
        this.jlG = new w(frsFragment.getTbPageContext(), bz.eOk, this.jcX.getUniqueId());
        this.jlG.b(sVar);
        this.jlH = new n(frsFragment.getTbPageContext(), bz.eOm, this.jcX.getUniqueId());
        this.jlH.b(sVar);
        this.jlI = new q(frsFragment.getTbPageContext(), bz.eOn, this.jcX.getUniqueId());
        this.jlI.b(sVar);
        this.jlK = new ae(frsFragment.getTbPageContext(), bz.eOs, this.jcX.getUniqueId());
        this.jlK.b(sVar);
        this.jlJ = new aa(frsFragment.getTbPageContext(), bz.eOM, this.jcX.getUniqueId());
        this.jlJ.b(sVar);
        this.jlL = new y(frsFragment.getTbPageContext(), bz.eOt, this.jcX.getUniqueId());
        this.jlL.b(sVar);
        this.jlM = new v(frsFragment.getTbPageContext(), bz.eOu, this.jcX.getUniqueId());
        this.jlM.b(sVar);
        this.jlN = new ad(frsFragment.getPageContext(), bz.eOy, this.jcX.getUniqueId());
        this.jlN.b(sVar);
        this.jlO = new p(frsFragment.getPageContext(), bz.eOR, this.jcX.getUniqueId());
        this.jlO.b(sVar);
        t tVar = new t(frsFragment.getPageContext(), bz.eOw, this.jcX.getUniqueId());
        tVar.b(sVar);
        ab abVar = new ab(frsFragment.getPageContext(), bz.eOD, this.jcX.getUniqueId());
        abVar.b(sVar);
        a aVar = new a(frsFragment.getPageContext(), bz.eOp, frsFragment.getUniqueId());
        aVar.b(sVar);
        aVar.uN(1);
        d dVar = new d(frsFragment.getPageContext(), bz.eOl, frsFragment.getUniqueId());
        dVar.b(sVar);
        b bVar = new b(frsFragment.getPageContext(), bz.eOF, this.jcX.getUniqueId());
        bVar.b(sVar);
        bVar.setInFrsAllThread(true);
        i iVar = new i(frsFragment.getPageContext(), bz.eOE, this.jcX.getUniqueId());
        iVar.b(sVar);
        iVar.setInFrsAllThread(true);
        j jVar = new j(frsFragment.getPageContext(), bz.eOG, this.jcX.getUniqueId());
        jVar.b(sVar);
        jVar.setInFrsAllThread(true);
        ad adVar = new ad(frsFragment.getPageContext(), bz.eOH, this.jcX.getUniqueId());
        adVar.b(sVar);
        s sVar2 = new s(frsFragment.getPageContext(), bz.eOQ, this.jcX.getUniqueId());
        sVar2.b(sVar);
        r rVar = new r(frsFragment.getPageContext(), bz.eOI, this.jcX.getUniqueId());
        rVar.b(sVar);
        this.jlB = new ai(frsFragment.getPageContext(), com.baidu.tieba.tbadkCore.q.nlx, this.jcX.getUniqueId());
        this.jlP = new x(frsFragment.getPageContext(), bz.eOx, this.jcX.getUniqueId());
        this.jlP.b(sVar);
        com.baidu.adp.widget.ListView.a<? extends by, ? extends TypeAdapter.ViewHolder> a2 = com.baidu.tieba.frs.e.cAp().a(frsFragment.getPageContext(), this.jcX.getUniqueId(), true);
        com.baidu.adp.widget.ListView.a<? extends bz, ? extends TypeAdapter.ViewHolder> b2 = com.baidu.tieba.frs.e.cAp().b(frsFragment.getPageContext(), bz.eQl, this.jcX.getUniqueId());
        com.baidu.tieba.frs.r rVar2 = new com.baidu.tieba.frs.r(frsFragment.getPageContext(), com.baidu.tieba.frs.s.jdY);
        m mVar = new m(frsFragment.getPageContext(), com.baidu.tieba.frs.u.jep);
        FrsUserRecommendAdapter frsUserRecommendAdapter = new FrsUserRecommendAdapter(frsFragment.getPageContext(), com.baidu.tieba.frs.w.jey, this.jcX.getUniqueId());
        g gVar = new g(frsFragment.getPageContext(), bz.eOr, this.jcX.getUniqueId());
        gVar.a((BdTypeRecyclerView) sVar);
        this.bjZ.add(this.jlC);
        this.bjZ.add(this.jlD);
        this.bjZ.add(this.jlE);
        this.bjZ.add(this.jlF);
        this.bjZ.add(this.jlG);
        this.bjZ.add(this.jlH);
        this.bjZ.add(this.jlI);
        this.bjZ.add(this.jlJ);
        this.bjZ.add(this.jlK);
        this.bjZ.add(this.jlL);
        this.bjZ.add(this.jlM);
        this.bjZ.add(this.jlB);
        this.bjZ.add(tVar);
        this.bjZ.add(abVar);
        this.bjZ.add(aVar);
        this.bjZ.add(dVar);
        this.bjZ.add(bVar);
        this.bjZ.add(iVar);
        this.bjZ.add(jVar);
        this.bjZ.add(this.jlP);
        this.bjZ.add(this.jlN);
        this.bjZ.add(this.jlO);
        this.bjZ.add(a2);
        this.bjZ.add(b2);
        this.bjZ.add(rVar2);
        this.bjZ.add(mVar);
        this.bjZ.add(sVar2);
        this.bjZ.add(rVar);
        this.bjZ.add(frsUserRecommendAdapter);
        this.bjZ.add(adVar);
        this.bjZ.add(gVar);
        this.bjZ.add(com.baidu.tieba.h.b.cLy().c(this.jcX.getBaseFragmentActivity(), AdvertAppInfo.eJa));
        com.baidu.tieba.InjectPlugin.b.b bVar2 = new com.baidu.tieba.InjectPlugin.b.b(this.jcX, 1);
        bVar2.setExtraData(this.bjZ);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_FEED_AD_PLUGIN_OPERATE, bVar2));
        dr(this.bjZ);
        sVar.addAdapters(this.bjZ);
        AbsDelegateAdapterList absDelegateAdapterList = new AbsDelegateAdapterList();
        CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_ADD_ADAPTER, absDelegateAdapterList);
        CustomMessage customMessage = new CustomMessage(CmdConfigCustom.CMD_FRS_ADD_ADAPTER);
        customMessage.setTag(this.jcX.getUniqueId());
        customResponsedMessage.setOrginalMessage(customMessage);
        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
        Ea("page_frs");
        if (!absDelegateAdapterList.isEmpty()) {
            Iterator it = absDelegateAdapterList.iterator();
            while (it.hasNext()) {
                com.baidu.adp.widget.ListView.a aVar2 = (com.baidu.adp.widget.ListView.a) it.next();
                if (aVar2 instanceof com.baidu.tieba.frs.k) {
                    ((com.baidu.tieba.frs.k) aVar2).a(this.jcX.getPageContext(), this.jcX.getUniqueId());
                }
            }
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(absDelegateAdapterList);
            if (this.bjZ != null) {
                this.bjZ.addAll(arrayList);
            }
            if (this.iGb != null) {
                this.iGb.addAdapters(arrayList);
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.adapter.al
    public void onDestory() {
        for (com.baidu.adp.widget.ListView.a aVar : this.bjZ) {
            if (aVar instanceof com.baidu.tieba.frs.k) {
                ((com.baidu.tieba.frs.k) aVar).release();
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.adapter.al
    public HashMap<Integer, bz> cFf() {
        return this.jly;
    }

    @Override // com.baidu.tieba.frs.entelechy.adapter.al
    public void notifyDataSetChanged() {
        if (this.iGb.getListAdapter() != null) {
            this.iGb.getListAdapter().notifyDataSetChanged();
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.adapter.al
    public int cFg() {
        if (this.jlC != null) {
            return R.id.frs_bawu_center;
        }
        return 0;
    }

    @Override // com.baidu.tieba.frs.entelechy.adapter.al
    public boolean r(BdUniqueId bdUniqueId) {
        if (bdUniqueId == null) {
            return false;
        }
        for (com.baidu.adp.widget.ListView.a aVar : this.bjZ) {
            if (aVar != null && aVar.getType() == bdUniqueId) {
                return true;
            }
        }
        return false;
    }

    @Override // com.baidu.tieba.frs.entelechy.adapter.al
    public void a(com.baidu.adp.widget.ListView.w wVar) {
        if (this.bjZ != null && this.bjZ.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.bjZ) {
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
        if (this.bjZ != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.bjZ) {
                if (aVar instanceof com.baidu.tieba.card.y) {
                    ((com.baidu.tieba.card.y) aVar).setForumName(str);
                }
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v1, resolved type: com.baidu.tieba.frs.FrsFragment */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.baidu.tieba.frs.entelechy.adapter.al
    public void cFh() {
        if (this.bjZ != null && this.bjZ.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.bjZ) {
                if (aVar instanceof com.baidu.tieba.frs.k) {
                    ((com.baidu.tieba.frs.k) aVar).a(this.jcX.getPageContext(), this.jcX.getUniqueId());
                }
            }
            dr(this.bjZ);
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.adapter.al
    public List<com.baidu.adp.widget.ListView.n> getDatas() {
        if (this.iGb != null) {
            return this.iGb.getData();
        }
        return null;
    }

    @Override // com.baidu.tieba.frs.entelechy.adapter.al
    public int cFi() {
        if (this.jlC != null) {
            return R.id.frs_fortune_bag_item;
        }
        return 0;
    }

    @Override // com.baidu.tieba.frs.entelechy.adapter.al
    public int cFj() {
        if (this.jlC != null) {
            return R.id.frs_my_service_item;
        }
        return 0;
    }

    public void bbp() {
        if (this.dataList != null) {
            this.iGb.setData(this.dataList);
        }
        notifyDataSetChanged();
    }

    @Override // com.baidu.tieba.frs.entelechy.adapter.al
    public void setFromCDN(boolean z) {
        if (this.bjZ != null && this.bjZ.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.bjZ) {
                if (aVar instanceof com.baidu.tieba.frs.k) {
                    ((com.baidu.tieba.frs.k) aVar).setFromCDN(z);
                }
            }
            if (this.jlD != null) {
                this.jlD.setFromCDN(z);
            }
            if (this.jlE != null) {
                this.jlE.setFromCDN(z);
            }
            if (this.jlF != null) {
                this.jlF.setFromCDN(z);
            }
            if (this.jlG != null) {
                this.jlG.setFromCDN(z);
            }
            if (this.jlH != null) {
                this.jlH.setFromCDN(z);
            }
            if (this.jlI != null) {
                this.jlI.setFromCDN(z);
            }
            if (this.jlN != null) {
                this.jlN.setFromCDN(z);
            }
            if (this.jlP != null) {
                this.jlP.setFromCDN(z);
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.adapter.al
    public void cFk() {
        List<com.baidu.adp.widget.ListView.n> data;
        if (this.iGb != null && this.iGb.getData() != null && this.iGb.getData().size() != 0 && (data = this.iGb.getData()) != null && data.size() != 0) {
            for (com.baidu.adp.widget.ListView.n nVar : data) {
                if (nVar instanceof bz) {
                    if (((bz) nVar).bns() != 0) {
                        ((bz) nVar).box();
                    }
                } else if ((nVar instanceof by) && ((by) nVar).eHK.bns() != 0) {
                    ((by) nVar).eHK.box();
                }
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.adapter.al
    public void qV(boolean z) {
        if (this.jlA != z) {
            this.jlA = z;
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.adapter.al
    public void b(ArrayList<com.baidu.adp.widget.ListView.n> arrayList, FrsViewData frsViewData) {
        b(frsViewData);
        cDL();
        com.baidu.tieba.tbadkCore.v.x(arrayList, 1);
        aw(arrayList);
        ax(arrayList);
        ay(arrayList);
        Iterator<com.baidu.adp.widget.ListView.n> it = arrayList.iterator();
        while (it.hasNext()) {
            com.baidu.adp.widget.ListView.n next = it.next();
            if ((next instanceof by) && ((by) next).eHK.boh()) {
                it.remove();
            }
        }
        this.iGb.setData(arrayList);
        this.jlz = frsViewData;
        cEo();
        cFl();
        this.dataList = arrayList;
    }

    public void b(FrsViewData frsViewData) {
        if (this.bjZ != null && this.bjZ.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.bjZ) {
                if (aVar instanceof com.baidu.tieba.frs.k) {
                    ((com.baidu.tieba.frs.k) aVar).b(frsViewData);
                }
            }
        }
    }

    private ArrayList<Integer> aw(ArrayList<com.baidu.adp.widget.ListView.n> arrayList) {
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
                if (this.jly != null && !this.jly.containsValue(nVar)) {
                    this.jly.put(Integer.valueOf(i2), (bz) nVar);
                }
            }
            i = i2 + 1;
        }
    }

    private void ax(ArrayList<com.baidu.adp.widget.ListView.n> arrayList) {
        int i;
        if (this.bjZ != null && this.bjZ.size() != 0) {
            int i2 = 0;
            if (arrayList == null || arrayList.size() <= 0) {
                i = 0;
            } else {
                Iterator<com.baidu.adp.widget.ListView.n> it = arrayList.iterator();
                while (true) {
                    i = i2;
                    if (!it.hasNext() || it.next().getType().getId() != bz.eNZ.getId()) {
                        break;
                    }
                    i2 = i + 1;
                }
            }
            for (com.baidu.adp.widget.ListView.a aVar : this.bjZ) {
                if (aVar instanceof com.baidu.tieba.frs.k) {
                    ((com.baidu.tieba.frs.k) aVar).yk(i);
                }
            }
        }
    }

    private void ay(ArrayList<com.baidu.adp.widget.ListView.n> arrayList) {
        int count = com.baidu.tbadk.core.util.x.getCount(arrayList);
        for (int i = 0; i < count; i++) {
            com.baidu.adp.widget.ListView.n nVar = (com.baidu.adp.widget.ListView.n) com.baidu.tbadk.core.util.x.getItem(arrayList, i - 1);
            com.baidu.adp.widget.ListView.n nVar2 = (com.baidu.adp.widget.ListView.n) com.baidu.tbadk.core.util.x.getItem(arrayList, i);
            if (nVar2 instanceof by) {
                bz bzVar = ((by) nVar2).eHK;
                if (i == 0) {
                    bzVar.isFirstFloor = true;
                } else {
                    bzVar.isFirstFloor = false;
                }
                String bkW = bzVar.bkW();
                if (nVar instanceof com.baidu.tieba.frs.u) {
                    bzVar.needTopMargin = false;
                } else if (nVar != null && !c(nVar)) {
                    bzVar.needTopMargin = false;
                } else if ((nVar instanceof by) && c(nVar) && !TextUtils.isEmpty(((by) nVar).eHK.bkW())) {
                    bzVar.needTopMargin = true;
                } else if (c(nVar2) && !TextUtils.isEmpty(bkW)) {
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
        return type == bz.eOa || type == bz.eOx || type == bz.eOy || type == bz.eOH || type == bz.eOQ;
    }

    private void cDL() {
        if (!com.baidu.tbadk.core.util.x.isEmpty(this.bjZ) && this.jcX != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.bjZ) {
                if (aVar instanceof com.baidu.tieba.frs.k) {
                    ((com.baidu.tieba.frs.k) aVar).a(this.jcX.getTbPageTag());
                }
            }
        }
    }

    private void cEo() {
        com.baidu.tieba.frs.b.b statisticMetaData;
        if (this.jlz != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.bjZ) {
                if ((aVar instanceof com.baidu.tieba.frs.b.d) && (statisticMetaData = ((com.baidu.tieba.frs.b.d) aVar).getStatisticMetaData()) != null) {
                    if (this.jlz.needLog == 1) {
                        statisticMetaData.jBG = true;
                    } else {
                        statisticMetaData.jBG = false;
                    }
                    if (this.jlz.getForum() != null) {
                        statisticMetaData.jBI = this.jlz.getForum().getId();
                    }
                    if (this.jcX != null && this.jcX.cBd() != null) {
                        int cIs = this.jcX.cBd().cIs();
                        if (cIs == -1) {
                            cIs = this.jcX.cBd().cIt();
                        }
                        statisticMetaData.jBH = cIs;
                    }
                }
            }
        }
    }

    private void cFl() {
        if (this.jlz != null && this.jlz.getForum() != null && !StringUtils.isNull(this.jlz.getForum().getId()) && this.jlB != null) {
            this.jlB.setForumId(this.jlz.getForum().getId());
        }
    }

    private void dr(List<com.baidu.adp.widget.ListView.a> list) {
        if (list != null) {
            for (com.baidu.adp.widget.ListView.a aVar : list) {
                if (aVar instanceof com.baidu.tieba.frs.k) {
                    ((com.baidu.tieba.frs.k) aVar).a(this.jad);
                }
            }
        }
    }

    private void Ea(String str) {
        if (this.bjZ != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.bjZ) {
                if (aVar instanceof com.baidu.tieba.a.f) {
                    ((com.baidu.tieba.a.f) aVar).Ea(str);
                }
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.adapter.al
    public void a(com.baidu.tieba.frs.f fVar) {
        if (this.bjZ != null && this.bjZ.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.bjZ) {
                if (aVar instanceof com.baidu.tieba.frs.k) {
                    ((com.baidu.tieba.frs.k) aVar).a(fVar);
                }
            }
        }
    }
}
