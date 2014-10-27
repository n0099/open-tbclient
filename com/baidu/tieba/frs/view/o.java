package com.baidu.tieba.frs.view;

import android.content.Context;
import android.view.View;
import com.baidu.tbadk.core.atomData.PraiseListActivityConfig;
import com.baidu.tbadk.core.data.PraiseData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class o implements View.OnClickListener {
    final /* synthetic */ FrsPraiseView aGe;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(FrsPraiseView frsPraiseView) {
        this.aGe = frsPraiseView;
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
        praiseData = this.aGe.aGc;
        if (praiseData != null) {
            praiseData2 = this.aGe.aGc;
            str3 = praiseData2.getTitle();
        }
        context = this.aGe.mContext;
        str = this.aGe.mThreadId;
        str2 = this.aGe.mPostId;
        z = this.aGe.aGd;
        com.baidu.tbadk.util.f.c(new PraiseListActivityConfig(context, str, str2, str3, z));
    }
}
