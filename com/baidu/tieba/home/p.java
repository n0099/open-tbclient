package com.baidu.tieba.home;

import android.view.View;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tieba.data.z;
import com.baidu.tieba.guide.NewUserGuideActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class p implements View.OnClickListener {
    final /* synthetic */ o aMP;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(o oVar) {
        this.aMP = oVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        z zVar;
        boolean z;
        BaseFragmentActivity baseFragmentActivity;
        z zVar2;
        z zVar3;
        zVar = this.aMP.aME;
        if (zVar != null) {
            zVar2 = this.aMP.aME;
            if (zVar2.zz() != null) {
                zVar3 = this.aMP.aME;
                if (zVar3.zz().size() > 0) {
                    z = true;
                    baseFragmentActivity = this.aMP.mActivity;
                    NewUserGuideActivity.a(baseFragmentActivity, false, z);
                }
            }
        }
        z = false;
        baseFragmentActivity = this.aMP.mActivity;
        NewUserGuideActivity.a(baseFragmentActivity, false, z);
    }
}
