package com.baidu.tieba.horizonalList.a.b;

import android.view.View;
import com.baidu.tieba.horizonalList.a.b;
/* loaded from: classes.dex */
public class a extends b.C0063b {
    public a(View view) {
        super(view);
    }

    @Override // com.baidu.tieba.horizonalList.a.b.C0063b, com.baidu.tieba.horizonalList.a.b.a
    public void setScrollX(int i) {
        this.view.setScrollX(i);
    }

    @Override // com.baidu.tieba.horizonalList.a.b.C0063b, com.baidu.tieba.horizonalList.a.b.a
    public boolean isHardwareAccelerated() {
        return this.view.isHardwareAccelerated();
    }
}
