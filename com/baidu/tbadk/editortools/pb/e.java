package com.baidu.tbadk.editortools.pb;

import android.content.Context;
import android.text.TextWatcher;
import android.widget.EditText;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.editortools.k;
import com.baidu.tieba.e;
/* loaded from: classes.dex */
public class e extends k {
    private EditText aVV;

    public e(Context context) {
        super(context, (String) null, 27);
        this.aUM = false;
        this.aUL = 3;
        this.aTV = new PbNewInputContainer(context);
        this.aVV = ((PbNewInputContainer) this.aTV).getInputView();
        ((PbNewInputContainer) this.aTV).setHint(context.getString(e.j.say_your_point));
        this.aUN = new int[]{4, 17, 24, 3, 9, 6, 44, 12, 10, 13, 11, 28, 29, 39};
    }

    public void b(TextWatcher textWatcher) {
        this.aVV.addTextChangedListener(textWatcher);
    }

    public void c(TextWatcher textWatcher) {
        this.aVV.removeTextChangedListener(textWatcher);
    }

    public void setHint(String str) {
        if (this.aTV != null && !StringUtils.isNull(str)) {
            ((PbNewInputContainer) this.aTV).setHint(str);
        }
    }

    public EditText getInputView() {
        return this.aVV;
    }

    public void setType(int i) {
        if (this.aTV != null) {
            ((PbNewInputContainer) this.aTV).setType(i);
        }
    }

    public void fq(int i) {
        if (this.aTV != null) {
            ((PbNewInputContainer) this.aTV).fq(i);
        }
    }
}
