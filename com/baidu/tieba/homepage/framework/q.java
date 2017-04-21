package com.baidu.tieba.homepage.framework;

import android.util.SparseBooleanArray;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.j.aa;
import com.baidu.tbadk.mvc.message.MvcHttpResponsedMessage;
import com.baidu.tbadk.mvc.message.MvcNetMessage;
import com.baidu.tbadk.mvc.message.MvcSocketResponsedMessage;
import com.baidu.tieba.homepage.alalivelist.model.RecommendAlaLiveCacheModel;
import com.baidu.tieba.homepage.alalivelist.model.RecommendAlaLiveNetModel;
import com.baidu.tieba.homepage.mygod.RecommendGodCacheModel;
import com.baidu.tieba.homepage.mygod.RecommendGodNetModel;
import com.baidu.tieba.homepage.personalize.model.RecPersonalizePageModel;
import com.baidu.tieba.homepage.recommendfrs.model.RecommendFrsCacheModel;
import com.baidu.tieba.homepage.recommendfrs.model.RecommendFrsNetModel;
import com.baidu.tieba.w;
import tbclient.Personalized.DataRes;
/* loaded from: classes.dex */
public class q {
    private a cvv;
    private RecommendGodNetModel cwA;
    private RecPersonalizePageModel cwB;
    private final TbPageContext<BaseFragmentActivity> cwu;
    private RecommendAlaLiveCacheModel cwv;
    private RecommendFrsCacheModel cww;
    private RecommendGodCacheModel cwx;
    private RecommendAlaLiveNetModel cwy;
    private RecommendFrsNetModel cwz;
    private final BdUniqueId uniqueId;
    private com.baidu.tieba.lego.model.a cwF = null;
    private RecPersonalizePageModel.a cwG = new r(this);
    private SparseBooleanArray cwH = new SparseBooleanArray();
    private SparseBooleanArray cwI = new SparseBooleanArray();
    private com.baidu.tieba.homepage.recommendfrs.data.d cwD = new com.baidu.tieba.homepage.recommendfrs.data.d();
    private com.baidu.tieba.homepage.mygod.data.e cwE = new com.baidu.tieba.homepage.mygod.data.e();
    private com.baidu.tieba.homepage.alalivelist.data.b cwC = new com.baidu.tieba.homepage.alalivelist.data.b();

    /* loaded from: classes.dex */
    public interface a {
        void a(long j, String str, String str2, int i, boolean z);

        void a(long j, DataRes dataRes, boolean z);

        void a(boolean z, com.baidu.tieba.homepage.recommendfrs.data.c cVar, boolean z2, long j, String str, boolean z3);
    }

    public q(TbPageContext<BaseFragmentActivity> tbPageContext, BdUniqueId bdUniqueId) {
        this.cwu = tbPageContext;
        this.uniqueId = bdUniqueId;
        this.cwv = new RecommendAlaLiveCacheModel(tbPageContext);
        this.cwv.setUniqueId(bdUniqueId);
        this.cww = new RecommendFrsCacheModel(tbPageContext);
        this.cww.setUniqueId(bdUniqueId);
        this.cwx = new RecommendGodCacheModel(tbPageContext);
        this.cwx.setUniqueId(bdUniqueId);
        this.cwy = new RecommendAlaLiveNetModel(tbPageContext, this.cwC);
        this.cwy.setUniqueId(bdUniqueId);
        this.cwz = new RecommendFrsNetModel(tbPageContext, this.cwD);
        this.cwz.setUniqueId(bdUniqueId);
        this.cwA = new RecommendGodNetModel(tbPageContext, this.cwE);
        this.cwA.setUniqueId(bdUniqueId);
        this.cwB = new RecPersonalizePageModel(tbPageContext, bdUniqueId);
        this.cwB.a(this.cwG);
        s sVar = new s(this);
        this.cwv.a(sVar);
        this.cww.a(sVar);
        this.cwx.a(sVar);
        t tVar = new t(this);
        this.cwy.a(tVar);
        this.cwz.a(tVar);
        this.cwA.a(tVar);
    }

