package com.baidu.tbadk.editortools.pb;

import android.content.Context;
import android.text.TextWatcher;
import android.widget.EditText;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.editortools.k;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class e extends k {
    private EditText cky;

    public e(Context context) {
        super(context, (String) null, 27);
        this.cjp = false;
        this.cjo = 3;
        this.cix = new PbNewInputContainer(context);
        this.cky = ((PbNewInputContainer) this.cix).getInputView();
        ((PbNewInputContainer) this.cix).setHint(context.getString(d.j.say_your_point));
        this.cjq = new int[]{4, 17, 24, 3, 9, 6, 44, 12, 10, 13, 11, 28, 29, 39};
    }

    public void c(TextWatcher textWatcher) {
        this.cky.addTextChangedListener(textWatcher);
    }

    public void d(TextWatcher textWatcher) {
        this.cky.removeTextChangedListener(textWatcher);
    }

    public void setHint(String str) {
        if (this.cix != null && !StringUtils.isNull(str)) {
            ((PbNewInputContainer) this.cix).setHint(str);
        }
    }

    public void setDefaultHint(String str) {
        if (this.cix != null && !StringUtils.isNull(str)) {
            ((PbNewInputContainer) this.cix).setDefaultHint(str);
        }
    }

    public EditText getInputView() {
        return this.cky;
    }

    public void setType(int i) {
        if (this.cix != null) {
            ((PbNewInputContainer) this.cix).setType(i);
        }
    }

    public void jD(int i) {
        if (this.cix != null) {
            ((PbNewInputContainer) this.cix).jD(i);
        }
    }
}
