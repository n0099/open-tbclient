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
import com.baidu.tieba.homepage.personalize.c.g;
import com.baidu.tieba.r;
import tbclient.Personalized.DataRes;
/* loaded from: classes.dex */
public class q {
    private com.baidu.tieba.homepage.recommendfrs.a.b cCA;
    private com.baidu.tieba.homepage.mygod.b cCB;
    private com.baidu.tieba.homepage.personalize.c.g cCC;
    private a cCa;
    private final TbPageContext<BaseFragmentActivity> cCx;
    private com.baidu.tieba.homepage.recommendfrs.a.a cCy;
    private com.baidu.tieba.homepage.mygod.a cCz;
    private final BdUniqueId uniqueId;
    private com.baidu.tieba.lego.model.a cCF = null;
    private g.a cCG = new r(this);
    private SparseBooleanArray cCH = new SparseBooleanArray();
    private SparseBooleanArray cCI = new SparseBooleanArray();
    private com.baidu.tieba.homepage.recommendfrs.data.d cCD = new com.baidu.tieba.homepage.recommendfrs.data.d();
    private com.baidu.tieba.homepage.mygod.data.e cCE = new com.baidu.tieba.homepage.mygod.data.e();

    /* loaded from: classes.dex */
    public interface a {
        void a(long j, String str, String str2, int i, boolean z);

        void a(long j, DataRes dataRes, boolean z);

        void a(boolean z, com.baidu.tieba.homepage.recommendfrs.data.c cVar, boolean z2, long j, String str, boolean z3);
    }

    public q(TbPageContext<BaseFragmentActivity> tbPageContext, BdUniqueId bdUniqueId) {
        this.cCx = tbPageContext;
        this.uniqueId = bdUniqueId;
        this.cCy = new com.baidu.tieba.homepage.recommendfrs.a.a(tbPageContext);
        this.cCy.setUniqueId(bdUniqueId);
        this.cCz = new com.baidu.tieba.homepage.mygod.a(tbPageContext);
        this.cCz.setUniqueId(bdUniqueId);
        this.cCA = new com.baidu.tieba.homepage.recommendfrs.a.b(tbPageContext, this.cCD);
        this.cCA.setUniqueId(bdUniqueId);
        this.cCB = new com.baidu.tieba.homepage.mygod.b(tbPageContext, this.cCE);
        this.cCB.setUniqueId(bdUniqueId);
        this.cCC = new com.baidu.tieba.homepage.personalize.c.g(tbPageContext, bdUniqueId);
        this.cCC.a(this.cCG);
        s sVar = new s(this);
        this.cCy.a(sVar);
        this.cCz.a(sVar);
        t tVar = new t(this);
        this.cCA.a(tVar);
        this.cCB.a(tVar);
    }

