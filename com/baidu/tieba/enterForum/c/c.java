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
import com.baidu.tieba.n;
import com.baidu.tieba.tbadkCore.w;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/* loaded from: classes.dex */
public class c extends com.baidu.adp.base.e {
    private com.baidu.tieba.enterForum.b.b aQZ;
    private boolean aRa;
    private b aRb;
    private com.baidu.tieba.tbadkCore.d.a aRc;
    private long aRd;
    private long aRe;
    private long aRf;
    private long aRg;
    private TbPageContext mContext;
    private Handler mUIHandler;

    /* loaded from: classes.dex */
    public interface b {
        void a(a aVar);
    }

    /* loaded from: classes.dex */
    public class a {
        public String aRk = "";
        public boolean aRl = false;
        public int type = -1;
        public com.baidu.tieba.enterForum.b.b aRm = null;

        public a() {
        }
    }

    public c(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.aQZ = null;
        this.aRa = true;
        this.aRb = null;
        this.aRc = null;
        this.aRd = 0L;
        this.aRe = 0L;
        this.aRf = 0L;
        this.aRg = 0L;
        this.mUIHandler = null;
        this.mContext = tbPageContext;
        setUniqueId(BdUniqueId.gen());
        this.mUIHandler = new Handler(Looper.getMainLooper());
    }

    @Override // com.baidu.adp.base.e
    public BdUniqueId getUniqueId() {
        return this.unique_id;
    }

    public long Kb() {
        return this.aRg;
    }

    public long Kc() {
        return this.aRe;
    }

    public long Kd() {
        return this.aRf;
    }

    public long Ke() {
        return this.aRd;
    }

    public com.baidu.tieba.enterForum.b.b Kf() {
        return this.aQZ;
    }

    public void b(com.baidu.tieba.enterForum.b.b bVar) {
        this.aQZ = bVar;
    }

    public void a(b bVar) {
        this.aRb = bVar;
    }

    @Override // com.baidu.adp.base.e
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.e
    public boolean cancelLoadData() {
        cancelMessage();
        Kg();
        return true;
    }

    private void Kg() {
        if (this.aRc != null) {
            this.aRc.destory();
            this.aRc = null;
        }
    }

    public boolean cc(boolean z) {
        cancelLoadData();
        this.aRa = z;
        forumRecommendRequestMessage forumrecommendrequestmessage = new forumRecommendRequestMessage();
        forumrecommendrequestmessage.set_like_forum(Integer.valueOf(z ? 1 : 0));
        forumrecommendrequestmessage.set_topic(0);
        forumrecommendrequestmessage.set_recommend(1);
        this.aRd = System.currentTimeMillis();
        if (this.aRc == null) {
            this.aRc = new com.baidu.tieba.tbadkCore.d.a("forumrecommendStat");
        }
        sendMessage(forumrecommendrequestmessage);
        return true;
    }

    public boolean cd(boolean z) {
        this.aRa = z;
        Kh();
        return true;
    }

    public void a(boolean z, int i, String str, boolean z2, int i2, long j, long j2) {
        a aVar = new a();
        boolean z3 = !z;
        if (this.aRc != null) {
            this.aRc.a(z2, z3, i, str, i2, j, j2);
            this.aRc = null;
        }
        this.aQZ.bX(false);
        if (z || !this.aQZ.isSuccess()) {
            if (str != null && str.length() > 0) {
                setErrorString(str);
                aVar.aRk = str;
            }
            aVar.type = 1;
            aVar.aRl = false;
            aVar.aRm = this.aQZ;
            this.aRb.a(aVar);
            return;
        }
        aVar.type = 1;
        aVar.aRl = true;
        aVar.aRm = this.aQZ;
        this.aRb.a(aVar);
    }

    public void a(forumRecommendSocketResponseMessage forumrecommendsocketresponsemessage) {
        String errorString;
        int downSize = forumrecommendsocketresponsemessage.getDownSize();
        long costTime = forumrecommendsocketresponsemessage.getCostTime();
        if (StringUtils.isNull(forumrecommendsocketresponsemessage.getErrorString())) {
            errorString = TbadkCoreApplication.m411getInst().getApp().getResources().getString(n.i.neterror);
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
            errorString = TbadkCoreApplication.m411getInst().getApp().getResources().getString(n.i.neterror);
        } else {
            errorString = forumrecommendhttpresponsemessage.getErrorString();
        }
        a(forumrecommendhttpresponsemessage, forumrecommendhttpresponsemessage.hasError(), forumrecommendhttpresponsemessage.getError(), errorString, true, downSize, costTime, 0L);
    }

