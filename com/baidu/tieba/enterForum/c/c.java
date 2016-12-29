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
import com.baidu.tieba.tbadkCore.v;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/* loaded from: classes.dex */
public class c extends com.baidu.adp.base.e {
    private long bqA;
    private long bqB;
    private long bqC;
    private com.baidu.tieba.enterForum.b.b bqw;
    private b bqx;
    private com.baidu.tieba.tbadkCore.d.b bqy;
    private long bqz;

    /* loaded from: classes.dex */
    public interface b {
        void a(a aVar);
    }

    /* loaded from: classes.dex */
    public class a {
        public String bqE = "";
        public boolean bqF = false;
        public int type = -1;
        public com.baidu.tieba.enterForum.b.b bqG = null;

        public a() {
        }
    }

    public c(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.bqw = null;
        this.bqx = null;
        this.bqy = null;
        this.bqz = 0L;
        this.bqA = 0L;
        this.bqB = 0L;
        this.bqC = 0L;
        setUniqueId(BdUniqueId.gen());
    }

    @Override // com.baidu.adp.base.e
    public BdUniqueId getUniqueId() {
        return this.unique_id;
    }

    public long Tr() {
        return this.bqC;
    }

    public long Ts() {
        return this.bqA;
    }

    public long Tt() {
        return this.bqB;
    }

    public long Tu() {
        return this.bqz;
    }

    public com.baidu.tieba.enterForum.b.b Tv() {
        return this.bqw;
    }

    public void d(com.baidu.tieba.enterForum.b.b bVar) {
        this.bqw = bVar;
    }

    public void a(b bVar) {
        this.bqx = bVar;
    }

    @Override // com.baidu.adp.base.e
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.e
    public boolean cancelLoadData() {
        cancelMessage();
        Tw();
        return true;
    }

    private void Tw() {
        if (this.bqy != null) {
            this.bqy.destory();
            this.bqy = null;
        }
    }

    public boolean da(boolean z) {
        cancelLoadData();
        forumRecommendRequestMessage forumrecommendrequestmessage = new forumRecommendRequestMessage();
        forumrecommendrequestmessage.set_like_forum(Integer.valueOf(z ? 1 : 0));
        forumrecommendrequestmessage.set_topic(0);
        forumrecommendrequestmessage.set_recommend(1);
        this.bqz = System.currentTimeMillis();
        if (this.bqy == null) {
            this.bqy = new com.baidu.tieba.tbadkCore.d.b("forumrecommendStat");
        }
        sendMessage(forumrecommendrequestmessage);
        return true;
    }

    public boolean db(boolean z) {
        Tx();
        return true;
    }

