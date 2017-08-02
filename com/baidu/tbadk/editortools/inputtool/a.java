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
    private static final int[] aCh = {4, 17, 24, 3, 9, 6, 44};
    private InputView aCi;

    public a(Context context, boolean z) {
        super(context, (String) null, 3);
        init(context, z);
    }

    public a(Context context, boolean z, boolean z2) {
        super(context, (String) null, 3);
        init(context, z);
        if (this.aCi != null) {
            this.aCi.setNeedFaceMaxCount(z2);
        }
    }

    private void init(Context context, boolean z) {
        this.aBA = false;
        this.aBz = 2;
        this.aBB = aCh;
        this.aCi = new InputView(context, z);
        this.aAL = this.aCi;
        p.a aVar = new p.a(0, -2);
        aVar.topMargin = context.getResources().getDimensionPixelSize(d.f.ds22);
        aVar.bottomMargin = context.getResources().getDimensionPixelSize(d.f.ds20);
        aVar.leftMargin = context.getResources().getDimensionPixelSize(d.f.ds10);
        aVar.rightMargin = context.getResources().getDimensionPixelSize(d.f.ds10);
        aVar.weight = 1.0f;
        ((View) this.aAL).setLayoutParams(aVar);
    }

    public void setIsOnlyLocalEmotion(boolean z) {
        ((InputView) this.aAL).setIsOnlyLocalEmotion(z);
    }

    public void b(TextWatcher textWatcher) {
        ((InputView) this.aAL).setOutTextWather(textWatcher);
    }

    public void setHint(String str) {
        if (this.aAL != null && !StringUtils.isNull(str)) {
            ((EditText) this.aAL).setHint(str);
        }
    }

    public EditText Dl() {
        return this.aCi;
    }
}
