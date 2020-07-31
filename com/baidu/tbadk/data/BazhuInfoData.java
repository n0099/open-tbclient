package com.baidu.tbadk.data;

import android.os.Parcel;
import android.os.Parcelable;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class BazhuInfoData extends OrmObject {
    public ArrayList<BaInfo> bazhu_info;

    /* loaded from: classes.dex */
    public static class BaInfo extends OrmObject implements Parcelable {
        public static final Parcelable.Creator<BaInfo> CREATOR = new Parcelable.Creator<BaInfo>() { // from class: com.baidu.tbadk.data.BazhuInfoData.BaInfo.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.os.Parcelable.Creator
            /* renamed from: Q */
            public BaInfo createFromParcel(Parcel parcel) {
                return new BaInfo(parcel);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.os.Parcelable.Creator
            /* renamed from: nK */
            public BaInfo[] newArray(int i) {
                return new BaInfo[i];
            }
        };
        public String forum_Avatar;
        public int forum_id;
        public String forum_name;
        public boolean isChecked;

        public BaInfo() {
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.forum_id);
            parcel.writeString(this.forum_name);
            parcel.writeString(this.forum_Avatar);
            parcel.writeByte(this.isChecked ? (byte) 1 : (byte) 0);
        }

        protected BaInfo(Parcel parcel) {
            this.forum_id = parcel.readInt();
            this.forum_name = parcel.readString();
            this.forum_Avatar = parcel.readString();
            this.isChecked = parcel.readByte() != 0;
        }
    }
}
