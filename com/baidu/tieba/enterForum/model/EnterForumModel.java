package com.baidu.tieba.enterForum.model;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.cache.l;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.u;
import com.baidu.tbadk.util.c;
import com.baidu.tieba.d;
import com.baidu.tieba.enterForum.b.g;
import com.baidu.tieba.enterForum.b.h;
import com.baidu.tieba.enterForum.b.k;
import com.baidu.tieba.enterForum.home.forumRecommendHttpResponseMessage;
import com.baidu.tieba.enterForum.home.forumRecommendRequestMessage;
import com.baidu.tieba.enterForum.home.forumRecommendSocketResponseMessage;
import com.squareup.wire.Wire;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tbclient.ForumRecommend.ForumRecommendResIdl;
import tbclient.RecommendForumInfo;
/* loaded from: classes.dex */
public class EnterForumModel extends BdBaseModel {
    public static final String FORUMRECOMMEND_CACHE_KEY = "forumRecommend_cache_key";
    public static final int MAX_LIKE_SHOWED = 500;
    public static final int TYPE_DB = 0;
    public static final int TYPE_DEFAULT = -1;
    public static final int TYPE_NET = 1;
    private com.baidu.tieba.enterForum.b.b bZH;
    private b bZI;
    private com.baidu.tieba.tbadkCore.d.b bZJ;
    private long bZK;
    private long bZL;
    private long bZM;
    private long bZN;

    /* loaded from: classes.dex */
    public interface b {
        void a(a aVar);
    }

    /* loaded from: classes.dex */
    public class a {
        public String bZP = "";
        public boolean bZQ = false;
        public int type = -1;
        public com.baidu.tieba.enterForum.b.b bZR = null;

        public a() {
        }
    }

