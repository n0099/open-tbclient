package com.baidu.tbadk.editortools.pb;

import android.content.Context;
import android.text.TextWatcher;
import android.widget.EditText;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.editortools.l;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class f extends l {
    private EditText dyQ;

    public f(Context context) {
        super(context, (String) null, 27);
        this.dxF = false;
        this.dxE = 3;
        this.dwN = new PbNewInputContainer(context);
        this.dyQ = ((PbNewInputContainer) this.dwN).getInputView();
        ((PbNewInputContainer) this.dwN).setHint(context.getString(R.string.say_your_point));
        this.dxG = new int[]{4, 17, 24, 3, 9, 6, 44, 12, 10, 13, 11, 28, 29, 39};
    }

    public void c(TextWatcher textWatcher) {
        this.dyQ.addTextChangedListener(textWatcher);
    }

    public void d(TextWatcher textWatcher) {
        this.dyQ.removeTextChangedListener(textWatcher);
    }

    public void setHint(String str) {
        if (this.dwN != null && !StringUtils.isNull(str)) {
            ((PbNewInputContainer) this.dwN).setHint(str);
        }
    }

    public void setDefaultHint(String str) {
        if (this.dwN != null && !StringUtils.isNull(str)) {
            ((PbNewInputContainer) this.dwN).setDefaultHint(str);
        }
    }

    public EditText getInputView() {
        return this.dyQ;
    }

    public void setType(int i) {
        if (this.dwN != null) {
            ((PbNewInputContainer) this.dwN).setType(i);
        }
    }

    public void mx(int i) {
        if (this.dwN != null) {
            ((PbNewInputContainer) this.dwN).mx(i);
        }
    }
}
