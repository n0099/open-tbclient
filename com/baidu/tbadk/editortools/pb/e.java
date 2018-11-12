package com.baidu.tbadk.editortools.pb;

import android.content.Context;
import android.text.TextWatcher;
import android.widget.EditText;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.editortools.k;
import com.baidu.tieba.e;
/* loaded from: classes.dex */
public class e extends k {
    private EditText aWL;

    public e(Context context) {
        super(context, (String) null, 27);
        this.aVC = false;
        this.aVB = 3;
        this.aUL = new PbNewInputContainer(context);
        this.aWL = ((PbNewInputContainer) this.aUL).getInputView();
        ((PbNewInputContainer) this.aUL).setHint(context.getString(e.j.say_your_point));
        this.aVD = new int[]{4, 17, 24, 3, 9, 6, 44, 12, 10, 13, 11, 28, 29, 39};
    }

    public void b(TextWatcher textWatcher) {
        this.aWL.addTextChangedListener(textWatcher);
    }

    public void c(TextWatcher textWatcher) {
        this.aWL.removeTextChangedListener(textWatcher);
    }

    public void setHint(String str) {
        if (this.aUL != null && !StringUtils.isNull(str)) {
            ((PbNewInputContainer) this.aUL).setHint(str);
        }
    }

    public EditText getInputView() {
        return this.aWL;
    }

    public void setType(int i) {
        if (this.aUL != null) {
            ((PbNewInputContainer) this.aUL).setType(i);
        }
    }

    public void fE(int i) {
        if (this.aUL != null) {
            ((PbNewInputContainer) this.aUL).fE(i);
        }
    }
}
