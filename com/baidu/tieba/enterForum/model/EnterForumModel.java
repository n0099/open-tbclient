package com.baidu.tieba.enterForum.model;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.cache.l;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.w;
import com.baidu.tbadk.util.c;
import com.baidu.tieba.enterForum.data.g;
import com.baidu.tieba.enterForum.data.j;
import com.baidu.tieba.enterForum.home.forumRecommendHttpResponseMessage;
import com.baidu.tieba.enterForum.home.forumRecommendRequestMessage;
import com.baidu.tieba.enterForum.home.forumRecommendSocketResponseMessage;
import com.baidu.tieba.f;
import com.squareup.wire.Wire;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tbclient.ForumRecommend.ForumRecommendResIdl;
import tbclient.RecommendForumInfo;
/* loaded from: classes2.dex */
public class EnterForumModel extends BdBaseModel {
    public static final String FORUMRECOMMEND_CACHE_KEY = "forumRecommend_cache_key";
    public static final int MAX_LIKE_SHOWED = 500;
    public static final int TYPE_DB = 0;
    public static final int TYPE_DEFAULT = -1;
    public static final int TYPE_NET = 1;
    private com.baidu.tieba.enterForum.data.b cTr;
    private b cTs;
    private com.baidu.tieba.tbadkCore.d.b cTt;
    private long cTu;
    private long cTv;
    private long cTw;
    private long cTx;

    /* loaded from: classes2.dex */
    public interface b {
        void a(a aVar);
    }

    /* loaded from: classes2.dex */
    public class a {
        public String error = "";
        public boolean cTz = false;
        public int type = -1;
        public com.baidu.tieba.enterForum.data.b cTA = null;

        public a() {
        }
    }

    public EnterForumModel(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.cTr = null;
        this.cTs = null;
        this.cTt = null;
        this.cTu = 0L;
        this.cTv = 0L;
        this.cTw = 0L;
        this.cTx = 0L;
        setUniqueId(BdUniqueId.gen());
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public BdUniqueId getUniqueId() {
        return this.unique_id;
    }

    public long apc() {
        return this.cTx;
    }

    public long apd() {
        return this.cTv;
    }

    public long ape() {
        return this.cTw;
    }

    public long apf() {
        return this.cTu;
    }

    public com.baidu.tieba.enterForum.data.b apg() {
        return this.cTr;
    }

    public void c(com.baidu.tieba.enterForum.data.b bVar) {
        this.cTr = bVar;
    }

    public void a(b bVar) {
        this.cTs = bVar;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        cancelMessage();
        aph();
        return true;
    }

    private void aph() {
        if (this.cTt != null) {
            this.cTt.destory();
            this.cTt = null;
        }
    }

    public boolean fh(boolean z) {
        cancelLoadData();
        forumRecommendRequestMessage forumrecommendrequestmessage = new forumRecommendRequestMessage();
        forumrecommendrequestmessage.set_like_forum(Integer.valueOf(z ? 1 : 0));
        forumrecommendrequestmessage.set_topic(0);
        forumrecommendrequestmessage.set_recommend(1);
        this.cTu = System.currentTimeMillis();
        if (this.cTt == null) {
            this.cTt = new com.baidu.tieba.tbadkCore.d.b("forumrecommendStat");
        }
        sendMessage(forumrecommendrequestmessage);
        return true;
    }

    public boolean fi(boolean z) {
        apj();
        return true;
    }

    public void a(boolean z, int i, String str, boolean z2, int i2, long j, long j2) {
        a aVar = new a();
        boolean z3 = !z;
        if (this.cTt != null) {
            this.cTt.a(z2, z3, i, str, i2, j, j2);
            this.cTt = null;
        }
        if (z || !this.cTr.isSuccess()) {
            if (str != null && str.length() > 0) {
                setErrorString(str);
                aVar.error = str;
            }
            aVar.type = 1;
            aVar.cTz = false;
            aVar.cTA = this.cTr;
            this.cTs.a(aVar);
            return;
        }
        aVar.type = 1;
        aVar.cTz = true;
        aVar.cTA = this.cTr;
        this.cTs.a(aVar);
    }

    public void a(forumRecommendSocketResponseMessage forumrecommendsocketresponsemessage) {
        String errorString;
        int downSize = forumrecommendsocketresponsemessage.getDownSize();
        long costTime = forumrecommendsocketresponsemessage.getCostTime();
        if (StringUtils.isNull(forumrecommendsocketresponsemessage.getErrorString())) {
            errorString = TbadkCoreApplication.getInst().getApp().getResources().getString(f.j.neterror);
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
            errorString = TbadkCoreApplication.getInst().getApp().getResources().getString(f.j.neterror);
        } else {
            errorString = forumrecommendhttpresponsemessage.getErrorString();
        }
        a(forumrecommendhttpresponsemessage, forumrecommendhttpresponsemessage.hasError(), forumrecommendhttpresponsemessage.getError(), errorString, true, downSize, costTime, 0L);
    }

    public void a(ResponsedMessage<?> responsedMessage, boolean z, int i, String str, boolean z2, int i2, long j, long j2) {
        if (z) {
            this.cTr = null;
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
                this.cTr = new com.baidu.tieba.enterForum.data.b();
                this.cTr.setTime(forumrecommendhttpresponsemessage.GetTime().intValue());
                g gVar = new g();
                gVar.aN(forumrecommendhttpresponsemessage.GetLikeForum());
                this.cTr.a(gVar);
                j jVar = new j();
                jVar.aO(forumrecommendhttpresponsemessage.GetRecommendForumInfoList());
                this.cTr.a(jVar);
                this.cTr.aM(aQ(forumrecommendhttpresponsemessage.getRecommendConcernForums()));
                this.cTr.aE(true);
                this.cTr.a(forumrecommendhttpresponsemessage.getHotSearchInfoData());
            } catch (Exception e) {
                this.cTr.aE(false);
                BdLog.e(e.getMessage());
            }
        }
    }

