package com.baidu.tieba.barcode.result;

import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes.dex */
public class ZxingResult implements Parcelable {
    private String a;

    public String a() {
        return this.a;
    }

    public void a(String str) {
        this.a = str;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
    }
}
