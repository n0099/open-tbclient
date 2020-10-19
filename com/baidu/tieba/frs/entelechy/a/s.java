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
/* loaded from: classes22.dex */
public class s implements al {
    private ArrayList<com.baidu.adp.widget.ListView.q> dataList;
    private com.baidu.adp.widget.ListView.v hUo;
    private FrsFragment irr;
    private final HashMap<Integer, bw> izD;
    private FrsViewData izE;
    private ah izG;
    private com.baidu.adp.widget.ListView.a izH;
    private aa izI;
    private n izJ;
    private x izK;
    private u izL;
    private m izM;
    private o izN;
    private y izO;
    private ac izP;
    private w izQ;
    private t izR;
    private ab izS;
    private v izT;
    private List<com.baidu.adp.widget.ListView.a> bhH = new LinkedList();
    private boolean izF = false;
    private final com.baidu.tieba.frs.i iox = new com.baidu.tieba.frs.i();

    public s(FrsFragment frsFragment, com.baidu.adp.widget.ListView.v vVar, boolean z) {
        this.hUo = vVar;
        a(frsFragment, vVar);
        this.izD = new HashMap<>();
        pA(z);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r5v35, resolved type: com.baidu.tieba.frs.FrsFragment */
    /* JADX WARN: Multi-variable type inference failed */
    public void a(FrsFragment frsFragment, com.baidu.adp.widget.ListView.v vVar) {
        this.irr = frsFragment;
        this.izH = com.baidu.tieba.frs.e.crN().a(frsFragment.getPageContext(), com.baidu.tieba.tbadkCore.w.mDa, this.irr.getUniqueId(), false);
        this.izI = new aa(frsFragment.getTbPageContext(), bw.epq, this.irr.getUniqueId());
        this.izI.b(vVar);
        this.izJ = new n(frsFragment.getTbPageContext(), bw.epr, this.irr.getUniqueId());
        this.izJ.b(vVar);
        this.izK = new x(frsFragment.getTbPageContext(), bw.ept, this.irr.getUniqueId());
        this.izK.b(vVar);
        this.izL = new u(frsFragment.getTbPageContext(), bw.epu, this.irr.getUniqueId());
        this.izL.b(vVar);
        this.izM = new m(frsFragment.getTbPageContext(), bw.epw, this.irr.getUniqueId());
        this.izM.b(vVar);
        this.izN = new o(frsFragment.getTbPageContext(), bw.epx, this.irr.getUniqueId());
        this.izN.b(vVar);
        this.izP = new ac(frsFragment.getTbPageContext(), bw.epC, this.irr.getUniqueId());
        this.izP.b(vVar);
        this.izO = new y(frsFragment.getTbPageContext(), bw.epU, this.irr.getUniqueId());
        this.izO.b(vVar);
        this.izQ = new w(frsFragment.getTbPageContext(), bw.epD, this.irr.getUniqueId());
        this.izQ.b(vVar);
        this.izR = new t(frsFragment.getTbPageContext(), bw.epE, this.irr.getUniqueId());
        this.izR.b(vVar);
        this.izS = new ab(frsFragment.getPageContext(), bw.epH, this.irr.getUniqueId());
        this.izS.b(vVar);
        r rVar = new r(frsFragment.getPageContext(), bw.epF, this.irr.getUniqueId());
        rVar.b(vVar);
        z zVar = new z(frsFragment.getPageContext(), bw.epL, this.irr.getUniqueId());
        zVar.b(vVar);
        a aVar = new a(frsFragment.getPageContext(), bw.epz, frsFragment.getUniqueId());
        aVar.b(vVar);
        aVar.ux(1);
        e eVar = new e(frsFragment.getPageContext(), bw.epv, frsFragment.getUniqueId());
        eVar.b(vVar);
        b bVar = new b(frsFragment.getPageContext(), bw.epN, this.irr.getUniqueId());
        bVar.b(vVar);
        bVar.setInFrsAllThread(true);
        h hVar = new h(frsFragment.getPageContext(), bw.epM, this.irr.getUniqueId());
        hVar.b(vVar);
        hVar.setInFrsAllThread(true);
        i iVar = new i(frsFragment.getPageContext(), bw.epO, this.irr.getUniqueId());
        iVar.b(vVar);
        iVar.setInFrsAllThread(true);
        ab abVar = new ab(frsFragment.getPageContext(), bw.epP, this.irr.getUniqueId());
        abVar.b(vVar);
        q qVar = new q(frsFragment.getPageContext(), bw.epY, this.irr.getUniqueId());
        qVar.b(vVar);
        p pVar = new p(frsFragment.getPageContext(), bw.epQ, this.irr.getUniqueId());
        pVar.b(vVar);
        this.izG = new ah(frsFragment.getPageContext(), com.baidu.tieba.tbadkCore.p.mCS, this.irr.getUniqueId());
        this.izT = new v(frsFragment.getPageContext(), bw.epG, this.irr.getUniqueId());
        this.izT.b(vVar);
        com.baidu.adp.widget.ListView.a<? extends bv, ? extends af.a> a2 = com.baidu.tieba.frs.e.crN().a(frsFragment.getPageContext(), this.irr.getUniqueId(), true);
        com.baidu.adp.widget.ListView.a<? extends bw, ? extends af.a> b = com.baidu.tieba.frs.e.crN().b(frsFragment.getPageContext(), bw.ert, this.irr.getUniqueId());
        com.baidu.tieba.frs.r rVar2 = new com.baidu.tieba.frs.r(frsFragment.getPageContext(), com.baidu.tieba.frs.s.iss);
        l lVar = new l(frsFragment.getPageContext(), com.baidu.tieba.frs.w.isL);
        ag agVar = new ag(frsFragment.getPageContext(), com.baidu.tieba.frs.y.isU, this.irr.getUniqueId());
        this.bhH.add(this.izH);
        this.bhH.add(this.izI);
        this.bhH.add(this.izJ);
        this.bhH.add(this.izK);
        this.bhH.add(this.izL);
        this.bhH.add(this.izM);
        this.bhH.add(this.izN);
        this.bhH.add(this.izO);
        this.bhH.add(this.izP);
        this.bhH.add(this.izQ);
        this.bhH.add(this.izR);
        this.bhH.add(this.izG);
        this.bhH.add(rVar);
        this.bhH.add(zVar);
        this.bhH.add(aVar);
        this.bhH.add(eVar);
        this.bhH.add(bVar);
        this.bhH.add(hVar);
        this.bhH.add(iVar);
        this.bhH.add(this.izT);
        this.bhH.add(this.izS);
        this.bhH.add(a2);
        this.bhH.add(b);
        this.bhH.add(rVar2);
        this.bhH.add(lVar);
        this.bhH.add(qVar);
        this.bhH.add(pVar);
        this.bhH.add(agVar);
        this.bhH.add(abVar);
        com.baidu.tieba.InjectPlugin.b.b bVar2 = new com.baidu.tieba.InjectPlugin.b.b(this.irr, 1);
        bVar2.setExtraData(this.bhH);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_FEED_AD_PLUGIN_OPERATE, bVar2));
        cO(this.bhH);
        vVar.addAdapters(this.bhH);
        AbsDelegateAdapterList absDelegateAdapterList = new AbsDelegateAdapterList();
        CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_ADD_ADAPTER, absDelegateAdapterList);
        CustomMessage customMessage = new CustomMessage(CmdConfigCustom.CMD_FRS_ADD_ADAPTER);
        customMessage.setTag(this.irr.getUniqueId());
        customResponsedMessage.setOrginalMessage(customMessage);
        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
        Es("page_frs");
        if (!absDelegateAdapterList.isEmpty()) {
            Iterator it = absDelegateAdapterList.iterator();
            while (it.hasNext()) {
                com.baidu.adp.widget.ListView.a aVar2 = (com.baidu.adp.widget.ListView.a) it.next();
                if (aVar2 instanceof com.baidu.tieba.frs.k) {
                    ((com.baidu.tieba.frs.k) aVar2).a(this.irr.getPageContext(), this.irr.getUniqueId());
                }
            }
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(absDelegateAdapterList);
            if (this.bhH != null) {
                this.bhH.addAll(arrayList);
            }
            if (this.hUo != null) {
                this.hUo.addAdapters(arrayList);
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.a.al
    public void onDestory() {
        for (com.baidu.adp.widget.ListView.a aVar : this.bhH) {
            if (aVar instanceof com.baidu.tieba.frs.k) {
                ((com.baidu.tieba.frs.k) aVar).release();
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.a.al
    public HashMap<Integer, bw> cws() {
        return this.izD;
    }

    @Override // com.baidu.tieba.frs.entelechy.a.al
    public void notifyDataSetChanged() {
        if (this.hUo.getListAdapter() != null) {
            this.hUo.getListAdapter().notifyDataSetChanged();
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.a.al
    public int cwt() {
        if (this.izH != null) {
            return R.id.frs_bawu_center;
        }
        return 0;
    }

    @Override // com.baidu.tieba.frs.entelechy.a.al
    public boolean r(BdUniqueId bdUniqueId) {
        if (bdUniqueId == null) {
            return false;
        }
        for (com.baidu.adp.widget.ListView.a aVar : this.bhH) {
            if (aVar != null && aVar.getType() == bdUniqueId) {
                return true;
            }
        }
        return false;
    }

    @Override // com.baidu.tieba.frs.entelechy.a.al
    public void a(com.baidu.adp.widget.ListView.ab abVar) {
        if (this.bhH != null && this.bhH.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.bhH) {
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
        if (this.bhH != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.bhH) {
                if (aVar instanceof com.baidu.tieba.card.y) {
                    ((com.baidu.tieba.card.y) aVar).setForumName(str);
                }
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v1, resolved type: com.baidu.tieba.frs.FrsFragment */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.baidu.tieba.frs.entelechy.a.al
    public void cwu() {
        if (this.bhH != null && this.bhH.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.bhH) {
                if (aVar instanceof com.baidu.tieba.frs.k) {
                    ((com.baidu.tieba.frs.k) aVar).a(this.irr.getPageContext(), this.irr.getUniqueId());
                }
            }
            cO(this.bhH);
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.a.al
    public List<com.baidu.adp.widget.ListView.q> getDatas() {
        if (this.hUo != null) {
            return this.hUo.getData();
        }
        return null;
    }

    @Override // com.baidu.tieba.frs.entelechy.a.al
    public int cwv() {
        if (this.izH != null) {
            return R.id.frs_fortune_bag_item;
        }
        return 0;
    }

    @Override // com.baidu.tieba.frs.entelechy.a.al
    public int cww() {
        if (this.izH != null) {
            return R.id.frs_my_service_item;
        }
        return 0;
    }

    public void aVY() {
        if (this.dataList != null) {
            this.hUo.setData(this.dataList);
        }
        notifyDataSetChanged();
    }

    @Override // com.baidu.tieba.frs.entelechy.a.al
    public void setFromCDN(boolean z) {
        if (this.bhH != null && this.bhH.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.bhH) {
                if (aVar instanceof com.baidu.tieba.frs.k) {
                    ((com.baidu.tieba.frs.k) aVar).setFromCDN(z);
                }
            }
            if (this.izI != null) {
                this.izI.setFromCDN(z);
            }
            if (this.izJ != null) {
                this.izJ.setFromCDN(z);
            }
            if (this.izK != null) {
                this.izK.setFromCDN(z);
            }
            if (this.izL != null) {
                this.izL.setFromCDN(z);
            }
            if (this.izM != null) {
                this.izM.setFromCDN(z);
            }
            if (this.izN != null) {
                this.izN.setFromCDN(z);
            }
            if (this.izS != null) {
                this.izS.setFromCDN(z);
            }
            if (this.izT != null) {
                this.izT.setFromCDN(z);
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.a.al
    public void cwx() {
        List<com.baidu.adp.widget.ListView.q> data;
        if (this.hUo != null && this.hUo.getData() != null && this.hUo.getData().size() != 0 && (data = this.hUo.getData()) != null && data.size() != 0) {
            for (com.baidu.adp.widget.ListView.q qVar : data) {
                if (qVar instanceof bw) {
                    if (((bw) qVar).bic() != 0) {
                        ((bw) qVar).bjf();
                    }
                } else if ((qVar instanceof bv) && ((bv) qVar).eji.bic() != 0) {
                    ((bv) qVar).eji.bjf();
                }
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.a.al
    public void pA(boolean z) {
        if (this.izF != z) {
            this.izF = z;
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.a.al
    public void b(ArrayList<com.baidu.adp.widget.ListView.q> arrayList, FrsViewData frsViewData) {
        b(frsViewData);
        cvf();
        com.baidu.tieba.tbadkCore.u.w(arrayList, 1);
        ax(arrayList);
        ay(arrayList);
        az(arrayList);
        Iterator<com.baidu.adp.widget.ListView.q> it = arrayList.iterator();
        while (it.hasNext()) {
            com.baidu.adp.widget.ListView.q next = it.next();
            if ((next instanceof bv) && ((bv) next).eji.isTop()) {
                it.remove();
            }
        }
        this.hUo.setData(arrayList);
        this.izE = frsViewData;
        cvI();
        cwy();
        this.dataList = arrayList;
    }

    public void b(FrsViewData frsViewData) {
        if (this.bhH != null && this.bhH.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.bhH) {
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
                if (this.izD != null && !this.izD.containsValue(qVar)) {
                    this.izD.put(Integer.valueOf(i2), (bw) qVar);
                }
            }
            i = i2 + 1;
        }
    }

    private void ay(ArrayList<com.baidu.adp.widget.ListView.q> arrayList) {
        int i;
        if (this.bhH != null && this.bhH.size() != 0) {
            int i2 = 0;
            if (arrayList == null || arrayList.size() <= 0) {
                i = 0;
            } else {
                Iterator<com.baidu.adp.widget.ListView.q> it = arrayList.iterator();
                while (true) {
                    i = i2;
                    if (!it.hasNext() || it.next().getType().getId() != bw.epk.getId()) {
                        break;
                    }
                    i2 = i + 1;
                }
            }
            for (com.baidu.adp.widget.ListView.a aVar : this.bhH) {
                if (aVar instanceof com.baidu.tieba.frs.k) {
                    ((com.baidu.tieba.frs.k) aVar).xU(i);
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
                bw bwVar = ((bv) qVar2).eji;
                if (i == 0) {
                    bwVar.isFirstFloor = true;
                } else {
                    bwVar.isFirstFloor = false;
                }
                String bfH = bwVar.bfH();
                if (qVar instanceof com.baidu.tieba.frs.w) {
                    bwVar.needTopMargin = false;
                } else if (qVar != null && !c(qVar)) {
                    bwVar.needTopMargin = false;
                } else if ((qVar instanceof bv) && c(qVar) && !TextUtils.isEmpty(((bv) qVar).eji.bfH())) {
                    bwVar.needTopMargin = true;
                } else if (c(qVar2) && !TextUtils.isEmpty(bfH)) {
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
        return type == bw.epl || type == bw.epG || type == bw.epH || type == bw.epP || type == bw.epY;
    }

    private void cvf() {
        if (!com.baidu.tbadk.core.util.y.isEmpty(this.bhH) && this.irr != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.bhH) {
                if (aVar instanceof com.baidu.tieba.frs.k) {
                    ((com.baidu.tieba.frs.k) aVar).a(this.irr.getTbPageTag());
                }
            }
        }
    }

    private void cvI() {
        com.baidu.tieba.frs.d.b statisticMetaData;
        if (this.izE != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.bhH) {
                if ((aVar instanceof com.baidu.tieba.frs.d.d) && (statisticMetaData = ((com.baidu.tieba.frs.d.d) aVar).getStatisticMetaData()) != null) {
                    if (this.izE.needLog == 1) {
                        statisticMetaData.iNi = true;
                    } else {
                        statisticMetaData.iNi = false;
                    }
                    if (this.izE.getForum() != null) {
                        statisticMetaData.iNk = this.izE.getForum().getId();
                    }
                    if (this.irr != null && this.irr.csy() != null) {
                        int cyJ = this.irr.csy().cyJ();
                        if (cyJ == -1) {
                            cyJ = this.irr.csy().cyK();
                        }
                        statisticMetaData.iNj = cyJ;
                    }
                }
            }
        }
    }

    private void cwy() {
        if (this.izE != null && this.izE.getForum() != null && !StringUtils.isNull(this.izE.getForum().getId()) && this.izG != null) {
            this.izG.setForumId(this.izE.getForum().getId());
        }
    }

    private void cO(List<com.baidu.adp.widget.ListView.a> list) {
        if (list != null) {
            for (com.baidu.adp.widget.ListView.a aVar : list) {
                if (aVar instanceof com.baidu.tieba.frs.k) {
                    ((com.baidu.tieba.frs.k) aVar).a(this.iox);
                }
            }
        }
    }

    private void Es(String str) {
        if (this.bhH != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.bhH) {
                if (aVar instanceof com.baidu.tieba.a.f) {
                    ((com.baidu.tieba.a.f) aVar).Es(str);
                }
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.a.al
    public void a(com.baidu.tieba.frs.f fVar) {
        if (this.bhH != null && this.bhH.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.bhH) {
                if (aVar instanceof com.baidu.tieba.frs.k) {
                    ((com.baidu.tieba.frs.k) aVar).a(fVar);
                }
            }
        }
    }
}
