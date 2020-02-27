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
        anVar.cy("uid", com.baidu.tieba.aiapps.apps.a.a.aZD().getUid() == null ? "" : com.baidu.tieba.aiapps.apps.a.a.aZD().getUid());
        anVar.s("obj_param1", aVar.agf());
        anVar.cy(TiebaInitialize.Params.OBJ_PARAM2, aVar.agg());
        TiebaStatic.log(anVar);
        if (aVar.age() == 10 && aVar.agf() == 1013) {
            bbk();
            return true;
        }
        return false;
    }

    private void bbk() {
        SwanAppErrorDialog.ahw().fP(R.string.swan_app_update_title).fQ(R.string.swan_app_update_msg).a(R.string.swan_app_update_btn, (DialogInterface.OnClickListener) null).show();
    }
}
