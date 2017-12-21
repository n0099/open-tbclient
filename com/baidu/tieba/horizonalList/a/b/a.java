package com.baidu.tieba.horizonalList.a.b;

import android.annotation.TargetApi;
import android.view.View;
import com.baidu.tieba.horizonalList.a.b;
/* loaded from: classes.dex */
public class a extends b.C0104b {
    public a(View view) {
        super(view);
    }

    @Override // com.baidu.tieba.horizonalList.a.b.C0104b, com.baidu.tieba.horizonalList.a.b.a
    @TargetApi(14)
    public void setScrollX(int i) {
        this.view.setScrollX(i);
    }

    @Override // com.baidu.tieba.horizonalList.a.b.C0104b, com.baidu.tieba.horizonalList.a.b.a
    @TargetApi(11)
    public boolean isHardwareAccelerated() {
        return this.view.isHardwareAccelerated();
    }
}
