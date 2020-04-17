package com.baidu.tieba.aiapps.apps.e;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationConstants;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.adaptation.a.x;
import com.baidu.swan.apps.runtime.e;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.coreExtra.service.DealIntentService;
import com.baidu.tbadk.m.d;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes12.dex */
public class a implements x {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private long lastResumeTime;

    @Override // com.baidu.swan.apps.adaptation.a.x
    public void Qn() {
        if (DEBUG) {
            Log.e("DefaultSwanAppLifecycle", "onAppForeground" + e.akN().id);
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

    @Override // com.baidu.swan.apps.adaptation.a.x
    public void Qo() {
        if (DEBUG) {
            Log.e("DefaultSwanAppLifecycle", "onAppBackground");
        }
        long j = com.baidu.tbadk.core.sharedPref.b.aNV().getLong("smart_app_tid", 0L);
        String string = com.baidu.tbadk.core.sharedPref.b.aNV().getString("smart_app_id", "");
        String string2 = com.baidu.tbadk.core.sharedPref.b.aNV().getString("smart_app_name", "");
        if (this.lastResumeTime != 0 && j != 0) {
            long currentTimeMillis = System.currentTimeMillis() - this.lastResumeTime;
            d dVar = new d();
            dVar.setStayDurationTime(currentTimeMillis);
            dVar.setCurrentPageKey(getCurrentPageKey());
            dVar.setTid(j);
            dVar.objID = string;
            dVar.edd = string2;
            dVar.setSorceKeyList(getCurrentPageSourceKeyList());
            com.baidu.tbadk.m.e.aZm().hR(true);
            com.baidu.tbadk.m.e.aZm().a(TbadkApplication.getInst().getApplicationContext(), dVar, getPageStayFilter());
            com.baidu.tbadk.core.sharedPref.b.aNV().putLong("smart_app_tid", 0L);
        }
    }

    @Override // com.baidu.swan.apps.adaptation.a.x
    public void a(@NonNull SwanAppActivity swanAppActivity, int i, @Nullable com.baidu.swan.apps.x.b.b bVar) {
        if (DEBUG) {
            Log.e("DefaultSwanAppLifecycle", "onAppExit");
        }
        if (com.baidu.tbadk.core.sharedPref.b.aNV().getBoolean("key_ai_app_guide_display", true)) {
            com.baidu.tbadk.core.sharedPref.b.aNV().putBoolean("key_ai_app_guide_display", false);
            Intent intent = new Intent(swanAppActivity, DealIntentService.class);
            intent.putExtra(DealIntentService.KEY_CLASS, 38);
            swanAppActivity.startService(intent);
        }
    }

    @Override // com.baidu.swan.apps.adaptation.a.x
    public void Qp() {
    }
}
