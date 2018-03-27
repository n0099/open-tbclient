package com.baidu.tbadk.editortools.pb;

import android.content.Context;
import android.text.TextWatcher;
import android.widget.EditText;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.editortools.r;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class e extends r {
    private EditText bup;

    public e(Context context) {
        super(context, (String) null, 27);
        this.btd = false;
        this.btc = 3;
        this.bsm = new f(context);
        this.bup = ((f) this.bsm).getInputView();
        ((f) this.bsm).setHint(context.getString(d.j.say_your_point));
        this.bte = new int[]{4, 17, 24, 3, 9, 6, 44, 12, 10, 13, 11, 28, 29, 39};
    }

    public void b(TextWatcher textWatcher) {
        this.bup.addTextChangedListener(textWatcher);
    }

    public void c(TextWatcher textWatcher) {
        this.bup.removeTextChangedListener(textWatcher);
    }

    public void setHint(String str) {
        if (this.bsm != null && !StringUtils.isNull(str)) {
            ((f) this.bsm).setHint(str);
        }
    }

    public EditText getInputView() {
        return this.bup;
    }

    public void setType(int i) {
        if (this.bsm != null) {
            ((f) this.bsm).setType(i);
        }
    }

    public void hQ(int i) {
        if (this.bsm != null) {
            ((f) this.bsm).hQ(i);
        }
    }
}