    public EnterForumModel(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.bZH = null;
        this.bZI = null;
        this.bZJ = null;
        this.bZK = 0L;
        this.bZL = 0L;
        this.bZM = 0L;
        this.bZN = 0L;
        setUniqueId(BdUniqueId.gen());
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public BdUniqueId getUniqueId() {
        return this.unique_id;
    }

    public long ack() {
        return this.bZN;
    }

    public long acl() {
        return this.bZL;
    }

    public long acm() {
        return this.bZM;
    }

    public long acn() {
        return this.bZK;
    }

    public com.baidu.tieba.enterForum.b.b aco() {
        return this.bZH;
    }

    public void c(com.baidu.tieba.enterForum.b.b bVar) {
        this.bZH = bVar;
    }

    public void a(b bVar) {
        this.bZI = bVar;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        cancelMessage();
        acp();
        return true;
    }

    private void acp() {
        if (this.bZJ != null) {
            this.bZJ.destory();
            this.bZJ = null;
        }
    }

    public boolean el(boolean z) {
        cancelLoadData();
        forumRecommendRequestMessage forumrecommendrequestmessage = new forumRecommendRequestMessage();
        forumrecommendrequestmessage.set_like_forum(Integer.valueOf(z ? 1 : 0));
        forumrecommendrequestmessage.set_topic(0);
        forumrecommendrequestmessage.set_recommend(1);
        this.bZK = System.currentTimeMillis();
        if (this.bZJ == null) {
            this.bZJ = new com.baidu.tieba.tbadkCore.d.b("forumrecommendStat");
        }
        sendMessage(forumrecommendrequestmessage);
        return true;
    }

    public boolean em(boolean z) {
        acq();
        return true;
    }

    public void a(boolean z, int i, String str, boolean z2, int i2, long j, long j2) {
        a aVar = new a();
        boolean z3 = !z;
        if (this.bZJ != null) {
            this.bZJ.a(z2, z3, i, str, i2, j, j2);
            this.bZJ = null;
        }
        this.bZH.eg(false);
        if (z || !this.bZH.isSuccess()) {
            if (str != null && str.length() > 0) {
                setErrorString(str);
                aVar.bZP = str;
            }
            aVar.type = 1;
            aVar.bZQ = false;
            aVar.bZR = this.bZH;
            this.bZI.a(aVar);
            return;
        }
        aVar.type = 1;
        aVar.bZQ = true;
        aVar.bZR = this.bZH;
        this.bZI.a(aVar);
    }

    public void a(forumRecommendSocketResponseMessage forumrecommendsocketresponsemessage) {
        String errorString;
        int downSize = forumrecommendsocketresponsemessage.getDownSize();
        long costTime = forumrecommendsocketresponsemessage.getCostTime();
        if (StringUtils.isNull(forumrecommendsocketresponsemessage.getErrorString())) {
            errorString = TbadkCoreApplication.getInst().getApp().getResources().getString(d.l.neterror);
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
            errorString = TbadkCoreApplication.getInst().getApp().getResources().getString(d.l.neterror);
        } else {
            errorString = forumrecommendhttpresponsemessage.getErrorString();
        }
        a(forumrecommendhttpresponsemessage, forumrecommendhttpresponsemessage.hasError(), forumrecommendhttpresponsemessage.getError(), errorString, true, downSize, costTime, 0L);
    }

    public void a(ResponsedMessage<?> responsedMessage, boolean z, int i, String str, boolean z2, int i2, long j, long j2) {
        if (z) {
            this.bZH = null;
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
                this.bZH = new com.baidu.tieba.enterForum.b.b();
                this.bZH.setTime(forumrecommendhttpresponsemessage.GetTime().intValue());
                this.bZH.ie(forumrecommendhttpresponsemessage.GetMsignValid().intValue());
                this.bZH.jC(forumrecommendhttpresponsemessage.GetMsignText());
                this.bZH.m11if(forumrecommendhttpresponsemessage.GetMsignLevel().intValue());
                this.bZH.setIsMem(forumrecommendhttpresponsemessage.GetIsMem().intValue());
                this.bZH.id(forumrecommendhttpresponsemessage.GetIsLogin().intValue());
                this.bZH.eg(false);
                h hVar = new h();
                hVar.setLevel(forumrecommendhttpresponsemessage.GetMsignLevel().intValue());
                hVar.ao(forumrecommendhttpresponsemessage.GetLikeForum());
                this.bZH.a(hVar);
                k kVar = new k();
                kVar.ap(forumrecommendhttpresponsemessage.GetRecommendForumInfoList());
                this.bZH.a(kVar);
                this.bZH.an(aq(forumrecommendhttpresponsemessage.getRecommendConcernForums()));
                this.bZH.ay(true);
                this.bZH.a(forumrecommendhttpresponsemessage.getHotSearchInfoData());
            } catch (Exception e) {
                this.bZH.ay(false);
                BdLog.e(e.getMessage());
            }
        }
    }

