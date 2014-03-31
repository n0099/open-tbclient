package com.baidu.tieba.faceshop;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.coreExtra.act.LoginActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class bn implements View.OnClickListener {
    final /* synthetic */ bm a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bn(bm bmVar) {
        this.a = bmVar;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        Context context;
        try {
            br brVar = (br) view.getTag();
            if (brVar != null) {
                int i = brVar.a;
                if (!TbadkApplication.F()) {
                    this.a.j = brVar.a;
                    context = this.a.c;
                    LoginActivity.a((Activity) ((com.baidu.adp.a.a) context), (String) null, true, 11003);
                } else {
                    switch (brVar.b) {
                        case 2:
                            this.a.a(i);
                            break;
                        case 3:
                            this.a.b(i);
                            break;
                        case 4:
                            this.a.c(i);
                            break;
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
