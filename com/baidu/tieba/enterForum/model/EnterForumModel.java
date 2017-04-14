package com.baidu.tieba.enterForum.model;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.base.BdBaseModel;
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
import com.baidu.tieba.tbadkCore.u;
import com.baidu.tieba.w;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/* loaded from: classes.dex */
public class EnterForumModel extends BdBaseModel {
    public static final String FORUMRECOMMEND_CACHE_KEY = "forumRecommend_cache_key";
    public static final int FORUM_NUM_COLUMN_TYPE_TWO = 8;
    public static final int FORUM_NUM_SHOW_GUIDE = 0;
    public static final int FORUM_NUM_SHOW_RECOMMEND = 10;
    public static final int MAX_LIKE_SHOWED = 500;
    public static final String SHARED_KEY_FORUM_COLUMN_TYPE = "shared_key_forum_column_type_";
    public static final String SHARED_KEY_FORUM_EDIT_GUIDE = "shared_key_forum_edit_guide_";
    public static final String SHARED_KEY_FORUM_SORT = "shared_key_forum_sort";
    public static final int TYPE_DB = 0;
    public static final int TYPE_DEFAULT = -1;
    public static final int TYPE_NET = 1;
    private com.baidu.tieba.enterForum.b.b bFi;
    private b bFj;
    private com.baidu.tieba.tbadkCore.d.b bFk;
    private long bFl;
    private long bFm;
    private long bFn;
    private long bFo;

    /* loaded from: classes.dex */
    public interface b {
        void a(a aVar);
    }

    /* loaded from: classes.dex */
    public class a {
        public String bFq = "";
        public boolean bFr = false;
        public int type = -1;
        public com.baidu.tieba.enterForum.b.b bFs = null;

        public a() {
        }
    }

    public EnterForumModel(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.bFi = null;
        this.bFj = null;
        this.bFk = null;
        this.bFl = 0L;
        this.bFm = 0L;
        this.bFn = 0L;
        this.bFo = 0L;
        setUniqueId(BdUniqueId.gen());
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public BdUniqueId getUniqueId() {
        return this.unique_id;
    }

    public long Wg() {
        return this.bFo;
    }

    public long Wh() {
        return this.bFm;
    }

    public long Wi() {
        return this.bFn;
    }

    public long Wj() {
        return this.bFl;
    }

    public com.baidu.tieba.enterForum.b.b Wk() {
        return this.bFi;
    }

    public void d(com.baidu.tieba.enterForum.b.b bVar) {
        this.bFi = bVar;
    }

    public void a(b bVar) {
        this.bFj = bVar;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        cancelMessage();
        Wl();
        return true;
    }

    private void Wl() {
        if (this.bFk != null) {
            this.bFk.destory();
            this.bFk = null;
        }
    }

    public boolean dj(boolean z) {
        cancelLoadData();
        forumRecommendRequestMessage forumrecommendrequestmessage = new forumRecommendRequestMessage();
        forumrecommendrequestmessage.set_like_forum(Integer.valueOf(z ? 1 : 0));
        forumrecommendrequestmessage.set_topic(0);
        forumrecommendrequestmessage.set_recommend(1);
        this.bFl = System.currentTimeMillis();
        if (this.bFk == null) {
            this.bFk = new com.baidu.tieba.tbadkCore.d.b("forumrecommendStat");
        }
        sendMessage(forumrecommendrequestmessage);
        return true;
    }

    public boolean dk(boolean z) {
        Wm();
        return true;
    }

    public void a(boolean z, int i, String str, boolean z2, int i2, long j, long j2) {
        a aVar = new a();
        boolean z3 = !z;
        if (this.bFk != null) {
            this.bFk.a(z2, z3, i, str, i2, j, j2);
            this.bFk = null;
        }
        this.bFi.de(false);
        if (z || !this.bFi.isSuccess()) {
            if (str != null && str.length() > 0) {
                setErrorString(str);
                aVar.bFq = str;
            }
            aVar.type = 1;
            aVar.bFr = false;
            aVar.bFs = this.bFi;
            this.bFj.a(aVar);
            return;
        }
        aVar.type = 1;
        aVar.bFr = true;
        aVar.bFs = this.bFi;
        this.bFj.a(aVar);
    }

    public void a(forumRecommendSocketResponseMessage forumrecommendsocketresponsemessage) {
        String errorString;
        int downSize = forumrecommendsocketresponsemessage.getDownSize();
        long costTime = forumrecommendsocketresponsemessage.getCostTime();
        if (StringUtils.isNull(forumrecommendsocketresponsemessage.getErrorString())) {
            errorString = TbadkCoreApplication.m9getInst().getApp().getResources().getString(w.l.neterror);
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
            errorString = TbadkCoreApplication.m9getInst().getApp().getResources().getString(w.l.neterror);
        } else {
            errorString = forumrecommendhttpresponsemessage.getErrorString();
        }
        a(forumrecommendhttpresponsemessage, forumrecommendhttpresponsemessage.hasError(), forumrecommendhttpresponsemessage.getError(), errorString, true, downSize, costTime, 0L);
    }

    public void a(ResponsedMessage<?> responsedMessage, boolean z, int i, String str, boolean z2, int i2, long j, long j2) {
        if (z) {
            this.bFi = null;
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
                this.bFi = new com.baidu.tieba.enterForum.b.b();
                this.bFi.setTime(forumrecommendhttpresponsemessage.GetIsLogin().intValue());
                this.bFi.hm(forumrecommendhttpresponsemessage.GetMsignValid().intValue());
                this.bFi.ik(forumrecommendhttpresponsemessage.GetMsignText());
                this.bFi.hn(forumrecommendhttpresponsemessage.GetMsignLevel().intValue());
                this.bFi.setIsMem(forumrecommendhttpresponsemessage.GetIsMem().intValue());
                this.bFi.hl(forumrecommendhttpresponsemessage.GetIsLogin().intValue());
                this.bFi.de(false);
                com.baidu.tieba.enterForum.b.e eVar = new com.baidu.tieba.enterForum.b.e();
                eVar.setLevel(forumrecommendhttpresponsemessage.GetMsignLevel().intValue());
                eVar.ab(forumrecommendhttpresponsemessage.GetLikeForum());
                this.bFi.a(eVar);
                h hVar = new h();
                hVar.aa(forumrecommendhttpresponsemessage.GetRecommendForumInfoList());
                this.bFi.a(hVar);
                com.baidu.tieba.enterForum.b.c cVar = new com.baidu.tieba.enterForum.b.c();
                cVar.aa(forumrecommendhttpresponsemessage.getFrequentlyForumInfo());
                this.bFi.a(cVar);
                i iVar = new i();
                iVar.ab(forumrecommendhttpresponsemessage.GetBanner());
                this.bFi.a(iVar);
                i iVar2 = new i();
                iVar2.ab(forumrecommendhttpresponsemessage.getNewBannerInfo());
                this.bFi.b(iVar2);
                this.bFi.aC(true);
                this.bFi.a(forumrecommendhttpresponsemessage.getHotSearchInfoData());
            } catch (Exception e) {
                this.bFi.aC(false);
                BdLog.e(e.getMessage());
            }
        }
    }

