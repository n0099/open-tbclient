package com.baidu.tbadk.coreExtra.view;

import android.view.View;
import android.widget.EditText;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class u implements View.OnClickListener {
    final /* synthetic */ s a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(s sVar) {
        this.a = sVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EditText editText;
        BaseActivity baseActivity;
        z zVar;
        y yVar;
        y yVar2;
        y yVar3;
        editText = this.a.c;
        String editable = editText.getText().toString();
        if (editable != null && editable.length() > 0) {
            zVar = this.a.l;
            if (zVar == null) {
                yVar = this.a.m;
                if (yVar == null) {
                    this.a.m = new y(this.a, String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.DETECT_USERNAME_ADDRESS, editable);
                    yVar2 = this.a.m;
                    yVar2.setPriority(3);
                    yVar3 = this.a.m;
                    yVar3.execute(new String[0]);
                    return;
                }
                return;
            }
            return;
        }
        s sVar = this.a;
        baseActivity = this.a.j;
        sVar.b(baseActivity.getString(com.baidu.tieba.x.input_name));
    }
}
