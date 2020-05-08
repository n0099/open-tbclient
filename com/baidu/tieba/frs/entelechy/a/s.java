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
    private com.baidu.adp.widget.ListView.r gEi;
    private FrsFragment han;
    private com.baidu.adp.widget.ListView.a hhA;
    private y hhB;
    private n hhC;
    private v hhD;
    private t hhE;
    private m hhF;
    private o hhG;
    private w hhH;
    private z hhI;
    private u hhJ;
    private final HashMap<Integer, bj> hhw;
    private FrsViewData hhx;
    private ae hhz;
    private List<com.baidu.adp.widget.ListView.a> aMj = new LinkedList();
    private boolean hhy = false;
    private final com.baidu.tieba.frs.f gXX = new com.baidu.tieba.frs.f();

    public s(FrsFragment frsFragment, com.baidu.adp.widget.ListView.r rVar, boolean z) {
        this.gEi = rVar;
        a(frsFragment, rVar);
        this.hhw = new HashMap<>();
        mX(z);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r5v29, resolved type: com.baidu.tieba.frs.FrsFragment */
    /* JADX WARN: Multi-variable type inference failed */
    public void a(FrsFragment frsFragment, com.baidu.adp.widget.ListView.r rVar) {
        this.han = frsFragment;
        this.hhA = com.baidu.tieba.frs.c.bNL().a(frsFragment.getPageContext(), com.baidu.tieba.tbadkCore.v.kRo, this.han.getUniqueId(), false);
        this.hhB = new y(frsFragment.getTbPageContext(), bj.dqM, this.han.getUniqueId());
        this.hhB.b(rVar);
        this.hhC = new n(frsFragment.getTbPageContext(), bj.dqN, this.han.getUniqueId());
        this.hhC.b(rVar);
        this.hhD = new v(frsFragment.getTbPageContext(), bj.dqP, this.han.getUniqueId());
        this.hhD.b(rVar);
        this.hhE = new t(frsFragment.getTbPageContext(), bj.dqQ, this.han.getUniqueId());
        this.hhE.b(rVar);
        this.hhF = new m(frsFragment.getTbPageContext(), bj.dqS, this.han.getUniqueId());
        this.hhF.b(rVar);
        this.hhG = new o(frsFragment.getTbPageContext(), bj.dqT, this.han.getUniqueId());
        this.hhG.b(rVar);
        this.hhH = new w(frsFragment.getTbPageContext(), bj.drm, this.han.getUniqueId());
        this.hhH.b(rVar);
        this.hhI = new z(frsFragment.getPageContext(), bj.dqZ, this.han.getUniqueId());
        this.hhI.b(rVar);
        r rVar2 = new r(frsFragment.getPageContext(), bj.dqX, this.han.getUniqueId());
        rVar2.b(rVar);
        x xVar = new x(frsFragment.getPageContext(), bj.drd, this.han.getUniqueId());
        xVar.b(rVar);
        a aVar = new a(frsFragment.getPageContext(), bj.dqV, frsFragment.getUniqueId());
        aVar.b(rVar);
        aVar.pV(1);
        e eVar = new e(frsFragment.getPageContext(), bj.dqR, frsFragment.getUniqueId());
        eVar.b(rVar);
        b bVar = new b(frsFragment.getPageContext(), bj.drf, this.han.getUniqueId());
        bVar.b(rVar);
        bVar.setInFrsAllThread(true);
        h hVar = new h(frsFragment.getPageContext(), bj.dre, this.han.getUniqueId());
        hVar.b(rVar);
        hVar.setInFrsAllThread(true);
        i iVar = new i(frsFragment.getPageContext(), bj.drg, this.han.getUniqueId());
        iVar.b(rVar);
        iVar.setInFrsAllThread(true);
        z zVar = new z(frsFragment.getPageContext(), bj.drh, this.han.getUniqueId());
        zVar.b(rVar);
        q qVar = new q(frsFragment.getPageContext(), bj.drq, this.han.getUniqueId());
        qVar.b(rVar);
        p pVar = new p(frsFragment.getPageContext(), bj.dri, this.han.getUniqueId());
        pVar.b(rVar);
        this.hhz = new ae(frsFragment.getPageContext(), com.baidu.tieba.tbadkCore.o.kRg, this.han.getUniqueId());
        this.hhJ = new u(frsFragment.getPageContext(), bj.dqY, this.han.getUniqueId());
        this.hhJ.b(rVar);
        com.baidu.adp.widget.ListView.a<? extends bi, ? extends y.a> a = com.baidu.tieba.frs.c.bNL().a(frsFragment.getPageContext(), this.han.getUniqueId(), true);
        com.baidu.adp.widget.ListView.a<? extends bj, ? extends y.a> b = com.baidu.tieba.frs.c.bNL().b(frsFragment.getPageContext(), bj.dsN, this.han.getUniqueId());
        com.baidu.tieba.frs.o oVar = new com.baidu.tieba.frs.o(frsFragment.getPageContext(), com.baidu.tieba.frs.p.hbp);
        l lVar = new l(frsFragment.getPageContext(), com.baidu.tieba.frs.t.hbE);
        ad adVar = new ad(frsFragment.getPageContext(), com.baidu.tieba.frs.u.hbJ, this.han.getUniqueId());
        this.aMj.add(this.hhA);
        this.aMj.add(this.hhB);
        this.aMj.add(this.hhC);
        this.aMj.add(this.hhD);
        this.aMj.add(this.hhE);
        this.aMj.add(this.hhF);
        this.aMj.add(this.hhG);
        this.aMj.add(this.hhH);
        this.aMj.add(this.hhz);
        this.aMj.add(rVar2);
        this.aMj.add(xVar);
        this.aMj.add(aVar);
        this.aMj.add(eVar);
        this.aMj.add(bVar);
        this.aMj.add(hVar);
        this.aMj.add(iVar);
        this.aMj.add(this.hhJ);
        this.aMj.add(this.hhI);
        this.aMj.add(a);
        this.aMj.add(b);
        this.aMj.add(oVar);
        this.aMj.add(lVar);
        this.aMj.add(qVar);
        this.aMj.add(pVar);
        this.aMj.add(adVar);
        this.aMj.add(zVar);
        com.baidu.tieba.InjectPlugin.b.b bVar2 = new com.baidu.tieba.InjectPlugin.b.b(this.han, 1);
        bVar2.setExtraData(this.aMj);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_FEED_AD_PLUGIN_OPERATE, bVar2));
        cr(this.aMj);
        rVar.addAdapters(this.aMj);
        AbsDelegateAdapterList absDelegateAdapterList = new AbsDelegateAdapterList();
        CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_ADD_ADAPTER, absDelegateAdapterList);
        CustomMessage customMessage = new CustomMessage(CmdConfigCustom.CMD_FRS_ADD_ADAPTER);
        customMessage.setTag(this.han.getUniqueId());
        customResponsedMessage.setOrginalMessage(customMessage);
        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
        yf("page_frs");
        if (!absDelegateAdapterList.isEmpty()) {
            Iterator it = absDelegateAdapterList.iterator();
            while (it.hasNext()) {
                com.baidu.adp.widget.ListView.a aVar2 = (com.baidu.adp.widget.ListView.a) it.next();
                if (aVar2 instanceof com.baidu.tieba.frs.h) {
                    ((com.baidu.tieba.frs.h) aVar2).a(this.han.getPageContext(), this.han.getUniqueId());
                }
            }
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(absDelegateAdapterList);
            if (this.aMj != null) {
                this.aMj.addAll(arrayList);
            }
            if (this.gEi != null) {
                this.gEi.addAdapters(arrayList);
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.a.ai
    public void onDestory() {
        for (com.baidu.adp.widget.ListView.a aVar : this.aMj) {
            if (aVar instanceof com.baidu.tieba.frs.h) {
                ((com.baidu.tieba.frs.h) aVar).release();
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.a.ai
    public HashMap<Integer, bj> bRP() {
        return this.hhw;
    }

    @Override // com.baidu.tieba.frs.entelechy.a.ai
    public void notifyDataSetChanged() {
        if (this.gEi.getListAdapter() != null) {
            this.gEi.getListAdapter().notifyDataSetChanged();
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.a.ai
    public int bRQ() {
        if (this.hhA != null) {
            return R.id.frs_bawu_center;
        }
        return 0;
    }

    @Override // com.baidu.tieba.frs.entelechy.a.ai
    public boolean p(BdUniqueId bdUniqueId) {
        if (bdUniqueId == null) {
            return false;
        }
        for (com.baidu.adp.widget.ListView.a aVar : this.aMj) {
            if (aVar != null && aVar.getType() == bdUniqueId) {
                return true;
            }
        }
        return false;
    }

    @Override // com.baidu.tieba.frs.entelechy.a.ai
    public void a(com.baidu.adp.widget.ListView.v vVar) {
        if (this.aMj != null && this.aMj.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.aMj) {
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
        if (this.aMj != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.aMj) {
                if (aVar instanceof com.baidu.tieba.card.x) {
                    ((com.baidu.tieba.card.x) aVar).setForumName(str);
                }
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v1, resolved type: com.baidu.tieba.frs.FrsFragment */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.baidu.tieba.frs.entelechy.a.ai
    public void bRR() {
        if (this.aMj != null && this.aMj.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.aMj) {
                if (aVar instanceof com.baidu.tieba.frs.h) {
                    ((com.baidu.tieba.frs.h) aVar).a(this.han.getPageContext(), this.han.getUniqueId());
                }
            }
            cr(this.aMj);
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.a.ai
    public List<com.baidu.adp.widget.ListView.m> getDatas() {
        if (this.gEi != null) {
            return this.gEi.getData();
        }
        return null;
    }

    @Override // com.baidu.tieba.frs.entelechy.a.ai
    public int bRS() {
        if (this.hhA != null) {
            return R.id.frs_fortune_bag_item;
        }
        return 0;
    }

    @Override // com.baidu.tieba.frs.entelechy.a.ai
    public int bRT() {
        if (this.hhA != null) {
            return R.id.frs_my_service_item;
        }
        return 0;
    }

    public void aBa() {
        if (this.dataList != null) {
            this.gEi.setData(this.dataList);
        }
        notifyDataSetChanged();
    }

    @Override // com.baidu.tieba.frs.entelechy.a.ai
    public void setFromCDN(boolean z) {
        if (this.aMj != null && this.aMj.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.aMj) {
                if (aVar instanceof com.baidu.tieba.frs.h) {
                    ((com.baidu.tieba.frs.h) aVar).setFromCDN(z);
                }
            }
            if (this.hhB != null) {
                this.hhB.setFromCDN(z);
            }
            if (this.hhC != null) {
                this.hhC.setFromCDN(z);
            }
            if (this.hhD != null) {
                this.hhD.setFromCDN(z);
            }
            if (this.hhE != null) {
                this.hhE.setFromCDN(z);
            }
            if (this.hhF != null) {
                this.hhF.setFromCDN(z);
            }
            if (this.hhG != null) {
                this.hhG.setFromCDN(z);
            }
            if (this.hhI != null) {
                this.hhI.setFromCDN(z);
            }
            if (this.hhJ != null) {
                this.hhJ.setFromCDN(z);
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.a.ai
    public void bRU() {
        List<com.baidu.adp.widget.ListView.m> data;
        if (this.gEi != null && this.gEi.getData() != null && this.gEi.getData().size() != 0 && (data = this.gEi.getData()) != null && data.size() != 0) {
            for (com.baidu.adp.widget.ListView.m mVar : data) {
                if (mVar instanceof bj) {
                    if (((bj) mVar).aKx() != 0) {
                        ((bj) mVar).aLx();
                    }
                } else if ((mVar instanceof bi) && ((bi) mVar).dqE.aKx() != 0) {
                    ((bi) mVar).dqE.aLx();
                }
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.a.ai
    public void mX(boolean z) {
        if (this.hhy != z) {
            this.hhy = z;
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.a.ai
    public void b(ArrayList<com.baidu.adp.widget.ListView.m> arrayList, FrsViewData frsViewData) {
        b(frsViewData);
        bQG();
        com.baidu.tieba.tbadkCore.t.q(arrayList, 1);
        ao(arrayList);
        ap(arrayList);
        aq(arrayList);
        Iterator<com.baidu.adp.widget.ListView.m> it = arrayList.iterator();
        while (it.hasNext()) {
            com.baidu.adp.widget.ListView.m next = it.next();
            if ((next instanceof bi) && ((bi) next).dqE.isTop()) {
                it.remove();
            }
        }
        this.gEi.setData(arrayList);
        this.hhx = frsViewData;
        bRk();
        bRW();
        this.dataList = arrayList;
    }

    public void b(FrsViewData frsViewData) {
        if (this.aMj != null && this.aMj.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.aMj) {
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
                if (this.hhw != null && !this.hhw.containsValue(mVar)) {
                    this.hhw.put(Integer.valueOf(i2), (bj) mVar);
                }
            }
            i = i2 + 1;
        }
    }

    private void ap(ArrayList<com.baidu.adp.widget.ListView.m> arrayList) {
        int i;
        if (this.aMj != null && this.aMj.size() != 0) {
            int i2 = 0;
            if (arrayList == null || arrayList.size() <= 0) {
                i = 0;
            } else {
                Iterator<com.baidu.adp.widget.ListView.m> it = arrayList.iterator();
                while (true) {
                    i = i2;
                    if (!it.hasNext() || it.next().getType().getId() != bj.dqH.getId()) {
                        break;
                    }
                    i2 = i + 1;
                }
            }
            for (com.baidu.adp.widget.ListView.a aVar : this.aMj) {
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
                bj bjVar = ((bi) mVar2).dqE;
                if (i == 0) {
                    bjVar.isFirstFloor = true;
                } else {
                    bjVar.isFirstFloor = false;
                }
                String aIv = bjVar.aIv();
                if (mVar instanceof com.baidu.tieba.frs.t) {
                    bjVar.needTopMargin = false;
                } else if (mVar != null && !c(mVar)) {
                    bjVar.needTopMargin = false;
                } else if ((mVar instanceof bi) && c(mVar) && !TextUtils.isEmpty(((bi) mVar).dqE.aIv())) {
                    bjVar.needTopMargin = true;
                } else if (c(mVar2) && !TextUtils.isEmpty(aIv)) {
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
        return type == bj.dqI || type == bj.dqY || type == bj.dqZ || type == bj.drh || type == bj.drq;
    }

    private void bQG() {
        if (!com.baidu.tbadk.core.util.v.isEmpty(this.aMj) && this.han != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.aMj) {
                if (aVar instanceof com.baidu.tieba.frs.h) {
                    ((com.baidu.tieba.frs.h) aVar).a(this.han.getTbPageTag());
                }
            }
        }
    }

    private void bRk() {
        com.baidu.tieba.frs.d.b statisticMetaData;
        if (this.hhx != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.aMj) {
                if ((aVar instanceof com.baidu.tieba.frs.d.d) && (statisticMetaData = ((com.baidu.tieba.frs.d.d) aVar).getStatisticMetaData()) != null) {
                    if (this.hhx.needLog == 1) {
                        statisticMetaData.hua = true;
                    } else {
                        statisticMetaData.hua = false;
                    }
                    if (this.hhx.getForum() != null) {
                        statisticMetaData.huc = this.hhx.getForum().getId();
                    }
                    if (this.han != null && this.han.bOq() != null) {
                        statisticMetaData.hub = this.han.bOq().bTY();
                    }
                }
            }
            bRV();
        }
    }

    private void bRV() {
        com.baidu.tieba.frs.d.b bVar = new com.baidu.tieba.frs.d.b();
        if (this.hhx.needLog == 1) {
            bVar.hua = true;
        } else {
            bVar.hua = false;
        }
        if (this.hhx.getForum() != null) {
            bVar.huc = this.hhx.getForum().getId();
        }
        if (this.han != null && this.han.bOq() != null) {
            bVar.hub = this.han.bOq().bTY();
        }
        if (com.baidu.tieba.frs.d.d.hgM != null) {
            bVar.hud = com.baidu.tieba.frs.d.d.hgM.hud;
            bVar.hue = com.baidu.tieba.frs.d.d.hgM.hue;
        }
        if (this.han != null) {
            com.baidu.tieba.frs.live.b bVar2 = new com.baidu.tieba.frs.live.b(bVar, this.han.getTbPageTag(), this.han.getUniqueId());
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

    private void bRW() {
        if (this.hhx != null && this.hhx.getForum() != null && !StringUtils.isNull(this.hhx.getForum().getId()) && this.hhz != null) {
            this.hhz.setForumId(this.hhx.getForum().getId());
        }
    }

    private void cr(List<com.baidu.adp.widget.ListView.a> list) {
        if (list != null) {
            for (com.baidu.adp.widget.ListView.a aVar : list) {
                if (aVar instanceof com.baidu.tieba.frs.h) {
                    ((com.baidu.tieba.frs.h) aVar).a(this.gXX);
                }
            }
        }
    }

    private void yf(String str) {
        if (this.aMj != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.aMj) {
                if (aVar instanceof com.baidu.tieba.a.f) {
                    ((com.baidu.tieba.a.f) aVar).yf(str);
                }
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.a.ai
    public void a(com.baidu.tieba.frs.d dVar) {
        if (this.aMj != null && this.aMj.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.aMj) {
                if (aVar instanceof com.baidu.tieba.frs.h) {
                    ((com.baidu.tieba.frs.h) aVar).a(dVar);
                }
            }
        }
    }
}
