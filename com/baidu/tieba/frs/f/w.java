package com.baidu.tieba.frs.f;

import android.util.Log;
import android.widget.CompoundButton;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ao;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.view.o;
import com.baidu.tieba.w;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class w implements o.a {
    final /* synthetic */ v cqc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(v vVar) {
        this.cqc = vVar;
    }

    @Override // com.baidu.tbadk.core.view.o.a
    public void a(ao aoVar) {
        TiebaStatic.log(new au("c11973").Z("fid", aoVar.getFid()).Z("tid", aoVar.getTid()).Z(SapiAccountManager.SESSION_UID, TbadkCoreApplication.getCurrentAccount()));
    }

    @Override // com.baidu.tbadk.core.view.o.a
    public void a(ao aoVar, CompoundButton compoundButton, boolean z) {
    }

    @Override // com.baidu.tbadk.core.view.o.a
    public void a(ArrayList<Integer> arrayList, ao aoVar) {
        if (arrayList != null && aoVar != null) {
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
            TiebaStatic.log(new au("c11974").Z("obj_locate", sb.toString()).Z("fid", aoVar.getFid()).Z("tid", aoVar.getTid()).Z(SapiAccountManager.SESSION_UID, TbadkCoreApplication.getCurrentAccount()));
        }
    }
}
