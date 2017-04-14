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
import com.baidu.tbadk.core.data.av;
import com.baidu.tbadk.core.data.aw;
import com.baidu.tbadk.core.data.bi;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.card.cd;
import com.baidu.tieba.card.data.CardHListViewData;
import com.baidu.tieba.frs.AbsDelegateAdapterList;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.frs.at;
import com.baidu.tieba.frs.au;
import com.baidu.tieba.frs.bf;
import com.baidu.tieba.frs.bg;
import com.baidu.tieba.frs.bj;
import com.baidu.tieba.frs.bl;
import com.baidu.tieba.frs.bs;
import com.baidu.tieba.frs.bt;
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
    private ArrayList<com.baidu.adp.widget.ListView.v> bCL;
    private FrsActivity bOf;
    private z bRG;
    private o bRH;
    private i bRI;
    private com.baidu.adp.widget.ListView.a bRJ;
    private bj bRK;
    private ak bRL;
    private s bRM;
    private com.baidu.adp.widget.ListView.a bRN;
    private com.baidu.adp.widget.ListView.a bRO;
    private k bRP;
    private k bRQ;
    private bf bRR;
    private com.baidu.tieba.frs.h.a bRS;
    private List<com.baidu.adp.widget.ListView.a> bRT;
    private ad bRU;
    private w bRV;
    private u bRW;
    private final HashMap<Integer, bi> bRX;
    private n bRY;
    private BdTypeListView mListView;
    private List<com.baidu.adp.widget.ListView.a> mAdapters = new LinkedList();
    private boolean bRZ = false;
    private CustomMessageListener bSa = new c(this, CmdConfigCustom.CMD_FRS_ADD_ADAPTER);
    private CustomMessageListener bSb = new d(this, CmdConfigCustom.CMD_LEGO_REGISTER);
    private CustomMessageListener amU = new e(this, CmdConfigCustom.CMD_UPDATE_ATTENTION);
    private CustomMessageListener mLikeForumListener = new f(this, CmdConfigCustom.CMD_LIKE_FORUM);
    private CustomMessageListener mUnlikeForumListener = new g(this, CmdConfigCustom.CMD_UNLIKE_FORUM);
    private CustomMessageListener bSc = new h(this, CmdConfigCustom.CMD_UPDATE_ADCARD);
    private final au bNZ = new au();

    public b(FrsActivity frsActivity, BdTypeListView bdTypeListView, boolean z) {
        this.mListView = bdTypeListView;
        a(frsActivity, bdTypeListView);
        this.bRX = new HashMap<>();
        dV(z);
    }

    public void a(FrsActivity frsActivity, BdTypeListView bdTypeListView) {
        this.bOf = frsActivity;
        this.bRG = new z(frsActivity.getPageContext(), bi.Ya);
        this.bRH = new o(frsActivity.getPageContext(), bi.Yb);
        this.bRL = new ak(frsActivity.getPageContext(), bi.Yc);
        this.bRM = new s(frsActivity.getPageContext(), bi.Yf);
        this.bRI = new i(frsActivity.getPageContext(), av.Xt);
        this.bRJ = com.baidu.tieba.frs.c.YM().a(frsActivity, com.baidu.tieba.tbadkCore.w.fuI, false);
        this.bRR = new bf(frsActivity, bg.bOQ);
        this.bRK = new bj(frsActivity, aw.Xw);
        this.bRP = new k(frsActivity.getPageContext(), bi.Yj);
        this.bRQ = new k(frsActivity.getPageContext(), bi.Yk);
        this.bRN = com.baidu.tieba.frs.c.YM().a(frsActivity, bi.Zj, false);
        this.bRO = com.baidu.tieba.frs.c.YM().b(frsActivity, bi.Zo);
        this.bRS = new com.baidu.tieba.frs.h.a(frsActivity, com.baidu.tbadk.core.data.z.VX);
        this.bRU = new ad(frsActivity, bl.bPs);
        this.bRV = new w(frsActivity.getPageContext(), bi.Yl);
        this.bRW = new u(frsActivity, CardHListViewData.TYPE);
        this.mAdapters.add(this.bRW);
        this.mAdapters.add(this.bRG);
        this.mAdapters.add(this.bRH);
        com.baidu.tieba.InjectPlugin.b.b bVar = new com.baidu.tieba.InjectPlugin.b.b(this.bOf.getPageContext(), 1);
        bVar.K(this.mAdapters);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_FEED_AD_PLUGIN_OPERATE, bVar));
        this.mAdapters.add(this.bRI);
        this.mAdapters.add(this.bRV);
        if (this.bRJ != null) {
            this.mAdapters.add(this.bRJ);
        }
        this.mAdapters.add(this.bRR);
        this.mAdapters.add(this.bRL);
        this.mAdapters.add(this.bRM);
        this.mAdapters.add(this.bRK);
        this.mAdapters.add(this.bRP);
        this.mAdapters.add(this.bRQ);
        this.mAdapters.add(new bs(frsActivity, bt.bPM));
        this.mAdapters.add(this.bRN);
        if (this.bRO != null) {
            this.mAdapters.add(this.bRO);
        }
        this.mAdapters.add(this.bRS);
        this.mAdapters.add(this.bRU);
        com.baidu.adp.widget.ListView.a<? extends bi, ? extends y.a> b = com.baidu.tieba.frs.c.YM().b(frsActivity, bi.Zi);
        if (b != null) {
            this.mAdapters.add(b);
        }
        this.bSa.setPriority(1);
        this.bSa.setSelfListener(true);
        frsActivity.registerListener(this.bSa);
        frsActivity.registerListener(this.amU);
        frsActivity.registerListener(this.mLikeForumListener);
        frsActivity.registerListener(this.mUnlikeForumListener);
        frsActivity.registerListener(this.bSc);
        abn();
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
        if (this.bCL != null) {
            Iterator<com.baidu.adp.widget.ListView.v> it = this.bCL.iterator();
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
        if (this.bCL != null) {
            Iterator<com.baidu.adp.widget.ListView.v> it = this.bCL.iterator();
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

    private void abn() {
        if (this.bOf != null && !abo()) {
            this.bOf.registerListener(this.bSb);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean abo() {
        if (this.bOf == null) {
            return false;
        }
        this.bRT = new ArrayList();
        ArrayList<BdUniqueId> bhu = com.baidu.tieba.tbadkCore.t.bhu();
        if (bhu == null || bhu.size() <= 0) {
            return false;
        }
        int size = bhu.size();
        for (int i = 0; i < size; i++) {
            com.baidu.tieba.frs.av<ICardInfo, ? extends y.a> a = com.baidu.tieba.frs.c.YM().a(this.bOf, bhu.get(i));
            if (a != null) {
                this.mAdapters.add(a);
                this.bRT.add(a);
            }
        }
        if (!com.baidu.tbadk.core.util.x.q(this.bRT)) {
            this.mListView.addAdapters(this.bRT);
        }
        return true;
    }

    @Override // com.baidu.tieba.frs.entelechy.a.am
    public void onDestory() {
        for (com.baidu.adp.widget.ListView.a aVar : this.mAdapters) {
            if (aVar instanceof com.baidu.tieba.frs.av) {
                ((com.baidu.tieba.frs.av) aVar).release();
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
        this.bRY = nVar;
        abv();
        this.bCL = arrayList;
    }

    private void F(ArrayList<com.baidu.adp.widget.ListView.v> arrayList) {
        int p = com.baidu.tbadk.core.util.x.p(arrayList);
        for (int i = 0; i < p; i++) {
            com.baidu.adp.widget.ListView.v vVar = (com.baidu.adp.widget.ListView.v) com.baidu.tbadk.core.util.x.c(arrayList, i - 1);
            com.baidu.adp.widget.ListView.v vVar2 = (com.baidu.adp.widget.ListView.v) com.baidu.tbadk.core.util.x.c(arrayList, i);
            if (vVar2 instanceof bi) {
                bi biVar = (bi) vVar2;
                if (i == 0) {
                    biVar.isFirstFloor = true;
                } else {
                    biVar.isFirstFloor = false;
                }
                String sM = biVar.sM();
                if (vVar instanceof bl) {
                    biVar.needTopMargin = false;
                } else if (vVar != null && !c(vVar)) {
                    biVar.needTopMargin = false;
                } else if ((vVar instanceof bi) && c(vVar) && !TextUtils.isEmpty(((bi) vVar).sM())) {
                    biVar.needTopMargin = true;
                } else if (c(vVar2) && !TextUtils.isEmpty(sM)) {
                    biVar.needTopMargin = true;
                } else {
                    biVar.needTopMargin = false;
                }
            }
        }
    }

    private boolean c(com.baidu.adp.widget.ListView.v vVar) {
        if (vVar == null) {
            return false;
        }
        BdUniqueId type = vVar.getType();
        return type == bi.Ya || type == bi.Yb || type == bi.Yc || type == bi.Yf || type == bi.Yl || type == av.Xt || type == bi.Yj || type == bi.Yk;
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
                if (this.bRX != null && !this.bRX.containsValue(vVar)) {
                    this.bRX.put(Integer.valueOf(i2), (bi) vVar);
                }
            }
            i = i2 + 1;
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.a.am
    public void dV(boolean z) {
        if (this.bRZ != z) {
            this.bRZ = z;
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.a.am
    public HashMap<Integer, bi> abp() {
        return this.bRX;
    }

    @Override // com.baidu.tieba.frs.entelechy.a.am
    public void abq() {
        if (this.mListView != null && this.mListView.getData() != null && this.mListView.getData().size() != 0) {
            for (com.baidu.adp.widget.ListView.v vVar : this.mListView.getData()) {
                if ((vVar instanceof bi) && ((bi) vVar).sk() != 0) {
                    ((bi) vVar).sW();
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
                if (aVar instanceof com.baidu.tieba.frs.av) {
                    ((com.baidu.tieba.frs.av) aVar).setFromCDN(z);
                }
            }
            if (this.bRG != null) {
                this.bRG.setFromCDN(z);
            }
            if (this.bRH != null) {
                this.bRH.setFromCDN(z);
            }
            if (this.bRP != null) {
                this.bRP.setFromCDN(z);
            }
            if (this.bRQ != null) {
                this.bRQ.setFromCDN(z);
            }
        }
    }

    public void a(n nVar) {
        if (this.mAdapters != null && this.mAdapters.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.mAdapters) {
                if (aVar instanceof com.baidu.tieba.frs.av) {
                    ((com.baidu.tieba.frs.av) aVar).a(nVar);
                }
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.a.am
    public void a(at atVar) {
        if (this.mAdapters != null && this.mAdapters.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.mAdapters) {
                if (aVar instanceof com.baidu.tieba.frs.av) {
                    ((com.baidu.tieba.frs.av) aVar).a(atVar);
                }
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.a.am
    public int abr() {
        if (this.bRJ != null) {
            return w.h.frs_fortune_bag_item;
        }
        return 0;
    }

    @Override // com.baidu.tieba.frs.entelechy.a.am
    public int abs() {
        if (this.bRJ != null) {
            return w.h.frs_my_service_item;
        }
        return 0;
    }

    @Override // com.baidu.tieba.frs.entelechy.a.am
    public int abt() {
        if (this.bRJ != null) {
            return w.h.frs_bawu_center;
        }
        return 0;
    }

    @Override // com.baidu.tieba.frs.entelechy.a.am
    public int abu() {
        if (this.bRK != null) {
            return this.bRK.aav();
        }
        return 0;
    }

    @Override // com.baidu.tieba.frs.entelechy.a.am
    public int aaw() {
        if (this.bRK != null) {
            return this.bRK.aaw();
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
                if (aVar instanceof com.baidu.tieba.frs.av) {
                    ((com.baidu.tieba.frs.av) aVar).setOnAdapterItemClickListener(wVar);
                } else if ((aVar instanceof z) || (aVar instanceof i) || (aVar instanceof o) || (aVar instanceof k) || (aVar instanceof ak)) {
                    aVar.setOnAdapterItemClickListener(wVar);
                } else if (aVar != null && aVar.getType() == bi.Zi) {
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

    private void abv() {
        if (this.bRY != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.mAdapters) {
                if (aVar instanceof com.baidu.tieba.frs.e.e) {
                    com.baidu.tieba.frs.e.e eVar = (com.baidu.tieba.frs.e.e) aVar;
                    if (com.baidu.tieba.frs.e.e.bYW != null) {
                        if (this.bRY.ftt == 1) {
                            com.baidu.tieba.frs.e.e.bYW.bYM = true;
                        } else {
                            com.baidu.tieba.frs.e.e.bYW.bYM = false;
                        }
                        if (this.bRY.aJw() != null) {
                            com.baidu.tieba.frs.e.e.bYW.bYO = this.bRY.aJw().getId();
                        }
                        if (this.bOf != null && this.bOf.YU() != null) {
                            com.baidu.tieba.frs.e.e.bYW.bYN = this.bOf.YT().acR();
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
                if (aVar instanceof com.baidu.tieba.frs.av) {
                    ((com.baidu.tieba.frs.av) aVar).setOnAdapterItemLongClickListener(xVar);
                } else if ((aVar instanceof z) || (aVar instanceof i) || (aVar instanceof k) || (aVar instanceof o)) {
                    aVar.setOnAdapterItemLongClickListener(xVar);
                } else if (aVar != null && aVar.getType() == bi.Zi) {
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
                    if (!it.hasNext() || it.next().getType().getId() != bi.XZ.getId()) {
                        break;
                    }
                    i2 = i + 1;
                }
            }
            for (com.baidu.adp.widget.ListView.a aVar : this.mAdapters) {
                if (aVar instanceof com.baidu.tieba.frs.av) {
                    ((com.baidu.tieba.frs.av) aVar).hO(i);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aq(List<com.baidu.adp.widget.ListView.a> list) {
        if (list != null) {
            for (com.baidu.adp.widget.ListView.a aVar : list) {
                if (aVar instanceof com.baidu.tieba.frs.av) {
                    ((com.baidu.tieba.frs.av) aVar).a(this.bNZ);
                }
            }
        }
    }
}
