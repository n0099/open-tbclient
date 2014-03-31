package com.baidu.tieba.frs.view;

import android.content.Context;
import com.baidu.tbadk.core.b.ag;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.PraiseData;
import com.baidu.tieba.view.ae;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class l implements ae {
    final /* synthetic */ FrsPraiseView a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(FrsPraiseView frsPraiseView) {
        this.a = frsPraiseView;
    }

    @Override // com.baidu.tieba.view.ae
    public final void a(int i) {
        PraiseData praiseData;
        Context context;
        praiseData = this.a.f;
        MetaData metaData = praiseData.getUser().get(i);
        if (metaData != null) {
            com.baidu.adp.framework.c a = com.baidu.adp.framework.c.a();
            context = this.a.a;
            a.a(new com.baidu.adp.framework.message.a(2001003, new ag(context, metaData.getUserId(), metaData.getName_show())));
        }
    }
}
