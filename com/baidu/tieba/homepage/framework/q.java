package com.baidu.tieba.homepage.framework;

import android.util.SparseBooleanArray;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.mvc.message.MvcHttpResponsedMessage;
import com.baidu.tbadk.mvc.message.MvcNetMessage;
import com.baidu.tbadk.mvc.message.MvcSocketResponsedMessage;
import com.baidu.tbadk.performanceLog.aa;
import com.baidu.tieba.homepage.personalize.b.g;
import com.baidu.tieba.tbadkCore.w;
import com.baidu.tieba.u;
import tbclient.Personalized.DataRes;
/* loaded from: classes.dex */
public class q {
    private com.baidu.tieba.homepage.recommendfrs.a.b coA;
    private com.baidu.tieba.homepage.mygod.b coB;
    private com.baidu.tieba.homepage.personalize.b.g coC;
    private a coa;
    private final TbPageContext<BaseFragmentActivity> cox;
    private com.baidu.tieba.homepage.recommendfrs.a.a coy;
    private com.baidu.tieba.homepage.mygod.a coz;
    private final BdUniqueId uniqueId;
    private com.baidu.tieba.lego.model.a coF = null;
    private g.a coG = new r(this);
    private SparseBooleanArray coH = new SparseBooleanArray();
    private SparseBooleanArray coI = new SparseBooleanArray();
    private com.baidu.tieba.homepage.recommendfrs.data.d coD = new com.baidu.tieba.homepage.recommendfrs.data.d();
    private com.baidu.tieba.homepage.mygod.data.d coE = new com.baidu.tieba.homepage.mygod.data.d();

    /* loaded from: classes.dex */
    public interface a {
        void a(long j, String str, String str2, int i, boolean z);

        void a(long j, DataRes dataRes, boolean z);

        void a(boolean z, com.baidu.tieba.homepage.recommendfrs.data.c cVar, boolean z2, long j, String str, boolean z3);
    }

    public q(TbPageContext<BaseFragmentActivity> tbPageContext, BdUniqueId bdUniqueId) {
        this.cox = tbPageContext;
        this.uniqueId = bdUniqueId;
        this.coy = new com.baidu.tieba.homepage.recommendfrs.a.a(tbPageContext);
        this.coy.setUniqueId(bdUniqueId);
        this.coz = new com.baidu.tieba.homepage.mygod.a(tbPageContext);
        this.coz.setUniqueId(bdUniqueId);
        this.coA = new com.baidu.tieba.homepage.recommendfrs.a.b(tbPageContext, this.coD);
        this.coA.setUniqueId(bdUniqueId);
        this.coB = new com.baidu.tieba.homepage.mygod.b(tbPageContext, this.coE);
        this.coB.setUniqueId(bdUniqueId);
        this.coC = new com.baidu.tieba.homepage.personalize.b.g(tbPageContext, bdUniqueId);
        this.coC.a(this.coG);
        s sVar = new s(this);
        this.coy.a(sVar);
        this.coz.a(sVar);
        t tVar = new t(this);
        this.coA.a(tVar);
        this.coB.a(tVar);
    }

