package com.baidu.tbadk.coreExtra.view;

import android.view.View;
import android.widget.EditText;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class u implements View.OnClickListener {
    final /* synthetic */ r OC;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(r rVar) {
        this.OC = rVar;
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
        editText = this.OC.Ok;
        String editable = editText.getText().toString();
        if (editable != null && editable.length() > 0) {
            xVar = this.OC.Ou;
            if (xVar != null) {
                xVar2 = this.OC.Ou;
                xVar2.cancel();
            }
            yVar = this.OC.Ot;
            if (yVar == null) {
                this.OC.Ot = new y(this.OC, String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.INPUT_USERNAME_ADDRESS, editable);
                yVar2 = this.OC.Ot;
                yVar2.setPriority(3);
                yVar3 = this.OC.Ot;
                yVar3.execute(new String[0]);
                return;
            }
            return;
        }
        r rVar = this.OC;
        baseActivity = this.OC.Or;
        rVar.cM(baseActivity.getString(com.baidu.tieba.y.input_name));
    }
}
