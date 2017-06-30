package com.baidu.tieba.frs.f;

import android.view.View;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.view.NoPressedRelativeLayout;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j implements View.OnClickListener {
    final /* synthetic */ i cpK;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(i iVar) {
        this.cpK = iVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tieba.frs.r rVar;
        com.baidu.tieba.frs.r rVar2;
        NoPressedRelativeLayout noPressedRelativeLayout;
        if (!this.cpK.ahI()) {
            if (this.cpK.cpJ == null) {
                i iVar = this.cpK;
                rVar2 = this.cpK.cdv;
                TbPageContext<BaseFragmentActivity> pageContext = rVar2.getPageContext();
                noPressedRelativeLayout = this.cpK.cpj;
                iVar.cpJ = new com.baidu.tieba.write.e(pageContext, noPressedRelativeLayout);
                this.cpK.cpJ.sa("2");
            }
            com.baidu.tieba.write.e eVar = this.cpK.cpJ;
            rVar = this.cpK.cdv;
            eVar.a(rVar.aeo());
            this.cpK.cpJ.ms(false);
        }
    }
}
