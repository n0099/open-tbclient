package com.baidu.tbadk.editortools.pb;

import android.content.Context;
import android.text.TextWatcher;
import android.widget.EditText;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.editortools.m;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class f extends m {
    private EditText ePB;

    public f(Context context, boolean z, boolean z2) {
        super(context, (String) null, 27);
        this.eNN = false;
        this.eNM = 3;
        this.eMS = new PbNewInputContainer(context);
        ((PbNewInputContainer) this.eMS).setTransLink(z ? false : true);
        this.ePB = ((PbNewInputContainer) this.eMS).getInputView();
        ((PbNewInputContainer) this.eMS).setHint(context.getString(R.string.say_your_point));
        ((PbNewInputContainer) this.eMS).jt(z2);
        this.eNO = new int[]{4, 17, 24, 3, 9, 6, 44, 12, 10, 13, 11, 28, 29, 39, 45};
    }

    public void b(TextWatcher textWatcher) {
        this.ePB.addTextChangedListener(textWatcher);
    }

    public void c(TextWatcher textWatcher) {
        this.ePB.removeTextChangedListener(textWatcher);
    }

    public void setHint(String str) {
        if (this.eMS != null && !StringUtils.isNull(str)) {
            ((PbNewInputContainer) this.eMS).setHint(str);
        }
    }

    public void setDefaultHint(String str) {
        if (this.eMS != null && !StringUtils.isNull(str)) {
            ((PbNewInputContainer) this.eMS).setDefaultHint(str);
        }
    }

    public EditText getInputView() {
        return this.ePB;
    }

    public void setType(int i) {
        if (this.eMS != null) {
            ((PbNewInputContainer) this.eMS).setType(i);
        }
    }

    public void qD(int i) {
        if (this.eMS != null) {
            ((PbNewInputContainer) this.eMS).qD(i);
        }
    }
}
