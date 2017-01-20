package com.baidu.tbadk.editortools.pb;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.util.u;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
class k implements TextWatcher {
    final /* synthetic */ c avv;
    private final /* synthetic */ int avw;
    private final /* synthetic */ EditText avx;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(c cVar, int i, EditText editText) {
        this.avv = cVar;
        this.avw = i;
        this.avx = editText;
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
        if (editable != null) {
            String editable2 = editable.toString();
            if (!StringUtils.isNull(editable2) && u.gv(editable2) > this.avw) {
                String d = u.d(editable2, 0, this.avw - 1);
                this.avx.setText(d);
                this.avx.setSelection(this.avx.getText().length());
                UtilHelper.showToast(this.avv.getContext().getApplication(), this.avv.getContext().getResources().getString(r.l.edit_text_over_limit_tip, Integer.valueOf(d.length())));
            }
        }
    }
}
