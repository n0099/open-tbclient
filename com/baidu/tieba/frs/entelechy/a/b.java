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
import com.baidu.tbadk.core.data.bc;
import com.baidu.tbadk.core.util.w;
import com.baidu.tbadk.coreExtra.message.UpdateAttentionMessage;
import com.baidu.tieba.card.ab;
import com.baidu.tieba.d;
import com.baidu.tieba.frs.AbsDelegateAdapterList;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.frs.u;
import com.baidu.tieba.frs.v;
import com.baidu.tieba.lego.card.model.ICardInfo;
import com.baidu.tieba.tbadkCore.s;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes2.dex */
public class b implements q {
    private ArrayList<com.baidu.adp.widget.ListView.h> ami;
    private FrsFragment dla;
    private com.baidu.tieba.frs.l dnp;
    private i dpP;
    private i dpQ;
    private l dpR;
    private p dpS;
    private d dpT;
    private com.baidu.adp.widget.ListView.m dqF;
    private g dqG;
    private com.baidu.adp.widget.ListView.a dqH;
    private com.baidu.adp.widget.ListView.a dqI;
    private com.baidu.adp.widget.ListView.a dqJ;
    private List<com.baidu.adp.widget.ListView.a> dqK;
    private j dqL;
    private f dqM;
    private m dqN;
    private n dqO;
    private e dqP;
    private final HashMap<Integer, bc> dqQ;
    private com.baidu.tieba.tbadkCore.l dqR;
    private List<com.baidu.adp.widget.ListView.a> mAdapters = new LinkedList();
    private boolean dqS = false;
    private CustomMessageListener dpU = new CustomMessageListener(2003008) { // from class: com.baidu.tieba.frs.entelechy.a.b.1
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
                        ((com.baidu.tieba.frs.h) aVar).a(b.this.dla.getPageContext(), b.this.dla.getUniqueId());
                    }
                }
                ArrayList arrayList = new ArrayList();
                arrayList.addAll(absDelegateAdapterList);
                b.this.bp(arrayList);
                if (b.this.mAdapters != null) {
                    b.this.mAdapters.addAll(absDelegateAdapterList);
                }
                if (b.this.dqF != null) {
                    b.this.mAdapters.addAll(arrayList);
                    b.this.dqF.addAdapters(arrayList);
                }
            }
        }
    };
    private CustomMessageListener dqT = new CustomMessageListener(2016470) { // from class: com.baidu.tieba.frs.entelechy.a.b.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && w.A(b.this.dqK)) {
                b.this.aws();
                b.this.b(b.this.ami, b.this.dqR);
            }
        }
    };
    private CustomMessageListener mAttentionListener = new CustomMessageListener(2001115) { // from class: com.baidu.tieba.frs.entelechy.a.b.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
            if (updateAttentionMessage != null && updateAttentionMessage.getData() != null && updateAttentionMessage.getData().Gr) {
                b.this.Y(updateAttentionMessage.getData());
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
                bVar.ePT = true;
                b.this.Y(bVar);
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
                bVar.ePT = false;
                b.this.Y(bVar);
            }
        }
    };
    private CustomMessageListener dqU = new CustomMessageListener(2016492) { // from class: com.baidu.tieba.frs.entelechy.a.b.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.data.g)) {
                b.this.Z((com.baidu.tbadk.data.g) customResponsedMessage.getData());
            }
        }
    };
    private final com.baidu.tieba.frs.f djg = new com.baidu.tieba.frs.f();

    public b(FrsFragment frsFragment, com.baidu.adp.widget.ListView.m mVar, boolean z) {
        this.dqF = mVar;
        a(frsFragment, mVar);
        this.dqQ = new HashMap<>();
        fX(z);
    }

    public void a(FrsFragment frsFragment, com.baidu.adp.widget.ListView.m mVar) {
        this.dla = frsFragment;
        this.dpP = new i(frsFragment.getPageContext(), bc.aib, this.dla.getUniqueId());
        this.dpP.setVoiceManager(frsFragment.getVoiceManager());
        this.dpP.setInFrsAllThread(true);
        this.dqG = new g(frsFragment.getPageContext(), bc.aic, this.dla.getUniqueId());
        this.dqG.setInFrsAllThread(true);
        this.dpR = new l(frsFragment.getPageContext(), bc.aii, this.dla.getUniqueId());
        this.dpR.setInFrsAllThread(true);
        this.dpQ = new i(frsFragment.getPageContext(), bc.aid, this.dla.getUniqueId());
        this.dpQ.setVoiceManager(frsFragment.getVoiceManager());
        this.dpQ.setInFrsAllThread(true);
        this.dpS = new p(frsFragment.getPageContext(), bc.aie, this.dla.getUniqueId());
        this.dpS.setInFrsAllThread(true);
        this.dpT = new d(frsFragment.getPageContext(), bc.aij, this.dla.getUniqueId());
        this.dpT.setInFrsAllThread(true);
        this.dqH = com.baidu.tieba.frs.c.atf().a(frsFragment.getPageContext(), s.gLR, this.dla.getUniqueId(), false);
        this.dnp = new com.baidu.tieba.frs.l(frsFragment.getPageContext(), com.baidu.tieba.frs.m.dmd);
        this.dqI = com.baidu.tieba.frs.c.atf().a(frsFragment.getPageContext(), bc.ajw, this.dla.getUniqueId(), true);
        this.dqJ = com.baidu.tieba.frs.c.atf().b(frsFragment.getPageContext(), bc.ajE, this.dla.getUniqueId());
        this.dqL = new j(frsFragment.getPageContext(), com.baidu.tieba.frs.p.dmi);
        this.dqM = new f(frsFragment.getPageContext(), bc.aip, this.dla.getUniqueId());
        this.dqN = new m(frsFragment.getPageContext(), com.baidu.tieba.frs.q.dmo, this.dla.getUniqueId());
        this.dqO = new n(frsFragment.getPageContext().getPageActivity(), com.baidu.tieba.tbadkCore.k.gLF, this.dla.getUniqueId());
        this.dqP = new e(frsFragment.getPageContext(), bc.aik, this.dla.getUniqueId());
        this.mAdapters.add(this.dqO);
        this.mAdapters.add(this.dpP);
        this.mAdapters.add(this.dqG);
        this.mAdapters.add(this.dpR);
        this.mAdapters.add(this.dpQ);
        this.mAdapters.add(this.dqN);
        com.baidu.tieba.InjectPlugin.b.b bVar = new com.baidu.tieba.InjectPlugin.b.b(this.dla, 1);
        bVar.setExtraData(this.mAdapters);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016515, bVar));
        this.mAdapters.add(this.dqM);
        if (this.dqH != null) {
            this.mAdapters.add(this.dqH);
        }
        this.mAdapters.add(this.dnp);
        this.mAdapters.add(this.dpS);
        this.mAdapters.add(this.dpT);
        this.mAdapters.add(new u(this.dla.getPageContext(), v.dmA));
        this.mAdapters.add(this.dqI);
        if (this.dqJ != null) {
            this.mAdapters.add(this.dqJ);
        }
        this.mAdapters.add(this.dqL);
        this.mAdapters.add(this.dqP);
        this.dpU.setPriority(1);
        this.dpU.setSelfListener(true);
        this.dla.registerListener(this.dpU);
        this.dla.registerListener(this.mAttentionListener);
        this.dla.registerListener(this.mLikeForumListener);
        this.dla.registerListener(this.mUnlikeForumListener);
        this.dla.registerListener(this.dqU);
        awr();
        CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2003008, new AbsDelegateAdapterList());
        CustomMessage customMessage = new CustomMessage(2003008);
        customMessage.setTag(this.dla.getUniqueId());
        customResponsedMessage.setOrginalMessage(customMessage);
        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
        bp(this.mAdapters);
        mVar.addAdapters(this.mAdapters);
        iD("page_frs");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Y(Object obj) {
        boolean z;
        boolean z2 = false;
        if (this.ami != null) {
            Iterator<com.baidu.adp.widget.ListView.h> it = this.ami.iterator();
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
    public void Z(Object obj) {
        if (this.ami != null) {
            Iterator<com.baidu.adp.widget.ListView.h> it = this.ami.iterator();
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

    private void awr() {
        if (this.dla != null && !aws()) {
            this.dla.registerListener(this.dqT);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v5, resolved type: com.baidu.tieba.frs.FrsFragment */
    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public boolean aws() {
        if (this.dla == null) {
            return false;
        }
        this.dqK = new ArrayList();
        ArrayList<BdUniqueId> bwO = com.baidu.tieba.tbadkCore.q.bwO();
        if (bwO == null || bwO.size() <= 0) {
            return false;
        }
        int size = bwO.size();
        for (int i = 0; i < size; i++) {
            com.baidu.tieba.frs.h<ICardInfo, ? extends q.a> a = com.baidu.tieba.frs.c.atf().a(this.dla.getPageContext(), bwO.get(i), this.dla.getUniqueId());
            if (a != null) {
                this.mAdapters.add(a);
                this.dqK.add(a);
            }
        }
        if (!w.A(this.dqK)) {
            this.dqF.addAdapters(this.dqK);
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
        com.baidu.tieba.tbadkCore.q.p(arrayList, 1);
        R(arrayList);
        S(arrayList);
        Q(arrayList);
        this.dqF.setData(arrayList);
        this.dqR = lVar;
        awA();
        awt();
        this.ami = arrayList;
    }

    private void c(com.baidu.tieba.tbadkCore.l lVar) {
        if (lVar != null && lVar.baT() != null && "worldcup".equals(lVar.baT().getSpecialForumType())) {
            com.baidu.tieba.frs.worldcup.c.a(lVar.baT().getId(), 2, this.dpP, this.dpS, this.dqP, this.dpQ, this.dpT);
        }
    }

    private void awt() {
        if (this.dqR != null && this.dqR.baT() != null && !StringUtils.isNull(this.dqR.baT().getId()) && this.dqO != null) {
            this.dqO.setForumId(this.dqR.baT().getId());
        }
    }

    private void Q(ArrayList<com.baidu.adp.widget.ListView.h> arrayList) {
        int z = w.z(arrayList);
        for (int i = 0; i < z; i++) {
            com.baidu.adp.widget.ListView.h hVar = (com.baidu.adp.widget.ListView.h) w.d(arrayList, i - 1);
            com.baidu.adp.widget.ListView.h hVar2 = (com.baidu.adp.widget.ListView.h) w.d(arrayList, i);
            if (hVar2 instanceof bc) {
                bc bcVar = (bc) hVar2;
                if (i == 0) {
                    bcVar.isFirstFloor = true;
                } else {
                    bcVar.isFirstFloor = false;
                }
                String vT = bcVar.vT();
                if (hVar instanceof com.baidu.tieba.frs.p) {
                    bcVar.needTopMargin = false;
                } else if (hVar != null && !d(hVar)) {
                    bcVar.needTopMargin = false;
                } else if ((hVar instanceof bc) && d(hVar) && !TextUtils.isEmpty(((bc) hVar).vT())) {
                    bcVar.needTopMargin = true;
                } else if (d(hVar2) && !TextUtils.isEmpty(vT)) {
                    bcVar.needTopMargin = true;
                } else {
                    bcVar.needTopMargin = false;
                }
            }
        }
    }

    private boolean d(com.baidu.adp.widget.ListView.h hVar) {
        if (hVar == null) {
            return false;
        }
        BdUniqueId type = hVar.getType();
        return type == bc.aib || type == bc.aid || type == bc.aie || type == bc.aij || type == bc.aip;
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
                if (this.dqQ != null && !this.dqQ.containsValue(hVar)) {
                    this.dqQ.put(Integer.valueOf(i2), (bc) hVar);
                }
            }
            i = i2 + 1;
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.a.q
    public void fX(boolean z) {
        if (this.dqS != z) {
            this.dqS = z;
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.a.q
    public HashMap<Integer, bc> awu() {
        return this.dqQ;
    }

    @Override // com.baidu.tieba.frs.entelechy.a.q
    public void awv() {
        List<com.baidu.adp.widget.ListView.h> data;
        if (this.dqF != null && this.dqF.getData() != null && this.dqF.getData().size() != 0 && (data = this.dqF.getData()) != null && data.size() != 0) {
            for (com.baidu.adp.widget.ListView.h hVar : data) {
                if ((hVar instanceof bc) && ((bc) hVar).vr() != 0) {
                    ((bc) hVar).wd();
                }
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.a.q
    public void notifyDataSetChanged() {
        if (this.dqF.getListAdapter() != null) {
            this.dqF.getListAdapter().notifyDataSetChanged();
        }
    }

    public void ajF() {
        if (this.ami != null) {
            this.dqF.setData(this.ami);
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
            if (this.dpP != null) {
                this.dpP.setFromCDN(z);
            }
            if (this.dpQ != null) {
                this.dpQ.setFromCDN(z);
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
    public int aww() {
        if (this.dqH != null) {
            return d.g.frs_fortune_bag_item;
        }
        return 0;
    }

    @Override // com.baidu.tieba.frs.entelechy.a.q
    public int awx() {
        if (this.dqH != null) {
            return d.g.frs_my_service_item;
        }
        return 0;
    }

    @Override // com.baidu.tieba.frs.entelechy.a.q
    public int awy() {
        if (this.dqH != null) {
            return d.g.frs_bawu_center;
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
    public void awz() {
        if (this.mAdapters != null && this.mAdapters.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.mAdapters) {
                if (aVar instanceof com.baidu.tieba.frs.h) {
                    ((com.baidu.tieba.frs.h) aVar).a(this.dla.getPageContext(), this.dla.getUniqueId());
                }
            }
            bp(this.mAdapters);
        }
    }

    private void awA() {
        if (this.dqR != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.mAdapters) {
                if (aVar instanceof com.baidu.tieba.frs.e.c) {
                    com.baidu.tieba.frs.e.c cVar = (com.baidu.tieba.frs.e.c) aVar;
                    if (cVar.awC() != null) {
                        if (this.dqR.gKm == 1) {
                            cVar.awC().dBR = true;
                        } else {
                            cVar.awC().dBR = false;
                        }
                        if (this.dqR.baT() != null) {
                            cVar.awC().dBT = this.dqR.baT().getId();
                        }
                        if (this.dla != null && this.dla.atD() != null) {
                            cVar.awC().dBS = this.dla.atD().azf();
                        }
                    }
                }
            }
            awB();
        }
    }

    private void awB() {
        com.baidu.tieba.frs.e.a aVar = new com.baidu.tieba.frs.e.a();
        if (this.dqR.gKm == 1) {
            aVar.dBR = true;
        } else {
            aVar.dBR = false;
        }
        if (this.dqR.baT() != null) {
            aVar.dBT = this.dqR.baT().getId();
        }
        if (this.dla != null && this.dla.atD() != null) {
            aVar.dBS = this.dla.atD().azf();
        }
        if (com.baidu.tieba.frs.e.c.drl != null) {
            aVar.dBU = com.baidu.tieba.frs.e.c.drl.dBU;
            aVar.dBV = com.baidu.tieba.frs.e.c.drl.dBV;
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
        if (this.dqF != null) {
            return this.dqF.getData();
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
                    if (!it.hasNext() || it.next().getType().getId() != bc.aia.getId()) {
                        break;
                    }
                    i2 = i + 1;
                }
            }
            for (com.baidu.adp.widget.ListView.a aVar : this.mAdapters) {
                if (aVar instanceof com.baidu.tieba.frs.h) {
                    ((com.baidu.tieba.frs.h) aVar).ke(i);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bp(List<com.baidu.adp.widget.ListView.a> list) {
        if (list != null) {
            for (com.baidu.adp.widget.ListView.a aVar : list) {
                if (aVar instanceof com.baidu.tieba.frs.h) {
                    ((com.baidu.tieba.frs.h) aVar).a(this.djg);
                }
            }
        }
    }

    private void iD(String str) {
        if (this.mAdapters != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.mAdapters) {
                if (aVar instanceof com.baidu.tieba.a.f) {
                    ((com.baidu.tieba.a.f) aVar).iD(str);
                }
            }
        }
    }
}
