package com.baidu.tieba.ala.livecard.a;

import com.baidu.adp.widget.ListView.v;
import com.baidu.tieba.R;
/* loaded from: classes6.dex */
public class e extends v.a {
    public com.baidu.tieba.ala.livecard.b.e dSF;

    public e(com.baidu.tieba.ala.livecard.b.e eVar) {
        super(eVar.getView());
        this.dSF = eVar;
        if (this.dSF.dSC != null && this.dSF.dSC.getController() != null) {
            eVar.getView().setTag(R.id.video_controller_tag, this.dSF.dSC.getController());
        }
    }
}
