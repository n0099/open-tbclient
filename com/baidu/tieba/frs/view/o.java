package com.baidu.tieba.frs.view;

import android.content.Context;
import android.view.View;
import com.baidu.tbadk.core.atomData.PraiseListActivityConfig;
import com.baidu.tbadk.core.data.PraiseData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class o implements View.OnClickListener {
    final /* synthetic */ FrsPraiseView aGo;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(FrsPraiseView frsPraiseView) {
        this.aGo = frsPraiseView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        PraiseData praiseData;
        Context context;
        String str;
        String str2;
        boolean z;
        PraiseData praiseData2;
        String str3 = "";
        praiseData = this.aGo.aGm;
        if (praiseData != null) {
            praiseData2 = this.aGo.aGm;
            str3 = praiseData2.getTitle();
        }
        context = this.aGo.mContext;
        str = this.aGo.mThreadId;
        str2 = this.aGo.mPostId;
        z = this.aGo.aGn;
        com.baidu.tbadk.util.f.c(new PraiseListActivityConfig(context, str, str2, str3, z));
    }
}