    private List<com.baidu.tieba.enterForum.multiConcern.b> aQ(List<RecommendForumInfo> list) {
        if (w.z(list)) {
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
                this.cTr = new com.baidu.tieba.enterForum.data.b();
                this.cTr.setTime(forumrecommendsocketresponsemessage.GetTime().intValue());
                g gVar = new g();
                gVar.aN(forumrecommendsocketresponsemessage.GetLikeForum());
                this.cTr.a(gVar);
                j jVar = new j();
                jVar.aO(forumrecommendsocketresponsemessage.GetRecommendForumInfoList());
                this.cTr.a(jVar);
                this.cTr.aM(aQ(forumrecommendsocketresponsemessage.getRecommendConcernForums()));
                this.cTr.aE(true);
                this.cTr.a(forumrecommendsocketresponsemessage.getHotSearchInfoData());
            } catch (Exception e) {
                this.cTr.aE(false);
                BdLog.e(e.getMessage());
            }
        }
    }

    private void apj() {
        new BdAsyncTask<Void, Void, com.baidu.tieba.enterForum.data.b>() { // from class: com.baidu.tieba.enterForum.model.EnterForumModel.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
            /* renamed from: g */
            public com.baidu.tieba.enterForum.data.b doInBackground(Void... voidArr) {
                l<byte[]> P = com.baidu.tbadk.core.c.a.xa().P("tb_forum_recommend", TbadkCoreApplication.getCurrentAccountName());
                com.baidu.tieba.enterForum.data.b bVar = new com.baidu.tieba.enterForum.data.b();
                byte[] bArr = P.get(EnterForumModel.FORUMRECOMMEND_CACHE_KEY);
                if (bArr != null) {
                    bVar.aE(true);
                    try {
                        ForumRecommendResIdl forumRecommendResIdl = (ForumRecommendResIdl) new Wire(new Class[0]).parseFrom(bArr, ForumRecommendResIdl.class);
                        if (forumRecommendResIdl.data != null) {
                            bVar.a(forumRecommendResIdl.data);
                        }
                    } catch (Exception e) {
                        bVar.aE(false);
                    }
                    if (bVar.isSuccess() && !bVar.aou()) {
                        bVar.aos().aoz();
                    }
                }
                return bVar;
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
            /* renamed from: d */
            public void onPostExecute(com.baidu.tieba.enterForum.data.b bVar) {
                super.onPostExecute(bVar);
                a aVar = new a();
                aVar.type = 0;
                if (bVar != null && bVar.isSuccess()) {
                    aVar.cTz = true;
                    aVar.cTA = bVar;
                } else {
                    aVar.cTz = false;
                    aVar.cTA = bVar;
                }
                EnterForumModel.this.cTs.a(aVar);
            }
        }.execute(new Void[0]);
    }

    public void aR(List<com.baidu.tieba.enterForum.data.f> list) {
        if (list != null) {
            ArrayList arrayList = new ArrayList();
            for (com.baidu.tieba.enterForum.data.f fVar : list) {
                if (fVar != null && fVar.getType() == 0 && !StringUtils.isNull(fVar.getName())) {
                    arrayList.add(new c.a(fVar.getName(), fVar.getLevel()));
                }
            }
            com.baidu.tbadk.util.c.M(arrayList);
        }
    }

    public List<com.baidu.tieba.enterForum.data.f> a(List<com.baidu.tieba.enterForum.data.f> list, String[] strArr) {
        ArrayList arrayList = new ArrayList();
        if (list == null || list.isEmpty()) {
            return arrayList;
        }
        if (strArr == null || strArr.length == 0) {
            arrayList.addAll(list);
        } else {
            for (String str : strArr) {
                for (com.baidu.tieba.enterForum.data.f fVar : list) {
                    if (fVar != null && fVar.getName() != null && fVar.getName().equals(str)) {
                        arrayList.add(fVar);
                    }
                }
            }
            int size = list.size();
            for (int i = 0; i < size; i++) {
                com.baidu.tieba.enterForum.data.f fVar2 = list.get(i);
                if (!arrayList.contains(fVar2)) {
                    arrayList.add(fVar2);
                }
            }
        }
        return arrayList;
    }

    public boolean i(List<com.baidu.tieba.enterForum.data.f> list, List<com.baidu.tieba.enterForum.data.f> list2) {
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
            com.baidu.tieba.enterForum.data.f fVar = list.get(i);
            com.baidu.tieba.enterForum.data.f fVar2 = list2.get(i);
            if (fVar == null || fVar2 == null) {
                return false;
            }
            if (!fVar.getId().equals(fVar2.getId())) {
                return false;
            }
        }
        return true;
    }
}
