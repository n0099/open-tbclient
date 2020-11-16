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
import com.baidu.tbadk.core.data.bw;
import com.baidu.tbadk.core.data.bx;
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
    private FrsFragment iKx;
    private final HashMap<Integer, bx> iSJ;
    private FrsViewData iSK;
    private ah iSM;
    private com.baidu.adp.widget.ListView.a iSN;
    private aa iSO;
    private n iSP;
    private x iSQ;
    private u iSR;
    private m iSS;
    private o iST;
    private y iSU;
    private ac iSV;
    private w iSW;
    private t iSX;
    private ab iSY;
    private v iSZ;
    private com.baidu.adp.widget.ListView.v inB;
    private List<com.baidu.adp.widget.ListView.a> biN = new LinkedList();
    private boolean iSL = false;
    private final com.baidu.tieba.frs.i iHE = new com.baidu.tieba.frs.i();

    public s(FrsFragment frsFragment, com.baidu.adp.widget.ListView.v vVar, boolean z) {
        this.inB = vVar;
        a(frsFragment, vVar);
        this.iSJ = new HashMap<>();
        qe(z);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r5v35, resolved type: com.baidu.tieba.frs.FrsFragment */
    /* JADX WARN: Multi-variable type inference failed */
    public void a(FrsFragment frsFragment, com.baidu.adp.widget.ListView.v vVar) {
        this.iKx = frsFragment;
        this.iSN = com.baidu.tieba.frs.e.cwX().a(frsFragment.getPageContext(), com.baidu.tieba.tbadkCore.w.mWE, this.iKx.getUniqueId(), false);
        this.iSO = new aa(frsFragment.getTbPageContext(), bx.eBX, this.iKx.getUniqueId());
        this.iSO.b(vVar);
        this.iSP = new n(frsFragment.getTbPageContext(), bx.eBY, this.iKx.getUniqueId());
        this.iSP.b(vVar);
        this.iSQ = new x(frsFragment.getTbPageContext(), bx.eCa, this.iKx.getUniqueId());
        this.iSQ.b(vVar);
        this.iSR = new u(frsFragment.getTbPageContext(), bx.eCb, this.iKx.getUniqueId());
        this.iSR.b(vVar);
        this.iSS = new m(frsFragment.getTbPageContext(), bx.eCd, this.iKx.getUniqueId());
        this.iSS.b(vVar);
        this.iST = new o(frsFragment.getTbPageContext(), bx.eCe, this.iKx.getUniqueId());
        this.iST.b(vVar);
        this.iSV = new ac(frsFragment.getTbPageContext(), bx.eCj, this.iKx.getUniqueId());
        this.iSV.b(vVar);
        this.iSU = new y(frsFragment.getTbPageContext(), bx.eCC, this.iKx.getUniqueId());
        this.iSU.b(vVar);
        this.iSW = new w(frsFragment.getTbPageContext(), bx.eCk, this.iKx.getUniqueId());
        this.iSW.b(vVar);
        this.iSX = new t(frsFragment.getTbPageContext(), bx.eCl, this.iKx.getUniqueId());
        this.iSX.b(vVar);
        this.iSY = new ab(frsFragment.getPageContext(), bx.eCo, this.iKx.getUniqueId());
        this.iSY.b(vVar);
        r rVar = new r(frsFragment.getPageContext(), bx.eCm, this.iKx.getUniqueId());
        rVar.b(vVar);
        z zVar = new z(frsFragment.getPageContext(), bx.eCt, this.iKx.getUniqueId());
        zVar.b(vVar);
        a aVar = new a(frsFragment.getPageContext(), bx.eCg, frsFragment.getUniqueId());
        aVar.b(vVar);
        aVar.vB(1);
        e eVar = new e(frsFragment.getPageContext(), bx.eCc, frsFragment.getUniqueId());
        eVar.b(vVar);
        b bVar = new b(frsFragment.getPageContext(), bx.eCv, this.iKx.getUniqueId());
        bVar.b(vVar);
        bVar.setInFrsAllThread(true);
        h hVar = new h(frsFragment.getPageContext(), bx.eCu, this.iKx.getUniqueId());
        hVar.b(vVar);
        hVar.setInFrsAllThread(true);
        i iVar = new i(frsFragment.getPageContext(), bx.eCw, this.iKx.getUniqueId());
        iVar.b(vVar);
        iVar.setInFrsAllThread(true);
        ab abVar = new ab(frsFragment.getPageContext(), bx.eCx, this.iKx.getUniqueId());
        abVar.b(vVar);
        q qVar = new q(frsFragment.getPageContext(), bx.eCG, this.iKx.getUniqueId());
        qVar.b(vVar);
        p pVar = new p(frsFragment.getPageContext(), bx.eCy, this.iKx.getUniqueId());
        pVar.b(vVar);
        this.iSM = new ah(frsFragment.getPageContext(), com.baidu.tieba.tbadkCore.p.mWw, this.iKx.getUniqueId());
        this.iSZ = new v(frsFragment.getPageContext(), bx.eCn, this.iKx.getUniqueId());
        this.iSZ.b(vVar);
        com.baidu.adp.widget.ListView.a<? extends bw, ? extends af.a> a2 = com.baidu.tieba.frs.e.cwX().a(frsFragment.getPageContext(), this.iKx.getUniqueId(), true);
        com.baidu.adp.widget.ListView.a<? extends bx, ? extends af.a> b = com.baidu.tieba.frs.e.cwX().b(frsFragment.getPageContext(), bx.eEa, this.iKx.getUniqueId());
        com.baidu.tieba.frs.r rVar2 = new com.baidu.tieba.frs.r(frsFragment.getPageContext(), com.baidu.tieba.frs.s.iLy);
        l lVar = new l(frsFragment.getPageContext(), com.baidu.tieba.frs.w.iLR);
        ag agVar = new ag(frsFragment.getPageContext(), com.baidu.tieba.frs.y.iMa, this.iKx.getUniqueId());
        this.biN.add(this.iSN);
        this.biN.add(this.iSO);
        this.biN.add(this.iSP);
        this.biN.add(this.iSQ);
        this.biN.add(this.iSR);
        this.biN.add(this.iSS);
        this.biN.add(this.iST);
        this.biN.add(this.iSU);
        this.biN.add(this.iSV);
        this.biN.add(this.iSW);
        this.biN.add(this.iSX);
        this.biN.add(this.iSM);
        this.biN.add(rVar);
        this.biN.add(zVar);
        this.biN.add(aVar);
        this.biN.add(eVar);
        this.biN.add(bVar);
        this.biN.add(hVar);
        this.biN.add(iVar);
        this.biN.add(this.iSZ);
        this.biN.add(this.iSY);
        this.biN.add(a2);
        this.biN.add(b);
        this.biN.add(rVar2);
        this.biN.add(lVar);
        this.biN.add(qVar);
        this.biN.add(pVar);
        this.biN.add(agVar);
        this.biN.add(abVar);
        com.baidu.tieba.InjectPlugin.b.b bVar2 = new com.baidu.tieba.InjectPlugin.b.b(this.iKx, 1);
        bVar2.setExtraData(this.biN);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_FEED_AD_PLUGIN_OPERATE, bVar2));
        df(this.biN);
        vVar.addAdapters(this.biN);
        AbsDelegateAdapterList absDelegateAdapterList = new AbsDelegateAdapterList();
        CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_ADD_ADAPTER, absDelegateAdapterList);
        CustomMessage customMessage = new CustomMessage(CmdConfigCustom.CMD_FRS_ADD_ADAPTER);
        customMessage.setTag(this.iKx.getUniqueId());
        customResponsedMessage.setOrginalMessage(customMessage);
        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
        EA("page_frs");
        if (!absDelegateAdapterList.isEmpty()) {
            Iterator it = absDelegateAdapterList.iterator();
            while (it.hasNext()) {
                com.baidu.adp.widget.ListView.a aVar2 = (com.baidu.adp.widget.ListView.a) it.next();
                if (aVar2 instanceof com.baidu.tieba.frs.k) {
                    ((com.baidu.tieba.frs.k) aVar2).a(this.iKx.getPageContext(), this.iKx.getUniqueId());
                }
            }
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(absDelegateAdapterList);
            if (this.biN != null) {
                this.biN.addAll(arrayList);
            }
            if (this.inB != null) {
                this.inB.addAdapters(arrayList);
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.a.al
    public void onDestory() {
        for (com.baidu.adp.widget.ListView.a aVar : this.biN) {
            if (aVar instanceof com.baidu.tieba.frs.k) {
                ((com.baidu.tieba.frs.k) aVar).release();
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.a.al
    public HashMap<Integer, bx> cBD() {
        return this.iSJ;
    }

    @Override // com.baidu.tieba.frs.entelechy.a.al
    public void notifyDataSetChanged() {
        if (this.inB.getListAdapter() != null) {
            this.inB.getListAdapter().notifyDataSetChanged();
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.a.al
    public int cBE() {
        if (this.iSN != null) {
            return R.id.frs_bawu_center;
        }
        return 0;
    }

    @Override // com.baidu.tieba.frs.entelechy.a.al
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

    @Override // com.baidu.tieba.frs.entelechy.a.al
    public void a(com.baidu.adp.widget.ListView.ab abVar) {
        if (this.biN != null && this.biN.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.biN) {
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
        if (this.biN != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.biN) {
                if (aVar instanceof com.baidu.tieba.card.z) {
                    ((com.baidu.tieba.card.z) aVar).setForumName(str);
                }
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v1, resolved type: com.baidu.tieba.frs.FrsFragment */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.baidu.tieba.frs.entelechy.a.al
    public void cBF() {
        if (this.biN != null && this.biN.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.biN) {
                if (aVar instanceof com.baidu.tieba.frs.k) {
                    ((com.baidu.tieba.frs.k) aVar).a(this.iKx.getPageContext(), this.iKx.getUniqueId());
                }
            }
            df(this.biN);
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.a.al
    public List<com.baidu.adp.widget.ListView.q> getDatas() {
        if (this.inB != null) {
            return this.inB.getData();
        }
        return null;
    }

    @Override // com.baidu.tieba.frs.entelechy.a.al
    public int cBG() {
        if (this.iSN != null) {
            return R.id.frs_fortune_bag_item;
        }
        return 0;
    }

    @Override // com.baidu.tieba.frs.entelechy.a.al
    public int cBH() {
        if (this.iSN != null) {
            return R.id.frs_my_service_item;
        }
        return 0;
    }

    public void aZK() {
        if (this.dataList != null) {
            this.inB.setData(this.dataList);
        }
        notifyDataSetChanged();
    }

    @Override // com.baidu.tieba.frs.entelechy.a.al
    public void setFromCDN(boolean z) {
        if (this.biN != null && this.biN.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.biN) {
                if (aVar instanceof com.baidu.tieba.frs.k) {
                    ((com.baidu.tieba.frs.k) aVar).setFromCDN(z);
                }
            }
            if (this.iSO != null) {
                this.iSO.setFromCDN(z);
            }
            if (this.iSP != null) {
                this.iSP.setFromCDN(z);
            }
            if (this.iSQ != null) {
                this.iSQ.setFromCDN(z);
            }
            if (this.iSR != null) {
                this.iSR.setFromCDN(z);
            }
            if (this.iSS != null) {
                this.iSS.setFromCDN(z);
            }
            if (this.iST != null) {
                this.iST.setFromCDN(z);
            }
            if (this.iSY != null) {
                this.iSY.setFromCDN(z);
            }
            if (this.iSZ != null) {
                this.iSZ.setFromCDN(z);
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.a.al
    public void cBI() {
        List<com.baidu.adp.widget.ListView.q> data;
        if (this.inB != null && this.inB.getData() != null && this.inB.getData().size() != 0 && (data = this.inB.getData()) != null && data.size() != 0) {
            for (com.baidu.adp.widget.ListView.q qVar : data) {
                if (qVar instanceof bx) {
                    if (((bx) qVar).blx() != 0) {
                        ((bx) qVar).bmC();
                    }
                } else if ((qVar instanceof bw) && ((bw) qVar).evQ.blx() != 0) {
                    ((bw) qVar).evQ.bmC();
                }
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.a.al
    public void qe(boolean z) {
        if (this.iSL != z) {
            this.iSL = z;
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.a.al
    public void b(ArrayList<com.baidu.adp.widget.ListView.q> arrayList, FrsViewData frsViewData) {
        b(frsViewData);
        cAq();
        com.baidu.tieba.tbadkCore.u.x(arrayList, 1);
        az(arrayList);
        aA(arrayList);
        aB(arrayList);
        Iterator<com.baidu.adp.widget.ListView.q> it = arrayList.iterator();
        while (it.hasNext()) {
            com.baidu.adp.widget.ListView.q next = it.next();
            if ((next instanceof bw) && ((bw) next).evQ.isTop()) {
                it.remove();
            }
        }
        this.inB.setData(arrayList);
        this.iSK = frsViewData;
        cAT();
        cBJ();
        this.dataList = arrayList;
    }

    public void b(FrsViewData frsViewData) {
        if (this.biN != null && this.biN.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.biN) {
                if (aVar instanceof com.baidu.tieba.frs.k) {
                    ((com.baidu.tieba.frs.k) aVar).b(frsViewData);
                }
            }
        }
    }

    private ArrayList<Integer> az(ArrayList<com.baidu.adp.widget.ListView.q> arrayList) {
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
                if (this.iSJ != null && !this.iSJ.containsValue(qVar)) {
                    this.iSJ.put(Integer.valueOf(i2), (bx) qVar);
                }
            }
            i = i2 + 1;
        }
    }

    private void aA(ArrayList<com.baidu.adp.widget.ListView.q> arrayList) {
        int i;
        if (this.biN != null && this.biN.size() != 0) {
            int i2 = 0;
            if (arrayList == null || arrayList.size() <= 0) {
                i = 0;
            } else {
                Iterator<com.baidu.adp.widget.ListView.q> it = arrayList.iterator();
                while (true) {
                    i = i2;
                    if (!it.hasNext() || it.next().getType().getId() != bx.eBQ.getId()) {
                        break;
                    }
                    i2 = i + 1;
                }
            }
            for (com.baidu.adp.widget.ListView.a aVar : this.biN) {
                if (aVar instanceof com.baidu.tieba.frs.k) {
                    ((com.baidu.tieba.frs.k) aVar).yY(i);
                }
            }
        }
    }

    private void aB(ArrayList<com.baidu.adp.widget.ListView.q> arrayList) {
        int count = com.baidu.tbadk.core.util.y.getCount(arrayList);
        for (int i = 0; i < count; i++) {
            com.baidu.adp.widget.ListView.q qVar = (com.baidu.adp.widget.ListView.q) com.baidu.tbadk.core.util.y.getItem(arrayList, i - 1);
            com.baidu.adp.widget.ListView.q qVar2 = (com.baidu.adp.widget.ListView.q) com.baidu.tbadk.core.util.y.getItem(arrayList, i);
            if (qVar2 instanceof bw) {
                bx bxVar = ((bw) qVar2).evQ;
                if (i == 0) {
                    bxVar.isFirstFloor = true;
                } else {
                    bxVar.isFirstFloor = false;
                }
                String bje = bxVar.bje();
                if (qVar instanceof com.baidu.tieba.frs.w) {
                    bxVar.needTopMargin = false;
                } else if (qVar != null && !c(qVar)) {
                    bxVar.needTopMargin = false;
                } else if ((qVar instanceof bw) && c(qVar) && !TextUtils.isEmpty(((bw) qVar).evQ.bje())) {
                    bxVar.needTopMargin = true;
                } else if (c(qVar2) && !TextUtils.isEmpty(bje)) {
                    bxVar.needTopMargin = true;
                } else {
                    bxVar.needTopMargin = false;
                }
            }
        }
    }

    private boolean c(com.baidu.adp.widget.ListView.q qVar) {
        if (qVar == null) {
            return false;
        }
        BdUniqueId type = qVar.getType();
        return type == bx.eBR || type == bx.eCn || type == bx.eCo || type == bx.eCx || type == bx.eCG;
    }

    private void cAq() {
        if (!com.baidu.tbadk.core.util.y.isEmpty(this.biN) && this.iKx != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.biN) {
                if (aVar instanceof com.baidu.tieba.frs.k) {
                    ((com.baidu.tieba.frs.k) aVar).a(this.iKx.getTbPageTag());
                }
            }
        }
    }

    private void cAT() {
        com.baidu.tieba.frs.d.b statisticMetaData;
        if (this.iSK != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.biN) {
                if ((aVar instanceof com.baidu.tieba.frs.d.d) && (statisticMetaData = ((com.baidu.tieba.frs.d.d) aVar).getStatisticMetaData()) != null) {
                    if (this.iSK.needLog == 1) {
                        statisticMetaData.jgm = true;
                    } else {
                        statisticMetaData.jgm = false;
                    }
                    if (this.iSK.getForum() != null) {
                        statisticMetaData.jgo = this.iSK.getForum().getId();
                    }
                    if (this.iKx != null && this.iKx.cxJ() != null) {
                        int cDV = this.iKx.cxJ().cDV();
                        if (cDV == -1) {
                            cDV = this.iKx.cxJ().cDW();
                        }
                        statisticMetaData.jgn = cDV;
                    }
                }
            }
        }
    }

    private void cBJ() {
        if (this.iSK != null && this.iSK.getForum() != null && !StringUtils.isNull(this.iSK.getForum().getId()) && this.iSM != null) {
            this.iSM.setForumId(this.iSK.getForum().getId());
        }
    }

    private void df(List<com.baidu.adp.widget.ListView.a> list) {
        if (list != null) {
            for (com.baidu.adp.widget.ListView.a aVar : list) {
                if (aVar instanceof com.baidu.tieba.frs.k) {
                    ((com.baidu.tieba.frs.k) aVar).a(this.iHE);
                }
            }
        }
    }

    private void EA(String str) {
        if (this.biN != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.biN) {
                if (aVar instanceof com.baidu.tieba.a.f) {
                    ((com.baidu.tieba.a.f) aVar).EA(str);
                }
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.a.al
    public void a(com.baidu.tieba.frs.f fVar) {
        if (this.biN != null && this.biN.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.biN) {
                if (aVar instanceof com.baidu.tieba.frs.k) {
                    ((com.baidu.tieba.frs.k) aVar).a(fVar);
                }
            }
        }
    }
}
