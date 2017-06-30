package com.baidu.tbadk.editortools.pb;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.util.y;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
class k implements TextWatcher {
    final /* synthetic */ c aBW;
    private final /* synthetic */ int aBX;
    private final /* synthetic */ EditText aBY;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(c cVar, int i, EditText editText) {
        this.aBW = cVar;
        this.aBX = i;
        this.aBY = editText;
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
            if (!StringUtils.isNull(editable2) && y.gI(editable2) > this.aBX) {
                String d = y.d(editable2, 0, this.aBX - 1);
                this.aBY.setText(d);
                this.aBY.setSelection(this.aBY.getText().length());
                UtilHelper.showToast(this.aBW.getContext().getApplication(), this.aBW.getContext().getResources().getString(w.l.edit_text_over_limit_tip, Integer.valueOf(d.length())));
            }
        }
    }
}