    public void a(int i, boolean z, int i2, int i3, int i4, int i5) {
        if (this.cCC != null) {
            this.cCC.a(i, z, i2, i3, i4, i5);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long a(MvcNetMessage<com.baidu.tbadk.mvc.b.h, com.baidu.tieba.homepage.recommendfrs.data.c> mvcNetMessage) {
        com.baidu.tieba.homepage.mygod.data.e eVar;
        if (mvcNetMessage != null) {
            if (mvcNetMessage.getRequestData() instanceof com.baidu.tieba.homepage.recommendfrs.data.d) {
                com.baidu.tieba.homepage.recommendfrs.data.d dVar = (com.baidu.tieba.homepage.recommendfrs.data.d) mvcNetMessage.getRequestData();
                if (dVar != null) {
                    return dVar.getTagCode();
                }
            } else if ((mvcNetMessage.getRequestData() instanceof com.baidu.tieba.homepage.mygod.data.e) && (eVar = (com.baidu.tieba.homepage.mygod.data.e) mvcNetMessage.getRequestData()) != null) {
                return eVar.getTagCode();
            }
        }
        return -1L;
    }

    private int b(MvcNetMessage<com.baidu.tbadk.mvc.b.h, com.baidu.tieba.homepage.recommendfrs.data.c> mvcNetMessage) {
        if (mvcNetMessage != null) {
            if (mvcNetMessage.getRequestData() instanceof com.baidu.tieba.homepage.recommendfrs.data.d) {
                return 2;
            }
            return mvcNetMessage.getRequestData() instanceof com.baidu.tieba.homepage.mygod.data.e ? 3 : 0;
        }
        return 0;
    }

    public void a(long j, int i, long j2, String str) {
        if (i == 3) {
            this.cCz.a((com.baidu.tbadk.mvc.b.e) new com.baidu.tieba.homepage.mygod.data.c(j));
        } else if (i == 2) {
            this.cCy.a((com.baidu.tbadk.mvc.b.e) new com.baidu.tieba.homepage.recommendfrs.data.b(j));
        } else if (i == 5) {
            if (this.cCF != null) {
                this.cCF.t(j2, com.baidu.tieba.tbadkCore.v.rb(str));
            } else if (this.cCa != null) {
                this.cCa.a(j, "", TbadkCoreApplication.m9getInst().getString(r.j.invite_friend_no_data_now), -53, false);
            }
        } else if (this.cCa != null) {
            this.cCa.a(j, "", TbadkCoreApplication.m9getInst().getString(r.j.invite_friend_no_data_now), -53, false);
        }
    }

    public void a(int i, long j, int i2, long j2, long j3, String str, String str2) {
        switch (i2) {
            case 3:
                if (!this.cCB.wG()) {
                    this.cCE.setPn(i);
                    this.cCE.setTagCode(j);
                    this.cCE.setRn(30);
                    if (i == 1) {
                        this.cCE.bG(0L);
                    } else {
                        this.cCE.bG(j2);
                    }
                    this.cCB.Fa();
                    return;
                }
                return;
            case 4:
            default:
                if (!this.cCA.wG()) {
                    this.cCD.setPn(i);
                    this.cCD.setTagCode(j);
                    this.cCD.bK(j2);
                    this.cCA.Fa();
                    return;
                }
                return;
            case 5:
                if (this.cCF != null) {
                    this.cCF.a(com.baidu.tieba.tbadkCore.v.rd(str), j3, com.baidu.tieba.tbadkCore.v.rb(str), i, str2);
                    return;
                } else if (this.cCa != null) {
                    this.cCa.a(j, "", TbadkCoreApplication.m9getInst().getString(r.j.invite_friend_no_data_now), -53, false);
                    return;
                } else {
                    return;
                }
        }
    }

    public BdUniqueId getUniqueId() {
        return this.uniqueId;
    }

    public TbPageContext<BaseFragmentActivity> alP() {
        return this.cCx;
    }

    public void a(com.baidu.tieba.lego.model.a aVar) {
        this.cCF = aVar;
    }

    public com.baidu.tieba.lego.model.a alQ() {
        return this.cCF;
    }

    public void a(a aVar) {
        this.cCa = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(MvcSocketResponsedMessage<com.baidu.tieba.homepage.recommendfrs.data.c, ?> mvcSocketResponsedMessage, MvcNetMessage<com.baidu.tbadk.mvc.b.h, com.baidu.tieba.homepage.recommendfrs.data.c> mvcNetMessage) {
        int b = b(mvcNetMessage);
        if (!this.cCI.get(b, false)) {
            this.cCI.put(b, true);
            a(b, false, (ResponsedMessage<?>) mvcSocketResponsedMessage);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(MvcHttpResponsedMessage<com.baidu.tieba.homepage.recommendfrs.data.c> mvcHttpResponsedMessage, MvcNetMessage<com.baidu.tbadk.mvc.b.h, com.baidu.tieba.homepage.recommendfrs.data.c> mvcNetMessage) {
        int b = b(mvcNetMessage);
        if (!this.cCI.get(b, false)) {
            this.cCI.put(b, true);
            a(b, true, (ResponsedMessage<?>) mvcHttpResponsedMessage);
        }
    }

    public void a(int i, boolean z, ResponsedMessage<?> responsedMessage) {
        if (aa.Go().Gp()) {
            long jS = com.baidu.tieba.homepage.framework.a.alK().jS(i);
            long jR = com.baidu.tieba.homepage.framework.a.alK().jR(i);
            com.baidu.tieba.homepage.framework.a.alK().setCreateTime(0L);
            com.baidu.tbadk.performanceLog.n nVar = new com.baidu.tbadk.performanceLog.n(1005, z, responsedMessage, 0L, 0L, jR, false, jS);
            if (nVar != null) {
                nVar.pageType = i;
                nVar.Gj();
            }
        }
    }

    public a alR() {
        return this.cCa;
    }
}
