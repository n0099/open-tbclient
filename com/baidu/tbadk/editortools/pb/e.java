package com.baidu.tbadk.editortools.pb;

import android.content.Context;
import android.text.TextWatcher;
import android.widget.EditText;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.editortools.k;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class e extends k {
    private EditText ctU;

    public e(Context context) {
        super(context, (String) null, 27);
        this.csL = false;
        this.csK = 3;
        this.crT = new PbNewInputContainer(context);
        this.ctU = ((PbNewInputContainer) this.crT).getInputView();
        ((PbNewInputContainer) this.crT).setHint(context.getString(R.string.say_your_point));
        this.csM = new int[]{4, 17, 24, 3, 9, 6, 44, 12, 10, 13, 11, 28, 29, 39};
    }

    public void c(TextWatcher textWatcher) {
        this.ctU.addTextChangedListener(textWatcher);
    }

    public void d(TextWatcher textWatcher) {
        this.ctU.removeTextChangedListener(textWatcher);
    }

    public void setHint(String str) {
        if (this.crT != null && !StringUtils.isNull(str)) {
            ((PbNewInputContainer) this.crT).setHint(str);
        }
    }

    public void setDefaultHint(String str) {
        if (this.crT != null && !StringUtils.isNull(str)) {
            ((PbNewInputContainer) this.crT).setDefaultHint(str);
        }
    }

    public EditText getInputView() {
        return this.ctU;
    }

    public void setType(int i) {
        if (this.crT != null) {
            ((PbNewInputContainer) this.crT).setType(i);
        }
    }

    public void kx(int i) {
        if (this.crT != null) {
            ((PbNewInputContainer) this.crT).kx(i);
        }
    }
}
