package com.baidu.tieba.ala.livecard.a;

import com.baidu.adp.widget.ListView.v;
import com.baidu.tieba.R;
/* loaded from: classes3.dex */
public class e extends v.a {
    public com.baidu.tieba.ala.livecard.b.e eOc;

    public e(com.baidu.tieba.ala.livecard.b.e eVar) {
        super(eVar.getView());
        this.eOc = eVar;
        if (this.eOc.eNZ != null && this.eOc.eNZ.getController() != null) {
            eVar.getView().setTag(R.id.video_controller_tag, this.eOc.eNZ.getController());
        }
    }
}
