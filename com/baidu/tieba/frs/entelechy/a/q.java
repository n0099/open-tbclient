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
    private com.baidu.adp.widget.ListView.r fWB;
    private FrsFragment gpX;
    private final HashMap<Integer, bj> gwW;
    private FrsViewData gwX;
    private ac gwZ;
    private com.baidu.adp.widget.ListView.a gxa;
    private w gxb;
    private l gxc;
    private t gxd;
    private r gxe;
    private k gxf;
    private m gxg;
    private u gxh;
    private x gxi;
    private s gxj;
    private List<com.baidu.adp.widget.ListView.a> asE = new LinkedList();
    private boolean gwY = false;
    private final com.baidu.tieba.frs.f gnN = new com.baidu.tieba.frs.f();

    public q(FrsFragment frsFragment, com.baidu.adp.widget.ListView.r rVar, boolean z) {
        this.fWB = rVar;
        a(frsFragment, rVar);
        this.gwW = new HashMap<>();
        lO(z);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r5v29, resolved type: com.baidu.tieba.frs.FrsFragment */
    /* JADX WARN: Multi-variable type inference failed */
    public void a(FrsFragment frsFragment, com.baidu.adp.widget.ListView.r rVar) {
        this.gpX = frsFragment;
        this.gxa = com.baidu.tieba.frs.c.bDe().a(frsFragment.getPageContext(), com.baidu.tieba.tbadkCore.u.kfp, this.gpX.getUniqueId(), false);
        this.gxb = new w(frsFragment.getTbPageContext(), bj.cRm, this.gpX.getUniqueId());
        this.gxb.a(rVar);
        this.gxc = new l(frsFragment.getTbPageContext(), bj.cRn, this.gpX.getUniqueId());
        this.gxc.a(rVar);
        this.gxd = new t(frsFragment.getTbPageContext(), bj.cRp, this.gpX.getUniqueId());
        this.gxd.a(rVar);
        this.gxe = new r(frsFragment.getTbPageContext(), bj.cRq, this.gpX.getUniqueId());
        this.gxe.a(rVar);
        this.gxf = new k(frsFragment.getTbPageContext(), bj.cRs, this.gpX.getUniqueId());
        this.gxf.a(rVar);
        this.gxg = new m(frsFragment.getTbPageContext(), bj.cRt, this.gpX.getUniqueId());
        this.gxg.a(rVar);
        this.gxh = new u(frsFragment.getTbPageContext(), bj.cRL, this.gpX.getUniqueId());
        this.gxh.a(rVar);
        this.gxi = new x(frsFragment.getPageContext(), bj.cRy, this.gpX.getUniqueId());
        this.gxi.a(rVar);
        p pVar = new p(frsFragment.getPageContext(), bj.cRw, this.gpX.getUniqueId());
        pVar.a(rVar);
        v vVar = new v(frsFragment.getPageContext(), bj.cRC, this.gpX.getUniqueId());
        vVar.a(rVar);
        a aVar = new a(frsFragment.getPageContext(), bj.cRv, frsFragment.getUniqueId());
        aVar.a(rVar);
        aVar.pz(1);
        d dVar = new d(frsFragment.getPageContext(), bj.cRr, frsFragment.getUniqueId());
        dVar.a(rVar);
        b bVar = new b(frsFragment.getPageContext(), bj.cRE, this.gpX.getUniqueId());
        bVar.a(rVar);
        bVar.setInFrsAllThread(true);
        g gVar = new g(frsFragment.getPageContext(), bj.cRD, this.gpX.getUniqueId());
        gVar.a(rVar);
        gVar.setInFrsAllThread(true);
        h hVar = new h(frsFragment.getPageContext(), bj.cRF, this.gpX.getUniqueId());
        hVar.a(rVar);
        hVar.setInFrsAllThread(true);
        x xVar = new x(frsFragment.getPageContext(), bj.cRG, this.gpX.getUniqueId());
        xVar.a(rVar);
        o oVar = new o(frsFragment.getPageContext(), bj.cRP, this.gpX.getUniqueId());
        oVar.a(rVar);
        n nVar = new n(frsFragment.getPageContext(), bj.cRH, this.gpX.getUniqueId());
        nVar.a(rVar);
        this.gwZ = new ac(frsFragment.getPageContext(), com.baidu.tieba.tbadkCore.n.kfh, this.gpX.getUniqueId());
        this.gxj = new s(frsFragment.getPageContext(), bj.cRx, this.gpX.getUniqueId());
        this.gxj.a(rVar);
        com.baidu.adp.widget.ListView.a<? extends bi, ? extends v.a> a = com.baidu.tieba.frs.c.bDe().a(frsFragment.getPageContext(), this.gpX.getUniqueId(), true);
        com.baidu.adp.widget.ListView.a<? extends bj, ? extends v.a> b = com.baidu.tieba.frs.c.bDe().b(frsFragment.getPageContext(), bj.cTk, this.gpX.getUniqueId());
        com.baidu.tieba.frs.m mVar = new com.baidu.tieba.frs.m(frsFragment.getPageContext(), com.baidu.tieba.frs.n.gqY);
        j jVar = new j(frsFragment.getPageContext(), com.baidu.tieba.frs.q.grn);
        ab abVar = new ab(frsFragment.getPageContext(), com.baidu.tieba.frs.r.grs, this.gpX.getUniqueId());
        this.asE.add(this.gxa);
        this.asE.add(this.gxb);
        this.asE.add(this.gxc);
        this.asE.add(this.gxd);
        this.asE.add(this.gxe);
        this.asE.add(this.gxf);
        this.asE.add(this.gxg);
        this.asE.add(this.gxh);
        this.asE.add(this.gwZ);
        this.asE.add(pVar);
        this.asE.add(vVar);
        this.asE.add(aVar);
        this.asE.add(dVar);
        this.asE.add(bVar);
        this.asE.add(gVar);
        this.asE.add(hVar);
        this.asE.add(this.gxj);
        this.asE.add(this.gxi);
        this.asE.add(a);
        this.asE.add(b);
        this.asE.add(mVar);
        this.asE.add(jVar);
        this.asE.add(oVar);
        this.asE.add(nVar);
        this.asE.add(abVar);
        this.asE.add(xVar);
        com.baidu.tieba.InjectPlugin.b.b bVar2 = new com.baidu.tieba.InjectPlugin.b.b(this.gpX, 1);
        bVar2.setExtraData(this.asE);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_FEED_AD_PLUGIN_OPERATE, bVar2));
        cf(this.asE);
        rVar.addAdapters(this.asE);
        AbsDelegateAdapterList absDelegateAdapterList = new AbsDelegateAdapterList();
        CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_ADD_ADAPTER, absDelegateAdapterList);
        CustomMessage customMessage = new CustomMessage(CmdConfigCustom.CMD_FRS_ADD_ADAPTER);
        customMessage.setTag(this.gpX.getUniqueId());
        customResponsedMessage.setOrginalMessage(customMessage);
        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
        wO("page_frs");
        if (!absDelegateAdapterList.isEmpty()) {
            Iterator it = absDelegateAdapterList.iterator();
            while (it.hasNext()) {
                com.baidu.adp.widget.ListView.a aVar2 = (com.baidu.adp.widget.ListView.a) it.next();
                if (aVar2 instanceof com.baidu.tieba.frs.h) {
                    ((com.baidu.tieba.frs.h) aVar2).a(this.gpX.getPageContext(), this.gpX.getUniqueId());
                }
            }
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(absDelegateAdapterList);
            if (this.asE != null) {
                this.asE.addAll(arrayList);
            }
            if (this.fWB != null) {
                this.fWB.addAdapters(arrayList);
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
    public HashMap<Integer, bj> bGY() {
        return this.gwW;
    }

    @Override // com.baidu.tieba.frs.entelechy.a.af
    public void notifyDataSetChanged() {
        if (this.fWB.getListAdapter() != null) {
            this.fWB.getListAdapter().notifyDataSetChanged();
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.a.af
    public int bGZ() {
        if (this.gxa != null) {
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
    public void bHa() {
        if (this.asE != null && this.asE.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.asE) {
                if (aVar instanceof com.baidu.tieba.frs.h) {
                    ((com.baidu.tieba.frs.h) aVar).a(this.gpX.getPageContext(), this.gpX.getUniqueId());
                }
            }
            cf(this.asE);
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.a.af
    public List<com.baidu.adp.widget.ListView.m> getDatas() {
        if (this.fWB != null) {
            return this.fWB.getData();
        }
        return null;
    }

    @Override // com.baidu.tieba.frs.entelechy.a.af
    public int bHb() {
        if (this.gxa != null) {
            return R.id.frs_fortune_bag_item;
        }
        return 0;
    }

    @Override // com.baidu.tieba.frs.entelechy.a.af
    public int bHc() {
        if (this.gxa != null) {
            return R.id.frs_my_service_item;
        }
        return 0;
    }

    public void asL() {
        if (this.dataList != null) {
            this.fWB.setData(this.dataList);
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
            if (this.gxb != null) {
                this.gxb.setFromCDN(z);
            }
            if (this.gxc != null) {
                this.gxc.setFromCDN(z);
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
            if (this.gxi != null) {
                this.gxi.setFromCDN(z);
            }
            if (this.gxj != null) {
                this.gxj.setFromCDN(z);
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.a.af
    public void bHd() {
        List<com.baidu.adp.widget.ListView.m> data;
        if (this.fWB != null && this.fWB.getData() != null && this.fWB.getData().size() != 0 && (data = this.fWB.getData()) != null && data.size() != 0) {
            for (com.baidu.adp.widget.ListView.m mVar : data) {
                if (mVar instanceof bj) {
                    if (((bj) mVar).aCh() != 0) {
                        ((bj) mVar).aDh();
                    }
                } else if ((mVar instanceof bi) && ((bi) mVar).cRe.aCh() != 0) {
                    ((bi) mVar).cRe.aDh();
                }
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.a.af
    public void lO(boolean z) {
        if (this.gwY != z) {
            this.gwY = z;
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.a.af
    public void b(ArrayList<com.baidu.adp.widget.ListView.m> arrayList, FrsViewData frsViewData) {
        b(frsViewData);
        bFS();
        com.baidu.tieba.tbadkCore.s.o(arrayList, 1);
        am(arrayList);
        an(arrayList);
        ao(arrayList);
        Iterator<com.baidu.adp.widget.ListView.m> it = arrayList.iterator();
        while (it.hasNext()) {
            com.baidu.adp.widget.ListView.m next = it.next();
            if ((next instanceof bi) && ((bi) next).cRe.isTop()) {
                it.remove();
            }
        }
        this.fWB.setData(arrayList);
        this.gwX = frsViewData;
        bGw();
        bHf();
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
                if (this.gwW != null && !this.gwW.containsValue(mVar)) {
                    this.gwW.put(Integer.valueOf(i2), (bj) mVar);
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
                    if (!it.hasNext() || it.next().getType().getId() != bj.cRh.getId()) {
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
                bj bjVar = ((bi) mVar2).cRe;
                if (i == 0) {
                    bjVar.isFirstFloor = true;
                } else {
                    bjVar.isFirstFloor = false;
                }
                String aAf = bjVar.aAf();
                if (mVar instanceof com.baidu.tieba.frs.q) {
                    bjVar.needTopMargin = false;
                } else if (mVar != null && !c(mVar)) {
                    bjVar.needTopMargin = false;
                } else if ((mVar instanceof bi) && c(mVar) && !TextUtils.isEmpty(((bi) mVar).cRe.aAf())) {
                    bjVar.needTopMargin = true;
                } else if (c(mVar2) && !TextUtils.isEmpty(aAf)) {
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
        return type == bj.cRi || type == bj.cRx || type == bj.cRy || type == bj.cRG || type == bj.cRP;
    }

    private void bFS() {
        if (!com.baidu.tbadk.core.util.v.isEmpty(this.asE) && this.gpX != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.asE) {
                if (aVar instanceof com.baidu.tieba.frs.h) {
                    ((com.baidu.tieba.frs.h) aVar).a(this.gpX.getTbPageTag());
                }
            }
        }
    }

    private void bGw() {
        com.baidu.tieba.frs.d.b bGV;
        if (this.gwX != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.asE) {
                if ((aVar instanceof com.baidu.tieba.frs.d.d) && (bGV = ((com.baidu.tieba.frs.d.d) aVar).bGV()) != null) {
                    if (this.gwX.needLog == 1) {
                        bGV.gJk = true;
                    } else {
                        bGV.gJk = false;
                    }
                    if (this.gwX.getForum() != null) {
                        bGV.gJm = this.gwX.getForum().getId();
                    }
                    if (this.gpX != null && this.gpX.bDI() != null) {
                        bGV.gJl = this.gpX.bDI().bJn();
                    }
                }
            }
            bHe();
        }
    }

    private void bHe() {
        com.baidu.tieba.frs.d.b bVar = new com.baidu.tieba.frs.d.b();
        if (this.gwX.needLog == 1) {
            bVar.gJk = true;
        } else {
            bVar.gJk = false;
        }
        if (this.gwX.getForum() != null) {
            bVar.gJm = this.gwX.getForum().getId();
        }
        if (this.gpX != null && this.gpX.bDI() != null) {
            bVar.gJl = this.gpX.bDI().bJn();
        }
        if (com.baidu.tieba.frs.d.d.gwo != null) {
            bVar.gJn = com.baidu.tieba.frs.d.d.gwo.gJn;
            bVar.gJo = com.baidu.tieba.frs.d.d.gwo.gJo;
        }
        if (this.gpX != null) {
            com.baidu.tieba.frs.live.b bVar2 = new com.baidu.tieba.frs.live.b(bVar, this.gpX.getTbPageTag(), this.gpX.getUniqueId());
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

    private void bHf() {
        if (this.gwX != null && this.gwX.getForum() != null && !StringUtils.isNull(this.gwX.getForum().getId()) && this.gwZ != null) {
            this.gwZ.setForumId(this.gwX.getForum().getId());
        }
    }

    private void cf(List<com.baidu.adp.widget.ListView.a> list) {
        if (list != null) {
            for (com.baidu.adp.widget.ListView.a aVar : list) {
                if (aVar instanceof com.baidu.tieba.frs.h) {
                    ((com.baidu.tieba.frs.h) aVar).a(this.gnN);
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
