package com.baidu.tbadk.coreExtra.view;

import android.view.View;
import android.widget.EditText;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class t implements View.OnClickListener {
    final /* synthetic */ r OC;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(r rVar) {
        this.OC = rVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EditText editText;
        BaseActivity baseActivity;
        y yVar;
        x xVar;
        x xVar2;
        x xVar3;
        editText = this.OC.Ok;
        String editable = editText.getText().toString();
        if (editable != null && editable.length() > 0) {
            yVar = this.OC.Ot;
            if (yVar == null) {
                xVar = this.OC.Ou;
                if (xVar == null) {
                    this.OC.Ou = new x(this.OC, String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.DETECT_USERNAME_ADDRESS, editable);
                    xVar2 = this.OC.Ou;
                    xVar2.setPriority(3);
                    xVar3 = this.OC.Ou;
                    xVar3.execute(new String[0]);
                    return;
                }
                return;
            }
            return;
        }
        r rVar = this.OC;
        baseActivity = this.OC.Or;
        rVar.cM(baseActivity.getString(com.baidu.tieba.y.input_name));
    }
}
