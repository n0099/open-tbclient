package com.baidu.tieba.frs.view;

import android.content.Context;
import com.baidu.tbadk.core.b.ag;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.PraiseData;
import com.baidu.tieba.view.ac;
/* loaded from: classes.dex */
final class l implements ac {
    final /* synthetic */ FrsPraiseView a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(FrsPraiseView frsPraiseView) {
        this.a = frsPraiseView;
    }

    @Override // com.baidu.tieba.view.ac
    public final void a(int i) {
        PraiseData praiseData;
        Context context;
        praiseData = this.a.e;
        MetaData metaData = praiseData.getUser().get(i);
        if (metaData != null) {
            com.baidu.adp.framework.c a = com.baidu.adp.framework.c.a();
            context = this.a.a;
            a.a(new com.baidu.adp.framework.message.a(2001003, new ag(context, metaData.getUserId(), metaData.getName_show())));
        }
    }
}
