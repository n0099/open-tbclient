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
import com.baidu.tbadk.core.util.u;
import com.baidu.tbadk.core.view.h;
import com.baidu.tbadk.coreExtra.message.UpdateAttentionMessage;
import com.baidu.tieba.lego.card.model.ICardInfo;
import com.baidu.tieba.recapp.r;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes.dex */
public class o {
    private BdTypeListView aTN;
    private TbPageContext<?> alI;
    private c cUA;
    private b cUB;
    private boolean cUC;
    private boolean cUD;
    private List<com.baidu.adp.widget.ListView.f> cUo;
    private a cUp;
    private n cUq;
    private com.baidu.adp.widget.ListView.a cUr;
    private h cUs;
    private g cUt;
    private j cUu;
    private e cUv;
    private f cUw;
    private i cUx;
    private com.baidu.tieba.homepage.alalivelist.a.c cUy;
    private com.baidu.tieba.homepage.alalivelist.a.d cUz;
    private List<com.baidu.adp.widget.ListView.a> cnl;
    private com.baidu.adp.widget.ListView.a cqT;
    private CustomMessageListener cnu = new CustomMessageListener(CmdConfigCustom.CMD_LEGO_REGISTER) { // from class: com.baidu.tieba.homepage.personalize.b.o.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                o.this.agM();
                if (o.this.cUo != null) {
                    o.this.bo(o.this.cUo);
                }
            }
        }
    };
    private CustomMessageListener aqg = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.homepage.personalize.b.o.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
            if (updateAttentionMessage != null && updateAttentionMessage.getData() != null && updateAttentionMessage.getData().Ea) {
                o.this.R(updateAttentionMessage.getData());
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
                bVar.dSi = true;
                o.this.R(bVar);
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
                bVar.dSi = false;
                o.this.R(bVar);
            }
        }
    };
    private List<com.baidu.adp.widget.ListView.a> cPF = new ArrayList();

    public o(Context context, BdTypeListView bdTypeListView) {
        this.aTN = bdTypeListView;
        this.alI = (TbPageContext) com.baidu.adp.base.i.aa(context);
        bm(context);
        bdTypeListView.addAdapters(this.cPF);
    }

    private void bm(Context context) {
        this.cUp = new a(this.alI);
        this.cUq = new n(this.alI);
        this.cqT = r.bhF().c(this.alI, AdvertAppInfo.UC);
        this.cUr = r.bhF().c(this.alI, AdvertAppInfo.UF);
        this.cUs = new h(this.alI, com.baidu.tieba.card.data.l.TYPE);
        this.cUt = new g(this.alI, com.baidu.tieba.card.data.l.Zb);
        this.cUu = new j(this.alI, com.baidu.tieba.card.data.n.bJN);
        this.cUB = new b(this.alI, com.baidu.tieba.card.data.m.TYPE);
        this.cUv = new e(this.alI, com.baidu.tieba.card.data.l.bJG);
        this.cUw = new f(this.alI, com.baidu.tieba.card.data.n.bJO);
        this.cUx = new i(this.alI);
        this.cUy = new com.baidu.tieba.homepage.alalivelist.a.c(this.alI, com.baidu.tieba.homepage.alalivelist.view.b.TYPE);
        this.cUz = new com.baidu.tieba.homepage.alalivelist.a.d(this.alI, com.baidu.tieba.homepage.alalivelist.view.d.TYPE);
        this.cUA = new c(this.alI, com.baidu.tieba.card.data.k.TYPE);
        this.cPF.add(this.cUp);
        this.cPF.add(this.cUq);
        this.cPF.add(this.cqT);
        this.cPF.add(this.cUr);
        this.cPF.add(this.cUu);
        this.cPF.add(this.cUs);
        this.cPF.add(this.cUt);
        this.cPF.add(this.cUB);
        this.cPF.add(this.cUv);
        this.cPF.add(this.cUw);
        this.cPF.add(new m(this.alI.getPageActivity()));
        this.cPF.add(new l(this.alI.getPageActivity()));
        this.cPF.add(this.cUx);
        this.cPF.add(new com.baidu.tieba.homepage.personalize.c.b(this.alI, com.baidu.tieba.homepage.personalize.c.c.TYPE));
        this.cPF.add(this.cUy);
        this.cPF.add(this.cUz);
        this.cPF.add(new com.baidu.tieba.homepage.alalivelist.a.a(this.alI, com.baidu.tieba.homepage.alalivelist.a.b.cPj));
        this.cPF.add(this.cUA);
        agL();
    }

    public void b(com.baidu.tieba.homepage.personalize.model.e eVar) {
        this.cUs.a(eVar);
        this.cUu.a(eVar);
        this.cUv.a(eVar);
        this.cUw.a(eVar);
    }

    public void bo(List<com.baidu.adp.widget.ListView.f> list) {
        com.baidu.tieba.tbadkCore.n.q(list, 2);
        this.aTN.setData(list);
        this.cUo = list;
    }

    public void onChangeSkinType(int i) {
        notifyDataSetChanged();
        this.cUp.onChangeSkinType(i);
        this.cUx.kH(i);
    }

    public void notifyDataSetChanged() {
        if (this.aTN != null && (this.aTN.getAdapter() instanceof com.baidu.adp.widget.ListView.d)) {
            ((com.baidu.adp.widget.ListView.d) this.aTN.getAdapter()).notifyDataSetChanged();
        }
    }

    public void setFromCDN(boolean z) {
        if (this.cUs != null) {
            this.cUs.setFromCDN(z);
        }
        if (this.cUv != null) {
            this.cUv.setFromCDN(z);
        }
        if (this.cUr != null && (this.cUr instanceof com.baidu.tieba.recapp.n)) {
            ((com.baidu.tieba.recapp.n) this.cUr).setIsFromCDN(z);
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.cUs != null) {
            this.cUs.aOM = bdUniqueId;
        }
        if (this.cUt != null) {
            this.cUt.aOM = bdUniqueId;
        }
        if (this.cUu != null) {
            this.cUu.aOM = bdUniqueId;
        }
        if (this.cUB != null) {
            this.cUB.aOM = bdUniqueId;
        }
        if (this.cUp != null) {
            this.cUp.setPageUniqueId(bdUniqueId);
        }
        if (this.cUv != null) {
            this.cUv.aOM = bdUniqueId;
        }
        if (this.cUw != null) {
            this.cUw.aOM = bdUniqueId;
        }
        if (this.cUx != null) {
            this.cUx.aOM = bdUniqueId;
        }
        if (this.cUy != null) {
            this.cUy.aOM = bdUniqueId;
        }
        if (this.cUz != null) {
            this.cUz.aOM = bdUniqueId;
        }
        if (this.cUA != null) {
            this.cUA.aOM = bdUniqueId;
        }
        if (!u.v(this.cnl)) {
            for (com.baidu.adp.widget.ListView.a aVar : this.cnl) {
                if (aVar instanceof com.baidu.tieba.lego.card.a.a) {
                    ((com.baidu.tieba.lego.card.a.a) aVar).setUniqueId(bdUniqueId);
                }
            }
        }
        this.aqg.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.aqg);
        this.mLikeForumListener.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.mLikeForumListener);
        this.mUnlikeForumListener.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.mUnlikeForumListener);
        if (!this.cUD) {
            this.cnu.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.cnu);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void R(Object obj) {
        boolean z;
        boolean z2 = false;
        if (this.cUo != null) {
            Iterator<com.baidu.adp.widget.ListView.f> it = this.cUo.iterator();
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

    private void agL() {
        this.cUD = agM();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean agM() {
        if (this.cnl == null || this.cnl.size() <= 0) {
            this.cnl = new ArrayList();
            ArrayList<BdUniqueId> brI = com.baidu.tieba.tbadkCore.n.brI();
            if (brI == null || brI.size() <= 0) {
                return false;
            }
            int size = brI.size();
            for (int i = 0; i < size; i++) {
                com.baidu.tieba.lego.card.a.a a = com.baidu.tieba.lego.d.b.aDI().a(this.alI, brI.get(i), 2);
                if (this.cUC) {
                    a.setBusinessType(3);
                }
                if (this.cUs != null && this.cUs.aOM != null) {
                    a.setUniqueId(this.cUs.aOM);
                }
                this.cnl.add(a);
            }
            this.aTN.addAdapters(this.cnl);
            return true;
        }
        return true;
    }

    public void a(h.a aVar) {
        if (this.cUs != null) {
            this.cUs.setEventCallback(aVar);
        }
        if (this.cUt != null) {
            this.cUt.setEventCallback(aVar);
        }
        if (this.cUB != null) {
            this.cUB.setEventCallback(aVar);
        }
        if (this.cUu != null) {
            this.cUu.setEventCallback(aVar);
        }
        if (this.cUA != null) {
            this.cUA.setEventCallback(aVar);
        }
    }
}
