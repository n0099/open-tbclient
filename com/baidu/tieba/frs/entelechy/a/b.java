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
import com.baidu.tbadk.core.data.av;
import com.baidu.tbadk.core.data.aw;
import com.baidu.tbadk.core.data.bh;
import com.baidu.tbadk.core.data.z;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.coreExtra.message.UpdateAttentionMessage;
import com.baidu.tieba.card.data.CardHListViewData;
import com.baidu.tieba.d;
import com.baidu.tieba.frs.AbsDelegateAdapterList;
import com.baidu.tieba.frs.k;
import com.baidu.tieba.frs.n;
import com.baidu.tieba.frs.w;
import com.baidu.tieba.lego.card.model.ICardInfo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public class b implements r {
    private ArrayList<com.baidu.adp.widget.ListView.f> abL;
    private com.baidu.tieba.frs.f crw;
    private l cvA;
    private c cvB;
    private com.baidu.adp.widget.ListView.a cvC;
    private n cvD;
    private q cvE;
    private g cvF;
    private com.baidu.adp.widget.ListView.a cvG;
    private com.baidu.adp.widget.ListView.a cvH;
    private d cvI;
    private d cvJ;
    private com.baidu.tieba.frs.j cvK;
    private com.baidu.tieba.frs.i.a cvL;
    private List<com.baidu.adp.widget.ListView.a> cvM;
    private m cvN;
    private i cvO;
    private h cvP;
    private p cvQ;
    private final HashMap<Integer, bh> cvR;
    private com.baidu.tieba.tbadkCore.i cvS;
    private l cvy;
    private j cvz;
    private BdTypeListView mListView;
    private List<com.baidu.adp.widget.ListView.a> mAdapters = new LinkedList();
    private boolean cvT = false;
    private CustomMessageListener cvU = new CustomMessageListener(CmdConfigCustom.CMD_FRS_ADD_ADAPTER) { // from class: com.baidu.tieba.frs.entelechy.a.b.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2003008 && (customResponsedMessage.getData() instanceof AbsDelegateAdapterList)) {
                AbsDelegateAdapterList absDelegateAdapterList = (AbsDelegateAdapterList) customResponsedMessage.getData();
                Iterator it = absDelegateAdapterList.iterator();
                while (it.hasNext()) {
                    com.baidu.adp.widget.ListView.a aVar = (com.baidu.adp.widget.ListView.a) it.next();
                    if (aVar instanceof com.baidu.tieba.frs.d) {
                        ((com.baidu.tieba.frs.d) aVar).a(b.this.crw.getPageContext(), b.this.crw.getUniqueId());
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
    private CustomMessageListener cvV = new CustomMessageListener(CmdConfigCustom.CMD_LEGO_REGISTER) { // from class: com.baidu.tieba.frs.entelechy.a.b.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && v.u(b.this.cvM)) {
                b.this.aiX();
                b.this.b(b.this.abL, b.this.cvS);
            }
        }
    };
    private CustomMessageListener aoH = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.frs.entelechy.a.b.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
            if (updateAttentionMessage != null && updateAttentionMessage.getData() != null && updateAttentionMessage.getData().BZ) {
                b.this.P(updateAttentionMessage.getData());
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
                bVar.dXE = true;
                b.this.P(bVar);
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
                bVar.dXE = false;
                b.this.P(bVar);
            }
        }
    };
    private CustomMessageListener cvW = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ADCARD) { // from class: com.baidu.tieba.frs.entelechy.a.b.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.data.h)) {
                b.this.Q((com.baidu.tbadk.data.h) customResponsedMessage.getData());
            }
        }
    };
    private final com.baidu.tieba.frs.c cpQ = new com.baidu.tieba.frs.c();

    public b(com.baidu.tieba.frs.f fVar, BdTypeListView bdTypeListView, boolean z) {
        this.mListView = bdTypeListView;
        a(fVar, bdTypeListView);
        this.cvR = new HashMap<>();
        eR(z);
    }

    public void a(com.baidu.tieba.frs.f fVar, BdTypeListView bdTypeListView) {
        this.crw = fVar;
        this.cvy = new l(fVar.getPageContext(), bh.XW, this.crw.getUniqueId());
        this.cvy.setVoiceManager(fVar.getVoiceManager());
        this.cvz = new j(fVar.getPageContext(), bh.XX, this.crw.getUniqueId());
        this.cvA = new l(fVar.getPageContext(), bh.XY, this.crw.getUniqueId());
        this.cvA.setVoiceManager(fVar.getVoiceManager());
        this.cvE = new q(fVar.getPageContext(), bh.XZ, this.crw.getUniqueId());
        this.cvF = new g(fVar.getPageContext(), bh.Yd, this.crw.getUniqueId());
        this.cvB = new c(fVar.getPageContext(), av.Xt, this.crw.getUniqueId());
        this.cvC = com.baidu.tieba.frs.a.ags().a(fVar.getPageContext(), com.baidu.tieba.tbadkCore.p.gfn, this.crw.getUniqueId(), false);
        this.cvK = new com.baidu.tieba.frs.j(fVar.getPageContext(), k.csb);
        this.cvD = new n(fVar.getPageContext(), aw.Xw);
        this.cvI = new d(fVar.getPageContext(), bh.Yh, this.crw.getUniqueId());
        this.cvJ = new d(fVar.getPageContext(), bh.Yi, this.crw.getUniqueId());
        this.cvG = com.baidu.tieba.frs.a.ags().a(fVar.getPageContext(), bh.Zg, this.crw.getUniqueId(), false);
        this.cvH = com.baidu.tieba.frs.a.ags().b(fVar.getPageContext(), bh.Zl, this.crw.getUniqueId());
        this.cvL = new com.baidu.tieba.frs.i.a(fVar.getPageContext(), z.Wf, this.crw.getUniqueId());
        this.cvN = new m(fVar.getPageContext(), com.baidu.tieba.frs.p.csD);
        this.cvO = new i(fVar.getPageContext(), bh.Yj, this.crw.getUniqueId());
        this.cvP = new h(fVar.getPageContext(), CardHListViewData.TYPE);
        this.cvQ = new p(fVar.getPageContext(), com.baidu.tieba.frs.q.csJ, this.crw.getUniqueId());
        this.mAdapters.add(this.cvP);
        this.mAdapters.add(this.cvy);
        this.mAdapters.add(this.cvz);
        this.mAdapters.add(this.cvA);
        this.mAdapters.add(this.cvQ);
        com.baidu.tieba.InjectPlugin.b.b bVar = new com.baidu.tieba.InjectPlugin.b.b(this.crw, 1);
        bVar.setExtraData(this.mAdapters);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_FEED_AD_PLUGIN_OPERATE, bVar));
        this.mAdapters.add(this.cvB);
        this.mAdapters.add(this.cvO);
        if (this.cvC != null) {
            this.mAdapters.add(this.cvC);
        }
        this.mAdapters.add(this.cvK);
        this.mAdapters.add(this.cvE);
        this.mAdapters.add(this.cvF);
        this.mAdapters.add(this.cvD);
        this.mAdapters.add(this.cvI);
        this.mAdapters.add(this.cvJ);
        this.mAdapters.add(new com.baidu.tieba.frs.v(this.crw.getPageContext(), w.csX));
        this.mAdapters.add(this.cvG);
        if (this.cvH != null) {
            this.mAdapters.add(this.cvH);
        }
        this.mAdapters.add(this.cvL);
        this.mAdapters.add(this.cvN);
        com.baidu.adp.widget.ListView.a<? extends bh, ? extends j.a> b = com.baidu.tieba.frs.a.ags().b(this.crw.getPageContext(), bh.Zf, this.crw.getUniqueId());
        if (b != null) {
            this.mAdapters.add(b);
        }
        this.cvU.setPriority(1);
        this.cvU.setSelfListener(true);
        this.crw.registerListener(this.cvU);
        this.crw.registerListener(this.aoH);
        this.crw.registerListener(this.mLikeForumListener);
        this.crw.registerListener(this.mUnlikeForumListener);
        this.crw.registerListener(this.cvW);
        aiW();
        CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_ADD_ADAPTER, new AbsDelegateAdapterList());
        CustomMessage customMessage = new CustomMessage(CmdConfigCustom.CMD_FRS_ADD_ADAPTER);
        customMessage.setTag(this.crw.getUniqueId());
        customResponsedMessage.setOrginalMessage(customMessage);
        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
        aL(this.mAdapters);
        bdTypeListView.addAdapters(this.mAdapters);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void P(Object obj) {
        boolean z;
        boolean z2 = false;
        if (this.abL != null) {
            Iterator<com.baidu.adp.widget.ListView.f> it = this.abL.iterator();
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
    public void Q(Object obj) {
        if (this.abL != null) {
            Iterator<com.baidu.adp.widget.ListView.f> it = this.abL.iterator();
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

    private void aiW() {
        if (this.crw != null && !aiX()) {
            this.crw.registerListener(this.cvV);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aiX() {
        if (this.crw == null) {
            return false;
        }
        this.cvM = new ArrayList();
        ArrayList<BdUniqueId> bqz = com.baidu.tieba.tbadkCore.n.bqz();
        if (bqz == null || bqz.size() <= 0) {
            return false;
        }
        int size = bqz.size();
        for (int i = 0; i < size; i++) {
            com.baidu.tieba.frs.d<ICardInfo, ? extends j.a> a = com.baidu.tieba.frs.a.ags().a(this.crw.getPageContext(), bqz.get(i), this.crw.getUniqueId());
            if (a != null) {
                this.mAdapters.add(a);
                this.cvM.add(a);
            }
        }
        if (!v.u(this.cvM)) {
            this.mListView.addAdapters(this.cvM);
        }
        return true;
    }

    @Override // com.baidu.tieba.frs.entelechy.a.r
    public void onDestory() {
        for (com.baidu.adp.widget.ListView.a aVar : this.mAdapters) {
            if (aVar instanceof com.baidu.tieba.frs.d) {
                ((com.baidu.tieba.frs.d) aVar).release();
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.a.r
    public void b(ArrayList<com.baidu.adp.widget.ListView.f> arrayList, com.baidu.tieba.tbadkCore.i iVar) {
        a(iVar);
        com.baidu.tieba.tbadkCore.n.p(arrayList, 1);
        I(arrayList);
        J(arrayList);
        H(arrayList);
        this.mListView.setData(arrayList);
        this.cvS = iVar;
        ajf();
        this.abL = arrayList;
    }

    private void H(ArrayList<com.baidu.adp.widget.ListView.f> arrayList) {
        int t = v.t(arrayList);
        for (int i = 0; i < t; i++) {
            com.baidu.adp.widget.ListView.f fVar = (com.baidu.adp.widget.ListView.f) v.c(arrayList, i - 1);
            com.baidu.adp.widget.ListView.f fVar2 = (com.baidu.adp.widget.ListView.f) v.c(arrayList, i);
            if (fVar2 instanceof bh) {
                bh bhVar = (bh) fVar2;
                if (i == 0) {
                    bhVar.isFirstFloor = true;
                } else {
                    bhVar.isFirstFloor = false;
                }
                String rM = bhVar.rM();
                if (fVar instanceof com.baidu.tieba.frs.p) {
                    bhVar.needTopMargin = false;
                } else if (fVar != null && !e(fVar)) {
                    bhVar.needTopMargin = false;
                } else if ((fVar instanceof bh) && e(fVar) && !TextUtils.isEmpty(((bh) fVar).rM())) {
                    bhVar.needTopMargin = true;
                } else if (e(fVar2) && !TextUtils.isEmpty(rM)) {
                    bhVar.needTopMargin = true;
                } else {
                    bhVar.needTopMargin = false;
                }
            }
        }
    }

    private boolean e(com.baidu.adp.widget.ListView.f fVar) {
        if (fVar == null) {
            return false;
        }
        BdUniqueId type = fVar.getType();
        return type == bh.XW || type == bh.XY || type == bh.XZ || type == bh.Yd || type == bh.Yj || type == av.Xt || type == bh.Yh || type == bh.Yi;
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
                if (this.cvR != null && !this.cvR.containsValue(fVar)) {
                    this.cvR.put(Integer.valueOf(i2), (bh) fVar);
                }
            }
            i = i2 + 1;
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.a.r
    public void eR(boolean z) {
        if (this.cvT != z) {
            this.cvT = z;
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.a.r
    public HashMap<Integer, bh> aiY() {
        return this.cvR;
    }

    @Override // com.baidu.tieba.frs.entelechy.a.r
    public void aiZ() {
        if (this.mListView != null && this.mListView.getData() != null && this.mListView.getData().size() != 0) {
            for (com.baidu.adp.widget.ListView.f fVar : this.mListView.getData()) {
                if ((fVar instanceof bh) && ((bh) fVar).rj() != 0) {
                    ((bh) fVar).rW();
                }
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.a.r
    public void notifyDataSetChanged() {
        if (this.mListView.getAdapter() instanceof com.baidu.adp.widget.ListView.d) {
            ((com.baidu.adp.widget.ListView.d) this.mListView.getAdapter()).notifyDataSetChanged();
        }
    }

    public void YR() {
        if (this.mListView.getAdapter() instanceof com.baidu.adp.widget.ListView.d) {
            if (this.abL != null) {
                this.mListView.setData(this.abL);
            }
            ((com.baidu.adp.widget.ListView.d) this.mListView.getAdapter()).notifyDataSetChanged();
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.a.r
    public void setFromCDN(boolean z) {
        if (this.mAdapters != null && this.mAdapters.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.mAdapters) {
                if (aVar instanceof com.baidu.tieba.frs.d) {
                    ((com.baidu.tieba.frs.d) aVar).setFromCDN(z);
                }
            }
            if (this.cvy != null) {
                this.cvy.setFromCDN(z);
            }
            if (this.cvA != null) {
                this.cvA.setFromCDN(z);
            }
            if (this.cvI != null) {
                this.cvI.setFromCDN(z);
            }
            if (this.cvJ != null) {
                this.cvJ.setFromCDN(z);
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

    @Override // com.baidu.tieba.frs.entelechy.a.r
    public void a(com.baidu.tieba.frs.b bVar) {
        if (this.mAdapters != null && this.mAdapters.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.mAdapters) {
                if (aVar instanceof com.baidu.tieba.frs.d) {
                    ((com.baidu.tieba.frs.d) aVar).a(bVar);
                }
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.a.r
    public int aja() {
        if (this.cvC != null) {
            return d.h.frs_fortune_bag_item;
        }
        return 0;
    }

    @Override // com.baidu.tieba.frs.entelechy.a.r
    public int ajb() {
        if (this.cvC != null) {
            return d.h.frs_my_service_item;
        }
        return 0;
    }

    @Override // com.baidu.tieba.frs.entelechy.a.r
    public int ajc() {
        if (this.cvC != null) {
            return d.h.frs_bawu_center;
        }
        return 0;
    }

    @Override // com.baidu.tieba.frs.entelechy.a.r
    public int ajd() {
        if (this.cvD != null) {
            return this.cvD.ahR();
        }
        return 0;
    }

    @Override // com.baidu.tieba.frs.entelechy.a.r
    public int ahS() {
        if (this.cvD != null) {
            return this.cvD.ahS();
        }
        return 0;
    }

    @Override // com.baidu.tieba.frs.entelechy.a.r
    public boolean l(BdUniqueId bdUniqueId) {
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

    @Override // com.baidu.tieba.frs.entelechy.a.r
    public void setOnAdapterItemClickListener(com.baidu.adp.widget.ListView.h hVar) {
        if (this.mAdapters != null && this.mAdapters.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.mAdapters) {
                if (aVar instanceof com.baidu.tieba.frs.d) {
                    ((com.baidu.tieba.frs.d) aVar).setOnAdapterItemClickListener(hVar);
                } else if ((aVar instanceof l) || (aVar instanceof c) || (aVar instanceof f) || (aVar instanceof d) || (aVar instanceof q)) {
                    aVar.setOnAdapterItemClickListener(hVar);
                } else if (aVar != null && aVar.getType() == bh.Zf) {
                    aVar.setOnAdapterItemClickListener(hVar);
                }
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.a.r
    public void setForumName(String str) {
        if (this.mAdapters != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.mAdapters) {
                if (aVar instanceof com.baidu.tieba.card.v) {
                    ((com.baidu.tieba.card.v) aVar).setForumName(str);
                }
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.a.r
    public void cI(boolean z) {
        if (this.mAdapters != null && this.mAdapters.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.mAdapters) {
                if (aVar instanceof com.baidu.tieba.frs.d) {
                    ((com.baidu.tieba.frs.d) aVar).cI(z);
                }
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.a.r
    public void aje() {
        if (this.mAdapters != null && this.mAdapters.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.mAdapters) {
                if (aVar instanceof com.baidu.tieba.frs.d) {
                    ((com.baidu.tieba.frs.d) aVar).a(this.crw.getPageContext(), this.crw.getUniqueId());
                }
            }
            aL(this.mAdapters);
        }
    }

    private void ajf() {
        if (this.cvS != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.mAdapters) {
                if (aVar instanceof com.baidu.tieba.frs.f.c) {
                    com.baidu.tieba.frs.f.c cVar = (com.baidu.tieba.frs.f.c) aVar;
                    if (com.baidu.tieba.frs.f.c.cFQ != null) {
                        if (this.cvS.gdW == 1) {
                            com.baidu.tieba.frs.f.c.cFQ.cFG = true;
                        } else {
                            com.baidu.tieba.frs.f.c.cFQ.cFG = false;
                        }
                        if (this.cvS.aMU() != null) {
                            com.baidu.tieba.frs.f.c.cFQ.cFI = this.cvS.aMU().getId();
                        }
                        if (this.crw != null && this.crw.agK() != null) {
                            com.baidu.tieba.frs.f.c.cFQ.cFH = this.crw.agK().akY();
                        }
                    }
                }
            }
            ajg();
        }
    }

    private void ajg() {
        com.baidu.tieba.frs.f.a aVar = new com.baidu.tieba.frs.f.a();
        if (this.cvS.gdW == 1) {
            aVar.cFG = true;
        } else {
            aVar.cFG = false;
        }
        if (this.cvS.aMU() != null) {
            aVar.cFI = this.cvS.aMU().getId();
        }
        if (this.crw != null && this.crw.agK() != null) {
            aVar.cFH = this.crw.agK().akY();
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

    @Override // com.baidu.tieba.frs.entelechy.a.r
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
                    if (!it.hasNext() || it.next().getType().getId() != bh.XV.getId()) {
                        break;
                    }
                    i2 = i + 1;
                }
            }
            for (com.baidu.adp.widget.ListView.a aVar : this.mAdapters) {
                if (aVar instanceof com.baidu.tieba.frs.d) {
                    ((com.baidu.tieba.frs.d) aVar).iW(i);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aL(List<com.baidu.adp.widget.ListView.a> list) {
        if (list != null) {
            for (com.baidu.adp.widget.ListView.a aVar : list) {
                if (aVar instanceof com.baidu.tieba.frs.d) {
                    ((com.baidu.tieba.frs.d) aVar).a(this.cpQ);
                }
            }
        }
    }
}
