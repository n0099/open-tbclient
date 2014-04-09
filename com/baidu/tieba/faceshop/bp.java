package com.baidu.tieba.faceshop;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.coreExtra.act.LoginActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class bp implements View.OnClickListener {
    final /* synthetic */ bo a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bp(bo boVar) {
        this.a = boVar;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        Context context;
        try {
            bt btVar = (bt) view.getTag();
            if (btVar != null) {
                int i = btVar.a;
                if (!TbadkApplication.F()) {
                    this.a.j = btVar.a;
                    context = this.a.c;
                    LoginActivity.a((Activity) ((com.baidu.adp.a.a) context), (String) null, true, 11003);
                } else {
                    switch (btVar.b) {
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
