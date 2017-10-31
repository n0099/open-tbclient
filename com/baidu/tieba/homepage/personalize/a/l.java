package com.baidu.tieba.homepage.personalize.a;

import android.content.Context;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.coreExtra.message.UpdateAttentionMessage;
import com.baidu.tieba.NEGFeedBack.c;
import com.baidu.tieba.card.data.m;
import com.baidu.tieba.card.data.n;
import com.baidu.tieba.lego.card.model.ICardInfo;
import com.baidu.tieba.recapp.r;
import com.baidu.tieba.tbadkCore.o;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes.dex */
public class l {
    private BdTypeListView aUn;
    private List<com.baidu.adp.widget.ListView.a> cDs;
    private com.baidu.adp.widget.ListView.a cHs;
    private List<com.baidu.adp.widget.ListView.f> dhL;
    private a dhM;
    private k dhN;
    private com.baidu.adp.widget.ListView.a dhO;
    private h dhP;
    private g dhQ;
    private j dhR;
    private e dhS;
    private f dhT;
    private i dhU;
    private c dhV;
    private b dhW;
    private boolean dhX;
    private boolean dhY;
    private TbPageContext<?> mPageContext;
    private CustomMessageListener cDC = new CustomMessageListener(CmdConfigCustom.CMD_LEGO_REGISTER) { // from class: com.baidu.tieba.homepage.personalize.a.l.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                l.this.alj();
                if (l.this.dhL != null) {
                    l.this.br(l.this.dhL);
                }
            }
        }
    };
    private CustomMessageListener mAttentionListener = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.homepage.personalize.a.l.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
            if (updateAttentionMessage != null && updateAttentionMessage.getData() != null && updateAttentionMessage.getData().BJ) {
                l.this.S(updateAttentionMessage.getData());
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
                bVar.efp = true;
                l.this.S(bVar);
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
                bVar.efp = false;
                l.this.S(bVar);
            }
        }
    };
    private List<com.baidu.adp.widget.ListView.a> ddn = new ArrayList();

    public l(Context context, BdTypeListView bdTypeListView) {
        this.aUn = bdTypeListView;
        this.mPageContext = (TbPageContext) com.baidu.adp.base.i.Y(context);
        bs(context);
        bdTypeListView.addAdapters(this.ddn);
    }

    private void bs(Context context) {
        this.dhM = new a(this.mPageContext);
        this.dhN = new k(this.mPageContext);
        this.cHs = r.bja().c(this.mPageContext, AdvertAppInfo.Ub);
        this.dhO = r.bja().c(this.mPageContext, AdvertAppInfo.Ue);
        this.dhP = new h(this.mPageContext, com.baidu.tieba.card.data.l.TYPE);
        this.dhQ = new g(this.mPageContext, com.baidu.tieba.card.data.l.Yp);
        this.dhR = new j(this.mPageContext, n.bVd);
        this.dhW = new b(this.mPageContext, m.TYPE);
        this.dhS = new e(this.mPageContext, com.baidu.tieba.card.data.l.bUW);
        this.dhT = new f(this.mPageContext, n.bVe);
        this.dhU = new i(this.mPageContext);
        this.dhV = new c(this.mPageContext, com.baidu.tieba.card.data.k.TYPE);
        this.ddn.add(this.dhM);
        this.ddn.add(this.dhN);
        this.ddn.add(this.cHs);
        this.ddn.add(this.dhO);
        this.ddn.add(this.dhR);
        this.ddn.add(this.dhP);
        this.ddn.add(this.dhQ);
        this.ddn.add(this.dhW);
        this.ddn.add(this.dhS);
        this.ddn.add(this.dhT);
        this.ddn.add(this.dhU);
        this.ddn.add(new com.baidu.tieba.homepage.personalize.b.b(this.mPageContext, com.baidu.tieba.homepage.personalize.b.c.TYPE));
        this.ddn.add(this.dhV);
        ali();
    }

    public void b(com.baidu.tieba.homepage.personalize.model.e eVar) {
        this.dhP.a(eVar);
        this.dhR.a(eVar);
        this.dhS.a(eVar);
        this.dhT.a(eVar);
    }

    public void br(List<com.baidu.adp.widget.ListView.f> list) {
        o.p(list, 2);
        this.aUn.setData(list);
        this.dhL = list;
    }

    public void onChangeSkinType(int i) {
        notifyDataSetChanged();
        this.dhM.onChangeSkinType(i);
        this.dhU.lx(i);
    }

    public void notifyDataSetChanged() {
        if (this.aUn != null && (this.aUn.getAdapter() instanceof com.baidu.adp.widget.ListView.d)) {
            ((com.baidu.adp.widget.ListView.d) this.aUn.getAdapter()).notifyDataSetChanged();
        }
    }

    public void setFromCDN(boolean z) {
        if (this.dhP != null) {
            this.dhP.setFromCDN(z);
        }
        if (this.dhS != null) {
            this.dhS.setFromCDN(z);
        }
        if (this.dhO != null && (this.dhO instanceof com.baidu.tieba.recapp.n)) {
            ((com.baidu.tieba.recapp.n) this.dhO).setIsFromCDN(z);
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.dhP != null) {
            this.dhP.aPq = bdUniqueId;
        }
        if (this.dhQ != null) {
            this.dhQ.aPq = bdUniqueId;
        }
        if (this.dhR != null) {
            this.dhR.aPq = bdUniqueId;
        }
        if (this.dhW != null) {
            this.dhW.aPq = bdUniqueId;
        }
        if (this.dhM != null) {
            this.dhM.setPageUniqueId(bdUniqueId);
        }
        if (this.dhS != null) {
            this.dhS.aPq = bdUniqueId;
        }
        if (this.dhT != null) {
            this.dhT.aPq = bdUniqueId;
        }
        if (this.dhU != null) {
            this.dhU.aPq = bdUniqueId;
        }
        if (this.dhV != null) {
            this.dhV.aPq = bdUniqueId;
        }
        if (!v.v(this.cDs)) {
            for (com.baidu.adp.widget.ListView.a aVar : this.cDs) {
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
        if (!this.dhY) {
            this.cDC.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.cDC);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void S(Object obj) {
        boolean z;
        boolean z2 = false;
        if (this.dhL != null) {
            Iterator<com.baidu.adp.widget.ListView.f> it = this.dhL.iterator();
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

    private void ali() {
        this.dhY = alj();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean alj() {
        if (this.cDs == null || this.cDs.size() <= 0) {
            this.cDs = new ArrayList();
            ArrayList<BdUniqueId> btF = o.btF();
            if (btF == null || btF.size() <= 0) {
                return false;
            }
            int size = btF.size();
            for (int i = 0; i < size; i++) {
                com.baidu.tieba.lego.card.a.a a = com.baidu.tieba.lego.d.b.aHp().a(this.mPageContext, btF.get(i), 2);
                if (this.dhX) {
                    a.setBusinessType(3);
                }
                if (this.dhP != null && this.dhP.aPq != null) {
                    a.setUniqueId(this.dhP.aPq);
                }
                this.cDs.add(a);
            }
            this.aUn.addAdapters(this.cDs);
            return true;
        }
        return true;
    }

    public void a(c.a aVar) {
        if (this.dhP != null) {
            this.dhP.setEventCallback(aVar);
        }
        if (this.dhQ != null) {
            this.dhQ.setEventCallback(aVar);
        }
        if (this.dhW != null) {
            this.dhW.setEventCallback(aVar);
        }
        if (this.dhR != null) {
            this.dhR.setEventCallback(aVar);
        }
        if (this.dhV != null) {
            this.dhV.setEventCallback(aVar);
        }
    }
}
