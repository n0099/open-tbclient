package com.baidu.tieba.home;

import android.view.View;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tieba.data.z;
import com.baidu.tieba.guide.NewUserGuideActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class p implements View.OnClickListener {
    final /* synthetic */ o aMB;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(o oVar) {
        this.aMB = oVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        z zVar;
        boolean z;
        BaseFragmentActivity baseFragmentActivity;
        z zVar2;
        z zVar3;
        zVar = this.aMB.aMq;
        if (zVar != null) {
            zVar2 = this.aMB.aMq;
            if (zVar2.zx() != null) {
                zVar3 = this.aMB.aMq;
                if (zVar3.zx().size() > 0) {
                    z = true;
                    baseFragmentActivity = this.aMB.mActivity;
                    NewUserGuideActivity.a(baseFragmentActivity, false, z);
                }
            }
        }
        z = false;
        baseFragmentActivity = this.aMB.mActivity;
        NewUserGuideActivity.a(baseFragmentActivity, false, z);
    }
}
