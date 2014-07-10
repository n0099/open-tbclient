package com.baidu.tieba.discover;

import android.view.View;
import com.baidu.tbadk.BaseActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class t implements View.OnClickListener {
    final /* synthetic */ s a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(s sVar) {
        this.a = sVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        BaseActivity baseActivity;
        baseActivity = this.a.a;
        baseActivity.finish();
    }
}
