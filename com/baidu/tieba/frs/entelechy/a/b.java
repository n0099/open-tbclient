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
    private ArrayList<com.baidu.adp.widget.ListView.f> acP;
    private com.baidu.tieba.frs.f cla;
    private l cnH;
    private j cnI;
    private l cnJ;
    private c cnK;
    private com.baidu.adp.widget.ListView.a cnL;
    private n cnM;
    private p cnN;
    private g cnO;
    private com.baidu.adp.widget.ListView.a cnP;
    private com.baidu.adp.widget.ListView.a cnQ;
    private d cnR;
    private d cnS;
    private com.baidu.tieba.frs.j cnT;
    private com.baidu.tieba.frs.h.a cnU;
    private List<com.baidu.adp.widget.ListView.a> cnV;
    private m cnW;
    private i cnX;
    private h cnY;
    private final HashMap<Integer, bl> cnZ;
    private com.baidu.tieba.tbadkCore.i coa;
    private BdTypeListView mListView;
    private List<com.baidu.adp.widget.ListView.a> mAdapters = new LinkedList();
    private boolean cob = false;
    private CustomMessageListener coc = new CustomMessageListener(CmdConfigCustom.CMD_FRS_ADD_ADAPTER) { // from class: com.baidu.tieba.frs.entelechy.a.b.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2003008 && (customResponsedMessage.getData() instanceof AbsDelegateAdapterList)) {
                AbsDelegateAdapterList absDelegateAdapterList = (AbsDelegateAdapterList) customResponsedMessage.getData();
                Iterator it = absDelegateAdapterList.iterator();
                while (it.hasNext()) {
                    com.baidu.adp.widget.ListView.a aVar = (com.baidu.adp.widget.ListView.a) it.next();
                    if (aVar instanceof com.baidu.tieba.frs.d) {
                        ((com.baidu.tieba.frs.d) aVar).a(b.this.cla.getPageContext(), b.this.cla.getUniqueId());
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
    private CustomMessageListener cod = new CustomMessageListener(CmdConfigCustom.CMD_LEGO_REGISTER) { // from class: com.baidu.tieba.frs.entelechy.a.b.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && u.v(b.this.cnV)) {
                b.this.ahb();
                b.this.b(b.this.acP, b.this.coa);
            }
        }
    };
    private CustomMessageListener aqh = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.frs.entelechy.a.b.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
            if (updateAttentionMessage != null && updateAttentionMessage.getData() != null && updateAttentionMessage.getData().Ec) {
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
                bVar.dUe = true;
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
                bVar.dUe = false;
                b.this.R(bVar);
            }
        }
    };
    private CustomMessageListener coe = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ADCARD) { // from class: com.baidu.tieba.frs.entelechy.a.b.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.data.i)) {
                b.this.S((com.baidu.tbadk.data.i) customResponsedMessage.getData());
            }
        }
    };
    private final com.baidu.tieba.frs.c cjs = new com.baidu.tieba.frs.c();

    public b(com.baidu.tieba.frs.f fVar, BdTypeListView bdTypeListView, boolean z) {
        this.mListView = bdTypeListView;
        a(fVar, bdTypeListView);
        this.cnZ = new HashMap<>();
        eR(z);
    }

    public void a(com.baidu.tieba.frs.f fVar, BdTypeListView bdTypeListView) {
        this.cla = fVar;
        this.cnH = new l(fVar.getPageContext(), bl.Zd, this.cla.getUniqueId());
        this.cnH.setVoiceManager(fVar.getVoiceManager());
        this.cnI = new j(fVar.getPageContext(), bl.Ze, this.cla.getUniqueId());
        this.cnJ = new l(fVar.getPageContext(), bl.Zf, this.cla.getUniqueId());
        this.cnJ.setVoiceManager(fVar.getVoiceManager());
        this.cnN = new p(fVar.getPageContext(), bl.Zg, this.cla.getUniqueId());
        this.cnO = new g(fVar.getPageContext(), bl.Zk, this.cla.getUniqueId());
        this.cnK = new c(fVar.getPageContext(), ax.Yw, this.cla.getUniqueId());
        this.cnL = com.baidu.tieba.frs.a.aeR().a(fVar.getPageContext(), com.baidu.tieba.tbadkCore.p.giz, this.cla.getUniqueId(), false);
        this.cnT = new com.baidu.tieba.frs.j(fVar.getPageContext(), k.clD);
        this.cnM = new n(fVar.getPageContext(), ay.Yz);
        this.cnR = new d(fVar.getPageContext(), bl.Zo, this.cla.getUniqueId());
        this.cnS = new d(fVar.getPageContext(), bl.Zp, this.cla.getUniqueId());
        this.cnP = com.baidu.tieba.frs.a.aeR().a(fVar.getPageContext(), bl.aao, this.cla.getUniqueId(), false);
        this.cnQ = com.baidu.tieba.frs.a.aeR().b(fVar.getPageContext(), bl.aat, this.cla.getUniqueId());
        this.cnU = new com.baidu.tieba.frs.h.a(fVar.getPageContext(), z.WU, this.cla.getUniqueId());
        this.cnW = new m(fVar.getPageContext(), com.baidu.tieba.frs.p.cmg);
        this.cnX = new i(fVar.getPageContext(), bl.Zq, this.cla.getUniqueId());
        this.cnY = new h(fVar.getPageContext(), CardHListViewData.TYPE);
        this.mAdapters.add(this.cnY);
        this.mAdapters.add(this.cnH);
        this.mAdapters.add(this.cnI);
        this.mAdapters.add(this.cnJ);
        com.baidu.tieba.InjectPlugin.b.b bVar = new com.baidu.tieba.InjectPlugin.b.b(this.cla, 1);
        bVar.setExtraData(this.mAdapters);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_FEED_AD_PLUGIN_OPERATE, bVar));
        this.mAdapters.add(this.cnK);
        this.mAdapters.add(this.cnX);
        if (this.cnL != null) {
            this.mAdapters.add(this.cnL);
        }
        this.mAdapters.add(this.cnT);
        this.mAdapters.add(this.cnN);
        this.mAdapters.add(this.cnO);
        this.mAdapters.add(this.cnM);
        this.mAdapters.add(this.cnR);
        this.mAdapters.add(this.cnS);
        this.mAdapters.add(new com.baidu.tieba.frs.u(this.cla.getPageContext(), v.cmv));
        this.mAdapters.add(this.cnP);
        if (this.cnQ != null) {
            this.mAdapters.add(this.cnQ);
        }
        this.mAdapters.add(this.cnU);
        this.mAdapters.add(this.cnW);
        com.baidu.adp.widget.ListView.a<? extends bl, ? extends j.a> b = com.baidu.tieba.frs.a.aeR().b(this.cla.getPageContext(), bl.aan, this.cla.getUniqueId());
        if (b != null) {
            this.mAdapters.add(b);
        }
        this.coc.setPriority(1);
        this.coc.setSelfListener(true);
        this.cla.registerListener(this.coc);
        this.cla.registerListener(this.aqh);
        this.cla.registerListener(this.mLikeForumListener);
        this.cla.registerListener(this.mUnlikeForumListener);
        this.cla.registerListener(this.coe);
        aha();
        CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_ADD_ADAPTER, new AbsDelegateAdapterList());
        CustomMessage customMessage = new CustomMessage(CmdConfigCustom.CMD_FRS_ADD_ADAPTER);
        customMessage.setTag(this.cla.getUniqueId());
        customResponsedMessage.setOrginalMessage(customMessage);
        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
        aH(this.mAdapters);
        bdTypeListView.addAdapters(this.mAdapters);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void R(Object obj) {
        boolean z;
        boolean z2 = false;
        if (this.acP != null) {
            Iterator<com.baidu.adp.widget.ListView.f> it = this.acP.iterator();
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
        if (this.acP != null) {
            Iterator<com.baidu.adp.widget.ListView.f> it = this.acP.iterator();
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

    private void aha() {
        if (this.cla != null && !ahb()) {
            this.cla.registerListener(this.cod);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean ahb() {
        if (this.cla == null) {
            return false;
        }
        this.cnV = new ArrayList();
        ArrayList<BdUniqueId> bsj = com.baidu.tieba.tbadkCore.n.bsj();
        if (bsj == null || bsj.size() <= 0) {
            return false;
        }
        int size = bsj.size();
        for (int i = 0; i < size; i++) {
            com.baidu.tieba.frs.d<ICardInfo, ? extends j.a> a = com.baidu.tieba.frs.a.aeR().a(this.cla.getPageContext(), bsj.get(i), this.cla.getUniqueId());
            if (a != null) {
                this.mAdapters.add(a);
                this.cnV.add(a);
            }
        }
        if (!u.v(this.cnV)) {
            this.mListView.addAdapters(this.cnV);
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
        this.coa = iVar;
        ahi();
        this.acP = arrayList;
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
                String se = blVar.se();
                if (fVar instanceof com.baidu.tieba.frs.p) {
                    blVar.needTopMargin = false;
                } else if (fVar != null && !e(fVar)) {
                    blVar.needTopMargin = false;
                } else if ((fVar instanceof bl) && e(fVar) && !TextUtils.isEmpty(((bl) fVar).se())) {
                    blVar.needTopMargin = true;
                } else if (e(fVar2) && !TextUtils.isEmpty(se)) {
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
        return type == bl.Zd || type == bl.Zf || type == bl.Zg || type == bl.Zk || type == bl.Zq || type == ax.Yw || type == bl.Zo || type == bl.Zp;
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
                if (this.cnZ != null && !this.cnZ.containsValue(fVar)) {
                    this.cnZ.put(Integer.valueOf(i2), (bl) fVar);
                }
            }
            i = i2 + 1;
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.a.q
    public void eR(boolean z) {
        if (this.cob != z) {
            this.cob = z;
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.a.q
    public HashMap<Integer, bl> ahc() {
        return this.cnZ;
    }

    @Override // com.baidu.tieba.frs.entelechy.a.q
    public void ahd() {
        if (this.mListView != null && this.mListView.getData() != null && this.mListView.getData().size() != 0) {
            for (com.baidu.adp.widget.ListView.f fVar : this.mListView.getData()) {
                if ((fVar instanceof bl) && ((bl) fVar).rB() != 0) {
                    ((bl) fVar).so();
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

    public void XY() {
        if (this.mListView.getAdapter() instanceof com.baidu.adp.widget.ListView.d) {
            if (this.acP != null) {
                this.mListView.setData(this.acP);
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
            if (this.cnH != null) {
                this.cnH.setFromCDN(z);
            }
            if (this.cnJ != null) {
                this.cnJ.setFromCDN(z);
            }
            if (this.cnR != null) {
                this.cnR.setFromCDN(z);
            }
            if (this.cnS != null) {
                this.cnS.setFromCDN(z);
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
    public int ahe() {
        if (this.cnL != null) {
            return d.h.frs_fortune_bag_item;
        }
        return 0;
    }

    @Override // com.baidu.tieba.frs.entelechy.a.q
    public int ahf() {
        if (this.cnL != null) {
            return d.h.frs_my_service_item;
        }
        return 0;
    }

    @Override // com.baidu.tieba.frs.entelechy.a.q
    public int ahg() {
        if (this.cnL != null) {
            return d.h.frs_bawu_center;
        }
        return 0;
    }

    @Override // com.baidu.tieba.frs.entelechy.a.q
    public int ahh() {
        if (this.cnM != null) {
            return this.cnM.agr();
        }
        return 0;
    }

    @Override // com.baidu.tieba.frs.entelechy.a.q
    public int ags() {
        if (this.cnM != null) {
            return this.cnM.ags();
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
                } else if (aVar != null && aVar.getType() == bl.aan) {
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
                    ((com.baidu.tieba.frs.d) aVar).a(this.cla.getPageContext(), this.cla.getUniqueId());
                }
            }
            aH(this.mAdapters);
        }
    }

    private void ahi() {
        if (this.coa != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.mAdapters) {
                if (aVar instanceof com.baidu.tieba.frs.e.c) {
                    com.baidu.tieba.frs.e.c cVar = (com.baidu.tieba.frs.e.c) aVar;
                    if (com.baidu.tieba.frs.e.c.cxO != null) {
                        if (this.coa.ghi == 1) {
                            com.baidu.tieba.frs.e.c.cxO.cxE = true;
                        } else {
                            com.baidu.tieba.frs.e.c.cxO.cxE = false;
                        }
                        if (this.coa.aPJ() != null) {
                            com.baidu.tieba.frs.e.c.cxO.cxG = this.coa.aPJ().getId();
                        }
                        if (this.cla != null && this.cla.afk() != null) {
                            com.baidu.tieba.frs.e.c.cxO.cxF = this.cla.afk().ajf();
                        }
                    }
                }
            }
            ahj();
        }
    }

    private void ahj() {
        com.baidu.tieba.frs.e.a aVar = new com.baidu.tieba.frs.e.a();
        if (this.coa.ghi == 1) {
            aVar.cxE = true;
        } else {
            aVar.cxE = false;
        }
        if (this.coa.aPJ() != null) {
            aVar.cxG = this.coa.aPJ().getId();
        }
        if (this.cla != null && this.cla.afk() != null) {
            aVar.cxF = this.cla.afk().ajf();
        }
        com.baidu.tieba.frs.c.b bVar = new com.baidu.tieba.frs.c.b(aVar);
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
                    if (!it.hasNext() || it.next().getType().getId() != bl.Zc.getId()) {
                        break;
                    }
                    i2 = i + 1;
                }
            }
            for (com.baidu.adp.widget.ListView.a aVar : this.mAdapters) {
                if (aVar instanceof com.baidu.tieba.frs.d) {
                    ((com.baidu.tieba.frs.d) aVar).iB(i);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aH(List<com.baidu.adp.widget.ListView.a> list) {
        if (list != null) {
            for (com.baidu.adp.widget.ListView.a aVar : list) {
                if (aVar instanceof com.baidu.tieba.frs.d) {
                    ((com.baidu.tieba.frs.d) aVar).a(this.cjs);
                }
            }
        }
    }
}
