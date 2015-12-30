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
    final /* synthetic */ e auv;
    private final /* synthetic */ int auw;
    private final /* synthetic */ EditText aux;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(e eVar, int i, EditText editText) {
        this.auv = eVar;
        this.auw = i;
        this.aux = editText;
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
        if (!StringUtils.isNull(editable2) && com.baidu.tbadk.util.o.gi(editable2) > this.auw) {
            this.aux.setText(com.baidu.tbadk.util.o.e(editable2, 0, this.auw - 1));
            this.aux.setSelection(this.aux.getText().length());
            UtilHelper.showToast(this.auv.BY().getApplication(), this.auv.BY().getResources().getString(n.j.show_pic_over_limit_tip));
        }
    }
}
