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
    private BdTypeListView aXC;
    private List<com.baidu.adp.widget.ListView.a> cNf;
    private com.baidu.adp.widget.ListView.a cRl;
    private List<com.baidu.adp.widget.ListView.f> drZ;
    private a dsa;
    private j dsb;
    private f dsc;
    private e dsd;
    private i dse;
    private g dsf;
    private c dsg;
    private b dsh;
    private h dsi;
    private f dsj;
    private i dsk;
    private com.baidu.adp.widget.ListView.a dsl;
    private com.baidu.adp.widget.ListView.a dsm;
    private com.baidu.adp.widget.ListView.a dsn;
    private com.baidu.adp.widget.ListView.a dso;
    private com.baidu.adp.widget.ListView.a dsp;
    private com.baidu.adp.widget.ListView.a dsq;
    private boolean dsr;
    private boolean dss;
    private TbPageContext<?> mPageContext;
    private CustomMessageListener cNp = new CustomMessageListener(CmdConfigCustom.CMD_LEGO_REGISTER) { // from class: com.baidu.tieba.homepage.personalize.a.k.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                k.this.anB();
                if (k.this.drZ != null) {
                    k.this.ae(k.this.drZ);
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
                bVar.emt = true;
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
                bVar.emt = false;
                k.this.S(bVar);
            }
        }
    };
    private List<com.baidu.adp.widget.ListView.a> dnw = new ArrayList();

    public k(Context context, BdTypeListView bdTypeListView) {
        this.aXC = bdTypeListView;
        this.mPageContext = (TbPageContext) com.baidu.adp.base.i.Y(context);
        bu(context);
        bdTypeListView.addAdapters(this.dnw);
    }

    private void bu(Context context) {
        this.dsa = new a(this.mPageContext);
        this.dsb = new j(this.mPageContext);
        this.cRl = q.blR().c(this.mPageContext, AdvertAppInfo.UD);
        this.dsl = q.blR().c(this.mPageContext, AdvertAppInfo.UG);
        this.dsm = q.blR().c(this.mPageContext, AdvertAppInfo.UH);
        this.dsn = q.blR().c(this.mPageContext, AdvertAppInfo.UI);
        this.dso = q.blR().c(this.mPageContext, AdvertAppInfo.UJ);
        this.dsp = q.blR().c(this.mPageContext, AdvertAppInfo.UK);
        this.dsq = q.blR().c(this.mPageContext, AdvertAppInfo.UL);
        this.dsc = new f(this.mPageContext, l.TYPE);
        this.dsd = new e(this.mPageContext, l.YE);
        this.dse = new i(this.mPageContext, n.cec);
        this.dsh = new b(this.mPageContext, m.TYPE);
        this.dsf = new g(this.mPageContext);
        this.dsg = new c(this.mPageContext, com.baidu.tieba.card.data.k.TYPE);
        this.dsi = new h(this.mPageContext, l.YK);
        this.dsj = new f(this.mPageContext, l.cdV);
        this.dsk = new i(this.mPageContext, n.ced);
        this.dnw.add(this.dsa);
        this.dnw.add(this.dsb);
        this.dnw.add(this.cRl);
        this.dnw.add(this.dsl);
        this.dnw.add(this.dsm);
        this.dnw.add(this.dsn);
        this.dnw.add(this.dso);
        this.dnw.add(this.dsp);
        this.dnw.add(this.dsq);
        this.dnw.add(this.dse);
        this.dnw.add(this.dsc);
        this.dnw.add(this.dsd);
        this.dnw.add(this.dsh);
        this.dnw.add(this.dsf);
        this.dnw.add(this.dsj);
        this.dnw.add(this.dsk);
        this.dnw.add(new com.baidu.tieba.homepage.personalize.b.b(this.mPageContext, com.baidu.tieba.homepage.personalize.b.c.TYPE));
        this.dnw.add(this.dsg);
        this.dnw.add(this.dsi);
        anA();
    }

    public void b(com.baidu.tieba.homepage.personalize.model.e eVar) {
        this.dsc.a(eVar);
        this.dse.a(eVar);
    }

    public void ae(List<com.baidu.adp.widget.ListView.f> list) {
        p.p(list, 2);
        this.aXC.setData(list);
        this.drZ = list;
    }

    public void onChangeSkinType(int i) {
        notifyDataSetChanged();
        this.dsa.onChangeSkinType(i);
        this.dsf.md(i);
    }

    public void notifyDataSetChanged() {
        if (this.aXC != null && (this.aXC.getAdapter() instanceof com.baidu.adp.widget.ListView.d)) {
            ((com.baidu.adp.widget.ListView.d) this.aXC.getAdapter()).notifyDataSetChanged();
        }
    }

    public void setFromCDN(boolean z) {
        if (this.dsc != null) {
            this.dsc.setFromCDN(z);
        }
        if (this.dsl != null && (this.dsl instanceof com.baidu.tieba.recapp.n)) {
            ((com.baidu.tieba.recapp.n) this.dsl).setIsFromCDN(z);
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.dsc != null) {
            this.dsc.aSB = bdUniqueId;
        }
        if (this.dsd != null) {
            this.dsd.aSB = bdUniqueId;
        }
        if (this.dse != null) {
            this.dse.aSB = bdUniqueId;
        }
        if (this.dsh != null) {
            this.dsh.aSB = bdUniqueId;
        }
        if (this.dsa != null) {
            this.dsa.setPageUniqueId(bdUniqueId);
        }
        if (this.dsf != null) {
            this.dsf.aSB = bdUniqueId;
        }
        if (this.dsg != null) {
            this.dsg.aSB = bdUniqueId;
        }
        if (this.dsi != null) {
            this.dsi.aSB = bdUniqueId;
        }
        if (this.dsj != null) {
            this.dsj.aSB = bdUniqueId;
        }
        if (this.dsk != null) {
            this.dsk.aSB = bdUniqueId;
        }
        if (!v.w(this.cNf)) {
            for (com.baidu.adp.widget.ListView.a aVar : this.cNf) {
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
        if (!this.dss) {
            this.cNp.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.cNp);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void S(Object obj) {
        boolean z;
        boolean z2 = false;
        if (this.drZ != null) {
            Iterator<com.baidu.adp.widget.ListView.f> it = this.drZ.iterator();
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

    private void anA() {
        this.dss = anB();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean anB() {
        if (this.cNf == null || this.cNf.size() <= 0) {
            this.cNf = new ArrayList();
            ArrayList<BdUniqueId> bwg = p.bwg();
            if (bwg == null || bwg.size() <= 0) {
                return false;
            }
            int size = bwg.size();
            for (int i = 0; i < size; i++) {
                com.baidu.tieba.lego.card.a.a a = com.baidu.tieba.lego.d.b.aIk().a(this.mPageContext, bwg.get(i), 2);
                if (this.dsr) {
                    a.setBusinessType(3);
                }
                if (this.dsc != null && this.dsc.aSB != null) {
                    a.setUniqueId(this.dsc.aSB);
                }
                this.cNf.add(a);
            }
            this.aXC.addAdapters(this.cNf);
            return true;
        }
        return true;
    }

    public void a(c.a aVar) {
        if (this.dsc != null) {
            this.dsc.setEventCallback(aVar);
        }
        if (this.dsd != null) {
            this.dsd.setEventCallback(aVar);
        }
        if (this.dsh != null) {
            this.dsh.setEventCallback(aVar);
        }
        if (this.dse != null) {
            this.dse.setEventCallback(aVar);
        }
        if (this.dsg != null) {
            this.dsg.setEventCallback(aVar);
        }
        if (this.dsi != null) {
            this.dsi.setEventCallback(aVar);
        }
        if (this.dsj != null) {
            this.dsj.setEventCallback(aVar);
        }
        if (this.dsk != null) {
            this.dsk.setEventCallback(aVar);
        }
    }
}
