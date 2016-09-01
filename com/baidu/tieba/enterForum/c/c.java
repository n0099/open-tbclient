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
import com.baidu.tieba.t;
import com.baidu.tieba.tbadkCore.w;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/* loaded from: classes.dex */
public class c extends com.baidu.adp.base.e {
    private com.baidu.tieba.enterForum.b.b bHr;
    private b bHs;
    private com.baidu.tieba.tbadkCore.d.b bHt;
    private long bHu;
    private long bHv;
    private long bHw;
    private long bHx;

    /* loaded from: classes.dex */
    public interface b {
        void a(a aVar);
    }

    /* loaded from: classes.dex */
    public class a {
        public String bHz = "";
        public boolean bHA = false;
        public int type = -1;
        public com.baidu.tieba.enterForum.b.b bHB = null;

        public a() {
        }
    }

    public c(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.bHr = null;
        this.bHs = null;
        this.bHt = null;
        this.bHu = 0L;
        this.bHv = 0L;
        this.bHw = 0L;
        this.bHx = 0L;
        setUniqueId(BdUniqueId.gen());
    }

    @Override // com.baidu.adp.base.e
    public BdUniqueId getUniqueId() {
        return this.unique_id;
    }

    public long XJ() {
        return this.bHx;
    }

    public long XK() {
        return this.bHv;
    }

    public long XL() {
        return this.bHw;
    }

    public long XM() {
        return this.bHu;
    }

    public com.baidu.tieba.enterForum.b.b XN() {
        return this.bHr;
    }

    public void e(com.baidu.tieba.enterForum.b.b bVar) {
        this.bHr = bVar;
    }

    public void a(b bVar) {
        this.bHs = bVar;
    }

    @Override // com.baidu.adp.base.e
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.e
    public boolean cancelLoadData() {
        cancelMessage();
        XO();
        return true;
    }

    private void XO() {
        if (this.bHt != null) {
            this.bHt.destory();
            this.bHt = null;
        }
    }

    public boolean dm(boolean z) {
        cancelLoadData();
        forumRecommendRequestMessage forumrecommendrequestmessage = new forumRecommendRequestMessage();
        forumrecommendrequestmessage.set_like_forum(Integer.valueOf(z ? 1 : 0));
        forumrecommendrequestmessage.set_topic(0);
        forumrecommendrequestmessage.set_recommend(1);
        this.bHu = System.currentTimeMillis();
        if (this.bHt == null) {
            this.bHt = new com.baidu.tieba.tbadkCore.d.b("forumrecommendStat");
        }
        sendMessage(forumrecommendrequestmessage);
        return true;
    }

    public boolean dn(boolean z) {
        XP();
        return true;
    }

    public void a(boolean z, int i, String str, boolean z2, int i2, long j, long j2) {
        a aVar = new a();
        boolean z3 = !z;
        if (this.bHt != null) {
            this.bHt.a(z2, z3, i, str, i2, j, j2);
            this.bHt = null;
        }
        this.bHr.dh(false);
        if (z || !this.bHr.isSuccess()) {
            if (str != null && str.length() > 0) {
                setErrorString(str);
                aVar.bHz = str;
            }
            aVar.type = 1;
            aVar.bHA = false;
            aVar.bHB = this.bHr;
            this.bHs.a(aVar);
            return;
        }
        aVar.type = 1;
        aVar.bHA = true;
        aVar.bHB = this.bHr;
        this.bHs.a(aVar);
    }

    public void a(forumRecommendSocketResponseMessage forumrecommendsocketresponsemessage) {
        String errorString;
        int downSize = forumrecommendsocketresponsemessage.getDownSize();
        long costTime = forumrecommendsocketresponsemessage.getCostTime();
        if (StringUtils.isNull(forumrecommendsocketresponsemessage.getErrorString())) {
            errorString = TbadkCoreApplication.m9getInst().getApp().getResources().getString(t.j.neterror);
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
            errorString = TbadkCoreApplication.m9getInst().getApp().getResources().getString(t.j.neterror);
        } else {
            errorString = forumrecommendhttpresponsemessage.getErrorString();
        }
        a(forumrecommendhttpresponsemessage, forumrecommendhttpresponsemessage.hasError(), forumrecommendhttpresponsemessage.getError(), errorString, true, downSize, costTime, 0L);
    }

