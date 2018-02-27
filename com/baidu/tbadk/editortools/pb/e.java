package com.baidu.tbadk.editortools.pb;

import android.content.Context;
import android.text.TextWatcher;
import android.widget.EditText;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.editortools.r;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class e extends r {
    private EditText bum;

    public e(Context context) {
        super(context, (String) null, 27);
        this.bta = false;
        this.bsZ = 3;
        this.bsj = new f(context);
        this.bum = ((f) this.bsj).getInputView();
        ((f) this.bsj).setHint(context.getString(d.j.say_your_point));
        this.btb = new int[]{4, 17, 24, 3, 9, 6, 44, 12, 10, 13, 11, 28, 29, 39};
    }

    public void b(TextWatcher textWatcher) {
        this.bum.addTextChangedListener(textWatcher);
    }

    public void c(TextWatcher textWatcher) {
        this.bum.removeTextChangedListener(textWatcher);
    }

    public void setHint(String str) {
        if (this.bsj != null && !StringUtils.isNull(str)) {
            ((f) this.bsj).setHint(str);
        }
    }

    public EditText getInputView() {
        return this.bum;
    }

    public void setType(int i) {
        if (this.bsj != null) {
            ((f) this.bsj).setType(i);
        }
    }

    public void hQ(int i) {
        if (this.bsj != null) {
            ((f) this.bsj).hQ(i);
        }
    }
}
