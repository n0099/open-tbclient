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
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.util.d;
import com.baidu.tieba.e;
import com.baidu.tieba.enterForum.data.f;
import com.baidu.tieba.enterForum.data.g;
import com.baidu.tieba.enterForum.data.j;
import com.baidu.tieba.enterForum.home.forumRecommendHttpResponseMessage;
import com.baidu.tieba.enterForum.home.forumRecommendRequestMessage;
import com.baidu.tieba.enterForum.home.forumRecommendSocketResponseMessage;
import com.squareup.wire.Wire;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tbclient.ForumRecommend.ForumRecommendResIdl;
import tbclient.RecommendForumInfo;
/* loaded from: classes4.dex */
public class EnterForumModel extends BdBaseModel {
    public static final String FORUMRECOMMEND_CACHE_KEY = "forumRecommend_cache_key";
    public static final int MAX_LIKE_SHOWED = 500;
    public static final int TYPE_DB = 0;
    public static final int TYPE_DEFAULT = -1;
    public static final int TYPE_NET = 1;
    private long dhA;
    private long dhB;
    private long dhC;
    private long dhD;
    private com.baidu.tieba.enterForum.data.b dhx;
    private b dhy;
    private com.baidu.tieba.tbadkCore.d.b dhz;

    /* loaded from: classes4.dex */
    public interface b {
        void a(a aVar);
    }

    /* loaded from: classes4.dex */
    public class a {
        public String error = "";
        public boolean dhF = false;
        public int type = -1;
        public com.baidu.tieba.enterForum.data.b dhG = null;

        public a() {
        }
    }

    public EnterForumModel(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.dhx = null;
        this.dhy = null;
        this.dhz = null;
        this.dhA = 0L;
        this.dhB = 0L;
        this.dhC = 0L;
        this.dhD = 0L;
        setUniqueId(BdUniqueId.gen());
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public BdUniqueId getUniqueId() {
        return this.unique_id;
    }

    public long aun() {
        return this.dhD;
    }

    public long auo() {
        return this.dhB;
    }

    public long aup() {
        return this.dhC;
    }

    public long auq() {
        return this.dhA;
    }

    public com.baidu.tieba.enterForum.data.b aur() {
        return this.dhx;
    }

    public void c(com.baidu.tieba.enterForum.data.b bVar) {
        this.dhx = bVar;
    }

    public void a(b bVar) {
        this.dhy = bVar;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        cancelMessage();
        aus();
        return true;
    }

    private void aus() {
        if (this.dhz != null) {
            this.dhz.destory();
            this.dhz = null;
        }
    }

    public boolean fQ(boolean z) {
        cancelLoadData();
        forumRecommendRequestMessage forumrecommendrequestmessage = new forumRecommendRequestMessage();
        forumrecommendrequestmessage.set_like_forum(Integer.valueOf(z ? 1 : 0));
        forumrecommendrequestmessage.set_topic(0);
        forumrecommendrequestmessage.set_recommend(1);
        this.dhA = System.currentTimeMillis();
        if (this.dhz == null) {
            this.dhz = new com.baidu.tieba.tbadkCore.d.b("forumrecommendStat");
        }
        sendMessage(forumrecommendrequestmessage);
        return true;
    }

    public boolean fR(boolean z) {
        aut();
        return true;
    }

    public void a(boolean z, int i, String str, boolean z2, int i2, long j, long j2) {
        a aVar = new a();
        boolean z3 = !z;
        if (this.dhz != null) {
            this.dhz.a(z2, z3, i, str, i2, j, j2);
            this.dhz = null;
        }
        if (z || !this.dhx.isSuccess()) {
            if (str != null && str.length() > 0) {
                setErrorString(str);
                aVar.error = str;
            }
            aVar.type = 1;
            aVar.dhF = false;
            aVar.dhG = this.dhx;
            this.dhy.a(aVar);
            return;
        }
        aVar.type = 1;
        aVar.dhF = true;
        aVar.dhG = this.dhx;
        this.dhy.a(aVar);
    }

    public void a(forumRecommendSocketResponseMessage forumrecommendsocketresponsemessage) {
        String errorString;
        int downSize = forumrecommendsocketresponsemessage.getDownSize();
        long costTime = forumrecommendsocketresponsemessage.getCostTime();
        if (StringUtils.isNull(forumrecommendsocketresponsemessage.getErrorString())) {
            errorString = TbadkCoreApplication.getInst().getApp().getResources().getString(e.j.neterror);
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
            errorString = TbadkCoreApplication.getInst().getApp().getResources().getString(e.j.neterror);
        } else {
            errorString = forumrecommendhttpresponsemessage.getErrorString();
        }
        a(forumrecommendhttpresponsemessage, forumrecommendhttpresponsemessage.hasError(), forumrecommendhttpresponsemessage.getError(), errorString, true, downSize, costTime, 0L);
    }

    public void a(ResponsedMessage<?> responsedMessage, boolean z, int i, String str, boolean z2, int i2, long j, long j2) {
        if (z) {
            this.dhx = null;
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
                this.dhx = new com.baidu.tieba.enterForum.data.b();
                this.dhx.setTime(forumrecommendhttpresponsemessage.GetTime().intValue());
                g gVar = new g();
                gVar.be(forumrecommendhttpresponsemessage.GetLikeForum());
                this.dhx.a(gVar);
                j jVar = new j();
                jVar.bf(forumrecommendhttpresponsemessage.GetRecommendForumInfoList());
                this.dhx.a(jVar);
                this.dhx.bd(bh(forumrecommendhttpresponsemessage.getRecommendConcernForums()));
                this.dhx.aX(true);
                this.dhx.a(forumrecommendhttpresponsemessage.getHotSearchInfoData());
            } catch (Exception e) {
                this.dhx.aX(false);
                BdLog.e(e.getMessage());
            }
        }
    }

