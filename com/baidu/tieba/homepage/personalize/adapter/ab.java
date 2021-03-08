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
    private List<com.baidu.adp.widget.ListView.a> jFJ;
    private com.baidu.tieba.homepage.concern.adapter.z kbK;
    private a kkE;
    private z kmA;
    private b kmB;
    private n kmC;
    private x kmD;
    private h kmE;
    private i kmF;
    private j kmG;
    private r kmH;
    private k kmI;
    private o kmJ;
    private m kmK;
    private g kmL;
    private f kmM;
    private e kmN;
    private y kmO;
    private d kmP;
    private l kmQ;
    private HomePageAlaLiveThreadAdapter kmR;
    private HomePageAlaFriendRoomAdapter kmS;
    private v kmT;
    private u kmU;
    private w kmV;
    private t kmW;
    private n kmX;
    private p kmY;
    private q kmZ;
    private com.baidu.adp.widget.ListView.s kmx;
    private List<com.baidu.adp.widget.ListView.n> kmy;
    private com.baidu.tieba.homepage.personalize.adapter.a kmz;
    private s kna;
    private c knb;
    private com.baidu.adp.widget.ListView.a knc;
    private com.baidu.adp.widget.ListView.a knd;
    private com.baidu.adp.widget.ListView.a kne;
    private com.baidu.adp.widget.ListView.a knf;
    private com.baidu.adp.widget.ListView.a kng;
    private com.baidu.adp.widget.ListView.a knh;
    private com.baidu.adp.widget.ListView.a kni;
    private boolean knj;
    private boolean knk;
    private TbPageContext<?> mPageContext;
    private CustomMessageListener jFL = new CustomMessageListener(CmdConfigCustom.CMD_LEGO_REGISTER) { // from class: com.baidu.tieba.homepage.personalize.adapter.ab.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                ab.this.cRJ();
                if (ab.this.kmy != null) {
                    ab.this.cx(ab.this.kmy);
                }
            }
        }
    };
    private CustomMessageListener fci = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.homepage.personalize.adapter.ab.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
            if (updateAttentionMessage != null && updateAttentionMessage.getData() != null && updateAttentionMessage.getData().isSucc) {
                ab.this.aO(updateAttentionMessage.getData());
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
                bVar.eRl = true;
                ab.this.aO(bVar);
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
                bVar.eRl = false;
                ab.this.aO(bVar);
            }
        }
    };
    private CustomMessageListener iyH = new CustomMessageListener(2921394) { // from class: com.baidu.tieba.homepage.personalize.adapter.ab.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            com.baidu.afd.videopaster.data.b Lv;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (!StringUtils.isNull(str, true) && (Lv = ab.this.Lv(str)) != null) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921395, Lv));
                }
            }
        }
    };
    private List<com.baidu.adp.widget.ListView.a> jPR = new ArrayList();

    /* loaded from: classes2.dex */
    public interface a {
        void Mn();
    }

    public ab(Context context, com.baidu.adp.widget.ListView.s sVar) {
        this.kmx = sVar;
        this.mPageContext = (TbPageContext) com.baidu.adp.base.j.J(context);
        gl(context);
        a(sVar);
        sVar.addAdapters(this.jPR);
    }

    private void gl(Context context) {
        this.kmz = new com.baidu.tieba.homepage.personalize.adapter.a(this.mPageContext);
        this.kmA = new z(this.mPageContext);
        this.kmB = new b(this.mPageContext, com.baidu.tieba.homepage.personalize.data.f.knK);
        this.kmC = new n(this.mPageContext, com.baidu.tieba.card.data.k.TYPE);
        this.kmD = new x(this.mPageContext, com.baidu.tieba.card.data.k.iCK);
        this.kmE = new h(this.mPageContext, com.baidu.tieba.card.data.k.iCQ);
        this.kmF = new i(this.mPageContext, com.baidu.tieba.card.data.k.eRS);
        this.kmG = new j(this.mPageContext, com.baidu.tieba.card.data.k.iCR);
        this.kmH = new r(this.mPageContext, com.baidu.tieba.card.data.k.iCP);
        this.kmI = new k(this.mPageContext, com.baidu.tieba.card.data.k.eSe);
        this.kmJ = new o(this.mPageContext, com.baidu.tieba.card.data.k.eSg);
        this.kmK = new m(this.mPageContext, com.baidu.tieba.card.data.k.eSh);
        this.kmL = new g(this.mPageContext, com.baidu.tieba.card.data.k.iCL);
        this.kmM = new f(this.mPageContext, com.baidu.tieba.card.data.k.iCM);
        this.kmN = new e(this.mPageContext, com.baidu.tieba.card.data.k.iCN);
        this.kmO = new y(this.mPageContext, com.baidu.tieba.card.data.l.eSl);
        this.kmQ = new l(this.mPageContext, com.baidu.tieba.card.data.k.eSj);
        this.kmR = new HomePageAlaLiveThreadAdapter(this.mPageContext, com.baidu.tieba.card.data.j.TYPE);
        this.kmS = new HomePageAlaFriendRoomAdapter(this.mPageContext, com.baidu.tieba.card.data.j.iCq);
        this.kmT = new v(this.mPageContext, com.baidu.tieba.card.data.k.eSq);
        this.kmU = new u(this.mPageContext, com.baidu.tieba.card.data.k.eSr);
        this.kmV = new w(this.mPageContext, com.baidu.tieba.card.data.k.eSt);
        this.kmW = new t(this.mPageContext, com.baidu.tieba.card.data.k.eSs);
        this.kmX = new n(this.mPageContext, com.baidu.tieba.card.data.k.iCI);
        this.kmY = new p(this.mPageContext, com.baidu.tieba.card.data.k.eSx);
        this.kmZ = new q(this.mPageContext, com.baidu.tieba.card.data.k.eSy);
        this.kna = new s(this.mPageContext, com.baidu.tieba.homepage.topic.topictab.b.a.ksg);
        this.knb = new c(this.mPageContext, com.baidu.tieba.card.data.e.iCl);
        this.kmP = new d(this.mPageContext, com.baidu.tieba.card.data.k.iCO);
        this.kbK = new com.baidu.tieba.homepage.concern.adapter.z(this.mPageContext, com.baidu.tieba.card.data.k.iCJ, (byte) 3);
        this.jPR.add(this.kmz);
        this.jPR.add(this.kmA);
        this.jPR.add(this.kmB);
        this.jPR.add(this.kmC);
        this.jPR.add(this.kmD);
        this.jPR.add(this.kmE);
        this.jPR.add(this.kmF);
        this.jPR.add(this.kmG);
        this.jPR.add(this.kmH);
        this.jPR.add(this.kmI);
        this.jPR.add(this.kmJ);
        this.jPR.add(this.kmK);
        this.jPR.add(this.kmL);
        this.jPR.add(this.kmM);
        this.jPR.add(this.kmN);
        this.jPR.add(this.kmO);
        this.jPR.add(this.kmQ);
        this.jPR.add(this.kmX);
        this.jPR.add(new ReadProgessDelegetAdapter(this.mPageContext, com.baidu.tieba.homepage.personalize.readProgressBar.b.TYPE));
        this.jPR.add(this.kmR);
        this.jPR.add(this.kmS);
        this.jPR.add(this.kmT);
        this.jPR.add(this.kmU);
        this.jPR.add(this.kmW);
        this.jPR.add(this.kmV);
        this.jPR.add(new aa(this.mPageContext, com.baidu.tieba.homepage.personalize.data.h.TYPE));
        this.jPR.add(this.kmY);
        this.jPR.add(this.kmZ);
        this.jPR.add(this.kna);
        this.jPR.add(this.knb);
        this.jPR.add(this.kmP);
        this.jPR.add(this.kbK);
        cRI();
        cOS();
        ED("page_recommend");
    }

    private void cOS() {
        if (!cb.eSB.get()) {
            AdvertAppInfo.eMT.set(false);
            return;
        }
        this.knc = com.baidu.tieba.recapp.s.dDB().a(this.mPageContext, AdvertAppInfo.eMH, "INDEX");
        this.knd = com.baidu.tieba.recapp.s.dDB().a(this.mPageContext, AdvertAppInfo.eMK, "INDEX");
        this.kne = com.baidu.tieba.recapp.s.dDB().a(this.mPageContext, AdvertAppInfo.eMO, "INDEX");
        this.knf = com.baidu.tieba.recapp.s.dDB().a(this.mPageContext, AdvertAppInfo.eMP, "INDEX");
        this.kng = com.baidu.tieba.recapp.s.dDB().a(this.mPageContext, AdvertAppInfo.eMQ, "INDEX");
        this.knh = com.baidu.tieba.recapp.s.dDB().a(this.mPageContext, AdvertAppInfo.eMS, "INDEX");
        this.kni = com.baidu.tieba.recapp.s.dDB().a(this.mPageContext, AdvertAppInfo.eMR, "INDEX");
        this.jPR.add(this.knc);
        this.jPR.add(this.knd);
        this.jPR.add(this.kne);
        this.jPR.add(this.knf);
        this.jPR.add(this.kng);
        this.jPR.add(this.knh);
        this.jPR.add(this.kni);
        AdvertAppInfo.eMT.set(true);
    }

    public void b(com.baidu.tieba.homepage.personalize.model.e eVar) {
        this.kmC.a(eVar);
        this.kmD.a(eVar);
        this.kmE.a(eVar);
        this.kmG.a(eVar);
        this.kmH.a(eVar);
        this.kmL.a(eVar);
        this.kmM.a(eVar);
        this.kmN.a(eVar);
        this.kmO.a(eVar);
        this.kmP.a(eVar);
    }

    private void a(com.baidu.adp.widget.ListView.s sVar) {
        this.kmD.a(sVar);
        this.kmE.a(sVar);
        this.kmF.a(sVar);
        this.kmG.a(sVar);
        this.kmH.a(sVar);
        this.kmI.a(sVar);
        this.kmJ.a(sVar);
        this.kmK.a(sVar);
        this.kmL.a(sVar);
        this.kmM.a(sVar);
        this.kmN.a(sVar);
        this.kmP.a(sVar);
        this.kmO.a(sVar);
        this.knb.a(sVar);
        this.kmU.a(sVar);
        this.kmU.a(sVar);
        this.kmW.a(sVar);
        this.kbK.a(sVar);
    }

    public void j(List<com.baidu.adp.widget.ListView.n> list, int i) {
        com.baidu.tieba.tbadkCore.v.x(list, 2);
        ViewGroup listView = this.kmx.getListView();
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
        this.kmx.setData(list);
        this.kmy = list;
        if (this.kkE != null) {
            this.kkE.Mn();
        }
    }

    public void cx(List<com.baidu.adp.widget.ListView.n> list) {
        com.baidu.tieba.tbadkCore.v.x(list, 2);
        this.kmx.setData(list);
        this.kmy = list;
        if (this.kkE != null) {
            this.kkE.Mn();
        }
    }

    public void onChangeSkinType(int i) {
        notifyDataSetChanged();
        this.kmz.onChangeSkinType(i);
    }

    public void notifyDataSetChanged() {
        if (this.kmx != null) {
            this.kmx.getListAdapter().notifyDataSetChanged();
        }
    }

    public void setFromCDN(boolean z) {
        if (this.kmC != null) {
            this.kmC.setFromCDN(z);
            this.kmX.setFromCDN(z);
            this.kmQ.setFromCDN(z);
            this.kmT.setFromCDN(z);
        }
        if (this.kmG != null) {
            this.kmG.setFromCDN(z);
        }
        if (this.kmP != null) {
            this.kmP.setFromCDN(z);
        }
        if (this.knd != null && (this.knd instanceof com.baidu.tieba.recapp.p)) {
            ((com.baidu.tieba.recapp.p) this.knd).setIsFromCDN(z);
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.kmB != null) {
            this.kmB.setPageUniqueId(bdUniqueId);
        }
        if (this.kmC != null) {
            this.kmC.fIy = bdUniqueId;
        }
        if (this.kmD != null) {
            this.kmD.fIy = bdUniqueId;
        }
        if (this.kmE != null) {
            this.kmE.fIy = bdUniqueId;
        }
        if (this.kmF != null) {
            this.kmF.fIy = bdUniqueId;
        }
        if (this.kmG != null) {
            this.kmG.fIy = bdUniqueId;
        }
        if (this.kmH != null) {
            this.kmH.fIy = bdUniqueId;
        }
        if (this.kmI != null) {
            this.kmI.fIy = bdUniqueId;
        }
        if (this.kmJ != null) {
            this.kmJ.fIy = bdUniqueId;
        }
        if (this.kmK != null) {
            this.kmK.fIy = bdUniqueId;
        }
        if (this.kmL != null) {
            this.kmL.fIy = bdUniqueId;
        }
        if (this.kmM != null) {
            this.kmM.fIy = bdUniqueId;
        }
        if (this.kmN != null) {
            this.kmN.fIy = bdUniqueId;
        }
        if (this.kmQ != null) {
            this.kmQ.fIy = bdUniqueId;
        }
        if (this.kmO != null) {
            this.kmO.fIy = bdUniqueId;
        }
        if (this.kmz != null) {
            this.kmz.setPageUniqueId(bdUniqueId);
        }
        if (this.kmR != null) {
            this.kmR.fIy = bdUniqueId;
        }
        if (this.kmS != null) {
            this.kmS.fIy = bdUniqueId;
        }
        if (this.kmT != null) {
            this.kmT.fIy = bdUniqueId;
        }
        if (this.kmU != null) {
            this.kmU.fIy = bdUniqueId;
        }
        if (this.kmW != null) {
            this.kmW.fIy = bdUniqueId;
        }
        if (this.kmV != null) {
            this.kmV.fIy = bdUniqueId;
        }
        if (this.kmX != null) {
            this.kmX.fIy = bdUniqueId;
        }
        if (this.kmY != null) {
            this.kmY.fIy = bdUniqueId;
        }
        if (this.kmZ != null) {
            this.kmZ.fIy = bdUniqueId;
        }
        if (this.kna != null) {
            this.kna.fIy = bdUniqueId;
        }
        if (this.knb != null) {
            this.knb.fIy = bdUniqueId;
        }
        if (this.kmP != null) {
            this.kmP.fIy = bdUniqueId;
        }
        if (this.kbK != null) {
            this.kbK.fIy = bdUniqueId;
        }
        if (!com.baidu.tbadk.core.util.y.isEmpty(this.jFJ)) {
            for (com.baidu.adp.widget.ListView.a aVar : this.jFJ) {
                if (aVar instanceof com.baidu.tieba.lego.card.adapter.a) {
                    ((com.baidu.tieba.lego.card.adapter.a) aVar).setUniqueId(bdUniqueId);
                }
            }
        }
        this.fci.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.fci);
        this.mLikeForumListener.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.mLikeForumListener);
        this.mUnlikeForumListener.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.mUnlikeForumListener);
        this.iyH.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.iyH);
        if (!this.knk) {
            this.jFL.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.jFL);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aO(Object obj) {
        boolean z;
        boolean z2 = false;
        if (this.kmy != null) {
            Iterator<com.baidu.adp.widget.ListView.n> it = this.kmy.iterator();
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

    private void cRI() {
        this.knk = cRJ();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean cRJ() {
        if (this.jFJ == null || this.jFJ.size() <= 0) {
            this.jFJ = new ArrayList();
            ArrayList<BdUniqueId> dNb = com.baidu.tieba.tbadkCore.v.dNb();
            if (dNb == null || dNb.size() <= 0) {
                return false;
            }
            int size = dNb.size();
            for (int i = 0; i < size; i++) {
                com.baidu.tieba.lego.card.adapter.a a2 = com.baidu.tieba.lego.d.b.ddj().a(this.mPageContext, dNb.get(i), 2);
                if (this.knj) {
                    a2.setBusinessType(3);
                }
                if (this.kmC != null && this.kmC.fIy != null) {
                    a2.setUniqueId(this.kmC.fIy);
                }
                this.jFJ.add(a2);
            }
            this.kmx.addAdapters(this.jFJ);
            return true;
        }
        return true;
    }

    public void a(FollowUserButton.a aVar) {
        for (com.baidu.adp.widget.ListView.a aVar2 : this.jPR) {
            if (aVar2 instanceof com.baidu.tieba.homepage.a) {
                ((com.baidu.tieba.homepage.a) aVar2).a(aVar);
            }
        }
    }

    public void b(NEGFeedBackView.a aVar) {
        if (this.kmC != null) {
            this.kmC.setEventCallback(aVar);
        }
        if (this.kmH != null) {
            this.kmH.setEventCallback(aVar);
        }
        if (this.kmF != null) {
            this.kmF.setEventCallback(aVar);
        }
        if (this.kmQ != null) {
            this.kmQ.setEventCallback(aVar);
        }
        if (this.kmR != null) {
            this.kmR.setEventCallback(aVar);
        }
        if (this.kmS != null) {
            this.kmS.setEventCallback(aVar);
        }
        if (this.kmT != null) {
            this.kmT.setEventCallback(aVar);
        }
        if (this.kmU != null) {
            this.kmU.setEventCallback(aVar);
        }
        if (this.kmW != null) {
            this.kmW.setEventCallback(aVar);
        }
        if (this.kmV != null) {
            this.kmV.setEventCallback(aVar);
        }
        if (this.kmX != null) {
            this.kmX.setEventCallback(aVar);
        }
        if (this.kmY != null) {
            this.kmY.setEventCallback(aVar);
        }
        if (this.kmZ != null) {
            this.kmZ.setEventCallback(aVar);
        }
        if (this.kna != null) {
            this.kna.setEventCallback(aVar);
        }
        if (this.knb != null) {
            this.knb.setEventCallback(aVar);
        }
    }

    private void ED(String str) {
        if (this.jPR != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.jPR) {
                if (aVar instanceof com.baidu.tieba.a.f) {
                    ((com.baidu.tieba.a.f) aVar).ED(str);
                }
            }
        }
    }

    private boolean g(com.baidu.adp.widget.ListView.n nVar) {
        AdvertAppInfo advertAppInfo;
        return nVar != null && (nVar instanceof com.baidu.tieba.homepage.personalize.data.a) && (advertAppInfo = ((com.baidu.tieba.homepage.personalize.data.a) nVar).iCk) != null && advertAppInfo.blF() == 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.baidu.afd.videopaster.data.b Lv(String str) {
        int i;
        com.baidu.tieba.card.data.l lVar;
        if (this.kmy == null || this.kmy.isEmpty() || str == null) {
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
            if (i2 >= this.kmy.size()) {
                i = -1;
                break;
            }
            if (this.kmy.get(i2) instanceof com.baidu.tieba.homepage.personalize.data.h) {
                i3++;
            }
            if (this.kmy.get(i2) instanceof com.baidu.tieba.homepage.personalize.data.a) {
                if (g(this.kmy.get(i2))) {
                    if (z) {
                        i = ((com.baidu.tieba.homepage.personalize.data.a) this.kmy.get(i2)).position;
                        break;
                    }
                    i6 = ((com.baidu.tieba.homepage.personalize.data.a) this.kmy.get(i2)).position;
                } else if (z) {
                    i4++;
                }
            }
            if ((this.kmy.get(i2) instanceof com.baidu.tieba.card.data.l) && (lVar = (com.baidu.tieba.card.data.l) this.kmy.get(i2)) != null && lVar.eLr != null && str.equals(lVar.eLr.getId())) {
                z = true;
                i5 = ((com.baidu.tieba.card.data.l) this.kmy.get(i2)).position;
            }
            i2++;
        }
        if (i != -1 && (i = i - i4) < -1) {
            i = -1;
        }
        bVar.setVideoId(str);
        bVar.bg(i5 - i3 >= -1 ? i5 - i3 : -1);
        bVar.bh(i6);
        bVar.bi(i);
        return bVar;
    }

    public void onPause() {
        if (this.kmO != null) {
            this.kmO.onPause();
        }
    }

    public void onResume() {
        if (this.kmO != null) {
            this.kmO.onResume();
        }
        notifyDataSetChanged();
    }

    public void onDestroy() {
    }

    public List<com.baidu.adp.widget.ListView.n> getDataList() {
        return this.kmy;
    }

    public void a(a aVar) {
        this.kkE = aVar;
    }
}
