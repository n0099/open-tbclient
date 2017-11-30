package com.baidu.tbadk.editortools.pb;

import android.content.Context;
import android.text.TextWatcher;
import android.widget.EditText;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.editortools.r;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class e extends r {
    private EditText aDS;

    public e(Context context) {
        super(context, (String) null, 27);
        this.aCF = false;
        this.aCE = 3;
        this.aBO = new f(context);
        this.aDS = ((f) this.aBO).getInputView();
        ((f) this.aBO).setHint(context.getString(d.j.say_your_point));
        this.aCG = new int[]{4, 17, 24, 3, 9, 6, 44, 12, 10, 13, 11, 28, 29, 39};
    }

    public void b(TextWatcher textWatcher) {
        this.aDS.addTextChangedListener(textWatcher);
    }

    public void c(TextWatcher textWatcher) {
        this.aDS.removeTextChangedListener(textWatcher);
    }

    public void setHint(String str) {
        if (this.aBO != null && !StringUtils.isNull(str)) {
            ((f) this.aBO).setHint(str);
        }
    }

    public EditText getInputView() {
        return this.aDS;
    }

    public void setType(int i) {
        if (this.aBO != null) {
            ((f) this.aBO).setType(i);
        }
    }

    public void eY(int i) {
        if (this.aBO != null) {
            ((f) this.aBO).eY(i);
        }
    }
}
