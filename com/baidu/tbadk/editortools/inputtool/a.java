package com.baidu.tbadk.editortools.inputtool;

import android.content.Context;
import android.view.View;
import com.baidu.tbadk.editortools.RawLayout;
import com.baidu.tbadk.editortools.k;
import com.baidu.tieba.e;
/* loaded from: classes.dex */
public class a extends k {
    private static final int[] aZH = {4, 17, 24, 3, 9, 6, 44};
    private InputView aZI;

    public a(Context context, boolean z) {
        super(context, (String) null, 3);
        init(context, z);
    }

    public a(Context context, boolean z, boolean z2) {
        super(context, (String) null, 3);
        init(context, z);
        if (this.aZI != null) {
            this.aZI.setNeedFaceMaxCount(z2);
        }
    }

    private void init(Context context, boolean z) {
        this.aZc = false;
        this.aZb = 2;
        this.aZd = aZH;
        this.aZI = new InputView(context, z);
        this.aYl = this.aZI;
        RawLayout.a aVar = new RawLayout.a(0, -1);
        aVar.topMargin = context.getResources().getDimensionPixelSize(e.C0210e.ds14);
        aVar.bottomMargin = context.getResources().getDimensionPixelSize(e.C0210e.ds14);
        aVar.leftMargin = context.getResources().getDimensionPixelSize(e.C0210e.ds30);
        aVar.rightMargin = context.getResources().getDimensionPixelSize(e.C0210e.ds12);
        aVar.weight = 1.0f;
        aVar.gravity = 80;
        ((View) this.aYl).setLayoutParams(aVar);
    }

    public void setIsOnlyLocalEmotion(boolean z) {
        ((InputView) this.aYl).setIsOnlyLocalEmotion(z);
    }
}
