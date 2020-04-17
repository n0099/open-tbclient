package com.baidu.tbadk.editortools.pb;

import android.content.Context;
import android.text.TextWatcher;
import android.widget.EditText;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.editortools.l;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class f extends l {
    private EditText dYK;

    public f(Context context) {
        super(context, (String) null, 27);
        this.dXz = false;
        this.dXy = 3;
        this.dWH = new PbNewInputContainer(context);
        this.dYK = ((PbNewInputContainer) this.dWH).getInputView();
        ((PbNewInputContainer) this.dWH).setHint(context.getString(R.string.say_your_point));
        this.dXA = new int[]{4, 17, 24, 3, 9, 6, 44, 12, 10, 13, 11, 28, 29, 39};
    }

    public void c(TextWatcher textWatcher) {
        this.dYK.addTextChangedListener(textWatcher);
    }

    public void d(TextWatcher textWatcher) {
        this.dYK.removeTextChangedListener(textWatcher);
    }

    public void setHint(String str) {
        if (this.dWH != null && !StringUtils.isNull(str)) {
            ((PbNewInputContainer) this.dWH).setHint(str);
        }
    }

    public void setDefaultHint(String str) {
        if (this.dWH != null && !StringUtils.isNull(str)) {
            ((PbNewInputContainer) this.dWH).setDefaultHint(str);
        }
    }

    public EditText getInputView() {
        return this.dYK;
    }

    public void setType(int i) {
        if (this.dWH != null) {
            ((PbNewInputContainer) this.dWH).setType(i);
        }
    }

    public void mL(int i) {
        if (this.dWH != null) {
            ((PbNewInputContainer) this.dWH).mL(i);
        }
    }
}
