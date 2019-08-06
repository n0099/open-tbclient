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
    private com.baidu.adp.widget.ListView.r eZn;
    private final HashMap<Integer, bh> fDh;
    private FrsViewData fDi;
    private r fDk;
    private g fDl;
    private o fDm;
    private m fDn;
    private f fDo;
    private h fDp;
    private p fDq;
    private s fDr;
    private x fDs;
    private com.baidu.adp.widget.ListView.a fDt;
    private n fDu;
    private FrsFragment fwg;
    private List<com.baidu.adp.widget.ListView.a> mAdapters = new LinkedList();
    private boolean fDj = false;
    private final com.baidu.tieba.frs.f ftU = new com.baidu.tieba.frs.f();

    public l(FrsFragment frsFragment, com.baidu.adp.widget.ListView.r rVar, boolean z) {
        this.eZn = rVar;
        a(frsFragment, rVar);
        this.fDh = new HashMap<>();
        ky(z);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r3v29, resolved type: com.baidu.tieba.frs.FrsFragment */
    /* JADX WARN: Multi-variable type inference failed */
    public void a(FrsFragment frsFragment, com.baidu.adp.widget.ListView.r rVar) {
        this.fwg = frsFragment;
        this.fDt = com.baidu.tieba.frs.c.blr().a(frsFragment.getPageContext(), com.baidu.tieba.tbadkCore.u.jfa, this.fwg.getUniqueId(), false);
        this.fDk = new r(frsFragment.getTbPageContext(), bh.bJs, this.fwg.getUniqueId());
        this.fDk.a(rVar);
        this.fDk.setInFrsAllThread(true);
        this.fDl = new g(frsFragment.getTbPageContext(), bh.bJt, this.fwg.getUniqueId());
        this.fDl.a(rVar);
        this.fDm = new o(frsFragment.getTbPageContext(), bh.bJv, this.fwg.getUniqueId());
        this.fDm.a(rVar);
        this.fDn = new m(frsFragment.getTbPageContext(), bh.bJw, this.fwg.getUniqueId());
        this.fDn.a(rVar);
        this.fDo = new f(frsFragment.getTbPageContext(), bh.bJx, this.fwg.getUniqueId());
        this.fDo.a(rVar);
        this.fDp = new h(frsFragment.getTbPageContext(), bh.bJy, this.fwg.getUniqueId());
        this.fDp.a(rVar);
        this.fDq = new p(frsFragment.getTbPageContext(), bh.bJM, this.fwg.getUniqueId());
        this.fDq.a(rVar);
        this.fDr = new s(frsFragment.getPageContext(), bh.bJC, this.fwg.getUniqueId());
        this.fDr.setInFrsAllThread(true);
        this.fDr.a(rVar);
        k kVar = new k(frsFragment.getPageContext(), bh.bJA, this.fwg.getUniqueId());
        kVar.a(rVar);
        kVar.setInFrsAllThread(true);
        q qVar = new q(frsFragment.getPageContext(), bh.bJG, this.fwg.getUniqueId());
        qVar.a(rVar);
        qVar.setInFrsAllThread(true);
        s sVar = new s(frsFragment.getPageContext(), bh.bJH, this.fwg.getUniqueId());
        sVar.a(rVar);
        sVar.setInFrsAllThread(true);
        j jVar = new j(frsFragment.getPageContext(), bh.bJQ, this.fwg.getUniqueId());
        jVar.a(rVar);
        i iVar = new i(frsFragment.getPageContext(), bh.bJI, this.fwg.getUniqueId());
        iVar.a(rVar);
        this.fDs = new x(frsFragment.getPageContext().getPageActivity(), com.baidu.tieba.tbadkCore.n.jeS, this.fwg.getUniqueId());
        this.fDu = new n(frsFragment.getPageContext(), bh.bJB, this.fwg.getUniqueId());
        this.fDu.a(rVar);
        this.fDu.setVoiceManager(frsFragment.getVoiceManager());
        this.fDu.setInFrsAllThread(true);
        com.baidu.adp.widget.ListView.a<? extends bg, ? extends v.a> a = com.baidu.tieba.frs.c.blr().a(frsFragment.getPageContext(), this.fwg.getUniqueId(), true);
        com.baidu.adp.widget.ListView.a<? extends bh, ? extends v.a> b = com.baidu.tieba.frs.c.blr().b(frsFragment.getPageContext(), bh.bLi, this.fwg.getUniqueId());
        com.baidu.tieba.frs.l lVar = new com.baidu.tieba.frs.l(frsFragment.getPageContext(), com.baidu.tieba.frs.m.fxi);
        e eVar = new e(frsFragment.getPageContext(), com.baidu.tieba.frs.p.fxw);
        w wVar = new w(frsFragment.getPageContext(), com.baidu.tieba.frs.q.fxB, this.fwg.getUniqueId());
        this.mAdapters.add(this.fDt);
        this.mAdapters.add(this.fDk);
        this.mAdapters.add(this.fDl);
        this.mAdapters.add(this.fDm);
        this.mAdapters.add(this.fDn);
        this.mAdapters.add(this.fDo);
        this.mAdapters.add(this.fDp);
        this.mAdapters.add(this.fDq);
        this.mAdapters.add(this.fDs);
        this.mAdapters.add(kVar);
        this.mAdapters.add(qVar);
        this.mAdapters.add(this.fDu);
        this.mAdapters.add(this.fDr);
        this.mAdapters.add(a);
        this.mAdapters.add(b);
        this.mAdapters.add(lVar);
        this.mAdapters.add(eVar);
        this.mAdapters.add(jVar);
        this.mAdapters.add(iVar);
        this.mAdapters.add(wVar);
        this.mAdapters.add(sVar);
        com.baidu.tieba.InjectPlugin.b.b bVar = new com.baidu.tieba.InjectPlugin.b.b(this.fwg, 1);
        bVar.setExtraData(this.mAdapters);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016515, bVar));
        ca(this.mAdapters);
        rVar.addAdapters(this.mAdapters);
        AbsDelegateAdapterList absDelegateAdapterList = new AbsDelegateAdapterList();
        CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2003008, absDelegateAdapterList);
        CustomMessage customMessage = new CustomMessage(2003008);
        customMessage.setTag(this.fwg.getUniqueId());
        customResponsedMessage.setOrginalMessage(customMessage);
        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
        sm("page_frs");
        if (!absDelegateAdapterList.isEmpty()) {
            Iterator it = absDelegateAdapterList.iterator();
            while (it.hasNext()) {
                com.baidu.adp.widget.ListView.a aVar = (com.baidu.adp.widget.ListView.a) it.next();
                if (aVar instanceof com.baidu.tieba.frs.h) {
                    ((com.baidu.tieba.frs.h) aVar).a(this.fwg.getPageContext(), this.fwg.getUniqueId());
                }
            }
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(absDelegateAdapterList);
            if (this.mAdapters != null) {
                this.mAdapters.addAll(arrayList);
            }
            if (this.eZn != null) {
                this.eZn.addAdapters(arrayList);
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
    public HashMap<Integer, bh> bpi() {
        return this.fDh;
    }

    @Override // com.baidu.tieba.frs.entelechy.a.aa
    public void notifyDataSetChanged() {
        if (this.eZn.getListAdapter() != null) {
            this.eZn.getListAdapter().notifyDataSetChanged();
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.a.aa
    public int bpj() {
        if (this.fDt != null) {
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
    public void bpk() {
        if (this.mAdapters != null && this.mAdapters.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.mAdapters) {
                if (aVar instanceof com.baidu.tieba.frs.h) {
                    ((com.baidu.tieba.frs.h) aVar).a(this.fwg.getPageContext(), this.fwg.getUniqueId());
                }
            }
            ca(this.mAdapters);
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.a.aa
    public List<com.baidu.adp.widget.ListView.m> getDatas() {
        if (this.eZn != null) {
            return this.eZn.getData();
        }
        return null;
    }

    @Override // com.baidu.tieba.frs.entelechy.a.aa
    public int bpl() {
        if (this.fDt != null) {
            return R.id.frs_fortune_bag_item;
        }
        return 0;
    }

    @Override // com.baidu.tieba.frs.entelechy.a.aa
    public int bpm() {
        if (this.fDt != null) {
            return R.id.frs_my_service_item;
        }
        return 0;
    }

    public void VX() {
        if (this.dataList != null) {
            this.eZn.setData(this.dataList);
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
            if (this.fDk != null) {
                this.fDk.setFromCDN(z);
            }
            if (this.fDl != null) {
                this.fDl.setFromCDN(z);
            }
            if (this.fDm != null) {
                this.fDm.setFromCDN(z);
            }
            if (this.fDn != null) {
                this.fDn.setFromCDN(z);
            }
            if (this.fDo != null) {
                this.fDo.setFromCDN(z);
            }
            if (this.fDp != null) {
                this.fDp.setFromCDN(z);
            }
            if (this.fDr != null) {
                this.fDr.setFromCDN(z);
            }
            if (this.fDu != null) {
                this.fDu.setFromCDN(z);
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.a.aa
    public void bpn() {
        List<com.baidu.adp.widget.ListView.m> data;
        if (this.eZn != null && this.eZn.getData() != null && this.eZn.getData().size() != 0 && (data = this.eZn.getData()) != null && data.size() != 0) {
            for (com.baidu.adp.widget.ListView.m mVar : data) {
                if (mVar instanceof bh) {
                    if (((bh) mVar).aet() != 0) {
                        ((bh) mVar).afo();
                    }
                } else if ((mVar instanceof bg) && ((bg) mVar).threadData.aet() != 0) {
                    ((bg) mVar).threadData.afo();
                }
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.a.aa
    public void ky(boolean z) {
        if (this.fDj != z) {
            this.fDj = z;
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
            if ((next instanceof bg) && ((bg) next).threadData.aff()) {
                it.remove();
            }
        }
        this.eZn.setData(arrayList);
        this.fDi = frsViewData;
        boJ();
        bpp();
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
                if (this.fDh != null && !this.fDh.containsValue(mVar)) {
                    this.fDh.put(Integer.valueOf(i2), (bh) mVar);
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
                    if (!it.hasNext() || it.next().getType().getId() != bh.bJn.getId()) {
                        break;
                    }
                    i2 = i + 1;
                }
            }
            for (com.baidu.adp.widget.ListView.a aVar : this.mAdapters) {
                if (aVar instanceof com.baidu.tieba.frs.h) {
                    ((com.baidu.tieba.frs.h) aVar).ro(i);
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
                String acz = bhVar.acz();
                if (mVar instanceof com.baidu.tieba.frs.p) {
                    bhVar.needTopMargin = false;
                } else if (mVar != null && !d(mVar)) {
                    bhVar.needTopMargin = false;
                } else if ((mVar instanceof bg) && d(mVar) && !TextUtils.isEmpty(((bg) mVar).threadData.acz())) {
                    bhVar.needTopMargin = true;
                } else if (d(mVar2) && !TextUtils.isEmpty(acz)) {
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
        return type == bh.bJo || type == bh.bJB || type == bh.bJC || type == bh.bJH || type == bh.bJQ;
    }

    private void boJ() {
        com.baidu.tieba.frs.d.b bph;
        if (this.fDi != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.mAdapters) {
                if ((aVar instanceof com.baidu.tieba.frs.d.d) && (bph = ((com.baidu.tieba.frs.d.d) aVar).bph()) != null) {
                    if (this.fDi.needLog == 1) {
                        bph.fPr = true;
                    } else {
                        bph.fPr = false;
                    }
                    if (this.fDi.getForum() != null) {
                        bph.fPt = this.fDi.getForum().getId();
                    }
                    if (this.fwg != null && this.fwg.blT() != null) {
                        bph.fPs = this.fwg.blT().brz();
                    }
                }
            }
            bpo();
        }
    }

    private void bpo() {
        com.baidu.tieba.frs.d.b bVar = new com.baidu.tieba.frs.d.b();
        if (this.fDi.needLog == 1) {
            bVar.fPr = true;
        } else {
            bVar.fPr = false;
        }
        if (this.fDi.getForum() != null) {
            bVar.fPt = this.fDi.getForum().getId();
        }
        if (this.fwg != null && this.fwg.blT() != null) {
            bVar.fPs = this.fwg.blT().brz();
        }
        if (com.baidu.tieba.frs.d.d.fCV != null) {
            bVar.fPu = com.baidu.tieba.frs.d.d.fCV.fPu;
            bVar.fPv = com.baidu.tieba.frs.d.d.fCV.fPv;
        }
        com.baidu.tieba.frs.live.b bVar2 = new com.baidu.tieba.frs.live.b(bVar, this.fwg.getUniqueId());
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

    private void bpp() {
        if (this.fDi != null && this.fDi.getForum() != null && !StringUtils.isNull(this.fDi.getForum().getId()) && this.fDs != null) {
            this.fDs.setForumId(this.fDi.getForum().getId());
        }
    }

    private void ca(List<com.baidu.adp.widget.ListView.a> list) {
        if (list != null) {
            for (com.baidu.adp.widget.ListView.a aVar : list) {
                if (aVar instanceof com.baidu.tieba.frs.h) {
                    ((com.baidu.tieba.frs.h) aVar).a(this.ftU);
                }
            }
        }
    }

    private void sm(String str) {
        if (this.mAdapters != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.mAdapters) {
                if (aVar instanceof com.baidu.tieba.a.f) {
                    ((com.baidu.tieba.a.f) aVar).sm(str);
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
