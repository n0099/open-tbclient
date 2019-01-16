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
    private com.baidu.tieba.enterForum.data.b dsE;
    private b dsF;
    private com.baidu.tieba.tbadkCore.d.b dsG;
    private long dsH;
    private long dsI;
    private long dsJ;
    private long dsK;

    /* loaded from: classes4.dex */
    public interface b {
        void a(a aVar);
    }

    /* loaded from: classes4.dex */
    public class a {
        public String error = "";
        public boolean dsM = false;
        public int type = -1;
        public com.baidu.tieba.enterForum.data.b dsN = null;

        public a() {
        }
    }

    public EnterForumModel(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.dsE = null;
        this.dsF = null;
        this.dsG = null;
        this.dsH = 0L;
        this.dsI = 0L;
        this.dsJ = 0L;
        this.dsK = 0L;
        setUniqueId(BdUniqueId.gen());
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public BdUniqueId getUniqueId() {
        return this.unique_id;
    }

    public long awJ() {
        return this.dsK;
    }

    public long awK() {
        return this.dsI;
    }

    public long awL() {
        return this.dsJ;
    }

    public long awM() {
        return this.dsH;
    }

    public com.baidu.tieba.enterForum.data.b awN() {
        return this.dsE;
    }

    public void c(com.baidu.tieba.enterForum.data.b bVar) {
        this.dsE = bVar;
    }

    public void a(b bVar) {
        this.dsF = bVar;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        cancelMessage();
        awO();
        return true;
    }

    private void awO() {
        if (this.dsG != null) {
            this.dsG.destory();
            this.dsG = null;
        }
    }

    public boolean gg(boolean z) {
        cancelLoadData();
        forumRecommendRequestMessage forumrecommendrequestmessage = new forumRecommendRequestMessage();
        forumrecommendrequestmessage.set_like_forum(Integer.valueOf(z ? 1 : 0));
        forumrecommendrequestmessage.set_topic(0);
        forumrecommendrequestmessage.set_recommend(1);
        this.dsH = System.currentTimeMillis();
        if (this.dsG == null) {
            this.dsG = new com.baidu.tieba.tbadkCore.d.b("forumrecommendStat");
        }
        sendMessage(forumrecommendrequestmessage);
        return true;
    }

    public boolean gh(boolean z) {
        awP();
        return true;
    }

    public void a(boolean z, int i, String str, boolean z2, int i2, long j, long j2) {
        a aVar = new a();
        boolean z3 = !z;
        if (this.dsG != null) {
            this.dsG.a(z2, z3, i, str, i2, j, j2);
            this.dsG = null;
        }
        if (z || !this.dsE.isSuccess()) {
            if (str != null && str.length() > 0) {
                setErrorString(str);
                aVar.error = str;
            }
            aVar.type = 1;
            aVar.dsM = false;
            aVar.dsN = this.dsE;
            this.dsF.a(aVar);
            return;
        }
        aVar.type = 1;
        aVar.dsM = true;
        aVar.dsN = this.dsE;
        this.dsF.a(aVar);
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
            this.dsE = null;
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
                this.dsE = new com.baidu.tieba.enterForum.data.b();
                this.dsE.setTime(forumrecommendhttpresponsemessage.GetTime().intValue());
                g gVar = new g();
                gVar.bg(forumrecommendhttpresponsemessage.GetLikeForum());
                this.dsE.a(gVar);
                j jVar = new j();
                jVar.bh(forumrecommendhttpresponsemessage.GetRecommendForumInfoList());
                this.dsE.a(jVar);
                this.dsE.bf(bj(forumrecommendhttpresponsemessage.getRecommendConcernForums()));
                this.dsE.bp(true);
                this.dsE.a(forumrecommendhttpresponsemessage.getHotSearchInfoData());
            } catch (Exception e) {
                this.dsE.bp(false);
                BdLog.e(e.getMessage());
            }
        }
    }

    private List<com.baidu.tieba.enterForum.multiConcern.b> bj(List<RecommendForumInfo> list) {
        if (v.I(list)) {
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
                this.dsE = new com.baidu.tieba.enterForum.data.b();
                this.dsE.setTime(forumrecommendsocketresponsemessage.GetTime().intValue());
                g gVar = new g();
                gVar.bg(forumrecommendsocketresponsemessage.GetLikeForum());
                this.dsE.a(gVar);
                j jVar = new j();
                jVar.bh(forumrecommendsocketresponsemessage.GetRecommendForumInfoList());
                this.dsE.a(jVar);
                this.dsE.bf(bj(forumrecommendsocketresponsemessage.getRecommendConcernForums()));
                this.dsE.bp(true);
                this.dsE.a(forumrecommendsocketresponsemessage.getHotSearchInfoData());
            } catch (Exception e) {
                this.dsE.bp(false);
                BdLog.e(e.getMessage());
            }
        }
    }

    private void awP() {
        new BdAsyncTask<Void, Void, com.baidu.tieba.enterForum.data.b>() { // from class: com.baidu.tieba.enterForum.model.EnterForumModel.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
            /* renamed from: h */
            public com.baidu.tieba.enterForum.data.b doInBackground(Void... voidArr) {
                l<byte[]> an = com.baidu.tbadk.core.c.a.BO().an("tb_forum_recommend", TbadkCoreApplication.getCurrentAccountName());
                com.baidu.tieba.enterForum.data.b bVar = new com.baidu.tieba.enterForum.data.b();
                byte[] bArr = an.get(EnterForumModel.FORUMRECOMMEND_CACHE_KEY);
                if (bArr != null) {
                    bVar.bp(true);
                    try {
                        ForumRecommendResIdl forumRecommendResIdl = (ForumRecommendResIdl) new Wire(new Class[0]).parseFrom(bArr, ForumRecommendResIdl.class);
                        if (forumRecommendResIdl.data != null) {
                            bVar.a(forumRecommendResIdl.data);
                        }
                    } catch (Exception e) {
                        bVar.bp(false);
                    }
                    if (bVar.isSuccess() && !bVar.awe()) {
                        bVar.awc().awj();
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
                    aVar.dsM = true;
                    aVar.dsN = bVar;
                } else {
                    aVar.dsM = false;
                    aVar.dsN = bVar;
                }
                EnterForumModel.this.dsF.a(aVar);
            }
        }.execute(new Void[0]);
    }

    public void bk(List<f> list) {
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
