package com.baidu.tbadk.plugins;

import android.app.IntentService;
import android.content.ContentProvider;
/* loaded from: classes.dex */
public class XiaoyingPlugin {
    private static IntentService ayA;
    private static ContentProvider ayw;
    private static IntentService ayx;
    private static IntentService ayy;
    private static IntentService ayz;

    public static IntentService getDownloadService() {
        return ayy;
    }

    public static void setDownloadService(IntentService intentService) {
        ayy = intentService;
    }

    public static IntentService getTaskService() {
        return ayz;
    }

    public static void setTaskService(IntentService intentService) {
        ayz = intentService;
    }

    public static IntentService getShareService() {
        return ayA;
    }

    public static void setShareService(IntentService intentService) {
        ayA = intentService;
    }

    public static final void setSocialService(IntentService intentService) {
        ayx = intentService;
    }

    public static final IntentService getSocialService() {
        return ayx;
    }

    public static final void setContentProvider(ContentProvider contentProvider) {
        ayw = contentProvider;
    }

    public static final ContentProvider getContentProvider() {
        return ayw;
    }
}
