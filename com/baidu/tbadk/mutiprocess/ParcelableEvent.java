package com.baidu.tbadk.mutiprocess;

import android.os.Parcelable;
import android.os.Process;
/* loaded from: classes.dex */
public abstract class ParcelableEvent implements Parcelable, a {
    private int mTag = 0;
    private int mType = 0;
    private int mPid = Process.myPid();
}
