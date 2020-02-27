package com.baidu.tbadk.editortools.pb;

import android.content.Context;
import android.text.TextWatcher;
import android.widget.EditText;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.editortools.l;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class f extends l {
    private EditText dyC;

    public f(Context context) {
        super(context, (String) null, 27);
        this.dxr = false;
        this.dxq = 3;
        this.dwz = new PbNewInputContainer(context);
        this.dyC = ((PbNewInputContainer) this.dwz).getInputView();
        ((PbNewInputContainer) this.dwz).setHint(context.getString(R.string.say_your_point));
        this.dxs = new int[]{4, 17, 24, 3, 9, 6, 44, 12, 10, 13, 11, 28, 29, 39};
    }

    public void c(TextWatcher textWatcher) {
        this.dyC.addTextChangedListener(textWatcher);
    }

    public void d(TextWatcher textWatcher) {
        this.dyC.removeTextChangedListener(textWatcher);
    }

    public void setHint(String str) {
        if (this.dwz != null && !StringUtils.isNull(str)) {
            ((PbNewInputContainer) this.dwz).setHint(str);
        }
    }

    public void setDefaultHint(String str) {
        if (this.dwz != null && !StringUtils.isNull(str)) {
            ((PbNewInputContainer) this.dwz).setDefaultHint(str);
        }
    }

    public EditText getInputView() {
        return this.dyC;
    }

    public void setType(int i) {
        if (this.dwz != null) {
            ((PbNewInputContainer) this.dwz).setType(i);
        }
    }

    public void mx(int i) {
        if (this.dwz != null) {
            ((PbNewInputContainer) this.dwz).mx(i);
        }
    }
}
