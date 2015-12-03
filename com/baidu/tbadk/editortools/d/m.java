package com.baidu.tbadk.editortools.d;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.n;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class m implements TextWatcher {
    final /* synthetic */ e asR;
    private final /* synthetic */ int asS;
    private final /* synthetic */ EditText asT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(e eVar, int i, EditText editText) {
        this.asR = eVar;
        this.asS = i;
        this.asT = editText;
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
        if (!StringUtils.isNull(editable2) && com.baidu.tbadk.util.o.ge(editable2) > this.asS) {
            this.asT.setText(com.baidu.tbadk.util.o.e(editable2, 0, this.asS - 1));
            this.asT.setSelection(this.asT.getText().length());
            UtilHelper.showToast(this.asR.Cj().getApplication(), this.asR.Cj().getResources().getString(n.i.show_pic_over_limit_tip));
        }
    }
}