    public void a(int i, boolean z, int i2, int i3, int i4, int i5) {
        if (this.cwB != null) {
            this.cwB.a(i, z, i2, i3, i4, i5);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long a(MvcNetMessage<com.baidu.tbadk.mvc.b.h, com.baidu.tieba.homepage.recommendfrs.data.c> mvcNetMessage) {
        com.baidu.tieba.homepage.alalivelist.data.b bVar;
        if (mvcNetMessage != null) {
            if (mvcNetMessage.getRequestData() instanceof com.baidu.tieba.homepage.recommendfrs.data.d) {
                com.baidu.tieba.homepage.recommendfrs.data.d dVar = (com.baidu.tieba.homepage.recommendfrs.data.d) mvcNetMessage.getRequestData();
                if (dVar != null) {
                    return dVar.getTagCode();
                }
            } else if (mvcNetMessage.getRequestData() instanceof com.baidu.tieba.homepage.mygod.data.e) {
                com.baidu.tieba.homepage.mygod.data.e eVar = (com.baidu.tieba.homepage.mygod.data.e) mvcNetMessage.getRequestData();
                if (eVar != null) {
                    return eVar.getTagCode();
                }
            } else if ((mvcNetMessage.getRequestData() instanceof com.baidu.tieba.homepage.alalivelist.data.b) && (bVar = (com.baidu.tieba.homepage.alalivelist.data.b) mvcNetMessage.getRequestData()) != null) {
                return bVar.getTagCode();
            }
        }
        return -1L;
    }

    private int b(MvcNetMessage<com.baidu.tbadk.mvc.b.h, com.baidu.tieba.homepage.recommendfrs.data.c> mvcNetMessage) {
        if (mvcNetMessage != null) {
            if (mvcNetMessage.getRequestData() instanceof com.baidu.tieba.homepage.recommendfrs.data.d) {
                return 2;
            }
            if (mvcNetMessage.getRequestData() instanceof com.baidu.tieba.homepage.mygod.data.e) {
                return 3;
            }
            return mvcNetMessage.getRequestData() instanceof com.baidu.tieba.homepage.alalivelist.data.b ? 7 : 0;
        }
        return 0;
    }

    public void a(long j, int i, long j2, String str) {
        if (i == 7) {
            this.cwv.a((com.baidu.tbadk.mvc.b.e) new com.baidu.tieba.homepage.alalivelist.data.a(j));
        } else if (i == 3) {
            this.cwx.a((com.baidu.tbadk.mvc.b.e) new com.baidu.tieba.homepage.mygod.data.c(j));
        } else if (i == 2) {
            this.cww.a((com.baidu.tbadk.mvc.b.e) new com.baidu.tieba.homepage.recommendfrs.data.b(j));
        } else if (i == 5) {
            if (this.cwF != null) {
                this.cwF.p(j2, com.baidu.tieba.tbadkCore.t.pU(str));
            } else if (this.cvv != null) {
                this.cvv.a(j, "", TbadkCoreApplication.m9getInst().getString(w.l.invite_friend_no_data_now), -53, false);
            }
        } else if (this.cvv != null) {
            this.cvv.a(j, "", TbadkCoreApplication.m9getInst().getString(w.l.invite_friend_no_data_now), -53, false);
        }
    }

    public void a(int i, long j, int i2, long j2, long j3, String str, String str2) {
        switch (i2) {
            case 3:
                if (!this.cwA.xj()) {
                    this.cwE.setPn(i);
                    this.cwE.setTagCode(j);
                    this.cwE.setRn(30);
                    if (i == 1) {
                        this.cwE.bo(0L);
                    } else {
                        this.cwE.bo(j2);
                    }
                    this.cwA.FC();
                    return;
                }
                return;
            case 4:
            case 6:
            default:
                if (!this.cwz.xj()) {
                    this.cwD.setPn(i);
                    this.cwD.setTagCode(j);
                    this.cwD.bs(j2);
                    this.cwz.FC();
                    return;
                }
                return;
            case 5:
                if (this.cwF != null) {
                    this.cwF.a(com.baidu.tieba.tbadkCore.t.pW(str), j3, com.baidu.tieba.tbadkCore.t.pU(str), i, str2);
                    return;
                } else if (this.cvv != null) {
                    this.cvv.a(j, "", TbadkCoreApplication.m9getInst().getString(w.l.invite_friend_no_data_now), -53, false);
                    return;
                } else {
                    return;
                }
            case 7:
                if (!this.cwy.xj()) {
                    this.cwC.setPn(i);
                    this.cwC.setTagCode(j);
                    this.cwy.FC();
                    return;
                }
                return;
        }
    }

    public BdUniqueId getUniqueId() {
        return this.uniqueId;
    }

    public TbPageContext<BaseFragmentActivity> ajz() {
        return this.cwu;
    }

    public void a(com.baidu.tieba.lego.model.a aVar) {
        this.cwF = aVar;
    }

    public com.baidu.tieba.lego.model.a ajA() {
        return this.cwF;
    }

    public void a(a aVar) {
        this.cvv = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(MvcSocketResponsedMessage<com.baidu.tieba.homepage.recommendfrs.data.c, ?> mvcSocketResponsedMessage, MvcNetMessage<com.baidu.tbadk.mvc.b.h, com.baidu.tieba.homepage.recommendfrs.data.c> mvcNetMessage) {
        int b = b(mvcNetMessage);
        if (!this.cwI.get(b, false)) {
            this.cwI.put(b, true);
            a(b, false, (ResponsedMessage<?>) mvcSocketResponsedMessage);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(MvcHttpResponsedMessage<com.baidu.tieba.homepage.recommendfrs.data.c> mvcHttpResponsedMessage, MvcNetMessage<com.baidu.tbadk.mvc.b.h, com.baidu.tieba.homepage.recommendfrs.data.c> mvcNetMessage) {
        int b = b(mvcNetMessage);
        if (!this.cwI.get(b, false)) {
            this.cwI.put(b, true);
            a(b, true, (ResponsedMessage<?>) mvcHttpResponsedMessage);
        }
    }

    public void a(int i, boolean z, ResponsedMessage<?> responsedMessage) {
        if (aa.GG().GH()) {
            long jJ = com.baidu.tieba.homepage.framework.a.aju().jJ(i);
            long jI = com.baidu.tieba.homepage.framework.a.aju().jI(i);
            com.baidu.tieba.homepage.framework.a.aju().setCreateTime(0L);
            com.baidu.tbadk.j.n nVar = new com.baidu.tbadk.j.n(1005, z, responsedMessage, 0L, 0L, jI, false, jJ);
            if (nVar != null) {
                nVar.pageType = i;
                nVar.GB();
            }
        }
    }

    public a ajB() {
        return this.cvv;
    }
}
