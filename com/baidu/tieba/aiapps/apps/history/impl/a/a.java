package com.baidu.tieba.aiapps.apps.history.impl.a;

import android.content.ContentValues;
import android.database.Cursor;
import com.baidu.ar.constants.HttpConstants;
import com.baidu.searchbox.ng.ai.apps.aps.AiAppsApsUtils;
import com.baidu.searchbox.ng.ai.apps.launch.model.AiAppsLaunchInfo;
import com.baidu.searchbox.ng.ai.apps.runtime.AiApp;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes4.dex */
public class a {
    public String appId;
    public String appKey;
    public String appTitle;
    public String bGK;
    public String bGL;
    public int bGM;
    public long bGN;

    public static List<a> j(Cursor cursor) {
        if (cursor == null || cursor.getCount() <= 0) {
            return null;
        }
        int columnIndex = cursor.getColumnIndex(HttpConstants.HTTP_APP_ID);
        int columnIndex2 = cursor.getColumnIndex(AiAppsApsUtils.APP_KEY);
        int columnIndex3 = cursor.getColumnIndex("app_title");
        int columnIndex4 = cursor.getColumnIndex("app_desc");
        int columnIndex5 = cursor.getColumnIndex("app_icon_url");
        int columnIndex6 = cursor.getColumnIndex("app_access_time");
        int columnIndex7 = cursor.getColumnIndex("app_type");
        LinkedList linkedList = new LinkedList();
        while (cursor.moveToNext()) {
            a aVar = new a();
            aVar.appId = cursor.getString(columnIndex);
            aVar.appKey = cursor.getString(columnIndex2);
            aVar.appTitle = cursor.getString(columnIndex3);
            aVar.bGK = cursor.getString(columnIndex4);
            aVar.bGL = cursor.getString(columnIndex5);
            aVar.bGN = cursor.getLong(columnIndex6);
            aVar.bGM = cursor.getInt(columnIndex7);
            linkedList.add(aVar);
        }
        return linkedList;
    }

    public static ContentValues a(a aVar) {
        if (aVar == null) {
            return null;
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put(AiAppsApsUtils.APP_KEY, aVar.appKey);
        contentValues.put(HttpConstants.HTTP_APP_ID, aVar.appId);
        contentValues.put("app_access_time", Long.valueOf(aVar.bGN));
        contentValues.put("app_desc", aVar.bGK);
        contentValues.put("app_title", aVar.appTitle);
        contentValues.put("app_icon_url", aVar.bGL);
        contentValues.put("app_type", Integer.valueOf(aVar.bGM));
        return contentValues;
    }

    public static a a(AiApp aiApp) {
        if (aiApp == null || aiApp.getLaunchInfo() == null) {
            return null;
        }
        AiAppsLaunchInfo launchInfo = aiApp.getLaunchInfo();
        a aVar = new a();
        aVar.bGN = System.currentTimeMillis();
        aVar.bGL = launchInfo.mAppIconUrl;
        aVar.appId = launchInfo.mAppId;
        aVar.appKey = launchInfo.mAppKey;
        aVar.bGK = launchInfo.mDescription;
        aVar.appTitle = launchInfo.mAppTitle;
        aVar.bGM = launchInfo.mType;
        return aVar;
    }
}
