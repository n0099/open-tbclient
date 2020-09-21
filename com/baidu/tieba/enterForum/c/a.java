package com.baidu.tieba.enterForum.c;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.cache.l;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigSocket;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.data.VisitedForumData;
import com.baidu.tbadk.util.ad;
import com.baidu.tbadk.util.ae;
import com.baidu.tieba.enterForum.data.RecentlyVisitedForumData;
import com.baidu.tieba.enterForum.home.RecentlyVisitedForumHttpResponseMessage;
import com.baidu.tieba.enterForum.home.RecentlyVisitedForumRequestMessage;
import com.baidu.tieba.enterForum.home.RecentlyVisitedForumSocketResponseMessage;
import java.util.ArrayList;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class a {
    private RecentlyVisitedForumData hBW;
    private boolean hBX;
    private InterfaceC0665a hBY;
    private CustomMessageListener hBZ;
    private com.baidu.adp.framework.listener.a hCa;
    private boolean isFromCache;
    private boolean isLoading;
    private CustomMessageListener mAccountChangeListener;

    /* renamed from: com.baidu.tieba.enterForum.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0665a {
        void b(LinkedList<VisitedForumData> linkedList, boolean z);

        void onNotify();

        void wv(int i);
    }

    public static a cis() {
        return b.hCc;
    }

    public void a(InterfaceC0665a interfaceC0665a) {
        this.hBY = interfaceC0665a;
    }

    public void cit() {
        if (!this.isLoading) {
            RecentlyVisitedForumRequestMessage recentlyVisitedForumRequestMessage = new RecentlyVisitedForumRequestMessage();
            recentlyVisitedForumRequestMessage.setForumData(this.hBW.getForumData());
            this.isLoading = MessageManager.getInstance().sendMessage(recentlyVisitedForumRequestMessage);
        }
    }

    public String ciu() {
        if (this.hBW == null || this.hBW.getForumData() == null || this.hBW.getForumData().size() < 1) {
            return "";
        }
        ArrayList<VisitedForumData> arrayList = new ArrayList(this.hBW.getForumData());
        JSONArray jSONArray = new JSONArray();
        for (VisitedForumData visitedForumData : arrayList) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("forum_id", com.baidu.adp.lib.f.b.toLong(visitedForumData.getForumId(), 0L));
                jSONObject.put("visit_time", visitedForumData.bsa());
            } catch (JSONException e) {
                e.printStackTrace();
            }
            jSONArray.put(jSONObject);
        }
        return jSONArray.toString();
    }

    public void civ() {
        if (!this.hBX) {
            ae.a(new ad<Object>() { // from class: com.baidu.tieba.enterForum.c.a.1
                @Override // com.baidu.tbadk.util.ad
                public Object doInBackground() {
                    l<String> dw = com.baidu.tbadk.core.c.a.bhV().dw("tb.recently_visited_forum", TbadkCoreApplication.getCurrentAccount() == null ? "local" : TbadkCoreApplication.getCurrentAccount());
                    if (dw != null && a.this.hBW != null) {
                        dw.setForever("recently_visited_forum", OrmObject.jsonStrWithObject(a.this.hBW));
                    }
                    return null;
                }
            }, null);
        }
    }

    public void c(VisitedForumData visitedForumData) {
        e(visitedForumData);
    }

    public void ciw() {
        if (this.hBY != null) {
            this.hBY.b(this.hBW.getForumData(), this.isFromCache);
        }
    }

    public void onNotify() {
        if (this.hBY != null) {
            this.hBY.onNotify();
        }
    }

    private a() {
        this.hBX = false;
        this.isLoading = false;
        this.hBZ = new CustomMessageListener(CmdConfigCustom.CMD_ENTER_FORUM) { // from class: com.baidu.tieba.enterForum.c.a.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
                    a.this.d((VisitedForumData) customResponsedMessage.getData());
                }
            }
        };
        this.mAccountChangeListener = new CustomMessageListener(CmdConfigCustom.METHOD_ACCOUNT_CHANGE) { // from class: com.baidu.tieba.enterForum.c.a.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null) {
                    a.this.ciy();
                }
            }
        };
        this.hCa = new com.baidu.adp.framework.listener.a(1003394, CmdConfigSocket.CMD_GET_HISTORY_FORUM) { // from class: com.baidu.tieba.enterForum.c.a.5
            @Override // com.baidu.adp.framework.listener.a
            public void onMessage(ResponsedMessage<?> responsedMessage) {
                a.this.isLoading = false;
                if (responsedMessage != null) {
                    if (responsedMessage instanceof RecentlyVisitedForumHttpResponseMessage) {
                        a.this.a((RecentlyVisitedForumHttpResponseMessage) responsedMessage);
                    } else if (responsedMessage instanceof RecentlyVisitedForumSocketResponseMessage) {
                        a.this.a((RecentlyVisitedForumSocketResponseMessage) responsedMessage);
                    }
                }
            }
        };
        this.hBW = new RecentlyVisitedForumData();
        registerListener();
        ciy();
    }

    private void registerListener() {
        MessageManager.getInstance().registerListener(this.hCa);
        MessageManager.getInstance().registerListener(this.hBZ);
        MessageManager.getInstance().registerListener(this.mAccountChangeListener);
    }

    /* loaded from: classes.dex */
    private static class b {
        private static a hCc = new a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(RecentlyVisitedForumHttpResponseMessage recentlyVisitedForumHttpResponseMessage) {
        if (recentlyVisitedForumHttpResponseMessage != null && recentlyVisitedForumHttpResponseMessage.getForumData() != null) {
            a(recentlyVisitedForumHttpResponseMessage.getForumData(), false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(RecentlyVisitedForumSocketResponseMessage recentlyVisitedForumSocketResponseMessage) {
        if (recentlyVisitedForumSocketResponseMessage != null && recentlyVisitedForumSocketResponseMessage.getForumData() != null) {
            a(recentlyVisitedForumSocketResponseMessage.getForumData(), false);
        }
    }

    public RecentlyVisitedForumData cix() {
        return this.hBW;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(VisitedForumData visitedForumData) {
        if (visitedForumData != null) {
            this.hBW.a(visitedForumData);
            this.hBW.wu(20);
            ciw();
            civ();
        }
    }

    private void e(VisitedForumData visitedForumData) {
        int b2;
        if (visitedForumData != null && (b2 = this.hBW.b(visitedForumData)) >= 0) {
            if (this.hBY != null) {
                this.hBY.wv(b2);
            }
            f(visitedForumData);
        }
    }

    private void f(VisitedForumData visitedForumData) {
        if (TbadkCoreApplication.isLogin()) {
            HttpMessage httpMessage = new HttpMessage(1003395);
            httpMessage.addParam("forum_id", com.baidu.adp.lib.f.b.toLong(visitedForumData.getForumId(), 0L));
            MessageManager.getInstance().sendMessage(httpMessage);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(LinkedList<VisitedForumData> linkedList, boolean z) {
        if (linkedList != null) {
            this.hBW.setForumData(linkedList);
            this.hBW.wu(20);
            this.isFromCache = z;
            ciw();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ciy() {
        this.hBX = true;
        BdAsyncTask<Void, Void, RecentlyVisitedForumData> bdAsyncTask = new BdAsyncTask<Void, Void, RecentlyVisitedForumData>() { // from class: com.baidu.tieba.enterForum.c.a.2
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
            /* renamed from: g */
            public RecentlyVisitedForumData doInBackground(Void... voidArr) {
                RecentlyVisitedForumData recentlyVisitedForumData;
                l<String> dw = com.baidu.tbadk.core.c.a.bhV().dw("tb.recently_visited_forum", "local");
                RecentlyVisitedForumData recentlyVisitedForumData2 = (dw == null || at.isEmpty(dw.get("recently_visited_forum"))) ? null : (RecentlyVisitedForumData) OrmObject.objectWithJsonStr(dw.get("recently_visited_forum"), RecentlyVisitedForumData.class);
                if (TbadkCoreApplication.getCurrentAccount() != null) {
                    if (dw != null) {
                        dw.setForever("recently_visited_forum", "");
                    }
                    l<String> dw2 = com.baidu.tbadk.core.c.a.bhV().dw("tb.recently_visited_forum", TbadkCoreApplication.getCurrentAccount());
                    if (dw2 != null && !StringUtils.isNull(dw2.get("recently_visited_forum"))) {
                        try {
                            recentlyVisitedForumData = (RecentlyVisitedForumData) OrmObject.objectWithJsonStr(dw2.get("recently_visited_forum"), RecentlyVisitedForumData.class);
                        } catch (Exception e) {
                            e.printStackTrace();
                            recentlyVisitedForumData = null;
                        }
                        if (recentlyVisitedForumData2 != null) {
                            recentlyVisitedForumData2.a(recentlyVisitedForumData);
                            dw2.setForever("recently_visited_forum", OrmObject.jsonStrWithObject(recentlyVisitedForumData2));
                            return recentlyVisitedForumData2;
                        }
                        return recentlyVisitedForumData;
                    }
                    return recentlyVisitedForumData2;
                }
                return recentlyVisitedForumData2;
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
            /* renamed from: b */
            public void onPostExecute(RecentlyVisitedForumData recentlyVisitedForumData) {
                a.this.hBX = false;
                if (recentlyVisitedForumData != null) {
                    a.this.a(recentlyVisitedForumData.getForumData(), true);
                }
            }
        };
        bdAsyncTask.setPriority(3);
        bdAsyncTask.execute(new Void[0]);
    }
}
