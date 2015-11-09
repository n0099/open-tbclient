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
import com.baidu.tieba.i;
import com.baidu.tieba.tbadkCore.v;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/* loaded from: classes.dex */
public class c extends com.baidu.adp.base.e {
    private com.baidu.tieba.enterForum.b.b aMq;
    private boolean aMr;
    private b aMs;
    private com.baidu.tieba.tbadkCore.e.a aMt;
    private long aMu;
    private long aMv;
    private long aMw;
    private long aMx;
    private TbPageContext mContext;
    private Handler mUIHandler;

    /* loaded from: classes.dex */
    public interface b {
        void a(a aVar);
    }

    /* loaded from: classes.dex */
    public class a {
        public String aMB = "";
        public boolean aMC = false;
        public int type = -1;
        public com.baidu.tieba.enterForum.b.b aMD = null;

        public a() {
        }
    }

    public c(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.aMq = null;
        this.aMr = true;
        this.aMs = null;
        this.aMt = null;
        this.aMu = 0L;
        this.aMv = 0L;
        this.aMw = 0L;
        this.aMx = 0L;
        this.mUIHandler = null;
        this.mContext = tbPageContext;
        setUniqueId(BdUniqueId.gen());
        this.mUIHandler = new Handler(Looper.getMainLooper());
    }

    @Override // com.baidu.adp.base.e
    public BdUniqueId getUniqueId() {
        return this.unique_id;
    }

    public long IJ() {
        return this.aMx;
    }

    public long IK() {
        return this.aMv;
    }

    public long IL() {
        return this.aMw;
    }

    public long IM() {
        return this.aMu;
    }

    public com.baidu.tieba.enterForum.b.b IN() {
        return this.aMq;
    }

    public void b(com.baidu.tieba.enterForum.b.b bVar) {
        this.aMq = bVar;
    }

    public void a(b bVar) {
        this.aMs = bVar;
    }

    @Override // com.baidu.adp.base.e
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.e
    public boolean cancelLoadData() {
        cancelMessage();
        IO();
        return true;
    }

    private void IO() {
        if (this.aMt != null) {
            this.aMt.destory();
            this.aMt = null;
        }
    }

    public boolean bP(boolean z) {
        cancelLoadData();
        this.aMr = z;
        forumRecommendRequestMessage forumrecommendrequestmessage = new forumRecommendRequestMessage();
        forumrecommendrequestmessage.set_like_forum(1);
        forumrecommendrequestmessage.set_topic(0);
        forumrecommendrequestmessage.set_recommend(0);
        this.aMu = System.currentTimeMillis();
        if (this.aMt == null) {
            this.aMt = new com.baidu.tieba.tbadkCore.e.a("forumrecommendStat");
        }
        sendMessage(forumrecommendrequestmessage);
        return true;
    }

    public boolean bQ(boolean z) {
        this.aMr = z;
        IP();
        return true;
    }

    public void a(boolean z, int i, String str, boolean z2, int i2, long j, long j2) {
        a aVar = new a();
        boolean z3 = !z;
        if (this.aMt != null) {
            this.aMt.a(z2, z3, i, str, i2, j, j2);
            this.aMt = null;
        }
        this.aMq.bM(false);
        if (z || !this.aMq.isSuccess()) {
            if (str != null && str.length() > 0) {
                setErrorString(str);
                aVar.aMB = str;
            }
            aVar.type = 1;
            aVar.aMC = false;
            aVar.aMD = this.aMq;
            this.aMs.a(aVar);
            return;
        }
        aVar.type = 1;
        aVar.aMC = true;
        aVar.aMD = this.aMq;
        this.aMs.a(aVar);
    }

    public void a(forumRecommendSocketResponseMessage forumrecommendsocketresponsemessage) {
        a(forumrecommendsocketresponsemessage, forumrecommendsocketresponsemessage.hasError(), forumrecommendsocketresponsemessage.getError(), StringUtils.isNull(forumrecommendsocketresponsemessage.getErrorString()) ? TbadkCoreApplication.m411getInst().getApp().getResources().getString(i.h.neterror) : forumrecommendsocketresponsemessage.getErrorString(), false, forumrecommendsocketresponsemessage.getDownSize(), 0L, forumrecommendsocketresponsemessage.getCostTime());
    }

    public void a(forumRecommendHttpResponseMessage forumrecommendhttpresponsemessage) {
        a(forumrecommendhttpresponsemessage, forumrecommendhttpresponsemessage.hasError(), forumrecommendhttpresponsemessage.getError(), StringUtils.isNull(forumrecommendhttpresponsemessage.getErrorString()) ? TbadkCoreApplication.m411getInst().getApp().getResources().getString(i.h.neterror) : forumrecommendhttpresponsemessage.getErrorString(), true, forumrecommendhttpresponsemessage.getDownSize(), forumrecommendhttpresponsemessage.getCostTime(), 0L);
    }

