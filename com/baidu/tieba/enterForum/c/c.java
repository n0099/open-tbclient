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
import com.baidu.tieba.tbadkCore.v;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/* loaded from: classes.dex */
public class c extends com.baidu.adp.base.e {
    private TbPageContext MX;
    private com.baidu.tieba.enterForum.b.b bbL;
    private boolean bbM;
    private b bbN;
    private com.baidu.tieba.tbadkCore.d.b bbO;
    private long bbP;
    private long bbQ;
    private long bbR;
    private long bbS;
    private Handler mUIHandler;

    /* loaded from: classes.dex */
    public interface b {
        void a(a aVar);
    }

    /* loaded from: classes.dex */
    public class a {
        public String bbW = "";
        public boolean bbX = false;
        public int type = -1;
        public com.baidu.tieba.enterForum.b.b bbY = null;

        public a() {
        }
    }

    public c(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.bbL = null;
        this.bbM = true;
        this.bbN = null;
        this.bbO = null;
        this.bbP = 0L;
        this.bbQ = 0L;
        this.bbR = 0L;
        this.bbS = 0L;
        this.mUIHandler = null;
        this.MX = tbPageContext;
        setUniqueId(BdUniqueId.gen());
        this.mUIHandler = new Handler(Looper.getMainLooper());
    }

    @Override // com.baidu.adp.base.e
    public BdUniqueId getUniqueId() {
        return this.unique_id;
    }

    public long NZ() {
        return this.bbS;
    }

    public long Oa() {
        return this.bbQ;
    }

    public long Ob() {
        return this.bbR;
    }

    public long Oc() {
        return this.bbP;
    }

    public com.baidu.tieba.enterForum.b.b Od() {
        return this.bbL;
    }

    public void c(com.baidu.tieba.enterForum.b.b bVar) {
        this.bbL = bVar;
    }

    public void a(b bVar) {
        this.bbN = bVar;
    }

    @Override // com.baidu.adp.base.e
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.e
    public boolean cancelLoadData() {
        cancelMessage();
        Oe();
        return true;
    }

    private void Oe() {
        if (this.bbO != null) {
            this.bbO.destory();
            this.bbO = null;
        }
    }

    public boolean cn(boolean z) {
        cancelLoadData();
        this.bbM = z;
        forumRecommendRequestMessage forumrecommendrequestmessage = new forumRecommendRequestMessage();
        forumrecommendrequestmessage.set_like_forum(Integer.valueOf(z ? 1 : 0));
        forumrecommendrequestmessage.set_topic(0);
        forumrecommendrequestmessage.set_recommend(1);
        this.bbP = System.currentTimeMillis();
        if (this.bbO == null) {
            this.bbO = new com.baidu.tieba.tbadkCore.d.b("forumrecommendStat");
        }
        sendMessage(forumrecommendrequestmessage);
        return true;
    }

    public boolean co(boolean z) {
        this.bbM = z;
        Of();
        return true;
    }

    public void a(boolean z, int i, String str, boolean z2, int i2, long j, long j2) {
        a aVar = new a();
        boolean z3 = !z;
        if (this.bbO != null) {
            this.bbO.a(z2, z3, i, str, i2, j, j2);
            this.bbO = null;
        }
        this.bbL.ci(false);
        if (z || !this.bbL.isSuccess()) {
            if (str != null && str.length() > 0) {
                setErrorString(str);
                aVar.bbW = str;
            }
            aVar.type = 1;
            aVar.bbX = false;
            aVar.bbY = this.bbL;
            this.bbN.a(aVar);
            return;
        }
        aVar.type = 1;
        aVar.bbX = true;
        aVar.bbY = this.bbL;
        this.bbN.a(aVar);
    }

    public void a(forumRecommendSocketResponseMessage forumrecommendsocketresponsemessage) {
        String errorString;
        int downSize = forumrecommendsocketresponsemessage.getDownSize();
        long costTime = forumrecommendsocketresponsemessage.getCostTime();
        if (StringUtils.isNull(forumrecommendsocketresponsemessage.getErrorString())) {
            errorString = TbadkCoreApplication.m411getInst().getApp().getResources().getString(t.j.neterror);
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
            errorString = TbadkCoreApplication.m411getInst().getApp().getResources().getString(t.j.neterror);
        } else {
            errorString = forumrecommendhttpresponsemessage.getErrorString();
        }
        a(forumrecommendhttpresponsemessage, forumrecommendhttpresponsemessage.hasError(), forumrecommendhttpresponsemessage.getError(), errorString, true, downSize, costTime, 0L);
    }

