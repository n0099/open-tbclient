package com.baidu.tbadk.editortools.inputtool;

import android.content.Context;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.editortools.v;
import com.baidu.tbadk.editortools.x;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class a extends x {
    private static final int[] avC = {4, 17, 24, 3, 9, 6, 44};
    private InputView avD;

    public a(Context context, boolean z) {
        super(context, (String) null, 3);
        init(context, z);
    }

    public a(Context context, boolean z, boolean z2) {
        super(context, (String) null, 3);
        init(context, z);
        if (this.avD != null) {
            this.avD.setNeedFaceMaxCount(z2);
        }
    }

    private void init(Context context, boolean z) {
        this.auV = false;
        this.auU = 2;
        this.auW = avC;
        this.avD = new InputView(context, z);
        this.auh = this.avD;
        v.a aVar = new v.a(0, -2);
        aVar.topMargin = context.getResources().getDimensionPixelSize(r.e.ds22);
        aVar.bottomMargin = context.getResources().getDimensionPixelSize(r.e.ds20);
        aVar.leftMargin = context.getResources().getDimensionPixelSize(r.e.ds10);
        aVar.rightMargin = context.getResources().getDimensionPixelSize(r.e.ds10);
        aVar.weight = 1.0f;
        ((View) this.auh).setLayoutParams(aVar);
    }

    public void setIsOnlyLocalEmotion(boolean z) {
        ((InputView) this.auh).setIsOnlyLocalEmotion(z);
    }

    public void b(TextWatcher textWatcher) {
        ((InputView) this.auh).setOutTextWather(textWatcher);
    }

    public void setHint(String str) {
        if (this.auh != null && !StringUtils.isNull(str)) {
            ((EditText) this.auh).setHint(str);
        }
    }
}
