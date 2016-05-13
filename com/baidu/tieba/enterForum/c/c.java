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
import com.baidu.tieba.enterForum.b.h;
import com.baidu.tieba.enterForum.home.forumRecommendHttpResponseMessage;
import com.baidu.tieba.enterForum.home.forumRecommendRequestMessage;
import com.baidu.tieba.enterForum.home.forumRecommendSocketResponseMessage;
import com.baidu.tieba.t;
import com.baidu.tieba.tbadkCore.w;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/* loaded from: classes.dex */
public class c extends com.baidu.adp.base.e {
    private TbPageContext Do;
    private com.baidu.tieba.enterForum.b.b aXU;
    private boolean aXV;
    private b aXW;
    private com.baidu.tieba.tbadkCore.d.b aXX;
    private long aXY;
    private long aXZ;
    private long aYa;
    private long aYb;
    private Handler mUIHandler;

    /* loaded from: classes.dex */
    public interface b {
        void a(a aVar);
    }

    /* loaded from: classes.dex */
    public class a {
        public String aYf = "";
        public boolean aYg = false;
        public int type = -1;
        public com.baidu.tieba.enterForum.b.b aYh = null;

        public a() {
        }
    }

    public c(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.aXU = null;
        this.aXV = true;
        this.aXW = null;
        this.aXX = null;
        this.aXY = 0L;
        this.aXZ = 0L;
        this.aYa = 0L;
        this.aYb = 0L;
        this.mUIHandler = null;
        this.Do = tbPageContext;
        setUniqueId(BdUniqueId.gen());
        this.mUIHandler = new Handler(Looper.getMainLooper());
    }

    @Override // com.baidu.adp.base.e
    public BdUniqueId getUniqueId() {
        return this.unique_id;
    }

    public long MO() {
        return this.aYb;
    }

    public long MP() {
        return this.aXZ;
    }

    public long MQ() {
        return this.aYa;
    }

    public long MR() {
        return this.aXY;
    }

    public com.baidu.tieba.enterForum.b.b MS() {
        return this.aXU;
    }

    public void d(com.baidu.tieba.enterForum.b.b bVar) {
        this.aXU = bVar;
    }

    public void a(b bVar) {
        this.aXW = bVar;
    }

    @Override // com.baidu.adp.base.e
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.e
    public boolean cancelLoadData() {
        cancelMessage();
        MT();
        return true;
    }

    private void MT() {
        if (this.aXX != null) {
            this.aXX.destory();
            this.aXX = null;
        }
    }

    public boolean cu(boolean z) {
        cancelLoadData();
        this.aXV = z;
        forumRecommendRequestMessage forumrecommendrequestmessage = new forumRecommendRequestMessage();
        forumrecommendrequestmessage.set_like_forum(Integer.valueOf(z ? 1 : 0));
        forumrecommendrequestmessage.set_topic(0);
        forumrecommendrequestmessage.set_recommend(1);
        this.aXY = System.currentTimeMillis();
        if (this.aXX == null) {
            this.aXX = new com.baidu.tieba.tbadkCore.d.b("forumrecommendStat");
        }
        sendMessage(forumrecommendrequestmessage);
        return true;
    }

    public boolean cv(boolean z) {
        this.aXV = z;
        MU();
        return true;
    }

    public void a(boolean z, int i, String str, boolean z2, int i2, long j, long j2) {
        a aVar = new a();
        boolean z3 = !z;
        if (this.aXX != null) {
            this.aXX.a(z2, z3, i, str, i2, j, j2);
            this.aXX = null;
        }
        this.aXU.cp(false);
        if (z || !this.aXU.isSuccess()) {
            if (str != null && str.length() > 0) {
                setErrorString(str);
                aVar.aYf = str;
            }
            aVar.type = 1;
            aVar.aYg = false;
            aVar.aYh = this.aXU;
            this.aXW.a(aVar);
            return;
        }
        aVar.type = 1;
        aVar.aYg = true;
        aVar.aYh = this.aXU;
        this.aXW.a(aVar);
    }

