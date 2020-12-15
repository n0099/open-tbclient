package com.baidu.tieba.frs.entelechy.a;

import android.text.TextUtils;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.adp.widget.ListView.af;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.data.bx;
import com.baidu.tbadk.core.data.by;
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
public class t implements am {
    private ArrayList<com.baidu.adp.widget.ListView.q> dataList;
    private FrsFragment iVs;
    private com.baidu.adp.widget.ListView.v iyv;
    private final HashMap<Integer, by> jdH;
    private FrsViewData jdI;
    private ai jdK;
    private com.baidu.adp.widget.ListView.a jdL;
    private ab jdM;
    private o jdN;
    private y jdO;
    private v jdP;
    private n jdQ;
    private p jdR;
    private z jdS;
    private ad jdT;
    private x jdU;
    private u jdV;
    private ac jdW;
    private w jdX;
    private List<com.baidu.adp.widget.ListView.a> bnf = new LinkedList();
    private boolean jdJ = false;
    private final com.baidu.tieba.frs.i iSy = new com.baidu.tieba.frs.i();

    public t(FrsFragment frsFragment, com.baidu.adp.widget.ListView.v vVar, boolean z) {
        this.iyv = vVar;
        a(frsFragment, vVar);
        this.jdH = new HashMap<>();
        qB(z);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r6v33, resolved type: com.baidu.tieba.frs.FrsFragment */
    /* JADX WARN: Multi-variable type inference failed */
    public void a(FrsFragment frsFragment, com.baidu.adp.widget.ListView.v vVar) {
        this.iVs = frsFragment;
        this.jdL = com.baidu.tieba.frs.e.cBn().a(frsFragment.getPageContext(), com.baidu.tieba.tbadkCore.x.nkF, this.iVs.getUniqueId(), false);
        this.jdM = new ab(frsFragment.getTbPageContext(), by.eIY, this.iVs.getUniqueId());
        this.jdM.b(vVar);
        this.jdN = new o(frsFragment.getTbPageContext(), by.eIZ, this.iVs.getUniqueId());
        this.jdN.b(vVar);
        this.jdO = new y(frsFragment.getTbPageContext(), by.eJb, this.iVs.getUniqueId());
        this.jdO.b(vVar);
        this.jdP = new v(frsFragment.getTbPageContext(), by.eJc, this.iVs.getUniqueId());
        this.jdP.b(vVar);
        this.jdQ = new n(frsFragment.getTbPageContext(), by.eJe, this.iVs.getUniqueId());
        this.jdQ.b(vVar);
        this.jdR = new p(frsFragment.getTbPageContext(), by.eJf, this.iVs.getUniqueId());
        this.jdR.b(vVar);
        this.jdT = new ad(frsFragment.getTbPageContext(), by.eJk, this.iVs.getUniqueId());
        this.jdT.b(vVar);
        this.jdS = new z(frsFragment.getTbPageContext(), by.eJE, this.iVs.getUniqueId());
        this.jdS.b(vVar);
        this.jdU = new x(frsFragment.getTbPageContext(), by.eJl, this.iVs.getUniqueId());
        this.jdU.b(vVar);
        this.jdV = new u(frsFragment.getTbPageContext(), by.eJm, this.iVs.getUniqueId());
        this.jdV.b(vVar);
        this.jdW = new ac(frsFragment.getPageContext(), by.eJq, this.iVs.getUniqueId());
        this.jdW.b(vVar);
        s sVar = new s(frsFragment.getPageContext(), by.eJo, this.iVs.getUniqueId());
        sVar.b(vVar);
        aa aaVar = new aa(frsFragment.getPageContext(), by.eJv, this.iVs.getUniqueId());
        aaVar.b(vVar);
        a aVar = new a(frsFragment.getPageContext(), by.eJh, frsFragment.getUniqueId());
        aVar.b(vVar);
        aVar.wi(1);
        e eVar = new e(frsFragment.getPageContext(), by.eJd, frsFragment.getUniqueId());
        eVar.b(vVar);
        b bVar = new b(frsFragment.getPageContext(), by.eJx, this.iVs.getUniqueId());
        bVar.b(vVar);
        bVar.setInFrsAllThread(true);
        i iVar = new i(frsFragment.getPageContext(), by.eJw, this.iVs.getUniqueId());
        iVar.b(vVar);
        iVar.setInFrsAllThread(true);
        j jVar = new j(frsFragment.getPageContext(), by.eJy, this.iVs.getUniqueId());
        jVar.b(vVar);
        jVar.setInFrsAllThread(true);
        ac acVar = new ac(frsFragment.getPageContext(), by.eJz, this.iVs.getUniqueId());
        acVar.b(vVar);
        r rVar = new r(frsFragment.getPageContext(), by.eJI, this.iVs.getUniqueId());
        rVar.b(vVar);
        q qVar = new q(frsFragment.getPageContext(), by.eJA, this.iVs.getUniqueId());
        qVar.b(vVar);
        this.jdK = new ai(frsFragment.getPageContext(), com.baidu.tieba.tbadkCore.q.nkx, this.iVs.getUniqueId());
        this.jdX = new w(frsFragment.getPageContext(), by.eJp, this.iVs.getUniqueId());
        this.jdX.b(vVar);
        com.baidu.adp.widget.ListView.a<? extends bx, ? extends af.a> a2 = com.baidu.tieba.frs.e.cBn().a(frsFragment.getPageContext(), this.iVs.getUniqueId(), true);
        com.baidu.adp.widget.ListView.a<? extends by, ? extends af.a> b = com.baidu.tieba.frs.e.cBn().b(frsFragment.getPageContext(), by.eLc, this.iVs.getUniqueId());
        com.baidu.tieba.frs.r rVar2 = new com.baidu.tieba.frs.r(frsFragment.getPageContext(), com.baidu.tieba.frs.s.iWt);
        m mVar = new m(frsFragment.getPageContext(), com.baidu.tieba.frs.v.iWK);
        ah ahVar = new ah(frsFragment.getPageContext(), com.baidu.tieba.frs.x.iWT, this.iVs.getUniqueId());
        g gVar = new g(frsFragment.getPageContext(), by.eJj, this.iVs.getUniqueId());
        gVar.a((BdTypeRecyclerView) vVar);
        this.bnf.add(this.jdL);
        this.bnf.add(this.jdM);
        this.bnf.add(this.jdN);
        this.bnf.add(this.jdO);
        this.bnf.add(this.jdP);
        this.bnf.add(this.jdQ);
        this.bnf.add(this.jdR);
        this.bnf.add(this.jdS);
        this.bnf.add(this.jdT);
        this.bnf.add(this.jdU);
        this.bnf.add(this.jdV);
        this.bnf.add(this.jdK);
        this.bnf.add(sVar);
        this.bnf.add(aaVar);
        this.bnf.add(aVar);
        this.bnf.add(eVar);
        this.bnf.add(bVar);
        this.bnf.add(iVar);
        this.bnf.add(jVar);
        this.bnf.add(this.jdX);
        this.bnf.add(this.jdW);
        this.bnf.add(a2);
        this.bnf.add(b);
        this.bnf.add(rVar2);
        this.bnf.add(mVar);
        this.bnf.add(rVar);
        this.bnf.add(qVar);
        this.bnf.add(ahVar);
        this.bnf.add(acVar);
        this.bnf.add(gVar);
        com.baidu.tieba.InjectPlugin.b.b bVar2 = new com.baidu.tieba.InjectPlugin.b.b(this.iVs, 1);
        bVar2.setExtraData(this.bnf);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_FEED_AD_PLUGIN_OPERATE, bVar2));
        dj(this.bnf);
        vVar.addAdapters(this.bnf);
        AbsDelegateAdapterList absDelegateAdapterList = new AbsDelegateAdapterList();
        CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_ADD_ADAPTER, absDelegateAdapterList);
        CustomMessage customMessage = new CustomMessage(CmdConfigCustom.CMD_FRS_ADD_ADAPTER);
        customMessage.setTag(this.iVs.getUniqueId());
        customResponsedMessage.setOrginalMessage(customMessage);
        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
        Fo("page_frs");
        if (!absDelegateAdapterList.isEmpty()) {
            Iterator it = absDelegateAdapterList.iterator();
            while (it.hasNext()) {
                com.baidu.adp.widget.ListView.a aVar2 = (com.baidu.adp.widget.ListView.a) it.next();
                if (aVar2 instanceof com.baidu.tieba.frs.k) {
                    ((com.baidu.tieba.frs.k) aVar2).a(this.iVs.getPageContext(), this.iVs.getUniqueId());
                }
            }
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(absDelegateAdapterList);
            if (this.bnf != null) {
                this.bnf.addAll(arrayList);
            }
            if (this.iyv != null) {
                this.iyv.addAdapters(arrayList);
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.a.am
    public void onDestory() {
        for (com.baidu.adp.widget.ListView.a aVar : this.bnf) {
            if (aVar instanceof com.baidu.tieba.frs.k) {
                ((com.baidu.tieba.frs.k) aVar).release();
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.a.am
    public HashMap<Integer, by> cFX() {
        return this.jdH;
    }

    @Override // com.baidu.tieba.frs.entelechy.a.am
    public void notifyDataSetChanged() {
        if (this.iyv.getListAdapter() != null) {
            this.iyv.getListAdapter().notifyDataSetChanged();
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.a.am
    public int cFY() {
        if (this.jdL != null) {
            return R.id.frs_bawu_center;
        }
        return 0;
    }

    @Override // com.baidu.tieba.frs.entelechy.a.am
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

    @Override // com.baidu.tieba.frs.entelechy.a.am
    public void a(com.baidu.adp.widget.ListView.ab abVar) {
        if (this.bnf != null && this.bnf.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.bnf) {
                if (aVar instanceof com.baidu.tieba.frs.k) {
                    ((com.baidu.tieba.frs.k) aVar).a(abVar);
                } else if ((aVar instanceof w) || (aVar instanceof ac)) {
                    aVar.a(abVar);
                }
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.a.am
    public void setForumName(String str) {
        if (this.bnf != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.bnf) {
                if (aVar instanceof com.baidu.tieba.card.z) {
                    ((com.baidu.tieba.card.z) aVar).setForumName(str);
                }
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v1, resolved type: com.baidu.tieba.frs.FrsFragment */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.baidu.tieba.frs.entelechy.a.am
    public void cFZ() {
        if (this.bnf != null && this.bnf.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.bnf) {
                if (aVar instanceof com.baidu.tieba.frs.k) {
                    ((com.baidu.tieba.frs.k) aVar).a(this.iVs.getPageContext(), this.iVs.getUniqueId());
                }
            }
            dj(this.bnf);
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.a.am
    public List<com.baidu.adp.widget.ListView.q> getDatas() {
        if (this.iyv != null) {
            return this.iyv.getData();
        }
        return null;
    }

    @Override // com.baidu.tieba.frs.entelechy.a.am
    public int cGa() {
        if (this.jdL != null) {
            return R.id.frs_fortune_bag_item;
        }
        return 0;
    }

    @Override // com.baidu.tieba.frs.entelechy.a.am
    public int cGb() {
        if (this.jdL != null) {
            return R.id.frs_my_service_item;
        }
        return 0;
    }

    public void bcP() {
        if (this.dataList != null) {
            this.iyv.setData(this.dataList);
        }
        notifyDataSetChanged();
    }

    @Override // com.baidu.tieba.frs.entelechy.a.am
    public void setFromCDN(boolean z) {
        if (this.bnf != null && this.bnf.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.bnf) {
                if (aVar instanceof com.baidu.tieba.frs.k) {
                    ((com.baidu.tieba.frs.k) aVar).setFromCDN(z);
                }
            }
            if (this.jdM != null) {
                this.jdM.setFromCDN(z);
            }
            if (this.jdN != null) {
                this.jdN.setFromCDN(z);
            }
            if (this.jdO != null) {
                this.jdO.setFromCDN(z);
            }
            if (this.jdP != null) {
                this.jdP.setFromCDN(z);
            }
            if (this.jdQ != null) {
                this.jdQ.setFromCDN(z);
            }
            if (this.jdR != null) {
                this.jdR.setFromCDN(z);
            }
            if (this.jdW != null) {
                this.jdW.setFromCDN(z);
            }
            if (this.jdX != null) {
                this.jdX.setFromCDN(z);
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.a.am
    public void cGc() {
        List<com.baidu.adp.widget.ListView.q> data;
        if (this.iyv != null && this.iyv.getData() != null && this.iyv.getData().size() != 0 && (data = this.iyv.getData()) != null && data.size() != 0) {
            for (com.baidu.adp.widget.ListView.q qVar : data) {
                if (qVar instanceof by) {
                    if (((by) qVar).boK() != 0) {
                        ((by) qVar).bpP();
                    }
                } else if ((qVar instanceof bx) && ((bx) qVar).eCR.boK() != 0) {
                    ((bx) qVar).eCR.bpP();
                }
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.a.am
    public void qB(boolean z) {
        if (this.jdJ != z) {
            this.jdJ = z;
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.a.am
    public void b(ArrayList<com.baidu.adp.widget.ListView.q> arrayList, FrsViewData frsViewData) {
        b(frsViewData);
        cEH();
        com.baidu.tieba.tbadkCore.v.x(arrayList, 1);
        aB(arrayList);
        aC(arrayList);
        aD(arrayList);
        Iterator<com.baidu.adp.widget.ListView.q> it = arrayList.iterator();
        while (it.hasNext()) {
            com.baidu.adp.widget.ListView.q next = it.next();
            if ((next instanceof bx) && ((bx) next).eCR.isTop()) {
                it.remove();
            }
        }
        this.iyv.setData(arrayList);
        this.jdI = frsViewData;
        cFk();
        cGd();
        this.dataList = arrayList;
    }

    public void b(FrsViewData frsViewData) {
        if (this.bnf != null && this.bnf.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.bnf) {
                if (aVar instanceof com.baidu.tieba.frs.k) {
                    ((com.baidu.tieba.frs.k) aVar).b(frsViewData);
                }
            }
        }
    }

    private ArrayList<Integer> aB(ArrayList<com.baidu.adp.widget.ListView.q> arrayList) {
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
                if (this.jdH != null && !this.jdH.containsValue(qVar)) {
                    this.jdH.put(Integer.valueOf(i2), (by) qVar);
                }
            }
            i = i2 + 1;
        }
    }

    private void aC(ArrayList<com.baidu.adp.widget.ListView.q> arrayList) {
        int i;
        if (this.bnf != null && this.bnf.size() != 0) {
            int i2 = 0;
            if (arrayList == null || arrayList.size() <= 0) {
                i = 0;
            } else {
                Iterator<com.baidu.adp.widget.ListView.q> it = arrayList.iterator();
                while (true) {
                    i = i2;
                    if (!it.hasNext() || it.next().getType().getId() != by.eIR.getId()) {
                        break;
                    }
                    i2 = i + 1;
                }
            }
            for (com.baidu.adp.widget.ListView.a aVar : this.bnf) {
                if (aVar instanceof com.baidu.tieba.frs.k) {
                    ((com.baidu.tieba.frs.k) aVar).zD(i);
                }
            }
        }
    }

    private void aD(ArrayList<com.baidu.adp.widget.ListView.q> arrayList) {
        int count = com.baidu.tbadk.core.util.y.getCount(arrayList);
        for (int i = 0; i < count; i++) {
            com.baidu.adp.widget.ListView.q qVar = (com.baidu.adp.widget.ListView.q) com.baidu.tbadk.core.util.y.getItem(arrayList, i - 1);
            com.baidu.adp.widget.ListView.q qVar2 = (com.baidu.adp.widget.ListView.q) com.baidu.tbadk.core.util.y.getItem(arrayList, i);
            if (qVar2 instanceof bx) {
                by byVar = ((bx) qVar2).eCR;
                if (i == 0) {
                    byVar.isFirstFloor = true;
                } else {
                    byVar.isFirstFloor = false;
                }
                String bmo = byVar.bmo();
                if (qVar instanceof com.baidu.tieba.frs.v) {
                    byVar.needTopMargin = false;
                } else if (qVar != null && !c(qVar)) {
                    byVar.needTopMargin = false;
                } else if ((qVar instanceof bx) && c(qVar) && !TextUtils.isEmpty(((bx) qVar).eCR.bmo())) {
                    byVar.needTopMargin = true;
                } else if (c(qVar2) && !TextUtils.isEmpty(bmo)) {
                    byVar.needTopMargin = true;
                } else {
                    byVar.needTopMargin = false;
                }
            }
        }
    }

    private boolean c(com.baidu.adp.widget.ListView.q qVar) {
        if (qVar == null) {
            return false;
        }
        BdUniqueId type = qVar.getType();
        return type == by.eIS || type == by.eJp || type == by.eJq || type == by.eJz || type == by.eJI;
    }

    private void cEH() {
        if (!com.baidu.tbadk.core.util.y.isEmpty(this.bnf) && this.iVs != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.bnf) {
                if (aVar instanceof com.baidu.tieba.frs.k) {
                    ((com.baidu.tieba.frs.k) aVar).a(this.iVs.getTbPageTag());
                }
            }
        }
    }

    private void cFk() {
        com.baidu.tieba.frs.d.b statisticMetaData;
        if (this.jdI != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.bnf) {
                if ((aVar instanceof com.baidu.tieba.frs.d.d) && (statisticMetaData = ((com.baidu.tieba.frs.d.d) aVar).getStatisticMetaData()) != null) {
                    if (this.jdI.needLog == 1) {
                        statisticMetaData.jtR = true;
                    } else {
                        statisticMetaData.jtR = false;
                    }
                    if (this.jdI.getForum() != null) {
                        statisticMetaData.jtT = this.jdI.getForum().getId();
                    }
                    if (this.iVs != null && this.iVs.cCa() != null) {
                        int cJj = this.iVs.cCa().cJj();
                        if (cJj == -1) {
                            cJj = this.iVs.cCa().cJk();
                        }
                        statisticMetaData.jtS = cJj;
                    }
                }
            }
        }
    }

    private void cGd() {
        if (this.jdI != null && this.jdI.getForum() != null && !StringUtils.isNull(this.jdI.getForum().getId()) && this.jdK != null) {
            this.jdK.setForumId(this.jdI.getForum().getId());
        }
    }

    private void dj(List<com.baidu.adp.widget.ListView.a> list) {
        if (list != null) {
            for (com.baidu.adp.widget.ListView.a aVar : list) {
                if (aVar instanceof com.baidu.tieba.frs.k) {
                    ((com.baidu.tieba.frs.k) aVar).a(this.iSy);
                }
            }
        }
    }

    private void Fo(String str) {
        if (this.bnf != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.bnf) {
                if (aVar instanceof com.baidu.tieba.a.f) {
                    ((com.baidu.tieba.a.f) aVar).Fo(str);
                }
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.a.am
    public void a(com.baidu.tieba.frs.f fVar) {
        if (this.bnf != null && this.bnf.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.bnf) {
                if (aVar instanceof com.baidu.tieba.frs.k) {
                    ((com.baidu.tieba.frs.k) aVar).a(fVar);
                }
            }
        }
    }
}
