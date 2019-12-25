package com.baidu.tbadk.editortools.pb;

import android.content.Context;
import android.text.TextWatcher;
import android.widget.EditText;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.editortools.l;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class f extends l {
    private EditText dul;

    public f(Context context) {
        super(context, (String) null, 27);
        this.dta = false;
        this.dsZ = 3;
        this.dsh = new PbNewInputContainer(context);
        this.dul = ((PbNewInputContainer) this.dsh).getInputView();
        ((PbNewInputContainer) this.dsh).setHint(context.getString(R.string.say_your_point));
        this.dtb = new int[]{4, 17, 24, 3, 9, 6, 44, 12, 10, 13, 11, 28, 29, 39};
    }

    public void c(TextWatcher textWatcher) {
        this.dul.addTextChangedListener(textWatcher);
    }

    public void d(TextWatcher textWatcher) {
        this.dul.removeTextChangedListener(textWatcher);
    }

    public void setHint(String str) {
        if (this.dsh != null && !StringUtils.isNull(str)) {
            ((PbNewInputContainer) this.dsh).setHint(str);
        }
    }

    public void setDefaultHint(String str) {
        if (this.dsh != null && !StringUtils.isNull(str)) {
            ((PbNewInputContainer) this.dsh).setDefaultHint(str);
        }
    }

    public EditText getInputView() {
        return this.dul;
    }

    public void setType(int i) {
        if (this.dsh != null) {
            ((PbNewInputContainer) this.dsh).setType(i);
        }
    }

    public void mf(int i) {
        if (this.dsh != null) {
            ((PbNewInputContainer) this.dsh).mf(i);
        }
    }
}
