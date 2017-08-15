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
import com.baidu.tbadk.core.data.ax;
import com.baidu.tbadk.core.data.ay;
import com.baidu.tbadk.core.data.bl;
import com.baidu.tbadk.core.data.z;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.u;
import com.baidu.tbadk.coreExtra.message.UpdateAttentionMessage;
import com.baidu.tieba.card.data.CardHListViewData;
import com.baidu.tieba.d;
import com.baidu.tieba.frs.AbsDelegateAdapterList;
import com.baidu.tieba.frs.k;
import com.baidu.tieba.frs.n;
import com.baidu.tieba.frs.v;
import com.baidu.tieba.lego.card.model.ICardInfo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public class b implements q {
    private ArrayList<com.baidu.adp.widget.ListView.f> acP;
    private com.baidu.tieba.frs.f ckZ;
    private l cnG;
    private j cnH;
    private l cnI;
    private c cnJ;
    private com.baidu.adp.widget.ListView.a cnK;
    private n cnL;
    private p cnM;
    private g cnN;
    private com.baidu.adp.widget.ListView.a cnO;
    private com.baidu.adp.widget.ListView.a cnP;
    private d cnQ;
    private d cnR;
    private com.baidu.tieba.frs.j cnS;
    private com.baidu.tieba.frs.h.a cnT;
    private List<com.baidu.adp.widget.ListView.a> cnU;
    private m cnV;
    private i cnW;
    private h cnX;
    private final HashMap<Integer, bl> cnY;
    private com.baidu.tieba.tbadkCore.i cnZ;
    private BdTypeListView mListView;
    private List<com.baidu.adp.widget.ListView.a> mAdapters = new LinkedList();
    private boolean coa = false;
    private CustomMessageListener cob = new CustomMessageListener(CmdConfigCustom.CMD_FRS_ADD_ADAPTER) { // from class: com.baidu.tieba.frs.entelechy.a.b.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2003008 && (customResponsedMessage.getData() instanceof AbsDelegateAdapterList)) {
                AbsDelegateAdapterList absDelegateAdapterList = (AbsDelegateAdapterList) customResponsedMessage.getData();
                Iterator it = absDelegateAdapterList.iterator();
                while (it.hasNext()) {
                    com.baidu.adp.widget.ListView.a aVar = (com.baidu.adp.widget.ListView.a) it.next();
                    if (aVar instanceof com.baidu.tieba.frs.d) {
                        ((com.baidu.tieba.frs.d) aVar).a(b.this.ckZ.getPageContext(), b.this.ckZ.getUniqueId());
                    }
                }
                ArrayList arrayList = new ArrayList();
                arrayList.addAll(absDelegateAdapterList);
                b.this.aH(arrayList);
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
    private CustomMessageListener coc = new CustomMessageListener(CmdConfigCustom.CMD_LEGO_REGISTER) { // from class: com.baidu.tieba.frs.entelechy.a.b.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && u.v(b.this.cnU)) {
                b.this.ahh();
                b.this.b(b.this.acP, b.this.cnZ);
            }
        }
    };
    private CustomMessageListener aqh = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.frs.entelechy.a.b.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
            if (updateAttentionMessage != null && updateAttentionMessage.getData() != null && updateAttentionMessage.getData().Ec) {
                b.this.R(updateAttentionMessage.getData());
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
                bVar.dUe = true;
                b.this.R(bVar);
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
                bVar.dUe = false;
                b.this.R(bVar);
            }
        }
    };
    private CustomMessageListener cod = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ADCARD) { // from class: com.baidu.tieba.frs.entelechy.a.b.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.data.i)) {
                b.this.S((com.baidu.tbadk.data.i) customResponsedMessage.getData());
            }
        }
    };
    private final com.baidu.tieba.frs.c cjr = new com.baidu.tieba.frs.c();

    public b(com.baidu.tieba.frs.f fVar, BdTypeListView bdTypeListView, boolean z) {
        this.mListView = bdTypeListView;
        a(fVar, bdTypeListView);
        this.cnY = new HashMap<>();
        eR(z);
    }

    public void a(com.baidu.tieba.frs.f fVar, BdTypeListView bdTypeListView) {
        this.ckZ = fVar;
        this.cnG = new l(fVar.getPageContext(), bl.Zc, this.ckZ.getUniqueId());
        this.cnG.setVoiceManager(fVar.getVoiceManager());
        this.cnH = new j(fVar.getPageContext(), bl.Zd, this.ckZ.getUniqueId());
        this.cnI = new l(fVar.getPageContext(), bl.Ze, this.ckZ.getUniqueId());
        this.cnI.setVoiceManager(fVar.getVoiceManager());
        this.cnM = new p(fVar.getPageContext(), bl.Zf, this.ckZ.getUniqueId());
        this.cnN = new g(fVar.getPageContext(), bl.Zj, this.ckZ.getUniqueId());
        this.cnJ = new c(fVar.getPageContext(), ax.Yv, this.ckZ.getUniqueId());
        this.cnK = com.baidu.tieba.frs.a.aeX().a(fVar.getPageContext(), com.baidu.tieba.tbadkCore.p.giz, this.ckZ.getUniqueId(), false);
        this.cnS = new com.baidu.tieba.frs.j(fVar.getPageContext(), k.clC);
        this.cnL = new n(fVar.getPageContext(), ay.Yy);
        this.cnQ = new d(fVar.getPageContext(), bl.Zn, this.ckZ.getUniqueId());
        this.cnR = new d(fVar.getPageContext(), bl.Zo, this.ckZ.getUniqueId());
        this.cnO = com.baidu.tieba.frs.a.aeX().a(fVar.getPageContext(), bl.aao, this.ckZ.getUniqueId(), false);
        this.cnP = com.baidu.tieba.frs.a.aeX().b(fVar.getPageContext(), bl.aat, this.ckZ.getUniqueId());
        this.cnT = new com.baidu.tieba.frs.h.a(fVar.getPageContext(), z.WT, this.ckZ.getUniqueId());
        this.cnV = new m(fVar.getPageContext(), com.baidu.tieba.frs.p.cmf);
        this.cnW = new i(fVar.getPageContext(), bl.Zp, this.ckZ.getUniqueId());
        this.cnX = new h(fVar.getPageContext(), CardHListViewData.TYPE);
        this.mAdapters.add(this.cnX);
        this.mAdapters.add(this.cnG);
        this.mAdapters.add(this.cnH);
        this.mAdapters.add(this.cnI);
        com.baidu.tieba.InjectPlugin.b.b bVar = new com.baidu.tieba.InjectPlugin.b.b(this.ckZ, 1);
        bVar.setExtraData(this.mAdapters);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_FEED_AD_PLUGIN_OPERATE, bVar));
        this.mAdapters.add(this.cnJ);
        this.mAdapters.add(this.cnW);
        if (this.cnK != null) {
            this.mAdapters.add(this.cnK);
        }
        this.mAdapters.add(this.cnS);
        this.mAdapters.add(this.cnM);
        this.mAdapters.add(this.cnN);
        this.mAdapters.add(this.cnL);
        this.mAdapters.add(this.cnQ);
        this.mAdapters.add(this.cnR);
        this.mAdapters.add(new com.baidu.tieba.frs.u(this.ckZ.getPageContext(), v.cmu));
        this.mAdapters.add(this.cnO);
        if (this.cnP != null) {
            this.mAdapters.add(this.cnP);
        }
        this.mAdapters.add(this.cnT);
        this.mAdapters.add(this.cnV);
        com.baidu.adp.widget.ListView.a<? extends bl, ? extends j.a> b = com.baidu.tieba.frs.a.aeX().b(this.ckZ.getPageContext(), bl.aan, this.ckZ.getUniqueId());
        if (b != null) {
            this.mAdapters.add(b);
        }
        this.cob.setPriority(1);
        this.cob.setSelfListener(true);
        this.ckZ.registerListener(this.cob);
        this.ckZ.registerListener(this.aqh);
        this.ckZ.registerListener(this.mLikeForumListener);
        this.ckZ.registerListener(this.mUnlikeForumListener);
        this.ckZ.registerListener(this.cod);
        ahg();
        CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_ADD_ADAPTER, new AbsDelegateAdapterList());
        CustomMessage customMessage = new CustomMessage(CmdConfigCustom.CMD_FRS_ADD_ADAPTER);
        customMessage.setTag(this.ckZ.getUniqueId());
        customResponsedMessage.setOrginalMessage(customMessage);
        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
        aH(this.mAdapters);
        bdTypeListView.addAdapters(this.mAdapters);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void R(Object obj) {
        boolean z;
        boolean z2 = false;
        if (this.acP != null) {
            Iterator<com.baidu.adp.widget.ListView.f> it = this.acP.iterator();
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
    public void S(Object obj) {
        if (this.acP != null) {
            Iterator<com.baidu.adp.widget.ListView.f> it = this.acP.iterator();
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

    private void ahg() {
        if (this.ckZ != null && !ahh()) {
            this.ckZ.registerListener(this.coc);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean ahh() {
        if (this.ckZ == null) {
            return false;
        }
        this.cnU = new ArrayList();
        ArrayList<BdUniqueId> bsq = com.baidu.tieba.tbadkCore.n.bsq();
        if (bsq == null || bsq.size() <= 0) {
            return false;
        }
        int size = bsq.size();
        for (int i = 0; i < size; i++) {
            com.baidu.tieba.frs.d<ICardInfo, ? extends j.a> a = com.baidu.tieba.frs.a.aeX().a(this.ckZ.getPageContext(), bsq.get(i), this.ckZ.getUniqueId());
            if (a != null) {
                this.mAdapters.add(a);
                this.cnU.add(a);
            }
        }
        if (!u.v(this.cnU)) {
            this.mListView.addAdapters(this.cnU);
        }
        return true;
    }

    @Override // com.baidu.tieba.frs.entelechy.a.q
    public void onDestory() {
        for (com.baidu.adp.widget.ListView.a aVar : this.mAdapters) {
            if (aVar instanceof com.baidu.tieba.frs.d) {
                ((com.baidu.tieba.frs.d) aVar).release();
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.a.q
    public void b(ArrayList<com.baidu.adp.widget.ListView.f> arrayList, com.baidu.tieba.tbadkCore.i iVar) {
        a(iVar);
        com.baidu.tieba.tbadkCore.n.q(arrayList, 1);
        I(arrayList);
        J(arrayList);
        H(arrayList);
        this.mListView.setData(arrayList);
        this.cnZ = iVar;
        aho();
        this.acP = arrayList;
    }

    private void H(ArrayList<com.baidu.adp.widget.ListView.f> arrayList) {
        int u = u.u(arrayList);
        for (int i = 0; i < u; i++) {
            com.baidu.adp.widget.ListView.f fVar = (com.baidu.adp.widget.ListView.f) u.c(arrayList, i - 1);
            com.baidu.adp.widget.ListView.f fVar2 = (com.baidu.adp.widget.ListView.f) u.c(arrayList, i);
            if (fVar2 instanceof bl) {
                bl blVar = (bl) fVar2;
                if (i == 0) {
                    blVar.isFirstFloor = true;
                } else {
                    blVar.isFirstFloor = false;
                }
                String sd = blVar.sd();
                if (fVar instanceof com.baidu.tieba.frs.p) {
                    blVar.needTopMargin = false;
                } else if (fVar != null && !e(fVar)) {
                    blVar.needTopMargin = false;
                } else if ((fVar instanceof bl) && e(fVar) && !TextUtils.isEmpty(((bl) fVar).sd())) {
                    blVar.needTopMargin = true;
                } else if (e(fVar2) && !TextUtils.isEmpty(sd)) {
                    blVar.needTopMargin = true;
                } else {
                    blVar.needTopMargin = false;
                }
            }
        }
    }

    private boolean e(com.baidu.adp.widget.ListView.f fVar) {
        if (fVar == null) {
            return false;
        }
        BdUniqueId type = fVar.getType();
        return type == bl.Zc || type == bl.Ze || type == bl.Zf || type == bl.Zj || type == bl.Zp || type == ax.Yv || type == bl.Zn || type == bl.Zo;
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
                if (this.cnY != null && !this.cnY.containsValue(fVar)) {
                    this.cnY.put(Integer.valueOf(i2), (bl) fVar);
                }
            }
            i = i2 + 1;
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.a.q
    public void eR(boolean z) {
        if (this.coa != z) {
            this.coa = z;
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.a.q
    public HashMap<Integer, bl> ahi() {
        return this.cnY;
    }

    @Override // com.baidu.tieba.frs.entelechy.a.q
    public void ahj() {
        if (this.mListView != null && this.mListView.getData() != null && this.mListView.getData().size() != 0) {
            for (com.baidu.adp.widget.ListView.f fVar : this.mListView.getData()) {
                if ((fVar instanceof bl) && ((bl) fVar).rA() != 0) {
                    ((bl) fVar).sn();
                }
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.a.q
    public void notifyDataSetChanged() {
        if (this.mListView.getAdapter() instanceof com.baidu.adp.widget.ListView.d) {
            ((com.baidu.adp.widget.ListView.d) this.mListView.getAdapter()).notifyDataSetChanged();
        }
    }

    public void Yb() {
        if (this.mListView.getAdapter() instanceof com.baidu.adp.widget.ListView.d) {
            if (this.acP != null) {
                this.mListView.setData(this.acP);
            }
            ((com.baidu.adp.widget.ListView.d) this.mListView.getAdapter()).notifyDataSetChanged();
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.a.q
    public void setFromCDN(boolean z) {
        if (this.mAdapters != null && this.mAdapters.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.mAdapters) {
                if (aVar instanceof com.baidu.tieba.frs.d) {
                    ((com.baidu.tieba.frs.d) aVar).setFromCDN(z);
                }
            }
            if (this.cnG != null) {
                this.cnG.setFromCDN(z);
            }
            if (this.cnI != null) {
                this.cnI.setFromCDN(z);
            }
            if (this.cnQ != null) {
                this.cnQ.setFromCDN(z);
            }
            if (this.cnR != null) {
                this.cnR.setFromCDN(z);
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

    @Override // com.baidu.tieba.frs.entelechy.a.q
    public void a(com.baidu.tieba.frs.b bVar) {
        if (this.mAdapters != null && this.mAdapters.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.mAdapters) {
                if (aVar instanceof com.baidu.tieba.frs.d) {
                    ((com.baidu.tieba.frs.d) aVar).a(bVar);
                }
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.a.q
    public int ahk() {
        if (this.cnK != null) {
            return d.h.frs_fortune_bag_item;
        }
        return 0;
    }

    @Override // com.baidu.tieba.frs.entelechy.a.q
    public int ahl() {
        if (this.cnK != null) {
            return d.h.frs_my_service_item;
        }
        return 0;
    }

    @Override // com.baidu.tieba.frs.entelechy.a.q
    public int ahm() {
        if (this.cnK != null) {
            return d.h.frs_bawu_center;
        }
        return 0;
    }

    @Override // com.baidu.tieba.frs.entelechy.a.q
    public int ahn() {
        if (this.cnL != null) {
            return this.cnL.agx();
        }
        return 0;
    }

    @Override // com.baidu.tieba.frs.entelechy.a.q
    public int agy() {
        if (this.cnL != null) {
            return this.cnL.agy();
        }
        return 0;
    }

    @Override // com.baidu.tieba.frs.entelechy.a.q
    public boolean k(BdUniqueId bdUniqueId) {
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

    @Override // com.baidu.tieba.frs.entelechy.a.q
    public void setOnAdapterItemClickListener(com.baidu.adp.widget.ListView.h hVar) {
        if (this.mAdapters != null && this.mAdapters.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.mAdapters) {
                if (aVar instanceof com.baidu.tieba.frs.d) {
                    ((com.baidu.tieba.frs.d) aVar).setOnAdapterItemClickListener(hVar);
                } else if ((aVar instanceof l) || (aVar instanceof c) || (aVar instanceof f) || (aVar instanceof d) || (aVar instanceof p)) {
                    aVar.setOnAdapterItemClickListener(hVar);
                } else if (aVar != null && aVar.getType() == bl.aan) {
                    aVar.setOnAdapterItemClickListener(hVar);
                }
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.a.q
    public void setForumName(String str) {
        if (this.mAdapters != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.mAdapters) {
                if (aVar instanceof com.baidu.tieba.card.v) {
                    ((com.baidu.tieba.card.v) aVar).setForumName(str);
                }
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.a.q
    public void cH(boolean z) {
        if (this.mAdapters != null && this.mAdapters.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.mAdapters) {
                if (aVar instanceof com.baidu.tieba.frs.d) {
                    ((com.baidu.tieba.frs.d) aVar).cH(z);
                }
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.a.q
    public void reInit() {
        if (this.mAdapters != null && this.mAdapters.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.mAdapters) {
                if (aVar instanceof com.baidu.tieba.frs.d) {
                    ((com.baidu.tieba.frs.d) aVar).a(this.ckZ.getPageContext(), this.ckZ.getUniqueId());
                }
            }
            aH(this.mAdapters);
        }
    }

    private void aho() {
        if (this.cnZ != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.mAdapters) {
                if (aVar instanceof com.baidu.tieba.frs.e.c) {
                    com.baidu.tieba.frs.e.c cVar = (com.baidu.tieba.frs.e.c) aVar;
                    if (com.baidu.tieba.frs.e.c.cxO != null) {
                        if (this.cnZ.ghi == 1) {
                            com.baidu.tieba.frs.e.c.cxO.cxE = true;
                        } else {
                            com.baidu.tieba.frs.e.c.cxO.cxE = false;
                        }
                        if (this.cnZ.aPO() != null) {
                            com.baidu.tieba.frs.e.c.cxO.cxG = this.cnZ.aPO().getId();
                        }
                        if (this.ckZ != null && this.ckZ.afq() != null) {
                            com.baidu.tieba.frs.e.c.cxO.cxF = this.ckZ.afq().ajl();
                        }
                    }
                }
            }
            ahp();
        }
    }

    private void ahp() {
        com.baidu.tieba.frs.e.a aVar = new com.baidu.tieba.frs.e.a();
        if (this.cnZ.ghi == 1) {
            aVar.cxE = true;
        } else {
            aVar.cxE = false;
        }
        if (this.cnZ.aPO() != null) {
            aVar.cxG = this.cnZ.aPO().getId();
        }
        if (this.ckZ != null && this.ckZ.afq() != null) {
            aVar.cxF = this.ckZ.afq().ajl();
        }
        com.baidu.tieba.frs.c.b bVar = new com.baidu.tieba.frs.c.b(aVar);
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

    @Override // com.baidu.tieba.frs.entelechy.a.q
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
                    if (!it.hasNext() || it.next().getType().getId() != bl.Zb.getId()) {
                        break;
                    }
                    i2 = i + 1;
                }
            }
            for (com.baidu.adp.widget.ListView.a aVar : this.mAdapters) {
                if (aVar instanceof com.baidu.tieba.frs.d) {
                    ((com.baidu.tieba.frs.d) aVar).iB(i);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aH(List<com.baidu.adp.widget.ListView.a> list) {
        if (list != null) {
            for (com.baidu.adp.widget.ListView.a aVar : list) {
                if (aVar instanceof com.baidu.tieba.frs.d) {
                    ((com.baidu.tieba.frs.d) aVar).a(this.cjr);
                }
            }
        }
    }
}
