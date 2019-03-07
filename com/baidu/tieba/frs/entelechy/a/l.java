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
import com.baidu.tieba.InjectPlugin.b.b;
import com.baidu.tieba.d;
import com.baidu.tieba.frs.AbsDelegateAdapterList;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.frs.c;
import com.baidu.tieba.tbadkCore.FrsViewData;
import com.baidu.tieba.tbadkCore.s;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes4.dex */
public class l implements z {
    private ArrayList<com.baidu.adp.widget.ListView.m> bFN;
    private com.baidu.adp.widget.ListView.r eEv;
    private FrsFragment faH;
    private r fhA;
    private w fhB;
    private com.baidu.adp.widget.ListView.a fhC;
    private n fhD;
    private final HashMap<Integer, bg> fhr;
    private FrsViewData fhs;
    private q fhu;
    private g fhv;
    private o fhw;
    private m fhx;
    private f fhy;
    private h fhz;
    private List<com.baidu.adp.widget.ListView.a> mAdapters = new LinkedList();
    private boolean fht = false;
    private final com.baidu.tieba.frs.f eYz = new com.baidu.tieba.frs.f();

    public l(FrsFragment frsFragment, com.baidu.adp.widget.ListView.r rVar, boolean z) {
        this.eEv = rVar;
        a(frsFragment, rVar);
        this.fhr = new HashMap<>();
        jC(z);
    }

