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
/* loaded from: classes16.dex */
public class s implements al {
    private ArrayList<com.baidu.adp.widget.ListView.q> dataList;
    private FrsFragment hVk;
    private com.baidu.adp.widget.ListView.v hyl;
    private final HashMap<Integer, bw> idA;
    private FrsViewData idB;
    private ah idD;
    private com.baidu.adp.widget.ListView.a idE;
    private aa idF;
    private n idG;
    private x idH;
    private u idI;
    private m idJ;
    private o idK;
    private y idL;
    private ac idM;
    private w idN;
    private t idO;
    private ab idP;
    private v idQ;
    private List<com.baidu.adp.widget.ListView.a> bbu = new LinkedList();
    private boolean idC = false;
    private final com.baidu.tieba.frs.i hSq = new com.baidu.tieba.frs.i();

    public s(FrsFragment frsFragment, com.baidu.adp.widget.ListView.v vVar, boolean z) {
        this.hyl = vVar;
        a(frsFragment, vVar);
        this.idA = new HashMap<>();
        oN(z);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r5v35, resolved type: com.baidu.tieba.frs.FrsFragment */
    /* JADX WARN: Multi-variable type inference failed */
    public void a(FrsFragment frsFragment, com.baidu.adp.widget.ListView.v vVar) {
        this.hVk = frsFragment;
        this.idE = com.baidu.tieba.frs.e.clb().a(frsFragment.getPageContext(), com.baidu.tieba.tbadkCore.w.mdI, this.hVk.getUniqueId(), false);
        this.idF = new aa(frsFragment.getTbPageContext(), bw.eaX, this.hVk.getUniqueId());
        this.idF.b(vVar);
        this.idG = new n(frsFragment.getTbPageContext(), bw.eaY, this.hVk.getUniqueId());
        this.idG.b(vVar);
        this.idH = new x(frsFragment.getTbPageContext(), bw.eba, this.hVk.getUniqueId());
        this.idH.b(vVar);
        this.idI = new u(frsFragment.getTbPageContext(), bw.ebb, this.hVk.getUniqueId());
        this.idI.b(vVar);
        this.idJ = new m(frsFragment.getTbPageContext(), bw.ebd, this.hVk.getUniqueId());
        this.idJ.b(vVar);
        this.idK = new o(frsFragment.getTbPageContext(), bw.ebe, this.hVk.getUniqueId());
        this.idK.b(vVar);
        this.idM = new ac(frsFragment.getTbPageContext(), bw.ebj, this.hVk.getUniqueId());
        this.idM.b(vVar);
        this.idL = new y(frsFragment.getTbPageContext(), bw.ebB, this.hVk.getUniqueId());
        this.idL.b(vVar);
        this.idN = new w(frsFragment.getTbPageContext(), bw.ebk, this.hVk.getUniqueId());
        this.idN.b(vVar);
        this.idO = new t(frsFragment.getTbPageContext(), bw.ebl, this.hVk.getUniqueId());
        this.idO.b(vVar);
        this.idP = new ab(frsFragment.getPageContext(), bw.ebo, this.hVk.getUniqueId());
        this.idP.b(vVar);
        r rVar = new r(frsFragment.getPageContext(), bw.ebm, this.hVk.getUniqueId());
        rVar.b(vVar);
        z zVar = new z(frsFragment.getPageContext(), bw.ebs, this.hVk.getUniqueId());
        zVar.b(vVar);
        a aVar = new a(frsFragment.getPageContext(), bw.ebg, frsFragment.getUniqueId());
        aVar.b(vVar);
        aVar.tz(1);
        e eVar = new e(frsFragment.getPageContext(), bw.ebc, frsFragment.getUniqueId());
        eVar.b(vVar);
        b bVar = new b(frsFragment.getPageContext(), bw.ebu, this.hVk.getUniqueId());
        bVar.b(vVar);
        bVar.setInFrsAllThread(true);
        h hVar = new h(frsFragment.getPageContext(), bw.ebt, this.hVk.getUniqueId());
        hVar.b(vVar);
        hVar.setInFrsAllThread(true);
        i iVar = new i(frsFragment.getPageContext(), bw.ebv, this.hVk.getUniqueId());
        iVar.b(vVar);
        iVar.setInFrsAllThread(true);
        ab abVar = new ab(frsFragment.getPageContext(), bw.ebw, this.hVk.getUniqueId());
        abVar.b(vVar);
        q qVar = new q(frsFragment.getPageContext(), bw.ebF, this.hVk.getUniqueId());
        qVar.b(vVar);
        p pVar = new p(frsFragment.getPageContext(), bw.ebx, this.hVk.getUniqueId());
        pVar.b(vVar);
        this.idD = new ah(frsFragment.getPageContext(), com.baidu.tieba.tbadkCore.p.mdA, this.hVk.getUniqueId());
        this.idQ = new v(frsFragment.getPageContext(), bw.ebn, this.hVk.getUniqueId());
        this.idQ.b(vVar);
        com.baidu.adp.widget.ListView.a<? extends bv, ? extends af.a> a = com.baidu.tieba.frs.e.clb().a(frsFragment.getPageContext(), this.hVk.getUniqueId(), true);
        com.baidu.adp.widget.ListView.a<? extends bw, ? extends af.a> b = com.baidu.tieba.frs.e.clb().b(frsFragment.getPageContext(), bw.ecZ, this.hVk.getUniqueId());
        com.baidu.tieba.frs.r rVar2 = new com.baidu.tieba.frs.r(frsFragment.getPageContext(), com.baidu.tieba.frs.s.hWl);
        l lVar = new l(frsFragment.getPageContext(), com.baidu.tieba.frs.w.hWE);
        ag agVar = new ag(frsFragment.getPageContext(), com.baidu.tieba.frs.y.hWN, this.hVk.getUniqueId());
        this.bbu.add(this.idE);
        this.bbu.add(this.idF);
        this.bbu.add(this.idG);
        this.bbu.add(this.idH);
        this.bbu.add(this.idI);
        this.bbu.add(this.idJ);
        this.bbu.add(this.idK);
        this.bbu.add(this.idL);
        this.bbu.add(this.idM);
        this.bbu.add(this.idN);
        this.bbu.add(this.idO);
        this.bbu.add(this.idD);
        this.bbu.add(rVar);
        this.bbu.add(zVar);
        this.bbu.add(aVar);
        this.bbu.add(eVar);
        this.bbu.add(bVar);
        this.bbu.add(hVar);
        this.bbu.add(iVar);
        this.bbu.add(this.idQ);
        this.bbu.add(this.idP);
        this.bbu.add(a);
        this.bbu.add(b);
        this.bbu.add(rVar2);
        this.bbu.add(lVar);
        this.bbu.add(qVar);
        this.bbu.add(pVar);
        this.bbu.add(agVar);
        this.bbu.add(abVar);
        com.baidu.tieba.InjectPlugin.b.b bVar2 = new com.baidu.tieba.InjectPlugin.b.b(this.hVk, 1);
        bVar2.setExtraData(this.bbu);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_FEED_AD_PLUGIN_OPERATE, bVar2));
        cF(this.bbu);
        vVar.addAdapters(this.bbu);
        AbsDelegateAdapterList absDelegateAdapterList = new AbsDelegateAdapterList();
        CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_ADD_ADAPTER, absDelegateAdapterList);
        CustomMessage customMessage = new CustomMessage(CmdConfigCustom.CMD_FRS_ADD_ADAPTER);
        customMessage.setTag(this.hVk.getUniqueId());
        customResponsedMessage.setOrginalMessage(customMessage);
        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
        Dj("page_frs");
        if (!absDelegateAdapterList.isEmpty()) {
            Iterator it = absDelegateAdapterList.iterator();
            while (it.hasNext()) {
                com.baidu.adp.widget.ListView.a aVar2 = (com.baidu.adp.widget.ListView.a) it.next();
                if (aVar2 instanceof com.baidu.tieba.frs.k) {
                    ((com.baidu.tieba.frs.k) aVar2).a(this.hVk.getPageContext(), this.hVk.getUniqueId());
                }
            }
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(absDelegateAdapterList);
            if (this.bbu != null) {
                this.bbu.addAll(arrayList);
            }
            if (this.hyl != null) {
                this.hyl.addAdapters(arrayList);
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.a.al
    public void onDestory() {
        for (com.baidu.adp.widget.ListView.a aVar : this.bbu) {
            if (aVar instanceof com.baidu.tieba.frs.k) {
                ((com.baidu.tieba.frs.k) aVar).release();
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.a.al
    public HashMap<Integer, bw> cpH() {
        return this.idA;
    }

    @Override // com.baidu.tieba.frs.entelechy.a.al
    public void notifyDataSetChanged() {
        if (this.hyl.getListAdapter() != null) {
            this.hyl.getListAdapter().notifyDataSetChanged();
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.a.al
    public int cpI() {
        if (this.idE != null) {
            return R.id.frs_bawu_center;
        }
        return 0;
    }

    @Override // com.baidu.tieba.frs.entelechy.a.al
    public boolean s(BdUniqueId bdUniqueId) {
        if (bdUniqueId == null) {
            return false;
        }
        for (com.baidu.adp.widget.ListView.a aVar : this.bbu) {
            if (aVar != null && aVar.getType() == bdUniqueId) {
                return true;
            }
        }
        return false;
    }

    @Override // com.baidu.tieba.frs.entelechy.a.al
    public void a(com.baidu.adp.widget.ListView.ab abVar) {
        if (this.bbu != null && this.bbu.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.bbu) {
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
        if (this.bbu != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.bbu) {
                if (aVar instanceof com.baidu.tieba.card.y) {
                    ((com.baidu.tieba.card.y) aVar).setForumName(str);
                }
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v1, resolved type: com.baidu.tieba.frs.FrsFragment */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.baidu.tieba.frs.entelechy.a.al
    public void cpJ() {
        if (this.bbu != null && this.bbu.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.bbu) {
                if (aVar instanceof com.baidu.tieba.frs.k) {
                    ((com.baidu.tieba.frs.k) aVar).a(this.hVk.getPageContext(), this.hVk.getUniqueId());
                }
            }
            cF(this.bbu);
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.a.al
    public List<com.baidu.adp.widget.ListView.q> getDatas() {
        if (this.hyl != null) {
            return this.hyl.getData();
        }
        return null;
    }

    @Override // com.baidu.tieba.frs.entelechy.a.al
    public int cpK() {
        if (this.idE != null) {
            return R.id.frs_fortune_bag_item;
        }
        return 0;
    }

    @Override // com.baidu.tieba.frs.entelechy.a.al
    public int cpL() {
        if (this.idE != null) {
            return R.id.frs_my_service_item;
        }
        return 0;
    }

    public void aSD() {
        if (this.dataList != null) {
            this.hyl.setData(this.dataList);
        }
        notifyDataSetChanged();
    }

    @Override // com.baidu.tieba.frs.entelechy.a.al
    public void setFromCDN(boolean z) {
        if (this.bbu != null && this.bbu.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.bbu) {
                if (aVar instanceof com.baidu.tieba.frs.k) {
                    ((com.baidu.tieba.frs.k) aVar).setFromCDN(z);
                }
            }
            if (this.idF != null) {
                this.idF.setFromCDN(z);
            }
            if (this.idG != null) {
                this.idG.setFromCDN(z);
            }
            if (this.idH != null) {
                this.idH.setFromCDN(z);
            }
            if (this.idI != null) {
                this.idI.setFromCDN(z);
            }
            if (this.idJ != null) {
                this.idJ.setFromCDN(z);
            }
            if (this.idK != null) {
                this.idK.setFromCDN(z);
            }
            if (this.idP != null) {
                this.idP.setFromCDN(z);
            }
            if (this.idQ != null) {
                this.idQ.setFromCDN(z);
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.a.al
    public void cpM() {
        List<com.baidu.adp.widget.ListView.q> data;
        if (this.hyl != null && this.hyl.getData() != null && this.hyl.getData().size() != 0 && (data = this.hyl.getData()) != null && data.size() != 0) {
            for (com.baidu.adp.widget.ListView.q qVar : data) {
                if (qVar instanceof bw) {
                    if (((bw) qVar).bez() != 0) {
                        ((bw) qVar).bfC();
                    }
                } else if ((qVar instanceof bv) && ((bv) qVar).dUS.bez() != 0) {
                    ((bv) qVar).dUS.bfC();
                }
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.a.al
    public void oN(boolean z) {
        if (this.idC != z) {
            this.idC = z;
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.a.al
    public void b(ArrayList<com.baidu.adp.widget.ListView.q> arrayList, FrsViewData frsViewData) {
        b(frsViewData);
        cot();
        com.baidu.tieba.tbadkCore.u.u(arrayList, 1);
        av(arrayList);
        aw(arrayList);
        ax(arrayList);
        Iterator<com.baidu.adp.widget.ListView.q> it = arrayList.iterator();
        while (it.hasNext()) {
            com.baidu.adp.widget.ListView.q next = it.next();
            if ((next instanceof bv) && ((bv) next).dUS.isTop()) {
                it.remove();
            }
        }
        this.hyl.setData(arrayList);
        this.idB = frsViewData;
        coX();
        cpN();
        this.dataList = arrayList;
    }

    public void b(FrsViewData frsViewData) {
        if (this.bbu != null && this.bbu.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.bbu) {
                if (aVar instanceof com.baidu.tieba.frs.k) {
                    ((com.baidu.tieba.frs.k) aVar).b(frsViewData);
                }
            }
        }
    }

    private ArrayList<Integer> av(ArrayList<com.baidu.adp.widget.ListView.q> arrayList) {
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
                if (this.idA != null && !this.idA.containsValue(qVar)) {
                    this.idA.put(Integer.valueOf(i2), (bw) qVar);
                }
            }
            i = i2 + 1;
        }
    }

    private void aw(ArrayList<com.baidu.adp.widget.ListView.q> arrayList) {
        int i;
        if (this.bbu != null && this.bbu.size() != 0) {
            int i2 = 0;
            if (arrayList == null || arrayList.size() <= 0) {
                i = 0;
            } else {
                Iterator<com.baidu.adp.widget.ListView.q> it = arrayList.iterator();
                while (true) {
                    i = i2;
                    if (!it.hasNext() || it.next().getType().getId() != bw.eaR.getId()) {
                        break;
                    }
                    i2 = i + 1;
                }
            }
            for (com.baidu.adp.widget.ListView.a aVar : this.bbu) {
                if (aVar instanceof com.baidu.tieba.frs.k) {
                    ((com.baidu.tieba.frs.k) aVar).wP(i);
                }
            }
        }
    }

    private void ax(ArrayList<com.baidu.adp.widget.ListView.q> arrayList) {
        int count = com.baidu.tbadk.core.util.y.getCount(arrayList);
        for (int i = 0; i < count; i++) {
            com.baidu.adp.widget.ListView.q qVar = (com.baidu.adp.widget.ListView.q) com.baidu.tbadk.core.util.y.getItem(arrayList, i - 1);
            com.baidu.adp.widget.ListView.q qVar2 = (com.baidu.adp.widget.ListView.q) com.baidu.tbadk.core.util.y.getItem(arrayList, i);
            if (qVar2 instanceof bv) {
                bw bwVar = ((bv) qVar2).dUS;
                if (i == 0) {
                    bwVar.isFirstFloor = true;
                } else {
                    bwVar.isFirstFloor = false;
                }
                String bcf = bwVar.bcf();
                if (qVar instanceof com.baidu.tieba.frs.w) {
                    bwVar.needTopMargin = false;
                } else if (qVar != null && !c(qVar)) {
                    bwVar.needTopMargin = false;
                } else if ((qVar instanceof bv) && c(qVar) && !TextUtils.isEmpty(((bv) qVar).dUS.bcf())) {
                    bwVar.needTopMargin = true;
                } else if (c(qVar2) && !TextUtils.isEmpty(bcf)) {
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
        return type == bw.eaS || type == bw.ebn || type == bw.ebo || type == bw.ebw || type == bw.ebF;
    }

    private void cot() {
        if (!com.baidu.tbadk.core.util.y.isEmpty(this.bbu) && this.hVk != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.bbu) {
                if (aVar instanceof com.baidu.tieba.frs.k) {
                    ((com.baidu.tieba.frs.k) aVar).a(this.hVk.getTbPageTag());
                }
            }
        }
    }

    private void coX() {
        com.baidu.tieba.frs.d.b statisticMetaData;
        if (this.idB != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.bbu) {
                if ((aVar instanceof com.baidu.tieba.frs.d.d) && (statisticMetaData = ((com.baidu.tieba.frs.d.d) aVar).getStatisticMetaData()) != null) {
                    if (this.idB.needLog == 1) {
                        statisticMetaData.iqT = true;
                    } else {
                        statisticMetaData.iqT = false;
                    }
                    if (this.idB.getForum() != null) {
                        statisticMetaData.iqV = this.idB.getForum().getId();
                    }
                    if (this.hVk != null && this.hVk.clN() != null) {
                        int crW = this.hVk.clN().crW();
                        if (crW == -1) {
                            crW = this.hVk.clN().crX();
                        }
                        statisticMetaData.iqU = crW;
                    }
                }
            }
        }
    }

    private void cpN() {
        if (this.idB != null && this.idB.getForum() != null && !StringUtils.isNull(this.idB.getForum().getId()) && this.idD != null) {
            this.idD.setForumId(this.idB.getForum().getId());
        }
    }

    private void cF(List<com.baidu.adp.widget.ListView.a> list) {
        if (list != null) {
            for (com.baidu.adp.widget.ListView.a aVar : list) {
                if (aVar instanceof com.baidu.tieba.frs.k) {
                    ((com.baidu.tieba.frs.k) aVar).a(this.hSq);
                }
            }
        }
    }

    private void Dj(String str) {
        if (this.bbu != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.bbu) {
                if (aVar instanceof com.baidu.tieba.a.f) {
                    ((com.baidu.tieba.a.f) aVar).Dj(str);
                }
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.a.al
    public void a(com.baidu.tieba.frs.f fVar) {
        if (this.bbu != null && this.bbu.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.bbu) {
                if (aVar instanceof com.baidu.tieba.frs.k) {
                    ((com.baidu.tieba.frs.k) aVar).a(fVar);
                }
            }
        }
    }
}
