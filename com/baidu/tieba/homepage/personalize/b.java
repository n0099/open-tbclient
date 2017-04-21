package com.baidu.tieba.homepage.personalize;

import android.widget.CompoundButton;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.al;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.view.o;
import com.baidu.tieba.w;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements o.a {
    final /* synthetic */ a czr;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.czr = aVar;
    }

    @Override // com.baidu.tbadk.core.view.o.a
    public void a(al alVar) {
        if (alVar != null) {
            TiebaStatic.log(new as("c11693").aa("obj_locate", "1").aa("fid", alVar.getFid()).aa("tid", alVar.getTid()).aa(SapiAccountManager.SESSION_UID, TbadkCoreApplication.getCurrentAccount()));
            TiebaStatic.log(new as("c11989").aa("fid", alVar.getFid()).aa("tid", alVar.getTid()).aa(SapiAccountManager.SESSION_UID, TbadkCoreApplication.getCurrentAccount()));
        }
    }

    @Override // com.baidu.tbadk.core.view.o.a
    public void a(al alVar, CompoundButton compoundButton, boolean z) {
    }

    @Override // com.baidu.tbadk.core.view.o.a
    public void a(ArrayList<Integer> arrayList, al alVar) {
        String str;
        if (arrayList != null && alVar != null) {
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
                        TiebaStatic.log(new as("c11693").aa("obj_locate", str).aa("fid", alVar.getFid()).aa("tid", alVar.getTid()).aa(SapiAccountManager.SESSION_UID, TbadkCoreApplication.getCurrentAccount()));
                    }
                    i = i2 + 1;
                } else {
                    TiebaStatic.log(new as("c11693").aa("obj_locate", "5").aa("fid", alVar.getFid()).aa("tid", alVar.getTid()).aa(SapiAccountManager.SESSION_UID, TbadkCoreApplication.getCurrentAccount()));
                    return;
                }
            }
        }
    }
}
