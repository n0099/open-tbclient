package com.baidu.tieba.im.more;

import android.view.View;
import com.baidu.tbadk.coreExtra.view.TbSettingTextTipView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h implements View.OnClickListener {
    final /* synthetic */ g bfu;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(g gVar) {
        this.bfu = gVar;
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
        jVar = this.bfu.bfe;
        if (jVar != null) {
            view2 = this.bfu.Jt;
            if (view != view2) {
                tbSettingTextTipView = this.bfu.bfl;
                if (view != tbSettingTextTipView) {
                    tbSettingTextTipView2 = this.bfu.bfm;
                    if (view != tbSettingTextTipView2) {
                        tbSettingTextTipView3 = this.bfu.bfn;
                        if (view != tbSettingTextTipView3) {
                            tbSettingTextTipView4 = this.bfu.bfo;
                            if (view != tbSettingTextTipView4) {
                                return;
                            }
                            jVar2 = this.bfu.bfe;
                            jVar2.QO();
                            return;
                        }
                        jVar3 = this.bfu.bfe;
                        jVar3.QP();
                        return;
                    }
                    jVar4 = this.bfu.bfe;
                    jVar4.QQ();
                    return;
                }
                jVar5 = this.bfu.bfe;
                jVar5.QN();
                return;
            }
            jVar6 = this.bfu.bfe;
            jVar6.onBackPressed();
        }
    }
}
