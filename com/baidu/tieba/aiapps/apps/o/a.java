package com.baidu.tieba.aiapps.apps.o;

import android.content.DialogInterface;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.swan.apps.view.SwanAppErrorDialog;
import com.baidu.swan.apps.w.b.i;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tieba.R;
/* loaded from: classes9.dex */
public class a implements i {
    @Override // com.baidu.swan.apps.w.b.i
    public boolean a(String str, com.baidu.swan.apps.ap.a aVar) {
        an anVar = new an("c13607");
        anVar.cp("obj_id", str);
        anVar.cp("uid", com.baidu.tieba.aiapps.apps.a.a.aWU().getUid() == null ? "" : com.baidu.tieba.aiapps.apps.a.a.aWU().getUid());
        anVar.s("obj_param1", aVar.ady());
        anVar.cp(TiebaInitialize.Params.OBJ_PARAM2, aVar.adz());
        TiebaStatic.log(anVar);
        if (aVar.adx() == 10 && aVar.ady() == 1013) {
            aYB();
            return true;
        }
        return false;
    }

    private void aYB() {
        SwanAppErrorDialog.aeP().fy(R.string.swan_app_update_title).fz(R.string.swan_app_update_msg).a(R.string.swan_app_update_btn, (DialogInterface.OnClickListener) null).show();
    }
}
