package com.baidu.tieba.frs.f;

import android.util.Log;
import android.widget.CompoundButton;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.an;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.view.o;
import com.baidu.tieba.w;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class af implements o.a {
    final /* synthetic */ ae cib;

    /* JADX INFO: Access modifiers changed from: package-private */
    public af(ae aeVar) {
        this.cib = aeVar;
    }

    @Override // com.baidu.tbadk.core.view.o.a
    public void a(an anVar) {
        TiebaStatic.log(new as("c11973").Z("fid", anVar.getFid()).Z("tid", anVar.getTid()).Z(SapiAccountManager.SESSION_UID, TbadkCoreApplication.getCurrentAccount()));
    }

    @Override // com.baidu.tbadk.core.view.o.a
    public void a(an anVar, CompoundButton compoundButton, boolean z) {
    }

    @Override // com.baidu.tbadk.core.view.o.a
    public void a(ArrayList<Integer> arrayList, an anVar) {
        if (arrayList != null && anVar != null) {
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
            TiebaStatic.log(new as("c11974").Z("obj_locate", sb.toString()).Z("fid", anVar.getFid()).Z("tid", anVar.getTid()).Z(SapiAccountManager.SESSION_UID, TbadkCoreApplication.getCurrentAccount()));
        }
    }
}
