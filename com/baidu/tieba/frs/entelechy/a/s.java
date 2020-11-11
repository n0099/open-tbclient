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
    private FrsFragment iJK;
    private final HashMap<Integer, bw> iRW;
    private FrsViewData iRX;
    private ah iRZ;
    private com.baidu.adp.widget.ListView.a iSa;
    private aa iSb;
    private n iSc;
    private x iSd;
    private u iSe;
    private m iSf;
    private o iSg;
    private y iSh;
    private ac iSi;
    private w iSj;
    private t iSk;
    private ab iSl;
    private v iSm;
    private com.baidu.adp.widget.ListView.v imM;
    private List<com.baidu.adp.widget.ListView.a> bky = new LinkedList();
    private boolean iRY = false;
    private final com.baidu.tieba.frs.i iGQ = new com.baidu.tieba.frs.i();

    public s(FrsFragment frsFragment, com.baidu.adp.widget.ListView.v vVar, boolean z) {
        this.imM = vVar;
        a(frsFragment, vVar);
        this.iRW = new HashMap<>();
        qb(z);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r5v35, resolved type: com.baidu.tieba.frs.FrsFragment */
    /* JADX WARN: Multi-variable type inference failed */
    public void a(FrsFragment frsFragment, com.baidu.adp.widget.ListView.v vVar) {
        this.iJK = frsFragment;
        this.iSa = com.baidu.tieba.frs.e.cxv().a(frsFragment.getPageContext(), com.baidu.tieba.tbadkCore.w.mVM, this.iJK.getUniqueId(), false);
        this.iSb = new aa(frsFragment.getTbPageContext(), bw.eDF, this.iJK.getUniqueId());
        this.iSb.b(vVar);
        this.iSc = new n(frsFragment.getTbPageContext(), bw.eDG, this.iJK.getUniqueId());
        this.iSc.b(vVar);
        this.iSd = new x(frsFragment.getTbPageContext(), bw.eDI, this.iJK.getUniqueId());
        this.iSd.b(vVar);
        this.iSe = new u(frsFragment.getTbPageContext(), bw.eDJ, this.iJK.getUniqueId());
        this.iSe.b(vVar);
        this.iSf = new m(frsFragment.getTbPageContext(), bw.eDL, this.iJK.getUniqueId());
        this.iSf.b(vVar);
        this.iSg = new o(frsFragment.getTbPageContext(), bw.eDM, this.iJK.getUniqueId());
        this.iSg.b(vVar);
        this.iSi = new ac(frsFragment.getTbPageContext(), bw.eDR, this.iJK.getUniqueId());
        this.iSi.b(vVar);
        this.iSh = new y(frsFragment.getTbPageContext(), bw.eEk, this.iJK.getUniqueId());
        this.iSh.b(vVar);
        this.iSj = new w(frsFragment.getTbPageContext(), bw.eDS, this.iJK.getUniqueId());
        this.iSj.b(vVar);
        this.iSk = new t(frsFragment.getTbPageContext(), bw.eDT, this.iJK.getUniqueId());
        this.iSk.b(vVar);
        this.iSl = new ab(frsFragment.getPageContext(), bw.eDW, this.iJK.getUniqueId());
        this.iSl.b(vVar);
        r rVar = new r(frsFragment.getPageContext(), bw.eDU, this.iJK.getUniqueId());
        rVar.b(vVar);
        z zVar = new z(frsFragment.getPageContext(), bw.eEb, this.iJK.getUniqueId());
        zVar.b(vVar);
        a aVar = new a(frsFragment.getPageContext(), bw.eDO, frsFragment.getUniqueId());
        aVar.b(vVar);
        aVar.vd(1);
        e eVar = new e(frsFragment.getPageContext(), bw.eDK, frsFragment.getUniqueId());
        eVar.b(vVar);
        b bVar = new b(frsFragment.getPageContext(), bw.eEd, this.iJK.getUniqueId());
        bVar.b(vVar);
        bVar.setInFrsAllThread(true);
        h hVar = new h(frsFragment.getPageContext(), bw.eEc, this.iJK.getUniqueId());
        hVar.b(vVar);
        hVar.setInFrsAllThread(true);
        i iVar = new i(frsFragment.getPageContext(), bw.eEe, this.iJK.getUniqueId());
        iVar.b(vVar);
        iVar.setInFrsAllThread(true);
        ab abVar = new ab(frsFragment.getPageContext(), bw.eEf, this.iJK.getUniqueId());
        abVar.b(vVar);
        q qVar = new q(frsFragment.getPageContext(), bw.eEo, this.iJK.getUniqueId());
        qVar.b(vVar);
        p pVar = new p(frsFragment.getPageContext(), bw.eEg, this.iJK.getUniqueId());
        pVar.b(vVar);
        this.iRZ = new ah(frsFragment.getPageContext(), com.baidu.tieba.tbadkCore.p.mVE, this.iJK.getUniqueId());
        this.iSm = new v(frsFragment.getPageContext(), bw.eDV, this.iJK.getUniqueId());
        this.iSm.b(vVar);
        com.baidu.adp.widget.ListView.a<? extends bv, ? extends af.a> a2 = com.baidu.tieba.frs.e.cxv().a(frsFragment.getPageContext(), this.iJK.getUniqueId(), true);
        com.baidu.adp.widget.ListView.a<? extends bw, ? extends af.a> b = com.baidu.tieba.frs.e.cxv().b(frsFragment.getPageContext(), bw.eFI, this.iJK.getUniqueId());
        com.baidu.tieba.frs.r rVar2 = new com.baidu.tieba.frs.r(frsFragment.getPageContext(), com.baidu.tieba.frs.s.iKL);
        l lVar = new l(frsFragment.getPageContext(), com.baidu.tieba.frs.w.iLe);
        ag agVar = new ag(frsFragment.getPageContext(), com.baidu.tieba.frs.y.iLn, this.iJK.getUniqueId());
        this.bky.add(this.iSa);
        this.bky.add(this.iSb);
        this.bky.add(this.iSc);
        this.bky.add(this.iSd);
        this.bky.add(this.iSe);
        this.bky.add(this.iSf);
        this.bky.add(this.iSg);
        this.bky.add(this.iSh);
        this.bky.add(this.iSi);
        this.bky.add(this.iSj);
        this.bky.add(this.iSk);
        this.bky.add(this.iRZ);
        this.bky.add(rVar);
        this.bky.add(zVar);
        this.bky.add(aVar);
        this.bky.add(eVar);
        this.bky.add(bVar);
        this.bky.add(hVar);
        this.bky.add(iVar);
        this.bky.add(this.iSm);
        this.bky.add(this.iSl);
        this.bky.add(a2);
        this.bky.add(b);
        this.bky.add(rVar2);
        this.bky.add(lVar);
        this.bky.add(qVar);
        this.bky.add(pVar);
        this.bky.add(agVar);
        this.bky.add(abVar);
        com.baidu.tieba.InjectPlugin.b.b bVar2 = new com.baidu.tieba.InjectPlugin.b.b(this.iJK, 1);
        bVar2.setExtraData(this.bky);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_FEED_AD_PLUGIN_OPERATE, bVar2));
        df(this.bky);
        vVar.addAdapters(this.bky);
        AbsDelegateAdapterList absDelegateAdapterList = new AbsDelegateAdapterList();
        CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_ADD_ADAPTER, absDelegateAdapterList);
        CustomMessage customMessage = new CustomMessage(CmdConfigCustom.CMD_FRS_ADD_ADAPTER);
        customMessage.setTag(this.iJK.getUniqueId());
        customResponsedMessage.setOrginalMessage(customMessage);
        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
        EZ("page_frs");
        if (!absDelegateAdapterList.isEmpty()) {
            Iterator it = absDelegateAdapterList.iterator();
            while (it.hasNext()) {
                com.baidu.adp.widget.ListView.a aVar2 = (com.baidu.adp.widget.ListView.a) it.next();
                if (aVar2 instanceof com.baidu.tieba.frs.k) {
                    ((com.baidu.tieba.frs.k) aVar2).a(this.iJK.getPageContext(), this.iJK.getUniqueId());
                }
            }
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(absDelegateAdapterList);
            if (this.bky != null) {
                this.bky.addAll(arrayList);
            }
            if (this.imM != null) {
                this.imM.addAdapters(arrayList);
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.a.al
    public void onDestory() {
        for (com.baidu.adp.widget.ListView.a aVar : this.bky) {
            if (aVar instanceof com.baidu.tieba.frs.k) {
                ((com.baidu.tieba.frs.k) aVar).release();
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.a.al
    public HashMap<Integer, bw> cCa() {
        return this.iRW;
    }

    @Override // com.baidu.tieba.frs.entelechy.a.al
    public void notifyDataSetChanged() {
        if (this.imM.getListAdapter() != null) {
            this.imM.getListAdapter().notifyDataSetChanged();
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.a.al
    public int cCb() {
        if (this.iSa != null) {
            return R.id.frs_bawu_center;
        }
        return 0;
    }

    @Override // com.baidu.tieba.frs.entelechy.a.al
    public boolean r(BdUniqueId bdUniqueId) {
        if (bdUniqueId == null) {
            return false;
        }
        for (com.baidu.adp.widget.ListView.a aVar : this.bky) {
            if (aVar != null && aVar.getType() == bdUniqueId) {
                return true;
            }
        }
        return false;
    }

    @Override // com.baidu.tieba.frs.entelechy.a.al
    public void a(com.baidu.adp.widget.ListView.ab abVar) {
        if (this.bky != null && this.bky.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.bky) {
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
        if (this.bky != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.bky) {
                if (aVar instanceof com.baidu.tieba.card.z) {
                    ((com.baidu.tieba.card.z) aVar).setForumName(str);
                }
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v1, resolved type: com.baidu.tieba.frs.FrsFragment */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.baidu.tieba.frs.entelechy.a.al
    public void cCc() {
        if (this.bky != null && this.bky.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.bky) {
                if (aVar instanceof com.baidu.tieba.frs.k) {
                    ((com.baidu.tieba.frs.k) aVar).a(this.iJK.getPageContext(), this.iJK.getUniqueId());
                }
            }
            df(this.bky);
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.a.al
    public List<com.baidu.adp.widget.ListView.q> getDatas() {
        if (this.imM != null) {
            return this.imM.getData();
        }
        return null;
    }

    @Override // com.baidu.tieba.frs.entelechy.a.al
    public int cCd() {
        if (this.iSa != null) {
            return R.id.frs_fortune_bag_item;
        }
        return 0;
    }

    @Override // com.baidu.tieba.frs.entelechy.a.al
    public int cCe() {
        if (this.iSa != null) {
            return R.id.frs_my_service_item;
        }
        return 0;
    }

    public void bar() {
        if (this.dataList != null) {
            this.imM.setData(this.dataList);
        }
        notifyDataSetChanged();
    }

    @Override // com.baidu.tieba.frs.entelechy.a.al
    public void setFromCDN(boolean z) {
        if (this.bky != null && this.bky.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.bky) {
                if (aVar instanceof com.baidu.tieba.frs.k) {
                    ((com.baidu.tieba.frs.k) aVar).setFromCDN(z);
                }
            }
            if (this.iSb != null) {
                this.iSb.setFromCDN(z);
            }
            if (this.iSc != null) {
                this.iSc.setFromCDN(z);
            }
            if (this.iSd != null) {
                this.iSd.setFromCDN(z);
            }
            if (this.iSe != null) {
                this.iSe.setFromCDN(z);
            }
            if (this.iSf != null) {
                this.iSf.setFromCDN(z);
            }
            if (this.iSg != null) {
                this.iSg.setFromCDN(z);
            }
            if (this.iSl != null) {
                this.iSl.setFromCDN(z);
            }
            if (this.iSm != null) {
                this.iSm.setFromCDN(z);
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.a.al
    public void cCf() {
        List<com.baidu.adp.widget.ListView.q> data;
        if (this.imM != null && this.imM.getData() != null && this.imM.getData().size() != 0 && (data = this.imM.getData()) != null && data.size() != 0) {
            for (com.baidu.adp.widget.ListView.q qVar : data) {
                if (qVar instanceof bw) {
                    if (((bw) qVar).bmv() != 0) {
                        ((bw) qVar).bny();
                    }
                } else if ((qVar instanceof bv) && ((bv) qVar).exA.bmv() != 0) {
                    ((bv) qVar).exA.bny();
                }
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.a.al
    public void qb(boolean z) {
        if (this.iRY != z) {
            this.iRY = z;
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.a.al
    public void b(ArrayList<com.baidu.adp.widget.ListView.q> arrayList, FrsViewData frsViewData) {
        b(frsViewData);
        cAN();
        com.baidu.tieba.tbadkCore.u.x(arrayList, 1);
        ay(arrayList);
        az(arrayList);
        aA(arrayList);
        Iterator<com.baidu.adp.widget.ListView.q> it = arrayList.iterator();
        while (it.hasNext()) {
            com.baidu.adp.widget.ListView.q next = it.next();
            if ((next instanceof bv) && ((bv) next).exA.isTop()) {
                it.remove();
            }
        }
        this.imM.setData(arrayList);
        this.iRX = frsViewData;
        cBq();
        cCg();
        this.dataList = arrayList;
    }

    public void b(FrsViewData frsViewData) {
        if (this.bky != null && this.bky.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.bky) {
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
                if (this.iRW != null && !this.iRW.containsValue(qVar)) {
                    this.iRW.put(Integer.valueOf(i2), (bw) qVar);
                }
            }
            i = i2 + 1;
        }
    }

    private void az(ArrayList<com.baidu.adp.widget.ListView.q> arrayList) {
        int i;
        if (this.bky != null && this.bky.size() != 0) {
            int i2 = 0;
            if (arrayList == null || arrayList.size() <= 0) {
                i = 0;
            } else {
                Iterator<com.baidu.adp.widget.ListView.q> it = arrayList.iterator();
                while (true) {
                    i = i2;
                    if (!it.hasNext() || it.next().getType().getId() != bw.eDz.getId()) {
                        break;
                    }
                    i2 = i + 1;
                }
            }
            for (com.baidu.adp.widget.ListView.a aVar : this.bky) {
                if (aVar instanceof com.baidu.tieba.frs.k) {
                    ((com.baidu.tieba.frs.k) aVar).yA(i);
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
                bw bwVar = ((bv) qVar2).exA;
                if (i == 0) {
                    bwVar.isFirstFloor = true;
                } else {
                    bwVar.isFirstFloor = false;
                }
                String bka = bwVar.bka();
                if (qVar instanceof com.baidu.tieba.frs.w) {
                    bwVar.needTopMargin = false;
                } else if (qVar != null && !c(qVar)) {
                    bwVar.needTopMargin = false;
                } else if ((qVar instanceof bv) && c(qVar) && !TextUtils.isEmpty(((bv) qVar).exA.bka())) {
                    bwVar.needTopMargin = true;
                } else if (c(qVar2) && !TextUtils.isEmpty(bka)) {
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
        return type == bw.eDA || type == bw.eDV || type == bw.eDW || type == bw.eEf || type == bw.eEo;
    }

    private void cAN() {
        if (!com.baidu.tbadk.core.util.y.isEmpty(this.bky) && this.iJK != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.bky) {
                if (aVar instanceof com.baidu.tieba.frs.k) {
                    ((com.baidu.tieba.frs.k) aVar).a(this.iJK.getTbPageTag());
                }
            }
        }
    }

    private void cBq() {
        com.baidu.tieba.frs.d.b statisticMetaData;
        if (this.iRX != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.bky) {
                if ((aVar instanceof com.baidu.tieba.frs.d.d) && (statisticMetaData = ((com.baidu.tieba.frs.d.d) aVar).getStatisticMetaData()) != null) {
                    if (this.iRX.needLog == 1) {
                        statisticMetaData.jfB = true;
                    } else {
                        statisticMetaData.jfB = false;
                    }
                    if (this.iRX.getForum() != null) {
                        statisticMetaData.jfD = this.iRX.getForum().getId();
                    }
                    if (this.iJK != null && this.iJK.cyg() != null) {
                        int cEr = this.iJK.cyg().cEr();
                        if (cEr == -1) {
                            cEr = this.iJK.cyg().cEs();
                        }
                        statisticMetaData.jfC = cEr;
                    }
                }
            }
        }
    }

    private void cCg() {
        if (this.iRX != null && this.iRX.getForum() != null && !StringUtils.isNull(this.iRX.getForum().getId()) && this.iRZ != null) {
            this.iRZ.setForumId(this.iRX.getForum().getId());
        }
    }

    private void df(List<com.baidu.adp.widget.ListView.a> list) {
        if (list != null) {
            for (com.baidu.adp.widget.ListView.a aVar : list) {
                if (aVar instanceof com.baidu.tieba.frs.k) {
                    ((com.baidu.tieba.frs.k) aVar).a(this.iGQ);
                }
            }
        }
    }

    private void EZ(String str) {
        if (this.bky != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.bky) {
                if (aVar instanceof com.baidu.tieba.a.f) {
                    ((com.baidu.tieba.a.f) aVar).EZ(str);
                }
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.a.al
    public void a(com.baidu.tieba.frs.f fVar) {
        if (this.bky != null && this.bky.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.bky) {
                if (aVar instanceof com.baidu.tieba.frs.k) {
                    ((com.baidu.tieba.frs.k) aVar).a(fVar);
                }
            }
        }
    }
}
