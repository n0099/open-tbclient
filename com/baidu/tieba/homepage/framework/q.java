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
    private a cuE;
    private final TbPageContext<BaseFragmentActivity> cvD;
    private RecommendAlaLiveCacheModel cvE;
    private RecommendFrsCacheModel cvF;
    private RecommendGodCacheModel cvG;
    private RecommendAlaLiveNetModel cvH;
    private RecommendFrsNetModel cvI;
    private RecommendGodNetModel cvJ;
    private RecPersonalizePageModel cvK;
    private final BdUniqueId uniqueId;
    private com.baidu.tieba.lego.model.a cvO = null;
    private RecPersonalizePageModel.a cvP = new r(this);
    private SparseBooleanArray cvQ = new SparseBooleanArray();
    private SparseBooleanArray cvR = new SparseBooleanArray();
    private com.baidu.tieba.homepage.recommendfrs.data.d cvM = new com.baidu.tieba.homepage.recommendfrs.data.d();
    private com.baidu.tieba.homepage.mygod.data.e cvN = new com.baidu.tieba.homepage.mygod.data.e();
    private com.baidu.tieba.homepage.alalivelist.data.b cvL = new com.baidu.tieba.homepage.alalivelist.data.b();

    /* loaded from: classes.dex */
    public interface a {
        void a(long j, String str, String str2, int i, boolean z);

        void a(long j, DataRes dataRes, boolean z);

        void a(boolean z, com.baidu.tieba.homepage.recommendfrs.data.c cVar, boolean z2, long j, String str, boolean z3);
    }

    public q(TbPageContext<BaseFragmentActivity> tbPageContext, BdUniqueId bdUniqueId) {
        this.cvD = tbPageContext;
        this.uniqueId = bdUniqueId;
        this.cvE = new RecommendAlaLiveCacheModel(tbPageContext);
        this.cvE.setUniqueId(bdUniqueId);
        this.cvF = new RecommendFrsCacheModel(tbPageContext);
        this.cvF.setUniqueId(bdUniqueId);
        this.cvG = new RecommendGodCacheModel(tbPageContext);
        this.cvG.setUniqueId(bdUniqueId);
        this.cvH = new RecommendAlaLiveNetModel(tbPageContext, this.cvL);
        this.cvH.setUniqueId(bdUniqueId);
        this.cvI = new RecommendFrsNetModel(tbPageContext, this.cvM);
        this.cvI.setUniqueId(bdUniqueId);
        this.cvJ = new RecommendGodNetModel(tbPageContext, this.cvN);
        this.cvJ.setUniqueId(bdUniqueId);
        this.cvK = new RecPersonalizePageModel(tbPageContext, bdUniqueId);
        this.cvK.a(this.cvP);
        s sVar = new s(this);
        this.cvE.a(sVar);
        this.cvF.a(sVar);
        this.cvG.a(sVar);
        t tVar = new t(this);
        this.cvH.a(tVar);
        this.cvI.a(tVar);
        this.cvJ.a(tVar);
    }

    public void a(int i, boolean z, int i2, int i3, int i4, int i5) {
        if (this.cvK != null) {
            this.cvK.a(i, z, i2, i3, i4, i5);
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
            this.cvE.a((com.baidu.tbadk.mvc.b.e) new com.baidu.tieba.homepage.alalivelist.data.a(j));
        } else if (i == 3) {
            this.cvG.a((com.baidu.tbadk.mvc.b.e) new com.baidu.tieba.homepage.mygod.data.c(j));
        } else if (i == 2) {
            this.cvF.a((com.baidu.tbadk.mvc.b.e) new com.baidu.tieba.homepage.recommendfrs.data.b(j));
        } else if (i == 5) {
            if (this.cvO != null) {
                this.cvO.p(j2, com.baidu.tieba.tbadkCore.t.pC(str));
            } else if (this.cuE != null) {
                this.cuE.a(j, "", TbadkCoreApplication.m9getInst().getString(w.l.invite_friend_no_data_now), -53, false);
            }
        } else if (this.cuE != null) {
            this.cuE.a(j, "", TbadkCoreApplication.m9getInst().getString(w.l.invite_friend_no_data_now), -53, false);
        }
    }

    public void a(int i, long j, int i2, long j2, long j3, String str, String str2) {
        switch (i2) {
            case 3:
                if (!this.cvJ.wN()) {
                    this.cvN.setPn(i);
                    this.cvN.setTagCode(j);
                    this.cvN.setRn(30);
                    if (i == 1) {
                        this.cvN.bo(0L);
                    } else {
                        this.cvN.bo(j2);
                    }
                    this.cvJ.Fe();
                    return;
                }
                return;
            case 4:
            case 6:
            default:
                if (!this.cvI.wN()) {
                    this.cvM.setPn(i);
                    this.cvM.setTagCode(j);
                    this.cvM.bs(j2);
                    this.cvI.Fe();
                    return;
                }
                return;
            case 5:
                if (this.cvO != null) {
                    this.cvO.a(com.baidu.tieba.tbadkCore.t.pE(str), j3, com.baidu.tieba.tbadkCore.t.pC(str), i, str2);
                    return;
                } else if (this.cuE != null) {
                    this.cuE.a(j, "", TbadkCoreApplication.m9getInst().getString(w.l.invite_friend_no_data_now), -53, false);
                    return;
                } else {
                    return;
                }
            case 7:
                if (!this.cvH.wN()) {
                    this.cvL.setPn(i);
                    this.cvL.setTagCode(j);
                    this.cvH.Fe();
                    return;
                }
                return;
        }
    }

    public BdUniqueId getUniqueId() {
        return this.uniqueId;
    }

    public TbPageContext<BaseFragmentActivity> aiE() {
        return this.cvD;
    }

    public void a(com.baidu.tieba.lego.model.a aVar) {
        this.cvO = aVar;
    }

    public com.baidu.tieba.lego.model.a aiF() {
        return this.cvO;
    }

    public void a(a aVar) {
        this.cuE = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(MvcSocketResponsedMessage<com.baidu.tieba.homepage.recommendfrs.data.c, ?> mvcSocketResponsedMessage, MvcNetMessage<com.baidu.tbadk.mvc.b.h, com.baidu.tieba.homepage.recommendfrs.data.c> mvcNetMessage) {
        int b = b(mvcNetMessage);
        if (!this.cvR.get(b, false)) {
            this.cvR.put(b, true);
            a(b, false, (ResponsedMessage<?>) mvcSocketResponsedMessage);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(MvcHttpResponsedMessage<com.baidu.tieba.homepage.recommendfrs.data.c> mvcHttpResponsedMessage, MvcNetMessage<com.baidu.tbadk.mvc.b.h, com.baidu.tieba.homepage.recommendfrs.data.c> mvcNetMessage) {
        int b = b(mvcNetMessage);
        if (!this.cvR.get(b, false)) {
            this.cvR.put(b, true);
            a(b, true, (ResponsedMessage<?>) mvcHttpResponsedMessage);
        }
    }

    public void a(int i, boolean z, ResponsedMessage<?> responsedMessage) {
        if (aa.Gi().Gj()) {
            long jC = com.baidu.tieba.homepage.framework.a.aiz().jC(i);
            long jB = com.baidu.tieba.homepage.framework.a.aiz().jB(i);
            com.baidu.tieba.homepage.framework.a.aiz().setCreateTime(0L);
            com.baidu.tbadk.performanceLog.n nVar = new com.baidu.tbadk.performanceLog.n(1005, z, responsedMessage, 0L, 0L, jB, false, jC);
            if (nVar != null) {
                nVar.pageType = i;
                nVar.Gd();
            }
        }
    }

    public a aiG() {
        return this.cuE;
    }
}
