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
    private ArrayList<com.baidu.adp.widget.ListView.h> atR;
    private FrsFragment dDf;
    private com.baidu.tieba.frs.l dFM;
    private com.baidu.adp.widget.ListView.m dIZ;
    private i dIe;
    private i dIf;
    private l dIg;
    private p dIh;
    private d dIi;
    private g dJa;
    private com.baidu.adp.widget.ListView.a dJb;
    private com.baidu.adp.widget.ListView.a dJc;
    private com.baidu.adp.widget.ListView.a dJd;
    private List<com.baidu.adp.widget.ListView.a> dJe;
    private j dJf;
    private f dJg;
    private m dJh;
    private n dJi;
    private e dJj;
    private final HashMap<Integer, bb> dJk;
    private com.baidu.tieba.tbadkCore.l dJl;
    private List<com.baidu.adp.widget.ListView.a> mAdapters = new LinkedList();
    private boolean dJm = false;
    private CustomMessageListener dIk = new CustomMessageListener(2003008) { // from class: com.baidu.tieba.frs.entelechy.a.b.1
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
                        ((com.baidu.tieba.frs.h) aVar).a(b.this.dDf.getPageContext(), b.this.dDf.getUniqueId());
                    }
                }
                ArrayList arrayList = new ArrayList();
                arrayList.addAll(absDelegateAdapterList);
                b.this.bD(arrayList);
                if (b.this.mAdapters != null) {
                    b.this.mAdapters.addAll(absDelegateAdapterList);
                }
                if (b.this.dIZ != null) {
                    b.this.mAdapters.addAll(arrayList);
                    b.this.dIZ.addAdapters(arrayList);
                }
            }
        }
    };
    private CustomMessageListener dJn = new CustomMessageListener(2016470) { // from class: com.baidu.tieba.frs.entelechy.a.b.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && v.I(b.this.dJe)) {
                b.this.aBY();
                b.this.b(b.this.atR, b.this.dJl);
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
                bVar.apy = true;
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
                bVar.apy = false;
                b.this.ae(bVar);
            }
        }
    };
    private CustomMessageListener dJo = new CustomMessageListener(2016492) { // from class: com.baidu.tieba.frs.entelechy.a.b.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.data.g)) {
                b.this.af((com.baidu.tbadk.data.g) customResponsedMessage.getData());
            }
        }
    };
    private final com.baidu.tieba.frs.f dBk = new com.baidu.tieba.frs.f();

    public b(FrsFragment frsFragment, com.baidu.adp.widget.ListView.m mVar, boolean z) {
        this.dIZ = mVar;
        a(frsFragment, mVar);
        this.dJk = new HashMap<>();
        gY(z);
    }

    public void a(FrsFragment frsFragment, com.baidu.adp.widget.ListView.m mVar) {
        this.dDf = frsFragment;
        this.dIe = new i(frsFragment.getPageContext(), bb.apG, this.dDf.getUniqueId());
        this.dIe.setVoiceManager(frsFragment.getVoiceManager());
        this.dIe.setInFrsAllThread(true);
        this.dJa = new g(frsFragment.getPageContext(), bb.apH, this.dDf.getUniqueId());
        this.dJa.setInFrsAllThread(true);
        this.dIg = new l(frsFragment.getPageContext(), bb.apN, this.dDf.getUniqueId());
        this.dIg.setInFrsAllThread(true);
        this.dIf = new i(frsFragment.getPageContext(), bb.apI, this.dDf.getUniqueId());
        this.dIf.setVoiceManager(frsFragment.getVoiceManager());
        this.dIf.setInFrsAllThread(true);
        this.dIh = new p(frsFragment.getPageContext(), bb.apJ, this.dDf.getUniqueId());
        this.dIh.setInFrsAllThread(true);
        this.dIi = new d(frsFragment.getPageContext(), bb.apO, this.dDf.getUniqueId());
        this.dIi.setInFrsAllThread(true);
        this.dJb = com.baidu.tieba.frs.c.ayt().a(frsFragment.getPageContext(), s.hdn, this.dDf.getUniqueId(), false);
        this.dFM = new com.baidu.tieba.frs.l(frsFragment.getPageContext(), com.baidu.tieba.frs.m.dEh);
        this.dJc = com.baidu.tieba.frs.c.ayt().a(frsFragment.getPageContext(), bb.ard, this.dDf.getUniqueId(), true);
        this.dJd = com.baidu.tieba.frs.c.ayt().b(frsFragment.getPageContext(), bb.arl, this.dDf.getUniqueId());
        this.dJf = new j(frsFragment.getPageContext(), com.baidu.tieba.frs.p.dEm);
        this.dJg = new f(frsFragment.getPageContext(), bb.apU, this.dDf.getUniqueId());
        this.dJh = new m(frsFragment.getPageContext(), com.baidu.tieba.frs.q.dEs, this.dDf.getUniqueId());
        this.dJi = new n(frsFragment.getPageContext().getPageActivity(), com.baidu.tieba.tbadkCore.k.hdc, this.dDf.getUniqueId());
        this.dJj = new e(frsFragment.getPageContext(), bb.apP, this.dDf.getUniqueId());
        this.mAdapters.add(this.dJi);
        this.mAdapters.add(this.dIe);
        this.mAdapters.add(this.dJa);
        this.mAdapters.add(this.dIg);
        this.mAdapters.add(this.dIf);
        this.mAdapters.add(this.dJh);
        com.baidu.tieba.InjectPlugin.b.b bVar = new com.baidu.tieba.InjectPlugin.b.b(this.dDf, 1);
        bVar.setExtraData(this.mAdapters);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016515, bVar));
        this.mAdapters.add(this.dJg);
        if (this.dJb != null) {
            this.mAdapters.add(this.dJb);
        }
        this.mAdapters.add(this.dFM);
        this.mAdapters.add(this.dIh);
        this.mAdapters.add(this.dIi);
        this.mAdapters.add(new u(this.dDf.getPageContext(), com.baidu.tieba.frs.v.dEO));
        this.mAdapters.add(this.dJc);
        if (this.dJd != null) {
            this.mAdapters.add(this.dJd);
        }
        this.mAdapters.add(this.dJf);
        this.mAdapters.add(this.dJj);
        this.dIk.setPriority(1);
        this.dIk.setSelfListener(true);
        this.dDf.registerListener(this.dIk);
        this.dDf.registerListener(this.mAttentionListener);
        this.dDf.registerListener(this.mLikeForumListener);
        this.dDf.registerListener(this.mUnlikeForumListener);
        this.dDf.registerListener(this.dJo);
        aBX();
        CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2003008, new AbsDelegateAdapterList());
        CustomMessage customMessage = new CustomMessage(2003008);
        customMessage.setTag(this.dDf.getUniqueId());
        customResponsedMessage.setOrginalMessage(customMessage);
        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
        bD(this.mAdapters);
        mVar.addAdapters(this.mAdapters);
        js("page_frs");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ae(Object obj) {
        boolean z;
        boolean z2 = false;
        if (this.atR != null) {
            Iterator<com.baidu.adp.widget.ListView.h> it = this.atR.iterator();
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
        if (this.atR != null) {
            Iterator<com.baidu.adp.widget.ListView.h> it = this.atR.iterator();
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

    private void aBX() {
        if (this.dDf != null && !aBY()) {
            this.dDf.registerListener(this.dJn);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v5, resolved type: com.baidu.tieba.frs.FrsFragment */
    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public boolean aBY() {
        if (this.dDf == null) {
            return false;
        }
        this.dJe = new ArrayList();
        ArrayList<BdUniqueId> bAK = com.baidu.tieba.tbadkCore.q.bAK();
        if (bAK == null || bAK.size() <= 0) {
            return false;
        }
        int size = bAK.size();
        for (int i = 0; i < size; i++) {
            com.baidu.tieba.frs.h<ICardInfo, ? extends q.a> a = com.baidu.tieba.frs.c.ayt().a(this.dDf.getPageContext(), bAK.get(i), this.dDf.getUniqueId());
            if (a != null) {
                this.mAdapters.add(a);
                this.dJe.add(a);
            }
        }
        if (!v.I(this.dJe)) {
            this.dIZ.addAdapters(this.dJe);
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
        c(lVar);
        com.baidu.tieba.tbadkCore.q.q(arrayList, 1);
        Q(arrayList);
        R(arrayList);
        P(arrayList);
        this.dIZ.setData(arrayList);
        this.dJl = lVar;
        aBx();
        aBZ();
        this.atR = arrayList;
    }

    private void c(com.baidu.tieba.tbadkCore.l lVar) {
        if (lVar != null && lVar.ber() != null && "worldcup".equals(lVar.ber().getSpecialForumType())) {
            com.baidu.tieba.frs.worldcup.c.a(lVar.ber().getId(), 2, this.dIe, this.dIh, this.dJj, this.dIf, this.dIi);
        }
    }

    private void aBZ() {
        if (this.dJl != null && this.dJl.ber() != null && !StringUtils.isNull(this.dJl.ber().getId()) && this.dJi != null) {
            this.dJi.setForumId(this.dJl.ber().getId());
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
                String zb = bbVar.zb();
                if (hVar instanceof com.baidu.tieba.frs.p) {
                    bbVar.needTopMargin = false;
                } else if (hVar != null && !d(hVar)) {
                    bbVar.needTopMargin = false;
                } else if ((hVar instanceof bb) && d(hVar) && !TextUtils.isEmpty(((bb) hVar).zb())) {
                    bbVar.needTopMargin = true;
                } else if (d(hVar2) && !TextUtils.isEmpty(zb)) {
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
        return type == bb.apG || type == bb.apI || type == bb.apJ || type == bb.apO || type == bb.apU;
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
                if (this.dJk != null && !this.dJk.containsValue(hVar)) {
                    this.dJk.put(Integer.valueOf(i2), (bb) hVar);
                }
            }
            i = i2 + 1;
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.a.q
    public void gY(boolean z) {
        if (this.dJm != z) {
            this.dJm = z;
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.a.q
    public HashMap<Integer, bb> aCa() {
        return this.dJk;
    }

    @Override // com.baidu.tieba.frs.entelechy.a.q
    public void aCb() {
        List<com.baidu.adp.widget.ListView.h> data;
        if (this.dIZ != null && this.dIZ.getData() != null && this.dIZ.getData().size() != 0 && (data = this.dIZ.getData()) != null && data.size() != 0) {
            for (com.baidu.adp.widget.ListView.h hVar : data) {
                if ((hVar instanceof bb) && ((bb) hVar).yx() != 0) {
                    ((bb) hVar).zm();
                }
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.a.q
    public void notifyDataSetChanged() {
        if (this.dIZ.getListAdapter() != null) {
            this.dIZ.getListAdapter().notifyDataSetChanged();
        }
    }

    public void notifyDataChanged() {
        if (this.atR != null) {
            this.dIZ.setData(this.atR);
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
            if (this.dIe != null) {
                this.dIe.setFromCDN(z);
            }
            if (this.dIf != null) {
                this.dIf.setFromCDN(z);
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
    public int aCc() {
        if (this.dJb != null) {
            return e.g.frs_fortune_bag_item;
        }
        return 0;
    }

    @Override // com.baidu.tieba.frs.entelechy.a.q
    public int aCd() {
        if (this.dJb != null) {
            return e.g.frs_my_service_item;
        }
        return 0;
    }

    @Override // com.baidu.tieba.frs.entelechy.a.q
    public int aCe() {
        if (this.dJb != null) {
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
    public void aCf() {
        if (this.mAdapters != null && this.mAdapters.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.mAdapters) {
                if (aVar instanceof com.baidu.tieba.frs.h) {
                    ((com.baidu.tieba.frs.h) aVar).a(this.dDf.getPageContext(), this.dDf.getUniqueId());
                }
            }
            bD(this.mAdapters);
        }
    }

    private void aBx() {
        com.baidu.tieba.frs.e.a aCh;
        if (this.dJl != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.mAdapters) {
                if ((aVar instanceof com.baidu.tieba.frs.e.c) && (aCh = ((com.baidu.tieba.frs.e.c) aVar).aCh()) != null) {
                    if (this.dJl.hbG == 1) {
                        aCh.dUJ = true;
                    } else {
                        aCh.dUJ = false;
                    }
                    if (this.dJl.ber() != null) {
                        aCh.dUL = this.dJl.ber().getId();
                    }
                    if (this.dDf != null && this.dDf.ayT() != null) {
                        aCh.dUK = this.dDf.ayT().aEG();
                    }
                }
            }
            aCg();
        }
    }

    private void aCg() {
        com.baidu.tieba.frs.e.a aVar = new com.baidu.tieba.frs.e.a();
        if (this.dJl.hbG == 1) {
            aVar.dUJ = true;
        } else {
            aVar.dUJ = false;
        }
        if (this.dJl.ber() != null) {
            aVar.dUL = this.dJl.ber().getId();
        }
        if (this.dDf != null && this.dDf.ayT() != null) {
            aVar.dUK = this.dDf.ayT().aEG();
        }
        if (com.baidu.tieba.frs.e.c.dJF != null) {
            aVar.dUM = com.baidu.tieba.frs.e.c.dJF.dUM;
            aVar.dUN = com.baidu.tieba.frs.e.c.dJF.dUN;
        }
        com.baidu.tieba.frs.live.b bVar = new com.baidu.tieba.frs.live.b(aVar);
        CustomMessageTask customMessageTask = new CustomMessageTask(2921018, bVar);
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
        CustomMessageTask customMessageTask2 = new CustomMessageTask(2921017, bVar);
        customMessageTask2.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask2);
        CustomMessageTask customMessageTask3 = new CustomMessageTask(2921016, bVar);
        customMessageTask3.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask3);
        CustomMessageTask customMessageTask4 = new CustomMessageTask(2921019, bVar);
        customMessageTask4.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask4);
    }

    @Override // com.baidu.tieba.frs.entelechy.a.q
    public List<com.baidu.adp.widget.ListView.h> getDatas() {
        if (this.dIZ != null) {
            return this.dIZ.getData();
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
                    if (!it.hasNext() || it.next().getType().getId() != bb.apF.getId()) {
                        break;
                    }
                    i2 = i + 1;
                }
            }
            for (com.baidu.adp.widget.ListView.a aVar : this.mAdapters) {
                if (aVar instanceof com.baidu.tieba.frs.h) {
                    ((com.baidu.tieba.frs.h) aVar).lD(i);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bD(List<com.baidu.adp.widget.ListView.a> list) {
        if (list != null) {
            for (com.baidu.adp.widget.ListView.a aVar : list) {
                if (aVar instanceof com.baidu.tieba.frs.h) {
                    ((com.baidu.tieba.frs.h) aVar).a(this.dBk);
                }
            }
        }
    }

    private void js(String str) {
        if (this.mAdapters != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.mAdapters) {
                if (aVar instanceof com.baidu.tieba.a.f) {
                    ((com.baidu.tieba.a.f) aVar).js(str);
                }
            }
        }
    }
}
