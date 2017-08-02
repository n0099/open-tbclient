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
    private com.baidu.tieba.enterForum.b.b bXP;
    private b bXQ;
    private com.baidu.tieba.tbadkCore.d.b bXR;
    private long bXS;
    private long bXT;
    private long bXU;
    private long bXV;

    /* loaded from: classes.dex */
    public interface b {
        void a(a aVar);
    }

    /* loaded from: classes.dex */
    public class a {
        public String bXX = "";
        public boolean bXY = false;
        public int type = -1;
        public com.baidu.tieba.enterForum.b.b bXZ = null;

        public a() {
        }
    }

    public EnterForumModel(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.bXP = null;
        this.bXQ = null;
        this.bXR = null;
        this.bXS = 0L;
        this.bXT = 0L;
        this.bXU = 0L;
        this.bXV = 0L;
        setUniqueId(BdUniqueId.gen());
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public BdUniqueId getUniqueId() {
        return this.unique_id;
    }

    public long abK() {
        return this.bXV;
    }

    public long abL() {
        return this.bXT;
    }

    public long abM() {
        return this.bXU;
    }

    public long abN() {
        return this.bXS;
    }

    public com.baidu.tieba.enterForum.b.b abO() {
        return this.bXP;
    }

    public void c(com.baidu.tieba.enterForum.b.b bVar) {
        this.bXP = bVar;
    }

    public void a(b bVar) {
        this.bXQ = bVar;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        cancelMessage();
        abP();
        return true;
    }

    private void abP() {
        if (this.bXR != null) {
            this.bXR.destory();
            this.bXR = null;
        }
    }

    public boolean ek(boolean z) {
        cancelLoadData();
        forumRecommendRequestMessage forumrecommendrequestmessage = new forumRecommendRequestMessage();
        forumrecommendrequestmessage.set_like_forum(Integer.valueOf(z ? 1 : 0));
        forumrecommendrequestmessage.set_topic(0);
        forumrecommendrequestmessage.set_recommend(1);
        this.bXS = System.currentTimeMillis();
        if (this.bXR == null) {
            this.bXR = new com.baidu.tieba.tbadkCore.d.b("forumrecommendStat");
        }
        sendMessage(forumrecommendrequestmessage);
        return true;
    }

    public boolean el(boolean z) {
        abQ();
        return true;
    }

    public void a(boolean z, int i, String str, boolean z2, int i2, long j, long j2) {
        a aVar = new a();
        boolean z3 = !z;
        if (this.bXR != null) {
            this.bXR.a(z2, z3, i, str, i2, j, j2);
            this.bXR = null;
        }
        this.bXP.ef(false);
        if (z || !this.bXP.isSuccess()) {
            if (str != null && str.length() > 0) {
                setErrorString(str);
                aVar.bXX = str;
            }
            aVar.type = 1;
            aVar.bXY = false;
            aVar.bXZ = this.bXP;
            this.bXQ.a(aVar);
            return;
        }
        aVar.type = 1;
        aVar.bXY = true;
        aVar.bXZ = this.bXP;
        this.bXQ.a(aVar);
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
            this.bXP = null;
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
                this.bXP = new com.baidu.tieba.enterForum.b.b();
                this.bXP.setTime(forumrecommendhttpresponsemessage.GetTime().intValue());
                this.bXP.ic(forumrecommendhttpresponsemessage.GetMsignValid().intValue());
                this.bXP.jw(forumrecommendhttpresponsemessage.GetMsignText());
                this.bXP.id(forumrecommendhttpresponsemessage.GetMsignLevel().intValue());
                this.bXP.setIsMem(forumrecommendhttpresponsemessage.GetIsMem().intValue());
                this.bXP.ib(forumrecommendhttpresponsemessage.GetIsLogin().intValue());
                this.bXP.ef(false);
                h hVar = new h();
                hVar.setLevel(forumrecommendhttpresponsemessage.GetMsignLevel().intValue());
                hVar.ao(forumrecommendhttpresponsemessage.GetLikeForum());
                this.bXP.a(hVar);
                k kVar = new k();
                kVar.ap(forumrecommendhttpresponsemessage.GetRecommendForumInfoList());
                this.bXP.a(kVar);
                this.bXP.an(aq(forumrecommendhttpresponsemessage.getRecommendConcernForums()));
                this.bXP.ay(true);
                this.bXP.a(forumrecommendhttpresponsemessage.getHotSearchInfoData());
            } catch (Exception e) {
                this.bXP.ay(false);
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
                this.bXP = new com.baidu.tieba.enterForum.b.b();
                this.bXP.setTime(forumrecommendsocketresponsemessage.GetTime().intValue());
                this.bXP.ic(forumrecommendsocketresponsemessage.GetMsignValid().intValue());
                this.bXP.jw(forumrecommendsocketresponsemessage.GetMsignText());
                this.bXP.id(forumrecommendsocketresponsemessage.GetMsignLevel().intValue());
                this.bXP.setIsMem(forumrecommendsocketresponsemessage.GetIsMem().intValue());
                this.bXP.ib(forumrecommendsocketresponsemessage.GetIsLogin().intValue());
                this.bXP.ef(false);
                h hVar = new h();
                hVar.setLevel(forumrecommendsocketresponsemessage.GetMsignLevel().intValue());
                hVar.ao(forumrecommendsocketresponsemessage.GetLikeForum());
                this.bXP.a(hVar);
                k kVar = new k();
                kVar.ap(forumrecommendsocketresponsemessage.GetRecommendForumInfoList());
                this.bXP.a(kVar);
                this.bXP.an(aq(forumrecommendsocketresponsemessage.getRecommendConcernForums()));
                this.bXP.ay(true);
                this.bXP.a(forumrecommendsocketresponsemessage.getHotSearchInfoData());
            } catch (Exception e) {
                this.bXP.ay(false);
                BdLog.e(e.getMessage());
            }
        }
    }

    private void abQ() {
        new BdAsyncTask<Void, Void, com.baidu.tieba.enterForum.b.b>() { // from class: com.baidu.tieba.enterForum.model.EnterForumModel.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
            /* renamed from: e */
            public com.baidu.tieba.enterForum.b.b doInBackground(Void... voidArr) {
                l<byte[]> L = com.baidu.tbadk.core.c.a.td().L("tb_forum_recommend", TbadkCoreApplication.getCurrentAccountName());
                com.baidu.tieba.enterForum.b.b bVar = new com.baidu.tieba.enterForum.b.b();
                byte[] bArr = L.get(EnterForumModel.FORUMRECOMMEND_CACHE_KEY);
                if (bArr != null) {
                    bVar.ay(true);
                    try {
                        ForumRecommendResIdl forumRecommendResIdl = (ForumRecommendResIdl) new Wire(new Class[0]).parseFrom(bArr, ForumRecommendResIdl.class);
                        if (forumRecommendResIdl.data != null) {
                            bVar.a(forumRecommendResIdl.data);
                            bVar.ef(true);
                        }
                    } catch (Exception e) {
                        bVar.ay(false);
                    }
                    if (bVar.isSuccess() && !bVar.abh()) {
                        bVar.abe().abm();
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
                    aVar.bXY = true;
                    aVar.bXZ = bVar;
                } else {
                    aVar.bXY = false;
                    aVar.bXZ = bVar;
                }
                EnterForumModel.this.bXQ.a(aVar);
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
