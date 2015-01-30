package com.baidu.tieba.im.more;

import android.view.View;
import com.baidu.tbadk.coreExtra.view.TbSettingTextTipView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h implements View.OnClickListener {
    final /* synthetic */ g bkk;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(g gVar) {
        this.bkk = gVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        j jVar;
        View view2;
        TbSettingTextTipView tbSettingTextTipView;
        TbSettingTextTipView tbSettingTextTipView2;
        TbSettingTextTipView tbSettingTextTipView3;
        TbSettingTextTipView tbSettingTextTipView4;
        j jVar2;
        j jVar3;
        j jVar4;
        j jVar5;
        j jVar6;
        jVar = this.bkk.bjU;
        if (jVar != null) {
            view2 = this.bkk.mBack;
            if (view != view2) {
                tbSettingTextTipView = this.bkk.bkb;
                if (view != tbSettingTextTipView) {
                    tbSettingTextTipView2 = this.bkk.bkc;
                    if (view != tbSettingTextTipView2) {
                        tbSettingTextTipView3 = this.bkk.bkd;
                        if (view != tbSettingTextTipView3) {
                            tbSettingTextTipView4 = this.bkk.bke;
                            if (view != tbSettingTextTipView4) {
                                return;
                            }
                            jVar2 = this.bkk.bjU;
                            jVar2.RJ();
                            return;
                        }
                        jVar3 = this.bkk.bjU;
                        jVar3.RK();
                        return;
                    }
                    jVar4 = this.bkk.bjU;
                    jVar4.RL();
                    return;
                }
                jVar5 = this.bkk.bjU;
                jVar5.RI();
                return;
            }
            jVar6 = this.bkk.bjU;
            jVar6.onBackPressed();
        }
    }
}
