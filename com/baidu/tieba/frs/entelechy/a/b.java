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
/* loaded from: classes2.dex */
public class b implements q {
    private ArrayList<com.baidu.adp.widget.ListView.h> aom;
    private List<com.baidu.adp.widget.ListView.a> dAa;
    private j dAb;
    private f dAc;
    private m dAd;
    private n dAe;
    private e dAf;
    private final HashMap<Integer, bb> dAg;
    private com.baidu.tieba.tbadkCore.l dAh;
    private FrsFragment dtN;
    private com.baidu.tieba.frs.l dwv;
    private p dyP;
    private d dyQ;
    private com.baidu.adp.widget.ListView.m dzV;
    private g dzW;
    private com.baidu.adp.widget.ListView.a dzX;
    private com.baidu.adp.widget.ListView.a dzY;
    private com.baidu.adp.widget.ListView.a dzZ;
    private i dzh;
    private i dzi;
    private l dzj;
    private List<com.baidu.adp.widget.ListView.a> mAdapters = new LinkedList();
    private boolean dAi = false;
    private CustomMessageListener dzk = new CustomMessageListener(2003008) { // from class: com.baidu.tieba.frs.entelechy.a.b.1
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
                        ((com.baidu.tieba.frs.h) aVar).a(b.this.dtN.getPageContext(), b.this.dtN.getUniqueId());
                    }
                }
                ArrayList arrayList = new ArrayList();
                arrayList.addAll(absDelegateAdapterList);
                b.this.bp(arrayList);
                if (b.this.mAdapters != null) {
                    b.this.mAdapters.addAll(absDelegateAdapterList);
                }
                if (b.this.dzV != null) {
                    b.this.mAdapters.addAll(arrayList);
                    b.this.dzV.addAdapters(arrayList);
                }
            }
        }
    };
    private CustomMessageListener dAj = new CustomMessageListener(2016470) { // from class: com.baidu.tieba.frs.entelechy.a.b.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && v.z(b.this.dAa)) {
                b.this.azk();
                b.this.b(b.this.aom, b.this.dAh);
            }
        }
    };
    private CustomMessageListener mAttentionListener = new CustomMessageListener(2001115) { // from class: com.baidu.tieba.frs.entelechy.a.b.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
            if (updateAttentionMessage != null && updateAttentionMessage.getData() != null && updateAttentionMessage.getData().IM) {
                b.this.ab(updateAttentionMessage.getData());
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
                bVar.ajP = true;
                b.this.ab(bVar);
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
                bVar.ajP = false;
                b.this.ab(bVar);
            }
        }
    };
    private CustomMessageListener dAk = new CustomMessageListener(2016492) { // from class: com.baidu.tieba.frs.entelechy.a.b.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.data.g)) {
                b.this.ac((com.baidu.tbadk.data.g) customResponsedMessage.getData());
            }
        }
    };
    private final com.baidu.tieba.frs.f drR = new com.baidu.tieba.frs.f();

    public b(FrsFragment frsFragment, com.baidu.adp.widget.ListView.m mVar, boolean z) {
        this.dzV = mVar;
        a(frsFragment, mVar);
        this.dAg = new HashMap<>();
        gx(z);
    }

    public void a(FrsFragment frsFragment, com.baidu.adp.widget.ListView.m mVar) {
        this.dtN = frsFragment;
        this.dzh = new i(frsFragment.getPageContext(), bb.ajX, this.dtN.getUniqueId());
        this.dzh.setVoiceManager(frsFragment.getVoiceManager());
        this.dzh.setInFrsAllThread(true);
        this.dzW = new g(frsFragment.getPageContext(), bb.ajY, this.dtN.getUniqueId());
        this.dzW.setInFrsAllThread(true);
        this.dzj = new l(frsFragment.getPageContext(), bb.ake, this.dtN.getUniqueId());
        this.dzj.setInFrsAllThread(true);
        this.dzi = new i(frsFragment.getPageContext(), bb.ajZ, this.dtN.getUniqueId());
        this.dzi.setVoiceManager(frsFragment.getVoiceManager());
        this.dzi.setInFrsAllThread(true);
        this.dyP = new p(frsFragment.getPageContext(), bb.aka, this.dtN.getUniqueId());
        this.dyP.setInFrsAllThread(true);
        this.dyQ = new d(frsFragment.getPageContext(), bb.akf, this.dtN.getUniqueId());
        this.dyQ.setInFrsAllThread(true);
        this.dzX = com.baidu.tieba.frs.c.avz().a(frsFragment.getPageContext(), s.gUu, this.dtN.getUniqueId(), false);
        this.dwv = new com.baidu.tieba.frs.l(frsFragment.getPageContext(), com.baidu.tieba.frs.m.duQ);
        this.dzY = com.baidu.tieba.frs.c.avz().a(frsFragment.getPageContext(), bb.alv, this.dtN.getUniqueId(), true);
        this.dzZ = com.baidu.tieba.frs.c.avz().b(frsFragment.getPageContext(), bb.alD, this.dtN.getUniqueId());
        this.dAb = new j(frsFragment.getPageContext(), com.baidu.tieba.frs.p.duV);
        this.dAc = new f(frsFragment.getPageContext(), bb.akl, this.dtN.getUniqueId());
        this.dAd = new m(frsFragment.getPageContext(), com.baidu.tieba.frs.q.dvb, this.dtN.getUniqueId());
        this.dAe = new n(frsFragment.getPageContext().getPageActivity(), com.baidu.tieba.tbadkCore.k.gUj, this.dtN.getUniqueId());
        this.dAf = new e(frsFragment.getPageContext(), bb.akg, this.dtN.getUniqueId());
        this.mAdapters.add(this.dAe);
        this.mAdapters.add(this.dzh);
        this.mAdapters.add(this.dzW);
        this.mAdapters.add(this.dzj);
        this.mAdapters.add(this.dzi);
        this.mAdapters.add(this.dAd);
        com.baidu.tieba.InjectPlugin.b.b bVar = new com.baidu.tieba.InjectPlugin.b.b(this.dtN, 1);
        bVar.setExtraData(this.mAdapters);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016515, bVar));
        this.mAdapters.add(this.dAc);
        if (this.dzX != null) {
            this.mAdapters.add(this.dzX);
        }
        this.mAdapters.add(this.dwv);
        this.mAdapters.add(this.dyP);
        this.mAdapters.add(this.dyQ);
        this.mAdapters.add(new u(this.dtN.getPageContext(), com.baidu.tieba.frs.v.dvx));
        this.mAdapters.add(this.dzY);
        if (this.dzZ != null) {
            this.mAdapters.add(this.dzZ);
        }
        this.mAdapters.add(this.dAb);
        this.mAdapters.add(this.dAf);
        this.dzk.setPriority(1);
        this.dzk.setSelfListener(true);
        this.dtN.registerListener(this.dzk);
        this.dtN.registerListener(this.mAttentionListener);
        this.dtN.registerListener(this.mLikeForumListener);
        this.dtN.registerListener(this.mUnlikeForumListener);
        this.dtN.registerListener(this.dAk);
        azj();
        CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2003008, new AbsDelegateAdapterList());
        CustomMessage customMessage = new CustomMessage(2003008);
        customMessage.setTag(this.dtN.getUniqueId());
        customResponsedMessage.setOrginalMessage(customMessage);
        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
        bp(this.mAdapters);
        mVar.addAdapters(this.mAdapters);
        jd("page_frs");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ab(Object obj) {
        boolean z;
        boolean z2 = false;
        if (this.aom != null) {
            Iterator<com.baidu.adp.widget.ListView.h> it = this.aom.iterator();
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
    public void ac(Object obj) {
        if (this.aom != null) {
            Iterator<com.baidu.adp.widget.ListView.h> it = this.aom.iterator();
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

    private void azj() {
        if (this.dtN != null && !azk()) {
            this.dtN.registerListener(this.dAj);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v5, resolved type: com.baidu.tieba.frs.FrsFragment */
    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public boolean azk() {
        if (this.dtN == null) {
            return false;
        }
        this.dAa = new ArrayList();
        ArrayList<BdUniqueId> bxZ = com.baidu.tieba.tbadkCore.q.bxZ();
        if (bxZ == null || bxZ.size() <= 0) {
            return false;
        }
        int size = bxZ.size();
        for (int i = 0; i < size; i++) {
            com.baidu.tieba.frs.h<ICardInfo, ? extends q.a> a = com.baidu.tieba.frs.c.avz().a(this.dtN.getPageContext(), bxZ.get(i), this.dtN.getUniqueId());
            if (a != null) {
                this.mAdapters.add(a);
                this.dAa.add(a);
            }
        }
        if (!v.z(this.dAa)) {
            this.dzV.addAdapters(this.dAa);
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
        this.dzV.setData(arrayList);
        this.dAh = lVar;
        ayG();
        azl();
        this.aom = arrayList;
    }

    private void c(com.baidu.tieba.tbadkCore.l lVar) {
        if (lVar != null && lVar.bbH() != null && "worldcup".equals(lVar.bbH().getSpecialForumType())) {
            com.baidu.tieba.frs.worldcup.c.a(lVar.bbH().getId(), 2, this.dzh, this.dyP, this.dAf, this.dzi, this.dyQ);
        }
    }

    private void azl() {
        if (this.dAh != null && this.dAh.bbH() != null && !StringUtils.isNull(this.dAh.bbH().getId()) && this.dAe != null) {
            this.dAe.setForumId(this.dAh.bbH().getId());
        }
    }

    private void Q(ArrayList<com.baidu.adp.widget.ListView.h> arrayList) {
        int y = v.y(arrayList);
        for (int i = 0; i < y; i++) {
            com.baidu.adp.widget.ListView.h hVar = (com.baidu.adp.widget.ListView.h) v.d(arrayList, i - 1);
            com.baidu.adp.widget.ListView.h hVar2 = (com.baidu.adp.widget.ListView.h) v.d(arrayList, i);
            if (hVar2 instanceof bb) {
                bb bbVar = (bb) hVar2;
                if (i == 0) {
                    bbVar.isFirstFloor = true;
                } else {
                    bbVar.isFirstFloor = false;
                }
                String wL = bbVar.wL();
                if (hVar instanceof com.baidu.tieba.frs.p) {
                    bbVar.needTopMargin = false;
                } else if (hVar != null && !d(hVar)) {
                    bbVar.needTopMargin = false;
                } else if ((hVar instanceof bb) && d(hVar) && !TextUtils.isEmpty(((bb) hVar).wL())) {
                    bbVar.needTopMargin = true;
                } else if (d(hVar2) && !TextUtils.isEmpty(wL)) {
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
        return type == bb.ajX || type == bb.ajZ || type == bb.aka || type == bb.akf || type == bb.akl;
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
                if (this.dAg != null && !this.dAg.containsValue(hVar)) {
                    this.dAg.put(Integer.valueOf(i2), (bb) hVar);
                }
            }
            i = i2 + 1;
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.a.q
    public void gx(boolean z) {
        if (this.dAi != z) {
            this.dAi = z;
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.a.q
    public HashMap<Integer, bb> azm() {
        return this.dAg;
    }

    @Override // com.baidu.tieba.frs.entelechy.a.q
    public void azn() {
        List<com.baidu.adp.widget.ListView.h> data;
        if (this.dzV != null && this.dzV.getData() != null && this.dzV.getData().size() != 0 && (data = this.dzV.getData()) != null && data.size() != 0) {
            for (com.baidu.adp.widget.ListView.h hVar : data) {
                if ((hVar instanceof bb) && ((bb) hVar).wh() != 0) {
                    ((bb) hVar).wW();
                }
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.a.q
    public void notifyDataSetChanged() {
        if (this.dzV.getListAdapter() != null) {
            this.dzV.getListAdapter().notifyDataSetChanged();
        }
    }

    public void alQ() {
        if (this.aom != null) {
            this.dzV.setData(this.aom);
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
            if (this.dzh != null) {
                this.dzh.setFromCDN(z);
            }
            if (this.dzi != null) {
                this.dzi.setFromCDN(z);
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
    public int azo() {
        if (this.dzX != null) {
            return e.g.frs_fortune_bag_item;
        }
        return 0;
    }

    @Override // com.baidu.tieba.frs.entelechy.a.q
    public int azp() {
        if (this.dzX != null) {
            return e.g.frs_my_service_item;
        }
        return 0;
    }

    @Override // com.baidu.tieba.frs.entelechy.a.q
    public int azq() {
        if (this.dzX != null) {
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
    public void azr() {
        if (this.mAdapters != null && this.mAdapters.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.mAdapters) {
                if (aVar instanceof com.baidu.tieba.frs.h) {
                    ((com.baidu.tieba.frs.h) aVar).a(this.dtN.getPageContext(), this.dtN.getUniqueId());
                }
            }
            bp(this.mAdapters);
        }
    }

    private void ayG() {
        com.baidu.tieba.frs.e.a azt;
        if (this.dAh != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.mAdapters) {
                if ((aVar instanceof com.baidu.tieba.frs.e.c) && (azt = ((com.baidu.tieba.frs.e.c) aVar).azt()) != null) {
                    if (this.dAh.gSN == 1) {
                        azt.dLH = true;
                    } else {
                        azt.dLH = false;
                    }
                    if (this.dAh.bbH() != null) {
                        azt.dLJ = this.dAh.bbH().getId();
                    }
                    if (this.dtN != null && this.dtN.avZ() != null) {
                        azt.dLI = this.dtN.avZ().aBR();
                    }
                }
            }
            azs();
        }
    }

    private void azs() {
        com.baidu.tieba.frs.e.a aVar = new com.baidu.tieba.frs.e.a();
        if (this.dAh.gSN == 1) {
            aVar.dLH = true;
        } else {
            aVar.dLH = false;
        }
        if (this.dAh.bbH() != null) {
            aVar.dLJ = this.dAh.bbH().getId();
        }
        if (this.dtN != null && this.dtN.avZ() != null) {
            aVar.dLI = this.dtN.avZ().aBR();
        }
        if (com.baidu.tieba.frs.e.c.dAB != null) {
            aVar.dLK = com.baidu.tieba.frs.e.c.dAB.dLK;
            aVar.dLL = com.baidu.tieba.frs.e.c.dAB.dLL;
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
        if (this.dzV != null) {
            return this.dzV.getData();
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
                    if (!it.hasNext() || it.next().getType().getId() != bb.ajW.getId()) {
                        break;
                    }
                    i2 = i + 1;
                }
            }
            for (com.baidu.adp.widget.ListView.a aVar : this.mAdapters) {
                if (aVar instanceof com.baidu.tieba.frs.h) {
                    ((com.baidu.tieba.frs.h) aVar).kN(i);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bp(List<com.baidu.adp.widget.ListView.a> list) {
        if (list != null) {
            for (com.baidu.adp.widget.ListView.a aVar : list) {
                if (aVar instanceof com.baidu.tieba.frs.h) {
                    ((com.baidu.tieba.frs.h) aVar).a(this.drR);
                }
            }
        }
    }

    private void jd(String str) {
        if (this.mAdapters != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.mAdapters) {
                if (aVar instanceof com.baidu.tieba.a.f) {
                    ((com.baidu.tieba.a.f) aVar).jd(str);
                }
            }
        }
    }
}
