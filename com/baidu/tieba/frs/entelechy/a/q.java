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
/* loaded from: classes7.dex */
public class q implements af {
    private ArrayList<com.baidu.adp.widget.ListView.m> dataList;
    private com.baidu.adp.widget.ListView.r fUA;
    private FrsFragment gnW;
    private final HashMap<Integer, bj> guV;
    private FrsViewData guW;
    private ac guY;
    private com.baidu.adp.widget.ListView.a guZ;
    private w gva;
    private l gvb;
    private t gvc;
    private r gvd;
    private k gve;
    private m gvf;
    private u gvg;
    private x gvh;
    private s gvi;
    private List<com.baidu.adp.widget.ListView.a> apl = new LinkedList();
    private boolean guX = false;
    private final com.baidu.tieba.frs.f glM = new com.baidu.tieba.frs.f();

    public q(FrsFragment frsFragment, com.baidu.adp.widget.ListView.r rVar, boolean z) {
        this.fUA = rVar;
        a(frsFragment, rVar);
        this.guV = new HashMap<>();
        lL(z);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r5v29, resolved type: com.baidu.tieba.frs.FrsFragment */
    /* JADX WARN: Multi-variable type inference failed */
    public void a(FrsFragment frsFragment, com.baidu.adp.widget.ListView.r rVar) {
        this.gnW = frsFragment;
        this.guZ = com.baidu.tieba.frs.c.bBC().a(frsFragment.getPageContext(), com.baidu.tieba.tbadkCore.u.kep, this.gnW.getUniqueId(), false);
        this.gva = new w(frsFragment.getTbPageContext(), bj.cNj, this.gnW.getUniqueId());
        this.gva.a(rVar);
        this.gvb = new l(frsFragment.getTbPageContext(), bj.cNk, this.gnW.getUniqueId());
        this.gvb.a(rVar);
        this.gvc = new t(frsFragment.getTbPageContext(), bj.cNm, this.gnW.getUniqueId());
        this.gvc.a(rVar);
        this.gvd = new r(frsFragment.getTbPageContext(), bj.cNn, this.gnW.getUniqueId());
        this.gvd.a(rVar);
        this.gve = new k(frsFragment.getTbPageContext(), bj.cNp, this.gnW.getUniqueId());
        this.gve.a(rVar);
        this.gvf = new m(frsFragment.getTbPageContext(), bj.cNq, this.gnW.getUniqueId());
        this.gvf.a(rVar);
        this.gvg = new u(frsFragment.getTbPageContext(), bj.cNI, this.gnW.getUniqueId());
        this.gvg.a(rVar);
        this.gvh = new x(frsFragment.getPageContext(), bj.cNv, this.gnW.getUniqueId());
        this.gvh.a(rVar);
        p pVar = new p(frsFragment.getPageContext(), bj.cNt, this.gnW.getUniqueId());
        pVar.a(rVar);
        v vVar = new v(frsFragment.getPageContext(), bj.cNz, this.gnW.getUniqueId());
        vVar.a(rVar);
        a aVar = new a(frsFragment.getPageContext(), bj.cNs, frsFragment.getUniqueId());
        aVar.a(rVar);
        aVar.po(1);
        d dVar = new d(frsFragment.getPageContext(), bj.cNo, frsFragment.getUniqueId());
        dVar.a(rVar);
        b bVar = new b(frsFragment.getPageContext(), bj.cNB, this.gnW.getUniqueId());
        bVar.a(rVar);
        bVar.setInFrsAllThread(true);
        g gVar = new g(frsFragment.getPageContext(), bj.cNA, this.gnW.getUniqueId());
        gVar.a(rVar);
        gVar.setInFrsAllThread(true);
        h hVar = new h(frsFragment.getPageContext(), bj.cNC, this.gnW.getUniqueId());
        hVar.a(rVar);
        hVar.setInFrsAllThread(true);
        x xVar = new x(frsFragment.getPageContext(), bj.cND, this.gnW.getUniqueId());
        xVar.a(rVar);
        o oVar = new o(frsFragment.getPageContext(), bj.cNM, this.gnW.getUniqueId());
        oVar.a(rVar);
        n nVar = new n(frsFragment.getPageContext(), bj.cNE, this.gnW.getUniqueId());
        nVar.a(rVar);
        this.guY = new ac(frsFragment.getPageContext(), com.baidu.tieba.tbadkCore.n.keh, this.gnW.getUniqueId());
        this.gvi = new s(frsFragment.getPageContext(), bj.cNu, this.gnW.getUniqueId());
        this.gvi.a(rVar);
        com.baidu.adp.widget.ListView.a<? extends bi, ? extends v.a> a = com.baidu.tieba.frs.c.bBC().a(frsFragment.getPageContext(), this.gnW.getUniqueId(), true);
        com.baidu.adp.widget.ListView.a<? extends bj, ? extends v.a> b = com.baidu.tieba.frs.c.bBC().b(frsFragment.getPageContext(), bj.cPi, this.gnW.getUniqueId());
        com.baidu.tieba.frs.m mVar = new com.baidu.tieba.frs.m(frsFragment.getPageContext(), com.baidu.tieba.frs.n.goX);
        j jVar = new j(frsFragment.getPageContext(), com.baidu.tieba.frs.q.gpm);
        ab abVar = new ab(frsFragment.getPageContext(), com.baidu.tieba.frs.r.gpr, this.gnW.getUniqueId());
        this.apl.add(this.guZ);
        this.apl.add(this.gva);
        this.apl.add(this.gvb);
        this.apl.add(this.gvc);
        this.apl.add(this.gvd);
        this.apl.add(this.gve);
        this.apl.add(this.gvf);
        this.apl.add(this.gvg);
        this.apl.add(this.guY);
        this.apl.add(pVar);
        this.apl.add(vVar);
        this.apl.add(aVar);
        this.apl.add(dVar);
        this.apl.add(bVar);
        this.apl.add(gVar);
        this.apl.add(hVar);
        this.apl.add(this.gvi);
        this.apl.add(this.gvh);
        this.apl.add(a);
        this.apl.add(b);
        this.apl.add(mVar);
        this.apl.add(jVar);
        this.apl.add(oVar);
        this.apl.add(nVar);
        this.apl.add(abVar);
        this.apl.add(xVar);
        com.baidu.tieba.InjectPlugin.b.b bVar2 = new com.baidu.tieba.InjectPlugin.b.b(this.gnW, 1);
        bVar2.setExtraData(this.apl);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_FEED_AD_PLUGIN_OPERATE, bVar2));
        cj(this.apl);
        rVar.addAdapters(this.apl);
        AbsDelegateAdapterList absDelegateAdapterList = new AbsDelegateAdapterList();
        CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_ADD_ADAPTER, absDelegateAdapterList);
        CustomMessage customMessage = new CustomMessage(CmdConfigCustom.CMD_FRS_ADD_ADAPTER);
        customMessage.setTag(this.gnW.getUniqueId());
        customResponsedMessage.setOrginalMessage(customMessage);
        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
        wu("page_frs");
        if (!absDelegateAdapterList.isEmpty()) {
            Iterator it = absDelegateAdapterList.iterator();
            while (it.hasNext()) {
                com.baidu.adp.widget.ListView.a aVar2 = (com.baidu.adp.widget.ListView.a) it.next();
                if (aVar2 instanceof com.baidu.tieba.frs.h) {
                    ((com.baidu.tieba.frs.h) aVar2).a(this.gnW.getPageContext(), this.gnW.getUniqueId());
                }
            }
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(absDelegateAdapterList);
            if (this.apl != null) {
                this.apl.addAll(arrayList);
            }
            if (this.fUA != null) {
                this.fUA.addAdapters(arrayList);
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.a.af
    public void onDestory() {
        for (com.baidu.adp.widget.ListView.a aVar : this.apl) {
            if (aVar instanceof com.baidu.tieba.frs.h) {
                ((com.baidu.tieba.frs.h) aVar).release();
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.a.af
    public HashMap<Integer, bj> bFw() {
        return this.guV;
    }

    @Override // com.baidu.tieba.frs.entelechy.a.af
    public void notifyDataSetChanged() {
        if (this.fUA.getListAdapter() != null) {
            this.fUA.getListAdapter().notifyDataSetChanged();
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.a.af
    public int bFx() {
        if (this.guZ != null) {
            return R.id.frs_bawu_center;
        }
        return 0;
    }

    @Override // com.baidu.tieba.frs.entelechy.a.af
    public boolean p(BdUniqueId bdUniqueId) {
        if (bdUniqueId == null) {
            return false;
        }
        for (com.baidu.adp.widget.ListView.a aVar : this.apl) {
            if (aVar != null && aVar.getType() == bdUniqueId) {
                return true;
            }
        }
        return false;
    }

    @Override // com.baidu.tieba.frs.entelechy.a.af
    public void a(com.baidu.adp.widget.ListView.s sVar) {
        if (this.apl != null && this.apl.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.apl) {
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
        if (this.apl != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.apl) {
                if (aVar instanceof com.baidu.tieba.card.x) {
                    ((com.baidu.tieba.card.x) aVar).setForumName(str);
                }
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v1, resolved type: com.baidu.tieba.frs.FrsFragment */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.baidu.tieba.frs.entelechy.a.af
    public void bFy() {
        if (this.apl != null && this.apl.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.apl) {
                if (aVar instanceof com.baidu.tieba.frs.h) {
                    ((com.baidu.tieba.frs.h) aVar).a(this.gnW.getPageContext(), this.gnW.getUniqueId());
                }
            }
            cj(this.apl);
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.a.af
    public List<com.baidu.adp.widget.ListView.m> getDatas() {
        if (this.fUA != null) {
            return this.fUA.getData();
        }
        return null;
    }

    @Override // com.baidu.tieba.frs.entelechy.a.af
    public int bFz() {
        if (this.guZ != null) {
            return R.id.frs_fortune_bag_item;
        }
        return 0;
    }

    @Override // com.baidu.tieba.frs.entelechy.a.af
    public int bFA() {
        if (this.guZ != null) {
            return R.id.frs_my_service_item;
        }
        return 0;
    }

    public void aqx() {
        if (this.dataList != null) {
            this.fUA.setData(this.dataList);
        }
        notifyDataSetChanged();
    }

    @Override // com.baidu.tieba.frs.entelechy.a.af
    public void setFromCDN(boolean z) {
        if (this.apl != null && this.apl.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.apl) {
                if (aVar instanceof com.baidu.tieba.frs.h) {
                    ((com.baidu.tieba.frs.h) aVar).setFromCDN(z);
                }
            }
            if (this.gva != null) {
                this.gva.setFromCDN(z);
            }
            if (this.gvb != null) {
                this.gvb.setFromCDN(z);
            }
            if (this.gvc != null) {
                this.gvc.setFromCDN(z);
            }
            if (this.gvd != null) {
                this.gvd.setFromCDN(z);
            }
            if (this.gve != null) {
                this.gve.setFromCDN(z);
            }
            if (this.gvf != null) {
                this.gvf.setFromCDN(z);
            }
            if (this.gvh != null) {
                this.gvh.setFromCDN(z);
            }
            if (this.gvi != null) {
                this.gvi.setFromCDN(z);
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.a.af
    public void bFB() {
        List<com.baidu.adp.widget.ListView.m> data;
        if (this.fUA != null && this.fUA.getData() != null && this.fUA.getData().size() != 0 && (data = this.fUA.getData()) != null && data.size() != 0) {
            for (com.baidu.adp.widget.ListView.m mVar : data) {
                if (mVar instanceof bj) {
                    if (((bj) mVar).azS() != 0) {
                        ((bj) mVar).aAT();
                    }
                } else if ((mVar instanceof bi) && ((bi) mVar).cNb.azS() != 0) {
                    ((bi) mVar).cNb.aAT();
                }
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.a.af
    public void lL(boolean z) {
        if (this.guX != z) {
            this.guX = z;
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.a.af
    public void b(ArrayList<com.baidu.adp.widget.ListView.m> arrayList, FrsViewData frsViewData) {
        b(frsViewData);
        bEq();
        com.baidu.tieba.tbadkCore.s.o(arrayList, 1);
        am(arrayList);
        an(arrayList);
        ao(arrayList);
        Iterator<com.baidu.adp.widget.ListView.m> it = arrayList.iterator();
        while (it.hasNext()) {
            com.baidu.adp.widget.ListView.m next = it.next();
            if ((next instanceof bi) && ((bi) next).cNb.isTop()) {
                it.remove();
            }
        }
        this.fUA.setData(arrayList);
        this.guW = frsViewData;
        bEU();
        bFD();
        this.dataList = arrayList;
    }

    public void b(FrsViewData frsViewData) {
        if (this.apl != null && this.apl.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.apl) {
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
                if (this.guV != null && !this.guV.containsValue(mVar)) {
                    this.guV.put(Integer.valueOf(i2), (bj) mVar);
                }
            }
            i = i2 + 1;
        }
    }

    private void an(ArrayList<com.baidu.adp.widget.ListView.m> arrayList) {
        int i;
        if (this.apl != null && this.apl.size() != 0) {
            int i2 = 0;
            if (arrayList == null || arrayList.size() <= 0) {
                i = 0;
            } else {
                Iterator<com.baidu.adp.widget.ListView.m> it = arrayList.iterator();
                while (true) {
                    i = i2;
                    if (!it.hasNext() || it.next().getType().getId() != bj.cNe.getId()) {
                        break;
                    }
                    i2 = i + 1;
                }
            }
            for (com.baidu.adp.widget.ListView.a aVar : this.apl) {
                if (aVar instanceof com.baidu.tieba.frs.h) {
                    ((com.baidu.tieba.frs.h) aVar).su(i);
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
                bj bjVar = ((bi) mVar2).cNb;
                if (i == 0) {
                    bjVar.isFirstFloor = true;
                } else {
                    bjVar.isFirstFloor = false;
                }
                String axR = bjVar.axR();
                if (mVar instanceof com.baidu.tieba.frs.q) {
                    bjVar.needTopMargin = false;
                } else if (mVar != null && !c(mVar)) {
                    bjVar.needTopMargin = false;
                } else if ((mVar instanceof bi) && c(mVar) && !TextUtils.isEmpty(((bi) mVar).cNb.axR())) {
                    bjVar.needTopMargin = true;
                } else if (c(mVar2) && !TextUtils.isEmpty(axR)) {
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
        return type == bj.cNf || type == bj.cNu || type == bj.cNv || type == bj.cND || type == bj.cNM;
    }

    private void bEq() {
        if (!com.baidu.tbadk.core.util.v.isEmpty(this.apl) && this.gnW != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.apl) {
                if (aVar instanceof com.baidu.tieba.frs.h) {
                    ((com.baidu.tieba.frs.h) aVar).a(this.gnW.getTbPageTag());
                }
            }
        }
    }

    private void bEU() {
        com.baidu.tieba.frs.d.b bFt;
        if (this.guW != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.apl) {
                if ((aVar instanceof com.baidu.tieba.frs.d.d) && (bFt = ((com.baidu.tieba.frs.d.d) aVar).bFt()) != null) {
                    if (this.guW.needLog == 1) {
                        bFt.gHl = true;
                    } else {
                        bFt.gHl = false;
                    }
                    if (this.guW.getForum() != null) {
                        bFt.gHn = this.guW.getForum().getId();
                    }
                    if (this.gnW != null && this.gnW.bCf() != null) {
                        bFt.gHm = this.gnW.bCf().bHL();
                    }
                }
            }
            bFC();
        }
    }

    private void bFC() {
        com.baidu.tieba.frs.d.b bVar = new com.baidu.tieba.frs.d.b();
        if (this.guW.needLog == 1) {
            bVar.gHl = true;
        } else {
            bVar.gHl = false;
        }
        if (this.guW.getForum() != null) {
            bVar.gHn = this.guW.getForum().getId();
        }
        if (this.gnW != null && this.gnW.bCf() != null) {
            bVar.gHm = this.gnW.bCf().bHL();
        }
        if (com.baidu.tieba.frs.d.d.gun != null) {
            bVar.gHo = com.baidu.tieba.frs.d.d.gun.gHo;
            bVar.gHp = com.baidu.tieba.frs.d.d.gun.gHp;
        }
        if (this.gnW != null) {
            com.baidu.tieba.frs.live.b bVar2 = new com.baidu.tieba.frs.live.b(bVar, this.gnW.getTbPageTag(), this.gnW.getUniqueId());
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

    private void bFD() {
        if (this.guW != null && this.guW.getForum() != null && !StringUtils.isNull(this.guW.getForum().getId()) && this.guY != null) {
            this.guY.setForumId(this.guW.getForum().getId());
        }
    }

    private void cj(List<com.baidu.adp.widget.ListView.a> list) {
        if (list != null) {
            for (com.baidu.adp.widget.ListView.a aVar : list) {
                if (aVar instanceof com.baidu.tieba.frs.h) {
                    ((com.baidu.tieba.frs.h) aVar).a(this.glM);
                }
            }
        }
    }

    private void wu(String str) {
        if (this.apl != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.apl) {
                if (aVar instanceof com.baidu.tieba.a.f) {
                    ((com.baidu.tieba.a.f) aVar).wu(str);
                }
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.a.af
    public void a(com.baidu.tieba.frs.d dVar) {
        if (this.apl != null && this.apl.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.apl) {
                if (aVar instanceof com.baidu.tieba.frs.h) {
                    ((com.baidu.tieba.frs.h) aVar).a(dVar);
                }
            }
        }
    }
}
