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
    private List<com.baidu.adp.widget.ListView.a> dPH;
    private com.baidu.adp.widget.ListView.a dYq;
    private m evZ;
    private List<com.baidu.adp.widget.ListView.h> ewa;
    private a ewb;
    private j ewc;
    private f ewd;
    private e ewe;
    private i ewf;
    private g ewg;
    private b ewh;
    private h ewi;
    private f ewj;
    private i ewk;
    private d ewl;
    private com.baidu.adp.widget.ListView.a ewm;
    private com.baidu.adp.widget.ListView.a ewn;
    private com.baidu.adp.widget.ListView.a ewo;
    private com.baidu.adp.widget.ListView.a ewp;
    private com.baidu.adp.widget.ListView.a ewq;
    private com.baidu.adp.widget.ListView.a ewr;
    private boolean ews;
    private boolean ewt;
    private TbPageContext<?> mPageContext;
    private CustomMessageListener dPQ = new CustomMessageListener(2016470) { // from class: com.baidu.tieba.homepage.personalize.a.l.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                l.this.aDK();
                if (l.this.ewa != null) {
                    l.this.ak(l.this.ewa);
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
                bVar.asY = true;
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
                bVar.asY = false;
                l.this.ae(bVar);
            }
        }
    };
    private List<com.baidu.adp.widget.ListView.a> epR = new ArrayList();

    public l(Context context, m mVar) {
        this.evZ = mVar;
        this.mPageContext = (TbPageContext) com.baidu.adp.base.i.aK(context);
        cs(context);
        mVar.addAdapters(this.epR);
    }

    private void cs(Context context) {
        this.ewb = new a(this.mPageContext);
        this.ewc = new j(this.mPageContext);
        this.ewd = new f(this.mPageContext, com.baidu.tieba.card.data.k.TYPE);
        this.ewe = new e(this.mPageContext, com.baidu.tieba.card.data.k.ath);
        this.ewf = new i(this.mPageContext, com.baidu.tieba.card.data.l.cYh);
        this.ewg = new g(this.mPageContext);
        this.ewh = new b(this.mPageContext, com.baidu.tieba.card.data.j.TYPE);
        this.ewi = new h(this.mPageContext, com.baidu.tieba.card.data.k.atn);
        this.ewj = new f(this.mPageContext, com.baidu.tieba.card.data.k.cYd);
        this.ewk = new i(this.mPageContext, com.baidu.tieba.card.data.l.cYi);
        this.ewl = new d(this.mPageContext, com.baidu.tieba.card.data.k.cYe);
        this.epR.add(this.ewb);
        this.epR.add(this.ewc);
        this.epR.add(this.ewf);
        this.epR.add(this.ewd);
        this.epR.add(this.ewe);
        this.epR.add(this.ewg);
        this.epR.add(this.ewj);
        this.epR.add(this.ewk);
        this.epR.add(new com.baidu.tieba.homepage.personalize.b.b(this.mPageContext, com.baidu.tieba.homepage.personalize.b.c.TYPE));
        this.epR.add(this.ewh);
        this.epR.add(this.ewi);
        this.epR.add(new k(this.mPageContext, com.baidu.tieba.homepage.personalize.data.g.TYPE));
        this.epR.add(this.ewl);
        aDJ();
        aLs();
        jK("page_recommend");
    }

    private void aLs() {
        if (!bb.ats.get()) {
            AdvertAppInfo.apn.set(false);
            return;
        }
        this.dYq = r.buz().c(this.mPageContext, AdvertAppInfo.ape);
        this.ewm = r.buz().c(this.mPageContext, AdvertAppInfo.aph);
        this.ewn = r.buz().c(this.mPageContext, AdvertAppInfo.api);
        this.ewo = r.buz().c(this.mPageContext, AdvertAppInfo.apj);
        this.ewp = r.buz().c(this.mPageContext, AdvertAppInfo.apk);
        this.ewq = r.buz().c(this.mPageContext, AdvertAppInfo.apl);
        this.ewr = r.buz().c(this.mPageContext, AdvertAppInfo.apm);
        this.epR.add(this.dYq);
        this.epR.add(this.ewm);
        this.epR.add(this.ewn);
        this.epR.add(this.ewo);
        this.epR.add(this.ewp);
        this.epR.add(this.ewq);
        this.epR.add(this.ewr);
        AdvertAppInfo.apn.set(true);
    }

    public void b(com.baidu.tieba.homepage.personalize.model.e eVar) {
        this.ewd.a(eVar);
        this.ewf.a(eVar);
    }

    public void ak(List<com.baidu.adp.widget.ListView.h> list) {
        q.q(list, 2);
        this.evZ.setData(list);
        this.ewa = list;
    }

    public void onChangeSkinType(int i) {
        notifyDataSetChanged();
        this.ewb.onChangeSkinType(i);
        this.ewg.oH(i);
    }

    public void notifyDataSetChanged() {
        if (this.evZ != null) {
            this.evZ.getListAdapter().notifyDataSetChanged();
        }
    }

    public void setFromCDN(boolean z) {
        if (this.ewd != null) {
            this.ewd.setFromCDN(z);
        }
        if (this.ewm != null && (this.ewm instanceof com.baidu.tieba.recapp.m)) {
            ((com.baidu.tieba.recapp.m) this.ewm).setIsFromCDN(z);
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.ewd != null) {
            this.ewd.bdE = bdUniqueId;
        }
        if (this.ewe != null) {
            this.ewe.bdE = bdUniqueId;
        }
        if (this.ewf != null) {
            this.ewf.bdE = bdUniqueId;
        }
        if (this.ewb != null) {
            this.ewb.setPageUniqueId(bdUniqueId);
        }
        if (this.ewg != null) {
            this.ewg.bdE = bdUniqueId;
        }
        if (this.ewh != null) {
            this.ewh.bdE = bdUniqueId;
        }
        if (this.ewi != null) {
            this.ewi.bdE = bdUniqueId;
        }
        if (this.ewj != null) {
            this.ewj.bdE = bdUniqueId;
        }
        if (this.ewk != null) {
            this.ewk.bdE = bdUniqueId;
        }
        if (!v.I(this.dPH)) {
            for (com.baidu.adp.widget.ListView.a aVar : this.dPH) {
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
        if (!this.ewt) {
            this.dPQ.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.dPQ);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ae(Object obj) {
        boolean z;
        boolean z2 = false;
        if (this.ewa != null) {
            Iterator<com.baidu.adp.widget.ListView.h> it = this.ewa.iterator();
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

    private void aDJ() {
        this.ewt = aDK();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aDK() {
        if (this.dPH == null || this.dPH.size() <= 0) {
            this.dPH = new ArrayList();
            ArrayList<BdUniqueId> bCF = q.bCF();
            if (bCF == null || bCF.size() <= 0) {
                return false;
            }
            int size = bCF.size();
            for (int i = 0; i < size; i++) {
                com.baidu.tieba.lego.card.a.a a = com.baidu.tieba.lego.d.b.aZv().a(this.mPageContext, bCF.get(i), 2);
                if (this.ews) {
                    a.setBusinessType(3);
                }
                if (this.ewd != null && this.ewd.bdE != null) {
                    a.setUniqueId(this.ewd.bdE);
                }
                this.dPH.add(a);
            }
            this.evZ.addAdapters(this.dPH);
            return true;
        }
        return true;
    }

    public void a(NEGFeedBackView.a aVar) {
        if (this.ewd != null) {
            this.ewd.setEventCallback(aVar);
        }
        if (this.ewe != null) {
            this.ewe.setEventCallback(aVar);
        }
        if (this.ewf != null) {
            this.ewf.setEventCallback(aVar);
        }
        if (this.ewh != null) {
            this.ewh.setEventCallback(aVar);
        }
        if (this.ewi != null) {
            this.ewi.setEventCallback(aVar);
        }
        if (this.ewj != null) {
            this.ewj.setEventCallback(aVar);
        }
        if (this.ewk != null) {
            this.ewk.setEventCallback(aVar);
        }
    }

    private void jK(String str) {
        if (this.epR != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.epR) {
                if (aVar instanceof com.baidu.tieba.a.f) {
                    ((com.baidu.tieba.a.f) aVar).jK(str);
                }
            }
        }
    }
}
