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
import com.baidu.tbadk.core.util.v;
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
    private ArrayList<com.baidu.adp.widget.ListView.h> adH;
    private FrsFragment cZJ;
    private i ddn;
    private i ddo;
    private l ddp;
    private p ddq;
    private d ddr;
    private com.baidu.tieba.frs.j dds;
    private com.baidu.adp.widget.ListView.m deh;
    private g dei;
    private com.baidu.adp.widget.ListView.a dej;
    private com.baidu.adp.widget.ListView.a dek;
    private com.baidu.adp.widget.ListView.a del;
    private List<com.baidu.adp.widget.ListView.a> dem;
    private j den;
    private f deo;
    private m dep;
    private n deq;
    private e der;
    private final HashMap<Integer, bd> det;
    private com.baidu.tieba.tbadkCore.l deu;
    private List<com.baidu.adp.widget.ListView.a> mAdapters = new LinkedList();
    private boolean dev = false;
    private CustomMessageListener ddt = new CustomMessageListener(2003008) { // from class: com.baidu.tieba.frs.entelechy.a.b.1
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
                        ((com.baidu.tieba.frs.f) aVar).a(b.this.cZJ.getPageContext(), b.this.cZJ.getUniqueId());
                    }
                }
                ArrayList arrayList = new ArrayList();
                arrayList.addAll(absDelegateAdapterList);
                b.this.bj(arrayList);
                if (b.this.mAdapters != null) {
                    b.this.mAdapters.addAll(absDelegateAdapterList);
                }
                if (b.this.deh != null) {
                    b.this.mAdapters.addAll(arrayList);
                    b.this.deh.addAdapters(arrayList);
                }
            }
        }
    };
    private CustomMessageListener dew = new CustomMessageListener(2016470) { // from class: com.baidu.tieba.frs.entelechy.a.b.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && v.w(b.this.dem)) {
                b.this.arJ();
                b.this.b(b.this.adH, b.this.deu);
            }
        }
    };
    private CustomMessageListener mAttentionListener = new CustomMessageListener(2001115) { // from class: com.baidu.tieba.frs.entelechy.a.b.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
            if (updateAttentionMessage != null && updateAttentionMessage.getData() != null && updateAttentionMessage.getData().Ai) {
                b.this.T(updateAttentionMessage.getData());
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
                bVar.eAJ = true;
                b.this.T(bVar);
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
                bVar.eAJ = false;
                b.this.T(bVar);
            }
        }
    };
    private CustomMessageListener dex = new CustomMessageListener(2016492) { // from class: com.baidu.tieba.frs.entelechy.a.b.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.data.g)) {
                b.this.U((com.baidu.tbadk.data.g) customResponsedMessage.getData());
            }
        }
    };
    private final com.baidu.tieba.frs.d cXW = new com.baidu.tieba.frs.d();

    public b(FrsFragment frsFragment, com.baidu.adp.widget.ListView.m mVar, boolean z) {
        this.deh = mVar;
        a(frsFragment, mVar);
        this.det = new HashMap<>();
        fK(z);
    }

    public void a(FrsFragment frsFragment, com.baidu.adp.widget.ListView.m mVar) {
        this.cZJ = frsFragment;
        this.ddn = new i(frsFragment.getPageContext(), bd.ZH, this.cZJ.getUniqueId());
        this.ddn.setVoiceManager(frsFragment.getVoiceManager());
        this.dei = new g(frsFragment.getPageContext(), bd.ZI, this.cZJ.getUniqueId());
        this.ddp = new l(frsFragment.getPageContext(), bd.ZO, this.cZJ.getUniqueId());
        this.ddo = new i(frsFragment.getPageContext(), bd.ZJ, this.cZJ.getUniqueId());
        this.ddo.setVoiceManager(frsFragment.getVoiceManager());
        this.ddq = new p(frsFragment.getPageContext(), bd.ZK, this.cZJ.getUniqueId());
        this.ddr = new d(frsFragment.getPageContext(), bd.ZP, this.cZJ.getUniqueId());
        this.dej = com.baidu.tieba.frs.a.aoJ().a(frsFragment.getPageContext(), s.gws, this.cZJ.getUniqueId(), false);
        this.dds = new com.baidu.tieba.frs.j(frsFragment.getPageContext(), com.baidu.tieba.frs.k.daG);
        this.dek = com.baidu.tieba.frs.a.aoJ().a(frsFragment.getPageContext(), bd.aaW, this.cZJ.getUniqueId(), true);
        this.del = com.baidu.tieba.frs.a.aoJ().b(frsFragment.getPageContext(), bd.abf, this.cZJ.getUniqueId());
        this.den = new j(frsFragment.getPageContext(), com.baidu.tieba.frs.n.daL);
        this.deo = new f(frsFragment.getPageContext(), bd.ZU, this.cZJ.getUniqueId());
        this.dep = new m(frsFragment.getPageContext(), com.baidu.tieba.frs.o.daR, this.cZJ.getUniqueId());
        this.deq = new n(frsFragment.getPageContext().getPageActivity(), com.baidu.tieba.tbadkCore.k.gwh, this.cZJ.getUniqueId());
        this.der = new e(frsFragment.getPageContext(), bd.ZQ, this.cZJ.getUniqueId());
        this.mAdapters.add(this.deq);
        this.mAdapters.add(this.ddn);
        this.mAdapters.add(this.dei);
        this.mAdapters.add(this.ddp);
        this.mAdapters.add(this.ddo);
        this.mAdapters.add(this.dep);
        com.baidu.tieba.InjectPlugin.b.b bVar = new com.baidu.tieba.InjectPlugin.b.b(this.cZJ, 1);
        bVar.setExtraData(this.mAdapters);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016515, bVar));
        this.mAdapters.add(this.deo);
        if (this.dej != null) {
            this.mAdapters.add(this.dej);
        }
        this.mAdapters.add(this.dds);
        this.mAdapters.add(this.ddq);
        this.mAdapters.add(this.ddr);
        this.mAdapters.add(new com.baidu.tieba.frs.s(this.cZJ.getPageContext(), t.dbd));
        this.mAdapters.add(this.dek);
        if (this.del != null) {
            this.mAdapters.add(this.del);
        }
        this.mAdapters.add(this.den);
        this.mAdapters.add(this.der);
        this.ddt.setPriority(1);
        this.ddt.setSelfListener(true);
        this.cZJ.registerListener(this.ddt);
        this.cZJ.registerListener(this.mAttentionListener);
        this.cZJ.registerListener(this.mLikeForumListener);
        this.cZJ.registerListener(this.mUnlikeForumListener);
        this.cZJ.registerListener(this.dex);
        arI();
        CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2003008, new AbsDelegateAdapterList());
        CustomMessage customMessage = new CustomMessage(2003008);
        customMessage.setTag(this.cZJ.getUniqueId());
        customResponsedMessage.setOrginalMessage(customMessage);
        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
        bj(this.mAdapters);
        mVar.addAdapters(this.mAdapters);
        hZ("page_frs");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void T(Object obj) {
        boolean z;
        boolean z2 = false;
        if (this.adH != null) {
            Iterator<com.baidu.adp.widget.ListView.h> it = this.adH.iterator();
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
    public void U(Object obj) {
        if (this.adH != null) {
            Iterator<com.baidu.adp.widget.ListView.h> it = this.adH.iterator();
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

    private void arI() {
        if (this.cZJ != null && !arJ()) {
            this.cZJ.registerListener(this.dew);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v5, resolved type: com.baidu.tieba.frs.FrsFragment */
    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public boolean arJ() {
        if (this.cZJ == null) {
            return false;
        }
        this.dem = new ArrayList();
        ArrayList<BdUniqueId> brl = com.baidu.tieba.tbadkCore.q.brl();
        if (brl == null || brl.size() <= 0) {
            return false;
        }
        int size = brl.size();
        for (int i = 0; i < size; i++) {
            com.baidu.tieba.frs.f<ICardInfo, ? extends q.a> a = com.baidu.tieba.frs.a.aoJ().a(this.cZJ.getPageContext(), brl.get(i), this.cZJ.getUniqueId());
            if (a != null) {
                this.mAdapters.add(a);
                this.dem.add(a);
            }
        }
        if (!v.w(this.dem)) {
            this.deh.addAdapters(this.dem);
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
        com.baidu.tieba.tbadkCore.q.n(arrayList, 1);
        M(arrayList);
        N(arrayList);
        L(arrayList);
        this.deh.setData(arrayList);
        this.deu = lVar;
        arR();
        arK();
        this.adH = arrayList;
    }

    private void arK() {
        if (this.deu != null && this.deu.aVq() != null && !StringUtils.isNull(this.deu.aVq().getId()) && this.deq != null) {
            this.deq.setForumId(this.deu.aVq().getId());
        }
    }

    private void L(ArrayList<com.baidu.adp.widget.ListView.h> arrayList) {
        int v = v.v(arrayList);
        for (int i = 0; i < v; i++) {
            com.baidu.adp.widget.ListView.h hVar = (com.baidu.adp.widget.ListView.h) v.c(arrayList, i - 1);
            com.baidu.adp.widget.ListView.h hVar2 = (com.baidu.adp.widget.ListView.h) v.c(arrayList, i);
            if (hVar2 instanceof bd) {
                bd bdVar = (bd) hVar2;
                if (i == 0) {
                    bdVar.isFirstFloor = true;
                } else {
                    bdVar.isFirstFloor = false;
                }
                String sm = bdVar.sm();
                if (hVar instanceof com.baidu.tieba.frs.n) {
                    bdVar.needTopMargin = false;
                } else if (hVar != null && !d(hVar)) {
                    bdVar.needTopMargin = false;
                } else if ((hVar instanceof bd) && d(hVar) && !TextUtils.isEmpty(((bd) hVar).sm())) {
                    bdVar.needTopMargin = true;
                } else if (d(hVar2) && !TextUtils.isEmpty(sm)) {
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
        return type == bd.ZH || type == bd.ZJ || type == bd.ZK || type == bd.ZP || type == bd.ZU;
    }

    private ArrayList<Integer> M(ArrayList<com.baidu.adp.widget.ListView.h> arrayList) {
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
                if (this.det != null && !this.det.containsValue(hVar)) {
                    this.det.put(Integer.valueOf(i2), (bd) hVar);
                }
            }
            i = i2 + 1;
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.a.q
    public void fK(boolean z) {
        if (this.dev != z) {
            this.dev = z;
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.a.q
    public HashMap<Integer, bd> arL() {
        return this.det;
    }

    @Override // com.baidu.tieba.frs.entelechy.a.q
    public void arM() {
        List<com.baidu.adp.widget.ListView.h> data;
        if (this.deh != null && this.deh.getData() != null && this.deh.getData().size() != 0 && (data = this.deh.getData()) != null && data.size() != 0) {
            for (com.baidu.adp.widget.ListView.h hVar : data) {
                if ((hVar instanceof bd) && ((bd) hVar).rK() != 0) {
                    ((bd) hVar).sw();
                }
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.a.q
    public void notifyDataSetChanged() {
        if (this.deh.getListAdapter() != null) {
            this.deh.getListAdapter().notifyDataSetChanged();
        }
    }

    public void agD() {
        if (this.adH != null) {
            this.deh.setData(this.adH);
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
            if (this.ddn != null) {
                this.ddn.setFromCDN(z);
            }
            if (this.ddo != null) {
                this.ddo.setFromCDN(z);
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
    public int arN() {
        if (this.dej != null) {
            return d.g.frs_fortune_bag_item;
        }
        return 0;
    }

    @Override // com.baidu.tieba.frs.entelechy.a.q
    public int arO() {
        if (this.dej != null) {
            return d.g.frs_my_service_item;
        }
        return 0;
    }

    @Override // com.baidu.tieba.frs.entelechy.a.q
    public int arP() {
        if (this.dej != null) {
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
    public void arQ() {
        if (this.mAdapters != null && this.mAdapters.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.mAdapters) {
                if (aVar instanceof com.baidu.tieba.frs.f) {
                    ((com.baidu.tieba.frs.f) aVar).a(this.cZJ.getPageContext(), this.cZJ.getUniqueId());
                }
            }
            bj(this.mAdapters);
        }
    }

    private void arR() {
        if (this.deu != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.mAdapters) {
                if (aVar instanceof com.baidu.tieba.frs.e.c) {
                    com.baidu.tieba.frs.e.c cVar = (com.baidu.tieba.frs.e.c) aVar;
                    if (com.baidu.tieba.frs.e.c.dpD != null) {
                        if (this.deu.guT == 1) {
                            com.baidu.tieba.frs.e.c.dpD.dpr = true;
                        } else {
                            com.baidu.tieba.frs.e.c.dpD.dpr = false;
                        }
                        if (this.deu.aVq() != null) {
                            com.baidu.tieba.frs.e.c.dpD.dpt = this.deu.aVq().getId();
                        }
                        if (this.cZJ != null && this.cZJ.apg() != null) {
                            com.baidu.tieba.frs.e.c.dpD.dps = this.cZJ.apg().aum();
                        }
                    }
                }
            }
            arS();
        }
    }

    private void arS() {
        com.baidu.tieba.frs.e.a aVar = new com.baidu.tieba.frs.e.a();
        if (this.deu.guT == 1) {
            aVar.dpr = true;
        } else {
            aVar.dpr = false;
        }
        if (this.deu.aVq() != null) {
            aVar.dpt = this.deu.aVq().getId();
        }
        if (this.cZJ != null && this.cZJ.apg() != null) {
            aVar.dps = this.cZJ.apg().aum();
        }
        if (com.baidu.tieba.frs.e.c.dpD != null) {
            aVar.dpu = com.baidu.tieba.frs.e.c.dpD.dpu;
            aVar.dpv = com.baidu.tieba.frs.e.c.dpD.dpv;
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
        if (this.deh != null) {
            return this.deh.getData();
        }
        return null;
    }

    private void N(ArrayList<com.baidu.adp.widget.ListView.h> arrayList) {
        int i;
        if (this.mAdapters != null && this.mAdapters.size() != 0) {
            int i2 = 0;
            if (arrayList == null || arrayList.size() <= 0) {
                i = 0;
            } else {
                Iterator<com.baidu.adp.widget.ListView.h> it = arrayList.iterator();
                while (true) {
                    i = i2;
                    if (!it.hasNext() || it.next().getType().getId() != bd.ZG.getId()) {
                        break;
                    }
                    i2 = i + 1;
                }
            }
            for (com.baidu.adp.widget.ListView.a aVar : this.mAdapters) {
                if (aVar instanceof com.baidu.tieba.frs.f) {
                    ((com.baidu.tieba.frs.f) aVar).jX(i);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bj(List<com.baidu.adp.widget.ListView.a> list) {
        if (list != null) {
            for (com.baidu.adp.widget.ListView.a aVar : list) {
                if (aVar instanceof com.baidu.tieba.frs.f) {
                    ((com.baidu.tieba.frs.f) aVar).a(this.cXW);
                }
            }
        }
    }

    private void hZ(String str) {
        if (this.mAdapters != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.mAdapters) {
                if (aVar instanceof com.baidu.tieba.a.f) {
                    ((com.baidu.tieba.a.f) aVar).hZ(str);
                }
            }
        }
    }
}
