package com.baidu.tbadk.editortools.pb;

import android.content.Context;
import android.text.TextWatcher;
import android.widget.EditText;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.editortools.k;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class e extends k {
    private EditText ckx;

    public e(Context context) {
        super(context, (String) null, 27);
        this.cjo = false;
        this.cjn = 3;
        this.ciw = new PbNewInputContainer(context);
        this.ckx = ((PbNewInputContainer) this.ciw).getInputView();
        ((PbNewInputContainer) this.ciw).setHint(context.getString(d.j.say_your_point));
        this.cjp = new int[]{4, 17, 24, 3, 9, 6, 44, 12, 10, 13, 11, 28, 29, 39};
    }

    public void c(TextWatcher textWatcher) {
        this.ckx.addTextChangedListener(textWatcher);
    }

    public void d(TextWatcher textWatcher) {
        this.ckx.removeTextChangedListener(textWatcher);
    }

    public void setHint(String str) {
        if (this.ciw != null && !StringUtils.isNull(str)) {
            ((PbNewInputContainer) this.ciw).setHint(str);
        }
    }

    public void setDefaultHint(String str) {
        if (this.ciw != null && !StringUtils.isNull(str)) {
            ((PbNewInputContainer) this.ciw).setDefaultHint(str);
        }
    }

    public EditText getInputView() {
        return this.ckx;
    }

    public void setType(int i) {
        if (this.ciw != null) {
            ((PbNewInputContainer) this.ciw).setType(i);
        }
    }

    public void jD(int i) {
        if (this.ciw != null) {
            ((PbNewInputContainer) this.ciw).jD(i);
        }
    }
}
