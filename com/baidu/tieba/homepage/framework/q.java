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
import com.baidu.tieba.r;
import tbclient.Personalized.DataRes;
/* loaded from: classes.dex */
public class q {
    private a ctf;
    private final TbPageContext<BaseFragmentActivity> cue;
    private RecommendAlaLiveCacheModel cuf;
    private RecommendFrsCacheModel cug;
    private RecommendGodCacheModel cuh;
    private RecommendAlaLiveNetModel cui;
    private RecommendFrsNetModel cuj;
    private RecommendGodNetModel cuk;
    private RecPersonalizePageModel cul;
    private final BdUniqueId uniqueId;
    private com.baidu.tieba.lego.model.a cup = null;
    private RecPersonalizePageModel.a cuq = new r(this);
    private SparseBooleanArray cur = new SparseBooleanArray();
    private SparseBooleanArray cus = new SparseBooleanArray();
    private com.baidu.tieba.homepage.recommendfrs.data.d cun = new com.baidu.tieba.homepage.recommendfrs.data.d();
    private com.baidu.tieba.homepage.mygod.data.e cuo = new com.baidu.tieba.homepage.mygod.data.e();
    private com.baidu.tieba.homepage.alalivelist.data.b cum = new com.baidu.tieba.homepage.alalivelist.data.b();

    /* loaded from: classes.dex */
    public interface a {
        void a(long j, String str, String str2, int i, boolean z);

        void a(long j, DataRes dataRes, boolean z);

        void a(boolean z, com.baidu.tieba.homepage.recommendfrs.data.c cVar, boolean z2, long j, String str, boolean z3);
    }

    public q(TbPageContext<BaseFragmentActivity> tbPageContext, BdUniqueId bdUniqueId) {
        this.cue = tbPageContext;
        this.uniqueId = bdUniqueId;
        this.cuf = new RecommendAlaLiveCacheModel(tbPageContext);
        this.cuf.setUniqueId(bdUniqueId);
        this.cug = new RecommendFrsCacheModel(tbPageContext);
        this.cug.setUniqueId(bdUniqueId);
        this.cuh = new RecommendGodCacheModel(tbPageContext);
        this.cuh.setUniqueId(bdUniqueId);
        this.cui = new RecommendAlaLiveNetModel(tbPageContext, this.cum);
        this.cui.setUniqueId(bdUniqueId);
        this.cuj = new RecommendFrsNetModel(tbPageContext, this.cun);
        this.cuj.setUniqueId(bdUniqueId);
        this.cuk = new RecommendGodNetModel(tbPageContext, this.cuo);
        this.cuk.setUniqueId(bdUniqueId);
        this.cul = new RecPersonalizePageModel(tbPageContext, bdUniqueId);
        this.cul.a(this.cuq);
        s sVar = new s(this);
        this.cuf.a(sVar);
        this.cug.a(sVar);
        this.cuh.a(sVar);
        t tVar = new t(this);
        this.cui.a(tVar);
        this.cuj.a(tVar);
        this.cuk.a(tVar);
    }

    public void a(int i, boolean z, int i2, int i3, int i4, int i5) {
        if (this.cul != null) {
            this.cul.a(i, z, i2, i3, i4, i5);
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
            this.cuf.a((com.baidu.tbadk.mvc.b.e) new com.baidu.tieba.homepage.alalivelist.data.a(j));
        } else if (i == 3) {
            this.cuh.a((com.baidu.tbadk.mvc.b.e) new com.baidu.tieba.homepage.mygod.data.c(j));
        } else if (i == 2) {
            this.cug.a((com.baidu.tbadk.mvc.b.e) new com.baidu.tieba.homepage.recommendfrs.data.b(j));
        } else if (i == 5) {
            if (this.cup != null) {
                this.cup.q(j2, com.baidu.tieba.tbadkCore.t.qt(str));
            } else if (this.ctf != null) {
                this.ctf.a(j, "", TbadkCoreApplication.m9getInst().getString(r.l.invite_friend_no_data_now), -53, false);
            }
        } else if (this.ctf != null) {
            this.ctf.a(j, "", TbadkCoreApplication.m9getInst().getString(r.l.invite_friend_no_data_now), -53, false);
        }
    }

