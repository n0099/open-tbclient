package com.baidu.tbadk.editortools.pb;

import android.content.Context;
import android.text.TextWatcher;
import android.widget.EditText;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.editortools.k;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class e extends k {
    private EditText aOg;

    public e(Context context) {
        super(context, (String) null, 27);
        this.aMW = false;
        this.aMV = 3;
        this.aMf = new PbNewInputContainer(context);
        this.aOg = ((PbNewInputContainer) this.aMf).getInputView();
        ((PbNewInputContainer) this.aMf).setHint(context.getString(d.k.say_your_point));
        this.aMX = new int[]{4, 17, 24, 3, 9, 6, 44, 12, 10, 13, 11, 28, 29, 39};
    }

    public void b(TextWatcher textWatcher) {
        this.aOg.addTextChangedListener(textWatcher);
    }

    public void c(TextWatcher textWatcher) {
        this.aOg.removeTextChangedListener(textWatcher);
    }

    public void setHint(String str) {
        if (this.aMf != null && !StringUtils.isNull(str)) {
            ((PbNewInputContainer) this.aMf).setHint(str);
        }
    }

    public EditText getInputView() {
        return this.aOg;
    }

    public void setType(int i) {
        if (this.aMf != null) {
            ((PbNewInputContainer) this.aMf).setType(i);
        }
    }

    public void eV(int i) {
        if (this.aMf != null) {
            ((PbNewInputContainer) this.aMf).eV(i);
        }
    }
}
