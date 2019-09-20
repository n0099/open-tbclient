package com.baidu.tieba.frs.entelechy.a;

import android.text.TextUtils;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.v;
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
    private final HashMap<Integer, bh> fEU;
    private FrsViewData fEV;
    private r fEX;
    private g fEY;
    private o fEZ;
    private m fFa;
    private f fFb;
    private h fFc;
    private p fFd;
    private s fFe;
    private x fFf;
    private com.baidu.adp.widget.ListView.a fFg;
    private n fFh;
    private com.baidu.adp.widget.ListView.r faT;
    private FrsFragment fxT;
    private List<com.baidu.adp.widget.ListView.a> mAdapters = new LinkedList();
    private boolean fEW = false;
    private final com.baidu.tieba.frs.f fvH = new com.baidu.tieba.frs.f();

    public l(FrsFragment frsFragment, com.baidu.adp.widget.ListView.r rVar, boolean z) {
        this.faT = rVar;
        a(frsFragment, rVar);
        this.fEU = new HashMap<>();
        kB(z);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r3v29, resolved type: com.baidu.tieba.frs.FrsFragment */
    /* JADX WARN: Multi-variable type inference failed */
    public void a(FrsFragment frsFragment, com.baidu.adp.widget.ListView.r rVar) {
        this.fxT = frsFragment;
        this.fFg = com.baidu.tieba.frs.c.bmc().a(frsFragment.getPageContext(), com.baidu.tieba.tbadkCore.u.jhv, this.fxT.getUniqueId(), false);
        this.fEX = new r(frsFragment.getTbPageContext(), bh.bJQ, this.fxT.getUniqueId());
        this.fEX.a(rVar);
        this.fEX.setInFrsAllThread(true);
        this.fEY = new g(frsFragment.getTbPageContext(), bh.bJR, this.fxT.getUniqueId());
        this.fEY.a(rVar);
        this.fEZ = new o(frsFragment.getTbPageContext(), bh.bJT, this.fxT.getUniqueId());
        this.fEZ.a(rVar);
        this.fFa = new m(frsFragment.getTbPageContext(), bh.bJU, this.fxT.getUniqueId());
        this.fFa.a(rVar);
        this.fFb = new f(frsFragment.getTbPageContext(), bh.bJV, this.fxT.getUniqueId());
        this.fFb.a(rVar);
        this.fFc = new h(frsFragment.getTbPageContext(), bh.bJW, this.fxT.getUniqueId());
        this.fFc.a(rVar);
        this.fFd = new p(frsFragment.getTbPageContext(), bh.bKk, this.fxT.getUniqueId());
        this.fFd.a(rVar);
        this.fFe = new s(frsFragment.getPageContext(), bh.bKa, this.fxT.getUniqueId());
        this.fFe.setInFrsAllThread(true);
        this.fFe.a(rVar);
        k kVar = new k(frsFragment.getPageContext(), bh.bJY, this.fxT.getUniqueId());
        kVar.a(rVar);
        kVar.setInFrsAllThread(true);
        q qVar = new q(frsFragment.getPageContext(), bh.bKe, this.fxT.getUniqueId());
        qVar.a(rVar);
        qVar.setInFrsAllThread(true);
        s sVar = new s(frsFragment.getPageContext(), bh.bKf, this.fxT.getUniqueId());
        sVar.a(rVar);
        sVar.setInFrsAllThread(true);
        j jVar = new j(frsFragment.getPageContext(), bh.bKo, this.fxT.getUniqueId());
        jVar.a(rVar);
        i iVar = new i(frsFragment.getPageContext(), bh.bKg, this.fxT.getUniqueId());
        iVar.a(rVar);
        this.fFf = new x(frsFragment.getPageContext().getPageActivity(), com.baidu.tieba.tbadkCore.n.jhn, this.fxT.getUniqueId());
        this.fFh = new n(frsFragment.getPageContext(), bh.bJZ, this.fxT.getUniqueId());
        this.fFh.a(rVar);
        this.fFh.setVoiceManager(frsFragment.getVoiceManager());
        this.fFh.setInFrsAllThread(true);
        com.baidu.adp.widget.ListView.a<? extends bg, ? extends v.a> a = com.baidu.tieba.frs.c.bmc().a(frsFragment.getPageContext(), this.fxT.getUniqueId(), true);
        com.baidu.adp.widget.ListView.a<? extends bh, ? extends v.a> b = com.baidu.tieba.frs.c.bmc().b(frsFragment.getPageContext(), bh.bLG, this.fxT.getUniqueId());
        com.baidu.tieba.frs.l lVar = new com.baidu.tieba.frs.l(frsFragment.getPageContext(), com.baidu.tieba.frs.m.fyV);
        e eVar = new e(frsFragment.getPageContext(), com.baidu.tieba.frs.p.fzj);
        w wVar = new w(frsFragment.getPageContext(), com.baidu.tieba.frs.q.fzo, this.fxT.getUniqueId());
        this.mAdapters.add(this.fFg);
        this.mAdapters.add(this.fEX);
        this.mAdapters.add(this.fEY);
        this.mAdapters.add(this.fEZ);
        this.mAdapters.add(this.fFa);
        this.mAdapters.add(this.fFb);
        this.mAdapters.add(this.fFc);
        this.mAdapters.add(this.fFd);
        this.mAdapters.add(this.fFf);
        this.mAdapters.add(kVar);
        this.mAdapters.add(qVar);
        this.mAdapters.add(this.fFh);
        this.mAdapters.add(this.fFe);
        this.mAdapters.add(a);
        this.mAdapters.add(b);
        this.mAdapters.add(lVar);
        this.mAdapters.add(eVar);
        this.mAdapters.add(jVar);
        this.mAdapters.add(iVar);
        this.mAdapters.add(wVar);
        this.mAdapters.add(sVar);
        com.baidu.tieba.InjectPlugin.b.b bVar = new com.baidu.tieba.InjectPlugin.b.b(this.fxT, 1);
        bVar.setExtraData(this.mAdapters);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016515, bVar));
        ca(this.mAdapters);
        rVar.addAdapters(this.mAdapters);
        AbsDelegateAdapterList absDelegateAdapterList = new AbsDelegateAdapterList();
        CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2003008, absDelegateAdapterList);
        CustomMessage customMessage = new CustomMessage(2003008);
        customMessage.setTag(this.fxT.getUniqueId());
        customResponsedMessage.setOrginalMessage(customMessage);
        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
        sy("page_frs");
        if (!absDelegateAdapterList.isEmpty()) {
            Iterator it = absDelegateAdapterList.iterator();
            while (it.hasNext()) {
                com.baidu.adp.widget.ListView.a aVar = (com.baidu.adp.widget.ListView.a) it.next();
                if (aVar instanceof com.baidu.tieba.frs.h) {
                    ((com.baidu.tieba.frs.h) aVar).a(this.fxT.getPageContext(), this.fxT.getUniqueId());
                }
            }
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(absDelegateAdapterList);
            if (this.mAdapters != null) {
                this.mAdapters.addAll(arrayList);
            }
            if (this.faT != null) {
                this.faT.addAdapters(arrayList);
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.a.aa
    public void onDestory() {
        for (com.baidu.adp.widget.ListView.a aVar : this.mAdapters) {
            if (aVar instanceof com.baidu.tieba.frs.h) {
                ((com.baidu.tieba.frs.h) aVar).release();
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.a.aa
    public HashMap<Integer, bh> bpT() {
        return this.fEU;
    }

    @Override // com.baidu.tieba.frs.entelechy.a.aa
    public void notifyDataSetChanged() {
        if (this.faT.getListAdapter() != null) {
            this.faT.getListAdapter().notifyDataSetChanged();
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.a.aa
    public int bpU() {
        if (this.fFg != null) {
            return R.id.frs_bawu_center;
        }
        return 0;
    }

    @Override // com.baidu.tieba.frs.entelechy.a.aa
    public boolean n(BdUniqueId bdUniqueId) {
        if (bdUniqueId == null) {
            return false;
        }
        for (com.baidu.adp.widget.ListView.a aVar : this.mAdapters) {
            if (aVar != null && aVar.getType() == bdUniqueId) {
                return true;
            }
        }
        return false;
    }

    @Override // com.baidu.tieba.frs.entelechy.a.aa
    public void setOnAdapterItemClickListener(com.baidu.adp.widget.ListView.s sVar) {
        if (this.mAdapters != null && this.mAdapters.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.mAdapters) {
                if (aVar instanceof com.baidu.tieba.frs.h) {
                    ((com.baidu.tieba.frs.h) aVar).setOnAdapterItemClickListener(sVar);
                } else if ((aVar instanceof n) || (aVar instanceof s)) {
                    aVar.setOnAdapterItemClickListener(sVar);
                }
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.a.aa
    public void setForumName(String str) {
        if (this.mAdapters != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.mAdapters) {
                if (aVar instanceof com.baidu.tieba.card.z) {
                    ((com.baidu.tieba.card.z) aVar).setForumName(str);
                }
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v1, resolved type: com.baidu.tieba.frs.FrsFragment */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.baidu.tieba.frs.entelechy.a.aa
    public void bpV() {
        if (this.mAdapters != null && this.mAdapters.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.mAdapters) {
                if (aVar instanceof com.baidu.tieba.frs.h) {
                    ((com.baidu.tieba.frs.h) aVar).a(this.fxT.getPageContext(), this.fxT.getUniqueId());
                }
            }
            ca(this.mAdapters);
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.a.aa
    public List<com.baidu.adp.widget.ListView.m> getDatas() {
        if (this.faT != null) {
            return this.faT.getData();
        }
        return null;
    }

    @Override // com.baidu.tieba.frs.entelechy.a.aa
    public int bpW() {
        if (this.fFg != null) {
            return R.id.frs_fortune_bag_item;
        }
        return 0;
    }

    @Override // com.baidu.tieba.frs.entelechy.a.aa
    public int bpX() {
        if (this.fFg != null) {
            return R.id.frs_my_service_item;
        }
        return 0;
    }

    public void Wb() {
        if (this.dataList != null) {
            this.faT.setData(this.dataList);
        }
        notifyDataSetChanged();
    }

    @Override // com.baidu.tieba.frs.entelechy.a.aa
    public void setFromCDN(boolean z) {
        if (this.mAdapters != null && this.mAdapters.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.mAdapters) {
                if (aVar instanceof com.baidu.tieba.frs.h) {
                    ((com.baidu.tieba.frs.h) aVar).setFromCDN(z);
                }
            }
            if (this.fEX != null) {
                this.fEX.setFromCDN(z);
            }
            if (this.fEY != null) {
                this.fEY.setFromCDN(z);
            }
            if (this.fEZ != null) {
                this.fEZ.setFromCDN(z);
            }
            if (this.fFa != null) {
                this.fFa.setFromCDN(z);
            }
            if (this.fFb != null) {
                this.fFb.setFromCDN(z);
            }
            if (this.fFc != null) {
                this.fFc.setFromCDN(z);
            }
            if (this.fFe != null) {
                this.fFe.setFromCDN(z);
            }
            if (this.fFh != null) {
                this.fFh.setFromCDN(z);
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.a.aa
    public void bpY() {
        List<com.baidu.adp.widget.ListView.m> data;
        if (this.faT != null && this.faT.getData() != null && this.faT.getData().size() != 0 && (data = this.faT.getData()) != null && data.size() != 0) {
            for (com.baidu.adp.widget.ListView.m mVar : data) {
                if (mVar instanceof bh) {
                    if (((bh) mVar).aex() != 0) {
                        ((bh) mVar).afs();
                    }
                } else if ((mVar instanceof bg) && ((bg) mVar).threadData.aex() != 0) {
                    ((bg) mVar).threadData.afs();
                }
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.a.aa
    public void kB(boolean z) {
        if (this.fEW != z) {
            this.fEW = z;
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.a.aa
    public void b(ArrayList<com.baidu.adp.widget.ListView.m> arrayList, FrsViewData frsViewData) {
        b(frsViewData);
        com.baidu.tieba.tbadkCore.s.p(arrayList, 1);
        W(arrayList);
        X(arrayList);
        Y(arrayList);
        Iterator<com.baidu.adp.widget.ListView.m> it = arrayList.iterator();
        while (it.hasNext()) {
            com.baidu.adp.widget.ListView.m next = it.next();
            if ((next instanceof bg) && ((bg) next).threadData.afj()) {
                it.remove();
            }
        }
        this.faT.setData(arrayList);
        this.fEV = frsViewData;
        bpu();
        bqa();
        this.dataList = arrayList;
    }

    public void b(FrsViewData frsViewData) {
        if (this.mAdapters != null && this.mAdapters.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.mAdapters) {
                if (aVar instanceof com.baidu.tieba.frs.h) {
                    ((com.baidu.tieba.frs.h) aVar).b(frsViewData);
                }
            }
        }
    }

    private ArrayList<Integer> W(ArrayList<com.baidu.adp.widget.ListView.m> arrayList) {
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
                if (this.fEU != null && !this.fEU.containsValue(mVar)) {
                    this.fEU.put(Integer.valueOf(i2), (bh) mVar);
                }
            }
            i = i2 + 1;
        }
    }

    private void X(ArrayList<com.baidu.adp.widget.ListView.m> arrayList) {
        int i;
        if (this.mAdapters != null && this.mAdapters.size() != 0) {
            int i2 = 0;
            if (arrayList == null || arrayList.size() <= 0) {
                i = 0;
            } else {
                Iterator<com.baidu.adp.widget.ListView.m> it = arrayList.iterator();
                while (true) {
                    i = i2;
                    if (!it.hasNext() || it.next().getType().getId() != bh.bJL.getId()) {
                        break;
                    }
                    i2 = i + 1;
                }
            }
            for (com.baidu.adp.widget.ListView.a aVar : this.mAdapters) {
                if (aVar instanceof com.baidu.tieba.frs.h) {
                    ((com.baidu.tieba.frs.h) aVar).rr(i);
                }
            }
        }
    }

    private void Y(ArrayList<com.baidu.adp.widget.ListView.m> arrayList) {
        int Z = com.baidu.tbadk.core.util.v.Z(arrayList);
        for (int i = 0; i < Z; i++) {
            com.baidu.adp.widget.ListView.m mVar = (com.baidu.adp.widget.ListView.m) com.baidu.tbadk.core.util.v.c(arrayList, i - 1);
            com.baidu.adp.widget.ListView.m mVar2 = (com.baidu.adp.widget.ListView.m) com.baidu.tbadk.core.util.v.c(arrayList, i);
            if (mVar2 instanceof bg) {
                bh bhVar = ((bg) mVar2).threadData;
                if (i == 0) {
                    bhVar.isFirstFloor = true;
                } else {
                    bhVar.isFirstFloor = false;
                }
                String acD = bhVar.acD();
                if (mVar instanceof com.baidu.tieba.frs.p) {
                    bhVar.needTopMargin = false;
                } else if (mVar != null && !d(mVar)) {
                    bhVar.needTopMargin = false;
                } else if ((mVar instanceof bg) && d(mVar) && !TextUtils.isEmpty(((bg) mVar).threadData.acD())) {
                    bhVar.needTopMargin = true;
                } else if (d(mVar2) && !TextUtils.isEmpty(acD)) {
                    bhVar.needTopMargin = true;
                } else {
                    bhVar.needTopMargin = false;
                }
            }
        }
    }

    private boolean d(com.baidu.adp.widget.ListView.m mVar) {
        if (mVar == null) {
            return false;
        }
        BdUniqueId type = mVar.getType();
        return type == bh.bJM || type == bh.bJZ || type == bh.bKa || type == bh.bKf || type == bh.bKo;
    }

    private void bpu() {
        com.baidu.tieba.frs.d.b bpS;
        if (this.fEV != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.mAdapters) {
                if ((aVar instanceof com.baidu.tieba.frs.d.d) && (bpS = ((com.baidu.tieba.frs.d.d) aVar).bpS()) != null) {
                    if (this.fEV.needLog == 1) {
                        bpS.fRi = true;
                    } else {
                        bpS.fRi = false;
                    }
                    if (this.fEV.getForum() != null) {
                        bpS.fRk = this.fEV.getForum().getId();
                    }
                    if (this.fxT != null && this.fxT.bmE() != null) {
                        bpS.fRj = this.fxT.bmE().bsl();
                    }
                }
            }
            bpZ();
        }
    }

    private void bpZ() {
        com.baidu.tieba.frs.d.b bVar = new com.baidu.tieba.frs.d.b();
        if (this.fEV.needLog == 1) {
            bVar.fRi = true;
        } else {
            bVar.fRi = false;
        }
        if (this.fEV.getForum() != null) {
            bVar.fRk = this.fEV.getForum().getId();
        }
        if (this.fxT != null && this.fxT.bmE() != null) {
            bVar.fRj = this.fxT.bmE().bsl();
        }
        if (com.baidu.tieba.frs.d.d.fEI != null) {
            bVar.fRl = com.baidu.tieba.frs.d.d.fEI.fRl;
            bVar.fRm = com.baidu.tieba.frs.d.d.fEI.fRm;
        }
        com.baidu.tieba.frs.live.b bVar2 = new com.baidu.tieba.frs.live.b(bVar, this.fxT.getUniqueId());
        CustomMessageTask customMessageTask = new CustomMessageTask(2921018, bVar2);
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
        CustomMessageTask customMessageTask2 = new CustomMessageTask(2921017, bVar2);
        customMessageTask2.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask2);
        CustomMessageTask customMessageTask3 = new CustomMessageTask(2921016, bVar2);
        customMessageTask3.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask3);
        CustomMessageTask customMessageTask4 = new CustomMessageTask(2921019, bVar2);
        customMessageTask4.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask4);
    }

    private void bqa() {
        if (this.fEV != null && this.fEV.getForum() != null && !StringUtils.isNull(this.fEV.getForum().getId()) && this.fFf != null) {
            this.fFf.setForumId(this.fEV.getForum().getId());
        }
    }

    private void ca(List<com.baidu.adp.widget.ListView.a> list) {
        if (list != null) {
            for (com.baidu.adp.widget.ListView.a aVar : list) {
                if (aVar instanceof com.baidu.tieba.frs.h) {
                    ((com.baidu.tieba.frs.h) aVar).a(this.fvH);
                }
            }
        }
    }

    private void sy(String str) {
        if (this.mAdapters != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.mAdapters) {
                if (aVar instanceof com.baidu.tieba.a.f) {
                    ((com.baidu.tieba.a.f) aVar).sy(str);
                }
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.a.aa
    public void a(com.baidu.tieba.frs.d dVar) {
        if (this.mAdapters != null && this.mAdapters.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.mAdapters) {
                if (aVar instanceof com.baidu.tieba.frs.h) {
                    ((com.baidu.tieba.frs.h) aVar).a(dVar);
                }
            }
        }
    }
}
