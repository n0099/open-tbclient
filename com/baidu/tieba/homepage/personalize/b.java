package com.baidu.tieba.homepage.personalize;

import android.widget.CompoundButton;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.am;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.view.o;
import com.baidu.tieba.w;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements o.a {
    final /* synthetic */ a cyA;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.cyA = aVar;
    }

    @Override // com.baidu.tbadk.core.view.o.a
    public void a(am amVar) {
        if (amVar != null) {
            TiebaStatic.log(new as("c11693").Z("obj_locate", "1").Z("fid", amVar.getFid()).Z("tid", amVar.getTid()).Z(SapiAccountManager.SESSION_UID, TbadkCoreApplication.getCurrentAccount()));
            TiebaStatic.log(new as("c11989").Z("fid", amVar.getFid()).Z("tid", amVar.getTid()).Z(SapiAccountManager.SESSION_UID, TbadkCoreApplication.getCurrentAccount()));
        }
    }

    @Override // com.baidu.tbadk.core.view.o.a
    public void a(am amVar, CompoundButton compoundButton, boolean z) {
    }

    @Override // com.baidu.tbadk.core.view.o.a
    public void a(ArrayList<Integer> arrayList, am amVar) {
        String str;
        if (arrayList != null && amVar != null) {
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
                        TiebaStatic.log(new as("c11693").Z("obj_locate", str).Z("fid", amVar.getFid()).Z("tid", amVar.getTid()).Z(SapiAccountManager.SESSION_UID, TbadkCoreApplication.getCurrentAccount()));
                    }
                    i = i2 + 1;
                } else {
                    TiebaStatic.log(new as("c11693").Z("obj_locate", "5").Z("fid", amVar.getFid()).Z("tid", amVar.getTid()).Z(SapiAccountManager.SESSION_UID, TbadkCoreApplication.getCurrentAccount()));
                    return;
                }
            }
        }
    }
}
