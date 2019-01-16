package com.baidu.tbadk.editortools.pb;

import android.content.Context;
import android.text.TextWatcher;
import android.widget.EditText;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.editortools.k;
import com.baidu.tieba.e;
/* loaded from: classes.dex */
public class e extends k {
    private EditText baW;

    public e(Context context) {
        super(context, (String) null, 27);
        this.aZM = false;
        this.aZL = 3;
        this.aYV = new PbNewInputContainer(context);
        this.baW = ((PbNewInputContainer) this.aYV).getInputView();
        ((PbNewInputContainer) this.aYV).setHint(context.getString(e.j.say_your_point));
        this.aZN = new int[]{4, 17, 24, 3, 9, 6, 44, 12, 10, 13, 11, 28, 29, 39};
    }

    public void b(TextWatcher textWatcher) {
        this.baW.addTextChangedListener(textWatcher);
    }

    public void c(TextWatcher textWatcher) {
        this.baW.removeTextChangedListener(textWatcher);
    }

    public void setHint(String str) {
        if (this.aYV != null && !StringUtils.isNull(str)) {
            ((PbNewInputContainer) this.aYV).setHint(str);
        }
    }

    public EditText getInputView() {
        return this.baW;
    }

    public void setType(int i) {
        if (this.aYV != null) {
            ((PbNewInputContainer) this.aYV).setType(i);
        }
    }

    public void fT(int i) {
        if (this.aYV != null) {
            ((PbNewInputContainer) this.aYV).fT(i);
        }
    }
}
