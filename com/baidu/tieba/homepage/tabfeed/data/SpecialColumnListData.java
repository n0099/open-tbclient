package com.baidu.tieba.homepage.tabfeed.data;

import android.os.Parcel;
import android.os.Parcelable;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.AbsThreadDataSupport;
import com.baidu.tbadk.core.data.ar;
import com.baidu.tbadk.core.data.bw;
import com.baidu.tbadk.core.util.y;
import java.util.ArrayList;
import java.util.List;
import tbclient.ActivityPage.SpecialColumn;
import tbclient.ActivityPage.SpecialColumnList;
/* loaded from: classes16.dex */
public class SpecialColumnListData extends AbsThreadDataSupport implements Parcelable {
    public static final int MAX_SIZE = 3;
    private List<SpecialColumnItemData> mListData;
    private List<SpecialColumnItemData> mResultListData;
    public String title;
    public static final BdUniqueId TYPE = BdUniqueId.gen();
    public static final Parcelable.Creator<SpecialColumnListData> CREATOR = new Parcelable.Creator<SpecialColumnListData>() { // from class: com.baidu.tieba.homepage.tabfeed.data.SpecialColumnListData.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        /* renamed from: Z */
        public SpecialColumnListData createFromParcel(Parcel parcel) {
            return new SpecialColumnListData(parcel);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        /* renamed from: Ac */
        public SpecialColumnListData[] newArray(int i) {
            return new SpecialColumnListData[i];
        }
    };

    public SpecialColumnListData() {
        this.mListData = new ArrayList();
        this.mResultListData = new ArrayList();
    }

    public void a(SpecialColumnList specialColumnList) {
        if (specialColumnList != null) {
            this.floorPosition = specialColumnList.floor_position.intValue();
            this.title = specialColumnList.special_column_name;
            parserProtobuf(specialColumnList.item_list);
        }
    }

    public void parserProtobuf(List<SpecialColumn> list) {
        if (list != null) {
            ArrayList arrayList = new ArrayList();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < list.size()) {
                    SpecialColumnItemData specialColumnItemData = new SpecialColumnItemData();
                    specialColumnItemData.a(list.get(i2));
                    arrayList.add(specialColumnItemData);
                    i = i2 + 1;
                } else {
                    this.mResultListData.addAll(arrayList);
                    this.mListData.addAll(y.trimToSize(arrayList, 3));
                    return;
                }
            }
        }
    }

    public SpecialColumnListData(Parcel parcel) {
        this.title = parcel.readString();
        this.mListData = parcel.createTypedArrayList(SpecialColumnItemData.CREATOR);
        this.mResultListData = parcel.createTypedArrayList(SpecialColumnItemData.CREATOR);
    }

    @Override // com.baidu.tieba.card.data.b, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return TYPE;
    }

    @Override // com.baidu.tbadk.core.data.AbsThreadDataSupport
    public bw bce() {
        return null;
    }

    @Override // com.baidu.tbadk.core.data.AbsThreadDataSupport
    public ar bcg() {
        return null;
    }

    public List<SpecialColumnItemData> cyS() {
        return this.mListData;
    }

    public String getTitle() {
        return this.title;
    }

    public List<SpecialColumnItemData> bGi() {
        return this.mResultListData;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.title);
        parcel.writeTypedList(this.mListData);
        parcel.writeTypedList(this.mResultListData);
    }
}
