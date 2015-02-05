package com.baidu.tbadk.coreExtra.view;

import android.view.View;
import android.widget.EditText;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class w implements View.OnClickListener {
    final /* synthetic */ t US;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(t tVar) {
        this.US = tVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EditText editText;
        BaseActivity baseActivity;
        z zVar;
        aa aaVar;
        aa aaVar2;
        aa aaVar3;
        z zVar2;
        editText = this.US.Uz;
        String editable = editText.getText().toString();
        if (editable != null && editable.length() > 0) {
            zVar = this.US.UJ;
            if (zVar != null) {
                zVar2 = this.US.UJ;
                zVar2.cancel();
            }
            aaVar = this.US.UI;
            if (aaVar == null) {
                this.US.UI = new aa(this.US, String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.INPUT_USERNAME_ADDRESS, editable);
                aaVar2 = this.US.UI;
                aaVar2.setPriority(3);
                aaVar3 = this.US.UI;
                aaVar3.execute(new String[0]);
                return;
            }
            return;
        }
        t tVar = this.US;
        baseActivity = this.US.UG;
        tVar.dE(baseActivity.getPageContext().getString(com.baidu.tieba.z.input_name));
    }
}
