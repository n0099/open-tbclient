package com.baidu.tieba.frs.entelechy.a;

import android.text.TextUtils;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.adp.widget.ListView.y;
import com.baidu.tbadk.core.data.au;
import com.baidu.tbadk.core.data.bg;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.card.data.CardHListViewData;
import com.baidu.tieba.frs.AbsDelegateAdapterList;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.frs.as;
import com.baidu.tieba.frs.at;
import com.baidu.tieba.frs.bf;
import com.baidu.tieba.frs.bj;
import com.baidu.tieba.frs.bl;
import com.baidu.tieba.frs.bs;
import com.baidu.tieba.frs.bt;
import com.baidu.tieba.frs.entelechy.view.bb;
import com.baidu.tieba.lego.card.model.ICardInfo;
import com.baidu.tieba.r;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public class b implements am {
    private BdTypeListView aMc;
    private com.baidu.adp.widget.ListView.a bEA;
    private com.baidu.adp.widget.ListView.a bEB;
    private k bEC;
    private k bED;
    private bf bEE;
    private com.baidu.tieba.frs.i.a bEF;
    private List<com.baidu.adp.widget.ListView.a> bEG;
    private ad bEH;
    private w bEI;
    private u bEJ;
    private final HashMap<Integer, bg> bEK;
    private com.baidu.tieba.tbadkCore.o bEL;
    private z bEn;
    private o bEo;
    private com.baidu.adp.widget.ListView.a bEp;
    private com.baidu.adp.widget.ListView.a bEq;
    private com.baidu.adp.widget.ListView.a bEr;
    private com.baidu.adp.widget.ListView.a bEs;
    private com.baidu.adp.widget.ListView.a bEt;
    private i bEu;
    private com.baidu.adp.widget.ListView.a bEv;
    private bj bEw;
    private ak bEx;
    private s bEy;
    private com.baidu.tieba.frs.c.a bEz;
    private ArrayList<com.baidu.adp.widget.ListView.v> bnZ;
    private FrsActivity bzH;
    private List<com.baidu.adp.widget.ListView.a> bbV = new LinkedList();
    private boolean bEM = false;
    private CustomMessageListener bEN = new c(this, CmdConfigCustom.CMD_FRS_ADD_ADAPTER);
    private CustomMessageListener bEO = new d(this, CmdConfigCustom.CMD_LEGO_REGISTER);
    private CustomMessageListener ahW = new e(this, CmdConfigCustom.CMD_UPDATE_ATTENTION);
    private CustomMessageListener mLikeForumListener = new f(this, CmdConfigCustom.CMD_LIKE_FORUM);
    private CustomMessageListener mUnlikeForumListener = new g(this, CmdConfigCustom.CMD_UNLIKE_FORUM);
    private CustomMessageListener bEP = new h(this, CmdConfigCustom.CMD_UPDATE_ADCARD);
    private final at bzB = new at();

    public b(FrsActivity frsActivity, BdTypeListView bdTypeListView, boolean z) {
        this.aMc = bdTypeListView;
        a(frsActivity, bdTypeListView);
        this.bEK = new HashMap<>();
        dO(z);
    }

    public void a(FrsActivity frsActivity, BdTypeListView bdTypeListView) {
        this.bzH = frsActivity;
        this.bEn = new z(frsActivity.getPageContext(), bg.Tn);
        this.bEo = new o(frsActivity.getPageContext(), bg.To);
        this.bEx = new ak(frsActivity.getPageContext(), bg.Tp);
        this.bEy = new s(frsActivity.getPageContext(), bg.Tq);
        this.bEp = com.baidu.tieba.recapp.j.aYf().a(frsActivity, com.baidu.tbadk.core.data.c.OU);
        this.bEq = com.baidu.tieba.recapp.j.aYf().a(frsActivity, com.baidu.tbadk.core.data.c.OV);
        this.bEr = com.baidu.tieba.recapp.j.aYf().a(frsActivity, com.baidu.tbadk.core.data.c.OW);
        this.bEs = com.baidu.tieba.recapp.j.aYf().a(frsActivity, com.baidu.tbadk.core.data.c.OX);
        this.bEt = com.baidu.tieba.recapp.j.aYf().a(frsActivity, com.baidu.tbadk.core.data.c.OY);
        this.bEu = new i(frsActivity.getPageContext(), com.baidu.tbadk.core.data.at.SG);
        this.bEv = com.baidu.tieba.frs.g.VZ().a(frsActivity, com.baidu.tieba.tbadkCore.z.ffh, false);
        this.bEE = new bf(frsActivity, com.baidu.tieba.frs.bg.bAx);
        this.bEw = new bj(frsActivity, au.SJ);
        this.bEz = new com.baidu.tieba.frs.c.a(frsActivity, com.baidu.tbadk.core.data.z.Rq);
        this.bEC = new k(frsActivity.getPageContext(), bg.Tu);
        this.bED = new k(frsActivity.getPageContext(), bg.Tv);
        this.bEA = com.baidu.tieba.frs.g.VZ().a(frsActivity, bg.Uu, false);
        this.bEB = com.baidu.tieba.frs.g.VZ().b(frsActivity, bg.Uz);
        this.bEF = new com.baidu.tieba.frs.i.a(frsActivity, com.baidu.tbadk.core.data.x.Rk);
        this.bEH = new ad(frsActivity, bl.bBa);
        this.bEI = new w(frsActivity.getPageContext(), bg.Tw);
        this.bEJ = new u(frsActivity, CardHListViewData.TYPE);
        this.bbV.add(this.bEJ);
        this.bbV.add(this.bEn);
        this.bbV.add(this.bEo);
        this.bbV.add(this.bEp);
        this.bbV.add(this.bEq);
        this.bbV.add(this.bEr);
        this.bbV.add(this.bEs);
        this.bbV.add(this.bEt);
        this.bbV.add(this.bEu);
        this.bbV.add(this.bEI);
        if (this.bEv != null) {
            this.bbV.add(this.bEv);
        }
        this.bbV.add(this.bEE);
        this.bbV.add(this.bEx);
        this.bbV.add(this.bEy);
        this.bbV.add(this.bEw);
        this.bbV.add(this.bEC);
        this.bbV.add(this.bED);
        this.bbV.add(this.bEz);
        this.bbV.add(new bs(frsActivity, bt.bBu));
        this.bbV.add(this.bEA);
        if (this.bEB != null) {
            this.bbV.add(this.bEB);
        }
        this.bbV.add(this.bEF);
        this.bbV.add(this.bEH);
        com.baidu.adp.widget.ListView.a<? extends bg, ? extends y.a> b = com.baidu.tieba.frs.g.VZ().b(frsActivity, bg.Ut);
        if (b != null) {
            this.bbV.add(b);
        }
        this.bEN.setPriority(1);
        this.bEN.setSelfListener(true);
        frsActivity.registerListener(this.bEN);
        frsActivity.registerListener(this.ahW);
        frsActivity.registerListener(this.mLikeForumListener);
        frsActivity.registerListener(this.mUnlikeForumListener);
        frsActivity.registerListener(this.bEP);
        YQ();
        CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_ADD_ADAPTER, new AbsDelegateAdapterList());
        CustomMessage customMessage = new CustomMessage(CmdConfigCustom.CMD_FRS_ADD_ADAPTER);
        customMessage.setTag(frsActivity.getUniqueId());
        customResponsedMessage.setOrginalMessage(customMessage);
        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
        ap(this.bbV);
        bdTypeListView.g(this.bbV);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void M(Object obj) {
        if (this.bnZ != null) {
            Iterator<com.baidu.adp.widget.ListView.v> it = this.bnZ.iterator();
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

    /* JADX INFO: Access modifiers changed from: private */
    public void N(Object obj) {
        if (this.bnZ != null) {
            Iterator<com.baidu.adp.widget.ListView.v> it = this.bnZ.iterator();
            while (it.hasNext()) {
                com.baidu.adp.widget.ListView.v next = it.next();
                if (next instanceof com.baidu.tbadk.core.data.c) {
                    com.baidu.tbadk.core.data.c cVar = (com.baidu.tbadk.core.data.c) next;
                    if (cVar.Py != null) {
                        cVar.Py.refreshReservation(obj);
                    }
                }
            }
        }
    }

    private void YQ() {
        if (this.bzH != null && !YR()) {
            this.bzH.registerListener(this.bEO);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean YR() {
        if (this.bzH == null) {
            return false;
        }
        this.bEG = new ArrayList();
        ArrayList<BdUniqueId> bfh = com.baidu.tieba.tbadkCore.u.bfh();
        if (bfh == null || bfh.size() <= 0) {
            return false;
        }
        int size = bfh.size();
        for (int i = 0; i < size; i++) {
            com.baidu.tieba.frs.au<ICardInfo, ? extends y.a> a = com.baidu.tieba.frs.g.VZ().a(this.bzH, bfh.get(i));
            if (a != null) {
                this.bbV.add(a);
                this.bEG.add(a);
            }
        }
        if (!com.baidu.tbadk.core.util.x.t(this.bEG)) {
            this.aMc.g(this.bEG);
        }
        return true;
    }

    @Override // com.baidu.tieba.frs.entelechy.a.am
    public void onDestory() {
        for (com.baidu.adp.widget.ListView.a aVar : this.bbV) {
            if (aVar instanceof com.baidu.tieba.frs.au) {
                ((com.baidu.tieba.frs.au) aVar).release();
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.a.am
    public void b(ArrayList<com.baidu.adp.widget.ListView.v> arrayList, com.baidu.tieba.tbadkCore.o oVar) {
        a(oVar);
        com.baidu.tieba.tbadkCore.u.r(arrayList, 1);
        F(arrayList);
        G(arrayList);
        E(arrayList);
        this.aMc.setData(arrayList);
        this.bEL = oVar;
        YZ();
        this.bnZ = arrayList;
    }

    private void E(ArrayList<com.baidu.adp.widget.ListView.v> arrayList) {
        int s = com.baidu.tbadk.core.util.x.s(arrayList);
        for (int i = 0; i < s; i++) {
            com.baidu.adp.widget.ListView.v vVar = (com.baidu.adp.widget.ListView.v) com.baidu.tbadk.core.util.x.c(arrayList, i - 1);
            com.baidu.adp.widget.ListView.v vVar2 = (com.baidu.adp.widget.ListView.v) com.baidu.tbadk.core.util.x.c(arrayList, i);
            if (vVar2 instanceof bg) {
                bg bgVar = (bg) vVar2;
                if (i == 0) {
                    bgVar.isFirstFloor = true;
                } else {
                    bgVar.isFirstFloor = false;
                }
                String sc = bgVar.sc();
                if (vVar instanceof bl) {
                    bgVar.needTopMargin = false;
                } else if (vVar != null && !c(vVar)) {
                    bgVar.needTopMargin = false;
                } else if ((vVar instanceof bg) && c(vVar) && !TextUtils.isEmpty(((bg) vVar).sc())) {
                    bgVar.needTopMargin = true;
                } else if (c(vVar2) && !TextUtils.isEmpty(sc)) {
                    bgVar.needTopMargin = true;
                } else {
                    bgVar.needTopMargin = false;
                }
            }
        }
    }

    private boolean c(com.baidu.adp.widget.ListView.v vVar) {
        if (vVar == null) {
            return false;
        }
        BdUniqueId type = vVar.getType();
        return type == bg.Tn || type == bg.To || type == bg.Tp || type == bg.Tq || type == bg.Tw || type == com.baidu.tbadk.core.data.at.SG || type == bg.Tu || type == bg.Tv;
    }

    private ArrayList<Integer> F(ArrayList<com.baidu.adp.widget.ListView.v> arrayList) {
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
            if (vVar instanceof com.baidu.tbadk.core.data.c) {
                arrayList2.add(Integer.valueOf(i2));
                if (this.bEK != null && !this.bEK.containsValue(vVar)) {
                    this.bEK.put(Integer.valueOf(i2), (bg) vVar);
                }
            }
            i = i2 + 1;
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.a.am
    public void dO(boolean z) {
        if (this.bEM != z) {
            this.bEM = z;
            if (this.bEz != null) {
                this.bEz.dO(z);
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.a.am
    public HashMap<Integer, bg> YS() {
        return this.bEK;
    }

    @Override // com.baidu.tieba.frs.entelechy.a.am
    public void YT() {
        if (this.aMc != null && this.aMc.getData() != null && this.aMc.getData().size() != 0) {
            for (com.baidu.adp.widget.ListView.v vVar : this.aMc.getData()) {
                if ((vVar instanceof bg) && ((bg) vVar).rA() != 0) {
                    ((bg) vVar).sl();
                }
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.a.am
    public void notifyDataSetChanged() {
        if (this.aMc.getAdapter() instanceof com.baidu.adp.widget.ListView.e) {
            ((com.baidu.adp.widget.ListView.e) this.aMc.getAdapter()).notifyDataSetChanged();
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.a.am
    public void setFromCDN(boolean z) {
        if (this.bbV != null && this.bbV.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.bbV) {
                if (aVar instanceof com.baidu.tieba.frs.au) {
                    ((com.baidu.tieba.frs.au) aVar).setFromCDN(z);
                }
            }
            if (this.bEn != null) {
                this.bEn.setFromCDN(z);
            }
            if (this.bEo != null) {
                this.bEo.setFromCDN(z);
            }
            if (this.bEC != null) {
                this.bEC.setFromCDN(z);
            }
            if (this.bED != null) {
                this.bED.setFromCDN(z);
            }
            if (this.bEq != null && (this.bEq instanceof com.baidu.tieba.recapp.f)) {
                ((com.baidu.tieba.recapp.f) this.bEq).setIsFromCDN(z);
            }
            if (this.bEr != null && (this.bEr instanceof com.baidu.tieba.recapp.f)) {
                ((com.baidu.tieba.recapp.f) this.bEr).setIsFromCDN(z);
            }
            if (this.bEs != null && (this.bEs instanceof com.baidu.tieba.recapp.f)) {
                ((com.baidu.tieba.recapp.f) this.bEs).setIsFromCDN(z);
            }
            if (this.bEt != null && (this.bEt instanceof com.baidu.tieba.recapp.f)) {
                ((com.baidu.tieba.recapp.f) this.bEt).setIsFromCDN(z);
            }
        }
    }

    public void a(com.baidu.tieba.tbadkCore.o oVar) {
        if (this.bbV != null && this.bbV.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.bbV) {
                if (aVar instanceof com.baidu.tieba.frs.au) {
                    ((com.baidu.tieba.frs.au) aVar).a(oVar);
                }
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.a.am
    public void a(as asVar) {
        if (this.bbV != null && this.bbV.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.bbV) {
                if (aVar instanceof com.baidu.tieba.frs.au) {
                    ((com.baidu.tieba.frs.au) aVar).a(asVar);
                }
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.a.am
    public int YU() {
        if (this.bEv != null) {
            return r.g.frs_fortune_bag_item;
        }
        return 0;
    }

    @Override // com.baidu.tieba.frs.entelechy.a.am
    public int YV() {
        if (this.bEv != null) {
            return r.g.frs_my_service_item;
        }
        return 0;
    }

    @Override // com.baidu.tieba.frs.entelechy.a.am
    public int YW() {
        if (this.bEv != null) {
            return r.g.frs_bawu_center;
        }
        return 0;
    }

    @Override // com.baidu.tieba.frs.entelechy.a.am
    public int YX() {
        if (this.bEw != null) {
            return this.bEw.XR();
        }
        return 0;
    }

    @Override // com.baidu.tieba.frs.entelechy.a.am
    public int XS() {
        if (this.bEw != null) {
            return this.bEw.XS();
        }
        return 0;
    }

    @Override // com.baidu.tieba.frs.entelechy.a.am
    public int YY() {
        if (this.bEz != null) {
            return this.bEz.aaF();
        }
        return 0;
    }

    @Override // com.baidu.tieba.frs.entelechy.a.am
    public boolean k(BdUniqueId bdUniqueId) {
        if (bdUniqueId == null) {
            return false;
        }
        for (com.baidu.adp.widget.ListView.a aVar : this.bbV) {
            if (aVar != null && aVar.getType() == bdUniqueId) {
                return true;
            }
        }
        return false;
    }

    @Override // com.baidu.tieba.frs.entelechy.a.am
    public void a(com.baidu.adp.widget.ListView.w wVar) {
        if (this.bbV != null && this.bbV.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.bbV) {
                if (aVar instanceof com.baidu.tieba.frs.au) {
                    ((com.baidu.tieba.frs.au) aVar).a(wVar);
                } else if ((aVar instanceof z) || (aVar instanceof i) || (aVar instanceof o) || (aVar instanceof k) || (aVar instanceof ak)) {
                    aVar.a(wVar);
                } else if (aVar != null && aVar.getType() == bg.Ut) {
                    aVar.a(wVar);
                }
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.a.am
    public void setForumName(String str) {
        if (this.bbV != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.bbV) {
                if (aVar instanceof bb) {
                    ((bb) aVar).setForumName(str);
                }
            }
        }
    }

    private void YZ() {
        if (this.bEL != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.bbV) {
                if (aVar instanceof com.baidu.tieba.frs.g.e) {
                    com.baidu.tieba.frs.g.e eVar = (com.baidu.tieba.frs.g.e) aVar;
                    if (com.baidu.tieba.frs.g.e.bMV != null) {
                        if (this.bEL.fdP == 1) {
                            com.baidu.tieba.frs.g.e.bMV.bML = true;
                        } else {
                            com.baidu.tieba.frs.g.e.bMV.bML = false;
                        }
                        if (this.bEL.aIk() != null) {
                            com.baidu.tieba.frs.g.e.bMV.bMN = this.bEL.aIk().getId();
                        }
                        if (this.bzH != null && this.bzH.Wi() != null) {
                            com.baidu.tieba.frs.g.e.bMV.bMM = this.bzH.Wh().aaU();
                        }
                    }
                }
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.a.am
    public void a(com.baidu.adp.widget.ListView.x xVar) {
        if (this.bbV != null && this.bbV.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.bbV) {
                if (aVar instanceof com.baidu.tieba.frs.au) {
                    ((com.baidu.tieba.frs.au) aVar).a(xVar);
                } else if ((aVar instanceof z) || (aVar instanceof i) || (aVar instanceof k) || (aVar instanceof o)) {
                    aVar.a(xVar);
                } else if (aVar != null && aVar.getType() == bg.Ut) {
                    aVar.a(xVar);
                }
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.a.am
    public List<com.baidu.adp.widget.ListView.v> getDatas() {
        if (this.aMc != null) {
            return this.aMc.getData();
        }
        return null;
    }

    private void G(ArrayList<com.baidu.adp.widget.ListView.v> arrayList) {
        int i;
        if (this.bbV != null && this.bbV.size() != 0) {
            int i2 = 0;
            if (arrayList == null || arrayList.size() <= 0) {
                i = 0;
            } else {
                Iterator<com.baidu.adp.widget.ListView.v> it = arrayList.iterator();
                while (true) {
                    i = i2;
                    if (!it.hasNext() || it.next().getType().getId() != bg.Tm.getId()) {
                        break;
                    }
                    i2 = i + 1;
                }
            }
            for (com.baidu.adp.widget.ListView.a aVar : this.bbV) {
                if (aVar instanceof com.baidu.tieba.frs.au) {
                    ((com.baidu.tieba.frs.au) aVar).hd(i);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ap(List<com.baidu.adp.widget.ListView.a> list) {
        if (list != null) {
            for (com.baidu.adp.widget.ListView.a aVar : list) {
                if (aVar instanceof com.baidu.tieba.frs.au) {
                    ((com.baidu.tieba.frs.au) aVar).a(this.bzB);
                }
            }
        }
    }
}
