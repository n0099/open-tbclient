package com.baidu.tieba.frs;

import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.data.GodUserData;
/* loaded from: classes21.dex */
public class bb implements com.baidu.tieba.horizonalList.widget.c {
    public MetaData metaData = new MetaData();

    public bb() {
        if (this.metaData.getGodUserData() == null) {
            this.metaData.setGodUserData(new GodUserData());
        }
    }
}
