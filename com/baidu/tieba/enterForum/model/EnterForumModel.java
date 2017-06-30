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
import com.baidu.tbadk.core.util.z;
import com.baidu.tbadk.util.c;
import com.baidu.tieba.enterForum.b.h;
import com.baidu.tieba.enterForum.b.k;
import com.baidu.tieba.enterForum.home.forumRecommendHttpResponseMessage;
import com.baidu.tieba.enterForum.home.forumRecommendRequestMessage;
import com.baidu.tieba.enterForum.home.forumRecommendSocketResponseMessage;
import com.baidu.tieba.enterForum.multiConcern.g;
import com.baidu.tieba.w;
import java.util.ArrayList;
import java.util.List;
import tbclient.RecommendForumInfo;
/* loaded from: classes.dex */
public class EnterForumModel extends BdBaseModel {
    public static final String FORUMRECOMMEND_CACHE_KEY = "forumRecommend_cache_key";
    public static final int MAX_LIKE_SHOWED = 500;
    public static final int TYPE_DB = 0;
    public static final int TYPE_DEFAULT = -1;
    public static final int TYPE_NET = 1;
    private com.baidu.tieba.enterForum.b.b bTB;
    private b bTC;
    private com.baidu.tieba.tbadkCore.d.b bTD;
    private long bTE;
    private long bTF;
    private long bTG;
    private long bTH;

    /* loaded from: classes.dex */
    public interface b {
        void a(a aVar);
    }

    /* loaded from: classes.dex */
    public class a {
        public String bTJ = "";
        public boolean bTK = false;
        public int type = -1;
        public com.baidu.tieba.enterForum.b.b bTL = null;

        public a() {
        }
    }

