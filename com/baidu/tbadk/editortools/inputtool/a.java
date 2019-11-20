package com.baidu.tbadk.editortools.inputtool;

import android.content.Context;
import android.view.View;
import com.baidu.tbadk.editortools.RawLayout;
import com.baidu.tbadk.editortools.k;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class a extends k {
    private static final int[] cFL = {4, 17, 24, 3, 9, 6, 44};
    private InputView cFM;

    public a(Context context, boolean z) {
        super(context, (String) null, 3);
        init(context, z);
    }

    public a(Context context, boolean z, boolean z2) {
        super(context, (String) null, 3);
        init(context, z);
        if (this.cFM != null) {
            this.cFM.setNeedFaceMaxCount(z2);
        }
    }

    private void init(Context context, boolean z) {
        this.cFg = false;
        this.cFf = 2;
        this.cFh = cFL;
        this.cFM = new InputView(context, z);
        this.cEn = this.cFM;
        RawLayout.a aVar = new RawLayout.a(0, -1);
        aVar.topMargin = context.getResources().getDimensionPixelSize(R.dimen.ds14);
        aVar.bottomMargin = context.getResources().getDimensionPixelSize(R.dimen.ds14);
        aVar.leftMargin = context.getResources().getDimensionPixelSize(R.dimen.ds30);
        aVar.rightMargin = context.getResources().getDimensionPixelSize(R.dimen.ds12);
        aVar.weight = 1.0f;
        aVar.gravity = 80;
        ((View) this.cEn).setLayoutParams(aVar);
    }

    public void setIsOnlyLocalEmotion(boolean z) {
        ((InputView) this.cEn).setIsOnlyLocalEmotion(z);
    }
}
