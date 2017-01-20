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
import com.baidu.tieba.r;
import com.baidu.tieba.tbadkCore.u;
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
    private com.baidu.tieba.enterForum.b.b byj;
    private b byk;
    private com.baidu.tieba.tbadkCore.d.b byl;
    private long bym;
    private long byn;
    private long byo;
    private long byp;

    /* loaded from: classes.dex */
    public interface b {
        void a(a aVar);
    }

    /* loaded from: classes.dex */
    public class a {
        public String byr = "";
        public boolean bys = false;
        public int type = -1;
        public com.baidu.tieba.enterForum.b.b byt = null;

        public a() {
        }
    }

    public EnterForumModel(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.byj = null;
        this.byk = null;
        this.byl = null;
        this.bym = 0L;
        this.byn = 0L;
        this.byo = 0L;
        this.byp = 0L;
        setUniqueId(BdUniqueId.gen());
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public BdUniqueId getUniqueId() {
        return this.unique_id;
    }

    public long UK() {
        return this.byp;
    }

    public long UL() {
        return this.byn;
    }

    public long UM() {
        return this.byo;
    }

    public long UN() {
        return this.bym;
    }

    public com.baidu.tieba.enterForum.b.b UO() {
        return this.byj;
    }

    public void d(com.baidu.tieba.enterForum.b.b bVar) {
        this.byj = bVar;
    }

    public void a(b bVar) {
        this.byk = bVar;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        cancelMessage();
        UP();
        return true;
    }

    private void UP() {
        if (this.byl != null) {
            this.byl.destory();
            this.byl = null;
        }
    }

    public boolean dh(boolean z) {
        cancelLoadData();
        forumRecommendRequestMessage forumrecommendrequestmessage = new forumRecommendRequestMessage();
        forumrecommendrequestmessage.set_like_forum(Integer.valueOf(z ? 1 : 0));
        forumrecommendrequestmessage.set_topic(0);
        forumrecommendrequestmessage.set_recommend(1);
        this.bym = System.currentTimeMillis();
        if (this.byl == null) {
            this.byl = new com.baidu.tieba.tbadkCore.d.b("forumrecommendStat");
        }
        sendMessage(forumrecommendrequestmessage);
        return true;
    }

    public boolean di(boolean z) {
        UQ();
        return true;
    }

    public void a(boolean z, int i, String str, boolean z2, int i2, long j, long j2) {
        a aVar = new a();
        boolean z3 = !z;
        if (this.byl != null) {
            this.byl.a(z2, z3, i, str, i2, j, j2);
            this.byl = null;
        }
        this.byj.dc(false);
        if (z || !this.byj.isSuccess()) {
            if (str != null && str.length() > 0) {
                setErrorString(str);
                aVar.byr = str;
            }
            aVar.type = 1;
            aVar.bys = false;
            aVar.byt = this.byj;
            this.byk.a(aVar);
            return;
        }
        aVar.type = 1;
        aVar.bys = true;
        aVar.byt = this.byj;
        this.byk.a(aVar);
    }

    public void a(forumRecommendSocketResponseMessage forumrecommendsocketresponsemessage) {
        String errorString;
        int downSize = forumrecommendsocketresponsemessage.getDownSize();
        long costTime = forumrecommendsocketresponsemessage.getCostTime();
        if (StringUtils.isNull(forumrecommendsocketresponsemessage.getErrorString())) {
            errorString = TbadkCoreApplication.m9getInst().getApp().getResources().getString(r.l.neterror);
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
            errorString = TbadkCoreApplication.m9getInst().getApp().getResources().getString(r.l.neterror);
        } else {
            errorString = forumrecommendhttpresponsemessage.getErrorString();
        }
        a(forumrecommendhttpresponsemessage, forumrecommendhttpresponsemessage.hasError(), forumrecommendhttpresponsemessage.getError(), errorString, true, downSize, costTime, 0L);
    }

    public void a(ResponsedMessage<?> responsedMessage, boolean z, int i, String str, boolean z2, int i2, long j, long j2) {
        if (z) {
            this.byj = null;
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
                this.byj = new com.baidu.tieba.enterForum.b.b();
                this.byj.setTime(forumrecommendhttpresponsemessage.GetIsLogin().intValue());
                this.byj.hn(forumrecommendhttpresponsemessage.GetMsignValid().intValue());
                this.byj.iq(forumrecommendhttpresponsemessage.GetMsignText());
                this.byj.ho(forumrecommendhttpresponsemessage.GetMsignLevel().intValue());
                this.byj.setIsMem(forumrecommendhttpresponsemessage.GetIsMem().intValue());
                this.byj.hm(forumrecommendhttpresponsemessage.GetIsLogin().intValue());
                this.byj.dc(false);
                com.baidu.tieba.enterForum.b.e eVar = new com.baidu.tieba.enterForum.b.e();
                eVar.setLevel(forumrecommendhttpresponsemessage.GetMsignLevel().intValue());
                eVar.ae(forumrecommendhttpresponsemessage.GetLikeForum());
                this.byj.a(eVar);
                h hVar = new h();
                hVar.ad(forumrecommendhttpresponsemessage.GetRecommendForumInfoList());
                this.byj.a(hVar);
                com.baidu.tieba.enterForum.b.c cVar = new com.baidu.tieba.enterForum.b.c();
                cVar.ad(forumrecommendhttpresponsemessage.getFrequentlyForumInfo());
                this.byj.a(cVar);
                i iVar = new i();
                iVar.ae(forumrecommendhttpresponsemessage.GetBanner());
                this.byj.a(iVar);
                i iVar2 = new i();
                iVar2.ae(forumrecommendhttpresponsemessage.getNewBannerInfo());
                this.byj.b(iVar2);
                this.byj.aB(true);
                this.byj.a(forumrecommendhttpresponsemessage.getHotSearchInfoData());
            } catch (Exception e) {
                this.byj.aB(false);
                BdLog.e(e.getMessage());
            }
        }
    }

    public void b(forumRecommendSocketResponseMessage forumrecommendsocketresponsemessage) {
        if (forumrecommendsocketresponsemessage != null) {
            try {
                this.byj = new com.baidu.tieba.enterForum.b.b();
                this.byj.setTime(forumrecommendsocketresponsemessage.GetIsLogin().intValue());
                this.byj.hn(forumrecommendsocketresponsemessage.GetMsignValid().intValue());
                this.byj.iq(forumrecommendsocketresponsemessage.GetMsignText());
                this.byj.ho(forumrecommendsocketresponsemessage.GetMsignLevel().intValue());
                this.byj.setIsMem(forumrecommendsocketresponsemessage.GetIsMem().intValue());
                this.byj.hm(forumrecommendsocketresponsemessage.GetIsLogin().intValue());
                this.byj.dc(false);
                com.baidu.tieba.enterForum.b.e eVar = new com.baidu.tieba.enterForum.b.e();
                eVar.setLevel(forumrecommendsocketresponsemessage.GetMsignLevel().intValue());
                eVar.ae(forumrecommendsocketresponsemessage.GetLikeForum());
                this.byj.a(eVar);
                h hVar = new h();
                hVar.ad(forumrecommendsocketresponsemessage.GetRecommendForumInfoList());
                this.byj.a(hVar);
                com.baidu.tieba.enterForum.b.c cVar = new com.baidu.tieba.enterForum.b.c();
                cVar.ad(forumrecommendsocketresponsemessage.getFrequentlyForumInfo());
                this.byj.a(cVar);
                i iVar = new i();
                iVar.ae(forumrecommendsocketresponsemessage.GetBanner());
                this.byj.a(iVar);
                i iVar2 = new i();
                iVar2.ae(forumrecommendsocketresponsemessage.getNewBannerInfo());
                this.byj.b(iVar2);
                this.byj.aB(true);
                this.byj.a(forumrecommendsocketresponsemessage.getHotSearchInfoData());
            } catch (Exception e) {
                this.byj.aB(false);
                BdLog.e(e.getMessage());
            }
        }
    }

    private void UQ() {
        new c(this).execute(new Void[0]);
    }

    public void hs(int i) {
        com.baidu.tbadk.core.sharedPref.b.tQ().putInt(SHARED_KEY_FORUM_COLUMN_TYPE + TbadkCoreApplication.getCurrentAccount(), i);
    }

    public int ht(int i) {
        return com.baidu.tbadk.core.sharedPref.b.tQ().getInt(SHARED_KEY_FORUM_COLUMN_TYPE + TbadkCoreApplication.getCurrentAccount(), i);
    }

    public void ag(List<u> list) {
        if (list != null) {
            StringBuilder sb = new StringBuilder();
            for (u uVar : list) {
                if (uVar != null) {
                    sb.append(uVar.getId()).append("#");
                }
            }
            com.baidu.tbadk.core.sharedPref.b.tQ().putString(SHARED_KEY_FORUM_SORT + TbadkCoreApplication.getCurrentAccount(), sb.toString());
        }
    }

    public String[] UR() {
        return com.baidu.tbadk.core.sharedPref.b.tQ().getString(SHARED_KEY_FORUM_SORT + TbadkCoreApplication.getCurrentAccount(), "").split("#");
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

    public List<u> ah(List<u> list) {
        if (list != null && !list.isEmpty()) {
            Collections.sort(list, new d(this));
        }
        return list;
    }

    public void aL(long j) {
        com.baidu.tbadk.core.sharedPref.b.tQ().putLong("last_close_recommend_time@" + TbadkCoreApplication.getCurrentAccount(), j);
    }

    public long US() {
        return com.baidu.tbadk.core.sharedPref.b.tQ().getLong("last_close_recommend_time@" + TbadkCoreApplication.getCurrentAccount(), 0L);
    }

    public boolean aM(long j) {
        return System.currentTimeMillis() - j > TbConfig.APP_OVERDUR_DRAFT_BOX;
    }

    public boolean d(List<u> list, List<u> list2) {
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
