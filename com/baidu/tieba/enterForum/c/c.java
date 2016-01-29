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
import com.baidu.tieba.t;
import com.baidu.tieba.tbadkCore.v;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/* loaded from: classes.dex */
public class c extends com.baidu.adp.base.e {
    private TbPageContext MR;
    private com.baidu.tieba.enterForum.b.b aXc;
    private boolean aXd;
    private b aXe;
    private com.baidu.tieba.tbadkCore.d.b aXf;
    private long aXg;
    private long aXh;
    private long aXi;
    private long aXj;
    private Handler mUIHandler;

    /* loaded from: classes.dex */
    public interface b {
        void a(a aVar);
    }

    /* loaded from: classes.dex */
    public class a {
        public String aXn = "";
        public boolean aXo = false;
        public int type = -1;
        public com.baidu.tieba.enterForum.b.b aXp = null;

        public a() {
        }
    }

    public c(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.aXc = null;
        this.aXd = true;
        this.aXe = null;
        this.aXf = null;
        this.aXg = 0L;
        this.aXh = 0L;
        this.aXi = 0L;
        this.aXj = 0L;
        this.mUIHandler = null;
        this.MR = tbPageContext;
        setUniqueId(BdUniqueId.gen());
        this.mUIHandler = new Handler(Looper.getMainLooper());
    }

    @Override // com.baidu.adp.base.e
    public BdUniqueId getUniqueId() {
        return this.unique_id;
    }

    public long Ml() {
        return this.aXj;
    }

    public long Mm() {
        return this.aXh;
    }

    public long Mn() {
        return this.aXi;
    }

    public long Mo() {
        return this.aXg;
    }

    public com.baidu.tieba.enterForum.b.b Mp() {
        return this.aXc;
    }

    public void c(com.baidu.tieba.enterForum.b.b bVar) {
        this.aXc = bVar;
    }

    public void a(b bVar) {
        this.aXe = bVar;
    }

    @Override // com.baidu.adp.base.e
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.e
    public boolean cancelLoadData() {
        cancelMessage();
        Mq();
        return true;
    }

    private void Mq() {
        if (this.aXf != null) {
            this.aXf.destory();
            this.aXf = null;
        }
    }

    public boolean cb(boolean z) {
        cancelLoadData();
        this.aXd = z;
        forumRecommendRequestMessage forumrecommendrequestmessage = new forumRecommendRequestMessage();
        forumrecommendrequestmessage.set_like_forum(Integer.valueOf(z ? 1 : 0));
        forumrecommendrequestmessage.set_topic(0);
        forumrecommendrequestmessage.set_recommend(1);
        this.aXg = System.currentTimeMillis();
        if (this.aXf == null) {
            this.aXf = new com.baidu.tieba.tbadkCore.d.b("forumrecommendStat");
        }
        sendMessage(forumrecommendrequestmessage);
        return true;
    }

    public boolean cc(boolean z) {
        this.aXd = z;
        Mr();
        return true;
    }

