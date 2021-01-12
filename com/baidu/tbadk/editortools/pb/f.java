package com.baidu.tbadk.editortools.pb;

import android.content.Context;
import android.text.TextWatcher;
import android.widget.EditText;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.editortools.m;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class f extends m {
    private EditText fBK;

    public f(Context context, boolean z, boolean z2) {
        super(context, (String) null, 27);
        this.fzU = false;
        this.fzT = 3;
        this.fyZ = new PbNewInputContainer(context);
        ((PbNewInputContainer) this.fyZ).setTransLink(z ? false : true);
        this.fBK = ((PbNewInputContainer) this.fyZ).getInputView();
        ((PbNewInputContainer) this.fyZ).setHint(context.getString(R.string.say_your_point));
        ((PbNewInputContainer) this.fyZ).kX(z2);
        this.fzV = new int[]{4, 17, 24, 3, 9, 6, 44, 12, 10, 13, 11, 28, 29, 39, 45};
    }

    public void b(TextWatcher textWatcher) {
        this.fBK.addTextChangedListener(textWatcher);
    }

    public void c(TextWatcher textWatcher) {
        this.fBK.removeTextChangedListener(textWatcher);
    }

    public void setHint(String str) {
        if (this.fyZ != null && !StringUtils.isNull(str)) {
            ((PbNewInputContainer) this.fyZ).setHint(str);
        }
    }

    public void setDefaultHint(String str) {
        if (this.fyZ != null && !StringUtils.isNull(str)) {
            ((PbNewInputContainer) this.fyZ).setDefaultHint(str);
        }
    }

    public EditText getInputView() {
        return this.fBK;
    }

    public void setType(int i) {
        if (this.fyZ != null) {
            ((PbNewInputContainer) this.fyZ).setType(i);
        }
    }

    public void rb(int i) {
        if (this.fyZ != null) {
            ((PbNewInputContainer) this.fyZ).rb(i);
        }
    }
}
