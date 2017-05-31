package com.baidu.tbadk.editortools.pb;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.util.x;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
class k implements TextWatcher {
    final /* synthetic */ c aAT;
    private final /* synthetic */ int aAU;
    private final /* synthetic */ EditText aAV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(c cVar, int i, EditText editText) {
        this.aAT = cVar;
        this.aAU = i;
        this.aAV = editText;
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
            if (!StringUtils.isNull(editable2) && x.gn(editable2) > this.aAU) {
                String d = x.d(editable2, 0, this.aAU - 1);
                this.aAV.setText(d);
                this.aAV.setSelection(this.aAV.getText().length());
                UtilHelper.showToast(this.aAT.getContext().getApplication(), this.aAT.getContext().getResources().getString(w.l.edit_text_over_limit_tip, Integer.valueOf(d.length())));
            }
        }
    }
}
