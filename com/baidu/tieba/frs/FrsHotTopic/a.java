package com.baidu.tieba.frs.FrsHotTopic;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.cache.l;
import com.baidu.adp.lib.util.StringUtils;
import java.util.Iterator;
import java.util.Map;
/* loaded from: classes.dex */
public class a {
    private static a gnR;
    private FrsLinkHashMap<String, Long> gnS;

    private a() {
    }

    public static a bCU() {
        if (gnR == null) {
            synchronized (a.class) {
                if (gnR == null) {
                    gnR = new a();
                }
            }
        }
        return gnR;
    }

    private void A(String str, long j) {
        BdAsyncTask<Void, Void, Void> bdAsyncTask = new BdAsyncTask<Void, Void, Void>() { // from class: com.baidu.tieba.frs.FrsHotTopic.a.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
            public Void doInBackground(Void... voidArr) {
                FrsHotTopicListData frsHotTopicListData;
                l<String> ci = com.baidu.tbadk.core.c.a.aCo().ci("tb.frs_hottopic", "");
                if (ci != null) {
                    String str2 = ci.get("hot_topic_key");
                    if (!StringUtils.isNull(str2) && (frsHotTopicListData = (FrsHotTopicListData) OrmObject.objectWithJsonStr(str2, FrsHotTopicListData.class)) != null) {
                        a.this.gnS = frsHotTopicListData.mSceneMap;
                    }
                }
                return null;
            }
        };
        bdAsyncTask.setPriority(3);
        bdAsyncTask.execute(new Void[0]);
    }

    public boolean B(String str, long j) {
        boolean z;
        if (this.gnS == null) {
            this.gnS = new FrsLinkHashMap<>();
            A(str, j);
        }
        if (StringUtils.isNull(str) || this.gnS.isEmpty()) {
            return false;
        }
        Iterator<Map.Entry<String, Long>> it = this.gnS.entrySet().iterator();
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
        if (z && this.gnS.get(str).longValue() == j) {
            return false;
        }
        this.gnS.put(str, Long.valueOf(j));
        bCV();
        return true;
    }

    private void bCV() {
        BdAsyncTask<Void, Void, Void> bdAsyncTask = new BdAsyncTask<Void, Void, Void>() { // from class: com.baidu.tieba.frs.FrsHotTopic.a.2
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
            public Void doInBackground(Void... voidArr) {
                l<String> ci = com.baidu.tbadk.core.c.a.aCo().ci("tb.frs_hottopic", "");
                if (ci != null) {
                    FrsHotTopicListData frsHotTopicListData = new FrsHotTopicListData();
                    frsHotTopicListData.mSceneMap = a.this.gnS;
                    String jsonStrWithObject = OrmObject.jsonStrWithObject(frsHotTopicListData);
                    if (!StringUtils.isNull(jsonStrWithObject)) {
                        ci.setForever("hot_topic_key", jsonStrWithObject);
                    }
                }
                return null;
            }
        };
        bdAsyncTask.setPriority(3);
        bdAsyncTask.execute(new Void[0]);
    }
}
