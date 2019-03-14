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
import com.baidu.tieba.d;
import com.baidu.tieba.frs.AbsDelegateAdapterList;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.tbadkCore.FrsViewData;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes4.dex */
public class l implements z {
    private ArrayList<com.baidu.adp.widget.ListView.m> bFP;
    private com.baidu.adp.widget.ListView.r eEr;
    private FrsFragment faG;
    private w fhA;
    private com.baidu.adp.widget.ListView.a fhB;
    private n fhC;
    private final HashMap<Integer, bg> fhq;
    private FrsViewData fhr;
    private q fht;
    private g fhu;
    private o fhv;
    private m fhw;
    private f fhx;
    private h fhy;
    private r fhz;
    private List<com.baidu.adp.widget.ListView.a> mAdapters = new LinkedList();
    private boolean fhs = false;
    private final com.baidu.tieba.frs.f eYy = new com.baidu.tieba.frs.f();

    public l(FrsFragment frsFragment, com.baidu.adp.widget.ListView.r rVar, boolean z) {
        this.eEr = rVar;
        a(frsFragment, rVar);
        this.fhq = new HashMap<>();
        jC(z);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r3v28, resolved type: com.baidu.tieba.frs.FrsFragment */
    /* JADX WARN: Multi-variable type inference failed */
    public void a(FrsFragment frsFragment, com.baidu.adp.widget.ListView.r rVar) {
        this.faG = frsFragment;
        this.fhB = com.baidu.tieba.frs.c.bbO().a(frsFragment.getPageContext(), com.baidu.tieba.tbadkCore.s.iEX, this.faG.getUniqueId(), false);
        this.fht = new q(frsFragment.getTbPageContext(), bg.bAU, this.faG.getUniqueId());
        this.fht.a(rVar);
        this.fht.setInFrsAllThread(true);
        this.fhu = new g(frsFragment.getTbPageContext(), bg.bAV, this.faG.getUniqueId());
        this.fhu.a(rVar);
        this.fhv = new o(frsFragment.getTbPageContext(), bg.bAX, this.faG.getUniqueId());
        this.fhv.a(rVar);
        this.fhw = new m(frsFragment.getTbPageContext(), bg.bAY, this.faG.getUniqueId());
        this.fhw.a(rVar);
        this.fhx = new f(frsFragment.getTbPageContext(), bg.bAZ, this.faG.getUniqueId());
        this.fhx.a(rVar);
        this.fhy = new h(frsFragment.getTbPageContext(), bg.bBa, this.faG.getUniqueId());
        this.fhy.a(rVar);
        this.fhz = new r(frsFragment.getPageContext(), bg.bBd, this.faG.getUniqueId());
        this.fhz.setInFrsAllThread(true);
        this.fhz.a(rVar);
        k kVar = new k(frsFragment.getPageContext(), bg.bBb, this.faG.getUniqueId());
        kVar.a(rVar);
        kVar.setInFrsAllThread(true);
        p pVar = new p(frsFragment.getPageContext(), bg.bBh, this.faG.getUniqueId());
        pVar.a(rVar);
        pVar.setInFrsAllThread(true);
        r rVar2 = new r(frsFragment.getPageContext(), bg.bBi, this.faG.getUniqueId());
        rVar2.a(rVar);
        rVar2.setInFrsAllThread(true);
        j jVar = new j(frsFragment.getPageContext(), bg.bBq, this.faG.getUniqueId());
        jVar.a(rVar);
        i iVar = new i(frsFragment.getPageContext(), bg.bBj, this.faG.getUniqueId());
        iVar.a(rVar);
        this.fhA = new w(frsFragment.getPageContext().getPageActivity(), com.baidu.tieba.tbadkCore.l.iEP, this.faG.getUniqueId());
        this.fhC = new n(frsFragment.getPageContext(), bg.bBc, this.faG.getUniqueId());
        this.fhC.a(rVar);
        this.fhC.setVoiceManager(frsFragment.getVoiceManager());
        this.fhC.setInFrsAllThread(true);
        com.baidu.adp.widget.ListView.a<? extends bf, ? extends v.a> a = com.baidu.tieba.frs.c.bbO().a(frsFragment.getPageContext(), this.faG.getUniqueId(), true);
        com.baidu.adp.widget.ListView.a<? extends bg, ? extends v.a> b = com.baidu.tieba.frs.c.bbO().b(frsFragment.getPageContext(), bg.bCI, this.faG.getUniqueId());
        com.baidu.tieba.frs.l lVar = new com.baidu.tieba.frs.l(frsFragment.getPageContext(), com.baidu.tieba.frs.m.fbJ);
        e eVar = new e(frsFragment.getPageContext(), com.baidu.tieba.frs.p.fbY);
        v vVar = new v(frsFragment.getPageContext(), com.baidu.tieba.frs.q.fce, this.faG.getUniqueId());
        this.mAdapters.add(this.fhB);
        this.mAdapters.add(this.fht);
        this.mAdapters.add(this.fhu);
        this.mAdapters.add(this.fhv);
        this.mAdapters.add(this.fhw);
        this.mAdapters.add(this.fhx);
        this.mAdapters.add(this.fhy);
        this.mAdapters.add(this.fhA);
        this.mAdapters.add(kVar);
        this.mAdapters.add(pVar);
        this.mAdapters.add(this.fhC);
        this.mAdapters.add(this.fhz);
        this.mAdapters.add(a);
        this.mAdapters.add(b);
        this.mAdapters.add(lVar);
        this.mAdapters.add(eVar);
        this.mAdapters.add(jVar);
        this.mAdapters.add(iVar);
        this.mAdapters.add(vVar);
        com.baidu.tieba.InjectPlugin.b.b bVar = new com.baidu.tieba.InjectPlugin.b.b(this.faG, 1);
        bVar.setExtraData(this.mAdapters);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016515, bVar));
        bV(this.mAdapters);
        rVar.addAdapters(this.mAdapters);
        AbsDelegateAdapterList absDelegateAdapterList = new AbsDelegateAdapterList();
        CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2003008, absDelegateAdapterList);
        CustomMessage customMessage = new CustomMessage(2003008);
        customMessage.setTag(this.faG.getUniqueId());
        customResponsedMessage.setOrginalMessage(customMessage);
        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
        qL("page_frs");
        if (!absDelegateAdapterList.isEmpty()) {
            Iterator it = absDelegateAdapterList.iterator();
            while (it.hasNext()) {
                com.baidu.adp.widget.ListView.a aVar = (com.baidu.adp.widget.ListView.a) it.next();
                if (aVar instanceof com.baidu.tieba.frs.h) {
                    ((com.baidu.tieba.frs.h) aVar).a(this.faG.getPageContext(), this.faG.getUniqueId());
                }
            }
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(absDelegateAdapterList);
            if (this.mAdapters != null) {
                this.mAdapters.addAll(arrayList);
            }
            if (this.eEr != null) {
                this.eEr.addAdapters(arrayList);
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.a.z
    public void onDestory() {
        for (com.baidu.adp.widget.ListView.a aVar : this.mAdapters) {
            if (aVar instanceof com.baidu.tieba.frs.h) {
                ((com.baidu.tieba.frs.h) aVar).release();
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.a.z
    public HashMap<Integer, bg> bfA() {
        return this.fhq;
    }

    @Override // com.baidu.tieba.frs.entelechy.a.z
    public void notifyDataSetChanged() {
        if (this.eEr.getListAdapter() != null) {
            this.eEr.getListAdapter().notifyDataSetChanged();
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.a.z
    public int bfB() {
        if (this.fhB != null) {
            return d.g.frs_bawu_center;
        }
        return 0;
    }

    @Override // com.baidu.tieba.frs.entelechy.a.z
    public boolean l(BdUniqueId bdUniqueId) {
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

    @Override // com.baidu.tieba.frs.entelechy.a.z
    public void setOnAdapterItemClickListener(com.baidu.adp.widget.ListView.s sVar) {
        if (this.mAdapters != null && this.mAdapters.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.mAdapters) {
                if (aVar instanceof com.baidu.tieba.frs.h) {
                    ((com.baidu.tieba.frs.h) aVar).setOnAdapterItemClickListener(sVar);
                } else if ((aVar instanceof n) || (aVar instanceof r)) {
                    aVar.setOnAdapterItemClickListener(sVar);
                }
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.a.z
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
    @Override // com.baidu.tieba.frs.entelechy.a.z
    public void bfC() {
        if (this.mAdapters != null && this.mAdapters.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.mAdapters) {
                if (aVar instanceof com.baidu.tieba.frs.h) {
                    ((com.baidu.tieba.frs.h) aVar).a(this.faG.getPageContext(), this.faG.getUniqueId());
                }
            }
            bV(this.mAdapters);
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.a.z
    public List<com.baidu.adp.widget.ListView.m> getDatas() {
        if (this.eEr != null) {
            return this.eEr.getData();
        }
        return null;
    }

    @Override // com.baidu.tieba.frs.entelechy.a.z
    public int bfD() {
        if (this.fhB != null) {
            return d.g.frs_fortune_bag_item;
        }
        return 0;
    }

    @Override // com.baidu.tieba.frs.entelechy.a.z
    public int bfE() {
        if (this.fhB != null) {
            return d.g.frs_my_service_item;
        }
        return 0;
    }

    public void Ru() {
        if (this.bFP != null) {
            this.eEr.setData(this.bFP);
        }
        notifyDataSetChanged();
    }

    @Override // com.baidu.tieba.frs.entelechy.a.z
    public void setFromCDN(boolean z) {
        if (this.mAdapters != null && this.mAdapters.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.mAdapters) {
                if (aVar instanceof com.baidu.tieba.frs.h) {
                    ((com.baidu.tieba.frs.h) aVar).setFromCDN(z);
                }
            }
            if (this.fht != null) {
                this.fht.setFromCDN(z);
            }
            if (this.fhu != null) {
                this.fhu.setFromCDN(z);
            }
            if (this.fhv != null) {
                this.fhv.setFromCDN(z);
            }
            if (this.fhw != null) {
                this.fhw.setFromCDN(z);
            }
            if (this.fhx != null) {
                this.fhx.setFromCDN(z);
            }
            if (this.fhy != null) {
                this.fhy.setFromCDN(z);
            }
            if (this.fhz != null) {
                this.fhz.setFromCDN(z);
            }
            if (this.fhC != null) {
                this.fhC.setFromCDN(z);
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.a.z
    public void bfF() {
        List<com.baidu.adp.widget.ListView.m> data;
        if (this.eEr != null && this.eEr.getData() != null && this.eEr.getData().size() != 0 && (data = this.eEr.getData()) != null && data.size() != 0) {
            for (com.baidu.adp.widget.ListView.m mVar : data) {
                if (mVar instanceof bg) {
                    if (((bg) mVar).YM() != 0) {
                        ((bg) mVar).ZH();
                    }
                } else if ((mVar instanceof bf) && ((bf) mVar).threadData.YM() != 0) {
                    ((bf) mVar).threadData.ZH();
                }
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.a.z
    public void jC(boolean z) {
        if (this.fhs != z) {
            this.fhs = z;
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.a.z
    public void b(ArrayList<com.baidu.adp.widget.ListView.m> arrayList, FrsViewData frsViewData) {
        b(frsViewData);
        com.baidu.tieba.tbadkCore.q.p(arrayList, 1);
        S(arrayList);
        T(arrayList);
        U(arrayList);
        Iterator<com.baidu.adp.widget.ListView.m> it = arrayList.iterator();
        while (it.hasNext()) {
            com.baidu.adp.widget.ListView.m next = it.next();
            if ((next instanceof bf) && ((bf) next).threadData.Zy()) {
                it.remove();
            }
        }
        this.eEr.setData(arrayList);
        this.fhr = frsViewData;
        bfc();
        bfH();
        this.bFP = arrayList;
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

    private ArrayList<Integer> S(ArrayList<com.baidu.adp.widget.ListView.m> arrayList) {
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
                if (this.fhq != null && !this.fhq.containsValue(mVar)) {
                    this.fhq.put(Integer.valueOf(i2), (bg) mVar);
                }
            }
            i = i2 + 1;
        }
    }

    private void T(ArrayList<com.baidu.adp.widget.ListView.m> arrayList) {
        int i;
        if (this.mAdapters != null && this.mAdapters.size() != 0) {
            int i2 = 0;
            if (arrayList == null || arrayList.size() <= 0) {
                i = 0;
            } else {
                Iterator<com.baidu.adp.widget.ListView.m> it = arrayList.iterator();
                while (true) {
                    i = i2;
                    if (!it.hasNext() || it.next().getType().getId() != bg.bAP.getId()) {
                        break;
                    }
                    i2 = i + 1;
                }
            }
            for (com.baidu.adp.widget.ListView.a aVar : this.mAdapters) {
                if (aVar instanceof com.baidu.tieba.frs.h) {
                    ((com.baidu.tieba.frs.h) aVar).pS(i);
                }
            }
        }
    }

    private void U(ArrayList<com.baidu.adp.widget.ListView.m> arrayList) {
        int S = com.baidu.tbadk.core.util.v.S(arrayList);
        for (int i = 0; i < S; i++) {
            com.baidu.adp.widget.ListView.m mVar = (com.baidu.adp.widget.ListView.m) com.baidu.tbadk.core.util.v.c(arrayList, i - 1);
            com.baidu.adp.widget.ListView.m mVar2 = (com.baidu.adp.widget.ListView.m) com.baidu.tbadk.core.util.v.c(arrayList, i);
            if (mVar2 instanceof bf) {
                bg bgVar = ((bf) mVar2).threadData;
                if (i == 0) {
                    bgVar.isFirstFloor = true;
                } else {
                    bgVar.isFirstFloor = false;
                }
                String WS = bgVar.WS();
                if (mVar instanceof com.baidu.tieba.frs.p) {
                    bgVar.needTopMargin = false;
                } else if (mVar != null && !d(mVar)) {
                    bgVar.needTopMargin = false;
                } else if ((mVar instanceof bf) && d(mVar) && !TextUtils.isEmpty(((bf) mVar).threadData.WS())) {
                    bgVar.needTopMargin = true;
                } else if (d(mVar2) && !TextUtils.isEmpty(WS)) {
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
        return type == bg.bAQ || type == bg.bBc || type == bg.bBd || type == bg.bBi || type == bg.bBq;
    }

    private void bfc() {
        com.baidu.tieba.frs.d.b bfz;
        if (this.fhr != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.mAdapters) {
                if ((aVar instanceof com.baidu.tieba.frs.d.d) && (bfz = ((com.baidu.tieba.frs.d.d) aVar).bfz()) != null) {
                    if (this.fhr.needLog == 1) {
                        bfz.fta = true;
                    } else {
                        bfz.fta = false;
                    }
                    if (this.fhr.getForum() != null) {
                        bfz.ftc = this.fhr.getForum().getId();
                    }
                    if (this.faG != null && this.faG.bcp() != null) {
                        bfz.ftb = this.faG.bcp().bhP();
                    }
                }
            }
            bfG();
        }
    }

    private void bfG() {
        com.baidu.tieba.frs.d.b bVar = new com.baidu.tieba.frs.d.b();
        if (this.fhr.needLog == 1) {
            bVar.fta = true;
        } else {
            bVar.fta = false;
        }
        if (this.fhr.getForum() != null) {
            bVar.ftc = this.fhr.getForum().getId();
        }
        if (this.faG != null && this.faG.bcp() != null) {
            bVar.ftb = this.faG.bcp().bhP();
        }
        if (com.baidu.tieba.frs.d.d.fhe != null) {
            bVar.ftd = com.baidu.tieba.frs.d.d.fhe.ftd;
            bVar.fte = com.baidu.tieba.frs.d.d.fhe.fte;
        }
        com.baidu.tieba.frs.live.b bVar2 = new com.baidu.tieba.frs.live.b(bVar, this.faG.getUniqueId());
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

    private void bfH() {
        if (this.fhr != null && this.fhr.getForum() != null && !StringUtils.isNull(this.fhr.getForum().getId()) && this.fhA != null) {
            this.fhA.setForumId(this.fhr.getForum().getId());
        }
    }

    private void bV(List<com.baidu.adp.widget.ListView.a> list) {
        if (list != null) {
            for (com.baidu.adp.widget.ListView.a aVar : list) {
                if (aVar instanceof com.baidu.tieba.frs.h) {
                    ((com.baidu.tieba.frs.h) aVar).a(this.eYy);
                }
            }
        }
    }

    private void qL(String str) {
        if (this.mAdapters != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.mAdapters) {
                if (aVar instanceof com.baidu.tieba.a.f) {
                    ((com.baidu.tieba.a.f) aVar).qL(str);
                }
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.a.z
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