    private List<com.baidu.tieba.enterForum.multiConcern.b> aq(List<RecommendForumInfo> list) {
        if (u.v(list)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        int i = 0;
        Iterator<RecommendForumInfo> it = list.iterator();
        while (true) {
            int i2 = i;
            if (!it.hasNext()) {
                break;
            }
            RecommendForumInfo next = it.next();
            if (i2 >= 4) {
                break;
            }
            if (next != null && next.forum_id.longValue() > 0 && !StringUtils.isNull(next.forum_name)) {
                com.baidu.tieba.enterForum.multiConcern.b bVar = new com.baidu.tieba.enterForum.multiConcern.b();
                bVar.avatar = next.avatar;
                bVar.forumId = next.forum_id.longValue();
                bVar.forumName = next.forum_name;
                bVar.followNum = next.member_count.intValue();
                bVar.threadNum = next.thread_count.intValue();
                bVar.isSelected = true;
                arrayList.add(bVar);
                i2++;
            }
            i = i2;
        }
        return arrayList;
    }

    public void b(forumRecommendSocketResponseMessage forumrecommendsocketresponsemessage) {
        if (forumrecommendsocketresponsemessage != null) {
            try {
                this.bZH = new com.baidu.tieba.enterForum.b.b();
                this.bZH.setTime(forumrecommendsocketresponsemessage.GetTime().intValue());
                this.bZH.ie(forumrecommendsocketresponsemessage.GetMsignValid().intValue());
                this.bZH.jC(forumrecommendsocketresponsemessage.GetMsignText());
                this.bZH.m11if(forumrecommendsocketresponsemessage.GetMsignLevel().intValue());
                this.bZH.setIsMem(forumrecommendsocketresponsemessage.GetIsMem().intValue());
                this.bZH.id(forumrecommendsocketresponsemessage.GetIsLogin().intValue());
                this.bZH.eg(false);
                h hVar = new h();
                hVar.setLevel(forumrecommendsocketresponsemessage.GetMsignLevel().intValue());
                hVar.ao(forumrecommendsocketresponsemessage.GetLikeForum());
                this.bZH.a(hVar);
                k kVar = new k();
                kVar.ap(forumrecommendsocketresponsemessage.GetRecommendForumInfoList());
                this.bZH.a(kVar);
                this.bZH.an(aq(forumrecommendsocketresponsemessage.getRecommendConcernForums()));
                this.bZH.ay(true);
                this.bZH.a(forumrecommendsocketresponsemessage.getHotSearchInfoData());
            } catch (Exception e) {
                this.bZH.ay(false);
                BdLog.e(e.getMessage());
            }
        }
    }

    private void acq() {
        new BdAsyncTask<Void, Void, com.baidu.tieba.enterForum.b.b>() { // from class: com.baidu.tieba.enterForum.model.EnterForumModel.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
            /* renamed from: e */
            public com.baidu.tieba.enterForum.b.b doInBackground(Void... voidArr) {
                l<byte[]> L = com.baidu.tbadk.core.c.a.tn().L("tb_forum_recommend", TbadkCoreApplication.getCurrentAccountName());
                com.baidu.tieba.enterForum.b.b bVar = new com.baidu.tieba.enterForum.b.b();
                byte[] bArr = L.get(EnterForumModel.FORUMRECOMMEND_CACHE_KEY);
                if (bArr != null) {
                    bVar.ay(true);
                    try {
                        ForumRecommendResIdl forumRecommendResIdl = (ForumRecommendResIdl) new Wire(new Class[0]).parseFrom(bArr, ForumRecommendResIdl.class);
                        if (forumRecommendResIdl.data != null) {
                            bVar.a(forumRecommendResIdl.data);
                            bVar.eg(true);
                        }
                    } catch (Exception e) {
                        bVar.ay(false);
                    }
                    if (bVar.isSuccess() && !bVar.abH()) {
                        bVar.abE().abM();
                    }
                }
                return bVar;
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
            /* renamed from: d */
            public void onPostExecute(com.baidu.tieba.enterForum.b.b bVar) {
                super.onPostExecute(bVar);
                a aVar = new a();
                aVar.type = 0;
                if (bVar != null && bVar.isSuccess()) {
                    aVar.bZQ = true;
                    aVar.bZR = bVar;
                } else {
                    aVar.bZQ = false;
                    aVar.bZR = bVar;
                }
                EnterForumModel.this.bZI.a(aVar);
            }
        }.execute(new Void[0]);
    }

    public void ar(List<g> list) {
        if (list != null) {
            ArrayList arrayList = new ArrayList();
            for (g gVar : list) {
                if (gVar != null && gVar.getType() == 0 && !StringUtils.isNull(gVar.getName())) {
                    arrayList.add(new c.a(gVar.getName(), gVar.getLevel()));
                }
            }
            com.baidu.tbadk.util.c.H(arrayList);
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

    public boolean h(List<g> list, List<g> list2) {
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
