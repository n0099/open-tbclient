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
    final /* synthetic */ e avn;
    private final /* synthetic */ int avo;
    private final /* synthetic */ EditText avp;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(e eVar, int i, EditText editText) {
        this.avn = eVar;
        this.avo = i;
        this.avp = editText;
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
        if (!StringUtils.isNull(editable2) && com.baidu.tbadk.util.o.gf(editable2) > this.avo) {
            this.avp.setText(com.baidu.tbadk.util.o.d(editable2, 0, this.avo - 1));
            this.avp.setSelection(this.avp.getText().length());
            UtilHelper.showToast(this.avn.Do().getApplication(), this.avn.Do().getResources().getString(t.j.show_pic_over_limit_tip));
        }
    }
}
