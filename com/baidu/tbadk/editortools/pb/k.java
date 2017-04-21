package com.baidu.tbadk.editortools.pb;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.util.u;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
class k implements TextWatcher {
    final /* synthetic */ c aBi;
    private final /* synthetic */ int aBj;
    private final /* synthetic */ EditText aBk;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(c cVar, int i, EditText editText) {
        this.aBi = cVar;
        this.aBj = i;
        this.aBk = editText;
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
            if (!StringUtils.isNull(editable2) && u.gq(editable2) > this.aBj) {
                String d = u.d(editable2, 0, this.aBj - 1);
                this.aBk.setText(d);
                this.aBk.setSelection(this.aBk.getText().length());
                UtilHelper.showToast(this.aBi.getContext().getApplication(), this.aBi.getContext().getResources().getString(w.l.edit_text_over_limit_tip, Integer.valueOf(d.length())));
            }
        }
    }
}
