package com.baidu.tieba.aiapps.apps.history;

import android.content.Context;
import android.database.Cursor;
import android.text.TextUtils;
import com.baidu.searchbox.ng.ai.apps.env.AiAppEnv;
import com.baidu.searchbox.ng.ai.apps.env.Purger;
import com.baidu.searchbox.ng.ai.apps.ioc.AiAppsRuntime;
import com.baidu.searchbox.ng.ai.apps.ioc.interfaces.IAiAppHistoryIoc;
import com.baidu.searchbox.ng.ai.apps.launch.model.AiAppsLaunchType;
import com.baidu.searchbox.ng.ai.apps.runtime.AiApp;
import com.baidu.searchbox.ng.ai.apps.scheme.actions.GetSwanHistoryAction;
import com.baidu.tieba.aiapps.apps.history.impl.provider.AiAppsHistoryProvider;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import rx.d;
import rx.functions.b;
import rx.functions.f;
import rx.schedulers.Schedulers;
/* loaded from: classes4.dex */
public class a implements IAiAppHistoryIoc {
    @Override // com.baidu.searchbox.ng.ai.apps.ioc.interfaces.IAiAppHistoryIoc
    public void getSwanHistory(final GetSwanHistoryAction.OnSwanHistoryListener onSwanHistoryListener) {
        if (onSwanHistoryListener != null) {
            d.just("").subscribeOn(Schedulers.io()).map(new f<String, List<com.baidu.tieba.aiapps.apps.history.impl.a.a>>() { // from class: com.baidu.tieba.aiapps.apps.history.a.2
                /* JADX DEBUG: Method merged with bridge method */
                @Override // rx.functions.f
                /* renamed from: ky */
                public List<com.baidu.tieba.aiapps.apps.history.impl.a.a> call(String str) {
                    return a.this.kx(str);
                }
            }).observeOn(rx.a.b.a.ccY()).subscribe(new b<List<com.baidu.tieba.aiapps.apps.history.impl.a.a>>() { // from class: com.baidu.tieba.aiapps.apps.history.a.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // rx.functions.b
                /* renamed from: aq */
                public void call(List<com.baidu.tieba.aiapps.apps.history.impl.a.a> list) {
                    if (list == null || list.size() == 0) {
                        onSwanHistoryListener.onFinish(null);
                        return;
                    }
                    JSONArray jSONArray = new JSONArray();
                    for (com.baidu.tieba.aiapps.apps.history.impl.a.a aVar : list) {
                        if (aVar != null) {
                            JSONObject jSONObject = new JSONObject();
                            try {
                                if (!TextUtils.isEmpty(aVar.appId)) {
                                    jSONObject.put("appid", aVar.appId);
                                }
                                jSONObject.put("type", aVar.bGJ);
                                jSONObject.put(GetSwanHistoryAction.KEY_SCHEME, GetSwanHistoryAction.SCHEME_CONSTANT_START + aVar.appId + GetSwanHistoryAction.SCHEME_CONSTANT_CONNECT + AiAppsLaunchType.LAUNCH_FROM_HISTORY);
                                if (aVar.bGK > 0) {
                                    jSONObject.put(GetSwanHistoryAction.KEY_DATA_STAMP, aVar.bGK);
                                }
                                if (!TextUtils.isEmpty(aVar.bGI)) {
                                    jSONObject.put(GetSwanHistoryAction.KEY_ICON_URL, aVar.bGI);
                                }
                                if (!TextUtils.isEmpty(aVar.appTitle)) {
                                    jSONObject.put("title", aVar.appTitle);
                                }
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                            jSONArray.put(jSONObject);
                        }
                    }
                    JSONObject jSONObject2 = new JSONObject();
                    try {
                        jSONObject2.put(GetSwanHistoryAction.KEY_HISTORY, jSONArray);
                    } catch (JSONException e2) {
                        e2.printStackTrace();
                    }
                    onSwanHistoryListener.onFinish(jSONObject2);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<com.baidu.tieba.aiapps.apps.history.impl.a.a> kx(String str) {
        Cursor cursor;
        Cursor cursor2 = null;
        String str2 = "%" + str + "%";
        StringBuilder append = new StringBuilder().append("app_access_time desc ");
        try {
            try {
                cursor = AiAppsRuntime.getAppContext().getContentResolver().query(AiAppsHistoryProvider.bGM, null, "app_title LIKE ?", new String[]{str2}, append.append(" LIMIT 400").toString());
                try {
                    List<com.baidu.tieba.aiapps.apps.history.impl.a.a> j = com.baidu.tieba.aiapps.apps.history.impl.a.a.j(cursor);
                    com.baidu.b.a.h.d.h(cursor);
                    return j;
                } catch (Exception e) {
                    e = e;
                    e.printStackTrace();
                    com.baidu.b.a.h.d.h(cursor);
                    return null;
                }
            } catch (Throwable th) {
                th = th;
                cursor2 = append;
                com.baidu.b.a.h.d.h(cursor2);
                throw th;
            }
        } catch (Exception e2) {
            e = e2;
            cursor = null;
        } catch (Throwable th2) {
            th = th2;
            com.baidu.b.a.h.d.h(cursor2);
            throw th;
        }
    }

    @Override // com.baidu.searchbox.ng.ai.apps.ioc.interfaces.IAiAppHistoryIoc
    public boolean removeSwanHistory(String str, boolean z) {
        Purger purger;
        int delete = AiAppsRuntime.getAppContext().getContentResolver().delete(AiAppsHistoryProvider.bGM, "app_id= ?", new String[]{str});
        if (delete > 0 && z && (purger = AiAppEnv.get().getPurger()) != null) {
            purger.deleteAiApp(str);
        }
        return delete > 0;
    }

    @Override // com.baidu.searchbox.ng.ai.apps.ioc.interfaces.IAiAppHistoryIoc
    public void saveAiAppInHistory(Context context, AiApp aiApp) {
        if (aiApp != null && aiApp.getLaunchInfo() != null && !TextUtils.equals(aiApp.getLaunchInfo().mNotInHistory, "1")) {
            context.getContentResolver().insert(AiAppsHistoryProvider.bGM, com.baidu.tieba.aiapps.apps.history.impl.a.a.a(com.baidu.tieba.aiapps.apps.history.impl.a.a.a(aiApp)));
        }
    }
}
