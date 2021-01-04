package com.baidu.tieba.frs.gamerecommend.data;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.tbadk.core.util.x;
import java.util.List;
/* loaded from: classes2.dex */
public class FeatureCardTopic extends OrmObject {
    public Integer floor;
    public List<FeatureCardTopicSubNode> sub_nodes;
    public String title;
    public Integer type;

    public boolean isValid() {
        return !x.isEmpty(this.sub_nodes);
    }
}
