package com.baidu.tieba.frs.FrsHotTopic;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.cache.l;
import com.baidu.adp.lib.util.StringUtils;
import java.util.Iterator;
import java.util.Map;
/* loaded from: classes.dex */
public class a {
    private static a diU;
    private static FrsLinkHashMap<String, Long> diV = new FrsLinkHashMap<>();

    private a() {
        atQ();
    }

    public static a atP() {
        if (diU == null) {
            synchronized (a.class) {
                if (diU == null) {
                    diU = new a();
                }
            }
        }
        return diU;
    }

    private static void atQ() {
        BdAsyncTask<Void, Void, Void> bdAsyncTask = new BdAsyncTask<Void, Void, Void>() { // from class: com.baidu.tieba.frs.FrsHotTopic.a.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
            public Void doInBackground(Void... voidArr) {
                FrsHotTopicListData frsHotTopicListData;
                l<String> R = com.baidu.tbadk.core.c.a.wW().R("tb.frs_hottopic", "");
                if (R != null) {
                    String str = R.get("hot_topic_key");
                    if (!StringUtils.isNull(str) && (frsHotTopicListData = (FrsHotTopicListData) OrmObject.objectWithJsonStr(str, FrsHotTopicListData.class)) != null) {
                        FrsLinkHashMap unused = a.diV = frsHotTopicListData.mSceneMap;
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
        if (diV != null && str != null) {
            Iterator<Map.Entry<String, Long>> it = diV.entrySet().iterator();
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
            if (!z || (z && diV.get(str).longValue() != j)) {
                diV.put(str, Long.valueOf(j));
                atR();
                return true;
            }
        }
        return false;
    }

    private void atR() {
        BdAsyncTask<Void, Void, Void> bdAsyncTask = new BdAsyncTask<Void, Void, Void>() { // from class: com.baidu.tieba.frs.FrsHotTopic.a.2
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
            public Void doInBackground(Void... voidArr) {
                l<String> R = com.baidu.tbadk.core.c.a.wW().R("tb.frs_hottopic", "");
                if (R != null) {
                    FrsHotTopicListData frsHotTopicListData = new FrsHotTopicListData();
                    frsHotTopicListData.mSceneMap = a.diV;
                    String jsonStrWithObject = OrmObject.jsonStrWithObject(frsHotTopicListData);
                    if (!StringUtils.isNull(jsonStrWithObject)) {
                        R.e("hot_topic_key", jsonStrWithObject);
                    }
                }
                return null;
            }
        };
        bdAsyncTask.setPriority(3);
        bdAsyncTask.execute(new Void[0]);
    }
}
