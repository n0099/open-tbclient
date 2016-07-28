package com.baidu.tieba.frs.entelechy.a;

import android.view.View;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.adp.widget.ListView.y;
import com.baidu.tbadk.core.data.ao;
import com.baidu.tbadk.core.data.ap;
import com.baidu.tbadk.core.data.at;
import com.baidu.tbadk.core.data.be;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.frs.AbsDelegateAdapterList;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.frs.ba;
import com.baidu.tieba.frs.bi;
import com.baidu.tieba.frs.bj;
import com.baidu.tieba.frs.cb;
import com.baidu.tieba.frs.cc;
import com.baidu.tieba.frs.cf;
import com.baidu.tieba.frs.ch;
import com.baidu.tieba.frs.cz;
import com.baidu.tieba.frs.da;
import com.baidu.tieba.frs.entelechy.view.aw;
import com.baidu.tieba.lego.card.model.ICardInfo;
import com.baidu.tieba.tbadkCore.p;
import com.baidu.tieba.u;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public class c implements ai {
    private FrsActivity bGh;
    private cb bKA;
    private com.baidu.tieba.frs.i.a bKB;
    private List<com.baidu.adp.widget.ListView.a> bKC;
    private final HashMap<Integer, be> bKD;
    private p bKE;
    private ab bKh;
    private v bKi;
    private com.baidu.tieba.frs.be bKj;
    private b bKk;
    private a bKl;
    private i bKm;
    private com.baidu.adp.widget.ListView.a bKn;
    private ch bKo;
    private cf bKp;
    private ag bKq;
    private z bKr;
    private com.baidu.adp.widget.ListView.a bKs;
    private com.baidu.adp.widget.ListView.a bKt;
    private com.baidu.adp.widget.ListView.a bKu;
    private com.baidu.tieba.frs.d.a bKv;
    private com.baidu.adp.widget.ListView.a bKw;
    private com.baidu.adp.widget.ListView.a bKx;
    private k bKy;
    private k bKz;
    private BdTypeListView bqG;
    private ArrayList<com.baidu.adp.widget.ListView.v> btF;
    private List<com.baidu.adp.widget.ListView.a> bCN = new LinkedList();
    private boolean bKF = false;
    private CustomMessageListener bKG = new d(this, CmdConfigCustom.CMD_FRS_ADD_ADAPTER);
    private CustomMessageListener bKH = new e(this, CmdConfigCustom.CMD_LEGO_REGISTER);
    private CustomMessageListener afl = new f(this, CmdConfigCustom.CMD_UPDATE_ATTENTION);
    private CustomMessageListener mLikeForumListener = new g(this, CmdConfigCustom.CMD_LIKE_FORUM);
    private CustomMessageListener mUnlikeForumListener = new h(this, CmdConfigCustom.CMD_UNLIKE_FORUM);
    private final bi bFH = new bi();

    public c(FrsActivity frsActivity, BdTypeListView bdTypeListView, boolean z) {
        this.bqG = bdTypeListView;
        a(frsActivity, bdTypeListView);
        this.bKD = new HashMap<>();
        dx(z);
    }

    public void a(FrsActivity frsActivity, BdTypeListView bdTypeListView) {
        this.bGh = frsActivity;
        this.bKh = new ab(frsActivity.getPageContext(), be.TYPE_NORMAL);
        this.bKi = new v(frsActivity.getPageContext(), be.QB);
        this.bKq = new ag(frsActivity.getPageContext(), be.QC);
        this.bKr = new z(frsActivity.getPageContext(), be.QD);
        this.bKj = new com.baidu.tieba.frs.be(frsActivity, com.baidu.tbadk.core.data.b.Mw, false);
        this.bKk = new b(frsActivity, com.baidu.tbadk.core.data.b.Mx);
        this.bKl = new a(frsActivity, com.baidu.tbadk.core.data.b.My);
        this.bKm = new i(frsActivity.getPageContext(), ao.Py);
        this.bKn = com.baidu.tieba.frs.c.Vz().a(frsActivity, com.baidu.tieba.tbadkCore.ab.fjp, false);
        this.bKo = new ch(frsActivity, at.PQ);
        this.bKs = com.baidu.tieba.frs.c.Vz().b(frsActivity, com.baidu.tbadk.core.data.b.MB);
        this.bKu = com.baidu.tieba.frs.c.Vz().b(frsActivity, com.baidu.tbadk.core.data.b.MA);
        this.bKt = com.baidu.tieba.frs.c.Vz().b(frsActivity, com.baidu.tbadk.core.data.b.Mz);
        this.bKA = new cb(frsActivity, cc.bGZ);
        this.bKp = new cf(frsActivity, ap.PC);
        this.bKv = new com.baidu.tieba.frs.d.a(frsActivity, com.baidu.tbadk.core.data.v.Og);
        this.bKy = new k(frsActivity.getPageContext(), be.QG);
        this.bKz = new k(frsActivity.getPageContext(), be.QH);
        this.bKw = com.baidu.tieba.frs.c.Vz().a(frsActivity, be.RF, false);
        this.bKx = com.baidu.tieba.frs.c.Vz().b(frsActivity, be.RL);
        this.bKB = new com.baidu.tieba.frs.i.a(frsActivity, be.QI);
        this.bCN.add(this.bKh);
        this.bCN.add(this.bKi);
        this.bCN.add(this.bKj);
        this.bCN.add(this.bKk);
        this.bCN.add(this.bKl);
        this.bCN.add(this.bKm);
        if (this.bKn != null) {
            this.bCN.add(this.bKn);
        }
        this.bCN.add(this.bKo);
        if (this.bKs != null) {
            this.bCN.add(this.bKs);
        }
        if (this.bKu != null) {
            this.bCN.add(this.bKu);
        }
        if (this.bKt != null) {
            this.bCN.add(this.bKt);
        }
        this.bCN.add(this.bKA);
        this.bCN.add(this.bKq);
        this.bCN.add(this.bKr);
        this.bCN.add(this.bKp);
        this.bCN.add(this.bKy);
        this.bCN.add(this.bKz);
        this.bCN.add(this.bKv);
        this.bCN.add(new cz(frsActivity, da.bIh));
        this.bCN.add(this.bKw);
        if (this.bKx != null) {
            this.bCN.add(this.bKx);
        }
        this.bCN.add(this.bKB);
        com.baidu.adp.widget.ListView.a<? extends be, ? extends y.a> b = com.baidu.tieba.frs.c.Vz().b(frsActivity, be.RE);
        if (b != null) {
            this.bCN.add(b);
        }
        this.bKG.setPriority(1);
        this.bKG.setSelfListener(true);
        frsActivity.registerListener(this.bKG);
        frsActivity.registerListener(this.afl);
        frsActivity.registerListener(this.mLikeForumListener);
        frsActivity.registerListener(this.mUnlikeForumListener);
        Yj();
        CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_ADD_ADAPTER, new AbsDelegateAdapterList());
        CustomMessage customMessage = new CustomMessage(CmdConfigCustom.CMD_FRS_ADD_ADAPTER);
        customMessage.setTag(frsActivity.getUniqueId());
        customResponsedMessage.setOrginalMessage(customMessage);
        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
        au(this.bCN);
        bdTypeListView.g(this.bCN);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void H(Object obj) {
        if (this.btF != null) {
            Iterator<com.baidu.adp.widget.ListView.v> it = this.btF.iterator();
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

    private void Yj() {
        if (this.bGh != null && !Yk()) {
            this.bGh.registerListener(this.bKH);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean Yk() {
        if (this.bGh == null) {
            return false;
        }
        this.bKC = new ArrayList();
        ArrayList<BdUniqueId> beB = com.baidu.tieba.tbadkCore.w.beB();
        if (beB == null || beB.size() <= 0) {
            return false;
        }
        int size = beB.size();
        for (int i = 0; i < size; i++) {
            bj<ICardInfo, ? extends y.a> a = com.baidu.tieba.frs.c.Vz().a(this.bGh, beB.get(i));
            if (a != null) {
                this.bCN.add(a);
                this.bKC.add(a);
            }
        }
        if (!com.baidu.tbadk.core.util.y.t(this.bKC)) {
            this.bqG.g(this.bKC);
        }
        return true;
    }

    @Override // com.baidu.tieba.frs.entelechy.a.ai
    public void onDestory() {
        for (com.baidu.adp.widget.ListView.a aVar : this.bCN) {
            if (aVar instanceof bj) {
                ((bj) aVar).release();
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.a.ai
    public void a(ArrayList<com.baidu.adp.widget.ListView.v> arrayList, p pVar) {
        a(pVar);
        com.baidu.tieba.tbadkCore.w.r(arrayList, 1);
        N(arrayList);
        O(arrayList);
        M(arrayList);
        this.bqG.setData(arrayList);
        this.bKE = pVar;
        Ys();
        this.btF = arrayList;
    }

    private void M(ArrayList<com.baidu.adp.widget.ListView.v> arrayList) {
        for (int i = 0; i < com.baidu.tbadk.core.util.y.s(arrayList); i++) {
            com.baidu.adp.widget.ListView.v vVar = (com.baidu.adp.widget.ListView.v) com.baidu.tbadk.core.util.y.c(arrayList, i);
            if (vVar instanceof be) {
                be beVar = (be) vVar;
                if (beVar.qT() || beVar.qU()) {
                    if (i == 0) {
                        beVar.aVR = true;
                        beVar.aVQ = false;
                    } else {
                        beVar.aVQ = true;
                    }
                }
            }
        }
        for (int i2 = 0; i2 < com.baidu.tbadk.core.util.y.s(arrayList); i2++) {
            com.baidu.adp.widget.ListView.v vVar2 = (com.baidu.adp.widget.ListView.v) com.baidu.tbadk.core.util.y.c(arrayList, i2);
            com.baidu.adp.widget.ListView.v vVar3 = (com.baidu.adp.widget.ListView.v) com.baidu.tbadk.core.util.y.c(arrayList, i2 + 1);
            if ((vVar2 instanceof be) && (vVar3 instanceof be)) {
                be beVar2 = (be) vVar2;
                be beVar3 = (be) vVar3;
                if ((beVar2.qT() || beVar2.qU()) && (beVar3.qT() || beVar3.qU())) {
                    beVar3.aVQ = false;
                }
            }
            if ((vVar2 instanceof com.baidu.tbadk.core.data.b) && (vVar3 instanceof be)) {
                be beVar4 = (be) vVar3;
                if (beVar4.qT() || beVar4.qU()) {
                    beVar4.aVQ = true;
                }
            }
            if ((vVar2 instanceof com.baidu.tieba.frs.h5.h) && (vVar3 instanceof be)) {
                be beVar5 = (be) vVar3;
                if (beVar5.qT() || beVar5.qU()) {
                    beVar5.aVQ = false;
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
                if (this.bKD != null && !this.bKD.containsValue(vVar)) {
                    this.bKD.put(Integer.valueOf(i2), (be) vVar);
                }
            }
            i = i2 + 1;
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.a.ai
    public void dx(boolean z) {
        if (this.bKF != z) {
            this.bKF = z;
            if (this.bKv != null) {
                this.bKv.dx(z);
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.a.ai
    public HashMap<Integer, be> Yl() {
        return this.bKD;
    }

    @Override // com.baidu.tieba.frs.entelechy.a.ai
    public void av(String str, String str2) {
        if (this.bKo != null) {
            this.bKo.av(str, str2);
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.a.ai
    public void m(View.OnClickListener onClickListener) {
        if (this.bKj != null) {
            this.bKj.m(onClickListener);
        }
        if (this.bKk != null) {
            this.bKk.m(onClickListener);
        }
        if (this.bKl != null) {
            this.bKl.m(onClickListener);
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.a.ai
    public void n(View.OnClickListener onClickListener) {
        if (this.bKj != null) {
            this.bKj.n(onClickListener);
        }
        if (this.bKk != null) {
            this.bKk.n(onClickListener);
        }
        if (this.bKl != null) {
            this.bKl.n(onClickListener);
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.a.ai
    public void Ym() {
        if (this.bqG != null && this.bqG.getData() != null && this.bqG.getData().size() != 0) {
            for (com.baidu.adp.widget.ListView.v vVar : this.bqG.getData()) {
                if ((vVar instanceof be) && ((be) vVar).qt() != 0) {
                    ((be) vVar).rd();
                }
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.a.ai
    public void notifyDataSetChanged() {
        if (this.bqG.getAdapter() instanceof com.baidu.adp.widget.ListView.e) {
            ((com.baidu.adp.widget.ListView.e) this.bqG.getAdapter()).notifyDataSetChanged();
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.a.ai
    public void setFromCDN(boolean z) {
        if (this.bCN != null && this.bCN.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.bCN) {
                if (aVar instanceof bj) {
                    ((bj) aVar).setFromCDN(z);
                }
            }
            if (this.bKh != null) {
                this.bKh.setFromCDN(z);
            }
            if (this.bKi != null) {
                this.bKi.setFromCDN(z);
            }
            if (this.bKy != null) {
                this.bKy.setFromCDN(z);
            }
            if (this.bKz != null) {
                this.bKz.setFromCDN(z);
            }
            if (this.bKk != null) {
                this.bKk.setFromCDN(z);
            }
            if (this.bKl != null) {
                this.bKl.setFromCDN(z);
            }
        }
    }

    public void a(p pVar) {
        if (this.bCN != null && this.bCN.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.bCN) {
                if (aVar instanceof bj) {
                    ((bj) aVar).a(pVar);
                }
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.a.ai
    public void a(ba baVar) {
        if (this.bCN != null && this.bCN.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.bCN) {
                if (aVar instanceof bj) {
                    ((bj) aVar).a(baVar);
                }
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.a.ai
    public int Yn() {
        if (this.bKn != null) {
            return u.g.frs_fortune_bag_item;
        }
        return 0;
    }

    @Override // com.baidu.tieba.frs.entelechy.a.ai
    public int Yo() {
        if (this.bKn != null) {
            return u.g.frs_my_service_item;
        }
        return 0;
    }

    @Override // com.baidu.tieba.frs.entelechy.a.ai
    public int Yp() {
        if (this.bKn != null) {
            return u.g.frs_bawu_center;
        }
        return 0;
    }

    @Override // com.baidu.tieba.frs.entelechy.a.ai
    public int Yq() {
        if (this.bKp != null) {
            return this.bKp.Xj();
        }
        return 0;
    }

    @Override // com.baidu.tieba.frs.entelechy.a.ai
    public int Xk() {
        if (this.bKp != null) {
            return this.bKp.Xk();
        }
        return 0;
    }

    @Override // com.baidu.tieba.frs.entelechy.a.ai
    public int Yr() {
        if (this.bKv != null) {
            return this.bKv.ZT();
        }
        return 0;
    }

    @Override // com.baidu.tieba.frs.entelechy.a.ai
    public boolean k(BdUniqueId bdUniqueId) {
        if (bdUniqueId == null) {
            return false;
        }
        for (com.baidu.adp.widget.ListView.a aVar : this.bCN) {
            if (aVar != null && aVar.getType() == bdUniqueId) {
                return true;
            }
        }
        return false;
    }

    @Override // com.baidu.tieba.frs.entelechy.a.ai
    public void a(com.baidu.adp.widget.ListView.w wVar) {
        if (this.bCN != null && this.bCN.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.bCN) {
                if (aVar instanceof bj) {
                    ((bj) aVar).a(wVar);
                } else if ((aVar instanceof ab) || (aVar instanceof i) || (aVar instanceof v) || (aVar instanceof k) || (aVar instanceof ag)) {
                    aVar.a(wVar);
                } else if (aVar != null && aVar.getType() == be.RE) {
                    aVar.a(wVar);
                }
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.a.ai
    public void setForumName(String str) {
        if (this.bCN != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.bCN) {
                if (aVar instanceof aw) {
                    ((aw) aVar).setForumName(str);
                }
            }
        }
    }

    private void Ys() {
        if (this.bKE != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.bCN) {
                if (aVar instanceof com.baidu.tieba.frs.h.e) {
                    com.baidu.tieba.frs.h.e eVar = (com.baidu.tieba.frs.h.e) aVar;
                    if (com.baidu.tieba.frs.h.e.bSh != null) {
                        if (this.bKE.fig == 1) {
                            com.baidu.tieba.frs.h.e.bSh.bRX = true;
                        } else {
                            com.baidu.tieba.frs.h.e.bSh.bRX = false;
                        }
                        if (this.bKE.aGX() != null) {
                            com.baidu.tieba.frs.h.e.bSh.bRZ = this.bKE.aGX().getId();
                        }
                        if (this.bGh != null && this.bGh.Wa() != null) {
                            com.baidu.tieba.frs.h.e.bSh.bRY = this.bGh.VY().Xi();
                        }
                    }
                }
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.a.ai
    public void a(com.baidu.adp.widget.ListView.x xVar) {
        if (this.bCN != null && this.bCN.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.bCN) {
                if (aVar instanceof bj) {
                    ((bj) aVar).a(xVar);
                } else if ((aVar instanceof ab) || (aVar instanceof i) || (aVar instanceof k) || (aVar instanceof v)) {
                    aVar.a(xVar);
                } else if (aVar != null && aVar.getType() == be.RE) {
                    aVar.a(xVar);
                }
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.a.ai
    public com.baidu.adp.widget.ListView.v aw(int i) {
        if (this.bqG != null) {
            return this.bqG.aw(i);
        }
        return null;
    }

    private void O(ArrayList<com.baidu.adp.widget.ListView.v> arrayList) {
        int i;
        if (this.bCN != null && this.bCN.size() != 0) {
            int i2 = 0;
            if (arrayList == null || arrayList.size() <= 0) {
                i = 0;
            } else {
                Iterator<com.baidu.adp.widget.ListView.v> it = arrayList.iterator();
                while (true) {
                    i = i2;
                    if (!it.hasNext() || it.next().getType().getId() != be.QA.getId()) {
                        break;
                    }
                    i2 = i + 1;
                }
            }
            for (com.baidu.adp.widget.ListView.a aVar : this.bCN) {
                if (aVar instanceof bj) {
                    ((bj) aVar).hn(i);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void au(List<com.baidu.adp.widget.ListView.a> list) {
        if (list != null) {
            for (com.baidu.adp.widget.ListView.a aVar : list) {
                if (aVar instanceof bj) {
                    ((bj) aVar).a(this.bFH);
                }
            }
        }
    }
}
