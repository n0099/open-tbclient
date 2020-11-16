package com.baidu.tbadk.editortools.pb;

import android.content.Context;
import android.text.TextWatcher;
import android.widget.EditText;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.editortools.m;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class f extends m {
    private EditText fpg;

    public f(Context context, boolean z, boolean z2) {
        super(context, (String) null, 27);
        this.fns = false;
        this.fnr = 3;
        this.fmx = new PbNewInputContainer(context);
        ((PbNewInputContainer) this.fmx).setTransLink(z ? false : true);
        this.fpg = ((PbNewInputContainer) this.fmx).getInputView();
        ((PbNewInputContainer) this.fmx).setHint(context.getString(R.string.say_your_point));
        ((PbNewInputContainer) this.fmx).ko(z2);
        this.fnt = new int[]{4, 17, 24, 3, 9, 6, 44, 12, 10, 13, 11, 28, 29, 39, 45};
    }

    public void b(TextWatcher textWatcher) {
        this.fpg.addTextChangedListener(textWatcher);
    }

    public void c(TextWatcher textWatcher) {
        this.fpg.removeTextChangedListener(textWatcher);
    }

    public void setHint(String str) {
        if (this.fmx != null && !StringUtils.isNull(str)) {
            ((PbNewInputContainer) this.fmx).setHint(str);
        }
    }

    public void setDefaultHint(String str) {
        if (this.fmx != null && !StringUtils.isNull(str)) {
            ((PbNewInputContainer) this.fmx).setDefaultHint(str);
        }
    }

    public EditText getInputView() {
        return this.fpg;
    }

    public void setType(int i) {
        if (this.fmx != null) {
            ((PbNewInputContainer) this.fmx).setType(i);
        }
    }

    public void rU(int i) {
        if (this.fmx != null) {
            ((PbNewInputContainer) this.fmx).rU(i);
        }
    }
}
