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
import com.baidu.tbadk.core.data.bk;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.card.cb;
import com.baidu.tieba.card.data.CardHListViewData;
import com.baidu.tieba.frs.AbsDelegateAdapterList;
import com.baidu.tieba.frs.az;
import com.baidu.tieba.frs.ba;
import com.baidu.tieba.frs.bd;
import com.baidu.tieba.frs.bf;
import com.baidu.tieba.frs.bl;
import com.baidu.tieba.frs.bm;
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
    private ArrayList<com.baidu.adp.widget.ListView.v> aaS;
    private com.baidu.tieba.frs.r bPw;
    private z bRR;
    private o bRS;
    private i bRT;
    private com.baidu.adp.widget.ListView.a bRU;
    private bd bRV;
    private ak bRW;
    private s bRX;
    private com.baidu.adp.widget.ListView.a bRY;
    private com.baidu.adp.widget.ListView.a bRZ;
    private k bSa;
    private k bSb;
    private az bSc;
    private com.baidu.tieba.frs.f.a bSd;
    private List<com.baidu.adp.widget.ListView.a> bSe;
    private ad bSf;
    private w bSg;
    private u bSh;
    private final HashMap<Integer, bk> bSi;
    private n bSj;
    private BdTypeListView mListView;
    private List<com.baidu.adp.widget.ListView.a> mAdapters = new LinkedList();
    private boolean bSk = false;
    private CustomMessageListener bSl = new c(this, CmdConfigCustom.CMD_FRS_ADD_ADAPTER);
    private CustomMessageListener bSm = new d(this, CmdConfigCustom.CMD_LEGO_REGISTER);
    private CustomMessageListener amZ = new e(this, CmdConfigCustom.CMD_UPDATE_ATTENTION);
    private CustomMessageListener mLikeForumListener = new f(this, CmdConfigCustom.CMD_LIKE_FORUM);
    private CustomMessageListener mUnlikeForumListener = new g(this, CmdConfigCustom.CMD_UNLIKE_FORUM);
    private CustomMessageListener bSn = new h(this, CmdConfigCustom.CMD_UPDATE_ADCARD);
    private final com.baidu.tieba.frs.o bNX = new com.baidu.tieba.frs.o();

    public b(com.baidu.tieba.frs.r rVar, BdTypeListView bdTypeListView, boolean z) {
        this.mListView = bdTypeListView;
        a(rVar, bdTypeListView);
        this.bSi = new HashMap<>();
        dW(z);
    }

    public void a(com.baidu.tieba.frs.r rVar, BdTypeListView bdTypeListView) {
        this.bPw = rVar;
        this.bRR = new z(rVar.getPageContext(), bk.Xt, this.bPw.getUniqueId());
        this.bRR.setVoiceManager(rVar.getVoiceManager());
        this.bRS = new o(rVar.getPageContext(), bk.Xu, this.bPw.getUniqueId());
        this.bRW = new ak(rVar.getPageContext(), bk.Xv, this.bPw.getUniqueId());
        this.bRX = new s(rVar.getPageContext(), bk.Xy, this.bPw.getUniqueId());
        this.bRT = new i(rVar.getPageContext(), aw.WM, this.bPw.getUniqueId());
        this.bRU = com.baidu.tieba.frs.c.YE().a(rVar.getPageContext(), com.baidu.tieba.tbadkCore.u.ftd, this.bPw.getUniqueId(), false);
        this.bSc = new az(rVar.getPageContext(), ba.bPY);
        this.bRV = new bd(rVar.getPageContext(), ax.WP);
        this.bSa = new k(rVar.getPageContext(), bk.XC, this.bPw.getUniqueId());
        this.bSb = new k(rVar.getPageContext(), bk.XD, this.bPw.getUniqueId());
        this.bRY = com.baidu.tieba.frs.c.YE().a(rVar.getPageContext(), bk.YC, this.bPw.getUniqueId(), false);
        this.bRZ = com.baidu.tieba.frs.c.YE().b(rVar.getPageContext(), bk.YH, this.bPw.getUniqueId());
        this.bSd = new com.baidu.tieba.frs.f.a(rVar.getPageContext(), com.baidu.tbadk.core.data.z.Vs, this.bPw.getUniqueId());
        this.bSf = new ad(rVar.getPageContext(), bf.bQA);
        this.bSg = new w(rVar.getPageContext(), bk.XE, this.bPw.getUniqueId());
        this.bSh = new u(rVar.getPageContext(), CardHListViewData.TYPE);
        this.mAdapters.add(this.bSh);
        this.mAdapters.add(this.bRR);
        this.mAdapters.add(this.bRS);
        com.baidu.tieba.InjectPlugin.b.b bVar = new com.baidu.tieba.InjectPlugin.b.b(this.bPw.getPageContext(), 1);
        bVar.setExtraData(this.mAdapters);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_FEED_AD_PLUGIN_OPERATE, bVar));
        this.mAdapters.add(this.bRT);
        this.mAdapters.add(this.bSg);
        if (this.bRU != null) {
            this.mAdapters.add(this.bRU);
        }
        this.mAdapters.add(this.bSc);
        this.mAdapters.add(this.bRW);
        this.mAdapters.add(this.bRX);
        this.mAdapters.add(this.bRV);
        this.mAdapters.add(this.bSa);
        this.mAdapters.add(this.bSb);
        this.mAdapters.add(new bl(this.bPw.getPageContext(), bm.bQP));
        this.mAdapters.add(this.bRY);
        if (this.bRZ != null) {
            this.mAdapters.add(this.bRZ);
        }
        this.mAdapters.add(this.bSd);
        this.mAdapters.add(this.bSf);
        com.baidu.adp.widget.ListView.a<? extends bk, ? extends y.a> b = com.baidu.tieba.frs.c.YE().b(this.bPw.getPageContext(), bk.YB, this.bPw.getUniqueId());
        if (b != null) {
            this.mAdapters.add(b);
        }
        this.bSl.setPriority(1);
        this.bSl.setSelfListener(true);
        this.bPw.registerListener(this.bSl);
        this.bPw.registerListener(this.amZ);
        this.bPw.registerListener(this.mLikeForumListener);
        this.bPw.registerListener(this.mUnlikeForumListener);
        this.bPw.registerListener(this.bSn);
        aaA();
        CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_ADD_ADAPTER, new AbsDelegateAdapterList());
        CustomMessage customMessage = new CustomMessage(CmdConfigCustom.CMD_FRS_ADD_ADAPTER);
        customMessage.setTag(this.bPw.getUniqueId());
        customResponsedMessage.setOrginalMessage(customMessage);
        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
        an(this.mAdapters);
        bdTypeListView.addAdapters(this.mAdapters);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void P(Object obj) {
        if (this.aaS != null) {
            Iterator<com.baidu.adp.widget.ListView.v> it = this.aaS.iterator();
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
    public void Q(Object obj) {
        if (this.aaS != null) {
            Iterator<com.baidu.adp.widget.ListView.v> it = this.aaS.iterator();
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

    private void aaA() {
        if (this.bPw != null && !aaB()) {
            this.bPw.registerListener(this.bSm);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aaB() {
        if (this.bPw == null) {
            return false;
        }
        this.bSe = new ArrayList();
        ArrayList<BdUniqueId> bfT = com.baidu.tieba.tbadkCore.s.bfT();
        if (bfT == null || bfT.size() <= 0) {
            return false;
        }
        int size = bfT.size();
        for (int i = 0; i < size; i++) {
            com.baidu.tieba.frs.p<ICardInfo, ? extends y.a> a = com.baidu.tieba.frs.c.YE().a(this.bPw.getPageContext(), bfT.get(i), this.bPw.getUniqueId());
            if (a != null) {
                this.mAdapters.add(a);
                this.bSe.add(a);
            }
        }
        if (!com.baidu.tbadk.core.util.x.r(this.bSe)) {
            this.mListView.addAdapters(this.bSe);
        }
        return true;
    }

    @Override // com.baidu.tieba.frs.entelechy.a.am
    public void onDestory() {
        for (com.baidu.adp.widget.ListView.a aVar : this.mAdapters) {
            if (aVar instanceof com.baidu.tieba.frs.p) {
                ((com.baidu.tieba.frs.p) aVar).release();
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.a.am
    public void b(ArrayList<com.baidu.adp.widget.ListView.v> arrayList, n nVar) {
        a(nVar);
        com.baidu.tieba.tbadkCore.s.r(arrayList, 1);
        G(arrayList);
        H(arrayList);
        F(arrayList);
        this.mListView.setData(arrayList);
        this.bSj = nVar;
        aaI();
        this.aaS = arrayList;
    }

    private void F(ArrayList<com.baidu.adp.widget.ListView.v> arrayList) {
        int q = com.baidu.tbadk.core.util.x.q(arrayList);
        for (int i = 0; i < q; i++) {
            com.baidu.adp.widget.ListView.v vVar = (com.baidu.adp.widget.ListView.v) com.baidu.tbadk.core.util.x.c(arrayList, i - 1);
            com.baidu.adp.widget.ListView.v vVar2 = (com.baidu.adp.widget.ListView.v) com.baidu.tbadk.core.util.x.c(arrayList, i);
            if (vVar2 instanceof bk) {
                bk bkVar = (bk) vVar2;
                if (i == 0) {
                    bkVar.isFirstFloor = true;
                } else {
                    bkVar.isFirstFloor = false;
                }
                String rW = bkVar.rW();
                if (vVar instanceof bf) {
                    bkVar.needTopMargin = false;
                } else if (vVar != null && !c(vVar)) {
                    bkVar.needTopMargin = false;
                } else if ((vVar instanceof bk) && c(vVar) && !TextUtils.isEmpty(((bk) vVar).rW())) {
                    bkVar.needTopMargin = true;
                } else if (c(vVar2) && !TextUtils.isEmpty(rW)) {
                    bkVar.needTopMargin = true;
                } else {
                    bkVar.needTopMargin = false;
                }
            }
        }
    }

    private boolean c(com.baidu.adp.widget.ListView.v vVar) {
        if (vVar == null) {
            return false;
        }
        BdUniqueId type = vVar.getType();
        return type == bk.Xt || type == bk.Xu || type == bk.Xv || type == bk.Xy || type == bk.XE || type == aw.WM || type == bk.XC || type == bk.XD;
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
                if (this.bSi != null && !this.bSi.containsValue(vVar)) {
                    this.bSi.put(Integer.valueOf(i2), (bk) vVar);
                }
            }
            i = i2 + 1;
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.a.am
    public void dW(boolean z) {
        if (this.bSk != z) {
            this.bSk = z;
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.a.am
    public HashMap<Integer, bk> aaC() {
        return this.bSi;
    }

    @Override // com.baidu.tieba.frs.entelechy.a.am
    public void aaD() {
        if (this.mListView != null && this.mListView.getData() != null && this.mListView.getData().size() != 0) {
            for (com.baidu.adp.widget.ListView.v vVar : this.mListView.getData()) {
                if ((vVar instanceof bk) && ((bk) vVar).ru() != 0) {
                    ((bk) vVar).sg();
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
                if (aVar instanceof com.baidu.tieba.frs.p) {
                    ((com.baidu.tieba.frs.p) aVar).setFromCDN(z);
                }
            }
            if (this.bRR != null) {
                this.bRR.setFromCDN(z);
            }
            if (this.bRS != null) {
                this.bRS.setFromCDN(z);
            }
            if (this.bSa != null) {
                this.bSa.setFromCDN(z);
            }
            if (this.bSb != null) {
                this.bSb.setFromCDN(z);
            }
        }
    }

    public void a(n nVar) {
        if (this.mAdapters != null && this.mAdapters.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.mAdapters) {
                if (aVar instanceof com.baidu.tieba.frs.p) {
                    ((com.baidu.tieba.frs.p) aVar).a(nVar);
                }
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.a.am
    public void a(com.baidu.tieba.frs.n nVar) {
        if (this.mAdapters != null && this.mAdapters.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.mAdapters) {
                if (aVar instanceof com.baidu.tieba.frs.p) {
                    ((com.baidu.tieba.frs.p) aVar).a(nVar);
                }
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.a.am
    public int aaE() {
        if (this.bRU != null) {
            return w.h.frs_fortune_bag_item;
        }
        return 0;
    }

    @Override // com.baidu.tieba.frs.entelechy.a.am
    public int aaF() {
        if (this.bRU != null) {
            return w.h.frs_my_service_item;
        }
        return 0;
    }

    @Override // com.baidu.tieba.frs.entelechy.a.am
    public int aaG() {
        if (this.bRU != null) {
            return w.h.frs_bawu_center;
        }
        return 0;
    }

    @Override // com.baidu.tieba.frs.entelechy.a.am
    public int aaH() {
        if (this.bRV != null) {
            return this.bRV.ZY();
        }
        return 0;
    }

    @Override // com.baidu.tieba.frs.entelechy.a.am
    public int ZZ() {
        if (this.bRV != null) {
            return this.bRV.ZZ();
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
                if (aVar instanceof com.baidu.tieba.frs.p) {
                    ((com.baidu.tieba.frs.p) aVar).setOnAdapterItemClickListener(wVar);
                } else if ((aVar instanceof z) || (aVar instanceof i) || (aVar instanceof o) || (aVar instanceof k) || (aVar instanceof ak)) {
                    aVar.setOnAdapterItemClickListener(wVar);
                } else if (aVar != null && aVar.getType() == bk.YB) {
                    aVar.setOnAdapterItemClickListener(wVar);
                }
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.a.am
    public void setForumName(String str) {
        if (this.mAdapters != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.mAdapters) {
                if (aVar instanceof cb) {
                    ((cb) aVar).setForumName(str);
                }
            }
        }
    }

    private void aaI() {
        if (this.bSj != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.mAdapters) {
                if (aVar instanceof com.baidu.tieba.frs.c.e) {
                    com.baidu.tieba.frs.c.e eVar = (com.baidu.tieba.frs.c.e) aVar;
                    if (com.baidu.tieba.frs.c.e.bZb != null) {
                        if (this.bSj.frQ == 1) {
                            com.baidu.tieba.frs.c.e.bZb.bYR = true;
                        } else {
                            com.baidu.tieba.frs.c.e.bZb.bYR = false;
                        }
                        if (this.bSj.aHE() != null) {
                            com.baidu.tieba.frs.c.e.bZb.bYT = this.bSj.aHE().getId();
                        }
                        if (this.bPw != null && this.bPw.YU() != null) {
                            com.baidu.tieba.frs.c.e.bZb.bYS = this.bPw.YU().abW();
                        }
                    }
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
                    if (!it.hasNext() || it.next().getType().getId() != bk.Xs.getId()) {
                        break;
                    }
                    i2 = i + 1;
                }
            }
            for (com.baidu.adp.widget.ListView.a aVar : this.mAdapters) {
                if (aVar instanceof com.baidu.tieba.frs.p) {
                    ((com.baidu.tieba.frs.p) aVar).hG(i);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void an(List<com.baidu.adp.widget.ListView.a> list) {
        if (list != null) {
            for (com.baidu.adp.widget.ListView.a aVar : list) {
                if (aVar instanceof com.baidu.tieba.frs.p) {
                    ((com.baidu.tieba.frs.p) aVar).a(this.bNX);
                }
            }
        }
    }
}
