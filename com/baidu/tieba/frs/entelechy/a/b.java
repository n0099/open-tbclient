package com.baidu.tieba.frs.entelechy.a;

import android.text.TextUtils;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.adp.widget.ListView.j;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.data.av;
import com.baidu.tbadk.core.data.aw;
import com.baidu.tbadk.core.data.bh;
import com.baidu.tbadk.core.data.z;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.coreExtra.message.UpdateAttentionMessage;
import com.baidu.tieba.card.data.CardHListViewData;
import com.baidu.tieba.d;
import com.baidu.tieba.frs.AbsDelegateAdapterList;
import com.baidu.tieba.frs.k;
import com.baidu.tieba.frs.n;
import com.baidu.tieba.frs.w;
import com.baidu.tieba.lego.card.model.ICardInfo;
import com.baidu.tieba.tbadkCore.o;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public class b implements t {
    private ArrayList<com.baidu.adp.widget.ListView.f> acj;
    private l cDe;
    private j cDf;
    private l cDg;
    private c cDh;
    private com.baidu.adp.widget.ListView.a cDi;
    private n cDj;
    private s cDk;
    private g cDl;
    private com.baidu.adp.widget.ListView.a cDm;
    private com.baidu.adp.widget.ListView.a cDn;
    private d cDo;
    private d cDp;
    private com.baidu.tieba.frs.j cDq;
    private com.baidu.tieba.frs.h.a cDr;
    private List<com.baidu.adp.widget.ListView.a> cDs;
    private m cDt;
    private i cDu;
    private h cDv;
    private p cDw;
    private q cDx;
    private final HashMap<Integer, bh> cDy;
    private com.baidu.tieba.tbadkCore.j cDz;
    private com.baidu.tieba.frs.f cyR;
    private BdTypeListView mListView;
    private List<com.baidu.adp.widget.ListView.a> mAdapters = new LinkedList();
    private boolean cDA = false;
    private CustomMessageListener cDB = new CustomMessageListener(CmdConfigCustom.CMD_FRS_ADD_ADAPTER) { // from class: com.baidu.tieba.frs.entelechy.a.b.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2003008 && (customResponsedMessage.getData() instanceof AbsDelegateAdapterList)) {
                AbsDelegateAdapterList absDelegateAdapterList = (AbsDelegateAdapterList) customResponsedMessage.getData();
                Iterator it = absDelegateAdapterList.iterator();
                while (it.hasNext()) {
                    com.baidu.adp.widget.ListView.a aVar = (com.baidu.adp.widget.ListView.a) it.next();
                    if (aVar instanceof com.baidu.tieba.frs.d) {
                        ((com.baidu.tieba.frs.d) aVar).a(b.this.cyR.getPageContext(), b.this.cyR.getUniqueId());
                    }
                }
                ArrayList arrayList = new ArrayList();
                arrayList.addAll(absDelegateAdapterList);
                b.this.aN(arrayList);
                if (b.this.mAdapters != null) {
                    b.this.mAdapters.addAll(absDelegateAdapterList);
                }
                if (b.this.mListView != null) {
                    b.this.mAdapters.addAll(arrayList);
                    b.this.mListView.addAdapters(arrayList);
                }
            }
        }
    };
    private CustomMessageListener cDC = new CustomMessageListener(CmdConfigCustom.CMD_LEGO_REGISTER) { // from class: com.baidu.tieba.frs.entelechy.a.b.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && v.v(b.this.cDs)) {
                b.this.alj();
                b.this.b(b.this.acj, b.this.cDz);
            }
        }
    };
    private CustomMessageListener mAttentionListener = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.frs.entelechy.a.b.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
            if (updateAttentionMessage != null && updateAttentionMessage.getData() != null && updateAttentionMessage.getData().BJ) {
                b.this.S(updateAttentionMessage.getData());
            }
        }
    };
    private CustomMessageListener mLikeForumListener = new CustomMessageListener(CmdConfigCustom.CMD_LIKE_FORUM) { // from class: com.baidu.tieba.frs.entelechy.a.b.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                com.baidu.tieba.lego.c.b bVar = new com.baidu.tieba.lego.c.b();
                bVar.fid = String.valueOf(customResponsedMessage.getData());
                bVar.efp = true;
                b.this.S(bVar);
            }
        }
    };
    private CustomMessageListener mUnlikeForumListener = new CustomMessageListener(CmdConfigCustom.CMD_UNLIKE_FORUM) { // from class: com.baidu.tieba.frs.entelechy.a.b.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                com.baidu.tieba.lego.c.b bVar = new com.baidu.tieba.lego.c.b();
                bVar.fid = String.valueOf(customResponsedMessage.getData());
                bVar.efp = false;
                b.this.S(bVar);
            }
        }
    };
    private CustomMessageListener cDD = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ADCARD) { // from class: com.baidu.tieba.frs.entelechy.a.b.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.data.j)) {
                b.this.T((com.baidu.tbadk.data.j) customResponsedMessage.getData());
            }
        }
    };
    private final com.baidu.tieba.frs.c cxk = new com.baidu.tieba.frs.c();

    public b(com.baidu.tieba.frs.f fVar, BdTypeListView bdTypeListView, boolean z) {
        this.mListView = bdTypeListView;
        a(fVar, bdTypeListView);
        this.cDy = new HashMap<>();
        eM(z);
    }

    public void a(com.baidu.tieba.frs.f fVar, BdTypeListView bdTypeListView) {
        this.cyR = fVar;
        this.cDe = new l(fVar.getPageContext(), bh.Yo, this.cyR.getUniqueId());
        this.cDe.setVoiceManager(fVar.getVoiceManager());
        this.cDf = new j(fVar.getPageContext(), bh.Yp, this.cyR.getUniqueId());
        this.cDg = new l(fVar.getPageContext(), bh.Yq, this.cyR.getUniqueId());
        this.cDg.setVoiceManager(fVar.getVoiceManager());
        this.cDk = new s(fVar.getPageContext(), bh.Yr, this.cyR.getUniqueId());
        this.cDl = new g(fVar.getPageContext(), bh.Yv, this.cyR.getUniqueId());
        this.cDh = new c(fVar.getPageContext(), av.XL, this.cyR.getUniqueId());
        this.cDi = com.baidu.tieba.frs.a.aiz().a(fVar.getPageContext(), com.baidu.tieba.tbadkCore.q.goc, this.cyR.getUniqueId(), false);
        this.cDq = new com.baidu.tieba.frs.j(fVar.getPageContext(), k.czy);
        this.cDj = new n(fVar.getPageContext(), aw.XO);
        this.cDo = new d(fVar.getPageContext(), bh.Yz, this.cyR.getUniqueId());
        this.cDp = new d(fVar.getPageContext(), bh.YA, this.cyR.getUniqueId());
        this.cDm = com.baidu.tieba.frs.a.aiz().a(fVar.getPageContext(), bh.ZB, this.cyR.getUniqueId(), true);
        this.cDn = com.baidu.tieba.frs.a.aiz().b(fVar.getPageContext(), bh.ZG, this.cyR.getUniqueId());
        this.cDr = new com.baidu.tieba.frs.h.a(fVar.getPageContext(), z.Wx, this.cyR.getUniqueId());
        this.cDt = new m(fVar.getPageContext(), com.baidu.tieba.frs.p.cAa);
        this.cDu = new i(fVar.getPageContext(), bh.YB, this.cyR.getUniqueId());
        this.cDv = new h(fVar.getPageContext(), CardHListViewData.TYPE);
        this.cDw = new p(fVar.getPageContext(), com.baidu.tieba.frs.q.cAg, this.cyR.getUniqueId());
        this.cDx = new q(fVar.getPageContext().getPageActivity(), com.baidu.tieba.tbadkCore.i.gnR, this.cyR.getUniqueId());
        this.mAdapters.add(this.cDx);
        this.mAdapters.add(this.cDv);
        this.mAdapters.add(this.cDe);
        this.mAdapters.add(this.cDf);
        this.mAdapters.add(this.cDg);
        this.mAdapters.add(this.cDw);
        com.baidu.tieba.InjectPlugin.b.b bVar = new com.baidu.tieba.InjectPlugin.b.b(this.cyR, 1);
        bVar.setExtraData(this.mAdapters);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_FEED_AD_PLUGIN_OPERATE, bVar));
        this.mAdapters.add(this.cDh);
        this.mAdapters.add(this.cDu);
        if (this.cDi != null) {
            this.mAdapters.add(this.cDi);
        }
        this.mAdapters.add(this.cDq);
        this.mAdapters.add(this.cDk);
        this.mAdapters.add(this.cDl);
        this.mAdapters.add(this.cDj);
        this.mAdapters.add(this.cDo);
        this.mAdapters.add(this.cDp);
        this.mAdapters.add(new com.baidu.tieba.frs.v(this.cyR.getPageContext(), w.cAu));
        this.mAdapters.add(this.cDm);
        if (this.cDn != null) {
            this.mAdapters.add(this.cDn);
        }
        this.mAdapters.add(this.cDr);
        this.mAdapters.add(this.cDt);
        com.baidu.adp.widget.ListView.a<? extends bh, ? extends j.a> b = com.baidu.tieba.frs.a.aiz().b(this.cyR.getPageContext(), bh.ZA, this.cyR.getUniqueId());
        if (b != null) {
            this.mAdapters.add(b);
        }
        this.cDB.setPriority(1);
        this.cDB.setSelfListener(true);
        this.cyR.registerListener(this.cDB);
        this.cyR.registerListener(this.mAttentionListener);
        this.cyR.registerListener(this.mLikeForumListener);
        this.cyR.registerListener(this.mUnlikeForumListener);
        this.cyR.registerListener(this.cDD);
        ali();
        CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_ADD_ADAPTER, new AbsDelegateAdapterList());
        CustomMessage customMessage = new CustomMessage(CmdConfigCustom.CMD_FRS_ADD_ADAPTER);
        customMessage.setTag(this.cyR.getUniqueId());
        customResponsedMessage.setOrginalMessage(customMessage);
        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
        aN(this.mAdapters);
        bdTypeListView.addAdapters(this.mAdapters);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void S(Object obj) {
        boolean z;
        boolean z2 = false;
        if (this.acj != null) {
            Iterator<com.baidu.adp.widget.ListView.f> it = this.acj.iterator();
            while (true) {
                z = z2;
                if (!it.hasNext()) {
                    break;
                }
                com.baidu.adp.widget.ListView.f next = it.next();
                if ((next instanceof ICardInfo) && ((ICardInfo) next).responseAttention(obj)) {
                    z = true;
                }
                z2 = z;
            }
            if (z) {
                notifyDataSetChanged();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void T(Object obj) {
        if (this.acj != null) {
            Iterator<com.baidu.adp.widget.ListView.f> it = this.acj.iterator();
            while (it.hasNext()) {
                com.baidu.adp.widget.ListView.f next = it.next();
                if (next instanceof AdvertAppInfo) {
                    AdvertAppInfo advertAppInfo = (AdvertAppInfo) next;
                    if (advertAppInfo.legoCard != null) {
                        advertAppInfo.legoCard.refreshReservation(obj);
                    }
                }
            }
        }
    }

    private void ali() {
        if (this.cyR != null && !alj()) {
            this.cyR.registerListener(this.cDC);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean alj() {
        if (this.cyR == null) {
            return false;
        }
        this.cDs = new ArrayList();
        ArrayList<BdUniqueId> btF = o.btF();
        if (btF == null || btF.size() <= 0) {
            return false;
        }
        int size = btF.size();
        for (int i = 0; i < size; i++) {
            com.baidu.tieba.frs.d<ICardInfo, ? extends j.a> a = com.baidu.tieba.frs.a.aiz().a(this.cyR.getPageContext(), btF.get(i), this.cyR.getUniqueId());
            if (a != null) {
                this.mAdapters.add(a);
                this.cDs.add(a);
            }
        }
        if (!v.v(this.cDs)) {
            this.mListView.addAdapters(this.cDs);
        }
        return true;
    }

    @Override // com.baidu.tieba.frs.entelechy.a.t
    public void onDestory() {
        for (com.baidu.adp.widget.ListView.a aVar : this.mAdapters) {
            if (aVar instanceof com.baidu.tieba.frs.d) {
                ((com.baidu.tieba.frs.d) aVar).release();
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.a.t
    public void b(ArrayList<com.baidu.adp.widget.ListView.f> arrayList, com.baidu.tieba.tbadkCore.j jVar) {
        a(jVar);
        o.p(arrayList, 1);
        J(arrayList);
        K(arrayList);
        I(arrayList);
        this.mListView.setData(arrayList);
        this.cDz = jVar;
        als();
        alk();
        this.acj = arrayList;
    }

    private void alk() {
        if (this.cDz != null && this.cDz.aPM() != null && !StringUtils.isNull(this.cDz.aPM().getId()) && this.cDx != null) {
            this.cDx.setForumId(this.cDz.aPM().getId());
        }
    }

    private void I(ArrayList<com.baidu.adp.widget.ListView.f> arrayList) {
        int u = v.u(arrayList);
        for (int i = 0; i < u; i++) {
            com.baidu.adp.widget.ListView.f fVar = (com.baidu.adp.widget.ListView.f) v.c(arrayList, i - 1);
            com.baidu.adp.widget.ListView.f fVar2 = (com.baidu.adp.widget.ListView.f) v.c(arrayList, i);
            if (fVar2 instanceof bh) {
                bh bhVar = (bh) fVar2;
                if (i == 0) {
                    bhVar.isFirstFloor = true;
                } else {
                    bhVar.isFirstFloor = false;
                }
                String rS = bhVar.rS();
                if (fVar instanceof com.baidu.tieba.frs.p) {
                    bhVar.needTopMargin = false;
                } else if (fVar != null && !e(fVar)) {
                    bhVar.needTopMargin = false;
                } else if ((fVar instanceof bh) && e(fVar) && !TextUtils.isEmpty(((bh) fVar).rS())) {
                    bhVar.needTopMargin = true;
                } else if (e(fVar2) && !TextUtils.isEmpty(rS)) {
                    bhVar.needTopMargin = true;
                } else {
                    bhVar.needTopMargin = false;
                }
            }
        }
    }

    private boolean e(com.baidu.adp.widget.ListView.f fVar) {
        if (fVar == null) {
            return false;
        }
        BdUniqueId type = fVar.getType();
        return type == bh.Yo || type == bh.Yq || type == bh.Yr || type == bh.Yv || type == bh.YB || type == av.XL || type == bh.Yz || type == bh.YA;
    }

    private ArrayList<Integer> J(ArrayList<com.baidu.adp.widget.ListView.f> arrayList) {
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
            com.baidu.adp.widget.ListView.f fVar = arrayList.get(i2);
            if (fVar instanceof AdvertAppInfo) {
                arrayList2.add(Integer.valueOf(i2));
                if (this.cDy != null && !this.cDy.containsValue(fVar)) {
                    this.cDy.put(Integer.valueOf(i2), (bh) fVar);
                }
            }
            i = i2 + 1;
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.a.t
    public void eM(boolean z) {
        if (this.cDA != z) {
            this.cDA = z;
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.a.t
    public HashMap<Integer, bh> all() {
        return this.cDy;
    }

    @Override // com.baidu.tieba.frs.entelechy.a.t
    public void alm() {
        if (this.mListView != null && this.mListView.getData() != null && this.mListView.getData().size() != 0) {
            for (com.baidu.adp.widget.ListView.f fVar : this.mListView.getData()) {
                if ((fVar instanceof bh) && ((bh) fVar).ro() != 0) {
                    ((bh) fVar).sc();
                }
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.a.t
    public void notifyDataSetChanged() {
        if (this.mListView.getAdapter() instanceof com.baidu.adp.widget.ListView.d) {
            ((com.baidu.adp.widget.ListView.d) this.mListView.getAdapter()).notifyDataSetChanged();
        }
    }

    public void abb() {
        if (this.mListView.getAdapter() instanceof com.baidu.adp.widget.ListView.d) {
            if (this.acj != null) {
                this.mListView.setData(this.acj);
            }
            ((com.baidu.adp.widget.ListView.d) this.mListView.getAdapter()).notifyDataSetChanged();
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.a.t
    public void setFromCDN(boolean z) {
        if (this.mAdapters != null && this.mAdapters.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.mAdapters) {
                if (aVar instanceof com.baidu.tieba.frs.d) {
                    ((com.baidu.tieba.frs.d) aVar).setFromCDN(z);
                }
            }
            if (this.cDe != null) {
                this.cDe.setFromCDN(z);
            }
            if (this.cDg != null) {
                this.cDg.setFromCDN(z);
            }
            if (this.cDo != null) {
                this.cDo.setFromCDN(z);
            }
            if (this.cDp != null) {
                this.cDp.setFromCDN(z);
            }
        }
    }

    public void a(com.baidu.tieba.tbadkCore.j jVar) {
        if (this.mAdapters != null && this.mAdapters.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.mAdapters) {
                if (aVar instanceof com.baidu.tieba.frs.d) {
                    ((com.baidu.tieba.frs.d) aVar).a(jVar);
                }
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.a.t
    public void a(com.baidu.tieba.frs.b bVar) {
        if (this.mAdapters != null && this.mAdapters.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.mAdapters) {
                if (aVar instanceof com.baidu.tieba.frs.d) {
                    ((com.baidu.tieba.frs.d) aVar).a(bVar);
                }
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.a.t
    public int aln() {
        if (this.cDi != null) {
            return d.g.frs_fortune_bag_item;
        }
        return 0;
    }

    @Override // com.baidu.tieba.frs.entelechy.a.t
    public int alo() {
        if (this.cDi != null) {
            return d.g.frs_my_service_item;
        }
        return 0;
    }

    @Override // com.baidu.tieba.frs.entelechy.a.t
    public int alp() {
        if (this.cDi != null) {
            return d.g.frs_bawu_center;
        }
        return 0;
    }

    @Override // com.baidu.tieba.frs.entelechy.a.t
    public int alq() {
        if (this.cDj != null) {
            return this.cDj.ajZ();
        }
        return 0;
    }

    @Override // com.baidu.tieba.frs.entelechy.a.t
    public int aka() {
        if (this.cDj != null) {
            return this.cDj.aka();
        }
        return 0;
    }

    @Override // com.baidu.tieba.frs.entelechy.a.t
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

    @Override // com.baidu.tieba.frs.entelechy.a.t
    public void setOnAdapterItemClickListener(com.baidu.adp.widget.ListView.h hVar) {
        if (this.mAdapters != null && this.mAdapters.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.mAdapters) {
                if (aVar instanceof com.baidu.tieba.frs.d) {
                    ((com.baidu.tieba.frs.d) aVar).setOnAdapterItemClickListener(hVar);
                } else if ((aVar instanceof l) || (aVar instanceof c) || (aVar instanceof f) || (aVar instanceof d) || (aVar instanceof s)) {
                    aVar.setOnAdapterItemClickListener(hVar);
                } else if (aVar != null && aVar.getType() == bh.ZA) {
                    aVar.setOnAdapterItemClickListener(hVar);
                }
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.a.t
    public void setForumName(String str) {
        if (this.mAdapters != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.mAdapters) {
                if (aVar instanceof com.baidu.tieba.card.v) {
                    ((com.baidu.tieba.card.v) aVar).setForumName(str);
                }
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.a.t
    public void cD(boolean z) {
        if (this.mAdapters != null && this.mAdapters.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.mAdapters) {
                if (aVar instanceof com.baidu.tieba.frs.d) {
                    ((com.baidu.tieba.frs.d) aVar).cD(z);
                }
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.a.t
    public void alr() {
        if (this.mAdapters != null && this.mAdapters.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.mAdapters) {
                if (aVar instanceof com.baidu.tieba.frs.d) {
                    ((com.baidu.tieba.frs.d) aVar).a(this.cyR.getPageContext(), this.cyR.getUniqueId());
                }
            }
            aN(this.mAdapters);
        }
    }

    private void als() {
        if (this.cDz != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.mAdapters) {
                if (aVar instanceof com.baidu.tieba.frs.e.c) {
                    com.baidu.tieba.frs.e.c cVar = (com.baidu.tieba.frs.e.c) aVar;
                    if (com.baidu.tieba.frs.e.c.cPd != null) {
                        if (this.cDz.gmI == 1) {
                            com.baidu.tieba.frs.e.c.cPd.cOT = true;
                        } else {
                            com.baidu.tieba.frs.e.c.cPd.cOT = false;
                        }
                        if (this.cDz.aPM() != null) {
                            com.baidu.tieba.frs.e.c.cPd.cOV = this.cDz.aPM().getId();
                        }
                        if (this.cyR != null && this.cyR.aiR() != null) {
                            com.baidu.tieba.frs.e.c.cPd.cOU = this.cyR.aiR().anJ();
                        }
                    }
                }
            }
            alt();
        }
    }

    private void alt() {
        com.baidu.tieba.frs.e.a aVar = new com.baidu.tieba.frs.e.a();
        if (this.cDz.gmI == 1) {
            aVar.cOT = true;
        } else {
            aVar.cOT = false;
        }
        if (this.cDz.aPM() != null) {
            aVar.cOV = this.cDz.aPM().getId();
        }
        if (this.cyR != null && this.cyR.aiR() != null) {
            aVar.cOU = this.cyR.aiR().anJ();
        }
        com.baidu.tieba.frs.live.b bVar = new com.baidu.tieba.frs.live.b(aVar);
        CustomMessageTask customMessageTask = new CustomMessageTask(CmdConfigCustom.CMD_FRS_LIVE_CARD_CLICK, bVar);
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
        CustomMessageTask customMessageTask2 = new CustomMessageTask(CmdConfigCustom.CMD_FRS_LIVE_CARD_SHOW, bVar);
        customMessageTask2.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask2);
        CustomMessageTask customMessageTask3 = new CustomMessageTask(CmdConfigCustom.CMD_FRS_LIVE_USER_CLICK, bVar);
        customMessageTask3.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask3);
        CustomMessageTask customMessageTask4 = new CustomMessageTask(CmdConfigCustom.CMD_FRS_LIVE_VIDEO_CLICK, bVar);
        customMessageTask4.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask4);
    }

    @Override // com.baidu.tieba.frs.entelechy.a.t
    public List<com.baidu.adp.widget.ListView.f> getDatas() {
        if (this.mListView != null) {
            return this.mListView.getData();
        }
        return null;
    }

    private void K(ArrayList<com.baidu.adp.widget.ListView.f> arrayList) {
        int i;
        if (this.mAdapters != null && this.mAdapters.size() != 0) {
            int i2 = 0;
            if (arrayList == null || arrayList.size() <= 0) {
                i = 0;
            } else {
                Iterator<com.baidu.adp.widget.ListView.f> it = arrayList.iterator();
                while (true) {
                    i = i2;
                    if (!it.hasNext() || it.next().getType().getId() != bh.Yn.getId()) {
                        break;
                    }
                    i2 = i + 1;
                }
            }
            for (com.baidu.adp.widget.ListView.a aVar : this.mAdapters) {
                if (aVar instanceof com.baidu.tieba.frs.d) {
                    ((com.baidu.tieba.frs.d) aVar).jm(i);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aN(List<com.baidu.adp.widget.ListView.a> list) {
        if (list != null) {
            for (com.baidu.adp.widget.ListView.a aVar : list) {
                if (aVar instanceof com.baidu.tieba.frs.d) {
                    ((com.baidu.tieba.frs.d) aVar).a(this.cxk);
                }
            }
        }
    }
}
