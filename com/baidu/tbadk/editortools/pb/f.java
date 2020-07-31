package com.baidu.tbadk.editortools.pb;

import android.content.Context;
import android.text.TextWatcher;
import android.widget.EditText;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.editortools.l;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class f extends l {
    private EditText eCh;

    public f(Context context, boolean z, boolean z2) {
        super(context, (String) null, 27);
        this.eAT = false;
        this.eAS = 3;
        this.ezZ = new PbNewInputContainer(context);
        ((PbNewInputContainer) this.ezZ).setTransLink(z ? false : true);
        this.eCh = ((PbNewInputContainer) this.ezZ).getInputView();
        ((PbNewInputContainer) this.ezZ).setHint(context.getString(R.string.say_your_point));
        ((PbNewInputContainer) this.ezZ).iS(z2);
        this.eAU = new int[]{4, 17, 24, 3, 9, 6, 44, 12, 10, 13, 11, 28, 29, 39, 45};
    }

    public void b(TextWatcher textWatcher) {
        this.eCh.addTextChangedListener(textWatcher);
    }

    public void c(TextWatcher textWatcher) {
        this.eCh.removeTextChangedListener(textWatcher);
    }

    public void setHint(String str) {
        if (this.ezZ != null && !StringUtils.isNull(str)) {
            ((PbNewInputContainer) this.ezZ).setHint(str);
        }
    }

    public void setDefaultHint(String str) {
        if (this.ezZ != null && !StringUtils.isNull(str)) {
            ((PbNewInputContainer) this.ezZ).setDefaultHint(str);
        }
    }

    public EditText getInputView() {
        return this.eCh;
    }

    public void setType(int i) {
        if (this.ezZ != null) {
            ((PbNewInputContainer) this.ezZ).setType(i);
        }
    }

    public void ob(int i) {
        if (this.ezZ != null) {
            ((PbNewInputContainer) this.ezZ).ob(i);
        }
    }
}
