package com.baidu.tbadk.editortools.d;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.u;
/* loaded from: classes.dex */
class m implements TextWatcher {
    final /* synthetic */ e asC;
    private final /* synthetic */ int asD;
    private final /* synthetic */ EditText asE;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(e eVar, int i, EditText editText) {
        this.asC = eVar;
        this.asD = i;
        this.asE = editText;
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
        if (!StringUtils.isNull(editable2) && com.baidu.tbadk.util.u.gx(editable2) > this.asD) {
            this.asE.setText(com.baidu.tbadk.util.u.d(editable2, 0, this.asD - 1));
            this.asE.setSelection(this.asE.getText().length());
            UtilHelper.showToast(this.asC.getContext().getApplication(), this.asC.getContext().getResources().getString(u.j.show_pic_over_limit_tip));
        }
    }
}
