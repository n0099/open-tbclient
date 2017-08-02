package com.baidu.tieba.frs.entelechy.a;

import android.text.TextUtils;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.adp.widget.ListView.j;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.data.ax;
import com.baidu.tbadk.core.data.ay;
import com.baidu.tbadk.core.data.bl;
import com.baidu.tbadk.core.data.z;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.u;
import com.baidu.tbadk.coreExtra.message.UpdateAttentionMessage;
import com.baidu.tieba.card.data.CardHListViewData;
import com.baidu.tieba.d;
import com.baidu.tieba.frs.AbsDelegateAdapterList;
import com.baidu.tieba.frs.k;
import com.baidu.tieba.frs.n;
import com.baidu.tieba.frs.v;
import com.baidu.tieba.lego.card.model.ICardInfo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public class b implements q {
    private ArrayList<com.baidu.adp.widget.ListView.f> abq;
    private com.baidu.tieba.frs.f cjg;
    private l clL;
    private j clM;
    private l clN;
    private c clO;
    private com.baidu.adp.widget.ListView.a clP;
    private n clQ;
    private p clR;
    private g clS;
    private com.baidu.adp.widget.ListView.a clT;
    private com.baidu.adp.widget.ListView.a clU;
    private d clV;
    private d clW;
    private com.baidu.tieba.frs.j clX;
    private com.baidu.tieba.frs.i.a clY;
    private List<com.baidu.adp.widget.ListView.a> clZ;
    private m cma;
    private i cmb;
    private h cmc;
    private final HashMap<Integer, bl> cme;
    private com.baidu.tieba.tbadkCore.i cmf;
    private BdTypeListView mListView;
    private List<com.baidu.adp.widget.ListView.a> mAdapters = new LinkedList();
    private boolean cmg = false;
    private CustomMessageListener cmh = new CustomMessageListener(CmdConfigCustom.CMD_FRS_ADD_ADAPTER) { // from class: com.baidu.tieba.frs.entelechy.a.b.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2003008 && (customResponsedMessage.getData() instanceof AbsDelegateAdapterList)) {
                AbsDelegateAdapterList absDelegateAdapterList = (AbsDelegateAdapterList) customResponsedMessage.getData();
                Iterator it = absDelegateAdapterList.iterator();
                while (it.hasNext()) {
                    com.baidu.adp.widget.ListView.a aVar = (com.baidu.adp.widget.ListView.a) it.next();
                    if (aVar instanceof com.baidu.tieba.frs.d) {
                        ((com.baidu.tieba.frs.d) aVar).a(b.this.cjg.getPageContext(), b.this.cjg.getUniqueId());
                    }
                }
                ArrayList arrayList = new ArrayList();
                arrayList.addAll(absDelegateAdapterList);
                b.this.aH(arrayList);
                if (b.this.mAdapters != null) {
                    b.this.mAdapters.addAll(absDelegateAdapterList);
                }
                if (b.this.mListView != null) {
                    b.this.mAdapters.addAll(arrayList);
                    b.this.mListView.addAdapters(arrayList);
                }
            }
        }
    };
    private CustomMessageListener cmi = new CustomMessageListener(CmdConfigCustom.CMD_LEGO_REGISTER) { // from class: com.baidu.tieba.frs.entelechy.a.b.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && u.v(b.this.clZ)) {
                b.this.agF();
                b.this.b(b.this.abq, b.this.cmf);
            }
        }
    };
    private CustomMessageListener aoM = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.frs.entelechy.a.b.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
            if (updateAttentionMessage != null && updateAttentionMessage.getData() != null && updateAttentionMessage.getData().CB) {
                b.this.R(updateAttentionMessage.getData());
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
                bVar.dQR = true;
                b.this.R(bVar);
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
                bVar.dQR = false;
                b.this.R(bVar);
            }
        }
    };
    private CustomMessageListener cmj = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ADCARD) { // from class: com.baidu.tieba.frs.entelechy.a.b.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.data.i)) {
                b.this.S((com.baidu.tbadk.data.i) customResponsedMessage.getData());
            }
        }
    };
    private final com.baidu.tieba.frs.c chy = new com.baidu.tieba.frs.c();

    public b(com.baidu.tieba.frs.f fVar, BdTypeListView bdTypeListView, boolean z) {
        this.mListView = bdTypeListView;
        a(fVar, bdTypeListView);
        this.cme = new HashMap<>();
        eP(z);
    }

    public void a(com.baidu.tieba.frs.f fVar, BdTypeListView bdTypeListView) {
        this.cjg = fVar;
        this.clL = new l(fVar.getPageContext(), bl.XE, this.cjg.getUniqueId());
        this.clL.setVoiceManager(fVar.getVoiceManager());
        this.clM = new j(fVar.getPageContext(), bl.XF, this.cjg.getUniqueId());
        this.clN = new l(fVar.getPageContext(), bl.XG, this.cjg.getUniqueId());
        this.clN.setVoiceManager(fVar.getVoiceManager());
        this.clR = new p(fVar.getPageContext(), bl.XH, this.cjg.getUniqueId());
        this.clS = new g(fVar.getPageContext(), bl.XL, this.cjg.getUniqueId());
        this.clO = new c(fVar.getPageContext(), ax.WX, this.cjg.getUniqueId());
        this.clP = com.baidu.tieba.frs.a.aex().a(fVar.getPageContext(), com.baidu.tieba.tbadkCore.p.gfv, this.cjg.getUniqueId(), false);
        this.clX = new com.baidu.tieba.frs.j(fVar.getPageContext(), k.cjJ);
        this.clQ = new n(fVar.getPageContext(), ay.Xa);
        this.clV = new d(fVar.getPageContext(), bl.XP, this.cjg.getUniqueId());
        this.clW = new d(fVar.getPageContext(), bl.XQ, this.cjg.getUniqueId());
        this.clT = com.baidu.tieba.frs.a.aex().a(fVar.getPageContext(), bl.YQ, this.cjg.getUniqueId(), false);
        this.clU = com.baidu.tieba.frs.a.aex().b(fVar.getPageContext(), bl.YV, this.cjg.getUniqueId());
        this.clY = new com.baidu.tieba.frs.i.a(fVar.getPageContext(), z.Vv, this.cjg.getUniqueId());
        this.cma = new m(fVar.getPageContext(), com.baidu.tieba.frs.p.ckl);
        this.cmb = new i(fVar.getPageContext(), bl.XR, this.cjg.getUniqueId());
        this.cmc = new h(fVar.getPageContext(), CardHListViewData.TYPE);
        this.mAdapters.add(this.cmc);
        this.mAdapters.add(this.clL);
        this.mAdapters.add(this.clM);
        this.mAdapters.add(this.clN);
        com.baidu.tieba.InjectPlugin.b.b bVar = new com.baidu.tieba.InjectPlugin.b.b(this.cjg, 1);
        bVar.setExtraData(this.mAdapters);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_FEED_AD_PLUGIN_OPERATE, bVar));
        this.mAdapters.add(this.clO);
        this.mAdapters.add(this.cmb);
        if (this.clP != null) {
            this.mAdapters.add(this.clP);
        }
        this.mAdapters.add(this.clX);
        this.mAdapters.add(this.clR);
        this.mAdapters.add(this.clS);
        this.mAdapters.add(this.clQ);
        this.mAdapters.add(this.clV);
        this.mAdapters.add(this.clW);
        this.mAdapters.add(new com.baidu.tieba.frs.u(this.cjg.getPageContext(), v.ckA));
        this.mAdapters.add(this.clT);
        if (this.clU != null) {
            this.mAdapters.add(this.clU);
        }
        this.mAdapters.add(this.clY);
        this.mAdapters.add(this.cma);
        com.baidu.adp.widget.ListView.a<? extends bl, ? extends j.a> b = com.baidu.tieba.frs.a.aex().b(this.cjg.getPageContext(), bl.YP, this.cjg.getUniqueId());
        if (b != null) {
            this.mAdapters.add(b);
        }
        this.cmh.setPriority(1);
        this.cmh.setSelfListener(true);
        this.cjg.registerListener(this.cmh);
        this.cjg.registerListener(this.aoM);
        this.cjg.registerListener(this.mLikeForumListener);
        this.cjg.registerListener(this.mUnlikeForumListener);
        this.cjg.registerListener(this.cmj);
        agE();
        CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_ADD_ADAPTER, new AbsDelegateAdapterList());
        CustomMessage customMessage = new CustomMessage(CmdConfigCustom.CMD_FRS_ADD_ADAPTER);
        customMessage.setTag(this.cjg.getUniqueId());
        customResponsedMessage.setOrginalMessage(customMessage);
        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
        aH(this.mAdapters);
        bdTypeListView.addAdapters(this.mAdapters);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void R(Object obj) {
        boolean z;
        boolean z2 = false;
        if (this.abq != null) {
            Iterator<com.baidu.adp.widget.ListView.f> it = this.abq.iterator();
            while (true) {
                z = z2;
                if (!it.hasNext()) {
                    break;
                }
                com.baidu.adp.widget.ListView.f next = it.next();
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
    public void S(Object obj) {
        if (this.abq != null) {
            Iterator<com.baidu.adp.widget.ListView.f> it = this.abq.iterator();
            while (it.hasNext()) {
                com.baidu.adp.widget.ListView.f next = it.next();
                if (next instanceof AdvertAppInfo) {
                    AdvertAppInfo advertAppInfo = (AdvertAppInfo) next;
                    if (advertAppInfo.legoCard != null) {
                        advertAppInfo.legoCard.refreshReservation(obj);
                    }
                }
            }
        }
    }

    private void agE() {
        if (this.cjg != null && !agF()) {
            this.cjg.registerListener(this.cmi);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean agF() {
        if (this.cjg == null) {
            return false;
        }
        this.clZ = new ArrayList();
        ArrayList<BdUniqueId> brB = com.baidu.tieba.tbadkCore.n.brB();
        if (brB == null || brB.size() <= 0) {
            return false;
        }
        int size = brB.size();
        for (int i = 0; i < size; i++) {
            com.baidu.tieba.frs.d<ICardInfo, ? extends j.a> a = com.baidu.tieba.frs.a.aex().a(this.cjg.getPageContext(), brB.get(i), this.cjg.getUniqueId());
            if (a != null) {
                this.mAdapters.add(a);
                this.clZ.add(a);
            }
        }
        if (!u.v(this.clZ)) {
            this.mListView.addAdapters(this.clZ);
        }
        return true;
    }

    @Override // com.baidu.tieba.frs.entelechy.a.q
    public void onDestory() {
        for (com.baidu.adp.widget.ListView.a aVar : this.mAdapters) {
            if (aVar instanceof com.baidu.tieba.frs.d) {
                ((com.baidu.tieba.frs.d) aVar).release();
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.a.q
    public void b(ArrayList<com.baidu.adp.widget.ListView.f> arrayList, com.baidu.tieba.tbadkCore.i iVar) {
        a(iVar);
        com.baidu.tieba.tbadkCore.n.q(arrayList, 1);
        I(arrayList);
        J(arrayList);
        H(arrayList);
        this.mListView.setData(arrayList);
        this.cmf = iVar;
        agM();
        this.abq = arrayList;
    }

    private void H(ArrayList<com.baidu.adp.widget.ListView.f> arrayList) {
        int u = u.u(arrayList);
        for (int i = 0; i < u; i++) {
            com.baidu.adp.widget.ListView.f fVar = (com.baidu.adp.widget.ListView.f) u.c(arrayList, i - 1);
            com.baidu.adp.widget.ListView.f fVar2 = (com.baidu.adp.widget.ListView.f) u.c(arrayList, i);
            if (fVar2 instanceof bl) {
                bl blVar = (bl) fVar2;
                if (i == 0) {
                    blVar.isFirstFloor = true;
                } else {
                    blVar.isFirstFloor = false;
                }
                String rT = blVar.rT();
                if (fVar instanceof com.baidu.tieba.frs.p) {
                    blVar.needTopMargin = false;
                } else if (fVar != null && !e(fVar)) {
                    blVar.needTopMargin = false;
                } else if ((fVar instanceof bl) && e(fVar) && !TextUtils.isEmpty(((bl) fVar).rT())) {
                    blVar.needTopMargin = true;
                } else if (e(fVar2) && !TextUtils.isEmpty(rT)) {
                    blVar.needTopMargin = true;
                } else {
                    blVar.needTopMargin = false;
                }
            }
        }
    }

    private boolean e(com.baidu.adp.widget.ListView.f fVar) {
        if (fVar == null) {
            return false;
        }
        BdUniqueId type = fVar.getType();
        return type == bl.XE || type == bl.XG || type == bl.XH || type == bl.XL || type == bl.XR || type == ax.WX || type == bl.XP || type == bl.XQ;
    }

    private ArrayList<Integer> I(ArrayList<com.baidu.adp.widget.ListView.f> arrayList) {
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
            com.baidu.adp.widget.ListView.f fVar = arrayList.get(i2);
            if (fVar instanceof AdvertAppInfo) {
                arrayList2.add(Integer.valueOf(i2));
                if (this.cme != null && !this.cme.containsValue(fVar)) {
                    this.cme.put(Integer.valueOf(i2), (bl) fVar);
                }
            }
            i = i2 + 1;
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.a.q
    public void eP(boolean z) {
        if (this.cmg != z) {
            this.cmg = z;
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.a.q
    public HashMap<Integer, bl> agG() {
        return this.cme;
    }

    @Override // com.baidu.tieba.frs.entelechy.a.q
    public void agH() {
        if (this.mListView != null && this.mListView.getData() != null && this.mListView.getData().size() != 0) {
            for (com.baidu.adp.widget.ListView.f fVar : this.mListView.getData()) {
                if ((fVar instanceof bl) && ((bl) fVar).rq() != 0) {
                    ((bl) fVar).sd();
                }
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.a.q
    public void notifyDataSetChanged() {
        if (this.mListView.getAdapter() instanceof com.baidu.adp.widget.ListView.d) {
            ((com.baidu.adp.widget.ListView.d) this.mListView.getAdapter()).notifyDataSetChanged();
        }
    }

    public void XB() {
        if (this.mListView.getAdapter() instanceof com.baidu.adp.widget.ListView.d) {
            if (this.abq != null) {
                this.mListView.setData(this.abq);
            }
            ((com.baidu.adp.widget.ListView.d) this.mListView.getAdapter()).notifyDataSetChanged();
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.a.q
    public void setFromCDN(boolean z) {
        if (this.mAdapters != null && this.mAdapters.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.mAdapters) {
                if (aVar instanceof com.baidu.tieba.frs.d) {
                    ((com.baidu.tieba.frs.d) aVar).setFromCDN(z);
                }
            }
            if (this.clL != null) {
                this.clL.setFromCDN(z);
            }
            if (this.clN != null) {
                this.clN.setFromCDN(z);
            }
            if (this.clV != null) {
                this.clV.setFromCDN(z);
            }
            if (this.clW != null) {
                this.clW.setFromCDN(z);
            }
        }
    }

    public void a(com.baidu.tieba.tbadkCore.i iVar) {
        if (this.mAdapters != null && this.mAdapters.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.mAdapters) {
                if (aVar instanceof com.baidu.tieba.frs.d) {
                    ((com.baidu.tieba.frs.d) aVar).a(iVar);
                }
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.a.q
    public void a(com.baidu.tieba.frs.b bVar) {
        if (this.mAdapters != null && this.mAdapters.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.mAdapters) {
                if (aVar instanceof com.baidu.tieba.frs.d) {
                    ((com.baidu.tieba.frs.d) aVar).a(bVar);
                }
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.a.q
    public int agI() {
        if (this.clP != null) {
            return d.h.frs_fortune_bag_item;
        }
        return 0;
    }

    @Override // com.baidu.tieba.frs.entelechy.a.q
    public int agJ() {
        if (this.clP != null) {
            return d.h.frs_my_service_item;
        }
        return 0;
    }

    @Override // com.baidu.tieba.frs.entelechy.a.q
    public int agK() {
        if (this.clP != null) {
            return d.h.frs_bawu_center;
        }
        return 0;
    }

    @Override // com.baidu.tieba.frs.entelechy.a.q
    public int agL() {
        if (this.clQ != null) {
            return this.clQ.afV();
        }
        return 0;
    }

    @Override // com.baidu.tieba.frs.entelechy.a.q
    public int afW() {
        if (this.clQ != null) {
            return this.clQ.afW();
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
    public void setOnAdapterItemClickListener(com.baidu.adp.widget.ListView.h hVar) {
        if (this.mAdapters != null && this.mAdapters.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.mAdapters) {
                if (aVar instanceof com.baidu.tieba.frs.d) {
                    ((com.baidu.tieba.frs.d) aVar).setOnAdapterItemClickListener(hVar);
                } else if ((aVar instanceof l) || (aVar instanceof c) || (aVar instanceof f) || (aVar instanceof d) || (aVar instanceof p)) {
                    aVar.setOnAdapterItemClickListener(hVar);
                } else if (aVar != null && aVar.getType() == bl.YP) {
                    aVar.setOnAdapterItemClickListener(hVar);
                }
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.a.q
    public void setForumName(String str) {
        if (this.mAdapters != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.mAdapters) {
                if (aVar instanceof com.baidu.tieba.card.v) {
                    ((com.baidu.tieba.card.v) aVar).setForumName(str);
                }
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.a.q
    public void cH(boolean z) {
        if (this.mAdapters != null && this.mAdapters.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.mAdapters) {
                if (aVar instanceof com.baidu.tieba.frs.d) {
                    ((com.baidu.tieba.frs.d) aVar).cH(z);
                }
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.a.q
    public void reInit() {
        if (this.mAdapters != null && this.mAdapters.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.mAdapters) {
                if (aVar instanceof com.baidu.tieba.frs.d) {
                    ((com.baidu.tieba.frs.d) aVar).a(this.cjg.getPageContext(), this.cjg.getUniqueId());
                }
            }
            aH(this.mAdapters);
        }
    }

    private void agM() {
        if (this.cmf != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.mAdapters) {
                if (aVar instanceof com.baidu.tieba.frs.f.c) {
                    com.baidu.tieba.frs.f.c cVar = (com.baidu.tieba.frs.f.c) aVar;
                    if (com.baidu.tieba.frs.f.c.cut != null) {
                        if (this.cmf.gef == 1) {
                            com.baidu.tieba.frs.f.c.cut.cuj = true;
                        } else {
                            com.baidu.tieba.frs.f.c.cut.cuj = false;
                        }
                        if (this.cmf.aOW() != null) {
                            com.baidu.tieba.frs.f.c.cut.cul = this.cmf.aOW().getId();
                        }
                        if (this.cjg != null && this.cjg.aeP() != null) {
                            com.baidu.tieba.frs.f.c.cut.cuk = this.cjg.aeP().ais();
                        }
                    }
                }
            }
            agN();
        }
    }

    private void agN() {
        com.baidu.tieba.frs.f.a aVar = new com.baidu.tieba.frs.f.a();
        if (this.cmf.gef == 1) {
            aVar.cuj = true;
        } else {
            aVar.cuj = false;
        }
        if (this.cmf.aOW() != null) {
            aVar.cul = this.cmf.aOW().getId();
        }
        if (this.cjg != null && this.cjg.aeP() != null) {
            aVar.cuk = this.cjg.aeP().ais();
        }
        com.baidu.tieba.frs.d.b bVar = new com.baidu.tieba.frs.d.b(aVar);
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

    @Override // com.baidu.tieba.frs.entelechy.a.q
    public List<com.baidu.adp.widget.ListView.f> getDatas() {
        if (this.mListView != null) {
            return this.mListView.getData();
        }
        return null;
    }

    private void J(ArrayList<com.baidu.adp.widget.ListView.f> arrayList) {
        int i;
        if (this.mAdapters != null && this.mAdapters.size() != 0) {
            int i2 = 0;
            if (arrayList == null || arrayList.size() <= 0) {
                i = 0;
            } else {
                Iterator<com.baidu.adp.widget.ListView.f> it = arrayList.iterator();
                while (true) {
                    i = i2;
                    if (!it.hasNext() || it.next().getType().getId() != bl.XD.getId()) {
                        break;
                    }
                    i2 = i + 1;
                }
            }
            for (com.baidu.adp.widget.ListView.a aVar : this.mAdapters) {
                if (aVar instanceof com.baidu.tieba.frs.d) {
                    ((com.baidu.tieba.frs.d) aVar).iz(i);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aH(List<com.baidu.adp.widget.ListView.a> list) {
        if (list != null) {
            for (com.baidu.adp.widget.ListView.a aVar : list) {
                if (aVar instanceof com.baidu.tieba.frs.d) {
                    ((com.baidu.tieba.frs.d) aVar).a(this.chy);
                }
            }
        }
    }
}
