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
    final /* synthetic */ c aBg;
    private final /* synthetic */ int aBh;
    private final /* synthetic */ EditText aBi;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(c cVar, int i, EditText editText) {
        this.aBg = cVar;
        this.aBh = i;
        this.aBi = editText;
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
            if (!StringUtils.isNull(editable2) && u.gq(editable2) > this.aBh) {
                String d = u.d(editable2, 0, this.aBh - 1);
                this.aBi.setText(d);
                this.aBi.setSelection(this.aBi.getText().length());
                UtilHelper.showToast(this.aBg.getContext().getApplication(), this.aBg.getContext().getResources().getString(w.l.edit_text_over_limit_tip, Integer.valueOf(d.length())));
            }
        }
    }
}
