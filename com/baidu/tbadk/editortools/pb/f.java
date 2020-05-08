package com.baidu.tbadk.editortools.pb;

import android.content.Context;
import android.text.TextWatcher;
import android.widget.EditText;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.editortools.l;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class f extends l {
    private EditText dYP;

    public f(Context context) {
        super(context, (String) null, 27);
        this.dXE = false;
        this.dXD = 3;
        this.dWM = new PbNewInputContainer(context);
        this.dYP = ((PbNewInputContainer) this.dWM).getInputView();
        ((PbNewInputContainer) this.dWM).setHint(context.getString(R.string.say_your_point));
        this.dXF = new int[]{4, 17, 24, 3, 9, 6, 44, 12, 10, 13, 11, 28, 29, 39};
    }

    public void c(TextWatcher textWatcher) {
        this.dYP.addTextChangedListener(textWatcher);
    }

    public void d(TextWatcher textWatcher) {
        this.dYP.removeTextChangedListener(textWatcher);
    }

    public void setHint(String str) {
        if (this.dWM != null && !StringUtils.isNull(str)) {
            ((PbNewInputContainer) this.dWM).setHint(str);
        }
    }

    public void setDefaultHint(String str) {
        if (this.dWM != null && !StringUtils.isNull(str)) {
            ((PbNewInputContainer) this.dWM).setDefaultHint(str);
        }
    }

    public EditText getInputView() {
        return this.dYP;
    }

    public void setType(int i) {
        if (this.dWM != null) {
            ((PbNewInputContainer) this.dWM).setType(i);
        }
    }

    public void mL(int i) {
        if (this.dWM != null) {
            ((PbNewInputContainer) this.dWM).mL(i);
        }
    }
}
