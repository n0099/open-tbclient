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
import com.baidu.tieba.card.u;
import com.baidu.tieba.d;
import com.baidu.tieba.frs.AbsDelegateAdapterList;
import com.baidu.tieba.frs.w;
import com.baidu.tieba.frs.x;
import com.baidu.tieba.lego.card.model.ICardInfo;
import com.baidu.tieba.tbadkCore.t;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes2.dex */
public class b implements s {
    private ArrayList<com.baidu.adp.widget.ListView.i> aSl;
    private com.baidu.tieba.frs.i dFH;
    private com.baidu.adp.widget.ListView.n dJN;
    private k dJO;
    private i dJP;
    private n dJQ;
    private k dJR;
    private c dJS;
    private com.baidu.adp.widget.ListView.a dJT;
    private com.baidu.tieba.frs.p dJU;
    private r dJV;
    private g dJW;
    private com.baidu.adp.widget.ListView.a dJX;
    private com.baidu.adp.widget.ListView.a dJY;
    private d dJZ;
    private d dKa;
    private com.baidu.tieba.frs.l dKb;
    private List<com.baidu.adp.widget.ListView.a> dKc;
    private l dKd;
    private h dKe;
    private o dKf;
    private p dKg;
    private final HashMap<Integer, bd> dKh;
    private com.baidu.tieba.tbadkCore.m dKi;
    private List<com.baidu.adp.widget.ListView.a> mAdapters = new LinkedList();
    private boolean dKj = false;
    private CustomMessageListener dKk = new CustomMessageListener(2003008) { // from class: com.baidu.tieba.frs.entelechy.a.b.1
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
                        ((com.baidu.tieba.frs.g) aVar).a(b.this.dFH.getPageContext(), b.this.dFH.getUniqueId());
                    }
                }
                ArrayList arrayList = new ArrayList();
                arrayList.addAll(absDelegateAdapterList);
                b.this.bm(arrayList);
                if (b.this.mAdapters != null) {
                    b.this.mAdapters.addAll(absDelegateAdapterList);
                }
                if (b.this.dJN != null) {
                    b.this.mAdapters.addAll(arrayList);
                    b.this.dJN.addAdapters(arrayList);
                }
            }
        }
    };
    private CustomMessageListener dKl = new CustomMessageListener(2016470) { // from class: com.baidu.tieba.frs.entelechy.a.b.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && v.E(b.this.dKc)) {
                b.this.axm();
                b.this.b(b.this.aSl, b.this.dKi);
            }
        }
    };
    private CustomMessageListener mAttentionListener = new CustomMessageListener(2001115) { // from class: com.baidu.tieba.frs.entelechy.a.b.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
            if (updateAttentionMessage != null && updateAttentionMessage.getData() != null && updateAttentionMessage.getData().apH) {
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
                bVar.feQ = true;
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
                bVar.feQ = false;
                b.this.aY(bVar);
            }
        }
    };
    private CustomMessageListener dKm = new CustomMessageListener(2016492) { // from class: com.baidu.tieba.frs.entelechy.a.b.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.data.g)) {
                b.this.aZ((com.baidu.tbadk.data.g) customResponsedMessage.getData());
            }
        }
    };
    private final com.baidu.tieba.frs.e dDW = new com.baidu.tieba.frs.e();

    public b(com.baidu.tieba.frs.i iVar, com.baidu.adp.widget.ListView.n nVar, boolean z) {
        this.dJN = nVar;
        a(iVar, nVar);
        this.dKh = new HashMap<>();
        gd(z);
    }

    public void a(com.baidu.tieba.frs.i iVar, com.baidu.adp.widget.ListView.n nVar) {
        this.dFH = iVar;
        this.dJO = new k(iVar.getPageContext(), bd.aOk, this.dFH.getUniqueId());
        this.dJO.setVoiceManager(iVar.getVoiceManager());
        this.dJP = new i(iVar.getPageContext(), bd.aOl, this.dFH.getUniqueId());
        this.dJQ = new n(iVar.getPageContext(), bd.aOr, this.dFH.getUniqueId());
        this.dJR = new k(iVar.getPageContext(), bd.aOm, this.dFH.getUniqueId());
        this.dJR.setVoiceManager(iVar.getVoiceManager());
        this.dJV = new r(iVar.getPageContext(), bd.aOn, this.dFH.getUniqueId());
        this.dJW = new g(iVar.getPageContext(), bd.aOs, this.dFH.getUniqueId());
        this.dJS = new c(iVar.getPageContext(), ar.aNG, this.dFH.getUniqueId());
        this.dJT = com.baidu.tieba.frs.a.auv().a(iVar.getPageContext(), t.gZV, this.dFH.getUniqueId(), false);
        this.dKb = new com.baidu.tieba.frs.l(iVar.getPageContext(), com.baidu.tieba.frs.m.dGD);
        this.dJU = new com.baidu.tieba.frs.p(iVar.getPageContext(), as.aNJ);
        this.dJZ = new d(iVar.getPageContext(), bd.aOw, this.dFH.getUniqueId());
        this.dKa = new d(iVar.getPageContext(), bd.aOx, this.dFH.getUniqueId());
        this.dJX = com.baidu.tieba.frs.a.auv().a(iVar.getPageContext(), bd.aPy, this.dFH.getUniqueId(), true);
        this.dJY = com.baidu.tieba.frs.a.auv().b(iVar.getPageContext(), bd.aPF, this.dFH.getUniqueId());
        this.dKd = new l(iVar.getPageContext(), com.baidu.tieba.frs.r.dGM);
        this.dKe = new h(iVar.getPageContext(), bd.aOy, this.dFH.getUniqueId());
        this.dKf = new o(iVar.getPageContext(), com.baidu.tieba.frs.s.dGS, this.dFH.getUniqueId());
        this.dKg = new p(iVar.getPageContext().getPageActivity(), com.baidu.tieba.tbadkCore.l.gZK, this.dFH.getUniqueId());
        this.mAdapters.add(this.dKg);
        this.mAdapters.add(this.dJO);
        this.mAdapters.add(this.dJP);
        this.mAdapters.add(this.dJQ);
        this.mAdapters.add(this.dJR);
        this.mAdapters.add(this.dKf);
        com.baidu.tieba.InjectPlugin.b.b bVar = new com.baidu.tieba.InjectPlugin.b.b(this.dFH, 1);
        bVar.setExtraData(this.mAdapters);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016515, bVar));
        this.mAdapters.add(this.dJS);
        this.mAdapters.add(this.dKe);
        if (this.dJT != null) {
            this.mAdapters.add(this.dJT);
        }
        this.mAdapters.add(this.dKb);
        this.mAdapters.add(this.dJV);
        this.mAdapters.add(this.dJW);
        this.mAdapters.add(this.dJU);
        this.mAdapters.add(this.dJZ);
        this.mAdapters.add(this.dKa);
        this.mAdapters.add(new w(this.dFH.getPageContext(), x.dHe));
        this.mAdapters.add(this.dJX);
        if (this.dJY != null) {
            this.mAdapters.add(this.dJY);
        }
        this.mAdapters.add(this.dKd);
        this.dKk.setPriority(1);
        this.dKk.setSelfListener(true);
        this.dFH.registerListener(this.dKk);
        this.dFH.registerListener(this.mAttentionListener);
        this.dFH.registerListener(this.mLikeForumListener);
        this.dFH.registerListener(this.mUnlikeForumListener);
        this.dFH.registerListener(this.dKm);
        axl();
        CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2003008, new AbsDelegateAdapterList());
        CustomMessage customMessage = new CustomMessage(2003008);
        customMessage.setTag(this.dFH.getUniqueId());
        customResponsedMessage.setOrginalMessage(customMessage);
        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
        bm(this.mAdapters);
        nVar.addAdapters(this.mAdapters);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aY(Object obj) {
        boolean z;
        boolean z2 = false;
        if (this.aSl != null) {
            Iterator<com.baidu.adp.widget.ListView.i> it = this.aSl.iterator();
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
        if (this.aSl != null) {
            Iterator<com.baidu.adp.widget.ListView.i> it = this.aSl.iterator();
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

    private void axl() {
        if (this.dFH != null && !axm()) {
            this.dFH.registerListener(this.dKl);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v5, resolved type: com.baidu.tieba.frs.i */
    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public boolean axm() {
        if (this.dFH == null) {
            return false;
        }
        this.dKc = new ArrayList();
        ArrayList<BdUniqueId> bwn = com.baidu.tieba.tbadkCore.r.bwn();
        if (bwn == null || bwn.size() <= 0) {
            return false;
        }
        int size = bwn.size();
        for (int i = 0; i < size; i++) {
            com.baidu.tieba.frs.g<ICardInfo, ? extends r.a> a = com.baidu.tieba.frs.a.auv().a(this.dFH.getPageContext(), bwn.get(i), this.dFH.getUniqueId());
            if (a != null) {
                this.mAdapters.add(a);
                this.dKc.add(a);
            }
        }
        if (!v.E(this.dKc)) {
            this.dJN.addAdapters(this.dKc);
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
    public void b(ArrayList<com.baidu.adp.widget.ListView.i> arrayList, com.baidu.tieba.tbadkCore.m mVar) {
        b(mVar);
        com.baidu.tieba.tbadkCore.r.r(arrayList, 1);
        L(arrayList);
        M(arrayList);
        K(arrayList);
        this.dJN.setData(arrayList);
        this.dKi = mVar;
        axv();
        axn();
        this.aSl = arrayList;
    }

    private void axn() {
        if (this.dKi != null && this.dKi.bas() != null && !StringUtils.isNull(this.dKi.bas().getId()) && this.dKg != null) {
            this.dKg.setForumId(this.dKi.bas().getId());
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
        return type == bd.aOk || type == bd.aOm || type == bd.aOn || type == bd.aOs || type == bd.aOy || type == ar.aNG || type == bd.aOw || type == bd.aOx;
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
                if (this.dKh != null && !this.dKh.containsValue(iVar)) {
                    this.dKh.put(Integer.valueOf(i2), (bd) iVar);
                }
            }
            i = i2 + 1;
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.a.s
    public void gd(boolean z) {
        if (this.dKj != z) {
            this.dKj = z;
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.a.s
    public HashMap<Integer, bd> axo() {
        return this.dKh;
    }

    @Override // com.baidu.tieba.frs.entelechy.a.s
    public void axp() {
        List<com.baidu.adp.widget.ListView.i> data;
        if (this.dJN != null && this.dJN.getData() != null && this.dJN.getData().size() != 0 && (data = this.dJN.getData()) != null && data.size() != 0) {
            for (com.baidu.adp.widget.ListView.i iVar : data) {
                if ((iVar instanceof bd) && ((bd) iVar).zi() != 0) {
                    ((bd) iVar).zW();
                }
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.a.s
    public void notifyDataSetChanged() {
        if (this.dJN.getListAdapter() != null) {
            this.dJN.getListAdapter().notifyDataSetChanged();
        }
    }

    public void amD() {
        if (this.aSl != null) {
            this.dJN.setData(this.aSl);
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
            if (this.dJO != null) {
                this.dJO.setFromCDN(z);
            }
            if (this.dJR != null) {
                this.dJR.setFromCDN(z);
            }
            if (this.dJZ != null) {
                this.dJZ.setFromCDN(z);
            }
            if (this.dKa != null) {
                this.dKa.setFromCDN(z);
            }
        }
    }

    public void b(com.baidu.tieba.tbadkCore.m mVar) {
        if (this.mAdapters != null && this.mAdapters.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.mAdapters) {
                if (aVar instanceof com.baidu.tieba.frs.g) {
                    ((com.baidu.tieba.frs.g) aVar).b(mVar);
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
    public int axq() {
        if (this.dJT != null) {
            return d.g.frs_fortune_bag_item;
        }
        return 0;
    }

    @Override // com.baidu.tieba.frs.entelechy.a.s
    public int axr() {
        if (this.dJT != null) {
            return d.g.frs_my_service_item;
        }
        return 0;
    }

    @Override // com.baidu.tieba.frs.entelechy.a.s
    public int axs() {
        if (this.dJT != null) {
            return d.g.frs_bawu_center;
        }
        return 0;
    }

    @Override // com.baidu.tieba.frs.entelechy.a.s
    public int axt() {
        if (this.dJU != null) {
            return this.dJU.awh();
        }
        return 0;
    }

    @Override // com.baidu.tieba.frs.entelechy.a.s
    public int awi() {
        if (this.dJU != null) {
            return this.dJU.awi();
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
                if (aVar instanceof com.baidu.tieba.card.t) {
                    ((com.baidu.tieba.card.t) aVar).setForumName(str);
                }
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v1, resolved type: com.baidu.tieba.frs.i */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.baidu.tieba.frs.entelechy.a.s
    public void axu() {
        if (this.mAdapters != null && this.mAdapters.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.mAdapters) {
                if (aVar instanceof com.baidu.tieba.frs.g) {
                    ((com.baidu.tieba.frs.g) aVar).a(this.dFH.getPageContext(), this.dFH.getUniqueId());
                }
            }
            bm(this.mAdapters);
        }
    }

    private void axv() {
        if (this.dKi != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.mAdapters) {
                if (aVar instanceof com.baidu.tieba.frs.e.c) {
                    com.baidu.tieba.frs.e.c cVar = (com.baidu.tieba.frs.e.c) aVar;
                    if (com.baidu.tieba.frs.e.c.dUj != null) {
                        if (this.dKi.gYv == 1) {
                            com.baidu.tieba.frs.e.c.dUj.dTX = true;
                        } else {
                            com.baidu.tieba.frs.e.c.dUj.dTX = false;
                        }
                        if (this.dKi.bas() != null) {
                            com.baidu.tieba.frs.e.c.dUj.dTZ = this.dKi.bas().getId();
                        }
                        if (this.dFH != null && this.dFH.auO() != null) {
                            com.baidu.tieba.frs.e.c.dUj.dTY = this.dFH.auO().azy();
                        }
                    }
                }
            }
            axw();
        }
    }

    private void axw() {
        com.baidu.tieba.frs.e.a aVar = new com.baidu.tieba.frs.e.a();
        if (this.dKi.gYv == 1) {
            aVar.dTX = true;
        } else {
            aVar.dTX = false;
        }
        if (this.dKi.bas() != null) {
            aVar.dTZ = this.dKi.bas().getId();
        }
        if (this.dFH != null && this.dFH.auO() != null) {
            aVar.dTY = this.dFH.auO().azy();
        }
        if (com.baidu.tieba.frs.e.c.dUj != null) {
            aVar.dUa = com.baidu.tieba.frs.e.c.dUj.dUa;
            aVar.dUb = com.baidu.tieba.frs.e.c.dUj.dUb;
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
        if (this.dJN != null) {
            return this.dJN.getData();
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
                    if (!it.hasNext() || it.next().getType().getId() != bd.aOj.getId()) {
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
                    ((com.baidu.tieba.frs.g) aVar).a(this.dDW);
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
