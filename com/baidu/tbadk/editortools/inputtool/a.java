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
    private static final int[] auH = {4, 17, 24, 3, 9, 6, 44};
    private InputView auI;

    public a(Context context, boolean z) {
        super(context, (String) null, 3);
        init(context, z);
    }

    public a(Context context, boolean z, boolean z2) {
        super(context, (String) null, 3);
        init(context, z);
        if (this.auI != null) {
            this.auI.setNeedFaceMaxCount(z2);
        }
    }

    private void init(Context context, boolean z) {
        this.aua = false;
        this.atZ = 2;
        this.aub = auH;
        this.auI = new InputView(context, z);
        this.atm = this.auI;
        v.a aVar = new v.a(0, -2);
        aVar.topMargin = context.getResources().getDimensionPixelSize(r.f.ds22);
        aVar.bottomMargin = context.getResources().getDimensionPixelSize(r.f.ds20);
        aVar.leftMargin = context.getResources().getDimensionPixelSize(r.f.ds10);
        aVar.rightMargin = context.getResources().getDimensionPixelSize(r.f.ds10);
        aVar.weight = 1.0f;
        ((View) this.atm).setLayoutParams(aVar);
    }

    public void setIsOnlyLocalEmotion(boolean z) {
        ((InputView) this.atm).setIsOnlyLocalEmotion(z);
    }

    public void b(TextWatcher textWatcher) {
        ((InputView) this.atm).setOutTextWather(textWatcher);
    }

    public void setHint(String str) {
        if (this.atm != null && !StringUtils.isNull(str)) {
            ((EditText) this.atm).setHint(str);
        }
    }
}
