package com.baidu.tbadk.coreExtra.view;

import android.view.View;
import android.widget.EditText;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class t implements View.OnClickListener {
    final /* synthetic */ q a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(q qVar) {
        this.a = qVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EditText editText;
        BaseActivity baseActivity;
        w wVar;
        x xVar;
        x xVar2;
        x xVar3;
        w wVar2;
        editText = this.a.c;
        String editable = editText.getText().toString();
        if (editable != null && editable.length() > 0) {
            wVar = this.a.m;
            if (wVar != null) {
                wVar2 = this.a.m;
                wVar2.cancel();
            }
            xVar = this.a.l;
            if (xVar == null) {
                this.a.l = new x(this.a, String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.INPUT_USERNAME_ADDRESS, editable);
                xVar2 = this.a.l;
                xVar2.setPriority(3);
                xVar3 = this.a.l;
                xVar3.execute(new String[0]);
                return;
            }
            return;
        }
        q qVar = this.a;
        baseActivity = this.a.j;
        qVar.b(baseActivity.getString(com.baidu.tieba.u.input_name));
    }
}
