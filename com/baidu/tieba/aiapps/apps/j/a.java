package com.baidu.tieba.aiapps.apps.j;

import android.content.DialogInterface;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.swan.apps.u.b.g;
import com.baidu.swan.apps.view.SwanAppErrorDialog;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tieba.R;
/* loaded from: classes12.dex */
public class a implements g {
    @Override // com.baidu.swan.apps.u.b.g
    public boolean a(String str, com.baidu.swan.apps.an.a aVar) {
        an anVar = new an("c13607");
        anVar.dh("obj_id", str);
        anVar.dh("uid", com.baidu.tieba.aiapps.apps.a.a.bnX().getUid() == null ? "" : com.baidu.tieba.aiapps.apps.a.a.bnX().getUid());
        anVar.s("obj_param1", aVar.asI());
        anVar.dh(TiebaInitialize.Params.OBJ_PARAM2, aVar.asJ());
        TiebaStatic.log(anVar);
        if (aVar.asH() == 10 && aVar.asI() == 1013) {
            boJ();
            return true;
        }
        return false;
    }

    private void boJ() {
        SwanAppErrorDialog.aup().gn(R.string.swan_app_update_title).gp(R.string.swan_app_update_msg).a(R.string.swan_app_update_btn, (DialogInterface.OnClickListener) null).show();
    }
}
