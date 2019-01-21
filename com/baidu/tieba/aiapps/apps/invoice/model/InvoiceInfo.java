package com.baidu.tieba.aiapps.apps.invoice.model;

import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes4.dex */
public class InvoiceInfo implements Parcelable {
    public static final Parcelable.Creator<InvoiceInfo> CREATOR = new Parcelable.Creator<InvoiceInfo>() { // from class: com.baidu.tieba.aiapps.apps.invoice.model.InvoiceInfo.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        /* renamed from: l */
        public InvoiceInfo createFromParcel(Parcel parcel) {
            return new InvoiceInfo(parcel);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        /* renamed from: hW */
        public InvoiceInfo[] newArray(int i) {
            return new InvoiceInfo[i];
        }
    };
    @com.google.gson.a.c("tax_number")
    public String bHW;
    @com.google.gson.a.c("company_address")
    public String bHX;
    @com.google.gson.a.c("telephone")
    public String bHY;
    @com.google.gson.a.c("bank_name")
    public String bHZ;
    @com.google.gson.a.c("bank_account")
    public String bIa;
    @com.google.gson.a.c("id")
    public long mId;
    @com.google.gson.a.c("is_default")
    public int mIsDefault;
    @com.google.gson.a.c("title")
    public String mTitle;
    @com.google.gson.a.c("type")
    public int mType;

    public InvoiceInfo() {
    }

    public InvoiceInfo(int i, String str, String str2, String str3, String str4, String str5, String str6) {
        this.mType = i;
        this.mTitle = str;
        this.bHW = str2;
        this.bHX = str3;
        this.bHY = str4;
        this.bHZ = str5;
        this.bIa = str6;
    }

    public InvoiceInfo(int i, String str, String str2) {
        this.mType = i;
        this.mTitle = str;
        this.bHY = str2;
    }

    private InvoiceInfo(Parcel parcel) {
        this.mId = parcel.readLong();
        this.mType = parcel.readInt();
        this.mTitle = parcel.readString();
        this.bHW = parcel.readString();
        this.bHX = parcel.readString();
        this.bHY = parcel.readString();
        this.bHZ = parcel.readString();
        this.bIa = parcel.readString();
        this.mIsDefault = parcel.readInt();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(this.mId);
        parcel.writeInt(this.mType);
        parcel.writeString(this.mTitle);
        parcel.writeString(this.bHW);
        parcel.writeString(this.bHX);
        parcel.writeString(this.bHY);
        parcel.writeString(this.bHZ);
        parcel.writeString(this.bIa);
        parcel.writeInt(this.mIsDefault);
    }

    public InvoiceInfo c(InvoiceInfo invoiceInfo) {
        if (invoiceInfo != null) {
            this.mId = invoiceInfo.mId;
            this.mIsDefault = invoiceInfo.mIsDefault;
        }
        return this;
    }

    public boolean equals(Object obj) {
        return (obj instanceof InvoiceInfo) && ((InvoiceInfo) obj).mId == this.mId;
    }
}
