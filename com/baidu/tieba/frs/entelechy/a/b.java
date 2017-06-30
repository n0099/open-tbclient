package com.baidu.tieba.frs.entelechy.a;

import android.text.TextUtils;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.adp.widget.ListView.x;
import com.baidu.adp.widget.ListView.z;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.data.ay;
import com.baidu.tbadk.core.data.az;
import com.baidu.tbadk.core.data.bm;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.card.cg;
import com.baidu.tieba.card.data.CardHListViewData;
import com.baidu.tieba.frs.AbsDelegateAdapterList;
import com.baidu.tieba.frs.bb;
import com.baidu.tieba.frs.bc;
import com.baidu.tieba.frs.bf;
import com.baidu.tieba.frs.bh;
import com.baidu.tieba.frs.bn;
import com.baidu.tieba.frs.bo;
import com.baidu.tieba.lego.card.model.ICardInfo;
import com.baidu.tieba.tbadkCore.n;
import com.baidu.tieba.w;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public class b implements al {
    private ArrayList<com.baidu.adp.widget.ListView.v> aaS;
    private com.baidu.tieba.frs.r cdv;
    private y cfR;
    private v cfS;
    private y cfT;
    private i cfU;
    private com.baidu.adp.widget.ListView.a cfV;
    private bf cfW;
    private aj cfX;
    private p cfY;
    private com.baidu.adp.widget.ListView.a cfZ;
    private com.baidu.adp.widget.ListView.a cga;
    private k cgb;
    private k cgc;
    private bb cgd;
    private com.baidu.tieba.frs.g.a cge;
    private List<com.baidu.adp.widget.ListView.a> cgf;
    private ac cgg;
    private t cgh;
    private r cgi;
    private final HashMap<Integer, bm> cgj;
    private n cgk;
    private BdTypeListView mListView;
    private List<com.baidu.adp.widget.ListView.a> mAdapters = new LinkedList();
    private boolean cgl = false;
    private CustomMessageListener cgm = new c(this, CmdConfigCustom.CMD_FRS_ADD_ADAPTER);
    private CustomMessageListener cgn = new d(this, CmdConfigCustom.CMD_LEGO_REGISTER);
    private CustomMessageListener anV = new e(this, CmdConfigCustom.CMD_UPDATE_ATTENTION);
    private CustomMessageListener mLikeForumListener = new f(this, CmdConfigCustom.CMD_LIKE_FORUM);
    private CustomMessageListener mUnlikeForumListener = new g(this, CmdConfigCustom.CMD_UNLIKE_FORUM);
    private CustomMessageListener cgo = new h(this, CmdConfigCustom.CMD_UPDATE_ADCARD);
    private final com.baidu.tieba.frs.o cbR = new com.baidu.tieba.frs.o();

    public b(com.baidu.tieba.frs.r rVar, BdTypeListView bdTypeListView, boolean z) {
        this.mListView = bdTypeListView;
        a(rVar, bdTypeListView);
        this.cgj = new HashMap<>();
        eE(z);
    }

    public void a(com.baidu.tieba.frs.r rVar, BdTypeListView bdTypeListView) {
        this.cdv = rVar;
        this.cfR = new y(rVar.getPageContext(), bm.Xo, this.cdv.getUniqueId());
        this.cfR.setVoiceManager(rVar.getVoiceManager());
        this.cfS = new v(rVar.getPageContext(), bm.Xp, this.cdv.getUniqueId());
        this.cfT = new y(rVar.getPageContext(), bm.Xq, this.cdv.getUniqueId());
        this.cfT.setVoiceManager(rVar.getVoiceManager());
        this.cfX = new aj(rVar.getPageContext(), bm.Xr, this.cdv.getUniqueId());
        this.cfY = new p(rVar.getPageContext(), bm.Xu, this.cdv.getUniqueId());
        this.cfU = new i(rVar.getPageContext(), ay.WH, this.cdv.getUniqueId());
        this.cfV = com.baidu.tieba.frs.c.ady().a(rVar.getPageContext(), com.baidu.tieba.tbadkCore.u.fKY, this.cdv.getUniqueId(), false);
        this.cgd = new bb(rVar.getPageContext(), bc.cdX);
        this.cfW = new bf(rVar.getPageContext(), az.WK);
        this.cgb = new k(rVar.getPageContext(), bm.Xy, this.cdv.getUniqueId());
        this.cgc = new k(rVar.getPageContext(), bm.Xz, this.cdv.getUniqueId());
        this.cfZ = com.baidu.tieba.frs.c.ady().a(rVar.getPageContext(), bm.Yz, this.cdv.getUniqueId(), false);
        this.cga = com.baidu.tieba.frs.c.ady().b(rVar.getPageContext(), bm.YE, this.cdv.getUniqueId());
        this.cge = new com.baidu.tieba.frs.g.a(rVar.getPageContext(), com.baidu.tbadk.core.data.aa.Vf, this.cdv.getUniqueId());
        this.cgg = new ac(rVar.getPageContext(), bh.cez);
        this.cgh = new t(rVar.getPageContext(), bm.XA, this.cdv.getUniqueId());
        this.cgi = new r(rVar.getPageContext(), CardHListViewData.TYPE);
        this.mAdapters.add(this.cgi);
        this.mAdapters.add(this.cfR);
        this.mAdapters.add(this.cfS);
        this.mAdapters.add(this.cfT);
        com.baidu.tieba.InjectPlugin.b.b bVar = new com.baidu.tieba.InjectPlugin.b.b(this.cdv, 1);
        bVar.setExtraData(this.mAdapters);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_FEED_AD_PLUGIN_OPERATE, bVar));
        this.mAdapters.add(this.cfU);
        this.mAdapters.add(this.cgh);
        if (this.cfV != null) {
            this.mAdapters.add(this.cfV);
        }
        this.mAdapters.add(this.cgd);
        this.mAdapters.add(this.cfX);
        this.mAdapters.add(this.cfY);
        this.mAdapters.add(this.cfW);
        this.mAdapters.add(this.cgb);
        this.mAdapters.add(this.cgc);
        this.mAdapters.add(new bn(this.cdv.getPageContext(), bo.ceO));
        this.mAdapters.add(this.cfZ);
        if (this.cga != null) {
            this.mAdapters.add(this.cga);
        }
        this.mAdapters.add(this.cge);
        this.mAdapters.add(this.cgg);
        com.baidu.adp.widget.ListView.a<? extends bm, ? extends z.a> b = com.baidu.tieba.frs.c.ady().b(this.cdv.getPageContext(), bm.Yy, this.cdv.getUniqueId());
        if (b != null) {
            this.mAdapters.add(b);
        }
        this.cgm.setPriority(1);
        this.cgm.setSelfListener(true);
        this.cdv.registerListener(this.cgm);
        this.cdv.registerListener(this.anV);
        this.cdv.registerListener(this.mLikeForumListener);
        this.cdv.registerListener(this.mUnlikeForumListener);
        this.cdv.registerListener(this.cgo);
        afu();
        CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_ADD_ADAPTER, new AbsDelegateAdapterList());
        CustomMessage customMessage = new CustomMessage(CmdConfigCustom.CMD_FRS_ADD_ADAPTER);
        customMessage.setTag(this.cdv.getUniqueId());
        customResponsedMessage.setOrginalMessage(customMessage);
        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
        aw(this.mAdapters);
        bdTypeListView.addAdapters(this.mAdapters);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void R(Object obj) {
        if (this.aaS != null) {
            Iterator<com.baidu.adp.widget.ListView.v> it = this.aaS.iterator();
            boolean z = false;
            while (it.hasNext()) {
                com.baidu.adp.widget.ListView.v next = it.next();
                if ((next instanceof ICardInfo) && ((ICardInfo) next).responseAttention(obj)) {
                    z = true;
                }
            }
            if (z) {
                notifyDataSetChanged();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void S(Object obj) {
        if (this.aaS != null) {
            Iterator<com.baidu.adp.widget.ListView.v> it = this.aaS.iterator();
            while (it.hasNext()) {
                com.baidu.adp.widget.ListView.v next = it.next();
                if (next instanceof AdvertAppInfo) {
                    AdvertAppInfo advertAppInfo = (AdvertAppInfo) next;
                    if (advertAppInfo.legoCard != null) {
                        advertAppInfo.legoCard.refreshReservation(obj);
                    }
                }
            }
        }
    }

    private void afu() {
        if (this.cdv != null && !afv()) {
            this.cdv.registerListener(this.cgn);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean afv() {
        if (this.cdv == null) {
            return false;
        }
        this.cgf = new ArrayList();
        ArrayList<BdUniqueId> blE = com.baidu.tieba.tbadkCore.s.blE();
        if (blE == null || blE.size() <= 0) {
            return false;
        }
        int size = blE.size();
        for (int i = 0; i < size; i++) {
            com.baidu.tieba.frs.p<ICardInfo, ? extends z.a> a = com.baidu.tieba.frs.c.ady().a(this.cdv.getPageContext(), blE.get(i), this.cdv.getUniqueId());
            if (a != null) {
                this.mAdapters.add(a);
                this.cgf.add(a);
            }
        }
        if (!com.baidu.tbadk.core.util.z.t(this.cgf)) {
            this.mListView.addAdapters(this.cgf);
        }
        return true;
    }

    @Override // com.baidu.tieba.frs.entelechy.a.al
    public void onDestory() {
        for (com.baidu.adp.widget.ListView.a aVar : this.mAdapters) {
            if (aVar instanceof com.baidu.tieba.frs.p) {
                ((com.baidu.tieba.frs.p) aVar).release();
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.a.al
    public void b(ArrayList<com.baidu.adp.widget.ListView.v> arrayList, n nVar) {
        a(nVar);
        com.baidu.tieba.tbadkCore.s.q(arrayList, 1);
        I(arrayList);
        J(arrayList);
        H(arrayList);
        this.mListView.setData(arrayList);
        this.cgk = nVar;
        afC();
        this.aaS = arrayList;
    }

    private void H(ArrayList<com.baidu.adp.widget.ListView.v> arrayList) {
        int s = com.baidu.tbadk.core.util.z.s(arrayList);
        for (int i = 0; i < s; i++) {
            com.baidu.adp.widget.ListView.v vVar = (com.baidu.adp.widget.ListView.v) com.baidu.tbadk.core.util.z.c(arrayList, i - 1);
            com.baidu.adp.widget.ListView.v vVar2 = (com.baidu.adp.widget.ListView.v) com.baidu.tbadk.core.util.z.c(arrayList, i);
            if (vVar2 instanceof bm) {
                bm bmVar = (bm) vVar2;
                if (i == 0) {
                    bmVar.isFirstFloor = true;
                } else {
                    bmVar.isFirstFloor = false;
                }
                String rP = bmVar.rP();
                if (vVar instanceof bh) {
                    bmVar.needTopMargin = false;
                } else if (vVar != null && !d(vVar)) {
                    bmVar.needTopMargin = false;
                } else if ((vVar instanceof bm) && d(vVar) && !TextUtils.isEmpty(((bm) vVar).rP())) {
                    bmVar.needTopMargin = true;
                } else if (d(vVar2) && !TextUtils.isEmpty(rP)) {
                    bmVar.needTopMargin = true;
                } else {
                    bmVar.needTopMargin = false;
                }
            }
        }
    }

    private boolean d(com.baidu.adp.widget.ListView.v vVar) {
        if (vVar == null) {
            return false;
        }
        BdUniqueId type = vVar.getType();
        return type == bm.Xo || type == bm.Xq || type == bm.Xr || type == bm.Xu || type == bm.XA || type == ay.WH || type == bm.Xy || type == bm.Xz;
    }

    private ArrayList<Integer> I(ArrayList<com.baidu.adp.widget.ListView.v> arrayList) {
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
            com.baidu.adp.widget.ListView.v vVar = arrayList.get(i2);
            if (vVar instanceof AdvertAppInfo) {
                arrayList2.add(Integer.valueOf(i2));
                if (this.cgj != null && !this.cgj.containsValue(vVar)) {
                    this.cgj.put(Integer.valueOf(i2), (bm) vVar);
                }
            }
            i = i2 + 1;
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.a.al
    public void eE(boolean z) {
        if (this.cgl != z) {
            this.cgl = z;
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.a.al
    public HashMap<Integer, bm> afw() {
        return this.cgj;
    }

    @Override // com.baidu.tieba.frs.entelechy.a.al
    public void afx() {
        if (this.mListView != null && this.mListView.getData() != null && this.mListView.getData().size() != 0) {
            for (com.baidu.adp.widget.ListView.v vVar : this.mListView.getData()) {
                if ((vVar instanceof bm) && ((bm) vVar).rm() != 0) {
                    ((bm) vVar).rZ();
                }
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.a.al
    public void notifyDataSetChanged() {
        if (this.mListView.getAdapter() instanceof com.baidu.adp.widget.ListView.e) {
            ((com.baidu.adp.widget.ListView.e) this.mListView.getAdapter()).notifyDataSetChanged();
        }
    }

    public void WT() {
        if (this.mListView.getAdapter() instanceof com.baidu.adp.widget.ListView.e) {
            if (this.aaS != null) {
                this.mListView.setData(this.aaS);
            }
            ((com.baidu.adp.widget.ListView.e) this.mListView.getAdapter()).notifyDataSetChanged();
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.a.al
    public void setFromCDN(boolean z) {
        if (this.mAdapters != null && this.mAdapters.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.mAdapters) {
                if (aVar instanceof com.baidu.tieba.frs.p) {
                    ((com.baidu.tieba.frs.p) aVar).setFromCDN(z);
                }
            }
            if (this.cfR != null) {
                this.cfR.setFromCDN(z);
            }
            if (this.cfT != null) {
                this.cfT.setFromCDN(z);
            }
            if (this.cgb != null) {
                this.cgb.setFromCDN(z);
            }
            if (this.cgc != null) {
                this.cgc.setFromCDN(z);
            }
        }
    }

    public void a(n nVar) {
        if (this.mAdapters != null && this.mAdapters.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.mAdapters) {
                if (aVar instanceof com.baidu.tieba.frs.p) {
                    ((com.baidu.tieba.frs.p) aVar).a(nVar);
                }
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.a.al
    public void a(com.baidu.tieba.frs.n nVar) {
        if (this.mAdapters != null && this.mAdapters.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.mAdapters) {
                if (aVar instanceof com.baidu.tieba.frs.p) {
                    ((com.baidu.tieba.frs.p) aVar).a(nVar);
                }
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.a.al
    public int afy() {
        if (this.cfV != null) {
            return w.h.frs_fortune_bag_item;
        }
        return 0;
    }

    @Override // com.baidu.tieba.frs.entelechy.a.al
    public int afz() {
        if (this.cfV != null) {
            return w.h.frs_my_service_item;
        }
        return 0;
    }

    @Override // com.baidu.tieba.frs.entelechy.a.al
    public int afA() {
        if (this.cfV != null) {
            return w.h.frs_bawu_center;
        }
        return 0;
    }

    @Override // com.baidu.tieba.frs.entelechy.a.al
    public int afB() {
        if (this.cfW != null) {
            return this.cfW.aeR();
        }
        return 0;
    }

    @Override // com.baidu.tieba.frs.entelechy.a.al
    public int aeS() {
        if (this.cfW != null) {
            return this.cfW.aeS();
        }
        return 0;
    }

    @Override // com.baidu.tieba.frs.entelechy.a.al
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

    @Override // com.baidu.tieba.frs.entelechy.a.al
    public void setOnAdapterItemClickListener(x xVar) {
        if (this.mAdapters != null && this.mAdapters.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.mAdapters) {
                if (aVar instanceof com.baidu.tieba.frs.p) {
                    ((com.baidu.tieba.frs.p) aVar).setOnAdapterItemClickListener(xVar);
                } else if ((aVar instanceof y) || (aVar instanceof i) || (aVar instanceof o) || (aVar instanceof k) || (aVar instanceof aj)) {
                    aVar.setOnAdapterItemClickListener(xVar);
                } else if (aVar != null && aVar.getType() == bm.Yy) {
                    aVar.setOnAdapterItemClickListener(xVar);
                }
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.a.al
    public void setForumName(String str) {
        if (this.mAdapters != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.mAdapters) {
                if (aVar instanceof cg) {
                    ((cg) aVar).setForumName(str);
                }
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.a.al
    public void cA(boolean z) {
        if (this.mAdapters != null && this.mAdapters.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.mAdapters) {
                if (aVar instanceof com.baidu.tieba.frs.p) {
                    ((com.baidu.tieba.frs.p) aVar).cA(z);
                }
            }
        }
    }

    private void afC() {
        if (this.cgk != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.mAdapters) {
                if (aVar instanceof com.baidu.tieba.frs.d.e) {
                    com.baidu.tieba.frs.d.e eVar = (com.baidu.tieba.frs.d.e) aVar;
                    if (com.baidu.tieba.frs.d.e.cnC != null) {
                        if (this.cgk.fJJ == 1) {
                            com.baidu.tieba.frs.d.e.cnC.cnr = true;
                        } else {
                            com.baidu.tieba.frs.d.e.cnC.cnr = false;
                        }
                        if (this.cgk.aMt() != null) {
                            com.baidu.tieba.frs.d.e.cnC.cnu = this.cgk.aMt().getId();
                        }
                        if (this.cdv != null && this.cdv.adP() != null) {
                            com.baidu.tieba.frs.d.e.cnC.cns = this.cdv.adP().agT();
                        }
                    }
                }
            }
            afD();
        }
    }

    private void afD() {
        com.baidu.tieba.frs.d.a aVar = new com.baidu.tieba.frs.d.a();
        if (this.cgk.fJJ == 1) {
            aVar.cnr = true;
        } else {
            aVar.cnr = false;
        }
        if (this.cgk.aMt() != null) {
            aVar.cnu = this.cgk.aMt().getId();
        }
        if (this.cdv != null && this.cdv.adP() != null) {
            aVar.cns = this.cdv.adP().agT();
        }
        com.baidu.tieba.frs.c.a aVar2 = new com.baidu.tieba.frs.c.a(aVar);
        CustomMessageTask customMessageTask = new CustomMessageTask(CmdConfigCustom.CMD_FRS_LIVE_CARD_CLICK, aVar2);
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
        CustomMessageTask customMessageTask2 = new CustomMessageTask(CmdConfigCustom.CMD_FRS_LIVE_CARD_SHOW, aVar2);
        customMessageTask2.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask2);
        CustomMessageTask customMessageTask3 = new CustomMessageTask(CmdConfigCustom.CMD_FRS_LIVE_USER_CLICK, aVar2);
        customMessageTask3.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask3);
        CustomMessageTask customMessageTask4 = new CustomMessageTask(CmdConfigCustom.CMD_FRS_LIVE_VIDEO_CLICK, aVar2);
        customMessageTask4.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask4);
    }

    @Override // com.baidu.tieba.frs.entelechy.a.al
    public List<com.baidu.adp.widget.ListView.v> getDatas() {
        if (this.mListView != null) {
            return this.mListView.getData();
        }
        return null;
    }

    private void J(ArrayList<com.baidu.adp.widget.ListView.v> arrayList) {
        int i;
        if (this.mAdapters != null && this.mAdapters.size() != 0) {
            int i2 = 0;
            if (arrayList == null || arrayList.size() <= 0) {
                i = 0;
            } else {
                Iterator<com.baidu.adp.widget.ListView.v> it = arrayList.iterator();
                while (true) {
                    i = i2;
                    if (!it.hasNext() || it.next().getType().getId() != bm.Xn.getId()) {
                        break;
                    }
                    i2 = i + 1;
                }
            }
            for (com.baidu.adp.widget.ListView.a aVar : this.mAdapters) {
                if (aVar instanceof com.baidu.tieba.frs.p) {
                    ((com.baidu.tieba.frs.p) aVar).iq(i);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aw(List<com.baidu.adp.widget.ListView.a> list) {
        if (list != null) {
            for (com.baidu.adp.widget.ListView.a aVar : list) {
                if (aVar instanceof com.baidu.tieba.frs.p) {
                    ((com.baidu.tieba.frs.p) aVar).a(this.cbR);
                }
            }
        }
    }
}
