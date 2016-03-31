package com.baidu.tbadk.plugins;

import android.app.IntentService;
import android.content.ContentProvider;
/* loaded from: classes.dex */
public class XiaoyingPlugin {
    private static ContentProvider aDc;
    private static IntentService aDd;
    private static IntentService aDe;
    private static IntentService aDf;
    private static IntentService aDg;

    public static IntentService getDownloadService() {
        return aDe;
    }

    public static void setDownloadService(IntentService intentService) {
        aDe = intentService;
    }

    public static IntentService getTaskService() {
        return aDf;
    }

    public static void setTaskService(IntentService intentService) {
        aDf = intentService;
    }

    public static IntentService getShareService() {
        return aDg;
    }

    public static void setShareService(IntentService intentService) {
        aDg = intentService;
    }

    public static final void setSocialService(IntentService intentService) {
        aDd = intentService;
    }

    public static final IntentService getSocialService() {
        return aDd;
    }

    public static final void setContentProvider(ContentProvider contentProvider) {
        aDc = contentProvider;
    }

    public static final ContentProvider getContentProvider() {
        return aDc;
    }
}
