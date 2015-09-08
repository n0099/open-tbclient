package com.baidu.tieba.enterForum.c;

import android.os.Handler;
import android.os.Looper;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.cache.o;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.v;
import com.baidu.tieba.enterForum.home.forumRecommendHttpResponseMessage;
import com.baidu.tieba.enterForum.home.forumRecommendRequestMessage;
import com.baidu.tieba.enterForum.home.forumRecommendSocketResponseMessage;
import com.baidu.tieba.i;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/* loaded from: classes.dex */
public class c extends com.baidu.adp.base.e {
    private com.baidu.tieba.enterForum.b.b aNc;
    private boolean aNd;
    private b aNe;
    private com.baidu.tieba.tbadkCore.e.a aNf;
    private long aNg;
    private long aNh;
    private long aNi;
    private long aNj;
    private TbPageContext mContext;
    private Handler mUIHandler;

    /* loaded from: classes.dex */
    public interface b {
        void a(a aVar);
    }

    /* loaded from: classes.dex */
    public class a {
        public String aNn = "";
        public boolean aNo = false;
        public int type = -1;
        public com.baidu.tieba.enterForum.b.b aNp = null;

        public a() {
        }
    }

    public c(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.aNc = null;
        this.aNd = true;
        this.aNe = null;
        this.aNf = null;
        this.aNg = 0L;
        this.aNh = 0L;
        this.aNi = 0L;
        this.aNj = 0L;
        this.mUIHandler = null;
        this.mContext = tbPageContext;
        setUniqueId(BdUniqueId.gen());
        this.mUIHandler = new Handler(Looper.getMainLooper());
    }

    @Override // com.baidu.adp.base.e
    public BdUniqueId getUniqueId() {
        return this.unique_id;
    }

    public long IB() {
        return this.aNj;
    }

    public long IC() {
        return this.aNh;
    }

    public long ID() {
        return this.aNi;
    }

    public long IE() {
        return this.aNg;
    }

    public com.baidu.tieba.enterForum.b.b IF() {
        return this.aNc;
    }

    public void b(com.baidu.tieba.enterForum.b.b bVar) {
        this.aNc = bVar;
    }

    public void a(b bVar) {
        this.aNe = bVar;
    }

    @Override // com.baidu.adp.base.e
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.e
    public boolean cancelLoadData() {
        cancelMessage();
        IG();
        return true;
    }

    private void IG() {
        if (this.aNf != null) {
            this.aNf.destory();
            this.aNf = null;
        }
    }

    public boolean bQ(boolean z) {
        cancelLoadData();
        this.aNd = z;
        forumRecommendRequestMessage forumrecommendrequestmessage = new forumRecommendRequestMessage();
        forumrecommendrequestmessage.set_like_forum(1);
        forumrecommendrequestmessage.set_topic(0);
        forumrecommendrequestmessage.set_recommend(0);
        this.aNg = System.currentTimeMillis();
        if (this.aNf == null) {
            this.aNf = new com.baidu.tieba.tbadkCore.e.a("forumrecommendStat");
        }
        sendMessage(forumrecommendrequestmessage);
        return true;
    }

    public boolean bR(boolean z) {
        this.aNd = z;
        IH();
        return true;
    }

    public void a(boolean z, int i, String str, boolean z2, int i2, long j, long j2) {
        a aVar = new a();
        boolean z3 = !z;
        if (this.aNf != null) {
            this.aNf.a(z2, z3, i, str, i2, j, j2);
            this.aNf = null;
        }
        this.aNc.bN(false);
        if (z || !this.aNc.isSuccess()) {
            if (str != null && str.length() > 0) {
                setErrorString(str);
                aVar.aNn = str;
            }
            aVar.type = 1;
            aVar.aNo = false;
            aVar.aNp = this.aNc;
            this.aNe.a(aVar);
            return;
        }
        aVar.type = 1;
        aVar.aNo = true;
        aVar.aNp = this.aNc;
        this.aNe.a(aVar);
    }

