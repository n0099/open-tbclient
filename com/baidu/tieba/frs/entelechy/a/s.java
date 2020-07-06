package com.baidu.tieba.frs.entelechy.a;

import android.text.TextUtils;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.ad;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.data.bt;
import com.baidu.tbadk.core.data.bu;
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
public class s implements al {
    private ArrayList<com.baidu.adp.widget.ListView.q> dataList;
    private FrsFragment hBW;
    private y hJA;
    private ac hJB;
    private w hJC;
    private t hJD;
    private ab hJE;
    private v hJF;
    private final HashMap<Integer, bu> hJp;
    private FrsViewData hJq;
    private ah hJs;
    private com.baidu.adp.widget.ListView.a hJt;
    private aa hJu;
    private n hJv;
    private x hJw;
    private u hJx;
    private m hJy;
    private o hJz;
    private com.baidu.adp.widget.ListView.v hfK;
    private List<com.baidu.adp.widget.ListView.a> aUP = new LinkedList();
    private boolean hJr = false;
    private final com.baidu.tieba.frs.h hzl = new com.baidu.tieba.frs.h();

    public s(FrsFragment frsFragment, com.baidu.adp.widget.ListView.v vVar, boolean z) {
        this.hfK = vVar;
        a(frsFragment, vVar);
        this.hJp = new HashMap<>();
        nE(z);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r5v35, resolved type: com.baidu.tieba.frs.FrsFragment */
    /* JADX WARN: Multi-variable type inference failed */
    public void a(FrsFragment frsFragment, com.baidu.adp.widget.ListView.v vVar) {
        this.hBW = frsFragment;
        this.hJt = com.baidu.tieba.frs.e.bXm().a(frsFragment.getPageContext(), com.baidu.tieba.tbadkCore.v.lEH, this.hBW.getUniqueId(), false);
        this.hJu = new aa(frsFragment.getTbPageContext(), bu.dLq, this.hBW.getUniqueId());
        this.hJu.b(vVar);
        this.hJv = new n(frsFragment.getTbPageContext(), bu.dLr, this.hBW.getUniqueId());
        this.hJv.b(vVar);
        this.hJw = new x(frsFragment.getTbPageContext(), bu.dLt, this.hBW.getUniqueId());
        this.hJw.b(vVar);
        this.hJx = new u(frsFragment.getTbPageContext(), bu.dLu, this.hBW.getUniqueId());
        this.hJx.b(vVar);
        this.hJy = new m(frsFragment.getTbPageContext(), bu.dLw, this.hBW.getUniqueId());
        this.hJy.b(vVar);
        this.hJz = new o(frsFragment.getTbPageContext(), bu.dLx, this.hBW.getUniqueId());
        this.hJz.b(vVar);
        this.hJB = new ac(frsFragment.getTbPageContext(), bu.dLC, this.hBW.getUniqueId());
        this.hJB.b(vVar);
        this.hJA = new y(frsFragment.getTbPageContext(), bu.dLU, this.hBW.getUniqueId());
        this.hJA.b(vVar);
        this.hJC = new w(frsFragment.getTbPageContext(), bu.dLD, this.hBW.getUniqueId());
        this.hJC.b(vVar);
        this.hJD = new t(frsFragment.getTbPageContext(), bu.dLE, this.hBW.getUniqueId());
        this.hJD.b(vVar);
        this.hJE = new ab(frsFragment.getPageContext(), bu.dLH, this.hBW.getUniqueId());
        this.hJE.b(vVar);
        r rVar = new r(frsFragment.getPageContext(), bu.dLF, this.hBW.getUniqueId());
        rVar.b(vVar);
        z zVar = new z(frsFragment.getPageContext(), bu.dLL, this.hBW.getUniqueId());
        zVar.b(vVar);
        a aVar = new a(frsFragment.getPageContext(), bu.dLz, frsFragment.getUniqueId());
        aVar.b(vVar);
        aVar.qX(1);
        e eVar = new e(frsFragment.getPageContext(), bu.dLv, frsFragment.getUniqueId());
        eVar.b(vVar);
        b bVar = new b(frsFragment.getPageContext(), bu.dLN, this.hBW.getUniqueId());
        bVar.b(vVar);
        bVar.setInFrsAllThread(true);
        h hVar = new h(frsFragment.getPageContext(), bu.dLM, this.hBW.getUniqueId());
        hVar.b(vVar);
        hVar.setInFrsAllThread(true);
        i iVar = new i(frsFragment.getPageContext(), bu.dLO, this.hBW.getUniqueId());
        iVar.b(vVar);
        iVar.setInFrsAllThread(true);
        ab abVar = new ab(frsFragment.getPageContext(), bu.dLP, this.hBW.getUniqueId());
        abVar.b(vVar);
        q qVar = new q(frsFragment.getPageContext(), bu.dLY, this.hBW.getUniqueId());
        qVar.b(vVar);
        p pVar = new p(frsFragment.getPageContext(), bu.dLQ, this.hBW.getUniqueId());
        pVar.b(vVar);
        this.hJs = new ah(frsFragment.getPageContext(), com.baidu.tieba.tbadkCore.o.lEz, this.hBW.getUniqueId());
        this.hJF = new v(frsFragment.getPageContext(), bu.dLG, this.hBW.getUniqueId());
        this.hJF.b(vVar);
        com.baidu.adp.widget.ListView.a<? extends bt, ? extends ad.a> a = com.baidu.tieba.frs.e.bXm().a(frsFragment.getPageContext(), this.hBW.getUniqueId(), true);
        com.baidu.adp.widget.ListView.a<? extends bu, ? extends ad.a> b = com.baidu.tieba.frs.e.bXm().b(frsFragment.getPageContext(), bu.dNs, this.hBW.getUniqueId());
        com.baidu.tieba.frs.q qVar2 = new com.baidu.tieba.frs.q(frsFragment.getPageContext(), com.baidu.tieba.frs.r.hCX);
        l lVar = new l(frsFragment.getPageContext(), com.baidu.tieba.frs.v.hDm);
        ag agVar = new ag(frsFragment.getPageContext(), com.baidu.tieba.frs.x.hDv, this.hBW.getUniqueId());
        this.aUP.add(this.hJt);
        this.aUP.add(this.hJu);
        this.aUP.add(this.hJv);
        this.aUP.add(this.hJw);
        this.aUP.add(this.hJx);
        this.aUP.add(this.hJy);
        this.aUP.add(this.hJz);
        this.aUP.add(this.hJA);
        this.aUP.add(this.hJB);
        this.aUP.add(this.hJC);
        this.aUP.add(this.hJD);
        this.aUP.add(this.hJs);
        this.aUP.add(rVar);
        this.aUP.add(zVar);
        this.aUP.add(aVar);
        this.aUP.add(eVar);
        this.aUP.add(bVar);
        this.aUP.add(hVar);
        this.aUP.add(iVar);
        this.aUP.add(this.hJF);
        this.aUP.add(this.hJE);
        this.aUP.add(a);
        this.aUP.add(b);
        this.aUP.add(qVar2);
        this.aUP.add(lVar);
        this.aUP.add(qVar);
        this.aUP.add(pVar);
        this.aUP.add(agVar);
        this.aUP.add(abVar);
        com.baidu.tieba.InjectPlugin.b.b bVar2 = new com.baidu.tieba.InjectPlugin.b.b(this.hBW, 1);
        bVar2.setExtraData(this.aUP);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_FEED_AD_PLUGIN_OPERATE, bVar2));
        cy(this.aUP);
        vVar.addAdapters(this.aUP);
        AbsDelegateAdapterList absDelegateAdapterList = new AbsDelegateAdapterList();
        CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_ADD_ADAPTER, absDelegateAdapterList);
        CustomMessage customMessage = new CustomMessage(CmdConfigCustom.CMD_FRS_ADD_ADAPTER);
        customMessage.setTag(this.hBW.getUniqueId());
        customResponsedMessage.setOrginalMessage(customMessage);
        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
        Ae("page_frs");
        if (!absDelegateAdapterList.isEmpty()) {
            Iterator it = absDelegateAdapterList.iterator();
            while (it.hasNext()) {
                com.baidu.adp.widget.ListView.a aVar2 = (com.baidu.adp.widget.ListView.a) it.next();
                if (aVar2 instanceof com.baidu.tieba.frs.j) {
                    ((com.baidu.tieba.frs.j) aVar2).a(this.hBW.getPageContext(), this.hBW.getUniqueId());
                }
            }
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(absDelegateAdapterList);
            if (this.aUP != null) {
                this.aUP.addAll(arrayList);
            }
            if (this.hfK != null) {
                this.hfK.addAdapters(arrayList);
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.a.al
    public void onDestory() {
        for (com.baidu.adp.widget.ListView.a aVar : this.aUP) {
            if (aVar instanceof com.baidu.tieba.frs.j) {
                ((com.baidu.tieba.frs.j) aVar).release();
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.a.al
    public HashMap<Integer, bu> cbE() {
        return this.hJp;
    }

    @Override // com.baidu.tieba.frs.entelechy.a.al
    public void notifyDataSetChanged() {
        if (this.hfK.getListAdapter() != null) {
            this.hfK.getListAdapter().notifyDataSetChanged();
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.a.al
    public int cbF() {
        if (this.hJt != null) {
            return R.id.frs_bawu_center;
        }
        return 0;
    }

    @Override // com.baidu.tieba.frs.entelechy.a.al
    public boolean r(BdUniqueId bdUniqueId) {
        if (bdUniqueId == null) {
            return false;
        }
        for (com.baidu.adp.widget.ListView.a aVar : this.aUP) {
            if (aVar != null && aVar.getType() == bdUniqueId) {
                return true;
            }
        }
        return false;
    }

    @Override // com.baidu.tieba.frs.entelechy.a.al
    public void a(com.baidu.adp.widget.ListView.z zVar) {
        if (this.aUP != null && this.aUP.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.aUP) {
                if (aVar instanceof com.baidu.tieba.frs.j) {
                    ((com.baidu.tieba.frs.j) aVar).a(zVar);
                } else if ((aVar instanceof v) || (aVar instanceof ab)) {
                    aVar.a(zVar);
                }
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.a.al
    public void setForumName(String str) {
        if (this.aUP != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.aUP) {
                if (aVar instanceof com.baidu.tieba.card.y) {
                    ((com.baidu.tieba.card.y) aVar).setForumName(str);
                }
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v1, resolved type: com.baidu.tieba.frs.FrsFragment */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.baidu.tieba.frs.entelechy.a.al
    public void cbG() {
        if (this.aUP != null && this.aUP.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.aUP) {
                if (aVar instanceof com.baidu.tieba.frs.j) {
                    ((com.baidu.tieba.frs.j) aVar).a(this.hBW.getPageContext(), this.hBW.getUniqueId());
                }
            }
            cy(this.aUP);
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.a.al
    public List<com.baidu.adp.widget.ListView.q> getDatas() {
        if (this.hfK != null) {
            return this.hfK.getData();
        }
        return null;
    }

    @Override // com.baidu.tieba.frs.entelechy.a.al
    public int cbH() {
        if (this.hJt != null) {
            return R.id.frs_fortune_bag_item;
        }
        return 0;
    }

    @Override // com.baidu.tieba.frs.entelechy.a.al
    public int cbI() {
        if (this.hJt != null) {
            return R.id.frs_my_service_item;
        }
        return 0;
    }

    public void aFY() {
        if (this.dataList != null) {
            this.hfK.setData(this.dataList);
        }
        notifyDataSetChanged();
    }

    @Override // com.baidu.tieba.frs.entelechy.a.al
    public void setFromCDN(boolean z) {
        if (this.aUP != null && this.aUP.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.aUP) {
                if (aVar instanceof com.baidu.tieba.frs.j) {
                    ((com.baidu.tieba.frs.j) aVar).setFromCDN(z);
                }
            }
            if (this.hJu != null) {
                this.hJu.setFromCDN(z);
            }
            if (this.hJv != null) {
                this.hJv.setFromCDN(z);
            }
            if (this.hJw != null) {
                this.hJw.setFromCDN(z);
            }
            if (this.hJx != null) {
                this.hJx.setFromCDN(z);
            }
            if (this.hJy != null) {
                this.hJy.setFromCDN(z);
            }
            if (this.hJz != null) {
                this.hJz.setFromCDN(z);
            }
            if (this.hJE != null) {
                this.hJE.setFromCDN(z);
            }
            if (this.hJF != null) {
                this.hJF.setFromCDN(z);
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.a.al
    public void cbJ() {
        List<com.baidu.adp.widget.ListView.q> data;
        if (this.hfK != null && this.hfK.getData() != null && this.hfK.getData().size() != 0 && (data = this.hfK.getData()) != null && data.size() != 0) {
            for (com.baidu.adp.widget.ListView.q qVar : data) {
                if (qVar instanceof bu) {
                    if (((bu) qVar).aSk() != 0) {
                        ((bu) qVar).aTn();
                    }
                } else if ((qVar instanceof bt) && ((bt) qVar).dLi.aSk() != 0) {
                    ((bt) qVar).dLi.aTn();
                }
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.a.al
    public void nE(boolean z) {
        if (this.hJr != z) {
            this.hJr = z;
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.a.al
    public void b(ArrayList<com.baidu.adp.widget.ListView.q> arrayList, FrsViewData frsViewData) {
        b(frsViewData);
        car();
        com.baidu.tieba.tbadkCore.t.t(arrayList, 1);
        ao(arrayList);
        ap(arrayList);
        aq(arrayList);
        Iterator<com.baidu.adp.widget.ListView.q> it = arrayList.iterator();
        while (it.hasNext()) {
            com.baidu.adp.widget.ListView.q next = it.next();
            if ((next instanceof bt) && ((bt) next).dLi.isTop()) {
                it.remove();
            }
        }
        this.hfK.setData(arrayList);
        this.hJq = frsViewData;
        caV();
        cbK();
        this.dataList = arrayList;
    }

    public void b(FrsViewData frsViewData) {
        if (this.aUP != null && this.aUP.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.aUP) {
                if (aVar instanceof com.baidu.tieba.frs.j) {
                    ((com.baidu.tieba.frs.j) aVar).b(frsViewData);
                }
            }
        }
    }

    private ArrayList<Integer> ao(ArrayList<com.baidu.adp.widget.ListView.q> arrayList) {
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
            com.baidu.adp.widget.ListView.q qVar = arrayList.get(i2);
            if (qVar instanceof AdvertAppInfo) {
                arrayList2.add(Integer.valueOf(i2));
                if (this.hJp != null && !this.hJp.containsValue(qVar)) {
                    this.hJp.put(Integer.valueOf(i2), (bu) qVar);
                }
            }
            i = i2 + 1;
        }
    }

    private void ap(ArrayList<com.baidu.adp.widget.ListView.q> arrayList) {
        int i;
        if (this.aUP != null && this.aUP.size() != 0) {
            int i2 = 0;
            if (arrayList == null || arrayList.size() <= 0) {
                i = 0;
            } else {
                Iterator<com.baidu.adp.widget.ListView.q> it = arrayList.iterator();
                while (true) {
                    i = i2;
                    if (!it.hasNext() || it.next().getType().getId() != bu.dLl.getId()) {
                        break;
                    }
                    i2 = i + 1;
                }
            }
            for (com.baidu.adp.widget.ListView.a aVar : this.aUP) {
                if (aVar instanceof com.baidu.tieba.frs.j) {
                    ((com.baidu.tieba.frs.j) aVar).ui(i);
                }
            }
        }
    }

    private void aq(ArrayList<com.baidu.adp.widget.ListView.q> arrayList) {
        int count = com.baidu.tbadk.core.util.w.getCount(arrayList);
        for (int i = 0; i < count; i++) {
            com.baidu.adp.widget.ListView.q qVar = (com.baidu.adp.widget.ListView.q) com.baidu.tbadk.core.util.w.getItem(arrayList, i - 1);
            com.baidu.adp.widget.ListView.q qVar2 = (com.baidu.adp.widget.ListView.q) com.baidu.tbadk.core.util.w.getItem(arrayList, i);
            if (qVar2 instanceof bt) {
                bu buVar = ((bt) qVar2).dLi;
                if (i == 0) {
                    buVar.isFirstFloor = true;
                } else {
                    buVar.isFirstFloor = false;
                }
                String aPT = buVar.aPT();
                if (qVar instanceof com.baidu.tieba.frs.v) {
                    buVar.needTopMargin = false;
                } else if (qVar != null && !c(qVar)) {
                    buVar.needTopMargin = false;
                } else if ((qVar instanceof bt) && c(qVar) && !TextUtils.isEmpty(((bt) qVar).dLi.aPT())) {
                    buVar.needTopMargin = true;
                } else if (c(qVar2) && !TextUtils.isEmpty(aPT)) {
                    buVar.needTopMargin = true;
                } else {
                    buVar.needTopMargin = false;
                }
            }
        }
    }

    private boolean c(com.baidu.adp.widget.ListView.q qVar) {
        if (qVar == null) {
            return false;
        }
        BdUniqueId type = qVar.getType();
        return type == bu.dLm || type == bu.dLG || type == bu.dLH || type == bu.dLP || type == bu.dLY;
    }

    private void car() {
        if (!com.baidu.tbadk.core.util.w.isEmpty(this.aUP) && this.hBW != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.aUP) {
                if (aVar instanceof com.baidu.tieba.frs.j) {
                    ((com.baidu.tieba.frs.j) aVar).a(this.hBW.getTbPageTag());
                }
            }
        }
    }

    private void caV() {
        com.baidu.tieba.frs.d.b statisticMetaData;
        if (this.hJq != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.aUP) {
                if ((aVar instanceof com.baidu.tieba.frs.d.d) && (statisticMetaData = ((com.baidu.tieba.frs.d.d) aVar).getStatisticMetaData()) != null) {
                    if (this.hJq.needLog == 1) {
                        statisticMetaData.hWM = true;
                    } else {
                        statisticMetaData.hWM = false;
                    }
                    if (this.hJq.getForum() != null) {
                        statisticMetaData.hWO = this.hJq.getForum().getId();
                    }
                    if (this.hBW != null && this.hBW.bXV() != null) {
                        int cdS = this.hBW.bXV().cdS();
                        if (cdS == -1) {
                            cdS = this.hBW.bXV().cdT();
                        }
                        statisticMetaData.hWN = cdS;
                    }
                }
            }
        }
    }

    private void cbK() {
        if (this.hJq != null && this.hJq.getForum() != null && !StringUtils.isNull(this.hJq.getForum().getId()) && this.hJs != null) {
            this.hJs.setForumId(this.hJq.getForum().getId());
        }
    }

    private void cy(List<com.baidu.adp.widget.ListView.a> list) {
        if (list != null) {
            for (com.baidu.adp.widget.ListView.a aVar : list) {
                if (aVar instanceof com.baidu.tieba.frs.j) {
                    ((com.baidu.tieba.frs.j) aVar).a(this.hzl);
                }
            }
        }
    }

    private void Ae(String str) {
        if (this.aUP != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.aUP) {
                if (aVar instanceof com.baidu.tieba.a.f) {
                    ((com.baidu.tieba.a.f) aVar).Ae(str);
                }
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.a.al
    public void a(com.baidu.tieba.frs.f fVar) {
        if (this.aUP != null && this.aUP.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.aUP) {
                if (aVar instanceof com.baidu.tieba.frs.j) {
                    ((com.baidu.tieba.frs.j) aVar).a(fVar);
                }
            }
        }
    }
}
