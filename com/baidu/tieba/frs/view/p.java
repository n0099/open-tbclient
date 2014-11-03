package com.baidu.tieba.frs.view;

import android.content.Context;
import android.view.View;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.PraiseData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class p implements View.OnClickListener {
    final /* synthetic */ FrsPraiseView aGo;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(FrsPraiseView frsPraiseView) {
        this.aGo = frsPraiseView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        PraiseData praiseData;
        Context context;
        praiseData = this.aGo.aGm;
        MetaData metaData = praiseData.getUser().get(1);
        if (metaData != null) {
            context = this.aGo.mContext;
            com.baidu.tbadk.util.f.a(2002003, new PersonInfoActivityConfig(context, metaData.getUserId(), metaData.getName_show()));
        }
    }
}
