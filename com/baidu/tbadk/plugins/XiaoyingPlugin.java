package com.baidu.tbadk.plugins;

import android.app.IntentService;
import android.content.ContentProvider;
/* loaded from: classes.dex */
public class XiaoyingPlugin {
    private static ContentProvider aCe;
    private static IntentService aCf;
    private static IntentService aCg;
    private static IntentService aCh;
    private static IntentService aCi;

    public static IntentService getDownloadService() {
        return aCg;
    }

    public static void setDownloadService(IntentService intentService) {
        aCg = intentService;
    }

    public static IntentService getTaskService() {
        return aCh;
    }

    public static void setTaskService(IntentService intentService) {
        aCh = intentService;
    }

    public static IntentService getShareService() {
        return aCi;
    }

    public static void setShareService(IntentService intentService) {
        aCi = intentService;
    }

    public static final void setSocialService(IntentService intentService) {
        aCf = intentService;
    }

    public static final IntentService getSocialService() {
        return aCf;
    }

    public static final void setContentProvider(ContentProvider contentProvider) {
        aCe = contentProvider;
    }

    public static final ContentProvider getContentProvider() {
        return aCe;
    }
}
