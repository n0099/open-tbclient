package com.baidu.tieba.frs.gamerecommend.data;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.tbadk.core.util.w;
import java.util.List;
/* loaded from: classes3.dex */
public class FeatureCardCompetition extends OrmObject {
    public Integer floor;
    public List<FeatureCardCompetitionSubNode> sub_nodes;
    public String title;
    public Integer type;

    public boolean isValid() {
        return !w.z(this.sub_nodes);
    }
}
