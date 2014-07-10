package com.baidu.tbadk.coreExtra.view;

import android.view.View;
import android.widget.EditText;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class v implements View.OnClickListener {
    final /* synthetic */ s a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(s sVar) {
        this.a = sVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EditText editText;
        BaseActivity baseActivity;
        y yVar;
        z zVar;
        z zVar2;
        z zVar3;
        y yVar2;
        editText = this.a.c;
        String editable = editText.getText().toString();
        if (editable != null && editable.length() > 0) {
            yVar = this.a.m;
            if (yVar != null) {
                yVar2 = this.a.m;
                yVar2.cancel();
            }
            zVar = this.a.l;
            if (zVar == null) {
                this.a.l = new z(this.a, String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.INPUT_USERNAME_ADDRESS, editable);
                zVar2 = this.a.l;
                zVar2.setPriority(3);
                zVar3 = this.a.l;
                zVar3.execute(new String[0]);
                return;
            }
            return;
        }
        s sVar = this.a;
        baseActivity = this.a.j;
        sVar.b(baseActivity.getString(com.baidu.tieba.y.input_name));
    }
}
