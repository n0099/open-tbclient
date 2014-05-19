package com.baidu.tbadk.coreExtra.view;

import android.view.View;
import android.widget.EditText;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class s implements View.OnClickListener {
    final /* synthetic */ q a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(q qVar) {
        this.a = qVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EditText editText;
        BaseActivity baseActivity;
        x xVar;
        w wVar;
        w wVar2;
        w wVar3;
        editText = this.a.c;
        String editable = editText.getText().toString();
        if (editable != null && editable.length() > 0) {
            xVar = this.a.l;
            if (xVar == null) {
                wVar = this.a.m;
                if (wVar == null) {
                    this.a.m = new w(this.a, String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.DETECT_USERNAME_ADDRESS, editable);
                    wVar2 = this.a.m;
                    wVar2.setPriority(3);
                    wVar3 = this.a.m;
                    wVar3.execute(new String[0]);
                    return;
                }
                return;
            }
            return;
        }
        q qVar = this.a;
        baseActivity = this.a.j;
        qVar.b(baseActivity.getString(com.baidu.tieba.u.input_name));
    }
}
