package com.baidu.tieba.frs.FrsHotTopic;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.cache.l;
import com.baidu.adp.lib.util.StringUtils;
import java.util.Iterator;
import java.util.Map;
/* loaded from: classes.dex */
public class a {
    private static a icm;
    private FrsLinkHashMap<String, Long> icn;

    private a() {
    }

    public static a cpX() {
        if (icm == null) {
            synchronized (a.class) {
                if (icm == null) {
                    icm = new a();
                }
            }
        }
        return icm;
    }

    private void B(String str, long j) {
        BdAsyncTask<Void, Void, Void> bdAsyncTask = new BdAsyncTask<Void, Void, Void>() { // from class: com.baidu.tieba.frs.FrsHotTopic.a.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
            public Void doInBackground(Void... voidArr) {
                FrsHotTopicListData frsHotTopicListData;
                l<String> dw = com.baidu.tbadk.core.c.a.bhV().dw("tb.frs_hottopic", "");
                if (dw != null) {
                    String str2 = dw.get("hot_topic_key");
                    if (!StringUtils.isNull(str2) && (frsHotTopicListData = (FrsHotTopicListData) OrmObject.objectWithJsonStr(str2, FrsHotTopicListData.class)) != null) {
                        a.this.icn = frsHotTopicListData.mSceneMap;
                    }
                }
                return null;
            }
        };
        bdAsyncTask.setPriority(3);
        bdAsyncTask.execute(new Void[0]);
    }

    public boolean C(String str, long j) {
        boolean z;
        if (this.icn == null) {
            this.icn = new FrsLinkHashMap<>();
            B(str, j);
        }
        if (StringUtils.isNull(str) || this.icn.isEmpty()) {
            return false;
        }
        Iterator<Map.Entry<String, Long>> it = this.icn.entrySet().iterator();
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
        if (z && this.icn.get(str).longValue() == j) {
            return false;
        }
        this.icn.put(str, Long.valueOf(j));
        cpY();
        return true;
    }

    private void cpY() {
        BdAsyncTask<Void, Void, Void> bdAsyncTask = new BdAsyncTask<Void, Void, Void>() { // from class: com.baidu.tieba.frs.FrsHotTopic.a.2
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
            public Void doInBackground(Void... voidArr) {
                l<String> dw = com.baidu.tbadk.core.c.a.bhV().dw("tb.frs_hottopic", "");
                if (dw != null) {
                    FrsHotTopicListData frsHotTopicListData = new FrsHotTopicListData();
                    frsHotTopicListData.mSceneMap = a.this.icn;
                    String jsonStrWithObject = OrmObject.jsonStrWithObject(frsHotTopicListData);
                    if (!StringUtils.isNull(jsonStrWithObject)) {
                        dw.setForever("hot_topic_key", jsonStrWithObject);
                    }
                }
                return null;
            }
        };
        bdAsyncTask.setPriority(3);
        bdAsyncTask.execute(new Void[0]);
    }
}
