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
    private com.baidu.adp.widget.ListView.r fWQ;
    private FrsFragment gqm;
    private final HashMap<Integer, bj> gxk;
    private FrsViewData gxl;
    private ac gxn;
    private com.baidu.adp.widget.ListView.a gxo;
    private w gxp;
    private l gxq;
    private t gxr;
    private r gxs;
    private k gxt;
    private m gxu;
    private u gxv;
    private x gxw;
    private s gxx;
    private List<com.baidu.adp.widget.ListView.a> asF = new LinkedList();
    private boolean gxm = false;
    private final com.baidu.tieba.frs.f goc = new com.baidu.tieba.frs.f();

    public q(FrsFragment frsFragment, com.baidu.adp.widget.ListView.r rVar, boolean z) {
        this.fWQ = rVar;
        a(frsFragment, rVar);
        this.gxk = new HashMap<>();
        lO(z);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r5v29, resolved type: com.baidu.tieba.frs.FrsFragment */
    /* JADX WARN: Multi-variable type inference failed */
    public void a(FrsFragment frsFragment, com.baidu.adp.widget.ListView.r rVar) {
        this.gqm = frsFragment;
        this.gxo = com.baidu.tieba.frs.c.bDh().a(frsFragment.getPageContext(), com.baidu.tieba.tbadkCore.u.kfD, this.gqm.getUniqueId(), false);
        this.gxp = new w(frsFragment.getTbPageContext(), bj.cRo, this.gqm.getUniqueId());
        this.gxp.a(rVar);
        this.gxq = new l(frsFragment.getTbPageContext(), bj.cRp, this.gqm.getUniqueId());
        this.gxq.a(rVar);
        this.gxr = new t(frsFragment.getTbPageContext(), bj.cRr, this.gqm.getUniqueId());
        this.gxr.a(rVar);
        this.gxs = new r(frsFragment.getTbPageContext(), bj.cRs, this.gqm.getUniqueId());
        this.gxs.a(rVar);
        this.gxt = new k(frsFragment.getTbPageContext(), bj.cRu, this.gqm.getUniqueId());
        this.gxt.a(rVar);
        this.gxu = new m(frsFragment.getTbPageContext(), bj.cRv, this.gqm.getUniqueId());
        this.gxu.a(rVar);
        this.gxv = new u(frsFragment.getTbPageContext(), bj.cRN, this.gqm.getUniqueId());
        this.gxv.a(rVar);
        this.gxw = new x(frsFragment.getPageContext(), bj.cRA, this.gqm.getUniqueId());
        this.gxw.a(rVar);
        p pVar = new p(frsFragment.getPageContext(), bj.cRy, this.gqm.getUniqueId());
        pVar.a(rVar);
        v vVar = new v(frsFragment.getPageContext(), bj.cRE, this.gqm.getUniqueId());
        vVar.a(rVar);
        a aVar = new a(frsFragment.getPageContext(), bj.cRx, frsFragment.getUniqueId());
        aVar.a(rVar);
        aVar.pz(1);
        d dVar = new d(frsFragment.getPageContext(), bj.cRt, frsFragment.getUniqueId());
        dVar.a(rVar);
        b bVar = new b(frsFragment.getPageContext(), bj.cRG, this.gqm.getUniqueId());
        bVar.a(rVar);
        bVar.setInFrsAllThread(true);
        g gVar = new g(frsFragment.getPageContext(), bj.cRF, this.gqm.getUniqueId());
        gVar.a(rVar);
        gVar.setInFrsAllThread(true);
        h hVar = new h(frsFragment.getPageContext(), bj.cRH, this.gqm.getUniqueId());
        hVar.a(rVar);
        hVar.setInFrsAllThread(true);
        x xVar = new x(frsFragment.getPageContext(), bj.cRI, this.gqm.getUniqueId());
        xVar.a(rVar);
        o oVar = new o(frsFragment.getPageContext(), bj.cRR, this.gqm.getUniqueId());
        oVar.a(rVar);
        n nVar = new n(frsFragment.getPageContext(), bj.cRJ, this.gqm.getUniqueId());
        nVar.a(rVar);
        this.gxn = new ac(frsFragment.getPageContext(), com.baidu.tieba.tbadkCore.n.kfv, this.gqm.getUniqueId());
        this.gxx = new s(frsFragment.getPageContext(), bj.cRz, this.gqm.getUniqueId());
        this.gxx.a(rVar);
        com.baidu.adp.widget.ListView.a<? extends bi, ? extends v.a> a = com.baidu.tieba.frs.c.bDh().a(frsFragment.getPageContext(), this.gqm.getUniqueId(), true);
        com.baidu.adp.widget.ListView.a<? extends bj, ? extends v.a> b = com.baidu.tieba.frs.c.bDh().b(frsFragment.getPageContext(), bj.cTm, this.gqm.getUniqueId());
        com.baidu.tieba.frs.m mVar = new com.baidu.tieba.frs.m(frsFragment.getPageContext(), com.baidu.tieba.frs.n.grn);
        j jVar = new j(frsFragment.getPageContext(), com.baidu.tieba.frs.q.grC);
        ab abVar = new ab(frsFragment.getPageContext(), com.baidu.tieba.frs.r.grH, this.gqm.getUniqueId());
        this.asF.add(this.gxo);
        this.asF.add(this.gxp);
        this.asF.add(this.gxq);
        this.asF.add(this.gxr);
        this.asF.add(this.gxs);
        this.asF.add(this.gxt);
        this.asF.add(this.gxu);
        this.asF.add(this.gxv);
        this.asF.add(this.gxn);
        this.asF.add(pVar);
        this.asF.add(vVar);
        this.asF.add(aVar);
        this.asF.add(dVar);
        this.asF.add(bVar);
        this.asF.add(gVar);
        this.asF.add(hVar);
        this.asF.add(this.gxx);
        this.asF.add(this.gxw);
        this.asF.add(a);
        this.asF.add(b);
        this.asF.add(mVar);
        this.asF.add(jVar);
        this.asF.add(oVar);
        this.asF.add(nVar);
        this.asF.add(abVar);
        this.asF.add(xVar);
        com.baidu.tieba.InjectPlugin.b.b bVar2 = new com.baidu.tieba.InjectPlugin.b.b(this.gqm, 1);
        bVar2.setExtraData(this.asF);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_FEED_AD_PLUGIN_OPERATE, bVar2));
        cf(this.asF);
        rVar.addAdapters(this.asF);
        AbsDelegateAdapterList absDelegateAdapterList = new AbsDelegateAdapterList();
        CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_ADD_ADAPTER, absDelegateAdapterList);
        CustomMessage customMessage = new CustomMessage(CmdConfigCustom.CMD_FRS_ADD_ADAPTER);
        customMessage.setTag(this.gqm.getUniqueId());
        customResponsedMessage.setOrginalMessage(customMessage);
        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
        wP("page_frs");
        if (!absDelegateAdapterList.isEmpty()) {
            Iterator it = absDelegateAdapterList.iterator();
            while (it.hasNext()) {
                com.baidu.adp.widget.ListView.a aVar2 = (com.baidu.adp.widget.ListView.a) it.next();
                if (aVar2 instanceof com.baidu.tieba.frs.h) {
                    ((com.baidu.tieba.frs.h) aVar2).a(this.gqm.getPageContext(), this.gqm.getUniqueId());
                }
            }
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(absDelegateAdapterList);
            if (this.asF != null) {
                this.asF.addAll(arrayList);
            }
            if (this.fWQ != null) {
                this.fWQ.addAdapters(arrayList);
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.a.af
    public void onDestory() {
        for (com.baidu.adp.widget.ListView.a aVar : this.asF) {
            if (aVar instanceof com.baidu.tieba.frs.h) {
                ((com.baidu.tieba.frs.h) aVar).release();
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.a.af
    public HashMap<Integer, bj> bHb() {
        return this.gxk;
    }

    @Override // com.baidu.tieba.frs.entelechy.a.af
    public void notifyDataSetChanged() {
        if (this.fWQ.getListAdapter() != null) {
            this.fWQ.getListAdapter().notifyDataSetChanged();
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.a.af
    public int bHc() {
        if (this.gxo != null) {
            return R.id.frs_bawu_center;
        }
        return 0;
    }

    @Override // com.baidu.tieba.frs.entelechy.a.af
    public boolean p(BdUniqueId bdUniqueId) {
        if (bdUniqueId == null) {
            return false;
        }
        for (com.baidu.adp.widget.ListView.a aVar : this.asF) {
            if (aVar != null && aVar.getType() == bdUniqueId) {
                return true;
            }
        }
        return false;
    }

    @Override // com.baidu.tieba.frs.entelechy.a.af
    public void a(com.baidu.adp.widget.ListView.s sVar) {
        if (this.asF != null && this.asF.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.asF) {
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
        if (this.asF != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.asF) {
                if (aVar instanceof com.baidu.tieba.card.x) {
                    ((com.baidu.tieba.card.x) aVar).setForumName(str);
                }
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v1, resolved type: com.baidu.tieba.frs.FrsFragment */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.baidu.tieba.frs.entelechy.a.af
    public void bHd() {
        if (this.asF != null && this.asF.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.asF) {
                if (aVar instanceof com.baidu.tieba.frs.h) {
                    ((com.baidu.tieba.frs.h) aVar).a(this.gqm.getPageContext(), this.gqm.getUniqueId());
                }
            }
            cf(this.asF);
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.a.af
    public List<com.baidu.adp.widget.ListView.m> getDatas() {
        if (this.fWQ != null) {
            return this.fWQ.getData();
        }
        return null;
    }

    @Override // com.baidu.tieba.frs.entelechy.a.af
    public int bHe() {
        if (this.gxo != null) {
            return R.id.frs_fortune_bag_item;
        }
        return 0;
    }

    @Override // com.baidu.tieba.frs.entelechy.a.af
    public int bHf() {
        if (this.gxo != null) {
            return R.id.frs_my_service_item;
        }
        return 0;
    }

    public void asN() {
        if (this.dataList != null) {
            this.fWQ.setData(this.dataList);
        }
        notifyDataSetChanged();
    }

    @Override // com.baidu.tieba.frs.entelechy.a.af
    public void setFromCDN(boolean z) {
        if (this.asF != null && this.asF.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.asF) {
                if (aVar instanceof com.baidu.tieba.frs.h) {
                    ((com.baidu.tieba.frs.h) aVar).setFromCDN(z);
                }
            }
            if (this.gxp != null) {
                this.gxp.setFromCDN(z);
            }
            if (this.gxq != null) {
                this.gxq.setFromCDN(z);
            }
            if (this.gxr != null) {
                this.gxr.setFromCDN(z);
            }
            if (this.gxs != null) {
                this.gxs.setFromCDN(z);
            }
            if (this.gxt != null) {
                this.gxt.setFromCDN(z);
            }
            if (this.gxu != null) {
                this.gxu.setFromCDN(z);
            }
            if (this.gxw != null) {
                this.gxw.setFromCDN(z);
            }
            if (this.gxx != null) {
                this.gxx.setFromCDN(z);
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.a.af
    public void bHg() {
        List<com.baidu.adp.widget.ListView.m> data;
        if (this.fWQ != null && this.fWQ.getData() != null && this.fWQ.getData().size() != 0 && (data = this.fWQ.getData()) != null && data.size() != 0) {
            for (com.baidu.adp.widget.ListView.m mVar : data) {
                if (mVar instanceof bj) {
                    if (((bj) mVar).aCj() != 0) {
                        ((bj) mVar).aDj();
                    }
                } else if ((mVar instanceof bi) && ((bi) mVar).cRg.aCj() != 0) {
                    ((bi) mVar).cRg.aDj();
                }
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.a.af
    public void lO(boolean z) {
        if (this.gxm != z) {
            this.gxm = z;
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.a.af
    public void b(ArrayList<com.baidu.adp.widget.ListView.m> arrayList, FrsViewData frsViewData) {
        b(frsViewData);
        bFV();
        com.baidu.tieba.tbadkCore.s.o(arrayList, 1);
        am(arrayList);
        an(arrayList);
        ao(arrayList);
        Iterator<com.baidu.adp.widget.ListView.m> it = arrayList.iterator();
        while (it.hasNext()) {
            com.baidu.adp.widget.ListView.m next = it.next();
            if ((next instanceof bi) && ((bi) next).cRg.isTop()) {
                it.remove();
            }
        }
        this.fWQ.setData(arrayList);
        this.gxl = frsViewData;
        bGz();
        bHi();
        this.dataList = arrayList;
    }

    public void b(FrsViewData frsViewData) {
        if (this.asF != null && this.asF.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.asF) {
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
                if (this.gxk != null && !this.gxk.containsValue(mVar)) {
                    this.gxk.put(Integer.valueOf(i2), (bj) mVar);
                }
            }
            i = i2 + 1;
        }
    }

    private void an(ArrayList<com.baidu.adp.widget.ListView.m> arrayList) {
        int i;
        if (this.asF != null && this.asF.size() != 0) {
            int i2 = 0;
            if (arrayList == null || arrayList.size() <= 0) {
                i = 0;
            } else {
                Iterator<com.baidu.adp.widget.ListView.m> it = arrayList.iterator();
                while (true) {
                    i = i2;
                    if (!it.hasNext() || it.next().getType().getId() != bj.cRj.getId()) {
                        break;
                    }
                    i2 = i + 1;
                }
            }
            for (com.baidu.adp.widget.ListView.a aVar : this.asF) {
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
                bj bjVar = ((bi) mVar2).cRg;
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
                } else if ((mVar instanceof bi) && c(mVar) && !TextUtils.isEmpty(((bi) mVar).cRg.aAh())) {
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
        return type == bj.cRk || type == bj.cRz || type == bj.cRA || type == bj.cRI || type == bj.cRR;
    }

    private void bFV() {
        if (!com.baidu.tbadk.core.util.v.isEmpty(this.asF) && this.gqm != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.asF) {
                if (aVar instanceof com.baidu.tieba.frs.h) {
                    ((com.baidu.tieba.frs.h) aVar).a(this.gqm.getTbPageTag());
                }
            }
        }
    }

    private void bGz() {
        com.baidu.tieba.frs.d.b bGY;
        if (this.gxl != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.asF) {
                if ((aVar instanceof com.baidu.tieba.frs.d.d) && (bGY = ((com.baidu.tieba.frs.d.d) aVar).bGY()) != null) {
                    if (this.gxl.needLog == 1) {
                        bGY.gJy = true;
                    } else {
                        bGY.gJy = false;
                    }
                    if (this.gxl.getForum() != null) {
                        bGY.gJA = this.gxl.getForum().getId();
                    }
                    if (this.gqm != null && this.gqm.bDL() != null) {
                        bGY.gJz = this.gqm.bDL().bJq();
                    }
                }
            }
            bHh();
        }
    }

    private void bHh() {
        com.baidu.tieba.frs.d.b bVar = new com.baidu.tieba.frs.d.b();
        if (this.gxl.needLog == 1) {
            bVar.gJy = true;
        } else {
            bVar.gJy = false;
        }
        if (this.gxl.getForum() != null) {
            bVar.gJA = this.gxl.getForum().getId();
        }
        if (this.gqm != null && this.gqm.bDL() != null) {
            bVar.gJz = this.gqm.bDL().bJq();
        }
        if (com.baidu.tieba.frs.d.d.gwC != null) {
            bVar.gJB = com.baidu.tieba.frs.d.d.gwC.gJB;
            bVar.gJC = com.baidu.tieba.frs.d.d.gwC.gJC;
        }
        if (this.gqm != null) {
            com.baidu.tieba.frs.live.b bVar2 = new com.baidu.tieba.frs.live.b(bVar, this.gqm.getTbPageTag(), this.gqm.getUniqueId());
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

    private void bHi() {
        if (this.gxl != null && this.gxl.getForum() != null && !StringUtils.isNull(this.gxl.getForum().getId()) && this.gxn != null) {
            this.gxn.setForumId(this.gxl.getForum().getId());
        }
    }

    private void cf(List<com.baidu.adp.widget.ListView.a> list) {
        if (list != null) {
            for (com.baidu.adp.widget.ListView.a aVar : list) {
                if (aVar instanceof com.baidu.tieba.frs.h) {
                    ((com.baidu.tieba.frs.h) aVar).a(this.goc);
                }
            }
        }
    }

    private void wP(String str) {
        if (this.asF != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.asF) {
                if (aVar instanceof com.baidu.tieba.a.f) {
                    ((com.baidu.tieba.a.f) aVar).wP(str);
                }
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.a.af
    public void a(com.baidu.tieba.frs.d dVar) {
        if (this.asF != null && this.asF.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.asF) {
                if (aVar instanceof com.baidu.tieba.frs.h) {
                    ((com.baidu.tieba.frs.h) aVar).a(dVar);
                }
            }
        }
    }
}
