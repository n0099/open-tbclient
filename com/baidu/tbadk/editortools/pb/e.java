package com.baidu.tbadk.editortools.pb;

import android.content.Context;
import android.text.TextWatcher;
import android.widget.EditText;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.editortools.k;
import com.baidu.tieba.e;
/* loaded from: classes.dex */
public class e extends k {
    private EditText bai;

    public e(Context context) {
        super(context, (String) null, 27);
        this.aYZ = false;
        this.aYY = 3;
        this.aYi = new PbNewInputContainer(context);
        this.bai = ((PbNewInputContainer) this.aYi).getInputView();
        ((PbNewInputContainer) this.aYi).setHint(context.getString(e.j.say_your_point));
        this.aZa = new int[]{4, 17, 24, 3, 9, 6, 44, 12, 10, 13, 11, 28, 29, 39};
    }

    public void b(TextWatcher textWatcher) {
        this.bai.addTextChangedListener(textWatcher);
    }

    public void c(TextWatcher textWatcher) {
        this.bai.removeTextChangedListener(textWatcher);
    }

    public void setHint(String str) {
        if (this.aYi != null && !StringUtils.isNull(str)) {
            ((PbNewInputContainer) this.aYi).setHint(str);
        }
    }

    public EditText getInputView() {
        return this.bai;
    }

    public void setType(int i) {
        if (this.aYi != null) {
            ((PbNewInputContainer) this.aYi).setType(i);
        }
    }

    public void fS(int i) {
        if (this.aYi != null) {
            ((PbNewInputContainer) this.aYi).fS(i);
        }
    }
}
