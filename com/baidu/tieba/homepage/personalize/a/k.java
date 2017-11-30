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
import com.baidu.tieba.card.data.l;
import com.baidu.tieba.card.data.m;
import com.baidu.tieba.card.data.n;
import com.baidu.tieba.lego.card.model.ICardInfo;
import com.baidu.tieba.recapp.q;
import com.baidu.tieba.tbadkCore.p;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes.dex */
public class k {
    private BdTypeListView aXw;
    private List<com.baidu.adp.widget.ListView.a> cMQ;
    private com.baidu.adp.widget.ListView.a cQW;
    private List<com.baidu.adp.widget.ListView.f> dqQ;
    private a dqR;
    private j dqS;
    private f dqT;
    private e dqU;
    private i dqV;
    private g dqW;
    private c dqX;
    private b dqY;
    private h dqZ;
    private f dra;
    private i drb;
    private com.baidu.adp.widget.ListView.a drc;
    private com.baidu.adp.widget.ListView.a drd;
    private com.baidu.adp.widget.ListView.a dre;
    private com.baidu.adp.widget.ListView.a drf;
    private com.baidu.adp.widget.ListView.a drg;
    private com.baidu.adp.widget.ListView.a drh;
    private boolean dri;
    private boolean drj;
    private TbPageContext<?> mPageContext;
    private CustomMessageListener cNa = new CustomMessageListener(CmdConfigCustom.CMD_LEGO_REGISTER) { // from class: com.baidu.tieba.homepage.personalize.a.k.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                k.this.ans();
                if (k.this.dqQ != null) {
                    k.this.ae(k.this.dqQ);
                }
            }
        }
    };
    private CustomMessageListener mAttentionListener = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.homepage.personalize.a.k.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
            if (updateAttentionMessage != null && updateAttentionMessage.getData() != null && updateAttentionMessage.getData().BJ) {
                k.this.S(updateAttentionMessage.getData());
            }
        }
    };
    private CustomMessageListener mLikeForumListener = new CustomMessageListener(CmdConfigCustom.CMD_LIKE_FORUM) { // from class: com.baidu.tieba.homepage.personalize.a.k.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                com.baidu.tieba.lego.c.b bVar = new com.baidu.tieba.lego.c.b();
                bVar.fid = String.valueOf(customResponsedMessage.getData());
                bVar.elk = true;
                k.this.S(bVar);
            }
        }
    };
    private CustomMessageListener mUnlikeForumListener = new CustomMessageListener(CmdConfigCustom.CMD_UNLIKE_FORUM) { // from class: com.baidu.tieba.homepage.personalize.a.k.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                com.baidu.tieba.lego.c.b bVar = new com.baidu.tieba.lego.c.b();
                bVar.fid = String.valueOf(customResponsedMessage.getData());
                bVar.elk = false;
                k.this.S(bVar);
            }
        }
    };
    private List<com.baidu.adp.widget.ListView.a> dmn = new ArrayList();

    public k(Context context, BdTypeListView bdTypeListView) {
        this.aXw = bdTypeListView;
        this.mPageContext = (TbPageContext) com.baidu.adp.base.i.Y(context);
        bx(context);
        bdTypeListView.addAdapters(this.dmn);
    }

    private void bx(Context context) {
        this.dqR = new a(this.mPageContext);
        this.dqS = new j(this.mPageContext);
        this.cQW = q.bll().c(this.mPageContext, AdvertAppInfo.UG);
        this.drc = q.bll().c(this.mPageContext, AdvertAppInfo.UJ);
        this.drd = q.bll().c(this.mPageContext, AdvertAppInfo.UK);
        this.dre = q.bll().c(this.mPageContext, AdvertAppInfo.UL);
        this.drf = q.bll().c(this.mPageContext, AdvertAppInfo.UM);
        this.drg = q.bll().c(this.mPageContext, AdvertAppInfo.UN);
        this.drh = q.bll().c(this.mPageContext, AdvertAppInfo.UO);
        this.dqT = new f(this.mPageContext, l.TYPE);
        this.dqU = new e(this.mPageContext, l.YH);
        this.dqV = new i(this.mPageContext, n.cdK);
        this.dqY = new b(this.mPageContext, m.TYPE);
        this.dqW = new g(this.mPageContext);
        this.dqX = new c(this.mPageContext, com.baidu.tieba.card.data.k.TYPE);
        this.dqZ = new h(this.mPageContext, l.YN);
        this.dra = new f(this.mPageContext, l.cdD);
        this.drb = new i(this.mPageContext, n.cdL);
        this.dmn.add(this.dqR);
        this.dmn.add(this.dqS);
        this.dmn.add(this.cQW);
        this.dmn.add(this.drc);
        this.dmn.add(this.drd);
        this.dmn.add(this.dre);
        this.dmn.add(this.drf);
        this.dmn.add(this.drg);
        this.dmn.add(this.drh);
        this.dmn.add(this.dqV);
        this.dmn.add(this.dqT);
        this.dmn.add(this.dqU);
        this.dmn.add(this.dqY);
        this.dmn.add(this.dqW);
        this.dmn.add(this.dra);
        this.dmn.add(this.drb);
        this.dmn.add(new com.baidu.tieba.homepage.personalize.b.b(this.mPageContext, com.baidu.tieba.homepage.personalize.b.c.TYPE));
        this.dmn.add(this.dqX);
        this.dmn.add(this.dqZ);
        anr();
    }

    public void b(com.baidu.tieba.homepage.personalize.model.e eVar) {
        this.dqT.a(eVar);
        this.dqV.a(eVar);
    }

    public void ae(List<com.baidu.adp.widget.ListView.f> list) {
        p.p(list, 2);
        this.aXw.setData(list);
        this.dqQ = list;
    }

    public void onChangeSkinType(int i) {
        notifyDataSetChanged();
        this.dqR.onChangeSkinType(i);
        this.dqW.lW(i);
    }

    public void notifyDataSetChanged() {
        if (this.aXw != null && (this.aXw.getAdapter() instanceof com.baidu.adp.widget.ListView.d)) {
            ((com.baidu.adp.widget.ListView.d) this.aXw.getAdapter()).notifyDataSetChanged();
        }
    }

    public void setFromCDN(boolean z) {
        if (this.dqT != null) {
            this.dqT.setFromCDN(z);
        }
        if (this.drc != null && (this.drc instanceof com.baidu.tieba.recapp.n)) {
            ((com.baidu.tieba.recapp.n) this.drc).setIsFromCDN(z);
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.dqT != null) {
            this.dqT.aSv = bdUniqueId;
        }
        if (this.dqU != null) {
            this.dqU.aSv = bdUniqueId;
        }
        if (this.dqV != null) {
            this.dqV.aSv = bdUniqueId;
        }
        if (this.dqY != null) {
            this.dqY.aSv = bdUniqueId;
        }
        if (this.dqR != null) {
            this.dqR.setPageUniqueId(bdUniqueId);
        }
        if (this.dqW != null) {
            this.dqW.aSv = bdUniqueId;
        }
        if (this.dqX != null) {
            this.dqX.aSv = bdUniqueId;
        }
        if (this.dqZ != null) {
            this.dqZ.aSv = bdUniqueId;
        }
        if (this.dra != null) {
            this.dra.aSv = bdUniqueId;
        }
        if (this.drb != null) {
            this.drb.aSv = bdUniqueId;
        }
        if (!v.w(this.cMQ)) {
            for (com.baidu.adp.widget.ListView.a aVar : this.cMQ) {
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
        if (!this.drj) {
            this.cNa.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.cNa);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void S(Object obj) {
        boolean z;
        boolean z2 = false;
        if (this.dqQ != null) {
            Iterator<com.baidu.adp.widget.ListView.f> it = this.dqQ.iterator();
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

    private void anr() {
        this.drj = ans();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean ans() {
        if (this.cMQ == null || this.cMQ.size() <= 0) {
            this.cMQ = new ArrayList();
            ArrayList<BdUniqueId> bvz = p.bvz();
            if (bvz == null || bvz.size() <= 0) {
                return false;
            }
            int size = bvz.size();
            for (int i = 0; i < size; i++) {
                com.baidu.tieba.lego.card.a.a a = com.baidu.tieba.lego.d.b.aIb().a(this.mPageContext, bvz.get(i), 2);
                if (this.dri) {
                    a.setBusinessType(3);
                }
                if (this.dqT != null && this.dqT.aSv != null) {
                    a.setUniqueId(this.dqT.aSv);
                }
                this.cMQ.add(a);
            }
            this.aXw.addAdapters(this.cMQ);
            return true;
        }
        return true;
    }

    public void a(c.a aVar) {
        if (this.dqT != null) {
            this.dqT.setEventCallback(aVar);
        }
        if (this.dqU != null) {
            this.dqU.setEventCallback(aVar);
        }
        if (this.dqY != null) {
            this.dqY.setEventCallback(aVar);
        }
        if (this.dqV != null) {
            this.dqV.setEventCallback(aVar);
        }
        if (this.dqX != null) {
            this.dqX.setEventCallback(aVar);
        }
        if (this.dqZ != null) {
            this.dqZ.setEventCallback(aVar);
        }
        if (this.dra != null) {
            this.dra.setEventCallback(aVar);
        }
        if (this.drb != null) {
            this.drb.setEventCallback(aVar);
        }
    }
}
