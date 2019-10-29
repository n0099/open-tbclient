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
    private final HashMap<Integer, bh> fEl;
    private FrsViewData fEm;
    private r fEo;
    private g fEp;
    private o fEq;
    private m fEr;
    private f fEs;
    private h fEt;
    private p fEu;
    private s fEv;
    private x fEw;
    private com.baidu.adp.widget.ListView.a fEx;
    private n fEy;
    private com.baidu.adp.widget.ListView.r fdE;
    private FrsFragment fxh;
    private List<com.baidu.adp.widget.ListView.a> agQ = new LinkedList();
    private boolean fEn = false;
    private final com.baidu.tieba.frs.f fuU = new com.baidu.tieba.frs.f();

    public l(FrsFragment frsFragment, com.baidu.adp.widget.ListView.r rVar, boolean z) {
        this.fdE = rVar;
        a(frsFragment, rVar);
        this.fEl = new HashMap<>();
        ko(z);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r3v29, resolved type: com.baidu.tieba.frs.FrsFragment */
    /* JADX WARN: Multi-variable type inference failed */
    public void a(FrsFragment frsFragment, com.baidu.adp.widget.ListView.r rVar) {
        this.fxh = frsFragment;
        this.fEx = com.baidu.tieba.frs.c.bji().a(frsFragment.getPageContext(), com.baidu.tieba.tbadkCore.u.jhl, this.fxh.getUniqueId(), false);
        this.fEo = new r(frsFragment.getTbPageContext(), bh.cby, this.fxh.getUniqueId());
        this.fEo.a(rVar);
        this.fEo.setInFrsAllThread(true);
        this.fEp = new g(frsFragment.getTbPageContext(), bh.cbz, this.fxh.getUniqueId());
        this.fEp.a(rVar);
        this.fEq = new o(frsFragment.getTbPageContext(), bh.cbB, this.fxh.getUniqueId());
        this.fEq.a(rVar);
        this.fEr = new m(frsFragment.getTbPageContext(), bh.cbC, this.fxh.getUniqueId());
        this.fEr.a(rVar);
        this.fEs = new f(frsFragment.getTbPageContext(), bh.cbD, this.fxh.getUniqueId());
        this.fEs.a(rVar);
        this.fEt = new h(frsFragment.getTbPageContext(), bh.cbE, this.fxh.getUniqueId());
        this.fEt.a(rVar);
        this.fEu = new p(frsFragment.getTbPageContext(), bh.cbS, this.fxh.getUniqueId());
        this.fEu.a(rVar);
        this.fEv = new s(frsFragment.getPageContext(), bh.cbI, this.fxh.getUniqueId());
        this.fEv.setInFrsAllThread(true);
        this.fEv.a(rVar);
        k kVar = new k(frsFragment.getPageContext(), bh.cbG, this.fxh.getUniqueId());
        kVar.a(rVar);
        kVar.setInFrsAllThread(true);
        q qVar = new q(frsFragment.getPageContext(), bh.cbM, this.fxh.getUniqueId());
        qVar.a(rVar);
        qVar.setInFrsAllThread(true);
        s sVar = new s(frsFragment.getPageContext(), bh.cbN, this.fxh.getUniqueId());
        sVar.a(rVar);
        sVar.setInFrsAllThread(true);
        j jVar = new j(frsFragment.getPageContext(), bh.cbW, this.fxh.getUniqueId());
        jVar.a(rVar);
        i iVar = new i(frsFragment.getPageContext(), bh.cbO, this.fxh.getUniqueId());
        iVar.a(rVar);
        this.fEw = new x(frsFragment.getPageContext().getPageActivity(), com.baidu.tieba.tbadkCore.n.jhd, this.fxh.getUniqueId());
        this.fEy = new n(frsFragment.getPageContext(), bh.cbH, this.fxh.getUniqueId());
        this.fEy.a(rVar);
        this.fEy.setVoiceManager(frsFragment.getVoiceManager());
        this.fEy.setInFrsAllThread(true);
        com.baidu.adp.widget.ListView.a<? extends bg, ? extends v.a> a = com.baidu.tieba.frs.c.bji().a(frsFragment.getPageContext(), this.fxh.getUniqueId(), true);
        com.baidu.adp.widget.ListView.a<? extends bh, ? extends v.a> b = com.baidu.tieba.frs.c.bji().b(frsFragment.getPageContext(), bh.cdp, this.fxh.getUniqueId());
        com.baidu.tieba.frs.l lVar = new com.baidu.tieba.frs.l(frsFragment.getPageContext(), com.baidu.tieba.frs.m.fyi);
        e eVar = new e(frsFragment.getPageContext(), com.baidu.tieba.frs.p.fyx);
        w wVar = new w(frsFragment.getPageContext(), com.baidu.tieba.frs.q.fyC, this.fxh.getUniqueId());
        this.agQ.add(this.fEx);
        this.agQ.add(this.fEo);
        this.agQ.add(this.fEp);
        this.agQ.add(this.fEq);
        this.agQ.add(this.fEr);
        this.agQ.add(this.fEs);
        this.agQ.add(this.fEt);
        this.agQ.add(this.fEu);
        this.agQ.add(this.fEw);
        this.agQ.add(kVar);
        this.agQ.add(qVar);
        this.agQ.add(this.fEy);
        this.agQ.add(this.fEv);
        this.agQ.add(a);
        this.agQ.add(b);
        this.agQ.add(lVar);
        this.agQ.add(eVar);
        this.agQ.add(jVar);
        this.agQ.add(iVar);
        this.agQ.add(wVar);
        this.agQ.add(sVar);
        com.baidu.tieba.InjectPlugin.b.b bVar = new com.baidu.tieba.InjectPlugin.b.b(this.fxh, 1);
        bVar.setExtraData(this.agQ);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_FEED_AD_PLUGIN_OPERATE, bVar));
        cn(this.agQ);
        rVar.addAdapters(this.agQ);
        AbsDelegateAdapterList absDelegateAdapterList = new AbsDelegateAdapterList();
        CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_ADD_ADAPTER, absDelegateAdapterList);
        CustomMessage customMessage = new CustomMessage(CmdConfigCustom.CMD_FRS_ADD_ADAPTER);
        customMessage.setTag(this.fxh.getUniqueId());
        customResponsedMessage.setOrginalMessage(customMessage);
        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
        rh("page_frs");
        if (!absDelegateAdapterList.isEmpty()) {
            Iterator it = absDelegateAdapterList.iterator();
            while (it.hasNext()) {
                com.baidu.adp.widget.ListView.a aVar = (com.baidu.adp.widget.ListView.a) it.next();
                if (aVar instanceof com.baidu.tieba.frs.h) {
                    ((com.baidu.tieba.frs.h) aVar).a(this.fxh.getPageContext(), this.fxh.getUniqueId());
                }
            }
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(absDelegateAdapterList);
            if (this.agQ != null) {
                this.agQ.addAll(arrayList);
            }
            if (this.fdE != null) {
                this.fdE.addAdapters(arrayList);
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.a.aa
    public void onDestory() {
        for (com.baidu.adp.widget.ListView.a aVar : this.agQ) {
            if (aVar instanceof com.baidu.tieba.frs.h) {
                ((com.baidu.tieba.frs.h) aVar).release();
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.a.aa
    public HashMap<Integer, bh> bmY() {
        return this.fEl;
    }

    @Override // com.baidu.tieba.frs.entelechy.a.aa
    public void notifyDataSetChanged() {
        if (this.fdE.getListAdapter() != null) {
            this.fdE.getListAdapter().notifyDataSetChanged();
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.a.aa
    public int bmZ() {
        if (this.fEx != null) {
            return R.id.frs_bawu_center;
        }
        return 0;
    }

    @Override // com.baidu.tieba.frs.entelechy.a.aa
    public boolean o(BdUniqueId bdUniqueId) {
        if (bdUniqueId == null) {
            return false;
        }
        for (com.baidu.adp.widget.ListView.a aVar : this.agQ) {
            if (aVar != null && aVar.getType() == bdUniqueId) {
                return true;
            }
        }
        return false;
    }

    @Override // com.baidu.tieba.frs.entelechy.a.aa
    public void a(com.baidu.adp.widget.ListView.s sVar) {
        if (this.agQ != null && this.agQ.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.agQ) {
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
        if (this.agQ != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.agQ) {
                if (aVar instanceof com.baidu.tieba.card.z) {
                    ((com.baidu.tieba.card.z) aVar).setForumName(str);
                }
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v1, resolved type: com.baidu.tieba.frs.FrsFragment */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.baidu.tieba.frs.entelechy.a.aa
    public void bna() {
        if (this.agQ != null && this.agQ.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.agQ) {
                if (aVar instanceof com.baidu.tieba.frs.h) {
                    ((com.baidu.tieba.frs.h) aVar).a(this.fxh.getPageContext(), this.fxh.getUniqueId());
                }
            }
            cn(this.agQ);
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.a.aa
    public List<com.baidu.adp.widget.ListView.m> getDatas() {
        if (this.fdE != null) {
            return this.fdE.getData();
        }
        return null;
    }

    @Override // com.baidu.tieba.frs.entelechy.a.aa
    public int bnb() {
        if (this.fEx != null) {
            return R.id.frs_fortune_bag_item;
        }
        return 0;
    }

    @Override // com.baidu.tieba.frs.entelechy.a.aa
    public int bnc() {
        if (this.fEx != null) {
            return R.id.frs_my_service_item;
        }
        return 0;
    }

    public void aaQ() {
        if (this.dataList != null) {
            this.fdE.setData(this.dataList);
        }
        notifyDataSetChanged();
    }

    @Override // com.baidu.tieba.frs.entelechy.a.aa
    public void setFromCDN(boolean z) {
        if (this.agQ != null && this.agQ.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.agQ) {
                if (aVar instanceof com.baidu.tieba.frs.h) {
                    ((com.baidu.tieba.frs.h) aVar).setFromCDN(z);
                }
            }
            if (this.fEo != null) {
                this.fEo.setFromCDN(z);
            }
            if (this.fEp != null) {
                this.fEp.setFromCDN(z);
            }
            if (this.fEq != null) {
                this.fEq.setFromCDN(z);
            }
            if (this.fEr != null) {
                this.fEr.setFromCDN(z);
            }
            if (this.fEs != null) {
                this.fEs.setFromCDN(z);
            }
            if (this.fEt != null) {
                this.fEt.setFromCDN(z);
            }
            if (this.fEv != null) {
                this.fEv.setFromCDN(z);
            }
            if (this.fEy != null) {
                this.fEy.setFromCDN(z);
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.a.aa
    public void bnd() {
        List<com.baidu.adp.widget.ListView.m> data;
        if (this.fdE != null && this.fdE.getData() != null && this.fdE.getData().size() != 0 && (data = this.fdE.getData()) != null && data.size() != 0) {
            for (com.baidu.adp.widget.ListView.m mVar : data) {
                if (mVar instanceof bh) {
                    if (((bh) mVar).aiB() != 0) {
                        ((bh) mVar).ajw();
                    }
                } else if ((mVar instanceof bg) && ((bg) mVar).cbq.aiB() != 0) {
                    ((bg) mVar).cbq.ajw();
                }
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.a.aa
    public void ko(boolean z) {
        if (this.fEn != z) {
            this.fEn = z;
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
            if ((next instanceof bg) && ((bg) next).cbq.ajn()) {
                it.remove();
            }
        }
        this.fdE.setData(arrayList);
        this.fEm = frsViewData;
        bmz();
        bnf();
        this.dataList = arrayList;
    }

    public void b(FrsViewData frsViewData) {
        if (this.agQ != null && this.agQ.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.agQ) {
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
                if (this.fEl != null && !this.fEl.containsValue(mVar)) {
                    this.fEl.put(Integer.valueOf(i2), (bh) mVar);
                }
            }
            i = i2 + 1;
        }
    }

    private void ac(ArrayList<com.baidu.adp.widget.ListView.m> arrayList) {
        int i;
        if (this.agQ != null && this.agQ.size() != 0) {
            int i2 = 0;
            if (arrayList == null || arrayList.size() <= 0) {
                i = 0;
            } else {
                Iterator<com.baidu.adp.widget.ListView.m> it = arrayList.iterator();
                while (true) {
                    i = i2;
                    if (!it.hasNext() || it.next().getType().getId() != bh.cbt.getId()) {
                        break;
                    }
                    i2 = i + 1;
                }
            }
            for (com.baidu.adp.widget.ListView.a aVar : this.agQ) {
                if (aVar instanceof com.baidu.tieba.frs.h) {
                    ((com.baidu.tieba.frs.h) aVar).qk(i);
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
                bh bhVar = ((bg) mVar2).cbq;
                if (i == 0) {
                    bhVar.isFirstFloor = true;
                } else {
                    bhVar.isFirstFloor = false;
                }
                String agJ = bhVar.agJ();
                if (mVar instanceof com.baidu.tieba.frs.p) {
                    bhVar.needTopMargin = false;
                } else if (mVar != null && !c(mVar)) {
                    bhVar.needTopMargin = false;
                } else if ((mVar instanceof bg) && c(mVar) && !TextUtils.isEmpty(((bg) mVar).cbq.agJ())) {
                    bhVar.needTopMargin = true;
                } else if (c(mVar2) && !TextUtils.isEmpty(agJ)) {
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
        return type == bh.cbu || type == bh.cbH || type == bh.cbI || type == bh.cbN || type == bh.cbW;
    }

    private void bmz() {
        com.baidu.tieba.frs.d.b bmX;
        if (this.fEm != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.agQ) {
                if ((aVar instanceof com.baidu.tieba.frs.d.d) && (bmX = ((com.baidu.tieba.frs.d.d) aVar).bmX()) != null) {
                    if (this.fEm.needLog == 1) {
                        bmX.fQB = true;
                    } else {
                        bmX.fQB = false;
                    }
                    if (this.fEm.getForum() != null) {
                        bmX.fQD = this.fEm.getForum().getId();
                    }
                    if (this.fxh != null && this.fxh.bjK() != null) {
                        bmX.fQC = this.fxh.bjK().bpp();
                    }
                }
            }
            bne();
        }
    }

    private void bne() {
        com.baidu.tieba.frs.d.b bVar = new com.baidu.tieba.frs.d.b();
        if (this.fEm.needLog == 1) {
            bVar.fQB = true;
        } else {
            bVar.fQB = false;
        }
        if (this.fEm.getForum() != null) {
            bVar.fQD = this.fEm.getForum().getId();
        }
        if (this.fxh != null && this.fxh.bjK() != null) {
            bVar.fQC = this.fxh.bjK().bpp();
        }
        if (com.baidu.tieba.frs.d.d.fDZ != null) {
            bVar.fQE = com.baidu.tieba.frs.d.d.fDZ.fQE;
            bVar.fQF = com.baidu.tieba.frs.d.d.fDZ.fQF;
        }
        com.baidu.tieba.frs.live.b bVar2 = new com.baidu.tieba.frs.live.b(bVar, this.fxh.getUniqueId());
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

    private void bnf() {
        if (this.fEm != null && this.fEm.getForum() != null && !StringUtils.isNull(this.fEm.getForum().getId()) && this.fEw != null) {
            this.fEw.setForumId(this.fEm.getForum().getId());
        }
    }

    private void cn(List<com.baidu.adp.widget.ListView.a> list) {
        if (list != null) {
            for (com.baidu.adp.widget.ListView.a aVar : list) {
                if (aVar instanceof com.baidu.tieba.frs.h) {
                    ((com.baidu.tieba.frs.h) aVar).a(this.fuU);
                }
            }
        }
    }

    private void rh(String str) {
        if (this.agQ != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.agQ) {
                if (aVar instanceof com.baidu.tieba.a.f) {
                    ((com.baidu.tieba.a.f) aVar).rh(str);
                }
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.a.aa
    public void a(com.baidu.tieba.frs.d dVar) {
        if (this.agQ != null && this.agQ.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.agQ) {
                if (aVar instanceof com.baidu.tieba.frs.h) {
                    ((com.baidu.tieba.frs.h) aVar).a(dVar);
                }
            }
        }
    }
}