    public void a(ResponsedMessage<?> responsedMessage, boolean z, int i, String str, boolean z2, int i2, long j, long j2) {
        if (z) {
            this.bHr = null;
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
                this.bHr = new com.baidu.tieba.enterForum.b.b();
                this.bHr.setTime(forumrecommendhttpresponsemessage.GetIsLogin().intValue());
                this.bHr.hm(forumrecommendhttpresponsemessage.GetMsignValid().intValue());
                this.bHr.jk(forumrecommendhttpresponsemessage.GetMsignText());
                this.bHr.hn(forumrecommendhttpresponsemessage.GetMsignLevel().intValue());
                this.bHr.setIsMem(forumrecommendhttpresponsemessage.GetIsMem().intValue());
                this.bHr.hl(forumrecommendhttpresponsemessage.GetIsLogin().intValue());
                this.bHr.dh(false);
                com.baidu.tieba.enterForum.b.e eVar = new com.baidu.tieba.enterForum.b.e();
                eVar.setLevel(forumrecommendhttpresponsemessage.GetMsignLevel().intValue());
                eVar.ah(forumrecommendhttpresponsemessage.GetLikeForum());
                this.bHr.a(eVar);
                h hVar = new h();
                hVar.ag(forumrecommendhttpresponsemessage.GetRecommendForumInfoList());
                this.bHr.a(hVar);
                com.baidu.tieba.enterForum.b.c cVar = new com.baidu.tieba.enterForum.b.c();
                cVar.ag(forumrecommendhttpresponsemessage.getFrequentlyForumInfo());
                this.bHr.a(cVar);
                i iVar = new i();
                iVar.ah(forumrecommendhttpresponsemessage.GetBanner());
                this.bHr.a(iVar);
                i iVar2 = new i();
                iVar2.ah(forumrecommendhttpresponsemessage.getNewBannerInfo());
                this.bHr.b(iVar2);
                this.bHr.ax(true);
                this.bHr.a(forumrecommendhttpresponsemessage.getHotSearchInfoData());
            } catch (Exception e) {
                this.bHr.ax(false);
                BdLog.e(e.getMessage());
            }
        }
    }

    public void b(forumRecommendSocketResponseMessage forumrecommendsocketresponsemessage) {
        if (forumrecommendsocketresponsemessage != null) {
            try {
                this.bHr = new com.baidu.tieba.enterForum.b.b();
                this.bHr.setTime(forumrecommendsocketresponsemessage.GetIsLogin().intValue());
                this.bHr.hm(forumrecommendsocketresponsemessage.GetMsignValid().intValue());
                this.bHr.jk(forumrecommendsocketresponsemessage.GetMsignText());
                this.bHr.hn(forumrecommendsocketresponsemessage.GetMsignLevel().intValue());
                this.bHr.setIsMem(forumrecommendsocketresponsemessage.GetIsMem().intValue());
                this.bHr.hl(forumrecommendsocketresponsemessage.GetIsLogin().intValue());
                this.bHr.dh(false);
                com.baidu.tieba.enterForum.b.e eVar = new com.baidu.tieba.enterForum.b.e();
                eVar.setLevel(forumrecommendsocketresponsemessage.GetMsignLevel().intValue());
                eVar.ah(forumrecommendsocketresponsemessage.GetLikeForum());
                this.bHr.a(eVar);
                h hVar = new h();
                hVar.ag(forumrecommendsocketresponsemessage.GetRecommendForumInfoList());
                this.bHr.a(hVar);
                com.baidu.tieba.enterForum.b.c cVar = new com.baidu.tieba.enterForum.b.c();
                cVar.ag(forumrecommendsocketresponsemessage.getFrequentlyForumInfo());
                this.bHr.a(cVar);
                i iVar = new i();
                iVar.ah(forumrecommendsocketresponsemessage.GetBanner());
                this.bHr.a(iVar);
                i iVar2 = new i();
                iVar2.ah(forumrecommendsocketresponsemessage.getNewBannerInfo());
                this.bHr.b(iVar2);
                this.bHr.ax(true);
                this.bHr.a(forumrecommendsocketresponsemessage.getHotSearchInfoData());
            } catch (Exception e) {
                this.bHr.ax(false);
                BdLog.e(e.getMessage());
            }
        }
    }

    private void XP() {
        new d(this).execute(new Void[0]);
    }

    public void hr(int i) {
        com.baidu.tbadk.core.sharedPref.b.tS().putInt("shared_key_forum_column_type_" + TbadkCoreApplication.getCurrentAccount(), i);
    }

    public int hs(int i) {
        return com.baidu.tbadk.core.sharedPref.b.tS().getInt("shared_key_forum_column_type_" + TbadkCoreApplication.getCurrentAccount(), i);
    }

    public void aj(List<w> list) {
        if (list != null) {
            StringBuilder sb = new StringBuilder();
            for (w wVar : list) {
                if (wVar != null) {
                    sb.append(wVar.getId()).append("#");
                }
            }
            com.baidu.tbadk.core.sharedPref.b.tS().putString("shared_key_forum_sort" + TbadkCoreApplication.getCurrentAccount(), sb.toString());
        }
    }

    public String[] XQ() {
        return com.baidu.tbadk.core.sharedPref.b.tS().getString("shared_key_forum_sort" + TbadkCoreApplication.getCurrentAccount(), "").split("#");
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
        com.baidu.tbadk.core.sharedPref.b.tS().putLong("last_close_recommend_time@" + TbadkCoreApplication.getCurrentAccount(), j);
    }

    public long XR() {
        return com.baidu.tbadk.core.sharedPref.b.tS().getLong("last_close_recommend_time@" + TbadkCoreApplication.getCurrentAccount(), 0L);
    }

    public boolean bf(long j) {
        return System.currentTimeMillis() - j > TbConfig.APP_OVERDUR_DRAFT_BOX;
    }

    public boolean e(List<w> list, List<w> list2) {
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
