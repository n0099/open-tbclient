package com.baidu.tbadk.editortools.pb;

import android.content.Context;
import android.text.TextWatcher;
import android.widget.EditText;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.editortools.k;
import com.baidu.tieba.e;
/* loaded from: classes.dex */
public class e extends k {
    private EditText aRu;

    public e(Context context) {
        super(context, (String) null, 27);
        this.aQl = false;
        this.aQk = 3;
        this.aPu = new PbNewInputContainer(context);
        this.aRu = ((PbNewInputContainer) this.aPu).getInputView();
        ((PbNewInputContainer) this.aPu).setHint(context.getString(e.j.say_your_point));
        this.aQm = new int[]{4, 17, 24, 3, 9, 6, 44, 12, 10, 13, 11, 28, 29, 39};
    }

    public void b(TextWatcher textWatcher) {
        this.aRu.addTextChangedListener(textWatcher);
    }

    public void c(TextWatcher textWatcher) {
        this.aRu.removeTextChangedListener(textWatcher);
    }

    public void setHint(String str) {
        if (this.aPu != null && !StringUtils.isNull(str)) {
            ((PbNewInputContainer) this.aPu).setHint(str);
        }
    }

    public EditText getInputView() {
        return this.aRu;
    }

    public void setType(int i) {
        if (this.aPu != null) {
            ((PbNewInputContainer) this.aPu).setType(i);
        }
    }

    public void fh(int i) {
        if (this.aPu != null) {
            ((PbNewInputContainer) this.aPu).fh(i);
        }
    }
}
