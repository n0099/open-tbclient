package com.baidu.tbadk.editortools.pb;

import android.content.Context;
import android.text.TextWatcher;
import android.widget.EditText;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.editortools.l;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class f extends l {
    private EditText evO;

    public f(Context context, boolean z) {
        super(context, (String) null, 27);
        this.euA = false;
        this.euz = 3;
        this.etH = new PbNewInputContainer(context);
        ((PbNewInputContainer) this.etH).setTransLink(z ? false : true);
        this.evO = ((PbNewInputContainer) this.etH).getInputView();
        ((PbNewInputContainer) this.etH).setHint(context.getString(R.string.say_your_point));
        this.euB = new int[]{4, 17, 24, 3, 9, 6, 44, 12, 10, 13, 11, 28, 29, 39};
    }

    public void b(TextWatcher textWatcher) {
        this.evO.addTextChangedListener(textWatcher);
    }

    public void c(TextWatcher textWatcher) {
        this.evO.removeTextChangedListener(textWatcher);
    }

    public void setHint(String str) {
        if (this.etH != null && !StringUtils.isNull(str)) {
            ((PbNewInputContainer) this.etH).setHint(str);
        }
    }

    public void setDefaultHint(String str) {
        if (this.etH != null && !StringUtils.isNull(str)) {
            ((PbNewInputContainer) this.etH).setDefaultHint(str);
        }
    }

    public EditText getInputView() {
        return this.evO;
    }

    public void setType(int i) {
        if (this.etH != null) {
            ((PbNewInputContainer) this.etH).setType(i);
        }
    }

    public void nJ(int i) {
        if (this.etH != null) {
            ((PbNewInputContainer) this.etH).nJ(i);
        }
    }
}
