package com.baidu.tieba.homepage.tabfeed.data;

import android.os.Parcel;
import android.os.Parcelable;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.q;
import tbclient.ActivityPage.SpecialColumn;
/* loaded from: classes21.dex */
public class SpecialColumnItemData implements Parcelable, q {
    public static final int TYPE_LIVE = 3;
    public static final int TYPE_LIVE_RE = 4;
    public static final int TYPE_NORMAL = 1;
    public static final int TYPE_VIDEO = 2;
    public int agree_num;
    public int freq_num;
    public String image;
    public long liveId;
    public int specialType;
    public String text;
    public long threadId;
    public String title;
    public static final BdUniqueId TYPE = BdUniqueId.gen();
    public static final Parcelable.Creator<SpecialColumnItemData> CREATOR = new Parcelable.Creator<SpecialColumnItemData>() { // from class: com.baidu.tieba.homepage.tabfeed.data.SpecialColumnItemData.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        /* renamed from: Y */
        public SpecialColumnItemData createFromParcel(Parcel parcel) {
            return new SpecialColumnItemData(parcel);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        /* renamed from: AC */
        public SpecialColumnItemData[] newArray(int i) {
            return new SpecialColumnItemData[i];
        }
    };

    public void a(SpecialColumn specialColumn) {
        this.specialType = specialColumn.type.intValue();
        this.threadId = specialColumn.thread_id.longValue();
        this.liveId = specialColumn.live_id.longValue();
        this.title = specialColumn.title;
        this.image = specialColumn.image;
        this.text = specialColumn.text;
        this.freq_num = specialColumn.freq_num.intValue();
        this.agree_num = specialColumn.agree_num.intValue();
    }

    @Override // com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return TYPE;
    }

    public SpecialColumnItemData() {
    }

    public SpecialColumnItemData(Parcel parcel) {
        this.specialType = parcel.readInt();
        this.threadId = parcel.readLong();
        this.liveId = parcel.readLong();
        this.title = parcel.readString();
        this.image = parcel.readString();
        this.text = parcel.readString();
        this.freq_num = parcel.readInt();
        this.agree_num = parcel.readInt();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.specialType);
        parcel.writeLong(this.threadId);
        parcel.writeLong(this.liveId);
        parcel.writeString(this.title);
        parcel.writeString(this.image);
        parcel.writeString(this.text);
        parcel.writeInt(this.freq_num);
        parcel.writeInt(this.agree_num);
    }
}