    public EnterForumModel(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.bTB = null;
        this.bTC = null;
        this.bTD = null;
        this.bTE = 0L;
        this.bTF = 0L;
        this.bTG = 0L;
        this.bTH = 0L;
        setUniqueId(BdUniqueId.gen());
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public BdUniqueId getUniqueId() {
        return this.unique_id;
    }

    public long aaY() {
        return this.bTH;
    }

    public long aaZ() {
        return this.bTF;
    }

    public long aba() {
        return this.bTG;
    }

    public long abb() {
        return this.bTE;
    }

    public com.baidu.tieba.enterForum.b.b abc() {
        return this.bTB;
    }

    public void c(com.baidu.tieba.enterForum.b.b bVar) {
        this.bTB = bVar;
    }

    public void a(b bVar) {
        this.bTC = bVar;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        cancelMessage();
        abd();
        return true;
    }

    private void abd() {
        if (this.bTD != null) {
            this.bTD.destory();
            this.bTD = null;
        }
    }

    public boolean eb(boolean z) {
        cancelLoadData();
        forumRecommendRequestMessage forumrecommendrequestmessage = new forumRecommendRequestMessage();
        forumrecommendrequestmessage.set_like_forum(Integer.valueOf(z ? 1 : 0));
        forumrecommendrequestmessage.set_topic(0);
        forumrecommendrequestmessage.set_recommend(1);
        this.bTE = System.currentTimeMillis();
        if (this.bTD == null) {
            this.bTD = new com.baidu.tieba.tbadkCore.d.b("forumrecommendStat");
        }
        sendMessage(forumrecommendrequestmessage);
        return true;
    }

    public boolean ec(boolean z) {
        abe();
        return true;
    }

    public void a(boolean z, int i, String str, boolean z2, int i2, long j, long j2) {
        a aVar = new a();
        boolean z3 = !z;
        if (this.bTD != null) {
            this.bTD.a(z2, z3, i, str, i2, j, j2);
            this.bTD = null;
        }
        this.bTB.dW(false);
        if (z || !this.bTB.isSuccess()) {
            if (str != null && str.length() > 0) {
                setErrorString(str);
                aVar.bTJ = str;
            }
            aVar.type = 1;
            aVar.bTK = false;
            aVar.bTL = this.bTB;
            this.bTC.a(aVar);
            return;
        }
        aVar.type = 1;
        aVar.bTK = true;
        aVar.bTL = this.bTB;
        this.bTC.a(aVar);
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
            this.bTB = null;
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
                this.bTB = new com.baidu.tieba.enterForum.b.b();
                this.bTB.setTime(forumrecommendhttpresponsemessage.GetTime().intValue());
                this.bTB.hV(forumrecommendhttpresponsemessage.GetMsignValid().intValue());
                this.bTB.jq(forumrecommendhttpresponsemessage.GetMsignText());
                this.bTB.hW(forumrecommendhttpresponsemessage.GetMsignLevel().intValue());
                this.bTB.setIsMem(forumrecommendhttpresponsemessage.GetIsMem().intValue());
                this.bTB.hU(forumrecommendhttpresponsemessage.GetIsLogin().intValue());
                this.bTB.dW(false);
                h hVar = new h();
                hVar.setLevel(forumrecommendhttpresponsemessage.GetMsignLevel().intValue());
                hVar.ai(forumrecommendhttpresponsemessage.GetLikeForum());
                this.bTB.a(hVar);
                k kVar = new k();
                kVar.aj(forumrecommendhttpresponsemessage.GetRecommendForumInfoList());
                this.bTB.a(kVar);
                this.bTB.ah(ak(forumrecommendhttpresponsemessage.getRecommendConcernForums()));
                this.bTB.az(true);
                this.bTB.a(forumrecommendhttpresponsemessage.getHotSearchInfoData());
            } catch (Exception e) {
                this.bTB.az(false);
                BdLog.e(e.getMessage());
            }
        }
    }

    private List<g> ak(List<RecommendForumInfo> list) {
        if (z.t(list)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        int i = 0;
        for (RecommendForumInfo recommendForumInfo : list) {
            if (i >= 4) {
                break;
            } else if (recommendForumInfo != null && recommendForumInfo.forum_id.longValue() > 0 && !StringUtils.isNull(recommendForumInfo.forum_name)) {
                g gVar = new g();
                gVar.avatar = recommendForumInfo.avatar;
                gVar.forumId = recommendForumInfo.forum_id.longValue();
                gVar.forumName = recommendForumInfo.forum_name;
                gVar.followNum = recommendForumInfo.member_count.intValue();
                gVar.threadNum = recommendForumInfo.thread_count.intValue();
                gVar.isSelected = true;
                arrayList.add(gVar);
                i++;
            }
        }
        return arrayList;
    }

    public void b(forumRecommendSocketResponseMessage forumrecommendsocketresponsemessage) {
        if (forumrecommendsocketresponsemessage != null) {
            try {
                this.bTB = new com.baidu.tieba.enterForum.b.b();
                this.bTB.setTime(forumrecommendsocketresponsemessage.GetTime().intValue());
                this.bTB.hV(forumrecommendsocketresponsemessage.GetMsignValid().intValue());
                this.bTB.jq(forumrecommendsocketresponsemessage.GetMsignText());
                this.bTB.hW(forumrecommendsocketresponsemessage.GetMsignLevel().intValue());
                this.bTB.setIsMem(forumrecommendsocketresponsemessage.GetIsMem().intValue());
                this.bTB.hU(forumrecommendsocketresponsemessage.GetIsLogin().intValue());
                this.bTB.dW(false);
                h hVar = new h();
                hVar.setLevel(forumrecommendsocketresponsemessage.GetMsignLevel().intValue());
                hVar.ai(forumrecommendsocketresponsemessage.GetLikeForum());
                this.bTB.a(hVar);
                k kVar = new k();
                kVar.aj(forumrecommendsocketresponsemessage.GetRecommendForumInfoList());
                this.bTB.a(kVar);
                this.bTB.ah(ak(forumrecommendsocketresponsemessage.getRecommendConcernForums()));
                this.bTB.az(true);
                this.bTB.a(forumrecommendsocketresponsemessage.getHotSearchInfoData());
            } catch (Exception e) {
                this.bTB.az(false);
                BdLog.e(e.getMessage());
            }
        }
    }

    private void abe() {
        new c(this).execute(new Void[0]);
    }

    public void al(List<com.baidu.tieba.enterForum.b.g> list) {
        if (list != null) {
            ArrayList arrayList = new ArrayList();
            for (com.baidu.tieba.enterForum.b.g gVar : list) {
                if (gVar != null && gVar.getType() == 0 && !StringUtils.isNull(gVar.getName())) {
                    arrayList.add(new c.a(gVar.getName(), gVar.getLevel()));
                }
            }
            com.baidu.tbadk.util.c.D(arrayList);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_CHANGE_SUB_TAB, true));
        }
    }

    public List<com.baidu.tieba.enterForum.b.g> a(List<com.baidu.tieba.enterForum.b.g> list, String[] strArr) {
        ArrayList arrayList = new ArrayList();
        if (list == null || list.isEmpty()) {
            return arrayList;
        }
        if (strArr == null || strArr.length == 0) {
            arrayList.addAll(list);
        } else {
            for (String str : strArr) {
                for (com.baidu.tieba.enterForum.b.g gVar : list) {
                    if (gVar != null && gVar.getName() != null && gVar.getName().equals(str)) {
                        arrayList.add(gVar);
                    }
                }
            }
            int size = list.size();
            for (int i = 0; i < size; i++) {
                com.baidu.tieba.enterForum.b.g gVar2 = list.get(i);
                if (!arrayList.contains(gVar2)) {
                    arrayList.add(gVar2);
                }
            }
        }
        return arrayList;
    }

    public boolean h(List<com.baidu.tieba.enterForum.b.g> list, List<com.baidu.tieba.enterForum.b.g> list2) {
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
            com.baidu.tieba.enterForum.b.g gVar = list.get(i);
            com.baidu.tieba.enterForum.b.g gVar2 = list2.get(i);
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
