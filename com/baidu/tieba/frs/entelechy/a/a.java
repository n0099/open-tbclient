package com.baidu.tieba.frs.entelechy.a;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.adp.widget.ListView.y;
import com.baidu.tbadk.core.data.as;
import com.baidu.tbadk.core.data.at;
import com.baidu.tbadk.core.data.ax;
import com.baidu.tbadk.core.data.bi;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.frs.AbsDelegateAdapterList;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.frs.ba;
import com.baidu.tieba.frs.be;
import com.baidu.tieba.frs.bf;
import com.baidu.tieba.frs.bx;
import com.baidu.tieba.frs.by;
import com.baidu.tieba.frs.cb;
import com.baidu.tieba.frs.cd;
import com.baidu.tieba.frs.cv;
import com.baidu.tieba.frs.cw;
import com.baidu.tieba.frs.entelechy.view.az;
import com.baidu.tieba.lego.card.model.ICardInfo;
import com.baidu.tieba.r;
import com.baidu.tieba.tbadkCore.p;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public class a implements af {
    private BdTypeListView bCe;
    private ArrayList<com.baidu.adp.widget.ListView.v> bFc;
    private FrsActivity bRi;
    private cb bVA;
    private ad bVB;
    private x bVC;
    private com.baidu.tieba.frs.d.a bVD;
    private com.baidu.adp.widget.ListView.a bVE;
    private com.baidu.adp.widget.ListView.a bVF;
    private i bVG;
    private i bVH;
    private bx bVI;
    private com.baidu.tieba.frs.h.a bVJ;
    private com.baidu.tieba.frs.j.a bVK;
    private List<com.baidu.adp.widget.ListView.a> bVL;
    private final HashMap<Integer, bi> bVM;
    private p bVN;
    private z bVs;
    private t bVt;
    private com.baidu.adp.widget.ListView.a bVu;
    private com.baidu.adp.widget.ListView.a bVv;
    private com.baidu.adp.widget.ListView.a bVw;
    private g bVx;
    private com.baidu.adp.widget.ListView.a bVy;
    private cd bVz;
    private List<com.baidu.adp.widget.ListView.a> bOo = new LinkedList();
    private boolean bVO = false;
    private CustomMessageListener bVP = new b(this, CmdConfigCustom.CMD_FRS_ADD_ADAPTER);
    private CustomMessageListener bVQ = new c(this, CmdConfigCustom.CMD_LEGO_REGISTER);
    private CustomMessageListener ahO = new d(this, CmdConfigCustom.CMD_UPDATE_ATTENTION);
    private CustomMessageListener mLikeForumListener = new e(this, CmdConfigCustom.CMD_LIKE_FORUM);
    private CustomMessageListener mUnlikeForumListener = new f(this, CmdConfigCustom.CMD_UNLIKE_FORUM);
    private final be bQI = new be();

    public a(FrsActivity frsActivity, BdTypeListView bdTypeListView, boolean z) {
        this.bCe = bdTypeListView;
        a(frsActivity, bdTypeListView);
        this.bVM = new HashMap<>();
        dU(z);
    }

    public void a(FrsActivity frsActivity, BdTypeListView bdTypeListView) {
        this.bRi = frsActivity;
        this.bVs = new z(frsActivity.getPageContext(), bi.Tr);
        this.bVt = new t(frsActivity.getPageContext(), bi.Ts);
        this.bVB = new ad(frsActivity.getPageContext(), bi.Tt);
        this.bVC = new x(frsActivity.getPageContext(), bi.Tu);
        this.bVu = com.baidu.tieba.recapp.e.bbV().a(frsActivity, com.baidu.tbadk.core.data.b.OP);
        this.bVv = com.baidu.tieba.recapp.e.bbV().a(frsActivity, com.baidu.tbadk.core.data.b.OQ);
        this.bVw = com.baidu.tieba.recapp.e.bbV().a(frsActivity, com.baidu.tbadk.core.data.b.OR);
        this.bVx = new g(frsActivity.getPageContext(), as.Sq);
        this.bVy = com.baidu.tieba.frs.c.aaI().a(frsActivity, com.baidu.tieba.tbadkCore.aa.ftP, false);
        this.bVz = new cd(frsActivity, ax.SH);
        this.bVI = new bx(frsActivity, by.bRY);
        this.bVA = new cb(frsActivity, at.St);
        this.bVD = new com.baidu.tieba.frs.d.a(frsActivity, com.baidu.tbadk.core.data.y.QY);
        this.bVG = new i(frsActivity.getPageContext(), bi.Tx);
        this.bVH = new i(frsActivity.getPageContext(), bi.Ty);
        this.bVE = com.baidu.tieba.frs.c.aaI().a(frsActivity, bi.Uy, false);
        this.bVF = com.baidu.tieba.frs.c.aaI().b(frsActivity, bi.UF);
        this.bVJ = new com.baidu.tieba.frs.h.a(frsActivity, bi.Tz);
        this.bVK = new com.baidu.tieba.frs.j.a(frsActivity, com.baidu.tbadk.core.data.w.QS);
        this.bOo.add(this.bVs);
        this.bOo.add(this.bVt);
        this.bOo.add(this.bVu);
        this.bOo.add(this.bVv);
        this.bOo.add(this.bVw);
        this.bOo.add(this.bVx);
        if (this.bVy != null) {
            this.bOo.add(this.bVy);
        }
        this.bOo.add(this.bVz);
        this.bOo.add(this.bVI);
        this.bOo.add(this.bVB);
        this.bOo.add(this.bVC);
        this.bOo.add(this.bVA);
        this.bOo.add(this.bVG);
        this.bOo.add(this.bVH);
        this.bOo.add(this.bVD);
        this.bOo.add(new cv(frsActivity, cw.bTg));
        this.bOo.add(this.bVE);
        if (this.bVF != null) {
            this.bOo.add(this.bVF);
        }
        this.bOo.add(this.bVJ);
        this.bOo.add(this.bVK);
        com.baidu.adp.widget.ListView.a<? extends bi, ? extends y.a> b = com.baidu.tieba.frs.c.aaI().b(frsActivity, bi.Ux);
        if (b != null) {
            this.bOo.add(b);
        }
        this.bVP.setPriority(1);
        this.bVP.setSelfListener(true);
        frsActivity.registerListener(this.bVP);
        frsActivity.registerListener(this.ahO);
        frsActivity.registerListener(this.mLikeForumListener);
        frsActivity.registerListener(this.mUnlikeForumListener);
        adj();
        CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_ADD_ADAPTER, new AbsDelegateAdapterList());
        CustomMessage customMessage = new CustomMessage(CmdConfigCustom.CMD_FRS_ADD_ADAPTER);
        customMessage.setTag(frsActivity.getUniqueId());
        customResponsedMessage.setOrginalMessage(customMessage);
        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
        aw(this.bOo);
        bdTypeListView.g(this.bOo);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void K(Object obj) {
        if (this.bFc != null) {
            Iterator<com.baidu.adp.widget.ListView.v> it = this.bFc.iterator();
            boolean z = false;
            while (it.hasNext()) {
                com.baidu.adp.widget.ListView.v next = it.next();
                if ((next instanceof ICardInfo) && ((ICardInfo) next).responseAttention(obj)) {
                    z = true;
                }
            }
            if (z) {
                notifyDataSetChanged();
            }
        }
    }

    private void adj() {
        if (this.bRi != null && !adk()) {
            this.bRi.registerListener(this.bVQ);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean adk() {
        if (this.bRi == null) {
            return false;
        }
        this.bVL = new ArrayList();
        ArrayList<BdUniqueId> biS = com.baidu.tieba.tbadkCore.v.biS();
        if (biS == null || biS.size() <= 0) {
            return false;
        }
        int size = biS.size();
        for (int i = 0; i < size; i++) {
            bf<ICardInfo, ? extends y.a> a = com.baidu.tieba.frs.c.aaI().a(this.bRi, biS.get(i));
            if (a != null) {
                this.bOo.add(a);
                this.bVL.add(a);
            }
        }
        if (!com.baidu.tbadk.core.util.y.t(this.bVL)) {
            this.bCe.g(this.bVL);
        }
        return true;
    }

    @Override // com.baidu.tieba.frs.entelechy.a.af
    public void onDestory() {
        for (com.baidu.adp.widget.ListView.a aVar : this.bOo) {
            if (aVar instanceof bf) {
                ((bf) aVar).release();
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.a.af
    public void a(ArrayList<com.baidu.adp.widget.ListView.v> arrayList, p pVar) {
        a(pVar);
        com.baidu.tieba.tbadkCore.v.s(arrayList, 1);
        N(arrayList);
        O(arrayList);
        M(arrayList);
        this.bCe.setData(arrayList);
        this.bVN = pVar;
        ads();
        this.bFc = arrayList;
    }

    private void M(ArrayList<com.baidu.adp.widget.ListView.v> arrayList) {
        for (int i = 0; i < com.baidu.tbadk.core.util.y.s(arrayList); i++) {
            com.baidu.adp.widget.ListView.v vVar = (com.baidu.adp.widget.ListView.v) com.baidu.tbadk.core.util.y.c(arrayList, i);
            if (vVar instanceof bi) {
                bi biVar = (bi) vVar;
                if (biVar.sk() || biVar.sl()) {
                    if (i == 0) {
                        biVar.bbM = true;
                        biVar.bbL = false;
                    } else {
                        biVar.bbL = true;
                    }
                }
            }
        }
        for (int i2 = 0; i2 < com.baidu.tbadk.core.util.y.s(arrayList); i2++) {
            com.baidu.adp.widget.ListView.v vVar2 = (com.baidu.adp.widget.ListView.v) com.baidu.tbadk.core.util.y.c(arrayList, i2);
            com.baidu.adp.widget.ListView.v vVar3 = (com.baidu.adp.widget.ListView.v) com.baidu.tbadk.core.util.y.c(arrayList, i2 + 1);
            if ((vVar2 instanceof bi) && (vVar3 instanceof bi)) {
                bi biVar2 = (bi) vVar2;
                bi biVar3 = (bi) vVar3;
                if ((biVar2.sk() || biVar2.sl()) && (biVar3.sk() || biVar3.sl())) {
                    biVar3.bbL = false;
                }
            }
            if ((vVar2 instanceof com.baidu.tbadk.core.data.b) && (vVar3 instanceof bi)) {
                bi biVar4 = (bi) vVar3;
                if (biVar4.sk() || biVar4.sl()) {
                    biVar4.bbL = true;
                }
            }
            if ((vVar2 instanceof com.baidu.tieba.frs.h5.h) && (vVar3 instanceof bi)) {
                bi biVar5 = (bi) vVar3;
                if (biVar5.sk() || biVar5.sl()) {
                    biVar5.bbL = false;
                }
            }
        }
    }

    private ArrayList<Integer> N(ArrayList<com.baidu.adp.widget.ListView.v> arrayList) {
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
            com.baidu.adp.widget.ListView.v vVar = arrayList.get(i2);
            if (vVar instanceof com.baidu.tbadk.core.data.b) {
                arrayList2.add(Integer.valueOf(i2));
                if (this.bVM != null && !this.bVM.containsValue(vVar)) {
                    this.bVM.put(Integer.valueOf(i2), (bi) vVar);
                }
            }
            i = i2 + 1;
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.a.af
    public void dU(boolean z) {
        if (this.bVO != z) {
            this.bVO = z;
            if (this.bVD != null) {
                this.bVD.dU(z);
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.a.af
    public HashMap<Integer, bi> adl() {
        return this.bVM;
    }

    @Override // com.baidu.tieba.frs.entelechy.a.af
    public void aw(String str, String str2) {
        if (this.bVz != null) {
            this.bVz.aw(str, str2);
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.a.af
    public void adm() {
        if (this.bCe != null && this.bCe.getData() != null && this.bCe.getData().size() != 0) {
            for (com.baidu.adp.widget.ListView.v vVar : this.bCe.getData()) {
                if ((vVar instanceof bi) && ((bi) vVar).rJ() != 0) {
                    ((bi) vVar).su();
                }
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.a.af
    public void notifyDataSetChanged() {
        if (this.bCe.getAdapter() instanceof com.baidu.adp.widget.ListView.e) {
            ((com.baidu.adp.widget.ListView.e) this.bCe.getAdapter()).notifyDataSetChanged();
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.a.af
    public void setFromCDN(boolean z) {
        if (this.bOo != null && this.bOo.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.bOo) {
                if (aVar instanceof bf) {
                    ((bf) aVar).setFromCDN(z);
                }
            }
            if (this.bVs != null) {
                this.bVs.setFromCDN(z);
            }
            if (this.bVt != null) {
                this.bVt.setFromCDN(z);
            }
            if (this.bVG != null) {
                this.bVG.setFromCDN(z);
            }
            if (this.bVH != null) {
                this.bVH.setFromCDN(z);
            }
            if (this.bVu != null && (this.bVu instanceof com.baidu.tieba.recapp.a)) {
                ((com.baidu.tieba.recapp.a) this.bVu).setIsFromCDN(z);
            }
            if (this.bVv != null && (this.bVv instanceof com.baidu.tieba.recapp.a)) {
                ((com.baidu.tieba.recapp.a) this.bVv).setIsFromCDN(z);
            }
            if (this.bVw != null && (this.bVw instanceof com.baidu.tieba.recapp.a)) {
                ((com.baidu.tieba.recapp.a) this.bVw).setIsFromCDN(z);
            }
        }
    }

    public void a(p pVar) {
        if (this.bOo != null && this.bOo.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.bOo) {
                if (aVar instanceof bf) {
                    ((bf) aVar).a(pVar);
                }
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.a.af
    public void a(ba baVar) {
        if (this.bOo != null && this.bOo.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.bOo) {
                if (aVar instanceof bf) {
                    ((bf) aVar).a(baVar);
                }
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.a.af
    public int adn() {
        if (this.bVy != null) {
            return r.g.frs_fortune_bag_item;
        }
        return 0;
    }

    @Override // com.baidu.tieba.frs.entelechy.a.af
    public int ado() {
        if (this.bVy != null) {
            return r.g.frs_my_service_item;
        }
        return 0;
    }

    @Override // com.baidu.tieba.frs.entelechy.a.af
    public int adp() {
        if (this.bVy != null) {
            return r.g.frs_bawu_center;
        }
        return 0;
    }

    @Override // com.baidu.tieba.frs.entelechy.a.af
    public int adq() {
        if (this.bVA != null) {
            return this.bVA.act();
        }
        return 0;
    }

    @Override // com.baidu.tieba.frs.entelechy.a.af
    public int acu() {
        if (this.bVA != null) {
            return this.bVA.acu();
        }
        return 0;
    }

    @Override // com.baidu.tieba.frs.entelechy.a.af
    public int adr() {
        if (this.bVD != null) {
            return this.bVD.aeR();
        }
        return 0;
    }

    @Override // com.baidu.tieba.frs.entelechy.a.af
    public boolean k(BdUniqueId bdUniqueId) {
        if (bdUniqueId == null) {
            return false;
        }
        for (com.baidu.adp.widget.ListView.a aVar : this.bOo) {
            if (aVar != null && aVar.getType() == bdUniqueId) {
                return true;
            }
        }
        return false;
    }

    @Override // com.baidu.tieba.frs.entelechy.a.af
    public void a(com.baidu.adp.widget.ListView.w wVar) {
        if (this.bOo != null && this.bOo.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.bOo) {
                if (aVar instanceof bf) {
                    ((bf) aVar).a(wVar);
                } else if ((aVar instanceof z) || (aVar instanceof g) || (aVar instanceof t) || (aVar instanceof i) || (aVar instanceof ad)) {
                    aVar.a(wVar);
                } else if (aVar != null && aVar.getType() == bi.Ux) {
                    aVar.a(wVar);
                }
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.a.af
    public void setForumName(String str) {
        if (this.bOo != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.bOo) {
                if (aVar instanceof az) {
                    ((az) aVar).setForumName(str);
                }
            }
        }
    }

    private void ads() {
        if (this.bVN != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.bOo) {
                if (aVar instanceof com.baidu.tieba.frs.g.e) {
                    com.baidu.tieba.frs.g.e eVar = (com.baidu.tieba.frs.g.e) aVar;
                    if (com.baidu.tieba.frs.g.e.cdl != null) {
                        if (this.bVN.fsD == 1) {
                            com.baidu.tieba.frs.g.e.cdl.cdb = true;
                        } else {
                            com.baidu.tieba.frs.g.e.cdl.cdb = false;
                        }
                        if (this.bVN.aMr() != null) {
                            com.baidu.tieba.frs.g.e.cdl.cdd = this.bVN.aMr().getId();
                        }
                        if (this.bRi != null && this.bRi.abk() != null) {
                            com.baidu.tieba.frs.g.e.cdl.cdc = this.bRi.abi().acs();
                        }
                    }
                }
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.a.af
    public void a(com.baidu.adp.widget.ListView.x xVar) {
        if (this.bOo != null && this.bOo.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.bOo) {
                if (aVar instanceof bf) {
                    ((bf) aVar).a(xVar);
                } else if ((aVar instanceof z) || (aVar instanceof g) || (aVar instanceof i) || (aVar instanceof t)) {
                    aVar.a(xVar);
                } else if (aVar != null && aVar.getType() == bi.Ux) {
                    aVar.a(xVar);
                }
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.a.af
    public List<com.baidu.adp.widget.ListView.v> getDatas() {
        if (this.bCe != null) {
            return this.bCe.getData();
        }
        return null;
    }

    private void O(ArrayList<com.baidu.adp.widget.ListView.v> arrayList) {
        int i;
        if (this.bOo != null && this.bOo.size() != 0) {
            int i2 = 0;
            if (arrayList == null || arrayList.size() <= 0) {
                i = 0;
            } else {
                Iterator<com.baidu.adp.widget.ListView.v> it = arrayList.iterator();
                while (true) {
                    i = i2;
                    if (!it.hasNext() || it.next().getType().getId() != bi.Tq.getId()) {
                        break;
                    }
                    i2 = i + 1;
                }
            }
            for (com.baidu.adp.widget.ListView.a aVar : this.bOo) {
                if (aVar instanceof bf) {
                    ((bf) aVar).hU(i);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aw(List<com.baidu.adp.widget.ListView.a> list) {
        if (list != null) {
            for (com.baidu.adp.widget.ListView.a aVar : list) {
                if (aVar instanceof bf) {
                    ((bf) aVar).a(this.bQI);
                }
            }
        }
    }
}
