package com.baidu.tieba.im.more;

import android.view.View;
import com.baidu.tbadk.coreExtra.view.TbSettingTextTipView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h implements View.OnClickListener {
    final /* synthetic */ g biN;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(g gVar) {
        this.biN = gVar;
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
        jVar = this.biN.bix;
        if (jVar != null) {
            view2 = this.biN.mBack;
            if (view != view2) {
                tbSettingTextTipView = this.biN.biE;
                if (view != tbSettingTextTipView) {
                    tbSettingTextTipView2 = this.biN.biF;
                    if (view != tbSettingTextTipView2) {
                        tbSettingTextTipView3 = this.biN.biG;
                        if (view != tbSettingTextTipView3) {
                            tbSettingTextTipView4 = this.biN.biH;
                            if (view != tbSettingTextTipView4) {
                                return;
                            }
                            jVar2 = this.biN.bix;
                            jVar2.Rn();
                            return;
                        }
                        jVar3 = this.biN.bix;
                        jVar3.Ro();
                        return;
                    }
                    jVar4 = this.biN.bix;
                    jVar4.Rp();
                    return;
                }
                jVar5 = this.biN.bix;
                jVar5.Rm();
                return;
            }
            jVar6 = this.biN.bix;
            jVar6.onBackPressed();
        }
    }
}
