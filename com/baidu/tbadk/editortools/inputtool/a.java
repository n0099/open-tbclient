package com.baidu.tbadk.editortools.inputtool;

import android.content.Context;
import android.view.View;
import com.baidu.tbadk.editortools.RawLayout;
import com.baidu.tbadk.editortools.k;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class a extends k {
    private static final int[] csc = {4, 17, 24, 3, 9, 6, 44};
    private InputView csd;

    public a(Context context, boolean z) {
        super(context, (String) null, 3);
        init(context, z);
    }

    public a(Context context, boolean z, boolean z2) {
        super(context, (String) null, 3);
        init(context, z);
        if (this.csd != null) {
            this.csd.setNeedFaceMaxCount(z2);
        }
    }

    private void init(Context context, boolean z) {
        this.crx = false;
        this.crw = 2;
        this.cry = csc;
        this.csd = new InputView(context, z);
        this.cqE = this.csd;
        RawLayout.a aVar = new RawLayout.a(0, -1);
        aVar.topMargin = context.getResources().getDimensionPixelSize(R.dimen.ds14);
        aVar.bottomMargin = context.getResources().getDimensionPixelSize(R.dimen.ds14);
        aVar.leftMargin = context.getResources().getDimensionPixelSize(R.dimen.ds30);
        aVar.rightMargin = context.getResources().getDimensionPixelSize(R.dimen.ds12);
        aVar.weight = 1.0f;
        aVar.gravity = 80;
        ((View) this.cqE).setLayoutParams(aVar);
    }

    public void setIsOnlyLocalEmotion(boolean z) {
        ((InputView) this.cqE).setIsOnlyLocalEmotion(z);
    }
}
