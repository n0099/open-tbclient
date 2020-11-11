package com.baidu.tieba.frs.FrsHotTopic;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.cache.l;
import com.baidu.adp.lib.util.StringUtils;
import java.util.Iterator;
import java.util.Map;
/* loaded from: classes.dex */
public class a {
    private static a iJG;
    private FrsLinkHashMap<String, Long> iJH;

    private a() {
    }

    public static a czd() {
        if (iJG == null) {
            synchronized (a.class) {
                if (iJG == null) {
                    iJG = new a();
                }
            }
        }
        return iJG;
    }

    private void E(String str, long j) {
        BdAsyncTask<Void, Void, Void> bdAsyncTask = new BdAsyncTask<Void, Void, Void>() { // from class: com.baidu.tieba.frs.FrsHotTopic.a.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
            public Void doInBackground(Void... voidArr) {
                FrsHotTopicListData frsHotTopicListData;
                l<String> dI = com.baidu.tbadk.core.c.a.boX().dI("tb.frs_hottopic", "");
                if (dI != null) {
                    String str2 = dI.get("hot_topic_key");
                    if (!StringUtils.isNull(str2) && (frsHotTopicListData = (FrsHotTopicListData) OrmObject.objectWithJsonStr(str2, FrsHotTopicListData.class)) != null) {
                        a.this.iJH = frsHotTopicListData.mSceneMap;
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
        if (this.iJH == null) {
            this.iJH = new FrsLinkHashMap<>();
            E(str, j);
        }
        if (StringUtils.isNull(str) || this.iJH.isEmpty()) {
            return false;
        }
        Iterator<Map.Entry<String, Long>> it = this.iJH.entrySet().iterator();
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
        if (z && this.iJH.get(str).longValue() == j) {
            return false;
        }
        this.iJH.put(str, Long.valueOf(j));
        cze();
        return true;
    }

    private void cze() {
        BdAsyncTask<Void, Void, Void> bdAsyncTask = new BdAsyncTask<Void, Void, Void>() { // from class: com.baidu.tieba.frs.FrsHotTopic.a.2
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
            public Void doInBackground(Void... voidArr) {
                l<String> dI = com.baidu.tbadk.core.c.a.boX().dI("tb.frs_hottopic", "");
                if (dI != null) {
                    FrsHotTopicListData frsHotTopicListData = new FrsHotTopicListData();
                    frsHotTopicListData.mSceneMap = a.this.iJH;
                    String jsonStrWithObject = OrmObject.jsonStrWithObject(frsHotTopicListData);
                    if (!StringUtils.isNull(jsonStrWithObject)) {
                        dI.setForever("hot_topic_key", jsonStrWithObject);
                    }
                }
                return null;
            }
        };
        bdAsyncTask.setPriority(3);
        bdAsyncTask.execute(new Void[0]);
    }
}
