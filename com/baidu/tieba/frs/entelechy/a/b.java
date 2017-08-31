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
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.data.z;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.coreExtra.message.UpdateAttentionMessage;
import com.baidu.tieba.card.data.CardHListViewData;
import com.baidu.tieba.d;
import com.baidu.tieba.frs.AbsDelegateAdapterList;
import com.baidu.tieba.frs.k;
import com.baidu.tieba.frs.n;
import com.baidu.tieba.frs.u;
import com.baidu.tieba.lego.card.model.ICardInfo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public class b implements q {
    private ArrayList<com.baidu.adp.widget.ListView.f> abW;
    private com.baidu.tieba.frs.f cqt;
    private m cuA;
    private i cuB;
    private h cuC;
    private final HashMap<Integer, bj> cuD;
    private com.baidu.tieba.tbadkCore.i cuE;
    private l cul;
    private j cum;
    private l cun;
    private c cuo;
    private com.baidu.adp.widget.ListView.a cup;
    private n cuq;
    private p cur;
    private g cus;
    private com.baidu.adp.widget.ListView.a cut;
    private com.baidu.adp.widget.ListView.a cuu;
    private d cuv;
    private d cuw;
    private com.baidu.tieba.frs.j cux;
    private com.baidu.tieba.frs.i.a cuy;
    private List<com.baidu.adp.widget.ListView.a> cuz;
    private BdTypeListView mListView;
    private List<com.baidu.adp.widget.ListView.a> mAdapters = new LinkedList();
    private boolean cuF = false;
    private CustomMessageListener cuG = new CustomMessageListener(CmdConfigCustom.CMD_FRS_ADD_ADAPTER) { // from class: com.baidu.tieba.frs.entelechy.a.b.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2003008 && (customResponsedMessage.getData() instanceof AbsDelegateAdapterList)) {
                AbsDelegateAdapterList absDelegateAdapterList = (AbsDelegateAdapterList) customResponsedMessage.getData();
                Iterator it = absDelegateAdapterList.iterator();
                while (it.hasNext()) {
                    com.baidu.adp.widget.ListView.a aVar = (com.baidu.adp.widget.ListView.a) it.next();
                    if (aVar instanceof com.baidu.tieba.frs.d) {
                        ((com.baidu.tieba.frs.d) aVar).a(b.this.cqt.getPageContext(), b.this.cqt.getUniqueId());
                    }
                }
                ArrayList arrayList = new ArrayList();
                arrayList.addAll(absDelegateAdapterList);
                b.this.aL(arrayList);
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
    private CustomMessageListener cuH = new CustomMessageListener(CmdConfigCustom.CMD_LEGO_REGISTER) { // from class: com.baidu.tieba.frs.entelechy.a.b.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && v.v(b.this.cuz)) {
                b.this.aiN();
                b.this.b(b.this.abW, b.this.cuE);
            }
        }
    };
    private CustomMessageListener apM = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.frs.entelechy.a.b.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
            if (updateAttentionMessage != null && updateAttentionMessage.getData() != null && updateAttentionMessage.getData().BW) {
                b.this.Q(updateAttentionMessage.getData());
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
                bVar.eaP = true;
                b.this.Q(bVar);
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
                bVar.eaP = false;
                b.this.Q(bVar);
            }
        }
    };
    private CustomMessageListener cuI = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ADCARD) { // from class: com.baidu.tieba.frs.entelechy.a.b.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.data.i)) {
                b.this.R((com.baidu.tbadk.data.i) customResponsedMessage.getData());
            }
        }
    };
    private final com.baidu.tieba.frs.c coL = new com.baidu.tieba.frs.c();

    public b(com.baidu.tieba.frs.f fVar, BdTypeListView bdTypeListView, boolean z) {
        this.mListView = bdTypeListView;
        a(fVar, bdTypeListView);
        this.cuD = new HashMap<>();
        eY(z);
    }

    public void a(com.baidu.tieba.frs.f fVar, BdTypeListView bdTypeListView) {
        this.cqt = fVar;
        this.cul = new l(fVar.getPageContext(), bj.Yh, this.cqt.getUniqueId());
        this.cul.setVoiceManager(fVar.getVoiceManager());
        this.cum = new j(fVar.getPageContext(), bj.Yi, this.cqt.getUniqueId());
        this.cun = new l(fVar.getPageContext(), bj.Yj, this.cqt.getUniqueId());
        this.cun.setVoiceManager(fVar.getVoiceManager());
        this.cur = new p(fVar.getPageContext(), bj.Yk, this.cqt.getUniqueId());
        this.cus = new g(fVar.getPageContext(), bj.Yo, this.cqt.getUniqueId());
        this.cuo = new c(fVar.getPageContext(), ax.XE, this.cqt.getUniqueId());
        this.cup = com.baidu.tieba.frs.a.agp().a(fVar.getPageContext(), com.baidu.tieba.tbadkCore.p.gha, this.cqt.getUniqueId(), false);
        this.cux = new com.baidu.tieba.frs.j(fVar.getPageContext(), k.cqX);
        this.cuq = new n(fVar.getPageContext(), ay.XH);
        this.cuv = new d(fVar.getPageContext(), bj.Ys, this.cqt.getUniqueId());
        this.cuw = new d(fVar.getPageContext(), bj.Yt, this.cqt.getUniqueId());
        this.cut = com.baidu.tieba.frs.a.agp().a(fVar.getPageContext(), bj.Zs, this.cqt.getUniqueId(), false);
        this.cuu = com.baidu.tieba.frs.a.agp().b(fVar.getPageContext(), bj.Zx, this.cqt.getUniqueId());
        this.cuy = new com.baidu.tieba.frs.i.a(fVar.getPageContext(), z.Wd, this.cqt.getUniqueId());
        this.cuA = new m(fVar.getPageContext(), com.baidu.tieba.frs.p.crA);
        this.cuB = new i(fVar.getPageContext(), bj.Yu, this.cqt.getUniqueId());
        this.cuC = new h(fVar.getPageContext(), CardHListViewData.TYPE);
        this.mAdapters.add(this.cuC);
        this.mAdapters.add(this.cul);
        this.mAdapters.add(this.cum);
        this.mAdapters.add(this.cun);
        com.baidu.tieba.InjectPlugin.b.b bVar = new com.baidu.tieba.InjectPlugin.b.b(this.cqt, 1);
        bVar.setExtraData(this.mAdapters);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_FEED_AD_PLUGIN_OPERATE, bVar));
        this.mAdapters.add(this.cuo);
        this.mAdapters.add(this.cuB);
        if (this.cup != null) {
            this.mAdapters.add(this.cup);
        }
        this.mAdapters.add(this.cux);
        this.mAdapters.add(this.cur);
        this.mAdapters.add(this.cus);
        this.mAdapters.add(this.cuq);
        this.mAdapters.add(this.cuv);
        this.mAdapters.add(this.cuw);
        this.mAdapters.add(new u(this.cqt.getPageContext(), com.baidu.tieba.frs.v.crP));
        this.mAdapters.add(this.cut);
        if (this.cuu != null) {
            this.mAdapters.add(this.cuu);
        }
        this.mAdapters.add(this.cuy);
        this.mAdapters.add(this.cuA);
        com.baidu.adp.widget.ListView.a<? extends bj, ? extends j.a> b = com.baidu.tieba.frs.a.agp().b(this.cqt.getPageContext(), bj.Zr, this.cqt.getUniqueId());
        if (b != null) {
            this.mAdapters.add(b);
        }
        this.cuG.setPriority(1);
        this.cuG.setSelfListener(true);
        this.cqt.registerListener(this.cuG);
        this.cqt.registerListener(this.apM);
        this.cqt.registerListener(this.mLikeForumListener);
        this.cqt.registerListener(this.mUnlikeForumListener);
        this.cqt.registerListener(this.cuI);
        aiM();
        CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_ADD_ADAPTER, new AbsDelegateAdapterList());
        CustomMessage customMessage = new CustomMessage(CmdConfigCustom.CMD_FRS_ADD_ADAPTER);
        customMessage.setTag(this.cqt.getUniqueId());
        customResponsedMessage.setOrginalMessage(customMessage);
        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
        aL(this.mAdapters);
        bdTypeListView.addAdapters(this.mAdapters);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Q(Object obj) {
        boolean z;
        boolean z2 = false;
        if (this.abW != null) {
            Iterator<com.baidu.adp.widget.ListView.f> it = this.abW.iterator();
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
    public void R(Object obj) {
        if (this.abW != null) {
            Iterator<com.baidu.adp.widget.ListView.f> it = this.abW.iterator();
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

    private void aiM() {
        if (this.cqt != null && !aiN()) {
            this.cqt.registerListener(this.cuH);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aiN() {
        if (this.cqt == null) {
            return false;
        }
        this.cuz = new ArrayList();
        ArrayList<BdUniqueId> bry = com.baidu.tieba.tbadkCore.n.bry();
        if (bry == null || bry.size() <= 0) {
            return false;
        }
        int size = bry.size();
        for (int i = 0; i < size; i++) {
            com.baidu.tieba.frs.d<ICardInfo, ? extends j.a> a = com.baidu.tieba.frs.a.agp().a(this.cqt.getPageContext(), bry.get(i), this.cqt.getUniqueId());
            if (a != null) {
                this.mAdapters.add(a);
                this.cuz.add(a);
            }
        }
        if (!v.v(this.cuz)) {
            this.mListView.addAdapters(this.cuz);
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
        com.baidu.tieba.tbadkCore.n.p(arrayList, 1);
        I(arrayList);
        J(arrayList);
        H(arrayList);
        this.mListView.setData(arrayList);
        this.cuE = iVar;
        aiV();
        this.abW = arrayList;
    }

    private void H(ArrayList<com.baidu.adp.widget.ListView.f> arrayList) {
        int u = v.u(arrayList);
        for (int i = 0; i < u; i++) {
            com.baidu.adp.widget.ListView.f fVar = (com.baidu.adp.widget.ListView.f) v.c(arrayList, i - 1);
            com.baidu.adp.widget.ListView.f fVar2 = (com.baidu.adp.widget.ListView.f) v.c(arrayList, i);
            if (fVar2 instanceof bj) {
                bj bjVar = (bj) fVar2;
                if (i == 0) {
                    bjVar.isFirstFloor = true;
                } else {
                    bjVar.isFirstFloor = false;
                }
                String rZ = bjVar.rZ();
                if (fVar instanceof com.baidu.tieba.frs.p) {
                    bjVar.needTopMargin = false;
                } else if (fVar != null && !e(fVar)) {
                    bjVar.needTopMargin = false;
                } else if ((fVar instanceof bj) && e(fVar) && !TextUtils.isEmpty(((bj) fVar).rZ())) {
                    bjVar.needTopMargin = true;
                } else if (e(fVar2) && !TextUtils.isEmpty(rZ)) {
                    bjVar.needTopMargin = true;
                } else {
                    bjVar.needTopMargin = false;
                }
            }
        }
    }

    private boolean e(com.baidu.adp.widget.ListView.f fVar) {
        if (fVar == null) {
            return false;
        }
        BdUniqueId type = fVar.getType();
        return type == bj.Yh || type == bj.Yj || type == bj.Yk || type == bj.Yo || type == bj.Yu || type == ax.XE || type == bj.Ys || type == bj.Yt;
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
                if (this.cuD != null && !this.cuD.containsValue(fVar)) {
                    this.cuD.put(Integer.valueOf(i2), (bj) fVar);
                }
            }
            i = i2 + 1;
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.a.q
    public void eY(boolean z) {
        if (this.cuF != z) {
            this.cuF = z;
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.a.q
    public HashMap<Integer, bj> aiO() {
        return this.cuD;
    }

    @Override // com.baidu.tieba.frs.entelechy.a.q
    public void aiP() {
        if (this.mListView != null && this.mListView.getData() != null && this.mListView.getData().size() != 0) {
            for (com.baidu.adp.widget.ListView.f fVar : this.mListView.getData()) {
                if ((fVar instanceof bj) && ((bj) fVar).rw() != 0) {
                    ((bj) fVar).sj();
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

    public void Zb() {
        if (this.mListView.getAdapter() instanceof com.baidu.adp.widget.ListView.d) {
            if (this.abW != null) {
                this.mListView.setData(this.abW);
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
            if (this.cul != null) {
                this.cul.setFromCDN(z);
            }
            if (this.cun != null) {
                this.cun.setFromCDN(z);
            }
            if (this.cuv != null) {
                this.cuv.setFromCDN(z);
            }
            if (this.cuw != null) {
                this.cuw.setFromCDN(z);
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
    public int aiQ() {
        if (this.cup != null) {
            return d.h.frs_fortune_bag_item;
        }
        return 0;
    }

    @Override // com.baidu.tieba.frs.entelechy.a.q
    public int aiR() {
        if (this.cup != null) {
            return d.h.frs_my_service_item;
        }
        return 0;
    }

    @Override // com.baidu.tieba.frs.entelechy.a.q
    public int aiS() {
        if (this.cup != null) {
            return d.h.frs_bawu_center;
        }
        return 0;
    }

    @Override // com.baidu.tieba.frs.entelechy.a.q
    public int aiT() {
        if (this.cuq != null) {
            return this.cuq.ahP();
        }
        return 0;
    }

    @Override // com.baidu.tieba.frs.entelechy.a.q
    public int ahQ() {
        if (this.cuq != null) {
            return this.cuq.ahQ();
        }
        return 0;
    }

    @Override // com.baidu.tieba.frs.entelechy.a.q
    public boolean m(BdUniqueId bdUniqueId) {
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
                } else if (aVar != null && aVar.getType() == bj.Zr) {
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
    public void cK(boolean z) {
        if (this.mAdapters != null && this.mAdapters.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.mAdapters) {
                if (aVar instanceof com.baidu.tieba.frs.d) {
                    ((com.baidu.tieba.frs.d) aVar).cK(z);
                }
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.a.q
    public void aiU() {
        if (this.mAdapters != null && this.mAdapters.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.mAdapters) {
                if (aVar instanceof com.baidu.tieba.frs.d) {
                    ((com.baidu.tieba.frs.d) aVar).a(this.cqt.getPageContext(), this.cqt.getUniqueId());
                }
            }
            aL(this.mAdapters);
        }
    }

    private void aiV() {
        if (this.cuE != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.mAdapters) {
                if (aVar instanceof com.baidu.tieba.frs.f.c) {
                    com.baidu.tieba.frs.f.c cVar = (com.baidu.tieba.frs.f.c) aVar;
                    if (com.baidu.tieba.frs.f.c.cEr != null) {
                        if (this.cuE.gfK == 1) {
                            com.baidu.tieba.frs.f.c.cEr.cEh = true;
                        } else {
                            com.baidu.tieba.frs.f.c.cEr.cEh = false;
                        }
                        if (this.cuE.aOV() != null) {
                            com.baidu.tieba.frs.f.c.cEr.cEj = this.cuE.aOV().getId();
                        }
                        if (this.cqt != null && this.cqt.agI() != null) {
                            com.baidu.tieba.frs.f.c.cEr.cEi = this.cqt.agI().akO();
                        }
                    }
                }
            }
            aiW();
        }
    }

    private void aiW() {
        com.baidu.tieba.frs.f.a aVar = new com.baidu.tieba.frs.f.a();
        if (this.cuE.gfK == 1) {
            aVar.cEh = true;
        } else {
            aVar.cEh = false;
        }
        if (this.cuE.aOV() != null) {
            aVar.cEj = this.cuE.aOV().getId();
        }
        if (this.cqt != null && this.cqt.agI() != null) {
            aVar.cEi = this.cqt.agI().akO();
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
                    if (!it.hasNext() || it.next().getType().getId() != bj.Yg.getId()) {
                        break;
                    }
                    i2 = i + 1;
                }
            }
            for (com.baidu.adp.widget.ListView.a aVar : this.mAdapters) {
                if (aVar instanceof com.baidu.tieba.frs.d) {
                    ((com.baidu.tieba.frs.d) aVar).iN(i);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aL(List<com.baidu.adp.widget.ListView.a> list) {
        if (list != null) {
            for (com.baidu.adp.widget.ListView.a aVar : list) {
                if (aVar instanceof com.baidu.tieba.frs.d) {
                    ((com.baidu.tieba.frs.d) aVar).a(this.coL);
                }
            }
        }
    }
}
