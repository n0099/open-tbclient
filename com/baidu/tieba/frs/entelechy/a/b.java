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
import com.baidu.tbadk.core.data.ar;
import com.baidu.tbadk.core.data.as;
import com.baidu.tbadk.core.data.bd;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.coreExtra.message.UpdateAttentionMessage;
import com.baidu.tieba.card.data.CardHListViewData;
import com.baidu.tieba.d;
import com.baidu.tieba.frs.AbsDelegateAdapterList;
import com.baidu.tieba.frs.e;
import com.baidu.tieba.frs.k;
import com.baidu.tieba.frs.o;
import com.baidu.tieba.frs.w;
import com.baidu.tieba.frs.x;
import com.baidu.tieba.lego.card.model.ICardInfo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public class b implements u {
    private ArrayList<com.baidu.adp.widget.ListView.f> acB;
    private com.baidu.tieba.frs.g cIC;
    private l cMR;
    private j cMS;
    private p cMT;
    private l cMU;
    private c cMV;
    private com.baidu.adp.widget.ListView.a cMW;
    private o cMX;
    private t cMY;
    private g cMZ;
    private com.baidu.adp.widget.ListView.a cNa;
    private com.baidu.adp.widget.ListView.a cNb;
    private d cNc;
    private d cNd;
    private k cNe;
    private List<com.baidu.adp.widget.ListView.a> cNf;
    private m cNg;
    private i cNh;
    private h cNi;
    private q cNj;
    private r cNk;
    private final HashMap<Integer, bd> cNl;
    private com.baidu.tieba.tbadkCore.k cNm;
    private BdTypeListView mListView;
    private List<com.baidu.adp.widget.ListView.a> mAdapters = new LinkedList();
    private boolean cNn = false;
    private CustomMessageListener cNo = new CustomMessageListener(CmdConfigCustom.CMD_FRS_ADD_ADAPTER) { // from class: com.baidu.tieba.frs.entelechy.a.b.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2003008 && (customResponsedMessage.getData() instanceof AbsDelegateAdapterList)) {
                AbsDelegateAdapterList absDelegateAdapterList = (AbsDelegateAdapterList) customResponsedMessage.getData();
                Iterator it = absDelegateAdapterList.iterator();
                while (it.hasNext()) {
                    com.baidu.adp.widget.ListView.a aVar = (com.baidu.adp.widget.ListView.a) it.next();
                    if (aVar instanceof e) {
                        ((e) aVar).a(b.this.cIC.getPageContext(), b.this.cIC.getUniqueId());
                    }
                }
                ArrayList arrayList = new ArrayList();
                arrayList.addAll(absDelegateAdapterList);
                b.this.aZ(arrayList);
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
    private CustomMessageListener cNp = new CustomMessageListener(CmdConfigCustom.CMD_LEGO_REGISTER) { // from class: com.baidu.tieba.frs.entelechy.a.b.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && v.w(b.this.cNf)) {
                b.this.anB();
                b.this.b(b.this.acB, b.this.cNm);
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
                bVar.emt = true;
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
                bVar.emt = false;
                b.this.S(bVar);
            }
        }
    };
    private CustomMessageListener cNq = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ADCARD) { // from class: com.baidu.tieba.frs.entelechy.a.b.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.data.j)) {
                b.this.T((com.baidu.tbadk.data.j) customResponsedMessage.getData());
            }
        }
    };
    private final com.baidu.tieba.frs.c cGV = new com.baidu.tieba.frs.c();

    public b(com.baidu.tieba.frs.g gVar, BdTypeListView bdTypeListView, boolean z) {
        this.mListView = bdTypeListView;
        a(gVar, bdTypeListView);
        this.cNl = new HashMap<>();
        fj(z);
    }

    public void a(com.baidu.tieba.frs.g gVar, BdTypeListView bdTypeListView) {
        this.cIC = gVar;
        this.cMR = new l(gVar.getPageContext(), bd.YD, this.cIC.getUniqueId());
        this.cMR.setVoiceManager(gVar.getVoiceManager());
        this.cMS = new j(gVar.getPageContext(), bd.YE, this.cIC.getUniqueId());
        this.cMT = new p(gVar.getPageContext(), bd.YK, this.cIC.getUniqueId());
        this.cMU = new l(gVar.getPageContext(), bd.YF, this.cIC.getUniqueId());
        this.cMU.setVoiceManager(gVar.getVoiceManager());
        this.cMY = new t(gVar.getPageContext(), bd.YG, this.cIC.getUniqueId());
        this.cMZ = new g(gVar.getPageContext(), bd.YL, this.cIC.getUniqueId());
        this.cMV = new c(gVar.getPageContext(), ar.Ya, this.cIC.getUniqueId());
        this.cMW = com.baidu.tieba.frs.a.akO().a(gVar.getPageContext(), com.baidu.tieba.tbadkCore.r.gAN, this.cIC.getUniqueId(), false);
        this.cNe = new k(gVar.getPageContext(), com.baidu.tieba.frs.l.cJk);
        this.cMX = new o(gVar.getPageContext(), as.Yd);
        this.cNc = new d(gVar.getPageContext(), bd.YP, this.cIC.getUniqueId());
        this.cNd = new d(gVar.getPageContext(), bd.YQ, this.cIC.getUniqueId());
        this.cNa = com.baidu.tieba.frs.a.akO().a(gVar.getPageContext(), bd.ZR, this.cIC.getUniqueId(), true);
        this.cNb = com.baidu.tieba.frs.a.akO().b(gVar.getPageContext(), bd.ZW, this.cIC.getUniqueId());
        this.cNg = new m(gVar.getPageContext(), com.baidu.tieba.frs.q.cJL);
        this.cNh = new i(gVar.getPageContext(), bd.YR, this.cIC.getUniqueId());
        this.cNi = new h(gVar.getPageContext(), CardHListViewData.TYPE);
        this.cNj = new q(gVar.getPageContext(), com.baidu.tieba.frs.r.cJR, this.cIC.getUniqueId());
        this.cNk = new r(gVar.getPageContext().getPageActivity(), com.baidu.tieba.tbadkCore.j.gAC, this.cIC.getUniqueId());
        this.mAdapters.add(this.cNk);
        this.mAdapters.add(this.cNi);
        this.mAdapters.add(this.cMR);
        this.mAdapters.add(this.cMS);
        this.mAdapters.add(this.cMT);
        this.mAdapters.add(this.cMU);
        this.mAdapters.add(this.cNj);
        com.baidu.tieba.InjectPlugin.b.b bVar = new com.baidu.tieba.InjectPlugin.b.b(this.cIC, 1);
        bVar.setExtraData(this.mAdapters);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_FEED_AD_PLUGIN_OPERATE, bVar));
        this.mAdapters.add(this.cMV);
        this.mAdapters.add(this.cNh);
        if (this.cMW != null) {
            this.mAdapters.add(this.cMW);
        }
        this.mAdapters.add(this.cNe);
        this.mAdapters.add(this.cMY);
        this.mAdapters.add(this.cMZ);
        this.mAdapters.add(this.cMX);
        this.mAdapters.add(this.cNc);
        this.mAdapters.add(this.cNd);
        this.mAdapters.add(new w(this.cIC.getPageContext(), x.cKf));
        this.mAdapters.add(this.cNa);
        if (this.cNb != null) {
            this.mAdapters.add(this.cNb);
        }
        this.mAdapters.add(this.cNg);
        com.baidu.adp.widget.ListView.a<? extends bd, ? extends j.a> b = com.baidu.tieba.frs.a.akO().b(this.cIC.getPageContext(), bd.ZQ, this.cIC.getUniqueId());
        if (b != null) {
            this.mAdapters.add(b);
        }
        this.cNo.setPriority(1);
        this.cNo.setSelfListener(true);
        this.cIC.registerListener(this.cNo);
        this.cIC.registerListener(this.mAttentionListener);
        this.cIC.registerListener(this.mLikeForumListener);
        this.cIC.registerListener(this.mUnlikeForumListener);
        this.cIC.registerListener(this.cNq);
        anA();
        CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_ADD_ADAPTER, new AbsDelegateAdapterList());
        CustomMessage customMessage = new CustomMessage(CmdConfigCustom.CMD_FRS_ADD_ADAPTER);
        customMessage.setTag(this.cIC.getUniqueId());
        customResponsedMessage.setOrginalMessage(customMessage);
        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
        aZ(this.mAdapters);
        bdTypeListView.addAdapters(this.mAdapters);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void S(Object obj) {
        boolean z;
        boolean z2 = false;
        if (this.acB != null) {
            Iterator<com.baidu.adp.widget.ListView.f> it = this.acB.iterator();
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
        if (this.acB != null) {
            Iterator<com.baidu.adp.widget.ListView.f> it = this.acB.iterator();
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

    private void anA() {
        if (this.cIC != null && !anB()) {
            this.cIC.registerListener(this.cNp);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean anB() {
        if (this.cIC == null) {
            return false;
        }
        this.cNf = new ArrayList();
        ArrayList<BdUniqueId> bwg = com.baidu.tieba.tbadkCore.p.bwg();
        if (bwg == null || bwg.size() <= 0) {
            return false;
        }
        int size = bwg.size();
        for (int i = 0; i < size; i++) {
            e<ICardInfo, ? extends j.a> a = com.baidu.tieba.frs.a.akO().a(this.cIC.getPageContext(), bwg.get(i), this.cIC.getUniqueId());
            if (a != null) {
                this.mAdapters.add(a);
                this.cNf.add(a);
            }
        }
        if (!v.w(this.cNf)) {
            this.mListView.addAdapters(this.cNf);
        }
        return true;
    }

    @Override // com.baidu.tieba.frs.entelechy.a.u
    public void onDestory() {
        for (com.baidu.adp.widget.ListView.a aVar : this.mAdapters) {
            if (aVar instanceof e) {
                ((e) aVar).release();
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.a.u
    public void b(ArrayList<com.baidu.adp.widget.ListView.f> arrayList, com.baidu.tieba.tbadkCore.k kVar) {
        b(kVar);
        com.baidu.tieba.tbadkCore.p.p(arrayList, 1);
        K(arrayList);
        L(arrayList);
        J(arrayList);
        this.mListView.setData(arrayList);
        this.cNm = kVar;
        anK();
        anC();
        this.acB = arrayList;
    }

    private void anC() {
        if (this.cNm != null && this.cNm.aRo() != null && !StringUtils.isNull(this.cNm.aRo().getId()) && this.cNk != null) {
            this.cNk.setForumId(this.cNm.aRo().getId());
        }
    }

    private void J(ArrayList<com.baidu.adp.widget.ListView.f> arrayList) {
        int v = v.v(arrayList);
        for (int i = 0; i < v; i++) {
            com.baidu.adp.widget.ListView.f fVar = (com.baidu.adp.widget.ListView.f) v.c(arrayList, i - 1);
            com.baidu.adp.widget.ListView.f fVar2 = (com.baidu.adp.widget.ListView.f) v.c(arrayList, i);
            if (fVar2 instanceof bd) {
                bd bdVar = (bd) fVar2;
                if (i == 0) {
                    bdVar.isFirstFloor = true;
                } else {
                    bdVar.isFirstFloor = false;
                }
                String rU = bdVar.rU();
                if (fVar instanceof com.baidu.tieba.frs.q) {
                    bdVar.needTopMargin = false;
                } else if (fVar != null && !e(fVar)) {
                    bdVar.needTopMargin = false;
                } else if ((fVar instanceof bd) && e(fVar) && !TextUtils.isEmpty(((bd) fVar).rU())) {
                    bdVar.needTopMargin = true;
                } else if (e(fVar2) && !TextUtils.isEmpty(rU)) {
                    bdVar.needTopMargin = true;
                } else {
                    bdVar.needTopMargin = false;
                }
            }
        }
    }

    private boolean e(com.baidu.adp.widget.ListView.f fVar) {
        if (fVar == null) {
            return false;
        }
        BdUniqueId type = fVar.getType();
        return type == bd.YD || type == bd.YF || type == bd.YG || type == bd.YL || type == bd.YR || type == ar.Ya || type == bd.YP || type == bd.YQ;
    }

    private ArrayList<Integer> K(ArrayList<com.baidu.adp.widget.ListView.f> arrayList) {
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
                if (this.cNl != null && !this.cNl.containsValue(fVar)) {
                    this.cNl.put(Integer.valueOf(i2), (bd) fVar);
                }
            }
            i = i2 + 1;
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.a.u
    public void fj(boolean z) {
        if (this.cNn != z) {
            this.cNn = z;
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.a.u
    public HashMap<Integer, bd> anD() {
        return this.cNl;
    }

    @Override // com.baidu.tieba.frs.entelechy.a.u
    public void anE() {
        if (this.mListView != null && this.mListView.getData() != null && this.mListView.getData().size() != 0) {
            for (com.baidu.adp.widget.ListView.f fVar : this.mListView.getData()) {
                if ((fVar instanceof bd) && ((bd) fVar).rq() != 0) {
                    ((bd) fVar).sd();
                }
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.a.u
    public void notifyDataSetChanged() {
        if (this.mListView.getAdapter() instanceof com.baidu.adp.widget.ListView.d) {
            ((com.baidu.adp.widget.ListView.d) this.mListView.getAdapter()).notifyDataSetChanged();
        }
    }

    public void adf() {
        if (this.mListView.getAdapter() instanceof com.baidu.adp.widget.ListView.d) {
            if (this.acB != null) {
                this.mListView.setData(this.acB);
            }
            ((com.baidu.adp.widget.ListView.d) this.mListView.getAdapter()).notifyDataSetChanged();
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.a.u
    public void setFromCDN(boolean z) {
        if (this.mAdapters != null && this.mAdapters.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.mAdapters) {
                if (aVar instanceof e) {
                    ((e) aVar).setFromCDN(z);
                }
            }
            if (this.cMR != null) {
                this.cMR.setFromCDN(z);
            }
            if (this.cMU != null) {
                this.cMU.setFromCDN(z);
            }
            if (this.cNc != null) {
                this.cNc.setFromCDN(z);
            }
            if (this.cNd != null) {
                this.cNd.setFromCDN(z);
            }
        }
    }

    public void b(com.baidu.tieba.tbadkCore.k kVar) {
        if (this.mAdapters != null && this.mAdapters.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.mAdapters) {
                if (aVar instanceof e) {
                    ((e) aVar).b(kVar);
                }
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.a.u
    public void a(com.baidu.tieba.frs.b bVar) {
        if (this.mAdapters != null && this.mAdapters.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.mAdapters) {
                if (aVar instanceof e) {
                    ((e) aVar).a(bVar);
                }
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.a.u
    public int anF() {
        if (this.cMW != null) {
            return d.g.frs_fortune_bag_item;
        }
        return 0;
    }

    @Override // com.baidu.tieba.frs.entelechy.a.u
    public int anG() {
        if (this.cMW != null) {
            return d.g.frs_my_service_item;
        }
        return 0;
    }

    @Override // com.baidu.tieba.frs.entelechy.a.u
    public int anH() {
        if (this.cMW != null) {
            return d.g.frs_bawu_center;
        }
        return 0;
    }

    @Override // com.baidu.tieba.frs.entelechy.a.u
    public int anI() {
        if (this.cMX != null) {
            return this.cMX.ams();
        }
        return 0;
    }

    @Override // com.baidu.tieba.frs.entelechy.a.u
    public int amt() {
        if (this.cMX != null) {
            return this.cMX.amt();
        }
        return 0;
    }

    @Override // com.baidu.tieba.frs.entelechy.a.u
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

    @Override // com.baidu.tieba.frs.entelechy.a.u
    public void setOnAdapterItemClickListener(com.baidu.adp.widget.ListView.h hVar) {
        if (this.mAdapters != null && this.mAdapters.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.mAdapters) {
                if (aVar instanceof e) {
                    ((e) aVar).setOnAdapterItemClickListener(hVar);
                } else if ((aVar instanceof l) || (aVar instanceof c) || (aVar instanceof f) || (aVar instanceof d) || (aVar instanceof t)) {
                    aVar.setOnAdapterItemClickListener(hVar);
                } else if (aVar != null && aVar.getType() == bd.ZQ) {
                    aVar.setOnAdapterItemClickListener(hVar);
                }
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.a.u
    public void setForumName(String str) {
        if (this.mAdapters != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.mAdapters) {
                if (aVar instanceof com.baidu.tieba.card.u) {
                    ((com.baidu.tieba.card.u) aVar).setForumName(str);
                }
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.a.u
    public void cN(boolean z) {
        if (this.mAdapters != null && this.mAdapters.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.mAdapters) {
                if (aVar instanceof e) {
                    ((e) aVar).cN(z);
                }
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.a.u
    public void anJ() {
        if (this.mAdapters != null && this.mAdapters.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.mAdapters) {
                if (aVar instanceof e) {
                    ((e) aVar).a(this.cIC.getPageContext(), this.cIC.getUniqueId());
                }
            }
            aZ(this.mAdapters);
        }
    }

    private void anK() {
        if (this.cNm != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.mAdapters) {
                if (aVar instanceof com.baidu.tieba.frs.e.c) {
                    com.baidu.tieba.frs.e.c cVar = (com.baidu.tieba.frs.e.c) aVar;
                    if (com.baidu.tieba.frs.e.c.cZc != null) {
                        if (this.cNm.gzq == 1) {
                            com.baidu.tieba.frs.e.c.cZc.cYS = true;
                        } else {
                            com.baidu.tieba.frs.e.c.cZc.cYS = false;
                        }
                        if (this.cNm.aRo() != null) {
                            com.baidu.tieba.frs.e.c.cZc.cYU = this.cNm.aRo().getId();
                        }
                        if (this.cIC != null && this.cIC.ali() != null) {
                            com.baidu.tieba.frs.e.c.cZc.cYT = this.cIC.ali().aqb();
                        }
                    }
                }
            }
            anL();
        }
    }

    private void anL() {
        com.baidu.tieba.frs.e.a aVar = new com.baidu.tieba.frs.e.a();
        if (this.cNm.gzq == 1) {
            aVar.cYS = true;
        } else {
            aVar.cYS = false;
        }
        if (this.cNm.aRo() != null) {
            aVar.cYU = this.cNm.aRo().getId();
        }
        if (this.cIC != null && this.cIC.ali() != null) {
            aVar.cYT = this.cIC.ali().aqb();
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

    @Override // com.baidu.tieba.frs.entelechy.a.u
    public List<com.baidu.adp.widget.ListView.f> getDatas() {
        if (this.mListView != null) {
            return this.mListView.getData();
        }
        return null;
    }

    private void L(ArrayList<com.baidu.adp.widget.ListView.f> arrayList) {
        int i;
        if (this.mAdapters != null && this.mAdapters.size() != 0) {
            int i2 = 0;
            if (arrayList == null || arrayList.size() <= 0) {
                i = 0;
            } else {
                Iterator<com.baidu.adp.widget.ListView.f> it = arrayList.iterator();
                while (true) {
                    i = i2;
                    if (!it.hasNext() || it.next().getType().getId() != bd.YC.getId()) {
                        break;
                    }
                    i2 = i + 1;
                }
            }
            for (com.baidu.adp.widget.ListView.a aVar : this.mAdapters) {
                if (aVar instanceof e) {
                    ((e) aVar).jL(i);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aZ(List<com.baidu.adp.widget.ListView.a> list) {
        if (list != null) {
            for (com.baidu.adp.widget.ListView.a aVar : list) {
                if (aVar instanceof e) {
                    ((e) aVar).a(this.cGV);
                }
            }
        }
    }
}
