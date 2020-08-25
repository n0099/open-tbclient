package com.baidu.tieba.horizonalList.a.b;

import android.annotation.TargetApi;
import android.view.View;
import com.baidu.tieba.horizonalList.a.a;
/* loaded from: classes2.dex */
public class a extends a.b {
    public a(View view) {
        super(view);
    }

    @Override // com.baidu.tieba.horizonalList.a.a.b, com.baidu.tieba.horizonalList.a.a.AbstractC0702a
    @TargetApi(14)
    public void setScrollX(int i) {
        this.view.setScrollX(i);
    }

    @Override // com.baidu.tieba.horizonalList.a.a.b, com.baidu.tieba.horizonalList.a.a.AbstractC0702a
    @TargetApi(11)
    public boolean isHardwareAccelerated() {
        return this.view.isHardwareAccelerated();
    }
}
