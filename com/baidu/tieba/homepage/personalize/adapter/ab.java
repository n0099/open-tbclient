package com.baidu.tieba.homepage.personalize.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdRecyclerView;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.data.bz;
import com.baidu.tbadk.coreExtra.message.UpdateAttentionMessage;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.homepage.personalize.readProgressBar.ReadProgessDelegetAdapter;
import com.baidu.tieba.lego.card.model.ICardInfo;
import com.baidu.tieba.view.FollowUserButton;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes2.dex */
public class ab {
    private com.baidu.tieba.homepage.concern.adapter.z jRT;
    private List<com.baidu.adp.widget.ListView.a> jyh;
    private com.baidu.adp.widget.ListView.s kbX;
    private List<com.baidu.adp.widget.ListView.n> kbY;
    private a kbZ;
    private s kcA;
    private c kcB;
    private com.baidu.adp.widget.ListView.a kcC;
    private com.baidu.adp.widget.ListView.a kcD;
    private com.baidu.adp.widget.ListView.a kcE;
    private com.baidu.adp.widget.ListView.a kcF;
    private com.baidu.adp.widget.ListView.a kcG;
    private com.baidu.adp.widget.ListView.a kcH;
    private com.baidu.adp.widget.ListView.a kcI;
    private boolean kcJ;
    private boolean kcK;
    private z kca;
    private b kcb;
    private n kcc;
    private x kcd;
    private h kce;
    private i kcf;
    private j kcg;
    private r kch;
    private k kci;
    private o kcj;
    private m kck;
    private g kcl;
    private f kcm;
    private e kcn;
    private y kco;
    private d kcp;
    private l kcq;
    private HomePageAlaLiveThreadAdapter kcr;
    private HomePageAlaFriendRoomAdapter kcs;
    private v kct;
    private u kcu;
    private w kcv;
    private t kcw;
    private n kcx;
    private p kcy;
    private q kcz;
    private TbPageContext<?> mPageContext;
    private CustomMessageListener jyj = new CustomMessageListener(CmdConfigCustom.CMD_LEGO_REGISTER) { // from class: com.baidu.tieba.homepage.personalize.adapter.ab.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                ab.this.cPw();
                if (ab.this.kbY != null) {
                    ab.this.cC(ab.this.kbY);
                }
            }
        }
    };
    private CustomMessageListener eYu = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.homepage.personalize.adapter.ab.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
            if (updateAttentionMessage != null && updateAttentionMessage.getData() != null && updateAttentionMessage.getData().isSucc) {
                ab.this.aM(updateAttentionMessage.getData());
            }
        }
    };
    private CustomMessageListener mLikeForumListener = new CustomMessageListener(CmdConfigCustom.CMD_LIKE_FORUM) { // from class: com.baidu.tieba.homepage.personalize.adapter.ab.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                com.baidu.tieba.lego.c.b bVar = new com.baidu.tieba.lego.c.b();
                bVar.fid = String.valueOf(customResponsedMessage.getData());
                bVar.eNy = true;
                ab.this.aM(bVar);
            }
        }
    };
    private CustomMessageListener mUnlikeForumListener = new CustomMessageListener(CmdConfigCustom.CMD_UNLIKE_FORUM) { // from class: com.baidu.tieba.homepage.personalize.adapter.ab.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                com.baidu.tieba.lego.c.b bVar = new com.baidu.tieba.lego.c.b();
                bVar.fid = String.valueOf(customResponsedMessage.getData());
                bVar.eNy = false;
                ab.this.aM(bVar);
            }
        }
    };
    private CustomMessageListener irg = new CustomMessageListener(2921394) { // from class: com.baidu.tieba.homepage.personalize.adapter.ab.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            com.baidu.afd.videopaster.data.b KA;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (!StringUtils.isNull(str, true) && (KA = ab.this.KA(str)) != null) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921395, KA));
                }
            }
        }
    };
    private List<com.baidu.adp.widget.ListView.a> jRp = new ArrayList();

    public ab(Context context, com.baidu.adp.widget.ListView.s sVar) {
        this.kbX = sVar;
        this.mPageContext = (TbPageContext) com.baidu.adp.base.j.K(context);
        gl(context);
        a(sVar);
        sVar.addAdapters(this.jRp);
    }

    private void gl(Context context) {
        this.kbZ = new a(this.mPageContext);
        this.kca = new z(this.mPageContext);
        this.kcb = new b(this.mPageContext, com.baidu.tieba.homepage.personalize.data.f.kdk);
        this.kcc = new n(this.mPageContext, com.baidu.tieba.card.data.k.TYPE);
        this.kcd = new x(this.mPageContext, com.baidu.tieba.card.data.k.ivd);
        this.kce = new h(this.mPageContext, com.baidu.tieba.card.data.k.ivj);
        this.kcf = new i(this.mPageContext, com.baidu.tieba.card.data.k.eOf);
        this.kcg = new j(this.mPageContext, com.baidu.tieba.card.data.k.ivk);
        this.kch = new r(this.mPageContext, com.baidu.tieba.card.data.k.ivi);
        this.kci = new k(this.mPageContext, com.baidu.tieba.card.data.k.eOr);
        this.kcj = new o(this.mPageContext, com.baidu.tieba.card.data.k.eOt);
        this.kck = new m(this.mPageContext, com.baidu.tieba.card.data.k.eOu);
        this.kcl = new g(this.mPageContext, com.baidu.tieba.card.data.k.ive);
        this.kcm = new f(this.mPageContext, com.baidu.tieba.card.data.k.ivf);
        this.kcn = new e(this.mPageContext, com.baidu.tieba.card.data.k.ivg);
        this.kco = new y(this.mPageContext, com.baidu.tieba.card.data.l.eOy);
        this.kcq = new l(this.mPageContext, com.baidu.tieba.card.data.k.eOw);
        this.kcr = new HomePageAlaLiveThreadAdapter(this.mPageContext, com.baidu.tieba.card.data.j.TYPE);
        this.kcs = new HomePageAlaFriendRoomAdapter(this.mPageContext, com.baidu.tieba.card.data.j.iuJ);
        this.kct = new v(this.mPageContext, com.baidu.tieba.card.data.k.eOD);
        this.kcu = new u(this.mPageContext, com.baidu.tieba.card.data.k.eOE);
        this.kcv = new w(this.mPageContext, com.baidu.tieba.card.data.k.eOG);
        this.kcw = new t(this.mPageContext, com.baidu.tieba.card.data.k.eOF);
        this.kcx = new n(this.mPageContext, com.baidu.tieba.card.data.k.ivb);
        this.kcy = new p(this.mPageContext, com.baidu.tieba.card.data.k.eOK);
        this.kcz = new q(this.mPageContext, com.baidu.tieba.card.data.k.eOL);
        this.kcA = new s(this.mPageContext, com.baidu.tieba.homepage.topic.topictab.b.a.khI);
        this.kcB = new c(this.mPageContext, com.baidu.tieba.card.data.e.iuE);
        this.kcp = new d(this.mPageContext, com.baidu.tieba.card.data.k.ivh);
        this.jRT = new com.baidu.tieba.homepage.concern.adapter.z(this.mPageContext, com.baidu.tieba.card.data.k.ivc, (byte) 3);
        this.jRp.add(this.kbZ);
        this.jRp.add(this.kca);
        this.jRp.add(this.kcb);
        this.jRp.add(this.kcc);
        this.jRp.add(this.kcd);
        this.jRp.add(this.kce);
        this.jRp.add(this.kcf);
        this.jRp.add(this.kcg);
        this.jRp.add(this.kch);
        this.jRp.add(this.kci);
        this.jRp.add(this.kcj);
        this.jRp.add(this.kck);
        this.jRp.add(this.kcl);
        this.jRp.add(this.kcm);
        this.jRp.add(this.kcn);
        this.jRp.add(this.kco);
        this.jRp.add(this.kcq);
        this.jRp.add(this.kcx);
        this.jRp.add(new ReadProgessDelegetAdapter(this.mPageContext, com.baidu.tieba.homepage.personalize.readProgressBar.b.TYPE));
        this.jRp.add(this.kcr);
        this.jRp.add(this.kcs);
        this.jRp.add(this.kct);
        this.jRp.add(this.kcu);
        this.jRp.add(this.kcw);
        this.jRp.add(this.kcv);
        this.jRp.add(new aa(this.mPageContext, com.baidu.tieba.homepage.personalize.data.h.TYPE));
        this.jRp.add(this.kcy);
        this.jRp.add(this.kcz);
        this.jRp.add(this.kcA);
        this.jRp.add(this.kcB);
        this.jRp.add(this.kcp);
        this.jRp.add(this.jRT);
        cPv();
        cMH();
        Ea("page_recommend");
    }

    private void cMH() {
        if (!bz.eOO.get()) {
            AdvertAppInfo.eJg.set(false);
            return;
        }
        this.kcC = com.baidu.tieba.recapp.r.dBe().a(this.mPageContext, AdvertAppInfo.eIU, "INDEX");
        this.kcD = com.baidu.tieba.recapp.r.dBe().a(this.mPageContext, AdvertAppInfo.eIX, "INDEX");
        this.kcE = com.baidu.tieba.recapp.r.dBe().a(this.mPageContext, AdvertAppInfo.eJb, "INDEX");
        this.kcF = com.baidu.tieba.recapp.r.dBe().a(this.mPageContext, AdvertAppInfo.eJc, "INDEX");
        this.kcG = com.baidu.tieba.recapp.r.dBe().a(this.mPageContext, AdvertAppInfo.eJd, "INDEX");
        this.kcH = com.baidu.tieba.recapp.r.dBe().a(this.mPageContext, AdvertAppInfo.eJf, "INDEX");
        this.kcI = com.baidu.tieba.recapp.r.dBe().a(this.mPageContext, AdvertAppInfo.eJe, "INDEX");
        this.jRp.add(this.kcC);
        this.jRp.add(this.kcD);
        this.jRp.add(this.kcE);
        this.jRp.add(this.kcF);
        this.jRp.add(this.kcG);
        this.jRp.add(this.kcH);
        this.jRp.add(this.kcI);
        AdvertAppInfo.eJg.set(true);
    }

    public void b(com.baidu.tieba.homepage.personalize.model.e eVar) {
        this.kcc.a(eVar);
        this.kcd.a(eVar);
        this.kce.a(eVar);
        this.kcg.a(eVar);
        this.kch.a(eVar);
        this.kcl.a(eVar);
        this.kcm.a(eVar);
        this.kcn.a(eVar);
        this.kco.a(eVar);
        this.kcp.a(eVar);
    }

    private void a(com.baidu.adp.widget.ListView.s sVar) {
        this.kcd.a(sVar);
        this.kce.a(sVar);
        this.kcf.a(sVar);
        this.kcg.a(sVar);
        this.kch.a(sVar);
        this.kci.a(sVar);
        this.kcj.a(sVar);
        this.kck.a(sVar);
        this.kcl.a(sVar);
        this.kcm.a(sVar);
        this.kcn.a(sVar);
        this.kcp.a(sVar);
        this.kco.a(sVar);
        this.kcB.a(sVar);
        this.kcu.a(sVar);
        this.kcu.a(sVar);
        this.kcw.a(sVar);
        this.jRT.a(sVar);
    }

    public void j(List<com.baidu.adp.widget.ListView.n> list, int i) {
        com.baidu.tieba.tbadkCore.v.x(list, 2);
        ViewGroup listView = this.kbX.getListView();
        if (i > 0 && (listView instanceof BdRecyclerView)) {
            int firstVisiblePosition = ((BdRecyclerView) listView).getFirstVisiblePosition();
            View childAt = ((BdRecyclerView) listView).getChildAt(0);
            int top = childAt == null ? 0 : childAt.getTop();
            RecyclerView.LayoutManager layoutManager = ((BdRecyclerView) listView).getLayoutManager();
            int i2 = firstVisiblePosition - i;
            if (layoutManager instanceof LinearLayoutManager) {
                ((BdRecyclerView) listView).qv();
                ((LinearLayoutManager) layoutManager).scrollToPositionWithOffset(i2, top);
                ((BdRecyclerView) listView).qw();
            }
        }
        this.kbX.setData(list);
        this.kbY = list;
    }

    public void cC(List<com.baidu.adp.widget.ListView.n> list) {
        com.baidu.tieba.tbadkCore.v.x(list, 2);
        this.kbX.setData(list);
        this.kbY = list;
    }

    public void onChangeSkinType(int i) {
        notifyDataSetChanged();
        this.kbZ.onChangeSkinType(i);
    }

    public void notifyDataSetChanged() {
        if (this.kbX != null) {
            this.kbX.getListAdapter().notifyDataSetChanged();
        }
    }

    public void setFromCDN(boolean z) {
        if (this.kcc != null) {
            this.kcc.setFromCDN(z);
            this.kcx.setFromCDN(z);
            this.kcq.setFromCDN(z);
            this.kct.setFromCDN(z);
        }
        if (this.kcg != null) {
            this.kcg.setFromCDN(z);
        }
        if (this.kcp != null) {
            this.kcp.setFromCDN(z);
        }
        if (this.kcD != null && (this.kcD instanceof com.baidu.tieba.recapp.o)) {
            ((com.baidu.tieba.recapp.o) this.kcD).setIsFromCDN(z);
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.kcb != null) {
            this.kcb.setPageUniqueId(bdUniqueId);
        }
        if (this.kcc != null) {
            this.kcc.fEN = bdUniqueId;
        }
        if (this.kcd != null) {
            this.kcd.fEN = bdUniqueId;
        }
        if (this.kce != null) {
            this.kce.fEN = bdUniqueId;
        }
        if (this.kcf != null) {
            this.kcf.fEN = bdUniqueId;
        }
        if (this.kcg != null) {
            this.kcg.fEN = bdUniqueId;
        }
        if (this.kch != null) {
            this.kch.fEN = bdUniqueId;
        }
        if (this.kci != null) {
            this.kci.fEN = bdUniqueId;
        }
        if (this.kcj != null) {
            this.kcj.fEN = bdUniqueId;
        }
        if (this.kck != null) {
            this.kck.fEN = bdUniqueId;
        }
        if (this.kcl != null) {
            this.kcl.fEN = bdUniqueId;
        }
        if (this.kcm != null) {
            this.kcm.fEN = bdUniqueId;
        }
        if (this.kcn != null) {
            this.kcn.fEN = bdUniqueId;
        }
        if (this.kcq != null) {
            this.kcq.fEN = bdUniqueId;
        }
        if (this.kco != null) {
            this.kco.fEN = bdUniqueId;
        }
        if (this.kbZ != null) {
            this.kbZ.setPageUniqueId(bdUniqueId);
        }
        if (this.kcr != null) {
            this.kcr.fEN = bdUniqueId;
        }
        if (this.kcs != null) {
            this.kcs.fEN = bdUniqueId;
        }
        if (this.kct != null) {
            this.kct.fEN = bdUniqueId;
        }
        if (this.kcu != null) {
            this.kcu.fEN = bdUniqueId;
        }
        if (this.kcw != null) {
            this.kcw.fEN = bdUniqueId;
        }
        if (this.kcv != null) {
            this.kcv.fEN = bdUniqueId;
        }
        if (this.kcx != null) {
            this.kcx.fEN = bdUniqueId;
        }
        if (this.kcy != null) {
            this.kcy.fEN = bdUniqueId;
        }
        if (this.kcz != null) {
            this.kcz.fEN = bdUniqueId;
        }
        if (this.kcA != null) {
            this.kcA.fEN = bdUniqueId;
        }
        if (this.kcB != null) {
            this.kcB.fEN = bdUniqueId;
        }
        if (this.kcp != null) {
            this.kcp.fEN = bdUniqueId;
        }
        if (this.jRT != null) {
            this.jRT.fEN = bdUniqueId;
        }
        if (!com.baidu.tbadk.core.util.x.isEmpty(this.jyh)) {
            for (com.baidu.adp.widget.ListView.a aVar : this.jyh) {
                if (aVar instanceof com.baidu.tieba.lego.card.adapter.a) {
                    ((com.baidu.tieba.lego.card.adapter.a) aVar).setUniqueId(bdUniqueId);
                }
            }
        }
        this.eYu.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.eYu);
        this.mLikeForumListener.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.mLikeForumListener);
        this.mUnlikeForumListener.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.mUnlikeForumListener);
        this.irg.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.irg);
        if (!this.kcK) {
            this.jyj.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.jyj);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aM(Object obj) {
        boolean z;
        boolean z2 = false;
        if (this.kbY != null) {
            Iterator<com.baidu.adp.widget.ListView.n> it = this.kbY.iterator();
            while (true) {
                z = z2;
                if (!it.hasNext()) {
                    break;
                }
                com.baidu.adp.widget.ListView.n next = it.next();
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

    private void cPv() {
        this.kcK = cPw();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean cPw() {
        if (this.jyh == null || this.jyh.size() <= 0) {
            this.jyh = new ArrayList();
            ArrayList<BdUniqueId> dKA = com.baidu.tieba.tbadkCore.v.dKA();
            if (dKA == null || dKA.size() <= 0) {
                return false;
            }
            int size = dKA.size();
            for (int i = 0; i < size; i++) {
                com.baidu.tieba.lego.card.adapter.a a2 = com.baidu.tieba.lego.d.b.daV().a(this.mPageContext, dKA.get(i), 2);
                if (this.kcJ) {
                    a2.setBusinessType(3);
                }
                if (this.kcc != null && this.kcc.fEN != null) {
                    a2.setUniqueId(this.kcc.fEN);
                }
                this.jyh.add(a2);
            }
            this.kbX.addAdapters(this.jyh);
            return true;
        }
        return true;
    }

    public void a(FollowUserButton.a aVar) {
        for (com.baidu.adp.widget.ListView.a aVar2 : this.jRp) {
            if (aVar2 instanceof com.baidu.tieba.homepage.a) {
                ((com.baidu.tieba.homepage.a) aVar2).a(aVar);
            }
        }
    }

    public void b(NEGFeedBackView.a aVar) {
        if (this.kcc != null) {
            this.kcc.setEventCallback(aVar);
        }
        if (this.kch != null) {
            this.kch.setEventCallback(aVar);
        }
        if (this.kcf != null) {
            this.kcf.setEventCallback(aVar);
        }
        if (this.kcq != null) {
            this.kcq.setEventCallback(aVar);
        }
        if (this.kcr != null) {
            this.kcr.setEventCallback(aVar);
        }
        if (this.kcs != null) {
            this.kcs.setEventCallback(aVar);
        }
        if (this.kct != null) {
            this.kct.setEventCallback(aVar);
        }
        if (this.kcu != null) {
            this.kcu.setEventCallback(aVar);
        }
        if (this.kcw != null) {
            this.kcw.setEventCallback(aVar);
        }
        if (this.kcv != null) {
            this.kcv.setEventCallback(aVar);
        }
        if (this.kcx != null) {
            this.kcx.setEventCallback(aVar);
        }
        if (this.kcy != null) {
            this.kcy.setEventCallback(aVar);
        }
        if (this.kcz != null) {
            this.kcz.setEventCallback(aVar);
        }
        if (this.kcA != null) {
            this.kcA.setEventCallback(aVar);
        }
        if (this.kcB != null) {
            this.kcB.setEventCallback(aVar);
        }
    }

    private void Ea(String str) {
        if (this.jRp != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.jRp) {
                if (aVar instanceof com.baidu.tieba.a.f) {
                    ((com.baidu.tieba.a.f) aVar).Ea(str);
                }
            }
        }
    }

    private boolean g(com.baidu.adp.widget.ListView.n nVar) {
        AdvertAppInfo advertAppInfo;
        return nVar != null && (nVar instanceof com.baidu.tieba.homepage.personalize.data.a) && (advertAppInfo = ((com.baidu.tieba.homepage.personalize.data.a) nVar).iuD) != null && advertAppInfo.bll() == 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.baidu.afd.videopaster.data.b KA(String str) {
        int i;
        com.baidu.tieba.card.data.l lVar;
        if (this.kbY == null || this.kbY.isEmpty() || str == null) {
            return null;
        }
        com.baidu.afd.videopaster.data.b bVar = new com.baidu.afd.videopaster.data.b();
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        boolean z = false;
        int i5 = -1;
        int i6 = -1;
        while (true) {
            if (i2 >= this.kbY.size()) {
                i = -1;
                break;
            }
            if (this.kbY.get(i2) instanceof com.baidu.tieba.homepage.personalize.data.h) {
                i3++;
            }
            if (this.kbY.get(i2) instanceof com.baidu.tieba.homepage.personalize.data.a) {
                if (g(this.kbY.get(i2))) {
                    if (z) {
                        i = ((com.baidu.tieba.homepage.personalize.data.a) this.kbY.get(i2)).position;
                        break;
                    }
                    i6 = ((com.baidu.tieba.homepage.personalize.data.a) this.kbY.get(i2)).position;
                } else if (z) {
                    i4++;
                }
            }
            if ((this.kbY.get(i2) instanceof com.baidu.tieba.card.data.l) && (lVar = (com.baidu.tieba.card.data.l) this.kbY.get(i2)) != null && lVar.eHK != null && str.equals(lVar.eHK.getId())) {
                z = true;
                i5 = ((com.baidu.tieba.card.data.l) this.kbY.get(i2)).position;
            }
            i2++;
        }
        if (i != -1 && (i = i - i4) < -1) {
            i = -1;
        }
        bVar.setVideoId(str);
        bVar.bf(i5 - i3 >= -1 ? i5 - i3 : -1);
        bVar.bg(i6);
        bVar.bh(i);
        return bVar;
    }

    public void onPause() {
        if (this.kco != null) {
            this.kco.onPause();
        }
    }

    public void onResume() {
        if (this.kco != null) {
            this.kco.onResume();
        }
        notifyDataSetChanged();
    }

    public void onDestroy() {
    }

    public List<com.baidu.adp.widget.ListView.n> getDataList() {
        return this.kbY;
    }
}