    public void a(forumRecommendSocketResponseMessage forumrecommendsocketresponsemessage) {
        String errorString;
        int downSize = forumrecommendsocketresponsemessage.getDownSize();
        long costTime = forumrecommendsocketresponsemessage.getCostTime();
        if (StringUtils.isNull(forumrecommendsocketresponsemessage.getErrorString())) {
            errorString = TbadkCoreApplication.m11getInst().getApp().getResources().getString(t.j.neterror);
        } else {
            errorString = forumrecommendsocketresponsemessage.getErrorString();
        }
        a(forumrecommendsocketresponsemessage, forumrecommendsocketresponsemessage.hasError(), forumrecommendsocketresponsemessage.getError(), errorString, false, downSize, 0L, costTime);
    }

    public void a(forumRecommendHttpResponseMessage forumrecommendhttpresponsemessage) {
        String errorString;
        int downSize = forumrecommendhttpresponsemessage.getDownSize();
        long costTime = forumrecommendhttpresponsemessage.getCostTime();
        if (StringUtils.isNull(forumrecommendhttpresponsemessage.getErrorString())) {
            errorString = TbadkCoreApplication.m11getInst().getApp().getResources().getString(t.j.neterror);
        } else {
            errorString = forumrecommendhttpresponsemessage.getErrorString();
        }
        a(forumrecommendhttpresponsemessage, forumrecommendhttpresponsemessage.hasError(), forumrecommendhttpresponsemessage.getError(), errorString, true, downSize, costTime, 0L);
    }

