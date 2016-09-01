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
import com.baidu.tieba.t;
import tbclient.Personalized.DataRes;
/* loaded from: classes.dex */
public class q {
    private final TbPageContext<BaseFragmentActivity> cBS;
    private com.baidu.tieba.homepage.recommendfrs.a.a cBT;
    private com.baidu.tieba.homepage.mygod.a cBU;
    private com.baidu.tieba.homepage.recommendfrs.a.b cBV;
    private com.baidu.tieba.homepage.mygod.b cBW;
    private com.baidu.tieba.homepage.personalize.b.g cBX;
    private a cBw;
    private final BdUniqueId uniqueId;
    private com.baidu.tieba.lego.model.a cCa = null;
    private g.a cCb = new r(this);
    private SparseBooleanArray cCc = new SparseBooleanArray();
    private SparseBooleanArray cCd = new SparseBooleanArray();
    private com.baidu.tieba.homepage.recommendfrs.data.d cBY = new com.baidu.tieba.homepage.recommendfrs.data.d();
    private com.baidu.tieba.homepage.mygod.data.e cBZ = new com.baidu.tieba.homepage.mygod.data.e();

    /* loaded from: classes.dex */
    public interface a {
        void a(long j, String str, String str2, int i, boolean z);

        void a(long j, DataRes dataRes, boolean z);

        void a(boolean z, com.baidu.tieba.homepage.recommendfrs.data.c cVar, boolean z2, long j, String str, boolean z3);
    }

    public q(TbPageContext<BaseFragmentActivity> tbPageContext, BdUniqueId bdUniqueId) {
        this.cBS = tbPageContext;
        this.uniqueId = bdUniqueId;
        this.cBT = new com.baidu.tieba.homepage.recommendfrs.a.a(tbPageContext);
        this.cBT.setUniqueId(bdUniqueId);
        this.cBU = new com.baidu.tieba.homepage.mygod.a(tbPageContext);
        this.cBU.setUniqueId(bdUniqueId);
        this.cBV = new com.baidu.tieba.homepage.recommendfrs.a.b(tbPageContext, this.cBY);
        this.cBV.setUniqueId(bdUniqueId);
        this.cBW = new com.baidu.tieba.homepage.mygod.b(tbPageContext, this.cBZ);
        this.cBW.setUniqueId(bdUniqueId);
        this.cBX = new com.baidu.tieba.homepage.personalize.b.g(tbPageContext, bdUniqueId);
        this.cBX.a(this.cCb);
        s sVar = new s(this);
        this.cBT.a(sVar);
        this.cBU.a(sVar);
        t tVar = new t(this);
        this.cBV.a(tVar);
        this.cBW.a(tVar);
    }

    public void a(int i, boolean z, int i2, int i3, int i4, int i5) {
        if (this.cBX != null) {
            this.cBX.a(i, z, i2, i3, i4, i5);
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
            this.cBU.a((com.baidu.tbadk.mvc.b.e) new com.baidu.tieba.homepage.mygod.data.c(j));
        } else if (i == 2) {
            this.cBT.a((com.baidu.tbadk.mvc.b.e) new com.baidu.tieba.homepage.recommendfrs.data.b(j));
        } else if (i == 5) {
            if (this.cCa != null) {
                this.cCa.t(j2, com.baidu.tieba.tbadkCore.v.qN(str));
            } else if (this.cBw != null) {
                this.cBw.a(j, "", TbadkCoreApplication.m9getInst().getString(t.j.invite_friend_no_data_now), -53, false);
            }
        } else if (this.cBw != null) {
            this.cBw.a(j, "", TbadkCoreApplication.m9getInst().getString(t.j.invite_friend_no_data_now), -53, false);
        }
    }

    public void a(int i, long j, int i2, long j2, long j3, String str, String str2) {
        switch (i2) {
            case 3:
                if (!this.cBW.Fd()) {
                    this.cBZ.setPn(i);
                    this.cBZ.setTagCode(j);
                    this.cBZ.setRn(30);
                    if (i == 1) {
                        this.cBZ.bG(0L);
                    } else {
                        this.cBZ.bG(j2);
                    }
                    this.cBW.Fa();
                    return;
                }
                return;
            case 4:
            default:
                if (!this.cBV.Fd()) {
                    this.cBY.setPn(i);
                    this.cBY.setTagCode(j);
                    this.cBY.bK(j2);
                    this.cBV.Fa();
                    return;
                }
                return;
            case 5:
                if (this.cCa != null) {
                    this.cCa.a(com.baidu.tieba.tbadkCore.v.qP(str), j3, com.baidu.tieba.tbadkCore.v.qN(str), i, str2);
                    return;
                } else if (this.cBw != null) {
                    this.cBw.a(j, "", TbadkCoreApplication.m9getInst().getString(t.j.invite_friend_no_data_now), -53, false);
                    return;
                } else {
                    return;
                }
        }
    }

    public BdUniqueId getUniqueId() {
        return this.uniqueId;
    }

    public TbPageContext<BaseFragmentActivity> alB() {
        return this.cBS;
    }

    public void a(com.baidu.tieba.lego.model.a aVar) {
        this.cCa = aVar;
    }

    public com.baidu.tieba.lego.model.a alC() {
        return this.cCa;
    }

    public void a(a aVar) {
        this.cBw = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(MvcSocketResponsedMessage<com.baidu.tieba.homepage.recommendfrs.data.c, ?> mvcSocketResponsedMessage, MvcNetMessage<com.baidu.tbadk.mvc.b.h, com.baidu.tieba.homepage.recommendfrs.data.c> mvcNetMessage) {
        int b = b(mvcNetMessage);
        if (!this.cCd.get(b, false)) {
            this.cCd.put(b, true);
            a(b, false, (ResponsedMessage<?>) mvcSocketResponsedMessage);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(MvcHttpResponsedMessage<com.baidu.tieba.homepage.recommendfrs.data.c> mvcHttpResponsedMessage, MvcNetMessage<com.baidu.tbadk.mvc.b.h, com.baidu.tieba.homepage.recommendfrs.data.c> mvcNetMessage) {
        int b = b(mvcNetMessage);
        if (!this.cCd.get(b, false)) {
            this.cCd.put(b, true);
            a(b, true, (ResponsedMessage<?>) mvcHttpResponsedMessage);
        }
    }

    public void a(int i, boolean z, ResponsedMessage<?> responsedMessage) {
        if (aa.Gp().Gq()) {
            long jM = com.baidu.tieba.homepage.framework.a.alw().jM(i);
            long jL = com.baidu.tieba.homepage.framework.a.alw().jL(i);
            com.baidu.tieba.homepage.framework.a.alw().setCreateTime(0L);
            com.baidu.tbadk.performanceLog.n nVar = new com.baidu.tbadk.performanceLog.n(1005, z, responsedMessage, 0L, 0L, jL, false, jM);
            if (nVar != null) {
                nVar.pageType = i;
                nVar.Gk();
            }
        }
    }

    public a alD() {
        return this.cBw;
    }
}
