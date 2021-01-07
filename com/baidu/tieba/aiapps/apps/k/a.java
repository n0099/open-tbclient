package com.baidu.tieba.aiapps.apps.k;

import android.content.Context;
import android.content.DialogInterface;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.swan.apps.t.b.g;
import com.baidu.swan.apps.view.SwanAppErrorDialog;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tieba.R;
/* loaded from: classes9.dex */
public class a implements g {
    @Override // com.baidu.swan.apps.t.b.g
    public boolean a(Context context, String str, com.baidu.swan.apps.al.a aVar) {
        aq aqVar = new aq("c13607");
        aqVar.dX("uid", com.baidu.tieba.aiapps.apps.a.a.bQk().getUid() == null ? "" : com.baidu.tieba.aiapps.apps.a.a.bQk().getUid());
        aqVar.w("obj_param1", aVar.aQC());
        aqVar.dX(TiebaInitialize.Params.OBJ_PARAM2, aVar.aQD());
        TiebaStatic.log(aqVar);
        if (aVar.aQB() == 10 && aVar.aQC() == 1013) {
            bRa();
            return true;
        }
        return false;
    }

    private void bRa() {
        SwanAppErrorDialog.aSy().kr(R.string.swan_app_update_title).ks(R.string.swan_app_update_msg).a(R.string.swan_app_update_btn, (DialogInterface.OnClickListener) null).show();
    }
}
