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
        aqVar.dR("uid", com.baidu.tieba.aiapps.apps.a.a.bKO().getUid() == null ? "" : com.baidu.tieba.aiapps.apps.a.a.bKO().getUid());
        aqVar.w("obj_param1", aVar.aLL());
        aqVar.dR(TiebaInitialize.Params.OBJ_PARAM2, aVar.aLM());
        TiebaStatic.log(aqVar);
        if (aVar.aLK() == 10 && aVar.aLL() == 1013) {
            bLF();
            return true;
        }
        return false;
    }

    private void bLF() {
        SwanAppErrorDialog.aNE().jU(R.string.swan_app_update_title).jV(R.string.swan_app_update_msg).a(R.string.swan_app_update_btn, (DialogInterface.OnClickListener) null).show();
    }
}