    public void a(ResponsedMessage<?> responsedMessage, boolean z, int i, String str, boolean z2, int i2, long j, long j2) {
        if (z) {
            this.aQZ = null;
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
                this.aQZ = new com.baidu.tieba.enterForum.b.b();
                this.aQZ.setTime(forumrecommendhttpresponsemessage.GetIsLogin().intValue());
                this.aQZ.fu(forumrecommendhttpresponsemessage.GetMsignValid().intValue());
                this.aQZ.gL(forumrecommendhttpresponsemessage.GetMsignText());
                this.aQZ.fv(forumrecommendhttpresponsemessage.GetMsignLevel().intValue());
                this.aQZ.setIsMem(forumrecommendhttpresponsemessage.GetIsMem().intValue());
                this.aQZ.ft(forumrecommendhttpresponsemessage.GetIsLogin().intValue());
                this.aQZ.bX(false);
                this.aQZ.fs(forumrecommendhttpresponsemessage.getRedirect());
                com.baidu.tieba.enterForum.b.d dVar = new com.baidu.tieba.enterForum.b.d();
                dVar.setLevel(forumrecommendhttpresponsemessage.GetMsignLevel().intValue());
                dVar.K(forumrecommendhttpresponsemessage.GetLikeForum());
                this.aQZ.a(dVar);
                com.baidu.tieba.enterForum.b.g gVar = new com.baidu.tieba.enterForum.b.g();
                gVar.L(forumrecommendhttpresponsemessage.GetRecommendForumInfoList());
                this.aQZ.a(gVar);
                h hVar = new h();
                hVar.K(forumrecommendhttpresponsemessage.GetBanner());
                this.aQZ.a(hVar);
                this.aQZ.as(true);
                this.aQZ.a(forumrecommendhttpresponsemessage.getHotSearchInfoData());
            } catch (Exception e) {
                this.aQZ.as(false);
                BdLog.e(e.getMessage());
            }
        }
    }

    public void b(forumRecommendSocketResponseMessage forumrecommendsocketresponsemessage) {
        if (forumrecommendsocketresponsemessage != null) {
            try {
                this.aQZ = new com.baidu.tieba.enterForum.b.b();
                this.aQZ.setTime(forumrecommendsocketresponsemessage.GetIsLogin().intValue());
                this.aQZ.fu(forumrecommendsocketresponsemessage.GetMsignValid().intValue());
                this.aQZ.gL(forumrecommendsocketresponsemessage.GetMsignText());
                this.aQZ.fv(forumrecommendsocketresponsemessage.GetMsignLevel().intValue());
                this.aQZ.setIsMem(forumrecommendsocketresponsemessage.GetIsMem().intValue());
                this.aQZ.ft(forumrecommendsocketresponsemessage.GetIsLogin().intValue());
                this.aQZ.bX(false);
                com.baidu.tieba.enterForum.b.d dVar = new com.baidu.tieba.enterForum.b.d();
                dVar.setLevel(forumrecommendsocketresponsemessage.GetMsignLevel().intValue());
                dVar.K(forumrecommendsocketresponsemessage.GetLikeForum());
                this.aQZ.a(dVar);
                com.baidu.tieba.enterForum.b.g gVar = new com.baidu.tieba.enterForum.b.g();
                gVar.L(forumrecommendsocketresponsemessage.GetRecommendForumInfoList());
                this.aQZ.a(gVar);
                h hVar = new h();
                hVar.K(forumrecommendsocketresponsemessage.GetBanner());
                this.aQZ.a(hVar);
                this.aQZ.as(true);
                this.aQZ.a(forumrecommendsocketresponsemessage.getHotSearchInfoData());
            } catch (Exception e) {
                this.aQZ.as(false);
                BdLog.e(e.getMessage());
            }
        }
    }

    private void Kh() {
        Ki().a("forumRecommend_cache_key", new d(this, new com.baidu.tieba.enterForum.b.b()));
    }

    private o<byte[]> Ki() {
        return com.baidu.tbadk.core.b.a.ts().Q("tb_forum_recommend", TbadkCoreApplication.getCurrentAccountName());
    }

    public void fy(int i) {
        com.baidu.tbadk.core.sharedPref.b.tZ().putInt("shared_key_forum_column_type_" + TbadkCoreApplication.getCurrentAccount(), i);
    }

    public int fz(int i) {
        return com.baidu.tbadk.core.sharedPref.b.tZ().getInt("shared_key_forum_column_type_" + TbadkCoreApplication.getCurrentAccount(), i);
    }

    public void N(List<w> list) {
        if (list != null) {
            StringBuilder sb = new StringBuilder();
            for (w wVar : list) {
                if (wVar != null) {
                    sb.append(wVar.getId()).append("#");
                }
            }
            com.baidu.tbadk.core.sharedPref.b.tZ().putString("shared_key_forum_sort" + TbadkCoreApplication.getCurrentAccount(), sb.toString());
        }
    }

    public String[] Kj() {
        return com.baidu.tbadk.core.sharedPref.b.tZ().getString("shared_key_forum_sort" + TbadkCoreApplication.getCurrentAccount(), "").split("#");
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

    public List<w> O(List<w> list) {
        if (list != null && !list.isEmpty()) {
            Collections.sort(list, new f(this));
        }
        return list;
    }

    public void aq(long j) {
        com.baidu.tbadk.core.sharedPref.b.tZ().putLong("last_close_recommend_time@" + TbadkCoreApplication.getCurrentAccount(), j);
    }

    public long Kk() {
        return com.baidu.tbadk.core.sharedPref.b.tZ().getLong("last_close_recommend_time@" + TbadkCoreApplication.getCurrentAccount(), 0L);
    }

    public boolean ar(long j) {
        return System.currentTimeMillis() - j > TbConfig.APP_OVERDUR_DRAFT_BOX;
    }

    public boolean b(List<w> list, List<w> list2) {
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
