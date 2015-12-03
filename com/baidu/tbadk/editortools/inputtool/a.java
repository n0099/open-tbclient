package com.baidu.tbadk.editortools.inputtool;

import android.content.Context;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.editortools.w;
import com.baidu.tbadk.editortools.y;
import com.baidu.tieba.n;
/* loaded from: classes.dex */
public class a extends y {
    private static final int[] asb = {4, 17, 24, 3, 9, 6};
    private InputView asc;

    public a(Context context, boolean z) {
        super(context, (String) null, 3);
        init(context, z);
    }

    public a(Context context, boolean z, boolean z2) {
        super(context, (String) null, 3);
        init(context, z);
        if (this.asc != null) {
            this.asc.setNeedFaceMaxCount(z2);
        }
    }

    private void init(Context context, boolean z) {
        this.toolNeedAction = false;
        this.toolPosition = 2;
        this.toolLaunchAction = asb;
        this.asc = new InputView(context, z);
        this.toolView = this.asc;
        w.a aVar = new w.a(0, -2);
        aVar.topMargin = context.getResources().getDimensionPixelSize(n.d.ds22);
        aVar.bottomMargin = context.getResources().getDimensionPixelSize(n.d.ds20);
        aVar.leftMargin = context.getResources().getDimensionPixelSize(n.d.ds10);
        aVar.rightMargin = context.getResources().getDimensionPixelSize(n.d.ds10);
        aVar.weight = 1.0f;
        ((View) this.toolView).setLayoutParams(aVar);
    }

    public void setIsOnlyLocalEmotion(boolean z) {
        ((InputView) this.toolView).setIsOnlyLocalEmotion(z);
    }

    public void b(TextWatcher textWatcher) {
        ((InputView) this.toolView).setOutTextWather(textWatcher);
    }

    public void fi(String str) {
        if (this.toolView != null && !StringUtils.isNull(str)) {
            ((EditText) this.toolView).setHint(str);
        }
    }
}
