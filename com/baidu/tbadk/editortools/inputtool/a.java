package com.baidu.tbadk.editortools.inputtool;

import android.content.Context;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.editortools.v;
import com.baidu.tbadk.editortools.x;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class a extends x {
    private static final int[] aAu = {4, 17, 24, 3, 9, 6, 44};
    private InputView aAv;

    public a(Context context, boolean z) {
        super(context, (String) null, 3);
        init(context, z);
    }

    public a(Context context, boolean z, boolean z2) {
        super(context, (String) null, 3);
        init(context, z);
        if (this.aAv != null) {
            this.aAv.setNeedFaceMaxCount(z2);
        }
    }

    private void init(Context context, boolean z) {
        this.azN = false;
        this.azM = 2;
        this.azO = aAu;
        this.aAv = new InputView(context, z);
        this.ayZ = this.aAv;
        v.a aVar = new v.a(0, -2);
        aVar.topMargin = context.getResources().getDimensionPixelSize(w.f.ds22);
        aVar.bottomMargin = context.getResources().getDimensionPixelSize(w.f.ds20);
        aVar.leftMargin = context.getResources().getDimensionPixelSize(w.f.ds10);
        aVar.rightMargin = context.getResources().getDimensionPixelSize(w.f.ds10);
        aVar.weight = 1.0f;
        ((View) this.ayZ).setLayoutParams(aVar);
    }

    public void setIsOnlyLocalEmotion(boolean z) {
        ((InputView) this.ayZ).setIsOnlyLocalEmotion(z);
    }

    public void b(TextWatcher textWatcher) {
        ((InputView) this.ayZ).setOutTextWather(textWatcher);
    }

    public void setHint(String str) {
        if (this.ayZ != null && !StringUtils.isNull(str)) {
            ((EditText) this.ayZ).setHint(str);
        }
    }

    public EditText DG() {
        return this.aAv;
    }
}
