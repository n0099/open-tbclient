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
import com.baidu.tbadk.core.data.bg;
import com.baidu.tbadk.core.data.bh;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.AbsDelegateAdapterList;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.tbadkCore.FrsViewData;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes4.dex */
public class l implements aa {
    private ArrayList<com.baidu.adp.widget.ListView.m> dataList;
    private m fDA;
    private f fDB;
    private h fDC;
    private p fDD;
    private s fDE;
    private x fDF;
    private com.baidu.adp.widget.ListView.a fDG;
    private n fDH;
    private final HashMap<Integer, bh> fDu;
    private FrsViewData fDv;
    private r fDx;
    private g fDy;
    private o fDz;
    private com.baidu.adp.widget.ListView.r fcN;
    private FrsFragment fwq;
    private List<com.baidu.adp.widget.ListView.a> agy = new LinkedList();
    private boolean fDw = false;
    private final com.baidu.tieba.frs.f fud = new com.baidu.tieba.frs.f();

    public l(FrsFragment frsFragment, com.baidu.adp.widget.ListView.r rVar, boolean z) {
        this.fcN = rVar;
        a(frsFragment, rVar);
        this.fDu = new HashMap<>();
        ko(z);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r3v29, resolved type: com.baidu.tieba.frs.FrsFragment */
    /* JADX WARN: Multi-variable type inference failed */
    public void a(FrsFragment frsFragment, com.baidu.adp.widget.ListView.r rVar) {
        this.fwq = frsFragment;
        this.fDG = com.baidu.tieba.frs.c.bjg().a(frsFragment.getPageContext(), com.baidu.tieba.tbadkCore.u.jgu, this.fwq.getUniqueId(), false);
        this.fDx = new r(frsFragment.getTbPageContext(), bh.caH, this.fwq.getUniqueId());
        this.fDx.a(rVar);
        this.fDx.setInFrsAllThread(true);
        this.fDy = new g(frsFragment.getTbPageContext(), bh.caI, this.fwq.getUniqueId());
        this.fDy.a(rVar);
        this.fDz = new o(frsFragment.getTbPageContext(), bh.caK, this.fwq.getUniqueId());
        this.fDz.a(rVar);
        this.fDA = new m(frsFragment.getTbPageContext(), bh.caL, this.fwq.getUniqueId());
        this.fDA.a(rVar);
        this.fDB = new f(frsFragment.getTbPageContext(), bh.caM, this.fwq.getUniqueId());
        this.fDB.a(rVar);
        this.fDC = new h(frsFragment.getTbPageContext(), bh.caN, this.fwq.getUniqueId());
        this.fDC.a(rVar);
        this.fDD = new p(frsFragment.getTbPageContext(), bh.cbb, this.fwq.getUniqueId());
        this.fDD.a(rVar);
        this.fDE = new s(frsFragment.getPageContext(), bh.caR, this.fwq.getUniqueId());
        this.fDE.setInFrsAllThread(true);
        this.fDE.a(rVar);
        k kVar = new k(frsFragment.getPageContext(), bh.caP, this.fwq.getUniqueId());
        kVar.a(rVar);
        kVar.setInFrsAllThread(true);
        q qVar = new q(frsFragment.getPageContext(), bh.caV, this.fwq.getUniqueId());
        qVar.a(rVar);
        qVar.setInFrsAllThread(true);
        s sVar = new s(frsFragment.getPageContext(), bh.caW, this.fwq.getUniqueId());
        sVar.a(rVar);
        sVar.setInFrsAllThread(true);
        j jVar = new j(frsFragment.getPageContext(), bh.cbf, this.fwq.getUniqueId());
        jVar.a(rVar);
        i iVar = new i(frsFragment.getPageContext(), bh.caX, this.fwq.getUniqueId());
        iVar.a(rVar);
        this.fDF = new x(frsFragment.getPageContext().getPageActivity(), com.baidu.tieba.tbadkCore.n.jgm, this.fwq.getUniqueId());
        this.fDH = new n(frsFragment.getPageContext(), bh.caQ, this.fwq.getUniqueId());
        this.fDH.a(rVar);
        this.fDH.setVoiceManager(frsFragment.getVoiceManager());
        this.fDH.setInFrsAllThread(true);
        com.baidu.adp.widget.ListView.a<? extends bg, ? extends v.a> a = com.baidu.tieba.frs.c.bjg().a(frsFragment.getPageContext(), this.fwq.getUniqueId(), true);
        com.baidu.adp.widget.ListView.a<? extends bh, ? extends v.a> b = com.baidu.tieba.frs.c.bjg().b(frsFragment.getPageContext(), bh.ccy, this.fwq.getUniqueId());
        com.baidu.tieba.frs.l lVar = new com.baidu.tieba.frs.l(frsFragment.getPageContext(), com.baidu.tieba.frs.m.fxr);
        e eVar = new e(frsFragment.getPageContext(), com.baidu.tieba.frs.p.fxG);
        w wVar = new w(frsFragment.getPageContext(), com.baidu.tieba.frs.q.fxL, this.fwq.getUniqueId());
        this.agy.add(this.fDG);
        this.agy.add(this.fDx);
        this.agy.add(this.fDy);
        this.agy.add(this.fDz);
        this.agy.add(this.fDA);
        this.agy.add(this.fDB);
        this.agy.add(this.fDC);
        this.agy.add(this.fDD);
        this.agy.add(this.fDF);
        this.agy.add(kVar);
        this.agy.add(qVar);
        this.agy.add(this.fDH);
        this.agy.add(this.fDE);
        this.agy.add(a);
        this.agy.add(b);
        this.agy.add(lVar);
        this.agy.add(eVar);
        this.agy.add(jVar);
        this.agy.add(iVar);
        this.agy.add(wVar);
        this.agy.add(sVar);
        com.baidu.tieba.InjectPlugin.b.b bVar = new com.baidu.tieba.InjectPlugin.b.b(this.fwq, 1);
        bVar.setExtraData(this.agy);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_FEED_AD_PLUGIN_OPERATE, bVar));
        cn(this.agy);
        rVar.addAdapters(this.agy);
        AbsDelegateAdapterList absDelegateAdapterList = new AbsDelegateAdapterList();
        CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_ADD_ADAPTER, absDelegateAdapterList);
        CustomMessage customMessage = new CustomMessage(CmdConfigCustom.CMD_FRS_ADD_ADAPTER);
        customMessage.setTag(this.fwq.getUniqueId());
        customResponsedMessage.setOrginalMessage(customMessage);
        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
        rh("page_frs");
        if (!absDelegateAdapterList.isEmpty()) {
            Iterator it = absDelegateAdapterList.iterator();
            while (it.hasNext()) {
                com.baidu.adp.widget.ListView.a aVar = (com.baidu.adp.widget.ListView.a) it.next();
                if (aVar instanceof com.baidu.tieba.frs.h) {
                    ((com.baidu.tieba.frs.h) aVar).a(this.fwq.getPageContext(), this.fwq.getUniqueId());
                }
            }
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(absDelegateAdapterList);
            if (this.agy != null) {
                this.agy.addAll(arrayList);
            }
            if (this.fcN != null) {
                this.fcN.addAdapters(arrayList);
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.a.aa
    public void onDestory() {
        for (com.baidu.adp.widget.ListView.a aVar : this.agy) {
            if (aVar instanceof com.baidu.tieba.frs.h) {
                ((com.baidu.tieba.frs.h) aVar).release();
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.a.aa
    public HashMap<Integer, bh> bmW() {
        return this.fDu;
    }

    @Override // com.baidu.tieba.frs.entelechy.a.aa
    public void notifyDataSetChanged() {
        if (this.fcN.getListAdapter() != null) {
            this.fcN.getListAdapter().notifyDataSetChanged();
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.a.aa
    public int bmX() {
        if (this.fDG != null) {
            return R.id.frs_bawu_center;
        }
        return 0;
    }

    @Override // com.baidu.tieba.frs.entelechy.a.aa
    public boolean o(BdUniqueId bdUniqueId) {
        if (bdUniqueId == null) {
            return false;
        }
        for (com.baidu.adp.widget.ListView.a aVar : this.agy) {
            if (aVar != null && aVar.getType() == bdUniqueId) {
                return true;
            }
        }
        return false;
    }

    @Override // com.baidu.tieba.frs.entelechy.a.aa
    public void a(com.baidu.adp.widget.ListView.s sVar) {
        if (this.agy != null && this.agy.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.agy) {
                if (aVar instanceof com.baidu.tieba.frs.h) {
                    ((com.baidu.tieba.frs.h) aVar).a(sVar);
                } else if ((aVar instanceof n) || (aVar instanceof s)) {
                    aVar.a(sVar);
                }
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.a.aa
    public void setForumName(String str) {
        if (this.agy != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.agy) {
                if (aVar instanceof com.baidu.tieba.card.z) {
                    ((com.baidu.tieba.card.z) aVar).setForumName(str);
                }
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v1, resolved type: com.baidu.tieba.frs.FrsFragment */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.baidu.tieba.frs.entelechy.a.aa
    public void bmY() {
        if (this.agy != null && this.agy.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.agy) {
                if (aVar instanceof com.baidu.tieba.frs.h) {
                    ((com.baidu.tieba.frs.h) aVar).a(this.fwq.getPageContext(), this.fwq.getUniqueId());
                }
            }
            cn(this.agy);
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.a.aa
    public List<com.baidu.adp.widget.ListView.m> getDatas() {
        if (this.fcN != null) {
            return this.fcN.getData();
        }
        return null;
    }

    @Override // com.baidu.tieba.frs.entelechy.a.aa
    public int bmZ() {
        if (this.fDG != null) {
            return R.id.frs_fortune_bag_item;
        }
        return 0;
    }

    @Override // com.baidu.tieba.frs.entelechy.a.aa
    public int bna() {
        if (this.fDG != null) {
            return R.id.frs_my_service_item;
        }
        return 0;
    }

    public void aaO() {
        if (this.dataList != null) {
            this.fcN.setData(this.dataList);
        }
        notifyDataSetChanged();
    }

    @Override // com.baidu.tieba.frs.entelechy.a.aa
    public void setFromCDN(boolean z) {
        if (this.agy != null && this.agy.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.agy) {
                if (aVar instanceof com.baidu.tieba.frs.h) {
                    ((com.baidu.tieba.frs.h) aVar).setFromCDN(z);
                }
            }
            if (this.fDx != null) {
                this.fDx.setFromCDN(z);
            }
            if (this.fDy != null) {
                this.fDy.setFromCDN(z);
            }
            if (this.fDz != null) {
                this.fDz.setFromCDN(z);
            }
            if (this.fDA != null) {
                this.fDA.setFromCDN(z);
            }
            if (this.fDB != null) {
                this.fDB.setFromCDN(z);
            }
            if (this.fDC != null) {
                this.fDC.setFromCDN(z);
            }
            if (this.fDE != null) {
                this.fDE.setFromCDN(z);
            }
            if (this.fDH != null) {
                this.fDH.setFromCDN(z);
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.a.aa
    public void bnb() {
        List<com.baidu.adp.widget.ListView.m> data;
        if (this.fcN != null && this.fcN.getData() != null && this.fcN.getData().size() != 0 && (data = this.fcN.getData()) != null && data.size() != 0) {
            for (com.baidu.adp.widget.ListView.m mVar : data) {
                if (mVar instanceof bh) {
                    if (((bh) mVar).aiz() != 0) {
                        ((bh) mVar).aju();
                    }
                } else if ((mVar instanceof bg) && ((bg) mVar).caz.aiz() != 0) {
                    ((bg) mVar).caz.aju();
                }
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.a.aa
    public void ko(boolean z) {
        if (this.fDw != z) {
            this.fDw = z;
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.a.aa
    public void b(ArrayList<com.baidu.adp.widget.ListView.m> arrayList, FrsViewData frsViewData) {
        b(frsViewData);
        com.baidu.tieba.tbadkCore.s.n(arrayList, 1);
        ab(arrayList);
        ac(arrayList);
        ad(arrayList);
        Iterator<com.baidu.adp.widget.ListView.m> it = arrayList.iterator();
        while (it.hasNext()) {
            com.baidu.adp.widget.ListView.m next = it.next();
            if ((next instanceof bg) && ((bg) next).caz.ajl()) {
                it.remove();
            }
        }
        this.fcN.setData(arrayList);
        this.fDv = frsViewData;
        bmx();
        bnd();
        this.dataList = arrayList;
    }

    public void b(FrsViewData frsViewData) {
        if (this.agy != null && this.agy.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.agy) {
                if (aVar instanceof com.baidu.tieba.frs.h) {
                    ((com.baidu.tieba.frs.h) aVar).b(frsViewData);
                }
            }
        }
    }

    private ArrayList<Integer> ab(ArrayList<com.baidu.adp.widget.ListView.m> arrayList) {
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
                if (this.fDu != null && !this.fDu.containsValue(mVar)) {
                    this.fDu.put(Integer.valueOf(i2), (bh) mVar);
                }
            }
            i = i2 + 1;
        }
    }

    private void ac(ArrayList<com.baidu.adp.widget.ListView.m> arrayList) {
        int i;
        if (this.agy != null && this.agy.size() != 0) {
            int i2 = 0;
            if (arrayList == null || arrayList.size() <= 0) {
                i = 0;
            } else {
                Iterator<com.baidu.adp.widget.ListView.m> it = arrayList.iterator();
                while (true) {
                    i = i2;
                    if (!it.hasNext() || it.next().getType().getId() != bh.caC.getId()) {
                        break;
                    }
                    i2 = i + 1;
                }
            }
            for (com.baidu.adp.widget.ListView.a aVar : this.agy) {
                if (aVar instanceof com.baidu.tieba.frs.h) {
                    ((com.baidu.tieba.frs.h) aVar).qj(i);
                }
            }
        }
    }

    private void ad(ArrayList<com.baidu.adp.widget.ListView.m> arrayList) {
        int count = com.baidu.tbadk.core.util.v.getCount(arrayList);
        for (int i = 0; i < count; i++) {
            com.baidu.adp.widget.ListView.m mVar = (com.baidu.adp.widget.ListView.m) com.baidu.tbadk.core.util.v.getItem(arrayList, i - 1);
            com.baidu.adp.widget.ListView.m mVar2 = (com.baidu.adp.widget.ListView.m) com.baidu.tbadk.core.util.v.getItem(arrayList, i);
            if (mVar2 instanceof bg) {
                bh bhVar = ((bg) mVar2).caz;
                if (i == 0) {
                    bhVar.isFirstFloor = true;
                } else {
                    bhVar.isFirstFloor = false;
                }
                String agH = bhVar.agH();
                if (mVar instanceof com.baidu.tieba.frs.p) {
                    bhVar.needTopMargin = false;
                } else if (mVar != null && !c(mVar)) {
                    bhVar.needTopMargin = false;
                } else if ((mVar instanceof bg) && c(mVar) && !TextUtils.isEmpty(((bg) mVar).caz.agH())) {
                    bhVar.needTopMargin = true;
                } else if (c(mVar2) && !TextUtils.isEmpty(agH)) {
                    bhVar.needTopMargin = true;
                } else {
                    bhVar.needTopMargin = false;
                }
            }
        }
    }

    private boolean c(com.baidu.adp.widget.ListView.m mVar) {
        if (mVar == null) {
            return false;
        }
        BdUniqueId type = mVar.getType();
        return type == bh.caD || type == bh.caQ || type == bh.caR || type == bh.caW || type == bh.cbf;
    }

    private void bmx() {
        com.baidu.tieba.frs.d.b bmV;
        if (this.fDv != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.agy) {
                if ((aVar instanceof com.baidu.tieba.frs.d.d) && (bmV = ((com.baidu.tieba.frs.d.d) aVar).bmV()) != null) {
                    if (this.fDv.needLog == 1) {
                        bmV.fPK = true;
                    } else {
                        bmV.fPK = false;
                    }
                    if (this.fDv.getForum() != null) {
                        bmV.fPM = this.fDv.getForum().getId();
                    }
                    if (this.fwq != null && this.fwq.bjI() != null) {
                        bmV.fPL = this.fwq.bjI().bpn();
                    }
                }
            }
            bnc();
        }
    }

    private void bnc() {
        com.baidu.tieba.frs.d.b bVar = new com.baidu.tieba.frs.d.b();
        if (this.fDv.needLog == 1) {
            bVar.fPK = true;
        } else {
            bVar.fPK = false;
        }
        if (this.fDv.getForum() != null) {
            bVar.fPM = this.fDv.getForum().getId();
        }
        if (this.fwq != null && this.fwq.bjI() != null) {
            bVar.fPL = this.fwq.bjI().bpn();
        }
        if (com.baidu.tieba.frs.d.d.fDi != null) {
            bVar.fPN = com.baidu.tieba.frs.d.d.fDi.fPN;
            bVar.fPO = com.baidu.tieba.frs.d.d.fDi.fPO;
        }
        com.baidu.tieba.frs.live.b bVar2 = new com.baidu.tieba.frs.live.b(bVar, this.fwq.getUniqueId());
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

    private void bnd() {
        if (this.fDv != null && this.fDv.getForum() != null && !StringUtils.isNull(this.fDv.getForum().getId()) && this.fDF != null) {
            this.fDF.setForumId(this.fDv.getForum().getId());
        }
    }

    private void cn(List<com.baidu.adp.widget.ListView.a> list) {
        if (list != null) {
            for (com.baidu.adp.widget.ListView.a aVar : list) {
                if (aVar instanceof com.baidu.tieba.frs.h) {
                    ((com.baidu.tieba.frs.h) aVar).a(this.fud);
                }
            }
        }
    }

    private void rh(String str) {
        if (this.agy != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.agy) {
                if (aVar instanceof com.baidu.tieba.a.f) {
                    ((com.baidu.tieba.a.f) aVar).rh(str);
                }
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.a.aa
    public void a(com.baidu.tieba.frs.d dVar) {
        if (this.agy != null && this.agy.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.agy) {
                if (aVar instanceof com.baidu.tieba.frs.h) {
                    ((com.baidu.tieba.frs.h) aVar).a(dVar);
                }
            }
        }
    }
}
