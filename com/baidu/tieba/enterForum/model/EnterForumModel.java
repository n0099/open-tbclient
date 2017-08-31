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
    private com.baidu.tieba.enterForum.b.b ccE;
    private b ccF;
    private com.baidu.tieba.tbadkCore.d.b ccG;
    private long ccH;
    private long ccI;
    private long ccJ;
    private long ccK;

    /* loaded from: classes.dex */
    public interface b {
        void a(a aVar);
    }

    /* loaded from: classes.dex */
    public class a {
        public String error = "";
        public boolean ccM = false;
        public int type = -1;
        public com.baidu.tieba.enterForum.b.b ccN = null;

        public a() {
        }
    }

    public EnterForumModel(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.ccE = null;
        this.ccF = null;
        this.ccG = null;
        this.ccH = 0L;
        this.ccI = 0L;
        this.ccJ = 0L;
        this.ccK = 0L;
        setUniqueId(BdUniqueId.gen());
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public BdUniqueId getUniqueId() {
        return this.unique_id;
    }

    public long adg() {
        return this.ccK;
    }

    public long adh() {
        return this.ccI;
    }

    public long adi() {
        return this.ccJ;
    }

    public long adj() {
        return this.ccH;
    }

    public com.baidu.tieba.enterForum.b.b adk() {
        return this.ccE;
    }

    public void c(com.baidu.tieba.enterForum.b.b bVar) {
        this.ccE = bVar;
    }

    public void a(b bVar) {
        this.ccF = bVar;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        cancelMessage();
        adl();
        return true;
    }

    private void adl() {
        if (this.ccG != null) {
            this.ccG.destory();
            this.ccG = null;
        }
    }

    public boolean eo(boolean z) {
        cancelLoadData();
        forumRecommendRequestMessage forumrecommendrequestmessage = new forumRecommendRequestMessage();
        forumrecommendrequestmessage.set_like_forum(Integer.valueOf(z ? 1 : 0));
        forumrecommendrequestmessage.set_topic(0);
        forumrecommendrequestmessage.set_recommend(1);
        this.ccH = System.currentTimeMillis();
        if (this.ccG == null) {
            this.ccG = new com.baidu.tieba.tbadkCore.d.b("forumrecommendStat");
        }
        sendMessage(forumrecommendrequestmessage);
        return true;
    }

    public boolean ep(boolean z) {
        adm();
        return true;
    }

    public void a(boolean z, int i, String str, boolean z2, int i2, long j, long j2) {
        a aVar = new a();
        boolean z3 = !z;
        if (this.ccG != null) {
            this.ccG.a(z2, z3, i, str, i2, j, j2);
            this.ccG = null;
        }
        this.ccE.ej(false);
        if (z || !this.ccE.isSuccess()) {
            if (str != null && str.length() > 0) {
                setErrorString(str);
                aVar.error = str;
            }
            aVar.type = 1;
            aVar.ccM = false;
            aVar.ccN = this.ccE;
            this.ccF.a(aVar);
            return;
        }
        aVar.type = 1;
        aVar.ccM = true;
        aVar.ccN = this.ccE;
        this.ccF.a(aVar);
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
            this.ccE = null;
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
                this.ccE = new com.baidu.tieba.enterForum.b.b();
                this.ccE.setTime(forumrecommendhttpresponsemessage.GetTime().intValue());
                this.ccE.io(forumrecommendhttpresponsemessage.GetMsignValid().intValue());
                this.ccE.jP(forumrecommendhttpresponsemessage.GetMsignText());
                this.ccE.ip(forumrecommendhttpresponsemessage.GetMsignLevel().intValue());
                this.ccE.setIsMem(forumrecommendhttpresponsemessage.GetIsMem().intValue());
                this.ccE.in(forumrecommendhttpresponsemessage.GetIsLogin().intValue());
                this.ccE.ej(false);
                h hVar = new h();
                hVar.setLevel(forumrecommendhttpresponsemessage.GetMsignLevel().intValue());
                hVar.ao(forumrecommendhttpresponsemessage.GetLikeForum());
                this.ccE.a(hVar);
                k kVar = new k();
                kVar.ap(forumrecommendhttpresponsemessage.GetRecommendForumInfoList());
                this.ccE.a(kVar);
                this.ccE.an(ar(forumrecommendhttpresponsemessage.getRecommendConcernForums()));
                this.ccE.ay(true);
                this.ccE.a(forumrecommendhttpresponsemessage.getHotSearchInfoData());
            } catch (Exception e) {
                this.ccE.ay(false);
                BdLog.e(e.getMessage());
            }
        }
    }

    private List<com.baidu.tieba.enterForum.multiConcern.b> ar(List<RecommendForumInfo> list) {
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
                this.ccE = new com.baidu.tieba.enterForum.b.b();
                this.ccE.setTime(forumrecommendsocketresponsemessage.GetTime().intValue());
                this.ccE.io(forumrecommendsocketresponsemessage.GetMsignValid().intValue());
                this.ccE.jP(forumrecommendsocketresponsemessage.GetMsignText());
                this.ccE.ip(forumrecommendsocketresponsemessage.GetMsignLevel().intValue());
                this.ccE.setIsMem(forumrecommendsocketresponsemessage.GetIsMem().intValue());
                this.ccE.in(forumrecommendsocketresponsemessage.GetIsLogin().intValue());
                this.ccE.ej(false);
                h hVar = new h();
                hVar.setLevel(forumrecommendsocketresponsemessage.GetMsignLevel().intValue());
                hVar.ao(forumrecommendsocketresponsemessage.GetLikeForum());
                this.ccE.a(hVar);
                k kVar = new k();
                kVar.ap(forumrecommendsocketresponsemessage.GetRecommendForumInfoList());
                this.ccE.a(kVar);
                this.ccE.an(ar(forumrecommendsocketresponsemessage.getRecommendConcernForums()));
                this.ccE.ay(true);
                this.ccE.a(forumrecommendsocketresponsemessage.getHotSearchInfoData());
            } catch (Exception e) {
                this.ccE.ay(false);
                BdLog.e(e.getMessage());
            }
        }
    }

    private void adm() {
        new BdAsyncTask<Void, Void, com.baidu.tieba.enterForum.b.b>() { // from class: com.baidu.tieba.enterForum.model.EnterForumModel.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
            /* renamed from: e */
            public com.baidu.tieba.enterForum.b.b doInBackground(Void... voidArr) {
                l<byte[]> N = com.baidu.tbadk.core.c.a.tk().N("tb_forum_recommend", TbadkCoreApplication.getCurrentAccountName());
                com.baidu.tieba.enterForum.b.b bVar = new com.baidu.tieba.enterForum.b.b();
                byte[] bArr = N.get(EnterForumModel.FORUMRECOMMEND_CACHE_KEY);
                if (bArr != null) {
                    bVar.ay(true);
                    try {
                        ForumRecommendResIdl forumRecommendResIdl = (ForumRecommendResIdl) new Wire(new Class[0]).parseFrom(bArr, ForumRecommendResIdl.class);
                        if (forumRecommendResIdl.data != null) {
                            bVar.a(forumRecommendResIdl.data);
                            bVar.ej(true);
                        }
                    } catch (Exception e) {
                        bVar.ay(false);
                    }
                    if (bVar.isSuccess() && !bVar.acG()) {
                        bVar.acE().acL();
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
                    aVar.ccM = true;
                    aVar.ccN = bVar;
                } else {
                    aVar.ccM = false;
                    aVar.ccN = bVar;
                }
                EnterForumModel.this.ccF.a(aVar);
            }
        }.execute(new Void[0]);
    }

    public void as(List<g> list) {
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
