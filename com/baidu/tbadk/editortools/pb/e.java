package com.baidu.tbadk.editortools.pb;

import android.content.Context;
import android.text.TextWatcher;
import android.widget.EditText;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.editortools.k;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class e extends k {
    private EditText aEN;

    public e(Context context) {
        super(context, (String) null, 27);
        this.aDD = false;
        this.aDC = 3;
        this.aCM = new PbNewInputContainer(context);
        this.aEN = ((PbNewInputContainer) this.aCM).getInputView();
        ((PbNewInputContainer) this.aCM).setHint(context.getString(d.k.say_your_point));
        this.aDE = new int[]{4, 17, 24, 3, 9, 6, 44, 12, 10, 13, 11, 28, 29, 39};
    }

    public void b(TextWatcher textWatcher) {
        this.aEN.addTextChangedListener(textWatcher);
    }

    public void c(TextWatcher textWatcher) {
        this.aEN.removeTextChangedListener(textWatcher);
    }

    public void setHint(String str) {
        if (this.aCM != null && !StringUtils.isNull(str)) {
            ((PbNewInputContainer) this.aCM).setHint(str);
        }
    }

    public EditText getInputView() {
        return this.aEN;
    }

    public void setType(int i) {
        if (this.aCM != null) {
            ((PbNewInputContainer) this.aCM).setType(i);
        }
    }

    public void eP(int i) {
        if (this.aCM != null) {
            ((PbNewInputContainer) this.aCM).eP(i);
        }
    }
}
