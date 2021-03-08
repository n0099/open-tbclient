package com.baidu.tieba.aiapps.apps.k;

import android.content.Context;
import android.content.DialogInterface;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.swan.apps.t.b.g;
import com.baidu.swan.apps.view.SwanAppErrorDialog;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tieba.R;
/* loaded from: classes8.dex */
public class a implements g {
    @Override // com.baidu.swan.apps.t.b.g
    public boolean a(Context context, String str, com.baidu.swan.apps.al.a aVar) {
        ar arVar = new ar("c13607");
        arVar.dR("uid", com.baidu.tieba.aiapps.apps.a.a.bNg().getUid() == null ? "" : com.baidu.tieba.aiapps.apps.a.a.bNg().getUid());
        arVar.v("obj_param1", aVar.aNe());
        arVar.dR(TiebaInitialize.Params.OBJ_PARAM2, aVar.aNf());
        TiebaStatic.log(arVar);
        if (aVar.aNd() == 10 && aVar.aNe() == 1013) {
            bNW();
            return true;
        }
        return false;
    }

    private void bNW() {
        SwanAppErrorDialog.aPa().iP(R.string.swan_app_update_title).iQ(R.string.swan_app_update_msg).a(R.string.swan_app_update_btn, (DialogInterface.OnClickListener) null).show();
    }
}
