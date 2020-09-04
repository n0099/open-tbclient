package com.baidu.tieba.frs.entelechy.a;

import android.text.TextUtils;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.af;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.data.bv;
import com.baidu.tbadk.core.data.bw;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.AbsDelegateAdapterList;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.tbadkCore.FrsViewData;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes16.dex */
public class s implements al {
    private ArrayList<com.baidu.adp.widget.ListView.q> dataList;
    private FrsFragment hVq;
    private com.baidu.adp.widget.ListView.v hyr;
    private final HashMap<Integer, bw> idG;
    private FrsViewData idH;
    private ah idJ;
    private com.baidu.adp.widget.ListView.a idK;
    private aa idL;
    private n idM;
    private x idN;
    private u idO;
    private m idP;
    private o idQ;
    private y idR;
    private ac idS;
    private w idT;
    private t idU;
    private ab idV;
    private v idW;
    private List<com.baidu.adp.widget.ListView.a> bbw = new LinkedList();
    private boolean idI = false;
    private final com.baidu.tieba.frs.i hSw = new com.baidu.tieba.frs.i();

    public s(FrsFragment frsFragment, com.baidu.adp.widget.ListView.v vVar, boolean z) {
        this.hyr = vVar;
        a(frsFragment, vVar);
        this.idG = new HashMap<>();
        oP(z);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r5v35, resolved type: com.baidu.tieba.frs.FrsFragment */
    /* JADX WARN: Multi-variable type inference failed */
    public void a(FrsFragment frsFragment, com.baidu.adp.widget.ListView.v vVar) {
        this.hVq = frsFragment;
        this.idK = com.baidu.tieba.frs.e.clc().a(frsFragment.getPageContext(), com.baidu.tieba.tbadkCore.w.mdX, this.hVq.getUniqueId(), false);
        this.idL = new aa(frsFragment.getTbPageContext(), bw.ebb, this.hVq.getUniqueId());
        this.idL.b(vVar);
        this.idM = new n(frsFragment.getTbPageContext(), bw.ebc, this.hVq.getUniqueId());
        this.idM.b(vVar);
        this.idN = new x(frsFragment.getTbPageContext(), bw.ebe, this.hVq.getUniqueId());
        this.idN.b(vVar);
        this.idO = new u(frsFragment.getTbPageContext(), bw.ebf, this.hVq.getUniqueId());
        this.idO.b(vVar);
        this.idP = new m(frsFragment.getTbPageContext(), bw.ebh, this.hVq.getUniqueId());
        this.idP.b(vVar);
        this.idQ = new o(frsFragment.getTbPageContext(), bw.ebi, this.hVq.getUniqueId());
        this.idQ.b(vVar);
        this.idS = new ac(frsFragment.getTbPageContext(), bw.ebn, this.hVq.getUniqueId());
        this.idS.b(vVar);
        this.idR = new y(frsFragment.getTbPageContext(), bw.ebF, this.hVq.getUniqueId());
        this.idR.b(vVar);
        this.idT = new w(frsFragment.getTbPageContext(), bw.ebo, this.hVq.getUniqueId());
        this.idT.b(vVar);
        this.idU = new t(frsFragment.getTbPageContext(), bw.ebp, this.hVq.getUniqueId());
        this.idU.b(vVar);
        this.idV = new ab(frsFragment.getPageContext(), bw.ebs, this.hVq.getUniqueId());
        this.idV.b(vVar);
        r rVar = new r(frsFragment.getPageContext(), bw.ebq, this.hVq.getUniqueId());
        rVar.b(vVar);
        z zVar = new z(frsFragment.getPageContext(), bw.ebw, this.hVq.getUniqueId());
        zVar.b(vVar);
        a aVar = new a(frsFragment.getPageContext(), bw.ebk, frsFragment.getUniqueId());
        aVar.b(vVar);
        aVar.tz(1);
        e eVar = new e(frsFragment.getPageContext(), bw.ebg, frsFragment.getUniqueId());
        eVar.b(vVar);
        b bVar = new b(frsFragment.getPageContext(), bw.eby, this.hVq.getUniqueId());
        bVar.b(vVar);
        bVar.setInFrsAllThread(true);
        h hVar = new h(frsFragment.getPageContext(), bw.ebx, this.hVq.getUniqueId());
        hVar.b(vVar);
        hVar.setInFrsAllThread(true);
        i iVar = new i(frsFragment.getPageContext(), bw.ebz, this.hVq.getUniqueId());
        iVar.b(vVar);
        iVar.setInFrsAllThread(true);
        ab abVar = new ab(frsFragment.getPageContext(), bw.ebA, this.hVq.getUniqueId());
        abVar.b(vVar);
        q qVar = new q(frsFragment.getPageContext(), bw.ebJ, this.hVq.getUniqueId());
        qVar.b(vVar);
        p pVar = new p(frsFragment.getPageContext(), bw.ebB, this.hVq.getUniqueId());
        pVar.b(vVar);
        this.idJ = new ah(frsFragment.getPageContext(), com.baidu.tieba.tbadkCore.p.mdP, this.hVq.getUniqueId());
        this.idW = new v(frsFragment.getPageContext(), bw.ebr, this.hVq.getUniqueId());
        this.idW.b(vVar);
        com.baidu.adp.widget.ListView.a<? extends bv, ? extends af.a> a = com.baidu.tieba.frs.e.clc().a(frsFragment.getPageContext(), this.hVq.getUniqueId(), true);
        com.baidu.adp.widget.ListView.a<? extends bw, ? extends af.a> b = com.baidu.tieba.frs.e.clc().b(frsFragment.getPageContext(), bw.edd, this.hVq.getUniqueId());
        com.baidu.tieba.frs.r rVar2 = new com.baidu.tieba.frs.r(frsFragment.getPageContext(), com.baidu.tieba.frs.s.hWr);
        l lVar = new l(frsFragment.getPageContext(), com.baidu.tieba.frs.w.hWK);
        ag agVar = new ag(frsFragment.getPageContext(), com.baidu.tieba.frs.y.hWT, this.hVq.getUniqueId());
        this.bbw.add(this.idK);
        this.bbw.add(this.idL);
        this.bbw.add(this.idM);
        this.bbw.add(this.idN);
        this.bbw.add(this.idO);
        this.bbw.add(this.idP);
        this.bbw.add(this.idQ);
        this.bbw.add(this.idR);
        this.bbw.add(this.idS);
        this.bbw.add(this.idT);
        this.bbw.add(this.idU);
        this.bbw.add(this.idJ);
        this.bbw.add(rVar);
        this.bbw.add(zVar);
        this.bbw.add(aVar);
        this.bbw.add(eVar);
        this.bbw.add(bVar);
        this.bbw.add(hVar);
        this.bbw.add(iVar);
        this.bbw.add(this.idW);
        this.bbw.add(this.idV);
        this.bbw.add(a);
        this.bbw.add(b);
        this.bbw.add(rVar2);
        this.bbw.add(lVar);
        this.bbw.add(qVar);
        this.bbw.add(pVar);
        this.bbw.add(agVar);
        this.bbw.add(abVar);
        com.baidu.tieba.InjectPlugin.b.b bVar2 = new com.baidu.tieba.InjectPlugin.b.b(this.hVq, 1);
        bVar2.setExtraData(this.bbw);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_FEED_AD_PLUGIN_OPERATE, bVar2));
        cF(this.bbw);
        vVar.addAdapters(this.bbw);
        AbsDelegateAdapterList absDelegateAdapterList = new AbsDelegateAdapterList();
        CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_ADD_ADAPTER, absDelegateAdapterList);
        CustomMessage customMessage = new CustomMessage(CmdConfigCustom.CMD_FRS_ADD_ADAPTER);
        customMessage.setTag(this.hVq.getUniqueId());
        customResponsedMessage.setOrginalMessage(customMessage);
        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
        Dk("page_frs");
        if (!absDelegateAdapterList.isEmpty()) {
            Iterator it = absDelegateAdapterList.iterator();
            while (it.hasNext()) {
                com.baidu.adp.widget.ListView.a aVar2 = (com.baidu.adp.widget.ListView.a) it.next();
                if (aVar2 instanceof com.baidu.tieba.frs.k) {
                    ((com.baidu.tieba.frs.k) aVar2).a(this.hVq.getPageContext(), this.hVq.getUniqueId());
                }
            }
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(absDelegateAdapterList);
            if (this.bbw != null) {
                this.bbw.addAll(arrayList);
            }
            if (this.hyr != null) {
                this.hyr.addAdapters(arrayList);
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.a.al
    public void onDestory() {
        for (com.baidu.adp.widget.ListView.a aVar : this.bbw) {
            if (aVar instanceof com.baidu.tieba.frs.k) {
                ((com.baidu.tieba.frs.k) aVar).release();
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.a.al
    public HashMap<Integer, bw> cpI() {
        return this.idG;
    }

    @Override // com.baidu.tieba.frs.entelechy.a.al
    public void notifyDataSetChanged() {
        if (this.hyr.getListAdapter() != null) {
            this.hyr.getListAdapter().notifyDataSetChanged();
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.a.al
    public int cpJ() {
        if (this.idK != null) {
            return R.id.frs_bawu_center;
        }
        return 0;
    }

    @Override // com.baidu.tieba.frs.entelechy.a.al
    public boolean s(BdUniqueId bdUniqueId) {
        if (bdUniqueId == null) {
            return false;
        }
        for (com.baidu.adp.widget.ListView.a aVar : this.bbw) {
            if (aVar != null && aVar.getType() == bdUniqueId) {
                return true;
            }
        }
        return false;
    }

    @Override // com.baidu.tieba.frs.entelechy.a.al
    public void a(com.baidu.adp.widget.ListView.ab abVar) {
        if (this.bbw != null && this.bbw.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.bbw) {
                if (aVar instanceof com.baidu.tieba.frs.k) {
                    ((com.baidu.tieba.frs.k) aVar).a(abVar);
                } else if ((aVar instanceof v) || (aVar instanceof ab)) {
                    aVar.a(abVar);
                }
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.a.al
    public void setForumName(String str) {
        if (this.bbw != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.bbw) {
                if (aVar instanceof com.baidu.tieba.card.y) {
                    ((com.baidu.tieba.card.y) aVar).setForumName(str);
                }
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v1, resolved type: com.baidu.tieba.frs.FrsFragment */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.baidu.tieba.frs.entelechy.a.al
    public void cpK() {
        if (this.bbw != null && this.bbw.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.bbw) {
                if (aVar instanceof com.baidu.tieba.frs.k) {
                    ((com.baidu.tieba.frs.k) aVar).a(this.hVq.getPageContext(), this.hVq.getUniqueId());
                }
            }
            cF(this.bbw);
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.a.al
    public List<com.baidu.adp.widget.ListView.q> getDatas() {
        if (this.hyr != null) {
            return this.hyr.getData();
        }
        return null;
    }

    @Override // com.baidu.tieba.frs.entelechy.a.al
    public int cpL() {
        if (this.idK != null) {
            return R.id.frs_fortune_bag_item;
        }
        return 0;
    }

    @Override // com.baidu.tieba.frs.entelechy.a.al
    public int cpM() {
        if (this.idK != null) {
            return R.id.frs_my_service_item;
        }
        return 0;
    }

    public void aSD() {
        if (this.dataList != null) {
            this.hyr.setData(this.dataList);
        }
        notifyDataSetChanged();
    }

    @Override // com.baidu.tieba.frs.entelechy.a.al
    public void setFromCDN(boolean z) {
        if (this.bbw != null && this.bbw.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.bbw) {
                if (aVar instanceof com.baidu.tieba.frs.k) {
                    ((com.baidu.tieba.frs.k) aVar).setFromCDN(z);
                }
            }
            if (this.idL != null) {
                this.idL.setFromCDN(z);
            }
            if (this.idM != null) {
                this.idM.setFromCDN(z);
            }
            if (this.idN != null) {
                this.idN.setFromCDN(z);
            }
            if (this.idO != null) {
                this.idO.setFromCDN(z);
            }
            if (this.idP != null) {
                this.idP.setFromCDN(z);
            }
            if (this.idQ != null) {
                this.idQ.setFromCDN(z);
            }
            if (this.idV != null) {
                this.idV.setFromCDN(z);
            }
            if (this.idW != null) {
                this.idW.setFromCDN(z);
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.a.al
    public void cpN() {
        List<com.baidu.adp.widget.ListView.q> data;
        if (this.hyr != null && this.hyr.getData() != null && this.hyr.getData().size() != 0 && (data = this.hyr.getData()) != null && data.size() != 0) {
            for (com.baidu.adp.widget.ListView.q qVar : data) {
                if (qVar instanceof bw) {
                    if (((bw) qVar).bez() != 0) {
                        ((bw) qVar).bfC();
                    }
                } else if ((qVar instanceof bv) && ((bv) qVar).dUW.bez() != 0) {
                    ((bv) qVar).dUW.bfC();
                }
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.a.al
    public void oP(boolean z) {
        if (this.idI != z) {
            this.idI = z;
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.a.al
    public void b(ArrayList<com.baidu.adp.widget.ListView.q> arrayList, FrsViewData frsViewData) {
        b(frsViewData);
        cou();
        com.baidu.tieba.tbadkCore.u.u(arrayList, 1);
        av(arrayList);
        aw(arrayList);
        ax(arrayList);
        Iterator<com.baidu.adp.widget.ListView.q> it = arrayList.iterator();
        while (it.hasNext()) {
            com.baidu.adp.widget.ListView.q next = it.next();
            if ((next instanceof bv) && ((bv) next).dUW.isTop()) {
                it.remove();
            }
        }
        this.hyr.setData(arrayList);
        this.idH = frsViewData;
        coY();
        cpO();
        this.dataList = arrayList;
    }

    public void b(FrsViewData frsViewData) {
        if (this.bbw != null && this.bbw.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.bbw) {
                if (aVar instanceof com.baidu.tieba.frs.k) {
                    ((com.baidu.tieba.frs.k) aVar).b(frsViewData);
                }
            }
        }
    }

    private ArrayList<Integer> av(ArrayList<com.baidu.adp.widget.ListView.q> arrayList) {
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
                if (this.idG != null && !this.idG.containsValue(qVar)) {
                    this.idG.put(Integer.valueOf(i2), (bw) qVar);
                }
            }
            i = i2 + 1;
        }
    }

    private void aw(ArrayList<com.baidu.adp.widget.ListView.q> arrayList) {
        int i;
        if (this.bbw != null && this.bbw.size() != 0) {
            int i2 = 0;
            if (arrayList == null || arrayList.size() <= 0) {
                i = 0;
            } else {
                Iterator<com.baidu.adp.widget.ListView.q> it = arrayList.iterator();
                while (true) {
                    i = i2;
                    if (!it.hasNext() || it.next().getType().getId() != bw.eaV.getId()) {
                        break;
                    }
                    i2 = i + 1;
                }
            }
            for (com.baidu.adp.widget.ListView.a aVar : this.bbw) {
                if (aVar instanceof com.baidu.tieba.frs.k) {
                    ((com.baidu.tieba.frs.k) aVar).wP(i);
                }
            }
        }
    }

    private void ax(ArrayList<com.baidu.adp.widget.ListView.q> arrayList) {
        int count = com.baidu.tbadk.core.util.y.getCount(arrayList);
        for (int i = 0; i < count; i++) {
            com.baidu.adp.widget.ListView.q qVar = (com.baidu.adp.widget.ListView.q) com.baidu.tbadk.core.util.y.getItem(arrayList, i - 1);
            com.baidu.adp.widget.ListView.q qVar2 = (com.baidu.adp.widget.ListView.q) com.baidu.tbadk.core.util.y.getItem(arrayList, i);
            if (qVar2 instanceof bv) {
                bw bwVar = ((bv) qVar2).dUW;
                if (i == 0) {
                    bwVar.isFirstFloor = true;
                } else {
                    bwVar.isFirstFloor = false;
                }
                String bcf = bwVar.bcf();
                if (qVar instanceof com.baidu.tieba.frs.w) {
                    bwVar.needTopMargin = false;
                } else if (qVar != null && !c(qVar)) {
                    bwVar.needTopMargin = false;
                } else if ((qVar instanceof bv) && c(qVar) && !TextUtils.isEmpty(((bv) qVar).dUW.bcf())) {
                    bwVar.needTopMargin = true;
                } else if (c(qVar2) && !TextUtils.isEmpty(bcf)) {
                    bwVar.needTopMargin = true;
                } else {
                    bwVar.needTopMargin = false;
                }
            }
        }
    }

    private boolean c(com.baidu.adp.widget.ListView.q qVar) {
        if (qVar == null) {
            return false;
        }
        BdUniqueId type = qVar.getType();
        return type == bw.eaW || type == bw.ebr || type == bw.ebs || type == bw.ebA || type == bw.ebJ;
    }

    private void cou() {
        if (!com.baidu.tbadk.core.util.y.isEmpty(this.bbw) && this.hVq != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.bbw) {
                if (aVar instanceof com.baidu.tieba.frs.k) {
                    ((com.baidu.tieba.frs.k) aVar).a(this.hVq.getTbPageTag());
                }
            }
        }
    }

    private void coY() {
        com.baidu.tieba.frs.d.b statisticMetaData;
        if (this.idH != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.bbw) {
                if ((aVar instanceof com.baidu.tieba.frs.d.d) && (statisticMetaData = ((com.baidu.tieba.frs.d.d) aVar).getStatisticMetaData()) != null) {
                    if (this.idH.needLog == 1) {
                        statisticMetaData.iqZ = true;
                    } else {
                        statisticMetaData.iqZ = false;
                    }
                    if (this.idH.getForum() != null) {
                        statisticMetaData.irb = this.idH.getForum().getId();
                    }
                    if (this.hVq != null && this.hVq.clO() != null) {
                        int crX = this.hVq.clO().crX();
                        if (crX == -1) {
                            crX = this.hVq.clO().crY();
                        }
                        statisticMetaData.ira = crX;
                    }
                }
            }
        }
    }

    private void cpO() {
        if (this.idH != null && this.idH.getForum() != null && !StringUtils.isNull(this.idH.getForum().getId()) && this.idJ != null) {
            this.idJ.setForumId(this.idH.getForum().getId());
        }
    }

    private void cF(List<com.baidu.adp.widget.ListView.a> list) {
        if (list != null) {
            for (com.baidu.adp.widget.ListView.a aVar : list) {
                if (aVar instanceof com.baidu.tieba.frs.k) {
                    ((com.baidu.tieba.frs.k) aVar).a(this.hSw);
                }
            }
        }
    }

    private void Dk(String str) {
        if (this.bbw != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.bbw) {
                if (aVar instanceof com.baidu.tieba.a.f) {
                    ((com.baidu.tieba.a.f) aVar).Dk(str);
                }
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.a.al
    public void a(com.baidu.tieba.frs.f fVar) {
        if (this.bbw != null && this.bbw.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.bbw) {
                if (aVar instanceof com.baidu.tieba.frs.k) {
                    ((com.baidu.tieba.frs.k) aVar).a(fVar);
                }
            }
        }
    }
}
