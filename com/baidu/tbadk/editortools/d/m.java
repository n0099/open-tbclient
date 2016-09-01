package com.baidu.tbadk.editortools.d;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.util.v;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
class m implements TextWatcher {
    private final /* synthetic */ EditText awA;
    final /* synthetic */ e awy;
    private final /* synthetic */ int awz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(e eVar, int i, EditText editText) {
        this.awy = eVar;
        this.awz = i;
        this.awA = editText;
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
            if (!StringUtils.isNull(editable2) && v.gz(editable2) > this.awz) {
                String d = v.d(editable2, 0, this.awz - 1);
                this.awA.setText(d);
                this.awA.setSelection(this.awA.getText().length());
                UtilHelper.showToast(this.awy.getContext().getApplication(), this.awy.getContext().getResources().getString(t.j.edit_text_over_limit_tip, Integer.valueOf(d.length())));
            }
        }
    }
}
