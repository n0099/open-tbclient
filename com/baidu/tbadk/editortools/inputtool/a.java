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
    private static final int[] aDz = {4, 17, 24, 3, 9, 6, 44};
    private InputView aDA;

    public a(Context context, boolean z) {
        super(context, (String) null, 3);
        init(context, z);
    }

    public a(Context context, boolean z, boolean z2) {
        super(context, (String) null, 3);
        init(context, z);
        if (this.aDA != null) {
            this.aDA.setNeedFaceMaxCount(z2);
        }
    }

    private void init(Context context, boolean z) {
        this.aCT = false;
        this.aCS = 2;
        this.aCU = aDz;
        this.aDA = new InputView(context, z);
        this.aCe = this.aDA;
        p.a aVar = new p.a(0, -2);
        aVar.topMargin = context.getResources().getDimensionPixelSize(d.f.ds22);
        aVar.bottomMargin = context.getResources().getDimensionPixelSize(d.f.ds20);
        aVar.leftMargin = context.getResources().getDimensionPixelSize(d.f.ds10);
        aVar.rightMargin = context.getResources().getDimensionPixelSize(d.f.ds10);
        aVar.weight = 1.0f;
        ((View) this.aCe).setLayoutParams(aVar);
    }

    public void setIsOnlyLocalEmotion(boolean z) {
        ((InputView) this.aCe).setIsOnlyLocalEmotion(z);
    }

    public void a(TextWatcher textWatcher) {
        ((InputView) this.aCe).setOutTextWather(textWatcher);
    }

    public void setHint(String str) {
        if (this.aCe != null && !StringUtils.isNull(str)) {
            ((EditText) this.aCe).setHint(str);
        }
    }

    public EditText Dt() {
        return this.aDA;
    }
}
