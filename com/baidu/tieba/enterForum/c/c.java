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
    private com.baidu.tieba.tbadkCore.d.b bHA;
    private long bHB;
    private long bHC;
    private long bHD;
    private long bHE;
    private com.baidu.tieba.enterForum.b.b bHy;
    private b bHz;

    /* loaded from: classes.dex */
    public interface b {
        void a(a aVar);
    }

    /* loaded from: classes.dex */
    public class a {
        public String bHG = "";
        public boolean bHH = false;
        public int type = -1;
        public com.baidu.tieba.enterForum.b.b bHI = null;

        public a() {
        }
    }

    public c(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.bHy = null;
        this.bHz = null;
        this.bHA = null;
        this.bHB = 0L;
        this.bHC = 0L;
        this.bHD = 0L;
        this.bHE = 0L;
        setUniqueId(BdUniqueId.gen());
    }

    @Override // com.baidu.adp.base.e
    public BdUniqueId getUniqueId() {
        return this.unique_id;
    }

    public long Yc() {
        return this.bHE;
    }

    public long Yd() {
        return this.bHC;
    }

    public long Ye() {
        return this.bHD;
    }

    public long Yf() {
        return this.bHB;
    }

    public com.baidu.tieba.enterForum.b.b Yg() {
        return this.bHy;
    }

    public void d(com.baidu.tieba.enterForum.b.b bVar) {
        this.bHy = bVar;
    }

    public void a(b bVar) {
        this.bHz = bVar;
    }

    @Override // com.baidu.adp.base.e
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.e
    public boolean cancelLoadData() {
        cancelMessage();
        Yh();
        return true;
    }

    private void Yh() {
        if (this.bHA != null) {
            this.bHA.destory();
            this.bHA = null;
        }
    }

    public boolean dn(boolean z) {
        cancelLoadData();
        forumRecommendRequestMessage forumrecommendrequestmessage = new forumRecommendRequestMessage();
        forumrecommendrequestmessage.set_like_forum(Integer.valueOf(z ? 1 : 0));
        forumrecommendrequestmessage.set_topic(0);
        forumrecommendrequestmessage.set_recommend(1);
        this.bHB = System.currentTimeMillis();
        if (this.bHA == null) {
            this.bHA = new com.baidu.tieba.tbadkCore.d.b("forumrecommendStat");
        }
        sendMessage(forumrecommendrequestmessage);
        return true;
    }

    /* renamed from: do  reason: not valid java name */
    public boolean m13do(boolean z) {
        Yi();
        return true;
    }

    public void a(boolean z, int i, String str, boolean z2, int i2, long j, long j2) {
        a aVar = new a();
        boolean z3 = !z;
        if (this.bHA != null) {
            this.bHA.a(z2, z3, i, str, i2, j, j2);
            this.bHA = null;
        }
        this.bHy.di(false);
        if (z || !this.bHy.isSuccess()) {
            if (str != null && str.length() > 0) {
                setErrorString(str);
                aVar.bHG = str;
            }
            aVar.type = 1;
            aVar.bHH = false;
            aVar.bHI = this.bHy;
            this.bHz.a(aVar);
            return;
        }
        aVar.type = 1;
        aVar.bHH = true;
        aVar.bHI = this.bHy;
        this.bHz.a(aVar);
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
            this.bHy = null;
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
                this.bHy = new com.baidu.tieba.enterForum.b.b();
                this.bHy.setTime(forumrecommendhttpresponsemessage.GetIsLogin().intValue());
                this.bHy.hq(forumrecommendhttpresponsemessage.GetMsignValid().intValue());
                this.bHy.jr(forumrecommendhttpresponsemessage.GetMsignText());
                this.bHy.hr(forumrecommendhttpresponsemessage.GetMsignLevel().intValue());
                this.bHy.setIsMem(forumrecommendhttpresponsemessage.GetIsMem().intValue());
                this.bHy.hp(forumrecommendhttpresponsemessage.GetIsLogin().intValue());
                this.bHy.di(false);
                com.baidu.tieba.enterForum.b.e eVar = new com.baidu.tieba.enterForum.b.e();
                eVar.setLevel(forumrecommendhttpresponsemessage.GetMsignLevel().intValue());
                eVar.ah(forumrecommendhttpresponsemessage.GetLikeForum());
                this.bHy.a(eVar);
                h hVar = new h();
                hVar.ag(forumrecommendhttpresponsemessage.GetRecommendForumInfoList());
                this.bHy.a(hVar);
                com.baidu.tieba.enterForum.b.c cVar = new com.baidu.tieba.enterForum.b.c();
                cVar.ag(forumrecommendhttpresponsemessage.getFrequentlyForumInfo());
                this.bHy.a(cVar);
                i iVar = new i();
                iVar.ah(forumrecommendhttpresponsemessage.GetBanner());
                this.bHy.a(iVar);
                i iVar2 = new i();
                iVar2.ah(forumrecommendhttpresponsemessage.getNewBannerInfo());
                this.bHy.b(iVar2);
                this.bHy.ax(true);
                this.bHy.a(forumrecommendhttpresponsemessage.getHotSearchInfoData());
            } catch (Exception e) {
                this.bHy.ax(false);
                BdLog.e(e.getMessage());
            }
        }
    }

    public void b(forumRecommendSocketResponseMessage forumrecommendsocketresponsemessage) {
        if (forumrecommendsocketresponsemessage != null) {
            try {
                this.bHy = new com.baidu.tieba.enterForum.b.b();
                this.bHy.setTime(forumrecommendsocketresponsemessage.GetIsLogin().intValue());
                this.bHy.hq(forumrecommendsocketresponsemessage.GetMsignValid().intValue());
                this.bHy.jr(forumrecommendsocketresponsemessage.GetMsignText());
                this.bHy.hr(forumrecommendsocketresponsemessage.GetMsignLevel().intValue());
                this.bHy.setIsMem(forumrecommendsocketresponsemessage.GetIsMem().intValue());
                this.bHy.hp(forumrecommendsocketresponsemessage.GetIsLogin().intValue());
                this.bHy.di(false);
                com.baidu.tieba.enterForum.b.e eVar = new com.baidu.tieba.enterForum.b.e();
                eVar.setLevel(forumrecommendsocketresponsemessage.GetMsignLevel().intValue());
                eVar.ah(forumrecommendsocketresponsemessage.GetLikeForum());
                this.bHy.a(eVar);
                h hVar = new h();
                hVar.ag(forumrecommendsocketresponsemessage.GetRecommendForumInfoList());
                this.bHy.a(hVar);
                com.baidu.tieba.enterForum.b.c cVar = new com.baidu.tieba.enterForum.b.c();
                cVar.ag(forumrecommendsocketresponsemessage.getFrequentlyForumInfo());
                this.bHy.a(cVar);
                i iVar = new i();
                iVar.ah(forumrecommendsocketresponsemessage.GetBanner());
                this.bHy.a(iVar);
                i iVar2 = new i();
                iVar2.ah(forumrecommendsocketresponsemessage.getNewBannerInfo());
                this.bHy.b(iVar2);
                this.bHy.ax(true);
                this.bHy.a(forumrecommendsocketresponsemessage.getHotSearchInfoData());
            } catch (Exception e) {
                this.bHy.ax(false);
                BdLog.e(e.getMessage());
            }
        }
    }

    private void Yi() {
        new d(this).execute(new Void[0]);
    }

    public void hv(int i) {
        com.baidu.tbadk.core.sharedPref.b.uh().putInt("shared_key_forum_column_type_" + TbadkCoreApplication.getCurrentAccount(), i);
    }

    public int hw(int i) {
        return com.baidu.tbadk.core.sharedPref.b.uh().getInt("shared_key_forum_column_type_" + TbadkCoreApplication.getCurrentAccount(), i);
    }

    public void aj(List<w> list) {
        if (list != null) {
            StringBuilder sb = new StringBuilder();
            for (w wVar : list) {
                if (wVar != null) {
                    sb.append(wVar.getId()).append("#");
                }
            }
            com.baidu.tbadk.core.sharedPref.b.uh().putString("shared_key_forum_sort" + TbadkCoreApplication.getCurrentAccount(), sb.toString());
        }
    }

    public String[] Yj() {
        return com.baidu.tbadk.core.sharedPref.b.uh().getString("shared_key_forum_sort" + TbadkCoreApplication.getCurrentAccount(), "").split("#");
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

    public List<w> ak(List<w> list) {
        if (list != null && !list.isEmpty()) {
            Collections.sort(list, new e(this));
        }
        return list;
    }

    public void be(long j) {
        com.baidu.tbadk.core.sharedPref.b.uh().putLong("last_close_recommend_time@" + TbadkCoreApplication.getCurrentAccount(), j);
    }

    public long Yk() {
        return com.baidu.tbadk.core.sharedPref.b.uh().getLong("last_close_recommend_time@" + TbadkCoreApplication.getCurrentAccount(), 0L);
    }

    public boolean bf(long j) {
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
