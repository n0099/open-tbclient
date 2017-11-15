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
    private BdTypeListView aUv;
    private List<com.baidu.adp.widget.ListView.a> cDL;
    private com.baidu.adp.widget.ListView.a cHL;
    private List<com.baidu.adp.widget.ListView.f> dif;
    private a dig;
    private k dih;
    private com.baidu.adp.widget.ListView.a dii;
    private h dij;
    private g dik;
    private j dil;
    private e dim;
    private f din;
    private i dio;
    private c dip;
    private b diq;
    private boolean dir;
    private boolean dis;
    private TbPageContext<?> mPageContext;
    private CustomMessageListener cDV = new CustomMessageListener(CmdConfigCustom.CMD_LEGO_REGISTER) { // from class: com.baidu.tieba.homepage.personalize.a.l.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                l.this.alx();
                if (l.this.dif != null) {
                    l.this.br(l.this.dif);
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
                bVar.eft = true;
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
                bVar.eft = false;
                l.this.S(bVar);
            }
        }
    };
    private List<com.baidu.adp.widget.ListView.a> ddI = new ArrayList();

    public l(Context context, BdTypeListView bdTypeListView) {
        this.aUv = bdTypeListView;
        this.mPageContext = (TbPageContext) com.baidu.adp.base.i.Y(context);
        bs(context);
        bdTypeListView.addAdapters(this.ddI);
    }

    private void bs(Context context) {
        this.dig = new a(this.mPageContext);
        this.dih = new k(this.mPageContext);
        this.cHL = r.bjl().c(this.mPageContext, AdvertAppInfo.Ub);
        this.dii = r.bjl().c(this.mPageContext, AdvertAppInfo.Ue);
        this.dij = new h(this.mPageContext, com.baidu.tieba.card.data.l.TYPE);
        this.dik = new g(this.mPageContext, com.baidu.tieba.card.data.l.Yp);
        this.dil = new j(this.mPageContext, n.bVq);
        this.diq = new b(this.mPageContext, m.TYPE);
        this.dim = new e(this.mPageContext, com.baidu.tieba.card.data.l.bVj);
        this.din = new f(this.mPageContext, n.bVr);
        this.dio = new i(this.mPageContext);
        this.dip = new c(this.mPageContext, com.baidu.tieba.card.data.k.TYPE);
        this.ddI.add(this.dig);
        this.ddI.add(this.dih);
        this.ddI.add(this.cHL);
        this.ddI.add(this.dii);
        this.ddI.add(this.dil);
        this.ddI.add(this.dij);
        this.ddI.add(this.dik);
        this.ddI.add(this.diq);
        this.ddI.add(this.dim);
        this.ddI.add(this.din);
        this.ddI.add(this.dio);
        this.ddI.add(new com.baidu.tieba.homepage.personalize.b.b(this.mPageContext, com.baidu.tieba.homepage.personalize.b.c.TYPE));
        this.ddI.add(this.dip);
        alw();
    }

    public void b(com.baidu.tieba.homepage.personalize.model.e eVar) {
        this.dij.a(eVar);
        this.dil.a(eVar);
        this.dim.a(eVar);
        this.din.a(eVar);
    }

    public void br(List<com.baidu.adp.widget.ListView.f> list) {
        o.p(list, 2);
        this.aUv.setData(list);
        this.dif = list;
    }

    public void onChangeSkinType(int i) {
        notifyDataSetChanged();
        this.dig.onChangeSkinType(i);
        this.dio.lx(i);
    }

    public void notifyDataSetChanged() {
        if (this.aUv != null && (this.aUv.getAdapter() instanceof com.baidu.adp.widget.ListView.d)) {
            ((com.baidu.adp.widget.ListView.d) this.aUv.getAdapter()).notifyDataSetChanged();
        }
    }

    public void setFromCDN(boolean z) {
        if (this.dij != null) {
            this.dij.setFromCDN(z);
        }
        if (this.dim != null) {
            this.dim.setFromCDN(z);
        }
        if (this.dii != null && (this.dii instanceof com.baidu.tieba.recapp.n)) {
            ((com.baidu.tieba.recapp.n) this.dii).setIsFromCDN(z);
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.dij != null) {
            this.dij.aPy = bdUniqueId;
        }
        if (this.dik != null) {
            this.dik.aPy = bdUniqueId;
        }
        if (this.dil != null) {
            this.dil.aPy = bdUniqueId;
        }
        if (this.diq != null) {
            this.diq.aPy = bdUniqueId;
        }
        if (this.dig != null) {
            this.dig.setPageUniqueId(bdUniqueId);
        }
        if (this.dim != null) {
            this.dim.aPy = bdUniqueId;
        }
        if (this.din != null) {
            this.din.aPy = bdUniqueId;
        }
        if (this.dio != null) {
            this.dio.aPy = bdUniqueId;
        }
        if (this.dip != null) {
            this.dip.aPy = bdUniqueId;
        }
        if (!v.v(this.cDL)) {
            for (com.baidu.adp.widget.ListView.a aVar : this.cDL) {
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
        if (!this.dis) {
            this.cDV.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.cDV);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void S(Object obj) {
        boolean z;
        boolean z2 = false;
        if (this.dif != null) {
            Iterator<com.baidu.adp.widget.ListView.f> it = this.dif.iterator();
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

    private void alw() {
        this.dis = alx();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean alx() {
        if (this.cDL == null || this.cDL.size() <= 0) {
            this.cDL = new ArrayList();
            ArrayList<BdUniqueId> btR = o.btR();
            if (btR == null || btR.size() <= 0) {
                return false;
            }
            int size = btR.size();
            for (int i = 0; i < size; i++) {
                com.baidu.tieba.lego.card.a.a a = com.baidu.tieba.lego.d.b.aHt().a(this.mPageContext, btR.get(i), 2);
                if (this.dir) {
                    a.setBusinessType(3);
                }
                if (this.dij != null && this.dij.aPy != null) {
                    a.setUniqueId(this.dij.aPy);
                }
                this.cDL.add(a);
            }
            this.aUv.addAdapters(this.cDL);
            return true;
        }
        return true;
    }

    public void a(c.a aVar) {
        if (this.dij != null) {
            this.dij.setEventCallback(aVar);
        }
        if (this.dik != null) {
            this.dik.setEventCallback(aVar);
        }
        if (this.diq != null) {
            this.diq.setEventCallback(aVar);
        }
        if (this.dil != null) {
            this.dil.setEventCallback(aVar);
        }
        if (this.dip != null) {
            this.dip.setEventCallback(aVar);
        }
    }
}
