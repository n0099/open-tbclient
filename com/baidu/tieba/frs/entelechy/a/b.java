package com.baidu.tieba.frs.entelechy.a;

import android.text.TextUtils;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.data.bb;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.coreExtra.message.UpdateAttentionMessage;
import com.baidu.tieba.card.ab;
import com.baidu.tieba.e;
import com.baidu.tieba.frs.AbsDelegateAdapterList;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.frs.u;
import com.baidu.tieba.lego.card.model.ICardInfo;
import com.baidu.tieba.tbadkCore.s;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes6.dex */
public class b implements q {
    private ArrayList<com.baidu.adp.widget.ListView.h> axs;
    private FrsFragment dMs;
    private com.baidu.tieba.frs.l dOZ;
    private i dRr;
    private i dRs;
    private l dRt;
    private p dRu;
    private d dRv;
    private e dSA;
    private final HashMap<Integer, bb> dSB;
    private com.baidu.tieba.tbadkCore.l dSC;
    private com.baidu.adp.widget.ListView.m dSq;
    private g dSr;
    private com.baidu.adp.widget.ListView.a dSs;
    private com.baidu.adp.widget.ListView.a dSt;
    private com.baidu.adp.widget.ListView.a dSu;
    private List<com.baidu.adp.widget.ListView.a> dSv;
    private j dSw;
    private f dSx;
    private m dSy;
    private n dSz;
    private List<com.baidu.adp.widget.ListView.a> mAdapters = new LinkedList();
    private boolean dSD = false;
    private int dSE = 0;
    private CustomMessageListener dRx = new CustomMessageListener(2003008) { // from class: com.baidu.tieba.frs.entelechy.a.b.1
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX DEBUG: Multi-variable search result rejected for r3v2, resolved type: com.baidu.tieba.frs.FrsFragment */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2003008 && (customResponsedMessage.getData() instanceof AbsDelegateAdapterList)) {
                AbsDelegateAdapterList absDelegateAdapterList = (AbsDelegateAdapterList) customResponsedMessage.getData();
                Iterator it = absDelegateAdapterList.iterator();
                while (it.hasNext()) {
                    com.baidu.adp.widget.ListView.a aVar = (com.baidu.adp.widget.ListView.a) it.next();
                    if (aVar instanceof com.baidu.tieba.frs.h) {
                        ((com.baidu.tieba.frs.h) aVar).a(b.this.dMs.getPageContext(), b.this.dMs.getUniqueId());
                    }
                }
                ArrayList arrayList = new ArrayList();
                arrayList.addAll(absDelegateAdapterList);
                b.this.bG(arrayList);
                if (b.this.mAdapters != null) {
                    b.this.mAdapters.addAll(absDelegateAdapterList);
                }
                if (b.this.dSq != null) {
                    b.this.mAdapters.addAll(arrayList);
                    b.this.dSq.addAdapters(arrayList);
                }
            }
        }
    };
    private CustomMessageListener dSF = new CustomMessageListener(2016470) { // from class: com.baidu.tieba.frs.entelechy.a.b.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && v.I(b.this.dSv)) {
                b.this.aEz();
                b.this.b(b.this.axs, b.this.dSC);
            }
        }
    };
    private CustomMessageListener mAttentionListener = new CustomMessageListener(2001115) { // from class: com.baidu.tieba.frs.entelechy.a.b.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
            if (updateAttentionMessage != null && updateAttentionMessage.getData() != null && updateAttentionMessage.getData().Jr) {
                b.this.ae(updateAttentionMessage.getData());
            }
        }
    };
    private CustomMessageListener mLikeForumListener = new CustomMessageListener(2001335) { // from class: com.baidu.tieba.frs.entelechy.a.b.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                com.baidu.tieba.lego.c.b bVar = new com.baidu.tieba.lego.c.b();
                bVar.fid = String.valueOf(customResponsedMessage.getData());
                bVar.asY = true;
                b.this.ae(bVar);
            }
        }
    };
    private CustomMessageListener mUnlikeForumListener = new CustomMessageListener(2001336) { // from class: com.baidu.tieba.frs.entelechy.a.b.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                com.baidu.tieba.lego.c.b bVar = new com.baidu.tieba.lego.c.b();
                bVar.fid = String.valueOf(customResponsedMessage.getData());
                bVar.asY = false;
                b.this.ae(bVar);
            }
        }
    };
    private CustomMessageListener dSG = new CustomMessageListener(2016492) { // from class: com.baidu.tieba.frs.entelechy.a.b.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.data.g)) {
                b.this.af((com.baidu.tbadk.data.g) customResponsedMessage.getData());
            }
        }
    };
    private CustomMessageListener dSH = new CustomMessageListener(2921386) { // from class: com.baidu.tieba.frs.entelechy.a.b.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            am a;
            AdvertAppInfo advertAppInfo = (AdvertAppInfo) customResponsedMessage.getData();
            if (advertAppInfo != null && b.this.dMs != null && b.this.dMs.aBs() != null && (a = com.baidu.tieba.q.a.a(advertAppInfo, "a006", "common_click", -1, (advertAppInfo.avH - b.this.dSE) + 1, true, advertAppInfo.apq, null)) != null) {
                a.x("list_order", b.this.dMs.aBs().aHh());
                com.baidu.tieba.q.c.bBT().b(b.this.dMs.getUniqueId(), a);
            }
        }
    };
    private CustomMessageListener dSI = new CustomMessageListener(2921387) { // from class: com.baidu.tieba.frs.entelechy.a.b.8
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            am a;
            AdvertAppInfo advertAppInfo = (AdvertAppInfo) customResponsedMessage.getData();
            if (advertAppInfo != null && b.this.dMs != null && b.this.dMs.aBs() != null && (a = com.baidu.tieba.q.a.a(advertAppInfo, "a006", "common_exp", (advertAppInfo.avH - b.this.dSE) + 1, true, advertAppInfo.apq, null)) != null) {
                a.x("list_order", b.this.dMs.aBs().aHh());
                com.baidu.tieba.q.c.bBT().a(b.this.dMs.getUniqueId(), advertAppInfo.apq, a);
            }
        }
    };
    private final com.baidu.tieba.frs.f dKx = new com.baidu.tieba.frs.f();

    public b(FrsFragment frsFragment, com.baidu.adp.widget.ListView.m mVar, boolean z) {
        this.dSq = mVar;
        a(frsFragment, mVar);
        this.dSB = new HashMap<>();
        hd(z);
    }

    public void a(FrsFragment frsFragment, com.baidu.adp.widget.ListView.m mVar) {
        this.dMs = frsFragment;
        this.dRr = new i(frsFragment.getPageContext(), bb.atg, this.dMs.getUniqueId());
        this.dRr.setVoiceManager(frsFragment.getVoiceManager());
        this.dRr.setInFrsAllThread(true);
        this.dSr = new g(frsFragment.getPageContext(), bb.ath, this.dMs.getUniqueId());
        this.dSr.setInFrsAllThread(true);
        this.dRt = new l(frsFragment.getPageContext(), bb.atn, this.dMs.getUniqueId());
        this.dRt.setInFrsAllThread(true);
        this.dRs = new i(frsFragment.getPageContext(), bb.ati, this.dMs.getUniqueId());
        this.dRs.setVoiceManager(frsFragment.getVoiceManager());
        this.dRs.setInFrsAllThread(true);
        this.dRu = new p(frsFragment.getPageContext(), bb.atj, this.dMs.getUniqueId());
        this.dRu.setInFrsAllThread(true);
        this.dRv = new d(frsFragment.getPageContext(), bb.ato, this.dMs.getUniqueId());
        this.dRv.setInFrsAllThread(true);
        this.dSs = com.baidu.tieba.frs.c.aAS().a(frsFragment.getPageContext(), s.hns, this.dMs.getUniqueId(), false);
        this.dOZ = new com.baidu.tieba.frs.l(frsFragment.getPageContext(), com.baidu.tieba.frs.m.dNu);
        this.dSt = com.baidu.tieba.frs.c.aAS().a(frsFragment.getPageContext(), bb.auD, this.dMs.getUniqueId(), true);
        this.dSu = com.baidu.tieba.frs.c.aAS().b(frsFragment.getPageContext(), bb.auL, this.dMs.getUniqueId());
        this.dSw = new j(frsFragment.getPageContext(), com.baidu.tieba.frs.p.dNz);
        this.dSx = new f(frsFragment.getPageContext(), bb.atu, this.dMs.getUniqueId());
        this.dSy = new m(frsFragment.getPageContext(), com.baidu.tieba.frs.q.dNF, this.dMs.getUniqueId());
        this.dSz = new n(frsFragment.getPageContext().getPageActivity(), com.baidu.tieba.tbadkCore.k.hnh, this.dMs.getUniqueId());
        this.dSA = new e(frsFragment.getPageContext(), bb.atp, this.dMs.getUniqueId());
        this.mAdapters.add(this.dSz);
        this.mAdapters.add(this.dRr);
        this.mAdapters.add(this.dSr);
        this.mAdapters.add(this.dRt);
        this.mAdapters.add(this.dRs);
        this.mAdapters.add(this.dSy);
        com.baidu.tieba.InjectPlugin.b.b bVar = new com.baidu.tieba.InjectPlugin.b.b(this.dMs, 1);
        bVar.setExtraData(this.mAdapters);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016515, bVar));
        this.mAdapters.add(this.dSx);
        if (this.dSs != null) {
            this.mAdapters.add(this.dSs);
        }
        this.mAdapters.add(this.dOZ);
        this.mAdapters.add(this.dRu);
        this.mAdapters.add(this.dRv);
        this.mAdapters.add(new u(this.dMs.getPageContext(), com.baidu.tieba.frs.v.dOb));
        this.mAdapters.add(this.dSt);
        if (this.dSu != null) {
            this.mAdapters.add(this.dSu);
        }
        this.mAdapters.add(this.dSw);
        this.mAdapters.add(this.dSA);
        this.dRx.setPriority(1);
        this.dRx.setSelfListener(true);
        this.dMs.registerListener(this.dRx);
        this.dMs.registerListener(this.mAttentionListener);
        this.dMs.registerListener(this.mLikeForumListener);
        this.dMs.registerListener(this.mUnlikeForumListener);
        this.dMs.registerListener(this.dSG);
        this.dMs.registerListener(this.dSH);
        this.dMs.registerListener(this.dSI);
        aEy();
        CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2003008, new AbsDelegateAdapterList());
        CustomMessage customMessage = new CustomMessage(2003008);
        customMessage.setTag(this.dMs.getUniqueId());
        customResponsedMessage.setOrginalMessage(customMessage);
        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
        bG(this.mAdapters);
        mVar.addAdapters(this.mAdapters);
        jL("page_frs");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ae(Object obj) {
        boolean z;
        boolean z2 = false;
        if (this.axs != null) {
            Iterator<com.baidu.adp.widget.ListView.h> it = this.axs.iterator();
            while (true) {
                z = z2;
                if (!it.hasNext()) {
                    break;
                }
                com.baidu.adp.widget.ListView.h next = it.next();
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
    public void af(Object obj) {
        if (this.axs != null) {
            Iterator<com.baidu.adp.widget.ListView.h> it = this.axs.iterator();
            while (it.hasNext()) {
                com.baidu.adp.widget.ListView.h next = it.next();
                if (next instanceof AdvertAppInfo) {
                    AdvertAppInfo advertAppInfo = (AdvertAppInfo) next;
                    if (advertAppInfo.legoCard != null) {
                        advertAppInfo.legoCard.refreshReservation(obj);
                    }
                }
            }
        }
    }

    private void aEy() {
        if (this.dMs != null && !aEz()) {
            this.dMs.registerListener(this.dSF);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v5, resolved type: com.baidu.tieba.frs.FrsFragment */
    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public boolean aEz() {
        if (this.dMs == null) {
            return false;
        }
        this.dSv = new ArrayList();
        ArrayList<BdUniqueId> bDw = com.baidu.tieba.tbadkCore.q.bDw();
        if (bDw == null || bDw.size() <= 0) {
            return false;
        }
        int size = bDw.size();
        for (int i = 0; i < size; i++) {
            com.baidu.tieba.frs.h<ICardInfo, ? extends q.a> a = com.baidu.tieba.frs.c.aAS().a(this.dMs.getPageContext(), bDw.get(i), this.dMs.getUniqueId());
            if (a != null) {
                this.mAdapters.add(a);
                this.dSv.add(a);
            }
        }
        if (!v.I(this.dSv)) {
            this.dSq.addAdapters(this.dSv);
        }
        return true;
    }

    @Override // com.baidu.tieba.frs.entelechy.a.q
    public void onDestory() {
        for (com.baidu.adp.widget.ListView.a aVar : this.mAdapters) {
            if (aVar instanceof com.baidu.tieba.frs.h) {
                ((com.baidu.tieba.frs.h) aVar).release();
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.a.q
    public void b(ArrayList<com.baidu.adp.widget.ListView.h> arrayList, com.baidu.tieba.tbadkCore.l lVar) {
        b(lVar);
        d(lVar);
        com.baidu.tieba.tbadkCore.q.q(arrayList, 1);
        Q(arrayList);
        R(arrayList);
        P(arrayList);
        this.dSq.setData(arrayList);
        this.dSC = lVar;
        aDW();
        aEA();
        this.axs = arrayList;
    }

    private void d(com.baidu.tieba.tbadkCore.l lVar) {
        if (lVar != null && lVar.bgT() != null && "worldcup".equals(lVar.bgT().getSpecialForumType())) {
            com.baidu.tieba.frs.worldcup.c.a(lVar.bgT().getId(), 2, this.dRr, this.dRu, this.dSA, this.dRs, this.dRv);
        }
    }

    private void aEA() {
        if (this.dSC != null && this.dSC.bgT() != null && !StringUtils.isNull(this.dSC.bgT().getId()) && this.dSz != null) {
            this.dSz.setForumId(this.dSC.bgT().getId());
        }
    }

    private void P(ArrayList<com.baidu.adp.widget.ListView.h> arrayList) {
        int H = v.H(arrayList);
        for (int i = 0; i < H; i++) {
            com.baidu.adp.widget.ListView.h hVar = (com.baidu.adp.widget.ListView.h) v.d(arrayList, i - 1);
            com.baidu.adp.widget.ListView.h hVar2 = (com.baidu.adp.widget.ListView.h) v.d(arrayList, i);
            if (hVar2 instanceof bb) {
                bb bbVar = (bb) hVar2;
                if (i == 0) {
                    bbVar.isFirstFloor = true;
                } else {
                    bbVar.isFirstFloor = false;
                }
                String Af = bbVar.Af();
                if (hVar instanceof com.baidu.tieba.frs.p) {
                    bbVar.needTopMargin = false;
                } else if (hVar != null && !d(hVar)) {
                    bbVar.needTopMargin = false;
                } else if ((hVar instanceof bb) && d(hVar) && !TextUtils.isEmpty(((bb) hVar).Af())) {
                    bbVar.needTopMargin = true;
                } else if (d(hVar2) && !TextUtils.isEmpty(Af)) {
                    bbVar.needTopMargin = true;
                } else {
                    bbVar.needTopMargin = false;
                }
            }
        }
    }

    private boolean d(com.baidu.adp.widget.ListView.h hVar) {
        if (hVar == null) {
            return false;
        }
        BdUniqueId type = hVar.getType();
        return type == bb.atg || type == bb.ati || type == bb.atj || type == bb.ato || type == bb.atu;
    }

    private ArrayList<Integer> Q(ArrayList<com.baidu.adp.widget.ListView.h> arrayList) {
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
            com.baidu.adp.widget.ListView.h hVar = arrayList.get(i2);
            if (hVar instanceof AdvertAppInfo) {
                arrayList2.add(Integer.valueOf(i2));
                if (this.dSB != null && !this.dSB.containsValue(hVar)) {
                    this.dSB.put(Integer.valueOf(i2), (bb) hVar);
                }
            }
            i = i2 + 1;
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.a.q
    public void hd(boolean z) {
        if (this.dSD != z) {
            this.dSD = z;
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.a.q
    public HashMap<Integer, bb> aEB() {
        return this.dSB;
    }

    @Override // com.baidu.tieba.frs.entelechy.a.q
    public void aEC() {
        List<com.baidu.adp.widget.ListView.h> data;
        if (this.dSq != null && this.dSq.getData() != null && this.dSq.getData().size() != 0 && (data = this.dSq.getData()) != null && data.size() != 0) {
            for (com.baidu.adp.widget.ListView.h hVar : data) {
                if ((hVar instanceof bb) && ((bb) hVar).zB() != 0) {
                    ((bb) hVar).Aq();
                }
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.a.q
    public void notifyDataSetChanged() {
        if (this.dSq.getListAdapter() != null) {
            this.dSq.getListAdapter().notifyDataSetChanged();
        }
    }

    public void notifyDataChanged() {
        if (this.axs != null) {
            this.dSq.setData(this.axs);
        }
        notifyDataSetChanged();
    }

    @Override // com.baidu.tieba.frs.entelechy.a.q
    public void setFromCDN(boolean z) {
        if (this.mAdapters != null && this.mAdapters.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.mAdapters) {
                if (aVar instanceof com.baidu.tieba.frs.h) {
                    ((com.baidu.tieba.frs.h) aVar).setFromCDN(z);
                }
            }
            if (this.dRr != null) {
                this.dRr.setFromCDN(z);
            }
            if (this.dRs != null) {
                this.dRs.setFromCDN(z);
            }
        }
    }

    public void b(com.baidu.tieba.tbadkCore.l lVar) {
        if (this.mAdapters != null && this.mAdapters.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.mAdapters) {
                if (aVar instanceof com.baidu.tieba.frs.h) {
                    ((com.baidu.tieba.frs.h) aVar).b(lVar);
                }
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.a.q
    public void a(com.baidu.tieba.frs.d dVar) {
        if (this.mAdapters != null && this.mAdapters.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.mAdapters) {
                if (aVar instanceof com.baidu.tieba.frs.h) {
                    ((com.baidu.tieba.frs.h) aVar).a(dVar);
                }
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.a.q
    public int aED() {
        if (this.dSs != null) {
            return e.g.frs_fortune_bag_item;
        }
        return 0;
    }

    @Override // com.baidu.tieba.frs.entelechy.a.q
    public int aEE() {
        if (this.dSs != null) {
            return e.g.frs_my_service_item;
        }
        return 0;
    }

    @Override // com.baidu.tieba.frs.entelechy.a.q
    public int aEF() {
        if (this.dSs != null) {
            return e.g.frs_bawu_center;
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
    public void setOnAdapterItemClickListener(com.baidu.adp.widget.ListView.n nVar) {
        if (this.mAdapters != null && this.mAdapters.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.mAdapters) {
                if (aVar instanceof com.baidu.tieba.frs.h) {
                    ((com.baidu.tieba.frs.h) aVar).setOnAdapterItemClickListener(nVar);
                } else if ((aVar instanceof i) || (aVar instanceof p)) {
                    aVar.setOnAdapterItemClickListener(nVar);
                }
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.a.q
    public void setForumName(String str) {
        if (this.mAdapters != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.mAdapters) {
                if (aVar instanceof ab) {
                    ((ab) aVar).setForumName(str);
                }
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v1, resolved type: com.baidu.tieba.frs.FrsFragment */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.baidu.tieba.frs.entelechy.a.q
    public void aEG() {
        if (this.mAdapters != null && this.mAdapters.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.mAdapters) {
                if (aVar instanceof com.baidu.tieba.frs.h) {
                    ((com.baidu.tieba.frs.h) aVar).a(this.dMs.getPageContext(), this.dMs.getUniqueId());
                }
            }
            bG(this.mAdapters);
        }
    }

    private void aDW() {
        com.baidu.tieba.frs.e.b aEI;
        if (this.dSC != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.mAdapters) {
                if ((aVar instanceof com.baidu.tieba.frs.e.d) && (aEI = ((com.baidu.tieba.frs.e.d) aVar).aEI()) != null) {
                    if (this.dSC.hlK == 1) {
                        aEI.eed = true;
                    } else {
                        aEI.eed = false;
                    }
                    if (this.dSC.bgT() != null) {
                        aEI.eef = this.dSC.bgT().getId();
                    }
                    if (this.dMs != null && this.dMs.aBs() != null) {
                        aEI.eee = this.dMs.aBs().aHh();
                    }
                }
            }
            aEH();
        }
    }

    private void aEH() {
        com.baidu.tieba.frs.e.b bVar = new com.baidu.tieba.frs.e.b();
        if (this.dSC.hlK == 1) {
            bVar.eed = true;
        } else {
            bVar.eed = false;
        }
        if (this.dSC.bgT() != null) {
            bVar.eef = this.dSC.bgT().getId();
        }
        if (this.dMs != null && this.dMs.aBs() != null) {
            bVar.eee = this.dMs.aBs().aHh();
        }
        if (com.baidu.tieba.frs.e.d.dSZ != null) {
            bVar.eeg = com.baidu.tieba.frs.e.d.dSZ.eeg;
            bVar.eeh = com.baidu.tieba.frs.e.d.dSZ.eeh;
        }
        com.baidu.tieba.frs.live.b bVar2 = new com.baidu.tieba.frs.live.b(bVar, this.dMs.getUniqueId());
        CustomMessageTask customMessageTask = new CustomMessageTask(2921018, bVar2);
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
        CustomMessageTask customMessageTask2 = new CustomMessageTask(2921017, bVar2);
        customMessageTask2.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask2);
        CustomMessageTask customMessageTask3 = new CustomMessageTask(2921016, bVar2);
        customMessageTask3.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask3);
        CustomMessageTask customMessageTask4 = new CustomMessageTask(2921019, bVar2);
        customMessageTask4.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask4);
    }

    @Override // com.baidu.tieba.frs.entelechy.a.q
    public List<com.baidu.adp.widget.ListView.h> getDatas() {
        if (this.dSq != null) {
            return this.dSq.getData();
        }
        return null;
    }

    private void R(ArrayList<com.baidu.adp.widget.ListView.h> arrayList) {
        int i;
        if (this.mAdapters != null && this.mAdapters.size() != 0) {
            int i2 = 0;
            if (arrayList == null || arrayList.size() <= 0) {
                i = 0;
            } else {
                Iterator<com.baidu.adp.widget.ListView.h> it = arrayList.iterator();
                while (true) {
                    i = i2;
                    if (!it.hasNext() || it.next().getType().getId() != bb.atf.getId()) {
                        break;
                    }
                    i2 = i + 1;
                }
            }
            this.dSE = i;
            for (com.baidu.adp.widget.ListView.a aVar : this.mAdapters) {
                if (aVar instanceof com.baidu.tieba.frs.h) {
                    ((com.baidu.tieba.frs.h) aVar).mg(i);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bG(List<com.baidu.adp.widget.ListView.a> list) {
        if (list != null) {
            for (com.baidu.adp.widget.ListView.a aVar : list) {
                if (aVar instanceof com.baidu.tieba.frs.h) {
                    ((com.baidu.tieba.frs.h) aVar).a(this.dKx);
                }
            }
        }
    }

    private void jL(String str) {
        if (this.mAdapters != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.mAdapters) {
                if (aVar instanceof com.baidu.tieba.a.f) {
                    ((com.baidu.tieba.a.f) aVar).jL(str);
                }
            }
        }
    }
}
