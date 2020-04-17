package com.baidu.tieba.ala.livecard.a;

import com.baidu.adp.widget.ListView.y;
import com.baidu.tieba.R;
/* loaded from: classes3.dex */
public class e extends y.a {
    public com.baidu.tieba.ala.livecard.b.e fsw;

    public e(com.baidu.tieba.ala.livecard.b.e eVar) {
        super(eVar.getView());
        this.fsw = eVar;
        if (this.fsw.fst != null && this.fsw.fst.getController() != null) {
            eVar.getView().setTag(R.id.video_controller_tag, this.fsw.fst.getController());
        }
    }
}
