package com.baidu.tbadk.img;

import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes.dex */
class j implements Parcelable.Creator<WriteImagesInfo> {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.os.Parcelable.Creator
    /* renamed from: e */
    public WriteImagesInfo createFromParcel(Parcel parcel) {
        WriteImagesInfo writeImagesInfo = new WriteImagesInfo();
        writeImagesInfo.parseJson(parcel.readString());
        return writeImagesInfo;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.os.Parcelable.Creator
    /* renamed from: dF */
    public WriteImagesInfo[] newArray(int i) {
        return new WriteImagesInfo[i];
    }
}
