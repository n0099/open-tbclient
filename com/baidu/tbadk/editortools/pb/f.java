package com.baidu.tbadk.editortools.pb;

import android.content.Context;
import android.text.TextWatcher;
import android.widget.EditText;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.editortools.l;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class f extends l {
    private EditText emY;

    public f(Context context) {
        super(context, (String) null, 27);
        this.elN = false;
        this.elM = 3;
        this.ekV = new PbNewInputContainer(context);
        this.emY = ((PbNewInputContainer) this.ekV).getInputView();
        ((PbNewInputContainer) this.ekV).setHint(context.getString(R.string.say_your_point));
        this.elO = new int[]{4, 17, 24, 3, 9, 6, 44, 12, 10, 13, 11, 28, 29, 39};
    }

    public void b(TextWatcher textWatcher) {
        this.emY.addTextChangedListener(textWatcher);
    }

    public void c(TextWatcher textWatcher) {
        this.emY.removeTextChangedListener(textWatcher);
    }

    public void setHint(String str) {
        if (this.ekV != null && !StringUtils.isNull(str)) {
            ((PbNewInputContainer) this.ekV).setHint(str);
        }
    }

    public void setDefaultHint(String str) {
        if (this.ekV != null && !StringUtils.isNull(str)) {
            ((PbNewInputContainer) this.ekV).setDefaultHint(str);
        }
    }

    public EditText getInputView() {
        return this.emY;
    }

    public void setType(int i) {
        if (this.ekV != null) {
            ((PbNewInputContainer) this.ekV).setType(i);
        }
    }

    public void np(int i) {
        if (this.ekV != null) {
            ((PbNewInputContainer) this.ekV).np(i);
        }
    }
}
