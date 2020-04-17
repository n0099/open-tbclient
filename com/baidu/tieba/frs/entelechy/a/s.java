package com.baidu.tieba.frs.entelechy.a;

import android.text.TextUtils;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.y;
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
    private com.baidu.adp.widget.ListView.r gEc;
    private FrsFragment hah;
    private o hhA;
    private w hhB;
    private z hhC;
    private u hhD;
    private final HashMap<Integer, bj> hhq;
    private FrsViewData hhr;
    private ae hht;
    private com.baidu.adp.widget.ListView.a hhu;
    private y hhv;
    private n hhw;
    private v hhx;
    private t hhy;
    private m hhz;
    private List<com.baidu.adp.widget.ListView.a> aMd = new LinkedList();
    private boolean hhs = false;
    private final com.baidu.tieba.frs.f gXR = new com.baidu.tieba.frs.f();

    public s(FrsFragment frsFragment, com.baidu.adp.widget.ListView.r rVar, boolean z) {
        this.gEc = rVar;
        a(frsFragment, rVar);
        this.hhq = new HashMap<>();
        mX(z);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r5v29, resolved type: com.baidu.tieba.frs.FrsFragment */
    /* JADX WARN: Multi-variable type inference failed */
    public void a(FrsFragment frsFragment, com.baidu.adp.widget.ListView.r rVar) {
        this.hah = frsFragment;
        this.hhu = com.baidu.tieba.frs.c.bNN().a(frsFragment.getPageContext(), com.baidu.tieba.tbadkCore.v.kRk, this.hah.getUniqueId(), false);
        this.hhv = new y(frsFragment.getTbPageContext(), bj.dqI, this.hah.getUniqueId());
        this.hhv.b(rVar);
        this.hhw = new n(frsFragment.getTbPageContext(), bj.dqJ, this.hah.getUniqueId());
        this.hhw.b(rVar);
        this.hhx = new v(frsFragment.getTbPageContext(), bj.dqL, this.hah.getUniqueId());
        this.hhx.b(rVar);
        this.hhy = new t(frsFragment.getTbPageContext(), bj.dqM, this.hah.getUniqueId());
        this.hhy.b(rVar);
        this.hhz = new m(frsFragment.getTbPageContext(), bj.dqO, this.hah.getUniqueId());
        this.hhz.b(rVar);
        this.hhA = new o(frsFragment.getTbPageContext(), bj.dqP, this.hah.getUniqueId());
        this.hhA.b(rVar);
        this.hhB = new w(frsFragment.getTbPageContext(), bj.dri, this.hah.getUniqueId());
        this.hhB.b(rVar);
        this.hhC = new z(frsFragment.getPageContext(), bj.dqV, this.hah.getUniqueId());
        this.hhC.b(rVar);
        r rVar2 = new r(frsFragment.getPageContext(), bj.dqT, this.hah.getUniqueId());
        rVar2.b(rVar);
        x xVar = new x(frsFragment.getPageContext(), bj.dqZ, this.hah.getUniqueId());
        xVar.b(rVar);
        a aVar = new a(frsFragment.getPageContext(), bj.dqR, frsFragment.getUniqueId());
        aVar.b(rVar);
        aVar.pV(1);
        e eVar = new e(frsFragment.getPageContext(), bj.dqN, frsFragment.getUniqueId());
        eVar.b(rVar);
        b bVar = new b(frsFragment.getPageContext(), bj.drb, this.hah.getUniqueId());
        bVar.b(rVar);
        bVar.setInFrsAllThread(true);
        h hVar = new h(frsFragment.getPageContext(), bj.dra, this.hah.getUniqueId());
        hVar.b(rVar);
        hVar.setInFrsAllThread(true);
        i iVar = new i(frsFragment.getPageContext(), bj.drc, this.hah.getUniqueId());
        iVar.b(rVar);
        iVar.setInFrsAllThread(true);
        z zVar = new z(frsFragment.getPageContext(), bj.drd, this.hah.getUniqueId());
        zVar.b(rVar);
        q qVar = new q(frsFragment.getPageContext(), bj.drm, this.hah.getUniqueId());
        qVar.b(rVar);
        p pVar = new p(frsFragment.getPageContext(), bj.dre, this.hah.getUniqueId());
        pVar.b(rVar);
        this.hht = new ae(frsFragment.getPageContext(), com.baidu.tieba.tbadkCore.o.kRc, this.hah.getUniqueId());
        this.hhD = new u(frsFragment.getPageContext(), bj.dqU, this.hah.getUniqueId());
        this.hhD.b(rVar);
        com.baidu.adp.widget.ListView.a<? extends bi, ? extends y.a> a = com.baidu.tieba.frs.c.bNN().a(frsFragment.getPageContext(), this.hah.getUniqueId(), true);
        com.baidu.adp.widget.ListView.a<? extends bj, ? extends y.a> b = com.baidu.tieba.frs.c.bNN().b(frsFragment.getPageContext(), bj.dsJ, this.hah.getUniqueId());
        com.baidu.tieba.frs.o oVar = new com.baidu.tieba.frs.o(frsFragment.getPageContext(), com.baidu.tieba.frs.p.hbj);
        l lVar = new l(frsFragment.getPageContext(), com.baidu.tieba.frs.t.hby);
        ad adVar = new ad(frsFragment.getPageContext(), com.baidu.tieba.frs.u.hbD, this.hah.getUniqueId());
        this.aMd.add(this.hhu);
        this.aMd.add(this.hhv);
        this.aMd.add(this.hhw);
        this.aMd.add(this.hhx);
        this.aMd.add(this.hhy);
        this.aMd.add(this.hhz);
        this.aMd.add(this.hhA);
        this.aMd.add(this.hhB);
        this.aMd.add(this.hht);
        this.aMd.add(rVar2);
        this.aMd.add(xVar);
        this.aMd.add(aVar);
        this.aMd.add(eVar);
        this.aMd.add(bVar);
        this.aMd.add(hVar);
        this.aMd.add(iVar);
        this.aMd.add(this.hhD);
        this.aMd.add(this.hhC);
        this.aMd.add(a);
        this.aMd.add(b);
        this.aMd.add(oVar);
        this.aMd.add(lVar);
        this.aMd.add(qVar);
        this.aMd.add(pVar);
        this.aMd.add(adVar);
        this.aMd.add(zVar);
        com.baidu.tieba.InjectPlugin.b.b bVar2 = new com.baidu.tieba.InjectPlugin.b.b(this.hah, 1);
        bVar2.setExtraData(this.aMd);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_FEED_AD_PLUGIN_OPERATE, bVar2));
        cr(this.aMd);
        rVar.addAdapters(this.aMd);
        AbsDelegateAdapterList absDelegateAdapterList = new AbsDelegateAdapterList();
        CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_ADD_ADAPTER, absDelegateAdapterList);
        CustomMessage customMessage = new CustomMessage(CmdConfigCustom.CMD_FRS_ADD_ADAPTER);
        customMessage.setTag(this.hah.getUniqueId());
        customResponsedMessage.setOrginalMessage(customMessage);
        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
        yc("page_frs");
        if (!absDelegateAdapterList.isEmpty()) {
            Iterator it = absDelegateAdapterList.iterator();
            while (it.hasNext()) {
                com.baidu.adp.widget.ListView.a aVar2 = (com.baidu.adp.widget.ListView.a) it.next();
                if (aVar2 instanceof com.baidu.tieba.frs.h) {
                    ((com.baidu.tieba.frs.h) aVar2).a(this.hah.getPageContext(), this.hah.getUniqueId());
                }
            }
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(absDelegateAdapterList);
            if (this.aMd != null) {
                this.aMd.addAll(arrayList);
            }
            if (this.gEc != null) {
                this.gEc.addAdapters(arrayList);
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.a.ai
    public void onDestory() {
        for (com.baidu.adp.widget.ListView.a aVar : this.aMd) {
            if (aVar instanceof com.baidu.tieba.frs.h) {
                ((com.baidu.tieba.frs.h) aVar).release();
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.a.ai
    public HashMap<Integer, bj> bRR() {
        return this.hhq;
    }

    @Override // com.baidu.tieba.frs.entelechy.a.ai
    public void notifyDataSetChanged() {
        if (this.gEc.getListAdapter() != null) {
            this.gEc.getListAdapter().notifyDataSetChanged();
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.a.ai
    public int bRS() {
        if (this.hhu != null) {
            return R.id.frs_bawu_center;
        }
        return 0;
    }

    @Override // com.baidu.tieba.frs.entelechy.a.ai
    public boolean p(BdUniqueId bdUniqueId) {
        if (bdUniqueId == null) {
            return false;
        }
        for (com.baidu.adp.widget.ListView.a aVar : this.aMd) {
            if (aVar != null && aVar.getType() == bdUniqueId) {
                return true;
            }
        }
        return false;
    }

    @Override // com.baidu.tieba.frs.entelechy.a.ai
    public void a(com.baidu.adp.widget.ListView.v vVar) {
        if (this.aMd != null && this.aMd.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.aMd) {
                if (aVar instanceof com.baidu.tieba.frs.h) {
                    ((com.baidu.tieba.frs.h) aVar).a(vVar);
                } else if ((aVar instanceof u) || (aVar instanceof z)) {
                    aVar.a(vVar);
                }
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.a.ai
    public void setForumName(String str) {
        if (this.aMd != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.aMd) {
                if (aVar instanceof com.baidu.tieba.card.x) {
                    ((com.baidu.tieba.card.x) aVar).setForumName(str);
                }
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v1, resolved type: com.baidu.tieba.frs.FrsFragment */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.baidu.tieba.frs.entelechy.a.ai
    public void bRT() {
        if (this.aMd != null && this.aMd.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.aMd) {
                if (aVar instanceof com.baidu.tieba.frs.h) {
                    ((com.baidu.tieba.frs.h) aVar).a(this.hah.getPageContext(), this.hah.getUniqueId());
                }
            }
            cr(this.aMd);
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.a.ai
    public List<com.baidu.adp.widget.ListView.m> getDatas() {
        if (this.gEc != null) {
            return this.gEc.getData();
        }
        return null;
    }

    @Override // com.baidu.tieba.frs.entelechy.a.ai
    public int bRU() {
        if (this.hhu != null) {
            return R.id.frs_fortune_bag_item;
        }
        return 0;
    }

    @Override // com.baidu.tieba.frs.entelechy.a.ai
    public int bRV() {
        if (this.hhu != null) {
            return R.id.frs_my_service_item;
        }
        return 0;
    }

    public void aBa() {
        if (this.dataList != null) {
            this.gEc.setData(this.dataList);
        }
        notifyDataSetChanged();
    }

    @Override // com.baidu.tieba.frs.entelechy.a.ai
    public void setFromCDN(boolean z) {
        if (this.aMd != null && this.aMd.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.aMd) {
                if (aVar instanceof com.baidu.tieba.frs.h) {
                    ((com.baidu.tieba.frs.h) aVar).setFromCDN(z);
                }
            }
            if (this.hhv != null) {
                this.hhv.setFromCDN(z);
            }
            if (this.hhw != null) {
                this.hhw.setFromCDN(z);
            }
            if (this.hhx != null) {
                this.hhx.setFromCDN(z);
            }
            if (this.hhy != null) {
                this.hhy.setFromCDN(z);
            }
            if (this.hhz != null) {
                this.hhz.setFromCDN(z);
            }
            if (this.hhA != null) {
                this.hhA.setFromCDN(z);
            }
            if (this.hhC != null) {
                this.hhC.setFromCDN(z);
            }
            if (this.hhD != null) {
                this.hhD.setFromCDN(z);
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.a.ai
    public void bRW() {
        List<com.baidu.adp.widget.ListView.m> data;
        if (this.gEc != null && this.gEc.getData() != null && this.gEc.getData().size() != 0 && (data = this.gEc.getData()) != null && data.size() != 0) {
            for (com.baidu.adp.widget.ListView.m mVar : data) {
                if (mVar instanceof bj) {
                    if (((bj) mVar).aKz() != 0) {
                        ((bj) mVar).aLz();
                    }
                } else if ((mVar instanceof bi) && ((bi) mVar).dqA.aKz() != 0) {
                    ((bi) mVar).dqA.aLz();
                }
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.a.ai
    public void mX(boolean z) {
        if (this.hhs != z) {
            this.hhs = z;
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.a.ai
    public void b(ArrayList<com.baidu.adp.widget.ListView.m> arrayList, FrsViewData frsViewData) {
        b(frsViewData);
        bQI();
        com.baidu.tieba.tbadkCore.t.q(arrayList, 1);
        ao(arrayList);
        ap(arrayList);
        aq(arrayList);
        Iterator<com.baidu.adp.widget.ListView.m> it = arrayList.iterator();
        while (it.hasNext()) {
            com.baidu.adp.widget.ListView.m next = it.next();
            if ((next instanceof bi) && ((bi) next).dqA.isTop()) {
                it.remove();
            }
        }
        this.gEc.setData(arrayList);
        this.hhr = frsViewData;
        bRm();
        bRY();
        this.dataList = arrayList;
    }

    public void b(FrsViewData frsViewData) {
        if (this.aMd != null && this.aMd.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.aMd) {
                if (aVar instanceof com.baidu.tieba.frs.h) {
                    ((com.baidu.tieba.frs.h) aVar).b(frsViewData);
                }
            }
        }
    }

    private ArrayList<Integer> ao(ArrayList<com.baidu.adp.widget.ListView.m> arrayList) {
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
                if (this.hhq != null && !this.hhq.containsValue(mVar)) {
                    this.hhq.put(Integer.valueOf(i2), (bj) mVar);
                }
            }
            i = i2 + 1;
        }
    }

    private void ap(ArrayList<com.baidu.adp.widget.ListView.m> arrayList) {
        int i;
        if (this.aMd != null && this.aMd.size() != 0) {
            int i2 = 0;
            if (arrayList == null || arrayList.size() <= 0) {
                i = 0;
            } else {
                Iterator<com.baidu.adp.widget.ListView.m> it = arrayList.iterator();
                while (true) {
                    i = i2;
                    if (!it.hasNext() || it.next().getType().getId() != bj.dqD.getId()) {
                        break;
                    }
                    i2 = i + 1;
                }
            }
            for (com.baidu.adp.widget.ListView.a aVar : this.aMd) {
                if (aVar instanceof com.baidu.tieba.frs.h) {
                    ((com.baidu.tieba.frs.h) aVar).sZ(i);
                }
            }
        }
    }

    private void aq(ArrayList<com.baidu.adp.widget.ListView.m> arrayList) {
        int count = com.baidu.tbadk.core.util.v.getCount(arrayList);
        for (int i = 0; i < count; i++) {
            com.baidu.adp.widget.ListView.m mVar = (com.baidu.adp.widget.ListView.m) com.baidu.tbadk.core.util.v.getItem(arrayList, i - 1);
            com.baidu.adp.widget.ListView.m mVar2 = (com.baidu.adp.widget.ListView.m) com.baidu.tbadk.core.util.v.getItem(arrayList, i);
            if (mVar2 instanceof bi) {
                bj bjVar = ((bi) mVar2).dqA;
                if (i == 0) {
                    bjVar.isFirstFloor = true;
                } else {
                    bjVar.isFirstFloor = false;
                }
                String aIx = bjVar.aIx();
                if (mVar instanceof com.baidu.tieba.frs.t) {
                    bjVar.needTopMargin = false;
                } else if (mVar != null && !c(mVar)) {
                    bjVar.needTopMargin = false;
                } else if ((mVar instanceof bi) && c(mVar) && !TextUtils.isEmpty(((bi) mVar).dqA.aIx())) {
                    bjVar.needTopMargin = true;
                } else if (c(mVar2) && !TextUtils.isEmpty(aIx)) {
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
        return type == bj.dqE || type == bj.dqU || type == bj.dqV || type == bj.drd || type == bj.drm;
    }

    private void bQI() {
        if (!com.baidu.tbadk.core.util.v.isEmpty(this.aMd) && this.hah != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.aMd) {
                if (aVar instanceof com.baidu.tieba.frs.h) {
                    ((com.baidu.tieba.frs.h) aVar).a(this.hah.getTbPageTag());
                }
            }
        }
    }

    private void bRm() {
        com.baidu.tieba.frs.d.b statisticMetaData;
        if (this.hhr != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.aMd) {
                if ((aVar instanceof com.baidu.tieba.frs.d.d) && (statisticMetaData = ((com.baidu.tieba.frs.d.d) aVar).getStatisticMetaData()) != null) {
                    if (this.hhr.needLog == 1) {
                        statisticMetaData.htU = true;
                    } else {
                        statisticMetaData.htU = false;
                    }
                    if (this.hhr.getForum() != null) {
                        statisticMetaData.htW = this.hhr.getForum().getId();
                    }
                    if (this.hah != null && this.hah.bOs() != null) {
                        statisticMetaData.htV = this.hah.bOs().bUa();
                    }
                }
            }
            bRX();
        }
    }

    private void bRX() {
        com.baidu.tieba.frs.d.b bVar = new com.baidu.tieba.frs.d.b();
        if (this.hhr.needLog == 1) {
            bVar.htU = true;
        } else {
            bVar.htU = false;
        }
        if (this.hhr.getForum() != null) {
            bVar.htW = this.hhr.getForum().getId();
        }
        if (this.hah != null && this.hah.bOs() != null) {
            bVar.htV = this.hah.bOs().bUa();
        }
        if (com.baidu.tieba.frs.d.d.hgG != null) {
            bVar.htX = com.baidu.tieba.frs.d.d.hgG.htX;
            bVar.htY = com.baidu.tieba.frs.d.d.hgG.htY;
        }
        if (this.hah != null) {
            com.baidu.tieba.frs.live.b bVar2 = new com.baidu.tieba.frs.live.b(bVar, this.hah.getTbPageTag(), this.hah.getUniqueId());
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

    private void bRY() {
        if (this.hhr != null && this.hhr.getForum() != null && !StringUtils.isNull(this.hhr.getForum().getId()) && this.hht != null) {
            this.hht.setForumId(this.hhr.getForum().getId());
        }
    }

    private void cr(List<com.baidu.adp.widget.ListView.a> list) {
        if (list != null) {
            for (com.baidu.adp.widget.ListView.a aVar : list) {
                if (aVar instanceof com.baidu.tieba.frs.h) {
                    ((com.baidu.tieba.frs.h) aVar).a(this.gXR);
                }
            }
        }
    }

    private void yc(String str) {
        if (this.aMd != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.aMd) {
                if (aVar instanceof com.baidu.tieba.a.f) {
                    ((com.baidu.tieba.a.f) aVar).yc(str);
                }
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.a.ai
    public void a(com.baidu.tieba.frs.d dVar) {
        if (this.aMd != null && this.aMd.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.aMd) {
                if (aVar instanceof com.baidu.tieba.frs.h) {
                    ((com.baidu.tieba.frs.h) aVar).a(dVar);
                }
            }
        }
    }
}
