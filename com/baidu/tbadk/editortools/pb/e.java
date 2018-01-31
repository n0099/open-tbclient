package com.baidu.tbadk.editortools.pb;

import android.content.Context;
import android.text.TextWatcher;
import android.widget.EditText;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.editortools.r;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class e extends r {
    private EditText bsm;

    public e(Context context) {
        super(context, (String) null, 27);
        this.bra = false;
        this.bqZ = 3;
        this.bqj = new f(context);
        this.bsm = ((f) this.bqj).getInputView();
        ((f) this.bqj).setHint(context.getString(d.j.say_your_point));
        this.brb = new int[]{4, 17, 24, 3, 9, 6, 44, 12, 10, 13, 11, 28, 29, 39};
    }

    public void b(TextWatcher textWatcher) {
        this.bsm.addTextChangedListener(textWatcher);
    }

    public void c(TextWatcher textWatcher) {
        this.bsm.removeTextChangedListener(textWatcher);
    }

    public void setHint(String str) {
        if (this.bqj != null && !StringUtils.isNull(str)) {
            ((f) this.bqj).setHint(str);
        }
    }

    public EditText getInputView() {
        return this.bsm;
    }

    public void setType(int i) {
        if (this.bqj != null) {
            ((f) this.bqj).setType(i);
        }
    }

    public void hS(int i) {
        if (this.bqj != null) {
            ((f) this.bqj).hS(i);
        }
    }
}
