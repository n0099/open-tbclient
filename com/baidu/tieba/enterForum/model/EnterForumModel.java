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
    private com.baidu.tieba.enterForum.b.b cdl;
    private b cdm;
    private com.baidu.tieba.tbadkCore.d.b cdn;
    private long cdo;
    private long cdp;
    private long cdq;
    private long cdr;

    /* loaded from: classes.dex */
    public interface b {
        void a(a aVar);
    }

    /* loaded from: classes.dex */
    public class a {
        public String error = "";
        public boolean cdt = false;
        public int type = -1;
        public com.baidu.tieba.enterForum.b.b cdu = null;

        public a() {
        }
    }

    public EnterForumModel(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.cdl = null;
        this.cdm = null;
        this.cdn = null;
        this.cdo = 0L;
        this.cdp = 0L;
        this.cdq = 0L;
        this.cdr = 0L;
        setUniqueId(BdUniqueId.gen());
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public BdUniqueId getUniqueId() {
        return this.unique_id;
    }

    public long ada() {
        return this.cdr;
    }

    public long adb() {
        return this.cdp;
    }

    public long adc() {
        return this.cdq;
    }

    public long add() {
        return this.cdo;
    }

    public com.baidu.tieba.enterForum.b.b ade() {
        return this.cdl;
    }

    public void c(com.baidu.tieba.enterForum.b.b bVar) {
        this.cdl = bVar;
    }

    public void a(b bVar) {
        this.cdm = bVar;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        cancelMessage();
        adf();
        return true;
    }

    private void adf() {
        if (this.cdn != null) {
            this.cdn.destory();
            this.cdn = null;
        }
    }

    public boolean eh(boolean z) {
        cancelLoadData();
        forumRecommendRequestMessage forumrecommendrequestmessage = new forumRecommendRequestMessage();
        forumrecommendrequestmessage.set_like_forum(Integer.valueOf(z ? 1 : 0));
        forumrecommendrequestmessage.set_topic(0);
        forumrecommendrequestmessage.set_recommend(1);
        this.cdo = System.currentTimeMillis();
        if (this.cdn == null) {
            this.cdn = new com.baidu.tieba.tbadkCore.d.b("forumrecommendStat");
        }
        sendMessage(forumrecommendrequestmessage);
        return true;
    }

    public boolean ei(boolean z) {
        adg();
        return true;
    }

    public void a(boolean z, int i, String str, boolean z2, int i2, long j, long j2) {
        a aVar = new a();
        boolean z3 = !z;
        if (this.cdn != null) {
            this.cdn.a(z2, z3, i, str, i2, j, j2);
            this.cdn = null;
        }
        this.cdl.ec(false);
        if (z || !this.cdl.isSuccess()) {
            if (str != null && str.length() > 0) {
                setErrorString(str);
                aVar.error = str;
            }
            aVar.type = 1;
            aVar.cdt = false;
            aVar.cdu = this.cdl;
            this.cdm.a(aVar);
            return;
        }
        aVar.type = 1;
        aVar.cdt = true;
        aVar.cdu = this.cdl;
        this.cdm.a(aVar);
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
            this.cdl = null;
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
                this.cdl = new com.baidu.tieba.enterForum.b.b();
                this.cdl.setTime(forumrecommendhttpresponsemessage.GetTime().intValue());
                this.cdl.ix(forumrecommendhttpresponsemessage.GetMsignValid().intValue());
                this.cdl.jK(forumrecommendhttpresponsemessage.GetMsignText());
                this.cdl.iy(forumrecommendhttpresponsemessage.GetMsignLevel().intValue());
                this.cdl.setIsMem(forumrecommendhttpresponsemessage.GetIsMem().intValue());
                this.cdl.iw(forumrecommendhttpresponsemessage.GetIsLogin().intValue());
                this.cdl.ec(false);
                h hVar = new h();
                hVar.setLevel(forumrecommendhttpresponsemessage.GetMsignLevel().intValue());
                hVar.an(forumrecommendhttpresponsemessage.GetLikeForum());
                this.cdl.a(hVar);
                k kVar = new k();
                kVar.ao(forumrecommendhttpresponsemessage.GetRecommendForumInfoList());
                this.cdl.a(kVar);
                this.cdl.am(aq(forumrecommendhttpresponsemessage.getRecommendConcernForums()));
                this.cdl.ax(true);
                this.cdl.a(forumrecommendhttpresponsemessage.getHotSearchInfoData());
            } catch (Exception e) {
                this.cdl.ax(false);
                BdLog.e(e.getMessage());
            }
        }
    }

    private List<com.baidu.tieba.enterForum.multiConcern.b> aq(List<RecommendForumInfo> list) {
        if (v.u(list)) {
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
                this.cdl = new com.baidu.tieba.enterForum.b.b();
                this.cdl.setTime(forumrecommendsocketresponsemessage.GetTime().intValue());
                this.cdl.ix(forumrecommendsocketresponsemessage.GetMsignValid().intValue());
                this.cdl.jK(forumrecommendsocketresponsemessage.GetMsignText());
                this.cdl.iy(forumrecommendsocketresponsemessage.GetMsignLevel().intValue());
                this.cdl.setIsMem(forumrecommendsocketresponsemessage.GetIsMem().intValue());
                this.cdl.iw(forumrecommendsocketresponsemessage.GetIsLogin().intValue());
                this.cdl.ec(false);
                h hVar = new h();
                hVar.setLevel(forumrecommendsocketresponsemessage.GetMsignLevel().intValue());
                hVar.an(forumrecommendsocketresponsemessage.GetLikeForum());
                this.cdl.a(hVar);
                k kVar = new k();
                kVar.ao(forumrecommendsocketresponsemessage.GetRecommendForumInfoList());
                this.cdl.a(kVar);
                this.cdl.am(aq(forumrecommendsocketresponsemessage.getRecommendConcernForums()));
                this.cdl.ax(true);
                this.cdl.a(forumrecommendsocketresponsemessage.getHotSearchInfoData());
            } catch (Exception e) {
                this.cdl.ax(false);
                BdLog.e(e.getMessage());
            }
        }
    }

    private void adg() {
        new BdAsyncTask<Void, Void, com.baidu.tieba.enterForum.b.b>() { // from class: com.baidu.tieba.enterForum.model.EnterForumModel.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
            /* renamed from: e */
            public com.baidu.tieba.enterForum.b.b doInBackground(Void... voidArr) {
                l<byte[]> M = com.baidu.tbadk.core.c.a.sX().M("tb_forum_recommend", TbadkCoreApplication.getCurrentAccountName());
                com.baidu.tieba.enterForum.b.b bVar = new com.baidu.tieba.enterForum.b.b();
                byte[] bArr = M.get(EnterForumModel.FORUMRECOMMEND_CACHE_KEY);
                if (bArr != null) {
                    bVar.ax(true);
                    try {
                        ForumRecommendResIdl forumRecommendResIdl = (ForumRecommendResIdl) new Wire(new Class[0]).parseFrom(bArr, ForumRecommendResIdl.class);
                        if (forumRecommendResIdl.data != null) {
                            bVar.a(forumRecommendResIdl.data);
                            bVar.ec(true);
                        }
                    } catch (Exception e) {
                        bVar.ax(false);
                    }
                    if (bVar.isSuccess() && !bVar.acA()) {
                        bVar.acy().acF();
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
                    aVar.cdt = true;
                    aVar.cdu = bVar;
                } else {
                    aVar.cdt = false;
                    aVar.cdu = bVar;
                }
                EnterForumModel.this.cdm.a(aVar);
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
            com.baidu.tbadk.util.c.G(arrayList);
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
