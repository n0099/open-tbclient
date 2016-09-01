package com.baidu.tieba.frs.entelechy.a;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.adp.widget.ListView.y;
import com.baidu.tbadk.core.data.aq;
import com.baidu.tbadk.core.data.ar;
import com.baidu.tbadk.core.data.av;
import com.baidu.tbadk.core.data.bg;
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
import com.baidu.tieba.t;
import com.baidu.tieba.tbadkCore.p;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public class a implements af {
    private BdTypeListView bBT;
    private ArrayList<com.baidu.adp.widget.ListView.v> bER;
    private FrsActivity bRp;
    private com.baidu.adp.widget.ListView.a bVA;
    private cd bVB;
    private cb bVC;
    private ad bVD;
    private x bVE;
    private com.baidu.tieba.frs.d.a bVF;
    private com.baidu.adp.widget.ListView.a bVG;
    private com.baidu.adp.widget.ListView.a bVH;
    private i bVI;
    private i bVJ;
    private bx bVK;
    private com.baidu.tieba.frs.h.a bVL;
    private List<com.baidu.adp.widget.ListView.a> bVM;
    private final HashMap<Integer, bg> bVN;
    private p bVO;
    private z bVu;
    private t bVv;
    private com.baidu.adp.widget.ListView.a bVw;
    private com.baidu.adp.widget.ListView.a bVx;
    private com.baidu.adp.widget.ListView.a bVy;
    private g bVz;
    private List<com.baidu.adp.widget.ListView.a> bOr = new LinkedList();
    private boolean bVP = false;
    private CustomMessageListener bVQ = new b(this, CmdConfigCustom.CMD_FRS_ADD_ADAPTER);
    private CustomMessageListener bVR = new c(this, CmdConfigCustom.CMD_LEGO_REGISTER);
    private CustomMessageListener aig = new d(this, CmdConfigCustom.CMD_UPDATE_ATTENTION);
    private CustomMessageListener mLikeForumListener = new e(this, CmdConfigCustom.CMD_LIKE_FORUM);
    private CustomMessageListener mUnlikeForumListener = new f(this, CmdConfigCustom.CMD_UNLIKE_FORUM);
    private final be bQP = new be();

    public a(FrsActivity frsActivity, BdTypeListView bdTypeListView, boolean z) {
        this.bBT = bdTypeListView;
        a(frsActivity, bdTypeListView);
        this.bVN = new HashMap<>();
        dT(z);
    }

    public void a(FrsActivity frsActivity, BdTypeListView bdTypeListView) {
        this.bRp = frsActivity;
        this.bVu = new z(frsActivity.getPageContext(), bg.TYPE_NORMAL);
        this.bVv = new t(frsActivity.getPageContext(), bg.Tk);
        this.bVD = new ad(frsActivity.getPageContext(), bg.Tl);
        this.bVE = new x(frsActivity.getPageContext(), bg.Tm);
        this.bVw = com.baidu.tieba.recapp.e.bbp().a(frsActivity, com.baidu.tbadk.core.data.b.OO);
        this.bVx = com.baidu.tieba.recapp.e.bbp().a(frsActivity, com.baidu.tbadk.core.data.b.OP);
        this.bVy = com.baidu.tieba.recapp.e.bbp().a(frsActivity, com.baidu.tbadk.core.data.b.OQ);
        this.bVz = new g(frsActivity.getPageContext(), aq.Sk);
        this.bVA = com.baidu.tieba.frs.c.aau().a(frsActivity, com.baidu.tieba.tbadkCore.aa.frh, false);
        this.bVB = new cd(frsActivity, av.SA);
        this.bVK = new bx(frsActivity, by.bSf);
        this.bVC = new cb(frsActivity, ar.Sn);
        this.bVF = new com.baidu.tieba.frs.d.a(frsActivity, com.baidu.tbadk.core.data.w.QS);
        this.bVI = new i(frsActivity.getPageContext(), bg.Tp);
        this.bVJ = new i(frsActivity.getPageContext(), bg.Tq);
        this.bVG = com.baidu.tieba.frs.c.aau().a(frsActivity, bg.Uo, false);
        this.bVH = com.baidu.tieba.frs.c.aau().b(frsActivity, bg.Uu);
        this.bVL = new com.baidu.tieba.frs.h.a(frsActivity, bg.Tr);
        this.bOr.add(this.bVu);
        this.bOr.add(this.bVv);
        this.bOr.add(this.bVw);
        this.bOr.add(this.bVx);
        this.bOr.add(this.bVy);
        this.bOr.add(this.bVz);
        if (this.bVA != null) {
            this.bOr.add(this.bVA);
        }
        this.bOr.add(this.bVB);
        this.bOr.add(this.bVK);
        this.bOr.add(this.bVD);
        this.bOr.add(this.bVE);
        this.bOr.add(this.bVC);
        this.bOr.add(this.bVI);
        this.bOr.add(this.bVJ);
        this.bOr.add(this.bVF);
        this.bOr.add(new cv(frsActivity, cw.bTn));
        this.bOr.add(this.bVG);
        if (this.bVH != null) {
            this.bOr.add(this.bVH);
        }
        this.bOr.add(this.bVL);
        com.baidu.adp.widget.ListView.a<? extends bg, ? extends y.a> b = com.baidu.tieba.frs.c.aau().b(frsActivity, bg.Un);
        if (b != null) {
            this.bOr.add(b);
        }
        this.bVQ.setPriority(1);
        this.bVQ.setSelfListener(true);
        frsActivity.registerListener(this.bVQ);
        frsActivity.registerListener(this.aig);
        frsActivity.registerListener(this.mLikeForumListener);
        frsActivity.registerListener(this.mUnlikeForumListener);
        acV();
        CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_ADD_ADAPTER, new AbsDelegateAdapterList());
        CustomMessage customMessage = new CustomMessage(CmdConfigCustom.CMD_FRS_ADD_ADAPTER);
        customMessage.setTag(frsActivity.getUniqueId());
        customResponsedMessage.setOrginalMessage(customMessage);
        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
        aw(this.bOr);
        bdTypeListView.g(this.bOr);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void K(Object obj) {
        if (this.bER != null) {
            Iterator<com.baidu.adp.widget.ListView.v> it = this.bER.iterator();
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

    private void acV() {
        if (this.bRp != null && !acW()) {
            this.bRp.registerListener(this.bVR);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean acW() {
        if (this.bRp == null) {
            return false;
        }
        this.bVM = new ArrayList();
        ArrayList<BdUniqueId> bih = com.baidu.tieba.tbadkCore.v.bih();
        if (bih == null || bih.size() <= 0) {
            return false;
        }
        int size = bih.size();
        for (int i = 0; i < size; i++) {
            bf<ICardInfo, ? extends y.a> a = com.baidu.tieba.frs.c.aau().a(this.bRp, bih.get(i));
            if (a != null) {
                this.bOr.add(a);
                this.bVM.add(a);
            }
        }
        if (!com.baidu.tbadk.core.util.y.t(this.bVM)) {
            this.bBT.g(this.bVM);
        }
        return true;
    }

    @Override // com.baidu.tieba.frs.entelechy.a.af
    public void onDestory() {
        for (com.baidu.adp.widget.ListView.a aVar : this.bOr) {
            if (aVar instanceof bf) {
                ((bf) aVar).release();
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.a.af
    public void a(ArrayList<com.baidu.adp.widget.ListView.v> arrayList, p pVar) {
        a(pVar);
        com.baidu.tieba.tbadkCore.v.r(arrayList, 1);
        N(arrayList);
        O(arrayList);
        M(arrayList);
        this.bBT.setData(arrayList);
        this.bVO = pVar;
        ade();
        this.bER = arrayList;
    }

    private void M(ArrayList<com.baidu.adp.widget.ListView.v> arrayList) {
        for (int i = 0; i < com.baidu.tbadk.core.util.y.s(arrayList); i++) {
            com.baidu.adp.widget.ListView.v vVar = (com.baidu.adp.widget.ListView.v) com.baidu.tbadk.core.util.y.c(arrayList, i);
            if (vVar instanceof bg) {
                bg bgVar = (bg) vVar;
                if (bgVar.rY() || bgVar.rZ()) {
                    if (i == 0) {
                        bgVar.bbu = true;
                        bgVar.bbt = false;
                    } else {
                        bgVar.bbt = true;
                    }
                }
            }
        }
        for (int i2 = 0; i2 < com.baidu.tbadk.core.util.y.s(arrayList); i2++) {
            com.baidu.adp.widget.ListView.v vVar2 = (com.baidu.adp.widget.ListView.v) com.baidu.tbadk.core.util.y.c(arrayList, i2);
            com.baidu.adp.widget.ListView.v vVar3 = (com.baidu.adp.widget.ListView.v) com.baidu.tbadk.core.util.y.c(arrayList, i2 + 1);
            if ((vVar2 instanceof bg) && (vVar3 instanceof bg)) {
                bg bgVar2 = (bg) vVar2;
                bg bgVar3 = (bg) vVar3;
                if ((bgVar2.rY() || bgVar2.rZ()) && (bgVar3.rY() || bgVar3.rZ())) {
                    bgVar3.bbt = false;
                }
            }
            if ((vVar2 instanceof com.baidu.tbadk.core.data.b) && (vVar3 instanceof bg)) {
                bg bgVar4 = (bg) vVar3;
                if (bgVar4.rY() || bgVar4.rZ()) {
                    bgVar4.bbt = true;
                }
            }
            if ((vVar2 instanceof com.baidu.tieba.frs.h5.h) && (vVar3 instanceof bg)) {
                bg bgVar5 = (bg) vVar3;
                if (bgVar5.rY() || bgVar5.rZ()) {
                    bgVar5.bbt = false;
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
                if (this.bVN != null && !this.bVN.containsValue(vVar)) {
                    this.bVN.put(Integer.valueOf(i2), (bg) vVar);
                }
            }
            i = i2 + 1;
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.a.af
    public void dT(boolean z) {
        if (this.bVP != z) {
            this.bVP = z;
            if (this.bVF != null) {
                this.bVF.dT(z);
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.a.af
    public HashMap<Integer, bg> acX() {
        return this.bVN;
    }

    @Override // com.baidu.tieba.frs.entelechy.a.af
    public void aw(String str, String str2) {
        if (this.bVB != null) {
            this.bVB.aw(str, str2);
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.a.af
    public void acY() {
        if (this.bBT != null && this.bBT.getData() != null && this.bBT.getData().size() != 0) {
            for (com.baidu.adp.widget.ListView.v vVar : this.bBT.getData()) {
                if ((vVar instanceof bg) && ((bg) vVar).rx() != 0) {
                    ((bg) vVar).si();
                }
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.a.af
    public void notifyDataSetChanged() {
        if (this.bBT.getAdapter() instanceof com.baidu.adp.widget.ListView.e) {
            ((com.baidu.adp.widget.ListView.e) this.bBT.getAdapter()).notifyDataSetChanged();
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.a.af
    public void setFromCDN(boolean z) {
        if (this.bOr != null && this.bOr.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.bOr) {
                if (aVar instanceof bf) {
                    ((bf) aVar).setFromCDN(z);
                }
            }
            if (this.bVu != null) {
                this.bVu.setFromCDN(z);
            }
            if (this.bVv != null) {
                this.bVv.setFromCDN(z);
            }
            if (this.bVI != null) {
                this.bVI.setFromCDN(z);
            }
            if (this.bVJ != null) {
                this.bVJ.setFromCDN(z);
            }
            if (this.bVw != null && (this.bVw instanceof com.baidu.tieba.recapp.a)) {
                ((com.baidu.tieba.recapp.a) this.bVw).setIsFromCDN(z);
            }
            if (this.bVx != null && (this.bVx instanceof com.baidu.tieba.recapp.a)) {
                ((com.baidu.tieba.recapp.a) this.bVx).setIsFromCDN(z);
            }
            if (this.bVy != null && (this.bVy instanceof com.baidu.tieba.recapp.a)) {
                ((com.baidu.tieba.recapp.a) this.bVy).setIsFromCDN(z);
            }
        }
    }

    public void a(p pVar) {
        if (this.bOr != null && this.bOr.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.bOr) {
                if (aVar instanceof bf) {
                    ((bf) aVar).a(pVar);
                }
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.a.af
    public void a(ba baVar) {
        if (this.bOr != null && this.bOr.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.bOr) {
                if (aVar instanceof bf) {
                    ((bf) aVar).a(baVar);
                }
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.a.af
    public int acZ() {
        if (this.bVA != null) {
            return t.g.frs_fortune_bag_item;
        }
        return 0;
    }

    @Override // com.baidu.tieba.frs.entelechy.a.af
    public int ada() {
        if (this.bVA != null) {
            return t.g.frs_my_service_item;
        }
        return 0;
    }

    @Override // com.baidu.tieba.frs.entelechy.a.af
    public int adb() {
        if (this.bVA != null) {
            return t.g.frs_bawu_center;
        }
        return 0;
    }

    @Override // com.baidu.tieba.frs.entelechy.a.af
    public int adc() {
        if (this.bVC != null) {
            return this.bVC.acg();
        }
        return 0;
    }

    @Override // com.baidu.tieba.frs.entelechy.a.af
    public int ach() {
        if (this.bVC != null) {
            return this.bVC.ach();
        }
        return 0;
    }

    @Override // com.baidu.tieba.frs.entelechy.a.af
    public int add() {
        if (this.bVF != null) {
            return this.bVF.aeD();
        }
        return 0;
    }

    @Override // com.baidu.tieba.frs.entelechy.a.af
    public boolean k(BdUniqueId bdUniqueId) {
        if (bdUniqueId == null) {
            return false;
        }
        for (com.baidu.adp.widget.ListView.a aVar : this.bOr) {
            if (aVar != null && aVar.getType() == bdUniqueId) {
                return true;
            }
        }
        return false;
    }

    @Override // com.baidu.tieba.frs.entelechy.a.af
    public void a(com.baidu.adp.widget.ListView.w wVar) {
        if (this.bOr != null && this.bOr.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.bOr) {
                if (aVar instanceof bf) {
                    ((bf) aVar).a(wVar);
                } else if ((aVar instanceof z) || (aVar instanceof g) || (aVar instanceof t) || (aVar instanceof i) || (aVar instanceof ad)) {
                    aVar.a(wVar);
                } else if (aVar != null && aVar.getType() == bg.Un) {
                    aVar.a(wVar);
                }
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.a.af
    public void setForumName(String str) {
        if (this.bOr != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.bOr) {
                if (aVar instanceof az) {
                    ((az) aVar).setForumName(str);
                }
            }
        }
    }

    private void ade() {
        if (this.bVO != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.bOr) {
                if (aVar instanceof com.baidu.tieba.frs.g.e) {
                    com.baidu.tieba.frs.g.e eVar = (com.baidu.tieba.frs.g.e) aVar;
                    if (com.baidu.tieba.frs.g.e.cdn != null) {
                        if (this.bVO.fpX == 1) {
                            com.baidu.tieba.frs.g.e.cdn.cdd = true;
                        } else {
                            com.baidu.tieba.frs.g.e.cdn.cdd = false;
                        }
                        if (this.bVO.aLP() != null) {
                            com.baidu.tieba.frs.g.e.cdn.cdf = this.bVO.aLP().getId();
                        }
                        if (this.bRp != null && this.bRp.aaX() != null) {
                            com.baidu.tieba.frs.g.e.cdn.cde = this.bRp.aaV().acf();
                        }
                    }
                }
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.a.af
    public void a(com.baidu.adp.widget.ListView.x xVar) {
        if (this.bOr != null && this.bOr.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.bOr) {
                if (aVar instanceof bf) {
                    ((bf) aVar).a(xVar);
                } else if ((aVar instanceof z) || (aVar instanceof g) || (aVar instanceof i) || (aVar instanceof t)) {
                    aVar.a(xVar);
                } else if (aVar != null && aVar.getType() == bg.Un) {
                    aVar.a(xVar);
                }
            }
        }
    }

    private void O(ArrayList<com.baidu.adp.widget.ListView.v> arrayList) {
        int i;
        if (this.bOr != null && this.bOr.size() != 0) {
            int i2 = 0;
            if (arrayList == null || arrayList.size() <= 0) {
                i = 0;
            } else {
                Iterator<com.baidu.adp.widget.ListView.v> it = arrayList.iterator();
                while (true) {
                    i = i2;
                    if (!it.hasNext() || it.next().getType().getId() != bg.Tj.getId()) {
                        break;
                    }
                    i2 = i + 1;
                }
            }
            for (com.baidu.adp.widget.ListView.a aVar : this.bOr) {
                if (aVar instanceof bf) {
                    ((bf) aVar).hQ(i);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aw(List<com.baidu.adp.widget.ListView.a> list) {
        if (list != null) {
            for (com.baidu.adp.widget.ListView.a aVar : list) {
                if (aVar instanceof bf) {
                    ((bf) aVar).a(this.bQP);
                }
            }
        }
    }
}
