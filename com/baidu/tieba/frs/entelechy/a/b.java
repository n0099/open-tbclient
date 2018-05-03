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
    private FrsFragment cYC;
    private com.baidu.adp.widget.ListView.m dcZ;
    private i dcf;
    private i dcg;
    private l dch;
    private p dci;
    private d dcj;
    private com.baidu.tieba.frs.j dck;
    private g dda;
    private com.baidu.adp.widget.ListView.a ddb;
    private com.baidu.adp.widget.ListView.a ddc;
    private com.baidu.adp.widget.ListView.a ddd;
    private List<com.baidu.adp.widget.ListView.a> dde;
    private j ddf;
    private f ddg;
    private m ddh;
    private n ddi;
    private e ddj;
    private final HashMap<Integer, bd> ddk;
    private com.baidu.tieba.tbadkCore.l ddl;
    private List<com.baidu.adp.widget.ListView.a> mAdapters = new LinkedList();
    private boolean ddm = false;
    private CustomMessageListener dcl = new CustomMessageListener(2003008) { // from class: com.baidu.tieba.frs.entelechy.a.b.1
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
                        ((com.baidu.tieba.frs.f) aVar).a(b.this.cYC.getPageContext(), b.this.cYC.getUniqueId());
                    }
                }
                ArrayList arrayList = new ArrayList();
                arrayList.addAll(absDelegateAdapterList);
                b.this.bg(arrayList);
                if (b.this.mAdapters != null) {
                    b.this.mAdapters.addAll(absDelegateAdapterList);
                }
                if (b.this.dcZ != null) {
                    b.this.mAdapters.addAll(arrayList);
                    b.this.dcZ.addAdapters(arrayList);
                }
            }
        }
    };
    private CustomMessageListener ddn = new CustomMessageListener(2016470) { // from class: com.baidu.tieba.frs.entelechy.a.b.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && v.w(b.this.dde)) {
                b.this.arK();
                b.this.b(b.this.adH, b.this.ddl);
            }
        }
    };
    private CustomMessageListener mAttentionListener = new CustomMessageListener(2001115) { // from class: com.baidu.tieba.frs.entelechy.a.b.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
            if (updateAttentionMessage != null && updateAttentionMessage.getData() != null && updateAttentionMessage.getData().Aj) {
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
                bVar.ezB = true;
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
                bVar.ezB = false;
                b.this.T(bVar);
            }
        }
    };
    private CustomMessageListener ddo = new CustomMessageListener(2016492) { // from class: com.baidu.tieba.frs.entelechy.a.b.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.data.g)) {
                b.this.U((com.baidu.tbadk.data.g) customResponsedMessage.getData());
            }
        }
    };
    private final com.baidu.tieba.frs.d cWP = new com.baidu.tieba.frs.d();

    public b(FrsFragment frsFragment, com.baidu.adp.widget.ListView.m mVar, boolean z) {
        this.dcZ = mVar;
        a(frsFragment, mVar);
        this.ddk = new HashMap<>();
        fJ(z);
    }

    public void a(FrsFragment frsFragment, com.baidu.adp.widget.ListView.m mVar) {
        this.cYC = frsFragment;
        this.dcf = new i(frsFragment.getPageContext(), bd.ZH, this.cYC.getUniqueId());
        this.dcf.setVoiceManager(frsFragment.getVoiceManager());
        this.dda = new g(frsFragment.getPageContext(), bd.ZI, this.cYC.getUniqueId());
        this.dch = new l(frsFragment.getPageContext(), bd.ZO, this.cYC.getUniqueId());
        this.dcg = new i(frsFragment.getPageContext(), bd.ZJ, this.cYC.getUniqueId());
        this.dcg.setVoiceManager(frsFragment.getVoiceManager());
        this.dci = new p(frsFragment.getPageContext(), bd.ZK, this.cYC.getUniqueId());
        this.dcj = new d(frsFragment.getPageContext(), bd.ZP, this.cYC.getUniqueId());
        this.ddb = com.baidu.tieba.frs.a.aoK().a(frsFragment.getPageContext(), s.gvo, this.cYC.getUniqueId(), false);
        this.dck = new com.baidu.tieba.frs.j(frsFragment.getPageContext(), com.baidu.tieba.frs.k.cZx);
        this.ddc = com.baidu.tieba.frs.a.aoK().a(frsFragment.getPageContext(), bd.aaV, this.cYC.getUniqueId(), true);
        this.ddd = com.baidu.tieba.frs.a.aoK().b(frsFragment.getPageContext(), bd.abe, this.cYC.getUniqueId());
        this.ddf = new j(frsFragment.getPageContext(), com.baidu.tieba.frs.n.cZC);
        this.ddg = new f(frsFragment.getPageContext(), bd.ZU, this.cYC.getUniqueId());
        this.ddh = new m(frsFragment.getPageContext(), com.baidu.tieba.frs.o.cZI, this.cYC.getUniqueId());
        this.ddi = new n(frsFragment.getPageContext().getPageActivity(), com.baidu.tieba.tbadkCore.k.gvd, this.cYC.getUniqueId());
        this.ddj = new e(frsFragment.getPageContext(), bd.ZQ, this.cYC.getUniqueId());
        this.mAdapters.add(this.ddi);
        this.mAdapters.add(this.dcf);
        this.mAdapters.add(this.dda);
        this.mAdapters.add(this.dch);
        this.mAdapters.add(this.dcg);
        this.mAdapters.add(this.ddh);
        com.baidu.tieba.InjectPlugin.b.b bVar = new com.baidu.tieba.InjectPlugin.b.b(this.cYC, 1);
        bVar.setExtraData(this.mAdapters);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016515, bVar));
        this.mAdapters.add(this.ddg);
        if (this.ddb != null) {
            this.mAdapters.add(this.ddb);
        }
        this.mAdapters.add(this.dck);
        this.mAdapters.add(this.dci);
        this.mAdapters.add(this.dcj);
        this.mAdapters.add(new com.baidu.tieba.frs.s(this.cYC.getPageContext(), t.cZU));
        this.mAdapters.add(this.ddc);
        if (this.ddd != null) {
            this.mAdapters.add(this.ddd);
        }
        this.mAdapters.add(this.ddf);
        this.mAdapters.add(this.ddj);
        this.dcl.setPriority(1);
        this.dcl.setSelfListener(true);
        this.cYC.registerListener(this.dcl);
        this.cYC.registerListener(this.mAttentionListener);
        this.cYC.registerListener(this.mLikeForumListener);
        this.cYC.registerListener(this.mUnlikeForumListener);
        this.cYC.registerListener(this.ddo);
        arJ();
        CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2003008, new AbsDelegateAdapterList());
        CustomMessage customMessage = new CustomMessage(2003008);
        customMessage.setTag(this.cYC.getUniqueId());
        customResponsedMessage.setOrginalMessage(customMessage);
        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
        bg(this.mAdapters);
        mVar.addAdapters(this.mAdapters);
        hY("page_frs");
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

    private void arJ() {
        if (this.cYC != null && !arK()) {
            this.cYC.registerListener(this.ddn);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v5, resolved type: com.baidu.tieba.frs.FrsFragment */
    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public boolean arK() {
        if (this.cYC == null) {
            return false;
        }
        this.dde = new ArrayList();
        ArrayList<BdUniqueId> brn = com.baidu.tieba.tbadkCore.q.brn();
        if (brn == null || brn.size() <= 0) {
            return false;
        }
        int size = brn.size();
        for (int i = 0; i < size; i++) {
            com.baidu.tieba.frs.f<ICardInfo, ? extends q.a> a = com.baidu.tieba.frs.a.aoK().a(this.cYC.getPageContext(), brn.get(i), this.cYC.getUniqueId());
            if (a != null) {
                this.mAdapters.add(a);
                this.dde.add(a);
            }
        }
        if (!v.w(this.dde)) {
            this.dcZ.addAdapters(this.dde);
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
        this.dcZ.setData(arrayList);
        this.ddl = lVar;
        arS();
        arL();
        this.adH = arrayList;
    }

    private void arL() {
        if (this.ddl != null && this.ddl.aVq() != null && !StringUtils.isNull(this.ddl.aVq().getId()) && this.ddi != null) {
            this.ddi.setForumId(this.ddl.aVq().getId());
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
                String sn = bdVar.sn();
                if (hVar instanceof com.baidu.tieba.frs.n) {
                    bdVar.needTopMargin = false;
                } else if (hVar != null && !d(hVar)) {
                    bdVar.needTopMargin = false;
                } else if ((hVar instanceof bd) && d(hVar) && !TextUtils.isEmpty(((bd) hVar).sn())) {
                    bdVar.needTopMargin = true;
                } else if (d(hVar2) && !TextUtils.isEmpty(sn)) {
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
                if (this.ddk != null && !this.ddk.containsValue(hVar)) {
                    this.ddk.put(Integer.valueOf(i2), (bd) hVar);
                }
            }
            i = i2 + 1;
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.a.q
    public void fJ(boolean z) {
        if (this.ddm != z) {
            this.ddm = z;
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.a.q
    public HashMap<Integer, bd> arM() {
        return this.ddk;
    }

    @Override // com.baidu.tieba.frs.entelechy.a.q
    public void arN() {
        List<com.baidu.adp.widget.ListView.h> data;
        if (this.dcZ != null && this.dcZ.getData() != null && this.dcZ.getData().size() != 0 && (data = this.dcZ.getData()) != null && data.size() != 0) {
            for (com.baidu.adp.widget.ListView.h hVar : data) {
                if ((hVar instanceof bd) && ((bd) hVar).rL() != 0) {
                    ((bd) hVar).sx();
                }
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.a.q
    public void notifyDataSetChanged() {
        if (this.dcZ.getListAdapter() != null) {
            this.dcZ.getListAdapter().notifyDataSetChanged();
        }
    }

    public void agD() {
        if (this.adH != null) {
            this.dcZ.setData(this.adH);
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
            if (this.dcf != null) {
                this.dcf.setFromCDN(z);
            }
            if (this.dcg != null) {
                this.dcg.setFromCDN(z);
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
    public int arO() {
        if (this.ddb != null) {
            return d.g.frs_fortune_bag_item;
        }
        return 0;
    }

    @Override // com.baidu.tieba.frs.entelechy.a.q
    public int arP() {
        if (this.ddb != null) {
            return d.g.frs_my_service_item;
        }
        return 0;
    }

    @Override // com.baidu.tieba.frs.entelechy.a.q
    public int arQ() {
        if (this.ddb != null) {
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
    public void arR() {
        if (this.mAdapters != null && this.mAdapters.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.mAdapters) {
                if (aVar instanceof com.baidu.tieba.frs.f) {
                    ((com.baidu.tieba.frs.f) aVar).a(this.cYC.getPageContext(), this.cYC.getUniqueId());
                }
            }
            bg(this.mAdapters);
        }
    }

    private void arS() {
        if (this.ddl != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.mAdapters) {
                if (aVar instanceof com.baidu.tieba.frs.e.c) {
                    com.baidu.tieba.frs.e.c cVar = (com.baidu.tieba.frs.e.c) aVar;
                    if (com.baidu.tieba.frs.e.c.dov != null) {
                        if (this.ddl.gtP == 1) {
                            com.baidu.tieba.frs.e.c.dov.doj = true;
                        } else {
                            com.baidu.tieba.frs.e.c.dov.doj = false;
                        }
                        if (this.ddl.aVq() != null) {
                            com.baidu.tieba.frs.e.c.dov.dol = this.ddl.aVq().getId();
                        }
                        if (this.cYC != null && this.cYC.aph() != null) {
                            com.baidu.tieba.frs.e.c.dov.dok = this.cYC.aph().aun();
                        }
                    }
                }
            }
            arT();
        }
    }

    private void arT() {
        com.baidu.tieba.frs.e.a aVar = new com.baidu.tieba.frs.e.a();
        if (this.ddl.gtP == 1) {
            aVar.doj = true;
        } else {
            aVar.doj = false;
        }
        if (this.ddl.aVq() != null) {
            aVar.dol = this.ddl.aVq().getId();
        }
        if (this.cYC != null && this.cYC.aph() != null) {
            aVar.dok = this.cYC.aph().aun();
        }
        if (com.baidu.tieba.frs.e.c.dov != null) {
            aVar.dom = com.baidu.tieba.frs.e.c.dov.dom;
            aVar.don = com.baidu.tieba.frs.e.c.dov.don;
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
        if (this.dcZ != null) {
            return this.dcZ.getData();
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
                    ((com.baidu.tieba.frs.f) aVar).jY(i);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bg(List<com.baidu.adp.widget.ListView.a> list) {
        if (list != null) {
            for (com.baidu.adp.widget.ListView.a aVar : list) {
                if (aVar instanceof com.baidu.tieba.frs.f) {
                    ((com.baidu.tieba.frs.f) aVar).a(this.cWP);
                }
            }
        }
    }

    private void hY(String str) {
        if (this.mAdapters != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.mAdapters) {
                if (aVar instanceof com.baidu.tieba.a.f) {
                    ((com.baidu.tieba.a.f) aVar).hY(str);
                }
            }
        }
    }
}
