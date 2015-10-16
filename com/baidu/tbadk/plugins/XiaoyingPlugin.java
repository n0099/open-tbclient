package com.baidu.tbadk.plugins;

import android.app.IntentService;
import android.content.ContentProvider;
/* loaded from: classes.dex */
public class XiaoyingPlugin {
    private static ContentProvider ayP;
    private static IntentService ayQ;
    private static IntentService ayR;
    private static IntentService ayS;
    private static IntentService ayT;

    public static IntentService getDownloadService() {
        return ayR;
    }

    public static void setDownloadService(IntentService intentService) {
        ayR = intentService;
    }

    public static IntentService getTaskService() {
        return ayS;
    }

    public static void setTaskService(IntentService intentService) {
        ayS = intentService;
    }

    public static IntentService getShareService() {
        return ayT;
    }

    public static void setShareService(IntentService intentService) {
        ayT = intentService;
    }

    public static final void setSocialService(IntentService intentService) {
        ayQ = intentService;
    }

    public static final IntentService getSocialService() {
        return ayQ;
    }

    public static final void setContentProvider(ContentProvider contentProvider) {
        ayP = contentProvider;
    }

    public static final ContentProvider getContentProvider() {
        return ayP;
    }
}
