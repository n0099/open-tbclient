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
    private static final int[] aAe = {4, 17, 24, 3, 9, 6, 44};
    private InputView aAf;

    public a(Context context, boolean z) {
        super(context, (String) null, 3);
        init(context, z);
    }

    public a(Context context, boolean z, boolean z2) {
        super(context, (String) null, 3);
        init(context, z);
        if (this.aAf != null) {
            this.aAf.setNeedFaceMaxCount(z2);
        }
    }

    private void init(Context context, boolean z) {
        this.azx = false;
        this.azw = 2;
        this.azy = aAe;
        this.aAf = new InputView(context, z);
        this.ayJ = this.aAf;
        v.a aVar = new v.a(0, -2);
        aVar.topMargin = context.getResources().getDimensionPixelSize(w.f.ds22);
        aVar.bottomMargin = context.getResources().getDimensionPixelSize(w.f.ds20);
        aVar.leftMargin = context.getResources().getDimensionPixelSize(w.f.ds10);
        aVar.rightMargin = context.getResources().getDimensionPixelSize(w.f.ds10);
        aVar.weight = 1.0f;
        ((View) this.ayJ).setLayoutParams(aVar);
    }

    public void setIsOnlyLocalEmotion(boolean z) {
        ((InputView) this.ayJ).setIsOnlyLocalEmotion(z);
    }

    public void b(TextWatcher textWatcher) {
        ((InputView) this.ayJ).setOutTextWather(textWatcher);
    }

    public void setHint(String str) {
        if (this.ayJ != null && !StringUtils.isNull(str)) {
            ((EditText) this.ayJ).setHint(str);
        }
    }

    public EditText CE() {
        return this.aAf;
    }
}
