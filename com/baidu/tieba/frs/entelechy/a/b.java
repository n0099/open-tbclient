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
    private ArrayList<com.baidu.adp.widget.ListView.h> ate;
    private FrsFragment dBO;
    private com.baidu.tieba.frs.l dEw;
    private p dGP;
    private d dGQ;
    private com.baidu.adp.widget.ListView.m dHV;
    private g dHW;
    private com.baidu.adp.widget.ListView.a dHX;
    private com.baidu.adp.widget.ListView.a dHY;
    private com.baidu.adp.widget.ListView.a dHZ;
    private i dHh;
    private i dHi;
    private l dHj;
    private List<com.baidu.adp.widget.ListView.a> dIa;
    private j dIb;
    private f dIc;
    private m dId;
    private n dIe;
    private e dIf;
    private final HashMap<Integer, bb> dIg;
    private com.baidu.tieba.tbadkCore.l dIh;
    private List<com.baidu.adp.widget.ListView.a> mAdapters = new LinkedList();
    private boolean dIi = false;
    private CustomMessageListener dHk = new CustomMessageListener(2003008) { // from class: com.baidu.tieba.frs.entelechy.a.b.1
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
                        ((com.baidu.tieba.frs.h) aVar).a(b.this.dBO.getPageContext(), b.this.dBO.getUniqueId());
                    }
                }
                ArrayList arrayList = new ArrayList();
                arrayList.addAll(absDelegateAdapterList);
                b.this.bF(arrayList);
                if (b.this.mAdapters != null) {
                    b.this.mAdapters.addAll(absDelegateAdapterList);
                }
                if (b.this.dHV != null) {
                    b.this.mAdapters.addAll(arrayList);
                    b.this.dHV.addAdapters(arrayList);
                }
            }
        }
    };
    private CustomMessageListener dIj = new CustomMessageListener(2016470) { // from class: com.baidu.tieba.frs.entelechy.a.b.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && v.J(b.this.dIa)) {
                b.this.aCE();
                b.this.b(b.this.ate, b.this.dIh);
            }
        }
    };
    private CustomMessageListener mAttentionListener = new CustomMessageListener(2001115) { // from class: com.baidu.tieba.frs.entelechy.a.b.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
            if (updateAttentionMessage != null && updateAttentionMessage.getData() != null && updateAttentionMessage.getData().Jo) {
                b.this.af(updateAttentionMessage.getData());
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
                bVar.aoK = true;
                b.this.af(bVar);
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
                bVar.aoK = false;
                b.this.af(bVar);
            }
        }
    };
    private CustomMessageListener dIk = new CustomMessageListener(2016492) { // from class: com.baidu.tieba.frs.entelechy.a.b.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.data.g)) {
                b.this.ag((com.baidu.tbadk.data.g) customResponsedMessage.getData());
            }
        }
    };
    private final com.baidu.tieba.frs.f dzT = new com.baidu.tieba.frs.f();

    public b(FrsFragment frsFragment, com.baidu.adp.widget.ListView.m mVar, boolean z) {
        this.dHV = mVar;
        a(frsFragment, mVar);
        this.dIg = new HashMap<>();
        gP(z);
    }

    public void a(FrsFragment frsFragment, com.baidu.adp.widget.ListView.m mVar) {
        this.dBO = frsFragment;
        this.dHh = new i(frsFragment.getPageContext(), bb.aoS, this.dBO.getUniqueId());
        this.dHh.setVoiceManager(frsFragment.getVoiceManager());
        this.dHh.setInFrsAllThread(true);
        this.dHW = new g(frsFragment.getPageContext(), bb.aoT, this.dBO.getUniqueId());
        this.dHW.setInFrsAllThread(true);
        this.dHj = new l(frsFragment.getPageContext(), bb.aoZ, this.dBO.getUniqueId());
        this.dHj.setInFrsAllThread(true);
        this.dHi = new i(frsFragment.getPageContext(), bb.aoU, this.dBO.getUniqueId());
        this.dHi.setVoiceManager(frsFragment.getVoiceManager());
        this.dHi.setInFrsAllThread(true);
        this.dGP = new p(frsFragment.getPageContext(), bb.aoV, this.dBO.getUniqueId());
        this.dGP.setInFrsAllThread(true);
        this.dGQ = new d(frsFragment.getPageContext(), bb.apa, this.dBO.getUniqueId());
        this.dGQ.setInFrsAllThread(true);
        this.dHX = com.baidu.tieba.frs.c.ayW().a(frsFragment.getPageContext(), s.hbQ, this.dBO.getUniqueId(), false);
        this.dEw = new com.baidu.tieba.frs.l(frsFragment.getPageContext(), com.baidu.tieba.frs.m.dCR);
        this.dHY = com.baidu.tieba.frs.c.ayW().a(frsFragment.getPageContext(), bb.aqq, this.dBO.getUniqueId(), true);
        this.dHZ = com.baidu.tieba.frs.c.ayW().b(frsFragment.getPageContext(), bb.aqy, this.dBO.getUniqueId());
        this.dIb = new j(frsFragment.getPageContext(), com.baidu.tieba.frs.p.dCW);
        this.dIc = new f(frsFragment.getPageContext(), bb.apg, this.dBO.getUniqueId());
        this.dId = new m(frsFragment.getPageContext(), com.baidu.tieba.frs.q.dDc, this.dBO.getUniqueId());
        this.dIe = new n(frsFragment.getPageContext().getPageActivity(), com.baidu.tieba.tbadkCore.k.hbF, this.dBO.getUniqueId());
        this.dIf = new e(frsFragment.getPageContext(), bb.apb, this.dBO.getUniqueId());
        this.mAdapters.add(this.dIe);
        this.mAdapters.add(this.dHh);
        this.mAdapters.add(this.dHW);
        this.mAdapters.add(this.dHj);
        this.mAdapters.add(this.dHi);
        this.mAdapters.add(this.dId);
        com.baidu.tieba.InjectPlugin.b.b bVar = new com.baidu.tieba.InjectPlugin.b.b(this.dBO, 1);
        bVar.setExtraData(this.mAdapters);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016515, bVar));
        this.mAdapters.add(this.dIc);
        if (this.dHX != null) {
            this.mAdapters.add(this.dHX);
        }
        this.mAdapters.add(this.dEw);
        this.mAdapters.add(this.dGP);
        this.mAdapters.add(this.dGQ);
        this.mAdapters.add(new u(this.dBO.getPageContext(), com.baidu.tieba.frs.v.dDy));
        this.mAdapters.add(this.dHY);
        if (this.dHZ != null) {
            this.mAdapters.add(this.dHZ);
        }
        this.mAdapters.add(this.dIb);
        this.mAdapters.add(this.dIf);
        this.dHk.setPriority(1);
        this.dHk.setSelfListener(true);
        this.dBO.registerListener(this.dHk);
        this.dBO.registerListener(this.mAttentionListener);
        this.dBO.registerListener(this.mLikeForumListener);
        this.dBO.registerListener(this.mUnlikeForumListener);
        this.dBO.registerListener(this.dIk);
        aCD();
        CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2003008, new AbsDelegateAdapterList());
        CustomMessage customMessage = new CustomMessage(2003008);
        customMessage.setTag(this.dBO.getUniqueId());
        customResponsedMessage.setOrginalMessage(customMessage);
        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
        bF(this.mAdapters);
        mVar.addAdapters(this.mAdapters);
        jq("page_frs");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void af(Object obj) {
        boolean z;
        boolean z2 = false;
        if (this.ate != null) {
            Iterator<com.baidu.adp.widget.ListView.h> it = this.ate.iterator();
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
    public void ag(Object obj) {
        if (this.ate != null) {
            Iterator<com.baidu.adp.widget.ListView.h> it = this.ate.iterator();
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

    private void aCD() {
        if (this.dBO != null && !aCE()) {
            this.dBO.registerListener(this.dIj);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v5, resolved type: com.baidu.tieba.frs.FrsFragment */
    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public boolean aCE() {
        if (this.dBO == null) {
            return false;
        }
        this.dIa = new ArrayList();
        ArrayList<BdUniqueId> bBo = com.baidu.tieba.tbadkCore.q.bBo();
        if (bBo == null || bBo.size() <= 0) {
            return false;
        }
        int size = bBo.size();
        for (int i = 0; i < size; i++) {
            com.baidu.tieba.frs.h<ICardInfo, ? extends q.a> a = com.baidu.tieba.frs.c.ayW().a(this.dBO.getPageContext(), bBo.get(i), this.dBO.getUniqueId());
            if (a != null) {
                this.mAdapters.add(a);
                this.dIa.add(a);
            }
        }
        if (!v.J(this.dIa)) {
            this.dHV.addAdapters(this.dIa);
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
        R(arrayList);
        S(arrayList);
        Q(arrayList);
        this.dHV.setData(arrayList);
        this.dIh = lVar;
        aCa();
        aCF();
        this.ate = arrayList;
    }

    private void c(com.baidu.tieba.tbadkCore.l lVar) {
        if (lVar != null && lVar.beT() != null && "worldcup".equals(lVar.beT().getSpecialForumType())) {
            com.baidu.tieba.frs.worldcup.c.a(lVar.beT().getId(), 2, this.dHh, this.dGP, this.dIf, this.dHi, this.dGQ);
        }
    }

    private void aCF() {
        if (this.dIh != null && this.dIh.beT() != null && !StringUtils.isNull(this.dIh.beT().getId()) && this.dIe != null) {
            this.dIe.setForumId(this.dIh.beT().getId());
        }
    }

    private void Q(ArrayList<com.baidu.adp.widget.ListView.h> arrayList) {
        int I = v.I(arrayList);
        for (int i = 0; i < I; i++) {
            com.baidu.adp.widget.ListView.h hVar = (com.baidu.adp.widget.ListView.h) v.d(arrayList, i - 1);
            com.baidu.adp.widget.ListView.h hVar2 = (com.baidu.adp.widget.ListView.h) v.d(arrayList, i);
            if (hVar2 instanceof bb) {
                bb bbVar = (bb) hVar2;
                if (i == 0) {
                    bbVar.isFirstFloor = true;
                } else {
                    bbVar.isFirstFloor = false;
                }
                String yU = bbVar.yU();
                if (hVar instanceof com.baidu.tieba.frs.p) {
                    bbVar.needTopMargin = false;
                } else if (hVar != null && !d(hVar)) {
                    bbVar.needTopMargin = false;
                } else if ((hVar instanceof bb) && d(hVar) && !TextUtils.isEmpty(((bb) hVar).yU())) {
                    bbVar.needTopMargin = true;
                } else if (d(hVar2) && !TextUtils.isEmpty(yU)) {
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
        return type == bb.aoS || type == bb.aoU || type == bb.aoV || type == bb.apa || type == bb.apg;
    }

    private ArrayList<Integer> R(ArrayList<com.baidu.adp.widget.ListView.h> arrayList) {
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
                if (this.dIg != null && !this.dIg.containsValue(hVar)) {
                    this.dIg.put(Integer.valueOf(i2), (bb) hVar);
                }
            }
            i = i2 + 1;
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.a.q
    public void gP(boolean z) {
        if (this.dIi != z) {
            this.dIi = z;
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.a.q
    public HashMap<Integer, bb> aCG() {
        return this.dIg;
    }

    @Override // com.baidu.tieba.frs.entelechy.a.q
    public void aCH() {
        List<com.baidu.adp.widget.ListView.h> data;
        if (this.dHV != null && this.dHV.getData() != null && this.dHV.getData().size() != 0 && (data = this.dHV.getData()) != null && data.size() != 0) {
            for (com.baidu.adp.widget.ListView.h hVar : data) {
                if ((hVar instanceof bb) && ((bb) hVar).yq() != 0) {
                    ((bb) hVar).zf();
                }
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.a.q
    public void notifyDataSetChanged() {
        if (this.dHV.getListAdapter() != null) {
            this.dHV.getListAdapter().notifyDataSetChanged();
        }
    }

    public void notifyDataChanged() {
        if (this.ate != null) {
            this.dHV.setData(this.ate);
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
            if (this.dHh != null) {
                this.dHh.setFromCDN(z);
            }
            if (this.dHi != null) {
                this.dHi.setFromCDN(z);
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
    public int aCI() {
        if (this.dHX != null) {
            return e.g.frs_fortune_bag_item;
        }
        return 0;
    }

    @Override // com.baidu.tieba.frs.entelechy.a.q
    public int aCJ() {
        if (this.dHX != null) {
            return e.g.frs_my_service_item;
        }
        return 0;
    }

    @Override // com.baidu.tieba.frs.entelechy.a.q
    public int aCK() {
        if (this.dHX != null) {
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
    public void aCL() {
        if (this.mAdapters != null && this.mAdapters.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.mAdapters) {
                if (aVar instanceof com.baidu.tieba.frs.h) {
                    ((com.baidu.tieba.frs.h) aVar).a(this.dBO.getPageContext(), this.dBO.getUniqueId());
                }
            }
            bF(this.mAdapters);
        }
    }

    private void aCa() {
        com.baidu.tieba.frs.e.a aCN;
        if (this.dIh != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.mAdapters) {
                if ((aVar instanceof com.baidu.tieba.frs.e.c) && (aCN = ((com.baidu.tieba.frs.e.c) aVar).aCN()) != null) {
                    if (this.dIh.haj == 1) {
                        aCN.dTD = true;
                    } else {
                        aCN.dTD = false;
                    }
                    if (this.dIh.beT() != null) {
                        aCN.dTF = this.dIh.beT().getId();
                    }
                    if (this.dBO != null && this.dBO.azw() != null) {
                        aCN.dTE = this.dBO.azw().aFk();
                    }
                }
            }
            aCM();
        }
    }

    private void aCM() {
        com.baidu.tieba.frs.e.a aVar = new com.baidu.tieba.frs.e.a();
        if (this.dIh.haj == 1) {
            aVar.dTD = true;
        } else {
            aVar.dTD = false;
        }
        if (this.dIh.beT() != null) {
            aVar.dTF = this.dIh.beT().getId();
        }
        if (this.dBO != null && this.dBO.azw() != null) {
            aVar.dTE = this.dBO.azw().aFk();
        }
        if (com.baidu.tieba.frs.e.c.dIB != null) {
            aVar.dTG = com.baidu.tieba.frs.e.c.dIB.dTG;
            aVar.dTH = com.baidu.tieba.frs.e.c.dIB.dTH;
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
        if (this.dHV != null) {
            return this.dHV.getData();
        }
        return null;
    }

    private void S(ArrayList<com.baidu.adp.widget.ListView.h> arrayList) {
        int i;
        if (this.mAdapters != null && this.mAdapters.size() != 0) {
            int i2 = 0;
            if (arrayList == null || arrayList.size() <= 0) {
                i = 0;
            } else {
                Iterator<com.baidu.adp.widget.ListView.h> it = arrayList.iterator();
                while (true) {
                    i = i2;
                    if (!it.hasNext() || it.next().getType().getId() != bb.aoR.getId()) {
                        break;
                    }
                    i2 = i + 1;
                }
            }
            for (com.baidu.adp.widget.ListView.a aVar : this.mAdapters) {
                if (aVar instanceof com.baidu.tieba.frs.h) {
                    ((com.baidu.tieba.frs.h) aVar).ll(i);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bF(List<com.baidu.adp.widget.ListView.a> list) {
        if (list != null) {
            for (com.baidu.adp.widget.ListView.a aVar : list) {
                if (aVar instanceof com.baidu.tieba.frs.h) {
                    ((com.baidu.tieba.frs.h) aVar).a(this.dzT);
                }
            }
        }
    }

    private void jq(String str) {
        if (this.mAdapters != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.mAdapters) {
                if (aVar instanceof com.baidu.tieba.a.f) {
                    ((com.baidu.tieba.a.f) aVar).jq(str);
                }
            }
        }
    }
}
