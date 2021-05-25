package com.baidu.tieba.homepage.tabfeed.data;

import android.os.Parcel;
import android.os.Parcelable;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.util.ListUtils;
import d.a.m0.r.q.a2;
import d.a.m0.r.q.v0;
import java.util.ArrayList;
import java.util.List;
import tbclient.ActivityPage.SpecialColumn;
import tbclient.ActivityPage.SpecialColumnList;
/* loaded from: classes4.dex */
public class SpecialColumnListData extends d.a.m0.r.q.a implements Parcelable {
    public static final int MAX_SIZE = 3;
    public List<SpecialColumnItemData> mListData;
    public List<SpecialColumnItemData> mResultListData;
    public String title;
    public static final BdUniqueId TYPE = BdUniqueId.gen();
    public static final Parcelable.Creator<SpecialColumnListData> CREATOR = new a();

    /* loaded from: classes4.dex */
    public static class a implements Parcelable.Creator<SpecialColumnListData> {
        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public SpecialColumnListData createFromParcel(Parcel parcel) {
            return new SpecialColumnListData(parcel);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public SpecialColumnListData[] newArray(int i2) {
            return new SpecialColumnListData[i2];
        }
    }

    public SpecialColumnListData() {
        this.mListData = new ArrayList();
        this.mResultListData = new ArrayList();
    }

    public List<SpecialColumnItemData> A() {
        return this.mResultListData;
    }

    public String B() {
        return this.title;
    }

    public void C(SpecialColumnList specialColumnList) {
        if (specialColumnList == null) {
            return;
        }
        this.floorPosition = specialColumnList.floor_position.intValue();
        this.title = specialColumnList.special_column_name;
        parserProtobuf(specialColumnList.item_list);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.baidu.tieba.card.data.BaseCardInfo, d.a.c.j.e.n
    public BdUniqueId getType() {
        return TYPE;
    }

    @Override // d.a.m0.r.q.a
    public v0 h() {
        return null;
    }

    @Override // d.a.m0.r.q.a
    public a2 m() {
        return null;
    }

    public void parserProtobuf(List<SpecialColumn> list) {
        if (list != null) {
            ArrayList arrayList = new ArrayList();
            for (int i2 = 0; i2 < list.size(); i2++) {
                SpecialColumnItemData specialColumnItemData = new SpecialColumnItemData();
                specialColumnItemData.c(list.get(i2));
                arrayList.add(specialColumnItemData);
            }
            this.mResultListData.addAll(arrayList);
            this.mListData.addAll(ListUtils.trimToSize(arrayList, 3));
        }
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.title);
        parcel.writeTypedList(this.mListData);
        parcel.writeTypedList(this.mResultListData);
    }

    public List<SpecialColumnItemData> z() {
        return this.mListData;
    }

    public SpecialColumnListData(Parcel parcel) {
        this.title = parcel.readString();
        this.mListData = parcel.createTypedArrayList(SpecialColumnItemData.CREATOR);
        this.mResultListData = parcel.createTypedArrayList(SpecialColumnItemData.CREATOR);
    }
}
