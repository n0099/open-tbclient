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
    private static final int[] aCK = {4, 17, 24, 3, 9, 6, 44};
    private InputView aCL;

    public a(Context context, boolean z) {
        super(context, (String) null, 3);
        init(context, z);
    }

    public a(Context context, boolean z, boolean z2) {
        super(context, (String) null, 3);
        init(context, z);
        if (this.aCL != null) {
            this.aCL.setNeedFaceMaxCount(z2);
        }
    }

    private void init(Context context, boolean z) {
        this.aCd = false;
        this.aCc = 2;
        this.aCe = aCK;
        this.aCL = new InputView(context, z);
        this.aBn = this.aCL;
        p.a aVar = new p.a(0, -2);
        aVar.topMargin = context.getResources().getDimensionPixelSize(d.f.ds14);
        aVar.bottomMargin = context.getResources().getDimensionPixelSize(d.f.ds14);
        aVar.leftMargin = context.getResources().getDimensionPixelSize(d.f.ds30);
        aVar.rightMargin = context.getResources().getDimensionPixelSize(d.f.ds12);
        aVar.weight = 1.0f;
        aVar.gravity = 80;
        ((View) this.aBn).setLayoutParams(aVar);
    }

    public void setIsOnlyLocalEmotion(boolean z) {
        ((InputView) this.aBn).setIsOnlyLocalEmotion(z);
    }

    public void a(TextWatcher textWatcher) {
        ((InputView) this.aBn).setOutTextWather(textWatcher);
    }

    public void setHint(String str) {
        if (this.aBn != null && !StringUtils.isNull(str)) {
            ((EditText) this.aBn).setHint(str);
        }
    }

    public EditText Do() {
        return this.aCL;
    }
}
