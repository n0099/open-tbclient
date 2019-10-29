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
        /* renamed from: N */
        public InvoiceInfo createFromParcel(Parcel parcel) {
            return new InvoiceInfo(parcel);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        /* renamed from: lQ */
        public InvoiceInfo[] newArray(int i) {
            return new InvoiceInfo[i];
        }
    };
    public String doF;
    public String doG;
    public String doH;
    public String doI;
    public String doJ;
    public long mId;
    public int mIsDefault;
    public String mTitle;
    public int mType;

    public InvoiceInfo() {
    }

    public InvoiceInfo(int i, String str, String str2, String str3, String str4, String str5, String str6) {
        this.mType = i;
        this.mTitle = str;
        this.doF = str2;
        this.doG = str3;
        this.doH = str4;
        this.doI = str5;
        this.doJ = str6;
    }

    public InvoiceInfo(int i, String str, String str2) {
        this.mType = i;
        this.mTitle = str;
        this.doH = str2;
    }

    private InvoiceInfo(Parcel parcel) {
        this.mId = parcel.readLong();
        this.mType = parcel.readInt();
        this.mTitle = parcel.readString();
        this.doF = parcel.readString();
        this.doG = parcel.readString();
        this.doH = parcel.readString();
        this.doI = parcel.readString();
        this.doJ = parcel.readString();
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
        parcel.writeString(this.doF);
        parcel.writeString(this.doG);
        parcel.writeString(this.doH);
        parcel.writeString(this.doI);
        parcel.writeString(this.doJ);
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
            jSONObject.put("tax_number", this.doF);
            jSONObject.put("company_address", this.doG);
            jSONObject.put("telephone", this.doH);
            jSONObject.put("bank_name", this.doI);
            jSONObject.put("bank_account", this.doJ);
            jSONObject.put("is_default", this.mIsDefault);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    @Override // com.baidu.tieba.aiapps.apps.invoice.model.c
    public void bE(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.mId = jSONObject.optLong("id");
            this.mType = jSONObject.optInt("type");
            this.mTitle = jSONObject.optString("title");
            this.doF = jSONObject.optString("tax_number");
            this.doG = jSONObject.optString("company_address");
            this.doH = jSONObject.optString("telephone");
            this.doI = jSONObject.optString("bank_name");
            this.doJ = jSONObject.optString("bank_account");
            this.mIsDefault = jSONObject.optInt("is_default");
        }
    }
}
