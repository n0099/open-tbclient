package com.baidu.tbadk.editortools.pb;

import android.content.Context;
import android.text.TextWatcher;
import android.widget.EditText;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.editortools.k;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class e extends k {
    private EditText csG;

    public e(Context context) {
        super(context, (String) null, 27);
        this.crx = false;
        this.crw = 3;
        this.cqE = new PbNewInputContainer(context);
        this.csG = ((PbNewInputContainer) this.cqE).getInputView();
        ((PbNewInputContainer) this.cqE).setHint(context.getString(R.string.say_your_point));
        this.cry = new int[]{4, 17, 24, 3, 9, 6, 44, 12, 10, 13, 11, 28, 29, 39};
    }

    public void c(TextWatcher textWatcher) {
        this.csG.addTextChangedListener(textWatcher);
    }

    public void d(TextWatcher textWatcher) {
        this.csG.removeTextChangedListener(textWatcher);
    }

    public void setHint(String str) {
        if (this.cqE != null && !StringUtils.isNull(str)) {
            ((PbNewInputContainer) this.cqE).setHint(str);
        }
    }

    public void setDefaultHint(String str) {
        if (this.cqE != null && !StringUtils.isNull(str)) {
            ((PbNewInputContainer) this.cqE).setDefaultHint(str);
        }
    }

    public EditText getInputView() {
        return this.csG;
    }

    public void setType(int i) {
        if (this.cqE != null) {
            ((PbNewInputContainer) this.cqE).setType(i);
        }
    }

    public void kr(int i) {
        if (this.cqE != null) {
            ((PbNewInputContainer) this.cqE).kr(i);
        }
    }
}
