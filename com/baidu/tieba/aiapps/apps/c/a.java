package com.baidu.tieba.aiapps.apps.c;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationConstants;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.adaptation.a.ac;
import com.baidu.swan.apps.runtime.e;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.coreExtra.service.DealIntentService;
import com.baidu.tbadk.m.d;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes19.dex */
public class a implements ac {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private long lastResumeTime;

    @Override // com.baidu.swan.apps.adaptation.a.ac
    public void aay() {
        if (DEBUG) {
            Log.e("DefaultSwanAppLifecycle", "onAppForeground" + e.azI().id);
        }
        this.lastResumeTime = System.currentTimeMillis();
    }

    public String getCurrentPageKey() {
        return "a061";
    }

    public com.baidu.tbadk.m.b getPageStayFilter() {
        return null;
    }

    public List<String> getCurrentPageSourceKeyList() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(PageStayDurationConstants.PageName.HOMEPAGE);
        return arrayList;
    }

    @Override // com.baidu.swan.apps.adaptation.a.ac
    public void aaz() {
        if (DEBUG) {
            Log.e("DefaultSwanAppLifecycle", "onAppBackground");
        }
        long j = com.baidu.tbadk.core.sharedPref.b.bik().getLong("smart_app_tid", 0L);
        String string = com.baidu.tbadk.core.sharedPref.b.bik().getString("smart_app_id", "");
        String string2 = com.baidu.tbadk.core.sharedPref.b.bik().getString("smart_app_name", "");
        if (this.lastResumeTime != 0 && j != 0) {
            long currentTimeMillis = System.currentTimeMillis() - this.lastResumeTime;
            d dVar = new d();
            dVar.setStayDurationTime(currentTimeMillis);
            dVar.setCurrentPageKey(getCurrentPageKey());
            dVar.setTid(j);
            dVar.objID = string;
            dVar.eRi = string2;
            dVar.setSorceKeyList(getCurrentPageSourceKeyList());
            com.baidu.tbadk.m.e.btZ().jz(true);
            com.baidu.tbadk.m.e.btZ().a(TbadkApplication.getInst().getApplicationContext(), dVar, getPageStayFilter());
            com.baidu.tbadk.core.sharedPref.b.bik().putLong("smart_app_tid", 0L);
        }
    }

    @Override // com.baidu.swan.apps.adaptation.a.ac
    public void a(@NonNull SwanAppActivity swanAppActivity, int i, @Nullable com.baidu.swan.apps.u.c.b bVar) {
        if (DEBUG) {
            Log.e("DefaultSwanAppLifecycle", "onAppExit");
        }
        if (com.baidu.tbadk.core.sharedPref.b.bik().getBoolean("key_ai_app_guide_display", true)) {
            com.baidu.tbadk.core.sharedPref.b.bik().putBoolean("key_ai_app_guide_display", false);
            Intent intent = new Intent(swanAppActivity, DealIntentService.class);
            intent.putExtra(DealIntentService.KEY_CLASS, 38);
            swanAppActivity.startService(intent);
        }
    }

    @Override // com.baidu.swan.apps.adaptation.a.ac
    public void aaA() {
    }
}
