package com.baidu.tbadk.editortools.pb;

import android.content.Context;
import android.text.TextWatcher;
import android.widget.EditText;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.editortools.r;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class e extends r {
    private EditText brU;

    public e(Context context) {
        super(context, (String) null, 27);
        this.bqI = false;
        this.bqH = 3;
        this.bpR = new f(context);
        this.brU = ((f) this.bpR).getInputView();
        ((f) this.bpR).setHint(context.getString(d.j.say_your_point));
        this.bqJ = new int[]{4, 17, 24, 3, 9, 6, 44, 12, 10, 13, 11, 28, 29, 39};
    }

    public void b(TextWatcher textWatcher) {
        this.brU.addTextChangedListener(textWatcher);
    }

    public void c(TextWatcher textWatcher) {
        this.brU.removeTextChangedListener(textWatcher);
    }

    public void setHint(String str) {
        if (this.bpR != null && !StringUtils.isNull(str)) {
            ((f) this.bpR).setHint(str);
        }
    }

    public EditText getInputView() {
        return this.brU;
    }

    public void setType(int i) {
        if (this.bpR != null) {
            ((f) this.bpR).setType(i);
        }
    }

    public void hW(int i) {
        if (this.bpR != null) {
            ((f) this.bpR).hW(i);
        }
    }
}
