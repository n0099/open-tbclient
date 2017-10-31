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
import com.baidu.tbadk.util.c;
import com.baidu.tieba.d;
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
/* loaded from: classes.dex */
public class EnterForumModel extends BdBaseModel {
    public static final String FORUMRECOMMEND_CACHE_KEY = "forumRecommend_cache_key";
    public static final int MAX_LIKE_SHOWED = 500;
    public static final int TYPE_DB = 0;
    public static final int TYPE_DEFAULT = -1;
    public static final int TYPE_NET = 1;
    private com.baidu.tieba.enterForum.data.b ckG;
    private b ckH;
    private com.baidu.tieba.tbadkCore.d.b ckI;
    private long ckJ;
    private long ckK;
    private long ckL;
    private long ckM;

    /* loaded from: classes.dex */
    public interface b {
        void a(a aVar);
    }

    /* loaded from: classes.dex */
    public class a {
        public String error = "";
        public boolean ckO = false;
        public int type = -1;
        public com.baidu.tieba.enterForum.data.b ckP = null;

        public a() {
        }
    }

    public EnterForumModel(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.ckG = null;
        this.ckH = null;
        this.ckI = null;
        this.ckJ = 0L;
        this.ckK = 0L;
        this.ckL = 0L;
        this.ckM = 0L;
        setUniqueId(BdUniqueId.gen());
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public BdUniqueId getUniqueId() {
        return this.unique_id;
    }

    public long afi() {
        return this.ckM;
    }

    public long afj() {
        return this.ckK;
    }

    public long afk() {
        return this.ckL;
    }

    public long afl() {
        return this.ckJ;
    }

    public com.baidu.tieba.enterForum.data.b afm() {
        return this.ckG;
    }

    public void c(com.baidu.tieba.enterForum.data.b bVar) {
        this.ckG = bVar;
    }

    public void a(b bVar) {
        this.ckH = bVar;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        cancelMessage();
        afn();
        return true;
    }

    private void afn() {
        if (this.ckI != null) {
            this.ckI.destory();
            this.ckI = null;
        }
    }

    public boolean ef(boolean z) {
        cancelLoadData();
        forumRecommendRequestMessage forumrecommendrequestmessage = new forumRecommendRequestMessage();
        forumrecommendrequestmessage.set_like_forum(Integer.valueOf(z ? 1 : 0));
        forumrecommendrequestmessage.set_topic(0);
        forumrecommendrequestmessage.set_recommend(1);
        this.ckJ = System.currentTimeMillis();
        if (this.ckI == null) {
            this.ckI = new com.baidu.tieba.tbadkCore.d.b("forumrecommendStat");
        }
        sendMessage(forumrecommendrequestmessage);
        return true;
    }

    public boolean eg(boolean z) {
        afo();
        return true;
    }

    public void a(boolean z, int i, String str, boolean z2, int i2, long j, long j2) {
        a aVar = new a();
        boolean z3 = !z;
        if (this.ckI != null) {
            this.ckI.a(z2, z3, i, str, i2, j, j2);
            this.ckI = null;
        }
        if (z || !this.ckG.isSuccess()) {
            if (str != null && str.length() > 0) {
                setErrorString(str);
                aVar.error = str;
            }
            aVar.type = 1;
            aVar.ckO = false;
            aVar.ckP = this.ckG;
            this.ckH.a(aVar);
            return;
        }
        aVar.type = 1;
        aVar.ckO = true;
        aVar.ckP = this.ckG;
        this.ckH.a(aVar);
    }

    public void a(forumRecommendSocketResponseMessage forumrecommendsocketresponsemessage) {
        String errorString;
        int downSize = forumrecommendsocketresponsemessage.getDownSize();
        long costTime = forumrecommendsocketresponsemessage.getCostTime();
        if (StringUtils.isNull(forumrecommendsocketresponsemessage.getErrorString())) {
            errorString = TbadkCoreApplication.getInst().getApp().getResources().getString(d.j.neterror);
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
            errorString = TbadkCoreApplication.getInst().getApp().getResources().getString(d.j.neterror);
        } else {
            errorString = forumrecommendhttpresponsemessage.getErrorString();
        }
        a(forumrecommendhttpresponsemessage, forumrecommendhttpresponsemessage.hasError(), forumrecommendhttpresponsemessage.getError(), errorString, true, downSize, costTime, 0L);
    }

    public void a(ResponsedMessage<?> responsedMessage, boolean z, int i, String str, boolean z2, int i2, long j, long j2) {
        if (z) {
            this.ckG = null;
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
                this.ckG = new com.baidu.tieba.enterForum.data.b();
                this.ckG.setTime(forumrecommendhttpresponsemessage.GetTime().intValue());
                g gVar = new g();
                gVar.ap(forumrecommendhttpresponsemessage.GetLikeForum());
                this.ckG.a(gVar);
                j jVar = new j();
                jVar.aq(forumrecommendhttpresponsemessage.GetRecommendForumInfoList());
                this.ckG.a(jVar);
                this.ckG.ao(as(forumrecommendhttpresponsemessage.getRecommendConcernForums()));
                this.ckG.av(true);
                this.ckG.a(forumrecommendhttpresponsemessage.getHotSearchInfoData());
            } catch (Exception e) {
                this.ckG.av(false);
                BdLog.e(e.getMessage());
            }
        }
    }

