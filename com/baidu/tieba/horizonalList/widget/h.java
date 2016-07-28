package com.baidu.tieba.horizonalList.widget;

import android.os.Parcel;
import android.os.Parcelable;
import com.baidu.tieba.horizonalList.widget.ExpandableHListConnector;
/* loaded from: classes.dex */
class h implements Parcelable.Creator<ExpandableHListConnector.GroupMetadata> {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.os.Parcelable.Creator
    /* renamed from: l */
    public ExpandableHListConnector.GroupMetadata createFromParcel(Parcel parcel) {
        return ExpandableHListConnector.GroupMetadata.a(parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readLong());
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.os.Parcelable.Creator
    /* renamed from: jW */
    public ExpandableHListConnector.GroupMetadata[] newArray(int i) {
        return new ExpandableHListConnector.GroupMetadata[i];
    }
}
