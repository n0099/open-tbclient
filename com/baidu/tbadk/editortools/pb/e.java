package com.baidu.tbadk.editortools.pb;

import android.content.Context;
import android.text.TextWatcher;
import android.widget.EditText;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.editortools.k;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class e extends k {
    private EditText cGr;

    public e(Context context) {
        super(context, (String) null, 27);
        this.cFg = false;
        this.cFf = 3;
        this.cEn = new PbNewInputContainer(context);
        this.cGr = ((PbNewInputContainer) this.cEn).getInputView();
        ((PbNewInputContainer) this.cEn).setHint(context.getString(R.string.say_your_point));
        this.cFh = new int[]{4, 17, 24, 3, 9, 6, 44, 12, 10, 13, 11, 28, 29, 39};
    }

    public void c(TextWatcher textWatcher) {
        this.cGr.addTextChangedListener(textWatcher);
    }

    public void d(TextWatcher textWatcher) {
        this.cGr.removeTextChangedListener(textWatcher);
    }

    public void setHint(String str) {
        if (this.cEn != null && !StringUtils.isNull(str)) {
            ((PbNewInputContainer) this.cEn).setHint(str);
        }
    }

    public void setDefaultHint(String str) {
        if (this.cEn != null && !StringUtils.isNull(str)) {
            ((PbNewInputContainer) this.cEn).setDefaultHint(str);
        }
    }

    public EditText getInputView() {
        return this.cGr;
    }

    public void setType(int i) {
        if (this.cEn != null) {
            ((PbNewInputContainer) this.cEn).setType(i);
        }
    }

    public void jS(int i) {
        if (this.cEn != null) {
            ((PbNewInputContainer) this.cEn).jS(i);
        }
    }
}
