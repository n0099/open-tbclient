package com.baidu.tieba.aiapps.apps.k;

import android.content.Context;
import android.content.DialogInterface;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.swan.apps.t.b.g;
import com.baidu.swan.apps.view.SwanAppErrorDialog;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tieba.R;
/* loaded from: classes24.dex */
public class a implements g {
    @Override // com.baidu.swan.apps.t.b.g
    public boolean a(Context context, String str, com.baidu.swan.apps.am.a aVar) {
        aq aqVar = new aq("c13607");
        aqVar.dF("uid", com.baidu.tieba.aiapps.apps.a.a.bDK().getUid() == null ? "" : com.baidu.tieba.aiapps.apps.a.a.bDK().getUid());
        aqVar.u("obj_param1", aVar.aEI());
        aqVar.dF(TiebaInitialize.Params.OBJ_PARAM2, aVar.aEJ());
        TiebaStatic.log(aqVar);
        if (aVar.aEH() == 10 && aVar.aEI() == 1013) {
            bEB();
            return true;
        }
        return false;
    }

    private void bEB() {
        SwanAppErrorDialog.aGB().jc(R.string.swan_app_update_title).jd(R.string.swan_app_update_msg).a(R.string.swan_app_update_btn, (DialogInterface.OnClickListener) null).show();
    }
}
