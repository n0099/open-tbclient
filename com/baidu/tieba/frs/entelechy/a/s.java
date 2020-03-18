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
/* loaded from: classes9.dex */
public class s implements ai {
    private ArrayList<com.baidu.adp.widget.ListView.m> dataList;
    private com.baidu.adp.widget.ListView.r fXy;
    private FrsFragment gqW;
    private final HashMap<Integer, bj> gxV;
    private FrsViewData gxW;
    private ae gxY;
    private com.baidu.adp.widget.ListView.a gxZ;
    private y gya;
    private n gyb;
    private v gyc;
    private t gyd;
    private m gye;
    private o gyf;
    private w gyg;
    private z gyh;
    private u gyi;
    private List<com.baidu.adp.widget.ListView.a> asP = new LinkedList();
    private boolean gxX = false;
    private final com.baidu.tieba.frs.f goM = new com.baidu.tieba.frs.f();

    public s(FrsFragment frsFragment, com.baidu.adp.widget.ListView.r rVar, boolean z) {
        this.fXy = rVar;
        a(frsFragment, rVar);
        this.gxV = new HashMap<>();
        lT(z);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r5v29, resolved type: com.baidu.tieba.frs.FrsFragment */
    /* JADX WARN: Multi-variable type inference failed */
    public void a(FrsFragment frsFragment, com.baidu.adp.widget.ListView.r rVar) {
        this.gqW = frsFragment;
        this.gxZ = com.baidu.tieba.frs.c.bDp().a(frsFragment.getPageContext(), com.baidu.tieba.tbadkCore.v.khf, this.gqW.getUniqueId(), false);
        this.gya = new y(frsFragment.getTbPageContext(), bj.cRB, this.gqW.getUniqueId());
        this.gya.a(rVar);
        this.gyb = new n(frsFragment.getTbPageContext(), bj.cRC, this.gqW.getUniqueId());
        this.gyb.a(rVar);
        this.gyc = new v(frsFragment.getTbPageContext(), bj.cRE, this.gqW.getUniqueId());
        this.gyc.a(rVar);
        this.gyd = new t(frsFragment.getTbPageContext(), bj.cRF, this.gqW.getUniqueId());
        this.gyd.a(rVar);
        this.gye = new m(frsFragment.getTbPageContext(), bj.cRH, this.gqW.getUniqueId());
        this.gye.a(rVar);
        this.gyf = new o(frsFragment.getTbPageContext(), bj.cRI, this.gqW.getUniqueId());
        this.gyf.a(rVar);
        this.gyg = new w(frsFragment.getTbPageContext(), bj.cSa, this.gqW.getUniqueId());
        this.gyg.a(rVar);
        this.gyh = new z(frsFragment.getPageContext(), bj.cRN, this.gqW.getUniqueId());
        this.gyh.a(rVar);
        r rVar2 = new r(frsFragment.getPageContext(), bj.cRL, this.gqW.getUniqueId());
        rVar2.a(rVar);
        x xVar = new x(frsFragment.getPageContext(), bj.cRR, this.gqW.getUniqueId());
        xVar.a(rVar);
        a aVar = new a(frsFragment.getPageContext(), bj.cRK, frsFragment.getUniqueId());
        aVar.a(rVar);
        aVar.pB(1);
        e eVar = new e(frsFragment.getPageContext(), bj.cRG, frsFragment.getUniqueId());
        eVar.a(rVar);
        b bVar = new b(frsFragment.getPageContext(), bj.cRT, this.gqW.getUniqueId());
        bVar.a(rVar);
        bVar.setInFrsAllThread(true);
        h hVar = new h(frsFragment.getPageContext(), bj.cRS, this.gqW.getUniqueId());
        hVar.a(rVar);
        hVar.setInFrsAllThread(true);
        i iVar = new i(frsFragment.getPageContext(), bj.cRU, this.gqW.getUniqueId());
        iVar.a(rVar);
        iVar.setInFrsAllThread(true);
        z zVar = new z(frsFragment.getPageContext(), bj.cRV, this.gqW.getUniqueId());
        zVar.a(rVar);
        q qVar = new q(frsFragment.getPageContext(), bj.cSe, this.gqW.getUniqueId());
        qVar.a(rVar);
        p pVar = new p(frsFragment.getPageContext(), bj.cRW, this.gqW.getUniqueId());
        pVar.a(rVar);
        this.gxY = new ae(frsFragment.getPageContext(), com.baidu.tieba.tbadkCore.o.kgX, this.gqW.getUniqueId());
        this.gyi = new u(frsFragment.getPageContext(), bj.cRM, this.gqW.getUniqueId());
        this.gyi.a(rVar);
        com.baidu.adp.widget.ListView.a<? extends bi, ? extends v.a> a = com.baidu.tieba.frs.c.bDp().a(frsFragment.getPageContext(), this.gqW.getUniqueId(), true);
        com.baidu.adp.widget.ListView.a<? extends bj, ? extends v.a> b = com.baidu.tieba.frs.c.bDp().b(frsFragment.getPageContext(), bj.cTz, this.gqW.getUniqueId());
        com.baidu.tieba.frs.n nVar = new com.baidu.tieba.frs.n(frsFragment.getPageContext(), com.baidu.tieba.frs.o.grX);
        l lVar = new l(frsFragment.getPageContext(), com.baidu.tieba.frs.r.gsm);
        ad adVar = new ad(frsFragment.getPageContext(), com.baidu.tieba.frs.s.gsr, this.gqW.getUniqueId());
        this.asP.add(this.gxZ);
        this.asP.add(this.gya);
        this.asP.add(this.gyb);
        this.asP.add(this.gyc);
        this.asP.add(this.gyd);
        this.asP.add(this.gye);
        this.asP.add(this.gyf);
        this.asP.add(this.gyg);
        this.asP.add(this.gxY);
        this.asP.add(rVar2);
        this.asP.add(xVar);
        this.asP.add(aVar);
        this.asP.add(eVar);
        this.asP.add(bVar);
        this.asP.add(hVar);
        this.asP.add(iVar);
        this.asP.add(this.gyi);
        this.asP.add(this.gyh);
        this.asP.add(a);
        this.asP.add(b);
        this.asP.add(nVar);
        this.asP.add(lVar);
        this.asP.add(qVar);
        this.asP.add(pVar);
        this.asP.add(adVar);
        this.asP.add(zVar);
        com.baidu.tieba.InjectPlugin.b.b bVar2 = new com.baidu.tieba.InjectPlugin.b.b(this.gqW, 1);
        bVar2.setExtraData(this.asP);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_FEED_AD_PLUGIN_OPERATE, bVar2));
        cf(this.asP);
        rVar.addAdapters(this.asP);
        AbsDelegateAdapterList absDelegateAdapterList = new AbsDelegateAdapterList();
        CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_ADD_ADAPTER, absDelegateAdapterList);
        CustomMessage customMessage = new CustomMessage(CmdConfigCustom.CMD_FRS_ADD_ADAPTER);
        customMessage.setTag(this.gqW.getUniqueId());
        customResponsedMessage.setOrginalMessage(customMessage);
        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
        wP("page_frs");
        if (!absDelegateAdapterList.isEmpty()) {
            Iterator it = absDelegateAdapterList.iterator();
            while (it.hasNext()) {
                com.baidu.adp.widget.ListView.a aVar2 = (com.baidu.adp.widget.ListView.a) it.next();
                if (aVar2 instanceof com.baidu.tieba.frs.h) {
                    ((com.baidu.tieba.frs.h) aVar2).a(this.gqW.getPageContext(), this.gqW.getUniqueId());
                }
            }
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(absDelegateAdapterList);
            if (this.asP != null) {
                this.asP.addAll(arrayList);
            }
            if (this.fXy != null) {
                this.fXy.addAdapters(arrayList);
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.a.ai
    public void onDestory() {
        for (com.baidu.adp.widget.ListView.a aVar : this.asP) {
            if (aVar instanceof com.baidu.tieba.frs.h) {
                ((com.baidu.tieba.frs.h) aVar).release();
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.a.ai
    public HashMap<Integer, bj> bHq() {
        return this.gxV;
    }

    @Override // com.baidu.tieba.frs.entelechy.a.ai
    public void notifyDataSetChanged() {
        if (this.fXy.getListAdapter() != null) {
            this.fXy.getListAdapter().notifyDataSetChanged();
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.a.ai
    public int bHr() {
        if (this.gxZ != null) {
            return R.id.frs_bawu_center;
        }
        return 0;
    }

    @Override // com.baidu.tieba.frs.entelechy.a.ai
    public boolean p(BdUniqueId bdUniqueId) {
        if (bdUniqueId == null) {
            return false;
        }
        for (com.baidu.adp.widget.ListView.a aVar : this.asP) {
            if (aVar != null && aVar.getType() == bdUniqueId) {
                return true;
            }
        }
        return false;
    }

    @Override // com.baidu.tieba.frs.entelechy.a.ai
    public void a(com.baidu.adp.widget.ListView.s sVar) {
        if (this.asP != null && this.asP.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.asP) {
                if (aVar instanceof com.baidu.tieba.frs.h) {
                    ((com.baidu.tieba.frs.h) aVar).a(sVar);
                } else if ((aVar instanceof u) || (aVar instanceof z)) {
                    aVar.a(sVar);
                }
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.a.ai
    public void setForumName(String str) {
        if (this.asP != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.asP) {
                if (aVar instanceof com.baidu.tieba.card.x) {
                    ((com.baidu.tieba.card.x) aVar).setForumName(str);
                }
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v1, resolved type: com.baidu.tieba.frs.FrsFragment */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.baidu.tieba.frs.entelechy.a.ai
    public void bHs() {
        if (this.asP != null && this.asP.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.asP) {
                if (aVar instanceof com.baidu.tieba.frs.h) {
                    ((com.baidu.tieba.frs.h) aVar).a(this.gqW.getPageContext(), this.gqW.getUniqueId());
                }
            }
            cf(this.asP);
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.a.ai
    public List<com.baidu.adp.widget.ListView.m> getDatas() {
        if (this.fXy != null) {
            return this.fXy.getData();
        }
        return null;
    }

    @Override // com.baidu.tieba.frs.entelechy.a.ai
    public int bHt() {
        if (this.gxZ != null) {
            return R.id.frs_fortune_bag_item;
        }
        return 0;
    }

    @Override // com.baidu.tieba.frs.entelechy.a.ai
    public int bHu() {
        if (this.gxZ != null) {
            return R.id.frs_my_service_item;
        }
        return 0;
    }

    public void asQ() {
        if (this.dataList != null) {
            this.fXy.setData(this.dataList);
        }
        notifyDataSetChanged();
    }

    @Override // com.baidu.tieba.frs.entelechy.a.ai
    public void setFromCDN(boolean z) {
        if (this.asP != null && this.asP.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.asP) {
                if (aVar instanceof com.baidu.tieba.frs.h) {
                    ((com.baidu.tieba.frs.h) aVar).setFromCDN(z);
                }
            }
            if (this.gya != null) {
                this.gya.setFromCDN(z);
            }
            if (this.gyb != null) {
                this.gyb.setFromCDN(z);
            }
            if (this.gyc != null) {
                this.gyc.setFromCDN(z);
            }
            if (this.gyd != null) {
                this.gyd.setFromCDN(z);
            }
            if (this.gye != null) {
                this.gye.setFromCDN(z);
            }
            if (this.gyf != null) {
                this.gyf.setFromCDN(z);
            }
            if (this.gyh != null) {
                this.gyh.setFromCDN(z);
            }
            if (this.gyi != null) {
                this.gyi.setFromCDN(z);
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.a.ai
    public void bHv() {
        List<com.baidu.adp.widget.ListView.m> data;
        if (this.fXy != null && this.fXy.getData() != null && this.fXy.getData().size() != 0 && (data = this.fXy.getData()) != null && data.size() != 0) {
            for (com.baidu.adp.widget.ListView.m mVar : data) {
                if (mVar instanceof bj) {
                    if (((bj) mVar).aCm() != 0) {
                        ((bj) mVar).aDm();
                    }
                } else if ((mVar instanceof bi) && ((bi) mVar).cRt.aCm() != 0) {
                    ((bi) mVar).cRt.aDm();
                }
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.a.ai
    public void lT(boolean z) {
        if (this.gxX != z) {
            this.gxX = z;
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.a.ai
    public void b(ArrayList<com.baidu.adp.widget.ListView.m> arrayList, FrsViewData frsViewData) {
        b(frsViewData);
        bGg();
        com.baidu.tieba.tbadkCore.t.n(arrayList, 1);
        am(arrayList);
        an(arrayList);
        ao(arrayList);
        Iterator<com.baidu.adp.widget.ListView.m> it = arrayList.iterator();
        while (it.hasNext()) {
            com.baidu.adp.widget.ListView.m next = it.next();
            if ((next instanceof bi) && ((bi) next).cRt.isTop()) {
                it.remove();
            }
        }
        this.fXy.setData(arrayList);
        this.gxW = frsViewData;
        bGL();
        bHx();
        this.dataList = arrayList;
    }

    public void b(FrsViewData frsViewData) {
        if (this.asP != null && this.asP.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.asP) {
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
                if (this.gxV != null && !this.gxV.containsValue(mVar)) {
                    this.gxV.put(Integer.valueOf(i2), (bj) mVar);
                }
            }
            i = i2 + 1;
        }
    }

    private void an(ArrayList<com.baidu.adp.widget.ListView.m> arrayList) {
        int i;
        if (this.asP != null && this.asP.size() != 0) {
            int i2 = 0;
            if (arrayList == null || arrayList.size() <= 0) {
                i = 0;
            } else {
                Iterator<com.baidu.adp.widget.ListView.m> it = arrayList.iterator();
                while (true) {
                    i = i2;
                    if (!it.hasNext() || it.next().getType().getId() != bj.cRw.getId()) {
                        break;
                    }
                    i2 = i + 1;
                }
            }
            for (com.baidu.adp.widget.ListView.a aVar : this.asP) {
                if (aVar instanceof com.baidu.tieba.frs.h) {
                    ((com.baidu.tieba.frs.h) aVar).sC(i);
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
                bj bjVar = ((bi) mVar2).cRt;
                if (i == 0) {
                    bjVar.isFirstFloor = true;
                } else {
                    bjVar.isFirstFloor = false;
                }
                String aAk = bjVar.aAk();
                if (mVar instanceof com.baidu.tieba.frs.r) {
                    bjVar.needTopMargin = false;
                } else if (mVar != null && !c(mVar)) {
                    bjVar.needTopMargin = false;
                } else if ((mVar instanceof bi) && c(mVar) && !TextUtils.isEmpty(((bi) mVar).cRt.aAk())) {
                    bjVar.needTopMargin = true;
                } else if (c(mVar2) && !TextUtils.isEmpty(aAk)) {
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
        return type == bj.cRx || type == bj.cRM || type == bj.cRN || type == bj.cRV || type == bj.cSe;
    }

    private void bGg() {
        if (!com.baidu.tbadk.core.util.v.isEmpty(this.asP) && this.gqW != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.asP) {
                if (aVar instanceof com.baidu.tieba.frs.h) {
                    ((com.baidu.tieba.frs.h) aVar).a(this.gqW.getTbPageTag());
                }
            }
        }
    }

    private void bGL() {
        com.baidu.tieba.frs.d.b bHn;
        if (this.gxW != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.asP) {
                if ((aVar instanceof com.baidu.tieba.frs.d.d) && (bHn = ((com.baidu.tieba.frs.d.d) aVar).bHn()) != null) {
                    if (this.gxW.needLog == 1) {
                        bHn.gKD = true;
                    } else {
                        bHn.gKD = false;
                    }
                    if (this.gxW.getForum() != null) {
                        bHn.gKF = this.gxW.getForum().getId();
                    }
                    if (this.gqW != null && this.gqW.bDT() != null) {
                        bHn.gKE = this.gqW.bDT().bJD();
                    }
                }
            }
            bHw();
        }
    }

    private void bHw() {
        com.baidu.tieba.frs.d.b bVar = new com.baidu.tieba.frs.d.b();
        if (this.gxW.needLog == 1) {
            bVar.gKD = true;
        } else {
            bVar.gKD = false;
        }
        if (this.gxW.getForum() != null) {
            bVar.gKF = this.gxW.getForum().getId();
        }
        if (this.gqW != null && this.gqW.bDT() != null) {
            bVar.gKE = this.gqW.bDT().bJD();
        }
        if (com.baidu.tieba.frs.d.d.gxl != null) {
            bVar.gKG = com.baidu.tieba.frs.d.d.gxl.gKG;
            bVar.gKH = com.baidu.tieba.frs.d.d.gxl.gKH;
        }
        if (this.gqW != null) {
            com.baidu.tieba.frs.live.b bVar2 = new com.baidu.tieba.frs.live.b(bVar, this.gqW.getTbPageTag(), this.gqW.getUniqueId());
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

    private void bHx() {
        if (this.gxW != null && this.gxW.getForum() != null && !StringUtils.isNull(this.gxW.getForum().getId()) && this.gxY != null) {
            this.gxY.setForumId(this.gxW.getForum().getId());
        }
    }

    private void cf(List<com.baidu.adp.widget.ListView.a> list) {
        if (list != null) {
            for (com.baidu.adp.widget.ListView.a aVar : list) {
                if (aVar instanceof com.baidu.tieba.frs.h) {
                    ((com.baidu.tieba.frs.h) aVar).a(this.goM);
                }
            }
        }
    }

    private void wP(String str) {
        if (this.asP != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.asP) {
                if (aVar instanceof com.baidu.tieba.a.f) {
                    ((com.baidu.tieba.a.f) aVar).wP(str);
                }
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.a.ai
    public void a(com.baidu.tieba.frs.d dVar) {
        if (this.asP != null && this.asP.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.asP) {
                if (aVar instanceof com.baidu.tieba.frs.h) {
                    ((com.baidu.tieba.frs.h) aVar).a(dVar);
                }
            }
        }
    }
}
