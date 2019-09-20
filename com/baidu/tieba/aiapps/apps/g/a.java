package com.baidu.tieba.aiapps.apps.g;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.b.b.i;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.coreExtra.service.DealIntentService;
import com.baidu.tbadk.o.d;
import com.baidu.tbadk.o.e;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class a implements i {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private long lastResumeTime;

    @Override // com.baidu.swan.apps.b.b.i
    public void xl() {
        if (DEBUG) {
            Log.e("DefaultSwanAppLifecycle", "onAppForeground" + com.baidu.swan.apps.ae.b.Mh().id);
        }
        this.lastResumeTime = System.currentTimeMillis();
    }

    public String getCurrentPageKey() {
        return "a061";
    }

    public com.baidu.tbadk.o.b getPageStayFilter() {
        return null;
    }

    public List<String> getCurrentPageSourceKeyList() {
        ArrayList arrayList = new ArrayList();
        arrayList.add("a001");
        return arrayList;
    }

    @Override // com.baidu.swan.apps.b.b.i
    public void xm() {
        if (DEBUG) {
            Log.e("DefaultSwanAppLifecycle", "onAppBackground");
        }
        long j = com.baidu.tbadk.core.sharedPref.b.ahU().getLong("smart_app_tid", 0L);
        String string = com.baidu.tbadk.core.sharedPref.b.ahU().getString("smart_app_id", "");
        String string2 = com.baidu.tbadk.core.sharedPref.b.ahU().getString("smart_app_name", "");
        if (this.lastResumeTime != 0 && j != 0) {
            long currentTimeMillis = System.currentTimeMillis() - this.lastResumeTime;
            d dVar = new d();
            dVar.bl(currentTimeMillis);
            dVar.re(getCurrentPageKey());
            dVar.setTid(j);
            dVar.cAn = string;
            dVar.cAo = string2;
            dVar.ao(getCurrentPageSourceKeyList());
            e.avn().fF(true);
            e.avn().a(TbadkApplication.getInst().getApplicationContext(), dVar, getPageStayFilter());
            com.baidu.tbadk.core.sharedPref.b.ahU().putLong("smart_app_tid", 0L);
        }
    }

    @Override // com.baidu.swan.apps.b.b.i
    public void a(@NonNull SwanAppActivity swanAppActivity, int i, @Nullable com.baidu.swan.apps.v.b.b bVar) {
        if (DEBUG) {
            Log.e("DefaultSwanAppLifecycle", "onAppExit");
        }
        if (com.baidu.tbadk.core.sharedPref.b.ahU().getBoolean("key_ai_app_guide_display", true)) {
            com.baidu.tbadk.core.sharedPref.b.ahU().putBoolean("key_ai_app_guide_display", false);
            Intent intent = new Intent(swanAppActivity, DealIntentService.class);
            intent.putExtra(DealIntentService.KEY_CLASS, 38);
            swanAppActivity.startService(intent);
        }
    }
}
