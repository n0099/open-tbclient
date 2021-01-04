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
import com.baidu.tbadk.core.data.bz;
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
    private List<com.baidu.adp.widget.ListView.a> jCN;
    private com.baidu.tieba.homepage.concern.adapter.z jWy;
    private com.baidu.adp.widget.ListView.s kgD;
    private List<com.baidu.adp.widget.ListView.n> kgE;
    private a kgF;
    private z kgG;
    private b kgH;
    private n kgI;
    private x kgJ;
    private h kgK;
    private i kgL;
    private j kgM;
    private r kgN;
    private k kgO;
    private o kgP;
    private m kgQ;
    private g kgR;
    private f kgS;
    private e kgT;
    private y kgU;
    private d kgV;
    private l kgW;
    private HomePageAlaLiveThreadAdapter kgX;
    private HomePageAlaFriendRoomAdapter kgY;
    private v kgZ;
    private u kha;
    private w khb;
    private t khc;
    private n khd;
    private p khe;
    private q khf;
    private s khg;
    private c khh;
    private com.baidu.adp.widget.ListView.a khi;
    private com.baidu.adp.widget.ListView.a khj;
    private com.baidu.adp.widget.ListView.a khk;
    private com.baidu.adp.widget.ListView.a khl;
    private com.baidu.adp.widget.ListView.a khm;
    private com.baidu.adp.widget.ListView.a khn;
    private com.baidu.adp.widget.ListView.a kho;
    private boolean khp;
    private boolean khq;
    private TbPageContext<?> mPageContext;
    private CustomMessageListener jCP = new CustomMessageListener(CmdConfigCustom.CMD_LEGO_REGISTER) { // from class: com.baidu.tieba.homepage.personalize.adapter.ab.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                ab.this.cTn();
                if (ab.this.kgE != null) {
                    ab.this.cC(ab.this.kgE);
                }
            }
        }
    };
    private CustomMessageListener fdd = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.homepage.personalize.adapter.ab.2
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
                bVar.eSj = true;
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
                bVar.eSj = false;
                ab.this.aM(bVar);
            }
        }
    };
    private CustomMessageListener ivN = new CustomMessageListener(2921394) { // from class: com.baidu.tieba.homepage.personalize.adapter.ab.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            com.baidu.afd.videopaster.data.b LL;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (!StringUtils.isNull(str, true) && (LL = ab.this.LL(str)) != null) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921395, LL));
                }
            }
        }
    };
    private List<com.baidu.adp.widget.ListView.a> jVU = new ArrayList();

    public ab(Context context, com.baidu.adp.widget.ListView.s sVar) {
        this.kgD = sVar;
        this.mPageContext = (TbPageContext) com.baidu.adp.base.j.K(context);
        gn(context);
        a(sVar);
        sVar.addAdapters(this.jVU);
    }

    private void gn(Context context) {
        this.kgF = new a(this.mPageContext);
        this.kgG = new z(this.mPageContext);
        this.kgH = new b(this.mPageContext, com.baidu.tieba.homepage.personalize.data.f.khQ);
        this.kgI = new n(this.mPageContext, com.baidu.tieba.card.data.k.TYPE);
        this.kgJ = new x(this.mPageContext, com.baidu.tieba.card.data.k.izK);
        this.kgK = new h(this.mPageContext, com.baidu.tieba.card.data.k.izQ);
        this.kgL = new i(this.mPageContext, com.baidu.tieba.card.data.k.eSQ);
        this.kgM = new j(this.mPageContext, com.baidu.tieba.card.data.k.izR);
        this.kgN = new r(this.mPageContext, com.baidu.tieba.card.data.k.izP);
        this.kgO = new k(this.mPageContext, com.baidu.tieba.card.data.k.eTc);
        this.kgP = new o(this.mPageContext, com.baidu.tieba.card.data.k.eTe);
        this.kgQ = new m(this.mPageContext, com.baidu.tieba.card.data.k.eTf);
        this.kgR = new g(this.mPageContext, com.baidu.tieba.card.data.k.izL);
        this.kgS = new f(this.mPageContext, com.baidu.tieba.card.data.k.izM);
        this.kgT = new e(this.mPageContext, com.baidu.tieba.card.data.k.izN);
        this.kgU = new y(this.mPageContext, com.baidu.tieba.card.data.l.eTj);
        this.kgW = new l(this.mPageContext, com.baidu.tieba.card.data.k.eTh);
        this.kgX = new HomePageAlaLiveThreadAdapter(this.mPageContext, com.baidu.tieba.card.data.j.TYPE);
        this.kgY = new HomePageAlaFriendRoomAdapter(this.mPageContext, com.baidu.tieba.card.data.j.izq);
        this.kgZ = new v(this.mPageContext, com.baidu.tieba.card.data.k.eTo);
        this.kha = new u(this.mPageContext, com.baidu.tieba.card.data.k.eTp);
        this.khb = new w(this.mPageContext, com.baidu.tieba.card.data.k.eTr);
        this.khc = new t(this.mPageContext, com.baidu.tieba.card.data.k.eTq);
        this.khd = new n(this.mPageContext, com.baidu.tieba.card.data.k.izI);
        this.khe = new p(this.mPageContext, com.baidu.tieba.card.data.k.eTv);
        this.khf = new q(this.mPageContext, com.baidu.tieba.card.data.k.eTw);
        this.khg = new s(this.mPageContext, com.baidu.tieba.homepage.topic.topictab.b.a.kmo);
        this.khh = new c(this.mPageContext, com.baidu.tieba.card.data.e.izl);
        this.kgV = new d(this.mPageContext, com.baidu.tieba.card.data.k.izO);
        this.jWy = new com.baidu.tieba.homepage.concern.adapter.z(this.mPageContext, com.baidu.tieba.card.data.k.izJ, (byte) 3);
        this.jVU.add(this.kgF);
        this.jVU.add(this.kgG);
        this.jVU.add(this.kgH);
        this.jVU.add(this.kgI);
        this.jVU.add(this.kgJ);
        this.jVU.add(this.kgK);
        this.jVU.add(this.kgL);
        this.jVU.add(this.kgM);
        this.jVU.add(this.kgN);
        this.jVU.add(this.kgO);
        this.jVU.add(this.kgP);
        this.jVU.add(this.kgQ);
        this.jVU.add(this.kgR);
        this.jVU.add(this.kgS);
        this.jVU.add(this.kgT);
        this.jVU.add(this.kgU);
        this.jVU.add(this.kgW);
        this.jVU.add(this.khd);
        this.jVU.add(new ReadProgessDelegetAdapter(this.mPageContext, com.baidu.tieba.homepage.personalize.readProgressBar.b.TYPE));
        this.jVU.add(this.kgX);
        this.jVU.add(this.kgY);
        this.jVU.add(this.kgZ);
        this.jVU.add(this.kha);
        this.jVU.add(this.khc);
        this.jVU.add(this.khb);
        this.jVU.add(new aa(this.mPageContext, com.baidu.tieba.homepage.personalize.data.h.TYPE));
        this.jVU.add(this.khe);
        this.jVU.add(this.khf);
        this.jVU.add(this.khg);
        this.jVU.add(this.khh);
        this.jVU.add(this.kgV);
        this.jVU.add(this.jWy);
        cTm();
        cQy();
        Fm("page_recommend");
    }

    private void cQy() {
        if (!bz.eTz.get()) {
            AdvertAppInfo.eNR.set(false);
            return;
        }
        this.khi = com.baidu.tieba.recapp.r.dEV().a(this.mPageContext, AdvertAppInfo.eNF, "INDEX");
        this.khj = com.baidu.tieba.recapp.r.dEV().a(this.mPageContext, AdvertAppInfo.eNI, "INDEX");
        this.khk = com.baidu.tieba.recapp.r.dEV().a(this.mPageContext, AdvertAppInfo.eNM, "INDEX");
        this.khl = com.baidu.tieba.recapp.r.dEV().a(this.mPageContext, AdvertAppInfo.eNN, "INDEX");
        this.khm = com.baidu.tieba.recapp.r.dEV().a(this.mPageContext, AdvertAppInfo.eNO, "INDEX");
        this.khn = com.baidu.tieba.recapp.r.dEV().a(this.mPageContext, AdvertAppInfo.eNQ, "INDEX");
        this.kho = com.baidu.tieba.recapp.r.dEV().a(this.mPageContext, AdvertAppInfo.eNP, "INDEX");
        this.jVU.add(this.khi);
        this.jVU.add(this.khj);
        this.jVU.add(this.khk);
        this.jVU.add(this.khl);
        this.jVU.add(this.khm);
        this.jVU.add(this.khn);
        this.jVU.add(this.kho);
        AdvertAppInfo.eNR.set(true);
    }

    public void b(com.baidu.tieba.homepage.personalize.model.e eVar) {
        this.kgI.a(eVar);
        this.kgJ.a(eVar);
        this.kgK.a(eVar);
        this.kgM.a(eVar);
        this.kgN.a(eVar);
        this.kgR.a(eVar);
        this.kgS.a(eVar);
        this.kgT.a(eVar);
        this.kgU.a(eVar);
        this.kgV.a(eVar);
    }

    private void a(com.baidu.adp.widget.ListView.s sVar) {
        this.kgJ.a(sVar);
        this.kgK.a(sVar);
        this.kgL.a(sVar);
        this.kgM.a(sVar);
        this.kgN.a(sVar);
        this.kgO.a(sVar);
        this.kgP.a(sVar);
        this.kgQ.a(sVar);
        this.kgR.a(sVar);
        this.kgS.a(sVar);
        this.kgT.a(sVar);
        this.kgV.a(sVar);
        this.kgU.a(sVar);
        this.khh.a(sVar);
        this.kha.a(sVar);
        this.kha.a(sVar);
        this.khc.a(sVar);
        this.jWy.a(sVar);
    }

    public void j(List<com.baidu.adp.widget.ListView.n> list, int i) {
        com.baidu.tieba.tbadkCore.v.x(list, 2);
        ViewGroup listView = this.kgD.getListView();
        if (i > 0 && (listView instanceof BdRecyclerView)) {
            int firstVisiblePosition = ((BdRecyclerView) listView).getFirstVisiblePosition();
            View childAt = ((BdRecyclerView) listView).getChildAt(0);
            int top = childAt == null ? 0 : childAt.getTop();
            RecyclerView.LayoutManager layoutManager = ((BdRecyclerView) listView).getLayoutManager();
            int i2 = firstVisiblePosition - i;
            if (layoutManager instanceof LinearLayoutManager) {
                ((BdRecyclerView) listView).qv();
                ((LinearLayoutManager) layoutManager).scrollToPositionWithOffset(i2, top);
                ((BdRecyclerView) listView).qw();
            }
        }
        this.kgD.setData(list);
        this.kgE = list;
    }

    public void cC(List<com.baidu.adp.widget.ListView.n> list) {
        com.baidu.tieba.tbadkCore.v.x(list, 2);
        this.kgD.setData(list);
        this.kgE = list;
    }

    public void onChangeSkinType(int i) {
        notifyDataSetChanged();
        this.kgF.onChangeSkinType(i);
    }

    public void notifyDataSetChanged() {
        if (this.kgD != null) {
            this.kgD.getListAdapter().notifyDataSetChanged();
        }
    }

    public void setFromCDN(boolean z) {
        if (this.kgI != null) {
            this.kgI.setFromCDN(z);
            this.khd.setFromCDN(z);
            this.kgW.setFromCDN(z);
            this.kgZ.setFromCDN(z);
        }
        if (this.kgM != null) {
            this.kgM.setFromCDN(z);
        }
        if (this.kgV != null) {
            this.kgV.setFromCDN(z);
        }
        if (this.khj != null && (this.khj instanceof com.baidu.tieba.recapp.o)) {
            ((com.baidu.tieba.recapp.o) this.khj).setIsFromCDN(z);
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.kgH != null) {
            this.kgH.setPageUniqueId(bdUniqueId);
        }
        if (this.kgI != null) {
            this.kgI.fJu = bdUniqueId;
        }
        if (this.kgJ != null) {
            this.kgJ.fJu = bdUniqueId;
        }
        if (this.kgK != null) {
            this.kgK.fJu = bdUniqueId;
        }
        if (this.kgL != null) {
            this.kgL.fJu = bdUniqueId;
        }
        if (this.kgM != null) {
            this.kgM.fJu = bdUniqueId;
        }
        if (this.kgN != null) {
            this.kgN.fJu = bdUniqueId;
        }
        if (this.kgO != null) {
            this.kgO.fJu = bdUniqueId;
        }
        if (this.kgP != null) {
            this.kgP.fJu = bdUniqueId;
        }
        if (this.kgQ != null) {
            this.kgQ.fJu = bdUniqueId;
        }
        if (this.kgR != null) {
            this.kgR.fJu = bdUniqueId;
        }
        if (this.kgS != null) {
            this.kgS.fJu = bdUniqueId;
        }
        if (this.kgT != null) {
            this.kgT.fJu = bdUniqueId;
        }
        if (this.kgW != null) {
            this.kgW.fJu = bdUniqueId;
        }
        if (this.kgU != null) {
            this.kgU.fJu = bdUniqueId;
        }
        if (this.kgF != null) {
            this.kgF.setPageUniqueId(bdUniqueId);
        }
        if (this.kgX != null) {
            this.kgX.fJu = bdUniqueId;
        }
        if (this.kgY != null) {
            this.kgY.fJu = bdUniqueId;
        }
        if (this.kgZ != null) {
            this.kgZ.fJu = bdUniqueId;
        }
        if (this.kha != null) {
            this.kha.fJu = bdUniqueId;
        }
        if (this.khc != null) {
            this.khc.fJu = bdUniqueId;
        }
        if (this.khb != null) {
            this.khb.fJu = bdUniqueId;
        }
        if (this.khd != null) {
            this.khd.fJu = bdUniqueId;
        }
        if (this.khe != null) {
            this.khe.fJu = bdUniqueId;
        }
        if (this.khf != null) {
            this.khf.fJu = bdUniqueId;
        }
        if (this.khg != null) {
            this.khg.fJu = bdUniqueId;
        }
        if (this.khh != null) {
            this.khh.fJu = bdUniqueId;
        }
        if (this.kgV != null) {
            this.kgV.fJu = bdUniqueId;
        }
        if (this.jWy != null) {
            this.jWy.fJu = bdUniqueId;
        }
        if (!com.baidu.tbadk.core.util.x.isEmpty(this.jCN)) {
            for (com.baidu.adp.widget.ListView.a aVar : this.jCN) {
                if (aVar instanceof com.baidu.tieba.lego.card.adapter.a) {
                    ((com.baidu.tieba.lego.card.adapter.a) aVar).setUniqueId(bdUniqueId);
                }
            }
        }
        this.fdd.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.fdd);
        this.mLikeForumListener.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.mLikeForumListener);
        this.mUnlikeForumListener.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.mUnlikeForumListener);
        this.ivN.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.ivN);
        if (!this.khq) {
            this.jCP.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.jCP);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aM(Object obj) {
        boolean z;
        boolean z2 = false;
        if (this.kgE != null) {
            Iterator<com.baidu.adp.widget.ListView.n> it = this.kgE.iterator();
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

    private void cTm() {
        this.khq = cTn();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean cTn() {
        if (this.jCN == null || this.jCN.size() <= 0) {
            this.jCN = new ArrayList();
            ArrayList<BdUniqueId> dOr = com.baidu.tieba.tbadkCore.v.dOr();
            if (dOr == null || dOr.size() <= 0) {
                return false;
            }
            int size = dOr.size();
            for (int i = 0; i < size; i++) {
                com.baidu.tieba.lego.card.adapter.a a2 = com.baidu.tieba.lego.d.b.deM().a(this.mPageContext, dOr.get(i), 2);
                if (this.khp) {
                    a2.setBusinessType(3);
                }
                if (this.kgI != null && this.kgI.fJu != null) {
                    a2.setUniqueId(this.kgI.fJu);
                }
                this.jCN.add(a2);
            }
            this.kgD.addAdapters(this.jCN);
            return true;
        }
        return true;
    }

    public void a(FollowUserButton.a aVar) {
        for (com.baidu.adp.widget.ListView.a aVar2 : this.jVU) {
            if (aVar2 instanceof com.baidu.tieba.homepage.a) {
                ((com.baidu.tieba.homepage.a) aVar2).a(aVar);
            }
        }
    }

    public void b(NEGFeedBackView.a aVar) {
        if (this.kgI != null) {
            this.kgI.setEventCallback(aVar);
        }
        if (this.kgN != null) {
            this.kgN.setEventCallback(aVar);
        }
        if (this.kgL != null) {
            this.kgL.setEventCallback(aVar);
        }
        if (this.kgW != null) {
            this.kgW.setEventCallback(aVar);
        }
        if (this.kgX != null) {
            this.kgX.setEventCallback(aVar);
        }
        if (this.kgY != null) {
            this.kgY.setEventCallback(aVar);
        }
        if (this.kgZ != null) {
            this.kgZ.setEventCallback(aVar);
        }
        if (this.kha != null) {
            this.kha.setEventCallback(aVar);
        }
        if (this.khc != null) {
            this.khc.setEventCallback(aVar);
        }
        if (this.khb != null) {
            this.khb.setEventCallback(aVar);
        }
        if (this.khd != null) {
            this.khd.setEventCallback(aVar);
        }
        if (this.khe != null) {
            this.khe.setEventCallback(aVar);
        }
        if (this.khf != null) {
            this.khf.setEventCallback(aVar);
        }
        if (this.khg != null) {
            this.khg.setEventCallback(aVar);
        }
        if (this.khh != null) {
            this.khh.setEventCallback(aVar);
        }
    }

    private void Fm(String str) {
        if (this.jVU != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.jVU) {
                if (aVar instanceof com.baidu.tieba.a.f) {
                    ((com.baidu.tieba.a.f) aVar).Fm(str);
                }
            }
        }
    }

    private boolean g(com.baidu.adp.widget.ListView.n nVar) {
        AdvertAppInfo advertAppInfo;
        return nVar != null && (nVar instanceof com.baidu.tieba.homepage.personalize.data.a) && (advertAppInfo = ((com.baidu.tieba.homepage.personalize.data.a) nVar).izk) != null && advertAppInfo.bpe() == 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.baidu.afd.videopaster.data.b LL(String str) {
        int i;
        com.baidu.tieba.card.data.l lVar;
        if (this.kgE == null || this.kgE.isEmpty() || str == null) {
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
            if (i2 >= this.kgE.size()) {
                i = -1;
                break;
            }
            if (this.kgE.get(i2) instanceof com.baidu.tieba.homepage.personalize.data.h) {
                i3++;
            }
            if (this.kgE.get(i2) instanceof com.baidu.tieba.homepage.personalize.data.a) {
                if (g(this.kgE.get(i2))) {
                    if (z) {
                        i = ((com.baidu.tieba.homepage.personalize.data.a) this.kgE.get(i2)).position;
                        break;
                    }
                    i6 = ((com.baidu.tieba.homepage.personalize.data.a) this.kgE.get(i2)).position;
                } else if (z) {
                    i4++;
                }
            }
            if ((this.kgE.get(i2) instanceof com.baidu.tieba.card.data.l) && (lVar = (com.baidu.tieba.card.data.l) this.kgE.get(i2)) != null && lVar.eMv != null && str.equals(lVar.eMv.getId())) {
                z = true;
                i5 = ((com.baidu.tieba.card.data.l) this.kgE.get(i2)).position;
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
        if (this.kgU != null) {
            this.kgU.onPause();
        }
    }

    public void onResume() {
        if (this.kgU != null) {
            this.kgU.onResume();
        }
        notifyDataSetChanged();
    }

    public void onDestroy() {
    }

    public List<com.baidu.adp.widget.ListView.n> getDataList() {
        return this.kgE;
    }
}
