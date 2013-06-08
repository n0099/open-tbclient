package com.baidu.tieba.home;

import android.content.Context;
import android.view.View;
import com.baidu.loginshare.Token;
import com.baidu.tieba.TiebaApplication;
/* loaded from: classes.dex */
class m implements View.OnClickListener {
    final /* synthetic */ l a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(l lVar) {
        this.a = lVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Context context;
        Context context2;
        if (TiebaApplication.d().aO() != null) {
            Token b = com.baidu.tieba.account.a.b(TiebaApplication.C());
            String b2 = TiebaApplication.d().aO().b();
            String c = TiebaApplication.d().aO().c();
            if (b != null) {
                context2 = this.a.a;
                LotteryActivity.a(context2, b2, c, b.mBduss, b.mPtoken, TiebaApplication.D());
                return;
            }
            context = this.a.a;
            LotteryActivity.a(context, b2, c, null, null, TiebaApplication.D());
        }
    }
}