    public void a(int i, boolean z, int i2, int i3, int i4, int i5) {
        if (this.coC != null) {
            this.coC.a(i, z, i2, i3, i4, i5);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long a(MvcNetMessage<com.baidu.tbadk.mvc.b.h, com.baidu.tieba.homepage.recommendfrs.data.c> mvcNetMessage) {
        com.baidu.tieba.homepage.mygod.data.d dVar;
        if (mvcNetMessage != null) {
            if (mvcNetMessage.getRequestData() instanceof com.baidu.tieba.homepage.recommendfrs.data.d) {
                com.baidu.tieba.homepage.recommendfrs.data.d dVar2 = (com.baidu.tieba.homepage.recommendfrs.data.d) mvcNetMessage.getRequestData();
                if (dVar2 != null) {
                    return dVar2.getTagCode();
                }
            } else if ((mvcNetMessage.getRequestData() instanceof com.baidu.tieba.homepage.mygod.data.d) && (dVar = (com.baidu.tieba.homepage.mygod.data.d) mvcNetMessage.getRequestData()) != null) {
                return dVar.getTagCode();
            }
        }
        return -1L;
    }

    private int b(MvcNetMessage<com.baidu.tbadk.mvc.b.h, com.baidu.tieba.homepage.recommendfrs.data.c> mvcNetMessage) {
        if (mvcNetMessage != null) {
            if (mvcNetMessage.getRequestData() instanceof com.baidu.tieba.homepage.recommendfrs.data.d) {
                return 2;
            }
            return mvcNetMessage.getRequestData() instanceof com.baidu.tieba.homepage.mygod.data.d ? 3 : 0;
        }
        return 0;
    }

    public void a(long j, int i, long j2, String str) {
        if (i == 3) {
            this.coz.a((com.baidu.tbadk.mvc.b.e) new com.baidu.tieba.homepage.mygod.data.b(j));
        } else if (i == 2) {
            this.coy.a((com.baidu.tbadk.mvc.b.e) new com.baidu.tieba.homepage.recommendfrs.data.b(j));
        } else if (i == 5) {
            if (this.coF != null) {
                this.coF.q(j2, w.pt(str));
            } else if (this.coa != null) {
                this.coa.a(j, "", TbadkCoreApplication.m9getInst().getString(u.j.invite_friend_no_data_now), -53, false);
            }
        } else if (this.coa != null) {
            this.coa.a(j, "", TbadkCoreApplication.m9getInst().getString(u.j.invite_friend_no_data_now), -53, false);
        }
    }

    public void a(int i, long j, int i2, long j2, long j3, String str, String str2) {
        switch (i2) {
            case 3:
                if (!this.coB.DK()) {
                    this.coE.setPn(i);
                    this.coE.setTagCode(j);
                    this.coE.setRn(30);
                    if (i == 1) {
                        this.coE.bp(0L);
                    } else {
                        this.coE.bp(j2);
                    }
                    this.coB.DH();
                    return;
                }
                return;
            case 4:
            default:
                if (!this.coA.DK()) {
                    this.coD.setPn(i);
                    this.coD.setTagCode(j);
                    this.coD.bt(j2);
                    this.coA.DH();
                    return;
                }
                return;
            case 5:
                if (this.coF != null) {
                    this.coF.a(w.pv(str), j3, w.pt(str), i, str2);
                    return;
                } else if (this.coa != null) {
                    this.coa.a(j, "", TbadkCoreApplication.m9getInst().getString(u.j.invite_friend_no_data_now), -53, false);
                    return;
                } else {
                    return;
                }
        }
    }

    public BdUniqueId getUniqueId() {
        return this.uniqueId;
    }

    public TbPageContext<BaseFragmentActivity> agn() {
        return this.cox;
    }

    public void a(com.baidu.tieba.lego.model.a aVar) {
        this.coF = aVar;
    }

    public com.baidu.tieba.lego.model.a ago() {
        return this.coF;
    }

    public void a(a aVar) {
        this.coa = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(MvcSocketResponsedMessage<com.baidu.tieba.homepage.recommendfrs.data.c, ?> mvcSocketResponsedMessage, MvcNetMessage<com.baidu.tbadk.mvc.b.h, com.baidu.tieba.homepage.recommendfrs.data.c> mvcNetMessage) {
        int b = b(mvcNetMessage);
        if (!this.coI.get(b, false)) {
            this.coI.put(b, true);
            a(b, false, (ResponsedMessage<?>) mvcSocketResponsedMessage);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(MvcHttpResponsedMessage<com.baidu.tieba.homepage.recommendfrs.data.c> mvcHttpResponsedMessage, MvcNetMessage<com.baidu.tbadk.mvc.b.h, com.baidu.tieba.homepage.recommendfrs.data.c> mvcNetMessage) {
        int b = b(mvcNetMessage);
        if (!this.coI.get(b, false)) {
            this.coI.put(b, true);
            a(b, true, (ResponsedMessage<?>) mvcHttpResponsedMessage);
        }
    }

    public void a(int i, boolean z, ResponsedMessage<?> responsedMessage) {
        if (aa.EW().EX()) {
            long jj = com.baidu.tieba.homepage.framework.a.agi().jj(i);
            long ji = com.baidu.tieba.homepage.framework.a.agi().ji(i);
            com.baidu.tieba.homepage.framework.a.agi().setCreateTime(0L);
            com.baidu.tbadk.performanceLog.n nVar = new com.baidu.tbadk.performanceLog.n(1005, z, responsedMessage, 0L, 0L, ji, false, jj);
            if (nVar != null) {
                nVar.pageType = i;
                nVar.ER();
            }
        }
    }

    public a agp() {
        return this.coa;
    }
}
