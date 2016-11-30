package com.baidu.tieba.enterForum.c;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.enterForum.b.h;
import com.baidu.tieba.enterForum.b.i;
import com.baidu.tieba.enterForum.home.forumRecommendHttpResponseMessage;
import com.baidu.tieba.enterForum.home.forumRecommendRequestMessage;
import com.baidu.tieba.enterForum.home.forumRecommendSocketResponseMessage;
import com.baidu.tieba.r;
import com.baidu.tieba.tbadkCore.w;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/* loaded from: classes.dex */
public class c extends com.baidu.adp.base.e {
    private com.baidu.tieba.enterForum.b.b bKs;
    private b bKt;
    private com.baidu.tieba.tbadkCore.d.b bKu;
    private long bKv;
    private long bKw;
    private long bKx;
    private long bKy;

    /* loaded from: classes.dex */
    public interface b {
        void a(a aVar);
    }

    /* loaded from: classes.dex */
    public class a {
        public String bKA = "";
        public boolean bKB = false;
        public int type = -1;
        public com.baidu.tieba.enterForum.b.b bKC = null;

        public a() {
        }
    }

    public c(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.bKs = null;
        this.bKt = null;
        this.bKu = null;
        this.bKv = 0L;
        this.bKw = 0L;
        this.bKx = 0L;
        this.bKy = 0L;
        setUniqueId(BdUniqueId.gen());
    }

    @Override // com.baidu.adp.base.e
    public BdUniqueId getUniqueId() {
        return this.unique_id;
    }

    public long Ze() {
        return this.bKy;
    }

    public long Zf() {
        return this.bKw;
    }

    public long Zg() {
        return this.bKx;
    }

    public long Zh() {
        return this.bKv;
    }

    public com.baidu.tieba.enterForum.b.b Zi() {
        return this.bKs;
    }

    public void d(com.baidu.tieba.enterForum.b.b bVar) {
        this.bKs = bVar;
    }

    public void a(b bVar) {
        this.bKt = bVar;
    }

    @Override // com.baidu.adp.base.e
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.e
    public boolean cancelLoadData() {
        cancelMessage();
        Zj();
        return true;
    }

    private void Zj() {
        if (this.bKu != null) {
            this.bKu.destory();
            this.bKu = null;
        }
    }

    public boolean ds(boolean z) {
        cancelLoadData();
        forumRecommendRequestMessage forumrecommendrequestmessage = new forumRecommendRequestMessage();
        forumrecommendrequestmessage.set_like_forum(Integer.valueOf(z ? 1 : 0));
        forumrecommendrequestmessage.set_topic(0);
        forumrecommendrequestmessage.set_recommend(1);
        this.bKv = System.currentTimeMillis();
        if (this.bKu == null) {
            this.bKu = new com.baidu.tieba.tbadkCore.d.b("forumrecommendStat");
        }
        sendMessage(forumrecommendrequestmessage);
        return true;
    }

    public boolean dt(boolean z) {
        Zk();
        return true;
    }

    public void a(boolean z, int i, String str, boolean z2, int i2, long j, long j2) {
        a aVar = new a();
        boolean z3 = !z;
        if (this.bKu != null) {
            this.bKu.a(z2, z3, i, str, i2, j, j2);
            this.bKu = null;
        }
        this.bKs.dn(false);
        if (z || !this.bKs.isSuccess()) {
            if (str != null && str.length() > 0) {
                setErrorString(str);
                aVar.bKA = str;
            }
            aVar.type = 1;
            aVar.bKB = false;
            aVar.bKC = this.bKs;
            this.bKt.a(aVar);
            return;
        }
        aVar.type = 1;
        aVar.bKB = true;
        aVar.bKC = this.bKs;
        this.bKt.a(aVar);
    }

    public void a(forumRecommendSocketResponseMessage forumrecommendsocketresponsemessage) {
        String errorString;
        int downSize = forumrecommendsocketresponsemessage.getDownSize();
        long costTime = forumrecommendsocketresponsemessage.getCostTime();
        if (StringUtils.isNull(forumrecommendsocketresponsemessage.getErrorString())) {
            errorString = TbadkCoreApplication.m9getInst().getApp().getResources().getString(r.j.neterror);
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
            errorString = TbadkCoreApplication.m9getInst().getApp().getResources().getString(r.j.neterror);
        } else {
            errorString = forumrecommendhttpresponsemessage.getErrorString();
        }
        a(forumrecommendhttpresponsemessage, forumrecommendhttpresponsemessage.hasError(), forumrecommendhttpresponsemessage.getError(), errorString, true, downSize, costTime, 0L);
    }

