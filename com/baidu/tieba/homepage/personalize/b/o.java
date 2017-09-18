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
    private BdTypeListView aTw;
    private List<com.baidu.adp.widget.ListView.a> cvr;
    private com.baidu.adp.widget.ListView.a cyX;
    private List<com.baidu.adp.widget.ListView.f> ddN;
    private a ddO;
    private n ddP;
    private com.baidu.adp.widget.ListView.a ddQ;
    private h ddR;
    private g ddS;
    private j ddT;
    private e ddU;
    private f ddV;
    private i ddW;
    private com.baidu.tieba.homepage.alalivelist.a.c ddX;
    private com.baidu.tieba.homepage.alalivelist.a.d ddY;
    private c ddZ;
    private b dea;
    private boolean deb;
    private boolean dec;
    private TbPageContext<?> mF;
    private CustomMessageListener cvz = new CustomMessageListener(CmdConfigCustom.CMD_LEGO_REGISTER) { // from class: com.baidu.tieba.homepage.personalize.b.o.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                o.this.aiY();
                if (o.this.ddN != null) {
                    o.this.bw(o.this.ddN);
                }
            }
        }
    };
    private CustomMessageListener apK = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.homepage.personalize.b.o.2
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
                bVar.ebJ = true;
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
                bVar.ebJ = false;
                o.this.Q(bVar);
            }
        }
    };
    private List<com.baidu.adp.widget.ListView.a> cYO = new ArrayList();

    public o(Context context, BdTypeListView bdTypeListView) {
        this.aTw = bdTypeListView;
        this.mF = (TbPageContext) com.baidu.adp.base.i.Y(context);
        bv(context);
        bdTypeListView.addAdapters(this.cYO);
    }

    private void bv(Context context) {
        this.ddO = new a(this.mF);
        this.ddP = new n(this.mF);
        this.cyX = r.bho().c(this.mF, AdvertAppInfo.TG);
        this.ddQ = r.bho().c(this.mF, AdvertAppInfo.TJ);
        this.ddR = new h(this.mF, com.baidu.tieba.card.data.l.TYPE);
        this.ddS = new g(this.mF, com.baidu.tieba.card.data.l.Yi);
        this.ddT = new j(this.mF, com.baidu.tieba.card.data.n.bOg);
        this.dea = new b(this.mF, com.baidu.tieba.card.data.m.TYPE);
        this.ddU = new e(this.mF, com.baidu.tieba.card.data.l.bNZ);
        this.ddV = new f(this.mF, com.baidu.tieba.card.data.n.bOh);
        this.ddW = new i(this.mF);
        this.ddX = new com.baidu.tieba.homepage.alalivelist.a.c(this.mF, com.baidu.tieba.homepage.alalivelist.view.b.TYPE);
        this.ddY = new com.baidu.tieba.homepage.alalivelist.a.d(this.mF, com.baidu.tieba.homepage.alalivelist.view.d.TYPE);
        this.ddZ = new c(this.mF, com.baidu.tieba.card.data.k.TYPE);
        this.cYO.add(this.ddO);
        this.cYO.add(this.ddP);
        this.cYO.add(this.cyX);
        this.cYO.add(this.ddQ);
        this.cYO.add(this.ddT);
        this.cYO.add(this.ddR);
        this.cYO.add(this.ddS);
        this.cYO.add(this.dea);
        this.cYO.add(this.ddU);
        this.cYO.add(this.ddV);
        this.cYO.add(new m(this.mF.getPageActivity()));
        this.cYO.add(new l(this.mF.getPageActivity()));
        this.cYO.add(this.ddW);
        this.cYO.add(new com.baidu.tieba.homepage.personalize.c.b(this.mF, com.baidu.tieba.homepage.personalize.c.c.TYPE));
        this.cYO.add(this.ddX);
        this.cYO.add(this.ddY);
        this.cYO.add(new com.baidu.tieba.homepage.alalivelist.a.a(this.mF, com.baidu.tieba.homepage.alalivelist.a.b.cYs));
        this.cYO.add(this.ddZ);
        aiX();
    }

    public void b(com.baidu.tieba.homepage.personalize.model.e eVar) {
        this.ddR.a(eVar);
        this.ddT.a(eVar);
        this.ddU.a(eVar);
        this.ddV.a(eVar);
    }

    public void bw(List<com.baidu.adp.widget.ListView.f> list) {
        com.baidu.tieba.tbadkCore.n.p(list, 2);
        this.aTw.setData(list);
        this.ddN = list;
    }

    public void onChangeSkinType(int i) {
        notifyDataSetChanged();
        this.ddO.onChangeSkinType(i);
        this.ddW.ll(i);
    }

    public void notifyDataSetChanged() {
        if (this.aTw != null && (this.aTw.getAdapter() instanceof com.baidu.adp.widget.ListView.d)) {
            ((com.baidu.adp.widget.ListView.d) this.aTw.getAdapter()).notifyDataSetChanged();
        }
    }

    public void setFromCDN(boolean z) {
        if (this.ddR != null) {
            this.ddR.setFromCDN(z);
        }
        if (this.ddU != null) {
            this.ddU.setFromCDN(z);
        }
        if (this.ddQ != null && (this.ddQ instanceof com.baidu.tieba.recapp.n)) {
            ((com.baidu.tieba.recapp.n) this.ddQ).setIsFromCDN(z);
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.ddR != null) {
            this.ddR.aOu = bdUniqueId;
        }
        if (this.ddS != null) {
            this.ddS.aOu = bdUniqueId;
        }
        if (this.ddT != null) {
            this.ddT.aOu = bdUniqueId;
        }
        if (this.dea != null) {
            this.dea.aOu = bdUniqueId;
        }
        if (this.ddO != null) {
            this.ddO.setPageUniqueId(bdUniqueId);
        }
        if (this.ddU != null) {
            this.ddU.aOu = bdUniqueId;
        }
        if (this.ddV != null) {
            this.ddV.aOu = bdUniqueId;
        }
        if (this.ddW != null) {
            this.ddW.aOu = bdUniqueId;
        }
        if (this.ddX != null) {
            this.ddX.aOu = bdUniqueId;
        }
        if (this.ddY != null) {
            this.ddY.aOu = bdUniqueId;
        }
        if (this.ddZ != null) {
            this.ddZ.aOu = bdUniqueId;
        }
        if (!v.v(this.cvr)) {
            for (com.baidu.adp.widget.ListView.a aVar : this.cvr) {
                if (aVar instanceof com.baidu.tieba.lego.card.a.a) {
                    ((com.baidu.tieba.lego.card.a.a) aVar).setUniqueId(bdUniqueId);
                }
            }
        }
        this.apK.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.apK);
        this.mLikeForumListener.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.mLikeForumListener);
        this.mUnlikeForumListener.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.mUnlikeForumListener);
        if (!this.dec) {
            this.cvz.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.cvz);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Q(Object obj) {
        boolean z;
        boolean z2 = false;
        if (this.ddN != null) {
            Iterator<com.baidu.adp.widget.ListView.f> it = this.ddN.iterator();
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

    private void aiX() {
        this.dec = aiY();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aiY() {
        if (this.cvr == null || this.cvr.size() <= 0) {
            this.cvr = new ArrayList();
            ArrayList<BdUniqueId> brJ = com.baidu.tieba.tbadkCore.n.brJ();
            if (brJ == null || brJ.size() <= 0) {
                return false;
            }
            int size = brJ.size();
            for (int i = 0; i < size; i++) {
                com.baidu.tieba.lego.card.a.a a = com.baidu.tieba.lego.d.b.aGi().a(this.mF, brJ.get(i), 2);
                if (this.deb) {
                    a.setBusinessType(3);
                }
                if (this.ddR != null && this.ddR.aOu != null) {
                    a.setUniqueId(this.ddR.aOu);
                }
                this.cvr.add(a);
            }
            this.aTw.addAdapters(this.cvr);
            return true;
        }
        return true;
    }

    public void a(h.a aVar) {
        if (this.ddR != null) {
            this.ddR.setEventCallback(aVar);
        }
        if (this.ddS != null) {
            this.ddS.setEventCallback(aVar);
        }
        if (this.dea != null) {
            this.dea.setEventCallback(aVar);
        }
        if (this.ddT != null) {
            this.ddT.setEventCallback(aVar);
        }
        if (this.ddZ != null) {
            this.ddZ.setEventCallback(aVar);
        }
    }
}
