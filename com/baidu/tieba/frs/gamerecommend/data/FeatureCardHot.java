package com.baidu.tieba.frs.gamerecommend.data;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.tbadk.core.util.w;
import java.util.List;
/* loaded from: classes9.dex */
public class FeatureCardHot extends OrmObject {
    public Integer floor;
    public List<FeatureCardHotSubNode> sub_nodes;
    public String title;
    public String type;

    public boolean isValid() {
        return !w.isEmpty(this.sub_nodes);
    }
}
