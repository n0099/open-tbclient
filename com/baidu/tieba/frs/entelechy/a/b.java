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
    private ArrayList<com.baidu.adp.widget.ListView.h> alI;
    private FrsFragment dnR;
    private com.baidu.tieba.frs.l dqj;
    private i dsC;
    private i dsD;
    private l dsE;
    private p dsF;
    private d dsG;
    private m dtA;
    private n dtB;
    private e dtC;
    private final HashMap<Integer, bb> dtD;
    private com.baidu.tieba.tbadkCore.l dtE;
    private com.baidu.adp.widget.ListView.m dts;
    private g dtt;
    private com.baidu.adp.widget.ListView.a dtu;
    private com.baidu.adp.widget.ListView.a dtv;
    private com.baidu.adp.widget.ListView.a dtw;
    private List<com.baidu.adp.widget.ListView.a> dtx;
    private j dty;
    private f dtz;
    private List<com.baidu.adp.widget.ListView.a> mAdapters = new LinkedList();
    private boolean dtF = false;
    private CustomMessageListener dsH = new CustomMessageListener(2003008) { // from class: com.baidu.tieba.frs.entelechy.a.b.1
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
                        ((com.baidu.tieba.frs.h) aVar).a(b.this.dnR.getPageContext(), b.this.dnR.getUniqueId());
                    }
                }
                ArrayList arrayList = new ArrayList();
                arrayList.addAll(absDelegateAdapterList);
                b.this.bo(arrayList);
                if (b.this.mAdapters != null) {
                    b.this.mAdapters.addAll(absDelegateAdapterList);
                }
                if (b.this.dts != null) {
                    b.this.mAdapters.addAll(arrayList);
                    b.this.dts.addAdapters(arrayList);
                }
            }
        }
    };
    private CustomMessageListener dtG = new CustomMessageListener(2016470) { // from class: com.baidu.tieba.frs.entelechy.a.b.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && w.z(b.this.dtx)) {
                b.this.awX();
                b.this.b(b.this.alI, b.this.dtE);
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
    private CustomMessageListener dtH = new CustomMessageListener(2016492) { // from class: com.baidu.tieba.frs.entelechy.a.b.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.data.g)) {
                b.this.Z((com.baidu.tbadk.data.g) customResponsedMessage.getData());
            }
        }
    };
    private final com.baidu.tieba.frs.f dlW = new com.baidu.tieba.frs.f();

    public b(FrsFragment frsFragment, com.baidu.adp.widget.ListView.m mVar, boolean z) {
        this.dts = mVar;
        a(frsFragment, mVar);
        this.dtD = new HashMap<>();
        fZ(z);
    }

    public void a(FrsFragment frsFragment, com.baidu.adp.widget.ListView.m mVar) {
        this.dnR = frsFragment;
        this.dsC = new i(frsFragment.getPageContext(), bb.ahx, this.dnR.getUniqueId());
        this.dsC.setVoiceManager(frsFragment.getVoiceManager());
        this.dsC.setInFrsAllThread(true);
        this.dtt = new g(frsFragment.getPageContext(), bb.ahy, this.dnR.getUniqueId());
        this.dtt.setInFrsAllThread(true);
        this.dsE = new l(frsFragment.getPageContext(), bb.ahE, this.dnR.getUniqueId());
        this.dsE.setInFrsAllThread(true);
        this.dsD = new i(frsFragment.getPageContext(), bb.ahz, this.dnR.getUniqueId());
        this.dsD.setVoiceManager(frsFragment.getVoiceManager());
        this.dsD.setInFrsAllThread(true);
        this.dsF = new p(frsFragment.getPageContext(), bb.ahA, this.dnR.getUniqueId());
        this.dsF.setInFrsAllThread(true);
        this.dsG = new d(frsFragment.getPageContext(), bb.ahF, this.dnR.getUniqueId());
        this.dsG.setInFrsAllThread(true);
        this.dtu = com.baidu.tieba.frs.c.atJ().a(frsFragment.getPageContext(), s.gMP, this.dnR.getUniqueId(), false);
        this.dqj = new com.baidu.tieba.frs.l(frsFragment.getPageContext(), com.baidu.tieba.frs.m.doV);
        this.dtv = com.baidu.tieba.frs.c.atJ().a(frsFragment.getPageContext(), bb.aiT, this.dnR.getUniqueId(), true);
        this.dtw = com.baidu.tieba.frs.c.atJ().b(frsFragment.getPageContext(), bb.ajb, this.dnR.getUniqueId());
        this.dty = new j(frsFragment.getPageContext(), com.baidu.tieba.frs.p.dpa);
        this.dtz = new f(frsFragment.getPageContext(), bb.ahL, this.dnR.getUniqueId());
        this.dtA = new m(frsFragment.getPageContext(), com.baidu.tieba.frs.q.dpg, this.dnR.getUniqueId());
        this.dtB = new n(frsFragment.getPageContext().getPageActivity(), com.baidu.tieba.tbadkCore.k.gMD, this.dnR.getUniqueId());
        this.dtC = new e(frsFragment.getPageContext(), bb.ahG, this.dnR.getUniqueId());
        this.mAdapters.add(this.dtB);
        this.mAdapters.add(this.dsC);
        this.mAdapters.add(this.dtt);
        this.mAdapters.add(this.dsE);
        this.mAdapters.add(this.dsD);
        this.mAdapters.add(this.dtA);
        com.baidu.tieba.InjectPlugin.b.b bVar = new com.baidu.tieba.InjectPlugin.b.b(this.dnR, 1);
        bVar.setExtraData(this.mAdapters);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016515, bVar));
        this.mAdapters.add(this.dtz);
        if (this.dtu != null) {
            this.mAdapters.add(this.dtu);
        }
        this.mAdapters.add(this.dqj);
        this.mAdapters.add(this.dsF);
        this.mAdapters.add(this.dsG);
        this.mAdapters.add(new u(this.dnR.getPageContext(), v.dps));
        this.mAdapters.add(this.dtv);
        if (this.dtw != null) {
            this.mAdapters.add(this.dtw);
        }
        this.mAdapters.add(this.dty);
        this.mAdapters.add(this.dtC);
        this.dsH.setPriority(1);
        this.dsH.setSelfListener(true);
        this.dnR.registerListener(this.dsH);
        this.dnR.registerListener(this.mAttentionListener);
        this.dnR.registerListener(this.mLikeForumListener);
        this.dnR.registerListener(this.mUnlikeForumListener);
        this.dnR.registerListener(this.dtH);
        awW();
        CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2003008, new AbsDelegateAdapterList());
        CustomMessage customMessage = new CustomMessage(2003008);
        customMessage.setTag(this.dnR.getUniqueId());
        customResponsedMessage.setOrginalMessage(customMessage);
        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
        bo(this.mAdapters);
        mVar.addAdapters(this.mAdapters);
        iA("page_frs");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Y(Object obj) {
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
    public void Z(Object obj) {
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

    private void awW() {
        if (this.dnR != null && !awX()) {
            this.dnR.registerListener(this.dtG);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v5, resolved type: com.baidu.tieba.frs.FrsFragment */
    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public boolean awX() {
        if (this.dnR == null) {
            return false;
        }
        this.dtx = new ArrayList();
        ArrayList<BdUniqueId> bvs = com.baidu.tieba.tbadkCore.q.bvs();
        if (bvs == null || bvs.size() <= 0) {
            return false;
        }
        int size = bvs.size();
        for (int i = 0; i < size; i++) {
            com.baidu.tieba.frs.h<ICardInfo, ? extends q.a> a = com.baidu.tieba.frs.c.atJ().a(this.dnR.getPageContext(), bvs.get(i), this.dnR.getUniqueId());
            if (a != null) {
                this.mAdapters.add(a);
                this.dtx.add(a);
            }
        }
        if (!w.z(this.dtx)) {
            this.dts.addAdapters(this.dtx);
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
        this.dts.setData(arrayList);
        this.dtE = lVar;
        axf();
        awY();
        this.alI = arrayList;
    }

    private void c(com.baidu.tieba.tbadkCore.l lVar) {
        if (lVar != null && lVar.aZl() != null && "worldcup".equals(lVar.aZl().getSpecialForumType())) {
            com.baidu.tieba.frs.worldcup.c.a(lVar.aZl().getId(), 2, this.dsC, this.dsF, this.dtC, this.dsD, this.dsG);
        }
    }

    private void awY() {
        if (this.dtE != null && this.dtE.aZl() != null && !StringUtils.isNull(this.dtE.aZl().getId()) && this.dtB != null) {
            this.dtB.setForumId(this.dtE.aZl().getId());
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
                String vI = bbVar.vI();
                if (hVar instanceof com.baidu.tieba.frs.p) {
                    bbVar.needTopMargin = false;
                } else if (hVar != null && !d(hVar)) {
                    bbVar.needTopMargin = false;
                } else if ((hVar instanceof bb) && d(hVar) && !TextUtils.isEmpty(((bb) hVar).vI())) {
                    bbVar.needTopMargin = true;
                } else if (d(hVar2) && !TextUtils.isEmpty(vI)) {
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
                if (this.dtD != null && !this.dtD.containsValue(hVar)) {
                    this.dtD.put(Integer.valueOf(i2), (bb) hVar);
                }
            }
            i = i2 + 1;
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.a.q
    public void fZ(boolean z) {
        if (this.dtF != z) {
            this.dtF = z;
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.a.q
    public HashMap<Integer, bb> awZ() {
        return this.dtD;
    }

    @Override // com.baidu.tieba.frs.entelechy.a.q
    public void axa() {
        List<com.baidu.adp.widget.ListView.h> data;
        if (this.dts != null && this.dts.getData() != null && this.dts.getData().size() != 0 && (data = this.dts.getData()) != null && data.size() != 0) {
            for (com.baidu.adp.widget.ListView.h hVar : data) {
                if ((hVar instanceof bb) && ((bb) hVar).vf() != 0) {
                    ((bb) hVar).vS();
                }
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.a.q
    public void notifyDataSetChanged() {
        if (this.dts.getListAdapter() != null) {
            this.dts.getListAdapter().notifyDataSetChanged();
        }
    }

    public void akd() {
        if (this.alI != null) {
            this.dts.setData(this.alI);
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
            if (this.dsC != null) {
                this.dsC.setFromCDN(z);
            }
            if (this.dsD != null) {
                this.dsD.setFromCDN(z);
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
    public int axb() {
        if (this.dtu != null) {
            return d.g.frs_fortune_bag_item;
        }
        return 0;
    }

    @Override // com.baidu.tieba.frs.entelechy.a.q
    public int axc() {
        if (this.dtu != null) {
            return d.g.frs_my_service_item;
        }
        return 0;
    }

    @Override // com.baidu.tieba.frs.entelechy.a.q
    public int axd() {
        if (this.dtu != null) {
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
    public void axe() {
        if (this.mAdapters != null && this.mAdapters.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.mAdapters) {
                if (aVar instanceof com.baidu.tieba.frs.h) {
                    ((com.baidu.tieba.frs.h) aVar).a(this.dnR.getPageContext(), this.dnR.getUniqueId());
                }
            }
            bo(this.mAdapters);
        }
    }

    private void axf() {
        if (this.dtE != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.mAdapters) {
                if (aVar instanceof com.baidu.tieba.frs.e.c) {
                    com.baidu.tieba.frs.e.c cVar = (com.baidu.tieba.frs.e.c) aVar;
                    if (cVar.axh() != null) {
                        if (this.dtE.gLj == 1) {
                            cVar.axh().dED = true;
                        } else {
                            cVar.axh().dED = false;
                        }
                        if (this.dtE.aZl() != null) {
                            cVar.axh().dEF = this.dtE.aZl().getId();
                        }
                        if (this.dnR != null && this.dnR.auh() != null) {
                            cVar.axh().dEE = this.dnR.auh().azL();
                        }
                    }
                }
            }
            axg();
        }
    }

    private void axg() {
        com.baidu.tieba.frs.e.a aVar = new com.baidu.tieba.frs.e.a();
        if (this.dtE.gLj == 1) {
            aVar.dED = true;
        } else {
            aVar.dED = false;
        }
        if (this.dtE.aZl() != null) {
            aVar.dEF = this.dtE.aZl().getId();
        }
        if (this.dnR != null && this.dnR.auh() != null) {
            aVar.dEE = this.dnR.auh().azL();
        }
        if (com.baidu.tieba.frs.e.c.dtY != null) {
            aVar.dEG = com.baidu.tieba.frs.e.c.dtY.dEG;
            aVar.dEH = com.baidu.tieba.frs.e.c.dtY.dEH;
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
        if (this.dts != null) {
            return this.dts.getData();
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
                    ((com.baidu.tieba.frs.h) aVar).kp(i);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bo(List<com.baidu.adp.widget.ListView.a> list) {
        if (list != null) {
            for (com.baidu.adp.widget.ListView.a aVar : list) {
                if (aVar instanceof com.baidu.tieba.frs.h) {
                    ((com.baidu.tieba.frs.h) aVar).a(this.dlW);
                }
            }
        }
    }

    private void iA(String str) {
        if (this.mAdapters != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.mAdapters) {
                if (aVar instanceof com.baidu.tieba.a.f) {
                    ((com.baidu.tieba.a.f) aVar).iA(str);
                }
            }
        }
    }
}
