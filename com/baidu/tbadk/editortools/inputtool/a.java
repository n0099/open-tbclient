package com.baidu.tbadk.editortools.inputtool;

import android.content.Context;
import android.view.View;
import com.baidu.tbadk.editortools.RawLayout;
import com.baidu.tbadk.editortools.k;
import com.baidu.tieba.e;
/* loaded from: classes.dex */
public class a extends k {
    private static final int[] aQQ = {4, 17, 24, 3, 9, 6, 44};
    private InputView aQR;

    public a(Context context, boolean z) {
        super(context, (String) null, 3);
        init(context, z);
    }

    public a(Context context, boolean z, boolean z2) {
        super(context, (String) null, 3);
        init(context, z);
        if (this.aQR != null) {
            this.aQR.setNeedFaceMaxCount(z2);
        }
    }

    private void init(Context context, boolean z) {
        this.aQl = false;
        this.aQk = 2;
        this.aQm = aQQ;
        this.aQR = new InputView(context, z);
        this.aPu = this.aQR;
        RawLayout.a aVar = new RawLayout.a(0, -1);
        aVar.topMargin = context.getResources().getDimensionPixelSize(e.C0141e.ds14);
        aVar.bottomMargin = context.getResources().getDimensionPixelSize(e.C0141e.ds14);
        aVar.leftMargin = context.getResources().getDimensionPixelSize(e.C0141e.ds30);
        aVar.rightMargin = context.getResources().getDimensionPixelSize(e.C0141e.ds12);
        aVar.weight = 1.0f;
        aVar.gravity = 80;
        ((View) this.aPu).setLayoutParams(aVar);
    }

    public void setIsOnlyLocalEmotion(boolean z) {
        ((InputView) this.aPu).setIsOnlyLocalEmotion(z);
    }
}
