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
    private ArrayList<com.baidu.adp.widget.ListView.i> aQN;
    private com.baidu.tieba.frs.i dCx;
    private t dGA;
    private g dGB;
    private com.baidu.adp.widget.ListView.a dGC;
    private com.baidu.adp.widget.ListView.a dGD;
    private d dGE;
    private d dGF;
    private com.baidu.tieba.frs.l dGG;
    private List<com.baidu.adp.widget.ListView.a> dGH;
    private m dGI;
    private i dGJ;
    private h dGK;
    private q dGL;
    private r dGM;
    private final HashMap<Integer, bd> dGN;
    private com.baidu.tieba.tbadkCore.l dGO;
    private n dGs;
    private l dGt;
    private j dGu;
    private p dGv;
    private l dGw;
    private c dGx;
    private com.baidu.adp.widget.ListView.a dGy;
    private com.baidu.tieba.frs.p dGz;
    private List<com.baidu.adp.widget.ListView.a> mAdapters = new LinkedList();
    private boolean dGP = false;
    private CustomMessageListener dGQ = new CustomMessageListener(CmdConfigCustom.CMD_FRS_ADD_ADAPTER) { // from class: com.baidu.tieba.frs.entelechy.a.b.1
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
                        ((com.baidu.tieba.frs.g) aVar).a(b.this.dCx.getPageContext(), b.this.dCx.getUniqueId());
                    }
                }
                ArrayList arrayList = new ArrayList();
                arrayList.addAll(absDelegateAdapterList);
                b.this.bk(arrayList);
                if (b.this.mAdapters != null) {
                    b.this.mAdapters.addAll(absDelegateAdapterList);
                }
                if (b.this.dGs != null) {
                    b.this.mAdapters.addAll(arrayList);
                    b.this.dGs.addAdapters(arrayList);
                }
            }
        }
    };
    private CustomMessageListener dGR = new CustomMessageListener(CmdConfigCustom.CMD_LEGO_REGISTER) { // from class: com.baidu.tieba.frs.entelechy.a.b.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && v.E(b.this.dGH)) {
                b.this.awh();
                b.this.b(b.this.aQN, b.this.dGO);
            }
        }
    };
    private CustomMessageListener mAttentionListener = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.frs.entelechy.a.b.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
            if (updateAttentionMessage != null && updateAttentionMessage.getData() != null && updateAttentionMessage.getData().apN) {
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
                bVar.faa = true;
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
                bVar.faa = false;
                b.this.aW(bVar);
            }
        }
    };
    private CustomMessageListener dGS = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ADCARD) { // from class: com.baidu.tieba.frs.entelechy.a.b.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.data.g)) {
                b.this.aX((com.baidu.tbadk.data.g) customResponsedMessage.getData());
            }
        }
    };
    private final e dAR = new e();

    public b(com.baidu.tieba.frs.i iVar, n nVar, boolean z) {
        this.dGs = nVar;
        a(iVar, nVar);
        this.dGN = new HashMap<>();
        fT(z);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v43, resolved type: com.baidu.tieba.frs.i */
    /* JADX WARN: Multi-variable type inference failed */
    public void a(com.baidu.tieba.frs.i iVar, n nVar) {
        this.dCx = iVar;
        this.dGt = new l(iVar.getPageContext(), bd.aMY, this.dCx.getUniqueId());
        this.dGt.setVoiceManager(iVar.getVoiceManager());
        this.dGu = new j(iVar.getPageContext(), bd.aMZ, this.dCx.getUniqueId());
        this.dGv = new p(iVar.getPageContext(), bd.aNf, this.dCx.getUniqueId());
        this.dGw = new l(iVar.getPageContext(), bd.aNa, this.dCx.getUniqueId());
        this.dGw.setVoiceManager(iVar.getVoiceManager());
        this.dGA = new t(iVar.getPageContext(), bd.aNb, this.dCx.getUniqueId());
        this.dGB = new g(iVar.getPageContext(), bd.aNg, this.dCx.getUniqueId());
        this.dGx = new c(iVar.getPageContext(), ar.aMu, this.dCx.getUniqueId());
        this.dGy = com.baidu.tieba.frs.a.atA().a(iVar.getPageContext(), com.baidu.tieba.tbadkCore.s.gXa, this.dCx.getUniqueId(), false);
        this.dGG = new com.baidu.tieba.frs.l(iVar.getPageContext(), com.baidu.tieba.frs.m.dDm);
        this.dGz = new com.baidu.tieba.frs.p(iVar.getPageContext(), as.aMx);
        this.dGE = new d(iVar.getPageContext(), bd.aNk, this.dCx.getUniqueId());
        this.dGF = new d(iVar.getPageContext(), bd.aNl, this.dCx.getUniqueId());
        this.dGC = com.baidu.tieba.frs.a.atA().a(iVar.getPageContext(), bd.aOm, this.dCx.getUniqueId(), true);
        this.dGD = com.baidu.tieba.frs.a.atA().b(iVar.getPageContext(), bd.aOt, this.dCx.getUniqueId());
        this.dGI = new m(iVar.getPageContext(), com.baidu.tieba.frs.r.dDv);
        this.dGJ = new i(iVar.getPageContext(), bd.aNm, this.dCx.getUniqueId());
        this.dGK = new h(iVar.getPageContext(), CardHListViewData.TYPE);
        this.dGL = new q(iVar.getPageContext(), com.baidu.tieba.frs.s.dDB, this.dCx.getUniqueId());
        this.dGM = new r(iVar.getPageContext().getPageActivity(), k.gWP, this.dCx.getUniqueId());
        this.mAdapters.add(this.dGM);
        this.mAdapters.add(this.dGK);
        this.mAdapters.add(this.dGt);
        this.mAdapters.add(this.dGu);
        this.mAdapters.add(this.dGv);
        this.mAdapters.add(this.dGw);
        this.mAdapters.add(this.dGL);
        com.baidu.tieba.InjectPlugin.b.b bVar = new com.baidu.tieba.InjectPlugin.b.b(this.dCx, 1);
        bVar.setExtraData(this.mAdapters);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_FEED_AD_PLUGIN_OPERATE, bVar));
        this.mAdapters.add(this.dGx);
        this.mAdapters.add(this.dGJ);
        if (this.dGy != null) {
            this.mAdapters.add(this.dGy);
        }
        this.mAdapters.add(this.dGG);
        this.mAdapters.add(this.dGA);
        this.mAdapters.add(this.dGB);
        this.mAdapters.add(this.dGz);
        this.mAdapters.add(this.dGE);
        this.mAdapters.add(this.dGF);
        this.mAdapters.add(new w(this.dCx.getPageContext(), x.dDN));
        this.mAdapters.add(this.dGC);
        if (this.dGD != null) {
            this.mAdapters.add(this.dGD);
        }
        this.mAdapters.add(this.dGI);
        com.baidu.adp.widget.ListView.a<? extends bd, ? extends r.a> b = com.baidu.tieba.frs.a.atA().b(this.dCx.getPageContext(), bd.aOl, this.dCx.getUniqueId());
        if (b != null) {
            this.mAdapters.add(b);
        }
        this.dGQ.setPriority(1);
        this.dGQ.setSelfListener(true);
        this.dCx.registerListener(this.dGQ);
        this.dCx.registerListener(this.mAttentionListener);
        this.dCx.registerListener(this.mLikeForumListener);
        this.dCx.registerListener(this.mUnlikeForumListener);
        this.dCx.registerListener(this.dGS);
        awg();
        CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_ADD_ADAPTER, new AbsDelegateAdapterList());
        CustomMessage customMessage = new CustomMessage(CmdConfigCustom.CMD_FRS_ADD_ADAPTER);
        customMessage.setTag(this.dCx.getUniqueId());
        customResponsedMessage.setOrginalMessage(customMessage);
        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
        bk(this.mAdapters);
        nVar.addAdapters(this.mAdapters);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aW(Object obj) {
        boolean z;
        boolean z2 = false;
        if (this.aQN != null) {
            Iterator<com.baidu.adp.widget.ListView.i> it = this.aQN.iterator();
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
        if (this.aQN != null) {
            Iterator<com.baidu.adp.widget.ListView.i> it = this.aQN.iterator();
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

    private void awg() {
        if (this.dCx != null && !awh()) {
            this.dCx.registerListener(this.dGR);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v5, resolved type: com.baidu.tieba.frs.i */
    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public boolean awh() {
        if (this.dCx == null) {
            return false;
        }
        this.dGH = new ArrayList();
        ArrayList<BdUniqueId> buR = com.baidu.tieba.tbadkCore.q.buR();
        if (buR == null || buR.size() <= 0) {
            return false;
        }
        int size = buR.size();
        for (int i = 0; i < size; i++) {
            com.baidu.tieba.frs.g<ICardInfo, ? extends r.a> a = com.baidu.tieba.frs.a.atA().a(this.dCx.getPageContext(), buR.get(i), this.dCx.getUniqueId());
            if (a != null) {
                this.mAdapters.add(a);
                this.dGH.add(a);
            }
        }
        if (!v.E(this.dGH)) {
            this.dGs.addAdapters(this.dGH);
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
        this.dGs.setData(arrayList);
        this.dGO = lVar;
        awq();
        awi();
        this.aQN = arrayList;
    }

    private void awi() {
        if (this.dGO != null && this.dGO.aYE() != null && !StringUtils.isNull(this.dGO.aYE().getId()) && this.dGM != null) {
            this.dGM.setForumId(this.dGO.aYE().getId());
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
                String zr = bdVar.zr();
                if (iVar instanceof com.baidu.tieba.frs.r) {
                    bdVar.needTopMargin = false;
                } else if (iVar != null && !d(iVar)) {
                    bdVar.needTopMargin = false;
                } else if ((iVar instanceof bd) && d(iVar) && !TextUtils.isEmpty(((bd) iVar).zr())) {
                    bdVar.needTopMargin = true;
                } else if (d(iVar2) && !TextUtils.isEmpty(zr)) {
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
        return type == bd.aMY || type == bd.aNa || type == bd.aNb || type == bd.aNg || type == bd.aNm || type == ar.aMu || type == bd.aNk || type == bd.aNl;
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
                if (this.dGN != null && !this.dGN.containsValue(iVar)) {
                    this.dGN.put(Integer.valueOf(i2), (bd) iVar);
                }
            }
            i = i2 + 1;
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.a.u
    public void fT(boolean z) {
        if (this.dGP != z) {
            this.dGP = z;
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.a.u
    public HashMap<Integer, bd> awj() {
        return this.dGN;
    }

    @Override // com.baidu.tieba.frs.entelechy.a.u
    public void awk() {
        List<com.baidu.adp.widget.ListView.i> data;
        if (this.dGs != null && this.dGs.getData() != null && this.dGs.getData().size() != 0 && (data = this.dGs.getData()) != null && data.size() != 0) {
            for (com.baidu.adp.widget.ListView.i iVar : data) {
                if ((iVar instanceof bd) && ((bd) iVar).yN() != 0) {
                    ((bd) iVar).zB();
                }
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.a.u
    public void notifyDataSetChanged() {
        if (this.dGs.getListAdapter() != null) {
            this.dGs.getListAdapter().notifyDataSetChanged();
        }
    }

    public void alO() {
        if (this.aQN != null) {
            this.dGs.setData(this.aQN);
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
            if (this.dGt != null) {
                this.dGt.setFromCDN(z);
            }
            if (this.dGw != null) {
                this.dGw.setFromCDN(z);
            }
            if (this.dGE != null) {
                this.dGE.setFromCDN(z);
            }
            if (this.dGF != null) {
                this.dGF.setFromCDN(z);
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
    public int awl() {
        if (this.dGy != null) {
            return d.g.frs_fortune_bag_item;
        }
        return 0;
    }

    @Override // com.baidu.tieba.frs.entelechy.a.u
    public int awm() {
        if (this.dGy != null) {
            return d.g.frs_my_service_item;
        }
        return 0;
    }

    @Override // com.baidu.tieba.frs.entelechy.a.u
    public int awn() {
        if (this.dGy != null) {
            return d.g.frs_bawu_center;
        }
        return 0;
    }

    @Override // com.baidu.tieba.frs.entelechy.a.u
    public int awo() {
        if (this.dGz != null) {
            return this.dGz.avd();
        }
        return 0;
    }

    @Override // com.baidu.tieba.frs.entelechy.a.u
    public int ave() {
        if (this.dGz != null) {
            return this.dGz.ave();
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
                } else if (aVar != null && aVar.getType() == bd.aOl) {
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
    public void awp() {
        if (this.mAdapters != null && this.mAdapters.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.mAdapters) {
                if (aVar instanceof com.baidu.tieba.frs.g) {
                    ((com.baidu.tieba.frs.g) aVar).a(this.dCx.getPageContext(), this.dCx.getUniqueId());
                }
            }
            bk(this.mAdapters);
        }
    }

    private void awq() {
        if (this.dGO != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.mAdapters) {
                if (aVar instanceof com.baidu.tieba.frs.d.c) {
                    com.baidu.tieba.frs.d.c cVar = (com.baidu.tieba.frs.d.c) aVar;
                    if (com.baidu.tieba.frs.d.c.dQJ != null) {
                        if (this.dGO.gVC == 1) {
                            com.baidu.tieba.frs.d.c.dQJ.dQx = true;
                        } else {
                            com.baidu.tieba.frs.d.c.dQJ.dQx = false;
                        }
                        if (this.dGO.aYE() != null) {
                            com.baidu.tieba.frs.d.c.dQJ.dQz = this.dGO.aYE().getId();
                        }
                        if (this.dCx != null && this.dCx.atT() != null) {
                            com.baidu.tieba.frs.d.c.dQJ.dQy = this.dCx.atT().ayq();
                        }
                    }
                }
            }
            awr();
        }
    }

    private void awr() {
        com.baidu.tieba.frs.d.a aVar = new com.baidu.tieba.frs.d.a();
        if (this.dGO.gVC == 1) {
            aVar.dQx = true;
        } else {
            aVar.dQx = false;
        }
        if (this.dGO.aYE() != null) {
            aVar.dQz = this.dGO.aYE().getId();
        }
        if (this.dCx != null && this.dCx.atT() != null) {
            aVar.dQy = this.dCx.atT().ayq();
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
        if (this.dGs != null) {
            return this.dGs.getData();
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
                    if (!it.hasNext() || it.next().getType().getId() != bd.aMX.getId()) {
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
                    ((com.baidu.tieba.frs.g) aVar).a(this.dAR);
                }
            }
        }
    }
}
