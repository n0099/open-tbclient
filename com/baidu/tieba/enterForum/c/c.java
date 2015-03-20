package com.baidu.tieba.enterForum.c;

import android.os.Handler;
import android.os.Looper;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.cache.t;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.v;
import com.baidu.tieba.enterForum.home.forumRecommendHttpResponseMessage;
import com.baidu.tieba.enterForum.home.forumRecommendRequestMessage;
import com.baidu.tieba.enterForum.home.forumRecommendSocketResponseMessage;
import com.baidu.tieba.tbadkCore.ae;
import com.baidu.tieba.y;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/* loaded from: classes.dex */
public class c extends com.baidu.adp.base.f {
    private TbPageContext LN;
    private com.baidu.tieba.enterForum.b.b aDf;
    private boolean aDg;
    private h aDh;
    private com.baidu.tieba.tbadkCore.e.a aDi;
    private long aDj;
    private long aDk;
    private long aDl;
    private long aDm;
    private Handler mUIHandler;

    public c(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.aDf = null;
        this.aDg = true;
        this.aDh = null;
        this.aDi = null;
        this.aDj = 0L;
        this.aDk = 0L;
        this.aDl = 0L;
        this.aDm = 0L;
        this.mUIHandler = null;
        this.LN = tbPageContext;
        setUniqueId(BdUniqueId.gen());
        this.mUIHandler = new Handler(Looper.getMainLooper());
    }

    @Override // com.baidu.adp.base.f
    public BdUniqueId getUniqueId() {
        return this.unique_id;
    }

    public long GR() {
        return this.aDm;
    }

    public long GS() {
        return this.aDk;
    }

    public long GT() {
        return this.aDl;
    }

    public long GU() {
        return this.aDj;
    }

    public com.baidu.tieba.enterForum.b.b GV() {
        return this.aDf;
    }

    public void b(com.baidu.tieba.enterForum.b.b bVar) {
        this.aDf = bVar;
    }

    public void a(h hVar) {
        this.aDh = hVar;
    }

    @Override // com.baidu.adp.base.f
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.f
    public boolean cancelLoadData() {
        cancelMessage();
        GW();
        return true;
    }

    private void GW() {
        if (this.aDi != null) {
            this.aDi.destory();
            this.aDi = null;
        }
    }

    public boolean bz(boolean z) {
        cancelLoadData();
        this.aDg = z;
        forumRecommendRequestMessage forumrecommendrequestmessage = new forumRecommendRequestMessage();
        forumrecommendrequestmessage.set_like_forum(1);
        forumrecommendrequestmessage.set_topic(0);
        forumrecommendrequestmessage.set_recommend(0);
        this.aDj = System.currentTimeMillis();
        if (this.aDi == null) {
            this.aDi = new com.baidu.tieba.tbadkCore.e.a("forumrecommendStat");
        }
        sendMessage(forumrecommendrequestmessage);
        return true;
    }

    public boolean bA(boolean z) {
        this.aDg = z;
        GX();
        return true;
    }

    public void a(boolean z, int i, String str, boolean z2, int i2, long j, long j2) {
        g gVar = new g(this);
        boolean z3 = !z;
        if (this.aDi != null) {
            this.aDi.a(z2, z3, i, str, i2, j, j2);
            this.aDi = null;
        }
        this.aDf.bw(false);
        if (z || !this.aDf.isSuccess()) {
            if (str != null && str.length() > 0) {
                setErrorString(str);
                gVar.aDq = str;
            }
            gVar.type = 1;
            gVar.aDr = false;
            gVar.aDs = this.aDf;
            this.aDh.a(gVar);
            return;
        }
        gVar.type = 1;
        gVar.aDr = true;
        gVar.aDs = this.aDf;
        this.aDh.a(gVar);
    }

    public void a(forumRecommendSocketResponseMessage forumrecommendsocketresponsemessage) {
        a(forumrecommendsocketresponsemessage, forumrecommendsocketresponsemessage.hasError(), forumrecommendsocketresponsemessage.getError(), StringUtils.isNull(forumrecommendsocketresponsemessage.getErrorString()) ? this.LN.getResources().getString(y.neterror) : forumrecommendsocketresponsemessage.getErrorString(), false, forumrecommendsocketresponsemessage.getDownSize(), 0L, forumrecommendsocketresponsemessage.getCostTime());
    }

    public void a(forumRecommendHttpResponseMessage forumrecommendhttpresponsemessage) {
        a(forumrecommendhttpresponsemessage, forumrecommendhttpresponsemessage.hasError(), forumrecommendhttpresponsemessage.getError(), StringUtils.isNull(forumrecommendhttpresponsemessage.getErrorString()) ? this.LN.getResources().getString(y.neterror) : forumrecommendhttpresponsemessage.getErrorString(), true, forumrecommendhttpresponsemessage.getDownSize(), forumrecommendhttpresponsemessage.getCostTime(), 0L);
    }

