package com.baidu.tieba.ala.alasquare.special_forum.data;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class SpecialLiveTabInfo implements Parcelable {
    public static final Parcelable.Creator<SpecialLiveTabInfo> CREATOR = new Parcelable.Creator<SpecialLiveTabInfo>() { // from class: com.baidu.tieba.ala.alasquare.special_forum.data.SpecialLiveTabInfo.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        /* renamed from: Z */
        public SpecialLiveTabInfo createFromParcel(Parcel parcel) {
            return new SpecialLiveTabInfo(parcel);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        /* renamed from: ot */
        public SpecialLiveTabInfo[] newArray(int i) {
            return new SpecialLiveTabInfo[i];
        }
    };
    public List<String> sortTypeList;
    public int tabId;
    public String tabName;
    public int tabType;

    public SpecialLiveTabInfo() {
    }

    public SpecialLiveTabInfo(Parcel parcel) {
        this.tabId = parcel.readInt();
        this.tabName = parcel.readString();
        this.tabType = parcel.readInt();
        this.sortTypeList = parcel.createStringArrayList();
    }

    public void parse(JSONObject jSONObject) throws JSONException {
        if (jSONObject != null) {
            this.tabId = jSONObject.optInt("tab_id");
            this.tabName = jSONObject.optString("tab_name");
            this.tabType = jSONObject.optInt("icon_type");
            JSONArray optJSONArray = jSONObject.optJSONArray("live_tab_type");
            if (optJSONArray != null && optJSONArray.length() > 0) {
                int length = optJSONArray.length();
                this.sortTypeList = new ArrayList(length);
                for (int i = 0; i < length; i++) {
                    this.sortTypeList.add(optJSONArray.optString(i));
                }
            }
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 1;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.tabId);
        parcel.writeString(this.tabName);
        parcel.writeInt(this.tabType);
        parcel.writeStringList(this.sortTypeList);
    }
}
