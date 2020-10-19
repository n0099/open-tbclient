package com.baidu.tieba.aiapps.apps.k;

import android.content.Context;
import android.content.DialogInterface;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.swan.apps.t.b.g;
import com.baidu.swan.apps.view.SwanAppErrorDialog;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tieba.R;
/* loaded from: classes25.dex */
public class a implements g {
    @Override // com.baidu.swan.apps.t.b.g
    public boolean a(Context context, String str, com.baidu.swan.apps.am.a aVar) {
        aq aqVar = new aq("c13607");
        aqVar.dK("uid", com.baidu.tieba.aiapps.apps.a.a.bGw().getUid() == null ? "" : com.baidu.tieba.aiapps.apps.a.a.bGw().getUid());
        aqVar.u("obj_param1", aVar.aHr());
        aqVar.dK(TiebaInitialize.Params.OBJ_PARAM2, aVar.aHs());
        TiebaStatic.log(aqVar);
        if (aVar.aHq() == 10 && aVar.aHr() == 1013) {
            bHn();
            return true;
        }
        return false;
    }

    private void bHn() {
        SwanAppErrorDialog.aJk().jz(R.string.swan_app_update_title).jA(R.string.swan_app_update_msg).a(R.string.swan_app_update_btn, (DialogInterface.OnClickListener) null).show();
    }
}
