package com.baidu.tieba.homepage.personalize.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdRecyclerView;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.data.cb;
import com.baidu.tbadk.coreExtra.message.UpdateAttentionMessage;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.homepage.personalize.readProgressBar.ReadProgessDelegetAdapter;
import com.baidu.tieba.lego.card.model.ICardInfo;
import com.baidu.tieba.view.FollowUserButton;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes2.dex */
public class ab {
    private List<com.baidu.adp.widget.ListView.a> jDM;
    private com.baidu.tieba.homepage.concern.adapter.z jZu;
    private a kio;
    private l kkA;
    private HomePageAlaLiveThreadAdapter kkB;
    private HomePageAlaFriendRoomAdapter kkC;
    private v kkD;
    private u kkE;
    private w kkF;
    private t kkG;
    private n kkH;
    private p kkI;
    private q kkJ;
    private s kkK;
    private c kkL;
    private com.baidu.adp.widget.ListView.a kkM;
    private com.baidu.adp.widget.ListView.a kkN;
    private com.baidu.adp.widget.ListView.a kkO;
    private com.baidu.adp.widget.ListView.a kkP;
    private com.baidu.adp.widget.ListView.a kkQ;
    private com.baidu.adp.widget.ListView.a kkR;
    private com.baidu.adp.widget.ListView.a kkS;
    private boolean kkT;
    private boolean kkU;
    private com.baidu.adp.widget.ListView.s kkh;
    private List<com.baidu.adp.widget.ListView.n> kki;
    private com.baidu.tieba.homepage.personalize.adapter.a kkj;
    private z kkk;
    private b kkl;
    private n kkm;
    private x kkn;
    private h kko;
    private i kkp;
    private j kkq;
    private r kkr;
    private k kks;
    private o kkt;
    private m kku;
    private g kkv;
    private f kkw;
    private e kkx;
    private y kky;
    private d kkz;
    private TbPageContext<?> mPageContext;
    private CustomMessageListener jDO = new CustomMessageListener(CmdConfigCustom.CMD_LEGO_REGISTER) { // from class: com.baidu.tieba.homepage.personalize.adapter.ab.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                ab.this.cRv();
                if (ab.this.kki != null) {
                    ab.this.cx(ab.this.kki);
                }
            }
        }
    };
    private CustomMessageListener faJ = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.homepage.personalize.adapter.ab.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
            if (updateAttentionMessage != null && updateAttentionMessage.getData() != null && updateAttentionMessage.getData().isSucc) {
                ab.this.aM(updateAttentionMessage.getData());
            }
        }
    };
    private CustomMessageListener mLikeForumListener = new CustomMessageListener(CmdConfigCustom.CMD_LIKE_FORUM) { // from class: com.baidu.tieba.homepage.personalize.adapter.ab.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                com.baidu.tieba.lego.c.b bVar = new com.baidu.tieba.lego.c.b();
                bVar.fid = String.valueOf(customResponsedMessage.getData());
                bVar.ePK = true;
                ab.this.aM(bVar);
            }
        }
    };
    private CustomMessageListener mUnlikeForumListener = new CustomMessageListener(CmdConfigCustom.CMD_UNLIKE_FORUM) { // from class: com.baidu.tieba.homepage.personalize.adapter.ab.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                com.baidu.tieba.lego.c.b bVar = new com.baidu.tieba.lego.c.b();
                bVar.fid = String.valueOf(customResponsedMessage.getData());
                bVar.ePK = false;
                ab.this.aM(bVar);
            }
        }
    };
    private CustomMessageListener iwK = new CustomMessageListener(2921394) { // from class: com.baidu.tieba.homepage.personalize.adapter.ab.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            com.baidu.afd.videopaster.data.b Ll;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (!StringUtils.isNull(str, true) && (Ll = ab.this.Ll(str)) != null) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921395, Ll));
                }
            }
        }
    };
    private List<com.baidu.adp.widget.ListView.a> jNU = new ArrayList();

    /* loaded from: classes2.dex */
    public interface a {
        void Mk();
    }

    public ab(Context context, com.baidu.adp.widget.ListView.s sVar) {
        this.kkh = sVar;
        this.mPageContext = (TbPageContext) com.baidu.adp.base.j.K(context);
        gm(context);
        a(sVar);
        sVar.addAdapters(this.jNU);
    }

    private void gm(Context context) {
        this.kkj = new com.baidu.tieba.homepage.personalize.adapter.a(this.mPageContext);
        this.kkk = new z(this.mPageContext);
        this.kkl = new b(this.mPageContext, com.baidu.tieba.homepage.personalize.data.f.klu);
        this.kkm = new n(this.mPageContext, com.baidu.tieba.card.data.k.TYPE);
        this.kkn = new x(this.mPageContext, com.baidu.tieba.card.data.k.iAN);
        this.kko = new h(this.mPageContext, com.baidu.tieba.card.data.k.iAT);
        this.kkp = new i(this.mPageContext, com.baidu.tieba.card.data.k.eQr);
        this.kkq = new j(this.mPageContext, com.baidu.tieba.card.data.k.iAU);
        this.kkr = new r(this.mPageContext, com.baidu.tieba.card.data.k.iAS);
        this.kks = new k(this.mPageContext, com.baidu.tieba.card.data.k.eQD);
        this.kkt = new o(this.mPageContext, com.baidu.tieba.card.data.k.eQF);
        this.kku = new m(this.mPageContext, com.baidu.tieba.card.data.k.eQG);
        this.kkv = new g(this.mPageContext, com.baidu.tieba.card.data.k.iAO);
        this.kkw = new f(this.mPageContext, com.baidu.tieba.card.data.k.iAP);
        this.kkx = new e(this.mPageContext, com.baidu.tieba.card.data.k.iAQ);
        this.kky = new y(this.mPageContext, com.baidu.tieba.card.data.l.eQK);
        this.kkA = new l(this.mPageContext, com.baidu.tieba.card.data.k.eQI);
        this.kkB = new HomePageAlaLiveThreadAdapter(this.mPageContext, com.baidu.tieba.card.data.j.TYPE);
        this.kkC = new HomePageAlaFriendRoomAdapter(this.mPageContext, com.baidu.tieba.card.data.j.iAt);
        this.kkD = new v(this.mPageContext, com.baidu.tieba.card.data.k.eQP);
        this.kkE = new u(this.mPageContext, com.baidu.tieba.card.data.k.eQQ);
        this.kkF = new w(this.mPageContext, com.baidu.tieba.card.data.k.eQS);
        this.kkG = new t(this.mPageContext, com.baidu.tieba.card.data.k.eQR);
        this.kkH = new n(this.mPageContext, com.baidu.tieba.card.data.k.iAL);
        this.kkI = new p(this.mPageContext, com.baidu.tieba.card.data.k.eQW);
        this.kkJ = new q(this.mPageContext, com.baidu.tieba.card.data.k.eQX);
        this.kkK = new s(this.mPageContext, com.baidu.tieba.homepage.topic.topictab.b.a.kpQ);
        this.kkL = new c(this.mPageContext, com.baidu.tieba.card.data.e.iAo);
        this.kkz = new d(this.mPageContext, com.baidu.tieba.card.data.k.iAR);
        this.jZu = new com.baidu.tieba.homepage.concern.adapter.z(this.mPageContext, com.baidu.tieba.card.data.k.iAM, (byte) 3);
        this.jNU.add(this.kkj);
        this.jNU.add(this.kkk);
        this.jNU.add(this.kkl);
        this.jNU.add(this.kkm);
        this.jNU.add(this.kkn);
        this.jNU.add(this.kko);
        this.jNU.add(this.kkp);
        this.jNU.add(this.kkq);
        this.jNU.add(this.kkr);
        this.jNU.add(this.kks);
        this.jNU.add(this.kkt);
        this.jNU.add(this.kku);
        this.jNU.add(this.kkv);
        this.jNU.add(this.kkw);
        this.jNU.add(this.kkx);
        this.jNU.add(this.kky);
        this.jNU.add(this.kkA);
        this.jNU.add(this.kkH);
        this.jNU.add(new ReadProgessDelegetAdapter(this.mPageContext, com.baidu.tieba.homepage.personalize.readProgressBar.b.TYPE));
        this.jNU.add(this.kkB);
        this.jNU.add(this.kkC);
        this.jNU.add(this.kkD);
        this.jNU.add(this.kkE);
        this.jNU.add(this.kkG);
        this.jNU.add(this.kkF);
        this.jNU.add(new aa(this.mPageContext, com.baidu.tieba.homepage.personalize.data.h.TYPE));
        this.jNU.add(this.kkI);
        this.jNU.add(this.kkJ);
        this.jNU.add(this.kkK);
        this.jNU.add(this.kkL);
        this.jNU.add(this.kkz);
        this.jNU.add(this.jZu);
        cRu();
        cOE();
        Ey("page_recommend");
    }

    private void cOE() {
        if (!cb.eRa.get()) {
            AdvertAppInfo.eLs.set(false);
            return;
        }
        this.kkM = com.baidu.tieba.recapp.r.dDm().a(this.mPageContext, AdvertAppInfo.eLg, "INDEX");
        this.kkN = com.baidu.tieba.recapp.r.dDm().a(this.mPageContext, AdvertAppInfo.eLj, "INDEX");
        this.kkO = com.baidu.tieba.recapp.r.dDm().a(this.mPageContext, AdvertAppInfo.eLn, "INDEX");
        this.kkP = com.baidu.tieba.recapp.r.dDm().a(this.mPageContext, AdvertAppInfo.eLo, "INDEX");
        this.kkQ = com.baidu.tieba.recapp.r.dDm().a(this.mPageContext, AdvertAppInfo.eLp, "INDEX");
        this.kkR = com.baidu.tieba.recapp.r.dDm().a(this.mPageContext, AdvertAppInfo.eLr, "INDEX");
        this.kkS = com.baidu.tieba.recapp.r.dDm().a(this.mPageContext, AdvertAppInfo.eLq, "INDEX");
        this.jNU.add(this.kkM);
        this.jNU.add(this.kkN);
        this.jNU.add(this.kkO);
        this.jNU.add(this.kkP);
        this.jNU.add(this.kkQ);
        this.jNU.add(this.kkR);
        this.jNU.add(this.kkS);
        AdvertAppInfo.eLs.set(true);
    }

    public void b(com.baidu.tieba.homepage.personalize.model.e eVar) {
        this.kkm.a(eVar);
        this.kkn.a(eVar);
        this.kko.a(eVar);
        this.kkq.a(eVar);
        this.kkr.a(eVar);
        this.kkv.a(eVar);
        this.kkw.a(eVar);
        this.kkx.a(eVar);
        this.kky.a(eVar);
        this.kkz.a(eVar);
    }

    private void a(com.baidu.adp.widget.ListView.s sVar) {
        this.kkn.a(sVar);
        this.kko.a(sVar);
        this.kkp.a(sVar);
        this.kkq.a(sVar);
        this.kkr.a(sVar);
        this.kks.a(sVar);
        this.kkt.a(sVar);
        this.kku.a(sVar);
        this.kkv.a(sVar);
        this.kkw.a(sVar);
        this.kkx.a(sVar);
        this.kkz.a(sVar);
        this.kky.a(sVar);
        this.kkL.a(sVar);
        this.kkE.a(sVar);
        this.kkE.a(sVar);
        this.kkG.a(sVar);
        this.jZu.a(sVar);
    }

    public void j(List<com.baidu.adp.widget.ListView.n> list, int i) {
        com.baidu.tieba.tbadkCore.v.x(list, 2);
        ViewGroup listView = this.kkh.getListView();
        if (i > 0 && (listView instanceof BdRecyclerView)) {
            int firstVisiblePosition = ((BdRecyclerView) listView).getFirstVisiblePosition();
            View childAt = ((BdRecyclerView) listView).getChildAt(0);
            int top = childAt == null ? 0 : childAt.getTop();
            RecyclerView.LayoutManager layoutManager = ((BdRecyclerView) listView).getLayoutManager();
            int i2 = firstVisiblePosition - i;
            if (layoutManager instanceof LinearLayoutManager) {
                ((BdRecyclerView) listView).qt();
                ((LinearLayoutManager) layoutManager).scrollToPositionWithOffset(i2, top);
                ((BdRecyclerView) listView).qu();
            }
        }
        this.kkh.setData(list);
        this.kki = list;
        if (this.kio != null) {
            this.kio.Mk();
        }
    }

    public void cx(List<com.baidu.adp.widget.ListView.n> list) {
        com.baidu.tieba.tbadkCore.v.x(list, 2);
        this.kkh.setData(list);
        this.kki = list;
        if (this.kio != null) {
            this.kio.Mk();
        }
    }

    public void onChangeSkinType(int i) {
        notifyDataSetChanged();
        this.kkj.onChangeSkinType(i);
    }

    public void notifyDataSetChanged() {
        if (this.kkh != null) {
            this.kkh.getListAdapter().notifyDataSetChanged();
        }
    }

    public void setFromCDN(boolean z) {
        if (this.kkm != null) {
            this.kkm.setFromCDN(z);
            this.kkH.setFromCDN(z);
            this.kkA.setFromCDN(z);
            this.kkD.setFromCDN(z);
        }
        if (this.kkq != null) {
            this.kkq.setFromCDN(z);
        }
        if (this.kkz != null) {
            this.kkz.setFromCDN(z);
        }
        if (this.kkN != null && (this.kkN instanceof com.baidu.tieba.recapp.o)) {
            ((com.baidu.tieba.recapp.o) this.kkN).setIsFromCDN(z);
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.kkl != null) {
            this.kkl.setPageUniqueId(bdUniqueId);
        }
        if (this.kkm != null) {
            this.kkm.fGZ = bdUniqueId;
        }
        if (this.kkn != null) {
            this.kkn.fGZ = bdUniqueId;
        }
        if (this.kko != null) {
            this.kko.fGZ = bdUniqueId;
        }
        if (this.kkp != null) {
            this.kkp.fGZ = bdUniqueId;
        }
        if (this.kkq != null) {
            this.kkq.fGZ = bdUniqueId;
        }
        if (this.kkr != null) {
            this.kkr.fGZ = bdUniqueId;
        }
        if (this.kks != null) {
            this.kks.fGZ = bdUniqueId;
        }
        if (this.kkt != null) {
            this.kkt.fGZ = bdUniqueId;
        }
        if (this.kku != null) {
            this.kku.fGZ = bdUniqueId;
        }
        if (this.kkv != null) {
            this.kkv.fGZ = bdUniqueId;
        }
        if (this.kkw != null) {
            this.kkw.fGZ = bdUniqueId;
        }
        if (this.kkx != null) {
            this.kkx.fGZ = bdUniqueId;
        }
        if (this.kkA != null) {
            this.kkA.fGZ = bdUniqueId;
        }
        if (this.kky != null) {
            this.kky.fGZ = bdUniqueId;
        }
        if (this.kkj != null) {
            this.kkj.setPageUniqueId(bdUniqueId);
        }
        if (this.kkB != null) {
            this.kkB.fGZ = bdUniqueId;
        }
        if (this.kkC != null) {
            this.kkC.fGZ = bdUniqueId;
        }
        if (this.kkD != null) {
            this.kkD.fGZ = bdUniqueId;
        }
        if (this.kkE != null) {
            this.kkE.fGZ = bdUniqueId;
        }
        if (this.kkG != null) {
            this.kkG.fGZ = bdUniqueId;
        }
        if (this.kkF != null) {
            this.kkF.fGZ = bdUniqueId;
        }
        if (this.kkH != null) {
            this.kkH.fGZ = bdUniqueId;
        }
        if (this.kkI != null) {
            this.kkI.fGZ = bdUniqueId;
        }
        if (this.kkJ != null) {
            this.kkJ.fGZ = bdUniqueId;
        }
        if (this.kkK != null) {
            this.kkK.fGZ = bdUniqueId;
        }
        if (this.kkL != null) {
            this.kkL.fGZ = bdUniqueId;
        }
        if (this.kkz != null) {
            this.kkz.fGZ = bdUniqueId;
        }
        if (this.jZu != null) {
            this.jZu.fGZ = bdUniqueId;
        }
        if (!com.baidu.tbadk.core.util.y.isEmpty(this.jDM)) {
            for (com.baidu.adp.widget.ListView.a aVar : this.jDM) {
                if (aVar instanceof com.baidu.tieba.lego.card.adapter.a) {
                    ((com.baidu.tieba.lego.card.adapter.a) aVar).setUniqueId(bdUniqueId);
                }
            }
        }
        this.faJ.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.faJ);
        this.mLikeForumListener.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.mLikeForumListener);
        this.mUnlikeForumListener.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.mUnlikeForumListener);
        this.iwK.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.iwK);
        if (!this.kkU) {
            this.jDO.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.jDO);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aM(Object obj) {
        boolean z;
        boolean z2 = false;
        if (this.kki != null) {
            Iterator<com.baidu.adp.widget.ListView.n> it = this.kki.iterator();
            while (true) {
                z = z2;
                if (!it.hasNext()) {
                    break;
                }
                com.baidu.adp.widget.ListView.n next = it.next();
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

    private void cRu() {
        this.kkU = cRv();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean cRv() {
        if (this.jDM == null || this.jDM.size() <= 0) {
            this.jDM = new ArrayList();
            ArrayList<BdUniqueId> dML = com.baidu.tieba.tbadkCore.v.dML();
            if (dML == null || dML.size() <= 0) {
                return false;
            }
            int size = dML.size();
            for (int i = 0; i < size; i++) {
                com.baidu.tieba.lego.card.adapter.a a2 = com.baidu.tieba.lego.d.b.dcT().a(this.mPageContext, dML.get(i), 2);
                if (this.kkT) {
                    a2.setBusinessType(3);
                }
                if (this.kkm != null && this.kkm.fGZ != null) {
                    a2.setUniqueId(this.kkm.fGZ);
                }
                this.jDM.add(a2);
            }
            this.kkh.addAdapters(this.jDM);
            return true;
        }
        return true;
    }

    public void a(FollowUserButton.a aVar) {
        for (com.baidu.adp.widget.ListView.a aVar2 : this.jNU) {
            if (aVar2 instanceof com.baidu.tieba.homepage.a) {
                ((com.baidu.tieba.homepage.a) aVar2).a(aVar);
            }
        }
    }

    public void b(NEGFeedBackView.a aVar) {
        if (this.kkm != null) {
            this.kkm.setEventCallback(aVar);
        }
        if (this.kkr != null) {
            this.kkr.setEventCallback(aVar);
        }
        if (this.kkp != null) {
            this.kkp.setEventCallback(aVar);
        }
        if (this.kkA != null) {
            this.kkA.setEventCallback(aVar);
        }
        if (this.kkB != null) {
            this.kkB.setEventCallback(aVar);
        }
        if (this.kkC != null) {
            this.kkC.setEventCallback(aVar);
        }
        if (this.kkD != null) {
            this.kkD.setEventCallback(aVar);
        }
        if (this.kkE != null) {
            this.kkE.setEventCallback(aVar);
        }
        if (this.kkG != null) {
            this.kkG.setEventCallback(aVar);
        }
        if (this.kkF != null) {
            this.kkF.setEventCallback(aVar);
        }
        if (this.kkH != null) {
            this.kkH.setEventCallback(aVar);
        }
        if (this.kkI != null) {
            this.kkI.setEventCallback(aVar);
        }
        if (this.kkJ != null) {
            this.kkJ.setEventCallback(aVar);
        }
        if (this.kkK != null) {
            this.kkK.setEventCallback(aVar);
        }
        if (this.kkL != null) {
            this.kkL.setEventCallback(aVar);
        }
    }

    private void Ey(String str) {
        if (this.jNU != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.jNU) {
                if (aVar instanceof com.baidu.tieba.a.f) {
                    ((com.baidu.tieba.a.f) aVar).Ey(str);
                }
            }
        }
    }

    private boolean g(com.baidu.adp.widget.ListView.n nVar) {
        AdvertAppInfo advertAppInfo;
        return nVar != null && (nVar instanceof com.baidu.tieba.homepage.personalize.data.a) && (advertAppInfo = ((com.baidu.tieba.homepage.personalize.data.a) nVar).iAn) != null && advertAppInfo.blD() == 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.baidu.afd.videopaster.data.b Ll(String str) {
        int i;
        com.baidu.tieba.card.data.l lVar;
        if (this.kki == null || this.kki.isEmpty() || str == null) {
            return null;
        }
        com.baidu.afd.videopaster.data.b bVar = new com.baidu.afd.videopaster.data.b();
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        boolean z = false;
        int i5 = -1;
        int i6 = -1;
        while (true) {
            if (i2 >= this.kki.size()) {
                i = -1;
                break;
            }
            if (this.kki.get(i2) instanceof com.baidu.tieba.homepage.personalize.data.h) {
                i3++;
            }
            if (this.kki.get(i2) instanceof com.baidu.tieba.homepage.personalize.data.a) {
                if (g(this.kki.get(i2))) {
                    if (z) {
                        i = ((com.baidu.tieba.homepage.personalize.data.a) this.kki.get(i2)).position;
                        break;
                    }
                    i6 = ((com.baidu.tieba.homepage.personalize.data.a) this.kki.get(i2)).position;
                } else if (z) {
                    i4++;
                }
            }
            if ((this.kki.get(i2) instanceof com.baidu.tieba.card.data.l) && (lVar = (com.baidu.tieba.card.data.l) this.kki.get(i2)) != null && lVar.eJQ != null && str.equals(lVar.eJQ.getId())) {
                z = true;
                i5 = ((com.baidu.tieba.card.data.l) this.kki.get(i2)).position;
            }
            i2++;
        }
        if (i != -1 && (i = i - i4) < -1) {
            i = -1;
        }
        bVar.setVideoId(str);
        bVar.bf(i5 - i3 >= -1 ? i5 - i3 : -1);
        bVar.bg(i6);
        bVar.bh(i);
        return bVar;
    }

    public void onPause() {
        if (this.kky != null) {
            this.kky.onPause();
        }
    }

    public void onResume() {
        if (this.kky != null) {
            this.kky.onResume();
        }
        notifyDataSetChanged();
    }

    public void onDestroy() {
    }

    public List<com.baidu.adp.widget.ListView.n> getDataList() {
        return this.kki;
    }

    public void a(a aVar) {
        this.kio = aVar;
    }
}
