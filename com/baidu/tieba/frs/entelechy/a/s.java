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
    private FrsFragment iDN;
    private final HashMap<Integer, bw> iLZ;
    private FrsViewData iMa;
    private ah iMc;
    private com.baidu.adp.widget.ListView.a iMd;
    private aa iMe;
    private n iMf;
    private x iMg;
    private u iMh;
    private m iMi;
    private o iMj;
    private y iMk;
    private ac iMl;
    private w iMm;
    private t iMn;
    private ab iMo;
    private v iMp;
    private com.baidu.adp.widget.ListView.v igO;
    private List<com.baidu.adp.widget.ListView.a> bje = new LinkedList();
    private boolean iMb = false;
    private final com.baidu.tieba.frs.i iAT = new com.baidu.tieba.frs.i();

    public s(FrsFragment frsFragment, com.baidu.adp.widget.ListView.v vVar, boolean z) {
        this.igO = vVar;
        a(frsFragment, vVar);
        this.iLZ = new HashMap<>();
        pS(z);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r5v35, resolved type: com.baidu.tieba.frs.FrsFragment */
    /* JADX WARN: Multi-variable type inference failed */
    public void a(FrsFragment frsFragment, com.baidu.adp.widget.ListView.v vVar) {
        this.iDN = frsFragment;
        this.iMd = com.baidu.tieba.frs.e.cuU().a(frsFragment.getPageContext(), com.baidu.tieba.tbadkCore.w.mPJ, this.iDN.getUniqueId(), false);
        this.iMe = new aa(frsFragment.getTbPageContext(), bw.exO, this.iDN.getUniqueId());
        this.iMe.b(vVar);
        this.iMf = new n(frsFragment.getTbPageContext(), bw.exP, this.iDN.getUniqueId());
        this.iMf.b(vVar);
        this.iMg = new x(frsFragment.getTbPageContext(), bw.exR, this.iDN.getUniqueId());
        this.iMg.b(vVar);
        this.iMh = new u(frsFragment.getTbPageContext(), bw.exS, this.iDN.getUniqueId());
        this.iMh.b(vVar);
        this.iMi = new m(frsFragment.getTbPageContext(), bw.exU, this.iDN.getUniqueId());
        this.iMi.b(vVar);
        this.iMj = new o(frsFragment.getTbPageContext(), bw.exV, this.iDN.getUniqueId());
        this.iMj.b(vVar);
        this.iMl = new ac(frsFragment.getTbPageContext(), bw.eya, this.iDN.getUniqueId());
        this.iMl.b(vVar);
        this.iMk = new y(frsFragment.getTbPageContext(), bw.eyv, this.iDN.getUniqueId());
        this.iMk.b(vVar);
        this.iMm = new w(frsFragment.getTbPageContext(), bw.eyb, this.iDN.getUniqueId());
        this.iMm.b(vVar);
        this.iMn = new t(frsFragment.getTbPageContext(), bw.eyc, this.iDN.getUniqueId());
        this.iMn.b(vVar);
        this.iMo = new ab(frsFragment.getPageContext(), bw.eyg, this.iDN.getUniqueId());
        this.iMo.b(vVar);
        r rVar = new r(frsFragment.getPageContext(), bw.eyd, this.iDN.getUniqueId());
        rVar.b(vVar);
        z zVar = new z(frsFragment.getPageContext(), bw.eyl, this.iDN.getUniqueId());
        zVar.b(vVar);
        a aVar = new a(frsFragment.getPageContext(), bw.exX, frsFragment.getUniqueId());
        aVar.b(vVar);
        aVar.uQ(1);
        e eVar = new e(frsFragment.getPageContext(), bw.exT, frsFragment.getUniqueId());
        eVar.b(vVar);
        b bVar = new b(frsFragment.getPageContext(), bw.eyo, this.iDN.getUniqueId());
        bVar.b(vVar);
        bVar.setInFrsAllThread(true);
        h hVar = new h(frsFragment.getPageContext(), bw.eyn, this.iDN.getUniqueId());
        hVar.b(vVar);
        hVar.setInFrsAllThread(true);
        i iVar = new i(frsFragment.getPageContext(), bw.eyp, this.iDN.getUniqueId());
        iVar.b(vVar);
        iVar.setInFrsAllThread(true);
        ab abVar = new ab(frsFragment.getPageContext(), bw.eyq, this.iDN.getUniqueId());
        abVar.b(vVar);
        q qVar = new q(frsFragment.getPageContext(), bw.eyz, this.iDN.getUniqueId());
        qVar.b(vVar);
        p pVar = new p(frsFragment.getPageContext(), bw.eyr, this.iDN.getUniqueId());
        pVar.b(vVar);
        this.iMc = new ah(frsFragment.getPageContext(), com.baidu.tieba.tbadkCore.p.mPB, this.iDN.getUniqueId());
        this.iMp = new v(frsFragment.getPageContext(), bw.eyf, this.iDN.getUniqueId());
        this.iMp.b(vVar);
        com.baidu.adp.widget.ListView.a<? extends bv, ? extends af.a> a2 = com.baidu.tieba.frs.e.cuU().a(frsFragment.getPageContext(), this.iDN.getUniqueId(), true);
        com.baidu.adp.widget.ListView.a<? extends bw, ? extends af.a> b = com.baidu.tieba.frs.e.cuU().b(frsFragment.getPageContext(), bw.ezT, this.iDN.getUniqueId());
        com.baidu.tieba.frs.r rVar2 = new com.baidu.tieba.frs.r(frsFragment.getPageContext(), com.baidu.tieba.frs.s.iEO);
        l lVar = new l(frsFragment.getPageContext(), com.baidu.tieba.frs.w.iFh);
        ag agVar = new ag(frsFragment.getPageContext(), com.baidu.tieba.frs.y.iFq, this.iDN.getUniqueId());
        this.bje.add(this.iMd);
        this.bje.add(this.iMe);
        this.bje.add(this.iMf);
        this.bje.add(this.iMg);
        this.bje.add(this.iMh);
        this.bje.add(this.iMi);
        this.bje.add(this.iMj);
        this.bje.add(this.iMk);
        this.bje.add(this.iMl);
        this.bje.add(this.iMm);
        this.bje.add(this.iMn);
        this.bje.add(this.iMc);
        this.bje.add(rVar);
        this.bje.add(zVar);
        this.bje.add(aVar);
        this.bje.add(eVar);
        this.bje.add(bVar);
        this.bje.add(hVar);
        this.bje.add(iVar);
        this.bje.add(this.iMp);
        this.bje.add(this.iMo);
        this.bje.add(a2);
        this.bje.add(b);
        this.bje.add(rVar2);
        this.bje.add(lVar);
        this.bje.add(qVar);
        this.bje.add(pVar);
        this.bje.add(agVar);
        this.bje.add(abVar);
        com.baidu.tieba.InjectPlugin.b.b bVar2 = new com.baidu.tieba.InjectPlugin.b.b(this.iDN, 1);
        bVar2.setExtraData(this.bje);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_FEED_AD_PLUGIN_OPERATE, bVar2));
        cX(this.bje);
        vVar.addAdapters(this.bje);
        AbsDelegateAdapterList absDelegateAdapterList = new AbsDelegateAdapterList();
        CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_ADD_ADAPTER, absDelegateAdapterList);
        CustomMessage customMessage = new CustomMessage(CmdConfigCustom.CMD_FRS_ADD_ADAPTER);
        customMessage.setTag(this.iDN.getUniqueId());
        customResponsedMessage.setOrginalMessage(customMessage);
        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
        EL("page_frs");
        if (!absDelegateAdapterList.isEmpty()) {
            Iterator it = absDelegateAdapterList.iterator();
            while (it.hasNext()) {
                com.baidu.adp.widget.ListView.a aVar2 = (com.baidu.adp.widget.ListView.a) it.next();
                if (aVar2 instanceof com.baidu.tieba.frs.k) {
                    ((com.baidu.tieba.frs.k) aVar2).a(this.iDN.getPageContext(), this.iDN.getUniqueId());
                }
            }
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(absDelegateAdapterList);
            if (this.bje != null) {
                this.bje.addAll(arrayList);
            }
            if (this.igO != null) {
                this.igO.addAdapters(arrayList);
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.a.al
    public void onDestory() {
        for (com.baidu.adp.widget.ListView.a aVar : this.bje) {
            if (aVar instanceof com.baidu.tieba.frs.k) {
                ((com.baidu.tieba.frs.k) aVar).release();
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.a.al
    public HashMap<Integer, bw> czz() {
        return this.iLZ;
    }

    @Override // com.baidu.tieba.frs.entelechy.a.al
    public void notifyDataSetChanged() {
        if (this.igO.getListAdapter() != null) {
            this.igO.getListAdapter().notifyDataSetChanged();
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.a.al
    public int czA() {
        if (this.iMd != null) {
            return R.id.frs_bawu_center;
        }
        return 0;
    }

    @Override // com.baidu.tieba.frs.entelechy.a.al
    public boolean r(BdUniqueId bdUniqueId) {
        if (bdUniqueId == null) {
            return false;
        }
        for (com.baidu.adp.widget.ListView.a aVar : this.bje) {
            if (aVar != null && aVar.getType() == bdUniqueId) {
                return true;
            }
        }
        return false;
    }

    @Override // com.baidu.tieba.frs.entelechy.a.al
    public void a(com.baidu.adp.widget.ListView.ab abVar) {
        if (this.bje != null && this.bje.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.bje) {
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
        if (this.bje != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.bje) {
                if (aVar instanceof com.baidu.tieba.card.z) {
                    ((com.baidu.tieba.card.z) aVar).setForumName(str);
                }
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v1, resolved type: com.baidu.tieba.frs.FrsFragment */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.baidu.tieba.frs.entelechy.a.al
    public void czB() {
        if (this.bje != null && this.bje.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.bje) {
                if (aVar instanceof com.baidu.tieba.frs.k) {
                    ((com.baidu.tieba.frs.k) aVar).a(this.iDN.getPageContext(), this.iDN.getUniqueId());
                }
            }
            cX(this.bje);
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.a.al
    public List<com.baidu.adp.widget.ListView.q> getDatas() {
        if (this.igO != null) {
            return this.igO.getData();
        }
        return null;
    }

    @Override // com.baidu.tieba.frs.entelechy.a.al
    public int czC() {
        if (this.iMd != null) {
            return R.id.frs_fortune_bag_item;
        }
        return 0;
    }

    @Override // com.baidu.tieba.frs.entelechy.a.al
    public int czD() {
        if (this.iMd != null) {
            return R.id.frs_my_service_item;
        }
        return 0;
    }

    public void aXR() {
        if (this.dataList != null) {
            this.igO.setData(this.dataList);
        }
        notifyDataSetChanged();
    }

    @Override // com.baidu.tieba.frs.entelechy.a.al
    public void setFromCDN(boolean z) {
        if (this.bje != null && this.bje.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.bje) {
                if (aVar instanceof com.baidu.tieba.frs.k) {
                    ((com.baidu.tieba.frs.k) aVar).setFromCDN(z);
                }
            }
            if (this.iMe != null) {
                this.iMe.setFromCDN(z);
            }
            if (this.iMf != null) {
                this.iMf.setFromCDN(z);
            }
            if (this.iMg != null) {
                this.iMg.setFromCDN(z);
            }
            if (this.iMh != null) {
                this.iMh.setFromCDN(z);
            }
            if (this.iMi != null) {
                this.iMi.setFromCDN(z);
            }
            if (this.iMj != null) {
                this.iMj.setFromCDN(z);
            }
            if (this.iMo != null) {
                this.iMo.setFromCDN(z);
            }
            if (this.iMp != null) {
                this.iMp.setFromCDN(z);
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.a.al
    public void czE() {
        List<com.baidu.adp.widget.ListView.q> data;
        if (this.igO != null && this.igO.getData() != null && this.igO.getData().size() != 0 && (data = this.igO.getData()) != null && data.size() != 0) {
            for (com.baidu.adp.widget.ListView.q qVar : data) {
                if (qVar instanceof bw) {
                    if (((bw) qVar).bjV() != 0) {
                        ((bw) qVar).bkY();
                    }
                } else if ((qVar instanceof bv) && ((bv) qVar).erH.bjV() != 0) {
                    ((bv) qVar).erH.bkY();
                }
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.a.al
    public void pS(boolean z) {
        if (this.iMb != z) {
            this.iMb = z;
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.a.al
    public void b(ArrayList<com.baidu.adp.widget.ListView.q> arrayList, FrsViewData frsViewData) {
        b(frsViewData);
        cym();
        com.baidu.tieba.tbadkCore.u.x(arrayList, 1);
        ay(arrayList);
        az(arrayList);
        aA(arrayList);
        Iterator<com.baidu.adp.widget.ListView.q> it = arrayList.iterator();
        while (it.hasNext()) {
            com.baidu.adp.widget.ListView.q next = it.next();
            if ((next instanceof bv) && ((bv) next).erH.isTop()) {
                it.remove();
            }
        }
        this.igO.setData(arrayList);
        this.iMa = frsViewData;
        cyP();
        czF();
        this.dataList = arrayList;
    }

    public void b(FrsViewData frsViewData) {
        if (this.bje != null && this.bje.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.bje) {
                if (aVar instanceof com.baidu.tieba.frs.k) {
                    ((com.baidu.tieba.frs.k) aVar).b(frsViewData);
                }
            }
        }
    }

    private ArrayList<Integer> ay(ArrayList<com.baidu.adp.widget.ListView.q> arrayList) {
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
                if (this.iLZ != null && !this.iLZ.containsValue(qVar)) {
                    this.iLZ.put(Integer.valueOf(i2), (bw) qVar);
                }
            }
            i = i2 + 1;
        }
    }

    private void az(ArrayList<com.baidu.adp.widget.ListView.q> arrayList) {
        int i;
        if (this.bje != null && this.bje.size() != 0) {
            int i2 = 0;
            if (arrayList == null || arrayList.size() <= 0) {
                i = 0;
            } else {
                Iterator<com.baidu.adp.widget.ListView.q> it = arrayList.iterator();
                while (true) {
                    i = i2;
                    if (!it.hasNext() || it.next().getType().getId() != bw.exI.getId()) {
                        break;
                    }
                    i2 = i + 1;
                }
            }
            for (com.baidu.adp.widget.ListView.a aVar : this.bje) {
                if (aVar instanceof com.baidu.tieba.frs.k) {
                    ((com.baidu.tieba.frs.k) aVar).yn(i);
                }
            }
        }
    }

    private void aA(ArrayList<com.baidu.adp.widget.ListView.q> arrayList) {
        int count = com.baidu.tbadk.core.util.y.getCount(arrayList);
        for (int i = 0; i < count; i++) {
            com.baidu.adp.widget.ListView.q qVar = (com.baidu.adp.widget.ListView.q) com.baidu.tbadk.core.util.y.getItem(arrayList, i - 1);
            com.baidu.adp.widget.ListView.q qVar2 = (com.baidu.adp.widget.ListView.q) com.baidu.tbadk.core.util.y.getItem(arrayList, i);
            if (qVar2 instanceof bv) {
                bw bwVar = ((bv) qVar2).erH;
                if (i == 0) {
                    bwVar.isFirstFloor = true;
                } else {
                    bwVar.isFirstFloor = false;
                }
                String bhA = bwVar.bhA();
                if (qVar instanceof com.baidu.tieba.frs.w) {
                    bwVar.needTopMargin = false;
                } else if (qVar != null && !c(qVar)) {
                    bwVar.needTopMargin = false;
                } else if ((qVar instanceof bv) && c(qVar) && !TextUtils.isEmpty(((bv) qVar).erH.bhA())) {
                    bwVar.needTopMargin = true;
                } else if (c(qVar2) && !TextUtils.isEmpty(bhA)) {
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
        return type == bw.exJ || type == bw.eyf || type == bw.eyg || type == bw.eyq || type == bw.eyz;
    }

    private void cym() {
        if (!com.baidu.tbadk.core.util.y.isEmpty(this.bje) && this.iDN != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.bje) {
                if (aVar instanceof com.baidu.tieba.frs.k) {
                    ((com.baidu.tieba.frs.k) aVar).a(this.iDN.getTbPageTag());
                }
            }
        }
    }

    private void cyP() {
        com.baidu.tieba.frs.d.b statisticMetaData;
        if (this.iMa != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.bje) {
                if ((aVar instanceof com.baidu.tieba.frs.d.d) && (statisticMetaData = ((com.baidu.tieba.frs.d.d) aVar).getStatisticMetaData()) != null) {
                    if (this.iMa.needLog == 1) {
                        statisticMetaData.iZE = true;
                    } else {
                        statisticMetaData.iZE = false;
                    }
                    if (this.iMa.getForum() != null) {
                        statisticMetaData.iZG = this.iMa.getForum().getId();
                    }
                    if (this.iDN != null && this.iDN.cvF() != null) {
                        int cBQ = this.iDN.cvF().cBQ();
                        if (cBQ == -1) {
                            cBQ = this.iDN.cvF().cBR();
                        }
                        statisticMetaData.iZF = cBQ;
                    }
                }
            }
        }
    }

    private void czF() {
        if (this.iMa != null && this.iMa.getForum() != null && !StringUtils.isNull(this.iMa.getForum().getId()) && this.iMc != null) {
            this.iMc.setForumId(this.iMa.getForum().getId());
        }
    }

    private void cX(List<com.baidu.adp.widget.ListView.a> list) {
        if (list != null) {
            for (com.baidu.adp.widget.ListView.a aVar : list) {
                if (aVar instanceof com.baidu.tieba.frs.k) {
                    ((com.baidu.tieba.frs.k) aVar).a(this.iAT);
                }
            }
        }
    }

    private void EL(String str) {
        if (this.bje != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.bje) {
                if (aVar instanceof com.baidu.tieba.a.f) {
                    ((com.baidu.tieba.a.f) aVar).EL(str);
                }
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.a.al
    public void a(com.baidu.tieba.frs.f fVar) {
        if (this.bje != null && this.bje.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.bje) {
                if (aVar instanceof com.baidu.tieba.frs.k) {
                    ((com.baidu.tieba.frs.k) aVar).a(fVar);
                }
            }
        }
    }
}
