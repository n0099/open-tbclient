package com.baidu.tieba.enterForum.c;

import android.os.Handler;
import android.os.Looper;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.v;
import com.baidu.tieba.enterForum.home.forumRecommendHttpResponseMessage;
import com.baidu.tieba.enterForum.home.forumRecommendRequestMessage;
import com.baidu.tieba.enterForum.home.forumRecommendSocketResponseMessage;
import com.baidu.tieba.t;
import com.baidu.tieba.tbadkCore.ae;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/* loaded from: classes.dex */
public class c extends com.baidu.adp.base.f {
    private TbPageContext LH;
    private com.baidu.tieba.enterForum.b.b aFp;
    private boolean aFq;
    private h aFr;
    private com.baidu.tieba.tbadkCore.e.a aFs;
    private long aFt;
    private long aFu;
    private long aFv;
    private long aFw;
    private Handler mUIHandler;

    public c(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.aFp = null;
        this.aFq = true;
        this.aFr = null;
        this.aFs = null;
        this.aFt = 0L;
        this.aFu = 0L;
        this.aFv = 0L;
        this.aFw = 0L;
        this.mUIHandler = null;
        this.LH = tbPageContext;
        setUniqueId(BdUniqueId.gen());
        this.mUIHandler = new Handler(Looper.getMainLooper());
    }

    @Override // com.baidu.adp.base.f
    public BdUniqueId getUniqueId() {
        return this.unique_id;
    }

    public long HZ() {
        return this.aFw;
    }

    public long Ia() {
        return this.aFu;
    }

    public long Ib() {
        return this.aFv;
    }

    public long Ic() {
        return this.aFt;
    }

    public com.baidu.tieba.enterForum.b.b Id() {
        return this.aFp;
    }

    public void b(com.baidu.tieba.enterForum.b.b bVar) {
        this.aFp = bVar;
    }

    public void a(h hVar) {
        this.aFr = hVar;
    }

    @Override // com.baidu.adp.base.f
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.f
    public boolean cancelLoadData() {
        cancelMessage();
        Ie();
        return true;
    }

    private void Ie() {
        if (this.aFs != null) {
            this.aFs.destory();
            this.aFs = null;
        }
    }

    public boolean bJ(boolean z) {
        cancelLoadData();
        this.aFq = z;
        forumRecommendRequestMessage forumrecommendrequestmessage = new forumRecommendRequestMessage();
        forumrecommendrequestmessage.set_like_forum(1);
        forumrecommendrequestmessage.set_topic(0);
        forumrecommendrequestmessage.set_recommend(0);
        this.aFt = System.currentTimeMillis();
        if (this.aFs == null) {
            this.aFs = new com.baidu.tieba.tbadkCore.e.a("forumrecommendStat");
        }
        sendMessage(forumrecommendrequestmessage);
        return true;
    }

    public boolean bK(boolean z) {
        this.aFq = z;
        If();
        return true;
    }

    public void a(boolean z, int i, String str, boolean z2, int i2, long j, long j2) {
        g gVar = new g(this);
        boolean z3 = !z;
        if (this.aFs != null) {
            this.aFs.a(z2, z3, i, str, i2, j, j2);
            this.aFs = null;
        }
        this.aFp.bG(false);
        if (z || !this.aFp.isSuccess()) {
            if (str != null && str.length() > 0) {
                setErrorString(str);
                gVar.aFA = str;
            }
            gVar.type = 1;
            gVar.aFB = false;
            gVar.aFC = this.aFp;
            this.aFr.a(gVar);
            return;
        }
        gVar.type = 1;
        gVar.aFB = true;
        gVar.aFC = this.aFp;
        this.aFr.a(gVar);
    }

    public void a(forumRecommendSocketResponseMessage forumrecommendsocketresponsemessage) {
        a(forumrecommendsocketresponsemessage, forumrecommendsocketresponsemessage.hasError(), forumrecommendsocketresponsemessage.getError(), StringUtils.isNull(forumrecommendsocketresponsemessage.getErrorString()) ? this.LH.getResources().getString(t.neterror) : forumrecommendsocketresponsemessage.getErrorString(), false, forumrecommendsocketresponsemessage.getDownSize(), 0L, forumrecommendsocketresponsemessage.getCostTime());
    }

