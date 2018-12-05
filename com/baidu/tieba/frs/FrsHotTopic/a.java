package com.baidu.tieba.frs.FrsHotTopic;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.cache.l;
import com.baidu.adp.lib.util.StringUtils;
import java.util.Iterator;
import java.util.Map;
/* loaded from: classes.dex */
public class a {
    private static FrsLinkHashMap<String, Long> dJA = new FrsLinkHashMap<>();
    private static a dJz;

    private a() {
        aBj();
    }

    public static a aBi() {
        if (dJz == null) {
            synchronized (a.class) {
                if (dJz == null) {
                    dJz = new a();
                }
            }
        }
        return dJz;
    }

    private static void aBj() {
        BdAsyncTask<Void, Void, Void> bdAsyncTask = new BdAsyncTask<Void, Void, Void>() { // from class: com.baidu.tieba.frs.FrsHotTopic.a.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
            public Void doInBackground(Void... voidArr) {
                FrsHotTopicListData frsHotTopicListData;
                l<String> an = com.baidu.tbadk.core.c.a.BB().an("tb.frs_hottopic", "");
                if (an != null) {
                    String str = an.get("hot_topic_key");
                    if (!StringUtils.isNull(str) && (frsHotTopicListData = (FrsHotTopicListData) OrmObject.objectWithJsonStr(str, FrsHotTopicListData.class)) != null) {
                        FrsLinkHashMap unused = a.dJA = frsHotTopicListData.mSceneMap;
                    }
                }
                return null;
            }
        };
        bdAsyncTask.setPriority(3);
        bdAsyncTask.execute(new Void[0]);
    }

    public boolean n(String str, long j) {
        boolean z;
        if (dJA != null && str != null) {
            Iterator<Map.Entry<String, Long>> it = dJA.entrySet().iterator();
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
            if (!z || (z && dJA.get(str).longValue() != j)) {
                dJA.put(str, Long.valueOf(j));
                aBk();
                return true;
            }
        }
        return false;
    }

    private void aBk() {
        BdAsyncTask<Void, Void, Void> bdAsyncTask = new BdAsyncTask<Void, Void, Void>() { // from class: com.baidu.tieba.frs.FrsHotTopic.a.2
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
            public Void doInBackground(Void... voidArr) {
                l<String> an = com.baidu.tbadk.core.c.a.BB().an("tb.frs_hottopic", "");
                if (an != null) {
                    FrsHotTopicListData frsHotTopicListData = new FrsHotTopicListData();
                    frsHotTopicListData.mSceneMap = a.dJA;
                    String jsonStrWithObject = OrmObject.jsonStrWithObject(frsHotTopicListData);
                    if (!StringUtils.isNull(jsonStrWithObject)) {
                        an.e("hot_topic_key", jsonStrWithObject);
                    }
                }
                return null;
            }
        };
        bdAsyncTask.setPriority(3);
        bdAsyncTask.execute(new Void[0]);
    }
}
