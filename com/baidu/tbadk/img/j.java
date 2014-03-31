package com.baidu.tbadk.img;

import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes.dex */
final class j implements Parcelable.Creator<WriteImagesInfo> {
    /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ WriteImagesInfo createFromParcel(Parcel parcel) {
        WriteImagesInfo writeImagesInfo = new WriteImagesInfo();
        writeImagesInfo.parseJson(parcel.readString());
        return writeImagesInfo;
    }

    /* JADX DEBUG: Return type fixed from 'java.lang.Object[]' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ WriteImagesInfo[] newArray(int i) {
        return new WriteImagesInfo[i];
    }
}
