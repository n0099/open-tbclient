package com.baidu.tbadk.plugins;

import android.app.IntentService;
import android.content.ContentProvider;
/* loaded from: classes.dex */
public class XiaoyingPlugin {
    private static ContentProvider axE;
    private static IntentService axF;
    private static IntentService axG;
    private static IntentService axH;
    private static IntentService axI;

    public static IntentService getDownloadService() {
        return axG;
    }

    public static void setDownloadService(IntentService intentService) {
        axG = intentService;
    }

    public static IntentService getTaskService() {
        return axH;
    }

    public static void setTaskService(IntentService intentService) {
        axH = intentService;
    }

    public static IntentService getShareService() {
        return axI;
    }

    public static void setShareService(IntentService intentService) {
        axI = intentService;
    }

    public static final void setSocialService(IntentService intentService) {
        axF = intentService;
    }

    public static final IntentService getSocialService() {
        return axF;
    }

    public static final void setContentProvider(ContentProvider contentProvider) {
        axE = contentProvider;
    }

    public static final ContentProvider getContentProvider() {
        return axE;
    }
}
