package com.baidu.tbadk.live.service;

import android.os.IInterface;
/* loaded from: classes.dex */
public interface a extends IInterface {
    void a(d dVar);

    void b(d dVar);

    void closePublish(String str, boolean z);

    void connectAndPublish(String str, String str2, String str3, String str4, String str5, String str6);

    String getCurrentGroupId();

    int getCurrentStatus();

    String getCurrentUrl();

    int getDurationOfRecord();

    int getPositionOfRecord();

    int getRecordStatus();

    int getRecordTime();

    int getSignalStrength();

    void pausePlay(String str);

    void pausePublish(String str);

    void playOrRecord(String str, String str2, String str3, String str4, String str5, String str6, boolean z, boolean z2);

    void requestStatusRebroadcast();

    void resumePlay(String str);

    void resumePublish(String str);

    void retryPlay();

    void seekPlayRecord(int i);

    void setPublisherPaused(boolean z);

    void startPlay(String str, String str2, int i);

    void startPublish(String str);

    void startRecordInPublish(String str);

    void stopAnyRunning(boolean z);

    void stopPlay(String str, boolean z);

    void stopPublish(String str);

    void stopRecordInPublish(String str);

    int whatIsRunning();
}
