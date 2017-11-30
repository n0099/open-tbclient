package com.baidu.tbadk.editortools.inputtool;

import android.content.Context;
import android.view.View;
import com.baidu.tbadk.editortools.p;
import com.baidu.tbadk.editortools.r;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class a extends r {
    private static final int[] aDl = {4, 17, 24, 3, 9, 6, 44};
    private InputView aDm;

    public a(Context context, boolean z) {
        super(context, (String) null, 3);
        init(context, z);
    }

    public a(Context context, boolean z, boolean z2) {
        super(context, (String) null, 3);
        init(context, z);
        if (this.aDm != null) {
            this.aDm.setNeedFaceMaxCount(z2);
        }
    }

    private void init(Context context, boolean z) {
        this.aCF = false;
        this.aCE = 2;
        this.aCG = aDl;
        this.aDm = new InputView(context, z);
        this.aBO = this.aDm;
        p.a aVar = new p.a(0, -1);
        aVar.topMargin = context.getResources().getDimensionPixelSize(d.e.ds14);
        aVar.bottomMargin = context.getResources().getDimensionPixelSize(d.e.ds14);
        aVar.leftMargin = context.getResources().getDimensionPixelSize(d.e.ds30);
        aVar.rightMargin = context.getResources().getDimensionPixelSize(d.e.ds12);
        aVar.weight = 1.0f;
        aVar.gravity = 80;
        ((View) this.aBO).setLayoutParams(aVar);
    }

    public void setIsOnlyLocalEmotion(boolean z) {
        ((InputView) this.aBO).setIsOnlyLocalEmotion(z);
    }
}
