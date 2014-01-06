package com.baidu.tieba.faceshop;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.account.LoginActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class az implements View.OnClickListener {
    final /* synthetic */ ay a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public az(ay ayVar) {
        this.a = ayVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Context context;
        try {
            bd bdVar = (bd) view.getTag();
            if (bdVar != null) {
                int i = bdVar.a;
                if (!TiebaApplication.B()) {
                    this.a.j = bdVar.a;
                    context = this.a.c;
                    LoginActivity.a((Activity) ((com.baidu.adp.a.a) context), (String) null, true, 11003);
                } else {
                    switch (bdVar.b) {
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
