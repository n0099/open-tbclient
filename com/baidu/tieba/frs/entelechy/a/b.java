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
    private c cDA;
    private com.baidu.adp.widget.ListView.a cDB;
    private n cDC;
    private s cDD;
    private g cDE;
    private com.baidu.adp.widget.ListView.a cDF;
    private com.baidu.adp.widget.ListView.a cDG;
    private d cDH;
    private d cDI;
    private com.baidu.tieba.frs.j cDJ;
    private com.baidu.tieba.frs.h.a cDK;
    private List<com.baidu.adp.widget.ListView.a> cDL;
    private m cDM;
    private i cDN;
    private h cDO;
    private p cDP;
    private q cDQ;
    private final HashMap<Integer, bh> cDR;
    private com.baidu.tieba.tbadkCore.j cDS;
    private l cDx;
    private j cDy;
    private l cDz;
    private com.baidu.tieba.frs.f czk;
    private BdTypeListView mListView;
    private List<com.baidu.adp.widget.ListView.a> mAdapters = new LinkedList();
    private boolean cDT = false;
    private CustomMessageListener cDU = new CustomMessageListener(CmdConfigCustom.CMD_FRS_ADD_ADAPTER) { // from class: com.baidu.tieba.frs.entelechy.a.b.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2003008 && (customResponsedMessage.getData() instanceof AbsDelegateAdapterList)) {
                AbsDelegateAdapterList absDelegateAdapterList = (AbsDelegateAdapterList) customResponsedMessage.getData();
                Iterator it = absDelegateAdapterList.iterator();
                while (it.hasNext()) {
                    com.baidu.adp.widget.ListView.a aVar = (com.baidu.adp.widget.ListView.a) it.next();
                    if (aVar instanceof com.baidu.tieba.frs.d) {
                        ((com.baidu.tieba.frs.d) aVar).a(b.this.czk.getPageContext(), b.this.czk.getUniqueId());
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
    private CustomMessageListener cDV = new CustomMessageListener(CmdConfigCustom.CMD_LEGO_REGISTER) { // from class: com.baidu.tieba.frs.entelechy.a.b.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && v.v(b.this.cDL)) {
                b.this.alx();
                b.this.b(b.this.acj, b.this.cDS);
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
                bVar.eft = true;
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
                bVar.eft = false;
                b.this.S(bVar);
            }
        }
    };
    private CustomMessageListener cDW = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ADCARD) { // from class: com.baidu.tieba.frs.entelechy.a.b.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.data.j)) {
                b.this.T((com.baidu.tbadk.data.j) customResponsedMessage.getData());
            }
        }
    };
    private final com.baidu.tieba.frs.c cxD = new com.baidu.tieba.frs.c();

    public b(com.baidu.tieba.frs.f fVar, BdTypeListView bdTypeListView, boolean z) {
        this.mListView = bdTypeListView;
        a(fVar, bdTypeListView);
        this.cDR = new HashMap<>();
        eR(z);
    }

    public void a(com.baidu.tieba.frs.f fVar, BdTypeListView bdTypeListView) {
        this.czk = fVar;
        this.cDx = new l(fVar.getPageContext(), bh.Yo, this.czk.getUniqueId());
        this.cDx.setVoiceManager(fVar.getVoiceManager());
        this.cDy = new j(fVar.getPageContext(), bh.Yp, this.czk.getUniqueId());
        this.cDz = new l(fVar.getPageContext(), bh.Yq, this.czk.getUniqueId());
        this.cDz.setVoiceManager(fVar.getVoiceManager());
        this.cDD = new s(fVar.getPageContext(), bh.Yr, this.czk.getUniqueId());
        this.cDE = new g(fVar.getPageContext(), bh.Yv, this.czk.getUniqueId());
        this.cDA = new c(fVar.getPageContext(), av.XL, this.czk.getUniqueId());
        this.cDB = com.baidu.tieba.frs.a.aiN().a(fVar.getPageContext(), com.baidu.tieba.tbadkCore.q.gpg, this.czk.getUniqueId(), false);
        this.cDJ = new com.baidu.tieba.frs.j(fVar.getPageContext(), k.czR);
        this.cDC = new n(fVar.getPageContext(), aw.XO);
        this.cDH = new d(fVar.getPageContext(), bh.Yz, this.czk.getUniqueId());
        this.cDI = new d(fVar.getPageContext(), bh.YA, this.czk.getUniqueId());
        this.cDF = com.baidu.tieba.frs.a.aiN().a(fVar.getPageContext(), bh.ZB, this.czk.getUniqueId(), true);
        this.cDG = com.baidu.tieba.frs.a.aiN().b(fVar.getPageContext(), bh.ZG, this.czk.getUniqueId());
        this.cDK = new com.baidu.tieba.frs.h.a(fVar.getPageContext(), z.Wx, this.czk.getUniqueId());
        this.cDM = new m(fVar.getPageContext(), com.baidu.tieba.frs.p.cAt);
        this.cDN = new i(fVar.getPageContext(), bh.YB, this.czk.getUniqueId());
        this.cDO = new h(fVar.getPageContext(), CardHListViewData.TYPE);
        this.cDP = new p(fVar.getPageContext(), com.baidu.tieba.frs.q.cAz, this.czk.getUniqueId());
        this.cDQ = new q(fVar.getPageContext().getPageActivity(), com.baidu.tieba.tbadkCore.i.goV, this.czk.getUniqueId());
        this.mAdapters.add(this.cDQ);
        this.mAdapters.add(this.cDO);
        this.mAdapters.add(this.cDx);
        this.mAdapters.add(this.cDy);
        this.mAdapters.add(this.cDz);
        this.mAdapters.add(this.cDP);
        com.baidu.tieba.InjectPlugin.b.b bVar = new com.baidu.tieba.InjectPlugin.b.b(this.czk, 1);
        bVar.setExtraData(this.mAdapters);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_FEED_AD_PLUGIN_OPERATE, bVar));
        this.mAdapters.add(this.cDA);
        this.mAdapters.add(this.cDN);
        if (this.cDB != null) {
            this.mAdapters.add(this.cDB);
        }
        this.mAdapters.add(this.cDJ);
        this.mAdapters.add(this.cDD);
        this.mAdapters.add(this.cDE);
        this.mAdapters.add(this.cDC);
        this.mAdapters.add(this.cDH);
        this.mAdapters.add(this.cDI);
        this.mAdapters.add(new com.baidu.tieba.frs.v(this.czk.getPageContext(), w.cAN));
        this.mAdapters.add(this.cDF);
        if (this.cDG != null) {
            this.mAdapters.add(this.cDG);
        }
        this.mAdapters.add(this.cDK);
        this.mAdapters.add(this.cDM);
        com.baidu.adp.widget.ListView.a<? extends bh, ? extends j.a> b = com.baidu.tieba.frs.a.aiN().b(this.czk.getPageContext(), bh.ZA, this.czk.getUniqueId());
        if (b != null) {
            this.mAdapters.add(b);
        }
        this.cDU.setPriority(1);
        this.cDU.setSelfListener(true);
        this.czk.registerListener(this.cDU);
        this.czk.registerListener(this.mAttentionListener);
        this.czk.registerListener(this.mLikeForumListener);
        this.czk.registerListener(this.mUnlikeForumListener);
        this.czk.registerListener(this.cDW);
        alw();
        CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_ADD_ADAPTER, new AbsDelegateAdapterList());
        CustomMessage customMessage = new CustomMessage(CmdConfigCustom.CMD_FRS_ADD_ADAPTER);
        customMessage.setTag(this.czk.getUniqueId());
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

    private void alw() {
        if (this.czk != null && !alx()) {
            this.czk.registerListener(this.cDV);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean alx() {
        if (this.czk == null) {
            return false;
        }
        this.cDL = new ArrayList();
        ArrayList<BdUniqueId> btR = o.btR();
        if (btR == null || btR.size() <= 0) {
            return false;
        }
        int size = btR.size();
        for (int i = 0; i < size; i++) {
            com.baidu.tieba.frs.d<ICardInfo, ? extends j.a> a = com.baidu.tieba.frs.a.aiN().a(this.czk.getPageContext(), btR.get(i), this.czk.getUniqueId());
            if (a != null) {
                this.mAdapters.add(a);
                this.cDL.add(a);
            }
        }
        if (!v.v(this.cDL)) {
            this.mListView.addAdapters(this.cDL);
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
        this.cDS = jVar;
        alG();
        aly();
        this.acj = arrayList;
    }

    private void aly() {
        if (this.cDS != null && this.cDS.aPU() != null && !StringUtils.isNull(this.cDS.aPU().getId()) && this.cDQ != null) {
            this.cDQ.setForumId(this.cDS.aPU().getId());
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
                if (this.cDR != null && !this.cDR.containsValue(fVar)) {
                    this.cDR.put(Integer.valueOf(i2), (bh) fVar);
                }
            }
            i = i2 + 1;
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.a.t
    public void eR(boolean z) {
        if (this.cDT != z) {
            this.cDT = z;
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.a.t
    public HashMap<Integer, bh> alz() {
        return this.cDR;
    }

    @Override // com.baidu.tieba.frs.entelechy.a.t
    public void alA() {
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

    public void abn() {
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
            if (this.cDx != null) {
                this.cDx.setFromCDN(z);
            }
            if (this.cDz != null) {
                this.cDz.setFromCDN(z);
            }
            if (this.cDH != null) {
                this.cDH.setFromCDN(z);
            }
            if (this.cDI != null) {
                this.cDI.setFromCDN(z);
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
    public int alB() {
        if (this.cDB != null) {
            return d.g.frs_fortune_bag_item;
        }
        return 0;
    }

    @Override // com.baidu.tieba.frs.entelechy.a.t
    public int alC() {
        if (this.cDB != null) {
            return d.g.frs_my_service_item;
        }
        return 0;
    }

    @Override // com.baidu.tieba.frs.entelechy.a.t
    public int alD() {
        if (this.cDB != null) {
            return d.g.frs_bawu_center;
        }
        return 0;
    }

    @Override // com.baidu.tieba.frs.entelechy.a.t
    public int alE() {
        if (this.cDC != null) {
            return this.cDC.akn();
        }
        return 0;
    }

    @Override // com.baidu.tieba.frs.entelechy.a.t
    public int ako() {
        if (this.cDC != null) {
            return this.cDC.ako();
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
    public void cE(boolean z) {
        if (this.mAdapters != null && this.mAdapters.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.mAdapters) {
                if (aVar instanceof com.baidu.tieba.frs.d) {
                    ((com.baidu.tieba.frs.d) aVar).cE(z);
                }
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.a.t
    public void alF() {
        if (this.mAdapters != null && this.mAdapters.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.mAdapters) {
                if (aVar instanceof com.baidu.tieba.frs.d) {
                    ((com.baidu.tieba.frs.d) aVar).a(this.czk.getPageContext(), this.czk.getUniqueId());
                }
            }
            aN(this.mAdapters);
        }
    }

    private void alG() {
        if (this.cDS != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.mAdapters) {
                if (aVar instanceof com.baidu.tieba.frs.e.c) {
                    com.baidu.tieba.frs.e.c cVar = (com.baidu.tieba.frs.e.c) aVar;
                    if (com.baidu.tieba.frs.e.c.cPx != null) {
                        if (this.cDS.gnK == 1) {
                            com.baidu.tieba.frs.e.c.cPx.cPn = true;
                        } else {
                            com.baidu.tieba.frs.e.c.cPx.cPn = false;
                        }
                        if (this.cDS.aPU() != null) {
                            com.baidu.tieba.frs.e.c.cPx.cPp = this.cDS.aPU().getId();
                        }
                        if (this.czk != null && this.czk.ajf() != null) {
                            com.baidu.tieba.frs.e.c.cPx.cPo = this.czk.ajf().anY();
                        }
                    }
                }
            }
            alH();
        }
    }

    private void alH() {
        com.baidu.tieba.frs.e.a aVar = new com.baidu.tieba.frs.e.a();
        if (this.cDS.gnK == 1) {
            aVar.cPn = true;
        } else {
            aVar.cPn = false;
        }
        if (this.cDS.aPU() != null) {
            aVar.cPp = this.cDS.aPU().getId();
        }
        if (this.czk != null && this.czk.ajf() != null) {
            aVar.cPo = this.czk.ajf().anY();
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
                    ((com.baidu.tieba.frs.d) aVar).jl(i);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aN(List<com.baidu.adp.widget.ListView.a> list) {
        if (list != null) {
            for (com.baidu.adp.widget.ListView.a aVar : list) {
                if (aVar instanceof com.baidu.tieba.frs.d) {
                    ((com.baidu.tieba.frs.d) aVar).a(this.cxD);
                }
            }
        }
    }
}
