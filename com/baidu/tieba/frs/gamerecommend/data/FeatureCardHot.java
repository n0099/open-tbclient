package com.baidu.tieba.frs.gamerecommend.data;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.tbadk.core.util.x;
import java.util.List;
/* loaded from: classes16.dex */
public class FeatureCardHot extends OrmObject {
    public Integer floor;
    public List<FeatureCardHotSubNode> sub_nodes;
    public String title;
    public String type;

    public boolean isValid() {
        return !x.isEmpty(this.sub_nodes);
    }
}
