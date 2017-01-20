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
import com.baidu.tbadk.core.data.av;
import com.baidu.tbadk.core.data.y;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.card.cd;
import com.baidu.tieba.card.data.CardHListViewData;
import com.baidu.tieba.frs.AbsDelegateAdapterList;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.frs.ar;
import com.baidu.tieba.frs.as;
import com.baidu.tieba.frs.at;
import com.baidu.tieba.frs.bd;
import com.baidu.tieba.frs.be;
import com.baidu.tieba.frs.bh;
import com.baidu.tieba.frs.bj;
import com.baidu.tieba.frs.bq;
import com.baidu.tieba.frs.br;
import com.baidu.tieba.lego.card.model.ICardInfo;
import com.baidu.tieba.r;
import com.baidu.tieba.tbadkCore.n;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public class b implements am {
    private FrsActivity bHh;
    private z bKL;
    private o bKM;
    private i bKN;
    private com.baidu.adp.widget.ListView.a bKO;
    private bh bKP;
    private ak bKQ;
    private s bKR;
    private com.baidu.tieba.frs.c.a bKS;
    private com.baidu.adp.widget.ListView.a bKT;
    private com.baidu.adp.widget.ListView.a bKU;
    private k bKV;
    private k bKW;
    private bd bKX;
    private com.baidu.tieba.frs.g.a bKY;
    private List<com.baidu.adp.widget.ListView.a> bKZ;
    private ad bLa;
    private w bLb;
    private u bLc;
    private final HashMap<Integer, com.baidu.tbadk.core.data.bh> bLd;
    private n bLe;
    private ArrayList<com.baidu.adp.widget.ListView.v> bvM;
    private BdTypeListView mListView;
    private List<com.baidu.adp.widget.ListView.a> mAdapters = new LinkedList();
    private boolean bLf = false;
    private CustomMessageListener bLg = new c(this, CmdConfigCustom.CMD_FRS_ADD_ADAPTER);
    private CustomMessageListener bLh = new d(this, CmdConfigCustom.CMD_LEGO_REGISTER);
    private CustomMessageListener ahk = new e(this, CmdConfigCustom.CMD_UPDATE_ATTENTION);
    private CustomMessageListener mLikeForumListener = new f(this, CmdConfigCustom.CMD_LIKE_FORUM);
    private CustomMessageListener mUnlikeForumListener = new g(this, CmdConfigCustom.CMD_UNLIKE_FORUM);
    private CustomMessageListener bLi = new h(this, CmdConfigCustom.CMD_UPDATE_ADCARD);
    private final as bHb = new as();

    public b(FrsActivity frsActivity, BdTypeListView bdTypeListView, boolean z) {
        this.mListView = bdTypeListView;
        a(frsActivity, bdTypeListView);
        this.bLd = new HashMap<>();
        dT(z);
    }

    public void a(FrsActivity frsActivity, BdTypeListView bdTypeListView) {
        this.bHh = frsActivity;
        this.bKL = new z(frsActivity.getPageContext(), com.baidu.tbadk.core.data.bh.Sx);
        this.bKM = new o(frsActivity.getPageContext(), com.baidu.tbadk.core.data.bh.Sy);
        this.bKQ = new ak(frsActivity.getPageContext(), com.baidu.tbadk.core.data.bh.Sz);
        this.bKR = new s(frsActivity.getPageContext(), com.baidu.tbadk.core.data.bh.SC);
        this.bKN = new i(frsActivity.getPageContext(), au.RQ);
        this.bKO = com.baidu.tieba.frs.c.Xq().a(frsActivity, com.baidu.tieba.tbadkCore.x.foC, false);
        this.bKX = new bd(frsActivity, be.bHS);
        this.bKP = new bh(frsActivity, av.RT);
        this.bKS = new com.baidu.tieba.frs.c.a(frsActivity, com.baidu.tbadk.core.data.aa.Qz);
        this.bKV = new k(frsActivity.getPageContext(), com.baidu.tbadk.core.data.bh.SG);
        this.bKW = new k(frsActivity.getPageContext(), com.baidu.tbadk.core.data.bh.SH);
        this.bKT = com.baidu.tieba.frs.c.Xq().a(frsActivity, com.baidu.tbadk.core.data.bh.TH, false);
        this.bKU = com.baidu.tieba.frs.c.Xq().b(frsActivity, com.baidu.tbadk.core.data.bh.TM);
        this.bKY = new com.baidu.tieba.frs.g.a(frsActivity, y.Qt);
        this.bLa = new ad(frsActivity, bj.bIu);
        this.bLb = new w(frsActivity.getPageContext(), com.baidu.tbadk.core.data.bh.SI);
        this.bLc = new u(frsActivity, CardHListViewData.TYPE);
        this.mAdapters.add(this.bLc);
        this.mAdapters.add(this.bKL);
        this.mAdapters.add(this.bKM);
        com.baidu.tieba.InjectPlugin.b.b bVar = new com.baidu.tieba.InjectPlugin.b.b(this.bHh.getPageContext(), 1);
        bVar.K((Object) this.mAdapters);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_FEED_AD_PLUGIN_OPERATE, bVar));
        this.mAdapters.add(this.bKN);
        this.mAdapters.add(this.bLb);
        if (this.bKO != null) {
            this.mAdapters.add(this.bKO);
        }
        this.mAdapters.add(this.bKX);
        this.mAdapters.add(this.bKQ);
        this.mAdapters.add(this.bKR);
        this.mAdapters.add(this.bKP);
        this.mAdapters.add(this.bKV);
        this.mAdapters.add(this.bKW);
        this.mAdapters.add(this.bKS);
        this.mAdapters.add(new bq(frsActivity, br.bIO));
        this.mAdapters.add(this.bKT);
        if (this.bKU != null) {
            this.mAdapters.add(this.bKU);
        }
        this.mAdapters.add(this.bKY);
        this.mAdapters.add(this.bLa);
        com.baidu.adp.widget.ListView.a<? extends com.baidu.tbadk.core.data.bh, ? extends y.a> b = com.baidu.tieba.frs.c.Xq().b(frsActivity, com.baidu.tbadk.core.data.bh.TG);
        if (b != null) {
            this.mAdapters.add(b);
        }
        this.bLg.setPriority(1);
        this.bLg.setSelfListener(true);
        frsActivity.registerListener(this.bLg);
        frsActivity.registerListener(this.ahk);
        frsActivity.registerListener(this.mLikeForumListener);
        frsActivity.registerListener(this.mUnlikeForumListener);
        frsActivity.registerListener(this.bLi);
        ZS();
        CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_ADD_ADAPTER, new AbsDelegateAdapterList());
        CustomMessage customMessage = new CustomMessage(CmdConfigCustom.CMD_FRS_ADD_ADAPTER);
        customMessage.setTag(frsActivity.getUniqueId());
        customResponsedMessage.setOrginalMessage(customMessage);
        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
        at(this.mAdapters);
        bdTypeListView.addAdapters(this.mAdapters);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Q(Object obj) {
        if (this.bvM != null) {
            Iterator<com.baidu.adp.widget.ListView.v> it = this.bvM.iterator();
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
    public void R(Object obj) {
        if (this.bvM != null) {
            Iterator<com.baidu.adp.widget.ListView.v> it = this.bvM.iterator();
            while (it.hasNext()) {
                com.baidu.adp.widget.ListView.v next = it.next();
                if (next instanceof com.baidu.tbadk.core.data.c) {
                    com.baidu.tbadk.core.data.c cVar = (com.baidu.tbadk.core.data.c) next;
                    if (cVar.legoCard != null) {
                        cVar.legoCard.refreshReservation(obj);
                    }
                }
            }
        }
    }

    private void ZS() {
        if (this.bHh != null && !ZT()) {
            this.bHh.registerListener(this.bLh);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean ZT() {
        if (this.bHh == null) {
            return false;
        }
        this.bKZ = new ArrayList();
        ArrayList<BdUniqueId> bgW = com.baidu.tieba.tbadkCore.t.bgW();
        if (bgW == null || bgW.size() <= 0) {
            return false;
        }
        int size = bgW.size();
        for (int i = 0; i < size; i++) {
            at<ICardInfo, ? extends y.a> a = com.baidu.tieba.frs.c.Xq().a(this.bHh, bgW.get(i));
            if (a != null) {
                this.mAdapters.add(a);
                this.bKZ.add(a);
            }
        }
        if (!com.baidu.tbadk.core.util.w.s(this.bKZ)) {
            this.mListView.addAdapters(this.bKZ);
        }
        return true;
    }

    @Override // com.baidu.tieba.frs.entelechy.a.am
    public void onDestory() {
        for (com.baidu.adp.widget.ListView.a aVar : this.mAdapters) {
            if (aVar instanceof at) {
                ((at) aVar).release();
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.a.am
    public void b(ArrayList<com.baidu.adp.widget.ListView.v> arrayList, n nVar) {
        a(nVar);
        com.baidu.tieba.tbadkCore.t.r(arrayList, 1);
        H(arrayList);
        I(arrayList);
        G(arrayList);
        this.mListView.setData(arrayList);
        this.bLe = nVar;
        aab();
        this.bvM = arrayList;
    }

    private void G(ArrayList<com.baidu.adp.widget.ListView.v> arrayList) {
        int r = com.baidu.tbadk.core.util.w.r(arrayList);
        for (int i = 0; i < r; i++) {
            com.baidu.adp.widget.ListView.v vVar = (com.baidu.adp.widget.ListView.v) com.baidu.tbadk.core.util.w.c(arrayList, i - 1);
            com.baidu.adp.widget.ListView.v vVar2 = (com.baidu.adp.widget.ListView.v) com.baidu.tbadk.core.util.w.c(arrayList, i);
            if (vVar2 instanceof com.baidu.tbadk.core.data.bh) {
                com.baidu.tbadk.core.data.bh bhVar = (com.baidu.tbadk.core.data.bh) vVar2;
                if (i == 0) {
                    bhVar.isFirstFloor = true;
                } else {
                    bhVar.isFirstFloor = false;
                }
                String rU = bhVar.rU();
                if (vVar instanceof bj) {
                    bhVar.needTopMargin = false;
                } else if (vVar != null && !c(vVar)) {
                    bhVar.needTopMargin = false;
                } else if ((vVar instanceof com.baidu.tbadk.core.data.bh) && c(vVar) && !TextUtils.isEmpty(((com.baidu.tbadk.core.data.bh) vVar).rU())) {
                    bhVar.needTopMargin = true;
                } else if (c(vVar2) && !TextUtils.isEmpty(rU)) {
                    bhVar.needTopMargin = true;
                } else {
                    bhVar.needTopMargin = false;
                }
            }
        }
    }

    private boolean c(com.baidu.adp.widget.ListView.v vVar) {
        if (vVar == null) {
            return false;
        }
        BdUniqueId type = vVar.getType();
        return type == com.baidu.tbadk.core.data.bh.Sx || type == com.baidu.tbadk.core.data.bh.Sy || type == com.baidu.tbadk.core.data.bh.Sz || type == com.baidu.tbadk.core.data.bh.SC || type == com.baidu.tbadk.core.data.bh.SI || type == au.RQ || type == com.baidu.tbadk.core.data.bh.SG || type == com.baidu.tbadk.core.data.bh.SH;
    }

    private ArrayList<Integer> H(ArrayList<com.baidu.adp.widget.ListView.v> arrayList) {
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
                if (this.bLd != null && !this.bLd.containsValue(vVar)) {
                    this.bLd.put(Integer.valueOf(i2), (com.baidu.tbadk.core.data.bh) vVar);
                }
            }
            i = i2 + 1;
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.a.am
    public void dT(boolean z) {
        if (this.bLf != z) {
            this.bLf = z;
            if (this.bKS != null) {
                this.bKS.dT(z);
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.a.am
    public HashMap<Integer, com.baidu.tbadk.core.data.bh> ZU() {
        return this.bLd;
    }

    @Override // com.baidu.tieba.frs.entelechy.a.am
    public void ZV() {
        if (this.mListView != null && this.mListView.getData() != null && this.mListView.getData().size() != 0) {
            for (com.baidu.adp.widget.ListView.v vVar : this.mListView.getData()) {
                if ((vVar instanceof com.baidu.tbadk.core.data.bh) && ((com.baidu.tbadk.core.data.bh) vVar).rs() != 0) {
                    ((com.baidu.tbadk.core.data.bh) vVar).sd();
                }
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.a.am
    public void notifyDataSetChanged() {
        if (this.mListView.getAdapter() instanceof com.baidu.adp.widget.ListView.e) {
            ((com.baidu.adp.widget.ListView.e) this.mListView.getAdapter()).notifyDataSetChanged();
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.a.am
    public void setFromCDN(boolean z) {
        if (this.mAdapters != null && this.mAdapters.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.mAdapters) {
                if (aVar instanceof at) {
                    ((at) aVar).setFromCDN(z);
                }
            }
            if (this.bKL != null) {
                this.bKL.setFromCDN(z);
            }
            if (this.bKM != null) {
                this.bKM.setFromCDN(z);
            }
            if (this.bKV != null) {
                this.bKV.setFromCDN(z);
            }
            if (this.bKW != null) {
                this.bKW.setFromCDN(z);
            }
        }
    }

    public void a(n nVar) {
        if (this.mAdapters != null && this.mAdapters.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.mAdapters) {
                if (aVar instanceof at) {
                    ((at) aVar).a(nVar);
                }
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.a.am
    public void a(ar arVar) {
        if (this.mAdapters != null && this.mAdapters.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.mAdapters) {
                if (aVar instanceof at) {
                    ((at) aVar).a(arVar);
                }
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.a.am
    public int ZW() {
        if (this.bKO != null) {
            return r.h.frs_fortune_bag_item;
        }
        return 0;
    }

    @Override // com.baidu.tieba.frs.entelechy.a.am
    public int ZX() {
        if (this.bKO != null) {
            return r.h.frs_my_service_item;
        }
        return 0;
    }

    @Override // com.baidu.tieba.frs.entelechy.a.am
    public int ZY() {
        if (this.bKO != null) {
            return r.h.frs_bawu_center;
        }
        return 0;
    }

    @Override // com.baidu.tieba.frs.entelechy.a.am
    public int ZZ() {
        if (this.bKP != null) {
            return this.bKP.YY();
        }
        return 0;
    }

    @Override // com.baidu.tieba.frs.entelechy.a.am
    public int YZ() {
        if (this.bKP != null) {
            return this.bKP.YZ();
        }
        return 0;
    }

    @Override // com.baidu.tieba.frs.entelechy.a.am
    public int aaa() {
        if (this.bKS != null) {
            return this.bKS.abL();
        }
        return 0;
    }

    @Override // com.baidu.tieba.frs.entelechy.a.am
    public boolean l(BdUniqueId bdUniqueId) {
        if (bdUniqueId == null) {
            return false;
        }
        for (com.baidu.adp.widget.ListView.a aVar : this.mAdapters) {
            if (aVar != null && aVar.getType() == bdUniqueId) {
                return true;
            }
        }
        return false;
    }

    @Override // com.baidu.tieba.frs.entelechy.a.am
    public void setOnAdapterItemClickListener(com.baidu.adp.widget.ListView.w wVar) {
        if (this.mAdapters != null && this.mAdapters.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.mAdapters) {
                if (aVar instanceof at) {
                    ((at) aVar).setOnAdapterItemClickListener(wVar);
                } else if ((aVar instanceof z) || (aVar instanceof i) || (aVar instanceof o) || (aVar instanceof k) || (aVar instanceof ak)) {
                    aVar.setOnAdapterItemClickListener(wVar);
                } else if (aVar != null && aVar.getType() == com.baidu.tbadk.core.data.bh.TG) {
                    aVar.setOnAdapterItemClickListener(wVar);
                }
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.a.am
    public void setForumName(String str) {
        if (this.mAdapters != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.mAdapters) {
                if (aVar instanceof cd) {
                    ((cd) aVar).setForumName(str);
                }
            }
        }
    }

    private void aab() {
        if (this.bLe != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.mAdapters) {
                if (aVar instanceof com.baidu.tieba.frs.e.e) {
                    com.baidu.tieba.frs.e.e eVar = (com.baidu.tieba.frs.e.e) aVar;
                    if (com.baidu.tieba.frs.e.e.bTj != null) {
                        if (this.bLe.fnk == 1) {
                            com.baidu.tieba.frs.e.e.bTj.bSZ = true;
                        } else {
                            com.baidu.tieba.frs.e.e.bTj.bSZ = false;
                        }
                        if (this.bLe.aJY() != null) {
                            com.baidu.tieba.frs.e.e.bTj.bTb = this.bLe.aJY().getId();
                        }
                        if (this.bHh != null && this.bHh.Xz() != null) {
                            com.baidu.tieba.frs.e.e.bTj.bTa = this.bHh.Xy().aca();
                        }
                    }
                }
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.a.am
    public void setOnAdapterItemLongClickListener(com.baidu.adp.widget.ListView.x xVar) {
        if (this.mAdapters != null && this.mAdapters.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.mAdapters) {
                if (aVar instanceof at) {
                    ((at) aVar).setOnAdapterItemLongClickListener(xVar);
                } else if ((aVar instanceof z) || (aVar instanceof i) || (aVar instanceof k) || (aVar instanceof o)) {
                    aVar.setOnAdapterItemLongClickListener(xVar);
                } else if (aVar != null && aVar.getType() == com.baidu.tbadk.core.data.bh.TG) {
                    aVar.setOnAdapterItemLongClickListener(xVar);
                }
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.a.am
    public List<com.baidu.adp.widget.ListView.v> getDatas() {
        if (this.mListView != null) {
            return this.mListView.getData();
        }
        return null;
    }

    private void I(ArrayList<com.baidu.adp.widget.ListView.v> arrayList) {
        int i;
        if (this.mAdapters != null && this.mAdapters.size() != 0) {
            int i2 = 0;
            if (arrayList == null || arrayList.size() <= 0) {
                i = 0;
            } else {
                Iterator<com.baidu.adp.widget.ListView.v> it = arrayList.iterator();
                while (true) {
                    i = i2;
                    if (!it.hasNext() || it.next().getType().getId() != com.baidu.tbadk.core.data.bh.Sw.getId()) {
                        break;
                    }
                    i2 = i + 1;
                }
            }
            for (com.baidu.adp.widget.ListView.a aVar : this.mAdapters) {
                if (aVar instanceof at) {
                    ((at) aVar).hP(i);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void at(List<com.baidu.adp.widget.ListView.a> list) {
        if (list != null) {
            for (com.baidu.adp.widget.ListView.a aVar : list) {
                if (aVar instanceof at) {
                    ((at) aVar).a(this.bHb);
                }
            }
        }
    }
}
