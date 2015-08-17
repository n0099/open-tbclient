package com.baidu.tbadk.editortools.inputtool;

import android.content.Context;
import android.text.TextWatcher;
import android.view.View;
import com.baidu.tbadk.editortools.u;
import com.baidu.tbadk.editortools.v;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
public class a extends v {
    private static final int[] arr = {4, 17, 24, 3, 9, 6};
    private InputView ars;

    public a(Context context, boolean z) {
        super(context, (String) null, 3);
        init(context, z);
    }

    public a(Context context, boolean z, boolean z2) {
        super(context, (String) null, 3);
        init(context, z);
        if (this.ars != null) {
            this.ars.setNeedFaceMaxCount(z2);
        }
    }

    private void init(Context context, boolean z) {
        this.apj = false;
        this.api = 2;
        this.apk = arr;
        this.ars = new InputView(context, z);
        this.aox = this.ars;
        u.a aVar = new u.a(0, -2);
        aVar.topMargin = context.getResources().getDimensionPixelSize(i.d.ds22);
        aVar.bottomMargin = context.getResources().getDimensionPixelSize(i.d.ds20);
        aVar.leftMargin = context.getResources().getDimensionPixelSize(i.d.ds10);
        aVar.rightMargin = context.getResources().getDimensionPixelSize(i.d.ds10);
        aVar.weight = 1.0f;
        ((View) this.aox).setLayoutParams(aVar);
    }

    public void setIsOnlyLocalEmotion(boolean z) {
        ((InputView) this.aox).setIsOnlyLocalEmotion(z);
    }

    public void b(TextWatcher textWatcher) {
        ((InputView) this.aox).setOutTextWather(textWatcher);
    }
}
