package com.baidu.tieba.enterForum.c;

import android.os.Handler;
import android.os.Looper;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.cache.o;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.plugin.proxy.ContentProviderProxy;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.enterForum.b.h;
import com.baidu.tieba.enterForum.home.forumRecommendHttpResponseMessage;
import com.baidu.tieba.enterForum.home.forumRecommendRequestMessage;
import com.baidu.tieba.enterForum.home.forumRecommendSocketResponseMessage;
import com.baidu.tieba.n;
import com.baidu.tieba.tbadkCore.w;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/* loaded from: classes.dex */
public class c extends com.baidu.adp.base.e {
    private com.baidu.tieba.enterForum.b.b aUQ;
    private boolean aUR;
    private b aUS;
    private com.baidu.tieba.tbadkCore.d.a aUT;
    private long aUU;
    private long aUV;
    private long aUW;
    private long aUX;
    private TbPageContext mContext;
    private Handler mUIHandler;

    /* loaded from: classes.dex */
    public interface b {
        void a(a aVar);
    }

    /* loaded from: classes.dex */
    public class a {
        public String aVb = "";
        public boolean aVc = false;
        public int type = -1;
        public com.baidu.tieba.enterForum.b.b aVd = null;

        public a() {
        }
    }

    public c(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.aUQ = null;
        this.aUR = true;
        this.aUS = null;
        this.aUT = null;
        this.aUU = 0L;
        this.aUV = 0L;
        this.aUW = 0L;
        this.aUX = 0L;
        this.mUIHandler = null;
        this.mContext = tbPageContext;
        setUniqueId(BdUniqueId.gen());
        this.mUIHandler = new Handler(Looper.getMainLooper());
    }

    @Override // com.baidu.adp.base.e
    public BdUniqueId getUniqueId() {
        return this.unique_id;
    }

    public long Ku() {
        return this.aUX;
    }

    public long Kv() {
        return this.aUV;
    }

    public long Kw() {
        return this.aUW;
    }

    public long Kx() {
        return this.aUU;
    }

    public com.baidu.tieba.enterForum.b.b Ky() {
        return this.aUQ;
    }

    public void b(com.baidu.tieba.enterForum.b.b bVar) {
        this.aUQ = bVar;
    }

    public void a(b bVar) {
        this.aUS = bVar;
    }

    @Override // com.baidu.adp.base.e
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.e
    public boolean cancelLoadData() {
        cancelMessage();
        Kz();
        return true;
    }

    private void Kz() {
        if (this.aUT != null) {
            this.aUT.destory();
            this.aUT = null;
        }
    }

    public boolean cd(boolean z) {
        cancelLoadData();
        this.aUR = z;
        forumRecommendRequestMessage forumrecommendrequestmessage = new forumRecommendRequestMessage();
        forumrecommendrequestmessage.set_like_forum(Integer.valueOf(z ? 1 : 0));
        forumrecommendrequestmessage.set_topic(0);
        forumrecommendrequestmessage.set_recommend(1);
        this.aUU = System.currentTimeMillis();
        if (this.aUT == null) {
            this.aUT = new com.baidu.tieba.tbadkCore.d.a("forumrecommendStat");
        }
        sendMessage(forumrecommendrequestmessage);
        return true;
    }

    public boolean ce(boolean z) {
        this.aUR = z;
        KA();
        return true;
    }

    public void a(boolean z, int i, String str, boolean z2, int i2, long j, long j2) {
        a aVar = new a();
        boolean z3 = !z;
        if (this.aUT != null) {
            this.aUT.a(z2, z3, i, str, i2, j, j2);
            this.aUT = null;
        }
        this.aUQ.bY(false);
        if (z || !this.aUQ.isSuccess()) {
            if (str != null && str.length() > 0) {
                setErrorString(str);
                aVar.aVb = str;
            }
            aVar.type = 1;
            aVar.aVc = false;
            aVar.aVd = this.aUQ;
            this.aUS.a(aVar);
            return;
        }
        aVar.type = 1;
        aVar.aVc = true;
        aVar.aVd = this.aUQ;
        this.aUS.a(aVar);
    }

    public void a(forumRecommendSocketResponseMessage forumrecommendsocketresponsemessage) {
        String errorString;
        int downSize = forumrecommendsocketresponsemessage.getDownSize();
        long costTime = forumrecommendsocketresponsemessage.getCostTime();
        if (StringUtils.isNull(forumrecommendsocketresponsemessage.getErrorString())) {
            errorString = TbadkCoreApplication.m411getInst().getApp().getResources().getString(n.j.neterror);
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
            errorString = TbadkCoreApplication.m411getInst().getApp().getResources().getString(n.j.neterror);
        } else {
            errorString = forumrecommendhttpresponsemessage.getErrorString();
        }
        a(forumrecommendhttpresponsemessage, forumrecommendhttpresponsemessage.hasError(), forumrecommendhttpresponsemessage.getError(), errorString, true, downSize, costTime, 0L);
    }

