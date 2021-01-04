package com.baidu.tbadk.editortools.inputtool;

import android.content.Context;
import android.view.View;
import com.baidu.tbadk.editortools.RawLayout;
import com.baidu.tbadk.editortools.m;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class a extends m {
    private static final int[] fFl = {4, 17, 24, 3, 9, 6, 44};
    private InputView fFm;

    public a(Context context, boolean z) {
        super(context, (String) null, 3);
        init(context, z);
    }

    public a(Context context, boolean z, boolean z2) {
        super(context, (String) null, 3);
        init(context, z);
        if (this.fFm != null) {
            this.fFm.setNeedFaceMaxCount(z2);
        }
    }

    private void init(Context context, boolean z) {
        this.fEC = false;
        this.fEB = 2;
        this.fED = fFl;
        this.fFm = new InputView(context, z);
        this.fDH = this.fFm;
        RawLayout.LayoutParams layoutParams = new RawLayout.LayoutParams(0, -1);
        layoutParams.topMargin = context.getResources().getDimensionPixelSize(R.dimen.ds14);
        layoutParams.bottomMargin = context.getResources().getDimensionPixelSize(R.dimen.ds14);
        layoutParams.leftMargin = context.getResources().getDimensionPixelSize(R.dimen.ds30);
        layoutParams.rightMargin = context.getResources().getDimensionPixelSize(R.dimen.ds12);
        layoutParams.weight = 1.0f;
        layoutParams.gravity = 80;
        ((View) this.fDH).setLayoutParams(layoutParams);
    }

    public void setIsOnlyLocalEmotion(boolean z) {
        ((InputView) this.fDH).setIsOnlyLocalEmotion(z);
    }
}
