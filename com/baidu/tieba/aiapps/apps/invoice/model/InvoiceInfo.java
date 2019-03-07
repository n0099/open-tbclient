package com.baidu.tieba.aiapps.apps.invoice.model;

import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes4.dex */
public class InvoiceInfo implements Parcelable {
    public static final Parcelable.Creator<InvoiceInfo> CREATOR = new Parcelable.Creator<InvoiceInfo>() { // from class: com.baidu.tieba.aiapps.apps.invoice.model.InvoiceInfo.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        /* renamed from: C */
        public InvoiceInfo createFromParcel(Parcel parcel) {
            return new InvoiceInfo(parcel);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        /* renamed from: lN */
        public InvoiceInfo[] newArray(int i) {
            return new InvoiceInfo[i];
        }
    };
    @com.google.gson.a.c("bank_account")
    public String cTA;
    @com.google.gson.a.c("tax_number")
    public String cTw;
    @com.google.gson.a.c("company_address")
    public String cTx;
    @com.google.gson.a.c("telephone")
    public String cTy;
    @com.google.gson.a.c("bank_name")
    public String cTz;
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
        this.cTw = str2;
        this.cTx = str3;
        this.cTy = str4;
        this.cTz = str5;
        this.cTA = str6;
    }

    public InvoiceInfo(int i, String str, String str2) {
        this.mType = i;
        this.mTitle = str;
        this.cTy = str2;
    }

    private InvoiceInfo(Parcel parcel) {
        this.mId = parcel.readLong();
        this.mType = parcel.readInt();
        this.mTitle = parcel.readString();
        this.cTw = parcel.readString();
        this.cTx = parcel.readString();
        this.cTy = parcel.readString();
        this.cTz = parcel.readString();
        this.cTA = parcel.readString();
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
        parcel.writeString(this.cTw);
        parcel.writeString(this.cTx);
        parcel.writeString(this.cTy);
        parcel.writeString(this.cTz);
        parcel.writeString(this.cTA);
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
