package com.baidu.tbadk.editortools.inputtool;

import android.content.Context;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.editortools.aa;
import com.baidu.tbadk.editortools.y;
import com.baidu.tieba.u;
/* loaded from: classes.dex */
public class a extends aa {
    private static final int[] arM = {4, 17, 24, 3, 9, 6};
    private InputView arN;

    public a(Context context, boolean z) {
        super(context, (String) null, 3);
        init(context, z);
    }

    public a(Context context, boolean z, boolean z2) {
        super(context, (String) null, 3);
        init(context, z);
        if (this.arN != null) {
            this.arN.setNeedFaceMaxCount(z2);
        }
    }

    private void init(Context context, boolean z) {
        this.arf = false;
        this.are = 2;
        this.arg = arM;
        this.arN = new InputView(context, z);
        this.aqi = this.arN;
        y.a aVar = new y.a(0, -2);
        aVar.topMargin = context.getResources().getDimensionPixelSize(u.e.ds22);
        aVar.bottomMargin = context.getResources().getDimensionPixelSize(u.e.ds20);
        aVar.leftMargin = context.getResources().getDimensionPixelSize(u.e.ds10);
        aVar.rightMargin = context.getResources().getDimensionPixelSize(u.e.ds10);
        aVar.weight = 1.0f;
        ((View) this.aqi).setLayoutParams(aVar);
    }

    public void setIsOnlyLocalEmotion(boolean z) {
        ((InputView) this.aqi).setIsOnlyLocalEmotion(z);
    }

    public void b(TextWatcher textWatcher) {
        ((InputView) this.aqi).setOutTextWather(textWatcher);
    }

    public void setHint(String str) {
        if (this.aqi != null && !StringUtils.isNull(str)) {
            ((EditText) this.aqi).setHint(str);
        }
    }
}
