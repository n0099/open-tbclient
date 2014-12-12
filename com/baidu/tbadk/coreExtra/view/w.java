package com.baidu.tbadk.coreExtra.view;

import android.view.View;
import android.widget.EditText;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class w implements View.OnClickListener {
    final /* synthetic */ t Uo;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(t tVar) {
        this.Uo = tVar;
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
        editText = this.Uo.TX;
        String editable = editText.getText().toString();
        if (editable != null && editable.length() > 0) {
            zVar = this.Uo.Ug;
            if (zVar != null) {
                zVar2 = this.Uo.Ug;
                zVar2.cancel();
            }
            aaVar = this.Uo.Uf;
            if (aaVar == null) {
                this.Uo.Uf = new aa(this.Uo, String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.INPUT_USERNAME_ADDRESS, editable);
                aaVar2 = this.Uo.Uf;
                aaVar2.setPriority(3);
                aaVar3 = this.Uo.Uf;
                aaVar3.execute(new String[0]);
                return;
            }
            return;
        }
        t tVar = this.Uo;
        baseActivity = this.Uo.Ud;
        tVar.dI(baseActivity.getPageContext().getString(com.baidu.tieba.z.input_name));
    }
}
