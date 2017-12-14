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
    private ArrayList<com.baidu.adp.widget.ListView.f> acy;
    private com.baidu.tieba.frs.g cIy;
    private l cMN;
    private j cMO;
    private p cMP;
    private l cMQ;
    private c cMR;
    private com.baidu.adp.widget.ListView.a cMS;
    private o cMT;
    private t cMU;
    private g cMV;
    private com.baidu.adp.widget.ListView.a cMW;
    private com.baidu.adp.widget.ListView.a cMX;
    private d cMY;
    private d cMZ;
    private k cNa;
    private List<com.baidu.adp.widget.ListView.a> cNb;
    private m cNc;
    private i cNd;
    private h cNe;
    private q cNf;
    private r cNg;
    private final HashMap<Integer, bd> cNh;
    private com.baidu.tieba.tbadkCore.k cNi;
    private BdTypeListView mListView;
    private List<com.baidu.adp.widget.ListView.a> mAdapters = new LinkedList();
    private boolean cNj = false;
    private CustomMessageListener cNk = new CustomMessageListener(CmdConfigCustom.CMD_FRS_ADD_ADAPTER) { // from class: com.baidu.tieba.frs.entelechy.a.b.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2003008 && (customResponsedMessage.getData() instanceof AbsDelegateAdapterList)) {
                AbsDelegateAdapterList absDelegateAdapterList = (AbsDelegateAdapterList) customResponsedMessage.getData();
                Iterator it = absDelegateAdapterList.iterator();
                while (it.hasNext()) {
                    com.baidu.adp.widget.ListView.a aVar = (com.baidu.adp.widget.ListView.a) it.next();
                    if (aVar instanceof e) {
                        ((e) aVar).a(b.this.cIy.getPageContext(), b.this.cIy.getUniqueId());
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
    private CustomMessageListener cNl = new CustomMessageListener(CmdConfigCustom.CMD_LEGO_REGISTER) { // from class: com.baidu.tieba.frs.entelechy.a.b.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && v.w(b.this.cNb)) {
                b.this.anB();
                b.this.b(b.this.acy, b.this.cNi);
            }
        }
    };
    private CustomMessageListener mAttentionListener = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.frs.entelechy.a.b.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
            if (updateAttentionMessage != null && updateAttentionMessage.getData() != null && updateAttentionMessage.getData().BI) {
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
                bVar.emp = true;
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
                bVar.emp = false;
                b.this.S(bVar);
            }
        }
    };
    private CustomMessageListener cNm = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ADCARD) { // from class: com.baidu.tieba.frs.entelechy.a.b.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.data.j)) {
                b.this.T((com.baidu.tbadk.data.j) customResponsedMessage.getData());
            }
        }
    };
    private final com.baidu.tieba.frs.c cGR = new com.baidu.tieba.frs.c();

    public b(com.baidu.tieba.frs.g gVar, BdTypeListView bdTypeListView, boolean z) {
        this.mListView = bdTypeListView;
        a(gVar, bdTypeListView);
        this.cNh = new HashMap<>();
        fj(z);
    }

    public void a(com.baidu.tieba.frs.g gVar, BdTypeListView bdTypeListView) {
        this.cIy = gVar;
        this.cMN = new l(gVar.getPageContext(), bd.YA, this.cIy.getUniqueId());
        this.cMN.setVoiceManager(gVar.getVoiceManager());
        this.cMO = new j(gVar.getPageContext(), bd.YB, this.cIy.getUniqueId());
        this.cMP = new p(gVar.getPageContext(), bd.YH, this.cIy.getUniqueId());
        this.cMQ = new l(gVar.getPageContext(), bd.YC, this.cIy.getUniqueId());
        this.cMQ.setVoiceManager(gVar.getVoiceManager());
        this.cMU = new t(gVar.getPageContext(), bd.YD, this.cIy.getUniqueId());
        this.cMV = new g(gVar.getPageContext(), bd.YI, this.cIy.getUniqueId());
        this.cMR = new c(gVar.getPageContext(), ar.XX, this.cIy.getUniqueId());
        this.cMS = com.baidu.tieba.frs.a.akP().a(gVar.getPageContext(), com.baidu.tieba.tbadkCore.r.gAI, this.cIy.getUniqueId(), false);
        this.cNa = new k(gVar.getPageContext(), com.baidu.tieba.frs.l.cJg);
        this.cMT = new o(gVar.getPageContext(), as.Ya);
        this.cMY = new d(gVar.getPageContext(), bd.YM, this.cIy.getUniqueId());
        this.cMZ = new d(gVar.getPageContext(), bd.YN, this.cIy.getUniqueId());
        this.cMW = com.baidu.tieba.frs.a.akP().a(gVar.getPageContext(), bd.ZO, this.cIy.getUniqueId(), true);
        this.cMX = com.baidu.tieba.frs.a.akP().b(gVar.getPageContext(), bd.ZT, this.cIy.getUniqueId());
        this.cNc = new m(gVar.getPageContext(), com.baidu.tieba.frs.q.cJH);
        this.cNd = new i(gVar.getPageContext(), bd.YO, this.cIy.getUniqueId());
        this.cNe = new h(gVar.getPageContext(), CardHListViewData.TYPE);
        this.cNf = new q(gVar.getPageContext(), com.baidu.tieba.frs.r.cJN, this.cIy.getUniqueId());
        this.cNg = new r(gVar.getPageContext().getPageActivity(), com.baidu.tieba.tbadkCore.j.gAx, this.cIy.getUniqueId());
        this.mAdapters.add(this.cNg);
        this.mAdapters.add(this.cNe);
        this.mAdapters.add(this.cMN);
        this.mAdapters.add(this.cMO);
        this.mAdapters.add(this.cMP);
        this.mAdapters.add(this.cMQ);
        this.mAdapters.add(this.cNf);
        com.baidu.tieba.InjectPlugin.b.b bVar = new com.baidu.tieba.InjectPlugin.b.b(this.cIy, 1);
        bVar.setExtraData(this.mAdapters);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_FEED_AD_PLUGIN_OPERATE, bVar));
        this.mAdapters.add(this.cMR);
        this.mAdapters.add(this.cNd);
        if (this.cMS != null) {
            this.mAdapters.add(this.cMS);
        }
        this.mAdapters.add(this.cNa);
        this.mAdapters.add(this.cMU);
        this.mAdapters.add(this.cMV);
        this.mAdapters.add(this.cMT);
        this.mAdapters.add(this.cMY);
        this.mAdapters.add(this.cMZ);
        this.mAdapters.add(new w(this.cIy.getPageContext(), x.cKb));
        this.mAdapters.add(this.cMW);
        if (this.cMX != null) {
            this.mAdapters.add(this.cMX);
        }
        this.mAdapters.add(this.cNc);
        com.baidu.adp.widget.ListView.a<? extends bd, ? extends j.a> b = com.baidu.tieba.frs.a.akP().b(this.cIy.getPageContext(), bd.ZN, this.cIy.getUniqueId());
        if (b != null) {
            this.mAdapters.add(b);
        }
        this.cNk.setPriority(1);
        this.cNk.setSelfListener(true);
        this.cIy.registerListener(this.cNk);
        this.cIy.registerListener(this.mAttentionListener);
        this.cIy.registerListener(this.mLikeForumListener);
        this.cIy.registerListener(this.mUnlikeForumListener);
        this.cIy.registerListener(this.cNm);
        anA();
        CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_ADD_ADAPTER, new AbsDelegateAdapterList());
        CustomMessage customMessage = new CustomMessage(CmdConfigCustom.CMD_FRS_ADD_ADAPTER);
        customMessage.setTag(this.cIy.getUniqueId());
        customResponsedMessage.setOrginalMessage(customMessage);
        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
        aZ(this.mAdapters);
        bdTypeListView.addAdapters(this.mAdapters);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void S(Object obj) {
        boolean z;
        boolean z2 = false;
        if (this.acy != null) {
            Iterator<com.baidu.adp.widget.ListView.f> it = this.acy.iterator();
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
        if (this.acy != null) {
            Iterator<com.baidu.adp.widget.ListView.f> it = this.acy.iterator();
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
        if (this.cIy != null && !anB()) {
            this.cIy.registerListener(this.cNl);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean anB() {
        if (this.cIy == null) {
            return false;
        }
        this.cNb = new ArrayList();
        ArrayList<BdUniqueId> bwg = com.baidu.tieba.tbadkCore.p.bwg();
        if (bwg == null || bwg.size() <= 0) {
            return false;
        }
        int size = bwg.size();
        for (int i = 0; i < size; i++) {
            e<ICardInfo, ? extends j.a> a = com.baidu.tieba.frs.a.akP().a(this.cIy.getPageContext(), bwg.get(i), this.cIy.getUniqueId());
            if (a != null) {
                this.mAdapters.add(a);
                this.cNb.add(a);
            }
        }
        if (!v.w(this.cNb)) {
            this.mListView.addAdapters(this.cNb);
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
        this.cNi = kVar;
        anK();
        anC();
        this.acy = arrayList;
    }

    private void anC() {
        if (this.cNi != null && this.cNi.aRo() != null && !StringUtils.isNull(this.cNi.aRo().getId()) && this.cNg != null) {
            this.cNg.setForumId(this.cNi.aRo().getId());
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
        return type == bd.YA || type == bd.YC || type == bd.YD || type == bd.YI || type == bd.YO || type == ar.XX || type == bd.YM || type == bd.YN;
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
                if (this.cNh != null && !this.cNh.containsValue(fVar)) {
                    this.cNh.put(Integer.valueOf(i2), (bd) fVar);
                }
            }
            i = i2 + 1;
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.a.u
    public void fj(boolean z) {
        if (this.cNj != z) {
            this.cNj = z;
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.a.u
    public HashMap<Integer, bd> anD() {
        return this.cNh;
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

    public void adg() {
        if (this.mListView.getAdapter() instanceof com.baidu.adp.widget.ListView.d) {
            if (this.acy != null) {
                this.mListView.setData(this.acy);
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
            if (this.cMN != null) {
                this.cMN.setFromCDN(z);
            }
            if (this.cMQ != null) {
                this.cMQ.setFromCDN(z);
            }
            if (this.cMY != null) {
                this.cMY.setFromCDN(z);
            }
            if (this.cMZ != null) {
                this.cMZ.setFromCDN(z);
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
        if (this.cMS != null) {
            return d.g.frs_fortune_bag_item;
        }
        return 0;
    }

    @Override // com.baidu.tieba.frs.entelechy.a.u
    public int anG() {
        if (this.cMS != null) {
            return d.g.frs_my_service_item;
        }
        return 0;
    }

    @Override // com.baidu.tieba.frs.entelechy.a.u
    public int anH() {
        if (this.cMS != null) {
            return d.g.frs_bawu_center;
        }
        return 0;
    }

    @Override // com.baidu.tieba.frs.entelechy.a.u
    public int anI() {
        if (this.cMT != null) {
            return this.cMT.ams();
        }
        return 0;
    }

    @Override // com.baidu.tieba.frs.entelechy.a.u
    public int amt() {
        if (this.cMT != null) {
            return this.cMT.amt();
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
                } else if (aVar != null && aVar.getType() == bd.ZN) {
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
                    ((e) aVar).a(this.cIy.getPageContext(), this.cIy.getUniqueId());
                }
            }
            aZ(this.mAdapters);
        }
    }

    private void anK() {
        if (this.cNi != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.mAdapters) {
                if (aVar instanceof com.baidu.tieba.frs.e.c) {
                    com.baidu.tieba.frs.e.c cVar = (com.baidu.tieba.frs.e.c) aVar;
                    if (com.baidu.tieba.frs.e.c.cYY != null) {
                        if (this.cNi.gzl == 1) {
                            com.baidu.tieba.frs.e.c.cYY.cYO = true;
                        } else {
                            com.baidu.tieba.frs.e.c.cYY.cYO = false;
                        }
                        if (this.cNi.aRo() != null) {
                            com.baidu.tieba.frs.e.c.cYY.cYQ = this.cNi.aRo().getId();
                        }
                        if (this.cIy != null && this.cIy.alj() != null) {
                            com.baidu.tieba.frs.e.c.cYY.cYP = this.cIy.alj().aqb();
                        }
                    }
                }
            }
            anL();
        }
    }

    private void anL() {
        com.baidu.tieba.frs.e.a aVar = new com.baidu.tieba.frs.e.a();
        if (this.cNi.gzl == 1) {
            aVar.cYO = true;
        } else {
            aVar.cYO = false;
        }
        if (this.cNi.aRo() != null) {
            aVar.cYQ = this.cNi.aRo().getId();
        }
        if (this.cIy != null && this.cIy.alj() != null) {
            aVar.cYP = this.cIy.alj().aqb();
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
                    if (!it.hasNext() || it.next().getType().getId() != bd.Yz.getId()) {
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
                    ((e) aVar).a(this.cGR);
                }
            }
        }
    }
}
