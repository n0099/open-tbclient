package com.baidu.tieba.ala.livecard.a;

import com.baidu.adp.widget.ListView.v;
import com.baidu.tieba.R;
/* loaded from: classes3.dex */
public class e extends v.a {
    public com.baidu.tieba.ala.livecard.b.e eNq;

    public e(com.baidu.tieba.ala.livecard.b.e eVar) {
        super(eVar.getView());
        this.eNq = eVar;
        if (this.eNq.eNn != null && this.eNq.eNn.getController() != null) {
            eVar.getView().setTag(R.id.video_controller_tag, this.eNq.eNn.getController());
        }
    }
}
