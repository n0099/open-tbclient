package com.baidu.tieba.homepage.framework.indicator;

import android.os.Parcel;
import android.os.Parcelable;
import com.baidu.tieba.homepage.framework.indicator.PagerSlidingTabStrip;
/* loaded from: classes.dex */
class g implements Parcelable.Creator<PagerSlidingTabStrip.SavedState> {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.os.Parcelable.Creator
    /* renamed from: h */
    public PagerSlidingTabStrip.SavedState createFromParcel(Parcel parcel) {
        return new PagerSlidingTabStrip.SavedState(parcel, null);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.os.Parcelable.Creator
    /* renamed from: jK */
    public PagerSlidingTabStrip.SavedState[] newArray(int i) {
        return new PagerSlidingTabStrip.SavedState[i];
    }
}
