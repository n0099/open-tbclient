package com.baidu.tbadk.editortools.c;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.i;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class m implements TextWatcher {
    final /* synthetic */ e aqO;
    private final /* synthetic */ int aqP;
    private final /* synthetic */ EditText aqQ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(e eVar, int i, EditText editText) {
        this.aqO = eVar;
        this.aqP = i;
        this.aqQ = editText;
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
        if (!StringUtils.isNull(editable2) && com.baidu.tbadk.util.n.fQ(editable2) > this.aqP) {
            this.aqQ.setText(com.baidu.tbadk.util.n.e(editable2, 0, this.aqP - 1));
            this.aqQ.setSelection(this.aqQ.getText().length());
            UtilHelper.showToast(this.aqO.Bj().getApplication(), this.aqO.Bj().getResources().getString(i.h.show_pic_over_limit_tip));
        }
    }
}
