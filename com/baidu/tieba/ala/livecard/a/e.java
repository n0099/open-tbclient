package com.baidu.tieba.ala.livecard.a;

import com.baidu.adp.widget.ListView.v;
import com.baidu.tieba.R;
/* loaded from: classes2.dex */
public class e extends v.a {
    public com.baidu.tieba.ala.livecard.b.e eIm;

    public e(com.baidu.tieba.ala.livecard.b.e eVar) {
        super(eVar.getView());
        this.eIm = eVar;
        if (this.eIm.eIj != null && this.eIm.eIj.getController() != null) {
            eVar.getView().setTag(R.id.video_controller_tag, this.eIm.eIj.getController());
        }
    }
}
