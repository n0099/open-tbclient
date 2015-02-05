package com.baidu.tbadk.coreExtra.view;

import android.view.View;
import android.widget.EditText;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class v implements View.OnClickListener {
    final /* synthetic */ t US;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(t tVar) {
        this.US = tVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EditText editText;
        BaseActivity baseActivity;
        aa aaVar;
        z zVar;
        z zVar2;
        z zVar3;
        editText = this.US.Uz;
        String editable = editText.getText().toString();
        if (editable != null && editable.length() > 0) {
            aaVar = this.US.UI;
            if (aaVar == null) {
                zVar = this.US.UJ;
                if (zVar == null) {
                    this.US.UJ = new z(this.US, String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.DETECT_USERNAME_ADDRESS, editable);
                    zVar2 = this.US.UJ;
                    zVar2.setPriority(3);
                    zVar3 = this.US.UJ;
                    zVar3.execute(new String[0]);
                    return;
                }
                return;
            }
            return;
        }
        t tVar = this.US;
        baseActivity = this.US.UG;
        tVar.dE(baseActivity.getPageContext().getString(com.baidu.tieba.z.input_name));
    }
}
