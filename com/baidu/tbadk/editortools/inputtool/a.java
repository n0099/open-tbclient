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
    private static final int[] aCN = {4, 17, 24, 3, 9, 6, 44};
    private InputView aCO;

    public a(Context context, boolean z) {
        super(context, (String) null, 3);
        init(context, z);
    }

    public a(Context context, boolean z, boolean z2) {
        super(context, (String) null, 3);
        init(context, z);
        if (this.aCO != null) {
            this.aCO.setNeedFaceMaxCount(z2);
        }
    }

    private void init(Context context, boolean z) {
        this.aCg = false;
        this.aCf = 2;
        this.aCh = aCN;
        this.aCO = new InputView(context, z);
        this.aBq = this.aCO;
        p.a aVar = new p.a(0, -2);
        aVar.topMargin = context.getResources().getDimensionPixelSize(d.f.ds14);
        aVar.bottomMargin = context.getResources().getDimensionPixelSize(d.f.ds14);
        aVar.leftMargin = context.getResources().getDimensionPixelSize(d.f.ds30);
        aVar.rightMargin = context.getResources().getDimensionPixelSize(d.f.ds12);
        aVar.weight = 1.0f;
        aVar.gravity = 80;
        ((View) this.aBq).setLayoutParams(aVar);
    }

    public void setIsOnlyLocalEmotion(boolean z) {
        ((InputView) this.aBq).setIsOnlyLocalEmotion(z);
    }

    public void a(TextWatcher textWatcher) {
        ((InputView) this.aBq).setOutTextWather(textWatcher);
    }

    public void setHint(String str) {
        if (this.aBq != null && !StringUtils.isNull(str)) {
            ((EditText) this.aBq).setHint(str);
        }
    }

    public EditText Do() {
        return this.aCO;
    }
}