    public void b(forumRecommendSocketResponseMessage forumrecommendsocketresponsemessage) {
        if (forumrecommendsocketresponsemessage != null) {
            try {
                this.bFi = new com.baidu.tieba.enterForum.b.b();
                this.bFi.setTime(forumrecommendsocketresponsemessage.GetIsLogin().intValue());
                this.bFi.hm(forumrecommendsocketresponsemessage.GetMsignValid().intValue());
                this.bFi.ik(forumrecommendsocketresponsemessage.GetMsignText());
                this.bFi.hn(forumrecommendsocketresponsemessage.GetMsignLevel().intValue());
                this.bFi.setIsMem(forumrecommendsocketresponsemessage.GetIsMem().intValue());
                this.bFi.hl(forumrecommendsocketresponsemessage.GetIsLogin().intValue());
                this.bFi.de(false);
                com.baidu.tieba.enterForum.b.e eVar = new com.baidu.tieba.enterForum.b.e();
                eVar.setLevel(forumrecommendsocketresponsemessage.GetMsignLevel().intValue());
                eVar.ab(forumrecommendsocketresponsemessage.GetLikeForum());
                this.bFi.a(eVar);
                h hVar = new h();
                hVar.aa(forumrecommendsocketresponsemessage.GetRecommendForumInfoList());
                this.bFi.a(hVar);
                com.baidu.tieba.enterForum.b.c cVar = new com.baidu.tieba.enterForum.b.c();
                cVar.aa(forumrecommendsocketresponsemessage.getFrequentlyForumInfo());
                this.bFi.a(cVar);
                i iVar = new i();
                iVar.ab(forumrecommendsocketresponsemessage.GetBanner());
                this.bFi.a(iVar);
                i iVar2 = new i();
                iVar2.ab(forumrecommendsocketresponsemessage.getNewBannerInfo());
                this.bFi.b(iVar2);
                this.bFi.aC(true);
                this.bFi.a(forumrecommendsocketresponsemessage.getHotSearchInfoData());
            } catch (Exception e) {
                this.bFi.aC(false);
                BdLog.e(e.getMessage());
            }
        }
    }

    private void Wm() {
        new c(this).execute(new Void[0]);
    }

    public void hr(int i) {
        com.baidu.tbadk.core.sharedPref.b.uL().putInt(SHARED_KEY_FORUM_COLUMN_TYPE + TbadkCoreApplication.getCurrentAccount(), i);
    }

    public int hs(int i) {
        return com.baidu.tbadk.core.sharedPref.b.uL().getInt(SHARED_KEY_FORUM_COLUMN_TYPE + TbadkCoreApplication.getCurrentAccount(), i);
    }

    public void ad(List<u> list) {
        if (list != null) {
            StringBuilder sb = new StringBuilder();
            for (u uVar : list) {
                if (uVar != null) {
                    sb.append(uVar.getId()).append("#");
                }
            }
            com.baidu.tbadk.core.sharedPref.b.uL().putString(SHARED_KEY_FORUM_SORT + TbadkCoreApplication.getCurrentAccount(), sb.toString());
        }
    }

    public String[] Wn() {
        return com.baidu.tbadk.core.sharedPref.b.uL().getString(SHARED_KEY_FORUM_SORT + TbadkCoreApplication.getCurrentAccount(), "").split("#");
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

    public List<u> ae(List<u> list) {
        if (list != null && !list.isEmpty()) {
            Collections.sort(list, new d(this));
        }
        return list;
    }

    public void aL(long j) {
        com.baidu.tbadk.core.sharedPref.b.uL().putLong("last_close_recommend_time@" + TbadkCoreApplication.getCurrentAccount(), j);
    }

    public long Wo() {
        return com.baidu.tbadk.core.sharedPref.b.uL().getLong("last_close_recommend_time@" + TbadkCoreApplication.getCurrentAccount(), 0L);
    }

    public boolean aM(long j) {
        return System.currentTimeMillis() - j > TbConfig.APP_OVERDUR_DRAFT_BOX;
    }

    public boolean e(List<u> list, List<u> list2) {
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
            if (uVar == null || uVar2 == null) {
                return false;
            }
            if (!uVar.getId().equals(uVar2.getId())) {
                return false;
            }
        }
        return true;
    }
}
