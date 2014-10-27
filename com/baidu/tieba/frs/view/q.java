package com.baidu.tieba.frs.view;

import android.content.Context;
import android.view.View;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.PraiseData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class q implements View.OnClickListener {
    final /* synthetic */ FrsPraiseView aGe;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(FrsPraiseView frsPraiseView) {
        this.aGe = frsPraiseView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        PraiseData praiseData;
        Context context;
        praiseData = this.aGe.aGc;
        MetaData metaData = praiseData.getUser().get(0);
        if (metaData != null) {
            context = this.aGe.mContext;
            com.baidu.tbadk.util.f.a(2002003, new PersonInfoActivityConfig(context, metaData.getUserId(), metaData.getName_show()));
        }
    }
}
