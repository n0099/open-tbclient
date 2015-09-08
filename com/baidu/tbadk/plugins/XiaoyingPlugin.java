package com.baidu.tbadk.plugins;

import android.app.IntentService;
import android.content.ContentProvider;
/* loaded from: classes.dex */
public class XiaoyingPlugin {
    private static ContentProvider aAe;
    private static IntentService aAf;
    private static IntentService aAg;
    private static IntentService aAh;
    private static IntentService aAi;

    public static IntentService getDownloadService() {
        return aAg;
    }

    public static void setDownloadService(IntentService intentService) {
        aAg = intentService;
    }

    public static IntentService getTaskService() {
        return aAh;
    }

    public static void setTaskService(IntentService intentService) {
        aAh = intentService;
    }

    public static IntentService getShareService() {
        return aAi;
    }

    public static void setShareService(IntentService intentService) {
        aAi = intentService;
    }

    public static final void setSocialService(IntentService intentService) {
        aAf = intentService;
    }

    public static final IntentService getSocialService() {
        return aAf;
    }

    public static final void setContentProvider(ContentProvider contentProvider) {
        aAe = contentProvider;
    }

    public static final ContentProvider getContentProvider() {
        return aAe;
    }
}
