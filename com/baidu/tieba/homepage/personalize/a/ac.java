package com.baidu.tieba.homepage.personalize.a;

import android.content.Context;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.lego.card.model.ICardInfo;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class ac {
    private TbPageContext<?> GM;
    private List<com.baidu.adp.widget.ListView.a> bVM;
    private com.baidu.adp.widget.ListView.a bVw;
    private BdTypeListView cFk;
    private i cGA;
    private o cGB;
    private c cGC;
    private com.baidu.tieba.homepage.mygod.a.c cGD;
    private com.baidu.tieba.homepage.mygod.a.e cGE;
    private boolean cGF;
    private List<com.baidu.adp.widget.ListView.v> cGr;
    private b cGs;
    private a cGt;
    private s cGu;
    private ab cGv;
    private com.baidu.adp.widget.ListView.a cGw;
    private k cGx;
    private q cGy;
    private e cGz;
    private CustomMessageListener bVR = new ad(this, CmdConfigCustom.CMD_LEGO_REGISTER);
    private CustomMessageListener aig = new ae(this, CmdConfigCustom.CMD_UPDATE_ATTENTION);
    private CustomMessageListener mLikeForumListener = new af(this, CmdConfigCustom.CMD_LIKE_FORUM);
    private CustomMessageListener mUnlikeForumListener = new ag(this, CmdConfigCustom.CMD_UNLIKE_FORUM);
    private List<com.baidu.adp.widget.ListView.a> cGq = new ArrayList();

    public ac(Context context, BdTypeListView bdTypeListView) {
        this.cFk = bdTypeListView;
        this.GM = (TbPageContext) com.baidu.adp.base.l.C(context);
        this.GM.registerListener(this.aig);
        this.GM.registerListener(this.mLikeForumListener);
        this.GM.registerListener(this.mUnlikeForumListener);
        aN(context);
        bdTypeListView.g(this.cGq);
    }

    public void fc(boolean z) {
        this.cGF = z;
        if (!com.baidu.tbadk.core.util.y.t(this.bVM)) {
            for (com.baidu.adp.widget.ListView.a aVar : this.bVM) {
                if (aVar instanceof com.baidu.tieba.lego.card.a.a) {
                    if (z) {
                        ((com.baidu.tieba.lego.card.a.a) aVar).setBusinessType(3);
                    } else {
                        ((com.baidu.tieba.lego.card.a.a) aVar).setBusinessType(2);
                    }
                }
            }
        }
    }

    private void aN(Context context) {
        this.cGs = new b(this.GM);
        this.cGt = new a(this.GM);
        this.cGu = new s(this.GM);
        this.cGv = new ab(this.GM);
        this.bVw = com.baidu.tieba.recapp.e.bbp().b(this.GM, com.baidu.tbadk.core.data.b.OU);
        this.cGw = com.baidu.tieba.recapp.e.bbp().b(this.GM, com.baidu.tbadk.core.data.b.OV);
        this.cGx = new k(this.GM, com.baidu.tieba.card.data.m.Ro);
        this.cGy = new q(this.GM, com.baidu.tieba.card.data.o.bbZ);
        this.cGC = new c(this.GM, com.baidu.tieba.card.data.n.Ro);
        this.cGz = new e(this.GM, com.baidu.tieba.card.data.m.bbS);
        this.cGA = new i(this.GM, com.baidu.tieba.card.data.o.bca);
        this.cGD = new com.baidu.tieba.homepage.mygod.a.c(this.GM, com.baidu.tieba.card.data.g.Ro);
        this.cGE = new com.baidu.tieba.homepage.mygod.a.e(this.GM, com.baidu.tieba.card.data.h.Ro);
        this.cGB = new o(this.GM);
        this.cGq.add(this.cGs);
        this.cGq.add(this.cGt);
        this.cGq.add(this.cGu);
        this.cGq.add(this.cGv);
        this.cGq.add(this.bVw);
        this.cGq.add(this.cGw);
        this.cGq.add(this.cGy);
        this.cGq.add(this.cGx);
        this.cGq.add(this.cGC);
        this.cGq.add(new com.baidu.tieba.homepage.mygod.a.b(this.GM.getPageActivity(), com.baidu.tieba.homepage.mygod.data.b.cEb));
        this.cGq.add(new com.baidu.tieba.homepage.mygod.a.a(this.GM, com.baidu.tieba.homepage.mygod.data.a.cDW));
        this.cGq.add(this.cGD);
        this.cGq.add(this.cGE);
        this.cGq.add(this.cGz);
        this.cGq.add(this.cGA);
        this.cGq.add(new x(this.GM.getPageActivity()));
        this.cGq.add(new u(this.GM.getPageActivity()));
        this.cGq.add(this.cGB);
        this.cGq.add(new com.baidu.tieba.homepage.personalize.c.c(this.GM, com.baidu.tieba.homepage.personalize.c.e.Ro));
        acV();
    }

    public void b(com.baidu.tieba.homepage.personalize.b.f fVar) {
        this.cGx.a(fVar);
        this.cGy.a(fVar);
        this.cGz.a(fVar);
        this.cGA.a(fVar);
    }

    public void bv(List<com.baidu.adp.widget.ListView.v> list) {
        com.baidu.tieba.tbadkCore.v.r(list, 2);
        this.cFk.setData(list);
        this.cGr = list;
    }

    public void onChangeSkinType(int i) {
        notifyDataSetChanged();
        this.cGs.onChangeSkinType(i);
        this.cGt.onChangeSkinType(i);
        this.cGB.kc(i);
    }

    public void notifyDataSetChanged() {
        if (this.cFk != null && (this.cFk.getAdapter() instanceof com.baidu.adp.widget.ListView.e)) {
            ((com.baidu.adp.widget.ListView.e) this.cFk.getAdapter()).notifyDataSetChanged();
        }
    }

    public void setFromCDN(boolean z) {
        if (this.cGx != null) {
            this.cGx.setFromCDN(z);
        }
        if (this.cGz != null) {
            this.cGz.setFromCDN(z);
        }
        if (this.bVw != null && (this.bVw instanceof com.baidu.tieba.recapp.a)) {
            ((com.baidu.tieba.recapp.a) this.bVw).setIsFromCDN(z);
        }
        if (this.cGw != null && (this.cGw instanceof com.baidu.tieba.recapp.a)) {
            ((com.baidu.tieba.recapp.a) this.cGw).setIsFromCDN(z);
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.cGD != null) {
            this.cGD.aYu = bdUniqueId;
        }
        if (this.cGE != null) {
            this.cGE.aYu = bdUniqueId;
        }
        if (this.cGx != null) {
            this.cGx.aYu = bdUniqueId;
        }
        if (this.cGy != null) {
            this.cGy.aYu = bdUniqueId;
        }
        if (this.cGC != null) {
            this.cGC.aYu = bdUniqueId;
        }
        if (this.cGs != null) {
            this.cGs.setPageUniqueId(bdUniqueId);
        }
        if (this.cGt != null) {
            this.cGt.setPageUniqueId(bdUniqueId);
        }
        if (this.cGz != null) {
            this.cGz.aYu = bdUniqueId;
        }
        if (this.cGA != null) {
            this.cGA.aYu = bdUniqueId;
        }
        if (this.cGB != null) {
            this.cGB.aYu = bdUniqueId;
        }
        if (!com.baidu.tbadk.core.util.y.t(this.bVM)) {
            for (com.baidu.adp.widget.ListView.a aVar : this.bVM) {
                if (aVar instanceof com.baidu.tieba.lego.card.a.a) {
                    ((com.baidu.tieba.lego.card.a.a) aVar).setUniqueId(bdUniqueId);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void K(Object obj) {
        if (this.cGr != null) {
            boolean z = false;
            for (com.baidu.adp.widget.ListView.v vVar : this.cGr) {
                if ((vVar instanceof ICardInfo) && ((ICardInfo) vVar).responseAttention(obj)) {
                    z = true;
                }
            }
            if (z) {
                notifyDataSetChanged();
            }
        }
    }

    private void acV() {
        if (!acW() && this.GM != null) {
            this.GM.registerListener(this.bVR);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean acW() {
        if (this.bVM == null || this.bVM.size() <= 0) {
            this.bVM = new ArrayList();
            ArrayList<BdUniqueId> bih = com.baidu.tieba.tbadkCore.v.bih();
            if (bih == null || bih.size() <= 0) {
                return false;
            }
            int size = bih.size();
            for (int i = 0; i < size; i++) {
                com.baidu.tieba.lego.card.a.a a = com.baidu.tieba.lego.d.b.aCf().a(this.GM, bih.get(i), 2);
                if (this.cGF) {
                    a.setBusinessType(3);
                }
                if (this.cGx != null && this.cGx.aYu != null) {
                    a.setUniqueId(this.cGx.aYu);
                }
                this.bVM.add(a);
            }
            this.cFk.g(this.bVM);
            return true;
        }
        return true;
    }
}
