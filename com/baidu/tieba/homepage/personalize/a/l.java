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
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.coreExtra.message.UpdateAttentionMessage;
import com.baidu.tieba.NEGFeedBack.c;
import com.baidu.tieba.card.data.m;
import com.baidu.tieba.card.data.n;
import com.baidu.tieba.lego.card.model.ICardInfo;
import com.baidu.tieba.recapp.q;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes2.dex */
public class l {
    private List<com.baidu.adp.widget.ListView.a> dHc;
    private com.baidu.adp.widget.ListView.a dOA;
    private BdTypeListView ebl;
    private List<com.baidu.adp.widget.ListView.i> efP;
    private a efQ;
    private j efR;
    private f efS;
    private e efT;
    private i efU;
    private g efV;
    private c efW;
    private b efX;
    private h efY;
    private f efZ;
    private i ega;
    private com.baidu.adp.widget.ListView.a egb;
    private com.baidu.adp.widget.ListView.a egc;
    private com.baidu.adp.widget.ListView.a egd;
    private com.baidu.adp.widget.ListView.a ege;
    private com.baidu.adp.widget.ListView.a egf;
    private com.baidu.adp.widget.ListView.a egg;
    private boolean egh;
    private boolean egi;
    private TbPageContext<?> mPageContext;
    private CustomMessageListener dHm = new CustomMessageListener(CmdConfigCustom.CMD_LEGO_REGISTER) { // from class: com.baidu.tieba.homepage.personalize.a.l.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                l.this.awm();
                if (l.this.efP != null) {
                    l.this.am(l.this.efP);
                }
            }
        }
    };
    private CustomMessageListener mAttentionListener = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.homepage.personalize.a.l.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
            if (updateAttentionMessage != null && updateAttentionMessage.getData() != null && updateAttentionMessage.getData().apQ) {
                l.this.aW(updateAttentionMessage.getData());
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
                bVar.fav = true;
                l.this.aW(bVar);
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
                bVar.fav = false;
                l.this.aW(bVar);
            }
        }
    };
    private List<com.baidu.adp.widget.ListView.a> ebk = new ArrayList();

    public l(Context context, BdTypeListView bdTypeListView) {
        this.ebl = bdTypeListView;
        this.mPageContext = (TbPageContext) com.baidu.adp.base.i.ak(context);
        bC(context);
        bdTypeListView.addAdapters(this.ebk);
    }

    private void bC(Context context) {
        this.efQ = new a(this.mPageContext);
        this.efR = new j(this.mPageContext);
        this.efS = new f(this.mPageContext, com.baidu.tieba.card.data.l.TYPE);
        this.efT = new e(this.mPageContext, com.baidu.tieba.card.data.l.aNc);
        this.efU = new i(this.mPageContext, n.cXD);
        this.efX = new b(this.mPageContext, m.TYPE);
        this.efV = new g(this.mPageContext);
        this.efW = new c(this.mPageContext, com.baidu.tieba.card.data.k.TYPE);
        this.efY = new h(this.mPageContext, com.baidu.tieba.card.data.l.aNi);
        this.efZ = new f(this.mPageContext, com.baidu.tieba.card.data.l.cXw);
        this.ega = new i(this.mPageContext, n.cXE);
        this.ebk.add(this.efQ);
        this.ebk.add(this.efR);
        this.ebk.add(this.efU);
        this.ebk.add(this.efS);
        this.ebk.add(this.efT);
        this.ebk.add(this.efX);
        this.ebk.add(this.efV);
        this.ebk.add(this.efZ);
        this.ebk.add(this.ega);
        this.ebk.add(new com.baidu.tieba.homepage.personalize.b.b(this.mPageContext, com.baidu.tieba.homepage.personalize.b.c.TYPE));
        this.ebk.add(this.efW);
        this.ebk.add(this.efY);
        this.ebk.add(new k(this.mPageContext, com.baidu.tieba.homepage.personalize.data.g.TYPE));
        awl();
        aBI();
    }

    private void aBI() {
        if (!bd.aNl.get()) {
            AdvertAppInfo.aJk.set(false);
            return;
        }
        this.dOA = q.bmS().c(this.mPageContext, AdvertAppInfo.aJb);
        this.egb = q.bmS().c(this.mPageContext, AdvertAppInfo.aJe);
        this.egc = q.bmS().c(this.mPageContext, AdvertAppInfo.aJf);
        this.egd = q.bmS().c(this.mPageContext, AdvertAppInfo.aJg);
        this.ege = q.bmS().c(this.mPageContext, AdvertAppInfo.aJh);
        this.egf = q.bmS().c(this.mPageContext, AdvertAppInfo.aJi);
        this.egg = q.bmS().c(this.mPageContext, AdvertAppInfo.aJj);
        this.ebk.add(this.dOA);
        this.ebk.add(this.egb);
        this.ebk.add(this.egc);
        this.ebk.add(this.egd);
        this.ebk.add(this.ege);
        this.ebk.add(this.egf);
        this.ebk.add(this.egg);
        AdvertAppInfo.aJk.set(true);
    }

    public void b(com.baidu.tieba.homepage.personalize.model.e eVar) {
        this.efS.a(eVar);
        this.efU.a(eVar);
    }

    public void am(List<com.baidu.adp.widget.ListView.i> list) {
        com.baidu.tieba.tbadkCore.q.s(list, 2);
        this.ebl.setData(list);
        this.efP = list;
    }

    public void onChangeSkinType(int i) {
        notifyDataSetChanged();
        this.efQ.onChangeSkinType(i);
        this.efV.oN(i);
    }

    public void notifyDataSetChanged() {
        if (this.ebl != null && (this.ebl.getAdapter() instanceof com.baidu.adp.widget.ListView.e)) {
            this.ebl.getAdapter().notifyDataSetChanged();
        }
    }

    public void setFromCDN(boolean z) {
        if (this.efS != null) {
            this.efS.setFromCDN(z);
        }
        if (this.egb != null && (this.egb instanceof com.baidu.tieba.recapp.n)) {
            ((com.baidu.tieba.recapp.n) this.egb).setIsFromCDN(z);
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.efS != null) {
            this.efS.bGE = bdUniqueId;
        }
        if (this.efT != null) {
            this.efT.bGE = bdUniqueId;
        }
        if (this.efU != null) {
            this.efU.bGE = bdUniqueId;
        }
        if (this.efX != null) {
            this.efX.bGE = bdUniqueId;
        }
        if (this.efQ != null) {
            this.efQ.setPageUniqueId(bdUniqueId);
        }
        if (this.efV != null) {
            this.efV.bGE = bdUniqueId;
        }
        if (this.efW != null) {
            this.efW.bGE = bdUniqueId;
        }
        if (this.efY != null) {
            this.efY.bGE = bdUniqueId;
        }
        if (this.efZ != null) {
            this.efZ.bGE = bdUniqueId;
        }
        if (this.ega != null) {
            this.ega.bGE = bdUniqueId;
        }
        if (!v.E(this.dHc)) {
            for (com.baidu.adp.widget.ListView.a aVar : this.dHc) {
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
        if (!this.egi) {
            this.dHm.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.dHm);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aW(Object obj) {
        boolean z;
        boolean z2 = false;
        if (this.efP != null) {
            Iterator<com.baidu.adp.widget.ListView.i> it = this.efP.iterator();
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

    private void awl() {
        this.egi = awm();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean awm() {
        if (this.dHc == null || this.dHc.size() <= 0) {
            this.dHc = new ArrayList();
            ArrayList<BdUniqueId> buT = com.baidu.tieba.tbadkCore.q.buT();
            if (buT == null || buT.size() <= 0) {
                return false;
            }
            int size = buT.size();
            for (int i = 0; i < size; i++) {
                com.baidu.tieba.lego.card.a.a a = com.baidu.tieba.lego.d.b.aPu().a(this.mPageContext, buT.get(i), 2);
                if (this.egh) {
                    a.setBusinessType(3);
                }
                if (this.efS != null && this.efS.bGE != null) {
                    a.setUniqueId(this.efS.bGE);
                }
                this.dHc.add(a);
            }
            this.ebl.addAdapters(this.dHc);
            return true;
        }
        return true;
    }

    public void a(c.a aVar) {
        if (this.efS != null) {
            this.efS.setEventCallback(aVar);
        }
        if (this.efT != null) {
            this.efT.setEventCallback(aVar);
        }
        if (this.efX != null) {
            this.efX.setEventCallback(aVar);
        }
        if (this.efU != null) {
            this.efU.setEventCallback(aVar);
        }
        if (this.efW != null) {
            this.efW.setEventCallback(aVar);
        }
        if (this.efY != null) {
            this.efY.setEventCallback(aVar);
        }
        if (this.efZ != null) {
            this.efZ.setEventCallback(aVar);
        }
        if (this.ega != null) {
            this.ega.setEventCallback(aVar);
        }
    }

    public void setCardShowType(int i) {
        this.efS.setCardShowType(i);
        this.efT.setCardShowType(i);
        this.efU.setCardShowType(i);
        this.efW.setCardShowType(i);
        this.efY.setCardShowType(i);
        this.efZ.setCardShowType(i);
        this.ega.setCardShowType(i);
    }
}