    public void a(ResponsedMessage<?> responsedMessage, boolean z, int i, String str, boolean z2, int i2, long j, long j2) {
        if (z) {
            this.aDf = null;
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
                this.aDf = new com.baidu.tieba.enterForum.b.b();
                this.aDf.setTime(forumrecommendhttpresponsemessage.GetIsLogin().intValue());
                this.aDf.es(forumrecommendhttpresponsemessage.GetMsignValid().intValue());
                this.aDf.fn(forumrecommendhttpresponsemessage.GetMsignText());
                this.aDf.et(forumrecommendhttpresponsemessage.GetMsignLevel().intValue());
                this.aDf.setIsMem(forumrecommendhttpresponsemessage.GetIsMem().intValue());
                this.aDf.er(forumrecommendhttpresponsemessage.GetIsLogin().intValue());
                this.aDf.bw(false);
                com.baidu.tieba.enterForum.b.c cVar = new com.baidu.tieba.enterForum.b.c();
                cVar.setLevel(forumrecommendhttpresponsemessage.GetMsignLevel().intValue());
                cVar.i(forumrecommendhttpresponsemessage.GetLikeForum());
                this.aDf.a(cVar);
                com.baidu.tieba.enterForum.b.e eVar = new com.baidu.tieba.enterForum.b.e();
                eVar.F(forumrecommendhttpresponsemessage.GetRecommendForumInfoList());
                this.aDf.a(eVar);
                v vVar = new v();
                vVar.i(forumrecommendhttpresponsemessage.GetBanner());
                this.aDf.a(vVar);
                this.aDf.af(true);
            } catch (Exception e) {
                this.aDf.af(false);
                BdLog.e(e.getMessage());
            }
        }
    }

    public void b(forumRecommendSocketResponseMessage forumrecommendsocketresponsemessage) {
        if (forumrecommendsocketresponsemessage != null) {
            try {
                this.aDf = new com.baidu.tieba.enterForum.b.b();
                this.aDf.setTime(forumrecommendsocketresponsemessage.GetIsLogin().intValue());
                this.aDf.es(forumrecommendsocketresponsemessage.GetMsignValid().intValue());
                this.aDf.fn(forumrecommendsocketresponsemessage.GetMsignText());
                this.aDf.et(forumrecommendsocketresponsemessage.GetMsignLevel().intValue());
                this.aDf.setIsMem(forumrecommendsocketresponsemessage.GetIsMem().intValue());
                this.aDf.er(forumrecommendsocketresponsemessage.GetIsLogin().intValue());
                this.aDf.bw(false);
                com.baidu.tieba.enterForum.b.c cVar = new com.baidu.tieba.enterForum.b.c();
                cVar.setLevel(forumrecommendsocketresponsemessage.GetMsignLevel().intValue());
                cVar.i(forumrecommendsocketresponsemessage.GetLikeForum());
                this.aDf.a(cVar);
                com.baidu.tieba.enterForum.b.e eVar = new com.baidu.tieba.enterForum.b.e();
                eVar.F(forumrecommendsocketresponsemessage.GetRecommendForumInfoList());
                this.aDf.a(eVar);
                v vVar = new v();
                vVar.i(forumrecommendsocketresponsemessage.GetBanner());
                this.aDf.a(vVar);
                this.aDf.af(true);
            } catch (Exception e) {
                this.aDf.af(false);
                BdLog.e(e.getMessage());
            }
        }
    }

    private void GX() {
        t<byte[]> GY = GY();
        com.baidu.tieba.enterForum.b.b bVar = new com.baidu.tieba.enterForum.b.b();
        if (this.aDg) {
            GY.a("forumRecommend_cache_key", new d(this, bVar));
        }
    }

    private t<byte[]> GY() {
        return com.baidu.tbadk.core.b.a.rc().R("tb_forum_recommend", TbadkCoreApplication.getCurrentAccountName());
    }

    public void eu(int i) {
        com.baidu.tbadk.core.sharedPref.b.rB().putInt("shared_key_forum_column_type_" + TbadkCoreApplication.getCurrentAccount(), i);
    }

    public int ev(int i) {
        return com.baidu.tbadk.core.sharedPref.b.rB().getInt("shared_key_forum_column_type_" + TbadkCoreApplication.getCurrentAccount(), i);
    }

    public void GZ() {
        com.baidu.tbadk.core.sharedPref.b.rB().putString("shared_key_forum_edit_guide_" + TbadkCoreApplication.getCurrentAccount(), TbConfig.getVersion());
    }

    public boolean Ha() {
        return com.baidu.tbadk.core.sharedPref.b.rB().getString(new StringBuilder("shared_key_forum_edit_guide_").append(TbadkCoreApplication.getCurrentAccount()).toString(), "").equals(TbConfig.getVersion());
    }

    public void H(List<ae> list) {
        if (list != null) {
            StringBuilder sb = new StringBuilder();
            for (ae aeVar : list) {
                if (aeVar != null) {
                    sb.append(aeVar.getId()).append("#");
                }
            }
            com.baidu.tbadk.core.sharedPref.b.rB().putString("shared_key_forum_sort" + TbadkCoreApplication.getCurrentAccount(), sb.toString());
        }
    }

    public String[] Hb() {
        return com.baidu.tbadk.core.sharedPref.b.rB().getString("shared_key_forum_sort" + TbadkCoreApplication.getCurrentAccount(), "").split("#");
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

    public List<ae> I(List<ae> list) {
        if (list != null && !list.isEmpty()) {
            Collections.sort(list, new f(this));
        }
        return list;
    }

    public void N(long j) {
        com.baidu.tbadk.core.sharedPref.b.rB().putLong("last_close_recommend_time@" + TbadkCoreApplication.getCurrentAccount(), j);
    }

    public long Hc() {
        return com.baidu.tbadk.core.sharedPref.b.rB().getLong("last_close_recommend_time@" + TbadkCoreApplication.getCurrentAccount(), 0L);
    }

    public boolean O(long j) {
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
