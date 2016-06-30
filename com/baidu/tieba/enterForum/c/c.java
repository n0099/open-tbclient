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
import com.baidu.tieba.tbadkCore.x;
import com.baidu.tieba.u;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/* loaded from: classes.dex */
public class c extends com.baidu.adp.base.e {
    private com.baidu.tieba.enterForum.b.b btP;
    private b btQ;
    private com.baidu.tieba.tbadkCore.d.b btR;
    private long btS;
    private long btT;
    private long btU;
    private long btV;

    /* loaded from: classes.dex */
    public interface b {
        void a(a aVar);
    }

    /* loaded from: classes.dex */
    public class a {
        public String btX = "";
        public boolean btY = false;
        public int type = -1;
        public com.baidu.tieba.enterForum.b.b btZ = null;

        public a() {
        }
    }

    public c(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.btP = null;
        this.btQ = null;
        this.btR = null;
        this.btS = 0L;
        this.btT = 0L;
        this.btU = 0L;
        this.btV = 0L;
        setUniqueId(BdUniqueId.gen());
    }

    @Override // com.baidu.adp.base.e
    public BdUniqueId getUniqueId() {
        return this.unique_id;
    }

    public long Sq() {
        return this.btV;
    }

    public long Sr() {
        return this.btT;
    }

    public long Ss() {
        return this.btU;
    }

    public long St() {
        return this.btS;
    }

    public com.baidu.tieba.enterForum.b.b Su() {
        return this.btP;
    }

    public void e(com.baidu.tieba.enterForum.b.b bVar) {
        this.btP = bVar;
    }

    public void a(b bVar) {
        this.btQ = bVar;
    }

    @Override // com.baidu.adp.base.e
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.e
    public boolean cancelLoadData() {
        cancelMessage();
        Sv();
        return true;
    }

    private void Sv() {
        if (this.btR != null) {
            this.btR.destory();
            this.btR = null;
        }
    }

    public boolean cP(boolean z) {
        cancelLoadData();
        forumRecommendRequestMessage forumrecommendrequestmessage = new forumRecommendRequestMessage();
        forumrecommendrequestmessage.set_like_forum(Integer.valueOf(z ? 1 : 0));
        forumrecommendrequestmessage.set_topic(0);
        forumrecommendrequestmessage.set_recommend(1);
        this.btS = System.currentTimeMillis();
        if (this.btR == null) {
            this.btR = new com.baidu.tieba.tbadkCore.d.b("forumrecommendStat");
        }
        sendMessage(forumrecommendrequestmessage);
        return true;
    }

    public boolean cQ(boolean z) {
        Sw();
        return true;
    }

    public void a(boolean z, int i, String str, boolean z2, int i2, long j, long j2) {
        a aVar = new a();
        boolean z3 = !z;
        if (this.btR != null) {
            this.btR.a(z2, z3, i, str, i2, j, j2);
            this.btR = null;
        }
        this.btP.cK(false);
        if (z || !this.btP.isSuccess()) {
            if (str != null && str.length() > 0) {
                setErrorString(str);
                aVar.btX = str;
            }
            aVar.type = 1;
            aVar.btY = false;
            aVar.btZ = this.btP;
            this.btQ.a(aVar);
            return;
        }
        aVar.type = 1;
        aVar.btY = true;
        aVar.btZ = this.btP;
        this.btQ.a(aVar);
    }

    public void a(forumRecommendSocketResponseMessage forumrecommendsocketresponsemessage) {
        String errorString;
        int downSize = forumrecommendsocketresponsemessage.getDownSize();
        long costTime = forumrecommendsocketresponsemessage.getCostTime();
        if (StringUtils.isNull(forumrecommendsocketresponsemessage.getErrorString())) {
            errorString = TbadkCoreApplication.m9getInst().getApp().getResources().getString(u.j.neterror);
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
            errorString = TbadkCoreApplication.m9getInst().getApp().getResources().getString(u.j.neterror);
        } else {
            errorString = forumrecommendhttpresponsemessage.getErrorString();
        }
        a(forumrecommendhttpresponsemessage, forumrecommendhttpresponsemessage.hasError(), forumrecommendhttpresponsemessage.getError(), errorString, true, downSize, costTime, 0L);
    }

