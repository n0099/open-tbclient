package com.baidu.tieba.faceshop;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import com.baidu.adp.base.BdBaseActivity;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.coreExtra.act.LoginActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bi implements View.OnClickListener {
    final /* synthetic */ bh a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bi(bh bhVar) {
        this.a = bhVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Context context;
        try {
            bm bmVar = (bm) view.getTag();
            if (bmVar != null) {
                int i = bmVar.a;
                if (!TbadkApplication.isLogin()) {
                    this.a.i = bmVar.a;
                    context = this.a.c;
                    LoginActivity.a((Activity) ((BdBaseActivity) context), (String) null, true, 11003);
                } else {
                    switch (bmVar.b) {
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