    public void a(forumRecommendHttpResponseMessage forumrecommendhttpresponsemessage) {
        a(forumrecommendhttpresponsemessage, forumrecommendhttpresponsemessage.hasError(), forumrecommendhttpresponsemessage.getError(), StringUtils.isNull(forumrecommendhttpresponsemessage.getErrorString()) ? this.LH.getResources().getString(t.neterror) : forumrecommendhttpresponsemessage.getErrorString(), true, forumrecommendhttpresponsemessage.getDownSize(), forumrecommendhttpresponsemessage.getCostTime(), 0L);
    }

    public void a(ResponsedMessage<?> responsedMessage, boolean z, int i, String str, boolean z2, int i2, long j, long j2) {
        if (z) {
            this.aFp = null;
        }
        if (responsedMessage != null) {
            if (responsedMessage instanceof forumRecommendSocketResponseMessage) {
                b((forumRecommendSocketResponseMessage) responsedMessage);
            } else if (responsedMessage instanceof forumRecommendHttpResponseMessage) {
                b((forumRecommendHttpResponseMessage) responsedMessage);
            }
        }
        a(z, i, str, z2, i2, j, j2);
    }

    public void b(forumRecommendHttpResponseMessage forumrecommendhttpresponsemessage) {
        if (forumrecommendhttpresponsemessage != null) {
            try {
                this.aFp = new com.baidu.tieba.enterForum.b.b();
                this.aFp.setTime(forumrecommendhttpresponsemessage.GetIsLogin().intValue());
                this.aFp.eE(forumrecommendhttpresponsemessage.GetMsignValid().intValue());
                this.aFp.fQ(forumrecommendhttpresponsemessage.GetMsignText());
                this.aFp.eF(forumrecommendhttpresponsemessage.GetMsignLevel().intValue());
                this.aFp.setIsMem(forumrecommendhttpresponsemessage.GetIsMem().intValue());
                this.aFp.eD(forumrecommendhttpresponsemessage.GetIsLogin().intValue());
                this.aFp.bG(false);
                com.baidu.tieba.enterForum.b.c cVar = new com.baidu.tieba.enterForum.b.c();
                cVar.setLevel(forumrecommendhttpresponsemessage.GetMsignLevel().intValue());
                cVar.j(forumrecommendhttpresponsemessage.GetLikeForum());
                this.aFp.a(cVar);
                com.baidu.tieba.enterForum.b.f fVar = new com.baidu.tieba.enterForum.b.f();
                fVar.I(forumrecommendhttpresponsemessage.GetRecommendForumInfoList());
                this.aFp.a(fVar);
                v vVar = new v();
                vVar.j(forumrecommendhttpresponsemessage.GetBanner());
                this.aFp.a(vVar);
                this.aFp.al(true);
            } catch (Exception e) {
                this.aFp.al(false);
                BdLog.e(e.getMessage());
            }
        }
    }

    public void b(forumRecommendSocketResponseMessage forumrecommendsocketresponsemessage) {
        if (forumrecommendsocketresponsemessage != null) {
            try {
                this.aFp = new com.baidu.tieba.enterForum.b.b();
                this.aFp.setTime(forumrecommendsocketresponsemessage.GetIsLogin().intValue());
                this.aFp.eE(forumrecommendsocketresponsemessage.GetMsignValid().intValue());
                this.aFp.fQ(forumrecommendsocketresponsemessage.GetMsignText());
                this.aFp.eF(forumrecommendsocketresponsemessage.GetMsignLevel().intValue());
                this.aFp.setIsMem(forumrecommendsocketresponsemessage.GetIsMem().intValue());
                this.aFp.eD(forumrecommendsocketresponsemessage.GetIsLogin().intValue());
                this.aFp.bG(false);
                com.baidu.tieba.enterForum.b.c cVar = new com.baidu.tieba.enterForum.b.c();
                cVar.setLevel(forumrecommendsocketresponsemessage.GetMsignLevel().intValue());
                cVar.j(forumrecommendsocketresponsemessage.GetLikeForum());
                this.aFp.a(cVar);
                com.baidu.tieba.enterForum.b.f fVar = new com.baidu.tieba.enterForum.b.f();
                fVar.I(forumrecommendsocketresponsemessage.GetRecommendForumInfoList());
                this.aFp.a(fVar);
                v vVar = new v();
                vVar.j(forumrecommendsocketresponsemessage.GetBanner());
                this.aFp.a(vVar);
                this.aFp.al(true);
            } catch (Exception e) {
                this.aFp.al(false);
                BdLog.e(e.getMessage());
            }
        }
    }

