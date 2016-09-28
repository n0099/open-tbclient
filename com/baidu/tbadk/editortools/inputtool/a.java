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
    private static final int[] avl = {4, 17, 24, 3, 9, 6, 44};
    private InputView avm;

    public a(Context context, boolean z) {
        super(context, (String) null, 3);
        init(context, z);
    }

    public a(Context context, boolean z, boolean z2) {
        super(context, (String) null, 3);
        init(context, z);
        if (this.avm != null) {
            this.avm.setNeedFaceMaxCount(z2);
        }
    }

    private void init(Context context, boolean z) {
        this.auE = false;
        this.auD = 2;
        this.auF = avl;
        this.avm = new InputView(context, z);
        this.atI = this.avm;
        y.a aVar = new y.a(0, -2);
        aVar.topMargin = context.getResources().getDimensionPixelSize(r.e.ds22);
        aVar.bottomMargin = context.getResources().getDimensionPixelSize(r.e.ds20);
        aVar.leftMargin = context.getResources().getDimensionPixelSize(r.e.ds10);
        aVar.rightMargin = context.getResources().getDimensionPixelSize(r.e.ds10);
        aVar.weight = 1.0f;
        ((View) this.atI).setLayoutParams(aVar);
    }

    public void setIsOnlyLocalEmotion(boolean z) {
        ((InputView) this.atI).setIsOnlyLocalEmotion(z);
    }

    public void b(TextWatcher textWatcher) {
        ((InputView) this.atI).setOutTextWather(textWatcher);
    }

    public void setHint(String str) {
        if (this.atI != null && !StringUtils.isNull(str)) {
            ((EditText) this.atI).setHint(str);
        }
    }
}
