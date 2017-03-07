package com.baidu.tieba.frs.entelechy.a;

import android.text.TextUtils;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.adp.widget.ListView.y;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.data.aw;
import com.baidu.tbadk.core.data.ax;
import com.baidu.tbadk.core.data.bj;
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
import com.baidu.tieba.frs.bq;
import com.baidu.tieba.frs.br;
import com.baidu.tieba.lego.card.model.ICardInfo;
import com.baidu.tieba.tbadkCore.n;
import com.baidu.tieba.w;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public class b implements am {
    private ArrayList<com.baidu.adp.widget.ListView.v> bCS;
    private FrsActivity bOq;
    private z bRR;
    private o bRS;
    private i bRT;
    private com.baidu.adp.widget.ListView.a bRU;
    private bh bRV;
    private ak bRW;
    private s bRX;
    private com.baidu.tieba.frs.c.a bRY;
    private com.baidu.adp.widget.ListView.a bRZ;
    private com.baidu.adp.widget.ListView.a bSa;
    private k bSb;
    private k bSc;
    private bd bSd;
    private com.baidu.tieba.frs.g.a bSe;
    private List<com.baidu.adp.widget.ListView.a> bSf;
    private ad bSg;
    private w bSh;
    private u bSi;
    private final HashMap<Integer, bj> bSj;
    private n bSk;
    private BdTypeListView mListView;
    private List<com.baidu.adp.widget.ListView.a> mAdapters = new LinkedList();
    private boolean bSl = false;
    private CustomMessageListener bSm = new c(this, CmdConfigCustom.CMD_FRS_ADD_ADAPTER);
    private CustomMessageListener bSn = new d(this, CmdConfigCustom.CMD_LEGO_REGISTER);
    private CustomMessageListener amG = new e(this, CmdConfigCustom.CMD_UPDATE_ATTENTION);
    private CustomMessageListener mLikeForumListener = new f(this, CmdConfigCustom.CMD_LIKE_FORUM);
    private CustomMessageListener mUnlikeForumListener = new g(this, CmdConfigCustom.CMD_UNLIKE_FORUM);
    private CustomMessageListener bSo = new h(this, CmdConfigCustom.CMD_UPDATE_ADCARD);
    private final as bOk = new as();

    public b(FrsActivity frsActivity, BdTypeListView bdTypeListView, boolean z) {
        this.mListView = bdTypeListView;
        a(frsActivity, bdTypeListView);
        this.bSj = new HashMap<>();
        dT(z);
    }

    public void a(FrsActivity frsActivity, BdTypeListView bdTypeListView) {
        this.bOq = frsActivity;
        this.bRR = new z(frsActivity.getPageContext(), bj.XK);
        this.bRS = new o(frsActivity.getPageContext(), bj.XL);
        this.bRW = new ak(frsActivity.getPageContext(), bj.XM);
        this.bRX = new s(frsActivity.getPageContext(), bj.XP);
        this.bRT = new i(frsActivity.getPageContext(), aw.Xd);
        this.bRU = com.baidu.tieba.frs.c.Yp().a(frsActivity, com.baidu.tieba.tbadkCore.w.fsY, false);
        this.bSd = new bd(frsActivity, be.bPb);
        this.bRV = new bh(frsActivity, ax.Xg);
        this.bRY = new com.baidu.tieba.frs.c.a(frsActivity, com.baidu.tbadk.core.data.ab.VM);
        this.bSb = new k(frsActivity.getPageContext(), bj.XT);
        this.bSc = new k(frsActivity.getPageContext(), bj.XU);
        this.bRZ = com.baidu.tieba.frs.c.Yp().a(frsActivity, bj.YT, false);
        this.bSa = com.baidu.tieba.frs.c.Yp().b(frsActivity, bj.YY);
        this.bSe = new com.baidu.tieba.frs.g.a(frsActivity, com.baidu.tbadk.core.data.z.VG);
        this.bSg = new ad(frsActivity, com.baidu.tieba.frs.bj.bPD);
        this.bSh = new w(frsActivity.getPageContext(), bj.XV);
        this.bSi = new u(frsActivity, CardHListViewData.TYPE);
        this.mAdapters.add(this.bSi);
        this.mAdapters.add(this.bRR);
        this.mAdapters.add(this.bRS);
        com.baidu.tieba.InjectPlugin.b.b bVar = new com.baidu.tieba.InjectPlugin.b.b(this.bOq.getPageContext(), 1);
        bVar.K(this.mAdapters);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_FEED_AD_PLUGIN_OPERATE, bVar));
        this.mAdapters.add(this.bRT);
        this.mAdapters.add(this.bSh);
        if (this.bRU != null) {
            this.mAdapters.add(this.bRU);
        }
        this.mAdapters.add(this.bSd);
        this.mAdapters.add(this.bRW);
        this.mAdapters.add(this.bRX);
        this.mAdapters.add(this.bRV);
        this.mAdapters.add(this.bSb);
        this.mAdapters.add(this.bSc);
        this.mAdapters.add(this.bRY);
        this.mAdapters.add(new bq(frsActivity, br.bPX));
        this.mAdapters.add(this.bRZ);
        if (this.bSa != null) {
            this.mAdapters.add(this.bSa);
        }
        this.mAdapters.add(this.bSe);
        this.mAdapters.add(this.bSg);
        com.baidu.adp.widget.ListView.a<? extends bj, ? extends y.a> b = com.baidu.tieba.frs.c.Yp().b(frsActivity, bj.YS);
        if (b != null) {
            this.mAdapters.add(b);
        }
        this.bSm.setPriority(1);
        this.bSm.setSelfListener(true);
        frsActivity.registerListener(this.bSm);
        frsActivity.registerListener(this.amG);
        frsActivity.registerListener(this.mLikeForumListener);
        frsActivity.registerListener(this.mUnlikeForumListener);
        frsActivity.registerListener(this.bSo);
        aaP();
        CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_ADD_ADAPTER, new AbsDelegateAdapterList());
        CustomMessage customMessage = new CustomMessage(CmdConfigCustom.CMD_FRS_ADD_ADAPTER);
        customMessage.setTag(frsActivity.getUniqueId());
        customResponsedMessage.setOrginalMessage(customMessage);
        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
        aq(this.mAdapters);
        bdTypeListView.addAdapters(this.mAdapters);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Q(Object obj) {
        if (this.bCS != null) {
            Iterator<com.baidu.adp.widget.ListView.v> it = this.bCS.iterator();
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
        if (this.bCS != null) {
            Iterator<com.baidu.adp.widget.ListView.v> it = this.bCS.iterator();
            while (it.hasNext()) {
                com.baidu.adp.widget.ListView.v next = it.next();
                if (next instanceof AdvertAppInfo) {
                    AdvertAppInfo advertAppInfo = (AdvertAppInfo) next;
                    if (advertAppInfo.legoCard != null) {
                        advertAppInfo.legoCard.refreshReservation(obj);
                    }
                }
            }
        }
    }

    private void aaP() {
        if (this.bOq != null && !aaQ()) {
            this.bOq.registerListener(this.bSn);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aaQ() {
        if (this.bOq == null) {
            return false;
        }
        this.bSf = new ArrayList();
        ArrayList<BdUniqueId> bgJ = com.baidu.tieba.tbadkCore.t.bgJ();
        if (bgJ == null || bgJ.size() <= 0) {
            return false;
        }
        int size = bgJ.size();
        for (int i = 0; i < size; i++) {
            at<ICardInfo, ? extends y.a> a = com.baidu.tieba.frs.c.Yp().a(this.bOq, bgJ.get(i));
            if (a != null) {
                this.mAdapters.add(a);
                this.bSf.add(a);
            }
        }
        if (!com.baidu.tbadk.core.util.x.q(this.bSf)) {
            this.mListView.addAdapters(this.bSf);
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
        G(arrayList);
        H(arrayList);
        F(arrayList);
        this.mListView.setData(arrayList);
        this.bSk = nVar;
        aaY();
        this.bCS = arrayList;
    }

    private void F(ArrayList<com.baidu.adp.widget.ListView.v> arrayList) {
        int p = com.baidu.tbadk.core.util.x.p(arrayList);
        for (int i = 0; i < p; i++) {
            com.baidu.adp.widget.ListView.v vVar = (com.baidu.adp.widget.ListView.v) com.baidu.tbadk.core.util.x.c(arrayList, i - 1);
            com.baidu.adp.widget.ListView.v vVar2 = (com.baidu.adp.widget.ListView.v) com.baidu.tbadk.core.util.x.c(arrayList, i);
            if (vVar2 instanceof bj) {
                bj bjVar = (bj) vVar2;
                if (i == 0) {
                    bjVar.isFirstFloor = true;
                } else {
                    bjVar.isFirstFloor = false;
                }
                String so = bjVar.so();
                if (vVar instanceof com.baidu.tieba.frs.bj) {
                    bjVar.needTopMargin = false;
                } else if (vVar != null && !c(vVar)) {
                    bjVar.needTopMargin = false;
                } else if ((vVar instanceof bj) && c(vVar) && !TextUtils.isEmpty(((bj) vVar).so())) {
                    bjVar.needTopMargin = true;
                } else if (c(vVar2) && !TextUtils.isEmpty(so)) {
                    bjVar.needTopMargin = true;
                } else {
                    bjVar.needTopMargin = false;
                }
            }
        }
    }

    private boolean c(com.baidu.adp.widget.ListView.v vVar) {
        if (vVar == null) {
            return false;
        }
        BdUniqueId type = vVar.getType();
        return type == bj.XK || type == bj.XL || type == bj.XM || type == bj.XP || type == bj.XV || type == aw.Xd || type == bj.XT || type == bj.XU;
    }

    private ArrayList<Integer> G(ArrayList<com.baidu.adp.widget.ListView.v> arrayList) {
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
            if (vVar instanceof AdvertAppInfo) {
                arrayList2.add(Integer.valueOf(i2));
                if (this.bSj != null && !this.bSj.containsValue(vVar)) {
                    this.bSj.put(Integer.valueOf(i2), (bj) vVar);
                }
            }
            i = i2 + 1;
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.a.am
    public void dT(boolean z) {
        if (this.bSl != z) {
            this.bSl = z;
            if (this.bRY != null) {
                this.bRY.dT(z);
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.a.am
    public HashMap<Integer, bj> aaR() {
        return this.bSj;
    }

    @Override // com.baidu.tieba.frs.entelechy.a.am
    public void aaS() {
        if (this.mListView != null && this.mListView.getData() != null && this.mListView.getData().size() != 0) {
            for (com.baidu.adp.widget.ListView.v vVar : this.mListView.getData()) {
                if ((vVar instanceof bj) && ((bj) vVar).rM() != 0) {
                    ((bj) vVar).sy();
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
            if (this.bRR != null) {
                this.bRR.setFromCDN(z);
            }
            if (this.bRS != null) {
                this.bRS.setFromCDN(z);
            }
            if (this.bSb != null) {
                this.bSb.setFromCDN(z);
            }
            if (this.bSc != null) {
                this.bSc.setFromCDN(z);
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
    public int aaT() {
        if (this.bRU != null) {
            return w.h.frs_fortune_bag_item;
        }
        return 0;
    }

    @Override // com.baidu.tieba.frs.entelechy.a.am
    public int aaU() {
        if (this.bRU != null) {
            return w.h.frs_my_service_item;
        }
        return 0;
    }

    @Override // com.baidu.tieba.frs.entelechy.a.am
    public int aaV() {
        if (this.bRU != null) {
            return w.h.frs_bawu_center;
        }
        return 0;
    }

    @Override // com.baidu.tieba.frs.entelechy.a.am
    public int aaW() {
        if (this.bRV != null) {
            return this.bRV.ZX();
        }
        return 0;
    }

    @Override // com.baidu.tieba.frs.entelechy.a.am
    public int ZY() {
        if (this.bRV != null) {
            return this.bRV.ZY();
        }
        return 0;
    }

    @Override // com.baidu.tieba.frs.entelechy.a.am
    public int aaX() {
        if (this.bRY != null) {
            return this.bRY.acI();
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
                } else if (aVar != null && aVar.getType() == bj.YS) {
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

    private void aaY() {
        if (this.bSk != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.mAdapters) {
                if (aVar instanceof com.baidu.tieba.frs.e.e) {
                    com.baidu.tieba.frs.e.e eVar = (com.baidu.tieba.frs.e.e) aVar;
                    if (com.baidu.tieba.frs.e.e.cav != null) {
                        if (this.bSk.frI == 1) {
                            com.baidu.tieba.frs.e.e.cav.cal = true;
                        } else {
                            com.baidu.tieba.frs.e.e.cav.cal = false;
                        }
                        if (this.bSk.aJp() != null) {
                            com.baidu.tieba.frs.e.e.cav.can = this.bSk.aJp().getId();
                        }
                        if (this.bOq != null && this.bOq.Yy() != null) {
                            com.baidu.tieba.frs.e.e.cav.cam = this.bOq.Yx().acX();
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
                } else if (aVar != null && aVar.getType() == bj.YS) {
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

    private void H(ArrayList<com.baidu.adp.widget.ListView.v> arrayList) {
        int i;
        if (this.mAdapters != null && this.mAdapters.size() != 0) {
            int i2 = 0;
            if (arrayList == null || arrayList.size() <= 0) {
                i = 0;
            } else {
                Iterator<com.baidu.adp.widget.ListView.v> it = arrayList.iterator();
                while (true) {
                    i = i2;
                    if (!it.hasNext() || it.next().getType().getId() != bj.XJ.getId()) {
                        break;
                    }
                    i2 = i + 1;
                }
            }
            for (com.baidu.adp.widget.ListView.a aVar : this.mAdapters) {
                if (aVar instanceof at) {
                    ((at) aVar).hL(i);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aq(List<com.baidu.adp.widget.ListView.a> list) {
        if (list != null) {
            for (com.baidu.adp.widget.ListView.a aVar : list) {
                if (aVar instanceof at) {
                    ((at) aVar).a(this.bOk);
                }
            }
        }
    }
}
