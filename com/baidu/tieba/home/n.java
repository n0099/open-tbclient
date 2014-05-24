package com.baidu.tieba.home;

import android.view.View;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tieba.data.y;
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
        y yVar;
        boolean z;
        BaseFragmentActivity baseFragmentActivity;
        y yVar2;
        y yVar3;
        yVar = this.a.b;
        if (yVar != null) {
            yVar2 = this.a.b;
            if (yVar2.a() != null) {
                yVar3 = this.a.b;
                if (yVar3.a().size() > 0) {
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
