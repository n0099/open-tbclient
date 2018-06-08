package com.baidu.tbadk.editortools.inputtool;

import android.content.Context;
import android.view.View;
import com.baidu.tbadk.editortools.RawLayout;
import com.baidu.tbadk.editortools.k;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class a extends k {
    private static final int[] aMF = {4, 17, 24, 3, 9, 6, 44};
    private InputView aMG;

    public a(Context context, boolean z) {
        super(context, (String) null, 3);
        init(context, z);
    }

    public a(Context context, boolean z, boolean z2) {
        super(context, (String) null, 3);
        init(context, z);
        if (this.aMG != null) {
            this.aMG.setNeedFaceMaxCount(z2);
        }
    }

    private void init(Context context, boolean z) {
        this.aMa = false;
        this.aLZ = 2;
        this.aMb = aMF;
        this.aMG = new InputView(context, z);
        this.aLj = this.aMG;
        RawLayout.a aVar = new RawLayout.a(0, -1);
        aVar.topMargin = context.getResources().getDimensionPixelSize(d.e.ds14);
        aVar.bottomMargin = context.getResources().getDimensionPixelSize(d.e.ds14);
        aVar.leftMargin = context.getResources().getDimensionPixelSize(d.e.ds30);
        aVar.rightMargin = context.getResources().getDimensionPixelSize(d.e.ds12);
        aVar.weight = 1.0f;
        aVar.gravity = 80;
        ((View) this.aLj).setLayoutParams(aVar);
    }

    public void setIsOnlyLocalEmotion(boolean z) {
        ((InputView) this.aLj).setIsOnlyLocalEmotion(z);
    }
}
