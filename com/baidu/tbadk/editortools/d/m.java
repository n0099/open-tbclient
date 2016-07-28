package com.baidu.tbadk.editortools.d;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.util.v;
import com.baidu.tieba.u;
/* loaded from: classes.dex */
class m implements TextWatcher {
    final /* synthetic */ e atr;
    private final /* synthetic */ int ats;
    private final /* synthetic */ EditText att;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(e eVar, int i, EditText editText) {
        this.atr = eVar;
        this.ats = i;
        this.att = editText;
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
        if (!StringUtils.isNull(editable2) && v.gw(editable2) > this.ats) {
            this.att.setText(v.d(editable2, 0, this.ats - 1));
            this.att.setSelection(this.att.getText().length());
            UtilHelper.showToast(this.atr.getContext().getApplication(), this.atr.getContext().getResources().getString(u.j.show_pic_over_limit_tip));
        }
    }
}
