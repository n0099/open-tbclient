package com.baidu.tieba.frs.entelechy.a;

import android.text.TextUtils;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.aa;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.data.bk;
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
    private ArrayList<com.baidu.adp.widget.ListView.o> dataList;
    private com.baidu.adp.widget.ListView.t gSQ;
    private FrsFragment hpb;
    private final HashMap<Integer, bk> hwk;
    private FrsViewData hwl;
    private ae hwn;
    private com.baidu.adp.widget.ListView.a hwo;
    private y hwp;
    private n hwq;
    private v hwr;
    private t hws;
    private m hwt;
    private o hwu;
    private w hwv;
    private z hww;
    private u hwx;
    private List<com.baidu.adp.widget.ListView.a> aSj = new LinkedList();
    private boolean hwm = false;
    private final com.baidu.tieba.frs.f hmJ = new com.baidu.tieba.frs.f();

    public s(FrsFragment frsFragment, com.baidu.adp.widget.ListView.t tVar, boolean z) {
        this.gSQ = tVar;
        a(frsFragment, tVar);
        this.hwk = new HashMap<>();
        ns(z);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r5v29, resolved type: com.baidu.tieba.frs.FrsFragment */
    /* JADX WARN: Multi-variable type inference failed */
    public void a(FrsFragment frsFragment, com.baidu.adp.widget.ListView.t tVar) {
        this.hpb = frsFragment;
        this.hwo = com.baidu.tieba.frs.c.bUh().a(frsFragment.getPageContext(), com.baidu.tieba.tbadkCore.v.ljE, this.hpb.getUniqueId(), false);
        this.hwp = new y(frsFragment.getTbPageContext(), bk.dEI, this.hpb.getUniqueId());
        this.hwp.b(tVar);
        this.hwq = new n(frsFragment.getTbPageContext(), bk.dEJ, this.hpb.getUniqueId());
        this.hwq.b(tVar);
        this.hwr = new v(frsFragment.getTbPageContext(), bk.dEL, this.hpb.getUniqueId());
        this.hwr.b(tVar);
        this.hws = new t(frsFragment.getTbPageContext(), bk.dEM, this.hpb.getUniqueId());
        this.hws.b(tVar);
        this.hwt = new m(frsFragment.getTbPageContext(), bk.dEO, this.hpb.getUniqueId());
        this.hwt.b(tVar);
        this.hwu = new o(frsFragment.getTbPageContext(), bk.dEP, this.hpb.getUniqueId());
        this.hwu.b(tVar);
        this.hwv = new w(frsFragment.getTbPageContext(), bk.dFi, this.hpb.getUniqueId());
        this.hwv.b(tVar);
        this.hww = new z(frsFragment.getPageContext(), bk.dEV, this.hpb.getUniqueId());
        this.hww.b(tVar);
        r rVar = new r(frsFragment.getPageContext(), bk.dET, this.hpb.getUniqueId());
        rVar.b(tVar);
        x xVar = new x(frsFragment.getPageContext(), bk.dEZ, this.hpb.getUniqueId());
        xVar.b(tVar);
        a aVar = new a(frsFragment.getPageContext(), bk.dER, frsFragment.getUniqueId());
        aVar.b(tVar);
        aVar.qw(1);
        e eVar = new e(frsFragment.getPageContext(), bk.dEN, frsFragment.getUniqueId());
        eVar.b(tVar);
        b bVar = new b(frsFragment.getPageContext(), bk.dFb, this.hpb.getUniqueId());
        bVar.b(tVar);
        bVar.setInFrsAllThread(true);
        h hVar = new h(frsFragment.getPageContext(), bk.dFa, this.hpb.getUniqueId());
        hVar.b(tVar);
        hVar.setInFrsAllThread(true);
        i iVar = new i(frsFragment.getPageContext(), bk.dFc, this.hpb.getUniqueId());
        iVar.b(tVar);
        iVar.setInFrsAllThread(true);
        z zVar = new z(frsFragment.getPageContext(), bk.dFd, this.hpb.getUniqueId());
        zVar.b(tVar);
        q qVar = new q(frsFragment.getPageContext(), bk.dFm, this.hpb.getUniqueId());
        qVar.b(tVar);
        p pVar = new p(frsFragment.getPageContext(), bk.dFe, this.hpb.getUniqueId());
        pVar.b(tVar);
        this.hwn = new ae(frsFragment.getPageContext(), com.baidu.tieba.tbadkCore.o.ljw, this.hpb.getUniqueId());
        this.hwx = new u(frsFragment.getPageContext(), bk.dEU, this.hpb.getUniqueId());
        this.hwx.b(tVar);
        com.baidu.adp.widget.ListView.a<? extends bj, ? extends aa.a> a = com.baidu.tieba.frs.c.bUh().a(frsFragment.getPageContext(), this.hpb.getUniqueId(), true);
        com.baidu.adp.widget.ListView.a<? extends bk, ? extends aa.a> b = com.baidu.tieba.frs.c.bUh().b(frsFragment.getPageContext(), bk.dGH, this.hpb.getUniqueId());
        com.baidu.tieba.frs.o oVar = new com.baidu.tieba.frs.o(frsFragment.getPageContext(), com.baidu.tieba.frs.p.hqd);
        l lVar = new l(frsFragment.getPageContext(), com.baidu.tieba.frs.t.hqs);
        ad adVar = new ad(frsFragment.getPageContext(), com.baidu.tieba.frs.u.hqx, this.hpb.getUniqueId());
        this.aSj.add(this.hwo);
        this.aSj.add(this.hwp);
        this.aSj.add(this.hwq);
        this.aSj.add(this.hwr);
        this.aSj.add(this.hws);
        this.aSj.add(this.hwt);
        this.aSj.add(this.hwu);
        this.aSj.add(this.hwv);
        this.aSj.add(this.hwn);
        this.aSj.add(rVar);
        this.aSj.add(xVar);
        this.aSj.add(aVar);
        this.aSj.add(eVar);
        this.aSj.add(bVar);
        this.aSj.add(hVar);
        this.aSj.add(iVar);
        this.aSj.add(this.hwx);
        this.aSj.add(this.hww);
        this.aSj.add(a);
        this.aSj.add(b);
        this.aSj.add(oVar);
        this.aSj.add(lVar);
        this.aSj.add(qVar);
        this.aSj.add(pVar);
        this.aSj.add(adVar);
        this.aSj.add(zVar);
        com.baidu.tieba.InjectPlugin.b.b bVar2 = new com.baidu.tieba.InjectPlugin.b.b(this.hpb, 1);
        bVar2.setExtraData(this.aSj);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_FEED_AD_PLUGIN_OPERATE, bVar2));
        co(this.aSj);
        tVar.addAdapters(this.aSj);
        AbsDelegateAdapterList absDelegateAdapterList = new AbsDelegateAdapterList();
        CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_ADD_ADAPTER, absDelegateAdapterList);
        CustomMessage customMessage = new CustomMessage(CmdConfigCustom.CMD_FRS_ADD_ADAPTER);
        customMessage.setTag(this.hpb.getUniqueId());
        customResponsedMessage.setOrginalMessage(customMessage);
        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
        zL("page_frs");
        if (!absDelegateAdapterList.isEmpty()) {
            Iterator it = absDelegateAdapterList.iterator();
            while (it.hasNext()) {
                com.baidu.adp.widget.ListView.a aVar2 = (com.baidu.adp.widget.ListView.a) it.next();
                if (aVar2 instanceof com.baidu.tieba.frs.h) {
                    ((com.baidu.tieba.frs.h) aVar2).a(this.hpb.getPageContext(), this.hpb.getUniqueId());
                }
            }
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(absDelegateAdapterList);
            if (this.aSj != null) {
                this.aSj.addAll(arrayList);
            }
            if (this.gSQ != null) {
                this.gSQ.addAdapters(arrayList);
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.a.ai
    public void onDestory() {
        for (com.baidu.adp.widget.ListView.a aVar : this.aSj) {
            if (aVar instanceof com.baidu.tieba.frs.h) {
                ((com.baidu.tieba.frs.h) aVar).release();
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.a.ai
    public HashMap<Integer, bk> bYm() {
        return this.hwk;
    }

    @Override // com.baidu.tieba.frs.entelechy.a.ai
    public void notifyDataSetChanged() {
        if (this.gSQ.getListAdapter() != null) {
            this.gSQ.getListAdapter().notifyDataSetChanged();
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.a.ai
    public int bYn() {
        if (this.hwo != null) {
            return R.id.frs_bawu_center;
        }
        return 0;
    }

    @Override // com.baidu.tieba.frs.entelechy.a.ai
    public boolean r(BdUniqueId bdUniqueId) {
        if (bdUniqueId == null) {
            return false;
        }
        for (com.baidu.adp.widget.ListView.a aVar : this.aSj) {
            if (aVar != null && aVar.getType() == bdUniqueId) {
                return true;
            }
        }
        return false;
    }

    @Override // com.baidu.tieba.frs.entelechy.a.ai
    public void a(com.baidu.adp.widget.ListView.x xVar) {
        if (this.aSj != null && this.aSj.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.aSj) {
                if (aVar instanceof com.baidu.tieba.frs.h) {
                    ((com.baidu.tieba.frs.h) aVar).a(xVar);
                } else if ((aVar instanceof u) || (aVar instanceof z)) {
                    aVar.a(xVar);
                }
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.a.ai
    public void setForumName(String str) {
        if (this.aSj != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.aSj) {
                if (aVar instanceof com.baidu.tieba.card.y) {
                    ((com.baidu.tieba.card.y) aVar).setForumName(str);
                }
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v1, resolved type: com.baidu.tieba.frs.FrsFragment */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.baidu.tieba.frs.entelechy.a.ai
    public void bYo() {
        if (this.aSj != null && this.aSj.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.aSj) {
                if (aVar instanceof com.baidu.tieba.frs.h) {
                    ((com.baidu.tieba.frs.h) aVar).a(this.hpb.getPageContext(), this.hpb.getUniqueId());
                }
            }
            co(this.aSj);
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.a.ai
    public List<com.baidu.adp.widget.ListView.o> getDatas() {
        if (this.gSQ != null) {
            return this.gSQ.getData();
        }
        return null;
    }

    @Override // com.baidu.tieba.frs.entelechy.a.ai
    public int bYp() {
        if (this.hwo != null) {
            return R.id.frs_fortune_bag_item;
        }
        return 0;
    }

    @Override // com.baidu.tieba.frs.entelechy.a.ai
    public int bYq() {
        if (this.hwo != null) {
            return R.id.frs_my_service_item;
        }
        return 0;
    }

    public void aES() {
        if (this.dataList != null) {
            this.gSQ.setData(this.dataList);
        }
        notifyDataSetChanged();
    }

    @Override // com.baidu.tieba.frs.entelechy.a.ai
    public void setFromCDN(boolean z) {
        if (this.aSj != null && this.aSj.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.aSj) {
                if (aVar instanceof com.baidu.tieba.frs.h) {
                    ((com.baidu.tieba.frs.h) aVar).setFromCDN(z);
                }
            }
            if (this.hwp != null) {
                this.hwp.setFromCDN(z);
            }
            if (this.hwq != null) {
                this.hwq.setFromCDN(z);
            }
            if (this.hwr != null) {
                this.hwr.setFromCDN(z);
            }
            if (this.hws != null) {
                this.hws.setFromCDN(z);
            }
            if (this.hwt != null) {
                this.hwt.setFromCDN(z);
            }
            if (this.hwu != null) {
                this.hwu.setFromCDN(z);
            }
            if (this.hww != null) {
                this.hww.setFromCDN(z);
            }
            if (this.hwx != null) {
                this.hwx.setFromCDN(z);
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.a.ai
    public void bYr() {
        List<com.baidu.adp.widget.ListView.o> data;
        if (this.gSQ != null && this.gSQ.getData() != null && this.gSQ.getData().size() != 0 && (data = this.gSQ.getData()) != null && data.size() != 0) {
            for (com.baidu.adp.widget.ListView.o oVar : data) {
                if (oVar instanceof bk) {
                    if (((bk) oVar).aQs() != 0) {
                        ((bk) oVar).aRw();
                    }
                } else if ((oVar instanceof bj) && ((bj) oVar).dEA.aQs() != 0) {
                    ((bj) oVar).dEA.aRw();
                }
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.a.ai
    public void ns(boolean z) {
        if (this.hwm != z) {
            this.hwm = z;
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.a.ai
    public void b(ArrayList<com.baidu.adp.widget.ListView.o> arrayList, FrsViewData frsViewData) {
        b(frsViewData);
        bXd();
        com.baidu.tieba.tbadkCore.t.s(arrayList, 1);
        ao(arrayList);
        ap(arrayList);
        aq(arrayList);
        Iterator<com.baidu.adp.widget.ListView.o> it = arrayList.iterator();
        while (it.hasNext()) {
            com.baidu.adp.widget.ListView.o next = it.next();
            if ((next instanceof bj) && ((bj) next).dEA.isTop()) {
                it.remove();
            }
        }
        this.gSQ.setData(arrayList);
        this.hwl = frsViewData;
        bXH();
        bYs();
        this.dataList = arrayList;
    }

    public void b(FrsViewData frsViewData) {
        if (this.aSj != null && this.aSj.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.aSj) {
                if (aVar instanceof com.baidu.tieba.frs.h) {
                    ((com.baidu.tieba.frs.h) aVar).b(frsViewData);
                }
            }
        }
    }

    private ArrayList<Integer> ao(ArrayList<com.baidu.adp.widget.ListView.o> arrayList) {
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
            com.baidu.adp.widget.ListView.o oVar = arrayList.get(i2);
            if (oVar instanceof AdvertAppInfo) {
                arrayList2.add(Integer.valueOf(i2));
                if (this.hwk != null && !this.hwk.containsValue(oVar)) {
                    this.hwk.put(Integer.valueOf(i2), (bk) oVar);
                }
            }
            i = i2 + 1;
        }
    }

    private void ap(ArrayList<com.baidu.adp.widget.ListView.o> arrayList) {
        int i;
        if (this.aSj != null && this.aSj.size() != 0) {
            int i2 = 0;
            if (arrayList == null || arrayList.size() <= 0) {
                i = 0;
            } else {
                Iterator<com.baidu.adp.widget.ListView.o> it = arrayList.iterator();
                while (true) {
                    i = i2;
                    if (!it.hasNext() || it.next().getType().getId() != bk.dED.getId()) {
                        break;
                    }
                    i2 = i + 1;
                }
            }
            for (com.baidu.adp.widget.ListView.a aVar : this.aSj) {
                if (aVar instanceof com.baidu.tieba.frs.h) {
                    ((com.baidu.tieba.frs.h) aVar).tE(i);
                }
            }
        }
    }

    private void aq(ArrayList<com.baidu.adp.widget.ListView.o> arrayList) {
        int count = com.baidu.tbadk.core.util.v.getCount(arrayList);
        for (int i = 0; i < count; i++) {
            com.baidu.adp.widget.ListView.o oVar = (com.baidu.adp.widget.ListView.o) com.baidu.tbadk.core.util.v.getItem(arrayList, i - 1);
            com.baidu.adp.widget.ListView.o oVar2 = (com.baidu.adp.widget.ListView.o) com.baidu.tbadk.core.util.v.getItem(arrayList, i);
            if (oVar2 instanceof bj) {
                bk bkVar = ((bj) oVar2).dEA;
                if (i == 0) {
                    bkVar.isFirstFloor = true;
                } else {
                    bkVar.isFirstFloor = false;
                }
                String aOj = bkVar.aOj();
                if (oVar instanceof com.baidu.tieba.frs.t) {
                    bkVar.needTopMargin = false;
                } else if (oVar != null && !c(oVar)) {
                    bkVar.needTopMargin = false;
                } else if ((oVar instanceof bj) && c(oVar) && !TextUtils.isEmpty(((bj) oVar).dEA.aOj())) {
                    bkVar.needTopMargin = true;
                } else if (c(oVar2) && !TextUtils.isEmpty(aOj)) {
                    bkVar.needTopMargin = true;
                } else {
                    bkVar.needTopMargin = false;
                }
            }
        }
    }

    private boolean c(com.baidu.adp.widget.ListView.o oVar) {
        if (oVar == null) {
            return false;
        }
        BdUniqueId type = oVar.getType();
        return type == bk.dEE || type == bk.dEU || type == bk.dEV || type == bk.dFd || type == bk.dFm;
    }

    private void bXd() {
        if (!com.baidu.tbadk.core.util.v.isEmpty(this.aSj) && this.hpb != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.aSj) {
                if (aVar instanceof com.baidu.tieba.frs.h) {
                    ((com.baidu.tieba.frs.h) aVar).a(this.hpb.getTbPageTag());
                }
            }
        }
    }

    private void bXH() {
        com.baidu.tieba.frs.d.b statisticMetaData;
        if (this.hwl != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.aSj) {
                if ((aVar instanceof com.baidu.tieba.frs.d.d) && (statisticMetaData = ((com.baidu.tieba.frs.d.d) aVar).getStatisticMetaData()) != null) {
                    if (this.hwl.needLog == 1) {
                        statisticMetaData.hIN = true;
                    } else {
                        statisticMetaData.hIN = false;
                    }
                    if (this.hwl.getForum() != null) {
                        statisticMetaData.hIP = this.hwl.getForum().getId();
                    }
                    if (this.hpb != null && this.hpb.bUM() != null) {
                        int cav = this.hpb.bUM().cav();
                        if (cav == -1) {
                            cav = this.hpb.bUM().caw();
                        }
                        statisticMetaData.hIO = cav;
                    }
                }
            }
        }
    }

    private void bYs() {
        if (this.hwl != null && this.hwl.getForum() != null && !StringUtils.isNull(this.hwl.getForum().getId()) && this.hwn != null) {
            this.hwn.setForumId(this.hwl.getForum().getId());
        }
    }

    private void co(List<com.baidu.adp.widget.ListView.a> list) {
        if (list != null) {
            for (com.baidu.adp.widget.ListView.a aVar : list) {
                if (aVar instanceof com.baidu.tieba.frs.h) {
                    ((com.baidu.tieba.frs.h) aVar).a(this.hmJ);
                }
            }
        }
    }

    private void zL(String str) {
        if (this.aSj != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.aSj) {
                if (aVar instanceof com.baidu.tieba.a.f) {
                    ((com.baidu.tieba.a.f) aVar).zL(str);
                }
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.a.ai
    public void a(com.baidu.tieba.frs.d dVar) {
        if (this.aSj != null && this.aSj.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.aSj) {
                if (aVar instanceof com.baidu.tieba.frs.h) {
                    ((com.baidu.tieba.frs.h) aVar).a(dVar);
                }
            }
        }
    }
}
