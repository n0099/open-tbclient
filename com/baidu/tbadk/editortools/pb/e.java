package com.baidu.tbadk.editortools.pb;

import android.content.Context;
import android.text.TextWatcher;
import android.widget.EditText;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.editortools.r;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class e extends r {
    private EditText buz;

    public e(Context context) {
        super(context, (String) null, 27);
        this.bto = false;
        this.btm = 3;
        this.bsw = new f(context);
        this.buz = ((f) this.bsw).getInputView();
        ((f) this.bsw).setHint(context.getString(d.j.say_your_point));
        this.btp = new int[]{4, 17, 24, 3, 9, 6, 44, 12, 10, 13, 11, 28, 29, 39};
    }

    public void b(TextWatcher textWatcher) {
        this.buz.addTextChangedListener(textWatcher);
    }

    public void c(TextWatcher textWatcher) {
        this.buz.removeTextChangedListener(textWatcher);
    }

    public void setHint(String str) {
        if (this.bsw != null && !StringUtils.isNull(str)) {
            ((f) this.bsw).setHint(str);
        }
    }

    public EditText getInputView() {
        return this.buz;
    }

    public void setType(int i) {
        if (this.bsw != null) {
            ((f) this.bsw).setType(i);
        }
    }

    public void hQ(int i) {
        if (this.bsw != null) {
            ((f) this.bsw).hQ(i);
        }
    }
}
