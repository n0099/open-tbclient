package com.baidu.tieba.home;

import android.view.View;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tieba.data.aa;
import com.baidu.tieba.guide.NewUserGuideActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class n implements View.OnClickListener {
    final /* synthetic */ m a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(m mVar) {
        this.a = mVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        aa aaVar;
        boolean z;
        BaseFragmentActivity baseFragmentActivity;
        aa aaVar2;
        aa aaVar3;
        aaVar = this.a.b;
        if (aaVar != null) {
            aaVar2 = this.a.b;
            if (aaVar2.a() != null) {
                aaVar3 = this.a.b;
                if (aaVar3.a().size() > 0) {
                    z = true;
                    baseFragmentActivity = this.a.a;
                    NewUserGuideActivity.a(baseFragmentActivity, false, z);
                }
            }
        }
        z = false;
        baseFragmentActivity = this.a.a;
        NewUserGuideActivity.a(baseFragmentActivity, false, z);
    }
}
