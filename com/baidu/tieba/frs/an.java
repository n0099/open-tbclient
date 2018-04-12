package com.baidu.tieba.frs;

import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.data.GodUserData;
/* loaded from: classes3.dex */
public class an implements com.baidu.tieba.horizonalList.widget.c {
    public MetaData metaData = new MetaData();

    public an() {
        if (this.metaData.getGodUserData() == null) {
            this.metaData.setGodUserData(new GodUserData());
        }
    }
}
