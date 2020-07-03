package com.baidu.tieba.aiapps.apps.j;

import android.content.DialogInterface;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.swan.apps.u.b.g;
import com.baidu.swan.apps.view.SwanAppErrorDialog;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tieba.R;
/* loaded from: classes12.dex */
public class a implements g {
    @Override // com.baidu.swan.apps.u.b.g
    public boolean a(String str, com.baidu.swan.apps.an.a aVar) {
        ao aoVar = new ao("c13607");
        aoVar.dk("obj_id", str);
        aoVar.dk("uid", com.baidu.tieba.aiapps.apps.a.a.bqz().getUid() == null ? "" : com.baidu.tieba.aiapps.apps.a.a.bqz().getUid());
        aoVar.s("obj_param1", aVar.atO());
        aoVar.dk(TiebaInitialize.Params.OBJ_PARAM2, aVar.atP());
        TiebaStatic.log(aoVar);
        if (aVar.atN() == 10 && aVar.atO() == 1013) {
            brl();
            return true;
        }
        return false;
    }

    private void brl() {
        SwanAppErrorDialog.avv().gB(R.string.swan_app_update_title).gC(R.string.swan_app_update_msg).a(R.string.swan_app_update_btn, (DialogInterface.OnClickListener) null).show();
    }
}
