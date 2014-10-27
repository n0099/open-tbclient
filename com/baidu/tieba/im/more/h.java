package com.baidu.tieba.im.more;

import android.view.View;
import com.baidu.tbadk.coreExtra.view.TbSettingTextTipView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h implements View.OnClickListener {
    final /* synthetic */ g bfg;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(g gVar) {
        this.bfg = gVar;
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
        jVar = this.bfg.beQ;
        if (jVar != null) {
            view2 = this.bfg.Js;
            if (view != view2) {
                tbSettingTextTipView = this.bfg.beX;
                if (view != tbSettingTextTipView) {
                    tbSettingTextTipView2 = this.bfg.beY;
                    if (view != tbSettingTextTipView2) {
                        tbSettingTextTipView3 = this.bfg.beZ;
                        if (view != tbSettingTextTipView3) {
                            tbSettingTextTipView4 = this.bfg.bfa;
                            if (view != tbSettingTextTipView4) {
                                return;
                            }
                            jVar2 = this.bfg.beQ;
                            jVar2.QL();
                            return;
                        }
                        jVar3 = this.bfg.beQ;
                        jVar3.QM();
                        return;
                    }
                    jVar4 = this.bfg.beQ;
                    jVar4.QN();
                    return;
                }
                jVar5 = this.bfg.beQ;
                jVar5.QK();
                return;
            }
            jVar6 = this.bfg.beQ;
            jVar6.onBackPressed();
        }
    }
}
