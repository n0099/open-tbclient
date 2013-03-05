package com.baidu.tieba.home;

import android.content.Context;
import android.view.View;
import com.baidu.loginshare.Token;
import com.baidu.tieba.TiebaApplication;
/* loaded from: classes.dex */
class g implements View.OnClickListener {
    final /* synthetic */ f a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(f fVar) {
        this.a = fVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Context context;
        Context context2;
        if (TiebaApplication.b().aA() != null) {
            Token b = com.baidu.tieba.account.a.b(TiebaApplication.y());
            String b2 = TiebaApplication.b().aA().b();
            String c = TiebaApplication.b().aA().c();
            if (b != null) {
                context2 = this.a.a;
                LotteryActivity.a(context2, b2, c, b.mBduss, b.mPtoken, TiebaApplication.z());
                return;
            }
            context = this.a.a;
            LotteryActivity.a(context, b2, c, null, null, TiebaApplication.z());
        }
    }
}