    public void a(ResponsedMessage<?> responsedMessage, boolean z, int i, String str, boolean z2, int i2, long j, long j2) {
        if (z) {
            this.bKs = null;
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
                this.bKs = new com.baidu.tieba.enterForum.b.b();
                this.bKs.setTime(forumrecommendhttpresponsemessage.GetIsLogin().intValue());
                this.bKs.hr(forumrecommendhttpresponsemessage.GetMsignValid().intValue());
                this.bKs.jv(forumrecommendhttpresponsemessage.GetMsignText());
                this.bKs.hs(forumrecommendhttpresponsemessage.GetMsignLevel().intValue());
                this.bKs.setIsMem(forumrecommendhttpresponsemessage.GetIsMem().intValue());
                this.bKs.hq(forumrecommendhttpresponsemessage.GetIsLogin().intValue());
                this.bKs.dn(false);
                com.baidu.tieba.enterForum.b.e eVar = new com.baidu.tieba.enterForum.b.e();
                eVar.setLevel(forumrecommendhttpresponsemessage.GetMsignLevel().intValue());
                eVar.ai(forumrecommendhttpresponsemessage.GetLikeForum());
                this.bKs.a(eVar);
                h hVar = new h();
                hVar.ah(forumrecommendhttpresponsemessage.GetRecommendForumInfoList());
                this.bKs.a(hVar);
                com.baidu.tieba.enterForum.b.c cVar = new com.baidu.tieba.enterForum.b.c();
                cVar.ah(forumrecommendhttpresponsemessage.getFrequentlyForumInfo());
                this.bKs.a(cVar);
                i iVar = new i();
                iVar.ai(forumrecommendhttpresponsemessage.GetBanner());
                this.bKs.a(iVar);
                i iVar2 = new i();
                iVar2.ai(forumrecommendhttpresponsemessage.getNewBannerInfo());
                this.bKs.b(iVar2);
                this.bKs.aA(true);
                this.bKs.a(forumrecommendhttpresponsemessage.getHotSearchInfoData());
            } catch (Exception e) {
                this.bKs.aA(false);
                BdLog.e(e.getMessage());
            }
        }
    }

    public void b(forumRecommendSocketResponseMessage forumrecommendsocketresponsemessage) {
        if (forumrecommendsocketresponsemessage != null) {
            try {
                this.bKs = new com.baidu.tieba.enterForum.b.b();
                this.bKs.setTime(forumrecommendsocketresponsemessage.GetIsLogin().intValue());
                this.bKs.hr(forumrecommendsocketresponsemessage.GetMsignValid().intValue());
                this.bKs.jv(forumrecommendsocketresponsemessage.GetMsignText());
                this.bKs.hs(forumrecommendsocketresponsemessage.GetMsignLevel().intValue());
                this.bKs.setIsMem(forumrecommendsocketresponsemessage.GetIsMem().intValue());
                this.bKs.hq(forumrecommendsocketresponsemessage.GetIsLogin().intValue());
                this.bKs.dn(false);
                com.baidu.tieba.enterForum.b.e eVar = new com.baidu.tieba.enterForum.b.e();
                eVar.setLevel(forumrecommendsocketresponsemessage.GetMsignLevel().intValue());
                eVar.ai(forumrecommendsocketresponsemessage.GetLikeForum());
                this.bKs.a(eVar);
                h hVar = new h();
                hVar.ah(forumrecommendsocketresponsemessage.GetRecommendForumInfoList());
                this.bKs.a(hVar);
                com.baidu.tieba.enterForum.b.c cVar = new com.baidu.tieba.enterForum.b.c();
                cVar.ah(forumrecommendsocketresponsemessage.getFrequentlyForumInfo());
                this.bKs.a(cVar);
                i iVar = new i();
                iVar.ai(forumrecommendsocketresponsemessage.GetBanner());
                this.bKs.a(iVar);
                i iVar2 = new i();
                iVar2.ai(forumrecommendsocketresponsemessage.getNewBannerInfo());
                this.bKs.b(iVar2);
                this.bKs.aA(true);
                this.bKs.a(forumrecommendsocketresponsemessage.getHotSearchInfoData());
            } catch (Exception e) {
                this.bKs.aA(false);
                BdLog.e(e.getMessage());
            }
        }
    }

    private void Zk() {
        new d(this).execute(new Void[0]);
    }

    public void hw(int i) {
        com.baidu.tbadk.core.sharedPref.b.um().putInt("shared_key_forum_column_type_" + TbadkCoreApplication.getCurrentAccount(), i);
    }

    public int hx(int i) {
        return com.baidu.tbadk.core.sharedPref.b.um().getInt("shared_key_forum_column_type_" + TbadkCoreApplication.getCurrentAccount(), i);
    }

    public void ak(List<w> list) {
        if (list != null) {
            StringBuilder sb = new StringBuilder();
            for (w wVar : list) {
                if (wVar != null) {
                    sb.append(wVar.getId()).append("#");
                }
            }
            com.baidu.tbadk.core.sharedPref.b.um().putString("shared_key_forum_sort" + TbadkCoreApplication.getCurrentAccount(), sb.toString());
        }
    }

    public String[] Zl() {
        return com.baidu.tbadk.core.sharedPref.b.um().getString("shared_key_forum_sort" + TbadkCoreApplication.getCurrentAccount(), "").split("#");
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

    public List<w> al(List<w> list) {
        if (list != null && !list.isEmpty()) {
            Collections.sort(list, new e(this));
        }
        return list;
    }

    public void bc(long j) {
        com.baidu.tbadk.core.sharedPref.b.um().putLong("last_close_recommend_time@" + TbadkCoreApplication.getCurrentAccount(), j);
    }

    public long Zm() {
        return com.baidu.tbadk.core.sharedPref.b.um().getLong("last_close_recommend_time@" + TbadkCoreApplication.getCurrentAccount(), 0L);
    }

    public boolean bd(long j) {
        return System.currentTimeMillis() - j > TbConfig.APP_OVERDUR_DRAFT_BOX;
    }

    public boolean g(List<w> list, List<w> list2) {
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
            if (wVar == null || wVar2 == null) {
                return false;
            }
            if (!wVar.getId().equals(wVar2.getId())) {
                return false;
            }
        }
        return true;
    }
}
