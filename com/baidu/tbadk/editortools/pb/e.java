package com.baidu.tbadk.editortools.pb;

import android.content.Context;
import android.text.TextWatcher;
import android.widget.EditText;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.editortools.k;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class e extends k {
    private EditText aNk;

    public e(Context context) {
        super(context, (String) null, 27);
        this.aMa = false;
        this.aLZ = 3;
        this.aLj = new PbNewInputContainer(context);
        this.aNk = ((PbNewInputContainer) this.aLj).getInputView();
        ((PbNewInputContainer) this.aLj).setHint(context.getString(d.k.say_your_point));
        this.aMb = new int[]{4, 17, 24, 3, 9, 6, 44, 12, 10, 13, 11, 28, 29, 39};
    }

    public void b(TextWatcher textWatcher) {
        this.aNk.addTextChangedListener(textWatcher);
    }

    public void c(TextWatcher textWatcher) {
        this.aNk.removeTextChangedListener(textWatcher);
    }

    public void setHint(String str) {
        if (this.aLj != null && !StringUtils.isNull(str)) {
            ((PbNewInputContainer) this.aLj).setHint(str);
        }
    }

    public EditText getInputView() {
        return this.aNk;
    }

    public void setType(int i) {
        if (this.aLj != null) {
            ((PbNewInputContainer) this.aLj).setType(i);
        }
    }

    public void eU(int i) {
        if (this.aLj != null) {
            ((PbNewInputContainer) this.aLj).eU(i);
        }
    }
}
