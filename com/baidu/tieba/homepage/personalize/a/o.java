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
import com.baidu.tieba.lego.card.model.ICardInfo;
import com.baidu.tieba.recapp.r;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes.dex */
public class o {
    private BdTypeListView aUv;
    private List<com.baidu.adp.widget.ListView.a> cvY;
    private com.baidu.adp.widget.ListView.a czP;
    private List<com.baidu.adp.widget.ListView.f> daa;
    private a dab;
    private n dac;
    private com.baidu.adp.widget.ListView.a dad;
    private h dae;
    private g daf;
    private j dag;
    private e dah;
    private f dai;
    private i daj;
    private com.baidu.tieba.homepage.alalivelist.a.c dak;
    private com.baidu.tieba.homepage.alalivelist.a.d dal;
    private c dam;
    private b dan;
    private boolean dao;
    private boolean dap;
    private TbPageContext<?> mG;
    private CustomMessageListener cwh = new CustomMessageListener(CmdConfigCustom.CMD_LEGO_REGISTER) { // from class: com.baidu.tieba.homepage.personalize.a.o.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                o.this.ajc();
                if (o.this.daa != null) {
                    o.this.br(o.this.daa);
                }
            }
        }
    };
    private CustomMessageListener aoT = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.homepage.personalize.a.o.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
            if (updateAttentionMessage != null && updateAttentionMessage.getData() != null && updateAttentionMessage.getData().BY) {
                o.this.P(updateAttentionMessage.getData());
            }
        }
    };
    private CustomMessageListener mLikeForumListener = new CustomMessageListener(CmdConfigCustom.CMD_LIKE_FORUM) { // from class: com.baidu.tieba.homepage.personalize.a.o.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                com.baidu.tieba.lego.c.b bVar = new com.baidu.tieba.lego.c.b();
                bVar.fid = String.valueOf(customResponsedMessage.getData());
                bVar.dXS = true;
                o.this.P(bVar);
            }
        }
    };
    private CustomMessageListener mUnlikeForumListener = new CustomMessageListener(CmdConfigCustom.CMD_UNLIKE_FORUM) { // from class: com.baidu.tieba.homepage.personalize.a.o.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                com.baidu.tieba.lego.c.b bVar = new com.baidu.tieba.lego.c.b();
                bVar.fid = String.valueOf(customResponsedMessage.getData());
                bVar.dXS = false;
                o.this.P(bVar);
            }
        }
    };
    private List<com.baidu.adp.widget.ListView.a> cVh = new ArrayList();

    public o(Context context, BdTypeListView bdTypeListView) {
        this.aUv = bdTypeListView;
        this.mG = (TbPageContext) com.baidu.adp.base.i.Y(context);
        bt(context);
        bdTypeListView.addAdapters(this.cVh);
    }

    private void bt(Context context) {
        this.dab = new a(this.mG);
        this.dac = new n(this.mG);
        this.czP = r.bfU().c(this.mG, AdvertAppInfo.TV);
        this.dad = r.bfU().c(this.mG, AdvertAppInfo.TY);
        this.dae = new h(this.mG, com.baidu.tieba.card.data.l.TYPE);
        this.daf = new g(this.mG, com.baidu.tieba.card.data.l.Yj);
        this.dag = new j(this.mG, com.baidu.tieba.card.data.n.bNL);
        this.dan = new b(this.mG, com.baidu.tieba.card.data.m.TYPE);
        this.dah = new e(this.mG, com.baidu.tieba.card.data.l.bNE);
        this.dai = new f(this.mG, com.baidu.tieba.card.data.n.bNM);
        this.daj = new i(this.mG);
        this.dak = new com.baidu.tieba.homepage.alalivelist.a.c(this.mG, com.baidu.tieba.homepage.alalivelist.view.b.TYPE);
        this.dal = new com.baidu.tieba.homepage.alalivelist.a.d(this.mG, com.baidu.tieba.homepage.alalivelist.view.d.TYPE);
        this.dam = new c(this.mG, com.baidu.tieba.card.data.k.TYPE);
        this.cVh.add(this.dab);
        this.cVh.add(this.dac);
        this.cVh.add(this.czP);
        this.cVh.add(this.dad);
        this.cVh.add(this.dag);
        this.cVh.add(this.dae);
        this.cVh.add(this.daf);
        this.cVh.add(this.dan);
        this.cVh.add(this.dah);
        this.cVh.add(this.dai);
        this.cVh.add(new m(this.mG.getPageActivity()));
        this.cVh.add(new l(this.mG.getPageActivity()));
        this.cVh.add(this.daj);
        this.cVh.add(new com.baidu.tieba.homepage.personalize.b.b(this.mG, com.baidu.tieba.homepage.personalize.b.c.TYPE));
        this.cVh.add(this.dak);
        this.cVh.add(this.dal);
        this.cVh.add(new com.baidu.tieba.homepage.alalivelist.a.a(this.mG, com.baidu.tieba.homepage.alalivelist.a.b.cUK));
        this.cVh.add(this.dam);
        ajb();
    }

    public void b(com.baidu.tieba.homepage.personalize.model.e eVar) {
        this.dae.a(eVar);
        this.dag.a(eVar);
        this.dah.a(eVar);
        this.dai.a(eVar);
    }

    public void br(List<com.baidu.adp.widget.ListView.f> list) {
        com.baidu.tieba.tbadkCore.n.p(list, 2);
        this.aUv.setData(list);
        this.daa = list;
    }

    public void onChangeSkinType(int i) {
        notifyDataSetChanged();
        this.dab.onChangeSkinType(i);
        this.daj.lg(i);
    }

    public void notifyDataSetChanged() {
        if (this.aUv != null && (this.aUv.getAdapter() instanceof com.baidu.adp.widget.ListView.d)) {
            ((com.baidu.adp.widget.ListView.d) this.aUv.getAdapter()).notifyDataSetChanged();
        }
    }

    public void setFromCDN(boolean z) {
        if (this.dae != null) {
            this.dae.setFromCDN(z);
        }
        if (this.dah != null) {
            this.dah.setFromCDN(z);
        }
        if (this.dad != null && (this.dad instanceof com.baidu.tieba.recapp.n)) {
            ((com.baidu.tieba.recapp.n) this.dad).setIsFromCDN(z);
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.dae != null) {
            this.dae.aPx = bdUniqueId;
        }
        if (this.daf != null) {
            this.daf.aPx = bdUniqueId;
        }
        if (this.dag != null) {
            this.dag.aPx = bdUniqueId;
        }
        if (this.dan != null) {
            this.dan.aPx = bdUniqueId;
        }
        if (this.dab != null) {
            this.dab.setPageUniqueId(bdUniqueId);
        }
        if (this.dah != null) {
            this.dah.aPx = bdUniqueId;
        }
        if (this.dai != null) {
            this.dai.aPx = bdUniqueId;
        }
        if (this.daj != null) {
            this.daj.aPx = bdUniqueId;
        }
        if (this.dak != null) {
            this.dak.aPx = bdUniqueId;
        }
        if (this.dal != null) {
            this.dal.aPx = bdUniqueId;
        }
        if (this.dam != null) {
            this.dam.aPx = bdUniqueId;
        }
        if (!v.u(this.cvY)) {
            for (com.baidu.adp.widget.ListView.a aVar : this.cvY) {
                if (aVar instanceof com.baidu.tieba.lego.card.a.a) {
                    ((com.baidu.tieba.lego.card.a.a) aVar).setUniqueId(bdUniqueId);
                }
            }
        }
        this.aoT.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.aoT);
        this.mLikeForumListener.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.mLikeForumListener);
        this.mUnlikeForumListener.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.mUnlikeForumListener);
        if (!this.dap) {
            this.cwh.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.cwh);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void P(Object obj) {
        boolean z;
        boolean z2 = false;
        if (this.daa != null) {
            Iterator<com.baidu.adp.widget.ListView.f> it = this.daa.iterator();
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

    private void ajb() {
        this.dap = ajc();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean ajc() {
        if (this.cvY == null || this.cvY.size() <= 0) {
            this.cvY = new ArrayList();
            ArrayList<BdUniqueId> bqH = com.baidu.tieba.tbadkCore.n.bqH();
            if (bqH == null || bqH.size() <= 0) {
                return false;
            }
            int size = bqH.size();
            for (int i = 0; i < size; i++) {
                com.baidu.tieba.lego.card.a.a a = com.baidu.tieba.lego.d.b.aEZ().a(this.mG, bqH.get(i), 2);
                if (this.dao) {
                    a.setBusinessType(3);
                }
                if (this.dae != null && this.dae.aPx != null) {
                    a.setUniqueId(this.dae.aPx);
                }
                this.cvY.add(a);
            }
            this.aUv.addAdapters(this.cvY);
            return true;
        }
        return true;
    }

    public void a(c.a aVar) {
        if (this.dae != null) {
            this.dae.setEventCallback(aVar);
        }
        if (this.daf != null) {
            this.daf.setEventCallback(aVar);
        }
        if (this.dan != null) {
            this.dan.setEventCallback(aVar);
        }
        if (this.dag != null) {
            this.dag.setEventCallback(aVar);
        }
        if (this.dam != null) {
            this.dam.setEventCallback(aVar);
        }
    }
}
