package com.baidu.tbadk.coreExtra.view;

import android.view.View;
import android.widget.EditText;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class v implements View.OnClickListener {
    final /* synthetic */ t UV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(t tVar) {
        this.UV = tVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EditText editText;
        BaseActivity baseActivity;
        aa aaVar;
        z zVar;
        z zVar2;
        z zVar3;
        editText = this.UV.UD;
        String editable = editText.getText().toString();
        if (editable != null && editable.length() > 0) {
            aaVar = this.UV.UL;
            if (aaVar == null) {
                zVar = this.UV.UM;
                if (zVar == null) {
                    this.UV.UM = new z(this.UV, String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.DETECT_USERNAME_ADDRESS, editable);
                    zVar2 = this.UV.UM;
                    zVar2.setPriority(3);
                    zVar3 = this.UV.UM;
                    zVar3.execute(new String[0]);
                    return;
                }
                return;
            }
            return;
        }
        t tVar = this.UV;
        baseActivity = this.UV.UJ;
        tVar.dH(baseActivity.getPageContext().getString(com.baidu.tieba.z.input_name));
    }
}
