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
import com.baidu.tieba.u;
import tbclient.Personalized.DataRes;
/* loaded from: classes.dex */
public class q {
    private final TbPageContext<BaseFragmentActivity> cqK;
    private com.baidu.tieba.homepage.recommendfrs.a.a cqL;
    private com.baidu.tieba.homepage.mygod.a cqM;
    private com.baidu.tieba.homepage.recommendfrs.a.b cqN;
    private com.baidu.tieba.homepage.mygod.b cqO;
    private com.baidu.tieba.homepage.personalize.b.g cqP;
    private a cqo;
    private final BdUniqueId uniqueId;
    private com.baidu.tieba.lego.model.a cqS = null;
    private g.a cqT = new r(this);
    private SparseBooleanArray cqU = new SparseBooleanArray();
    private SparseBooleanArray cqV = new SparseBooleanArray();
    private com.baidu.tieba.homepage.recommendfrs.data.d cqQ = new com.baidu.tieba.homepage.recommendfrs.data.d();
    private com.baidu.tieba.homepage.mygod.data.d cqR = new com.baidu.tieba.homepage.mygod.data.d();

    /* loaded from: classes.dex */
    public interface a {
        void a(long j, String str, String str2, int i, boolean z);

        void a(long j, DataRes dataRes, boolean z);

        void a(boolean z, com.baidu.tieba.homepage.recommendfrs.data.c cVar, boolean z2, long j, String str, boolean z3);
    }

    public q(TbPageContext<BaseFragmentActivity> tbPageContext, BdUniqueId bdUniqueId) {
        this.cqK = tbPageContext;
        this.uniqueId = bdUniqueId;
        this.cqL = new com.baidu.tieba.homepage.recommendfrs.a.a(tbPageContext);
        this.cqL.setUniqueId(bdUniqueId);
        this.cqM = new com.baidu.tieba.homepage.mygod.a(tbPageContext);
        this.cqM.setUniqueId(bdUniqueId);
        this.cqN = new com.baidu.tieba.homepage.recommendfrs.a.b(tbPageContext, this.cqQ);
        this.cqN.setUniqueId(bdUniqueId);
        this.cqO = new com.baidu.tieba.homepage.mygod.b(tbPageContext, this.cqR);
        this.cqO.setUniqueId(bdUniqueId);
        this.cqP = new com.baidu.tieba.homepage.personalize.b.g(tbPageContext, bdUniqueId);
        this.cqP.a(this.cqT);
        s sVar = new s(this);
        this.cqL.a(sVar);
        this.cqM.a(sVar);
        t tVar = new t(this);
        this.cqN.a(tVar);
        this.cqO.a(tVar);
    }

    public void a(int i, boolean z, int i2, int i3, int i4, int i5) {
        if (this.cqP != null) {
            this.cqP.a(i, z, i2, i3, i4, i5);
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
            this.cqM.a((com.baidu.tbadk.mvc.b.e) new com.baidu.tieba.homepage.mygod.data.b(j));
        } else if (i == 2) {
            this.cqL.a((com.baidu.tbadk.mvc.b.e) new com.baidu.tieba.homepage.recommendfrs.data.b(j));
        } else if (i == 5) {
            if (this.cqS != null) {
                this.cqS.q(j2, com.baidu.tieba.tbadkCore.w.qd(str));
            } else if (this.cqo != null) {
                this.cqo.a(j, "", TbadkCoreApplication.m10getInst().getString(u.j.invite_friend_no_data_now), -53, false);
            }
        } else if (this.cqo != null) {
            this.cqo.a(j, "", TbadkCoreApplication.m10getInst().getString(u.j.invite_friend_no_data_now), -53, false);
        }
    }

    public void a(int i, long j, int i2, long j2, long j3, String str, String str2) {
        switch (i2) {
            case 3:
                if (!this.cqO.DJ()) {
                    this.cqR.setPn(i);
                    this.cqR.setTagCode(j);
                    this.cqR.setRn(30);
                    if (i == 1) {
                        this.cqR.bk(0L);
                    } else {
                        this.cqR.bk(j2);
                    }
                    this.cqO.DG();
                    return;
                }
                return;
            case 4:
            default:
                if (!this.cqN.DJ()) {
                    this.cqQ.setPn(i);
                    this.cqQ.setTagCode(j);
                    this.cqQ.bo(j2);
                    this.cqN.DG();
                    return;
                }
                return;
            case 5:
                if (this.cqS != null) {
                    this.cqS.a(com.baidu.tieba.tbadkCore.w.qf(str), j3, com.baidu.tieba.tbadkCore.w.qd(str), i, str2);
                    return;
                } else if (this.cqo != null) {
                    this.cqo.a(j, "", TbadkCoreApplication.m10getInst().getString(u.j.invite_friend_no_data_now), -53, false);
                    return;
                } else {
                    return;
                }
        }
    }

    public BdUniqueId getUniqueId() {
        return this.uniqueId;
    }

    public TbPageContext<BaseFragmentActivity> agQ() {
        return this.cqK;
    }

    public void a(com.baidu.tieba.lego.model.a aVar) {
        this.cqS = aVar;
    }

    public com.baidu.tieba.lego.model.a agR() {
        return this.cqS;
    }

    public void a(a aVar) {
        this.cqo = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(MvcSocketResponsedMessage<com.baidu.tieba.homepage.recommendfrs.data.c, ?> mvcSocketResponsedMessage, MvcNetMessage<com.baidu.tbadk.mvc.b.h, com.baidu.tieba.homepage.recommendfrs.data.c> mvcNetMessage) {
        int b = b(mvcNetMessage);
        if (!this.cqV.get(b, false)) {
            this.cqV.put(b, true);
            a(b, false, (ResponsedMessage<?>) mvcSocketResponsedMessage);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(MvcHttpResponsedMessage<com.baidu.tieba.homepage.recommendfrs.data.c> mvcHttpResponsedMessage, MvcNetMessage<com.baidu.tbadk.mvc.b.h, com.baidu.tieba.homepage.recommendfrs.data.c> mvcNetMessage) {
        int b = b(mvcNetMessage);
        if (!this.cqV.get(b, false)) {
            this.cqV.put(b, true);
            a(b, true, (ResponsedMessage<?>) mvcHttpResponsedMessage);
        }
    }

    public void a(int i, boolean z, ResponsedMessage<?> responsedMessage) {
        if (aa.EV().EW()) {
            long jk = com.baidu.tieba.homepage.framework.a.agL().jk(i);
            long jj = com.baidu.tieba.homepage.framework.a.agL().jj(i);
            com.baidu.tieba.homepage.framework.a.agL().setCreateTime(0L);
            com.baidu.tbadk.performanceLog.n nVar = new com.baidu.tbadk.performanceLog.n(1005, z, responsedMessage, 0L, 0L, jj, false, jk);
            if (nVar != null) {
                nVar.pageType = i;
                nVar.EQ();
            }
        }
    }

    public a agS() {
        return this.cqo;
    }
}
