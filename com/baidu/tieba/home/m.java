package com.baidu.tieba.home;

import android.view.View;
import com.baidu.tieba.guide.NewUserGuideActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class m implements View.OnClickListener {
    final /* synthetic */ l a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(l lVar) {
        this.a = lVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tieba.data.ae aeVar;
        boolean z;
        com.baidu.tieba.k kVar;
        com.baidu.tieba.data.ae aeVar2;
        com.baidu.tieba.data.ae aeVar3;
        aeVar = this.a.b;
        if (aeVar != null) {
            aeVar2 = this.a.b;
            if (aeVar2.a() != null) {
                aeVar3 = this.a.b;
                if (aeVar3.a().size() > 0) {
                    z = true;
                    kVar = this.a.a;
                    NewUserGuideActivity.a(kVar, false, z);
                }
            }
        }
        z = false;
        kVar = this.a.a;
        NewUserGuideActivity.a(kVar, false, z);
    }
}
