package com.baidu.tieba.frs.entelechy.adapter;

import android.text.TextUtils;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.data.ca;
import com.baidu.tbadk.core.data.cb;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.AbsDelegateAdapterList;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.tbadkCore.FrsViewData;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes2.dex */
public class u implements al {
    private ArrayList<com.baidu.adp.widget.ListView.n> dataList;
    private com.baidu.adp.widget.ListView.s iNH;
    private FrsFragment jkB;
    private final HashMap<Integer, cb> jtc;
    private FrsViewData jtd;
    private ai jtf;
    private com.baidu.adp.widget.ListView.a jtg;
    private ac jth;
    private o jti;
    private z jtj;
    private w jtk;
    private n jtl;
    private q jtm;
    private aa jtn;
    private ae jto;
    private y jtp;
    private v jtq;
    private ad jtr;
    private p jts;
    private x jtt;
    private List<com.baidu.adp.widget.ListView.a> boS = new LinkedList();
    private boolean jte = false;
    private final com.baidu.tieba.frs.i jhG = new com.baidu.tieba.frs.i();

    public u(FrsFragment frsFragment, com.baidu.adp.widget.ListView.s sVar, boolean z) {
        this.iNH = sVar;
        a(frsFragment, sVar);
        this.jtc = new HashMap<>();
        rf(z);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r6v35, resolved type: com.baidu.tieba.frs.FrsFragment */
    /* JADX WARN: Multi-variable type inference failed */
    public void a(FrsFragment frsFragment, com.baidu.adp.widget.ListView.s sVar) {
        this.jkB = frsFragment;
        this.jtg = com.baidu.tieba.frs.e.cBN().a(frsFragment.getPageContext(), com.baidu.tieba.tbadkCore.x.nxS, this.jkB.getUniqueId(), false);
        this.jth = new ac(frsFragment.getTbPageContext(), cb.eRT, this.jkB.getUniqueId());
        this.jth.b(sVar);
        this.jti = new o(frsFragment.getTbPageContext(), cb.eRU, this.jkB.getUniqueId());
        this.jti.b(sVar);
        this.jtj = new z(frsFragment.getTbPageContext(), cb.eRW, this.jkB.getUniqueId());
        this.jtj.b(sVar);
        this.jtk = new w(frsFragment.getTbPageContext(), cb.eRX, this.jkB.getUniqueId());
        this.jtk.b(sVar);
        this.jtl = new n(frsFragment.getTbPageContext(), cb.eRZ, this.jkB.getUniqueId());
        this.jtl.b(sVar);
        this.jtm = new q(frsFragment.getTbPageContext(), cb.eSa, this.jkB.getUniqueId());
        this.jtm.b(sVar);
        this.jto = new ae(frsFragment.getTbPageContext(), cb.eSf, this.jkB.getUniqueId());
        this.jto.b(sVar);
        this.jtn = new aa(frsFragment.getTbPageContext(), cb.eSz, this.jkB.getUniqueId());
        this.jtn.b(sVar);
        this.jtp = new y(frsFragment.getTbPageContext(), cb.eSg, this.jkB.getUniqueId());
        this.jtp.b(sVar);
        this.jtq = new v(frsFragment.getTbPageContext(), cb.eSh, this.jkB.getUniqueId());
        this.jtq.b(sVar);
        this.jtr = new ad(frsFragment.getPageContext(), cb.eSl, this.jkB.getUniqueId());
        this.jtr.b(sVar);
        this.jts = new p(frsFragment.getPageContext(), cb.eSE, this.jkB.getUniqueId());
        this.jts.b(sVar);
        t tVar = new t(frsFragment.getPageContext(), cb.eSj, this.jkB.getUniqueId());
        tVar.b(sVar);
        ab abVar = new ab(frsFragment.getPageContext(), cb.eSq, this.jkB.getUniqueId());
        abVar.b(sVar);
        a aVar = new a(frsFragment.getPageContext(), cb.eSc, frsFragment.getUniqueId());
        aVar.b(sVar);
        aVar.uZ(1);
        d dVar = new d(frsFragment.getPageContext(), cb.eRY, frsFragment.getUniqueId());
        dVar.b(sVar);
        b bVar = new b(frsFragment.getPageContext(), cb.eSs, this.jkB.getUniqueId());
        bVar.b(sVar);
        bVar.setInFrsAllThread(true);
        i iVar = new i(frsFragment.getPageContext(), cb.eSr, this.jkB.getUniqueId());
        iVar.b(sVar);
        iVar.setInFrsAllThread(true);
        j jVar = new j(frsFragment.getPageContext(), cb.eSt, this.jkB.getUniqueId());
        jVar.b(sVar);
        jVar.setInFrsAllThread(true);
        ad adVar = new ad(frsFragment.getPageContext(), cb.eSu, this.jkB.getUniqueId());
        adVar.b(sVar);
        s sVar2 = new s(frsFragment.getPageContext(), cb.eSD, this.jkB.getUniqueId());
        sVar2.b(sVar);
        r rVar = new r(frsFragment.getPageContext(), cb.eSv, this.jkB.getUniqueId());
        rVar.b(sVar);
        this.jtf = new ai(frsFragment.getPageContext(), com.baidu.tieba.tbadkCore.q.nxK, this.jkB.getUniqueId());
        this.jtt = new x(frsFragment.getPageContext(), cb.eSk, this.jkB.getUniqueId());
        this.jtt.b(sVar);
        com.baidu.adp.widget.ListView.a<? extends ca, ? extends TypeAdapter.ViewHolder> a2 = com.baidu.tieba.frs.e.cBN().a(frsFragment.getPageContext(), this.jkB.getUniqueId(), true);
        com.baidu.adp.widget.ListView.a<? extends cb, ? extends TypeAdapter.ViewHolder> b = com.baidu.tieba.frs.e.cBN().b(frsFragment.getPageContext(), cb.eTY, this.jkB.getUniqueId());
        com.baidu.tieba.frs.r rVar2 = new com.baidu.tieba.frs.r(frsFragment.getPageContext(), com.baidu.tieba.frs.s.jlC);
        m mVar = new m(frsFragment.getPageContext(), com.baidu.tieba.frs.u.jlT);
        FrsUserRecommendAdapter frsUserRecommendAdapter = new FrsUserRecommendAdapter(frsFragment.getPageContext(), com.baidu.tieba.frs.w.jmc, this.jkB.getUniqueId());
        g gVar = new g(frsFragment.getPageContext(), cb.eSe, this.jkB.getUniqueId());
        gVar.a((BdTypeRecyclerView) sVar);
        this.boS.add(this.jtg);
        this.boS.add(this.jth);
        this.boS.add(this.jti);
        this.boS.add(this.jtj);
        this.boS.add(this.jtk);
        this.boS.add(this.jtl);
        this.boS.add(this.jtm);
        this.boS.add(this.jtn);
        this.boS.add(this.jto);
        this.boS.add(this.jtp);
        this.boS.add(this.jtq);
        this.boS.add(this.jtf);
        this.boS.add(tVar);
        this.boS.add(abVar);
        this.boS.add(aVar);
        this.boS.add(dVar);
        this.boS.add(bVar);
        this.boS.add(iVar);
        this.boS.add(jVar);
        this.boS.add(this.jtt);
        this.boS.add(this.jtr);
        this.boS.add(this.jts);
        this.boS.add(a2);
        this.boS.add(b);
        this.boS.add(rVar2);
        this.boS.add(mVar);
        this.boS.add(sVar2);
        this.boS.add(rVar);
        this.boS.add(frsUserRecommendAdapter);
        this.boS.add(adVar);
        this.boS.add(gVar);
        this.boS.add(com.baidu.tieba.h.b.cNB().c(this.jkB.getBaseFragmentActivity(), AdvertAppInfo.eMN));
        com.baidu.tieba.InjectPlugin.b.b bVar2 = new com.baidu.tieba.InjectPlugin.b.b(this.jkB, 1);
        bVar2.setExtraData(this.boS);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_FEED_AD_PLUGIN_OPERATE, bVar2));
        dm(this.boS);
        sVar.addAdapters(this.boS);
        AbsDelegateAdapterList absDelegateAdapterList = new AbsDelegateAdapterList();
        CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_ADD_ADAPTER, absDelegateAdapterList);
        CustomMessage customMessage = new CustomMessage(CmdConfigCustom.CMD_FRS_ADD_ADAPTER);
        customMessage.setTag(this.jkB.getUniqueId());
        customResponsedMessage.setOrginalMessage(customMessage);
        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
        ED("page_frs");
        if (!absDelegateAdapterList.isEmpty()) {
            Iterator it = absDelegateAdapterList.iterator();
            while (it.hasNext()) {
                com.baidu.adp.widget.ListView.a aVar2 = (com.baidu.adp.widget.ListView.a) it.next();
                if (aVar2 instanceof com.baidu.tieba.frs.k) {
                    ((com.baidu.tieba.frs.k) aVar2).a(this.jkB.getPageContext(), this.jkB.getUniqueId());
                }
            }
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(absDelegateAdapterList);
            if (this.boS != null) {
                this.boS.addAll(arrayList);
            }
            if (this.iNH != null) {
                this.iNH.addAdapters(arrayList);
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.adapter.al
    public void onDestory() {
        for (com.baidu.adp.widget.ListView.a aVar : this.boS) {
            if (aVar instanceof com.baidu.tieba.frs.k) {
                ((com.baidu.tieba.frs.k) aVar).release();
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.adapter.al
    public HashMap<Integer, cb> cGF() {
        return this.jtc;
    }

    @Override // com.baidu.tieba.frs.entelechy.adapter.al
    public void notifyDataSetChanged() {
        if (this.iNH.getListAdapter() != null) {
            this.iNH.getListAdapter().notifyDataSetChanged();
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.adapter.al
    public int cGG() {
        if (this.jtg != null) {
            return R.id.frs_bawu_center;
        }
        return 0;
    }

    @Override // com.baidu.tieba.frs.entelechy.adapter.al
    public boolean r(BdUniqueId bdUniqueId) {
        if (bdUniqueId == null) {
            return false;
        }
        for (com.baidu.adp.widget.ListView.a aVar : this.boS) {
            if (aVar != null && aVar.getType() == bdUniqueId) {
                return true;
            }
        }
        return false;
    }

    @Override // com.baidu.tieba.frs.entelechy.adapter.al
    public void a(com.baidu.adp.widget.ListView.w wVar) {
        if (this.boS != null && this.boS.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.boS) {
                if (aVar instanceof com.baidu.tieba.frs.k) {
                    ((com.baidu.tieba.frs.k) aVar).a(wVar);
                } else if ((aVar instanceof x) || (aVar instanceof ad)) {
                    aVar.a(wVar);
                }
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.adapter.al
    public void setForumName(String str) {
        if (this.boS != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.boS) {
                if (aVar instanceof com.baidu.tieba.card.z) {
                    ((com.baidu.tieba.card.z) aVar).setForumName(str);
                }
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v1, resolved type: com.baidu.tieba.frs.FrsFragment */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.baidu.tieba.frs.entelechy.adapter.al
    public void cGH() {
        if (this.boS != null && this.boS.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.boS) {
                if (aVar instanceof com.baidu.tieba.frs.k) {
                    ((com.baidu.tieba.frs.k) aVar).a(this.jkB.getPageContext(), this.jkB.getUniqueId());
                }
            }
            dm(this.boS);
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.adapter.al
    public List<com.baidu.adp.widget.ListView.n> getDatas() {
        if (this.iNH != null) {
            return this.iNH.getData();
        }
        return null;
    }

    @Override // com.baidu.tieba.frs.entelechy.adapter.al
    public int cGI() {
        if (this.jtg != null) {
            return R.id.frs_fortune_bag_item;
        }
        return 0;
    }

    @Override // com.baidu.tieba.frs.entelechy.adapter.al
    public int cGJ() {
        if (this.jtg != null) {
            return R.id.frs_my_service_item;
        }
        return 0;
    }

    public void bbE() {
        if (this.dataList != null) {
            this.iNH.setData(this.dataList);
        }
        notifyDataSetChanged();
    }

    @Override // com.baidu.tieba.frs.entelechy.adapter.al
    public void setFromCDN(boolean z) {
        if (this.boS != null && this.boS.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.boS) {
                if (aVar instanceof com.baidu.tieba.frs.k) {
                    ((com.baidu.tieba.frs.k) aVar).setFromCDN(z);
                }
            }
            if (this.jth != null) {
                this.jth.setFromCDN(z);
            }
            if (this.jti != null) {
                this.jti.setFromCDN(z);
            }
            if (this.jtj != null) {
                this.jtj.setFromCDN(z);
            }
            if (this.jtk != null) {
                this.jtk.setFromCDN(z);
            }
            if (this.jtl != null) {
                this.jtl.setFromCDN(z);
            }
            if (this.jtm != null) {
                this.jtm.setFromCDN(z);
            }
            if (this.jtr != null) {
                this.jtr.setFromCDN(z);
            }
            if (this.jtt != null) {
                this.jtt.setFromCDN(z);
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.adapter.al
    public void cGK() {
        List<com.baidu.adp.widget.ListView.n> data;
        if (this.iNH != null && this.iNH.getData() != null && this.iNH.getData().size() != 0 && (data = this.iNH.getData()) != null && data.size() != 0) {
            for (com.baidu.adp.widget.ListView.n nVar : data) {
                if (nVar instanceof cb) {
                    if (((cb) nVar).bnN() != 0) {
                        ((cb) nVar).boR();
                    }
                } else if ((nVar instanceof ca) && ((ca) nVar).eLr.bnN() != 0) {
                    ((ca) nVar).eLr.boR();
                }
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.adapter.al
    public void rf(boolean z) {
        if (this.jte != z) {
            this.jte = z;
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.adapter.al
    public void b(ArrayList<com.baidu.adp.widget.ListView.n> arrayList, FrsViewData frsViewData) {
        b(frsViewData);
        cFk();
        com.baidu.tieba.tbadkCore.v.x(arrayList, 1);
        av(arrayList);
        aw(arrayList);
        ax(arrayList);
        Iterator<com.baidu.adp.widget.ListView.n> it = arrayList.iterator();
        while (it.hasNext()) {
            com.baidu.adp.widget.ListView.n next = it.next();
            if ((next instanceof ca) && ((ca) next).eLr.isTop()) {
                it.remove();
            }
        }
        this.iNH.setData(arrayList);
        this.jtd = frsViewData;
        cFO();
        cGL();
        this.dataList = arrayList;
    }

    public void b(FrsViewData frsViewData) {
        if (this.boS != null && this.boS.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.boS) {
                if (aVar instanceof com.baidu.tieba.frs.k) {
                    ((com.baidu.tieba.frs.k) aVar).b(frsViewData);
                }
            }
        }
    }

    private ArrayList<Integer> av(ArrayList<com.baidu.adp.widget.ListView.n> arrayList) {
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
            com.baidu.adp.widget.ListView.n nVar = arrayList.get(i2);
            if (nVar instanceof AdvertAppInfo) {
                arrayList2.add(Integer.valueOf(i2));
                if (this.jtc != null && !this.jtc.containsValue(nVar)) {
                    this.jtc.put(Integer.valueOf(i2), (cb) nVar);
                }
            }
            i = i2 + 1;
        }
    }

    private void aw(ArrayList<com.baidu.adp.widget.ListView.n> arrayList) {
        int i;
        if (this.boS != null && this.boS.size() != 0) {
            int i2 = 0;
            if (arrayList == null || arrayList.size() <= 0) {
                i = 0;
            } else {
                Iterator<com.baidu.adp.widget.ListView.n> it = arrayList.iterator();
                while (true) {
                    i = i2;
                    if (!it.hasNext() || it.next().getType().getId() != cb.eRM.getId()) {
                        break;
                    }
                    i2 = i + 1;
                }
            }
            for (com.baidu.adp.widget.ListView.a aVar : this.boS) {
                if (aVar instanceof com.baidu.tieba.frs.k) {
                    ((com.baidu.tieba.frs.k) aVar).yv(i);
                }
            }
        }
    }

    private void ax(ArrayList<com.baidu.adp.widget.ListView.n> arrayList) {
        int count = com.baidu.tbadk.core.util.y.getCount(arrayList);
        for (int i = 0; i < count; i++) {
            com.baidu.adp.widget.ListView.n nVar = (com.baidu.adp.widget.ListView.n) com.baidu.tbadk.core.util.y.getItem(arrayList, i - 1);
            com.baidu.adp.widget.ListView.n nVar2 = (com.baidu.adp.widget.ListView.n) com.baidu.tbadk.core.util.y.getItem(arrayList, i);
            if (nVar2 instanceof ca) {
                cb cbVar = ((ca) nVar2).eLr;
                if (i == 0) {
                    cbVar.isFirstFloor = true;
                } else {
                    cbVar.isFirstFloor = false;
                }
                String blq = cbVar.blq();
                if (nVar instanceof com.baidu.tieba.frs.u) {
                    cbVar.needTopMargin = false;
                } else if (nVar != null && !c(nVar)) {
                    cbVar.needTopMargin = false;
                } else if ((nVar instanceof ca) && c(nVar) && !TextUtils.isEmpty(((ca) nVar).eLr.blq())) {
                    cbVar.needTopMargin = true;
                } else if (c(nVar2) && !TextUtils.isEmpty(blq)) {
                    cbVar.needTopMargin = true;
                } else {
                    cbVar.needTopMargin = false;
                }
            }
        }
    }

    private boolean c(com.baidu.adp.widget.ListView.n nVar) {
        if (nVar == null) {
            return false;
        }
        BdUniqueId type = nVar.getType();
        return type == cb.eRN || type == cb.eSk || type == cb.eSl || type == cb.eSu || type == cb.eSD;
    }

    private void cFk() {
        if (!com.baidu.tbadk.core.util.y.isEmpty(this.boS) && this.jkB != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.boS) {
                if (aVar instanceof com.baidu.tieba.frs.k) {
                    ((com.baidu.tieba.frs.k) aVar).a(this.jkB.getTbPageTag());
                }
            }
        }
    }

    private void cFO() {
        com.baidu.tieba.frs.b.b statisticMetaData;
        if (this.jtd != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.boS) {
                if ((aVar instanceof com.baidu.tieba.frs.b.d) && (statisticMetaData = ((com.baidu.tieba.frs.b.d) aVar).getStatisticMetaData()) != null) {
                    if (this.jtd.needLog == 1) {
                        statisticMetaData.jJh = true;
                    } else {
                        statisticMetaData.jJh = false;
                    }
                    if (this.jtd.getForum() != null) {
                        statisticMetaData.jJj = this.jtd.getForum().getId();
                    }
                    if (this.jkB != null && this.jkB.cCC() != null) {
                        int cJS = this.jkB.cCC().cJS();
                        if (cJS == -1) {
                            cJS = this.jkB.cCC().cJT();
                        }
                        statisticMetaData.jJi = cJS;
                    }
                }
            }
        }
    }

    private void cGL() {
        if (this.jtd != null && this.jtd.getForum() != null && !StringUtils.isNull(this.jtd.getForum().getId()) && this.jtf != null) {
            this.jtf.setForumId(this.jtd.getForum().getId());
        }
    }

    private void dm(List<com.baidu.adp.widget.ListView.a> list) {
        if (list != null) {
            for (com.baidu.adp.widget.ListView.a aVar : list) {
                if (aVar instanceof com.baidu.tieba.frs.k) {
                    ((com.baidu.tieba.frs.k) aVar).a(this.jhG);
                }
            }
        }
    }

    private void ED(String str) {
        if (this.boS != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.boS) {
                if (aVar instanceof com.baidu.tieba.a.f) {
                    ((com.baidu.tieba.a.f) aVar).ED(str);
                }
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.adapter.al
    public void a(com.baidu.tieba.frs.f fVar) {
        if (this.boS != null && this.boS.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.boS) {
                if (aVar instanceof com.baidu.tieba.frs.k) {
                    ((com.baidu.tieba.frs.k) aVar).a(fVar);
                }
            }
        }
    }
}
