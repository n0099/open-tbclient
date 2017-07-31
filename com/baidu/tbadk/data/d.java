package com.baidu.tbadk.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class d implements com.baidu.adp.widget.ListView.f {
    public static final BdUniqueId aAv = BdUniqueId.gen();

    public String getName() {
        return TbadkCoreApplication.getInst().getString(d.l.post_story);
    }

    @Override // com.baidu.adp.widget.ListView.f
    public BdUniqueId getType() {
        return aAv;
    }
}
