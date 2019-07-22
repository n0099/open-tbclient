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
    private ArrayList<com.baidu.adp.widget.ListView.m> dataList;
    private com.baidu.adp.widget.ListView.r eYZ;
    private f fCA;
    private h fCB;
    private p fCC;
    private s fCD;
    private x fCE;
    private com.baidu.adp.widget.ListView.a fCF;
    private n fCG;
    private final HashMap<Integer, bg> fCt;
    private FrsViewData fCu;
    private r fCw;
    private g fCx;
    private o fCy;
    private m fCz;
    private FrsFragment fvH;
    private List<com.baidu.adp.widget.ListView.a> mAdapters = new LinkedList();
    private boolean fCv = false;
    private final com.baidu.tieba.frs.f ftv = new com.baidu.tieba.frs.f();

    public l(FrsFragment frsFragment, com.baidu.adp.widget.ListView.r rVar, boolean z) {
        this.eYZ = rVar;
        a(frsFragment, rVar);
        this.fCt = new HashMap<>();
        ky(z);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r3v29, resolved type: com.baidu.tieba.frs.FrsFragment */
    /* JADX WARN: Multi-variable type inference failed */
    public void a(FrsFragment frsFragment, com.baidu.adp.widget.ListView.r rVar) {
        this.fvH = frsFragment;
        this.fCF = com.baidu.tieba.frs.c.blk().a(frsFragment.getPageContext(), com.baidu.tieba.tbadkCore.s.jdT, this.fvH.getUniqueId(), false);
        this.fCw = new r(frsFragment.getTbPageContext(), bg.bJn, this.fvH.getUniqueId());
        this.fCw.a(rVar);
        this.fCw.setInFrsAllThread(true);
        this.fCx = new g(frsFragment.getTbPageContext(), bg.bJo, this.fvH.getUniqueId());
        this.fCx.a(rVar);
        this.fCy = new o(frsFragment.getTbPageContext(), bg.bJq, this.fvH.getUniqueId());
        this.fCy.a(rVar);
        this.fCz = new m(frsFragment.getTbPageContext(), bg.bJr, this.fvH.getUniqueId());
        this.fCz.a(rVar);
        this.fCA = new f(frsFragment.getTbPageContext(), bg.bJs, this.fvH.getUniqueId());
        this.fCA.a(rVar);
        this.fCB = new h(frsFragment.getTbPageContext(), bg.bJt, this.fvH.getUniqueId());
        this.fCB.a(rVar);
        this.fCC = new p(frsFragment.getTbPageContext(), bg.bJH, this.fvH.getUniqueId());
        this.fCC.a(rVar);
        this.fCD = new s(frsFragment.getPageContext(), bg.bJx, this.fvH.getUniqueId());
        this.fCD.setInFrsAllThread(true);
        this.fCD.a(rVar);
        k kVar = new k(frsFragment.getPageContext(), bg.bJv, this.fvH.getUniqueId());
        kVar.a(rVar);
        kVar.setInFrsAllThread(true);
        q qVar = new q(frsFragment.getPageContext(), bg.bJB, this.fvH.getUniqueId());
        qVar.a(rVar);
        qVar.setInFrsAllThread(true);
        s sVar = new s(frsFragment.getPageContext(), bg.bJC, this.fvH.getUniqueId());
        sVar.a(rVar);
        sVar.setInFrsAllThread(true);
        j jVar = new j(frsFragment.getPageContext(), bg.bJL, this.fvH.getUniqueId());
        jVar.a(rVar);
        i iVar = new i(frsFragment.getPageContext(), bg.bJD, this.fvH.getUniqueId());
        iVar.a(rVar);
        this.fCE = new x(frsFragment.getPageContext().getPageActivity(), com.baidu.tieba.tbadkCore.l.jdL, this.fvH.getUniqueId());
        this.fCG = new n(frsFragment.getPageContext(), bg.bJw, this.fvH.getUniqueId());
        this.fCG.a(rVar);
        this.fCG.setVoiceManager(frsFragment.getVoiceManager());
        this.fCG.setInFrsAllThread(true);
        com.baidu.adp.widget.ListView.a<? extends bf, ? extends v.a> a = com.baidu.tieba.frs.c.blk().a(frsFragment.getPageContext(), this.fvH.getUniqueId(), true);
        com.baidu.adp.widget.ListView.a<? extends bg, ? extends v.a> b = com.baidu.tieba.frs.c.blk().b(frsFragment.getPageContext(), bg.bLd, this.fvH.getUniqueId());
        com.baidu.tieba.frs.l lVar = new com.baidu.tieba.frs.l(frsFragment.getPageContext(), com.baidu.tieba.frs.m.fwJ);
        e eVar = new e(frsFragment.getPageContext(), com.baidu.tieba.frs.p.fwX);
        w wVar = new w(frsFragment.getPageContext(), com.baidu.tieba.frs.q.fxc, this.fvH.getUniqueId());
        this.mAdapters.add(this.fCF);
        this.mAdapters.add(this.fCw);
        this.mAdapters.add(this.fCx);
        this.mAdapters.add(this.fCy);
        this.mAdapters.add(this.fCz);
        this.mAdapters.add(this.fCA);
        this.mAdapters.add(this.fCB);
        this.mAdapters.add(this.fCC);
        this.mAdapters.add(this.fCE);
        this.mAdapters.add(kVar);
        this.mAdapters.add(qVar);
        this.mAdapters.add(this.fCG);
        this.mAdapters.add(this.fCD);
        this.mAdapters.add(a);
        this.mAdapters.add(b);
        this.mAdapters.add(lVar);
        this.mAdapters.add(eVar);
        this.mAdapters.add(jVar);
        this.mAdapters.add(iVar);
        this.mAdapters.add(wVar);
        this.mAdapters.add(sVar);
        com.baidu.tieba.InjectPlugin.b.b bVar = new com.baidu.tieba.InjectPlugin.b.b(this.fvH, 1);
        bVar.setExtraData(this.mAdapters);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016515, bVar));
        cb(this.mAdapters);
        rVar.addAdapters(this.mAdapters);
        AbsDelegateAdapterList absDelegateAdapterList = new AbsDelegateAdapterList();
        CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2003008, absDelegateAdapterList);
        CustomMessage customMessage = new CustomMessage(2003008);
        customMessage.setTag(this.fvH.getUniqueId());
        customResponsedMessage.setOrginalMessage(customMessage);
        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
        sm("page_frs");
        if (!absDelegateAdapterList.isEmpty()) {
            Iterator it = absDelegateAdapterList.iterator();
            while (it.hasNext()) {
                com.baidu.adp.widget.ListView.a aVar = (com.baidu.adp.widget.ListView.a) it.next();
                if (aVar instanceof com.baidu.tieba.frs.h) {
                    ((com.baidu.tieba.frs.h) aVar).a(this.fvH.getPageContext(), this.fvH.getUniqueId());
                }
            }
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(absDelegateAdapterList);
            if (this.mAdapters != null) {
                this.mAdapters.addAll(arrayList);
            }
            if (this.eYZ != null) {
                this.eYZ.addAdapters(arrayList);
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
    public HashMap<Integer, bg> boV() {
        return this.fCt;
    }

    @Override // com.baidu.tieba.frs.entelechy.a.aa
    public void notifyDataSetChanged() {
        if (this.eYZ.getListAdapter() != null) {
            this.eYZ.getListAdapter().notifyDataSetChanged();
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.a.aa
    public int boW() {
        if (this.fCF != null) {
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
    public void boX() {
        if (this.mAdapters != null && this.mAdapters.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.mAdapters) {
                if (aVar instanceof com.baidu.tieba.frs.h) {
                    ((com.baidu.tieba.frs.h) aVar).a(this.fvH.getPageContext(), this.fvH.getUniqueId());
                }
            }
            cb(this.mAdapters);
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.a.aa
    public List<com.baidu.adp.widget.ListView.m> getDatas() {
        if (this.eYZ != null) {
            return this.eYZ.getData();
        }
        return null;
    }

    @Override // com.baidu.tieba.frs.entelechy.a.aa
    public int boY() {
        if (this.fCF != null) {
            return R.id.frs_fortune_bag_item;
        }
        return 0;
    }

    @Override // com.baidu.tieba.frs.entelechy.a.aa
    public int boZ() {
        if (this.fCF != null) {
            return R.id.frs_my_service_item;
        }
        return 0;
    }

    public void VX() {
        if (this.dataList != null) {
            this.eYZ.setData(this.dataList);
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
            if (this.fCw != null) {
                this.fCw.setFromCDN(z);
            }
            if (this.fCx != null) {
                this.fCx.setFromCDN(z);
            }
            if (this.fCy != null) {
                this.fCy.setFromCDN(z);
            }
            if (this.fCz != null) {
                this.fCz.setFromCDN(z);
            }
            if (this.fCA != null) {
                this.fCA.setFromCDN(z);
            }
            if (this.fCB != null) {
                this.fCB.setFromCDN(z);
            }
            if (this.fCD != null) {
                this.fCD.setFromCDN(z);
            }
            if (this.fCG != null) {
                this.fCG.setFromCDN(z);
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.a.aa
    public void bpa() {
        List<com.baidu.adp.widget.ListView.m> data;
        if (this.eYZ != null && this.eYZ.getData() != null && this.eYZ.getData().size() != 0 && (data = this.eYZ.getData()) != null && data.size() != 0) {
            for (com.baidu.adp.widget.ListView.m mVar : data) {
                if (mVar instanceof bg) {
                    if (((bg) mVar).aes() != 0) {
                        ((bg) mVar).afn();
                    }
                } else if ((mVar instanceof bf) && ((bf) mVar).threadData.aes() != 0) {
                    ((bf) mVar).threadData.afn();
                }
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.a.aa
    public void ky(boolean z) {
        if (this.fCv != z) {
            this.fCv = z;
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
            if ((next instanceof bf) && ((bf) next).threadData.afe()) {
                it.remove();
            }
        }
        this.eYZ.setData(arrayList);
        this.fCu = frsViewData;
        bow();
        bpc();
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
                if (this.fCt != null && !this.fCt.containsValue(mVar)) {
                    this.fCt.put(Integer.valueOf(i2), (bg) mVar);
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
                    if (!it.hasNext() || it.next().getType().getId() != bg.bJi.getId()) {
                        break;
                    }
                    i2 = i + 1;
                }
            }
            for (com.baidu.adp.widget.ListView.a aVar : this.mAdapters) {
                if (aVar instanceof com.baidu.tieba.frs.h) {
                    ((com.baidu.tieba.frs.h) aVar).rm(i);
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
                String acy = bgVar.acy();
                if (mVar instanceof com.baidu.tieba.frs.p) {
                    bgVar.needTopMargin = false;
                } else if (mVar != null && !d(mVar)) {
                    bgVar.needTopMargin = false;
                } else if ((mVar instanceof bf) && d(mVar) && !TextUtils.isEmpty(((bf) mVar).threadData.acy())) {
                    bgVar.needTopMargin = true;
                } else if (d(mVar2) && !TextUtils.isEmpty(acy)) {
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
        return type == bg.bJj || type == bg.bJw || type == bg.bJx || type == bg.bJC || type == bg.bJL;
    }

    private void bow() {
        com.baidu.tieba.frs.d.b boU;
        if (this.fCu != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.mAdapters) {
                if ((aVar instanceof com.baidu.tieba.frs.d.d) && (boU = ((com.baidu.tieba.frs.d.d) aVar).boU()) != null) {
                    if (this.fCu.needLog == 1) {
                        boU.fOD = true;
                    } else {
                        boU.fOD = false;
                    }
                    if (this.fCu.getForum() != null) {
                        boU.fOF = this.fCu.getForum().getId();
                    }
                    if (this.fvH != null && this.fvH.blM() != null) {
                        boU.fOE = this.fvH.blM().brm();
                    }
                }
            }
            bpb();
        }
    }

    private void bpb() {
        com.baidu.tieba.frs.d.b bVar = new com.baidu.tieba.frs.d.b();
        if (this.fCu.needLog == 1) {
            bVar.fOD = true;
        } else {
            bVar.fOD = false;
        }
        if (this.fCu.getForum() != null) {
            bVar.fOF = this.fCu.getForum().getId();
        }
        if (this.fvH != null && this.fvH.blM() != null) {
            bVar.fOE = this.fvH.blM().brm();
        }
        if (com.baidu.tieba.frs.d.d.fCh != null) {
            bVar.fOG = com.baidu.tieba.frs.d.d.fCh.fOG;
            bVar.fOH = com.baidu.tieba.frs.d.d.fCh.fOH;
        }
        com.baidu.tieba.frs.live.b bVar2 = new com.baidu.tieba.frs.live.b(bVar, this.fvH.getUniqueId());
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

    private void bpc() {
        if (this.fCu != null && this.fCu.getForum() != null && !StringUtils.isNull(this.fCu.getForum().getId()) && this.fCE != null) {
            this.fCE.setForumId(this.fCu.getForum().getId());
        }
    }

    private void cb(List<com.baidu.adp.widget.ListView.a> list) {
        if (list != null) {
            for (com.baidu.adp.widget.ListView.a aVar : list) {
                if (aVar instanceof com.baidu.tieba.frs.h) {
                    ((com.baidu.tieba.frs.h) aVar).a(this.ftv);
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
