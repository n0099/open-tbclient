package com.baidu.tieba.frs.entelechy.a;

import android.text.TextUtils;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.r;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.data.ar;
import com.baidu.tbadk.core.data.as;
import com.baidu.tbadk.core.data.bd;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.coreExtra.message.UpdateAttentionMessage;
import com.baidu.tieba.card.t;
import com.baidu.tieba.card.u;
import com.baidu.tieba.d;
import com.baidu.tieba.frs.AbsDelegateAdapterList;
import com.baidu.tieba.frs.w;
import com.baidu.tieba.frs.x;
import com.baidu.tieba.lego.card.model.ICardInfo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes2.dex */
public class b implements s {
    private ArrayList<com.baidu.adp.widget.ListView.i> aSu;
    private com.baidu.tieba.frs.i dFP;
    private com.baidu.adp.widget.ListView.n dJU;
    private k dJV;
    private i dJW;
    private n dJX;
    private k dJY;
    private c dJZ;
    private com.baidu.adp.widget.ListView.a dKa;
    private com.baidu.tieba.frs.p dKb;
    private r dKc;
    private g dKd;
    private com.baidu.adp.widget.ListView.a dKe;
    private com.baidu.adp.widget.ListView.a dKf;
    private d dKg;
    private d dKh;
    private com.baidu.tieba.frs.l dKi;
    private List<com.baidu.adp.widget.ListView.a> dKj;
    private l dKk;
    private h dKl;
    private o dKm;
    private p dKn;
    private final HashMap<Integer, bd> dKo;
    private com.baidu.tieba.tbadkCore.l dKp;
    private List<com.baidu.adp.widget.ListView.a> mAdapters = new LinkedList();
    private boolean dKq = false;
    private CustomMessageListener dKr = new CustomMessageListener(2003008) { // from class: com.baidu.tieba.frs.entelechy.a.b.1
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX DEBUG: Multi-variable search result rejected for r3v2, resolved type: com.baidu.tieba.frs.i */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2003008 && (customResponsedMessage.getData() instanceof AbsDelegateAdapterList)) {
                AbsDelegateAdapterList absDelegateAdapterList = (AbsDelegateAdapterList) customResponsedMessage.getData();
                Iterator it = absDelegateAdapterList.iterator();
                while (it.hasNext()) {
                    com.baidu.adp.widget.ListView.a aVar = (com.baidu.adp.widget.ListView.a) it.next();
                    if (aVar instanceof com.baidu.tieba.frs.g) {
                        ((com.baidu.tieba.frs.g) aVar).a(b.this.dFP.getPageContext(), b.this.dFP.getUniqueId());
                    }
                }
                ArrayList arrayList = new ArrayList();
                arrayList.addAll(absDelegateAdapterList);
                b.this.bm(arrayList);
                if (b.this.mAdapters != null) {
                    b.this.mAdapters.addAll(absDelegateAdapterList);
                }
                if (b.this.dJU != null) {
                    b.this.mAdapters.addAll(arrayList);
                    b.this.dJU.addAdapters(arrayList);
                }
            }
        }
    };
    private CustomMessageListener dKs = new CustomMessageListener(2016470) { // from class: com.baidu.tieba.frs.entelechy.a.b.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && v.E(b.this.dKj)) {
                b.this.axl();
                b.this.b(b.this.aSu, b.this.dKp);
            }
        }
    };
    private CustomMessageListener mAttentionListener = new CustomMessageListener(2001115) { // from class: com.baidu.tieba.frs.entelechy.a.b.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
            if (updateAttentionMessage != null && updateAttentionMessage.getData() != null && updateAttentionMessage.getData().apP) {
                b.this.aY(updateAttentionMessage.getData());
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
                bVar.feO = true;
                b.this.aY(bVar);
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
                bVar.feO = false;
                b.this.aY(bVar);
            }
        }
    };
    private CustomMessageListener dKt = new CustomMessageListener(2016492) { // from class: com.baidu.tieba.frs.entelechy.a.b.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.data.g)) {
                b.this.aZ((com.baidu.tbadk.data.g) customResponsedMessage.getData());
            }
        }
    };
    private final com.baidu.tieba.frs.e dEf = new com.baidu.tieba.frs.e();

    public b(com.baidu.tieba.frs.i iVar, com.baidu.adp.widget.ListView.n nVar, boolean z) {
        this.dJU = nVar;
        a(iVar, nVar);
        this.dKo = new HashMap<>();
        gd(z);
    }

    public void a(com.baidu.tieba.frs.i iVar, com.baidu.adp.widget.ListView.n nVar) {
        this.dFP = iVar;
        this.dJV = new k(iVar.getPageContext(), bd.aOu, this.dFP.getUniqueId());
        this.dJV.setVoiceManager(iVar.getVoiceManager());
        this.dJW = new i(iVar.getPageContext(), bd.aOv, this.dFP.getUniqueId());
        this.dJX = new n(iVar.getPageContext(), bd.aOB, this.dFP.getUniqueId());
        this.dJY = new k(iVar.getPageContext(), bd.aOw, this.dFP.getUniqueId());
        this.dJY.setVoiceManager(iVar.getVoiceManager());
        this.dKc = new r(iVar.getPageContext(), bd.aOx, this.dFP.getUniqueId());
        this.dKd = new g(iVar.getPageContext(), bd.aOC, this.dFP.getUniqueId());
        this.dJZ = new c(iVar.getPageContext(), ar.aNQ, this.dFP.getUniqueId());
        this.dKa = com.baidu.tieba.frs.a.auv().a(iVar.getPageContext(), com.baidu.tieba.tbadkCore.s.gZN, this.dFP.getUniqueId(), false);
        this.dKi = new com.baidu.tieba.frs.l(iVar.getPageContext(), com.baidu.tieba.frs.m.dGK);
        this.dKb = new com.baidu.tieba.frs.p(iVar.getPageContext(), as.aNT);
        this.dKg = new d(iVar.getPageContext(), bd.aOG, this.dFP.getUniqueId());
        this.dKh = new d(iVar.getPageContext(), bd.aOH, this.dFP.getUniqueId());
        this.dKe = com.baidu.tieba.frs.a.auv().a(iVar.getPageContext(), bd.aPI, this.dFP.getUniqueId(), true);
        this.dKf = com.baidu.tieba.frs.a.auv().b(iVar.getPageContext(), bd.aPP, this.dFP.getUniqueId());
        this.dKk = new l(iVar.getPageContext(), com.baidu.tieba.frs.r.dGT);
        this.dKl = new h(iVar.getPageContext(), bd.aOI, this.dFP.getUniqueId());
        this.dKm = new o(iVar.getPageContext(), com.baidu.tieba.frs.s.dGZ, this.dFP.getUniqueId());
        this.dKn = new p(iVar.getPageContext().getPageActivity(), com.baidu.tieba.tbadkCore.k.gZC, this.dFP.getUniqueId());
        this.mAdapters.add(this.dKn);
        this.mAdapters.add(this.dJV);
        this.mAdapters.add(this.dJW);
        this.mAdapters.add(this.dJX);
        this.mAdapters.add(this.dJY);
        this.mAdapters.add(this.dKm);
        com.baidu.tieba.InjectPlugin.b.b bVar = new com.baidu.tieba.InjectPlugin.b.b(this.dFP, 1);
        bVar.setExtraData(this.mAdapters);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016515, bVar));
        this.mAdapters.add(this.dJZ);
        this.mAdapters.add(this.dKl);
        if (this.dKa != null) {
            this.mAdapters.add(this.dKa);
        }
        this.mAdapters.add(this.dKi);
        this.mAdapters.add(this.dKc);
        this.mAdapters.add(this.dKd);
        this.mAdapters.add(this.dKb);
        this.mAdapters.add(this.dKg);
        this.mAdapters.add(this.dKh);
        this.mAdapters.add(new w(this.dFP.getPageContext(), x.dHl));
        this.mAdapters.add(this.dKe);
        if (this.dKf != null) {
            this.mAdapters.add(this.dKf);
        }
        this.mAdapters.add(this.dKk);
        this.dKr.setPriority(1);
        this.dKr.setSelfListener(true);
        this.dFP.registerListener(this.dKr);
        this.dFP.registerListener(this.mAttentionListener);
        this.dFP.registerListener(this.mLikeForumListener);
        this.dFP.registerListener(this.mUnlikeForumListener);
        this.dFP.registerListener(this.dKt);
        axk();
        CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2003008, new AbsDelegateAdapterList());
        CustomMessage customMessage = new CustomMessage(2003008);
        customMessage.setTag(this.dFP.getUniqueId());
        customResponsedMessage.setOrginalMessage(customMessage);
        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
        bm(this.mAdapters);
        nVar.addAdapters(this.mAdapters);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aY(Object obj) {
        boolean z;
        boolean z2 = false;
        if (this.aSu != null) {
            Iterator<com.baidu.adp.widget.ListView.i> it = this.aSu.iterator();
            while (true) {
                z = z2;
                if (!it.hasNext()) {
                    break;
                }
                com.baidu.adp.widget.ListView.i next = it.next();
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
    public void aZ(Object obj) {
        if (this.aSu != null) {
            Iterator<com.baidu.adp.widget.ListView.i> it = this.aSu.iterator();
            while (it.hasNext()) {
                com.baidu.adp.widget.ListView.i next = it.next();
                if (next instanceof AdvertAppInfo) {
                    AdvertAppInfo advertAppInfo = (AdvertAppInfo) next;
                    if (advertAppInfo.legoCard != null) {
                        advertAppInfo.legoCard.refreshReservation(obj);
                    }
                }
            }
        }
    }

    private void axk() {
        if (this.dFP != null && !axl()) {
            this.dFP.registerListener(this.dKs);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v5, resolved type: com.baidu.tieba.frs.i */
    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public boolean axl() {
        if (this.dFP == null) {
            return false;
        }
        this.dKj = new ArrayList();
        ArrayList<BdUniqueId> bwj = com.baidu.tieba.tbadkCore.q.bwj();
        if (bwj == null || bwj.size() <= 0) {
            return false;
        }
        int size = bwj.size();
        for (int i = 0; i < size; i++) {
            com.baidu.tieba.frs.g<ICardInfo, ? extends r.a> a = com.baidu.tieba.frs.a.auv().a(this.dFP.getPageContext(), bwj.get(i), this.dFP.getUniqueId());
            if (a != null) {
                this.mAdapters.add(a);
                this.dKj.add(a);
            }
        }
        if (!v.E(this.dKj)) {
            this.dJU.addAdapters(this.dKj);
        }
        return true;
    }

    @Override // com.baidu.tieba.frs.entelechy.a.s
    public void onDestory() {
        for (com.baidu.adp.widget.ListView.a aVar : this.mAdapters) {
            if (aVar instanceof com.baidu.tieba.frs.g) {
                ((com.baidu.tieba.frs.g) aVar).release();
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.a.s
    public void b(ArrayList<com.baidu.adp.widget.ListView.i> arrayList, com.baidu.tieba.tbadkCore.l lVar) {
        b(lVar);
        com.baidu.tieba.tbadkCore.q.r(arrayList, 1);
        L(arrayList);
        M(arrayList);
        K(arrayList);
        this.dJU.setData(arrayList);
        this.dKp = lVar;
        axu();
        axm();
        this.aSu = arrayList;
    }

    private void axm() {
        if (this.dKp != null && this.dKp.bas() != null && !StringUtils.isNull(this.dKp.bas().getId()) && this.dKn != null) {
            this.dKn.setForumId(this.dKp.bas().getId());
        }
    }

    private void K(ArrayList<com.baidu.adp.widget.ListView.i> arrayList) {
        int D = v.D(arrayList);
        for (int i = 0; i < D; i++) {
            com.baidu.adp.widget.ListView.i iVar = (com.baidu.adp.widget.ListView.i) v.f(arrayList, i - 1);
            com.baidu.adp.widget.ListView.i iVar2 = (com.baidu.adp.widget.ListView.i) v.f(arrayList, i);
            if (iVar2 instanceof bd) {
                bd bdVar = (bd) iVar2;
                if (i == 0) {
                    bdVar.isFirstFloor = true;
                } else {
                    bdVar.isFirstFloor = false;
                }
                String zM = bdVar.zM();
                if (iVar instanceof com.baidu.tieba.frs.r) {
                    bdVar.needTopMargin = false;
                } else if (iVar != null && !d(iVar)) {
                    bdVar.needTopMargin = false;
                } else if ((iVar instanceof bd) && d(iVar) && !TextUtils.isEmpty(((bd) iVar).zM())) {
                    bdVar.needTopMargin = true;
                } else if (d(iVar2) && !TextUtils.isEmpty(zM)) {
                    bdVar.needTopMargin = true;
                } else {
                    bdVar.needTopMargin = false;
                }
            }
        }
    }

    private boolean d(com.baidu.adp.widget.ListView.i iVar) {
        if (iVar == null) {
            return false;
        }
        BdUniqueId type = iVar.getType();
        return type == bd.aOu || type == bd.aOw || type == bd.aOx || type == bd.aOC || type == bd.aOI || type == ar.aNQ || type == bd.aOG || type == bd.aOH;
    }

    private ArrayList<Integer> L(ArrayList<com.baidu.adp.widget.ListView.i> arrayList) {
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
            com.baidu.adp.widget.ListView.i iVar = arrayList.get(i2);
            if (iVar instanceof AdvertAppInfo) {
                arrayList2.add(Integer.valueOf(i2));
                if (this.dKo != null && !this.dKo.containsValue(iVar)) {
                    this.dKo.put(Integer.valueOf(i2), (bd) iVar);
                }
            }
            i = i2 + 1;
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.a.s
    public void gd(boolean z) {
        if (this.dKq != z) {
            this.dKq = z;
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.a.s
    public HashMap<Integer, bd> axn() {
        return this.dKo;
    }

    @Override // com.baidu.tieba.frs.entelechy.a.s
    public void axo() {
        List<com.baidu.adp.widget.ListView.i> data;
        if (this.dJU != null && this.dJU.getData() != null && this.dJU.getData().size() != 0 && (data = this.dJU.getData()) != null && data.size() != 0) {
            for (com.baidu.adp.widget.ListView.i iVar : data) {
                if ((iVar instanceof bd) && ((bd) iVar).zi() != 0) {
                    ((bd) iVar).zW();
                }
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.a.s
    public void notifyDataSetChanged() {
        if (this.dJU.getListAdapter() != null) {
            this.dJU.getListAdapter().notifyDataSetChanged();
        }
    }

    public void amD() {
        if (this.aSu != null) {
            this.dJU.setData(this.aSu);
        }
        notifyDataSetChanged();
    }

    @Override // com.baidu.tieba.frs.entelechy.a.s
    public void setFromCDN(boolean z) {
        if (this.mAdapters != null && this.mAdapters.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.mAdapters) {
                if (aVar instanceof com.baidu.tieba.frs.g) {
                    ((com.baidu.tieba.frs.g) aVar).setFromCDN(z);
                }
            }
            if (this.dJV != null) {
                this.dJV.setFromCDN(z);
            }
            if (this.dJY != null) {
                this.dJY.setFromCDN(z);
            }
            if (this.dKg != null) {
                this.dKg.setFromCDN(z);
            }
            if (this.dKh != null) {
                this.dKh.setFromCDN(z);
            }
        }
    }

    public void b(com.baidu.tieba.tbadkCore.l lVar) {
        if (this.mAdapters != null && this.mAdapters.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.mAdapters) {
                if (aVar instanceof com.baidu.tieba.frs.g) {
                    ((com.baidu.tieba.frs.g) aVar).b(lVar);
                }
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.a.s
    public void a(com.baidu.tieba.frs.b bVar) {
        if (this.mAdapters != null && this.mAdapters.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.mAdapters) {
                if (aVar instanceof com.baidu.tieba.frs.g) {
                    ((com.baidu.tieba.frs.g) aVar).a(bVar);
                }
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.a.s
    public int axp() {
        if (this.dKa != null) {
            return d.g.frs_fortune_bag_item;
        }
        return 0;
    }

    @Override // com.baidu.tieba.frs.entelechy.a.s
    public int axq() {
        if (this.dKa != null) {
            return d.g.frs_my_service_item;
        }
        return 0;
    }

    @Override // com.baidu.tieba.frs.entelechy.a.s
    public int axr() {
        if (this.dKa != null) {
            return d.g.frs_bawu_center;
        }
        return 0;
    }

    @Override // com.baidu.tieba.frs.entelechy.a.s
    public int axs() {
        if (this.dKb != null) {
            return this.dKb.awg();
        }
        return 0;
    }

    @Override // com.baidu.tieba.frs.entelechy.a.s
    public int awh() {
        if (this.dKb != null) {
            return this.dKb.awh();
        }
        return 0;
    }

    @Override // com.baidu.tieba.frs.entelechy.a.s
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

    @Override // com.baidu.tieba.frs.entelechy.a.s
    public void setOnAdapterItemClickListener(com.baidu.adp.widget.ListView.o oVar) {
        if (this.mAdapters != null && this.mAdapters.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.mAdapters) {
                if (aVar instanceof com.baidu.tieba.frs.g) {
                    ((com.baidu.tieba.frs.g) aVar).setOnAdapterItemClickListener(oVar);
                } else if ((aVar instanceof k) || (aVar instanceof c) || (aVar instanceof f) || (aVar instanceof d) || (aVar instanceof r)) {
                    aVar.setOnAdapterItemClickListener(oVar);
                }
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.a.s
    public void setForumName(String str) {
        if (this.mAdapters != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.mAdapters) {
                if (aVar instanceof t) {
                    ((t) aVar).setForumName(str);
                }
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v1, resolved type: com.baidu.tieba.frs.i */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.baidu.tieba.frs.entelechy.a.s
    public void axt() {
        if (this.mAdapters != null && this.mAdapters.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.mAdapters) {
                if (aVar instanceof com.baidu.tieba.frs.g) {
                    ((com.baidu.tieba.frs.g) aVar).a(this.dFP.getPageContext(), this.dFP.getUniqueId());
                }
            }
            bm(this.mAdapters);
        }
    }

    private void axu() {
        if (this.dKp != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.mAdapters) {
                if (aVar instanceof com.baidu.tieba.frs.e.c) {
                    com.baidu.tieba.frs.e.c cVar = (com.baidu.tieba.frs.e.c) aVar;
                    if (com.baidu.tieba.frs.e.c.dUq != null) {
                        if (this.dKp.gYp == 1) {
                            com.baidu.tieba.frs.e.c.dUq.dUe = true;
                        } else {
                            com.baidu.tieba.frs.e.c.dUq.dUe = false;
                        }
                        if (this.dKp.bas() != null) {
                            com.baidu.tieba.frs.e.c.dUq.dUg = this.dKp.bas().getId();
                        }
                        if (this.dFP != null && this.dFP.auO() != null) {
                            com.baidu.tieba.frs.e.c.dUq.dUf = this.dFP.auO().azx();
                        }
                    }
                }
            }
            axv();
        }
    }

    private void axv() {
        com.baidu.tieba.frs.e.a aVar = new com.baidu.tieba.frs.e.a();
        if (this.dKp.gYp == 1) {
            aVar.dUe = true;
        } else {
            aVar.dUe = false;
        }
        if (this.dKp.bas() != null) {
            aVar.dUg = this.dKp.bas().getId();
        }
        if (this.dFP != null && this.dFP.auO() != null) {
            aVar.dUf = this.dFP.auO().azx();
        }
        if (com.baidu.tieba.frs.e.c.dUq != null) {
            aVar.dUh = com.baidu.tieba.frs.e.c.dUq.dUh;
            aVar.dUi = com.baidu.tieba.frs.e.c.dUq.dUi;
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

    @Override // com.baidu.tieba.frs.entelechy.a.s
    public List<com.baidu.adp.widget.ListView.i> getDatas() {
        if (this.dJU != null) {
            return this.dJU.getData();
        }
        return null;
    }

    private void M(ArrayList<com.baidu.adp.widget.ListView.i> arrayList) {
        int i;
        if (this.mAdapters != null && this.mAdapters.size() != 0) {
            int i2 = 0;
            if (arrayList == null || arrayList.size() <= 0) {
                i = 0;
            } else {
                Iterator<com.baidu.adp.widget.ListView.i> it = arrayList.iterator();
                while (true) {
                    i = i2;
                    if (!it.hasNext() || it.next().getType().getId() != bd.aOt.getId()) {
                        break;
                    }
                    i2 = i + 1;
                }
            }
            for (com.baidu.adp.widget.ListView.a aVar : this.mAdapters) {
                if (aVar instanceof com.baidu.tieba.frs.g) {
                    ((com.baidu.tieba.frs.g) aVar).mM(i);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bm(List<com.baidu.adp.widget.ListView.a> list) {
        if (list != null) {
            for (com.baidu.adp.widget.ListView.a aVar : list) {
                if (aVar instanceof com.baidu.tieba.frs.g) {
                    ((com.baidu.tieba.frs.g) aVar).a(this.dEf);
                }
            }
        }
    }

    public void setCardShowType(int i) {
        if (this.mAdapters != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.mAdapters) {
                if (aVar instanceof u) {
                    ((u) aVar).setCardShowType(i);
                }
            }
        }
    }
}
