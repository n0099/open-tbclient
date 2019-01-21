package com.baidu.tbadk.editortools.pb;

import android.content.Context;
import android.text.TextWatcher;
import android.widget.EditText;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.editortools.k;
import com.baidu.tieba.e;
/* loaded from: classes.dex */
public class e extends k {
    private EditText baX;

    public e(Context context) {
        super(context, (String) null, 27);
        this.aZN = false;
        this.aZM = 3;
        this.aYW = new PbNewInputContainer(context);
        this.baX = ((PbNewInputContainer) this.aYW).getInputView();
        ((PbNewInputContainer) this.aYW).setHint(context.getString(e.j.say_your_point));
        this.aZO = new int[]{4, 17, 24, 3, 9, 6, 44, 12, 10, 13, 11, 28, 29, 39};
    }

    public void b(TextWatcher textWatcher) {
        this.baX.addTextChangedListener(textWatcher);
    }

    public void c(TextWatcher textWatcher) {
        this.baX.removeTextChangedListener(textWatcher);
    }

    public void setHint(String str) {
        if (this.aYW != null && !StringUtils.isNull(str)) {
            ((PbNewInputContainer) this.aYW).setHint(str);
        }
    }

    public EditText getInputView() {
        return this.baX;
    }

    public void setType(int i) {
        if (this.aYW != null) {
            ((PbNewInputContainer) this.aYW).setType(i);
        }
    }

    public void fT(int i) {
        if (this.aYW != null) {
            ((PbNewInputContainer) this.aYW).fT(i);
        }
    }
}