    public void a(boolean z, int i, String str, boolean z2, int i2, long j, long j2) {
        a aVar = new a();
        boolean z3 = !z;
        if (this.aXf != null) {
            this.aXf.a(z2, z3, i, str, i2, j, j2);
            this.aXf = null;
        }
        this.aXc.bW(false);
        if (z || !this.aXc.isSuccess()) {
            if (str != null && str.length() > 0) {
                setErrorString(str);
                aVar.aXn = str;
            }
            aVar.type = 1;
            aVar.aXo = false;
            aVar.aXp = this.aXc;
            this.aXe.a(aVar);
            return;
        }
        aVar.type = 1;
        aVar.aXo = true;
        aVar.aXp = this.aXc;
        this.aXe.a(aVar);
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
            this.aXc = null;
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
                this.aXc = new com.baidu.tieba.enterForum.b.b();
                this.aXc.setTime(forumrecommendhttpresponsemessage.GetIsLogin().intValue());
                this.aXc.fO(forumrecommendhttpresponsemessage.GetMsignValid().intValue());
                this.aXc.gW(forumrecommendhttpresponsemessage.GetMsignText());
                this.aXc.fP(forumrecommendhttpresponsemessage.GetMsignLevel().intValue());
                this.aXc.setIsMem(forumrecommendhttpresponsemessage.GetIsMem().intValue());
                this.aXc.fN(forumrecommendhttpresponsemessage.GetIsLogin().intValue());
                this.aXc.bW(false);
                this.aXc.fM(forumrecommendhttpresponsemessage.getRedirect());
                com.baidu.tieba.enterForum.b.d dVar = new com.baidu.tieba.enterForum.b.d();
                dVar.setLevel(forumrecommendhttpresponsemessage.GetMsignLevel().intValue());
                dVar.I(forumrecommendhttpresponsemessage.GetLikeForum());
                this.aXc.a(dVar);
                com.baidu.tieba.enterForum.b.g gVar = new com.baidu.tieba.enterForum.b.g();
                gVar.J(forumrecommendhttpresponsemessage.GetRecommendForumInfoList());
                this.aXc.a(gVar);
                h hVar = new h();
                hVar.I(forumrecommendhttpresponsemessage.GetBanner());
                this.aXc.a(hVar);
                h hVar2 = new h();
                hVar2.I(forumrecommendhttpresponsemessage.getNewBannerInfo());
                this.aXc.b(hVar2);
                this.aXc.aq(true);
                this.aXc.a(forumrecommendhttpresponsemessage.getHotSearchInfoData());
            } catch (Exception e) {
                this.aXc.aq(false);
                BdLog.e(e.getMessage());
            }
        }
    }

    public void b(forumRecommendSocketResponseMessage forumrecommendsocketresponsemessage) {
        if (forumrecommendsocketresponsemessage != null) {
            try {
                this.aXc = new com.baidu.tieba.enterForum.b.b();
                this.aXc.setTime(forumrecommendsocketresponsemessage.GetIsLogin().intValue());
                this.aXc.fO(forumrecommendsocketresponsemessage.GetMsignValid().intValue());
                this.aXc.gW(forumrecommendsocketresponsemessage.GetMsignText());
                this.aXc.fP(forumrecommendsocketresponsemessage.GetMsignLevel().intValue());
                this.aXc.setIsMem(forumrecommendsocketresponsemessage.GetIsMem().intValue());
                this.aXc.fN(forumrecommendsocketresponsemessage.GetIsLogin().intValue());
                this.aXc.bW(false);
                com.baidu.tieba.enterForum.b.d dVar = new com.baidu.tieba.enterForum.b.d();
                dVar.setLevel(forumrecommendsocketresponsemessage.GetMsignLevel().intValue());
                dVar.I(forumrecommendsocketresponsemessage.GetLikeForum());
                this.aXc.a(dVar);
                com.baidu.tieba.enterForum.b.g gVar = new com.baidu.tieba.enterForum.b.g();
                gVar.J(forumrecommendsocketresponsemessage.GetRecommendForumInfoList());
                this.aXc.a(gVar);
                h hVar = new h();
                hVar.I(forumrecommendsocketresponsemessage.GetBanner());
                this.aXc.a(hVar);
                h hVar2 = new h();
                hVar2.I(forumrecommendsocketresponsemessage.getNewBannerInfo());
                this.aXc.b(hVar2);
                this.aXc.aq(true);
                this.aXc.a(forumrecommendsocketresponsemessage.getHotSearchInfoData());
            } catch (Exception e) {
                this.aXc.aq(false);
                BdLog.e(e.getMessage());
            }
        }
    }

    private void Mr() {
        Ms().a("forumRecommend_cache_key", new d(this, new com.baidu.tieba.enterForum.b.b()));
    }

    private o<byte[]> Ms() {
        return com.baidu.tbadk.core.b.a.ug().P("tb_forum_recommend", TbadkCoreApplication.getCurrentAccountName());
    }

    public void fS(int i) {
        com.baidu.tbadk.core.sharedPref.b.uO().putInt("shared_key_forum_column_type_" + TbadkCoreApplication.getCurrentAccount(), i);
    }

    public int fT(int i) {
        return com.baidu.tbadk.core.sharedPref.b.uO().getInt("shared_key_forum_column_type_" + TbadkCoreApplication.getCurrentAccount(), i);
    }

    public void L(List<v> list) {
        if (list != null) {
            StringBuilder sb = new StringBuilder();
            for (v vVar : list) {
                if (vVar != null) {
                    sb.append(vVar.getId()).append(ContentProviderProxy.PROVIDER_FRAGMENT_SEPARATOR);
                }
            }
            com.baidu.tbadk.core.sharedPref.b.uO().putString("shared_key_forum_sort" + TbadkCoreApplication.getCurrentAccount(), sb.toString());
        }
    }

    public String[] Mt() {
        return com.baidu.tbadk.core.sharedPref.b.uO().getString("shared_key_forum_sort" + TbadkCoreApplication.getCurrentAccount(), "").split(ContentProviderProxy.PROVIDER_FRAGMENT_SEPARATOR);
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

    public List<v> M(List<v> list) {
        if (list != null && !list.isEmpty()) {
            Collections.sort(list, new f(this));
        }
        return list;
    }

    public void at(long j) {
        com.baidu.tbadk.core.sharedPref.b.uO().putLong("last_close_recommend_time@" + TbadkCoreApplication.getCurrentAccount(), j);
    }

    public long Mu() {
        return com.baidu.tbadk.core.sharedPref.b.uO().getLong("last_close_recommend_time@" + TbadkCoreApplication.getCurrentAccount(), 0L);
    }

    public boolean au(long j) {
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
