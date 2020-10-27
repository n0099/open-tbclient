package com.baidu.tbadk.editortools.pb;

import android.content.Context;
import android.text.TextWatcher;
import android.widget.EditText;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.editortools.m;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class f extends m {
    private EditText fkh;

    public f(Context context, boolean z, boolean z2) {
        super(context, (String) null, 27);
        this.fis = false;
        this.fir = 3;
        this.fhv = new PbNewInputContainer(context);
        ((PbNewInputContainer) this.fhv).setTransLink(z ? false : true);
        this.fkh = ((PbNewInputContainer) this.fhv).getInputView();
        ((PbNewInputContainer) this.fhv).setHint(context.getString(R.string.say_your_point));
        ((PbNewInputContainer) this.fhv).ke(z2);
        this.fit = new int[]{4, 17, 24, 3, 9, 6, 44, 12, 10, 13, 11, 28, 29, 39, 45};
    }

    public void b(TextWatcher textWatcher) {
        this.fkh.addTextChangedListener(textWatcher);
    }

    public void c(TextWatcher textWatcher) {
        this.fkh.removeTextChangedListener(textWatcher);
    }

    public void setHint(String str) {
        if (this.fhv != null && !StringUtils.isNull(str)) {
            ((PbNewInputContainer) this.fhv).setHint(str);
        }
    }

    public void setDefaultHint(String str) {
        if (this.fhv != null && !StringUtils.isNull(str)) {
            ((PbNewInputContainer) this.fhv).setDefaultHint(str);
        }
    }

    public EditText getInputView() {
        return this.fkh;
    }

    public void setType(int i) {
        if (this.fhv != null) {
            ((PbNewInputContainer) this.fhv).setType(i);
        }
    }

    public void rm(int i) {
        if (this.fhv != null) {
            ((PbNewInputContainer) this.fhv).rm(i);
        }
    }
}
