package com.baidu.tieba.enterForum.model;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.util.c;
import com.baidu.tieba.enterForum.b.g;
import com.baidu.tieba.enterForum.b.h;
import com.baidu.tieba.enterForum.b.k;
import com.baidu.tieba.enterForum.home.forumRecommendHttpResponseMessage;
import com.baidu.tieba.enterForum.home.forumRecommendRequestMessage;
import com.baidu.tieba.enterForum.home.forumRecommendSocketResponseMessage;
import com.baidu.tieba.w;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class EnterForumModel extends BdBaseModel {
    public static final String FORUMRECOMMEND_CACHE_KEY = "forumRecommend_cache_key";
    public static final int MAX_LIKE_SHOWED = 500;
    public static final int TYPE_DB = 0;
    public static final int TYPE_DEFAULT = -1;
    public static final int TYPE_NET = 1;
    private com.baidu.tieba.enterForum.b.b bHk;
    private b bHl;
    private com.baidu.tieba.tbadkCore.d.b bHm;
    private long bHn;
    private long bHo;
    private long bHp;
    private long bHq;

    /* loaded from: classes.dex */
    public interface b {
        void a(a aVar);
    }

    /* loaded from: classes.dex */
    public class a {
        public String bHs = "";
        public boolean bHt = false;
        public int type = -1;
        public com.baidu.tieba.enterForum.b.b bHu = null;

        public a() {
        }
    }

    public EnterForumModel(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.bHk = null;
        this.bHl = null;
        this.bHm = null;
        this.bHn = 0L;
        this.bHo = 0L;
        this.bHp = 0L;
        this.bHq = 0L;
        setUniqueId(BdUniqueId.gen());
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public BdUniqueId getUniqueId() {
        return this.unique_id;
    }

    public long Wx() {
        return this.bHq;
    }

    public long Wy() {
        return this.bHo;
    }

    public long Wz() {
        return this.bHp;
    }

    public long WA() {
        return this.bHn;
    }

    public com.baidu.tieba.enterForum.b.b WB() {
        return this.bHk;
    }

    public void b(com.baidu.tieba.enterForum.b.b bVar) {
        this.bHk = bVar;
    }

    public void a(b bVar) {
        this.bHl = bVar;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        cancelMessage();
        WC();
        return true;
    }

    private void WC() {
        if (this.bHm != null) {
            this.bHm.destory();
            this.bHm = null;
        }
    }

    public boolean dv(boolean z) {
        cancelLoadData();
        forumRecommendRequestMessage forumrecommendrequestmessage = new forumRecommendRequestMessage();
        forumrecommendrequestmessage.set_like_forum(Integer.valueOf(z ? 1 : 0));
        forumrecommendrequestmessage.set_topic(0);
        forumrecommendrequestmessage.set_recommend(1);
        this.bHn = System.currentTimeMillis();
        if (this.bHm == null) {
            this.bHm = new com.baidu.tieba.tbadkCore.d.b("forumrecommendStat");
        }
        sendMessage(forumrecommendrequestmessage);
        return true;
    }

    public boolean dw(boolean z) {
        WD();
        return true;
    }

    public void a(boolean z, int i, String str, boolean z2, int i2, long j, long j2) {
        a aVar = new a();
        boolean z3 = !z;
        if (this.bHm != null) {
            this.bHm.a(z2, z3, i, str, i2, j, j2);
            this.bHm = null;
        }
        this.bHk.dq(false);
        if (z || !this.bHk.isSuccess()) {
            if (str != null && str.length() > 0) {
                setErrorString(str);
                aVar.bHs = str;
            }
            aVar.type = 1;
            aVar.bHt = false;
            aVar.bHu = this.bHk;
            this.bHl.a(aVar);
            return;
        }
        aVar.type = 1;
        aVar.bHt = true;
        aVar.bHu = this.bHk;
        this.bHl.a(aVar);
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
            this.bHk = null;
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
                this.bHk = new com.baidu.tieba.enterForum.b.b();
                this.bHk.setTime(forumrecommendhttpresponsemessage.GetTime().intValue());
                this.bHk.ho(forumrecommendhttpresponsemessage.GetMsignValid().intValue());
                this.bHk.it(forumrecommendhttpresponsemessage.GetMsignText());
                this.bHk.hp(forumrecommendhttpresponsemessage.GetMsignLevel().intValue());
                this.bHk.setIsMem(forumrecommendhttpresponsemessage.GetIsMem().intValue());
                this.bHk.hn(forumrecommendhttpresponsemessage.GetIsLogin().intValue());
                this.bHk.dq(false);
                h hVar = new h();
                hVar.setLevel(forumrecommendhttpresponsemessage.GetMsignLevel().intValue());
                hVar.ad(forumrecommendhttpresponsemessage.GetLikeForum());
                this.bHk.a(hVar);
                k kVar = new k();
                kVar.ae(forumrecommendhttpresponsemessage.GetRecommendForumInfoList());
                this.bHk.a(kVar);
                this.bHk.az(true);
                this.bHk.a(forumrecommendhttpresponsemessage.getHotSearchInfoData());
            } catch (Exception e) {
                this.bHk.az(false);
                BdLog.e(e.getMessage());
            }
        }
    }

    public void b(forumRecommendSocketResponseMessage forumrecommendsocketresponsemessage) {
        if (forumrecommendsocketresponsemessage != null) {
            try {
                this.bHk = new com.baidu.tieba.enterForum.b.b();
                this.bHk.setTime(forumrecommendsocketresponsemessage.GetTime().intValue());
                this.bHk.ho(forumrecommendsocketresponsemessage.GetMsignValid().intValue());
                this.bHk.it(forumrecommendsocketresponsemessage.GetMsignText());
                this.bHk.hp(forumrecommendsocketresponsemessage.GetMsignLevel().intValue());
                this.bHk.setIsMem(forumrecommendsocketresponsemessage.GetIsMem().intValue());
                this.bHk.hn(forumrecommendsocketresponsemessage.GetIsLogin().intValue());
                this.bHk.dq(false);
                h hVar = new h();
                hVar.setLevel(forumrecommendsocketresponsemessage.GetMsignLevel().intValue());
                hVar.ad(forumrecommendsocketresponsemessage.GetLikeForum());
                this.bHk.a(hVar);
                k kVar = new k();
                kVar.ae(forumrecommendsocketresponsemessage.GetRecommendForumInfoList());
                this.bHk.a(kVar);
                this.bHk.az(true);
                this.bHk.a(forumrecommendsocketresponsemessage.getHotSearchInfoData());
            } catch (Exception e) {
                this.bHk.az(false);
                BdLog.e(e.getMessage());
            }
        }
    }

    private void WD() {
        new c(this).execute(new Void[0]);
    }

    public void af(List<g> list) {
        if (list != null) {
            ArrayList arrayList = new ArrayList();
            for (g gVar : list) {
                if (gVar != null && gVar.getType() == 0 && !StringUtils.isNull(gVar.getName())) {
                    arrayList.add(new c.a(gVar.getName(), gVar.getLevel()));
                }
            }
            com.baidu.tbadk.util.c.B(arrayList);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_CHANGE_SUB_TAB, true));
        }
    }

    public List<g> a(List<g> list, String[] strArr) {
        ArrayList arrayList = new ArrayList();
        if (list == null || list.isEmpty()) {
            return arrayList;
        }
        if (strArr == null || strArr.length == 0) {
            arrayList.addAll(list);
        } else {
            for (String str : strArr) {
                for (g gVar : list) {
                    if (gVar != null && gVar.getName() != null && gVar.getName().equals(str)) {
                        arrayList.add(gVar);
                    }
                }
            }
            int size = list.size();
            for (int i = 0; i < size; i++) {
                g gVar2 = list.get(i);
                if (!arrayList.contains(gVar2)) {
                    arrayList.add(gVar2);
                }
            }
        }
        return arrayList;
    }

    public boolean e(List<g> list, List<g> list2) {
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
            g gVar = list.get(i);
            g gVar2 = list2.get(i);
            if (gVar == null || gVar2 == null) {
                return false;
            }
            if (!gVar.getId().equals(gVar2.getId())) {
                return false;
            }
        }
        return true;
    }
}
