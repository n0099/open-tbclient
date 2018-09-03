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
import com.baidu.tbadk.core.util.w;
import com.baidu.tbadk.coreExtra.message.UpdateAttentionMessage;
import com.baidu.tieba.card.ab;
import com.baidu.tieba.f;
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
    private ArrayList<com.baidu.adp.widget.ListView.h> alH;
    private FrsFragment dnP;
    private com.baidu.tieba.frs.l dqh;
    private i dsA;
    private l dsB;
    private p dsC;
    private d dsD;
    private i dsz;
    private final HashMap<Integer, bb> dtA;
    private com.baidu.tieba.tbadkCore.l dtB;
    private com.baidu.adp.widget.ListView.m dtp;
    private g dtq;
    private com.baidu.adp.widget.ListView.a dtr;
    private com.baidu.adp.widget.ListView.a dts;
    private com.baidu.adp.widget.ListView.a dtt;
    private List<com.baidu.adp.widget.ListView.a> dtu;
    private j dtv;
    private f dtw;
    private m dtx;
    private n dty;
    private e dtz;
    private List<com.baidu.adp.widget.ListView.a> mAdapters = new LinkedList();
    private boolean dtC = false;
    private CustomMessageListener dsE = new CustomMessageListener(2003008) { // from class: com.baidu.tieba.frs.entelechy.a.b.1
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
                        ((com.baidu.tieba.frs.h) aVar).a(b.this.dnP.getPageContext(), b.this.dnP.getUniqueId());
                    }
                }
                ArrayList arrayList = new ArrayList();
                arrayList.addAll(absDelegateAdapterList);
                b.this.bo(arrayList);
                if (b.this.mAdapters != null) {
                    b.this.mAdapters.addAll(absDelegateAdapterList);
                }
                if (b.this.dtp != null) {
                    b.this.mAdapters.addAll(arrayList);
                    b.this.dtp.addAdapters(arrayList);
                }
            }
        }
    };
    private CustomMessageListener dtD = new CustomMessageListener(2016470) { // from class: com.baidu.tieba.frs.entelechy.a.b.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && w.z(b.this.dtu)) {
                b.this.awW();
                b.this.b(b.this.alH, b.this.dtB);
            }
        }
    };
    private CustomMessageListener mAttentionListener = new CustomMessageListener(2001115) { // from class: com.baidu.tieba.frs.entelechy.a.b.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
            if (updateAttentionMessage != null && updateAttentionMessage.getData() != null && updateAttentionMessage.getData().Gp) {
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
                bVar.ahp = true;
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
                bVar.ahp = false;
                b.this.Y(bVar);
            }
        }
    };
    private CustomMessageListener dtE = new CustomMessageListener(2016492) { // from class: com.baidu.tieba.frs.entelechy.a.b.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.data.g)) {
                b.this.Z((com.baidu.tbadk.data.g) customResponsedMessage.getData());
            }
        }
    };
    private final com.baidu.tieba.frs.f dlU = new com.baidu.tieba.frs.f();

    public b(FrsFragment frsFragment, com.baidu.adp.widget.ListView.m mVar, boolean z) {
        this.dtp = mVar;
        a(frsFragment, mVar);
        this.dtA = new HashMap<>();
        fZ(z);
    }

    public void a(FrsFragment frsFragment, com.baidu.adp.widget.ListView.m mVar) {
        this.dnP = frsFragment;
        this.dsz = new i(frsFragment.getPageContext(), bb.ahx, this.dnP.getUniqueId());
        this.dsz.setVoiceManager(frsFragment.getVoiceManager());
        this.dsz.setInFrsAllThread(true);
        this.dtq = new g(frsFragment.getPageContext(), bb.ahy, this.dnP.getUniqueId());
        this.dtq.setInFrsAllThread(true);
        this.dsB = new l(frsFragment.getPageContext(), bb.ahE, this.dnP.getUniqueId());
        this.dsB.setInFrsAllThread(true);
        this.dsA = new i(frsFragment.getPageContext(), bb.ahz, this.dnP.getUniqueId());
        this.dsA.setVoiceManager(frsFragment.getVoiceManager());
        this.dsA.setInFrsAllThread(true);
        this.dsC = new p(frsFragment.getPageContext(), bb.ahA, this.dnP.getUniqueId());
        this.dsC.setInFrsAllThread(true);
        this.dsD = new d(frsFragment.getPageContext(), bb.ahF, this.dnP.getUniqueId());
        this.dsD.setInFrsAllThread(true);
        this.dtr = com.baidu.tieba.frs.c.atI().a(frsFragment.getPageContext(), s.gMR, this.dnP.getUniqueId(), false);
        this.dqh = new com.baidu.tieba.frs.l(frsFragment.getPageContext(), com.baidu.tieba.frs.m.doT);
        this.dts = com.baidu.tieba.frs.c.atI().a(frsFragment.getPageContext(), bb.aiT, this.dnP.getUniqueId(), true);
        this.dtt = com.baidu.tieba.frs.c.atI().b(frsFragment.getPageContext(), bb.ajb, this.dnP.getUniqueId());
        this.dtv = new j(frsFragment.getPageContext(), com.baidu.tieba.frs.p.doY);
        this.dtw = new f(frsFragment.getPageContext(), bb.ahL, this.dnP.getUniqueId());
        this.dtx = new m(frsFragment.getPageContext(), com.baidu.tieba.frs.q.dpe, this.dnP.getUniqueId());
        this.dty = new n(frsFragment.getPageContext().getPageActivity(), com.baidu.tieba.tbadkCore.k.gMF, this.dnP.getUniqueId());
        this.dtz = new e(frsFragment.getPageContext(), bb.ahG, this.dnP.getUniqueId());
        this.mAdapters.add(this.dty);
        this.mAdapters.add(this.dsz);
        this.mAdapters.add(this.dtq);
        this.mAdapters.add(this.dsB);
        this.mAdapters.add(this.dsA);
        this.mAdapters.add(this.dtx);
        com.baidu.tieba.InjectPlugin.b.b bVar = new com.baidu.tieba.InjectPlugin.b.b(this.dnP, 1);
        bVar.setExtraData(this.mAdapters);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016515, bVar));
        this.mAdapters.add(this.dtw);
        if (this.dtr != null) {
            this.mAdapters.add(this.dtr);
        }
        this.mAdapters.add(this.dqh);
        this.mAdapters.add(this.dsC);
        this.mAdapters.add(this.dsD);
        this.mAdapters.add(new u(this.dnP.getPageContext(), v.dpq));
        this.mAdapters.add(this.dts);
        if (this.dtt != null) {
            this.mAdapters.add(this.dtt);
        }
        this.mAdapters.add(this.dtv);
        this.mAdapters.add(this.dtz);
        this.dsE.setPriority(1);
        this.dsE.setSelfListener(true);
        this.dnP.registerListener(this.dsE);
        this.dnP.registerListener(this.mAttentionListener);
        this.dnP.registerListener(this.mLikeForumListener);
        this.dnP.registerListener(this.mUnlikeForumListener);
        this.dnP.registerListener(this.dtE);
        awV();
        CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2003008, new AbsDelegateAdapterList());
        CustomMessage customMessage = new CustomMessage(2003008);
        customMessage.setTag(this.dnP.getUniqueId());
        customResponsedMessage.setOrginalMessage(customMessage);
        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
        bo(this.mAdapters);
        mVar.addAdapters(this.mAdapters);
        iB("page_frs");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Y(Object obj) {
        boolean z;
        boolean z2 = false;
        if (this.alH != null) {
            Iterator<com.baidu.adp.widget.ListView.h> it = this.alH.iterator();
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
        if (this.alH != null) {
            Iterator<com.baidu.adp.widget.ListView.h> it = this.alH.iterator();
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

    private void awV() {
        if (this.dnP != null && !awW()) {
            this.dnP.registerListener(this.dtD);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v5, resolved type: com.baidu.tieba.frs.FrsFragment */
    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public boolean awW() {
        if (this.dnP == null) {
            return false;
        }
        this.dtu = new ArrayList();
        ArrayList<BdUniqueId> bvt = com.baidu.tieba.tbadkCore.q.bvt();
        if (bvt == null || bvt.size() <= 0) {
            return false;
        }
        int size = bvt.size();
        for (int i = 0; i < size; i++) {
            com.baidu.tieba.frs.h<ICardInfo, ? extends q.a> a = com.baidu.tieba.frs.c.atI().a(this.dnP.getPageContext(), bvt.get(i), this.dnP.getUniqueId());
            if (a != null) {
                this.mAdapters.add(a);
                this.dtu.add(a);
            }
        }
        if (!w.z(this.dtu)) {
            this.dtp.addAdapters(this.dtu);
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
        this.dtp.setData(arrayList);
        this.dtB = lVar;
        axe();
        awX();
        this.alH = arrayList;
    }

    private void c(com.baidu.tieba.tbadkCore.l lVar) {
        if (lVar != null && lVar.aZg() != null && "worldcup".equals(lVar.aZg().getSpecialForumType())) {
            com.baidu.tieba.frs.worldcup.c.a(lVar.aZg().getId(), 2, this.dsz, this.dsC, this.dtz, this.dsA, this.dsD);
        }
    }

    private void awX() {
        if (this.dtB != null && this.dtB.aZg() != null && !StringUtils.isNull(this.dtB.aZg().getId()) && this.dty != null) {
            this.dty.setForumId(this.dtB.aZg().getId());
        }
    }

    private void Q(ArrayList<com.baidu.adp.widget.ListView.h> arrayList) {
        int y = w.y(arrayList);
        for (int i = 0; i < y; i++) {
            com.baidu.adp.widget.ListView.h hVar = (com.baidu.adp.widget.ListView.h) w.d(arrayList, i - 1);
            com.baidu.adp.widget.ListView.h hVar2 = (com.baidu.adp.widget.ListView.h) w.d(arrayList, i);
            if (hVar2 instanceof bb) {
                bb bbVar = (bb) hVar2;
                if (i == 0) {
                    bbVar.isFirstFloor = true;
                } else {
                    bbVar.isFirstFloor = false;
                }
                String vH = bbVar.vH();
                if (hVar instanceof com.baidu.tieba.frs.p) {
                    bbVar.needTopMargin = false;
                } else if (hVar != null && !d(hVar)) {
                    bbVar.needTopMargin = false;
                } else if ((hVar instanceof bb) && d(hVar) && !TextUtils.isEmpty(((bb) hVar).vH())) {
                    bbVar.needTopMargin = true;
                } else if (d(hVar2) && !TextUtils.isEmpty(vH)) {
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
        return type == bb.ahx || type == bb.ahz || type == bb.ahA || type == bb.ahF || type == bb.ahL;
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
                if (this.dtA != null && !this.dtA.containsValue(hVar)) {
                    this.dtA.put(Integer.valueOf(i2), (bb) hVar);
                }
            }
            i = i2 + 1;
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.a.q
    public void fZ(boolean z) {
        if (this.dtC != z) {
            this.dtC = z;
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.a.q
    public HashMap<Integer, bb> awY() {
        return this.dtA;
    }

    @Override // com.baidu.tieba.frs.entelechy.a.q
    public void awZ() {
        List<com.baidu.adp.widget.ListView.h> data;
        if (this.dtp != null && this.dtp.getData() != null && this.dtp.getData().size() != 0 && (data = this.dtp.getData()) != null && data.size() != 0) {
            for (com.baidu.adp.widget.ListView.h hVar : data) {
                if ((hVar instanceof bb) && ((bb) hVar).ve() != 0) {
                    ((bb) hVar).vR();
                }
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.a.q
    public void notifyDataSetChanged() {
        if (this.dtp.getListAdapter() != null) {
            this.dtp.getListAdapter().notifyDataSetChanged();
        }
    }

    public void akf() {
        if (this.alH != null) {
            this.dtp.setData(this.alH);
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
            if (this.dsz != null) {
                this.dsz.setFromCDN(z);
            }
            if (this.dsA != null) {
                this.dsA.setFromCDN(z);
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
    public int axa() {
        if (this.dtr != null) {
            return f.g.frs_fortune_bag_item;
        }
        return 0;
    }

    @Override // com.baidu.tieba.frs.entelechy.a.q
    public int axb() {
        if (this.dtr != null) {
            return f.g.frs_my_service_item;
        }
        return 0;
    }

    @Override // com.baidu.tieba.frs.entelechy.a.q
    public int axc() {
        if (this.dtr != null) {
            return f.g.frs_bawu_center;
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
    public void axd() {
        if (this.mAdapters != null && this.mAdapters.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.mAdapters) {
                if (aVar instanceof com.baidu.tieba.frs.h) {
                    ((com.baidu.tieba.frs.h) aVar).a(this.dnP.getPageContext(), this.dnP.getUniqueId());
                }
            }
            bo(this.mAdapters);
        }
    }

    private void axe() {
        if (this.dtB != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.mAdapters) {
                if (aVar instanceof com.baidu.tieba.frs.e.c) {
                    com.baidu.tieba.frs.e.c cVar = (com.baidu.tieba.frs.e.c) aVar;
                    if (cVar.axg() != null) {
                        if (this.dtB.gLl == 1) {
                            cVar.axg().dEA = true;
                        } else {
                            cVar.axg().dEA = false;
                        }
                        if (this.dtB.aZg() != null) {
                            cVar.axg().dEC = this.dtB.aZg().getId();
                        }
                        if (this.dnP != null && this.dnP.aug() != null) {
                            cVar.axg().dEB = this.dnP.aug().azI();
                        }
                    }
                }
            }
            axf();
        }
    }

    private void axf() {
        com.baidu.tieba.frs.e.a aVar = new com.baidu.tieba.frs.e.a();
        if (this.dtB.gLl == 1) {
            aVar.dEA = true;
        } else {
            aVar.dEA = false;
        }
        if (this.dtB.aZg() != null) {
            aVar.dEC = this.dtB.aZg().getId();
        }
        if (this.dnP != null && this.dnP.aug() != null) {
            aVar.dEB = this.dnP.aug().azI();
        }
        if (com.baidu.tieba.frs.e.c.dtV != null) {
            aVar.dED = com.baidu.tieba.frs.e.c.dtV.dED;
            aVar.dEE = com.baidu.tieba.frs.e.c.dtV.dEE;
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
        if (this.dtp != null) {
            return this.dtp.getData();
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
                    if (!it.hasNext() || it.next().getType().getId() != bb.ahw.getId()) {
                        break;
                    }
                    i2 = i + 1;
                }
            }
            for (com.baidu.adp.widget.ListView.a aVar : this.mAdapters) {
                if (aVar instanceof com.baidu.tieba.frs.h) {
                    ((com.baidu.tieba.frs.h) aVar).ko(i);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bo(List<com.baidu.adp.widget.ListView.a> list) {
        if (list != null) {
            for (com.baidu.adp.widget.ListView.a aVar : list) {
                if (aVar instanceof com.baidu.tieba.frs.h) {
                    ((com.baidu.tieba.frs.h) aVar).a(this.dlU);
                }
            }
        }
    }

    private void iB(String str) {
        if (this.mAdapters != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.mAdapters) {
                if (aVar instanceof com.baidu.tieba.a.f) {
                    ((com.baidu.tieba.a.f) aVar).iB(str);
                }
            }
        }
    }
}
