package com.baidu.tbadk.plugins;

import android.app.IntentService;
import android.content.ContentProvider;
/* loaded from: classes.dex */
public class XiaoyingPlugin {
    private static ContentProvider ayE;
    private static IntentService ayF;
    private static IntentService ayG;
    private static IntentService ayH;
    private static IntentService ayI;

    public static IntentService getDownloadService() {
        return ayG;
    }

    public static void setDownloadService(IntentService intentService) {
        ayG = intentService;
    }

    public static IntentService getTaskService() {
        return ayH;
    }

    public static void setTaskService(IntentService intentService) {
        ayH = intentService;
    }

    public static IntentService getShareService() {
        return ayI;
    }

    public static void setShareService(IntentService intentService) {
        ayI = intentService;
    }

    public static final void setSocialService(IntentService intentService) {
        ayF = intentService;
    }

    public static final IntentService getSocialService() {
        return ayF;
    }

    public static final void setContentProvider(ContentProvider contentProvider) {
        ayE = contentProvider;
    }

    public static final ContentProvider getContentProvider() {
        return ayE;
    }
}
