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
    private ArrayList<com.baidu.adp.widget.ListView.v> bFc;
    private FrsActivity bQw;
    private z bTX;
    private o bTY;
    private i bTZ;
    private com.baidu.adp.widget.ListView.a bUa;
    private bj bUb;
    private ak bUc;
    private s bUd;
    private com.baidu.adp.widget.ListView.a bUe;
    private com.baidu.adp.widget.ListView.a bUf;
    private k bUg;
    private k bUh;
    private bf bUi;
    private com.baidu.tieba.frs.h.a bUj;
    private List<com.baidu.adp.widget.ListView.a> bUk;
    private ad bUl;
    private w bUm;
    private u bUn;
    private final HashMap<Integer, bi> bUo;
    private n bUp;
    private BdTypeListView mListView;
    private List<com.baidu.adp.widget.ListView.a> mAdapters = new LinkedList();
    private boolean bUq = false;
    private CustomMessageListener bUr = new c(this, CmdConfigCustom.CMD_FRS_ADD_ADAPTER);
    private CustomMessageListener bUs = new d(this, CmdConfigCustom.CMD_LEGO_REGISTER);
    private CustomMessageListener amU = new e(this, CmdConfigCustom.CMD_UPDATE_ATTENTION);
    private CustomMessageListener mLikeForumListener = new f(this, CmdConfigCustom.CMD_LIKE_FORUM);
    private CustomMessageListener mUnlikeForumListener = new g(this, CmdConfigCustom.CMD_UNLIKE_FORUM);
    private CustomMessageListener bUt = new h(this, CmdConfigCustom.CMD_UPDATE_ADCARD);
    private final au bQq = new au();

    public b(FrsActivity frsActivity, BdTypeListView bdTypeListView, boolean z) {
        this.mListView = bdTypeListView;
        a(frsActivity, bdTypeListView);
        this.bUo = new HashMap<>();
        ef(z);
    }

    public void a(FrsActivity frsActivity, BdTypeListView bdTypeListView) {
        this.bQw = frsActivity;
        this.bTX = new z(frsActivity.getPageContext(), bi.Yb);
        this.bTY = new o(frsActivity.getPageContext(), bi.Yc);
        this.bUc = new ak(frsActivity.getPageContext(), bi.Yd);
        this.bUd = new s(frsActivity.getPageContext(), bi.Yg);
        this.bTZ = new i(frsActivity.getPageContext(), av.Xu);
        this.bUa = com.baidu.tieba.frs.c.ZN().a(frsActivity, com.baidu.tieba.tbadkCore.w.fwY, false);
        this.bUi = new bf(frsActivity, bg.bRh);
        this.bUb = new bj(frsActivity, aw.Xx);
        this.bUg = new k(frsActivity.getPageContext(), bi.Yk);
        this.bUh = new k(frsActivity.getPageContext(), bi.Yl);
        this.bUe = com.baidu.tieba.frs.c.ZN().a(frsActivity, bi.Zk, false);
        this.bUf = com.baidu.tieba.frs.c.ZN().b(frsActivity, bi.Zp);
        this.bUj = new com.baidu.tieba.frs.h.a(frsActivity, com.baidu.tbadk.core.data.z.VZ);
        this.bUl = new ad(frsActivity, bl.bRJ);
        this.bUm = new w(frsActivity.getPageContext(), bi.Ym);
        this.bUn = new u(frsActivity, CardHListViewData.TYPE);
        this.mAdapters.add(this.bUn);
        this.mAdapters.add(this.bTX);
        this.mAdapters.add(this.bTY);
        com.baidu.tieba.InjectPlugin.b.b bVar = new com.baidu.tieba.InjectPlugin.b.b(this.bQw.getPageContext(), 1);
        bVar.setExtraData(this.mAdapters);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_FEED_AD_PLUGIN_OPERATE, bVar));
        this.mAdapters.add(this.bTZ);
        this.mAdapters.add(this.bUm);
        if (this.bUa != null) {
            this.mAdapters.add(this.bUa);
        }
        this.mAdapters.add(this.bUi);
        this.mAdapters.add(this.bUc);
        this.mAdapters.add(this.bUd);
        this.mAdapters.add(this.bUb);
        this.mAdapters.add(this.bUg);
        this.mAdapters.add(this.bUh);
        this.mAdapters.add(new bs(frsActivity, bt.bSd));
        this.mAdapters.add(this.bUe);
        if (this.bUf != null) {
            this.mAdapters.add(this.bUf);
        }
        this.mAdapters.add(this.bUj);
        this.mAdapters.add(this.bUl);
        com.baidu.adp.widget.ListView.a<? extends bi, ? extends y.a> b = com.baidu.tieba.frs.c.ZN().b(frsActivity, bi.Zj);
        if (b != null) {
            this.mAdapters.add(b);
        }
        this.bUr.setPriority(1);
        this.bUr.setSelfListener(true);
        frsActivity.registerListener(this.bUr);
        frsActivity.registerListener(this.amU);
        frsActivity.registerListener(this.mLikeForumListener);
        frsActivity.registerListener(this.mUnlikeForumListener);
        frsActivity.registerListener(this.bUt);
        aco();
        CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_ADD_ADAPTER, new AbsDelegateAdapterList());
        CustomMessage customMessage = new CustomMessage(CmdConfigCustom.CMD_FRS_ADD_ADAPTER);
        customMessage.setTag(frsActivity.getUniqueId());
        customResponsedMessage.setOrginalMessage(customMessage);
        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
        ar(this.mAdapters);
        bdTypeListView.addAdapters(this.mAdapters);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void P(Object obj) {
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

    /* JADX INFO: Access modifiers changed from: private */
    public void Q(Object obj) {
        if (this.bFc != null) {
            Iterator<com.baidu.adp.widget.ListView.v> it = this.bFc.iterator();
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

    private void aco() {
        if (this.bQw != null && !acp()) {
            this.bQw.registerListener(this.bUs);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean acp() {
        if (this.bQw == null) {
            return false;
        }
        this.bUk = new ArrayList();
        ArrayList<BdUniqueId> biv = com.baidu.tieba.tbadkCore.t.biv();
        if (biv == null || biv.size() <= 0) {
            return false;
        }
        int size = biv.size();
        for (int i = 0; i < size; i++) {
            com.baidu.tieba.frs.av<ICardInfo, ? extends y.a> a = com.baidu.tieba.frs.c.ZN().a(this.bQw, biv.get(i));
            if (a != null) {
                this.mAdapters.add(a);
                this.bUk.add(a);
            }
        }
        if (!com.baidu.tbadk.core.util.x.q(this.bUk)) {
            this.mListView.addAdapters(this.bUk);
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
        this.bUp = nVar;
        acw();
        this.bFc = arrayList;
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
        return type == bi.Yb || type == bi.Yc || type == bi.Yd || type == bi.Yg || type == bi.Ym || type == av.Xu || type == bi.Yk || type == bi.Yl;
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
                if (this.bUo != null && !this.bUo.containsValue(vVar)) {
                    this.bUo.put(Integer.valueOf(i2), (bi) vVar);
                }
            }
            i = i2 + 1;
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.a.am
    public void ef(boolean z) {
        if (this.bUq != z) {
            this.bUq = z;
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.a.am
    public HashMap<Integer, bi> acq() {
        return this.bUo;
    }

    @Override // com.baidu.tieba.frs.entelechy.a.am
    public void acr() {
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
            if (this.bTX != null) {
                this.bTX.setFromCDN(z);
            }
            if (this.bTY != null) {
                this.bTY.setFromCDN(z);
            }
            if (this.bUg != null) {
                this.bUg.setFromCDN(z);
            }
            if (this.bUh != null) {
                this.bUh.setFromCDN(z);
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
    public int acs() {
        if (this.bUa != null) {
            return w.h.frs_fortune_bag_item;
        }
        return 0;
    }

    @Override // com.baidu.tieba.frs.entelechy.a.am
    public int act() {
        if (this.bUa != null) {
            return w.h.frs_my_service_item;
        }
        return 0;
    }

    @Override // com.baidu.tieba.frs.entelechy.a.am
    public int acu() {
        if (this.bUa != null) {
            return w.h.frs_bawu_center;
        }
        return 0;
    }

    @Override // com.baidu.tieba.frs.entelechy.a.am
    public int acv() {
        if (this.bUb != null) {
            return this.bUb.abw();
        }
        return 0;
    }

    @Override // com.baidu.tieba.frs.entelechy.a.am
    public int abx() {
        if (this.bUb != null) {
            return this.bUb.abx();
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
                } else if (aVar != null && aVar.getType() == bi.Zj) {
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

    private void acw() {
        if (this.bUp != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.mAdapters) {
                if (aVar instanceof com.baidu.tieba.frs.e.e) {
                    com.baidu.tieba.frs.e.e eVar = (com.baidu.tieba.frs.e.e) aVar;
                    if (com.baidu.tieba.frs.e.e.cbn != null) {
                        if (this.bUp.fvK == 1) {
                            com.baidu.tieba.frs.e.e.cbn.cbd = true;
                        } else {
                            com.baidu.tieba.frs.e.e.cbn.cbd = false;
                        }
                        if (this.bUp.aKx() != null) {
                            com.baidu.tieba.frs.e.e.cbn.cbf = this.bUp.aKx().getId();
                        }
                        if (this.bQw != null && this.bQw.ZV() != null) {
                            com.baidu.tieba.frs.e.e.cbn.cbe = this.bQw.ZU().adS();
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
                } else if (aVar != null && aVar.getType() == bi.Zj) {
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
                    if (!it.hasNext() || it.next().getType().getId() != bi.Ya.getId()) {
                        break;
                    }
                    i2 = i + 1;
                }
            }
            for (com.baidu.adp.widget.ListView.a aVar : this.mAdapters) {
                if (aVar instanceof com.baidu.tieba.frs.av) {
                    ((com.baidu.tieba.frs.av) aVar).hU(i);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ar(List<com.baidu.adp.widget.ListView.a> list) {
        if (list != null) {
            for (com.baidu.adp.widget.ListView.a aVar : list) {
                if (aVar instanceof com.baidu.tieba.frs.av) {
                    ((com.baidu.tieba.frs.av) aVar).a(this.bQq);
                }
            }
        }
    }
}