    public void a(ResponsedMessage<?> responsedMessage, boolean z, int i, String str, boolean z2, int i2, long j, long j2) {
        if (z) {
            this.aUQ = null;
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
                this.aUQ = new com.baidu.tieba.enterForum.b.b();
                this.aUQ.setTime(forumrecommendhttpresponsemessage.GetIsLogin().intValue());
                this.aUQ.fp(forumrecommendhttpresponsemessage.GetMsignValid().intValue());
                this.aUQ.gV(forumrecommendhttpresponsemessage.GetMsignText());
                this.aUQ.fq(forumrecommendhttpresponsemessage.GetMsignLevel().intValue());
                this.aUQ.setIsMem(forumrecommendhttpresponsemessage.GetIsMem().intValue());
                this.aUQ.fo(forumrecommendhttpresponsemessage.GetIsLogin().intValue());
                this.aUQ.bY(false);
                this.aUQ.fn(forumrecommendhttpresponsemessage.getRedirect());
                com.baidu.tieba.enterForum.b.d dVar = new com.baidu.tieba.enterForum.b.d();
                dVar.setLevel(forumrecommendhttpresponsemessage.GetMsignLevel().intValue());
                dVar.L(forumrecommendhttpresponsemessage.GetLikeForum());
                this.aUQ.a(dVar);
                com.baidu.tieba.enterForum.b.g gVar = new com.baidu.tieba.enterForum.b.g();
                gVar.M(forumrecommendhttpresponsemessage.GetRecommendForumInfoList());
                this.aUQ.a(gVar);
                h hVar = new h();
                hVar.L(forumrecommendhttpresponsemessage.GetBanner());
                this.aUQ.a(hVar);
                this.aUQ.ap(true);
                this.aUQ.a(forumrecommendhttpresponsemessage.getHotSearchInfoData());
            } catch (Exception e) {
                this.aUQ.ap(false);
                BdLog.e(e.getMessage());
            }
        }
    }

    public void b(forumRecommendSocketResponseMessage forumrecommendsocketresponsemessage) {
        if (forumrecommendsocketresponsemessage != null) {
            try {
                this.aUQ = new com.baidu.tieba.enterForum.b.b();
                this.aUQ.setTime(forumrecommendsocketresponsemessage.GetIsLogin().intValue());
                this.aUQ.fp(forumrecommendsocketresponsemessage.GetMsignValid().intValue());
                this.aUQ.gV(forumrecommendsocketresponsemessage.GetMsignText());
                this.aUQ.fq(forumrecommendsocketresponsemessage.GetMsignLevel().intValue());
                this.aUQ.setIsMem(forumrecommendsocketresponsemessage.GetIsMem().intValue());
                this.aUQ.fo(forumrecommendsocketresponsemessage.GetIsLogin().intValue());
                this.aUQ.bY(false);
                com.baidu.tieba.enterForum.b.d dVar = new com.baidu.tieba.enterForum.b.d();
                dVar.setLevel(forumrecommendsocketresponsemessage.GetMsignLevel().intValue());
                dVar.L(forumrecommendsocketresponsemessage.GetLikeForum());
                this.aUQ.a(dVar);
                com.baidu.tieba.enterForum.b.g gVar = new com.baidu.tieba.enterForum.b.g();
                gVar.M(forumrecommendsocketresponsemessage.GetRecommendForumInfoList());
                this.aUQ.a(gVar);
                h hVar = new h();
                hVar.L(forumrecommendsocketresponsemessage.GetBanner());
                this.aUQ.a(hVar);
                this.aUQ.ap(true);
                this.aUQ.a(forumrecommendsocketresponsemessage.getHotSearchInfoData());
            } catch (Exception e) {
                this.aUQ.ap(false);
                BdLog.e(e.getMessage());
            }
        }
    }

    private void KA() {
        KB().a("forumRecommend_cache_key", new d(this, new com.baidu.tieba.enterForum.b.b()));
    }

    private o<byte[]> KB() {
        return com.baidu.tbadk.core.b.a.tc().P("tb_forum_recommend", TbadkCoreApplication.getCurrentAccountName());
    }

    public void ft(int i) {
        com.baidu.tbadk.core.sharedPref.b.tJ().putInt("shared_key_forum_column_type_" + TbadkCoreApplication.getCurrentAccount(), i);
    }

    public int fu(int i) {
        return com.baidu.tbadk.core.sharedPref.b.tJ().getInt("shared_key_forum_column_type_" + TbadkCoreApplication.getCurrentAccount(), i);
    }

    public void O(List<w> list) {
        if (list != null) {
            StringBuilder sb = new StringBuilder();
            for (w wVar : list) {
                if (wVar != null) {
                    sb.append(wVar.getId()).append(ContentProviderProxy.PROVIDER_FRAGMENT_SEPARATOR);
                }
            }
            com.baidu.tbadk.core.sharedPref.b.tJ().putString("shared_key_forum_sort" + TbadkCoreApplication.getCurrentAccount(), sb.toString());
        }
    }

    public String[] KC() {
        return com.baidu.tbadk.core.sharedPref.b.tJ().getString("shared_key_forum_sort" + TbadkCoreApplication.getCurrentAccount(), "").split(ContentProviderProxy.PROVIDER_FRAGMENT_SEPARATOR);
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

    public List<w> P(List<w> list) {
        if (list != null && !list.isEmpty()) {
            Collections.sort(list, new f(this));
        }
        return list;
    }

    public void ar(long j) {
        com.baidu.tbadk.core.sharedPref.b.tJ().putLong("last_close_recommend_time@" + TbadkCoreApplication.getCurrentAccount(), j);
    }

    public long KD() {
        return com.baidu.tbadk.core.sharedPref.b.tJ().getLong("last_close_recommend_time@" + TbadkCoreApplication.getCurrentAccount(), 0L);
    }

    public boolean as(long j) {
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
