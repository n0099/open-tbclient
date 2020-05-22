package com.baidu.tieba.homepage.personalize.a;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdRecyclerView;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.data.bk;
import com.baidu.tbadk.coreExtra.message.UpdateAttentionMessage;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.lego.card.model.ICardInfo;
import com.baidu.tieba.view.FollowUserButton;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes9.dex */
public class ab {
    private List<com.baidu.adp.widget.ListView.a> hFh;
    private com.baidu.adp.widget.ListView.t idO;
    private List<com.baidu.adp.widget.ListView.o> idP;
    private b idQ;
    private z idR;
    private d idS;
    private o idT;
    private x idU;
    private k idV;
    private l idW;
    private m idX;
    private r idY;
    private j idZ;
    private i iea;
    private h ieb;
    private y iec;
    private g ied;
    private n iee;
    private c ief;
    private v ieg;
    private u ieh;
    private w iei;
    private t iej;
    private o iek;
    private p iel;
    private q iem;
    private s ien;
    private e ieo;
    private com.baidu.adp.widget.ListView.a iep;
    private com.baidu.adp.widget.ListView.a ieq;
    private com.baidu.adp.widget.ListView.a ier;
    private com.baidu.adp.widget.ListView.a ies;
    private com.baidu.adp.widget.ListView.a iet;
    private com.baidu.adp.widget.ListView.a ieu;
    private com.baidu.adp.widget.ListView.a iev;
    private boolean iew;
    private boolean iex;
    private TbPageContext<?> mPageContext;
    private CustomMessageListener hFj = new CustomMessageListener(CmdConfigCustom.CMD_LEGO_REGISTER) { // from class: com.baidu.tieba.homepage.personalize.a.ab.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                ab.this.cgj();
                if (ab.this.idP != null) {
                    ab.this.bE(ab.this.idP);
                }
            }
        }
    };
    private CustomMessageListener dNP = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.homepage.personalize.a.ab.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
            if (updateAttentionMessage != null && updateAttentionMessage.getData() != null && updateAttentionMessage.getData().isSucc) {
                ab.this.aB(updateAttentionMessage.getData());
            }
        }
    };
    private CustomMessageListener mLikeForumListener = new CustomMessageListener(CmdConfigCustom.CMD_LIKE_FORUM) { // from class: com.baidu.tieba.homepage.personalize.a.ab.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                com.baidu.tieba.lego.c.b bVar = new com.baidu.tieba.lego.c.b();
                bVar.fid = String.valueOf(customResponsedMessage.getData());
                bVar.dEi = true;
                ab.this.aB(bVar);
            }
        }
    };
    private CustomMessageListener mUnlikeForumListener = new CustomMessageListener(CmdConfigCustom.CMD_UNLIKE_FORUM) { // from class: com.baidu.tieba.homepage.personalize.a.ab.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                com.baidu.tieba.lego.c.b bVar = new com.baidu.tieba.lego.c.b();
                bVar.fid = String.valueOf(customResponsedMessage.getData());
                bVar.dEi = false;
                ab.this.aB(bVar);
            }
        }
    };
    private CustomMessageListener gDZ = new CustomMessageListener(2921394) { // from class: com.baidu.tieba.homepage.personalize.a.ab.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            com.baidu.afd.videopaster.data.b Fm;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (!StringUtils.isNull(str, true) && (Fm = ab.this.Fm(str)) != null) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921395, Fm));
                }
            }
        }
    };
    private List<com.baidu.adp.widget.ListView.a> hWo = new ArrayList();

    public ab(Context context, com.baidu.adp.widget.ListView.t tVar) {
        this.idO = tVar;
        this.mPageContext = (TbPageContext) com.baidu.adp.base.i.G(context);
        eK(context);
        a(tVar);
        tVar.addAdapters(this.hWo);
    }

    private void eK(Context context) {
        this.idQ = new b(this.mPageContext);
        this.idR = new z(this.mPageContext);
        this.idS = new d(this.mPageContext, com.baidu.tieba.homepage.personalize.data.f.ieX);
        this.idT = new o(this.mPageContext, com.baidu.tieba.card.data.k.TYPE);
        this.idU = new x(this.mPageContext, com.baidu.tieba.card.data.k.gHu);
        this.idV = new k(this.mPageContext, com.baidu.tieba.card.data.k.gHB);
        this.idW = new l(this.mPageContext, com.baidu.tieba.card.data.k.gHv);
        this.idX = new m(this.mPageContext, com.baidu.tieba.card.data.k.gHC);
        this.idY = new r(this.mPageContext, com.baidu.tieba.card.data.k.gHA);
        this.idZ = new j(this.mPageContext, com.baidu.tieba.card.data.k.gHw);
        this.iea = new i(this.mPageContext, com.baidu.tieba.card.data.k.gHx);
        this.ieb = new h(this.mPageContext, com.baidu.tieba.card.data.k.gHy);
        this.iec = new y(this.mPageContext, com.baidu.tieba.card.data.l.dEV);
        this.iee = new n(this.mPageContext, com.baidu.tieba.card.data.k.dET);
        this.ief = new c(this.mPageContext, com.baidu.tieba.card.data.j.TYPE);
        this.ieg = new v(this.mPageContext, com.baidu.tieba.card.data.k.dEZ);
        this.ieh = new u(this.mPageContext, com.baidu.tieba.card.data.k.dFa);
        this.iei = new w(this.mPageContext, com.baidu.tieba.card.data.k.dFc);
        this.iej = new t(this.mPageContext, com.baidu.tieba.card.data.k.dFb);
        this.iek = new o(this.mPageContext, com.baidu.tieba.card.data.k.gHt);
        this.iel = new p(this.mPageContext, com.baidu.tieba.card.data.k.dFg);
        this.iem = new q(this.mPageContext, com.baidu.tieba.card.data.k.dFh);
        this.ien = new s(this.mPageContext, com.baidu.tieba.homepage.topic.topictab.b.a.ihJ);
        this.ieo = new e(this.mPageContext, com.baidu.tieba.card.data.e.gGW);
        this.ied = new g(this.mPageContext, com.baidu.tieba.card.data.k.gHz);
        this.hWo.add(this.idQ);
        this.hWo.add(this.idR);
        this.hWo.add(this.idS);
        this.hWo.add(this.idT);
        this.hWo.add(this.idU);
        this.hWo.add(this.idV);
        this.hWo.add(this.idW);
        this.hWo.add(this.idX);
        this.hWo.add(this.idY);
        this.hWo.add(this.idZ);
        this.hWo.add(this.iea);
        this.hWo.add(this.ieb);
        this.hWo.add(this.iec);
        this.hWo.add(this.iee);
        this.hWo.add(this.iek);
        this.hWo.add(new com.baidu.tieba.homepage.personalize.b.b(this.mPageContext, com.baidu.tieba.homepage.personalize.b.c.TYPE));
        this.hWo.add(this.ief);
        this.hWo.add(this.ieg);
        this.hWo.add(this.ieh);
        this.hWo.add(this.iej);
        this.hWo.add(this.iei);
        this.hWo.add(new aa(this.mPageContext, com.baidu.tieba.homepage.personalize.data.g.TYPE));
        this.hWo.add(this.iel);
        this.hWo.add(this.iem);
        this.hWo.add(this.ien);
        this.hWo.add(this.ieo);
        this.hWo.add(this.ied);
        cgi();
        cgh();
        zL("page_recommend");
    }

    private void cgh() {
        if (!bk.dFk.get()) {
            AdvertAppInfo.dAs.set(false);
            return;
        }
        this.iep = com.baidu.tieba.recapp.q.cUm().c(this.mPageContext, AdvertAppInfo.dAj);
        this.ieq = com.baidu.tieba.recapp.q.cUm().c(this.mPageContext, AdvertAppInfo.dAm);
        this.ier = com.baidu.tieba.recapp.q.cUm().c(this.mPageContext, AdvertAppInfo.dAn);
        this.ies = com.baidu.tieba.recapp.q.cUm().c(this.mPageContext, AdvertAppInfo.dAo);
        this.iet = com.baidu.tieba.recapp.q.cUm().c(this.mPageContext, AdvertAppInfo.dAp);
        this.ieu = com.baidu.tieba.recapp.q.cUm().c(this.mPageContext, AdvertAppInfo.dAr);
        this.iev = com.baidu.tieba.recapp.q.cUm().c(this.mPageContext, AdvertAppInfo.dAq);
        this.hWo.add(this.iep);
        this.hWo.add(this.ieq);
        this.hWo.add(this.ier);
        this.hWo.add(this.ies);
        this.hWo.add(this.iet);
        this.hWo.add(this.ieu);
        this.hWo.add(this.iev);
        AdvertAppInfo.dAs.set(true);
    }

    public void b(com.baidu.tieba.homepage.personalize.model.e eVar) {
        this.idT.a(eVar);
        this.idU.a(eVar);
        this.idV.a(eVar);
        this.idX.a(eVar);
        this.idY.a(eVar);
        this.idZ.a(eVar);
        this.iea.a(eVar);
        this.ieb.a(eVar);
        this.iec.a(eVar);
        this.ied.a(eVar);
    }

    private void a(com.baidu.adp.widget.ListView.t tVar) {
        this.idU.a(tVar);
        this.idV.a(tVar);
        this.idW.a(tVar);
        this.idX.a(tVar);
        this.idY.a(tVar);
        this.idZ.a(tVar);
        this.iea.a(tVar);
        this.ieb.a(tVar);
        this.ied.a(tVar);
        this.iec.a(tVar);
        this.ieo.a(tVar);
        this.ieh.a(tVar);
        this.ieh.a(tVar);
        this.iej.a(tVar);
    }

    public void k(List<com.baidu.adp.widget.ListView.o> list, int i) {
        com.baidu.tieba.tbadkCore.t.s(list, 2);
        ViewGroup listView = this.idO.getListView();
        if (i > 0 && (listView instanceof BdRecyclerView)) {
            int firstVisiblePosition = ((BdRecyclerView) listView).getFirstVisiblePosition();
            View childAt = ((BdRecyclerView) listView).getChildAt(0);
            int top2 = childAt == null ? 0 : childAt.getTop();
            RecyclerView.LayoutManager layoutManager = ((BdRecyclerView) listView).getLayoutManager();
            int i2 = firstVisiblePosition - i;
            if (layoutManager instanceof LinearLayoutManager) {
                ((BdRecyclerView) listView).oV();
                ((LinearLayoutManager) layoutManager).scrollToPositionWithOffset(i2, top2);
                ((BdRecyclerView) listView).oW();
            }
        }
        this.idO.setData(list);
        this.idP = list;
    }

    public void bE(List<com.baidu.adp.widget.ListView.o> list) {
        com.baidu.tieba.tbadkCore.t.s(list, 2);
        this.idO.setData(list);
        this.idP = list;
    }

    public void onChangeSkinType(int i) {
        notifyDataSetChanged();
        this.idQ.onChangeSkinType(i);
    }

    public void notifyDataSetChanged() {
        if (this.idO != null) {
            this.idO.getListAdapter().notifyDataSetChanged();
        }
    }

    public void setFromCDN(boolean z) {
        if (this.idT != null) {
            this.idT.setFromCDN(z);
            this.iek.setFromCDN(z);
            this.iee.setFromCDN(z);
            this.ieg.setFromCDN(z);
        }
        if (this.idX != null) {
            this.idX.setFromCDN(z);
        }
        if (this.ied != null) {
            this.ied.setFromCDN(z);
        }
        if (this.ieq != null && (this.ieq instanceof com.baidu.tieba.recapp.l)) {
            ((com.baidu.tieba.recapp.l) this.ieq).setIsFromCDN(z);
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.idS != null) {
            this.idS.setPageUniqueId(bdUniqueId);
        }
        if (this.idT != null) {
            this.idT.epM = bdUniqueId;
        }
        if (this.idU != null) {
            this.idU.epM = bdUniqueId;
        }
        if (this.idV != null) {
            this.idV.epM = bdUniqueId;
        }
        if (this.idW != null) {
            this.idW.epM = bdUniqueId;
        }
        if (this.idX != null) {
            this.idX.epM = bdUniqueId;
        }
        if (this.idY != null) {
            this.idY.epM = bdUniqueId;
        }
        if (this.idZ != null) {
            this.idZ.epM = bdUniqueId;
        }
        if (this.iea != null) {
            this.iea.epM = bdUniqueId;
        }
        if (this.ieb != null) {
            this.ieb.epM = bdUniqueId;
        }
        if (this.iee != null) {
            this.iee.epM = bdUniqueId;
        }
        if (this.iec != null) {
            this.iec.epM = bdUniqueId;
        }
        if (this.idQ != null) {
            this.idQ.setPageUniqueId(bdUniqueId);
        }
        if (this.ief != null) {
            this.ief.epM = bdUniqueId;
        }
        if (this.ieg != null) {
            this.ieg.epM = bdUniqueId;
        }
        if (this.ieh != null) {
            this.ieh.epM = bdUniqueId;
        }
        if (this.iej != null) {
            this.iej.epM = bdUniqueId;
        }
        if (this.iei != null) {
            this.iei.epM = bdUniqueId;
        }
        if (this.iek != null) {
            this.iek.epM = bdUniqueId;
        }
        if (this.iel != null) {
            this.iel.epM = bdUniqueId;
        }
        if (this.iem != null) {
            this.iem.epM = bdUniqueId;
        }
        if (this.ien != null) {
            this.ien.epM = bdUniqueId;
        }
        if (this.ieo != null) {
            this.ieo.epM = bdUniqueId;
        }
        if (this.ied != null) {
            this.ied.epM = bdUniqueId;
        }
        if (!com.baidu.tbadk.core.util.v.isEmpty(this.hFh)) {
            for (com.baidu.adp.widget.ListView.a aVar : this.hFh) {
                if (aVar instanceof com.baidu.tieba.lego.card.a.a) {
                    ((com.baidu.tieba.lego.card.a.a) aVar).setUniqueId(bdUniqueId);
                }
            }
        }
        this.dNP.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.dNP);
        this.mLikeForumListener.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.mLikeForumListener);
        this.mUnlikeForumListener.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.mUnlikeForumListener);
        this.gDZ.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.gDZ);
        if (!this.iex) {
            this.hFj.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.hFj);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aB(Object obj) {
        boolean z;
        boolean z2 = false;
        if (this.idP != null) {
            Iterator<com.baidu.adp.widget.ListView.o> it = this.idP.iterator();
            while (true) {
                z = z2;
                if (!it.hasNext()) {
                    break;
                }
                com.baidu.adp.widget.ListView.o next = it.next();
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

    private void cgi() {
        this.iex = cgj();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean cgj() {
        if (this.hFh == null || this.hFh.size() <= 0) {
            this.hFh = new ArrayList();
            ArrayList<BdUniqueId> dcL = com.baidu.tieba.tbadkCore.t.dcL();
            if (dcL == null || dcL.size() <= 0) {
                return false;
            }
            int size = dcL.size();
            for (int i = 0; i < size; i++) {
                com.baidu.tieba.lego.card.a.a a = com.baidu.tieba.lego.d.b.cuF().a(this.mPageContext, dcL.get(i), 2);
                if (this.iew) {
                    a.setBusinessType(3);
                }
                if (this.idT != null && this.idT.epM != null) {
                    a.setUniqueId(this.idT.epM);
                }
                this.hFh.add(a);
            }
            this.idO.addAdapters(this.hFh);
            return true;
        }
        return true;
    }

    public void a(FollowUserButton.a aVar) {
        for (com.baidu.adp.widget.ListView.a aVar2 : this.hWo) {
            if (aVar2 instanceof com.baidu.tieba.homepage.a) {
                ((com.baidu.tieba.homepage.a) aVar2).a(aVar);
            }
        }
    }

    public void b(NEGFeedBackView.a aVar) {
        if (this.idT != null) {
            this.idT.setEventCallback(aVar);
        }
        if (this.idY != null) {
            this.idY.setEventCallback(aVar);
        }
        if (this.idW != null) {
            this.idW.setEventCallback(aVar);
        }
        if (this.iee != null) {
            this.iee.setEventCallback(aVar);
        }
        if (this.ief != null) {
            this.ief.setEventCallback(aVar);
        }
        if (this.ieg != null) {
            this.ieg.setEventCallback(aVar);
        }
        if (this.ieh != null) {
            this.ieh.setEventCallback(aVar);
        }
        if (this.iej != null) {
            this.iej.setEventCallback(aVar);
        }
        if (this.iei != null) {
            this.iei.setEventCallback(aVar);
        }
        if (this.iek != null) {
            this.iek.setEventCallback(aVar);
        }
        if (this.iel != null) {
            this.iel.setEventCallback(aVar);
        }
        if (this.iem != null) {
            this.iem.setEventCallback(aVar);
        }
        if (this.ien != null) {
            this.ien.setEventCallback(aVar);
        }
        if (this.ieo != null) {
            this.ieo.setEventCallback(aVar);
        }
    }

    private void zL(String str) {
        if (this.hWo != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.hWo) {
                if (aVar instanceof com.baidu.tieba.a.f) {
                    ((com.baidu.tieba.a.f) aVar).zL(str);
                }
            }
        }
    }

    private boolean g(com.baidu.adp.widget.ListView.o oVar) {
        AdvertAppInfo advertAppInfo;
        return oVar != null && (oVar instanceof com.baidu.tieba.homepage.personalize.data.a) && (advertAppInfo = ((com.baidu.tieba.homepage.personalize.data.a) oVar).gGV) != null && advertAppInfo.aOy() == 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.baidu.afd.videopaster.data.b Fm(String str) {
        int i;
        int i2;
        com.baidu.tieba.card.data.l lVar;
        int i3 = 0;
        if (this.idP == null || this.idP.isEmpty() || str == null) {
            return null;
        }
        com.baidu.afd.videopaster.data.b bVar = new com.baidu.afd.videopaster.data.b();
        int i4 = 0;
        int i5 = 0;
        boolean z = false;
        int i6 = -1;
        int i7 = -1;
        while (true) {
            if (i4 >= this.idP.size()) {
                i = i3;
                i2 = -1;
                break;
            }
            i = this.idP.get(i4) instanceof com.baidu.tieba.homepage.personalize.data.g ? i3 + 1 : i3;
            if (this.idP.get(i4) instanceof com.baidu.tieba.homepage.personalize.data.a) {
                if (g(this.idP.get(i4))) {
                    if (z) {
                        i2 = ((com.baidu.tieba.homepage.personalize.data.a) this.idP.get(i4)).position;
                        break;
                    }
                    i7 = ((com.baidu.tieba.homepage.personalize.data.a) this.idP.get(i4)).position;
                } else if (z) {
                    i5++;
                }
            }
            if ((this.idP.get(i4) instanceof com.baidu.tieba.card.data.l) && (lVar = (com.baidu.tieba.card.data.l) this.idP.get(i4)) != null && lVar.dEA != null && str.equals(lVar.dEA.getId())) {
                z = true;
                i6 = ((com.baidu.tieba.card.data.l) this.idP.get(i4)).position;
            }
            i4++;
            i3 = i;
        }
        if (i2 != -1 && (i2 = i2 - i5) < -1) {
            i2 = -1;
        }
        bVar.setVideoId(str);
        bVar.aM(i6 - i >= -1 ? i6 - i : -1);
        bVar.aN(i7);
        bVar.aO(i2);
        return bVar;
    }

    public void onPause() {
        if (this.iec != null) {
            this.iec.onPause();
        }
    }

    public void onResume() {
        if (this.iec != null) {
            this.iec.onResume();
        }
        notifyDataSetChanged();
    }

    public void onDestroy() {
    }

    public List<com.baidu.adp.widget.ListView.o> getDataList() {
        return this.idP;
    }
}
