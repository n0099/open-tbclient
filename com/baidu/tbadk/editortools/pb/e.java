package com.baidu.tbadk.editortools.pb;

import android.content.Context;
import android.text.TextWatcher;
import android.widget.EditText;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.editortools.k;
import com.baidu.tieba.f;
/* loaded from: classes.dex */
public class e extends k {
    private EditText aOc;

    public e(Context context) {
        super(context, (String) null, 27);
        this.aMT = false;
        this.aMS = 3;
        this.aMc = new PbNewInputContainer(context);
        this.aOc = ((PbNewInputContainer) this.aMc).getInputView();
        ((PbNewInputContainer) this.aMc).setHint(context.getString(f.j.say_your_point));
        this.aMU = new int[]{4, 17, 24, 3, 9, 6, 44, 12, 10, 13, 11, 28, 29, 39};
    }

    public void b(TextWatcher textWatcher) {
        this.aOc.addTextChangedListener(textWatcher);
    }

    public void c(TextWatcher textWatcher) {
        this.aOc.removeTextChangedListener(textWatcher);
    }

    public void setHint(String str) {
        if (this.aMc != null && !StringUtils.isNull(str)) {
            ((PbNewInputContainer) this.aMc).setHint(str);
        }
    }

    public EditText getInputView() {
        return this.aOc;
    }

    public void setType(int i) {
        if (this.aMc != null) {
            ((PbNewInputContainer) this.aMc).setType(i);
        }
    }

    public void eV(int i) {
        if (this.aMc != null) {
            ((PbNewInputContainer) this.aMc).eV(i);
        }
    }
}
