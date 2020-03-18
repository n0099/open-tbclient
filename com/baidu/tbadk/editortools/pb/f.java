package com.baidu.tbadk.editortools.pb;

import android.content.Context;
import android.text.TextWatcher;
import android.widget.EditText;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.editortools.l;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class f extends l {
    private EditText dzd;

    public f(Context context) {
        super(context, (String) null, 27);
        this.dxS = false;
        this.dxR = 3;
        this.dxa = new PbNewInputContainer(context);
        this.dzd = ((PbNewInputContainer) this.dxa).getInputView();
        ((PbNewInputContainer) this.dxa).setHint(context.getString(R.string.say_your_point));
        this.dxT = new int[]{4, 17, 24, 3, 9, 6, 44, 12, 10, 13, 11, 28, 29, 39};
    }

    public void c(TextWatcher textWatcher) {
        this.dzd.addTextChangedListener(textWatcher);
    }

    public void d(TextWatcher textWatcher) {
        this.dzd.removeTextChangedListener(textWatcher);
    }

    public void setHint(String str) {
        if (this.dxa != null && !StringUtils.isNull(str)) {
            ((PbNewInputContainer) this.dxa).setHint(str);
        }
    }

    public void setDefaultHint(String str) {
        if (this.dxa != null && !StringUtils.isNull(str)) {
            ((PbNewInputContainer) this.dxa).setDefaultHint(str);
        }
    }

    public EditText getInputView() {
        return this.dzd;
    }

    public void setType(int i) {
        if (this.dxa != null) {
            ((PbNewInputContainer) this.dxa).setType(i);
        }
    }

    public void mz(int i) {
        if (this.dxa != null) {
            ((PbNewInputContainer) this.dxa).mz(i);
        }
    }
}