    private List<com.baidu.tieba.enterForum.multiConcern.b> bh(List<RecommendForumInfo> list) {
        if (v.J(list)) {
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
                this.dhx = new com.baidu.tieba.enterForum.data.b();
                this.dhx.setTime(forumrecommendsocketresponsemessage.GetTime().intValue());
                g gVar = new g();
                gVar.be(forumrecommendsocketresponsemessage.GetLikeForum());
                this.dhx.a(gVar);
                j jVar = new j();
                jVar.bf(forumrecommendsocketresponsemessage.GetRecommendForumInfoList());
                this.dhx.a(jVar);
                this.dhx.bd(bh(forumrecommendsocketresponsemessage.getRecommendConcernForums()));
                this.dhx.aX(true);
                this.dhx.a(forumrecommendsocketresponsemessage.getHotSearchInfoData());
            } catch (Exception e) {
                this.dhx.aX(false);
                BdLog.e(e.getMessage());
            }
        }
    }

    private void aut() {
        new BdAsyncTask<Void, Void, com.baidu.tieba.enterForum.data.b>() { // from class: com.baidu.tieba.enterForum.model.EnterForumModel.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
            /* renamed from: g */
            public com.baidu.tieba.enterForum.data.b doInBackground(Void... voidArr) {
                l<byte[]> aj = com.baidu.tbadk.core.c.a.Aq().aj("tb_forum_recommend", TbadkCoreApplication.getCurrentAccountName());
                com.baidu.tieba.enterForum.data.b bVar = new com.baidu.tieba.enterForum.data.b();
                byte[] bArr = aj.get(EnterForumModel.FORUMRECOMMEND_CACHE_KEY);
                if (bArr != null) {
                    bVar.aX(true);
                    try {
                        ForumRecommendResIdl forumRecommendResIdl = (ForumRecommendResIdl) new Wire(new Class[0]).parseFrom(bArr, ForumRecommendResIdl.class);
                        if (forumRecommendResIdl.data != null) {
                            bVar.a(forumRecommendResIdl.data);
                        }
                    } catch (Exception e) {
                        bVar.aX(false);
                    }
                    if (bVar.isSuccess() && !bVar.atF()) {
                        bVar.atD().atK();
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
                    aVar.dhF = true;
                    aVar.dhG = bVar;
                } else {
                    aVar.dhF = false;
                    aVar.dhG = bVar;
                }
                EnterForumModel.this.dhy.a(aVar);
            }
        }.execute(new Void[0]);
    }

    public void bi(List<f> list) {
        if (list != null) {
            ArrayList arrayList = new ArrayList();
            for (f fVar : list) {
                if (fVar != null && fVar.getType() == 0 && !StringUtils.isNull(fVar.getName())) {
                    arrayList.add(new d.a(fVar.getName(), fVar.getLevel()));
                }
            }
            com.baidu.tbadk.util.d.W(arrayList);
        }
    }

    public List<f> a(List<f> list, String[] strArr) {
        ArrayList arrayList = new ArrayList();
        if (list == null || list.isEmpty()) {
            return arrayList;
        }
        if (strArr == null || strArr.length == 0) {
            arrayList.addAll(list);
        } else {
            for (String str : strArr) {
                for (f fVar : list) {
                    if (fVar != null && fVar.getName() != null && fVar.getName().equals(str)) {
                        arrayList.add(fVar);
                    }
                }
            }
            int size = list.size();
            for (int i = 0; i < size; i++) {
                f fVar2 = list.get(i);
                if (!arrayList.contains(fVar2)) {
                    arrayList.add(fVar2);
                }
            }
        }
        return arrayList;
    }

    public boolean i(List<f> list, List<f> list2) {
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
            f fVar = list.get(i);
            f fVar2 = list2.get(i);
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
