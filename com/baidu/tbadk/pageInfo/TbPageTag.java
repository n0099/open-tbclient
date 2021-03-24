package com.baidu.tbadk.pageInfo;

import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes3.dex */
public class TbPageTag implements Parcelable {
    public static final Parcelable.Creator<TbPageTag> CREATOR = new a();
    public int isGeneralTab;
    public String locatePage;
    public int sortType;
    public int tabId;
    public int tabType;

    /* loaded from: classes3.dex */
    public static class a implements Parcelable.Creator<TbPageTag> {
        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public TbPageTag createFromParcel(Parcel parcel) {
            return new TbPageTag(parcel);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public TbPageTag[] newArray(int i) {
            return new TbPageTag[i];
        }
    }

    public TbPageTag() {
        this.sortType = -1;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        return "TbPageTag{locatePage='" + this.locatePage + "', sortType=" + this.sortType + ", tabId=" + this.tabId + ", tabType=" + this.tabType + ", isGeneralTab=" + this.isGeneralTab + '}';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.locatePage);
        parcel.writeInt(this.sortType);
        parcel.writeInt(this.tabId);
        parcel.writeInt(this.tabType);
        parcel.writeInt(this.isGeneralTab);
    }

    public TbPageTag(Parcel parcel) {
        this.sortType = -1;
        this.locatePage = parcel.readString();
        this.sortType = parcel.readInt();
        this.tabId = parcel.readInt();
        this.tabType = parcel.readInt();
        this.isGeneralTab = parcel.readInt();
    }
}
