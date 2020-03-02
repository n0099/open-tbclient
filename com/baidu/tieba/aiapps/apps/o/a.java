package com.baidu.tieba.aiapps.apps.o;

import android.content.DialogInterface;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.swan.apps.view.SwanAppErrorDialog;
import com.baidu.swan.apps.w.b.i;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tieba.R;
/* loaded from: classes12.dex */
public class a implements i {
    @Override // com.baidu.swan.apps.w.b.i
    public boolean a(String str, com.baidu.swan.apps.ap.a aVar) {
        an anVar = new an("c13607");
        anVar.cy("obj_id", str);
        anVar.cy("uid", com.baidu.tieba.aiapps.apps.a.a.aZF().getUid() == null ? "" : com.baidu.tieba.aiapps.apps.a.a.aZF().getUid());
        anVar.s("obj_param1", aVar.agh());
        anVar.cy(TiebaInitialize.Params.OBJ_PARAM2, aVar.agi());
        TiebaStatic.log(anVar);
        if (aVar.agg() == 10 && aVar.agh() == 1013) {
            bbm();
            return true;
        }
        return false;
    }

    private void bbm() {
        SwanAppErrorDialog.ahy().fP(R.string.swan_app_update_title).fQ(R.string.swan_app_update_msg).a(R.string.swan_app_update_btn, (DialogInterface.OnClickListener) null).show();
    }
}
