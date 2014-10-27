package com.baidu.tieba.faceshop;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import com.baidu.adp.base.BdBaseActivity;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.coreExtra.act.LoginActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bj implements View.OnClickListener {
    final /* synthetic */ bi auv;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bj(bi biVar) {
        this.auv = biVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Context context;
        try {
            bn bnVar = (bn) view.getTag();
            if (bnVar != null) {
                int i = bnVar.position;
                if (!TbadkApplication.isLogin()) {
                    this.auv.aus = bnVar.position;
                    context = this.auv.mContext;
                    LoginActivity.a((Activity) ((BdBaseActivity) context), (String) null, true, 11003);
                } else {
                    switch (bnVar.auG) {
                        case 2:
                            this.auv.ev(i);
                            break;
                        case 3:
                            this.auv.ew(i);
                            break;
                        case 4:
                            this.auv.ex(i);
                            break;
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
