package com.baidu.tieba.frs.FrsHotTopic;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.cache.l;
import com.baidu.adp.lib.util.StringUtils;
import java.util.Iterator;
import java.util.Map;
/* loaded from: classes.dex */
public class a {
    private static a jhA;
    private FrsLinkHashMap<String, Long> jhB;

    private a() {
    }

    public static a cFS() {
        if (jhA == null) {
            synchronized (a.class) {
                if (jhA == null) {
                    jhA = new a();
                }
            }
        }
        return jhA;
    }

    private void E(String str, long j) {
        BdAsyncTask<Void, Void, Void> bdAsyncTask = new BdAsyncTask<Void, Void, Void>() { // from class: com.baidu.tieba.frs.FrsHotTopic.a.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
            public Void doInBackground(Void... voidArr) {
                FrsHotTopicListData frsHotTopicListData;
                l<String> dM = com.baidu.tbadk.core.c.a.btS().dM("tb.frs_hottopic", "");
                if (dM != null) {
                    String str2 = dM.get("hot_topic_key");
                    if (!StringUtils.isNull(str2) && (frsHotTopicListData = (FrsHotTopicListData) OrmObject.objectWithJsonStr(str2, FrsHotTopicListData.class)) != null) {
                        a.this.jhB = frsHotTopicListData.mSceneMap;
                    }
                }
                return null;
            }
        };
        bdAsyncTask.setPriority(3);
        bdAsyncTask.execute(new Void[0]);
    }

    public boolean F(String str, long j) {
        boolean z;
        if (this.jhB == null) {
            this.jhB = new FrsLinkHashMap<>();
            E(str, j);
        }
        if (StringUtils.isNull(str) || this.jhB.isEmpty()) {
            return false;
        }
        Iterator<Map.Entry<String, Long>> it = this.jhB.entrySet().iterator();
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
        if (z && this.jhB.get(str).longValue() == j) {
            return false;
        }
        this.jhB.put(str, Long.valueOf(j));
        cFT();
        return true;
    }

    private void cFT() {
        BdAsyncTask<Void, Void, Void> bdAsyncTask = new BdAsyncTask<Void, Void, Void>() { // from class: com.baidu.tieba.frs.FrsHotTopic.a.2
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
            public Void doInBackground(Void... voidArr) {
                l<String> dM = com.baidu.tbadk.core.c.a.btS().dM("tb.frs_hottopic", "");
                if (dM != null) {
                    FrsHotTopicListData frsHotTopicListData = new FrsHotTopicListData();
                    frsHotTopicListData.mSceneMap = a.this.jhB;
                    String jsonStrWithObject = OrmObject.jsonStrWithObject(frsHotTopicListData);
                    if (!StringUtils.isNull(jsonStrWithObject)) {
                        dM.setForever("hot_topic_key", jsonStrWithObject);
                    }
                }
                return null;
            }
        };
        bdAsyncTask.setPriority(3);
        bdAsyncTask.execute(new Void[0]);
    }
}
