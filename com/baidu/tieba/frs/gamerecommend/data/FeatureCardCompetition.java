package com.baidu.tieba.frs.gamerecommend.data;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.tbadk.core.util.y;
import java.util.List;
/* loaded from: classes21.dex */
public class FeatureCardCompetition extends OrmObject {
    public Integer floor;
    public List<FeatureCardCompetitionSubNode> sub_nodes;
    public String title;
    public Integer type;

    public boolean isValid() {
        return !y.isEmpty(this.sub_nodes);
    }
}
