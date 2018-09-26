package com.baidu.tieba.applist;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class ApplistRequest extends HttpMessage {
    public ApplistRequest() {
        super(CmdConfigHttp.REPORT_APPLIST);
        addParam("applist", listToString());
        addParam("screen_w", String.valueOf(l.aO(TbadkCoreApplication.getInst().getContext())));
        addParam("screen_h", String.valueOf(l.aQ(TbadkCoreApplication.getInst().getContext())));
        addParam("mnc", String.valueOf(j.kT()));
        addParam("uid", TbadkCoreApplication.getCurrentAccount());
        addParam("_os_version", Build.VERSION.RELEASE);
        addParam("brand", Build.BRAND);
        addParam("brand_type", Build.MODEL);
    }

    private String listToString() {
        JSONObject jsonObject;
        JSONObject jSONObject = new JSONObject();
        try {
            JSONArray jSONArray = new JSONArray();
            for (a aVar : getAppInfos()) {
                if (aVar != null && (jsonObject = aVar.toJsonObject()) != null) {
                    jSONArray.put(jsonObject);
                }
            }
            jSONObject.put("applist", jSONArray);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject.toString();
    }

    private List<a> getAppInfos() {
        PackageManager packageManager = TbadkCoreApplication.getInst().getContext().getPackageManager();
        ArrayList arrayList = new ArrayList();
        for (ApplicationInfo applicationInfo : packageManager.getInstalledApplications(8192)) {
            a aVar = new a();
            aVar.setIcon(applicationInfo.loadIcon(packageManager));
            aVar.setName(applicationInfo.loadLabel(packageManager).toString());
            String str = applicationInfo.packageName;
            aVar.ly(str);
            try {
                aVar.setVersion(packageManager.getPackageInfo(str, 0).versionName);
            } catch (PackageManager.NameNotFoundException e) {
                e.printStackTrace();
            }
            aVar.eG(filterApp(applicationInfo));
            arrayList.add(aVar);
        }
        return arrayList;
    }

    private boolean filterApp(ApplicationInfo applicationInfo) {
        return (applicationInfo.flags & 128) != 0 || (applicationInfo.flags & 1) == 0;
    }
}
