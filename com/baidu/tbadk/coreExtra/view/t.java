package com.baidu.tbadk.coreExtra.view;

import android.view.View;
import android.widget.EditText;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class t implements View.OnClickListener {
    final /* synthetic */ r Oy;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(r rVar) {
        this.Oy = rVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EditText editText;
        BaseActivity baseActivity;
        y yVar;
        x xVar;
        x xVar2;
        x xVar3;
        editText = this.Oy.Og;
        String editable = editText.getText().toString();
        if (editable != null && editable.length() > 0) {
            yVar = this.Oy.Op;
            if (yVar == null) {
                xVar = this.Oy.Oq;
                if (xVar == null) {
                    this.Oy.Oq = new x(this.Oy, String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.DETECT_USERNAME_ADDRESS, editable);
                    xVar2 = this.Oy.Oq;
                    xVar2.setPriority(3);
                    xVar3 = this.Oy.Oq;
                    xVar3.execute(new String[0]);
                    return;
                }
                return;
            }
            return;
        }
        r rVar = this.Oy;
        baseActivity = this.Oy.On;
        rVar.cM(baseActivity.getString(com.baidu.tieba.y.input_name));
    }
}
