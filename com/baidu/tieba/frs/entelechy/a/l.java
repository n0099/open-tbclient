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
    private ArrayList<com.baidu.adp.widget.ListView.m> bFR;
    private com.baidu.adp.widget.ListView.r eEc;
    private FrsFragment fat;
    private final HashMap<Integer, bg> fhc;
    private FrsViewData fhd;
    private q fhf;
    private g fhg;
    private o fhh;
    private m fhi;
    private f fhj;
    private h fhk;
    private r fhl;
    private w fhm;
    private com.baidu.adp.widget.ListView.a fhn;
    private n fho;
    private List<com.baidu.adp.widget.ListView.a> mAdapters = new LinkedList();
    private boolean fhe = false;
    private final com.baidu.tieba.frs.f eYk = new com.baidu.tieba.frs.f();

    public l(FrsFragment frsFragment, com.baidu.adp.widget.ListView.r rVar, boolean z) {
        this.eEc = rVar;
        a(frsFragment, rVar);
        this.fhc = new HashMap<>();
        jC(z);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r3v28, resolved type: com.baidu.tieba.frs.FrsFragment */
    /* JADX WARN: Multi-variable type inference failed */
    public void a(FrsFragment frsFragment, com.baidu.adp.widget.ListView.r rVar) {
        this.fat = frsFragment;
        this.fhn = com.baidu.tieba.frs.c.bbM().a(frsFragment.getPageContext(), com.baidu.tieba.tbadkCore.s.iEH, this.fat.getUniqueId(), false);
        this.fhf = new q(frsFragment.getTbPageContext(), bg.bAX, this.fat.getUniqueId());
        this.fhf.a(rVar);
        this.fhf.setInFrsAllThread(true);
        this.fhg = new g(frsFragment.getTbPageContext(), bg.bAY, this.fat.getUniqueId());
        this.fhg.a(rVar);
        this.fhh = new o(frsFragment.getTbPageContext(), bg.bBa, this.fat.getUniqueId());
        this.fhh.a(rVar);
        this.fhi = new m(frsFragment.getTbPageContext(), bg.bBb, this.fat.getUniqueId());
        this.fhi.a(rVar);
        this.fhj = new f(frsFragment.getTbPageContext(), bg.bBc, this.fat.getUniqueId());
        this.fhj.a(rVar);
        this.fhk = new h(frsFragment.getTbPageContext(), bg.bBd, this.fat.getUniqueId());
        this.fhk.a(rVar);
        this.fhl = new r(frsFragment.getPageContext(), bg.bBg, this.fat.getUniqueId());
        this.fhl.setInFrsAllThread(true);
        this.fhl.a(rVar);
        k kVar = new k(frsFragment.getPageContext(), bg.bBe, this.fat.getUniqueId());
        kVar.a(rVar);
        kVar.setInFrsAllThread(true);
        p pVar = new p(frsFragment.getPageContext(), bg.bBk, this.fat.getUniqueId());
        pVar.a(rVar);
        pVar.setInFrsAllThread(true);
        r rVar2 = new r(frsFragment.getPageContext(), bg.bBl, this.fat.getUniqueId());
        rVar2.a(rVar);
        rVar2.setInFrsAllThread(true);
        j jVar = new j(frsFragment.getPageContext(), bg.bBt, this.fat.getUniqueId());
        jVar.a(rVar);
        i iVar = new i(frsFragment.getPageContext(), bg.bBm, this.fat.getUniqueId());
        iVar.a(rVar);
        this.fhm = new w(frsFragment.getPageContext().getPageActivity(), com.baidu.tieba.tbadkCore.l.iEz, this.fat.getUniqueId());
        this.fho = new n(frsFragment.getPageContext(), bg.bBf, this.fat.getUniqueId());
        this.fho.a(rVar);
        this.fho.setVoiceManager(frsFragment.getVoiceManager());
        this.fho.setInFrsAllThread(true);
        com.baidu.adp.widget.ListView.a<? extends bf, ? extends v.a> a = com.baidu.tieba.frs.c.bbM().a(frsFragment.getPageContext(), this.fat.getUniqueId(), true);
        com.baidu.adp.widget.ListView.a<? extends bg, ? extends v.a> b = com.baidu.tieba.frs.c.bbM().b(frsFragment.getPageContext(), bg.bCL, this.fat.getUniqueId());
        com.baidu.tieba.frs.l lVar = new com.baidu.tieba.frs.l(frsFragment.getPageContext(), com.baidu.tieba.frs.m.fbw);
        e eVar = new e(frsFragment.getPageContext(), com.baidu.tieba.frs.p.fbL);
        v vVar = new v(frsFragment.getPageContext(), com.baidu.tieba.frs.q.fbR, this.fat.getUniqueId());
        this.mAdapters.add(this.fhn);
        this.mAdapters.add(this.fhf);
        this.mAdapters.add(this.fhg);
        this.mAdapters.add(this.fhh);
        this.mAdapters.add(this.fhi);
        this.mAdapters.add(this.fhj);
        this.mAdapters.add(this.fhk);
        this.mAdapters.add(this.fhm);
        this.mAdapters.add(kVar);
        this.mAdapters.add(pVar);
        this.mAdapters.add(this.fho);
        this.mAdapters.add(this.fhl);
        this.mAdapters.add(a);
        this.mAdapters.add(b);
        this.mAdapters.add(lVar);
        this.mAdapters.add(eVar);
        this.mAdapters.add(jVar);
        this.mAdapters.add(iVar);
        this.mAdapters.add(vVar);
        com.baidu.tieba.InjectPlugin.b.b bVar = new com.baidu.tieba.InjectPlugin.b.b(this.fat, 1);
        bVar.setExtraData(this.mAdapters);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016515, bVar));
        bS(this.mAdapters);
        rVar.addAdapters(this.mAdapters);
        AbsDelegateAdapterList absDelegateAdapterList = new AbsDelegateAdapterList();
        CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2003008, absDelegateAdapterList);
        CustomMessage customMessage = new CustomMessage(2003008);
        customMessage.setTag(this.fat.getUniqueId());
        customResponsedMessage.setOrginalMessage(customMessage);
        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
        qM("page_frs");
        if (!absDelegateAdapterList.isEmpty()) {
            Iterator it = absDelegateAdapterList.iterator();
            while (it.hasNext()) {
                com.baidu.adp.widget.ListView.a aVar = (com.baidu.adp.widget.ListView.a) it.next();
                if (aVar instanceof com.baidu.tieba.frs.h) {
                    ((com.baidu.tieba.frs.h) aVar).a(this.fat.getPageContext(), this.fat.getUniqueId());
                }
            }
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(absDelegateAdapterList);
            if (this.mAdapters != null) {
                this.mAdapters.addAll(arrayList);
            }
            if (this.eEc != null) {
                this.eEc.addAdapters(arrayList);
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
    public HashMap<Integer, bg> bfy() {
        return this.fhc;
    }

    @Override // com.baidu.tieba.frs.entelechy.a.z
    public void notifyDataSetChanged() {
        if (this.eEc.getListAdapter() != null) {
            this.eEc.getListAdapter().notifyDataSetChanged();
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.a.z
    public int bfz() {
        if (this.fhn != null) {
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
    public void bfA() {
        if (this.mAdapters != null && this.mAdapters.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.mAdapters) {
                if (aVar instanceof com.baidu.tieba.frs.h) {
                    ((com.baidu.tieba.frs.h) aVar).a(this.fat.getPageContext(), this.fat.getUniqueId());
                }
            }
            bS(this.mAdapters);
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.a.z
    public List<com.baidu.adp.widget.ListView.m> getDatas() {
        if (this.eEc != null) {
            return this.eEc.getData();
        }
        return null;
    }

    @Override // com.baidu.tieba.frs.entelechy.a.z
    public int bfB() {
        if (this.fhn != null) {
            return d.g.frs_fortune_bag_item;
        }
        return 0;
    }

    @Override // com.baidu.tieba.frs.entelechy.a.z
    public int bfC() {
        if (this.fhn != null) {
            return d.g.frs_my_service_item;
        }
        return 0;
    }

    public void Rs() {
        if (this.bFR != null) {
            this.eEc.setData(this.bFR);
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
            if (this.fhf != null) {
                this.fhf.setFromCDN(z);
            }
            if (this.fhg != null) {
                this.fhg.setFromCDN(z);
            }
            if (this.fhh != null) {
                this.fhh.setFromCDN(z);
            }
            if (this.fhi != null) {
                this.fhi.setFromCDN(z);
            }
            if (this.fhj != null) {
                this.fhj.setFromCDN(z);
            }
            if (this.fhk != null) {
                this.fhk.setFromCDN(z);
            }
            if (this.fhl != null) {
                this.fhl.setFromCDN(z);
            }
            if (this.fho != null) {
                this.fho.setFromCDN(z);
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.a.z
    public void bfD() {
        List<com.baidu.adp.widget.ListView.m> data;
        if (this.eEc != null && this.eEc.getData() != null && this.eEc.getData().size() != 0 && (data = this.eEc.getData()) != null && data.size() != 0) {
            for (com.baidu.adp.widget.ListView.m mVar : data) {
                if (mVar instanceof bg) {
                    if (((bg) mVar).YJ() != 0) {
                        ((bg) mVar).ZE();
                    }
                } else if ((mVar instanceof bf) && ((bf) mVar).threadData.YJ() != 0) {
                    ((bf) mVar).threadData.ZE();
                }
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.a.z
    public void jC(boolean z) {
        if (this.fhe != z) {
            this.fhe = z;
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
            if ((next instanceof bf) && ((bf) next).threadData.Zv()) {
                it.remove();
            }
        }
        this.eEc.setData(arrayList);
        this.fhd = frsViewData;
        bfa();
        bfF();
        this.bFR = arrayList;
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
                if (this.fhc != null && !this.fhc.containsValue(mVar)) {
                    this.fhc.put(Integer.valueOf(i2), (bg) mVar);
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
                    if (!it.hasNext() || it.next().getType().getId() != bg.bAS.getId()) {
                        break;
                    }
                    i2 = i + 1;
                }
            }
            for (com.baidu.adp.widget.ListView.a aVar : this.mAdapters) {
                if (aVar instanceof com.baidu.tieba.frs.h) {
                    ((com.baidu.tieba.frs.h) aVar).pO(i);
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
                String WP = bgVar.WP();
                if (mVar instanceof com.baidu.tieba.frs.p) {
                    bgVar.needTopMargin = false;
                } else if (mVar != null && !d(mVar)) {
                    bgVar.needTopMargin = false;
                } else if ((mVar instanceof bf) && d(mVar) && !TextUtils.isEmpty(((bf) mVar).threadData.WP())) {
                    bgVar.needTopMargin = true;
                } else if (d(mVar2) && !TextUtils.isEmpty(WP)) {
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
        return type == bg.bAT || type == bg.bBf || type == bg.bBg || type == bg.bBl || type == bg.bBt;
    }

    private void bfa() {
        com.baidu.tieba.frs.d.b bfx;
        if (this.fhd != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.mAdapters) {
                if ((aVar instanceof com.baidu.tieba.frs.d.d) && (bfx = ((com.baidu.tieba.frs.d.d) aVar).bfx()) != null) {
                    if (this.fhd.needLog == 1) {
                        bfx.fsM = true;
                    } else {
                        bfx.fsM = false;
                    }
                    if (this.fhd.getForum() != null) {
                        bfx.fsO = this.fhd.getForum().getId();
                    }
                    if (this.fat != null && this.fat.bcn() != null) {
                        bfx.fsN = this.fat.bcn().bhN();
                    }
                }
            }
            bfE();
        }
    }

    private void bfE() {
        com.baidu.tieba.frs.d.b bVar = new com.baidu.tieba.frs.d.b();
        if (this.fhd.needLog == 1) {
            bVar.fsM = true;
        } else {
            bVar.fsM = false;
        }
        if (this.fhd.getForum() != null) {
            bVar.fsO = this.fhd.getForum().getId();
        }
        if (this.fat != null && this.fat.bcn() != null) {
            bVar.fsN = this.fat.bcn().bhN();
        }
        if (com.baidu.tieba.frs.d.d.fgQ != null) {
            bVar.fsP = com.baidu.tieba.frs.d.d.fgQ.fsP;
            bVar.fsQ = com.baidu.tieba.frs.d.d.fgQ.fsQ;
        }
        com.baidu.tieba.frs.live.b bVar2 = new com.baidu.tieba.frs.live.b(bVar, this.fat.getUniqueId());
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

    private void bfF() {
        if (this.fhd != null && this.fhd.getForum() != null && !StringUtils.isNull(this.fhd.getForum().getId()) && this.fhm != null) {
            this.fhm.setForumId(this.fhd.getForum().getId());
        }
    }

    private void bS(List<com.baidu.adp.widget.ListView.a> list) {
        if (list != null) {
            for (com.baidu.adp.widget.ListView.a aVar : list) {
                if (aVar instanceof com.baidu.tieba.frs.h) {
                    ((com.baidu.tieba.frs.h) aVar).a(this.eYk);
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
