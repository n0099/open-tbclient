package com.baidu.tbadk.editortools.pb;

import android.content.Context;
import android.text.TextWatcher;
import android.widget.EditText;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.editortools.m;
import com.baidu.tieba.R;
/* loaded from: classes2.dex */
public class f extends m {
    private EditText eMG;

    public f(Context context, boolean z, boolean z2) {
        super(context, (String) null, 27);
        this.eLs = false;
        this.eLr = 3;
        this.eKx = new PbNewInputContainer(context);
        ((PbNewInputContainer) this.eKx).setTransLink(z ? false : true);
        this.eMG = ((PbNewInputContainer) this.eKx).getInputView();
        ((PbNewInputContainer) this.eKx).setHint(context.getString(R.string.say_your_point));
        ((PbNewInputContainer) this.eKx).jq(z2);
        this.eLt = new int[]{4, 17, 24, 3, 9, 6, 44, 12, 10, 13, 11, 28, 29, 39, 45};
    }

    public void b(TextWatcher textWatcher) {
        this.eMG.addTextChangedListener(textWatcher);
    }

    public void c(TextWatcher textWatcher) {
        this.eMG.removeTextChangedListener(textWatcher);
    }

    public void setHint(String str) {
        if (this.eKx != null && !StringUtils.isNull(str)) {
            ((PbNewInputContainer) this.eKx).setHint(str);
        }
    }

    public void setDefaultHint(String str) {
        if (this.eKx != null && !StringUtils.isNull(str)) {
            ((PbNewInputContainer) this.eKx).setDefaultHint(str);
        }
    }

    public EditText getInputView() {
        return this.eMG;
    }

    public void setType(int i) {
        if (this.eKx != null) {
            ((PbNewInputContainer) this.eKx).setType(i);
        }
    }

    public void qm(int i) {
        if (this.eKx != null) {
            ((PbNewInputContainer) this.eKx).qm(i);
        }
    }
}
