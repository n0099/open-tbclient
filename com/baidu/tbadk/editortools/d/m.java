package com.baidu.tbadk.editortools.d;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.t;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class m implements TextWatcher {
    final /* synthetic */ e avN;
    private final /* synthetic */ int avO;
    private final /* synthetic */ EditText avP;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(e eVar, int i, EditText editText) {
        this.avN = eVar;
        this.avO = i;
        this.avP = editText;
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
        String editable2 = editable.toString();
        if (!StringUtils.isNull(editable2) && com.baidu.tbadk.util.r.go(editable2) > this.avO) {
            this.avP.setText(com.baidu.tbadk.util.r.d(editable2, 0, this.avO - 1));
            this.avP.setSelection(this.avP.getText().length());
            UtilHelper.showToast(this.avN.DY().getApplication(), this.avN.DY().getResources().getString(t.j.show_pic_over_limit_tip));
        }
    }
}
