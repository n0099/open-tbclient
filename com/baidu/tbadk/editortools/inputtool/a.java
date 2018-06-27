package com.baidu.tbadk.editortools.inputtool;

import android.content.Context;
import android.view.View;
import com.baidu.tbadk.editortools.RawLayout;
import com.baidu.tbadk.editortools.k;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class a extends k {
    private static final int[] aNB = {4, 17, 24, 3, 9, 6, 44};
    private InputView aNC;

    public a(Context context, boolean z) {
        super(context, (String) null, 3);
        init(context, z);
    }

    public a(Context context, boolean z, boolean z2) {
        super(context, (String) null, 3);
        init(context, z);
        if (this.aNC != null) {
            this.aNC.setNeedFaceMaxCount(z2);
        }
    }

    private void init(Context context, boolean z) {
        this.aMW = false;
        this.aMV = 2;
        this.aMX = aNB;
        this.aNC = new InputView(context, z);
        this.aMf = this.aNC;
        RawLayout.a aVar = new RawLayout.a(0, -1);
        aVar.topMargin = context.getResources().getDimensionPixelSize(d.e.ds14);
        aVar.bottomMargin = context.getResources().getDimensionPixelSize(d.e.ds14);
        aVar.leftMargin = context.getResources().getDimensionPixelSize(d.e.ds30);
        aVar.rightMargin = context.getResources().getDimensionPixelSize(d.e.ds12);
        aVar.weight = 1.0f;
        aVar.gravity = 80;
        ((View) this.aMf).setLayoutParams(aVar);
    }

    public void setIsOnlyLocalEmotion(boolean z) {
        ((InputView) this.aMf).setIsOnlyLocalEmotion(z);
    }
}
