package com.baidu.tbadk.editortools.pb;

import android.content.Context;
import android.text.TextWatcher;
import android.widget.EditText;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.editortools.r;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class e extends r {
    private EditText aEa;

    public e(Context context) {
        super(context, (String) null, 27);
        this.aCN = false;
        this.aCM = 3;
        this.aBW = new f(context);
        this.aEa = ((f) this.aBW).getInputView();
        ((f) this.aBW).setHint(context.getString(d.j.say_your_point));
        this.aCO = new int[]{4, 17, 24, 3, 9, 6, 44, 12, 10, 13, 11, 28, 29, 39};
    }

    public void b(TextWatcher textWatcher) {
        this.aEa.addTextChangedListener(textWatcher);
    }

    public void c(TextWatcher textWatcher) {
        this.aEa.removeTextChangedListener(textWatcher);
    }

    public void setHint(String str) {
        if (this.aBW != null && !StringUtils.isNull(str)) {
            ((f) this.aBW).setHint(str);
        }
    }

    public EditText getInputView() {
        return this.aEa;
    }

    public void setType(int i) {
        if (this.aBW != null) {
            ((f) this.aBW).setType(i);
        }
    }

    public void eY(int i) {
        if (this.aBW != null) {
            ((f) this.aBW).eY(i);
        }
    }
}
