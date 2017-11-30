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
import com.baidu.tieba.frs.n;
import com.baidu.tieba.frs.w;
import com.baidu.tieba.lego.card.model.ICardInfo;
import com.baidu.tieba.tbadkCore.k;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public class b implements u {
    private ArrayList<com.baidu.adp.widget.ListView.f> acE;
    private com.baidu.tieba.frs.f cIp;
    private l cMC;
    private j cMD;
    private p cME;
    private l cMF;
    private c cMG;
    private com.baidu.adp.widget.ListView.a cMH;
    private n cMI;
    private t cMJ;
    private g cMK;
    private com.baidu.adp.widget.ListView.a cML;
    private com.baidu.adp.widget.ListView.a cMM;
    private d cMN;
    private d cMO;
    private com.baidu.tieba.frs.j cMP;
    private List<com.baidu.adp.widget.ListView.a> cMQ;
    private m cMR;
    private i cMS;
    private h cMT;
    private q cMU;
    private r cMV;
    private final HashMap<Integer, bd> cMW;
    private k cMX;
    private BdTypeListView mListView;
    private List<com.baidu.adp.widget.ListView.a> mAdapters = new LinkedList();
    private boolean cMY = false;
    private CustomMessageListener cMZ = new CustomMessageListener(CmdConfigCustom.CMD_FRS_ADD_ADAPTER) { // from class: com.baidu.tieba.frs.entelechy.a.b.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2003008 && (customResponsedMessage.getData() instanceof AbsDelegateAdapterList)) {
                AbsDelegateAdapterList absDelegateAdapterList = (AbsDelegateAdapterList) customResponsedMessage.getData();
                Iterator it = absDelegateAdapterList.iterator();
                while (it.hasNext()) {
                    com.baidu.adp.widget.ListView.a aVar = (com.baidu.adp.widget.ListView.a) it.next();
                    if (aVar instanceof com.baidu.tieba.frs.d) {
                        ((com.baidu.tieba.frs.d) aVar).a(b.this.cIp.getPageContext(), b.this.cIp.getUniqueId());
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
    private CustomMessageListener cNa = new CustomMessageListener(CmdConfigCustom.CMD_LEGO_REGISTER) { // from class: com.baidu.tieba.frs.entelechy.a.b.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && v.w(b.this.cMQ)) {
                b.this.ans();
                b.this.b(b.this.acE, b.this.cMX);
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
                bVar.elk = true;
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
                bVar.elk = false;
                b.this.S(bVar);
            }
        }
    };
    private CustomMessageListener cNb = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ADCARD) { // from class: com.baidu.tieba.frs.entelechy.a.b.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.data.j)) {
                b.this.T((com.baidu.tbadk.data.j) customResponsedMessage.getData());
            }
        }
    };
    private final com.baidu.tieba.frs.c cGJ = new com.baidu.tieba.frs.c();

    public b(com.baidu.tieba.frs.f fVar, BdTypeListView bdTypeListView, boolean z) {
        this.mListView = bdTypeListView;
        a(fVar, bdTypeListView);
        this.cMW = new HashMap<>();
        fi(z);
    }

    public void a(com.baidu.tieba.frs.f fVar, BdTypeListView bdTypeListView) {
        this.cIp = fVar;
        this.cMC = new l(fVar.getPageContext(), bd.YG, this.cIp.getUniqueId());
        this.cMC.setVoiceManager(fVar.getVoiceManager());
        this.cMD = new j(fVar.getPageContext(), bd.YH, this.cIp.getUniqueId());
        this.cME = new p(fVar.getPageContext(), bd.YN, this.cIp.getUniqueId());
        this.cMF = new l(fVar.getPageContext(), bd.YI, this.cIp.getUniqueId());
        this.cMF.setVoiceManager(fVar.getVoiceManager());
        this.cMJ = new t(fVar.getPageContext(), bd.YJ, this.cIp.getUniqueId());
        this.cMK = new g(fVar.getPageContext(), bd.YO, this.cIp.getUniqueId());
        this.cMG = new c(fVar.getPageContext(), ar.Yd, this.cIp.getUniqueId());
        this.cMH = com.baidu.tieba.frs.a.akH().a(fVar.getPageContext(), com.baidu.tieba.tbadkCore.r.gxZ, this.cIp.getUniqueId(), false);
        this.cMP = new com.baidu.tieba.frs.j(fVar.getPageContext(), com.baidu.tieba.frs.k.cIW);
        this.cMI = new n(fVar.getPageContext(), as.Yg);
        this.cMN = new d(fVar.getPageContext(), bd.YS, this.cIp.getUniqueId());
        this.cMO = new d(fVar.getPageContext(), bd.YT, this.cIp.getUniqueId());
        this.cML = com.baidu.tieba.frs.a.akH().a(fVar.getPageContext(), bd.ZU, this.cIp.getUniqueId(), true);
        this.cMM = com.baidu.tieba.frs.a.akH().b(fVar.getPageContext(), bd.ZZ, this.cIp.getUniqueId());
        this.cMR = new m(fVar.getPageContext(), com.baidu.tieba.frs.p.cJx);
        this.cMS = new i(fVar.getPageContext(), bd.YU, this.cIp.getUniqueId());
        this.cMT = new h(fVar.getPageContext(), CardHListViewData.TYPE);
        this.cMU = new q(fVar.getPageContext(), com.baidu.tieba.frs.q.cJD, this.cIp.getUniqueId());
        this.cMV = new r(fVar.getPageContext().getPageActivity(), com.baidu.tieba.tbadkCore.j.gxO, this.cIp.getUniqueId());
        this.mAdapters.add(this.cMV);
        this.mAdapters.add(this.cMT);
        this.mAdapters.add(this.cMC);
        this.mAdapters.add(this.cMD);
        this.mAdapters.add(this.cME);
        this.mAdapters.add(this.cMF);
        this.mAdapters.add(this.cMU);
        com.baidu.tieba.InjectPlugin.b.b bVar = new com.baidu.tieba.InjectPlugin.b.b(this.cIp, 1);
        bVar.setExtraData(this.mAdapters);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_FEED_AD_PLUGIN_OPERATE, bVar));
        this.mAdapters.add(this.cMG);
        this.mAdapters.add(this.cMS);
        if (this.cMH != null) {
            this.mAdapters.add(this.cMH);
        }
        this.mAdapters.add(this.cMP);
        this.mAdapters.add(this.cMJ);
        this.mAdapters.add(this.cMK);
        this.mAdapters.add(this.cMI);
        this.mAdapters.add(this.cMN);
        this.mAdapters.add(this.cMO);
        this.mAdapters.add(new com.baidu.tieba.frs.v(this.cIp.getPageContext(), w.cJR));
        this.mAdapters.add(this.cML);
        if (this.cMM != null) {
            this.mAdapters.add(this.cMM);
        }
        this.mAdapters.add(this.cMR);
        com.baidu.adp.widget.ListView.a<? extends bd, ? extends j.a> b = com.baidu.tieba.frs.a.akH().b(this.cIp.getPageContext(), bd.ZT, this.cIp.getUniqueId());
        if (b != null) {
            this.mAdapters.add(b);
        }
        this.cMZ.setPriority(1);
        this.cMZ.setSelfListener(true);
        this.cIp.registerListener(this.cMZ);
        this.cIp.registerListener(this.mAttentionListener);
        this.cIp.registerListener(this.mLikeForumListener);
        this.cIp.registerListener(this.mUnlikeForumListener);
        this.cIp.registerListener(this.cNb);
        anr();
        CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_ADD_ADAPTER, new AbsDelegateAdapterList());
        CustomMessage customMessage = new CustomMessage(CmdConfigCustom.CMD_FRS_ADD_ADAPTER);
        customMessage.setTag(this.cIp.getUniqueId());
        customResponsedMessage.setOrginalMessage(customMessage);
        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
        aZ(this.mAdapters);
        bdTypeListView.addAdapters(this.mAdapters);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void S(Object obj) {
        boolean z;
        boolean z2 = false;
        if (this.acE != null) {
            Iterator<com.baidu.adp.widget.ListView.f> it = this.acE.iterator();
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
        if (this.acE != null) {
            Iterator<com.baidu.adp.widget.ListView.f> it = this.acE.iterator();
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

    private void anr() {
        if (this.cIp != null && !ans()) {
            this.cIp.registerListener(this.cNa);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean ans() {
        if (this.cIp == null) {
            return false;
        }
        this.cMQ = new ArrayList();
        ArrayList<BdUniqueId> bvz = com.baidu.tieba.tbadkCore.p.bvz();
        if (bvz == null || bvz.size() <= 0) {
            return false;
        }
        int size = bvz.size();
        for (int i = 0; i < size; i++) {
            com.baidu.tieba.frs.d<ICardInfo, ? extends j.a> a = com.baidu.tieba.frs.a.akH().a(this.cIp.getPageContext(), bvz.get(i), this.cIp.getUniqueId());
            if (a != null) {
                this.mAdapters.add(a);
                this.cMQ.add(a);
            }
        }
        if (!v.w(this.cMQ)) {
            this.mListView.addAdapters(this.cMQ);
        }
        return true;
    }

    @Override // com.baidu.tieba.frs.entelechy.a.u
    public void onDestory() {
        for (com.baidu.adp.widget.ListView.a aVar : this.mAdapters) {
            if (aVar instanceof com.baidu.tieba.frs.d) {
                ((com.baidu.tieba.frs.d) aVar).release();
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.a.u
    public void b(ArrayList<com.baidu.adp.widget.ListView.f> arrayList, k kVar) {
        a(kVar);
        com.baidu.tieba.tbadkCore.p.p(arrayList, 1);
        J(arrayList);
        K(arrayList);
        I(arrayList);
        this.mListView.setData(arrayList);
        this.cMX = kVar;
        anB();
        ant();
        this.acE = arrayList;
    }

    private void ant() {
        if (this.cMX != null && this.cMX.aRf() != null && !StringUtils.isNull(this.cMX.aRf().getId()) && this.cMV != null) {
            this.cMV.setForumId(this.cMX.aRf().getId());
        }
    }

    private void I(ArrayList<com.baidu.adp.widget.ListView.f> arrayList) {
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
                String rW = bdVar.rW();
                if (fVar instanceof com.baidu.tieba.frs.p) {
                    bdVar.needTopMargin = false;
                } else if (fVar != null && !e(fVar)) {
                    bdVar.needTopMargin = false;
                } else if ((fVar instanceof bd) && e(fVar) && !TextUtils.isEmpty(((bd) fVar).rW())) {
                    bdVar.needTopMargin = true;
                } else if (e(fVar2) && !TextUtils.isEmpty(rW)) {
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
        return type == bd.YG || type == bd.YI || type == bd.YJ || type == bd.YO || type == bd.YU || type == ar.Yd || type == bd.YS || type == bd.YT;
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
                if (this.cMW != null && !this.cMW.containsValue(fVar)) {
                    this.cMW.put(Integer.valueOf(i2), (bd) fVar);
                }
            }
            i = i2 + 1;
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.a.u
    public void fi(boolean z) {
        if (this.cMY != z) {
            this.cMY = z;
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.a.u
    public HashMap<Integer, bd> anu() {
        return this.cMW;
    }

    @Override // com.baidu.tieba.frs.entelechy.a.u
    public void anv() {
        if (this.mListView != null && this.mListView.getData() != null && this.mListView.getData().size() != 0) {
            for (com.baidu.adp.widget.ListView.f fVar : this.mListView.getData()) {
                if ((fVar instanceof bd) && ((bd) fVar).rs() != 0) {
                    ((bd) fVar).sf();
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

    public void acW() {
        if (this.mListView.getAdapter() instanceof com.baidu.adp.widget.ListView.d) {
            if (this.acE != null) {
                this.mListView.setData(this.acE);
            }
            ((com.baidu.adp.widget.ListView.d) this.mListView.getAdapter()).notifyDataSetChanged();
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.a.u
    public void setFromCDN(boolean z) {
        if (this.mAdapters != null && this.mAdapters.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.mAdapters) {
                if (aVar instanceof com.baidu.tieba.frs.d) {
                    ((com.baidu.tieba.frs.d) aVar).setFromCDN(z);
                }
            }
            if (this.cMC != null) {
                this.cMC.setFromCDN(z);
            }
            if (this.cMF != null) {
                this.cMF.setFromCDN(z);
            }
            if (this.cMN != null) {
                this.cMN.setFromCDN(z);
            }
            if (this.cMO != null) {
                this.cMO.setFromCDN(z);
            }
        }
    }

    public void a(k kVar) {
        if (this.mAdapters != null && this.mAdapters.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.mAdapters) {
                if (aVar instanceof com.baidu.tieba.frs.d) {
                    ((com.baidu.tieba.frs.d) aVar).a(kVar);
                }
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.a.u
    public void a(com.baidu.tieba.frs.b bVar) {
        if (this.mAdapters != null && this.mAdapters.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.mAdapters) {
                if (aVar instanceof com.baidu.tieba.frs.d) {
                    ((com.baidu.tieba.frs.d) aVar).a(bVar);
                }
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.a.u
    public int anw() {
        if (this.cMH != null) {
            return d.g.frs_fortune_bag_item;
        }
        return 0;
    }

    @Override // com.baidu.tieba.frs.entelechy.a.u
    public int anx() {
        if (this.cMH != null) {
            return d.g.frs_my_service_item;
        }
        return 0;
    }

    @Override // com.baidu.tieba.frs.entelechy.a.u
    public int any() {
        if (this.cMH != null) {
            return d.g.frs_bawu_center;
        }
        return 0;
    }

    @Override // com.baidu.tieba.frs.entelechy.a.u
    public int anz() {
        if (this.cMI != null) {
            return this.cMI.amj();
        }
        return 0;
    }

    @Override // com.baidu.tieba.frs.entelechy.a.u
    public int amk() {
        if (this.cMI != null) {
            return this.cMI.amk();
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
                if (aVar instanceof com.baidu.tieba.frs.d) {
                    ((com.baidu.tieba.frs.d) aVar).setOnAdapterItemClickListener(hVar);
                } else if ((aVar instanceof l) || (aVar instanceof c) || (aVar instanceof f) || (aVar instanceof d) || (aVar instanceof t)) {
                    aVar.setOnAdapterItemClickListener(hVar);
                } else if (aVar != null && aVar.getType() == bd.ZT) {
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
    public void cM(boolean z) {
        if (this.mAdapters != null && this.mAdapters.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.mAdapters) {
                if (aVar instanceof com.baidu.tieba.frs.d) {
                    ((com.baidu.tieba.frs.d) aVar).cM(z);
                }
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.a.u
    public void anA() {
        if (this.mAdapters != null && this.mAdapters.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.mAdapters) {
                if (aVar instanceof com.baidu.tieba.frs.d) {
                    ((com.baidu.tieba.frs.d) aVar).a(this.cIp.getPageContext(), this.cIp.getUniqueId());
                }
            }
            aZ(this.mAdapters);
        }
    }

    private void anB() {
        if (this.cMX != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.mAdapters) {
                if (aVar instanceof com.baidu.tieba.frs.e.c) {
                    com.baidu.tieba.frs.e.c cVar = (com.baidu.tieba.frs.e.c) aVar;
                    if (com.baidu.tieba.frs.e.c.cYM != null) {
                        if (this.cMX.gwD == 1) {
                            com.baidu.tieba.frs.e.c.cYM.cYC = true;
                        } else {
                            com.baidu.tieba.frs.e.c.cYM.cYC = false;
                        }
                        if (this.cMX.aRf() != null) {
                            com.baidu.tieba.frs.e.c.cYM.cYE = this.cMX.aRf().getId();
                        }
                        if (this.cIp != null && this.cIp.akZ() != null) {
                            com.baidu.tieba.frs.e.c.cYM.cYD = this.cIp.akZ().apS();
                        }
                    }
                }
            }
            anC();
        }
    }

    private void anC() {
        com.baidu.tieba.frs.e.a aVar = new com.baidu.tieba.frs.e.a();
        if (this.cMX.gwD == 1) {
            aVar.cYC = true;
        } else {
            aVar.cYC = false;
        }
        if (this.cMX.aRf() != null) {
            aVar.cYE = this.cMX.aRf().getId();
        }
        if (this.cIp != null && this.cIp.akZ() != null) {
            aVar.cYD = this.cIp.akZ().apS();
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
                    if (!it.hasNext() || it.next().getType().getId() != bd.YF.getId()) {
                        break;
                    }
                    i2 = i + 1;
                }
            }
            for (com.baidu.adp.widget.ListView.a aVar : this.mAdapters) {
                if (aVar instanceof com.baidu.tieba.frs.d) {
                    ((com.baidu.tieba.frs.d) aVar).jJ(i);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aZ(List<com.baidu.adp.widget.ListView.a> list) {
        if (list != null) {
            for (com.baidu.adp.widget.ListView.a aVar : list) {
                if (aVar instanceof com.baidu.tieba.frs.d) {
                    ((com.baidu.tieba.frs.d) aVar).a(this.cGJ);
                }
            }
        }
    }
}
