package com.baidu.tieba.frs;

import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.data.GodUserData;
/* loaded from: classes7.dex */
public class ao implements com.baidu.tieba.horizonalList.widget.c {
    public MetaData metaData = new MetaData();

    public ao() {
        if (this.metaData.getGodUserData() == null) {
            this.metaData.setGodUserData(new GodUserData());
        }
    }
}
