package com.baidu.tieba.frs.entelechy.a;

import android.text.TextUtils;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.ad;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.data.bu;
import com.baidu.tbadk.core.data.bv;
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
    private FrsFragment hHU;
    private y hPA;
    private ac hPB;
    private w hPC;
    private t hPD;
    private ab hPE;
    private v hPF;
    private final HashMap<Integer, bv> hPp;
    private FrsViewData hPq;
    private ah hPs;
    private com.baidu.adp.widget.ListView.a hPt;
    private aa hPu;
    private n hPv;
    private x hPw;
    private u hPx;
    private m hPy;
    private o hPz;
    private com.baidu.adp.widget.ListView.v hlu;
    private List<com.baidu.adp.widget.ListView.a> aWf = new LinkedList();
    private boolean hPr = false;
    private final com.baidu.tieba.frs.h hFa = new com.baidu.tieba.frs.h();

    public s(FrsFragment frsFragment, com.baidu.adp.widget.ListView.v vVar, boolean z) {
        this.hlu = vVar;
        a(frsFragment, vVar);
        this.hPp = new HashMap<>();
        oj(z);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r5v35, resolved type: com.baidu.tieba.frs.FrsFragment */
    /* JADX WARN: Multi-variable type inference failed */
    public void a(FrsFragment frsFragment, com.baidu.adp.widget.ListView.v vVar) {
        this.hHU = frsFragment;
        this.hPt = com.baidu.tieba.frs.e.caF().a(frsFragment.getPageContext(), com.baidu.tieba.tbadkCore.v.lLW, this.hHU.getUniqueId(), false);
        this.hPu = new aa(frsFragment.getTbPageContext(), bv.dRB, this.hHU.getUniqueId());
        this.hPu.b(vVar);
        this.hPv = new n(frsFragment.getTbPageContext(), bv.dRC, this.hHU.getUniqueId());
        this.hPv.b(vVar);
        this.hPw = new x(frsFragment.getTbPageContext(), bv.dRE, this.hHU.getUniqueId());
        this.hPw.b(vVar);
        this.hPx = new u(frsFragment.getTbPageContext(), bv.dRF, this.hHU.getUniqueId());
        this.hPx.b(vVar);
        this.hPy = new m(frsFragment.getTbPageContext(), bv.dRH, this.hHU.getUniqueId());
        this.hPy.b(vVar);
        this.hPz = new o(frsFragment.getTbPageContext(), bv.dRI, this.hHU.getUniqueId());
        this.hPz.b(vVar);
        this.hPB = new ac(frsFragment.getTbPageContext(), bv.dRN, this.hHU.getUniqueId());
        this.hPB.b(vVar);
        this.hPA = new y(frsFragment.getTbPageContext(), bv.dSf, this.hHU.getUniqueId());
        this.hPA.b(vVar);
        this.hPC = new w(frsFragment.getTbPageContext(), bv.dRO, this.hHU.getUniqueId());
        this.hPC.b(vVar);
        this.hPD = new t(frsFragment.getTbPageContext(), bv.dRP, this.hHU.getUniqueId());
        this.hPD.b(vVar);
        this.hPE = new ab(frsFragment.getPageContext(), bv.dRS, this.hHU.getUniqueId());
        this.hPE.b(vVar);
        r rVar = new r(frsFragment.getPageContext(), bv.dRQ, this.hHU.getUniqueId());
        rVar.b(vVar);
        z zVar = new z(frsFragment.getPageContext(), bv.dRW, this.hHU.getUniqueId());
        zVar.b(vVar);
        a aVar = new a(frsFragment.getPageContext(), bv.dRK, frsFragment.getUniqueId());
        aVar.b(vVar);
        aVar.rn(1);
        e eVar = new e(frsFragment.getPageContext(), bv.dRG, frsFragment.getUniqueId());
        eVar.b(vVar);
        b bVar = new b(frsFragment.getPageContext(), bv.dRY, this.hHU.getUniqueId());
        bVar.b(vVar);
        bVar.setInFrsAllThread(true);
        h hVar = new h(frsFragment.getPageContext(), bv.dRX, this.hHU.getUniqueId());
        hVar.b(vVar);
        hVar.setInFrsAllThread(true);
        i iVar = new i(frsFragment.getPageContext(), bv.dRZ, this.hHU.getUniqueId());
        iVar.b(vVar);
        iVar.setInFrsAllThread(true);
        ab abVar = new ab(frsFragment.getPageContext(), bv.dSa, this.hHU.getUniqueId());
        abVar.b(vVar);
        q qVar = new q(frsFragment.getPageContext(), bv.dSj, this.hHU.getUniqueId());
        qVar.b(vVar);
        p pVar = new p(frsFragment.getPageContext(), bv.dSb, this.hHU.getUniqueId());
        pVar.b(vVar);
        this.hPs = new ah(frsFragment.getPageContext(), com.baidu.tieba.tbadkCore.o.lLO, this.hHU.getUniqueId());
        this.hPF = new v(frsFragment.getPageContext(), bv.dRR, this.hHU.getUniqueId());
        this.hPF.b(vVar);
        com.baidu.adp.widget.ListView.a<? extends bu, ? extends ad.a> a = com.baidu.tieba.frs.e.caF().a(frsFragment.getPageContext(), this.hHU.getUniqueId(), true);
        com.baidu.adp.widget.ListView.a<? extends bv, ? extends ad.a> b = com.baidu.tieba.frs.e.caF().b(frsFragment.getPageContext(), bv.dTD, this.hHU.getUniqueId());
        com.baidu.tieba.frs.q qVar2 = new com.baidu.tieba.frs.q(frsFragment.getPageContext(), com.baidu.tieba.frs.r.hIV);
        l lVar = new l(frsFragment.getPageContext(), com.baidu.tieba.frs.v.hJk);
        ag agVar = new ag(frsFragment.getPageContext(), com.baidu.tieba.frs.x.hJt, this.hHU.getUniqueId());
        this.aWf.add(this.hPt);
        this.aWf.add(this.hPu);
        this.aWf.add(this.hPv);
        this.aWf.add(this.hPw);
        this.aWf.add(this.hPx);
        this.aWf.add(this.hPy);
        this.aWf.add(this.hPz);
        this.aWf.add(this.hPA);
        this.aWf.add(this.hPB);
        this.aWf.add(this.hPC);
        this.aWf.add(this.hPD);
        this.aWf.add(this.hPs);
        this.aWf.add(rVar);
        this.aWf.add(zVar);
        this.aWf.add(aVar);
        this.aWf.add(eVar);
        this.aWf.add(bVar);
        this.aWf.add(hVar);
        this.aWf.add(iVar);
        this.aWf.add(this.hPF);
        this.aWf.add(this.hPE);
        this.aWf.add(a);
        this.aWf.add(b);
        this.aWf.add(qVar2);
        this.aWf.add(lVar);
        this.aWf.add(qVar);
        this.aWf.add(pVar);
        this.aWf.add(agVar);
        this.aWf.add(abVar);
        com.baidu.tieba.InjectPlugin.b.b bVar2 = new com.baidu.tieba.InjectPlugin.b.b(this.hHU, 1);
        bVar2.setExtraData(this.aWf);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_FEED_AD_PLUGIN_OPERATE, bVar2));
        cD(this.aWf);
        vVar.addAdapters(this.aWf);
        AbsDelegateAdapterList absDelegateAdapterList = new AbsDelegateAdapterList();
        CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_ADD_ADAPTER, absDelegateAdapterList);
        CustomMessage customMessage = new CustomMessage(CmdConfigCustom.CMD_FRS_ADD_ADAPTER);
        customMessage.setTag(this.hHU.getUniqueId());
        customResponsedMessage.setOrginalMessage(customMessage);
        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
        AP("page_frs");
        if (!absDelegateAdapterList.isEmpty()) {
            Iterator it = absDelegateAdapterList.iterator();
            while (it.hasNext()) {
                com.baidu.adp.widget.ListView.a aVar2 = (com.baidu.adp.widget.ListView.a) it.next();
                if (aVar2 instanceof com.baidu.tieba.frs.j) {
                    ((com.baidu.tieba.frs.j) aVar2).a(this.hHU.getPageContext(), this.hHU.getUniqueId());
                }
            }
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(absDelegateAdapterList);
            if (this.aWf != null) {
                this.aWf.addAll(arrayList);
            }
            if (this.hlu != null) {
                this.hlu.addAdapters(arrayList);
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.a.al
    public void onDestory() {
        for (com.baidu.adp.widget.ListView.a aVar : this.aWf) {
            if (aVar instanceof com.baidu.tieba.frs.j) {
                ((com.baidu.tieba.frs.j) aVar).release();
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.a.al
    public HashMap<Integer, bv> cfc() {
        return this.hPp;
    }

    @Override // com.baidu.tieba.frs.entelechy.a.al
    public void notifyDataSetChanged() {
        if (this.hlu.getListAdapter() != null) {
            this.hlu.getListAdapter().notifyDataSetChanged();
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.a.al
    public int cfd() {
        if (this.hPt != null) {
            return R.id.frs_bawu_center;
        }
        return 0;
    }

    @Override // com.baidu.tieba.frs.entelechy.a.al
    public boolean s(BdUniqueId bdUniqueId) {
        if (bdUniqueId == null) {
            return false;
        }
        for (com.baidu.adp.widget.ListView.a aVar : this.aWf) {
            if (aVar != null && aVar.getType() == bdUniqueId) {
                return true;
            }
        }
        return false;
    }

    @Override // com.baidu.tieba.frs.entelechy.a.al
    public void a(com.baidu.adp.widget.ListView.z zVar) {
        if (this.aWf != null && this.aWf.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.aWf) {
                if (aVar instanceof com.baidu.tieba.frs.j) {
                    ((com.baidu.tieba.frs.j) aVar).a(zVar);
                } else if ((aVar instanceof v) || (aVar instanceof ab)) {
                    aVar.a(zVar);
                }
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.a.al
    public void setForumName(String str) {
        if (this.aWf != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.aWf) {
                if (aVar instanceof com.baidu.tieba.card.y) {
                    ((com.baidu.tieba.card.y) aVar).setForumName(str);
                }
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v1, resolved type: com.baidu.tieba.frs.FrsFragment */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.baidu.tieba.frs.entelechy.a.al
    public void cfe() {
        if (this.aWf != null && this.aWf.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.aWf) {
                if (aVar instanceof com.baidu.tieba.frs.j) {
                    ((com.baidu.tieba.frs.j) aVar).a(this.hHU.getPageContext(), this.hHU.getUniqueId());
                }
            }
            cD(this.aWf);
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.a.al
    public List<com.baidu.adp.widget.ListView.q> getDatas() {
        if (this.hlu != null) {
            return this.hlu.getData();
        }
        return null;
    }

    @Override // com.baidu.tieba.frs.entelechy.a.al
    public int cff() {
        if (this.hPt != null) {
            return R.id.frs_fortune_bag_item;
        }
        return 0;
    }

    @Override // com.baidu.tieba.frs.entelechy.a.al
    public int cfg() {
        if (this.hPt != null) {
            return R.id.frs_my_service_item;
        }
        return 0;
    }

    public void aJP() {
        if (this.dataList != null) {
            this.hlu.setData(this.dataList);
        }
        notifyDataSetChanged();
    }

    @Override // com.baidu.tieba.frs.entelechy.a.al
    public void setFromCDN(boolean z) {
        if (this.aWf != null && this.aWf.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.aWf) {
                if (aVar instanceof com.baidu.tieba.frs.j) {
                    ((com.baidu.tieba.frs.j) aVar).setFromCDN(z);
                }
            }
            if (this.hPu != null) {
                this.hPu.setFromCDN(z);
            }
            if (this.hPv != null) {
                this.hPv.setFromCDN(z);
            }
            if (this.hPw != null) {
                this.hPw.setFromCDN(z);
            }
            if (this.hPx != null) {
                this.hPx.setFromCDN(z);
            }
            if (this.hPy != null) {
                this.hPy.setFromCDN(z);
            }
            if (this.hPz != null) {
                this.hPz.setFromCDN(z);
            }
            if (this.hPE != null) {
                this.hPE.setFromCDN(z);
            }
            if (this.hPF != null) {
                this.hPF.setFromCDN(z);
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.a.al
    public void cfh() {
        List<com.baidu.adp.widget.ListView.q> data;
        if (this.hlu != null && this.hlu.getData() != null && this.hlu.getData().size() != 0 && (data = this.hlu.getData()) != null && data.size() != 0) {
            for (com.baidu.adp.widget.ListView.q qVar : data) {
                if (qVar instanceof bv) {
                    if (((bv) qVar).aWg() != 0) {
                        ((bv) qVar).aXj();
                    }
                } else if ((qVar instanceof bu) && ((bu) qVar).dLK.aWg() != 0) {
                    ((bu) qVar).dLK.aXj();
                }
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.a.al
    public void oj(boolean z) {
        if (this.hPr != z) {
            this.hPr = z;
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.a.al
    public void b(ArrayList<com.baidu.adp.widget.ListView.q> arrayList, FrsViewData frsViewData) {
        b(frsViewData);
        cdP();
        com.baidu.tieba.tbadkCore.t.r(arrayList, 1);
        ap(arrayList);
        aq(arrayList);
        ar(arrayList);
        Iterator<com.baidu.adp.widget.ListView.q> it = arrayList.iterator();
        while (it.hasNext()) {
            com.baidu.adp.widget.ListView.q next = it.next();
            if ((next instanceof bu) && ((bu) next).dLK.isTop()) {
                it.remove();
            }
        }
        this.hlu.setData(arrayList);
        this.hPq = frsViewData;
        cet();
        cfi();
        this.dataList = arrayList;
    }

    public void b(FrsViewData frsViewData) {
        if (this.aWf != null && this.aWf.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.aWf) {
                if (aVar instanceof com.baidu.tieba.frs.j) {
                    ((com.baidu.tieba.frs.j) aVar).b(frsViewData);
                }
            }
        }
    }

    private ArrayList<Integer> ap(ArrayList<com.baidu.adp.widget.ListView.q> arrayList) {
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
                if (this.hPp != null && !this.hPp.containsValue(qVar)) {
                    this.hPp.put(Integer.valueOf(i2), (bv) qVar);
                }
            }
            i = i2 + 1;
        }
    }

    private void aq(ArrayList<com.baidu.adp.widget.ListView.q> arrayList) {
        int i;
        if (this.aWf != null && this.aWf.size() != 0) {
            int i2 = 0;
            if (arrayList == null || arrayList.size() <= 0) {
                i = 0;
            } else {
                Iterator<com.baidu.adp.widget.ListView.q> it = arrayList.iterator();
                while (true) {
                    i = i2;
                    if (!it.hasNext() || it.next().getType().getId() != bv.dRw.getId()) {
                        break;
                    }
                    i2 = i + 1;
                }
            }
            for (com.baidu.adp.widget.ListView.a aVar : this.aWf) {
                if (aVar instanceof com.baidu.tieba.frs.j) {
                    ((com.baidu.tieba.frs.j) aVar).uA(i);
                }
            }
        }
    }

    private void ar(ArrayList<com.baidu.adp.widget.ListView.q> arrayList) {
        int count = com.baidu.tbadk.core.util.x.getCount(arrayList);
        for (int i = 0; i < count; i++) {
            com.baidu.adp.widget.ListView.q qVar = (com.baidu.adp.widget.ListView.q) com.baidu.tbadk.core.util.x.getItem(arrayList, i - 1);
            com.baidu.adp.widget.ListView.q qVar2 = (com.baidu.adp.widget.ListView.q) com.baidu.tbadk.core.util.x.getItem(arrayList, i);
            if (qVar2 instanceof bu) {
                bv bvVar = ((bu) qVar2).dLK;
                if (i == 0) {
                    bvVar.isFirstFloor = true;
                } else {
                    bvVar.isFirstFloor = false;
                }
                String aTO = bvVar.aTO();
                if (qVar instanceof com.baidu.tieba.frs.v) {
                    bvVar.needTopMargin = false;
                } else if (qVar != null && !c(qVar)) {
                    bvVar.needTopMargin = false;
                } else if ((qVar instanceof bu) && c(qVar) && !TextUtils.isEmpty(((bu) qVar).dLK.aTO())) {
                    bvVar.needTopMargin = true;
                } else if (c(qVar2) && !TextUtils.isEmpty(aTO)) {
                    bvVar.needTopMargin = true;
                } else {
                    bvVar.needTopMargin = false;
                }
            }
        }
    }

    private boolean c(com.baidu.adp.widget.ListView.q qVar) {
        if (qVar == null) {
            return false;
        }
        BdUniqueId type = qVar.getType();
        return type == bv.dRx || type == bv.dRR || type == bv.dRS || type == bv.dSa || type == bv.dSj;
    }

    private void cdP() {
        if (!com.baidu.tbadk.core.util.x.isEmpty(this.aWf) && this.hHU != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.aWf) {
                if (aVar instanceof com.baidu.tieba.frs.j) {
                    ((com.baidu.tieba.frs.j) aVar).a(this.hHU.getTbPageTag());
                }
            }
        }
    }

    private void cet() {
        com.baidu.tieba.frs.d.b statisticMetaData;
        if (this.hPq != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.aWf) {
                if ((aVar instanceof com.baidu.tieba.frs.d.d) && (statisticMetaData = ((com.baidu.tieba.frs.d.d) aVar).getStatisticMetaData()) != null) {
                    if (this.hPq.needLog == 1) {
                        statisticMetaData.icK = true;
                    } else {
                        statisticMetaData.icK = false;
                    }
                    if (this.hPq.getForum() != null) {
                        statisticMetaData.icM = this.hPq.getForum().getId();
                    }
                    if (this.hHU != null && this.hHU.cbr() != null) {
                        int chr = this.hHU.cbr().chr();
                        if (chr == -1) {
                            chr = this.hHU.cbr().chs();
                        }
                        statisticMetaData.icL = chr;
                    }
                }
            }
        }
    }

    private void cfi() {
        if (this.hPq != null && this.hPq.getForum() != null && !StringUtils.isNull(this.hPq.getForum().getId()) && this.hPs != null) {
            this.hPs.setForumId(this.hPq.getForum().getId());
        }
    }

    private void cD(List<com.baidu.adp.widget.ListView.a> list) {
        if (list != null) {
            for (com.baidu.adp.widget.ListView.a aVar : list) {
                if (aVar instanceof com.baidu.tieba.frs.j) {
                    ((com.baidu.tieba.frs.j) aVar).a(this.hFa);
                }
            }
        }
    }

    private void AP(String str) {
        if (this.aWf != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.aWf) {
                if (aVar instanceof com.baidu.tieba.a.f) {
                    ((com.baidu.tieba.a.f) aVar).AP(str);
                }
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.a.al
    public void a(com.baidu.tieba.frs.f fVar) {
        if (this.aWf != null && this.aWf.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.aWf) {
                if (aVar instanceof com.baidu.tieba.frs.j) {
                    ((com.baidu.tieba.frs.j) aVar).a(fVar);
                }
            }
        }
    }
}
