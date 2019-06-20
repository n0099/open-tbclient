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
import com.baidu.tbadk.core.data.bf;
import com.baidu.tbadk.core.data.bg;
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
    private ArrayList<com.baidu.adp.widget.ListView.m> bNt;
    private com.baidu.adp.widget.ListView.r eTY;
    private FrsFragment fqJ;
    private r fxA;
    private g fxB;
    private o fxC;
    private m fxD;
    private f fxE;
    private h fxF;
    private p fxG;
    private s fxH;
    private x fxI;
    private com.baidu.adp.widget.ListView.a fxJ;
    private n fxK;
    private final HashMap<Integer, bg> fxx;
    private FrsViewData fxy;
    private List<com.baidu.adp.widget.ListView.a> mAdapters = new LinkedList();
    private boolean fxz = false;
    private final com.baidu.tieba.frs.f fow = new com.baidu.tieba.frs.f();

    public l(FrsFragment frsFragment, com.baidu.adp.widget.ListView.r rVar, boolean z) {
        this.eTY = rVar;
        a(frsFragment, rVar);
        this.fxx = new HashMap<>();
        ko(z);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r3v29, resolved type: com.baidu.tieba.frs.FrsFragment */
    /* JADX WARN: Multi-variable type inference failed */
    public void a(FrsFragment frsFragment, com.baidu.adp.widget.ListView.r rVar) {
        this.fqJ = frsFragment;
        this.fxJ = com.baidu.tieba.frs.c.bji().a(frsFragment.getPageContext(), com.baidu.tieba.tbadkCore.s.iXC, this.fqJ.getUniqueId(), false);
        this.fxA = new r(frsFragment.getTbPageContext(), bg.bIn, this.fqJ.getUniqueId());
        this.fxA.a(rVar);
        this.fxA.setInFrsAllThread(true);
        this.fxB = new g(frsFragment.getTbPageContext(), bg.bIo, this.fqJ.getUniqueId());
        this.fxB.a(rVar);
        this.fxC = new o(frsFragment.getTbPageContext(), bg.bIq, this.fqJ.getUniqueId());
        this.fxC.a(rVar);
        this.fxD = new m(frsFragment.getTbPageContext(), bg.bIr, this.fqJ.getUniqueId());
        this.fxD.a(rVar);
        this.fxE = new f(frsFragment.getTbPageContext(), bg.bIs, this.fqJ.getUniqueId());
        this.fxE.a(rVar);
        this.fxF = new h(frsFragment.getTbPageContext(), bg.bIt, this.fqJ.getUniqueId());
        this.fxF.a(rVar);
        this.fxG = new p(frsFragment.getTbPageContext(), bg.bIH, this.fqJ.getUniqueId());
        this.fxG.a(rVar);
        this.fxH = new s(frsFragment.getPageContext(), bg.bIx, this.fqJ.getUniqueId());
        this.fxH.setInFrsAllThread(true);
        this.fxH.a(rVar);
        k kVar = new k(frsFragment.getPageContext(), bg.bIv, this.fqJ.getUniqueId());
        kVar.a(rVar);
        kVar.setInFrsAllThread(true);
        q qVar = new q(frsFragment.getPageContext(), bg.bIB, this.fqJ.getUniqueId());
        qVar.a(rVar);
        qVar.setInFrsAllThread(true);
        s sVar = new s(frsFragment.getPageContext(), bg.bIC, this.fqJ.getUniqueId());
        sVar.a(rVar);
        sVar.setInFrsAllThread(true);
        j jVar = new j(frsFragment.getPageContext(), bg.bIL, this.fqJ.getUniqueId());
        jVar.a(rVar);
        i iVar = new i(frsFragment.getPageContext(), bg.bID, this.fqJ.getUniqueId());
        iVar.a(rVar);
        this.fxI = new x(frsFragment.getPageContext().getPageActivity(), com.baidu.tieba.tbadkCore.l.iXu, this.fqJ.getUniqueId());
        this.fxK = new n(frsFragment.getPageContext(), bg.bIw, this.fqJ.getUniqueId());
        this.fxK.a(rVar);
        this.fxK.setVoiceManager(frsFragment.getVoiceManager());
        this.fxK.setInFrsAllThread(true);
        com.baidu.adp.widget.ListView.a<? extends bf, ? extends v.a> a = com.baidu.tieba.frs.c.bji().a(frsFragment.getPageContext(), this.fqJ.getUniqueId(), true);
        com.baidu.adp.widget.ListView.a<? extends bg, ? extends v.a> b = com.baidu.tieba.frs.c.bji().b(frsFragment.getPageContext(), bg.bKd, this.fqJ.getUniqueId());
        com.baidu.tieba.frs.l lVar = new com.baidu.tieba.frs.l(frsFragment.getPageContext(), com.baidu.tieba.frs.m.frM);
        e eVar = new e(frsFragment.getPageContext(), com.baidu.tieba.frs.p.fsb);
        w wVar = new w(frsFragment.getPageContext(), com.baidu.tieba.frs.q.fsg, this.fqJ.getUniqueId());
        this.mAdapters.add(this.fxJ);
        this.mAdapters.add(this.fxA);
        this.mAdapters.add(this.fxB);
        this.mAdapters.add(this.fxC);
        this.mAdapters.add(this.fxD);
        this.mAdapters.add(this.fxE);
        this.mAdapters.add(this.fxF);
        this.mAdapters.add(this.fxG);
        this.mAdapters.add(this.fxI);
        this.mAdapters.add(kVar);
        this.mAdapters.add(qVar);
        this.mAdapters.add(this.fxK);
        this.mAdapters.add(this.fxH);
        this.mAdapters.add(a);
        this.mAdapters.add(b);
        this.mAdapters.add(lVar);
        this.mAdapters.add(eVar);
        this.mAdapters.add(jVar);
        this.mAdapters.add(iVar);
        this.mAdapters.add(wVar);
        this.mAdapters.add(sVar);
        com.baidu.tieba.InjectPlugin.b.b bVar = new com.baidu.tieba.InjectPlugin.b.b(this.fqJ, 1);
        bVar.setExtraData(this.mAdapters);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016515, bVar));
        ca(this.mAdapters);
        rVar.addAdapters(this.mAdapters);
        AbsDelegateAdapterList absDelegateAdapterList = new AbsDelegateAdapterList();
        CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2003008, absDelegateAdapterList);
        CustomMessage customMessage = new CustomMessage(2003008);
        customMessage.setTag(this.fqJ.getUniqueId());
        customResponsedMessage.setOrginalMessage(customMessage);
        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
        rU("page_frs");
        if (!absDelegateAdapterList.isEmpty()) {
            Iterator it = absDelegateAdapterList.iterator();
            while (it.hasNext()) {
                com.baidu.adp.widget.ListView.a aVar = (com.baidu.adp.widget.ListView.a) it.next();
                if (aVar instanceof com.baidu.tieba.frs.h) {
                    ((com.baidu.tieba.frs.h) aVar).a(this.fqJ.getPageContext(), this.fqJ.getUniqueId());
                }
            }
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(absDelegateAdapterList);
            if (this.mAdapters != null) {
                this.mAdapters.addAll(arrayList);
            }
            if (this.eTY != null) {
                this.eTY.addAdapters(arrayList);
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
    public HashMap<Integer, bg> bmU() {
        return this.fxx;
    }

    @Override // com.baidu.tieba.frs.entelechy.a.aa
    public void notifyDataSetChanged() {
        if (this.eTY.getListAdapter() != null) {
            this.eTY.getListAdapter().notifyDataSetChanged();
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.a.aa
    public int bmV() {
        if (this.fxJ != null) {
            return R.id.frs_bawu_center;
        }
        return 0;
    }

    @Override // com.baidu.tieba.frs.entelechy.a.aa
    public boolean m(BdUniqueId bdUniqueId) {
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
    public void bmW() {
        if (this.mAdapters != null && this.mAdapters.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.mAdapters) {
                if (aVar instanceof com.baidu.tieba.frs.h) {
                    ((com.baidu.tieba.frs.h) aVar).a(this.fqJ.getPageContext(), this.fqJ.getUniqueId());
                }
            }
            ca(this.mAdapters);
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.a.aa
    public List<com.baidu.adp.widget.ListView.m> getDatas() {
        if (this.eTY != null) {
            return this.eTY.getData();
        }
        return null;
    }

    @Override // com.baidu.tieba.frs.entelechy.a.aa
    public int bmX() {
        if (this.fxJ != null) {
            return R.id.frs_fortune_bag_item;
        }
        return 0;
    }

    @Override // com.baidu.tieba.frs.entelechy.a.aa
    public int bmY() {
        if (this.fxJ != null) {
            return R.id.frs_my_service_item;
        }
        return 0;
    }

    public void Ve() {
        if (this.bNt != null) {
            this.eTY.setData(this.bNt);
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
            if (this.fxA != null) {
                this.fxA.setFromCDN(z);
            }
            if (this.fxB != null) {
                this.fxB.setFromCDN(z);
            }
            if (this.fxC != null) {
                this.fxC.setFromCDN(z);
            }
            if (this.fxD != null) {
                this.fxD.setFromCDN(z);
            }
            if (this.fxE != null) {
                this.fxE.setFromCDN(z);
            }
            if (this.fxF != null) {
                this.fxF.setFromCDN(z);
            }
            if (this.fxH != null) {
                this.fxH.setFromCDN(z);
            }
            if (this.fxK != null) {
                this.fxK.setFromCDN(z);
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.a.aa
    public void bmZ() {
        List<com.baidu.adp.widget.ListView.m> data;
        if (this.eTY != null && this.eTY.getData() != null && this.eTY.getData().size() != 0 && (data = this.eTY.getData()) != null && data.size() != 0) {
            for (com.baidu.adp.widget.ListView.m mVar : data) {
                if (mVar instanceof bg) {
                    if (((bg) mVar).adq() != 0) {
                        ((bg) mVar).ael();
                    }
                } else if ((mVar instanceof bf) && ((bf) mVar).threadData.adq() != 0) {
                    ((bf) mVar).threadData.ael();
                }
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.a.aa
    public void ko(boolean z) {
        if (this.fxz != z) {
            this.fxz = z;
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.a.aa
    public void b(ArrayList<com.baidu.adp.widget.ListView.m> arrayList, FrsViewData frsViewData) {
        b(frsViewData);
        com.baidu.tieba.tbadkCore.q.p(arrayList, 1);
        W(arrayList);
        X(arrayList);
        Y(arrayList);
        Iterator<com.baidu.adp.widget.ListView.m> it = arrayList.iterator();
        while (it.hasNext()) {
            com.baidu.adp.widget.ListView.m next = it.next();
            if ((next instanceof bf) && ((bf) next).threadData.aec()) {
                it.remove();
            }
        }
        this.eTY.setData(arrayList);
        this.fxy = frsViewData;
        bmv();
        bnb();
        this.bNt = arrayList;
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
                if (this.fxx != null && !this.fxx.containsValue(mVar)) {
                    this.fxx.put(Integer.valueOf(i2), (bg) mVar);
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
                    if (!it.hasNext() || it.next().getType().getId() != bg.bIi.getId()) {
                        break;
                    }
                    i2 = i + 1;
                }
            }
            for (com.baidu.adp.widget.ListView.a aVar : this.mAdapters) {
                if (aVar instanceof com.baidu.tieba.frs.h) {
                    ((com.baidu.tieba.frs.h) aVar).qU(i);
                }
            }
        }
    }

    private void Y(ArrayList<com.baidu.adp.widget.ListView.m> arrayList) {
        int Z = com.baidu.tbadk.core.util.v.Z(arrayList);
        for (int i = 0; i < Z; i++) {
            com.baidu.adp.widget.ListView.m mVar = (com.baidu.adp.widget.ListView.m) com.baidu.tbadk.core.util.v.c(arrayList, i - 1);
            com.baidu.adp.widget.ListView.m mVar2 = (com.baidu.adp.widget.ListView.m) com.baidu.tbadk.core.util.v.c(arrayList, i);
            if (mVar2 instanceof bf) {
                bg bgVar = ((bf) mVar2).threadData;
                if (i == 0) {
                    bgVar.isFirstFloor = true;
                } else {
                    bgVar.isFirstFloor = false;
                }
                String abw = bgVar.abw();
                if (mVar instanceof com.baidu.tieba.frs.p) {
                    bgVar.needTopMargin = false;
                } else if (mVar != null && !d(mVar)) {
                    bgVar.needTopMargin = false;
                } else if ((mVar instanceof bf) && d(mVar) && !TextUtils.isEmpty(((bf) mVar).threadData.abw())) {
                    bgVar.needTopMargin = true;
                } else if (d(mVar2) && !TextUtils.isEmpty(abw)) {
                    bgVar.needTopMargin = true;
                } else {
                    bgVar.needTopMargin = false;
                }
            }
        }
    }

    private boolean d(com.baidu.adp.widget.ListView.m mVar) {
        if (mVar == null) {
            return false;
        }
        BdUniqueId type = mVar.getType();
        return type == bg.bIj || type == bg.bIw || type == bg.bIx || type == bg.bIC || type == bg.bIL;
    }

    private void bmv() {
        com.baidu.tieba.frs.d.b bmT;
        if (this.fxy != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.mAdapters) {
                if ((aVar instanceof com.baidu.tieba.frs.d.d) && (bmT = ((com.baidu.tieba.frs.d.d) aVar).bmT()) != null) {
                    if (this.fxy.needLog == 1) {
                        bmT.fJF = true;
                    } else {
                        bmT.fJF = false;
                    }
                    if (this.fxy.getForum() != null) {
                        bmT.fJH = this.fxy.getForum().getId();
                    }
                    if (this.fqJ != null && this.fqJ.bjK() != null) {
                        bmT.fJG = this.fqJ.bjK().bpl();
                    }
                }
            }
            bna();
        }
    }

    private void bna() {
        com.baidu.tieba.frs.d.b bVar = new com.baidu.tieba.frs.d.b();
        if (this.fxy.needLog == 1) {
            bVar.fJF = true;
        } else {
            bVar.fJF = false;
        }
        if (this.fxy.getForum() != null) {
            bVar.fJH = this.fxy.getForum().getId();
        }
        if (this.fqJ != null && this.fqJ.bjK() != null) {
            bVar.fJG = this.fqJ.bjK().bpl();
        }
        if (com.baidu.tieba.frs.d.d.fxl != null) {
            bVar.fJI = com.baidu.tieba.frs.d.d.fxl.fJI;
            bVar.fJJ = com.baidu.tieba.frs.d.d.fxl.fJJ;
        }
        com.baidu.tieba.frs.live.b bVar2 = new com.baidu.tieba.frs.live.b(bVar, this.fqJ.getUniqueId());
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

    private void bnb() {
        if (this.fxy != null && this.fxy.getForum() != null && !StringUtils.isNull(this.fxy.getForum().getId()) && this.fxI != null) {
            this.fxI.setForumId(this.fxy.getForum().getId());
        }
    }

    private void ca(List<com.baidu.adp.widget.ListView.a> list) {
        if (list != null) {
            for (com.baidu.adp.widget.ListView.a aVar : list) {
                if (aVar instanceof com.baidu.tieba.frs.h) {
                    ((com.baidu.tieba.frs.h) aVar).a(this.fow);
                }
            }
        }
    }

    private void rU(String str) {
        if (this.mAdapters != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.mAdapters) {
                if (aVar instanceof com.baidu.tieba.a.f) {
                    ((com.baidu.tieba.a.f) aVar).rU(str);
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
