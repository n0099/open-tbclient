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
    private a cmH;
    private final TbPageContext<BaseFragmentActivity> cne;
    private com.baidu.tieba.homepage.recommendfrs.a.a cnf;
    private com.baidu.tieba.homepage.mygod.a cng;
    private com.baidu.tieba.homepage.recommendfrs.a.b cnh;
    private com.baidu.tieba.homepage.mygod.b cni;
    private com.baidu.tieba.homepage.personalize.c.g cnj;
    private final BdUniqueId uniqueId;
    private com.baidu.tieba.lego.model.a cnm = null;
    private g.a cnn = new r(this);
    private SparseBooleanArray cno = new SparseBooleanArray();
    private SparseBooleanArray cnp = new SparseBooleanArray();
    private com.baidu.tieba.homepage.recommendfrs.data.d cnk = new com.baidu.tieba.homepage.recommendfrs.data.d();
    private com.baidu.tieba.homepage.mygod.data.e cnl = new com.baidu.tieba.homepage.mygod.data.e();

    /* loaded from: classes.dex */
    public interface a {
        void a(long j, String str, String str2, int i, boolean z);

        void a(long j, DataRes dataRes, boolean z);

        void a(boolean z, com.baidu.tieba.homepage.recommendfrs.data.c cVar, boolean z2, long j, String str, boolean z3);
    }

    public q(TbPageContext<BaseFragmentActivity> tbPageContext, BdUniqueId bdUniqueId) {
        this.cne = tbPageContext;
        this.uniqueId = bdUniqueId;
        this.cnf = new com.baidu.tieba.homepage.recommendfrs.a.a(tbPageContext);
        this.cnf.setUniqueId(bdUniqueId);
        this.cng = new com.baidu.tieba.homepage.mygod.a(tbPageContext);
        this.cng.setUniqueId(bdUniqueId);
        this.cnh = new com.baidu.tieba.homepage.recommendfrs.a.b(tbPageContext, this.cnk);
        this.cnh.setUniqueId(bdUniqueId);
        this.cni = new com.baidu.tieba.homepage.mygod.b(tbPageContext, this.cnl);
        this.cni.setUniqueId(bdUniqueId);
        this.cnj = new com.baidu.tieba.homepage.personalize.c.g(tbPageContext, bdUniqueId);
        this.cnj.a(this.cnn);
        s sVar = new s(this);
        this.cnf.a(sVar);
        this.cng.a(sVar);
        t tVar = new t(this);
        this.cnh.a(tVar);
        this.cni.a(tVar);
    }

    public void a(int i, boolean z, int i2, int i3, int i4, int i5) {
        if (this.cnj != null) {
            this.cnj.a(i, z, i2, i3, i4, i5);
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
            this.cng.a((com.baidu.tbadk.mvc.b.e) new com.baidu.tieba.homepage.mygod.data.c(j));
        } else if (i == 2) {
            this.cnf.a((com.baidu.tbadk.mvc.b.e) new com.baidu.tieba.homepage.recommendfrs.data.b(j));
        } else if (i == 5) {
            if (this.cnm != null) {
                this.cnm.t(j2, com.baidu.tieba.tbadkCore.u.pZ(str));
            } else if (this.cmH != null) {
                this.cmH.a(j, "", TbadkCoreApplication.m9getInst().getString(r.j.invite_friend_no_data_now), -53, false);
            }
        } else if (this.cmH != null) {
            this.cmH.a(j, "", TbadkCoreApplication.m9getInst().getString(r.j.invite_friend_no_data_now), -53, false);
        }
    }

    public void a(int i, long j, int i2, long j2, long j3, String str, String str2) {
        switch (i2) {
            case 3:
                if (!this.cni.wv()) {
                    this.cnl.setPn(i);
                    this.cnl.setTagCode(j);
                    this.cnl.setRn(30);
                    if (i == 1) {
                        this.cnl.bt(0L);
                    } else {
                        this.cnl.bt(j2);
                    }
                    this.cni.EN();
                    return;
                }
                return;
            case 4:
            default:
                if (!this.cnh.wv()) {
                    this.cnk.setPn(i);
                    this.cnk.setTagCode(j);
                    this.cnk.bx(j2);
                    this.cnh.EN();
                    return;
                }
                return;
            case 5:
                if (this.cnm != null) {
                    this.cnm.a(com.baidu.tieba.tbadkCore.u.qb(str), j3, com.baidu.tieba.tbadkCore.u.pZ(str), i, str2);
                    return;
                } else if (this.cmH != null) {
                    this.cmH.a(j, "", TbadkCoreApplication.m9getInst().getString(r.j.invite_friend_no_data_now), -53, false);
                    return;
                } else {
                    return;
                }
        }
    }

    public BdUniqueId getUniqueId() {
        return this.uniqueId;
    }

    public TbPageContext<BaseFragmentActivity> aik() {
        return this.cne;
    }

    public void a(com.baidu.tieba.lego.model.a aVar) {
        this.cnm = aVar;
    }

    public com.baidu.tieba.lego.model.a ail() {
        return this.cnm;
    }

    public void a(a aVar) {
        this.cmH = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(MvcSocketResponsedMessage<com.baidu.tieba.homepage.recommendfrs.data.c, ?> mvcSocketResponsedMessage, MvcNetMessage<com.baidu.tbadk.mvc.b.h, com.baidu.tieba.homepage.recommendfrs.data.c> mvcNetMessage) {
        int b = b(mvcNetMessage);
        if (!this.cnp.get(b, false)) {
            this.cnp.put(b, true);
            a(b, false, (ResponsedMessage<?>) mvcSocketResponsedMessage);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(MvcHttpResponsedMessage<com.baidu.tieba.homepage.recommendfrs.data.c> mvcHttpResponsedMessage, MvcNetMessage<com.baidu.tbadk.mvc.b.h, com.baidu.tieba.homepage.recommendfrs.data.c> mvcNetMessage) {
        int b = b(mvcNetMessage);
        if (!this.cnp.get(b, false)) {
            this.cnp.put(b, true);
            a(b, true, (ResponsedMessage<?>) mvcHttpResponsedMessage);
        }
    }

    public void a(int i, boolean z, ResponsedMessage<?> responsedMessage) {
        if (aa.FU().FV()) {
            long jk = com.baidu.tieba.homepage.framework.a.aif().jk(i);
            long jj = com.baidu.tieba.homepage.framework.a.aif().jj(i);
            com.baidu.tieba.homepage.framework.a.aif().setCreateTime(0L);
            com.baidu.tbadk.performanceLog.n nVar = new com.baidu.tbadk.performanceLog.n(1005, z, responsedMessage, 0L, 0L, jj, false, jk);
            if (nVar != null) {
                nVar.pageType = i;
                nVar.FP();
            }
        }
    }

    public a aim() {
        return this.cmH;
    }
}
