package com.baidu.tieba.frs.entelechy.a;

import android.view.View;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.adp.widget.ListView.y;
import com.baidu.tbadk.core.data.aj;
import com.baidu.tbadk.core.data.ak;
import com.baidu.tbadk.core.data.ao;
import com.baidu.tbadk.core.data.az;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.frs.AbsDelegateAdapterList;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.frs.ba;
import com.baidu.tieba.frs.be;
import com.baidu.tieba.frs.bi;
import com.baidu.tieba.frs.bj;
import com.baidu.tieba.frs.cb;
import com.baidu.tieba.frs.cc;
import com.baidu.tieba.frs.cf;
import com.baidu.tieba.frs.ch;
import com.baidu.tieba.frs.cz;
import com.baidu.tieba.frs.da;
import com.baidu.tieba.frs.entelechy.view.au;
import com.baidu.tieba.lego.card.model.ICardInfo;
import com.baidu.tieba.tbadkCore.p;
import com.baidu.tieba.u;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public class c implements ad {
    private FrsActivity bET;
    private y bID;
    private t bIE;
    private be bIF;
    private b bIG;
    private a bIH;
    private i bII;
    private com.baidu.adp.widget.ListView.a bIJ;
    private ch bIK;
    private cf bIL;
    private ac bIM;
    private x bIN;
    private com.baidu.adp.widget.ListView.a bIO;
    private com.baidu.adp.widget.ListView.a bIP;
    private com.baidu.adp.widget.ListView.a bIQ;
    private com.baidu.tieba.frs.d.a bIR;
    private com.baidu.adp.widget.ListView.a bIS;
    private com.baidu.adp.widget.ListView.a bIT;
    private k bIU;
    private k bIV;
    private cb bIW;
    private com.baidu.tieba.frs.h.a bIX;
    private List<com.baidu.adp.widget.ListView.a> bIY;
    private final HashMap<Integer, az> bIZ;
    private p bJa;
    private BdTypeListView bou;
    private ArrayList<com.baidu.adp.widget.ListView.v> brq;
    private List<com.baidu.adp.widget.ListView.a> bAz = new LinkedList();
    private boolean bBx = false;
    private CustomMessageListener bJb = new d(this, CmdConfigCustom.CMD_FRS_ADD_ADAPTER);
    private CustomMessageListener bJc = new e(this, CmdConfigCustom.CMD_LEGO_REGISTER);
    private CustomMessageListener aex = new f(this, CmdConfigCustom.CMD_UPDATE_ATTENTION);
    private CustomMessageListener mLikeForumListener = new g(this, CmdConfigCustom.CMD_LIKE_FORUM);
    private CustomMessageListener mUnlikeForumListener = new h(this, CmdConfigCustom.CMD_UNLIKE_FORUM);
    private final bi bEu = new bi();

    public c(FrsActivity frsActivity, BdTypeListView bdTypeListView, boolean z) {
        this.bou = bdTypeListView;
        a(frsActivity, bdTypeListView);
        this.bIZ = new HashMap<>();
        db(z);
    }

    public void a(FrsActivity frsActivity, BdTypeListView bdTypeListView) {
        this.bET = frsActivity;
        this.bID = new y(frsActivity.getPageContext(), az.TYPE_NORMAL);
        this.bIE = new t(frsActivity.getPageContext(), az.Qg);
        this.bIM = new ac(frsActivity.getPageContext(), az.Qh);
        this.bIN = new x(frsActivity.getPageContext(), az.Qi);
        this.bIF = new be(frsActivity, com.baidu.tbadk.core.data.b.My, false);
        this.bIG = new b(frsActivity, com.baidu.tbadk.core.data.b.Mz);
        this.bIH = new a(frsActivity, com.baidu.tbadk.core.data.b.MA);
        this.bII = new i(frsActivity.getPageContext(), aj.Pc);
        this.bIJ = com.baidu.tieba.frs.c.Vj().a(frsActivity, com.baidu.tieba.tbadkCore.ab.eWn, false);
        this.bIK = new ch(frsActivity, ao.Ps);
        this.bIO = com.baidu.tieba.frs.c.Vj().b(frsActivity, com.baidu.tbadk.core.data.b.MD);
        this.bIQ = com.baidu.tieba.frs.c.Vj().b(frsActivity, com.baidu.tbadk.core.data.b.MC);
        this.bIP = com.baidu.tieba.frs.c.Vj().b(frsActivity, com.baidu.tbadk.core.data.b.MB);
        this.bIW = new cb(frsActivity, cc.bFL);
        this.bIL = new cf(frsActivity, ak.Pf);
        this.bIR = new com.baidu.tieba.frs.d.a(frsActivity, com.baidu.tbadk.core.data.t.NX);
        this.bIU = new k(frsActivity.getPageContext(), az.Ql);
        this.bIV = new k(frsActivity.getPageContext(), az.Qm);
        this.bIS = com.baidu.tieba.frs.c.Vj().a(frsActivity, az.Rd, false);
        this.bIT = com.baidu.tieba.frs.c.Vj().b(frsActivity, az.Rj);
        this.bIX = new com.baidu.tieba.frs.h.a(frsActivity, az.Qn);
        this.bAz.add(this.bID);
        this.bAz.add(this.bIE);
        this.bAz.add(this.bIF);
        this.bAz.add(this.bIG);
        this.bAz.add(this.bIH);
        this.bAz.add(this.bII);
        if (this.bIJ != null) {
            this.bAz.add(this.bIJ);
        }
        this.bAz.add(this.bIK);
        if (this.bIO != null) {
            this.bAz.add(this.bIO);
        }
        if (this.bIQ != null) {
            this.bAz.add(this.bIQ);
        }
        if (this.bIP != null) {
            this.bAz.add(this.bIP);
        }
        this.bAz.add(this.bIW);
        this.bAz.add(this.bIM);
        this.bAz.add(this.bIN);
        this.bAz.add(this.bIL);
        this.bAz.add(this.bIU);
        this.bAz.add(this.bIV);
        this.bAz.add(this.bIR);
        this.bAz.add(new cz(frsActivity, da.bGL));
        this.bAz.add(this.bIS);
        if (this.bIT != null) {
            this.bAz.add(this.bIT);
        }
        this.bAz.add(this.bIX);
        com.baidu.adp.widget.ListView.a<? extends az, ? extends y.a> b = com.baidu.tieba.frs.c.Vj().b(frsActivity, az.Rc);
        if (b != null) {
            this.bAz.add(b);
        }
        this.bJb.setPriority(1);
        this.bJb.setSelfListener(true);
        frsActivity.registerListener(this.bJb);
        frsActivity.registerListener(this.aex);
        frsActivity.registerListener(this.mLikeForumListener);
        frsActivity.registerListener(this.mUnlikeForumListener);
        XQ();
        CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_ADD_ADAPTER, new AbsDelegateAdapterList());
        CustomMessage customMessage = new CustomMessage(CmdConfigCustom.CMD_FRS_ADD_ADAPTER);
        customMessage.setTag(frsActivity.getUniqueId());
        customResponsedMessage.setOrginalMessage(customMessage);
        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
        aq(this.bAz);
        bdTypeListView.g(this.bAz);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void E(Object obj) {
        if (this.brq != null) {
            Iterator<com.baidu.adp.widget.ListView.v> it = this.brq.iterator();
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

    private void XQ() {
        if (this.bET != null && !XR()) {
            this.bET.registerListener(this.bJc);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean XR() {
        if (this.bET == null) {
            return false;
        }
        this.bIY = new ArrayList();
        ArrayList<BdUniqueId> bbn = com.baidu.tieba.tbadkCore.w.bbn();
        if (bbn == null || bbn.size() <= 0) {
            return false;
        }
        int size = bbn.size();
        for (int i = 0; i < size; i++) {
            bj<ICardInfo, ? extends y.a> a = com.baidu.tieba.frs.c.Vj().a(this.bET, bbn.get(i));
            if (a != null) {
                this.bAz.add(a);
                this.bIY.add(a);
            }
        }
        if (!com.baidu.tbadk.core.util.y.t(this.bIY)) {
            this.bou.g(this.bIY);
        }
        return true;
    }

    @Override // com.baidu.tieba.frs.entelechy.a.ad
    public void onDestory() {
        for (com.baidu.adp.widget.ListView.a aVar : this.bAz) {
            if (aVar instanceof bj) {
                ((bj) aVar).release();
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.a.ad
    public void a(ArrayList<com.baidu.adp.widget.ListView.v> arrayList, p pVar) {
        a(pVar);
        com.baidu.tieba.tbadkCore.w.p(arrayList, 1);
        L(arrayList);
        M(arrayList);
        this.bou.setData(arrayList);
        this.bJa = pVar;
        this.brq = arrayList;
    }

    private ArrayList<Integer> L(ArrayList<com.baidu.adp.widget.ListView.v> arrayList) {
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
                if (this.bIZ != null && !this.bIZ.containsValue(vVar)) {
                    this.bIZ.put(Integer.valueOf(i2), (az) vVar);
                }
            }
            i = i2 + 1;
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.a.ad
    public void db(boolean z) {
        if (this.bBx != z) {
            this.bBx = z;
            if (this.bIR != null) {
                this.bIR.db(z);
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.a.ad
    public HashMap<Integer, az> XS() {
        return this.bIZ;
    }

    @Override // com.baidu.tieba.frs.entelechy.a.ad
    public void av(String str, String str2) {
        if (this.bIK != null) {
            this.bIK.av(str, str2);
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.a.ad
    public void m(View.OnClickListener onClickListener) {
        if (this.bIF != null) {
            this.bIF.m(onClickListener);
        }
        if (this.bIG != null) {
            this.bIG.m(onClickListener);
        }
        if (this.bIH != null) {
            this.bIH.m(onClickListener);
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.a.ad
    public void n(View.OnClickListener onClickListener) {
        if (this.bIF != null) {
            this.bIF.n(onClickListener);
        }
        if (this.bIG != null) {
            this.bIG.n(onClickListener);
        }
        if (this.bIH != null) {
            this.bIH.n(onClickListener);
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.a.ad
    public void XT() {
        if (this.bou != null && this.bou.getData() != null && this.bou.getData().size() != 0) {
            for (com.baidu.adp.widget.ListView.v vVar : this.bou.getData()) {
                if ((vVar instanceof az) && ((az) vVar).getIs_top() != 0) {
                    ((az) vVar).parser_title();
                }
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.a.ad
    public void notifyDataSetChanged() {
        if (this.bou.getAdapter() instanceof com.baidu.adp.widget.ListView.e) {
            ((com.baidu.adp.widget.ListView.e) this.bou.getAdapter()).notifyDataSetChanged();
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.a.ad
    public void setFromCDN(boolean z) {
        if (this.bAz != null && this.bAz.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.bAz) {
                if (aVar instanceof bj) {
                    ((bj) aVar).setFromCDN(z);
                }
            }
            if (this.bID != null) {
                this.bID.setFromCDN(z);
            }
            if (this.bIE != null) {
                this.bIE.setFromCDN(z);
            }
            if (this.bIU != null) {
                this.bIU.setFromCDN(z);
            }
            if (this.bIV != null) {
                this.bIV.setFromCDN(z);
            }
            if (this.bIG != null) {
                this.bIG.setFromCDN(z);
            }
            if (this.bIH != null) {
                this.bIH.setFromCDN(z);
            }
        }
    }

    public void a(p pVar) {
        if (this.bAz != null && this.bAz.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.bAz) {
                if (aVar instanceof bj) {
                    ((bj) aVar).a(pVar);
                }
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.a.ad
    public void a(ba baVar) {
        if (this.bAz != null && this.bAz.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.bAz) {
                if (aVar instanceof bj) {
                    ((bj) aVar).a(baVar);
                }
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.a.ad
    public int XU() {
        if (this.bIJ != null) {
            return u.g.frs_fortune_bag_item;
        }
        return 0;
    }

    @Override // com.baidu.tieba.frs.entelechy.a.ad
    public int XV() {
        if (this.bIJ != null) {
            return u.g.frs_my_service_item;
        }
        return 0;
    }

    @Override // com.baidu.tieba.frs.entelechy.a.ad
    public int XW() {
        if (this.bIJ != null) {
            return u.g.frs_bawu_center;
        }
        return 0;
    }

    @Override // com.baidu.tieba.frs.entelechy.a.ad
    public int XX() {
        if (this.bIL != null) {
            return this.bIL.WR();
        }
        return 0;
    }

    @Override // com.baidu.tieba.frs.entelechy.a.ad
    public int WS() {
        if (this.bIL != null) {
            return this.bIL.WS();
        }
        return 0;
    }

    @Override // com.baidu.tieba.frs.entelechy.a.ad
    public int XY() {
        if (this.bIR != null) {
            return this.bIR.Zx();
        }
        return 0;
    }

    @Override // com.baidu.tieba.frs.entelechy.a.ad
    public boolean k(BdUniqueId bdUniqueId) {
        if (bdUniqueId == null) {
            return false;
        }
        for (com.baidu.adp.widget.ListView.a aVar : this.bAz) {
            if (aVar != null && aVar.getType() == bdUniqueId) {
                return true;
            }
        }
        return false;
    }

    @Override // com.baidu.tieba.frs.entelechy.a.ad
    public void a(com.baidu.adp.widget.ListView.w wVar) {
        if (this.bAz != null && this.bAz.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.bAz) {
                if (aVar instanceof bj) {
                    ((bj) aVar).a(wVar);
                } else if ((aVar instanceof y) || (aVar instanceof i) || (aVar instanceof t) || (aVar instanceof k) || (aVar instanceof ac)) {
                    aVar.a(wVar);
                } else if (aVar != null && aVar.getType() == az.Rc) {
                    aVar.a(wVar);
                }
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.a.ad
    public void setForumName(String str) {
        if (this.bAz != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.bAz) {
                if (aVar instanceof au) {
                    ((au) aVar).setForumName(str);
                }
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.a.ad
    public void a(com.baidu.adp.widget.ListView.x xVar) {
        if (this.bAz != null && this.bAz.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.bAz) {
                if (aVar instanceof bj) {
                    ((bj) aVar).a(xVar);
                } else if ((aVar instanceof y) || (aVar instanceof i) || (aVar instanceof k) || (aVar instanceof t)) {
                    aVar.a(xVar);
                } else if (aVar != null && aVar.getType() == az.Rc) {
                    aVar.a(xVar);
                }
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.a.ad
    public com.baidu.adp.widget.ListView.v at(int i) {
        if (this.bou != null) {
            return this.bou.at(i);
        }
        return null;
    }

    private void M(ArrayList<com.baidu.adp.widget.ListView.v> arrayList) {
        int i;
        if (this.bAz != null && this.bAz.size() != 0) {
            int i2 = 0;
            if (arrayList == null || arrayList.size() <= 0) {
                i = 0;
            } else {
                Iterator<com.baidu.adp.widget.ListView.v> it = arrayList.iterator();
                while (true) {
                    i = i2;
                    if (!it.hasNext() || it.next().getType().getId() != az.Qf.getId()) {
                        break;
                    }
                    i2 = i + 1;
                }
            }
            for (com.baidu.adp.widget.ListView.a aVar : this.bAz) {
                if (aVar instanceof bj) {
                    ((bj) aVar).hn(i);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aq(List<com.baidu.adp.widget.ListView.a> list) {
        if (list != null) {
            for (com.baidu.adp.widget.ListView.a aVar : list) {
                if (aVar instanceof bj) {
                    ((bj) aVar).a(this.bEu);
                }
            }
        }
    }
}
