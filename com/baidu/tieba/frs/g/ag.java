package com.baidu.tieba.frs.g;

import android.util.Log;
import android.widget.CompoundButton;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.o;
import com.baidu.tieba.w;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ag implements o.a {
    final /* synthetic */ af cef;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ag(af afVar) {
        this.cef = afVar;
    }

    @Override // com.baidu.tbadk.core.view.o.a
    public void a(com.baidu.tbadk.core.data.al alVar) {
        TiebaStatic.log(new com.baidu.tbadk.core.util.as("c11973").aa("fid", alVar.getFid()).aa("tid", alVar.getTid()).aa(SapiAccountManager.SESSION_UID, TbadkCoreApplication.getCurrentAccount()));
    }

    @Override // com.baidu.tbadk.core.view.o.a
    public void a(com.baidu.tbadk.core.data.al alVar, CompoundButton compoundButton, boolean z) {
    }

    @Override // com.baidu.tbadk.core.view.o.a
    public void a(ArrayList<Integer> arrayList, com.baidu.tbadk.core.data.al alVar) {
        if (arrayList != null && alVar != null) {
            StringBuilder sb = new StringBuilder();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= arrayList.size()) {
                    break;
                }
                int intValue = arrayList.get(i2).intValue();
                if (intValue == w.h.reason_checkbox1) {
                    sb.append("left,");
                } else if (intValue == w.h.reason_checkbox2) {
                    sb.append("mid,");
                } else if (intValue == w.h.reason_checkbox3) {
                    sb.append("right,");
                }
                i = i2 + 1;
            }
            if (sb.length() > 0) {
                sb.deleteCharAt(sb.length() - 1);
            }
            Log.v("steven", "location is " + sb.toString());
            TiebaStatic.log(new com.baidu.tbadk.core.util.as("c11974").aa("obj_locate", sb.toString()).aa("fid", alVar.getFid()).aa("tid", alVar.getTid()).aa(SapiAccountManager.SESSION_UID, TbadkCoreApplication.getCurrentAccount()));
        }
    }
}
