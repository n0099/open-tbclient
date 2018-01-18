package com.baidu.tieba.homepage.personalize.a;

import android.content.Context;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.data.bd;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.coreExtra.message.UpdateAttentionMessage;
import com.baidu.tieba.NEGFeedBack.c;
import com.baidu.tieba.card.data.m;
import com.baidu.tieba.card.data.n;
import com.baidu.tieba.lego.card.model.ICardInfo;
import com.baidu.tieba.recapp.q;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes2.dex */
public class l {
    private List<com.baidu.adp.widget.ListView.a> dGH;
    private com.baidu.adp.widget.ListView.a dOf;
    private BdTypeListView eaQ;
    private g efA;
    private c efB;
    private b efC;
    private h efD;
    private f efE;
    private i efF;
    private com.baidu.adp.widget.ListView.a efG;
    private com.baidu.adp.widget.ListView.a efH;
    private com.baidu.adp.widget.ListView.a efI;
    private com.baidu.adp.widget.ListView.a efJ;
    private com.baidu.adp.widget.ListView.a efK;
    private com.baidu.adp.widget.ListView.a efL;
    private boolean efM;
    private boolean efN;
    private List<com.baidu.adp.widget.ListView.i> efu;
    private a efv;
    private j efw;
    private f efx;
    private e efy;
    private i efz;
    private TbPageContext<?> mPageContext;
    private CustomMessageListener dGR = new CustomMessageListener(CmdConfigCustom.CMD_LEGO_REGISTER) { // from class: com.baidu.tieba.homepage.personalize.a.l.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                l.this.awh();
                if (l.this.efu != null) {
                    l.this.am(l.this.efu);
                }
            }
        }
    };
    private CustomMessageListener mAttentionListener = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.homepage.personalize.a.l.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
            if (updateAttentionMessage != null && updateAttentionMessage.getData() != null && updateAttentionMessage.getData().apN) {
                l.this.aW(updateAttentionMessage.getData());
            }
        }
    };
    private CustomMessageListener mLikeForumListener = new CustomMessageListener(CmdConfigCustom.CMD_LIKE_FORUM) { // from class: com.baidu.tieba.homepage.personalize.a.l.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                com.baidu.tieba.lego.c.b bVar = new com.baidu.tieba.lego.c.b();
                bVar.fid = String.valueOf(customResponsedMessage.getData());
                bVar.faa = true;
                l.this.aW(bVar);
            }
        }
    };
    private CustomMessageListener mUnlikeForumListener = new CustomMessageListener(CmdConfigCustom.CMD_UNLIKE_FORUM) { // from class: com.baidu.tieba.homepage.personalize.a.l.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                com.baidu.tieba.lego.c.b bVar = new com.baidu.tieba.lego.c.b();
                bVar.fid = String.valueOf(customResponsedMessage.getData());
                bVar.faa = false;
                l.this.aW(bVar);
            }
        }
    };
    private List<com.baidu.adp.widget.ListView.a> eaP = new ArrayList();

    public l(Context context, BdTypeListView bdTypeListView) {
        this.eaQ = bdTypeListView;
        this.mPageContext = (TbPageContext) com.baidu.adp.base.i.ak(context);
        bF(context);
        bdTypeListView.addAdapters(this.eaP);
    }

    private void bF(Context context) {
        this.efv = new a(this.mPageContext);
        this.efw = new j(this.mPageContext);
        this.efx = new f(this.mPageContext, com.baidu.tieba.card.data.l.TYPE);
        this.efy = new e(this.mPageContext, com.baidu.tieba.card.data.l.aMZ);
        this.efz = new i(this.mPageContext, n.cXi);
        this.efC = new b(this.mPageContext, m.TYPE);
        this.efA = new g(this.mPageContext);
        this.efB = new c(this.mPageContext, com.baidu.tieba.card.data.k.TYPE);
        this.efD = new h(this.mPageContext, com.baidu.tieba.card.data.l.aNf);
        this.efE = new f(this.mPageContext, com.baidu.tieba.card.data.l.cXb);
        this.efF = new i(this.mPageContext, n.cXj);
        this.eaP.add(this.efv);
        this.eaP.add(this.efw);
        this.eaP.add(this.efz);
        this.eaP.add(this.efx);
        this.eaP.add(this.efy);
        this.eaP.add(this.efC);
        this.eaP.add(this.efA);
        this.eaP.add(this.efE);
        this.eaP.add(this.efF);
        this.eaP.add(new com.baidu.tieba.homepage.personalize.b.b(this.mPageContext, com.baidu.tieba.homepage.personalize.b.c.TYPE));
        this.eaP.add(this.efB);
        this.eaP.add(this.efD);
        this.eaP.add(new k(this.mPageContext, com.baidu.tieba.homepage.personalize.data.g.TYPE));
        awg();
        aBD();
    }

    private void aBD() {
        if (!bd.aNi.get()) {
            AdvertAppInfo.aJh.set(false);
            return;
        }
        this.dOf = q.bmR().c(this.mPageContext, AdvertAppInfo.aIY);
        this.efG = q.bmR().c(this.mPageContext, AdvertAppInfo.aJb);
        this.efH = q.bmR().c(this.mPageContext, AdvertAppInfo.aJc);
        this.efI = q.bmR().c(this.mPageContext, AdvertAppInfo.aJd);
        this.efJ = q.bmR().c(this.mPageContext, AdvertAppInfo.aJe);
        this.efK = q.bmR().c(this.mPageContext, AdvertAppInfo.aJf);
        this.efL = q.bmR().c(this.mPageContext, AdvertAppInfo.aJg);
        this.eaP.add(this.dOf);
        this.eaP.add(this.efG);
        this.eaP.add(this.efH);
        this.eaP.add(this.efI);
        this.eaP.add(this.efJ);
        this.eaP.add(this.efK);
        this.eaP.add(this.efL);
        AdvertAppInfo.aJh.set(true);
    }

    public void b(com.baidu.tieba.homepage.personalize.model.e eVar) {
        this.efx.a(eVar);
        this.efz.a(eVar);
    }

    public void am(List<com.baidu.adp.widget.ListView.i> list) {
        com.baidu.tieba.tbadkCore.q.s(list, 2);
        this.eaQ.setData(list);
        this.efu = list;
    }

    public void onChangeSkinType(int i) {
        notifyDataSetChanged();
        this.efv.onChangeSkinType(i);
        this.efA.oN(i);
    }

    public void notifyDataSetChanged() {
        if (this.eaQ != null && (this.eaQ.getAdapter() instanceof com.baidu.adp.widget.ListView.e)) {
            this.eaQ.getAdapter().notifyDataSetChanged();
        }
    }

    public void setFromCDN(boolean z) {
        if (this.efx != null) {
            this.efx.setFromCDN(z);
        }
        if (this.efG != null && (this.efG instanceof com.baidu.tieba.recapp.n)) {
            ((com.baidu.tieba.recapp.n) this.efG).setIsFromCDN(z);
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.efx != null) {
            this.efx.bGw = bdUniqueId;
        }
        if (this.efy != null) {
            this.efy.bGw = bdUniqueId;
        }
        if (this.efz != null) {
            this.efz.bGw = bdUniqueId;
        }
        if (this.efC != null) {
            this.efC.bGw = bdUniqueId;
        }
        if (this.efv != null) {
            this.efv.setPageUniqueId(bdUniqueId);
        }
        if (this.efA != null) {
            this.efA.bGw = bdUniqueId;
        }
        if (this.efB != null) {
            this.efB.bGw = bdUniqueId;
        }
        if (this.efD != null) {
            this.efD.bGw = bdUniqueId;
        }
        if (this.efE != null) {
            this.efE.bGw = bdUniqueId;
        }
        if (this.efF != null) {
            this.efF.bGw = bdUniqueId;
        }
        if (!v.E(this.dGH)) {
            for (com.baidu.adp.widget.ListView.a aVar : this.dGH) {
                if (aVar instanceof com.baidu.tieba.lego.card.a.a) {
                    ((com.baidu.tieba.lego.card.a.a) aVar).setUniqueId(bdUniqueId);
                }
            }
        }
        this.mAttentionListener.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.mAttentionListener);
        this.mLikeForumListener.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.mLikeForumListener);
        this.mUnlikeForumListener.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.mUnlikeForumListener);
        if (!this.efN) {
            this.dGR.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.dGR);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aW(Object obj) {
        boolean z;
        boolean z2 = false;
        if (this.efu != null) {
            Iterator<com.baidu.adp.widget.ListView.i> it = this.efu.iterator();
            while (true) {
                z = z2;
                if (!it.hasNext()) {
                    break;
                }
                com.baidu.adp.widget.ListView.i next = it.next();
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

    private void awg() {
        this.efN = awh();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean awh() {
        if (this.dGH == null || this.dGH.size() <= 0) {
            this.dGH = new ArrayList();
            ArrayList<BdUniqueId> buR = com.baidu.tieba.tbadkCore.q.buR();
            if (buR == null || buR.size() <= 0) {
                return false;
            }
            int size = buR.size();
            for (int i = 0; i < size; i++) {
                com.baidu.tieba.lego.card.a.a a = com.baidu.tieba.lego.d.b.aPp().a(this.mPageContext, buR.get(i), 2);
                if (this.efM) {
                    a.setBusinessType(3);
                }
                if (this.efx != null && this.efx.bGw != null) {
                    a.setUniqueId(this.efx.bGw);
                }
                this.dGH.add(a);
            }
            this.eaQ.addAdapters(this.dGH);
            return true;
        }
        return true;
    }

    public void a(c.a aVar) {
        if (this.efx != null) {
            this.efx.setEventCallback(aVar);
        }
        if (this.efy != null) {
            this.efy.setEventCallback(aVar);
        }
        if (this.efC != null) {
            this.efC.setEventCallback(aVar);
        }
        if (this.efz != null) {
            this.efz.setEventCallback(aVar);
        }
        if (this.efB != null) {
            this.efB.setEventCallback(aVar);
        }
        if (this.efD != null) {
            this.efD.setEventCallback(aVar);
        }
        if (this.efE != null) {
            this.efE.setEventCallback(aVar);
        }
        if (this.efF != null) {
            this.efF.setEventCallback(aVar);
        }
    }

    public void setCardShowType(int i) {
        this.efx.setCardShowType(i);
        this.efy.setCardShowType(i);
        this.efz.setCardShowType(i);
        this.efB.setCardShowType(i);
        this.efD.setCardShowType(i);
        this.efE.setCardShowType(i);
        this.efF.setCardShowType(i);
    }
}
