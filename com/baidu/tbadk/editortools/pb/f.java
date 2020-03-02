package com.baidu.tbadk.editortools.pb;

import android.content.Context;
import android.text.TextWatcher;
import android.widget.EditText;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.editortools.l;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class f extends l {
    private EditText dyD;

    public f(Context context) {
        super(context, (String) null, 27);
        this.dxs = false;
        this.dxr = 3;
        this.dwA = new PbNewInputContainer(context);
        this.dyD = ((PbNewInputContainer) this.dwA).getInputView();
        ((PbNewInputContainer) this.dwA).setHint(context.getString(R.string.say_your_point));
        this.dxt = new int[]{4, 17, 24, 3, 9, 6, 44, 12, 10, 13, 11, 28, 29, 39};
    }

    public void c(TextWatcher textWatcher) {
        this.dyD.addTextChangedListener(textWatcher);
    }

    public void d(TextWatcher textWatcher) {
        this.dyD.removeTextChangedListener(textWatcher);
    }

    public void setHint(String str) {
        if (this.dwA != null && !StringUtils.isNull(str)) {
            ((PbNewInputContainer) this.dwA).setHint(str);
        }
    }

    public void setDefaultHint(String str) {
        if (this.dwA != null && !StringUtils.isNull(str)) {
            ((PbNewInputContainer) this.dwA).setDefaultHint(str);
        }
    }

    public EditText getInputView() {
        return this.dyD;
    }

    public void setType(int i) {
        if (this.dwA != null) {
            ((PbNewInputContainer) this.dwA).setType(i);
        }
    }

    public void mx(int i) {
        if (this.dwA != null) {
            ((PbNewInputContainer) this.dwA).mx(i);
        }
    }
}
