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
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.coreExtra.message.UpdateAttentionMessage;
import com.baidu.tieba.NEGFeedBack.c;
import com.baidu.tieba.card.data.m;
import com.baidu.tieba.lego.card.model.ICardInfo;
import com.baidu.tieba.recapp.r;
import com.baidu.tieba.tbadkCore.q;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes2.dex */
public class l {
    private List<com.baidu.adp.widget.ListView.a> dKj;
    private com.baidu.adp.widget.ListView.a dRE;
    private BdTypeListView efx;
    private List<com.baidu.adp.widget.ListView.i> ekb;
    private a ekc;
    private j ekd;
    private f eke;
    private e ekf;
    private i ekg;
    private g ekh;
    private c eki;
    private b ekj;
    private h ekk;
    private f ekl;
    private i ekm;
    private com.baidu.adp.widget.ListView.a ekn;
    private com.baidu.adp.widget.ListView.a eko;
    private com.baidu.adp.widget.ListView.a ekp;
    private com.baidu.adp.widget.ListView.a ekq;
    private com.baidu.adp.widget.ListView.a ekr;
    private com.baidu.adp.widget.ListView.a eks;
    private boolean ekt;
    private boolean eku;
    private TbPageContext<?> mPageContext;
    private CustomMessageListener dKs = new CustomMessageListener(2016470) { // from class: com.baidu.tieba.homepage.personalize.a.l.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                l.this.axl();
                if (l.this.ekb != null) {
                    l.this.ao(l.this.ekb);
                }
            }
        }
    };
    private CustomMessageListener mAttentionListener = new CustomMessageListener(2001115) { // from class: com.baidu.tieba.homepage.personalize.a.l.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
            if (updateAttentionMessage != null && updateAttentionMessage.getData() != null && updateAttentionMessage.getData().apP) {
                l.this.aY(updateAttentionMessage.getData());
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
                bVar.feO = true;
                l.this.aY(bVar);
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
                bVar.feO = false;
                l.this.aY(bVar);
            }
        }
    };
    private List<com.baidu.adp.widget.ListView.a> efw = new ArrayList();

    public l(Context context, BdTypeListView bdTypeListView) {
        this.efx = bdTypeListView;
        this.mPageContext = (TbPageContext) com.baidu.adp.base.i.ak(context);
        bB(context);
        bdTypeListView.addAdapters(this.efw);
    }

    private void bB(Context context) {
        this.ekc = new a(this.mPageContext);
        this.ekd = new j(this.mPageContext);
        this.eke = new f(this.mPageContext, com.baidu.tieba.card.data.k.TYPE);
        this.ekf = new e(this.mPageContext, com.baidu.tieba.card.data.k.aOv);
        this.ekg = new i(this.mPageContext, m.daq);
        this.ekj = new b(this.mPageContext, com.baidu.tieba.card.data.l.TYPE);
        this.ekh = new g(this.mPageContext);
        this.eki = new c(this.mPageContext, com.baidu.tieba.card.data.j.TYPE);
        this.ekk = new h(this.mPageContext, com.baidu.tieba.card.data.k.aOB);
        this.ekl = new f(this.mPageContext, com.baidu.tieba.card.data.k.daj);
        this.ekm = new i(this.mPageContext, m.dar);
        this.efw.add(this.ekc);
        this.efw.add(this.ekd);
        this.efw.add(this.ekg);
        this.efw.add(this.eke);
        this.efw.add(this.ekf);
        this.efw.add(this.ekj);
        this.efw.add(this.ekh);
        this.efw.add(this.ekl);
        this.efw.add(this.ekm);
        this.efw.add(new com.baidu.tieba.homepage.personalize.b.b(this.mPageContext, com.baidu.tieba.homepage.personalize.b.c.TYPE));
        this.efw.add(this.eki);
        this.efw.add(this.ekk);
        this.efw.add(new k(this.mPageContext, com.baidu.tieba.homepage.personalize.data.g.TYPE));
        axk();
        aDc();
    }

    private void aDc() {
        if (!bd.aOE.get()) {
            AdvertAppInfo.aKD.set(false);
            return;
        }
        this.dRE = r.bof().c(this.mPageContext, AdvertAppInfo.aKu);
        this.ekn = r.bof().c(this.mPageContext, AdvertAppInfo.aKx);
        this.eko = r.bof().c(this.mPageContext, AdvertAppInfo.aKy);
        this.ekp = r.bof().c(this.mPageContext, AdvertAppInfo.aKz);
        this.ekq = r.bof().c(this.mPageContext, AdvertAppInfo.aKA);
        this.ekr = r.bof().c(this.mPageContext, AdvertAppInfo.aKB);
        this.eks = r.bof().c(this.mPageContext, AdvertAppInfo.aKC);
        this.efw.add(this.dRE);
        this.efw.add(this.ekn);
        this.efw.add(this.eko);
        this.efw.add(this.ekp);
        this.efw.add(this.ekq);
        this.efw.add(this.ekr);
        this.efw.add(this.eks);
        AdvertAppInfo.aKD.set(true);
    }

    public void b(com.baidu.tieba.homepage.personalize.model.e eVar) {
        this.eke.a(eVar);
        this.ekg.a(eVar);
    }

    public void ao(List<com.baidu.adp.widget.ListView.i> list) {
        q.r(list, 2);
        this.efx.setData(list);
        this.ekb = list;
    }

    public void onChangeSkinType(int i) {
        notifyDataSetChanged();
        this.ekc.onChangeSkinType(i);
        this.ekh.oO(i);
    }

    public void notifyDataSetChanged() {
        if (this.efx != null && (this.efx.getAdapter() instanceof com.baidu.adp.widget.ListView.e)) {
            this.efx.getAdapter().notifyDataSetChanged();
        }
    }

    public void setFromCDN(boolean z) {
        if (this.eke != null) {
            this.eke.setFromCDN(z);
        }
        if (this.ekn != null && (this.ekn instanceof com.baidu.tieba.recapp.m)) {
            ((com.baidu.tieba.recapp.m) this.ekn).setIsFromCDN(z);
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.eke != null) {
            this.eke.bII = bdUniqueId;
        }
        if (this.ekf != null) {
            this.ekf.bII = bdUniqueId;
        }
        if (this.ekg != null) {
            this.ekg.bII = bdUniqueId;
        }
        if (this.ekj != null) {
            this.ekj.bII = bdUniqueId;
        }
        if (this.ekc != null) {
            this.ekc.setPageUniqueId(bdUniqueId);
        }
        if (this.ekh != null) {
            this.ekh.bII = bdUniqueId;
        }
        if (this.eki != null) {
            this.eki.bII = bdUniqueId;
        }
        if (this.ekk != null) {
            this.ekk.bII = bdUniqueId;
        }
        if (this.ekl != null) {
            this.ekl.bII = bdUniqueId;
        }
        if (this.ekm != null) {
            this.ekm.bII = bdUniqueId;
        }
        if (!v.E(this.dKj)) {
            for (com.baidu.adp.widget.ListView.a aVar : this.dKj) {
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
        if (!this.eku) {
            this.dKs.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.dKs);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aY(Object obj) {
        boolean z;
        boolean z2 = false;
        if (this.ekb != null) {
            Iterator<com.baidu.adp.widget.ListView.i> it = this.ekb.iterator();
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

    private void axk() {
        this.eku = axl();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean axl() {
        if (this.dKj == null || this.dKj.size() <= 0) {
            this.dKj = new ArrayList();
            ArrayList<BdUniqueId> bwj = q.bwj();
            if (bwj == null || bwj.size() <= 0) {
                return false;
            }
            int size = bwj.size();
            for (int i = 0; i < size; i++) {
                com.baidu.tieba.lego.card.a.a a = com.baidu.tieba.lego.d.b.aRf().a(this.mPageContext, bwj.get(i), 2);
                if (this.ekt) {
                    a.setBusinessType(3);
                }
                if (this.eke != null && this.eke.bII != null) {
                    a.setUniqueId(this.eke.bII);
                }
                this.dKj.add(a);
            }
            this.efx.addAdapters(this.dKj);
            return true;
        }
        return true;
    }

    public void a(c.a aVar) {
        if (this.eke != null) {
            this.eke.setEventCallback(aVar);
        }
        if (this.ekf != null) {
            this.ekf.setEventCallback(aVar);
        }
        if (this.ekj != null) {
            this.ekj.setEventCallback(aVar);
        }
        if (this.ekg != null) {
            this.ekg.setEventCallback(aVar);
        }
        if (this.eki != null) {
            this.eki.setEventCallback(aVar);
        }
        if (this.ekk != null) {
            this.ekk.setEventCallback(aVar);
        }
        if (this.ekl != null) {
            this.ekl.setEventCallback(aVar);
        }
        if (this.ekm != null) {
            this.ekm.setEventCallback(aVar);
        }
    }

    public void setCardShowType(int i) {
        this.eke.setCardShowType(i);
        this.ekf.setCardShowType(i);
        this.ekg.setCardShowType(i);
        this.eki.setCardShowType(i);
        this.ekk.setCardShowType(i);
        this.ekl.setCardShowType(i);
        this.ekm.setCardShowType(i);
    }
}
