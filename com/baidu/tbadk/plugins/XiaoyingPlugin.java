package com.baidu.tbadk.plugins;

import android.app.IntentService;
import android.content.ContentProvider;
/* loaded from: classes.dex */
public class XiaoyingPlugin {
    private static ContentProvider aDU;
    private static IntentService aDV;
    private static IntentService aDW;
    private static IntentService aDX;
    private static IntentService aDY;

    public static IntentService getDownloadService() {
        return aDW;
    }

    public static void setDownloadService(IntentService intentService) {
        aDW = intentService;
    }

    public static IntentService getTaskService() {
        return aDX;
    }

    public static void setTaskService(IntentService intentService) {
        aDX = intentService;
    }

    public static IntentService getShareService() {
        return aDY;
    }

    public static void setShareService(IntentService intentService) {
        aDY = intentService;
    }

    public static final void setSocialService(IntentService intentService) {
        aDV = intentService;
    }

    public static final IntentService getSocialService() {
        return aDV;
    }

    public static final void setContentProvider(ContentProvider contentProvider) {
        aDU = contentProvider;
    }

    public static final ContentProvider getContentProvider() {
        return aDU;
    }
}
