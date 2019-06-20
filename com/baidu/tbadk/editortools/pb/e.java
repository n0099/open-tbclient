package com.baidu.tbadk.editortools.pb;

import android.content.Context;
import android.text.TextWatcher;
import android.widget.EditText;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.editortools.k;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class e extends k {
    private EditText csH;

    public e(Context context) {
        super(context, (String) null, 27);
        this.cry = false;
        this.crx = 3;
        this.cqF = new PbNewInputContainer(context);
        this.csH = ((PbNewInputContainer) this.cqF).getInputView();
        ((PbNewInputContainer) this.cqF).setHint(context.getString(R.string.say_your_point));
        this.crz = new int[]{4, 17, 24, 3, 9, 6, 44, 12, 10, 13, 11, 28, 29, 39};
    }

    public void c(TextWatcher textWatcher) {
        this.csH.addTextChangedListener(textWatcher);
    }

    public void d(TextWatcher textWatcher) {
        this.csH.removeTextChangedListener(textWatcher);
    }

    public void setHint(String str) {
        if (this.cqF != null && !StringUtils.isNull(str)) {
            ((PbNewInputContainer) this.cqF).setHint(str);
        }
    }

    public void setDefaultHint(String str) {
        if (this.cqF != null && !StringUtils.isNull(str)) {
            ((PbNewInputContainer) this.cqF).setDefaultHint(str);
        }
    }

    public EditText getInputView() {
        return this.csH;
    }

    public void setType(int i) {
        if (this.cqF != null) {
            ((PbNewInputContainer) this.cqF).setType(i);
        }
    }

    public void kr(int i) {
        if (this.cqF != null) {
            ((PbNewInputContainer) this.cqF).kr(i);
        }
    }
}