    public void a(ResponsedMessage<?> responsedMessage, boolean z, int i, String str, boolean z2, int i2, long j, long j2) {
        if (z) {
            this.aMq = null;
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
                this.aMq = new com.baidu.tieba.enterForum.b.b();
                this.aMq.setTime(forumrecommendhttpresponsemessage.GetIsLogin().intValue());
                this.aMq.fe(forumrecommendhttpresponsemessage.GetMsignValid().intValue());
                this.aMq.gv(forumrecommendhttpresponsemessage.GetMsignText());
                this.aMq.ff(forumrecommendhttpresponsemessage.GetMsignLevel().intValue());
                this.aMq.setIsMem(forumrecommendhttpresponsemessage.GetIsMem().intValue());
                this.aMq.fd(forumrecommendhttpresponsemessage.GetIsLogin().intValue());
                this.aMq.bM(false);
                com.baidu.tieba.enterForum.b.d dVar = new com.baidu.tieba.enterForum.b.d();
                dVar.setLevel(forumrecommendhttpresponsemessage.GetMsignLevel().intValue());
                dVar.K(forumrecommendhttpresponsemessage.GetLikeForum());
                this.aMq.a(dVar);
                com.baidu.tieba.enterForum.b.g gVar = new com.baidu.tieba.enterForum.b.g();
                gVar.L(forumrecommendhttpresponsemessage.GetRecommendForumInfoList());
                this.aMq.a(gVar);
                h hVar = new h();
                hVar.K(forumrecommendhttpresponsemessage.GetBanner());
                this.aMq.a(hVar);
                this.aMq.ap(true);
                this.aMq.a(forumrecommendhttpresponsemessage.getHotSearchInfoData());
            } catch (Exception e) {
                this.aMq.ap(false);
                BdLog.e(e.getMessage());
            }
        }
    }

    public void b(forumRecommendSocketResponseMessage forumrecommendsocketresponsemessage) {
        if (forumrecommendsocketresponsemessage != null) {
            try {
                this.aMq = new com.baidu.tieba.enterForum.b.b();
                this.aMq.setTime(forumrecommendsocketresponsemessage.GetIsLogin().intValue());
                this.aMq.fe(forumrecommendsocketresponsemessage.GetMsignValid().intValue());
                this.aMq.gv(forumrecommendsocketresponsemessage.GetMsignText());
                this.aMq.ff(forumrecommendsocketresponsemessage.GetMsignLevel().intValue());
                this.aMq.setIsMem(forumrecommendsocketresponsemessage.GetIsMem().intValue());
                this.aMq.fd(forumrecommendsocketresponsemessage.GetIsLogin().intValue());
                this.aMq.bM(false);
                com.baidu.tieba.enterForum.b.d dVar = new com.baidu.tieba.enterForum.b.d();
                dVar.setLevel(forumrecommendsocketresponsemessage.GetMsignLevel().intValue());
                dVar.K(forumrecommendsocketresponsemessage.GetLikeForum());
                this.aMq.a(dVar);
                com.baidu.tieba.enterForum.b.g gVar = new com.baidu.tieba.enterForum.b.g();
                gVar.L(forumrecommendsocketresponsemessage.GetRecommendForumInfoList());
                this.aMq.a(gVar);
                h hVar = new h();
                hVar.K(forumrecommendsocketresponsemessage.GetBanner());
                this.aMq.a(hVar);
                this.aMq.ap(true);
                this.aMq.a(forumrecommendsocketresponsemessage.getHotSearchInfoData());
            } catch (Exception e) {
                this.aMq.ap(false);
                BdLog.e(e.getMessage());
            }
        }
    }

    private void IP() {
        IQ().a("forumRecommend_cache_key", new d(this, new com.baidu.tieba.enterForum.b.b()));
    }

    private o<byte[]> IQ() {
        return com.baidu.tbadk.core.b.a.sO().T("tb_forum_recommend", TbadkCoreApplication.getCurrentAccountName());
    }

    public void fg(int i) {
        com.baidu.tbadk.core.sharedPref.b.tu().putInt("shared_key_forum_column_type_" + TbadkCoreApplication.getCurrentAccount(), i);
    }

    public int fh(int i) {
        return com.baidu.tbadk.core.sharedPref.b.tu().getInt("shared_key_forum_column_type_" + TbadkCoreApplication.getCurrentAccount(), i);
    }

    public boolean hasShowForumEditGuide() {
        return com.baidu.tbadk.core.sharedPref.b.tu().getString(new StringBuilder("shared_key_forum_edit_guide_").append(TbadkCoreApplication.getCurrentAccount()).toString(), "").equals(TbConfig.getVersion());
    }

    public void N(List<v> list) {
        if (list != null) {
            StringBuilder sb = new StringBuilder();
            for (v vVar : list) {
                if (vVar != null) {
                    sb.append(vVar.getId()).append("#");
                }
            }
            com.baidu.tbadk.core.sharedPref.b.tu().putString("shared_key_forum_sort" + TbadkCoreApplication.getCurrentAccount(), sb.toString());
        }
    }

    public String[] IR() {
        return com.baidu.tbadk.core.sharedPref.b.tu().getString("shared_key_forum_sort" + TbadkCoreApplication.getCurrentAccount(), "").split("#");
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

    public List<v> O(List<v> list) {
        if (list != null && !list.isEmpty()) {
            Collections.sort(list, new f(this));
        }
        return list;
    }

    public void ai(long j) {
        com.baidu.tbadk.core.sharedPref.b.tu().putLong("last_close_recommend_time@" + TbadkCoreApplication.getCurrentAccount(), j);
    }

    public long IS() {
        return com.baidu.tbadk.core.sharedPref.b.tu().getLong("last_close_recommend_time@" + TbadkCoreApplication.getCurrentAccount(), 0L);
    }

    public boolean aj(long j) {
        return System.currentTimeMillis() - j > TbConfig.APP_OVERDUR_DRAFT_BOX;
    }

    public boolean b(List<v> list, List<v> list2) {
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
