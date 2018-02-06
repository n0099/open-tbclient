package com.baidu.tieba.frs;

import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.data.GodUserData;
/* loaded from: classes3.dex */
public class ar implements com.baidu.tieba.horizonalList.widget.d {
    public MetaData metaData = new MetaData();

    public ar() {
        if (this.metaData.getGodUserData() == null) {
            this.metaData.setGodUserData(new GodUserData());
        }
    }
}
