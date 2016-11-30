package com.baidu.tieba.frs.entelechy.a;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.adp.widget.ListView.v;
import com.baidu.adp.widget.ListView.w;
import com.baidu.adp.widget.ListView.y;
import com.baidu.tbadk.core.data.au;
import com.baidu.tbadk.core.data.av;
import com.baidu.tbadk.core.data.az;
import com.baidu.tbadk.core.data.bk;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.frs.AbsDelegateAdapterList;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.frs.ao;
import com.baidu.tieba.frs.ap;
import com.baidu.tieba.frs.aq;
import com.baidu.tieba.frs.bc;
import com.baidu.tieba.frs.bd;
import com.baidu.tieba.frs.bg;
import com.baidu.tieba.frs.bi;
import com.baidu.tieba.frs.bj;
import com.baidu.tieba.frs.bt;
import com.baidu.tieba.frs.bu;
import com.baidu.tieba.frs.entelechy.view.ba;
import com.baidu.tieba.lego.card.model.ICardInfo;
import com.baidu.tieba.r;
import com.baidu.tieba.tbadkCore.p;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public class a implements aj {
    private BdTypeListView aML;
    private ArrayList<v> bHW;
    private FrsActivity bTA;
    private x bYA;
    private com.baidu.adp.widget.ListView.a bYB;
    private com.baidu.adp.widget.ListView.a bYC;
    private com.baidu.adp.widget.ListView.a bYD;
    private com.baidu.adp.widget.ListView.a bYE;
    private h bYF;
    private com.baidu.adp.widget.ListView.a bYG;
    private bj bYH;
    private bg bYI;
    private ah bYJ;
    private ab bYK;
    private com.baidu.tieba.frs.d.a bYL;
    private com.baidu.adp.widget.ListView.a bYM;
    private com.baidu.adp.widget.ListView.a bYN;
    private j bYO;
    private j bYP;
    private bc bYQ;
    private com.baidu.tieba.frs.i.a bYR;
    private com.baidu.tieba.frs.k.a bYS;
    private List<com.baidu.adp.widget.ListView.a> bYT;
    private q bYU;
    private n bYV;
    private final HashMap<Integer, bk> bYW;
    private p bYX;
    private ad bYz;
    private List<com.baidu.adp.widget.ListView.a> bRh = new LinkedList();
    private boolean bYY = false;
    private CustomMessageListener bYZ = new b(this, CmdConfigCustom.CMD_FRS_ADD_ADAPTER);
    private CustomMessageListener bZa = new c(this, CmdConfigCustom.CMD_LEGO_REGISTER);
    private CustomMessageListener aiv = new d(this, CmdConfigCustom.CMD_UPDATE_ATTENTION);
    private CustomMessageListener mLikeForumListener = new e(this, CmdConfigCustom.CMD_LIKE_FORUM);
    private CustomMessageListener mUnlikeForumListener = new f(this, CmdConfigCustom.CMD_UNLIKE_FORUM);
    private CustomMessageListener bZb = new g(this, CmdConfigCustom.CMD_UPDATE_ADCARD);
    private final ap bTq = new ap();

    public a(FrsActivity frsActivity, BdTypeListView bdTypeListView, boolean z) {
        this.aML = bdTypeListView;
        a(frsActivity, bdTypeListView);
        this.bYW = new HashMap<>();
        ee(z);
    }

    public void a(FrsActivity frsActivity, BdTypeListView bdTypeListView) {
        this.bTA = frsActivity;
        this.bYz = new ad(frsActivity.getPageContext(), bk.TM);
        this.bYA = new x(frsActivity.getPageContext(), bk.TO);
        this.bYJ = new ah(frsActivity.getPageContext(), bk.TP);
        this.bYK = new ab(frsActivity.getPageContext(), bk.TQ);
        this.bYB = com.baidu.tieba.recapp.e.bes().a(frsActivity, com.baidu.tbadk.core.data.c.OY);
        this.bYC = com.baidu.tieba.recapp.e.bes().a(frsActivity, com.baidu.tbadk.core.data.c.OZ);
        this.bYD = com.baidu.tieba.recapp.e.bes().a(frsActivity, com.baidu.tbadk.core.data.c.Pa);
        this.bYE = com.baidu.tieba.recapp.e.bes().a(frsActivity, com.baidu.tbadk.core.data.c.Pc);
        this.bYF = new h(frsActivity.getPageContext(), au.SL);
        this.bYG = com.baidu.tieba.frs.c.abK().a(frsActivity, com.baidu.tieba.tbadkCore.aa.fBc, false);
        this.bYH = new bj(frsActivity, az.Tc);
        this.bYQ = new bc(frsActivity, bd.bUl);
        this.bYI = new bg(frsActivity, av.SO);
        this.bYL = new com.baidu.tieba.frs.d.a(frsActivity, com.baidu.tbadk.core.data.aa.Rt);
        this.bYO = new j(frsActivity.getPageContext(), bk.TT);
        this.bYP = new j(frsActivity.getPageContext(), bk.TU);
        this.bYM = com.baidu.tieba.frs.c.abK().a(frsActivity, bk.UW, false);
        this.bYN = com.baidu.tieba.frs.c.abK().b(frsActivity, bk.Vc);
        this.bYR = new com.baidu.tieba.frs.i.a(frsActivity, bk.TV);
        this.bYS = new com.baidu.tieba.frs.k.a(frsActivity, com.baidu.tbadk.core.data.y.Rn);
        this.bYU = new q(frsActivity, bi.bUO);
        this.bYV = new n(frsActivity.getPageContext(), bk.TW);
        this.bRh.add(this.bYz);
        this.bRh.add(this.bYA);
        this.bRh.add(this.bYB);
        this.bRh.add(this.bYC);
        this.bRh.add(this.bYD);
        this.bRh.add(this.bYE);
        this.bRh.add(this.bYF);
        this.bRh.add(this.bYV);
        if (this.bYG != null) {
            this.bRh.add(this.bYG);
        }
        this.bRh.add(this.bYH);
        this.bRh.add(this.bYQ);
        this.bRh.add(this.bYJ);
        this.bRh.add(this.bYK);
        this.bRh.add(this.bYI);
        this.bRh.add(this.bYO);
        this.bRh.add(this.bYP);
        this.bRh.add(this.bYL);
        this.bRh.add(new bt(frsActivity, bu.bVm));
        this.bRh.add(this.bYM);
        if (this.bYN != null) {
            this.bRh.add(this.bYN);
        }
        this.bRh.add(this.bYR);
        this.bRh.add(this.bYS);
        this.bRh.add(this.bYU);
        com.baidu.adp.widget.ListView.a<? extends bk, ? extends y.a> b = com.baidu.tieba.frs.c.abK().b(frsActivity, bk.UV);
        if (b != null) {
            this.bRh.add(b);
        }
        this.bYZ.setPriority(1);
        this.bYZ.setSelfListener(true);
        frsActivity.registerListener(this.bYZ);
        frsActivity.registerListener(this.aiv);
        frsActivity.registerListener(this.mLikeForumListener);
        frsActivity.registerListener(this.mUnlikeForumListener);
        frsActivity.registerListener(this.bZb);
        aew();
        CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_ADD_ADAPTER, new AbsDelegateAdapterList());
        CustomMessage customMessage = new CustomMessage(CmdConfigCustom.CMD_FRS_ADD_ADAPTER);
        customMessage.setTag(frsActivity.getUniqueId());
        customResponsedMessage.setOrginalMessage(customMessage);
        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
        ax(this.bRh);
        bdTypeListView.g(this.bRh);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void M(Object obj) {
        if (this.bHW != null) {
            Iterator<v> it = this.bHW.iterator();
            boolean z = false;
            while (it.hasNext()) {
                v next = it.next();
                if ((next instanceof ICardInfo) && ((ICardInfo) next).responseAttention(obj)) {
                    z = true;
                }
            }
            if (z) {
                notifyDataSetChanged();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void N(Object obj) {
        if (this.bHW != null) {
            Iterator<v> it = this.bHW.iterator();
            while (it.hasNext()) {
                v next = it.next();
                if (next instanceof com.baidu.tbadk.core.data.c) {
                    com.baidu.tbadk.core.data.c cVar = (com.baidu.tbadk.core.data.c) next;
                    if (cVar.PC != null) {
                        cVar.PC.refreshReservation(obj);
                    }
                }
            }
        }
    }

    private void aew() {
        if (this.bTA != null && !aex()) {
            this.bTA.registerListener(this.bZa);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aex() {
        if (this.bTA == null) {
            return false;
        }
        this.bYT = new ArrayList();
        ArrayList<BdUniqueId> bls = com.baidu.tieba.tbadkCore.v.bls();
        if (bls == null || bls.size() <= 0) {
            return false;
        }
        int size = bls.size();
        for (int i = 0; i < size; i++) {
            aq<ICardInfo, ? extends y.a> a = com.baidu.tieba.frs.c.abK().a(this.bTA, bls.get(i));
            if (a != null) {
                this.bRh.add(a);
                this.bYT.add(a);
            }
        }
        if (!com.baidu.tbadk.core.util.x.t(this.bYT)) {
            this.aML.g(this.bYT);
        }
        return true;
    }

    @Override // com.baidu.tieba.frs.entelechy.a.aj
    public void onDestory() {
        for (com.baidu.adp.widget.ListView.a aVar : this.bRh) {
            if (aVar instanceof aq) {
                ((aq) aVar).release();
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.a.aj
    public void b(ArrayList<v> arrayList, p pVar) {
        a(pVar);
        com.baidu.tieba.tbadkCore.v.s(arrayList, 1);
        O(arrayList);
        P(arrayList);
        N(arrayList);
        this.aML.setData(arrayList);
        this.bYX = pVar;
        aeF();
        this.bHW = arrayList;
    }

    private void N(ArrayList<v> arrayList) {
        for (int i = 0; i < com.baidu.tbadk.core.util.x.s(arrayList); i++) {
            v vVar = (v) com.baidu.tbadk.core.util.x.c(arrayList, i);
            if (vVar instanceof bk) {
                bk bkVar = (bk) vVar;
                if (bkVar.sm() || bkVar.sn()) {
                    if (i == 0) {
                        bkVar.isFirstFloor = true;
                        bkVar.needTopMargin = false;
                    } else {
                        bkVar.needTopMargin = true;
                    }
                }
            }
        }
        for (int i2 = 0; i2 < com.baidu.tbadk.core.util.x.s(arrayList); i2++) {
            v vVar2 = (v) com.baidu.tbadk.core.util.x.c(arrayList, i2);
            v vVar3 = (v) com.baidu.tbadk.core.util.x.c(arrayList, i2 + 1);
            if ((vVar2 instanceof bk) && (vVar3 instanceof bk)) {
                bk bkVar2 = (bk) vVar2;
                bk bkVar3 = (bk) vVar3;
                if ((bkVar2.sm() || bkVar2.sn()) && (bkVar3.sm() || bkVar3.sn())) {
                    bkVar3.needTopMargin = false;
                }
            }
            if ((vVar2 instanceof com.baidu.tbadk.core.data.c) && (vVar3 instanceof bk)) {
                bk bkVar4 = (bk) vVar3;
                if (bkVar4.sm() || bkVar4.sn()) {
                    bkVar4.needTopMargin = true;
                }
            }
            if ((vVar2 instanceof com.baidu.tieba.frs.h5.h) && (vVar3 instanceof bk)) {
                bk bkVar5 = (bk) vVar3;
                if (bkVar5.sm() || bkVar5.sn()) {
                    bkVar5.needTopMargin = false;
                }
            }
        }
    }

    private ArrayList<Integer> O(ArrayList<v> arrayList) {
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
            v vVar = arrayList.get(i2);
            if (vVar instanceof com.baidu.tbadk.core.data.c) {
                arrayList2.add(Integer.valueOf(i2));
                if (this.bYW != null && !this.bYW.containsValue(vVar)) {
                    this.bYW.put(Integer.valueOf(i2), (bk) vVar);
                }
            }
            i = i2 + 1;
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.a.aj
    public void ee(boolean z) {
        if (this.bYY != z) {
            this.bYY = z;
            if (this.bYL != null) {
                this.bYL.ee(z);
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.a.aj
    public HashMap<Integer, bk> aey() {
        return this.bYW;
    }

    @Override // com.baidu.tieba.frs.entelechy.a.aj
    public void ax(String str, String str2) {
        if (this.bYH != null) {
            this.bYH.ax(str, str2);
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.a.aj
    public void aez() {
        if (this.aML != null && this.aML.getData() != null && this.aML.getData().size() != 0) {
            for (v vVar : this.aML.getData()) {
                if ((vVar instanceof bk) && ((bk) vVar).rL() != 0) {
                    ((bk) vVar).sw();
                }
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.a.aj
    public void notifyDataSetChanged() {
        if (this.aML.getAdapter() instanceof com.baidu.adp.widget.ListView.e) {
            ((com.baidu.adp.widget.ListView.e) this.aML.getAdapter()).notifyDataSetChanged();
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.a.aj
    public void setFromCDN(boolean z) {
        if (this.bRh != null && this.bRh.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.bRh) {
                if (aVar instanceof aq) {
                    ((aq) aVar).setFromCDN(z);
                }
            }
            if (this.bYz != null) {
                this.bYz.setFromCDN(z);
            }
            if (this.bYA != null) {
                this.bYA.setFromCDN(z);
            }
            if (this.bYO != null) {
                this.bYO.setFromCDN(z);
            }
            if (this.bYP != null) {
                this.bYP.setFromCDN(z);
            }
            if (this.bYC != null && (this.bYC instanceof com.baidu.tieba.recapp.a)) {
                ((com.baidu.tieba.recapp.a) this.bYC).setIsFromCDN(z);
            }
            if (this.bYD != null && (this.bYD instanceof com.baidu.tieba.recapp.a)) {
                ((com.baidu.tieba.recapp.a) this.bYD).setIsFromCDN(z);
            }
            if (this.bYE != null && (this.bYE instanceof com.baidu.tieba.recapp.a)) {
                ((com.baidu.tieba.recapp.a) this.bYE).setIsFromCDN(z);
            }
        }
    }

    public void a(p pVar) {
        if (this.bRh != null && this.bRh.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.bRh) {
                if (aVar instanceof aq) {
                    ((aq) aVar).a(pVar);
                }
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.a.aj
    public void a(ao aoVar) {
        if (this.bRh != null && this.bRh.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.bRh) {
                if (aVar instanceof aq) {
                    ((aq) aVar).a(aoVar);
                }
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.a.aj
    public int aeA() {
        if (this.bYG != null) {
            return r.g.frs_fortune_bag_item;
        }
        return 0;
    }

    @Override // com.baidu.tieba.frs.entelechy.a.aj
    public int aeB() {
        if (this.bYG != null) {
            return r.g.frs_my_service_item;
        }
        return 0;
    }

    @Override // com.baidu.tieba.frs.entelechy.a.aj
    public int aeC() {
        if (this.bYG != null) {
            return r.g.frs_bawu_center;
        }
        return 0;
    }

    @Override // com.baidu.tieba.frs.entelechy.a.aj
    public int aeD() {
        if (this.bYI != null) {
            return this.bYI.ady();
        }
        return 0;
    }

    @Override // com.baidu.tieba.frs.entelechy.a.aj
    public int adz() {
        if (this.bYI != null) {
            return this.bYI.adz();
        }
        return 0;
    }

    @Override // com.baidu.tieba.frs.entelechy.a.aj
    public int aeE() {
        if (this.bYL != null) {
            return this.bYL.agj();
        }
        return 0;
    }

    @Override // com.baidu.tieba.frs.entelechy.a.aj
    public boolean k(BdUniqueId bdUniqueId) {
        if (bdUniqueId == null) {
            return false;
        }
        for (com.baidu.adp.widget.ListView.a aVar : this.bRh) {
            if (aVar != null && aVar.getType() == bdUniqueId) {
                return true;
            }
        }
        return false;
    }

    @Override // com.baidu.tieba.frs.entelechy.a.aj
    public void a(w wVar) {
        if (this.bRh != null && this.bRh.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.bRh) {
                if (aVar instanceof aq) {
                    ((aq) aVar).a(wVar);
                } else if ((aVar instanceof ad) || (aVar instanceof h) || (aVar instanceof x) || (aVar instanceof j) || (aVar instanceof ah)) {
                    aVar.a(wVar);
                } else if (aVar != null && aVar.getType() == bk.UV) {
                    aVar.a(wVar);
                }
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.a.aj
    public void setForumName(String str) {
        if (this.bRh != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.bRh) {
                if (aVar instanceof ba) {
                    ((ba) aVar).setForumName(str);
                }
            }
        }
    }

    private void aeF() {
        if (this.bYX != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.bRh) {
                if (aVar instanceof com.baidu.tieba.frs.h.e) {
                    com.baidu.tieba.frs.h.e eVar = (com.baidu.tieba.frs.h.e) aVar;
                    if (com.baidu.tieba.frs.h.e.chm != null) {
                        if (this.bYX.fzN == 1) {
                            com.baidu.tieba.frs.h.e.chm.chc = true;
                        } else {
                            com.baidu.tieba.frs.h.e.chm.chc = false;
                        }
                        if (this.bYX.aOk() != null) {
                            com.baidu.tieba.frs.h.e.chm.che = this.bYX.aOk().getId();
                        }
                        if (this.bTA != null && this.bTA.abT() != null) {
                            com.baidu.tieba.frs.h.e.chm.chd = this.bTA.abS().agx();
                        }
                    }
                }
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.a.aj
    public void a(com.baidu.adp.widget.ListView.x xVar) {
        if (this.bRh != null && this.bRh.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.bRh) {
                if (aVar instanceof aq) {
                    ((aq) aVar).a(xVar);
                } else if ((aVar instanceof ad) || (aVar instanceof h) || (aVar instanceof j) || (aVar instanceof x)) {
                    aVar.a(xVar);
                } else if (aVar != null && aVar.getType() == bk.UV) {
                    aVar.a(xVar);
                }
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.a.aj
    public List<v> getDatas() {
        if (this.aML != null) {
            return this.aML.getData();
        }
        return null;
    }

    private void P(ArrayList<v> arrayList) {
        int i;
        if (this.bRh != null && this.bRh.size() != 0) {
            int i2 = 0;
            if (arrayList == null || arrayList.size() <= 0) {
                i = 0;
            } else {
                Iterator<v> it = arrayList.iterator();
                while (true) {
                    i = i2;
                    if (!it.hasNext() || it.next().getType().getId() != bk.TL.getId()) {
                        break;
                    }
                    i2 = i + 1;
                }
            }
            for (com.baidu.adp.widget.ListView.a aVar : this.bRh) {
                if (aVar instanceof aq) {
                    ((aq) aVar).hT(i);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ax(List<com.baidu.adp.widget.ListView.a> list) {
        if (list != null) {
            for (com.baidu.adp.widget.ListView.a aVar : list) {
                if (aVar instanceof aq) {
                    ((aq) aVar).a(this.bTq);
                }
            }
        }
    }
}
