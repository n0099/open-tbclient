package com.baidu.tieba.homepage.tabfeed.data;

import android.os.Parcel;
import android.os.Parcelable;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.util.ListUtils;
import d.b.h0.r.q.a2;
import d.b.h0.r.q.v0;
import java.util.ArrayList;
import java.util.List;
import tbclient.ActivityPage.SpecialColumn;
import tbclient.ActivityPage.SpecialColumnList;
/* loaded from: classes4.dex */
public class SpecialColumnListData extends d.b.h0.r.q.a implements Parcelable {
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
        public SpecialColumnListData[] newArray(int i) {
            return new SpecialColumnListData[i];
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

    @Override // d.b.h0.r.q.a
    public v0 g() {
        return null;
    }

    @Override // com.baidu.tieba.card.data.BaseCardInfo, d.b.b.j.e.n
    public BdUniqueId getType() {
        return TYPE;
    }

    @Override // d.b.h0.r.q.a
    public a2 n() {
        return null;
    }

    public void parserProtobuf(List<SpecialColumn> list) {
        if (list != null) {
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < list.size(); i++) {
                SpecialColumnItemData specialColumnItemData = new SpecialColumnItemData();
                specialColumnItemData.a(list.get(i));
                arrayList.add(specialColumnItemData);
            }
            this.mResultListData.addAll(arrayList);
            this.mListData.addAll(ListUtils.trimToSize(arrayList, 3));
        }
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
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
