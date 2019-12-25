package com.baidu.tieba.frs.entelechy.a;

import android.text.TextUtils;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.v;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.data.bi;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.AbsDelegateAdapterList;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.tbadkCore.FrsViewData;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes6.dex */
public class q implements af {
    private ArrayList<com.baidu.adp.widget.ListView.m> dataList;
    private com.baidu.adp.widget.ListView.r fRq;
    private FrsFragment gkN;
    private final HashMap<Integer, bj> grM;
    private FrsViewData grN;
    private ac grP;
    private com.baidu.adp.widget.ListView.a grQ;
    private w grR;
    private l grS;
    private t grT;
    private r grU;
    private k grV;
    private m grW;
    private u grX;
    private x grY;
    private s grZ;
    private List<com.baidu.adp.widget.ListView.a> aoz = new LinkedList();
    private boolean grO = false;
    private final com.baidu.tieba.frs.f giD = new com.baidu.tieba.frs.f();

    public q(FrsFragment frsFragment, com.baidu.adp.widget.ListView.r rVar, boolean z) {
        this.fRq = rVar;
        a(frsFragment, rVar);
        this.grM = new HashMap<>();
        lA(z);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r5v29, resolved type: com.baidu.tieba.frs.FrsFragment */
    /* JADX WARN: Multi-variable type inference failed */
    public void a(FrsFragment frsFragment, com.baidu.adp.widget.ListView.r rVar) {
        this.gkN = frsFragment;
        this.grQ = com.baidu.tieba.frs.c.bAA().a(frsFragment.getPageContext(), com.baidu.tieba.tbadkCore.u.kaH, this.gkN.getUniqueId(), false);
        this.grR = new w(frsFragment.getTbPageContext(), bj.cMZ, this.gkN.getUniqueId());
        this.grR.a(rVar);
        this.grS = new l(frsFragment.getTbPageContext(), bj.cNa, this.gkN.getUniqueId());
        this.grS.a(rVar);
        this.grT = new t(frsFragment.getTbPageContext(), bj.cNc, this.gkN.getUniqueId());
        this.grT.a(rVar);
        this.grU = new r(frsFragment.getTbPageContext(), bj.cNd, this.gkN.getUniqueId());
        this.grU.a(rVar);
        this.grV = new k(frsFragment.getTbPageContext(), bj.cNf, this.gkN.getUniqueId());
        this.grV.a(rVar);
        this.grW = new m(frsFragment.getTbPageContext(), bj.cNg, this.gkN.getUniqueId());
        this.grW.a(rVar);
        this.grX = new u(frsFragment.getTbPageContext(), bj.cNy, this.gkN.getUniqueId());
        this.grX.a(rVar);
        this.grY = new x(frsFragment.getPageContext(), bj.cNl, this.gkN.getUniqueId());
        this.grY.a(rVar);
        p pVar = new p(frsFragment.getPageContext(), bj.cNj, this.gkN.getUniqueId());
        pVar.a(rVar);
        v vVar = new v(frsFragment.getPageContext(), bj.cNp, this.gkN.getUniqueId());
        vVar.a(rVar);
        a aVar = new a(frsFragment.getPageContext(), bj.cNi, frsFragment.getUniqueId());
        aVar.a(rVar);
        aVar.pm(1);
        d dVar = new d(frsFragment.getPageContext(), bj.cNe, frsFragment.getUniqueId());
        dVar.a(rVar);
        b bVar = new b(frsFragment.getPageContext(), bj.cNr, this.gkN.getUniqueId());
        bVar.a(rVar);
        bVar.setInFrsAllThread(true);
        g gVar = new g(frsFragment.getPageContext(), bj.cNq, this.gkN.getUniqueId());
        gVar.a(rVar);
        gVar.setInFrsAllThread(true);
        h hVar = new h(frsFragment.getPageContext(), bj.cNs, this.gkN.getUniqueId());
        hVar.a(rVar);
        hVar.setInFrsAllThread(true);
        x xVar = new x(frsFragment.getPageContext(), bj.cNt, this.gkN.getUniqueId());
        xVar.a(rVar);
        o oVar = new o(frsFragment.getPageContext(), bj.cNC, this.gkN.getUniqueId());
        oVar.a(rVar);
        n nVar = new n(frsFragment.getPageContext(), bj.cNu, this.gkN.getUniqueId());
        nVar.a(rVar);
        this.grP = new ac(frsFragment.getPageContext(), com.baidu.tieba.tbadkCore.n.kaz, this.gkN.getUniqueId());
        this.grZ = new s(frsFragment.getPageContext(), bj.cNk, this.gkN.getUniqueId());
        this.grZ.a(rVar);
        com.baidu.adp.widget.ListView.a<? extends bi, ? extends v.a> a = com.baidu.tieba.frs.c.bAA().a(frsFragment.getPageContext(), this.gkN.getUniqueId(), true);
        com.baidu.adp.widget.ListView.a<? extends bj, ? extends v.a> b = com.baidu.tieba.frs.c.bAA().b(frsFragment.getPageContext(), bj.cOY, this.gkN.getUniqueId());
        com.baidu.tieba.frs.m mVar = new com.baidu.tieba.frs.m(frsFragment.getPageContext(), com.baidu.tieba.frs.n.glO);
        j jVar = new j(frsFragment.getPageContext(), com.baidu.tieba.frs.q.gmd);
        ab abVar = new ab(frsFragment.getPageContext(), com.baidu.tieba.frs.r.gmi, this.gkN.getUniqueId());
        this.aoz.add(this.grQ);
        this.aoz.add(this.grR);
        this.aoz.add(this.grS);
        this.aoz.add(this.grT);
        this.aoz.add(this.grU);
        this.aoz.add(this.grV);
        this.aoz.add(this.grW);
        this.aoz.add(this.grX);
        this.aoz.add(this.grP);
        this.aoz.add(pVar);
        this.aoz.add(vVar);
        this.aoz.add(aVar);
        this.aoz.add(dVar);
        this.aoz.add(bVar);
        this.aoz.add(gVar);
        this.aoz.add(hVar);
        this.aoz.add(this.grZ);
        this.aoz.add(this.grY);
        this.aoz.add(a);
        this.aoz.add(b);
        this.aoz.add(mVar);
        this.aoz.add(jVar);
        this.aoz.add(oVar);
        this.aoz.add(nVar);
        this.aoz.add(abVar);
        this.aoz.add(xVar);
        com.baidu.tieba.InjectPlugin.b.b bVar2 = new com.baidu.tieba.InjectPlugin.b.b(this.gkN, 1);
        bVar2.setExtraData(this.aoz);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_FEED_AD_PLUGIN_OPERATE, bVar2));
        cj(this.aoz);
        rVar.addAdapters(this.aoz);
        AbsDelegateAdapterList absDelegateAdapterList = new AbsDelegateAdapterList();
        CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_ADD_ADAPTER, absDelegateAdapterList);
        CustomMessage customMessage = new CustomMessage(CmdConfigCustom.CMD_FRS_ADD_ADAPTER);
        customMessage.setTag(this.gkN.getUniqueId());
        customResponsedMessage.setOrginalMessage(customMessage);
        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
        wq("page_frs");
        if (!absDelegateAdapterList.isEmpty()) {
            Iterator it = absDelegateAdapterList.iterator();
            while (it.hasNext()) {
                com.baidu.adp.widget.ListView.a aVar2 = (com.baidu.adp.widget.ListView.a) it.next();
                if (aVar2 instanceof com.baidu.tieba.frs.h) {
                    ((com.baidu.tieba.frs.h) aVar2).a(this.gkN.getPageContext(), this.gkN.getUniqueId());
                }
            }
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(absDelegateAdapterList);
            if (this.aoz != null) {
                this.aoz.addAll(arrayList);
            }
            if (this.fRq != null) {
                this.fRq.addAdapters(arrayList);
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.a.af
    public void onDestory() {
        for (com.baidu.adp.widget.ListView.a aVar : this.aoz) {
            if (aVar instanceof com.baidu.tieba.frs.h) {
                ((com.baidu.tieba.frs.h) aVar).release();
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.a.af
    public HashMap<Integer, bj> bEu() {
        return this.grM;
    }

    @Override // com.baidu.tieba.frs.entelechy.a.af
    public void notifyDataSetChanged() {
        if (this.fRq.getListAdapter() != null) {
            this.fRq.getListAdapter().notifyDataSetChanged();
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.a.af
    public int bEv() {
        if (this.grQ != null) {
            return R.id.frs_bawu_center;
        }
        return 0;
    }

    @Override // com.baidu.tieba.frs.entelechy.a.af
    public boolean p(BdUniqueId bdUniqueId) {
        if (bdUniqueId == null) {
            return false;
        }
        for (com.baidu.adp.widget.ListView.a aVar : this.aoz) {
            if (aVar != null && aVar.getType() == bdUniqueId) {
                return true;
            }
        }
        return false;
    }

    @Override // com.baidu.tieba.frs.entelechy.a.af
    public void a(com.baidu.adp.widget.ListView.s sVar) {
        if (this.aoz != null && this.aoz.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.aoz) {
                if (aVar instanceof com.baidu.tieba.frs.h) {
                    ((com.baidu.tieba.frs.h) aVar).a(sVar);
                } else if ((aVar instanceof s) || (aVar instanceof x)) {
                    aVar.a(sVar);
                }
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.a.af
    public void setForumName(String str) {
        if (this.aoz != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.aoz) {
                if (aVar instanceof com.baidu.tieba.card.x) {
                    ((com.baidu.tieba.card.x) aVar).setForumName(str);
                }
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v1, resolved type: com.baidu.tieba.frs.FrsFragment */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.baidu.tieba.frs.entelechy.a.af
    public void bEw() {
        if (this.aoz != null && this.aoz.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.aoz) {
                if (aVar instanceof com.baidu.tieba.frs.h) {
                    ((com.baidu.tieba.frs.h) aVar).a(this.gkN.getPageContext(), this.gkN.getUniqueId());
                }
            }
            cj(this.aoz);
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.a.af
    public List<com.baidu.adp.widget.ListView.m> getDatas() {
        if (this.fRq != null) {
            return this.fRq.getData();
        }
        return null;
    }

    @Override // com.baidu.tieba.frs.entelechy.a.af
    public int bEx() {
        if (this.grQ != null) {
            return R.id.frs_fortune_bag_item;
        }
        return 0;
    }

    @Override // com.baidu.tieba.frs.entelechy.a.af
    public int bEy() {
        if (this.grQ != null) {
            return R.id.frs_my_service_item;
        }
        return 0;
    }

    public void aqe() {
        if (this.dataList != null) {
            this.fRq.setData(this.dataList);
        }
        notifyDataSetChanged();
    }

    @Override // com.baidu.tieba.frs.entelechy.a.af
    public void setFromCDN(boolean z) {
        if (this.aoz != null && this.aoz.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.aoz) {
                if (aVar instanceof com.baidu.tieba.frs.h) {
                    ((com.baidu.tieba.frs.h) aVar).setFromCDN(z);
                }
            }
            if (this.grR != null) {
                this.grR.setFromCDN(z);
            }
            if (this.grS != null) {
                this.grS.setFromCDN(z);
            }
            if (this.grT != null) {
                this.grT.setFromCDN(z);
            }
            if (this.grU != null) {
                this.grU.setFromCDN(z);
            }
            if (this.grV != null) {
                this.grV.setFromCDN(z);
            }
            if (this.grW != null) {
                this.grW.setFromCDN(z);
            }
            if (this.grY != null) {
                this.grY.setFromCDN(z);
            }
            if (this.grZ != null) {
                this.grZ.setFromCDN(z);
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.a.af
    public void bEz() {
        List<com.baidu.adp.widget.ListView.m> data;
        if (this.fRq != null && this.fRq.getData() != null && this.fRq.getData().size() != 0 && (data = this.fRq.getData()) != null && data.size() != 0) {
            for (com.baidu.adp.widget.ListView.m mVar : data) {
                if (mVar instanceof bj) {
                    if (((bj) mVar).azz() != 0) {
                        ((bj) mVar).aAA();
                    }
                } else if ((mVar instanceof bi) && ((bi) mVar).cMR.azz() != 0) {
                    ((bi) mVar).cMR.aAA();
                }
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.a.af
    public void lA(boolean z) {
        if (this.grO != z) {
            this.grO = z;
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.a.af
    public void b(ArrayList<com.baidu.adp.widget.ListView.m> arrayList, FrsViewData frsViewData) {
        b(frsViewData);
        bDo();
        com.baidu.tieba.tbadkCore.s.n(arrayList, 1);
        am(arrayList);
        an(arrayList);
        ao(arrayList);
        Iterator<com.baidu.adp.widget.ListView.m> it = arrayList.iterator();
        while (it.hasNext()) {
            com.baidu.adp.widget.ListView.m next = it.next();
            if ((next instanceof bi) && ((bi) next).cMR.isTop()) {
                it.remove();
            }
        }
        this.fRq.setData(arrayList);
        this.grN = frsViewData;
        bDS();
        bEB();
        this.dataList = arrayList;
    }

    public void b(FrsViewData frsViewData) {
        if (this.aoz != null && this.aoz.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.aoz) {
                if (aVar instanceof com.baidu.tieba.frs.h) {
                    ((com.baidu.tieba.frs.h) aVar).b(frsViewData);
                }
            }
        }
    }

    private ArrayList<Integer> am(ArrayList<com.baidu.adp.widget.ListView.m> arrayList) {
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
            com.baidu.adp.widget.ListView.m mVar = arrayList.get(i2);
            if (mVar instanceof AdvertAppInfo) {
                arrayList2.add(Integer.valueOf(i2));
                if (this.grM != null && !this.grM.containsValue(mVar)) {
                    this.grM.put(Integer.valueOf(i2), (bj) mVar);
                }
            }
            i = i2 + 1;
        }
    }

    private void an(ArrayList<com.baidu.adp.widget.ListView.m> arrayList) {
        int i;
        if (this.aoz != null && this.aoz.size() != 0) {
            int i2 = 0;
            if (arrayList == null || arrayList.size() <= 0) {
                i = 0;
            } else {
                Iterator<com.baidu.adp.widget.ListView.m> it = arrayList.iterator();
                while (true) {
                    i = i2;
                    if (!it.hasNext() || it.next().getType().getId() != bj.cMU.getId()) {
                        break;
                    }
                    i2 = i + 1;
                }
            }
            for (com.baidu.adp.widget.ListView.a aVar : this.aoz) {
                if (aVar instanceof com.baidu.tieba.frs.h) {
                    ((com.baidu.tieba.frs.h) aVar).sp(i);
                }
            }
        }
    }

    private void ao(ArrayList<com.baidu.adp.widget.ListView.m> arrayList) {
        int count = com.baidu.tbadk.core.util.v.getCount(arrayList);
        for (int i = 0; i < count; i++) {
            com.baidu.adp.widget.ListView.m mVar = (com.baidu.adp.widget.ListView.m) com.baidu.tbadk.core.util.v.getItem(arrayList, i - 1);
            com.baidu.adp.widget.ListView.m mVar2 = (com.baidu.adp.widget.ListView.m) com.baidu.tbadk.core.util.v.getItem(arrayList, i);
            if (mVar2 instanceof bi) {
                bj bjVar = ((bi) mVar2).cMR;
                if (i == 0) {
                    bjVar.isFirstFloor = true;
                } else {
                    bjVar.isFirstFloor = false;
                }
                String axy = bjVar.axy();
                if (mVar instanceof com.baidu.tieba.frs.q) {
                    bjVar.needTopMargin = false;
                } else if (mVar != null && !c(mVar)) {
                    bjVar.needTopMargin = false;
                } else if ((mVar instanceof bi) && c(mVar) && !TextUtils.isEmpty(((bi) mVar).cMR.axy())) {
                    bjVar.needTopMargin = true;
                } else if (c(mVar2) && !TextUtils.isEmpty(axy)) {
                    bjVar.needTopMargin = true;
                } else {
                    bjVar.needTopMargin = false;
                }
            }
        }
    }

    private boolean c(com.baidu.adp.widget.ListView.m mVar) {
        if (mVar == null) {
            return false;
        }
        BdUniqueId type = mVar.getType();
        return type == bj.cMV || type == bj.cNk || type == bj.cNl || type == bj.cNt || type == bj.cNC;
    }

    private void bDo() {
        if (!com.baidu.tbadk.core.util.v.isEmpty(this.aoz) && this.gkN != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.aoz) {
                if (aVar instanceof com.baidu.tieba.frs.h) {
                    ((com.baidu.tieba.frs.h) aVar).a(this.gkN.getTbPageTag());
                }
            }
        }
    }

    private void bDS() {
        com.baidu.tieba.frs.d.b bEr;
        if (this.grN != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.aoz) {
                if ((aVar instanceof com.baidu.tieba.frs.d.d) && (bEr = ((com.baidu.tieba.frs.d.d) aVar).bEr()) != null) {
                    if (this.grN.needLog == 1) {
                        bEr.gDW = true;
                    } else {
                        bEr.gDW = false;
                    }
                    if (this.grN.getForum() != null) {
                        bEr.gDY = this.grN.getForum().getId();
                    }
                    if (this.gkN != null && this.gkN.bBd() != null) {
                        bEr.gDX = this.gkN.bBd().bGJ();
                    }
                }
            }
            bEA();
        }
    }

    private void bEA() {
        com.baidu.tieba.frs.d.b bVar = new com.baidu.tieba.frs.d.b();
        if (this.grN.needLog == 1) {
            bVar.gDW = true;
        } else {
            bVar.gDW = false;
        }
        if (this.grN.getForum() != null) {
            bVar.gDY = this.grN.getForum().getId();
        }
        if (this.gkN != null && this.gkN.bBd() != null) {
            bVar.gDX = this.gkN.bBd().bGJ();
        }
        if (com.baidu.tieba.frs.d.d.gre != null) {
            bVar.gDZ = com.baidu.tieba.frs.d.d.gre.gDZ;
            bVar.gEa = com.baidu.tieba.frs.d.d.gre.gEa;
        }
        if (this.gkN != null) {
            com.baidu.tieba.frs.live.b bVar2 = new com.baidu.tieba.frs.live.b(bVar, this.gkN.getTbPageTag(), this.gkN.getUniqueId());
            CustomMessageTask customMessageTask = new CustomMessageTask(CmdConfigCustom.CMD_FRS_LIVE_CARD_CLICK, bVar2);
            customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
            MessageManager.getInstance().registerTask(customMessageTask);
            CustomMessageTask customMessageTask2 = new CustomMessageTask(CmdConfigCustom.CMD_FRS_LIVE_CARD_SHOW, bVar2);
            customMessageTask2.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
            MessageManager.getInstance().registerTask(customMessageTask2);
            CustomMessageTask customMessageTask3 = new CustomMessageTask(CmdConfigCustom.CMD_FRS_LIVE_USER_CLICK, bVar2);
            customMessageTask3.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
            MessageManager.getInstance().registerTask(customMessageTask3);
            CustomMessageTask customMessageTask4 = new CustomMessageTask(CmdConfigCustom.CMD_FRS_LIVE_VIDEO_CLICK, bVar2);
            customMessageTask4.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
            MessageManager.getInstance().registerTask(customMessageTask4);
        }
    }

    private void bEB() {
        if (this.grN != null && this.grN.getForum() != null && !StringUtils.isNull(this.grN.getForum().getId()) && this.grP != null) {
            this.grP.setForumId(this.grN.getForum().getId());
        }
    }

    private void cj(List<com.baidu.adp.widget.ListView.a> list) {
        if (list != null) {
            for (com.baidu.adp.widget.ListView.a aVar : list) {
                if (aVar instanceof com.baidu.tieba.frs.h) {
                    ((com.baidu.tieba.frs.h) aVar).a(this.giD);
                }
            }
        }
    }

    private void wq(String str) {
        if (this.aoz != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.aoz) {
                if (aVar instanceof com.baidu.tieba.a.f) {
                    ((com.baidu.tieba.a.f) aVar).wq(str);
                }
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.a.af
    public void a(com.baidu.tieba.frs.d dVar) {
        if (this.aoz != null && this.aoz.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.aoz) {
                if (aVar instanceof com.baidu.tieba.frs.h) {
                    ((com.baidu.tieba.frs.h) aVar).a(dVar);
                }
            }
        }
    }
}
