package com.baidu.tbadk.editortools.inputtool;

import android.content.Context;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.editortools.aa;
import com.baidu.tbadk.editortools.y;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class a extends aa {
    private static final int[] awf = {4, 17, 24, 3, 9, 6, 44};
    private InputView awg;

    public a(Context context, boolean z) {
        super(context, (String) null, 3);
        init(context, z);
    }

    public a(Context context, boolean z, boolean z2) {
        super(context, (String) null, 3);
        init(context, z);
        if (this.awg != null) {
            this.awg.setNeedFaceMaxCount(z2);
        }
    }

    private void init(Context context, boolean z) {
        this.avy = false;
        this.avx = 2;
        this.avz = awf;
        this.awg = new InputView(context, z);
        this.auC = this.awg;
        y.a aVar = new y.a(0, -2);
        aVar.topMargin = context.getResources().getDimensionPixelSize(r.e.ds22);
        aVar.bottomMargin = context.getResources().getDimensionPixelSize(r.e.ds20);
        aVar.leftMargin = context.getResources().getDimensionPixelSize(r.e.ds10);
        aVar.rightMargin = context.getResources().getDimensionPixelSize(r.e.ds10);
        aVar.weight = 1.0f;
        ((View) this.auC).setLayoutParams(aVar);
    }

    public void setIsOnlyLocalEmotion(boolean z) {
        ((InputView) this.auC).setIsOnlyLocalEmotion(z);
    }

    public void b(TextWatcher textWatcher) {
        ((InputView) this.auC).setOutTextWather(textWatcher);
    }

    public void setHint(String str) {
        if (this.auC != null && !StringUtils.isNull(str)) {
            ((EditText) this.auC).setHint(str);
        }
    }
}
