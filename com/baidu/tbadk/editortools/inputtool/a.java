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
    private static final int[] aCI = {4, 17, 24, 3, 9, 6, 44};
    private InputView aCJ;

    public a(Context context, boolean z) {
        super(context, (String) null, 3);
        init(context, z);
    }

    public a(Context context, boolean z, boolean z2) {
        super(context, (String) null, 3);
        init(context, z);
        if (this.aCJ != null) {
            this.aCJ.setNeedFaceMaxCount(z2);
        }
    }

    private void init(Context context, boolean z) {
        this.aCc = false;
        this.aCb = 2;
        this.aCd = aCI;
        this.aCJ = new InputView(context, z);
        this.aBn = this.aCJ;
        p.a aVar = new p.a(0, -1);
        aVar.topMargin = context.getResources().getDimensionPixelSize(d.e.ds14);
        aVar.bottomMargin = context.getResources().getDimensionPixelSize(d.e.ds14);
        aVar.leftMargin = context.getResources().getDimensionPixelSize(d.e.ds30);
        aVar.rightMargin = context.getResources().getDimensionPixelSize(d.e.ds12);
        aVar.weight = 1.0f;
        aVar.gravity = 80;
        ((View) this.aBn).setLayoutParams(aVar);
    }

    public void setIsOnlyLocalEmotion(boolean z) {
        ((InputView) this.aBn).setIsOnlyLocalEmotion(z);
    }

    public void a(TextWatcher textWatcher) {
        ((InputView) this.aBn).addTextChangedListener(textWatcher);
    }

    public void b(TextWatcher textWatcher) {
        ((InputView) this.aBn).removeTextChangedListener(textWatcher);
    }

    public void setHint(String str) {
        if (this.aBn != null && !StringUtils.isNull(str)) {
            ((EditText) this.aBn).setHint(str);
        }
    }

    public EditText Dm() {
        return this.aCJ;
    }
}
