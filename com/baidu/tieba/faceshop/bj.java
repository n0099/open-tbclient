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
    final /* synthetic */ bi auE;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bj(bi biVar) {
        this.auE = biVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Context context;
        try {
            bn bnVar = (bn) view.getTag();
            if (bnVar != null) {
                int i = bnVar.position;
                if (!TbadkApplication.isLogin()) {
                    this.auE.auB = bnVar.position;
                    context = this.auE.mContext;
                    LoginActivity.a((Activity) ((BdBaseActivity) context), (String) null, true, 11003);
                } else {
                    switch (bnVar.auP) {
                        case 2:
                            this.auE.ev(i);
                            break;
                        case 3:
                            this.auE.ew(i);
                            break;
                        case 4:
                            this.auE.ex(i);
                            break;
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
