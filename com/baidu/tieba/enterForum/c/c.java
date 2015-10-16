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
    private com.baidu.tieba.enterForum.b.b aMi;
    private boolean aMj;
    private b aMk;
    private com.baidu.tieba.tbadkCore.e.a aMl;
    private long aMm;
    private long aMn;
    private long aMo;
    private long aMp;
    private TbPageContext mContext;
    private Handler mUIHandler;

    /* loaded from: classes.dex */
    public interface b {
        void a(a aVar);
    }

    /* loaded from: classes.dex */
    public class a {
        public String aMt = "";
        public boolean aMu = false;
        public int type = -1;
        public com.baidu.tieba.enterForum.b.b aMv = null;

        public a() {
        }
    }

    public c(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.aMi = null;
        this.aMj = true;
        this.aMk = null;
        this.aMl = null;
        this.aMm = 0L;
        this.aMn = 0L;
        this.aMo = 0L;
        this.aMp = 0L;
        this.mUIHandler = null;
        this.mContext = tbPageContext;
        setUniqueId(BdUniqueId.gen());
        this.mUIHandler = new Handler(Looper.getMainLooper());
    }

    @Override // com.baidu.adp.base.e
    public BdUniqueId getUniqueId() {
        return this.unique_id;
    }

    public long Ix() {
        return this.aMp;
    }

    public long Iy() {
        return this.aMn;
    }

    public long Iz() {
        return this.aMo;
    }

    public long IA() {
        return this.aMm;
    }

    public com.baidu.tieba.enterForum.b.b IB() {
        return this.aMi;
    }

    public void b(com.baidu.tieba.enterForum.b.b bVar) {
        this.aMi = bVar;
    }

    public void a(b bVar) {
        this.aMk = bVar;
    }

    @Override // com.baidu.adp.base.e
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.e
    public boolean cancelLoadData() {
        cancelMessage();
        IC();
        return true;
    }

    private void IC() {
        if (this.aMl != null) {
            this.aMl.destory();
            this.aMl = null;
        }
    }

    public boolean bN(boolean z) {
        cancelLoadData();
        this.aMj = z;
        forumRecommendRequestMessage forumrecommendrequestmessage = new forumRecommendRequestMessage();
        forumrecommendrequestmessage.set_like_forum(1);
        forumrecommendrequestmessage.set_topic(0);
        forumrecommendrequestmessage.set_recommend(0);
        this.aMm = System.currentTimeMillis();
        if (this.aMl == null) {
            this.aMl = new com.baidu.tieba.tbadkCore.e.a("forumrecommendStat");
        }
        sendMessage(forumrecommendrequestmessage);
        return true;
    }

    public boolean bO(boolean z) {
        this.aMj = z;
        ID();
        return true;
    }

    public void a(boolean z, int i, String str, boolean z2, int i2, long j, long j2) {
        a aVar = new a();
        boolean z3 = !z;
        if (this.aMl != null) {
            this.aMl.a(z2, z3, i, str, i2, j, j2);
            this.aMl = null;
        }
        this.aMi.bK(false);
        if (z || !this.aMi.isSuccess()) {
            if (str != null && str.length() > 0) {
                setErrorString(str);
                aVar.aMt = str;
            }
            aVar.type = 1;
            aVar.aMu = false;
            aVar.aMv = this.aMi;
            this.aMk.a(aVar);
            return;
        }
        aVar.type = 1;
        aVar.aMu = true;
        aVar.aMv = this.aMi;
        this.aMk.a(aVar);
    }

    public void a(forumRecommendSocketResponseMessage forumrecommendsocketresponsemessage) {
        a(forumrecommendsocketresponsemessage, forumrecommendsocketresponsemessage.hasError(), forumrecommendsocketresponsemessage.getError(), StringUtils.isNull(forumrecommendsocketresponsemessage.getErrorString()) ? TbadkCoreApplication.m411getInst().getApp().getResources().getString(i.h.neterror) : forumrecommendsocketresponsemessage.getErrorString(), false, forumrecommendsocketresponsemessage.getDownSize(), 0L, forumrecommendsocketresponsemessage.getCostTime());
    }

    public void a(forumRecommendHttpResponseMessage forumrecommendhttpresponsemessage) {
        a(forumrecommendhttpresponsemessage, forumrecommendhttpresponsemessage.hasError(), forumrecommendhttpresponsemessage.getError(), StringUtils.isNull(forumrecommendhttpresponsemessage.getErrorString()) ? TbadkCoreApplication.m411getInst().getApp().getResources().getString(i.h.neterror) : forumrecommendhttpresponsemessage.getErrorString(), true, forumrecommendhttpresponsemessage.getDownSize(), forumrecommendhttpresponsemessage.getCostTime(), 0L);
    }

    public void a(ResponsedMessage<?> responsedMessage, boolean z, int i, String str, boolean z2, int i2, long j, long j2) {
        if (z) {
            this.aMi = null;
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
                this.aMi = new com.baidu.tieba.enterForum.b.b();
                this.aMi.setTime(forumrecommendhttpresponsemessage.GetIsLogin().intValue());
                this.aMi.eW(forumrecommendhttpresponsemessage.GetMsignValid().intValue());
                this.aMi.gt(forumrecommendhttpresponsemessage.GetMsignText());
                this.aMi.eX(forumrecommendhttpresponsemessage.GetMsignLevel().intValue());
                this.aMi.setIsMem(forumrecommendhttpresponsemessage.GetIsMem().intValue());
                this.aMi.eV(forumrecommendhttpresponsemessage.GetIsLogin().intValue());
                this.aMi.bK(false);
                com.baidu.tieba.enterForum.b.d dVar = new com.baidu.tieba.enterForum.b.d();
                dVar.setLevel(forumrecommendhttpresponsemessage.GetMsignLevel().intValue());
                dVar.I(forumrecommendhttpresponsemessage.GetLikeForum());
                this.aMi.a(dVar);
                com.baidu.tieba.enterForum.b.g gVar = new com.baidu.tieba.enterForum.b.g();
                gVar.J(forumrecommendhttpresponsemessage.GetRecommendForumInfoList());
                this.aMi.a(gVar);
                h hVar = new h();
                hVar.I(forumrecommendhttpresponsemessage.GetBanner());
                this.aMi.a(hVar);
                this.aMi.ap(true);
                this.aMi.a(forumrecommendhttpresponsemessage.getHotSearchInfoData());
            } catch (Exception e) {
                this.aMi.ap(false);
                BdLog.e(e.getMessage());
            }
        }
    }

    public void b(forumRecommendSocketResponseMessage forumrecommendsocketresponsemessage) {
        if (forumrecommendsocketresponsemessage != null) {
            try {
                this.aMi = new com.baidu.tieba.enterForum.b.b();
                this.aMi.setTime(forumrecommendsocketresponsemessage.GetIsLogin().intValue());
                this.aMi.eW(forumrecommendsocketresponsemessage.GetMsignValid().intValue());
                this.aMi.gt(forumrecommendsocketresponsemessage.GetMsignText());
                this.aMi.eX(forumrecommendsocketresponsemessage.GetMsignLevel().intValue());
                this.aMi.setIsMem(forumrecommendsocketresponsemessage.GetIsMem().intValue());
                this.aMi.eV(forumrecommendsocketresponsemessage.GetIsLogin().intValue());
                this.aMi.bK(false);
                com.baidu.tieba.enterForum.b.d dVar = new com.baidu.tieba.enterForum.b.d();
                dVar.setLevel(forumrecommendsocketresponsemessage.GetMsignLevel().intValue());
                dVar.I(forumrecommendsocketresponsemessage.GetLikeForum());
                this.aMi.a(dVar);
                com.baidu.tieba.enterForum.b.g gVar = new com.baidu.tieba.enterForum.b.g();
                gVar.J(forumrecommendsocketresponsemessage.GetRecommendForumInfoList());
                this.aMi.a(gVar);
                h hVar = new h();
                hVar.I(forumrecommendsocketresponsemessage.GetBanner());
                this.aMi.a(hVar);
                this.aMi.ap(true);
                this.aMi.a(forumrecommendsocketresponsemessage.getHotSearchInfoData());
            } catch (Exception e) {
                this.aMi.ap(false);
                BdLog.e(e.getMessage());
            }
        }
    }

    private void ID() {
        IE().a("forumRecommend_cache_key", new d(this, new com.baidu.tieba.enterForum.b.b()));
    }

    private o<byte[]> IE() {
        return com.baidu.tbadk.core.b.a.sO().T("tb_forum_recommend", TbadkCoreApplication.getCurrentAccountName());
    }

    public void eY(int i) {
        com.baidu.tbadk.core.sharedPref.b.tu().putInt("shared_key_forum_column_type_" + TbadkCoreApplication.getCurrentAccount(), i);
    }

    public int eZ(int i) {
        return com.baidu.tbadk.core.sharedPref.b.tu().getInt("shared_key_forum_column_type_" + TbadkCoreApplication.getCurrentAccount(), i);
    }

    public boolean hasShowForumEditGuide() {
        return com.baidu.tbadk.core.sharedPref.b.tu().getString(new StringBuilder("shared_key_forum_edit_guide_").append(TbadkCoreApplication.getCurrentAccount()).toString(), "").equals(TbConfig.getVersion());
    }

    public void L(List<v> list) {
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

    public String[] IF() {
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

    public List<v> M(List<v> list) {
        if (list != null && !list.isEmpty()) {
            Collections.sort(list, new f(this));
        }
        return list;
    }

    public void ak(long j) {
        com.baidu.tbadk.core.sharedPref.b.tu().putLong("last_close_recommend_time@" + TbadkCoreApplication.getCurrentAccount(), j);
    }

    public long IG() {
        return com.baidu.tbadk.core.sharedPref.b.tu().getLong("last_close_recommend_time@" + TbadkCoreApplication.getCurrentAccount(), 0L);
    }

    public boolean al(long j) {
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
