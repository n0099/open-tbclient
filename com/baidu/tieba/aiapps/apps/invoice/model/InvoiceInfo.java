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
        /* renamed from: mG */
        public InvoiceInfo[] newArray(int i) {
            return new InvoiceInfo[i];
        }
    };
    public String ddq;
    public String ddr;
    public String dds;
    public String ddt;
    public String ddv;
    public long mId;
    public int mIsDefault;
    public String mTitle;
    public int mType;

    public InvoiceInfo() {
    }

    public InvoiceInfo(int i, String str, String str2, String str3, String str4, String str5, String str6) {
        this.mType = i;
        this.mTitle = str;
        this.ddq = str2;
        this.ddr = str3;
        this.dds = str4;
        this.ddt = str5;
        this.ddv = str6;
    }

    public InvoiceInfo(int i, String str, String str2) {
        this.mType = i;
        this.mTitle = str;
        this.dds = str2;
    }

    private InvoiceInfo(Parcel parcel) {
        this.mId = parcel.readLong();
        this.mType = parcel.readInt();
        this.mTitle = parcel.readString();
        this.ddq = parcel.readString();
        this.ddr = parcel.readString();
        this.dds = parcel.readString();
        this.ddt = parcel.readString();
        this.ddv = parcel.readString();
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
        parcel.writeString(this.ddq);
        parcel.writeString(this.ddr);
        parcel.writeString(this.dds);
        parcel.writeString(this.ddt);
        parcel.writeString(this.ddv);
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
            jSONObject.put("tax_number", this.ddq);
            jSONObject.put("company_address", this.ddr);
            jSONObject.put("telephone", this.dds);
            jSONObject.put("bank_name", this.ddt);
            jSONObject.put("bank_account", this.ddv);
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
            this.ddq = jSONObject.optString("tax_number");
            this.ddr = jSONObject.optString("company_address");
            this.dds = jSONObject.optString("telephone");
            this.ddt = jSONObject.optString("bank_name");
            this.ddv = jSONObject.optString("bank_account");
            this.mIsDefault = jSONObject.optInt("is_default");
        }
    }
}
