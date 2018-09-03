package com.baidu.tbadk.editortools.inputtool;

import android.content.Context;
import android.view.View;
import com.baidu.tbadk.editortools.RawLayout;
import com.baidu.tbadk.editortools.k;
import com.baidu.tieba.f;
/* loaded from: classes.dex */
public class a extends k {
    private static final int[] aNy = {4, 17, 24, 3, 9, 6, 44};
    private InputView aNz;

    public a(Context context, boolean z) {
        super(context, (String) null, 3);
        init(context, z);
    }

    public a(Context context, boolean z, boolean z2) {
        super(context, (String) null, 3);
        init(context, z);
        if (this.aNz != null) {
            this.aNz.setNeedFaceMaxCount(z2);
        }
    }

    private void init(Context context, boolean z) {
        this.aMT = false;
        this.aMS = 2;
        this.aMU = aNy;
        this.aNz = new InputView(context, z);
        this.aMc = this.aNz;
        RawLayout.a aVar = new RawLayout.a(0, -1);
        aVar.topMargin = context.getResources().getDimensionPixelSize(f.e.ds14);
        aVar.bottomMargin = context.getResources().getDimensionPixelSize(f.e.ds14);
        aVar.leftMargin = context.getResources().getDimensionPixelSize(f.e.ds30);
        aVar.rightMargin = context.getResources().getDimensionPixelSize(f.e.ds12);
        aVar.weight = 1.0f;
        aVar.gravity = 80;
        ((View) this.aMc).setLayoutParams(aVar);
    }

    public void setIsOnlyLocalEmotion(boolean z) {
        ((InputView) this.aMc).setIsOnlyLocalEmotion(z);
    }
}
