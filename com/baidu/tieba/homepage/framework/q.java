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
    private final TbPageContext<BaseFragmentActivity> cHK;
    private com.baidu.tieba.homepage.recommendfrs.a.a cHL;
    private com.baidu.tieba.homepage.mygod.a cHM;
    private com.baidu.tieba.homepage.recommendfrs.a.b cHN;
    private com.baidu.tieba.homepage.mygod.b cHO;
    private com.baidu.tieba.homepage.personalize.c.g cHP;
    private a cHn;
    private final BdUniqueId uniqueId;
    private com.baidu.tieba.lego.model.a cHS = null;
    private g.a cHT = new r(this);
    private SparseBooleanArray cHU = new SparseBooleanArray();
    private SparseBooleanArray cHV = new SparseBooleanArray();
    private com.baidu.tieba.homepage.recommendfrs.data.d cHQ = new com.baidu.tieba.homepage.recommendfrs.data.d();
    private com.baidu.tieba.homepage.mygod.data.e cHR = new com.baidu.tieba.homepage.mygod.data.e();

    /* loaded from: classes.dex */
    public interface a {
        void a(long j, String str, String str2, int i, boolean z);

        void a(long j, DataRes dataRes, boolean z);

        void a(boolean z, com.baidu.tieba.homepage.recommendfrs.data.c cVar, boolean z2, long j, String str, boolean z3);
    }

    public q(TbPageContext<BaseFragmentActivity> tbPageContext, BdUniqueId bdUniqueId) {
        this.cHK = tbPageContext;
        this.uniqueId = bdUniqueId;
        this.cHL = new com.baidu.tieba.homepage.recommendfrs.a.a(tbPageContext);
        this.cHL.setUniqueId(bdUniqueId);
        this.cHM = new com.baidu.tieba.homepage.mygod.a(tbPageContext);
        this.cHM.setUniqueId(bdUniqueId);
        this.cHN = new com.baidu.tieba.homepage.recommendfrs.a.b(tbPageContext, this.cHQ);
        this.cHN.setUniqueId(bdUniqueId);
        this.cHO = new com.baidu.tieba.homepage.mygod.b(tbPageContext, this.cHR);
        this.cHO.setUniqueId(bdUniqueId);
        this.cHP = new com.baidu.tieba.homepage.personalize.c.g(tbPageContext, bdUniqueId);
        this.cHP.a(this.cHT);
        s sVar = new s(this);
        this.cHL.a(sVar);
        this.cHM.a(sVar);
        t tVar = new t(this);
        this.cHN.a(tVar);
        this.cHO.a(tVar);
    }

    public void a(int i, boolean z, int i2, int i3, int i4, int i5) {
        if (this.cHP != null) {
            this.cHP.a(i, z, i2, i3, i4, i5);
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
            this.cHM.a((com.baidu.tbadk.mvc.b.e) new com.baidu.tieba.homepage.mygod.data.c(j));
        } else if (i == 2) {
            this.cHL.a((com.baidu.tbadk.mvc.b.e) new com.baidu.tieba.homepage.recommendfrs.data.b(j));
        } else if (i == 5) {
            if (this.cHS != null) {
                this.cHS.t(j2, com.baidu.tieba.tbadkCore.v.rv(str));
            } else if (this.cHn != null) {
                this.cHn.a(j, "", TbadkCoreApplication.m9getInst().getString(r.j.invite_friend_no_data_now), -53, false);
            }
        } else if (this.cHn != null) {
            this.cHn.a(j, "", TbadkCoreApplication.m9getInst().getString(r.j.invite_friend_no_data_now), -53, false);
        }
    }

    public void a(int i, long j, int i2, long j2, long j3, String str, String str2) {
        switch (i2) {
            case 3:
                if (!this.cHO.wL()) {
                    this.cHR.setPn(i);
                    this.cHR.setTagCode(j);
                    this.cHR.setRn(30);
                    if (i == 1) {
                        this.cHR.bF(0L);
                    } else {
                        this.cHR.bF(j2);
                    }
                    this.cHO.Ff();
                    return;
                }
                return;
            case 4:
            default:
                if (!this.cHN.wL()) {
                    this.cHQ.setPn(i);
                    this.cHQ.setTagCode(j);
                    this.cHQ.bJ(j2);
                    this.cHN.Ff();
                    return;
                }
                return;
            case 5:
                if (this.cHS != null) {
                    this.cHS.a(com.baidu.tieba.tbadkCore.v.rx(str), j3, com.baidu.tieba.tbadkCore.v.rv(str), i, str2);
                    return;
                } else if (this.cHn != null) {
                    this.cHn.a(j, "", TbadkCoreApplication.m9getInst().getString(r.j.invite_friend_no_data_now), -53, false);
                    return;
                } else {
                    return;
                }
        }
    }

    public BdUniqueId getUniqueId() {
        return this.uniqueId;
    }

    public TbPageContext<BaseFragmentActivity> anK() {
        return this.cHK;
    }

    public void a(com.baidu.tieba.lego.model.a aVar) {
        this.cHS = aVar;
    }

    public com.baidu.tieba.lego.model.a anL() {
        return this.cHS;
    }

    public void a(a aVar) {
        this.cHn = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(MvcSocketResponsedMessage<com.baidu.tieba.homepage.recommendfrs.data.c, ?> mvcSocketResponsedMessage, MvcNetMessage<com.baidu.tbadk.mvc.b.h, com.baidu.tieba.homepage.recommendfrs.data.c> mvcNetMessage) {
        int b = b(mvcNetMessage);
        if (!this.cHV.get(b, false)) {
            this.cHV.put(b, true);
            a(b, false, (ResponsedMessage<?>) mvcSocketResponsedMessage);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(MvcHttpResponsedMessage<com.baidu.tieba.homepage.recommendfrs.data.c> mvcHttpResponsedMessage, MvcNetMessage<com.baidu.tbadk.mvc.b.h, com.baidu.tieba.homepage.recommendfrs.data.c> mvcNetMessage) {
        int b = b(mvcNetMessage);
        if (!this.cHV.get(b, false)) {
            this.cHV.put(b, true);
            a(b, true, (ResponsedMessage<?>) mvcHttpResponsedMessage);
        }
    }

    public void a(int i, boolean z, ResponsedMessage<?> responsedMessage) {
        if (aa.Gu().Gv()) {
            long jZ = com.baidu.tieba.homepage.framework.a.anF().jZ(i);
            long jY = com.baidu.tieba.homepage.framework.a.anF().jY(i);
            com.baidu.tieba.homepage.framework.a.anF().setCreateTime(0L);
            com.baidu.tbadk.performanceLog.n nVar = new com.baidu.tbadk.performanceLog.n(1005, z, responsedMessage, 0L, 0L, jY, false, jZ);
            if (nVar != null) {
                nVar.pageType = i;
                nVar.Gp();
            }
        }
    }

    public a anM() {
        return this.cHn;
    }
}
