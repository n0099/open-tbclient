package com.baidu.tieba.im.more;

import android.view.View;
import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i implements com.baidu.adp.widget.BdSwitchView.c {
    final /* synthetic */ g bfu;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(g gVar) {
        this.bfu = gVar;
    }

    @Override // com.baidu.adp.widget.BdSwitchView.c
    public void a(View view, BdSwitchView.SwitchState switchState) {
        j jVar;
        j jVar2;
        jVar = this.bfu.bfe;
        if (jVar == null) {
            return;
        }
        jVar2 = this.bfu.bfe;
        jVar2.a(switchState);
    }
}
