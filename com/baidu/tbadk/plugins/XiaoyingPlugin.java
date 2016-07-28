package com.baidu.tbadk.plugins;

import android.app.IntentService;
import android.content.ContentProvider;
/* loaded from: classes.dex */
public class XiaoyingPlugin {
    private static ContentProvider aAN;
    private static IntentService aAO;
    private static IntentService aAP;
    private static IntentService aAQ;
    private static IntentService aAR;

    public static IntentService getDownloadService() {
        return aAP;
    }

    public static void setDownloadService(IntentService intentService) {
        aAP = intentService;
    }

    public static IntentService getTaskService() {
        return aAQ;
    }

    public static void setTaskService(IntentService intentService) {
        aAQ = intentService;
    }

    public static IntentService getShareService() {
        return aAR;
    }

    public static void setShareService(IntentService intentService) {
        aAR = intentService;
    }

    public static final void setSocialService(IntentService intentService) {
        aAO = intentService;
    }

    public static final IntentService getSocialService() {
        return aAO;
    }

    public static final void setContentProvider(ContentProvider contentProvider) {
        aAN = contentProvider;
    }

    public static final ContentProvider getContentProvider() {
        return aAN;
    }
}
