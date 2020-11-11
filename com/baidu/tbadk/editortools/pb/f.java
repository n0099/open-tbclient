package com.baidu.tbadk.editortools.pb;

import android.content.Context;
import android.text.TextWatcher;
import android.widget.EditText;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.editortools.m;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class f extends m {
    private EditText fpZ;

    public f(Context context, boolean z, boolean z2) {
        super(context, (String) null, 27);
        this.fok = false;
        this.foj = 3;
        this.fnp = new PbNewInputContainer(context);
        ((PbNewInputContainer) this.fnp).setTransLink(z ? false : true);
        this.fpZ = ((PbNewInputContainer) this.fnp).getInputView();
        ((PbNewInputContainer) this.fnp).setHint(context.getString(R.string.say_your_point));
        ((PbNewInputContainer) this.fnp).kn(z2);
        this.fol = new int[]{4, 17, 24, 3, 9, 6, 44, 12, 10, 13, 11, 28, 29, 39, 45};
    }

    public void b(TextWatcher textWatcher) {
        this.fpZ.addTextChangedListener(textWatcher);
    }

    public void c(TextWatcher textWatcher) {
        this.fpZ.removeTextChangedListener(textWatcher);
    }

    public void setHint(String str) {
        if (this.fnp != null && !StringUtils.isNull(str)) {
            ((PbNewInputContainer) this.fnp).setHint(str);
        }
    }

    public void setDefaultHint(String str) {
        if (this.fnp != null && !StringUtils.isNull(str)) {
            ((PbNewInputContainer) this.fnp).setDefaultHint(str);
        }
    }

    public EditText getInputView() {
        return this.fpZ;
    }

    public void setType(int i) {
        if (this.fnp != null) {
            ((PbNewInputContainer) this.fnp).setType(i);
        }
    }

    public void rw(int i) {
        if (this.fnp != null) {
            ((PbNewInputContainer) this.fnp).rw(i);
        }
    }
}
