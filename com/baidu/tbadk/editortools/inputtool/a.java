package com.baidu.tbadk.editortools.inputtool;

import android.content.Context;
import android.view.View;
import com.baidu.tbadk.editortools.RawLayout;
import com.baidu.tbadk.editortools.l;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class a extends l {
    private static final int[] dyx = {4, 17, 24, 3, 9, 6, 44};
    private InputView dyy;

    public a(Context context, boolean z) {
        super(context, (String) null, 3);
        init(context, z);
    }

    public a(Context context, boolean z, boolean z2) {
        super(context, (String) null, 3);
        init(context, z);
        if (this.dyy != null) {
            this.dyy.setNeedFaceMaxCount(z2);
        }
    }

    private void init(Context context, boolean z) {
        this.dxS = false;
        this.dxR = 2;
        this.dxT = dyx;
        this.dyy = new InputView(context, z);
        this.dxa = this.dyy;
        RawLayout.LayoutParams layoutParams = new RawLayout.LayoutParams(0, -1);
        layoutParams.topMargin = context.getResources().getDimensionPixelSize(R.dimen.ds14);
        layoutParams.bottomMargin = context.getResources().getDimensionPixelSize(R.dimen.ds14);
        layoutParams.leftMargin = context.getResources().getDimensionPixelSize(R.dimen.ds30);
        layoutParams.rightMargin = context.getResources().getDimensionPixelSize(R.dimen.ds12);
        layoutParams.weight = 1.0f;
        layoutParams.gravity = 80;
        ((View) this.dxa).setLayoutParams(layoutParams);
    }

    public void setIsOnlyLocalEmotion(boolean z) {
        ((InputView) this.dxa).setIsOnlyLocalEmotion(z);
    }
}
