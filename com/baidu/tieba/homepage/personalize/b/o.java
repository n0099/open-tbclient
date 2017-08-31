package com.baidu.tieba.homepage.personalize.b;

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
import com.baidu.tbadk.core.view.h;
import com.baidu.tbadk.coreExtra.message.UpdateAttentionMessage;
import com.baidu.tieba.lego.card.model.ICardInfo;
import com.baidu.tieba.recapp.r;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes.dex */
public class o {
    private BdTypeListView aTz;
    private List<com.baidu.adp.widget.ListView.a> cuz;
    private com.baidu.adp.widget.ListView.a cyf;
    private List<com.baidu.adp.widget.ListView.f> dcR;
    private a dcS;
    private n dcT;
    private com.baidu.adp.widget.ListView.a dcU;
    private h dcV;
    private g dcW;
    private j dcX;
    private e dcY;
    private f dcZ;
    private i dda;
    private com.baidu.tieba.homepage.alalivelist.a.c ddb;
    private com.baidu.tieba.homepage.alalivelist.a.d ddc;
    private c ddd;
    private b dde;
    private boolean ddf;
    private boolean ddg;
    private TbPageContext<?> mF;
    private CustomMessageListener cuH = new CustomMessageListener(CmdConfigCustom.CMD_LEGO_REGISTER) { // from class: com.baidu.tieba.homepage.personalize.b.o.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                o.this.aiN();
                if (o.this.dcR != null) {
                    o.this.bv(o.this.dcR);
                }
            }
        }
    };
    private CustomMessageListener apM = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.homepage.personalize.b.o.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
            if (updateAttentionMessage != null && updateAttentionMessage.getData() != null && updateAttentionMessage.getData().BW) {
                o.this.Q(updateAttentionMessage.getData());
            }
        }
    };
    private CustomMessageListener mLikeForumListener = new CustomMessageListener(CmdConfigCustom.CMD_LIKE_FORUM) { // from class: com.baidu.tieba.homepage.personalize.b.o.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                com.baidu.tieba.lego.c.b bVar = new com.baidu.tieba.lego.c.b();
                bVar.fid = String.valueOf(customResponsedMessage.getData());
                bVar.eaP = true;
                o.this.Q(bVar);
            }
        }
    };
    private CustomMessageListener mUnlikeForumListener = new CustomMessageListener(CmdConfigCustom.CMD_UNLIKE_FORUM) { // from class: com.baidu.tieba.homepage.personalize.b.o.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                com.baidu.tieba.lego.c.b bVar = new com.baidu.tieba.lego.c.b();
                bVar.fid = String.valueOf(customResponsedMessage.getData());
                bVar.eaP = false;
                o.this.Q(bVar);
            }
        }
    };
    private List<com.baidu.adp.widget.ListView.a> cXU = new ArrayList();

    public o(Context context, BdTypeListView bdTypeListView) {
        this.aTz = bdTypeListView;
        this.mF = (TbPageContext) com.baidu.adp.base.i.X(context);
        bu(context);
        bdTypeListView.addAdapters(this.cXU);
    }

    private void bu(Context context) {
        this.dcS = new a(this.mF);
        this.dcT = new n(this.mF);
        this.cyf = r.bhd().c(this.mF, AdvertAppInfo.TG);
        this.dcU = r.bhd().c(this.mF, AdvertAppInfo.TJ);
        this.dcV = new h(this.mF, com.baidu.tieba.card.data.l.TYPE);
        this.dcW = new g(this.mF, com.baidu.tieba.card.data.l.Yi);
        this.dcX = new j(this.mF, com.baidu.tieba.card.data.n.bNp);
        this.dde = new b(this.mF, com.baidu.tieba.card.data.m.TYPE);
        this.dcY = new e(this.mF, com.baidu.tieba.card.data.l.bNi);
        this.dcZ = new f(this.mF, com.baidu.tieba.card.data.n.bNq);
        this.dda = new i(this.mF);
        this.ddb = new com.baidu.tieba.homepage.alalivelist.a.c(this.mF, com.baidu.tieba.homepage.alalivelist.view.b.TYPE);
        this.ddc = new com.baidu.tieba.homepage.alalivelist.a.d(this.mF, com.baidu.tieba.homepage.alalivelist.view.d.TYPE);
        this.ddd = new c(this.mF, com.baidu.tieba.card.data.k.TYPE);
        this.cXU.add(this.dcS);
        this.cXU.add(this.dcT);
        this.cXU.add(this.cyf);
        this.cXU.add(this.dcU);
        this.cXU.add(this.dcX);
        this.cXU.add(this.dcV);
        this.cXU.add(this.dcW);
        this.cXU.add(this.dde);
        this.cXU.add(this.dcY);
        this.cXU.add(this.dcZ);
        this.cXU.add(new m(this.mF.getPageActivity()));
        this.cXU.add(new l(this.mF.getPageActivity()));
        this.cXU.add(this.dda);
        this.cXU.add(new com.baidu.tieba.homepage.personalize.c.b(this.mF, com.baidu.tieba.homepage.personalize.c.c.TYPE));
        this.cXU.add(this.ddb);
        this.cXU.add(this.ddc);
        this.cXU.add(new com.baidu.tieba.homepage.alalivelist.a.a(this.mF, com.baidu.tieba.homepage.alalivelist.a.b.cXy));
        this.cXU.add(this.ddd);
        aiM();
    }

    public void b(com.baidu.tieba.homepage.personalize.model.e eVar) {
        this.dcV.a(eVar);
        this.dcX.a(eVar);
        this.dcY.a(eVar);
        this.dcZ.a(eVar);
    }

    public void bv(List<com.baidu.adp.widget.ListView.f> list) {
        com.baidu.tieba.tbadkCore.n.p(list, 2);
        this.aTz.setData(list);
        this.dcR = list;
    }

    public void onChangeSkinType(int i) {
        notifyDataSetChanged();
        this.dcS.onChangeSkinType(i);
        this.dda.lj(i);
    }

    public void notifyDataSetChanged() {
        if (this.aTz != null && (this.aTz.getAdapter() instanceof com.baidu.adp.widget.ListView.d)) {
            ((com.baidu.adp.widget.ListView.d) this.aTz.getAdapter()).notifyDataSetChanged();
        }
    }

    public void setFromCDN(boolean z) {
        if (this.dcV != null) {
            this.dcV.setFromCDN(z);
        }
        if (this.dcY != null) {
            this.dcY.setFromCDN(z);
        }
        if (this.dcU != null && (this.dcU instanceof com.baidu.tieba.recapp.n)) {
            ((com.baidu.tieba.recapp.n) this.dcU).setIsFromCDN(z);
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.dcV != null) {
            this.dcV.aOx = bdUniqueId;
        }
        if (this.dcW != null) {
            this.dcW.aOx = bdUniqueId;
        }
        if (this.dcX != null) {
            this.dcX.aOx = bdUniqueId;
        }
        if (this.dde != null) {
            this.dde.aOx = bdUniqueId;
        }
        if (this.dcS != null) {
            this.dcS.setPageUniqueId(bdUniqueId);
        }
        if (this.dcY != null) {
            this.dcY.aOx = bdUniqueId;
        }
        if (this.dcZ != null) {
            this.dcZ.aOx = bdUniqueId;
        }
        if (this.dda != null) {
            this.dda.aOx = bdUniqueId;
        }
        if (this.ddb != null) {
            this.ddb.aOx = bdUniqueId;
        }
        if (this.ddc != null) {
            this.ddc.aOx = bdUniqueId;
        }
        if (this.ddd != null) {
            this.ddd.aOx = bdUniqueId;
        }
        if (!v.v(this.cuz)) {
            for (com.baidu.adp.widget.ListView.a aVar : this.cuz) {
                if (aVar instanceof com.baidu.tieba.lego.card.a.a) {
                    ((com.baidu.tieba.lego.card.a.a) aVar).setUniqueId(bdUniqueId);
                }
            }
        }
        this.apM.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.apM);
        this.mLikeForumListener.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.mLikeForumListener);
        this.mUnlikeForumListener.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.mUnlikeForumListener);
        if (!this.ddg) {
            this.cuH.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.cuH);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Q(Object obj) {
        boolean z;
        boolean z2 = false;
        if (this.dcR != null) {
            Iterator<com.baidu.adp.widget.ListView.f> it = this.dcR.iterator();
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

    private void aiM() {
        this.ddg = aiN();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aiN() {
        if (this.cuz == null || this.cuz.size() <= 0) {
            this.cuz = new ArrayList();
            ArrayList<BdUniqueId> bry = com.baidu.tieba.tbadkCore.n.bry();
            if (bry == null || bry.size() <= 0) {
                return false;
            }
            int size = bry.size();
            for (int i = 0; i < size; i++) {
                com.baidu.tieba.lego.card.a.a a = com.baidu.tieba.lego.d.b.aFX().a(this.mF, bry.get(i), 2);
                if (this.ddf) {
                    a.setBusinessType(3);
                }
                if (this.dcV != null && this.dcV.aOx != null) {
                    a.setUniqueId(this.dcV.aOx);
                }
                this.cuz.add(a);
            }
            this.aTz.addAdapters(this.cuz);
            return true;
        }
        return true;
    }

    public void a(h.a aVar) {
        if (this.dcV != null) {
            this.dcV.setEventCallback(aVar);
        }
        if (this.dcW != null) {
            this.dcW.setEventCallback(aVar);
        }
        if (this.dde != null) {
            this.dde.setEventCallback(aVar);
        }
        if (this.dcX != null) {
            this.dcX.setEventCallback(aVar);
        }
        if (this.ddd != null) {
            this.ddd.setEventCallback(aVar);
        }
    }
}
