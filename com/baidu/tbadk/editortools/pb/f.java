package com.baidu.tbadk.editortools.pb;

import android.content.Context;
import android.text.TextWatcher;
import android.widget.EditText;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.editortools.m;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class f extends m {
    private EditText eMK;

    public f(Context context, boolean z, boolean z2) {
        super(context, (String) null, 27);
        this.eLw = false;
        this.eLv = 3;
        this.eKB = new PbNewInputContainer(context);
        ((PbNewInputContainer) this.eKB).setTransLink(z ? false : true);
        this.eMK = ((PbNewInputContainer) this.eKB).getInputView();
        ((PbNewInputContainer) this.eKB).setHint(context.getString(R.string.say_your_point));
        ((PbNewInputContainer) this.eKB).js(z2);
        this.eLx = new int[]{4, 17, 24, 3, 9, 6, 44, 12, 10, 13, 11, 28, 29, 39, 45};
    }

    public void b(TextWatcher textWatcher) {
        this.eMK.addTextChangedListener(textWatcher);
    }

    public void c(TextWatcher textWatcher) {
        this.eMK.removeTextChangedListener(textWatcher);
    }

    public void setHint(String str) {
        if (this.eKB != null && !StringUtils.isNull(str)) {
            ((PbNewInputContainer) this.eKB).setHint(str);
        }
    }

    public void setDefaultHint(String str) {
        if (this.eKB != null && !StringUtils.isNull(str)) {
            ((PbNewInputContainer) this.eKB).setDefaultHint(str);
        }
    }

    public EditText getInputView() {
        return this.eMK;
    }

    public void setType(int i) {
        if (this.eKB != null) {
            ((PbNewInputContainer) this.eKB).setType(i);
        }
    }

    public void qm(int i) {
        if (this.eKB != null) {
            ((PbNewInputContainer) this.eKB).qm(i);
        }
    }
}
