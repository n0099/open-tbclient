package com.baidu.tbadk.editortools.e;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.util.v;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
class m implements TextWatcher {
    final /* synthetic */ e awb;
    private final /* synthetic */ int awc;
    private final /* synthetic */ EditText awd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(e eVar, int i, EditText editText) {
        this.awb = eVar;
        this.awc = i;
        this.awd = editText;
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
            if (!StringUtils.isNull(editable2) && v.gD(editable2) > this.awc) {
                String d = v.d(editable2, 0, this.awc - 1);
                this.awd.setText(d);
                this.awd.setSelection(this.awd.getText().length());
                UtilHelper.showToast(this.awb.getContext().getApplication(), this.awb.getContext().getResources().getString(r.j.edit_text_over_limit_tip, Integer.valueOf(d.length())));
            }
        }
    }
}
