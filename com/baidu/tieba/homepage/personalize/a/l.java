package com.baidu.tieba.homepage.personalize.a;

import android.content.Context;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.widget.ListView.m;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.data.bb;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.coreExtra.message.UpdateAttentionMessage;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.lego.card.model.ICardInfo;
import com.baidu.tieba.recapp.r;
import com.baidu.tieba.tbadkCore.q;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes6.dex */
public class l {
    private List<com.baidu.adp.widget.ListView.a> dJe;
    private com.baidu.adp.widget.ListView.a dRO;
    private m epf;
    private List<com.baidu.adp.widget.ListView.h> epg;
    private a eph;
    private j epi;
    private f epj;
    private e epk;
    private i epl;
    private g epm;
    private b epn;
    private h epo;
    private f epp;
    private i epq;
    private d epr;
    private com.baidu.adp.widget.ListView.a eps;
    private com.baidu.adp.widget.ListView.a ept;
    private com.baidu.adp.widget.ListView.a epu;
    private com.baidu.adp.widget.ListView.a epv;
    private com.baidu.adp.widget.ListView.a epw;
    private com.baidu.adp.widget.ListView.a epx;
    private boolean epy;
    private boolean epz;
    private TbPageContext<?> mPageContext;
    private CustomMessageListener dJn = new CustomMessageListener(2016470) { // from class: com.baidu.tieba.homepage.personalize.a.l.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                l.this.aBY();
                if (l.this.epg != null) {
                    l.this.ak(l.this.epg);
                }
            }
        }
    };
    private CustomMessageListener mAttentionListener = new CustomMessageListener(2001115) { // from class: com.baidu.tieba.homepage.personalize.a.l.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
            if (updateAttentionMessage != null && updateAttentionMessage.getData() != null && updateAttentionMessage.getData().Jr) {
                l.this.ae(updateAttentionMessage.getData());
            }
        }
    };
    private CustomMessageListener mLikeForumListener = new CustomMessageListener(2001335) { // from class: com.baidu.tieba.homepage.personalize.a.l.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                com.baidu.tieba.lego.c.b bVar = new com.baidu.tieba.lego.c.b();
                bVar.fid = String.valueOf(customResponsedMessage.getData());
                bVar.apy = true;
                l.this.ae(bVar);
            }
        }
    };
    private CustomMessageListener mUnlikeForumListener = new CustomMessageListener(2001336) { // from class: com.baidu.tieba.homepage.personalize.a.l.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                com.baidu.tieba.lego.c.b bVar = new com.baidu.tieba.lego.c.b();
                bVar.fid = String.valueOf(customResponsedMessage.getData());
                bVar.apy = false;
                l.this.ae(bVar);
            }
        }
    };
    private List<com.baidu.adp.widget.ListView.a> eiX = new ArrayList();

    public l(Context context, m mVar) {
        this.epf = mVar;
        this.mPageContext = (TbPageContext) com.baidu.adp.base.i.aK(context);
        co(context);
        mVar.addAdapters(this.eiX);
    }

    private void co(Context context) {
        this.eph = new a(this.mPageContext);
        this.epi = new j(this.mPageContext);
        this.epj = new f(this.mPageContext, com.baidu.tieba.card.data.k.TYPE);
        this.epk = new e(this.mPageContext, com.baidu.tieba.card.data.k.apH);
        this.epl = new i(this.mPageContext, com.baidu.tieba.card.data.l.cRA);
        this.epm = new g(this.mPageContext);
        this.epn = new b(this.mPageContext, com.baidu.tieba.card.data.j.TYPE);
        this.epo = new h(this.mPageContext, com.baidu.tieba.card.data.k.apN);
        this.epp = new f(this.mPageContext, com.baidu.tieba.card.data.k.cRw);
        this.epq = new i(this.mPageContext, com.baidu.tieba.card.data.l.cRB);
        this.epr = new d(this.mPageContext, com.baidu.tieba.card.data.k.cRx);
        this.eiX.add(this.eph);
        this.eiX.add(this.epi);
        this.eiX.add(this.epl);
        this.eiX.add(this.epj);
        this.eiX.add(this.epk);
        this.eiX.add(this.epm);
        this.eiX.add(this.epp);
        this.eiX.add(this.epq);
        this.eiX.add(new com.baidu.tieba.homepage.personalize.b.b(this.mPageContext, com.baidu.tieba.homepage.personalize.b.c.TYPE));
        this.eiX.add(this.epn);
        this.eiX.add(this.epo);
        this.eiX.add(new k(this.mPageContext, com.baidu.tieba.homepage.personalize.data.g.TYPE));
        this.eiX.add(this.epr);
        aBX();
        aJA();
        js("page_recommend");
    }

    private void aJA() {
        if (!bb.apS.get()) {
            AdvertAppInfo.alN.set(false);
            return;
        }
        this.dRO = r.bsG().c(this.mPageContext, AdvertAppInfo.alE);
        this.eps = r.bsG().c(this.mPageContext, AdvertAppInfo.alH);
        this.ept = r.bsG().c(this.mPageContext, AdvertAppInfo.alI);
        this.epu = r.bsG().c(this.mPageContext, AdvertAppInfo.alJ);
        this.epv = r.bsG().c(this.mPageContext, AdvertAppInfo.alK);
        this.epw = r.bsG().c(this.mPageContext, AdvertAppInfo.alL);
        this.epx = r.bsG().c(this.mPageContext, AdvertAppInfo.alM);
        this.eiX.add(this.dRO);
        this.eiX.add(this.eps);
        this.eiX.add(this.ept);
        this.eiX.add(this.epu);
        this.eiX.add(this.epv);
        this.eiX.add(this.epw);
        this.eiX.add(this.epx);
        AdvertAppInfo.alN.set(true);
    }

    public void b(com.baidu.tieba.homepage.personalize.model.e eVar) {
        this.epj.a(eVar);
        this.epl.a(eVar);
    }

    public void ak(List<com.baidu.adp.widget.ListView.h> list) {
        q.q(list, 2);
        this.epf.setData(list);
        this.epg = list;
    }

    public void onChangeSkinType(int i) {
        notifyDataSetChanged();
        this.eph.onChangeSkinType(i);
        this.epm.on(i);
    }

    public void notifyDataSetChanged() {
        if (this.epf != null) {
            this.epf.getListAdapter().notifyDataSetChanged();
        }
    }

    public void setFromCDN(boolean z) {
        if (this.epj != null) {
            this.epj.setFromCDN(z);
        }
        if (this.eps != null && (this.eps instanceof com.baidu.tieba.recapp.m)) {
            ((com.baidu.tieba.recapp.m) this.eps).setIsFromCDN(z);
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.epj != null) {
            this.epj.bag = bdUniqueId;
        }
        if (this.epk != null) {
            this.epk.bag = bdUniqueId;
        }
        if (this.epl != null) {
            this.epl.bag = bdUniqueId;
        }
        if (this.eph != null) {
            this.eph.setPageUniqueId(bdUniqueId);
        }
        if (this.epm != null) {
            this.epm.bag = bdUniqueId;
        }
        if (this.epn != null) {
            this.epn.bag = bdUniqueId;
        }
        if (this.epo != null) {
            this.epo.bag = bdUniqueId;
        }
        if (this.epp != null) {
            this.epp.bag = bdUniqueId;
        }
        if (this.epq != null) {
            this.epq.bag = bdUniqueId;
        }
        if (!v.I(this.dJe)) {
            for (com.baidu.adp.widget.ListView.a aVar : this.dJe) {
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
        if (!this.epz) {
            this.dJn.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.dJn);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ae(Object obj) {
        boolean z;
        boolean z2 = false;
        if (this.epg != null) {
            Iterator<com.baidu.adp.widget.ListView.h> it = this.epg.iterator();
            while (true) {
                z = z2;
                if (!it.hasNext()) {
                    break;
                }
                com.baidu.adp.widget.ListView.h next = it.next();
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

    private void aBX() {
        this.epz = aBY();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aBY() {
        if (this.dJe == null || this.dJe.size() <= 0) {
            this.dJe = new ArrayList();
            ArrayList<BdUniqueId> bAK = q.bAK();
            if (bAK == null || bAK.size() <= 0) {
                return false;
            }
            int size = bAK.size();
            for (int i = 0; i < size; i++) {
                com.baidu.tieba.lego.card.a.a a = com.baidu.tieba.lego.d.b.aXD().a(this.mPageContext, bAK.get(i), 2);
                if (this.epy) {
                    a.setBusinessType(3);
                }
                if (this.epj != null && this.epj.bag != null) {
                    a.setUniqueId(this.epj.bag);
                }
                this.dJe.add(a);
            }
            this.epf.addAdapters(this.dJe);
            return true;
        }
        return true;
    }

    public void a(NEGFeedBackView.a aVar) {
        if (this.epj != null) {
            this.epj.setEventCallback(aVar);
        }
        if (this.epk != null) {
            this.epk.setEventCallback(aVar);
        }
        if (this.epl != null) {
            this.epl.setEventCallback(aVar);
        }
        if (this.epn != null) {
            this.epn.setEventCallback(aVar);
        }
        if (this.epo != null) {
            this.epo.setEventCallback(aVar);
        }
        if (this.epp != null) {
            this.epp.setEventCallback(aVar);
        }
        if (this.epq != null) {
            this.epq.setEventCallback(aVar);
        }
    }

    private void js(String str) {
        if (this.eiX != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.eiX) {
                if (aVar instanceof com.baidu.tieba.a.f) {
                    ((com.baidu.tieba.a.f) aVar).js(str);
                }
            }
        }
    }
}
