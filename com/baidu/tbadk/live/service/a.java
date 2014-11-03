package com.baidu.tbadk.live.service;

import android.os.IInterface;
/* loaded from: classes.dex */
public interface a extends IInterface {
    void a(d dVar);

    void a(String str, String str2, String str3, String str4, String str5, String str6);

    void a(String str, String str2, String str3, String str4, String str5, String str6, boolean z, boolean z2);

    void ax(boolean z);

    void b(d dVar);

    void c(String str, String str2, int i);

    void dC(String str);

    void dD(String str);

    void dE(String str);

    String getCurrentGroupId();

    int getCurrentStatus();

    String getCurrentUrl();

    int getDurationOfRecord();

    int getPositionOfRecord();

    int getRecordStatus();

    int getRecordTime();

    int getSignalStrength();

    void o(String str, boolean z);

    void p(String str, boolean z);

    void pausePublish(String str);

    void resumePublish(String str);

    void retryPlay();

    void seekPlayRecord(int i);

    void setPublisherPaused(boolean z);

    void startRecordInPublish(String str);

    void stopPublish(String str);

    void stopRecordInPublish(String str);

    void sw();

    int whatIsRunning();
}
