package com.baidu.tbadk.data;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.tbadk.core.util.y;
import java.util.List;
/* loaded from: classes2.dex */
public class FeatureCardGod extends OrmObject {
    public Integer floor;
    public List<com.baidu.tbadk.core.data.MetaData> sub_nodes;
    public String title;
    public Integer type;

    public boolean isValid() {
        return !y.isEmpty(this.sub_nodes);
    }
}
