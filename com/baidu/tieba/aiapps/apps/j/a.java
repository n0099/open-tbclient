package com.baidu.tieba.aiapps.apps.j;

import android.content.Context;
import android.content.DialogInterface;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.swan.apps.t.b.g;
import com.baidu.swan.apps.view.SwanAppErrorDialog;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tieba.R;
/* loaded from: classes19.dex */
public class a implements g {
    @Override // com.baidu.swan.apps.t.b.g
    public boolean a(Context context, String str, com.baidu.swan.apps.am.a aVar) {
        aq aqVar = new aq("c13607");
        aqVar.dD("uid", com.baidu.tieba.aiapps.apps.a.a.bCy().getUid() == null ? "" : com.baidu.tieba.aiapps.apps.a.a.bCy().getUid());
        aqVar.u("obj_param1", aVar.aDY());
        aqVar.dD(TiebaInitialize.Params.OBJ_PARAM2, aVar.aDZ());
        TiebaStatic.log(aqVar);
        if (aVar.aDX() == 10 && aVar.aDY() == 1013) {
            bDo();
            return true;
        }
        return false;
    }

    private void bDo() {
        SwanAppErrorDialog.aFR().iR(R.string.swan_app_update_title).iS(R.string.swan_app_update_msg).a(R.string.swan_app_update_btn, (DialogInterface.OnClickListener) null).show();
    }
}
