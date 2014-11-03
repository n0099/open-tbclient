package com.baidu.tieba.discover;

import android.view.View;
import com.baidu.tbadk.BaseActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class w implements View.OnClickListener {
    final /* synthetic */ v aor;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(v vVar) {
        this.aor = vVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        BaseActivity baseActivity;
        baseActivity = this.aor.Or;
        baseActivity.finish();
    }
}