    public void a(FrsFragment frsFragment, com.baidu.adp.widget.ListView.r rVar) {
        this.faH = frsFragment;
        this.fhC = c.bbO().a(frsFragment.getPageContext(), s.iFe, this.faH.getUniqueId(), false);
        this.fhu = new q(frsFragment.getTbPageContext(), bg.bAS, this.faH.getUniqueId());
        this.fhu.a(rVar);
        this.fhu.setInFrsAllThread(true);
        this.fhv = new g(frsFragment.getTbPageContext(), bg.bAT, this.faH.getUniqueId());
        this.fhv.a(rVar);
        this.fhw = new o(frsFragment.getTbPageContext(), bg.bAV, this.faH.getUniqueId());
        this.fhw.a(rVar);
        this.fhx = new m(frsFragment.getTbPageContext(), bg.bAW, this.faH.getUniqueId());
        this.fhx.a(rVar);
        this.fhy = new f(frsFragment.getTbPageContext(), bg.bAX, this.faH.getUniqueId());
        this.fhy.a(rVar);
        this.fhz = new h(frsFragment.getTbPageContext(), bg.bAY, this.faH.getUniqueId());
        this.fhz.a(rVar);
        this.fhA = new r(frsFragment.getPageContext(), bg.bBb, this.faH.getUniqueId());
        this.fhA.setInFrsAllThread(true);
        this.fhA.a(rVar);
        k kVar = new k(frsFragment.getPageContext(), bg.bAZ, this.faH.getUniqueId());
        kVar.a(rVar);
        kVar.setInFrsAllThread(true);
        p pVar = new p(frsFragment.getPageContext(), bg.bBf, this.faH.getUniqueId());
        pVar.a(rVar);
        pVar.setInFrsAllThread(true);
        r rVar2 = new r(frsFragment.getPageContext(), bg.bBg, this.faH.getUniqueId());
        rVar2.a(rVar);
        rVar2.setInFrsAllThread(true);
        j jVar = new j(frsFragment.getPageContext(), bg.bBo, this.faH.getUniqueId());
        jVar.a(rVar);
        i iVar = new i(frsFragment.getPageContext(), bg.bBh, this.faH.getUniqueId());
        iVar.a(rVar);
        this.fhB = new w(frsFragment.getPageContext().getPageActivity(), com.baidu.tieba.tbadkCore.l.iEW, this.faH.getUniqueId());
        this.fhD = new n(frsFragment.getPageContext(), bg.bBa, this.faH.getUniqueId());
        this.fhD.a(rVar);
        this.fhD.setVoiceManager(frsFragment.getVoiceManager());
        this.fhD.setInFrsAllThread(true);
        com.baidu.adp.widget.ListView.a<? extends bf, ? extends v.a> a = c.bbO().a(frsFragment.getPageContext(), this.faH.getUniqueId(), true);
        com.baidu.adp.widget.ListView.a<? extends bg, ? extends v.a> b = c.bbO().b(frsFragment.getPageContext(), bg.bCG, this.faH.getUniqueId());
        com.baidu.tieba.frs.l lVar = new com.baidu.tieba.frs.l(frsFragment.getPageContext(), com.baidu.tieba.frs.m.fbK);
        e eVar = new e(frsFragment.getPageContext(), com.baidu.tieba.frs.p.fbZ);
        v vVar = new v(frsFragment.getPageContext(), com.baidu.tieba.frs.q.fcf, this.faH.getUniqueId());
        this.mAdapters.add(this.fhC);
        this.mAdapters.add(this.fhu);
        this.mAdapters.add(this.fhv);
        this.mAdapters.add(this.fhw);
        this.mAdapters.add(this.fhx);
        this.mAdapters.add(this.fhy);
        this.mAdapters.add(this.fhz);
        this.mAdapters.add(this.fhB);
        this.mAdapters.add(kVar);
        this.mAdapters.add(pVar);
        this.mAdapters.add(this.fhD);
        this.mAdapters.add(this.fhA);
        this.mAdapters.add(a);
        this.mAdapters.add(b);
        this.mAdapters.add(lVar);
        this.mAdapters.add(eVar);
        this.mAdapters.add(jVar);
        this.mAdapters.add(iVar);
        this.mAdapters.add(vVar);
        b bVar = new b(this.faH, 1);
        bVar.setExtraData(this.mAdapters);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016515, bVar));
        bV(this.mAdapters);
        rVar.addAdapters(this.mAdapters);
        CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2003008, new AbsDelegateAdapterList());
        CustomMessage customMessage = new CustomMessage(2003008);
        customMessage.setTag(this.faH.getUniqueId());
        customResponsedMessage.setOrginalMessage(customMessage);
        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
        qM("page_frs");
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
        return this.fhr;
    }

    @Override // com.baidu.tieba.frs.entelechy.a.z
    public void notifyDataSetChanged() {
        if (this.eEv.getListAdapter() != null) {
            this.eEv.getListAdapter().notifyDataSetChanged();
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.a.z
    public int bfB() {
        if (this.fhC != null) {
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
                    ((com.baidu.tieba.frs.h) aVar).a(this.faH.getPageContext(), this.faH.getUniqueId());
                }
            }
            bV(this.mAdapters);
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.a.z
    public List<com.baidu.adp.widget.ListView.m> getDatas() {
        if (this.eEv != null) {
            return this.eEv.getData();
        }
        return null;
    }

    @Override // com.baidu.tieba.frs.entelechy.a.z
    public int bfD() {
        if (this.fhC != null) {
            return d.g.frs_fortune_bag_item;
        }
        return 0;
    }

    @Override // com.baidu.tieba.frs.entelechy.a.z
    public int bfE() {
        if (this.fhC != null) {
            return d.g.frs_my_service_item;
        }
        return 0;
    }

    public void Ru() {
        if (this.bFN != null) {
            this.eEv.setData(this.bFN);
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
            if (this.fhA != null) {
                this.fhA.setFromCDN(z);
            }
            if (this.fhD != null) {
                this.fhD.setFromCDN(z);
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.a.z
    public void bfF() {
        List<com.baidu.adp.widget.ListView.m> data;
        if (this.eEv != null && this.eEv.getData() != null && this.eEv.getData().size() != 0 && (data = this.eEv.getData()) != null && data.size() != 0) {
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
        if (this.fht != z) {
            this.fht = z;
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
        this.eEv.setData(arrayList);
        this.fhs = frsViewData;
        bfc();
        bfH();
        this.bFN = arrayList;
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
                if (this.fhr != null && !this.fhr.containsValue(mVar)) {
                    this.fhr.put(Integer.valueOf(i2), (bg) mVar);
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
                    if (!it.hasNext() || it.next().getType().getId() != bg.bAN.getId()) {
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
        return type == bg.bAO || type == bg.bBa || type == bg.bBb || type == bg.bBg || type == bg.bBo;
    }

    private void bfc() {
        com.baidu.tieba.frs.d.b bfz;
        if (this.fhs != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.mAdapters) {
                if ((aVar instanceof com.baidu.tieba.frs.d.d) && (bfz = ((com.baidu.tieba.frs.d.d) aVar).bfz()) != null) {
                    if (this.fhs.needLog == 1) {
                        bfz.ftb = true;
                    } else {
                        bfz.ftb = false;
                    }
                    if (this.fhs.getForum() != null) {
                        bfz.ftd = this.fhs.getForum().getId();
                    }
                    if (this.faH != null && this.faH.bcp() != null) {
                        bfz.ftc = this.faH.bcp().bhP();
                    }
                }
            }
            bfG();
        }
    }

    private void bfG() {
        com.baidu.tieba.frs.d.b bVar = new com.baidu.tieba.frs.d.b();
        if (this.fhs.needLog == 1) {
            bVar.ftb = true;
        } else {
            bVar.ftb = false;
        }
        if (this.fhs.getForum() != null) {
            bVar.ftd = this.fhs.getForum().getId();
        }
        if (this.faH != null && this.faH.bcp() != null) {
            bVar.ftc = this.faH.bcp().bhP();
        }
        if (com.baidu.tieba.frs.d.d.fhf != null) {
            bVar.fte = com.baidu.tieba.frs.d.d.fhf.fte;
            bVar.ftf = com.baidu.tieba.frs.d.d.fhf.ftf;
        }
        com.baidu.tieba.frs.live.b bVar2 = new com.baidu.tieba.frs.live.b(bVar, this.faH.getUniqueId());
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
        if (this.fhs != null && this.fhs.getForum() != null && !StringUtils.isNull(this.fhs.getForum().getId()) && this.fhB != null) {
            this.fhB.setForumId(this.fhs.getForum().getId());
        }
    }

    private void bV(List<com.baidu.adp.widget.ListView.a> list) {
        if (list != null) {
            for (com.baidu.adp.widget.ListView.a aVar : list) {
                if (aVar instanceof com.baidu.tieba.frs.h) {
                    ((com.baidu.tieba.frs.h) aVar).a(this.eYz);
                }
            }
        }
    }

    private void qM(String str) {
        if (this.mAdapters != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.mAdapters) {
                if (aVar instanceof com.baidu.tieba.a.f) {
                    ((com.baidu.tieba.a.f) aVar).qM(str);
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
