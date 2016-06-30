package com.baidu.tbadk.plugins;

import android.app.IntentService;
import android.content.ContentProvider;
/* loaded from: classes.dex */
public class XiaoyingPlugin {
    private static IntentService aAa;
    private static IntentService aAb;
    private static ContentProvider azX;
    private static IntentService azY;
    private static IntentService azZ;

    public static IntentService getDownloadService() {
        return azZ;
    }

    public static void setDownloadService(IntentService intentService) {
        azZ = intentService;
    }

    public static IntentService getTaskService() {
        return aAa;
    }

    public static void setTaskService(IntentService intentService) {
        aAa = intentService;
    }

    public static IntentService getShareService() {
        return aAb;
    }

    public static void setShareService(IntentService intentService) {
        aAb = intentService;
    }

    public static final void setSocialService(IntentService intentService) {
        azY = intentService;
    }

    public static final IntentService getSocialService() {
        return azY;
    }

    public static final void setContentProvider(ContentProvider contentProvider) {
        azX = contentProvider;
    }

    public static final ContentProvider getContentProvider() {
        return azX;
    }
}
