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
import com.baidu.tbadk.core.data.as;
import com.baidu.tbadk.core.data.at;
import com.baidu.tbadk.core.data.be;
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
    private ArrayList<com.baidu.adp.widget.ListView.i> aQO;
    private n dBR;
    private l dBS;
    private j dBT;
    private p dBU;
    private l dBV;
    private c dBW;
    private com.baidu.adp.widget.ListView.a dBX;
    private com.baidu.tieba.frs.p dBY;
    private t dBZ;
    private g dCa;
    private com.baidu.adp.widget.ListView.a dCb;
    private com.baidu.adp.widget.ListView.a dCc;
    private d dCd;
    private d dCe;
    private com.baidu.tieba.frs.l dCf;
    private List<com.baidu.adp.widget.ListView.a> dCg;
    private m dCh;
    private i dCi;
    private h dCj;
    private q dCk;
    private r dCl;
    private final HashMap<Integer, be> dCm;
    private com.baidu.tieba.tbadkCore.l dCn;
    private com.baidu.tieba.frs.i dxW;
    private List<com.baidu.adp.widget.ListView.a> mAdapters = new LinkedList();
    private boolean dCo = false;
    private CustomMessageListener dCp = new CustomMessageListener(CmdConfigCustom.CMD_FRS_ADD_ADAPTER) { // from class: com.baidu.tieba.frs.entelechy.a.b.1
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
                        ((com.baidu.tieba.frs.g) aVar).a(b.this.dxW.getPageContext(), b.this.dxW.getUniqueId());
                    }
                }
                ArrayList arrayList = new ArrayList();
                arrayList.addAll(absDelegateAdapterList);
                b.this.bm(arrayList);
                if (b.this.mAdapters != null) {
                    b.this.mAdapters.addAll(absDelegateAdapterList);
                }
                if (b.this.dBR != null) {
                    b.this.mAdapters.addAll(arrayList);
                    b.this.dBR.addAdapters(arrayList);
                }
            }
        }
    };
    private CustomMessageListener dCq = new CustomMessageListener(CmdConfigCustom.CMD_LEGO_REGISTER) { // from class: com.baidu.tieba.frs.entelechy.a.b.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && v.G(b.this.dCg)) {
                b.this.ave();
                b.this.b(b.this.aQO, b.this.dCn);
            }
        }
    };
    private CustomMessageListener mAttentionListener = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.frs.entelechy.a.b.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
            if (updateAttentionMessage != null && updateAttentionMessage.getData() != null && updateAttentionMessage.getData().apO) {
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
                bVar.eYz = true;
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
                bVar.eYz = false;
                b.this.aW(bVar);
            }
        }
    };
    private CustomMessageListener dCr = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ADCARD) { // from class: com.baidu.tieba.frs.entelechy.a.b.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.data.g)) {
                b.this.aX((com.baidu.tbadk.data.g) customResponsedMessage.getData());
            }
        }
    };
    private final e dwq = new e();

    public b(com.baidu.tieba.frs.i iVar, n nVar, boolean z) {
        this.dBR = nVar;
        a(iVar, nVar);
        this.dCm = new HashMap<>();
        fP(z);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v43, resolved type: com.baidu.tieba.frs.i */
    /* JADX WARN: Multi-variable type inference failed */
    public void a(com.baidu.tieba.frs.i iVar, n nVar) {
        this.dxW = iVar;
        this.dBS = new l(iVar.getPageContext(), be.aNc, this.dxW.getUniqueId());
        this.dBS.setVoiceManager(iVar.getVoiceManager());
        this.dBT = new j(iVar.getPageContext(), be.aNd, this.dxW.getUniqueId());
        this.dBU = new p(iVar.getPageContext(), be.aNj, this.dxW.getUniqueId());
        this.dBV = new l(iVar.getPageContext(), be.aNe, this.dxW.getUniqueId());
        this.dBV.setVoiceManager(iVar.getVoiceManager());
        this.dBZ = new t(iVar.getPageContext(), be.aNf, this.dxW.getUniqueId());
        this.dCa = new g(iVar.getPageContext(), be.aNk, this.dxW.getUniqueId());
        this.dBW = new c(iVar.getPageContext(), as.aMy, this.dxW.getUniqueId());
        this.dBX = com.baidu.tieba.frs.a.asx().a(iVar.getPageContext(), com.baidu.tieba.tbadkCore.s.hhz, this.dxW.getUniqueId(), false);
        this.dCf = new com.baidu.tieba.frs.l(iVar.getPageContext(), com.baidu.tieba.frs.m.dyL);
        this.dBY = new com.baidu.tieba.frs.p(iVar.getPageContext(), at.aMB);
        this.dCd = new d(iVar.getPageContext(), be.aNo, this.dxW.getUniqueId());
        this.dCe = new d(iVar.getPageContext(), be.aNp, this.dxW.getUniqueId());
        this.dCb = com.baidu.tieba.frs.a.asx().a(iVar.getPageContext(), be.aOq, this.dxW.getUniqueId(), true);
        this.dCc = com.baidu.tieba.frs.a.asx().b(iVar.getPageContext(), be.aOv, this.dxW.getUniqueId());
        this.dCh = new m(iVar.getPageContext(), com.baidu.tieba.frs.r.dyU);
        this.dCi = new i(iVar.getPageContext(), be.aNq, this.dxW.getUniqueId());
        this.dCj = new h(iVar.getPageContext(), CardHListViewData.TYPE);
        this.dCk = new q(iVar.getPageContext(), com.baidu.tieba.frs.s.dza, this.dxW.getUniqueId());
        this.dCl = new r(iVar.getPageContext().getPageActivity(), k.hho, this.dxW.getUniqueId());
        this.mAdapters.add(this.dCl);
        this.mAdapters.add(this.dCj);
        this.mAdapters.add(this.dBS);
        this.mAdapters.add(this.dBT);
        this.mAdapters.add(this.dBU);
        this.mAdapters.add(this.dBV);
        this.mAdapters.add(this.dCk);
        com.baidu.tieba.InjectPlugin.b.b bVar = new com.baidu.tieba.InjectPlugin.b.b(this.dxW, 1);
        bVar.setExtraData(this.mAdapters);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_FEED_AD_PLUGIN_OPERATE, bVar));
        this.mAdapters.add(this.dBW);
        this.mAdapters.add(this.dCi);
        if (this.dBX != null) {
            this.mAdapters.add(this.dBX);
        }
        this.mAdapters.add(this.dCf);
        this.mAdapters.add(this.dBZ);
        this.mAdapters.add(this.dCa);
        this.mAdapters.add(this.dBY);
        this.mAdapters.add(this.dCd);
        this.mAdapters.add(this.dCe);
        this.mAdapters.add(new w(this.dxW.getPageContext(), x.dzm));
        this.mAdapters.add(this.dCb);
        if (this.dCc != null) {
            this.mAdapters.add(this.dCc);
        }
        this.mAdapters.add(this.dCh);
        com.baidu.adp.widget.ListView.a<? extends be, ? extends r.a> b = com.baidu.tieba.frs.a.asx().b(this.dxW.getPageContext(), be.aOp, this.dxW.getUniqueId());
        if (b != null) {
            this.mAdapters.add(b);
        }
        this.dCp.setPriority(1);
        this.dCp.setSelfListener(true);
        this.dxW.registerListener(this.dCp);
        this.dxW.registerListener(this.mAttentionListener);
        this.dxW.registerListener(this.mLikeForumListener);
        this.dxW.registerListener(this.mUnlikeForumListener);
        this.dxW.registerListener(this.dCr);
        avd();
        CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_ADD_ADAPTER, new AbsDelegateAdapterList());
        CustomMessage customMessage = new CustomMessage(CmdConfigCustom.CMD_FRS_ADD_ADAPTER);
        customMessage.setTag(this.dxW.getUniqueId());
        customResponsedMessage.setOrginalMessage(customMessage);
        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
        bm(this.mAdapters);
        nVar.addAdapters(this.mAdapters);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aW(Object obj) {
        boolean z;
        boolean z2 = false;
        if (this.aQO != null) {
            Iterator<com.baidu.adp.widget.ListView.i> it = this.aQO.iterator();
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
        if (this.aQO != null) {
            Iterator<com.baidu.adp.widget.ListView.i> it = this.aQO.iterator();
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

    private void avd() {
        if (this.dxW != null && !ave()) {
            this.dxW.registerListener(this.dCq);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v5, resolved type: com.baidu.tieba.frs.i */
    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public boolean ave() {
        if (this.dxW == null) {
            return false;
        }
        this.dCg = new ArrayList();
        ArrayList<BdUniqueId> bBv = com.baidu.tieba.tbadkCore.q.bBv();
        if (bBv == null || bBv.size() <= 0) {
            return false;
        }
        int size = bBv.size();
        for (int i = 0; i < size; i++) {
            com.baidu.tieba.frs.g<ICardInfo, ? extends r.a> a = com.baidu.tieba.frs.a.asx().a(this.dxW.getPageContext(), bBv.get(i), this.dxW.getUniqueId());
            if (a != null) {
                this.mAdapters.add(a);
                this.dCg.add(a);
            }
        }
        if (!v.G(this.dCg)) {
            this.dBR.addAdapters(this.dCg);
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
        this.dBR.setData(arrayList);
        this.dCn = lVar;
        avn();
        avf();
        this.aQO = arrayList;
    }

    private void avf() {
        if (this.dCn != null && this.dCn.aYy() != null && !StringUtils.isNull(this.dCn.aYy().getId()) && this.dCl != null) {
            this.dCl.setForumId(this.dCn.aYy().getId());
        }
    }

    private void K(ArrayList<com.baidu.adp.widget.ListView.i> arrayList) {
        int F = v.F(arrayList);
        for (int i = 0; i < F; i++) {
            com.baidu.adp.widget.ListView.i iVar = (com.baidu.adp.widget.ListView.i) v.f(arrayList, i - 1);
            com.baidu.adp.widget.ListView.i iVar2 = (com.baidu.adp.widget.ListView.i) v.f(arrayList, i);
            if (iVar2 instanceof be) {
                be beVar = (be) iVar2;
                if (i == 0) {
                    beVar.isFirstFloor = true;
                } else {
                    beVar.isFirstFloor = false;
                }
                String zw = beVar.zw();
                if (iVar instanceof com.baidu.tieba.frs.r) {
                    beVar.needTopMargin = false;
                } else if (iVar != null && !d(iVar)) {
                    beVar.needTopMargin = false;
                } else if ((iVar instanceof be) && d(iVar) && !TextUtils.isEmpty(((be) iVar).zw())) {
                    beVar.needTopMargin = true;
                } else if (d(iVar2) && !TextUtils.isEmpty(zw)) {
                    beVar.needTopMargin = true;
                } else {
                    beVar.needTopMargin = false;
                }
            }
        }
    }

    private boolean d(com.baidu.adp.widget.ListView.i iVar) {
        if (iVar == null) {
            return false;
        }
        BdUniqueId type = iVar.getType();
        return type == be.aNc || type == be.aNe || type == be.aNf || type == be.aNk || type == be.aNq || type == as.aMy || type == be.aNo || type == be.aNp;
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
                if (this.dCm != null && !this.dCm.containsValue(iVar)) {
                    this.dCm.put(Integer.valueOf(i2), (be) iVar);
                }
            }
            i = i2 + 1;
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.a.u
    public void fP(boolean z) {
        if (this.dCo != z) {
            this.dCo = z;
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.a.u
    public HashMap<Integer, be> avg() {
        return this.dCm;
    }

    @Override // com.baidu.tieba.frs.entelechy.a.u
    public void avh() {
        List<com.baidu.adp.widget.ListView.i> data;
        if (this.dBR != null && this.dBR.getData() != null && this.dBR.getData().size() != 0 && (data = this.dBR.getData()) != null && data.size() != 0) {
            for (com.baidu.adp.widget.ListView.i iVar : data) {
                if ((iVar instanceof be) && ((be) iVar).yS() != 0) {
                    ((be) iVar).zF();
                }
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.a.u
    public void notifyDataSetChanged() {
        if (this.dBR.getListAdapter() != null) {
            this.dBR.getListAdapter().notifyDataSetChanged();
        }
    }

    public void akL() {
        if (this.aQO != null) {
            this.dBR.setData(this.aQO);
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
            if (this.dBS != null) {
                this.dBS.setFromCDN(z);
            }
            if (this.dBV != null) {
                this.dBV.setFromCDN(z);
            }
            if (this.dCd != null) {
                this.dCd.setFromCDN(z);
            }
            if (this.dCe != null) {
                this.dCe.setFromCDN(z);
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
    public int avi() {
        if (this.dBX != null) {
            return d.g.frs_fortune_bag_item;
        }
        return 0;
    }

    @Override // com.baidu.tieba.frs.entelechy.a.u
    public int avj() {
        if (this.dBX != null) {
            return d.g.frs_my_service_item;
        }
        return 0;
    }

    @Override // com.baidu.tieba.frs.entelechy.a.u
    public int avk() {
        if (this.dBX != null) {
            return d.g.frs_bawu_center;
        }
        return 0;
    }

    @Override // com.baidu.tieba.frs.entelechy.a.u
    public int avl() {
        if (this.dBY != null) {
            return this.dBY.aua();
        }
        return 0;
    }

    @Override // com.baidu.tieba.frs.entelechy.a.u
    public int aub() {
        if (this.dBY != null) {
            return this.dBY.aub();
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
                } else if (aVar != null && aVar.getType() == be.aOp) {
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
    public void avm() {
        if (this.mAdapters != null && this.mAdapters.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.mAdapters) {
                if (aVar instanceof com.baidu.tieba.frs.g) {
                    ((com.baidu.tieba.frs.g) aVar).a(this.dxW.getPageContext(), this.dxW.getUniqueId());
                }
            }
            bm(this.mAdapters);
        }
    }

    private void avn() {
        if (this.dCn != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.mAdapters) {
                if (aVar instanceof com.baidu.tieba.frs.d.c) {
                    com.baidu.tieba.frs.d.c cVar = (com.baidu.tieba.frs.d.c) aVar;
                    if (com.baidu.tieba.frs.d.c.dMh != null) {
                        if (this.dCn.hgc == 1) {
                            com.baidu.tieba.frs.d.c.dMh.dLV = true;
                        } else {
                            com.baidu.tieba.frs.d.c.dMh.dLV = false;
                        }
                        if (this.dCn.aYy() != null) {
                            com.baidu.tieba.frs.d.c.dMh.dLX = this.dCn.aYy().getId();
                        }
                        if (this.dxW != null && this.dxW.asQ() != null) {
                            com.baidu.tieba.frs.d.c.dMh.dLW = this.dxW.asQ().axn();
                        }
                    }
                }
            }
            avo();
        }
    }

    private void avo() {
        com.baidu.tieba.frs.d.a aVar = new com.baidu.tieba.frs.d.a();
        if (this.dCn.hgc == 1) {
            aVar.dLV = true;
        } else {
            aVar.dLV = false;
        }
        if (this.dCn.aYy() != null) {
            aVar.dLX = this.dCn.aYy().getId();
        }
        if (this.dxW != null && this.dxW.asQ() != null) {
            aVar.dLW = this.dxW.asQ().axn();
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
        if (this.dBR != null) {
            return this.dBR.getData();
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
                    if (!it.hasNext() || it.next().getType().getId() != be.aNb.getId()) {
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
                    ((com.baidu.tieba.frs.g) aVar).a(this.dwq);
                }
            }
        }
    }
}