    public void a(ResponsedMessage<?> responsedMessage, boolean z, int i, String str, boolean z2, int i2, long j, long j2) {
        if (z) {
            this.bbL = null;
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
                this.bbL = new com.baidu.tieba.enterForum.b.b();
                this.bbL.setTime(forumrecommendhttpresponsemessage.GetIsLogin().intValue());
                this.bbL.ge(forumrecommendhttpresponsemessage.GetMsignValid().intValue());
                this.bbL.hm(forumrecommendhttpresponsemessage.GetMsignText());
                this.bbL.gf(forumrecommendhttpresponsemessage.GetMsignLevel().intValue());
                this.bbL.setIsMem(forumrecommendhttpresponsemessage.GetIsMem().intValue());
                this.bbL.gd(forumrecommendhttpresponsemessage.GetIsLogin().intValue());
                this.bbL.ci(false);
                this.bbL.gc(forumrecommendhttpresponsemessage.getRedirect());
                com.baidu.tieba.enterForum.b.d dVar = new com.baidu.tieba.enterForum.b.d();
                dVar.setLevel(forumrecommendhttpresponsemessage.GetMsignLevel().intValue());
                dVar.M(forumrecommendhttpresponsemessage.GetLikeForum());
                this.bbL.a(dVar);
                com.baidu.tieba.enterForum.b.g gVar = new com.baidu.tieba.enterForum.b.g();
                gVar.N(forumrecommendhttpresponsemessage.GetRecommendForumInfoList());
                this.bbL.a(gVar);
                h hVar = new h();
                hVar.M(forumrecommendhttpresponsemessage.GetBanner());
                this.bbL.a(hVar);
                h hVar2 = new h();
                hVar2.M(forumrecommendhttpresponsemessage.getNewBannerInfo());
                this.bbL.b(hVar2);
                this.bbL.as(true);
                this.bbL.a(forumrecommendhttpresponsemessage.getHotSearchInfoData());
            } catch (Exception e) {
                this.bbL.as(false);
                BdLog.e(e.getMessage());
            }
        }
    }

    public void b(forumRecommendSocketResponseMessage forumrecommendsocketresponsemessage) {
        if (forumrecommendsocketresponsemessage != null) {
            try {
                this.bbL = new com.baidu.tieba.enterForum.b.b();
                this.bbL.setTime(forumrecommendsocketresponsemessage.GetIsLogin().intValue());
                this.bbL.ge(forumrecommendsocketresponsemessage.GetMsignValid().intValue());
                this.bbL.hm(forumrecommendsocketresponsemessage.GetMsignText());
                this.bbL.gf(forumrecommendsocketresponsemessage.GetMsignLevel().intValue());
                this.bbL.setIsMem(forumrecommendsocketresponsemessage.GetIsMem().intValue());
                this.bbL.gd(forumrecommendsocketresponsemessage.GetIsLogin().intValue());
                this.bbL.ci(false);
                com.baidu.tieba.enterForum.b.d dVar = new com.baidu.tieba.enterForum.b.d();
                dVar.setLevel(forumrecommendsocketresponsemessage.GetMsignLevel().intValue());
                dVar.M(forumrecommendsocketresponsemessage.GetLikeForum());
                this.bbL.a(dVar);
                com.baidu.tieba.enterForum.b.g gVar = new com.baidu.tieba.enterForum.b.g();
                gVar.N(forumrecommendsocketresponsemessage.GetRecommendForumInfoList());
                this.bbL.a(gVar);
                h hVar = new h();
                hVar.M(forumrecommendsocketresponsemessage.GetBanner());
                this.bbL.a(hVar);
                h hVar2 = new h();
                hVar2.M(forumrecommendsocketresponsemessage.getNewBannerInfo());
                this.bbL.b(hVar2);
                this.bbL.as(true);
                this.bbL.a(forumrecommendsocketresponsemessage.getHotSearchInfoData());
            } catch (Exception e) {
                this.bbL.as(false);
                BdLog.e(e.getMessage());
            }
        }
    }

    private void Of() {
        Og().a("forumRecommend_cache_key", new d(this, new com.baidu.tieba.enterForum.b.b()));
    }

    private o<byte[]> Og() {
        return com.baidu.tbadk.core.b.a.um().N("tb_forum_recommend", TbadkCoreApplication.getCurrentAccountName());
    }

    public void gi(int i) {
        com.baidu.tbadk.core.sharedPref.b.vk().putInt("shared_key_forum_column_type_" + TbadkCoreApplication.getCurrentAccount(), i);
    }

    public int gj(int i) {
        return com.baidu.tbadk.core.sharedPref.b.vk().getInt("shared_key_forum_column_type_" + TbadkCoreApplication.getCurrentAccount(), i);
    }

    public void P(List<v> list) {
        if (list != null) {
            StringBuilder sb = new StringBuilder();
            for (v vVar : list) {
                if (vVar != null) {
                    sb.append(vVar.getId()).append("#");
                }
            }
            com.baidu.tbadk.core.sharedPref.b.vk().putString("shared_key_forum_sort" + TbadkCoreApplication.getCurrentAccount(), sb.toString());
        }
    }

    public String[] Oh() {
        return com.baidu.tbadk.core.sharedPref.b.vk().getString("shared_key_forum_sort" + TbadkCoreApplication.getCurrentAccount(), "").split("#");
    }

    public List<v> a(List<v> list, String[] strArr) {
        ArrayList arrayList = new ArrayList();
        if (list == null || list.isEmpty()) {
            return arrayList;
        }
        if (strArr == null || strArr.length == 0) {
            arrayList.addAll(list);
        } else {
            for (String str : strArr) {
                for (v vVar : list) {
                    if (vVar != null && vVar.getId() != null && vVar.getId().equals(str)) {
                        arrayList.add(vVar);
                    }
                }
            }
            for (int size = list.size() - 1; size >= 0; size--) {
                v vVar2 = list.get(size);
                if (!arrayList.contains(vVar2)) {
                    arrayList.add(0, vVar2);
                }
            }
        }
        return arrayList;
    }

    public List<v> Q(List<v> list) {
        if (list != null && !list.isEmpty()) {
            Collections.sort(list, new f(this));
        }
        return list;
    }

    public void ax(long j) {
        com.baidu.tbadk.core.sharedPref.b.vk().putLong("last_close_recommend_time@" + TbadkCoreApplication.getCurrentAccount(), j);
    }

    public long Oi() {
        return com.baidu.tbadk.core.sharedPref.b.vk().getLong("last_close_recommend_time@" + TbadkCoreApplication.getCurrentAccount(), 0L);
    }

    public boolean ay(long j) {
        return System.currentTimeMillis() - j > TbConfig.APP_OVERDUR_DRAFT_BOX;
    }

    public boolean c(List<v> list, List<v> list2) {
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
            v vVar = list.get(i);
            v vVar2 = list2.get(i);
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
