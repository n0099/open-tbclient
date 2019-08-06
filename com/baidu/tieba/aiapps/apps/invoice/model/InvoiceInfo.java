package com.baidu.tieba.aiapps.apps.invoice.model;

import android.os.Parcel;
import android.os.Parcelable;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class InvoiceInfo implements Parcelable, c {
    public static final Parcelable.Creator<InvoiceInfo> CREATOR = new Parcelable.Creator<InvoiceInfo>() { // from class: com.baidu.tieba.aiapps.apps.invoice.model.InvoiceInfo.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        /* renamed from: F */
        public InvoiceInfo createFromParcel(Parcel parcel) {
            return new InvoiceInfo(parcel);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        /* renamed from: mH */
        public InvoiceInfo[] newArray(int i) {
            return new InvoiceInfo[i];
        }
    };
    public String ddA;
    public String ddB;
    public String ddC;
    public String ddy;
    public String ddz;
    public long mId;
    public int mIsDefault;
    public String mTitle;
    public int mType;

    public InvoiceInfo() {
    }

    public InvoiceInfo(int i, String str, String str2, String str3, String str4, String str5, String str6) {
        this.mType = i;
        this.mTitle = str;
        this.ddy = str2;
        this.ddz = str3;
        this.ddA = str4;
        this.ddB = str5;
        this.ddC = str6;
    }

    public InvoiceInfo(int i, String str, String str2) {
        this.mType = i;
        this.mTitle = str;
        this.ddA = str2;
    }

    private InvoiceInfo(Parcel parcel) {
        this.mId = parcel.readLong();
        this.mType = parcel.readInt();
        this.mTitle = parcel.readString();
        this.ddy = parcel.readString();
        this.ddz = parcel.readString();
        this.ddA = parcel.readString();
        this.ddB = parcel.readString();
        this.ddC = parcel.readString();
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
        parcel.writeString(this.ddy);
        parcel.writeString(this.ddz);
        parcel.writeString(this.ddA);
        parcel.writeString(this.ddB);
        parcel.writeString(this.ddC);
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

    public JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("id", this.mId);
            jSONObject.put("type", this.mType);
            jSONObject.put("title", this.mTitle);
            jSONObject.put("tax_number", this.ddy);
            jSONObject.put("company_address", this.ddz);
            jSONObject.put("telephone", this.ddA);
            jSONObject.put("bank_name", this.ddB);
            jSONObject.put("bank_account", this.ddC);
            jSONObject.put("is_default", this.mIsDefault);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    @Override // com.baidu.tieba.aiapps.apps.invoice.model.c
    public void bh(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.mId = jSONObject.optLong("id");
            this.mType = jSONObject.optInt("type");
            this.mTitle = jSONObject.optString("title");
            this.ddy = jSONObject.optString("tax_number");
            this.ddz = jSONObject.optString("company_address");
            this.ddA = jSONObject.optString("telephone");
            this.ddB = jSONObject.optString("bank_name");
            this.ddC = jSONObject.optString("bank_account");
            this.mIsDefault = jSONObject.optInt("is_default");
        }
    }
}
