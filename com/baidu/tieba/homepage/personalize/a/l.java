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
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes2.dex */
public class l {
    private List<com.baidu.adp.widget.ListView.a> dKc;
    private com.baidu.adp.widget.ListView.a dRx;
    private BdTypeListView efB;
    private List<com.baidu.adp.widget.ListView.i> ekf;
    private a ekg;
    private j ekh;
    private f eki;
    private e ekj;
    private i ekk;
    private g ekl;
    private c ekm;
    private b ekn;
    private h eko;
    private f ekp;
    private i ekq;
    private com.baidu.adp.widget.ListView.a ekr;
    private com.baidu.adp.widget.ListView.a eks;
    private com.baidu.adp.widget.ListView.a ekt;
    private com.baidu.adp.widget.ListView.a eku;
    private com.baidu.adp.widget.ListView.a ekv;
    private com.baidu.adp.widget.ListView.a ekw;
    private boolean ekx;
    private boolean eky;
    private TbPageContext<?> mPageContext;
    private CustomMessageListener dKl = new CustomMessageListener(2016470) { // from class: com.baidu.tieba.homepage.personalize.a.l.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                l.this.axm();
                if (l.this.ekf != null) {
                    l.this.ao(l.this.ekf);
                }
            }
        }
    };
    private CustomMessageListener mAttentionListener = new CustomMessageListener(2001115) { // from class: com.baidu.tieba.homepage.personalize.a.l.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
            if (updateAttentionMessage != null && updateAttentionMessage.getData() != null && updateAttentionMessage.getData().apH) {
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
                bVar.feQ = true;
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
                bVar.feQ = false;
                l.this.aY(bVar);
            }
        }
    };
    private List<com.baidu.adp.widget.ListView.a> efA = new ArrayList();

    public l(Context context, BdTypeListView bdTypeListView) {
        this.efB = bdTypeListView;
        this.mPageContext = (TbPageContext) com.baidu.adp.base.i.ak(context);
        bB(context);
        bdTypeListView.addAdapters(this.efA);
    }

    private void bB(Context context) {
        this.ekg = new a(this.mPageContext);
        this.ekh = new j(this.mPageContext);
        this.eki = new f(this.mPageContext, com.baidu.tieba.card.data.k.TYPE);
        this.ekj = new e(this.mPageContext, com.baidu.tieba.card.data.k.aOl);
        this.ekk = new i(this.mPageContext, m.dah);
        this.ekn = new b(this.mPageContext, com.baidu.tieba.card.data.l.TYPE);
        this.ekl = new g(this.mPageContext);
        this.ekm = new c(this.mPageContext, com.baidu.tieba.card.data.j.TYPE);
        this.eko = new h(this.mPageContext, com.baidu.tieba.card.data.k.aOr);
        this.ekp = new f(this.mPageContext, com.baidu.tieba.card.data.k.daa);
        this.ekq = new i(this.mPageContext, m.dai);
        this.efA.add(this.ekg);
        this.efA.add(this.ekh);
        this.efA.add(this.ekk);
        this.efA.add(this.eki);
        this.efA.add(this.ekj);
        this.efA.add(this.ekn);
        this.efA.add(this.ekl);
        this.efA.add(this.ekp);
        this.efA.add(this.ekq);
        this.efA.add(new com.baidu.tieba.homepage.personalize.b.b(this.mPageContext, com.baidu.tieba.homepage.personalize.b.c.TYPE));
        this.efA.add(this.ekm);
        this.efA.add(this.eko);
        this.efA.add(new k(this.mPageContext, com.baidu.tieba.homepage.personalize.data.g.TYPE));
        axl();
        aDc();
    }

    private void aDc() {
        if (!bd.aOu.get()) {
            AdvertAppInfo.aKt.set(false);
            return;
        }
        this.dRx = r.bof().c(this.mPageContext, AdvertAppInfo.aKk);
        this.ekr = r.bof().c(this.mPageContext, AdvertAppInfo.aKn);
        this.eks = r.bof().c(this.mPageContext, AdvertAppInfo.aKo);
        this.ekt = r.bof().c(this.mPageContext, AdvertAppInfo.aKp);
        this.eku = r.bof().c(this.mPageContext, AdvertAppInfo.aKq);
        this.ekv = r.bof().c(this.mPageContext, AdvertAppInfo.aKr);
        this.ekw = r.bof().c(this.mPageContext, AdvertAppInfo.aKs);
        this.efA.add(this.dRx);
        this.efA.add(this.ekr);
        this.efA.add(this.eks);
        this.efA.add(this.ekt);
        this.efA.add(this.eku);
        this.efA.add(this.ekv);
        this.efA.add(this.ekw);
        AdvertAppInfo.aKt.set(true);
    }

    public void b(com.baidu.tieba.homepage.personalize.model.e eVar) {
        this.eki.a(eVar);
        this.ekk.a(eVar);
    }

    public void ao(List<com.baidu.adp.widget.ListView.i> list) {
        com.baidu.tieba.tbadkCore.r.r(list, 2);
        this.efB.setData(list);
        this.ekf = list;
    }

    public void onChangeSkinType(int i) {
        notifyDataSetChanged();
        this.ekg.onChangeSkinType(i);
        this.ekl.oP(i);
    }

    public void notifyDataSetChanged() {
        if (this.efB != null && (this.efB.getAdapter() instanceof com.baidu.adp.widget.ListView.e)) {
            this.efB.getAdapter().notifyDataSetChanged();
        }
    }

    public void setFromCDN(boolean z) {
        if (this.eki != null) {
            this.eki.setFromCDN(z);
        }
        if (this.ekr != null && (this.ekr instanceof com.baidu.tieba.recapp.m)) {
            ((com.baidu.tieba.recapp.m) this.ekr).setIsFromCDN(z);
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.eki != null) {
            this.eki.bIy = bdUniqueId;
        }
        if (this.ekj != null) {
            this.ekj.bIy = bdUniqueId;
        }
        if (this.ekk != null) {
            this.ekk.bIy = bdUniqueId;
        }
        if (this.ekn != null) {
            this.ekn.bIy = bdUniqueId;
        }
        if (this.ekg != null) {
            this.ekg.setPageUniqueId(bdUniqueId);
        }
        if (this.ekl != null) {
            this.ekl.bIy = bdUniqueId;
        }
        if (this.ekm != null) {
            this.ekm.bIy = bdUniqueId;
        }
        if (this.eko != null) {
            this.eko.bIy = bdUniqueId;
        }
        if (this.ekp != null) {
            this.ekp.bIy = bdUniqueId;
        }
        if (this.ekq != null) {
            this.ekq.bIy = bdUniqueId;
        }
        if (!v.E(this.dKc)) {
            for (com.baidu.adp.widget.ListView.a aVar : this.dKc) {
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
        if (!this.eky) {
            this.dKl.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.dKl);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aY(Object obj) {
        boolean z;
        boolean z2 = false;
        if (this.ekf != null) {
            Iterator<com.baidu.adp.widget.ListView.i> it = this.ekf.iterator();
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

    private void axl() {
        this.eky = axm();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean axm() {
        if (this.dKc == null || this.dKc.size() <= 0) {
            this.dKc = new ArrayList();
            ArrayList<BdUniqueId> bwn = com.baidu.tieba.tbadkCore.r.bwn();
            if (bwn == null || bwn.size() <= 0) {
                return false;
            }
            int size = bwn.size();
            for (int i = 0; i < size; i++) {
                com.baidu.tieba.lego.card.a.a a = com.baidu.tieba.lego.d.b.aRf().a(this.mPageContext, bwn.get(i), 2);
                if (this.ekx) {
                    a.setBusinessType(3);
                }
                if (this.eki != null && this.eki.bIy != null) {
                    a.setUniqueId(this.eki.bIy);
                }
                this.dKc.add(a);
            }
            this.efB.addAdapters(this.dKc);
            return true;
        }
        return true;
    }

    public void a(c.a aVar) {
        if (this.eki != null) {
            this.eki.setEventCallback(aVar);
        }
        if (this.ekj != null) {
            this.ekj.setEventCallback(aVar);
        }
        if (this.ekn != null) {
            this.ekn.setEventCallback(aVar);
        }
        if (this.ekk != null) {
            this.ekk.setEventCallback(aVar);
        }
        if (this.ekm != null) {
            this.ekm.setEventCallback(aVar);
        }
        if (this.eko != null) {
            this.eko.setEventCallback(aVar);
        }
        if (this.ekp != null) {
            this.ekp.setEventCallback(aVar);
        }
        if (this.ekq != null) {
            this.ekq.setEventCallback(aVar);
        }
    }

    public void setCardShowType(int i) {
        this.eki.setCardShowType(i);
        this.ekj.setCardShowType(i);
        this.ekk.setCardShowType(i);
        this.ekm.setCardShowType(i);
        this.eko.setCardShowType(i);
        this.ekp.setCardShowType(i);
        this.ekq.setCardShowType(i);
    }
}
