package com.baidu.tbadk.coreExtra.view;

import android.view.View;
import android.widget.EditText;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class v implements View.OnClickListener {
    final /* synthetic */ t Uo;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(t tVar) {
        this.Uo = tVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EditText editText;
        BaseActivity baseActivity;
        aa aaVar;
        z zVar;
        z zVar2;
        z zVar3;
        editText = this.Uo.TX;
        String editable = editText.getText().toString();
        if (editable != null && editable.length() > 0) {
            aaVar = this.Uo.Uf;
            if (aaVar == null) {
                zVar = this.Uo.Ug;
                if (zVar == null) {
                    this.Uo.Ug = new z(this.Uo, String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.DETECT_USERNAME_ADDRESS, editable);
                    zVar2 = this.Uo.Ug;
                    zVar2.setPriority(3);
                    zVar3 = this.Uo.Ug;
                    zVar3.execute(new String[0]);
                    return;
                }
                return;
            }
            return;
        }
        t tVar = this.Uo;
        baseActivity = this.Uo.Ud;
        tVar.dI(baseActivity.getPageContext().getString(com.baidu.tieba.z.input_name));
    }
}
