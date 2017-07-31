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
    private static final int[] aDx = {4, 17, 24, 3, 9, 6, 44};
    private InputView aDy;

    public a(Context context, boolean z) {
        super(context, (String) null, 3);
        init(context, z);
    }

    public a(Context context, boolean z, boolean z2) {
        super(context, (String) null, 3);
        init(context, z);
        if (this.aDy != null) {
            this.aDy.setNeedFaceMaxCount(z2);
        }
    }

    private void init(Context context, boolean z) {
        this.aCR = false;
        this.aCQ = 2;
        this.aCS = aDx;
        this.aDy = new InputView(context, z);
        this.aCc = this.aDy;
        p.a aVar = new p.a(0, -2);
        aVar.topMargin = context.getResources().getDimensionPixelSize(d.f.ds22);
        aVar.bottomMargin = context.getResources().getDimensionPixelSize(d.f.ds20);
        aVar.leftMargin = context.getResources().getDimensionPixelSize(d.f.ds10);
        aVar.rightMargin = context.getResources().getDimensionPixelSize(d.f.ds10);
        aVar.weight = 1.0f;
        ((View) this.aCc).setLayoutParams(aVar);
    }

    public void setIsOnlyLocalEmotion(boolean z) {
        ((InputView) this.aCc).setIsOnlyLocalEmotion(z);
    }

    public void b(TextWatcher textWatcher) {
        ((InputView) this.aCc).setOutTextWather(textWatcher);
    }

    public void setHint(String str) {
        if (this.aCc != null && !StringUtils.isNull(str)) {
            ((EditText) this.aCc).setHint(str);
        }
    }

    public EditText Dt() {
        return this.aDy;
    }
}
