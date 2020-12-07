package com.baidu.tbadk.editortools.pb;

import android.content.Context;
import android.text.TextWatcher;
import android.widget.EditText;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.editortools.m;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class f extends m {
    private EditText fwL;

    public f(Context context, boolean z, boolean z2) {
        super(context, (String) null, 27);
        this.fuW = false;
        this.fuV = 3;
        this.fub = new PbNewInputContainer(context);
        ((PbNewInputContainer) this.fub).setTransLink(z ? false : true);
        this.fwL = ((PbNewInputContainer) this.fub).getInputView();
        ((PbNewInputContainer) this.fub).setHint(context.getString(R.string.say_your_point));
        ((PbNewInputContainer) this.fub).kF(z2);
        this.fuX = new int[]{4, 17, 24, 3, 9, 6, 44, 12, 10, 13, 11, 28, 29, 39, 45};
    }

    public void b(TextWatcher textWatcher) {
        this.fwL.addTextChangedListener(textWatcher);
    }

    public void c(TextWatcher textWatcher) {
        this.fwL.removeTextChangedListener(textWatcher);
    }

    public void setHint(String str) {
        if (this.fub != null && !StringUtils.isNull(str)) {
            ((PbNewInputContainer) this.fub).setHint(str);
        }
    }

    public void setDefaultHint(String str) {
        if (this.fub != null && !StringUtils.isNull(str)) {
            ((PbNewInputContainer) this.fub).setDefaultHint(str);
        }
    }

    public EditText getInputView() {
        return this.fwL;
    }

    public void setType(int i) {
        if (this.fub != null) {
            ((PbNewInputContainer) this.fub).setType(i);
        }
    }

    public void sv(int i) {
        if (this.fub != null) {
            ((PbNewInputContainer) this.fub).sv(i);
        }
    }
}
