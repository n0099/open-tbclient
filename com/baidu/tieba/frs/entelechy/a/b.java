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
    private ArrayList<com.baidu.adp.widget.ListView.h> axU;
    private FrsFragment dNb;
    private com.baidu.tieba.frs.l dPI;
    private com.baidu.adp.widget.ListView.m dSZ;
    private i dSa;
    private i dSb;
    private l dSc;
    private p dSd;
    private d dSe;
    private g dTa;
    private com.baidu.adp.widget.ListView.a dTb;
    private com.baidu.adp.widget.ListView.a dTc;
    private com.baidu.adp.widget.ListView.a dTd;
    private List<com.baidu.adp.widget.ListView.a> dTe;
    private j dTf;
    private f dTg;
    private m dTh;
    private n dTi;
    private e dTj;
    private final HashMap<Integer, bb> dTk;
    private com.baidu.tieba.tbadkCore.l dTl;
    private List<com.baidu.adp.widget.ListView.a> mAdapters = new LinkedList();
    private boolean dTm = false;
    private CustomMessageListener dSg = new CustomMessageListener(2003008) { // from class: com.baidu.tieba.frs.entelechy.a.b.1
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
                        ((com.baidu.tieba.frs.h) aVar).a(b.this.dNb.getPageContext(), b.this.dNb.getUniqueId());
                    }
                }
                ArrayList arrayList = new ArrayList();
                arrayList.addAll(absDelegateAdapterList);
                b.this.bH(arrayList);
                if (b.this.mAdapters != null) {
                    b.this.mAdapters.addAll(absDelegateAdapterList);
                }
                if (b.this.dSZ != null) {
                    b.this.mAdapters.addAll(arrayList);
                    b.this.dSZ.addAdapters(arrayList);
                }
            }
        }
    };
    private CustomMessageListener dTn = new CustomMessageListener(2016470) { // from class: com.baidu.tieba.frs.entelechy.a.b.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && v.I(b.this.dTe)) {
                b.this.aEW();
                b.this.b(b.this.axU, b.this.dTl);
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
                bVar.atA = true;
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
                bVar.atA = false;
                b.this.ae(bVar);
            }
        }
    };
    private CustomMessageListener dTo = new CustomMessageListener(2016492) { // from class: com.baidu.tieba.frs.entelechy.a.b.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.data.g)) {
                b.this.af((com.baidu.tbadk.data.g) customResponsedMessage.getData());
            }
        }
    };
    private final com.baidu.tieba.frs.f dLg = new com.baidu.tieba.frs.f();

    public b(FrsFragment frsFragment, com.baidu.adp.widget.ListView.m mVar, boolean z) {
        this.dSZ = mVar;
        a(frsFragment, mVar);
        this.dTk = new HashMap<>();
        hg(z);
    }

    public void a(FrsFragment frsFragment, com.baidu.adp.widget.ListView.m mVar) {
        this.dNb = frsFragment;
        this.dSa = new i(frsFragment.getPageContext(), bb.atI, this.dNb.getUniqueId());
        this.dSa.setVoiceManager(frsFragment.getVoiceManager());
        this.dSa.setInFrsAllThread(true);
        this.dTa = new g(frsFragment.getPageContext(), bb.atJ, this.dNb.getUniqueId());
        this.dTa.setInFrsAllThread(true);
        this.dSc = new l(frsFragment.getPageContext(), bb.atP, this.dNb.getUniqueId());
        this.dSc.setInFrsAllThread(true);
        this.dSb = new i(frsFragment.getPageContext(), bb.atK, this.dNb.getUniqueId());
        this.dSb.setVoiceManager(frsFragment.getVoiceManager());
        this.dSb.setInFrsAllThread(true);
        this.dSd = new p(frsFragment.getPageContext(), bb.atL, this.dNb.getUniqueId());
        this.dSd.setInFrsAllThread(true);
        this.dSe = new d(frsFragment.getPageContext(), bb.atQ, this.dNb.getUniqueId());
        this.dSe.setInFrsAllThread(true);
        this.dTb = com.baidu.tieba.frs.c.aBp().a(frsFragment.getPageContext(), s.hox, this.dNb.getUniqueId(), false);
        this.dPI = new com.baidu.tieba.frs.l(frsFragment.getPageContext(), com.baidu.tieba.frs.m.dOd);
        this.dTc = com.baidu.tieba.frs.c.aBp().a(frsFragment.getPageContext(), bb.avf, this.dNb.getUniqueId(), true);
        this.dTd = com.baidu.tieba.frs.c.aBp().b(frsFragment.getPageContext(), bb.avn, this.dNb.getUniqueId());
        this.dTf = new j(frsFragment.getPageContext(), com.baidu.tieba.frs.p.dOi);
        this.dTg = new f(frsFragment.getPageContext(), bb.atW, this.dNb.getUniqueId());
        this.dTh = new m(frsFragment.getPageContext(), com.baidu.tieba.frs.q.dOo, this.dNb.getUniqueId());
        this.dTi = new n(frsFragment.getPageContext().getPageActivity(), com.baidu.tieba.tbadkCore.k.hom, this.dNb.getUniqueId());
        this.dTj = new e(frsFragment.getPageContext(), bb.atR, this.dNb.getUniqueId());
        this.mAdapters.add(this.dTi);
        this.mAdapters.add(this.dSa);
        this.mAdapters.add(this.dTa);
        this.mAdapters.add(this.dSc);
        this.mAdapters.add(this.dSb);
        this.mAdapters.add(this.dTh);
        com.baidu.tieba.InjectPlugin.b.b bVar = new com.baidu.tieba.InjectPlugin.b.b(this.dNb, 1);
        bVar.setExtraData(this.mAdapters);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016515, bVar));
        this.mAdapters.add(this.dTg);
        if (this.dTb != null) {
            this.mAdapters.add(this.dTb);
        }
        this.mAdapters.add(this.dPI);
        this.mAdapters.add(this.dSd);
        this.mAdapters.add(this.dSe);
        this.mAdapters.add(new u(this.dNb.getPageContext(), com.baidu.tieba.frs.v.dOK));
        this.mAdapters.add(this.dTc);
        if (this.dTd != null) {
            this.mAdapters.add(this.dTd);
        }
        this.mAdapters.add(this.dTf);
        this.mAdapters.add(this.dTj);
        this.dSg.setPriority(1);
        this.dSg.setSelfListener(true);
        this.dNb.registerListener(this.dSg);
        this.dNb.registerListener(this.mAttentionListener);
        this.dNb.registerListener(this.mLikeForumListener);
        this.dNb.registerListener(this.mUnlikeForumListener);
        this.dNb.registerListener(this.dTo);
        aEV();
        CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2003008, new AbsDelegateAdapterList());
        CustomMessage customMessage = new CustomMessage(2003008);
        customMessage.setTag(this.dNb.getUniqueId());
        customResponsedMessage.setOrginalMessage(customMessage);
        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
        bH(this.mAdapters);
        mVar.addAdapters(this.mAdapters);
        kb("page_frs");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ae(Object obj) {
        boolean z;
        boolean z2 = false;
        if (this.axU != null) {
            Iterator<com.baidu.adp.widget.ListView.h> it = this.axU.iterator();
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
        if (this.axU != null) {
            Iterator<com.baidu.adp.widget.ListView.h> it = this.axU.iterator();
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

    private void aEV() {
        if (this.dNb != null && !aEW()) {
            this.dNb.registerListener(this.dTn);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v5, resolved type: com.baidu.tieba.frs.FrsFragment */
    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public boolean aEW() {
        if (this.dNb == null) {
            return false;
        }
        this.dTe = new ArrayList();
        ArrayList<BdUniqueId> bEf = com.baidu.tieba.tbadkCore.q.bEf();
        if (bEf == null || bEf.size() <= 0) {
            return false;
        }
        int size = bEf.size();
        for (int i = 0; i < size; i++) {
            com.baidu.tieba.frs.h<ICardInfo, ? extends q.a> a = com.baidu.tieba.frs.c.aBp().a(this.dNb.getPageContext(), bEf.get(i), this.dNb.getUniqueId());
            if (a != null) {
                this.mAdapters.add(a);
                this.dTe.add(a);
            }
        }
        if (!v.I(this.dTe)) {
            this.dSZ.addAdapters(this.dTe);
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
        this.dSZ.setData(arrayList);
        this.dTl = lVar;
        aEt();
        aEX();
        this.axU = arrayList;
    }

    private void d(com.baidu.tieba.tbadkCore.l lVar) {
        if (lVar != null && lVar.bhx() != null && "worldcup".equals(lVar.bhx().getSpecialForumType())) {
            com.baidu.tieba.frs.worldcup.c.a(lVar.bhx().getId(), 2, this.dSa, this.dSd, this.dTj, this.dSb, this.dSe);
        }
    }

    private void aEX() {
        if (this.dTl != null && this.dTl.bhx() != null && !StringUtils.isNull(this.dTl.bhx().getId()) && this.dTi != null) {
            this.dTi.setForumId(this.dTl.bhx().getId());
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
                String As = bbVar.As();
                if (hVar instanceof com.baidu.tieba.frs.p) {
                    bbVar.needTopMargin = false;
                } else if (hVar != null && !d(hVar)) {
                    bbVar.needTopMargin = false;
                } else if ((hVar instanceof bb) && d(hVar) && !TextUtils.isEmpty(((bb) hVar).As())) {
                    bbVar.needTopMargin = true;
                } else if (d(hVar2) && !TextUtils.isEmpty(As)) {
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
        return type == bb.atI || type == bb.atK || type == bb.atL || type == bb.atQ || type == bb.atW;
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
                if (this.dTk != null && !this.dTk.containsValue(hVar)) {
                    this.dTk.put(Integer.valueOf(i2), (bb) hVar);
                }
            }
            i = i2 + 1;
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.a.q
    public void hg(boolean z) {
        if (this.dTm != z) {
            this.dTm = z;
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.a.q
    public HashMap<Integer, bb> aEY() {
        return this.dTk;
    }

    @Override // com.baidu.tieba.frs.entelechy.a.q
    public void aEZ() {
        List<com.baidu.adp.widget.ListView.h> data;
        if (this.dSZ != null && this.dSZ.getData() != null && this.dSZ.getData().size() != 0 && (data = this.dSZ.getData()) != null && data.size() != 0) {
            for (com.baidu.adp.widget.ListView.h hVar : data) {
                if ((hVar instanceof bb) && ((bb) hVar).zO() != 0) {
                    ((bb) hVar).AD();
                }
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.a.q
    public void notifyDataSetChanged() {
        if (this.dSZ.getListAdapter() != null) {
            this.dSZ.getListAdapter().notifyDataSetChanged();
        }
    }

    public void notifyDataChanged() {
        if (this.axU != null) {
            this.dSZ.setData(this.axU);
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
            if (this.dSa != null) {
                this.dSa.setFromCDN(z);
            }
            if (this.dSb != null) {
                this.dSb.setFromCDN(z);
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
    public int aFa() {
        if (this.dTb != null) {
            return e.g.frs_fortune_bag_item;
        }
        return 0;
    }

    @Override // com.baidu.tieba.frs.entelechy.a.q
    public int aFb() {
        if (this.dTb != null) {
            return e.g.frs_my_service_item;
        }
        return 0;
    }

    @Override // com.baidu.tieba.frs.entelechy.a.q
    public int aFc() {
        if (this.dTb != null) {
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
    public void aFd() {
        if (this.mAdapters != null && this.mAdapters.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.mAdapters) {
                if (aVar instanceof com.baidu.tieba.frs.h) {
                    ((com.baidu.tieba.frs.h) aVar).a(this.dNb.getPageContext(), this.dNb.getUniqueId());
                }
            }
            bH(this.mAdapters);
        }
    }

    private void aEt() {
        com.baidu.tieba.frs.e.b aFf;
        if (this.dTl != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.mAdapters) {
                if ((aVar instanceof com.baidu.tieba.frs.e.d) && (aFf = ((com.baidu.tieba.frs.e.d) aVar).aFf()) != null) {
                    if (this.dTl.hmP == 1) {
                        aFf.eeJ = true;
                    } else {
                        aFf.eeJ = false;
                    }
                    if (this.dTl.bhx() != null) {
                        aFf.eeL = this.dTl.bhx().getId();
                    }
                    if (this.dNb != null && this.dNb.aBP() != null) {
                        aFf.eeK = this.dNb.aBP().aHE();
                    }
                }
            }
            aFe();
        }
    }

    private void aFe() {
        com.baidu.tieba.frs.e.b bVar = new com.baidu.tieba.frs.e.b();
        if (this.dTl.hmP == 1) {
            bVar.eeJ = true;
        } else {
            bVar.eeJ = false;
        }
        if (this.dTl.bhx() != null) {
            bVar.eeL = this.dTl.bhx().getId();
        }
        if (this.dNb != null && this.dNb.aBP() != null) {
            bVar.eeK = this.dNb.aBP().aHE();
        }
        if (com.baidu.tieba.frs.e.d.dTF != null) {
            bVar.eeM = com.baidu.tieba.frs.e.d.dTF.eeM;
            bVar.eeN = com.baidu.tieba.frs.e.d.dTF.eeN;
        }
        com.baidu.tieba.frs.live.b bVar2 = new com.baidu.tieba.frs.live.b(bVar, this.dNb.getUniqueId());
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
        if (this.dSZ != null) {
            return this.dSZ.getData();
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
                    if (!it.hasNext() || it.next().getType().getId() != bb.atH.getId()) {
                        break;
                    }
                    i2 = i + 1;
                }
            }
            for (com.baidu.adp.widget.ListView.a aVar : this.mAdapters) {
                if (aVar instanceof com.baidu.tieba.frs.h) {
                    ((com.baidu.tieba.frs.h) aVar).mh(i);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bH(List<com.baidu.adp.widget.ListView.a> list) {
        if (list != null) {
            for (com.baidu.adp.widget.ListView.a aVar : list) {
                if (aVar instanceof com.baidu.tieba.frs.h) {
                    ((com.baidu.tieba.frs.h) aVar).a(this.dLg);
                }
            }
        }
    }

    private void kb(String str) {
        if (this.mAdapters != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.mAdapters) {
                if (aVar instanceof com.baidu.tieba.a.f) {
                    ((com.baidu.tieba.a.f) aVar).kb(str);
                }
            }
        }
    }
}
