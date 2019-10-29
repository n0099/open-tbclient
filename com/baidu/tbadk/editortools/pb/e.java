package com.baidu.tbadk.editortools.pb;

import android.content.Context;
import android.text.TextWatcher;
import android.widget.EditText;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.editortools.k;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class e extends k {
    private EditText cHi;

    public e(Context context) {
        super(context, (String) null, 27);
        this.cFX = false;
        this.cFW = 3;
        this.cFe = new PbNewInputContainer(context);
        this.cHi = ((PbNewInputContainer) this.cFe).getInputView();
        ((PbNewInputContainer) this.cFe).setHint(context.getString(R.string.say_your_point));
        this.cFY = new int[]{4, 17, 24, 3, 9, 6, 44, 12, 10, 13, 11, 28, 29, 39};
    }

    public void c(TextWatcher textWatcher) {
        this.cHi.addTextChangedListener(textWatcher);
    }

    public void d(TextWatcher textWatcher) {
        this.cHi.removeTextChangedListener(textWatcher);
    }

    public void setHint(String str) {
        if (this.cFe != null && !StringUtils.isNull(str)) {
            ((PbNewInputContainer) this.cFe).setHint(str);
        }
    }

    public void setDefaultHint(String str) {
        if (this.cFe != null && !StringUtils.isNull(str)) {
            ((PbNewInputContainer) this.cFe).setDefaultHint(str);
        }
    }

    public EditText getInputView() {
        return this.cHi;
    }

    public void setType(int i) {
        if (this.cFe != null) {
            ((PbNewInputContainer) this.cFe).setType(i);
        }
    }

    public void jT(int i) {
        if (this.cFe != null) {
            ((PbNewInputContainer) this.cFe).jT(i);
        }
    }
}
