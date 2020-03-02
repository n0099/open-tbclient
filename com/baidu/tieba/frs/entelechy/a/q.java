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
public class q implements af {
    private ArrayList<com.baidu.adp.widget.ListView.m> dataList;
    private com.baidu.adp.widget.ListView.r fWD;
    private FrsFragment gpZ;
    private final HashMap<Integer, bj> gwY;
    private FrsViewData gwZ;
    private ac gxb;
    private com.baidu.adp.widget.ListView.a gxc;
    private w gxd;
    private l gxe;
    private t gxf;
    private r gxg;
    private k gxh;
    private m gxi;
    private u gxj;
    private x gxk;
    private s gxl;
    private List<com.baidu.adp.widget.ListView.a> asE = new LinkedList();
    private boolean gxa = false;
    private final com.baidu.tieba.frs.f gnP = new com.baidu.tieba.frs.f();

    public q(FrsFragment frsFragment, com.baidu.adp.widget.ListView.r rVar, boolean z) {
        this.fWD = rVar;
        a(frsFragment, rVar);
        this.gwY = new HashMap<>();
        lO(z);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r5v29, resolved type: com.baidu.tieba.frs.FrsFragment */
    /* JADX WARN: Multi-variable type inference failed */
    public void a(FrsFragment frsFragment, com.baidu.adp.widget.ListView.r rVar) {
        this.gpZ = frsFragment;
        this.gxc = com.baidu.tieba.frs.c.bDg().a(frsFragment.getPageContext(), com.baidu.tieba.tbadkCore.u.kfr, this.gpZ.getUniqueId(), false);
        this.gxd = new w(frsFragment.getTbPageContext(), bj.cRn, this.gpZ.getUniqueId());
        this.gxd.a(rVar);
        this.gxe = new l(frsFragment.getTbPageContext(), bj.cRo, this.gpZ.getUniqueId());
        this.gxe.a(rVar);
        this.gxf = new t(frsFragment.getTbPageContext(), bj.cRq, this.gpZ.getUniqueId());
        this.gxf.a(rVar);
        this.gxg = new r(frsFragment.getTbPageContext(), bj.cRr, this.gpZ.getUniqueId());
        this.gxg.a(rVar);
        this.gxh = new k(frsFragment.getTbPageContext(), bj.cRt, this.gpZ.getUniqueId());
        this.gxh.a(rVar);
        this.gxi = new m(frsFragment.getTbPageContext(), bj.cRu, this.gpZ.getUniqueId());
        this.gxi.a(rVar);
        this.gxj = new u(frsFragment.getTbPageContext(), bj.cRM, this.gpZ.getUniqueId());
        this.gxj.a(rVar);
        this.gxk = new x(frsFragment.getPageContext(), bj.cRz, this.gpZ.getUniqueId());
        this.gxk.a(rVar);
        p pVar = new p(frsFragment.getPageContext(), bj.cRx, this.gpZ.getUniqueId());
        pVar.a(rVar);
        v vVar = new v(frsFragment.getPageContext(), bj.cRD, this.gpZ.getUniqueId());
        vVar.a(rVar);
        a aVar = new a(frsFragment.getPageContext(), bj.cRw, frsFragment.getUniqueId());
        aVar.a(rVar);
        aVar.pz(1);
        d dVar = new d(frsFragment.getPageContext(), bj.cRs, frsFragment.getUniqueId());
        dVar.a(rVar);
        b bVar = new b(frsFragment.getPageContext(), bj.cRF, this.gpZ.getUniqueId());
        bVar.a(rVar);
        bVar.setInFrsAllThread(true);
        g gVar = new g(frsFragment.getPageContext(), bj.cRE, this.gpZ.getUniqueId());
        gVar.a(rVar);
        gVar.setInFrsAllThread(true);
        h hVar = new h(frsFragment.getPageContext(), bj.cRG, this.gpZ.getUniqueId());
        hVar.a(rVar);
        hVar.setInFrsAllThread(true);
        x xVar = new x(frsFragment.getPageContext(), bj.cRH, this.gpZ.getUniqueId());
        xVar.a(rVar);
        o oVar = new o(frsFragment.getPageContext(), bj.cRQ, this.gpZ.getUniqueId());
        oVar.a(rVar);
        n nVar = new n(frsFragment.getPageContext(), bj.cRI, this.gpZ.getUniqueId());
        nVar.a(rVar);
        this.gxb = new ac(frsFragment.getPageContext(), com.baidu.tieba.tbadkCore.n.kfj, this.gpZ.getUniqueId());
        this.gxl = new s(frsFragment.getPageContext(), bj.cRy, this.gpZ.getUniqueId());
        this.gxl.a(rVar);
        com.baidu.adp.widget.ListView.a<? extends bi, ? extends v.a> a = com.baidu.tieba.frs.c.bDg().a(frsFragment.getPageContext(), this.gpZ.getUniqueId(), true);
        com.baidu.adp.widget.ListView.a<? extends bj, ? extends v.a> b = com.baidu.tieba.frs.c.bDg().b(frsFragment.getPageContext(), bj.cTl, this.gpZ.getUniqueId());
        com.baidu.tieba.frs.m mVar = new com.baidu.tieba.frs.m(frsFragment.getPageContext(), com.baidu.tieba.frs.n.gra);
        j jVar = new j(frsFragment.getPageContext(), com.baidu.tieba.frs.q.grp);
        ab abVar = new ab(frsFragment.getPageContext(), com.baidu.tieba.frs.r.gru, this.gpZ.getUniqueId());
        this.asE.add(this.gxc);
        this.asE.add(this.gxd);
        this.asE.add(this.gxe);
        this.asE.add(this.gxf);
        this.asE.add(this.gxg);
        this.asE.add(this.gxh);
        this.asE.add(this.gxi);
        this.asE.add(this.gxj);
        this.asE.add(this.gxb);
        this.asE.add(pVar);
        this.asE.add(vVar);
        this.asE.add(aVar);
        this.asE.add(dVar);
        this.asE.add(bVar);
        this.asE.add(gVar);
        this.asE.add(hVar);
        this.asE.add(this.gxl);
        this.asE.add(this.gxk);
        this.asE.add(a);
        this.asE.add(b);
        this.asE.add(mVar);
        this.asE.add(jVar);
        this.asE.add(oVar);
        this.asE.add(nVar);
        this.asE.add(abVar);
        this.asE.add(xVar);
        com.baidu.tieba.InjectPlugin.b.b bVar2 = new com.baidu.tieba.InjectPlugin.b.b(this.gpZ, 1);
        bVar2.setExtraData(this.asE);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_FEED_AD_PLUGIN_OPERATE, bVar2));
        cf(this.asE);
        rVar.addAdapters(this.asE);
        AbsDelegateAdapterList absDelegateAdapterList = new AbsDelegateAdapterList();
        CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_ADD_ADAPTER, absDelegateAdapterList);
        CustomMessage customMessage = new CustomMessage(CmdConfigCustom.CMD_FRS_ADD_ADAPTER);
        customMessage.setTag(this.gpZ.getUniqueId());
        customResponsedMessage.setOrginalMessage(customMessage);
        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
        wO("page_frs");
        if (!absDelegateAdapterList.isEmpty()) {
            Iterator it = absDelegateAdapterList.iterator();
            while (it.hasNext()) {
                com.baidu.adp.widget.ListView.a aVar2 = (com.baidu.adp.widget.ListView.a) it.next();
                if (aVar2 instanceof com.baidu.tieba.frs.h) {
                    ((com.baidu.tieba.frs.h) aVar2).a(this.gpZ.getPageContext(), this.gpZ.getUniqueId());
                }
            }
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(absDelegateAdapterList);
            if (this.asE != null) {
                this.asE.addAll(arrayList);
            }
            if (this.fWD != null) {
                this.fWD.addAdapters(arrayList);
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.a.af
    public void onDestory() {
        for (com.baidu.adp.widget.ListView.a aVar : this.asE) {
            if (aVar instanceof com.baidu.tieba.frs.h) {
                ((com.baidu.tieba.frs.h) aVar).release();
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.a.af
    public HashMap<Integer, bj> bHa() {
        return this.gwY;
    }

    @Override // com.baidu.tieba.frs.entelechy.a.af
    public void notifyDataSetChanged() {
        if (this.fWD.getListAdapter() != null) {
            this.fWD.getListAdapter().notifyDataSetChanged();
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.a.af
    public int bHb() {
        if (this.gxc != null) {
            return R.id.frs_bawu_center;
        }
        return 0;
    }

    @Override // com.baidu.tieba.frs.entelechy.a.af
    public boolean p(BdUniqueId bdUniqueId) {
        if (bdUniqueId == null) {
            return false;
        }
        for (com.baidu.adp.widget.ListView.a aVar : this.asE) {
            if (aVar != null && aVar.getType() == bdUniqueId) {
                return true;
            }
        }
        return false;
    }

    @Override // com.baidu.tieba.frs.entelechy.a.af
    public void a(com.baidu.adp.widget.ListView.s sVar) {
        if (this.asE != null && this.asE.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.asE) {
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
        if (this.asE != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.asE) {
                if (aVar instanceof com.baidu.tieba.card.x) {
                    ((com.baidu.tieba.card.x) aVar).setForumName(str);
                }
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v1, resolved type: com.baidu.tieba.frs.FrsFragment */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.baidu.tieba.frs.entelechy.a.af
    public void bHc() {
        if (this.asE != null && this.asE.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.asE) {
                if (aVar instanceof com.baidu.tieba.frs.h) {
                    ((com.baidu.tieba.frs.h) aVar).a(this.gpZ.getPageContext(), this.gpZ.getUniqueId());
                }
            }
            cf(this.asE);
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.a.af
    public List<com.baidu.adp.widget.ListView.m> getDatas() {
        if (this.fWD != null) {
            return this.fWD.getData();
        }
        return null;
    }

    @Override // com.baidu.tieba.frs.entelechy.a.af
    public int bHd() {
        if (this.gxc != null) {
            return R.id.frs_fortune_bag_item;
        }
        return 0;
    }

    @Override // com.baidu.tieba.frs.entelechy.a.af
    public int bHe() {
        if (this.gxc != null) {
            return R.id.frs_my_service_item;
        }
        return 0;
    }

    public void asN() {
        if (this.dataList != null) {
            this.fWD.setData(this.dataList);
        }
        notifyDataSetChanged();
    }

    @Override // com.baidu.tieba.frs.entelechy.a.af
    public void setFromCDN(boolean z) {
        if (this.asE != null && this.asE.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.asE) {
                if (aVar instanceof com.baidu.tieba.frs.h) {
                    ((com.baidu.tieba.frs.h) aVar).setFromCDN(z);
                }
            }
            if (this.gxd != null) {
                this.gxd.setFromCDN(z);
            }
            if (this.gxe != null) {
                this.gxe.setFromCDN(z);
            }
            if (this.gxf != null) {
                this.gxf.setFromCDN(z);
            }
            if (this.gxg != null) {
                this.gxg.setFromCDN(z);
            }
            if (this.gxh != null) {
                this.gxh.setFromCDN(z);
            }
            if (this.gxi != null) {
                this.gxi.setFromCDN(z);
            }
            if (this.gxk != null) {
                this.gxk.setFromCDN(z);
            }
            if (this.gxl != null) {
                this.gxl.setFromCDN(z);
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.a.af
    public void bHf() {
        List<com.baidu.adp.widget.ListView.m> data;
        if (this.fWD != null && this.fWD.getData() != null && this.fWD.getData().size() != 0 && (data = this.fWD.getData()) != null && data.size() != 0) {
            for (com.baidu.adp.widget.ListView.m mVar : data) {
                if (mVar instanceof bj) {
                    if (((bj) mVar).aCj() != 0) {
                        ((bj) mVar).aDj();
                    }
                } else if ((mVar instanceof bi) && ((bi) mVar).cRf.aCj() != 0) {
                    ((bi) mVar).cRf.aDj();
                }
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.a.af
    public void lO(boolean z) {
        if (this.gxa != z) {
            this.gxa = z;
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.a.af
    public void b(ArrayList<com.baidu.adp.widget.ListView.m> arrayList, FrsViewData frsViewData) {
        b(frsViewData);
        bFU();
        com.baidu.tieba.tbadkCore.s.o(arrayList, 1);
        am(arrayList);
        an(arrayList);
        ao(arrayList);
        Iterator<com.baidu.adp.widget.ListView.m> it = arrayList.iterator();
        while (it.hasNext()) {
            com.baidu.adp.widget.ListView.m next = it.next();
            if ((next instanceof bi) && ((bi) next).cRf.isTop()) {
                it.remove();
            }
        }
        this.fWD.setData(arrayList);
        this.gwZ = frsViewData;
        bGy();
        bHh();
        this.dataList = arrayList;
    }

    public void b(FrsViewData frsViewData) {
        if (this.asE != null && this.asE.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.asE) {
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
                if (this.gwY != null && !this.gwY.containsValue(mVar)) {
                    this.gwY.put(Integer.valueOf(i2), (bj) mVar);
                }
            }
            i = i2 + 1;
        }
    }

    private void an(ArrayList<com.baidu.adp.widget.ListView.m> arrayList) {
        int i;
        if (this.asE != null && this.asE.size() != 0) {
            int i2 = 0;
            if (arrayList == null || arrayList.size() <= 0) {
                i = 0;
            } else {
                Iterator<com.baidu.adp.widget.ListView.m> it = arrayList.iterator();
                while (true) {
                    i = i2;
                    if (!it.hasNext() || it.next().getType().getId() != bj.cRi.getId()) {
                        break;
                    }
                    i2 = i + 1;
                }
            }
            for (com.baidu.adp.widget.ListView.a aVar : this.asE) {
                if (aVar instanceof com.baidu.tieba.frs.h) {
                    ((com.baidu.tieba.frs.h) aVar).sA(i);
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
                bj bjVar = ((bi) mVar2).cRf;
                if (i == 0) {
                    bjVar.isFirstFloor = true;
                } else {
                    bjVar.isFirstFloor = false;
                }
                String aAh = bjVar.aAh();
                if (mVar instanceof com.baidu.tieba.frs.q) {
                    bjVar.needTopMargin = false;
                } else if (mVar != null && !c(mVar)) {
                    bjVar.needTopMargin = false;
                } else if ((mVar instanceof bi) && c(mVar) && !TextUtils.isEmpty(((bi) mVar).cRf.aAh())) {
                    bjVar.needTopMargin = true;
                } else if (c(mVar2) && !TextUtils.isEmpty(aAh)) {
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
        return type == bj.cRj || type == bj.cRy || type == bj.cRz || type == bj.cRH || type == bj.cRQ;
    }

    private void bFU() {
        if (!com.baidu.tbadk.core.util.v.isEmpty(this.asE) && this.gpZ != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.asE) {
                if (aVar instanceof com.baidu.tieba.frs.h) {
                    ((com.baidu.tieba.frs.h) aVar).a(this.gpZ.getTbPageTag());
                }
            }
        }
    }

    private void bGy() {
        com.baidu.tieba.frs.d.b bGX;
        if (this.gwZ != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.asE) {
                if ((aVar instanceof com.baidu.tieba.frs.d.d) && (bGX = ((com.baidu.tieba.frs.d.d) aVar).bGX()) != null) {
                    if (this.gwZ.needLog == 1) {
                        bGX.gJm = true;
                    } else {
                        bGX.gJm = false;
                    }
                    if (this.gwZ.getForum() != null) {
                        bGX.gJo = this.gwZ.getForum().getId();
                    }
                    if (this.gpZ != null && this.gpZ.bDK() != null) {
                        bGX.gJn = this.gpZ.bDK().bJp();
                    }
                }
            }
            bHg();
        }
    }

    private void bHg() {
        com.baidu.tieba.frs.d.b bVar = new com.baidu.tieba.frs.d.b();
        if (this.gwZ.needLog == 1) {
            bVar.gJm = true;
        } else {
            bVar.gJm = false;
        }
        if (this.gwZ.getForum() != null) {
            bVar.gJo = this.gwZ.getForum().getId();
        }
        if (this.gpZ != null && this.gpZ.bDK() != null) {
            bVar.gJn = this.gpZ.bDK().bJp();
        }
        if (com.baidu.tieba.frs.d.d.gwq != null) {
            bVar.gJp = com.baidu.tieba.frs.d.d.gwq.gJp;
            bVar.gJq = com.baidu.tieba.frs.d.d.gwq.gJq;
        }
        if (this.gpZ != null) {
            com.baidu.tieba.frs.live.b bVar2 = new com.baidu.tieba.frs.live.b(bVar, this.gpZ.getTbPageTag(), this.gpZ.getUniqueId());
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

    private void bHh() {
        if (this.gwZ != null && this.gwZ.getForum() != null && !StringUtils.isNull(this.gwZ.getForum().getId()) && this.gxb != null) {
            this.gxb.setForumId(this.gwZ.getForum().getId());
        }
    }

    private void cf(List<com.baidu.adp.widget.ListView.a> list) {
        if (list != null) {
            for (com.baidu.adp.widget.ListView.a aVar : list) {
                if (aVar instanceof com.baidu.tieba.frs.h) {
                    ((com.baidu.tieba.frs.h) aVar).a(this.gnP);
                }
            }
        }
    }

    private void wO(String str) {
        if (this.asE != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.asE) {
                if (aVar instanceof com.baidu.tieba.a.f) {
                    ((com.baidu.tieba.a.f) aVar).wO(str);
                }
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.a.af
    public void a(com.baidu.tieba.frs.d dVar) {
        if (this.asE != null && this.asE.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.asE) {
                if (aVar instanceof com.baidu.tieba.frs.h) {
                    ((com.baidu.tieba.frs.h) aVar).a(dVar);
                }
            }
        }
    }
}
