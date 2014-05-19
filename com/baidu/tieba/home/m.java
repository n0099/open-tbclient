package com.baidu.tieba.home;

import android.view.View;
import com.baidu.tieba.data.y;
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
        y yVar;
        boolean z;
        com.baidu.tbadk.core.e eVar;
        y yVar2;
        y yVar3;
        yVar = this.a.b;
        if (yVar != null) {
            yVar2 = this.a.b;
            if (yVar2.a() != null) {
                yVar3 = this.a.b;
                if (yVar3.a().size() > 0) {
                    z = true;
                    eVar = this.a.a;
                    NewUserGuideActivity.a(eVar, false, z);
                }
            }
        }
        z = false;
        eVar = this.a.a;
        NewUserGuideActivity.a(eVar, false, z);
    }
}
