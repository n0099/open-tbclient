package com.baidu.tbadk.editortools.pb;

import android.content.Context;
import android.text.TextWatcher;
import android.widget.EditText;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.editortools.m;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class f extends m {
    private EditText fGr;

    public f(Context context, boolean z, boolean z2) {
        super(context, (String) null, 27);
        this.fEC = false;
        this.fEB = 3;
        this.fDH = new PbNewInputContainer(context);
        ((PbNewInputContainer) this.fDH).setTransLink(z ? false : true);
        this.fGr = ((PbNewInputContainer) this.fDH).getInputView();
        ((PbNewInputContainer) this.fDH).setHint(context.getString(R.string.say_your_point));
        ((PbNewInputContainer) this.fDH).lb(z2);
        this.fED = new int[]{4, 17, 24, 3, 9, 6, 44, 12, 10, 13, 11, 28, 29, 39, 45};
    }

    public void b(TextWatcher textWatcher) {
        this.fGr.addTextChangedListener(textWatcher);
    }

    public void c(TextWatcher textWatcher) {
        this.fGr.removeTextChangedListener(textWatcher);
    }

    public void setHint(String str) {
        if (this.fDH != null && !StringUtils.isNull(str)) {
            ((PbNewInputContainer) this.fDH).setHint(str);
        }
    }

    public void setDefaultHint(String str) {
        if (this.fDH != null && !StringUtils.isNull(str)) {
            ((PbNewInputContainer) this.fDH).setDefaultHint(str);
        }
    }

    public EditText getInputView() {
        return this.fGr;
    }

    public void setType(int i) {
        if (this.fDH != null) {
            ((PbNewInputContainer) this.fDH).setType(i);
        }
    }

    public void sH(int i) {
        if (this.fDH != null) {
            ((PbNewInputContainer) this.fDH).sH(i);
        }
    }
}
