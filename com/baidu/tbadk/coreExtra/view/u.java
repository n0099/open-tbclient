package com.baidu.tbadk.coreExtra.view;

import android.view.View;
import android.widget.EditText;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class u implements View.OnClickListener {
    final /* synthetic */ r Oy;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(r rVar) {
        this.Oy = rVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EditText editText;
        BaseActivity baseActivity;
        x xVar;
        y yVar;
        y yVar2;
        y yVar3;
        x xVar2;
        editText = this.Oy.Og;
        String editable = editText.getText().toString();
        if (editable != null && editable.length() > 0) {
            xVar = this.Oy.Oq;
            if (xVar != null) {
                xVar2 = this.Oy.Oq;
                xVar2.cancel();
            }
            yVar = this.Oy.Op;
            if (yVar == null) {
                this.Oy.Op = new y(this.Oy, String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.INPUT_USERNAME_ADDRESS, editable);
                yVar2 = this.Oy.Op;
                yVar2.setPriority(3);
                yVar3 = this.Oy.Op;
                yVar3.execute(new String[0]);
                return;
            }
            return;
        }
        r rVar = this.Oy;
        baseActivity = this.Oy.On;
        rVar.cM(baseActivity.getString(com.baidu.tieba.y.input_name));
    }
}
