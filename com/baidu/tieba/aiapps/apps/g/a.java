package com.baidu.tieba.aiapps.apps.g;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationConstants;
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
    public void Cf() {
        if (DEBUG) {
            Log.e("DefaultSwanAppLifecycle", "onAppForeground" + com.baidu.swan.apps.ae.b.QZ().id);
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
        arrayList.add(PageStayDurationConstants.PageName.HOMEPAGE);
        return arrayList;
    }

    @Override // com.baidu.swan.apps.b.b.i
    public void Cg() {
        if (DEBUG) {
            Log.e("DefaultSwanAppLifecycle", "onAppBackground");
        }
        long j = com.baidu.tbadk.core.sharedPref.b.alR().getLong("smart_app_tid", 0L);
        String string = com.baidu.tbadk.core.sharedPref.b.alR().getString("smart_app_id", "");
        String string2 = com.baidu.tbadk.core.sharedPref.b.alR().getString("smart_app_name", "");
        if (this.lastResumeTime != 0 && j != 0) {
            long currentTimeMillis = System.currentTimeMillis() - this.lastResumeTime;
            d dVar = new d();
            dVar.setStayDurationTime(currentTimeMillis);
            dVar.setCurrentPageKey(getCurrentPageKey());
            dVar.setTid(j);
            dVar.objID = string;
            dVar.cLB = string2;
            dVar.setSorceKeyList(getCurrentPageSourceKeyList());
            e.awz().fv(true);
            e.awz().a(TbadkApplication.getInst().getApplicationContext(), dVar, getPageStayFilter());
            com.baidu.tbadk.core.sharedPref.b.alR().putLong("smart_app_tid", 0L);
        }
    }

    @Override // com.baidu.swan.apps.b.b.i
    public void a(@NonNull SwanAppActivity swanAppActivity, int i, @Nullable com.baidu.swan.apps.v.b.b bVar) {
        if (DEBUG) {
            Log.e("DefaultSwanAppLifecycle", "onAppExit");
        }
        if (com.baidu.tbadk.core.sharedPref.b.alR().getBoolean("key_ai_app_guide_display", true)) {
            com.baidu.tbadk.core.sharedPref.b.alR().putBoolean("key_ai_app_guide_display", false);
            Intent intent = new Intent(swanAppActivity, DealIntentService.class);
            intent.putExtra(DealIntentService.KEY_CLASS, 38);
            swanAppActivity.startService(intent);
        }
    }
}
