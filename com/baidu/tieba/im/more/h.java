package com.baidu.tieba.im.more;

import android.view.View;
import com.baidu.tbadk.coreExtra.view.TbSettingTextTipView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h implements View.OnClickListener {
    final /* synthetic */ g bkj;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(g gVar) {
        this.bkj = gVar;
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
        jVar = this.bkj.bjT;
        if (jVar != null) {
            view2 = this.bkj.mBack;
            if (view != view2) {
                tbSettingTextTipView = this.bkj.bka;
                if (view != tbSettingTextTipView) {
                    tbSettingTextTipView2 = this.bkj.bkb;
                    if (view != tbSettingTextTipView2) {
                        tbSettingTextTipView3 = this.bkj.bkc;
                        if (view != tbSettingTextTipView3) {
                            tbSettingTextTipView4 = this.bkj.bkd;
                            if (view != tbSettingTextTipView4) {
                                return;
                            }
                            jVar2 = this.bkj.bjT;
                            jVar2.RE();
                            return;
                        }
                        jVar3 = this.bkj.bjT;
                        jVar3.RF();
                        return;
                    }
                    jVar4 = this.bkj.bjT;
                    jVar4.RG();
                    return;
                }
                jVar5 = this.bkj.bjT;
                jVar5.RD();
                return;
            }
            jVar6 = this.bkj.bjT;
            jVar6.onBackPressed();
        }
    }
}
