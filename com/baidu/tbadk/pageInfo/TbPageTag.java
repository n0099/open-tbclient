package com.baidu.tbadk.pageInfo;

import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes.dex */
public class TbPageTag implements Parcelable {
    public static final Parcelable.Creator<TbPageTag> CREATOR = new Parcelable.Creator<TbPageTag>() { // from class: com.baidu.tbadk.pageInfo.TbPageTag.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        /* renamed from: W */
        public TbPageTag createFromParcel(Parcel parcel) {
            return new TbPageTag(parcel);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        /* renamed from: mM */
        public TbPageTag[] newArray(int i) {
            return new TbPageTag[i];
        }
    };
    public String locatePage;
    public int sortType;

    public TbPageTag() {
        this.sortType = -1;
    }

    protected TbPageTag(Parcel parcel) {
        this.sortType = -1;
        this.locatePage = parcel.readString();
        this.sortType = parcel.readInt();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.locatePage);
        parcel.writeInt(this.sortType);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }
}