    private List<com.baidu.tieba.enterForum.multiConcern.b> as(List<RecommendForumInfo> list) {
        if (v.v(list)) {
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
                this.ckG = new com.baidu.tieba.enterForum.data.b();
                this.ckG.setTime(forumrecommendsocketresponsemessage.GetTime().intValue());
                g gVar = new g();
                gVar.ap(forumrecommendsocketresponsemessage.GetLikeForum());
                this.ckG.a(gVar);
                j jVar = new j();
                jVar.aq(forumrecommendsocketresponsemessage.GetRecommendForumInfoList());
                this.ckG.a(jVar);
                this.ckG.ao(as(forumrecommendsocketresponsemessage.getRecommendConcernForums()));
                this.ckG.av(true);
                this.ckG.a(forumrecommendsocketresponsemessage.getHotSearchInfoData());
            } catch (Exception e) {
                this.ckG.av(false);
                BdLog.e(e.getMessage());
            }
        }
    }

    private void afo() {
        new BdAsyncTask<Void, Void, com.baidu.tieba.enterForum.data.b>() { // from class: com.baidu.tieba.enterForum.model.EnterForumModel.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
            /* renamed from: e */
            public com.baidu.tieba.enterForum.data.b doInBackground(Void... voidArr) {
                l<byte[]> M = com.baidu.tbadk.core.c.a.td().M("tb_forum_recommend", TbadkCoreApplication.getCurrentAccountName());
                com.baidu.tieba.enterForum.data.b bVar = new com.baidu.tieba.enterForum.data.b();
                byte[] bArr = M.get(EnterForumModel.FORUMRECOMMEND_CACHE_KEY);
                if (bArr != null) {
                    bVar.av(true);
                    try {
                        ForumRecommendResIdl forumRecommendResIdl = (ForumRecommendResIdl) new Wire(new Class[0]).parseFrom(bArr, ForumRecommendResIdl.class);
                        if (forumRecommendResIdl.data != null) {
                            bVar.a(forumRecommendResIdl.data);
                        }
                    } catch (Exception e) {
                        bVar.av(false);
                    }
                    if (bVar.isSuccess() && !bVar.aeJ()) {
                        bVar.aeH().aeN();
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
                    aVar.ckO = true;
                    aVar.ckP = bVar;
                } else {
                    aVar.ckO = false;
                    aVar.ckP = bVar;
                }
                EnterForumModel.this.ckH.a(aVar);
            }
        }.execute(new Void[0]);
    }

    public void at(List<f> list) {
        if (list != null) {
            ArrayList arrayList = new ArrayList();
            for (f fVar : list) {
                if (fVar != null && fVar.getType() == 0 && !StringUtils.isNull(fVar.getName())) {
                    arrayList.add(new c.a(fVar.getName(), fVar.getLevel()));
                }
            }
            com.baidu.tbadk.util.c.H(arrayList);
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

    public boolean h(List<f> list, List<f> list2) {
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
