package com.baidu.tbadk.editortools.pb;

import android.content.Context;
import android.text.TextWatcher;
import android.widget.EditText;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.editortools.k;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class e extends k {
    private EditText aEO;

    public e(Context context) {
        super(context, (String) null, 27);
        this.aDE = false;
        this.aDD = 3;
        this.aCN = new PbNewInputContainer(context);
        this.aEO = ((PbNewInputContainer) this.aCN).getInputView();
        ((PbNewInputContainer) this.aCN).setHint(context.getString(d.k.say_your_point));
        this.aDF = new int[]{4, 17, 24, 3, 9, 6, 44, 12, 10, 13, 11, 28, 29, 39};
    }

    public void b(TextWatcher textWatcher) {
        this.aEO.addTextChangedListener(textWatcher);
    }

    public void c(TextWatcher textWatcher) {
        this.aEO.removeTextChangedListener(textWatcher);
    }

    public void setHint(String str) {
        if (this.aCN != null && !StringUtils.isNull(str)) {
            ((PbNewInputContainer) this.aCN).setHint(str);
        }
    }

    public EditText getInputView() {
        return this.aEO;
    }

    public void setType(int i) {
        if (this.aCN != null) {
            ((PbNewInputContainer) this.aCN).setType(i);
        }
    }

    public void eQ(int i) {
        if (this.aCN != null) {
            ((PbNewInputContainer) this.aCN).eQ(i);
        }
    }
}
