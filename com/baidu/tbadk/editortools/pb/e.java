package com.baidu.tbadk.editortools.pb;

import android.content.Context;
import android.text.TextWatcher;
import android.widget.EditText;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.editortools.k;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class e extends k {
    private EditText cuY;

    public e(Context context) {
        super(context, (String) null, 27);
        this.ctO = false;
        this.ctN = 3;
        this.csV = new PbNewInputContainer(context);
        this.cuY = ((PbNewInputContainer) this.csV).getInputView();
        ((PbNewInputContainer) this.csV).setHint(context.getString(R.string.say_your_point));
        this.ctP = new int[]{4, 17, 24, 3, 9, 6, 44, 12, 10, 13, 11, 28, 29, 39};
    }

    public void c(TextWatcher textWatcher) {
        this.cuY.addTextChangedListener(textWatcher);
    }

    public void d(TextWatcher textWatcher) {
        this.cuY.removeTextChangedListener(textWatcher);
    }

    public void setHint(String str) {
        if (this.csV != null && !StringUtils.isNull(str)) {
            ((PbNewInputContainer) this.csV).setHint(str);
        }
    }

    public void setDefaultHint(String str) {
        if (this.csV != null && !StringUtils.isNull(str)) {
            ((PbNewInputContainer) this.csV).setDefaultHint(str);
        }
    }

    public EditText getInputView() {
        return this.cuY;
    }

    public void setType(int i) {
        if (this.csV != null) {
            ((PbNewInputContainer) this.csV).setType(i);
        }
    }

    public void kB(int i) {
        if (this.csV != null) {
            ((PbNewInputContainer) this.csV).kB(i);
        }
    }
}
