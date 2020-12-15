package com.baidu.tieba.aiapps.apps.k;

import android.content.Context;
import android.content.DialogInterface;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.swan.apps.t.b.g;
import com.baidu.swan.apps.view.SwanAppErrorDialog;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tieba.R;
/* loaded from: classes25.dex */
public class a implements g {
    @Override // com.baidu.swan.apps.t.b.g
    public boolean a(Context context, String str, com.baidu.swan.apps.am.a aVar) {
        ar arVar = new ar("c13607");
        arVar.dY("uid", com.baidu.tieba.aiapps.apps.a.a.bNQ().getUid() == null ? "" : com.baidu.tieba.aiapps.apps.a.a.bNQ().getUid());
        arVar.w("obj_param1", aVar.aOk());
        arVar.dY(TiebaInitialize.Params.OBJ_PARAM2, aVar.aOl());
        TiebaStatic.log(arVar);
        if (aVar.aOj() == 10 && aVar.aOk() == 1013) {
            bOH();
            return true;
        }
        return false;
    }

    private void bOH() {
        SwanAppErrorDialog.aQc().ko(R.string.swan_app_update_title).kp(R.string.swan_app_update_msg).a(R.string.swan_app_update_btn, (DialogInterface.OnClickListener) null).show();
    }
}