    public void a(int i, long j, int i2, long j2, long j3, String str, String str2) {
        switch (i2) {
            case 3:
                if (!this.cuk.wq()) {
                    this.cuo.setPn(i);
                    this.cuo.setTagCode(j);
                    this.cuo.setRn(30);
                    if (i == 1) {
                        this.cuo.bo(0L);
                    } else {
                        this.cuo.bo(j2);
                    }
                    this.cuk.EH();
                    return;
                }
                return;
            case 4:
            case 6:
            default:
                if (!this.cuj.wq()) {
                    this.cun.setPn(i);
                    this.cun.setTagCode(j);
                    this.cun.bs(j2);
                    this.cuj.EH();
                    return;
                }
                return;
            case 5:
                if (this.cup != null) {
                    this.cup.a(com.baidu.tieba.tbadkCore.t.qv(str), j3, com.baidu.tieba.tbadkCore.t.qt(str), i, str2);
                    return;
                } else if (this.ctf != null) {
                    this.ctf.a(j, "", TbadkCoreApplication.m9getInst().getString(r.l.invite_friend_no_data_now), -53, false);
                    return;
                } else {
                    return;
                }
            case 7:
                if (!this.cui.wq()) {
                    this.cum.setPn(i);
                    this.cum.setTagCode(j);
                    this.cui.EH();
                    return;
                }
                return;
        }
    }

    public BdUniqueId getUniqueId() {
        return this.uniqueId;
    }

    public TbPageContext<BaseFragmentActivity> ajr() {
        return this.cue;
    }

    public void a(com.baidu.tieba.lego.model.a aVar) {
        this.cup = aVar;
    }

    public com.baidu.tieba.lego.model.a ajs() {
        return this.cup;
    }

    public void a(a aVar) {
        this.ctf = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(MvcSocketResponsedMessage<com.baidu.tieba.homepage.recommendfrs.data.c, ?> mvcSocketResponsedMessage, MvcNetMessage<com.baidu.tbadk.mvc.b.h, com.baidu.tieba.homepage.recommendfrs.data.c> mvcNetMessage) {
        int b = b(mvcNetMessage);
        if (!this.cus.get(b, false)) {
            this.cus.put(b, true);
            a(b, false, (ResponsedMessage<?>) mvcSocketResponsedMessage);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(MvcHttpResponsedMessage<com.baidu.tieba.homepage.recommendfrs.data.c> mvcHttpResponsedMessage, MvcNetMessage<com.baidu.tbadk.mvc.b.h, com.baidu.tieba.homepage.recommendfrs.data.c> mvcNetMessage) {
        int b = b(mvcNetMessage);
        if (!this.cus.get(b, false)) {
            this.cus.put(b, true);
            a(b, true, (ResponsedMessage<?>) mvcHttpResponsedMessage);
        }
    }

    public void a(int i, boolean z, ResponsedMessage<?> responsedMessage) {
        if (aa.FO().FP()) {
            long jX = com.baidu.tieba.homepage.framework.a.ajm().jX(i);
            long jW = com.baidu.tieba.homepage.framework.a.ajm().jW(i);
            com.baidu.tieba.homepage.framework.a.ajm().setCreateTime(0L);
            com.baidu.tbadk.performanceLog.n nVar = new com.baidu.tbadk.performanceLog.n(1005, z, responsedMessage, 0L, 0L, jW, false, jX);
            if (nVar != null) {
                nVar.pageType = i;
                nVar.FJ();
            }
        }
    }

    public a ajt() {
        return this.ctf;
    }
}
