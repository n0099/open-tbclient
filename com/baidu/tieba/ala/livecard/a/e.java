package com.baidu.tieba.ala.livecard.a;

import com.baidu.adp.widget.ListView.y;
import com.baidu.tieba.R;
/* loaded from: classes3.dex */
public class e extends y.a {
    public com.baidu.tieba.ala.livecard.b.e fsB;

    public e(com.baidu.tieba.ala.livecard.b.e eVar) {
        super(eVar.getView());
        this.fsB = eVar;
        if (this.fsB.fsy != null && this.fsB.fsy.getController() != null) {
            eVar.getView().setTag(R.id.video_controller_tag, this.fsB.fsy.getController());
        }
    }
}
