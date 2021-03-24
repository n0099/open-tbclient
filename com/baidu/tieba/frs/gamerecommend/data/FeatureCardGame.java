package com.baidu.tieba.frs.gamerecommend.data;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.tbadk.core.util.ListUtils;
import java.util.List;
/* loaded from: classes4.dex */
public class FeatureCardGame extends OrmObject {
    public Integer floor;
    public List<FeatureCardGameSubNode> sub_nodes;
    public String title;
    public Integer type;

    public boolean isValid() {
        return !ListUtils.isEmpty(this.sub_nodes);
    }
}
