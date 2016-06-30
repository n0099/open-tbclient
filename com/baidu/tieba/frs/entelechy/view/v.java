package com.baidu.tieba.frs.entelechy.view;

import android.view.View;
import com.baidu.tbadk.core.data.az;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tieba.card.bx;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class v implements View.OnClickListener {
    final /* synthetic */ u bKt;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(u uVar) {
        this.bKt = uVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        az azVar;
        az azVar2;
        az azVar3;
        az azVar4;
        az azVar5;
        azVar = this.bKt.aas;
        if (azVar != null) {
            azVar3 = this.bKt.aas;
            if (azVar3.getAuthor() != null) {
                azVar4 = this.bKt.aas;
                if (azVar4.getAuthor().getGodInfo() != null) {
                    ay s = new ay("c10806").s("obj_locate", 3);
                    azVar5 = this.bKt.aas;
                    TiebaStatic.log(s.ab("tid", azVar5.getId()));
                }
            }
        }
        if (this.bKt.KO() != null) {
            bx<az> KO = this.bKt.KO();
            azVar2 = this.bKt.aas;
            KO.a(view, azVar2);
        }
        this.bKt.Ld();
    }
}
