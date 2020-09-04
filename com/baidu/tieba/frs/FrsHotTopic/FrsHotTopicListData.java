package com.baidu.tieba.frs.FrsHotTopic;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import java.io.Serializable;
/* loaded from: classes.dex */
public class FrsHotTopicListData extends OrmObject implements Serializable {
    private static final long serialVersionUID = 6224432372313379044L;
    public FrsLinkHashMap<String, Long> mSceneMap = new FrsLinkHashMap<>();
}
