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
    private a cte;
    private final TbPageContext<BaseFragmentActivity> cud;
    private RecommendAlaLiveCacheModel cue;
    private RecommendFrsCacheModel cuf;
    private RecommendGodCacheModel cug;
    private RecommendAlaLiveNetModel cuh;
    private RecommendFrsNetModel cui;
    private RecommendGodNetModel cuj;
    private RecPersonalizePageModel cuk;
    private final BdUniqueId uniqueId;
    private com.baidu.tieba.lego.model.a cuo = null;
    private RecPersonalizePageModel.a cup = new r(this);
    private SparseBooleanArray cuq = new SparseBooleanArray();
    private SparseBooleanArray cur = new SparseBooleanArray();
    private com.baidu.tieba.homepage.recommendfrs.data.d cum = new com.baidu.tieba.homepage.recommendfrs.data.d();
    private com.baidu.tieba.homepage.mygod.data.e cun = new com.baidu.tieba.homepage.mygod.data.e();
    private com.baidu.tieba.homepage.alalivelist.data.b cul = new com.baidu.tieba.homepage.alalivelist.data.b();

    /* loaded from: classes.dex */
    public interface a {
        void a(long j, String str, String str2, int i, boolean z);

        void a(long j, DataRes dataRes, boolean z);

        void a(boolean z, com.baidu.tieba.homepage.recommendfrs.data.c cVar, boolean z2, long j, String str, boolean z3);
    }

    public q(TbPageContext<BaseFragmentActivity> tbPageContext, BdUniqueId bdUniqueId) {
        this.cud = tbPageContext;
        this.uniqueId = bdUniqueId;
        this.cue = new RecommendAlaLiveCacheModel(tbPageContext);
        this.cue.setUniqueId(bdUniqueId);
        this.cuf = new RecommendFrsCacheModel(tbPageContext);
        this.cuf.setUniqueId(bdUniqueId);
        this.cug = new RecommendGodCacheModel(tbPageContext);
        this.cug.setUniqueId(bdUniqueId);
        this.cuh = new RecommendAlaLiveNetModel(tbPageContext, this.cul);
        this.cuh.setUniqueId(bdUniqueId);
        this.cui = new RecommendFrsNetModel(tbPageContext, this.cum);
        this.cui.setUniqueId(bdUniqueId);
        this.cuj = new RecommendGodNetModel(tbPageContext, this.cun);
        this.cuj.setUniqueId(bdUniqueId);
        this.cuk = new RecPersonalizePageModel(tbPageContext, bdUniqueId);
        this.cuk.a(this.cup);
        s sVar = new s(this);
        this.cue.a(sVar);
        this.cuf.a(sVar);
        this.cug.a(sVar);
        t tVar = new t(this);
        this.cuh.a(tVar);
        this.cui.a(tVar);
        this.cuj.a(tVar);
    }

    public void a(int i, boolean z, int i2, int i3, int i4, int i5) {
        if (this.cuk != null) {
            this.cuk.a(i, z, i2, i3, i4, i5);
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
            this.cue.a((com.baidu.tbadk.mvc.b.e) new com.baidu.tieba.homepage.alalivelist.data.a(j));
        } else if (i == 3) {
            this.cug.a((com.baidu.tbadk.mvc.b.e) new com.baidu.tieba.homepage.mygod.data.c(j));
        } else if (i == 2) {
            this.cuf.a((com.baidu.tbadk.mvc.b.e) new com.baidu.tieba.homepage.recommendfrs.data.b(j));
        } else if (i == 5) {
            if (this.cuo != null) {
                this.cuo.p(j2, com.baidu.tieba.tbadkCore.t.pT(str));
            } else if (this.cte != null) {
                this.cte.a(j, "", TbadkCoreApplication.m9getInst().getString(w.l.invite_friend_no_data_now), -53, false);
            }
        } else if (this.cte != null) {
            this.cte.a(j, "", TbadkCoreApplication.m9getInst().getString(w.l.invite_friend_no_data_now), -53, false);
        }
    }

    public void a(int i, long j, int i2, long j2, long j3, String str, String str2) {
        switch (i2) {
            case 3:
                if (!this.cuj.xj()) {
                    this.cun.setPn(i);
                    this.cun.setTagCode(j);
                    this.cun.setRn(30);
                    if (i == 1) {
                        this.cun.bo(0L);
                    } else {
                        this.cun.bo(j2);
                    }
                    this.cuj.FC();
                    return;
                }
                return;
            case 4:
            case 6:
            default:
                if (!this.cui.xj()) {
                    this.cum.setPn(i);
                    this.cum.setTagCode(j);
                    this.cum.bs(j2);
                    this.cui.FC();
                    return;
                }
                return;
            case 5:
                if (this.cuo != null) {
                    this.cuo.a(com.baidu.tieba.tbadkCore.t.pV(str), j3, com.baidu.tieba.tbadkCore.t.pT(str), i, str2);
                    return;
                } else if (this.cte != null) {
                    this.cte.a(j, "", TbadkCoreApplication.m9getInst().getString(w.l.invite_friend_no_data_now), -53, false);
                    return;
                } else {
                    return;
                }
            case 7:
                if (!this.cuh.xj()) {
                    this.cul.setPn(i);
                    this.cul.setTagCode(j);
                    this.cuh.FC();
                    return;
                }
                return;
        }
    }

    public BdUniqueId getUniqueId() {
        return this.uniqueId;
    }

    public TbPageContext<BaseFragmentActivity> aiy() {
        return this.cud;
    }

    public void a(com.baidu.tieba.lego.model.a aVar) {
        this.cuo = aVar;
    }

    public com.baidu.tieba.lego.model.a aiz() {
        return this.cuo;
    }

    public void a(a aVar) {
        this.cte = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(MvcSocketResponsedMessage<com.baidu.tieba.homepage.recommendfrs.data.c, ?> mvcSocketResponsedMessage, MvcNetMessage<com.baidu.tbadk.mvc.b.h, com.baidu.tieba.homepage.recommendfrs.data.c> mvcNetMessage) {
        int b = b(mvcNetMessage);
        if (!this.cur.get(b, false)) {
            this.cur.put(b, true);
            a(b, false, (ResponsedMessage<?>) mvcSocketResponsedMessage);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(MvcHttpResponsedMessage<com.baidu.tieba.homepage.recommendfrs.data.c> mvcHttpResponsedMessage, MvcNetMessage<com.baidu.tbadk.mvc.b.h, com.baidu.tieba.homepage.recommendfrs.data.c> mvcNetMessage) {
        int b = b(mvcNetMessage);
        if (!this.cur.get(b, false)) {
            this.cur.put(b, true);
            a(b, true, (ResponsedMessage<?>) mvcHttpResponsedMessage);
        }
    }

    public void a(int i, boolean z, ResponsedMessage<?> responsedMessage) {
        if (aa.GG().GH()) {
            long jD = com.baidu.tieba.homepage.framework.a.ait().jD(i);
            long jC = com.baidu.tieba.homepage.framework.a.ait().jC(i);
            com.baidu.tieba.homepage.framework.a.ait().setCreateTime(0L);
            com.baidu.tbadk.j.n nVar = new com.baidu.tbadk.j.n(1005, z, responsedMessage, 0L, 0L, jC, false, jD);
            if (nVar != null) {
                nVar.pageType = i;
                nVar.GB();
            }
        }
    }

    public a aiA() {
        return this.cte;
    }
}