    public void a(ResponsedMessage<?> responsedMessage, boolean z, int i, String str, boolean z2, int i2, long j, long j2) {
        if (z) {
            this.aXU = null;
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
                this.aXU = new com.baidu.tieba.enterForum.b.b();
                this.aXU.setTime(forumrecommendhttpresponsemessage.GetIsLogin().intValue());
                this.aXU.fK(forumrecommendhttpresponsemessage.GetMsignValid().intValue());
                this.aXU.hm(forumrecommendhttpresponsemessage.GetMsignText());
                this.aXU.fL(forumrecommendhttpresponsemessage.GetMsignLevel().intValue());
                this.aXU.setIsMem(forumrecommendhttpresponsemessage.GetIsMem().intValue());
                this.aXU.fJ(forumrecommendhttpresponsemessage.GetIsLogin().intValue());
                this.aXU.cp(false);
                this.aXU.fI(forumrecommendhttpresponsemessage.getRedirect());
                com.baidu.tieba.enterForum.b.d dVar = new com.baidu.tieba.enterForum.b.d();
                dVar.setLevel(forumrecommendhttpresponsemessage.GetMsignLevel().intValue());
                dVar.N(forumrecommendhttpresponsemessage.GetLikeForum());
                this.aXU.a(dVar);
                com.baidu.tieba.enterForum.b.g gVar = new com.baidu.tieba.enterForum.b.g();
                gVar.O(forumrecommendhttpresponsemessage.GetRecommendForumInfoList());
                this.aXU.a(gVar);
                h hVar = new h();
                hVar.N(forumrecommendhttpresponsemessage.GetBanner());
                this.aXU.a(hVar);
                h hVar2 = new h();
                hVar2.N(forumrecommendhttpresponsemessage.getNewBannerInfo());
                this.aXU.b(hVar2);
                this.aXU.av(true);
                this.aXU.a(forumrecommendhttpresponsemessage.getHotSearchInfoData());
            } catch (Exception e) {
                this.aXU.av(false);
                BdLog.e(e.getMessage());
            }
        }
    }

    public void b(forumRecommendSocketResponseMessage forumrecommendsocketresponsemessage) {
        if (forumrecommendsocketresponsemessage != null) {
            try {
                this.aXU = new com.baidu.tieba.enterForum.b.b();
                this.aXU.setTime(forumrecommendsocketresponsemessage.GetIsLogin().intValue());
                this.aXU.fK(forumrecommendsocketresponsemessage.GetMsignValid().intValue());
                this.aXU.hm(forumrecommendsocketresponsemessage.GetMsignText());
                this.aXU.fL(forumrecommendsocketresponsemessage.GetMsignLevel().intValue());
                this.aXU.setIsMem(forumrecommendsocketresponsemessage.GetIsMem().intValue());
                this.aXU.fJ(forumrecommendsocketresponsemessage.GetIsLogin().intValue());
                this.aXU.cp(false);
                this.aXU.fI(forumrecommendsocketresponsemessage.getRedirect());
                com.baidu.tieba.enterForum.b.d dVar = new com.baidu.tieba.enterForum.b.d();
                dVar.setLevel(forumrecommendsocketresponsemessage.GetMsignLevel().intValue());
                dVar.N(forumrecommendsocketresponsemessage.GetLikeForum());
                this.aXU.a(dVar);
                com.baidu.tieba.enterForum.b.g gVar = new com.baidu.tieba.enterForum.b.g();
                gVar.O(forumrecommendsocketresponsemessage.GetRecommendForumInfoList());
                this.aXU.a(gVar);
                h hVar = new h();
                hVar.N(forumrecommendsocketresponsemessage.GetBanner());
                this.aXU.a(hVar);
                h hVar2 = new h();
                hVar2.N(forumrecommendsocketresponsemessage.getNewBannerInfo());
                this.aXU.b(hVar2);
                this.aXU.av(true);
                this.aXU.a(forumrecommendsocketresponsemessage.getHotSearchInfoData());
            } catch (Exception e) {
                this.aXU.av(false);
                BdLog.e(e.getMessage());
            }
        }
    }

    private void MU() {
        MV().a("forumRecommend_cache_key", new d(this, new com.baidu.tieba.enterForum.b.b()));
    }

    private o<byte[]> MV() {
        return com.baidu.tbadk.core.b.a.rS().N("tb_forum_recommend", TbadkCoreApplication.getCurrentAccountName());
    }

    public void fP(int i) {
        com.baidu.tbadk.core.sharedPref.b.sR().putInt("shared_key_forum_column_type_" + TbadkCoreApplication.getCurrentAccount(), i);
    }

    public int fQ(int i) {
        return com.baidu.tbadk.core.sharedPref.b.sR().getInt("shared_key_forum_column_type_" + TbadkCoreApplication.getCurrentAccount(), i);
    }

    public void Q(List<w> list) {
        if (list != null) {
            StringBuilder sb = new StringBuilder();
            for (w wVar : list) {
                if (wVar != null) {
                    sb.append(wVar.getId()).append("#");
                }
            }
            com.baidu.tbadk.core.sharedPref.b.sR().putString("shared_key_forum_sort" + TbadkCoreApplication.getCurrentAccount(), sb.toString());
        }
    }

    public String[] MW() {
        return com.baidu.tbadk.core.sharedPref.b.sR().getString("shared_key_forum_sort" + TbadkCoreApplication.getCurrentAccount(), "").split("#");
    }

    public List<w> a(List<w> list, String[] strArr) {
        ArrayList arrayList = new ArrayList();
        if (list == null || list.isEmpty()) {
            return arrayList;
        }
        if (strArr == null || strArr.length == 0) {
            arrayList.addAll(list);
        } else {
            for (String str : strArr) {
                for (w wVar : list) {
                    if (wVar != null && wVar.getId() != null && wVar.getId().equals(str)) {
                        arrayList.add(wVar);
                    }
                }
            }
            for (int size = list.size() - 1; size >= 0; size--) {
                w wVar2 = list.get(size);
                if (!arrayList.contains(wVar2)) {
                    arrayList.add(0, wVar2);
                }
            }
        }
        return arrayList;
    }

    public List<w> R(List<w> list) {
        if (list != null && !list.isEmpty()) {
            Collections.sort(list, new f(this));
        }
        return list;
    }

    public void ax(long j) {
        com.baidu.tbadk.core.sharedPref.b.sR().putLong("last_close_recommend_time@" + TbadkCoreApplication.getCurrentAccount(), j);
    }

    public long MX() {
        return com.baidu.tbadk.core.sharedPref.b.sR().getLong("last_close_recommend_time@" + TbadkCoreApplication.getCurrentAccount(), 0L);
    }

    public boolean ay(long j) {
        return System.currentTimeMillis() - j > TbConfig.APP_OVERDUR_DRAFT_BOX;
    }

    public boolean c(List<w> list, List<w> list2) {
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
            w wVar = list.get(i);
            w wVar2 = list2.get(i);
            if (wVar != null && wVar2 != null) {
                if (!wVar.getId().equals(wVar2.getId())) {
                    return false;
                }
            } else if (wVar == null || wVar2 == null) {
                return false;
            }
        }
        return true;
    }
}
