package com.baidu.tieba.frs.FrsHotTopic;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.cache.l;
import com.baidu.adp.lib.util.StringUtils;
import java.util.Iterator;
import java.util.Map;
/* loaded from: classes.dex */
public class a {
    private static a hHQ;
    private FrsLinkHashMap<String, Long> hHR;

    private a() {
    }

    public static a ccn() {
        if (hHQ == null) {
            synchronized (a.class) {
                if (hHQ == null) {
                    hHQ = new a();
                }
            }
        }
        return hHQ;
    }

    private void z(String str, long j) {
        BdAsyncTask<Void, Void, Void> bdAsyncTask = new BdAsyncTask<Void, Void, Void>() { // from class: com.baidu.tieba.frs.FrsHotTopic.a.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
            public Void doInBackground(Void... voidArr) {
                FrsHotTopicListData frsHotTopicListData;
                l<String> dg = com.baidu.tbadk.core.c.a.aYG().dg("tb.frs_hottopic", "");
                if (dg != null) {
                    String str2 = dg.get("hot_topic_key");
                    if (!StringUtils.isNull(str2) && (frsHotTopicListData = (FrsHotTopicListData) OrmObject.objectWithJsonStr(str2, FrsHotTopicListData.class)) != null) {
                        a.this.hHR = frsHotTopicListData.mSceneMap;
                    }
                }
                return null;
            }
        };
        bdAsyncTask.setPriority(3);
        bdAsyncTask.execute(new Void[0]);
    }

    public boolean A(String str, long j) {
        boolean z;
        if (this.hHR == null) {
            this.hHR = new FrsLinkHashMap<>();
            z(str, j);
        }
        if (StringUtils.isNull(str) || this.hHR.isEmpty()) {
            return false;
        }
        Iterator<Map.Entry<String, Long>> it = this.hHR.entrySet().iterator();
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
        if (z && this.hHR.get(str).longValue() == j) {
            return false;
        }
        this.hHR.put(str, Long.valueOf(j));
        cco();
        return true;
    }

    private void cco() {
        BdAsyncTask<Void, Void, Void> bdAsyncTask = new BdAsyncTask<Void, Void, Void>() { // from class: com.baidu.tieba.frs.FrsHotTopic.a.2
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
            public Void doInBackground(Void... voidArr) {
                l<String> dg = com.baidu.tbadk.core.c.a.aYG().dg("tb.frs_hottopic", "");
                if (dg != null) {
                    FrsHotTopicListData frsHotTopicListData = new FrsHotTopicListData();
                    frsHotTopicListData.mSceneMap = a.this.hHR;
                    String jsonStrWithObject = OrmObject.jsonStrWithObject(frsHotTopicListData);
                    if (!StringUtils.isNull(jsonStrWithObject)) {
                        dg.setForever("hot_topic_key", jsonStrWithObject);
                    }
                }
                return null;
            }
        };
        bdAsyncTask.setPriority(3);
        bdAsyncTask.execute(new Void[0]);
    }
}