    private void If() {
        Ig().a("forumRecommend_cache_key", new d(this, new com.baidu.tieba.enterForum.b.b()));
    }

    private com.baidu.adp.lib.cache.t<byte[]> Ig() {
        return com.baidu.tbadk.core.b.a.rI().V("tb_forum_recommend", TbadkCoreApplication.getCurrentAccountName());
    }

    public void eG(int i) {
        com.baidu.tbadk.core.sharedPref.b.sl().putInt("shared_key_forum_column_type_" + TbadkCoreApplication.getCurrentAccount(), i);
    }

    public int eH(int i) {
        return com.baidu.tbadk.core.sharedPref.b.sl().getInt("shared_key_forum_column_type_" + TbadkCoreApplication.getCurrentAccount(), i);
    }

    public boolean hasShowForumEditGuide() {
        return com.baidu.tbadk.core.sharedPref.b.sl().getString(new StringBuilder("shared_key_forum_edit_guide_").append(TbadkCoreApplication.getCurrentAccount()).toString(), "").equals(TbConfig.getVersion());
    }

    public void K(List<ae> list) {
        if (list != null) {
            StringBuilder sb = new StringBuilder();
            for (ae aeVar : list) {
                if (aeVar != null) {
                    sb.append(aeVar.getId()).append("#");
                }
            }
            com.baidu.tbadk.core.sharedPref.b.sl().putString("shared_key_forum_sort" + TbadkCoreApplication.getCurrentAccount(), sb.toString());
        }
    }

    public String[] Ih() {
        return com.baidu.tbadk.core.sharedPref.b.sl().getString("shared_key_forum_sort" + TbadkCoreApplication.getCurrentAccount(), "").split("#");
    }

    public List<ae> a(List<ae> list, String[] strArr) {
        ArrayList arrayList = new ArrayList();
        if (list == null || list.isEmpty()) {
            return arrayList;
        }
        if (strArr == null || strArr.length == 0) {
            arrayList.addAll(list);
        } else {
            for (String str : strArr) {
                for (ae aeVar : list) {
                    if (aeVar != null && aeVar.getId() != null && aeVar.getId().equals(str)) {
                        arrayList.add(aeVar);
                    }
                }
            }
            for (int size = list.size() - 1; size >= 0; size--) {
                ae aeVar2 = list.get(size);
                if (!arrayList.contains(aeVar2)) {
                    arrayList.add(0, aeVar2);
                }
            }
        }
        return arrayList;
    }

    public List<ae> L(List<ae> list) {
        if (list != null && !list.isEmpty()) {
            Collections.sort(list, new f(this));
        }
        return list;
    }

    public void O(long j) {
        com.baidu.tbadk.core.sharedPref.b.sl().putLong("last_close_recommend_time@" + TbadkCoreApplication.getCurrentAccount(), j);
    }

    public long Ii() {
        return com.baidu.tbadk.core.sharedPref.b.sl().getLong("last_close_recommend_time@" + TbadkCoreApplication.getCurrentAccount(), 0L);
    }

    public boolean P(long j) {
        return System.currentTimeMillis() - j > TbConfig.APP_OVERDUR_DRAFT_BOX;
    }

    public boolean b(List<ae> list, List<ae> list2) {
        if (list == null && list2 == null) {
            return true;
        }
        if (list == null || list2 == null) {
            return false;
        }
        if (list.size() != list2.size()) {
            return false;
        }
        int size = list.size();
        for (int i = 0; i < size; i++) {
            ae aeVar = list.get(i);
            ae aeVar2 = list2.get(i);
            if (aeVar != null && aeVar2 != null) {
                if (!aeVar.getId().equals(aeVar2.getId())) {
                    return false;
                }
            } else if (aeVar == null || aeVar2 == null) {
                return false;
            }
        }
        return true;
    }
}
