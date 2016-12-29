package com.baidu.tbadk.editortools.e;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
class m implements TextWatcher {
    final /* synthetic */ e awr;
    private final /* synthetic */ int aws;
    private final /* synthetic */ EditText awt;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(e eVar, int i, EditText editText) {
        this.awr = eVar;
        this.aws = i;
        this.awt = editText;
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
            if (!StringUtils.isNull(editable2) && com.baidu.tbadk.util.u.gy(editable2) > this.aws) {
                String d = com.baidu.tbadk.util.u.d(editable2, 0, this.aws - 1);
                this.awt.setText(d);
                this.awt.setSelection(this.awt.getText().length());
                UtilHelper.showToast(this.awr.getContext().getApplication(), this.awr.getContext().getResources().getString(r.j.edit_text_over_limit_tip, Integer.valueOf(d.length())));
            }
        }
    }
}
