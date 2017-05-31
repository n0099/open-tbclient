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
    private com.baidu.tieba.enterForum.b.b bMY;
    private b bMZ;
    private com.baidu.tieba.tbadkCore.d.b bNa;
    private long bNb;
    private long bNc;
    private long bNd;
    private long bNe;

    /* loaded from: classes.dex */
    public interface b {
        void a(a aVar);
    }

    /* loaded from: classes.dex */
    public class a {
        public String bNg = "";
        public boolean bNh = false;
        public int type = -1;
        public com.baidu.tieba.enterForum.b.b bNi = null;

        public a() {
        }
    }

    public EnterForumModel(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.bMY = null;
        this.bMZ = null;
        this.bNa = null;
        this.bNb = 0L;
        this.bNc = 0L;
        this.bNd = 0L;
        this.bNe = 0L;
        setUniqueId(BdUniqueId.gen());
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public BdUniqueId getUniqueId() {
        return this.unique_id;
    }

    public long XA() {
        return this.bNe;
    }

    public long XB() {
        return this.bNc;
    }

    public long XC() {
        return this.bNd;
    }

    public long XD() {
        return this.bNb;
    }

    public com.baidu.tieba.enterForum.b.b XE() {
        return this.bMY;
    }

    public void b(com.baidu.tieba.enterForum.b.b bVar) {
        this.bMY = bVar;
    }

    public void a(b bVar) {
        this.bMZ = bVar;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        cancelMessage();
        XF();
        return true;
    }

    private void XF() {
        if (this.bNa != null) {
            this.bNa.destory();
            this.bNa = null;
        }
    }

    public boolean dM(boolean z) {
        cancelLoadData();
        forumRecommendRequestMessage forumrecommendrequestmessage = new forumRecommendRequestMessage();
        forumrecommendrequestmessage.set_like_forum(Integer.valueOf(z ? 1 : 0));
        forumrecommendrequestmessage.set_topic(0);
        forumrecommendrequestmessage.set_recommend(1);
        this.bNb = System.currentTimeMillis();
        if (this.bNa == null) {
            this.bNa = new com.baidu.tieba.tbadkCore.d.b("forumrecommendStat");
        }
        sendMessage(forumrecommendrequestmessage);
        return true;
    }

    public boolean dN(boolean z) {
        XG();
        return true;
    }

    public void a(boolean z, int i, String str, boolean z2, int i2, long j, long j2) {
        a aVar = new a();
        boolean z3 = !z;
        if (this.bNa != null) {
            this.bNa.a(z2, z3, i, str, i2, j, j2);
            this.bNa = null;
        }
        this.bMY.dH(false);
        if (z || !this.bMY.isSuccess()) {
            if (str != null && str.length() > 0) {
                setErrorString(str);
                aVar.bNg = str;
            }
            aVar.type = 1;
            aVar.bNh = false;
            aVar.bNi = this.bMY;
            this.bMZ.a(aVar);
            return;
        }
        aVar.type = 1;
        aVar.bNh = true;
        aVar.bNi = this.bMY;
        this.bMZ.a(aVar);
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
            this.bMY = null;
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
                this.bMY = new com.baidu.tieba.enterForum.b.b();
                this.bMY.setTime(forumrecommendhttpresponsemessage.GetTime().intValue());
                this.bMY.hM(forumrecommendhttpresponsemessage.GetMsignValid().intValue());
                this.bMY.iB(forumrecommendhttpresponsemessage.GetMsignText());
                this.bMY.hN(forumrecommendhttpresponsemessage.GetMsignLevel().intValue());
                this.bMY.setIsMem(forumrecommendhttpresponsemessage.GetIsMem().intValue());
                this.bMY.hL(forumrecommendhttpresponsemessage.GetIsLogin().intValue());
                this.bMY.dH(false);
                h hVar = new h();
                hVar.setLevel(forumrecommendhttpresponsemessage.GetMsignLevel().intValue());
                hVar.ad(forumrecommendhttpresponsemessage.GetLikeForum());
                this.bMY.a(hVar);
                k kVar = new k();
                kVar.ae(forumrecommendhttpresponsemessage.GetRecommendForumInfoList());
                this.bMY.a(kVar);
                this.bMY.ay(true);
                this.bMY.a(forumrecommendhttpresponsemessage.getHotSearchInfoData());
            } catch (Exception e) {
                this.bMY.ay(false);
                BdLog.e(e.getMessage());
            }
        }
    }

    public void b(forumRecommendSocketResponseMessage forumrecommendsocketresponsemessage) {
        if (forumrecommendsocketresponsemessage != null) {
            try {
                this.bMY = new com.baidu.tieba.enterForum.b.b();
                this.bMY.setTime(forumrecommendsocketresponsemessage.GetTime().intValue());
                this.bMY.hM(forumrecommendsocketresponsemessage.GetMsignValid().intValue());
                this.bMY.iB(forumrecommendsocketresponsemessage.GetMsignText());
                this.bMY.hN(forumrecommendsocketresponsemessage.GetMsignLevel().intValue());
                this.bMY.setIsMem(forumrecommendsocketresponsemessage.GetIsMem().intValue());
                this.bMY.hL(forumrecommendsocketresponsemessage.GetIsLogin().intValue());
                this.bMY.dH(false);
                h hVar = new h();
                hVar.setLevel(forumrecommendsocketresponsemessage.GetMsignLevel().intValue());
                hVar.ad(forumrecommendsocketresponsemessage.GetLikeForum());
                this.bMY.a(hVar);
                k kVar = new k();
                kVar.ae(forumrecommendsocketresponsemessage.GetRecommendForumInfoList());
                this.bMY.a(kVar);
                this.bMY.ay(true);
                this.bMY.a(forumrecommendsocketresponsemessage.getHotSearchInfoData());
            } catch (Exception e) {
                this.bMY.ay(false);
                BdLog.e(e.getMessage());
            }
        }
    }

    private void XG() {
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

    public boolean g(List<g> list, List<g> list2) {
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
