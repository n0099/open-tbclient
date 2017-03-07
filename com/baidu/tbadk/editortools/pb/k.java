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
    final /* synthetic */ c aAQ;
    private final /* synthetic */ int aAR;
    private final /* synthetic */ EditText aAS;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(c cVar, int i, EditText editText) {
        this.aAQ = cVar;
        this.aAR = i;
        this.aAS = editText;
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
            if (!StringUtils.isNull(editable2) && u.gk(editable2) > this.aAR) {
                String d = u.d(editable2, 0, this.aAR - 1);
                this.aAS.setText(d);
                this.aAS.setSelection(this.aAS.getText().length());
                UtilHelper.showToast(this.aAQ.getContext().getApplication(), this.aAQ.getContext().getResources().getString(w.l.edit_text_over_limit_tip, Integer.valueOf(d.length())));
            }
        }
    }
}
