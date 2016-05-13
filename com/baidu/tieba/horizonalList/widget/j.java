package com.baidu.tieba.horizonalList.widget;

import android.os.Parcel;
import android.os.Parcelable;
import com.baidu.tieba.horizonalList.widget.ExpandableHListView;
/* loaded from: classes.dex */
class j implements Parcelable.Creator<ExpandableHListView.SavedState> {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.os.Parcelable.Creator
    /* renamed from: i */
    public ExpandableHListView.SavedState createFromParcel(Parcel parcel) {
        return new ExpandableHListView.SavedState(parcel, (ExpandableHListView.SavedState) null);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.os.Parcelable.Creator
    /* renamed from: iw */
    public ExpandableHListView.SavedState[] newArray(int i) {
        return new ExpandableHListView.SavedState[i];
    }
}
