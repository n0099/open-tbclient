package com.baidu.tieba.aiapps.apps.f;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.b.b.i;
import com.baidu.swan.apps.c;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.pageStayDuration.d;
import com.baidu.tbadk.pageStayDuration.e;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class a implements i {
    private static final boolean DEBUG = c.DEBUG;
    private long lastResumeTime;

    @Override // com.baidu.swan.apps.b.b.i
    public void vQ() {
        if (DEBUG) {
            Log.e("DefaultSwanAppLifecycle", "onAppForeground" + com.baidu.swan.apps.ae.b.IX().id);
        }
        this.lastResumeTime = System.currentTimeMillis();
    }

    public String getCurrentPageKey() {
        return "a061";
    }

    public com.baidu.tbadk.pageStayDuration.b getPageStayFilter() {
        return null;
    }

    public List<String> getCurrentPageSourceKeyList() {
        ArrayList arrayList = new ArrayList();
        arrayList.add("a001");
        return arrayList;
    }

    @Override // com.baidu.swan.apps.b.b.i
    public void vR() {
        if (DEBUG) {
            Log.e("DefaultSwanAppLifecycle", "onAppBackground");
        }
        long j = com.baidu.tbadk.core.sharedPref.b.getInstance().getLong("smart_app_tid", 0L);
        String string = com.baidu.tbadk.core.sharedPref.b.getInstance().getString("smart_app_id", "");
        String string2 = com.baidu.tbadk.core.sharedPref.b.getInstance().getString("smart_app_name", "");
        if (this.lastResumeTime != 0 && j != 0) {
            long currentTimeMillis = System.currentTimeMillis() - this.lastResumeTime;
            d dVar = new d();
            dVar.aS(currentTimeMillis);
            dVar.pt(getCurrentPageKey());
            dVar.setTid(j);
            dVar.cpL = string;
            dVar.cpM = string2;
            dVar.ah(getCurrentPageSourceKeyList());
            e.aoQ().fc(true);
            e.aoQ().a(TbadkApplication.getInst().getApplicationContext(), dVar, getPageStayFilter());
            com.baidu.tbadk.core.sharedPref.b.getInstance().putLong("smart_app_tid", 0L);
        }
    }

    @Override // com.baidu.swan.apps.b.b.i
    public void a(@NonNull SwanAppActivity swanAppActivity, int i, @Nullable com.baidu.swan.apps.v.b.b bVar) {
        if (DEBUG) {
            Log.e("DefaultSwanAppLifecycle", "onAppExit");
        }
    }
}
