package com.baidu.tbadk.plugins;

import android.app.IntentService;
import android.content.ContentProvider;
/* loaded from: classes.dex */
public class XiaoyingPlugin {
    private static ContentProvider aBp;
    private static IntentService aBq;
    private static IntentService aBr;
    private static IntentService aBs;
    private static IntentService aBt;

    public static IntentService getDownloadService() {
        return aBr;
    }

    public static void setDownloadService(IntentService intentService) {
        aBr = intentService;
    }

    public static IntentService getTaskService() {
        return aBs;
    }

    public static void setTaskService(IntentService intentService) {
        aBs = intentService;
    }

    public static IntentService getShareService() {
        return aBt;
    }

    public static void setShareService(IntentService intentService) {
        aBt = intentService;
    }

    public static final void setSocialService(IntentService intentService) {
        aBq = intentService;
    }

    public static final IntentService getSocialService() {
        return aBq;
    }

    public static final void setContentProvider(ContentProvider contentProvider) {
        aBp = contentProvider;
    }

    public static final ContentProvider getContentProvider() {
        return aBp;
    }
}
