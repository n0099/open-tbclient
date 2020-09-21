package com.baidu.tieba.frs.entelechy.a;

import android.text.TextUtils;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.af;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.data.bv;
import com.baidu.tbadk.core.data.bw;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.AbsDelegateAdapterList;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.tbadkCore.FrsViewData;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes21.dex */
public class s implements al {
    private ArrayList<com.baidu.adp.widget.ListView.q> dataList;
    private com.baidu.adp.widget.ListView.v hFt;
    private FrsFragment icq;
    private final HashMap<Integer, bw> ikG;
    private FrsViewData ikH;
    private ah ikJ;
    private com.baidu.adp.widget.ListView.a ikK;
    private aa ikL;
    private n ikM;
    private x ikN;
    private u ikO;
    private m ikP;
    private o ikQ;
    private y ikR;
    private ac ikS;
    private w ikT;
    private t ikU;
    private ab ikV;
    private v ikW;
    private List<com.baidu.adp.widget.ListView.a> bdV = new LinkedList();
    private boolean ikI = false;
    private final com.baidu.tieba.frs.i hZw = new com.baidu.tieba.frs.i();

    public s(FrsFragment frsFragment, com.baidu.adp.widget.ListView.v vVar, boolean z) {
        this.hFt = vVar;
        a(frsFragment, vVar);
        this.ikG = new HashMap<>();
        oV(z);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r5v35, resolved type: com.baidu.tieba.frs.FrsFragment */
    /* JADX WARN: Multi-variable type inference failed */
    public void a(FrsFragment frsFragment, com.baidu.adp.widget.ListView.v vVar) {
        this.icq = frsFragment;
        this.ikK = com.baidu.tieba.frs.e.cop().a(frsFragment.getPageContext(), com.baidu.tieba.tbadkCore.w.mnw, this.icq.getUniqueId(), false);
        this.ikL = new aa(frsFragment.getTbPageContext(), bw.edl, this.icq.getUniqueId());
        this.ikL.b(vVar);
        this.ikM = new n(frsFragment.getTbPageContext(), bw.edm, this.icq.getUniqueId());
        this.ikM.b(vVar);
        this.ikN = new x(frsFragment.getTbPageContext(), bw.edo, this.icq.getUniqueId());
        this.ikN.b(vVar);
        this.ikO = new u(frsFragment.getTbPageContext(), bw.edp, this.icq.getUniqueId());
        this.ikO.b(vVar);
        this.ikP = new m(frsFragment.getTbPageContext(), bw.edr, this.icq.getUniqueId());
        this.ikP.b(vVar);
        this.ikQ = new o(frsFragment.getTbPageContext(), bw.eds, this.icq.getUniqueId());
        this.ikQ.b(vVar);
        this.ikS = new ac(frsFragment.getTbPageContext(), bw.edx, this.icq.getUniqueId());
        this.ikS.b(vVar);
        this.ikR = new y(frsFragment.getTbPageContext(), bw.edP, this.icq.getUniqueId());
        this.ikR.b(vVar);
        this.ikT = new w(frsFragment.getTbPageContext(), bw.edy, this.icq.getUniqueId());
        this.ikT.b(vVar);
        this.ikU = new t(frsFragment.getTbPageContext(), bw.edz, this.icq.getUniqueId());
        this.ikU.b(vVar);
        this.ikV = new ab(frsFragment.getPageContext(), bw.edC, this.icq.getUniqueId());
        this.ikV.b(vVar);
        r rVar = new r(frsFragment.getPageContext(), bw.edA, this.icq.getUniqueId());
        rVar.b(vVar);
        z zVar = new z(frsFragment.getPageContext(), bw.edG, this.icq.getUniqueId());
        zVar.b(vVar);
        a aVar = new a(frsFragment.getPageContext(), bw.edu, frsFragment.getUniqueId());
        aVar.b(vVar);
        aVar.tS(1);
        e eVar = new e(frsFragment.getPageContext(), bw.edq, frsFragment.getUniqueId());
        eVar.b(vVar);
        b bVar = new b(frsFragment.getPageContext(), bw.edI, this.icq.getUniqueId());
        bVar.b(vVar);
        bVar.setInFrsAllThread(true);
        h hVar = new h(frsFragment.getPageContext(), bw.edH, this.icq.getUniqueId());
        hVar.b(vVar);
        hVar.setInFrsAllThread(true);
        i iVar = new i(frsFragment.getPageContext(), bw.edJ, this.icq.getUniqueId());
        iVar.b(vVar);
        iVar.setInFrsAllThread(true);
        ab abVar = new ab(frsFragment.getPageContext(), bw.edK, this.icq.getUniqueId());
        abVar.b(vVar);
        q qVar = new q(frsFragment.getPageContext(), bw.edT, this.icq.getUniqueId());
        qVar.b(vVar);
        p pVar = new p(frsFragment.getPageContext(), bw.edL, this.icq.getUniqueId());
        pVar.b(vVar);
        this.ikJ = new ah(frsFragment.getPageContext(), com.baidu.tieba.tbadkCore.p.mno, this.icq.getUniqueId());
        this.ikW = new v(frsFragment.getPageContext(), bw.edB, this.icq.getUniqueId());
        this.ikW.b(vVar);
        com.baidu.adp.widget.ListView.a<? extends bv, ? extends af.a> a = com.baidu.tieba.frs.e.cop().a(frsFragment.getPageContext(), this.icq.getUniqueId(), true);
        com.baidu.adp.widget.ListView.a<? extends bw, ? extends af.a> b = com.baidu.tieba.frs.e.cop().b(frsFragment.getPageContext(), bw.efn, this.icq.getUniqueId());
        com.baidu.tieba.frs.r rVar2 = new com.baidu.tieba.frs.r(frsFragment.getPageContext(), com.baidu.tieba.frs.s.idu);
        l lVar = new l(frsFragment.getPageContext(), com.baidu.tieba.frs.w.idO);
        ag agVar = new ag(frsFragment.getPageContext(), com.baidu.tieba.frs.y.idX, this.icq.getUniqueId());
        this.bdV.add(this.ikK);
        this.bdV.add(this.ikL);
        this.bdV.add(this.ikM);
        this.bdV.add(this.ikN);
        this.bdV.add(this.ikO);
        this.bdV.add(this.ikP);
        this.bdV.add(this.ikQ);
        this.bdV.add(this.ikR);
        this.bdV.add(this.ikS);
        this.bdV.add(this.ikT);
        this.bdV.add(this.ikU);
        this.bdV.add(this.ikJ);
        this.bdV.add(rVar);
        this.bdV.add(zVar);
        this.bdV.add(aVar);
        this.bdV.add(eVar);
        this.bdV.add(bVar);
        this.bdV.add(hVar);
        this.bdV.add(iVar);
        this.bdV.add(this.ikW);
        this.bdV.add(this.ikV);
        this.bdV.add(a);
        this.bdV.add(b);
        this.bdV.add(rVar2);
        this.bdV.add(lVar);
        this.bdV.add(qVar);
        this.bdV.add(pVar);
        this.bdV.add(agVar);
        this.bdV.add(abVar);
        com.baidu.tieba.InjectPlugin.b.b bVar2 = new com.baidu.tieba.InjectPlugin.b.b(this.icq, 1);
        bVar2.setExtraData(this.bdV);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_FEED_AD_PLUGIN_OPERATE, bVar2));
        cL(this.bdV);
        vVar.addAdapters(this.bdV);
        AbsDelegateAdapterList absDelegateAdapterList = new AbsDelegateAdapterList();
        CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_ADD_ADAPTER, absDelegateAdapterList);
        CustomMessage customMessage = new CustomMessage(CmdConfigCustom.CMD_FRS_ADD_ADAPTER);
        customMessage.setTag(this.icq.getUniqueId());
        customResponsedMessage.setOrginalMessage(customMessage);
        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
        DH("page_frs");
        if (!absDelegateAdapterList.isEmpty()) {
            Iterator it = absDelegateAdapterList.iterator();
            while (it.hasNext()) {
                com.baidu.adp.widget.ListView.a aVar2 = (com.baidu.adp.widget.ListView.a) it.next();
                if (aVar2 instanceof com.baidu.tieba.frs.k) {
                    ((com.baidu.tieba.frs.k) aVar2).a(this.icq.getPageContext(), this.icq.getUniqueId());
                }
            }
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(absDelegateAdapterList);
            if (this.bdV != null) {
                this.bdV.addAll(arrayList);
            }
            if (this.hFt != null) {
                this.hFt.addAdapters(arrayList);
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.a.al
    public void onDestory() {
        for (com.baidu.adp.widget.ListView.a aVar : this.bdV) {
            if (aVar instanceof com.baidu.tieba.frs.k) {
                ((com.baidu.tieba.frs.k) aVar).release();
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.a.al
    public HashMap<Integer, bw> csV() {
        return this.ikG;
    }

    @Override // com.baidu.tieba.frs.entelechy.a.al
    public void notifyDataSetChanged() {
        if (this.hFt.getListAdapter() != null) {
            this.hFt.getListAdapter().notifyDataSetChanged();
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.a.al
    public int csW() {
        if (this.ikK != null) {
            return R.id.frs_bawu_center;
        }
        return 0;
    }

    @Override // com.baidu.tieba.frs.entelechy.a.al
    public boolean r(BdUniqueId bdUniqueId) {
        if (bdUniqueId == null) {
            return false;
        }
        for (com.baidu.adp.widget.ListView.a aVar : this.bdV) {
            if (aVar != null && aVar.getType() == bdUniqueId) {
                return true;
            }
        }
        return false;
    }

    @Override // com.baidu.tieba.frs.entelechy.a.al
    public void a(com.baidu.adp.widget.ListView.ab abVar) {
        if (this.bdV != null && this.bdV.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.bdV) {
                if (aVar instanceof com.baidu.tieba.frs.k) {
                    ((com.baidu.tieba.frs.k) aVar).a(abVar);
                } else if ((aVar instanceof v) || (aVar instanceof ab)) {
                    aVar.a(abVar);
                }
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.a.al
    public void setForumName(String str) {
        if (this.bdV != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.bdV) {
                if (aVar instanceof com.baidu.tieba.card.y) {
                    ((com.baidu.tieba.card.y) aVar).setForumName(str);
                }
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v1, resolved type: com.baidu.tieba.frs.FrsFragment */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.baidu.tieba.frs.entelechy.a.al
    public void csX() {
        if (this.bdV != null && this.bdV.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.bdV) {
                if (aVar instanceof com.baidu.tieba.frs.k) {
                    ((com.baidu.tieba.frs.k) aVar).a(this.icq.getPageContext(), this.icq.getUniqueId());
                }
            }
            cL(this.bdV);
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.a.al
    public List<com.baidu.adp.widget.ListView.q> getDatas() {
        if (this.hFt != null) {
            return this.hFt.getData();
        }
        return null;
    }

    @Override // com.baidu.tieba.frs.entelechy.a.al
    public int csY() {
        if (this.ikK != null) {
            return R.id.frs_fortune_bag_item;
        }
        return 0;
    }

    @Override // com.baidu.tieba.frs.entelechy.a.al
    public int csZ() {
        if (this.ikK != null) {
            return R.id.frs_my_service_item;
        }
        return 0;
    }

    public void aTp() {
        if (this.dataList != null) {
            this.hFt.setData(this.dataList);
        }
        notifyDataSetChanged();
    }

    @Override // com.baidu.tieba.frs.entelechy.a.al
    public void setFromCDN(boolean z) {
        if (this.bdV != null && this.bdV.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.bdV) {
                if (aVar instanceof com.baidu.tieba.frs.k) {
                    ((com.baidu.tieba.frs.k) aVar).setFromCDN(z);
                }
            }
            if (this.ikL != null) {
                this.ikL.setFromCDN(z);
            }
            if (this.ikM != null) {
                this.ikM.setFromCDN(z);
            }
            if (this.ikN != null) {
                this.ikN.setFromCDN(z);
            }
            if (this.ikO != null) {
                this.ikO.setFromCDN(z);
            }
            if (this.ikP != null) {
                this.ikP.setFromCDN(z);
            }
            if (this.ikQ != null) {
                this.ikQ.setFromCDN(z);
            }
            if (this.ikV != null) {
                this.ikV.setFromCDN(z);
            }
            if (this.ikW != null) {
                this.ikW.setFromCDN(z);
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.a.al
    public void cta() {
        List<com.baidu.adp.widget.ListView.q> data;
        if (this.hFt != null && this.hFt.getData() != null && this.hFt.getData().size() != 0 && (data = this.hFt.getData()) != null && data.size() != 0) {
            for (com.baidu.adp.widget.ListView.q qVar : data) {
                if (qVar instanceof bw) {
                    if (((bw) qVar).bft() != 0) {
                        ((bw) qVar).bgw();
                    }
                } else if ((qVar instanceof bv) && ((bv) qVar).dXg.bft() != 0) {
                    ((bv) qVar).dXg.bgw();
                }
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.a.al
    public void oV(boolean z) {
        if (this.ikI != z) {
            this.ikI = z;
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.a.al
    public void b(ArrayList<com.baidu.adp.widget.ListView.q> arrayList, FrsViewData frsViewData) {
        b(frsViewData);
        crH();
        com.baidu.tieba.tbadkCore.u.u(arrayList, 1);
        ax(arrayList);
        ay(arrayList);
        az(arrayList);
        Iterator<com.baidu.adp.widget.ListView.q> it = arrayList.iterator();
        while (it.hasNext()) {
            com.baidu.adp.widget.ListView.q next = it.next();
            if ((next instanceof bv) && ((bv) next).dXg.isTop()) {
                it.remove();
            }
        }
        this.hFt.setData(arrayList);
        this.ikH = frsViewData;
        csl();
        ctb();
        this.dataList = arrayList;
    }

    public void b(FrsViewData frsViewData) {
        if (this.bdV != null && this.bdV.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.bdV) {
                if (aVar instanceof com.baidu.tieba.frs.k) {
                    ((com.baidu.tieba.frs.k) aVar).b(frsViewData);
                }
            }
        }
    }

    private ArrayList<Integer> ax(ArrayList<com.baidu.adp.widget.ListView.q> arrayList) {
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
            com.baidu.adp.widget.ListView.q qVar = arrayList.get(i2);
            if (qVar instanceof AdvertAppInfo) {
                arrayList2.add(Integer.valueOf(i2));
                if (this.ikG != null && !this.ikG.containsValue(qVar)) {
                    this.ikG.put(Integer.valueOf(i2), (bw) qVar);
                }
            }
            i = i2 + 1;
        }
    }

    private void ay(ArrayList<com.baidu.adp.widget.ListView.q> arrayList) {
        int i;
        if (this.bdV != null && this.bdV.size() != 0) {
            int i2 = 0;
            if (arrayList == null || arrayList.size() <= 0) {
                i = 0;
            } else {
                Iterator<com.baidu.adp.widget.ListView.q> it = arrayList.iterator();
                while (true) {
                    i = i2;
                    if (!it.hasNext() || it.next().getType().getId() != bw.edf.getId()) {
                        break;
                    }
                    i2 = i + 1;
                }
            }
            for (com.baidu.adp.widget.ListView.a aVar : this.bdV) {
                if (aVar instanceof com.baidu.tieba.frs.k) {
                    ((com.baidu.tieba.frs.k) aVar).xo(i);
                }
            }
        }
    }

    private void az(ArrayList<com.baidu.adp.widget.ListView.q> arrayList) {
        int count = com.baidu.tbadk.core.util.y.getCount(arrayList);
        for (int i = 0; i < count; i++) {
            com.baidu.adp.widget.ListView.q qVar = (com.baidu.adp.widget.ListView.q) com.baidu.tbadk.core.util.y.getItem(arrayList, i - 1);
            com.baidu.adp.widget.ListView.q qVar2 = (com.baidu.adp.widget.ListView.q) com.baidu.tbadk.core.util.y.getItem(arrayList, i);
            if (qVar2 instanceof bv) {
                bw bwVar = ((bv) qVar2).dXg;
                if (i == 0) {
                    bwVar.isFirstFloor = true;
                } else {
                    bwVar.isFirstFloor = false;
                }
                String bcZ = bwVar.bcZ();
                if (qVar instanceof com.baidu.tieba.frs.w) {
                    bwVar.needTopMargin = false;
                } else if (qVar != null && !c(qVar)) {
                    bwVar.needTopMargin = false;
                } else if ((qVar instanceof bv) && c(qVar) && !TextUtils.isEmpty(((bv) qVar).dXg.bcZ())) {
                    bwVar.needTopMargin = true;
                } else if (c(qVar2) && !TextUtils.isEmpty(bcZ)) {
                    bwVar.needTopMargin = true;
                } else {
                    bwVar.needTopMargin = false;
                }
            }
        }
    }

    private boolean c(com.baidu.adp.widget.ListView.q qVar) {
        if (qVar == null) {
            return false;
        }
        BdUniqueId type = qVar.getType();
        return type == bw.edg || type == bw.edB || type == bw.edC || type == bw.edK || type == bw.edT;
    }

    private void crH() {
        if (!com.baidu.tbadk.core.util.y.isEmpty(this.bdV) && this.icq != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.bdV) {
                if (aVar instanceof com.baidu.tieba.frs.k) {
                    ((com.baidu.tieba.frs.k) aVar).a(this.icq.getTbPageTag());
                }
            }
        }
    }

    private void csl() {
        com.baidu.tieba.frs.d.b statisticMetaData;
        if (this.ikH != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.bdV) {
                if ((aVar instanceof com.baidu.tieba.frs.d.d) && (statisticMetaData = ((com.baidu.tieba.frs.d.d) aVar).getStatisticMetaData()) != null) {
                    if (this.ikH.needLog == 1) {
                        statisticMetaData.iyp = true;
                    } else {
                        statisticMetaData.iyp = false;
                    }
                    if (this.ikH.getForum() != null) {
                        statisticMetaData.iyr = this.ikH.getForum().getId();
                    }
                    if (this.icq != null && this.icq.cpa() != null) {
                        int cvm = this.icq.cpa().cvm();
                        if (cvm == -1) {
                            cvm = this.icq.cpa().cvn();
                        }
                        statisticMetaData.iyq = cvm;
                    }
                }
            }
        }
    }

    private void ctb() {
        if (this.ikH != null && this.ikH.getForum() != null && !StringUtils.isNull(this.ikH.getForum().getId()) && this.ikJ != null) {
            this.ikJ.setForumId(this.ikH.getForum().getId());
        }
    }

    private void cL(List<com.baidu.adp.widget.ListView.a> list) {
        if (list != null) {
            for (com.baidu.adp.widget.ListView.a aVar : list) {
                if (aVar instanceof com.baidu.tieba.frs.k) {
                    ((com.baidu.tieba.frs.k) aVar).a(this.hZw);
                }
            }
        }
    }

    private void DH(String str) {
        if (this.bdV != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.bdV) {
                if (aVar instanceof com.baidu.tieba.a.f) {
                    ((com.baidu.tieba.a.f) aVar).DH(str);
                }
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.a.al
    public void a(com.baidu.tieba.frs.f fVar) {
        if (this.bdV != null && this.bdV.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.bdV) {
                if (aVar instanceof com.baidu.tieba.frs.k) {
                    ((com.baidu.tieba.frs.k) aVar).a(fVar);
                }
            }
        }
    }
}
