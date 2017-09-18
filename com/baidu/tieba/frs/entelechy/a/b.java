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
    private com.baidu.tieba.frs.f crm;
    private l cvd;
    private j cve;
    private l cvf;
    private c cvg;
    private com.baidu.adp.widget.ListView.a cvh;
    private n cvi;
    private p cvj;
    private g cvk;
    private com.baidu.adp.widget.ListView.a cvl;
    private com.baidu.adp.widget.ListView.a cvm;
    private d cvn;
    private d cvo;
    private com.baidu.tieba.frs.j cvp;
    private com.baidu.tieba.frs.i.a cvq;
    private List<com.baidu.adp.widget.ListView.a> cvr;
    private m cvs;
    private i cvt;
    private h cvu;
    private final HashMap<Integer, bj> cvv;
    private com.baidu.tieba.tbadkCore.i cvw;
    private BdTypeListView mListView;
    private List<com.baidu.adp.widget.ListView.a> mAdapters = new LinkedList();
    private boolean cvx = false;
    private CustomMessageListener cvy = new CustomMessageListener(CmdConfigCustom.CMD_FRS_ADD_ADAPTER) { // from class: com.baidu.tieba.frs.entelechy.a.b.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2003008 && (customResponsedMessage.getData() instanceof AbsDelegateAdapterList)) {
                AbsDelegateAdapterList absDelegateAdapterList = (AbsDelegateAdapterList) customResponsedMessage.getData();
                Iterator it = absDelegateAdapterList.iterator();
                while (it.hasNext()) {
                    com.baidu.adp.widget.ListView.a aVar = (com.baidu.adp.widget.ListView.a) it.next();
                    if (aVar instanceof com.baidu.tieba.frs.d) {
                        ((com.baidu.tieba.frs.d) aVar).a(b.this.crm.getPageContext(), b.this.crm.getUniqueId());
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
    private CustomMessageListener cvz = new CustomMessageListener(CmdConfigCustom.CMD_LEGO_REGISTER) { // from class: com.baidu.tieba.frs.entelechy.a.b.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && v.v(b.this.cvr)) {
                b.this.aiY();
                b.this.b(b.this.abW, b.this.cvw);
            }
        }
    };
    private CustomMessageListener apK = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.frs.entelechy.a.b.3
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
                bVar.ebJ = true;
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
                bVar.ebJ = false;
                b.this.Q(bVar);
            }
        }
    };
    private CustomMessageListener cvA = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ADCARD) { // from class: com.baidu.tieba.frs.entelechy.a.b.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.data.i)) {
                b.this.R((com.baidu.tbadk.data.i) customResponsedMessage.getData());
            }
        }
    };
    private final com.baidu.tieba.frs.c cpD = new com.baidu.tieba.frs.c();

    public b(com.baidu.tieba.frs.f fVar, BdTypeListView bdTypeListView, boolean z) {
        this.mListView = bdTypeListView;
        a(fVar, bdTypeListView);
        this.cvv = new HashMap<>();
        eZ(z);
    }

    public void a(com.baidu.tieba.frs.f fVar, BdTypeListView bdTypeListView) {
        this.crm = fVar;
        this.cvd = new l(fVar.getPageContext(), bj.Yh, this.crm.getUniqueId());
        this.cvd.setVoiceManager(fVar.getVoiceManager());
        this.cve = new j(fVar.getPageContext(), bj.Yi, this.crm.getUniqueId());
        this.cvf = new l(fVar.getPageContext(), bj.Yj, this.crm.getUniqueId());
        this.cvf.setVoiceManager(fVar.getVoiceManager());
        this.cvj = new p(fVar.getPageContext(), bj.Yk, this.crm.getUniqueId());
        this.cvk = new g(fVar.getPageContext(), bj.Yo, this.crm.getUniqueId());
        this.cvg = new c(fVar.getPageContext(), ax.XE, this.crm.getUniqueId());
        this.cvh = com.baidu.tieba.frs.a.agA().a(fVar.getPageContext(), com.baidu.tieba.tbadkCore.p.ghU, this.crm.getUniqueId(), false);
        this.cvp = new com.baidu.tieba.frs.j(fVar.getPageContext(), k.crQ);
        this.cvi = new n(fVar.getPageContext(), ay.XH);
        this.cvn = new d(fVar.getPageContext(), bj.Ys, this.crm.getUniqueId());
        this.cvo = new d(fVar.getPageContext(), bj.Yt, this.crm.getUniqueId());
        this.cvl = com.baidu.tieba.frs.a.agA().a(fVar.getPageContext(), bj.Zs, this.crm.getUniqueId(), false);
        this.cvm = com.baidu.tieba.frs.a.agA().b(fVar.getPageContext(), bj.Zx, this.crm.getUniqueId());
        this.cvq = new com.baidu.tieba.frs.i.a(fVar.getPageContext(), z.Wd, this.crm.getUniqueId());
        this.cvs = new m(fVar.getPageContext(), com.baidu.tieba.frs.p.css);
        this.cvt = new i(fVar.getPageContext(), bj.Yu, this.crm.getUniqueId());
        this.cvu = new h(fVar.getPageContext(), CardHListViewData.TYPE);
        this.mAdapters.add(this.cvu);
        this.mAdapters.add(this.cvd);
        this.mAdapters.add(this.cve);
        this.mAdapters.add(this.cvf);
        com.baidu.tieba.InjectPlugin.b.b bVar = new com.baidu.tieba.InjectPlugin.b.b(this.crm, 1);
        bVar.setExtraData(this.mAdapters);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_FEED_AD_PLUGIN_OPERATE, bVar));
        this.mAdapters.add(this.cvg);
        this.mAdapters.add(this.cvt);
        if (this.cvh != null) {
            this.mAdapters.add(this.cvh);
        }
        this.mAdapters.add(this.cvp);
        this.mAdapters.add(this.cvj);
        this.mAdapters.add(this.cvk);
        this.mAdapters.add(this.cvi);
        this.mAdapters.add(this.cvn);
        this.mAdapters.add(this.cvo);
        this.mAdapters.add(new u(this.crm.getPageContext(), com.baidu.tieba.frs.v.csH));
        this.mAdapters.add(this.cvl);
        if (this.cvm != null) {
            this.mAdapters.add(this.cvm);
        }
        this.mAdapters.add(this.cvq);
        this.mAdapters.add(this.cvs);
        com.baidu.adp.widget.ListView.a<? extends bj, ? extends j.a> b = com.baidu.tieba.frs.a.agA().b(this.crm.getPageContext(), bj.Zr, this.crm.getUniqueId());
        if (b != null) {
            this.mAdapters.add(b);
        }
        this.cvy.setPriority(1);
        this.cvy.setSelfListener(true);
        this.crm.registerListener(this.cvy);
        this.crm.registerListener(this.apK);
        this.crm.registerListener(this.mLikeForumListener);
        this.crm.registerListener(this.mUnlikeForumListener);
        this.crm.registerListener(this.cvA);
        aiX();
        CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_ADD_ADAPTER, new AbsDelegateAdapterList());
        CustomMessage customMessage = new CustomMessage(CmdConfigCustom.CMD_FRS_ADD_ADAPTER);
        customMessage.setTag(this.crm.getUniqueId());
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

    private void aiX() {
        if (this.crm != null && !aiY()) {
            this.crm.registerListener(this.cvz);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aiY() {
        if (this.crm == null) {
            return false;
        }
        this.cvr = new ArrayList();
        ArrayList<BdUniqueId> brJ = com.baidu.tieba.tbadkCore.n.brJ();
        if (brJ == null || brJ.size() <= 0) {
            return false;
        }
        int size = brJ.size();
        for (int i = 0; i < size; i++) {
            com.baidu.tieba.frs.d<ICardInfo, ? extends j.a> a = com.baidu.tieba.frs.a.agA().a(this.crm.getPageContext(), brJ.get(i), this.crm.getUniqueId());
            if (a != null) {
                this.mAdapters.add(a);
                this.cvr.add(a);
            }
        }
        if (!v.v(this.cvr)) {
            this.mListView.addAdapters(this.cvr);
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
        this.cvw = iVar;
        ajg();
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
                if (this.cvv != null && !this.cvv.containsValue(fVar)) {
                    this.cvv.put(Integer.valueOf(i2), (bj) fVar);
                }
            }
            i = i2 + 1;
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.a.q
    public void eZ(boolean z) {
        if (this.cvx != z) {
            this.cvx = z;
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.a.q
    public HashMap<Integer, bj> aiZ() {
        return this.cvv;
    }

    @Override // com.baidu.tieba.frs.entelechy.a.q
    public void aja() {
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

    public void Zm() {
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
            if (this.cvd != null) {
                this.cvd.setFromCDN(z);
            }
            if (this.cvf != null) {
                this.cvf.setFromCDN(z);
            }
            if (this.cvn != null) {
                this.cvn.setFromCDN(z);
            }
            if (this.cvo != null) {
                this.cvo.setFromCDN(z);
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
    public int ajb() {
        if (this.cvh != null) {
            return d.h.frs_fortune_bag_item;
        }
        return 0;
    }

    @Override // com.baidu.tieba.frs.entelechy.a.q
    public int ajc() {
        if (this.cvh != null) {
            return d.h.frs_my_service_item;
        }
        return 0;
    }

    @Override // com.baidu.tieba.frs.entelechy.a.q
    public int ajd() {
        if (this.cvh != null) {
            return d.h.frs_bawu_center;
        }
        return 0;
    }

    @Override // com.baidu.tieba.frs.entelechy.a.q
    public int aje() {
        if (this.cvi != null) {
            return this.cvi.aia();
        }
        return 0;
    }

    @Override // com.baidu.tieba.frs.entelechy.a.q
    public int aib() {
        if (this.cvi != null) {
            return this.cvi.aib();
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
    public void ajf() {
        if (this.mAdapters != null && this.mAdapters.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.mAdapters) {
                if (aVar instanceof com.baidu.tieba.frs.d) {
                    ((com.baidu.tieba.frs.d) aVar).a(this.crm.getPageContext(), this.crm.getUniqueId());
                }
            }
            aL(this.mAdapters);
        }
    }

    private void ajg() {
        if (this.cvw != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.mAdapters) {
                if (aVar instanceof com.baidu.tieba.frs.f.c) {
                    com.baidu.tieba.frs.f.c cVar = (com.baidu.tieba.frs.f.c) aVar;
                    if (com.baidu.tieba.frs.f.c.cFj != null) {
                        if (this.cvw.ggE == 1) {
                            com.baidu.tieba.frs.f.c.cFj.cEZ = true;
                        } else {
                            com.baidu.tieba.frs.f.c.cFj.cEZ = false;
                        }
                        if (this.cvw.aPg() != null) {
                            com.baidu.tieba.frs.f.c.cFj.cFb = this.cvw.aPg().getId();
                        }
                        if (this.crm != null && this.crm.agT() != null) {
                            com.baidu.tieba.frs.f.c.cFj.cFa = this.crm.agT().akZ();
                        }
                    }
                }
            }
            ajh();
        }
    }

    private void ajh() {
        com.baidu.tieba.frs.f.a aVar = new com.baidu.tieba.frs.f.a();
        if (this.cvw.ggE == 1) {
            aVar.cEZ = true;
        } else {
            aVar.cEZ = false;
        }
        if (this.cvw.aPg() != null) {
            aVar.cFb = this.cvw.aPg().getId();
        }
        if (this.crm != null && this.crm.agT() != null) {
            aVar.cFa = this.crm.agT().akZ();
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
                    ((com.baidu.tieba.frs.d) aVar).iP(i);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aL(List<com.baidu.adp.widget.ListView.a> list) {
        if (list != null) {
            for (com.baidu.adp.widget.ListView.a aVar : list) {
                if (aVar instanceof com.baidu.tieba.frs.d) {
                    ((com.baidu.tieba.frs.d) aVar).a(this.cpD);
                }
            }
        }
    }
}
