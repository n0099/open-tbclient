package com.baidu.tieba.frs.FrsHotTopic;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.cache.l;
import com.baidu.adp.lib.util.StringUtils;
import java.util.Iterator;
import java.util.Map;
/* loaded from: classes.dex */
public class a {
    private static a dnK;
    private static FrsLinkHashMap<String, Long> dnL = new FrsLinkHashMap<>();

    private a() {
        auL();
    }

    public static a auK() {
        if (dnK == null) {
            synchronized (a.class) {
                if (dnK == null) {
                    dnK = new a();
                }
            }
        }
        return dnK;
    }

    private static void auL() {
        BdAsyncTask<Void, Void, Void> bdAsyncTask = new BdAsyncTask<Void, Void, Void>() { // from class: com.baidu.tieba.frs.FrsHotTopic.a.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
            public Void doInBackground(Void... voidArr) {
                FrsHotTopicListData frsHotTopicListData;
                l<String> Q = com.baidu.tbadk.core.c.a.xa().Q("tb.frs_hottopic", "");
                if (Q != null) {
                    String str = Q.get("hot_topic_key");
                    if (!StringUtils.isNull(str) && (frsHotTopicListData = (FrsHotTopicListData) OrmObject.objectWithJsonStr(str, FrsHotTopicListData.class)) != null) {
                        FrsLinkHashMap unused = a.dnL = frsHotTopicListData.mSceneMap;
                    }
                }
                return null;
            }
        };
        bdAsyncTask.setPriority(3);
        bdAsyncTask.execute(new Void[0]);
    }

    public boolean k(String str, long j) {
        boolean z;
        if (dnL != null && str != null) {
            Iterator<Map.Entry<String, Long>> it = dnL.entrySet().iterator();
            while (true) {
                if (!it.hasNext()) {
                    z = false;
                    break;
                }
                Map.Entry<String, Long> next = it.next();
                if (next != null && str.equals(next.getKey())) {
                    z = true;
                    break;
                }
            }
            if (!z || (z && dnL.get(str).longValue() != j)) {
                dnL.put(str, Long.valueOf(j));
                auM();
                return true;
            }
        }
        return false;
    }

    private void auM() {
        BdAsyncTask<Void, Void, Void> bdAsyncTask = new BdAsyncTask<Void, Void, Void>() { // from class: com.baidu.tieba.frs.FrsHotTopic.a.2
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
            public Void doInBackground(Void... voidArr) {
                l<String> Q = com.baidu.tbadk.core.c.a.xa().Q("tb.frs_hottopic", "");
                if (Q != null) {
                    FrsHotTopicListData frsHotTopicListData = new FrsHotTopicListData();
                    frsHotTopicListData.mSceneMap = a.dnL;
                    String jsonStrWithObject = OrmObject.jsonStrWithObject(frsHotTopicListData);
                    if (!StringUtils.isNull(jsonStrWithObject)) {
                        Q.e("hot_topic_key", jsonStrWithObject);
                    }
                }
                return null;
            }
        };
        bdAsyncTask.setPriority(3);
        bdAsyncTask.execute(new Void[0]);
    }
}
