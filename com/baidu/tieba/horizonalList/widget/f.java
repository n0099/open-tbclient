package com.baidu.tieba.horizonalList.widget;

import android.os.Parcel;
import android.os.Parcelable;
import com.baidu.tieba.horizonalList.widget.AbsHListView;
/* loaded from: classes.dex */
class f implements Parcelable.Creator<AbsHListView.SavedState> {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.os.Parcelable.Creator
    /* renamed from: k */
    public AbsHListView.SavedState createFromParcel(Parcel parcel) {
        return new AbsHListView.SavedState(parcel, null);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.os.Parcelable.Creator
    /* renamed from: kx */
    public AbsHListView.SavedState[] newArray(int i) {
        return new AbsHListView.SavedState[i];
    }
}
