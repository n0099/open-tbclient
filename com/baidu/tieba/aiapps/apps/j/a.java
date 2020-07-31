package com.baidu.tieba.aiapps.apps.j;

import android.content.Context;
import android.content.DialogInterface;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.swan.apps.t.b.g;
import com.baidu.swan.apps.view.SwanAppErrorDialog;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.R;
/* loaded from: classes19.dex */
public class a implements g {
    @Override // com.baidu.swan.apps.t.b.g
    public boolean a(Context context, String str, com.baidu.swan.apps.an.a aVar) {
        ap apVar = new ap("c13607");
        apVar.dn("uid", com.baidu.tieba.aiapps.apps.a.a.btC().getUid() == null ? "" : com.baidu.tieba.aiapps.apps.a.a.btC().getUid());
        apVar.t("obj_param1", aVar.avP());
        apVar.dn(TiebaInitialize.Params.OBJ_PARAM2, aVar.avQ());
        TiebaStatic.log(apVar);
        if (aVar.avO() == 10 && aVar.avP() == 1013) {
            bus();
            return true;
        }
        return false;
    }

    private void bus() {
        SwanAppErrorDialog.axJ().gK(R.string.swan_app_update_title).gL(R.string.swan_app_update_msg).a(R.string.swan_app_update_btn, (DialogInterface.OnClickListener) null).show();
    }
}
