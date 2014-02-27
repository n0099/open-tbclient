package com.baidu.tieba.faceshop;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.account.LoginActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class ax implements View.OnClickListener {
    final /* synthetic */ aw a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ax(aw awVar) {
        this.a = awVar;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        Context context;
        try {
            bb bbVar = (bb) view.getTag();
            if (bbVar != null) {
                int i = bbVar.a;
                if (!TiebaApplication.w()) {
                    this.a.j = bbVar.a;
                    context = this.a.c;
                    LoginActivity.a((Activity) ((com.baidu.adp.a.a) context), (String) null, true, 11003);
                } else {
                    switch (bbVar.b) {
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
