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
    private BdTypeListView aXy;
    private List<com.baidu.adp.widget.ListView.a> cNb;
    private com.baidu.adp.widget.ListView.a cRh;
    private List<com.baidu.adp.widget.ListView.f> drV;
    private a drW;
    private j drX;
    private f drY;
    private e drZ;
    private i dsa;
    private g dsb;
    private c dsc;
    private b dsd;
    private h dse;
    private f dsf;
    private i dsg;
    private com.baidu.adp.widget.ListView.a dsh;
    private com.baidu.adp.widget.ListView.a dsi;
    private com.baidu.adp.widget.ListView.a dsj;
    private com.baidu.adp.widget.ListView.a dsk;
    private com.baidu.adp.widget.ListView.a dsl;
    private com.baidu.adp.widget.ListView.a dsm;
    private boolean dsn;
    private boolean dso;
    private TbPageContext<?> mPageContext;
    private CustomMessageListener cNl = new CustomMessageListener(CmdConfigCustom.CMD_LEGO_REGISTER) { // from class: com.baidu.tieba.homepage.personalize.a.k.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                k.this.anB();
                if (k.this.drV != null) {
                    k.this.ae(k.this.drV);
                }
            }
        }
    };
    private CustomMessageListener mAttentionListener = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.homepage.personalize.a.k.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
            if (updateAttentionMessage != null && updateAttentionMessage.getData() != null && updateAttentionMessage.getData().BI) {
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
                bVar.emp = true;
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
                bVar.emp = false;
                k.this.S(bVar);
            }
        }
    };
    private List<com.baidu.adp.widget.ListView.a> dns = new ArrayList();

    public k(Context context, BdTypeListView bdTypeListView) {
        this.aXy = bdTypeListView;
        this.mPageContext = (TbPageContext) com.baidu.adp.base.i.Y(context);
        bu(context);
        bdTypeListView.addAdapters(this.dns);
    }

    private void bu(Context context) {
        this.drW = new a(this.mPageContext);
        this.drX = new j(this.mPageContext);
        this.cRh = q.blR().c(this.mPageContext, AdvertAppInfo.Uz);
        this.dsh = q.blR().c(this.mPageContext, AdvertAppInfo.UD);
        this.dsi = q.blR().c(this.mPageContext, AdvertAppInfo.UE);
        this.dsj = q.blR().c(this.mPageContext, AdvertAppInfo.UF);
        this.dsk = q.blR().c(this.mPageContext, AdvertAppInfo.UG);
        this.dsl = q.blR().c(this.mPageContext, AdvertAppInfo.UH);
        this.dsm = q.blR().c(this.mPageContext, AdvertAppInfo.UI);
        this.drY = new f(this.mPageContext, l.TYPE);
        this.drZ = new e(this.mPageContext, l.YB);
        this.dsa = new i(this.mPageContext, n.cdY);
        this.dsd = new b(this.mPageContext, m.TYPE);
        this.dsb = new g(this.mPageContext);
        this.dsc = new c(this.mPageContext, com.baidu.tieba.card.data.k.TYPE);
        this.dse = new h(this.mPageContext, l.YH);
        this.dsf = new f(this.mPageContext, l.cdR);
        this.dsg = new i(this.mPageContext, n.cdZ);
        this.dns.add(this.drW);
        this.dns.add(this.drX);
        this.dns.add(this.cRh);
        this.dns.add(this.dsh);
        this.dns.add(this.dsi);
        this.dns.add(this.dsj);
        this.dns.add(this.dsk);
        this.dns.add(this.dsl);
        this.dns.add(this.dsm);
        this.dns.add(this.dsa);
        this.dns.add(this.drY);
        this.dns.add(this.drZ);
        this.dns.add(this.dsd);
        this.dns.add(this.dsb);
        this.dns.add(this.dsf);
        this.dns.add(this.dsg);
        this.dns.add(new com.baidu.tieba.homepage.personalize.b.b(this.mPageContext, com.baidu.tieba.homepage.personalize.b.c.TYPE));
        this.dns.add(this.dsc);
        this.dns.add(this.dse);
        anA();
    }

    public void b(com.baidu.tieba.homepage.personalize.model.e eVar) {
        this.drY.a(eVar);
        this.dsa.a(eVar);
    }

    public void ae(List<com.baidu.adp.widget.ListView.f> list) {
        p.p(list, 2);
        this.aXy.setData(list);
        this.drV = list;
    }

    public void onChangeSkinType(int i) {
        notifyDataSetChanged();
        this.drW.onChangeSkinType(i);
        this.dsb.md(i);
    }

    public void notifyDataSetChanged() {
        if (this.aXy != null && (this.aXy.getAdapter() instanceof com.baidu.adp.widget.ListView.d)) {
            ((com.baidu.adp.widget.ListView.d) this.aXy.getAdapter()).notifyDataSetChanged();
        }
    }

    public void setFromCDN(boolean z) {
        if (this.drY != null) {
            this.drY.setFromCDN(z);
        }
        if (this.dsh != null && (this.dsh instanceof com.baidu.tieba.recapp.n)) {
            ((com.baidu.tieba.recapp.n) this.dsh).setIsFromCDN(z);
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.drY != null) {
            this.drY.aSy = bdUniqueId;
        }
        if (this.drZ != null) {
            this.drZ.aSy = bdUniqueId;
        }
        if (this.dsa != null) {
            this.dsa.aSy = bdUniqueId;
        }
        if (this.dsd != null) {
            this.dsd.aSy = bdUniqueId;
        }
        if (this.drW != null) {
            this.drW.setPageUniqueId(bdUniqueId);
        }
        if (this.dsb != null) {
            this.dsb.aSy = bdUniqueId;
        }
        if (this.dsc != null) {
            this.dsc.aSy = bdUniqueId;
        }
        if (this.dse != null) {
            this.dse.aSy = bdUniqueId;
        }
        if (this.dsf != null) {
            this.dsf.aSy = bdUniqueId;
        }
        if (this.dsg != null) {
            this.dsg.aSy = bdUniqueId;
        }
        if (!v.w(this.cNb)) {
            for (com.baidu.adp.widget.ListView.a aVar : this.cNb) {
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
        if (!this.dso) {
            this.cNl.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.cNl);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void S(Object obj) {
        boolean z;
        boolean z2 = false;
        if (this.drV != null) {
            Iterator<com.baidu.adp.widget.ListView.f> it = this.drV.iterator();
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
        this.dso = anB();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean anB() {
        if (this.cNb == null || this.cNb.size() <= 0) {
            this.cNb = new ArrayList();
            ArrayList<BdUniqueId> bwg = p.bwg();
            if (bwg == null || bwg.size() <= 0) {
                return false;
            }
            int size = bwg.size();
            for (int i = 0; i < size; i++) {
                com.baidu.tieba.lego.card.a.a a = com.baidu.tieba.lego.d.b.aIk().a(this.mPageContext, bwg.get(i), 2);
                if (this.dsn) {
                    a.setBusinessType(3);
                }
                if (this.drY != null && this.drY.aSy != null) {
                    a.setUniqueId(this.drY.aSy);
                }
                this.cNb.add(a);
            }
            this.aXy.addAdapters(this.cNb);
            return true;
        }
        return true;
    }

    public void a(c.a aVar) {
        if (this.drY != null) {
            this.drY.setEventCallback(aVar);
        }
        if (this.drZ != null) {
            this.drZ.setEventCallback(aVar);
        }
        if (this.dsd != null) {
            this.dsd.setEventCallback(aVar);
        }
        if (this.dsa != null) {
            this.dsa.setEventCallback(aVar);
        }
        if (this.dsc != null) {
            this.dsc.setEventCallback(aVar);
        }
        if (this.dse != null) {
            this.dse.setEventCallback(aVar);
        }
        if (this.dsf != null) {
            this.dsf.setEventCallback(aVar);
        }
        if (this.dsg != null) {
            this.dsg.setEventCallback(aVar);
        }
    }
}