    public void a(ResponsedMessage<?> responsedMessage, boolean z, int i, String str, boolean z2, int i2, long j, long j2) {
        if (z) {
            this.btP = null;
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
                this.btP = new com.baidu.tieba.enterForum.b.b();
                this.btP.setTime(forumrecommendhttpresponsemessage.GetIsLogin().intValue());
                this.btP.gK(forumrecommendhttpresponsemessage.GetMsignValid().intValue());
                this.btP.iv(forumrecommendhttpresponsemessage.GetMsignText());
                this.btP.gL(forumrecommendhttpresponsemessage.GetMsignLevel().intValue());
                this.btP.setIsMem(forumrecommendhttpresponsemessage.GetIsMem().intValue());
                this.btP.gJ(forumrecommendhttpresponsemessage.GetIsLogin().intValue());
                this.btP.cK(false);
                com.baidu.tieba.enterForum.b.e eVar = new com.baidu.tieba.enterForum.b.e();
                eVar.setLevel(forumrecommendhttpresponsemessage.GetMsignLevel().intValue());
                eVar.aa(forumrecommendhttpresponsemessage.GetLikeForum());
                this.btP.a(eVar);
                h hVar = new h();
                hVar.Z(forumrecommendhttpresponsemessage.GetRecommendForumInfoList());
                this.btP.a(hVar);
                com.baidu.tieba.enterForum.b.c cVar = new com.baidu.tieba.enterForum.b.c();
                cVar.Z(forumrecommendhttpresponsemessage.getFrequentlyForumInfo());
                this.btP.a(cVar);
                i iVar = new i();
                iVar.aa(forumrecommendhttpresponsemessage.GetBanner());
                this.btP.a(iVar);
                i iVar2 = new i();
                iVar2.aa(forumrecommendhttpresponsemessage.getNewBannerInfo());
                this.btP.b(iVar2);
                this.btP.at(true);
                this.btP.a(forumrecommendhttpresponsemessage.getHotSearchInfoData());
            } catch (Exception e) {
                this.btP.at(false);
                BdLog.e(e.getMessage());
            }
        }
    }

    public void b(forumRecommendSocketResponseMessage forumrecommendsocketresponsemessage) {
        if (forumrecommendsocketresponsemessage != null) {
            try {
                this.btP = new com.baidu.tieba.enterForum.b.b();
                this.btP.setTime(forumrecommendsocketresponsemessage.GetIsLogin().intValue());
                this.btP.gK(forumrecommendsocketresponsemessage.GetMsignValid().intValue());
                this.btP.iv(forumrecommendsocketresponsemessage.GetMsignText());
                this.btP.gL(forumrecommendsocketresponsemessage.GetMsignLevel().intValue());
                this.btP.setIsMem(forumrecommendsocketresponsemessage.GetIsMem().intValue());
                this.btP.gJ(forumrecommendsocketresponsemessage.GetIsLogin().intValue());
                this.btP.cK(false);
                com.baidu.tieba.enterForum.b.e eVar = new com.baidu.tieba.enterForum.b.e();
                eVar.setLevel(forumrecommendsocketresponsemessage.GetMsignLevel().intValue());
                eVar.aa(forumrecommendsocketresponsemessage.GetLikeForum());
                this.btP.a(eVar);
                h hVar = new h();
                hVar.Z(forumrecommendsocketresponsemessage.GetRecommendForumInfoList());
                this.btP.a(hVar);
                com.baidu.tieba.enterForum.b.c cVar = new com.baidu.tieba.enterForum.b.c();
                cVar.Z(forumrecommendsocketresponsemessage.getFrequentlyForumInfo());
                this.btP.a(cVar);
                i iVar = new i();
                iVar.aa(forumrecommendsocketresponsemessage.GetBanner());
                this.btP.a(iVar);
                i iVar2 = new i();
                iVar2.aa(forumrecommendsocketresponsemessage.getNewBannerInfo());
                this.btP.b(iVar2);
                this.btP.at(true);
                this.btP.a(forumrecommendsocketresponsemessage.getHotSearchInfoData());
            } catch (Exception e) {
                this.btP.at(false);
                BdLog.e(e.getMessage());
            }
        }
    }

    private void Sw() {
        new d(this).execute(new Void[0]);
    }

    public void gP(int i) {
        com.baidu.tbadk.core.sharedPref.b.sO().putInt("shared_key_forum_column_type_" + TbadkCoreApplication.getCurrentAccount(), i);
    }

    public int gQ(int i) {
        return com.baidu.tbadk.core.sharedPref.b.sO().getInt("shared_key_forum_column_type_" + TbadkCoreApplication.getCurrentAccount(), i);
    }

    public void ac(List<x> list) {
        if (list != null) {
            StringBuilder sb = new StringBuilder();
            for (x xVar : list) {
                if (xVar != null) {
                    sb.append(xVar.getId()).append("#");
                }
            }
            com.baidu.tbadk.core.sharedPref.b.sO().putString("shared_key_forum_sort" + TbadkCoreApplication.getCurrentAccount(), sb.toString());
        }
    }

    public String[] Sx() {
        return com.baidu.tbadk.core.sharedPref.b.sO().getString("shared_key_forum_sort" + TbadkCoreApplication.getCurrentAccount(), "").split("#");
    }

    public List<x> a(List<x> list, String[] strArr) {
        ArrayList arrayList = new ArrayList();
        if (list == null || list.isEmpty()) {
            return arrayList;
        }
        if (strArr == null || strArr.length == 0) {
            arrayList.addAll(list);
        } else {
            for (String str : strArr) {
                for (x xVar : list) {
                    if (xVar != null && xVar.getId() != null && xVar.getId().equals(str)) {
                        arrayList.add(xVar);
                    }
                }
            }
            for (int size = list.size() - 1; size >= 0; size--) {
                x xVar2 = list.get(size);
                if (!arrayList.contains(xVar2)) {
                    arrayList.add(0, xVar2);
                }
            }
        }
        return arrayList;
    }

    public List<x> ad(List<x> list) {
        if (list != null && !list.isEmpty()) {
            Collections.sort(list, new e(this));
        }
        return list;
    }

    public void aN(long j) {
        com.baidu.tbadk.core.sharedPref.b.sO().putLong("last_close_recommend_time@" + TbadkCoreApplication.getCurrentAccount(), j);
    }

    public long Sy() {
        return com.baidu.tbadk.core.sharedPref.b.sO().getLong("last_close_recommend_time@" + TbadkCoreApplication.getCurrentAccount(), 0L);
    }

    public boolean aO(long j) {
        return System.currentTimeMillis() - j > TbConfig.APP_OVERDUR_DRAFT_BOX;
    }

    public boolean e(List<x> list, List<x> list2) {
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
            x xVar = list.get(i);
            x xVar2 = list2.get(i);
            if (xVar == null || xVar2 == null) {
                return false;
            }
            if (!xVar.getId().equals(xVar2.getId())) {
                return false;
            }
        }
        return true;
    }
}
