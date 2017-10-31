package com.baidu.tbadk.editortools.inputtool;

import android.content.Context;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.editortools.p;
import com.baidu.tbadk.editortools.r;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class a extends r {
    private static final int[] aCA = {4, 17, 24, 3, 9, 6, 44};
    private InputView aCB;

    public a(Context context, boolean z) {
        super(context, (String) null, 3);
        init(context, z);
    }

    public a(Context context, boolean z, boolean z2) {
        super(context, (String) null, 3);
        init(context, z);
        if (this.aCB != null) {
            this.aCB.setNeedFaceMaxCount(z2);
        }
    }

    private void init(Context context, boolean z) {
        this.aBU = false;
        this.aBT = 2;
        this.aBV = aCA;
        this.aCB = new InputView(context, z);
        this.aBf = this.aCB;
        p.a aVar = new p.a(0, -1);
        aVar.topMargin = context.getResources().getDimensionPixelSize(d.e.ds14);
        aVar.bottomMargin = context.getResources().getDimensionPixelSize(d.e.ds14);
        aVar.leftMargin = context.getResources().getDimensionPixelSize(d.e.ds30);
        aVar.rightMargin = context.getResources().getDimensionPixelSize(d.e.ds12);
        aVar.weight = 1.0f;
        aVar.gravity = 80;
        ((View) this.aBf).setLayoutParams(aVar);
    }

    public void setIsOnlyLocalEmotion(boolean z) {
        ((InputView) this.aBf).setIsOnlyLocalEmotion(z);
    }

    public void a(TextWatcher textWatcher) {
        ((InputView) this.aBf).addTextChangedListener(textWatcher);
    }

    public void b(TextWatcher textWatcher) {
        ((InputView) this.aBf).removeTextChangedListener(textWatcher);
    }

    public void setHint(String str) {
        if (this.aBf != null && !StringUtils.isNull(str)) {
            ((EditText) this.aBf).setHint(str);
        }
    }

    public EditText Da() {
        return this.aCB;
    }
}
