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
    private ArrayList<com.baidu.adp.widget.ListView.f> acN;
    private com.baidu.tieba.frs.f ckn;
    private l cmX;
    private j cmY;
    private l cmZ;
    private c cna;
    private com.baidu.adp.widget.ListView.a cnb;
    private n cnc;
    private p cnd;
    private g cne;
    private com.baidu.adp.widget.ListView.a cnf;
    private com.baidu.adp.widget.ListView.a cng;
    private d cnh;
    private d cni;
    private com.baidu.tieba.frs.j cnj;
    private com.baidu.tieba.frs.h.a cnk;
    private List<com.baidu.adp.widget.ListView.a> cnl;
    private m cnm;
    private i cnn;
    private h cno;
    private final HashMap<Integer, bl> cnp;
    private com.baidu.tieba.tbadkCore.i cnq;
    private BdTypeListView mListView;
    private List<com.baidu.adp.widget.ListView.a> mAdapters = new LinkedList();
    private boolean cnr = false;
    private CustomMessageListener cns = new CustomMessageListener(CmdConfigCustom.CMD_FRS_ADD_ADAPTER) { // from class: com.baidu.tieba.frs.entelechy.a.b.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2003008 && (customResponsedMessage.getData() instanceof AbsDelegateAdapterList)) {
                AbsDelegateAdapterList absDelegateAdapterList = (AbsDelegateAdapterList) customResponsedMessage.getData();
                Iterator it = absDelegateAdapterList.iterator();
                while (it.hasNext()) {
                    com.baidu.adp.widget.ListView.a aVar = (com.baidu.adp.widget.ListView.a) it.next();
                    if (aVar instanceof com.baidu.tieba.frs.d) {
                        ((com.baidu.tieba.frs.d) aVar).a(b.this.ckn.getPageContext(), b.this.ckn.getUniqueId());
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
    private CustomMessageListener cnu = new CustomMessageListener(CmdConfigCustom.CMD_LEGO_REGISTER) { // from class: com.baidu.tieba.frs.entelechy.a.b.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && u.v(b.this.cnl)) {
                b.this.agM();
                b.this.b(b.this.acN, b.this.cnq);
            }
        }
    };
    private CustomMessageListener aqg = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.frs.entelechy.a.b.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
            if (updateAttentionMessage != null && updateAttentionMessage.getData() != null && updateAttentionMessage.getData().Ea) {
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
                bVar.dSi = true;
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
                bVar.dSi = false;
                b.this.R(bVar);
            }
        }
    };
    private CustomMessageListener cnv = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ADCARD) { // from class: com.baidu.tieba.frs.entelechy.a.b.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.data.i)) {
                b.this.S((com.baidu.tbadk.data.i) customResponsedMessage.getData());
            }
        }
    };
    private final com.baidu.tieba.frs.c ciF = new com.baidu.tieba.frs.c();

    public b(com.baidu.tieba.frs.f fVar, BdTypeListView bdTypeListView, boolean z) {
        this.mListView = bdTypeListView;
        a(fVar, bdTypeListView);
        this.cnp = new HashMap<>();
        eP(z);
    }

    public void a(com.baidu.tieba.frs.f fVar, BdTypeListView bdTypeListView) {
        this.ckn = fVar;
        this.cmX = new l(fVar.getPageContext(), bl.Za, this.ckn.getUniqueId());
        this.cmX.setVoiceManager(fVar.getVoiceManager());
        this.cmY = new j(fVar.getPageContext(), bl.Zb, this.ckn.getUniqueId());
        this.cmZ = new l(fVar.getPageContext(), bl.Zc, this.ckn.getUniqueId());
        this.cmZ.setVoiceManager(fVar.getVoiceManager());
        this.cnd = new p(fVar.getPageContext(), bl.Zd, this.ckn.getUniqueId());
        this.cne = new g(fVar.getPageContext(), bl.Zh, this.ckn.getUniqueId());
        this.cna = new c(fVar.getPageContext(), ax.Yt, this.ckn.getUniqueId());
        this.cnb = com.baidu.tieba.frs.a.aeC().a(fVar.getPageContext(), com.baidu.tieba.tbadkCore.p.ggG, this.ckn.getUniqueId(), false);
        this.cnj = new com.baidu.tieba.frs.j(fVar.getPageContext(), k.ckR);
        this.cnc = new n(fVar.getPageContext(), ay.Yw);
        this.cnh = new d(fVar.getPageContext(), bl.Zl, this.ckn.getUniqueId());
        this.cni = new d(fVar.getPageContext(), bl.Zm, this.ckn.getUniqueId());
        this.cnf = com.baidu.tieba.frs.a.aeC().a(fVar.getPageContext(), bl.aam, this.ckn.getUniqueId(), false);
        this.cng = com.baidu.tieba.frs.a.aeC().b(fVar.getPageContext(), bl.aar, this.ckn.getUniqueId());
        this.cnk = new com.baidu.tieba.frs.h.a(fVar.getPageContext(), z.WR, this.ckn.getUniqueId());
        this.cnm = new m(fVar.getPageContext(), com.baidu.tieba.frs.p.clt);
        this.cnn = new i(fVar.getPageContext(), bl.Zn, this.ckn.getUniqueId());
        this.cno = new h(fVar.getPageContext(), CardHListViewData.TYPE);
        this.mAdapters.add(this.cno);
        this.mAdapters.add(this.cmX);
        this.mAdapters.add(this.cmY);
        this.mAdapters.add(this.cmZ);
        com.baidu.tieba.InjectPlugin.b.b bVar = new com.baidu.tieba.InjectPlugin.b.b(this.ckn, 1);
        bVar.setExtraData(this.mAdapters);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_FEED_AD_PLUGIN_OPERATE, bVar));
        this.mAdapters.add(this.cna);
        this.mAdapters.add(this.cnn);
        if (this.cnb != null) {
            this.mAdapters.add(this.cnb);
        }
        this.mAdapters.add(this.cnj);
        this.mAdapters.add(this.cnd);
        this.mAdapters.add(this.cne);
        this.mAdapters.add(this.cnc);
        this.mAdapters.add(this.cnh);
        this.mAdapters.add(this.cni);
        this.mAdapters.add(new com.baidu.tieba.frs.u(this.ckn.getPageContext(), v.clI));
        this.mAdapters.add(this.cnf);
        if (this.cng != null) {
            this.mAdapters.add(this.cng);
        }
        this.mAdapters.add(this.cnk);
        this.mAdapters.add(this.cnm);
        com.baidu.adp.widget.ListView.a<? extends bl, ? extends j.a> b = com.baidu.tieba.frs.a.aeC().b(this.ckn.getPageContext(), bl.aal, this.ckn.getUniqueId());
        if (b != null) {
            this.mAdapters.add(b);
        }
        this.cns.setPriority(1);
        this.cns.setSelfListener(true);
        this.ckn.registerListener(this.cns);
        this.ckn.registerListener(this.aqg);
        this.ckn.registerListener(this.mLikeForumListener);
        this.ckn.registerListener(this.mUnlikeForumListener);
        this.ckn.registerListener(this.cnv);
        agL();
        CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_ADD_ADAPTER, new AbsDelegateAdapterList());
        CustomMessage customMessage = new CustomMessage(CmdConfigCustom.CMD_FRS_ADD_ADAPTER);
        customMessage.setTag(this.ckn.getUniqueId());
        customResponsedMessage.setOrginalMessage(customMessage);
        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
        aH(this.mAdapters);
        bdTypeListView.addAdapters(this.mAdapters);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void R(Object obj) {
        boolean z;
        boolean z2 = false;
        if (this.acN != null) {
            Iterator<com.baidu.adp.widget.ListView.f> it = this.acN.iterator();
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
        if (this.acN != null) {
            Iterator<com.baidu.adp.widget.ListView.f> it = this.acN.iterator();
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

    private void agL() {
        if (this.ckn != null && !agM()) {
            this.ckn.registerListener(this.cnu);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean agM() {
        if (this.ckn == null) {
            return false;
        }
        this.cnl = new ArrayList();
        ArrayList<BdUniqueId> brI = com.baidu.tieba.tbadkCore.n.brI();
        if (brI == null || brI.size() <= 0) {
            return false;
        }
        int size = brI.size();
        for (int i = 0; i < size; i++) {
            com.baidu.tieba.frs.d<ICardInfo, ? extends j.a> a = com.baidu.tieba.frs.a.aeC().a(this.ckn.getPageContext(), brI.get(i), this.ckn.getUniqueId());
            if (a != null) {
                this.mAdapters.add(a);
                this.cnl.add(a);
            }
        }
        if (!u.v(this.cnl)) {
            this.mListView.addAdapters(this.cnl);
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
        this.cnq = iVar;
        agT();
        this.acN = arrayList;
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
        return type == bl.Za || type == bl.Zc || type == bl.Zd || type == bl.Zh || type == bl.Zn || type == ax.Yt || type == bl.Zl || type == bl.Zm;
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
                if (this.cnp != null && !this.cnp.containsValue(fVar)) {
                    this.cnp.put(Integer.valueOf(i2), (bl) fVar);
                }
            }
            i = i2 + 1;
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.a.q
    public void eP(boolean z) {
        if (this.cnr != z) {
            this.cnr = z;
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.a.q
    public HashMap<Integer, bl> agN() {
        return this.cnp;
    }

    @Override // com.baidu.tieba.frs.entelechy.a.q
    public void agO() {
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

    public void XG() {
        if (this.mListView.getAdapter() instanceof com.baidu.adp.widget.ListView.d) {
            if (this.acN != null) {
                this.mListView.setData(this.acN);
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
            if (this.cmX != null) {
                this.cmX.setFromCDN(z);
            }
            if (this.cmZ != null) {
                this.cmZ.setFromCDN(z);
            }
            if (this.cnh != null) {
                this.cnh.setFromCDN(z);
            }
            if (this.cni != null) {
                this.cni.setFromCDN(z);
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
    public int agP() {
        if (this.cnb != null) {
            return d.h.frs_fortune_bag_item;
        }
        return 0;
    }

    @Override // com.baidu.tieba.frs.entelechy.a.q
    public int agQ() {
        if (this.cnb != null) {
            return d.h.frs_my_service_item;
        }
        return 0;
    }

    @Override // com.baidu.tieba.frs.entelechy.a.q
    public int agR() {
        if (this.cnb != null) {
            return d.h.frs_bawu_center;
        }
        return 0;
    }

    @Override // com.baidu.tieba.frs.entelechy.a.q
    public int agS() {
        if (this.cnc != null) {
            return this.cnc.agc();
        }
        return 0;
    }

    @Override // com.baidu.tieba.frs.entelechy.a.q
    public int agd() {
        if (this.cnc != null) {
            return this.cnc.agd();
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
                } else if (aVar != null && aVar.getType() == bl.aal) {
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
                    ((com.baidu.tieba.frs.d) aVar).a(this.ckn.getPageContext(), this.ckn.getUniqueId());
                }
            }
            aH(this.mAdapters);
        }
    }

    private void agT() {
        if (this.cnq != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.mAdapters) {
                if (aVar instanceof com.baidu.tieba.frs.e.c) {
                    com.baidu.tieba.frs.e.c cVar = (com.baidu.tieba.frs.e.c) aVar;
                    if (com.baidu.tieba.frs.e.c.cvL != null) {
                        if (this.cnq.gfq == 1) {
                            com.baidu.tieba.frs.e.c.cvL.cvB = true;
                        } else {
                            com.baidu.tieba.frs.e.c.cvL.cvB = false;
                        }
                        if (this.cnq.aPh() != null) {
                            com.baidu.tieba.frs.e.c.cvL.cvD = this.cnq.aPh().getId();
                        }
                        if (this.ckn != null && this.ckn.aeU() != null) {
                            com.baidu.tieba.frs.e.c.cvL.cvC = this.ckn.aeU().aiE();
                        }
                    }
                }
            }
            agU();
        }
    }

    private void agU() {
        com.baidu.tieba.frs.e.a aVar = new com.baidu.tieba.frs.e.a();
        if (this.cnq.gfq == 1) {
            aVar.cvB = true;
        } else {
            aVar.cvB = false;
        }
        if (this.cnq.aPh() != null) {
            aVar.cvD = this.cnq.aPh().getId();
        }
        if (this.ckn != null && this.ckn.aeU() != null) {
            aVar.cvC = this.ckn.aeU().aiE();
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
                    if (!it.hasNext() || it.next().getType().getId() != bl.YZ.getId()) {
                        break;
                    }
                    i2 = i + 1;
                }
            }
            for (com.baidu.adp.widget.ListView.a aVar : this.mAdapters) {
                if (aVar instanceof com.baidu.tieba.frs.d) {
                    ((com.baidu.tieba.frs.d) aVar).iz(i);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aH(List<com.baidu.adp.widget.ListView.a> list) {
        if (list != null) {
            for (com.baidu.adp.widget.ListView.a aVar : list) {
                if (aVar instanceof com.baidu.tieba.frs.d) {
                    ((com.baidu.tieba.frs.d) aVar).a(this.ciF);
                }
            }
        }
    }
}
