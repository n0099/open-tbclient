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
import com.baidu.tbadk.core.data.t;
import com.baidu.tieba.enterForum.home.forumRecommendHttpResponseMessage;
import com.baidu.tieba.enterForum.home.forumRecommendRequestMessage;
import com.baidu.tieba.enterForum.home.forumRecommendSocketResponseMessage;
import com.baidu.tieba.i;
import com.baidu.tieba.tbadkCore.u;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/* loaded from: classes.dex */
public class c extends com.baidu.adp.base.e {
    private TbPageContext LS;
    private com.baidu.tieba.enterForum.b.b aMP;
    private boolean aMQ;
    private b aMR;
    private com.baidu.tieba.tbadkCore.e.a aMS;
    private long aMT;
    private long aMU;
    private long aMV;
    private long aMW;
    private Handler mUIHandler;

    /* loaded from: classes.dex */
    public interface b {
        void a(a aVar);
    }

    /* loaded from: classes.dex */
    public class a {
        public String aNa = "";
        public boolean aNb = false;
        public int type = -1;
        public com.baidu.tieba.enterForum.b.b aNc = null;

        public a() {
        }
    }

    public c(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.aMP = null;
        this.aMQ = true;
        this.aMR = null;
        this.aMS = null;
        this.aMT = 0L;
        this.aMU = 0L;
        this.aMV = 0L;
        this.aMW = 0L;
        this.mUIHandler = null;
        this.LS = tbPageContext;
        setUniqueId(BdUniqueId.gen());
        this.mUIHandler = new Handler(Looper.getMainLooper());
    }

    @Override // com.baidu.adp.base.e
    public BdUniqueId getUniqueId() {
        return this.unique_id;
    }

    public long IN() {
        return this.aMW;
    }

    public long IO() {
        return this.aMU;
    }

    public long IP() {
        return this.aMV;
    }

    public long IQ() {
        return this.aMT;
    }

    public com.baidu.tieba.enterForum.b.b IR() {
        return this.aMP;
    }

    public void b(com.baidu.tieba.enterForum.b.b bVar) {
        this.aMP = bVar;
    }

    public void a(b bVar) {
        this.aMR = bVar;
    }

    @Override // com.baidu.adp.base.e
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.e
    public boolean cancelLoadData() {
        cancelMessage();
        IS();
        return true;
    }

    private void IS() {
        if (this.aMS != null) {
            this.aMS.destory();
            this.aMS = null;
        }
    }

    public boolean bL(boolean z) {
        cancelLoadData();
        this.aMQ = z;
        forumRecommendRequestMessage forumrecommendrequestmessage = new forumRecommendRequestMessage();
        forumrecommendrequestmessage.set_like_forum(1);
        forumrecommendrequestmessage.set_topic(0);
        forumrecommendrequestmessage.set_recommend(0);
        this.aMT = System.currentTimeMillis();
        if (this.aMS == null) {
            this.aMS = new com.baidu.tieba.tbadkCore.e.a("forumrecommendStat");
        }
        sendMessage(forumrecommendrequestmessage);
        return true;
    }

    public boolean bM(boolean z) {
        this.aMQ = z;
        IT();
        return true;
    }

    public void a(boolean z, int i, String str, boolean z2, int i2, long j, long j2) {
        a aVar = new a();
        boolean z3 = !z;
        if (this.aMS != null) {
            this.aMS.a(z2, z3, i, str, i2, j, j2);
            this.aMS = null;
        }
        this.aMP.bI(false);
        if (z || !this.aMP.isSuccess()) {
            if (str != null && str.length() > 0) {
                setErrorString(str);
                aVar.aNa = str;
            }
            aVar.type = 1;
            aVar.aNb = false;
            aVar.aNc = this.aMP;
            this.aMR.a(aVar);
            return;
        }
        aVar.type = 1;
        aVar.aNb = true;
        aVar.aNc = this.aMP;
        this.aMR.a(aVar);
    }

