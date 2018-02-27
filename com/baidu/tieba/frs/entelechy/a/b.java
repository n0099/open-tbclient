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
    private ArrayList<com.baidu.adp.widget.ListView.i> aSj;
    private com.baidu.tieba.frs.i dFD;
    private com.baidu.adp.widget.ListView.n dJI;
    private k dJJ;
    private i dJK;
    private n dJL;
    private k dJM;
    private c dJN;
    private com.baidu.adp.widget.ListView.a dJO;
    private com.baidu.tieba.frs.p dJP;
    private r dJQ;
    private g dJR;
    private com.baidu.adp.widget.ListView.a dJS;
    private com.baidu.adp.widget.ListView.a dJT;
    private d dJU;
    private d dJV;
    private com.baidu.tieba.frs.l dJW;
    private List<com.baidu.adp.widget.ListView.a> dJX;
    private l dJY;
    private h dJZ;
    private o dKa;
    private p dKb;
    private final HashMap<Integer, bd> dKc;
    private com.baidu.tieba.tbadkCore.l dKd;
    private List<com.baidu.adp.widget.ListView.a> mAdapters = new LinkedList();
    private boolean dKe = false;
    private CustomMessageListener dKf = new CustomMessageListener(2003008) { // from class: com.baidu.tieba.frs.entelechy.a.b.1
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
                        ((com.baidu.tieba.frs.g) aVar).a(b.this.dFD.getPageContext(), b.this.dFD.getUniqueId());
                    }
                }
                ArrayList arrayList = new ArrayList();
                arrayList.addAll(absDelegateAdapterList);
                b.this.bm(arrayList);
                if (b.this.mAdapters != null) {
                    b.this.mAdapters.addAll(absDelegateAdapterList);
                }
                if (b.this.dJI != null) {
                    b.this.mAdapters.addAll(arrayList);
                    b.this.dJI.addAdapters(arrayList);
                }
            }
        }
    };
    private CustomMessageListener dKg = new CustomMessageListener(2016470) { // from class: com.baidu.tieba.frs.entelechy.a.b.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && v.E(b.this.dJX)) {
                b.this.axk();
                b.this.b(b.this.aSj, b.this.dKd);
            }
        }
    };
    private CustomMessageListener mAttentionListener = new CustomMessageListener(2001115) { // from class: com.baidu.tieba.frs.entelechy.a.b.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
            if (updateAttentionMessage != null && updateAttentionMessage.getData() != null && updateAttentionMessage.getData().apG) {
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
                bVar.feC = true;
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
                bVar.feC = false;
                b.this.aY(bVar);
            }
        }
    };
    private CustomMessageListener dKh = new CustomMessageListener(2016492) { // from class: com.baidu.tieba.frs.entelechy.a.b.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.data.g)) {
                b.this.aZ((com.baidu.tbadk.data.g) customResponsedMessage.getData());
            }
        }
    };
    private final com.baidu.tieba.frs.e dDT = new com.baidu.tieba.frs.e();

    public b(com.baidu.tieba.frs.i iVar, com.baidu.adp.widget.ListView.n nVar, boolean z) {
        this.dJI = nVar;
        a(iVar, nVar);
        this.dKc = new HashMap<>();
        gd(z);
    }

    public void a(com.baidu.tieba.frs.i iVar, com.baidu.adp.widget.ListView.n nVar) {
        this.dFD = iVar;
        this.dJJ = new k(iVar.getPageContext(), bd.aOj, this.dFD.getUniqueId());
        this.dJJ.setVoiceManager(iVar.getVoiceManager());
        this.dJK = new i(iVar.getPageContext(), bd.aOk, this.dFD.getUniqueId());
        this.dJL = new n(iVar.getPageContext(), bd.aOq, this.dFD.getUniqueId());
        this.dJM = new k(iVar.getPageContext(), bd.aOl, this.dFD.getUniqueId());
        this.dJM.setVoiceManager(iVar.getVoiceManager());
        this.dJQ = new r(iVar.getPageContext(), bd.aOm, this.dFD.getUniqueId());
        this.dJR = new g(iVar.getPageContext(), bd.aOr, this.dFD.getUniqueId());
        this.dJN = new c(iVar.getPageContext(), ar.aNF, this.dFD.getUniqueId());
        this.dJO = com.baidu.tieba.frs.a.auu().a(iVar.getPageContext(), com.baidu.tieba.tbadkCore.s.gZy, this.dFD.getUniqueId(), false);
        this.dJW = new com.baidu.tieba.frs.l(iVar.getPageContext(), com.baidu.tieba.frs.m.dGy);
        this.dJP = new com.baidu.tieba.frs.p(iVar.getPageContext(), as.aNI);
        this.dJU = new d(iVar.getPageContext(), bd.aOv, this.dFD.getUniqueId());
        this.dJV = new d(iVar.getPageContext(), bd.aOw, this.dFD.getUniqueId());
        this.dJS = com.baidu.tieba.frs.a.auu().a(iVar.getPageContext(), bd.aPx, this.dFD.getUniqueId(), true);
        this.dJT = com.baidu.tieba.frs.a.auu().b(iVar.getPageContext(), bd.aPE, this.dFD.getUniqueId());
        this.dJY = new l(iVar.getPageContext(), com.baidu.tieba.frs.r.dGH);
        this.dJZ = new h(iVar.getPageContext(), bd.aOx, this.dFD.getUniqueId());
        this.dKa = new o(iVar.getPageContext(), com.baidu.tieba.frs.s.dGN, this.dFD.getUniqueId());
        this.dKb = new p(iVar.getPageContext().getPageActivity(), com.baidu.tieba.tbadkCore.k.gZn, this.dFD.getUniqueId());
        this.mAdapters.add(this.dKb);
        this.mAdapters.add(this.dJJ);
        this.mAdapters.add(this.dJK);
        this.mAdapters.add(this.dJL);
        this.mAdapters.add(this.dJM);
        this.mAdapters.add(this.dKa);
        com.baidu.tieba.InjectPlugin.b.b bVar = new com.baidu.tieba.InjectPlugin.b.b(this.dFD, 1);
        bVar.setExtraData(this.mAdapters);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016515, bVar));
        this.mAdapters.add(this.dJN);
        this.mAdapters.add(this.dJZ);
        if (this.dJO != null) {
            this.mAdapters.add(this.dJO);
        }
        this.mAdapters.add(this.dJW);
        this.mAdapters.add(this.dJQ);
        this.mAdapters.add(this.dJR);
        this.mAdapters.add(this.dJP);
        this.mAdapters.add(this.dJU);
        this.mAdapters.add(this.dJV);
        this.mAdapters.add(new w(this.dFD.getPageContext(), x.dGZ));
        this.mAdapters.add(this.dJS);
        if (this.dJT != null) {
            this.mAdapters.add(this.dJT);
        }
        this.mAdapters.add(this.dJY);
        this.dKf.setPriority(1);
        this.dKf.setSelfListener(true);
        this.dFD.registerListener(this.dKf);
        this.dFD.registerListener(this.mAttentionListener);
        this.dFD.registerListener(this.mLikeForumListener);
        this.dFD.registerListener(this.mUnlikeForumListener);
        this.dFD.registerListener(this.dKh);
        axj();
        CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2003008, new AbsDelegateAdapterList());
        CustomMessage customMessage = new CustomMessage(2003008);
        customMessage.setTag(this.dFD.getUniqueId());
        customResponsedMessage.setOrginalMessage(customMessage);
        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
        bm(this.mAdapters);
        nVar.addAdapters(this.mAdapters);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aY(Object obj) {
        boolean z;
        boolean z2 = false;
        if (this.aSj != null) {
            Iterator<com.baidu.adp.widget.ListView.i> it = this.aSj.iterator();
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
        if (this.aSj != null) {
            Iterator<com.baidu.adp.widget.ListView.i> it = this.aSj.iterator();
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

    private void axj() {
        if (this.dFD != null && !axk()) {
            this.dFD.registerListener(this.dKg);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v5, resolved type: com.baidu.tieba.frs.i */
    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public boolean axk() {
        if (this.dFD == null) {
            return false;
        }
        this.dJX = new ArrayList();
        ArrayList<BdUniqueId> bwi = com.baidu.tieba.tbadkCore.q.bwi();
        if (bwi == null || bwi.size() <= 0) {
            return false;
        }
        int size = bwi.size();
        for (int i = 0; i < size; i++) {
            com.baidu.tieba.frs.g<ICardInfo, ? extends r.a> a = com.baidu.tieba.frs.a.auu().a(this.dFD.getPageContext(), bwi.get(i), this.dFD.getUniqueId());
            if (a != null) {
                this.mAdapters.add(a);
                this.dJX.add(a);
            }
        }
        if (!v.E(this.dJX)) {
            this.dJI.addAdapters(this.dJX);
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
        this.dJI.setData(arrayList);
        this.dKd = lVar;
        axt();
        axl();
        this.aSj = arrayList;
    }

    private void axl() {
        if (this.dKd != null && this.dKd.bar() != null && !StringUtils.isNull(this.dKd.bar().getId()) && this.dKb != null) {
            this.dKb.setForumId(this.dKd.bar().getId());
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
        return type == bd.aOj || type == bd.aOl || type == bd.aOm || type == bd.aOr || type == bd.aOx || type == ar.aNF || type == bd.aOv || type == bd.aOw;
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
                if (this.dKc != null && !this.dKc.containsValue(iVar)) {
                    this.dKc.put(Integer.valueOf(i2), (bd) iVar);
                }
            }
            i = i2 + 1;
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.a.s
    public void gd(boolean z) {
        if (this.dKe != z) {
            this.dKe = z;
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.a.s
    public HashMap<Integer, bd> axm() {
        return this.dKc;
    }

    @Override // com.baidu.tieba.frs.entelechy.a.s
    public void axn() {
        List<com.baidu.adp.widget.ListView.i> data;
        if (this.dJI != null && this.dJI.getData() != null && this.dJI.getData().size() != 0 && (data = this.dJI.getData()) != null && data.size() != 0) {
            for (com.baidu.adp.widget.ListView.i iVar : data) {
                if ((iVar instanceof bd) && ((bd) iVar).zi() != 0) {
                    ((bd) iVar).zW();
                }
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.a.s
    public void notifyDataSetChanged() {
        if (this.dJI.getListAdapter() != null) {
            this.dJI.getListAdapter().notifyDataSetChanged();
        }
    }

    public void amC() {
        if (this.aSj != null) {
            this.dJI.setData(this.aSj);
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
            if (this.dJJ != null) {
                this.dJJ.setFromCDN(z);
            }
            if (this.dJM != null) {
                this.dJM.setFromCDN(z);
            }
            if (this.dJU != null) {
                this.dJU.setFromCDN(z);
            }
            if (this.dJV != null) {
                this.dJV.setFromCDN(z);
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
    public int axo() {
        if (this.dJO != null) {
            return d.g.frs_fortune_bag_item;
        }
        return 0;
    }

    @Override // com.baidu.tieba.frs.entelechy.a.s
    public int axp() {
        if (this.dJO != null) {
            return d.g.frs_my_service_item;
        }
        return 0;
    }

    @Override // com.baidu.tieba.frs.entelechy.a.s
    public int axq() {
        if (this.dJO != null) {
            return d.g.frs_bawu_center;
        }
        return 0;
    }

    @Override // com.baidu.tieba.frs.entelechy.a.s
    public int axr() {
        if (this.dJP != null) {
            return this.dJP.awf();
        }
        return 0;
    }

    @Override // com.baidu.tieba.frs.entelechy.a.s
    public int awg() {
        if (this.dJP != null) {
            return this.dJP.awg();
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
    public void axs() {
        if (this.mAdapters != null && this.mAdapters.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.mAdapters) {
                if (aVar instanceof com.baidu.tieba.frs.g) {
                    ((com.baidu.tieba.frs.g) aVar).a(this.dFD.getPageContext(), this.dFD.getUniqueId());
                }
            }
            bm(this.mAdapters);
        }
    }

    private void axt() {
        if (this.dKd != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.mAdapters) {
                if (aVar instanceof com.baidu.tieba.frs.e.c) {
                    com.baidu.tieba.frs.e.c cVar = (com.baidu.tieba.frs.e.c) aVar;
                    if (com.baidu.tieba.frs.e.c.dUe != null) {
                        if (this.dKd.gYa == 1) {
                            com.baidu.tieba.frs.e.c.dUe.dTS = true;
                        } else {
                            com.baidu.tieba.frs.e.c.dUe.dTS = false;
                        }
                        if (this.dKd.bar() != null) {
                            com.baidu.tieba.frs.e.c.dUe.dTU = this.dKd.bar().getId();
                        }
                        if (this.dFD != null && this.dFD.auN() != null) {
                            com.baidu.tieba.frs.e.c.dUe.dTT = this.dFD.auN().azw();
                        }
                    }
                }
            }
            axu();
        }
    }

    private void axu() {
        com.baidu.tieba.frs.e.a aVar = new com.baidu.tieba.frs.e.a();
        if (this.dKd.gYa == 1) {
            aVar.dTS = true;
        } else {
            aVar.dTS = false;
        }
        if (this.dKd.bar() != null) {
            aVar.dTU = this.dKd.bar().getId();
        }
        if (this.dFD != null && this.dFD.auN() != null) {
            aVar.dTT = this.dFD.auN().azw();
        }
        if (com.baidu.tieba.frs.e.c.dUe != null) {
            aVar.dTV = com.baidu.tieba.frs.e.c.dUe.dTV;
            aVar.dTW = com.baidu.tieba.frs.e.c.dUe.dTW;
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
        if (this.dJI != null) {
            return this.dJI.getData();
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
                    if (!it.hasNext() || it.next().getType().getId() != bd.aOi.getId()) {
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
                    ((com.baidu.tieba.frs.g) aVar).a(this.dDT);
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
