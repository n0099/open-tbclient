package com.baidu.tieba.homepage.personalize.a;

import android.content.Context;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.data.be;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.coreExtra.message.UpdateAttentionMessage;
import com.baidu.tieba.NEGFeedBack.c;
import com.baidu.tieba.card.data.l;
import com.baidu.tieba.card.data.m;
import com.baidu.tieba.card.data.n;
import com.baidu.tieba.lego.card.model.ICardInfo;
import com.baidu.tieba.recapp.q;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes2.dex */
public class k {
    private List<com.baidu.adp.widget.ListView.a> dCg;
    private com.baidu.adp.widget.ListView.a dJD;
    private BdTypeListView dZF;
    private List<com.baidu.adp.widget.ListView.i> eef;
    private a eeg;
    private j eeh;
    private f eei;
    private e eej;
    private i eek;
    private g eel;
    private c eem;
    private b een;
    private h eeo;
    private f eep;
    private i eeq;
    private com.baidu.adp.widget.ListView.a eer;
    private com.baidu.adp.widget.ListView.a ees;
    private com.baidu.adp.widget.ListView.a eet;
    private com.baidu.adp.widget.ListView.a eeu;
    private com.baidu.adp.widget.ListView.a eev;
    private com.baidu.adp.widget.ListView.a eew;
    private boolean eex;
    private boolean eey;
    private TbPageContext<?> mPageContext;
    private CustomMessageListener dCq = new CustomMessageListener(CmdConfigCustom.CMD_LEGO_REGISTER) { // from class: com.baidu.tieba.homepage.personalize.a.k.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                k.this.ave();
                if (k.this.eef != null) {
                    k.this.ao(k.this.eef);
                }
            }
        }
    };
    private CustomMessageListener mAttentionListener = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.homepage.personalize.a.k.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
            if (updateAttentionMessage != null && updateAttentionMessage.getData() != null && updateAttentionMessage.getData().apO) {
                k.this.aW(updateAttentionMessage.getData());
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
                bVar.eYz = true;
                k.this.aW(bVar);
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
                bVar.eYz = false;
                k.this.aW(bVar);
            }
        }
    };
    private List<com.baidu.adp.widget.ListView.a> dZE = new ArrayList();

    public k(Context context, BdTypeListView bdTypeListView) {
        this.dZF = bdTypeListView;
        this.mPageContext = (TbPageContext) com.baidu.adp.base.i.ak(context);
        bF(context);
        bdTypeListView.addAdapters(this.dZE);
    }

    private void bF(Context context) {
        this.eeg = new a(this.mPageContext);
        this.eeh = new j(this.mPageContext);
        this.eei = new f(this.mPageContext, l.TYPE);
        this.eej = new e(this.mPageContext, l.aNd);
        this.eek = new i(this.mPageContext, n.cSG);
        this.een = new b(this.mPageContext, m.TYPE);
        this.eel = new g(this.mPageContext);
        this.eem = new c(this.mPageContext, com.baidu.tieba.card.data.k.TYPE);
        this.eeo = new h(this.mPageContext, l.aNj);
        this.eep = new f(this.mPageContext, l.cSz);
        this.eeq = new i(this.mPageContext, n.cSH);
        this.dZE.add(this.eeg);
        this.dZE.add(this.eeh);
        this.dZE.add(this.eek);
        this.dZE.add(this.eei);
        this.dZE.add(this.eej);
        this.dZE.add(this.een);
        this.dZE.add(this.eel);
        this.dZE.add(this.eep);
        this.dZE.add(this.eeq);
        this.dZE.add(new com.baidu.tieba.homepage.personalize.b.b(this.mPageContext, com.baidu.tieba.homepage.personalize.b.c.TYPE));
        this.dZE.add(this.eem);
        this.dZE.add(this.eeo);
        avd();
        aBy();
    }

    private void aBy() {
        if (!be.aNm.get()) {
            AdvertAppInfo.aJj.set(false);
            return;
        }
        this.dJD = q.bty().c(this.mPageContext, AdvertAppInfo.aJa);
        this.eer = q.bty().c(this.mPageContext, AdvertAppInfo.aJd);
        this.ees = q.bty().c(this.mPageContext, AdvertAppInfo.aJe);
        this.eet = q.bty().c(this.mPageContext, AdvertAppInfo.aJf);
        this.eeu = q.bty().c(this.mPageContext, AdvertAppInfo.aJg);
        this.eev = q.bty().c(this.mPageContext, AdvertAppInfo.aJh);
        this.eew = q.bty().c(this.mPageContext, AdvertAppInfo.aJi);
        this.dZE.add(this.dJD);
        this.dZE.add(this.eer);
        this.dZE.add(this.ees);
        this.dZE.add(this.eet);
        this.dZE.add(this.eeu);
        this.dZE.add(this.eev);
        this.dZE.add(this.eew);
        AdvertAppInfo.aJj.set(true);
    }

    public void b(com.baidu.tieba.homepage.personalize.model.e eVar) {
        this.eei.a(eVar);
        this.eek.a(eVar);
    }

    public void ao(List<com.baidu.adp.widget.ListView.i> list) {
        com.baidu.tieba.tbadkCore.q.s(list, 2);
        this.dZF.setData(list);
        this.eef = list;
    }

    public void onChangeSkinType(int i) {
        notifyDataSetChanged();
        this.eeg.onChangeSkinType(i);
        this.eel.oU(i);
    }

    public void notifyDataSetChanged() {
        if (this.dZF != null && (this.dZF.getAdapter() instanceof com.baidu.adp.widget.ListView.e)) {
            this.dZF.getAdapter().notifyDataSetChanged();
        }
    }

    public void setFromCDN(boolean z) {
        if (this.eei != null) {
            this.eei.setFromCDN(z);
        }
        if (this.eer != null && (this.eer instanceof com.baidu.tieba.recapp.n)) {
            ((com.baidu.tieba.recapp.n) this.eer).setIsFromCDN(z);
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.eei != null) {
            this.eei.bGo = bdUniqueId;
        }
        if (this.eej != null) {
            this.eej.bGo = bdUniqueId;
        }
        if (this.eek != null) {
            this.eek.bGo = bdUniqueId;
        }
        if (this.een != null) {
            this.een.bGo = bdUniqueId;
        }
        if (this.eeg != null) {
            this.eeg.setPageUniqueId(bdUniqueId);
        }
        if (this.eel != null) {
            this.eel.bGo = bdUniqueId;
        }
        if (this.eem != null) {
            this.eem.bGo = bdUniqueId;
        }
        if (this.eeo != null) {
            this.eeo.bGo = bdUniqueId;
        }
        if (this.eep != null) {
            this.eep.bGo = bdUniqueId;
        }
        if (this.eeq != null) {
            this.eeq.bGo = bdUniqueId;
        }
        if (!v.G(this.dCg)) {
            for (com.baidu.adp.widget.ListView.a aVar : this.dCg) {
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
        if (!this.eey) {
            this.dCq.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.dCq);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aW(Object obj) {
        boolean z;
        boolean z2 = false;
        if (this.eef != null) {
            Iterator<com.baidu.adp.widget.ListView.i> it = this.eef.iterator();
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

    private void avd() {
        this.eey = ave();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean ave() {
        if (this.dCg == null || this.dCg.size() <= 0) {
            this.dCg = new ArrayList();
            ArrayList<BdUniqueId> bBv = com.baidu.tieba.tbadkCore.q.bBv();
            if (bBv == null || bBv.size() <= 0) {
                return false;
            }
            int size = bBv.size();
            for (int i = 0; i < size; i++) {
                com.baidu.tieba.lego.card.a.a a = com.baidu.tieba.lego.d.b.aPk().a(this.mPageContext, bBv.get(i), 2);
                if (this.eex) {
                    a.setBusinessType(3);
                }
                if (this.eei != null && this.eei.bGo != null) {
                    a.setUniqueId(this.eei.bGo);
                }
                this.dCg.add(a);
            }
            this.dZF.addAdapters(this.dCg);
            return true;
        }
        return true;
    }

    public void a(c.a aVar) {
        if (this.eei != null) {
            this.eei.setEventCallback(aVar);
        }
        if (this.eej != null) {
            this.eej.setEventCallback(aVar);
        }
        if (this.een != null) {
            this.een.setEventCallback(aVar);
        }
        if (this.eek != null) {
            this.eek.setEventCallback(aVar);
        }
        if (this.eem != null) {
            this.eem.setEventCallback(aVar);
        }
        if (this.eeo != null) {
            this.eeo.setEventCallback(aVar);
        }
        if (this.eep != null) {
            this.eep.setEventCallback(aVar);
        }
        if (this.eeq != null) {
            this.eeq.setEventCallback(aVar);
        }
    }
}
