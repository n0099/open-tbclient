package com.baidu.tieba.barcode.result;

import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes.dex */
public class ZxingResult implements Parcelable {

    /* renamed from: a  reason: collision with root package name */
    private String f1158a;

    public String a() {
        return this.f1158a;
    }

    public void a(String str) {
        this.f1158a = str;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
    }
}
