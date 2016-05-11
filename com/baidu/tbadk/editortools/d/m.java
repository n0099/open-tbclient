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
    final /* synthetic */ e arM;
    private final /* synthetic */ int arN;
    private final /* synthetic */ EditText arO;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(e eVar, int i, EditText editText) {
        this.arM = eVar;
        this.arN = i;
        this.arO = editText;
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
        if (!StringUtils.isNull(editable2) && com.baidu.tbadk.util.u.gp(editable2) > this.arN) {
            this.arO.setText(com.baidu.tbadk.util.u.d(editable2, 0, this.arN - 1));
            this.arO.setSelection(this.arO.getText().length());
            UtilHelper.showToast(this.arM.BR().getApplication(), this.arM.BR().getResources().getString(t.j.show_pic_over_limit_tip));
        }
    }
}
