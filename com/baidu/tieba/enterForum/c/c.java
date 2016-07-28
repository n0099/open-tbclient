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
    private com.baidu.tieba.enterForum.b.b bwd;
    private b bwe;
    private com.baidu.tieba.tbadkCore.d.b bwf;
    private long bwg;
    private long bwh;
    private long bwi;
    private long bwj;

    /* loaded from: classes.dex */
    public interface b {
        void a(a aVar);
    }

    /* loaded from: classes.dex */
    public class a {
        public String bwl = "";
        public boolean bwm = false;
        public int type = -1;
        public com.baidu.tieba.enterForum.b.b bwn = null;

        public a() {
        }
    }

    public c(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.bwd = null;
        this.bwe = null;
        this.bwf = null;
        this.bwg = 0L;
        this.bwh = 0L;
        this.bwi = 0L;
        this.bwj = 0L;
        setUniqueId(BdUniqueId.gen());
    }

    @Override // com.baidu.adp.base.e
    public BdUniqueId getUniqueId() {
        return this.unique_id;
    }

    public long SY() {
        return this.bwj;
    }

    public long SZ() {
        return this.bwh;
    }

    public long Ta() {
        return this.bwi;
    }

    public long Tb() {
        return this.bwg;
    }

    public com.baidu.tieba.enterForum.b.b Tc() {
        return this.bwd;
    }

    public void e(com.baidu.tieba.enterForum.b.b bVar) {
        this.bwd = bVar;
    }

    public void a(b bVar) {
        this.bwe = bVar;
    }

    @Override // com.baidu.adp.base.e
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.e
    public boolean cancelLoadData() {
        cancelMessage();
        Td();
        return true;
    }

    private void Td() {
        if (this.bwf != null) {
            this.bwf.destory();
            this.bwf = null;
        }
    }

    public boolean cS(boolean z) {
        cancelLoadData();
        forumRecommendRequestMessage forumrecommendrequestmessage = new forumRecommendRequestMessage();
        forumrecommendrequestmessage.set_like_forum(Integer.valueOf(z ? 1 : 0));
        forumrecommendrequestmessage.set_topic(0);
        forumrecommendrequestmessage.set_recommend(1);
        this.bwg = System.currentTimeMillis();
        if (this.bwf == null) {
            this.bwf = new com.baidu.tieba.tbadkCore.d.b("forumrecommendStat");
        }
        sendMessage(forumrecommendrequestmessage);
        return true;
    }

    public boolean cT(boolean z) {
        Te();
        return true;
    }

    public void a(boolean z, int i, String str, boolean z2, int i2, long j, long j2) {
        a aVar = new a();
        boolean z3 = !z;
        if (this.bwf != null) {
            this.bwf.a(z2, z3, i, str, i2, j, j2);
            this.bwf = null;
        }
        this.bwd.cN(false);
        if (z || !this.bwd.isSuccess()) {
            if (str != null && str.length() > 0) {
                setErrorString(str);
                aVar.bwl = str;
            }
            aVar.type = 1;
            aVar.bwm = false;
            aVar.bwn = this.bwd;
            this.bwe.a(aVar);
            return;
        }
        aVar.type = 1;
        aVar.bwm = true;
        aVar.bwn = this.bwd;
        this.bwe.a(aVar);
    }

    public void a(forumRecommendSocketResponseMessage forumrecommendsocketresponsemessage) {
        String errorString;
        int downSize = forumrecommendsocketresponsemessage.getDownSize();
        long costTime = forumrecommendsocketresponsemessage.getCostTime();
        if (StringUtils.isNull(forumrecommendsocketresponsemessage.getErrorString())) {
            errorString = TbadkCoreApplication.m10getInst().getApp().getResources().getString(u.j.neterror);
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
            errorString = TbadkCoreApplication.m10getInst().getApp().getResources().getString(u.j.neterror);
        } else {
            errorString = forumrecommendhttpresponsemessage.getErrorString();
        }
        a(forumrecommendhttpresponsemessage, forumrecommendhttpresponsemessage.hasError(), forumrecommendhttpresponsemessage.getError(), errorString, true, downSize, costTime, 0L);
    }

    public void a(ResponsedMessage<?> responsedMessage, boolean z, int i, String str, boolean z2, int i2, long j, long j2) {
        if (z) {
            this.bwd = null;
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
                this.bwd = new com.baidu.tieba.enterForum.b.b();
                this.bwd.setTime(forumrecommendhttpresponsemessage.GetIsLogin().intValue());
                this.bwd.gK(forumrecommendhttpresponsemessage.GetMsignValid().intValue());
                this.bwd.iB(forumrecommendhttpresponsemessage.GetMsignText());
                this.bwd.gL(forumrecommendhttpresponsemessage.GetMsignLevel().intValue());
                this.bwd.setIsMem(forumrecommendhttpresponsemessage.GetIsMem().intValue());
                this.bwd.gJ(forumrecommendhttpresponsemessage.GetIsLogin().intValue());
                this.bwd.cN(false);
                com.baidu.tieba.enterForum.b.e eVar = new com.baidu.tieba.enterForum.b.e();
                eVar.setLevel(forumrecommendhttpresponsemessage.GetMsignLevel().intValue());
                eVar.af(forumrecommendhttpresponsemessage.GetLikeForum());
                this.bwd.a(eVar);
                h hVar = new h();
                hVar.ae(forumrecommendhttpresponsemessage.GetRecommendForumInfoList());
                this.bwd.a(hVar);
                com.baidu.tieba.enterForum.b.c cVar = new com.baidu.tieba.enterForum.b.c();
                cVar.ae(forumrecommendhttpresponsemessage.getFrequentlyForumInfo());
                this.bwd.a(cVar);
                i iVar = new i();
                iVar.af(forumrecommendhttpresponsemessage.GetBanner());
                this.bwd.a(iVar);
                i iVar2 = new i();
                iVar2.af(forumrecommendhttpresponsemessage.getNewBannerInfo());
                this.bwd.b(iVar2);
                this.bwd.aw(true);
                this.bwd.a(forumrecommendhttpresponsemessage.getHotSearchInfoData());
            } catch (Exception e) {
                this.bwd.aw(false);
                BdLog.e(e.getMessage());
            }
        }
    }

    public void b(forumRecommendSocketResponseMessage forumrecommendsocketresponsemessage) {
        if (forumrecommendsocketresponsemessage != null) {
            try {
                this.bwd = new com.baidu.tieba.enterForum.b.b();
                this.bwd.setTime(forumrecommendsocketresponsemessage.GetIsLogin().intValue());
                this.bwd.gK(forumrecommendsocketresponsemessage.GetMsignValid().intValue());
                this.bwd.iB(forumrecommendsocketresponsemessage.GetMsignText());
                this.bwd.gL(forumrecommendsocketresponsemessage.GetMsignLevel().intValue());
                this.bwd.setIsMem(forumrecommendsocketresponsemessage.GetIsMem().intValue());
                this.bwd.gJ(forumrecommendsocketresponsemessage.GetIsLogin().intValue());
                this.bwd.cN(false);
                com.baidu.tieba.enterForum.b.e eVar = new com.baidu.tieba.enterForum.b.e();
                eVar.setLevel(forumrecommendsocketresponsemessage.GetMsignLevel().intValue());
                eVar.af(forumrecommendsocketresponsemessage.GetLikeForum());
                this.bwd.a(eVar);
                h hVar = new h();
                hVar.ae(forumrecommendsocketresponsemessage.GetRecommendForumInfoList());
                this.bwd.a(hVar);
                com.baidu.tieba.enterForum.b.c cVar = new com.baidu.tieba.enterForum.b.c();
                cVar.ae(forumrecommendsocketresponsemessage.getFrequentlyForumInfo());
                this.bwd.a(cVar);
                i iVar = new i();
                iVar.af(forumrecommendsocketresponsemessage.GetBanner());
                this.bwd.a(iVar);
                i iVar2 = new i();
                iVar2.af(forumrecommendsocketresponsemessage.getNewBannerInfo());
                this.bwd.b(iVar2);
                this.bwd.aw(true);
                this.bwd.a(forumrecommendsocketresponsemessage.getHotSearchInfoData());
            } catch (Exception e) {
                this.bwd.aw(false);
                BdLog.e(e.getMessage());
            }
        }
    }

    private void Te() {
        new d(this).execute(new Void[0]);
    }

    public void gP(int i) {
        com.baidu.tbadk.core.sharedPref.b.sN().putInt("shared_key_forum_column_type_" + TbadkCoreApplication.getCurrentAccount(), i);
    }

    public int gQ(int i) {
        return com.baidu.tbadk.core.sharedPref.b.sN().getInt("shared_key_forum_column_type_" + TbadkCoreApplication.getCurrentAccount(), i);
    }

    public void ah(List<x> list) {
        if (list != null) {
            StringBuilder sb = new StringBuilder();
            for (x xVar : list) {
                if (xVar != null) {
                    sb.append(xVar.getId()).append("#");
                }
            }
            com.baidu.tbadk.core.sharedPref.b.sN().putString("shared_key_forum_sort" + TbadkCoreApplication.getCurrentAccount(), sb.toString());
        }
    }

    public String[] Tf() {
        return com.baidu.tbadk.core.sharedPref.b.sN().getString("shared_key_forum_sort" + TbadkCoreApplication.getCurrentAccount(), "").split("#");
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

    public List<x> ai(List<x> list) {
        if (list != null && !list.isEmpty()) {
            Collections.sort(list, new e(this));
        }
        return list;
    }

    public void aI(long j) {
        com.baidu.tbadk.core.sharedPref.b.sN().putLong("last_close_recommend_time@" + TbadkCoreApplication.getCurrentAccount(), j);
    }

    public long Tg() {
        return com.baidu.tbadk.core.sharedPref.b.sN().getLong("last_close_recommend_time@" + TbadkCoreApplication.getCurrentAccount(), 0L);
    }

    public boolean aJ(long j) {
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
