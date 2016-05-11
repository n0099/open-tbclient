package com.baidu.tbadk.plugins;

import android.app.IntentService;
import android.content.ContentProvider;
/* loaded from: classes.dex */
public class XiaoyingPlugin {
    private static ContentProvider azh;
    private static IntentService azi;
    private static IntentService azj;
    private static IntentService azk;
    private static IntentService azl;

    public static IntentService getDownloadService() {
        return azj;
    }

    public static void setDownloadService(IntentService intentService) {
        azj = intentService;
    }

    public static IntentService getTaskService() {
        return azk;
    }

    public static void setTaskService(IntentService intentService) {
        azk = intentService;
    }

    public static IntentService getShareService() {
        return azl;
    }

    public static void setShareService(IntentService intentService) {
        azl = intentService;
    }

    public static final void setSocialService(IntentService intentService) {
        azi = intentService;
    }

    public static final IntentService getSocialService() {
        return azi;
    }

    public static final void setContentProvider(ContentProvider contentProvider) {
        azh = contentProvider;
    }

    public static final ContentProvider getContentProvider() {
        return azh;
    }
}
