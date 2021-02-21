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
    private List<com.baidu.adp.widget.ListView.a> jEa;
    private com.baidu.tieba.homepage.concern.adapter.z jZI;
    private a kiC;
    private n kkA;
    private x kkB;
    private h kkC;
    private i kkD;
    private j kkE;
    private r kkF;
    private k kkG;
    private o kkH;
    private m kkI;
    private g kkJ;
    private f kkK;
    private e kkL;
    private y kkM;
    private d kkN;
    private l kkO;
    private HomePageAlaLiveThreadAdapter kkP;
    private HomePageAlaFriendRoomAdapter kkQ;
    private v kkR;
    private u kkS;
    private w kkT;
    private t kkU;
    private n kkV;
    private p kkW;
    private q kkX;
    private s kkY;
    private c kkZ;
    private com.baidu.adp.widget.ListView.s kkv;
    private List<com.baidu.adp.widget.ListView.n> kkw;
    private com.baidu.tieba.homepage.personalize.adapter.a kkx;
    private z kky;
    private b kkz;
    private com.baidu.adp.widget.ListView.a kla;
    private com.baidu.adp.widget.ListView.a klb;
    private com.baidu.adp.widget.ListView.a klc;
    private com.baidu.adp.widget.ListView.a kld;
    private com.baidu.adp.widget.ListView.a kle;
    private com.baidu.adp.widget.ListView.a klf;
    private com.baidu.adp.widget.ListView.a klg;
    private boolean klh;
    private boolean kli;
    private TbPageContext<?> mPageContext;
    private CustomMessageListener jEc = new CustomMessageListener(CmdConfigCustom.CMD_LEGO_REGISTER) { // from class: com.baidu.tieba.homepage.personalize.adapter.ab.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                ab.this.cRC();
                if (ab.this.kkw != null) {
                    ab.this.cx(ab.this.kkw);
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
    private CustomMessageListener iwY = new CustomMessageListener(2921394) { // from class: com.baidu.tieba.homepage.personalize.adapter.ab.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            com.baidu.afd.videopaster.data.b Lm;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (!StringUtils.isNull(str, true) && (Lm = ab.this.Lm(str)) != null) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921395, Lm));
                }
            }
        }
    };
    private List<com.baidu.adp.widget.ListView.a> jOi = new ArrayList();

    /* loaded from: classes2.dex */
    public interface a {
        void Mk();
    }

    public ab(Context context, com.baidu.adp.widget.ListView.s sVar) {
        this.kkv = sVar;
        this.mPageContext = (TbPageContext) com.baidu.adp.base.j.K(context);
        gm(context);
        a(sVar);
        sVar.addAdapters(this.jOi);
    }

    private void gm(Context context) {
        this.kkx = new com.baidu.tieba.homepage.personalize.adapter.a(this.mPageContext);
        this.kky = new z(this.mPageContext);
        this.kkz = new b(this.mPageContext, com.baidu.tieba.homepage.personalize.data.f.klI);
        this.kkA = new n(this.mPageContext, com.baidu.tieba.card.data.k.TYPE);
        this.kkB = new x(this.mPageContext, com.baidu.tieba.card.data.k.iBb);
        this.kkC = new h(this.mPageContext, com.baidu.tieba.card.data.k.iBh);
        this.kkD = new i(this.mPageContext, com.baidu.tieba.card.data.k.eQr);
        this.kkE = new j(this.mPageContext, com.baidu.tieba.card.data.k.iBi);
        this.kkF = new r(this.mPageContext, com.baidu.tieba.card.data.k.iBg);
        this.kkG = new k(this.mPageContext, com.baidu.tieba.card.data.k.eQD);
        this.kkH = new o(this.mPageContext, com.baidu.tieba.card.data.k.eQF);
        this.kkI = new m(this.mPageContext, com.baidu.tieba.card.data.k.eQG);
        this.kkJ = new g(this.mPageContext, com.baidu.tieba.card.data.k.iBc);
        this.kkK = new f(this.mPageContext, com.baidu.tieba.card.data.k.iBd);
        this.kkL = new e(this.mPageContext, com.baidu.tieba.card.data.k.iBe);
        this.kkM = new y(this.mPageContext, com.baidu.tieba.card.data.l.eQK);
        this.kkO = new l(this.mPageContext, com.baidu.tieba.card.data.k.eQI);
        this.kkP = new HomePageAlaLiveThreadAdapter(this.mPageContext, com.baidu.tieba.card.data.j.TYPE);
        this.kkQ = new HomePageAlaFriendRoomAdapter(this.mPageContext, com.baidu.tieba.card.data.j.iAH);
        this.kkR = new v(this.mPageContext, com.baidu.tieba.card.data.k.eQP);
        this.kkS = new u(this.mPageContext, com.baidu.tieba.card.data.k.eQQ);
        this.kkT = new w(this.mPageContext, com.baidu.tieba.card.data.k.eQS);
        this.kkU = new t(this.mPageContext, com.baidu.tieba.card.data.k.eQR);
        this.kkV = new n(this.mPageContext, com.baidu.tieba.card.data.k.iAZ);
        this.kkW = new p(this.mPageContext, com.baidu.tieba.card.data.k.eQW);
        this.kkX = new q(this.mPageContext, com.baidu.tieba.card.data.k.eQX);
        this.kkY = new s(this.mPageContext, com.baidu.tieba.homepage.topic.topictab.b.a.kqe);
        this.kkZ = new c(this.mPageContext, com.baidu.tieba.card.data.e.iAC);
        this.kkN = new d(this.mPageContext, com.baidu.tieba.card.data.k.iBf);
        this.jZI = new com.baidu.tieba.homepage.concern.adapter.z(this.mPageContext, com.baidu.tieba.card.data.k.iBa, (byte) 3);
        this.jOi.add(this.kkx);
        this.jOi.add(this.kky);
        this.jOi.add(this.kkz);
        this.jOi.add(this.kkA);
        this.jOi.add(this.kkB);
        this.jOi.add(this.kkC);
        this.jOi.add(this.kkD);
        this.jOi.add(this.kkE);
        this.jOi.add(this.kkF);
        this.jOi.add(this.kkG);
        this.jOi.add(this.kkH);
        this.jOi.add(this.kkI);
        this.jOi.add(this.kkJ);
        this.jOi.add(this.kkK);
        this.jOi.add(this.kkL);
        this.jOi.add(this.kkM);
        this.jOi.add(this.kkO);
        this.jOi.add(this.kkV);
        this.jOi.add(new ReadProgessDelegetAdapter(this.mPageContext, com.baidu.tieba.homepage.personalize.readProgressBar.b.TYPE));
        this.jOi.add(this.kkP);
        this.jOi.add(this.kkQ);
        this.jOi.add(this.kkR);
        this.jOi.add(this.kkS);
        this.jOi.add(this.kkU);
        this.jOi.add(this.kkT);
        this.jOi.add(new aa(this.mPageContext, com.baidu.tieba.homepage.personalize.data.h.TYPE));
        this.jOi.add(this.kkW);
        this.jOi.add(this.kkX);
        this.jOi.add(this.kkY);
        this.jOi.add(this.kkZ);
        this.jOi.add(this.kkN);
        this.jOi.add(this.jZI);
        cRB();
        cOL();
        Ew("page_recommend");
    }

    private void cOL() {
        if (!cb.eRa.get()) {
            AdvertAppInfo.eLs.set(false);
            return;
        }
        this.kla = com.baidu.tieba.recapp.s.dDt().a(this.mPageContext, AdvertAppInfo.eLg, "INDEX");
        this.klb = com.baidu.tieba.recapp.s.dDt().a(this.mPageContext, AdvertAppInfo.eLj, "INDEX");
        this.klc = com.baidu.tieba.recapp.s.dDt().a(this.mPageContext, AdvertAppInfo.eLn, "INDEX");
        this.kld = com.baidu.tieba.recapp.s.dDt().a(this.mPageContext, AdvertAppInfo.eLo, "INDEX");
        this.kle = com.baidu.tieba.recapp.s.dDt().a(this.mPageContext, AdvertAppInfo.eLp, "INDEX");
        this.klf = com.baidu.tieba.recapp.s.dDt().a(this.mPageContext, AdvertAppInfo.eLr, "INDEX");
        this.klg = com.baidu.tieba.recapp.s.dDt().a(this.mPageContext, AdvertAppInfo.eLq, "INDEX");
        this.jOi.add(this.kla);
        this.jOi.add(this.klb);
        this.jOi.add(this.klc);
        this.jOi.add(this.kld);
        this.jOi.add(this.kle);
        this.jOi.add(this.klf);
        this.jOi.add(this.klg);
        AdvertAppInfo.eLs.set(true);
    }

    public void b(com.baidu.tieba.homepage.personalize.model.e eVar) {
        this.kkA.a(eVar);
        this.kkB.a(eVar);
        this.kkC.a(eVar);
        this.kkE.a(eVar);
        this.kkF.a(eVar);
        this.kkJ.a(eVar);
        this.kkK.a(eVar);
        this.kkL.a(eVar);
        this.kkM.a(eVar);
        this.kkN.a(eVar);
    }

    private void a(com.baidu.adp.widget.ListView.s sVar) {
        this.kkB.a(sVar);
        this.kkC.a(sVar);
        this.kkD.a(sVar);
        this.kkE.a(sVar);
        this.kkF.a(sVar);
        this.kkG.a(sVar);
        this.kkH.a(sVar);
        this.kkI.a(sVar);
        this.kkJ.a(sVar);
        this.kkK.a(sVar);
        this.kkL.a(sVar);
        this.kkN.a(sVar);
        this.kkM.a(sVar);
        this.kkZ.a(sVar);
        this.kkS.a(sVar);
        this.kkS.a(sVar);
        this.kkU.a(sVar);
        this.jZI.a(sVar);
    }

    public void j(List<com.baidu.adp.widget.ListView.n> list, int i) {
        com.baidu.tieba.tbadkCore.v.x(list, 2);
        ViewGroup listView = this.kkv.getListView();
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
        this.kkv.setData(list);
        this.kkw = list;
        if (this.kiC != null) {
            this.kiC.Mk();
        }
    }

    public void cx(List<com.baidu.adp.widget.ListView.n> list) {
        com.baidu.tieba.tbadkCore.v.x(list, 2);
        this.kkv.setData(list);
        this.kkw = list;
        if (this.kiC != null) {
            this.kiC.Mk();
        }
    }

    public void onChangeSkinType(int i) {
        notifyDataSetChanged();
        this.kkx.onChangeSkinType(i);
    }

    public void notifyDataSetChanged() {
        if (this.kkv != null) {
            this.kkv.getListAdapter().notifyDataSetChanged();
        }
    }

    public void setFromCDN(boolean z) {
        if (this.kkA != null) {
            this.kkA.setFromCDN(z);
            this.kkV.setFromCDN(z);
            this.kkO.setFromCDN(z);
            this.kkR.setFromCDN(z);
        }
        if (this.kkE != null) {
            this.kkE.setFromCDN(z);
        }
        if (this.kkN != null) {
            this.kkN.setFromCDN(z);
        }
        if (this.klb != null && (this.klb instanceof com.baidu.tieba.recapp.p)) {
            ((com.baidu.tieba.recapp.p) this.klb).setIsFromCDN(z);
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.kkz != null) {
            this.kkz.setPageUniqueId(bdUniqueId);
        }
        if (this.kkA != null) {
            this.kkA.fGZ = bdUniqueId;
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
        if (this.kkF != null) {
            this.kkF.fGZ = bdUniqueId;
        }
        if (this.kkG != null) {
            this.kkG.fGZ = bdUniqueId;
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
        if (this.kkO != null) {
            this.kkO.fGZ = bdUniqueId;
        }
        if (this.kkM != null) {
            this.kkM.fGZ = bdUniqueId;
        }
        if (this.kkx != null) {
            this.kkx.setPageUniqueId(bdUniqueId);
        }
        if (this.kkP != null) {
            this.kkP.fGZ = bdUniqueId;
        }
        if (this.kkQ != null) {
            this.kkQ.fGZ = bdUniqueId;
        }
        if (this.kkR != null) {
            this.kkR.fGZ = bdUniqueId;
        }
        if (this.kkS != null) {
            this.kkS.fGZ = bdUniqueId;
        }
        if (this.kkU != null) {
            this.kkU.fGZ = bdUniqueId;
        }
        if (this.kkT != null) {
            this.kkT.fGZ = bdUniqueId;
        }
        if (this.kkV != null) {
            this.kkV.fGZ = bdUniqueId;
        }
        if (this.kkW != null) {
            this.kkW.fGZ = bdUniqueId;
        }
        if (this.kkX != null) {
            this.kkX.fGZ = bdUniqueId;
        }
        if (this.kkY != null) {
            this.kkY.fGZ = bdUniqueId;
        }
        if (this.kkZ != null) {
            this.kkZ.fGZ = bdUniqueId;
        }
        if (this.kkN != null) {
            this.kkN.fGZ = bdUniqueId;
        }
        if (this.jZI != null) {
            this.jZI.fGZ = bdUniqueId;
        }
        if (!com.baidu.tbadk.core.util.y.isEmpty(this.jEa)) {
            for (com.baidu.adp.widget.ListView.a aVar : this.jEa) {
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
        this.iwY.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.iwY);
        if (!this.kli) {
            this.jEc.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.jEc);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aM(Object obj) {
        boolean z;
        boolean z2 = false;
        if (this.kkw != null) {
            Iterator<com.baidu.adp.widget.ListView.n> it = this.kkw.iterator();
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

    private void cRB() {
        this.kli = cRC();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean cRC() {
        if (this.jEa == null || this.jEa.size() <= 0) {
            this.jEa = new ArrayList();
            ArrayList<BdUniqueId> dMT = com.baidu.tieba.tbadkCore.v.dMT();
            if (dMT == null || dMT.size() <= 0) {
                return false;
            }
            int size = dMT.size();
            for (int i = 0; i < size; i++) {
                com.baidu.tieba.lego.card.adapter.a a2 = com.baidu.tieba.lego.d.b.dda().a(this.mPageContext, dMT.get(i), 2);
                if (this.klh) {
                    a2.setBusinessType(3);
                }
                if (this.kkA != null && this.kkA.fGZ != null) {
                    a2.setUniqueId(this.kkA.fGZ);
                }
                this.jEa.add(a2);
            }
            this.kkv.addAdapters(this.jEa);
            return true;
        }
        return true;
    }

    public void a(FollowUserButton.a aVar) {
        for (com.baidu.adp.widget.ListView.a aVar2 : this.jOi) {
            if (aVar2 instanceof com.baidu.tieba.homepage.a) {
                ((com.baidu.tieba.homepage.a) aVar2).a(aVar);
            }
        }
    }

    public void b(NEGFeedBackView.a aVar) {
        if (this.kkA != null) {
            this.kkA.setEventCallback(aVar);
        }
        if (this.kkF != null) {
            this.kkF.setEventCallback(aVar);
        }
        if (this.kkD != null) {
            this.kkD.setEventCallback(aVar);
        }
        if (this.kkO != null) {
            this.kkO.setEventCallback(aVar);
        }
        if (this.kkP != null) {
            this.kkP.setEventCallback(aVar);
        }
        if (this.kkQ != null) {
            this.kkQ.setEventCallback(aVar);
        }
        if (this.kkR != null) {
            this.kkR.setEventCallback(aVar);
        }
        if (this.kkS != null) {
            this.kkS.setEventCallback(aVar);
        }
        if (this.kkU != null) {
            this.kkU.setEventCallback(aVar);
        }
        if (this.kkT != null) {
            this.kkT.setEventCallback(aVar);
        }
        if (this.kkV != null) {
            this.kkV.setEventCallback(aVar);
        }
        if (this.kkW != null) {
            this.kkW.setEventCallback(aVar);
        }
        if (this.kkX != null) {
            this.kkX.setEventCallback(aVar);
        }
        if (this.kkY != null) {
            this.kkY.setEventCallback(aVar);
        }
        if (this.kkZ != null) {
            this.kkZ.setEventCallback(aVar);
        }
    }

    private void Ew(String str) {
        if (this.jOi != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.jOi) {
                if (aVar instanceof com.baidu.tieba.a.f) {
                    ((com.baidu.tieba.a.f) aVar).Ew(str);
                }
            }
        }
    }

    private boolean g(com.baidu.adp.widget.ListView.n nVar) {
        AdvertAppInfo advertAppInfo;
        return nVar != null && (nVar instanceof com.baidu.tieba.homepage.personalize.data.a) && (advertAppInfo = ((com.baidu.tieba.homepage.personalize.data.a) nVar).iAB) != null && advertAppInfo.blD() == 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.baidu.afd.videopaster.data.b Lm(String str) {
        int i;
        com.baidu.tieba.card.data.l lVar;
        if (this.kkw == null || this.kkw.isEmpty() || str == null) {
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
            if (i2 >= this.kkw.size()) {
                i = -1;
                break;
            }
            if (this.kkw.get(i2) instanceof com.baidu.tieba.homepage.personalize.data.h) {
                i3++;
            }
            if (this.kkw.get(i2) instanceof com.baidu.tieba.homepage.personalize.data.a) {
                if (g(this.kkw.get(i2))) {
                    if (z) {
                        i = ((com.baidu.tieba.homepage.personalize.data.a) this.kkw.get(i2)).position;
                        break;
                    }
                    i6 = ((com.baidu.tieba.homepage.personalize.data.a) this.kkw.get(i2)).position;
                } else if (z) {
                    i4++;
                }
            }
            if ((this.kkw.get(i2) instanceof com.baidu.tieba.card.data.l) && (lVar = (com.baidu.tieba.card.data.l) this.kkw.get(i2)) != null && lVar.eJQ != null && str.equals(lVar.eJQ.getId())) {
                z = true;
                i5 = ((com.baidu.tieba.card.data.l) this.kkw.get(i2)).position;
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
        if (this.kkM != null) {
            this.kkM.onPause();
        }
    }

    public void onResume() {
        if (this.kkM != null) {
            this.kkM.onResume();
        }
        notifyDataSetChanged();
    }

    public void onDestroy() {
    }

    public List<com.baidu.adp.widget.ListView.n> getDataList() {
        return this.kkw;
    }

    public void a(a aVar) {
        this.kiC = aVar;
    }
}
