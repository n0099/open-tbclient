package com.baidu.tieba.frs.entelechy.a;

import android.text.TextUtils;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.aa;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.data.bk;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.AbsDelegateAdapterList;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.tbadkCore.FrsViewData;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes9.dex */
public class s implements ai {
    private ArrayList<com.baidu.adp.widget.ListView.o> dataList;
    private com.baidu.adp.widget.ListView.t gTb;
    private FrsFragment hpm;
    private y hwA;
    private n hwB;
    private v hwC;
    private t hwD;
    private m hwE;
    private o hwF;
    private w hwG;
    private z hwH;
    private u hwI;
    private final HashMap<Integer, bk> hwv;
    private FrsViewData hww;
    private ae hwy;
    private com.baidu.adp.widget.ListView.a hwz;
    private List<com.baidu.adp.widget.ListView.a> aSj = new LinkedList();
    private boolean hwx = false;
    private final com.baidu.tieba.frs.f hmU = new com.baidu.tieba.frs.f();

    public s(FrsFragment frsFragment, com.baidu.adp.widget.ListView.t tVar, boolean z) {
        this.gTb = tVar;
        a(frsFragment, tVar);
        this.hwv = new HashMap<>();
        ns(z);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r5v29, resolved type: com.baidu.tieba.frs.FrsFragment */
    /* JADX WARN: Multi-variable type inference failed */
    public void a(FrsFragment frsFragment, com.baidu.adp.widget.ListView.t tVar) {
        this.hpm = frsFragment;
        this.hwz = com.baidu.tieba.frs.c.bUj().a(frsFragment.getPageContext(), com.baidu.tieba.tbadkCore.v.lkN, this.hpm.getUniqueId(), false);
        this.hwA = new y(frsFragment.getTbPageContext(), bk.dEI, this.hpm.getUniqueId());
        this.hwA.b(tVar);
        this.hwB = new n(frsFragment.getTbPageContext(), bk.dEJ, this.hpm.getUniqueId());
        this.hwB.b(tVar);
        this.hwC = new v(frsFragment.getTbPageContext(), bk.dEL, this.hpm.getUniqueId());
        this.hwC.b(tVar);
        this.hwD = new t(frsFragment.getTbPageContext(), bk.dEM, this.hpm.getUniqueId());
        this.hwD.b(tVar);
        this.hwE = new m(frsFragment.getTbPageContext(), bk.dEO, this.hpm.getUniqueId());
        this.hwE.b(tVar);
        this.hwF = new o(frsFragment.getTbPageContext(), bk.dEP, this.hpm.getUniqueId());
        this.hwF.b(tVar);
        this.hwG = new w(frsFragment.getTbPageContext(), bk.dFi, this.hpm.getUniqueId());
        this.hwG.b(tVar);
        this.hwH = new z(frsFragment.getPageContext(), bk.dEV, this.hpm.getUniqueId());
        this.hwH.b(tVar);
        r rVar = new r(frsFragment.getPageContext(), bk.dET, this.hpm.getUniqueId());
        rVar.b(tVar);
        x xVar = new x(frsFragment.getPageContext(), bk.dEZ, this.hpm.getUniqueId());
        xVar.b(tVar);
        a aVar = new a(frsFragment.getPageContext(), bk.dER, frsFragment.getUniqueId());
        aVar.b(tVar);
        aVar.qy(1);
        e eVar = new e(frsFragment.getPageContext(), bk.dEN, frsFragment.getUniqueId());
        eVar.b(tVar);
        b bVar = new b(frsFragment.getPageContext(), bk.dFb, this.hpm.getUniqueId());
        bVar.b(tVar);
        bVar.setInFrsAllThread(true);
        h hVar = new h(frsFragment.getPageContext(), bk.dFa, this.hpm.getUniqueId());
        hVar.b(tVar);
        hVar.setInFrsAllThread(true);
        i iVar = new i(frsFragment.getPageContext(), bk.dFc, this.hpm.getUniqueId());
        iVar.b(tVar);
        iVar.setInFrsAllThread(true);
        z zVar = new z(frsFragment.getPageContext(), bk.dFd, this.hpm.getUniqueId());
        zVar.b(tVar);
        q qVar = new q(frsFragment.getPageContext(), bk.dFm, this.hpm.getUniqueId());
        qVar.b(tVar);
        p pVar = new p(frsFragment.getPageContext(), bk.dFe, this.hpm.getUniqueId());
        pVar.b(tVar);
        this.hwy = new ae(frsFragment.getPageContext(), com.baidu.tieba.tbadkCore.o.lkF, this.hpm.getUniqueId());
        this.hwI = new u(frsFragment.getPageContext(), bk.dEU, this.hpm.getUniqueId());
        this.hwI.b(tVar);
        com.baidu.adp.widget.ListView.a<? extends bj, ? extends aa.a> a = com.baidu.tieba.frs.c.bUj().a(frsFragment.getPageContext(), this.hpm.getUniqueId(), true);
        com.baidu.adp.widget.ListView.a<? extends bk, ? extends aa.a> b = com.baidu.tieba.frs.c.bUj().b(frsFragment.getPageContext(), bk.dGH, this.hpm.getUniqueId());
        com.baidu.tieba.frs.o oVar = new com.baidu.tieba.frs.o(frsFragment.getPageContext(), com.baidu.tieba.frs.p.hqo);
        l lVar = new l(frsFragment.getPageContext(), com.baidu.tieba.frs.t.hqD);
        ad adVar = new ad(frsFragment.getPageContext(), com.baidu.tieba.frs.u.hqI, this.hpm.getUniqueId());
        this.aSj.add(this.hwz);
        this.aSj.add(this.hwA);
        this.aSj.add(this.hwB);
        this.aSj.add(this.hwC);
        this.aSj.add(this.hwD);
        this.aSj.add(this.hwE);
        this.aSj.add(this.hwF);
        this.aSj.add(this.hwG);
        this.aSj.add(this.hwy);
        this.aSj.add(rVar);
        this.aSj.add(xVar);
        this.aSj.add(aVar);
        this.aSj.add(eVar);
        this.aSj.add(bVar);
        this.aSj.add(hVar);
        this.aSj.add(iVar);
        this.aSj.add(this.hwI);
        this.aSj.add(this.hwH);
        this.aSj.add(a);
        this.aSj.add(b);
        this.aSj.add(oVar);
        this.aSj.add(lVar);
        this.aSj.add(qVar);
        this.aSj.add(pVar);
        this.aSj.add(adVar);
        this.aSj.add(zVar);
        com.baidu.tieba.InjectPlugin.b.b bVar2 = new com.baidu.tieba.InjectPlugin.b.b(this.hpm, 1);
        bVar2.setExtraData(this.aSj);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_FEED_AD_PLUGIN_OPERATE, bVar2));
        co(this.aSj);
        tVar.addAdapters(this.aSj);
        AbsDelegateAdapterList absDelegateAdapterList = new AbsDelegateAdapterList();
        CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_ADD_ADAPTER, absDelegateAdapterList);
        CustomMessage customMessage = new CustomMessage(CmdConfigCustom.CMD_FRS_ADD_ADAPTER);
        customMessage.setTag(this.hpm.getUniqueId());
        customResponsedMessage.setOrginalMessage(customMessage);
        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
        zL("page_frs");
        if (!absDelegateAdapterList.isEmpty()) {
            Iterator it = absDelegateAdapterList.iterator();
            while (it.hasNext()) {
                com.baidu.adp.widget.ListView.a aVar2 = (com.baidu.adp.widget.ListView.a) it.next();
                if (aVar2 instanceof com.baidu.tieba.frs.h) {
                    ((com.baidu.tieba.frs.h) aVar2).a(this.hpm.getPageContext(), this.hpm.getUniqueId());
                }
            }
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(absDelegateAdapterList);
            if (this.aSj != null) {
                this.aSj.addAll(arrayList);
            }
            if (this.gTb != null) {
                this.gTb.addAdapters(arrayList);
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.a.ai
    public void onDestory() {
        for (com.baidu.adp.widget.ListView.a aVar : this.aSj) {
            if (aVar instanceof com.baidu.tieba.frs.h) {
                ((com.baidu.tieba.frs.h) aVar).release();
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.a.ai
    public HashMap<Integer, bk> bYp() {
        return this.hwv;
    }

    @Override // com.baidu.tieba.frs.entelechy.a.ai
    public void notifyDataSetChanged() {
        if (this.gTb.getListAdapter() != null) {
            this.gTb.getListAdapter().notifyDataSetChanged();
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.a.ai
    public int bYq() {
        if (this.hwz != null) {
            return R.id.frs_bawu_center;
        }
        return 0;
    }

    @Override // com.baidu.tieba.frs.entelechy.a.ai
    public boolean r(BdUniqueId bdUniqueId) {
        if (bdUniqueId == null) {
            return false;
        }
        for (com.baidu.adp.widget.ListView.a aVar : this.aSj) {
            if (aVar != null && aVar.getType() == bdUniqueId) {
                return true;
            }
        }
        return false;
    }

    @Override // com.baidu.tieba.frs.entelechy.a.ai
    public void a(com.baidu.adp.widget.ListView.x xVar) {
        if (this.aSj != null && this.aSj.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.aSj) {
                if (aVar instanceof com.baidu.tieba.frs.h) {
                    ((com.baidu.tieba.frs.h) aVar).a(xVar);
                } else if ((aVar instanceof u) || (aVar instanceof z)) {
                    aVar.a(xVar);
                }
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.a.ai
    public void setForumName(String str) {
        if (this.aSj != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.aSj) {
                if (aVar instanceof com.baidu.tieba.card.y) {
                    ((com.baidu.tieba.card.y) aVar).setForumName(str);
                }
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v1, resolved type: com.baidu.tieba.frs.FrsFragment */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.baidu.tieba.frs.entelechy.a.ai
    public void bYr() {
        if (this.aSj != null && this.aSj.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.aSj) {
                if (aVar instanceof com.baidu.tieba.frs.h) {
                    ((com.baidu.tieba.frs.h) aVar).a(this.hpm.getPageContext(), this.hpm.getUniqueId());
                }
            }
            co(this.aSj);
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.a.ai
    public List<com.baidu.adp.widget.ListView.o> getDatas() {
        if (this.gTb != null) {
            return this.gTb.getData();
        }
        return null;
    }

    @Override // com.baidu.tieba.frs.entelechy.a.ai
    public int bYs() {
        if (this.hwz != null) {
            return R.id.frs_fortune_bag_item;
        }
        return 0;
    }

    @Override // com.baidu.tieba.frs.entelechy.a.ai
    public int bYt() {
        if (this.hwz != null) {
            return R.id.frs_my_service_item;
        }
        return 0;
    }

    public void aES() {
        if (this.dataList != null) {
            this.gTb.setData(this.dataList);
        }
        notifyDataSetChanged();
    }

    @Override // com.baidu.tieba.frs.entelechy.a.ai
    public void setFromCDN(boolean z) {
        if (this.aSj != null && this.aSj.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.aSj) {
                if (aVar instanceof com.baidu.tieba.frs.h) {
                    ((com.baidu.tieba.frs.h) aVar).setFromCDN(z);
                }
            }
            if (this.hwA != null) {
                this.hwA.setFromCDN(z);
            }
            if (this.hwB != null) {
                this.hwB.setFromCDN(z);
            }
            if (this.hwC != null) {
                this.hwC.setFromCDN(z);
            }
            if (this.hwD != null) {
                this.hwD.setFromCDN(z);
            }
            if (this.hwE != null) {
                this.hwE.setFromCDN(z);
            }
            if (this.hwF != null) {
                this.hwF.setFromCDN(z);
            }
            if (this.hwH != null) {
                this.hwH.setFromCDN(z);
            }
            if (this.hwI != null) {
                this.hwI.setFromCDN(z);
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.a.ai
    public void bYu() {
        List<com.baidu.adp.widget.ListView.o> data;
        if (this.gTb != null && this.gTb.getData() != null && this.gTb.getData().size() != 0 && (data = this.gTb.getData()) != null && data.size() != 0) {
            for (com.baidu.adp.widget.ListView.o oVar : data) {
                if (oVar instanceof bk) {
                    if (((bk) oVar).aQs() != 0) {
                        ((bk) oVar).aRw();
                    }
                } else if ((oVar instanceof bj) && ((bj) oVar).dEA.aQs() != 0) {
                    ((bj) oVar).dEA.aRw();
                }
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.a.ai
    public void ns(boolean z) {
        if (this.hwx != z) {
            this.hwx = z;
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.a.ai
    public void b(ArrayList<com.baidu.adp.widget.ListView.o> arrayList, FrsViewData frsViewData) {
        b(frsViewData);
        bXf();
        com.baidu.tieba.tbadkCore.t.s(arrayList, 1);
        ao(arrayList);
        ap(arrayList);
        aq(arrayList);
        Iterator<com.baidu.adp.widget.ListView.o> it = arrayList.iterator();
        while (it.hasNext()) {
            com.baidu.adp.widget.ListView.o next = it.next();
            if ((next instanceof bj) && ((bj) next).dEA.isTop()) {
                it.remove();
            }
        }
        this.gTb.setData(arrayList);
        this.hww = frsViewData;
        bXJ();
        bYv();
        this.dataList = arrayList;
    }

    public void b(FrsViewData frsViewData) {
        if (this.aSj != null && this.aSj.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.aSj) {
                if (aVar instanceof com.baidu.tieba.frs.h) {
                    ((com.baidu.tieba.frs.h) aVar).b(frsViewData);
                }
            }
        }
    }

    private ArrayList<Integer> ao(ArrayList<com.baidu.adp.widget.ListView.o> arrayList) {
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
            com.baidu.adp.widget.ListView.o oVar = arrayList.get(i2);
            if (oVar instanceof AdvertAppInfo) {
                arrayList2.add(Integer.valueOf(i2));
                if (this.hwv != null && !this.hwv.containsValue(oVar)) {
                    this.hwv.put(Integer.valueOf(i2), (bk) oVar);
                }
            }
            i = i2 + 1;
        }
    }

    private void ap(ArrayList<com.baidu.adp.widget.ListView.o> arrayList) {
        int i;
        if (this.aSj != null && this.aSj.size() != 0) {
            int i2 = 0;
            if (arrayList == null || arrayList.size() <= 0) {
                i = 0;
            } else {
                Iterator<com.baidu.adp.widget.ListView.o> it = arrayList.iterator();
                while (true) {
                    i = i2;
                    if (!it.hasNext() || it.next().getType().getId() != bk.dED.getId()) {
                        break;
                    }
                    i2 = i + 1;
                }
            }
            for (com.baidu.adp.widget.ListView.a aVar : this.aSj) {
                if (aVar instanceof com.baidu.tieba.frs.h) {
                    ((com.baidu.tieba.frs.h) aVar).tG(i);
                }
            }
        }
    }

    private void aq(ArrayList<com.baidu.adp.widget.ListView.o> arrayList) {
        int count = com.baidu.tbadk.core.util.v.getCount(arrayList);
        for (int i = 0; i < count; i++) {
            com.baidu.adp.widget.ListView.o oVar = (com.baidu.adp.widget.ListView.o) com.baidu.tbadk.core.util.v.getItem(arrayList, i - 1);
            com.baidu.adp.widget.ListView.o oVar2 = (com.baidu.adp.widget.ListView.o) com.baidu.tbadk.core.util.v.getItem(arrayList, i);
            if (oVar2 instanceof bj) {
                bk bkVar = ((bj) oVar2).dEA;
                if (i == 0) {
                    bkVar.isFirstFloor = true;
                } else {
                    bkVar.isFirstFloor = false;
                }
                String aOj = bkVar.aOj();
                if (oVar instanceof com.baidu.tieba.frs.t) {
                    bkVar.needTopMargin = false;
                } else if (oVar != null && !c(oVar)) {
                    bkVar.needTopMargin = false;
                } else if ((oVar instanceof bj) && c(oVar) && !TextUtils.isEmpty(((bj) oVar).dEA.aOj())) {
                    bkVar.needTopMargin = true;
                } else if (c(oVar2) && !TextUtils.isEmpty(aOj)) {
                    bkVar.needTopMargin = true;
                } else {
                    bkVar.needTopMargin = false;
                }
            }
        }
    }

    private boolean c(com.baidu.adp.widget.ListView.o oVar) {
        if (oVar == null) {
            return false;
        }
        BdUniqueId type = oVar.getType();
        return type == bk.dEE || type == bk.dEU || type == bk.dEV || type == bk.dFd || type == bk.dFm;
    }

    private void bXf() {
        if (!com.baidu.tbadk.core.util.v.isEmpty(this.aSj) && this.hpm != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.aSj) {
                if (aVar instanceof com.baidu.tieba.frs.h) {
                    ((com.baidu.tieba.frs.h) aVar).a(this.hpm.getTbPageTag());
                }
            }
        }
    }

    private void bXJ() {
        com.baidu.tieba.frs.d.b statisticMetaData;
        if (this.hww != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.aSj) {
                if ((aVar instanceof com.baidu.tieba.frs.d.d) && (statisticMetaData = ((com.baidu.tieba.frs.d.d) aVar).getStatisticMetaData()) != null) {
                    if (this.hww.needLog == 1) {
                        statisticMetaData.hJA = true;
                    } else {
                        statisticMetaData.hJA = false;
                    }
                    if (this.hww.getForum() != null) {
                        statisticMetaData.hJC = this.hww.getForum().getId();
                    }
                    if (this.hpm != null && this.hpm.bUO() != null) {
                        int caD = this.hpm.bUO().caD();
                        if (caD == -1) {
                            caD = this.hpm.bUO().caE();
                        }
                        statisticMetaData.hJB = caD;
                    }
                }
            }
        }
    }

    private void bYv() {
        if (this.hww != null && this.hww.getForum() != null && !StringUtils.isNull(this.hww.getForum().getId()) && this.hwy != null) {
            this.hwy.setForumId(this.hww.getForum().getId());
        }
    }

    private void co(List<com.baidu.adp.widget.ListView.a> list) {
        if (list != null) {
            for (com.baidu.adp.widget.ListView.a aVar : list) {
                if (aVar instanceof com.baidu.tieba.frs.h) {
                    ((com.baidu.tieba.frs.h) aVar).a(this.hmU);
                }
            }
        }
    }

    private void zL(String str) {
        if (this.aSj != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.aSj) {
                if (aVar instanceof com.baidu.tieba.a.f) {
                    ((com.baidu.tieba.a.f) aVar).zL(str);
                }
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.a.ai
    public void a(com.baidu.tieba.frs.d dVar) {
        if (this.aSj != null && this.aSj.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.aSj) {
                if (aVar instanceof com.baidu.tieba.frs.h) {
                    ((com.baidu.tieba.frs.h) aVar).a(dVar);
                }
            }
        }
    }
}