    public void a(boolean z, int i, String str, boolean z2, int i2, long j, long j2) {
        a aVar = new a();
        boolean z3 = !z;
        if (this.bqy != null) {
            this.bqy.a(z2, z3, i, str, i2, j, j2);
            this.bqy = null;
        }
        this.bqw.cV(false);
        if (z || !this.bqw.isSuccess()) {
            if (str != null && str.length() > 0) {
                setErrorString(str);
                aVar.bqE = str;
            }
            aVar.type = 1;
            aVar.bqF = false;
            aVar.bqG = this.bqw;
            this.bqx.a(aVar);
            return;
        }
        aVar.type = 1;
        aVar.bqF = true;
        aVar.bqG = this.bqw;
        this.bqx.a(aVar);
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
            this.bqw = null;
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
                this.bqw = new com.baidu.tieba.enterForum.b.b();
                this.bqw.setTime(forumrecommendhttpresponsemessage.GetIsLogin().intValue());
                this.bqw.gB(forumrecommendhttpresponsemessage.GetMsignValid().intValue());
                this.bqw.ia(forumrecommendhttpresponsemessage.GetMsignText());
                this.bqw.gC(forumrecommendhttpresponsemessage.GetMsignLevel().intValue());
                this.bqw.setIsMem(forumrecommendhttpresponsemessage.GetIsMem().intValue());
                this.bqw.gA(forumrecommendhttpresponsemessage.GetIsLogin().intValue());
                this.bqw.cV(false);
                com.baidu.tieba.enterForum.b.e eVar = new com.baidu.tieba.enterForum.b.e();
                eVar.setLevel(forumrecommendhttpresponsemessage.GetMsignLevel().intValue());
                eVar.aa(forumrecommendhttpresponsemessage.GetLikeForum());
                this.bqw.a(eVar);
                h hVar = new h();
                hVar.Z(forumrecommendhttpresponsemessage.GetRecommendForumInfoList());
                this.bqw.a(hVar);
                com.baidu.tieba.enterForum.b.c cVar = new com.baidu.tieba.enterForum.b.c();
                cVar.Z(forumrecommendhttpresponsemessage.getFrequentlyForumInfo());
                this.bqw.a(cVar);
                i iVar = new i();
                iVar.aa(forumrecommendhttpresponsemessage.GetBanner());
                this.bqw.a(iVar);
                i iVar2 = new i();
                iVar2.aa(forumrecommendhttpresponsemessage.getNewBannerInfo());
                this.bqw.b(iVar2);
                this.bqw.aB(true);
                this.bqw.a(forumrecommendhttpresponsemessage.getHotSearchInfoData());
            } catch (Exception e) {
                this.bqw.aB(false);
                BdLog.e(e.getMessage());
            }
        }
    }

    public void b(forumRecommendSocketResponseMessage forumrecommendsocketresponsemessage) {
        if (forumrecommendsocketresponsemessage != null) {
            try {
                this.bqw = new com.baidu.tieba.enterForum.b.b();
                this.bqw.setTime(forumrecommendsocketresponsemessage.GetIsLogin().intValue());
                this.bqw.gB(forumrecommendsocketresponsemessage.GetMsignValid().intValue());
                this.bqw.ia(forumrecommendsocketresponsemessage.GetMsignText());
                this.bqw.gC(forumrecommendsocketresponsemessage.GetMsignLevel().intValue());
                this.bqw.setIsMem(forumrecommendsocketresponsemessage.GetIsMem().intValue());
                this.bqw.gA(forumrecommendsocketresponsemessage.GetIsLogin().intValue());
                this.bqw.cV(false);
                com.baidu.tieba.enterForum.b.e eVar = new com.baidu.tieba.enterForum.b.e();
                eVar.setLevel(forumrecommendsocketresponsemessage.GetMsignLevel().intValue());
                eVar.aa(forumrecommendsocketresponsemessage.GetLikeForum());
                this.bqw.a(eVar);
                h hVar = new h();
                hVar.Z(forumrecommendsocketresponsemessage.GetRecommendForumInfoList());
                this.bqw.a(hVar);
                com.baidu.tieba.enterForum.b.c cVar = new com.baidu.tieba.enterForum.b.c();
                cVar.Z(forumrecommendsocketresponsemessage.getFrequentlyForumInfo());
                this.bqw.a(cVar);
                i iVar = new i();
                iVar.aa(forumrecommendsocketresponsemessage.GetBanner());
                this.bqw.a(iVar);
                i iVar2 = new i();
                iVar2.aa(forumrecommendsocketresponsemessage.getNewBannerInfo());
                this.bqw.b(iVar2);
                this.bqw.aB(true);
                this.bqw.a(forumrecommendsocketresponsemessage.getHotSearchInfoData());
            } catch (Exception e) {
                this.bqw.aB(false);
                BdLog.e(e.getMessage());
            }
        }
    }

    private void Tx() {
        new d(this).execute(new Void[0]);
    }

    public void gG(int i) {
        com.baidu.tbadk.core.sharedPref.b.tW().putInt("shared_key_forum_column_type_" + TbadkCoreApplication.getCurrentAccount(), i);
    }

    public int gH(int i) {
        return com.baidu.tbadk.core.sharedPref.b.tW().getInt("shared_key_forum_column_type_" + TbadkCoreApplication.getCurrentAccount(), i);
    }

    public void ac(List<v> list) {
        if (list != null) {
            StringBuilder sb = new StringBuilder();
            for (v vVar : list) {
                if (vVar != null) {
                    sb.append(vVar.getId()).append("#");
                }
            }
            com.baidu.tbadk.core.sharedPref.b.tW().putString("shared_key_forum_sort" + TbadkCoreApplication.getCurrentAccount(), sb.toString());
        }
    }

    public String[] Ty() {
        return com.baidu.tbadk.core.sharedPref.b.tW().getString("shared_key_forum_sort" + TbadkCoreApplication.getCurrentAccount(), "").split("#");
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

    public List<v> ad(List<v> list) {
        if (list != null && !list.isEmpty()) {
            Collections.sort(list, new e(this));
        }
        return list;
    }

    public void aP(long j) {
        com.baidu.tbadk.core.sharedPref.b.tW().putLong("last_close_recommend_time@" + TbadkCoreApplication.getCurrentAccount(), j);
    }

    public long Tz() {
        return com.baidu.tbadk.core.sharedPref.b.tW().getLong("last_close_recommend_time@" + TbadkCoreApplication.getCurrentAccount(), 0L);
    }

    public boolean aQ(long j) {
        return System.currentTimeMillis() - j > TbConfig.APP_OVERDUR_DRAFT_BOX;
    }

    public boolean f(List<v> list, List<v> list2) {
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
            if (vVar == null || vVar2 == null) {
                return false;
            }
            if (!vVar.getId().equals(vVar2.getId())) {
                return false;
            }
        }
        return true;
    }
}
