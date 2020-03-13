package com.baidu.tieba.ala.livecard.a;

import com.baidu.adp.widget.ListView.v;
import com.baidu.tieba.R;
/* loaded from: classes3.dex */
public class e extends v.a {
    public com.baidu.tieba.ala.livecard.b.e eNE;

    public e(com.baidu.tieba.ala.livecard.b.e eVar) {
        super(eVar.getView());
        this.eNE = eVar;
        if (this.eNE.eNB != null && this.eNE.eNB.getController() != null) {
            eVar.getView().setTag(R.id.video_controller_tag, this.eNE.eNB.getController());
        }
    }
}
