package com.baidu.tbadk.plugins;

import android.app.IntentService;
import android.content.ContentProvider;
/* loaded from: classes.dex */
public class XiaoyingPlugin {
    private static ContentProvider azI;
    private static IntentService azJ;
    private static IntentService azK;
    private static IntentService azL;
    private static IntentService azM;

    public static IntentService getDownloadService() {
        return azK;
    }

    public static void setDownloadService(IntentService intentService) {
        azK = intentService;
    }

    public static IntentService getTaskService() {
        return azL;
    }

    public static void setTaskService(IntentService intentService) {
        azL = intentService;
    }

    public static IntentService getShareService() {
        return azM;
    }

    public static void setShareService(IntentService intentService) {
        azM = intentService;
    }

    public static final void setSocialService(IntentService intentService) {
        azJ = intentService;
    }

    public static final IntentService getSocialService() {
        return azJ;
    }

    public static final void setContentProvider(ContentProvider contentProvider) {
        azI = contentProvider;
    }

    public static final ContentProvider getContentProvider() {
        return azI;
    }
}
