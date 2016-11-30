package com.baidu.tbadk.editortools.e;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
class m implements TextWatcher {
    final /* synthetic */ e awU;
    private final /* synthetic */ int awV;
    private final /* synthetic */ EditText awW;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(e eVar, int i, EditText editText) {
        this.awU = eVar;
        this.awV = i;
        this.awW = editText;
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
            if (!StringUtils.isNull(editable2) && com.baidu.tbadk.util.u.gD(editable2) > this.awV) {
                String d = com.baidu.tbadk.util.u.d(editable2, 0, this.awV - 1);
                this.awW.setText(d);
                this.awW.setSelection(this.awW.getText().length());
                UtilHelper.showToast(this.awU.getContext().getApplication(), this.awU.getContext().getResources().getString(r.j.edit_text_over_limit_tip, Integer.valueOf(d.length())));
            }
        }
    }
}
