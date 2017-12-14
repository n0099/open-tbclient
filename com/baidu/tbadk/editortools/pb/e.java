package com.baidu.tbadk.editortools.pb;

import android.content.Context;
import android.text.TextWatcher;
import android.widget.EditText;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.editortools.r;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class e extends r {
    private EditText aDX;

    public e(Context context) {
        super(context, (String) null, 27);
        this.aCK = false;
        this.aCJ = 3;
        this.aBT = new f(context);
        this.aDX = ((f) this.aBT).getInputView();
        ((f) this.aBT).setHint(context.getString(d.j.say_your_point));
        this.aCL = new int[]{4, 17, 24, 3, 9, 6, 44, 12, 10, 13, 11, 28, 29, 39};
    }

    public void b(TextWatcher textWatcher) {
        this.aDX.addTextChangedListener(textWatcher);
    }

    public void c(TextWatcher textWatcher) {
        this.aDX.removeTextChangedListener(textWatcher);
    }

    public void setHint(String str) {
        if (this.aBT != null && !StringUtils.isNull(str)) {
            ((f) this.aBT).setHint(str);
        }
    }

    public EditText getInputView() {
        return this.aDX;
    }

    public void setType(int i) {
        if (this.aBT != null) {
            ((f) this.aBT).setType(i);
        }
    }

    public void eY(int i) {
        if (this.aBT != null) {
            ((f) this.aBT).eY(i);
        }
    }
}
