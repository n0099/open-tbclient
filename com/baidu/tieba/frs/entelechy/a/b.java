package com.baidu.tieba.frs.entelechy.a;

import android.text.TextUtils;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.adp.widget.ListView.z;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.data.ax;
import com.baidu.tbadk.core.data.ay;
import com.baidu.tbadk.core.data.bl;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.x;
import com.baidu.tieba.card.cg;
import com.baidu.tieba.card.data.CardHListViewData;
import com.baidu.tieba.frs.AbsDelegateAdapterList;
import com.baidu.tieba.frs.ba;
import com.baidu.tieba.frs.bb;
import com.baidu.tieba.frs.be;
import com.baidu.tieba.frs.bg;
import com.baidu.tieba.frs.bm;
import com.baidu.tieba.frs.bn;
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
    private ArrayList<com.baidu.adp.widget.ListView.v> aaR;
    private com.baidu.tieba.frs.r bVm;
    private y bXI;
    private v bXJ;
    private y bXK;
    private i bXL;
    private com.baidu.adp.widget.ListView.a bXM;
    private be bXN;
    private aj bXO;
    private p bXP;
    private com.baidu.adp.widget.ListView.a bXQ;
    private com.baidu.adp.widget.ListView.a bXR;
    private k bXS;
    private k bXT;
    private ba bXU;
    private com.baidu.tieba.frs.g.a bXV;
    private List<com.baidu.adp.widget.ListView.a> bXW;
    private ac bXX;
    private t bXY;
    private r bXZ;
    private final HashMap<Integer, bl> bYa;
    private n bYb;
    private BdTypeListView mListView;
    private List<com.baidu.adp.widget.ListView.a> mAdapters = new LinkedList();
    private boolean bYc = false;
    private CustomMessageListener bYd = new c(this, CmdConfigCustom.CMD_FRS_ADD_ADAPTER);
    private CustomMessageListener bYe = new d(this, CmdConfigCustom.CMD_LEGO_REGISTER);
    private CustomMessageListener amV = new e(this, CmdConfigCustom.CMD_UPDATE_ATTENTION);
    private CustomMessageListener mLikeForumListener = new f(this, CmdConfigCustom.CMD_LIKE_FORUM);
    private CustomMessageListener mUnlikeForumListener = new g(this, CmdConfigCustom.CMD_UNLIKE_FORUM);
    private CustomMessageListener bYf = new h(this, CmdConfigCustom.CMD_UPDATE_ADCARD);
    private final com.baidu.tieba.frs.o bTJ = new com.baidu.tieba.frs.o();

    public b(com.baidu.tieba.frs.r rVar, BdTypeListView bdTypeListView, boolean z) {
        this.mListView = bdTypeListView;
        a(rVar, bdTypeListView);
        this.bYa = new HashMap<>();
        em(z);
    }

    public void a(com.baidu.tieba.frs.r rVar, BdTypeListView bdTypeListView) {
        this.bVm = rVar;
        this.bXI = new y(rVar.getPageContext(), bl.Xo, this.bVm.getUniqueId());
        this.bXI.setVoiceManager(rVar.getVoiceManager());
        this.bXJ = new v(rVar.getPageContext(), bl.Xp, this.bVm.getUniqueId());
        this.bXK = new y(rVar.getPageContext(), bl.Xq, this.bVm.getUniqueId());
        this.bXK.setVoiceManager(rVar.getVoiceManager());
        this.bXO = new aj(rVar.getPageContext(), bl.Xr, this.bVm.getUniqueId());
        this.bXP = new p(rVar.getPageContext(), bl.Xu, this.bVm.getUniqueId());
        this.bXL = new i(rVar.getPageContext(), ax.WH, this.bVm.getUniqueId());
        this.bXM = com.baidu.tieba.frs.c.ZH().a(rVar.getPageContext(), com.baidu.tieba.tbadkCore.u.fAU, this.bVm.getUniqueId(), false);
        this.bXU = new ba(rVar.getPageContext(), bb.bVP);
        this.bXN = new be(rVar.getPageContext(), ay.WK);
        this.bXS = new k(rVar.getPageContext(), bl.Xy, this.bVm.getUniqueId());
        this.bXT = new k(rVar.getPageContext(), bl.Xz, this.bVm.getUniqueId());
        this.bXQ = com.baidu.tieba.frs.c.ZH().a(rVar.getPageContext(), bl.Yy, this.bVm.getUniqueId(), false);
        this.bXR = com.baidu.tieba.frs.c.ZH().b(rVar.getPageContext(), bl.YD, this.bVm.getUniqueId());
        this.bXV = new com.baidu.tieba.frs.g.a(rVar.getPageContext(), com.baidu.tbadk.core.data.z.Vf, this.bVm.getUniqueId());
        this.bXX = new ac(rVar.getPageContext(), bg.bWr);
        this.bXY = new t(rVar.getPageContext(), bl.XA, this.bVm.getUniqueId());
        this.bXZ = new r(rVar.getPageContext(), CardHListViewData.TYPE);
        this.mAdapters.add(this.bXZ);
        this.mAdapters.add(this.bXI);
        this.mAdapters.add(this.bXJ);
        this.mAdapters.add(this.bXK);
        com.baidu.tieba.InjectPlugin.b.b bVar = new com.baidu.tieba.InjectPlugin.b.b(this.bVm, 1);
        bVar.setExtraData(this.mAdapters);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_FEED_AD_PLUGIN_OPERATE, bVar));
        this.mAdapters.add(this.bXL);
        this.mAdapters.add(this.bXY);
        if (this.bXM != null) {
            this.mAdapters.add(this.bXM);
        }
        this.mAdapters.add(this.bXU);
        this.mAdapters.add(this.bXO);
        this.mAdapters.add(this.bXP);
        this.mAdapters.add(this.bXN);
        this.mAdapters.add(this.bXS);
        this.mAdapters.add(this.bXT);
        this.mAdapters.add(new bm(this.bVm.getPageContext(), bn.bWG));
        this.mAdapters.add(this.bXQ);
        if (this.bXR != null) {
            this.mAdapters.add(this.bXR);
        }
        this.mAdapters.add(this.bXV);
        this.mAdapters.add(this.bXX);
        com.baidu.adp.widget.ListView.a<? extends bl, ? extends z.a> b = com.baidu.tieba.frs.c.ZH().b(this.bVm.getPageContext(), bl.Yx, this.bVm.getUniqueId());
        if (b != null) {
            this.mAdapters.add(b);
        }
        this.bYd.setPriority(1);
        this.bYd.setSelfListener(true);
        this.bVm.registerListener(this.bYd);
        this.bVm.registerListener(this.amV);
        this.bVm.registerListener(this.mLikeForumListener);
        this.bVm.registerListener(this.mUnlikeForumListener);
        this.bVm.registerListener(this.bYf);
        abD();
        CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_ADD_ADAPTER, new AbsDelegateAdapterList());
        CustomMessage customMessage = new CustomMessage(CmdConfigCustom.CMD_FRS_ADD_ADAPTER);
        customMessage.setTag(this.bVm.getUniqueId());
        customResponsedMessage.setOrginalMessage(customMessage);
        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
        an(this.mAdapters);
        bdTypeListView.addAdapters(this.mAdapters);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void P(Object obj) {
        if (this.aaR != null) {
            Iterator<com.baidu.adp.widget.ListView.v> it = this.aaR.iterator();
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
    public void Q(Object obj) {
        if (this.aaR != null) {
            Iterator<com.baidu.adp.widget.ListView.v> it = this.aaR.iterator();
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

    private void abD() {
        if (this.bVm != null && !abE()) {
            this.bVm.registerListener(this.bYe);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean abE() {
        if (this.bVm == null) {
            return false;
        }
        this.bXW = new ArrayList();
        ArrayList<BdUniqueId> bhq = com.baidu.tieba.tbadkCore.s.bhq();
        if (bhq == null || bhq.size() <= 0) {
            return false;
        }
        int size = bhq.size();
        for (int i = 0; i < size; i++) {
            com.baidu.tieba.frs.p<ICardInfo, ? extends z.a> a = com.baidu.tieba.frs.c.ZH().a(this.bVm.getPageContext(), bhq.get(i), this.bVm.getUniqueId());
            if (a != null) {
                this.mAdapters.add(a);
                this.bXW.add(a);
            }
        }
        if (!x.r(this.bXW)) {
            this.mListView.addAdapters(this.bXW);
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
        H(arrayList);
        I(arrayList);
        G(arrayList);
        this.mListView.setData(arrayList);
        this.bYb = nVar;
        abL();
        this.aaR = arrayList;
    }

    private void G(ArrayList<com.baidu.adp.widget.ListView.v> arrayList) {
        int q = x.q(arrayList);
        for (int i = 0; i < q; i++) {
            com.baidu.adp.widget.ListView.v vVar = (com.baidu.adp.widget.ListView.v) x.c(arrayList, i - 1);
            com.baidu.adp.widget.ListView.v vVar2 = (com.baidu.adp.widget.ListView.v) x.c(arrayList, i);
            if (vVar2 instanceof bl) {
                bl blVar = (bl) vVar2;
                if (i == 0) {
                    blVar.isFirstFloor = true;
                } else {
                    blVar.isFirstFloor = false;
                }
                String rS = blVar.rS();
                if (vVar instanceof bg) {
                    blVar.needTopMargin = false;
                } else if (vVar != null && !d(vVar)) {
                    blVar.needTopMargin = false;
                } else if ((vVar instanceof bl) && d(vVar) && !TextUtils.isEmpty(((bl) vVar).rS())) {
                    blVar.needTopMargin = true;
                } else if (d(vVar2) && !TextUtils.isEmpty(rS)) {
                    blVar.needTopMargin = true;
                } else {
                    blVar.needTopMargin = false;
                }
            }
        }
    }

    private boolean d(com.baidu.adp.widget.ListView.v vVar) {
        if (vVar == null) {
            return false;
        }
        BdUniqueId type = vVar.getType();
        return type == bl.Xo || type == bl.Xq || type == bl.Xr || type == bl.Xu || type == bl.XA || type == ax.WH || type == bl.Xy || type == bl.Xz;
    }

    private ArrayList<Integer> H(ArrayList<com.baidu.adp.widget.ListView.v> arrayList) {
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
                if (this.bYa != null && !this.bYa.containsValue(vVar)) {
                    this.bYa.put(Integer.valueOf(i2), (bl) vVar);
                }
            }
            i = i2 + 1;
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.a.al
    public void em(boolean z) {
        if (this.bYc != z) {
            this.bYc = z;
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.a.al
    public HashMap<Integer, bl> abF() {
        return this.bYa;
    }

    @Override // com.baidu.tieba.frs.entelechy.a.al
    public void abG() {
        if (this.mListView != null && this.mListView.getData() != null && this.mListView.getData().size() != 0) {
            for (com.baidu.adp.widget.ListView.v vVar : this.mListView.getData()) {
                if ((vVar instanceof bl) && ((bl) vVar).rq() != 0) {
                    ((bl) vVar).sc();
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

    public void VC() {
        if (this.mListView.getAdapter() instanceof com.baidu.adp.widget.ListView.e) {
            if (this.aaR != null) {
                this.mListView.setData(this.aaR);
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
            if (this.bXI != null) {
                this.bXI.setFromCDN(z);
            }
            if (this.bXK != null) {
                this.bXK.setFromCDN(z);
            }
            if (this.bXS != null) {
                this.bXS.setFromCDN(z);
            }
            if (this.bXT != null) {
                this.bXT.setFromCDN(z);
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
    public int abH() {
        if (this.bXM != null) {
            return w.h.frs_fortune_bag_item;
        }
        return 0;
    }

    @Override // com.baidu.tieba.frs.entelechy.a.al
    public int abI() {
        if (this.bXM != null) {
            return w.h.frs_my_service_item;
        }
        return 0;
    }

    @Override // com.baidu.tieba.frs.entelechy.a.al
    public int abJ() {
        if (this.bXM != null) {
            return w.h.frs_bawu_center;
        }
        return 0;
    }

    @Override // com.baidu.tieba.frs.entelechy.a.al
    public int abK() {
        if (this.bXN != null) {
            return this.bXN.aba();
        }
        return 0;
    }

    @Override // com.baidu.tieba.frs.entelechy.a.al
    public int abb() {
        if (this.bXN != null) {
            return this.bXN.abb();
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
    public void setOnAdapterItemClickListener(com.baidu.adp.widget.ListView.x xVar) {
        if (this.mAdapters != null && this.mAdapters.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.mAdapters) {
                if (aVar instanceof com.baidu.tieba.frs.p) {
                    ((com.baidu.tieba.frs.p) aVar).setOnAdapterItemClickListener(xVar);
                } else if ((aVar instanceof y) || (aVar instanceof i) || (aVar instanceof o) || (aVar instanceof k) || (aVar instanceof aj)) {
                    aVar.setOnAdapterItemClickListener(xVar);
                } else if (aVar != null && aVar.getType() == bl.Yx) {
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
    public void cv(boolean z) {
        if (this.mAdapters != null && this.mAdapters.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.mAdapters) {
                if (aVar instanceof com.baidu.tieba.frs.p) {
                    ((com.baidu.tieba.frs.p) aVar).cv(z);
                }
            }
        }
    }

    private void abL() {
        if (this.bYb != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.mAdapters) {
                if (aVar instanceof com.baidu.tieba.frs.d.e) {
                    com.baidu.tieba.frs.d.e eVar = (com.baidu.tieba.frs.d.e) aVar;
                    if (com.baidu.tieba.frs.d.e.cfm != null) {
                        if (this.bYb.fzF == 1) {
                            com.baidu.tieba.frs.d.e.cfm.cfc = true;
                        } else {
                            com.baidu.tieba.frs.d.e.cfm.cfc = false;
                        }
                        if (this.bYb.aIz() != null) {
                            com.baidu.tieba.frs.d.e.cfm.cfe = this.bYb.aIz().getId();
                        }
                        if (this.bVm != null && this.bVm.ZY() != null) {
                            com.baidu.tieba.frs.d.e.cfm.cfd = this.bVm.ZY().ada();
                        }
                    }
                }
            }
            abM();
        }
    }

    private void abM() {
        com.baidu.tieba.frs.d.a aVar = new com.baidu.tieba.frs.d.a();
        if (this.bYb.fzF == 1) {
            aVar.cfc = true;
        } else {
            aVar.cfc = false;
        }
        if (this.bYb.aIz() != null) {
            aVar.cfe = this.bYb.aIz().getId();
        }
        if (this.bVm != null && this.bVm.ZY() != null) {
            aVar.cfd = this.bVm.ZY().ada();
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

    private void I(ArrayList<com.baidu.adp.widget.ListView.v> arrayList) {
        int i;
        if (this.mAdapters != null && this.mAdapters.size() != 0) {
            int i2 = 0;
            if (arrayList == null || arrayList.size() <= 0) {
                i = 0;
            } else {
                Iterator<com.baidu.adp.widget.ListView.v> it = arrayList.iterator();
                while (true) {
                    i = i2;
                    if (!it.hasNext() || it.next().getType().getId() != bl.Xn.getId()) {
                        break;
                    }
                    i2 = i + 1;
                }
            }
            for (com.baidu.adp.widget.ListView.a aVar : this.mAdapters) {
                if (aVar instanceof com.baidu.tieba.frs.p) {
                    ((com.baidu.tieba.frs.p) aVar).ie(i);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void an(List<com.baidu.adp.widget.ListView.a> list) {
        if (list != null) {
            for (com.baidu.adp.widget.ListView.a aVar : list) {
                if (aVar instanceof com.baidu.tieba.frs.p) {
                    ((com.baidu.tieba.frs.p) aVar).a(this.bTJ);
                }
            }
        }
    }
}
