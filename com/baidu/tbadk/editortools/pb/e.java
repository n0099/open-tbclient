package com.baidu.tbadk.editortools.pb;

import android.content.Context;
import android.text.TextWatcher;
import android.widget.EditText;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.editortools.r;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class e extends r {
    private EditText bsd;

    public e(Context context) {
        super(context, (String) null, 27);
        this.bqR = false;
        this.bqQ = 3;
        this.bqa = new f(context);
        this.bsd = ((f) this.bqa).getInputView();
        ((f) this.bqa).setHint(context.getString(d.j.say_your_point));
        this.bqS = new int[]{4, 17, 24, 3, 9, 6, 44, 12, 10, 13, 11, 28, 29, 39};
    }

    public void b(TextWatcher textWatcher) {
        this.bsd.addTextChangedListener(textWatcher);
    }

    public void c(TextWatcher textWatcher) {
        this.bsd.removeTextChangedListener(textWatcher);
    }

    public void setHint(String str) {
        if (this.bqa != null && !StringUtils.isNull(str)) {
            ((f) this.bqa).setHint(str);
        }
    }

    public EditText getInputView() {
        return this.bsd;
    }

    public void setType(int i) {
        if (this.bqa != null) {
            ((f) this.bqa).setType(i);
        }
    }

    public void hS(int i) {
        if (this.bqa != null) {
            ((f) this.bqa).hS(i);
        }
    }
}
