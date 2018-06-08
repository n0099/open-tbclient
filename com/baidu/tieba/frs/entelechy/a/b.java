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
import com.baidu.tbadk.core.data.bd;
import com.baidu.tbadk.core.util.w;
import com.baidu.tbadk.coreExtra.message.UpdateAttentionMessage;
import com.baidu.tieba.card.aa;
import com.baidu.tieba.d;
import com.baidu.tieba.frs.AbsDelegateAdapterList;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.frs.t;
import com.baidu.tieba.lego.card.model.ICardInfo;
import com.baidu.tieba.tbadkCore.s;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes2.dex */
public class b implements q {
    private ArrayList<com.baidu.adp.widget.ListView.h> alI;
    private FrsFragment diZ;
    private i dmC;
    private i dmD;
    private l dmE;
    private p dmF;
    private d dmG;
    private com.baidu.tieba.frs.j dmH;
    private com.baidu.adp.widget.ListView.a dnA;
    private List<com.baidu.adp.widget.ListView.a> dnB;
    private j dnC;
    private f dnD;
    private m dnE;
    private n dnF;
    private e dnG;
    private final HashMap<Integer, bd> dnH;
    private com.baidu.tieba.tbadkCore.l dnI;
    private com.baidu.adp.widget.ListView.m dnw;
    private g dnx;
    private com.baidu.adp.widget.ListView.a dny;
    private com.baidu.adp.widget.ListView.a dnz;
    private List<com.baidu.adp.widget.ListView.a> mAdapters = new LinkedList();
    private boolean dnJ = false;
    private CustomMessageListener dmI = new CustomMessageListener(2003008) { // from class: com.baidu.tieba.frs.entelechy.a.b.1
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
                    if (aVar instanceof com.baidu.tieba.frs.f) {
                        ((com.baidu.tieba.frs.f) aVar).a(b.this.diZ.getPageContext(), b.this.diZ.getUniqueId());
                    }
                }
                ArrayList arrayList = new ArrayList();
                arrayList.addAll(absDelegateAdapterList);
                b.this.bm(arrayList);
                if (b.this.mAdapters != null) {
                    b.this.mAdapters.addAll(absDelegateAdapterList);
                }
                if (b.this.dnw != null) {
                    b.this.mAdapters.addAll(arrayList);
                    b.this.dnw.addAdapters(arrayList);
                }
            }
        }
    };
    private CustomMessageListener dnK = new CustomMessageListener(2016470) { // from class: com.baidu.tieba.frs.entelechy.a.b.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && w.z(b.this.dnB)) {
                b.this.avO();
                b.this.b(b.this.alI, b.this.dnI);
            }
        }
    };
    private CustomMessageListener mAttentionListener = new CustomMessageListener(2001115) { // from class: com.baidu.tieba.frs.entelechy.a.b.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
            if (updateAttentionMessage != null && updateAttentionMessage.getData() != null && updateAttentionMessage.getData().Gp) {
                b.this.W(updateAttentionMessage.getData());
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
                bVar.eMd = true;
                b.this.W(bVar);
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
                bVar.eMd = false;
                b.this.W(bVar);
            }
        }
    };
    private CustomMessageListener dnL = new CustomMessageListener(2016492) { // from class: com.baidu.tieba.frs.entelechy.a.b.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.data.g)) {
                b.this.X((com.baidu.tbadk.data.g) customResponsedMessage.getData());
            }
        }
    };
    private final com.baidu.tieba.frs.d dhj = new com.baidu.tieba.frs.d();

    public b(FrsFragment frsFragment, com.baidu.adp.widget.ListView.m mVar, boolean z) {
        this.dnw = mVar;
        a(frsFragment, mVar);
        this.dnH = new HashMap<>();
        fP(z);
    }

    public void a(FrsFragment frsFragment, com.baidu.adp.widget.ListView.m mVar) {
        this.diZ = frsFragment;
        this.dmC = new i(frsFragment.getPageContext(), bd.ahJ, this.diZ.getUniqueId());
        this.dmC.setVoiceManager(frsFragment.getVoiceManager());
        this.dnx = new g(frsFragment.getPageContext(), bd.ahK, this.diZ.getUniqueId());
        this.dmE = new l(frsFragment.getPageContext(), bd.ahQ, this.diZ.getUniqueId());
        this.dmD = new i(frsFragment.getPageContext(), bd.ahL, this.diZ.getUniqueId());
        this.dmD.setVoiceManager(frsFragment.getVoiceManager());
        this.dmF = new p(frsFragment.getPageContext(), bd.ahM, this.diZ.getUniqueId());
        this.dmG = new d(frsFragment.getPageContext(), bd.ahR, this.diZ.getUniqueId());
        this.dny = com.baidu.tieba.frs.a.asO().a(frsFragment.getPageContext(), s.gHR, this.diZ.getUniqueId(), false);
        this.dmH = new com.baidu.tieba.frs.j(frsFragment.getPageContext(), com.baidu.tieba.frs.k.djW);
        this.dnz = com.baidu.tieba.frs.a.asO().a(frsFragment.getPageContext(), bd.ajb, this.diZ.getUniqueId(), true);
        this.dnA = com.baidu.tieba.frs.a.asO().b(frsFragment.getPageContext(), bd.ajj, this.diZ.getUniqueId());
        this.dnC = new j(frsFragment.getPageContext(), com.baidu.tieba.frs.n.dkb);
        this.dnD = new f(frsFragment.getPageContext(), bd.ahW, this.diZ.getUniqueId());
        this.dnE = new m(frsFragment.getPageContext(), com.baidu.tieba.frs.o.dkh, this.diZ.getUniqueId());
        this.dnF = new n(frsFragment.getPageContext().getPageActivity(), com.baidu.tieba.tbadkCore.k.gHG, this.diZ.getUniqueId());
        this.dnG = new e(frsFragment.getPageContext(), bd.ahS, this.diZ.getUniqueId());
        this.mAdapters.add(this.dnF);
        this.mAdapters.add(this.dmC);
        this.mAdapters.add(this.dnx);
        this.mAdapters.add(this.dmE);
        this.mAdapters.add(this.dmD);
        this.mAdapters.add(this.dnE);
        com.baidu.tieba.InjectPlugin.b.b bVar = new com.baidu.tieba.InjectPlugin.b.b(this.diZ, 1);
        bVar.setExtraData(this.mAdapters);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016515, bVar));
        this.mAdapters.add(this.dnD);
        if (this.dny != null) {
            this.mAdapters.add(this.dny);
        }
        this.mAdapters.add(this.dmH);
        this.mAdapters.add(this.dmF);
        this.mAdapters.add(this.dmG);
        this.mAdapters.add(new com.baidu.tieba.frs.s(this.diZ.getPageContext(), t.dkt));
        this.mAdapters.add(this.dnz);
        if (this.dnA != null) {
            this.mAdapters.add(this.dnA);
        }
        this.mAdapters.add(this.dnC);
        this.mAdapters.add(this.dnG);
        this.dmI.setPriority(1);
        this.dmI.setSelfListener(true);
        this.diZ.registerListener(this.dmI);
        this.diZ.registerListener(this.mAttentionListener);
        this.diZ.registerListener(this.mLikeForumListener);
        this.diZ.registerListener(this.mUnlikeForumListener);
        this.diZ.registerListener(this.dnL);
        avN();
        CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2003008, new AbsDelegateAdapterList());
        CustomMessage customMessage = new CustomMessage(2003008);
        customMessage.setTag(this.diZ.getUniqueId());
        customResponsedMessage.setOrginalMessage(customMessage);
        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
        bm(this.mAdapters);
        mVar.addAdapters(this.mAdapters);
        iy("page_frs");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void W(Object obj) {
        boolean z;
        boolean z2 = false;
        if (this.alI != null) {
            Iterator<com.baidu.adp.widget.ListView.h> it = this.alI.iterator();
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
    public void X(Object obj) {
        if (this.alI != null) {
            Iterator<com.baidu.adp.widget.ListView.h> it = this.alI.iterator();
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

    private void avN() {
        if (this.diZ != null && !avO()) {
            this.diZ.registerListener(this.dnK);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v5, resolved type: com.baidu.tieba.frs.FrsFragment */
    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public boolean avO() {
        if (this.diZ == null) {
            return false;
        }
        this.dnB = new ArrayList();
        ArrayList<BdUniqueId> bwn = com.baidu.tieba.tbadkCore.q.bwn();
        if (bwn == null || bwn.size() <= 0) {
            return false;
        }
        int size = bwn.size();
        for (int i = 0; i < size; i++) {
            com.baidu.tieba.frs.f<ICardInfo, ? extends q.a> a = com.baidu.tieba.frs.a.asO().a(this.diZ.getPageContext(), bwn.get(i), this.diZ.getUniqueId());
            if (a != null) {
                this.mAdapters.add(a);
                this.dnB.add(a);
            }
        }
        if (!w.z(this.dnB)) {
            this.dnw.addAdapters(this.dnB);
        }
        return true;
    }

    @Override // com.baidu.tieba.frs.entelechy.a.q
    public void onDestory() {
        for (com.baidu.adp.widget.ListView.a aVar : this.mAdapters) {
            if (aVar instanceof com.baidu.tieba.frs.f) {
                ((com.baidu.tieba.frs.f) aVar).release();
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.a.q
    public void b(ArrayList<com.baidu.adp.widget.ListView.h> arrayList, com.baidu.tieba.tbadkCore.l lVar) {
        b(lVar);
        c(lVar);
        com.baidu.tieba.tbadkCore.q.o(arrayList, 1);
        L(arrayList);
        M(arrayList);
        K(arrayList);
        this.dnw.setData(arrayList);
        this.dnI = lVar;
        avW();
        avP();
        this.alI = arrayList;
    }

    private void c(com.baidu.tieba.tbadkCore.l lVar) {
        if (lVar != null && lVar.bam() != null && "worldcup".equals(lVar.bam().getSpecialForumType())) {
            com.baidu.tieba.frs.worldcup.c.a(lVar.bam().getId(), 2, this.dmC, this.dmF, this.dnG, this.dmD, this.dmG);
        }
    }

    private void avP() {
        if (this.dnI != null && this.dnI.bam() != null && !StringUtils.isNull(this.dnI.bam().getId()) && this.dnF != null) {
            this.dnF.setForumId(this.dnI.bam().getId());
        }
    }

    private void K(ArrayList<com.baidu.adp.widget.ListView.h> arrayList) {
        int y = w.y(arrayList);
        for (int i = 0; i < y; i++) {
            com.baidu.adp.widget.ListView.h hVar = (com.baidu.adp.widget.ListView.h) w.c(arrayList, i - 1);
            com.baidu.adp.widget.ListView.h hVar2 = (com.baidu.adp.widget.ListView.h) w.c(arrayList, i);
            if (hVar2 instanceof bd) {
                bd bdVar = (bd) hVar2;
                if (i == 0) {
                    bdVar.isFirstFloor = true;
                } else {
                    bdVar.isFirstFloor = false;
                }
                String vJ = bdVar.vJ();
                if (hVar instanceof com.baidu.tieba.frs.n) {
                    bdVar.needTopMargin = false;
                } else if (hVar != null && !d(hVar)) {
                    bdVar.needTopMargin = false;
                } else if ((hVar instanceof bd) && d(hVar) && !TextUtils.isEmpty(((bd) hVar).vJ())) {
                    bdVar.needTopMargin = true;
                } else if (d(hVar2) && !TextUtils.isEmpty(vJ)) {
                    bdVar.needTopMargin = true;
                } else {
                    bdVar.needTopMargin = false;
                }
            }
        }
    }

    private boolean d(com.baidu.adp.widget.ListView.h hVar) {
        if (hVar == null) {
            return false;
        }
        BdUniqueId type = hVar.getType();
        return type == bd.ahJ || type == bd.ahL || type == bd.ahM || type == bd.ahR || type == bd.ahW;
    }

    private ArrayList<Integer> L(ArrayList<com.baidu.adp.widget.ListView.h> arrayList) {
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
                if (this.dnH != null && !this.dnH.containsValue(hVar)) {
                    this.dnH.put(Integer.valueOf(i2), (bd) hVar);
                }
            }
            i = i2 + 1;
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.a.q
    public void fP(boolean z) {
        if (this.dnJ != z) {
            this.dnJ = z;
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.a.q
    public HashMap<Integer, bd> avQ() {
        return this.dnH;
    }

    @Override // com.baidu.tieba.frs.entelechy.a.q
    public void avR() {
        List<com.baidu.adp.widget.ListView.h> data;
        if (this.dnw != null && this.dnw.getData() != null && this.dnw.getData().size() != 0 && (data = this.dnw.getData()) != null && data.size() != 0) {
            for (com.baidu.adp.widget.ListView.h hVar : data) {
                if ((hVar instanceof bd) && ((bd) hVar).vh() != 0) {
                    ((bd) hVar).vT();
                }
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.a.q
    public void notifyDataSetChanged() {
        if (this.dnw.getListAdapter() != null) {
            this.dnw.getListAdapter().notifyDataSetChanged();
        }
    }

    public void akl() {
        if (this.alI != null) {
            this.dnw.setData(this.alI);
        }
        notifyDataSetChanged();
    }

    @Override // com.baidu.tieba.frs.entelechy.a.q
    public void setFromCDN(boolean z) {
        if (this.mAdapters != null && this.mAdapters.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.mAdapters) {
                if (aVar instanceof com.baidu.tieba.frs.f) {
                    ((com.baidu.tieba.frs.f) aVar).setFromCDN(z);
                }
            }
            if (this.dmC != null) {
                this.dmC.setFromCDN(z);
            }
            if (this.dmD != null) {
                this.dmD.setFromCDN(z);
            }
        }
    }

    public void b(com.baidu.tieba.tbadkCore.l lVar) {
        if (this.mAdapters != null && this.mAdapters.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.mAdapters) {
                if (aVar instanceof com.baidu.tieba.frs.f) {
                    ((com.baidu.tieba.frs.f) aVar).b(lVar);
                }
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.a.q
    public void a(com.baidu.tieba.frs.b bVar) {
        if (this.mAdapters != null && this.mAdapters.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.mAdapters) {
                if (aVar instanceof com.baidu.tieba.frs.f) {
                    ((com.baidu.tieba.frs.f) aVar).a(bVar);
                }
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.a.q
    public int avS() {
        if (this.dny != null) {
            return d.g.frs_fortune_bag_item;
        }
        return 0;
    }

    @Override // com.baidu.tieba.frs.entelechy.a.q
    public int avT() {
        if (this.dny != null) {
            return d.g.frs_my_service_item;
        }
        return 0;
    }

    @Override // com.baidu.tieba.frs.entelechy.a.q
    public int avU() {
        if (this.dny != null) {
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
                if (aVar instanceof com.baidu.tieba.frs.f) {
                    ((com.baidu.tieba.frs.f) aVar).setOnAdapterItemClickListener(nVar);
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
                if (aVar instanceof aa) {
                    ((aa) aVar).setForumName(str);
                }
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v1, resolved type: com.baidu.tieba.frs.FrsFragment */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.baidu.tieba.frs.entelechy.a.q
    public void avV() {
        if (this.mAdapters != null && this.mAdapters.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.mAdapters) {
                if (aVar instanceof com.baidu.tieba.frs.f) {
                    ((com.baidu.tieba.frs.f) aVar).a(this.diZ.getPageContext(), this.diZ.getUniqueId());
                }
            }
            bm(this.mAdapters);
        }
    }

    private void avW() {
        if (this.dnI != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.mAdapters) {
                if (aVar instanceof com.baidu.tieba.frs.e.c) {
                    com.baidu.tieba.frs.e.c cVar = (com.baidu.tieba.frs.e.c) aVar;
                    if (com.baidu.tieba.frs.e.c.dyP != null) {
                        if (this.dnI.gGr == 1) {
                            com.baidu.tieba.frs.e.c.dyP.dyD = true;
                        } else {
                            com.baidu.tieba.frs.e.c.dyP.dyD = false;
                        }
                        if (this.dnI.bam() != null) {
                            com.baidu.tieba.frs.e.c.dyP.dyF = this.dnI.bam().getId();
                        }
                        if (this.diZ != null && this.diZ.atm() != null) {
                            com.baidu.tieba.frs.e.c.dyP.dyE = this.diZ.atm().ayz();
                        }
                    }
                }
            }
            avX();
        }
    }

    private void avX() {
        com.baidu.tieba.frs.e.a aVar = new com.baidu.tieba.frs.e.a();
        if (this.dnI.gGr == 1) {
            aVar.dyD = true;
        } else {
            aVar.dyD = false;
        }
        if (this.dnI.bam() != null) {
            aVar.dyF = this.dnI.bam().getId();
        }
        if (this.diZ != null && this.diZ.atm() != null) {
            aVar.dyE = this.diZ.atm().ayz();
        }
        if (com.baidu.tieba.frs.e.c.dyP != null) {
            aVar.dyG = com.baidu.tieba.frs.e.c.dyP.dyG;
            aVar.dyH = com.baidu.tieba.frs.e.c.dyP.dyH;
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
        if (this.dnw != null) {
            return this.dnw.getData();
        }
        return null;
    }

    private void M(ArrayList<com.baidu.adp.widget.ListView.h> arrayList) {
        int i;
        if (this.mAdapters != null && this.mAdapters.size() != 0) {
            int i2 = 0;
            if (arrayList == null || arrayList.size() <= 0) {
                i = 0;
            } else {
                Iterator<com.baidu.adp.widget.ListView.h> it = arrayList.iterator();
                while (true) {
                    i = i2;
                    if (!it.hasNext() || it.next().getType().getId() != bd.ahI.getId()) {
                        break;
                    }
                    i2 = i + 1;
                }
            }
            for (com.baidu.adp.widget.ListView.a aVar : this.mAdapters) {
                if (aVar instanceof com.baidu.tieba.frs.f) {
                    ((com.baidu.tieba.frs.f) aVar).ka(i);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bm(List<com.baidu.adp.widget.ListView.a> list) {
        if (list != null) {
            for (com.baidu.adp.widget.ListView.a aVar : list) {
                if (aVar instanceof com.baidu.tieba.frs.f) {
                    ((com.baidu.tieba.frs.f) aVar).a(this.dhj);
                }
            }
        }
    }

    private void iy(String str) {
        if (this.mAdapters != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.mAdapters) {
                if (aVar instanceof com.baidu.tieba.a.f) {
                    ((com.baidu.tieba.a.f) aVar).iy(str);
                }
            }
        }
    }
}
