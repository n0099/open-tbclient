package com.baidu.tbadk.editortools.pb;

import android.content.Context;
import android.text.TextWatcher;
import android.widget.EditText;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.editortools.m;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class f extends m {
    private EditText fDZ;

    public f(Context context, boolean z, boolean z2) {
        super(context, (String) null, 27);
        this.fCj = false;
        this.fCi = 3;
        this.fBo = new PbNewInputContainer(context);
        ((PbNewInputContainer) this.fBo).setTransLink(z ? false : true);
        this.fDZ = ((PbNewInputContainer) this.fBo).getInputView();
        ((PbNewInputContainer) this.fBo).setHint(context.getString(R.string.say_your_point));
        ((PbNewInputContainer) this.fBo).la(z2);
        this.fCk = new int[]{4, 17, 24, 3, 9, 6, 44, 12, 10, 13, 11, 28, 29, 39, 45};
    }

    public void b(TextWatcher textWatcher) {
        this.fDZ.addTextChangedListener(textWatcher);
    }

    public void c(TextWatcher textWatcher) {
        this.fDZ.removeTextChangedListener(textWatcher);
    }

    public void setHint(String str) {
        if (this.fBo != null && !StringUtils.isNull(str)) {
            ((PbNewInputContainer) this.fBo).setHint(str);
        }
    }

    public void setDefaultHint(String str) {
        if (this.fBo != null && !StringUtils.isNull(str)) {
            ((PbNewInputContainer) this.fBo).setDefaultHint(str);
        }
    }

    public EditText getInputView() {
        return this.fDZ;
    }

    public void setType(int i) {
        if (this.fBo != null) {
            ((PbNewInputContainer) this.fBo).setType(i);
        }
    }

    public void rg(int i) {
        if (this.fBo != null) {
            ((PbNewInputContainer) this.fBo).rg(i);
        }
    }
}
