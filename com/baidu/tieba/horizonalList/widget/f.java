package com.baidu.tieba.horizonalList.widget;

import android.os.Parcel;
import android.os.Parcelable;
import com.baidu.tieba.horizonalList.widget.AbsHListView;
/* loaded from: classes.dex */
class f implements Parcelable.Creator<AbsHListView.SavedState> {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.os.Parcelable.Creator
    /* renamed from: i */
    public AbsHListView.SavedState createFromParcel(Parcel parcel) {
        return new AbsHListView.SavedState(parcel, null);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.os.Parcelable.Creator
    /* renamed from: km */
    public AbsHListView.SavedState[] newArray(int i) {
        return new AbsHListView.SavedState[i];
    }
}
