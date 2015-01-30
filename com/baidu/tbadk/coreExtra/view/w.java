package com.baidu.tbadk.coreExtra.view;

import android.view.View;
import android.widget.EditText;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class w implements View.OnClickListener {
    final /* synthetic */ t UV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(t tVar) {
        this.UV = tVar;
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
        editText = this.UV.UD;
        String editable = editText.getText().toString();
        if (editable != null && editable.length() > 0) {
            zVar = this.UV.UM;
            if (zVar != null) {
                zVar2 = this.UV.UM;
                zVar2.cancel();
            }
            aaVar = this.UV.UL;
            if (aaVar == null) {
                this.UV.UL = new aa(this.UV, String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.INPUT_USERNAME_ADDRESS, editable);
                aaVar2 = this.UV.UL;
                aaVar2.setPriority(3);
                aaVar3 = this.UV.UL;
                aaVar3.execute(new String[0]);
                return;
            }
            return;
        }
        t tVar = this.UV;
        baseActivity = this.UV.UJ;
        tVar.dH(baseActivity.getPageContext().getString(com.baidu.tieba.z.input_name));
    }
}
