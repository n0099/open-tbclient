package com.baidu.tieba.frs.entelechy.a;

import android.text.TextUtils;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.n;
import com.baidu.adp.widget.ListView.o;
import com.baidu.adp.widget.ListView.r;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.data.ar;
import com.baidu.tbadk.core.data.as;
import com.baidu.tbadk.core.data.bd;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.coreExtra.message.UpdateAttentionMessage;
import com.baidu.tieba.card.data.CardHListViewData;
import com.baidu.tieba.d;
import com.baidu.tieba.frs.AbsDelegateAdapterList;
import com.baidu.tieba.frs.e;
import com.baidu.tieba.frs.w;
import com.baidu.tieba.frs.x;
import com.baidu.tieba.lego.card.model.ICardInfo;
import com.baidu.tieba.tbadkCore.k;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes2.dex */
public class b implements u {
    private ArrayList<com.baidu.adp.widget.ListView.i> aQQ;
    private com.baidu.tieba.frs.i dCS;
    private n dGN;
    private l dGO;
    private j dGP;
    private p dGQ;
    private l dGR;
    private c dGS;
    private com.baidu.adp.widget.ListView.a dGT;
    private com.baidu.tieba.frs.p dGU;
    private t dGV;
    private g dGW;
    private com.baidu.adp.widget.ListView.a dGX;
    private com.baidu.adp.widget.ListView.a dGY;
    private d dGZ;
    private d dHa;
    private com.baidu.tieba.frs.l dHb;
    private List<com.baidu.adp.widget.ListView.a> dHc;
    private m dHd;
    private i dHe;
    private h dHf;
    private q dHg;
    private r dHh;
    private final HashMap<Integer, bd> dHi;
    private com.baidu.tieba.tbadkCore.l dHj;
    private List<com.baidu.adp.widget.ListView.a> mAdapters = new LinkedList();
    private boolean dHk = false;
    private CustomMessageListener dHl = new CustomMessageListener(CmdConfigCustom.CMD_FRS_ADD_ADAPTER) { // from class: com.baidu.tieba.frs.entelechy.a.b.1
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
                        ((com.baidu.tieba.frs.g) aVar).a(b.this.dCS.getPageContext(), b.this.dCS.getUniqueId());
                    }
                }
                ArrayList arrayList = new ArrayList();
                arrayList.addAll(absDelegateAdapterList);
                b.this.bk(arrayList);
                if (b.this.mAdapters != null) {
                    b.this.mAdapters.addAll(absDelegateAdapterList);
                }
                if (b.this.dGN != null) {
                    b.this.mAdapters.addAll(arrayList);
                    b.this.dGN.addAdapters(arrayList);
                }
            }
        }
    };
    private CustomMessageListener dHm = new CustomMessageListener(CmdConfigCustom.CMD_LEGO_REGISTER) { // from class: com.baidu.tieba.frs.entelechy.a.b.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && v.E(b.this.dHc)) {
                b.this.awm();
                b.this.b(b.this.aQQ, b.this.dHj);
            }
        }
    };
    private CustomMessageListener mAttentionListener = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.frs.entelechy.a.b.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
            if (updateAttentionMessage != null && updateAttentionMessage.getData() != null && updateAttentionMessage.getData().apQ) {
                b.this.aW(updateAttentionMessage.getData());
            }
        }
    };
    private CustomMessageListener mLikeForumListener = new CustomMessageListener(CmdConfigCustom.CMD_LIKE_FORUM) { // from class: com.baidu.tieba.frs.entelechy.a.b.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                com.baidu.tieba.lego.c.b bVar = new com.baidu.tieba.lego.c.b();
                bVar.fid = String.valueOf(customResponsedMessage.getData());
                bVar.fav = true;
                b.this.aW(bVar);
            }
        }
    };
    private CustomMessageListener mUnlikeForumListener = new CustomMessageListener(CmdConfigCustom.CMD_UNLIKE_FORUM) { // from class: com.baidu.tieba.frs.entelechy.a.b.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                com.baidu.tieba.lego.c.b bVar = new com.baidu.tieba.lego.c.b();
                bVar.fid = String.valueOf(customResponsedMessage.getData());
                bVar.fav = false;
                b.this.aW(bVar);
            }
        }
    };
    private CustomMessageListener dHn = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ADCARD) { // from class: com.baidu.tieba.frs.entelechy.a.b.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.data.g)) {
                b.this.aX((com.baidu.tbadk.data.g) customResponsedMessage.getData());
            }
        }
    };
    private final e dBm = new e();

    public b(com.baidu.tieba.frs.i iVar, n nVar, boolean z) {
        this.dGN = nVar;
        a(iVar, nVar);
        this.dHi = new HashMap<>();
        fW(z);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v43, resolved type: com.baidu.tieba.frs.i */
    /* JADX WARN: Multi-variable type inference failed */
    public void a(com.baidu.tieba.frs.i iVar, n nVar) {
        this.dCS = iVar;
        this.dGO = new l(iVar.getPageContext(), bd.aNb, this.dCS.getUniqueId());
        this.dGO.setVoiceManager(iVar.getVoiceManager());
        this.dGP = new j(iVar.getPageContext(), bd.aNc, this.dCS.getUniqueId());
        this.dGQ = new p(iVar.getPageContext(), bd.aNi, this.dCS.getUniqueId());
        this.dGR = new l(iVar.getPageContext(), bd.aNd, this.dCS.getUniqueId());
        this.dGR.setVoiceManager(iVar.getVoiceManager());
        this.dGV = new t(iVar.getPageContext(), bd.aNe, this.dCS.getUniqueId());
        this.dGW = new g(iVar.getPageContext(), bd.aNj, this.dCS.getUniqueId());
        this.dGS = new c(iVar.getPageContext(), ar.aMx, this.dCS.getUniqueId());
        this.dGT = com.baidu.tieba.frs.a.atF().a(iVar.getPageContext(), com.baidu.tieba.tbadkCore.s.gXu, this.dCS.getUniqueId(), false);
        this.dHb = new com.baidu.tieba.frs.l(iVar.getPageContext(), com.baidu.tieba.frs.m.dDH);
        this.dGU = new com.baidu.tieba.frs.p(iVar.getPageContext(), as.aMA);
        this.dGZ = new d(iVar.getPageContext(), bd.aNn, this.dCS.getUniqueId());
        this.dHa = new d(iVar.getPageContext(), bd.aNo, this.dCS.getUniqueId());
        this.dGX = com.baidu.tieba.frs.a.atF().a(iVar.getPageContext(), bd.aOp, this.dCS.getUniqueId(), true);
        this.dGY = com.baidu.tieba.frs.a.atF().b(iVar.getPageContext(), bd.aOw, this.dCS.getUniqueId());
        this.dHd = new m(iVar.getPageContext(), com.baidu.tieba.frs.r.dDQ);
        this.dHe = new i(iVar.getPageContext(), bd.aNp, this.dCS.getUniqueId());
        this.dHf = new h(iVar.getPageContext(), CardHListViewData.TYPE);
        this.dHg = new q(iVar.getPageContext(), com.baidu.tieba.frs.s.dDW, this.dCS.getUniqueId());
        this.dHh = new r(iVar.getPageContext().getPageActivity(), k.gXj, this.dCS.getUniqueId());
        this.mAdapters.add(this.dHh);
        this.mAdapters.add(this.dHf);
        this.mAdapters.add(this.dGO);
        this.mAdapters.add(this.dGP);
        this.mAdapters.add(this.dGQ);
        this.mAdapters.add(this.dGR);
        this.mAdapters.add(this.dHg);
        com.baidu.tieba.InjectPlugin.b.b bVar = new com.baidu.tieba.InjectPlugin.b.b(this.dCS, 1);
        bVar.setExtraData(this.mAdapters);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_FEED_AD_PLUGIN_OPERATE, bVar));
        this.mAdapters.add(this.dGS);
        this.mAdapters.add(this.dHe);
        if (this.dGT != null) {
            this.mAdapters.add(this.dGT);
        }
        this.mAdapters.add(this.dHb);
        this.mAdapters.add(this.dGV);
        this.mAdapters.add(this.dGW);
        this.mAdapters.add(this.dGU);
        this.mAdapters.add(this.dGZ);
        this.mAdapters.add(this.dHa);
        this.mAdapters.add(new w(this.dCS.getPageContext(), x.dEi));
        this.mAdapters.add(this.dGX);
        if (this.dGY != null) {
            this.mAdapters.add(this.dGY);
        }
        this.mAdapters.add(this.dHd);
        com.baidu.adp.widget.ListView.a<? extends bd, ? extends r.a> b = com.baidu.tieba.frs.a.atF().b(this.dCS.getPageContext(), bd.aOo, this.dCS.getUniqueId());
        if (b != null) {
            this.mAdapters.add(b);
        }
        this.dHl.setPriority(1);
        this.dHl.setSelfListener(true);
        this.dCS.registerListener(this.dHl);
        this.dCS.registerListener(this.mAttentionListener);
        this.dCS.registerListener(this.mLikeForumListener);
        this.dCS.registerListener(this.mUnlikeForumListener);
        this.dCS.registerListener(this.dHn);
        awl();
        CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_ADD_ADAPTER, new AbsDelegateAdapterList());
        CustomMessage customMessage = new CustomMessage(CmdConfigCustom.CMD_FRS_ADD_ADAPTER);
        customMessage.setTag(this.dCS.getUniqueId());
        customResponsedMessage.setOrginalMessage(customMessage);
        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
        bk(this.mAdapters);
        nVar.addAdapters(this.mAdapters);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aW(Object obj) {
        boolean z;
        boolean z2 = false;
        if (this.aQQ != null) {
            Iterator<com.baidu.adp.widget.ListView.i> it = this.aQQ.iterator();
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
    public void aX(Object obj) {
        if (this.aQQ != null) {
            Iterator<com.baidu.adp.widget.ListView.i> it = this.aQQ.iterator();
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

    private void awl() {
        if (this.dCS != null && !awm()) {
            this.dCS.registerListener(this.dHm);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v5, resolved type: com.baidu.tieba.frs.i */
    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public boolean awm() {
        if (this.dCS == null) {
            return false;
        }
        this.dHc = new ArrayList();
        ArrayList<BdUniqueId> buT = com.baidu.tieba.tbadkCore.q.buT();
        if (buT == null || buT.size() <= 0) {
            return false;
        }
        int size = buT.size();
        for (int i = 0; i < size; i++) {
            com.baidu.tieba.frs.g<ICardInfo, ? extends r.a> a = com.baidu.tieba.frs.a.atF().a(this.dCS.getPageContext(), buT.get(i), this.dCS.getUniqueId());
            if (a != null) {
                this.mAdapters.add(a);
                this.dHc.add(a);
            }
        }
        if (!v.E(this.dHc)) {
            this.dGN.addAdapters(this.dHc);
        }
        return true;
    }

    @Override // com.baidu.tieba.frs.entelechy.a.u
    public void onDestory() {
        for (com.baidu.adp.widget.ListView.a aVar : this.mAdapters) {
            if (aVar instanceof com.baidu.tieba.frs.g) {
                ((com.baidu.tieba.frs.g) aVar).release();
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.a.u
    public void b(ArrayList<com.baidu.adp.widget.ListView.i> arrayList, com.baidu.tieba.tbadkCore.l lVar) {
        b(lVar);
        com.baidu.tieba.tbadkCore.q.s(arrayList, 1);
        L(arrayList);
        M(arrayList);
        K(arrayList);
        this.dGN.setData(arrayList);
        this.dHj = lVar;
        awv();
        awn();
        this.aQQ = arrayList;
    }

    private void awn() {
        if (this.dHj != null && this.dHj.aYJ() != null && !StringUtils.isNull(this.dHj.aYJ().getId()) && this.dHh != null) {
            this.dHh.setForumId(this.dHj.aYJ().getId());
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
                String zs = bdVar.zs();
                if (iVar instanceof com.baidu.tieba.frs.r) {
                    bdVar.needTopMargin = false;
                } else if (iVar != null && !d(iVar)) {
                    bdVar.needTopMargin = false;
                } else if ((iVar instanceof bd) && d(iVar) && !TextUtils.isEmpty(((bd) iVar).zs())) {
                    bdVar.needTopMargin = true;
                } else if (d(iVar2) && !TextUtils.isEmpty(zs)) {
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
        return type == bd.aNb || type == bd.aNd || type == bd.aNe || type == bd.aNj || type == bd.aNp || type == ar.aMx || type == bd.aNn || type == bd.aNo;
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
                if (this.dHi != null && !this.dHi.containsValue(iVar)) {
                    this.dHi.put(Integer.valueOf(i2), (bd) iVar);
                }
            }
            i = i2 + 1;
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.a.u
    public void fW(boolean z) {
        if (this.dHk != z) {
            this.dHk = z;
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.a.u
    public HashMap<Integer, bd> awo() {
        return this.dHi;
    }

    @Override // com.baidu.tieba.frs.entelechy.a.u
    public void awp() {
        List<com.baidu.adp.widget.ListView.i> data;
        if (this.dGN != null && this.dGN.getData() != null && this.dGN.getData().size() != 0 && (data = this.dGN.getData()) != null && data.size() != 0) {
            for (com.baidu.adp.widget.ListView.i iVar : data) {
                if ((iVar instanceof bd) && ((bd) iVar).yO() != 0) {
                    ((bd) iVar).zC();
                }
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.a.u
    public void notifyDataSetChanged() {
        if (this.dGN.getListAdapter() != null) {
            this.dGN.getListAdapter().notifyDataSetChanged();
        }
    }

    public void alT() {
        if (this.aQQ != null) {
            this.dGN.setData(this.aQQ);
        }
        notifyDataSetChanged();
    }

    @Override // com.baidu.tieba.frs.entelechy.a.u
    public void setFromCDN(boolean z) {
        if (this.mAdapters != null && this.mAdapters.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.mAdapters) {
                if (aVar instanceof com.baidu.tieba.frs.g) {
                    ((com.baidu.tieba.frs.g) aVar).setFromCDN(z);
                }
            }
            if (this.dGO != null) {
                this.dGO.setFromCDN(z);
            }
            if (this.dGR != null) {
                this.dGR.setFromCDN(z);
            }
            if (this.dGZ != null) {
                this.dGZ.setFromCDN(z);
            }
            if (this.dHa != null) {
                this.dHa.setFromCDN(z);
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

    @Override // com.baidu.tieba.frs.entelechy.a.u
    public void a(com.baidu.tieba.frs.b bVar) {
        if (this.mAdapters != null && this.mAdapters.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.mAdapters) {
                if (aVar instanceof com.baidu.tieba.frs.g) {
                    ((com.baidu.tieba.frs.g) aVar).a(bVar);
                }
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.a.u
    public int awq() {
        if (this.dGT != null) {
            return d.g.frs_fortune_bag_item;
        }
        return 0;
    }

    @Override // com.baidu.tieba.frs.entelechy.a.u
    public int awr() {
        if (this.dGT != null) {
            return d.g.frs_my_service_item;
        }
        return 0;
    }

    @Override // com.baidu.tieba.frs.entelechy.a.u
    public int aws() {
        if (this.dGT != null) {
            return d.g.frs_bawu_center;
        }
        return 0;
    }

    @Override // com.baidu.tieba.frs.entelechy.a.u
    public int awt() {
        if (this.dGU != null) {
            return this.dGU.avi();
        }
        return 0;
    }

    @Override // com.baidu.tieba.frs.entelechy.a.u
    public int avj() {
        if (this.dGU != null) {
            return this.dGU.avj();
        }
        return 0;
    }

    @Override // com.baidu.tieba.frs.entelechy.a.u
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

    @Override // com.baidu.tieba.frs.entelechy.a.u
    public void setOnAdapterItemClickListener(o oVar) {
        if (this.mAdapters != null && this.mAdapters.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.mAdapters) {
                if (aVar instanceof com.baidu.tieba.frs.g) {
                    ((com.baidu.tieba.frs.g) aVar).setOnAdapterItemClickListener(oVar);
                } else if ((aVar instanceof l) || (aVar instanceof c) || (aVar instanceof f) || (aVar instanceof d) || (aVar instanceof t)) {
                    aVar.setOnAdapterItemClickListener(oVar);
                } else if (aVar != null && aVar.getType() == bd.aOo) {
                    aVar.setOnAdapterItemClickListener(oVar);
                }
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.a.u
    public void setForumName(String str) {
        if (this.mAdapters != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.mAdapters) {
                if (aVar instanceof com.baidu.tieba.card.u) {
                    ((com.baidu.tieba.card.u) aVar).setForumName(str);
                }
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v1, resolved type: com.baidu.tieba.frs.i */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.baidu.tieba.frs.entelechy.a.u
    public void awu() {
        if (this.mAdapters != null && this.mAdapters.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.mAdapters) {
                if (aVar instanceof com.baidu.tieba.frs.g) {
                    ((com.baidu.tieba.frs.g) aVar).a(this.dCS.getPageContext(), this.dCS.getUniqueId());
                }
            }
            bk(this.mAdapters);
        }
    }

    private void awv() {
        if (this.dHj != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.mAdapters) {
                if (aVar instanceof com.baidu.tieba.frs.d.c) {
                    com.baidu.tieba.frs.d.c cVar = (com.baidu.tieba.frs.d.c) aVar;
                    if (com.baidu.tieba.frs.d.c.dRe != null) {
                        if (this.dHj.gVW == 1) {
                            com.baidu.tieba.frs.d.c.dRe.dQS = true;
                        } else {
                            com.baidu.tieba.frs.d.c.dRe.dQS = false;
                        }
                        if (this.dHj.aYJ() != null) {
                            com.baidu.tieba.frs.d.c.dRe.dQU = this.dHj.aYJ().getId();
                        }
                        if (this.dCS != null && this.dCS.atY() != null) {
                            com.baidu.tieba.frs.d.c.dRe.dQT = this.dCS.atY().ayv();
                        }
                    }
                }
            }
            aww();
        }
    }

    private void aww() {
        com.baidu.tieba.frs.d.a aVar = new com.baidu.tieba.frs.d.a();
        if (this.dHj.gVW == 1) {
            aVar.dQS = true;
        } else {
            aVar.dQS = false;
        }
        if (this.dHj.aYJ() != null) {
            aVar.dQU = this.dHj.aYJ().getId();
        }
        if (this.dCS != null && this.dCS.atY() != null) {
            aVar.dQT = this.dCS.atY().ayv();
        }
        com.baidu.tieba.frs.live.b bVar = new com.baidu.tieba.frs.live.b(aVar);
        CustomMessageTask customMessageTask = new CustomMessageTask(CmdConfigCustom.CMD_FRS_LIVE_CARD_CLICK, bVar);
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
        CustomMessageTask customMessageTask2 = new CustomMessageTask(CmdConfigCustom.CMD_FRS_LIVE_CARD_SHOW, bVar);
        customMessageTask2.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask2);
        CustomMessageTask customMessageTask3 = new CustomMessageTask(CmdConfigCustom.CMD_FRS_LIVE_USER_CLICK, bVar);
        customMessageTask3.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask3);
        CustomMessageTask customMessageTask4 = new CustomMessageTask(CmdConfigCustom.CMD_FRS_LIVE_VIDEO_CLICK, bVar);
        customMessageTask4.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask4);
    }

    @Override // com.baidu.tieba.frs.entelechy.a.u
    public List<com.baidu.adp.widget.ListView.i> getDatas() {
        if (this.dGN != null) {
            return this.dGN.getData();
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
                    if (!it.hasNext() || it.next().getType().getId() != bd.aNa.getId()) {
                        break;
                    }
                    i2 = i + 1;
                }
            }
            for (com.baidu.adp.widget.ListView.a aVar : this.mAdapters) {
                if (aVar instanceof com.baidu.tieba.frs.g) {
                    ((com.baidu.tieba.frs.g) aVar).mP(i);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bk(List<com.baidu.adp.widget.ListView.a> list) {
        if (list != null) {
            for (com.baidu.adp.widget.ListView.a aVar : list) {
                if (aVar instanceof com.baidu.tieba.frs.g) {
                    ((com.baidu.tieba.frs.g) aVar).a(this.dBm);
                }
            }
        }
    }
}
