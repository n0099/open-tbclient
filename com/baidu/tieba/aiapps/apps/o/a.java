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
        anVar.cI("obj_id", str);
        anVar.cI("uid", com.baidu.tieba.aiapps.apps.a.a.bhM().getUid() == null ? "" : com.baidu.tieba.aiapps.apps.a.a.bhM().getUid());
        anVar.t("obj_param1", aVar.aoo());
        anVar.cI(TiebaInitialize.Params.OBJ_PARAM2, aVar.aop());
        TiebaStatic.log(anVar);
        if (aVar.aon() == 10 && aVar.aoo() == 1013) {
            bjs();
            return true;
        }
        return false;
    }

    private void bjs() {
        SwanAppErrorDialog.apI().fW(R.string.swan_app_update_title).fX(R.string.swan_app_update_msg).a(R.string.swan_app_update_btn, (DialogInterface.OnClickListener) null).show();
    }
}
