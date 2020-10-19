package com.baidu.tbadk.editortools.pb;

import android.content.Context;
import android.text.TextWatcher;
import android.widget.EditText;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.editortools.m;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class f extends m {
    private EditText fbI;

    public f(Context context, boolean z, boolean z2) {
        super(context, (String) null, 27);
        this.eZU = false;
        this.eZT = 3;
        this.eYZ = new PbNewInputContainer(context);
        ((PbNewInputContainer) this.eYZ).setTransLink(z ? false : true);
        this.fbI = ((PbNewInputContainer) this.eYZ).getInputView();
        ((PbNewInputContainer) this.eYZ).setHint(context.getString(R.string.say_your_point));
        ((PbNewInputContainer) this.eYZ).jR(z2);
        this.eZV = new int[]{4, 17, 24, 3, 9, 6, 44, 12, 10, 13, 11, 28, 29, 39, 45};
    }

    public void b(TextWatcher textWatcher) {
        this.fbI.addTextChangedListener(textWatcher);
    }

    public void c(TextWatcher textWatcher) {
        this.fbI.removeTextChangedListener(textWatcher);
    }

    public void setHint(String str) {
        if (this.eYZ != null && !StringUtils.isNull(str)) {
            ((PbNewInputContainer) this.eYZ).setHint(str);
        }
    }

    public void setDefaultHint(String str) {
        if (this.eYZ != null && !StringUtils.isNull(str)) {
            ((PbNewInputContainer) this.eYZ).setDefaultHint(str);
        }
    }

    public EditText getInputView() {
        return this.fbI;
    }

    public void setType(int i) {
        if (this.eYZ != null) {
            ((PbNewInputContainer) this.eYZ).setType(i);
        }
    }

    public void rb(int i) {
        if (this.eYZ != null) {
            ((PbNewInputContainer) this.eYZ).rb(i);
        }
    }
}