    public void a(forumRecommendSocketResponseMessage forumrecommendsocketresponsemessage) {
        a(forumrecommendsocketresponsemessage, forumrecommendsocketresponsemessage.hasError(), forumrecommendsocketresponsemessage.getError(), StringUtils.isNull(forumrecommendsocketresponsemessage.getErrorString()) ? TbadkCoreApplication.m411getInst().getApp().getResources().getString(i.C0057i.neterror) : forumrecommendsocketresponsemessage.getErrorString(), false, forumrecommendsocketresponsemessage.getDownSize(), 0L, forumrecommendsocketresponsemessage.getCostTime());
    }

    public void a(forumRecommendHttpResponseMessage forumrecommendhttpresponsemessage) {
        a(forumrecommendhttpresponsemessage, forumrecommendhttpresponsemessage.hasError(), forumrecommendhttpresponsemessage.getError(), StringUtils.isNull(forumrecommendhttpresponsemessage.getErrorString()) ? TbadkCoreApplication.m411getInst().getApp().getResources().getString(i.C0057i.neterror) : forumrecommendhttpresponsemessage.getErrorString(), true, forumrecommendhttpresponsemessage.getDownSize(), forumrecommendhttpresponsemessage.getCostTime(), 0L);
    }

    public void a(ResponsedMessage<?> responsedMessage, boolean z, int i, String str, boolean z2, int i2, long j, long j2) {
        if (z) {
            this.aMP = null;
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
                this.aMP = new com.baidu.tieba.enterForum.b.b();
                this.aMP.setTime(forumrecommendhttpresponsemessage.GetIsLogin().intValue());
                this.aMP.eK(forumrecommendhttpresponsemessage.GetMsignValid().intValue());
                this.aMP.gj(forumrecommendhttpresponsemessage.GetMsignText());
                this.aMP.eL(forumrecommendhttpresponsemessage.GetMsignLevel().intValue());
                this.aMP.setIsMem(forumrecommendhttpresponsemessage.GetIsMem().intValue());
                this.aMP.eJ(forumrecommendhttpresponsemessage.GetIsLogin().intValue());
                this.aMP.bI(false);
                com.baidu.tieba.enterForum.b.c cVar = new com.baidu.tieba.enterForum.b.c();
                cVar.setLevel(forumrecommendhttpresponsemessage.GetMsignLevel().intValue());
                cVar.j(forumrecommendhttpresponsemessage.GetLikeForum());
                this.aMP.a(cVar);
                com.baidu.tieba.enterForum.b.f fVar = new com.baidu.tieba.enterForum.b.f();
                fVar.H(forumrecommendhttpresponsemessage.GetRecommendForumInfoList());
                this.aMP.a(fVar);
                t tVar = new t();
                tVar.j(forumrecommendhttpresponsemessage.GetBanner());
                this.aMP.a(tVar);
                this.aMP.ap(true);
            } catch (Exception e) {
                this.aMP.ap(false);
                BdLog.e(e.getMessage());
            }
        }
    }

    public void b(forumRecommendSocketResponseMessage forumrecommendsocketresponsemessage) {
        if (forumrecommendsocketresponsemessage != null) {
            try {
                this.aMP = new com.baidu.tieba.enterForum.b.b();
                this.aMP.setTime(forumrecommendsocketresponsemessage.GetIsLogin().intValue());
                this.aMP.eK(forumrecommendsocketresponsemessage.GetMsignValid().intValue());
                this.aMP.gj(forumrecommendsocketresponsemessage.GetMsignText());
                this.aMP.eL(forumrecommendsocketresponsemessage.GetMsignLevel().intValue());
                this.aMP.setIsMem(forumrecommendsocketresponsemessage.GetIsMem().intValue());
                this.aMP.eJ(forumrecommendsocketresponsemessage.GetIsLogin().intValue());
                this.aMP.bI(false);
                com.baidu.tieba.enterForum.b.c cVar = new com.baidu.tieba.enterForum.b.c();
                cVar.setLevel(forumrecommendsocketresponsemessage.GetMsignLevel().intValue());
                cVar.j(forumrecommendsocketresponsemessage.GetLikeForum());
                this.aMP.a(cVar);
                com.baidu.tieba.enterForum.b.f fVar = new com.baidu.tieba.enterForum.b.f();
                fVar.H(forumrecommendsocketresponsemessage.GetRecommendForumInfoList());
                this.aMP.a(fVar);
                t tVar = new t();
                tVar.j(forumrecommendsocketresponsemessage.GetBanner());
                this.aMP.a(tVar);
                this.aMP.ap(true);
            } catch (Exception e) {
                this.aMP.ap(false);
                BdLog.e(e.getMessage());
            }
        }
    }

    private void IT() {
        IU().a("forumRecommend_cache_key", new d(this, new com.baidu.tieba.enterForum.b.b()));
    }

    private o<byte[]> IU() {
        return com.baidu.tbadk.core.b.a.sM().U("tb_forum_recommend", TbadkCoreApplication.getCurrentAccountName());
    }

    public void eM(int i) {
        com.baidu.tbadk.core.sharedPref.b.ts().putInt("shared_key_forum_column_type_" + TbadkCoreApplication.getCurrentAccount(), i);
    }

    public int eN(int i) {
        return com.baidu.tbadk.core.sharedPref.b.ts().getInt("shared_key_forum_column_type_" + TbadkCoreApplication.getCurrentAccount(), i);
    }

    public boolean hasShowForumEditGuide() {
        return com.baidu.tbadk.core.sharedPref.b.ts().getString(new StringBuilder("shared_key_forum_edit_guide_").append(TbadkCoreApplication.getCurrentAccount()).toString(), "").equals(TbConfig.getVersion());
    }

    public void J(List<u> list) {
        if (list != null) {
            StringBuilder sb = new StringBuilder();
            for (u uVar : list) {
                if (uVar != null) {
                    sb.append(uVar.getId()).append("#");
                }
            }
            com.baidu.tbadk.core.sharedPref.b.ts().putString("shared_key_forum_sort" + TbadkCoreApplication.getCurrentAccount(), sb.toString());
        }
    }

    public String[] IV() {
        return com.baidu.tbadk.core.sharedPref.b.ts().getString("shared_key_forum_sort" + TbadkCoreApplication.getCurrentAccount(), "").split("#");
    }

    public List<u> a(List<u> list, String[] strArr) {
        ArrayList arrayList = new ArrayList();
        if (list == null || list.isEmpty()) {
            return arrayList;
        }
        if (strArr == null || strArr.length == 0) {
            arrayList.addAll(list);
        } else {
            for (String str : strArr) {
                for (u uVar : list) {
                    if (uVar != null && uVar.getId() != null && uVar.getId().equals(str)) {
                        arrayList.add(uVar);
                    }
                }
            }
            for (int size = list.size() - 1; size >= 0; size--) {
                u uVar2 = list.get(size);
                if (!arrayList.contains(uVar2)) {
                    arrayList.add(0, uVar2);
                }
            }
        }
        return arrayList;
    }

    public List<u> K(List<u> list) {
        if (list != null && !list.isEmpty()) {
            Collections.sort(list, new f(this));
        }
        return list;
    }

    public void Q(long j) {
        com.baidu.tbadk.core.sharedPref.b.ts().putLong("last_close_recommend_time@" + TbadkCoreApplication.getCurrentAccount(), j);
    }

    public long IW() {
        return com.baidu.tbadk.core.sharedPref.b.ts().getLong("last_close_recommend_time@" + TbadkCoreApplication.getCurrentAccount(), 0L);
    }

    public boolean R(long j) {
        return System.currentTimeMillis() - j > TbConfig.APP_OVERDUR_DRAFT_BOX;
    }

    public boolean b(List<u> list, List<u> list2) {
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
            u uVar = list.get(i);
            u uVar2 = list2.get(i);
            if (uVar != null && uVar2 != null) {
                if (!uVar.getId().equals(uVar2.getId())) {
                    return false;
                }
            } else if (uVar == null || uVar2 == null) {
                return false;
            }
        }
        return true;
    }
}
