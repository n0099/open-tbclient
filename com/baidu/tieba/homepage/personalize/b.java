package com.baidu.tieba.homepage.personalize;

import android.widget.CompoundButton;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.core.view.o;
import com.baidu.tieba.r;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements o.a {
    final /* synthetic */ a cKG;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.cKG = aVar;
    }

    @Override // com.baidu.tbadk.core.view.o.a
    public void a(com.baidu.tieba.card.data.c cVar) {
        if (cVar != null) {
            TiebaStatic.log(new av("c11693").ab("obj_locate", "1").ab("tid", cVar.TY).ab("uid", TbadkCoreApplication.getCurrentAccount()));
        }
    }

    @Override // com.baidu.tbadk.core.view.o.a
    public void a(com.baidu.tieba.card.data.c cVar, CompoundButton compoundButton, boolean z) {
    }

    @Override // com.baidu.tbadk.core.view.o.a
    public void a(ArrayList<Integer> arrayList, com.baidu.tieba.card.data.c cVar) {
        String str;
        if (arrayList != null && cVar != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < arrayList.size()) {
                    int intValue = arrayList.get(i2).intValue();
                    if (intValue == r.g.reason_checkbox1) {
                        str = "2";
                    } else if (intValue == r.g.reason_checkbox2) {
                        str = TbConfig.ST_PARAM_PERSON_INFO_SEND_MESSAGE;
                    } else {
                        str = intValue == r.g.reason_checkbox3 ? "4" : "";
                    }
                    if (!"".equals(str)) {
                        TiebaStatic.log(new av("c11693").ab("obj_locate", str).ab("tid", cVar.TY).ab("uid", TbadkCoreApplication.getCurrentAccount()));
                    }
                    i = i2 + 1;
                } else {
                    TiebaStatic.log(new av("c11693").ab("obj_locate", "5").ab("tid", cVar.TY).ab("uid", TbadkCoreApplication.getCurrentAccount()));
                    return;
                }
            }
        }
    }
}
