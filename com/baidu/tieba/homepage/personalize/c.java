package com.baidu.tieba.homepage.personalize;

import android.widget.CompoundButton;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.an;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.view.o;
import com.baidu.tieba.w;
import java.util.ArrayList;
/* loaded from: classes.dex */
class c implements o.a {
    final /* synthetic */ b cAU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(b bVar) {
        this.cAU = bVar;
    }

    @Override // com.baidu.tbadk.core.view.o.a
    public void a(an anVar) {
        if (anVar != null) {
            TiebaStatic.log(new as("c11693").Z("obj_locate", "1").Z("fid", anVar.getFid()).Z("tid", anVar.getTid()).Z(SapiAccountManager.SESSION_UID, TbadkCoreApplication.getCurrentAccount()));
            TiebaStatic.log(new as("c11989").Z("fid", anVar.getFid()).Z("tid", anVar.getTid()).Z(SapiAccountManager.SESSION_UID, TbadkCoreApplication.getCurrentAccount()));
        }
    }

    @Override // com.baidu.tbadk.core.view.o.a
    public void a(an anVar, CompoundButton compoundButton, boolean z) {
    }

    @Override // com.baidu.tbadk.core.view.o.a
    public void a(ArrayList<Integer> arrayList, an anVar) {
        String str;
        if (arrayList != null && anVar != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < arrayList.size()) {
                    int intValue = arrayList.get(i2).intValue();
                    if (intValue == w.h.reason_checkbox1) {
                        str = "2";
                    } else if (intValue == w.h.reason_checkbox2) {
                        str = TbConfig.ST_PARAM_PERSON_INFO_SEND_MESSAGE;
                    } else {
                        str = intValue == w.h.reason_checkbox3 ? "4" : "";
                    }
                    if (!"".equals(str)) {
                        TiebaStatic.log(new as("c11693").Z("obj_locate", str).Z("fid", anVar.getFid()).Z("tid", anVar.getTid()).Z(SapiAccountManager.SESSION_UID, TbadkCoreApplication.getCurrentAccount()));
                    }
                    i = i2 + 1;
                } else {
                    TiebaStatic.log(new as("c11693").Z("obj_locate", "5").Z("fid", anVar.getFid()).Z("tid", anVar.getTid()).Z(SapiAccountManager.SESSION_UID, TbadkCoreApplication.getCurrentAccount()));
                    return;
                }
            }
        }
    }
}
