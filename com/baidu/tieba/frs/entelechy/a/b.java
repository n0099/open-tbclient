package com.baidu.tieba.frs.entelechy.a;

import android.text.TextUtils;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public class b implements r {
    private ArrayList<com.baidu.adp.widget.ListView.f> abX;
    private com.baidu.tieba.frs.f crI;
    private l cvK;
    private j cvL;
    private l cvM;
    private c cvN;
    private com.baidu.adp.widget.ListView.a cvO;
    private n cvP;
    private q cvQ;
    private g cvR;
    private com.baidu.adp.widget.ListView.a cvS;
    private com.baidu.adp.widget.ListView.a cvT;
    private d cvU;
    private d cvV;
    private com.baidu.tieba.frs.j cvW;
    private com.baidu.tieba.frs.i.a cvX;
    private List<com.baidu.adp.widget.ListView.a> cvY;
    private m cvZ;
    private i cwa;
    private h cwb;
    private p cwc;
    private final HashMap<Integer, bh> cwd;
    private com.baidu.tieba.tbadkCore.i cwe;
    private BdTypeListView mListView;
    private List<com.baidu.adp.widget.ListView.a> mAdapters = new LinkedList();
    private boolean cwf = false;
    private CustomMessageListener cwg = new CustomMessageListener(CmdConfigCustom.CMD_FRS_ADD_ADAPTER) { // from class: com.baidu.tieba.frs.entelechy.a.b.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2003008 && (customResponsedMessage.getData() instanceof AbsDelegateAdapterList)) {
                AbsDelegateAdapterList absDelegateAdapterList = (AbsDelegateAdapterList) customResponsedMessage.getData();
                Iterator it = absDelegateAdapterList.iterator();
                while (it.hasNext()) {
                    com.baidu.adp.widget.ListView.a aVar = (com.baidu.adp.widget.ListView.a) it.next();
                    if (aVar instanceof com.baidu.tieba.frs.d) {
                        ((com.baidu.tieba.frs.d) aVar).a(b.this.crI.getPageContext(), b.this.crI.getUniqueId());
                    }
                }
                ArrayList arrayList = new ArrayList();
                arrayList.addAll(absDelegateAdapterList);
                b.this.aL(arrayList);
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
    private CustomMessageListener cwh = new CustomMessageListener(CmdConfigCustom.CMD_LEGO_REGISTER) { // from class: com.baidu.tieba.frs.entelechy.a.b.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && v.u(b.this.cvY)) {
                b.this.ajc();
                b.this.b(b.this.abX, b.this.cwe);
            }
        }
    };
    private CustomMessageListener aoT = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.frs.entelechy.a.b.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
            if (updateAttentionMessage != null && updateAttentionMessage.getData() != null && updateAttentionMessage.getData().BY) {
                b.this.P(updateAttentionMessage.getData());
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
                bVar.dXS = true;
                b.this.P(bVar);
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
                bVar.dXS = false;
                b.this.P(bVar);
            }
        }
    };
    private CustomMessageListener cwi = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ADCARD) { // from class: com.baidu.tieba.frs.entelechy.a.b.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.data.h)) {
                b.this.Q((com.baidu.tbadk.data.h) customResponsedMessage.getData());
            }
        }
    };
    private final com.baidu.tieba.frs.c cqc = new com.baidu.tieba.frs.c();

    public b(com.baidu.tieba.frs.f fVar, BdTypeListView bdTypeListView, boolean z) {
        this.mListView = bdTypeListView;
        a(fVar, bdTypeListView);
        this.cwd = new HashMap<>();
        eS(z);
    }

    public void a(com.baidu.tieba.frs.f fVar, BdTypeListView bdTypeListView) {
        this.crI = fVar;
        this.cvK = new l(fVar.getPageContext(), bh.Yi, this.crI.getUniqueId());
        this.cvK.setVoiceManager(fVar.getVoiceManager());
        this.cvL = new j(fVar.getPageContext(), bh.Yj, this.crI.getUniqueId());
        this.cvM = new l(fVar.getPageContext(), bh.Yk, this.crI.getUniqueId());
        this.cvM.setVoiceManager(fVar.getVoiceManager());
        this.cvQ = new q(fVar.getPageContext(), bh.Yl, this.crI.getUniqueId());
        this.cvR = new g(fVar.getPageContext(), bh.Yp, this.crI.getUniqueId());
        this.cvN = new c(fVar.getPageContext(), av.XF, this.crI.getUniqueId());
        this.cvO = com.baidu.tieba.frs.a.agx().a(fVar.getPageContext(), com.baidu.tieba.tbadkCore.p.gfB, this.crI.getUniqueId(), false);
        this.cvW = new com.baidu.tieba.frs.j(fVar.getPageContext(), k.csn);
        this.cvP = new n(fVar.getPageContext(), aw.XI);
        this.cvU = new d(fVar.getPageContext(), bh.Yt, this.crI.getUniqueId());
        this.cvV = new d(fVar.getPageContext(), bh.Yu, this.crI.getUniqueId());
        this.cvS = com.baidu.tieba.frs.a.agx().a(fVar.getPageContext(), bh.Zs, this.crI.getUniqueId(), false);
        this.cvT = com.baidu.tieba.frs.a.agx().b(fVar.getPageContext(), bh.Zx, this.crI.getUniqueId());
        this.cvX = new com.baidu.tieba.frs.i.a(fVar.getPageContext(), z.Wr, this.crI.getUniqueId());
        this.cvZ = new m(fVar.getPageContext(), com.baidu.tieba.frs.p.csP);
        this.cwa = new i(fVar.getPageContext(), bh.Yv, this.crI.getUniqueId());
        this.cwb = new h(fVar.getPageContext(), CardHListViewData.TYPE);
        this.cwc = new p(fVar.getPageContext(), com.baidu.tieba.frs.q.csV, this.crI.getUniqueId());
        this.mAdapters.add(this.cwb);
        this.mAdapters.add(this.cvK);
        this.mAdapters.add(this.cvL);
        this.mAdapters.add(this.cvM);
        this.mAdapters.add(this.cwc);
        com.baidu.tieba.InjectPlugin.b.b bVar = new com.baidu.tieba.InjectPlugin.b.b(this.crI, 1);
        bVar.setExtraData(this.mAdapters);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_FEED_AD_PLUGIN_OPERATE, bVar));
        this.mAdapters.add(this.cvN);
        this.mAdapters.add(this.cwa);
        if (this.cvO != null) {
            this.mAdapters.add(this.cvO);
        }
        this.mAdapters.add(this.cvW);
        this.mAdapters.add(this.cvQ);
        this.mAdapters.add(this.cvR);
        this.mAdapters.add(this.cvP);
        this.mAdapters.add(this.cvU);
        this.mAdapters.add(this.cvV);
        this.mAdapters.add(new com.baidu.tieba.frs.v(this.crI.getPageContext(), w.ctj));
        this.mAdapters.add(this.cvS);
        if (this.cvT != null) {
            this.mAdapters.add(this.cvT);
        }
        this.mAdapters.add(this.cvX);
        this.mAdapters.add(this.cvZ);
        com.baidu.adp.widget.ListView.a<? extends bh, ? extends j.a> b = com.baidu.tieba.frs.a.agx().b(this.crI.getPageContext(), bh.Zr, this.crI.getUniqueId());
        if (b != null) {
            this.mAdapters.add(b);
        }
        this.cwg.setPriority(1);
        this.cwg.setSelfListener(true);
        this.crI.registerListener(this.cwg);
        this.crI.registerListener(this.aoT);
        this.crI.registerListener(this.mLikeForumListener);
        this.crI.registerListener(this.mUnlikeForumListener);
        this.crI.registerListener(this.cwi);
        ajb();
        CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_ADD_ADAPTER, new AbsDelegateAdapterList());
        CustomMessage customMessage = new CustomMessage(CmdConfigCustom.CMD_FRS_ADD_ADAPTER);
        customMessage.setTag(this.crI.getUniqueId());
        customResponsedMessage.setOrginalMessage(customMessage);
        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
        aL(this.mAdapters);
        bdTypeListView.addAdapters(this.mAdapters);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void P(Object obj) {
        boolean z;
        boolean z2 = false;
        if (this.abX != null) {
            Iterator<com.baidu.adp.widget.ListView.f> it = this.abX.iterator();
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
    public void Q(Object obj) {
        if (this.abX != null) {
            Iterator<com.baidu.adp.widget.ListView.f> it = this.abX.iterator();
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

    private void ajb() {
        if (this.crI != null && !ajc()) {
            this.crI.registerListener(this.cwh);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean ajc() {
        if (this.crI == null) {
            return false;
        }
        this.cvY = new ArrayList();
        ArrayList<BdUniqueId> bqG = com.baidu.tieba.tbadkCore.n.bqG();
        if (bqG == null || bqG.size() <= 0) {
            return false;
        }
        int size = bqG.size();
        for (int i = 0; i < size; i++) {
            com.baidu.tieba.frs.d<ICardInfo, ? extends j.a> a = com.baidu.tieba.frs.a.agx().a(this.crI.getPageContext(), bqG.get(i), this.crI.getUniqueId());
            if (a != null) {
                this.mAdapters.add(a);
                this.cvY.add(a);
            }
        }
        if (!v.u(this.cvY)) {
            this.mListView.addAdapters(this.cvY);
        }
        return true;
    }

    @Override // com.baidu.tieba.frs.entelechy.a.r
    public void onDestory() {
        for (com.baidu.adp.widget.ListView.a aVar : this.mAdapters) {
            if (aVar instanceof com.baidu.tieba.frs.d) {
                ((com.baidu.tieba.frs.d) aVar).release();
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.a.r
    public void b(ArrayList<com.baidu.adp.widget.ListView.f> arrayList, com.baidu.tieba.tbadkCore.i iVar) {
        a(iVar);
        com.baidu.tieba.tbadkCore.n.p(arrayList, 1);
        I(arrayList);
        J(arrayList);
        H(arrayList);
        this.mListView.setData(arrayList);
        this.cwe = iVar;
        ajk();
        this.abX = arrayList;
    }

    private void H(ArrayList<com.baidu.adp.widget.ListView.f> arrayList) {
        int t = v.t(arrayList);
        for (int i = 0; i < t; i++) {
            com.baidu.adp.widget.ListView.f fVar = (com.baidu.adp.widget.ListView.f) v.c(arrayList, i - 1);
            com.baidu.adp.widget.ListView.f fVar2 = (com.baidu.adp.widget.ListView.f) v.c(arrayList, i);
            if (fVar2 instanceof bh) {
                bh bhVar = (bh) fVar2;
                if (i == 0) {
                    bhVar.isFirstFloor = true;
                } else {
                    bhVar.isFirstFloor = false;
                }
                String rT = bhVar.rT();
                if (fVar instanceof com.baidu.tieba.frs.p) {
                    bhVar.needTopMargin = false;
                } else if (fVar != null && !e(fVar)) {
                    bhVar.needTopMargin = false;
                } else if ((fVar instanceof bh) && e(fVar) && !TextUtils.isEmpty(((bh) fVar).rT())) {
                    bhVar.needTopMargin = true;
                } else if (e(fVar2) && !TextUtils.isEmpty(rT)) {
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
        return type == bh.Yi || type == bh.Yk || type == bh.Yl || type == bh.Yp || type == bh.Yv || type == av.XF || type == bh.Yt || type == bh.Yu;
    }

    private ArrayList<Integer> I(ArrayList<com.baidu.adp.widget.ListView.f> arrayList) {
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
                if (this.cwd != null && !this.cwd.containsValue(fVar)) {
                    this.cwd.put(Integer.valueOf(i2), (bh) fVar);
                }
            }
            i = i2 + 1;
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.a.r
    public void eS(boolean z) {
        if (this.cwf != z) {
            this.cwf = z;
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.a.r
    public HashMap<Integer, bh> ajd() {
        return this.cwd;
    }

    @Override // com.baidu.tieba.frs.entelechy.a.r
    public void aje() {
        if (this.mListView != null && this.mListView.getData() != null && this.mListView.getData().size() != 0) {
            for (com.baidu.adp.widget.ListView.f fVar : this.mListView.getData()) {
                if ((fVar instanceof bh) && ((bh) fVar).rq() != 0) {
                    ((bh) fVar).sd();
                }
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.a.r
    public void notifyDataSetChanged() {
        if (this.mListView.getAdapter() instanceof com.baidu.adp.widget.ListView.d) {
            ((com.baidu.adp.widget.ListView.d) this.mListView.getAdapter()).notifyDataSetChanged();
        }
    }

    public void YV() {
        if (this.mListView.getAdapter() instanceof com.baidu.adp.widget.ListView.d) {
            if (this.abX != null) {
                this.mListView.setData(this.abX);
            }
            ((com.baidu.adp.widget.ListView.d) this.mListView.getAdapter()).notifyDataSetChanged();
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.a.r
    public void setFromCDN(boolean z) {
        if (this.mAdapters != null && this.mAdapters.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.mAdapters) {
                if (aVar instanceof com.baidu.tieba.frs.d) {
                    ((com.baidu.tieba.frs.d) aVar).setFromCDN(z);
                }
            }
            if (this.cvK != null) {
                this.cvK.setFromCDN(z);
            }
            if (this.cvM != null) {
                this.cvM.setFromCDN(z);
            }
            if (this.cvU != null) {
                this.cvU.setFromCDN(z);
            }
            if (this.cvV != null) {
                this.cvV.setFromCDN(z);
            }
        }
    }

    public void a(com.baidu.tieba.tbadkCore.i iVar) {
        if (this.mAdapters != null && this.mAdapters.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.mAdapters) {
                if (aVar instanceof com.baidu.tieba.frs.d) {
                    ((com.baidu.tieba.frs.d) aVar).a(iVar);
                }
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.a.r
    public void a(com.baidu.tieba.frs.b bVar) {
        if (this.mAdapters != null && this.mAdapters.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.mAdapters) {
                if (aVar instanceof com.baidu.tieba.frs.d) {
                    ((com.baidu.tieba.frs.d) aVar).a(bVar);
                }
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.a.r
    public int ajf() {
        if (this.cvO != null) {
            return d.h.frs_fortune_bag_item;
        }
        return 0;
    }

    @Override // com.baidu.tieba.frs.entelechy.a.r
    public int ajg() {
        if (this.cvO != null) {
            return d.h.frs_my_service_item;
        }
        return 0;
    }

    @Override // com.baidu.tieba.frs.entelechy.a.r
    public int ajh() {
        if (this.cvO != null) {
            return d.h.frs_bawu_center;
        }
        return 0;
    }

    @Override // com.baidu.tieba.frs.entelechy.a.r
    public int aji() {
        if (this.cvP != null) {
            return this.cvP.ahW();
        }
        return 0;
    }

    @Override // com.baidu.tieba.frs.entelechy.a.r
    public int ahX() {
        if (this.cvP != null) {
            return this.cvP.ahX();
        }
        return 0;
    }

    @Override // com.baidu.tieba.frs.entelechy.a.r
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

    @Override // com.baidu.tieba.frs.entelechy.a.r
    public void setOnAdapterItemClickListener(com.baidu.adp.widget.ListView.h hVar) {
        if (this.mAdapters != null && this.mAdapters.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.mAdapters) {
                if (aVar instanceof com.baidu.tieba.frs.d) {
                    ((com.baidu.tieba.frs.d) aVar).setOnAdapterItemClickListener(hVar);
                } else if ((aVar instanceof l) || (aVar instanceof c) || (aVar instanceof f) || (aVar instanceof d) || (aVar instanceof q)) {
                    aVar.setOnAdapterItemClickListener(hVar);
                } else if (aVar != null && aVar.getType() == bh.Zr) {
                    aVar.setOnAdapterItemClickListener(hVar);
                }
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.a.r
    public void setForumName(String str) {
        if (this.mAdapters != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.mAdapters) {
                if (aVar instanceof com.baidu.tieba.card.v) {
                    ((com.baidu.tieba.card.v) aVar).setForumName(str);
                }
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.a.r
    public void cJ(boolean z) {
        if (this.mAdapters != null && this.mAdapters.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.mAdapters) {
                if (aVar instanceof com.baidu.tieba.frs.d) {
                    ((com.baidu.tieba.frs.d) aVar).cJ(z);
                }
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.a.r
    public void ajj() {
        if (this.mAdapters != null && this.mAdapters.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.mAdapters) {
                if (aVar instanceof com.baidu.tieba.frs.d) {
                    ((com.baidu.tieba.frs.d) aVar).a(this.crI.getPageContext(), this.crI.getUniqueId());
                }
            }
            aL(this.mAdapters);
        }
    }

    private void ajk() {
        if (this.cwe != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.mAdapters) {
                if (aVar instanceof com.baidu.tieba.frs.f.c) {
                    com.baidu.tieba.frs.f.c cVar = (com.baidu.tieba.frs.f.c) aVar;
                    if (com.baidu.tieba.frs.f.c.cGc != null) {
                        if (this.cwe.gek == 1) {
                            com.baidu.tieba.frs.f.c.cGc.cFS = true;
                        } else {
                            com.baidu.tieba.frs.f.c.cGc.cFS = false;
                        }
                        if (this.cwe.aMZ() != null) {
                            com.baidu.tieba.frs.f.c.cGc.cFU = this.cwe.aMZ().getId();
                        }
                        if (this.crI != null && this.crI.agP() != null) {
                            com.baidu.tieba.frs.f.c.cGc.cFT = this.crI.agP().ald();
                        }
                    }
                }
            }
            ajl();
        }
    }

    private void ajl() {
        com.baidu.tieba.frs.f.a aVar = new com.baidu.tieba.frs.f.a();
        if (this.cwe.gek == 1) {
            aVar.cFS = true;
        } else {
            aVar.cFS = false;
        }
        if (this.cwe.aMZ() != null) {
            aVar.cFU = this.cwe.aMZ().getId();
        }
        if (this.crI != null && this.crI.agP() != null) {
            aVar.cFT = this.crI.agP().ald();
        }
        com.baidu.tieba.frs.d.b bVar = new com.baidu.tieba.frs.d.b(aVar);
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

    @Override // com.baidu.tieba.frs.entelechy.a.r
    public List<com.baidu.adp.widget.ListView.f> getDatas() {
        if (this.mListView != null) {
            return this.mListView.getData();
        }
        return null;
    }

    private void J(ArrayList<com.baidu.adp.widget.ListView.f> arrayList) {
        int i;
        if (this.mAdapters != null && this.mAdapters.size() != 0) {
            int i2 = 0;
            if (arrayList == null || arrayList.size() <= 0) {
                i = 0;
            } else {
                Iterator<com.baidu.adp.widget.ListView.f> it = arrayList.iterator();
                while (true) {
                    i = i2;
                    if (!it.hasNext() || it.next().getType().getId() != bh.Yh.getId()) {
                        break;
                    }
                    i2 = i + 1;
                }
            }
            for (com.baidu.adp.widget.ListView.a aVar : this.mAdapters) {
                if (aVar instanceof com.baidu.tieba.frs.d) {
                    ((com.baidu.tieba.frs.d) aVar).iX(i);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aL(List<com.baidu.adp.widget.ListView.a> list) {
        if (list != null) {
            for (com.baidu.adp.widget.ListView.a aVar : list) {
                if (aVar instanceof com.baidu.tieba.frs.d) {
                    ((com.baidu.tieba.frs.d) aVar).a(this.cqc);
                }
            }
        }
    }
}