    public void a(forumRecommendSocketResponseMessage forumrecommendsocketresponsemessage) {
        a(forumrecommendsocketresponsemessage, forumrecommendsocketresponsemessage.hasError(), forumrecommendsocketresponsemessage.getError(), StringUtils.isNull(forumrecommendsocketresponsemessage.getErrorString()) ? TbadkCoreApplication.m411getInst().getApp().getResources().getString(i.h.neterror) : forumrecommendsocketresponsemessage.getErrorString(), false, forumrecommendsocketresponsemessage.getDownSize(), 0L, forumrecommendsocketresponsemessage.getCostTime());
    }

    public void a(forumRecommendHttpResponseMessage forumrecommendhttpresponsemessage) {
        a(forumrecommendhttpresponsemessage, forumrecommendhttpresponsemessage.hasError(), forumrecommendhttpresponsemessage.getError(), StringUtils.isNull(forumrecommendhttpresponsemessage.getErrorString()) ? TbadkCoreApplication.m411getInst().getApp().getResources().getString(i.h.neterror) : forumrecommendhttpresponsemessage.getErrorString(), true, forumrecommendhttpresponsemessage.getDownSize(), forumrecommendhttpresponsemessage.getCostTime(), 0L);
    }

    public void a(ResponsedMessage<?> responsedMessage, boolean z, int i, String str, boolean z2, int i2, long j, long j2) {
        if (z) {
            this.aNc = null;
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
                this.aNc = new com.baidu.tieba.enterForum.b.b();
                this.aNc.setTime(forumrecommendhttpresponsemessage.GetIsLogin().intValue());
                this.aNc.eR(forumrecommendhttpresponsemessage.GetMsignValid().intValue());
                this.aNc.gq(forumrecommendhttpresponsemessage.GetMsignText());
                this.aNc.eS(forumrecommendhttpresponsemessage.GetMsignLevel().intValue());
                this.aNc.setIsMem(forumrecommendhttpresponsemessage.GetIsMem().intValue());
                this.aNc.eQ(forumrecommendhttpresponsemessage.GetIsLogin().intValue());
                this.aNc.bN(false);
                com.baidu.tieba.enterForum.b.c cVar = new com.baidu.tieba.enterForum.b.c();
                cVar.setLevel(forumrecommendhttpresponsemessage.GetMsignLevel().intValue());
                cVar.k(forumrecommendhttpresponsemessage.GetLikeForum());
                this.aNc.a(cVar);
                com.baidu.tieba.enterForum.b.f fVar = new com.baidu.tieba.enterForum.b.f();
                fVar.I(forumrecommendhttpresponsemessage.GetRecommendForumInfoList());
                this.aNc.a(fVar);
                v vVar = new v();
                vVar.k(forumrecommendhttpresponsemessage.GetBanner());
                this.aNc.a(vVar);
                this.aNc.ap(true);
            } catch (Exception e) {
                this.aNc.ap(false);
                BdLog.e(e.getMessage());
            }
        }
    }

    public void b(forumRecommendSocketResponseMessage forumrecommendsocketresponsemessage) {
        if (forumrecommendsocketresponsemessage != null) {
            try {
                this.aNc = new com.baidu.tieba.enterForum.b.b();
                this.aNc.setTime(forumrecommendsocketresponsemessage.GetIsLogin().intValue());
                this.aNc.eR(forumrecommendsocketresponsemessage.GetMsignValid().intValue());
                this.aNc.gq(forumrecommendsocketresponsemessage.GetMsignText());
                this.aNc.eS(forumrecommendsocketresponsemessage.GetMsignLevel().intValue());
                this.aNc.setIsMem(forumrecommendsocketresponsemessage.GetIsMem().intValue());
                this.aNc.eQ(forumrecommendsocketresponsemessage.GetIsLogin().intValue());
                this.aNc.bN(false);
                com.baidu.tieba.enterForum.b.c cVar = new com.baidu.tieba.enterForum.b.c();
                cVar.setLevel(forumrecommendsocketresponsemessage.GetMsignLevel().intValue());
                cVar.k(forumrecommendsocketresponsemessage.GetLikeForum());
                this.aNc.a(cVar);
                com.baidu.tieba.enterForum.b.f fVar = new com.baidu.tieba.enterForum.b.f();
                fVar.I(forumrecommendsocketresponsemessage.GetRecommendForumInfoList());
                this.aNc.a(fVar);
                v vVar = new v();
                vVar.k(forumrecommendsocketresponsemessage.GetBanner());
                this.aNc.a(vVar);
                this.aNc.ap(true);
            } catch (Exception e) {
                this.aNc.ap(false);
                BdLog.e(e.getMessage());
            }
        }
    }

    private void IH() {
        II().a("forumRecommend_cache_key", new d(this, new com.baidu.tieba.enterForum.b.b()));
    }

    private o<byte[]> II() {
        return com.baidu.tbadk.core.b.a.sR().U("tb_forum_recommend", TbadkCoreApplication.getCurrentAccountName());
    }

    public void eT(int i) {
        com.baidu.tbadk.core.sharedPref.b.tx().putInt("shared_key_forum_column_type_" + TbadkCoreApplication.getCurrentAccount(), i);
    }

    public int eU(int i) {
        return com.baidu.tbadk.core.sharedPref.b.tx().getInt("shared_key_forum_column_type_" + TbadkCoreApplication.getCurrentAccount(), i);
    }

    public boolean hasShowForumEditGuide() {
        return com.baidu.tbadk.core.sharedPref.b.tx().getString(new StringBuilder("shared_key_forum_edit_guide_").append(TbadkCoreApplication.getCurrentAccount()).toString(), "").equals(TbConfig.getVersion());
    }

    public void K(List<com.baidu.tieba.tbadkCore.v> list) {
        if (list != null) {
            StringBuilder sb = new StringBuilder();
            for (com.baidu.tieba.tbadkCore.v vVar : list) {
                if (vVar != null) {
                    sb.append(vVar.getId()).append("#");
                }
            }
            com.baidu.tbadk.core.sharedPref.b.tx().putString("shared_key_forum_sort" + TbadkCoreApplication.getCurrentAccount(), sb.toString());
        }
    }

    public String[] IJ() {
        return com.baidu.tbadk.core.sharedPref.b.tx().getString("shared_key_forum_sort" + TbadkCoreApplication.getCurrentAccount(), "").split("#");
    }

    public List<com.baidu.tieba.tbadkCore.v> a(List<com.baidu.tieba.tbadkCore.v> list, String[] strArr) {
        ArrayList arrayList = new ArrayList();
        if (list == null || list.isEmpty()) {
            return arrayList;
        }
        if (strArr == null || strArr.length == 0) {
            arrayList.addAll(list);
        } else {
            for (String str : strArr) {
                for (com.baidu.tieba.tbadkCore.v vVar : list) {
                    if (vVar != null && vVar.getId() != null && vVar.getId().equals(str)) {
                        arrayList.add(vVar);
                    }
                }
            }
            for (int size = list.size() - 1; size >= 0; size--) {
                com.baidu.tieba.tbadkCore.v vVar2 = list.get(size);
                if (!arrayList.contains(vVar2)) {
                    arrayList.add(0, vVar2);
                }
            }
        }
        return arrayList;
    }

    public List<com.baidu.tieba.tbadkCore.v> L(List<com.baidu.tieba.tbadkCore.v> list) {
        if (list != null && !list.isEmpty()) {
            Collections.sort(list, new f(this));
        }
        return list;
    }

    public void R(long j) {
        com.baidu.tbadk.core.sharedPref.b.tx().putLong("last_close_recommend_time@" + TbadkCoreApplication.getCurrentAccount(), j);
    }

    public long IK() {
        return com.baidu.tbadk.core.sharedPref.b.tx().getLong("last_close_recommend_time@" + TbadkCoreApplication.getCurrentAccount(), 0L);
    }

    public boolean S(long j) {
        return System.currentTimeMillis() - j > TbConfig.APP_OVERDUR_DRAFT_BOX;
    }

    public boolean b(List<com.baidu.tieba.tbadkCore.v> list, List<com.baidu.tieba.tbadkCore.v> list2) {
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
            com.baidu.tieba.tbadkCore.v vVar = list.get(i);
            com.baidu.tieba.tbadkCore.v vVar2 = list2.get(i);
            if (vVar != null && vVar2 != null) {
                if (!vVar.getId().equals(vVar2.getId())) {
                    return false;
                }
            } else if (vVar == null || vVar2 == null) {
                return false;
            }
        }
        return true;
    }
}
