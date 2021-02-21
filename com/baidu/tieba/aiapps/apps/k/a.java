package com.baidu.tieba.aiapps.apps.k;

import android.content.Context;
import android.content.DialogInterface;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.swan.apps.t.b.g;
import com.baidu.swan.apps.view.SwanAppErrorDialog;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tieba.R;
/* loaded from: classes9.dex */
public class a implements g {
    @Override // com.baidu.swan.apps.t.b.g
    public boolean a(Context context, String str, com.baidu.swan.apps.al.a aVar) {
        ar arVar = new ar("c13607");
        arVar.dR("uid", com.baidu.tieba.aiapps.apps.a.a.bNa().getUid() == null ? "" : com.baidu.tieba.aiapps.apps.a.a.bNa().getUid());
        arVar.v("obj_param1", aVar.aNb());
        arVar.dR(TiebaInitialize.Params.OBJ_PARAM2, aVar.aNc());
        TiebaStatic.log(arVar);
        if (aVar.aNa() == 10 && aVar.aNb() == 1013) {
            bNQ();
            return true;
        }
        return false;
    }

    private void bNQ() {
        SwanAppErrorDialog.aOX().iO(R.string.swan_app_update_title).iP(R.string.swan_app_update_msg).a(R.string.swan_app_update_btn, (DialogInterface.OnClickListener) null).show();
    }
}
