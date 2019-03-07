package com.baidu.tbadk.editortools.pb;

import android.content.Context;
import android.text.TextWatcher;
import android.widget.EditText;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.editortools.k;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class e extends k {
    private EditText ckv;

    public e(Context context) {
        super(context, (String) null, 27);
        this.cjm = false;
        this.cjl = 3;
        this.ciu = new PbNewInputContainer(context);
        this.ckv = ((PbNewInputContainer) this.ciu).getInputView();
        ((PbNewInputContainer) this.ciu).setHint(context.getString(d.j.say_your_point));
        this.cjn = new int[]{4, 17, 24, 3, 9, 6, 44, 12, 10, 13, 11, 28, 29, 39};
    }

    public void c(TextWatcher textWatcher) {
        this.ckv.addTextChangedListener(textWatcher);
    }

    public void d(TextWatcher textWatcher) {
        this.ckv.removeTextChangedListener(textWatcher);
    }

    public void setHint(String str) {
        if (this.ciu != null && !StringUtils.isNull(str)) {
            ((PbNewInputContainer) this.ciu).setHint(str);
        }
    }

    public void setDefaultHint(String str) {
        if (this.ciu != null && !StringUtils.isNull(str)) {
            ((PbNewInputContainer) this.ciu).setDefaultHint(str);
        }
    }

    public EditText getInputView() {
        return this.ckv;
    }

    public void setType(int i) {
        if (this.ciu != null) {
            ((PbNewInputContainer) this.ciu).setType(i);
        }
    }

    public void jE(int i) {
        if (this.ciu != null) {
            ((PbNewInputContainer) this.ciu).jE(i);
        }
    }
}
