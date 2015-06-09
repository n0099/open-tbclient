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
    private com.baidu.tieba.enterForum.b.b aFq;
    private boolean aFr;
    private h aFs;
    private com.baidu.tieba.tbadkCore.e.a aFt;
    private long aFu;
    private long aFv;
    private long aFw;
    private long aFx;
    private Handler mUIHandler;

    public c(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.aFq = null;
        this.aFr = true;
        this.aFs = null;
        this.aFt = null;
        this.aFu = 0L;
        this.aFv = 0L;
        this.aFw = 0L;
        this.aFx = 0L;
        this.mUIHandler = null;
        this.LH = tbPageContext;
        setUniqueId(BdUniqueId.gen());
        this.mUIHandler = new Handler(Looper.getMainLooper());
    }

    @Override // com.baidu.adp.base.f
    public BdUniqueId getUniqueId() {
        return this.unique_id;
    }

    public long Ia() {
        return this.aFx;
    }

    public long Ib() {
        return this.aFv;
    }

    public long Ic() {
        return this.aFw;
    }

    public long Id() {
        return this.aFu;
    }

    public com.baidu.tieba.enterForum.b.b Ie() {
        return this.aFq;
    }

    public void b(com.baidu.tieba.enterForum.b.b bVar) {
        this.aFq = bVar;
    }

    public void a(h hVar) {
        this.aFs = hVar;
    }

    @Override // com.baidu.adp.base.f
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.f
    public boolean cancelLoadData() {
        cancelMessage();
        If();
        return true;
    }

    private void If() {
        if (this.aFt != null) {
            this.aFt.destory();
            this.aFt = null;
        }
    }

    public boolean bJ(boolean z) {
        cancelLoadData();
        this.aFr = z;
        forumRecommendRequestMessage forumrecommendrequestmessage = new forumRecommendRequestMessage();
        forumrecommendrequestmessage.set_like_forum(1);
        forumrecommendrequestmessage.set_topic(0);
        forumrecommendrequestmessage.set_recommend(0);
        this.aFu = System.currentTimeMillis();
        if (this.aFt == null) {
            this.aFt = new com.baidu.tieba.tbadkCore.e.a("forumrecommendStat");
        }
        sendMessage(forumrecommendrequestmessage);
        return true;
    }

    public boolean bK(boolean z) {
        this.aFr = z;
        Ig();
        return true;
    }

    public void a(boolean z, int i, String str, boolean z2, int i2, long j, long j2) {
        g gVar = new g(this);
        boolean z3 = !z;
        if (this.aFt != null) {
            this.aFt.a(z2, z3, i, str, i2, j, j2);
            this.aFt = null;
        }
        this.aFq.bG(false);
        if (z || !this.aFq.isSuccess()) {
            if (str != null && str.length() > 0) {
                setErrorString(str);
                gVar.aFB = str;
            }
            gVar.type = 1;
            gVar.aFC = false;
            gVar.aFD = this.aFq;
            this.aFs.a(gVar);
            return;
        }
        gVar.type = 1;
        gVar.aFC = true;
        gVar.aFD = this.aFq;
        this.aFs.a(gVar);
    }

    public void a(forumRecommendSocketResponseMessage forumrecommendsocketresponsemessage) {
        a(forumrecommendsocketresponsemessage, forumrecommendsocketresponsemessage.hasError(), forumrecommendsocketresponsemessage.getError(), StringUtils.isNull(forumrecommendsocketresponsemessage.getErrorString()) ? this.LH.getResources().getString(t.neterror) : forumrecommendsocketresponsemessage.getErrorString(), false, forumrecommendsocketresponsemessage.getDownSize(), 0L, forumrecommendsocketresponsemessage.getCostTime());
    }

    public void a(forumRecommendHttpResponseMessage forumrecommendhttpresponsemessage) {
        a(forumrecommendhttpresponsemessage, forumrecommendhttpresponsemessage.hasError(), forumrecommendhttpresponsemessage.getError(), StringUtils.isNull(forumrecommendhttpresponsemessage.getErrorString()) ? this.LH.getResources().getString(t.neterror) : forumrecommendhttpresponsemessage.getErrorString(), true, forumrecommendhttpresponsemessage.getDownSize(), forumrecommendhttpresponsemessage.getCostTime(), 0L);
    }

    public void a(ResponsedMessage<?> responsedMessage, boolean z, int i, String str, boolean z2, int i2, long j, long j2) {
        if (z) {
            this.aFq = null;
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
                this.aFq = new com.baidu.tieba.enterForum.b.b();
                this.aFq.setTime(forumrecommendhttpresponsemessage.GetIsLogin().intValue());
                this.aFq.eE(forumrecommendhttpresponsemessage.GetMsignValid().intValue());
                this.aFq.fQ(forumrecommendhttpresponsemessage.GetMsignText());
                this.aFq.eF(forumrecommendhttpresponsemessage.GetMsignLevel().intValue());
                this.aFq.setIsMem(forumrecommendhttpresponsemessage.GetIsMem().intValue());
                this.aFq.eD(forumrecommendhttpresponsemessage.GetIsLogin().intValue());
                this.aFq.bG(false);
                com.baidu.tieba.enterForum.b.c cVar = new com.baidu.tieba.enterForum.b.c();
                cVar.setLevel(forumrecommendhttpresponsemessage.GetMsignLevel().intValue());
                cVar.j(forumrecommendhttpresponsemessage.GetLikeForum());
                this.aFq.a(cVar);
                com.baidu.tieba.enterForum.b.f fVar = new com.baidu.tieba.enterForum.b.f();
                fVar.I(forumrecommendhttpresponsemessage.GetRecommendForumInfoList());
                this.aFq.a(fVar);
                v vVar = new v();
                vVar.j(forumrecommendhttpresponsemessage.GetBanner());
                this.aFq.a(vVar);
                this.aFq.al(true);
            } catch (Exception e) {
                this.aFq.al(false);
                BdLog.e(e.getMessage());
            }
        }
    }

    public void b(forumRecommendSocketResponseMessage forumrecommendsocketresponsemessage) {
        if (forumrecommendsocketresponsemessage != null) {
            try {
                this.aFq = new com.baidu.tieba.enterForum.b.b();
                this.aFq.setTime(forumrecommendsocketresponsemessage.GetIsLogin().intValue());
                this.aFq.eE(forumrecommendsocketresponsemessage.GetMsignValid().intValue());
                this.aFq.fQ(forumrecommendsocketresponsemessage.GetMsignText());
                this.aFq.eF(forumrecommendsocketresponsemessage.GetMsignLevel().intValue());
                this.aFq.setIsMem(forumrecommendsocketresponsemessage.GetIsMem().intValue());
                this.aFq.eD(forumrecommendsocketresponsemessage.GetIsLogin().intValue());
                this.aFq.bG(false);
                com.baidu.tieba.enterForum.b.c cVar = new com.baidu.tieba.enterForum.b.c();
                cVar.setLevel(forumrecommendsocketresponsemessage.GetMsignLevel().intValue());
                cVar.j(forumrecommendsocketresponsemessage.GetLikeForum());
                this.aFq.a(cVar);
                com.baidu.tieba.enterForum.b.f fVar = new com.baidu.tieba.enterForum.b.f();
                fVar.I(forumrecommendsocketresponsemessage.GetRecommendForumInfoList());
                this.aFq.a(fVar);
                v vVar = new v();
                vVar.j(forumrecommendsocketresponsemessage.GetBanner());
                this.aFq.a(vVar);
                this.aFq.al(true);
            } catch (Exception e) {
                this.aFq.al(false);
                BdLog.e(e.getMessage());
            }
        }
    }

    private void Ig() {
        Ih().a("forumRecommend_cache_key", new d(this, new com.baidu.tieba.enterForum.b.b()));
    }

    private com.baidu.adp.lib.cache.t<byte[]> Ih() {
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

    public String[] Ii() {
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

    public long Ij() {
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
