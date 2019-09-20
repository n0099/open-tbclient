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
        /* renamed from: mL */
        public InvoiceInfo[] newArray(int i) {
            return new InvoiceInfo[i];
        }
    };
    public String dfk;
    public String dfl;
    public String dfm;
    public String dfn;
    public String dfo;
    public long mId;
    public int mIsDefault;
    public String mTitle;
    public int mType;

    public InvoiceInfo() {
    }

    public InvoiceInfo(int i, String str, String str2, String str3, String str4, String str5, String str6) {
        this.mType = i;
        this.mTitle = str;
        this.dfk = str2;
        this.dfl = str3;
        this.dfm = str4;
        this.dfn = str5;
        this.dfo = str6;
    }

    public InvoiceInfo(int i, String str, String str2) {
        this.mType = i;
        this.mTitle = str;
        this.dfm = str2;
    }

    private InvoiceInfo(Parcel parcel) {
        this.mId = parcel.readLong();
        this.mType = parcel.readInt();
        this.mTitle = parcel.readString();
        this.dfk = parcel.readString();
        this.dfl = parcel.readString();
        this.dfm = parcel.readString();
        this.dfn = parcel.readString();
        this.dfo = parcel.readString();
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
        parcel.writeString(this.dfk);
        parcel.writeString(this.dfl);
        parcel.writeString(this.dfm);
        parcel.writeString(this.dfn);
        parcel.writeString(this.dfo);
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
            jSONObject.put("tax_number", this.dfk);
            jSONObject.put("company_address", this.dfl);
            jSONObject.put("telephone", this.dfm);
            jSONObject.put("bank_name", this.dfn);
            jSONObject.put("bank_account", this.dfo);
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
            this.dfk = jSONObject.optString("tax_number");
            this.dfl = jSONObject.optString("company_address");
            this.dfm = jSONObject.optString("telephone");
            this.dfn = jSONObject.optString("bank_name");
            this.dfo = jSONObject.optString("bank_account");
            this.mIsDefault = jSONObject.optInt("is_default");
        }
    }
}
