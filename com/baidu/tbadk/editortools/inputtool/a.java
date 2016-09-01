package com.baidu.tbadk.editortools.inputtool;

import android.content.Context;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.editortools.aa;
import com.baidu.tbadk.editortools.y;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class a extends aa {
    private static final int[] avI = {4, 17, 24, 3, 9, 6};
    private InputView avJ;

    public a(Context context, boolean z) {
        super(context, (String) null, 3);
        init(context, z);
    }

    public a(Context context, boolean z, boolean z2) {
        super(context, (String) null, 3);
        init(context, z);
        if (this.avJ != null) {
            this.avJ.setNeedFaceMaxCount(z2);
        }
    }

    private void init(Context context, boolean z) {
        this.avb = false;
        this.ava = 2;
        this.avc = avI;
        this.avJ = new InputView(context, z);
        this.aue = this.avJ;
        y.a aVar = new y.a(0, -2);
        aVar.topMargin = context.getResources().getDimensionPixelSize(t.e.ds22);
        aVar.bottomMargin = context.getResources().getDimensionPixelSize(t.e.ds20);
        aVar.leftMargin = context.getResources().getDimensionPixelSize(t.e.ds10);
        aVar.rightMargin = context.getResources().getDimensionPixelSize(t.e.ds10);
        aVar.weight = 1.0f;
        ((View) this.aue).setLayoutParams(aVar);
    }

    public void setIsOnlyLocalEmotion(boolean z) {
        ((InputView) this.aue).setIsOnlyLocalEmotion(z);
    }

    public void b(TextWatcher textWatcher) {
        ((InputView) this.aue).setOutTextWather(textWatcher);
    }

    public void setHint(String str) {
        if (this.aue != null && !StringUtils.isNull(str)) {
            ((EditText) this.aue).setHint(str);
        }
    }
}
