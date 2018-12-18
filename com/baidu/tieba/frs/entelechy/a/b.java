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
    private ArrayList<com.baidu.adp.widget.ListView.h> axr;
    private FrsFragment dJE;
    private com.baidu.tieba.frs.l dMl;
    private i dOD;
    private i dOE;
    private l dOF;
    private p dOG;
    private d dOH;
    private com.baidu.adp.widget.ListView.m dPC;
    private g dPD;
    private com.baidu.adp.widget.ListView.a dPE;
    private com.baidu.adp.widget.ListView.a dPF;
    private com.baidu.adp.widget.ListView.a dPG;
    private List<com.baidu.adp.widget.ListView.a> dPH;
    private j dPI;
    private f dPJ;
    private m dPK;
    private n dPL;
    private e dPM;
    private final HashMap<Integer, bb> dPN;
    private com.baidu.tieba.tbadkCore.l dPO;
    private List<com.baidu.adp.widget.ListView.a> mAdapters = new LinkedList();
    private boolean dPP = false;
    private CustomMessageListener dOJ = new CustomMessageListener(2003008) { // from class: com.baidu.tieba.frs.entelechy.a.b.1
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
                        ((com.baidu.tieba.frs.h) aVar).a(b.this.dJE.getPageContext(), b.this.dJE.getUniqueId());
                    }
                }
                ArrayList arrayList = new ArrayList();
                arrayList.addAll(absDelegateAdapterList);
                b.this.bF(arrayList);
                if (b.this.mAdapters != null) {
                    b.this.mAdapters.addAll(absDelegateAdapterList);
                }
                if (b.this.dPC != null) {
                    b.this.mAdapters.addAll(arrayList);
                    b.this.dPC.addAdapters(arrayList);
                }
            }
        }
    };
    private CustomMessageListener dPQ = new CustomMessageListener(2016470) { // from class: com.baidu.tieba.frs.entelechy.a.b.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && v.I(b.this.dPH)) {
                b.this.aDK();
                b.this.b(b.this.axr, b.this.dPO);
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
    private CustomMessageListener dPR = new CustomMessageListener(2016492) { // from class: com.baidu.tieba.frs.entelechy.a.b.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.data.g)) {
                b.this.af((com.baidu.tbadk.data.g) customResponsedMessage.getData());
            }
        }
    };
    private final com.baidu.tieba.frs.f dHJ = new com.baidu.tieba.frs.f();

    public b(FrsFragment frsFragment, com.baidu.adp.widget.ListView.m mVar, boolean z) {
        this.dPC = mVar;
        a(frsFragment, mVar);
        this.dPN = new HashMap<>();
        ha(z);
    }

    public void a(FrsFragment frsFragment, com.baidu.adp.widget.ListView.m mVar) {
        this.dJE = frsFragment;
        this.dOD = new i(frsFragment.getPageContext(), bb.atg, this.dJE.getUniqueId());
        this.dOD.setVoiceManager(frsFragment.getVoiceManager());
        this.dOD.setInFrsAllThread(true);
        this.dPD = new g(frsFragment.getPageContext(), bb.ath, this.dJE.getUniqueId());
        this.dPD.setInFrsAllThread(true);
        this.dOF = new l(frsFragment.getPageContext(), bb.atn, this.dJE.getUniqueId());
        this.dOF.setInFrsAllThread(true);
        this.dOE = new i(frsFragment.getPageContext(), bb.ati, this.dJE.getUniqueId());
        this.dOE.setVoiceManager(frsFragment.getVoiceManager());
        this.dOE.setInFrsAllThread(true);
        this.dOG = new p(frsFragment.getPageContext(), bb.atj, this.dJE.getUniqueId());
        this.dOG.setInFrsAllThread(true);
        this.dOH = new d(frsFragment.getPageContext(), bb.ato, this.dJE.getUniqueId());
        this.dOH.setInFrsAllThread(true);
        this.dPE = com.baidu.tieba.frs.c.aAd().a(frsFragment.getPageContext(), s.hkh, this.dJE.getUniqueId(), false);
        this.dMl = new com.baidu.tieba.frs.l(frsFragment.getPageContext(), com.baidu.tieba.frs.m.dKG);
        this.dPF = com.baidu.tieba.frs.c.aAd().a(frsFragment.getPageContext(), bb.auD, this.dJE.getUniqueId(), true);
        this.dPG = com.baidu.tieba.frs.c.aAd().b(frsFragment.getPageContext(), bb.auL, this.dJE.getUniqueId());
        this.dPI = new j(frsFragment.getPageContext(), com.baidu.tieba.frs.p.dKL);
        this.dPJ = new f(frsFragment.getPageContext(), bb.atu, this.dJE.getUniqueId());
        this.dPK = new m(frsFragment.getPageContext(), com.baidu.tieba.frs.q.dKR, this.dJE.getUniqueId());
        this.dPL = new n(frsFragment.getPageContext().getPageActivity(), com.baidu.tieba.tbadkCore.k.hjW, this.dJE.getUniqueId());
        this.dPM = new e(frsFragment.getPageContext(), bb.atp, this.dJE.getUniqueId());
        this.mAdapters.add(this.dPL);
        this.mAdapters.add(this.dOD);
        this.mAdapters.add(this.dPD);
        this.mAdapters.add(this.dOF);
        this.mAdapters.add(this.dOE);
        this.mAdapters.add(this.dPK);
        com.baidu.tieba.InjectPlugin.b.b bVar = new com.baidu.tieba.InjectPlugin.b.b(this.dJE, 1);
        bVar.setExtraData(this.mAdapters);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016515, bVar));
        this.mAdapters.add(this.dPJ);
        if (this.dPE != null) {
            this.mAdapters.add(this.dPE);
        }
        this.mAdapters.add(this.dMl);
        this.mAdapters.add(this.dOG);
        this.mAdapters.add(this.dOH);
        this.mAdapters.add(new u(this.dJE.getPageContext(), com.baidu.tieba.frs.v.dLn));
        this.mAdapters.add(this.dPF);
        if (this.dPG != null) {
            this.mAdapters.add(this.dPG);
        }
        this.mAdapters.add(this.dPI);
        this.mAdapters.add(this.dPM);
        this.dOJ.setPriority(1);
        this.dOJ.setSelfListener(true);
        this.dJE.registerListener(this.dOJ);
        this.dJE.registerListener(this.mAttentionListener);
        this.dJE.registerListener(this.mLikeForumListener);
        this.dJE.registerListener(this.mUnlikeForumListener);
        this.dJE.registerListener(this.dPR);
        aDJ();
        CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2003008, new AbsDelegateAdapterList());
        CustomMessage customMessage = new CustomMessage(2003008);
        customMessage.setTag(this.dJE.getUniqueId());
        customResponsedMessage.setOrginalMessage(customMessage);
        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
        bF(this.mAdapters);
        mVar.addAdapters(this.mAdapters);
        jK("page_frs");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ae(Object obj) {
        boolean z;
        boolean z2 = false;
        if (this.axr != null) {
            Iterator<com.baidu.adp.widget.ListView.h> it = this.axr.iterator();
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
        if (this.axr != null) {
            Iterator<com.baidu.adp.widget.ListView.h> it = this.axr.iterator();
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

    private void aDJ() {
        if (this.dJE != null && !aDK()) {
            this.dJE.registerListener(this.dPQ);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v5, resolved type: com.baidu.tieba.frs.FrsFragment */
    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public boolean aDK() {
        if (this.dJE == null) {
            return false;
        }
        this.dPH = new ArrayList();
        ArrayList<BdUniqueId> bCE = com.baidu.tieba.tbadkCore.q.bCE();
        if (bCE == null || bCE.size() <= 0) {
            return false;
        }
        int size = bCE.size();
        for (int i = 0; i < size; i++) {
            com.baidu.tieba.frs.h<ICardInfo, ? extends q.a> a = com.baidu.tieba.frs.c.aAd().a(this.dJE.getPageContext(), bCE.get(i), this.dJE.getUniqueId());
            if (a != null) {
                this.mAdapters.add(a);
                this.dPH.add(a);
            }
        }
        if (!v.I(this.dPH)) {
            this.dPC.addAdapters(this.dPH);
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
        this.dPC.setData(arrayList);
        this.dPO = lVar;
        aDh();
        aDL();
        this.axr = arrayList;
    }

    private void d(com.baidu.tieba.tbadkCore.l lVar) {
        if (lVar != null && lVar.bgh() != null && "worldcup".equals(lVar.bgh().getSpecialForumType())) {
            com.baidu.tieba.frs.worldcup.c.a(lVar.bgh().getId(), 2, this.dOD, this.dOG, this.dPM, this.dOE, this.dOH);
        }
    }

    private void aDL() {
        if (this.dPO != null && this.dPO.bgh() != null && !StringUtils.isNull(this.dPO.bgh().getId()) && this.dPL != null) {
            this.dPL.setForumId(this.dPO.bgh().getId());
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
                if (this.dPN != null && !this.dPN.containsValue(hVar)) {
                    this.dPN.put(Integer.valueOf(i2), (bb) hVar);
                }
            }
            i = i2 + 1;
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.a.q
    public void ha(boolean z) {
        if (this.dPP != z) {
            this.dPP = z;
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.a.q
    public HashMap<Integer, bb> aDM() {
        return this.dPN;
    }

    @Override // com.baidu.tieba.frs.entelechy.a.q
    public void aDN() {
        List<com.baidu.adp.widget.ListView.h> data;
        if (this.dPC != null && this.dPC.getData() != null && this.dPC.getData().size() != 0 && (data = this.dPC.getData()) != null && data.size() != 0) {
            for (com.baidu.adp.widget.ListView.h hVar : data) {
                if ((hVar instanceof bb) && ((bb) hVar).zB() != 0) {
                    ((bb) hVar).Aq();
                }
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.a.q
    public void notifyDataSetChanged() {
        if (this.dPC.getListAdapter() != null) {
            this.dPC.getListAdapter().notifyDataSetChanged();
        }
    }

    public void notifyDataChanged() {
        if (this.axr != null) {
            this.dPC.setData(this.axr);
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
            if (this.dOD != null) {
                this.dOD.setFromCDN(z);
            }
            if (this.dOE != null) {
                this.dOE.setFromCDN(z);
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
    public int aDO() {
        if (this.dPE != null) {
            return e.g.frs_fortune_bag_item;
        }
        return 0;
    }

    @Override // com.baidu.tieba.frs.entelechy.a.q
    public int aDP() {
        if (this.dPE != null) {
            return e.g.frs_my_service_item;
        }
        return 0;
    }

    @Override // com.baidu.tieba.frs.entelechy.a.q
    public int aDQ() {
        if (this.dPE != null) {
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
    public void aDR() {
        if (this.mAdapters != null && this.mAdapters.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.mAdapters) {
                if (aVar instanceof com.baidu.tieba.frs.h) {
                    ((com.baidu.tieba.frs.h) aVar).a(this.dJE.getPageContext(), this.dJE.getUniqueId());
                }
            }
            bF(this.mAdapters);
        }
    }

    private void aDh() {
        com.baidu.tieba.frs.e.a aDT;
        if (this.dPO != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.mAdapters) {
                if ((aVar instanceof com.baidu.tieba.frs.e.c) && (aDT = ((com.baidu.tieba.frs.e.c) aVar).aDT()) != null) {
                    if (this.dPO.hiz == 1) {
                        aDT.ebm = true;
                    } else {
                        aDT.ebm = false;
                    }
                    if (this.dPO.bgh() != null) {
                        aDT.ebo = this.dPO.bgh().getId();
                    }
                    if (this.dJE != null && this.dJE.aAD() != null) {
                        aDT.ebn = this.dJE.aAD().aGs();
                    }
                }
            }
            aDS();
        }
    }

    private void aDS() {
        com.baidu.tieba.frs.e.a aVar = new com.baidu.tieba.frs.e.a();
        if (this.dPO.hiz == 1) {
            aVar.ebm = true;
        } else {
            aVar.ebm = false;
        }
        if (this.dPO.bgh() != null) {
            aVar.ebo = this.dPO.bgh().getId();
        }
        if (this.dJE != null && this.dJE.aAD() != null) {
            aVar.ebn = this.dJE.aAD().aGs();
        }
        if (com.baidu.tieba.frs.e.c.dQi != null) {
            aVar.ebp = com.baidu.tieba.frs.e.c.dQi.ebp;
            aVar.ebq = com.baidu.tieba.frs.e.c.dQi.ebq;
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
        if (this.dPC != null) {
            return this.dPC.getData();
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
            for (com.baidu.adp.widget.ListView.a aVar : this.mAdapters) {
                if (aVar instanceof com.baidu.tieba.frs.h) {
                    ((com.baidu.tieba.frs.h) aVar).lT(i);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bF(List<com.baidu.adp.widget.ListView.a> list) {
        if (list != null) {
            for (com.baidu.adp.widget.ListView.a aVar : list) {
                if (aVar instanceof com.baidu.tieba.frs.h) {
                    ((com.baidu.tieba.frs.h) aVar).a(this.dHJ);
                }
            }
        }
    }

    private void jK(String str) {
        if (this.mAdapters != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.mAdapters) {
                if (aVar instanceof com.baidu.tieba.a.f) {
                    ((com.baidu.tieba.a.f) aVar).jK(str);
                }
            }
        }
    }
}
