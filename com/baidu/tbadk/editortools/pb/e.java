package com.baidu.tbadk.editortools.pb;

import android.content.Context;
import android.text.TextWatcher;
import android.widget.EditText;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.editortools.k;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class e extends k {
    private EditText cub;

    public e(Context context) {
        super(context, (String) null, 27);
        this.csS = false;
        this.csR = 3;
        this.csa = new PbNewInputContainer(context);
        this.cub = ((PbNewInputContainer) this.csa).getInputView();
        ((PbNewInputContainer) this.csa).setHint(context.getString(R.string.say_your_point));
        this.csT = new int[]{4, 17, 24, 3, 9, 6, 44, 12, 10, 13, 11, 28, 29, 39};
    }

    public void c(TextWatcher textWatcher) {
        this.cub.addTextChangedListener(textWatcher);
    }

    public void d(TextWatcher textWatcher) {
        this.cub.removeTextChangedListener(textWatcher);
    }

    public void setHint(String str) {
        if (this.csa != null && !StringUtils.isNull(str)) {
            ((PbNewInputContainer) this.csa).setHint(str);
        }
    }

    public void setDefaultHint(String str) {
        if (this.csa != null && !StringUtils.isNull(str)) {
            ((PbNewInputContainer) this.csa).setDefaultHint(str);
        }
    }

    public EditText getInputView() {
        return this.cub;
    }

    public void setType(int i) {
        if (this.csa != null) {
            ((PbNewInputContainer) this.csa).setType(i);
        }
    }

    public void ky(int i) {
        if (this.csa != null) {
            ((PbNewInputContainer) this.csa).ky(i);
        }
    }
}
