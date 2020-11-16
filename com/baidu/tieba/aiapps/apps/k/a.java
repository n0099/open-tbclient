package com.baidu.tieba.aiapps.apps.k;

import android.content.Context;
import android.content.DialogInterface;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.swan.apps.t.b.g;
import com.baidu.swan.apps.view.SwanAppErrorDialog;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tieba.R;
/* loaded from: classes24.dex */
public class a implements g {
    @Override // com.baidu.swan.apps.t.b.g
    public boolean a(Context context, String str, com.baidu.swan.apps.am.a aVar) {
        ar arVar = new ar("c13607");
        arVar.dR("uid", com.baidu.tieba.aiapps.apps.a.a.bKh().getUid() == null ? "" : com.baidu.tieba.aiapps.apps.a.a.bKh().getUid());
        arVar.w("obj_param1", aVar.aLd());
        arVar.dR(TiebaInitialize.Params.OBJ_PARAM2, aVar.aLe());
        TiebaStatic.log(arVar);
        if (aVar.aLc() == 10 && aVar.aLd() == 1013) {
            bKY();
            return true;
        }
        return false;
    }

    private void bKY() {
        SwanAppErrorDialog.aMW().jQ(R.string.swan_app_update_title).jR(R.string.swan_app_update_msg).a(R.string.swan_app_update_btn, (DialogInterface.OnClickListener) null).show();
    }
}
