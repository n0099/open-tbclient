package com.baidu.tbadk.editortools.pb;

import android.content.Context;
import android.text.TextWatcher;
import android.widget.EditText;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.editortools.m;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class f extends m {
    private EditText fFy;

    public f(Context context, boolean z, boolean z2) {
        super(context, (String) null, 27);
        this.fDI = false;
        this.fDH = 3;
        this.fCN = new PbNewInputContainer(context);
        ((PbNewInputContainer) this.fCN).setTransLink(z ? false : true);
        this.fFy = ((PbNewInputContainer) this.fCN).getInputView();
        ((PbNewInputContainer) this.fCN).setHint(context.getString(R.string.say_your_point));
        ((PbNewInputContainer) this.fCN).la(z2);
        this.fDJ = new int[]{4, 17, 24, 3, 9, 6, 44, 12, 10, 13, 11, 28, 29, 39, 45};
    }

    public void b(TextWatcher textWatcher) {
        this.fFy.addTextChangedListener(textWatcher);
    }

    public void c(TextWatcher textWatcher) {
        this.fFy.removeTextChangedListener(textWatcher);
    }

    public void setHint(String str) {
        if (this.fCN != null && !StringUtils.isNull(str)) {
            ((PbNewInputContainer) this.fCN).setHint(str);
        }
    }

    public void setDefaultHint(String str) {
        if (this.fCN != null && !StringUtils.isNull(str)) {
            ((PbNewInputContainer) this.fCN).setDefaultHint(str);
        }
    }

    public EditText getInputView() {
        return this.fFy;
    }

    public void setType(int i) {
        if (this.fCN != null) {
            ((PbNewInputContainer) this.fCN).setType(i);
        }
    }

    public void rh(int i) {
        if (this.fCN != null) {
            ((PbNewInputContainer) this.fCN).rh(i);
        }
    }
}
